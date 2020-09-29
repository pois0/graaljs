// CheckStyle: start generated
package com.oracle.truffle.js.nodes.cast;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.EncapsulatingNodeReference;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.access.ReadElementNode;
import com.oracle.truffle.js.nodes.array.JSGetLengthNode;
import com.oracle.truffle.js.nodes.interop.ImportValueNode;
import com.oracle.truffle.js.runtime.JSContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSToObjectArrayNode.class)
@SuppressWarnings("unused")
public final class JSToObjectArrayNodeGen extends JSToObjectArrayNode implements Provider {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @Child private JSGetLengthNode toArray_getLengthNode_;
    @Child private ReadElementNode toArray_readNode_;
    @Child private ForeignObject0Data foreignObject0_cache;
    @CompilationFinal private BranchProfile foreignObject1_hasPropertiesBranch_;
    @Child private ImportValueNode foreignObject1_foreignConvertNode_;

    private JSToObjectArrayNodeGen(JSContext context, boolean nullOrUndefinedAsEmptyArray) {
        super(context, nullOrUndefinedAsEmptyArray);
    }

    @ExplodeLoop
    @Override
    public Object[] executeObjectArray(Object arg0Value) {
        int state = state_;
        if ((state & 0b1) != 0 /* is-active toArray(DynamicObject, JSGetLengthNode, ReadElementNode) */ && JSTypes.isDynamicObject(arg0Value)) {
            DynamicObject arg0Value_ = (DynamicObject) arg0Value;
            if ((JSGuards.isJSObject(arg0Value_))) {
                return toArray(arg0Value_, this.toArray_getLengthNode_, this.toArray_readNode_);
            }
        }
        if ((state & 0b110) != 0 /* is-active doUndefined(Object) || doNull(Object) */) {
            if ((state & 0b10) != 0 /* is-active doUndefined(Object) */) {
                if ((JSGuards.isUndefined(arg0Value))) {
                    return doUndefined(arg0Value);
                }
            }
            if ((state & 0b100) != 0 /* is-active doNull(Object) */) {
                if ((JSGuards.isJSNull(arg0Value))) {
                    return doNull(arg0Value);
                }
            }
        }
        if ((state & 0b1000) != 0 /* is-active toArrayString(CharSequence) */ && JSTypesGen.isImplicitCharSequence((state & 0b1111000000000000) >>> 12 /* extract-implicit-active 0:CharSequence */, arg0Value)) {
            CharSequence arg0Value_ = JSTypesGen.asImplicitCharSequence((state & 0b1111000000000000) >>> 12 /* extract-implicit-active 0:CharSequence */, arg0Value);
            return toArrayString(arg0Value_);
        }
        if ((state & 0b10000) != 0 /* is-active toArrayInt(int) */ && arg0Value instanceof Integer) {
            int arg0Value_ = (int) arg0Value;
            return toArrayInt(arg0Value_);
        }
        if ((state & 0b100000) != 0 /* is-active toArrayDouble(double) */ && JSTypesGen.isImplicitDouble((state & 0xf0000) >>> 16 /* extract-implicit-active 0:double */, arg0Value)) {
            double arg0Value_ = JSTypesGen.asImplicitDouble((state & 0xf0000) >>> 16 /* extract-implicit-active 0:double */, arg0Value);
            return toArrayDouble(arg0Value_);
        }
        if ((state & 0b1000000) != 0 /* is-active toArrayBoolean(boolean) */ && arg0Value instanceof Boolean) {
            boolean arg0Value_ = (boolean) arg0Value;
            return toArrayBoolean(arg0Value_);
        }
        if ((state & 0b10000000) != 0 /* is-active passArray(Object[]) */ && arg0Value instanceof Object[]) {
            Object[] arg0Value_ = (Object[]) arg0Value;
            return passArray(arg0Value_);
        }
        if ((state & 0b111100000000) != 0 /* is-active doList(Object) || doForeignObject(Object, InteropLibrary, BranchProfile, ImportValueNode) || doForeignObject(Object, InteropLibrary, BranchProfile, ImportValueNode) || doFallback(Object) */) {
            if ((state & 0b100000000) != 0 /* is-active doList(Object) */) {
                if ((JSGuards.isList(arg0Value))) {
                    return doList(arg0Value);
                }
            }
            if ((state & 0b1000000000) != 0 /* is-active doForeignObject(Object, InteropLibrary, BranchProfile, ImportValueNode) */) {
                ForeignObject0Data s10_ = this.foreignObject0_cache;
                while (s10_ != null) {
                    if ((s10_.interop_.accepts(arg0Value)) && (JSGuards.isForeignObject(arg0Value))) {
                        return doForeignObject(arg0Value, s10_.interop_, s10_.hasPropertiesBranch_, s10_.foreignConvertNode_);
                    }
                    s10_ = s10_.next_;
                }
            }
            if ((state & 0b10000000000) != 0 /* is-active doForeignObject(Object, InteropLibrary, BranchProfile, ImportValueNode) */) {
                if ((JSGuards.isForeignObject(arg0Value))) {
                    return this.foreignObject1Boundary(state, arg0Value);
                }
            }
            if ((state & 0b100000000000) != 0 /* is-active doFallback(Object) */) {
                if (fallbackGuard_(state, arg0Value)) {
                    return doFallback(arg0Value);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    @TruffleBoundary
    private Object[] foreignObject1Boundary(int state, Object arg0Value) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary foreignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arg0Value));
                return doForeignObject(arg0Value, foreignObject1_interop__, this.foreignObject1_hasPropertiesBranch_, this.foreignObject1_foreignConvertNode_);
            }
        } finally {
            encapsulating_.set(prev_);
        }
    }

    private Object[] executeAndSpecialize(Object arg0Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        int exclude = exclude_;
        try {
            if (JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if ((JSGuards.isJSObject(arg0Value_))) {
                    this.toArray_getLengthNode_ = super.insert((JSGetLengthNode.create(context)));
                    this.toArray_readNode_ = super.insert((ReadElementNode.create(context)));
                    this.state_ = state = state | 0b1 /* add-active toArray(DynamicObject, JSGetLengthNode, ReadElementNode) */;
                    lock.unlock();
                    hasLock = false;
                    return toArray(arg0Value_, this.toArray_getLengthNode_, this.toArray_readNode_);
                }
            }
            if ((JSGuards.isUndefined(arg0Value))) {
                this.state_ = state = state | 0b10 /* add-active doUndefined(Object) */;
                lock.unlock();
                hasLock = false;
                return doUndefined(arg0Value);
            }
            if ((JSGuards.isJSNull(arg0Value))) {
                this.state_ = state = state | 0b100 /* add-active doNull(Object) */;
                lock.unlock();
                hasLock = false;
                return doNull(arg0Value);
            }
            {
                int charSequenceCast0;
                if ((charSequenceCast0 = JSTypesGen.specializeImplicitCharSequence(arg0Value)) != 0) {
                    CharSequence arg0Value_ = JSTypesGen.asImplicitCharSequence(charSequenceCast0, arg0Value);
                    state = (state | (charSequenceCast0 << 12) /* set-implicit-active 0:CharSequence */);
                    this.state_ = state = state | 0b1000 /* add-active toArrayString(CharSequence) */;
                    lock.unlock();
                    hasLock = false;
                    return toArrayString(arg0Value_);
                }
            }
            if (arg0Value instanceof Integer) {
                int arg0Value_ = (int) arg0Value;
                this.state_ = state = state | 0b10000 /* add-active toArrayInt(int) */;
                lock.unlock();
                hasLock = false;
                return toArrayInt(arg0Value_);
            }
            {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(arg0Value)) != 0) {
                    double arg0Value_ = JSTypesGen.asImplicitDouble(doubleCast0, arg0Value);
                    state = (state | (doubleCast0 << 16) /* set-implicit-active 0:double */);
                    this.state_ = state = state | 0b100000 /* add-active toArrayDouble(double) */;
                    lock.unlock();
                    hasLock = false;
                    return toArrayDouble(arg0Value_);
                }
            }
            if (arg0Value instanceof Boolean) {
                boolean arg0Value_ = (boolean) arg0Value;
                this.state_ = state = state | 0b1000000 /* add-active toArrayBoolean(boolean) */;
                lock.unlock();
                hasLock = false;
                return toArrayBoolean(arg0Value_);
            }
            if (arg0Value instanceof Object[]) {
                Object[] arg0Value_ = (Object[]) arg0Value;
                this.state_ = state = state | 0b10000000 /* add-active passArray(Object[]) */;
                lock.unlock();
                hasLock = false;
                return passArray(arg0Value_);
            }
            if ((JSGuards.isList(arg0Value))) {
                this.state_ = state = state | 0b100000000 /* add-active doList(Object) */;
                lock.unlock();
                hasLock = false;
                return doList(arg0Value);
            }
            if ((exclude) == 0 /* is-not-excluded doForeignObject(Object, InteropLibrary, BranchProfile, ImportValueNode) */) {
                int count10_ = 0;
                ForeignObject0Data s10_ = this.foreignObject0_cache;
                if ((state & 0b1000000000) != 0 /* is-active doForeignObject(Object, InteropLibrary, BranchProfile, ImportValueNode) */) {
                    while (s10_ != null) {
                        if ((s10_.interop_.accepts(arg0Value)) && (JSGuards.isForeignObject(arg0Value))) {
                            break;
                        }
                        s10_ = s10_.next_;
                        count10_++;
                    }
                }
                if (s10_ == null) {
                    if ((JSGuards.isForeignObject(arg0Value)) && count10_ < (5)) {
                        // assert (s10_.interop_.accepts(arg0Value));
                        s10_ = super.insert(new ForeignObject0Data(foreignObject0_cache));
                        s10_.interop_ = s10_.insertAccessor((INTEROP_LIBRARY_.create(arg0Value)));
                        s10_.hasPropertiesBranch_ = (BranchProfile.create());
                        s10_.foreignConvertNode_ = s10_.insertAccessor((ImportValueNode.create()));
                        this.foreignObject0_cache = s10_;
                        this.state_ = state = state | 0b1000000000 /* add-active doForeignObject(Object, InteropLibrary, BranchProfile, ImportValueNode) */;
                    }
                }
                if (s10_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return doForeignObject(arg0Value, s10_.interop_, s10_.hasPropertiesBranch_, s10_.foreignConvertNode_);
                }
            }
            {
                InteropLibrary foreignObject1_interop__ = null;
                {
                    EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                    Node prev_ = encapsulating_.set(this);
                    try {
                        if ((JSGuards.isForeignObject(arg0Value))) {
                            foreignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arg0Value));
                            this.foreignObject1_hasPropertiesBranch_ = (BranchProfile.create());
                            this.foreignObject1_foreignConvertNode_ = super.insert((ImportValueNode.create()));
                            this.exclude_ = exclude = exclude | 0b1 /* add-excluded doForeignObject(Object, InteropLibrary, BranchProfile, ImportValueNode) */;
                            this.foreignObject0_cache = null;
                            state = state & 0xfffffdff /* remove-active doForeignObject(Object, InteropLibrary, BranchProfile, ImportValueNode) */;
                            this.state_ = state = state | 0b10000000000 /* add-active doForeignObject(Object, InteropLibrary, BranchProfile, ImportValueNode) */;
                            lock.unlock();
                            hasLock = false;
                            return doForeignObject(arg0Value, foreignObject1_interop__, this.foreignObject1_hasPropertiesBranch_, this.foreignObject1_foreignConvertNode_);
                        }
                    } finally {
                        encapsulating_.set(prev_);
                    }
                }
            }
            this.state_ = state = state | 0b100000000000 /* add-active doFallback(Object) */;
            lock.unlock();
            hasLock = false;
            return doFallback(arg0Value);
        } finally {
            if (hasLock) {
                lock.unlock();
            }
        }
    }

    @Override
    public NodeCost getCost() {
        int state = state_;
        if ((state & 0b111111111111) == 0b0) {
            return NodeCost.UNINITIALIZED;
        } else if (((state & 0b111111111111) & ((state & 0b111111111111) - 1)) == 0 /* is-single-active  */) {
            ForeignObject0Data s10_ = this.foreignObject0_cache;
            if ((s10_ == null || s10_.next_ == null)) {
                return NodeCost.MONOMORPHIC;
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[13];
        Object[] s;
        data[0] = 0;
        int state = state_;
        int exclude = exclude_;
        s = new Object[3];
        s[0] = "toArray";
        if ((state & 0b1) != 0 /* is-active toArray(DynamicObject, JSGetLengthNode, ReadElementNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.toArray_getLengthNode_, this.toArray_readNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doUndefined";
        if ((state & 0b10) != 0 /* is-active doUndefined(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doNull";
        if ((state & 0b100) != 0 /* is-active doNull(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "toArrayString";
        if ((state & 0b1000) != 0 /* is-active toArrayString(CharSequence) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "toArrayInt";
        if ((state & 0b10000) != 0 /* is-active toArrayInt(int) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "toArrayDouble";
        if ((state & 0b100000) != 0 /* is-active toArrayDouble(double) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "toArrayBoolean";
        if ((state & 0b1000000) != 0 /* is-active toArrayBoolean(boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        s = new Object[3];
        s[0] = "passArray";
        if ((state & 0b10000000) != 0 /* is-active passArray(Object[]) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[8] = s;
        s = new Object[3];
        s[0] = "doList";
        if ((state & 0b100000000) != 0 /* is-active doList(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[9] = s;
        s = new Object[3];
        s[0] = "doForeignObject";
        if ((state & 0b1000000000) != 0 /* is-active doForeignObject(Object, InteropLibrary, BranchProfile, ImportValueNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            ForeignObject0Data s10_ = this.foreignObject0_cache;
            while (s10_ != null) {
                cached.add(Arrays.asList(s10_.interop_, s10_.hasPropertiesBranch_, s10_.foreignConvertNode_));
                s10_ = s10_.next_;
            }
            s[2] = cached;
        } else if (exclude != 0 /* is-excluded doForeignObject(Object, InteropLibrary, BranchProfile, ImportValueNode) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[10] = s;
        s = new Object[3];
        s[0] = "doForeignObject";
        if ((state & 0b10000000000) != 0 /* is-active doForeignObject(Object, InteropLibrary, BranchProfile, ImportValueNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.foreignObject1_hasPropertiesBranch_, this.foreignObject1_foreignConvertNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[11] = s;
        s = new Object[3];
        s[0] = "doFallback";
        if ((state & 0b100000000000) != 0 /* is-active doFallback(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[12] = s;
        return Provider.create(data);
    }

    private static boolean fallbackGuard_(int state, Object arg0Value) {
        if (JSTypes.isDynamicObject(arg0Value)) {
            DynamicObject arg0Value_ = (DynamicObject) arg0Value;
            if ((JSGuards.isJSObject(arg0Value_))) {
                return false;
            }
        }
        if (((state & 0b10)) == 0 /* is-not-active doUndefined(Object) */ && (JSGuards.isUndefined(arg0Value))) {
            return false;
        }
        if (((state & 0b100)) == 0 /* is-not-active doNull(Object) */ && (JSGuards.isJSNull(arg0Value))) {
            return false;
        }
        if (JSTypesGen.isImplicitCharSequence(arg0Value)) {
            return false;
        }
        if (JSTypesGen.isImplicitDouble(arg0Value)) {
            return false;
        }
        if (((state & 0b1000000)) == 0 /* is-not-active toArrayBoolean(boolean) */ && arg0Value instanceof Boolean) {
            return false;
        }
        if (((state & 0b10000000)) == 0 /* is-not-active passArray(Object[]) */ && arg0Value instanceof Object[]) {
            return false;
        }
        if (((state & 0b100000000)) == 0 /* is-not-active doList(Object) */ && (JSGuards.isList(arg0Value))) {
            return false;
        }
        if (((state & 0b10000000000)) == 0 /* is-not-active doForeignObject(Object, InteropLibrary, BranchProfile, ImportValueNode) */ && (JSGuards.isForeignObject(arg0Value))) {
            return false;
        }
        return true;
    }

    public static JSToObjectArrayNode create(JSContext context, boolean nullOrUndefinedAsEmptyArray) {
        return new JSToObjectArrayNodeGen(context, nullOrUndefinedAsEmptyArray);
    }

    @GeneratedBy(JSToObjectArrayNode.class)
    private static final class ForeignObject0Data extends Node {

        @Child ForeignObject0Data next_;
        @Child InteropLibrary interop_;
        @CompilationFinal BranchProfile hasPropertiesBranch_;
        @Child ImportValueNode foreignConvertNode_;

        ForeignObject0Data(ForeignObject0Data next_) {
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
