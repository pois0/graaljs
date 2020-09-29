// CheckStyle: start generated
package com.oracle.truffle.js.nodes.interop;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.TruffleLanguage.LanguageReference;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.interop.UnknownIdentifierException;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.lang.JavaScriptLanguage;
import com.oracle.truffle.js.nodes.access.PropertyGetNode;
import com.oracle.truffle.js.nodes.access.ReadElementNode;
import com.oracle.truffle.js.nodes.function.JSFunctionCallNode;
import com.oracle.truffle.js.nodes.unary.IsCallableNode;
import com.oracle.truffle.js.nodes.unary.IsCallableNodeGen;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSInteropInvokeNode.class)
public final class JSInteropInvokeNodeGen extends JSInteropInvokeNode implements Provider {

    private static final Uncached UNCACHED = new Uncached();

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @Child private IsCallableNode isCallable;
    @Child private JSFunctionCallNode call;
    @Child private ImportValueNode importValue;
    @CompilationFinal private LanguageReference<JavaScriptLanguage> javaScriptLanguageReference_;
    @CompilationFinal private String cached_cachedName_;
    @Child private PropertyGetNode cached_functionPropertyGetNode_;
    @Child private ReadElementNode uncached_readNode_;

    private JSInteropInvokeNodeGen() {
    }

