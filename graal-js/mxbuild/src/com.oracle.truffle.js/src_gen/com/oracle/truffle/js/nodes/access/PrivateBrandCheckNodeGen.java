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
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(PrivateBrandCheckNode.class)
@SuppressWarnings("unused")
public final class PrivateBrandCheckNodeGen extends PrivateBrandCheckNode implements Provider {

    private static final LibraryFactory<DynamicObjectLibrary> DYNAMIC_OBJECT_LIBRARY_ = LibraryFactory.resolve(DynamicObjectLibrary.class);

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @Child private Instance0Data instance0_cache;

    private PrivateBrandCheckNodeGen(JavaScriptNode targetNode, JavaScriptNode brandNode) {
        super(targetNode, brandNode);
    }

    @ExplodeLoop
    @Override
    public Object executeWithTarget(VirtualFrame frameValue, Object targetNodeValue) {
        int state = state_;
        Object brandNodeValue_ = super.brandNode.execute(frameValue);
        if ((state & 0b111) != 0 /* is-active doInstance(DynamicObject, HiddenKey, DynamicObjectLibrary) || doInstance(DynamicObject, HiddenKey, DynamicObjectLibrary) || doStatic(DynamicObject, DynamicObject) */ && JSTypes.isDynamicObject(targetNodeValue)) {
            DynamicObject targetNodeValue_ = (DynamicObject) targetNodeValue;
            if ((state & 0b11) != 0 /* is-active doInstance(DynamicObject, HiddenKey, DynamicObjectLibrary) || doInstance(DynamicObject, HiddenKey, DynamicObjectLibrary) */ && brandNodeValue_ instanceof HiddenKey) {
                HiddenKey brandNodeValue__ = (HiddenKey) brandNodeValue_;
                if ((state & 0b1) != 0 /* is-active doInstance(DynamicObject, HiddenKey, DynamicObjectLibrary) */) {
                    Instance0Data s1_ = this.instance0_cache;
                    while (s1_ != null) {
                        if ((s1_.access_.accepts(targetNodeValue_)) && (JSGuards.isJSObject(targetNodeValue_))) {
                            return doInstance(targetNodeValue_, brandNodeValue__, s1_.access_);
                        }
                        s1_ = s1_.next_;
                    }
                }
                if ((state & 0b10) != 0 /* is-active doInstance(DynamicObject, HiddenKey, DynamicObjectLibrary) */) {
                    if ((JSGuards.isJSObject(targetNodeValue_))) {
                        return this.instance1Boundary(state, targetNodeValue_, brandNodeValue__);
                    }
                }
            }
            if ((state & 0b100) != 0 /* is-active doStatic(DynamicObject, DynamicObject) */ && JSTypes.isDynamicObject(brandNodeValue_)) {
                DynamicObject brandNodeValue__ = (DynamicObject) brandNodeValue_;
                if ((JSGuards.isJSObject(targetNodeValue_))) {
                    return doStatic(targetNodeValue_, brandNodeValue__);
                }
            }
        }
        if ((state & 0b1000) != 0 /* is-active denied(Object, Object) */) {
            if (fallbackGuard_(targetNodeValue, brandNodeValue_)) {
                return denied(targetNodeValue, brandNodeValue_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(targetNodeValue, brandNodeValue_);
    }

    @TruffleBoundary
    private Object instance1Boundary(int state, DynamicObject targetNodeValue_, HiddenKey brandNodeValue__) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                DynamicObjectLibrary instance1_access__ = (DYNAMIC_OBJECT_LIBRARY_.getUncached(targetNodeValue_));
                return doInstance(targetNodeValue_, brandNodeValue__, instance1_access__);
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
        Object brandNodeValue_ = super.brandNode.execute(frameValue);
        if ((state & 0b111) != 0 /* is-active doInstance(DynamicObject, HiddenKey, DynamicObjectLibrary) || doInstance(DynamicObject, HiddenKey, DynamicObjectLibrary) || doStatic(DynamicObject, DynamicObject) */ && JSTypes.isDynamicObject(targetNodeValue_)) {
            DynamicObject targetNodeValue__ = (DynamicObject) targetNodeValue_;
            if ((state & 0b11) != 0 /* is-active doInstance(DynamicObject, HiddenKey, DynamicObjectLibrary) || doInstance(DynamicObject, HiddenKey, DynamicObjectLibrary) */ && brandNodeValue_ instanceof HiddenKey) {
                HiddenKey brandNodeValue__ = (HiddenKey) brandNodeValue_;
                if ((state & 0b1) != 0 /* is-active doInstance(DynamicObject, HiddenKey, DynamicObjectLibrary) */) {
                    Instance0Data s1_ = this.instance0_cache;
                    while (s1_ != null) {
                        if ((s1_.access_.accepts(targetNodeValue__)) && (JSGuards.isJSObject(targetNodeValue__))) {
                            return doInstance(targetNodeValue__, brandNodeValue__, s1_.access_);
                        }
                        s1_ = s1_.next_;
                    }
                }
                if ((state & 0b10) != 0 /* is-active doInstance(DynamicObject, HiddenKey, DynamicObjectLibrary) */) {
                    if ((JSGuards.isJSObject(targetNodeValue__))) {
                        return this.instance1Boundary0(state, targetNodeValue__, brandNodeValue__);
                    }
                }
            }
            if ((state & 0b100) != 0 /* is-active doStatic(DynamicObject, DynamicObject) */ && JSTypes.isDynamicObject(brandNodeValue_)) {
                DynamicObject brandNodeValue__ = (DynamicObject) brandNodeValue_;
                if ((JSGuards.isJSObject(targetNodeValue__))) {
                    return doStatic(targetNodeValue__, brandNodeValue__);
                }
            }
        }
        if ((state & 0b1000) != 0 /* is-active denied(Object, Object) */) {
            if (fallbackGuard_(targetNodeValue_, brandNodeValue_)) {
                return denied(targetNodeValue_, brandNodeValue_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(targetNodeValue_, brandNodeValue_);
    }

    @TruffleBoundary
    private Object instance1Boundary0(int state, DynamicObject targetNodeValue__, HiddenKey brandNodeValue__) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                DynamicObjectLibrary instance1_access__ = (DYNAMIC_OBJECT_LIBRARY_.getUncached(targetNodeValue__));
                return doInstance(targetNodeValue__, brandNodeValue__, instance1_access__);
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

    private Object executeAndSpecialize(Object targetNodeValue, Object brandNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        int exclude = exclude_;
        try {
            if (JSTypes.isDynamicObject(targetNodeValue)) {
                DynamicObject targetNodeValue_ = (DynamicObject) targetNodeValue;
                if (brandNodeValue instanceof HiddenKey) {
                    HiddenKey brandNodeValue_ = (HiddenKey) brandNodeValue;
                    if ((exclude) == 0 /* is-not-excluded doInstance(DynamicObject, HiddenKey, DynamicObjectLibrary) */) {
                        int count1_ = 0;
                        Instance0Data s1_ = this.instance0_cache;
                        if ((state & 0b1) != 0 /* is-active doInstance(DynamicObject, HiddenKey, DynamicObjectLibrary) */) {
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
                                s1_ = super.insert(new Instance0Data(instance0_cache));
                                s1_.access_ = s1_.insertAccessor((DYNAMIC_OBJECT_LIBRARY_.create(targetNodeValue_)));
                                this.instance0_cache = s1_;
                                this.state_ = state = state | 0b1 /* add-active doInstance(DynamicObject, HiddenKey, DynamicObjectLibrary) */;
                            }
                        }
                        if (s1_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return doInstance(targetNodeValue_, brandNodeValue_, s1_.access_);
                        }
                    }
                    {
                        DynamicObjectLibrary instance1_access__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                if ((JSGuards.isJSObject(targetNodeValue_))) {
                                    instance1_access__ = (DYNAMIC_OBJECT_LIBRARY_.getUncached(targetNodeValue_));
                                    this.exclude_ = exclude = exclude | 0b1 /* add-excluded doInstance(DynamicObject, HiddenKey, DynamicObjectLibrary) */;
                                    this.instance0_cache = null;
                                    state = state & 0xfffffffe /* remove-active doInstance(DynamicObject, HiddenKey, DynamicObjectLibrary) */;
                                    this.state_ = state = state | 0b10 /* add-active doInstance(DynamicObject, HiddenKey, DynamicObjectLibrary) */;
                                    lock.unlock();
                                    hasLock = false;
                                    return doInstance(targetNodeValue_, brandNodeValue_, instance1_access__);
                                }
                            } finally {
                                encapsulating_.set(prev_);
                            }
                        }
                    }
                }
                if (JSTypes.isDynamicObject(brandNodeValue)) {
                    DynamicObject brandNodeValue_ = (DynamicObject) brandNodeValue;
                    if ((JSGuards.isJSObject(targetNodeValue_))) {
                        this.state_ = state = state | 0b100 /* add-active doStatic(DynamicObject, DynamicObject) */;
                        lock.unlock();
                        hasLock = false;
                        return doStatic(targetNodeValue_, brandNodeValue_);
                    }
                }
            }
            this.state_ = state = state | 0b1000 /* add-active denied(Object, Object) */;
            lock.unlock();
            hasLock = false;
            return denied(targetNodeValue, brandNodeValue);
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
            Instance0Data s1_ = this.instance0_cache;
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
        s[0] = "doInstance";
        if ((state & 0b1) != 0 /* is-active doInstance(DynamicObject, HiddenKey, DynamicObjectLibrary) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            Instance0Data s1_ = this.instance0_cache;
            while (s1_ != null) {
                cached.add(Arrays.asList(s1_.access_));
                s1_ = s1_.next_;
            }
            s[2] = cached;
        } else if (exclude != 0 /* is-excluded doInstance(DynamicObject, HiddenKey, DynamicObjectLibrary) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doInstance";
        if ((state & 0b10) != 0 /* is-active doInstance(DynamicObject, HiddenKey, DynamicObjectLibrary) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList());
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doStatic";
        if ((state & 0b100) != 0 /* is-active doStatic(DynamicObject, DynamicObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "denied";
        if ((state & 0b1000) != 0 /* is-active denied(Object, Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        return Provider.create(data);
    }

    private static boolean fallbackGuard_(Object targetNodeValue, Object brandNodeValue) {
        if (JSTypes.isDynamicObject(targetNodeValue)) {
            if (brandNodeValue instanceof HiddenKey) {
                DynamicObject targetNodeValue_ = (DynamicObject) targetNodeValue;
                if ((JSGuards.isJSObject(targetNodeValue_))) {
                    return false;
                }
            }
            if (JSTypes.isDynamicObject(brandNodeValue)) {
                DynamicObject targetNodeValue_ = (DynamicObject) targetNodeValue;
                if ((JSGuards.isJSObject(targetNodeValue_))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static PrivateBrandCheckNode create(JavaScriptNode targetNode, JavaScriptNode brandNode) {
        return new PrivateBrandCheckNodeGen(targetNode, brandNode);
    }

    @GeneratedBy(PrivateBrandCheckNode.class)
    private static final class Instance0Data extends Node {

        @Child Instance0Data next_;
        @Child DynamicObjectLibrary access_;

        Instance0Data(Instance0Data next_) {
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
