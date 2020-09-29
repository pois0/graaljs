// CheckStyle: start generated
package com.oracle.truffle.js.nodes.unary;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.js.runtime.SafeInteger;
import com.oracle.truffle.js.runtime.objects.JSLazyString;
import com.oracle.truffle.js.runtime.objects.PropertyReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(FlattenNode.class)
public final class FlattenNodeGen extends FlattenNode implements Provider {

    @CompilationFinal private volatile int state_;
    @CompilationFinal private ConditionProfile lazyString0_flatten_;

    private FlattenNodeGen() {
    }

    @Override
    public Object execute(Object arg0Value) {
        int state = state_;
        if ((state & 0b1) != 0 /* is-active doLazyString(JSLazyString, ConditionProfile) */ && arg0Value instanceof JSLazyString) {
            JSLazyString arg0Value_ = (JSLazyString) arg0Value;
            return FlattenNode.doLazyString(arg0Value_, this.lazyString0_flatten_);
        }
        if ((state & 0b10) != 0 /* is-active doLazyString(PropertyReference) */ && arg0Value instanceof PropertyReference) {
            PropertyReference arg0Value_ = (PropertyReference) arg0Value;
            return FlattenNode.doLazyString(arg0Value_);
        }
        if ((state & 0b100) != 0 /* is-active doSafeInteger(SafeInteger) */ && arg0Value instanceof SafeInteger) {
            SafeInteger arg0Value_ = (SafeInteger) arg0Value;
            return FlattenNode.doSafeInteger(arg0Value_);
        }
        if ((state & 0b1000) != 0 /* is-active doOther(Object) */) {
            if (fallbackGuard_(state, arg0Value)) {
                return FlattenNode.doOther(arg0Value);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    private Object executeAndSpecialize(Object arg0Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        try {
            if (arg0Value instanceof JSLazyString) {
                JSLazyString arg0Value_ = (JSLazyString) arg0Value;
                this.lazyString0_flatten_ = (ConditionProfile.createBinaryProfile());
                this.state_ = state = state | 0b1 /* add-active doLazyString(JSLazyString, ConditionProfile) */;
                lock.unlock();
                hasLock = false;
                return FlattenNode.doLazyString(arg0Value_, this.lazyString0_flatten_);
            }
            if (arg0Value instanceof PropertyReference) {
                PropertyReference arg0Value_ = (PropertyReference) arg0Value;
                this.state_ = state = state | 0b10 /* add-active doLazyString(PropertyReference) */;
                lock.unlock();
                hasLock = false;
                return FlattenNode.doLazyString(arg0Value_);
            }
            if (arg0Value instanceof SafeInteger) {
                SafeInteger arg0Value_ = (SafeInteger) arg0Value;
                this.state_ = state = state | 0b100 /* add-active doSafeInteger(SafeInteger) */;
                lock.unlock();
                hasLock = false;
                return FlattenNode.doSafeInteger(arg0Value_);
            }
            this.state_ = state = state | 0b1000 /* add-active doOther(Object) */;
            lock.unlock();
            hasLock = false;
            return FlattenNode.doOther(arg0Value);
        } finally {
            if (hasLock) {
                lock.unlock();
            }
        }
    }

    @Override
    public NodeCost getCost() {
        int state = state_;
        if (state == 0b0) {
            return NodeCost.UNINITIALIZED;
        } else if ((state & (state - 1)) == 0 /* is-single-active  */) {
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
        s[0] = "doLazyString";
        if ((state & 0b1) != 0 /* is-active doLazyString(JSLazyString, ConditionProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.lazyString0_flatten_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doLazyString";
        if ((state & 0b10) != 0 /* is-active doLazyString(PropertyReference) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doSafeInteger";
        if ((state & 0b100) != 0 /* is-active doSafeInteger(SafeInteger) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doOther";
        if ((state & 0b1000) != 0 /* is-active doOther(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        return Provider.create(data);
    }

    private static boolean fallbackGuard_(int state, Object arg0Value) {
        if (((state & 0b1)) == 0 /* is-not-active doLazyString(JSLazyString, ConditionProfile) */ && arg0Value instanceof JSLazyString) {
            return false;
        }
        if (((state & 0b10)) == 0 /* is-not-active doLazyString(PropertyReference) */ && arg0Value instanceof PropertyReference) {
            return false;
        }
        if (((state & 0b100)) == 0 /* is-not-active doSafeInteger(SafeInteger) */ && arg0Value instanceof SafeInteger) {
            return false;
        }
        return true;
    }

    public static FlattenNode create() {
        return new FlattenNodeGen();
    }

}
