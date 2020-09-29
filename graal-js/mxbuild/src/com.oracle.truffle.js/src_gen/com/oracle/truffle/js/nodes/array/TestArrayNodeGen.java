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
import com.oracle.truffle.js.runtime.array.ScriptArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(TestArrayNode.class)
public final class TestArrayNodeGen extends TestArrayNode implements Provider {

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private CachedData cached_cache;

    private TestArrayNodeGen(Test test) {
        super(test);
    }

    @ExplodeLoop
    @Override
    public boolean executeBoolean(DynamicObject arg0Value) {
        int state = state_;
        if (state != 0 /* is-active doCached(DynamicObject, ScriptArray) || doUncached(DynamicObject) */) {
            if ((state & 0b1) != 0 /* is-active doCached(DynamicObject, ScriptArray) */) {
                CachedData s1_ = this.cached_cache;
                while (s1_ != null) {
                    if ((s1_.arrayType_.isInstance(TestArrayNode.getArrayType(arg0Value)))) {
                        assert (s1_.arrayType_.isStatelessType());
                        return doCached(arg0Value, s1_.arrayType_);
                    }
                    s1_ = s1_.next_;
                }
            }
            if ((state & 0b10) != 0 /* is-active doUncached(DynamicObject) */) {
                return doUncached(arg0Value);
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
            if ((exclude) == 0 /* is-not-excluded doCached(DynamicObject, ScriptArray) */) {
                int count1_ = 0;
                CachedData s1_ = this.cached_cache;
                if ((state & 0b1) != 0 /* is-active doCached(DynamicObject, ScriptArray) */) {
                    while (s1_ != null) {
                        if ((s1_.arrayType_.isInstance(TestArrayNode.getArrayType(arg0Value)))) {
                            assert (s1_.arrayType_.isStatelessType());
                            break;
                        }
                        s1_ = s1_.next_;
                        count1_++;
                    }
                }
                if (s1_ == null) {
                    {
                        ScriptArray arrayType__ = (TestArrayNode.getArrayType(arg0Value));
                        if ((arrayType__.isInstance(TestArrayNode.getArrayType(arg0Value))) && (arrayType__.isStatelessType()) && count1_ < (TestArrayNode.MAX_TYPE_COUNT)) {
                            s1_ = new CachedData(cached_cache);
                            s1_.arrayType_ = arrayType__;
                            this.cached_cache = s1_;
                            this.state_ = state = state | 0b1 /* add-active doCached(DynamicObject, ScriptArray) */;
                        }
                    }
                }
                if (s1_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return doCached(arg0Value, s1_.arrayType_);
                }
            }
            this.exclude_ = exclude = exclude | 0b1 /* add-excluded doCached(DynamicObject, ScriptArray) */;
            this.cached_cache = null;
            state = state & 0xfffffffe /* remove-active doCached(DynamicObject, ScriptArray) */;
            this.state_ = state = state | 0b10 /* add-active doUncached(DynamicObject) */;
            lock.unlock();
            hasLock = false;
            return doUncached(arg0Value);
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
        if ((state & 0b1) != 0 /* is-active doCached(DynamicObject, ScriptArray) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            CachedData s1_ = this.cached_cache;
            while (s1_ != null) {
                cached.add(Arrays.asList(s1_.arrayType_));
                s1_ = s1_.next_;
            }
            s[2] = cached;
        } else if (exclude != 0 /* is-excluded doCached(DynamicObject, ScriptArray) */) {
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
        return Provider.create(data);
    }

    public static TestArrayNode create(Test test) {
        return new TestArrayNodeGen(test);
    }

    @GeneratedBy(TestArrayNode.class)
    private static final class CachedData {

        @CompilationFinal CachedData next_;
        @CompilationFinal ScriptArray arrayType_;

        CachedData(CachedData next_) {
            this.next_ = next_;
        }

    }
}