    @Override
    public Object execute(DynamicObject arg0Value, String arg1Value, Object[] arg2Value) throws UnknownIdentifierException, UnsupportedMessageException {
        int state = state_;
        if ((state & 0b11) != 0 /* is-active doCached(DynamicObject, String, Object[], String, LanguageReference<JavaScriptLanguage>, PropertyGetNode, IsCallableNode, JSFunctionCallNode, ImportValueNode) || doUncached(DynamicObject, String, Object[], LanguageReference<JavaScriptLanguage>, ReadElementNode, IsCallableNode, JSFunctionCallNode, ImportValueNode) */) {
            if ((state & 0b1) != 0 /* is-active doCached(DynamicObject, String, Object[], String, LanguageReference<JavaScriptLanguage>, PropertyGetNode, IsCallableNode, JSFunctionCallNode, ImportValueNode) */) {
                if ((this.cached_cachedName_.equals(arg1Value))) {
                    LanguageReference<JavaScriptLanguage> javaScriptLanguageReference__ = this.javaScriptLanguageReference_;
                    LanguageReference<JavaScriptLanguage> cached_languageRef__ = javaScriptLanguageReference__;
                    return doCached(arg0Value, arg1Value, arg2Value, this.cached_cachedName_, cached_languageRef__, this.cached_functionPropertyGetNode_, this.isCallable, this.call, this.importValue);
                }
            }
            if ((state & 0b10) != 0 /* is-active doUncached(DynamicObject, String, Object[], LanguageReference<JavaScriptLanguage>, ReadElementNode, IsCallableNode, JSFunctionCallNode, ImportValueNode) */) {
                {
                    LanguageReference<JavaScriptLanguage> javaScriptLanguageReference__1 = this.javaScriptLanguageReference_;
                    LanguageReference<JavaScriptLanguage> uncached_languageRef__ = javaScriptLanguageReference__1;
                    return doUncached(arg0Value, arg1Value, arg2Value, uncached_languageRef__, this.uncached_readNode_, this.isCallable, this.call, this.importValue);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value, arg2Value);
    }

    private Object executeAndSpecialize(DynamicObject arg0Value, String arg1Value, Object[] arg2Value) throws UnknownIdentifierException, UnsupportedMessageException {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        int exclude = exclude_;
        try {
            {
                LanguageReference<JavaScriptLanguage> cached_languageRef__ = null;
                if ((exclude) == 0 /* is-not-excluded doCached(DynamicObject, String, Object[], String, LanguageReference<JavaScriptLanguage>, PropertyGetNode, IsCallableNode, JSFunctionCallNode, ImportValueNode) */) {
                    boolean Cached_duplicateFound_ = false;
                    if ((state & 0b1) != 0 /* is-active doCached(DynamicObject, String, Object[], String, LanguageReference<JavaScriptLanguage>, PropertyGetNode, IsCallableNode, JSFunctionCallNode, ImportValueNode) */) {
                        if ((this.cached_cachedName_.equals(arg1Value))) {
                            Cached_duplicateFound_ = true;
                            LanguageReference<JavaScriptLanguage> javaScriptLanguageReference__2 = this.javaScriptLanguageReference_;
                            if (javaScriptLanguageReference__2 == null) {
                                this.javaScriptLanguageReference_ = javaScriptLanguageReference__2 = super.lookupLanguageReference(JavaScriptLanguage.class);
                            }
                            cached_languageRef__ = javaScriptLanguageReference__2;
                        }
                    }
                    if (!Cached_duplicateFound_) {
                        // assert (this.cached_cachedName_.equals(arg1Value));
                        if (((state & 0b1)) == 0 /* is-not-active doCached(DynamicObject, String, Object[], String, LanguageReference<JavaScriptLanguage>, PropertyGetNode, IsCallableNode, JSFunctionCallNode, ImportValueNode) */) {
                            this.cached_cachedName_ = (arg1Value);
                            LanguageReference<JavaScriptLanguage> javaScriptLanguageReference__3 = this.javaScriptLanguageReference_;
                            if (javaScriptLanguageReference__3 == null) {
                                this.javaScriptLanguageReference_ = javaScriptLanguageReference__3 = super.lookupLanguageReference(JavaScriptLanguage.class);
                            }
                            cached_languageRef__ = javaScriptLanguageReference__3;
                            this.cached_functionPropertyGetNode_ = super.insert((createGetProperty(this.cached_cachedName_, cached_languageRef__)));
                            if (this.isCallable == null) {
                                this.isCallable = super.insert((IsCallableNode.create()));
                            }
                            if (this.call == null) {
                                this.call = super.insert((JSFunctionCallNode.createCall()));
                            }
                            if (this.importValue == null) {
                                this.importValue = super.insert((ImportValueNode.create()));
                            }
                            this.state_ = state = state | 0b1 /* add-active doCached(DynamicObject, String, Object[], String, LanguageReference<JavaScriptLanguage>, PropertyGetNode, IsCallableNode, JSFunctionCallNode, ImportValueNode) */;
                            Cached_duplicateFound_ = true;
                        }
                    }
                    if (Cached_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return doCached(arg0Value, arg1Value, arg2Value, this.cached_cachedName_, cached_languageRef__, this.cached_functionPropertyGetNode_, this.isCallable, this.call, this.importValue);
                    }
                }
            }
            {
                LanguageReference<JavaScriptLanguage> uncached_languageRef__ = null;
                LanguageReference<JavaScriptLanguage> javaScriptLanguageReference__4 = this.javaScriptLanguageReference_;
                if (javaScriptLanguageReference__4 == null) {
                    this.javaScriptLanguageReference_ = javaScriptLanguageReference__4 = super.lookupLanguageReference(JavaScriptLanguage.class);
                }
                uncached_languageRef__ = javaScriptLanguageReference__4;
                this.uncached_readNode_ = super.insert((ReadElementNode.create(uncached_languageRef__.get().getJSContext())));
                if (this.isCallable == null) {
                    this.isCallable = super.insert((IsCallableNode.create()));
                }
                if (this.call == null) {
                    this.call = super.insert((JSFunctionCallNode.createCall()));
                }
                if (this.importValue == null) {
                    this.importValue = super.insert((ImportValueNode.create()));
                }
                this.exclude_ = exclude = exclude | 0b1 /* add-excluded doCached(DynamicObject, String, Object[], String, LanguageReference<JavaScriptLanguage>, PropertyGetNode, IsCallableNode, JSFunctionCallNode, ImportValueNode) */;
                state = state & 0xfffffffe /* remove-active doCached(DynamicObject, String, Object[], String, LanguageReference<JavaScriptLanguage>, PropertyGetNode, IsCallableNode, JSFunctionCallNode, ImportValueNode) */;
                this.state_ = state = state | 0b10 /* add-active doUncached(DynamicObject, String, Object[], LanguageReference<JavaScriptLanguage>, ReadElementNode, IsCallableNode, JSFunctionCallNode, ImportValueNode) */;
                lock.unlock();
                hasLock = false;
                return doUncached(arg0Value, arg1Value, arg2Value, uncached_languageRef__, this.uncached_readNode_, this.isCallable, this.call, this.importValue);
            }
        } finally {
            if (hasLock) {
                lock.unlock();
            }
        }
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
        int exclude = exclude_;
        s = new Object[3];
        s[0] = "doCached";
        if ((state & 0b1) != 0 /* is-active doCached(DynamicObject, String, Object[], String, LanguageReference<JavaScriptLanguage>, PropertyGetNode, IsCallableNode, JSFunctionCallNode, ImportValueNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.cached_cachedName_, this.cached_functionPropertyGetNode_, this.isCallable, this.call, this.importValue));
            s[2] = cached;
        } else if (exclude != 0 /* is-excluded doCached(DynamicObject, String, Object[], String, LanguageReference<JavaScriptLanguage>, PropertyGetNode, IsCallableNode, JSFunctionCallNode, ImportValueNode) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doUncached";
        if ((state & 0b10) != 0 /* is-active doUncached(DynamicObject, String, Object[], LanguageReference<JavaScriptLanguage>, ReadElementNode, IsCallableNode, JSFunctionCallNode, ImportValueNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.uncached_readNode_, this.isCallable, this.call, this.importValue));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        return Provider.create(data);
    }

    public static JSInteropInvokeNode create() {
        return new JSInteropInvokeNodeGen();
    }

    public static JSInteropInvokeNode getUncached() {
        return JSInteropInvokeNodeGen.UNCACHED;
    }

    @GeneratedBy(JSInteropInvokeNode.class)
    private static final class Uncached extends JSInteropInvokeNode {

        private final LanguageReference<JavaScriptLanguage> javaScriptLanguageReference_ = lookupLanguageReference(JavaScriptLanguage.class);

        @TruffleBoundary
        @Override
        public Object execute(DynamicObject arg0Value, String arg1Value, Object[] arg2Value) throws UnknownIdentifierException, UnsupportedMessageException {
            return doUncached(arg0Value, arg1Value, arg2Value, this.javaScriptLanguageReference_, (JSInteropInvokeNode.getUncachedRead()), (IsCallableNodeGen.getUncached()), (JSInteropCallNode.getUncachedCall()), (ImportValueNodeGen.getUncached()));
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.MEGAMORPHIC;
        }

        @Override
        public boolean isAdoptable() {
            return false;
        }

    }
}
