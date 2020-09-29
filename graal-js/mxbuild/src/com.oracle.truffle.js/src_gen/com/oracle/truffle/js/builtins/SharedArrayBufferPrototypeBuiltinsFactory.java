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
import com.oracle.truffle.js.builtins.SharedArrayBufferPrototypeBuiltins.JSSharedArrayBufferSliceNode;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSContext;

@GeneratedBy(SharedArrayBufferPrototypeBuiltins.class)
public final class SharedArrayBufferPrototypeBuiltinsFactory {

    @GeneratedBy(JSSharedArrayBufferSliceNode.class)
    public static final class JSSharedArrayBufferSliceNodeGen extends JSSharedArrayBufferSliceNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private int state_;

        private JSSharedArrayBufferSliceNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state & 0b101) == 0 /* only-active sliceSharedDirect(DynamicObject, int, int) */ && state != 0  /* is-not error(Object, Object, Object) && sliceSharedDirect(DynamicObject, int, int) && sliceSharedDirect(DynamicObject, Object, Object) */) {
                return execute_int_int0(frameValue, state);
            } else {
                return execute_generic1(frameValue, state);
            }
        }

        private Object execute_int_int0(VirtualFrame frameValue, int state) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            int arguments1Value_;
            try {
                arguments1Value_ = this.arguments1_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                Object arguments2Value = this.arguments2_.execute(frameValue);
                return executeAndSpecialize(arguments0Value_, ex.getResult(), arguments2Value);
            }
            int arguments2Value_;
            try {
                arguments2Value_ = this.arguments2_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(arguments0Value_, arguments1Value_, ex.getResult());
            }
            assert (state & 0b10) != 0 /* is-active sliceSharedDirect(DynamicObject, int, int) */;
            if (JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((JSGuards.isJSSharedArrayBuffer(arguments0Value__))) {
                    return sliceSharedDirect(arguments0Value__, arguments1Value_, arguments2Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        private Object execute_generic1(VirtualFrame frameValue, int state) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if ((state & 0b1) != 0 /* is-active error(Object, Object, Object) */) {
                if ((!(JSGuards.isJSSharedArrayBuffer(arguments0Value_)))) {
                    return JSSharedArrayBufferSliceNode.error(arguments0Value_, arguments1Value_, arguments2Value_);
                }
            }
            if ((state & 0b110) != 0 /* is-active sliceSharedDirect(DynamicObject, int, int) || sliceSharedDirect(DynamicObject, Object, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state & 0b10) != 0 /* is-active sliceSharedDirect(DynamicObject, int, int) */ && arguments1Value_ instanceof Integer) {
                    int arguments1Value__ = (int) arguments1Value_;
                    if (arguments2Value_ instanceof Integer) {
                        int arguments2Value__ = (int) arguments2Value_;
                        if ((JSGuards.isJSSharedArrayBuffer(arguments0Value__))) {
                            return sliceSharedDirect(arguments0Value__, arguments1Value__, arguments2Value__);
                        }
                    }
                }
                if ((state & 0b100) != 0 /* is-active sliceSharedDirect(DynamicObject, Object, Object) */) {
                    if ((JSGuards.isJSSharedArrayBuffer(arguments0Value__))) {
                        return sliceSharedDirect(arguments0Value__, arguments1Value_, arguments2Value_);
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
            if ((!(JSGuards.isJSSharedArrayBuffer(arguments0Value)))) {
                this.state_ = state = state | 0b1 /* add-active error(Object, Object, Object) */;
                return JSSharedArrayBufferSliceNode.error(arguments0Value, arguments1Value, arguments2Value);
            }
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if (arguments1Value instanceof Integer) {
                    int arguments1Value_ = (int) arguments1Value;
                    if (arguments2Value instanceof Integer) {
                        int arguments2Value_ = (int) arguments2Value;
                        if ((JSGuards.isJSSharedArrayBuffer(arguments0Value_))) {
                            this.state_ = state = state | 0b10 /* add-active sliceSharedDirect(DynamicObject, int, int) */;
                            return sliceSharedDirect(arguments0Value_, arguments1Value_, arguments2Value_);
                        }
                    }
                }
                if ((JSGuards.isJSSharedArrayBuffer(arguments0Value_))) {
                    this.state_ = state = state | 0b100 /* add-active sliceSharedDirect(DynamicObject, Object, Object) */;
                    return sliceSharedDirect(arguments0Value_, arguments1Value, arguments2Value);
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
            s[0] = "error";
            if ((state & 0b1) != 0 /* is-active error(Object, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "sliceSharedDirect";
            if ((state & 0b10) != 0 /* is-active sliceSharedDirect(DynamicObject, int, int) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "sliceSharedDirect";
            if ((state & 0b100) != 0 /* is-active sliceSharedDirect(DynamicObject, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static JSSharedArrayBufferSliceNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSSharedArrayBufferSliceNodeGen(context, builtin, arguments);
        }

    }
}
