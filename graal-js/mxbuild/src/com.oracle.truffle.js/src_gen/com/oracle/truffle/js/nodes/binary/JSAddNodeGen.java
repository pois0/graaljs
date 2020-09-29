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
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.cast.JSDoubleToStringNode;
import com.oracle.truffle.js.nodes.cast.JSToNumericNode;
import com.oracle.truffle.js.nodes.cast.JSToPrimitiveNode;
import com.oracle.truffle.js.nodes.cast.JSToStringNode;
import com.oracle.truffle.js.runtime.BigInt;
import com.oracle.truffle.js.runtime.SafeInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSAddNode.class)
public final class JSAddNodeGen extends JSAddNode implements Provider {

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @Child private JSConcatStringsNode concatStringsNode;
    @Child private JSDoubleToStringNode doubleToStringNode;
    @Child private PrimitiveConversionData primitiveConversion_cache;

    private JSAddNodeGen(boolean truncate, JavaScriptNode left, JavaScriptNode right) {
        super(truncate, left, right);
    }

    @Override
    public Object execute(Object leftNodeValue, Object rightNodeValue) {
        int state = state_;
        if ((state & 0b1111) != 0 /* is-active doIntTruncate(int, int) || doInt(int, int) || doIntOverflow(int, int) || doIntSafeInteger(int, SafeInteger) */ && leftNodeValue instanceof Integer) {
            int leftNodeValue_ = (int) leftNodeValue;
            if ((state & 0b111) != 0 /* is-active doIntTruncate(int, int) || doInt(int, int) || doIntOverflow(int, int) */ && rightNodeValue instanceof Integer) {
                int rightNodeValue_ = (int) rightNodeValue;
                if ((state & 0b1) != 0 /* is-active doIntTruncate(int, int) */) {
                    assert (truncate);
                    return JSAddNode.doIntTruncate(leftNodeValue_, rightNodeValue_);
                }
                if ((state & 0b10) != 0 /* is-active doInt(int, int) */) {
                    assert (!(truncate));
                    try {
                        return JSAddNode.doInt(leftNodeValue_, rightNodeValue_);
                    } catch (ArithmeticException ex) {
                        // implicit transferToInterpreterAndInvalidate()
                        Lock lock = getLock();
                        lock.lock();
                        try {
                            this.exclude_ = this.exclude_ | 0b10 /* add-excluded doInt(int, int) */;
                            this.state_ = this.state_ & 0xfffffffd /* remove-active doInt(int, int) */;
                        } finally {
                            lock.unlock();
                        }
                        return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
                    }
                }
                if ((state & 0b100) != 0 /* is-active doIntOverflow(int, int) */) {
                    assert (!(truncate));
                    try {
                        return JSAddNode.doIntOverflow(leftNodeValue_, rightNodeValue_);
                    } catch (ArithmeticException ex) {
                        // implicit transferToInterpreterAndInvalidate()
                        Lock lock = getLock();
                        lock.lock();
                        try {
                            this.exclude_ = this.exclude_ | 0b100 /* add-excluded doIntOverflow(int, int) */;
                            this.state_ = this.state_ & 0xfffffffb /* remove-active doIntOverflow(int, int) */;
                        } finally {
                            lock.unlock();
                        }
                        return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
                    }
                }
            }
            if ((state & 0b1000) != 0 /* is-active doIntSafeInteger(int, SafeInteger) */ && rightNodeValue instanceof SafeInteger) {
                SafeInteger rightNodeValue_ = (SafeInteger) rightNodeValue;
                try {
                    return JSAddNode.doIntSafeInteger(leftNodeValue_, rightNodeValue_);
                } catch (ArithmeticException ex) {
                    // implicit transferToInterpreterAndInvalidate()
                    Lock lock = getLock();
                    lock.lock();
                    try {
                        this.exclude_ = this.exclude_ | 0b1000 /* add-excluded doIntSafeInteger(int, SafeInteger) */;
                        this.state_ = this.state_ & 0xfffffff7 /* remove-active doIntSafeInteger(int, SafeInteger) */;
                    } finally {
                        lock.unlock();
                    }
                    return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
                }
            }
        }
        if ((state & 0b110000) != 0 /* is-active doSafeIntegerInt(SafeInteger, int) || doSafeInteger(SafeInteger, SafeInteger) */ && leftNodeValue instanceof SafeInteger) {
            SafeInteger leftNodeValue_ = (SafeInteger) leftNodeValue;
            if ((state & 0b10000) != 0 /* is-active doSafeIntegerInt(SafeInteger, int) */ && rightNodeValue instanceof Integer) {
                int rightNodeValue_ = (int) rightNodeValue;
                try {
                    return JSAddNode.doSafeIntegerInt(leftNodeValue_, rightNodeValue_);
                } catch (ArithmeticException ex) {
                    // implicit transferToInterpreterAndInvalidate()
                    Lock lock = getLock();
                    lock.lock();
                    try {
                        this.exclude_ = this.exclude_ | 0b10000 /* add-excluded doSafeIntegerInt(SafeInteger, int) */;
                        this.state_ = this.state_ & 0xffffffef /* remove-active doSafeIntegerInt(SafeInteger, int) */;
                    } finally {
                        lock.unlock();
                    }
                    return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
                }
            }
            if ((state & 0b100000) != 0 /* is-active doSafeInteger(SafeInteger, SafeInteger) */ && rightNodeValue instanceof SafeInteger) {
                SafeInteger rightNodeValue_ = (SafeInteger) rightNodeValue;
                try {
                    return JSAddNode.doSafeInteger(leftNodeValue_, rightNodeValue_);
                } catch (ArithmeticException ex) {
                    // implicit transferToInterpreterAndInvalidate()
                    Lock lock = getLock();
                    lock.lock();
                    try {
                        this.exclude_ = this.exclude_ | 0b100000 /* add-excluded doSafeInteger(SafeInteger, SafeInteger) */;
                        this.state_ = this.state_ & 0xffffffdf /* remove-active doSafeInteger(SafeInteger, SafeInteger) */;
                    } finally {
                        lock.unlock();
                    }
                    return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
                }
            }
        }
        if ((state & 0b1000000) != 0 /* is-active doDouble(double, double) */ && JSTypesGen.isImplicitDouble((state & 0x3c000) >>> 14 /* extract-implicit-active 0:double */, leftNodeValue)) {
            double leftNodeValue_ = JSTypesGen.asImplicitDouble((state & 0x3c000) >>> 14 /* extract-implicit-active 0:double */, leftNodeValue);
            if (JSTypesGen.isImplicitDouble((state & 0x3c0000) >>> 18 /* extract-implicit-active 1:double */, rightNodeValue)) {
                double rightNodeValue_ = JSTypesGen.asImplicitDouble((state & 0x3c0000) >>> 18 /* extract-implicit-active 1:double */, rightNodeValue);
                return JSAddNode.doDouble(leftNodeValue_, rightNodeValue_);
            }
        }
        if ((state & 0b10000000) != 0 /* is-active doBigInt(BigInt, BigInt) */ && leftNodeValue instanceof BigInt) {
            BigInt leftNodeValue_ = (BigInt) leftNodeValue;
            if (rightNodeValue instanceof BigInt) {
                BigInt rightNodeValue_ = (BigInt) rightNodeValue;
                return doBigInt(leftNodeValue_, rightNodeValue_);
            }
        }
        if ((state & 0b1100000000) != 0 /* is-active doString(CharSequence, CharSequence, JSConcatStringsNode) || doStringInt(CharSequence, int) */ && JSTypesGen.isImplicitCharSequence((state & 0x3c00000) >>> 22 /* extract-implicit-active 0:CharSequence */, leftNodeValue)) {
            CharSequence leftNodeValue_ = JSTypesGen.asImplicitCharSequence((state & 0x3c00000) >>> 22 /* extract-implicit-active 0:CharSequence */, leftNodeValue);
            if ((state & 0b100000000) != 0 /* is-active doString(CharSequence, CharSequence, JSConcatStringsNode) */ && JSTypesGen.isImplicitCharSequence((state & 0x3c000000) >>> 26 /* extract-implicit-active 1:CharSequence */, rightNodeValue)) {
                CharSequence rightNodeValue_ = JSTypesGen.asImplicitCharSequence((state & 0x3c000000) >>> 26 /* extract-implicit-active 1:CharSequence */, rightNodeValue);
                return doString(leftNodeValue_, rightNodeValue_, this.concatStringsNode);
            }
            if ((state & 0b1000000000) != 0 /* is-active doStringInt(CharSequence, int) */ && rightNodeValue instanceof Integer) {
                int rightNodeValue_ = (int) rightNodeValue;
                return doStringInt(leftNodeValue_, rightNodeValue_);
            }
        }
        if ((state & 0b10000000000) != 0 /* is-active doIntString(int, CharSequence) */ && leftNodeValue instanceof Integer) {
            int leftNodeValue_ = (int) leftNodeValue;
            if (JSTypesGen.isImplicitCharSequence((state & 0x3c000000) >>> 26 /* extract-implicit-active 1:CharSequence */, rightNodeValue)) {
                CharSequence rightNodeValue_ = JSTypesGen.asImplicitCharSequence((state & 0x3c000000) >>> 26 /* extract-implicit-active 1:CharSequence */, rightNodeValue);
                return doIntString(leftNodeValue_, rightNodeValue_);
            }
        }
        if ((state & 0b100000000000) != 0 /* is-active doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) */ && JSTypesGen.isImplicitCharSequence((state & 0x3c00000) >>> 22 /* extract-implicit-active 0:CharSequence */, leftNodeValue)) {
            CharSequence leftNodeValue_ = JSTypesGen.asImplicitCharSequence((state & 0x3c00000) >>> 22 /* extract-implicit-active 0:CharSequence */, leftNodeValue);
            if ((JSGuards.isNumber(rightNodeValue))) {
                return doStringNumber(leftNodeValue_, rightNodeValue, this.concatStringsNode, this.doubleToStringNode);
            }
        }
        if ((state & 0b11000000000000) != 0 /* is-active doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) || doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */) {
            if ((state & 0b1000000000000) != 0 /* is-active doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) */ && JSTypesGen.isImplicitCharSequence((state & 0x3c000000) >>> 26 /* extract-implicit-active 1:CharSequence */, rightNodeValue)) {
                CharSequence rightNodeValue_ = JSTypesGen.asImplicitCharSequence((state & 0x3c000000) >>> 26 /* extract-implicit-active 1:CharSequence */, rightNodeValue);
                if ((JSGuards.isNumber(leftNodeValue))) {
                    return doNumberString(leftNodeValue, rightNodeValue_, this.concatStringsNode, this.doubleToStringNode);
                }
            }
            if ((state & 0b10000000000000) != 0 /* is-active doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */) {
                PrimitiveConversionData s14_ = this.primitiveConversion_cache;
                if (s14_ != null) {
                    return doPrimitiveConversion(leftNodeValue, rightNodeValue, s14_.toPrimitiveA_, s14_.toPrimitiveB_, s14_.toNumericA_, s14_.toNumericB_, s14_.toStringA_, s14_.toStringB_, s14_.profileA_, s14_.profileB_, s14_.add_, s14_.mixedNumericTypes_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(leftNodeValue, rightNodeValue);
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        int state = state_;
        if ((state & 0b11111111111000) == 0 /* only-active doIntTruncate(int, int) && doInt(int, int) && doIntOverflow(int, int) */ && (state & 0b11111111111111) != 0  /* is-not doIntTruncate(int, int) && doInt(int, int) && doIntOverflow(int, int) && doIntSafeInteger(int, SafeInteger) && doSafeIntegerInt(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doString(CharSequence, CharSequence, JSConcatStringsNode) && doStringInt(CharSequence, int) && doIntString(int, CharSequence) && doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) && doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) && doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */) {
            return execute_int_int0(frameValue, state);
        } else if ((state & 0b11111110111111) == 0 /* only-active doDouble(double, double) */ && (state & 0b11111111111111) != 0  /* is-not doIntTruncate(int, int) && doInt(int, int) && doIntOverflow(int, int) && doIntSafeInteger(int, SafeInteger) && doSafeIntegerInt(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doString(CharSequence, CharSequence, JSConcatStringsNode) && doStringInt(CharSequence, int) && doIntString(int, CharSequence) && doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) && doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) && doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */) {
            return execute_double_double1(frameValue, state);
        } else if ((state & 0b11101111110111) == 0 /* only-active doIntSafeInteger(int, SafeInteger) && doIntString(int, CharSequence) */ && (state & 0b11111111111111) != 0  /* is-not doIntTruncate(int, int) && doInt(int, int) && doIntOverflow(int, int) && doIntSafeInteger(int, SafeInteger) && doSafeIntegerInt(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doString(CharSequence, CharSequence, JSConcatStringsNode) && doStringInt(CharSequence, int) && doIntString(int, CharSequence) && doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) && doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) && doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */) {
            return execute_int2(frameValue, state);
        } else if ((state & 0b11110111101111) == 0 /* only-active doSafeIntegerInt(SafeInteger, int) && doStringInt(CharSequence, int) */ && (state & 0b11111111111111) != 0  /* is-not doIntTruncate(int, int) && doInt(int, int) && doIntOverflow(int, int) && doIntSafeInteger(int, SafeInteger) && doSafeIntegerInt(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doString(CharSequence, CharSequence, JSConcatStringsNode) && doStringInt(CharSequence, int) && doIntString(int, CharSequence) && doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) && doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) && doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */) {
            return execute_int3(frameValue, state);
        } else {
            return execute_generic4(frameValue, state);
        }
    }

    private Object execute_int_int0(VirtualFrame frameValue, int state) {
        int leftNodeValue_;
        try {
            leftNodeValue_ = super.leftNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            Object rightNodeValue = super.rightNode.execute(frameValue);
            return executeAndSpecialize(ex.getResult(), rightNodeValue);
        }
        int rightNodeValue_;
        try {
            rightNodeValue_ = super.rightNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(leftNodeValue_, ex.getResult());
        }
        if ((state & 0b1) != 0 /* is-active doIntTruncate(int, int) */) {
            assert (truncate);
            return JSAddNode.doIntTruncate(leftNodeValue_, rightNodeValue_);
        }
        if ((state & 0b10) != 0 /* is-active doInt(int, int) */) {
            assert (!(truncate));
            try {
                return JSAddNode.doInt(leftNodeValue_, rightNodeValue_);
            } catch (ArithmeticException ex) {
                // implicit transferToInterpreterAndInvalidate()
                Lock lock = getLock();
                lock.lock();
                try {
                    this.exclude_ = this.exclude_ | 0b10 /* add-excluded doInt(int, int) */;
                    this.state_ = this.state_ & 0xfffffffd /* remove-active doInt(int, int) */;
                } finally {
                    lock.unlock();
                }
                return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
            }
        }
        if ((state & 0b100) != 0 /* is-active doIntOverflow(int, int) */) {
            assert (!(truncate));
            try {
                return JSAddNode.doIntOverflow(leftNodeValue_, rightNodeValue_);
            } catch (ArithmeticException ex) {
                // implicit transferToInterpreterAndInvalidate()
                Lock lock = getLock();
                lock.lock();
                try {
                    this.exclude_ = this.exclude_ | 0b100 /* add-excluded doIntOverflow(int, int) */;
                    this.state_ = this.state_ & 0xfffffffb /* remove-active doIntOverflow(int, int) */;
                } finally {
                    lock.unlock();
                }
                return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
    }

    private Object execute_double_double1(VirtualFrame frameValue, int state) {
        int leftNodeValue_int = 0;
        long leftNodeValue_long = 0L;
        double leftNodeValue_;
        try {
            if ((state & 0x38000) == 0 /* only-active 0:double */ && (state & 0b11111111111111) != 0  /* is-not doIntTruncate(int, int) && doInt(int, int) && doIntOverflow(int, int) && doIntSafeInteger(int, SafeInteger) && doSafeIntegerInt(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doString(CharSequence, CharSequence, JSConcatStringsNode) && doStringInt(CharSequence, int) && doIntString(int, CharSequence) && doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) && doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) && doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */) {
                leftNodeValue_long = super.leftNode.executeLong(frameValue);
                leftNodeValue_ = JSTypes.longToDouble(leftNodeValue_long);
            } else if ((state & 0x34000) == 0 /* only-active 0:double */ && (state & 0b11111111111111) != 0  /* is-not doIntTruncate(int, int) && doInt(int, int) && doIntOverflow(int, int) && doIntSafeInteger(int, SafeInteger) && doSafeIntegerInt(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doString(CharSequence, CharSequence, JSConcatStringsNode) && doStringInt(CharSequence, int) && doIntString(int, CharSequence) && doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) && doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) && doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */) {
                leftNodeValue_int = super.leftNode.executeInt(frameValue);
                leftNodeValue_ = JSTypes.intToDouble(leftNodeValue_int);
            } else if ((state & 0x2c000) == 0 /* only-active 0:double */ && (state & 0b11111111111111) != 0  /* is-not doIntTruncate(int, int) && doInt(int, int) && doIntOverflow(int, int) && doIntSafeInteger(int, SafeInteger) && doSafeIntegerInt(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doString(CharSequence, CharSequence, JSConcatStringsNode) && doStringInt(CharSequence, int) && doIntString(int, CharSequence) && doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) && doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) && doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */) {
                leftNodeValue_ = super.leftNode.executeDouble(frameValue);
            } else {
                Object leftNodeValue__ = super.leftNode.execute(frameValue);
                leftNodeValue_ = JSTypesGen.expectImplicitDouble((state & 0x3c000) >>> 14 /* extract-implicit-active 0:double */, leftNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            Object rightNodeValue = super.rightNode.execute(frameValue);
            return executeAndSpecialize(ex.getResult(), rightNodeValue);
        }
        int rightNodeValue_int = 0;
        long rightNodeValue_long = 0L;
        double rightNodeValue_;
        try {
            if ((state & 0x380000) == 0 /* only-active 1:double */ && (state & 0b11111111111111) != 0  /* is-not doIntTruncate(int, int) && doInt(int, int) && doIntOverflow(int, int) && doIntSafeInteger(int, SafeInteger) && doSafeIntegerInt(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doString(CharSequence, CharSequence, JSConcatStringsNode) && doStringInt(CharSequence, int) && doIntString(int, CharSequence) && doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) && doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) && doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */) {
                rightNodeValue_long = super.rightNode.executeLong(frameValue);
                rightNodeValue_ = JSTypes.longToDouble(rightNodeValue_long);
            } else if ((state & 0x340000) == 0 /* only-active 1:double */ && (state & 0b11111111111111) != 0  /* is-not doIntTruncate(int, int) && doInt(int, int) && doIntOverflow(int, int) && doIntSafeInteger(int, SafeInteger) && doSafeIntegerInt(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doString(CharSequence, CharSequence, JSConcatStringsNode) && doStringInt(CharSequence, int) && doIntString(int, CharSequence) && doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) && doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) && doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */) {
                rightNodeValue_int = super.rightNode.executeInt(frameValue);
                rightNodeValue_ = JSTypes.intToDouble(rightNodeValue_int);
            } else if ((state & 0x2c0000) == 0 /* only-active 1:double */ && (state & 0b11111111111111) != 0  /* is-not doIntTruncate(int, int) && doInt(int, int) && doIntOverflow(int, int) && doIntSafeInteger(int, SafeInteger) && doSafeIntegerInt(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doString(CharSequence, CharSequence, JSConcatStringsNode) && doStringInt(CharSequence, int) && doIntString(int, CharSequence) && doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) && doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) && doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */) {
                rightNodeValue_ = super.rightNode.executeDouble(frameValue);
            } else {
                Object rightNodeValue__ = super.rightNode.execute(frameValue);
                rightNodeValue_ = JSTypesGen.expectImplicitDouble((state & 0x3c0000) >>> 18 /* extract-implicit-active 1:double */, rightNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(((state & 0x38000) == 0 /* only-active 0:double */ && (state & 0b11111111111111) != 0  /* is-not doIntTruncate(int, int) && doInt(int, int) && doIntOverflow(int, int) && doIntSafeInteger(int, SafeInteger) && doSafeIntegerInt(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doString(CharSequence, CharSequence, JSConcatStringsNode) && doStringInt(CharSequence, int) && doIntString(int, CharSequence) && doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) && doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) && doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */ ? (Object) leftNodeValue_long : ((state & 0x34000) == 0 /* only-active 0:double */ && (state & 0b11111111111111) != 0  /* is-not doIntTruncate(int, int) && doInt(int, int) && doIntOverflow(int, int) && doIntSafeInteger(int, SafeInteger) && doSafeIntegerInt(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doString(CharSequence, CharSequence, JSConcatStringsNode) && doStringInt(CharSequence, int) && doIntString(int, CharSequence) && doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) && doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) && doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */ ? (Object) leftNodeValue_int : (Object) leftNodeValue_)), ex.getResult());
        }
        assert (state & 0b1000000) != 0 /* is-active doDouble(double, double) */;
        return JSAddNode.doDouble(leftNodeValue_, rightNodeValue_);
    }

    private Object execute_int2(VirtualFrame frameValue, int state) {
        int leftNodeValue_;
        try {
            leftNodeValue_ = super.leftNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            Object rightNodeValue = super.rightNode.execute(frameValue);
            return executeAndSpecialize(ex.getResult(), rightNodeValue);
        }
        Object rightNodeValue_ = super.rightNode.execute(frameValue);
        if ((state & 0b1000) != 0 /* is-active doIntSafeInteger(int, SafeInteger) */ && rightNodeValue_ instanceof SafeInteger) {
            SafeInteger rightNodeValue__ = (SafeInteger) rightNodeValue_;
            try {
                return JSAddNode.doIntSafeInteger(leftNodeValue_, rightNodeValue__);
            } catch (ArithmeticException ex) {
                // implicit transferToInterpreterAndInvalidate()
                Lock lock = getLock();
                lock.lock();
                try {
                    this.exclude_ = this.exclude_ | 0b1000 /* add-excluded doIntSafeInteger(int, SafeInteger) */;
                    this.state_ = this.state_ & 0xfffffff7 /* remove-active doIntSafeInteger(int, SafeInteger) */;
                } finally {
                    lock.unlock();
                }
                return executeAndSpecialize(leftNodeValue_, rightNodeValue__);
            }
        }
        if ((state & 0b10000000000) != 0 /* is-active doIntString(int, CharSequence) */ && JSTypesGen.isImplicitCharSequence((state & 0x3c000000) >>> 26 /* extract-implicit-active 1:CharSequence */, rightNodeValue_)) {
            CharSequence rightNodeValue__ = JSTypesGen.asImplicitCharSequence((state & 0x3c000000) >>> 26 /* extract-implicit-active 1:CharSequence */, rightNodeValue_);
            return doIntString(leftNodeValue_, rightNodeValue__);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
    }

    private Object execute_int3(VirtualFrame frameValue, int state) {
        Object leftNodeValue_ = super.leftNode.execute(frameValue);
        int rightNodeValue_;
        try {
            rightNodeValue_ = super.rightNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(leftNodeValue_, ex.getResult());
        }
        if ((state & 0b10000) != 0 /* is-active doSafeIntegerInt(SafeInteger, int) */ && leftNodeValue_ instanceof SafeInteger) {
            SafeInteger leftNodeValue__ = (SafeInteger) leftNodeValue_;
            try {
                return JSAddNode.doSafeIntegerInt(leftNodeValue__, rightNodeValue_);
            } catch (ArithmeticException ex) {
                // implicit transferToInterpreterAndInvalidate()
                Lock lock = getLock();
                lock.lock();
                try {
                    this.exclude_ = this.exclude_ | 0b10000 /* add-excluded doSafeIntegerInt(SafeInteger, int) */;
                    this.state_ = this.state_ & 0xffffffef /* remove-active doSafeIntegerInt(SafeInteger, int) */;
                } finally {
                    lock.unlock();
                }
                return executeAndSpecialize(leftNodeValue__, rightNodeValue_);
            }
        }
        if ((state & 0b1000000000) != 0 /* is-active doStringInt(CharSequence, int) */ && JSTypesGen.isImplicitCharSequence((state & 0x3c00000) >>> 22 /* extract-implicit-active 0:CharSequence */, leftNodeValue_)) {
            CharSequence leftNodeValue__ = JSTypesGen.asImplicitCharSequence((state & 0x3c00000) >>> 22 /* extract-implicit-active 0:CharSequence */, leftNodeValue_);
            return doStringInt(leftNodeValue__, rightNodeValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
    }

    private Object execute_generic4(VirtualFrame frameValue, int state) {
        Object leftNodeValue_ = super.leftNode.execute(frameValue);
        Object rightNodeValue_ = super.rightNode.execute(frameValue);
        if ((state & 0b1111) != 0 /* is-active doIntTruncate(int, int) || doInt(int, int) || doIntOverflow(int, int) || doIntSafeInteger(int, SafeInteger) */ && leftNodeValue_ instanceof Integer) {
            int leftNodeValue__ = (int) leftNodeValue_;
            if ((state & 0b111) != 0 /* is-active doIntTruncate(int, int) || doInt(int, int) || doIntOverflow(int, int) */ && rightNodeValue_ instanceof Integer) {
                int rightNodeValue__ = (int) rightNodeValue_;
                if ((state & 0b1) != 0 /* is-active doIntTruncate(int, int) */) {
                    assert (truncate);
                    return JSAddNode.doIntTruncate(leftNodeValue__, rightNodeValue__);
                }
                if ((state & 0b10) != 0 /* is-active doInt(int, int) */) {
                    assert (!(truncate));
                    try {
                        return JSAddNode.doInt(leftNodeValue__, rightNodeValue__);
                    } catch (ArithmeticException ex) {
                        // implicit transferToInterpreterAndInvalidate()
                        Lock lock = getLock();
                        lock.lock();
                        try {
                            this.exclude_ = this.exclude_ | 0b10 /* add-excluded doInt(int, int) */;
                            this.state_ = this.state_ & 0xfffffffd /* remove-active doInt(int, int) */;
                        } finally {
                            lock.unlock();
                        }
                        return executeAndSpecialize(leftNodeValue__, rightNodeValue__);
                    }
                }
                if ((state & 0b100) != 0 /* is-active doIntOverflow(int, int) */) {
                    assert (!(truncate));
                    try {
                        return JSAddNode.doIntOverflow(leftNodeValue__, rightNodeValue__);
                    } catch (ArithmeticException ex) {
                        // implicit transferToInterpreterAndInvalidate()
                        Lock lock = getLock();
                        lock.lock();
                        try {
                            this.exclude_ = this.exclude_ | 0b100 /* add-excluded doIntOverflow(int, int) */;
                            this.state_ = this.state_ & 0xfffffffb /* remove-active doIntOverflow(int, int) */;
                        } finally {
                            lock.unlock();
                        }
                        return executeAndSpecialize(leftNodeValue__, rightNodeValue__);
                    }
                }
            }
            if ((state & 0b1000) != 0 /* is-active doIntSafeInteger(int, SafeInteger) */ && rightNodeValue_ instanceof SafeInteger) {
                SafeInteger rightNodeValue__ = (SafeInteger) rightNodeValue_;
                try {
                    return JSAddNode.doIntSafeInteger(leftNodeValue__, rightNodeValue__);
                } catch (ArithmeticException ex) {
                    // implicit transferToInterpreterAndInvalidate()
                    Lock lock = getLock();
                    lock.lock();
                    try {
                        this.exclude_ = this.exclude_ | 0b1000 /* add-excluded doIntSafeInteger(int, SafeInteger) */;
                        this.state_ = this.state_ & 0xfffffff7 /* remove-active doIntSafeInteger(int, SafeInteger) */;
                    } finally {
                        lock.unlock();
                    }
                    return executeAndSpecialize(leftNodeValue__, rightNodeValue__);
                }
            }
        }
        if ((state & 0b110000) != 0 /* is-active doSafeIntegerInt(SafeInteger, int) || doSafeInteger(SafeInteger, SafeInteger) */ && leftNodeValue_ instanceof SafeInteger) {
            SafeInteger leftNodeValue__ = (SafeInteger) leftNodeValue_;
            if ((state & 0b10000) != 0 /* is-active doSafeIntegerInt(SafeInteger, int) */ && rightNodeValue_ instanceof Integer) {
                int rightNodeValue__ = (int) rightNodeValue_;
                try {
                    return JSAddNode.doSafeIntegerInt(leftNodeValue__, rightNodeValue__);
                } catch (ArithmeticException ex) {
                    // implicit transferToInterpreterAndInvalidate()
                    Lock lock = getLock();
                    lock.lock();
                    try {
                        this.exclude_ = this.exclude_ | 0b10000 /* add-excluded doSafeIntegerInt(SafeInteger, int) */;
                        this.state_ = this.state_ & 0xffffffef /* remove-active doSafeIntegerInt(SafeInteger, int) */;
                    } finally {
                        lock.unlock();
                    }
                    return executeAndSpecialize(leftNodeValue__, rightNodeValue__);
                }
            }
            if ((state & 0b100000) != 0 /* is-active doSafeInteger(SafeInteger, SafeInteger) */ && rightNodeValue_ instanceof SafeInteger) {
                SafeInteger rightNodeValue__ = (SafeInteger) rightNodeValue_;
                try {
                    return JSAddNode.doSafeInteger(leftNodeValue__, rightNodeValue__);
                } catch (ArithmeticException ex) {
                    // implicit transferToInterpreterAndInvalidate()
                    Lock lock = getLock();
                    lock.lock();
                    try {
                        this.exclude_ = this.exclude_ | 0b100000 /* add-excluded doSafeInteger(SafeInteger, SafeInteger) */;
                        this.state_ = this.state_ & 0xffffffdf /* remove-active doSafeInteger(SafeInteger, SafeInteger) */;
                    } finally {
                        lock.unlock();
                    }
                    return executeAndSpecialize(leftNodeValue__, rightNodeValue__);
                }
            }
        }
        if ((state & 0b1000000) != 0 /* is-active doDouble(double, double) */ && JSTypesGen.isImplicitDouble((state & 0x3c000) >>> 14 /* extract-implicit-active 0:double */, leftNodeValue_)) {
            double leftNodeValue__ = JSTypesGen.asImplicitDouble((state & 0x3c000) >>> 14 /* extract-implicit-active 0:double */, leftNodeValue_);
            if (JSTypesGen.isImplicitDouble((state & 0x3c0000) >>> 18 /* extract-implicit-active 1:double */, rightNodeValue_)) {
                double rightNodeValue__ = JSTypesGen.asImplicitDouble((state & 0x3c0000) >>> 18 /* extract-implicit-active 1:double */, rightNodeValue_);
                return JSAddNode.doDouble(leftNodeValue__, rightNodeValue__);
            }
        }
        if ((state & 0b10000000) != 0 /* is-active doBigInt(BigInt, BigInt) */ && leftNodeValue_ instanceof BigInt) {
            BigInt leftNodeValue__ = (BigInt) leftNodeValue_;
            if (rightNodeValue_ instanceof BigInt) {
                BigInt rightNodeValue__ = (BigInt) rightNodeValue_;
                return doBigInt(leftNodeValue__, rightNodeValue__);
            }
        }
        if ((state & 0b1100000000) != 0 /* is-active doString(CharSequence, CharSequence, JSConcatStringsNode) || doStringInt(CharSequence, int) */ && JSTypesGen.isImplicitCharSequence((state & 0x3c00000) >>> 22 /* extract-implicit-active 0:CharSequence */, leftNodeValue_)) {
            CharSequence leftNodeValue__ = JSTypesGen.asImplicitCharSequence((state & 0x3c00000) >>> 22 /* extract-implicit-active 0:CharSequence */, leftNodeValue_);
            if ((state & 0b100000000) != 0 /* is-active doString(CharSequence, CharSequence, JSConcatStringsNode) */ && JSTypesGen.isImplicitCharSequence((state & 0x3c000000) >>> 26 /* extract-implicit-active 1:CharSequence */, rightNodeValue_)) {
                CharSequence rightNodeValue__ = JSTypesGen.asImplicitCharSequence((state & 0x3c000000) >>> 26 /* extract-implicit-active 1:CharSequence */, rightNodeValue_);
                return doString(leftNodeValue__, rightNodeValue__, this.concatStringsNode);
            }
            if ((state & 0b1000000000) != 0 /* is-active doStringInt(CharSequence, int) */ && rightNodeValue_ instanceof Integer) {
                int rightNodeValue__ = (int) rightNodeValue_;
                return doStringInt(leftNodeValue__, rightNodeValue__);
            }
        }
        if ((state & 0b10000000000) != 0 /* is-active doIntString(int, CharSequence) */ && leftNodeValue_ instanceof Integer) {
            int leftNodeValue__ = (int) leftNodeValue_;
            if (JSTypesGen.isImplicitCharSequence((state & 0x3c000000) >>> 26 /* extract-implicit-active 1:CharSequence */, rightNodeValue_)) {
                CharSequence rightNodeValue__ = JSTypesGen.asImplicitCharSequence((state & 0x3c000000) >>> 26 /* extract-implicit-active 1:CharSequence */, rightNodeValue_);
                return doIntString(leftNodeValue__, rightNodeValue__);
            }
        }
        if ((state & 0b100000000000) != 0 /* is-active doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) */ && JSTypesGen.isImplicitCharSequence((state & 0x3c00000) >>> 22 /* extract-implicit-active 0:CharSequence */, leftNodeValue_)) {
            CharSequence leftNodeValue__ = JSTypesGen.asImplicitCharSequence((state & 0x3c00000) >>> 22 /* extract-implicit-active 0:CharSequence */, leftNodeValue_);
            if ((JSGuards.isNumber(rightNodeValue_))) {
                return doStringNumber(leftNodeValue__, rightNodeValue_, this.concatStringsNode, this.doubleToStringNode);
            }
        }
        if ((state & 0b11000000000000) != 0 /* is-active doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) || doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */) {
            if ((state & 0b1000000000000) != 0 /* is-active doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) */ && JSTypesGen.isImplicitCharSequence((state & 0x3c000000) >>> 26 /* extract-implicit-active 1:CharSequence */, rightNodeValue_)) {
                CharSequence rightNodeValue__ = JSTypesGen.asImplicitCharSequence((state & 0x3c000000) >>> 26 /* extract-implicit-active 1:CharSequence */, rightNodeValue_);
                if ((JSGuards.isNumber(leftNodeValue_))) {
                    return doNumberString(leftNodeValue_, rightNodeValue__, this.concatStringsNode, this.doubleToStringNode);
                }
            }
            if ((state & 0b10000000000000) != 0 /* is-active doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */) {
                PrimitiveConversionData s14_ = this.primitiveConversion_cache;
                if (s14_ != null) {
                    return doPrimitiveConversion(leftNodeValue_, rightNodeValue_, s14_.toPrimitiveA_, s14_.toPrimitiveB_, s14_.toNumericA_, s14_.toNumericB_, s14_.toStringA_, s14_.toStringB_, s14_.profileA_, s14_.profileB_, s14_.add_, s14_.mixedNumericTypes_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
    }

    @Override
    public double executeDouble(VirtualFrame frameValue) throws UnexpectedResultException {
        int state = state_;
        if ((state & 0b10000000000100) != 0 /* is-active doIntOverflow(int, int) || doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */) {
            return JSTypesGen.expectDouble(execute(frameValue));
        }
        int leftNodeValue_int = 0;
        long leftNodeValue_long = 0L;
        double leftNodeValue_;
        try {
            if ((state & 0x38000) == 0 /* only-active 0:double */ && (state & 0b11111111111111) != 0  /* is-not doIntTruncate(int, int) && doInt(int, int) && doIntOverflow(int, int) && doIntSafeInteger(int, SafeInteger) && doSafeIntegerInt(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doString(CharSequence, CharSequence, JSConcatStringsNode) && doStringInt(CharSequence, int) && doIntString(int, CharSequence) && doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) && doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) && doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */) {
                leftNodeValue_long = super.leftNode.executeLong(frameValue);
                leftNodeValue_ = JSTypes.longToDouble(leftNodeValue_long);
            } else if ((state & 0x34000) == 0 /* only-active 0:double */ && (state & 0b11111111111111) != 0  /* is-not doIntTruncate(int, int) && doInt(int, int) && doIntOverflow(int, int) && doIntSafeInteger(int, SafeInteger) && doSafeIntegerInt(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doString(CharSequence, CharSequence, JSConcatStringsNode) && doStringInt(CharSequence, int) && doIntString(int, CharSequence) && doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) && doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) && doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */) {
                leftNodeValue_int = super.leftNode.executeInt(frameValue);
                leftNodeValue_ = JSTypes.intToDouble(leftNodeValue_int);
            } else if ((state & 0x2c000) == 0 /* only-active 0:double */ && (state & 0b11111111111111) != 0  /* is-not doIntTruncate(int, int) && doInt(int, int) && doIntOverflow(int, int) && doIntSafeInteger(int, SafeInteger) && doSafeIntegerInt(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doString(CharSequence, CharSequence, JSConcatStringsNode) && doStringInt(CharSequence, int) && doIntString(int, CharSequence) && doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) && doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) && doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */) {
                leftNodeValue_ = super.leftNode.executeDouble(frameValue);
            } else {
                Object leftNodeValue__ = super.leftNode.execute(frameValue);
                leftNodeValue_ = JSTypesGen.expectImplicitDouble((state & 0x3c000) >>> 14 /* extract-implicit-active 0:double */, leftNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            Object rightNodeValue = super.rightNode.execute(frameValue);
            return JSTypesGen.expectDouble(executeAndSpecialize(ex.getResult(), rightNodeValue));
        }
        int rightNodeValue_int = 0;
        long rightNodeValue_long = 0L;
        double rightNodeValue_;
        try {
            if ((state & 0x380000) == 0 /* only-active 1:double */ && (state & 0b11111111111111) != 0  /* is-not doIntTruncate(int, int) && doInt(int, int) && doIntOverflow(int, int) && doIntSafeInteger(int, SafeInteger) && doSafeIntegerInt(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doString(CharSequence, CharSequence, JSConcatStringsNode) && doStringInt(CharSequence, int) && doIntString(int, CharSequence) && doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) && doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) && doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */) {
                rightNodeValue_long = super.rightNode.executeLong(frameValue);
                rightNodeValue_ = JSTypes.longToDouble(rightNodeValue_long);
            } else if ((state & 0x340000) == 0 /* only-active 1:double */ && (state & 0b11111111111111) != 0  /* is-not doIntTruncate(int, int) && doInt(int, int) && doIntOverflow(int, int) && doIntSafeInteger(int, SafeInteger) && doSafeIntegerInt(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doString(CharSequence, CharSequence, JSConcatStringsNode) && doStringInt(CharSequence, int) && doIntString(int, CharSequence) && doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) && doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) && doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */) {
                rightNodeValue_int = super.rightNode.executeInt(frameValue);
                rightNodeValue_ = JSTypes.intToDouble(rightNodeValue_int);
            } else if ((state & 0x2c0000) == 0 /* only-active 1:double */ && (state & 0b11111111111111) != 0  /* is-not doIntTruncate(int, int) && doInt(int, int) && doIntOverflow(int, int) && doIntSafeInteger(int, SafeInteger) && doSafeIntegerInt(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doString(CharSequence, CharSequence, JSConcatStringsNode) && doStringInt(CharSequence, int) && doIntString(int, CharSequence) && doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) && doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) && doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */) {
                rightNodeValue_ = super.rightNode.executeDouble(frameValue);
            } else {
                Object rightNodeValue__ = super.rightNode.execute(frameValue);
                rightNodeValue_ = JSTypesGen.expectImplicitDouble((state & 0x3c0000) >>> 18 /* extract-implicit-active 1:double */, rightNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectDouble(executeAndSpecialize(((state & 0x38000) == 0 /* only-active 0:double */ && (state & 0b11111111111111) != 0  /* is-not doIntTruncate(int, int) && doInt(int, int) && doIntOverflow(int, int) && doIntSafeInteger(int, SafeInteger) && doSafeIntegerInt(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doString(CharSequence, CharSequence, JSConcatStringsNode) && doStringInt(CharSequence, int) && doIntString(int, CharSequence) && doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) && doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) && doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */ ? (Object) leftNodeValue_long : ((state & 0x34000) == 0 /* only-active 0:double */ && (state & 0b11111111111111) != 0  /* is-not doIntTruncate(int, int) && doInt(int, int) && doIntOverflow(int, int) && doIntSafeInteger(int, SafeInteger) && doSafeIntegerInt(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doString(CharSequence, CharSequence, JSConcatStringsNode) && doStringInt(CharSequence, int) && doIntString(int, CharSequence) && doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) && doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) && doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */ ? (Object) leftNodeValue_int : (Object) leftNodeValue_)), ex.getResult()));
        }
        if ((state & 0b1000000) != 0 /* is-active doDouble(double, double) */) {
            return JSAddNode.doDouble(leftNodeValue_, rightNodeValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectDouble(executeAndSpecialize(((state & 0x38000) == 0 /* only-active 0:double */ && (state & 0b11111111111111) != 0  /* is-not doIntTruncate(int, int) && doInt(int, int) && doIntOverflow(int, int) && doIntSafeInteger(int, SafeInteger) && doSafeIntegerInt(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doString(CharSequence, CharSequence, JSConcatStringsNode) && doStringInt(CharSequence, int) && doIntString(int, CharSequence) && doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) && doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) && doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */ ? (Object) leftNodeValue_long : ((state & 0x34000) == 0 /* only-active 0:double */ && (state & 0b11111111111111) != 0  /* is-not doIntTruncate(int, int) && doInt(int, int) && doIntOverflow(int, int) && doIntSafeInteger(int, SafeInteger) && doSafeIntegerInt(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doString(CharSequence, CharSequence, JSConcatStringsNode) && doStringInt(CharSequence, int) && doIntString(int, CharSequence) && doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) && doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) && doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */ ? (Object) leftNodeValue_int : (Object) leftNodeValue_)), ((state & 0x380000) == 0 /* only-active 1:double */ && (state & 0b11111111111111) != 0  /* is-not doIntTruncate(int, int) && doInt(int, int) && doIntOverflow(int, int) && doIntSafeInteger(int, SafeInteger) && doSafeIntegerInt(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doString(CharSequence, CharSequence, JSConcatStringsNode) && doStringInt(CharSequence, int) && doIntString(int, CharSequence) && doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) && doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) && doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */ ? (Object) rightNodeValue_long : ((state & 0x340000) == 0 /* only-active 1:double */ && (state & 0b11111111111111) != 0  /* is-not doIntTruncate(int, int) && doInt(int, int) && doIntOverflow(int, int) && doIntSafeInteger(int, SafeInteger) && doSafeIntegerInt(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doString(CharSequence, CharSequence, JSConcatStringsNode) && doStringInt(CharSequence, int) && doIntString(int, CharSequence) && doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) && doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) && doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */ ? (Object) rightNodeValue_int : (Object) rightNodeValue_))));
    }

    @Override
    public int executeInt(VirtualFrame frameValue) throws UnexpectedResultException {
        int state = state_;
        if ((state & 0b10000000000100) != 0 /* is-active doIntOverflow(int, int) || doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */) {
            return JSTypesGen.expectInteger(execute(frameValue));
        }
        int leftNodeValue_;
        try {
            leftNodeValue_ = super.leftNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            Object rightNodeValue = super.rightNode.execute(frameValue);
            return JSTypesGen.expectInteger(executeAndSpecialize(ex.getResult(), rightNodeValue));
        }
        int rightNodeValue_;
        try {
            rightNodeValue_ = super.rightNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectInteger(executeAndSpecialize(leftNodeValue_, ex.getResult()));
        }
        if ((state & 0b1) != 0 /* is-active doIntTruncate(int, int) */) {
            assert (truncate);
            return JSAddNode.doIntTruncate(leftNodeValue_, rightNodeValue_);
        }
        if ((state & 0b10) != 0 /* is-active doInt(int, int) */) {
            assert (!(truncate));
            try {
                return JSAddNode.doInt(leftNodeValue_, rightNodeValue_);
            } catch (ArithmeticException ex) {
                // implicit transferToInterpreterAndInvalidate()
                Lock lock = getLock();
                lock.lock();
                try {
                    this.exclude_ = this.exclude_ | 0b10 /* add-excluded doInt(int, int) */;
                    this.state_ = this.state_ & 0xfffffffd /* remove-active doInt(int, int) */;
                } finally {
                    lock.unlock();
                }
                return JSTypesGen.expectInteger(executeAndSpecialize(leftNodeValue_, rightNodeValue_));
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectInteger(executeAndSpecialize(leftNodeValue_, rightNodeValue_));
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        int state = state_;
        try {
            if ((state & 0b11111111111100) == 0 /* only-active doIntTruncate(int, int) && doInt(int, int) */ && (state & 0b11111111111111) != 0  /* is-not doIntTruncate(int, int) && doInt(int, int) && doIntOverflow(int, int) && doIntSafeInteger(int, SafeInteger) && doSafeIntegerInt(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doString(CharSequence, CharSequence, JSConcatStringsNode) && doStringInt(CharSequence, int) && doIntString(int, CharSequence) && doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) && doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) && doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */) {
                executeInt(frameValue);
                return;
            } else if ((state & 0b11111110111111) == 0 /* only-active doDouble(double, double) */ && (state & 0b11111111111111) != 0  /* is-not doIntTruncate(int, int) && doInt(int, int) && doIntOverflow(int, int) && doIntSafeInteger(int, SafeInteger) && doSafeIntegerInt(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doBigInt(BigInt, BigInt) && doString(CharSequence, CharSequence, JSConcatStringsNode) && doStringInt(CharSequence, int) && doIntString(int, CharSequence) && doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) && doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) && doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */) {
                executeDouble(frameValue);
                return;
            }
            execute(frameValue);
            return;
        } catch (UnexpectedResultException ex) {
            return;
        }
    }

    private Object executeAndSpecialize(Object leftNodeValue, Object rightNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        int exclude = exclude_;
        try {
            if (leftNodeValue instanceof Integer) {
                int leftNodeValue_ = (int) leftNodeValue;
                if (rightNodeValue instanceof Integer) {
                    int rightNodeValue_ = (int) rightNodeValue;
                    if (((exclude & 0b1)) == 0 /* is-not-excluded doIntTruncate(int, int) */) {
                        if ((truncate)) {
                            this.state_ = state = state | 0b1 /* add-active doIntTruncate(int, int) */;
                            lock.unlock();
                            hasLock = false;
                            return JSAddNode.doIntTruncate(leftNodeValue_, rightNodeValue_);
                        }
                    }
                    if (((exclude & 0b10)) == 0 /* is-not-excluded doInt(int, int) */) {
                        if ((!(truncate))) {
                            this.state_ = state = state | 0b10 /* add-active doInt(int, int) */;
                            try {
                                lock.unlock();
                                hasLock = false;
                                return JSAddNode.doInt(leftNodeValue_, rightNodeValue_);
                            } catch (ArithmeticException ex) {
                                // implicit transferToInterpreterAndInvalidate()
                                lock.lock();
                                try {
                                    this.exclude_ = this.exclude_ | 0b10 /* add-excluded doInt(int, int) */;
                                    this.state_ = this.state_ & 0xfffffffd /* remove-active doInt(int, int) */;
                                } finally {
                                    lock.unlock();
                                }
                                return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
                            }
                        }
                    }
                    if (((exclude & 0b100)) == 0 /* is-not-excluded doIntOverflow(int, int) */) {
                        if ((!(truncate))) {
                            this.state_ = state = state | 0b100 /* add-active doIntOverflow(int, int) */;
                            try {
                                lock.unlock();
                                hasLock = false;
                                return JSAddNode.doIntOverflow(leftNodeValue_, rightNodeValue_);
                            } catch (ArithmeticException ex) {
                                // implicit transferToInterpreterAndInvalidate()
                                lock.lock();
                                try {
                                    this.exclude_ = this.exclude_ | 0b100 /* add-excluded doIntOverflow(int, int) */;
                                    this.state_ = this.state_ & 0xfffffffb /* remove-active doIntOverflow(int, int) */;
                                } finally {
                                    lock.unlock();
                                }
                                return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
                            }
                        }
                    }
                }
                if (((exclude & 0b1000)) == 0 /* is-not-excluded doIntSafeInteger(int, SafeInteger) */ && rightNodeValue instanceof SafeInteger) {
                    SafeInteger rightNodeValue_ = (SafeInteger) rightNodeValue;
                    this.state_ = state = state | 0b1000 /* add-active doIntSafeInteger(int, SafeInteger) */;
                    try {
                        lock.unlock();
                        hasLock = false;
                        return JSAddNode.doIntSafeInteger(leftNodeValue_, rightNodeValue_);
                    } catch (ArithmeticException ex) {
                        // implicit transferToInterpreterAndInvalidate()
                        lock.lock();
                        try {
                            this.exclude_ = this.exclude_ | 0b1000 /* add-excluded doIntSafeInteger(int, SafeInteger) */;
                            this.state_ = this.state_ & 0xfffffff7 /* remove-active doIntSafeInteger(int, SafeInteger) */;
                        } finally {
                            lock.unlock();
                        }
                        return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
                    }
                }
            }
            if (leftNodeValue instanceof SafeInteger) {
                SafeInteger leftNodeValue_ = (SafeInteger) leftNodeValue;
                if (((exclude & 0b10000)) == 0 /* is-not-excluded doSafeIntegerInt(SafeInteger, int) */ && rightNodeValue instanceof Integer) {
                    int rightNodeValue_ = (int) rightNodeValue;
                    this.state_ = state = state | 0b10000 /* add-active doSafeIntegerInt(SafeInteger, int) */;
                    try {
                        lock.unlock();
                        hasLock = false;
                        return JSAddNode.doSafeIntegerInt(leftNodeValue_, rightNodeValue_);
                    } catch (ArithmeticException ex) {
                        // implicit transferToInterpreterAndInvalidate()
                        lock.lock();
                        try {
                            this.exclude_ = this.exclude_ | 0b10000 /* add-excluded doSafeIntegerInt(SafeInteger, int) */;
                            this.state_ = this.state_ & 0xffffffef /* remove-active doSafeIntegerInt(SafeInteger, int) */;
                        } finally {
                            lock.unlock();
                        }
                        return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
                    }
                }
                if (((exclude & 0b100000)) == 0 /* is-not-excluded doSafeInteger(SafeInteger, SafeInteger) */ && rightNodeValue instanceof SafeInteger) {
                    SafeInteger rightNodeValue_ = (SafeInteger) rightNodeValue;
                    this.state_ = state = state | 0b100000 /* add-active doSafeInteger(SafeInteger, SafeInteger) */;
                    try {
                        lock.unlock();
                        hasLock = false;
                        return JSAddNode.doSafeInteger(leftNodeValue_, rightNodeValue_);
                    } catch (ArithmeticException ex) {
                        // implicit transferToInterpreterAndInvalidate()
                        lock.lock();
                        try {
                            this.exclude_ = this.exclude_ | 0b100000 /* add-excluded doSafeInteger(SafeInteger, SafeInteger) */;
                            this.state_ = this.state_ & 0xffffffdf /* remove-active doSafeInteger(SafeInteger, SafeInteger) */;
                        } finally {
                            lock.unlock();
                        }
                        return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
                    }
                }
            }
            if (((exclude & 0b1000000)) == 0 /* is-not-excluded doDouble(double, double) */) {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(leftNodeValue)) != 0) {
                    double leftNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast0, leftNodeValue);
                    int doubleCast1;
                    if ((doubleCast1 = JSTypesGen.specializeImplicitDouble(rightNodeValue)) != 0) {
                        double rightNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast1, rightNodeValue);
                        state = (state | (doubleCast0 << 14) /* set-implicit-active 0:double */);
                        state = (state | (doubleCast1 << 18) /* set-implicit-active 1:double */);
                        this.state_ = state = state | 0b1000000 /* add-active doDouble(double, double) */;
                        lock.unlock();
                        hasLock = false;
                        return JSAddNode.doDouble(leftNodeValue_, rightNodeValue_);
                    }
                }
            }
            if (((exclude & 0b10000000)) == 0 /* is-not-excluded doBigInt(BigInt, BigInt) */ && leftNodeValue instanceof BigInt) {
                BigInt leftNodeValue_ = (BigInt) leftNodeValue;
                if (rightNodeValue instanceof BigInt) {
                    BigInt rightNodeValue_ = (BigInt) rightNodeValue;
                    this.state_ = state = state | 0b10000000 /* add-active doBigInt(BigInt, BigInt) */;
                    lock.unlock();
                    hasLock = false;
                    return doBigInt(leftNodeValue_, rightNodeValue_);
                }
            }
            {
                int charSequenceCast0;
                if ((charSequenceCast0 = JSTypesGen.specializeImplicitCharSequence(leftNodeValue)) != 0) {
                    CharSequence leftNodeValue_ = JSTypesGen.asImplicitCharSequence(charSequenceCast0, leftNodeValue);
                    if (((exclude & 0b100000000)) == 0 /* is-not-excluded doString(CharSequence, CharSequence, JSConcatStringsNode) */) {
                        int charSequenceCast1;
                        if ((charSequenceCast1 = JSTypesGen.specializeImplicitCharSequence(rightNodeValue)) != 0) {
                            CharSequence rightNodeValue_ = JSTypesGen.asImplicitCharSequence(charSequenceCast1, rightNodeValue);
                            if (this.concatStringsNode == null) {
                                this.concatStringsNode = super.insert((JSConcatStringsNode.create()));
                            }
                            state = (state | (charSequenceCast0 << 22) /* set-implicit-active 0:CharSequence */);
                            state = (state | (charSequenceCast1 << 26) /* set-implicit-active 1:CharSequence */);
                            this.state_ = state = state | 0b100000000 /* add-active doString(CharSequence, CharSequence, JSConcatStringsNode) */;
                            lock.unlock();
                            hasLock = false;
                            return doString(leftNodeValue_, rightNodeValue_, this.concatStringsNode);
                        }
                    }
                    if (((exclude & 0b1000000000)) == 0 /* is-not-excluded doStringInt(CharSequence, int) */ && rightNodeValue instanceof Integer) {
                        int rightNodeValue_ = (int) rightNodeValue;
                        state = (state | (charSequenceCast0 << 22) /* set-implicit-active 0:CharSequence */);
                        this.state_ = state = state | 0b1000000000 /* add-active doStringInt(CharSequence, int) */;
                        lock.unlock();
                        hasLock = false;
                        return doStringInt(leftNodeValue_, rightNodeValue_);
                    }
                }
            }
            if (((exclude & 0b10000000000)) == 0 /* is-not-excluded doIntString(int, CharSequence) */ && leftNodeValue instanceof Integer) {
                int leftNodeValue_ = (int) leftNodeValue;
                int charSequenceCast1;
                if ((charSequenceCast1 = JSTypesGen.specializeImplicitCharSequence(rightNodeValue)) != 0) {
                    CharSequence rightNodeValue_ = JSTypesGen.asImplicitCharSequence(charSequenceCast1, rightNodeValue);
                    state = (state | (charSequenceCast1 << 26) /* set-implicit-active 1:CharSequence */);
                    this.state_ = state = state | 0b10000000000 /* add-active doIntString(int, CharSequence) */;
                    lock.unlock();
                    hasLock = false;
                    return doIntString(leftNodeValue_, rightNodeValue_);
                }
            }
            if (((exclude & 0b100000000000)) == 0 /* is-not-excluded doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) */) {
                int charSequenceCast0;
                if ((charSequenceCast0 = JSTypesGen.specializeImplicitCharSequence(leftNodeValue)) != 0) {
                    CharSequence leftNodeValue_ = JSTypesGen.asImplicitCharSequence(charSequenceCast0, leftNodeValue);
                    if ((JSGuards.isNumber(rightNodeValue))) {
                        if (this.concatStringsNode == null) {
                            this.concatStringsNode = super.insert((JSConcatStringsNode.create()));
                        }
                        if (this.doubleToStringNode == null) {
                            this.doubleToStringNode = super.insert((JSDoubleToStringNode.create()));
                        }
                        state = (state | (charSequenceCast0 << 22) /* set-implicit-active 0:CharSequence */);
                        this.state_ = state = state | 0b100000000000 /* add-active doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) */;
                        lock.unlock();
                        hasLock = false;
                        return doStringNumber(leftNodeValue_, rightNodeValue, this.concatStringsNode, this.doubleToStringNode);
                    }
                }
            }
            if (((exclude & 0b1000000000000)) == 0 /* is-not-excluded doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) */) {
                int charSequenceCast1;
                if ((charSequenceCast1 = JSTypesGen.specializeImplicitCharSequence(rightNodeValue)) != 0) {
                    CharSequence rightNodeValue_ = JSTypesGen.asImplicitCharSequence(charSequenceCast1, rightNodeValue);
                    if ((JSGuards.isNumber(leftNodeValue))) {
                        if (this.concatStringsNode == null) {
                            this.concatStringsNode = super.insert((JSConcatStringsNode.create()));
                        }
                        if (this.doubleToStringNode == null) {
                            this.doubleToStringNode = super.insert((JSDoubleToStringNode.create()));
                        }
                        state = (state | (charSequenceCast1 << 26) /* set-implicit-active 1:CharSequence */);
                        this.state_ = state = state | 0b1000000000000 /* add-active doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) */;
                        lock.unlock();
                        hasLock = false;
                        return doNumberString(leftNodeValue, rightNodeValue_, this.concatStringsNode, this.doubleToStringNode);
                    }
                }
            }
            PrimitiveConversionData s14_ = super.insert(new PrimitiveConversionData());
            s14_.toPrimitiveA_ = s14_.insertAccessor((JSToPrimitiveNode.createHintNone()));
            s14_.toPrimitiveB_ = s14_.insertAccessor((JSToPrimitiveNode.createHintNone()));
            s14_.toNumericA_ = s14_.insertAccessor((JSToNumericNode.create()));
            s14_.toNumericB_ = s14_.insertAccessor((JSToNumericNode.create()));
            s14_.toStringA_ = s14_.insertAccessor((JSToStringNode.create()));
            s14_.toStringB_ = s14_.insertAccessor((JSToStringNode.create()));
            s14_.profileA_ = (ConditionProfile.createBinaryProfile());
            s14_.profileB_ = (ConditionProfile.createBinaryProfile());
            s14_.add_ = s14_.insertAccessor((copyRecursive()));
            s14_.mixedNumericTypes_ = (BranchProfile.create());
            this.primitiveConversion_cache = s14_;
            this.exclude_ = exclude = exclude | 0b1111111111111 /* add-excluded doIntTruncate(int, int), doInt(int, int), doIntOverflow(int, int), doIntSafeInteger(int, SafeInteger), doSafeIntegerInt(SafeInteger, int), doSafeInteger(SafeInteger, SafeInteger), doDouble(double, double), doBigInt(BigInt, BigInt), doString(CharSequence, CharSequence, JSConcatStringsNode), doStringInt(CharSequence, int), doIntString(int, CharSequence), doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode), doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) */;
            state = state & 0xffffe000 /* remove-active doIntTruncate(int, int), doInt(int, int), doIntOverflow(int, int), doIntSafeInteger(int, SafeInteger), doSafeIntegerInt(SafeInteger, int), doSafeInteger(SafeInteger, SafeInteger), doDouble(double, double), doBigInt(BigInt, BigInt), doString(CharSequence, CharSequence, JSConcatStringsNode), doStringInt(CharSequence, int), doIntString(int, CharSequence), doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode), doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) */;
            this.state_ = state = state | 0b10000000000000 /* add-active doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */;
            lock.unlock();
            hasLock = false;
            return doPrimitiveConversion(leftNodeValue, rightNodeValue, s14_.toPrimitiveA_, s14_.toPrimitiveB_, s14_.toNumericA_, s14_.toNumericB_, s14_.toStringA_, s14_.toStringB_, s14_.profileA_, s14_.profileB_, s14_.add_, s14_.mixedNumericTypes_);
        } finally {
            if (hasLock) {
                lock.unlock();
            }
        }
    }

    @Override
    public NodeCost getCost() {
        int state = state_;
        if ((state & 0b11111111111111) == 0b0) {
            return NodeCost.UNINITIALIZED;
        } else if (((state & 0b11111111111111) & ((state & 0b11111111111111) - 1)) == 0 /* is-single-active  */) {
            return NodeCost.MONOMORPHIC;
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[15];
        Object[] s;
        data[0] = 0;
        int state = state_;
        int exclude = exclude_;
        s = new Object[3];
        s[0] = "doIntTruncate";
        if ((state & 0b1) != 0 /* is-active doIntTruncate(int, int) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b1) != 0 /* is-excluded doIntTruncate(int, int) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doInt";
        if ((state & 0b10) != 0 /* is-active doInt(int, int) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b10) != 0 /* is-excluded doInt(int, int) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doIntOverflow";
        if ((state & 0b100) != 0 /* is-active doIntOverflow(int, int) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b100) != 0 /* is-excluded doIntOverflow(int, int) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doIntSafeInteger";
        if ((state & 0b1000) != 0 /* is-active doIntSafeInteger(int, SafeInteger) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b1000) != 0 /* is-excluded doIntSafeInteger(int, SafeInteger) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doSafeIntegerInt";
        if ((state & 0b10000) != 0 /* is-active doSafeIntegerInt(SafeInteger, int) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b10000) != 0 /* is-excluded doSafeIntegerInt(SafeInteger, int) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "doSafeInteger";
        if ((state & 0b100000) != 0 /* is-active doSafeInteger(SafeInteger, SafeInteger) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b100000) != 0 /* is-excluded doSafeInteger(SafeInteger, SafeInteger) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "doDouble";
        if ((state & 0b1000000) != 0 /* is-active doDouble(double, double) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b1000000) != 0 /* is-excluded doDouble(double, double) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        s = new Object[3];
        s[0] = "doBigInt";
        if ((state & 0b10000000) != 0 /* is-active doBigInt(BigInt, BigInt) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b10000000) != 0 /* is-excluded doBigInt(BigInt, BigInt) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[8] = s;
        s = new Object[3];
        s[0] = "doString";
        if ((state & 0b100000000) != 0 /* is-active doString(CharSequence, CharSequence, JSConcatStringsNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.concatStringsNode));
            s[2] = cached;
        } else if ((exclude & 0b100000000) != 0 /* is-excluded doString(CharSequence, CharSequence, JSConcatStringsNode) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[9] = s;
        s = new Object[3];
        s[0] = "doStringInt";
        if ((state & 0b1000000000) != 0 /* is-active doStringInt(CharSequence, int) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b1000000000) != 0 /* is-excluded doStringInt(CharSequence, int) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[10] = s;
        s = new Object[3];
        s[0] = "doIntString";
        if ((state & 0b10000000000) != 0 /* is-active doIntString(int, CharSequence) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b10000000000) != 0 /* is-excluded doIntString(int, CharSequence) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[11] = s;
        s = new Object[3];
        s[0] = "doStringNumber";
        if ((state & 0b100000000000) != 0 /* is-active doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.concatStringsNode, this.doubleToStringNode));
            s[2] = cached;
        } else if ((exclude & 0b100000000000) != 0 /* is-excluded doStringNumber(CharSequence, Object, JSConcatStringsNode, JSDoubleToStringNode) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[12] = s;
        s = new Object[3];
        s[0] = "doNumberString";
        if ((state & 0b1000000000000) != 0 /* is-active doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.concatStringsNode, this.doubleToStringNode));
            s[2] = cached;
        } else if ((exclude & 0b1000000000000) != 0 /* is-excluded doNumberString(Object, CharSequence, JSConcatStringsNode, JSDoubleToStringNode) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[13] = s;
        s = new Object[3];
        s[0] = "doPrimitiveConversion";
        if ((state & 0b10000000000000) != 0 /* is-active doPrimitiveConversion(Object, Object, JSToPrimitiveNode, JSToPrimitiveNode, JSToNumericNode, JSToNumericNode, JSToStringNode, JSToStringNode, ConditionProfile, ConditionProfile, JSAddNode, BranchProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            PrimitiveConversionData s14_ = this.primitiveConversion_cache;
            if (s14_ != null) {
                cached.add(Arrays.asList(s14_.toPrimitiveA_, s14_.toPrimitiveB_, s14_.toNumericA_, s14_.toNumericB_, s14_.toStringA_, s14_.toStringB_, s14_.profileA_, s14_.profileB_, s14_.add_, s14_.mixedNumericTypes_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[14] = s;
        return Provider.create(data);
    }

    public static JSAddNode create(boolean truncate, JavaScriptNode left, JavaScriptNode right) {
        return new JSAddNodeGen(truncate, left, right);
    }

    @GeneratedBy(JSAddNode.class)
    private static final class PrimitiveConversionData extends Node {

        @Child JSToPrimitiveNode toPrimitiveA_;
        @Child JSToPrimitiveNode toPrimitiveB_;
        @Child JSToNumericNode toNumericA_;
        @Child JSToNumericNode toNumericB_;
        @Child JSToStringNode toStringA_;
        @Child JSToStringNode toStringB_;
        @CompilationFinal ConditionProfile profileA_;
        @CompilationFinal ConditionProfile profileB_;
        @Child JSAddNode add_;
        @CompilationFinal BranchProfile mixedNumericTypes_;

        PrimitiveConversionData() {
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
