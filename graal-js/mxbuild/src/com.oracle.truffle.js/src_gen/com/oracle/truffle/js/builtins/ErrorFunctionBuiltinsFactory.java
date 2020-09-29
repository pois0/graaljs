// CheckStyle: start generated
package com.oracle.truffle.js.builtins;

import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.js.builtins.ErrorFunctionBuiltins.ErrorCaptureStackTraceNode;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSContext;

@GeneratedBy(ErrorFunctionBuiltins.class)
public final class ErrorFunctionBuiltinsFactory {

    @GeneratedBy(ErrorCaptureStackTraceNode.class)
    public static final class ErrorCaptureStackTraceNodeGen extends ErrorCaptureStackTraceNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;

        private ErrorCaptureStackTraceNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            return captureStackTrace(frameValue, arguments0Value_, arguments1Value_);
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
            s[0] = "captureStackTrace";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static ErrorCaptureStackTraceNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ErrorCaptureStackTraceNodeGen(context, builtin, arguments);
        }

    }
}
