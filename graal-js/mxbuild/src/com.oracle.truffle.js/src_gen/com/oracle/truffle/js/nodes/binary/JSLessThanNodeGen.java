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
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.cast.JSToPrimitiveNode;
import com.oracle.truffle.js.nodes.cast.JSToStringOrNumberNode;
import com.oracle.truffle.js.runtime.BigInt;
import com.oracle.truffle.js.runtime.SafeInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSLessThanNode.class)
public final class JSLessThanNodeGen extends JSLessThanNode implements Provider {

    @CompilationFinal private volatile long state_;
    @CompilationFinal private volatile int exclude_;
    @Child private GenericData generic_cache;

    private JSLessThanNodeGen(JavaScriptNode left, JavaScriptNode right) {
        super(left, right);
    }

    @Override
    public boolean executeBoolean(Object leftNodeValue, Object rightNodeValue) {
        long state = state_;
        if ((state & 0b11) != 0 /* is-active doInt(int, int) || doSafeInteger(int, SafeInteger) */ && leftNodeValue instanceof Integer) {
            int leftNodeValue_ = (int) leftNodeValue;
            if ((state & 0b1) != 0 /* is-active doInt(int, int) */ && rightNodeValue instanceof Integer) {
                int rightNodeValue_ = (int) rightNodeValue;
                return doInt(leftNodeValue_, rightNodeValue_);
            }
            if ((state & 0b10) != 0 /* is-active doSafeInteger(int, SafeInteger) */ && rightNodeValue instanceof SafeInteger) {
                SafeInteger rightNodeValue_ = (SafeInteger) rightNodeValue;
                return doSafeInteger(leftNodeValue_, rightNodeValue_);
            }
        }
        if ((state & 0b1100) != 0 /* is-active doSafeInteger(SafeInteger, int) || doSafeInteger(SafeInteger, SafeInteger) */ && leftNodeValue instanceof SafeInteger) {
            SafeInteger leftNodeValue_ = (SafeInteger) leftNodeValue;
            if ((state & 0b100) != 0 /* is-active doSafeInteger(SafeInteger, int) */ && rightNodeValue instanceof Integer) {
                int rightNodeValue_ = (int) rightNodeValue;
                return doSafeInteger(leftNodeValue_, rightNodeValue_);
            }
            if ((state & 0b1000) != 0 /* is-active doSafeInteger(SafeInteger, SafeInteger) */ && rightNodeValue instanceof SafeInteger) {
                SafeInteger rightNodeValue_ = (SafeInteger) rightNodeValue;
                return doSafeInteger(leftNodeValue_, rightNodeValue_);
            }
        }
        if ((state & 0b10000) != 0 /* is-active doDouble(double, double) */ && JSTypesGen.isImplicitDouble((int)((state & 0x1e0000L) >>> 17) /* extract-implicit-active 0:double */, leftNodeValue)) {
            double leftNodeValue_ = JSTypesGen.asImplicitDouble((int)((state & 0x1e0000L) >>> 17) /* extract-implicit-active 0:double */, leftNodeValue);
            if (JSTypesGen.isImplicitDouble((int)((state & 0x1e00000L) >>> 21) /* extract-implicit-active 1:double */, rightNodeValue)) {
                double rightNodeValue_ = JSTypesGen.asImplicitDouble((int)((state & 0x1e00000L) >>> 21) /* extract-implicit-active 1:double */, rightNodeValue);
                return doDouble(leftNodeValue_, rightNodeValue_);
            }
        }
        if ((state & 0b1100000) != 0 /* is-active doString(String, String) || doStringDouble(String, double) */ && JSTypesGen.isImplicitString((int)((state & 0x1e000000L) >>> 25) /* extract-implicit-active 0:String */, leftNodeValue)) {
            String leftNodeValue_ = JSTypesGen.asImplicitString((int)((state & 0x1e000000L) >>> 25) /* extract-implicit-active 0:String */, leftNodeValue);
            if ((state & 0b100000) != 0 /* is-active doString(String, String) */ && JSTypesGen.isImplicitString((int)((state & 0x1e0000000L) >>> 29) /* extract-implicit-active 1:String */, rightNodeValue)) {
                String rightNodeValue_ = JSTypesGen.asImplicitString((int)((state & 0x1e0000000L) >>> 29) /* extract-implicit-active 1:String */, rightNodeValue);
                return doString(leftNodeValue_, rightNodeValue_);
            }
            if ((state & 0b1000000) != 0 /* is-active doStringDouble(String, double) */ && JSTypesGen.isImplicitDouble((int)((state & 0x1e00000L) >>> 21) /* extract-implicit-active 1:double */, rightNodeValue)) {
                double rightNodeValue_ = JSTypesGen.asImplicitDouble((int)((state & 0x1e00000L) >>> 21) /* extract-implicit-active 1:double */, rightNodeValue);
                return doStringDouble(leftNodeValue_, rightNodeValue_);
            }
        }
        if ((state & 0b10000000) != 0 /* is-active doDoubleString(double, String) */ && JSTypesGen.isImplicitDouble((int)((state & 0x1e0000L) >>> 17) /* extract-implicit-active 0:double */, leftNodeValue)) {
            double leftNodeValue_ = JSTypesGen.asImplicitDouble((int)((state & 0x1e0000L) >>> 17) /* extract-implicit-active 0:double */, leftNodeValue);
            if (JSTypesGen.isImplicitString((int)((state & 0x1e0000000L) >>> 29) /* extract-implicit-active 1:String */, rightNodeValue)) {
                String rightNodeValue_ = JSTypesGen.asImplicitString((int)((state & 0x1e0000000L) >>> 29) /* extract-implicit-active 1:String */, rightNodeValue);
                return doDoubleString(leftNodeValue_, rightNodeValue_);
            }
        }
        if ((state & 0b100000000) != 0 /* is-active doStringBigInt(String, BigInt) */ && JSTypesGen.isImplicitString((int)((state & 0x1e000000L) >>> 25) /* extract-implicit-active 0:String */, leftNodeValue)) {
            String leftNodeValue_ = JSTypesGen.asImplicitString((int)((state & 0x1e000000L) >>> 25) /* extract-implicit-active 0:String */, leftNodeValue);
            if (rightNodeValue instanceof BigInt) {
                BigInt rightNodeValue_ = (BigInt) rightNodeValue;
                return doStringBigInt(leftNodeValue_, rightNodeValue_);
            }
        }
        if ((state & 0b1111000000000) != 0 /* is-active doBigIntString(BigInt, String) || doBigInt(BigInt, BigInt) || doBigIntAndInt(BigInt, int) || doBigIntAndNumber(BigInt, double) */ && leftNodeValue instanceof BigInt) {
            BigInt leftNodeValue_ = (BigInt) leftNodeValue;
            if ((state & 0b1000000000) != 0 /* is-active doBigIntString(BigInt, String) */ && JSTypesGen.isImplicitString((int)((state & 0x1e0000000L) >>> 29) /* extract-implicit-active 1:String */, rightNodeValue)) {
                String rightNodeValue_ = JSTypesGen.asImplicitString((int)((state & 0x1e0000000L) >>> 29) /* extract-implicit-active 1:String */, rightNodeValue);
                return doBigIntString(leftNodeValue_, rightNodeValue_);
            }
            if ((state & 0b10000000000) != 0 /* is-active doBigInt(BigInt, BigInt) */ && rightNodeValue instanceof BigInt) {
                BigInt rightNodeValue_ = (BigInt) rightNodeValue;
                return doBigInt(leftNodeValue_, rightNodeValue_);
            }
            if ((state & 0b100000000000) != 0 /* is-active doBigIntAndInt(BigInt, int) */ && rightNodeValue instanceof Integer) {
                int rightNodeValue_ = (int) rightNodeValue;
                return doBigIntAndInt(leftNodeValue_, rightNodeValue_);
            }
            if ((state & 0b1000000000000) != 0 /* is-active doBigIntAndNumber(BigInt, double) */ && JSTypesGen.isImplicitDouble((int)((state & 0x1e00000L) >>> 21) /* extract-implicit-active 1:double */, rightNodeValue)) {
                double rightNodeValue_ = JSTypesGen.asImplicitDouble((int)((state & 0x1e00000L) >>> 21) /* extract-implicit-active 1:double */, rightNodeValue);
                return doBigIntAndNumber(leftNodeValue_, rightNodeValue_);
            }
        }
        if ((state & 0b110000000000000) != 0 /* is-active doIntAndBigInt(int, BigInt) || doNumberAndBigInt(double, BigInt) */ && rightNodeValue instanceof BigInt) {
            BigInt rightNodeValue_ = (BigInt) rightNodeValue;
            if ((state & 0b10000000000000) != 0 /* is-active doIntAndBigInt(int, BigInt) */ && leftNodeValue instanceof Integer) {
                int leftNodeValue_ = (int) leftNodeValue;
                return doIntAndBigInt(leftNodeValue_, rightNodeValue_);
            }
            if ((state & 0b100000000000000) != 0 /* is-active doNumberAndBigInt(double, BigInt) */ && JSTypesGen.isImplicitDouble((int)((state & 0x1e0000L) >>> 17) /* extract-implicit-active 0:double */, leftNodeValue)) {
                double leftNodeValue_ = JSTypesGen.asImplicitDouble((int)((state & 0x1e0000L) >>> 17) /* extract-implicit-active 0:double */, leftNodeValue);
                return doNumberAndBigInt(leftNodeValue_, rightNodeValue_);
            }
        }
        if ((state & 0x18000L) != 0 /* is-active doJavaNumber(Object, Object) || doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSLessThanNode) */) {
            if ((state & 0b1000000000000000) != 0 /* is-active doJavaNumber(Object, Object) */) {
                if ((JSGuards.isJavaNumber(leftNodeValue)) && (JSGuards.isJavaNumber(rightNodeValue))) {
                    return doJavaNumber(leftNodeValue, rightNodeValue);
                }
            }
            if ((state & 0x10000L) != 0 /* is-active doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSLessThanNode) */) {
                GenericData s17_ = this.generic_cache;
                if (s17_ != null) {
                    return doGeneric(leftNodeValue, rightNodeValue, s17_.toStringOrNumber1_, s17_.toPrimitive1_, s17_.toStringOrNumber2_, s17_.toPrimitive2_, s17_.lessThanNode_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(leftNodeValue, rightNodeValue);
    }

    @Override
    public boolean executeBoolean(VirtualFrame frameValue) {
        long state = state_;
        if ((state & 0x1fffeL) == 0 /* only-active doInt(int, int) */ && (state & 0x1ffffL) != 0  /* is-not doInt(int, int) && doSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doString(String, String) && doStringDouble(String, double) && doDoubleString(double, String) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBigInt(BigInt, BigInt) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJavaNumber(Object, Object) && doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSLessThanNode) */) {
            return executeBoolean_int_int0(frameValue, state);
        } else if ((state & 0x1ffefL) == 0 /* only-active doDouble(double, double) */ && (state & 0x1ffffL) != 0  /* is-not doInt(int, int) && doSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doString(String, String) && doStringDouble(String, double) && doDoubleString(double, String) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBigInt(BigInt, BigInt) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJavaNumber(Object, Object) && doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSLessThanNode) */) {
            return executeBoolean_double_double1(frameValue, state);
        } else if ((state & 0x1dffdL) == 0 /* only-active doSafeInteger(int, SafeInteger) && doIntAndBigInt(int, BigInt) */ && (state & 0x1ffffL) != 0  /* is-not doInt(int, int) && doSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doString(String, String) && doStringDouble(String, double) && doDoubleString(double, String) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBigInt(BigInt, BigInt) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJavaNumber(Object, Object) && doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSLessThanNode) */) {
            return executeBoolean_int2(frameValue, state);
        } else if ((state & 0x1f7fbL) == 0 /* only-active doSafeInteger(SafeInteger, int) && doBigIntAndInt(BigInt, int) */ && (state & 0x1ffffL) != 0  /* is-not doInt(int, int) && doSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doString(String, String) && doStringDouble(String, double) && doDoubleString(double, String) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBigInt(BigInt, BigInt) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJavaNumber(Object, Object) && doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSLessThanNode) */) {
            return executeBoolean_int3(frameValue, state);
        } else if ((state & 0x1efbfL) == 0 /* only-active doStringDouble(String, double) && doBigIntAndNumber(BigInt, double) */ && (state & 0x1ffffL) != 0  /* is-not doInt(int, int) && doSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doString(String, String) && doStringDouble(String, double) && doDoubleString(double, String) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBigInt(BigInt, BigInt) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJavaNumber(Object, Object) && doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSLessThanNode) */) {
            return executeBoolean_double4(frameValue, state);
        } else if ((state & 0x1bf7fL) == 0 /* only-active doDoubleString(double, String) && doNumberAndBigInt(double, BigInt) */ && (state & 0x1ffffL) != 0  /* is-not doInt(int, int) && doSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doString(String, String) && doStringDouble(String, double) && doDoubleString(double, String) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBigInt(BigInt, BigInt) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJavaNumber(Object, Object) && doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSLessThanNode) */) {
            return executeBoolean_double5(frameValue, state);
        } else {
            return executeBoolean_generic6(frameValue, state);
        }
    }

    private boolean executeBoolean_int_int0(VirtualFrame frameValue, long state) {
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
        assert (state & 0b1) != 0 /* is-active doInt(int, int) */;
        return doInt(leftNodeValue_, rightNodeValue_);
    }

    private boolean executeBoolean_double_double1(VirtualFrame frameValue, long state) {
        int leftNodeValue_int = 0;
        long leftNodeValue_long = 0L;
        double leftNodeValue_;
        try {
            if ((state & 0x1c0000L) == 0 /* only-active 0:double */ && (state & 0x1ffffL) != 0  /* is-not doInt(int, int) && doSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doString(String, String) && doStringDouble(String, double) && doDoubleString(double, String) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBigInt(BigInt, BigInt) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJavaNumber(Object, Object) && doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSLessThanNode) */) {
                leftNodeValue_long = super.leftNode.executeLong(frameValue);
                leftNodeValue_ = JSTypes.longToDouble(leftNodeValue_long);
            } else if ((state & 0x1a0000L) == 0 /* only-active 0:double */ && (state & 0x1ffffL) != 0  /* is-not doInt(int, int) && doSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doString(String, String) && doStringDouble(String, double) && doDoubleString(double, String) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBigInt(BigInt, BigInt) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJavaNumber(Object, Object) && doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSLessThanNode) */) {
                leftNodeValue_int = super.leftNode.executeInt(frameValue);
                leftNodeValue_ = JSTypes.intToDouble(leftNodeValue_int);
            } else if ((state & 0x160000L) == 0 /* only-active 0:double */ && (state & 0x1ffffL) != 0  /* is-not doInt(int, int) && doSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doString(String, String) && doStringDouble(String, double) && doDoubleString(double, String) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBigInt(BigInt, BigInt) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJavaNumber(Object, Object) && doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSLessThanNode) */) {
                leftNodeValue_ = super.leftNode.executeDouble(frameValue);
            } else {
                Object leftNodeValue__ = super.leftNode.execute(frameValue);
                leftNodeValue_ = JSTypesGen.expectImplicitDouble((int)((state & 0x1e0000L) >>> 17) /* extract-implicit-active 0:double */, leftNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            Object rightNodeValue = super.rightNode.execute(frameValue);
            return executeAndSpecialize(ex.getResult(), rightNodeValue);
        }
        int rightNodeValue_int = 0;
        long rightNodeValue_long = 0L;
        double rightNodeValue_;
        try {
            if ((state & 0x1c00000L) == 0 /* only-active 1:double */ && (state & 0x1ffffL) != 0  /* is-not doInt(int, int) && doSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doString(String, String) && doStringDouble(String, double) && doDoubleString(double, String) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBigInt(BigInt, BigInt) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJavaNumber(Object, Object) && doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSLessThanNode) */) {
                rightNodeValue_long = super.rightNode.executeLong(frameValue);
                rightNodeValue_ = JSTypes.longToDouble(rightNodeValue_long);
            } else if ((state & 0x1a00000L) == 0 /* only-active 1:double */ && (state & 0x1ffffL) != 0  /* is-not doInt(int, int) && doSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doString(String, String) && doStringDouble(String, double) && doDoubleString(double, String) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBigInt(BigInt, BigInt) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJavaNumber(Object, Object) && doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSLessThanNode) */) {
                rightNodeValue_int = super.rightNode.executeInt(frameValue);
                rightNodeValue_ = JSTypes.intToDouble(rightNodeValue_int);
            } else if ((state & 0x1600000L) == 0 /* only-active 1:double */ && (state & 0x1ffffL) != 0  /* is-not doInt(int, int) && doSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doString(String, String) && doStringDouble(String, double) && doDoubleString(double, String) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBigInt(BigInt, BigInt) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJavaNumber(Object, Object) && doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSLessThanNode) */) {
                rightNodeValue_ = super.rightNode.executeDouble(frameValue);
            } else {
                Object rightNodeValue__ = super.rightNode.execute(frameValue);
                rightNodeValue_ = JSTypesGen.expectImplicitDouble((int)((state & 0x1e00000L) >>> 21) /* extract-implicit-active 1:double */, rightNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(((state & 0x1c0000L) == 0 /* only-active 0:double */ && (state & 0x1ffffL) != 0  /* is-not doInt(int, int) && doSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doString(String, String) && doStringDouble(String, double) && doDoubleString(double, String) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBigInt(BigInt, BigInt) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJavaNumber(Object, Object) && doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSLessThanNode) */ ? (Object) leftNodeValue_long : ((state & 0x1a0000L) == 0 /* only-active 0:double */ && (state & 0x1ffffL) != 0  /* is-not doInt(int, int) && doSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doString(String, String) && doStringDouble(String, double) && doDoubleString(double, String) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBigInt(BigInt, BigInt) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJavaNumber(Object, Object) && doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSLessThanNode) */ ? (Object) leftNodeValue_int : (Object) leftNodeValue_)), ex.getResult());
        }
        assert (state & 0b10000) != 0 /* is-active doDouble(double, double) */;
        return doDouble(leftNodeValue_, rightNodeValue_);
    }

    private boolean executeBoolean_int2(VirtualFrame frameValue, long state) {
        int leftNodeValue_;
        try {
            leftNodeValue_ = super.leftNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            Object rightNodeValue = super.rightNode.execute(frameValue);
            return executeAndSpecialize(ex.getResult(), rightNodeValue);
        }
        Object rightNodeValue_ = super.rightNode.execute(frameValue);
        if ((state & 0b10) != 0 /* is-active doSafeInteger(int, SafeInteger) */ && rightNodeValue_ instanceof SafeInteger) {
            SafeInteger rightNodeValue__ = (SafeInteger) rightNodeValue_;
            return doSafeInteger(leftNodeValue_, rightNodeValue__);
        }
        if ((state & 0b10000000000000) != 0 /* is-active doIntAndBigInt(int, BigInt) */ && rightNodeValue_ instanceof BigInt) {
            BigInt rightNodeValue__ = (BigInt) rightNodeValue_;
            return doIntAndBigInt(leftNodeValue_, rightNodeValue__);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
    }

    private boolean executeBoolean_int3(VirtualFrame frameValue, long state) {
        Object leftNodeValue_ = super.leftNode.execute(frameValue);
        int rightNodeValue_;
        try {
            rightNodeValue_ = super.rightNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(leftNodeValue_, ex.getResult());
        }
        if ((state & 0b100) != 0 /* is-active doSafeInteger(SafeInteger, int) */ && leftNodeValue_ instanceof SafeInteger) {
            SafeInteger leftNodeValue__ = (SafeInteger) leftNodeValue_;
            return doSafeInteger(leftNodeValue__, rightNodeValue_);
        }
        if ((state & 0b100000000000) != 0 /* is-active doBigIntAndInt(BigInt, int) */ && leftNodeValue_ instanceof BigInt) {
            BigInt leftNodeValue__ = (BigInt) leftNodeValue_;
            return doBigIntAndInt(leftNodeValue__, rightNodeValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
    }

    private boolean executeBoolean_double4(VirtualFrame frameValue, long state) {
        Object leftNodeValue_ = super.leftNode.execute(frameValue);
        int rightNodeValue_int = 0;
        long rightNodeValue_long = 0L;
        double rightNodeValue_;
        try {
            if ((state & 0x1c00000L) == 0 /* only-active 1:double */ && (state & 0x1ffffL) != 0  /* is-not doInt(int, int) && doSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doString(String, String) && doStringDouble(String, double) && doDoubleString(double, String) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBigInt(BigInt, BigInt) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJavaNumber(Object, Object) && doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSLessThanNode) */) {
                rightNodeValue_long = super.rightNode.executeLong(frameValue);
                rightNodeValue_ = JSTypes.longToDouble(rightNodeValue_long);
            } else if ((state & 0x1a00000L) == 0 /* only-active 1:double */ && (state & 0x1ffffL) != 0  /* is-not doInt(int, int) && doSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doString(String, String) && doStringDouble(String, double) && doDoubleString(double, String) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBigInt(BigInt, BigInt) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJavaNumber(Object, Object) && doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSLessThanNode) */) {
                rightNodeValue_int = super.rightNode.executeInt(frameValue);
                rightNodeValue_ = JSTypes.intToDouble(rightNodeValue_int);
            } else if ((state & 0x1600000L) == 0 /* only-active 1:double */ && (state & 0x1ffffL) != 0  /* is-not doInt(int, int) && doSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doString(String, String) && doStringDouble(String, double) && doDoubleString(double, String) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBigInt(BigInt, BigInt) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJavaNumber(Object, Object) && doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSLessThanNode) */) {
                rightNodeValue_ = super.rightNode.executeDouble(frameValue);
            } else {
                Object rightNodeValue__ = super.rightNode.execute(frameValue);
                rightNodeValue_ = JSTypesGen.expectImplicitDouble((int)((state & 0x1e00000L) >>> 21) /* extract-implicit-active 1:double */, rightNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(leftNodeValue_, ex.getResult());
        }
        if ((state & 0b1000000) != 0 /* is-active doStringDouble(String, double) */ && JSTypesGen.isImplicitString((int)((state & 0x1e000000L) >>> 25) /* extract-implicit-active 0:String */, leftNodeValue_)) {
            String leftNodeValue__ = JSTypesGen.asImplicitString((int)((state & 0x1e000000L) >>> 25) /* extract-implicit-active 0:String */, leftNodeValue_);
            return doStringDouble(leftNodeValue__, rightNodeValue_);
        }
        if ((state & 0b1000000000000) != 0 /* is-active doBigIntAndNumber(BigInt, double) */ && leftNodeValue_ instanceof BigInt) {
            BigInt leftNodeValue__ = (BigInt) leftNodeValue_;
            return doBigIntAndNumber(leftNodeValue__, rightNodeValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(leftNodeValue_, ((state & 0x1c00000L) == 0 /* only-active 1:double */ && (state & 0x1ffffL) != 0  /* is-not doInt(int, int) && doSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doString(String, String) && doStringDouble(String, double) && doDoubleString(double, String) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBigInt(BigInt, BigInt) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJavaNumber(Object, Object) && doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSLessThanNode) */ ? (Object) rightNodeValue_long : ((state & 0x1a00000L) == 0 /* only-active 1:double */ && (state & 0x1ffffL) != 0  /* is-not doInt(int, int) && doSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doString(String, String) && doStringDouble(String, double) && doDoubleString(double, String) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBigInt(BigInt, BigInt) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJavaNumber(Object, Object) && doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSLessThanNode) */ ? (Object) rightNodeValue_int : (Object) rightNodeValue_)));
    }

    private boolean executeBoolean_double5(VirtualFrame frameValue, long state) {
        int leftNodeValue_int = 0;
        long leftNodeValue_long = 0L;
        double leftNodeValue_;
        try {
            if ((state & 0x1c0000L) == 0 /* only-active 0:double */ && (state & 0x1ffffL) != 0  /* is-not doInt(int, int) && doSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doString(String, String) && doStringDouble(String, double) && doDoubleString(double, String) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBigInt(BigInt, BigInt) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJavaNumber(Object, Object) && doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSLessThanNode) */) {
                leftNodeValue_long = super.leftNode.executeLong(frameValue);
                leftNodeValue_ = JSTypes.longToDouble(leftNodeValue_long);
            } else if ((state & 0x1a0000L) == 0 /* only-active 0:double */ && (state & 0x1ffffL) != 0  /* is-not doInt(int, int) && doSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doString(String, String) && doStringDouble(String, double) && doDoubleString(double, String) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBigInt(BigInt, BigInt) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJavaNumber(Object, Object) && doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSLessThanNode) */) {
                leftNodeValue_int = super.leftNode.executeInt(frameValue);
                leftNodeValue_ = JSTypes.intToDouble(leftNodeValue_int);
            } else if ((state & 0x160000L) == 0 /* only-active 0:double */ && (state & 0x1ffffL) != 0  /* is-not doInt(int, int) && doSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doString(String, String) && doStringDouble(String, double) && doDoubleString(double, String) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBigInt(BigInt, BigInt) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJavaNumber(Object, Object) && doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSLessThanNode) */) {
                leftNodeValue_ = super.leftNode.executeDouble(frameValue);
            } else {
                Object leftNodeValue__ = super.leftNode.execute(frameValue);
                leftNodeValue_ = JSTypesGen.expectImplicitDouble((int)((state & 0x1e0000L) >>> 17) /* extract-implicit-active 0:double */, leftNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            Object rightNodeValue = super.rightNode.execute(frameValue);
            return executeAndSpecialize(ex.getResult(), rightNodeValue);
        }
        Object rightNodeValue_ = super.rightNode.execute(frameValue);
        if ((state & 0b10000000) != 0 /* is-active doDoubleString(double, String) */ && JSTypesGen.isImplicitString((int)((state & 0x1e0000000L) >>> 29) /* extract-implicit-active 1:String */, rightNodeValue_)) {
            String rightNodeValue__ = JSTypesGen.asImplicitString((int)((state & 0x1e0000000L) >>> 29) /* extract-implicit-active 1:String */, rightNodeValue_);
            return doDoubleString(leftNodeValue_, rightNodeValue__);
        }
        if ((state & 0b100000000000000) != 0 /* is-active doNumberAndBigInt(double, BigInt) */ && rightNodeValue_ instanceof BigInt) {
            BigInt rightNodeValue__ = (BigInt) rightNodeValue_;
            return doNumberAndBigInt(leftNodeValue_, rightNodeValue__);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(((state & 0x1c0000L) == 0 /* only-active 0:double */ && (state & 0x1ffffL) != 0  /* is-not doInt(int, int) && doSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doString(String, String) && doStringDouble(String, double) && doDoubleString(double, String) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBigInt(BigInt, BigInt) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJavaNumber(Object, Object) && doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSLessThanNode) */ ? (Object) leftNodeValue_long : ((state & 0x1a0000L) == 0 /* only-active 0:double */ && (state & 0x1ffffL) != 0  /* is-not doInt(int, int) && doSafeInteger(int, SafeInteger) && doSafeInteger(SafeInteger, int) && doSafeInteger(SafeInteger, SafeInteger) && doDouble(double, double) && doString(String, String) && doStringDouble(String, double) && doDoubleString(double, String) && doStringBigInt(String, BigInt) && doBigIntString(BigInt, String) && doBigInt(BigInt, BigInt) && doBigIntAndInt(BigInt, int) && doBigIntAndNumber(BigInt, double) && doIntAndBigInt(int, BigInt) && doNumberAndBigInt(double, BigInt) && doJavaNumber(Object, Object) && doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSLessThanNode) */ ? (Object) leftNodeValue_int : (Object) leftNodeValue_)), rightNodeValue_);
    }

    private boolean executeBoolean_generic6(VirtualFrame frameValue, long state) {
        Object leftNodeValue_ = super.leftNode.execute(frameValue);
        Object rightNodeValue_ = super.rightNode.execute(frameValue);
        if ((state & 0b11) != 0 /* is-active doInt(int, int) || doSafeInteger(int, SafeInteger) */ && leftNodeValue_ instanceof Integer) {
            int leftNodeValue__ = (int) leftNodeValue_;
            if ((state & 0b1) != 0 /* is-active doInt(int, int) */ && rightNodeValue_ instanceof Integer) {
                int rightNodeValue__ = (int) rightNodeValue_;
                return doInt(leftNodeValue__, rightNodeValue__);
            }
            if ((state & 0b10) != 0 /* is-active doSafeInteger(int, SafeInteger) */ && rightNodeValue_ instanceof SafeInteger) {
                SafeInteger rightNodeValue__ = (SafeInteger) rightNodeValue_;
                return doSafeInteger(leftNodeValue__, rightNodeValue__);
            }
        }
        if ((state & 0b1100) != 0 /* is-active doSafeInteger(SafeInteger, int) || doSafeInteger(SafeInteger, SafeInteger) */ && leftNodeValue_ instanceof SafeInteger) {
            SafeInteger leftNodeValue__ = (SafeInteger) leftNodeValue_;
            if ((state & 0b100) != 0 /* is-active doSafeInteger(SafeInteger, int) */ && rightNodeValue_ instanceof Integer) {
                int rightNodeValue__ = (int) rightNodeValue_;
                return doSafeInteger(leftNodeValue__, rightNodeValue__);
            }
            if ((state & 0b1000) != 0 /* is-active doSafeInteger(SafeInteger, SafeInteger) */ && rightNodeValue_ instanceof SafeInteger) {
                SafeInteger rightNodeValue__ = (SafeInteger) rightNodeValue_;
                return doSafeInteger(leftNodeValue__, rightNodeValue__);
            }
        }
        if ((state & 0b10000) != 0 /* is-active doDouble(double, double) */ && JSTypesGen.isImplicitDouble((int)((state & 0x1e0000L) >>> 17) /* extract-implicit-active 0:double */, leftNodeValue_)) {
            double leftNodeValue__ = JSTypesGen.asImplicitDouble((int)((state & 0x1e0000L) >>> 17) /* extract-implicit-active 0:double */, leftNodeValue_);
            if (JSTypesGen.isImplicitDouble((int)((state & 0x1e00000L) >>> 21) /* extract-implicit-active 1:double */, rightNodeValue_)) {
                double rightNodeValue__ = JSTypesGen.asImplicitDouble((int)((state & 0x1e00000L) >>> 21) /* extract-implicit-active 1:double */, rightNodeValue_);
                return doDouble(leftNodeValue__, rightNodeValue__);
            }
        }
        if ((state & 0b1100000) != 0 /* is-active doString(String, String) || doStringDouble(String, double) */ && JSTypesGen.isImplicitString((int)((state & 0x1e000000L) >>> 25) /* extract-implicit-active 0:String */, leftNodeValue_)) {
            String leftNodeValue__ = JSTypesGen.asImplicitString((int)((state & 0x1e000000L) >>> 25) /* extract-implicit-active 0:String */, leftNodeValue_);
            if ((state & 0b100000) != 0 /* is-active doString(String, String) */ && JSTypesGen.isImplicitString((int)((state & 0x1e0000000L) >>> 29) /* extract-implicit-active 1:String */, rightNodeValue_)) {
                String rightNodeValue__ = JSTypesGen.asImplicitString((int)((state & 0x1e0000000L) >>> 29) /* extract-implicit-active 1:String */, rightNodeValue_);
                return doString(leftNodeValue__, rightNodeValue__);
            }
            if ((state & 0b1000000) != 0 /* is-active doStringDouble(String, double) */ && JSTypesGen.isImplicitDouble((int)((state & 0x1e00000L) >>> 21) /* extract-implicit-active 1:double */, rightNodeValue_)) {
                double rightNodeValue__ = JSTypesGen.asImplicitDouble((int)((state & 0x1e00000L) >>> 21) /* extract-implicit-active 1:double */, rightNodeValue_);
                return doStringDouble(leftNodeValue__, rightNodeValue__);
            }
        }
        if ((state & 0b10000000) != 0 /* is-active doDoubleString(double, String) */ && JSTypesGen.isImplicitDouble((int)((state & 0x1e0000L) >>> 17) /* extract-implicit-active 0:double */, leftNodeValue_)) {
            double leftNodeValue__ = JSTypesGen.asImplicitDouble((int)((state & 0x1e0000L) >>> 17) /* extract-implicit-active 0:double */, leftNodeValue_);
            if (JSTypesGen.isImplicitString((int)((state & 0x1e0000000L) >>> 29) /* extract-implicit-active 1:String */, rightNodeValue_)) {
                String rightNodeValue__ = JSTypesGen.asImplicitString((int)((state & 0x1e0000000L) >>> 29) /* extract-implicit-active 1:String */, rightNodeValue_);
                return doDoubleString(leftNodeValue__, rightNodeValue__);
            }
        }
        if ((state & 0b100000000) != 0 /* is-active doStringBigInt(String, BigInt) */ && JSTypesGen.isImplicitString((int)((state & 0x1e000000L) >>> 25) /* extract-implicit-active 0:String */, leftNodeValue_)) {
            String leftNodeValue__ = JSTypesGen.asImplicitString((int)((state & 0x1e000000L) >>> 25) /* extract-implicit-active 0:String */, leftNodeValue_);
            if (rightNodeValue_ instanceof BigInt) {
                BigInt rightNodeValue__ = (BigInt) rightNodeValue_;
                return doStringBigInt(leftNodeValue__, rightNodeValue__);
            }
        }
        if ((state & 0b1111000000000) != 0 /* is-active doBigIntString(BigInt, String) || doBigInt(BigInt, BigInt) || doBigIntAndInt(BigInt, int) || doBigIntAndNumber(BigInt, double) */ && leftNodeValue_ instanceof BigInt) {
            BigInt leftNodeValue__ = (BigInt) leftNodeValue_;
            if ((state & 0b1000000000) != 0 /* is-active doBigIntString(BigInt, String) */ && JSTypesGen.isImplicitString((int)((state & 0x1e0000000L) >>> 29) /* extract-implicit-active 1:String */, rightNodeValue_)) {
                String rightNodeValue__ = JSTypesGen.asImplicitString((int)((state & 0x1e0000000L) >>> 29) /* extract-implicit-active 1:String */, rightNodeValue_);
                return doBigIntString(leftNodeValue__, rightNodeValue__);
            }
            if ((state & 0b10000000000) != 0 /* is-active doBigInt(BigInt, BigInt) */ && rightNodeValue_ instanceof BigInt) {
                BigInt rightNodeValue__ = (BigInt) rightNodeValue_;
                return doBigInt(leftNodeValue__, rightNodeValue__);
            }
            if ((state & 0b100000000000) != 0 /* is-active doBigIntAndInt(BigInt, int) */ && rightNodeValue_ instanceof Integer) {
                int rightNodeValue__ = (int) rightNodeValue_;
                return doBigIntAndInt(leftNodeValue__, rightNodeValue__);
            }
            if ((state & 0b1000000000000) != 0 /* is-active doBigIntAndNumber(BigInt, double) */ && JSTypesGen.isImplicitDouble((int)((state & 0x1e00000L) >>> 21) /* extract-implicit-active 1:double */, rightNodeValue_)) {
                double rightNodeValue__ = JSTypesGen.asImplicitDouble((int)((state & 0x1e00000L) >>> 21) /* extract-implicit-active 1:double */, rightNodeValue_);
                return doBigIntAndNumber(leftNodeValue__, rightNodeValue__);
            }
        }
        if ((state & 0b110000000000000) != 0 /* is-active doIntAndBigInt(int, BigInt) || doNumberAndBigInt(double, BigInt) */ && rightNodeValue_ instanceof BigInt) {
            BigInt rightNodeValue__ = (BigInt) rightNodeValue_;
            if ((state & 0b10000000000000) != 0 /* is-active doIntAndBigInt(int, BigInt) */ && leftNodeValue_ instanceof Integer) {
                int leftNodeValue__ = (int) leftNodeValue_;
                return doIntAndBigInt(leftNodeValue__, rightNodeValue__);
            }
            if ((state & 0b100000000000000) != 0 /* is-active doNumberAndBigInt(double, BigInt) */ && JSTypesGen.isImplicitDouble((int)((state & 0x1e0000L) >>> 17) /* extract-implicit-active 0:double */, leftNodeValue_)) {
                double leftNodeValue__ = JSTypesGen.asImplicitDouble((int)((state & 0x1e0000L) >>> 17) /* extract-implicit-active 0:double */, leftNodeValue_);
                return doNumberAndBigInt(leftNodeValue__, rightNodeValue__);
            }
        }
        if ((state & 0x18000L) != 0 /* is-active doJavaNumber(Object, Object) || doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSLessThanNode) */) {
            if ((state & 0b1000000000000000) != 0 /* is-active doJavaNumber(Object, Object) */) {
                if ((JSGuards.isJavaNumber(leftNodeValue_)) && (JSGuards.isJavaNumber(rightNodeValue_))) {
                    return doJavaNumber(leftNodeValue_, rightNodeValue_);
                }
            }
            if ((state & 0x10000L) != 0 /* is-active doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSLessThanNode) */) {
                GenericData s17_ = this.generic_cache;
                if (s17_ != null) {
                    return doGeneric(leftNodeValue_, rightNodeValue_, s17_.toStringOrNumber1_, s17_.toPrimitive1_, s17_.toStringOrNumber2_, s17_.toPrimitive2_, s17_.lessThanNode_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        executeBoolean(frameValue);
        return;
    }

    private boolean executeAndSpecialize(Object leftNodeValue, Object rightNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        long state = state_;
        int exclude = exclude_;
        try {
            if (leftNodeValue instanceof Integer) {
                int leftNodeValue_ = (int) leftNodeValue;
                if (((exclude & 0b1)) == 0 /* is-not-excluded doInt(int, int) */ && rightNodeValue instanceof Integer) {
                    int rightNodeValue_ = (int) rightNodeValue;
                    this.state_ = state = state | 0b1 /* add-active doInt(int, int) */;
                    lock.unlock();
                    hasLock = false;
                    return doInt(leftNodeValue_, rightNodeValue_);
                }
                if (rightNodeValue instanceof SafeInteger) {
                    SafeInteger rightNodeValue_ = (SafeInteger) rightNodeValue;
                    this.state_ = state = state | 0b10 /* add-active doSafeInteger(int, SafeInteger) */;
                    lock.unlock();
                    hasLock = false;
                    return doSafeInteger(leftNodeValue_, rightNodeValue_);
                }
            }
            if (leftNodeValue instanceof SafeInteger) {
                SafeInteger leftNodeValue_ = (SafeInteger) leftNodeValue;
                if (rightNodeValue instanceof Integer) {
                    int rightNodeValue_ = (int) rightNodeValue;
                    this.state_ = state = state | 0b100 /* add-active doSafeInteger(SafeInteger, int) */;
                    lock.unlock();
                    hasLock = false;
                    return doSafeInteger(leftNodeValue_, rightNodeValue_);
                }
                if (rightNodeValue instanceof SafeInteger) {
                    SafeInteger rightNodeValue_ = (SafeInteger) rightNodeValue;
                    this.state_ = state = state | 0b1000 /* add-active doSafeInteger(SafeInteger, SafeInteger) */;
                    lock.unlock();
                    hasLock = false;
                    return doSafeInteger(leftNodeValue_, rightNodeValue_);
                }
            }
            if (((exclude & 0b10)) == 0 /* is-not-excluded doDouble(double, double) */) {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(leftNodeValue)) != 0) {
                    double leftNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast0, leftNodeValue);
                    int doubleCast1;
                    if ((doubleCast1 = JSTypesGen.specializeImplicitDouble(rightNodeValue)) != 0) {
                        double rightNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast1, rightNodeValue);
                        state = (state | ((long) doubleCast0 << 17) /* set-implicit-active 0:double */);
                        state = (state | ((long) doubleCast1 << 21) /* set-implicit-active 1:double */);
                        this.state_ = state = state | 0b10000 /* add-active doDouble(double, double) */;
                        lock.unlock();
                        hasLock = false;
                        return doDouble(leftNodeValue_, rightNodeValue_);
                    }
                }
            }
            {
                int stringCast0;
                if ((stringCast0 = JSTypesGen.specializeImplicitString(leftNodeValue)) != 0) {
                    String leftNodeValue_ = JSTypesGen.asImplicitString(stringCast0, leftNodeValue);
                    if (((exclude & 0b100)) == 0 /* is-not-excluded doString(String, String) */) {
                        int stringCast1;
                        if ((stringCast1 = JSTypesGen.specializeImplicitString(rightNodeValue)) != 0) {
                            String rightNodeValue_ = JSTypesGen.asImplicitString(stringCast1, rightNodeValue);
                            state = (state | ((long) stringCast0 << 25) /* set-implicit-active 0:String */);
                            state = (state | ((long) stringCast1 << 29) /* set-implicit-active 1:String */);
                            this.state_ = state = state | 0b100000 /* add-active doString(String, String) */;
                            lock.unlock();
                            hasLock = false;
                            return doString(leftNodeValue_, rightNodeValue_);
                        }
                    }
                    if (((exclude & 0b1000)) == 0 /* is-not-excluded doStringDouble(String, double) */) {
                        int doubleCast1;
                        if ((doubleCast1 = JSTypesGen.specializeImplicitDouble(rightNodeValue)) != 0) {
                            double rightNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast1, rightNodeValue);
                            state = (state | ((long) stringCast0 << 25) /* set-implicit-active 0:String */);
                            state = (state | ((long) doubleCast1 << 21) /* set-implicit-active 1:double */);
                            this.state_ = state = state | 0b1000000 /* add-active doStringDouble(String, double) */;
                            lock.unlock();
                            hasLock = false;
                            return doStringDouble(leftNodeValue_, rightNodeValue_);
                        }
                    }
                }
            }
            if (((exclude & 0b10000)) == 0 /* is-not-excluded doDoubleString(double, String) */) {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(leftNodeValue)) != 0) {
                    double leftNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast0, leftNodeValue);
                    int stringCast1;
                    if ((stringCast1 = JSTypesGen.specializeImplicitString(rightNodeValue)) != 0) {
                        String rightNodeValue_ = JSTypesGen.asImplicitString(stringCast1, rightNodeValue);
                        state = (state | ((long) doubleCast0 << 17) /* set-implicit-active 0:double */);
                        state = (state | ((long) stringCast1 << 29) /* set-implicit-active 1:String */);
                        this.state_ = state = state | 0b10000000 /* add-active doDoubleString(double, String) */;
                        lock.unlock();
                        hasLock = false;
                        return doDoubleString(leftNodeValue_, rightNodeValue_);
                    }
                }
            }
            {
                int stringCast0;
                if ((stringCast0 = JSTypesGen.specializeImplicitString(leftNodeValue)) != 0) {
                    String leftNodeValue_ = JSTypesGen.asImplicitString(stringCast0, leftNodeValue);
                    if (rightNodeValue instanceof BigInt) {
                        BigInt rightNodeValue_ = (BigInt) rightNodeValue;
                        state = (state | ((long) stringCast0 << 25) /* set-implicit-active 0:String */);
                        this.state_ = state = state | 0b100000000 /* add-active doStringBigInt(String, BigInt) */;
                        lock.unlock();
                        hasLock = false;
                        return doStringBigInt(leftNodeValue_, rightNodeValue_);
                    }
                }
            }
            if (leftNodeValue instanceof BigInt) {
                BigInt leftNodeValue_ = (BigInt) leftNodeValue;
                {
                    int stringCast1;
                    if ((stringCast1 = JSTypesGen.specializeImplicitString(rightNodeValue)) != 0) {
                        String rightNodeValue_ = JSTypesGen.asImplicitString(stringCast1, rightNodeValue);
                        state = (state | ((long) stringCast1 << 29) /* set-implicit-active 1:String */);
                        this.state_ = state = state | 0b1000000000 /* add-active doBigIntString(BigInt, String) */;
                        lock.unlock();
                        hasLock = false;
                        return doBigIntString(leftNodeValue_, rightNodeValue_);
                    }
                }
                if (((exclude & 0b100000)) == 0 /* is-not-excluded doBigInt(BigInt, BigInt) */ && rightNodeValue instanceof BigInt) {
                    BigInt rightNodeValue_ = (BigInt) rightNodeValue;
                    this.state_ = state = state | 0b10000000000 /* add-active doBigInt(BigInt, BigInt) */;
                    lock.unlock();
                    hasLock = false;
                    return doBigInt(leftNodeValue_, rightNodeValue_);
                }
                if (rightNodeValue instanceof Integer) {
                    int rightNodeValue_ = (int) rightNodeValue;
                    this.state_ = state = state | 0b100000000000 /* add-active doBigIntAndInt(BigInt, int) */;
                    lock.unlock();
                    hasLock = false;
                    return doBigIntAndInt(leftNodeValue_, rightNodeValue_);
                }
                if (((exclude & 0b1000000)) == 0 /* is-not-excluded doBigIntAndNumber(BigInt, double) */) {
                    int doubleCast1;
                    if ((doubleCast1 = JSTypesGen.specializeImplicitDouble(rightNodeValue)) != 0) {
                        double rightNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast1, rightNodeValue);
                        state = (state | ((long) doubleCast1 << 21) /* set-implicit-active 1:double */);
                        this.state_ = state = state | 0b1000000000000 /* add-active doBigIntAndNumber(BigInt, double) */;
                        lock.unlock();
                        hasLock = false;
                        return doBigIntAndNumber(leftNodeValue_, rightNodeValue_);
                    }
                }
            }
            if (rightNodeValue instanceof BigInt) {
                BigInt rightNodeValue_ = (BigInt) rightNodeValue;
                if (leftNodeValue instanceof Integer) {
                    int leftNodeValue_ = (int) leftNodeValue;
                    this.state_ = state = state | 0b10000000000000 /* add-active doIntAndBigInt(int, BigInt) */;
                    lock.unlock();
                    hasLock = false;
                    return doIntAndBigInt(leftNodeValue_, rightNodeValue_);
                }
                if (((exclude & 0b10000000)) == 0 /* is-not-excluded doNumberAndBigInt(double, BigInt) */) {
                    int doubleCast0;
                    if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(leftNodeValue)) != 0) {
                        double leftNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast0, leftNodeValue);
                        state = (state | ((long) doubleCast0 << 17) /* set-implicit-active 0:double */);
                        this.state_ = state = state | 0b100000000000000 /* add-active doNumberAndBigInt(double, BigInt) */;
                        lock.unlock();
                        hasLock = false;
                        return doNumberAndBigInt(leftNodeValue_, rightNodeValue_);
                    }
                }
            }
            if (((exclude & 0b100000000)) == 0 /* is-not-excluded doJavaNumber(Object, Object) */) {
                if ((JSGuards.isJavaNumber(leftNodeValue)) && (JSGuards.isJavaNumber(rightNodeValue))) {
                    this.state_ = state = state | 0b1000000000000000 /* add-active doJavaNumber(Object, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return doJavaNumber(leftNodeValue, rightNodeValue);
                }
            }
            GenericData s17_ = super.insert(new GenericData());
            s17_.toStringOrNumber1_ = s17_.insertAccessor((JSToStringOrNumberNode.create()));
            s17_.toPrimitive1_ = s17_.insertAccessor((JSToPrimitiveNode.createHintNumber()));
            s17_.toStringOrNumber2_ = s17_.insertAccessor((JSToStringOrNumberNode.create()));
            s17_.toPrimitive2_ = s17_.insertAccessor((JSToPrimitiveNode.createHintNumber()));
            s17_.lessThanNode_ = s17_.insertAccessor((JSLessThanNode.create()));
            this.generic_cache = s17_;
            this.exclude_ = exclude = exclude | 0b111111111 /* add-excluded doInt(int, int), doDouble(double, double), doString(String, String), doStringDouble(String, double), doDoubleString(double, String), doBigInt(BigInt, BigInt), doBigIntAndNumber(BigInt, double), doNumberAndBigInt(double, BigInt), doJavaNumber(Object, Object) */;
            state = state & 0xffffffffffff2b0eL /* remove-active doInt(int, int), doDouble(double, double), doString(String, String), doStringDouble(String, double), doDoubleString(double, String), doBigInt(BigInt, BigInt), doBigIntAndNumber(BigInt, double), doNumberAndBigInt(double, BigInt), doJavaNumber(Object, Object) */;
            this.state_ = state = state | 0x10000L /* add-active doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSLessThanNode) */;
            lock.unlock();
            hasLock = false;
            return doGeneric(leftNodeValue, rightNodeValue, s17_.toStringOrNumber1_, s17_.toPrimitive1_, s17_.toStringOrNumber2_, s17_.toPrimitive2_, s17_.lessThanNode_);
        } finally {
            if (hasLock) {
                lock.unlock();
            }
        }
    }

    @Override
    public NodeCost getCost() {
        long state = state_;
        if ((state & 0x1ffffL) == 0b0) {
            return NodeCost.UNINITIALIZED;
        } else if (((state & 0x1ffffL) & ((state & 0x1ffffL) - 1)) == 0 /* is-single-active  */) {
            return NodeCost.MONOMORPHIC;
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[18];
        Object[] s;
        data[0] = 0;
        long state = state_;
        int exclude = exclude_;
        s = new Object[3];
        s[0] = "doInt";
        if ((state & 0b1) != 0 /* is-active doInt(int, int) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b1) != 0 /* is-excluded doInt(int, int) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doSafeInteger";
        if ((state & 0b10) != 0 /* is-active doSafeInteger(int, SafeInteger) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doSafeInteger";
        if ((state & 0b100) != 0 /* is-active doSafeInteger(SafeInteger, int) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doSafeInteger";
        if ((state & 0b1000) != 0 /* is-active doSafeInteger(SafeInteger, SafeInteger) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doDouble";
        if ((state & 0b10000) != 0 /* is-active doDouble(double, double) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b10) != 0 /* is-excluded doDouble(double, double) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "doString";
        if ((state & 0b100000) != 0 /* is-active doString(String, String) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b100) != 0 /* is-excluded doString(String, String) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "doStringDouble";
        if ((state & 0b1000000) != 0 /* is-active doStringDouble(String, double) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b1000) != 0 /* is-excluded doStringDouble(String, double) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        s = new Object[3];
        s[0] = "doDoubleString";
        if ((state & 0b10000000) != 0 /* is-active doDoubleString(double, String) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b10000) != 0 /* is-excluded doDoubleString(double, String) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[8] = s;
        s = new Object[3];
        s[0] = "doStringBigInt";
        if ((state & 0b100000000) != 0 /* is-active doStringBigInt(String, BigInt) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[9] = s;
        s = new Object[3];
        s[0] = "doBigIntString";
        if ((state & 0b1000000000) != 0 /* is-active doBigIntString(BigInt, String) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[10] = s;
        s = new Object[3];
        s[0] = "doBigInt";
        if ((state & 0b10000000000) != 0 /* is-active doBigInt(BigInt, BigInt) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b100000) != 0 /* is-excluded doBigInt(BigInt, BigInt) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[11] = s;
        s = new Object[3];
        s[0] = "doBigIntAndInt";
        if ((state & 0b100000000000) != 0 /* is-active doBigIntAndInt(BigInt, int) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[12] = s;
        s = new Object[3];
        s[0] = "doBigIntAndNumber";
        if ((state & 0b1000000000000) != 0 /* is-active doBigIntAndNumber(BigInt, double) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b1000000) != 0 /* is-excluded doBigIntAndNumber(BigInt, double) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[13] = s;
        s = new Object[3];
        s[0] = "doIntAndBigInt";
        if ((state & 0b10000000000000) != 0 /* is-active doIntAndBigInt(int, BigInt) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[14] = s;
        s = new Object[3];
        s[0] = "doNumberAndBigInt";
        if ((state & 0b100000000000000) != 0 /* is-active doNumberAndBigInt(double, BigInt) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b10000000) != 0 /* is-excluded doNumberAndBigInt(double, BigInt) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[15] = s;
        s = new Object[3];
        s[0] = "doJavaNumber";
        if ((state & 0b1000000000000000) != 0 /* is-active doJavaNumber(Object, Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b100000000) != 0 /* is-excluded doJavaNumber(Object, Object) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[16] = s;
        s = new Object[3];
        s[0] = "doGeneric";
        if ((state & 0x10000L) != 0 /* is-active doGeneric(Object, Object, JSToStringOrNumberNode, JSToPrimitiveNode, JSToStringOrNumberNode, JSToPrimitiveNode, JSLessThanNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            GenericData s17_ = this.generic_cache;
            if (s17_ != null) {
                cached.add(Arrays.asList(s17_.toStringOrNumber1_, s17_.toPrimitive1_, s17_.toStringOrNumber2_, s17_.toPrimitive2_, s17_.lessThanNode_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[17] = s;
        return Provider.create(data);
    }

    public static JSLessThanNode create(JavaScriptNode left, JavaScriptNode right) {
        return new JSLessThanNodeGen(left, right);
    }

    @GeneratedBy(JSLessThanNode.class)
    private static final class GenericData extends Node {

        @Child JSToStringOrNumberNode toStringOrNumber1_;
        @Child JSToPrimitiveNode toPrimitive1_;
        @Child JSToStringOrNumberNode toStringOrNumber2_;
        @Child JSToPrimitiveNode toPrimitive2_;
        @Child JSLessThanNode lessThanNode_;

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
