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
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.api.object.HiddenKey;
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.runtime.Symbol;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(ToArrayIndexNode.class)
public final class ToArrayIndexNodeGen extends ToArrayIndexNode implements Provider {

    @CompilationFinal private volatile int state_;
    @CompilationFinal private ConvertFromStringData convertFromString_cache;
    @Child private JSToPropertyKeyNode nonArrayIndex1_toPropertyKey_;

    private ToArrayIndexNodeGen(boolean convertToPropertyKey) {
        super(convertToPropertyKey);
    }

    @Override
    public Object execute(Object arg0Value) {
        int state = state_;
        if ((state & 0b1) != 0 /* is-active doInteger(int) */ && arg0Value instanceof Integer) {
            int arg0Value_ = (int) arg0Value;
            if ((JSGuards.isIntArrayIndex(arg0Value_))) {
                return ToArrayIndexNode.doInteger(arg0Value_);
            }
        }
        if ((state & 0b10) != 0 /* is-active doLong(long) */ && arg0Value instanceof Long) {
            long arg0Value_ = (long) arg0Value;
            if ((JSGuards.isLongArrayIndex(arg0Value_))) {
                return ToArrayIndexNode.doLong(arg0Value_);
            }
        }
        if ((state & 0b1100) != 0 /* is-active doDoubleAsIntIndex(double) || doDoubleAsUintIndex(double) */ && JSTypesGen.isImplicitDouble((state & 0b11110000000000) >>> 10 /* extract-implicit-active 0:double */, arg0Value)) {
            double arg0Value_ = JSTypesGen.asImplicitDouble((state & 0b11110000000000) >>> 10 /* extract-implicit-active 0:double */, arg0Value);
            if ((state & 0b100) != 0 /* is-active doDoubleAsIntIndex(double) */) {
                if ((ToArrayIndexNode.doubleIsIntIndex(arg0Value_))) {
                    return ToArrayIndexNode.doDoubleAsIntIndex(arg0Value_);
                }
            }
            if ((state & 0b1000) != 0 /* is-active doDoubleAsUintIndex(double) */) {
                if ((ToArrayIndexNode.doubleIsUintIndex(arg0Value_))) {
                    return ToArrayIndexNode.doDoubleAsUintIndex(arg0Value_);
                }
            }
        }
        if ((state & 0b10000) != 0 /* is-active doSymbol(Symbol) */ && arg0Value instanceof Symbol) {
            Symbol arg0Value_ = (Symbol) arg0Value;
            return ToArrayIndexNode.doSymbol(arg0Value_);
        }
        if ((state & 0b100000) != 0 /* is-active doHiddenKey(HiddenKey) */ && arg0Value instanceof HiddenKey) {
            HiddenKey arg0Value_ = (HiddenKey) arg0Value;
            return ToArrayIndexNode.doHiddenKey(arg0Value_);
        }
        if ((state & 0b11000000) != 0 /* is-active convertFromString(String, BranchProfile, BranchProfile, BranchProfile) || convertFromStringNotInRange(String) */ && JSTypesGen.isImplicitString((state & 0x3c000) >>> 14 /* extract-implicit-active 0:String */, arg0Value)) {
            String arg0Value_ = JSTypesGen.asImplicitString((state & 0x3c000) >>> 14 /* extract-implicit-active 0:String */, arg0Value);
            if ((state & 0b1000000) != 0 /* is-active convertFromString(String, BranchProfile, BranchProfile, BranchProfile) */) {
                ConvertFromStringData s7_ = this.convertFromString_cache;
                if (s7_ != null) {
                    if ((JSGuards.isArrayIndexLengthInRange(arg0Value_))) {
                        return ToArrayIndexNode.convertFromString(arg0Value_, s7_.startsWithDigitBranch_, s7_.isArrayIndexBranch_, s7_.needPassStringBranch_);
                    }
                }
            }
            if ((state & 0b10000000) != 0 /* is-active convertFromStringNotInRange(String) */) {
                if ((!(JSGuards.isArrayIndexLengthInRange(arg0Value_)))) {
                    return ToArrayIndexNode.convertFromStringNotInRange(arg0Value_);
                }
            }
        }
        if ((state & 0b1100000000) != 0 /* is-active doNonArrayIndex(Object) || doNonArrayIndex(Object, JSToPropertyKeyNode) */) {
            if ((state & 0b100000000) != 0 /* is-active doNonArrayIndex(Object) */) {
                assert (!(convertToPropertyKey));
                if ((ToArrayIndexNode.notArrayIndex(arg0Value))) {
                    return ToArrayIndexNode.doNonArrayIndex(arg0Value);
                }
            }
            if ((state & 0b1000000000) != 0 /* is-active doNonArrayIndex(Object, JSToPropertyKeyNode) */) {
                assert (convertToPropertyKey);
                if ((ToArrayIndexNode.notArrayIndex(arg0Value))) {
                    return ToArrayIndexNode.doNonArrayIndex(arg0Value, this.nonArrayIndex1_toPropertyKey_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    @Override
    public long executeLong(Object arg0Value) throws UnexpectedResultException {
        int state = state_;
        if ((state & 0b1111000000) != 0 /* is-active convertFromString(String, BranchProfile, BranchProfile, BranchProfile) || convertFromStringNotInRange(String) || doNonArrayIndex(Object) || doNonArrayIndex(Object, JSToPropertyKeyNode) */) {
            return JSTypesGen.expectLong(execute(arg0Value));
        }
        if ((state & 0b1) != 0 /* is-active doInteger(int) */ && arg0Value instanceof Integer) {
            int arg0Value_ = (int) arg0Value;
            if ((JSGuards.isIntArrayIndex(arg0Value_))) {
                return ToArrayIndexNode.doInteger(arg0Value_);
            }
        }
        if ((state & 0b10) != 0 /* is-active doLong(long) */ && arg0Value instanceof Long) {
            long arg0Value_ = (long) arg0Value;
            if ((JSGuards.isLongArrayIndex(arg0Value_))) {
                return ToArrayIndexNode.doLong(arg0Value_);
            }
        }
        if ((state & 0b1100) != 0 /* is-active doDoubleAsIntIndex(double) || doDoubleAsUintIndex(double) */ && JSTypesGen.isImplicitDouble((state & 0b11110000000000) >>> 10 /* extract-implicit-active 0:double */, arg0Value)) {
            double arg0Value_ = JSTypesGen.asImplicitDouble((state & 0b11110000000000) >>> 10 /* extract-implicit-active 0:double */, arg0Value);
            if ((state & 0b100) != 0 /* is-active doDoubleAsIntIndex(double) */) {
                if ((ToArrayIndexNode.doubleIsIntIndex(arg0Value_))) {
                    return ToArrayIndexNode.doDoubleAsIntIndex(arg0Value_);
                }
            }
            if ((state & 0b1000) != 0 /* is-active doDoubleAsUintIndex(double) */) {
                if ((ToArrayIndexNode.doubleIsUintIndex(arg0Value_))) {
                    return ToArrayIndexNode.doDoubleAsUintIndex(arg0Value_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectLong(executeAndSpecialize(arg0Value));
    }

    private Object executeAndSpecialize(Object arg0Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        try {
            if (arg0Value instanceof Integer) {
                int arg0Value_ = (int) arg0Value;
                if ((JSGuards.isIntArrayIndex(arg0Value_))) {
                    this.state_ = state = state | 0b1 /* add-active doInteger(int) */;
                    lock.unlock();
                    hasLock = false;
                    return ToArrayIndexNode.doInteger(arg0Value_);
                }
            }
            if (arg0Value instanceof Long) {
                long arg0Value_ = (long) arg0Value;
                if ((JSGuards.isLongArrayIndex(arg0Value_))) {
                    this.state_ = state = state | 0b10 /* add-active doLong(long) */;
                    lock.unlock();
                    hasLock = false;
                    return ToArrayIndexNode.doLong(arg0Value_);
                }
            }
            {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(arg0Value)) != 0) {
                    double arg0Value_ = JSTypesGen.asImplicitDouble(doubleCast0, arg0Value);
                    if ((ToArrayIndexNode.doubleIsIntIndex(arg0Value_))) {
                        state = (state | (doubleCast0 << 10) /* set-implicit-active 0:double */);
                        this.state_ = state = state | 0b100 /* add-active doDoubleAsIntIndex(double) */;
                        lock.unlock();
                        hasLock = false;
                        return ToArrayIndexNode.doDoubleAsIntIndex(arg0Value_);
                    }
                    if ((ToArrayIndexNode.doubleIsUintIndex(arg0Value_))) {
                        state = (state | (doubleCast0 << 10) /* set-implicit-active 0:double */);
                        this.state_ = state = state | 0b1000 /* add-active doDoubleAsUintIndex(double) */;
                        lock.unlock();
                        hasLock = false;
                        return ToArrayIndexNode.doDoubleAsUintIndex(arg0Value_);
                    }
                }
            }
            if (arg0Value instanceof Symbol) {
                Symbol arg0Value_ = (Symbol) arg0Value;
                this.state_ = state = state | 0b10000 /* add-active doSymbol(Symbol) */;
                lock.unlock();
                hasLock = false;
                return ToArrayIndexNode.doSymbol(arg0Value_);
            }
            if (arg0Value instanceof HiddenKey) {
                HiddenKey arg0Value_ = (HiddenKey) arg0Value;
                this.state_ = state = state | 0b100000 /* add-active doHiddenKey(HiddenKey) */;
                lock.unlock();
                hasLock = false;
                return ToArrayIndexNode.doHiddenKey(arg0Value_);
            }
            {
                int stringCast0;
                if ((stringCast0 = JSTypesGen.specializeImplicitString(arg0Value)) != 0) {
                    String arg0Value_ = JSTypesGen.asImplicitString(stringCast0, arg0Value);
                    if ((JSGuards.isArrayIndexLengthInRange(arg0Value_))) {
                        ConvertFromStringData s7_ = new ConvertFromStringData();
                        s7_.startsWithDigitBranch_ = (BranchProfile.create());
                        s7_.isArrayIndexBranch_ = (BranchProfile.create());
                        s7_.needPassStringBranch_ = (BranchProfile.create());
                        this.convertFromString_cache = s7_;
                        state = (state | (stringCast0 << 14) /* set-implicit-active 0:String */);
                        this.state_ = state = state | 0b1000000 /* add-active convertFromString(String, BranchProfile, BranchProfile, BranchProfile) */;
                        lock.unlock();
                        hasLock = false;
                        return ToArrayIndexNode.convertFromString(arg0Value_, s7_.startsWithDigitBranch_, s7_.isArrayIndexBranch_, s7_.needPassStringBranch_);
                    }
                    if ((!(JSGuards.isArrayIndexLengthInRange(arg0Value_)))) {
                        state = (state | (stringCast0 << 14) /* set-implicit-active 0:String */);
                        this.state_ = state = state | 0b10000000 /* add-active convertFromStringNotInRange(String) */;
                        lock.unlock();
                        hasLock = false;
                        return ToArrayIndexNode.convertFromStringNotInRange(arg0Value_);
                    }
                }
            }
            if ((!(convertToPropertyKey)) && (ToArrayIndexNode.notArrayIndex(arg0Value))) {
                this.state_ = state = state | 0b100000000 /* add-active doNonArrayIndex(Object) */;
                lock.unlock();
                hasLock = false;
                return ToArrayIndexNode.doNonArrayIndex(arg0Value);
            }
            if ((convertToPropertyKey) && (ToArrayIndexNode.notArrayIndex(arg0Value))) {
                this.nonArrayIndex1_toPropertyKey_ = super.insert((JSToPropertyKeyNode.create()));
                this.state_ = state = state | 0b1000000000 /* add-active doNonArrayIndex(Object, JSToPropertyKeyNode) */;
                lock.unlock();
                hasLock = false;
                return ToArrayIndexNode.doNonArrayIndex(arg0Value, this.nonArrayIndex1_toPropertyKey_);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {null}, arg0Value);
        } finally {
            if (hasLock) {
                lock.unlock();
            }
        }
    }

    @Override
    public NodeCost getCost() {
        int state = state_;
        if ((state & 0b1111111111) == 0b0) {
            return NodeCost.UNINITIALIZED;
        } else if (((state & 0b1111111111) & ((state & 0b1111111111) - 1)) == 0 /* is-single-active  */) {
            return NodeCost.MONOMORPHIC;
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[11];
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
        s[0] = "doLong";
        if ((state & 0b10) != 0 /* is-active doLong(long) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doDoubleAsIntIndex";
        if ((state & 0b100) != 0 /* is-active doDoubleAsIntIndex(double) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doDoubleAsUintIndex";
        if ((state & 0b1000) != 0 /* is-active doDoubleAsUintIndex(double) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doSymbol";
        if ((state & 0b10000) != 0 /* is-active doSymbol(Symbol) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "doHiddenKey";
        if ((state & 0b100000) != 0 /* is-active doHiddenKey(HiddenKey) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "convertFromString";
        if ((state & 0b1000000) != 0 /* is-active convertFromString(String, BranchProfile, BranchProfile, BranchProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            ConvertFromStringData s7_ = this.convertFromString_cache;
            if (s7_ != null) {
                cached.add(Arrays.asList(s7_.startsWithDigitBranch_, s7_.isArrayIndexBranch_, s7_.needPassStringBranch_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        s = new Object[3];
        s[0] = "convertFromStringNotInRange";
        if ((state & 0b10000000) != 0 /* is-active convertFromStringNotInRange(String) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[8] = s;
        s = new Object[3];
        s[0] = "doNonArrayIndex";
        if ((state & 0b100000000) != 0 /* is-active doNonArrayIndex(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[9] = s;
        s = new Object[3];
        s[0] = "doNonArrayIndex";
        if ((state & 0b1000000000) != 0 /* is-active doNonArrayIndex(Object, JSToPropertyKeyNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.nonArrayIndex1_toPropertyKey_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[10] = s;
        return Provider.create(data);
    }

    public static ToArrayIndexNode create(boolean convertToPropertyKey) {
        return new ToArrayIndexNodeGen(convertToPropertyKey);
    }

    @GeneratedBy(ToArrayIndexNode.class)
    private static final class ConvertFromStringData {

        @CompilationFinal BranchProfile startsWithDigitBranch_;
        @CompilationFinal BranchProfile isArrayIndexBranch_;
        @CompilationFinal BranchProfile needPassStringBranch_;

        ConvertFromStringData() {
        }

    }
}
