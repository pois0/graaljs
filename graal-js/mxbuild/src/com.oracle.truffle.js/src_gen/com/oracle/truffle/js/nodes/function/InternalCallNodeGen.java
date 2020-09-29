// CheckStyle: start generated
package com.oracle.truffle.js.nodes.function;

import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.nodes.DirectCallNode;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.IndirectCallNode;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(InternalCallNode.class)
public final class InternalCallNodeGen extends InternalCallNode implements Provider {

    @CompilationFinal private volatile int state_;
    @Child private DirectCallData directCall_cache;
    @Child private IndirectCallNode indirectCall_indirectCallNode_;

    private InternalCallNodeGen() {
    }

    @ExplodeLoop
    @Override
    public Object execute(CallTarget arg0Value, Object[] arg1Value) {
        int state = state_;
        if (state != 0 /* is-active directCall(CallTarget, Object[], CallTarget, DirectCallNode) || indirectCall(CallTarget, Object[], IndirectCallNode) */) {
            if ((state & 0b1) != 0 /* is-active directCall(CallTarget, Object[], CallTarget, DirectCallNode) */) {
                DirectCallData s1_ = this.directCall_cache;
                while (s1_ != null) {
                    if ((arg0Value == s1_.cachedCallTarget_)) {
                        return InternalCallNode.directCall(arg0Value, arg1Value, s1_.cachedCallTarget_, s1_.directCallNode_);
                    }
                    s1_ = s1_.next_;
                }
            }
            if ((state & 0b10) != 0 /* is-active indirectCall(CallTarget, Object[], IndirectCallNode) */) {
                return InternalCallNode.indirectCall(arg0Value, arg1Value, this.indirectCall_indirectCallNode_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value);
    }

    private Object executeAndSpecialize(CallTarget arg0Value, Object[] arg1Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        try {
            int count1_ = 0;
            DirectCallData s1_ = this.directCall_cache;
            if ((state & 0b1) != 0 /* is-active directCall(CallTarget, Object[], CallTarget, DirectCallNode) */) {
                while (s1_ != null) {
                    if ((arg0Value == s1_.cachedCallTarget_)) {
                        break;
                    }
                    s1_ = s1_.next_;
                    count1_++;
                }
            }
            if (s1_ == null) {
                // assert (arg0Value == s1_.cachedCallTarget_);
                if (count1_ < (InternalCallNode.LIMIT)) {
                    s1_ = super.insert(new DirectCallData(directCall_cache));
                    s1_.cachedCallTarget_ = (arg0Value);
                    s1_.directCallNode_ = s1_.insertAccessor((DirectCallNode.create(s1_.cachedCallTarget_)));
                    this.directCall_cache = s1_;
                    this.state_ = state = state | 0b1 /* add-active directCall(CallTarget, Object[], CallTarget, DirectCallNode) */;
                }
            }
            if (s1_ != null) {
                lock.unlock();
                hasLock = false;
                return InternalCallNode.directCall(arg0Value, arg1Value, s1_.cachedCallTarget_, s1_.directCallNode_);
            }
            this.indirectCall_indirectCallNode_ = super.insert((IndirectCallNode.create()));
            this.state_ = state = state | 0b10 /* add-active indirectCall(CallTarget, Object[], IndirectCallNode) */;
            lock.unlock();
            hasLock = false;
            return InternalCallNode.indirectCall(arg0Value, arg1Value, this.indirectCall_indirectCallNode_);
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
            DirectCallData s1_ = this.directCall_cache;
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
        s = new Object[3];
        s[0] = "directCall";
        if ((state & 0b1) != 0 /* is-active directCall(CallTarget, Object[], CallTarget, DirectCallNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            DirectCallData s1_ = this.directCall_cache;
            while (s1_ != null) {
                cached.add(Arrays.asList(s1_.cachedCallTarget_, s1_.directCallNode_));
                s1_ = s1_.next_;
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "indirectCall";
        if ((state & 0b10) != 0 /* is-active indirectCall(CallTarget, Object[], IndirectCallNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.indirectCall_indirectCallNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        return Provider.create(data);
    }

    public static InternalCallNode create() {
        return new InternalCallNodeGen();
    }

    @GeneratedBy(InternalCallNode.class)
    private static final class DirectCallData extends Node {

        @Child DirectCallData next_;
        @CompilationFinal CallTarget cachedCallTarget_;
        @Child DirectCallNode directCallNode_;

        DirectCallData(DirectCallData next_) {
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
