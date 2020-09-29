// CheckStyle: start generated
package com.oracle.truffle.js.nodes.array;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.js.nodes.access.ReadElementNode;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.array.ScriptArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSArrayToDenseObjectArrayNode.class)
public final class JSArrayToDenseObjectArrayNodeGen extends JSArrayToDenseObjectArrayNode implements Provider {

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @Child private FromDenseArrayData fromDenseArray_cache;
    @Child private FromSparseArrayData fromSparseArray_cache;
    @Child private UncachedData uncached_cache;

    private JSArrayToDenseObjectArrayNodeGen(JSContext context) {
        super(context);
    }

    @ExplodeLoop
    @Override
    public Object[] executeObjectArray(DynamicObject arg0Value, ScriptArray arg1Value, long arg2Value) {
        int state = state_;
        if (state != 0 /* is-active fromDenseArray(DynamicObject, ScriptArray, long, ScriptArray, ReadElementNode) || fromSparseArray(DynamicObject, ScriptArray, long, ScriptArray, JSArrayNextElementIndexNode, BranchProfile) || doUncached(DynamicObject, ScriptArray, long, JSArrayNextElementIndexNode, ReadElementNode, BranchProfile) */) {
            if ((state & 0b1) != 0 /* is-active fromDenseArray(DynamicObject, ScriptArray, long, ScriptArray, ReadElementNode) */) {
                FromDenseArrayData s1_ = this.fromDenseArray_cache;
                while (s1_ != null) {
                    if ((s1_.cachedArrayType_.isInstance(arg1Value))) {
                        assert (!(s1_.cachedArrayType_.isHolesType()));
                        if ((!(s1_.cachedArrayType_.hasHoles(arg0Value)))) {
                            return fromDenseArray(arg0Value, arg1Value, arg2Value, s1_.cachedArrayType_, s1_.readNode_);
                        }
                    }
                    s1_ = s1_.next_;
                }
            }
            if ((state & 0b10) != 0 /* is-active fromSparseArray(DynamicObject, ScriptArray, long, ScriptArray, JSArrayNextElementIndexNode, BranchProfile) */) {
                FromSparseArrayData s2_ = this.fromSparseArray_cache;
                while (s2_ != null) {
                    if ((s2_.cachedArrayType_.isInstance(arg1Value)) && (s2_.cachedArrayType_.isHolesType() || s2_.cachedArrayType_.hasHoles(arg0Value))) {
                        return fromSparseArray(arg0Value, arg1Value, arg2Value, s2_.cachedArrayType_, s2_.nextElementIndexNode_, s2_.growProfile_);
                    }
                    s2_ = s2_.next_;
                }
            }
            if ((state & 0b100) != 0 /* is-active doUncached(DynamicObject, ScriptArray, long, JSArrayNextElementIndexNode, ReadElementNode, BranchProfile) */) {
                UncachedData s3_ = this.uncached_cache;
                if (s3_ != null) {
                    return doUncached(arg0Value, arg1Value, arg2Value, s3_.nextElementIndexNode_, s3_.readNode_, s3_.growProfile_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value, arg2Value);
    }

    private Object[] executeAndSpecialize(DynamicObject arg0Value, ScriptArray arg1Value, long arg2Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        int exclude = exclude_;
        try {
            if (((exclude & 0b1)) == 0 /* is-not-excluded fromDenseArray(DynamicObject, ScriptArray, long, ScriptArray, ReadElementNode) */) {
                int count1_ = 0;
                FromDenseArrayData s1_ = this.fromDenseArray_cache;
                if ((state & 0b1) != 0 /* is-active fromDenseArray(DynamicObject, ScriptArray, long, ScriptArray, ReadElementNode) */) {
                    while (s1_ != null) {
                        if ((s1_.cachedArrayType_.isInstance(arg1Value))) {
                            assert (!(s1_.cachedArrayType_.isHolesType()));
                            if ((!(s1_.cachedArrayType_.hasHoles(arg0Value)))) {
                                break;
                            }
                        }
                        s1_ = s1_.next_;
                        count1_++;
                    }
                }
                if (s1_ == null) {
                    {
                        ScriptArray cachedArrayType__ = (arg1Value);
                        if ((cachedArrayType__.isInstance(arg1Value)) && (!(cachedArrayType__.isHolesType())) && (!(cachedArrayType__.hasHoles(arg0Value))) && count1_ < (5)) {
                            s1_ = super.insert(new FromDenseArrayData(fromDenseArray_cache));
                            s1_.cachedArrayType_ = cachedArrayType__;
                            s1_.readNode_ = s1_.insertAccessor((ReadElementNode.create(context)));
                            this.fromDenseArray_cache = s1_;
                            this.state_ = state = state | 0b1 /* add-active fromDenseArray(DynamicObject, ScriptArray, long, ScriptArray, ReadElementNode) */;
                        }
                    }
                }
                if (s1_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return fromDenseArray(arg0Value, arg1Value, arg2Value, s1_.cachedArrayType_, s1_.readNode_);
                }
            }
            if (((exclude & 0b10)) == 0 /* is-not-excluded fromSparseArray(DynamicObject, ScriptArray, long, ScriptArray, JSArrayNextElementIndexNode, BranchProfile) */) {
                int count2_ = 0;
                FromSparseArrayData s2_ = this.fromSparseArray_cache;
                if ((state & 0b10) != 0 /* is-active fromSparseArray(DynamicObject, ScriptArray, long, ScriptArray, JSArrayNextElementIndexNode, BranchProfile) */) {
                    while (s2_ != null) {
                        if ((s2_.cachedArrayType_.isInstance(arg1Value)) && (s2_.cachedArrayType_.isHolesType() || s2_.cachedArrayType_.hasHoles(arg0Value))) {
                            break;
                        }
                        s2_ = s2_.next_;
                        count2_++;
                    }
                }
                if (s2_ == null) {
                    {
                        ScriptArray cachedArrayType__1 = (arg1Value);
                        if ((cachedArrayType__1.isInstance(arg1Value)) && (cachedArrayType__1.isHolesType() || cachedArrayType__1.hasHoles(arg0Value)) && count2_ < (5)) {
                            s2_ = super.insert(new FromSparseArrayData(fromSparseArray_cache));
                            s2_.cachedArrayType_ = cachedArrayType__1;
                            s2_.nextElementIndexNode_ = s2_.insertAccessor((JSArrayNextElementIndexNode.create(context)));
                            s2_.growProfile_ = (BranchProfile.create());
                            this.fromSparseArray_cache = s2_;
                            this.state_ = state = state | 0b10 /* add-active fromSparseArray(DynamicObject, ScriptArray, long, ScriptArray, JSArrayNextElementIndexNode, BranchProfile) */;
                        }
                    }
                }
                if (s2_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return fromSparseArray(arg0Value, arg1Value, arg2Value, s2_.cachedArrayType_, s2_.nextElementIndexNode_, s2_.growProfile_);
                }
            }
            UncachedData s3_ = super.insert(new UncachedData());
            s3_.nextElementIndexNode_ = s3_.insertAccessor((JSArrayNextElementIndexNode.create(context)));
            s3_.readNode_ = s3_.insertAccessor((ReadElementNode.create(context)));
            s3_.growProfile_ = (BranchProfile.create());
            this.uncached_cache = s3_;
            this.exclude_ = exclude = exclude | 0b11 /* add-excluded fromDenseArray(DynamicObject, ScriptArray, long, ScriptArray, ReadElementNode), fromSparseArray(DynamicObject, ScriptArray, long, ScriptArray, JSArrayNextElementIndexNode, BranchProfile) */;
            this.fromDenseArray_cache = null;
            this.fromSparseArray_cache = null;
            state = state & 0xfffffffc /* remove-active fromDenseArray(DynamicObject, ScriptArray, long, ScriptArray, ReadElementNode), fromSparseArray(DynamicObject, ScriptArray, long, ScriptArray, JSArrayNextElementIndexNode, BranchProfile) */;
            this.state_ = state = state | 0b100 /* add-active doUncached(DynamicObject, ScriptArray, long, JSArrayNextElementIndexNode, ReadElementNode, BranchProfile) */;
            lock.unlock();
            hasLock = false;
            return doUncached(arg0Value, arg1Value, arg2Value, s3_.nextElementIndexNode_, s3_.readNode_, s3_.growProfile_);
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
            FromDenseArrayData s1_ = this.fromDenseArray_cache;
            FromSparseArrayData s2_ = this.fromSparseArray_cache;
            if ((s1_ == null || s1_.next_ == null) && (s2_ == null || s2_.next_ == null)) {
                return NodeCost.MONOMORPHIC;
            }
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
        s[0] = "fromDenseArray";
        if ((state & 0b1) != 0 /* is-active fromDenseArray(DynamicObject, ScriptArray, long, ScriptArray, ReadElementNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            FromDenseArrayData s1_ = this.fromDenseArray_cache;
            while (s1_ != null) {
                cached.add(Arrays.asList(s1_.cachedArrayType_, s1_.readNode_));
                s1_ = s1_.next_;
            }
            s[2] = cached;
        } else if ((exclude & 0b1) != 0 /* is-excluded fromDenseArray(DynamicObject, ScriptArray, long, ScriptArray, ReadElementNode) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "fromSparseArray";
        if ((state & 0b10) != 0 /* is-active fromSparseArray(DynamicObject, ScriptArray, long, ScriptArray, JSArrayNextElementIndexNode, BranchProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            FromSparseArrayData s2_ = this.fromSparseArray_cache;
            while (s2_ != null) {
                cached.add(Arrays.asList(s2_.cachedArrayType_, s2_.nextElementIndexNode_, s2_.growProfile_));
                s2_ = s2_.next_;
            }
            s[2] = cached;
        } else if ((exclude & 0b10) != 0 /* is-excluded fromSparseArray(DynamicObject, ScriptArray, long, ScriptArray, JSArrayNextElementIndexNode, BranchProfile) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doUncached";
        if ((state & 0b100) != 0 /* is-active doUncached(DynamicObject, ScriptArray, long, JSArrayNextElementIndexNode, ReadElementNode, BranchProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            UncachedData s3_ = this.uncached_cache;
            if (s3_ != null) {
                cached.add(Arrays.asList(s3_.nextElementIndexNode_, s3_.readNode_, s3_.growProfile_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        return Provider.create(data);
    }

    public static JSArrayToDenseObjectArrayNode create(JSContext context) {
        return new JSArrayToDenseObjectArrayNodeGen(context);
    }

    @GeneratedBy(JSArrayToDenseObjectArrayNode.class)
    private static final class FromDenseArrayData extends Node {

        @Child FromDenseArrayData next_;
        @CompilationFinal ScriptArray cachedArrayType_;
        @Child ReadElementNode readNode_;

        FromDenseArrayData(FromDenseArrayData next_) {
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
    @GeneratedBy(JSArrayToDenseObjectArrayNode.class)
    private static final class FromSparseArrayData extends Node {

        @Child FromSparseArrayData next_;
        @CompilationFinal ScriptArray cachedArrayType_;
        @Child JSArrayNextElementIndexNode nextElementIndexNode_;
        @CompilationFinal BranchProfile growProfile_;

        FromSparseArrayData(FromSparseArrayData next_) {
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
    @GeneratedBy(JSArrayToDenseObjectArrayNode.class)
    private static final class UncachedData extends Node {

        @Child JSArrayNextElementIndexNode nextElementIndexNode_;
        @Child ReadElementNode readNode_;
        @CompilationFinal BranchProfile growProfile_;

        UncachedData() {
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
