// CheckStyle: start generated
package com.oracle.truffle.js.nodes.unary;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.cast.JSToNumericNode;
import com.oracle.truffle.js.runtime.BigInt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSUnaryMinusNode.class)
public final class JSUnaryMinusNodeGen extends JSUnaryMinusNode implements Provider {

    @CompilationFinal private volatile int state_;
    @Child private JSToNumericNode generic_toNumericNode_;
    @Child private JSUnaryMinusNode generic_recursiveUnaryMinus_;

    private JSUnaryMinusNodeGen(JavaScriptNode operand) {
        super(operand);
    }

    @Override
    public Object execute(Object operandNodeValue) {
        int state = state_;
        if ((state & 0b1) != 0 /* is-active doInt(int) */ && operandNodeValue instanceof Integer) {
            int operandNodeValue_ = (int) operandNodeValue;
            if ((JSUnaryMinusNode.isInt(operandNodeValue_))) {
                return JSUnaryMinusNode.doInt(operandNodeValue_);
            }
        }
        if ((state & 0b10) != 0 /* is-active doDouble(double) */ && JSTypesGen.isImplicitDouble((state & 0b11110000) >>> 4 /* extract-implicit-active 0:double */, operandNodeValue)) {
            double operandNodeValue_ = JSTypesGen.asImplicitDouble((state & 0b11110000) >>> 4 /* extract-implicit-active 0:double */, operandNodeValue);
            return JSUnaryMinusNode.doDouble(operandNodeValue_);
        }
        if ((state & 0b100) != 0 /* is-active doBigInt(BigInt) */ && operandNodeValue instanceof BigInt) {
            BigInt operandNodeValue_ = (BigInt) operandNodeValue;
            return JSUnaryMinusNode.doBigInt(operandNodeValue_);
        }
        if ((state & 0b1000) != 0 /* is-active doGeneric(Object, JSToNumericNode, JSUnaryMinusNode) */) {
            return JSUnaryMinusNode.doGeneric(operandNodeValue, this.generic_toNumericNode_, this.generic_recursiveUnaryMinus_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue);
    }

    @Override
    public Object execute(VirtualFrame frameValue, Object operandNodeValue) {
        int state = state_;
        if ((state & 0b1) != 0 /* is-active doInt(int) */ && operandNodeValue instanceof Integer) {
            int operandNodeValue_ = (int) operandNodeValue;
            if ((JSUnaryMinusNode.isInt(operandNodeValue_))) {
                return JSUnaryMinusNode.doInt(operandNodeValue_);
            }
        }
        if ((state & 0b10) != 0 /* is-active doDouble(double) */ && JSTypesGen.isImplicitDouble((state & 0b11110000) >>> 4 /* extract-implicit-active 0:double */, operandNodeValue)) {
            double operandNodeValue_ = JSTypesGen.asImplicitDouble((state & 0b11110000) >>> 4 /* extract-implicit-active 0:double */, operandNodeValue);
            return JSUnaryMinusNode.doDouble(operandNodeValue_);
        }
        if ((state & 0b100) != 0 /* is-active doBigInt(BigInt) */ && operandNodeValue instanceof BigInt) {
            BigInt operandNodeValue_ = (BigInt) operandNodeValue;
            return JSUnaryMinusNode.doBigInt(operandNodeValue_);
        }
        if ((state & 0b1000) != 0 /* is-active doGeneric(Object, JSToNumericNode, JSUnaryMinusNode) */) {
            return JSUnaryMinusNode.doGeneric(operandNodeValue, this.generic_toNumericNode_, this.generic_recursiveUnaryMinus_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue);
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        int state = state_;
        if ((state & 0b1110) == 0 /* only-active doInt(int) */ && (state & 0b1111) != 0  /* is-not doInt(int) && doDouble(double) && doBigInt(BigInt) && doGeneric(Object, JSToNumericNode, JSUnaryMinusNode) */) {
            return execute_int0(frameValue, state);
        } else if ((state & 0b1101) == 0 /* only-active doDouble(double) */ && (state & 0b1111) != 0  /* is-not doInt(int) && doDouble(double) && doBigInt(BigInt) && doGeneric(Object, JSToNumericNode, JSUnaryMinusNode) */) {
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
        assert (state & 0b1) != 0 /* is-active doInt(int) */;
        if ((JSUnaryMinusNode.isInt(operandNodeValue_))) {
            return JSUnaryMinusNode.doInt(operandNodeValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue_);
    }

    private Object execute_double1(VirtualFrame frameValue, int state) {
        int operandNodeValue_int = 0;
        long operandNodeValue_long = 0L;
        double operandNodeValue_;
        try {
            if ((state & 0b11100000) == 0 /* only-active 0:double */ && (state & 0b1111) != 0  /* is-not doInt(int) && doDouble(double) && doBigInt(BigInt) && doGeneric(Object, JSToNumericNode, JSUnaryMinusNode) */) {
                operandNodeValue_long = super.operandNode.executeLong(frameValue);
                operandNodeValue_ = JSTypes.longToDouble(operandNodeValue_long);
            } else if ((state & 0b11010000) == 0 /* only-active 0:double */ && (state & 0b1111) != 0  /* is-not doInt(int) && doDouble(double) && doBigInt(BigInt) && doGeneric(Object, JSToNumericNode, JSUnaryMinusNode) */) {
                operandNodeValue_int = super.operandNode.executeInt(frameValue);
                operandNodeValue_ = JSTypes.intToDouble(operandNodeValue_int);
            } else if ((state & 0b10110000) == 0 /* only-active 0:double */ && (state & 0b1111) != 0  /* is-not doInt(int) && doDouble(double) && doBigInt(BigInt) && doGeneric(Object, JSToNumericNode, JSUnaryMinusNode) */) {
                operandNodeValue_ = super.operandNode.executeDouble(frameValue);
            } else {
                Object operandNodeValue__ = super.operandNode.execute(frameValue);
                operandNodeValue_ = JSTypesGen.expectImplicitDouble((state & 0b11110000) >>> 4 /* extract-implicit-active 0:double */, operandNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(ex.getResult());
        }
        assert (state & 0b10) != 0 /* is-active doDouble(double) */;
        return JSUnaryMinusNode.doDouble(operandNodeValue_);
    }

    private Object execute_generic2(VirtualFrame frameValue, int state) {
        Object operandNodeValue_ = super.operandNode.execute(frameValue);
        if ((state & 0b1) != 0 /* is-active doInt(int) */ && operandNodeValue_ instanceof Integer) {
            int operandNodeValue__ = (int) operandNodeValue_;
            if ((JSUnaryMinusNode.isInt(operandNodeValue__))) {
                return JSUnaryMinusNode.doInt(operandNodeValue__);
            }
        }
        if ((state & 0b10) != 0 /* is-active doDouble(double) */ && JSTypesGen.isImplicitDouble((state & 0b11110000) >>> 4 /* extract-implicit-active 0:double */, operandNodeValue_)) {
            double operandNodeValue__ = JSTypesGen.asImplicitDouble((state & 0b11110000) >>> 4 /* extract-implicit-active 0:double */, operandNodeValue_);
            return JSUnaryMinusNode.doDouble(operandNodeValue__);
        }
        if ((state & 0b100) != 0 /* is-active doBigInt(BigInt) */ && operandNodeValue_ instanceof BigInt) {
            BigInt operandNodeValue__ = (BigInt) operandNodeValue_;
            return JSUnaryMinusNode.doBigInt(operandNodeValue__);
        }
        if ((state & 0b1000) != 0 /* is-active doGeneric(Object, JSToNumericNode, JSUnaryMinusNode) */) {
            return JSUnaryMinusNode.doGeneric(operandNodeValue_, this.generic_toNumericNode_, this.generic_recursiveUnaryMinus_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue_);
    }

    @Override
    public double executeDouble(VirtualFrame frameValue) throws UnexpectedResultException {
        int state = state_;
        if ((state & 0b1000) != 0 /* is-active doGeneric(Object, JSToNumericNode, JSUnaryMinusNode) */) {
            return JSTypesGen.expectDouble(execute(frameValue));
        }
        int operandNodeValue_int = 0;
        long operandNodeValue_long = 0L;
        double operandNodeValue_;
        try {
            if ((state & 0b11100000) == 0 /* only-active 0:double */ && (state & 0b1111) != 0  /* is-not doInt(int) && doDouble(double) && doBigInt(BigInt) && doGeneric(Object, JSToNumericNode, JSUnaryMinusNode) */) {
                operandNodeValue_long = super.operandNode.executeLong(frameValue);
                operandNodeValue_ = JSTypes.longToDouble(operandNodeValue_long);
            } else if ((state & 0b11010000) == 0 /* only-active 0:double */ && (state & 0b1111) != 0  /* is-not doInt(int) && doDouble(double) && doBigInt(BigInt) && doGeneric(Object, JSToNumericNode, JSUnaryMinusNode) */) {
                operandNodeValue_int = super.operandNode.executeInt(frameValue);
                operandNodeValue_ = JSTypes.intToDouble(operandNodeValue_int);
            } else if ((state & 0b10110000) == 0 /* only-active 0:double */ && (state & 0b1111) != 0  /* is-not doInt(int) && doDouble(double) && doBigInt(BigInt) && doGeneric(Object, JSToNumericNode, JSUnaryMinusNode) */) {
                operandNodeValue_ = super.operandNode.executeDouble(frameValue);
            } else {
                Object operandNodeValue__ = super.operandNode.execute(frameValue);
                operandNodeValue_ = JSTypesGen.expectImplicitDouble((state & 0b11110000) >>> 4 /* extract-implicit-active 0:double */, operandNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectDouble(executeAndSpecialize(ex.getResult()));
        }
        if ((state & 0b10) != 0 /* is-active doDouble(double) */) {
            return JSUnaryMinusNode.doDouble(operandNodeValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectDouble(executeAndSpecialize(((state & 0b11100000) == 0 /* only-active 0:double */ && (state & 0b1111) != 0  /* is-not doInt(int) && doDouble(double) && doBigInt(BigInt) && doGeneric(Object, JSToNumericNode, JSUnaryMinusNode) */ ? (Object) operandNodeValue_long : ((state & 0b11010000) == 0 /* only-active 0:double */ && (state & 0b1111) != 0  /* is-not doInt(int) && doDouble(double) && doBigInt(BigInt) && doGeneric(Object, JSToNumericNode, JSUnaryMinusNode) */ ? (Object) operandNodeValue_int : (Object) operandNodeValue_))));
    }

    @Override
    public int executeInt(VirtualFrame frameValue) throws UnexpectedResultException {
        int state = state_;
        if ((state & 0b1000) != 0 /* is-active doGeneric(Object, JSToNumericNode, JSUnaryMinusNode) */) {
            return JSTypesGen.expectInteger(execute(frameValue));
        }
        int operandNodeValue_;
        try {
            operandNodeValue_ = super.operandNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectInteger(executeAndSpecialize(ex.getResult()));
        }
        if ((state & 0b1) != 0 /* is-active doInt(int) */) {
            if ((JSUnaryMinusNode.isInt(operandNodeValue_))) {
                return JSUnaryMinusNode.doInt(operandNodeValue_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectInteger(executeAndSpecialize(operandNodeValue_));
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        int state = state_;
        try {
            if ((state & 0b1110) == 0 /* only-active doInt(int) */ && (state & 0b1111) != 0  /* is-not doInt(int) && doDouble(double) && doBigInt(BigInt) && doGeneric(Object, JSToNumericNode, JSUnaryMinusNode) */) {
                executeInt(frameValue);
                return;
            } else if ((state & 0b1101) == 0 /* only-active doDouble(double) */ && (state & 0b1111) != 0  /* is-not doInt(int) && doDouble(double) && doBigInt(BigInt) && doGeneric(Object, JSToNumericNode, JSUnaryMinusNode) */) {
                executeDouble(frameValue);
                return;
            }
            execute(frameValue);
            return;
        } catch (UnexpectedResultException ex) {
            return;
        }
    }

    private Object executeAndSpecialize(Object operandNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        try {
            if (operandNodeValue instanceof Integer) {
                int operandNodeValue_ = (int) operandNodeValue;
                if ((JSUnaryMinusNode.isInt(operandNodeValue_))) {
                    this.state_ = state = state | 0b1 /* add-active doInt(int) */;
                    lock.unlock();
                    hasLock = false;
                    return JSUnaryMinusNode.doInt(operandNodeValue_);
                }
            }
            {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(operandNodeValue)) != 0) {
                    double operandNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast0, operandNodeValue);
                    state = (state | (doubleCast0 << 4) /* set-implicit-active 0:double */);
                    this.state_ = state = state | 0b10 /* add-active doDouble(double) */;
                    lock.unlock();
                    hasLock = false;
                    return JSUnaryMinusNode.doDouble(operandNodeValue_);
                }
            }
            if (operandNodeValue instanceof BigInt) {
                BigInt operandNodeValue_ = (BigInt) operandNodeValue;
                this.state_ = state = state | 0b100 /* add-active doBigInt(BigInt) */;
                lock.unlock();
                hasLock = false;
                return JSUnaryMinusNode.doBigInt(operandNodeValue_);
            }
            this.generic_toNumericNode_ = super.insert((JSToNumericNode.create()));
            this.generic_recursiveUnaryMinus_ = super.insert((JSUnaryMinusNode.create()));
            this.state_ = state = state | 0b1000 /* add-active doGeneric(Object, JSToNumericNode, JSUnaryMinusNode) */;
            lock.unlock();
            hasLock = false;
            return JSUnaryMinusNode.doGeneric(operandNodeValue, this.generic_toNumericNode_, this.generic_recursiveUnaryMinus_);
        } finally {
            if (hasLock) {
                lock.unlock();
            }
        }
    }

    @Override
    public NodeCost getCost() {
        int state = state_;
        if ((state & 0b1111) == 0b0) {
            return NodeCost.UNINITIALIZED;
        } else if (((state & 0b1111) & ((state & 0b1111) - 1)) == 0 /* is-single-active  */) {
            return NodeCost.MONOMORPHIC;
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[5];
        Object[] s;
        data[0] = 0;
        int state = state_;
        s = new Object[3];
        s[0] = "doInt";
        if ((state & 0b1) != 0 /* is-active doInt(int) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doDouble";
        if ((state & 0b10) != 0 /* is-active doDouble(double) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doBigInt";
        if ((state & 0b100) != 0 /* is-active doBigInt(BigInt) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doGeneric";
        if ((state & 0b1000) != 0 /* is-active doGeneric(Object, JSToNumericNode, JSUnaryMinusNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.generic_toNumericNode_, this.generic_recursiveUnaryMinus_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        return Provider.create(data);
    }

    public static JSUnaryMinusNode create(JavaScriptNode operand) {
        return new JSUnaryMinusNodeGen(operand);
    }

}
