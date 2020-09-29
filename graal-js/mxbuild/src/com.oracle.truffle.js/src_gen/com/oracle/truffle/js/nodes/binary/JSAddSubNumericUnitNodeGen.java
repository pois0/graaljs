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
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.runtime.BigInt;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSAddSubNumericUnitNode.class)
public final class JSAddSubNumericUnitNodeGen extends JSAddSubNumericUnitNode implements Provider {

    @CompilationFinal private int state_;
    @CompilationFinal private int exclude_;

    private JSAddSubNumericUnitNodeGen(JavaScriptNode operand, boolean isAddition, boolean truncate) {
        super(operand, isAddition, truncate);
    }

    @Override
    public Object execute(VirtualFrame frameValue, Object operandNodeValue) {
        int state = state_;
        if ((state & 0b1) != 0 /* is-active doInt(int) */ && operandNodeValue instanceof Integer) {
            int operandNodeValue_ = (int) operandNodeValue;
            try {
                return doInt(operandNodeValue_);
            } catch (ArithmeticException ex) {
                // implicit transferToInterpreterAndInvalidate()
                Lock lock = getLock();
                lock.lock();
                try {
                    this.exclude_ = this.exclude_ | 0b1 /* add-excluded doInt(int) */;
                    this.state_ = this.state_ & 0xfffffffe /* remove-active doInt(int) */;
                } finally {
                    lock.unlock();
                }
                return executeAndSpecialize(operandNodeValue_);
            }
        }
        if ((state & 0b10) != 0 /* is-active doDouble(double) */ && JSTypesGen.isImplicitDouble((state & 0b11110000) >>> 4 /* extract-implicit-active 0:double */, operandNodeValue)) {
            double operandNodeValue_ = JSTypesGen.asImplicitDouble((state & 0b11110000) >>> 4 /* extract-implicit-active 0:double */, operandNodeValue);
            return doDouble(operandNodeValue_);
        }
        if ((state & 0b100) != 0 /* is-active doBigInt(BigInt) */ && operandNodeValue instanceof BigInt) {
            BigInt operandNodeValue_ = (BigInt) operandNodeValue;
            return doBigInt(operandNodeValue_);
        }
        if ((state & 0b1000) != 0 /* is-active doJavaNumber(Object) */) {
            if ((JSGuards.isJavaNumber(operandNodeValue))) {
                return doJavaNumber(operandNodeValue);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue);
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        int state = state_;
        if ((state & 0b1110) == 0 /* only-active doInt(int) */ && (state & 0b1111) != 0  /* is-not doInt(int) && doDouble(double) && doBigInt(BigInt) && doJavaNumber(Object) */) {
            return execute_int0(frameValue, state);
        } else if ((state & 0b1101) == 0 /* only-active doDouble(double) */ && (state & 0b1111) != 0  /* is-not doInt(int) && doDouble(double) && doBigInt(BigInt) && doJavaNumber(Object) */) {
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
        try {
            return doInt(operandNodeValue_);
        } catch (ArithmeticException ex) {
            // implicit transferToInterpreterAndInvalidate()
            Lock lock = getLock();
            lock.lock();
            try {
                this.exclude_ = this.exclude_ | 0b1 /* add-excluded doInt(int) */;
                this.state_ = this.state_ & 0xfffffffe /* remove-active doInt(int) */;
            } finally {
                lock.unlock();
            }
            return executeAndSpecialize(operandNodeValue_);
        }
    }

    private Object execute_double1(VirtualFrame frameValue, int state) {
        int operandNodeValue_int = 0;
        long operandNodeValue_long = 0L;
        double operandNodeValue_;
        try {
            if ((state & 0b11100000) == 0 /* only-active 0:double */ && (state & 0b1111) != 0  /* is-not doInt(int) && doDouble(double) && doBigInt(BigInt) && doJavaNumber(Object) */) {
                operandNodeValue_long = super.operandNode.executeLong(frameValue);
                operandNodeValue_ = JSTypes.longToDouble(operandNodeValue_long);
            } else if ((state & 0b11010000) == 0 /* only-active 0:double */ && (state & 0b1111) != 0  /* is-not doInt(int) && doDouble(double) && doBigInt(BigInt) && doJavaNumber(Object) */) {
                operandNodeValue_int = super.operandNode.executeInt(frameValue);
                operandNodeValue_ = JSTypes.intToDouble(operandNodeValue_int);
            } else if ((state & 0b10110000) == 0 /* only-active 0:double */ && (state & 0b1111) != 0  /* is-not doInt(int) && doDouble(double) && doBigInt(BigInt) && doJavaNumber(Object) */) {
                operandNodeValue_ = super.operandNode.executeDouble(frameValue);
            } else {
                Object operandNodeValue__ = super.operandNode.execute(frameValue);
                operandNodeValue_ = JSTypesGen.expectImplicitDouble((state & 0b11110000) >>> 4 /* extract-implicit-active 0:double */, operandNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(ex.getResult());
        }
        assert (state & 0b10) != 0 /* is-active doDouble(double) */;
        return doDouble(operandNodeValue_);
    }

    private Object execute_generic2(VirtualFrame frameValue, int state) {
        Object operandNodeValue_ = super.operandNode.execute(frameValue);
        if ((state & 0b1) != 0 /* is-active doInt(int) */ && operandNodeValue_ instanceof Integer) {
            int operandNodeValue__ = (int) operandNodeValue_;
            try {
                return doInt(operandNodeValue__);
            } catch (ArithmeticException ex) {
                // implicit transferToInterpreterAndInvalidate()
                Lock lock = getLock();
                lock.lock();
                try {
                    this.exclude_ = this.exclude_ | 0b1 /* add-excluded doInt(int) */;
                    this.state_ = this.state_ & 0xfffffffe /* remove-active doInt(int) */;
                } finally {
                    lock.unlock();
                }
                return executeAndSpecialize(operandNodeValue__);
            }
        }
        if ((state & 0b10) != 0 /* is-active doDouble(double) */ && JSTypesGen.isImplicitDouble((state & 0b11110000) >>> 4 /* extract-implicit-active 0:double */, operandNodeValue_)) {
            double operandNodeValue__ = JSTypesGen.asImplicitDouble((state & 0b11110000) >>> 4 /* extract-implicit-active 0:double */, operandNodeValue_);
            return doDouble(operandNodeValue__);
        }
        if ((state & 0b100) != 0 /* is-active doBigInt(BigInt) */ && operandNodeValue_ instanceof BigInt) {
            BigInt operandNodeValue__ = (BigInt) operandNodeValue_;
            return doBigInt(operandNodeValue__);
        }
        if ((state & 0b1000) != 0 /* is-active doJavaNumber(Object) */) {
            if ((JSGuards.isJavaNumber(operandNodeValue_))) {
                return doJavaNumber(operandNodeValue_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue_);
    }

    @Override
    public double executeDouble(VirtualFrame frameValue) throws UnexpectedResultException {
        int state = state_;
        if ((state & 0b1000) == 0 /* only-active doDouble(double) */ && (state & 0b1010) != 0  /* is-not doDouble(double) && doJavaNumber(Object) */) {
            return executeDouble_double3(frameValue, state);
        } else {
            return executeDouble_generic4(frameValue, state);
        }
    }

    private double executeDouble_double3(VirtualFrame frameValue, int state) throws UnexpectedResultException {
        int operandNodeValue_int = 0;
        long operandNodeValue_long = 0L;
        double operandNodeValue_;
        try {
            if ((state & 0b11100000) == 0 /* only-active 0:double */ && (state & 0b1111) != 0  /* is-not doInt(int) && doDouble(double) && doBigInt(BigInt) && doJavaNumber(Object) */) {
                operandNodeValue_long = super.operandNode.executeLong(frameValue);
                operandNodeValue_ = JSTypes.longToDouble(operandNodeValue_long);
            } else if ((state & 0b11010000) == 0 /* only-active 0:double */ && (state & 0b1111) != 0  /* is-not doInt(int) && doDouble(double) && doBigInt(BigInt) && doJavaNumber(Object) */) {
                operandNodeValue_int = super.operandNode.executeInt(frameValue);
                operandNodeValue_ = JSTypes.intToDouble(operandNodeValue_int);
            } else if ((state & 0b10110000) == 0 /* only-active 0:double */ && (state & 0b1111) != 0  /* is-not doInt(int) && doDouble(double) && doBigInt(BigInt) && doJavaNumber(Object) */) {
                operandNodeValue_ = super.operandNode.executeDouble(frameValue);
            } else {
                Object operandNodeValue__ = super.operandNode.execute(frameValue);
                operandNodeValue_ = JSTypesGen.expectImplicitDouble((state & 0b11110000) >>> 4 /* extract-implicit-active 0:double */, operandNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectDouble(executeAndSpecialize(ex.getResult()));
        }
        assert (state & 0b10) != 0 /* is-active doDouble(double) */;
        return doDouble(operandNodeValue_);
    }

    private double executeDouble_generic4(VirtualFrame frameValue, int state) throws UnexpectedResultException {
        Object operandNodeValue_ = super.operandNode.execute(frameValue);
        if ((state & 0b10) != 0 /* is-active doDouble(double) */ && JSTypesGen.isImplicitDouble((state & 0b11110000) >>> 4 /* extract-implicit-active 0:double */, operandNodeValue_)) {
            double operandNodeValue__ = JSTypesGen.asImplicitDouble((state & 0b11110000) >>> 4 /* extract-implicit-active 0:double */, operandNodeValue_);
            return doDouble(operandNodeValue__);
        }
        if ((state & 0b1000) != 0 /* is-active doJavaNumber(Object) */) {
            if ((JSGuards.isJavaNumber(operandNodeValue_))) {
                return doJavaNumber(operandNodeValue_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectDouble(executeAndSpecialize(operandNodeValue_));
    }

    @Override
    public int executeInt(VirtualFrame frameValue) throws UnexpectedResultException {
        int state = state_;
        int operandNodeValue_;
        try {
            operandNodeValue_ = super.operandNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectInteger(executeAndSpecialize(ex.getResult()));
        }
        if ((state & 0b1) != 0 /* is-active doInt(int) */) {
            try {
                return doInt(operandNodeValue_);
            } catch (ArithmeticException ex) {
                // implicit transferToInterpreterAndInvalidate()
                Lock lock = getLock();
                lock.lock();
                try {
                    this.exclude_ = this.exclude_ | 0b1 /* add-excluded doInt(int) */;
                    this.state_ = this.state_ & 0xfffffffe /* remove-active doInt(int) */;
                } finally {
                    lock.unlock();
                }
                return JSTypesGen.expectInteger(executeAndSpecialize(operandNodeValue_));
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectInteger(executeAndSpecialize(operandNodeValue_));
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        int state = state_;
        try {
            if ((state & 0b1110) == 0 /* only-active doInt(int) */ && (state & 0b1111) != 0  /* is-not doInt(int) && doDouble(double) && doBigInt(BigInt) && doJavaNumber(Object) */) {
                executeInt(frameValue);
                return;
            } else if ((state & 0b101) == 0 /* only-active doDouble(double) && doJavaNumber(Object) */ && (state & 0b1111) != 0  /* is-not doInt(int) && doDouble(double) && doBigInt(BigInt) && doJavaNumber(Object) */) {
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
        int exclude = exclude_;
        try {
            if ((exclude) == 0 /* is-not-excluded doInt(int) */ && operandNodeValue instanceof Integer) {
                int operandNodeValue_ = (int) operandNodeValue;
                this.state_ = state = state | 0b1 /* add-active doInt(int) */;
                try {
                    lock.unlock();
                    hasLock = false;
                    return doInt(operandNodeValue_);
                } catch (ArithmeticException ex) {
                    // implicit transferToInterpreterAndInvalidate()
                    lock.lock();
                    try {
                        this.exclude_ = this.exclude_ | 0b1 /* add-excluded doInt(int) */;
                        this.state_ = this.state_ & 0xfffffffe /* remove-active doInt(int) */;
                    } finally {
                        lock.unlock();
                    }
                    return executeAndSpecialize(operandNodeValue_);
                }
            }
            {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(operandNodeValue)) != 0) {
                    double operandNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast0, operandNodeValue);
                    this.exclude_ = exclude = exclude | 0b1 /* add-excluded doInt(int) */;
                    state = state & 0xfffffffe /* remove-active doInt(int) */;
                    state = (state | (doubleCast0 << 4) /* set-implicit-active 0:double */);
                    this.state_ = state = state | 0b10 /* add-active doDouble(double) */;
                    lock.unlock();
                    hasLock = false;
                    return doDouble(operandNodeValue_);
                }
            }
            if (operandNodeValue instanceof BigInt) {
                BigInt operandNodeValue_ = (BigInt) operandNodeValue;
                this.state_ = state = state | 0b100 /* add-active doBigInt(BigInt) */;
                lock.unlock();
                hasLock = false;
                return doBigInt(operandNodeValue_);
            }
            if ((JSGuards.isJavaNumber(operandNodeValue))) {
                this.state_ = state = state | 0b1000 /* add-active doJavaNumber(Object) */;
                lock.unlock();
                hasLock = false;
                return doJavaNumber(operandNodeValue);
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
        int exclude = exclude_;
        s = new Object[3];
        s[0] = "doInt";
        if ((state & 0b1) != 0 /* is-active doInt(int) */) {
            s[1] = (byte)0b01 /* active */;
        } else if (exclude != 0 /* is-excluded doInt(int) */) {
            s[1] = (byte)0b10 /* excluded */;
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
        s[0] = "doJavaNumber";
        if ((state & 0b1000) != 0 /* is-active doJavaNumber(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        return Provider.create(data);
    }

    public static JSAddSubNumericUnitNode create(JavaScriptNode operand, boolean isAddition, boolean truncate) {
        return new JSAddSubNumericUnitNodeGen(operand, isAddition, truncate);
    }

}
