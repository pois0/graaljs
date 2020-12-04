/*
 * Copyright (c) 2018, 2020, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * The Universal Permissive License (UPL), Version 1.0
 *
 * Subject to the condition set forth below, permission is hereby granted to any
 * person obtaining a copy of this software, associated documentation and/or
 * data (collectively the "Software"), free of charge and under any and all
 * copyright rights in the Software, and any and all patent rights owned or
 * freely licensable by each licensor hereunder covering either (i) the
 * unmodified Software as contributed to or provided by such licensor, or (ii)
 * the Larger Works (as defined below), to deal in both
 *
 * (a) the Software, and
 *
 * (b) any piece of software and/or hardware listed in the lrgrwrks.txt file if
 * one is included with the Software each a "Larger Work" to which the Software
 * is contributed by such licensors),
 *
 * without restriction, including without limitation the rights to copy, create
 * derivative works of, display, perform, and distribute the Software and make,
 * use, sell, offer for sale, import, export, have made, and have sold the
 * Software and the Larger Work(s), and to sublicense the foregoing rights on
 * either these or other terms.
 *
 * This license is subject to the following condition:
 *
 * The above copyright notice and either this complete permission notice or at a
 * minimum a reference to the UPL must be included in all copies or substantial
 * portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.oracle.truffle.js.runtime;

import java.util.ArrayList;
import java.util.List;

import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.CompilerAsserts;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.TruffleException;
import com.oracle.truffle.api.TruffleStackTrace;
import com.oracle.truffle.api.TruffleStackTraceElement;
import com.oracle.truffle.api.frame.Frame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.RootNode;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.source.Source;
import com.oracle.truffle.api.source.SourceSection;
import com.oracle.truffle.js.lang.JavaScriptLanguage;
import com.oracle.truffle.js.nodes.promise.PerformPromiseAllNode.PromiseAllMarkerRootNode;
import com.oracle.truffle.js.nodes.promise.PromiseReactionJobNode.PromiseReactionJobRootNode;
import com.oracle.truffle.js.runtime.builtins.JSError;
import com.oracle.truffle.js.runtime.builtins.JSFunction;
import com.oracle.truffle.js.runtime.builtins.JSFunctionData;
import com.oracle.truffle.js.runtime.builtins.JSProxy;
import com.oracle.truffle.js.runtime.objects.JSDynamicObject;
import com.oracle.truffle.js.runtime.objects.JSObject;
import com.oracle.truffle.js.runtime.objects.Null;
import com.oracle.truffle.js.runtime.objects.PropertyDescriptor;
import com.oracle.truffle.js.runtime.objects.Undefined;

public abstract class GraalJSException extends RuntimeException implements TruffleException {
    private static final long serialVersionUID = -6624166672101791072L;
    private static final JSStackTraceElement[] EMPTY_STACK_TRACE = new JSStackTraceElement[0];
    private JSStackTraceElement[] jsStackTrace;
    private Object location;
    private int stackTraceLimit;

    private static final String DYNAMIC_FUNCTION_NAME = "anonymous";

    protected GraalJSException(String message, Throwable cause, Node node, int stackTraceLimit) {
        super(message, cause);
        this.location = node;
        this.stackTraceLimit = stackTraceLimit;
        this.jsStackTrace = stackTraceLimit == 0 ? EMPTY_STACK_TRACE : null;
    }

    protected GraalJSException(String message, Node node, int stackTraceLimit) {
        super(message);
        this.location = node;
        this.stackTraceLimit = stackTraceLimit;
        this.jsStackTrace = stackTraceLimit == 0 ? EMPTY_STACK_TRACE : null;
    }

    protected GraalJSException(String message, SourceSection location, int stackTraceLimit) {
        super(message);
        this.location = location;
        this.stackTraceLimit = stackTraceLimit;
        this.jsStackTrace = stackTraceLimit == 0 ? EMPTY_STACK_TRACE : null;
    }

    protected static <T extends GraalJSException> T fillInStackTrace(T exception, DynamicObject skipFramesUpTo, boolean capture) {
        exception.fillInStackTrace(skipFramesUpTo, capture);
        return exception;
    }

    protected final GraalJSException fillInStackTrace(DynamicObject skipFramesUpTo, boolean capture) {
        // We can only skip frames when capturing eagerly.
        assert capture || skipFramesUpTo == Undefined.instance;
        assert jsStackTrace == (stackTraceLimit == 0 ? EMPTY_STACK_TRACE : null);
        if (capture || JSConfig.EagerStackTrace) {
            if (stackTraceLimit > 0) {
                this.jsStackTrace = getJSStackTrace(skipFramesUpTo);
            }
        }
        return this;
    }

    @Override
    public Node getLocation() {
        return location instanceof Node ? (Node) location : null;
    }

    @Override
    public SourceSection getSourceLocation() {
        if (location instanceof SourceSection) {
            return (SourceSection) location;
        }
        return TruffleException.super.getSourceLocation();
    }

    @Override
    public Object getExceptionObject() {
        Object error = getErrorObject();
        return (error == null) ? null : JSRuntime.exportValue(error);
    }

    @Override
    public int getStackTraceElementLimit() {
        if (stackTraceLimit <= 0) {
            return 0;
        }
        // since we might skip stack frames, we do not know in advance how many we have to visit.
        return -1;
    }

    /** Could still be null due to lazy initialization. */
    public abstract Object getErrorObject();

    /**
     * Eager access to the ErrorObject. Use only if you must get a non-null error object. Could
     * result in an error object from the wrong realm, thus non spec-compliant.
     */
    public abstract Object getErrorObjectEager(JSContext context);

    /**
     * Omit creating stack trace for JavaScript exceptions.
     */
    @SuppressWarnings("sync-override")
    @Override
    @TruffleBoundary
    public final Throwable fillInStackTrace() {
        if (JSConfig.FillExceptionStack) {
            return super.fillInStackTrace();
        } else {
            return null;
        }
    }

    public JSStackTraceElement[] getJSStackTrace() {
        if (jsStackTrace != null) {
            return jsStackTrace;
        }
        jsStackTrace = materializeJSStackTrace();
        return jsStackTrace;
    }

    @TruffleBoundary
    private JSStackTraceElement[] materializeJSStackTrace() {
        return getJSStackTrace(Undefined.instance);
    }

    @TruffleBoundary
    private JSStackTraceElement[] getJSStackTrace(DynamicObject skipUpTo) {
        assert stackTraceLimit > 0;
        JSContext context = JavaScriptLanguage.getCurrentJSRealm().getContext();
        boolean nashornMode = context.isOptionNashornCompatibilityMode();
        // Nashorn does not support skipping of frames
        DynamicObject skipFramesUpTo = nashornMode ? Undefined.instance : skipUpTo;
        List<TruffleStackTraceElement> stackTrace = TruffleStackTrace.getStackTrace(this);
        if (stackTrace == null) {
            return EMPTY_STACK_TRACE;
        }
        FrameVisitorImpl visitor = new FrameVisitorImpl(getLocation(), stackTraceLimit, skipFramesUpTo, nashornMode);
        boolean asyncStackTraces = context.isOptionAsyncStackTraces();
        List<List<TruffleStackTraceElement>> asyncStacks = null;
        for (TruffleStackTraceElement element : stackTrace) {
            if (!visitor.visitFrame(element)) {
                asyncStacks = null;
                break;
            }
            if (asyncStackTraces) {
                List<TruffleStackTraceElement> asyncStack = getAsynchronousStackTrace(element);
                if (asyncStack != null && !asyncStack.isEmpty()) {
                    if (asyncStacks == null) {
                        asyncStacks = new ArrayList<>();
                    }
                    asyncStacks.add(asyncStack);
                }
            }
        }
        if (asyncStacks != null && !asyncStacks.isEmpty()) {
            out: for (List<TruffleStackTraceElement> asyncStack : asyncStacks) {
                visitor.async = true;
                for (TruffleStackTraceElement element : asyncStack) {
                    if (!visitor.visitFrame(element)) {
                        break out;
                    }
                }
            }
        }
        return visitor.getStackTrace().toArray(EMPTY_STACK_TRACE);
    }

    private static List<TruffleStackTraceElement> getAsynchronousStackTrace(TruffleStackTraceElement element) {
        if (element.getFrame() == null) {
            // getAsynchronousStackTrace requires a frame.
            return null;
        }
        RootNode rootNode = element.getTarget().getRootNode();
        if (rootNode.getLanguageInfo() == null) {
            // getAsynchronousStackTrace requires the RootNode to have language info.
            return null;
        }
        if (rootNode instanceof JavaScriptRootNode) {
            if (rootNode instanceof PromiseReactionJobRootNode) {
                return JavaScriptRootNode.findAsynchronousFrames((JavaScriptRootNode) rootNode, element.getFrame());
            } else {
                // We do not want to include any of the extra stack trace elements available when
                // getAsynchronousStackDepth() > 0.
                return null;
            }
        }
        return TruffleStackTrace.getAsynchronousStackTrace(element.getTarget(), element.getFrame());
    }

    public void setJSStackTrace(JSStackTraceElement[] jsStackTrace) {
        this.jsStackTrace = jsStackTrace;
    }

    @TruffleBoundary
    public static JSStackTraceElement[] getJSStackTrace(Node originatingNode) {
        int stackTraceLimit = JavaScriptLanguage.getCurrentJSRealm().getContext().getContextOptions().getStackTraceLimit();
        return UserScriptException.createCapture("", originatingNode, stackTraceLimit, Undefined.instance).getJSStackTrace();
    }

    private static final class FrameVisitorImpl {
        private static final int STACK_FRAME_SKIP = 0;
        private static final int STACK_FRAME_JS = 1;
        private static final int STACK_FRAME_FOREIGN = 2;

        private final List<JSStackTraceElement> stackTrace = new ArrayList<>();
        private final Node originatingNode;
        private final int stackTraceLimit;
        private final DynamicObject skipFramesUpTo;
        private final boolean inNashornMode;

        private boolean inStrictMode;
        private boolean skippingFrames;
        private boolean first = true;
        boolean async;

        FrameVisitorImpl(Node originatingNode, int stackTraceLimit, DynamicObject skipFramesUpTo, boolean nashornMode) {
            this.originatingNode = originatingNode;
            this.stackTraceLimit = stackTraceLimit;
            this.skipFramesUpTo = skipFramesUpTo;
            this.skippingFrames = (skipFramesUpTo != Undefined.instance);
            this.inNashornMode = nashornMode;
        }

        private int stackFrameType(Node callNode) {
            if (callNode == null) {
                return STACK_FRAME_SKIP;
            }
            SourceSection sourceSection = callNode.getEncapsulatingSourceSection();
            if (sourceSection == null) {
                return STACK_FRAME_SKIP;
            }
            if (JSFunction.isBuiltinSourceSection(sourceSection)) {
                return inNashornMode ? STACK_FRAME_SKIP : STACK_FRAME_JS;
            }
            if (sourceSection.getSource().isInternal() || !sourceSection.isAvailable()) {
                return STACK_FRAME_SKIP;
            }
            if (JSRuntime.isJSRootNode(callNode.getRootNode())) {
                return STACK_FRAME_JS;
            } else {
                return STACK_FRAME_FOREIGN;
            }
        }

        private static RootNode rootNode(TruffleStackTraceElement element) {
            CallTarget callTarget = element.getTarget();
            return (callTarget instanceof RootCallTarget) ? ((RootCallTarget) callTarget).getRootNode() : null;
        }

        public boolean visitFrame(TruffleStackTraceElement element) {
            Node callNode = element.getLocation();
            if (first) {
                first = false;
                if (JSRuntime.isJSRootNode(rootNode(element))) {
                    callNode = originatingNode;
                }
            }
            if (callNode == null) {
                callNode = rootNode(element);
            }

            // this check for code style analyzers
            if (callNode != null) {
                switch (stackFrameType(callNode)) {
                    case STACK_FRAME_JS: {
                        RootNode rootNode = callNode.getRootNode();
                        assert JSRuntime.isJSRootNode(rootNode);
                        final Object[] arguments;
                        int promiseIndex = -1;
                        if (element.getFrame() == null) {
                            break;
                        } else if (JSRuntime.isJSFunctionRootNode(rootNode)) {
                            arguments = element.getFrame().getArguments();
                        } else if (((JavaScriptRootNode) rootNode).isResumption()) {
                            // first argument is the context frame
                            if (element.getFrame().getArguments()[0] instanceof Frame) {
                                Frame frame = (Frame) element.getFrame().getArguments()[0];
                                arguments = frame.getArguments();
                            } else {
                                arguments = element.getFrame().getArguments();
                            }
                        } else if (rootNode instanceof PromiseAllMarkerRootNode) {
                            arguments = element.getFrame().getArguments();
                            if (JSArguments.getUserArgumentCount(arguments) > 0) {
                                Object promiseIndexArg = JSArguments.getUserArgument(arguments, 0);
                                if (promiseIndexArg instanceof Integer) {
                                    promiseIndex = (int) promiseIndexArg;
                                }
                            }
                        } else {
                            break;
                        }
                        Object thisObj = JSArguments.getThisObject(arguments);
                        Object functionObj = JSArguments.getFunctionObject(arguments);
                        if (JSFunction.isJSFunction(functionObj)) {
                            DynamicObject function = (DynamicObject) functionObj;
                            JSFunctionData functionData = JSFunction.getFunctionData(function);
                            if (functionData.isBuiltin()) {
                                if (JSFunction.isStrictBuiltin(function)) {
                                    inStrictMode = true;
                                }
                            } else if (functionData.isStrict()) {
                                inStrictMode = true;
                            }
                            if (skippingFrames && function == skipFramesUpTo) {
                                skippingFrames = false;
                                return true; // skip this frame as well
                            }
                            JSRealm realm = JSFunction.getRealm(function);
                            if (JSFunction.isBuiltinThatShouldNotAppearInStackTrace(realm, function)) {
                                return true;
                            }
                            if (!skippingFrames) {
                                if (functionData.isAsync() && !functionData.isGenerator() && JSRuntime.isJSFunctionRootNode(rootNode)) {
                                    // async function calls produce two frames, skip one
                                    return true;
                                }
                                stackTrace.add(processJSFrame(rootNode, callNode, thisObj, function, inStrictMode, inNashornMode, async, promiseIndex));
                            }
                        }
                        break;
                    }
                    case STACK_FRAME_FOREIGN:
                        if (!skippingFrames) {
                            JSStackTraceElement elem = processForeignFrame(callNode, inStrictMode, inNashornMode, async);
                            if (elem != null) {
                                stackTrace.add(elem);
                            }
                        }
                        break;
                }
            }
            return stackTrace.size() < stackTraceLimit;
        }

        public List<JSStackTraceElement> getStackTrace() {
            return stackTrace;
        }

    }

    private static JSStackTraceElement processJSFrame(RootNode rootNode, Node node, Object thisObj, DynamicObject functionObj, boolean inStrictMode, boolean inNashornMode, boolean async,
                    int promiseIndex) {
        Node callNode = node;
        while (callNode.getSourceSection() == null) {
            callNode = callNode.getParent();
        }
        SourceSection callNodeSourceSection = callNode.getSourceSection();
        Source source = callNodeSourceSection.getSource();

        String fileName = getFileName(source);
        String functionName;
        if (JSFunction.isBuiltin(functionObj)) {
            functionName = JSFunction.getName(functionObj);
        } else {
            functionName = rootNode.getName();
        }
        boolean eval = false;
        if (isEvalSource(source)) {
            functionName = "eval";
            eval = true;
        } else if (functionName == null || isInternalFunctionName(functionName)) {
            functionName = "";
        }
        SourceSection targetSourceSection = null;
        if (!inNashornMode) { // for V8
            if (callNode instanceof JavaScriptFunctionCallNode) {
                Node target = ((JavaScriptFunctionCallNode) callNode).getTarget();
                targetSourceSection = target == null ? null : target.getSourceSection();
            }
        }
        boolean global = (JSRuntime.isNullOrUndefined(thisObj) && !JSFunction.isStrict(functionObj)) || isGlobalObject(thisObj, JSFunction.getRealm(functionObj));

        return new JSStackTraceElement(fileName, functionName, callNodeSourceSection, thisObj, functionObj, targetSourceSection, inStrictMode, eval, global, inNashornMode, async, promiseIndex);
    }

    private static boolean isEvalSource(Source source) {
        return source != null && source.getName().startsWith(Evaluator.EVAL_AT_SOURCE_NAME_PREFIX);
    }

    private static boolean isInternalFunctionName(String functionName) {
        return functionName.length() >= 1 && functionName.charAt(0) == ':';
    }

    private static boolean isGlobalObject(Object object, JSRealm realm) {
        return JSDynamicObject.isJSDynamicObject(object) && (realm != null) && (realm.getGlobalObject() == object);
    }

    private static JSStackTraceElement processForeignFrame(Node node, boolean strict, boolean inNashornMode, boolean async) {
        RootNode rootNode = node.getRootNode();
        SourceSection sourceSection = rootNode.getSourceSection();
        if (sourceSection == null) {
            // can happen around FastR root nodes, see GR-6604
            return null;
        }
        String fileName = getFileName(sourceSection.getSource());
        String functionName = rootNode.getName();
        Object thisObj = null;
        Object functionObj = null;

        return new JSStackTraceElement(fileName, functionName, sourceSection, thisObj, functionObj, null, strict, false, false, inNashornMode, async, -1);
    }

    private static String getPrimitiveConstructorName(Object thisObj) {
        assert JSRuntime.isJSPrimitive(thisObj);
        if (thisObj instanceof Boolean) {
            return "Boolean";
        } else if (JSRuntime.isNumber(thisObj)) {
            return "Number";
        } else if (JSRuntime.isString(thisObj)) {
            return "String";
        } else if (thisObj instanceof Symbol) {
            return "Symbol";
        }
        return null;
    }

    private static int sourceSectionOffset(SourceSection callNodeSourceSection, SourceSection targetSourceSection) {
        int offset = 0;
        String code = callNodeSourceSection.getCharacters().toString();

        // skip code for the target
        if (targetSourceSection != null) {
            String targetCode = targetSourceSection.getCharacters().toString();
            int index = code.indexOf(targetCode);
            if (index != -1) {
                index += targetCode.length();
                offset += index;
                code = code.substring(index);
            }
        }

        // column number corresponds to the function invocation (left
        // parenthesis) unless it is preceded by an identifier (column
        // number is the beginning of the identified then)
        int index = code.indexOf('(');
        if (index != -1) {
            index--;
            int i = index;
            while (i >= 0 && Character.isWhitespace(code.charAt(i))) {
                i--;
            }
            if (i >= 0 && Character.isJavaIdentifierPart(code.charAt(i))) {
                do {
                    i--;
                } while (i >= 0 && Character.isJavaIdentifierPart(code.charAt(i)));
                index = i;
            }
            offset += index + 1;
        }
        return offset;
    }

    private static String getFileName(Source source) {
        return source != null ? source.getName() : "<unknown>";
    }

    public void printJSStackTrace() {
        System.err.println(getMessage());
        for (JSStackTraceElement jsste : jsStackTrace) {
            System.err.println(jsste);
        }
    }

    @TruffleBoundary
    public static void printJSStackTrace(Node originatingNode) {
        JSStackTraceElement[] jsstes = getJSStackTrace(originatingNode);
        for (JSStackTraceElement jsste : jsstes) {
            System.err.println(jsste);
        }
    }

    public static final class JSStackTraceElement {
        private final String fileName;
        private final String functionName;
        private final SourceSection sourceSection;
        private final Object thisObj;
        private final Object functionObj;
        private final SourceSection targetSourceSection;
        private final boolean strict;
        private final boolean eval;
        private final boolean global;
        private final boolean inNashornMode;
        private final boolean async;
        private final int promiseIndex;

        private JSStackTraceElement(String fileName, String functionName, SourceSection sourceSection, Object thisObj, Object functionObj, SourceSection targetSourceSection, boolean strict,
                        boolean eval, boolean global, boolean inNashornMode, boolean async, int promiseIndex) {
            CompilerAsserts.neverPartOfCompilation();
            this.fileName = fileName;
            this.functionName = functionName;
            this.sourceSection = sourceSection;
            this.thisObj = thisObj;
            this.functionObj = functionObj;
            this.targetSourceSection = targetSourceSection;
            this.strict = strict;
            this.eval = eval;
            this.global = global;
            this.inNashornMode = inNashornMode;
            this.async = async;
            this.promiseIndex = promiseIndex;
        }

        // This method is called from nashorn tests via java interop
        @TruffleBoundary
        public String getFileName() {
            if (fileName.startsWith(Evaluator.EVAL_AT_SOURCE_NAME_PREFIX)) {
                return Evaluator.EVAL_SOURCE_NAME;
            }
            return fileName;
        }

        // This method is called from nashorn tests via java interop
        public String getClassName() {
            return getTypeName(false);
        }

        public String getTypeName() {
            return getTypeName(true);
        }

        @TruffleBoundary
        public SourceSection getSourceSection() {
            return sourceSection;
        }

        @TruffleBoundary
        public String getTypeName(boolean checkGlobal) {
            if (inNashornMode) {
                return "<" + fileName + ">";
            } else {
                if (checkGlobal && global) {
                    return "global";
                }
                Object thisObject = getThis();
                if (thisObject == JSFunction.CONSTRUCT) {
                    return getFunctionName();
                } else if (!JSRuntime.isNullOrUndefined(thisObject) && !global) {
                    if (JSDynamicObject.isJSDynamicObject(thisObject)) {
                        return JSRuntime.getConstructorName((DynamicObject) thisObject);
                    } else if (JSRuntime.isJSPrimitive(thisObject)) {
                        return getPrimitiveConstructorName(thisObject);
                    }
                }
                return null;
            }
        }

        @TruffleBoundary
        public String getFunctionName() {
            if (JSFunction.isJSFunction(functionObj)) {
                String dynamicName = findFunctionName((DynamicObject) functionObj);
                // The default name of dynamic functions is "anonymous" as per the spec.
                // Yet, in V8 stack traces it is "eval" unless overwritten.
                if (dynamicName != null && !dynamicName.isEmpty() &&
                                (!isEval() || !dynamicName.equals(DYNAMIC_FUNCTION_NAME) || !JSObject.getJSContext((DynamicObject) functionObj).isOptionV8CompatibilityMode())) {
                    return dynamicName;
                }
            }
            return functionName;
        }

        private static String findFunctionName(DynamicObject functionObj) {
            assert JSFunction.isJSFunction(functionObj);
            PropertyDescriptor desc = JSObject.getOwnProperty(functionObj, JSFunction.NAME);
            if (desc != null) {
                if (desc.isDataDescriptor()) {
                    Object name = desc.getValue();
                    if (JSRuntime.isString(name)) {
                        return JSRuntime.javaToString(name);
                    }
                }
            }
            return null;
        }

        // This method is called from nashorn tests via java interop
        @TruffleBoundary
        public String getMethodName() {
            return getMethodName(JavaScriptLanguage.getCurrentJSRealm().getContext());
        }

        @TruffleBoundary
        public String getMethodName(JSContext context) {
            if (context.isOptionNashornCompatibilityMode()) {
                return JSError.correctMethodName(functionName, context);
            }
            if (JSRuntime.isNullOrUndefined(thisObj) || !JSDynamicObject.isJSDynamicObject(thisObj)) {
                return null;
            }
            if (!JSFunction.isJSFunction(functionObj)) {
                return null;
            }

            DynamicObject receiver = (DynamicObject) thisObj;
            DynamicObject function = (DynamicObject) functionObj;
            if (functionName != null && !functionName.isEmpty()) {
                String name = findMethodPropertyNameByFunctionName(receiver, functionName, function);
                if (name != null) {
                    return name;
                }
            }
            return findMethodPropertyName(receiver, function);
        }

        private static String findMethodPropertyNameByFunctionName(DynamicObject receiver, String functionName, DynamicObject functionObj) {
            String propertyName = functionName;
            boolean accessor = false;
            if (propertyName.startsWith("get ") || propertyName.startsWith("set ")) {
                propertyName = propertyName.substring(4);
                accessor = true;
            }
            if (propertyName.isEmpty()) {
                return null;
            }
            for (DynamicObject current = receiver; current != Null.instance && !JSProxy.isJSProxy(current); current = JSObject.getPrototype(current)) {
                PropertyDescriptor desc = JSObject.getOwnProperty(current, propertyName);
                if (desc != null) {
                    if (desc.isAccessorDescriptor() == accessor && (desc.getValue() == functionObj || desc.getGet() == functionObj || desc.getSet() == functionObj)) {
                        return propertyName;
                    }
                    break;
                }
            }
            return null;
        }

        private static String findMethodPropertyName(DynamicObject receiver, DynamicObject functionObj) {
            String name = null;
            for (DynamicObject current = receiver; current != Null.instance && !JSProxy.isJSProxy(current); current = JSObject.getPrototype(current)) {
                for (String key : JSObject.enumerableOwnNames(current)) {
                    PropertyDescriptor desc = JSObject.getOwnProperty(current, key);
                    if (desc.getValue() == functionObj || desc.getGet() == functionObj || desc.getSet() == functionObj) {
                        if (name == null) {
                            name = key;
                        } else {
                            return null; // method name is ambiguous
                        }
                    }
                }
            }
            return name;
        }

        // This method is called from nashorn tests via java interop
        @TruffleBoundary
        public int getLineNumber() {
            if (sourceSection == null) {
                return -1;
            }
            int lineNumber = sourceSection.getStartLine();
            if (!inNashornMode && targetSourceSection != null) {
                // for V8
                int offset = sourceSectionOffset(sourceSection, targetSourceSection);
                CharSequence chars = sourceSection.getCharacters();
                for (int pos = 0; pos < offset; pos++) {
                    if (chars.charAt(pos) == '\n') {
                        lineNumber++;
                    }
                }
            }
            return lineNumber;
        }

        @TruffleBoundary
        public String getLine() {
            int lineNumber = getLineNumber();
            if (sourceSection == null || sourceSection.getSource() == null || lineNumber <= 0) {
                return "<unknown>";
            }
            return sourceSection.getSource().getCharacters(lineNumber).toString();
        }

        @TruffleBoundary
        public int getColumnNumber() {
            if (sourceSection == null) {
                return -1;
            }
            int columnNumber = sourceSection.getStartColumn();
            if (!inNashornMode && targetSourceSection != null) {
                // for V8
                int offset = sourceSectionOffset(sourceSection, targetSourceSection);
                CharSequence chars = sourceSection.getCharacters();
                for (int pos = 0; pos < offset; pos++) {
                    if (chars.charAt(pos) == '\n') {
                        columnNumber = 1;
                    } else {
                        columnNumber++;
                    }
                }
            }
            return columnNumber;
        }

        public int getPosition() {
            return sourceSection != null ? sourceSection.getCharIndex() : -1;
        }

        public Object getThis() {
            return thisObj;
        }

        @TruffleBoundary
        public Object getThisOrGlobal() {
            if (global) {
                if (JSRuntime.isNullOrUndefined(thisObj)) {
                    return JSFunction.getRealm((DynamicObject) functionObj).getGlobalObject();
                } else {
                    assert thisObj == JSFunction.getRealm((DynamicObject) functionObj).getGlobalObject();
                    return thisObj;
                }
            }
            return (thisObj == JSFunction.CONSTRUCT) ? Undefined.instance : thisObj;
        }

        public Object getFunction() {
            return functionObj;
        }

        public boolean isStrict() {
            return strict;
        }

        @TruffleBoundary
        public boolean isConstructor() {
            if (thisObj == JSFunction.CONSTRUCT) {
                return true;
            } else if (!JSRuntime.isNullOrUndefined(thisObj) && JSDynamicObject.isJSDynamicObject(thisObj)) {
                Object constructor = JSRuntime.getDataProperty((DynamicObject) thisObj, JSObject.CONSTRUCTOR);
                return constructor != null && constructor == functionObj;
            }
            return false;
        }

        public boolean isEval() {
            return eval;
        }

        @TruffleBoundary
        public String getEvalOrigin() {
            if (fileName.startsWith("<")) {
                return null;
            }
            return fileName;
        }

        public int getPromiseIndex() {
            return promiseIndex;
        }

        public boolean isPromiseAll() {
            return promiseIndex >= 0;
        }

        public boolean isAsync() {
            return async;
        }

        @TruffleBoundary
        @Override
        public String toString() {
            JSContext context = JavaScriptLanguage.getCurrentJSRealm().getContext();
            return toString(context);
        }

        @TruffleBoundary
        public String toString(JSContext context) {
            StringBuilder builder = new StringBuilder();
            if (isPromiseAll()) {
                builder.append("async").append(' ').append("Promise.all").append(" (").append("index").append(' ').append(promiseIndex).append(")");
                return builder.toString();
            }

            String className = getClassName();
            String methodName = JSError.correctMethodName(getFunctionName(), context);
            if (methodName == null || methodName.isEmpty()) {
                String name = getMethodName(context);
                if (name == null) {
                    methodName = JSError.getAnonymousFunctionNameStackTrace(context);
                } else {
                    methodName = name;
                }
            }
            boolean includeMethodName = className != null || !JSError.getAnonymousFunctionNameStackTrace(context).equals(methodName);
            if (includeMethodName) {
                if (async) {
                    builder.append("async").append(' ');
                }
                if (className != null) {
                    if (className.equals(methodName)) {
                        if (isConstructor()) {
                            builder.append("new ");
                        }
                    } else {
                        builder.append(className).append('.');
                    }
                }
                builder.append(methodName);
                builder.append(" (");
            }
            if (JSFunction.isBuiltinSourceSection(sourceSection)) {
                builder.append("native");
            } else {
                String evalOrigin = getEvalOrigin();
                String sourceName = evalOrigin != null ? evalOrigin : getFileName();
                builder.append(sourceName);
                if (eval) {
                    builder.append(", <anonymous>");
                }
                builder.append(":");
                builder.append(getLineNumber());
                builder.append(":");
                builder.append(getColumnNumber());
            }
            if (includeMethodName) {
                builder.append(")");
            }
            return builder.toString();
        }
    }
}
