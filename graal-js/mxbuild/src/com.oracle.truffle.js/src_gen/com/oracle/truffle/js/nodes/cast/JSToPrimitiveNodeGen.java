// CheckStyle: start generated
package com.oracle.truffle.js.nodes.cast;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.TruffleLanguage.ContextReference;
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
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.js.lang.JavaScriptLanguage;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.access.IsPrimitiveNode;
import com.oracle.truffle.js.nodes.access.PropertyNode;
import com.oracle.truffle.js.nodes.function.JSFunctionCallNode;
import com.oracle.truffle.js.nodes.interop.ImportValueNode;
import com.oracle.truffle.js.runtime.BigInt;
import com.oracle.truffle.js.runtime.JSRealm;
import com.oracle.truffle.js.runtime.SafeInteger;
import com.oracle.truffle.js.runtime.Symbol;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSToPrimitiveNode.class)
@SuppressWarnings("unused")
public final class JSToPrimitiveNodeGen extends JSToPrimitiveNode implements Provider {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private ContextReference<JSRealm> javaScriptLanguageContextReference_;
    @Child private JSObjectData jSObject_cache;
    @Child private TruffleJavaObject0Data truffleJavaObject0_cache;
    @Child private ImportValueNode truffleJavaObject1_toJSType_;

    private JSToPrimitiveNodeGen(Hint hint) {
        super(hint);
    }

