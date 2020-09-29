// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.EncapsulatingNodeReference;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.cast.JSToObjectNode;
import com.oracle.truffle.js.runtime.JSContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(EnumerateNode.class)
@SuppressWarnings("unused")
public final class EnumerateNodeGen extends EnumerateNode implements Provider {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private ConditionProfile enumerateObject_isObject_;
    @Child private EnumerateNode enumerateJSAdapter_enumerateCallbackResultNode_;
    @Child private EnumerateTruffleObject0Data enumerateTruffleObject0_cache;
    @Child private EnumerateTruffleObject1Data enumerateTruffleObject1_cache;
    @Child private JSToObjectNode nonObject_toObjectNode_;
    @Child private EnumerateNode nonObject_enumerateNode_;

    private EnumerateNodeGen(JSContext context, boolean values, boolean requireIterable, JavaScriptNode targetNode) {
        super(context, values, requireIterable, targetNode);
    }

    @ExplodeLoop
    @Override
    public DynamicObject execute(Object targetNodeValue) {
        int state = state_;
        if ((state & 0b11) != 0 /* is-active doEnumerateObject(DynamicObject, ConditionProfile) || doEnumerateJSAdapter(DynamicObject, EnumerateNode) */ && JSTypes.isDynamicObject(targetNodeValue)) {
            DynamicObject targetNodeValue_ = (DynamicObject) targetNodeValue;
            if ((state & 0b1) != 0 /* is-active doEnumerateObject(DynamicObject, ConditionProfile) */) {
                if ((JSGuards.isJSDynamicObject(targetNodeValue_)) && (!(JSGuards.isJSAdapter(targetNodeValue_)))) {
                    return doEnumerateObject(targetNodeValue_, this.enumerateObject_isObject_);
                }
            }
            if ((state & 0b10) != 0 /* is-active doEnumerateJSAdapter(DynamicObject, EnumerateNode) */) {
                if ((JSGuards.isJSAdapter(targetNodeValue_))) {
                    return doEnumerateJSAdapter(targetNodeValue_, this.enumerateJSAdapter_enumerateCallbackResultNode_);
                }
            }
        }
        if ((state & 0b11100) != 0 /* is-active doEnumerateTruffleObject(Object, InteropLibrary, InteropLibrary, ConditionProfile, BranchProfile) || doEnumerateTruffleObject(Object, InteropLibrary, InteropLibrary, ConditionProfile, BranchProfile) || doNonObject(Object, JSToObjectNode, EnumerateNode) */) {
            if ((state & 0b100) != 0 /* is-active doEnumerateTruffleObject(Object, InteropLibrary, InteropLibrary, ConditionProfile, BranchProfile) */) {
                EnumerateTruffleObject0Data s3_ = this.enumerateTruffleObject0_cache;
                while (s3_ != null) {
                    if ((s3_.interop_.accepts(targetNodeValue)) && (JSGuards.isForeignObject(targetNodeValue))) {
                        return doEnumerateTruffleObject(targetNodeValue, s3_.interop_, s3_.keysInterop_, s3_.isHostObject_, s3_.notIterable_);
                    }
                    s3_ = s3_.next_;
                }
            }
            if ((state & 0b1000) != 0 /* is-active doEnumerateTruffleObject(Object, InteropLibrary, InteropLibrary, ConditionProfile, BranchProfile) */) {
                EnumerateTruffleObject1Data s4_ = this.enumerateTruffleObject1_cache;
                if (s4_ != null) {
                    if ((JSGuards.isForeignObject(targetNodeValue))) {
                        return this.enumerateTruffleObject1Boundary(state, s4_, targetNodeValue);
                    }
                }
            }
            if ((state & 0b10000) != 0 /* is-active doNonObject(Object, JSToObjectNode, EnumerateNode) */) {
                if ((!(JSGuards.isJSObject(targetNodeValue)))) {
                    return doNonObject(targetNodeValue, this.nonObject_toObjectNode_, this.nonObject_enumerateNode_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(targetNodeValue);
    }

    @TruffleBoundary
    private DynamicObject enumerateTruffleObject1Boundary(int state, EnumerateTruffleObject1Data s4_, Object targetNodeValue) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary interop__ = (INTEROP_LIBRARY_.getUncached(targetNodeValue));
                return doEnumerateTruffleObject(targetNodeValue, interop__, s4_.keysInterop_, s4_.isHostObject_, s4_.notIterable_);
            }
        } finally {
            encapsulating_.set(prev_);
        }
    }

    @ExplodeLoop
    @Override
    public DynamicObject execute(VirtualFrame frameValue) {
        int state = state_;
        Object targetNodeValue_ = super.targetNode.execute(frameValue);
        if ((state & 0b11) != 0 /* is-active doEnumerateObject(DynamicObject, ConditionProfile) || doEnumerateJSAdapter(DynamicObject, EnumerateNode) */ && JSTypes.isDynamicObject(targetNodeValue_)) {
            DynamicObject targetNodeValue__ = (DynamicObject) targetNodeValue_;
            if ((state & 0b1) != 0 /* is-active doEnumerateObject(DynamicObject, ConditionProfile) */) {
                if ((JSGuards.isJSDynamicObject(targetNodeValue__)) && (!(JSGuards.isJSAdapter(targetNodeValue__)))) {
                    return doEnumerateObject(targetNodeValue__, this.enumerateObject_isObject_);
                }
            }
            if ((state & 0b10) != 0 /* is-active doEnumerateJSAdapter(DynamicObject, EnumerateNode) */) {
                if ((JSGuards.isJSAdapter(targetNodeValue__))) {
                    return doEnumerateJSAdapter(targetNodeValue__, this.enumerateJSAdapter_enumerateCallbackResultNode_);
                }
            }
        }
        if ((state & 0b11100) != 0 /* is-active doEnumerateTruffleObject(Object, InteropLibrary, InteropLibrary, ConditionProfile, BranchProfile) || doEnumerateTruffleObject(Object, InteropLibrary, InteropLibrary, ConditionProfile, BranchProfile) || doNonObject(Object, JSToObjectNode, EnumerateNode) */) {
            if ((state & 0b100) != 0 /* is-active doEnumerateTruffleObject(Object, InteropLibrary, InteropLibrary, ConditionProfile, BranchProfile) */) {
                EnumerateTruffleObject0Data s3_ = this.enumerateTruffleObject0_cache;
                while (s3_ != null) {
                    if ((s3_.interop_.accepts(targetNodeValue_)) && (JSGuards.isForeignObject(targetNodeValue_))) {
                        return doEnumerateTruffleObject(targetNodeValue_, s3_.interop_, s3_.keysInterop_, s3_.isHostObject_, s3_.notIterable_);
                    }
                    s3_ = s3_.next_;
                }
            }
            if ((state & 0b1000) != 0 /* is-active doEnumerateTruffleObject(Object, InteropLibrary, InteropLibrary, ConditionProfile, BranchProfile) */) {
                EnumerateTruffleObject1Data s4_ = this.enumerateTruffleObject1_cache;
                if (s4_ != null) {
                    if ((JSGuards.isForeignObject(targetNodeValue_))) {
                        return this.enumerateTruffleObject1Boundary0(state, s4_, targetNodeValue_);
                    }
                }
            }
            if ((state & 0b10000) != 0 /* is-active doNonObject(Object, JSToObjectNode, EnumerateNode) */) {
                if ((!(JSGuards.isJSObject(targetNodeValue_)))) {
                    return doNonObject(targetNodeValue_, this.nonObject_toObjectNode_, this.nonObject_enumerateNode_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(targetNodeValue_);
    }

    @TruffleBoundary
    private DynamicObject enumerateTruffleObject1Boundary0(int state, EnumerateTruffleObject1Data s4_, Object targetNodeValue_) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary interop__ = (INTEROP_LIBRARY_.getUncached(targetNodeValue_));
                return doEnumerateTruffleObject(targetNodeValue_, interop__, s4_.keysInterop_, s4_.isHostObject_, s4_.notIterable_);
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

    private DynamicObject executeAndSpecialize(Object targetNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        int exclude = exclude_;
        try {
            if (JSTypes.isDynamicObject(targetNodeValue)) {
                DynamicObject targetNodeValue_ = (DynamicObject) targetNodeValue;
                if ((JSGuards.isJSDynamicObject(targetNodeValue_)) && (!(JSGuards.isJSAdapter(targetNodeValue_)))) {
                    this.enumerateObject_isObject_ = (ConditionProfile.createBinaryProfile());
                    this.state_ = state = state | 0b1 /* add-active doEnumerateObject(DynamicObject, ConditionProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return doEnumerateObject(targetNodeValue_, this.enumerateObject_isObject_);
                }
                if ((JSGuards.isJSAdapter(targetNodeValue_))) {
                    this.enumerateJSAdapter_enumerateCallbackResultNode_ = super.insert((createValues()));
                    this.state_ = state = state | 0b10 /* add-active doEnumerateJSAdapter(DynamicObject, EnumerateNode) */;
                    lock.unlock();
                    hasLock = false;
                    return doEnumerateJSAdapter(targetNodeValue_, this.enumerateJSAdapter_enumerateCallbackResultNode_);
                }
            }
            if ((exclude) == 0 /* is-not-excluded doEnumerateTruffleObject(Object, InteropLibrary, InteropLibrary, ConditionProfile, BranchProfile) */) {
                int count3_ = 0;
                EnumerateTruffleObject0Data s3_ = this.enumerateTruffleObject0_cache;
                if ((state & 0b100) != 0 /* is-active doEnumerateTruffleObject(Object, InteropLibrary, InteropLibrary, ConditionProfile, BranchProfile) */) {
                    while (s3_ != null) {
                        if ((s3_.interop_.accepts(targetNodeValue)) && (JSGuards.isForeignObject(targetNodeValue))) {
                            break;
                        }
                        s3_ = s3_.next_;
                        count3_++;
                    }
                }
                if (s3_ == null) {
                    if ((JSGuards.isForeignObject(targetNodeValue)) && count3_ < (3)) {
                        // assert (s3_.interop_.accepts(targetNodeValue));
                        s3_ = super.insert(new EnumerateTruffleObject0Data(enumerateTruffleObject0_cache));
                        s3_.interop_ = s3_.insertAccessor((INTEROP_LIBRARY_.create(targetNodeValue)));
                        s3_.keysInterop_ = s3_.insertAccessor((INTEROP_LIBRARY_.createDispatched(3)));
                        s3_.isHostObject_ = (ConditionProfile.createBinaryProfile());
                        s3_.notIterable_ = (BranchProfile.create());
                        this.enumerateTruffleObject0_cache = s3_;
                        this.state_ = state = state | 0b100 /* add-active doEnumerateTruffleObject(Object, InteropLibrary, InteropLibrary, ConditionProfile, BranchProfile) */;
                    }
                }
                if (s3_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return doEnumerateTruffleObject(targetNodeValue, s3_.interop_, s3_.keysInterop_, s3_.isHostObject_, s3_.notIterable_);
                }
            }
            {
                InteropLibrary interop__ = null;
                {
                    EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                    Node prev_ = encapsulating_.set(this);
                    try {
                        if ((JSGuards.isForeignObject(targetNodeValue))) {
                            EnumerateTruffleObject1Data s4_ = super.insert(new EnumerateTruffleObject1Data());
                            interop__ = (INTEROP_LIBRARY_.getUncached(targetNodeValue));
                            s4_.keysInterop_ = s4_.insertAccessor((INTEROP_LIBRARY_.createDispatched(3)));
                            s4_.isHostObject_ = (ConditionProfile.createBinaryProfile());
                            s4_.notIterable_ = (BranchProfile.create());
                            this.enumerateTruffleObject1_cache = s4_;
                            this.exclude_ = exclude = exclude | 0b1 /* add-excluded doEnumerateTruffleObject(Object, InteropLibrary, InteropLibrary, ConditionProfile, BranchProfile) */;
                            this.enumerateTruffleObject0_cache = null;
                            state = state & 0xfffffffb /* remove-active doEnumerateTruffleObject(Object, InteropLibrary, InteropLibrary, ConditionProfile, BranchProfile) */;
                            this.state_ = state = state | 0b1000 /* add-active doEnumerateTruffleObject(Object, InteropLibrary, InteropLibrary, ConditionProfile, BranchProfile) */;
                            lock.unlock();
                            hasLock = false;
                            return doEnumerateTruffleObject(targetNodeValue, interop__, s4_.keysInterop_, s4_.isHostObject_, s4_.notIterable_);
                        }
                    } finally {
                        encapsulating_.set(prev_);
                    }
                }
            }
            if ((!(JSGuards.isJSObject(targetNodeValue)))) {
                this.nonObject_toObjectNode_ = super.insert((JSToObjectNode.createToObjectNoCheck(context)));
                this.nonObject_enumerateNode_ = super.insert((copyRecursive()));
                this.state_ = state = state | 0b10000 /* add-active doNonObject(Object, JSToObjectNode, EnumerateNode) */;
                lock.unlock();
                hasLock = false;
                return doNonObject(targetNodeValue, this.nonObject_toObjectNode_, this.nonObject_enumerateNode_);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {super.targetNode}, targetNodeValue);
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
            EnumerateTruffleObject0Data s3_ = this.enumerateTruffleObject0_cache;
            if ((s3_ == null || s3_.next_ == null)) {
                return NodeCost.MONOMORPHIC;
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[6];
        Object[] s;
        data[0] = 0;
        int state = state_;
        int exclude = exclude_;
        s = new Object[3];
        s[0] = "doEnumerateObject";
        if ((state & 0b1) != 0 /* is-active doEnumerateObject(DynamicObject, ConditionProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.enumerateObject_isObject_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doEnumerateJSAdapter";
        if ((state & 0b10) != 0 /* is-active doEnumerateJSAdapter(DynamicObject, EnumerateNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.enumerateJSAdapter_enumerateCallbackResultNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doEnumerateTruffleObject";
        if ((state & 0b100) != 0 /* is-active doEnumerateTruffleObject(Object, InteropLibrary, InteropLibrary, ConditionProfile, BranchProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            EnumerateTruffleObject0Data s3_ = this.enumerateTruffleObject0_cache;
            while (s3_ != null) {
                cached.add(Arrays.asList(s3_.interop_, s3_.keysInterop_, s3_.isHostObject_, s3_.notIterable_));
                s3_ = s3_.next_;
            }
            s[2] = cached;
        } else if (exclude != 0 /* is-excluded doEnumerateTruffleObject(Object, InteropLibrary, InteropLibrary, ConditionProfile, BranchProfile) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doEnumerateTruffleObject";
        if ((state & 0b1000) != 0 /* is-active doEnumerateTruffleObject(Object, InteropLibrary, InteropLibrary, ConditionProfile, BranchProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            EnumerateTruffleObject1Data s4_ = this.enumerateTruffleObject1_cache;
            if (s4_ != null) {
                cached.add(Arrays.asList(s4_.keysInterop_, s4_.isHostObject_, s4_.notIterable_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doNonObject";
        if ((state & 0b10000) != 0 /* is-active doNonObject(Object, JSToObjectNode, EnumerateNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.nonObject_toObjectNode_, this.nonObject_enumerateNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        return Provider.create(data);
    }

    public static EnumerateNode create(JSContext context, boolean values, boolean requireIterable, JavaScriptNode targetNode) {
        return new EnumerateNodeGen(context, values, requireIterable, targetNode);
    }

    @GeneratedBy(EnumerateNode.class)
    private static final class EnumerateTruffleObject0Data extends Node {

        @Child EnumerateTruffleObject0Data next_;
        @Child InteropLibrary interop_;
        @Child InteropLibrary keysInterop_;
        @CompilationFinal ConditionProfile isHostObject_;
        @CompilationFinal BranchProfile notIterable_;

        EnumerateTruffleObject0Data(EnumerateTruffleObject0Data next_) {
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
    @GeneratedBy(EnumerateNode.class)
    private static final class EnumerateTruffleObject1Data extends Node {

        @Child InteropLibrary keysInterop_;
        @CompilationFinal ConditionProfile isHostObject_;
        @CompilationFinal BranchProfile notIterable_;

        EnumerateTruffleObject1Data() {
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
