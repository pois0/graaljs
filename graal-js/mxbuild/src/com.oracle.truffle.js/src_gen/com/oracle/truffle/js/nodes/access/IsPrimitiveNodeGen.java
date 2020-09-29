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
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.runtime.BigInt;
import com.oracle.truffle.js.runtime.SafeInteger;
import com.oracle.truffle.js.runtime.Symbol;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(IsPrimitiveNode.class)
@SuppressWarnings("unused")
public final class IsPrimitiveNodeGen extends IsPrimitiveNode implements Provider {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @Child private ForeignObject0Data foreignObject0_cache;

    private IsPrimitiveNodeGen() {
    }

    @ExplodeLoop
    @Override
    public boolean executeBoolean(Object arg0Value) {
        int state = state_;
        if ((state & 0b11) != 0 /* is-active doNull(Object) || doUndefined(Object) */) {
            if ((state & 0b1) != 0 /* is-active doNull(Object) */) {
                if ((JSGuards.isJSNull(arg0Value))) {
                    return IsPrimitiveNode.doNull(arg0Value);
                }
            }
            if ((state & 0b10) != 0 /* is-active doUndefined(Object) */) {
                if ((JSGuards.isUndefined(arg0Value))) {
                    return IsPrimitiveNode.doUndefined(arg0Value);
                }
            }
        }
        if ((state & 0b100) != 0 /* is-active doBoolean(boolean) */ && arg0Value instanceof Boolean) {
            boolean arg0Value_ = (boolean) arg0Value;
            return IsPrimitiveNode.doBoolean(arg0Value_);
        }
        if ((state & 0b1000) != 0 /* is-active doInt(int) */ && arg0Value instanceof Integer) {
            int arg0Value_ = (int) arg0Value;
            return IsPrimitiveNode.doInt(arg0Value_);
        }
        if ((state & 0b10000) != 0 /* is-active doLong(long) */ && arg0Value instanceof Long) {
            long arg0Value_ = (long) arg0Value;
            return IsPrimitiveNode.doLong(arg0Value_);
        }
        if ((state & 0b100000) != 0 /* is-active doLargeInt(SafeInteger) */ && arg0Value instanceof SafeInteger) {
            SafeInteger arg0Value_ = (SafeInteger) arg0Value;
            return IsPrimitiveNode.doLargeInt(arg0Value_);
        }
        if ((state & 0b1000000) != 0 /* is-active doDouble(double) */ && JSTypesGen.isImplicitDouble((state & 0x1e000) >>> 13 /* extract-implicit-active 0:double */, arg0Value)) {
            double arg0Value_ = JSTypesGen.asImplicitDouble((state & 0x1e000) >>> 13 /* extract-implicit-active 0:double */, arg0Value);
            return IsPrimitiveNode.doDouble(arg0Value_);
        }
        if ((state & 0b10000000) != 0 /* is-active doSymbol(Symbol) */ && arg0Value instanceof Symbol) {
            Symbol arg0Value_ = (Symbol) arg0Value;
            return IsPrimitiveNode.doSymbol(arg0Value_);
        }
        if ((state & 0b100000000) != 0 /* is-active doBigInt(BigInt) */ && arg0Value instanceof BigInt) {
            BigInt arg0Value_ = (BigInt) arg0Value;
            return IsPrimitiveNode.doBigInt(arg0Value_);
        }
        if ((state & 0b1000000000) != 0 /* is-active doString(CharSequence) */ && JSTypesGen.isImplicitCharSequence((state & 0x1e0000) >>> 17 /* extract-implicit-active 0:CharSequence */, arg0Value)) {
            CharSequence arg0Value_ = JSTypesGen.asImplicitCharSequence((state & 0x1e0000) >>> 17 /* extract-implicit-active 0:CharSequence */, arg0Value);
            return IsPrimitiveNode.doString(arg0Value_);
        }
        if ((state & 0b10000000000) != 0 /* is-active doIsObject(DynamicObject) */ && JSTypes.isDynamicObject(arg0Value)) {
            DynamicObject arg0Value_ = (DynamicObject) arg0Value;
            if ((JSGuards.isJSObject(arg0Value_))) {
                return IsPrimitiveNode.doIsObject(arg0Value_);
            }
        }
        if ((state & 0b1100000000000) != 0 /* is-active doForeignObject(Object, InteropLibrary) || doForeignObject(Object, InteropLibrary) */) {
            if ((state & 0b100000000000) != 0 /* is-active doForeignObject(Object, InteropLibrary) */) {
                ForeignObject0Data s12_ = this.foreignObject0_cache;
                while (s12_ != null) {
                    if ((s12_.interop_.accepts(arg0Value)) && (JSGuards.isForeignObject(arg0Value))) {
                        return IsPrimitiveNode.doForeignObject(arg0Value, s12_.interop_);
                    }
                    s12_ = s12_.next_;
                }
            }
            if ((state & 0b1000000000000) != 0 /* is-active doForeignObject(Object, InteropLibrary) */) {
                if ((JSGuards.isForeignObject(arg0Value))) {
                    return this.foreignObject1Boundary(state, arg0Value);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    @TruffleBoundary
    private boolean foreignObject1Boundary(int state, Object arg0Value) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary foreignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arg0Value));
                return IsPrimitiveNode.doForeignObject(arg0Value, foreignObject1_interop__);
            }
        } finally {
            encapsulating_.set(prev_);
        }
    }

    private boolean executeAndSpecialize(Object arg0Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        int exclude = exclude_;
        try {
            if ((JSGuards.isJSNull(arg0Value))) {
                this.state_ = state = state | 0b1 /* add-active doNull(Object) */;
                lock.unlock();
                hasLock = false;
                return IsPrimitiveNode.doNull(arg0Value);
            }
            if ((JSGuards.isUndefined(arg0Value))) {
                this.state_ = state = state | 0b10 /* add-active doUndefined(Object) */;
                lock.unlock();
                hasLock = false;
                return IsPrimitiveNode.doUndefined(arg0Value);
            }
            if (arg0Value instanceof Boolean) {
                boolean arg0Value_ = (boolean) arg0Value;
                this.state_ = state = state | 0b100 /* add-active doBoolean(boolean) */;
                lock.unlock();
                hasLock = false;
                return IsPrimitiveNode.doBoolean(arg0Value_);
            }
            if (arg0Value instanceof Integer) {
                int arg0Value_ = (int) arg0Value;
                this.state_ = state = state | 0b1000 /* add-active doInt(int) */;
                lock.unlock();
                hasLock = false;
                return IsPrimitiveNode.doInt(arg0Value_);
            }
            if (arg0Value instanceof Long) {
                long arg0Value_ = (long) arg0Value;
                this.state_ = state = state | 0b10000 /* add-active doLong(long) */;
                lock.unlock();
                hasLock = false;
                return IsPrimitiveNode.doLong(arg0Value_);
            }
            if (arg0Value instanceof SafeInteger) {
                SafeInteger arg0Value_ = (SafeInteger) arg0Value;
                this.state_ = state = state | 0b100000 /* add-active doLargeInt(SafeInteger) */;
                lock.unlock();
                hasLock = false;
                return IsPrimitiveNode.doLargeInt(arg0Value_);
            }
            {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(arg0Value)) != 0) {
                    double arg0Value_ = JSTypesGen.asImplicitDouble(doubleCast0, arg0Value);
                    state = (state | (doubleCast0 << 13) /* set-implicit-active 0:double */);
                    this.state_ = state = state | 0b1000000 /* add-active doDouble(double) */;
                    lock.unlock();
                    hasLock = false;
                    return IsPrimitiveNode.doDouble(arg0Value_);
                }
            }
            if (arg0Value instanceof Symbol) {
                Symbol arg0Value_ = (Symbol) arg0Value;
                this.state_ = state = state | 0b10000000 /* add-active doSymbol(Symbol) */;
                lock.unlock();
                hasLock = false;
                return IsPrimitiveNode.doSymbol(arg0Value_);
            }
            if (arg0Value instanceof BigInt) {
                BigInt arg0Value_ = (BigInt) arg0Value;
                this.state_ = state = state | 0b100000000 /* add-active doBigInt(BigInt) */;
                lock.unlock();
                hasLock = false;
                return IsPrimitiveNode.doBigInt(arg0Value_);
            }
            {
                int charSequenceCast0;
                if ((charSequenceCast0 = JSTypesGen.specializeImplicitCharSequence(arg0Value)) != 0) {
                    CharSequence arg0Value_ = JSTypesGen.asImplicitCharSequence(charSequenceCast0, arg0Value);
                    state = (state | (charSequenceCast0 << 17) /* set-implicit-active 0:CharSequence */);
                    this.state_ = state = state | 0b1000000000 /* add-active doString(CharSequence) */;
                    lock.unlock();
                    hasLock = false;
                    return IsPrimitiveNode.doString(arg0Value_);
                }
            }
            if (JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if ((JSGuards.isJSObject(arg0Value_))) {
                    this.state_ = state = state | 0b10000000000 /* add-active doIsObject(DynamicObject) */;
                    lock.unlock();
                    hasLock = false;
                    return IsPrimitiveNode.doIsObject(arg0Value_);
                }
            }
            if ((exclude) == 0 /* is-not-excluded doForeignObject(Object, InteropLibrary) */) {
                int count12_ = 0;
                ForeignObject0Data s12_ = this.foreignObject0_cache;
                if ((state & 0b100000000000) != 0 /* is-active doForeignObject(Object, InteropLibrary) */) {
                    while (s12_ != null) {
                        if ((s12_.interop_.accepts(arg0Value)) && (JSGuards.isForeignObject(arg0Value))) {
                            break;
                        }
                        s12_ = s12_.next_;
                        count12_++;
                    }
                }
                if (s12_ == null) {
                    if ((JSGuards.isForeignObject(arg0Value)) && count12_ < (5)) {
                        // assert (s12_.interop_.accepts(arg0Value));
                        s12_ = super.insert(new ForeignObject0Data(foreignObject0_cache));
                        s12_.interop_ = s12_.insertAccessor((INTEROP_LIBRARY_.create(arg0Value)));
                        this.foreignObject0_cache = s12_;
                        this.state_ = state = state | 0b100000000000 /* add-active doForeignObject(Object, InteropLibrary) */;
                    }
                }
                if (s12_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return IsPrimitiveNode.doForeignObject(arg0Value, s12_.interop_);
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
                            this.exclude_ = exclude = exclude | 0b1 /* add-excluded doForeignObject(Object, InteropLibrary) */;
                            this.foreignObject0_cache = null;
                            state = state & 0xfffff7ff /* remove-active doForeignObject(Object, InteropLibrary) */;
                            this.state_ = state = state | 0b1000000000000 /* add-active doForeignObject(Object, InteropLibrary) */;
                            lock.unlock();
                            hasLock = false;
                            return IsPrimitiveNode.doForeignObject(arg0Value, foreignObject1_interop__);
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
        if ((state & 0b1111111111111) == 0b0) {
            return NodeCost.UNINITIALIZED;
        } else if (((state & 0b1111111111111) & ((state & 0b1111111111111) - 1)) == 0 /* is-single-active  */) {
            ForeignObject0Data s12_ = this.foreignObject0_cache;
            if ((s12_ == null || s12_.next_ == null)) {
                return NodeCost.MONOMORPHIC;
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[14];
        Object[] s;
        data[0] = 0;
        int state = state_;
        int exclude = exclude_;
        s = new Object[3];
        s[0] = "doNull";
        if ((state & 0b1) != 0 /* is-active doNull(Object) */) {
            s[1] = (byte)0b01 /* active */;
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
        s[0] = "doBoolean";
        if ((state & 0b100) != 0 /* is-active doBoolean(boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doInt";
        if ((state & 0b1000) != 0 /* is-active doInt(int) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doLong";
        if ((state & 0b10000) != 0 /* is-active doLong(long) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "doLargeInt";
        if ((state & 0b100000) != 0 /* is-active doLargeInt(SafeInteger) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "doDouble";
        if ((state & 0b1000000) != 0 /* is-active doDouble(double) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        s = new Object[3];
        s[0] = "doSymbol";
        if ((state & 0b10000000) != 0 /* is-active doSymbol(Symbol) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[8] = s;
        s = new Object[3];
        s[0] = "doBigInt";
        if ((state & 0b100000000) != 0 /* is-active doBigInt(BigInt) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[9] = s;
        s = new Object[3];
        s[0] = "doString";
        if ((state & 0b1000000000) != 0 /* is-active doString(CharSequence) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[10] = s;
        s = new Object[3];
        s[0] = "doIsObject";
        if ((state & 0b10000000000) != 0 /* is-active doIsObject(DynamicObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[11] = s;
        s = new Object[3];
        s[0] = "doForeignObject";
        if ((state & 0b100000000000) != 0 /* is-active doForeignObject(Object, InteropLibrary) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            ForeignObject0Data s12_ = this.foreignObject0_cache;
            while (s12_ != null) {
                cached.add(Arrays.asList(s12_.interop_));
                s12_ = s12_.next_;
            }
            s[2] = cached;
        } else if (exclude != 0 /* is-excluded doForeignObject(Object, InteropLibrary) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[12] = s;
        s = new Object[3];
        s[0] = "doForeignObject";
        if ((state & 0b1000000000000) != 0 /* is-active doForeignObject(Object, InteropLibrary) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList());
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[13] = s;
        return Provider.create(data);
    }

    public static IsPrimitiveNode create() {
        return new IsPrimitiveNodeGen();
    }

    @GeneratedBy(IsPrimitiveNode.class)
    private static final class ForeignObject0Data extends Node {

        @Child ForeignObject0Data next_;
        @Child InteropLibrary interop_;

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
