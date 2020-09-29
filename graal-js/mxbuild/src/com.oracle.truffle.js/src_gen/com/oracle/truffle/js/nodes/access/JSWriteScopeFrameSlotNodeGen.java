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
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.runtime.SafeInteger;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSWriteScopeFrameSlotNode.class)
final class JSWriteScopeFrameSlotNodeGen extends JSWriteScopeFrameSlotNode implements Provider {

    @CompilationFinal private int state_;
    @CompilationFinal private int exclude_;

    private JSWriteScopeFrameSlotNodeGen(FrameSlot frameSlot, ScopeFrameNode scopeFrameNode, JavaScriptNode rhsNode) {
        super(frameSlot, scopeFrameNode, rhsNode);
    }

    @Override
    Object executeEvaluated(VirtualFrame frameValue, Frame scopeFrameNodeValue, Object rhsNodeValue) {
        int state = state_;
        if ((state & 0b1111111) != 0 /* is-active doBoolean(Frame, boolean) || doInt(Frame, int) || doSafeIntegerInt(Frame, int) || doSafeInteger(Frame, SafeInteger) || doLong(Frame, long) || doDouble(Frame, double) || doObject(Frame, Object) */) {
            if ((state & 0b1) != 0 /* is-active doBoolean(Frame, boolean) */ && rhsNodeValue instanceof Boolean) {
                boolean rhsNodeValue_ = (boolean) rhsNodeValue;
                if ((isBooleanKind(scopeFrameNodeValue))) {
                    return doBoolean(scopeFrameNodeValue, rhsNodeValue_);
                }
            }
            if ((state & 0b110) != 0 /* is-active doInt(Frame, int) || doSafeIntegerInt(Frame, int) */ && rhsNodeValue instanceof Integer) {
                int rhsNodeValue_ = (int) rhsNodeValue;
                if ((state & 0b10) != 0 /* is-active doInt(Frame, int) */) {
                    if ((isIntegerKind(scopeFrameNodeValue))) {
                        return doInt(scopeFrameNodeValue, rhsNodeValue_);
                    }
                }
                if ((state & 0b100) != 0 /* is-active doSafeIntegerInt(Frame, int) */) {
                    if ((isLongKind(scopeFrameNodeValue))) {
                        return doSafeIntegerInt(scopeFrameNodeValue, rhsNodeValue_);
                    }
                }
            }
            if ((state & 0b1000) != 0 /* is-active doSafeInteger(Frame, SafeInteger) */ && rhsNodeValue instanceof SafeInteger) {
                SafeInteger rhsNodeValue_ = (SafeInteger) rhsNodeValue;
                if ((isLongKind(scopeFrameNodeValue))) {
                    return doSafeInteger(scopeFrameNodeValue, rhsNodeValue_);
                }
            }
            if ((state & 0b10000) != 0 /* is-active doLong(Frame, long) */ && rhsNodeValue instanceof Long) {
                long rhsNodeValue_ = (long) rhsNodeValue;
                if ((ensureObjectKind(scopeFrameNodeValue))) {
                    return doLong(scopeFrameNodeValue, rhsNodeValue_);
                }
            }
            if ((state & 0b100000) != 0 /* is-active doDouble(Frame, double) */ && JSTypesGen.isImplicitDouble((state & 0b11110000000) >>> 7 /* extract-implicit-active 1:double */, rhsNodeValue)) {
                double rhsNodeValue_ = JSTypesGen.asImplicitDouble((state & 0b11110000000) >>> 7 /* extract-implicit-active 1:double */, rhsNodeValue);
                if ((isDoubleKind(scopeFrameNodeValue))) {
                    return doDouble(scopeFrameNodeValue, rhsNodeValue_);
                }
            }
            if ((state & 0b1000000) != 0 /* is-active doObject(Frame, Object) */) {
                if ((ensureObjectKind(scopeFrameNodeValue))) {
                    return doObject(scopeFrameNodeValue, rhsNodeValue);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(scopeFrameNodeValue, rhsNodeValue);
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        int state = state_;
        Frame scopeFrameNodeValue_ = super.scopeFrameNode.executeFrame(frameValue);
        if ((state & 0b1111110) == 0 /* only-active doBoolean(Frame, boolean) */ && (state & 0b1111111) != 0  /* is-not doBoolean(Frame, boolean) && doInt(Frame, int) && doSafeIntegerInt(Frame, int) && doSafeInteger(Frame, SafeInteger) && doLong(Frame, long) && doDouble(Frame, double) && doObject(Frame, Object) */) {
            return execute_boolean0(frameValue, state, scopeFrameNodeValue_);
        } else if ((state & 0b1111001) == 0 /* only-active doInt(Frame, int) && doSafeIntegerInt(Frame, int) */ && (state & 0b1111111) != 0  /* is-not doBoolean(Frame, boolean) && doInt(Frame, int) && doSafeIntegerInt(Frame, int) && doSafeInteger(Frame, SafeInteger) && doLong(Frame, long) && doDouble(Frame, double) && doObject(Frame, Object) */) {
            return execute_int1(frameValue, state, scopeFrameNodeValue_);
        } else if ((state & 0b1101111) == 0 /* only-active doLong(Frame, long) */ && (state & 0b1111111) != 0  /* is-not doBoolean(Frame, boolean) && doInt(Frame, int) && doSafeIntegerInt(Frame, int) && doSafeInteger(Frame, SafeInteger) && doLong(Frame, long) && doDouble(Frame, double) && doObject(Frame, Object) */) {
            return execute_long2(frameValue, state, scopeFrameNodeValue_);
        } else if ((state & 0b1011111) == 0 /* only-active doDouble(Frame, double) */ && (state & 0b1111111) != 0  /* is-not doBoolean(Frame, boolean) && doInt(Frame, int) && doSafeIntegerInt(Frame, int) && doSafeInteger(Frame, SafeInteger) && doLong(Frame, long) && doDouble(Frame, double) && doObject(Frame, Object) */) {
            return execute_double3(frameValue, state, scopeFrameNodeValue_);
        } else {
            return execute_generic4(frameValue, state, scopeFrameNodeValue_);
        }
    }

    private Object execute_boolean0(VirtualFrame frameValue, int state, Frame scopeFrameNodeValue_) {
        boolean rhsNodeValue_;
        try {
            rhsNodeValue_ = super.rhsNode.executeBoolean(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(scopeFrameNodeValue_, ex.getResult());
        }
        assert (state & 0b1) != 0 /* is-active doBoolean(Frame, boolean) */;
        if ((isBooleanKind(scopeFrameNodeValue_))) {
            return doBoolean(scopeFrameNodeValue_, rhsNodeValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(scopeFrameNodeValue_, rhsNodeValue_);
    }

    private Object execute_int1(VirtualFrame frameValue, int state, Frame scopeFrameNodeValue_) {
        int rhsNodeValue_;
        try {
            rhsNodeValue_ = super.rhsNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(scopeFrameNodeValue_, ex.getResult());
        }
        if ((state & 0b110) != 0 /* is-active doInt(Frame, int) || doSafeIntegerInt(Frame, int) */) {
            if ((state & 0b10) != 0 /* is-active doInt(Frame, int) */) {
                if ((isIntegerKind(scopeFrameNodeValue_))) {
                    return doInt(scopeFrameNodeValue_, rhsNodeValue_);
                }
            }
            if ((state & 0b100) != 0 /* is-active doSafeIntegerInt(Frame, int) */) {
                if ((isLongKind(scopeFrameNodeValue_))) {
                    return doSafeIntegerInt(scopeFrameNodeValue_, rhsNodeValue_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(scopeFrameNodeValue_, rhsNodeValue_);
    }

    private Object execute_long2(VirtualFrame frameValue, int state, Frame scopeFrameNodeValue_) {
        long rhsNodeValue_;
        try {
            rhsNodeValue_ = super.rhsNode.executeLong(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(scopeFrameNodeValue_, ex.getResult());
        }
        assert (state & 0b10000) != 0 /* is-active doLong(Frame, long) */;
        if ((ensureObjectKind(scopeFrameNodeValue_))) {
            return doLong(scopeFrameNodeValue_, rhsNodeValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(scopeFrameNodeValue_, rhsNodeValue_);
    }

    private Object execute_double3(VirtualFrame frameValue, int state, Frame scopeFrameNodeValue_) {
        int rhsNodeValue_int = 0;
        long rhsNodeValue_long = 0L;
        double rhsNodeValue_;
        try {
            if ((state & 0b11100000000) == 0 /* only-active 1:double */ && (state & 0b1111111) != 0  /* is-not doBoolean(Frame, boolean) && doInt(Frame, int) && doSafeIntegerInt(Frame, int) && doSafeInteger(Frame, SafeInteger) && doLong(Frame, long) && doDouble(Frame, double) && doObject(Frame, Object) */) {
                rhsNodeValue_long = super.rhsNode.executeLong(frameValue);
                rhsNodeValue_ = JSTypes.longToDouble(rhsNodeValue_long);
            } else if ((state & 0b11010000000) == 0 /* only-active 1:double */ && (state & 0b1111111) != 0  /* is-not doBoolean(Frame, boolean) && doInt(Frame, int) && doSafeIntegerInt(Frame, int) && doSafeInteger(Frame, SafeInteger) && doLong(Frame, long) && doDouble(Frame, double) && doObject(Frame, Object) */) {
                rhsNodeValue_int = super.rhsNode.executeInt(frameValue);
                rhsNodeValue_ = JSTypes.intToDouble(rhsNodeValue_int);
            } else if ((state & 0b10110000000) == 0 /* only-active 1:double */ && (state & 0b1111111) != 0  /* is-not doBoolean(Frame, boolean) && doInt(Frame, int) && doSafeIntegerInt(Frame, int) && doSafeInteger(Frame, SafeInteger) && doLong(Frame, long) && doDouble(Frame, double) && doObject(Frame, Object) */) {
                rhsNodeValue_ = super.rhsNode.executeDouble(frameValue);
            } else {
                Object rhsNodeValue__ = super.rhsNode.execute(frameValue);
                rhsNodeValue_ = JSTypesGen.expectImplicitDouble((state & 0b11110000000) >>> 7 /* extract-implicit-active 1:double */, rhsNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(scopeFrameNodeValue_, ex.getResult());
        }
        assert (state & 0b100000) != 0 /* is-active doDouble(Frame, double) */;
        if ((isDoubleKind(scopeFrameNodeValue_))) {
            return doDouble(scopeFrameNodeValue_, rhsNodeValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(scopeFrameNodeValue_, ((state & 0b11100000000) == 0 /* only-active 1:double */ && (state & 0b1111111) != 0  /* is-not doBoolean(Frame, boolean) && doInt(Frame, int) && doSafeIntegerInt(Frame, int) && doSafeInteger(Frame, SafeInteger) && doLong(Frame, long) && doDouble(Frame, double) && doObject(Frame, Object) */ ? (Object) rhsNodeValue_long : ((state & 0b11010000000) == 0 /* only-active 1:double */ && (state & 0b1111111) != 0  /* is-not doBoolean(Frame, boolean) && doInt(Frame, int) && doSafeIntegerInt(Frame, int) && doSafeInteger(Frame, SafeInteger) && doLong(Frame, long) && doDouble(Frame, double) && doObject(Frame, Object) */ ? (Object) rhsNodeValue_int : (Object) rhsNodeValue_)));
    }

    private Object execute_generic4(VirtualFrame frameValue, int state, Frame scopeFrameNodeValue_) {
        Object rhsNodeValue_ = super.rhsNode.execute(frameValue);
        if ((state & 0b1111111) != 0 /* is-active doBoolean(Frame, boolean) || doInt(Frame, int) || doSafeIntegerInt(Frame, int) || doSafeInteger(Frame, SafeInteger) || doLong(Frame, long) || doDouble(Frame, double) || doObject(Frame, Object) */) {
            if ((state & 0b1) != 0 /* is-active doBoolean(Frame, boolean) */ && rhsNodeValue_ instanceof Boolean) {
                boolean rhsNodeValue__ = (boolean) rhsNodeValue_;
                if ((isBooleanKind(scopeFrameNodeValue_))) {
                    return doBoolean(scopeFrameNodeValue_, rhsNodeValue__);
                }
            }
            if ((state & 0b110) != 0 /* is-active doInt(Frame, int) || doSafeIntegerInt(Frame, int) */ && rhsNodeValue_ instanceof Integer) {
                int rhsNodeValue__ = (int) rhsNodeValue_;
                if ((state & 0b10) != 0 /* is-active doInt(Frame, int) */) {
                    if ((isIntegerKind(scopeFrameNodeValue_))) {
                        return doInt(scopeFrameNodeValue_, rhsNodeValue__);
                    }
                }
                if ((state & 0b100) != 0 /* is-active doSafeIntegerInt(Frame, int) */) {
                    if ((isLongKind(scopeFrameNodeValue_))) {
                        return doSafeIntegerInt(scopeFrameNodeValue_, rhsNodeValue__);
                    }
                }
            }
            if ((state & 0b1000) != 0 /* is-active doSafeInteger(Frame, SafeInteger) */ && rhsNodeValue_ instanceof SafeInteger) {
                SafeInteger rhsNodeValue__ = (SafeInteger) rhsNodeValue_;
                if ((isLongKind(scopeFrameNodeValue_))) {
                    return doSafeInteger(scopeFrameNodeValue_, rhsNodeValue__);
                }
            }
            if ((state & 0b10000) != 0 /* is-active doLong(Frame, long) */ && rhsNodeValue_ instanceof Long) {
                long rhsNodeValue__ = (long) rhsNodeValue_;
                if ((ensureObjectKind(scopeFrameNodeValue_))) {
                    return doLong(scopeFrameNodeValue_, rhsNodeValue__);
                }
            }
            if ((state & 0b100000) != 0 /* is-active doDouble(Frame, double) */ && JSTypesGen.isImplicitDouble((state & 0b11110000000) >>> 7 /* extract-implicit-active 1:double */, rhsNodeValue_)) {
                double rhsNodeValue__ = JSTypesGen.asImplicitDouble((state & 0b11110000000) >>> 7 /* extract-implicit-active 1:double */, rhsNodeValue_);
                if ((isDoubleKind(scopeFrameNodeValue_))) {
                    return doDouble(scopeFrameNodeValue_, rhsNodeValue__);
                }
            }
            if ((state & 0b1000000) != 0 /* is-active doObject(Frame, Object) */) {
                if ((ensureObjectKind(scopeFrameNodeValue_))) {
                    return doObject(scopeFrameNodeValue_, rhsNodeValue_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(scopeFrameNodeValue_, rhsNodeValue_);
    }

    @Override
    public boolean executeBoolean(VirtualFrame frameValue) throws UnexpectedResultException {
        int state = state_;
        if ((state & 0b1000000) != 0 /* is-active doObject(Frame, Object) */) {
            return JSTypesGen.expectBoolean(execute(frameValue));
        }
        Frame scopeFrameNodeValue_ = super.scopeFrameNode.executeFrame(frameValue);
        boolean rhsNodeValue_;
        try {
            rhsNodeValue_ = super.rhsNode.executeBoolean(frameValue);
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectBoolean(executeAndSpecialize(scopeFrameNodeValue_, ex.getResult()));
        }
        if ((state & 0b1) != 0 /* is-active doBoolean(Frame, boolean) */) {
            if ((isBooleanKind(scopeFrameNodeValue_))) {
                return doBoolean(scopeFrameNodeValue_, rhsNodeValue_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectBoolean(executeAndSpecialize(scopeFrameNodeValue_, rhsNodeValue_));
    }

    @Override
    public double executeDouble(VirtualFrame frameValue) throws UnexpectedResultException {
        int state = state_;
        if ((state & 0b1000000) != 0 /* is-active doObject(Frame, Object) */) {
            return JSTypesGen.expectDouble(execute(frameValue));
        }
        Frame scopeFrameNodeValue_ = super.scopeFrameNode.executeFrame(frameValue);
        int rhsNodeValue_int = 0;
        long rhsNodeValue_long = 0L;
        double rhsNodeValue_;
        try {
            if ((state & 0b11100000000) == 0 /* only-active 1:double */ && (state & 0b1111111) != 0  /* is-not doBoolean(Frame, boolean) && doInt(Frame, int) && doSafeIntegerInt(Frame, int) && doSafeInteger(Frame, SafeInteger) && doLong(Frame, long) && doDouble(Frame, double) && doObject(Frame, Object) */) {
                rhsNodeValue_long = super.rhsNode.executeLong(frameValue);
                rhsNodeValue_ = JSTypes.longToDouble(rhsNodeValue_long);
            } else if ((state & 0b11010000000) == 0 /* only-active 1:double */ && (state & 0b1111111) != 0  /* is-not doBoolean(Frame, boolean) && doInt(Frame, int) && doSafeIntegerInt(Frame, int) && doSafeInteger(Frame, SafeInteger) && doLong(Frame, long) && doDouble(Frame, double) && doObject(Frame, Object) */) {
                rhsNodeValue_int = super.rhsNode.executeInt(frameValue);
                rhsNodeValue_ = JSTypes.intToDouble(rhsNodeValue_int);
            } else if ((state & 0b10110000000) == 0 /* only-active 1:double */ && (state & 0b1111111) != 0  /* is-not doBoolean(Frame, boolean) && doInt(Frame, int) && doSafeIntegerInt(Frame, int) && doSafeInteger(Frame, SafeInteger) && doLong(Frame, long) && doDouble(Frame, double) && doObject(Frame, Object) */) {
                rhsNodeValue_ = super.rhsNode.executeDouble(frameValue);
            } else {
                Object rhsNodeValue__ = super.rhsNode.execute(frameValue);
                rhsNodeValue_ = JSTypesGen.expectImplicitDouble((state & 0b11110000000) >>> 7 /* extract-implicit-active 1:double */, rhsNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectDouble(executeAndSpecialize(scopeFrameNodeValue_, ex.getResult()));
        }
        if ((state & 0b100000) != 0 /* is-active doDouble(Frame, double) */) {
            if ((isDoubleKind(scopeFrameNodeValue_))) {
                return doDouble(scopeFrameNodeValue_, rhsNodeValue_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectDouble(executeAndSpecialize(scopeFrameNodeValue_, ((state & 0b11100000000) == 0 /* only-active 1:double */ && (state & 0b1111111) != 0  /* is-not doBoolean(Frame, boolean) && doInt(Frame, int) && doSafeIntegerInt(Frame, int) && doSafeInteger(Frame, SafeInteger) && doLong(Frame, long) && doDouble(Frame, double) && doObject(Frame, Object) */ ? (Object) rhsNodeValue_long : ((state & 0b11010000000) == 0 /* only-active 1:double */ && (state & 0b1111111) != 0  /* is-not doBoolean(Frame, boolean) && doInt(Frame, int) && doSafeIntegerInt(Frame, int) && doSafeInteger(Frame, SafeInteger) && doLong(Frame, long) && doDouble(Frame, double) && doObject(Frame, Object) */ ? (Object) rhsNodeValue_int : (Object) rhsNodeValue_))));
    }

    @Override
    public int executeInt(VirtualFrame frameValue) throws UnexpectedResultException {
        int state = state_;
        if ((state & 0b1000000) != 0 /* is-active doObject(Frame, Object) */) {
            return JSTypesGen.expectInteger(execute(frameValue));
        }
        Frame scopeFrameNodeValue_ = super.scopeFrameNode.executeFrame(frameValue);
        int rhsNodeValue_;
        try {
            rhsNodeValue_ = super.rhsNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectInteger(executeAndSpecialize(scopeFrameNodeValue_, ex.getResult()));
        }
        if ((state & 0b110) != 0 /* is-active doInt(Frame, int) || doSafeIntegerInt(Frame, int) */) {
            if ((state & 0b10) != 0 /* is-active doInt(Frame, int) */) {
                if ((isIntegerKind(scopeFrameNodeValue_))) {
                    return doInt(scopeFrameNodeValue_, rhsNodeValue_);
                }
            }
            if ((state & 0b100) != 0 /* is-active doSafeIntegerInt(Frame, int) */) {
                if ((isLongKind(scopeFrameNodeValue_))) {
                    return doSafeIntegerInt(scopeFrameNodeValue_, rhsNodeValue_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectInteger(executeAndSpecialize(scopeFrameNodeValue_, rhsNodeValue_));
    }

    @Override
    public long executeLong(VirtualFrame frameValue) throws UnexpectedResultException {
        int state = state_;
        if ((state & 0b1000000) != 0 /* is-active doObject(Frame, Object) */) {
            return JSTypesGen.expectLong(execute(frameValue));
        }
        Frame scopeFrameNodeValue_ = super.scopeFrameNode.executeFrame(frameValue);
        long rhsNodeValue_;
        try {
            rhsNodeValue_ = super.rhsNode.executeLong(frameValue);
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectLong(executeAndSpecialize(scopeFrameNodeValue_, ex.getResult()));
        }
        if ((state & 0b10000) != 0 /* is-active doLong(Frame, long) */) {
            if ((ensureObjectKind(scopeFrameNodeValue_))) {
                return doLong(scopeFrameNodeValue_, rhsNodeValue_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectLong(executeAndSpecialize(scopeFrameNodeValue_, rhsNodeValue_));
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        int state = state_;
        try {
            if ((state & 0b1101111) == 0 /* only-active doLong(Frame, long) */ && (state & 0b1111111) != 0  /* is-not doBoolean(Frame, boolean) && doInt(Frame, int) && doSafeIntegerInt(Frame, int) && doSafeInteger(Frame, SafeInteger) && doLong(Frame, long) && doDouble(Frame, double) && doObject(Frame, Object) */) {
                executeLong(frameValue);
                return;
            } else if ((state & 0b1111001) == 0 /* only-active doInt(Frame, int) && doSafeIntegerInt(Frame, int) */ && (state & 0b1111111) != 0  /* is-not doBoolean(Frame, boolean) && doInt(Frame, int) && doSafeIntegerInt(Frame, int) && doSafeInteger(Frame, SafeInteger) && doLong(Frame, long) && doDouble(Frame, double) && doObject(Frame, Object) */) {
                executeInt(frameValue);
                return;
            } else if ((state & 0b1011111) == 0 /* only-active doDouble(Frame, double) */ && (state & 0b1111111) != 0  /* is-not doBoolean(Frame, boolean) && doInt(Frame, int) && doSafeIntegerInt(Frame, int) && doSafeInteger(Frame, SafeInteger) && doLong(Frame, long) && doDouble(Frame, double) && doObject(Frame, Object) */) {
                executeDouble(frameValue);
                return;
            } else if ((state & 0b1111110) == 0 /* only-active doBoolean(Frame, boolean) */ && (state & 0b1111111) != 0  /* is-not doBoolean(Frame, boolean) && doInt(Frame, int) && doSafeIntegerInt(Frame, int) && doSafeInteger(Frame, SafeInteger) && doLong(Frame, long) && doDouble(Frame, double) && doObject(Frame, Object) */) {
                executeBoolean(frameValue);
                return;
            }
            execute(frameValue);
            return;
        } catch (UnexpectedResultException ex) {
            return;
        }
    }

    private Object executeAndSpecialize(Frame scopeFrameNodeValue, Object rhsNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        int exclude = exclude_;
        try {
            if (((exclude & 0b1)) == 0 /* is-not-excluded doBoolean(Frame, boolean) */ && rhsNodeValue instanceof Boolean) {
                boolean rhsNodeValue_ = (boolean) rhsNodeValue;
                if ((isBooleanKind(scopeFrameNodeValue))) {
                    this.state_ = state = state | 0b1 /* add-active doBoolean(Frame, boolean) */;
                    lock.unlock();
                    hasLock = false;
                    return doBoolean(scopeFrameNodeValue, rhsNodeValue_);
                }
            }
            if (rhsNodeValue instanceof Integer) {
                int rhsNodeValue_ = (int) rhsNodeValue;
                if (((exclude & 0b10)) == 0 /* is-not-excluded doInt(Frame, int) */) {
                    if ((isIntegerKind(scopeFrameNodeValue))) {
                        this.state_ = state = state | 0b10 /* add-active doInt(Frame, int) */;
                        lock.unlock();
                        hasLock = false;
                        return doInt(scopeFrameNodeValue, rhsNodeValue_);
                    }
                }
                if (((exclude & 0b100)) == 0 /* is-not-excluded doSafeIntegerInt(Frame, int) */) {
                    if ((isLongKind(scopeFrameNodeValue))) {
                        this.state_ = state = state | 0b100 /* add-active doSafeIntegerInt(Frame, int) */;
                        lock.unlock();
                        hasLock = false;
                        return doSafeIntegerInt(scopeFrameNodeValue, rhsNodeValue_);
                    }
                }
            }
            if (((exclude & 0b1000)) == 0 /* is-not-excluded doSafeInteger(Frame, SafeInteger) */ && rhsNodeValue instanceof SafeInteger) {
                SafeInteger rhsNodeValue_ = (SafeInteger) rhsNodeValue;
                if ((isLongKind(scopeFrameNodeValue))) {
                    this.state_ = state = state | 0b1000 /* add-active doSafeInteger(Frame, SafeInteger) */;
                    lock.unlock();
                    hasLock = false;
                    return doSafeInteger(scopeFrameNodeValue, rhsNodeValue_);
                }
            }
            if (((exclude & 0b10000)) == 0 /* is-not-excluded doLong(Frame, long) */ && rhsNodeValue instanceof Long) {
                long rhsNodeValue_ = (long) rhsNodeValue;
                if ((ensureObjectKind(scopeFrameNodeValue))) {
                    this.state_ = state = state | 0b10000 /* add-active doLong(Frame, long) */;
                    lock.unlock();
                    hasLock = false;
                    return doLong(scopeFrameNodeValue, rhsNodeValue_);
                }
            }
            if (((exclude & 0b100000)) == 0 /* is-not-excluded doDouble(Frame, double) */) {
                int doubleCast1;
                if ((doubleCast1 = JSTypesGen.specializeImplicitDouble(rhsNodeValue)) != 0) {
                    double rhsNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast1, rhsNodeValue);
                    if ((isDoubleKind(scopeFrameNodeValue))) {
                        this.exclude_ = exclude = exclude | 0b1110 /* add-excluded doInt(Frame, int), doSafeIntegerInt(Frame, int), doSafeInteger(Frame, SafeInteger) */;
                        state = state & 0xfffffff1 /* remove-active doInt(Frame, int), doSafeIntegerInt(Frame, int), doSafeInteger(Frame, SafeInteger) */;
                        state = (state | (doubleCast1 << 7) /* set-implicit-active 1:double */);
                        this.state_ = state = state | 0b100000 /* add-active doDouble(Frame, double) */;
                        lock.unlock();
                        hasLock = false;
                        return doDouble(scopeFrameNodeValue, rhsNodeValue_);
                    }
                }
            }
            if ((ensureObjectKind(scopeFrameNodeValue))) {
                this.exclude_ = exclude = exclude | 0b111111 /* add-excluded doBoolean(Frame, boolean), doInt(Frame, int), doSafeIntegerInt(Frame, int), doSafeInteger(Frame, SafeInteger), doLong(Frame, long), doDouble(Frame, double) */;
                state = state & 0xffffffc0 /* remove-active doBoolean(Frame, boolean), doInt(Frame, int), doSafeIntegerInt(Frame, int), doSafeInteger(Frame, SafeInteger), doLong(Frame, long), doDouble(Frame, double) */;
                this.state_ = state = state | 0b1000000 /* add-active doObject(Frame, Object) */;
                lock.unlock();
                hasLock = false;
                return doObject(scopeFrameNodeValue, rhsNodeValue);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {super.scopeFrameNode, super.rhsNode}, scopeFrameNodeValue, rhsNodeValue);
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
        if ((state & 0b1) != 0 /* is-active doBoolean(Frame, boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b1) != 0 /* is-excluded doBoolean(Frame, boolean) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doInt";
        if ((state & 0b10) != 0 /* is-active doInt(Frame, int) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b10) != 0 /* is-excluded doInt(Frame, int) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doSafeIntegerInt";
        if ((state & 0b100) != 0 /* is-active doSafeIntegerInt(Frame, int) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b100) != 0 /* is-excluded doSafeIntegerInt(Frame, int) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doSafeInteger";
        if ((state & 0b1000) != 0 /* is-active doSafeInteger(Frame, SafeInteger) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b1000) != 0 /* is-excluded doSafeInteger(Frame, SafeInteger) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doLong";
        if ((state & 0b10000) != 0 /* is-active doLong(Frame, long) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b10000) != 0 /* is-excluded doLong(Frame, long) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "doDouble";
        if ((state & 0b100000) != 0 /* is-active doDouble(Frame, double) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b100000) != 0 /* is-excluded doDouble(Frame, double) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "doObject";
        if ((state & 0b1000000) != 0 /* is-active doObject(Frame, Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        return Provider.create(data);
    }

    public static JSWriteScopeFrameSlotNode create(FrameSlot frameSlot, ScopeFrameNode scopeFrameNode, JavaScriptNode rhsNode) {
        return new JSWriteScopeFrameSlotNodeGen(frameSlot, scopeFrameNode, rhsNode);
    }

}
