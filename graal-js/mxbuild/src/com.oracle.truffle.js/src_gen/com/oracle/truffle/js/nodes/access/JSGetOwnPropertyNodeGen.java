// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.Assumption;
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
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.api.profiles.ValueProfile;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.cast.ToArrayIndexNode;
import com.oracle.truffle.js.runtime.JSRuntime;
import com.oracle.truffle.js.runtime.builtins.JSClass;
import com.oracle.truffle.js.runtime.objects.PropertyDescriptor;
import com.oracle.truffle.js.runtime.util.JSClassProfile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSGetOwnPropertyNode.class)
public final class JSGetOwnPropertyNodeGen extends JSGetOwnPropertyNode implements Provider {

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @Child private ArrayData array_cache;
    @CompilationFinal private ConditionProfile getOwnPropertyString_stringCaseProfile_;
    @CompilationFinal private CachedOrdinaryData cachedOrdinary_cache;
    @Child private UsesOrdinaryGetOwnPropertyNode uncachedOrdinary_usesOrdinaryGetOwnProperty_;
    @CompilationFinal private JSClassProfile generic_jsclassProfile_;

    private JSGetOwnPropertyNodeGen(boolean needValue, boolean needEnumerability, boolean needConfigurability, boolean needWritability, boolean allowCaching) {
        super(needValue, needEnumerability, needConfigurability, needWritability, allowCaching);
    }

