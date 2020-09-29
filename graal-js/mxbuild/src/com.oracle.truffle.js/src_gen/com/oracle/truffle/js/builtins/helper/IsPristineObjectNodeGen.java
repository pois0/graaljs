// CheckStyle: start generated
package com.oracle.truffle.js.builtins.helper;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.object.Shape;
import com.oracle.truffle.js.runtime.builtins.JSClass;
import java.util.concurrent.locks.Lock;

@GeneratedBy(IsPristineObjectNode.class)
public final class IsPristineObjectNodeGen extends IsPristineObjectNode {

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private CachedData cached_cache;
    @CompilationFinal(dimensions = 1) private Assumption[] dynamic_assumption0_;

    private IsPristineObjectNodeGen(JSClass jsClass, Shape initialPrototypeShape, Object... propertyKeys) {
        super(jsClass, initialPrototypeShape, propertyKeys);
    }

    @ExplodeLoop
    @Override
    public boolean execute(DynamicObject arg0Value) {
        int state = state_;
        if (state != 0 /* is-active doCached(DynamicObject, Shape, boolean) || doDynamic(DynamicObject) || doAssumptionsInvalid(DynamicObject) */) {
            if ((state & 0b1) != 0 /* is-active doCached(DynamicObject, Shape, boolean) */) {
                CachedData s1_ = this.cached_cache;
                while (s1_ != null) {
                    if (!Assumption.isValidAssumption(s1_.assumption0_)) {
                        CompilerDirectives.transferToInterpreterAndInvalidate();
                        removeCached_(s1_);
                        return executeAndSpecialize(arg0Value);
                    }
                    if ((s1_.cachedShape_.check(arg0Value))) {
                        return doCached(arg0Value, s1_.cachedShape_, s1_.isInstanceAndDoesNotOverwriteProps_);
                    }
                    s1_ = s1_.next_;
                }
            }
            if ((state & 0b10) != 0 /* is-active doDynamic(DynamicObject) */) {
                if (!Assumption.isValidAssumption(this.dynamic_assumption0_)) {
                    CompilerDirectives.transferToInterpreterAndInvalidate();
                    removeDynamic_();
                    return executeAndSpecialize(arg0Value);
                }
                return doDynamic(arg0Value);
            }
            if ((state & 0b100) != 0 /* is-active doAssumptionsInvalid(DynamicObject) */) {
                return doAssumptionsInvalid(arg0Value);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    private boolean executeAndSpecialize(DynamicObject arg0Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        int exclude = exclude_;
        try {
            if ((exclude) == 0 /* is-not-excluded doCached(DynamicObject, Shape, boolean) */) {
                int count1_ = 0;
                CachedData s1_ = this.cached_cache;
                if ((state & 0b1) != 0 /* is-active doCached(DynamicObject, Shape, boolean) */) {
                    while (s1_ != null) {
                        if ((s1_.cachedShape_.check(arg0Value)) && (s1_.assumption0_ == null || Assumption.isValidAssumption(s1_.assumption0_))) {
                            break;
                        }
                        s1_ = s1_.next_;
                        count1_++;
                    }
                }
                if (s1_ == null) {
                    {
                        Shape cachedShape__ = (arg0Value.getShape());
                        if ((cachedShape__.check(arg0Value))) {
                            Assumption[] assumption0 = (getPropertyFinalAssumptions());
                            if (Assumption.isValidAssumption(assumption0)) {
                                if (count1_ < (3)) {
                                    s1_ = new CachedData(cached_cache);
                                    s1_.cachedShape_ = cachedShape__;
                                    s1_.isInstanceAndDoesNotOverwriteProps_ = (isInstanceAndDoesNotOverwriteProps(cachedShape__));
                                    s1_.assumption0_ = assumption0;
                                    this.cached_cache = s1_;
                                    this.state_ = state = state | 0b1 /* add-active doCached(DynamicObject, Shape, boolean) */;
                                }
                            }
                        }
                    }
                }
                if (s1_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return doCached(arg0Value, s1_.cachedShape_, s1_.isInstanceAndDoesNotOverwriteProps_);
                }
            }
            {
                Assumption[] dynamic_assumption0 = (getPropertyFinalAssumptions());
                if (Assumption.isValidAssumption(dynamic_assumption0)) {
                    this.dynamic_assumption0_ = dynamic_assumption0;
                    this.exclude_ = exclude = exclude | 0b1 /* add-excluded doCached(DynamicObject, Shape, boolean) */;
                    this.cached_cache = null;
                    state = state & 0xfffffffe /* remove-active doCached(DynamicObject, Shape, boolean) */;
                    this.state_ = state = state | 0b10 /* add-active doDynamic(DynamicObject) */;
                    lock.unlock();
                    hasLock = false;
                    return doDynamic(arg0Value);
                }
            }
            this.state_ = state = state | 0b100 /* add-active doAssumptionsInvalid(DynamicObject) */;
            lock.unlock();
            hasLock = false;
            return doAssumptionsInvalid(arg0Value);
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

    void removeDynamic_() {
        Lock lock = getLock();
        lock.lock();
        try {
            this.state_ = this.state_ & 0xfffffffd /* remove-active doDynamic(DynamicObject) */;
        } finally {
            lock.unlock();
        }
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
                this.state_ = this.state_ & 0xfffffffe /* remove-active doCached(DynamicObject, Shape, boolean) */;
            }
        } finally {
            lock.unlock();
        }
    }

    public static IsPristineObjectNode create(JSClass jsClass, Shape initialPrototypeShape, Object... propertyKeys) {
        return new IsPristineObjectNodeGen(jsClass, initialPrototypeShape, propertyKeys);
    }

    @GeneratedBy(IsPristineObjectNode.class)
    private static final class CachedData {

        @CompilationFinal CachedData next_;
        @CompilationFinal Shape cachedShape_;
        @CompilationFinal boolean isInstanceAndDoesNotOverwriteProps_;
        @CompilationFinal(dimensions = 1) Assumption[] assumption0_;

        CachedData(CachedData next_) {
            this.next_ = next_;
        }

    }
}
