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
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.builtins.FunctionPrototypeBuiltins.HasInstanceNode;
import com.oracle.truffle.js.builtins.FunctionPrototypeBuiltins.JSApplyNode;
import com.oracle.truffle.js.builtins.FunctionPrototypeBuiltins.JSBindNode;
import com.oracle.truffle.js.builtins.FunctionPrototypeBuiltins.JSCallNode;
import com.oracle.truffle.js.builtins.FunctionPrototypeBuiltins.JSFunctionToStringNode;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.nodes.unary.IsCallableNode;
import com.oracle.truffle.js.runtime.JSContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(FunctionPrototypeBuiltins.class)
public final class FunctionPrototypeBuiltinsFactory {

    @GeneratedBy(JSBindNode.class)
    public static final class JSBindNodeGen extends JSBindNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private int state_;

        private JSBindNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
            this.arguments2_ = arguments != null && 2 < arguments.length ? arguments[2] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_, this.arguments2_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if (state != 0 /* is-active bindFunction(DynamicObject, Object, Object[]) || bindProxy(DynamicObject, Object, Object[]) || bindError(Object, Object, Object[]) */ && arguments2Value_ instanceof Object[]) {
                Object[] arguments2Value__ = (Object[]) arguments2Value_;
                if ((state & 0b11) != 0 /* is-active bindFunction(DynamicObject, Object, Object[]) || bindProxy(DynamicObject, Object, Object[]) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((state & 0b1) != 0 /* is-active bindFunction(DynamicObject, Object, Object[]) */) {
                        if ((JSGuards.isJSFunction(arguments0Value__))) {
                            return bindFunction(arguments0Value__, arguments1Value_, arguments2Value__);
                        }
                    }
                    if ((state & 0b10) != 0 /* is-active bindProxy(DynamicObject, Object, Object[]) */) {
                        if ((JSGuards.isJSProxy(arguments0Value__))) {
                            return bindProxy(arguments0Value__, arguments1Value_, arguments2Value__);
                        }
                    }
                }
                if ((state & 0b100) != 0 /* is-active bindError(Object, Object, Object[]) */) {
                    if ((!(JSGuards.isJSFunction(arguments0Value_))) && (!(JSGuards.isJSProxy(arguments0Value_)))) {
                        return bindError(arguments0Value_, arguments1Value_, arguments2Value__);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            int state = state_;
            if (arguments2Value instanceof Object[]) {
                Object[] arguments2Value_ = (Object[]) arguments2Value;
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSFunction(arguments0Value_))) {
                        this.state_ = state = state | 0b1 /* add-active bindFunction(DynamicObject, Object, Object[]) */;
                        return bindFunction(arguments0Value_, arguments1Value, arguments2Value_);
                    }
                    if ((JSGuards.isJSProxy(arguments0Value_))) {
                        this.state_ = state = state | 0b10 /* add-active bindProxy(DynamicObject, Object, Object[]) */;
                        return bindProxy(arguments0Value_, arguments1Value, arguments2Value_);
                    }
                }
                if ((!(JSGuards.isJSFunction(arguments0Value))) && (!(JSGuards.isJSProxy(arguments0Value)))) {
                    this.state_ = state = state | 0b100 /* add-active bindError(Object, Object, Object[]) */;
                    return bindError(arguments0Value, arguments1Value, arguments2Value_);
                }
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_, this.arguments2_}, arguments0Value, arguments1Value, arguments2Value);
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
            s[0] = "bindFunction";
            if ((state & 0b1) != 0 /* is-active bindFunction(DynamicObject, Object, Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "bindProxy";
            if ((state & 0b10) != 0 /* is-active bindProxy(DynamicObject, Object, Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "bindError";
            if ((state & 0b100) != 0 /* is-active bindError(Object, Object, Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static JSBindNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSBindNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSFunctionToStringNode.class)
    public static final class JSFunctionToStringNodeGen extends JSFunctionToStringNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_;
        @Child private IsCallableNode isCallable;

        private JSFunctionToStringNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state & 0b111) != 0 /* is-active toStringDefault(DynamicObject) || toStringBound(DynamicObject) || toString(DynamicObject) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state & 0b1) != 0 /* is-active toStringDefault(DynamicObject) */) {
                    if ((JSGuards.isJSFunction(arguments0Value__)) && (isRootTarget(arguments0Value__)) && (!(isBoundTarget(arguments0Value__)))) {
                        return toStringDefault(arguments0Value__);
                    }
                }
                if ((state & 0b10) != 0 /* is-active toStringBound(DynamicObject) */) {
                    if ((JSGuards.isJSFunction(arguments0Value__)) && (isRootTarget(arguments0Value__)) && (isBoundTarget(arguments0Value__))) {
                        return toStringBound(arguments0Value__);
                    }
                }
                if ((state & 0b100) != 0 /* is-active toString(DynamicObject) */) {
                    if ((JSGuards.isJSFunction(arguments0Value__)) && (!(isRootTarget(arguments0Value__)))) {
                        return toString(arguments0Value__);
                    }
                }
            }
            if ((state & 0b111000) != 0 /* is-active toStringCallable(Object, IsCallableNode) || toStringNotCallable(Object, IsCallableNode) || toStringNotFunction(Object) */) {
                if ((state & 0b1000) != 0 /* is-active toStringCallable(Object, IsCallableNode) */) {
                    assert (isES2019OrLater());
                    if ((!(JSGuards.isJSFunction(arguments0Value_))) && (this.isCallable.executeBoolean(arguments0Value_))) {
                        return toStringCallable(arguments0Value_, this.isCallable);
                    }
                }
                if ((state & 0b10000) != 0 /* is-active toStringNotCallable(Object, IsCallableNode) */) {
                    assert (isES2019OrLater());
                    if ((!(this.isCallable.executeBoolean(arguments0Value_)))) {
                        return toStringNotCallable(arguments0Value_, this.isCallable);
                    }
                }
                if ((state & 0b100000) != 0 /* is-active toStringNotFunction(Object) */) {
                    assert (!(isES2019OrLater()));
                    if ((!(JSGuards.isJSFunction(arguments0Value_)))) {
                        return toStringNotFunction(arguments0Value_);
                    }
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

        private String executeAndSpecialize(Object arguments0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            try {
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSFunction(arguments0Value_)) && (isRootTarget(arguments0Value_)) && (!(isBoundTarget(arguments0Value_)))) {
                        this.state_ = state = state | 0b1 /* add-active toStringDefault(DynamicObject) */;
                        lock.unlock();
                        hasLock = false;
                        return toStringDefault(arguments0Value_);
                    }
                    if ((JSGuards.isJSFunction(arguments0Value_)) && (isRootTarget(arguments0Value_)) && (isBoundTarget(arguments0Value_))) {
                        this.state_ = state = state | 0b10 /* add-active toStringBound(DynamicObject) */;
                        lock.unlock();
                        hasLock = false;
                        return toStringBound(arguments0Value_);
                    }
                    if ((JSGuards.isJSFunction(arguments0Value_)) && (!(isRootTarget(arguments0Value_)))) {
                        this.state_ = state = state | 0b100 /* add-active toString(DynamicObject) */;
                        lock.unlock();
                        hasLock = false;
                        return toString(arguments0Value_);
                    }
                }
                boolean ToStringCallable_duplicateFound_ = false;
                if ((state & 0b1000) != 0 /* is-active toStringCallable(Object, IsCallableNode) */) {
                    assert (isES2019OrLater());
                    if ((!(JSGuards.isJSFunction(arguments0Value))) && (this.isCallable.executeBoolean(arguments0Value))) {
                        ToStringCallable_duplicateFound_ = true;
                    }
                }
                if (!ToStringCallable_duplicateFound_) {
                    if ((isES2019OrLater()) && (!(JSGuards.isJSFunction(arguments0Value)))) {
                        IsCallableNode toStringCallable_isCallable__ = super.insert((IsCallableNode.create()));
                        if ((toStringCallable_isCallable__.executeBoolean(arguments0Value)) && ((state & 0b1000)) == 0 /* is-not-active toStringCallable(Object, IsCallableNode) */) {
                            if (this.isCallable == null) {
                                this.isCallable = super.insert(toStringCallable_isCallable__);
                            }
                            this.state_ = state = state | 0b1000 /* add-active toStringCallable(Object, IsCallableNode) */;
                            ToStringCallable_duplicateFound_ = true;
                        }
                    }
                }
                if (ToStringCallable_duplicateFound_) {
                    lock.unlock();
                    hasLock = false;
                    return toStringCallable(arguments0Value, this.isCallable);
                }
                boolean ToStringNotCallable_duplicateFound_ = false;
                if ((state & 0b10000) != 0 /* is-active toStringNotCallable(Object, IsCallableNode) */) {
                    assert (isES2019OrLater());
                    if ((!(this.isCallable.executeBoolean(arguments0Value)))) {
                        ToStringNotCallable_duplicateFound_ = true;
                    }
                }
                if (!ToStringNotCallable_duplicateFound_) {
                    if ((isES2019OrLater())) {
                        IsCallableNode toStringNotCallable_isCallable__ = super.insert((IsCallableNode.create()));
                        if ((!(toStringNotCallable_isCallable__.executeBoolean(arguments0Value))) && ((state & 0b10000)) == 0 /* is-not-active toStringNotCallable(Object, IsCallableNode) */) {
                            if (this.isCallable == null) {
                                this.isCallable = super.insert(toStringNotCallable_isCallable__);
                            }
                            this.state_ = state = state | 0b10000 /* add-active toStringNotCallable(Object, IsCallableNode) */;
                            ToStringNotCallable_duplicateFound_ = true;
                        }
                    }
                }
                if (ToStringNotCallable_duplicateFound_) {
                    lock.unlock();
                    hasLock = false;
                    return toStringNotCallable(arguments0Value, this.isCallable);
                }
                if ((!(isES2019OrLater())) && (!(JSGuards.isJSFunction(arguments0Value)))) {
                    this.state_ = state = state | 0b100000 /* add-active toStringNotFunction(Object) */;
                    lock.unlock();
                    hasLock = false;
                    return toStringNotFunction(arguments0Value);
                }
                throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_}, arguments0Value);
            } finally {
                if (hasLock) {
                    lock.unlock();
                }
            }
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
            Object[] data = new Object[7];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "toStringDefault";
            if ((state & 0b1) != 0 /* is-active toStringDefault(DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "toStringBound";
            if ((state & 0b10) != 0 /* is-active toStringBound(DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "toString";
            if ((state & 0b100) != 0 /* is-active toString(DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "toStringCallable";
            if ((state & 0b1000) != 0 /* is-active toStringCallable(Object, IsCallableNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.isCallable));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            s = new Object[3];
            s[0] = "toStringNotCallable";
            if ((state & 0b10000) != 0 /* is-active toStringNotCallable(Object, IsCallableNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.isCallable));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[5] = s;
            s = new Object[3];
            s[0] = "toStringNotFunction";
            if ((state & 0b100000) != 0 /* is-active toStringNotFunction(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[6] = s;
            return Provider.create(data);
        }

        public static JSFunctionToStringNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSFunctionToStringNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSApplyNode.class)
    public static final class JSApplyNodeGen extends JSApplyNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private volatile int state_;
        @CompilationFinal private volatile int exclude_;
        @Child private IsCallableNode isCallable;

        private JSApplyNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
            this.arguments2_ = arguments != null && 2 < arguments.length ? arguments[2] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_, this.arguments2_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if (state != 0 /* is-active applyFunction(DynamicObject, Object, Object) || applyCallable(Object, Object, Object, IsCallableNode) || error(Object, Object, Object, IsCallableNode) */) {
                if ((state & 0b1) != 0 /* is-active applyFunction(DynamicObject, Object, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((JSGuards.isJSFunction(arguments0Value__))) {
                        return applyFunction(arguments0Value__, arguments1Value_, arguments2Value_);
                    }
                }
                if ((state & 0b110) != 0 /* is-active applyCallable(Object, Object, Object, IsCallableNode) || error(Object, Object, Object, IsCallableNode) */) {
                    if ((state & 0b10) != 0 /* is-active applyCallable(Object, Object, Object, IsCallableNode) */) {
                        if ((this.isCallable.executeBoolean(arguments0Value_))) {
                            return applyCallable(arguments0Value_, arguments1Value_, arguments2Value_, this.isCallable);
                        }
                    }
                    if ((state & 0b100) != 0 /* is-active error(Object, Object, Object, IsCallableNode) */) {
                        if ((!(this.isCallable.executeBoolean(arguments0Value_)))) {
                            return error(arguments0Value_, arguments1Value_, arguments2Value_, this.isCallable);
                        }
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private Object executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int exclude = exclude_;
            try {
                if ((exclude) == 0 /* is-not-excluded applyFunction(DynamicObject, Object, Object) */ && JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSFunction(arguments0Value_))) {
                        this.state_ = state = state | 0b1 /* add-active applyFunction(DynamicObject, Object, Object) */;
                        lock.unlock();
                        hasLock = false;
                        return applyFunction(arguments0Value_, arguments1Value, arguments2Value);
                    }
                }
                boolean ApplyCallable_duplicateFound_ = false;
                if ((state & 0b10) != 0 /* is-active applyCallable(Object, Object, Object, IsCallableNode) */) {
                    if ((this.isCallable.executeBoolean(arguments0Value))) {
                        ApplyCallable_duplicateFound_ = true;
                    }
                }
                if (!ApplyCallable_duplicateFound_) {
                    {
                        IsCallableNode applyCallable_isCallable__ = super.insert((IsCallableNode.create()));
                        if ((applyCallable_isCallable__.executeBoolean(arguments0Value)) && ((state & 0b10)) == 0 /* is-not-active applyCallable(Object, Object, Object, IsCallableNode) */) {
                            if (this.isCallable == null) {
                                this.isCallable = super.insert(applyCallable_isCallable__);
                            }
                            this.exclude_ = exclude = exclude | 0b1 /* add-excluded applyFunction(DynamicObject, Object, Object) */;
                            state = state & 0xfffffffe /* remove-active applyFunction(DynamicObject, Object, Object) */;
                            this.state_ = state = state | 0b10 /* add-active applyCallable(Object, Object, Object, IsCallableNode) */;
                            ApplyCallable_duplicateFound_ = true;
                        }
                    }
                }
                if (ApplyCallable_duplicateFound_) {
                    lock.unlock();
                    hasLock = false;
                    return applyCallable(arguments0Value, arguments1Value, arguments2Value, this.isCallable);
                }
                boolean Error_duplicateFound_ = false;
                if ((state & 0b100) != 0 /* is-active error(Object, Object, Object, IsCallableNode) */) {
                    if ((!(this.isCallable.executeBoolean(arguments0Value)))) {
                        Error_duplicateFound_ = true;
                    }
                }
                if (!Error_duplicateFound_) {
                    {
                        IsCallableNode error_isCallable__ = super.insert((IsCallableNode.create()));
                        if ((!(error_isCallable__.executeBoolean(arguments0Value))) && ((state & 0b100)) == 0 /* is-not-active error(Object, Object, Object, IsCallableNode) */) {
                            if (this.isCallable == null) {
                                this.isCallable = super.insert(error_isCallable__);
                            }
                            this.state_ = state = state | 0b100 /* add-active error(Object, Object, Object, IsCallableNode) */;
                            Error_duplicateFound_ = true;
                        }
                    }
                }
                if (Error_duplicateFound_) {
                    lock.unlock();
                    hasLock = false;
                    return error(arguments0Value, arguments1Value, arguments2Value, this.isCallable);
                }
                throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_, this.arguments2_}, arguments0Value, arguments1Value, arguments2Value);
            } finally {
                if (hasLock) {
                    lock.unlock();
                }
            }
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
            int exclude = exclude_;
            s = new Object[3];
            s[0] = "applyFunction";
            if ((state & 0b1) != 0 /* is-active applyFunction(DynamicObject, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else if (exclude != 0 /* is-excluded applyFunction(DynamicObject, Object, Object) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "applyCallable";
            if ((state & 0b10) != 0 /* is-active applyCallable(Object, Object, Object, IsCallableNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.isCallable));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "error";
            if ((state & 0b100) != 0 /* is-active error(Object, Object, Object, IsCallableNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.isCallable));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static JSApplyNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSApplyNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSCallNode.class)
    public static final class JSCallNodeGen extends JSCallNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private int state_;

        private JSCallNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
            this.arguments2_ = arguments != null && 2 < arguments.length ? arguments[2] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_, this.arguments2_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if (state != 0 /* is-active call(Object, Object, Object[]) */ && arguments2Value_ instanceof Object[]) {
                Object[] arguments2Value__ = (Object[]) arguments2Value_;
                return call(arguments0Value_, arguments1Value_, arguments2Value__);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private Object executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            int state = state_;
            if (arguments2Value instanceof Object[]) {
                Object[] arguments2Value_ = (Object[]) arguments2Value;
                this.state_ = state = state | 0b1 /* add-active call(Object, Object, Object[]) */;
                return call(arguments0Value, arguments1Value, arguments2Value_);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_, this.arguments2_}, arguments0Value, arguments1Value, arguments2Value);
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
            s[0] = "call";
            if (state != 0 /* is-active call(Object, Object, Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static JSCallNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSCallNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(HasInstanceNode.class)
    public static final class HasInstanceNodeGen extends HasInstanceNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;

        private HasInstanceNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            return hasInstance(arguments0Value_, arguments1Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            return hasInstance(arguments0Value_, arguments1Value_);
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
            s[0] = "hasInstance";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static HasInstanceNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new HasInstanceNodeGen(context, builtin, arguments);
        }

    }
}
