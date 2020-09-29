// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.EncapsulatingNodeReference;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.object.DynamicObjectLibrary;
import com.oracle.truffle.api.object.HiddenKey;
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.function.JSFunctionCallNode;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.objects.Accessor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(PrivateFieldSetNode.class)
@SuppressWarnings("unused")
public final class PrivateFieldSetNodeGen extends PrivateFieldSetNode implements Provider {

    private static final LibraryFactory<DynamicObjectLibrary> DYNAMIC_OBJECT_LIBRARY_ = LibraryFactory.resolve(DynamicObjectLibrary.class);

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @Child private Field0Data field0_cache;
    @CompilationFinal private BranchProfile field1_errorBranch_;
    @Child private JSFunctionCallNode accessor_callNode_;
    @CompilationFinal private BranchProfile accessor_errorBranch_;

    private PrivateFieldSetNodeGen(JavaScriptNode targetNode, JavaScriptNode keyNode, JavaScriptNode valueNode, JSContext context) {
        super(targetNode, keyNode, valueNode, context);
    }

    @ExplodeLoop
    @Override
    public Object executeWithTarget(VirtualFrame frameValue, Object targetNodeValue) {
        int state = state_;
        Object keyNodeValue_ = super.keyNode.execute(frameValue);
        Object valueNodeValue_ = super.valueNode.execute(frameValue);
        if (state != 0 /* is-active doField(DynamicObject, HiddenKey, Object, DynamicObjectLibrary, BranchProfile) || doField(DynamicObject, HiddenKey, Object, DynamicObjectLibrary, BranchProfile) || doAccessor(DynamicObject, Accessor, Object, JSFunctionCallNode, BranchProfile) || missing(Object, Object, Object) */) {
            if ((state & 0b111) != 0 /* is-active doField(DynamicObject, HiddenKey, Object, DynamicObjectLibrary, BranchProfile) || doField(DynamicObject, HiddenKey, Object, DynamicObjectLibrary, BranchProfile) || doAccessor(DynamicObject, Accessor, Object, JSFunctionCallNode, BranchProfile) */ && JSTypes.isDynamicObject(targetNodeValue)) {
                DynamicObject targetNodeValue_ = (DynamicObject) targetNodeValue;
                if ((state & 0b11) != 0 /* is-active doField(DynamicObject, HiddenKey, Object, DynamicObjectLibrary, BranchProfile) || doField(DynamicObject, HiddenKey, Object, DynamicObjectLibrary, BranchProfile) */ && keyNodeValue_ instanceof HiddenKey) {
                    HiddenKey keyNodeValue__ = (HiddenKey) keyNodeValue_;
                    if ((state & 0b1) != 0 /* is-active doField(DynamicObject, HiddenKey, Object, DynamicObjectLibrary, BranchProfile) */) {
                        Field0Data s1_ = this.field0_cache;
                        while (s1_ != null) {
                            if ((s1_.access_.accepts(targetNodeValue_)) && (JSGuards.isJSObject(targetNodeValue_))) {
                                return doField(targetNodeValue_, keyNodeValue__, valueNodeValue_, s1_.access_, s1_.errorBranch_);
                            }
                            s1_ = s1_.next_;
                        }
                    }
                    if ((state & 0b10) != 0 /* is-active doField(DynamicObject, HiddenKey, Object, DynamicObjectLibrary, BranchProfile) */) {
                        if ((JSGuards.isJSObject(targetNodeValue_))) {
                            return this.field1Boundary(state, targetNodeValue_, keyNodeValue__, valueNodeValue_);
                        }
                    }
                }
                if ((state & 0b100) != 0 /* is-active doAccessor(DynamicObject, Accessor, Object, JSFunctionCallNode, BranchProfile) */ && keyNodeValue_ instanceof Accessor) {
                    Accessor keyNodeValue__ = (Accessor) keyNodeValue_;
                    if ((JSGuards.isJSObject(targetNodeValue_))) {
                        return doAccessor(targetNodeValue_, keyNodeValue__, valueNodeValue_, this.accessor_callNode_, this.accessor_errorBranch_);
                    }
                }
            }
            if ((state & 0b1000) != 0 /* is-active missing(Object, Object, Object) */) {
                if (fallbackGuard_(targetNodeValue, keyNodeValue_, valueNodeValue_)) {
                    return missing(targetNodeValue, keyNodeValue_, valueNodeValue_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(targetNodeValue, keyNodeValue_, valueNodeValue_);
    }

    @TruffleBoundary
    private Object field1Boundary(int state, DynamicObject targetNodeValue_, HiddenKey keyNodeValue__, Object valueNodeValue_) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                DynamicObjectLibrary field1_access__ = (DYNAMIC_OBJECT_LIBRARY_.getUncached(targetNodeValue_));
                return doField(targetNodeValue_, keyNodeValue__, valueNodeValue_, field1_access__, this.field1_errorBranch_);
            }
        } finally {
            encapsulating_.set(prev_);
        }
    }

    @ExplodeLoop
    @Override
    public Object execute(VirtualFrame frameValue) {
        int state = state_;
        Object targetNodeValue_ = super.targetNode.execute(frameValue);
        Object keyNodeValue_ = super.keyNode.execute(frameValue);
        Object valueNodeValue_ = super.valueNode.execute(frameValue);
        if (state != 0 /* is-active doField(DynamicObject, HiddenKey, Object, DynamicObjectLibrary, BranchProfile) || doField(DynamicObject, HiddenKey, Object, DynamicObjectLibrary, BranchProfile) || doAccessor(DynamicObject, Accessor, Object, JSFunctionCallNode, BranchProfile) || missing(Object, Object, Object) */) {
            if ((state & 0b111) != 0 /* is-active doField(DynamicObject, HiddenKey, Object, DynamicObjectLibrary, BranchProfile) || doField(DynamicObject, HiddenKey, Object, DynamicObjectLibrary, BranchProfile) || doAccessor(DynamicObject, Accessor, Object, JSFunctionCallNode, BranchProfile) */ && JSTypes.isDynamicObject(targetNodeValue_)) {
                DynamicObject targetNodeValue__ = (DynamicObject) targetNodeValue_;
                if ((state & 0b11) != 0 /* is-active doField(DynamicObject, HiddenKey, Object, DynamicObjectLibrary, BranchProfile) || doField(DynamicObject, HiddenKey, Object, DynamicObjectLibrary, BranchProfile) */ && keyNodeValue_ instanceof HiddenKey) {
                    HiddenKey keyNodeValue__ = (HiddenKey) keyNodeValue_;
                    if ((state & 0b1) != 0 /* is-active doField(DynamicObject, HiddenKey, Object, DynamicObjectLibrary, BranchProfile) */) {
                        Field0Data s1_ = this.field0_cache;
                        while (s1_ != null) {
                            if ((s1_.access_.accepts(targetNodeValue__)) && (JSGuards.isJSObject(targetNodeValue__))) {
                                return doField(targetNodeValue__, keyNodeValue__, valueNodeValue_, s1_.access_, s1_.errorBranch_);
                            }
                            s1_ = s1_.next_;
                        }
                    }
                    if ((state & 0b10) != 0 /* is-active doField(DynamicObject, HiddenKey, Object, DynamicObjectLibrary, BranchProfile) */) {
                        if ((JSGuards.isJSObject(targetNodeValue__))) {
                            return this.field1Boundary0(state, targetNodeValue__, keyNodeValue__, valueNodeValue_);
                        }
                    }
                }
                if ((state & 0b100) != 0 /* is-active doAccessor(DynamicObject, Accessor, Object, JSFunctionCallNode, BranchProfile) */ && keyNodeValue_ instanceof Accessor) {
                    Accessor keyNodeValue__ = (Accessor) keyNodeValue_;
                    if ((JSGuards.isJSObject(targetNodeValue__))) {
                        return doAccessor(targetNodeValue__, keyNodeValue__, valueNodeValue_, this.accessor_callNode_, this.accessor_errorBranch_);
                    }
                }
            }
            if ((state & 0b1000) != 0 /* is-active missing(Object, Object, Object) */) {
                if (fallbackGuard_(targetNodeValue_, keyNodeValue_, valueNodeValue_)) {
                    return missing(targetNodeValue_, keyNodeValue_, valueNodeValue_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(targetNodeValue_, keyNodeValue_, valueNodeValue_);
    }

    @TruffleBoundary
    private Object field1Boundary0(int state, DynamicObject targetNodeValue__, HiddenKey keyNodeValue__, Object valueNodeValue_) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                DynamicObjectLibrary field1_access__ = (DYNAMIC_OBJECT_LIBRARY_.getUncached(targetNodeValue__));
                return doField(targetNodeValue__, keyNodeValue__, valueNodeValue_, field1_access__, this.field1_errorBranch_);
            }
        } finally {
            encapsulating_.set(prev_);
        }
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        execute(frameValue);
        return;
    }

    private Object executeAndSpecialize(Object targetNodeValue, Object keyNodeValue, Object valueNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        int exclude = exclude_;
        try {
            if (JSTypes.isDynamicObject(targetNodeValue)) {
                DynamicObject targetNodeValue_ = (DynamicObject) targetNodeValue;
                if (keyNodeValue instanceof HiddenKey) {
                    HiddenKey keyNodeValue_ = (HiddenKey) keyNodeValue;
                    if ((exclude) == 0 /* is-not-excluded doField(DynamicObject, HiddenKey, Object, DynamicObjectLibrary, BranchProfile) */) {
                        int count1_ = 0;
                        Field0Data s1_ = this.field0_cache;
                        if ((state & 0b1) != 0 /* is-active doField(DynamicObject, HiddenKey, Object, DynamicObjectLibrary, BranchProfile) */) {
                            while (s1_ != null) {
                                if ((s1_.access_.accepts(targetNodeValue_)) && (JSGuards.isJSObject(targetNodeValue_))) {
                                    break;
                                }
                                s1_ = s1_.next_;
                                count1_++;
                            }
                        }
                        if (s1_ == null) {
                            if ((JSGuards.isJSObject(targetNodeValue_)) && count1_ < (3)) {
                                // assert (s1_.access_.accepts(targetNodeValue_));
                                s1_ = super.insert(new Field0Data(field0_cache));
                                s1_.access_ = s1_.insertAccessor((DYNAMIC_OBJECT_LIBRARY_.create(targetNodeValue_)));
                                s1_.errorBranch_ = (BranchProfile.create());
                                this.field0_cache = s1_;
                                this.state_ = state = state | 0b1 /* add-active doField(DynamicObject, HiddenKey, Object, DynamicObjectLibrary, BranchProfile) */;
                            }
                        }
                        if (s1_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return doField(targetNodeValue_, keyNodeValue_, valueNodeValue, s1_.access_, s1_.errorBranch_);
                        }
                    }
                    {
                        DynamicObjectLibrary field1_access__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                if ((JSGuards.isJSObject(targetNodeValue_))) {
                                    field1_access__ = (DYNAMIC_OBJECT_LIBRARY_.getUncached(targetNodeValue_));
                                    this.field1_errorBranch_ = (BranchProfile.create());
                                    this.exclude_ = exclude = exclude | 0b1 /* add-excluded doField(DynamicObject, HiddenKey, Object, DynamicObjectLibrary, BranchProfile) */;
                                    this.field0_cache = null;
                                    state = state & 0xfffffffe /* remove-active doField(DynamicObject, HiddenKey, Object, DynamicObjectLibrary, BranchProfile) */;
                                    this.state_ = state = state | 0b10 /* add-active doField(DynamicObject, HiddenKey, Object, DynamicObjectLibrary, BranchProfile) */;
                                    lock.unlock();
                                    hasLock = false;
                                    return doField(targetNodeValue_, keyNodeValue_, valueNodeValue, field1_access__, this.field1_errorBranch_);
                                }
                            } finally {
                                encapsulating_.set(prev_);
                            }
                        }
                    }
                }
                if (keyNodeValue instanceof Accessor) {
                    Accessor keyNodeValue_ = (Accessor) keyNodeValue;
                    if ((JSGuards.isJSObject(targetNodeValue_))) {
                        this.accessor_callNode_ = super.insert((JSFunctionCallNode.createCall()));
                        this.accessor_errorBranch_ = (BranchProfile.create());
                        this.state_ = state = state | 0b100 /* add-active doAccessor(DynamicObject, Accessor, Object, JSFunctionCallNode, BranchProfile) */;
                        lock.unlock();
                        hasLock = false;
                        return doAccessor(targetNodeValue_, keyNodeValue_, valueNodeValue, this.accessor_callNode_, this.accessor_errorBranch_);
                    }
                }
            }
            this.state_ = state = state | 0b1000 /* add-active missing(Object, Object, Object) */;
            lock.unlock();
            hasLock = false;
            return missing(targetNodeValue, keyNodeValue, valueNodeValue);
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
            Field0Data s1_ = this.field0_cache;
            if ((s1_ == null || s1_.next_ == null)) {
                return NodeCost.MONOMORPHIC;
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[5];
        Object[] s;
        data[0] = 0;
        int state = state_;
        int exclude = exclude_;
        s = new Object[3];
        s[0] = "doField";
        if ((state & 0b1) != 0 /* is-active doField(DynamicObject, HiddenKey, Object, DynamicObjectLibrary, BranchProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            Field0Data s1_ = this.field0_cache;
            while (s1_ != null) {
                cached.add(Arrays.asList(s1_.access_, s1_.errorBranch_));
                s1_ = s1_.next_;
            }
            s[2] = cached;
        } else if (exclude != 0 /* is-excluded doField(DynamicObject, HiddenKey, Object, DynamicObjectLibrary, BranchProfile) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doField";
        if ((state & 0b10) != 0 /* is-active doField(DynamicObject, HiddenKey, Object, DynamicObjectLibrary, BranchProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.field1_errorBranch_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doAccessor";
        if ((state & 0b100) != 0 /* is-active doAccessor(DynamicObject, Accessor, Object, JSFunctionCallNode, BranchProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.accessor_callNode_, this.accessor_errorBranch_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "missing";
        if ((state & 0b1000) != 0 /* is-active missing(Object, Object, Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        return Provider.create(data);
    }

    private static boolean fallbackGuard_(Object targetNodeValue, Object keyNodeValue, Object valueNodeValue) {
        if (JSTypes.isDynamicObject(targetNodeValue)) {
            if (keyNodeValue instanceof HiddenKey) {
                DynamicObject targetNodeValue_ = (DynamicObject) targetNodeValue;
                if ((JSGuards.isJSObject(targetNodeValue_))) {
                    return false;
                }
            }
            if (keyNodeValue instanceof Accessor) {
                DynamicObject targetNodeValue_ = (DynamicObject) targetNodeValue;
                if ((JSGuards.isJSObject(targetNodeValue_))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static PrivateFieldSetNode create(JavaScriptNode targetNode, JavaScriptNode keyNode, JavaScriptNode valueNode, JSContext context) {
        return new PrivateFieldSetNodeGen(targetNode, keyNode, valueNode, context);
    }

    @GeneratedBy(PrivateFieldSetNode.class)
    private static final class Field0Data extends Node {

        @Child Field0Data next_;
        @Child DynamicObjectLibrary access_;
        @CompilationFinal BranchProfile errorBranch_;

        Field0Data(Field0Data next_) {
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
