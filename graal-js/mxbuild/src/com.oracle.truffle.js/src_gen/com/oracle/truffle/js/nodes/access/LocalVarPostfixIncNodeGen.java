// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.Frame;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.cast.JSToNumericNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(LocalVarPostfixIncNode.class)
final class LocalVarPostfixIncNodeGen extends LocalVarPostfixIncNode implements Provider {

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @Child private ObjectData object_cache;

    private LocalVarPostfixIncNodeGen(LocalVarOp op, FrameSlot frameSlot, boolean hasTemporalDeadZone, ScopeFrameNode scopeFrameNode) {
        super(op, frameSlot, hasTemporalDeadZone, scopeFrameNode);
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        int state = state_;
        Frame scopeFrameNodeValue_ = super.scopeFrameNode.executeFrame(frameValue);
        if (state != 0 /* is-active doBoolean(Frame) || doBooleanDouble(Frame) || doBooleanObject(Frame) || doInt(Frame) || doIntDouble(Frame) || doIntObject(Frame) || doDouble(Frame) || doDoubleObject(Frame) || doObject(Frame, ConditionProfile, ConditionProfile, ConditionProfile, JSToNumericNode, BranchProfile) || doSafeInteger(Frame) || doSafeIntegerToDouble(Frame) || doSafeIntegerObject(Frame) */) {
            if ((state & 0b1) != 0 /* is-active doBoolean(Frame) */) {
                if ((isBoolean(scopeFrameNodeValue_)) && (isIntegerKind(scopeFrameNodeValue_))) {
                    return doBoolean(scopeFrameNodeValue_);
                }
            }
            if ((state & 0b10) != 0 /* is-active doBooleanDouble(Frame) */) {
                if ((isBoolean(scopeFrameNodeValue_)) && (isDoubleKind(scopeFrameNodeValue_))) {
                    return doBooleanDouble(scopeFrameNodeValue_);
                }
            }
            if ((state & 0b100) != 0 /* is-active doBooleanObject(Frame) */) {
                if ((isBoolean(scopeFrameNodeValue_)) && (ensureObjectKind(scopeFrameNodeValue_))) {
                    return doBooleanObject(scopeFrameNodeValue_);
                }
            }
            if ((state & 0b1000) != 0 /* is-active doInt(Frame) */) {
                if ((isInt(scopeFrameNodeValue_)) && (isIntegerKind(scopeFrameNodeValue_))) {
                    try {
                        return doInt(scopeFrameNodeValue_);
                    } catch (ArithmeticException ex) {
                        // implicit transferToInterpreterAndInvalidate()
                        Lock lock = getLock();
                        lock.lock();
                        try {
                            this.exclude_ = this.exclude_ | 0b100 /* add-excluded doInt(Frame) */;
                            this.state_ = this.state_ & 0xfffffff7 /* remove-active doInt(Frame) */;
                        } finally {
                            lock.unlock();
                        }
                        return executeAndSpecialize(scopeFrameNodeValue_);
                    }
                }
            }
            if ((state & 0b10000) != 0 /* is-active doIntDouble(Frame) */) {
                if ((isInt(scopeFrameNodeValue_)) && (isDoubleKind(scopeFrameNodeValue_))) {
                    return doIntDouble(scopeFrameNodeValue_);
                }
            }
            if ((state & 0b100000) != 0 /* is-active doIntObject(Frame) */) {
                if ((isInt(scopeFrameNodeValue_)) && (ensureObjectKind(scopeFrameNodeValue_))) {
                    return doIntObject(scopeFrameNodeValue_);
                }
            }
            if ((state & 0b1000000) != 0 /* is-active doDouble(Frame) */) {
                if ((isDouble(scopeFrameNodeValue_)) && (isDoubleKind(scopeFrameNodeValue_))) {
                    return doDouble(scopeFrameNodeValue_);
                }
            }
            if ((state & 0b10000000) != 0 /* is-active doDoubleObject(Frame) */) {
                if ((isDouble(scopeFrameNodeValue_)) && (ensureObjectKind(scopeFrameNodeValue_))) {
                    return doDoubleObject(scopeFrameNodeValue_);
                }
            }
            if ((state & 0b100000000) != 0 /* is-active doObject(Frame, ConditionProfile, ConditionProfile, ConditionProfile, JSToNumericNode, BranchProfile) */) {
                ObjectData s9_ = this.object_cache;
                if (s9_ != null) {
                    if ((isObject(scopeFrameNodeValue_)) && (ensureObjectKind(scopeFrameNodeValue_))) {
                        return doObject(scopeFrameNodeValue_, s9_.isIntegerProfile_, s9_.isBigIntProfile_, s9_.isBoundaryProfile_, s9_.toNumeric_, s9_.deadBranch_);
                    }
                }
            }
            if ((state & 0b1000000000) != 0 /* is-active doSafeInteger(Frame) */) {
                if ((isLong(scopeFrameNodeValue_)) && (isLongKind(scopeFrameNodeValue_))) {
                    try {
                        return doSafeInteger(scopeFrameNodeValue_);
                    } catch (ArithmeticException ex) {
                        // implicit transferToInterpreterAndInvalidate()
                        Lock lock = getLock();
                        lock.lock();
                        try {
                            this.exclude_ = this.exclude_ | 0b100000 /* add-excluded doSafeInteger(Frame) */;
                            this.state_ = this.state_ & 0xfffffdff /* remove-active doSafeInteger(Frame) */;
                        } finally {
                            lock.unlock();
                        }
                        return executeAndSpecialize(scopeFrameNodeValue_);
                    }
                }
            }
            if ((state & 0b10000000000) != 0 /* is-active doSafeIntegerToDouble(Frame) */) {
                if ((isLong(scopeFrameNodeValue_)) && (isDoubleKind(scopeFrameNodeValue_))) {
                    return doSafeIntegerToDouble(scopeFrameNodeValue_);
                }
            }
            if ((state & 0b100000000000) != 0 /* is-active doSafeIntegerObject(Frame) */) {
                if ((isLong(scopeFrameNodeValue_)) && (ensureObjectKind(scopeFrameNodeValue_))) {
                    return doSafeIntegerObject(scopeFrameNodeValue_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(scopeFrameNodeValue_);
    }

    @Override
    public double executeDouble(VirtualFrame frameValue) throws UnexpectedResultException {
        int state = state_;
        if ((state & 0b100000000) != 0 /* is-active doObject(Frame, ConditionProfile, ConditionProfile, ConditionProfile, JSToNumericNode, BranchProfile) */) {
            return JSTypesGen.expectDouble(execute(frameValue));
        }
        Frame scopeFrameNodeValue_ = super.scopeFrameNode.executeFrame(frameValue);
        if ((state & 0b110011000000) != 0 /* is-active doDouble(Frame) || doDoubleObject(Frame) || doSafeIntegerToDouble(Frame) || doSafeIntegerObject(Frame) */) {
            if ((state & 0b1000000) != 0 /* is-active doDouble(Frame) */) {
                if ((isDouble(scopeFrameNodeValue_)) && (isDoubleKind(scopeFrameNodeValue_))) {
                    return doDouble(scopeFrameNodeValue_);
                }
            }
            if ((state & 0b10000000) != 0 /* is-active doDoubleObject(Frame) */) {
                if ((isDouble(scopeFrameNodeValue_)) && (ensureObjectKind(scopeFrameNodeValue_))) {
                    return doDoubleObject(scopeFrameNodeValue_);
                }
            }
            if ((state & 0b10000000000) != 0 /* is-active doSafeIntegerToDouble(Frame) */) {
                if ((isLong(scopeFrameNodeValue_)) && (isDoubleKind(scopeFrameNodeValue_))) {
                    return doSafeIntegerToDouble(scopeFrameNodeValue_);
                }
            }
            if ((state & 0b100000000000) != 0 /* is-active doSafeIntegerObject(Frame) */) {
                if ((isLong(scopeFrameNodeValue_)) && (ensureObjectKind(scopeFrameNodeValue_))) {
                    return doSafeIntegerObject(scopeFrameNodeValue_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectDouble(executeAndSpecialize(scopeFrameNodeValue_));
    }

    @Override
    public int executeInt(VirtualFrame frameValue) throws UnexpectedResultException {
        int state = state_;
        if ((state & 0b100000000) != 0 /* is-active doObject(Frame, ConditionProfile, ConditionProfile, ConditionProfile, JSToNumericNode, BranchProfile) */) {
            return JSTypesGen.expectInteger(execute(frameValue));
        }
        Frame scopeFrameNodeValue_ = super.scopeFrameNode.executeFrame(frameValue);
        if ((state & 0b111111) != 0 /* is-active doBoolean(Frame) || doBooleanDouble(Frame) || doBooleanObject(Frame) || doInt(Frame) || doIntDouble(Frame) || doIntObject(Frame) */) {
            if ((state & 0b1) != 0 /* is-active doBoolean(Frame) */) {
                if ((isBoolean(scopeFrameNodeValue_)) && (isIntegerKind(scopeFrameNodeValue_))) {
                    return doBoolean(scopeFrameNodeValue_);
                }
            }
            if ((state & 0b10) != 0 /* is-active doBooleanDouble(Frame) */) {
                if ((isBoolean(scopeFrameNodeValue_)) && (isDoubleKind(scopeFrameNodeValue_))) {
                    return doBooleanDouble(scopeFrameNodeValue_);
                }
            }
            if ((state & 0b100) != 0 /* is-active doBooleanObject(Frame) */) {
                if ((isBoolean(scopeFrameNodeValue_)) && (ensureObjectKind(scopeFrameNodeValue_))) {
                    return doBooleanObject(scopeFrameNodeValue_);
                }
            }
            if ((state & 0b1000) != 0 /* is-active doInt(Frame) */) {
                if ((isInt(scopeFrameNodeValue_)) && (isIntegerKind(scopeFrameNodeValue_))) {
                    try {
                        return doInt(scopeFrameNodeValue_);
                    } catch (ArithmeticException ex) {
                        // implicit transferToInterpreterAndInvalidate()
                        Lock lock = getLock();
                        lock.lock();
                        try {
                            this.exclude_ = this.exclude_ | 0b100 /* add-excluded doInt(Frame) */;
                            this.state_ = this.state_ & 0xfffffff7 /* remove-active doInt(Frame) */;
                        } finally {
                            lock.unlock();
                        }
                        return JSTypesGen.expectInteger(executeAndSpecialize(scopeFrameNodeValue_));
                    }
                }
            }
            if ((state & 0b10000) != 0 /* is-active doIntDouble(Frame) */) {
                if ((isInt(scopeFrameNodeValue_)) && (isDoubleKind(scopeFrameNodeValue_))) {
                    return doIntDouble(scopeFrameNodeValue_);
                }
            }
            if ((state & 0b100000) != 0 /* is-active doIntObject(Frame) */) {
                if ((isInt(scopeFrameNodeValue_)) && (ensureObjectKind(scopeFrameNodeValue_))) {
                    return doIntObject(scopeFrameNodeValue_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectInteger(executeAndSpecialize(scopeFrameNodeValue_));
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        int state = state_;
        try {
            if ((state & 0b111111000000) == 0 /* only-active doBoolean(Frame) && doBooleanDouble(Frame) && doBooleanObject(Frame) && doInt(Frame) && doIntDouble(Frame) && doIntObject(Frame) */ && state != 0  /* is-not doBoolean(Frame) && doBooleanDouble(Frame) && doBooleanObject(Frame) && doInt(Frame) && doIntDouble(Frame) && doIntObject(Frame) && doDouble(Frame) && doDoubleObject(Frame) && doObject(Frame, ConditionProfile, ConditionProfile, ConditionProfile, JSToNumericNode, BranchProfile) && doSafeInteger(Frame) && doSafeIntegerToDouble(Frame) && doSafeIntegerObject(Frame) */) {
                executeInt(frameValue);
                return;
            } else if ((state & 0b1100111111) == 0 /* only-active doDouble(Frame) && doDoubleObject(Frame) && doSafeIntegerToDouble(Frame) && doSafeIntegerObject(Frame) */ && state != 0  /* is-not doBoolean(Frame) && doBooleanDouble(Frame) && doBooleanObject(Frame) && doInt(Frame) && doIntDouble(Frame) && doIntObject(Frame) && doDouble(Frame) && doDoubleObject(Frame) && doObject(Frame, ConditionProfile, ConditionProfile, ConditionProfile, JSToNumericNode, BranchProfile) && doSafeInteger(Frame) && doSafeIntegerToDouble(Frame) && doSafeIntegerObject(Frame) */) {
                executeDouble(frameValue);
                return;
            }
            execute(frameValue);
            return;
        } catch (UnexpectedResultException ex) {
            return;
        }
    }

    private Object executeAndSpecialize(Frame scopeFrameNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        int exclude = exclude_;
        try {
            if (((exclude & 0b1)) == 0 /* is-not-excluded doBoolean(Frame) */) {
                if ((isBoolean(scopeFrameNodeValue)) && (isIntegerKind(scopeFrameNodeValue))) {
                    this.state_ = state = state | 0b1 /* add-active doBoolean(Frame) */;
                    lock.unlock();
                    hasLock = false;
                    return doBoolean(scopeFrameNodeValue);
                }
            }
            if (((exclude & 0b10)) == 0 /* is-not-excluded doBooleanDouble(Frame) */) {
                if ((isBoolean(scopeFrameNodeValue)) && (isDoubleKind(scopeFrameNodeValue))) {
                    this.exclude_ = exclude = exclude | 0b1 /* add-excluded doBoolean(Frame) */;
                    state = state & 0xfffffffe /* remove-active doBoolean(Frame) */;
                    this.state_ = state = state | 0b10 /* add-active doBooleanDouble(Frame) */;
                    lock.unlock();
                    hasLock = false;
                    return doBooleanDouble(scopeFrameNodeValue);
                }
            }
            if ((isBoolean(scopeFrameNodeValue)) && (ensureObjectKind(scopeFrameNodeValue))) {
                this.exclude_ = exclude = exclude | 0b11 /* add-excluded doBoolean(Frame), doBooleanDouble(Frame) */;
                state = state & 0xfffffffc /* remove-active doBoolean(Frame), doBooleanDouble(Frame) */;
                this.state_ = state = state | 0b100 /* add-active doBooleanObject(Frame) */;
                lock.unlock();
                hasLock = false;
                return doBooleanObject(scopeFrameNodeValue);
            }
            if (((exclude & 0b100)) == 0 /* is-not-excluded doInt(Frame) */) {
                if ((isInt(scopeFrameNodeValue)) && (isIntegerKind(scopeFrameNodeValue))) {
                    this.state_ = state = state | 0b1000 /* add-active doInt(Frame) */;
                    try {
                        lock.unlock();
                        hasLock = false;
                        return doInt(scopeFrameNodeValue);
                    } catch (ArithmeticException ex) {
                        // implicit transferToInterpreterAndInvalidate()
                        lock.lock();
                        try {
                            this.exclude_ = this.exclude_ | 0b100 /* add-excluded doInt(Frame) */;
                            this.state_ = this.state_ & 0xfffffff7 /* remove-active doInt(Frame) */;
                        } finally {
                            lock.unlock();
                        }
                        return executeAndSpecialize(scopeFrameNodeValue);
                    }
                }
            }
            if (((exclude & 0b1000)) == 0 /* is-not-excluded doIntDouble(Frame) */) {
                if ((isInt(scopeFrameNodeValue)) && (isDoubleKind(scopeFrameNodeValue))) {
                    this.exclude_ = exclude = exclude | 0b100 /* add-excluded doInt(Frame) */;
                    state = state & 0xfffffff7 /* remove-active doInt(Frame) */;
                    this.state_ = state = state | 0b10000 /* add-active doIntDouble(Frame) */;
                    lock.unlock();
                    hasLock = false;
                    return doIntDouble(scopeFrameNodeValue);
                }
            }
            if ((isInt(scopeFrameNodeValue)) && (ensureObjectKind(scopeFrameNodeValue))) {
                this.exclude_ = exclude = exclude | 0b1100 /* add-excluded doInt(Frame), doIntDouble(Frame) */;
                state = state & 0xffffffe7 /* remove-active doInt(Frame), doIntDouble(Frame) */;
                this.state_ = state = state | 0b100000 /* add-active doIntObject(Frame) */;
                lock.unlock();
                hasLock = false;
                return doIntObject(scopeFrameNodeValue);
            }
            if (((exclude & 0b10000)) == 0 /* is-not-excluded doDouble(Frame) */) {
                if ((isDouble(scopeFrameNodeValue)) && (isDoubleKind(scopeFrameNodeValue))) {
                    this.state_ = state = state | 0b1000000 /* add-active doDouble(Frame) */;
                    lock.unlock();
                    hasLock = false;
                    return doDouble(scopeFrameNodeValue);
                }
            }
            if ((isDouble(scopeFrameNodeValue)) && (ensureObjectKind(scopeFrameNodeValue))) {
                this.exclude_ = exclude = exclude | 0b10000 /* add-excluded doDouble(Frame) */;
                state = state & 0xffffffbf /* remove-active doDouble(Frame) */;
                this.state_ = state = state | 0b10000000 /* add-active doDoubleObject(Frame) */;
                lock.unlock();
                hasLock = false;
                return doDoubleObject(scopeFrameNodeValue);
            }
            if ((isObject(scopeFrameNodeValue)) && (ensureObjectKind(scopeFrameNodeValue))) {
                ObjectData s9_ = super.insert(new ObjectData());
                s9_.isIntegerProfile_ = (ConditionProfile.createBinaryProfile());
                s9_.isBigIntProfile_ = (ConditionProfile.createBinaryProfile());
                s9_.isBoundaryProfile_ = (ConditionProfile.createBinaryProfile());
                s9_.toNumeric_ = s9_.insertAccessor((JSToNumericNode.create()));
                s9_.deadBranch_ = (BranchProfile.create());
                this.object_cache = s9_;
                this.state_ = state = state | 0b100000000 /* add-active doObject(Frame, ConditionProfile, ConditionProfile, ConditionProfile, JSToNumericNode, BranchProfile) */;
                lock.unlock();
                hasLock = false;
                return doObject(scopeFrameNodeValue, s9_.isIntegerProfile_, s9_.isBigIntProfile_, s9_.isBoundaryProfile_, s9_.toNumeric_, s9_.deadBranch_);
            }
            if (((exclude & 0b100000)) == 0 /* is-not-excluded doSafeInteger(Frame) */) {
                if ((isLong(scopeFrameNodeValue)) && (isLongKind(scopeFrameNodeValue))) {
                    this.state_ = state = state | 0b1000000000 /* add-active doSafeInteger(Frame) */;
                    try {
                        lock.unlock();
                        hasLock = false;
                        return doSafeInteger(scopeFrameNodeValue);
                    } catch (ArithmeticException ex) {
                        // implicit transferToInterpreterAndInvalidate()
                        lock.lock();
                        try {
                            this.exclude_ = this.exclude_ | 0b100000 /* add-excluded doSafeInteger(Frame) */;
                            this.state_ = this.state_ & 0xfffffdff /* remove-active doSafeInteger(Frame) */;
                        } finally {
                            lock.unlock();
                        }
                        return executeAndSpecialize(scopeFrameNodeValue);
                    }
                }
            }
            if (((exclude & 0b1000000)) == 0 /* is-not-excluded doSafeIntegerToDouble(Frame) */) {
                if ((isLong(scopeFrameNodeValue)) && (isDoubleKind(scopeFrameNodeValue))) {
                    this.exclude_ = exclude = exclude | 0b100000 /* add-excluded doSafeInteger(Frame) */;
                    state = state & 0xfffffdff /* remove-active doSafeInteger(Frame) */;
                    this.state_ = state = state | 0b10000000000 /* add-active doSafeIntegerToDouble(Frame) */;
                    lock.unlock();
                    hasLock = false;
                    return doSafeIntegerToDouble(scopeFrameNodeValue);
                }
            }
            if ((isLong(scopeFrameNodeValue)) && (ensureObjectKind(scopeFrameNodeValue))) {
                this.exclude_ = exclude = exclude | 0b1100000 /* add-excluded doSafeInteger(Frame), doSafeIntegerToDouble(Frame) */;
                state = state & 0xfffff9ff /* remove-active doSafeInteger(Frame), doSafeIntegerToDouble(Frame) */;
                this.state_ = state = state | 0b100000000000 /* add-active doSafeIntegerObject(Frame) */;
                lock.unlock();
                hasLock = false;
                return doSafeIntegerObject(scopeFrameNodeValue);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {super.scopeFrameNode}, scopeFrameNodeValue);
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
        Object[] data = new Object[13];
        Object[] s;
        data[0] = 0;
        int state = state_;
        int exclude = exclude_;
        s = new Object[3];
        s[0] = "doBoolean";
        if ((state & 0b1) != 0 /* is-active doBoolean(Frame) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b1) != 0 /* is-excluded doBoolean(Frame) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doBooleanDouble";
        if ((state & 0b10) != 0 /* is-active doBooleanDouble(Frame) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b10) != 0 /* is-excluded doBooleanDouble(Frame) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doBooleanObject";
        if ((state & 0b100) != 0 /* is-active doBooleanObject(Frame) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doInt";
        if ((state & 0b1000) != 0 /* is-active doInt(Frame) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b100) != 0 /* is-excluded doInt(Frame) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doIntDouble";
        if ((state & 0b10000) != 0 /* is-active doIntDouble(Frame) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b1000) != 0 /* is-excluded doIntDouble(Frame) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "doIntObject";
        if ((state & 0b100000) != 0 /* is-active doIntObject(Frame) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "doDouble";
        if ((state & 0b1000000) != 0 /* is-active doDouble(Frame) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b10000) != 0 /* is-excluded doDouble(Frame) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        s = new Object[3];
        s[0] = "doDoubleObject";
        if ((state & 0b10000000) != 0 /* is-active doDoubleObject(Frame) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[8] = s;
        s = new Object[3];
        s[0] = "doObject";
        if ((state & 0b100000000) != 0 /* is-active doObject(Frame, ConditionProfile, ConditionProfile, ConditionProfile, JSToNumericNode, BranchProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            ObjectData s9_ = this.object_cache;
            if (s9_ != null) {
                cached.add(Arrays.asList(s9_.isIntegerProfile_, s9_.isBigIntProfile_, s9_.isBoundaryProfile_, s9_.toNumeric_, s9_.deadBranch_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[9] = s;
        s = new Object[3];
        s[0] = "doSafeInteger";
        if ((state & 0b1000000000) != 0 /* is-active doSafeInteger(Frame) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b100000) != 0 /* is-excluded doSafeInteger(Frame) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[10] = s;
        s = new Object[3];
        s[0] = "doSafeIntegerToDouble";
        if ((state & 0b10000000000) != 0 /* is-active doSafeIntegerToDouble(Frame) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b1000000) != 0 /* is-excluded doSafeIntegerToDouble(Frame) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[11] = s;
        s = new Object[3];
        s[0] = "doSafeIntegerObject";
        if ((state & 0b100000000000) != 0 /* is-active doSafeIntegerObject(Frame) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[12] = s;
        return Provider.create(data);
    }

    public static LocalVarPostfixIncNode create(LocalVarOp op, FrameSlot frameSlot, boolean hasTemporalDeadZone, ScopeFrameNode scopeFrameNode) {
        return new LocalVarPostfixIncNodeGen(op, frameSlot, hasTemporalDeadZone, scopeFrameNode);
    }

    @GeneratedBy(LocalVarPostfixIncNode.class)
    private static final class ObjectData extends Node {

        @CompilationFinal ConditionProfile isIntegerProfile_;
        @CompilationFinal ConditionProfile isBigIntProfile_;
        @CompilationFinal ConditionProfile isBoundaryProfile_;
        @Child JSToNumericNode toNumeric_;
        @CompilationFinal BranchProfile deadBranch_;

        ObjectData() {
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.NONE;
        }

        <T extends Node> T insertAccessor(T node) {
            return super.insert(node);
        }

    }
}
