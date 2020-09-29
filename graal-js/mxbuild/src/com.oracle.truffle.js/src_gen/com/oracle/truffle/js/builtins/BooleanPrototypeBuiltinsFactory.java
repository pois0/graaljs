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
import com.oracle.truffle.js.builtins.BooleanPrototypeBuiltins.JSBooleanToStringNode;
import com.oracle.truffle.js.builtins.BooleanPrototypeBuiltins.JSBooleanValueOfNode;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSContext;

@GeneratedBy(BooleanPrototypeBuiltins.class)
public final class BooleanPrototypeBuiltinsFactory {

    @GeneratedBy(JSBooleanToStringNode.class)
    public static final class JSBooleanToStringNodeGen extends JSBooleanToStringNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private int state_;

        private JSBooleanToStringNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state & 0b1) != 0 /* is-active toString(Object) */) {
                if ((!(JSGuards.isJSBoolean(arguments0Value_))) && (!(JSGuards.isBoolean(arguments0Value_)))) {
                    return toString(arguments0Value_);
                }
            }
            if ((state & 0b10) != 0 /* is-active toString(DynamicObject) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((JSGuards.isJSBoolean(arguments0Value__))) {
                    return toString(arguments0Value__);
                }
            }
            if ((state & 0b100) != 0 /* is-active toStringPrimitive(Object) */) {
                if ((JSGuards.isBoolean(arguments0Value_))) {
                    return toStringPrimitive(arguments0Value_);
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
            int state = state_;
            if ((!(JSGuards.isJSBoolean(arguments0Value))) && (!(JSGuards.isBoolean(arguments0Value)))) {
                this.state_ = state = state | 0b1 /* add-active toString(Object) */;
                return toString(arguments0Value);
            }
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((JSGuards.isJSBoolean(arguments0Value_))) {
                    this.state_ = state = state | 0b10 /* add-active toString(DynamicObject) */;
                    return toString(arguments0Value_);
                }
            }
            if ((JSGuards.isBoolean(arguments0Value))) {
                this.state_ = state = state | 0b100 /* add-active toStringPrimitive(Object) */;
                return toStringPrimitive(arguments0Value);
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
            Object[] data = new Object[4];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "toString";
            if ((state & 0b1) != 0 /* is-active toString(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "toString";
            if ((state & 0b10) != 0 /* is-active toString(DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "toStringPrimitive";
            if ((state & 0b100) != 0 /* is-active toStringPrimitive(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static JSBooleanToStringNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSBooleanToStringNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSBooleanValueOfNode.class)
    public static final class JSBooleanValueOfNodeGen extends JSBooleanValueOfNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private int state_;

        private JSBooleanValueOfNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state & 0b1) != 0 /* is-active valueOf(Object) */) {
                if ((!(JSGuards.isJSBoolean(arguments0Value_))) && (!(JSGuards.isBoolean(arguments0Value_)))) {
                    return valueOf(arguments0Value_);
                }
            }
            if ((state & 0b10) != 0 /* is-active valueOf(DynamicObject) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((JSGuards.isJSBoolean(arguments0Value__))) {
                    return valueOf(arguments0Value__);
                }
            }
            if ((state & 0b100) != 0 /* is-active valueOfPrimitive(Object) */) {
                if ((JSGuards.isBoolean(arguments0Value_))) {
                    return valueOfPrimitive(arguments0Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state & 0b1) != 0 /* is-active valueOf(Object) */) {
                if ((!(JSGuards.isJSBoolean(arguments0Value_))) && (!(JSGuards.isBoolean(arguments0Value_)))) {
                    return valueOf(arguments0Value_);
                }
            }
            if ((state & 0b10) != 0 /* is-active valueOf(DynamicObject) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((JSGuards.isJSBoolean(arguments0Value__))) {
                    return valueOf(arguments0Value__);
                }
            }
            if ((state & 0b100) != 0 /* is-active valueOfPrimitive(Object) */) {
                if ((JSGuards.isBoolean(arguments0Value_))) {
                    return valueOfPrimitive(arguments0Value_);
                }
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
            if ((!(JSGuards.isJSBoolean(arguments0Value))) && (!(JSGuards.isBoolean(arguments0Value)))) {
                this.state_ = state = state | 0b1 /* add-active valueOf(Object) */;
                return valueOf(arguments0Value);
            }
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((JSGuards.isJSBoolean(arguments0Value_))) {
                    this.state_ = state = state | 0b10 /* add-active valueOf(DynamicObject) */;
                    return valueOf(arguments0Value_);
                }
            }
            if ((JSGuards.isBoolean(arguments0Value))) {
                this.state_ = state = state | 0b100 /* add-active valueOfPrimitive(Object) */;
                return valueOfPrimitive(arguments0Value);
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
            Object[] data = new Object[4];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "valueOf";
            if ((state & 0b1) != 0 /* is-active valueOf(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "valueOf";
            if ((state & 0b10) != 0 /* is-active valueOf(DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "valueOfPrimitive";
            if ((state & 0b100) != 0 /* is-active valueOfPrimitive(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static JSBooleanValueOfNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSBooleanValueOfNodeGen(context, builtin, arguments);
        }

    }
}
