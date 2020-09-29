// CheckStyle: start generated
package com.oracle.truffle.js.builtins;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.builtins.DebugBuiltins.DebugArrayTypeNode;
import com.oracle.truffle.js.builtins.DebugBuiltins.DebugAssertIntNode;
import com.oracle.truffle.js.builtins.DebugBuiltins.DebugClassNameNode;
import com.oracle.truffle.js.builtins.DebugBuiltins.DebugClassNode;
import com.oracle.truffle.js.builtins.DebugBuiltins.DebugCompileFunctionNode;
import com.oracle.truffle.js.builtins.DebugBuiltins.DebugContinueInInterpreter;
import com.oracle.truffle.js.builtins.DebugBuiltins.DebugCreateLazyString;
import com.oracle.truffle.js.builtins.DebugBuiltins.DebugCreateSafeInteger;
import com.oracle.truffle.js.builtins.DebugBuiltins.DebugDumpCountersNode;
import com.oracle.truffle.js.builtins.DebugBuiltins.DebugDumpFunctionTreeNode;
import com.oracle.truffle.js.builtins.DebugBuiltins.DebugHeapDumpNode;
import com.oracle.truffle.js.builtins.DebugBuiltins.DebugIsHolesArrayNode;
import com.oracle.truffle.js.builtins.DebugBuiltins.DebugJSStackNode;
import com.oracle.truffle.js.builtins.DebugBuiltins.DebugLoadModuleNode;
import com.oracle.truffle.js.builtins.DebugBuiltins.DebugNeverPartOfCompilationNode;
import com.oracle.truffle.js.builtins.DebugBuiltins.DebugPrintObjectNode;
import com.oracle.truffle.js.builtins.DebugBuiltins.DebugPrintSourceAttribution;
import com.oracle.truffle.js.builtins.DebugBuiltins.DebugShapeNode;
import com.oracle.truffle.js.builtins.DebugBuiltins.DebugStringCompareNode;
import com.oracle.truffle.js.builtins.DebugBuiltins.DebugSystemProperties;
import com.oracle.truffle.js.builtins.DebugBuiltins.DebugSystemProperty;
import com.oracle.truffle.js.builtins.DebugBuiltins.DebugToJavaStringNode;
import com.oracle.truffle.js.builtins.DebugBuiltins.DebugTypedArrayDetachBufferNode;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.SafeInteger;

@GeneratedBy(DebugBuiltins.class)
@SuppressWarnings("unused")
public final class DebugBuiltinsFactory {

    @GeneratedBy(DebugContinueInInterpreter.class)
    public static final class DebugContinueInInterpreterNodeGen extends DebugContinueInInterpreter implements Provider {

        private DebugContinueInInterpreterNodeGen(JSContext context, JSBuiltin builtin, boolean invalidate, JavaScriptNode[] arguments) {
            super(context, builtin, invalidate);
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            return continueInInterpreter();
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.MONOMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            s = new Object[3];
            s[0] = "continueInInterpreter";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static DebugContinueInInterpreter create(JSContext context, JSBuiltin builtin, boolean invalidate, JavaScriptNode[] arguments) {
            return new DebugContinueInInterpreterNodeGen(context, builtin, invalidate, arguments);
        }

    }
    @GeneratedBy(DebugClassNode.class)
    public static final class DebugClassNodeGen extends DebugClassNode implements Provider {

        @Child private JavaScriptNode arguments0_;

