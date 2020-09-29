// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.EncapsulatingNodeReference;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.builtins.helper.ListGetNode;
import com.oracle.truffle.js.builtins.helper.ListSizeNode;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.interop.ImportValueNode;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.util.JSClassProfile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(CopyDataPropertiesNode.class)
@SuppressWarnings("unused")
public final class CopyDataPropertiesNodeGen extends CopyDataPropertiesNode implements Provider {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @Child private CopyDataPropertiesData copyDataProperties_cache;
    @Child private CopyDataPropertiesForeign0Data copyDataPropertiesForeign0_cache;
    @Child private CopyDataPropertiesForeign1Data copyDataPropertiesForeign1_cache;

    private CopyDataPropertiesNodeGen(JSContext context) {
        super(context);
    }

    @ExplodeLoop
    @Override
    protected Object executeImpl(Object arg0Value, Object arg1Value, Object[] arg2Value, boolean arg3Value) {
        int state = state_;
        if (state != 0 /* is-active doNullOrUndefined(DynamicObject, Object, Object[], boolean) || copyDataProperties(DynamicObject, DynamicObject, Object[], boolean, ReadElementNode, JSGetOwnPropertyNode, ListSizeNode, ListGetNode, JSClassProfile) || copyDataPropertiesForeign(DynamicObject, Object, Object[], boolean, InteropLibrary, InteropLibrary, InteropLibrary, ImportValueNode) || copyDataPropertiesForeign(DynamicObject, Object, Object[], boolean, InteropLibrary, InteropLibrary, InteropLibrary, ImportValueNode) */ && JSTypes.isDynamicObject(arg0Value)) {
            DynamicObject arg0Value_ = (DynamicObject) arg0Value;
            if ((state & 0b1) != 0 /* is-active doNullOrUndefined(DynamicObject, Object, Object[], boolean) */) {
                if ((JSGuards.isNullOrUndefined(arg1Value))) {
                    return CopyDataPropertiesNode.doNullOrUndefined(arg0Value_, arg1Value, arg2Value, arg3Value);
                }
            }
            if ((state & 0b10) != 0 /* is-active copyDataProperties(DynamicObject, DynamicObject, Object[], boolean, ReadElementNode, JSGetOwnPropertyNode, ListSizeNode, ListGetNode, JSClassProfile) */ && JSTypes.isDynamicObject(arg1Value)) {
                DynamicObject arg1Value_ = (DynamicObject) arg1Value;
                CopyDataPropertiesData s2_ = this.copyDataProperties_cache;
                if (s2_ != null) {
                    if ((JSGuards.isJSObject(arg1Value_))) {
                        return CopyDataPropertiesNode.copyDataProperties(arg0Value_, arg1Value_, arg2Value, arg3Value, s2_.getNode_, s2_.getOwnProperty_, s2_.listSize_, s2_.listGet_, s2_.classProfile_);
                    }
                }
            }
            if ((state & 0b1100) != 0 /* is-active copyDataPropertiesForeign(DynamicObject, Object, Object[], boolean, InteropLibrary, InteropLibrary, InteropLibrary, ImportValueNode) || copyDataPropertiesForeign(DynamicObject, Object, Object[], boolean, InteropLibrary, InteropLibrary, InteropLibrary, ImportValueNode) */) {
                if ((state & 0b100) != 0 /* is-active copyDataPropertiesForeign(DynamicObject, Object, Object[], boolean, InteropLibrary, InteropLibrary, InteropLibrary, ImportValueNode) */) {
                    CopyDataPropertiesForeign0Data s3_ = this.copyDataPropertiesForeign0_cache;
                    while (s3_ != null) {
                        if ((s3_.objInterop_.accepts(arg1Value)) && (!(JSGuards.isJSDynamicObject(arg1Value)))) {
                            return copyDataPropertiesForeign(arg0Value_, arg1Value, arg2Value, arg3Value, s3_.objInterop_, s3_.keysInterop_, s3_.stringInterop_, s3_.importValue_);
                        }
                        s3_ = s3_.next_;
                    }
                }
                if ((state & 0b1000) != 0 /* is-active copyDataPropertiesForeign(DynamicObject, Object, Object[], boolean, InteropLibrary, InteropLibrary, InteropLibrary, ImportValueNode) */) {
                    CopyDataPropertiesForeign1Data s4_ = this.copyDataPropertiesForeign1_cache;
                    if (s4_ != null) {
                        if ((!(JSGuards.isJSDynamicObject(arg1Value)))) {
                            return this.copyDataPropertiesForeign1Boundary(state, s4_, arg0Value_, arg1Value, arg2Value, arg3Value);
                        }
                    }
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value, arg2Value, arg3Value);
    }

    @TruffleBoundary
    private Object copyDataPropertiesForeign1Boundary(int state, CopyDataPropertiesForeign1Data s4_, DynamicObject arg0Value_, Object arg1Value, Object[] arg2Value, boolean arg3Value) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary objInterop__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                return copyDataPropertiesForeign(arg0Value_, arg1Value, arg2Value, arg3Value, objInterop__, s4_.keysInterop_, s4_.stringInterop_, s4_.importValue_);
            }
        } finally {
            encapsulating_.set(prev_);
        }
    }

    private DynamicObject executeAndSpecialize(Object arg0Value, Object arg1Value, Object[] arg2Value, boolean arg3Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        int exclude = exclude_;
        try {
            if (JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if ((JSGuards.isNullOrUndefined(arg1Value))) {
                    this.state_ = state = state | 0b1 /* add-active doNullOrUndefined(DynamicObject, Object, Object[], boolean) */;
                    lock.unlock();
                    hasLock = false;
                    return CopyDataPropertiesNode.doNullOrUndefined(arg0Value_, arg1Value, arg2Value, arg3Value);
                }
                if (JSTypes.isDynamicObject(arg1Value)) {
                    DynamicObject arg1Value_ = (DynamicObject) arg1Value;
                    if ((JSGuards.isJSObject(arg1Value_))) {
                        CopyDataPropertiesData s2_ = super.insert(new CopyDataPropertiesData());
                        s2_.getNode_ = s2_.insertAccessor((ReadElementNode.create(context)));
                        s2_.getOwnProperty_ = s2_.insertAccessor((JSGetOwnPropertyNode.create(false)));
                        s2_.listSize_ = s2_.insertAccessor((ListSizeNode.create()));
                        s2_.listGet_ = s2_.insertAccessor((ListGetNode.create()));
                        s2_.classProfile_ = (JSClassProfile.create());
                        this.copyDataProperties_cache = s2_;
                        this.state_ = state = state | 0b10 /* add-active copyDataProperties(DynamicObject, DynamicObject, Object[], boolean, ReadElementNode, JSGetOwnPropertyNode, ListSizeNode, ListGetNode, JSClassProfile) */;
                        lock.unlock();
                        hasLock = false;
                        return CopyDataPropertiesNode.copyDataProperties(arg0Value_, arg1Value_, arg2Value, arg3Value, s2_.getNode_, s2_.getOwnProperty_, s2_.listSize_, s2_.listGet_, s2_.classProfile_);
                    }
                }
                if ((exclude) == 0 /* is-not-excluded copyDataPropertiesForeign(DynamicObject, Object, Object[], boolean, InteropLibrary, InteropLibrary, InteropLibrary, ImportValueNode) */) {
                    int count3_ = 0;
                    CopyDataPropertiesForeign0Data s3_ = this.copyDataPropertiesForeign0_cache;
                    if ((state & 0b100) != 0 /* is-active copyDataPropertiesForeign(DynamicObject, Object, Object[], boolean, InteropLibrary, InteropLibrary, InteropLibrary, ImportValueNode) */) {
                        while (s3_ != null) {
                            if ((s3_.objInterop_.accepts(arg1Value)) && (!(JSGuards.isJSDynamicObject(arg1Value)))) {
                                break;
                            }
                            s3_ = s3_.next_;
                            count3_++;
                        }
                    }
                    if (s3_ == null) {
                        if ((!(JSGuards.isJSDynamicObject(arg1Value))) && count3_ < (3)) {
                            // assert (s3_.objInterop_.accepts(arg1Value));
                            s3_ = super.insert(new CopyDataPropertiesForeign0Data(copyDataPropertiesForeign0_cache));
                            s3_.objInterop_ = s3_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                            s3_.keysInterop_ = s3_.insertAccessor((INTEROP_LIBRARY_.createDispatched(3)));
                            s3_.stringInterop_ = s3_.insertAccessor((INTEROP_LIBRARY_.createDispatched(3)));
                            s3_.importValue_ = s3_.insertAccessor((ImportValueNode.create()));
                            this.copyDataPropertiesForeign0_cache = s3_;
                            this.state_ = state = state | 0b100 /* add-active copyDataPropertiesForeign(DynamicObject, Object, Object[], boolean, InteropLibrary, InteropLibrary, InteropLibrary, ImportValueNode) */;
                        }
                    }
                    if (s3_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return copyDataPropertiesForeign(arg0Value_, arg1Value, arg2Value, arg3Value, s3_.objInterop_, s3_.keysInterop_, s3_.stringInterop_, s3_.importValue_);
                    }
                }
                {
                    InteropLibrary objInterop__ = null;
                    {
                        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                        Node prev_ = encapsulating_.set(this);
                        try {
                            if ((!(JSGuards.isJSDynamicObject(arg1Value)))) {
                                CopyDataPropertiesForeign1Data s4_ = super.insert(new CopyDataPropertiesForeign1Data());
                                objInterop__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                s4_.keysInterop_ = s4_.insertAccessor((INTEROP_LIBRARY_.createDispatched(3)));
                                s4_.stringInterop_ = s4_.insertAccessor((INTEROP_LIBRARY_.createDispatched(3)));
                                s4_.importValue_ = s4_.insertAccessor((ImportValueNode.create()));
                                this.copyDataPropertiesForeign1_cache = s4_;
                                this.exclude_ = exclude = exclude | 0b1 /* add-excluded copyDataPropertiesForeign(DynamicObject, Object, Object[], boolean, InteropLibrary, InteropLibrary, InteropLibrary, ImportValueNode) */;
                                this.copyDataPropertiesForeign0_cache = null;
                                state = state & 0xfffffffb /* remove-active copyDataPropertiesForeign(DynamicObject, Object, Object[], boolean, InteropLibrary, InteropLibrary, InteropLibrary, ImportValueNode) */;
                                this.state_ = state = state | 0b1000 /* add-active copyDataPropertiesForeign(DynamicObject, Object, Object[], boolean, InteropLibrary, InteropLibrary, InteropLibrary, ImportValueNode) */;
                                lock.unlock();
                                hasLock = false;
                                return copyDataPropertiesForeign(arg0Value_, arg1Value, arg2Value, arg3Value, objInterop__, s4_.keysInterop_, s4_.stringInterop_, s4_.importValue_);
                            }
                        } finally {
                            encapsulating_.set(prev_);
                        }
                    }
                }
            }
            throw new UnsupportedSpecializationException(this, new Node[] {null, null, null, null}, arg0Value, arg1Value, arg2Value, arg3Value);
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
            CopyDataPropertiesForeign0Data s3_ = this.copyDataPropertiesForeign0_cache;
            if ((s3_ == null || s3_.next_ == null)) {
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
        s[0] = "doNullOrUndefined";
        if ((state & 0b1) != 0 /* is-active doNullOrUndefined(DynamicObject, Object, Object[], boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "copyDataProperties";
        if ((state & 0b10) != 0 /* is-active copyDataProperties(DynamicObject, DynamicObject, Object[], boolean, ReadElementNode, JSGetOwnPropertyNode, ListSizeNode, ListGetNode, JSClassProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            CopyDataPropertiesData s2_ = this.copyDataProperties_cache;
            if (s2_ != null) {
                cached.add(Arrays.asList(s2_.getNode_, s2_.getOwnProperty_, s2_.listSize_, s2_.listGet_, s2_.classProfile_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "copyDataPropertiesForeign";
        if ((state & 0b100) != 0 /* is-active copyDataPropertiesForeign(DynamicObject, Object, Object[], boolean, InteropLibrary, InteropLibrary, InteropLibrary, ImportValueNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            CopyDataPropertiesForeign0Data s3_ = this.copyDataPropertiesForeign0_cache;
            while (s3_ != null) {
                cached.add(Arrays.asList(s3_.objInterop_, s3_.keysInterop_, s3_.stringInterop_, s3_.importValue_));
                s3_ = s3_.next_;
            }
            s[2] = cached;
        } else if (exclude != 0 /* is-excluded copyDataPropertiesForeign(DynamicObject, Object, Object[], boolean, InteropLibrary, InteropLibrary, InteropLibrary, ImportValueNode) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "copyDataPropertiesForeign";
        if ((state & 0b1000) != 0 /* is-active copyDataPropertiesForeign(DynamicObject, Object, Object[], boolean, InteropLibrary, InteropLibrary, InteropLibrary, ImportValueNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            CopyDataPropertiesForeign1Data s4_ = this.copyDataPropertiesForeign1_cache;
            if (s4_ != null) {
                cached.add(Arrays.asList(s4_.keysInterop_, s4_.stringInterop_, s4_.importValue_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        return Provider.create(data);
    }

    public static CopyDataPropertiesNode create(JSContext context) {
        return new CopyDataPropertiesNodeGen(context);
    }

    @GeneratedBy(CopyDataPropertiesNode.class)
    private static final class CopyDataPropertiesData extends Node {

        @Child ReadElementNode getNode_;
        @Child JSGetOwnPropertyNode getOwnProperty_;
        @Child ListSizeNode listSize_;
        @Child ListGetNode listGet_;
        @CompilationFinal JSClassProfile classProfile_;

        CopyDataPropertiesData() {
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.NONE;
        }

        <T extends Node> T insertAccessor(T node) {
            return super.insert(node);
        }

    }
    @GeneratedBy(CopyDataPropertiesNode.class)
    private static final class CopyDataPropertiesForeign0Data extends Node {

        @Child CopyDataPropertiesForeign0Data next_;
        @Child InteropLibrary objInterop_;
        @Child InteropLibrary keysInterop_;
        @Child InteropLibrary stringInterop_;
        @Child ImportValueNode importValue_;

        CopyDataPropertiesForeign0Data(CopyDataPropertiesForeign0Data next_) {
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
    @GeneratedBy(CopyDataPropertiesNode.class)
    private static final class CopyDataPropertiesForeign1Data extends Node {

        @Child InteropLibrary keysInterop_;
        @Child InteropLibrary stringInterop_;
        @Child ImportValueNode importValue_;

        CopyDataPropertiesForeign1Data() {
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
