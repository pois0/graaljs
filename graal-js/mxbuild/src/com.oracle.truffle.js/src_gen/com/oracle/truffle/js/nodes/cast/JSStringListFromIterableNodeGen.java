// CheckStyle: start generated
package com.oracle.truffle.js.nodes.cast;

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
import com.oracle.truffle.js.nodes.access.GetIteratorNode;
import com.oracle.truffle.js.nodes.access.IteratorCloseNode;
import com.oracle.truffle.js.nodes.access.IteratorStepNode;
import com.oracle.truffle.js.nodes.access.IteratorValueNode;
import com.oracle.truffle.js.runtime.JSContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSStringListFromIterableNode.class)
public final class JSStringListFromIterableNodeGen extends JSStringListFromIterableNode implements Provider {

    @CompilationFinal private volatile int state_;
    @Child private ToArrayData toArray_cache;

    private JSStringListFromIterableNodeGen(JSContext context) {
        super(context);
    }

    @Override
    public List<String> executeIterable(Object arg0Value) {
        int state = state_;
        if ((state & 0b1) != 0 /* is-active stringToList(Object) */) {
            if ((JSGuards.isString(arg0Value))) {
                return JSStringListFromIterableNode.stringToList(arg0Value);
            }
        }
        if ((state & 0b10) != 0 /* is-active toArray(DynamicObject, GetIteratorNode, IteratorStepNode, IteratorValueNode, IteratorCloseNode) */ && JSTypes.isDynamicObject(arg0Value)) {
            DynamicObject arg0Value_ = (DynamicObject) arg0Value;
            ToArrayData s2_ = this.toArray_cache;
            if (s2_ != null) {
                if ((!(JSGuards.isUndefined(arg0Value_))) && (!(JSGuards.isString(arg0Value_)))) {
                    return JSStringListFromIterableNode.toArray(arg0Value_, s2_.getIteratorNode_, s2_.iteratorStepNode_, s2_.iteratorValueNode_, s2_.iteratorCloseNode_);
                }
            }
        }
        if ((state & 0b100) != 0 /* is-active doUndefined(Object) */) {
            if ((JSGuards.isUndefined(arg0Value))) {
                return doUndefined(arg0Value);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    private List<String> executeAndSpecialize(Object arg0Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        try {
            if ((JSGuards.isString(arg0Value))) {
                this.state_ = state = state | 0b1 /* add-active stringToList(Object) */;
                lock.unlock();
                hasLock = false;
                return JSStringListFromIterableNode.stringToList(arg0Value);
            }
            if (JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if ((!(JSGuards.isUndefined(arg0Value_))) && (!(JSGuards.isString(arg0Value_)))) {
                    ToArrayData s2_ = super.insert(new ToArrayData());
                    s2_.getIteratorNode_ = s2_.insertAccessor((GetIteratorNode.create(context)));
                    s2_.iteratorStepNode_ = s2_.insertAccessor((IteratorStepNode.create(context)));
                    s2_.iteratorValueNode_ = s2_.insertAccessor((IteratorValueNode.create(context)));
                    s2_.iteratorCloseNode_ = s2_.insertAccessor((IteratorCloseNode.create(context)));
                    this.toArray_cache = s2_;
                    this.state_ = state = state | 0b10 /* add-active toArray(DynamicObject, GetIteratorNode, IteratorStepNode, IteratorValueNode, IteratorCloseNode) */;
                    lock.unlock();
                    hasLock = false;
                    return JSStringListFromIterableNode.toArray(arg0Value_, s2_.getIteratorNode_, s2_.iteratorStepNode_, s2_.iteratorValueNode_, s2_.iteratorCloseNode_);
                }
            }
            if ((JSGuards.isUndefined(arg0Value))) {
                this.state_ = state = state | 0b100 /* add-active doUndefined(Object) */;
                lock.unlock();
                hasLock = false;
                return doUndefined(arg0Value);
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
        s[0] = "stringToList";
        if ((state & 0b1) != 0 /* is-active stringToList(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "toArray";
        if ((state & 0b10) != 0 /* is-active toArray(DynamicObject, GetIteratorNode, IteratorStepNode, IteratorValueNode, IteratorCloseNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            ToArrayData s2_ = this.toArray_cache;
            if (s2_ != null) {
                cached.add(Arrays.asList(s2_.getIteratorNode_, s2_.iteratorStepNode_, s2_.iteratorValueNode_, s2_.iteratorCloseNode_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doUndefined";
        if ((state & 0b100) != 0 /* is-active doUndefined(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        return Provider.create(data);
    }

    public static JSStringListFromIterableNode create(JSContext context) {
        return new JSStringListFromIterableNodeGen(context);
    }

    @GeneratedBy(JSStringListFromIterableNode.class)
    private static final class ToArrayData extends Node {

        @Child GetIteratorNode getIteratorNode_;
        @Child IteratorStepNode iteratorStepNode_;
        @Child IteratorValueNode iteratorValueNode_;
        @Child IteratorCloseNode iteratorCloseNode_;

        ToArrayData() {
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
