// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.api.profiles.ValueProfile;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.cast.JSToIndexNode;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.array.TypedArrayFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(SetViewValueNode.class)
public final class SetViewValueNodeGen extends SetViewValueNode implements Provider {

    @CompilationFinal private volatile int state_;
    @Child private SetData set_cache;

    private SetViewValueNodeGen(JSContext context, String type, JavaScriptNode view, JavaScriptNode requestIndex, JavaScriptNode isLittleEndian, JavaScriptNode value) {
        super(context, type, view, requestIndex, isLittleEndian, value);
    }

    private SetViewValueNodeGen(JSContext context, TypedArrayFactory factory, JavaScriptNode view, JavaScriptNode requestIndex, JavaScriptNode isLittleEndian, JavaScriptNode value) {
        super(context, factory, view, requestIndex, isLittleEndian, value);
    }

    @Override
    public Object execute(DynamicObject viewNodeValue, Object requestIndexNodeValue, Object isLittleEndianNodeValue, Object valueNodeValue) {
        int state = state_;
        if (state != 0 /* is-active doSet(Object, Object, Object, Object, JSToIndexNode, BranchProfile, ValueProfile) */) {
            SetData s1_ = this.set_cache;
            if (s1_ != null) {
                return doSet(viewNodeValue, requestIndexNodeValue, isLittleEndianNodeValue, valueNodeValue, s1_.toIndexNode_, s1_.errorBranch_, s1_.typeProfile_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(viewNodeValue, requestIndexNodeValue, isLittleEndianNodeValue, valueNodeValue);
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        int state = state_;
        Object viewNodeValue_ = super.viewNode.execute(frameValue);
        Object requestIndexNodeValue_ = super.requestIndexNode.execute(frameValue);
        Object isLittleEndianNodeValue_ = super.isLittleEndianNode.execute(frameValue);
        Object valueNodeValue_ = super.valueNode.execute(frameValue);
        if (state != 0 /* is-active doSet(Object, Object, Object, Object, JSToIndexNode, BranchProfile, ValueProfile) */) {
            SetData s1_ = this.set_cache;
            if (s1_ != null) {
                return doSet(viewNodeValue_, requestIndexNodeValue_, isLittleEndianNodeValue_, valueNodeValue_, s1_.toIndexNode_, s1_.errorBranch_, s1_.typeProfile_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(viewNodeValue_, requestIndexNodeValue_, isLittleEndianNodeValue_, valueNodeValue_);
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        execute(frameValue);
        return;
    }

    private Object executeAndSpecialize(Object viewNodeValue, Object requestIndexNodeValue, Object isLittleEndianNodeValue, Object valueNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        try {
            SetData s1_ = super.insert(new SetData());
            s1_.toIndexNode_ = s1_.insertAccessor((JSToIndexNode.create()));
            s1_.errorBranch_ = (BranchProfile.create());
            s1_.typeProfile_ = (ValueProfile.createClassProfile());
            this.set_cache = s1_;
            this.state_ = state = state | 0b1 /* add-active doSet(Object, Object, Object, Object, JSToIndexNode, BranchProfile, ValueProfile) */;
            lock.unlock();
            hasLock = false;
            return doSet(viewNodeValue, requestIndexNodeValue, isLittleEndianNodeValue, valueNodeValue, s1_.toIndexNode_, s1_.errorBranch_, s1_.typeProfile_);
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
        s[0] = "doSet";
        if (state != 0 /* is-active doSet(Object, Object, Object, Object, JSToIndexNode, BranchProfile, ValueProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            SetData s1_ = this.set_cache;
            if (s1_ != null) {
                cached.add(Arrays.asList(s1_.toIndexNode_, s1_.errorBranch_, s1_.typeProfile_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        return Provider.create(data);
    }

    public static SetViewValueNode create(JSContext context, String type, JavaScriptNode view, JavaScriptNode requestIndex, JavaScriptNode isLittleEndian, JavaScriptNode value) {
        return new SetViewValueNodeGen(context, type, view, requestIndex, isLittleEndian, value);
    }

    public static SetViewValueNode create(JSContext context, TypedArrayFactory factory, JavaScriptNode view, JavaScriptNode requestIndex, JavaScriptNode isLittleEndian, JavaScriptNode value) {
        return new SetViewValueNodeGen(context, factory, view, requestIndex, isLittleEndian, value);
    }

    @GeneratedBy(SetViewValueNode.class)
    private static final class SetData extends Node {

        @Child JSToIndexNode toIndexNode_;
        @CompilationFinal BranchProfile errorBranch_;
        @CompilationFinal ValueProfile typeProfile_;

        SetData() {
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
