// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.function.JSFunctionCallNode;
import com.oracle.truffle.js.nodes.unary.IsCallableNode;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.objects.IteratorRecord;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(GetIteratorNode.class)
public final class GetIteratorNodeGen extends GetIteratorNode implements Provider {

    @CompilationFinal private volatile int state_;
    @Child private GetIteratorData getIterator_cache;
    @Child private EnumerateNode foreignIterable_enumerateNode_;

    private GetIteratorNodeGen(JSContext context, JavaScriptNode objectNode) {
        super(context, objectNode);
    }

    @Override
    public IteratorRecord execute(Object objectNodeValue) {
        int state = state_;
        if (state != 0 /* is-active doGetIterator(Object, IsCallableNode, JSFunctionCallNode, IsJSObjectNode) || doForeignIterable(Object, EnumerateNode) */) {
            if ((state & 0b1) != 0 /* is-active doGetIterator(Object, IsCallableNode, JSFunctionCallNode, IsJSObjectNode) */) {
                GetIteratorData s1_ = this.getIterator_cache;
                if (s1_ != null) {
                    if ((!(JSGuards.isForeignObject(objectNodeValue)))) {
                        return doGetIterator(objectNodeValue, s1_.isCallableNode_, s1_.methodCallNode_, s1_.isObjectNode_);
                    }
                }
            }
            if ((state & 0b10) != 0 /* is-active doForeignIterable(Object, EnumerateNode) */) {
                if ((JSGuards.isForeignObject(objectNodeValue))) {
                    return doForeignIterable(objectNodeValue, this.foreignIterable_enumerateNode_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(objectNodeValue);
    }

    @Override
    public IteratorRecord execute(VirtualFrame frameValue) {
        int state = state_;
        Object objectNodeValue_ = super.objectNode.execute(frameValue);
        if (state != 0 /* is-active doGetIterator(Object, IsCallableNode, JSFunctionCallNode, IsJSObjectNode) || doForeignIterable(Object, EnumerateNode) */) {
            if ((state & 0b1) != 0 /* is-active doGetIterator(Object, IsCallableNode, JSFunctionCallNode, IsJSObjectNode) */) {
                GetIteratorData s1_ = this.getIterator_cache;
                if (s1_ != null) {
                    if ((!(JSGuards.isForeignObject(objectNodeValue_)))) {
                        return doGetIterator(objectNodeValue_, s1_.isCallableNode_, s1_.methodCallNode_, s1_.isObjectNode_);
                    }
                }
            }
            if ((state & 0b10) != 0 /* is-active doForeignIterable(Object, EnumerateNode) */) {
                if ((JSGuards.isForeignObject(objectNodeValue_))) {
                    return doForeignIterable(objectNodeValue_, this.foreignIterable_enumerateNode_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(objectNodeValue_);
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        execute(frameValue);
        return;
    }

    private IteratorRecord executeAndSpecialize(Object objectNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        try {
            if ((!(JSGuards.isForeignObject(objectNodeValue)))) {
                GetIteratorData s1_ = super.insert(new GetIteratorData());
                s1_.isCallableNode_ = s1_.insertAccessor((IsCallableNode.create()));
                s1_.methodCallNode_ = s1_.insertAccessor((JSFunctionCallNode.createCall()));
                s1_.isObjectNode_ = s1_.insertAccessor((IsJSObjectNode.create()));
                this.getIterator_cache = s1_;
                this.state_ = state = state | 0b1 /* add-active doGetIterator(Object, IsCallableNode, JSFunctionCallNode, IsJSObjectNode) */;
                lock.unlock();
                hasLock = false;
                return doGetIterator(objectNodeValue, s1_.isCallableNode_, s1_.methodCallNode_, s1_.isObjectNode_);
            }
            if ((JSGuards.isForeignObject(objectNodeValue))) {
                this.foreignIterable_enumerateNode_ = super.insert((createEnumerateValues()));
                this.state_ = state = state | 0b10 /* add-active doForeignIterable(Object, EnumerateNode) */;
                lock.unlock();
                hasLock = false;
                return doForeignIterable(objectNodeValue, this.foreignIterable_enumerateNode_);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {super.objectNode}, objectNodeValue);
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
        s = new Object[3];
        s[0] = "doGetIterator";
        if ((state & 0b1) != 0 /* is-active doGetIterator(Object, IsCallableNode, JSFunctionCallNode, IsJSObjectNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            GetIteratorData s1_ = this.getIterator_cache;
            if (s1_ != null) {
                cached.add(Arrays.asList(s1_.isCallableNode_, s1_.methodCallNode_, s1_.isObjectNode_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doForeignIterable";
        if ((state & 0b10) != 0 /* is-active doForeignIterable(Object, EnumerateNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.foreignIterable_enumerateNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        return Provider.create(data);
    }

    public static GetIteratorNode create(JSContext context, JavaScriptNode objectNode) {
        return new GetIteratorNodeGen(context, objectNode);
    }

    @GeneratedBy(GetIteratorNode.class)
    private static final class GetIteratorData extends Node {

        @Child IsCallableNode isCallableNode_;
        @Child JSFunctionCallNode methodCallNode_;
        @Child IsJSObjectNode isObjectNode_;

        GetIteratorData() {
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
