// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.builtins.JSGlobal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(DeclareGlobalVariableNode.class)
public final class DeclareGlobalVariableNodeGen extends DeclareGlobalVariableNode implements Provider {

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @Child private PropertySetNode cached_cache_;

    private DeclareGlobalVariableNodeGen(String varName, boolean configurable) {
        super(varName, configurable);
    }

    @Override
    protected void executeVoid(DynamicObject arg0Value, JSContext arg1Value) {
        int state = state_;
        if (state != 0 /* is-active doCached(DynamicObject, JSContext, PropertySetNode) || doUncached(DynamicObject, JSContext) */) {
            if ((state & 0b1) != 0 /* is-active doCached(DynamicObject, JSContext, PropertySetNode) */) {
                if ((arg1Value.getPropertyCacheLimit() > 0) && (JSGlobal.isJSGlobalObject(arg0Value))) {
                    doCached(arg0Value, arg1Value, this.cached_cache_);
                    return;
                }
            }
            if ((state & 0b10) != 0 /* is-active doUncached(DynamicObject, JSContext) */) {
                doUncached(arg0Value, arg1Value);
                return;
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        executeAndSpecialize(arg0Value, arg1Value);
        return;
    }

    private void executeAndSpecialize(DynamicObject arg0Value, JSContext arg1Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        int exclude = exclude_;
        try {
            if ((exclude) == 0 /* is-not-excluded doCached(DynamicObject, JSContext, PropertySetNode) */) {
                if ((arg1Value.getPropertyCacheLimit() > 0) && (JSGlobal.isJSGlobalObject(arg0Value))) {
                    this.cached_cache_ = super.insert((makeDefineOwnPropertyCache(arg1Value)));
                    this.state_ = state = state | 0b1 /* add-active doCached(DynamicObject, JSContext, PropertySetNode) */;
                    lock.unlock();
                    hasLock = false;
                    doCached(arg0Value, arg1Value, this.cached_cache_);
                    return;
                }
            }
            this.exclude_ = exclude = exclude | 0b1 /* add-excluded doCached(DynamicObject, JSContext, PropertySetNode) */;
            state = state & 0xfffffffe /* remove-active doCached(DynamicObject, JSContext, PropertySetNode) */;
            this.state_ = state = state | 0b10 /* add-active doUncached(DynamicObject, JSContext) */;
            lock.unlock();
            hasLock = false;
            doUncached(arg0Value, arg1Value);
            return;
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
        Object[] data = new Object[3];
        Object[] s;
        data[0] = 0;
        int state = state_;
        int exclude = exclude_;
        s = new Object[3];
        s[0] = "doCached";
        if ((state & 0b1) != 0 /* is-active doCached(DynamicObject, JSContext, PropertySetNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.cached_cache_));
            s[2] = cached;
        } else if (exclude != 0 /* is-excluded doCached(DynamicObject, JSContext, PropertySetNode) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doUncached";
        if ((state & 0b10) != 0 /* is-active doUncached(DynamicObject, JSContext) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        return Provider.create(data);
    }

    public static DeclareGlobalVariableNode create(String varName, boolean configurable) {
        return new DeclareGlobalVariableNodeGen(varName, configurable);
    }

}
