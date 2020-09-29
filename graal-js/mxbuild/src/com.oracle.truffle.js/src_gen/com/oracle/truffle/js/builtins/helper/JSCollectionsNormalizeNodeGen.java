// CheckStyle: start generated
package com.oracle.truffle.js.builtins.helper;

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
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.runtime.BigInt;
import com.oracle.truffle.js.runtime.Symbol;
import com.oracle.truffle.js.runtime.objects.JSLazyString;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSCollectionsNormalizeNode.class)
@SuppressWarnings("unused")
public final class JSCollectionsNormalizeNodeGen extends JSCollectionsNormalizeNode implements Provider {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private ConditionProfile jSLazyString_flatten_;
    @Child private ForeignObject0Data foreignObject0_cache;
    @CompilationFinal private ConditionProfile foreignObject1_primitiveProfile_;
    @Child private JSCollectionsNormalizeNode foreignObject1_nestedNormalizeNode_;

    private JSCollectionsNormalizeNodeGen() {
    }

    @ExplodeLoop
    @Override
    public Object execute(Object arg0Value) {
        int state = state_;
        if ((state & 0b1) != 0 /* is-active doInt(int) */ && arg0Value instanceof Integer) {
            int arg0Value_ = (int) arg0Value;
            return doInt(arg0Value_);
        }
        if ((state & 0b10) != 0 /* is-active doDouble(double) */ && JSTypesGen.isImplicitDouble((state & 0b11110000000000) >>> 10 /* extract-implicit-active 0:double */, arg0Value)) {
            double arg0Value_ = JSTypesGen.asImplicitDouble((state & 0b11110000000000) >>> 10 /* extract-implicit-active 0:double */, arg0Value);
            return doDouble(arg0Value_);
        }
        if ((state & 0b100) != 0 /* is-active doJSLazyString(JSLazyString, ConditionProfile) */ && arg0Value instanceof JSLazyString) {
            JSLazyString arg0Value_ = (JSLazyString) arg0Value;
            return doJSLazyString(arg0Value_, this.jSLazyString_flatten_);
        }
        if ((state & 0b1000) != 0 /* is-active doString(String) */ && JSTypesGen.isImplicitString((state & 0x3c000) >>> 14 /* extract-implicit-active 0:String */, arg0Value)) {
            String arg0Value_ = JSTypesGen.asImplicitString((state & 0x3c000) >>> 14 /* extract-implicit-active 0:String */, arg0Value);
            return doString(arg0Value_);
        }
        if ((state & 0b10000) != 0 /* is-active doBoolean(boolean) */ && arg0Value instanceof Boolean) {
            boolean arg0Value_ = (boolean) arg0Value;
            return doBoolean(arg0Value_);
        }
        if ((state & 0b100000) != 0 /* is-active doDynamicObject(DynamicObject) */ && JSTypes.isDynamicObject(arg0Value)) {
            DynamicObject arg0Value_ = (DynamicObject) arg0Value;
            if ((JSGuards.isJSDynamicObject(arg0Value_))) {
                return doDynamicObject(arg0Value_);
            }
        }
        if ((state & 0b1000000) != 0 /* is-active doSymbol(Symbol) */ && arg0Value instanceof Symbol) {
            Symbol arg0Value_ = (Symbol) arg0Value;
            return doSymbol(arg0Value_);
        }
        if ((state & 0b10000000) != 0 /* is-active doBigInt(BigInt) */ && arg0Value instanceof BigInt) {
            BigInt arg0Value_ = (BigInt) arg0Value;
            return doBigInt(arg0Value_);
        }
        if ((state & 0b1100000000) != 0 /* is-active doForeignObject(Object, InteropLibrary, ConditionProfile, JSCollectionsNormalizeNode) || doForeignObject(Object, InteropLibrary, ConditionProfile, JSCollectionsNormalizeNode) */) {
            if ((state & 0b100000000) != 0 /* is-active doForeignObject(Object, InteropLibrary, ConditionProfile, JSCollectionsNormalizeNode) */) {
                ForeignObject0Data s9_ = this.foreignObject0_cache;
                while (s9_ != null) {
                    if ((s9_.interop_.accepts(arg0Value)) && (JSGuards.isForeignObject(arg0Value))) {
                        return doForeignObject(arg0Value, s9_.interop_, s9_.primitiveProfile_, s9_.nestedNormalizeNode_);
                    }
                    s9_ = s9_.next_;
                }
            }
            if ((state & 0b1000000000) != 0 /* is-active doForeignObject(Object, InteropLibrary, ConditionProfile, JSCollectionsNormalizeNode) */) {
                if ((JSGuards.isForeignObject(arg0Value))) {
                    return this.foreignObject1Boundary(state, arg0Value);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    @TruffleBoundary
    private Object foreignObject1Boundary(int state, Object arg0Value) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary foreignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arg0Value));
                return doForeignObject(arg0Value, foreignObject1_interop__, this.foreignObject1_primitiveProfile_, this.foreignObject1_nestedNormalizeNode_);
            }
        } finally {
            encapsulating_.set(prev_);
        }
    }

    private Object executeAndSpecialize(Object arg0Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        int exclude = exclude_;
        try {
            if (arg0Value instanceof Integer) {
                int arg0Value_ = (int) arg0Value;
                this.state_ = state = state | 0b1 /* add-active doInt(int) */;
                lock.unlock();
                hasLock = false;
                return doInt(arg0Value_);
            }
            {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(arg0Value)) != 0) {
                    double arg0Value_ = JSTypesGen.asImplicitDouble(doubleCast0, arg0Value);
                    state = (state | (doubleCast0 << 10) /* set-implicit-active 0:double */);
                    this.state_ = state = state | 0b10 /* add-active doDouble(double) */;
                    lock.unlock();
                    hasLock = false;
                    return doDouble(arg0Value_);
                }
            }
            if (arg0Value instanceof JSLazyString) {
                JSLazyString arg0Value_ = (JSLazyString) arg0Value;
                this.jSLazyString_flatten_ = (ConditionProfile.createBinaryProfile());
                this.state_ = state = state | 0b100 /* add-active doJSLazyString(JSLazyString, ConditionProfile) */;
                lock.unlock();
                hasLock = false;
                return doJSLazyString(arg0Value_, this.jSLazyString_flatten_);
            }
            {
                int stringCast0;
                if ((stringCast0 = JSTypesGen.specializeImplicitString(arg0Value)) != 0) {
                    String arg0Value_ = JSTypesGen.asImplicitString(stringCast0, arg0Value);
                    state = (state | (stringCast0 << 14) /* set-implicit-active 0:String */);
                    this.state_ = state = state | 0b1000 /* add-active doString(String) */;
                    lock.unlock();
                    hasLock = false;
                    return doString(arg0Value_);
                }
            }
            if (arg0Value instanceof Boolean) {
                boolean arg0Value_ = (boolean) arg0Value;
                this.state_ = state = state | 0b10000 /* add-active doBoolean(boolean) */;
                lock.unlock();
                hasLock = false;
                return doBoolean(arg0Value_);
            }
            if (JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if ((JSGuards.isJSDynamicObject(arg0Value_))) {
                    this.state_ = state = state | 0b100000 /* add-active doDynamicObject(DynamicObject) */;
                    lock.unlock();
                    hasLock = false;
                    return doDynamicObject(arg0Value_);
                }
            }
            if (arg0Value instanceof Symbol) {
                Symbol arg0Value_ = (Symbol) arg0Value;
                this.state_ = state = state | 0b1000000 /* add-active doSymbol(Symbol) */;
                lock.unlock();
                hasLock = false;
                return doSymbol(arg0Value_);
            }
            if (arg0Value instanceof BigInt) {
                BigInt arg0Value_ = (BigInt) arg0Value;
                this.state_ = state = state | 0b10000000 /* add-active doBigInt(BigInt) */;
                lock.unlock();
                hasLock = false;
                return doBigInt(arg0Value_);
            }
            if ((exclude) == 0 /* is-not-excluded doForeignObject(Object, InteropLibrary, ConditionProfile, JSCollectionsNormalizeNode) */) {
                int count9_ = 0;
                ForeignObject0Data s9_ = this.foreignObject0_cache;
                if ((state & 0b100000000) != 0 /* is-active doForeignObject(Object, InteropLibrary, ConditionProfile, JSCollectionsNormalizeNode) */) {
                    while (s9_ != null) {
                        if ((s9_.interop_.accepts(arg0Value)) && (JSGuards.isForeignObject(arg0Value))) {
                            break;
                        }
                        s9_ = s9_.next_;
                        count9_++;
                    }
                }
                if (s9_ == null) {
                    if ((JSGuards.isForeignObject(arg0Value)) && count9_ < (3)) {
                        // assert (s9_.interop_.accepts(arg0Value));
                        s9_ = super.insert(new ForeignObject0Data(foreignObject0_cache));
                        s9_.interop_ = s9_.insertAccessor((INTEROP_LIBRARY_.create(arg0Value)));
                        s9_.primitiveProfile_ = (ConditionProfile.createBinaryProfile());
                        s9_.nestedNormalizeNode_ = s9_.insertAccessor((JSCollectionsNormalizeNode.create()));
                        this.foreignObject0_cache = s9_;
                        this.state_ = state = state | 0b100000000 /* add-active doForeignObject(Object, InteropLibrary, ConditionProfile, JSCollectionsNormalizeNode) */;
                    }
                }
                if (s9_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return doForeignObject(arg0Value, s9_.interop_, s9_.primitiveProfile_, s9_.nestedNormalizeNode_);
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
                            this.foreignObject1_primitiveProfile_ = (ConditionProfile.createBinaryProfile());
                            this.foreignObject1_nestedNormalizeNode_ = super.insert((JSCollectionsNormalizeNode.create()));
                            this.exclude_ = exclude = exclude | 0b1 /* add-excluded doForeignObject(Object, InteropLibrary, ConditionProfile, JSCollectionsNormalizeNode) */;
                            this.foreignObject0_cache = null;
                            state = state & 0xfffffeff /* remove-active doForeignObject(Object, InteropLibrary, ConditionProfile, JSCollectionsNormalizeNode) */;
                            this.state_ = state = state | 0b1000000000 /* add-active doForeignObject(Object, InteropLibrary, ConditionProfile, JSCollectionsNormalizeNode) */;
                            lock.unlock();
                            hasLock = false;
                            return doForeignObject(arg0Value, foreignObject1_interop__, this.foreignObject1_primitiveProfile_, this.foreignObject1_nestedNormalizeNode_);
                        }
                    } finally {
                        encapsulating_.set(prev_);
                    }
                }
            }
            throw new UnsupportedSpecializationException(this, new Node[] {null}, arg0Value);
        } finally {
            if (hasLock) {
                lock.unlock();
            }
        }
    }

    @Override
    public NodeCost getCost() {
        int state = state_;
        if ((state & 0b1111111111) == 0b0) {
            return NodeCost.UNINITIALIZED;
        } else if (((state & 0b1111111111) & ((state & 0b1111111111) - 1)) == 0 /* is-single-active  */) {
            ForeignObject0Data s9_ = this.foreignObject0_cache;
            if ((s9_ == null || s9_.next_ == null)) {
                return NodeCost.MONOMORPHIC;
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[11];
        Object[] s;
        data[0] = 0;
        int state = state_;
        int exclude = exclude_;
        s = new Object[3];
        s[0] = "doInt";
        if ((state & 0b1) != 0 /* is-active doInt(int) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doDouble";
        if ((state & 0b10) != 0 /* is-active doDouble(double) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doJSLazyString";
        if ((state & 0b100) != 0 /* is-active doJSLazyString(JSLazyString, ConditionProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.jSLazyString_flatten_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doString";
        if ((state & 0b1000) != 0 /* is-active doString(String) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doBoolean";
        if ((state & 0b10000) != 0 /* is-active doBoolean(boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "doDynamicObject";
        if ((state & 0b100000) != 0 /* is-active doDynamicObject(DynamicObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "doSymbol";
        if ((state & 0b1000000) != 0 /* is-active doSymbol(Symbol) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        s = new Object[3];
        s[0] = "doBigInt";
        if ((state & 0b10000000) != 0 /* is-active doBigInt(BigInt) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[8] = s;
        s = new Object[3];
        s[0] = "doForeignObject";
        if ((state & 0b100000000) != 0 /* is-active doForeignObject(Object, InteropLibrary, ConditionProfile, JSCollectionsNormalizeNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            ForeignObject0Data s9_ = this.foreignObject0_cache;
            while (s9_ != null) {
                cached.add(Arrays.asList(s9_.interop_, s9_.primitiveProfile_, s9_.nestedNormalizeNode_));
                s9_ = s9_.next_;
            }
            s[2] = cached;
        } else if (exclude != 0 /* is-excluded doForeignObject(Object, InteropLibrary, ConditionProfile, JSCollectionsNormalizeNode) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[9] = s;
        s = new Object[3];
        s[0] = "doForeignObject";
        if ((state & 0b1000000000) != 0 /* is-active doForeignObject(Object, InteropLibrary, ConditionProfile, JSCollectionsNormalizeNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.foreignObject1_primitiveProfile_, this.foreignObject1_nestedNormalizeNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[10] = s;
        return Provider.create(data);
    }

    public static JSCollectionsNormalizeNode create() {
        return new JSCollectionsNormalizeNodeGen();
    }

    @GeneratedBy(JSCollectionsNormalizeNode.class)
    private static final class ForeignObject0Data extends Node {

        @Child ForeignObject0Data next_;
        @Child InteropLibrary interop_;
        @CompilationFinal ConditionProfile primitiveProfile_;
        @Child JSCollectionsNormalizeNode nestedNormalizeNode_;

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
