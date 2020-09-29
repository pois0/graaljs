// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.object.Shape;
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.runtime.builtins.JSClass;
import com.oracle.truffle.js.runtime.objects.JSShape;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(IsExtensibleNode.class)
public final class IsExtensibleNodeGen extends IsExtensibleNode implements Provider {

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private ConditionProfile resultProfile;
    @CompilationFinal private Shape cachedShape_cachedShape_;
    @CompilationFinal private boolean cachedShape_result_;
    @CompilationFinal private JSClass cachedJSClass_cachedJSClass_;

    private IsExtensibleNodeGen() {
    }

    @Override
    public boolean executeBoolean(DynamicObject arg0Value) {
        int state = state_;
        if (state != 0 /* is-active doCachedShape(DynamicObject, Shape, boolean) || doCachedJSClass(DynamicObject, JSClass, ConditionProfile) || doUncached(DynamicObject, ConditionProfile) */) {
            if ((state & 0b1) != 0 /* is-active doCachedShape(DynamicObject, Shape, boolean) */) {
                assert (JSShape.getJSClass(this.cachedShape_cachedShape_).usesOrdinaryIsExtensible());
                if ((this.cachedShape_cachedShape_.check(arg0Value))) {
                    return IsExtensibleNode.doCachedShape(arg0Value, this.cachedShape_cachedShape_, this.cachedShape_result_);
                }
            }
            if ((state & 0b10) != 0 /* is-active doCachedJSClass(DynamicObject, JSClass, ConditionProfile) */) {
                assert (this.cachedJSClass_cachedJSClass_.usesOrdinaryIsExtensible());
                if ((this.cachedJSClass_cachedJSClass_.isInstance(arg0Value))) {
                    return IsExtensibleNode.doCachedJSClass(arg0Value, this.cachedJSClass_cachedJSClass_, this.resultProfile);
                }
            }
            if ((state & 0b100) != 0 /* is-active doUncached(DynamicObject, ConditionProfile) */) {
                return IsExtensibleNode.doUncached(arg0Value, this.resultProfile);
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
            if (((exclude & 0b1)) == 0 /* is-not-excluded doCachedShape(DynamicObject, Shape, boolean) */) {
                boolean CachedShape_duplicateFound_ = false;
                if ((state & 0b1) != 0 /* is-active doCachedShape(DynamicObject, Shape, boolean) */) {
                    assert (JSShape.getJSClass(this.cachedShape_cachedShape_).usesOrdinaryIsExtensible());
                    if ((this.cachedShape_cachedShape_.check(arg0Value))) {
                        CachedShape_duplicateFound_ = true;
                    }
                }
                if (!CachedShape_duplicateFound_) {
                    {
                        Shape cachedShape_cachedShape__ = (arg0Value.getShape());
                        if ((JSShape.getJSClass(cachedShape_cachedShape__).usesOrdinaryIsExtensible()) && (cachedShape_cachedShape__.check(arg0Value)) && ((state & 0b1)) == 0 /* is-not-active doCachedShape(DynamicObject, Shape, boolean) */) {
                            this.cachedShape_cachedShape_ = cachedShape_cachedShape__;
                            this.cachedShape_result_ = (JSShape.isExtensible(cachedShape_cachedShape__));
                            this.state_ = state = state | 0b1 /* add-active doCachedShape(DynamicObject, Shape, boolean) */;
                            CachedShape_duplicateFound_ = true;
                        }
                    }
                }
                if (CachedShape_duplicateFound_) {
                    lock.unlock();
                    hasLock = false;
                    return IsExtensibleNode.doCachedShape(arg0Value, this.cachedShape_cachedShape_, this.cachedShape_result_);
                }
            }
            if (((exclude & 0b10)) == 0 /* is-not-excluded doCachedJSClass(DynamicObject, JSClass, ConditionProfile) */) {
                boolean CachedJSClass_duplicateFound_ = false;
                if ((state & 0b10) != 0 /* is-active doCachedJSClass(DynamicObject, JSClass, ConditionProfile) */) {
                    assert (this.cachedJSClass_cachedJSClass_.usesOrdinaryIsExtensible());
                    if ((this.cachedJSClass_cachedJSClass_.isInstance(arg0Value))) {
                        CachedJSClass_duplicateFound_ = true;
                    }
                }
                if (!CachedJSClass_duplicateFound_) {
                    {
                        JSClass cachedJSClass_cachedJSClass__ = (JSGuards.getJSClassChecked(arg0Value));
                        if ((cachedJSClass_cachedJSClass__.usesOrdinaryIsExtensible()) && (cachedJSClass_cachedJSClass__.isInstance(arg0Value)) && ((state & 0b10)) == 0 /* is-not-active doCachedJSClass(DynamicObject, JSClass, ConditionProfile) */) {
                            this.cachedJSClass_cachedJSClass_ = cachedJSClass_cachedJSClass__;
                            if (this.resultProfile == null) {
                                this.resultProfile = (ConditionProfile.createBinaryProfile());
                            }
                            this.exclude_ = exclude = exclude | 0b1 /* add-excluded doCachedShape(DynamicObject, Shape, boolean) */;
                            state = state & 0xfffffffe /* remove-active doCachedShape(DynamicObject, Shape, boolean) */;
                            this.state_ = state = state | 0b10 /* add-active doCachedJSClass(DynamicObject, JSClass, ConditionProfile) */;
                            CachedJSClass_duplicateFound_ = true;
                        }
                    }
                }
                if (CachedJSClass_duplicateFound_) {
                    lock.unlock();
                    hasLock = false;
                    return IsExtensibleNode.doCachedJSClass(arg0Value, this.cachedJSClass_cachedJSClass_, this.resultProfile);
                }
            }
            if (this.resultProfile == null) {
                this.resultProfile = (ConditionProfile.createBinaryProfile());
            }
            this.exclude_ = exclude = exclude | 0b11 /* add-excluded doCachedShape(DynamicObject, Shape, boolean), doCachedJSClass(DynamicObject, JSClass, ConditionProfile) */;
            state = state & 0xfffffffc /* remove-active doCachedShape(DynamicObject, Shape, boolean), doCachedJSClass(DynamicObject, JSClass, ConditionProfile) */;
            this.state_ = state = state | 0b100 /* add-active doUncached(DynamicObject, ConditionProfile) */;
            lock.unlock();
            hasLock = false;
            return IsExtensibleNode.doUncached(arg0Value, this.resultProfile);
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
        int exclude = exclude_;
        s = new Object[3];
        s[0] = "doCachedShape";
        if ((state & 0b1) != 0 /* is-active doCachedShape(DynamicObject, Shape, boolean) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.cachedShape_cachedShape_, this.cachedShape_result_));
            s[2] = cached;
        } else if ((exclude & 0b1) != 0 /* is-excluded doCachedShape(DynamicObject, Shape, boolean) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doCachedJSClass";
        if ((state & 0b10) != 0 /* is-active doCachedJSClass(DynamicObject, JSClass, ConditionProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.cachedJSClass_cachedJSClass_, this.resultProfile));
            s[2] = cached;
        } else if ((exclude & 0b10) != 0 /* is-excluded doCachedJSClass(DynamicObject, JSClass, ConditionProfile) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doUncached";
        if ((state & 0b100) != 0 /* is-active doUncached(DynamicObject, ConditionProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.resultProfile));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        return Provider.create(data);
    }

    public static IsExtensibleNode create() {
        return new IsExtensibleNodeGen();
    }

}
