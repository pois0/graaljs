// CheckStyle: start generated
package com.oracle.truffle.js.nodes.binary;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.api.profiles.ConditionProfile;
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

@GeneratedBy(JSBitwiseAndConstantNode.class)
public final class JSBitwiseAndConstantNodeGen extends JSBitwiseAndConstantNode implements Provider {

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @Child private JSToInt32Node double_leftInt32_;
    @Child private GenericData generic_cache;
    @Child private JSToNumericNode genericBigIntCase_toNumeric_;
    @CompilationFinal private ConditionProfile genericBigIntCase_profileIsBigInt_;

    private JSBitwiseAndConstantNodeGen(JavaScriptNode left, Object rightValue) {
        super(left, rightValue);
    }

    @Override
    public Object executeObject(Object operandNodeValue) {
        int state = state_;
        if ((state & 0b1) != 0 /* is-active doInteger(int) */ && operandNodeValue instanceof Integer) {
            int operandNodeValue_ = (int) operandNodeValue;
            assert (isInt);
            return doInteger(operandNodeValue_);
        }
        if ((state & 0b10) != 0 /* is-active doSafeInteger(SafeInteger) */ && operandNodeValue instanceof SafeInteger) {
            SafeInteger operandNodeValue_ = (SafeInteger) operandNodeValue;
            assert (isInt);
            return doSafeInteger(operandNodeValue_);
        }
        if ((state & 0b100) != 0 /* is-active doDouble(double, JSToInt32Node) */ && JSTypesGen.isImplicitDouble((state & 0b1111000000000) >>> 9 /* extract-implicit-active 0:double */, operandNodeValue)) {
            double operandNodeValue_ = JSTypesGen.asImplicitDouble((state & 0b1111000000000) >>> 9 /* extract-implicit-active 0:double */, operandNodeValue);
            assert (isInt);
            return doDouble(operandNodeValue_, this.double_leftInt32_);
        }
        if ((state & 0b1000000) != 0 /* is-active doBigInt(BigInt) */ && operandNodeValue instanceof BigInt) {
            BigInt operandNodeValue_ = (BigInt) operandNodeValue;
            assert (!(isInt));
            return doBigInt(operandNodeValue_);
        }
        if ((state & 0b110000000) != 0 /* is-active doGeneric(Object, JSToNumericNode, ConditionProfile, JavaScriptNode) || doGenericBigIntCase(Object, JSToNumericNode, ConditionProfile) */) {
            if ((state & 0b10000000) != 0 /* is-active doGeneric(Object, JSToNumericNode, ConditionProfile, JavaScriptNode) */) {
                GenericData s8_ = this.generic_cache;
                if (s8_ != null) {
                    assert (isInt);
                    return doGeneric(operandNodeValue, s8_.toNumeric_, s8_.profileIsBigInt_, s8_.innerAndNode_);
                }
            }
            if ((state & 0b100000000) != 0 /* is-active doGenericBigIntCase(Object, JSToNumericNode, ConditionProfile) */) {
                assert (!(isInt()));
                return doGenericBigIntCase(operandNodeValue, this.genericBigIntCase_toNumeric_, this.genericBigIntCase_profileIsBigInt_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue);
    }

    @Override
    public Object execute(VirtualFrame frameValue, Object operandNodeValue) {
        int state = state_;
        if ((state & 0b1) != 0 /* is-active doInteger(int) */ && operandNodeValue instanceof Integer) {
            int operandNodeValue_ = (int) operandNodeValue;
            assert (isInt);
            return doInteger(operandNodeValue_);
        }
        if ((state & 0b10) != 0 /* is-active doSafeInteger(SafeInteger) */ && operandNodeValue instanceof SafeInteger) {
            SafeInteger operandNodeValue_ = (SafeInteger) operandNodeValue;
            assert (isInt);
            return doSafeInteger(operandNodeValue_);
        }
        if ((state & 0b100) != 0 /* is-active doDouble(double, JSToInt32Node) */ && JSTypesGen.isImplicitDouble((state & 0b1111000000000) >>> 9 /* extract-implicit-active 0:double */, operandNodeValue)) {
            double operandNodeValue_ = JSTypesGen.asImplicitDouble((state & 0b1111000000000) >>> 9 /* extract-implicit-active 0:double */, operandNodeValue);
            assert (isInt);
            return doDouble(operandNodeValue_, this.double_leftInt32_);
        }
        if ((state & 0b1000000) != 0 /* is-active doBigInt(BigInt) */ && operandNodeValue instanceof BigInt) {
            BigInt operandNodeValue_ = (BigInt) operandNodeValue;
            assert (!(isInt));
            return doBigInt(operandNodeValue_);
        }
        if ((state & 0b110000000) != 0 /* is-active doGeneric(Object, JSToNumericNode, ConditionProfile, JavaScriptNode) || doGenericBigIntCase(Object, JSToNumericNode, ConditionProfile) */) {
            if ((state & 0b10000000) != 0 /* is-active doGeneric(Object, JSToNumericNode, ConditionProfile, JavaScriptNode) */) {
                GenericData s8_ = this.generic_cache;
                if (s8_ != null) {
                    assert (isInt);
                    return doGeneric(operandNodeValue, s8_.toNumeric_, s8_.profileIsBigInt_, s8_.innerAndNode_);
                }
            }
            if ((state & 0b100000000) != 0 /* is-active doGenericBigIntCase(Object, JSToNumericNode, ConditionProfile) */) {
                assert (!(isInt()));
                return doGenericBigIntCase(operandNodeValue, this.genericBigIntCase_toNumeric_, this.genericBigIntCase_profileIsBigInt_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue);
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        int state = state_;
        if ((state & 0b111000110) == 0 /* only-active doInteger(int) */ && (state & 0b111000111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doDouble(double, JSToInt32Node) && doBigInt(BigInt) && doGeneric(Object, JSToNumericNode, ConditionProfile, JavaScriptNode) && doGenericBigIntCase(Object, JSToNumericNode, ConditionProfile) */) {
            return execute_int0(frameValue, state);
        } else if ((state & 0b111000011) == 0 /* only-active doDouble(double, JSToInt32Node) */ && (state & 0b111000111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doDouble(double, JSToInt32Node) && doBigInt(BigInt) && doGeneric(Object, JSToNumericNode, ConditionProfile, JavaScriptNode) && doGenericBigIntCase(Object, JSToNumericNode, ConditionProfile) */) {
            return execute_double1(frameValue, state);
        } else {
            return execute_generic2(frameValue, state);
        }
    }

    private Object execute_int0(VirtualFrame frameValue, int state) {
        int operandNodeValue_;
        try {
            operandNodeValue_ = super.operandNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(ex.getResult());
        }
        assert (state & 0b1) != 0 /* is-active doInteger(int) */;
        assert (isInt);
        return doInteger(operandNodeValue_);
    }

    private Object execute_double1(VirtualFrame frameValue, int state) {
        int operandNodeValue_int = 0;
        long operandNodeValue_long = 0L;
        double operandNodeValue_;
        try {
            if ((state & 0b1110000000000) == 0 /* only-active 0:double */ && (state & 0b111111111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doDouble(double, JSToInt32Node) && doIntegerThrows(int) && doDoubleThrows(double) && doBigIntThrows(BigInt) && doBigInt(BigInt) && doGeneric(Object, JSToNumericNode, ConditionProfile, JavaScriptNode) && doGenericBigIntCase(Object, JSToNumericNode, ConditionProfile) */) {
                operandNodeValue_long = super.operandNode.executeLong(frameValue);
                operandNodeValue_ = JSTypes.longToDouble(operandNodeValue_long);
            } else if ((state & 0b1101000000000) == 0 /* only-active 0:double */ && (state & 0b111111111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doDouble(double, JSToInt32Node) && doIntegerThrows(int) && doDoubleThrows(double) && doBigIntThrows(BigInt) && doBigInt(BigInt) && doGeneric(Object, JSToNumericNode, ConditionProfile, JavaScriptNode) && doGenericBigIntCase(Object, JSToNumericNode, ConditionProfile) */) {
                operandNodeValue_int = super.operandNode.executeInt(frameValue);
                operandNodeValue_ = JSTypes.intToDouble(operandNodeValue_int);
            } else if ((state & 0b1011000000000) == 0 /* only-active 0:double */ && (state & 0b111111111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doDouble(double, JSToInt32Node) && doIntegerThrows(int) && doDoubleThrows(double) && doBigIntThrows(BigInt) && doBigInt(BigInt) && doGeneric(Object, JSToNumericNode, ConditionProfile, JavaScriptNode) && doGenericBigIntCase(Object, JSToNumericNode, ConditionProfile) */) {
                operandNodeValue_ = super.operandNode.executeDouble(frameValue);
            } else {
                Object operandNodeValue__ = super.operandNode.execute(frameValue);
                operandNodeValue_ = JSTypesGen.expectImplicitDouble((state & 0b1111000000000) >>> 9 /* extract-implicit-active 0:double */, operandNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(ex.getResult());
        }
        assert (state & 0b100) != 0 /* is-active doDouble(double, JSToInt32Node) */;
        assert (isInt);
        return doDouble(operandNodeValue_, this.double_leftInt32_);
    }

    private Object execute_generic2(VirtualFrame frameValue, int state) {
        Object operandNodeValue_ = super.operandNode.execute(frameValue);
        if ((state & 0b1) != 0 /* is-active doInteger(int) */ && operandNodeValue_ instanceof Integer) {
            int operandNodeValue__ = (int) operandNodeValue_;
            assert (isInt);
            return doInteger(operandNodeValue__);
        }
        if ((state & 0b10) != 0 /* is-active doSafeInteger(SafeInteger) */ && operandNodeValue_ instanceof SafeInteger) {
            SafeInteger operandNodeValue__ = (SafeInteger) operandNodeValue_;
            assert (isInt);
            return doSafeInteger(operandNodeValue__);
        }
        if ((state & 0b100) != 0 /* is-active doDouble(double, JSToInt32Node) */ && JSTypesGen.isImplicitDouble((state & 0b1111000000000) >>> 9 /* extract-implicit-active 0:double */, operandNodeValue_)) {
            double operandNodeValue__ = JSTypesGen.asImplicitDouble((state & 0b1111000000000) >>> 9 /* extract-implicit-active 0:double */, operandNodeValue_);
            assert (isInt);
            return doDouble(operandNodeValue__, this.double_leftInt32_);
        }
        if ((state & 0b1000000) != 0 /* is-active doBigInt(BigInt) */ && operandNodeValue_ instanceof BigInt) {
            BigInt operandNodeValue__ = (BigInt) operandNodeValue_;
            assert (!(isInt));
            return doBigInt(operandNodeValue__);
        }
        if ((state & 0b110000000) != 0 /* is-active doGeneric(Object, JSToNumericNode, ConditionProfile, JavaScriptNode) || doGenericBigIntCase(Object, JSToNumericNode, ConditionProfile) */) {
            if ((state & 0b10000000) != 0 /* is-active doGeneric(Object, JSToNumericNode, ConditionProfile, JavaScriptNode) */) {
                GenericData s8_ = this.generic_cache;
                if (s8_ != null) {
                    assert (isInt);
                    return doGeneric(operandNodeValue_, s8_.toNumeric_, s8_.profileIsBigInt_, s8_.innerAndNode_);
                }
            }
            if ((state & 0b100000000) != 0 /* is-active doGenericBigIntCase(Object, JSToNumericNode, ConditionProfile) */) {
                assert (!(isInt()));
                return doGenericBigIntCase(operandNodeValue_, this.genericBigIntCase_toNumeric_, this.genericBigIntCase_profileIsBigInt_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue_);
    }

    @Override
    public int executeInt(VirtualFrame frameValue) throws UnexpectedResultException {
        int state = state_;
        if ((state & 0b10000000) != 0 /* is-active doGeneric(Object, JSToNumericNode, ConditionProfile, JavaScriptNode) */) {
            return JSTypesGen.expectInteger(execute(frameValue));
        }
        if ((state & 0b110) == 0 /* only-active doInteger(int) */ && (state & 0b111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doDouble(double, JSToInt32Node) */) {
            return executeInt_int3(frameValue, state);
        } else if ((state & 0b11) == 0 /* only-active doDouble(double, JSToInt32Node) */ && (state & 0b111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doDouble(double, JSToInt32Node) */) {
            return executeInt_double4(frameValue, state);
        } else {
            return executeInt_generic5(frameValue, state);
        }
    }

    private int executeInt_int3(VirtualFrame frameValue, int state) throws UnexpectedResultException {
        int operandNodeValue_;
        try {
            operandNodeValue_ = super.operandNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectInteger(executeAndSpecialize(ex.getResult()));
        }
        assert (state & 0b1) != 0 /* is-active doInteger(int) */;
        assert (isInt);
        return doInteger(operandNodeValue_);
    }

    private int executeInt_double4(VirtualFrame frameValue, int state) throws UnexpectedResultException {
        int operandNodeValue_int = 0;
        long operandNodeValue_long = 0L;
        double operandNodeValue_;
        try {
            if ((state & 0b1110000000000) == 0 /* only-active 0:double */ && (state & 0b111111111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doDouble(double, JSToInt32Node) && doIntegerThrows(int) && doDoubleThrows(double) && doBigIntThrows(BigInt) && doBigInt(BigInt) && doGeneric(Object, JSToNumericNode, ConditionProfile, JavaScriptNode) && doGenericBigIntCase(Object, JSToNumericNode, ConditionProfile) */) {
                operandNodeValue_long = super.operandNode.executeLong(frameValue);
                operandNodeValue_ = JSTypes.longToDouble(operandNodeValue_long);
            } else if ((state & 0b1101000000000) == 0 /* only-active 0:double */ && (state & 0b111111111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doDouble(double, JSToInt32Node) && doIntegerThrows(int) && doDoubleThrows(double) && doBigIntThrows(BigInt) && doBigInt(BigInt) && doGeneric(Object, JSToNumericNode, ConditionProfile, JavaScriptNode) && doGenericBigIntCase(Object, JSToNumericNode, ConditionProfile) */) {
                operandNodeValue_int = super.operandNode.executeInt(frameValue);
                operandNodeValue_ = JSTypes.intToDouble(operandNodeValue_int);
            } else if ((state & 0b1011000000000) == 0 /* only-active 0:double */ && (state & 0b111111111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doDouble(double, JSToInt32Node) && doIntegerThrows(int) && doDoubleThrows(double) && doBigIntThrows(BigInt) && doBigInt(BigInt) && doGeneric(Object, JSToNumericNode, ConditionProfile, JavaScriptNode) && doGenericBigIntCase(Object, JSToNumericNode, ConditionProfile) */) {
                operandNodeValue_ = super.operandNode.executeDouble(frameValue);
            } else {
                Object operandNodeValue__ = super.operandNode.execute(frameValue);
                operandNodeValue_ = JSTypesGen.expectImplicitDouble((state & 0b1111000000000) >>> 9 /* extract-implicit-active 0:double */, operandNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectInteger(executeAndSpecialize(ex.getResult()));
        }
        assert (state & 0b100) != 0 /* is-active doDouble(double, JSToInt32Node) */;
        assert (isInt);
        return doDouble(operandNodeValue_, this.double_leftInt32_);
    }

    private int executeInt_generic5(VirtualFrame frameValue, int state) throws UnexpectedResultException {
        Object operandNodeValue_ = super.operandNode.execute(frameValue);
        if ((state & 0b1) != 0 /* is-active doInteger(int) */ && operandNodeValue_ instanceof Integer) {
            int operandNodeValue__ = (int) operandNodeValue_;
            assert (isInt);
            return doInteger(operandNodeValue__);
        }
        if ((state & 0b10) != 0 /* is-active doSafeInteger(SafeInteger) */ && operandNodeValue_ instanceof SafeInteger) {
            SafeInteger operandNodeValue__ = (SafeInteger) operandNodeValue_;
            assert (isInt);
            return doSafeInteger(operandNodeValue__);
        }
        if ((state & 0b100) != 0 /* is-active doDouble(double, JSToInt32Node) */ && JSTypesGen.isImplicitDouble((state & 0b1111000000000) >>> 9 /* extract-implicit-active 0:double */, operandNodeValue_)) {
            double operandNodeValue__ = JSTypesGen.asImplicitDouble((state & 0b1111000000000) >>> 9 /* extract-implicit-active 0:double */, operandNodeValue_);
            assert (isInt);
            return doDouble(operandNodeValue__, this.double_leftInt32_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectInteger(executeAndSpecialize(operandNodeValue_));
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        int state = state_;
        try {
            if ((state & 0b111111000) == 0 /* only-active doInteger(int) && doSafeInteger(SafeInteger) && doDouble(double, JSToInt32Node) */ && (state & 0b111111111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doDouble(double, JSToInt32Node) && doIntegerThrows(int) && doDoubleThrows(double) && doBigIntThrows(BigInt) && doBigInt(BigInt) && doGeneric(Object, JSToNumericNode, ConditionProfile, JavaScriptNode) && doGenericBigIntCase(Object, JSToNumericNode, ConditionProfile) */) {
                executeInt(frameValue);
                return;
            } else if ((state & 0b111000111) != 0 /* is-active doInteger(int) || doSafeInteger(SafeInteger) || doDouble(double, JSToInt32Node) || doBigInt(BigInt) || doGeneric(Object, JSToNumericNode, ConditionProfile, JavaScriptNode) || doGenericBigIntCase(Object, JSToNumericNode, ConditionProfile) */) {
                execute(frameValue);
                return;
            }
        } catch (UnexpectedResultException ex) {
            return;
        }
        if ((state & 0b110000) == 0 /* only-active doIntegerThrows(int) */ && (state & 0b111000) != 0  /* is-not doIntegerThrows(int) && doDoubleThrows(double) && doBigIntThrows(BigInt) */) {
            executeVoid_int6(frameValue, state);
            return;
        } else if ((state & 0b101000) == 0 /* only-active doDoubleThrows(double) */ && (state & 0b111000) != 0  /* is-not doIntegerThrows(int) && doDoubleThrows(double) && doBigIntThrows(BigInt) */) {
            executeVoid_double7(frameValue, state);
            return;
        } else {
            executeVoid_generic8(frameValue, state);
            return;
        }
    }

    private void executeVoid_int6(VirtualFrame frameValue, int state) {
        int operandNodeValue_;
        try {
            operandNodeValue_ = super.operandNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            executeAndSpecialize(ex.getResult());
            return;
        }
        assert (state & 0b1000) != 0 /* is-active doIntegerThrows(int) */;
        assert (!(isInt));
        doIntegerThrows(operandNodeValue_);
        return;
    }

    private void executeVoid_double7(VirtualFrame frameValue, int state) {
        int operandNodeValue_int = 0;
        long operandNodeValue_long = 0L;
        double operandNodeValue_;
        try {
            if ((state & 0b1110000000000) == 0 /* only-active 0:double */ && (state & 0b111111111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doDouble(double, JSToInt32Node) && doIntegerThrows(int) && doDoubleThrows(double) && doBigIntThrows(BigInt) && doBigInt(BigInt) && doGeneric(Object, JSToNumericNode, ConditionProfile, JavaScriptNode) && doGenericBigIntCase(Object, JSToNumericNode, ConditionProfile) */) {
                operandNodeValue_long = super.operandNode.executeLong(frameValue);
                operandNodeValue_ = JSTypes.longToDouble(operandNodeValue_long);
            } else if ((state & 0b1101000000000) == 0 /* only-active 0:double */ && (state & 0b111111111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doDouble(double, JSToInt32Node) && doIntegerThrows(int) && doDoubleThrows(double) && doBigIntThrows(BigInt) && doBigInt(BigInt) && doGeneric(Object, JSToNumericNode, ConditionProfile, JavaScriptNode) && doGenericBigIntCase(Object, JSToNumericNode, ConditionProfile) */) {
                operandNodeValue_int = super.operandNode.executeInt(frameValue);
                operandNodeValue_ = JSTypes.intToDouble(operandNodeValue_int);
            } else if ((state & 0b1011000000000) == 0 /* only-active 0:double */ && (state & 0b111111111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doDouble(double, JSToInt32Node) && doIntegerThrows(int) && doDoubleThrows(double) && doBigIntThrows(BigInt) && doBigInt(BigInt) && doGeneric(Object, JSToNumericNode, ConditionProfile, JavaScriptNode) && doGenericBigIntCase(Object, JSToNumericNode, ConditionProfile) */) {
                operandNodeValue_ = super.operandNode.executeDouble(frameValue);
            } else {
                Object operandNodeValue__ = super.operandNode.execute(frameValue);
                operandNodeValue_ = JSTypesGen.expectImplicitDouble((state & 0b1111000000000) >>> 9 /* extract-implicit-active 0:double */, operandNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            executeAndSpecialize(ex.getResult());
            return;
        }
        assert (state & 0b10000) != 0 /* is-active doDoubleThrows(double) */;
        assert (!(isInt));
        doDoubleThrows(operandNodeValue_);
        return;
    }

    private void executeVoid_generic8(VirtualFrame frameValue, int state) {
        Object operandNodeValue_ = super.operandNode.execute(frameValue);
        if ((state & 0b1000) != 0 /* is-active doIntegerThrows(int) */ && operandNodeValue_ instanceof Integer) {
            int operandNodeValue__ = (int) operandNodeValue_;
            assert (!(isInt));
            doIntegerThrows(operandNodeValue__);
            return;
        }
        if ((state & 0b10000) != 0 /* is-active doDoubleThrows(double) */ && JSTypesGen.isImplicitDouble((state & 0b1111000000000) >>> 9 /* extract-implicit-active 0:double */, operandNodeValue_)) {
            double operandNodeValue__ = JSTypesGen.asImplicitDouble((state & 0b1111000000000) >>> 9 /* extract-implicit-active 0:double */, operandNodeValue_);
            assert (!(isInt));
            doDoubleThrows(operandNodeValue__);
            return;
        }
        if ((state & 0b100000) != 0 /* is-active doBigIntThrows(BigInt) */ && operandNodeValue_ instanceof BigInt) {
            BigInt operandNodeValue__ = (BigInt) operandNodeValue_;
            assert (isInt);
            doBigIntThrows(operandNodeValue__);
            return;
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        executeAndSpecialize(operandNodeValue_);
        return;
    }

    private Object executeAndSpecialize(Object operandNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        int exclude = exclude_;
        try {
            if (((exclude & 0b1)) == 0 /* is-not-excluded doInteger(int) */ && operandNodeValue instanceof Integer) {
                int operandNodeValue_ = (int) operandNodeValue;
                if ((isInt)) {
                    this.state_ = state = state | 0b1 /* add-active doInteger(int) */;
                    lock.unlock();
                    hasLock = false;
                    return doInteger(operandNodeValue_);
                }
            }
            if (((exclude & 0b10)) == 0 /* is-not-excluded doSafeInteger(SafeInteger) */ && operandNodeValue instanceof SafeInteger) {
                SafeInteger operandNodeValue_ = (SafeInteger) operandNodeValue;
                if ((isInt)) {
                    this.state_ = state = state | 0b10 /* add-active doSafeInteger(SafeInteger) */;
                    lock.unlock();
                    hasLock = false;
                    return doSafeInteger(operandNodeValue_);
                }
            }
            if (((exclude & 0b100)) == 0 /* is-not-excluded doDouble(double, JSToInt32Node) */) {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(operandNodeValue)) != 0) {
                    double operandNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast0, operandNodeValue);
                    if ((isInt)) {
                        this.double_leftInt32_ = super.insert((JSToInt32Node.create()));
                        state = (state | (doubleCast0 << 9) /* set-implicit-active 0:double */);
                        this.state_ = state = state | 0b100 /* add-active doDouble(double, JSToInt32Node) */;
                        lock.unlock();
                        hasLock = false;
                        return doDouble(operandNodeValue_, this.double_leftInt32_);
                    }
                }
            }
            if (((exclude & 0b1000)) == 0 /* is-not-excluded doIntegerThrows(int) */ && operandNodeValue instanceof Integer) {
                int operandNodeValue_ = (int) operandNodeValue;
                if ((!(isInt))) {
                    this.state_ = state = state | 0b1000 /* add-active doIntegerThrows(int) */;
                    lock.unlock();
                    hasLock = false;
                    doIntegerThrows(operandNodeValue_);
                    return null;
                }
            }
            if (((exclude & 0b10000)) == 0 /* is-not-excluded doDoubleThrows(double) */) {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(operandNodeValue)) != 0) {
                    double operandNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast0, operandNodeValue);
                    if ((!(isInt))) {
                        state = (state | (doubleCast0 << 9) /* set-implicit-active 0:double */);
                        this.state_ = state = state | 0b10000 /* add-active doDoubleThrows(double) */;
                        lock.unlock();
                        hasLock = false;
                        doDoubleThrows(operandNodeValue_);
                        return null;
                    }
                }
            }
            if (operandNodeValue instanceof BigInt) {
                BigInt operandNodeValue_ = (BigInt) operandNodeValue;
                if (((exclude & 0b100000)) == 0 /* is-not-excluded doBigIntThrows(BigInt) */) {
                    if ((isInt)) {
                        this.state_ = state = state | 0b100000 /* add-active doBigIntThrows(BigInt) */;
                        lock.unlock();
                        hasLock = false;
                        doBigIntThrows(operandNodeValue_);
                        return null;
                    }
                }
                if (((exclude & 0b1000000)) == 0 /* is-not-excluded doBigInt(BigInt) */) {
                    if ((!(isInt))) {
                        this.state_ = state = state | 0b1000000 /* add-active doBigInt(BigInt) */;
                        lock.unlock();
                        hasLock = false;
                        return doBigInt(operandNodeValue_);
                    }
                }
            }
            if ((isInt)) {
                GenericData s8_ = super.insert(new GenericData());
                s8_.toNumeric_ = s8_.insertAccessor((JSToNumericNode.create()));
                s8_.profileIsBigInt_ = (ConditionProfile.createBinaryProfile());
                s8_.innerAndNode_ = s8_.insertAccessor((makeCopy()));
                this.generic_cache = s8_;
                this.exclude_ = exclude = exclude | 0b100111 /* add-excluded doInteger(int), doSafeInteger(SafeInteger), doDouble(double, JSToInt32Node), doBigIntThrows(BigInt) */;
                state = state & 0xffffffd8 /* remove-active doInteger(int), doSafeInteger(SafeInteger), doDouble(double, JSToInt32Node), doBigIntThrows(BigInt) */;
                this.state_ = state = state | 0b10000000 /* add-active doGeneric(Object, JSToNumericNode, ConditionProfile, JavaScriptNode) */;
                lock.unlock();
                hasLock = false;
                return doGeneric(operandNodeValue, s8_.toNumeric_, s8_.profileIsBigInt_, s8_.innerAndNode_);
            }
            if ((!(isInt()))) {
                this.genericBigIntCase_toNumeric_ = super.insert((JSToNumericNode.create()));
                this.genericBigIntCase_profileIsBigInt_ = (ConditionProfile.createBinaryProfile());
                this.exclude_ = exclude = exclude | 0b1011000 /* add-excluded doIntegerThrows(int), doDoubleThrows(double), doBigInt(BigInt) */;
                state = state & 0xffffffa7 /* remove-active doIntegerThrows(int), doDoubleThrows(double), doBigInt(BigInt) */;
                this.state_ = state = state | 0b100000000 /* add-active doGenericBigIntCase(Object, JSToNumericNode, ConditionProfile) */;
                lock.unlock();
                hasLock = false;
                return doGenericBigIntCase(operandNodeValue, this.genericBigIntCase_toNumeric_, this.genericBigIntCase_profileIsBigInt_);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {super.operandNode}, operandNodeValue);
        } finally {
            if (hasLock) {
                lock.unlock();
            }
        }
    }

    @Override
    public NodeCost getCost() {
        int state = state_;
        if ((state & 0b111111111) == 0b0) {
            return NodeCost.UNINITIALIZED;
        } else if (((state & 0b111111111) & ((state & 0b111111111) - 1)) == 0 /* is-single-active  */) {
            return NodeCost.MONOMORPHIC;
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[10];
        Object[] s;
        data[0] = 0;
        int state = state_;
        int exclude = exclude_;
        s = new Object[3];
        s[0] = "doInteger";
        if ((state & 0b1) != 0 /* is-active doInteger(int) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b1) != 0 /* is-excluded doInteger(int) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doSafeInteger";
        if ((state & 0b10) != 0 /* is-active doSafeInteger(SafeInteger) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b10) != 0 /* is-excluded doSafeInteger(SafeInteger) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doDouble";
        if ((state & 0b100) != 0 /* is-active doDouble(double, JSToInt32Node) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.double_leftInt32_));
            s[2] = cached;
        } else if ((exclude & 0b100) != 0 /* is-excluded doDouble(double, JSToInt32Node) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doIntegerThrows";
        if ((state & 0b1000) != 0 /* is-active doIntegerThrows(int) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b1000) != 0 /* is-excluded doIntegerThrows(int) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doDoubleThrows";
        if ((state & 0b10000) != 0 /* is-active doDoubleThrows(double) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b10000) != 0 /* is-excluded doDoubleThrows(double) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "doBigIntThrows";
        if ((state & 0b100000) != 0 /* is-active doBigIntThrows(BigInt) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b100000) != 0 /* is-excluded doBigIntThrows(BigInt) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "doBigInt";
        if ((state & 0b1000000) != 0 /* is-active doBigInt(BigInt) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b1000000) != 0 /* is-excluded doBigInt(BigInt) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        s = new Object[3];
        s[0] = "doGeneric";
        if ((state & 0b10000000) != 0 /* is-active doGeneric(Object, JSToNumericNode, ConditionProfile, JavaScriptNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            GenericData s8_ = this.generic_cache;
            if (s8_ != null) {
                cached.add(Arrays.asList(s8_.toNumeric_, s8_.profileIsBigInt_, s8_.innerAndNode_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[8] = s;
        s = new Object[3];
        s[0] = "doGenericBigIntCase";
        if ((state & 0b100000000) != 0 /* is-active doGenericBigIntCase(Object, JSToNumericNode, ConditionProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.genericBigIntCase_toNumeric_, this.genericBigIntCase_profileIsBigInt_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[9] = s;
        return Provider.create(data);
    }

    public static JSBitwiseAndConstantNode create(JavaScriptNode left, Object rightValue) {
        return new JSBitwiseAndConstantNodeGen(left, rightValue);
    }

    @GeneratedBy(JSBitwiseAndConstantNode.class)
    private static final class GenericData extends Node {

        @Child JSToNumericNode toNumeric_;
        @CompilationFinal ConditionProfile profileIsBigInt_;
        @Child JavaScriptNode innerAndNode_;

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
