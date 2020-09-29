// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

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
import com.oracle.truffle.api.object.Property;
import com.oracle.truffle.api.object.Shape;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.runtime.util.JSClassProfile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(GetPrototypeNode.class)
public final class GetPrototypeNodeGen extends GetPrototypeNode implements Provider {

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private CachedShapeData cachedShape_cache;
    @CompilationFinal private JSClassProfile proxy_jsclassProfile_;

    private GetPrototypeNodeGen() {
    }

    @ExplodeLoop
    @Override
    public DynamicObject executeJSObject(Object arg0Value) {
        int state = state_;
        if ((state & 0b111) != 0 /* is-active doCachedShape(DynamicObject, Shape, Property) || doGeneric(DynamicObject) || doProxy(DynamicObject, JSClassProfile) */ && JSTypes.isDynamicObject(arg0Value)) {
            DynamicObject arg0Value_ = (DynamicObject) arg0Value;
            if ((state & 0b1) != 0 /* is-active doCachedShape(DynamicObject, Shape, Property) */) {
                CachedShapeData s1_ = this.cachedShape_cache;
                while (s1_ != null) {
                    if ((arg0Value_.getShape() == s1_.shape_)) {
                        assert (s1_.prototypeProperty_ != null);
                        return doCachedShape(arg0Value_, s1_.shape_, s1_.prototypeProperty_);
                    }
                    s1_ = s1_.next_;
                }
            }
            if ((state & 0b10) != 0 /* is-active doGeneric(DynamicObject) */) {
                if ((!(JSGuards.isJSProxy(arg0Value_)))) {
                    return doGeneric(arg0Value_);
                }
            }
            if ((state & 0b100) != 0 /* is-active doProxy(DynamicObject, JSClassProfile) */) {
                if ((JSGuards.isJSProxy(arg0Value_))) {
                    return doProxy(arg0Value_, this.proxy_jsclassProfile_);
                }
            }
        }
        if ((state & 0b1000) != 0 /* is-active doNotObject(Object) */) {
            if ((!(JSGuards.isDynamicObject(arg0Value)))) {
                return doNotObject(arg0Value);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    @ExplodeLoop
    @Override
    protected DynamicObject executeDynamicObject(DynamicObject arg0Value) {
        int state = state_;
        if ((state & 0b111) != 0 /* is-active doCachedShape(DynamicObject, Shape, Property) || doGeneric(DynamicObject) || doProxy(DynamicObject, JSClassProfile) */) {
            if ((state & 0b1) != 0 /* is-active doCachedShape(DynamicObject, Shape, Property) */) {
                CachedShapeData s1_ = this.cachedShape_cache;
                while (s1_ != null) {
                    if ((arg0Value.getShape() == s1_.shape_)) {
                        assert (s1_.prototypeProperty_ != null);
                        return doCachedShape(arg0Value, s1_.shape_, s1_.prototypeProperty_);
                    }
                    s1_ = s1_.next_;
                }
            }
            if ((state & 0b10) != 0 /* is-active doGeneric(DynamicObject) */) {
                if ((!(JSGuards.isJSProxy(arg0Value)))) {
                    return doGeneric(arg0Value);
                }
            }
            if ((state & 0b100) != 0 /* is-active doProxy(DynamicObject, JSClassProfile) */) {
                if ((JSGuards.isJSProxy(arg0Value))) {
                    return doProxy(arg0Value, this.proxy_jsclassProfile_);
                }
            }
        }
        if ((state & 0b1000) != 0 /* is-active doNotObject(Object) */) {
            if ((!(JSGuards.isDynamicObject(arg0Value)))) {
                return doNotObject(arg0Value);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    private DynamicObject executeAndSpecialize(Object arg0Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        int exclude = exclude_;
        try {
            if (JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if ((exclude) == 0 /* is-not-excluded doCachedShape(DynamicObject, Shape, Property) */) {
                    int count1_ = 0;
                    CachedShapeData s1_ = this.cachedShape_cache;
                    if ((state & 0b1) != 0 /* is-active doCachedShape(DynamicObject, Shape, Property) */) {
                        while (s1_ != null) {
                            if ((arg0Value_.getShape() == s1_.shape_)) {
                                assert (s1_.prototypeProperty_ != null);
                                break;
                            }
                            s1_ = s1_.next_;
                            count1_++;
                        }
                    }
                    if (s1_ == null) {
                        {
                            Shape shape__ = (arg0Value_.getShape());
                            if ((arg0Value_.getShape() == shape__)) {
                                Property prototypeProperty__ = (GetPrototypeNode.getPrototypeProperty(shape__));
                                if ((prototypeProperty__ != null) && count1_ < (GetPrototypeNode.MAX_SHAPE_COUNT)) {
                                    s1_ = new CachedShapeData(cachedShape_cache);
                                    s1_.shape_ = shape__;
                                    s1_.prototypeProperty_ = prototypeProperty__;
                                    this.cachedShape_cache = s1_;
                                    this.state_ = state = state | 0b1 /* add-active doCachedShape(DynamicObject, Shape, Property) */;
                                }
                            }
                        }
                    }
                    if (s1_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return doCachedShape(arg0Value_, s1_.shape_, s1_.prototypeProperty_);
                    }
                }
                if ((!(JSGuards.isJSProxy(arg0Value_)))) {
                    this.exclude_ = exclude = exclude | 0b1 /* add-excluded doCachedShape(DynamicObject, Shape, Property) */;
                    this.cachedShape_cache = null;
                    state = state & 0xfffffffe /* remove-active doCachedShape(DynamicObject, Shape, Property) */;
                    this.state_ = state = state | 0b10 /* add-active doGeneric(DynamicObject) */;
                    lock.unlock();
                    hasLock = false;
                    return doGeneric(arg0Value_);
                }
                if ((JSGuards.isJSProxy(arg0Value_))) {
                    this.proxy_jsclassProfile_ = (JSClassProfile.create());
                    this.state_ = state = state | 0b100 /* add-active doProxy(DynamicObject, JSClassProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return doProxy(arg0Value_, this.proxy_jsclassProfile_);
                }
            }
            if ((!(JSGuards.isDynamicObject(arg0Value)))) {
                this.state_ = state = state | 0b1000 /* add-active doNotObject(Object) */;
                lock.unlock();
                hasLock = false;
                return doNotObject(arg0Value);
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
            CachedShapeData s1_ = this.cachedShape_cache;
            if ((s1_ == null || s1_.next_ == null)) {
                return NodeCost.MONOMORPHIC;
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[5];
        Object[] s;
        data[0] = 0;
        int state = state_;
        int exclude = exclude_;
        s = new Object[3];
        s[0] = "doCachedShape";
        if ((state & 0b1) != 0 /* is-active doCachedShape(DynamicObject, Shape, Property) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            CachedShapeData s1_ = this.cachedShape_cache;
            while (s1_ != null) {
                cached.add(Arrays.asList(s1_.shape_, s1_.prototypeProperty_));
                s1_ = s1_.next_;
            }
            s[2] = cached;
        } else if (exclude != 0 /* is-excluded doCachedShape(DynamicObject, Shape, Property) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doGeneric";
        if ((state & 0b10) != 0 /* is-active doGeneric(DynamicObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doProxy";
        if ((state & 0b100) != 0 /* is-active doProxy(DynamicObject, JSClassProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.proxy_jsclassProfile_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doNotObject";
        if ((state & 0b1000) != 0 /* is-active doNotObject(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        return Provider.create(data);
    }

    public static GetPrototypeNode create() {
        return new GetPrototypeNodeGen();
    }

    @GeneratedBy(GetPrototypeNode.class)
    private static final class CachedShapeData {

        @CompilationFinal CachedShapeData next_;
        @CompilationFinal Shape shape_;
        @CompilationFinal Property prototypeProperty_;

        CachedShapeData(CachedShapeData next_) {
            this.next_ = next_;
        }

    }
}
