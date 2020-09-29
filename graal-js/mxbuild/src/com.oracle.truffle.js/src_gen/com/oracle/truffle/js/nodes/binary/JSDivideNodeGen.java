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

@GeneratedBy(JSDivideNode.class)
public final class JSDivideNodeGen extends JSDivideNode implements Provider {

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @Child private GenericData generic_cache;

    private JSDivideNodeGen(JavaScriptNode left, JavaScriptNode right) {
        super(left, right);
    }

    @Override
    public Object execute(Object leftNodeValue, Object rightNodeValue) {
        int state = state_;
        if ((state & 0b111) != 0 /* is-active doInt1(int, int) || doInt2(int, int) || doInt3(int, int) */ && leftNodeValue instanceof Integer) {
            int leftNodeValue_ = (int) leftNodeValue;
            if (rightNodeValue instanceof Integer) {
                int rightNodeValue_ = (int) rightNodeValue;
                if ((state & 0b1) != 0 /* is-active doInt1(int, int) */) {
                    if ((rightNodeValue_ > 0)) {
                        try {
                            return doInt1(leftNodeValue_, rightNodeValue_);
                        } catch (ArithmeticException ex) {
                            // implicit transferToInterpreterAndInvalidate()
                            Lock lock = getLock();
                            lock.lock();
                            try {
                                this.exclude_ = this.exclude_ | 0b1 /* add-excluded doInt1(int, int) */;
                                this.state_ = this.state_ & 0xfffffffe /* remove-active doInt1(int, int) */;
                            } finally {
                                lock.unlock();
                            }
                            return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
                        }
                    }
                }
                if ((state & 0b10) != 0 /* is-active doInt2(int, int) */) {
                    if ((leftNodeValue_ > 0)) {
                        try {
                            return doInt2(leftNodeValue_, rightNodeValue_);
                        } catch (ArithmeticException ex) {
                            // implicit transferToInterpreterAndInvalidate()
                            Lock lock = getLock();
                            lock.lock();
                            try {
                                this.exclude_ = this.exclude_ | 0b10 /* add-excluded doInt2(int, int) */;
                                this.state_ = this.state_ & 0xfffffffd /* remove-active doInt2(int, int) */;
                            } finally {
                                lock.unlock();
                            }
                            return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
                        }
                    }
                }
                if ((state & 0b100) != 0 /* is-active doInt3(int, int) */) {
                    if ((JSDivideNode.isCornercase(leftNodeValue_, rightNodeValue_))) {
                        try {
                            return doInt3(leftNodeValue_, rightNodeValue_);
                        } catch (ArithmeticException ex) {
                            // implicit transferToInterpreterAndInvalidate()
                            Lock lock = getLock();
                            lock.lock();
                            try {
                                this.exclude_ = this.exclude_ | 0b100 /* add-excluded doInt3(int, int) */;
                                this.state_ = this.state_ & 0xfffffffb /* remove-active doInt3(int, int) */;
                            } finally {
                                lock.unlock();
                            }
                            return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
                        }
                    }
                }
            }
        }
        if ((state & 0b1000) != 0 /* is-active doDouble(double, double) */ && JSTypesGen.isImplicitDouble((state & 0b11110000000) >>> 7 /* extract-implicit-active 0:double */, leftNodeValue)) {
            double leftNodeValue_ = JSTypesGen.asImplicitDouble((state & 0b11110000000) >>> 7 /* extract-implicit-active 0:double */, leftNodeValue);
            if (JSTypesGen.isImplicitDouble((state & 0b111100000000000) >>> 11 /* extract-implicit-active 1:double */, rightNodeValue)) {
                double rightNodeValue_ = JSTypesGen.asImplicitDouble((state & 0b111100000000000) >>> 11 /* extract-implicit-active 1:double */, rightNodeValue);
                return doDouble(leftNodeValue_, rightNodeValue_);
            }
        }
        if ((state & 0b110000) != 0 /* is-active doBigIntZeroDivision(BigInt, BigInt) || doBigInt(BigInt, BigInt) */ && leftNodeValue instanceof BigInt) {
            BigInt leftNodeValue_ = (BigInt) leftNodeValue;
            if (rightNodeValue instanceof BigInt) {
                BigInt rightNodeValue_ = (BigInt) rightNodeValue;
                if ((state & 0b10000) != 0 /* is-active doBigIntZeroDivision(BigInt, BigInt) */) {
                    if ((JSGuards.isBigIntZero(rightNodeValue_))) {
                        return doBigIntZeroDivision(leftNodeValue_, rightNodeValue_);
                    }
                }
                if ((state & 0b100000) != 0 /* is-active doBigInt(BigInt, BigInt) */) {
                    if ((!(JSGuards.isBigIntZero(rightNodeValue_)))) {
                        return doBigInt(leftNodeValue_, rightNodeValue_);
                    }
                }
            }
        }
        if ((state & 0b1000000) != 0 /* is-active doGeneric(Object, Object, JSDivideNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
            GenericData s7_ = this.generic_cache;
            if (s7_ != null) {
                return doGeneric(leftNodeValue, rightNodeValue, s7_.nestedDivideNode_, s7_.toNumeric1Node_, s7_.toNumeric2Node_, s7_.mixedNumericTypes_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(leftNodeValue, rightNodeValue);
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        int state = state_;
        if ((state & 0b1111000) == 0 /* only-active doInt1(int, int) && doInt2(int, int) && doInt3(int, int) */ && (state & 0b1111111) != 0  /* is-not doInt1(int, int) && doInt2(int, int) && doInt3(int, int) && doDouble(double, double) && doBigIntZeroDivision(BigInt, BigInt) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSDivideNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
            return execute_int_int0(frameValue, state);
        } else if ((state & 0b1110111) == 0 /* only-active doDouble(double, double) */ && (state & 0b1111111) != 0  /* is-not doInt1(int, int) && doInt2(int, int) && doInt3(int, int) && doDouble(double, double) && doBigIntZeroDivision(BigInt, BigInt) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSDivideNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
            return execute_double_double1(frameValue, state);
        } else {
            return execute_generic2(frameValue, state);
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
        if ((state & 0b1) != 0 /* is-active doInt1(int, int) */) {
            if ((rightNodeValue_ > 0)) {
                try {
                    return doInt1(leftNodeValue_, rightNodeValue_);
                } catch (ArithmeticException ex) {
                    // implicit transferToInterpreterAndInvalidate()
                    Lock lock = getLock();
                    lock.lock();
                    try {
                        this.exclude_ = this.exclude_ | 0b1 /* add-excluded doInt1(int, int) */;
                        this.state_ = this.state_ & 0xfffffffe /* remove-active doInt1(int, int) */;
                    } finally {
                        lock.unlock();
                    }
                    return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
                }
            }
        }
        if ((state & 0b10) != 0 /* is-active doInt2(int, int) */) {
            if ((leftNodeValue_ > 0)) {
                try {
                    return doInt2(leftNodeValue_, rightNodeValue_);
                } catch (ArithmeticException ex) {
                    // implicit transferToInterpreterAndInvalidate()
                    Lock lock = getLock();
                    lock.lock();
                    try {
                        this.exclude_ = this.exclude_ | 0b10 /* add-excluded doInt2(int, int) */;
                        this.state_ = this.state_ & 0xfffffffd /* remove-active doInt2(int, int) */;
                    } finally {
                        lock.unlock();
                    }
                    return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
                }
            }
        }
        if ((state & 0b100) != 0 /* is-active doInt3(int, int) */) {
            if ((JSDivideNode.isCornercase(leftNodeValue_, rightNodeValue_))) {
                try {
                    return doInt3(leftNodeValue_, rightNodeValue_);
                } catch (ArithmeticException ex) {
                    // implicit transferToInterpreterAndInvalidate()
                    Lock lock = getLock();
                    lock.lock();
                    try {
                        this.exclude_ = this.exclude_ | 0b100 /* add-excluded doInt3(int, int) */;
                        this.state_ = this.state_ & 0xfffffffb /* remove-active doInt3(int, int) */;
                    } finally {
                        lock.unlock();
                    }
                    return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
                }
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
            if ((state & 0b11100000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not doInt1(int, int) && doInt2(int, int) && doInt3(int, int) && doDouble(double, double) && doBigIntZeroDivision(BigInt, BigInt) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSDivideNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
                leftNodeValue_long = super.leftNode.executeLong(frameValue);
                leftNodeValue_ = JSTypes.longToDouble(leftNodeValue_long);
            } else if ((state & 0b11010000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not doInt1(int, int) && doInt2(int, int) && doInt3(int, int) && doDouble(double, double) && doBigIntZeroDivision(BigInt, BigInt) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSDivideNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
                leftNodeValue_int = super.leftNode.executeInt(frameValue);
                leftNodeValue_ = JSTypes.intToDouble(leftNodeValue_int);
            } else if ((state & 0b10110000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not doInt1(int, int) && doInt2(int, int) && doInt3(int, int) && doDouble(double, double) && doBigIntZeroDivision(BigInt, BigInt) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSDivideNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
                leftNodeValue_ = super.leftNode.executeDouble(frameValue);
            } else {
                Object leftNodeValue__ = super.leftNode.execute(frameValue);
                leftNodeValue_ = JSTypesGen.expectImplicitDouble((state & 0b11110000000) >>> 7 /* extract-implicit-active 0:double */, leftNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            Object rightNodeValue = super.rightNode.execute(frameValue);
            return executeAndSpecialize(ex.getResult(), rightNodeValue);
        }
        int rightNodeValue_int = 0;
        long rightNodeValue_long = 0L;
        double rightNodeValue_;
        try {
            if ((state & 0b111000000000000) == 0 /* only-active 1:double */ && (state & 0b1111111) != 0  /* is-not doInt1(int, int) && doInt2(int, int) && doInt3(int, int) && doDouble(double, double) && doBigIntZeroDivision(BigInt, BigInt) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSDivideNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
                rightNodeValue_long = super.rightNode.executeLong(frameValue);
                rightNodeValue_ = JSTypes.longToDouble(rightNodeValue_long);
            } else if ((state & 0b110100000000000) == 0 /* only-active 1:double */ && (state & 0b1111111) != 0  /* is-not doInt1(int, int) && doInt2(int, int) && doInt3(int, int) && doDouble(double, double) && doBigIntZeroDivision(BigInt, BigInt) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSDivideNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
                rightNodeValue_int = super.rightNode.executeInt(frameValue);
                rightNodeValue_ = JSTypes.intToDouble(rightNodeValue_int);
            } else if ((state & 0b101100000000000) == 0 /* only-active 1:double */ && (state & 0b1111111) != 0  /* is-not doInt1(int, int) && doInt2(int, int) && doInt3(int, int) && doDouble(double, double) && doBigIntZeroDivision(BigInt, BigInt) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSDivideNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
                rightNodeValue_ = super.rightNode.executeDouble(frameValue);
            } else {
                Object rightNodeValue__ = super.rightNode.execute(frameValue);
                rightNodeValue_ = JSTypesGen.expectImplicitDouble((state & 0b111100000000000) >>> 11 /* extract-implicit-active 1:double */, rightNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(((state & 0b11100000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not doInt1(int, int) && doInt2(int, int) && doInt3(int, int) && doDouble(double, double) && doBigIntZeroDivision(BigInt, BigInt) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSDivideNode, JSToNumericNode, JSToNumericNode, BranchProfile) */ ? (Object) leftNodeValue_long : ((state & 0b11010000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not doInt1(int, int) && doInt2(int, int) && doInt3(int, int) && doDouble(double, double) && doBigIntZeroDivision(BigInt, BigInt) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSDivideNode, JSToNumericNode, JSToNumericNode, BranchProfile) */ ? (Object) leftNodeValue_int : (Object) leftNodeValue_)), ex.getResult());
        }
        assert (state & 0b1000) != 0 /* is-active doDouble(double, double) */;
        return doDouble(leftNodeValue_, rightNodeValue_);
    }

    private Object execute_generic2(VirtualFrame frameValue, int state) {
        Object leftNodeValue_ = super.leftNode.execute(frameValue);
        Object rightNodeValue_ = super.rightNode.execute(frameValue);
        if ((state & 0b111) != 0 /* is-active doInt1(int, int) || doInt2(int, int) || doInt3(int, int) */ && leftNodeValue_ instanceof Integer) {
            int leftNodeValue__ = (int) leftNodeValue_;
            if (rightNodeValue_ instanceof Integer) {
                int rightNodeValue__ = (int) rightNodeValue_;
                if ((state & 0b1) != 0 /* is-active doInt1(int, int) */) {
                    if ((rightNodeValue__ > 0)) {
                        try {
                            return doInt1(leftNodeValue__, rightNodeValue__);
                        } catch (ArithmeticException ex) {
                            // implicit transferToInterpreterAndInvalidate()
                            Lock lock = getLock();
                            lock.lock();
                            try {
                                this.exclude_ = this.exclude_ | 0b1 /* add-excluded doInt1(int, int) */;
                                this.state_ = this.state_ & 0xfffffffe /* remove-active doInt1(int, int) */;
                            } finally {
                                lock.unlock();
                            }
                            return executeAndSpecialize(leftNodeValue__, rightNodeValue__);
                        }
                    }
                }
                if ((state & 0b10) != 0 /* is-active doInt2(int, int) */) {
                    if ((leftNodeValue__ > 0)) {
                        try {
                            return doInt2(leftNodeValue__, rightNodeValue__);
                        } catch (ArithmeticException ex) {
                            // implicit transferToInterpreterAndInvalidate()
                            Lock lock = getLock();
                            lock.lock();
                            try {
                                this.exclude_ = this.exclude_ | 0b10 /* add-excluded doInt2(int, int) */;
                                this.state_ = this.state_ & 0xfffffffd /* remove-active doInt2(int, int) */;
                            } finally {
                                lock.unlock();
                            }
                            return executeAndSpecialize(leftNodeValue__, rightNodeValue__);
                        }
                    }
                }
                if ((state & 0b100) != 0 /* is-active doInt3(int, int) */) {
                    if ((JSDivideNode.isCornercase(leftNodeValue__, rightNodeValue__))) {
                        try {
                            return doInt3(leftNodeValue__, rightNodeValue__);
                        } catch (ArithmeticException ex) {
                            // implicit transferToInterpreterAndInvalidate()
                            Lock lock = getLock();
                            lock.lock();
                            try {
                                this.exclude_ = this.exclude_ | 0b100 /* add-excluded doInt3(int, int) */;
                                this.state_ = this.state_ & 0xfffffffb /* remove-active doInt3(int, int) */;
                            } finally {
                                lock.unlock();
                            }
                            return executeAndSpecialize(leftNodeValue__, rightNodeValue__);
                        }
                    }
                }
            }
        }
        if ((state & 0b1000) != 0 /* is-active doDouble(double, double) */ && JSTypesGen.isImplicitDouble((state & 0b11110000000) >>> 7 /* extract-implicit-active 0:double */, leftNodeValue_)) {
            double leftNodeValue__ = JSTypesGen.asImplicitDouble((state & 0b11110000000) >>> 7 /* extract-implicit-active 0:double */, leftNodeValue_);
            if (JSTypesGen.isImplicitDouble((state & 0b111100000000000) >>> 11 /* extract-implicit-active 1:double */, rightNodeValue_)) {
                double rightNodeValue__ = JSTypesGen.asImplicitDouble((state & 0b111100000000000) >>> 11 /* extract-implicit-active 1:double */, rightNodeValue_);
                return doDouble(leftNodeValue__, rightNodeValue__);
            }
        }
        if ((state & 0b110000) != 0 /* is-active doBigIntZeroDivision(BigInt, BigInt) || doBigInt(BigInt, BigInt) */ && leftNodeValue_ instanceof BigInt) {
            BigInt leftNodeValue__ = (BigInt) leftNodeValue_;
            if (rightNodeValue_ instanceof BigInt) {
                BigInt rightNodeValue__ = (BigInt) rightNodeValue_;
                if ((state & 0b10000) != 0 /* is-active doBigIntZeroDivision(BigInt, BigInt) */) {
                    if ((JSGuards.isBigIntZero(rightNodeValue__))) {
                        return doBigIntZeroDivision(leftNodeValue__, rightNodeValue__);
                    }
                }
                if ((state & 0b100000) != 0 /* is-active doBigInt(BigInt, BigInt) */) {
                    if ((!(JSGuards.isBigIntZero(rightNodeValue__)))) {
                        return doBigInt(leftNodeValue__, rightNodeValue__);
                    }
                }
            }
        }
        if ((state & 0b1000000) != 0 /* is-active doGeneric(Object, Object, JSDivideNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
            GenericData s7_ = this.generic_cache;
            if (s7_ != null) {
                return doGeneric(leftNodeValue_, rightNodeValue_, s7_.nestedDivideNode_, s7_.toNumeric1Node_, s7_.toNumeric2Node_, s7_.mixedNumericTypes_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
    }

    @Override
    public double executeDouble(VirtualFrame frameValue) throws UnexpectedResultException {
        int state = state_;
        if ((state & 0b1000000) != 0 /* is-active doGeneric(Object, Object, JSDivideNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
            return JSTypesGen.expectDouble(execute(frameValue));
        }
        int leftNodeValue_int = 0;
        long leftNodeValue_long = 0L;
        double leftNodeValue_;
        try {
            if ((state & 0b11100000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not doInt1(int, int) && doInt2(int, int) && doInt3(int, int) && doDouble(double, double) && doBigIntZeroDivision(BigInt, BigInt) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSDivideNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
                leftNodeValue_long = super.leftNode.executeLong(frameValue);
                leftNodeValue_ = JSTypes.longToDouble(leftNodeValue_long);
            } else if ((state & 0b11010000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not doInt1(int, int) && doInt2(int, int) && doInt3(int, int) && doDouble(double, double) && doBigIntZeroDivision(BigInt, BigInt) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSDivideNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
                leftNodeValue_int = super.leftNode.executeInt(frameValue);
                leftNodeValue_ = JSTypes.intToDouble(leftNodeValue_int);
            } else if ((state & 0b10110000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not doInt1(int, int) && doInt2(int, int) && doInt3(int, int) && doDouble(double, double) && doBigIntZeroDivision(BigInt, BigInt) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSDivideNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
                leftNodeValue_ = super.leftNode.executeDouble(frameValue);
            } else {
                Object leftNodeValue__ = super.leftNode.execute(frameValue);
                leftNodeValue_ = JSTypesGen.expectImplicitDouble((state & 0b11110000000) >>> 7 /* extract-implicit-active 0:double */, leftNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            Object rightNodeValue = super.rightNode.execute(frameValue);
            return JSTypesGen.expectDouble(executeAndSpecialize(ex.getResult(), rightNodeValue));
        }
        int rightNodeValue_int = 0;
        long rightNodeValue_long = 0L;
        double rightNodeValue_;
        try {
            if ((state & 0b111000000000000) == 0 /* only-active 1:double */ && (state & 0b1111111) != 0  /* is-not doInt1(int, int) && doInt2(int, int) && doInt3(int, int) && doDouble(double, double) && doBigIntZeroDivision(BigInt, BigInt) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSDivideNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
                rightNodeValue_long = super.rightNode.executeLong(frameValue);
                rightNodeValue_ = JSTypes.longToDouble(rightNodeValue_long);
            } else if ((state & 0b110100000000000) == 0 /* only-active 1:double */ && (state & 0b1111111) != 0  /* is-not doInt1(int, int) && doInt2(int, int) && doInt3(int, int) && doDouble(double, double) && doBigIntZeroDivision(BigInt, BigInt) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSDivideNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
                rightNodeValue_int = super.rightNode.executeInt(frameValue);
                rightNodeValue_ = JSTypes.intToDouble(rightNodeValue_int);
            } else if ((state & 0b101100000000000) == 0 /* only-active 1:double */ && (state & 0b1111111) != 0  /* is-not doInt1(int, int) && doInt2(int, int) && doInt3(int, int) && doDouble(double, double) && doBigIntZeroDivision(BigInt, BigInt) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSDivideNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
                rightNodeValue_ = super.rightNode.executeDouble(frameValue);
            } else {
                Object rightNodeValue__ = super.rightNode.execute(frameValue);
                rightNodeValue_ = JSTypesGen.expectImplicitDouble((state & 0b111100000000000) >>> 11 /* extract-implicit-active 1:double */, rightNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectDouble(executeAndSpecialize(((state & 0b11100000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not doInt1(int, int) && doInt2(int, int) && doInt3(int, int) && doDouble(double, double) && doBigIntZeroDivision(BigInt, BigInt) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSDivideNode, JSToNumericNode, JSToNumericNode, BranchProfile) */ ? (Object) leftNodeValue_long : ((state & 0b11010000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not doInt1(int, int) && doInt2(int, int) && doInt3(int, int) && doDouble(double, double) && doBigIntZeroDivision(BigInt, BigInt) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSDivideNode, JSToNumericNode, JSToNumericNode, BranchProfile) */ ? (Object) leftNodeValue_int : (Object) leftNodeValue_)), ex.getResult()));
        }
        if ((state & 0b1000) != 0 /* is-active doDouble(double, double) */) {
            return doDouble(leftNodeValue_, rightNodeValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectDouble(executeAndSpecialize(((state & 0b11100000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not doInt1(int, int) && doInt2(int, int) && doInt3(int, int) && doDouble(double, double) && doBigIntZeroDivision(BigInt, BigInt) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSDivideNode, JSToNumericNode, JSToNumericNode, BranchProfile) */ ? (Object) leftNodeValue_long : ((state & 0b11010000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not doInt1(int, int) && doInt2(int, int) && doInt3(int, int) && doDouble(double, double) && doBigIntZeroDivision(BigInt, BigInt) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSDivideNode, JSToNumericNode, JSToNumericNode, BranchProfile) */ ? (Object) leftNodeValue_int : (Object) leftNodeValue_)), ((state & 0b111000000000000) == 0 /* only-active 1:double */ && (state & 0b1111111) != 0  /* is-not doInt1(int, int) && doInt2(int, int) && doInt3(int, int) && doDouble(double, double) && doBigIntZeroDivision(BigInt, BigInt) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSDivideNode, JSToNumericNode, JSToNumericNode, BranchProfile) */ ? (Object) rightNodeValue_long : ((state & 0b110100000000000) == 0 /* only-active 1:double */ && (state & 0b1111111) != 0  /* is-not doInt1(int, int) && doInt2(int, int) && doInt3(int, int) && doDouble(double, double) && doBigIntZeroDivision(BigInt, BigInt) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSDivideNode, JSToNumericNode, JSToNumericNode, BranchProfile) */ ? (Object) rightNodeValue_int : (Object) rightNodeValue_))));
    }

    @Override
    public int executeInt(VirtualFrame frameValue) throws UnexpectedResultException {
        int state = state_;
        if ((state & 0b1000000) != 0 /* is-active doGeneric(Object, Object, JSDivideNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
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
        if ((state & 0b1) != 0 /* is-active doInt1(int, int) */) {
            if ((rightNodeValue_ > 0)) {
                try {
                    return doInt1(leftNodeValue_, rightNodeValue_);
                } catch (ArithmeticException ex) {
                    // implicit transferToInterpreterAndInvalidate()
                    Lock lock = getLock();
                    lock.lock();
                    try {
                        this.exclude_ = this.exclude_ | 0b1 /* add-excluded doInt1(int, int) */;
                        this.state_ = this.state_ & 0xfffffffe /* remove-active doInt1(int, int) */;
                    } finally {
                        lock.unlock();
                    }
                    return JSTypesGen.expectInteger(executeAndSpecialize(leftNodeValue_, rightNodeValue_));
                }
            }
        }
        if ((state & 0b10) != 0 /* is-active doInt2(int, int) */) {
            if ((leftNodeValue_ > 0)) {
                try {
                    return doInt2(leftNodeValue_, rightNodeValue_);
                } catch (ArithmeticException ex) {
                    // implicit transferToInterpreterAndInvalidate()
                    Lock lock = getLock();
                    lock.lock();
                    try {
                        this.exclude_ = this.exclude_ | 0b10 /* add-excluded doInt2(int, int) */;
                        this.state_ = this.state_ & 0xfffffffd /* remove-active doInt2(int, int) */;
                    } finally {
                        lock.unlock();
                    }
                    return JSTypesGen.expectInteger(executeAndSpecialize(leftNodeValue_, rightNodeValue_));
                }
            }
        }
        if ((state & 0b100) != 0 /* is-active doInt3(int, int) */) {
            if ((JSDivideNode.isCornercase(leftNodeValue_, rightNodeValue_))) {
                try {
                    return doInt3(leftNodeValue_, rightNodeValue_);
                } catch (ArithmeticException ex) {
                    // implicit transferToInterpreterAndInvalidate()
                    Lock lock = getLock();
                    lock.lock();
                    try {
                        this.exclude_ = this.exclude_ | 0b100 /* add-excluded doInt3(int, int) */;
                        this.state_ = this.state_ & 0xfffffffb /* remove-active doInt3(int, int) */;
                    } finally {
                        lock.unlock();
                    }
                    return JSTypesGen.expectInteger(executeAndSpecialize(leftNodeValue_, rightNodeValue_));
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectInteger(executeAndSpecialize(leftNodeValue_, rightNodeValue_));
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        int state = state_;
        try {
            if ((state & 0b1111000) == 0 /* only-active doInt1(int, int) && doInt2(int, int) && doInt3(int, int) */ && (state & 0b1111111) != 0  /* is-not doInt1(int, int) && doInt2(int, int) && doInt3(int, int) && doDouble(double, double) && doBigIntZeroDivision(BigInt, BigInt) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSDivideNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
                executeInt(frameValue);
                return;
            } else if ((state & 0b1110111) == 0 /* only-active doDouble(double, double) */ && (state & 0b1111111) != 0  /* is-not doInt1(int, int) && doInt2(int, int) && doInt3(int, int) && doDouble(double, double) && doBigIntZeroDivision(BigInt, BigInt) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSDivideNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
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
                    if (((exclude & 0b1)) == 0 /* is-not-excluded doInt1(int, int) */) {
                        if ((rightNodeValue_ > 0)) {
                            this.state_ = state = state | 0b1 /* add-active doInt1(int, int) */;
                            try {
                                lock.unlock();
                                hasLock = false;
                                return doInt1(leftNodeValue_, rightNodeValue_);
                            } catch (ArithmeticException ex) {
                                // implicit transferToInterpreterAndInvalidate()
                                lock.lock();
                                try {
                                    this.exclude_ = this.exclude_ | 0b1 /* add-excluded doInt1(int, int) */;
                                    this.state_ = this.state_ & 0xfffffffe /* remove-active doInt1(int, int) */;
                                } finally {
                                    lock.unlock();
                                }
                                return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
                            }
                        }
                    }
                    if (((exclude & 0b10)) == 0 /* is-not-excluded doInt2(int, int) */) {
                        if ((leftNodeValue_ > 0)) {
                            this.state_ = state = state | 0b10 /* add-active doInt2(int, int) */;
                            try {
                                lock.unlock();
                                hasLock = false;
                                return doInt2(leftNodeValue_, rightNodeValue_);
                            } catch (ArithmeticException ex) {
                                // implicit transferToInterpreterAndInvalidate()
                                lock.lock();
                                try {
                                    this.exclude_ = this.exclude_ | 0b10 /* add-excluded doInt2(int, int) */;
                                    this.state_ = this.state_ & 0xfffffffd /* remove-active doInt2(int, int) */;
                                } finally {
                                    lock.unlock();
                                }
                                return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
                            }
                        }
                    }
                    if (((exclude & 0b100)) == 0 /* is-not-excluded doInt3(int, int) */) {
                        if ((JSDivideNode.isCornercase(leftNodeValue_, rightNodeValue_))) {
                            this.state_ = state = state | 0b100 /* add-active doInt3(int, int) */;
                            try {
                                lock.unlock();
                                hasLock = false;
                                return doInt3(leftNodeValue_, rightNodeValue_);
                            } catch (ArithmeticException ex) {
                                // implicit transferToInterpreterAndInvalidate()
                                lock.lock();
                                try {
                                    this.exclude_ = this.exclude_ | 0b100 /* add-excluded doInt3(int, int) */;
                                    this.state_ = this.state_ & 0xfffffffb /* remove-active doInt3(int, int) */;
                                } finally {
                                    lock.unlock();
                                }
                                return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
                            }
                        }
                    }
                }
            }
            if (((exclude & 0b1000)) == 0 /* is-not-excluded doDouble(double, double) */) {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(leftNodeValue)) != 0) {
                    double leftNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast0, leftNodeValue);
                    int doubleCast1;
                    if ((doubleCast1 = JSTypesGen.specializeImplicitDouble(rightNodeValue)) != 0) {
                        double rightNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast1, rightNodeValue);
                        this.exclude_ = exclude = exclude | 0b111 /* add-excluded doInt1(int, int), doInt2(int, int), doInt3(int, int) */;
                        state = state & 0xfffffff8 /* remove-active doInt1(int, int), doInt2(int, int), doInt3(int, int) */;
                        state = (state | (doubleCast0 << 7) /* set-implicit-active 0:double */);
                        state = (state | (doubleCast1 << 11) /* set-implicit-active 1:double */);
                        this.state_ = state = state | 0b1000 /* add-active doDouble(double, double) */;
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
                    if ((JSGuards.isBigIntZero(rightNodeValue_))) {
                        this.state_ = state = state | 0b10000 /* add-active doBigIntZeroDivision(BigInt, BigInt) */;
                        lock.unlock();
                        hasLock = false;
                        return doBigIntZeroDivision(leftNodeValue_, rightNodeValue_);
                    }
                    if ((!(JSGuards.isBigIntZero(rightNodeValue_)))) {
                        this.state_ = state = state | 0b100000 /* add-active doBigInt(BigInt, BigInt) */;
                        lock.unlock();
                        hasLock = false;
                        return doBigInt(leftNodeValue_, rightNodeValue_);
                    }
                }
            }
            GenericData s7_ = super.insert(new GenericData());
            s7_.nestedDivideNode_ = s7_.insertAccessor((JSDivideNode.create()));
            s7_.toNumeric1Node_ = s7_.insertAccessor((JSToNumericNode.create()));
            s7_.toNumeric2Node_ = s7_.insertAccessor((JSToNumericNode.create()));
            s7_.mixedNumericTypes_ = (BranchProfile.create());
            this.generic_cache = s7_;
            this.exclude_ = exclude = exclude | 0b1111 /* add-excluded doInt1(int, int), doInt2(int, int), doInt3(int, int), doDouble(double, double) */;
            state = state & 0xfffffff0 /* remove-active doInt1(int, int), doInt2(int, int), doInt3(int, int), doDouble(double, double) */;
            this.state_ = state = state | 0b1000000 /* add-active doGeneric(Object, Object, JSDivideNode, JSToNumericNode, JSToNumericNode, BranchProfile) */;
            lock.unlock();
            hasLock = false;
            return doGeneric(leftNodeValue, rightNodeValue, s7_.nestedDivideNode_, s7_.toNumeric1Node_, s7_.toNumeric2Node_, s7_.mixedNumericTypes_);
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
        s[0] = "doInt1";
        if ((state & 0b1) != 0 /* is-active doInt1(int, int) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b1) != 0 /* is-excluded doInt1(int, int) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doInt2";
        if ((state & 0b10) != 0 /* is-active doInt2(int, int) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b10) != 0 /* is-excluded doInt2(int, int) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doInt3";
        if ((state & 0b100) != 0 /* is-active doInt3(int, int) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b100) != 0 /* is-excluded doInt3(int, int) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doDouble";
        if ((state & 0b1000) != 0 /* is-active doDouble(double, double) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b1000) != 0 /* is-excluded doDouble(double, double) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doBigIntZeroDivision";
        if ((state & 0b10000) != 0 /* is-active doBigIntZeroDivision(BigInt, BigInt) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "doBigInt";
        if ((state & 0b100000) != 0 /* is-active doBigInt(BigInt, BigInt) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "doGeneric";
        if ((state & 0b1000000) != 0 /* is-active doGeneric(Object, Object, JSDivideNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            GenericData s7_ = this.generic_cache;
            if (s7_ != null) {
                cached.add(Arrays.asList(s7_.nestedDivideNode_, s7_.toNumeric1Node_, s7_.toNumeric2Node_, s7_.mixedNumericTypes_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        return Provider.create(data);
    }

    public static JSDivideNode create(JavaScriptNode left, JavaScriptNode right) {
        return new JSDivideNodeGen(left, right);
    }

    @GeneratedBy(JSDivideNode.class)
    private static final class GenericData extends Node {

        @Child JSDivideNode nestedDivideNode_;
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
