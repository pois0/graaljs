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
import com.oracle.truffle.js.builtins.CallSitePrototypeBuiltins.CallSiteGetBooleanNode;
import com.oracle.truffle.js.builtins.CallSitePrototypeBuiltins.CallSiteGetNode;
import com.oracle.truffle.js.builtins.CallSitePrototypeBuiltins.CallSiteGetNumberNode;
import com.oracle.truffle.js.builtins.CallSitePrototypeBuiltins.CallSitePrototype;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSContext;

@GeneratedBy(CallSitePrototypeBuiltins.class)
public final class CallSitePrototypeBuiltinsFactory {

    @GeneratedBy(CallSiteGetNumberNode.class)
    static final class CallSiteGetNumberNodeGen extends CallSiteGetNumberNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private int state_;

        private CallSiteGetNumberNodeGen(JSContext context, JSBuiltin builtin, CallSitePrototype method, JavaScriptNode[] arguments) {
            super(context, builtin, method);
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
            if (state != 0 /* is-active getNumber(DynamicObject) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                return getNumber(arguments0Value__);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public int executeInt(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if (state != 0 /* is-active getNumber(DynamicObject) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                return getNumber(arguments0Value__);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            executeInt(frameValue);
            return;
        }

        private int executeAndSpecialize(Object arguments0Value) {
            int state = state_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                this.state_ = state = state | 0b1 /* add-active getNumber(DynamicObject) */;
                return getNumber(arguments0Value_);
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
            s[0] = "getNumber";
            if (state != 0 /* is-active getNumber(DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static CallSiteGetNumberNode create(JSContext context, JSBuiltin builtin, CallSitePrototype method, JavaScriptNode[] arguments) {
            return new CallSiteGetNumberNodeGen(context, builtin, method, arguments);
        }

    }
    @GeneratedBy(CallSiteGetNode.class)
    static final class CallSiteGetNodeGen extends CallSiteGetNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private int state_;

        private CallSiteGetNodeGen(JSContext context, JSBuiltin builtin, CallSitePrototype method, JavaScriptNode[] arguments) {
            super(context, builtin, method);
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
            if (state != 0 /* is-active callSiteGet(DynamicObject) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                return callSiteGet(arguments0Value__);
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
                this.state_ = state = state | 0b1 /* add-active callSiteGet(DynamicObject) */;
                return callSiteGet(arguments0Value_);
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
            s[0] = "callSiteGet";
            if (state != 0 /* is-active callSiteGet(DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static CallSiteGetNode create(JSContext context, JSBuiltin builtin, CallSitePrototype method, JavaScriptNode[] arguments) {
            return new CallSiteGetNodeGen(context, builtin, method, arguments);
        }

    }
    @GeneratedBy(CallSiteGetBooleanNode.class)
    static final class CallSiteGetBooleanNodeGen extends CallSiteGetBooleanNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private int state_;

        private CallSiteGetBooleanNodeGen(JSContext context, JSBuiltin builtin, CallSitePrototype method, JavaScriptNode[] arguments) {
            super(context, builtin, method);
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
            if (state != 0 /* is-active getBoolean(DynamicObject) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                return getBoolean(arguments0Value__);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if (state != 0 /* is-active getBoolean(DynamicObject) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                return getBoolean(arguments0Value__);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            executeBoolean(frameValue);
            return;
        }

        private boolean executeAndSpecialize(Object arguments0Value) {
            int state = state_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                this.state_ = state = state | 0b1 /* add-active getBoolean(DynamicObject) */;
                return getBoolean(arguments0Value_);
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
            s[0] = "getBoolean";
            if (state != 0 /* is-active getBoolean(DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static CallSiteGetBooleanNode create(JSContext context, JSBuiltin builtin, CallSitePrototype method, JavaScriptNode[] arguments) {
            return new CallSiteGetBooleanNodeGen(context, builtin, method, arguments);
        }

    }
}
