// CheckStyle: start generated
package com.oracle.truffle.js.builtins.commonjs;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSContext;

@GeneratedBy(CommonJSResolveBuiltin.class)
public final class CommonJSResolveBuiltinNodeGen extends CommonJSResolveBuiltin implements Provider {

    @Child private JavaScriptNode arguments0_;
    @CompilationFinal private int state_;

    private CommonJSResolveBuiltinNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
        if ((state & 0b1) != 0 /* is-active resolve(String) */ && JSTypesGen.isImplicitString((state & 0b11110) >>> 1 /* extract-implicit-active 0:String */, arguments0Value_)) {
            String arguments0Value__ = JSTypesGen.asImplicitString((state & 0b11110) >>> 1 /* extract-implicit-active 0:String */, arguments0Value_);
            return resolve(arguments0Value__);
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
        {
            int stringCast0;
            if ((stringCast0 = JSTypesGen.specializeImplicitString(arguments0Value)) != 0) {
                String arguments0Value_ = JSTypesGen.asImplicitString(stringCast0, arguments0Value);
                state = (state | (stringCast0 << 1) /* set-implicit-active 0:String */);
                this.state_ = state = state | 0b1 /* add-active resolve(String) */;
                return resolve(arguments0Value_);
            }
        }
        throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_}, arguments0Value);
    }

    @Override
    public NodeCost getCost() {
        int state = state_;
        if ((state & 0b1) == 0b0) {
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
        s[0] = "resolve";
        if ((state & 0b1) != 0 /* is-active resolve(String) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        return Provider.create(data);
    }

    public static CommonJSResolveBuiltin create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
        return new CommonJSResolveBuiltinNodeGen(context, builtin, arguments);
    }

}
