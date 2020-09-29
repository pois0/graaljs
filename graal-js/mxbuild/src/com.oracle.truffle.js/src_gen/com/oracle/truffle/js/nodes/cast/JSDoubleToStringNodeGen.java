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
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.js.nodes.JSTypesGen;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSDoubleToStringNode.class)
public final class JSDoubleToStringNodeGen extends JSDoubleToStringNode implements Provider {

    @CompilationFinal private volatile int state_;
    @CompilationFinal private DoubleData double_cache;

    private JSDoubleToStringNodeGen() {
    }

    @Override
    public String executeString(Object arg0Value) {
        int state = state_;
        if ((state & 0b1) != 0 /* is-active doInt(int) */ && arg0Value instanceof Integer) {
            int arg0Value_ = (int) arg0Value;
            return JSDoubleToStringNode.doInt(arg0Value_);
        }
        if ((state & 0b10) != 0 /* is-active doLong(long) */ && arg0Value instanceof Long) {
            long arg0Value_ = (long) arg0Value;
            return JSDoubleToStringNode.doLong(arg0Value_);
        }
        if ((state & 0b100) != 0 /* is-active doDouble(double, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile) */ && JSTypesGen.isImplicitDouble((state & 0b1111000) >>> 3 /* extract-implicit-active 0:double */, arg0Value)) {
            double arg0Value_ = JSTypesGen.asImplicitDouble((state & 0b1111000) >>> 3 /* extract-implicit-active 0:double */, arg0Value);
            DoubleData s3_ = this.double_cache;
            if (s3_ != null) {
                return JSDoubleToStringNode.doDouble(arg0Value_, s3_.isInt_, s3_.isNaN_, s3_.isPositiveInfinity_, s3_.isNegativeInfinity_, s3_.isZero_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    private String executeAndSpecialize(Object arg0Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        try {
            if (arg0Value instanceof Integer) {
                int arg0Value_ = (int) arg0Value;
                this.state_ = state = state | 0b1 /* add-active doInt(int) */;
                lock.unlock();
                hasLock = false;
                return JSDoubleToStringNode.doInt(arg0Value_);
            }
            if (arg0Value instanceof Long) {
                long arg0Value_ = (long) arg0Value;
                this.state_ = state = state | 0b10 /* add-active doLong(long) */;
                lock.unlock();
                hasLock = false;
                return JSDoubleToStringNode.doLong(arg0Value_);
            }
            {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(arg0Value)) != 0) {
                    double arg0Value_ = JSTypesGen.asImplicitDouble(doubleCast0, arg0Value);
                    DoubleData s3_ = new DoubleData();
                    s3_.isInt_ = (ConditionProfile.createBinaryProfile());
                    s3_.isNaN_ = (ConditionProfile.createBinaryProfile());
                    s3_.isPositiveInfinity_ = (ConditionProfile.createBinaryProfile());
                    s3_.isNegativeInfinity_ = (ConditionProfile.createBinaryProfile());
                    s3_.isZero_ = (ConditionProfile.createBinaryProfile());
                    this.double_cache = s3_;
                    state = (state | (doubleCast0 << 3) /* set-implicit-active 0:double */);
                    this.state_ = state = state | 0b100 /* add-active doDouble(double, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return JSDoubleToStringNode.doDouble(arg0Value_, s3_.isInt_, s3_.isNaN_, s3_.isPositiveInfinity_, s3_.isNegativeInfinity_, s3_.isZero_);
                }
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
        if ((state & 0b111) == 0b0) {
            return NodeCost.UNINITIALIZED;
        } else if (((state & 0b111) & ((state & 0b111) - 1)) == 0 /* is-single-active  */) {
            return NodeCost.MONOMORPHIC;
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[4];
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
        s[0] = "doLong";
        if ((state & 0b10) != 0 /* is-active doLong(long) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doDouble";
        if ((state & 0b100) != 0 /* is-active doDouble(double, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile, ConditionProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            DoubleData s3_ = this.double_cache;
            if (s3_ != null) {
                cached.add(Arrays.asList(s3_.isInt_, s3_.isNaN_, s3_.isPositiveInfinity_, s3_.isNegativeInfinity_, s3_.isZero_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        return Provider.create(data);
    }

    public static JSDoubleToStringNode create() {
        return new JSDoubleToStringNodeGen();
    }

    @GeneratedBy(JSDoubleToStringNode.class)
    private static final class DoubleData {

        @CompilationFinal ConditionProfile isInt_;
        @CompilationFinal ConditionProfile isNaN_;
        @CompilationFinal ConditionProfile isPositiveInfinity_;
        @CompilationFinal ConditionProfile isNegativeInfinity_;
        @CompilationFinal ConditionProfile isZero_;

        DoubleData() {
        }

    }
}
