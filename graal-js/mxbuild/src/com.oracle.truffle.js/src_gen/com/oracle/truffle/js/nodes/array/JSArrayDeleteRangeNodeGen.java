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
import com.oracle.truffle.js.nodes.control.DeletePropertyNode;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.array.ScriptArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSArrayDeleteRangeNode.class)
public final class JSArrayDeleteRangeNodeGen extends JSArrayDeleteRangeNode implements Provider {

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @Child private DenseArrayData denseArray_cache;
    @Child private SparseArrayData sparseArray_cache;
    @Child private DeletePropertyNode uncached_deletePropertyNode_;
    @Child private JSArrayNextElementIndexNode uncached_nextElementIndexNode_;

    private JSArrayDeleteRangeNodeGen(JSContext context, boolean orThrow) {
        super(context, orThrow);
    }

    @ExplodeLoop
    @Override
    public void execute(DynamicObject arg0Value, ScriptArray arg1Value, long arg2Value, long arg3Value) {
        int state = state_;
        if (state != 0 /* is-active denseArray(DynamicObject, ScriptArray, long, long, ScriptArray, DeletePropertyNode) || sparseArray(DynamicObject, ScriptArray, long, long, ScriptArray, DeletePropertyNode, JSArrayNextElementIndexNode) || doUncached(DynamicObject, ScriptArray, long, long, DeletePropertyNode, JSArrayNextElementIndexNode) */) {
            if ((state & 0b1) != 0 /* is-active denseArray(DynamicObject, ScriptArray, long, long, ScriptArray, DeletePropertyNode) */) {
                DenseArrayData s1_ = this.denseArray_cache;
                while (s1_ != null) {
                    if ((s1_.cachedArrayType_.isInstance(arg1Value))) {
                        assert (!(s1_.cachedArrayType_.isHolesType()));
                        denseArray(arg0Value, arg1Value, arg2Value, arg3Value, s1_.cachedArrayType_, s1_.deletePropertyNode_);
                        return;
                    }
                    s1_ = s1_.next_;
                }
            }
            if ((state & 0b10) != 0 /* is-active sparseArray(DynamicObject, ScriptArray, long, long, ScriptArray, DeletePropertyNode, JSArrayNextElementIndexNode) */) {
                SparseArrayData s2_ = this.sparseArray_cache;
                while (s2_ != null) {
                    if ((s2_.cachedArrayType_.isInstance(arg1Value))) {
                        assert (s2_.cachedArrayType_.isHolesType());
                        sparseArray(arg0Value, arg1Value, arg2Value, arg3Value, s2_.cachedArrayType_, s2_.deletePropertyNode_, s2_.nextElementIndexNode_);
                        return;
                    }
                    s2_ = s2_.next_;
                }
            }
            if ((state & 0b100) != 0 /* is-active doUncached(DynamicObject, ScriptArray, long, long, DeletePropertyNode, JSArrayNextElementIndexNode) */) {
                doUncached(arg0Value, arg1Value, arg2Value, arg3Value, this.uncached_deletePropertyNode_, this.uncached_nextElementIndexNode_);
                return;
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        executeAndSpecialize(arg0Value, arg1Value, arg2Value, arg3Value);
        return;
    }

    private void executeAndSpecialize(DynamicObject arg0Value, ScriptArray arg1Value, long arg2Value, long arg3Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        int exclude = exclude_;
        try {
            if (((exclude & 0b1)) == 0 /* is-not-excluded denseArray(DynamicObject, ScriptArray, long, long, ScriptArray, DeletePropertyNode) */) {
                int count1_ = 0;
                DenseArrayData s1_ = this.denseArray_cache;
                if ((state & 0b1) != 0 /* is-active denseArray(DynamicObject, ScriptArray, long, long, ScriptArray, DeletePropertyNode) */) {
                    while (s1_ != null) {
                        if ((s1_.cachedArrayType_.isInstance(arg1Value))) {
                            assert (!(s1_.cachedArrayType_.isHolesType()));
                            break;
                        }
                        s1_ = s1_.next_;
                        count1_++;
                    }
                }
                if (s1_ == null) {
                    {
                        ScriptArray cachedArrayType__ = (arg1Value);
                        if ((cachedArrayType__.isInstance(arg1Value)) && (!(cachedArrayType__.isHolesType())) && count1_ < (5)) {
                            s1_ = super.insert(new DenseArrayData(denseArray_cache));
                            s1_.cachedArrayType_ = cachedArrayType__;
                            s1_.deletePropertyNode_ = s1_.insertAccessor((DeletePropertyNode.create(orThrow, context)));
                            this.denseArray_cache = s1_;
                            this.state_ = state = state | 0b1 /* add-active denseArray(DynamicObject, ScriptArray, long, long, ScriptArray, DeletePropertyNode) */;
                        }
                    }
                }
                if (s1_ != null) {
                    lock.unlock();
                    hasLock = false;
                    denseArray(arg0Value, arg1Value, arg2Value, arg3Value, s1_.cachedArrayType_, s1_.deletePropertyNode_);
                    return;
                }
            }
            if (((exclude & 0b10)) == 0 /* is-not-excluded sparseArray(DynamicObject, ScriptArray, long, long, ScriptArray, DeletePropertyNode, JSArrayNextElementIndexNode) */) {
                int count2_ = 0;
                SparseArrayData s2_ = this.sparseArray_cache;
                if ((state & 0b10) != 0 /* is-active sparseArray(DynamicObject, ScriptArray, long, long, ScriptArray, DeletePropertyNode, JSArrayNextElementIndexNode) */) {
                    while (s2_ != null) {
                        if ((s2_.cachedArrayType_.isInstance(arg1Value))) {
                            assert (s2_.cachedArrayType_.isHolesType());
                            break;
                        }
                        s2_ = s2_.next_;
                        count2_++;
                    }
                }
                if (s2_ == null) {
                    {
                        ScriptArray cachedArrayType__1 = (arg1Value);
                        if ((cachedArrayType__1.isInstance(arg1Value)) && (cachedArrayType__1.isHolesType()) && count2_ < (5)) {
                            s2_ = super.insert(new SparseArrayData(sparseArray_cache));
                            s2_.cachedArrayType_ = cachedArrayType__1;
                            s2_.deletePropertyNode_ = s2_.insertAccessor((DeletePropertyNode.create(orThrow, context)));
                            s2_.nextElementIndexNode_ = s2_.insertAccessor((JSArrayNextElementIndexNode.create(context)));
                            this.sparseArray_cache = s2_;
                            this.state_ = state = state | 0b10 /* add-active sparseArray(DynamicObject, ScriptArray, long, long, ScriptArray, DeletePropertyNode, JSArrayNextElementIndexNode) */;
                        }
                    }
                }
                if (s2_ != null) {
                    lock.unlock();
                    hasLock = false;
                    sparseArray(arg0Value, arg1Value, arg2Value, arg3Value, s2_.cachedArrayType_, s2_.deletePropertyNode_, s2_.nextElementIndexNode_);
                    return;
                }
            }
            this.uncached_deletePropertyNode_ = super.insert((DeletePropertyNode.create(orThrow, context)));
            this.uncached_nextElementIndexNode_ = super.insert((JSArrayNextElementIndexNode.create(context)));
            this.exclude_ = exclude = exclude | 0b11 /* add-excluded denseArray(DynamicObject, ScriptArray, long, long, ScriptArray, DeletePropertyNode), sparseArray(DynamicObject, ScriptArray, long, long, ScriptArray, DeletePropertyNode, JSArrayNextElementIndexNode) */;
            this.denseArray_cache = null;
            this.sparseArray_cache = null;
            state = state & 0xfffffffc /* remove-active denseArray(DynamicObject, ScriptArray, long, long, ScriptArray, DeletePropertyNode), sparseArray(DynamicObject, ScriptArray, long, long, ScriptArray, DeletePropertyNode, JSArrayNextElementIndexNode) */;
            this.state_ = state = state | 0b100 /* add-active doUncached(DynamicObject, ScriptArray, long, long, DeletePropertyNode, JSArrayNextElementIndexNode) */;
            lock.unlock();
            hasLock = false;
            doUncached(arg0Value, arg1Value, arg2Value, arg3Value, this.uncached_deletePropertyNode_, this.uncached_nextElementIndexNode_);
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
            DenseArrayData s1_ = this.denseArray_cache;
            SparseArrayData s2_ = this.sparseArray_cache;
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
        s[0] = "denseArray";
        if ((state & 0b1) != 0 /* is-active denseArray(DynamicObject, ScriptArray, long, long, ScriptArray, DeletePropertyNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            DenseArrayData s1_ = this.denseArray_cache;
            while (s1_ != null) {
                cached.add(Arrays.asList(s1_.cachedArrayType_, s1_.deletePropertyNode_));
                s1_ = s1_.next_;
            }
            s[2] = cached;
        } else if ((exclude & 0b1) != 0 /* is-excluded denseArray(DynamicObject, ScriptArray, long, long, ScriptArray, DeletePropertyNode) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "sparseArray";
        if ((state & 0b10) != 0 /* is-active sparseArray(DynamicObject, ScriptArray, long, long, ScriptArray, DeletePropertyNode, JSArrayNextElementIndexNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            SparseArrayData s2_ = this.sparseArray_cache;
            while (s2_ != null) {
                cached.add(Arrays.asList(s2_.cachedArrayType_, s2_.deletePropertyNode_, s2_.nextElementIndexNode_));
                s2_ = s2_.next_;
            }
            s[2] = cached;
        } else if ((exclude & 0b10) != 0 /* is-excluded sparseArray(DynamicObject, ScriptArray, long, long, ScriptArray, DeletePropertyNode, JSArrayNextElementIndexNode) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doUncached";
        if ((state & 0b100) != 0 /* is-active doUncached(DynamicObject, ScriptArray, long, long, DeletePropertyNode, JSArrayNextElementIndexNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.uncached_deletePropertyNode_, this.uncached_nextElementIndexNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        return Provider.create(data);
    }

    public static JSArrayDeleteRangeNode create(JSContext context, boolean orThrow) {
        return new JSArrayDeleteRangeNodeGen(context, orThrow);
    }

    @GeneratedBy(JSArrayDeleteRangeNode.class)
    private static final class DenseArrayData extends Node {

        @Child DenseArrayData next_;
        @CompilationFinal ScriptArray cachedArrayType_;
        @Child DeletePropertyNode deletePropertyNode_;

        DenseArrayData(DenseArrayData next_) {
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
    @GeneratedBy(JSArrayDeleteRangeNode.class)
    private static final class SparseArrayData extends Node {

        @Child SparseArrayData next_;
        @CompilationFinal ScriptArray cachedArrayType_;
        @Child DeletePropertyNode deletePropertyNode_;
        @Child JSArrayNextElementIndexNode nextElementIndexNode_;

        SparseArrayData(SparseArrayData next_) {
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
}
