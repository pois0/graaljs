// CheckStyle: start generated
package com.oracle.truffle.js.nodes.function;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.access.PropertySetNode;
import com.oracle.truffle.js.runtime.JSContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(CreateMethodPropertyNode.class)
public final class CreateMethodPropertyNodeGen extends CreateMethodPropertyNode implements Provider {

    @CompilationFinal private volatile int state_;
    @Child private PropertySetNode cached_propertyCache_;

    private CreateMethodPropertyNodeGen(JSContext context, Object key) {
        super(context, key);
    }

    @Override
    public void executeVoid(Object arg0Value, Object arg1Value) {
        int state = state_;
        if (state != 0 /* is-active doCached(Object, Object, PropertySetNode) || doUncached(DynamicObject, Object) || doNonObject(Object, Object) */) {
            if ((state & 0b1) != 0 /* is-active doCached(Object, Object, PropertySetNode) */) {
                assert (context.getPropertyCacheLimit() > 0);
                if ((isObject.executeBoolean(arg0Value))) {
                    CreateMethodPropertyNode.doCached(arg0Value, arg1Value, this.cached_propertyCache_);
                    return;
                }
            }
            if ((state & 0b10) != 0 /* is-active doUncached(DynamicObject, Object) */ && JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                assert (context.getPropertyCacheLimit() == 0);
                if ((JSGuards.isJSObject(arg0Value_))) {
                    doUncached(arg0Value_, arg1Value);
                    return;
                }
            }
            if ((state & 0b100) != 0 /* is-active doNonObject(Object, Object) */) {
                if ((!(JSGuards.isJSObject(arg0Value)))) {
                    doNonObject(arg0Value, arg1Value);
                    return;
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        executeAndSpecialize(arg0Value, arg1Value);
        return;
    }

    private void executeAndSpecialize(Object arg0Value, Object arg1Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        try {
            if ((context.getPropertyCacheLimit() > 0) && (isObject.executeBoolean(arg0Value))) {
                this.cached_propertyCache_ = super.insert((makeDefinePropertyCache()));
                this.state_ = state = state | 0b1 /* add-active doCached(Object, Object, PropertySetNode) */;
                lock.unlock();
                hasLock = false;
                CreateMethodPropertyNode.doCached(arg0Value, arg1Value, this.cached_propertyCache_);
                return;
            }
            if (JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if ((context.getPropertyCacheLimit() == 0) && (JSGuards.isJSObject(arg0Value_))) {
                    this.state_ = state = state | 0b10 /* add-active doUncached(DynamicObject, Object) */;
                    lock.unlock();
                    hasLock = false;
                    doUncached(arg0Value_, arg1Value);
                    return;
                }
            }
            if ((!(JSGuards.isJSObject(arg0Value)))) {
                this.state_ = state = state | 0b100 /* add-active doNonObject(Object, Object) */;
                lock.unlock();
                hasLock = false;
                doNonObject(arg0Value, arg1Value);
                return;
            }
            throw new UnsupportedSpecializationException(this, new Node[] {null, null}, arg0Value, arg1Value);
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
        Object[] data = new Object[4];
        Object[] s;
        data[0] = 0;
        int state = state_;
        s = new Object[3];
        s[0] = "doCached";
        if ((state & 0b1) != 0 /* is-active doCached(Object, Object, PropertySetNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.cached_propertyCache_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doUncached";
        if ((state & 0b10) != 0 /* is-active doUncached(DynamicObject, Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doNonObject";
        if ((state & 0b100) != 0 /* is-active doNonObject(Object, Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        return Provider.create(data);
    }

    public static CreateMethodPropertyNode create(JSContext context, Object key) {
        return new CreateMethodPropertyNodeGen(context, key);
    }

}
