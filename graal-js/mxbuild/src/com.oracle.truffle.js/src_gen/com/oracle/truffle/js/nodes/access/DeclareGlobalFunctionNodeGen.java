// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.builtins.JSGlobal;
import com.oracle.truffle.js.runtime.objects.PropertyDescriptor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(DeclareGlobalFunctionNode.class)
public final class DeclareGlobalFunctionNodeGen extends DeclareGlobalFunctionNode implements Provider {

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @Child private PropertySetNode cached_cache_;

    private DeclareGlobalFunctionNodeGen(String varName, boolean configurable, JavaScriptNode valueNode) {
        super(varName, configurable, valueNode);
    }

    @Override
    protected void executeVoid(DynamicObject arg0Value, Object arg1Value, PropertyDescriptor arg2Value, JSContext arg3Value) {
        int state = state_;
        if (state != 0 /* is-active doCached(DynamicObject, Object, PropertyDescriptor, JSContext, PropertySetNode) || doUncached(DynamicObject, Object, PropertyDescriptor, JSContext) */) {
            if ((state & 0b1) != 0 /* is-active doCached(DynamicObject, Object, PropertyDescriptor, JSContext, PropertySetNode) */) {
                if ((arg3Value.getPropertyCacheLimit() > 0) && (JSGlobal.isJSGlobalObject(arg0Value)) && (arg2Value == null)) {
                    doCached(arg0Value, arg1Value, arg2Value, arg3Value, this.cached_cache_);
                    return;
                }
            }
            if ((state & 0b10) != 0 /* is-active doUncached(DynamicObject, Object, PropertyDescriptor, JSContext) */) {
                doUncached(arg0Value, arg1Value, arg2Value, arg3Value);
                return;
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        executeAndSpecialize(arg0Value, arg1Value, arg2Value, arg3Value);
        return;
    }

    private void executeAndSpecialize(DynamicObject arg0Value, Object arg1Value, PropertyDescriptor arg2Value, JSContext arg3Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        int exclude = exclude_;
        try {
            if ((exclude) == 0 /* is-not-excluded doCached(DynamicObject, Object, PropertyDescriptor, JSContext, PropertySetNode) */) {
                if ((arg3Value.getPropertyCacheLimit() > 0) && (JSGlobal.isJSGlobalObject(arg0Value)) && (arg2Value == null)) {
                    this.cached_cache_ = super.insert((makeDefineOwnPropertyCache(arg3Value)));
                    this.state_ = state = state | 0b1 /* add-active doCached(DynamicObject, Object, PropertyDescriptor, JSContext, PropertySetNode) */;
                    lock.unlock();
                    hasLock = false;
                    doCached(arg0Value, arg1Value, arg2Value, arg3Value, this.cached_cache_);
                    return;
                }
            }
            this.exclude_ = exclude = exclude | 0b1 /* add-excluded doCached(DynamicObject, Object, PropertyDescriptor, JSContext, PropertySetNode) */;
            state = state & 0xfffffffe /* remove-active doCached(DynamicObject, Object, PropertyDescriptor, JSContext, PropertySetNode) */;
            this.state_ = state = state | 0b10 /* add-active doUncached(DynamicObject, Object, PropertyDescriptor, JSContext) */;
            lock.unlock();
            hasLock = false;
            doUncached(arg0Value, arg1Value, arg2Value, arg3Value);
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
        if ((state & 0b1) != 0 /* is-active doCached(DynamicObject, Object, PropertyDescriptor, JSContext, PropertySetNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.cached_cache_));
            s[2] = cached;
        } else if (exclude != 0 /* is-excluded doCached(DynamicObject, Object, PropertyDescriptor, JSContext, PropertySetNode) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doUncached";
        if ((state & 0b10) != 0 /* is-active doUncached(DynamicObject, Object, PropertyDescriptor, JSContext) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        return Provider.create(data);
    }

    public static DeclareGlobalFunctionNode create(String varName, boolean configurable, JavaScriptNode valueNode) {
        return new DeclareGlobalFunctionNodeGen(varName, configurable, valueNode);
    }

}
