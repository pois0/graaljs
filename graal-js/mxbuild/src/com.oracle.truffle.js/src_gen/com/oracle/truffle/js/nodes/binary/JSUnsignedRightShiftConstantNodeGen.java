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
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.cast.JSToNumericNode;
import com.oracle.truffle.js.nodes.cast.JSToUInt32Node;
import com.oracle.truffle.js.runtime.BigInt;
import com.oracle.truffle.js.runtime.SafeInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSUnsignedRightShiftConstantNode.class)
public final class JSUnsignedRightShiftConstantNodeGen extends JSUnsignedRightShiftConstantNode implements Provider {

    @CompilationFinal private volatile int state_;
    @Child private JSToUInt32Node double_toUInt32Node_;
    @Child private JSToNumericNode generic_leftToNumeric_;
    @Child private JSUnsignedRightShiftConstantNode generic_innerShiftNode_;

    private JSUnsignedRightShiftConstantNodeGen(JavaScriptNode operand, int shiftValue, int rightValue) {
        super(operand, shiftValue, rightValue);
    }

    @Override
    public Object execute(VirtualFrame frameValue, Object operandNodeValue) {
        int state = state_;
        if ((state & 0b1) != 0 /* is-active doInteger(int) */ && operandNodeValue instanceof Integer) {
            int operandNodeValue_ = (int) operandNodeValue;
            return doInteger(operandNodeValue_);
        }
        if ((state & 0b10) != 0 /* is-active doSafeInteger(SafeInteger) */ && operandNodeValue instanceof SafeInteger) {
            SafeInteger operandNodeValue_ = (SafeInteger) operandNodeValue;
            return doSafeInteger(operandNodeValue_);
        }
        if ((state & 0b100) != 0 /* is-active doDouble(double, JSToUInt32Node) */ && JSTypesGen.isImplicitDouble((state & 0b111100000) >>> 5 /* extract-implicit-active 0:double */, operandNodeValue)) {
            double operandNodeValue_ = JSTypesGen.asImplicitDouble((state & 0b111100000) >>> 5 /* extract-implicit-active 0:double */, operandNodeValue);
            return doDouble(operandNodeValue_, this.double_toUInt32Node_);
        }
        if ((state & 0b1000) != 0 /* is-active doBigInt(BigInt) */ && operandNodeValue instanceof BigInt) {
            BigInt operandNodeValue_ = (BigInt) operandNodeValue;
            return doBigInt(operandNodeValue_);
        }
        if ((state & 0b10000) != 0 /* is-active doGeneric(Object, JSToNumericNode, JSUnsignedRightShiftConstantNode) */) {
            if ((!(JSUnsignedRightShiftConstantNode.isHandled(operandNodeValue)))) {
                return doGeneric(operandNodeValue, this.generic_leftToNumeric_, this.generic_innerShiftNode_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue);
    }

    @Override
    public int executeInt(Object operandNodeValue) {
        int state = state_;
        if ((state & 0b1) != 0 /* is-active doInteger(int) */ && operandNodeValue instanceof Integer) {
            int operandNodeValue_ = (int) operandNodeValue;
            return doInteger(operandNodeValue_);
        }
        if ((state & 0b10) != 0 /* is-active doSafeInteger(SafeInteger) */ && operandNodeValue instanceof SafeInteger) {
            SafeInteger operandNodeValue_ = (SafeInteger) operandNodeValue;
            return doSafeInteger(operandNodeValue_);
        }
        if ((state & 0b100) != 0 /* is-active doDouble(double, JSToUInt32Node) */ && JSTypesGen.isImplicitDouble((state & 0b111100000) >>> 5 /* extract-implicit-active 0:double */, operandNodeValue)) {
            double operandNodeValue_ = JSTypesGen.asImplicitDouble((state & 0b111100000) >>> 5 /* extract-implicit-active 0:double */, operandNodeValue);
            return doDouble(operandNodeValue_, this.double_toUInt32Node_);
        }
        if ((state & 0b1000) != 0 /* is-active doBigInt(BigInt) */ && operandNodeValue instanceof BigInt) {
            BigInt operandNodeValue_ = (BigInt) operandNodeValue;
            return doBigInt(operandNodeValue_);
        }
        if ((state & 0b10000) != 0 /* is-active doGeneric(Object, JSToNumericNode, JSUnsignedRightShiftConstantNode) */) {
            if ((!(JSUnsignedRightShiftConstantNode.isHandled(operandNodeValue)))) {
                return doGeneric(operandNodeValue, this.generic_leftToNumeric_, this.generic_innerShiftNode_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue);
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        int state = state_;
        if ((state & 0b11110) == 0 /* only-active doInteger(int) */ && (state & 0b11111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doDouble(double, JSToUInt32Node) && doBigInt(BigInt) && doGeneric(Object, JSToNumericNode, JSUnsignedRightShiftConstantNode) */) {
            return execute_int0(frameValue, state);
        } else if ((state & 0b11011) == 0 /* only-active doDouble(double, JSToUInt32Node) */ && (state & 0b11111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doDouble(double, JSToUInt32Node) && doBigInt(BigInt) && doGeneric(Object, JSToNumericNode, JSUnsignedRightShiftConstantNode) */) {
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
        return doInteger(operandNodeValue_);
    }

    private Object execute_double1(VirtualFrame frameValue, int state) {
        int operandNodeValue_int = 0;
        long operandNodeValue_long = 0L;
        double operandNodeValue_;
        try {
            if ((state & 0b111000000) == 0 /* only-active 0:double */ && (state & 0b11111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doDouble(double, JSToUInt32Node) && doBigInt(BigInt) && doGeneric(Object, JSToNumericNode, JSUnsignedRightShiftConstantNode) */) {
                operandNodeValue_long = super.operandNode.executeLong(frameValue);
                operandNodeValue_ = JSTypes.longToDouble(operandNodeValue_long);
            } else if ((state & 0b110100000) == 0 /* only-active 0:double */ && (state & 0b11111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doDouble(double, JSToUInt32Node) && doBigInt(BigInt) && doGeneric(Object, JSToNumericNode, JSUnsignedRightShiftConstantNode) */) {
                operandNodeValue_int = super.operandNode.executeInt(frameValue);
                operandNodeValue_ = JSTypes.intToDouble(operandNodeValue_int);
            } else if ((state & 0b101100000) == 0 /* only-active 0:double */ && (state & 0b11111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doDouble(double, JSToUInt32Node) && doBigInt(BigInt) && doGeneric(Object, JSToNumericNode, JSUnsignedRightShiftConstantNode) */) {
                operandNodeValue_ = super.operandNode.executeDouble(frameValue);
            } else {
                Object operandNodeValue__ = super.operandNode.execute(frameValue);
                operandNodeValue_ = JSTypesGen.expectImplicitDouble((state & 0b111100000) >>> 5 /* extract-implicit-active 0:double */, operandNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(ex.getResult());
        }
        assert (state & 0b100) != 0 /* is-active doDouble(double, JSToUInt32Node) */;
        return doDouble(operandNodeValue_, this.double_toUInt32Node_);
    }

    private Object execute_generic2(VirtualFrame frameValue, int state) {
        Object operandNodeValue_ = super.operandNode.execute(frameValue);
        if ((state & 0b1) != 0 /* is-active doInteger(int) */ && operandNodeValue_ instanceof Integer) {
            int operandNodeValue__ = (int) operandNodeValue_;
            return doInteger(operandNodeValue__);
        }
        if ((state & 0b10) != 0 /* is-active doSafeInteger(SafeInteger) */ && operandNodeValue_ instanceof SafeInteger) {
            SafeInteger operandNodeValue__ = (SafeInteger) operandNodeValue_;
            return doSafeInteger(operandNodeValue__);
        }
        if ((state & 0b100) != 0 /* is-active doDouble(double, JSToUInt32Node) */ && JSTypesGen.isImplicitDouble((state & 0b111100000) >>> 5 /* extract-implicit-active 0:double */, operandNodeValue_)) {
            double operandNodeValue__ = JSTypesGen.asImplicitDouble((state & 0b111100000) >>> 5 /* extract-implicit-active 0:double */, operandNodeValue_);
            return doDouble(operandNodeValue__, this.double_toUInt32Node_);
        }
        if ((state & 0b1000) != 0 /* is-active doBigInt(BigInt) */ && operandNodeValue_ instanceof BigInt) {
            BigInt operandNodeValue__ = (BigInt) operandNodeValue_;
            return doBigInt(operandNodeValue__);
        }
        if ((state & 0b10000) != 0 /* is-active doGeneric(Object, JSToNumericNode, JSUnsignedRightShiftConstantNode) */) {
            if ((!(JSUnsignedRightShiftConstantNode.isHandled(operandNodeValue_)))) {
                return doGeneric(operandNodeValue_, this.generic_leftToNumeric_, this.generic_innerShiftNode_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue_);
    }

    @Override
    public int executeInt(VirtualFrame frameValue) {
        int state = state_;
        if ((state & 0b11110) == 0 /* only-active doInteger(int) */ && (state & 0b11111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doDouble(double, JSToUInt32Node) && doBigInt(BigInt) && doGeneric(Object, JSToNumericNode, JSUnsignedRightShiftConstantNode) */) {
            return executeInt_int3(frameValue, state);
        } else if ((state & 0b11011) == 0 /* only-active doDouble(double, JSToUInt32Node) */ && (state & 0b11111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doDouble(double, JSToUInt32Node) && doBigInt(BigInt) && doGeneric(Object, JSToNumericNode, JSUnsignedRightShiftConstantNode) */) {
            return executeInt_double4(frameValue, state);
        } else {
            return executeInt_generic5(frameValue, state);
        }
    }

    private int executeInt_int3(VirtualFrame frameValue, int state) {
        int operandNodeValue_;
        try {
            operandNodeValue_ = super.operandNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(ex.getResult());
        }
        assert (state & 0b1) != 0 /* is-active doInteger(int) */;
        return doInteger(operandNodeValue_);
    }

    private int executeInt_double4(VirtualFrame frameValue, int state) {
        int operandNodeValue_int = 0;
        long operandNodeValue_long = 0L;
        double operandNodeValue_;
        try {
            if ((state & 0b111000000) == 0 /* only-active 0:double */ && (state & 0b11111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doDouble(double, JSToUInt32Node) && doBigInt(BigInt) && doGeneric(Object, JSToNumericNode, JSUnsignedRightShiftConstantNode) */) {
                operandNodeValue_long = super.operandNode.executeLong(frameValue);
                operandNodeValue_ = JSTypes.longToDouble(operandNodeValue_long);
            } else if ((state & 0b110100000) == 0 /* only-active 0:double */ && (state & 0b11111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doDouble(double, JSToUInt32Node) && doBigInt(BigInt) && doGeneric(Object, JSToNumericNode, JSUnsignedRightShiftConstantNode) */) {
                operandNodeValue_int = super.operandNode.executeInt(frameValue);
                operandNodeValue_ = JSTypes.intToDouble(operandNodeValue_int);
            } else if ((state & 0b101100000) == 0 /* only-active 0:double */ && (state & 0b11111) != 0  /* is-not doInteger(int) && doSafeInteger(SafeInteger) && doDouble(double, JSToUInt32Node) && doBigInt(BigInt) && doGeneric(Object, JSToNumericNode, JSUnsignedRightShiftConstantNode) */) {
                operandNodeValue_ = super.operandNode.executeDouble(frameValue);
            } else {
                Object operandNodeValue__ = super.operandNode.execute(frameValue);
                operandNodeValue_ = JSTypesGen.expectImplicitDouble((state & 0b111100000) >>> 5 /* extract-implicit-active 0:double */, operandNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(ex.getResult());
        }
        assert (state & 0b100) != 0 /* is-active doDouble(double, JSToUInt32Node) */;
        return doDouble(operandNodeValue_, this.double_toUInt32Node_);
    }

    private int executeInt_generic5(VirtualFrame frameValue, int state) {
        Object operandNodeValue_ = super.operandNode.execute(frameValue);
        if ((state & 0b1) != 0 /* is-active doInteger(int) */ && operandNodeValue_ instanceof Integer) {
            int operandNodeValue__ = (int) operandNodeValue_;
            return doInteger(operandNodeValue__);
        }
        if ((state & 0b10) != 0 /* is-active doSafeInteger(SafeInteger) */ && operandNodeValue_ instanceof SafeInteger) {
            SafeInteger operandNodeValue__ = (SafeInteger) operandNodeValue_;
            return doSafeInteger(operandNodeValue__);
        }
        if ((state & 0b100) != 0 /* is-active doDouble(double, JSToUInt32Node) */ && JSTypesGen.isImplicitDouble((state & 0b111100000) >>> 5 /* extract-implicit-active 0:double */, operandNodeValue_)) {
            double operandNodeValue__ = JSTypesGen.asImplicitDouble((state & 0b111100000) >>> 5 /* extract-implicit-active 0:double */, operandNodeValue_);
            return doDouble(operandNodeValue__, this.double_toUInt32Node_);
        }
        if ((state & 0b1000) != 0 /* is-active doBigInt(BigInt) */ && operandNodeValue_ instanceof BigInt) {
            BigInt operandNodeValue__ = (BigInt) operandNodeValue_;
            return doBigInt(operandNodeValue__);
        }
        if ((state & 0b10000) != 0 /* is-active doGeneric(Object, JSToNumericNode, JSUnsignedRightShiftConstantNode) */) {
            if ((!(JSUnsignedRightShiftConstantNode.isHandled(operandNodeValue_)))) {
                return doGeneric(operandNodeValue_, this.generic_leftToNumeric_, this.generic_innerShiftNode_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue_);
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        executeInt(frameValue);
        return;
    }

    private int executeAndSpecialize(Object operandNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        try {
            if (operandNodeValue instanceof Integer) {
                int operandNodeValue_ = (int) operandNodeValue;
                this.state_ = state = state | 0b1 /* add-active doInteger(int) */;
                lock.unlock();
                hasLock = false;
                return doInteger(operandNodeValue_);
            }
            if (operandNodeValue instanceof SafeInteger) {
                SafeInteger operandNodeValue_ = (SafeInteger) operandNodeValue;
                this.state_ = state = state | 0b10 /* add-active doSafeInteger(SafeInteger) */;
                lock.unlock();
                hasLock = false;
                return doSafeInteger(operandNodeValue_);
            }
            {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(operandNodeValue)) != 0) {
                    double operandNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast0, operandNodeValue);
                    this.double_toUInt32Node_ = super.insert((JSToUInt32Node.create()));
                    state = (state | (doubleCast0 << 5) /* set-implicit-active 0:double */);
                    this.state_ = state = state | 0b100 /* add-active doDouble(double, JSToUInt32Node) */;
                    lock.unlock();
                    hasLock = false;
                    return doDouble(operandNodeValue_, this.double_toUInt32Node_);
                }
            }
            if (operandNodeValue instanceof BigInt) {
                BigInt operandNodeValue_ = (BigInt) operandNodeValue;
                this.state_ = state = state | 0b1000 /* add-active doBigInt(BigInt) */;
                lock.unlock();
                hasLock = false;
                return doBigInt(operandNodeValue_);
            }
            if ((!(JSUnsignedRightShiftConstantNode.isHandled(operandNodeValue)))) {
                this.generic_leftToNumeric_ = super.insert((JSToNumericNode.create()));
                this.generic_innerShiftNode_ = super.insert((createInner()));
                this.state_ = state = state | 0b10000 /* add-active doGeneric(Object, JSToNumericNode, JSUnsignedRightShiftConstantNode) */;
                lock.unlock();
                hasLock = false;
                return doGeneric(operandNodeValue, this.generic_leftToNumeric_, this.generic_innerShiftNode_);
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
        s = new Object[3];
        s[0] = "doInteger";
        if ((state & 0b1) != 0 /* is-active doInteger(int) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doSafeInteger";
        if ((state & 0b10) != 0 /* is-active doSafeInteger(SafeInteger) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doDouble";
        if ((state & 0b100) != 0 /* is-active doDouble(double, JSToUInt32Node) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.double_toUInt32Node_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doBigInt";
        if ((state & 0b1000) != 0 /* is-active doBigInt(BigInt) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doGeneric";
        if ((state & 0b10000) != 0 /* is-active doGeneric(Object, JSToNumericNode, JSUnsignedRightShiftConstantNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.generic_leftToNumeric_, this.generic_innerShiftNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        return Provider.create(data);
    }

    public static JSUnsignedRightShiftConstantNode create(JavaScriptNode operand, int shiftValue, int rightValue) {
        return new JSUnsignedRightShiftConstantNodeGen(operand, shiftValue, rightValue);
    }

}
