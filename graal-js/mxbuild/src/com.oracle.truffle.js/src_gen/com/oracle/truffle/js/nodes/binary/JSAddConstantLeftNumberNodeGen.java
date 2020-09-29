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
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.cast.JSToNumberNode;
import com.oracle.truffle.js.nodes.cast.JSToPrimitiveNode;
import com.oracle.truffle.js.runtime.SafeInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSAddConstantLeftNumberNode.class)
public final class JSAddConstantLeftNumberNodeGen extends JSAddConstantLeftNumberNode implements Provider {

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private String numberString_leftString_;
    @Child private JSConcatStringsNode numberString_createLazyString_;
    @Child private PrimitiveConversionData primitiveConversion_cache;

    private JSAddConstantLeftNumberNodeGen(Number leftValue, JavaScriptNode right, boolean truncate) {
        super(leftValue, right, truncate);
    }

    @Override
    public Object execute(Object operandNodeValue) {
        int state = state_;
        if ((state & 0b111) != 0 /* is-active doIntTruncate(int) || doInt(int) || doIntOverflow(int) */ && operandNodeValue instanceof Integer) {
            int operandNodeValue_ = (int) operandNodeValue;
            if ((state & 0b1) != 0 /* is-active doIntTruncate(int) */) {
                assert (truncate);
                assert (isInt);
                return doIntTruncate(operandNodeValue_);
            }
            if ((state & 0b10) != 0 /* is-active doInt(int) */) {
                assert (!(truncate));
                assert (isInt);
                try {
                    return doInt(operandNodeValue_);
                } catch (ArithmeticException ex) {
                    // implicit transferToInterpreterAndInvalidate()
                    Lock lock = getLock();
                    lock.lock();
                    try {
                        this.exclude_ = this.exclude_ | 0b1 /* add-excluded doInt(int) */;
                        this.state_ = this.state_ & 0xfffffffd /* remove-active doInt(int) */;
                    } finally {
                        lock.unlock();
                    }
                    return executeAndSpecialize(operandNodeValue_);
                }
            }
            if ((state & 0b100) != 0 /* is-active doIntOverflow(int) */) {
                assert (!(truncate));
                assert (isSafeLong);
                try {
                    return doIntOverflow(operandNodeValue_);
                } catch (ArithmeticException ex) {
                    // implicit transferToInterpreterAndInvalidate()
                    Lock lock = getLock();
                    lock.lock();
                    try {
                        this.exclude_ = this.exclude_ | 0b10 /* add-excluded doIntOverflow(int) */;
                        this.state_ = this.state_ & 0xfffffffb /* remove-active doIntOverflow(int) */;
                    } finally {
                        lock.unlock();
                    }
                    return executeAndSpecialize(operandNodeValue_);
                }
            }
        }
        if ((state & 0b1000) != 0 /* is-active doSafeInteger(SafeInteger) */ && operandNodeValue instanceof SafeInteger) {
            SafeInteger operandNodeValue_ = (SafeInteger) operandNodeValue;
            assert (isInt);
            try {
                return doSafeInteger(operandNodeValue_);
            } catch (ArithmeticException ex) {
                // implicit transferToInterpreterAndInvalidate()
                Lock lock = getLock();
                lock.lock();
                try {
                    this.exclude_ = this.exclude_ | 0b100 /* add-excluded doSafeInteger(SafeInteger) */;
                    this.state_ = this.state_ & 0xfffffff7 /* remove-active doSafeInteger(SafeInteger) */;
                } finally {
                    lock.unlock();
                }
                return executeAndSpecialize(operandNodeValue_);
            }
        }
        if ((state & 0b10000) != 0 /* is-active doDouble(double) */ && JSTypesGen.isImplicitDouble((state & 0b11110000000) >>> 7 /* extract-implicit-active 0:double */, operandNodeValue)) {
            double operandNodeValue_ = JSTypesGen.asImplicitDouble((state & 0b11110000000) >>> 7 /* extract-implicit-active 0:double */, operandNodeValue);
            return doDouble(operandNodeValue_);
        }
        if ((state & 0b100000) != 0 /* is-active doNumberString(CharSequence, String, JSConcatStringsNode) */ && JSTypesGen.isImplicitCharSequence((state & 0b111100000000000) >>> 11 /* extract-implicit-active 0:CharSequence */, operandNodeValue)) {
            CharSequence operandNodeValue_ = JSTypesGen.asImplicitCharSequence((state & 0b111100000000000) >>> 11 /* extract-implicit-active 0:CharSequence */, operandNodeValue);
            return doNumberString(operandNodeValue_, this.numberString_leftString_, this.numberString_createLazyString_);
        }
        if ((state & 0b1000000) != 0 /* is-active doPrimitiveConversion(Object, JSToPrimitiveNode, JSToNumberNode, String, JSConcatStringsNode, ConditionProfile) */) {
            PrimitiveConversionData s7_ = this.primitiveConversion_cache;
            if (s7_ != null) {
                return doPrimitiveConversion(operandNodeValue, s7_.toPrimitiveB_, s7_.toNumberB_, s7_.leftString_, s7_.createLazyString_, s7_.profileB_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue);
    }

    @Override
    public Object execute(VirtualFrame frameValue, Object operandNodeValue) {
        int state = state_;
        if ((state & 0b111) != 0 /* is-active doIntTruncate(int) || doInt(int) || doIntOverflow(int) */ && operandNodeValue instanceof Integer) {
            int operandNodeValue_ = (int) operandNodeValue;
            if ((state & 0b1) != 0 /* is-active doIntTruncate(int) */) {
                assert (truncate);
                assert (isInt);
                return doIntTruncate(operandNodeValue_);
            }
            if ((state & 0b10) != 0 /* is-active doInt(int) */) {
                assert (!(truncate));
                assert (isInt);
                try {
                    return doInt(operandNodeValue_);
                } catch (ArithmeticException ex) {
                    // implicit transferToInterpreterAndInvalidate()
                    Lock lock = getLock();
                    lock.lock();
                    try {
                        this.exclude_ = this.exclude_ | 0b1 /* add-excluded doInt(int) */;
                        this.state_ = this.state_ & 0xfffffffd /* remove-active doInt(int) */;
                    } finally {
                        lock.unlock();
                    }
                    return executeAndSpecialize(operandNodeValue_);
                }
            }
            if ((state & 0b100) != 0 /* is-active doIntOverflow(int) */) {
                assert (!(truncate));
                assert (isSafeLong);
                try {
                    return doIntOverflow(operandNodeValue_);
                } catch (ArithmeticException ex) {
                    // implicit transferToInterpreterAndInvalidate()
                    Lock lock = getLock();
                    lock.lock();
                    try {
                        this.exclude_ = this.exclude_ | 0b10 /* add-excluded doIntOverflow(int) */;
                        this.state_ = this.state_ & 0xfffffffb /* remove-active doIntOverflow(int) */;
                    } finally {
                        lock.unlock();
                    }
                    return executeAndSpecialize(operandNodeValue_);
                }
            }
        }
        if ((state & 0b1000) != 0 /* is-active doSafeInteger(SafeInteger) */ && operandNodeValue instanceof SafeInteger) {
            SafeInteger operandNodeValue_ = (SafeInteger) operandNodeValue;
            assert (isInt);
            try {
                return doSafeInteger(operandNodeValue_);
            } catch (ArithmeticException ex) {
                // implicit transferToInterpreterAndInvalidate()
                Lock lock = getLock();
                lock.lock();
                try {
                    this.exclude_ = this.exclude_ | 0b100 /* add-excluded doSafeInteger(SafeInteger) */;
                    this.state_ = this.state_ & 0xfffffff7 /* remove-active doSafeInteger(SafeInteger) */;
                } finally {
                    lock.unlock();
                }
                return executeAndSpecialize(operandNodeValue_);
            }
        }
        if ((state & 0b10000) != 0 /* is-active doDouble(double) */ && JSTypesGen.isImplicitDouble((state & 0b11110000000) >>> 7 /* extract-implicit-active 0:double */, operandNodeValue)) {
            double operandNodeValue_ = JSTypesGen.asImplicitDouble((state & 0b11110000000) >>> 7 /* extract-implicit-active 0:double */, operandNodeValue);
            return doDouble(operandNodeValue_);
        }
        if ((state & 0b100000) != 0 /* is-active doNumberString(CharSequence, String, JSConcatStringsNode) */ && JSTypesGen.isImplicitCharSequence((state & 0b111100000000000) >>> 11 /* extract-implicit-active 0:CharSequence */, operandNodeValue)) {
            CharSequence operandNodeValue_ = JSTypesGen.asImplicitCharSequence((state & 0b111100000000000) >>> 11 /* extract-implicit-active 0:CharSequence */, operandNodeValue);
            return doNumberString(operandNodeValue_, this.numberString_leftString_, this.numberString_createLazyString_);
        }
        if ((state & 0b1000000) != 0 /* is-active doPrimitiveConversion(Object, JSToPrimitiveNode, JSToNumberNode, String, JSConcatStringsNode, ConditionProfile) */) {
            PrimitiveConversionData s7_ = this.primitiveConversion_cache;
            if (s7_ != null) {
                return doPrimitiveConversion(operandNodeValue, s7_.toPrimitiveB_, s7_.toNumberB_, s7_.leftString_, s7_.createLazyString_, s7_.profileB_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue);
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        int state = state_;
        if ((state & 0b1111000) == 0 /* only-active doIntTruncate(int) && doInt(int) && doIntOverflow(int) */ && (state & 0b1111111) != 0  /* is-not doIntTruncate(int) && doInt(int) && doIntOverflow(int) && doSafeInteger(SafeInteger) && doDouble(double) && doNumberString(CharSequence, String, JSConcatStringsNode) && doPrimitiveConversion(Object, JSToPrimitiveNode, JSToNumberNode, String, JSConcatStringsNode, ConditionProfile) */) {
            return execute_int0(frameValue, state);
        } else if ((state & 0b1101111) == 0 /* only-active doDouble(double) */ && (state & 0b1111111) != 0  /* is-not doIntTruncate(int) && doInt(int) && doIntOverflow(int) && doSafeInteger(SafeInteger) && doDouble(double) && doNumberString(CharSequence, String, JSConcatStringsNode) && doPrimitiveConversion(Object, JSToPrimitiveNode, JSToNumberNode, String, JSConcatStringsNode, ConditionProfile) */) {
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
        if ((state & 0b1) != 0 /* is-active doIntTruncate(int) */) {
            assert (truncate);
            assert (isInt);
            return doIntTruncate(operandNodeValue_);
        }
        if ((state & 0b10) != 0 /* is-active doInt(int) */) {
            assert (!(truncate));
            assert (isInt);
            try {
                return doInt(operandNodeValue_);
            } catch (ArithmeticException ex) {
                // implicit transferToInterpreterAndInvalidate()
                Lock lock = getLock();
                lock.lock();
                try {
                    this.exclude_ = this.exclude_ | 0b1 /* add-excluded doInt(int) */;
                    this.state_ = this.state_ & 0xfffffffd /* remove-active doInt(int) */;
                } finally {
                    lock.unlock();
                }
                return executeAndSpecialize(operandNodeValue_);
            }
        }
        if ((state & 0b100) != 0 /* is-active doIntOverflow(int) */) {
            assert (!(truncate));
            assert (isSafeLong);
            try {
                return doIntOverflow(operandNodeValue_);
            } catch (ArithmeticException ex) {
                // implicit transferToInterpreterAndInvalidate()
                Lock lock = getLock();
                lock.lock();
                try {
                    this.exclude_ = this.exclude_ | 0b10 /* add-excluded doIntOverflow(int) */;
                    this.state_ = this.state_ & 0xfffffffb /* remove-active doIntOverflow(int) */;
                } finally {
                    lock.unlock();
                }
                return executeAndSpecialize(operandNodeValue_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue_);
    }

    private Object execute_double1(VirtualFrame frameValue, int state) {
        int operandNodeValue_int = 0;
        long operandNodeValue_long = 0L;
        double operandNodeValue_;
        try {
            if ((state & 0b11100000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not doIntTruncate(int) && doInt(int) && doIntOverflow(int) && doSafeInteger(SafeInteger) && doDouble(double) && doNumberString(CharSequence, String, JSConcatStringsNode) && doPrimitiveConversion(Object, JSToPrimitiveNode, JSToNumberNode, String, JSConcatStringsNode, ConditionProfile) */) {
                operandNodeValue_long = super.operandNode.executeLong(frameValue);
                operandNodeValue_ = JSTypes.longToDouble(operandNodeValue_long);
            } else if ((state & 0b11010000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not doIntTruncate(int) && doInt(int) && doIntOverflow(int) && doSafeInteger(SafeInteger) && doDouble(double) && doNumberString(CharSequence, String, JSConcatStringsNode) && doPrimitiveConversion(Object, JSToPrimitiveNode, JSToNumberNode, String, JSConcatStringsNode, ConditionProfile) */) {
                operandNodeValue_int = super.operandNode.executeInt(frameValue);
                operandNodeValue_ = JSTypes.intToDouble(operandNodeValue_int);
            } else if ((state & 0b10110000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not doIntTruncate(int) && doInt(int) && doIntOverflow(int) && doSafeInteger(SafeInteger) && doDouble(double) && doNumberString(CharSequence, String, JSConcatStringsNode) && doPrimitiveConversion(Object, JSToPrimitiveNode, JSToNumberNode, String, JSConcatStringsNode, ConditionProfile) */) {
                operandNodeValue_ = super.operandNode.executeDouble(frameValue);
            } else {
                Object operandNodeValue__ = super.operandNode.execute(frameValue);
                operandNodeValue_ = JSTypesGen.expectImplicitDouble((state & 0b11110000000) >>> 7 /* extract-implicit-active 0:double */, operandNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(ex.getResult());
        }
        assert (state & 0b10000) != 0 /* is-active doDouble(double) */;
        return doDouble(operandNodeValue_);
    }

    private Object execute_generic2(VirtualFrame frameValue, int state) {
        Object operandNodeValue_ = super.operandNode.execute(frameValue);
        if ((state & 0b111) != 0 /* is-active doIntTruncate(int) || doInt(int) || doIntOverflow(int) */ && operandNodeValue_ instanceof Integer) {
            int operandNodeValue__ = (int) operandNodeValue_;
            if ((state & 0b1) != 0 /* is-active doIntTruncate(int) */) {
                assert (truncate);
                assert (isInt);
                return doIntTruncate(operandNodeValue__);
            }
            if ((state & 0b10) != 0 /* is-active doInt(int) */) {
                assert (!(truncate));
                assert (isInt);
                try {
                    return doInt(operandNodeValue__);
                } catch (ArithmeticException ex) {
                    // implicit transferToInterpreterAndInvalidate()
                    Lock lock = getLock();
                    lock.lock();
                    try {
                        this.exclude_ = this.exclude_ | 0b1 /* add-excluded doInt(int) */;
                        this.state_ = this.state_ & 0xfffffffd /* remove-active doInt(int) */;
                    } finally {
                        lock.unlock();
                    }
                    return executeAndSpecialize(operandNodeValue__);
                }
            }
            if ((state & 0b100) != 0 /* is-active doIntOverflow(int) */) {
                assert (!(truncate));
                assert (isSafeLong);
                try {
                    return doIntOverflow(operandNodeValue__);
                } catch (ArithmeticException ex) {
                    // implicit transferToInterpreterAndInvalidate()
                    Lock lock = getLock();
                    lock.lock();
                    try {
                        this.exclude_ = this.exclude_ | 0b10 /* add-excluded doIntOverflow(int) */;
                        this.state_ = this.state_ & 0xfffffffb /* remove-active doIntOverflow(int) */;
                    } finally {
                        lock.unlock();
                    }
                    return executeAndSpecialize(operandNodeValue__);
                }
            }
        }
        if ((state & 0b1000) != 0 /* is-active doSafeInteger(SafeInteger) */ && operandNodeValue_ instanceof SafeInteger) {
            SafeInteger operandNodeValue__ = (SafeInteger) operandNodeValue_;
            assert (isInt);
            try {
                return doSafeInteger(operandNodeValue__);
            } catch (ArithmeticException ex) {
                // implicit transferToInterpreterAndInvalidate()
                Lock lock = getLock();
                lock.lock();
                try {
                    this.exclude_ = this.exclude_ | 0b100 /* add-excluded doSafeInteger(SafeInteger) */;
                    this.state_ = this.state_ & 0xfffffff7 /* remove-active doSafeInteger(SafeInteger) */;
                } finally {
                    lock.unlock();
                }
                return executeAndSpecialize(operandNodeValue__);
            }
        }
        if ((state & 0b10000) != 0 /* is-active doDouble(double) */ && JSTypesGen.isImplicitDouble((state & 0b11110000000) >>> 7 /* extract-implicit-active 0:double */, operandNodeValue_)) {
            double operandNodeValue__ = JSTypesGen.asImplicitDouble((state & 0b11110000000) >>> 7 /* extract-implicit-active 0:double */, operandNodeValue_);
            return doDouble(operandNodeValue__);
        }
        if ((state & 0b100000) != 0 /* is-active doNumberString(CharSequence, String, JSConcatStringsNode) */ && JSTypesGen.isImplicitCharSequence((state & 0b111100000000000) >>> 11 /* extract-implicit-active 0:CharSequence */, operandNodeValue_)) {
            CharSequence operandNodeValue__ = JSTypesGen.asImplicitCharSequence((state & 0b111100000000000) >>> 11 /* extract-implicit-active 0:CharSequence */, operandNodeValue_);
            return doNumberString(operandNodeValue__, this.numberString_leftString_, this.numberString_createLazyString_);
        }
        if ((state & 0b1000000) != 0 /* is-active doPrimitiveConversion(Object, JSToPrimitiveNode, JSToNumberNode, String, JSConcatStringsNode, ConditionProfile) */) {
            PrimitiveConversionData s7_ = this.primitiveConversion_cache;
            if (s7_ != null) {
                return doPrimitiveConversion(operandNodeValue_, s7_.toPrimitiveB_, s7_.toNumberB_, s7_.leftString_, s7_.createLazyString_, s7_.profileB_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue_);
    }

    @Override
    public double executeDouble(VirtualFrame frameValue) throws UnexpectedResultException {
        int state = state_;
        if ((state & 0b1000100) != 0 /* is-active doIntOverflow(int) || doPrimitiveConversion(Object, JSToPrimitiveNode, JSToNumberNode, String, JSConcatStringsNode, ConditionProfile) */) {
            return JSTypesGen.expectDouble(execute(frameValue));
        }
        int operandNodeValue_int = 0;
        long operandNodeValue_long = 0L;
        double operandNodeValue_;
        try {
            if ((state & 0b11100000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not doIntTruncate(int) && doInt(int) && doIntOverflow(int) && doSafeInteger(SafeInteger) && doDouble(double) && doNumberString(CharSequence, String, JSConcatStringsNode) && doPrimitiveConversion(Object, JSToPrimitiveNode, JSToNumberNode, String, JSConcatStringsNode, ConditionProfile) */) {
                operandNodeValue_long = super.operandNode.executeLong(frameValue);
                operandNodeValue_ = JSTypes.longToDouble(operandNodeValue_long);
            } else if ((state & 0b11010000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not doIntTruncate(int) && doInt(int) && doIntOverflow(int) && doSafeInteger(SafeInteger) && doDouble(double) && doNumberString(CharSequence, String, JSConcatStringsNode) && doPrimitiveConversion(Object, JSToPrimitiveNode, JSToNumberNode, String, JSConcatStringsNode, ConditionProfile) */) {
                operandNodeValue_int = super.operandNode.executeInt(frameValue);
                operandNodeValue_ = JSTypes.intToDouble(operandNodeValue_int);
            } else if ((state & 0b10110000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not doIntTruncate(int) && doInt(int) && doIntOverflow(int) && doSafeInteger(SafeInteger) && doDouble(double) && doNumberString(CharSequence, String, JSConcatStringsNode) && doPrimitiveConversion(Object, JSToPrimitiveNode, JSToNumberNode, String, JSConcatStringsNode, ConditionProfile) */) {
                operandNodeValue_ = super.operandNode.executeDouble(frameValue);
            } else {
                Object operandNodeValue__ = super.operandNode.execute(frameValue);
                operandNodeValue_ = JSTypesGen.expectImplicitDouble((state & 0b11110000000) >>> 7 /* extract-implicit-active 0:double */, operandNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectDouble(executeAndSpecialize(ex.getResult()));
        }
        if ((state & 0b10000) != 0 /* is-active doDouble(double) */) {
            return doDouble(operandNodeValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectDouble(executeAndSpecialize(((state & 0b11100000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not doIntTruncate(int) && doInt(int) && doIntOverflow(int) && doSafeInteger(SafeInteger) && doDouble(double) && doNumberString(CharSequence, String, JSConcatStringsNode) && doPrimitiveConversion(Object, JSToPrimitiveNode, JSToNumberNode, String, JSConcatStringsNode, ConditionProfile) */ ? (Object) operandNodeValue_long : ((state & 0b11010000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not doIntTruncate(int) && doInt(int) && doIntOverflow(int) && doSafeInteger(SafeInteger) && doDouble(double) && doNumberString(CharSequence, String, JSConcatStringsNode) && doPrimitiveConversion(Object, JSToPrimitiveNode, JSToNumberNode, String, JSConcatStringsNode, ConditionProfile) */ ? (Object) operandNodeValue_int : (Object) operandNodeValue_))));
    }

    @Override
    public int executeInt(VirtualFrame frameValue) throws UnexpectedResultException {
        int state = state_;
        if ((state & 0b1000100) != 0 /* is-active doIntOverflow(int) || doPrimitiveConversion(Object, JSToPrimitiveNode, JSToNumberNode, String, JSConcatStringsNode, ConditionProfile) */) {
            return JSTypesGen.expectInteger(execute(frameValue));
        }
        int operandNodeValue_;
        try {
            operandNodeValue_ = super.operandNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectInteger(executeAndSpecialize(ex.getResult()));
        }
        if ((state & 0b1) != 0 /* is-active doIntTruncate(int) */) {
            assert (truncate);
            assert (isInt);
            return doIntTruncate(operandNodeValue_);
        }
        if ((state & 0b10) != 0 /* is-active doInt(int) */) {
            assert (!(truncate));
            assert (isInt);
            try {
                return doInt(operandNodeValue_);
            } catch (ArithmeticException ex) {
                // implicit transferToInterpreterAndInvalidate()
                Lock lock = getLock();
                lock.lock();
                try {
                    this.exclude_ = this.exclude_ | 0b1 /* add-excluded doInt(int) */;
                    this.state_ = this.state_ & 0xfffffffd /* remove-active doInt(int) */;
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
            if ((state & 0b1111100) == 0 /* only-active doIntTruncate(int) && doInt(int) */ && (state & 0b1111111) != 0  /* is-not doIntTruncate(int) && doInt(int) && doIntOverflow(int) && doSafeInteger(SafeInteger) && doDouble(double) && doNumberString(CharSequence, String, JSConcatStringsNode) && doPrimitiveConversion(Object, JSToPrimitiveNode, JSToNumberNode, String, JSConcatStringsNode, ConditionProfile) */) {
                executeInt(frameValue);
                return;
            } else if ((state & 0b1101111) == 0 /* only-active doDouble(double) */ && (state & 0b1111111) != 0  /* is-not doIntTruncate(int) && doInt(int) && doIntOverflow(int) && doSafeInteger(SafeInteger) && doDouble(double) && doNumberString(CharSequence, String, JSConcatStringsNode) && doPrimitiveConversion(Object, JSToPrimitiveNode, JSToNumberNode, String, JSConcatStringsNode, ConditionProfile) */) {
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
            if (operandNodeValue instanceof Integer) {
                int operandNodeValue_ = (int) operandNodeValue;
                if ((truncate) && (isInt)) {
                    this.state_ = state = state | 0b1 /* add-active doIntTruncate(int) */;
                    lock.unlock();
                    hasLock = false;
                    return doIntTruncate(operandNodeValue_);
                }
                if (((exclude & 0b1)) == 0 /* is-not-excluded doInt(int) */) {
                    if ((!(truncate)) && (isInt)) {
                        this.state_ = state = state | 0b10 /* add-active doInt(int) */;
                        try {
                            lock.unlock();
                            hasLock = false;
                            return doInt(operandNodeValue_);
                        } catch (ArithmeticException ex) {
                            // implicit transferToInterpreterAndInvalidate()
                            lock.lock();
                            try {
                                this.exclude_ = this.exclude_ | 0b1 /* add-excluded doInt(int) */;
                                this.state_ = this.state_ & 0xfffffffd /* remove-active doInt(int) */;
                            } finally {
                                lock.unlock();
                            }
                            return executeAndSpecialize(operandNodeValue_);
                        }
                    }
                }
                if (((exclude & 0b10)) == 0 /* is-not-excluded doIntOverflow(int) */) {
                    if ((!(truncate)) && (isSafeLong)) {
                        this.state_ = state = state | 0b100 /* add-active doIntOverflow(int) */;
                        try {
                            lock.unlock();
                            hasLock = false;
                            return doIntOverflow(operandNodeValue_);
                        } catch (ArithmeticException ex) {
                            // implicit transferToInterpreterAndInvalidate()
                            lock.lock();
                            try {
                                this.exclude_ = this.exclude_ | 0b10 /* add-excluded doIntOverflow(int) */;
                                this.state_ = this.state_ & 0xfffffffb /* remove-active doIntOverflow(int) */;
                            } finally {
                                lock.unlock();
                            }
                            return executeAndSpecialize(operandNodeValue_);
                        }
                    }
                }
            }
            if (((exclude & 0b100)) == 0 /* is-not-excluded doSafeInteger(SafeInteger) */ && operandNodeValue instanceof SafeInteger) {
                SafeInteger operandNodeValue_ = (SafeInteger) operandNodeValue;
                if ((isInt)) {
                    this.state_ = state = state | 0b1000 /* add-active doSafeInteger(SafeInteger) */;
                    try {
                        lock.unlock();
                        hasLock = false;
                        return doSafeInteger(operandNodeValue_);
                    } catch (ArithmeticException ex) {
                        // implicit transferToInterpreterAndInvalidate()
                        lock.lock();
                        try {
                            this.exclude_ = this.exclude_ | 0b100 /* add-excluded doSafeInteger(SafeInteger) */;
                            this.state_ = this.state_ & 0xfffffff7 /* remove-active doSafeInteger(SafeInteger) */;
                        } finally {
                            lock.unlock();
                        }
                        return executeAndSpecialize(operandNodeValue_);
                    }
                }
            }
            if (((exclude & 0b1000)) == 0 /* is-not-excluded doDouble(double) */) {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(operandNodeValue)) != 0) {
                    double operandNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast0, operandNodeValue);
                    state = (state | (doubleCast0 << 7) /* set-implicit-active 0:double */);
                    this.state_ = state = state | 0b10000 /* add-active doDouble(double) */;
                    lock.unlock();
                    hasLock = false;
                    return doDouble(operandNodeValue_);
                }
            }
            if (((exclude & 0b10000)) == 0 /* is-not-excluded doNumberString(CharSequence, String, JSConcatStringsNode) */) {
                int charSequenceCast0;
                if ((charSequenceCast0 = JSTypesGen.specializeImplicitCharSequence(operandNodeValue)) != 0) {
                    CharSequence operandNodeValue_ = JSTypesGen.asImplicitCharSequence(charSequenceCast0, operandNodeValue);
                    this.numberString_leftString_ = (leftValueToString());
                    this.numberString_createLazyString_ = super.insert((JSConcatStringsNode.create()));
                    state = (state | (charSequenceCast0 << 11) /* set-implicit-active 0:CharSequence */);
                    this.state_ = state = state | 0b100000 /* add-active doNumberString(CharSequence, String, JSConcatStringsNode) */;
                    lock.unlock();
                    hasLock = false;
                    return doNumberString(operandNodeValue_, this.numberString_leftString_, this.numberString_createLazyString_);
                }
            }
            PrimitiveConversionData s7_ = super.insert(new PrimitiveConversionData());
            s7_.toPrimitiveB_ = s7_.insertAccessor((JSToPrimitiveNode.createHintNone()));
            s7_.toNumberB_ = s7_.insertAccessor((JSToNumberNode.create()));
            s7_.leftString_ = (leftValueToString());
            s7_.createLazyString_ = s7_.insertAccessor((JSConcatStringsNode.create()));
            s7_.profileB_ = (ConditionProfile.createBinaryProfile());
            this.primitiveConversion_cache = s7_;
            this.exclude_ = exclude = exclude | 0b11001 /* add-excluded doInt(int), doDouble(double), doNumberString(CharSequence, String, JSConcatStringsNode) */;
            state = state & 0xffffffcd /* remove-active doInt(int), doDouble(double), doNumberString(CharSequence, String, JSConcatStringsNode) */;
            this.state_ = state = state | 0b1000000 /* add-active doPrimitiveConversion(Object, JSToPrimitiveNode, JSToNumberNode, String, JSConcatStringsNode, ConditionProfile) */;
            lock.unlock();
            hasLock = false;
            return doPrimitiveConversion(operandNodeValue, s7_.toPrimitiveB_, s7_.toNumberB_, s7_.leftString_, s7_.createLazyString_, s7_.profileB_);
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
        s[0] = "doIntTruncate";
        if ((state & 0b1) != 0 /* is-active doIntTruncate(int) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doInt";
        if ((state & 0b10) != 0 /* is-active doInt(int) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b1) != 0 /* is-excluded doInt(int) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doIntOverflow";
        if ((state & 0b100) != 0 /* is-active doIntOverflow(int) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b10) != 0 /* is-excluded doIntOverflow(int) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doSafeInteger";
        if ((state & 0b1000) != 0 /* is-active doSafeInteger(SafeInteger) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b100) != 0 /* is-excluded doSafeInteger(SafeInteger) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doDouble";
        if ((state & 0b10000) != 0 /* is-active doDouble(double) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b1000) != 0 /* is-excluded doDouble(double) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "doNumberString";
        if ((state & 0b100000) != 0 /* is-active doNumberString(CharSequence, String, JSConcatStringsNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.numberString_leftString_, this.numberString_createLazyString_));
            s[2] = cached;
        } else if ((exclude & 0b10000) != 0 /* is-excluded doNumberString(CharSequence, String, JSConcatStringsNode) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "doPrimitiveConversion";
        if ((state & 0b1000000) != 0 /* is-active doPrimitiveConversion(Object, JSToPrimitiveNode, JSToNumberNode, String, JSConcatStringsNode, ConditionProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            PrimitiveConversionData s7_ = this.primitiveConversion_cache;
            if (s7_ != null) {
                cached.add(Arrays.asList(s7_.toPrimitiveB_, s7_.toNumberB_, s7_.leftString_, s7_.createLazyString_, s7_.profileB_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        return Provider.create(data);
    }

    public static JSAddConstantLeftNumberNode create(Number leftValue, JavaScriptNode right, boolean truncate) {
        return new JSAddConstantLeftNumberNodeGen(leftValue, right, truncate);
    }

    @GeneratedBy(JSAddConstantLeftNumberNode.class)
    private static final class PrimitiveConversionData extends Node {

        @Child JSToPrimitiveNode toPrimitiveB_;
        @Child JSToNumberNode toNumberB_;
        @CompilationFinal String leftString_;
        @Child JSConcatStringsNode createLazyString_;
        @CompilationFinal ConditionProfile profileB_;

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
