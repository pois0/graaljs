// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.cast.ToArrayIndexNode;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.JSRuntime;
import com.oracle.truffle.js.runtime.util.JSClassProfile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(CachedSetPropertyNode.class)
final class CachedSetPropertyNodeGen extends CachedSetPropertyNode implements Provider {

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @Child private CachedKeyData cachedKey_cache;
    @CompilationFinal private JSClassProfile intIndex_jsclassProfile_;
    @Child private ArrayIndexData arrayIndex_cache;
    @Child private JSProxyPropertySetNode proxy_proxySet_;
    @Child private GenericData generic_cache;

    private CachedSetPropertyNodeGen(JSContext context, boolean strict, boolean setOwn, boolean superProperty) {
        super(context, strict, setOwn, superProperty);
    }

    @ExplodeLoop
    @Override
    public void execute(DynamicObject arg0Value, Object arg1Value, Object arg2Value, Object arg3Value) {
        int state = state_;
        if (state != 0 /* is-active doCachedKey(DynamicObject, Object, Object, Object, Object, PropertySetNode) || doIntIndex(DynamicObject, int, Object, Object, JSClassProfile) || doArrayIndex(DynamicObject, Object, Object, Object, ToArrayIndexNode, Object, JSClassProfile) || doProxy(DynamicObject, Object, Object, Object, JSProxyPropertySetNode) || doGeneric(DynamicObject, Object, Object, Object, ToArrayIndexNode, ConditionProfile, JSClassProfile) */) {
            if ((state & 0b1) != 0 /* is-active doCachedKey(DynamicObject, Object, Object, Object, Object, PropertySetNode) */) {
                CachedKeyData s1_ = this.cachedKey_cache;
                while (s1_ != null) {
                    assert (s1_.cachedKey_ != null);
                    assert (!(JSRuntime.isArrayIndex(s1_.cachedKey_)));
                    if ((JSRuntime.propertyKeyEquals(s1_.cachedKey_, arg1Value))) {
                        doCachedKey(arg0Value, arg1Value, arg2Value, arg3Value, s1_.cachedKey_, s1_.propertyNode_);
                        return;
                    }
                    s1_ = s1_.next_;
                }
            }
            if ((state & 0b10) != 0 /* is-active doIntIndex(DynamicObject, int, Object, Object, JSClassProfile) */ && arg1Value instanceof Integer) {
                int arg1Value_ = (int) arg1Value;
                if ((JSRuntime.isArrayIndex(arg1Value_)) && (!(JSGuards.isJSProxy(arg0Value)))) {
                    doIntIndex(arg0Value, arg1Value_, arg2Value, arg3Value, this.intIndex_jsclassProfile_);
                    return;
                }
            }
            if ((state & 0b11100) != 0 /* is-active doArrayIndex(DynamicObject, Object, Object, Object, ToArrayIndexNode, Object, JSClassProfile) || doProxy(DynamicObject, Object, Object, Object, JSProxyPropertySetNode) || doGeneric(DynamicObject, Object, Object, Object, ToArrayIndexNode, ConditionProfile, JSClassProfile) */) {
                if ((state & 0b100) != 0 /* is-active doArrayIndex(DynamicObject, Object, Object, Object, ToArrayIndexNode, Object, JSClassProfile) */ && (!(JSGuards.isJSProxy(arg0Value)))) {
                    ArrayIndexData s3_ = this.arrayIndex_cache;
                    while (s3_ != null) {
                        {
                            Object maybeIndex__ = (s3_.toArrayIndexNode_.execute(arg1Value));
                            if ((s3_.toArrayIndexNode_.isResultArrayIndex(maybeIndex__))) {
                                doArrayIndex(arg0Value, arg1Value, arg2Value, arg3Value, s3_.toArrayIndexNode_, maybeIndex__, s3_.jsclassProfile_);
                                return;
                            }
                        }
                        s3_ = s3_.next_;
                    }
                }
                if ((state & 0b1000) != 0 /* is-active doProxy(DynamicObject, Object, Object, Object, JSProxyPropertySetNode) */) {
                    if ((JSGuards.isJSProxy(arg0Value))) {
                        doProxy(arg0Value, arg1Value, arg2Value, arg3Value, this.proxy_proxySet_);
                        return;
                    }
                }
                if ((state & 0b10000) != 0 /* is-active doGeneric(DynamicObject, Object, Object, Object, ToArrayIndexNode, ConditionProfile, JSClassProfile) */) {
                    GenericData s5_ = this.generic_cache;
                    if (s5_ != null) {
                        doGeneric(arg0Value, arg1Value, arg2Value, arg3Value, s5_.toArrayIndexNode_, s5_.getType_, s5_.jsclassProfile_);
                        return;
                    }
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        executeAndSpecialize(arg0Value, arg1Value, arg2Value, arg3Value);
        return;
    }

    private void executeAndSpecialize(DynamicObject arg0Value, Object arg1Value, Object arg2Value, Object arg3Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        int exclude = exclude_;
        int oldState = state;
        try {
            if (((exclude & 0b1)) == 0 /* is-not-excluded doCachedKey(DynamicObject, Object, Object, Object, Object, PropertySetNode) */) {
                int count1_ = 0;
                CachedKeyData s1_ = this.cachedKey_cache;
                if ((state & 0b1) != 0 /* is-active doCachedKey(DynamicObject, Object, Object, Object, Object, PropertySetNode) */) {
                    while (s1_ != null) {
                        assert (s1_.cachedKey_ != null);
                        assert (!(JSRuntime.isArrayIndex(s1_.cachedKey_)));
                        if ((JSRuntime.propertyKeyEquals(s1_.cachedKey_, arg1Value))) {
                            break;
                        }
                        s1_ = s1_.next_;
                        count1_++;
                    }
                }
                if (s1_ == null) {
                    {
                        Object cachedKey__ = (CachedGetPropertyNode.cachedPropertyKey(arg1Value));
                        if ((cachedKey__ != null) && (!(JSRuntime.isArrayIndex(cachedKey__))) && (JSRuntime.propertyKeyEquals(cachedKey__, arg1Value)) && count1_ < (CachedSetPropertyNode.MAX_DEPTH)) {
                            s1_ = super.insert(new CachedKeyData(cachedKey_cache));
                            s1_.cachedKey_ = cachedKey__;
                            s1_.propertyNode_ = s1_.insertAccessor((createSet(cachedKey__)));
                            this.cachedKey_cache = s1_;
                            this.state_ = state = state | 0b1 /* add-active doCachedKey(DynamicObject, Object, Object, Object, Object, PropertySetNode) */;
                        }
                    }
                }
                if (s1_ != null) {
                    lock.unlock();
                    hasLock = false;
                    doCachedKey(arg0Value, arg1Value, arg2Value, arg3Value, s1_.cachedKey_, s1_.propertyNode_);
                    return;
                }
            }
            if (((exclude & 0b10)) == 0 /* is-not-excluded doIntIndex(DynamicObject, int, Object, Object, JSClassProfile) */ && arg1Value instanceof Integer) {
                int arg1Value_ = (int) arg1Value;
                if ((JSRuntime.isArrayIndex(arg1Value_)) && (!(JSGuards.isJSProxy(arg0Value)))) {
                    this.intIndex_jsclassProfile_ = (JSClassProfile.create());
                    this.state_ = state = state | 0b10 /* add-active doIntIndex(DynamicObject, int, Object, Object, JSClassProfile) */;
                    lock.unlock();
                    hasLock = false;
                    doIntIndex(arg0Value, arg1Value_, arg2Value, arg3Value, this.intIndex_jsclassProfile_);
                    return;
                }
            }
            {
                Object maybeIndex__ = null;
                if (((exclude & 0b100)) == 0 /* is-not-excluded doArrayIndex(DynamicObject, Object, Object, Object, ToArrayIndexNode, Object, JSClassProfile) */ && (!(JSGuards.isJSProxy(arg0Value)))) {
                    int count3_ = 0;
                    ArrayIndexData s3_ = this.arrayIndex_cache;
                    if ((state & 0b100) != 0 /* is-active doArrayIndex(DynamicObject, Object, Object, Object, ToArrayIndexNode, Object, JSClassProfile) */) {
                        while (s3_ != null) {
                            {
                                maybeIndex__ = (s3_.toArrayIndexNode_.execute(arg1Value));
                                if ((s3_.toArrayIndexNode_.isResultArrayIndex(maybeIndex__))) {
                                    break;
                                }
                            }
                            s3_ = s3_.next_;
                            count3_++;
                        }
                    }
                    if (s3_ == null) {
                        {
                            ToArrayIndexNode toArrayIndexNode__ = super.insert((ToArrayIndexNode.createNoToPropertyKey()));
                            maybeIndex__ = (toArrayIndexNode__.execute(arg1Value));
                            if ((toArrayIndexNode__.isResultArrayIndex(maybeIndex__)) && count3_ < (3)) {
                                s3_ = super.insert(new ArrayIndexData(arrayIndex_cache));
                                s3_.toArrayIndexNode_ = s3_.insertAccessor(toArrayIndexNode__);
                                s3_.jsclassProfile_ = (JSClassProfile.create());
                                this.arrayIndex_cache = s3_;
                                this.exclude_ = exclude = exclude | 0b10 /* add-excluded doIntIndex(DynamicObject, int, Object, Object, JSClassProfile) */;
                                state = state & 0xfffffffd /* remove-active doIntIndex(DynamicObject, int, Object, Object, JSClassProfile) */;
                                this.state_ = state = state | 0b100 /* add-active doArrayIndex(DynamicObject, Object, Object, Object, ToArrayIndexNode, Object, JSClassProfile) */;
                            }
                        }
                    }
                    if (s3_ != null) {
                        lock.unlock();
                        hasLock = false;
                        doArrayIndex(arg0Value, arg1Value, arg2Value, arg3Value, s3_.toArrayIndexNode_, maybeIndex__, s3_.jsclassProfile_);
                        return;
                    }
                }
            }
            if (((exclude & 0b1000)) == 0 /* is-not-excluded doProxy(DynamicObject, Object, Object, Object, JSProxyPropertySetNode) */) {
                if ((JSGuards.isJSProxy(arg0Value))) {
                    this.proxy_proxySet_ = super.insert((JSProxyPropertySetNode.create(context, strict)));
                    this.state_ = state = state | 0b1000 /* add-active doProxy(DynamicObject, Object, Object, Object, JSProxyPropertySetNode) */;
                    lock.unlock();
                    hasLock = false;
                    doProxy(arg0Value, arg1Value, arg2Value, arg3Value, this.proxy_proxySet_);
                    return;
                }
            }
            GenericData s5_ = super.insert(new GenericData());
            s5_.toArrayIndexNode_ = s5_.insertAccessor((ToArrayIndexNode.create()));
            s5_.getType_ = (ConditionProfile.createBinaryProfile());
            s5_.jsclassProfile_ = (JSClassProfile.create());
            this.generic_cache = s5_;
            this.exclude_ = exclude = exclude | 0b1111 /* add-excluded doCachedKey(DynamicObject, Object, Object, Object, Object, PropertySetNode), doIntIndex(DynamicObject, int, Object, Object, JSClassProfile), doArrayIndex(DynamicObject, Object, Object, Object, ToArrayIndexNode, Object, JSClassProfile), doProxy(DynamicObject, Object, Object, Object, JSProxyPropertySetNode) */;
            this.cachedKey_cache = null;
            this.arrayIndex_cache = null;
            state = state & 0xfffffff0 /* remove-active doCachedKey(DynamicObject, Object, Object, Object, Object, PropertySetNode), doIntIndex(DynamicObject, int, Object, Object, JSClassProfile), doArrayIndex(DynamicObject, Object, Object, Object, ToArrayIndexNode, Object, JSClassProfile), doProxy(DynamicObject, Object, Object, Object, JSProxyPropertySetNode) */;
            this.state_ = state = state | 0b10000 /* add-active doGeneric(DynamicObject, Object, Object, Object, ToArrayIndexNode, ConditionProfile, JSClassProfile) */;
            lock.unlock();
            hasLock = false;
            doGeneric(arg0Value, arg1Value, arg2Value, arg3Value, s5_.toArrayIndexNode_, s5_.getType_, s5_.jsclassProfile_);
            return;
        } finally {
            if (oldState != 0) {
                checkForPolymorphicSpecialize(oldState);
            }
            if (hasLock) {
                lock.unlock();
            }
        }
    }

    private void checkForPolymorphicSpecialize(int oldState) {
        int megamorphicMask = 0b10000;
        int megamorphicState = (this.state_ & 0b10000);
        if ((((oldState & megamorphicMask) == 0) && (megamorphicState != 0))) {
            this.reportPolymorphicSpecialize();
        }
    }

    @Override
    public NodeCost getCost() {
        int state = state_;
        if (state == 0b0) {
            return NodeCost.UNINITIALIZED;
        } else if ((state & (state - 1)) == 0 /* is-single-active  */) {
            CachedKeyData s1_ = this.cachedKey_cache;
            ArrayIndexData s3_ = this.arrayIndex_cache;
            if ((s1_ == null || s1_.next_ == null) && (s3_ == null || s3_.next_ == null)) {
                return NodeCost.MONOMORPHIC;
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[6];
        Object[] s;
        data[0] = 0;
        int state = state_;
        int exclude = exclude_;
        s = new Object[3];
        s[0] = "doCachedKey";
        if ((state & 0b1) != 0 /* is-active doCachedKey(DynamicObject, Object, Object, Object, Object, PropertySetNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            CachedKeyData s1_ = this.cachedKey_cache;
            while (s1_ != null) {
                cached.add(Arrays.asList(s1_.cachedKey_, s1_.propertyNode_));
                s1_ = s1_.next_;
            }
            s[2] = cached;
        } else if ((exclude & 0b1) != 0 /* is-excluded doCachedKey(DynamicObject, Object, Object, Object, Object, PropertySetNode) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doIntIndex";
        if ((state & 0b10) != 0 /* is-active doIntIndex(DynamicObject, int, Object, Object, JSClassProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.intIndex_jsclassProfile_));
            s[2] = cached;
        } else if ((exclude & 0b10) != 0 /* is-excluded doIntIndex(DynamicObject, int, Object, Object, JSClassProfile) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doArrayIndex";
        if ((state & 0b100) != 0 /* is-active doArrayIndex(DynamicObject, Object, Object, Object, ToArrayIndexNode, Object, JSClassProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            ArrayIndexData s3_ = this.arrayIndex_cache;
            while (s3_ != null) {
                cached.add(Arrays.asList(s3_.toArrayIndexNode_, s3_.jsclassProfile_));
                s3_ = s3_.next_;
            }
            s[2] = cached;
        } else if ((exclude & 0b100) != 0 /* is-excluded doArrayIndex(DynamicObject, Object, Object, Object, ToArrayIndexNode, Object, JSClassProfile) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doProxy";
        if ((state & 0b1000) != 0 /* is-active doProxy(DynamicObject, Object, Object, Object, JSProxyPropertySetNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.proxy_proxySet_));
            s[2] = cached;
        } else if ((exclude & 0b1000) != 0 /* is-excluded doProxy(DynamicObject, Object, Object, Object, JSProxyPropertySetNode) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doGeneric";
        if ((state & 0b10000) != 0 /* is-active doGeneric(DynamicObject, Object, Object, Object, ToArrayIndexNode, ConditionProfile, JSClassProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            GenericData s5_ = this.generic_cache;
            if (s5_ != null) {
                cached.add(Arrays.asList(s5_.toArrayIndexNode_, s5_.getType_, s5_.jsclassProfile_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        return Provider.create(data);
    }

    public static CachedSetPropertyNode create(JSContext context, boolean strict, boolean setOwn, boolean superProperty) {
        return new CachedSetPropertyNodeGen(context, strict, setOwn, superProperty);
    }

    @GeneratedBy(CachedSetPropertyNode.class)
    private static final class CachedKeyData extends Node {

        @Child CachedKeyData next_;
        @CompilationFinal Object cachedKey_;
        @Child PropertySetNode propertyNode_;

        CachedKeyData(CachedKeyData next_) {
            this.next_ = next_;
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.NONE;
        }

        <T extends Node> T insertAccessor(T node) {
            return super.insert(node);
        }

    }
    @GeneratedBy(CachedSetPropertyNode.class)
    private static final class ArrayIndexData extends Node {

        @Child ArrayIndexData next_;
        @Child ToArrayIndexNode toArrayIndexNode_;
        @CompilationFinal JSClassProfile jsclassProfile_;

        ArrayIndexData(ArrayIndexData next_) {
            this.next_ = next_;
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.NONE;
        }

        <T extends Node> T insertAccessor(T node) {
            return super.insert(node);
        }

    }
    @GeneratedBy(CachedSetPropertyNode.class)
    private static final class GenericData extends Node {

        @Child ToArrayIndexNode toArrayIndexNode_;
        @CompilationFinal ConditionProfile getType_;
        @CompilationFinal JSClassProfile jsclassProfile_;

        GenericData() {
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.NONE;
        }

        <T extends Node> T insertAccessor(T node) {
            return super.insert(node);
        }

    }
}
