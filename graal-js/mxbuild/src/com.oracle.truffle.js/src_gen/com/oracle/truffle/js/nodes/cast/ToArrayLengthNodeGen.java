// CheckStyle: start generated
package com.oracle.truffle.js.nodes.cast;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.runtime.JSRuntime;
import com.oracle.truffle.js.runtime.SafeInteger;

@GeneratedBy(ToArrayLengthNode.class)
public final class ToArrayLengthNodeGen extends ToArrayLengthNode implements Provider {

    @CompilationFinal private int state_;

    private ToArrayLengthNodeGen() {
    }

    @Override
    public long executeLong(Object arg0Value) {
        int state = state_;
        if ((state & 0b1) != 0 /* is-active doInt(int) */ && arg0Value instanceof Integer) {
            int arg0Value_ = (int) arg0Value;
            return ToArrayLengthNode.doInt(arg0Value_);
        }
        if ((state & 0b110) != 0 /* is-active doSafeInteger(SafeInteger) || rangeError(SafeInteger) */ && arg0Value instanceof SafeInteger) {
            SafeInteger arg0Value_ = (SafeInteger) arg0Value;
            if ((state & 0b10) != 0 /* is-active doSafeInteger(SafeInteger) */) {
                if ((JSRuntime.isValidArrayLength(arg0Value_.longValue()))) {
                    return ToArrayLengthNode.doSafeInteger(arg0Value_);
                }
            }
            if ((state & 0b100) != 0 /* is-active rangeError(SafeInteger) */) {
                if ((!(JSRuntime.isValidArrayLength(arg0Value_.longValue())))) {
                    return ToArrayLengthNode.rangeError(arg0Value_);
                }
            }
        }
        if ((state & 0b11000) != 0 /* is-active doLong(long) || rangeError(long) */ && arg0Value instanceof Long) {
            long arg0Value_ = (long) arg0Value;
            if ((state & 0b1000) != 0 /* is-active doLong(long) */) {
                if ((JSRuntime.isValidArrayLength(arg0Value_))) {
                    return ToArrayLengthNode.doLong(arg0Value_);
                }
            }
            if ((state & 0b10000) != 0 /* is-active rangeError(long) */) {
                if ((!(JSRuntime.isValidArrayLength(arg0Value_)))) {
                    return ToArrayLengthNode.rangeError(arg0Value_);
                }
            }
        }
        if ((state & 0b1100000) != 0 /* is-active doDouble(double) || rangeError(double) */ && JSTypesGen.isImplicitDouble((state & 0b111100000000) >>> 8 /* extract-implicit-active 0:double */, arg0Value)) {
            double arg0Value_ = JSTypesGen.asImplicitDouble((state & 0b111100000000) >>> 8 /* extract-implicit-active 0:double */, arg0Value);
            if ((state & 0b100000) != 0 /* is-active doDouble(double) */) {
                if ((JSRuntime.isValidArrayLength(arg0Value_))) {
                    return ToArrayLengthNode.doDouble(arg0Value_);
                }
            }
            if ((state & 0b1000000) != 0 /* is-active rangeError(double) */) {
                if ((!(JSRuntime.isValidArrayLength(arg0Value_)))) {
                    return ToArrayLengthNode.rangeError(arg0Value_);
                }
            }
        }
        if ((state & 0b10000000) != 0 /* is-active typeNotNumber(Object) */) {
            if ((!(JSRuntime.isNumber(arg0Value)))) {
                return ToArrayLengthNode.typeNotNumber(arg0Value);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    private long executeAndSpecialize(Object arg0Value) {
        int state = state_;
        if (arg0Value instanceof Integer) {
            int arg0Value_ = (int) arg0Value;
            this.state_ = state = state | 0b1 /* add-active doInt(int) */;
            return ToArrayLengthNode.doInt(arg0Value_);
        }
        if (arg0Value instanceof SafeInteger) {
            SafeInteger arg0Value_ = (SafeInteger) arg0Value;
            if ((JSRuntime.isValidArrayLength(arg0Value_.longValue()))) {
                this.state_ = state = state | 0b10 /* add-active doSafeInteger(SafeInteger) */;
                return ToArrayLengthNode.doSafeInteger(arg0Value_);
            }
            if ((!(JSRuntime.isValidArrayLength(arg0Value_.longValue())))) {
                this.state_ = state = state | 0b100 /* add-active rangeError(SafeInteger) */;
                return ToArrayLengthNode.rangeError(arg0Value_);
            }
        }
        if (arg0Value instanceof Long) {
            long arg0Value_ = (long) arg0Value;
            if ((JSRuntime.isValidArrayLength(arg0Value_))) {
                this.state_ = state = state | 0b1000 /* add-active doLong(long) */;
                return ToArrayLengthNode.doLong(arg0Value_);
            }
            if ((!(JSRuntime.isValidArrayLength(arg0Value_)))) {
                this.state_ = state = state | 0b10000 /* add-active rangeError(long) */;
                return ToArrayLengthNode.rangeError(arg0Value_);
            }
        }
        {
            int doubleCast0;
            if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(arg0Value)) != 0) {
                double arg0Value_ = JSTypesGen.asImplicitDouble(doubleCast0, arg0Value);
                if ((JSRuntime.isValidArrayLength(arg0Value_))) {
                    state = (state | (doubleCast0 << 8) /* set-implicit-active 0:double */);
                    this.state_ = state = state | 0b100000 /* add-active doDouble(double) */;
                    return ToArrayLengthNode.doDouble(arg0Value_);
                }
                if ((!(JSRuntime.isValidArrayLength(arg0Value_)))) {
                    state = (state | (doubleCast0 << 8) /* set-implicit-active 0:double */);
                    this.state_ = state = state | 0b1000000 /* add-active rangeError(double) */;
                    return ToArrayLengthNode.rangeError(arg0Value_);
                }
            }
        }
        if ((!(JSRuntime.isNumber(arg0Value)))) {
            this.state_ = state = state | 0b10000000 /* add-active typeNotNumber(Object) */;
            return ToArrayLengthNode.typeNotNumber(arg0Value);
        }
        throw new UnsupportedSpecializationException(this, new Node[] {null}, arg0Value);
    }

    @Override
    public NodeCost getCost() {
        int state = state_;
        if ((state & 0b11111111) == 0b0) {
            return NodeCost.UNINITIALIZED;
        } else if (((state & 0b11111111) & ((state & 0b11111111) - 1)) == 0 /* is-single-active  */) {
            return NodeCost.MONOMORPHIC;
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[9];
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
        s[0] = "doSafeInteger";
        if ((state & 0b10) != 0 /* is-active doSafeInteger(SafeInteger) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "rangeError";
        if ((state & 0b100) != 0 /* is-active rangeError(SafeInteger) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doLong";
        if ((state & 0b1000) != 0 /* is-active doLong(long) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "rangeError";
        if ((state & 0b10000) != 0 /* is-active rangeError(long) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "doDouble";
        if ((state & 0b100000) != 0 /* is-active doDouble(double) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "rangeError";
        if ((state & 0b1000000) != 0 /* is-active rangeError(double) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        s = new Object[3];
        s[0] = "typeNotNumber";
        if ((state & 0b10000000) != 0 /* is-active typeNotNumber(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[8] = s;
        return Provider.create(data);
    }

    public static ToArrayLengthNode create() {
        return new ToArrayLengthNodeGen();
    }

}
