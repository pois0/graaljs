// CheckStyle: start generated
package com.oracle.truffle.js.nodes.unary;

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
import com.oracle.truffle.api.object.Shape;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.runtime.BigInt;
import com.oracle.truffle.js.runtime.Symbol;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(IsCallableNode.class)
@SuppressWarnings("unused")
public final class IsCallableNodeGen extends IsCallableNode implements Provider {

    private static final Uncached UNCACHED = new Uncached();
    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private Shape jSFunctionShape_shape_;
    @Child private TruffleObject0Data truffleObject0_cache;

    private IsCallableNodeGen() {
    }

    @ExplodeLoop
    @Override
    public boolean executeBoolean(Object arg0Value) {
        int state = state_;
        if ((state & 0b1111) != 0 /* is-active doJSFunctionShape(DynamicObject, Shape) || doJSFunction(DynamicObject) || doJSProxy(DynamicObject) || doJSTypeOther(DynamicObject) */ && JSTypes.isDynamicObject(arg0Value)) {
            DynamicObject arg0Value_ = (DynamicObject) arg0Value;
            if ((state & 0b1) != 0 /* is-active doJSFunctionShape(DynamicObject, Shape) */) {
                if ((this.jSFunctionShape_shape_.check(arg0Value_))) {
                    assert (JSGuards.isJSFunctionShape(this.jSFunctionShape_shape_));
                    return IsCallableNode.doJSFunctionShape(arg0Value_, this.jSFunctionShape_shape_);
                }
            }
            if ((state & 0b10) != 0 /* is-active doJSFunction(DynamicObject) */) {
                if ((JSGuards.isJSFunction(arg0Value_))) {
                    return IsCallableNode.doJSFunction(arg0Value_);
                }
            }
            if ((state & 0b100) != 0 /* is-active doJSProxy(DynamicObject) */) {
                if ((JSGuards.isJSProxy(arg0Value_))) {
                    return IsCallableNode.doJSProxy(arg0Value_);
                }
            }
            if ((state & 0b1000) != 0 /* is-active doJSTypeOther(DynamicObject) */) {
                if ((JSGuards.isJSDynamicObject(arg0Value_)) && (!(JSGuards.isJSFunction(arg0Value_))) && (!(JSGuards.isJSProxy(arg0Value_)))) {
                    return IsCallableNode.doJSTypeOther(arg0Value_);
                }
            }
        }
        if ((state & 0b110000) != 0 /* is-active doTruffleObject(Object, InteropLibrary) || doTruffleObject(Object, InteropLibrary) */) {
            if ((state & 0b10000) != 0 /* is-active doTruffleObject(Object, InteropLibrary) */) {
                TruffleObject0Data s5_ = this.truffleObject0_cache;
                while (s5_ != null) {
                    if ((s5_.interop_.accepts(arg0Value)) && (JSGuards.isForeignObject(arg0Value))) {
                        return IsCallableNode.doTruffleObject(arg0Value, s5_.interop_);
                    }
                    s5_ = s5_.next_;
                }
            }
            if ((state & 0b100000) != 0 /* is-active doTruffleObject(Object, InteropLibrary) */) {
                if ((JSGuards.isForeignObject(arg0Value))) {
                    return this.truffleObject1Boundary(state, arg0Value);
                }
            }
        }
        if ((state & 0b1000000) != 0 /* is-active doCharSequence(CharSequence) */ && JSTypesGen.isImplicitCharSequence((state & 0b111100000000000) >>> 11 /* extract-implicit-active 0:CharSequence */, arg0Value)) {
            CharSequence arg0Value_ = JSTypesGen.asImplicitCharSequence((state & 0b111100000000000) >>> 11 /* extract-implicit-active 0:CharSequence */, arg0Value);
            return IsCallableNode.doCharSequence(arg0Value_);
        }
        if ((state & 0b10000000) != 0 /* is-active doNumber(Number) */ && arg0Value instanceof Number) {
            Number arg0Value_ = (Number) arg0Value;
            return IsCallableNode.doNumber(arg0Value_);
        }
        if ((state & 0b100000000) != 0 /* is-active doBoolean(boolean) */ && arg0Value instanceof Boolean) {
            boolean arg0Value_ = (boolean) arg0Value;
            return IsCallableNode.doBoolean(arg0Value_);
        }
        if ((state & 0b1000000000) != 0 /* is-active doSymbol(Symbol) */ && arg0Value instanceof Symbol) {
            Symbol arg0Value_ = (Symbol) arg0Value;
            return IsCallableNode.doSymbol(arg0Value_);
        }
        if ((state & 0b10000000000) != 0 /* is-active doBigInt(BigInt) */ && arg0Value instanceof BigInt) {
            BigInt arg0Value_ = (BigInt) arg0Value;
            return IsCallableNode.doBigInt(arg0Value_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    @TruffleBoundary
    private boolean truffleObject1Boundary(int state, Object arg0Value) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary truffleObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arg0Value));
                return IsCallableNode.doTruffleObject(arg0Value, truffleObject1_interop__);
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
            if (JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if (((exclude & 0b1)) == 0 /* is-not-excluded doJSFunctionShape(DynamicObject, Shape) */) {
                    boolean JSFunctionShape_duplicateFound_ = false;
                    if ((state & 0b1) != 0 /* is-active doJSFunctionShape(DynamicObject, Shape) */) {
                        if ((this.jSFunctionShape_shape_.check(arg0Value_))) {
                            assert (JSGuards.isJSFunctionShape(this.jSFunctionShape_shape_));
                            JSFunctionShape_duplicateFound_ = true;
                        }
                    }
                    if (!JSFunctionShape_duplicateFound_) {
                        {
                            Shape jSFunctionShape_shape__ = (arg0Value_.getShape());
                            if ((jSFunctionShape_shape__.check(arg0Value_)) && (JSGuards.isJSFunctionShape(jSFunctionShape_shape__)) && ((state & 0b1)) == 0 /* is-not-active doJSFunctionShape(DynamicObject, Shape) */) {
                                this.jSFunctionShape_shape_ = jSFunctionShape_shape__;
                                this.state_ = state = state | 0b1 /* add-active doJSFunctionShape(DynamicObject, Shape) */;
                                JSFunctionShape_duplicateFound_ = true;
                            }
                        }
                    }
                    if (JSFunctionShape_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return IsCallableNode.doJSFunctionShape(arg0Value_, this.jSFunctionShape_shape_);
                    }
                }
                if ((JSGuards.isJSFunction(arg0Value_))) {
                    this.exclude_ = exclude = exclude | 0b1 /* add-excluded doJSFunctionShape(DynamicObject, Shape) */;
                    state = state & 0xfffffffe /* remove-active doJSFunctionShape(DynamicObject, Shape) */;
                    this.state_ = state = state | 0b10 /* add-active doJSFunction(DynamicObject) */;
                    lock.unlock();
                    hasLock = false;
                    return IsCallableNode.doJSFunction(arg0Value_);
                }
                if ((JSGuards.isJSProxy(arg0Value_))) {
                    this.state_ = state = state | 0b100 /* add-active doJSProxy(DynamicObject) */;
                    lock.unlock();
                    hasLock = false;
                    return IsCallableNode.doJSProxy(arg0Value_);
                }
                if ((JSGuards.isJSDynamicObject(arg0Value_)) && (!(JSGuards.isJSFunction(arg0Value_))) && (!(JSGuards.isJSProxy(arg0Value_)))) {
                    this.state_ = state = state | 0b1000 /* add-active doJSTypeOther(DynamicObject) */;
                    lock.unlock();
                    hasLock = false;
                    return IsCallableNode.doJSTypeOther(arg0Value_);
                }
            }
            if (((exclude & 0b10)) == 0 /* is-not-excluded doTruffleObject(Object, InteropLibrary) */) {
                int count5_ = 0;
                TruffleObject0Data s5_ = this.truffleObject0_cache;
                if ((state & 0b10000) != 0 /* is-active doTruffleObject(Object, InteropLibrary) */) {
                    while (s5_ != null) {
                        if ((s5_.interop_.accepts(arg0Value)) && (JSGuards.isForeignObject(arg0Value))) {
                            break;
                        }
                        s5_ = s5_.next_;
                        count5_++;
                    }
                }
                if (s5_ == null) {
                    if ((JSGuards.isForeignObject(arg0Value)) && count5_ < (3)) {
                        // assert (s5_.interop_.accepts(arg0Value));
                        s5_ = super.insert(new TruffleObject0Data(truffleObject0_cache));
                        s5_.interop_ = s5_.insertAccessor((INTEROP_LIBRARY_.create(arg0Value)));
                        this.truffleObject0_cache = s5_;
                        this.state_ = state = state | 0b10000 /* add-active doTruffleObject(Object, InteropLibrary) */;
                    }
                }
                if (s5_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return IsCallableNode.doTruffleObject(arg0Value, s5_.interop_);
                }
            }
            {
                InteropLibrary truffleObject1_interop__ = null;
                {
                    EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                    Node prev_ = encapsulating_.set(this);
                    try {
                        if ((JSGuards.isForeignObject(arg0Value))) {
                            truffleObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arg0Value));
                            this.exclude_ = exclude = exclude | 0b10 /* add-excluded doTruffleObject(Object, InteropLibrary) */;
                            this.truffleObject0_cache = null;
                            state = state & 0xffffffef /* remove-active doTruffleObject(Object, InteropLibrary) */;
                            this.state_ = state = state | 0b100000 /* add-active doTruffleObject(Object, InteropLibrary) */;
                            lock.unlock();
                            hasLock = false;
                            return IsCallableNode.doTruffleObject(arg0Value, truffleObject1_interop__);
                        }
                    } finally {
                        encapsulating_.set(prev_);
                    }
                }
            }
            {
                int charSequenceCast0;
                if ((charSequenceCast0 = JSTypesGen.specializeImplicitCharSequence(arg0Value)) != 0) {
                    CharSequence arg0Value_ = JSTypesGen.asImplicitCharSequence(charSequenceCast0, arg0Value);
                    state = (state | (charSequenceCast0 << 11) /* set-implicit-active 0:CharSequence */);
                    this.state_ = state = state | 0b1000000 /* add-active doCharSequence(CharSequence) */;
                    lock.unlock();
                    hasLock = false;
                    return IsCallableNode.doCharSequence(arg0Value_);
                }
            }
            if (arg0Value instanceof Number) {
                Number arg0Value_ = (Number) arg0Value;
                this.state_ = state = state | 0b10000000 /* add-active doNumber(Number) */;
                lock.unlock();
                hasLock = false;
                return IsCallableNode.doNumber(arg0Value_);
            }
            if (arg0Value instanceof Boolean) {
                boolean arg0Value_ = (boolean) arg0Value;
                this.state_ = state = state | 0b100000000 /* add-active doBoolean(boolean) */;
                lock.unlock();
                hasLock = false;
                return IsCallableNode.doBoolean(arg0Value_);
            }
            if (arg0Value instanceof Symbol) {
                Symbol arg0Value_ = (Symbol) arg0Value;
                this.state_ = state = state | 0b1000000000 /* add-active doSymbol(Symbol) */;
                lock.unlock();
                hasLock = false;
                return IsCallableNode.doSymbol(arg0Value_);
            }
            if (arg0Value instanceof BigInt) {
                BigInt arg0Value_ = (BigInt) arg0Value;
                this.state_ = state = state | 0b10000000000 /* add-active doBigInt(BigInt) */;
                lock.unlock();
                hasLock = false;
                return IsCallableNode.doBigInt(arg0Value_);
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
        if ((state & 0b11111111111) == 0b0) {
            return NodeCost.UNINITIALIZED;
        } else if (((state & 0b11111111111) & ((state & 0b11111111111) - 1)) == 0 /* is-single-active  */) {
            TruffleObject0Data s5_ = this.truffleObject0_cache;
            if ((s5_ == null || s5_.next_ == null)) {
                return NodeCost.MONOMORPHIC;
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[12];
        Object[] s;
        data[0] = 0;
        int state = state_;
        int exclude = exclude_;
        s = new Object[3];
        s[0] = "doJSFunctionShape";
        if ((state & 0b1) != 0 /* is-active doJSFunctionShape(DynamicObject, Shape) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.jSFunctionShape_shape_));
            s[2] = cached;
        } else if ((exclude & 0b1) != 0 /* is-excluded doJSFunctionShape(DynamicObject, Shape) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doJSFunction";
        if ((state & 0b10) != 0 /* is-active doJSFunction(DynamicObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doJSProxy";
        if ((state & 0b100) != 0 /* is-active doJSProxy(DynamicObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doJSTypeOther";
        if ((state & 0b1000) != 0 /* is-active doJSTypeOther(DynamicObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doTruffleObject";
        if ((state & 0b10000) != 0 /* is-active doTruffleObject(Object, InteropLibrary) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            TruffleObject0Data s5_ = this.truffleObject0_cache;
            while (s5_ != null) {
                cached.add(Arrays.asList(s5_.interop_));
                s5_ = s5_.next_;
            }
            s[2] = cached;
        } else if ((exclude & 0b10) != 0 /* is-excluded doTruffleObject(Object, InteropLibrary) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "doTruffleObject";
        if ((state & 0b100000) != 0 /* is-active doTruffleObject(Object, InteropLibrary) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList());
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "doCharSequence";
        if ((state & 0b1000000) != 0 /* is-active doCharSequence(CharSequence) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        s = new Object[3];
        s[0] = "doNumber";
        if ((state & 0b10000000) != 0 /* is-active doNumber(Number) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[8] = s;
        s = new Object[3];
        s[0] = "doBoolean";
        if ((state & 0b100000000) != 0 /* is-active doBoolean(boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[9] = s;
        s = new Object[3];
        s[0] = "doSymbol";
        if ((state & 0b1000000000) != 0 /* is-active doSymbol(Symbol) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[10] = s;
        s = new Object[3];
        s[0] = "doBigInt";
        if ((state & 0b10000000000) != 0 /* is-active doBigInt(BigInt) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[11] = s;
        return Provider.create(data);
    }

    public static IsCallableNode create() {
        return new IsCallableNodeGen();
    }

    public static IsCallableNode getUncached() {
        return IsCallableNodeGen.UNCACHED;
    }

    @GeneratedBy(IsCallableNode.class)
    private static final class TruffleObject0Data extends Node {

        @Child TruffleObject0Data next_;
        @Child InteropLibrary interop_;

        TruffleObject0Data(TruffleObject0Data next_) {
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
    @GeneratedBy(IsCallableNode.class)
    private static final class Uncached extends IsCallableNode {

        @TruffleBoundary
        @Override
        public boolean executeBoolean(Object arg0Value) {
            if (JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if ((JSGuards.isJSFunction(arg0Value_))) {
                    return IsCallableNode.doJSFunction(arg0Value_);
                }
                if ((JSGuards.isJSProxy(arg0Value_))) {
                    return IsCallableNode.doJSProxy(arg0Value_);
                }
                if ((JSGuards.isJSDynamicObject(arg0Value_)) && (!(JSGuards.isJSFunction(arg0Value_))) && (!(JSGuards.isJSProxy(arg0Value_)))) {
                    return IsCallableNode.doJSTypeOther(arg0Value_);
                }
            }
            if ((JSGuards.isForeignObject(arg0Value))) {
                return IsCallableNode.doTruffleObject(arg0Value, (INTEROP_LIBRARY_.getUncached(arg0Value)));
            }
            if (JSTypesGen.isImplicitCharSequence(arg0Value)) {
                CharSequence arg0Value_ = JSTypesGen.asImplicitCharSequence(arg0Value);
                return IsCallableNode.doCharSequence(arg0Value_);
            }
            if (arg0Value instanceof Number) {
                Number arg0Value_ = (Number) arg0Value;
                return IsCallableNode.doNumber(arg0Value_);
            }
            if (arg0Value instanceof Boolean) {
                boolean arg0Value_ = (boolean) arg0Value;
                return IsCallableNode.doBoolean(arg0Value_);
            }
            if (arg0Value instanceof Symbol) {
                Symbol arg0Value_ = (Symbol) arg0Value;
                return IsCallableNode.doSymbol(arg0Value_);
            }
            if (arg0Value instanceof BigInt) {
                BigInt arg0Value_ = (BigInt) arg0Value;
                return IsCallableNode.doBigInt(arg0Value_);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {null}, arg0Value);
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
