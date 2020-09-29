// CheckStyle: start generated
package com.oracle.truffle.js.nodes.array;

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
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.api.profiles.ValueProfile;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.access.JSHasPropertyNode;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.array.ScriptArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSArrayPreviousElementIndexNode.class)
public final class JSArrayPreviousElementIndexNodeGen extends JSArrayPreviousElementIndexNode implements Provider {

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private WithoutHolesCachedData withoutHolesCached_cache;
    @Child private PreviousWithHolesCachedData previousWithHolesCached_cache;
    @Child private PreviousWithHolesUncachedData previousWithHolesUncached_cache;
    @Child private JSHasPropertyNode previousObjectViaEnumeration_hasPropertyNode_;
    @Child private JSHasPropertyNode previousObjectViaFullEnumeration_hasPropertyNode_;
    @Child private JSHasPropertyNode previousObjectViaIteration_hasPropertyNode_;

    private JSArrayPreviousElementIndexNodeGen(JSContext context) {
        super(context);
    }

    @ExplodeLoop
    @Override
    public long executeLong(Object arg0Value, long arg1Value, boolean arg2Value) {
        int state = state_;
        if (state != 0 /* is-active doWithoutHolesCached(DynamicObject, long, boolean, ScriptArray) || doWithoutHolesUncached(DynamicObject, long, boolean) || previousWithHolesCached(DynamicObject, long, boolean, ScriptArray, JSArrayPreviousElementIndexNode, ConditionProfile) || previousWithHolesUncached(DynamicObject, long, boolean, JSArrayPreviousElementIndexNode, ConditionProfile, ValueProfile) || previousObjectViaEnumeration(DynamicObject, long, boolean, JSHasPropertyNode) || previousObjectViaFullEnumeration(DynamicObject, long, boolean, JSHasPropertyNode) || previousObjectViaIteration(Object, long, boolean, JSHasPropertyNode) */) {
            if ((state & 0b111111) != 0 /* is-active doWithoutHolesCached(DynamicObject, long, boolean, ScriptArray) || doWithoutHolesUncached(DynamicObject, long, boolean) || previousWithHolesCached(DynamicObject, long, boolean, ScriptArray, JSArrayPreviousElementIndexNode, ConditionProfile) || previousWithHolesUncached(DynamicObject, long, boolean, JSArrayPreviousElementIndexNode, ConditionProfile, ValueProfile) || previousObjectViaEnumeration(DynamicObject, long, boolean, JSHasPropertyNode) || previousObjectViaFullEnumeration(DynamicObject, long, boolean, JSHasPropertyNode) */ && JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if ((state & 0b1) != 0 /* is-active doWithoutHolesCached(DynamicObject, long, boolean, ScriptArray) */ && (arg2Value) && (!(hasPrototypeElements(arg0Value_)))) {
                    WithoutHolesCachedData s1_ = this.withoutHolesCached_cache;
                    while (s1_ != null) {
                        if ((JSArrayElementIndexNode.getArrayType(arg0Value_) == s1_.cachedArrayType_) && (!(s1_.cachedArrayType_.hasHoles(arg0Value_)))) {
                            return doWithoutHolesCached(arg0Value_, arg1Value, arg2Value, s1_.cachedArrayType_);
                        }
                        s1_ = s1_.next_;
                    }
                }
                if ((state & 0b10) != 0 /* is-active doWithoutHolesUncached(DynamicObject, long, boolean) */) {
                    if ((arg2Value) && (!(hasPrototypeElements(arg0Value_))) && (!(JSArrayElementIndexNode.hasHoles(arg0Value_)))) {
                        return doWithoutHolesUncached(arg0Value_, arg1Value, arg2Value);
                    }
                }
                if ((state & 0b100) != 0 /* is-active previousWithHolesCached(DynamicObject, long, boolean, ScriptArray, JSArrayPreviousElementIndexNode, ConditionProfile) */ && (arg2Value) && (!(hasPrototypeElements(arg0Value_)))) {
                    PreviousWithHolesCachedData s3_ = this.previousWithHolesCached_cache;
                    while (s3_ != null) {
                        if ((JSArrayElementIndexNode.getArrayType(arg0Value_) == s3_.cachedArrayType_) && (s3_.cachedArrayType_.hasHoles(arg0Value_))) {
                            return previousWithHolesCached(arg0Value_, arg1Value, arg2Value, s3_.cachedArrayType_, s3_.previousElementIndexNode_, s3_.isMinusOne_);
                        }
                        s3_ = s3_.next_;
                    }
                }
                if ((state & 0b1000) != 0 /* is-active previousWithHolesUncached(DynamicObject, long, boolean, JSArrayPreviousElementIndexNode, ConditionProfile, ValueProfile) */) {
                    PreviousWithHolesUncachedData s4_ = this.previousWithHolesUncached_cache;
                    if (s4_ != null) {
                        if ((arg2Value) && (hasPrototypeElements(arg0Value_) || JSArrayElementIndexNode.hasHoles(arg0Value_))) {
                            return previousWithHolesUncached(arg0Value_, arg1Value, arg2Value, s4_.previousElementIndexNode_, s4_.isMinusOne_, s4_.arrayTypeProfile_);
                        }
                    }
                }
                if ((state & 0b10000) != 0 /* is-active previousObjectViaEnumeration(DynamicObject, long, boolean, JSHasPropertyNode) */) {
                    if ((!(arg2Value)) && (isSuitableForEnumBasedProcessingUsingOwnKeys(arg0Value_, arg1Value))) {
                        return previousObjectViaEnumeration(arg0Value_, arg1Value, arg2Value, this.previousObjectViaEnumeration_hasPropertyNode_);
                    }
                }
                if ((state & 0b100000) != 0 /* is-active previousObjectViaFullEnumeration(DynamicObject, long, boolean, JSHasPropertyNode) */) {
                    if ((!(arg2Value)) && (!(isSuitableForEnumBasedProcessingUsingOwnKeys(arg0Value_, arg1Value))) && (JSArrayElementIndexNode.isSuitableForEnumBasedProcessing(arg0Value_, arg1Value))) {
                        return previousObjectViaFullEnumeration(arg0Value_, arg1Value, arg2Value, this.previousObjectViaFullEnumeration_hasPropertyNode_);
                    }
                }
            }
            if ((state & 0b1000000) != 0 /* is-active previousObjectViaIteration(Object, long, boolean, JSHasPropertyNode) */) {
                if ((!(arg2Value)) && (!(JSArrayElementIndexNode.isSuitableForEnumBasedProcessing(arg0Value, arg1Value)))) {
                    return previousObjectViaIteration(arg0Value, arg1Value, arg2Value, this.previousObjectViaIteration_hasPropertyNode_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value, arg2Value);
    }

    private long executeAndSpecialize(Object arg0Value, long arg1Value, boolean arg2Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        int exclude = exclude_;
        try {
            if (JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if (((exclude & 0b1)) == 0 /* is-not-excluded doWithoutHolesCached(DynamicObject, long, boolean, ScriptArray) */ && (arg2Value) && (!(hasPrototypeElements(arg0Value_)))) {
                    int count1_ = 0;
                    WithoutHolesCachedData s1_ = this.withoutHolesCached_cache;
                    if ((state & 0b1) != 0 /* is-active doWithoutHolesCached(DynamicObject, long, boolean, ScriptArray) */) {
                        while (s1_ != null) {
                            if ((JSArrayElementIndexNode.getArrayType(arg0Value_) == s1_.cachedArrayType_) && (!(s1_.cachedArrayType_.hasHoles(arg0Value_)))) {
                                break;
                            }
                            s1_ = s1_.next_;
                            count1_++;
                        }
                    }
                    if (s1_ == null) {
                        {
                            ScriptArray cachedArrayType__ = (JSArrayElementIndexNode.getArrayTypeIfArray(arg0Value_, arg2Value));
                            if ((JSArrayElementIndexNode.getArrayType(arg0Value_) == cachedArrayType__) && (!(cachedArrayType__.hasHoles(arg0Value_))) && count1_ < (JSArrayElementIndexNode.MAX_CACHED_ARRAY_TYPES)) {
                                s1_ = new WithoutHolesCachedData(withoutHolesCached_cache);
                                s1_.cachedArrayType_ = cachedArrayType__;
                                this.withoutHolesCached_cache = s1_;
                                this.state_ = state = state | 0b1 /* add-active doWithoutHolesCached(DynamicObject, long, boolean, ScriptArray) */;
                            }
                        }
                    }
                    if (s1_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return doWithoutHolesCached(arg0Value_, arg1Value, arg2Value, s1_.cachedArrayType_);
                    }
                }
                if ((arg2Value) && (!(hasPrototypeElements(arg0Value_))) && (!(JSArrayElementIndexNode.hasHoles(arg0Value_)))) {
                    this.exclude_ = exclude = exclude | 0b1 /* add-excluded doWithoutHolesCached(DynamicObject, long, boolean, ScriptArray) */;
                    this.withoutHolesCached_cache = null;
                    state = state & 0xfffffffe /* remove-active doWithoutHolesCached(DynamicObject, long, boolean, ScriptArray) */;
                    this.state_ = state = state | 0b10 /* add-active doWithoutHolesUncached(DynamicObject, long, boolean) */;
                    lock.unlock();
                    hasLock = false;
                    return doWithoutHolesUncached(arg0Value_, arg1Value, arg2Value);
                }
                if (((exclude & 0b10)) == 0 /* is-not-excluded previousWithHolesCached(DynamicObject, long, boolean, ScriptArray, JSArrayPreviousElementIndexNode, ConditionProfile) */ && (arg2Value) && (!(hasPrototypeElements(arg0Value_)))) {
                    int count3_ = 0;
                    PreviousWithHolesCachedData s3_ = this.previousWithHolesCached_cache;
                    if ((state & 0b100) != 0 /* is-active previousWithHolesCached(DynamicObject, long, boolean, ScriptArray, JSArrayPreviousElementIndexNode, ConditionProfile) */) {
                        while (s3_ != null) {
                            if ((JSArrayElementIndexNode.getArrayType(arg0Value_) == s3_.cachedArrayType_) && (s3_.cachedArrayType_.hasHoles(arg0Value_))) {
                                break;
                            }
                            s3_ = s3_.next_;
                            count3_++;
                        }
                    }
                    if (s3_ == null) {
                        {
                            ScriptArray cachedArrayType__1 = (JSArrayElementIndexNode.getArrayTypeIfArray(arg0Value_, arg2Value));
                            if ((JSArrayElementIndexNode.getArrayType(arg0Value_) == cachedArrayType__1) && (cachedArrayType__1.hasHoles(arg0Value_)) && count3_ < (JSArrayElementIndexNode.MAX_CACHED_ARRAY_TYPES)) {
                                s3_ = super.insert(new PreviousWithHolesCachedData(previousWithHolesCached_cache));
                                s3_.cachedArrayType_ = cachedArrayType__1;
                                s3_.previousElementIndexNode_ = s3_.insertAccessor((JSArrayPreviousElementIndexNode.create(context)));
                                s3_.isMinusOne_ = (ConditionProfile.createBinaryProfile());
                                this.previousWithHolesCached_cache = s3_;
                                this.state_ = state = state | 0b100 /* add-active previousWithHolesCached(DynamicObject, long, boolean, ScriptArray, JSArrayPreviousElementIndexNode, ConditionProfile) */;
                            }
                        }
                    }
                    if (s3_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return previousWithHolesCached(arg0Value_, arg1Value, arg2Value, s3_.cachedArrayType_, s3_.previousElementIndexNode_, s3_.isMinusOne_);
                    }
                }
                if ((arg2Value) && (hasPrototypeElements(arg0Value_) || JSArrayElementIndexNode.hasHoles(arg0Value_))) {
                    PreviousWithHolesUncachedData s4_ = super.insert(new PreviousWithHolesUncachedData());
                    s4_.previousElementIndexNode_ = s4_.insertAccessor((JSArrayPreviousElementIndexNode.create(context)));
                    s4_.isMinusOne_ = (ConditionProfile.createBinaryProfile());
                    s4_.arrayTypeProfile_ = (ValueProfile.createClassProfile());
                    this.previousWithHolesUncached_cache = s4_;
                    this.exclude_ = exclude = exclude | 0b10 /* add-excluded previousWithHolesCached(DynamicObject, long, boolean, ScriptArray, JSArrayPreviousElementIndexNode, ConditionProfile) */;
                    this.previousWithHolesCached_cache = null;
                    state = state & 0xfffffffb /* remove-active previousWithHolesCached(DynamicObject, long, boolean, ScriptArray, JSArrayPreviousElementIndexNode, ConditionProfile) */;
                    this.state_ = state = state | 0b1000 /* add-active previousWithHolesUncached(DynamicObject, long, boolean, JSArrayPreviousElementIndexNode, ConditionProfile, ValueProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return previousWithHolesUncached(arg0Value_, arg1Value, arg2Value, s4_.previousElementIndexNode_, s4_.isMinusOne_, s4_.arrayTypeProfile_);
                }
                if ((!(arg2Value)) && (isSuitableForEnumBasedProcessingUsingOwnKeys(arg0Value_, arg1Value))) {
                    this.previousObjectViaEnumeration_hasPropertyNode_ = super.insert((JSHasPropertyNode.create()));
                    this.state_ = state = state | 0b10000 /* add-active previousObjectViaEnumeration(DynamicObject, long, boolean, JSHasPropertyNode) */;
                    lock.unlock();
                    hasLock = false;
                    return previousObjectViaEnumeration(arg0Value_, arg1Value, arg2Value, this.previousObjectViaEnumeration_hasPropertyNode_);
                }
                if ((!(arg2Value)) && (!(isSuitableForEnumBasedProcessingUsingOwnKeys(arg0Value_, arg1Value))) && (JSArrayElementIndexNode.isSuitableForEnumBasedProcessing(arg0Value_, arg1Value))) {
                    this.previousObjectViaFullEnumeration_hasPropertyNode_ = super.insert((JSHasPropertyNode.create()));
                    this.state_ = state = state | 0b100000 /* add-active previousObjectViaFullEnumeration(DynamicObject, long, boolean, JSHasPropertyNode) */;
                    lock.unlock();
                    hasLock = false;
                    return previousObjectViaFullEnumeration(arg0Value_, arg1Value, arg2Value, this.previousObjectViaFullEnumeration_hasPropertyNode_);
                }
            }
            if ((!(arg2Value)) && (!(JSArrayElementIndexNode.isSuitableForEnumBasedProcessing(arg0Value, arg1Value)))) {
                this.previousObjectViaIteration_hasPropertyNode_ = super.insert((JSHasPropertyNode.create()));
                this.state_ = state = state | 0b1000000 /* add-active previousObjectViaIteration(Object, long, boolean, JSHasPropertyNode) */;
                lock.unlock();
                hasLock = false;
                return previousObjectViaIteration(arg0Value, arg1Value, arg2Value, this.previousObjectViaIteration_hasPropertyNode_);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {null, null, null}, arg0Value, arg1Value, arg2Value);
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
            WithoutHolesCachedData s1_ = this.withoutHolesCached_cache;
            PreviousWithHolesCachedData s3_ = this.previousWithHolesCached_cache;
            if ((s1_ == null || s1_.next_ == null) && (s3_ == null || s3_.next_ == null)) {
                return NodeCost.MONOMORPHIC;
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[8];
        Object[] s;
        data[0] = 0;
        int state = state_;
        int exclude = exclude_;
        s = new Object[3];
        s[0] = "doWithoutHolesCached";
        if ((state & 0b1) != 0 /* is-active doWithoutHolesCached(DynamicObject, long, boolean, ScriptArray) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            WithoutHolesCachedData s1_ = this.withoutHolesCached_cache;
            while (s1_ != null) {
                cached.add(Arrays.asList(s1_.cachedArrayType_));
                s1_ = s1_.next_;
            }
            s[2] = cached;
        } else if ((exclude & 0b1) != 0 /* is-excluded doWithoutHolesCached(DynamicObject, long, boolean, ScriptArray) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doWithoutHolesUncached";
        if ((state & 0b10) != 0 /* is-active doWithoutHolesUncached(DynamicObject, long, boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "previousWithHolesCached";
        if ((state & 0b100) != 0 /* is-active previousWithHolesCached(DynamicObject, long, boolean, ScriptArray, JSArrayPreviousElementIndexNode, ConditionProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            PreviousWithHolesCachedData s3_ = this.previousWithHolesCached_cache;
            while (s3_ != null) {
                cached.add(Arrays.asList(s3_.cachedArrayType_, s3_.previousElementIndexNode_, s3_.isMinusOne_));
                s3_ = s3_.next_;
            }
            s[2] = cached;
        } else if ((exclude & 0b10) != 0 /* is-excluded previousWithHolesCached(DynamicObject, long, boolean, ScriptArray, JSArrayPreviousElementIndexNode, ConditionProfile) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "previousWithHolesUncached";
        if ((state & 0b1000) != 0 /* is-active previousWithHolesUncached(DynamicObject, long, boolean, JSArrayPreviousElementIndexNode, ConditionProfile, ValueProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            PreviousWithHolesUncachedData s4_ = this.previousWithHolesUncached_cache;
            if (s4_ != null) {
                cached.add(Arrays.asList(s4_.previousElementIndexNode_, s4_.isMinusOne_, s4_.arrayTypeProfile_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "previousObjectViaEnumeration";
        if ((state & 0b10000) != 0 /* is-active previousObjectViaEnumeration(DynamicObject, long, boolean, JSHasPropertyNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.previousObjectViaEnumeration_hasPropertyNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "previousObjectViaFullEnumeration";
        if ((state & 0b100000) != 0 /* is-active previousObjectViaFullEnumeration(DynamicObject, long, boolean, JSHasPropertyNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.previousObjectViaFullEnumeration_hasPropertyNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "previousObjectViaIteration";
        if ((state & 0b1000000) != 0 /* is-active previousObjectViaIteration(Object, long, boolean, JSHasPropertyNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.previousObjectViaIteration_hasPropertyNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        return Provider.create(data);
    }

    public static JSArrayPreviousElementIndexNode create(JSContext context) {
        return new JSArrayPreviousElementIndexNodeGen(context);
    }

    @GeneratedBy(JSArrayPreviousElementIndexNode.class)
    private static final class WithoutHolesCachedData {

        @CompilationFinal WithoutHolesCachedData next_;
        @CompilationFinal ScriptArray cachedArrayType_;

        WithoutHolesCachedData(WithoutHolesCachedData next_) {
            this.next_ = next_;
        }

    }
    @GeneratedBy(JSArrayPreviousElementIndexNode.class)
    private static final class PreviousWithHolesCachedData extends Node {

        @Child PreviousWithHolesCachedData next_;
        @CompilationFinal ScriptArray cachedArrayType_;
        @Child JSArrayPreviousElementIndexNode previousElementIndexNode_;
        @CompilationFinal ConditionProfile isMinusOne_;

        PreviousWithHolesCachedData(PreviousWithHolesCachedData next_) {
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
    @GeneratedBy(JSArrayPreviousElementIndexNode.class)
    private static final class PreviousWithHolesUncachedData extends Node {

        @Child JSArrayPreviousElementIndexNode previousElementIndexNode_;
        @CompilationFinal ConditionProfile isMinusOne_;
        @CompilationFinal ValueProfile arrayTypeProfile_;

        PreviousWithHolesUncachedData() {
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
