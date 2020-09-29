// CheckStyle: start generated
package com.oracle.truffle.js.builtins.math;

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
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(RoundNode.class)
public final class RoundNodeGen extends RoundNode implements Provider {

    @Child private JavaScriptNode arguments0_;
    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private ConditionProfile roundDouble_profileA_;
    @CompilationFinal private ConditionProfile roundDouble_profileB_;

    private RoundNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
        if ((state & 0b1110) == 0 /* only-active roundInt(int) */ && (state & 0b1111) != 0  /* is-not roundInt(int) && roundCornercase(double) && roundDoubleInt(double) && roundDouble(double, ConditionProfile, ConditionProfile) */) {
            return execute_int0(frameValue, state);
        } else if ((state & 0b1) == 0 /* only-active roundCornercase(double) && roundDoubleInt(double) && roundDouble(double, ConditionProfile, ConditionProfile) */ && (state & 0b1111) != 0  /* is-not roundInt(int) && roundCornercase(double) && roundDoubleInt(double) && roundDouble(double, ConditionProfile, ConditionProfile) */) {
            return execute_double1(frameValue, state);
        } else {
            return execute_generic2(frameValue, state);
        }
    }

    private Object execute_int0(VirtualFrame frameValue, int state) {
        int arguments0Value_;
        try {
            arguments0Value_ = this.arguments0_.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(ex.getResult());
        }
        assert (state & 0b1) != 0 /* is-active roundInt(int) */;
        return RoundNode.roundInt(arguments0Value_);
    }

    private Object execute_double1(VirtualFrame frameValue, int state) {
        int arguments0Value_int = 0;
        long arguments0Value_long = 0L;
        double arguments0Value_;
        try {
            if ((state & 0b11100000) == 0 /* only-active 0:double */ && (state & 0b1111) != 0  /* is-not roundInt(int) && roundCornercase(double) && roundDoubleInt(double) && roundDouble(double, ConditionProfile, ConditionProfile) */) {
                arguments0Value_long = this.arguments0_.executeLong(frameValue);
                arguments0Value_ = JSTypes.longToDouble(arguments0Value_long);
            } else if ((state & 0b11010000) == 0 /* only-active 0:double */ && (state & 0b1111) != 0  /* is-not roundInt(int) && roundCornercase(double) && roundDoubleInt(double) && roundDouble(double, ConditionProfile, ConditionProfile) */) {
                arguments0Value_int = this.arguments0_.executeInt(frameValue);
                arguments0Value_ = JSTypes.intToDouble(arguments0Value_int);
            } else if ((state & 0b10110000) == 0 /* only-active 0:double */ && (state & 0b1111) != 0  /* is-not roundInt(int) && roundCornercase(double) && roundDoubleInt(double) && roundDouble(double, ConditionProfile, ConditionProfile) */) {
                arguments0Value_ = this.arguments0_.executeDouble(frameValue);
            } else {
                Object arguments0Value__ = this.arguments0_.execute(frameValue);
                arguments0Value_ = JSTypesGen.expectImplicitDouble((state & 0b11110000) >>> 4 /* extract-implicit-active 0:double */, arguments0Value__);
            }
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(ex.getResult());
        }
        if ((state & 0b10) != 0 /* is-active roundCornercase(double) */) {
            if ((RoundNode.isCornercase(arguments0Value_))) {
                return RoundNode.roundCornercase(arguments0Value_);
            }
        }
        if ((state & 0b100) != 0 /* is-active roundDoubleInt(double) */) {
            if ((!(RoundNode.isCornercase(arguments0Value_))) && (JSGuards.isDoubleInInt32Range(arguments0Value_))) {
                try {
                    return roundDoubleInt(arguments0Value_);
                } catch (ArithmeticException ex) {
                    // implicit transferToInterpreterAndInvalidate()
                    Lock lock = getLock();
                    lock.lock();
                    try {
                        this.exclude_ = this.exclude_ | 0b1 /* add-excluded roundDoubleInt(double) */;
                        this.state_ = this.state_ & 0xfffffffb /* remove-active roundDoubleInt(double) */;
                    } finally {
                        lock.unlock();
                    }
                    return executeAndSpecialize(arguments0Value_);
                }
            }
        }
        if ((state & 0b1000) != 0 /* is-active roundDouble(double, ConditionProfile, ConditionProfile) */) {
            if ((!(RoundNode.isCornercase(arguments0Value_)))) {
                return roundDouble(arguments0Value_, this.roundDouble_profileA_, this.roundDouble_profileB_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(((state & 0b11100000) == 0 /* only-active 0:double */ && (state & 0b1111) != 0  /* is-not roundInt(int) && roundCornercase(double) && roundDoubleInt(double) && roundDouble(double, ConditionProfile, ConditionProfile) */ ? (Object) arguments0Value_long : ((state & 0b11010000) == 0 /* only-active 0:double */ && (state & 0b1111) != 0  /* is-not roundInt(int) && roundCornercase(double) && roundDoubleInt(double) && roundDouble(double, ConditionProfile, ConditionProfile) */ ? (Object) arguments0Value_int : (Object) arguments0Value_)));
    }

    private Object execute_generic2(VirtualFrame frameValue, int state) {
        Object arguments0Value_ = this.arguments0_.execute(frameValue);
        if ((state & 0b1) != 0 /* is-active roundInt(int) */ && arguments0Value_ instanceof Integer) {
            int arguments0Value__ = (int) arguments0Value_;
            return RoundNode.roundInt(arguments0Value__);
        }
        if ((state & 0b1110) != 0 /* is-active roundCornercase(double) || roundDoubleInt(double) || roundDouble(double, ConditionProfile, ConditionProfile) */ && JSTypesGen.isImplicitDouble((state & 0b11110000) >>> 4 /* extract-implicit-active 0:double */, arguments0Value_)) {
            double arguments0Value__ = JSTypesGen.asImplicitDouble((state & 0b11110000) >>> 4 /* extract-implicit-active 0:double */, arguments0Value_);
            if ((state & 0b10) != 0 /* is-active roundCornercase(double) */) {
                if ((RoundNode.isCornercase(arguments0Value__))) {
                    return RoundNode.roundCornercase(arguments0Value__);
                }
            }
            if ((state & 0b100) != 0 /* is-active roundDoubleInt(double) */) {
                if ((!(RoundNode.isCornercase(arguments0Value__))) && (JSGuards.isDoubleInInt32Range(arguments0Value__))) {
                    try {
                        return roundDoubleInt(arguments0Value__);
                    } catch (ArithmeticException ex) {
                        // implicit transferToInterpreterAndInvalidate()
                        Lock lock = getLock();
                        lock.lock();
                        try {
                            this.exclude_ = this.exclude_ | 0b1 /* add-excluded roundDoubleInt(double) */;
                            this.state_ = this.state_ & 0xfffffffb /* remove-active roundDoubleInt(double) */;
                        } finally {
                            lock.unlock();
                        }
                        return executeAndSpecialize(arguments0Value__);
                    }
                }
            }
            if ((state & 0b1000) != 0 /* is-active roundDouble(double, ConditionProfile, ConditionProfile) */) {
                if ((!(RoundNode.isCornercase(arguments0Value__)))) {
                    return roundDouble(arguments0Value__, this.roundDouble_profileA_, this.roundDouble_profileB_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arguments0Value_);
    }

    @Override
    public double executeDouble(VirtualFrame frameValue) throws UnexpectedResultException {
        int state = state_;
        int arguments0Value_int = 0;
        long arguments0Value_long = 0L;
        double arguments0Value_;
        try {
            if ((state & 0b11100000) == 0 /* only-active 0:double */ && (state & 0b1111) != 0  /* is-not roundInt(int) && roundCornercase(double) && roundDoubleInt(double) && roundDouble(double, ConditionProfile, ConditionProfile) */) {
                arguments0Value_long = this.arguments0_.executeLong(frameValue);
                arguments0Value_ = JSTypes.longToDouble(arguments0Value_long);
            } else if ((state & 0b11010000) == 0 /* only-active 0:double */ && (state & 0b1111) != 0  /* is-not roundInt(int) && roundCornercase(double) && roundDoubleInt(double) && roundDouble(double, ConditionProfile, ConditionProfile) */) {
                arguments0Value_int = this.arguments0_.executeInt(frameValue);
                arguments0Value_ = JSTypes.intToDouble(arguments0Value_int);
            } else if ((state & 0b10110000) == 0 /* only-active 0:double */ && (state & 0b1111) != 0  /* is-not roundInt(int) && roundCornercase(double) && roundDoubleInt(double) && roundDouble(double, ConditionProfile, ConditionProfile) */) {
                arguments0Value_ = this.arguments0_.executeDouble(frameValue);
            } else {
                Object arguments0Value__ = this.arguments0_.execute(frameValue);
                arguments0Value_ = JSTypesGen.expectImplicitDouble((state & 0b11110000) >>> 4 /* extract-implicit-active 0:double */, arguments0Value__);
            }
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectDouble(executeAndSpecialize(ex.getResult()));
        }
        if ((state & 0b10) != 0 /* is-active roundCornercase(double) */) {
            if ((RoundNode.isCornercase(arguments0Value_))) {
                return RoundNode.roundCornercase(arguments0Value_);
            }
        }
        if ((state & 0b1000) != 0 /* is-active roundDouble(double, ConditionProfile, ConditionProfile) */) {
            if ((!(RoundNode.isCornercase(arguments0Value_)))) {
                return roundDouble(arguments0Value_, this.roundDouble_profileA_, this.roundDouble_profileB_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectDouble(executeAndSpecialize(((state & 0b11100000) == 0 /* only-active 0:double */ && (state & 0b1111) != 0  /* is-not roundInt(int) && roundCornercase(double) && roundDoubleInt(double) && roundDouble(double, ConditionProfile, ConditionProfile) */ ? (Object) arguments0Value_long : ((state & 0b11010000) == 0 /* only-active 0:double */ && (state & 0b1111) != 0  /* is-not roundInt(int) && roundCornercase(double) && roundDoubleInt(double) && roundDouble(double, ConditionProfile, ConditionProfile) */ ? (Object) arguments0Value_int : (Object) arguments0Value_))));
    }

    @Override
    public int executeInt(VirtualFrame frameValue) throws UnexpectedResultException {
        int state = state_;
        if ((state & 0b100) == 0 /* only-active roundInt(int) */ && (state & 0b101) != 0  /* is-not roundInt(int) && roundDoubleInt(double) */) {
            return executeInt_int3(frameValue, state);
        } else if ((state & 0b1) == 0 /* only-active roundDoubleInt(double) */ && (state & 0b101) != 0  /* is-not roundInt(int) && roundDoubleInt(double) */) {
            return executeInt_double4(frameValue, state);
        } else {
            return executeInt_generic5(frameValue, state);
        }
    }

    private int executeInt_int3(VirtualFrame frameValue, int state) throws UnexpectedResultException {
        int arguments0Value_;
        try {
            arguments0Value_ = this.arguments0_.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectInteger(executeAndSpecialize(ex.getResult()));
        }
        assert (state & 0b1) != 0 /* is-active roundInt(int) */;
        return RoundNode.roundInt(arguments0Value_);
    }

    private int executeInt_double4(VirtualFrame frameValue, int state) throws UnexpectedResultException {
        int arguments0Value_int = 0;
        long arguments0Value_long = 0L;
        double arguments0Value_;
        try {
            if ((state & 0b11100000) == 0 /* only-active 0:double */ && (state & 0b1111) != 0  /* is-not roundInt(int) && roundCornercase(double) && roundDoubleInt(double) && roundDouble(double, ConditionProfile, ConditionProfile) */) {
                arguments0Value_long = this.arguments0_.executeLong(frameValue);
                arguments0Value_ = JSTypes.longToDouble(arguments0Value_long);
            } else if ((state & 0b11010000) == 0 /* only-active 0:double */ && (state & 0b1111) != 0  /* is-not roundInt(int) && roundCornercase(double) && roundDoubleInt(double) && roundDouble(double, ConditionProfile, ConditionProfile) */) {
                arguments0Value_int = this.arguments0_.executeInt(frameValue);
                arguments0Value_ = JSTypes.intToDouble(arguments0Value_int);
            } else if ((state & 0b10110000) == 0 /* only-active 0:double */ && (state & 0b1111) != 0  /* is-not roundInt(int) && roundCornercase(double) && roundDoubleInt(double) && roundDouble(double, ConditionProfile, ConditionProfile) */) {
                arguments0Value_ = this.arguments0_.executeDouble(frameValue);
            } else {
                Object arguments0Value__ = this.arguments0_.execute(frameValue);
                arguments0Value_ = JSTypesGen.expectImplicitDouble((state & 0b11110000) >>> 4 /* extract-implicit-active 0:double */, arguments0Value__);
            }
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectInteger(executeAndSpecialize(ex.getResult()));
        }
        assert (state & 0b100) != 0 /* is-active roundDoubleInt(double) */;
        if ((!(RoundNode.isCornercase(arguments0Value_))) && (JSGuards.isDoubleInInt32Range(arguments0Value_))) {
            try {
                return roundDoubleInt(arguments0Value_);
            } catch (ArithmeticException ex) {
                // implicit transferToInterpreterAndInvalidate()
                Lock lock = getLock();
                lock.lock();
                try {
                    this.exclude_ = this.exclude_ | 0b1 /* add-excluded roundDoubleInt(double) */;
                    this.state_ = this.state_ & 0xfffffffb /* remove-active roundDoubleInt(double) */;
                } finally {
                    lock.unlock();
                }
                return JSTypesGen.expectInteger(executeAndSpecialize(arguments0Value_));
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectInteger(executeAndSpecialize(((state & 0b11100000) == 0 /* only-active 0:double */ && (state & 0b1111) != 0  /* is-not roundInt(int) && roundCornercase(double) && roundDoubleInt(double) && roundDouble(double, ConditionProfile, ConditionProfile) */ ? (Object) arguments0Value_long : ((state & 0b11010000) == 0 /* only-active 0:double */ && (state & 0b1111) != 0  /* is-not roundInt(int) && roundCornercase(double) && roundDoubleInt(double) && roundDouble(double, ConditionProfile, ConditionProfile) */ ? (Object) arguments0Value_int : (Object) arguments0Value_))));
    }

    private int executeInt_generic5(VirtualFrame frameValue, int state) throws UnexpectedResultException {
        Object arguments0Value_ = this.arguments0_.execute(frameValue);
        if ((state & 0b1) != 0 /* is-active roundInt(int) */ && arguments0Value_ instanceof Integer) {
            int arguments0Value__ = (int) arguments0Value_;
            return RoundNode.roundInt(arguments0Value__);
        }
        if ((state & 0b100) != 0 /* is-active roundDoubleInt(double) */ && JSTypesGen.isImplicitDouble((state & 0b11110000) >>> 4 /* extract-implicit-active 0:double */, arguments0Value_)) {
            double arguments0Value__ = JSTypesGen.asImplicitDouble((state & 0b11110000) >>> 4 /* extract-implicit-active 0:double */, arguments0Value_);
            if ((!(RoundNode.isCornercase(arguments0Value__))) && (JSGuards.isDoubleInInt32Range(arguments0Value__))) {
                try {
                    return roundDoubleInt(arguments0Value__);
                } catch (ArithmeticException ex) {
                    // implicit transferToInterpreterAndInvalidate()
                    Lock lock = getLock();
                    lock.lock();
                    try {
                        this.exclude_ = this.exclude_ | 0b1 /* add-excluded roundDoubleInt(double) */;
                        this.state_ = this.state_ & 0xfffffffb /* remove-active roundDoubleInt(double) */;
                    } finally {
                        lock.unlock();
                    }
                    return JSTypesGen.expectInteger(executeAndSpecialize(arguments0Value__));
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectInteger(executeAndSpecialize(arguments0Value_));
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        int state = state_;
        try {
            if ((state & 0b1010) == 0 /* only-active roundInt(int) && roundDoubleInt(double) */ && (state & 0b1111) != 0  /* is-not roundInt(int) && roundCornercase(double) && roundDoubleInt(double) && roundDouble(double, ConditionProfile, ConditionProfile) */) {
                executeInt(frameValue);
                return;
            } else if ((state & 0b101) == 0 /* only-active roundCornercase(double) && roundDouble(double, ConditionProfile, ConditionProfile) */ && (state & 0b1111) != 0  /* is-not roundInt(int) && roundCornercase(double) && roundDoubleInt(double) && roundDouble(double, ConditionProfile, ConditionProfile) */) {
                executeDouble(frameValue);
                return;
            }
            execute(frameValue);
            return;
        } catch (UnexpectedResultException ex) {
            return;
        }
    }

    private Object executeAndSpecialize(Object arguments0Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        int exclude = exclude_;
        try {
            if (arguments0Value instanceof Integer) {
                int arguments0Value_ = (int) arguments0Value;
                this.state_ = state = state | 0b1 /* add-active roundInt(int) */;
                lock.unlock();
                hasLock = false;
                return RoundNode.roundInt(arguments0Value_);
            }
            {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(arguments0Value)) != 0) {
                    double arguments0Value_ = JSTypesGen.asImplicitDouble(doubleCast0, arguments0Value);
                    if ((RoundNode.isCornercase(arguments0Value_))) {
                        state = (state | (doubleCast0 << 4) /* set-implicit-active 0:double */);
                        this.state_ = state = state | 0b10 /* add-active roundCornercase(double) */;
                        lock.unlock();
                        hasLock = false;
                        return RoundNode.roundCornercase(arguments0Value_);
                    }
                    if ((exclude) == 0 /* is-not-excluded roundDoubleInt(double) */) {
                        if ((!(RoundNode.isCornercase(arguments0Value_))) && (JSGuards.isDoubleInInt32Range(arguments0Value_))) {
                            state = (state | (doubleCast0 << 4) /* set-implicit-active 0:double */);
                            this.state_ = state = state | 0b100 /* add-active roundDoubleInt(double) */;
                            try {
                                lock.unlock();
                                hasLock = false;
                                return roundDoubleInt(arguments0Value_);
                            } catch (ArithmeticException ex) {
                                // implicit transferToInterpreterAndInvalidate()
                                lock.lock();
                                try {
                                    this.exclude_ = this.exclude_ | 0b1 /* add-excluded roundDoubleInt(double) */;
                                    this.state_ = this.state_ & 0xfffffffb /* remove-active roundDoubleInt(double) */;
                                } finally {
                                    lock.unlock();
                                }
                                return executeAndSpecialize(arguments0Value_);
                            }
                        }
                    }
                    if ((!(RoundNode.isCornercase(arguments0Value_)))) {
                        this.roundDouble_profileA_ = (ConditionProfile.createBinaryProfile());
                        this.roundDouble_profileB_ = (ConditionProfile.createBinaryProfile());
                        this.exclude_ = exclude = exclude | 0b1 /* add-excluded roundDoubleInt(double) */;
                        state = state & 0xfffffffb /* remove-active roundDoubleInt(double) */;
                        state = (state | (doubleCast0 << 4) /* set-implicit-active 0:double */);
                        this.state_ = state = state | 0b1000 /* add-active roundDouble(double, ConditionProfile, ConditionProfile) */;
                        lock.unlock();
                        hasLock = false;
                        return roundDouble(arguments0Value_, this.roundDouble_profileA_, this.roundDouble_profileB_);
                    }
                }
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_}, arguments0Value);
        } finally {
            if (hasLock) {
                lock.unlock();
            }
        }
    }

    @Override
    public NodeCost getCost() {
        int state = state_;
        if ((state & 0b1111) == 0b0) {
            return NodeCost.UNINITIALIZED;
        } else if (((state & 0b1111) & ((state & 0b1111) - 1)) == 0 /* is-single-active  */) {
            return NodeCost.MONOMORPHIC;
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[5];
        Object[] s;
        data[0] = 0;
        int state = state_;
        int exclude = exclude_;
        s = new Object[3];
        s[0] = "roundInt";
        if ((state & 0b1) != 0 /* is-active roundInt(int) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "roundCornercase";
        if ((state & 0b10) != 0 /* is-active roundCornercase(double) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "roundDoubleInt";
        if ((state & 0b100) != 0 /* is-active roundDoubleInt(double) */) {
            s[1] = (byte)0b01 /* active */;
        } else if (exclude != 0 /* is-excluded roundDoubleInt(double) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "roundDouble";
        if ((state & 0b1000) != 0 /* is-active roundDouble(double, ConditionProfile, ConditionProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.roundDouble_profileA_, this.roundDouble_profileB_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        return Provider.create(data);
    }

    public static RoundNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
        return new RoundNodeGen(context, builtin, arguments);
    }

}
