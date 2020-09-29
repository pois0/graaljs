// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.object.HiddenKey;
import com.oracle.truffle.api.object.Shape;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(HasHiddenKeyCacheNode.class)
public final class HasHiddenKeyCacheNodeGen extends HasHiddenKeyCacheNode implements Provider {

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private CachedData cached_cache;

    private HasHiddenKeyCacheNodeGen(HiddenKey key) {
        super(key);
    }

    @ExplodeLoop
    @Override
    public boolean executeHasHiddenKey(Object arg0Value) {
        int state = state_;
        if ((state & 0b11) != 0 /* is-active doCached(DynamicObject, Shape, boolean, int) || doUncached(DynamicObject) */ && JSTypes.isDynamicObject(arg0Value)) {
            DynamicObject arg0Value_ = (DynamicObject) arg0Value;
            if ((state & 0b1) != 0 /* is-active doCached(DynamicObject, Shape, boolean, int) */) {
                CachedData s1_ = this.cached_cache;
                while (s1_ != null) {
                    if (!Assumption.isValidAssumption(s1_.assumption0_)) {
                        CompilerDirectives.transferToInterpreterAndInvalidate();
                        removeCached_(s1_);
                        return executeAndSpecialize(arg0Value_);
                    }
                    if ((s1_.cachedShape_.check(arg0Value_))) {
                        return HasHiddenKeyCacheNode.doCached(arg0Value_, s1_.cachedShape_, s1_.hasOwnProperty_, s1_.cacheLimit_);
                    }
                    s1_ = s1_.next_;
                }
            }
            if ((state & 0b10) != 0 /* is-active doUncached(DynamicObject) */) {
                if ((JSGuards.isJSObject(arg0Value_))) {
                    return doUncached(arg0Value_);
                }
            }
        }
        if ((state & 0b100) != 0 /* is-active doNonObject(Object) */) {
            if ((!(JSGuards.isJSObject(arg0Value)))) {
                return HasHiddenKeyCacheNode.doNonObject(arg0Value);
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
            if (JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if ((exclude) == 0 /* is-not-excluded doCached(DynamicObject, Shape, boolean, int) */) {
                    int count1_ = 0;
                    CachedData s1_ = this.cached_cache;
                    if ((state & 0b1) != 0 /* is-active doCached(DynamicObject, Shape, boolean, int) */) {
                        while (s1_ != null) {
                            if ((s1_.cachedShape_.check(arg0Value_)) && (s1_.assumption0_ == null || Assumption.isValidAssumption(s1_.assumption0_))) {
                                break;
                            }
                            s1_ = s1_.next_;
                            count1_++;
                        }
                    }
                    if (s1_ == null) {
                        {
                            Shape cachedShape__ = (arg0Value_.getShape());
                            if ((cachedShape__.check(arg0Value_))) {
                                Assumption assumption0 = (cachedShape__.getValidAssumption());
                                if (Assumption.isValidAssumption(assumption0)) {
                                    int cacheLimit__ = (getPropertyCacheLimit());
                                    if (count1_ < (cacheLimit__)) {
                                        s1_ = new CachedData(cached_cache);
                                        s1_.cachedShape_ = cachedShape__;
                                        s1_.hasOwnProperty_ = (doUncached(arg0Value_));
                                        s1_.cacheLimit_ = cacheLimit__;
                                        s1_.assumption0_ = assumption0;
                                        this.cached_cache = s1_;
                                        this.state_ = state = state | 0b1 /* add-active doCached(DynamicObject, Shape, boolean, int) */;
                                    }
                                }
                            }
                        }
                    }
                    if (s1_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return HasHiddenKeyCacheNode.doCached(arg0Value_, s1_.cachedShape_, s1_.hasOwnProperty_, s1_.cacheLimit_);
                    }
                }
                if ((JSGuards.isJSObject(arg0Value_))) {
                    this.exclude_ = exclude = exclude | 0b1 /* add-excluded doCached(DynamicObject, Shape, boolean, int) */;
                    this.cached_cache = null;
                    state = state & 0xfffffffe /* remove-active doCached(DynamicObject, Shape, boolean, int) */;
                    this.state_ = state = state | 0b10 /* add-active doUncached(DynamicObject) */;
                    lock.unlock();
                    hasLock = false;
                    return doUncached(arg0Value_);
                }
            }
            if ((!(JSGuards.isJSObject(arg0Value)))) {
                this.state_ = state = state | 0b100 /* add-active doNonObject(Object) */;
                lock.unlock();
                hasLock = false;
                return HasHiddenKeyCacheNode.doNonObject(arg0Value);
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
        if (state == 0b0) {
            return NodeCost.UNINITIALIZED;
        } else if ((state & (state - 1)) == 0 /* is-single-active  */) {
            CachedData s1_ = this.cached_cache;
            if ((s1_ == null || s1_.next_ == null)) {
                return NodeCost.MONOMORPHIC;
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    void removeCached_(Object s1_) {
        Lock lock = getLock();
        lock.lock();
        try {
            CachedData prev = null;
            CachedData cur = this.cached_cache;
            while (cur != null) {
                if (cur == s1_) {
                    if (prev == null) {
                        this.cached_cache = cur.next_;
                    } else {
                        prev.next_ = cur.next_;
                    }
                    break;
                }
                prev = cur;
                cur = cur.next_;
            }
            if (this.cached_cache == null) {
                this.state_ = this.state_ & 0xfffffffe /* remove-active doCached(DynamicObject, Shape, boolean, int) */;
            }
        } finally {
            lock.unlock();
        }
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[4];
        Object[] s;
        data[0] = 0;
        int state = state_;
        int exclude = exclude_;
        s = new Object[3];
        s[0] = "doCached";
        if ((state & 0b1) != 0 /* is-active doCached(DynamicObject, Shape, boolean, int) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            CachedData s1_ = this.cached_cache;
            while (s1_ != null) {
                cached.add(Arrays.asList(s1_.cachedShape_, s1_.hasOwnProperty_, s1_.cacheLimit_));
                s1_ = s1_.next_;
            }
            s[2] = cached;
        } else if (exclude != 0 /* is-excluded doCached(DynamicObject, Shape, boolean, int) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doUncached";
        if ((state & 0b10) != 0 /* is-active doUncached(DynamicObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doNonObject";
        if ((state & 0b100) != 0 /* is-active doNonObject(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        return Provider.create(data);
    }

    public static HasHiddenKeyCacheNode create(HiddenKey key) {
        return new HasHiddenKeyCacheNodeGen(key);
    }

    @GeneratedBy(HasHiddenKeyCacheNode.class)
    private static final class CachedData {

        @CompilationFinal CachedData next_;
        @CompilationFinal Shape cachedShape_;
        @CompilationFinal boolean hasOwnProperty_;
        @CompilationFinal int cacheLimit_;
        @CompilationFinal Assumption assumption0_;

        CachedData(CachedData next_) {
            this.next_ = next_;
        }

    }
}
