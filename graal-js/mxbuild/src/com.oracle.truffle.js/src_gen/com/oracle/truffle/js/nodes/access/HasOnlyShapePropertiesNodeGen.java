// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.builtins.JSClass;
import com.oracle.truffle.js.runtime.objects.JSObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(HasOnlyShapePropertiesNode.class)
public final class HasOnlyShapePropertiesNodeGen extends HasOnlyShapePropertiesNode implements Provider {

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private CachedData cached_cache;
    @CompilationFinal private JSContext objectPrototype_context_;

    private HasOnlyShapePropertiesNodeGen() {
    }

    @ExplodeLoop
    @Override
    public boolean execute(DynamicObject arg0Value, JSClass arg1Value) {
        int state = state_;
        if (state != 0 /* is-active doCached(DynamicObject, JSClass, JSClass) || doObjectPrototype(DynamicObject, JSClass, JSContext) || doUncached(DynamicObject, JSClass) */) {
            if ((state & 0b1) != 0 /* is-active doCached(DynamicObject, JSClass, JSClass) */) {
                CachedData s1_ = this.cached_cache;
                while (s1_ != null) {
                    if ((arg1Value == s1_.cachedJSClass_)) {
                        assert (!(HasOnlyShapePropertiesNode.isJSObjectPrototype(s1_.cachedJSClass_)));
                        return HasOnlyShapePropertiesNode.doCached(arg0Value, arg1Value, s1_.cachedJSClass_);
                    }
                    s1_ = s1_.next_;
                }
            }
            if ((state & 0b10) != 0 /* is-active doObjectPrototype(DynamicObject, JSClass, JSContext) */) {
                if ((HasOnlyShapePropertiesNode.isJSObjectPrototype(arg1Value))) {
                    return HasOnlyShapePropertiesNode.doObjectPrototype(arg0Value, arg1Value, this.objectPrototype_context_);
                }
            }
            if ((state & 0b100) != 0 /* is-active doUncached(DynamicObject, JSClass) */) {
                return HasOnlyShapePropertiesNode.doUncached(arg0Value, arg1Value);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value);
    }

    private boolean executeAndSpecialize(DynamicObject arg0Value, JSClass arg1Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        int exclude = exclude_;
        try {
            if (((exclude & 0b1)) == 0 /* is-not-excluded doCached(DynamicObject, JSClass, JSClass) */) {
                int count1_ = 0;
                CachedData s1_ = this.cached_cache;
                if ((state & 0b1) != 0 /* is-active doCached(DynamicObject, JSClass, JSClass) */) {
                    while (s1_ != null) {
                        if ((arg1Value == s1_.cachedJSClass_)) {
                            assert (!(HasOnlyShapePropertiesNode.isJSObjectPrototype(s1_.cachedJSClass_)));
                            break;
                        }
                        s1_ = s1_.next_;
                        count1_++;
                    }
                }
                if (s1_ == null) {
                    {
                        JSClass cachedJSClass__ = (arg1Value);
                        // assert (arg1Value == s1_.cachedJSClass_);
                        if ((!(HasOnlyShapePropertiesNode.isJSObjectPrototype(cachedJSClass__))) && count1_ < (5)) {
                            s1_ = new CachedData(cached_cache);
                            s1_.cachedJSClass_ = cachedJSClass__;
                            this.cached_cache = s1_;
                            this.state_ = state = state | 0b1 /* add-active doCached(DynamicObject, JSClass, JSClass) */;
                        }
                    }
                }
                if (s1_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return HasOnlyShapePropertiesNode.doCached(arg0Value, arg1Value, s1_.cachedJSClass_);
                }
            }
            if (((exclude & 0b10)) == 0 /* is-not-excluded doObjectPrototype(DynamicObject, JSClass, JSContext) */) {
                if ((HasOnlyShapePropertiesNode.isJSObjectPrototype(arg1Value))) {
                    this.objectPrototype_context_ = (JSObject.getJSContext(arg0Value));
                    this.state_ = state = state | 0b10 /* add-active doObjectPrototype(DynamicObject, JSClass, JSContext) */;
                    lock.unlock();
                    hasLock = false;
                    return HasOnlyShapePropertiesNode.doObjectPrototype(arg0Value, arg1Value, this.objectPrototype_context_);
                }
            }
            this.exclude_ = exclude = exclude | 0b11 /* add-excluded doCached(DynamicObject, JSClass, JSClass), doObjectPrototype(DynamicObject, JSClass, JSContext) */;
            this.cached_cache = null;
            state = state & 0xfffffffc /* remove-active doCached(DynamicObject, JSClass, JSClass), doObjectPrototype(DynamicObject, JSClass, JSContext) */;
            this.state_ = state = state | 0b100 /* add-active doUncached(DynamicObject, JSClass) */;
            lock.unlock();
            hasLock = false;
            return HasOnlyShapePropertiesNode.doUncached(arg0Value, arg1Value);
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

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[4];
        Object[] s;
        data[0] = 0;
        int state = state_;
        int exclude = exclude_;
        s = new Object[3];
        s[0] = "doCached";
        if ((state & 0b1) != 0 /* is-active doCached(DynamicObject, JSClass, JSClass) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            CachedData s1_ = this.cached_cache;
            while (s1_ != null) {
                cached.add(Arrays.asList(s1_.cachedJSClass_));
                s1_ = s1_.next_;
            }
            s[2] = cached;
        } else if ((exclude & 0b1) != 0 /* is-excluded doCached(DynamicObject, JSClass, JSClass) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doObjectPrototype";
        if ((state & 0b10) != 0 /* is-active doObjectPrototype(DynamicObject, JSClass, JSContext) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.objectPrototype_context_));
            s[2] = cached;
        } else if ((exclude & 0b10) != 0 /* is-excluded doObjectPrototype(DynamicObject, JSClass, JSContext) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doUncached";
        if ((state & 0b100) != 0 /* is-active doUncached(DynamicObject, JSClass) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        return Provider.create(data);
    }

    public static HasOnlyShapePropertiesNode create() {
        return new HasOnlyShapePropertiesNodeGen();
    }

    @GeneratedBy(HasOnlyShapePropertiesNode.class)
    private static final class CachedData {

        @CompilationFinal CachedData next_;
        @CompilationFinal JSClass cachedJSClass_;

        CachedData(CachedData next_) {
            this.next_ = next_;
        }

    }
}
