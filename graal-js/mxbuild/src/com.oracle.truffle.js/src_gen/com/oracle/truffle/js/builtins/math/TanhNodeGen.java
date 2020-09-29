// CheckStyle: start generated
package com.oracle.truffle.js.builtins.math;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSContext;

@GeneratedBy(TanhNode.class)
public final class TanhNodeGen extends TanhNode implements Provider {

    @Child private JavaScriptNode arguments0_;
    @CompilationFinal private int state_;

    private TanhNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
        if ((state & 0b10) == 0 /* only-active tanh(double) */ && (state & 0b11) != 0  /* is-not tanh(double) && tanh(Object) */) {
            return execute_double0(frameValue, state);
        } else {
            return execute_generic1(frameValue, state);
        }
    }

    private Object execute_double0(VirtualFrame frameValue, int state) {
        int arguments0Value_int = 0;
        long arguments0Value_long = 0L;
        double arguments0Value_;
        try {
            if ((state & 0b111000) == 0 /* only-active 0:double */ && (state & 0b11) != 0  /* is-not tanh(double) && tanh(Object) */) {
                arguments0Value_long = this.arguments0_.executeLong(frameValue);
                arguments0Value_ = JSTypes.longToDouble(arguments0Value_long);
            } else if ((state & 0b110100) == 0 /* only-active 0:double */ && (state & 0b11) != 0  /* is-not tanh(double) && tanh(Object) */) {
                arguments0Value_int = this.arguments0_.executeInt(frameValue);
                arguments0Value_ = JSTypes.intToDouble(arguments0Value_int);
            } else if ((state & 0b101100) == 0 /* only-active 0:double */ && (state & 0b11) != 0  /* is-not tanh(double) && tanh(Object) */) {
                arguments0Value_ = this.arguments0_.executeDouble(frameValue);
            } else {
                Object arguments0Value__ = this.arguments0_.execute(frameValue);
                arguments0Value_ = JSTypesGen.expectImplicitDouble((state & 0b111100) >>> 2 /* extract-implicit-active 0:double */, arguments0Value__);
            }
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(ex.getResult());
        }
        assert (state & 0b1) != 0 /* is-active tanh(double) */;
        return tanh(arguments0Value_);
    }

    private Object execute_generic1(VirtualFrame frameValue, int state) {
        Object arguments0Value_ = this.arguments0_.execute(frameValue);
        if ((state & 0b1) != 0 /* is-active tanh(double) */ && JSTypesGen.isImplicitDouble((state & 0b111100) >>> 2 /* extract-implicit-active 0:double */, arguments0Value_)) {
            double arguments0Value__ = JSTypesGen.asImplicitDouble((state & 0b111100) >>> 2 /* extract-implicit-active 0:double */, arguments0Value_);
            return tanh(arguments0Value__);
        }
        if ((state & 0b10) != 0 /* is-active tanh(Object) */) {
            return tanh(arguments0Value_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arguments0Value_);
    }

    @Override
    public double executeDouble(VirtualFrame frameValue) {
        int state = state_;
        if ((state & 0b10) == 0 /* only-active tanh(double) */ && (state & 0b11) != 0  /* is-not tanh(double) && tanh(Object) */) {
            return executeDouble_double2(frameValue, state);
        } else {
            return executeDouble_generic3(frameValue, state);
        }
    }

    private double executeDouble_double2(VirtualFrame frameValue, int state) {
        int arguments0Value_int = 0;
        long arguments0Value_long = 0L;
        double arguments0Value_;
        try {
            if ((state & 0b111000) == 0 /* only-active 0:double */ && (state & 0b11) != 0  /* is-not tanh(double) && tanh(Object) */) {
                arguments0Value_long = this.arguments0_.executeLong(frameValue);
                arguments0Value_ = JSTypes.longToDouble(arguments0Value_long);
            } else if ((state & 0b110100) == 0 /* only-active 0:double */ && (state & 0b11) != 0  /* is-not tanh(double) && tanh(Object) */) {
                arguments0Value_int = this.arguments0_.executeInt(frameValue);
                arguments0Value_ = JSTypes.intToDouble(arguments0Value_int);
            } else if ((state & 0b101100) == 0 /* only-active 0:double */ && (state & 0b11) != 0  /* is-not tanh(double) && tanh(Object) */) {
                arguments0Value_ = this.arguments0_.executeDouble(frameValue);
            } else {
                Object arguments0Value__ = this.arguments0_.execute(frameValue);
                arguments0Value_ = JSTypesGen.expectImplicitDouble((state & 0b111100) >>> 2 /* extract-implicit-active 0:double */, arguments0Value__);
            }
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(ex.getResult());
        }
        assert (state & 0b1) != 0 /* is-active tanh(double) */;
        return tanh(arguments0Value_);
    }

    private double executeDouble_generic3(VirtualFrame frameValue, int state) {
        Object arguments0Value_ = this.arguments0_.execute(frameValue);
        if ((state & 0b1) != 0 /* is-active tanh(double) */ && JSTypesGen.isImplicitDouble((state & 0b111100) >>> 2 /* extract-implicit-active 0:double */, arguments0Value_)) {
            double arguments0Value__ = JSTypesGen.asImplicitDouble((state & 0b111100) >>> 2 /* extract-implicit-active 0:double */, arguments0Value_);
            return tanh(arguments0Value__);
        }
        if ((state & 0b10) != 0 /* is-active tanh(Object) */) {
            return tanh(arguments0Value_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arguments0Value_);
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        executeDouble(frameValue);
        return;
    }

    private double executeAndSpecialize(Object arguments0Value) {
        int state = state_;
        {
            int doubleCast0;
            if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(arguments0Value)) != 0) {
                double arguments0Value_ = JSTypesGen.asImplicitDouble(doubleCast0, arguments0Value);
                state = (state | (doubleCast0 << 2) /* set-implicit-active 0:double */);
                this.state_ = state = state | 0b1 /* add-active tanh(double) */;
                return tanh(arguments0Value_);
            }
        }
        this.state_ = state = state | 0b10 /* add-active tanh(Object) */;
        return tanh(arguments0Value);
    }

    @Override
    public NodeCost getCost() {
        int state = state_;
        if ((state & 0b11) == 0b0) {
            return NodeCost.UNINITIALIZED;
        } else if (((state & 0b11) & ((state & 0b11) - 1)) == 0 /* is-single-active  */) {
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
        s[0] = "tanh";
        if ((state & 0b1) != 0 /* is-active tanh(double) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "tanh";
        if ((state & 0b10) != 0 /* is-active tanh(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        return Provider.create(data);
    }

    public static TanhNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
        return new TanhNodeGen(context, builtin, arguments);
    }

}
