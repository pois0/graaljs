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
import com.oracle.truffle.js.builtins.ErrorPrototypeBuiltins.ErrorPrototypeGetStackTraceNode;
import com.oracle.truffle.js.builtins.ErrorPrototypeBuiltins.ErrorPrototypeToStringNode;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSContext;

@GeneratedBy(ErrorPrototypeBuiltins.class)
public final class ErrorPrototypeBuiltinsFactory {

    @GeneratedBy(ErrorPrototypeToStringNode.class)
    public static final class ErrorPrototypeToStringNodeGen extends ErrorPrototypeToStringNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private int state_;

        private ErrorPrototypeToStringNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state & 0b1) != 0 /* is-active toStringNonObject(Object) */) {
                if ((!(JSGuards.isJSObject(arguments0Value_)))) {
                    return toStringNonObject(arguments0Value_);
                }
            }
            if ((state & 0b10) != 0 /* is-active toStringObject(DynamicObject) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((JSGuards.isJSObject(arguments0Value__))) {
                    return toStringObject(arguments0Value__);
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
            if ((!(JSGuards.isJSObject(arguments0Value)))) {
                this.state_ = state = state | 0b1 /* add-active toStringNonObject(Object) */;
                return toStringNonObject(arguments0Value);
            }
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((JSGuards.isJSObject(arguments0Value_))) {
                    this.state_ = state = state | 0b10 /* add-active toStringObject(DynamicObject) */;
                    return toStringObject(arguments0Value_);
                }
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
            s[0] = "toStringNonObject";
            if ((state & 0b1) != 0 /* is-active toStringNonObject(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "toStringObject";
            if ((state & 0b10) != 0 /* is-active toStringObject(DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static ErrorPrototypeToStringNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ErrorPrototypeToStringNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ErrorPrototypeGetStackTraceNode.class)
    public static final class ErrorPrototypeGetStackTraceNodeGen extends ErrorPrototypeGetStackTraceNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private int state_;

        private ErrorPrototypeGetStackTraceNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state & 0b1) != 0 /* is-active getStackTrace(Object) */) {
                if ((!(JSGuards.isJSObject(arguments0Value_)))) {
                    return getStackTrace(arguments0Value_);
                }
            }
            if ((state & 0b10) != 0 /* is-active getStackTrace(DynamicObject) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((JSGuards.isJSObject(arguments0Value__))) {
                    return getStackTrace(arguments0Value__);
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
            if ((!(JSGuards.isJSObject(arguments0Value)))) {
                this.state_ = state = state | 0b1 /* add-active getStackTrace(Object) */;
                return getStackTrace(arguments0Value);
            }
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((JSGuards.isJSObject(arguments0Value_))) {
                    this.state_ = state = state | 0b10 /* add-active getStackTrace(DynamicObject) */;
                    return getStackTrace(arguments0Value_);
                }
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
            s[0] = "getStackTrace";
            if ((state & 0b1) != 0 /* is-active getStackTrace(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "getStackTrace";
            if ((state & 0b10) != 0 /* is-active getStackTrace(DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static ErrorPrototypeGetStackTraceNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ErrorPrototypeGetStackTraceNodeGen(context, builtin, arguments);
        }

    }
}
