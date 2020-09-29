// CheckStyle: start generated
package com.oracle.truffle.js.builtins.math;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.SlowPathException;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.SafeInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(FloorNode.class)
public final class FloorNodeGen extends FloorNode implements Provider {

    @Child private JavaScriptNode arguments0_;
    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private ConditionProfile floorMightReturnInt_smaller_;
    @CompilationFinal private FloorReturnsDoubleData floorReturnsDouble_cache;

    private FloorNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
        if ((state & 0b1110) == 0 /* only-active floorInt(int) */ && state != 0  /* is-not floorInt(int) && floorSafeInt(SafeInteger) && floorMightReturnInt(Object, ConditionProfile) && floorReturnsDouble(Object, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile) */) {
            return execute_int0(frameValue, state);
        } else {
            return execute_generic1(frameValue, state);
        }
    }

    private Object execute_int0(VirtualFrame frameValue, int state) {
        int arguments0Value_;
        try {
            arguments0Value_ = this.arguments0_.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(ex.getResult());
        }
        assert (state & 0b1) != 0 /* is-active floorInt(int) */;
        return FloorNode.floorInt(arguments0Value_);
    }

    private Object execute_generic1(VirtualFrame frameValue, int state) {
        Object arguments0Value_ = this.arguments0_.execute(frameValue);
        if ((state & 0b1) != 0 /* is-active floorInt(int) */ && arguments0Value_ instanceof Integer) {
            int arguments0Value__ = (int) arguments0Value_;
            return FloorNode.floorInt(arguments0Value__);
        }
        if ((state & 0b10) != 0 /* is-active floorSafeInt(SafeInteger) */ && arguments0Value_ instanceof SafeInteger) {
            SafeInteger arguments0Value__ = (SafeInteger) arguments0Value_;
            return FloorNode.floorSafeInt(arguments0Value__);
        }
        if ((state & 0b1100) != 0 /* is-active floorMightReturnInt(Object, ConditionProfile) || floorReturnsDouble(Object, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile) */) {
            if ((state & 0b100) != 0 /* is-active floorMightReturnInt(Object, ConditionProfile) */) {
                try {
                    return floorMightReturnInt(arguments0Value_, this.floorMightReturnInt_smaller_);
                } catch (SlowPathException ex) {
                    // implicit transferToInterpreterAndInvalidate()
                    Lock lock = getLock();
                    lock.lock();
                    try {
                        this.exclude_ = this.exclude_ | 0b1 /* add-excluded floorMightReturnInt(Object, ConditionProfile) */;
                        this.state_ = this.state_ & 0xfffffffb /* remove-active floorMightReturnInt(Object, ConditionProfile) */;
                    } finally {
                        lock.unlock();
                    }
                    return executeAndSpecialize(arguments0Value_);
                }
            }
            if ((state & 0b1000) != 0 /* is-active floorReturnsDouble(Object, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile) */) {
                FloorReturnsDoubleData s4_ = this.floorReturnsDouble_cache;
                if (s4_ != null) {
                    return floorReturnsDouble(arguments0Value_, s4_.isNaN_, s4_.isNegativeZero_, s4_.fitsSafeLong_, s4_.smaller_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arguments0Value_);
    }

    @Override
    public double executeDouble(VirtualFrame frameValue) throws UnexpectedResultException {
        int state = state_;
        Object arguments0Value_ = this.arguments0_.execute(frameValue);
        if ((state & 0b1000) != 0 /* is-active floorReturnsDouble(Object, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile) */) {
            FloorReturnsDoubleData s4_ = this.floorReturnsDouble_cache;
            if (s4_ != null) {
                return floorReturnsDouble(arguments0Value_, s4_.isNaN_, s4_.isNegativeZero_, s4_.fitsSafeLong_, s4_.smaller_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectDouble(executeAndSpecialize(arguments0Value_));
    }

    @Override
    public int executeInt(VirtualFrame frameValue) throws UnexpectedResultException {
        int state = state_;
        if ((state & 0b100) == 0 /* only-active floorInt(int) */ && (state & 0b101) != 0  /* is-not floorInt(int) && floorMightReturnInt(Object, ConditionProfile) */) {
            return executeInt_int2(frameValue, state);
        } else {
            return executeInt_generic3(frameValue, state);
        }
    }

    private int executeInt_int2(VirtualFrame frameValue, int state) throws UnexpectedResultException {
        int arguments0Value_;
        try {
            arguments0Value_ = this.arguments0_.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectInteger(executeAndSpecialize(ex.getResult()));
        }
        assert (state & 0b1) != 0 /* is-active floorInt(int) */;
        return FloorNode.floorInt(arguments0Value_);
    }

    private int executeInt_generic3(VirtualFrame frameValue, int state) throws UnexpectedResultException {
        Object arguments0Value_ = this.arguments0_.execute(frameValue);
        if ((state & 0b1) != 0 /* is-active floorInt(int) */ && arguments0Value_ instanceof Integer) {
            int arguments0Value__ = (int) arguments0Value_;
            return FloorNode.floorInt(arguments0Value__);
        }
        if ((state & 0b100) != 0 /* is-active floorMightReturnInt(Object, ConditionProfile) */) {
            try {
                return floorMightReturnInt(arguments0Value_, this.floorMightReturnInt_smaller_);
            } catch (SlowPathException ex) {
                // implicit transferToInterpreterAndInvalidate()
                Lock lock = getLock();
                lock.lock();
                try {
                    this.exclude_ = this.exclude_ | 0b1 /* add-excluded floorMightReturnInt(Object, ConditionProfile) */;
                    this.state_ = this.state_ & 0xfffffffb /* remove-active floorMightReturnInt(Object, ConditionProfile) */;
                } finally {
                    lock.unlock();
                }
                return JSTypesGen.expectInteger(executeAndSpecialize(arguments0Value_));
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectInteger(executeAndSpecialize(arguments0Value_));
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        int state = state_;
        try {
            if ((state & 0b1010) == 0 /* only-active floorInt(int) && floorMightReturnInt(Object, ConditionProfile) */ && state != 0  /* is-not floorInt(int) && floorSafeInt(SafeInteger) && floorMightReturnInt(Object, ConditionProfile) && floorReturnsDouble(Object, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile) */) {
                executeInt(frameValue);
                return;
            } else if ((state & 0b111) == 0 /* only-active floorReturnsDouble(Object, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile) */ && state != 0  /* is-not floorInt(int) && floorSafeInt(SafeInteger) && floorMightReturnInt(Object, ConditionProfile) && floorReturnsDouble(Object, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile) */) {
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
                this.state_ = state = state | 0b1 /* add-active floorInt(int) */;
                lock.unlock();
                hasLock = false;
                return FloorNode.floorInt(arguments0Value_);
            }
            if (arguments0Value instanceof SafeInteger) {
                SafeInteger arguments0Value_ = (SafeInteger) arguments0Value;
                this.state_ = state = state | 0b10 /* add-active floorSafeInt(SafeInteger) */;
                lock.unlock();
                hasLock = false;
                return FloorNode.floorSafeInt(arguments0Value_);
            }
            if ((exclude) == 0 /* is-not-excluded floorMightReturnInt(Object, ConditionProfile) */) {
                this.floorMightReturnInt_smaller_ = (ConditionProfile.createBinaryProfile());
                this.state_ = state = state | 0b100 /* add-active floorMightReturnInt(Object, ConditionProfile) */;
                try {
                    lock.unlock();
                    hasLock = false;
                    return floorMightReturnInt(arguments0Value, this.floorMightReturnInt_smaller_);
                } catch (SlowPathException ex) {
                    // implicit transferToInterpreterAndInvalidate()
                    lock.lock();
                    try {
                        this.exclude_ = this.exclude_ | 0b1 /* add-excluded floorMightReturnInt(Object, ConditionProfile) */;
                        this.state_ = this.state_ & 0xfffffffb /* remove-active floorMightReturnInt(Object, ConditionProfile) */;
                    } finally {
                        lock.unlock();
                    }
                    return executeAndSpecialize(arguments0Value);
                }
            }
            FloorReturnsDoubleData s4_ = new FloorReturnsDoubleData();
            s4_.isNaN_ = (ConditionProfile.createBinaryProfile());
            s4_.isNegativeZero_ = (ConditionProfile.createBinaryProfile());
            s4_.fitsSafeLong_ = (ConditionProfile.createBinaryProfile());
            s4_.smaller_ = (ConditionProfile.createBinaryProfile());
            this.floorReturnsDouble_cache = s4_;
            this.state_ = state = state | 0b1000 /* add-active floorReturnsDouble(Object, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile) */;
            lock.unlock();
            hasLock = false;
            return floorReturnsDouble(arguments0Value, s4_.isNaN_, s4_.isNegativeZero_, s4_.fitsSafeLong_, s4_.smaller_);
        } finally {
            if (hasLock) {
                lock.unlock();
            }
        }
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
        Object[] data = new Object[5];
        Object[] s;
        data[0] = 0;
        int state = state_;
        int exclude = exclude_;
        s = new Object[3];
        s[0] = "floorInt";
        if ((state & 0b1) != 0 /* is-active floorInt(int) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "floorSafeInt";
        if ((state & 0b10) != 0 /* is-active floorSafeInt(SafeInteger) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "floorMightReturnInt";
        if ((state & 0b100) != 0 /* is-active floorMightReturnInt(Object, ConditionProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.floorMightReturnInt_smaller_));
            s[2] = cached;
        } else if (exclude != 0 /* is-excluded floorMightReturnInt(Object, ConditionProfile) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "floorReturnsDouble";
        if ((state & 0b1000) != 0 /* is-active floorReturnsDouble(Object, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            FloorReturnsDoubleData s4_ = this.floorReturnsDouble_cache;
            if (s4_ != null) {
                cached.add(Arrays.asList(s4_.isNaN_, s4_.isNegativeZero_, s4_.fitsSafeLong_, s4_.smaller_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        return Provider.create(data);
    }

    public static FloorNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
        return new FloorNodeGen(context, builtin, arguments);
    }

    @GeneratedBy(FloorNode.class)
    private static final class FloorReturnsDoubleData {

        @CompilationFinal ConditionProfile isNaN_;
        @CompilationFinal ConditionProfile isNegativeZero_;
        @CompilationFinal ConditionProfile fitsSafeLong_;
        @CompilationFinal ConditionProfile smaller_;

        FloorReturnsDoubleData() {
        }

    }
}
