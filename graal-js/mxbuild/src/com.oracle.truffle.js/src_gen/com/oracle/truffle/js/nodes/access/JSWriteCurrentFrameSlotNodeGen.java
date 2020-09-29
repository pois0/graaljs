// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.runtime.SafeInteger;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSWriteCurrentFrameSlotNode.class)
final class JSWriteCurrentFrameSlotNodeGen extends JSWriteCurrentFrameSlotNode implements Provider {

    @CompilationFinal private int state_;
    @CompilationFinal private int exclude_;

    private JSWriteCurrentFrameSlotNodeGen(FrameSlot frameSlot, JavaScriptNode rhsNode) {
        super(frameSlot, rhsNode);
    }

    @Override
    Object executeEvaluated(VirtualFrame frameValue, Object rhsNodeValue) {
        int state = state_;
        if ((state & 0b1) != 0 /* is-active doBoolean(VirtualFrame, boolean) */ && rhsNodeValue instanceof Boolean) {
            boolean rhsNodeValue_ = (boolean) rhsNodeValue;
            if ((isBooleanKind(frameValue))) {
                return doBoolean(frameValue, rhsNodeValue_);
            }
        }
        if ((state & 0b110) != 0 /* is-active doInt(VirtualFrame, int) || doSafeIntegerInt(VirtualFrame, int) */ && rhsNodeValue instanceof Integer) {
            int rhsNodeValue_ = (int) rhsNodeValue;
            if ((state & 0b10) != 0 /* is-active doInt(VirtualFrame, int) */) {
                if ((isIntegerKind(frameValue))) {
                    return doInt(frameValue, rhsNodeValue_);
                }
            }
            if ((state & 0b100) != 0 /* is-active doSafeIntegerInt(VirtualFrame, int) */) {
                if ((isLongKind(frameValue))) {
                    return doSafeIntegerInt(frameValue, rhsNodeValue_);
                }
            }
        }
        if ((state & 0b1000) != 0 /* is-active doSafeInteger(VirtualFrame, SafeInteger) */ && rhsNodeValue instanceof SafeInteger) {
            SafeInteger rhsNodeValue_ = (SafeInteger) rhsNodeValue;
            if ((isLongKind(frameValue))) {
                return doSafeInteger(frameValue, rhsNodeValue_);
            }
        }
        if ((state & 0b10000) != 0 /* is-active doLong(VirtualFrame, long) */ && rhsNodeValue instanceof Long) {
            long rhsNodeValue_ = (long) rhsNodeValue;
            if ((ensureObjectKind(frameValue))) {
                return doLong(frameValue, rhsNodeValue_);
            }
        }
        if ((state & 0b100000) != 0 /* is-active doDouble(VirtualFrame, double) */ && JSTypesGen.isImplicitDouble((state & 0b11110000000) >>> 7 /* extract-implicit-active 0:double */, rhsNodeValue)) {
            double rhsNodeValue_ = JSTypesGen.asImplicitDouble((state & 0b11110000000) >>> 7 /* extract-implicit-active 0:double */, rhsNodeValue);
            if ((isDoubleKind(frameValue))) {
                return doDouble(frameValue, rhsNodeValue_);
            }
        }
        if ((state & 0b1000000) != 0 /* is-active doObject(VirtualFrame, Object) */) {
            if ((ensureObjectKind(frameValue))) {
                return doObject(frameValue, rhsNodeValue);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(frameValue, rhsNodeValue);
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        int state = state_;
        if ((state & 0b1111110) == 0 /* only-active doBoolean(VirtualFrame, boolean) */ && (state & 0b1111111) != 0  /* is-not doBoolean(VirtualFrame, boolean) && doInt(VirtualFrame, int) && doSafeIntegerInt(VirtualFrame, int) && doSafeInteger(VirtualFrame, SafeInteger) && doLong(VirtualFrame, long) && doDouble(VirtualFrame, double) && doObject(VirtualFrame, Object) */) {
            return execute_boolean0(frameValue, state);
        } else if ((state & 0b1111001) == 0 /* only-active doInt(VirtualFrame, int) && doSafeIntegerInt(VirtualFrame, int) */ && (state & 0b1111111) != 0  /* is-not doBoolean(VirtualFrame, boolean) && doInt(VirtualFrame, int) && doSafeIntegerInt(VirtualFrame, int) && doSafeInteger(VirtualFrame, SafeInteger) && doLong(VirtualFrame, long) && doDouble(VirtualFrame, double) && doObject(VirtualFrame, Object) */) {
            return execute_int1(frameValue, state);
        } else if ((state & 0b1101111) == 0 /* only-active doLong(VirtualFrame, long) */ && (state & 0b1111111) != 0  /* is-not doBoolean(VirtualFrame, boolean) && doInt(VirtualFrame, int) && doSafeIntegerInt(VirtualFrame, int) && doSafeInteger(VirtualFrame, SafeInteger) && doLong(VirtualFrame, long) && doDouble(VirtualFrame, double) && doObject(VirtualFrame, Object) */) {
            return execute_long2(frameValue, state);
        } else if ((state & 0b1011111) == 0 /* only-active doDouble(VirtualFrame, double) */ && (state & 0b1111111) != 0  /* is-not doBoolean(VirtualFrame, boolean) && doInt(VirtualFrame, int) && doSafeIntegerInt(VirtualFrame, int) && doSafeInteger(VirtualFrame, SafeInteger) && doLong(VirtualFrame, long) && doDouble(VirtualFrame, double) && doObject(VirtualFrame, Object) */) {
            return execute_double3(frameValue, state);
        } else {
            return execute_generic4(frameValue, state);
        }
    }

    private Object execute_boolean0(VirtualFrame frameValue, int state) {
        boolean rhsNodeValue_;
        try {
            rhsNodeValue_ = super.rhsNode.executeBoolean(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(frameValue, ex.getResult());
        }
        assert (state & 0b1) != 0 /* is-active doBoolean(VirtualFrame, boolean) */;
        if ((isBooleanKind(frameValue))) {
            return doBoolean(frameValue, rhsNodeValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(frameValue, rhsNodeValue_);
    }

    private Object execute_int1(VirtualFrame frameValue, int state) {
        int rhsNodeValue_;
        try {
            rhsNodeValue_ = super.rhsNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(frameValue, ex.getResult());
        }
        if ((state & 0b10) != 0 /* is-active doInt(VirtualFrame, int) */) {
            if ((isIntegerKind(frameValue))) {
                return doInt(frameValue, rhsNodeValue_);
            }
        }
        if ((state & 0b100) != 0 /* is-active doSafeIntegerInt(VirtualFrame, int) */) {
            if ((isLongKind(frameValue))) {
                return doSafeIntegerInt(frameValue, rhsNodeValue_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(frameValue, rhsNodeValue_);
    }

    private Object execute_long2(VirtualFrame frameValue, int state) {
        long rhsNodeValue_;
        try {
            rhsNodeValue_ = super.rhsNode.executeLong(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(frameValue, ex.getResult());
        }
        assert (state & 0b10000) != 0 /* is-active doLong(VirtualFrame, long) */;
        if ((ensureObjectKind(frameValue))) {
            return doLong(frameValue, rhsNodeValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(frameValue, rhsNodeValue_);
    }

    private Object execute_double3(VirtualFrame frameValue, int state) {
        int rhsNodeValue_int = 0;
        long rhsNodeValue_long = 0L;
        double rhsNodeValue_;
        try {
            if ((state & 0b11100000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not doBoolean(VirtualFrame, boolean) && doInt(VirtualFrame, int) && doSafeIntegerInt(VirtualFrame, int) && doSafeInteger(VirtualFrame, SafeInteger) && doLong(VirtualFrame, long) && doDouble(VirtualFrame, double) && doObject(VirtualFrame, Object) */) {
                rhsNodeValue_long = super.rhsNode.executeLong(frameValue);
                rhsNodeValue_ = JSTypes.longToDouble(rhsNodeValue_long);
            } else if ((state & 0b11010000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not doBoolean(VirtualFrame, boolean) && doInt(VirtualFrame, int) && doSafeIntegerInt(VirtualFrame, int) && doSafeInteger(VirtualFrame, SafeInteger) && doLong(VirtualFrame, long) && doDouble(VirtualFrame, double) && doObject(VirtualFrame, Object) */) {
                rhsNodeValue_int = super.rhsNode.executeInt(frameValue);
                rhsNodeValue_ = JSTypes.intToDouble(rhsNodeValue_int);
            } else if ((state & 0b10110000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not doBoolean(VirtualFrame, boolean) && doInt(VirtualFrame, int) && doSafeIntegerInt(VirtualFrame, int) && doSafeInteger(VirtualFrame, SafeInteger) && doLong(VirtualFrame, long) && doDouble(VirtualFrame, double) && doObject(VirtualFrame, Object) */) {
                rhsNodeValue_ = super.rhsNode.executeDouble(frameValue);
            } else {
                Object rhsNodeValue__ = super.rhsNode.execute(frameValue);
                rhsNodeValue_ = JSTypesGen.expectImplicitDouble((state & 0b11110000000) >>> 7 /* extract-implicit-active 0:double */, rhsNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(frameValue, ex.getResult());
        }
        assert (state & 0b100000) != 0 /* is-active doDouble(VirtualFrame, double) */;
        if ((isDoubleKind(frameValue))) {
            return doDouble(frameValue, rhsNodeValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(frameValue, ((state & 0b11100000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not doBoolean(VirtualFrame, boolean) && doInt(VirtualFrame, int) && doSafeIntegerInt(VirtualFrame, int) && doSafeInteger(VirtualFrame, SafeInteger) && doLong(VirtualFrame, long) && doDouble(VirtualFrame, double) && doObject(VirtualFrame, Object) */ ? (Object) rhsNodeValue_long : ((state & 0b11010000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not doBoolean(VirtualFrame, boolean) && doInt(VirtualFrame, int) && doSafeIntegerInt(VirtualFrame, int) && doSafeInteger(VirtualFrame, SafeInteger) && doLong(VirtualFrame, long) && doDouble(VirtualFrame, double) && doObject(VirtualFrame, Object) */ ? (Object) rhsNodeValue_int : (Object) rhsNodeValue_)));
    }

    private Object execute_generic4(VirtualFrame frameValue, int state) {
        Object rhsNodeValue_ = super.rhsNode.execute(frameValue);
        if ((state & 0b1) != 0 /* is-active doBoolean(VirtualFrame, boolean) */ && rhsNodeValue_ instanceof Boolean) {
            boolean rhsNodeValue__ = (boolean) rhsNodeValue_;
            if ((isBooleanKind(frameValue))) {
                return doBoolean(frameValue, rhsNodeValue__);
            }
        }
        if ((state & 0b110) != 0 /* is-active doInt(VirtualFrame, int) || doSafeIntegerInt(VirtualFrame, int) */ && rhsNodeValue_ instanceof Integer) {
            int rhsNodeValue__ = (int) rhsNodeValue_;
            if ((state & 0b10) != 0 /* is-active doInt(VirtualFrame, int) */) {
                if ((isIntegerKind(frameValue))) {
                    return doInt(frameValue, rhsNodeValue__);
                }
            }
            if ((state & 0b100) != 0 /* is-active doSafeIntegerInt(VirtualFrame, int) */) {
                if ((isLongKind(frameValue))) {
                    return doSafeIntegerInt(frameValue, rhsNodeValue__);
                }
            }
        }
        if ((state & 0b1000) != 0 /* is-active doSafeInteger(VirtualFrame, SafeInteger) */ && rhsNodeValue_ instanceof SafeInteger) {
            SafeInteger rhsNodeValue__ = (SafeInteger) rhsNodeValue_;
            if ((isLongKind(frameValue))) {
                return doSafeInteger(frameValue, rhsNodeValue__);
            }
        }
        if ((state & 0b10000) != 0 /* is-active doLong(VirtualFrame, long) */ && rhsNodeValue_ instanceof Long) {
            long rhsNodeValue__ = (long) rhsNodeValue_;
            if ((ensureObjectKind(frameValue))) {
                return doLong(frameValue, rhsNodeValue__);
            }
        }
        if ((state & 0b100000) != 0 /* is-active doDouble(VirtualFrame, double) */ && JSTypesGen.isImplicitDouble((state & 0b11110000000) >>> 7 /* extract-implicit-active 0:double */, rhsNodeValue_)) {
            double rhsNodeValue__ = JSTypesGen.asImplicitDouble((state & 0b11110000000) >>> 7 /* extract-implicit-active 0:double */, rhsNodeValue_);
            if ((isDoubleKind(frameValue))) {
                return doDouble(frameValue, rhsNodeValue__);
            }
        }
        if ((state & 0b1000000) != 0 /* is-active doObject(VirtualFrame, Object) */) {
            if ((ensureObjectKind(frameValue))) {
                return doObject(frameValue, rhsNodeValue_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(frameValue, rhsNodeValue_);
    }

    @Override
    public boolean executeBoolean(VirtualFrame frameValue) throws UnexpectedResultException {
        int state = state_;
        if ((state & 0b1000000) != 0 /* is-active doObject(VirtualFrame, Object) */) {
            return JSTypesGen.expectBoolean(execute(frameValue));
        }
        boolean rhsNodeValue_;
        try {
            rhsNodeValue_ = super.rhsNode.executeBoolean(frameValue);
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectBoolean(executeAndSpecialize(frameValue, ex.getResult()));
        }
        if ((state & 0b1) != 0 /* is-active doBoolean(VirtualFrame, boolean) */) {
            if ((isBooleanKind(frameValue))) {
                return doBoolean(frameValue, rhsNodeValue_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectBoolean(executeAndSpecialize(frameValue, rhsNodeValue_));
    }

    @Override
    public double executeDouble(VirtualFrame frameValue) throws UnexpectedResultException {
        int state = state_;
        if ((state & 0b1000000) != 0 /* is-active doObject(VirtualFrame, Object) */) {
            return JSTypesGen.expectDouble(execute(frameValue));
        }
        int rhsNodeValue_int = 0;
        long rhsNodeValue_long = 0L;
        double rhsNodeValue_;
        try {
            if ((state & 0b11100000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not doBoolean(VirtualFrame, boolean) && doInt(VirtualFrame, int) && doSafeIntegerInt(VirtualFrame, int) && doSafeInteger(VirtualFrame, SafeInteger) && doLong(VirtualFrame, long) && doDouble(VirtualFrame, double) && doObject(VirtualFrame, Object) */) {
                rhsNodeValue_long = super.rhsNode.executeLong(frameValue);
                rhsNodeValue_ = JSTypes.longToDouble(rhsNodeValue_long);
            } else if ((state & 0b11010000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not doBoolean(VirtualFrame, boolean) && doInt(VirtualFrame, int) && doSafeIntegerInt(VirtualFrame, int) && doSafeInteger(VirtualFrame, SafeInteger) && doLong(VirtualFrame, long) && doDouble(VirtualFrame, double) && doObject(VirtualFrame, Object) */) {
                rhsNodeValue_int = super.rhsNode.executeInt(frameValue);
                rhsNodeValue_ = JSTypes.intToDouble(rhsNodeValue_int);
            } else if ((state & 0b10110000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not doBoolean(VirtualFrame, boolean) && doInt(VirtualFrame, int) && doSafeIntegerInt(VirtualFrame, int) && doSafeInteger(VirtualFrame, SafeInteger) && doLong(VirtualFrame, long) && doDouble(VirtualFrame, double) && doObject(VirtualFrame, Object) */) {
                rhsNodeValue_ = super.rhsNode.executeDouble(frameValue);
            } else {
                Object rhsNodeValue__ = super.rhsNode.execute(frameValue);
                rhsNodeValue_ = JSTypesGen.expectImplicitDouble((state & 0b11110000000) >>> 7 /* extract-implicit-active 0:double */, rhsNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectDouble(executeAndSpecialize(frameValue, ex.getResult()));
        }
        if ((state & 0b100000) != 0 /* is-active doDouble(VirtualFrame, double) */) {
            if ((isDoubleKind(frameValue))) {
                return doDouble(frameValue, rhsNodeValue_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectDouble(executeAndSpecialize(frameValue, ((state & 0b11100000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not doBoolean(VirtualFrame, boolean) && doInt(VirtualFrame, int) && doSafeIntegerInt(VirtualFrame, int) && doSafeInteger(VirtualFrame, SafeInteger) && doLong(VirtualFrame, long) && doDouble(VirtualFrame, double) && doObject(VirtualFrame, Object) */ ? (Object) rhsNodeValue_long : ((state & 0b11010000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not doBoolean(VirtualFrame, boolean) && doInt(VirtualFrame, int) && doSafeIntegerInt(VirtualFrame, int) && doSafeInteger(VirtualFrame, SafeInteger) && doLong(VirtualFrame, long) && doDouble(VirtualFrame, double) && doObject(VirtualFrame, Object) */ ? (Object) rhsNodeValue_int : (Object) rhsNodeValue_))));
    }

    @Override
    public int executeInt(VirtualFrame frameValue) throws UnexpectedResultException {
        int state = state_;
        if ((state & 0b1000000) != 0 /* is-active doObject(VirtualFrame, Object) */) {
            return JSTypesGen.expectInteger(execute(frameValue));
        }
        int rhsNodeValue_;
        try {
            rhsNodeValue_ = super.rhsNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectInteger(executeAndSpecialize(frameValue, ex.getResult()));
        }
        if ((state & 0b10) != 0 /* is-active doInt(VirtualFrame, int) */) {
            if ((isIntegerKind(frameValue))) {
                return doInt(frameValue, rhsNodeValue_);
            }
        }
        if ((state & 0b100) != 0 /* is-active doSafeIntegerInt(VirtualFrame, int) */) {
            if ((isLongKind(frameValue))) {
                return doSafeIntegerInt(frameValue, rhsNodeValue_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectInteger(executeAndSpecialize(frameValue, rhsNodeValue_));
    }

    @Override
    public long executeLong(VirtualFrame frameValue) throws UnexpectedResultException {
        int state = state_;
        if ((state & 0b1000000) != 0 /* is-active doObject(VirtualFrame, Object) */) {
            return JSTypesGen.expectLong(execute(frameValue));
        }
        long rhsNodeValue_;
        try {
            rhsNodeValue_ = super.rhsNode.executeLong(frameValue);
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectLong(executeAndSpecialize(frameValue, ex.getResult()));
        }
        if ((state & 0b10000) != 0 /* is-active doLong(VirtualFrame, long) */) {
            if ((ensureObjectKind(frameValue))) {
                return doLong(frameValue, rhsNodeValue_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectLong(executeAndSpecialize(frameValue, rhsNodeValue_));
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        int state = state_;
        try {
            if ((state & 0b1101111) == 0 /* only-active doLong(VirtualFrame, long) */ && (state & 0b1111111) != 0  /* is-not doBoolean(VirtualFrame, boolean) && doInt(VirtualFrame, int) && doSafeIntegerInt(VirtualFrame, int) && doSafeInteger(VirtualFrame, SafeInteger) && doLong(VirtualFrame, long) && doDouble(VirtualFrame, double) && doObject(VirtualFrame, Object) */) {
                executeLong(frameValue);
                return;
            } else if ((state & 0b1111001) == 0 /* only-active doInt(VirtualFrame, int) && doSafeIntegerInt(VirtualFrame, int) */ && (state & 0b1111111) != 0  /* is-not doBoolean(VirtualFrame, boolean) && doInt(VirtualFrame, int) && doSafeIntegerInt(VirtualFrame, int) && doSafeInteger(VirtualFrame, SafeInteger) && doLong(VirtualFrame, long) && doDouble(VirtualFrame, double) && doObject(VirtualFrame, Object) */) {
                executeInt(frameValue);
                return;
            } else if ((state & 0b1011111) == 0 /* only-active doDouble(VirtualFrame, double) */ && (state & 0b1111111) != 0  /* is-not doBoolean(VirtualFrame, boolean) && doInt(VirtualFrame, int) && doSafeIntegerInt(VirtualFrame, int) && doSafeInteger(VirtualFrame, SafeInteger) && doLong(VirtualFrame, long) && doDouble(VirtualFrame, double) && doObject(VirtualFrame, Object) */) {
                executeDouble(frameValue);
                return;
            } else if ((state & 0b1111110) == 0 /* only-active doBoolean(VirtualFrame, boolean) */ && (state & 0b1111111) != 0  /* is-not doBoolean(VirtualFrame, boolean) && doInt(VirtualFrame, int) && doSafeIntegerInt(VirtualFrame, int) && doSafeInteger(VirtualFrame, SafeInteger) && doLong(VirtualFrame, long) && doDouble(VirtualFrame, double) && doObject(VirtualFrame, Object) */) {
                executeBoolean(frameValue);
                return;
            }
            execute(frameValue);
            return;
        } catch (UnexpectedResultException ex) {
            return;
        }
    }

    private Object executeAndSpecialize(VirtualFrame frameValue, Object rhsNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        int exclude = exclude_;
        try {
            if (((exclude & 0b1)) == 0 /* is-not-excluded doBoolean(VirtualFrame, boolean) */ && rhsNodeValue instanceof Boolean) {
                boolean rhsNodeValue_ = (boolean) rhsNodeValue;
                if ((isBooleanKind(frameValue))) {
                    this.state_ = state = state | 0b1 /* add-active doBoolean(VirtualFrame, boolean) */;
                    lock.unlock();
                    hasLock = false;
                    return doBoolean(frameValue, rhsNodeValue_);
                }
            }
            if (rhsNodeValue instanceof Integer) {
                int rhsNodeValue_ = (int) rhsNodeValue;
                if (((exclude & 0b10)) == 0 /* is-not-excluded doInt(VirtualFrame, int) */) {
                    if ((isIntegerKind(frameValue))) {
                        this.state_ = state = state | 0b10 /* add-active doInt(VirtualFrame, int) */;
                        lock.unlock();
                        hasLock = false;
                        return doInt(frameValue, rhsNodeValue_);
                    }
                }
                if (((exclude & 0b100)) == 0 /* is-not-excluded doSafeIntegerInt(VirtualFrame, int) */) {
                    if ((isLongKind(frameValue))) {
                        this.state_ = state = state | 0b100 /* add-active doSafeIntegerInt(VirtualFrame, int) */;
                        lock.unlock();
                        hasLock = false;
                        return doSafeIntegerInt(frameValue, rhsNodeValue_);
                    }
                }
            }
            if (((exclude & 0b1000)) == 0 /* is-not-excluded doSafeInteger(VirtualFrame, SafeInteger) */ && rhsNodeValue instanceof SafeInteger) {
                SafeInteger rhsNodeValue_ = (SafeInteger) rhsNodeValue;
                if ((isLongKind(frameValue))) {
                    this.state_ = state = state | 0b1000 /* add-active doSafeInteger(VirtualFrame, SafeInteger) */;
                    lock.unlock();
                    hasLock = false;
                    return doSafeInteger(frameValue, rhsNodeValue_);
                }
            }
            if (((exclude & 0b10000)) == 0 /* is-not-excluded doLong(VirtualFrame, long) */ && rhsNodeValue instanceof Long) {
                long rhsNodeValue_ = (long) rhsNodeValue;
                if ((ensureObjectKind(frameValue))) {
                    this.state_ = state = state | 0b10000 /* add-active doLong(VirtualFrame, long) */;
                    lock.unlock();
                    hasLock = false;
                    return doLong(frameValue, rhsNodeValue_);
                }
            }
            if (((exclude & 0b100000)) == 0 /* is-not-excluded doDouble(VirtualFrame, double) */) {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(rhsNodeValue)) != 0) {
                    double rhsNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast0, rhsNodeValue);
                    if ((isDoubleKind(frameValue))) {
                        this.exclude_ = exclude = exclude | 0b1110 /* add-excluded doInt(VirtualFrame, int), doSafeIntegerInt(VirtualFrame, int), doSafeInteger(VirtualFrame, SafeInteger) */;
                        state = state & 0xfffffff1 /* remove-active doInt(VirtualFrame, int), doSafeIntegerInt(VirtualFrame, int), doSafeInteger(VirtualFrame, SafeInteger) */;
                        state = (state | (doubleCast0 << 7) /* set-implicit-active 0:double */);
                        this.state_ = state = state | 0b100000 /* add-active doDouble(VirtualFrame, double) */;
                        lock.unlock();
                        hasLock = false;
                        return doDouble(frameValue, rhsNodeValue_);
                    }
                }
            }
            if ((ensureObjectKind(frameValue))) {
                this.exclude_ = exclude = exclude | 0b111111 /* add-excluded doBoolean(VirtualFrame, boolean), doInt(VirtualFrame, int), doSafeIntegerInt(VirtualFrame, int), doSafeInteger(VirtualFrame, SafeInteger), doLong(VirtualFrame, long), doDouble(VirtualFrame, double) */;
                state = state & 0xffffffc0 /* remove-active doBoolean(VirtualFrame, boolean), doInt(VirtualFrame, int), doSafeIntegerInt(VirtualFrame, int), doSafeInteger(VirtualFrame, SafeInteger), doLong(VirtualFrame, long), doDouble(VirtualFrame, double) */;
                this.state_ = state = state | 0b1000000 /* add-active doObject(VirtualFrame, Object) */;
                lock.unlock();
                hasLock = false;
                return doObject(frameValue, rhsNodeValue);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {super.rhsNode}, rhsNodeValue);
        } finally {
            if (hasLock) {
                lock.unlock();
            }
        }
    }

    @Override
    public NodeCost getCost() {
        int state = state_;
        if ((state & 0b1111111) == 0b0) {
            return NodeCost.UNINITIALIZED;
        } else if (((state & 0b1111111) & ((state & 0b1111111) - 1)) == 0 /* is-single-active  */) {
            return NodeCost.MONOMORPHIC;
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[8];
        Object[] s;
        data[0] = 0;
        int state = state_;
        int exclude = exclude_;
        s = new Object[3];
        s[0] = "doBoolean";
        if ((state & 0b1) != 0 /* is-active doBoolean(VirtualFrame, boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b1) != 0 /* is-excluded doBoolean(VirtualFrame, boolean) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doInt";
        if ((state & 0b10) != 0 /* is-active doInt(VirtualFrame, int) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b10) != 0 /* is-excluded doInt(VirtualFrame, int) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doSafeIntegerInt";
        if ((state & 0b100) != 0 /* is-active doSafeIntegerInt(VirtualFrame, int) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b100) != 0 /* is-excluded doSafeIntegerInt(VirtualFrame, int) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doSafeInteger";
        if ((state & 0b1000) != 0 /* is-active doSafeInteger(VirtualFrame, SafeInteger) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b1000) != 0 /* is-excluded doSafeInteger(VirtualFrame, SafeInteger) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doLong";
        if ((state & 0b10000) != 0 /* is-active doLong(VirtualFrame, long) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b10000) != 0 /* is-excluded doLong(VirtualFrame, long) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "doDouble";
        if ((state & 0b100000) != 0 /* is-active doDouble(VirtualFrame, double) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b100000) != 0 /* is-excluded doDouble(VirtualFrame, double) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "doObject";
        if ((state & 0b1000000) != 0 /* is-active doObject(VirtualFrame, Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        return Provider.create(data);
    }

    public static JSWriteCurrentFrameSlotNode create(FrameSlot frameSlot, JavaScriptNode rhsNode) {
        return new JSWriteCurrentFrameSlotNodeGen(frameSlot, rhsNode);
    }

}
