// CheckStyle: start generated
package com.oracle.truffle.js.nodes.array;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.array.ScriptArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSArrayDeleteIndexNode.class)
public final class JSArrayDeleteIndexNodeGen extends JSArrayDeleteIndexNode implements Provider {

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private CachedData cached_cache;

    private JSArrayDeleteIndexNodeGen(JSContext context, boolean strict) {
        super(context, strict);
    }

    @ExplodeLoop
    @Override
    public boolean execute(DynamicObject arg0Value, ScriptArray arg1Value, long arg2Value) {
        int state = state_;
        if (state != 0 /* is-active doCached(DynamicObject, ScriptArray, long, ScriptArray) || doUncached(DynamicObject, ScriptArray, long) */) {
            if ((state & 0b1) != 0 /* is-active doCached(DynamicObject, ScriptArray, long, ScriptArray) */) {
                CachedData s1_ = this.cached_cache;
                while (s1_ != null) {
                    if ((s1_.cachedArrayType_.isInstance(arg1Value))) {
                        return doCached(arg0Value, arg1Value, arg2Value, s1_.cachedArrayType_);
                    }
                    s1_ = s1_.next_;
                }
            }
            if ((state & 0b10) != 0 /* is-active doUncached(DynamicObject, ScriptArray, long) */) {
                return doUncached(arg0Value, arg1Value, arg2Value);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value, arg2Value);
    }

    private boolean executeAndSpecialize(DynamicObject arg0Value, ScriptArray arg1Value, long arg2Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        int exclude = exclude_;
        try {
            if ((exclude) == 0 /* is-not-excluded doCached(DynamicObject, ScriptArray, long, ScriptArray) */) {
                int count1_ = 0;
                CachedData s1_ = this.cached_cache;
                if ((state & 0b1) != 0 /* is-active doCached(DynamicObject, ScriptArray, long, ScriptArray) */) {
                    while (s1_ != null) {
                        if ((s1_.cachedArrayType_.isInstance(arg1Value))) {
                            break;
                        }
                        s1_ = s1_.next_;
                        count1_++;
                    }
                }
                if (s1_ == null) {
                    {
                        ScriptArray cachedArrayType__ = (arg1Value);
                        if ((cachedArrayType__.isInstance(arg1Value)) && count1_ < (5)) {
                            s1_ = new CachedData(cached_cache);
                            s1_.cachedArrayType_ = cachedArrayType__;
                            this.cached_cache = s1_;
                            this.state_ = state = state | 0b1 /* add-active doCached(DynamicObject, ScriptArray, long, ScriptArray) */;
                        }
                    }
                }
                if (s1_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return doCached(arg0Value, arg1Value, arg2Value, s1_.cachedArrayType_);
                }
            }
            this.exclude_ = exclude = exclude | 0b1 /* add-excluded doCached(DynamicObject, ScriptArray, long, ScriptArray) */;
            this.cached_cache = null;
            state = state & 0xfffffffe /* remove-active doCached(DynamicObject, ScriptArray, long, ScriptArray) */;
            this.state_ = state = state | 0b10 /* add-active doUncached(DynamicObject, ScriptArray, long) */;
            lock.unlock();
            hasLock = false;
            return doUncached(arg0Value, arg1Value, arg2Value);
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
        Object[] data = new Object[3];
        Object[] s;
        data[0] = 0;
        int state = state_;
        int exclude = exclude_;
        s = new Object[3];
        s[0] = "doCached";
        if ((state & 0b1) != 0 /* is-active doCached(DynamicObject, ScriptArray, long, ScriptArray) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            CachedData s1_ = this.cached_cache;
            while (s1_ != null) {
                cached.add(Arrays.asList(s1_.cachedArrayType_));
                s1_ = s1_.next_;
            }
            s[2] = cached;
        } else if (exclude != 0 /* is-excluded doCached(DynamicObject, ScriptArray, long, ScriptArray) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doUncached";
        if ((state & 0b10) != 0 /* is-active doUncached(DynamicObject, ScriptArray, long) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        return Provider.create(data);
    }

    public static JSArrayDeleteIndexNode create(JSContext context, boolean strict) {
        return new JSArrayDeleteIndexNodeGen(context, strict);
    }

    @GeneratedBy(JSArrayDeleteIndexNode.class)
    private static final class CachedData {

        @CompilationFinal CachedData next_;
        @CompilationFinal ScriptArray cachedArrayType_;

        CachedData(CachedData next_) {
            this.next_ = next_;
        }

    }
}
