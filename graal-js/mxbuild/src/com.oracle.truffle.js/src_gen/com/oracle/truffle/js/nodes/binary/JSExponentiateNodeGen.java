// CheckStyle: start generated
package com.oracle.truffle.js.nodes.binary;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.cast.JSToNumericNode;
import com.oracle.truffle.js.runtime.BigInt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSExponentiateNode.class)
public final class JSExponentiateNodeGen extends JSExponentiateNode implements Provider {

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @Child private GenericData generic_cache;

    private JSExponentiateNodeGen(JavaScriptNode left, JavaScriptNode right) {
        super(left, right);
    }

    @Override
    public Object execute(Object leftNodeValue, Object rightNodeValue) {
        int state = state_;
        if ((state & 0b1) != 0 /* is-active doDouble(double, double) */ && JSTypesGen.isImplicitDouble((state & 0b1111000000) >>> 6 /* extract-implicit-active 0:double */, leftNodeValue)) {
            double leftNodeValue_ = JSTypesGen.asImplicitDouble((state & 0b1111000000) >>> 6 /* extract-implicit-active 0:double */, leftNodeValue);
            if (JSTypesGen.isImplicitDouble((state & 0b11110000000000) >>> 10 /* extract-implicit-active 1:double */, rightNodeValue)) {
                double rightNodeValue_ = JSTypesGen.asImplicitDouble((state & 0b11110000000000) >>> 10 /* extract-implicit-active 1:double */, rightNodeValue);
                return doDouble(leftNodeValue_, rightNodeValue_);
            }
        }
        if ((state & 0b11100) != 0 /* is-active doBigIntZero(BigInt, BigInt) || doBigIntZeroPowZero(BigInt, BigInt) || doBigInt(BigInt, BigInt) */ && leftNodeValue instanceof BigInt) {
            BigInt leftNodeValue_ = (BigInt) leftNodeValue;
            if (rightNodeValue instanceof BigInt) {
                BigInt rightNodeValue_ = (BigInt) rightNodeValue;
                if ((state & 0b100) != 0 /* is-active doBigIntZero(BigInt, BigInt) */) {
                    if ((JSGuards.isBigIntZero(leftNodeValue_)) && (!(JSGuards.isBigIntZero(rightNodeValue_))) && (!(JSGuards.isBigIntNegativeVal(rightNodeValue_)))) {
                        return doBigIntZero(leftNodeValue_, rightNodeValue_);
                    }
                }
                if ((state & 0b1000) != 0 /* is-active doBigIntZeroPowZero(BigInt, BigInt) */) {
                    if ((JSGuards.isBigIntZero(rightNodeValue_))) {
                        return doBigIntZeroPowZero(leftNodeValue_, rightNodeValue_);
                    }
                }
                if ((state & 0b10000) != 0 /* is-active doBigInt(BigInt, BigInt) */) {
                    if ((!(JSGuards.isBigIntZero(leftNodeValue_))) && (!(JSGuards.isBigIntZero(rightNodeValue_))) && (!(JSGuards.isBigIntNegativeVal(rightNodeValue_)))) {
                        return doBigInt(leftNodeValue_, rightNodeValue_);
                    }
                }
            }
        }
        if ((state & 0b100000) != 0 /* is-active doGeneric(Object, Object, JSExponentiateNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
            GenericData s6_ = this.generic_cache;
            if (s6_ != null) {
                return doGeneric(leftNodeValue, rightNodeValue, s6_.nestedExponentiateNode_, s6_.toNumeric1Node_, s6_.toNumeric2Node_, s6_.mixedNumericTypes_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(leftNodeValue, rightNodeValue);
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        int state = state_;
        if ((state & 0b111100) == 0 /* only-active doDouble(double, double) */ && (state & 0b111101) != 0  /* is-not doDouble(double, double) && doBigIntZero(BigInt, BigInt) && doBigIntZeroPowZero(BigInt, BigInt) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSExponentiateNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
            return execute_double_double0(frameValue, state);
        } else {
            return execute_generic1(frameValue, state);
        }
    }

    private Object execute_double_double0(VirtualFrame frameValue, int state) {
        int leftNodeValue_int = 0;
        long leftNodeValue_long = 0L;
        double leftNodeValue_;
        try {
            if ((state & 0b1110000000) == 0 /* only-active 0:double */ && (state & 0b111111) != 0  /* is-not doDouble(double, double) && doBigIntNegativeExponent(BigInt, BigInt) && doBigIntZero(BigInt, BigInt) && doBigIntZeroPowZero(BigInt, BigInt) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSExponentiateNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
                leftNodeValue_long = super.leftNode.executeLong(frameValue);
                leftNodeValue_ = JSTypes.longToDouble(leftNodeValue_long);
            } else if ((state & 0b1101000000) == 0 /* only-active 0:double */ && (state & 0b111111) != 0  /* is-not doDouble(double, double) && doBigIntNegativeExponent(BigInt, BigInt) && doBigIntZero(BigInt, BigInt) && doBigIntZeroPowZero(BigInt, BigInt) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSExponentiateNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
                leftNodeValue_int = super.leftNode.executeInt(frameValue);
                leftNodeValue_ = JSTypes.intToDouble(leftNodeValue_int);
            } else if ((state & 0b1011000000) == 0 /* only-active 0:double */ && (state & 0b111111) != 0  /* is-not doDouble(double, double) && doBigIntNegativeExponent(BigInt, BigInt) && doBigIntZero(BigInt, BigInt) && doBigIntZeroPowZero(BigInt, BigInt) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSExponentiateNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
                leftNodeValue_ = super.leftNode.executeDouble(frameValue);
            } else {
                Object leftNodeValue__ = super.leftNode.execute(frameValue);
                leftNodeValue_ = JSTypesGen.expectImplicitDouble((state & 0b1111000000) >>> 6 /* extract-implicit-active 0:double */, leftNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            Object rightNodeValue = super.rightNode.execute(frameValue);
            return executeAndSpecialize(ex.getResult(), rightNodeValue);
        }
        int rightNodeValue_int = 0;
        long rightNodeValue_long = 0L;
        double rightNodeValue_;
        try {
            if ((state & 0b11100000000000) == 0 /* only-active 1:double */ && (state & 0b111111) != 0  /* is-not doDouble(double, double) && doBigIntNegativeExponent(BigInt, BigInt) && doBigIntZero(BigInt, BigInt) && doBigIntZeroPowZero(BigInt, BigInt) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSExponentiateNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
                rightNodeValue_long = super.rightNode.executeLong(frameValue);
                rightNodeValue_ = JSTypes.longToDouble(rightNodeValue_long);
            } else if ((state & 0b11010000000000) == 0 /* only-active 1:double */ && (state & 0b111111) != 0  /* is-not doDouble(double, double) && doBigIntNegativeExponent(BigInt, BigInt) && doBigIntZero(BigInt, BigInt) && doBigIntZeroPowZero(BigInt, BigInt) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSExponentiateNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
                rightNodeValue_int = super.rightNode.executeInt(frameValue);
                rightNodeValue_ = JSTypes.intToDouble(rightNodeValue_int);
            } else if ((state & 0b10110000000000) == 0 /* only-active 1:double */ && (state & 0b111111) != 0  /* is-not doDouble(double, double) && doBigIntNegativeExponent(BigInt, BigInt) && doBigIntZero(BigInt, BigInt) && doBigIntZeroPowZero(BigInt, BigInt) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSExponentiateNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
                rightNodeValue_ = super.rightNode.executeDouble(frameValue);
            } else {
                Object rightNodeValue__ = super.rightNode.execute(frameValue);
                rightNodeValue_ = JSTypesGen.expectImplicitDouble((state & 0b11110000000000) >>> 10 /* extract-implicit-active 1:double */, rightNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(((state & 0b1110000000) == 0 /* only-active 0:double */ && (state & 0b111111) != 0  /* is-not doDouble(double, double) && doBigIntNegativeExponent(BigInt, BigInt) && doBigIntZero(BigInt, BigInt) && doBigIntZeroPowZero(BigInt, BigInt) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSExponentiateNode, JSToNumericNode, JSToNumericNode, BranchProfile) */ ? (Object) leftNodeValue_long : ((state & 0b1101000000) == 0 /* only-active 0:double */ && (state & 0b111111) != 0  /* is-not doDouble(double, double) && doBigIntNegativeExponent(BigInt, BigInt) && doBigIntZero(BigInt, BigInt) && doBigIntZeroPowZero(BigInt, BigInt) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSExponentiateNode, JSToNumericNode, JSToNumericNode, BranchProfile) */ ? (Object) leftNodeValue_int : (Object) leftNodeValue_)), ex.getResult());
        }
        assert (state & 0b1) != 0 /* is-active doDouble(double, double) */;
        return doDouble(leftNodeValue_, rightNodeValue_);
    }

    private Object execute_generic1(VirtualFrame frameValue, int state) {
        Object leftNodeValue_ = super.leftNode.execute(frameValue);
        Object rightNodeValue_ = super.rightNode.execute(frameValue);
        if ((state & 0b1) != 0 /* is-active doDouble(double, double) */ && JSTypesGen.isImplicitDouble((state & 0b1111000000) >>> 6 /* extract-implicit-active 0:double */, leftNodeValue_)) {
            double leftNodeValue__ = JSTypesGen.asImplicitDouble((state & 0b1111000000) >>> 6 /* extract-implicit-active 0:double */, leftNodeValue_);
            if (JSTypesGen.isImplicitDouble((state & 0b11110000000000) >>> 10 /* extract-implicit-active 1:double */, rightNodeValue_)) {
                double rightNodeValue__ = JSTypesGen.asImplicitDouble((state & 0b11110000000000) >>> 10 /* extract-implicit-active 1:double */, rightNodeValue_);
                return doDouble(leftNodeValue__, rightNodeValue__);
            }
        }
        if ((state & 0b11100) != 0 /* is-active doBigIntZero(BigInt, BigInt) || doBigIntZeroPowZero(BigInt, BigInt) || doBigInt(BigInt, BigInt) */ && leftNodeValue_ instanceof BigInt) {
            BigInt leftNodeValue__ = (BigInt) leftNodeValue_;
            if (rightNodeValue_ instanceof BigInt) {
                BigInt rightNodeValue__ = (BigInt) rightNodeValue_;
                if ((state & 0b100) != 0 /* is-active doBigIntZero(BigInt, BigInt) */) {
                    if ((JSGuards.isBigIntZero(leftNodeValue__)) && (!(JSGuards.isBigIntZero(rightNodeValue__))) && (!(JSGuards.isBigIntNegativeVal(rightNodeValue__)))) {
                        return doBigIntZero(leftNodeValue__, rightNodeValue__);
                    }
                }
                if ((state & 0b1000) != 0 /* is-active doBigIntZeroPowZero(BigInt, BigInt) */) {
                    if ((JSGuards.isBigIntZero(rightNodeValue__))) {
                        return doBigIntZeroPowZero(leftNodeValue__, rightNodeValue__);
                    }
                }
                if ((state & 0b10000) != 0 /* is-active doBigInt(BigInt, BigInt) */) {
                    if ((!(JSGuards.isBigIntZero(leftNodeValue__))) && (!(JSGuards.isBigIntZero(rightNodeValue__))) && (!(JSGuards.isBigIntNegativeVal(rightNodeValue__)))) {
                        return doBigInt(leftNodeValue__, rightNodeValue__);
                    }
                }
            }
        }
        if ((state & 0b100000) != 0 /* is-active doGeneric(Object, Object, JSExponentiateNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
            GenericData s6_ = this.generic_cache;
            if (s6_ != null) {
                return doGeneric(leftNodeValue_, rightNodeValue_, s6_.nestedExponentiateNode_, s6_.toNumeric1Node_, s6_.toNumeric2Node_, s6_.mixedNumericTypes_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
    }

    @Override
    public double executeDouble(VirtualFrame frameValue) throws UnexpectedResultException {
        int state = state_;
        if ((state & 0b100000) != 0 /* is-active doGeneric(Object, Object, JSExponentiateNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
            return JSTypesGen.expectDouble(execute(frameValue));
        }
        int leftNodeValue_int = 0;
        long leftNodeValue_long = 0L;
        double leftNodeValue_;
        try {
            if ((state & 0b1110000000) == 0 /* only-active 0:double */ && (state & 0b111111) != 0  /* is-not doDouble(double, double) && doBigIntNegativeExponent(BigInt, BigInt) && doBigIntZero(BigInt, BigInt) && doBigIntZeroPowZero(BigInt, BigInt) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSExponentiateNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
                leftNodeValue_long = super.leftNode.executeLong(frameValue);
                leftNodeValue_ = JSTypes.longToDouble(leftNodeValue_long);
            } else if ((state & 0b1101000000) == 0 /* only-active 0:double */ && (state & 0b111111) != 0  /* is-not doDouble(double, double) && doBigIntNegativeExponent(BigInt, BigInt) && doBigIntZero(BigInt, BigInt) && doBigIntZeroPowZero(BigInt, BigInt) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSExponentiateNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
                leftNodeValue_int = super.leftNode.executeInt(frameValue);
                leftNodeValue_ = JSTypes.intToDouble(leftNodeValue_int);
            } else if ((state & 0b1011000000) == 0 /* only-active 0:double */ && (state & 0b111111) != 0  /* is-not doDouble(double, double) && doBigIntNegativeExponent(BigInt, BigInt) && doBigIntZero(BigInt, BigInt) && doBigIntZeroPowZero(BigInt, BigInt) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSExponentiateNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
                leftNodeValue_ = super.leftNode.executeDouble(frameValue);
            } else {
                Object leftNodeValue__ = super.leftNode.execute(frameValue);
                leftNodeValue_ = JSTypesGen.expectImplicitDouble((state & 0b1111000000) >>> 6 /* extract-implicit-active 0:double */, leftNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            Object rightNodeValue = super.rightNode.execute(frameValue);
            return JSTypesGen.expectDouble(executeAndSpecialize(ex.getResult(), rightNodeValue));
        }
        int rightNodeValue_int = 0;
        long rightNodeValue_long = 0L;
        double rightNodeValue_;
        try {
            if ((state & 0b11100000000000) == 0 /* only-active 1:double */ && (state & 0b111111) != 0  /* is-not doDouble(double, double) && doBigIntNegativeExponent(BigInt, BigInt) && doBigIntZero(BigInt, BigInt) && doBigIntZeroPowZero(BigInt, BigInt) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSExponentiateNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
                rightNodeValue_long = super.rightNode.executeLong(frameValue);
                rightNodeValue_ = JSTypes.longToDouble(rightNodeValue_long);
            } else if ((state & 0b11010000000000) == 0 /* only-active 1:double */ && (state & 0b111111) != 0  /* is-not doDouble(double, double) && doBigIntNegativeExponent(BigInt, BigInt) && doBigIntZero(BigInt, BigInt) && doBigIntZeroPowZero(BigInt, BigInt) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSExponentiateNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
                rightNodeValue_int = super.rightNode.executeInt(frameValue);
                rightNodeValue_ = JSTypes.intToDouble(rightNodeValue_int);
            } else if ((state & 0b10110000000000) == 0 /* only-active 1:double */ && (state & 0b111111) != 0  /* is-not doDouble(double, double) && doBigIntNegativeExponent(BigInt, BigInt) && doBigIntZero(BigInt, BigInt) && doBigIntZeroPowZero(BigInt, BigInt) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSExponentiateNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
                rightNodeValue_ = super.rightNode.executeDouble(frameValue);
            } else {
                Object rightNodeValue__ = super.rightNode.execute(frameValue);
                rightNodeValue_ = JSTypesGen.expectImplicitDouble((state & 0b11110000000000) >>> 10 /* extract-implicit-active 1:double */, rightNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectDouble(executeAndSpecialize(((state & 0b1110000000) == 0 /* only-active 0:double */ && (state & 0b111111) != 0  /* is-not doDouble(double, double) && doBigIntNegativeExponent(BigInt, BigInt) && doBigIntZero(BigInt, BigInt) && doBigIntZeroPowZero(BigInt, BigInt) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSExponentiateNode, JSToNumericNode, JSToNumericNode, BranchProfile) */ ? (Object) leftNodeValue_long : ((state & 0b1101000000) == 0 /* only-active 0:double */ && (state & 0b111111) != 0  /* is-not doDouble(double, double) && doBigIntNegativeExponent(BigInt, BigInt) && doBigIntZero(BigInt, BigInt) && doBigIntZeroPowZero(BigInt, BigInt) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSExponentiateNode, JSToNumericNode, JSToNumericNode, BranchProfile) */ ? (Object) leftNodeValue_int : (Object) leftNodeValue_)), ex.getResult()));
        }
        if ((state & 0b1) != 0 /* is-active doDouble(double, double) */) {
            return doDouble(leftNodeValue_, rightNodeValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectDouble(executeAndSpecialize(((state & 0b1110000000) == 0 /* only-active 0:double */ && (state & 0b111111) != 0  /* is-not doDouble(double, double) && doBigIntNegativeExponent(BigInt, BigInt) && doBigIntZero(BigInt, BigInt) && doBigIntZeroPowZero(BigInt, BigInt) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSExponentiateNode, JSToNumericNode, JSToNumericNode, BranchProfile) */ ? (Object) leftNodeValue_long : ((state & 0b1101000000) == 0 /* only-active 0:double */ && (state & 0b111111) != 0  /* is-not doDouble(double, double) && doBigIntNegativeExponent(BigInt, BigInt) && doBigIntZero(BigInt, BigInt) && doBigIntZeroPowZero(BigInt, BigInt) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSExponentiateNode, JSToNumericNode, JSToNumericNode, BranchProfile) */ ? (Object) leftNodeValue_int : (Object) leftNodeValue_)), ((state & 0b11100000000000) == 0 /* only-active 1:double */ && (state & 0b111111) != 0  /* is-not doDouble(double, double) && doBigIntNegativeExponent(BigInt, BigInt) && doBigIntZero(BigInt, BigInt) && doBigIntZeroPowZero(BigInt, BigInt) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSExponentiateNode, JSToNumericNode, JSToNumericNode, BranchProfile) */ ? (Object) rightNodeValue_long : ((state & 0b11010000000000) == 0 /* only-active 1:double */ && (state & 0b111111) != 0  /* is-not doDouble(double, double) && doBigIntNegativeExponent(BigInt, BigInt) && doBigIntZero(BigInt, BigInt) && doBigIntZeroPowZero(BigInt, BigInt) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSExponentiateNode, JSToNumericNode, JSToNumericNode, BranchProfile) */ ? (Object) rightNodeValue_int : (Object) rightNodeValue_))));
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        int state = state_;
        try {
            if ((state & 0b111110) == 0 /* only-active doDouble(double, double) */ && (state & 0b111111) != 0  /* is-not doDouble(double, double) && doBigIntNegativeExponent(BigInt, BigInt) && doBigIntZero(BigInt, BigInt) && doBigIntZeroPowZero(BigInt, BigInt) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSExponentiateNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
                executeDouble(frameValue);
                return;
            } else if ((state & 0b111101) != 0 /* is-active doDouble(double, double) || doBigIntZero(BigInt, BigInt) || doBigIntZeroPowZero(BigInt, BigInt) || doBigInt(BigInt, BigInt) || doGeneric(Object, Object, JSExponentiateNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
                execute(frameValue);
                return;
            }
        } catch (UnexpectedResultException ex) {
            return;
        }
        Object leftNodeValue_ = super.leftNode.execute(frameValue);
        Object rightNodeValue_ = super.rightNode.execute(frameValue);
        if ((state & 0b10) != 0 /* is-active doBigIntNegativeExponent(BigInt, BigInt) */ && leftNodeValue_ instanceof BigInt) {
            BigInt leftNodeValue__ = (BigInt) leftNodeValue_;
            if (rightNodeValue_ instanceof BigInt) {
                BigInt rightNodeValue__ = (BigInt) rightNodeValue_;
                if ((JSGuards.isBigIntNegativeVal(rightNodeValue__))) {
                    doBigIntNegativeExponent(leftNodeValue__, rightNodeValue__);
                    return;
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        executeAndSpecialize(leftNodeValue_, rightNodeValue_);
        return;
    }

    private Object executeAndSpecialize(Object leftNodeValue, Object rightNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        int exclude = exclude_;
        try {
            if ((exclude) == 0 /* is-not-excluded doDouble(double, double) */) {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(leftNodeValue)) != 0) {
                    double leftNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast0, leftNodeValue);
                    int doubleCast1;
                    if ((doubleCast1 = JSTypesGen.specializeImplicitDouble(rightNodeValue)) != 0) {
                        double rightNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast1, rightNodeValue);
                        state = (state | (doubleCast0 << 6) /* set-implicit-active 0:double */);
                        state = (state | (doubleCast1 << 10) /* set-implicit-active 1:double */);
                        this.state_ = state = state | 0b1 /* add-active doDouble(double, double) */;
                        lock.unlock();
                        hasLock = false;
                        return doDouble(leftNodeValue_, rightNodeValue_);
                    }
                }
            }
            if (leftNodeValue instanceof BigInt) {
                BigInt leftNodeValue_ = (BigInt) leftNodeValue;
                if (rightNodeValue instanceof BigInt) {
                    BigInt rightNodeValue_ = (BigInt) rightNodeValue;
                    if ((JSGuards.isBigIntNegativeVal(rightNodeValue_))) {
                        this.state_ = state = state | 0b10 /* add-active doBigIntNegativeExponent(BigInt, BigInt) */;
                        lock.unlock();
                        hasLock = false;
                        doBigIntNegativeExponent(leftNodeValue_, rightNodeValue_);
                        return null;
                    }
                    if ((JSGuards.isBigIntZero(leftNodeValue_)) && (!(JSGuards.isBigIntZero(rightNodeValue_))) && (!(JSGuards.isBigIntNegativeVal(rightNodeValue_)))) {
                        this.state_ = state = state | 0b100 /* add-active doBigIntZero(BigInt, BigInt) */;
                        lock.unlock();
                        hasLock = false;
                        return doBigIntZero(leftNodeValue_, rightNodeValue_);
                    }
                    if ((JSGuards.isBigIntZero(rightNodeValue_))) {
                        this.state_ = state = state | 0b1000 /* add-active doBigIntZeroPowZero(BigInt, BigInt) */;
                        lock.unlock();
                        hasLock = false;
                        return doBigIntZeroPowZero(leftNodeValue_, rightNodeValue_);
                    }
                    if ((!(JSGuards.isBigIntZero(leftNodeValue_))) && (!(JSGuards.isBigIntZero(rightNodeValue_))) && (!(JSGuards.isBigIntNegativeVal(rightNodeValue_)))) {
                        this.state_ = state = state | 0b10000 /* add-active doBigInt(BigInt, BigInt) */;
                        lock.unlock();
                        hasLock = false;
                        return doBigInt(leftNodeValue_, rightNodeValue_);
                    }
                }
            }
            GenericData s6_ = super.insert(new GenericData());
            s6_.nestedExponentiateNode_ = s6_.insertAccessor((JSExponentiateNode.create()));
            s6_.toNumeric1Node_ = s6_.insertAccessor((JSToNumericNode.create()));
            s6_.toNumeric2Node_ = s6_.insertAccessor((JSToNumericNode.create()));
            s6_.mixedNumericTypes_ = (BranchProfile.create());
            this.generic_cache = s6_;
            this.exclude_ = exclude = exclude | 0b1 /* add-excluded doDouble(double, double) */;
            state = state & 0xfffffffe /* remove-active doDouble(double, double) */;
            this.state_ = state = state | 0b100000 /* add-active doGeneric(Object, Object, JSExponentiateNode, JSToNumericNode, JSToNumericNode, BranchProfile) */;
            lock.unlock();
            hasLock = false;
            return doGeneric(leftNodeValue, rightNodeValue, s6_.nestedExponentiateNode_, s6_.toNumeric1Node_, s6_.toNumeric2Node_, s6_.mixedNumericTypes_);
        } finally {
            if (hasLock) {
                lock.unlock();
            }
        }
    }

    @Override
    public NodeCost getCost() {
        int state = state_;
        if ((state & 0b111111) == 0b0) {
            return NodeCost.UNINITIALIZED;
        } else if (((state & 0b111111) & ((state & 0b111111) - 1)) == 0 /* is-single-active  */) {
            return NodeCost.MONOMORPHIC;
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[7];
        Object[] s;
        data[0] = 0;
        int state = state_;
        int exclude = exclude_;
        s = new Object[3];
        s[0] = "doDouble";
        if ((state & 0b1) != 0 /* is-active doDouble(double, double) */) {
            s[1] = (byte)0b01 /* active */;
        } else if (exclude != 0 /* is-excluded doDouble(double, double) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doBigIntNegativeExponent";
        if ((state & 0b10) != 0 /* is-active doBigIntNegativeExponent(BigInt, BigInt) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doBigIntZero";
        if ((state & 0b100) != 0 /* is-active doBigIntZero(BigInt, BigInt) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doBigIntZeroPowZero";
        if ((state & 0b1000) != 0 /* is-active doBigIntZeroPowZero(BigInt, BigInt) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doBigInt";
        if ((state & 0b10000) != 0 /* is-active doBigInt(BigInt, BigInt) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "doGeneric";
        if ((state & 0b100000) != 0 /* is-active doGeneric(Object, Object, JSExponentiateNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            GenericData s6_ = this.generic_cache;
            if (s6_ != null) {
                cached.add(Arrays.asList(s6_.nestedExponentiateNode_, s6_.toNumeric1Node_, s6_.toNumeric2Node_, s6_.mixedNumericTypes_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        return Provider.create(data);
    }

    public static JSExponentiateNode create(JavaScriptNode left, JavaScriptNode right) {
        return new JSExponentiateNodeGen(left, right);
    }

    @GeneratedBy(JSExponentiateNode.class)
    private static final class GenericData extends Node {

        @Child JSExponentiateNode nestedExponentiateNode_;
        @Child JSToNumericNode toNumeric1Node_;
        @Child JSToNumericNode toNumeric2Node_;
        @CompilationFinal BranchProfile mixedNumericTypes_;

        GenericData() {
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
