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

@GeneratedBy(Atan2Node.class)
public final class Atan2NodeGen extends Atan2Node implements Provider {

    @Child private JavaScriptNode arguments0_;
    @Child private JavaScriptNode arguments1_;
    @CompilationFinal private int state_;

    private Atan2NodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
        if ((state & 0b10) == 0 /* only-active atan2Double(double, double) */ && (state & 0b11) != 0  /* is-not atan2Double(double, double) && atan2Generic(Object, Object) */) {
            return execute_double_double0(frameValue, state);
        } else {
            return execute_generic1(frameValue, state);
        }
    }

    private Object execute_double_double0(VirtualFrame frameValue, int state) {
        int arguments0Value_int = 0;
        long arguments0Value_long = 0L;
        double arguments0Value_;
        try {
            if ((state & 0b111000) == 0 /* only-active 0:double */ && (state & 0b11) != 0  /* is-not atan2Double(double, double) && atan2Generic(Object, Object) */) {
                arguments0Value_long = this.arguments0_.executeLong(frameValue);
                arguments0Value_ = JSTypes.longToDouble(arguments0Value_long);
            } else if ((state & 0b110100) == 0 /* only-active 0:double */ && (state & 0b11) != 0  /* is-not atan2Double(double, double) && atan2Generic(Object, Object) */) {
                arguments0Value_int = this.arguments0_.executeInt(frameValue);
                arguments0Value_ = JSTypes.intToDouble(arguments0Value_int);
            } else if ((state & 0b101100) == 0 /* only-active 0:double */ && (state & 0b11) != 0  /* is-not atan2Double(double, double) && atan2Generic(Object, Object) */) {
                arguments0Value_ = this.arguments0_.executeDouble(frameValue);
            } else {
                Object arguments0Value__ = this.arguments0_.execute(frameValue);
                arguments0Value_ = JSTypesGen.expectImplicitDouble((state & 0b111100) >>> 2 /* extract-implicit-active 0:double */, arguments0Value__);
            }
        } catch (UnexpectedResultException ex) {
            Object arguments1Value = this.arguments1_.execute(frameValue);
            return executeAndSpecialize(ex.getResult(), arguments1Value);
        }
        int arguments1Value_int = 0;
        long arguments1Value_long = 0L;
        double arguments1Value_;
        try {
            if ((state & 0b1110000000) == 0 /* only-active 1:double */ && (state & 0b11) != 0  /* is-not atan2Double(double, double) && atan2Generic(Object, Object) */) {
                arguments1Value_long = this.arguments1_.executeLong(frameValue);
                arguments1Value_ = JSTypes.longToDouble(arguments1Value_long);
            } else if ((state & 0b1101000000) == 0 /* only-active 1:double */ && (state & 0b11) != 0  /* is-not atan2Double(double, double) && atan2Generic(Object, Object) */) {
                arguments1Value_int = this.arguments1_.executeInt(frameValue);
                arguments1Value_ = JSTypes.intToDouble(arguments1Value_int);
            } else if ((state & 0b1011000000) == 0 /* only-active 1:double */ && (state & 0b11) != 0  /* is-not atan2Double(double, double) && atan2Generic(Object, Object) */) {
                arguments1Value_ = this.arguments1_.executeDouble(frameValue);
            } else {
                Object arguments1Value__ = this.arguments1_.execute(frameValue);
                arguments1Value_ = JSTypesGen.expectImplicitDouble((state & 0b1111000000) >>> 6 /* extract-implicit-active 1:double */, arguments1Value__);
            }
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(((state & 0b111000) == 0 /* only-active 0:double */ && (state & 0b11) != 0  /* is-not atan2Double(double, double) && atan2Generic(Object, Object) */ ? (Object) arguments0Value_long : ((state & 0b110100) == 0 /* only-active 0:double */ && (state & 0b11) != 0  /* is-not atan2Double(double, double) && atan2Generic(Object, Object) */ ? (Object) arguments0Value_int : (Object) arguments0Value_)), ex.getResult());
        }
        assert (state & 0b1) != 0 /* is-active atan2Double(double, double) */;
        return Atan2Node.atan2Double(arguments0Value_, arguments1Value_);
    }

    private Object execute_generic1(VirtualFrame frameValue, int state) {
        Object arguments0Value_ = this.arguments0_.execute(frameValue);
        Object arguments1Value_ = this.arguments1_.execute(frameValue);
        if ((state & 0b1) != 0 /* is-active atan2Double(double, double) */ && JSTypesGen.isImplicitDouble((state & 0b111100) >>> 2 /* extract-implicit-active 0:double */, arguments0Value_)) {
            double arguments0Value__ = JSTypesGen.asImplicitDouble((state & 0b111100) >>> 2 /* extract-implicit-active 0:double */, arguments0Value_);
            if (JSTypesGen.isImplicitDouble((state & 0b1111000000) >>> 6 /* extract-implicit-active 1:double */, arguments1Value_)) {
                double arguments1Value__ = JSTypesGen.asImplicitDouble((state & 0b1111000000) >>> 6 /* extract-implicit-active 1:double */, arguments1Value_);
                return Atan2Node.atan2Double(arguments0Value__, arguments1Value__);
            }
        }
        if ((state & 0b10) != 0 /* is-active atan2Generic(Object, Object) */) {
            return atan2Generic(arguments0Value_, arguments1Value_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arguments0Value_, arguments1Value_);
    }

    @Override
    public double executeDouble(VirtualFrame frameValue) {
        int state = state_;
        if ((state & 0b10) == 0 /* only-active atan2Double(double, double) */ && (state & 0b11) != 0  /* is-not atan2Double(double, double) && atan2Generic(Object, Object) */) {
            return executeDouble_double_double2(frameValue, state);
        } else {
            return executeDouble_generic3(frameValue, state);
        }
    }

    private double executeDouble_double_double2(VirtualFrame frameValue, int state) {
        int arguments0Value_int = 0;
        long arguments0Value_long = 0L;
        double arguments0Value_;
        try {
            if ((state & 0b111000) == 0 /* only-active 0:double */ && (state & 0b11) != 0  /* is-not atan2Double(double, double) && atan2Generic(Object, Object) */) {
                arguments0Value_long = this.arguments0_.executeLong(frameValue);
                arguments0Value_ = JSTypes.longToDouble(arguments0Value_long);
            } else if ((state & 0b110100) == 0 /* only-active 0:double */ && (state & 0b11) != 0  /* is-not atan2Double(double, double) && atan2Generic(Object, Object) */) {
                arguments0Value_int = this.arguments0_.executeInt(frameValue);
                arguments0Value_ = JSTypes.intToDouble(arguments0Value_int);
            } else if ((state & 0b101100) == 0 /* only-active 0:double */ && (state & 0b11) != 0  /* is-not atan2Double(double, double) && atan2Generic(Object, Object) */) {
                arguments0Value_ = this.arguments0_.executeDouble(frameValue);
            } else {
                Object arguments0Value__ = this.arguments0_.execute(frameValue);
                arguments0Value_ = JSTypesGen.expectImplicitDouble((state & 0b111100) >>> 2 /* extract-implicit-active 0:double */, arguments0Value__);
            }
        } catch (UnexpectedResultException ex) {
            Object arguments1Value = this.arguments1_.execute(frameValue);
            return executeAndSpecialize(ex.getResult(), arguments1Value);
        }
        int arguments1Value_int = 0;
        long arguments1Value_long = 0L;
        double arguments1Value_;
        try {
            if ((state & 0b1110000000) == 0 /* only-active 1:double */ && (state & 0b11) != 0  /* is-not atan2Double(double, double) && atan2Generic(Object, Object) */) {
                arguments1Value_long = this.arguments1_.executeLong(frameValue);
                arguments1Value_ = JSTypes.longToDouble(arguments1Value_long);
            } else if ((state & 0b1101000000) == 0 /* only-active 1:double */ && (state & 0b11) != 0  /* is-not atan2Double(double, double) && atan2Generic(Object, Object) */) {
                arguments1Value_int = this.arguments1_.executeInt(frameValue);
                arguments1Value_ = JSTypes.intToDouble(arguments1Value_int);
            } else if ((state & 0b1011000000) == 0 /* only-active 1:double */ && (state & 0b11) != 0  /* is-not atan2Double(double, double) && atan2Generic(Object, Object) */) {
                arguments1Value_ = this.arguments1_.executeDouble(frameValue);
            } else {
                Object arguments1Value__ = this.arguments1_.execute(frameValue);
                arguments1Value_ = JSTypesGen.expectImplicitDouble((state & 0b1111000000) >>> 6 /* extract-implicit-active 1:double */, arguments1Value__);
            }
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(((state & 0b111000) == 0 /* only-active 0:double */ && (state & 0b11) != 0  /* is-not atan2Double(double, double) && atan2Generic(Object, Object) */ ? (Object) arguments0Value_long : ((state & 0b110100) == 0 /* only-active 0:double */ && (state & 0b11) != 0  /* is-not atan2Double(double, double) && atan2Generic(Object, Object) */ ? (Object) arguments0Value_int : (Object) arguments0Value_)), ex.getResult());
        }
        assert (state & 0b1) != 0 /* is-active atan2Double(double, double) */;
        return Atan2Node.atan2Double(arguments0Value_, arguments1Value_);
    }

    private double executeDouble_generic3(VirtualFrame frameValue, int state) {
        Object arguments0Value_ = this.arguments0_.execute(frameValue);
        Object arguments1Value_ = this.arguments1_.execute(frameValue);
        if ((state & 0b1) != 0 /* is-active atan2Double(double, double) */ && JSTypesGen.isImplicitDouble((state & 0b111100) >>> 2 /* extract-implicit-active 0:double */, arguments0Value_)) {
            double arguments0Value__ = JSTypesGen.asImplicitDouble((state & 0b111100) >>> 2 /* extract-implicit-active 0:double */, arguments0Value_);
            if (JSTypesGen.isImplicitDouble((state & 0b1111000000) >>> 6 /* extract-implicit-active 1:double */, arguments1Value_)) {
                double arguments1Value__ = JSTypesGen.asImplicitDouble((state & 0b1111000000) >>> 6 /* extract-implicit-active 1:double */, arguments1Value_);
                return Atan2Node.atan2Double(arguments0Value__, arguments1Value__);
            }
        }
        if ((state & 0b10) != 0 /* is-active atan2Generic(Object, Object) */) {
            return atan2Generic(arguments0Value_, arguments1Value_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arguments0Value_, arguments1Value_);
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        executeDouble(frameValue);
        return;
    }

    private double executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
        int state = state_;
        {
            int doubleCast0;
            if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(arguments0Value)) != 0) {
                double arguments0Value_ = JSTypesGen.asImplicitDouble(doubleCast0, arguments0Value);
                int doubleCast1;
                if ((doubleCast1 = JSTypesGen.specializeImplicitDouble(arguments1Value)) != 0) {
                    double arguments1Value_ = JSTypesGen.asImplicitDouble(doubleCast1, arguments1Value);
                    state = (state | (doubleCast0 << 2) /* set-implicit-active 0:double */);
                    state = (state | (doubleCast1 << 6) /* set-implicit-active 1:double */);
                    this.state_ = state = state | 0b1 /* add-active atan2Double(double, double) */;
                    return Atan2Node.atan2Double(arguments0Value_, arguments1Value_);
                }
            }
        }
        this.state_ = state = state | 0b10 /* add-active atan2Generic(Object, Object) */;
        return atan2Generic(arguments0Value, arguments1Value);
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
        s[0] = "atan2Double";
        if ((state & 0b1) != 0 /* is-active atan2Double(double, double) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "atan2Generic";
        if ((state & 0b10) != 0 /* is-active atan2Generic(Object, Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        return Provider.create(data);
    }

    public static Atan2Node create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
        return new Atan2NodeGen(context, builtin, arguments);
    }

}
