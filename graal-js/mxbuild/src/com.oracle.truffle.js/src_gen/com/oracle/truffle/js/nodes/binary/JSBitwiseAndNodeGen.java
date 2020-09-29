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
import com.oracle.truffle.js.runtime.BigInt;
import com.oracle.truffle.js.runtime.SafeInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSBitwiseAndNode.class)
public final class JSBitwiseAndNodeGen extends JSBitwiseAndNode implements Provider {

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @Child private JSToInt32Node double_leftInt32_;
    @Child private JSToInt32Node double_rightInt32_;
    @Child private GenericData generic_cache;

    private JSBitwiseAndNodeGen(JavaScriptNode left, JavaScriptNode right) {
        super(left, right);
    }

    @Override
    public Object executeObject(Object leftNodeValue, Object rightNodeValue) {
        int state = state_;
        if ((state & 0b11) != 0 /* is-active doInteger(int, int) || doSafeIntegerInt(SafeInteger, int) */ && rightNodeValue instanceof Integer) {
            int rightNodeValue_ = (int) rightNodeValue;
            if ((state & 0b1) != 0 /* is-active doInteger(int, int) */ && leftNodeValue instanceof Integer) {
                int leftNodeValue_ = (int) leftNodeValue;
                return doInteger(leftNodeValue_, rightNodeValue_);
            }
            if ((state & 0b10) != 0 /* is-active doSafeIntegerInt(SafeInteger, int) */ && leftNodeValue instanceof SafeInteger) {
                SafeInteger leftNodeValue_ = (SafeInteger) leftNodeValue;
                return doSafeIntegerInt(leftNodeValue_, rightNodeValue_);
            }
        }
        if ((state & 0b1100) != 0 /* is-active doIntSafeInteger(int, SafeInteger) || doSafeInteger(SafeInteger, SafeInteger) */ && rightNodeValue instanceof SafeInteger) {
            SafeInteger rightNodeValue_ = (SafeInteger) rightNodeValue;
            if ((state & 0b100) != 0 /* is-active doIntSafeInteger(int, SafeInteger) */ && leftNodeValue instanceof Integer) {
                int leftNodeValue_ = (int) leftNodeValue;
                return doIntSafeInteger(leftNodeValue_, rightNodeValue_);
            }
            if ((state & 0b1000) != 0 /* is-active doSafeInteger(SafeInteger, SafeInteger) */ && leftNodeValue instanceof SafeInteger) {
                SafeInteger leftNodeValue_ = (SafeInteger) leftNodeValue;
                return doSafeInteger(leftNodeValue_, rightNodeValue_);
            }
        }
        if ((state & 0b10000) != 0 /* is-active doDouble(double, double, JSToInt32Node, JSToInt32Node) */ && JSTypesGen.isImplicitDouble((state & 0b11110000000) >>> 7 /* extract-implicit-active 0:double */, leftNodeValue)) {
            double leftNodeValue_ = JSTypesGen.asImplicitDouble((state & 0b11110000000) >>> 7 /* extract-implicit-active 0:double */, leftNodeValue);
            if (JSTypesGen.isImplicitDouble((state & 0b111100000000000) >>> 11 /* extract-implicit-active 1:double */, rightNodeValue)) {
                double rightNodeValue_ = JSTypesGen.asImplicitDouble((state & 0b111100000000000) >>> 11 /* extract-implicit-active 1:double */, rightNodeValue);
                return doDouble(leftNodeValue_, rightNodeValue_, this.double_leftInt32_, this.double_rightInt32_);
            }
        }
        if ((state & 0b100000) != 0 /* is-active doBigInt(BigInt, BigInt) */ && leftNodeValue instanceof BigInt) {
            BigInt leftNodeValue_ = (BigInt) leftNodeValue;
            if (rightNodeValue instanceof BigInt) {
                BigInt rightNodeValue_ = (BigInt) rightNodeValue;
                return doBigInt(leftNodeValue_, rightNodeValue_);
            }
        }
        if ((state & 0b1000000) != 0 /* is-active doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSBitwiseAndNode, BranchProfile) */) {
            GenericData s7_ = this.generic_cache;
            if (s7_ != null) {
                return doGeneric(leftNodeValue, rightNodeValue, s7_.leftNumeric_, s7_.rightNumeric_, s7_.and_, s7_.mixedNumericTypes_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(leftNodeValue, rightNodeValue);
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        int state = state_;
        if ((state & 0b1111110) == 0 /* only-active doInteger(int, int) */ && (state & 0b1111111) != 0  /* is-not doInteger(int, int) && doSafeIntegerInt(SafeInteger, int) && doIntSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double, JSToInt32Node, JSToInt32Node) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSBitwiseAndNode, BranchProfile) */) {
            return execute_int_int0(frameValue, state);
        } else if ((state & 0b1101111) == 0 /* only-active doDouble(double, double, JSToInt32Node, JSToInt32Node) */ && (state & 0b1111111) != 0  /* is-not doInteger(int, int) && doSafeIntegerInt(SafeInteger, int) && doIntSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double, JSToInt32Node, JSToInt32Node) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSBitwiseAndNode, BranchProfile) */) {
            return execute_double_double1(frameValue, state);
        } else if ((state & 0b1111101) == 0 /* only-active doSafeIntegerInt(SafeInteger, int) */ && (state & 0b1111111) != 0  /* is-not doInteger(int, int) && doSafeIntegerInt(SafeInteger, int) && doIntSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double, JSToInt32Node, JSToInt32Node) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSBitwiseAndNode, BranchProfile) */) {
            return execute_int2(frameValue, state);
        } else if ((state & 0b1111011) == 0 /* only-active doIntSafeInteger(int, SafeInteger) */ && (state & 0b1111111) != 0  /* is-not doInteger(int, int) && doSafeIntegerInt(SafeInteger, int) && doIntSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double, JSToInt32Node, JSToInt32Node) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSBitwiseAndNode, BranchProfile) */) {
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
        assert (state & 0b1) != 0 /* is-active doInteger(int, int) */;
        return doInteger(leftNodeValue_, rightNodeValue_);
    }

    private Object execute_double_double1(VirtualFrame frameValue, int state) {
        int leftNodeValue_int = 0;
        long leftNodeValue_long = 0L;
        double leftNodeValue_;
        try {
            if ((state & 0b11100000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not doInteger(int, int) && doSafeIntegerInt(SafeInteger, int) && doIntSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double, JSToInt32Node, JSToInt32Node) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSBitwiseAndNode, BranchProfile) */) {
                leftNodeValue_long = super.leftNode.executeLong(frameValue);
                leftNodeValue_ = JSTypes.longToDouble(leftNodeValue_long);
            } else if ((state & 0b11010000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not doInteger(int, int) && doSafeIntegerInt(SafeInteger, int) && doIntSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double, JSToInt32Node, JSToInt32Node) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSBitwiseAndNode, BranchProfile) */) {
                leftNodeValue_int = super.leftNode.executeInt(frameValue);
                leftNodeValue_ = JSTypes.intToDouble(leftNodeValue_int);
            } else if ((state & 0b10110000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not doInteger(int, int) && doSafeIntegerInt(SafeInteger, int) && doIntSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double, JSToInt32Node, JSToInt32Node) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSBitwiseAndNode, BranchProfile) */) {
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
            if ((state & 0b111000000000000) == 0 /* only-active 1:double */ && (state & 0b1111111) != 0  /* is-not doInteger(int, int) && doSafeIntegerInt(SafeInteger, int) && doIntSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double, JSToInt32Node, JSToInt32Node) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSBitwiseAndNode, BranchProfile) */) {
                rightNodeValue_long = super.rightNode.executeLong(frameValue);
                rightNodeValue_ = JSTypes.longToDouble(rightNodeValue_long);
            } else if ((state & 0b110100000000000) == 0 /* only-active 1:double */ && (state & 0b1111111) != 0  /* is-not doInteger(int, int) && doSafeIntegerInt(SafeInteger, int) && doIntSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double, JSToInt32Node, JSToInt32Node) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSBitwiseAndNode, BranchProfile) */) {
                rightNodeValue_int = super.rightNode.executeInt(frameValue);
                rightNodeValue_ = JSTypes.intToDouble(rightNodeValue_int);
            } else if ((state & 0b101100000000000) == 0 /* only-active 1:double */ && (state & 0b1111111) != 0  /* is-not doInteger(int, int) && doSafeIntegerInt(SafeInteger, int) && doIntSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double, JSToInt32Node, JSToInt32Node) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSBitwiseAndNode, BranchProfile) */) {
                rightNodeValue_ = super.rightNode.executeDouble(frameValue);
            } else {
                Object rightNodeValue__ = super.rightNode.execute(frameValue);
                rightNodeValue_ = JSTypesGen.expectImplicitDouble((state & 0b111100000000000) >>> 11 /* extract-implicit-active 1:double */, rightNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(((state & 0b11100000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not doInteger(int, int) && doSafeIntegerInt(SafeInteger, int) && doIntSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double, JSToInt32Node, JSToInt32Node) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSBitwiseAndNode, BranchProfile) */ ? (Object) leftNodeValue_long : ((state & 0b11010000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not doInteger(int, int) && doSafeIntegerInt(SafeInteger, int) && doIntSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double, JSToInt32Node, JSToInt32Node) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSBitwiseAndNode, BranchProfile) */ ? (Object) leftNodeValue_int : (Object) leftNodeValue_)), ex.getResult());
        }
        assert (state & 0b10000) != 0 /* is-active doDouble(double, double, JSToInt32Node, JSToInt32Node) */;
        return doDouble(leftNodeValue_, rightNodeValue_, this.double_leftInt32_, this.double_rightInt32_);
    }

    private Object execute_int2(VirtualFrame frameValue, int state) {
        Object leftNodeValue_ = super.leftNode.execute(frameValue);
        int rightNodeValue_;
        try {
            rightNodeValue_ = super.rightNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(leftNodeValue_, ex.getResult());
        }
        assert (state & 0b10) != 0 /* is-active doSafeIntegerInt(SafeInteger, int) */;
        if (leftNodeValue_ instanceof SafeInteger) {
            SafeInteger leftNodeValue__ = (SafeInteger) leftNodeValue_;
            return doSafeIntegerInt(leftNodeValue__, rightNodeValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
    }

    private Object execute_int3(VirtualFrame frameValue, int state) {
        int leftNodeValue_;
        try {
            leftNodeValue_ = super.leftNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            Object rightNodeValue = super.rightNode.execute(frameValue);
            return executeAndSpecialize(ex.getResult(), rightNodeValue);
        }
        Object rightNodeValue_ = super.rightNode.execute(frameValue);
        assert (state & 0b100) != 0 /* is-active doIntSafeInteger(int, SafeInteger) */;
        if (rightNodeValue_ instanceof SafeInteger) {
            SafeInteger rightNodeValue__ = (SafeInteger) rightNodeValue_;
            return doIntSafeInteger(leftNodeValue_, rightNodeValue__);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
    }

    private Object execute_generic4(VirtualFrame frameValue, int state) {
        Object leftNodeValue_ = super.leftNode.execute(frameValue);
        Object rightNodeValue_ = super.rightNode.execute(frameValue);
        if ((state & 0b11) != 0 /* is-active doInteger(int, int) || doSafeIntegerInt(SafeInteger, int) */ && rightNodeValue_ instanceof Integer) {
            int rightNodeValue__ = (int) rightNodeValue_;
            if ((state & 0b1) != 0 /* is-active doInteger(int, int) */ && leftNodeValue_ instanceof Integer) {
                int leftNodeValue__ = (int) leftNodeValue_;
                return doInteger(leftNodeValue__, rightNodeValue__);
            }
            if ((state & 0b10) != 0 /* is-active doSafeIntegerInt(SafeInteger, int) */ && leftNodeValue_ instanceof SafeInteger) {
                SafeInteger leftNodeValue__ = (SafeInteger) leftNodeValue_;
                return doSafeIntegerInt(leftNodeValue__, rightNodeValue__);
            }
        }
        if ((state & 0b1100) != 0 /* is-active doIntSafeInteger(int, SafeInteger) || doSafeInteger(SafeInteger, SafeInteger) */ && rightNodeValue_ instanceof SafeInteger) {
            SafeInteger rightNodeValue__ = (SafeInteger) rightNodeValue_;
            if ((state & 0b100) != 0 /* is-active doIntSafeInteger(int, SafeInteger) */ && leftNodeValue_ instanceof Integer) {
                int leftNodeValue__ = (int) leftNodeValue_;
                return doIntSafeInteger(leftNodeValue__, rightNodeValue__);
            }
            if ((state & 0b1000) != 0 /* is-active doSafeInteger(SafeInteger, SafeInteger) */ && leftNodeValue_ instanceof SafeInteger) {
                SafeInteger leftNodeValue__ = (SafeInteger) leftNodeValue_;
                return doSafeInteger(leftNodeValue__, rightNodeValue__);
            }
        }
        if ((state & 0b10000) != 0 /* is-active doDouble(double, double, JSToInt32Node, JSToInt32Node) */ && JSTypesGen.isImplicitDouble((state & 0b11110000000) >>> 7 /* extract-implicit-active 0:double */, leftNodeValue_)) {
            double leftNodeValue__ = JSTypesGen.asImplicitDouble((state & 0b11110000000) >>> 7 /* extract-implicit-active 0:double */, leftNodeValue_);
            if (JSTypesGen.isImplicitDouble((state & 0b111100000000000) >>> 11 /* extract-implicit-active 1:double */, rightNodeValue_)) {
                double rightNodeValue__ = JSTypesGen.asImplicitDouble((state & 0b111100000000000) >>> 11 /* extract-implicit-active 1:double */, rightNodeValue_);
                return doDouble(leftNodeValue__, rightNodeValue__, this.double_leftInt32_, this.double_rightInt32_);
            }
        }
        if ((state & 0b100000) != 0 /* is-active doBigInt(BigInt, BigInt) */ && leftNodeValue_ instanceof BigInt) {
            BigInt leftNodeValue__ = (BigInt) leftNodeValue_;
            if (rightNodeValue_ instanceof BigInt) {
                BigInt rightNodeValue__ = (BigInt) rightNodeValue_;
                return doBigInt(leftNodeValue__, rightNodeValue__);
            }
        }
        if ((state & 0b1000000) != 0 /* is-active doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSBitwiseAndNode, BranchProfile) */) {
            GenericData s7_ = this.generic_cache;
            if (s7_ != null) {
                return doGeneric(leftNodeValue_, rightNodeValue_, s7_.leftNumeric_, s7_.rightNumeric_, s7_.and_, s7_.mixedNumericTypes_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
    }

    @Override
    public int executeInt(VirtualFrame frameValue) throws UnexpectedResultException {
        int state = state_;
        if ((state & 0b1000000) != 0 /* is-active doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSBitwiseAndNode, BranchProfile) */) {
            return JSTypesGen.expectInteger(execute(frameValue));
        }
        if ((state & 0b11110) == 0 /* only-active doInteger(int, int) */ && (state & 0b11111) != 0  /* is-not doInteger(int, int) && doSafeIntegerInt(SafeInteger, int) && doIntSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double, JSToInt32Node, JSToInt32Node) */) {
            return executeInt_int_int5(frameValue, state);
        } else if ((state & 0b1111) == 0 /* only-active doDouble(double, double, JSToInt32Node, JSToInt32Node) */ && (state & 0b11111) != 0  /* is-not doInteger(int, int) && doSafeIntegerInt(SafeInteger, int) && doIntSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double, JSToInt32Node, JSToInt32Node) */) {
            return executeInt_double_double6(frameValue, state);
        } else if ((state & 0b11101) == 0 /* only-active doSafeIntegerInt(SafeInteger, int) */ && (state & 0b11111) != 0  /* is-not doInteger(int, int) && doSafeIntegerInt(SafeInteger, int) && doIntSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double, JSToInt32Node, JSToInt32Node) */) {
            return executeInt_int7(frameValue, state);
        } else if ((state & 0b11011) == 0 /* only-active doIntSafeInteger(int, SafeInteger) */ && (state & 0b11111) != 0  /* is-not doInteger(int, int) && doSafeIntegerInt(SafeInteger, int) && doIntSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double, JSToInt32Node, JSToInt32Node) */) {
            return executeInt_int8(frameValue, state);
        } else {
            return executeInt_generic9(frameValue, state);
        }
    }

    private int executeInt_int_int5(VirtualFrame frameValue, int state) throws UnexpectedResultException {
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
        assert (state & 0b1) != 0 /* is-active doInteger(int, int) */;
        return doInteger(leftNodeValue_, rightNodeValue_);
    }

    private int executeInt_double_double6(VirtualFrame frameValue, int state) throws UnexpectedResultException {
        int leftNodeValue_int = 0;
        long leftNodeValue_long = 0L;
        double leftNodeValue_;
        try {
            if ((state & 0b11100000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not doInteger(int, int) && doSafeIntegerInt(SafeInteger, int) && doIntSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double, JSToInt32Node, JSToInt32Node) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSBitwiseAndNode, BranchProfile) */) {
                leftNodeValue_long = super.leftNode.executeLong(frameValue);
                leftNodeValue_ = JSTypes.longToDouble(leftNodeValue_long);
            } else if ((state & 0b11010000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not doInteger(int, int) && doSafeIntegerInt(SafeInteger, int) && doIntSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double, JSToInt32Node, JSToInt32Node) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSBitwiseAndNode, BranchProfile) */) {
                leftNodeValue_int = super.leftNode.executeInt(frameValue);
                leftNodeValue_ = JSTypes.intToDouble(leftNodeValue_int);
            } else if ((state & 0b10110000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not doInteger(int, int) && doSafeIntegerInt(SafeInteger, int) && doIntSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double, JSToInt32Node, JSToInt32Node) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSBitwiseAndNode, BranchProfile) */) {
                leftNodeValue_ = super.leftNode.executeDouble(frameValue);
            } else {
                Object leftNodeValue__ = super.leftNode.execute(frameValue);
                leftNodeValue_ = JSTypesGen.expectImplicitDouble((state & 0b11110000000) >>> 7 /* extract-implicit-active 0:double */, leftNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            Object rightNodeValue = super.rightNode.execute(frameValue);
            return JSTypesGen.expectInteger(executeAndSpecialize(ex.getResult(), rightNodeValue));
        }
        int rightNodeValue_int = 0;
        long rightNodeValue_long = 0L;
        double rightNodeValue_;
        try {
            if ((state & 0b111000000000000) == 0 /* only-active 1:double */ && (state & 0b1111111) != 0  /* is-not doInteger(int, int) && doSafeIntegerInt(SafeInteger, int) && doIntSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double, JSToInt32Node, JSToInt32Node) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSBitwiseAndNode, BranchProfile) */) {
                rightNodeValue_long = super.rightNode.executeLong(frameValue);
                rightNodeValue_ = JSTypes.longToDouble(rightNodeValue_long);
            } else if ((state & 0b110100000000000) == 0 /* only-active 1:double */ && (state & 0b1111111) != 0  /* is-not doInteger(int, int) && doSafeIntegerInt(SafeInteger, int) && doIntSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double, JSToInt32Node, JSToInt32Node) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSBitwiseAndNode, BranchProfile) */) {
                rightNodeValue_int = super.rightNode.executeInt(frameValue);
                rightNodeValue_ = JSTypes.intToDouble(rightNodeValue_int);
            } else if ((state & 0b101100000000000) == 0 /* only-active 1:double */ && (state & 0b1111111) != 0  /* is-not doInteger(int, int) && doSafeIntegerInt(SafeInteger, int) && doIntSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double, JSToInt32Node, JSToInt32Node) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSBitwiseAndNode, BranchProfile) */) {
                rightNodeValue_ = super.rightNode.executeDouble(frameValue);
            } else {
                Object rightNodeValue__ = super.rightNode.execute(frameValue);
                rightNodeValue_ = JSTypesGen.expectImplicitDouble((state & 0b111100000000000) >>> 11 /* extract-implicit-active 1:double */, rightNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectInteger(executeAndSpecialize(((state & 0b11100000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not doInteger(int, int) && doSafeIntegerInt(SafeInteger, int) && doIntSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double, JSToInt32Node, JSToInt32Node) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSBitwiseAndNode, BranchProfile) */ ? (Object) leftNodeValue_long : ((state & 0b11010000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not doInteger(int, int) && doSafeIntegerInt(SafeInteger, int) && doIntSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double, JSToInt32Node, JSToInt32Node) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSBitwiseAndNode, BranchProfile) */ ? (Object) leftNodeValue_int : (Object) leftNodeValue_)), ex.getResult()));
        }
        assert (state & 0b10000) != 0 /* is-active doDouble(double, double, JSToInt32Node, JSToInt32Node) */;
        return doDouble(leftNodeValue_, rightNodeValue_, this.double_leftInt32_, this.double_rightInt32_);
    }

    private int executeInt_int7(VirtualFrame frameValue, int state) throws UnexpectedResultException {
        Object leftNodeValue_ = super.leftNode.execute(frameValue);
        int rightNodeValue_;
        try {
            rightNodeValue_ = super.rightNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectInteger(executeAndSpecialize(leftNodeValue_, ex.getResult()));
        }
        assert (state & 0b10) != 0 /* is-active doSafeIntegerInt(SafeInteger, int) */;
        if (leftNodeValue_ instanceof SafeInteger) {
            SafeInteger leftNodeValue__ = (SafeInteger) leftNodeValue_;
            return doSafeIntegerInt(leftNodeValue__, rightNodeValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectInteger(executeAndSpecialize(leftNodeValue_, rightNodeValue_));
    }

    private int executeInt_int8(VirtualFrame frameValue, int state) throws UnexpectedResultException {
        int leftNodeValue_;
        try {
            leftNodeValue_ = super.leftNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            Object rightNodeValue = super.rightNode.execute(frameValue);
            return JSTypesGen.expectInteger(executeAndSpecialize(ex.getResult(), rightNodeValue));
        }
        Object rightNodeValue_ = super.rightNode.execute(frameValue);
        assert (state & 0b100) != 0 /* is-active doIntSafeInteger(int, SafeInteger) */;
        if (rightNodeValue_ instanceof SafeInteger) {
            SafeInteger rightNodeValue__ = (SafeInteger) rightNodeValue_;
            return doIntSafeInteger(leftNodeValue_, rightNodeValue__);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectInteger(executeAndSpecialize(leftNodeValue_, rightNodeValue_));
    }

    private int executeInt_generic9(VirtualFrame frameValue, int state) throws UnexpectedResultException {
        Object leftNodeValue_ = super.leftNode.execute(frameValue);
        Object rightNodeValue_ = super.rightNode.execute(frameValue);
        if ((state & 0b11) != 0 /* is-active doInteger(int, int) || doSafeIntegerInt(SafeInteger, int) */ && rightNodeValue_ instanceof Integer) {
            int rightNodeValue__ = (int) rightNodeValue_;
            if ((state & 0b1) != 0 /* is-active doInteger(int, int) */ && leftNodeValue_ instanceof Integer) {
                int leftNodeValue__ = (int) leftNodeValue_;
                return doInteger(leftNodeValue__, rightNodeValue__);
            }
            if ((state & 0b10) != 0 /* is-active doSafeIntegerInt(SafeInteger, int) */ && leftNodeValue_ instanceof SafeInteger) {
                SafeInteger leftNodeValue__ = (SafeInteger) leftNodeValue_;
                return doSafeIntegerInt(leftNodeValue__, rightNodeValue__);
            }
        }
        if ((state & 0b1100) != 0 /* is-active doIntSafeInteger(int, SafeInteger) || doSafeInteger(SafeInteger, SafeInteger) */ && rightNodeValue_ instanceof SafeInteger) {
            SafeInteger rightNodeValue__ = (SafeInteger) rightNodeValue_;
            if ((state & 0b100) != 0 /* is-active doIntSafeInteger(int, SafeInteger) */ && leftNodeValue_ instanceof Integer) {
                int leftNodeValue__ = (int) leftNodeValue_;
                return doIntSafeInteger(leftNodeValue__, rightNodeValue__);
            }
            if ((state & 0b1000) != 0 /* is-active doSafeInteger(SafeInteger, SafeInteger) */ && leftNodeValue_ instanceof SafeInteger) {
                SafeInteger leftNodeValue__ = (SafeInteger) leftNodeValue_;
                return doSafeInteger(leftNodeValue__, rightNodeValue__);
            }
        }
        if ((state & 0b10000) != 0 /* is-active doDouble(double, double, JSToInt32Node, JSToInt32Node) */ && JSTypesGen.isImplicitDouble((state & 0b11110000000) >>> 7 /* extract-implicit-active 0:double */, leftNodeValue_)) {
            double leftNodeValue__ = JSTypesGen.asImplicitDouble((state & 0b11110000000) >>> 7 /* extract-implicit-active 0:double */, leftNodeValue_);
            if (JSTypesGen.isImplicitDouble((state & 0b111100000000000) >>> 11 /* extract-implicit-active 1:double */, rightNodeValue_)) {
                double rightNodeValue__ = JSTypesGen.asImplicitDouble((state & 0b111100000000000) >>> 11 /* extract-implicit-active 1:double */, rightNodeValue_);
                return doDouble(leftNodeValue__, rightNodeValue__, this.double_leftInt32_, this.double_rightInt32_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectInteger(executeAndSpecialize(leftNodeValue_, rightNodeValue_));
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        int state = state_;
        try {
            if ((state & 0b1100000) == 0 /* only-active doInteger(int, int) && doSafeIntegerInt(SafeInteger, int) && doIntSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double, JSToInt32Node, JSToInt32Node) */ && (state & 0b1111111) != 0  /* is-not doInteger(int, int) && doSafeIntegerInt(SafeInteger, int) && doIntSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double, JSToInt32Node, JSToInt32Node) && doBigInt(BigInt, BigInt) && doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSBitwiseAndNode, BranchProfile) */) {
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
            if (rightNodeValue instanceof Integer) {
                int rightNodeValue_ = (int) rightNodeValue;
                if (((exclude & 0b1)) == 0 /* is-not-excluded doInteger(int, int) */ && leftNodeValue instanceof Integer) {
                    int leftNodeValue_ = (int) leftNodeValue;
                    this.state_ = state = state | 0b1 /* add-active doInteger(int, int) */;
                    lock.unlock();
                    hasLock = false;
                    return doInteger(leftNodeValue_, rightNodeValue_);
                }
                if (((exclude & 0b10)) == 0 /* is-not-excluded doSafeIntegerInt(SafeInteger, int) */ && leftNodeValue instanceof SafeInteger) {
                    SafeInteger leftNodeValue_ = (SafeInteger) leftNodeValue;
                    this.state_ = state = state | 0b10 /* add-active doSafeIntegerInt(SafeInteger, int) */;
                    lock.unlock();
                    hasLock = false;
                    return doSafeIntegerInt(leftNodeValue_, rightNodeValue_);
                }
            }
            if (rightNodeValue instanceof SafeInteger) {
                SafeInteger rightNodeValue_ = (SafeInteger) rightNodeValue;
                if (((exclude & 0b100)) == 0 /* is-not-excluded doIntSafeInteger(int, SafeInteger) */ && leftNodeValue instanceof Integer) {
                    int leftNodeValue_ = (int) leftNodeValue;
                    this.state_ = state = state | 0b100 /* add-active doIntSafeInteger(int, SafeInteger) */;
                    lock.unlock();
                    hasLock = false;
                    return doIntSafeInteger(leftNodeValue_, rightNodeValue_);
                }
                if (((exclude & 0b1000)) == 0 /* is-not-excluded doSafeInteger(SafeInteger, SafeInteger) */ && leftNodeValue instanceof SafeInteger) {
                    SafeInteger leftNodeValue_ = (SafeInteger) leftNodeValue;
                    this.state_ = state = state | 0b1000 /* add-active doSafeInteger(SafeInteger, SafeInteger) */;
                    lock.unlock();
                    hasLock = false;
                    return doSafeInteger(leftNodeValue_, rightNodeValue_);
                }
            }
            if (((exclude & 0b10000)) == 0 /* is-not-excluded doDouble(double, double, JSToInt32Node, JSToInt32Node) */) {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(leftNodeValue)) != 0) {
                    double leftNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast0, leftNodeValue);
                    int doubleCast1;
                    if ((doubleCast1 = JSTypesGen.specializeImplicitDouble(rightNodeValue)) != 0) {
                        double rightNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast1, rightNodeValue);
                        this.double_leftInt32_ = super.insert((JSToInt32Node.create()));
                        this.double_rightInt32_ = super.insert((JSToInt32Node.create()));
                        state = (state | (doubleCast0 << 7) /* set-implicit-active 0:double */);
                        state = (state | (doubleCast1 << 11) /* set-implicit-active 1:double */);
                        this.state_ = state = state | 0b10000 /* add-active doDouble(double, double, JSToInt32Node, JSToInt32Node) */;
                        lock.unlock();
                        hasLock = false;
                        return doDouble(leftNodeValue_, rightNodeValue_, this.double_leftInt32_, this.double_rightInt32_);
                    }
                }
            }
            if (((exclude & 0b100000)) == 0 /* is-not-excluded doBigInt(BigInt, BigInt) */ && leftNodeValue instanceof BigInt) {
                BigInt leftNodeValue_ = (BigInt) leftNodeValue;
                if (rightNodeValue instanceof BigInt) {
                    BigInt rightNodeValue_ = (BigInt) rightNodeValue;
                    this.state_ = state = state | 0b100000 /* add-active doBigInt(BigInt, BigInt) */;
                    lock.unlock();
                    hasLock = false;
                    return doBigInt(leftNodeValue_, rightNodeValue_);
                }
            }
            GenericData s7_ = super.insert(new GenericData());
            s7_.leftNumeric_ = s7_.insertAccessor((JSToNumericNode.create()));
            s7_.rightNumeric_ = s7_.insertAccessor((JSToNumericNode.create()));
            s7_.and_ = s7_.insertAccessor((JSBitwiseAndNode.createInner()));
            s7_.mixedNumericTypes_ = (BranchProfile.create());
            this.generic_cache = s7_;
            this.exclude_ = exclude = exclude | 0b111111 /* add-excluded doInteger(int, int), doSafeIntegerInt(SafeInteger, int), doIntSafeInteger(int, SafeInteger), doSafeInteger(SafeInteger, SafeInteger), doDouble(double, double, JSToInt32Node, JSToInt32Node), doBigInt(BigInt, BigInt) */;
            state = state & 0xffffffc0 /* remove-active doInteger(int, int), doSafeIntegerInt(SafeInteger, int), doIntSafeInteger(int, SafeInteger), doSafeInteger(SafeInteger, SafeInteger), doDouble(double, double, JSToInt32Node, JSToInt32Node), doBigInt(BigInt, BigInt) */;
            this.state_ = state = state | 0b1000000 /* add-active doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSBitwiseAndNode, BranchProfile) */;
            lock.unlock();
            hasLock = false;
            return doGeneric(leftNodeValue, rightNodeValue, s7_.leftNumeric_, s7_.rightNumeric_, s7_.and_, s7_.mixedNumericTypes_);
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
        s[0] = "doSafeIntegerInt";
        if ((state & 0b10) != 0 /* is-active doSafeIntegerInt(SafeInteger, int) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b10) != 0 /* is-excluded doSafeIntegerInt(SafeInteger, int) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doIntSafeInteger";
        if ((state & 0b100) != 0 /* is-active doIntSafeInteger(int, SafeInteger) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b100) != 0 /* is-excluded doIntSafeInteger(int, SafeInteger) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doSafeInteger";
        if ((state & 0b1000) != 0 /* is-active doSafeInteger(SafeInteger, SafeInteger) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b1000) != 0 /* is-excluded doSafeInteger(SafeInteger, SafeInteger) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doDouble";
        if ((state & 0b10000) != 0 /* is-active doDouble(double, double, JSToInt32Node, JSToInt32Node) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.double_leftInt32_, this.double_rightInt32_));
            s[2] = cached;
        } else if ((exclude & 0b10000) != 0 /* is-excluded doDouble(double, double, JSToInt32Node, JSToInt32Node) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "doBigInt";
        if ((state & 0b100000) != 0 /* is-active doBigInt(BigInt, BigInt) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b100000) != 0 /* is-excluded doBigInt(BigInt, BigInt) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "doGeneric";
        if ((state & 0b1000000) != 0 /* is-active doGeneric(Object, Object, JSToNumericNode, JSToNumericNode, JSBitwiseAndNode, BranchProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            GenericData s7_ = this.generic_cache;
            if (s7_ != null) {
                cached.add(Arrays.asList(s7_.leftNumeric_, s7_.rightNumeric_, s7_.and_, s7_.mixedNumericTypes_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        return Provider.create(data);
    }

    public static JSBitwiseAndNode create(JavaScriptNode left, JavaScriptNode right) {
        return new JSBitwiseAndNodeGen(left, right);
    }

    @GeneratedBy(JSBitwiseAndNode.class)
    private static final class GenericData extends Node {

        @Child JSToNumericNode leftNumeric_;
        @Child JSToNumericNode rightNumeric_;
        @Child JSBitwiseAndNode and_;
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
