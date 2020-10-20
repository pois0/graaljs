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
import com.oracle.truffle.api.object.Shape;
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.js.nodes.JSTypes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(GlobalScopeLookupNode.class)
public final class GlobalScopeLookupNodeGen extends GlobalScopeLookupNode implements Provider {

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private Assumption absent_assumption_;
    @CompilationFinal private Assumption absent_assumption0_;
    @CompilationFinal private CachedData cached_cache;
    @CompilationFinal private BranchProfile uncached_errorBranch_;

    private GlobalScopeLookupNodeGen(String varName, boolean write) {
        super(varName, write);
    }

    @ExplodeLoop
    @Override
    public boolean execute(Object arg0Value) {
        int state = state_;
        if (state != 0 /* is-active doAbsent(DynamicObject, Assumption) || doCached(DynamicObject, Shape, boolean, boolean, boolean, int) || doUncached(DynamicObject, BranchProfile) */ && JSTypes.isDynamicObject(arg0Value)) {
            DynamicObject arg0Value_ = (DynamicObject) arg0Value;
            if ((state & 0b1) != 0 /* is-active doAbsent(DynamicObject, Assumption) */) {
                if (!Assumption.isValidAssumption(this.absent_assumption0_)) {
                    CompilerDirectives.transferToInterpreterAndInvalidate();
                    removeAbsent_();
                    return executeAndSpecialize(arg0Value_);
                }
                return GlobalScopeLookupNode.doAbsent(arg0Value_, this.absent_assumption_);
            }
            if ((state & 0b10) != 0 /* is-active doCached(DynamicObject, Shape, boolean, boolean, boolean, int) */) {
                CachedData s2_ = this.cached_cache;
                while (s2_ != null) {
                    if (!Assumption.isValidAssumption(s2_.assumption0_)) {
                        CompilerDirectives.transferToInterpreterAndInvalidate();
                        removeCached_(s2_);
                        return executeAndSpecialize(arg0Value_);
                    }
                    if ((arg0Value_.getShape() == s2_.cachedShape_)) {
                        return doCached(arg0Value_, s2_.cachedShape_, s2_.exists_, s2_.dead_, s2_.constAssignment_, s2_.cacheLimit_);
                    }
                    s2_ = s2_.next_;
                }
            }
            if ((state & 0b100) != 0 /* is-active doUncached(DynamicObject, BranchProfile) */) {
                return doUncached(arg0Value_, this.uncached_errorBranch_);
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
                if (((exclude & 0b1)) == 0 /* is-not-excluded doAbsent(DynamicObject, Assumption) */) {
                    {
                        Assumption absent_assumption__ = (getAbsentPropertyAssumption(arg0Value_.getShape()));
                        Assumption absent_assumption0 = (absent_assumption__);
                        if (Assumption.isValidAssumption(absent_assumption0)) {
                            this.absent_assumption_ = absent_assumption__;
                            this.absent_assumption0_ = absent_assumption0;
                            this.state_ = state = state | 0b1 /* add-active doAbsent(DynamicObject, Assumption) */;
                            lock.unlock();
                            hasLock = false;
                            return GlobalScopeLookupNode.doAbsent(arg0Value_, absent_assumption__);
                        }
                    }
                }
                if (((exclude & 0b10)) == 0 /* is-not-excluded doCached(DynamicObject, Shape, boolean, boolean, boolean, int) */) {
                    int count2_ = 0;
                    CachedData s2_ = this.cached_cache;
                    if ((state & 0b10) != 0 /* is-active doCached(DynamicObject, Shape, boolean, boolean, boolean, int) */) {
                        while (s2_ != null) {
                            if ((arg0Value_.getShape() == s2_.cachedShape_) && (s2_.assumption0_ == null || Assumption.isValidAssumption(s2_.assumption0_))) {
                                break;
                            }
                            s2_ = s2_.next_;
                            count2_++;
                        }
                    }
                    if (s2_ == null) {
                        {
                            Shape cachedShape__ = (arg0Value_.getShape());
                            if ((arg0Value_.getShape() == cachedShape__)) {
                                Assumption assumption0 = (cachedShape__.getValidAssumption());
                                if (Assumption.isValidAssumption(assumption0)) {
                                    int cacheLimit__ = (getPropertyCacheLimit());
                                    if (count2_ < (cacheLimit__)) {
                                        s2_ = new CachedData(cached_cache);
                                        s2_.cachedShape_ = cachedShape__;
                                        s2_.exists_ = (cachedShape__.hasProperty(varName));
                                        s2_.dead_ = (isDead(cachedShape__));
                                        s2_.constAssignment_ = (isConstAssignment(cachedShape__));
                                        s2_.cacheLimit_ = cacheLimit__;
                                        s2_.assumption0_ = assumption0;
                                        this.cached_cache = s2_;
                                        this.exclude_ = exclude = exclude | 0b1 /* add-excluded doAbsent(DynamicObject, Assumption) */;
                                        state = state & 0xfffffffe /* remove-active doAbsent(DynamicObject, Assumption) */;
                                        this.state_ = state = state | 0b10 /* add-active doCached(DynamicObject, Shape, boolean, boolean, boolean, int) */;
                                    }
                                }
                            }
                        }
                    }
                    if (s2_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return doCached(arg0Value_, s2_.cachedShape_, s2_.exists_, s2_.dead_, s2_.constAssignment_, s2_.cacheLimit_);
                    }
                }
                this.uncached_errorBranch_ = (BranchProfile.create());
                this.exclude_ = exclude = exclude | 0b11 /* add-excluded doAbsent(DynamicObject, Assumption), doCached(DynamicObject, Shape, boolean, boolean, boolean, int) */;
                this.cached_cache = null;
                state = state & 0xfffffffc /* remove-active doAbsent(DynamicObject, Assumption), doCached(DynamicObject, Shape, boolean, boolean, boolean, int) */;
                this.state_ = state = state | 0b100 /* add-active doUncached(DynamicObject, BranchProfile) */;
                lock.unlock();
                hasLock = false;
                return doUncached(arg0Value_, this.uncached_errorBranch_);
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
            CachedData s2_ = this.cached_cache;
            if ((s2_ == null || s2_.next_ == null)) {
                return NodeCost.MONOMORPHIC;
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    void removeCached_(Object s2_) {
        Lock lock = getLock();
        lock.lock();
        try {
            CachedData prev = null;
            CachedData cur = this.cached_cache;
            while (cur != null) {
                if (cur == s2_) {
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
                this.state_ = this.state_ & 0xfffffffd /* remove-active doCached(DynamicObject, Shape, boolean, boolean, boolean, int) */;
            }
        } finally {
            lock.unlock();
        }
    }

    void removeAbsent_() {
        Lock lock = getLock();
        lock.lock();
        try {
            this.state_ = this.state_ & 0xfffffffe /* remove-active doAbsent(DynamicObject, Assumption) */;
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
        s[0] = "doAbsent";
        if ((state & 0b1) != 0 /* is-active doAbsent(DynamicObject, Assumption) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.absent_assumption_));
            s[2] = cached;
        } else if ((exclude & 0b1) != 0 /* is-excluded doAbsent(DynamicObject, Assumption) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doCached";
        if ((state & 0b10) != 0 /* is-active doCached(DynamicObject, Shape, boolean, boolean, boolean, int) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            CachedData s2_ = this.cached_cache;
            while (s2_ != null) {
                cached.add(Arrays.asList(s2_.cachedShape_, s2_.exists_, s2_.dead_, s2_.constAssignment_, s2_.cacheLimit_));
                s2_ = s2_.next_;
            }
            s[2] = cached;
        } else if ((exclude & 0b10) != 0 /* is-excluded doCached(DynamicObject, Shape, boolean, boolean, boolean, int) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doUncached";
        if ((state & 0b100) != 0 /* is-active doUncached(DynamicObject, BranchProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.uncached_errorBranch_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        return Provider.create(data);
    }

    public static GlobalScopeLookupNode create(String varName, boolean write) {
        return new GlobalScopeLookupNodeGen(varName, write);
    }

    @GeneratedBy(GlobalScopeLookupNode.class)
    private static final class CachedData {

        @CompilationFinal CachedData next_;
        @CompilationFinal Shape cachedShape_;
        @CompilationFinal boolean exists_;
        @CompilationFinal boolean dead_;
        @CompilationFinal boolean constAssignment_;
        @CompilationFinal int cacheLimit_;
        @CompilationFinal Assumption assumption0_;

        CachedData(CachedData next_) {
            this.next_ = next_;
        }

    }
}
