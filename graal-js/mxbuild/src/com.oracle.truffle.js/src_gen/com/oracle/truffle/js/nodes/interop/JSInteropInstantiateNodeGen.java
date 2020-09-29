// CheckStyle: start generated
package com.oracle.truffle.js.nodes.interop;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.nodes.function.JSFunctionCallNode;
import com.oracle.truffle.js.nodes.unary.IsConstructorNode;
import com.oracle.truffle.js.nodes.unary.IsConstructorNodeGen;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSInteropInstantiateNode.class)
public final class JSInteropInstantiateNodeGen extends JSInteropInstantiateNode implements Provider {

    private static final Uncached UNCACHED = new Uncached();

    @CompilationFinal private volatile int state_;
    @Child private DefaultData default_cache;

    private JSInteropInstantiateNodeGen() {
    }

    @Override
    public Object execute(DynamicObject arg0Value, Object[] arg1Value) throws UnsupportedMessageException {
        int state = state_;
        if (state != 0 /* is-active doDefault(DynamicObject, Object[], IsConstructorNode, JSFunctionCallNode, ImportValueNode) */) {
            DefaultData s1_ = this.default_cache;
            if (s1_ != null) {
                return doDefault(arg0Value, arg1Value, s1_.isConstructorNode_, s1_.callNode_, s1_.importValueNode_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value);
    }

    private Object executeAndSpecialize(DynamicObject arg0Value, Object[] arg1Value) throws UnsupportedMessageException {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        try {
            DefaultData s1_ = super.insert(new DefaultData());
            s1_.isConstructorNode_ = s1_.insertAccessor((IsConstructorNode.create()));
            s1_.callNode_ = s1_.insertAccessor((JSFunctionCallNode.createNew()));
            s1_.importValueNode_ = s1_.insertAccessor((ImportValueNode.create()));
            this.default_cache = s1_;
            this.state_ = state = state | 0b1 /* add-active doDefault(DynamicObject, Object[], IsConstructorNode, JSFunctionCallNode, ImportValueNode) */;
            lock.unlock();
            hasLock = false;
            return doDefault(arg0Value, arg1Value, s1_.isConstructorNode_, s1_.callNode_, s1_.importValueNode_);
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
        } else {
            return NodeCost.MONOMORPHIC;
        }
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[2];
        Object[] s;
        data[0] = 0;
        int state = state_;
        s = new Object[3];
        s[0] = "doDefault";
        if (state != 0 /* is-active doDefault(DynamicObject, Object[], IsConstructorNode, JSFunctionCallNode, ImportValueNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            DefaultData s1_ = this.default_cache;
            if (s1_ != null) {
                cached.add(Arrays.asList(s1_.isConstructorNode_, s1_.callNode_, s1_.importValueNode_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        return Provider.create(data);
    }

    public static JSInteropInstantiateNode create() {
        return new JSInteropInstantiateNodeGen();
    }

    public static JSInteropInstantiateNode getUncached() {
        return JSInteropInstantiateNodeGen.UNCACHED;
    }

    @GeneratedBy(JSInteropInstantiateNode.class)
    private static final class DefaultData extends Node {

        @Child IsConstructorNode isConstructorNode_;
        @Child JSFunctionCallNode callNode_;
        @Child ImportValueNode importValueNode_;

        DefaultData() {
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.NONE;
        }

        <T extends Node> T insertAccessor(T node) {
            return super.insert(node);
        }

    }
    @GeneratedBy(JSInteropInstantiateNode.class)
    private static final class Uncached extends JSInteropInstantiateNode {

        @TruffleBoundary
        @Override
        public Object execute(DynamicObject arg0Value, Object[] arg1Value) throws UnsupportedMessageException {
            return doDefault(arg0Value, arg1Value, (IsConstructorNodeGen.getUncached()), (JSInteropCallNode.getUncachedCall()), (ImportValueNodeGen.getUncached()));
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.MEGAMORPHIC;
        }

        @Override
        public boolean isAdoptable() {
            return false;
        }

    }
}
