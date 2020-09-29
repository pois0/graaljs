// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.js.nodes.JSGuards;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(IsJSObjectNode.class)
public final class IsJSObjectNodeGen extends IsJSObjectNode implements Provider {

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private IsObjectCachedData isObjectCached_cache;
    @CompilationFinal private ConditionProfile isObject_resultProfile_;

    private IsJSObjectNodeGen(boolean includeNullUndefined) {
        super(includeNullUndefined);
    }

    @ExplodeLoop
    @Override
    public boolean executeBoolean(Object arg0Value) {
        int state = state_;
        if (state != 0 /* is-active isObjectCached(Object, Class<>, boolean) || isObject(Object, ConditionProfile) */) {
            if ((state & 0b1) != 0 /* is-active isObjectCached(Object, Class<>, boolean) */) {
                IsObjectCachedData s1_ = this.isObjectCached_cache;
                while (s1_ != null) {
                    assert (s1_.cachedClass_ != null);
                    if ((s1_.cachedClass_.isInstance(arg0Value))) {
                        return IsJSObjectNode.isObjectCached(arg0Value, s1_.cachedClass_, s1_.cachedResult_);
                    }
                    s1_ = s1_.next_;
                }
            }
            if ((state & 0b10) != 0 /* is-active isObject(Object, ConditionProfile) */) {
                return isObject(arg0Value, this.isObject_resultProfile_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    private boolean executeAndSpecialize(Object arg0Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        int exclude = exclude_;
        try {
            if ((exclude) == 0 /* is-not-excluded isObjectCached(Object, Class<>, boolean) */) {
                int count1_ = 0;
                IsObjectCachedData s1_ = this.isObjectCached_cache;
                if ((state & 0b1) != 0 /* is-active isObjectCached(Object, Class<>, boolean) */) {
                    while (s1_ != null) {
                        assert (s1_.cachedClass_ != null);
                        if ((s1_.cachedClass_.isInstance(arg0Value))) {
                            break;
                        }
                        s1_ = s1_.next_;
                        count1_++;
                    }
                }
                if (s1_ == null) {
                    {
                        Class<?> cachedClass__ = (JSGuards.getClassIfJSDynamicObject(arg0Value));
                        if ((cachedClass__ != null) && (cachedClass__.isInstance(arg0Value)) && count1_ < (IsJSObjectNode.MAX_CLASS_COUNT)) {
                            s1_ = new IsObjectCachedData(isObjectCached_cache);
                            s1_.cachedClass_ = cachedClass__;
                            s1_.cachedResult_ = (guardIsJSObject(arg0Value));
                            this.isObjectCached_cache = s1_;
                            this.state_ = state = state | 0b1 /* add-active isObjectCached(Object, Class<>, boolean) */;
                        }
                    }
                }
                if (s1_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return IsJSObjectNode.isObjectCached(arg0Value, s1_.cachedClass_, s1_.cachedResult_);
                }
            }
            this.isObject_resultProfile_ = (ConditionProfile.createBinaryProfile());
            this.exclude_ = exclude = exclude | 0b1 /* add-excluded isObjectCached(Object, Class<>, boolean) */;
            this.isObjectCached_cache = null;
            state = state & 0xfffffffe /* remove-active isObjectCached(Object, Class<>, boolean) */;
            this.state_ = state = state | 0b10 /* add-active isObject(Object, ConditionProfile) */;
            lock.unlock();
            hasLock = false;
            return isObject(arg0Value, this.isObject_resultProfile_);
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
            IsObjectCachedData s1_ = this.isObjectCached_cache;
            if ((s1_ == null || s1_.next_ == null)) {
                return NodeCost.MONOMORPHIC;
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[3];
        Object[] s;
        data[0] = 0;
        int state = state_;
        int exclude = exclude_;
        s = new Object[3];
        s[0] = "isObjectCached";
        if ((state & 0b1) != 0 /* is-active isObjectCached(Object, Class<>, boolean) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            IsObjectCachedData s1_ = this.isObjectCached_cache;
            while (s1_ != null) {
                cached.add(Arrays.asList(s1_.cachedClass_, s1_.cachedResult_));
                s1_ = s1_.next_;
            }
            s[2] = cached;
        } else if (exclude != 0 /* is-excluded isObjectCached(Object, Class<>, boolean) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "isObject";
        if ((state & 0b10) != 0 /* is-active isObject(Object, ConditionProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.isObject_resultProfile_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        return Provider.create(data);
    }

    public static IsJSObjectNode create(boolean includeNullUndefined) {
        return new IsJSObjectNodeGen(includeNullUndefined);
    }

    @GeneratedBy(IsJSObjectNode.class)
    private static final class IsObjectCachedData {

        @CompilationFinal IsObjectCachedData next_;
        @CompilationFinal Class<?> cachedClass_;
        @CompilationFinal boolean cachedResult_;

        IsObjectCachedData(IsObjectCachedData next_) {
            this.next_ = next_;
        }

    }
}
