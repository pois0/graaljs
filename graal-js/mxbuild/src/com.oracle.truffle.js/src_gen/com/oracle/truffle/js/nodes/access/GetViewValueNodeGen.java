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
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.api.profiles.ValueProfile;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.cast.JSToIndexNode;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.array.TypedArrayFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(GetViewValueNode.class)
public final class GetViewValueNodeGen extends GetViewValueNode implements Provider {

    @CompilationFinal private volatile int state_;
    @Child private GetData get_cache;

    private GetViewValueNodeGen(JSContext context, String type, JavaScriptNode view, JavaScriptNode requestIndex, JavaScriptNode isLittleEndian) {
        super(context, type, view, requestIndex, isLittleEndian);
    }

    private GetViewValueNodeGen(JSContext context, TypedArrayFactory factory, JavaScriptNode view, JavaScriptNode requestIndex, JavaScriptNode isLittleEndian) {
        super(context, factory, view, requestIndex, isLittleEndian);
    }

    @Override
    public Object execute(Object viewNodeValue, Object requestIndexNodeValue, Object isLittleEndianNodeValue) {
        int state = state_;
        if (state != 0 /* is-active doGet(Object, Object, Object, JSToIndexNode, BranchProfile, ValueProfile) */) {
            GetData s1_ = this.get_cache;
            if (s1_ != null) {
                return doGet(viewNodeValue, requestIndexNodeValue, isLittleEndianNodeValue, s1_.toIndexNode_, s1_.errorBranch_, s1_.typeProfile_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(viewNodeValue, requestIndexNodeValue, isLittleEndianNodeValue);
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        int state = state_;
        Object viewNodeValue_ = super.viewNode.execute(frameValue);
        Object requestIndexNodeValue_ = super.requestIndexNode.execute(frameValue);
        Object isLittleEndianNodeValue_ = super.isLittleEndianNode.execute(frameValue);
        if (state != 0 /* is-active doGet(Object, Object, Object, JSToIndexNode, BranchProfile, ValueProfile) */) {
            GetData s1_ = this.get_cache;
            if (s1_ != null) {
                return doGet(viewNodeValue_, requestIndexNodeValue_, isLittleEndianNodeValue_, s1_.toIndexNode_, s1_.errorBranch_, s1_.typeProfile_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(viewNodeValue_, requestIndexNodeValue_, isLittleEndianNodeValue_);
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        execute(frameValue);
        return;
    }

    private Object executeAndSpecialize(Object viewNodeValue, Object requestIndexNodeValue, Object isLittleEndianNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        try {
            GetData s1_ = super.insert(new GetData());
            s1_.toIndexNode_ = s1_.insertAccessor((JSToIndexNode.create()));
            s1_.errorBranch_ = (BranchProfile.create());
            s1_.typeProfile_ = (ValueProfile.createClassProfile());
            this.get_cache = s1_;
            this.state_ = state = state | 0b1 /* add-active doGet(Object, Object, Object, JSToIndexNode, BranchProfile, ValueProfile) */;
            lock.unlock();
            hasLock = false;
            return doGet(viewNodeValue, requestIndexNodeValue, isLittleEndianNodeValue, s1_.toIndexNode_, s1_.errorBranch_, s1_.typeProfile_);
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
        s[0] = "doGet";
        if (state != 0 /* is-active doGet(Object, Object, Object, JSToIndexNode, BranchProfile, ValueProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            GetData s1_ = this.get_cache;
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

    public static GetViewValueNode create(JSContext context, String type, JavaScriptNode view, JavaScriptNode requestIndex, JavaScriptNode isLittleEndian) {
        return new GetViewValueNodeGen(context, type, view, requestIndex, isLittleEndian);
    }

    public static GetViewValueNode create(JSContext context, TypedArrayFactory factory, JavaScriptNode view, JavaScriptNode requestIndex, JavaScriptNode isLittleEndian) {
        return new GetViewValueNodeGen(context, factory, view, requestIndex, isLittleEndian);
    }

    @GeneratedBy(GetViewValueNode.class)
    private static final class GetData extends Node {

        @Child JSToIndexNode toIndexNode_;
        @CompilationFinal BranchProfile errorBranch_;
        @CompilationFinal ValueProfile typeProfile_;

        GetData() {
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
