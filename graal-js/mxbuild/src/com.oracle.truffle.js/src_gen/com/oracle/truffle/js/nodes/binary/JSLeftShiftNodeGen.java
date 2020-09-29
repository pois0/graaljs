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
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.cast.JSToInt32Node;
import com.oracle.truffle.js.nodes.cast.JSToNumericNode;
import com.oracle.truffle.js.nodes.cast.JSToUInt32Node;
import com.oracle.truffle.js.runtime.BigInt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSLeftShiftNode.class)
public final class JSLeftShiftNodeGen extends JSLeftShiftNode implements Provider {

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @Child private DoubleData double_cache;
    @Child private GenericData generic_cache;

    private JSLeftShiftNodeGen(JavaScriptNode left, JavaScriptNode right) {
        super(left, right);
    }

    @Override
    public Object executeObject(Object leftNodeValue, Object rightNodeValue) {
        int state = state_;
        if ((state & 0b11) != 0 /* is-active doInteger(int, int) || doIntegerDouble(int, double) */ && leftNodeValue instanceof Integer) {
            int leftNodeValue_ = (int) leftNodeValue;
            if ((state & 0b1) != 0 /* is-active doInteger(int, int) */ && rightNodeValue instanceof Integer) {
                int rightNodeValue_ = (int) rightNodeValue;
                return doInteger(leftNodeValue_, rightNodeValue_);
            }
            if ((state & 0b10) != 0 /* is-active doIntegerDouble(int, double) */ && JSTypesGen.isImplicitDouble((state & 0b111100000) >>> 5 /* extract-implicit-active 1:double */, rightNodeValue)) {
                double rightNodeValue_ = JSTypesGen.asImplicitDouble((state & 0b111100000) >>> 5 /* extract-implicit-active 1:double */, rightNodeValue);
                if ((!(JSBinaryNode.largerThan2e32(rightNodeValue_)))) {
                    return doIntegerDouble(leftNodeValue_, rightNodeValue_);
                }
            }
        }
        if ((state & 0b100) != 0 /* is-active doDouble(double, double, JSLeftShiftNode, JSToInt32Node, JSToUInt32Node) */ && JSTypesGen.isImplicitDouble((state & 0b1111000000000) >>> 9 /* extract-implicit-active 0:double */, leftNodeValue)) {
            double leftNodeValue_ = JSTypesGen.asImplicitDouble((state & 0b1111000000000) >>> 9 /* extract-implicit-active 0:double */, leftNodeValue);
            if (JSTypesGen.isImplicitDouble((state & 0b111100000) >>> 5 /* extract-implicit-active 1:double */, rightNodeValue)) {
                double rightNodeValue_ = JSTypesGen.asImplicitDouble((state & 0b111100000) >>> 5 /* extract-implicit-active 1:double */, rightNodeValue);
                DoubleData s3_ = this.double_cache;
                if (s3_ != null) {
                    return doDouble(leftNodeValue_, rightNodeValue_, s3_.leftShift_, s3_.leftInt32_, s3_.rightUInt32_);
                }
            }
        }
        if ((state & 0b1000) != 0 /* is-active doBigInt(BigInt, BigInt) */ && leftNodeValue instanceof BigInt) {
            BigInt leftNodeValue_ = (BigInt) leftNodeValue;
            if (rightNodeValue instanceof BigInt) {
                BigInt rightNodeValue_ = (BigInt) rightNodeValue;
                return doBigInt(leftNodeValue_, rightNodeValue_);
            }
        }
        if ((state & 0b10000) != 0 /* is-active doGeneric(Object, Object, JSLeftShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
            GenericData s5_ = this.generic_cache;
            if (s5_ != null) {
                return doGeneric(leftNodeValue, rightNodeValue, s5_.leftShift_, s5_.leftToNumeric_, s5_.rightToNumeric_, s5_.mixedNumericTypes_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(leftNodeValue, rightNodeValue);
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        int state = state_;
        if ((state & 0b11110) == 0 /* only-active doInteger(int, int) */ && (state & 0b11111) != 0  /* is-not doInteger(int, int) && doIntegerDouble(int, double) && doDouble(double, double, JSLeftShiftNode, JSToInt32Node, JSToUInt32Node) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSLeftShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
            return execute_int_int0(frameValue, state);
        } else if ((state & 0b11101) == 0 /* only-active doIntegerDouble(int, double) */ && (state & 0b11111) != 0  /* is-not doInteger(int, int) && doIntegerDouble(int, double) && doDouble(double, double, JSLeftShiftNode, JSToInt32Node, JSToUInt32Node) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSLeftShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
            return execute_int_double1(frameValue, state);
        } else if ((state & 0b11011) == 0 /* only-active doDouble(double, double, JSLeftShiftNode, JSToInt32Node, JSToUInt32Node) */ && (state & 0b11111) != 0  /* is-not doInteger(int, int) && doIntegerDouble(int, double) && doDouble(double, double, JSLeftShiftNode, JSToInt32Node, JSToUInt32Node) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSLeftShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
            return execute_double_double2(frameValue, state);
        } else {
            return execute_generic3(frameValue, state);
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
        assert (state & 0b1) != 0 /* is-active doInteger(int, int) */;
        return doInteger(leftNodeValue_, rightNodeValue_);
    }

    private Object execute_int_double1(VirtualFrame frameValue, int state) {
        int leftNodeValue_;
        try {
            leftNodeValue_ = super.leftNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            Object rightNodeValue = super.rightNode.execute(frameValue);
            return executeAndSpecialize(ex.getResult(), rightNodeValue);
        }
        int rightNodeValue_int = 0;
        long rightNodeValue_long = 0L;
        double rightNodeValue_;
        try {
            if ((state & 0b111000000) == 0 /* only-active 1:double */ && (state & 0b11111) != 0  /* is-not doInteger(int, int) && doIntegerDouble(int, double) && doDouble(double, double, JSLeftShiftNode, JSToInt32Node, JSToUInt32Node) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSLeftShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
                rightNodeValue_long = super.rightNode.executeLong(frameValue);
                rightNodeValue_ = JSTypes.longToDouble(rightNodeValue_long);
            } else if ((state & 0b110100000) == 0 /* only-active 1:double */ && (state & 0b11111) != 0  /* is-not doInteger(int, int) && doIntegerDouble(int, double) && doDouble(double, double, JSLeftShiftNode, JSToInt32Node, JSToUInt32Node) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSLeftShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
                rightNodeValue_int = super.rightNode.executeInt(frameValue);
                rightNodeValue_ = JSTypes.intToDouble(rightNodeValue_int);
            } else if ((state & 0b101100000) == 0 /* only-active 1:double */ && (state & 0b11111) != 0  /* is-not doInteger(int, int) && doIntegerDouble(int, double) && doDouble(double, double, JSLeftShiftNode, JSToInt32Node, JSToUInt32Node) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSLeftShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
                rightNodeValue_ = super.rightNode.executeDouble(frameValue);
            } else {
                Object rightNodeValue__ = super.rightNode.execute(frameValue);
                rightNodeValue_ = JSTypesGen.expectImplicitDouble((state & 0b111100000) >>> 5 /* extract-implicit-active 1:double */, rightNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(leftNodeValue_, ex.getResult());
        }
        assert (state & 0b10) != 0 /* is-active doIntegerDouble(int, double) */;
        if ((!(JSBinaryNode.largerThan2e32(rightNodeValue_)))) {
            return doIntegerDouble(leftNodeValue_, rightNodeValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(leftNodeValue_, ((state & 0b111000000) == 0 /* only-active 1:double */ && (state & 0b11111) != 0  /* is-not doInteger(int, int) && doIntegerDouble(int, double) && doDouble(double, double, JSLeftShiftNode, JSToInt32Node, JSToUInt32Node) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSLeftShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */ ? (Object) rightNodeValue_long : ((state & 0b110100000) == 0 /* only-active 1:double */ && (state & 0b11111) != 0  /* is-not doInteger(int, int) && doIntegerDouble(int, double) && doDouble(double, double, JSLeftShiftNode, JSToInt32Node, JSToUInt32Node) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSLeftShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */ ? (Object) rightNodeValue_int : (Object) rightNodeValue_)));
    }

    private Object execute_double_double2(VirtualFrame frameValue, int state) {
        int leftNodeValue_int = 0;
        long leftNodeValue_long = 0L;
        double leftNodeValue_;
        try {
            if ((state & 0b1110000000000) == 0 /* only-active 0:double */ && (state & 0b11111) != 0  /* is-not doInteger(int, int) && doIntegerDouble(int, double) && doDouble(double, double, JSLeftShiftNode, JSToInt32Node, JSToUInt32Node) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSLeftShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
                leftNodeValue_long = super.leftNode.executeLong(frameValue);
                leftNodeValue_ = JSTypes.longToDouble(leftNodeValue_long);
            } else if ((state & 0b1101000000000) == 0 /* only-active 0:double */ && (state & 0b11111) != 0  /* is-not doInteger(int, int) && doIntegerDouble(int, double) && doDouble(double, double, JSLeftShiftNode, JSToInt32Node, JSToUInt32Node) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSLeftShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
                leftNodeValue_int = super.leftNode.executeInt(frameValue);
                leftNodeValue_ = JSTypes.intToDouble(leftNodeValue_int);
            } else if ((state & 0b1011000000000) == 0 /* only-active 0:double */ && (state & 0b11111) != 0  /* is-not doInteger(int, int) && doIntegerDouble(int, double) && doDouble(double, double, JSLeftShiftNode, JSToInt32Node, JSToUInt32Node) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSLeftShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
                leftNodeValue_ = super.leftNode.executeDouble(frameValue);
            } else {
                Object leftNodeValue__ = super.leftNode.execute(frameValue);
                leftNodeValue_ = JSTypesGen.expectImplicitDouble((state & 0b1111000000000) >>> 9 /* extract-implicit-active 0:double */, leftNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            Object rightNodeValue = super.rightNode.execute(frameValue);
            return executeAndSpecialize(ex.getResult(), rightNodeValue);
        }
        int rightNodeValue_int = 0;
        long rightNodeValue_long = 0L;
        double rightNodeValue_;
        try {
            if ((state & 0b111000000) == 0 /* only-active 1:double */ && (state & 0b11111) != 0  /* is-not doInteger(int, int) && doIntegerDouble(int, double) && doDouble(double, double, JSLeftShiftNode, JSToInt32Node, JSToUInt32Node) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSLeftShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
                rightNodeValue_long = super.rightNode.executeLong(frameValue);
                rightNodeValue_ = JSTypes.longToDouble(rightNodeValue_long);
            } else if ((state & 0b110100000) == 0 /* only-active 1:double */ && (state & 0b11111) != 0  /* is-not doInteger(int, int) && doIntegerDouble(int, double) && doDouble(double, double, JSLeftShiftNode, JSToInt32Node, JSToUInt32Node) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSLeftShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
                rightNodeValue_int = super.rightNode.executeInt(frameValue);
                rightNodeValue_ = JSTypes.intToDouble(rightNodeValue_int);
            } else if ((state & 0b101100000) == 0 /* only-active 1:double */ && (state & 0b11111) != 0  /* is-not doInteger(int, int) && doIntegerDouble(int, double) && doDouble(double, double, JSLeftShiftNode, JSToInt32Node, JSToUInt32Node) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSLeftShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
                rightNodeValue_ = super.rightNode.executeDouble(frameValue);
            } else {
                Object rightNodeValue__ = super.rightNode.execute(frameValue);
                rightNodeValue_ = JSTypesGen.expectImplicitDouble((state & 0b111100000) >>> 5 /* extract-implicit-active 1:double */, rightNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(((state & 0b1110000000000) == 0 /* only-active 0:double */ && (state & 0b11111) != 0  /* is-not doInteger(int, int) && doIntegerDouble(int, double) && doDouble(double, double, JSLeftShiftNode, JSToInt32Node, JSToUInt32Node) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSLeftShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */ ? (Object) leftNodeValue_long : ((state & 0b1101000000000) == 0 /* only-active 0:double */ && (state & 0b11111) != 0  /* is-not doInteger(int, int) && doIntegerDouble(int, double) && doDouble(double, double, JSLeftShiftNode, JSToInt32Node, JSToUInt32Node) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSLeftShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */ ? (Object) leftNodeValue_int : (Object) leftNodeValue_)), ex.getResult());
        }
        assert (state & 0b100) != 0 /* is-active doDouble(double, double, JSLeftShiftNode, JSToInt32Node, JSToUInt32Node) */;
        DoubleData s3_ = this.double_cache;
        if (s3_ != null) {
            return doDouble(leftNodeValue_, rightNodeValue_, s3_.leftShift_, s3_.leftInt32_, s3_.rightUInt32_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(((state & 0b1110000000000) == 0 /* only-active 0:double */ && (state & 0b11111) != 0  /* is-not doInteger(int, int) && doIntegerDouble(int, double) && doDouble(double, double, JSLeftShiftNode, JSToInt32Node, JSToUInt32Node) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSLeftShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */ ? (Object) leftNodeValue_long : ((state & 0b1101000000000) == 0 /* only-active 0:double */ && (state & 0b11111) != 0  /* is-not doInteger(int, int) && doIntegerDouble(int, double) && doDouble(double, double, JSLeftShiftNode, JSToInt32Node, JSToUInt32Node) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSLeftShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */ ? (Object) leftNodeValue_int : (Object) leftNodeValue_)), ((state & 0b111000000) == 0 /* only-active 1:double */ && (state & 0b11111) != 0  /* is-not doInteger(int, int) && doIntegerDouble(int, double) && doDouble(double, double, JSLeftShiftNode, JSToInt32Node, JSToUInt32Node) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSLeftShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */ ? (Object) rightNodeValue_long : ((state & 0b110100000) == 0 /* only-active 1:double */ && (state & 0b11111) != 0  /* is-not doInteger(int, int) && doIntegerDouble(int, double) && doDouble(double, double, JSLeftShiftNode, JSToInt32Node, JSToUInt32Node) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSLeftShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */ ? (Object) rightNodeValue_int : (Object) rightNodeValue_)));
    }

    private Object execute_generic3(VirtualFrame frameValue, int state) {
        Object leftNodeValue_ = super.leftNode.execute(frameValue);
        Object rightNodeValue_ = super.rightNode.execute(frameValue);
        if ((state & 0b11) != 0 /* is-active doInteger(int, int) || doIntegerDouble(int, double) */ && leftNodeValue_ instanceof Integer) {
            int leftNodeValue__ = (int) leftNodeValue_;
            if ((state & 0b1) != 0 /* is-active doInteger(int, int) */ && rightNodeValue_ instanceof Integer) {
                int rightNodeValue__ = (int) rightNodeValue_;
                return doInteger(leftNodeValue__, rightNodeValue__);
            }
            if ((state & 0b10) != 0 /* is-active doIntegerDouble(int, double) */ && JSTypesGen.isImplicitDouble((state & 0b111100000) >>> 5 /* extract-implicit-active 1:double */, rightNodeValue_)) {
                double rightNodeValue__ = JSTypesGen.asImplicitDouble((state & 0b111100000) >>> 5 /* extract-implicit-active 1:double */, rightNodeValue_);
                if ((!(JSBinaryNode.largerThan2e32(rightNodeValue__)))) {
                    return doIntegerDouble(leftNodeValue__, rightNodeValue__);
                }
            }
        }
        if ((state & 0b100) != 0 /* is-active doDouble(double, double, JSLeftShiftNode, JSToInt32Node, JSToUInt32Node) */ && JSTypesGen.isImplicitDouble((state & 0b1111000000000) >>> 9 /* extract-implicit-active 0:double */, leftNodeValue_)) {
            double leftNodeValue__ = JSTypesGen.asImplicitDouble((state & 0b1111000000000) >>> 9 /* extract-implicit-active 0:double */, leftNodeValue_);
            if (JSTypesGen.isImplicitDouble((state & 0b111100000) >>> 5 /* extract-implicit-active 1:double */, rightNodeValue_)) {
                double rightNodeValue__ = JSTypesGen.asImplicitDouble((state & 0b111100000) >>> 5 /* extract-implicit-active 1:double */, rightNodeValue_);
                DoubleData s3_ = this.double_cache;
                if (s3_ != null) {
                    return doDouble(leftNodeValue__, rightNodeValue__, s3_.leftShift_, s3_.leftInt32_, s3_.rightUInt32_);
                }
            }
        }
        if ((state & 0b1000) != 0 /* is-active doBigInt(BigInt, BigInt) */ && leftNodeValue_ instanceof BigInt) {
            BigInt leftNodeValue__ = (BigInt) leftNodeValue_;
            if (rightNodeValue_ instanceof BigInt) {
                BigInt rightNodeValue__ = (BigInt) rightNodeValue_;
                return doBigInt(leftNodeValue__, rightNodeValue__);
            }
        }
        if ((state & 0b10000) != 0 /* is-active doGeneric(Object, Object, JSLeftShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
            GenericData s5_ = this.generic_cache;
            if (s5_ != null) {
                return doGeneric(leftNodeValue_, rightNodeValue_, s5_.leftShift_, s5_.leftToNumeric_, s5_.rightToNumeric_, s5_.mixedNumericTypes_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
    }

    @Override
    public int executeInt(VirtualFrame frameValue) throws UnexpectedResultException {
        int state = state_;
        if ((state & 0b10100) != 0 /* is-active doDouble(double, double, JSLeftShiftNode, JSToInt32Node, JSToUInt32Node) || doGeneric(Object, Object, JSLeftShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
            return JSTypesGen.expectInteger(execute(frameValue));
        }
        int leftNodeValue_;
        try {
            leftNodeValue_ = super.leftNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            Object rightNodeValue = super.rightNode.execute(frameValue);
            return JSTypesGen.expectInteger(executeAndSpecialize(ex.getResult(), rightNodeValue));
        }
        if ((state & 0b10) == 0 /* only-active doInteger(int, int) */ && (state & 0b11) != 0  /* is-not doInteger(int, int) && doIntegerDouble(int, double) */) {
            return executeInt_int4(frameValue, state, leftNodeValue_);
        } else if ((state & 0b1) == 0 /* only-active doIntegerDouble(int, double) */ && (state & 0b11) != 0  /* is-not doInteger(int, int) && doIntegerDouble(int, double) */) {
            return executeInt_double5(frameValue, state, leftNodeValue_);
        } else {
            return executeInt_generic6(frameValue, state, leftNodeValue_);
        }
    }

    private int executeInt_int4(VirtualFrame frameValue, int state, int leftNodeValue_) throws UnexpectedResultException {
        int rightNodeValue_;
        try {
            rightNodeValue_ = super.rightNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectInteger(executeAndSpecialize(leftNodeValue_, ex.getResult()));
        }
        assert (state & 0b1) != 0 /* is-active doInteger(int, int) */;
        return doInteger(leftNodeValue_, rightNodeValue_);
    }

    private int executeInt_double5(VirtualFrame frameValue, int state, int leftNodeValue_) throws UnexpectedResultException {
        int rightNodeValue_int = 0;
        long rightNodeValue_long = 0L;
        double rightNodeValue_;
        try {
            if ((state & 0b111000000) == 0 /* only-active 1:double */ && (state & 0b11111) != 0  /* is-not doInteger(int, int) && doIntegerDouble(int, double) && doDouble(double, double, JSLeftShiftNode, JSToInt32Node, JSToUInt32Node) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSLeftShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
                rightNodeValue_long = super.rightNode.executeLong(frameValue);
                rightNodeValue_ = JSTypes.longToDouble(rightNodeValue_long);
            } else if ((state & 0b110100000) == 0 /* only-active 1:double */ && (state & 0b11111) != 0  /* is-not doInteger(int, int) && doIntegerDouble(int, double) && doDouble(double, double, JSLeftShiftNode, JSToInt32Node, JSToUInt32Node) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSLeftShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
                rightNodeValue_int = super.rightNode.executeInt(frameValue);
                rightNodeValue_ = JSTypes.intToDouble(rightNodeValue_int);
            } else if ((state & 0b101100000) == 0 /* only-active 1:double */ && (state & 0b11111) != 0  /* is-not doInteger(int, int) && doIntegerDouble(int, double) && doDouble(double, double, JSLeftShiftNode, JSToInt32Node, JSToUInt32Node) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSLeftShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
                rightNodeValue_ = super.rightNode.executeDouble(frameValue);
            } else {
                Object rightNodeValue__ = super.rightNode.execute(frameValue);
                rightNodeValue_ = JSTypesGen.expectImplicitDouble((state & 0b111100000) >>> 5 /* extract-implicit-active 1:double */, rightNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectInteger(executeAndSpecialize(leftNodeValue_, ex.getResult()));
        }
        assert (state & 0b10) != 0 /* is-active doIntegerDouble(int, double) */;
        if ((!(JSBinaryNode.largerThan2e32(rightNodeValue_)))) {
            return doIntegerDouble(leftNodeValue_, rightNodeValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectInteger(executeAndSpecialize(leftNodeValue_, ((state & 0b111000000) == 0 /* only-active 1:double */ && (state & 0b11111) != 0  /* is-not doInteger(int, int) && doIntegerDouble(int, double) && doDouble(double, double, JSLeftShiftNode, JSToInt32Node, JSToUInt32Node) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSLeftShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */ ? (Object) rightNodeValue_long : ((state & 0b110100000) == 0 /* only-active 1:double */ && (state & 0b11111) != 0  /* is-not doInteger(int, int) && doIntegerDouble(int, double) && doDouble(double, double, JSLeftShiftNode, JSToInt32Node, JSToUInt32Node) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSLeftShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */ ? (Object) rightNodeValue_int : (Object) rightNodeValue_))));
    }

    private int executeInt_generic6(VirtualFrame frameValue, int state, int leftNodeValue_) throws UnexpectedResultException {
        Object rightNodeValue_ = super.rightNode.execute(frameValue);
        if ((state & 0b1) != 0 /* is-active doInteger(int, int) */ && rightNodeValue_ instanceof Integer) {
            int rightNodeValue__ = (int) rightNodeValue_;
            return doInteger(leftNodeValue_, rightNodeValue__);
        }
        if ((state & 0b10) != 0 /* is-active doIntegerDouble(int, double) */ && JSTypesGen.isImplicitDouble((state & 0b111100000) >>> 5 /* extract-implicit-active 1:double */, rightNodeValue_)) {
            double rightNodeValue__ = JSTypesGen.asImplicitDouble((state & 0b111100000) >>> 5 /* extract-implicit-active 1:double */, rightNodeValue_);
            if ((!(JSBinaryNode.largerThan2e32(rightNodeValue__)))) {
                return doIntegerDouble(leftNodeValue_, rightNodeValue__);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectInteger(executeAndSpecialize(leftNodeValue_, rightNodeValue_));
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        int state = state_;
        try {
            if ((state & 0b11100) == 0 /* only-active doInteger(int, int) && doIntegerDouble(int, double) */ && (state & 0b11111) != 0  /* is-not doInteger(int, int) && doIntegerDouble(int, double) && doDouble(double, double, JSLeftShiftNode, JSToInt32Node, JSToUInt32Node) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSLeftShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
                executeInt(frameValue);
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
                if (((exclude & 0b1)) == 0 /* is-not-excluded doInteger(int, int) */ && rightNodeValue instanceof Integer) {
                    int rightNodeValue_ = (int) rightNodeValue;
                    this.state_ = state = state | 0b1 /* add-active doInteger(int, int) */;
                    lock.unlock();
                    hasLock = false;
                    return doInteger(leftNodeValue_, rightNodeValue_);
                }
                if (((exclude & 0b10)) == 0 /* is-not-excluded doIntegerDouble(int, double) */) {
                    int doubleCast1;
                    if ((doubleCast1 = JSTypesGen.specializeImplicitDouble(rightNodeValue)) != 0) {
                        double rightNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast1, rightNodeValue);
                        if ((!(JSBinaryNode.largerThan2e32(rightNodeValue_)))) {
                            state = (state | (doubleCast1 << 5) /* set-implicit-active 1:double */);
                            this.state_ = state = state | 0b10 /* add-active doIntegerDouble(int, double) */;
                            lock.unlock();
                            hasLock = false;
                            return doIntegerDouble(leftNodeValue_, rightNodeValue_);
                        }
                    }
                }
            }
            if (((exclude & 0b100)) == 0 /* is-not-excluded doDouble(double, double, JSLeftShiftNode, JSToInt32Node, JSToUInt32Node) */) {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(leftNodeValue)) != 0) {
                    double leftNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast0, leftNodeValue);
                    int doubleCast1;
                    if ((doubleCast1 = JSTypesGen.specializeImplicitDouble(rightNodeValue)) != 0) {
                        double rightNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast1, rightNodeValue);
                        DoubleData s3_ = super.insert(new DoubleData());
                        s3_.leftShift_ = s3_.insertAccessor((JSLeftShiftNode.create()));
                        s3_.leftInt32_ = s3_.insertAccessor((JSToInt32Node.create()));
                        s3_.rightUInt32_ = s3_.insertAccessor((JSToUInt32Node.create()));
                        this.double_cache = s3_;
                        state = (state | (doubleCast0 << 9) /* set-implicit-active 0:double */);
                        state = (state | (doubleCast1 << 5) /* set-implicit-active 1:double */);
                        this.state_ = state = state | 0b100 /* add-active doDouble(double, double, JSLeftShiftNode, JSToInt32Node, JSToUInt32Node) */;
                        lock.unlock();
                        hasLock = false;
                        return doDouble(leftNodeValue_, rightNodeValue_, s3_.leftShift_, s3_.leftInt32_, s3_.rightUInt32_);
                    }
                }
            }
            if (((exclude & 0b1000)) == 0 /* is-not-excluded doBigInt(BigInt, BigInt) */ && leftNodeValue instanceof BigInt) {
                BigInt leftNodeValue_ = (BigInt) leftNodeValue;
                if (rightNodeValue instanceof BigInt) {
                    BigInt rightNodeValue_ = (BigInt) rightNodeValue;
                    this.state_ = state = state | 0b1000 /* add-active doBigInt(BigInt, BigInt) */;
                    lock.unlock();
                    hasLock = false;
                    return doBigInt(leftNodeValue_, rightNodeValue_);
                }
            }
            GenericData s5_ = super.insert(new GenericData());
            s5_.leftShift_ = s5_.insertAccessor((JSLeftShiftNode.create()));
            s5_.leftToNumeric_ = s5_.insertAccessor((JSToNumericNode.create()));
            s5_.rightToNumeric_ = s5_.insertAccessor((JSToNumericNode.create()));
            s5_.mixedNumericTypes_ = (BranchProfile.create());
            this.generic_cache = s5_;
            this.exclude_ = exclude = exclude | 0b1111 /* add-excluded doInteger(int, int), doIntegerDouble(int, double), doDouble(double, double, JSLeftShiftNode, JSToInt32Node, JSToUInt32Node), doBigInt(BigInt, BigInt) */;
            this.double_cache = null;
            state = state & 0xfffffff0 /* remove-active doInteger(int, int), doIntegerDouble(int, double), doDouble(double, double, JSLeftShiftNode, JSToInt32Node, JSToUInt32Node), doBigInt(BigInt, BigInt) */;
            this.state_ = state = state | 0b10000 /* add-active doGeneric(Object, Object, JSLeftShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */;
            lock.unlock();
            hasLock = false;
            return doGeneric(leftNodeValue, rightNodeValue, s5_.leftShift_, s5_.leftToNumeric_, s5_.rightToNumeric_, s5_.mixedNumericTypes_);
        } finally {
            if (hasLock) {
                lock.unlock();
            }
        }
    }

    @Override
    public NodeCost getCost() {
        int state = state_;
        if ((state & 0b11111) == 0b0) {
            return NodeCost.UNINITIALIZED;
        } else if (((state & 0b11111) & ((state & 0b11111) - 1)) == 0 /* is-single-active  */) {
            return NodeCost.MONOMORPHIC;
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[6];
        Object[] s;
        data[0] = 0;
        int state = state_;
        int exclude = exclude_;
        s = new Object[3];
        s[0] = "doInteger";
        if ((state & 0b1) != 0 /* is-active doInteger(int, int) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b1) != 0 /* is-excluded doInteger(int, int) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doIntegerDouble";
        if ((state & 0b10) != 0 /* is-active doIntegerDouble(int, double) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b10) != 0 /* is-excluded doIntegerDouble(int, double) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doDouble";
        if ((state & 0b100) != 0 /* is-active doDouble(double, double, JSLeftShiftNode, JSToInt32Node, JSToUInt32Node) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            DoubleData s3_ = this.double_cache;
            if (s3_ != null) {
                cached.add(Arrays.asList(s3_.leftShift_, s3_.leftInt32_, s3_.rightUInt32_));
            }
            s[2] = cached;
        } else if ((exclude & 0b100) != 0 /* is-excluded doDouble(double, double, JSLeftShiftNode, JSToInt32Node, JSToUInt32Node) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doBigInt";
        if ((state & 0b1000) != 0 /* is-active doBigInt(BigInt, BigInt) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b1000) != 0 /* is-excluded doBigInt(BigInt, BigInt) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doGeneric";
        if ((state & 0b10000) != 0 /* is-active doGeneric(Object, Object, JSLeftShiftNode, JSToNumericNode, JSToNumericNode, BranchProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            GenericData s5_ = this.generic_cache;
            if (s5_ != null) {
                cached.add(Arrays.asList(s5_.leftShift_, s5_.leftToNumeric_, s5_.rightToNumeric_, s5_.mixedNumericTypes_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        return Provider.create(data);
    }

    public static JSLeftShiftNode create(JavaScriptNode left, JavaScriptNode right) {
        return new JSLeftShiftNodeGen(left, right);
    }

    @GeneratedBy(JSLeftShiftNode.class)
    private static final class DoubleData extends Node {

        @Child JSLeftShiftNode leftShift_;
        @Child JSToInt32Node leftInt32_;
        @Child JSToUInt32Node rightUInt32_;

        DoubleData() {
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.NONE;
        }

        <T extends Node> T insertAccessor(T node) {
            return super.insert(node);
        }

    }
    @GeneratedBy(JSLeftShiftNode.class)
    private static final class GenericData extends Node {

        @Child JSLeftShiftNode leftShift_;
        @Child JSToNumericNode leftToNumeric_;
        @Child JSToNumericNode rightToNumeric_;
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
