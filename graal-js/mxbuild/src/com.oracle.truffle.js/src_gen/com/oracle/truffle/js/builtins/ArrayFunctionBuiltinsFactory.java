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
import com.oracle.truffle.js.builtins.ArrayFunctionBuiltins.JSArrayFromNode;
import com.oracle.truffle.js.builtins.ArrayFunctionBuiltins.JSArrayOfNode;
import com.oracle.truffle.js.builtins.ArrayFunctionBuiltins.JSIsArrayNode;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSContext;

@GeneratedBy(ArrayFunctionBuiltins.class)
public final class ArrayFunctionBuiltinsFactory {

    @GeneratedBy(JSIsArrayNode.class)
    public static final class JSIsArrayNodeGen extends JSIsArrayNode implements Provider {

        @Child private JavaScriptNode arguments0_;

        private JSIsArrayNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            return isArray(arguments0Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return isArray(arguments0Value_);
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
            s[0] = "isArray";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSIsArrayNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSIsArrayNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSArrayOfNode.class)
    public static final class JSArrayOfNodeGen extends JSArrayOfNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private int state_;

        private JSArrayOfNodeGen(JSContext context, JSBuiltin builtin, boolean isTypedArray, JavaScriptNode[] arguments) {
            super(context, builtin, isTypedArray);
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
            if (state != 0 /* is-active arrayOf(Object, Object[]) */ && arguments1Value_ instanceof Object[]) {
                Object[] arguments1Value__ = (Object[]) arguments1Value_;
                return arrayOf(arguments0Value_, arguments1Value__);
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
            if (arguments1Value instanceof Object[]) {
                Object[] arguments1Value_ = (Object[]) arguments1Value;
                this.state_ = state = state | 0b1 /* add-active arrayOf(Object, Object[]) */;
                return arrayOf(arguments0Value, arguments1Value_);
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
            s[0] = "arrayOf";
            if (state != 0 /* is-active arrayOf(Object, Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static JSArrayOfNode create(JSContext context, JSBuiltin builtin, boolean isTypedArray, JavaScriptNode[] arguments) {
            return new JSArrayOfNodeGen(context, builtin, isTypedArray, arguments);
        }

    }
    @GeneratedBy(JSArrayFromNode.class)
    public static final class JSArrayFromNodeGen extends JSArrayFromNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private int state_;

        private JSArrayFromNodeGen(JSContext context, JSBuiltin builtin, boolean isTypedArray, JavaScriptNode[] arguments) {
            super(context, builtin, isTypedArray);
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
            if (state != 0 /* is-active arrayFrom(Object, Object[]) */ && arguments1Value_ instanceof Object[]) {
                Object[] arguments1Value__ = (Object[]) arguments1Value_;
                return arrayFrom(arguments0Value_, arguments1Value__);
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
            if (arguments1Value instanceof Object[]) {
                Object[] arguments1Value_ = (Object[]) arguments1Value;
                this.state_ = state = state | 0b1 /* add-active arrayFrom(Object, Object[]) */;
                return arrayFrom(arguments0Value, arguments1Value_);
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
            s[0] = "arrayFrom";
            if (state != 0 /* is-active arrayFrom(Object, Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static JSArrayFromNode create(JSContext context, JSBuiltin builtin, boolean isTypedArray, JavaScriptNode[] arguments) {
            return new JSArrayFromNodeGen(context, builtin, isTypedArray, arguments);
        }

    }
}