    @ExplodeLoop
    @Override
    public PropertyDescriptor execute(DynamicObject arg0Value, Object arg1Value) {
        int state = state_;
        if (state != 0 /* is-active array(DynamicObject, Object, ToArrayIndexNode, BranchProfile, ValueProfile) || getOwnPropertyString(DynamicObject, Object, ConditionProfile) || cachedOrdinary(DynamicObject, Object, JSClass, Shape, Object, Property) || uncachedOrdinary(DynamicObject, Object, UsesOrdinaryGetOwnPropertyNode) || generic(DynamicObject, Object, JSClassProfile) */) {
            if ((state & 0b1) != 0 /* is-active array(DynamicObject, Object, ToArrayIndexNode, BranchProfile, ValueProfile) */) {
                ArrayData s1_ = this.array_cache;
                if (s1_ != null) {
                    if ((JSGuards.isJSArray(arg0Value))) {
                        return array(arg0Value, arg1Value, s1_.toArrayIndexNode_, s1_.noSuchElementBranch_, s1_.typeProfile_);
                    }
                }
            }
            if ((state & 0b10) != 0 /* is-active getOwnPropertyString(DynamicObject, Object, ConditionProfile) */) {
                if ((JSGuards.isJSString(arg0Value))) {
                    return getOwnPropertyString(arg0Value, arg1Value, this.getOwnPropertyString_stringCaseProfile_);
                }
            }
            if ((state & 0b100) != 0 /* is-active cachedOrdinary(DynamicObject, Object, JSClass, Shape, Object, Property) */) {
                assert (allowCaching);
                CachedOrdinaryData s3_ = this.cachedOrdinary_cache;
                while (s3_ != null) {
                    if (!Assumption.isValidAssumption(s3_.assumption0_)) {
                        CompilerDirectives.transferToInterpreterAndInvalidate();
                        removeCachedOrdinary_(s3_);
                        return executeAndSpecialize(arg0Value, arg1Value);
                    }
                    assert (s3_.cachedJSClass_ != null);
                    if ((s3_.cachedJSClass_.isInstance(arg0Value)) && (JSRuntime.propertyKeyEquals(s3_.cachedPropertyKey_, arg1Value)) && (s3_.cachedShape_ == arg0Value.getShape())) {
                        return cachedOrdinary(arg0Value, arg1Value, s3_.cachedJSClass_, s3_.cachedShape_, s3_.cachedPropertyKey_, s3_.cachedProperty_);
                    }
                    s3_ = s3_.next_;
                }
            }
            if ((state & 0b1000) != 0 /* is-active uncachedOrdinary(DynamicObject, Object, UsesOrdinaryGetOwnPropertyNode) */) {
                if ((this.uncachedOrdinary_usesOrdinaryGetOwnProperty_.execute(arg0Value))) {
                    return uncachedOrdinary(arg0Value, arg1Value, this.uncachedOrdinary_usesOrdinaryGetOwnProperty_);
                }
            }
            if ((state & 0b10000) != 0 /* is-active generic(DynamicObject, Object, JSClassProfile) */) {
                if ((!(this.generic_jsclassProfile_.getJSClass(arg0Value).usesOrdinaryGetOwnProperty())) && (!(JSGuards.isJSArray(arg0Value))) && (!(JSGuards.isJSString(arg0Value)))) {
                    return JSGetOwnPropertyNode.generic(arg0Value, arg1Value, this.generic_jsclassProfile_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value);
    }

    private PropertyDescriptor executeAndSpecialize(DynamicObject arg0Value, Object arg1Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        int exclude = exclude_;
        try {
            if ((JSGuards.isJSArray(arg0Value))) {
                ArrayData s1_ = super.insert(new ArrayData());
                s1_.toArrayIndexNode_ = s1_.insertAccessor((ToArrayIndexNode.create()));
                s1_.noSuchElementBranch_ = (BranchProfile.create());
                s1_.typeProfile_ = (ValueProfile.createIdentityProfile());
                this.array_cache = s1_;
                this.state_ = state = state | 0b1 /* add-active array(DynamicObject, Object, ToArrayIndexNode, BranchProfile, ValueProfile) */;
                lock.unlock();
                hasLock = false;
                return array(arg0Value, arg1Value, s1_.toArrayIndexNode_, s1_.noSuchElementBranch_, s1_.typeProfile_);
            }
            if ((JSGuards.isJSString(arg0Value))) {
                this.getOwnPropertyString_stringCaseProfile_ = (ConditionProfile.createBinaryProfile());
                this.state_ = state = state | 0b10 /* add-active getOwnPropertyString(DynamicObject, Object, ConditionProfile) */;
                lock.unlock();
                hasLock = false;
                return getOwnPropertyString(arg0Value, arg1Value, this.getOwnPropertyString_stringCaseProfile_);
            }
            if ((exclude) == 0 /* is-not-excluded cachedOrdinary(DynamicObject, Object, JSClass, Shape, Object, Property) */ && (allowCaching)) {
                int count3_ = 0;
                CachedOrdinaryData s3_ = this.cachedOrdinary_cache;
                if ((state & 0b100) != 0 /* is-active cachedOrdinary(DynamicObject, Object, JSClass, Shape, Object, Property) */) {
                    while (s3_ != null) {
                        assert (s3_.cachedJSClass_ != null);
                        if ((s3_.cachedJSClass_.isInstance(arg0Value)) && (JSRuntime.propertyKeyEquals(s3_.cachedPropertyKey_, arg1Value)) && (s3_.cachedShape_ == arg0Value.getShape()) && (s3_.assumption0_ == null || Assumption.isValidAssumption(s3_.assumption0_))) {
                            break;
                        }
                        s3_ = s3_.next_;
                        count3_++;
                    }
                }
                if (s3_ == null) {
                    {
                        JSClass cachedJSClass__ = (JSGetOwnPropertyNode.getJSClassIfOrdinary(arg0Value));
                        if ((cachedJSClass__ != null) && (cachedJSClass__.isInstance(arg0Value))) {
                            Object cachedPropertyKey__ = (arg1Value);
                            if ((JSRuntime.propertyKeyEquals(cachedPropertyKey__, arg1Value))) {
                                Shape cachedShape__ = (arg0Value.getShape());
                                if ((cachedShape__ == arg0Value.getShape())) {
                                    Assumption assumption0 = (cachedShape__.getValidAssumption());
                                    if (Assumption.isValidAssumption(assumption0)) {
                                        if (count3_ < (3)) {
                                            s3_ = new CachedOrdinaryData(cachedOrdinary_cache);
                                            s3_.cachedJSClass_ = cachedJSClass__;
                                            s3_.cachedShape_ = cachedShape__;
                                            s3_.cachedPropertyKey_ = cachedPropertyKey__;
                                            s3_.cachedProperty_ = (cachedShape__.getProperty(arg1Value));
                                            s3_.assumption0_ = assumption0;
                                            this.cachedOrdinary_cache = s3_;
                                            this.state_ = state = state | 0b100 /* add-active cachedOrdinary(DynamicObject, Object, JSClass, Shape, Object, Property) */;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (s3_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return cachedOrdinary(arg0Value, arg1Value, s3_.cachedJSClass_, s3_.cachedShape_, s3_.cachedPropertyKey_, s3_.cachedProperty_);
                }
            }
            boolean UncachedOrdinary_duplicateFound_ = false;
            if ((state & 0b1000) != 0 /* is-active uncachedOrdinary(DynamicObject, Object, UsesOrdinaryGetOwnPropertyNode) */) {
                if ((this.uncachedOrdinary_usesOrdinaryGetOwnProperty_.execute(arg0Value))) {
                    UncachedOrdinary_duplicateFound_ = true;
                }
            }
            if (!UncachedOrdinary_duplicateFound_) {
                {
                    UsesOrdinaryGetOwnPropertyNode uncachedOrdinary_usesOrdinaryGetOwnProperty__ = super.insert((UsesOrdinaryGetOwnPropertyNode.create()));
                    if ((uncachedOrdinary_usesOrdinaryGetOwnProperty__.execute(arg0Value)) && ((state & 0b1000)) == 0 /* is-not-active uncachedOrdinary(DynamicObject, Object, UsesOrdinaryGetOwnPropertyNode) */) {
                        this.uncachedOrdinary_usesOrdinaryGetOwnProperty_ = super.insert(uncachedOrdinary_usesOrdinaryGetOwnProperty__);
                        this.exclude_ = exclude = exclude | 0b1 /* add-excluded cachedOrdinary(DynamicObject, Object, JSClass, Shape, Object, Property) */;
                        this.cachedOrdinary_cache = null;
                        state = state & 0xfffffffb /* remove-active cachedOrdinary(DynamicObject, Object, JSClass, Shape, Object, Property) */;
                        this.state_ = state = state | 0b1000 /* add-active uncachedOrdinary(DynamicObject, Object, UsesOrdinaryGetOwnPropertyNode) */;
                        UncachedOrdinary_duplicateFound_ = true;
                    }
                }
            }
            if (UncachedOrdinary_duplicateFound_) {
                lock.unlock();
                hasLock = false;
                return uncachedOrdinary(arg0Value, arg1Value, this.uncachedOrdinary_usesOrdinaryGetOwnProperty_);
            }
            boolean Generic_duplicateFound_ = false;
            if ((state & 0b10000) != 0 /* is-active generic(DynamicObject, Object, JSClassProfile) */) {
                if ((!(this.generic_jsclassProfile_.getJSClass(arg0Value).usesOrdinaryGetOwnProperty())) && (!(JSGuards.isJSArray(arg0Value))) && (!(JSGuards.isJSString(arg0Value)))) {
                    Generic_duplicateFound_ = true;
                }
            }
            if (!Generic_duplicateFound_) {
                {
                    JSClassProfile generic_jsclassProfile__ = (JSClassProfile.create());
                    if ((!(generic_jsclassProfile__.getJSClass(arg0Value).usesOrdinaryGetOwnProperty())) && (!(JSGuards.isJSArray(arg0Value))) && (!(JSGuards.isJSString(arg0Value))) && ((state & 0b10000)) == 0 /* is-not-active generic(DynamicObject, Object, JSClassProfile) */) {
                        this.generic_jsclassProfile_ = generic_jsclassProfile__;
                        this.state_ = state = state | 0b10000 /* add-active generic(DynamicObject, Object, JSClassProfile) */;
                        Generic_duplicateFound_ = true;
                    }
                }
            }
            if (Generic_duplicateFound_) {
                lock.unlock();
                hasLock = false;
                return JSGetOwnPropertyNode.generic(arg0Value, arg1Value, this.generic_jsclassProfile_);
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
            CachedOrdinaryData s3_ = this.cachedOrdinary_cache;
            if ((s3_ == null || s3_.next_ == null)) {
                return NodeCost.MONOMORPHIC;
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    void removeCachedOrdinary_(Object s3_) {
        Lock lock = getLock();
        lock.lock();
        try {
            CachedOrdinaryData prev = null;
            CachedOrdinaryData cur = this.cachedOrdinary_cache;
            while (cur != null) {
                if (cur == s3_) {
                    if (prev == null) {
                        this.cachedOrdinary_cache = cur.next_;
                    } else {
                        prev.next_ = cur.next_;
                    }
                    break;
                }
                prev = cur;
                cur = cur.next_;
            }
            if (this.cachedOrdinary_cache == null) {
                this.state_ = this.state_ & 0xfffffffb /* remove-active cachedOrdinary(DynamicObject, Object, JSClass, Shape, Object, Property) */;
            }
        } finally {
            lock.unlock();
        }
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[6];
        Object[] s;
        data[0] = 0;
        int state = state_;
        int exclude = exclude_;
        s = new Object[3];
        s[0] = "array";
        if ((state & 0b1) != 0 /* is-active array(DynamicObject, Object, ToArrayIndexNode, BranchProfile, ValueProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            ArrayData s1_ = this.array_cache;
            if (s1_ != null) {
                cached.add(Arrays.asList(s1_.toArrayIndexNode_, s1_.noSuchElementBranch_, s1_.typeProfile_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "getOwnPropertyString";
        if ((state & 0b10) != 0 /* is-active getOwnPropertyString(DynamicObject, Object, ConditionProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.getOwnPropertyString_stringCaseProfile_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "cachedOrdinary";
        if ((state & 0b100) != 0 /* is-active cachedOrdinary(DynamicObject, Object, JSClass, Shape, Object, Property) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            CachedOrdinaryData s3_ = this.cachedOrdinary_cache;
            while (s3_ != null) {
                cached.add(Arrays.asList(s3_.cachedJSClass_, s3_.cachedShape_, s3_.cachedPropertyKey_, s3_.cachedProperty_));
                s3_ = s3_.next_;
            }
            s[2] = cached;
        } else if (exclude != 0 /* is-excluded cachedOrdinary(DynamicObject, Object, JSClass, Shape, Object, Property) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "uncachedOrdinary";
        if ((state & 0b1000) != 0 /* is-active uncachedOrdinary(DynamicObject, Object, UsesOrdinaryGetOwnPropertyNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.uncachedOrdinary_usesOrdinaryGetOwnProperty_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "generic";
        if ((state & 0b10000) != 0 /* is-active generic(DynamicObject, Object, JSClassProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.generic_jsclassProfile_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        return Provider.create(data);
    }

    public static JSGetOwnPropertyNode create(boolean needValue, boolean needEnumerability, boolean needConfigurability, boolean needWritability, boolean allowCaching) {
        return new JSGetOwnPropertyNodeGen(needValue, needEnumerability, needConfigurability, needWritability, allowCaching);
    }

    @GeneratedBy(JSGetOwnPropertyNode.class)
    private static final class ArrayData extends Node {

        @Child ToArrayIndexNode toArrayIndexNode_;
        @CompilationFinal BranchProfile noSuchElementBranch_;
        @CompilationFinal ValueProfile typeProfile_;

        ArrayData() {
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.NONE;
        }

        <T extends Node> T insertAccessor(T node) {
            return super.insert(node);
        }

    }
    @GeneratedBy(JSGetOwnPropertyNode.class)
    private static final class CachedOrdinaryData {

        @CompilationFinal CachedOrdinaryData next_;
        @CompilationFinal JSClass cachedJSClass_;
        @CompilationFinal Shape cachedShape_;
        @CompilationFinal Object cachedPropertyKey_;
        @CompilationFinal Property cachedProperty_;
        @CompilationFinal Assumption assumption0_;

        CachedOrdinaryData(CachedOrdinaryData next_) {
            this.next_ = next_;
        }

    }
    @GeneratedBy(UsesOrdinaryGetOwnPropertyNode.class)
    public static final class UsesOrdinaryGetOwnPropertyNodeGen extends UsesOrdinaryGetOwnPropertyNode implements Provider {

        @CompilationFinal private volatile int state_;
        @CompilationFinal private volatile int exclude_;
        @CompilationFinal private CachedData cached_cache;

        private UsesOrdinaryGetOwnPropertyNodeGen() {
        }

        @ExplodeLoop
        @Override
        public boolean execute(JSClass arg0Value) {
            int state = state_;
            if (state != 0 /* is-active doCached(JSClass, JSClass) || doObjectPrototype(JSClass) */) {
                if ((state & 0b1) != 0 /* is-active doCached(JSClass, JSClass) */) {
                    CachedData s1_ = this.cached_cache;
                    while (s1_ != null) {
                        if ((arg0Value == s1_.cachedJSClass_)) {
                            return UsesOrdinaryGetOwnPropertyNode.doCached(arg0Value, s1_.cachedJSClass_);
                        }
                        s1_ = s1_.next_;
                    }
                }
                if ((state & 0b10) != 0 /* is-active doObjectPrototype(JSClass) */) {
                    return UsesOrdinaryGetOwnPropertyNode.doObjectPrototype(arg0Value);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value);
        }

        private boolean executeAndSpecialize(JSClass arg0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int exclude = exclude_;
            try {
                if ((exclude) == 0 /* is-not-excluded doCached(JSClass, JSClass) */) {
                    int count1_ = 0;
                    CachedData s1_ = this.cached_cache;
                    if ((state & 0b1) != 0 /* is-active doCached(JSClass, JSClass) */) {
                        while (s1_ != null) {
                            if ((arg0Value == s1_.cachedJSClass_)) {
                                break;
                            }
                            s1_ = s1_.next_;
                            count1_++;
                        }
                    }
                    if (s1_ == null) {
                        // assert (arg0Value == s1_.cachedJSClass_);
                        if (count1_ < (7)) {
                            s1_ = new CachedData(cached_cache);
                            s1_.cachedJSClass_ = (arg0Value);
                            this.cached_cache = s1_;
                            this.state_ = state = state | 0b1 /* add-active doCached(JSClass, JSClass) */;
                        }
                    }
                    if (s1_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return UsesOrdinaryGetOwnPropertyNode.doCached(arg0Value, s1_.cachedJSClass_);
                    }
                }
                this.exclude_ = exclude = exclude | 0b1 /* add-excluded doCached(JSClass, JSClass) */;
                this.cached_cache = null;
                state = state & 0xfffffffe /* remove-active doCached(JSClass, JSClass) */;
                this.state_ = state = state | 0b10 /* add-active doObjectPrototype(JSClass) */;
                lock.unlock();
                hasLock = false;
                return UsesOrdinaryGetOwnPropertyNode.doObjectPrototype(arg0Value);
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
            if ((state & 0b1) != 0 /* is-active doCached(JSClass, JSClass) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                CachedData s1_ = this.cached_cache;
                while (s1_ != null) {
                    cached.add(Arrays.asList(s1_.cachedJSClass_));
                    s1_ = s1_.next_;
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-excluded doCached(JSClass, JSClass) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doObjectPrototype";
            if ((state & 0b10) != 0 /* is-active doObjectPrototype(JSClass) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static UsesOrdinaryGetOwnPropertyNode create() {
            return new UsesOrdinaryGetOwnPropertyNodeGen();
        }

        @GeneratedBy(UsesOrdinaryGetOwnPropertyNode.class)
        private static final class CachedData {

            @CompilationFinal CachedData next_;
            @CompilationFinal JSClass cachedJSClass_;

            CachedData(CachedData next_) {
                this.next_ = next_;
            }

        }
    }
    @GeneratedBy(GetPropertyProxyValueNode.class)
    public static final class GetPropertyProxyValueNodeGen extends GetPropertyProxyValueNode implements Provider {

        @CompilationFinal private volatile int state_;
        @CompilationFinal private volatile int exclude_;
        @CompilationFinal private CachedData cached_cache;

        private GetPropertyProxyValueNodeGen() {
        }

        @ExplodeLoop
        @Override
        public Object execute(DynamicObject arg0Value, Object arg1Value) {
            int state = state_;
            if (state != 0 /* is-active doCached(DynamicObject, Object, Class<>) || doUncached(DynamicObject, Object) */) {
                if ((state & 0b1) != 0 /* is-active doCached(DynamicObject, Object, Class<>) */) {
                    CachedData s1_ = this.cached_cache;
                    while (s1_ != null) {
                        if ((arg1Value.getClass() == s1_.cachedClass_)) {
                            return GetPropertyProxyValueNode.doCached(arg0Value, arg1Value, s1_.cachedClass_);
                        }
                        s1_ = s1_.next_;
                    }
                }
                if ((state & 0b10) != 0 /* is-active doUncached(DynamicObject, Object) */) {
                    return GetPropertyProxyValueNode.doUncached(arg0Value, arg1Value);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value, arg1Value);
        }

        private Object executeAndSpecialize(DynamicObject arg0Value, Object arg1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int exclude = exclude_;
            try {
                if ((exclude) == 0 /* is-not-excluded doCached(DynamicObject, Object, Class<>) */) {
                    int count1_ = 0;
                    CachedData s1_ = this.cached_cache;
                    if ((state & 0b1) != 0 /* is-active doCached(DynamicObject, Object, Class<>) */) {
                        while (s1_ != null) {
                            if ((arg1Value.getClass() == s1_.cachedClass_)) {
                                break;
                            }
                            s1_ = s1_.next_;
                            count1_++;
                        }
                    }
                    if (s1_ == null) {
                        {
                            Class<?> cachedClass__ = (arg1Value.getClass());
                            if ((arg1Value.getClass() == cachedClass__) && count1_ < (5)) {
                                s1_ = new CachedData(cached_cache);
                                s1_.cachedClass_ = cachedClass__;
                                this.cached_cache = s1_;
                                this.state_ = state = state | 0b1 /* add-active doCached(DynamicObject, Object, Class<>) */;
                            }
                        }
                    }
                    if (s1_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return GetPropertyProxyValueNode.doCached(arg0Value, arg1Value, s1_.cachedClass_);
                    }
                }
                this.exclude_ = exclude = exclude | 0b1 /* add-excluded doCached(DynamicObject, Object, Class<>) */;
                this.cached_cache = null;
                state = state & 0xfffffffe /* remove-active doCached(DynamicObject, Object, Class<>) */;
                this.state_ = state = state | 0b10 /* add-active doUncached(DynamicObject, Object) */;
                lock.unlock();
                hasLock = false;
                return GetPropertyProxyValueNode.doUncached(arg0Value, arg1Value);
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
            if ((state & 0b1) != 0 /* is-active doCached(DynamicObject, Object, Class<>) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                CachedData s1_ = this.cached_cache;
                while (s1_ != null) {
                    cached.add(Arrays.asList(s1_.cachedClass_));
                    s1_ = s1_.next_;
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-excluded doCached(DynamicObject, Object, Class<>) */) {
                s[1] = (byte)0b10 /* excluded */;
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
            return Provider.create(data);
        }

        public static GetPropertyProxyValueNode create() {
            return new GetPropertyProxyValueNodeGen();
        }

        @GeneratedBy(GetPropertyProxyValueNode.class)
        private static final class CachedData {

            @CompilationFinal CachedData next_;
            @CompilationFinal Class<?> cachedClass_;

            CachedData(CachedData next_) {
                this.next_ = next_;
            }

        }
    }
}
