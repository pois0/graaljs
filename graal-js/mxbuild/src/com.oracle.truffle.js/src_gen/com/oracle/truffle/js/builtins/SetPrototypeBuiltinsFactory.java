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
import com.oracle.truffle.js.builtins.SetPrototypeBuiltins.CreateSetIteratorNode;
import com.oracle.truffle.js.builtins.SetPrototypeBuiltins.JSSetAddNode;
import com.oracle.truffle.js.builtins.SetPrototypeBuiltins.JSSetClearNode;
import com.oracle.truffle.js.builtins.SetPrototypeBuiltins.JSSetDeleteNode;
import com.oracle.truffle.js.builtins.SetPrototypeBuiltins.JSSetForEachNode;
import com.oracle.truffle.js.builtins.SetPrototypeBuiltins.JSSetHasNode;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.nodes.function.JSFunctionCallNode;
import com.oracle.truffle.js.nodes.unary.IsCallableNode;
import com.oracle.truffle.js.runtime.JSContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(SetPrototypeBuiltins.class)
public final class SetPrototypeBuiltinsFactory {

    @GeneratedBy(JSSetClearNode.class)
    public static final class JSSetClearNodeGen extends JSSetClearNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private int state_;

        private JSSetClearNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state & 0b1) != 0 /* is-active clear(DynamicObject) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((JSGuards.isJSSet(arguments0Value__))) {
                    return JSSetClearNode.clear(arguments0Value__);
                }
            }
            if ((state & 0b10) != 0 /* is-active notSet(Object) */) {
                if ((!(JSGuards.isJSSet(arguments0Value_)))) {
                    return JSSetClearNode.notSet(arguments0Value_);
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

        private DynamicObject executeAndSpecialize(Object arguments0Value) {
            int state = state_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((JSGuards.isJSSet(arguments0Value_))) {
                    this.state_ = state = state | 0b1 /* add-active clear(DynamicObject) */;
                    return JSSetClearNode.clear(arguments0Value_);
                }
            }
            if ((!(JSGuards.isJSSet(arguments0Value)))) {
                this.state_ = state = state | 0b10 /* add-active notSet(Object) */;
                return JSSetClearNode.notSet(arguments0Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_}, arguments0Value);
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
            Object[] data = new Object[3];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "clear";
            if ((state & 0b1) != 0 /* is-active clear(DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "notSet";
            if ((state & 0b10) != 0 /* is-active notSet(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static JSSetClearNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSSetClearNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSSetDeleteNode.class)
    public static final class JSSetDeleteNodeGen extends JSSetDeleteNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private int state_;

        private JSSetDeleteNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state != 0 /* is-active delete(DynamicObject, Object) || notSet(Object, Object) */) {
                if ((state & 0b1) != 0 /* is-active delete(DynamicObject, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((JSGuards.isJSSet(arguments0Value__))) {
                        return delete(arguments0Value__, arguments1Value_);
                    }
                }
                if ((state & 0b10) != 0 /* is-active notSet(Object, Object) */) {
                    if ((!(JSGuards.isJSSet(arguments0Value_)))) {
                        return JSSetDeleteNode.notSet(arguments0Value_, arguments1Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if (state != 0 /* is-active delete(DynamicObject, Object) || notSet(Object, Object) */) {
                if ((state & 0b1) != 0 /* is-active delete(DynamicObject, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((JSGuards.isJSSet(arguments0Value__))) {
                        return delete(arguments0Value__, arguments1Value_);
                    }
                }
                if ((state & 0b10) != 0 /* is-active notSet(Object, Object) */) {
                    if ((!(JSGuards.isJSSet(arguments0Value_)))) {
                        return JSSetDeleteNode.notSet(arguments0Value_, arguments1Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            executeBoolean(frameValue);
            return;
        }

        private boolean executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            int state = state_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((JSGuards.isJSSet(arguments0Value_))) {
                    this.state_ = state = state | 0b1 /* add-active delete(DynamicObject, Object) */;
                    return delete(arguments0Value_, arguments1Value);
                }
            }
            if ((!(JSGuards.isJSSet(arguments0Value)))) {
                this.state_ = state = state | 0b10 /* add-active notSet(Object, Object) */;
                return JSSetDeleteNode.notSet(arguments0Value, arguments1Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_}, arguments0Value, arguments1Value);
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
            Object[] data = new Object[3];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "delete";
            if ((state & 0b1) != 0 /* is-active delete(DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "notSet";
            if ((state & 0b10) != 0 /* is-active notSet(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static JSSetDeleteNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSSetDeleteNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSSetAddNode.class)
    public static final class JSSetAddNodeGen extends JSSetAddNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private int state_;

        private JSSetAddNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state != 0 /* is-active add(DynamicObject, Object) || notSet(Object, Object) */) {
                if ((state & 0b1) != 0 /* is-active add(DynamicObject, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((JSGuards.isJSSet(arguments0Value__))) {
                        return add(arguments0Value__, arguments1Value_);
                    }
                }
                if ((state & 0b10) != 0 /* is-active notSet(Object, Object) */) {
                    if ((!(JSGuards.isJSSet(arguments0Value_)))) {
                        return JSSetAddNode.notSet(arguments0Value_, arguments1Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            int state = state_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((JSGuards.isJSSet(arguments0Value_))) {
                    this.state_ = state = state | 0b1 /* add-active add(DynamicObject, Object) */;
                    return add(arguments0Value_, arguments1Value);
                }
            }
            if ((!(JSGuards.isJSSet(arguments0Value)))) {
                this.state_ = state = state | 0b10 /* add-active notSet(Object, Object) */;
                return JSSetAddNode.notSet(arguments0Value, arguments1Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_}, arguments0Value, arguments1Value);
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
            Object[] data = new Object[3];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "add";
            if ((state & 0b1) != 0 /* is-active add(DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "notSet";
            if ((state & 0b10) != 0 /* is-active notSet(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static JSSetAddNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSSetAddNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSSetHasNode.class)
    public static final class JSSetHasNodeGen extends JSSetHasNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private int state_;

        private JSSetHasNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state != 0 /* is-active has(DynamicObject, Object) || hasNoObject(Object, Object) */) {
                if ((state & 0b1) != 0 /* is-active has(DynamicObject, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((JSGuards.isJSSet(arguments0Value__))) {
                        return has(arguments0Value__, arguments1Value_);
                    }
                }
                if ((state & 0b10) != 0 /* is-active hasNoObject(Object, Object) */) {
                    if ((!(JSGuards.isJSSet(arguments0Value_)))) {
                        return hasNoObject(arguments0Value_, arguments1Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if (state != 0 /* is-active has(DynamicObject, Object) || hasNoObject(Object, Object) */) {
                if ((state & 0b1) != 0 /* is-active has(DynamicObject, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((JSGuards.isJSSet(arguments0Value__))) {
                        return has(arguments0Value__, arguments1Value_);
                    }
                }
                if ((state & 0b10) != 0 /* is-active hasNoObject(Object, Object) */) {
                    if ((!(JSGuards.isJSSet(arguments0Value_)))) {
                        return hasNoObject(arguments0Value_, arguments1Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            executeBoolean(frameValue);
            return;
        }

        private boolean executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            int state = state_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((JSGuards.isJSSet(arguments0Value_))) {
                    this.state_ = state = state | 0b1 /* add-active has(DynamicObject, Object) */;
                    return has(arguments0Value_, arguments1Value);
                }
            }
            if ((!(JSGuards.isJSSet(arguments0Value)))) {
                this.state_ = state = state | 0b10 /* add-active hasNoObject(Object, Object) */;
                return hasNoObject(arguments0Value, arguments1Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_}, arguments0Value, arguments1Value);
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
            Object[] data = new Object[3];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "has";
            if ((state & 0b1) != 0 /* is-active has(DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "hasNoObject";
            if ((state & 0b10) != 0 /* is-active hasNoObject(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static JSSetHasNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSSetHasNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSSetForEachNode.class)
    public static final class JSSetForEachNodeGen extends JSSetForEachNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private volatile int state_;
        @Child private IsCallableNode isCallable;
        @Child private JSFunctionCallNode forEachFunction_callNode_;

        private JSSetForEachNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state != 0 /* is-active forEachFunction(DynamicObject, DynamicObject, Object, IsCallableNode, JSFunctionCallNode) || forEachFunctionNoFunction(Object, Object, Object, IsCallableNode) || forEachFunctionNoSet(Object, Object, Object) */) {
                if ((state & 0b1) != 0 /* is-active forEachFunction(DynamicObject, DynamicObject, Object, IsCallableNode, JSFunctionCallNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if (JSTypes.isDynamicObject(arguments1Value_)) {
                        DynamicObject arguments1Value__ = (DynamicObject) arguments1Value_;
                        if ((JSGuards.isJSSet(arguments0Value__)) && (this.isCallable.executeBoolean(arguments1Value__))) {
                            return forEachFunction(arguments0Value__, arguments1Value__, arguments2Value_, this.isCallable, this.forEachFunction_callNode_);
                        }
                    }
                }
                if ((state & 0b110) != 0 /* is-active forEachFunctionNoFunction(Object, Object, Object, IsCallableNode) || forEachFunctionNoSet(Object, Object, Object) */) {
                    if ((state & 0b10) != 0 /* is-active forEachFunctionNoFunction(Object, Object, Object, IsCallableNode) */) {
                        if ((JSGuards.isJSSet(arguments0Value_)) && (!(this.isCallable.executeBoolean(arguments1Value_)))) {
                            return JSSetForEachNode.forEachFunctionNoFunction(arguments0Value_, arguments1Value_, arguments2Value_, this.isCallable);
                        }
                    }
                    if ((state & 0b100) != 0 /* is-active forEachFunctionNoSet(Object, Object, Object) */) {
                        if ((!(JSGuards.isJSSet(arguments0Value_)))) {
                            return JSSetForEachNode.forEachFunctionNoSet(arguments0Value_, arguments1Value_, arguments2Value_);
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
            try {
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if (JSTypes.isDynamicObject(arguments1Value)) {
                        DynamicObject arguments1Value_ = (DynamicObject) arguments1Value;
                        boolean ForEachFunction_duplicateFound_ = false;
                        if ((state & 0b1) != 0 /* is-active forEachFunction(DynamicObject, DynamicObject, Object, IsCallableNode, JSFunctionCallNode) */) {
                            if ((JSGuards.isJSSet(arguments0Value_)) && (this.isCallable.executeBoolean(arguments1Value_))) {
                                ForEachFunction_duplicateFound_ = true;
                            }
                        }
                        if (!ForEachFunction_duplicateFound_) {
                            if ((JSGuards.isJSSet(arguments0Value_))) {
                                IsCallableNode forEachFunction_isCallable__ = super.insert((IsCallableNode.create()));
                                if ((forEachFunction_isCallable__.executeBoolean(arguments1Value_)) && ((state & 0b1)) == 0 /* is-not-active forEachFunction(DynamicObject, DynamicObject, Object, IsCallableNode, JSFunctionCallNode) */) {
                                    if (this.isCallable == null) {
                                        this.isCallable = super.insert(forEachFunction_isCallable__);
                                    }
                                    this.forEachFunction_callNode_ = super.insert((JSFunctionCallNode.createCall()));
                                    this.state_ = state = state | 0b1 /* add-active forEachFunction(DynamicObject, DynamicObject, Object, IsCallableNode, JSFunctionCallNode) */;
                                    ForEachFunction_duplicateFound_ = true;
                                }
                            }
                        }
                        if (ForEachFunction_duplicateFound_) {
                            lock.unlock();
                            hasLock = false;
                            return forEachFunction(arguments0Value_, arguments1Value_, arguments2Value, this.isCallable, this.forEachFunction_callNode_);
                        }
                    }
                }
                boolean ForEachFunctionNoFunction_duplicateFound_ = false;
                if ((state & 0b10) != 0 /* is-active forEachFunctionNoFunction(Object, Object, Object, IsCallableNode) */) {
                    if ((JSGuards.isJSSet(arguments0Value)) && (!(this.isCallable.executeBoolean(arguments1Value)))) {
                        ForEachFunctionNoFunction_duplicateFound_ = true;
                    }
                }
                if (!ForEachFunctionNoFunction_duplicateFound_) {
                    if ((JSGuards.isJSSet(arguments0Value))) {
                        IsCallableNode forEachFunctionNoFunction_isCallable__ = super.insert((IsCallableNode.create()));
                        if ((!(forEachFunctionNoFunction_isCallable__.executeBoolean(arguments1Value))) && ((state & 0b10)) == 0 /* is-not-active forEachFunctionNoFunction(Object, Object, Object, IsCallableNode) */) {
                            if (this.isCallable == null) {
                                this.isCallable = super.insert(forEachFunctionNoFunction_isCallable__);
                            }
                            this.state_ = state = state | 0b10 /* add-active forEachFunctionNoFunction(Object, Object, Object, IsCallableNode) */;
                            ForEachFunctionNoFunction_duplicateFound_ = true;
                        }
                    }
                }
                if (ForEachFunctionNoFunction_duplicateFound_) {
                    lock.unlock();
                    hasLock = false;
                    return JSSetForEachNode.forEachFunctionNoFunction(arguments0Value, arguments1Value, arguments2Value, this.isCallable);
                }
                if ((!(JSGuards.isJSSet(arguments0Value)))) {
                    this.state_ = state = state | 0b100 /* add-active forEachFunctionNoSet(Object, Object, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return JSSetForEachNode.forEachFunctionNoSet(arguments0Value, arguments1Value, arguments2Value);
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
            s = new Object[3];
            s[0] = "forEachFunction";
            if ((state & 0b1) != 0 /* is-active forEachFunction(DynamicObject, DynamicObject, Object, IsCallableNode, JSFunctionCallNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.isCallable, this.forEachFunction_callNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "forEachFunctionNoFunction";
            if ((state & 0b10) != 0 /* is-active forEachFunctionNoFunction(Object, Object, Object, IsCallableNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.isCallable));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "forEachFunctionNoSet";
            if ((state & 0b100) != 0 /* is-active forEachFunctionNoSet(Object, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static JSSetForEachNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSSetForEachNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(CreateSetIteratorNode.class)
    public static final class CreateSetIteratorNodeGen extends CreateSetIteratorNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private int state_;

        private CreateSetIteratorNodeGen(JSContext context, JSBuiltin builtin, int iterationKind, JavaScriptNode[] arguments) {
            super(context, builtin, iterationKind);
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
            if ((state & 0b1) != 0 /* is-active doSet(VirtualFrame, DynamicObject) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((JSGuards.isJSSet(arguments0Value__))) {
                    return doSet(frameValue, arguments0Value__);
                }
            }
            if ((state & 0b10) != 0 /* is-active doIncompatibleReceiver(Object) */) {
                if ((!(JSGuards.isJSSet(arguments0Value_)))) {
                    return doIncompatibleReceiver(arguments0Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(frameValue, arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(VirtualFrame frameValue, Object arguments0Value) {
            int state = state_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((JSGuards.isJSSet(arguments0Value_))) {
                    this.state_ = state = state | 0b1 /* add-active doSet(VirtualFrame, DynamicObject) */;
                    return doSet(frameValue, arguments0Value_);
                }
            }
            if ((!(JSGuards.isJSSet(arguments0Value)))) {
                this.state_ = state = state | 0b10 /* add-active doIncompatibleReceiver(Object) */;
                return doIncompatibleReceiver(arguments0Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_}, arguments0Value);
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
            Object[] data = new Object[3];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "doSet";
            if ((state & 0b1) != 0 /* is-active doSet(VirtualFrame, DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doIncompatibleReceiver";
            if ((state & 0b10) != 0 /* is-active doIncompatibleReceiver(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static CreateSetIteratorNode create(JSContext context, JSBuiltin builtin, int iterationKind, JavaScriptNode[] arguments) {
            return new CreateSetIteratorNodeGen(context, builtin, iterationKind, arguments);
        }

    }
}