    @ExplodeLoop
    @Override
    public Object execute(Object arg0Value) {
        int state = state_;
        if ((state & 0b1) != 0 /* is-active doInt(int) */ && arg0Value instanceof Integer) {
            int arg0Value_ = (int) arg0Value;
            return doInt(arg0Value_);
        }
        if ((state & 0b10) != 0 /* is-active doSafeInteger(SafeInteger) */ && arg0Value instanceof SafeInteger) {
            SafeInteger arg0Value_ = (SafeInteger) arg0Value;
            return doSafeInteger(arg0Value_);
        }
        if ((state & 0b100) != 0 /* is-active doLong(long) */ && arg0Value instanceof Long) {
            long arg0Value_ = (long) arg0Value;
            return doLong(arg0Value_);
        }
        if ((state & 0b1000) != 0 /* is-active doDouble(double) */ && JSTypesGen.isImplicitDouble((state & 0x3c000) >>> 14 /* extract-implicit-active 0:double */, arg0Value)) {
            double arg0Value_ = JSTypesGen.asImplicitDouble((state & 0x3c000) >>> 14 /* extract-implicit-active 0:double */, arg0Value);
            return doDouble(arg0Value_);
        }
        if ((state & 0b10000) != 0 /* is-active doBoolean(boolean) */ && arg0Value instanceof Boolean) {
            boolean arg0Value_ = (boolean) arg0Value;
            return doBoolean(arg0Value_);
        }
        if ((state & 0b100000) != 0 /* is-active doString(CharSequence) */ && JSTypesGen.isImplicitCharSequence((state & 0x3c0000) >>> 18 /* extract-implicit-active 0:CharSequence */, arg0Value)) {
            CharSequence arg0Value_ = JSTypesGen.asImplicitCharSequence((state & 0x3c0000) >>> 18 /* extract-implicit-active 0:CharSequence */, arg0Value);
            return doString(arg0Value_);
        }
        if ((state & 0b1000000) != 0 /* is-active doSymbol(Symbol) */ && arg0Value instanceof Symbol) {
            Symbol arg0Value_ = (Symbol) arg0Value;
            return doSymbol(arg0Value_);
        }
        if ((state & 0b10000000) != 0 /* is-active doBigInt(BigInt) */ && arg0Value instanceof BigInt) {
            BigInt arg0Value_ = (BigInt) arg0Value;
            return doBigInt(arg0Value_);
        }
        if ((state & 0b1100000000) != 0 /* is-active doNull(Object) || doUndefined(Object) */) {
            if ((state & 0b100000000) != 0 /* is-active doNull(Object) */) {
                if ((JSGuards.isJSNull(arg0Value))) {
                    return doNull(arg0Value);
                }
            }
            if ((state & 0b1000000000) != 0 /* is-active doUndefined(Object) */) {
                if ((JSGuards.isUndefined(arg0Value))) {
                    return doUndefined(arg0Value);
                }
            }
        }
        if ((state & 0b10000000000) != 0 /* is-active doJSObject(DynamicObject, PropertyNode, IsPrimitiveNode, OrdinaryToPrimitiveNode, ConditionProfile, JSFunctionCallNode) */ && JSTypes.isDynamicObject(arg0Value)) {
            DynamicObject arg0Value_ = (DynamicObject) arg0Value;
            JSObjectData s11_ = this.jSObject_cache;
            if (s11_ != null) {
                if ((JSGuards.isJSObject(arg0Value_))) {
                    return doJSObject(arg0Value_, s11_.getToPrimitive_, s11_.isPrimitive_, s11_.ordinaryToPrimitive_, s11_.exoticToPrimProfile_, s11_.callExoticToPrim_);
                }
            }
        }
        if ((state & 0b11100000000000) != 0 /* is-active doTruffleJavaObject(Object, InteropLibrary, ContextReference<JSRealm>, ImportValueNode) || doTruffleJavaObject(Object, InteropLibrary, ContextReference<JSRealm>, ImportValueNode) || doFallback(Object) */) {
            if ((state & 0b100000000000) != 0 /* is-active doTruffleJavaObject(Object, InteropLibrary, ContextReference<JSRealm>, ImportValueNode) */) {
                TruffleJavaObject0Data s12_ = this.truffleJavaObject0_cache;
                while (s12_ != null) {
                    if ((s12_.interop_.accepts(arg0Value)) && (JSGuards.isForeignObject(arg0Value))) {
                        ContextReference<JSRealm> javaScriptLanguageContextReference__ = this.javaScriptLanguageContextReference_;
                        ContextReference<JSRealm> contextRef__ = javaScriptLanguageContextReference__;
                        return doTruffleJavaObject(arg0Value, s12_.interop_, contextRef__, s12_.toJSType_);
                    }
                    s12_ = s12_.next_;
                }
            }
            if ((state & 0b1000000000000) != 0 /* is-active doTruffleJavaObject(Object, InteropLibrary, ContextReference<JSRealm>, ImportValueNode) */) {
                if ((JSGuards.isForeignObject(arg0Value))) {
                    return this.truffleJavaObject1Boundary(state, arg0Value);
                }
            }
            if ((state & 0b10000000000000) != 0 /* is-active doFallback(Object) */) {
                if (fallbackGuard_(state, arg0Value)) {
                    return doFallback(arg0Value);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    @TruffleBoundary
    private Object truffleJavaObject1Boundary(int state, Object arg0Value) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary truffleJavaObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arg0Value));
                ContextReference<JSRealm> javaScriptLanguageContextReference__1 = this.javaScriptLanguageContextReference_;
                ContextReference<JSRealm> truffleJavaObject1_contextRef__ = javaScriptLanguageContextReference__1;
                return doTruffleJavaObject(arg0Value, truffleJavaObject1_interop__, truffleJavaObject1_contextRef__, this.truffleJavaObject1_toJSType_);
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
            if (arg0Value instanceof SafeInteger) {
                SafeInteger arg0Value_ = (SafeInteger) arg0Value;
                this.state_ = state = state | 0b10 /* add-active doSafeInteger(SafeInteger) */;
                lock.unlock();
                hasLock = false;
                return doSafeInteger(arg0Value_);
            }
            if (arg0Value instanceof Long) {
                long arg0Value_ = (long) arg0Value;
                this.state_ = state = state | 0b100 /* add-active doLong(long) */;
                lock.unlock();
                hasLock = false;
                return doLong(arg0Value_);
            }
            {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(arg0Value)) != 0) {
                    double arg0Value_ = JSTypesGen.asImplicitDouble(doubleCast0, arg0Value);
                    state = (state | (doubleCast0 << 14) /* set-implicit-active 0:double */);
                    this.state_ = state = state | 0b1000 /* add-active doDouble(double) */;
                    lock.unlock();
                    hasLock = false;
                    return doDouble(arg0Value_);
                }
            }
            if (arg0Value instanceof Boolean) {
                boolean arg0Value_ = (boolean) arg0Value;
                this.state_ = state = state | 0b10000 /* add-active doBoolean(boolean) */;
                lock.unlock();
                hasLock = false;
                return doBoolean(arg0Value_);
            }
            {
                int charSequenceCast0;
                if ((charSequenceCast0 = JSTypesGen.specializeImplicitCharSequence(arg0Value)) != 0) {
                    CharSequence arg0Value_ = JSTypesGen.asImplicitCharSequence(charSequenceCast0, arg0Value);
                    state = (state | (charSequenceCast0 << 18) /* set-implicit-active 0:CharSequence */);
                    this.state_ = state = state | 0b100000 /* add-active doString(CharSequence) */;
                    lock.unlock();
                    hasLock = false;
                    return doString(arg0Value_);
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
            if ((JSGuards.isJSNull(arg0Value))) {
                this.state_ = state = state | 0b100000000 /* add-active doNull(Object) */;
                lock.unlock();
                hasLock = false;
                return doNull(arg0Value);
            }
            if ((JSGuards.isUndefined(arg0Value))) {
                this.state_ = state = state | 0b1000000000 /* add-active doUndefined(Object) */;
                lock.unlock();
                hasLock = false;
                return doUndefined(arg0Value);
            }
            if (JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if ((JSGuards.isJSObject(arg0Value_))) {
                    JSObjectData s11_ = super.insert(new JSObjectData());
                    s11_.getToPrimitive_ = s11_.insertAccessor((JSToPrimitiveNode.createGetToPrimitive(arg0Value_)));
                    s11_.isPrimitive_ = s11_.insertAccessor((IsPrimitiveNode.create()));
                    s11_.ordinaryToPrimitive_ = s11_.insertAccessor((createOrdinaryToPrimitive(arg0Value_)));
                    s11_.exoticToPrimProfile_ = (ConditionProfile.createBinaryProfile());
                    s11_.callExoticToPrim_ = s11_.insertAccessor((JSFunctionCallNode.createCall()));
                    this.jSObject_cache = s11_;
                    this.state_ = state = state | 0b10000000000 /* add-active doJSObject(DynamicObject, PropertyNode, IsPrimitiveNode, OrdinaryToPrimitiveNode, ConditionProfile, JSFunctionCallNode) */;
                    lock.unlock();
                    hasLock = false;
                    return doJSObject(arg0Value_, s11_.getToPrimitive_, s11_.isPrimitive_, s11_.ordinaryToPrimitive_, s11_.exoticToPrimProfile_, s11_.callExoticToPrim_);
                }
            }
            {
                ContextReference<JSRealm> contextRef__ = null;
                if ((exclude) == 0 /* is-not-excluded doTruffleJavaObject(Object, InteropLibrary, ContextReference<JSRealm>, ImportValueNode) */) {
                    int count12_ = 0;
                    TruffleJavaObject0Data s12_ = this.truffleJavaObject0_cache;
                    if ((state & 0b100000000000) != 0 /* is-active doTruffleJavaObject(Object, InteropLibrary, ContextReference<JSRealm>, ImportValueNode) */) {
                        while (s12_ != null) {
                            if ((s12_.interop_.accepts(arg0Value)) && (JSGuards.isForeignObject(arg0Value))) {
                                ContextReference<JSRealm> javaScriptLanguageContextReference__2 = this.javaScriptLanguageContextReference_;
                                if (javaScriptLanguageContextReference__2 == null) {
                                    this.javaScriptLanguageContextReference_ = javaScriptLanguageContextReference__2 = super.lookupContextReference(JavaScriptLanguage.class);
                                }
                                contextRef__ = javaScriptLanguageContextReference__2;
                                break;
                            }
                            s12_ = s12_.next_;
                            count12_++;
                        }
                    }
                    if (s12_ == null) {
                        if ((JSGuards.isForeignObject(arg0Value)) && count12_ < (5)) {
                            // assert (s12_.interop_.accepts(arg0Value));
                            s12_ = super.insert(new TruffleJavaObject0Data(truffleJavaObject0_cache));
                            s12_.interop_ = s12_.insertAccessor((INTEROP_LIBRARY_.create(arg0Value)));
                            ContextReference<JSRealm> javaScriptLanguageContextReference__3 = this.javaScriptLanguageContextReference_;
                            if (javaScriptLanguageContextReference__3 == null) {
                                this.javaScriptLanguageContextReference_ = javaScriptLanguageContextReference__3 = super.lookupContextReference(JavaScriptLanguage.class);
                            }
                            contextRef__ = javaScriptLanguageContextReference__3;
                            s12_.toJSType_ = s12_.insertAccessor((ImportValueNode.create()));
                            this.truffleJavaObject0_cache = s12_;
                            this.state_ = state = state | 0b100000000000 /* add-active doTruffleJavaObject(Object, InteropLibrary, ContextReference<JSRealm>, ImportValueNode) */;
                        }
                    }
                    if (s12_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return doTruffleJavaObject(arg0Value, s12_.interop_, contextRef__, s12_.toJSType_);
                    }
                }
            }
            {
                ContextReference<JSRealm> truffleJavaObject1_contextRef__ = null;
                InteropLibrary truffleJavaObject1_interop__ = null;
                {
                    EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                    Node prev_ = encapsulating_.set(this);
                    try {
                        if ((JSGuards.isForeignObject(arg0Value))) {
                            truffleJavaObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arg0Value));
                            ContextReference<JSRealm> javaScriptLanguageContextReference__4 = this.javaScriptLanguageContextReference_;
                            if (javaScriptLanguageContextReference__4 == null) {
                                this.javaScriptLanguageContextReference_ = javaScriptLanguageContextReference__4 = super.lookupContextReference(JavaScriptLanguage.class);
                            }
                            truffleJavaObject1_contextRef__ = javaScriptLanguageContextReference__4;
                            this.truffleJavaObject1_toJSType_ = super.insert((ImportValueNode.create()));
                            this.exclude_ = exclude = exclude | 0b1 /* add-excluded doTruffleJavaObject(Object, InteropLibrary, ContextReference<JSRealm>, ImportValueNode) */;
                            this.truffleJavaObject0_cache = null;
                            state = state & 0xfffff7ff /* remove-active doTruffleJavaObject(Object, InteropLibrary, ContextReference<JSRealm>, ImportValueNode) */;
                            this.state_ = state = state | 0b1000000000000 /* add-active doTruffleJavaObject(Object, InteropLibrary, ContextReference<JSRealm>, ImportValueNode) */;
                            lock.unlock();
                            hasLock = false;
                            return doTruffleJavaObject(arg0Value, truffleJavaObject1_interop__, truffleJavaObject1_contextRef__, this.truffleJavaObject1_toJSType_);
                        }
                    } finally {
                        encapsulating_.set(prev_);
                    }
                }
            }
            this.state_ = state = state | 0b10000000000000 /* add-active doFallback(Object) */;
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
        if ((state & 0b11111111111111) == 0b0) {
            return NodeCost.UNINITIALIZED;
        } else if (((state & 0b11111111111111) & ((state & 0b11111111111111) - 1)) == 0 /* is-single-active  */) {
            TruffleJavaObject0Data s12_ = this.truffleJavaObject0_cache;
            if ((s12_ == null || s12_.next_ == null)) {
                return NodeCost.MONOMORPHIC;
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[15];
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
        s[0] = "doSafeInteger";
        if ((state & 0b10) != 0 /* is-active doSafeInteger(SafeInteger) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doLong";
        if ((state & 0b100) != 0 /* is-active doLong(long) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doDouble";
        if ((state & 0b1000) != 0 /* is-active doDouble(double) */) {
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
        s[0] = "doString";
        if ((state & 0b100000) != 0 /* is-active doString(CharSequence) */) {
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
        s[0] = "doNull";
        if ((state & 0b100000000) != 0 /* is-active doNull(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[9] = s;
        s = new Object[3];
        s[0] = "doUndefined";
        if ((state & 0b1000000000) != 0 /* is-active doUndefined(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[10] = s;
        s = new Object[3];
        s[0] = "doJSObject";
        if ((state & 0b10000000000) != 0 /* is-active doJSObject(DynamicObject, PropertyNode, IsPrimitiveNode, OrdinaryToPrimitiveNode, ConditionProfile, JSFunctionCallNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            JSObjectData s11_ = this.jSObject_cache;
            if (s11_ != null) {
                cached.add(Arrays.asList(s11_.getToPrimitive_, s11_.isPrimitive_, s11_.ordinaryToPrimitive_, s11_.exoticToPrimProfile_, s11_.callExoticToPrim_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[11] = s;
        s = new Object[3];
        s[0] = "doTruffleJavaObject";
        if ((state & 0b100000000000) != 0 /* is-active doTruffleJavaObject(Object, InteropLibrary, ContextReference<JSRealm>, ImportValueNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            TruffleJavaObject0Data s12_ = this.truffleJavaObject0_cache;
            while (s12_ != null) {
                cached.add(Arrays.asList(s12_.interop_, s12_.toJSType_));
                s12_ = s12_.next_;
            }
            s[2] = cached;
        } else if (exclude != 0 /* is-excluded doTruffleJavaObject(Object, InteropLibrary, ContextReference<JSRealm>, ImportValueNode) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[12] = s;
        s = new Object[3];
        s[0] = "doTruffleJavaObject";
        if ((state & 0b1000000000000) != 0 /* is-active doTruffleJavaObject(Object, InteropLibrary, ContextReference<JSRealm>, ImportValueNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.truffleJavaObject1_toJSType_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[13] = s;
        s = new Object[3];
        s[0] = "doFallback";
        if ((state & 0b10000000000000) != 0 /* is-active doFallback(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[14] = s;
        return Provider.create(data);
    }

    private static boolean fallbackGuard_(int state, Object arg0Value) {
        if (JSTypesGen.isImplicitDouble(arg0Value)) {
            return false;
        }
        if (((state & 0b10000)) == 0 /* is-not-active doBoolean(boolean) */ && arg0Value instanceof Boolean) {
            return false;
        }
        if (JSTypesGen.isImplicitCharSequence(arg0Value)) {
            return false;
        }
        if (((state & 0b1000000)) == 0 /* is-not-active doSymbol(Symbol) */ && arg0Value instanceof Symbol) {
            return false;
        }
        if (((state & 0b10000000)) == 0 /* is-not-active doBigInt(BigInt) */ && arg0Value instanceof BigInt) {
            return false;
        }
        if (((state & 0b100000000)) == 0 /* is-not-active doNull(Object) */ && (JSGuards.isJSNull(arg0Value))) {
            return false;
        }
        if (((state & 0b1000000000)) == 0 /* is-not-active doUndefined(Object) */ && (JSGuards.isUndefined(arg0Value))) {
            return false;
        }
        if (JSTypes.isDynamicObject(arg0Value)) {
            DynamicObject arg0Value_ = (DynamicObject) arg0Value;
            if ((JSGuards.isJSObject(arg0Value_))) {
                return false;
            }
        }
        if (((state & 0b1000000000000)) == 0 /* is-not-active doTruffleJavaObject(Object, InteropLibrary, ContextReference<JSRealm>, ImportValueNode) */ && (JSGuards.isForeignObject(arg0Value))) {
            return false;
        }
        return true;
    }

    public static JSToPrimitiveNode create(Hint hint) {
        return new JSToPrimitiveNodeGen(hint);
    }

    @GeneratedBy(JSToPrimitiveNode.class)
    private static final class JSObjectData extends Node {

        @Child PropertyNode getToPrimitive_;
        @Child IsPrimitiveNode isPrimitive_;
        @Child OrdinaryToPrimitiveNode ordinaryToPrimitive_;
        @CompilationFinal ConditionProfile exoticToPrimProfile_;
        @Child JSFunctionCallNode callExoticToPrim_;

        JSObjectData() {
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.NONE;
        }

        <T extends Node> T insertAccessor(T node) {
            return super.insert(node);
        }

    }
    @GeneratedBy(JSToPrimitiveNode.class)
    private static final class TruffleJavaObject0Data extends Node {

        @Child TruffleJavaObject0Data next_;
        @Child InteropLibrary interop_;
        @Child ImportValueNode toJSType_;

        TruffleJavaObject0Data(TruffleJavaObject0Data next_) {
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
