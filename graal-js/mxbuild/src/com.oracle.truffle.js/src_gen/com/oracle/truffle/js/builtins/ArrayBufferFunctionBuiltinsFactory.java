// CheckStyle: start generated
package com.oracle.truffle.js.builtins;

import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.js.builtins.ArrayBufferFunctionBuiltins.JSIsArrayBufferViewNode;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSContext;

@GeneratedBy(ArrayBufferFunctionBuiltins.class)
public final class ArrayBufferFunctionBuiltinsFactory {

    @GeneratedBy(JSIsArrayBufferViewNode.class)
    public static final class JSIsArrayBufferViewNodeGen extends JSIsArrayBufferViewNode implements Provider {

        @Child private JavaScriptNode arguments0_;

        private JSIsArrayBufferViewNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            return isArrayBufferView(arguments0Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return isArrayBufferView(arguments0Value_);
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
            s[0] = "isArrayBufferView";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSIsArrayBufferViewNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSIsArrayBufferViewNodeGen(context, builtin, arguments);
        }

    }
}