        private DebugClassNodeGen(JSContext context, JSBuiltin builtin, boolean getName, JavaScriptNode[] arguments) {
            super(context, builtin, getName);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return clazz(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.MONOMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            s = new Object[3];
            s[0] = "clazz";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static DebugClassNode create(JSContext context, JSBuiltin builtin, boolean getName, JavaScriptNode[] arguments) {
            return new DebugClassNodeGen(context, builtin, getName, arguments);
        }

    }
    @GeneratedBy(DebugClassNameNode.class)
    public static final class DebugClassNameNodeGen extends DebugClassNameNode implements Provider {

        @Child private JavaScriptNode arguments0_;

        private DebugClassNameNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return DebugClassNameNode.clazz(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.MONOMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            s = new Object[3];
            s[0] = "clazz";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static DebugClassNameNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new DebugClassNameNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(DebugShapeNode.class)
    public static final class DebugShapeNodeGen extends DebugShapeNode implements Provider {

        @Child private JavaScriptNode arguments0_;

        private DebugShapeNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return DebugShapeNode.shape(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.MONOMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            s = new Object[3];
            s[0] = "shape";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static DebugShapeNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new DebugShapeNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(DebugDumpCountersNode.class)
    public static final class DebugDumpCountersNodeGen extends DebugDumpCountersNode implements Provider {

        private DebugDumpCountersNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            return DebugDumpCountersNode.dumpCounters();
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.MONOMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            s = new Object[3];
            s[0] = "dumpCounters";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static DebugDumpCountersNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new DebugDumpCountersNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(DebugDumpFunctionTreeNode.class)
    public static final class DebugDumpFunctionTreeNodeGen extends DebugDumpFunctionTreeNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private int state_;

        private DebugDumpFunctionTreeNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if (state != 0 /* is-active dumpFunctionTree(DynamicObject) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((JSGuards.isJSFunction(arguments0Value__))) {
                    return dumpFunctionTree(arguments0Value__);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private Object executeAndSpecialize(Object arguments0Value) {
            int state = state_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((JSGuards.isJSFunction(arguments0Value_))) {
                    this.state_ = state = state | 0b1 /* add-active dumpFunctionTree(DynamicObject) */;
                    return dumpFunctionTree(arguments0Value_);
                }
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_}, arguments0Value);
        }

        @Override
        public NodeCost getCost() {
            int state = state_;
            if (state == 0b0) {
                return NodeCost.UNINITIALIZED;
            } else {
                return NodeCost.MONOMORPHIC;
            }
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "dumpFunctionTree";
            if (state != 0 /* is-active dumpFunctionTree(DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static DebugDumpFunctionTreeNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new DebugDumpFunctionTreeNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(DebugCompileFunctionNode.class)
    public static final class DebugCompileFunctionNodeGen extends DebugCompileFunctionNode implements Provider {

        @Child private JavaScriptNode arguments0_;

        private DebugCompileFunctionNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return DebugCompileFunctionNode.compileFunction(arguments0Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return DebugCompileFunctionNode.compileFunction(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            executeBoolean(frameValue);
            return;
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.MONOMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            s = new Object[3];
            s[0] = "compileFunction";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static DebugCompileFunctionNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new DebugCompileFunctionNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(DebugPrintObjectNode.class)
    public static final class DebugPrintObjectNodeGen extends DebugPrintObjectNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private int state_;

        private DebugPrintObjectNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if (state != 0 /* is-active printObject(DynamicObject, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                return printObject(arguments0Value__, arguments1Value_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private Object executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            int state = state_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                this.state_ = state = state | 0b1 /* add-active printObject(DynamicObject, Object) */;
                return printObject(arguments0Value_, arguments1Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_}, arguments0Value, arguments1Value);
        }

        @Override
        public NodeCost getCost() {
            int state = state_;
            if (state == 0b0) {
                return NodeCost.UNINITIALIZED;
            } else {
                return NodeCost.MONOMORPHIC;
            }
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "printObject";
            if (state != 0 /* is-active printObject(DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static DebugPrintObjectNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new DebugPrintObjectNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(DebugToJavaStringNode.class)
    public static final class DebugToJavaStringNodeGen extends DebugToJavaStringNode implements Provider {

        @Child private JavaScriptNode arguments0_;

        private DebugToJavaStringNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return DebugToJavaStringNode.toJavaString(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.MONOMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            s = new Object[3];
            s[0] = "toJavaString";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static DebugToJavaStringNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new DebugToJavaStringNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(DebugPrintSourceAttribution.class)
    public static final class DebugPrintSourceAttributionNodeGen extends DebugPrintSourceAttribution implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private int state_;

        private DebugPrintSourceAttributionNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state & 0b1) != 0 /* is-active printSourceAttribution(DynamicObject) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((JSGuards.isJSFunction(arguments0Value__))) {
                    return printSourceAttribution(arguments0Value__);
                }
            }
            if ((state & 0b10) != 0 /* is-active printSourceAttribution(String) */ && JSTypesGen.isImplicitString((state & 0b111100) >>> 2 /* extract-implicit-active 0:String */, arguments0Value_)) {
                String arguments0Value__ = JSTypesGen.asImplicitString((state & 0b111100) >>> 2 /* extract-implicit-active 0:String */, arguments0Value_);
                return printSourceAttribution(arguments0Value__);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private Object executeAndSpecialize(Object arguments0Value) {
            int state = state_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((JSGuards.isJSFunction(arguments0Value_))) {
                    this.state_ = state = state | 0b1 /* add-active printSourceAttribution(DynamicObject) */;
                    return printSourceAttribution(arguments0Value_);
                }
            }
            {
                int stringCast0;
                if ((stringCast0 = JSTypesGen.specializeImplicitString(arguments0Value)) != 0) {
                    String arguments0Value_ = JSTypesGen.asImplicitString(stringCast0, arguments0Value);
                    state = (state | (stringCast0 << 2) /* set-implicit-active 0:String */);
                    this.state_ = state = state | 0b10 /* add-active printSourceAttribution(String) */;
                    return printSourceAttribution(arguments0Value_);
                }
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_}, arguments0Value);
        }

        @Override
        public NodeCost getCost() {
            int state = state_;
            if ((state & 0b11) == 0b0) {
                return NodeCost.UNINITIALIZED;
            } else if (((state & 0b11) & ((state & 0b11) - 1)) == 0 /* is-single-active  */) {
                return NodeCost.MONOMORPHIC;
            }
            return NodeCost.POLYMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[3];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "printSourceAttribution";
            if ((state & 0b1) != 0 /* is-active printSourceAttribution(DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "printSourceAttribution";
            if ((state & 0b10) != 0 /* is-active printSourceAttribution(String) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static DebugPrintSourceAttribution create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new DebugPrintSourceAttributionNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(DebugArrayTypeNode.class)
    public static final class DebugArrayTypeNodeGen extends DebugArrayTypeNode implements Provider {

        @Child private JavaScriptNode arguments0_;

        private DebugArrayTypeNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return arraytype(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.MONOMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            s = new Object[3];
            s[0] = "arraytype";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static DebugArrayTypeNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new DebugArrayTypeNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(DebugAssertIntNode.class)
    public static final class DebugAssertIntNodeGen extends DebugAssertIntNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;

        private DebugAssertIntNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            return assertInt(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.MONOMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            s = new Object[3];
            s[0] = "assertInt";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static DebugAssertIntNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new DebugAssertIntNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(DebugHeapDumpNode.class)
    public static final class DebugHeapDumpNodeGen extends DebugHeapDumpNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;

        private DebugHeapDumpNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            return heapDump(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.MONOMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            s = new Object[3];
            s[0] = "heapDump";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static DebugHeapDumpNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new DebugHeapDumpNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(DebugStringCompareNode.class)
    public static final class DebugStringCompareNodeGen extends DebugStringCompareNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;

        private DebugStringCompareNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            return stringCompare(arguments0Value_, arguments1Value_);
        }

        @Override
        public int executeInt(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            return stringCompare(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            executeInt(frameValue);
            return;
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.MONOMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            s = new Object[3];
            s[0] = "stringCompare";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static DebugStringCompareNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new DebugStringCompareNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(DebugIsHolesArrayNode.class)
    public static final class DebugIsHolesArrayNodeGen extends DebugIsHolesArrayNode implements Provider {

        @Child private JavaScriptNode arguments0_;

        private DebugIsHolesArrayNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public boolean executeBoolean(Object arguments0Value) {
            return isHolesArray(arguments0Value);
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return isHolesArray(arguments0Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return isHolesArray(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            executeBoolean(frameValue);
            return;
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.MONOMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            s = new Object[3];
            s[0] = "isHolesArray";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static DebugIsHolesArrayNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new DebugIsHolesArrayNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(DebugJSStackNode.class)
    public static final class DebugJSStackNodeGen extends DebugJSStackNode implements Provider {

        private DebugJSStackNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            return printJSStack();
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.MONOMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            s = new Object[3];
            s[0] = "printJSStack";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static DebugJSStackNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new DebugJSStackNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(DebugLoadModuleNode.class)
    public static final class DebugLoadModuleNodeGen extends DebugLoadModuleNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;

        private DebugLoadModuleNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            return loadModule(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.MONOMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            s = new Object[3];
            s[0] = "loadModule";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static DebugLoadModuleNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new DebugLoadModuleNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(DebugSystemProperties.class)
    public static final class DebugSystemPropertiesNodeGen extends DebugSystemProperties implements Provider {

        private DebugSystemPropertiesNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            return systemProperties();
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.MONOMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            s = new Object[3];
            s[0] = "systemProperties";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static DebugSystemProperties create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new DebugSystemPropertiesNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(DebugSystemProperty.class)
    public static final class DebugSystemPropertyNodeGen extends DebugSystemProperty implements Provider {

        @Child private JavaScriptNode arguments0_;

        private DebugSystemPropertyNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return DebugSystemProperty.systemProperty(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.MONOMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            s = new Object[3];
            s[0] = "systemProperty";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static DebugSystemProperty create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new DebugSystemPropertyNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(DebugTypedArrayDetachBufferNode.class)
    public static final class DebugTypedArrayDetachBufferNodeGen extends DebugTypedArrayDetachBufferNode implements Provider {

        @Child private JavaScriptNode arguments0_;

        private DebugTypedArrayDetachBufferNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return DebugTypedArrayDetachBufferNode.detachBuffer(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.MONOMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            s = new Object[3];
            s[0] = "detachBuffer";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static DebugTypedArrayDetachBufferNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new DebugTypedArrayDetachBufferNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(DebugCreateSafeInteger.class)
    public static final class DebugCreateSafeIntegerNodeGen extends DebugCreateSafeInteger implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private int state_;

        private DebugCreateSafeIntegerNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            if ((state & 0b110) == 0 /* only-active createSafeInteger(int) */ && state != 0  /* is-not createSafeInteger(int) && createSafeInteger(SafeInteger) && createSafeInteger(Object) */) {
                return execute_int0(frameValue, state);
            } else {
                return execute_generic1(frameValue, state);
            }
        }

        private Object execute_int0(VirtualFrame frameValue, int state) {
            int arguments0Value_;
            try {
                arguments0Value_ = this.arguments0_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(ex.getResult());
            }
            assert (state & 0b1) != 0 /* is-active createSafeInteger(int) */;
            return DebugCreateSafeInteger.createSafeInteger(arguments0Value_);
        }

        private Object execute_generic1(VirtualFrame frameValue, int state) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state & 0b1) != 0 /* is-active createSafeInteger(int) */ && arguments0Value_ instanceof Integer) {
                int arguments0Value__ = (int) arguments0Value_;
                return DebugCreateSafeInteger.createSafeInteger(arguments0Value__);
            }
            if ((state & 0b10) != 0 /* is-active createSafeInteger(SafeInteger) */ && arguments0Value_ instanceof SafeInteger) {
                SafeInteger arguments0Value__ = (SafeInteger) arguments0Value_;
                return DebugCreateSafeInteger.createSafeInteger(arguments0Value__);
            }
            if ((state & 0b100) != 0 /* is-active createSafeInteger(Object) */) {
                return DebugCreateSafeInteger.createSafeInteger(arguments0Value_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private SafeInteger executeAndSpecialize(Object arguments0Value) {
            int state = state_;
            if (arguments0Value instanceof Integer) {
                int arguments0Value_ = (int) arguments0Value;
                this.state_ = state = state | 0b1 /* add-active createSafeInteger(int) */;
                return DebugCreateSafeInteger.createSafeInteger(arguments0Value_);
            }
            if (arguments0Value instanceof SafeInteger) {
                SafeInteger arguments0Value_ = (SafeInteger) arguments0Value;
                this.state_ = state = state | 0b10 /* add-active createSafeInteger(SafeInteger) */;
                return DebugCreateSafeInteger.createSafeInteger(arguments0Value_);
            }
            this.state_ = state = state | 0b100 /* add-active createSafeInteger(Object) */;
            return DebugCreateSafeInteger.createSafeInteger(arguments0Value);
        }

        @Override
        public NodeCost getCost() {
            int state = state_;
            if (state == 0b0) {
                return NodeCost.UNINITIALIZED;
            } else if ((state & (state - 1)) == 0 /* is-single-active  */) {
                return NodeCost.MONOMORPHIC;
            }
            return NodeCost.POLYMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[4];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "createSafeInteger";
            if ((state & 0b1) != 0 /* is-active createSafeInteger(int) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "createSafeInteger";
            if ((state & 0b10) != 0 /* is-active createSafeInteger(SafeInteger) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "createSafeInteger";
            if ((state & 0b100) != 0 /* is-active createSafeInteger(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static DebugCreateSafeInteger create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new DebugCreateSafeIntegerNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(DebugCreateLazyString.class)
    public static final class DebugCreateLazyStringNodeGen extends DebugCreateLazyString implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private int state_;

        private DebugCreateLazyStringNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if ((state & 0b1) != 0 /* is-active createLazyString(String, String) */ && JSTypesGen.isImplicitString((state & 0b111100) >>> 2 /* extract-implicit-active 0:String */, arguments0Value_)) {
                String arguments0Value__ = JSTypesGen.asImplicitString((state & 0b111100) >>> 2 /* extract-implicit-active 0:String */, arguments0Value_);
                if (JSTypesGen.isImplicitString((state & 0b1111000000) >>> 6 /* extract-implicit-active 1:String */, arguments1Value_)) {
                    String arguments1Value__ = JSTypesGen.asImplicitString((state & 0b1111000000) >>> 6 /* extract-implicit-active 1:String */, arguments1Value_);
                    return createLazyString(arguments0Value__, arguments1Value__);
                }
            }
            if ((state & 0b10) != 0 /* is-active createLazyString(Object, Object) */) {
                return createLazyString(arguments0Value_, arguments1Value_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private CharSequence executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            int state = state_;
            {
                int stringCast0;
                if ((stringCast0 = JSTypesGen.specializeImplicitString(arguments0Value)) != 0) {
                    String arguments0Value_ = JSTypesGen.asImplicitString(stringCast0, arguments0Value);
                    int stringCast1;
                    if ((stringCast1 = JSTypesGen.specializeImplicitString(arguments1Value)) != 0) {
                        String arguments1Value_ = JSTypesGen.asImplicitString(stringCast1, arguments1Value);
                        state = (state | (stringCast0 << 2) /* set-implicit-active 0:String */);
                        state = (state | (stringCast1 << 6) /* set-implicit-active 1:String */);
                        this.state_ = state = state | 0b1 /* add-active createLazyString(String, String) */;
                        return createLazyString(arguments0Value_, arguments1Value_);
                    }
                }
            }
            this.state_ = state = state | 0b10 /* add-active createLazyString(Object, Object) */;
            return createLazyString(arguments0Value, arguments1Value);
        }

        @Override
        public NodeCost getCost() {
            int state = state_;
            if ((state & 0b11) == 0b0) {
                return NodeCost.UNINITIALIZED;
            } else if (((state & 0b11) & ((state & 0b11) - 1)) == 0 /* is-single-active  */) {
                return NodeCost.MONOMORPHIC;
            }
            return NodeCost.POLYMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[3];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "createLazyString";
            if ((state & 0b1) != 0 /* is-active createLazyString(String, String) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "createLazyString";
            if ((state & 0b10) != 0 /* is-active createLazyString(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static DebugCreateLazyString create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new DebugCreateLazyStringNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(DebugNeverPartOfCompilationNode.class)
    public static final class DebugNeverPartOfCompilationNodeGen extends DebugNeverPartOfCompilationNode implements Provider {

        private DebugNeverPartOfCompilationNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            return DebugNeverPartOfCompilationNode.neverPartOfCompilation();
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.MONOMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            s = new Object[3];
            s[0] = "neverPartOfCompilation";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static DebugNeverPartOfCompilationNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new DebugNeverPartOfCompilationNodeGen(context, builtin, arguments);
        }

    }
}
