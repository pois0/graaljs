// CheckStyle: start generated
package com.oracle.truffle.js.nodes.binary;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.EncapsulatingNodeReference;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.runtime.BigInt;
import com.oracle.truffle.js.runtime.JSRuntime;
import com.oracle.truffle.js.runtime.Symbol;
import com.oracle.truffle.js.runtime.objects.JSLazyString;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSIdenticalNode.class)
@SuppressWarnings("unused")
public final class JSIdenticalNodeGen extends JSIdenticalNode implements Provider {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @CompilationFinal private volatile long state_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private ConditionProfile flattenA;
    @CompilationFinal private ConditionProfile flattenB;
    @CompilationFinal private ConditionProfile sameLen;
    @Child private NullA0Data nullA0_cache;
    @Child private NullB0Data nullB0_cache;
    @CompilationFinal private DifferentTypesCachedData differentTypesCached_cache;
    @CompilationFinal private NumberCachedData numberCached_cache;
    @Child private ForeignObject0Data foreignObject0_cache;

    private JSIdenticalNodeGen(JavaScriptNode left, JavaScriptNode right, int type) {
        super(left, right, type);
    }

    @ExplodeLoop
    @Override
    public boolean executeBoolean(Object leftNodeValue, Object rightNodeValue) {
        long state = state_;
        if ((state & 0b1) != 0 /* is-active doInt(int, int) */ && leftNodeValue instanceof Integer) {
            int leftNodeValue_ = (int) leftNodeValue;
            if (rightNodeValue instanceof Integer) {
                int rightNodeValue_ = (int) rightNodeValue;
                return JSIdenticalNode.doInt(leftNodeValue_, rightNodeValue_);
            }
        }
        if ((state & 0b10) != 0 /* is-active doDouble(double, double) */ && JSTypesGen.isImplicitDouble((int)((state & 0x3c00000000L) >>> 34) /* extract-implicit-active 0:double */, leftNodeValue)) {
            double leftNodeValue_ = JSTypesGen.asImplicitDouble((int)((state & 0x3c00000000L) >>> 34) /* extract-implicit-active 0:double */, leftNodeValue);
            if (JSTypesGen.isImplicitDouble((int)((state & 0x3c000000000L) >>> 38) /* extract-implicit-active 1:double */, rightNodeValue)) {
                double rightNodeValue_ = JSTypesGen.asImplicitDouble((int)((state & 0x3c000000000L) >>> 38) /* extract-implicit-active 1:double */, rightNodeValue);
                return doDouble(leftNodeValue_, rightNodeValue_);
            }
        }
        if ((state & 0b100) != 0 /* is-active doBoolean(boolean, boolean) */ && leftNodeValue instanceof Boolean) {
            boolean leftNodeValue_ = (boolean) leftNodeValue;
            if (rightNodeValue instanceof Boolean) {
                boolean rightNodeValue_ = (boolean) rightNodeValue;
                return JSIdenticalNode.doBoolean(leftNodeValue_, rightNodeValue_);
            }
        }
        if ((state & 0b11000) != 0 /* is-active doBigInt(BigInt, BigInt) || doBigIntDouble(BigInt, double) */ && leftNodeValue instanceof BigInt) {
            BigInt leftNodeValue_ = (BigInt) leftNodeValue;
            if ((state & 0b1000) != 0 /* is-active doBigInt(BigInt, BigInt) */ && rightNodeValue instanceof BigInt) {
                BigInt rightNodeValue_ = (BigInt) rightNodeValue;
                return JSIdenticalNode.doBigInt(leftNodeValue_, rightNodeValue_);
            }
            if ((state & 0b10000) != 0 /* is-active doBigIntDouble(BigInt, double) */ && JSTypesGen.isImplicitDouble((int)((state & 0x3c000000000L) >>> 38) /* extract-implicit-active 1:double */, rightNodeValue)) {
                double rightNodeValue_ = JSTypesGen.asImplicitDouble((int)((state & 0x3c000000000L) >>> 38) /* extract-implicit-active 1:double */, rightNodeValue);
                return JSIdenticalNode.doBigIntDouble(leftNodeValue_, rightNodeValue_);
            }
        }
        if ((state & 0b100000) != 0 /* is-active doDoubleBigInt(double, BigInt) */ && JSTypesGen.isImplicitDouble((int)((state & 0x3c00000000L) >>> 34) /* extract-implicit-active 0:double */, leftNodeValue)) {
            double leftNodeValue_ = JSTypesGen.asImplicitDouble((int)((state & 0x3c00000000L) >>> 34) /* extract-implicit-active 0:double */, leftNodeValue);
            if (rightNodeValue instanceof BigInt) {
                BigInt rightNodeValue_ = (BigInt) rightNodeValue;
                return JSIdenticalNode.doDoubleBigInt(leftNodeValue_, rightNodeValue_);
            }
        }
        if ((state & 0b111000000) != 0 /* is-active doUndefinedA(Object, Object) || doUndefinedB(Object, Object) || doJSObjectA(DynamicObject, Object) */) {
            if ((state & 0b11000000) != 0 /* is-active doUndefinedA(Object, Object) || doUndefinedB(Object, Object) */) {
                if ((state & 0b1000000) != 0 /* is-active doUndefinedA(Object, Object) */) {
                    if ((JSGuards.isUndefined(leftNodeValue))) {
                        return JSIdenticalNode.doUndefinedA(leftNodeValue, rightNodeValue);
                    }
                }
                if ((state & 0b10000000) != 0 /* is-active doUndefinedB(Object, Object) */) {
                    if ((JSGuards.isUndefined(rightNodeValue))) {
                        return JSIdenticalNode.doUndefinedB(leftNodeValue, rightNodeValue);
                    }
                }
            }
            if ((state & 0b100000000) != 0 /* is-active doJSObjectA(DynamicObject, Object) */ && JSTypes.isDynamicObject(leftNodeValue)) {
                DynamicObject leftNodeValue_ = (DynamicObject) leftNodeValue;
                if ((JSGuards.isJSObject(leftNodeValue_))) {
                    return JSIdenticalNode.doJSObjectA(leftNodeValue_, rightNodeValue);
                }
            }
        }
        if ((state & 0x1fe00L) != 0 /* is-active doJSObjectB(Object, DynamicObject) || doNullNull(Object, Object) || doNullUndefined(Object, Object) || doUndefinedNull(Object, Object) || doNullA(Object, Object, InteropLibrary) || doNullA(Object, Object, InteropLibrary) || doNullB(Object, Object, InteropLibrary) || doNullB(Object, Object, InteropLibrary) */) {
            if ((state & 0b1000000000) != 0 /* is-active doJSObjectB(Object, DynamicObject) */ && JSTypes.isDynamicObject(rightNodeValue)) {
                DynamicObject rightNodeValue_ = (DynamicObject) rightNodeValue;
                if ((JSGuards.isJSObject(rightNodeValue_))) {
                    return JSIdenticalNode.doJSObjectB(leftNodeValue, rightNodeValue_);
                }
            }
            if ((state & 0x1fc00L) != 0 /* is-active doNullNull(Object, Object) || doNullUndefined(Object, Object) || doUndefinedNull(Object, Object) || doNullA(Object, Object, InteropLibrary) || doNullA(Object, Object, InteropLibrary) || doNullB(Object, Object, InteropLibrary) || doNullB(Object, Object, InteropLibrary) */) {
                if ((state & 0b10000000000) != 0 /* is-active doNullNull(Object, Object) */) {
                    if ((JSGuards.isJSNull(leftNodeValue)) && (JSGuards.isJSNull(rightNodeValue))) {
                        return JSIdenticalNode.doNullNull(leftNodeValue, rightNodeValue);
                    }
                }
                if ((state & 0b100000000000) != 0 /* is-active doNullUndefined(Object, Object) */) {
                    if ((JSGuards.isJSNull(leftNodeValue)) && (JSGuards.isUndefined(rightNodeValue))) {
                        return JSIdenticalNode.doNullUndefined(leftNodeValue, rightNodeValue);
                    }
                }
                if ((state & 0b1000000000000) != 0 /* is-active doUndefinedNull(Object, Object) */) {
                    if ((JSGuards.isUndefined(leftNodeValue)) && (JSGuards.isJSNull(rightNodeValue))) {
                        return JSIdenticalNode.doUndefinedNull(leftNodeValue, rightNodeValue);
                    }
                }
                if ((state & 0b10000000000000) != 0 /* is-active doNullA(Object, Object, InteropLibrary) */) {
                    NullA0Data s14_ = this.nullA0_cache;
                    while (s14_ != null) {
                        if ((s14_.bInterop_.accepts(rightNodeValue)) && (JSGuards.isJSNull(leftNodeValue)) && (!(JSGuards.isJSNull(rightNodeValue))) && (!(JSGuards.isUndefined(rightNodeValue)))) {
                            return JSIdenticalNode.doNullA(leftNodeValue, rightNodeValue, s14_.bInterop_);
                        }
                        s14_ = s14_.next_;
                    }
                }
                if ((state & 0b100000000000000) != 0 /* is-active doNullA(Object, Object, InteropLibrary) */) {
                    if ((JSGuards.isJSNull(leftNodeValue)) && (!(JSGuards.isJSNull(rightNodeValue))) && (!(JSGuards.isUndefined(rightNodeValue)))) {
                        return this.nullA1Boundary(state, leftNodeValue, rightNodeValue);
                    }
                }
                if ((state & 0b1000000000000000) != 0 /* is-active doNullB(Object, Object, InteropLibrary) */) {
                    NullB0Data s16_ = this.nullB0_cache;
                    while (s16_ != null) {
                        if ((s16_.aInterop_.accepts(leftNodeValue)) && (!(JSGuards.isJSNull(leftNodeValue))) && (!(JSGuards.isUndefined(leftNodeValue))) && (JSGuards.isJSNull(rightNodeValue))) {
                            return JSIdenticalNode.doNullB(leftNodeValue, rightNodeValue, s16_.aInterop_);
                        }
                        s16_ = s16_.next_;
                    }
                }
                if ((state & 0x10000L) != 0 /* is-active doNullB(Object, Object, InteropLibrary) */) {
                    if ((!(JSGuards.isJSNull(leftNodeValue))) && (!(JSGuards.isUndefined(leftNodeValue))) && (JSGuards.isJSNull(rightNodeValue))) {
                        return this.nullB1Boundary(state, leftNodeValue, rightNodeValue);
                    }
                }
            }
        }
        if ((state & 0xe0000L) != 0 /* is-active doLazyStringReference(JSLazyString, JSLazyString) || doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) || doStringLazyString(String, JSLazyString, ConditionProfile, ConditionProfile) */ && rightNodeValue instanceof JSLazyString) {
            JSLazyString rightNodeValue_ = (JSLazyString) rightNodeValue;
            if ((state & 0x60000L) != 0 /* is-active doLazyStringReference(JSLazyString, JSLazyString) || doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) */ && leftNodeValue instanceof JSLazyString) {
                JSLazyString leftNodeValue_ = (JSLazyString) leftNodeValue;
                if ((state & 0x20000L) != 0 /* is-active doLazyStringReference(JSLazyString, JSLazyString) */) {
                    if ((JSGuards.isReferenceEquals(leftNodeValue_, rightNodeValue_))) {
                        return JSIdenticalNode.doLazyStringReference(leftNodeValue_, rightNodeValue_);
                    }
                }
                if ((state & 0x40000L) != 0 /* is-active doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) */) {
                    return JSIdenticalNode.doLazyString(leftNodeValue_, rightNodeValue_, this.flattenA, this.flattenB, this.sameLen);
                }
            }
            if ((state & 0x80000L) != 0 /* is-active doStringLazyString(String, JSLazyString, ConditionProfile, ConditionProfile) */ && JSTypesGen.isImplicitString((int)((state & 0x3c0000000000L) >>> 42) /* extract-implicit-active 0:String */, leftNodeValue)) {
                String leftNodeValue_ = JSTypesGen.asImplicitString((int)((state & 0x3c0000000000L) >>> 42) /* extract-implicit-active 0:String */, leftNodeValue);
                return JSIdenticalNode.doStringLazyString(leftNodeValue_, rightNodeValue_, this.flattenB, this.sameLen);
            }
        }
        if ((state & 0x700000L) != 0 /* is-active doLazyStringString(JSLazyString, String, ConditionProfile, ConditionProfile) || doStringIdentity(String, String) || doString(String, String) */ && JSTypesGen.isImplicitString((int)((state & 0x3c00000000000L) >>> 46) /* extract-implicit-active 1:String */, rightNodeValue)) {
            String rightNodeValue_ = JSTypesGen.asImplicitString((int)((state & 0x3c00000000000L) >>> 46) /* extract-implicit-active 1:String */, rightNodeValue);
            if ((state & 0x100000L) != 0 /* is-active doLazyStringString(JSLazyString, String, ConditionProfile, ConditionProfile) */ && leftNodeValue instanceof JSLazyString) {
                JSLazyString leftNodeValue_ = (JSLazyString) leftNodeValue;
                return JSIdenticalNode.doLazyStringString(leftNodeValue_, rightNodeValue_, this.flattenA, this.sameLen);
            }
            if ((state & 0x600000L) != 0 /* is-active doStringIdentity(String, String) || doString(String, String) */ && JSTypesGen.isImplicitString((int)((state & 0x3c0000000000L) >>> 42) /* extract-implicit-active 0:String */, leftNodeValue)) {
                String leftNodeValue_ = JSTypesGen.asImplicitString((int)((state & 0x3c0000000000L) >>> 42) /* extract-implicit-active 0:String */, leftNodeValue);
                if ((state & 0x200000L) != 0 /* is-active doStringIdentity(String, String) */) {
                    if ((JSGuards.isReferenceEquals(leftNodeValue_, rightNodeValue_))) {
                        return JSIdenticalNode.doStringIdentity(leftNodeValue_, rightNodeValue_);
                    }
                }
                if ((state & 0x400000L) != 0 /* is-active doString(String, String) */) {
                    return JSIdenticalNode.doString(leftNodeValue_, rightNodeValue_);
                }
            }
        }
        if ((state & 0x800000L) != 0 /* is-active doSymbol(Symbol, Symbol) */ && leftNodeValue instanceof Symbol) {
            Symbol leftNodeValue_ = (Symbol) leftNodeValue;
            if (rightNodeValue instanceof Symbol) {
                Symbol rightNodeValue_ = (Symbol) rightNodeValue;
                return JSIdenticalNode.doSymbol(leftNodeValue_, rightNodeValue_);
            }
        }
        if ((state & 0x3f000000L) != 0 /* is-active doBooleanNotBoolean(Object, Object) || doSymbolNotSymbol(Object, Object) || doDifferentTypesCached(Object, Object, Class<>, Class<>) || doNumberNotNumber(Object, Object) || doStringNotString(Object, Object) || doNumberCached(Object, Object, Class<>, Class<>) */) {
            if ((state & 0x1000000L) != 0 /* is-active doBooleanNotBoolean(Object, Object) */) {
                if ((JSGuards.isBoolean(leftNodeValue) != JSGuards.isBoolean(rightNodeValue))) {
                    return JSIdenticalNode.doBooleanNotBoolean(leftNodeValue, rightNodeValue);
                }
            }
            if ((state & 0x2000000L) != 0 /* is-active doSymbolNotSymbol(Object, Object) */) {
                if ((JSGuards.isSymbol(leftNodeValue) != JSGuards.isSymbol(rightNodeValue))) {
                    return JSIdenticalNode.doSymbolNotSymbol(leftNodeValue, rightNodeValue);
                }
            }
            if ((state & 0x4000000L) != 0 /* is-active doDifferentTypesCached(Object, Object, Class<>, Class<>) */) {
                DifferentTypesCachedData s27_ = this.differentTypesCached_cache;
                while (s27_ != null) {
                    if ((leftNodeValue.getClass() == s27_.cachedClassA_) && (rightNodeValue.getClass() == s27_.cachedClassB_)) {
                        assert (JSIdenticalNode.isNonObjectType(s27_.cachedClassA_) || JSIdenticalNode.isNonObjectType(s27_.cachedClassB_));
                        assert (JSIdenticalNode.differentNonObjectTypes(s27_.cachedClassA_, s27_.cachedClassB_));
                        return JSIdenticalNode.doDifferentTypesCached(leftNodeValue, rightNodeValue, s27_.cachedClassA_, s27_.cachedClassB_);
                    }
                    s27_ = s27_.next_;
                }
            }
            if ((state & 0x8000000L) != 0 /* is-active doNumberNotNumber(Object, Object) */) {
                if ((JSRuntime.isJavaNumber(leftNodeValue) != JSRuntime.isJavaNumber(rightNodeValue))) {
                    return JSIdenticalNode.doNumberNotNumber(leftNodeValue, rightNodeValue);
                }
            }
            if ((state & 0x10000000L) != 0 /* is-active doStringNotString(Object, Object) */) {
                if ((JSRuntime.isString(leftNodeValue) != JSRuntime.isString(rightNodeValue))) {
                    return JSIdenticalNode.doStringNotString(leftNodeValue, rightNodeValue);
                }
            }
            if ((state & 0x20000000L) != 0 /* is-active doNumberCached(Object, Object, Class<>, Class<>) */) {
                NumberCachedData s30_ = this.numberCached_cache;
                while (s30_ != null) {
                    assert (s30_.cachedClassA_ != null);
                    assert (s30_.cachedClassB_ != null);
                    if ((leftNodeValue.getClass() == s30_.cachedClassA_) && (rightNodeValue.getClass() == s30_.cachedClassB_)) {
                        return doNumberCached(leftNodeValue, rightNodeValue, s30_.cachedClassA_, s30_.cachedClassB_);
                    }
                    s30_ = s30_.next_;
                }
            }
        }
        if ((state & 0x40000000L) != 0 /* is-active doNumber(Number, Number) */ && leftNodeValue instanceof Number) {
            Number leftNodeValue_ = (Number) leftNodeValue;
            if (rightNodeValue instanceof Number) {
                Number rightNodeValue_ = (Number) rightNodeValue;
                if ((JSRuntime.isJavaNumber(leftNodeValue_)) && (JSRuntime.isJavaNumber(rightNodeValue_))) {
                    return doNumber(leftNodeValue_, rightNodeValue_);
                }
            }
        }
        if ((state & 0x380000000L) != 0 /* is-active doForeignObject(Object, Object, InteropLibrary, InteropLibrary) || doForeignObject(Object, Object, InteropLibrary, InteropLibrary) || doFallback(Object, Object) */) {
            if ((state & 0x80000000L) != 0 /* is-active doForeignObject(Object, Object, InteropLibrary, InteropLibrary) */) {
                ForeignObject0Data s32_ = this.foreignObject0_cache;
                while (s32_ != null) {
                    if ((s32_.aInterop_.accepts(leftNodeValue)) && (s32_.bInterop_.accepts(rightNodeValue)) && (JSRuntime.isForeignObject(leftNodeValue)) && (JSRuntime.isForeignObject(rightNodeValue))) {
                        return JSIdenticalNode.doForeignObject(leftNodeValue, rightNodeValue, s32_.aInterop_, s32_.bInterop_);
                    }
                    s32_ = s32_.next_;
                }
            }
            if ((state & 0x100000000L) != 0 /* is-active doForeignObject(Object, Object, InteropLibrary, InteropLibrary) */) {
                if ((JSRuntime.isForeignObject(leftNodeValue)) && (JSRuntime.isForeignObject(rightNodeValue))) {
                    return this.foreignObject1Boundary(state, leftNodeValue, rightNodeValue);
                }
            }
            if ((state & 0x200000000L) != 0 /* is-active doFallback(Object, Object) */) {
                if (fallbackGuard_(state, leftNodeValue, rightNodeValue)) {
                    return JSIdenticalNode.doFallback(leftNodeValue, rightNodeValue);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(leftNodeValue, rightNodeValue);
    }

    @TruffleBoundary
    private boolean nullA1Boundary(long state, Object leftNodeValue, Object rightNodeValue) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary nullA1_bInterop__ = (INTEROP_LIBRARY_.getUncached(rightNodeValue));
                return JSIdenticalNode.doNullA(leftNodeValue, rightNodeValue, nullA1_bInterop__);
            }
        } finally {
            encapsulating_.set(prev_);
        }
    }

    @TruffleBoundary
    private boolean nullB1Boundary(long state, Object leftNodeValue, Object rightNodeValue) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary nullB1_aInterop__ = (INTEROP_LIBRARY_.getUncached(leftNodeValue));
                return JSIdenticalNode.doNullB(leftNodeValue, rightNodeValue, nullB1_aInterop__);
            }
        } finally {
            encapsulating_.set(prev_);
        }
    }

    @TruffleBoundary
    private boolean foreignObject1Boundary(long state, Object leftNodeValue, Object rightNodeValue) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary foreignObject1_aInterop__ = (INTEROP_LIBRARY_.getUncached(leftNodeValue));
                InteropLibrary foreignObject1_bInterop__ = (INTEROP_LIBRARY_.getUncached(rightNodeValue));
                return JSIdenticalNode.doForeignObject(leftNodeValue, rightNodeValue, foreignObject1_aInterop__, foreignObject1_bInterop__);
            }
        } finally {
            encapsulating_.set(prev_);
        }
    }

    @Override
    public boolean executeBoolean(VirtualFrame frameValue) {
        long state = state_;
        if ((state & 0x3fffffffeL) == 0 /* only-active doInt(int, int) */ && (state & 0x3ffffffffL) != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBoolean(boolean, boolean) && doBigInt(BigInt, BigInt) && doBigIntDouble(BigInt, double) && doDoubleBigInt(double, BigInt) && doUndefinedA(Object, Object) && doUndefinedB(Object, Object) && doJSObjectA(DynamicObject, Object) && doJSObjectB(Object, DynamicObject) && doNullNull(Object, Object) && doNullUndefined(Object, Object) && doUndefinedNull(Object, Object) && doNullA(Object, Object, InteropLibrary) && doNullA(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doLazyStringReference(JSLazyString, JSLazyString) && doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) && doStringLazyString(String, JSLazyString, ConditionProfile, ConditionProfile) && doLazyStringString(JSLazyString, String, ConditionProfile, ConditionProfile) && doStringIdentity(String, String) && doString(String, String) && doSymbol(Symbol, Symbol) && doBooleanNotBoolean(Object, Object) && doSymbolNotSymbol(Object, Object) && doDifferentTypesCached(Object, Object, Class<>, Class<>) && doNumberNotNumber(Object, Object) && doStringNotString(Object, Object) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doFallback(Object, Object) */) {
            return executeBoolean_int_int0(frameValue, state);
        } else if ((state & 0x3fffffffdL) == 0 /* only-active doDouble(double, double) */ && (state & 0x3ffffffffL) != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBoolean(boolean, boolean) && doBigInt(BigInt, BigInt) && doBigIntDouble(BigInt, double) && doDoubleBigInt(double, BigInt) && doUndefinedA(Object, Object) && doUndefinedB(Object, Object) && doJSObjectA(DynamicObject, Object) && doJSObjectB(Object, DynamicObject) && doNullNull(Object, Object) && doNullUndefined(Object, Object) && doUndefinedNull(Object, Object) && doNullA(Object, Object, InteropLibrary) && doNullA(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doLazyStringReference(JSLazyString, JSLazyString) && doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) && doStringLazyString(String, JSLazyString, ConditionProfile, ConditionProfile) && doLazyStringString(JSLazyString, String, ConditionProfile, ConditionProfile) && doStringIdentity(String, String) && doString(String, String) && doSymbol(Symbol, Symbol) && doBooleanNotBoolean(Object, Object) && doSymbolNotSymbol(Object, Object) && doDifferentTypesCached(Object, Object, Class<>, Class<>) && doNumberNotNumber(Object, Object) && doStringNotString(Object, Object) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doFallback(Object, Object) */) {
            return executeBoolean_double_double1(frameValue, state);
        } else if ((state & 0x3fffffffbL) == 0 /* only-active doBoolean(boolean, boolean) */ && (state & 0x3ffffffffL) != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBoolean(boolean, boolean) && doBigInt(BigInt, BigInt) && doBigIntDouble(BigInt, double) && doDoubleBigInt(double, BigInt) && doUndefinedA(Object, Object) && doUndefinedB(Object, Object) && doJSObjectA(DynamicObject, Object) && doJSObjectB(Object, DynamicObject) && doNullNull(Object, Object) && doNullUndefined(Object, Object) && doUndefinedNull(Object, Object) && doNullA(Object, Object, InteropLibrary) && doNullA(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doLazyStringReference(JSLazyString, JSLazyString) && doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) && doStringLazyString(String, JSLazyString, ConditionProfile, ConditionProfile) && doLazyStringString(JSLazyString, String, ConditionProfile, ConditionProfile) && doStringIdentity(String, String) && doString(String, String) && doSymbol(Symbol, Symbol) && doBooleanNotBoolean(Object, Object) && doSymbolNotSymbol(Object, Object) && doDifferentTypesCached(Object, Object, Class<>, Class<>) && doNumberNotNumber(Object, Object) && doStringNotString(Object, Object) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doFallback(Object, Object) */) {
            return executeBoolean_boolean_boolean2(frameValue, state);
        } else if ((state & 0x3ffffffefL) == 0 /* only-active doBigIntDouble(BigInt, double) */ && (state & 0x3ffffffffL) != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBoolean(boolean, boolean) && doBigInt(BigInt, BigInt) && doBigIntDouble(BigInt, double) && doDoubleBigInt(double, BigInt) && doUndefinedA(Object, Object) && doUndefinedB(Object, Object) && doJSObjectA(DynamicObject, Object) && doJSObjectB(Object, DynamicObject) && doNullNull(Object, Object) && doNullUndefined(Object, Object) && doUndefinedNull(Object, Object) && doNullA(Object, Object, InteropLibrary) && doNullA(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doLazyStringReference(JSLazyString, JSLazyString) && doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) && doStringLazyString(String, JSLazyString, ConditionProfile, ConditionProfile) && doLazyStringString(JSLazyString, String, ConditionProfile, ConditionProfile) && doStringIdentity(String, String) && doString(String, String) && doSymbol(Symbol, Symbol) && doBooleanNotBoolean(Object, Object) && doSymbolNotSymbol(Object, Object) && doDifferentTypesCached(Object, Object, Class<>, Class<>) && doNumberNotNumber(Object, Object) && doStringNotString(Object, Object) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doFallback(Object, Object) */) {
            return executeBoolean_double3(frameValue, state);
        } else if ((state & 0x3ffffffdfL) == 0 /* only-active doDoubleBigInt(double, BigInt) */ && (state & 0x3ffffffffL) != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBoolean(boolean, boolean) && doBigInt(BigInt, BigInt) && doBigIntDouble(BigInt, double) && doDoubleBigInt(double, BigInt) && doUndefinedA(Object, Object) && doUndefinedB(Object, Object) && doJSObjectA(DynamicObject, Object) && doJSObjectB(Object, DynamicObject) && doNullNull(Object, Object) && doNullUndefined(Object, Object) && doUndefinedNull(Object, Object) && doNullA(Object, Object, InteropLibrary) && doNullA(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doLazyStringReference(JSLazyString, JSLazyString) && doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) && doStringLazyString(String, JSLazyString, ConditionProfile, ConditionProfile) && doLazyStringString(JSLazyString, String, ConditionProfile, ConditionProfile) && doStringIdentity(String, String) && doString(String, String) && doSymbol(Symbol, Symbol) && doBooleanNotBoolean(Object, Object) && doSymbolNotSymbol(Object, Object) && doDifferentTypesCached(Object, Object, Class<>, Class<>) && doNumberNotNumber(Object, Object) && doStringNotString(Object, Object) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doFallback(Object, Object) */) {
            return executeBoolean_double4(frameValue, state);
        } else {
            return executeBoolean_generic5(frameValue, state);
        }
    }

    private boolean executeBoolean_int_int0(VirtualFrame frameValue, long state) {
        int leftNodeValue_;
        try {
            leftNodeValue_ = super.leftNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            Object rightNodeValue = super.rightNode.execute(frameValue);
            return executeAndSpecialize(ex.getResult(), rightNodeValue);
        }
        int rightNodeValue_;
        try {
            rightNodeValue_ = super.rightNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(leftNodeValue_, ex.getResult());
        }
        assert (state & 0b1) != 0 /* is-active doInt(int, int) */;
        return JSIdenticalNode.doInt(leftNodeValue_, rightNodeValue_);
    }

    private boolean executeBoolean_double_double1(VirtualFrame frameValue, long state) {
        int leftNodeValue_int = 0;
        long leftNodeValue_long = 0L;
        double leftNodeValue_;
        try {
            if ((state & 0x3800000000L) == 0 /* only-active 0:double */ && (state & 0x3ffffffffL) != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBoolean(boolean, boolean) && doBigInt(BigInt, BigInt) && doBigIntDouble(BigInt, double) && doDoubleBigInt(double, BigInt) && doUndefinedA(Object, Object) && doUndefinedB(Object, Object) && doJSObjectA(DynamicObject, Object) && doJSObjectB(Object, DynamicObject) && doNullNull(Object, Object) && doNullUndefined(Object, Object) && doUndefinedNull(Object, Object) && doNullA(Object, Object, InteropLibrary) && doNullA(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doLazyStringReference(JSLazyString, JSLazyString) && doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) && doStringLazyString(String, JSLazyString, ConditionProfile, ConditionProfile) && doLazyStringString(JSLazyString, String, ConditionProfile, ConditionProfile) && doStringIdentity(String, String) && doString(String, String) && doSymbol(Symbol, Symbol) && doBooleanNotBoolean(Object, Object) && doSymbolNotSymbol(Object, Object) && doDifferentTypesCached(Object, Object, Class<>, Class<>) && doNumberNotNumber(Object, Object) && doStringNotString(Object, Object) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doFallback(Object, Object) */) {
                leftNodeValue_long = super.leftNode.executeLong(frameValue);
                leftNodeValue_ = JSTypes.longToDouble(leftNodeValue_long);
            } else if ((state & 0x3400000000L) == 0 /* only-active 0:double */ && (state & 0x3ffffffffL) != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBoolean(boolean, boolean) && doBigInt(BigInt, BigInt) && doBigIntDouble(BigInt, double) && doDoubleBigInt(double, BigInt) && doUndefinedA(Object, Object) && doUndefinedB(Object, Object) && doJSObjectA(DynamicObject, Object) && doJSObjectB(Object, DynamicObject) && doNullNull(Object, Object) && doNullUndefined(Object, Object) && doUndefinedNull(Object, Object) && doNullA(Object, Object, InteropLibrary) && doNullA(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doLazyStringReference(JSLazyString, JSLazyString) && doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) && doStringLazyString(String, JSLazyString, ConditionProfile, ConditionProfile) && doLazyStringString(JSLazyString, String, ConditionProfile, ConditionProfile) && doStringIdentity(String, String) && doString(String, String) && doSymbol(Symbol, Symbol) && doBooleanNotBoolean(Object, Object) && doSymbolNotSymbol(Object, Object) && doDifferentTypesCached(Object, Object, Class<>, Class<>) && doNumberNotNumber(Object, Object) && doStringNotString(Object, Object) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doFallback(Object, Object) */) {
                leftNodeValue_int = super.leftNode.executeInt(frameValue);
                leftNodeValue_ = JSTypes.intToDouble(leftNodeValue_int);
            } else if ((state & 0x2c00000000L) == 0 /* only-active 0:double */ && (state & 0x3ffffffffL) != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBoolean(boolean, boolean) && doBigInt(BigInt, BigInt) && doBigIntDouble(BigInt, double) && doDoubleBigInt(double, BigInt) && doUndefinedA(Object, Object) && doUndefinedB(Object, Object) && doJSObjectA(DynamicObject, Object) && doJSObjectB(Object, DynamicObject) && doNullNull(Object, Object) && doNullUndefined(Object, Object) && doUndefinedNull(Object, Object) && doNullA(Object, Object, InteropLibrary) && doNullA(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doLazyStringReference(JSLazyString, JSLazyString) && doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) && doStringLazyString(String, JSLazyString, ConditionProfile, ConditionProfile) && doLazyStringString(JSLazyString, String, ConditionProfile, ConditionProfile) && doStringIdentity(String, String) && doString(String, String) && doSymbol(Symbol, Symbol) && doBooleanNotBoolean(Object, Object) && doSymbolNotSymbol(Object, Object) && doDifferentTypesCached(Object, Object, Class<>, Class<>) && doNumberNotNumber(Object, Object) && doStringNotString(Object, Object) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doFallback(Object, Object) */) {
                leftNodeValue_ = super.leftNode.executeDouble(frameValue);
            } else {
                Object leftNodeValue__ = super.leftNode.execute(frameValue);
                leftNodeValue_ = JSTypesGen.expectImplicitDouble((int)((state & 0x3c00000000L) >>> 34) /* extract-implicit-active 0:double */, leftNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            Object rightNodeValue = super.rightNode.execute(frameValue);
            return executeAndSpecialize(ex.getResult(), rightNodeValue);
        }
        int rightNodeValue_int = 0;
        long rightNodeValue_long = 0L;
        double rightNodeValue_;
        try {
            if ((state & 0x38000000000L) == 0 /* only-active 1:double */ && (state & 0x3ffffffffL) != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBoolean(boolean, boolean) && doBigInt(BigInt, BigInt) && doBigIntDouble(BigInt, double) && doDoubleBigInt(double, BigInt) && doUndefinedA(Object, Object) && doUndefinedB(Object, Object) && doJSObjectA(DynamicObject, Object) && doJSObjectB(Object, DynamicObject) && doNullNull(Object, Object) && doNullUndefined(Object, Object) && doUndefinedNull(Object, Object) && doNullA(Object, Object, InteropLibrary) && doNullA(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doLazyStringReference(JSLazyString, JSLazyString) && doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) && doStringLazyString(String, JSLazyString, ConditionProfile, ConditionProfile) && doLazyStringString(JSLazyString, String, ConditionProfile, ConditionProfile) && doStringIdentity(String, String) && doString(String, String) && doSymbol(Symbol, Symbol) && doBooleanNotBoolean(Object, Object) && doSymbolNotSymbol(Object, Object) && doDifferentTypesCached(Object, Object, Class<>, Class<>) && doNumberNotNumber(Object, Object) && doStringNotString(Object, Object) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doFallback(Object, Object) */) {
                rightNodeValue_long = super.rightNode.executeLong(frameValue);
                rightNodeValue_ = JSTypes.longToDouble(rightNodeValue_long);
            } else if ((state & 0x34000000000L) == 0 /* only-active 1:double */ && (state & 0x3ffffffffL) != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBoolean(boolean, boolean) && doBigInt(BigInt, BigInt) && doBigIntDouble(BigInt, double) && doDoubleBigInt(double, BigInt) && doUndefinedA(Object, Object) && doUndefinedB(Object, Object) && doJSObjectA(DynamicObject, Object) && doJSObjectB(Object, DynamicObject) && doNullNull(Object, Object) && doNullUndefined(Object, Object) && doUndefinedNull(Object, Object) && doNullA(Object, Object, InteropLibrary) && doNullA(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doLazyStringReference(JSLazyString, JSLazyString) && doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) && doStringLazyString(String, JSLazyString, ConditionProfile, ConditionProfile) && doLazyStringString(JSLazyString, String, ConditionProfile, ConditionProfile) && doStringIdentity(String, String) && doString(String, String) && doSymbol(Symbol, Symbol) && doBooleanNotBoolean(Object, Object) && doSymbolNotSymbol(Object, Object) && doDifferentTypesCached(Object, Object, Class<>, Class<>) && doNumberNotNumber(Object, Object) && doStringNotString(Object, Object) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doFallback(Object, Object) */) {
                rightNodeValue_int = super.rightNode.executeInt(frameValue);
                rightNodeValue_ = JSTypes.intToDouble(rightNodeValue_int);
            } else if ((state & 0x2c000000000L) == 0 /* only-active 1:double */ && (state & 0x3ffffffffL) != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBoolean(boolean, boolean) && doBigInt(BigInt, BigInt) && doBigIntDouble(BigInt, double) && doDoubleBigInt(double, BigInt) && doUndefinedA(Object, Object) && doUndefinedB(Object, Object) && doJSObjectA(DynamicObject, Object) && doJSObjectB(Object, DynamicObject) && doNullNull(Object, Object) && doNullUndefined(Object, Object) && doUndefinedNull(Object, Object) && doNullA(Object, Object, InteropLibrary) && doNullA(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doLazyStringReference(JSLazyString, JSLazyString) && doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) && doStringLazyString(String, JSLazyString, ConditionProfile, ConditionProfile) && doLazyStringString(JSLazyString, String, ConditionProfile, ConditionProfile) && doStringIdentity(String, String) && doString(String, String) && doSymbol(Symbol, Symbol) && doBooleanNotBoolean(Object, Object) && doSymbolNotSymbol(Object, Object) && doDifferentTypesCached(Object, Object, Class<>, Class<>) && doNumberNotNumber(Object, Object) && doStringNotString(Object, Object) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doFallback(Object, Object) */) {
                rightNodeValue_ = super.rightNode.executeDouble(frameValue);
            } else {
                Object rightNodeValue__ = super.rightNode.execute(frameValue);
                rightNodeValue_ = JSTypesGen.expectImplicitDouble((int)((state & 0x3c000000000L) >>> 38) /* extract-implicit-active 1:double */, rightNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(((state & 0x3800000000L) == 0 /* only-active 0:double */ && (state & 0x3ffffffffL) != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBoolean(boolean, boolean) && doBigInt(BigInt, BigInt) && doBigIntDouble(BigInt, double) && doDoubleBigInt(double, BigInt) && doUndefinedA(Object, Object) && doUndefinedB(Object, Object) && doJSObjectA(DynamicObject, Object) && doJSObjectB(Object, DynamicObject) && doNullNull(Object, Object) && doNullUndefined(Object, Object) && doUndefinedNull(Object, Object) && doNullA(Object, Object, InteropLibrary) && doNullA(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doLazyStringReference(JSLazyString, JSLazyString) && doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) && doStringLazyString(String, JSLazyString, ConditionProfile, ConditionProfile) && doLazyStringString(JSLazyString, String, ConditionProfile, ConditionProfile) && doStringIdentity(String, String) && doString(String, String) && doSymbol(Symbol, Symbol) && doBooleanNotBoolean(Object, Object) && doSymbolNotSymbol(Object, Object) && doDifferentTypesCached(Object, Object, Class<>, Class<>) && doNumberNotNumber(Object, Object) && doStringNotString(Object, Object) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doFallback(Object, Object) */ ? (Object) leftNodeValue_long : ((state & 0x3400000000L) == 0 /* only-active 0:double */ && (state & 0x3ffffffffL) != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBoolean(boolean, boolean) && doBigInt(BigInt, BigInt) && doBigIntDouble(BigInt, double) && doDoubleBigInt(double, BigInt) && doUndefinedA(Object, Object) && doUndefinedB(Object, Object) && doJSObjectA(DynamicObject, Object) && doJSObjectB(Object, DynamicObject) && doNullNull(Object, Object) && doNullUndefined(Object, Object) && doUndefinedNull(Object, Object) && doNullA(Object, Object, InteropLibrary) && doNullA(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doLazyStringReference(JSLazyString, JSLazyString) && doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) && doStringLazyString(String, JSLazyString, ConditionProfile, ConditionProfile) && doLazyStringString(JSLazyString, String, ConditionProfile, ConditionProfile) && doStringIdentity(String, String) && doString(String, String) && doSymbol(Symbol, Symbol) && doBooleanNotBoolean(Object, Object) && doSymbolNotSymbol(Object, Object) && doDifferentTypesCached(Object, Object, Class<>, Class<>) && doNumberNotNumber(Object, Object) && doStringNotString(Object, Object) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doFallback(Object, Object) */ ? (Object) leftNodeValue_int : (Object) leftNodeValue_)), ex.getResult());
        }
        assert (state & 0b10) != 0 /* is-active doDouble(double, double) */;
        return doDouble(leftNodeValue_, rightNodeValue_);
    }

    private boolean executeBoolean_boolean_boolean2(VirtualFrame frameValue, long state) {
        boolean leftNodeValue_;
        try {
            leftNodeValue_ = super.leftNode.executeBoolean(frameValue);
        } catch (UnexpectedResultException ex) {
            Object rightNodeValue = super.rightNode.execute(frameValue);
            return executeAndSpecialize(ex.getResult(), rightNodeValue);
        }
        boolean rightNodeValue_;
        try {
            rightNodeValue_ = super.rightNode.executeBoolean(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(leftNodeValue_, ex.getResult());
        }
        assert (state & 0b100) != 0 /* is-active doBoolean(boolean, boolean) */;
        return JSIdenticalNode.doBoolean(leftNodeValue_, rightNodeValue_);
    }

    private boolean executeBoolean_double3(VirtualFrame frameValue, long state) {
        Object leftNodeValue_ = super.leftNode.execute(frameValue);
        int rightNodeValue_int = 0;
        long rightNodeValue_long = 0L;
        double rightNodeValue_;
        try {
            if ((state & 0x38000000000L) == 0 /* only-active 1:double */ && (state & 0x3ffffffffL) != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBoolean(boolean, boolean) && doBigInt(BigInt, BigInt) && doBigIntDouble(BigInt, double) && doDoubleBigInt(double, BigInt) && doUndefinedA(Object, Object) && doUndefinedB(Object, Object) && doJSObjectA(DynamicObject, Object) && doJSObjectB(Object, DynamicObject) && doNullNull(Object, Object) && doNullUndefined(Object, Object) && doUndefinedNull(Object, Object) && doNullA(Object, Object, InteropLibrary) && doNullA(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doLazyStringReference(JSLazyString, JSLazyString) && doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) && doStringLazyString(String, JSLazyString, ConditionProfile, ConditionProfile) && doLazyStringString(JSLazyString, String, ConditionProfile, ConditionProfile) && doStringIdentity(String, String) && doString(String, String) && doSymbol(Symbol, Symbol) && doBooleanNotBoolean(Object, Object) && doSymbolNotSymbol(Object, Object) && doDifferentTypesCached(Object, Object, Class<>, Class<>) && doNumberNotNumber(Object, Object) && doStringNotString(Object, Object) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doFallback(Object, Object) */) {
                rightNodeValue_long = super.rightNode.executeLong(frameValue);
                rightNodeValue_ = JSTypes.longToDouble(rightNodeValue_long);
            } else if ((state & 0x34000000000L) == 0 /* only-active 1:double */ && (state & 0x3ffffffffL) != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBoolean(boolean, boolean) && doBigInt(BigInt, BigInt) && doBigIntDouble(BigInt, double) && doDoubleBigInt(double, BigInt) && doUndefinedA(Object, Object) && doUndefinedB(Object, Object) && doJSObjectA(DynamicObject, Object) && doJSObjectB(Object, DynamicObject) && doNullNull(Object, Object) && doNullUndefined(Object, Object) && doUndefinedNull(Object, Object) && doNullA(Object, Object, InteropLibrary) && doNullA(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doLazyStringReference(JSLazyString, JSLazyString) && doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) && doStringLazyString(String, JSLazyString, ConditionProfile, ConditionProfile) && doLazyStringString(JSLazyString, String, ConditionProfile, ConditionProfile) && doStringIdentity(String, String) && doString(String, String) && doSymbol(Symbol, Symbol) && doBooleanNotBoolean(Object, Object) && doSymbolNotSymbol(Object, Object) && doDifferentTypesCached(Object, Object, Class<>, Class<>) && doNumberNotNumber(Object, Object) && doStringNotString(Object, Object) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doFallback(Object, Object) */) {
                rightNodeValue_int = super.rightNode.executeInt(frameValue);
                rightNodeValue_ = JSTypes.intToDouble(rightNodeValue_int);
            } else if ((state & 0x2c000000000L) == 0 /* only-active 1:double */ && (state & 0x3ffffffffL) != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBoolean(boolean, boolean) && doBigInt(BigInt, BigInt) && doBigIntDouble(BigInt, double) && doDoubleBigInt(double, BigInt) && doUndefinedA(Object, Object) && doUndefinedB(Object, Object) && doJSObjectA(DynamicObject, Object) && doJSObjectB(Object, DynamicObject) && doNullNull(Object, Object) && doNullUndefined(Object, Object) && doUndefinedNull(Object, Object) && doNullA(Object, Object, InteropLibrary) && doNullA(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doLazyStringReference(JSLazyString, JSLazyString) && doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) && doStringLazyString(String, JSLazyString, ConditionProfile, ConditionProfile) && doLazyStringString(JSLazyString, String, ConditionProfile, ConditionProfile) && doStringIdentity(String, String) && doString(String, String) && doSymbol(Symbol, Symbol) && doBooleanNotBoolean(Object, Object) && doSymbolNotSymbol(Object, Object) && doDifferentTypesCached(Object, Object, Class<>, Class<>) && doNumberNotNumber(Object, Object) && doStringNotString(Object, Object) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doFallback(Object, Object) */) {
                rightNodeValue_ = super.rightNode.executeDouble(frameValue);
            } else {
                Object rightNodeValue__ = super.rightNode.execute(frameValue);
                rightNodeValue_ = JSTypesGen.expectImplicitDouble((int)((state & 0x3c000000000L) >>> 38) /* extract-implicit-active 1:double */, rightNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(leftNodeValue_, ex.getResult());
        }
        assert (state & 0b10000) != 0 /* is-active doBigIntDouble(BigInt, double) */;
        if (leftNodeValue_ instanceof BigInt) {
            BigInt leftNodeValue__ = (BigInt) leftNodeValue_;
            return JSIdenticalNode.doBigIntDouble(leftNodeValue__, rightNodeValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(leftNodeValue_, ((state & 0x38000000000L) == 0 /* only-active 1:double */ && (state & 0x3ffffffffL) != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBoolean(boolean, boolean) && doBigInt(BigInt, BigInt) && doBigIntDouble(BigInt, double) && doDoubleBigInt(double, BigInt) && doUndefinedA(Object, Object) && doUndefinedB(Object, Object) && doJSObjectA(DynamicObject, Object) && doJSObjectB(Object, DynamicObject) && doNullNull(Object, Object) && doNullUndefined(Object, Object) && doUndefinedNull(Object, Object) && doNullA(Object, Object, InteropLibrary) && doNullA(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doLazyStringReference(JSLazyString, JSLazyString) && doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) && doStringLazyString(String, JSLazyString, ConditionProfile, ConditionProfile) && doLazyStringString(JSLazyString, String, ConditionProfile, ConditionProfile) && doStringIdentity(String, String) && doString(String, String) && doSymbol(Symbol, Symbol) && doBooleanNotBoolean(Object, Object) && doSymbolNotSymbol(Object, Object) && doDifferentTypesCached(Object, Object, Class<>, Class<>) && doNumberNotNumber(Object, Object) && doStringNotString(Object, Object) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doFallback(Object, Object) */ ? (Object) rightNodeValue_long : ((state & 0x34000000000L) == 0 /* only-active 1:double */ && (state & 0x3ffffffffL) != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBoolean(boolean, boolean) && doBigInt(BigInt, BigInt) && doBigIntDouble(BigInt, double) && doDoubleBigInt(double, BigInt) && doUndefinedA(Object, Object) && doUndefinedB(Object, Object) && doJSObjectA(DynamicObject, Object) && doJSObjectB(Object, DynamicObject) && doNullNull(Object, Object) && doNullUndefined(Object, Object) && doUndefinedNull(Object, Object) && doNullA(Object, Object, InteropLibrary) && doNullA(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doLazyStringReference(JSLazyString, JSLazyString) && doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) && doStringLazyString(String, JSLazyString, ConditionProfile, ConditionProfile) && doLazyStringString(JSLazyString, String, ConditionProfile, ConditionProfile) && doStringIdentity(String, String) && doString(String, String) && doSymbol(Symbol, Symbol) && doBooleanNotBoolean(Object, Object) && doSymbolNotSymbol(Object, Object) && doDifferentTypesCached(Object, Object, Class<>, Class<>) && doNumberNotNumber(Object, Object) && doStringNotString(Object, Object) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doFallback(Object, Object) */ ? (Object) rightNodeValue_int : (Object) rightNodeValue_)));
    }

    private boolean executeBoolean_double4(VirtualFrame frameValue, long state) {
        int leftNodeValue_int = 0;
        long leftNodeValue_long = 0L;
        double leftNodeValue_;
        try {
            if ((state & 0x3800000000L) == 0 /* only-active 0:double */ && (state & 0x3ffffffffL) != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBoolean(boolean, boolean) && doBigInt(BigInt, BigInt) && doBigIntDouble(BigInt, double) && doDoubleBigInt(double, BigInt) && doUndefinedA(Object, Object) && doUndefinedB(Object, Object) && doJSObjectA(DynamicObject, Object) && doJSObjectB(Object, DynamicObject) && doNullNull(Object, Object) && doNullUndefined(Object, Object) && doUndefinedNull(Object, Object) && doNullA(Object, Object, InteropLibrary) && doNullA(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doLazyStringReference(JSLazyString, JSLazyString) && doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) && doStringLazyString(String, JSLazyString, ConditionProfile, ConditionProfile) && doLazyStringString(JSLazyString, String, ConditionProfile, ConditionProfile) && doStringIdentity(String, String) && doString(String, String) && doSymbol(Symbol, Symbol) && doBooleanNotBoolean(Object, Object) && doSymbolNotSymbol(Object, Object) && doDifferentTypesCached(Object, Object, Class<>, Class<>) && doNumberNotNumber(Object, Object) && doStringNotString(Object, Object) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doFallback(Object, Object) */) {
                leftNodeValue_long = super.leftNode.executeLong(frameValue);
                leftNodeValue_ = JSTypes.longToDouble(leftNodeValue_long);
            } else if ((state & 0x3400000000L) == 0 /* only-active 0:double */ && (state & 0x3ffffffffL) != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBoolean(boolean, boolean) && doBigInt(BigInt, BigInt) && doBigIntDouble(BigInt, double) && doDoubleBigInt(double, BigInt) && doUndefinedA(Object, Object) && doUndefinedB(Object, Object) && doJSObjectA(DynamicObject, Object) && doJSObjectB(Object, DynamicObject) && doNullNull(Object, Object) && doNullUndefined(Object, Object) && doUndefinedNull(Object, Object) && doNullA(Object, Object, InteropLibrary) && doNullA(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doLazyStringReference(JSLazyString, JSLazyString) && doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) && doStringLazyString(String, JSLazyString, ConditionProfile, ConditionProfile) && doLazyStringString(JSLazyString, String, ConditionProfile, ConditionProfile) && doStringIdentity(String, String) && doString(String, String) && doSymbol(Symbol, Symbol) && doBooleanNotBoolean(Object, Object) && doSymbolNotSymbol(Object, Object) && doDifferentTypesCached(Object, Object, Class<>, Class<>) && doNumberNotNumber(Object, Object) && doStringNotString(Object, Object) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doFallback(Object, Object) */) {
                leftNodeValue_int = super.leftNode.executeInt(frameValue);
                leftNodeValue_ = JSTypes.intToDouble(leftNodeValue_int);
            } else if ((state & 0x2c00000000L) == 0 /* only-active 0:double */ && (state & 0x3ffffffffL) != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBoolean(boolean, boolean) && doBigInt(BigInt, BigInt) && doBigIntDouble(BigInt, double) && doDoubleBigInt(double, BigInt) && doUndefinedA(Object, Object) && doUndefinedB(Object, Object) && doJSObjectA(DynamicObject, Object) && doJSObjectB(Object, DynamicObject) && doNullNull(Object, Object) && doNullUndefined(Object, Object) && doUndefinedNull(Object, Object) && doNullA(Object, Object, InteropLibrary) && doNullA(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doLazyStringReference(JSLazyString, JSLazyString) && doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) && doStringLazyString(String, JSLazyString, ConditionProfile, ConditionProfile) && doLazyStringString(JSLazyString, String, ConditionProfile, ConditionProfile) && doStringIdentity(String, String) && doString(String, String) && doSymbol(Symbol, Symbol) && doBooleanNotBoolean(Object, Object) && doSymbolNotSymbol(Object, Object) && doDifferentTypesCached(Object, Object, Class<>, Class<>) && doNumberNotNumber(Object, Object) && doStringNotString(Object, Object) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doFallback(Object, Object) */) {
                leftNodeValue_ = super.leftNode.executeDouble(frameValue);
            } else {
                Object leftNodeValue__ = super.leftNode.execute(frameValue);
                leftNodeValue_ = JSTypesGen.expectImplicitDouble((int)((state & 0x3c00000000L) >>> 34) /* extract-implicit-active 0:double */, leftNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            Object rightNodeValue = super.rightNode.execute(frameValue);
            return executeAndSpecialize(ex.getResult(), rightNodeValue);
        }
        Object rightNodeValue_ = super.rightNode.execute(frameValue);
        assert (state & 0b100000) != 0 /* is-active doDoubleBigInt(double, BigInt) */;
        if (rightNodeValue_ instanceof BigInt) {
            BigInt rightNodeValue__ = (BigInt) rightNodeValue_;
            return JSIdenticalNode.doDoubleBigInt(leftNodeValue_, rightNodeValue__);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(((state & 0x3800000000L) == 0 /* only-active 0:double */ && (state & 0x3ffffffffL) != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBoolean(boolean, boolean) && doBigInt(BigInt, BigInt) && doBigIntDouble(BigInt, double) && doDoubleBigInt(double, BigInt) && doUndefinedA(Object, Object) && doUndefinedB(Object, Object) && doJSObjectA(DynamicObject, Object) && doJSObjectB(Object, DynamicObject) && doNullNull(Object, Object) && doNullUndefined(Object, Object) && doUndefinedNull(Object, Object) && doNullA(Object, Object, InteropLibrary) && doNullA(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doLazyStringReference(JSLazyString, JSLazyString) && doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) && doStringLazyString(String, JSLazyString, ConditionProfile, ConditionProfile) && doLazyStringString(JSLazyString, String, ConditionProfile, ConditionProfile) && doStringIdentity(String, String) && doString(String, String) && doSymbol(Symbol, Symbol) && doBooleanNotBoolean(Object, Object) && doSymbolNotSymbol(Object, Object) && doDifferentTypesCached(Object, Object, Class<>, Class<>) && doNumberNotNumber(Object, Object) && doStringNotString(Object, Object) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doFallback(Object, Object) */ ? (Object) leftNodeValue_long : ((state & 0x3400000000L) == 0 /* only-active 0:double */ && (state & 0x3ffffffffL) != 0  /* is-not doInt(int, int) && doDouble(double, double) && doBoolean(boolean, boolean) && doBigInt(BigInt, BigInt) && doBigIntDouble(BigInt, double) && doDoubleBigInt(double, BigInt) && doUndefinedA(Object, Object) && doUndefinedB(Object, Object) && doJSObjectA(DynamicObject, Object) && doJSObjectB(Object, DynamicObject) && doNullNull(Object, Object) && doNullUndefined(Object, Object) && doUndefinedNull(Object, Object) && doNullA(Object, Object, InteropLibrary) && doNullA(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doNullB(Object, Object, InteropLibrary) && doLazyStringReference(JSLazyString, JSLazyString) && doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) && doStringLazyString(String, JSLazyString, ConditionProfile, ConditionProfile) && doLazyStringString(JSLazyString, String, ConditionProfile, ConditionProfile) && doStringIdentity(String, String) && doString(String, String) && doSymbol(Symbol, Symbol) && doBooleanNotBoolean(Object, Object) && doSymbolNotSymbol(Object, Object) && doDifferentTypesCached(Object, Object, Class<>, Class<>) && doNumberNotNumber(Object, Object) && doStringNotString(Object, Object) && doNumberCached(Object, Object, Class<>, Class<>) && doNumber(Number, Number) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doForeignObject(Object, Object, InteropLibrary, InteropLibrary) && doFallback(Object, Object) */ ? (Object) leftNodeValue_int : (Object) leftNodeValue_)), rightNodeValue_);
    }

    @TruffleBoundary
    private boolean nullA1Boundary0(long state, Object leftNodeValue_, Object rightNodeValue_) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary nullA1_bInterop__ = (INTEROP_LIBRARY_.getUncached(rightNodeValue_));
                return JSIdenticalNode.doNullA(leftNodeValue_, rightNodeValue_, nullA1_bInterop__);
            }
        } finally {
            encapsulating_.set(prev_);
        }
    }

    @TruffleBoundary
    private boolean nullB1Boundary1(long state, Object leftNodeValue_, Object rightNodeValue_) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary nullB1_aInterop__ = (INTEROP_LIBRARY_.getUncached(leftNodeValue_));
                return JSIdenticalNode.doNullB(leftNodeValue_, rightNodeValue_, nullB1_aInterop__);
            }
        } finally {
            encapsulating_.set(prev_);
        }
    }

    @TruffleBoundary
    private boolean foreignObject1Boundary2(long state, Object leftNodeValue_, Object rightNodeValue_) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary foreignObject1_aInterop__ = (INTEROP_LIBRARY_.getUncached(leftNodeValue_));
                InteropLibrary foreignObject1_bInterop__ = (INTEROP_LIBRARY_.getUncached(rightNodeValue_));
                return JSIdenticalNode.doForeignObject(leftNodeValue_, rightNodeValue_, foreignObject1_aInterop__, foreignObject1_bInterop__);
            }
        } finally {
            encapsulating_.set(prev_);
        }
    }

    @ExplodeLoop
    private boolean executeBoolean_generic5(VirtualFrame frameValue, long state) {
        Object leftNodeValue_ = super.leftNode.execute(frameValue);
        Object rightNodeValue_ = super.rightNode.execute(frameValue);
        if ((state & 0b1) != 0 /* is-active doInt(int, int) */ && leftNodeValue_ instanceof Integer) {
            int leftNodeValue__ = (int) leftNodeValue_;
            if (rightNodeValue_ instanceof Integer) {
                int rightNodeValue__ = (int) rightNodeValue_;
                return JSIdenticalNode.doInt(leftNodeValue__, rightNodeValue__);
            }
        }
        if ((state & 0b10) != 0 /* is-active doDouble(double, double) */ && JSTypesGen.isImplicitDouble((int)((state & 0x3c00000000L) >>> 34) /* extract-implicit-active 0:double */, leftNodeValue_)) {
            double leftNodeValue__ = JSTypesGen.asImplicitDouble((int)((state & 0x3c00000000L) >>> 34) /* extract-implicit-active 0:double */, leftNodeValue_);
            if (JSTypesGen.isImplicitDouble((int)((state & 0x3c000000000L) >>> 38) /* extract-implicit-active 1:double */, rightNodeValue_)) {
                double rightNodeValue__ = JSTypesGen.asImplicitDouble((int)((state & 0x3c000000000L) >>> 38) /* extract-implicit-active 1:double */, rightNodeValue_);
                return doDouble(leftNodeValue__, rightNodeValue__);
            }
        }
        if ((state & 0b100) != 0 /* is-active doBoolean(boolean, boolean) */ && leftNodeValue_ instanceof Boolean) {
            boolean leftNodeValue__ = (boolean) leftNodeValue_;
            if (rightNodeValue_ instanceof Boolean) {
                boolean rightNodeValue__ = (boolean) rightNodeValue_;
                return JSIdenticalNode.doBoolean(leftNodeValue__, rightNodeValue__);
            }
        }
        if ((state & 0b11000) != 0 /* is-active doBigInt(BigInt, BigInt) || doBigIntDouble(BigInt, double) */ && leftNodeValue_ instanceof BigInt) {
            BigInt leftNodeValue__ = (BigInt) leftNodeValue_;
            if ((state & 0b1000) != 0 /* is-active doBigInt(BigInt, BigInt) */ && rightNodeValue_ instanceof BigInt) {
                BigInt rightNodeValue__ = (BigInt) rightNodeValue_;
                return JSIdenticalNode.doBigInt(leftNodeValue__, rightNodeValue__);
            }
            if ((state & 0b10000) != 0 /* is-active doBigIntDouble(BigInt, double) */ && JSTypesGen.isImplicitDouble((int)((state & 0x3c000000000L) >>> 38) /* extract-implicit-active 1:double */, rightNodeValue_)) {
                double rightNodeValue__ = JSTypesGen.asImplicitDouble((int)((state & 0x3c000000000L) >>> 38) /* extract-implicit-active 1:double */, rightNodeValue_);
                return JSIdenticalNode.doBigIntDouble(leftNodeValue__, rightNodeValue__);
            }
        }
        if ((state & 0b100000) != 0 /* is-active doDoubleBigInt(double, BigInt) */ && JSTypesGen.isImplicitDouble((int)((state & 0x3c00000000L) >>> 34) /* extract-implicit-active 0:double */, leftNodeValue_)) {
            double leftNodeValue__ = JSTypesGen.asImplicitDouble((int)((state & 0x3c00000000L) >>> 34) /* extract-implicit-active 0:double */, leftNodeValue_);
            if (rightNodeValue_ instanceof BigInt) {
                BigInt rightNodeValue__ = (BigInt) rightNodeValue_;
                return JSIdenticalNode.doDoubleBigInt(leftNodeValue__, rightNodeValue__);
            }
        }
        if ((state & 0b111000000) != 0 /* is-active doUndefinedA(Object, Object) || doUndefinedB(Object, Object) || doJSObjectA(DynamicObject, Object) */) {
            if ((state & 0b11000000) != 0 /* is-active doUndefinedA(Object, Object) || doUndefinedB(Object, Object) */) {
                if ((state & 0b1000000) != 0 /* is-active doUndefinedA(Object, Object) */) {
                    if ((JSGuards.isUndefined(leftNodeValue_))) {
                        return JSIdenticalNode.doUndefinedA(leftNodeValue_, rightNodeValue_);
                    }
                }
                if ((state & 0b10000000) != 0 /* is-active doUndefinedB(Object, Object) */) {
                    if ((JSGuards.isUndefined(rightNodeValue_))) {
                        return JSIdenticalNode.doUndefinedB(leftNodeValue_, rightNodeValue_);
                    }
                }
            }
            if ((state & 0b100000000) != 0 /* is-active doJSObjectA(DynamicObject, Object) */ && JSTypes.isDynamicObject(leftNodeValue_)) {
                DynamicObject leftNodeValue__ = (DynamicObject) leftNodeValue_;
                if ((JSGuards.isJSObject(leftNodeValue__))) {
                    return JSIdenticalNode.doJSObjectA(leftNodeValue__, rightNodeValue_);
                }
            }
        }
        if ((state & 0x1fe00L) != 0 /* is-active doJSObjectB(Object, DynamicObject) || doNullNull(Object, Object) || doNullUndefined(Object, Object) || doUndefinedNull(Object, Object) || doNullA(Object, Object, InteropLibrary) || doNullA(Object, Object, InteropLibrary) || doNullB(Object, Object, InteropLibrary) || doNullB(Object, Object, InteropLibrary) */) {
            if ((state & 0b1000000000) != 0 /* is-active doJSObjectB(Object, DynamicObject) */ && JSTypes.isDynamicObject(rightNodeValue_)) {
                DynamicObject rightNodeValue__ = (DynamicObject) rightNodeValue_;
                if ((JSGuards.isJSObject(rightNodeValue__))) {
                    return JSIdenticalNode.doJSObjectB(leftNodeValue_, rightNodeValue__);
                }
            }
            if ((state & 0x1fc00L) != 0 /* is-active doNullNull(Object, Object) || doNullUndefined(Object, Object) || doUndefinedNull(Object, Object) || doNullA(Object, Object, InteropLibrary) || doNullA(Object, Object, InteropLibrary) || doNullB(Object, Object, InteropLibrary) || doNullB(Object, Object, InteropLibrary) */) {
                if ((state & 0b10000000000) != 0 /* is-active doNullNull(Object, Object) */) {
                    if ((JSGuards.isJSNull(leftNodeValue_)) && (JSGuards.isJSNull(rightNodeValue_))) {
                        return JSIdenticalNode.doNullNull(leftNodeValue_, rightNodeValue_);
                    }
                }
                if ((state & 0b100000000000) != 0 /* is-active doNullUndefined(Object, Object) */) {
                    if ((JSGuards.isJSNull(leftNodeValue_)) && (JSGuards.isUndefined(rightNodeValue_))) {
                        return JSIdenticalNode.doNullUndefined(leftNodeValue_, rightNodeValue_);
                    }
                }
                if ((state & 0b1000000000000) != 0 /* is-active doUndefinedNull(Object, Object) */) {
                    if ((JSGuards.isUndefined(leftNodeValue_)) && (JSGuards.isJSNull(rightNodeValue_))) {
                        return JSIdenticalNode.doUndefinedNull(leftNodeValue_, rightNodeValue_);
                    }
                }
                if ((state & 0b10000000000000) != 0 /* is-active doNullA(Object, Object, InteropLibrary) */) {
                    NullA0Data s14_ = this.nullA0_cache;
                    while (s14_ != null) {
                        if ((s14_.bInterop_.accepts(rightNodeValue_)) && (JSGuards.isJSNull(leftNodeValue_)) && (!(JSGuards.isJSNull(rightNodeValue_))) && (!(JSGuards.isUndefined(rightNodeValue_)))) {
                            return JSIdenticalNode.doNullA(leftNodeValue_, rightNodeValue_, s14_.bInterop_);
                        }
                        s14_ = s14_.next_;
                    }
                }
                if ((state & 0b100000000000000) != 0 /* is-active doNullA(Object, Object, InteropLibrary) */) {
                    if ((JSGuards.isJSNull(leftNodeValue_)) && (!(JSGuards.isJSNull(rightNodeValue_))) && (!(JSGuards.isUndefined(rightNodeValue_)))) {
                        return this.nullA1Boundary0(state, leftNodeValue_, rightNodeValue_);
                    }
                }
                if ((state & 0b1000000000000000) != 0 /* is-active doNullB(Object, Object, InteropLibrary) */) {
                    NullB0Data s16_ = this.nullB0_cache;
                    while (s16_ != null) {
                        if ((s16_.aInterop_.accepts(leftNodeValue_)) && (!(JSGuards.isJSNull(leftNodeValue_))) && (!(JSGuards.isUndefined(leftNodeValue_))) && (JSGuards.isJSNull(rightNodeValue_))) {
                            return JSIdenticalNode.doNullB(leftNodeValue_, rightNodeValue_, s16_.aInterop_);
                        }
                        s16_ = s16_.next_;
                    }
                }
                if ((state & 0x10000L) != 0 /* is-active doNullB(Object, Object, InteropLibrary) */) {
                    if ((!(JSGuards.isJSNull(leftNodeValue_))) && (!(JSGuards.isUndefined(leftNodeValue_))) && (JSGuards.isJSNull(rightNodeValue_))) {
                        return this.nullB1Boundary1(state, leftNodeValue_, rightNodeValue_);
                    }
                }
            }
        }
        if ((state & 0xe0000L) != 0 /* is-active doLazyStringReference(JSLazyString, JSLazyString) || doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) || doStringLazyString(String, JSLazyString, ConditionProfile, ConditionProfile) */ && rightNodeValue_ instanceof JSLazyString) {
            JSLazyString rightNodeValue__ = (JSLazyString) rightNodeValue_;
            if ((state & 0x60000L) != 0 /* is-active doLazyStringReference(JSLazyString, JSLazyString) || doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) */ && leftNodeValue_ instanceof JSLazyString) {
                JSLazyString leftNodeValue__ = (JSLazyString) leftNodeValue_;
                if ((state & 0x20000L) != 0 /* is-active doLazyStringReference(JSLazyString, JSLazyString) */) {
                    if ((JSGuards.isReferenceEquals(leftNodeValue__, rightNodeValue__))) {
                        return JSIdenticalNode.doLazyStringReference(leftNodeValue__, rightNodeValue__);
                    }
                }
                if ((state & 0x40000L) != 0 /* is-active doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) */) {
                    return JSIdenticalNode.doLazyString(leftNodeValue__, rightNodeValue__, this.flattenA, this.flattenB, this.sameLen);
                }
            }
            if ((state & 0x80000L) != 0 /* is-active doStringLazyString(String, JSLazyString, ConditionProfile, ConditionProfile) */ && JSTypesGen.isImplicitString((int)((state & 0x3c0000000000L) >>> 42) /* extract-implicit-active 0:String */, leftNodeValue_)) {
                String leftNodeValue__ = JSTypesGen.asImplicitString((int)((state & 0x3c0000000000L) >>> 42) /* extract-implicit-active 0:String */, leftNodeValue_);
                return JSIdenticalNode.doStringLazyString(leftNodeValue__, rightNodeValue__, this.flattenB, this.sameLen);
            }
        }
        if ((state & 0x700000L) != 0 /* is-active doLazyStringString(JSLazyString, String, ConditionProfile, ConditionProfile) || doStringIdentity(String, String) || doString(String, String) */ && JSTypesGen.isImplicitString((int)((state & 0x3c00000000000L) >>> 46) /* extract-implicit-active 1:String */, rightNodeValue_)) {
            String rightNodeValue__ = JSTypesGen.asImplicitString((int)((state & 0x3c00000000000L) >>> 46) /* extract-implicit-active 1:String */, rightNodeValue_);
            if ((state & 0x100000L) != 0 /* is-active doLazyStringString(JSLazyString, String, ConditionProfile, ConditionProfile) */ && leftNodeValue_ instanceof JSLazyString) {
                JSLazyString leftNodeValue__ = (JSLazyString) leftNodeValue_;
                return JSIdenticalNode.doLazyStringString(leftNodeValue__, rightNodeValue__, this.flattenA, this.sameLen);
            }
            if ((state & 0x600000L) != 0 /* is-active doStringIdentity(String, String) || doString(String, String) */ && JSTypesGen.isImplicitString((int)((state & 0x3c0000000000L) >>> 42) /* extract-implicit-active 0:String */, leftNodeValue_)) {
                String leftNodeValue__ = JSTypesGen.asImplicitString((int)((state & 0x3c0000000000L) >>> 42) /* extract-implicit-active 0:String */, leftNodeValue_);
                if ((state & 0x200000L) != 0 /* is-active doStringIdentity(String, String) */) {
                    if ((JSGuards.isReferenceEquals(leftNodeValue__, rightNodeValue__))) {
                        return JSIdenticalNode.doStringIdentity(leftNodeValue__, rightNodeValue__);
                    }
                }
                if ((state & 0x400000L) != 0 /* is-active doString(String, String) */) {
                    return JSIdenticalNode.doString(leftNodeValue__, rightNodeValue__);
                }
            }
        }
        if ((state & 0x800000L) != 0 /* is-active doSymbol(Symbol, Symbol) */ && leftNodeValue_ instanceof Symbol) {
            Symbol leftNodeValue__ = (Symbol) leftNodeValue_;
            if (rightNodeValue_ instanceof Symbol) {
                Symbol rightNodeValue__ = (Symbol) rightNodeValue_;
                return JSIdenticalNode.doSymbol(leftNodeValue__, rightNodeValue__);
            }
        }
        if ((state & 0x3f000000L) != 0 /* is-active doBooleanNotBoolean(Object, Object) || doSymbolNotSymbol(Object, Object) || doDifferentTypesCached(Object, Object, Class<>, Class<>) || doNumberNotNumber(Object, Object) || doStringNotString(Object, Object) || doNumberCached(Object, Object, Class<>, Class<>) */) {
            if ((state & 0x1000000L) != 0 /* is-active doBooleanNotBoolean(Object, Object) */) {
                if ((JSGuards.isBoolean(leftNodeValue_) != JSGuards.isBoolean(rightNodeValue_))) {
                    return JSIdenticalNode.doBooleanNotBoolean(leftNodeValue_, rightNodeValue_);
                }
            }
            if ((state & 0x2000000L) != 0 /* is-active doSymbolNotSymbol(Object, Object) */) {
                if ((JSGuards.isSymbol(leftNodeValue_) != JSGuards.isSymbol(rightNodeValue_))) {
                    return JSIdenticalNode.doSymbolNotSymbol(leftNodeValue_, rightNodeValue_);
                }
            }
            if ((state & 0x4000000L) != 0 /* is-active doDifferentTypesCached(Object, Object, Class<>, Class<>) */) {
                DifferentTypesCachedData s27_ = this.differentTypesCached_cache;
                while (s27_ != null) {
                    if ((leftNodeValue_.getClass() == s27_.cachedClassA_) && (rightNodeValue_.getClass() == s27_.cachedClassB_)) {
                        assert (JSIdenticalNode.isNonObjectType(s27_.cachedClassA_) || JSIdenticalNode.isNonObjectType(s27_.cachedClassB_));
                        assert (JSIdenticalNode.differentNonObjectTypes(s27_.cachedClassA_, s27_.cachedClassB_));
                        return JSIdenticalNode.doDifferentTypesCached(leftNodeValue_, rightNodeValue_, s27_.cachedClassA_, s27_.cachedClassB_);
                    }
                    s27_ = s27_.next_;
                }
            }
            if ((state & 0x8000000L) != 0 /* is-active doNumberNotNumber(Object, Object) */) {
                if ((JSRuntime.isJavaNumber(leftNodeValue_) != JSRuntime.isJavaNumber(rightNodeValue_))) {
                    return JSIdenticalNode.doNumberNotNumber(leftNodeValue_, rightNodeValue_);
                }
            }
            if ((state & 0x10000000L) != 0 /* is-active doStringNotString(Object, Object) */) {
                if ((JSRuntime.isString(leftNodeValue_) != JSRuntime.isString(rightNodeValue_))) {
                    return JSIdenticalNode.doStringNotString(leftNodeValue_, rightNodeValue_);
                }
            }
            if ((state & 0x20000000L) != 0 /* is-active doNumberCached(Object, Object, Class<>, Class<>) */) {
                NumberCachedData s30_ = this.numberCached_cache;
                while (s30_ != null) {
                    assert (s30_.cachedClassA_ != null);
                    assert (s30_.cachedClassB_ != null);
                    if ((leftNodeValue_.getClass() == s30_.cachedClassA_) && (rightNodeValue_.getClass() == s30_.cachedClassB_)) {
                        return doNumberCached(leftNodeValue_, rightNodeValue_, s30_.cachedClassA_, s30_.cachedClassB_);
                    }
                    s30_ = s30_.next_;
                }
            }
        }
        if ((state & 0x40000000L) != 0 /* is-active doNumber(Number, Number) */ && leftNodeValue_ instanceof Number) {
            Number leftNodeValue__ = (Number) leftNodeValue_;
            if (rightNodeValue_ instanceof Number) {
                Number rightNodeValue__ = (Number) rightNodeValue_;
                if ((JSRuntime.isJavaNumber(leftNodeValue__)) && (JSRuntime.isJavaNumber(rightNodeValue__))) {
                    return doNumber(leftNodeValue__, rightNodeValue__);
                }
            }
        }
        if ((state & 0x380000000L) != 0 /* is-active doForeignObject(Object, Object, InteropLibrary, InteropLibrary) || doForeignObject(Object, Object, InteropLibrary, InteropLibrary) || doFallback(Object, Object) */) {
            if ((state & 0x80000000L) != 0 /* is-active doForeignObject(Object, Object, InteropLibrary, InteropLibrary) */) {
                ForeignObject0Data s32_ = this.foreignObject0_cache;
                while (s32_ != null) {
                    if ((s32_.aInterop_.accepts(leftNodeValue_)) && (s32_.bInterop_.accepts(rightNodeValue_)) && (JSRuntime.isForeignObject(leftNodeValue_)) && (JSRuntime.isForeignObject(rightNodeValue_))) {
                        return JSIdenticalNode.doForeignObject(leftNodeValue_, rightNodeValue_, s32_.aInterop_, s32_.bInterop_);
                    }
                    s32_ = s32_.next_;
                }
            }
            if ((state & 0x100000000L) != 0 /* is-active doForeignObject(Object, Object, InteropLibrary, InteropLibrary) */) {
                if ((JSRuntime.isForeignObject(leftNodeValue_)) && (JSRuntime.isForeignObject(rightNodeValue_))) {
                    return this.foreignObject1Boundary2(state, leftNodeValue_, rightNodeValue_);
                }
            }
            if ((state & 0x200000000L) != 0 /* is-active doFallback(Object, Object) */) {
                if (fallbackGuard_(state, leftNodeValue_, rightNodeValue_)) {
                    return JSIdenticalNode.doFallback(leftNodeValue_, rightNodeValue_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        executeBoolean(frameValue);
        return;
    }

    private boolean executeAndSpecialize(Object leftNodeValue, Object rightNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        long state = state_;
        int exclude = exclude_;
        try {
            if (leftNodeValue instanceof Integer) {
                int leftNodeValue_ = (int) leftNodeValue;
                if (rightNodeValue instanceof Integer) {
                    int rightNodeValue_ = (int) rightNodeValue;
                    this.state_ = state = state | 0b1 /* add-active doInt(int, int) */;
                    lock.unlock();
                    hasLock = false;
                    return JSIdenticalNode.doInt(leftNodeValue_, rightNodeValue_);
                }
            }
            {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(leftNodeValue)) != 0) {
                    double leftNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast0, leftNodeValue);
                    int doubleCast1;
                    if ((doubleCast1 = JSTypesGen.specializeImplicitDouble(rightNodeValue)) != 0) {
                        double rightNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast1, rightNodeValue);
                        state = (state | ((long) doubleCast0 << 34) /* set-implicit-active 0:double */);
                        state = (state | ((long) doubleCast1 << 38) /* set-implicit-active 1:double */);
                        this.state_ = state = state | 0b10 /* add-active doDouble(double, double) */;
                        lock.unlock();
                        hasLock = false;
                        return doDouble(leftNodeValue_, rightNodeValue_);
                    }
                }
            }
            if (leftNodeValue instanceof Boolean) {
                boolean leftNodeValue_ = (boolean) leftNodeValue;
                if (rightNodeValue instanceof Boolean) {
                    boolean rightNodeValue_ = (boolean) rightNodeValue;
                    this.state_ = state = state | 0b100 /* add-active doBoolean(boolean, boolean) */;
                    lock.unlock();
                    hasLock = false;
                    return JSIdenticalNode.doBoolean(leftNodeValue_, rightNodeValue_);
                }
            }
            if (leftNodeValue instanceof BigInt) {
                BigInt leftNodeValue_ = (BigInt) leftNodeValue;
                if (rightNodeValue instanceof BigInt) {
                    BigInt rightNodeValue_ = (BigInt) rightNodeValue;
                    this.state_ = state = state | 0b1000 /* add-active doBigInt(BigInt, BigInt) */;
                    lock.unlock();
                    hasLock = false;
                    return JSIdenticalNode.doBigInt(leftNodeValue_, rightNodeValue_);
                }
                {
                    int doubleCast1;
                    if ((doubleCast1 = JSTypesGen.specializeImplicitDouble(rightNodeValue)) != 0) {
                        double rightNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast1, rightNodeValue);
                        state = (state | ((long) doubleCast1 << 38) /* set-implicit-active 1:double */);
                        this.state_ = state = state | 0b10000 /* add-active doBigIntDouble(BigInt, double) */;
                        lock.unlock();
                        hasLock = false;
                        return JSIdenticalNode.doBigIntDouble(leftNodeValue_, rightNodeValue_);
                    }
                }
            }
            {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(leftNodeValue)) != 0) {
                    double leftNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast0, leftNodeValue);
                    if (rightNodeValue instanceof BigInt) {
                        BigInt rightNodeValue_ = (BigInt) rightNodeValue;
                        state = (state | ((long) doubleCast0 << 34) /* set-implicit-active 0:double */);
                        this.state_ = state = state | 0b100000 /* add-active doDoubleBigInt(double, BigInt) */;
                        lock.unlock();
                        hasLock = false;
                        return JSIdenticalNode.doDoubleBigInt(leftNodeValue_, rightNodeValue_);
                    }
                }
            }
            if ((JSGuards.isUndefined(leftNodeValue))) {
                this.state_ = state = state | 0b1000000 /* add-active doUndefinedA(Object, Object) */;
                lock.unlock();
                hasLock = false;
                return JSIdenticalNode.doUndefinedA(leftNodeValue, rightNodeValue);
            }
            if ((JSGuards.isUndefined(rightNodeValue))) {
                this.state_ = state = state | 0b10000000 /* add-active doUndefinedB(Object, Object) */;
                lock.unlock();
                hasLock = false;
                return JSIdenticalNode.doUndefinedB(leftNodeValue, rightNodeValue);
            }
            if (JSTypes.isDynamicObject(leftNodeValue)) {
                DynamicObject leftNodeValue_ = (DynamicObject) leftNodeValue;
                if ((JSGuards.isJSObject(leftNodeValue_))) {
                    this.state_ = state = state | 0b100000000 /* add-active doJSObjectA(DynamicObject, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return JSIdenticalNode.doJSObjectA(leftNodeValue_, rightNodeValue);
                }
            }
            if (JSTypes.isDynamicObject(rightNodeValue)) {
                DynamicObject rightNodeValue_ = (DynamicObject) rightNodeValue;
                if ((JSGuards.isJSObject(rightNodeValue_))) {
                    this.state_ = state = state | 0b1000000000 /* add-active doJSObjectB(Object, DynamicObject) */;
                    lock.unlock();
                    hasLock = false;
                    return JSIdenticalNode.doJSObjectB(leftNodeValue, rightNodeValue_);
                }
            }
            if ((JSGuards.isJSNull(leftNodeValue)) && (JSGuards.isJSNull(rightNodeValue))) {
                this.state_ = state = state | 0b10000000000 /* add-active doNullNull(Object, Object) */;
                lock.unlock();
                hasLock = false;
                return JSIdenticalNode.doNullNull(leftNodeValue, rightNodeValue);
            }
            if ((JSGuards.isJSNull(leftNodeValue)) && (JSGuards.isUndefined(rightNodeValue))) {
                this.state_ = state = state | 0b100000000000 /* add-active doNullUndefined(Object, Object) */;
                lock.unlock();
                hasLock = false;
                return JSIdenticalNode.doNullUndefined(leftNodeValue, rightNodeValue);
            }
            if ((JSGuards.isUndefined(leftNodeValue)) && (JSGuards.isJSNull(rightNodeValue))) {
                this.state_ = state = state | 0b1000000000000 /* add-active doUndefinedNull(Object, Object) */;
                lock.unlock();
                hasLock = false;
                return JSIdenticalNode.doUndefinedNull(leftNodeValue, rightNodeValue);
            }
            if (((exclude & 0b1)) == 0 /* is-not-excluded doNullA(Object, Object, InteropLibrary) */) {
                int count14_ = 0;
                NullA0Data s14_ = this.nullA0_cache;
                if ((state & 0b10000000000000) != 0 /* is-active doNullA(Object, Object, InteropLibrary) */) {
                    while (s14_ != null) {
                        if ((s14_.bInterop_.accepts(rightNodeValue)) && (JSGuards.isJSNull(leftNodeValue)) && (!(JSGuards.isJSNull(rightNodeValue))) && (!(JSGuards.isUndefined(rightNodeValue)))) {
                            break;
                        }
                        s14_ = s14_.next_;
                        count14_++;
                    }
                }
                if (s14_ == null) {
                    if ((JSGuards.isJSNull(leftNodeValue)) && (!(JSGuards.isJSNull(rightNodeValue))) && (!(JSGuards.isUndefined(rightNodeValue))) && count14_ < (JSIdenticalNode.INTEROP_LIMIT)) {
                        // assert (s14_.bInterop_.accepts(rightNodeValue));
                        s14_ = super.insert(new NullA0Data(nullA0_cache));
                        s14_.bInterop_ = s14_.insertAccessor((INTEROP_LIBRARY_.create(rightNodeValue)));
                        this.nullA0_cache = s14_;
                        this.state_ = state = state | 0b10000000000000 /* add-active doNullA(Object, Object, InteropLibrary) */;
                    }
                }
                if (s14_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return JSIdenticalNode.doNullA(leftNodeValue, rightNodeValue, s14_.bInterop_);
                }
            }
            {
                InteropLibrary nullA1_bInterop__ = null;
                {
                    EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                    Node prev_ = encapsulating_.set(this);
                    try {
                        if ((JSGuards.isJSNull(leftNodeValue)) && (!(JSGuards.isJSNull(rightNodeValue))) && (!(JSGuards.isUndefined(rightNodeValue)))) {
                            nullA1_bInterop__ = (INTEROP_LIBRARY_.getUncached(rightNodeValue));
                            this.exclude_ = exclude = exclude | 0b1 /* add-excluded doNullA(Object, Object, InteropLibrary) */;
                            this.nullA0_cache = null;
                            state = state & 0xffffffffffffdfffL /* remove-active doNullA(Object, Object, InteropLibrary) */;
                            this.state_ = state = state | 0b100000000000000 /* add-active doNullA(Object, Object, InteropLibrary) */;
                            lock.unlock();
                            hasLock = false;
                            return JSIdenticalNode.doNullA(leftNodeValue, rightNodeValue, nullA1_bInterop__);
                        }
                    } finally {
                        encapsulating_.set(prev_);
                    }
                }
            }
            if (((exclude & 0b10)) == 0 /* is-not-excluded doNullB(Object, Object, InteropLibrary) */) {
                int count16_ = 0;
                NullB0Data s16_ = this.nullB0_cache;
                if ((state & 0b1000000000000000) != 0 /* is-active doNullB(Object, Object, InteropLibrary) */) {
                    while (s16_ != null) {
                        if ((s16_.aInterop_.accepts(leftNodeValue)) && (!(JSGuards.isJSNull(leftNodeValue))) && (!(JSGuards.isUndefined(leftNodeValue))) && (JSGuards.isJSNull(rightNodeValue))) {
                            break;
                        }
                        s16_ = s16_.next_;
                        count16_++;
                    }
                }
                if (s16_ == null) {
                    if ((!(JSGuards.isJSNull(leftNodeValue))) && (!(JSGuards.isUndefined(leftNodeValue))) && (JSGuards.isJSNull(rightNodeValue)) && count16_ < (JSIdenticalNode.INTEROP_LIMIT)) {
                        // assert (s16_.aInterop_.accepts(leftNodeValue));
                        s16_ = super.insert(new NullB0Data(nullB0_cache));
                        s16_.aInterop_ = s16_.insertAccessor((INTEROP_LIBRARY_.create(leftNodeValue)));
                        this.nullB0_cache = s16_;
                        this.state_ = state = state | 0b1000000000000000 /* add-active doNullB(Object, Object, InteropLibrary) */;
                    }
                }
                if (s16_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return JSIdenticalNode.doNullB(leftNodeValue, rightNodeValue, s16_.aInterop_);
                }
            }
            {
                InteropLibrary nullB1_aInterop__ = null;
                {
                    EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                    Node prev_ = encapsulating_.set(this);
                    try {
                        if ((!(JSGuards.isJSNull(leftNodeValue))) && (!(JSGuards.isUndefined(leftNodeValue))) && (JSGuards.isJSNull(rightNodeValue))) {
                            nullB1_aInterop__ = (INTEROP_LIBRARY_.getUncached(leftNodeValue));
                            this.exclude_ = exclude = exclude | 0b10 /* add-excluded doNullB(Object, Object, InteropLibrary) */;
                            this.nullB0_cache = null;
                            state = state & 0xffffffffffff7fffL /* remove-active doNullB(Object, Object, InteropLibrary) */;
                            this.state_ = state = state | 0x10000L /* add-active doNullB(Object, Object, InteropLibrary) */;
                            lock.unlock();
                            hasLock = false;
                            return JSIdenticalNode.doNullB(leftNodeValue, rightNodeValue, nullB1_aInterop__);
                        }
                    } finally {
                        encapsulating_.set(prev_);
                    }
                }
            }
            if (rightNodeValue instanceof JSLazyString) {
                JSLazyString rightNodeValue_ = (JSLazyString) rightNodeValue;
                if (leftNodeValue instanceof JSLazyString) {
                    JSLazyString leftNodeValue_ = (JSLazyString) leftNodeValue;
                    if (((exclude & 0b100)) == 0 /* is-not-excluded doLazyStringReference(JSLazyString, JSLazyString) */) {
                        if ((JSGuards.isReferenceEquals(leftNodeValue_, rightNodeValue_))) {
                            this.state_ = state = state | 0x20000L /* add-active doLazyStringReference(JSLazyString, JSLazyString) */;
                            lock.unlock();
                            hasLock = false;
                            return JSIdenticalNode.doLazyStringReference(leftNodeValue_, rightNodeValue_);
                        }
                    }
                    if (this.flattenA == null) {
                        this.flattenA = (ConditionProfile.createBinaryProfile());
                    }
                    if (this.flattenB == null) {
                        this.flattenB = (ConditionProfile.createBinaryProfile());
                    }
                    if (this.sameLen == null) {
                        this.sameLen = (ConditionProfile.createBinaryProfile());
                    }
                    this.exclude_ = exclude = exclude | 0b100 /* add-excluded doLazyStringReference(JSLazyString, JSLazyString) */;
                    state = state & 0xfffffffffffdffffL /* remove-active doLazyStringReference(JSLazyString, JSLazyString) */;
                    this.state_ = state = state | 0x40000L /* add-active doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return JSIdenticalNode.doLazyString(leftNodeValue_, rightNodeValue_, this.flattenA, this.flattenB, this.sameLen);
                }
                {
                    int stringCast0;
                    if ((stringCast0 = JSTypesGen.specializeImplicitString(leftNodeValue)) != 0) {
                        String leftNodeValue_ = JSTypesGen.asImplicitString(stringCast0, leftNodeValue);
                        if (this.flattenB == null) {
                            this.flattenB = (ConditionProfile.createBinaryProfile());
                        }
                        if (this.sameLen == null) {
                            this.sameLen = (ConditionProfile.createBinaryProfile());
                        }
                        state = (state | ((long) stringCast0 << 42) /* set-implicit-active 0:String */);
                        this.state_ = state = state | 0x80000L /* add-active doStringLazyString(String, JSLazyString, ConditionProfile, ConditionProfile) */;
                        lock.unlock();
                        hasLock = false;
                        return JSIdenticalNode.doStringLazyString(leftNodeValue_, rightNodeValue_, this.flattenB, this.sameLen);
                    }
                }
            }
            {
                int stringCast1;
                if ((stringCast1 = JSTypesGen.specializeImplicitString(rightNodeValue)) != 0) {
                    String rightNodeValue_ = JSTypesGen.asImplicitString(stringCast1, rightNodeValue);
                    if (leftNodeValue instanceof JSLazyString) {
                        JSLazyString leftNodeValue_ = (JSLazyString) leftNodeValue;
                        if (this.flattenA == null) {
                            this.flattenA = (ConditionProfile.createBinaryProfile());
                        }
                        if (this.sameLen == null) {
                            this.sameLen = (ConditionProfile.createBinaryProfile());
                        }
                        state = (state | ((long) stringCast1 << 46) /* set-implicit-active 1:String */);
                        this.state_ = state = state | 0x100000L /* add-active doLazyStringString(JSLazyString, String, ConditionProfile, ConditionProfile) */;
                        lock.unlock();
                        hasLock = false;
                        return JSIdenticalNode.doLazyStringString(leftNodeValue_, rightNodeValue_, this.flattenA, this.sameLen);
                    }
                    {
                        int stringCast0;
                        if ((stringCast0 = JSTypesGen.specializeImplicitString(leftNodeValue)) != 0) {
                            String leftNodeValue_ = JSTypesGen.asImplicitString(stringCast0, leftNodeValue);
                            if (((exclude & 0b1000)) == 0 /* is-not-excluded doStringIdentity(String, String) */) {
                                if ((JSGuards.isReferenceEquals(leftNodeValue_, rightNodeValue_))) {
                                    state = (state | ((long) stringCast0 << 42) /* set-implicit-active 0:String */);
                                    state = (state | ((long) stringCast1 << 46) /* set-implicit-active 1:String */);
                                    this.state_ = state = state | 0x200000L /* add-active doStringIdentity(String, String) */;
                                    lock.unlock();
                                    hasLock = false;
                                    return JSIdenticalNode.doStringIdentity(leftNodeValue_, rightNodeValue_);
                                }
                            }
                            this.exclude_ = exclude = exclude | 0b1000 /* add-excluded doStringIdentity(String, String) */;
                            state = state & 0xffffffffffdfffffL /* remove-active doStringIdentity(String, String) */;
                            state = (state | ((long) stringCast0 << 42) /* set-implicit-active 0:String */);
                            state = (state | ((long) stringCast1 << 46) /* set-implicit-active 1:String */);
                            this.state_ = state = state | 0x400000L /* add-active doString(String, String) */;
                            lock.unlock();
                            hasLock = false;
                            return JSIdenticalNode.doString(leftNodeValue_, rightNodeValue_);
                        }
                    }
                }
            }
            if (leftNodeValue instanceof Symbol) {
                Symbol leftNodeValue_ = (Symbol) leftNodeValue;
                if (rightNodeValue instanceof Symbol) {
                    Symbol rightNodeValue_ = (Symbol) rightNodeValue;
                    this.state_ = state = state | 0x800000L /* add-active doSymbol(Symbol, Symbol) */;
                    lock.unlock();
                    hasLock = false;
                    return JSIdenticalNode.doSymbol(leftNodeValue_, rightNodeValue_);
                }
            }
            if ((JSGuards.isBoolean(leftNodeValue) != JSGuards.isBoolean(rightNodeValue))) {
                this.state_ = state = state | 0x1000000L /* add-active doBooleanNotBoolean(Object, Object) */;
                lock.unlock();
                hasLock = false;
                return JSIdenticalNode.doBooleanNotBoolean(leftNodeValue, rightNodeValue);
            }
            if ((JSGuards.isSymbol(leftNodeValue) != JSGuards.isSymbol(rightNodeValue))) {
                this.state_ = state = state | 0x2000000L /* add-active doSymbolNotSymbol(Object, Object) */;
                lock.unlock();
                hasLock = false;
                return JSIdenticalNode.doSymbolNotSymbol(leftNodeValue, rightNodeValue);
            }
            if (((exclude & 0b10000)) == 0 /* is-not-excluded doDifferentTypesCached(Object, Object, Class<>, Class<>) */) {
                int count27_ = 0;
                DifferentTypesCachedData s27_ = this.differentTypesCached_cache;
                if ((state & 0x4000000L) != 0 /* is-active doDifferentTypesCached(Object, Object, Class<>, Class<>) */) {
                    while (s27_ != null) {
                        if ((leftNodeValue.getClass() == s27_.cachedClassA_) && (rightNodeValue.getClass() == s27_.cachedClassB_)) {
                            assert (JSIdenticalNode.isNonObjectType(s27_.cachedClassA_) || JSIdenticalNode.isNonObjectType(s27_.cachedClassB_));
                            assert (JSIdenticalNode.differentNonObjectTypes(s27_.cachedClassA_, s27_.cachedClassB_));
                            break;
                        }
                        s27_ = s27_.next_;
                        count27_++;
                    }
                }
                if (s27_ == null) {
                    {
                        Class<?> cachedClassA__ = (leftNodeValue.getClass());
                        if ((leftNodeValue.getClass() == cachedClassA__)) {
                            Class<?> cachedClassB__ = (rightNodeValue.getClass());
                            if ((rightNodeValue.getClass() == cachedClassB__) && (JSIdenticalNode.isNonObjectType(cachedClassA__) || JSIdenticalNode.isNonObjectType(cachedClassB__)) && (JSIdenticalNode.differentNonObjectTypes(cachedClassA__, cachedClassB__)) && count27_ < (JSIdenticalNode.MAX_CLASSES)) {
                                s27_ = new DifferentTypesCachedData(differentTypesCached_cache);
                                s27_.cachedClassA_ = cachedClassA__;
                                s27_.cachedClassB_ = cachedClassB__;
                                this.differentTypesCached_cache = s27_;
                                this.state_ = state = state | 0x4000000L /* add-active doDifferentTypesCached(Object, Object, Class<>, Class<>) */;
                            }
                        }
                    }
                }
                if (s27_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return JSIdenticalNode.doDifferentTypesCached(leftNodeValue, rightNodeValue, s27_.cachedClassA_, s27_.cachedClassB_);
                }
            }
            if ((JSRuntime.isJavaNumber(leftNodeValue) != JSRuntime.isJavaNumber(rightNodeValue))) {
                this.exclude_ = exclude = exclude | 0b10000 /* add-excluded doDifferentTypesCached(Object, Object, Class<>, Class<>) */;
                this.differentTypesCached_cache = null;
                state = state & 0xfffffffffbffffffL /* remove-active doDifferentTypesCached(Object, Object, Class<>, Class<>) */;
                this.state_ = state = state | 0x8000000L /* add-active doNumberNotNumber(Object, Object) */;
                lock.unlock();
                hasLock = false;
                return JSIdenticalNode.doNumberNotNumber(leftNodeValue, rightNodeValue);
            }
            if ((JSRuntime.isString(leftNodeValue) != JSRuntime.isString(rightNodeValue))) {
                this.exclude_ = exclude = exclude | 0b10000 /* add-excluded doDifferentTypesCached(Object, Object, Class<>, Class<>) */;
                this.differentTypesCached_cache = null;
                state = state & 0xfffffffffbffffffL /* remove-active doDifferentTypesCached(Object, Object, Class<>, Class<>) */;
                this.state_ = state = state | 0x10000000L /* add-active doStringNotString(Object, Object) */;
                lock.unlock();
                hasLock = false;
                return JSIdenticalNode.doStringNotString(leftNodeValue, rightNodeValue);
            }
            if (((exclude & 0b100000)) == 0 /* is-not-excluded doNumberCached(Object, Object, Class<>, Class<>) */) {
                int count30_ = 0;
                NumberCachedData s30_ = this.numberCached_cache;
                if ((state & 0x20000000L) != 0 /* is-active doNumberCached(Object, Object, Class<>, Class<>) */) {
                    while (s30_ != null) {
                        assert (s30_.cachedClassA_ != null);
                        assert (s30_.cachedClassB_ != null);
                        if ((leftNodeValue.getClass() == s30_.cachedClassA_) && (rightNodeValue.getClass() == s30_.cachedClassB_)) {
                            break;
                        }
                        s30_ = s30_.next_;
                        count30_++;
                    }
                }
                if (s30_ == null) {
                    {
                        Class<?> cachedClassA__1 = (JSGuards.getJavaNumberClass(leftNodeValue));
                        if ((cachedClassA__1 != null)) {
                            Class<?> cachedClassB__1 = (JSGuards.getJavaNumberClass(rightNodeValue));
                            if ((cachedClassB__1 != null) && (leftNodeValue.getClass() == cachedClassA__1) && (rightNodeValue.getClass() == cachedClassB__1) && count30_ < (JSIdenticalNode.MAX_CLASSES)) {
                                s30_ = new NumberCachedData(numberCached_cache);
                                s30_.cachedClassA_ = cachedClassA__1;
                                s30_.cachedClassB_ = cachedClassB__1;
                                this.numberCached_cache = s30_;
                                this.state_ = state = state | 0x20000000L /* add-active doNumberCached(Object, Object, Class<>, Class<>) */;
                            }
                        }
                    }
                }
                if (s30_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return doNumberCached(leftNodeValue, rightNodeValue, s30_.cachedClassA_, s30_.cachedClassB_);
                }
            }
            if (leftNodeValue instanceof Number) {
                Number leftNodeValue_ = (Number) leftNodeValue;
                if (rightNodeValue instanceof Number) {
                    Number rightNodeValue_ = (Number) rightNodeValue;
                    if ((JSRuntime.isJavaNumber(leftNodeValue_)) && (JSRuntime.isJavaNumber(rightNodeValue_))) {
                        this.exclude_ = exclude = exclude | 0b100000 /* add-excluded doNumberCached(Object, Object, Class<>, Class<>) */;
                        this.numberCached_cache = null;
                        state = state & 0xffffffffdfffffffL /* remove-active doNumberCached(Object, Object, Class<>, Class<>) */;
                        this.state_ = state = state | 0x40000000L /* add-active doNumber(Number, Number) */;
                        lock.unlock();
                        hasLock = false;
                        return doNumber(leftNodeValue_, rightNodeValue_);
                    }
                }
            }
            if (((exclude & 0b1000000)) == 0 /* is-not-excluded doForeignObject(Object, Object, InteropLibrary, InteropLibrary) */) {
                int count32_ = 0;
                ForeignObject0Data s32_ = this.foreignObject0_cache;
                if ((state & 0x80000000L) != 0 /* is-active doForeignObject(Object, Object, InteropLibrary, InteropLibrary) */) {
                    while (s32_ != null) {
                        if ((s32_.aInterop_.accepts(leftNodeValue)) && (s32_.bInterop_.accepts(rightNodeValue)) && (JSRuntime.isForeignObject(leftNodeValue)) && (JSRuntime.isForeignObject(rightNodeValue))) {
                            break;
                        }
                        s32_ = s32_.next_;
                        count32_++;
                    }
                }
                if (s32_ == null) {
                    if ((JSRuntime.isForeignObject(leftNodeValue)) && (JSRuntime.isForeignObject(rightNodeValue)) && count32_ < (JSIdenticalNode.INTEROP_LIMIT)) {
                        // assert (s32_.aInterop_.accepts(leftNodeValue));
                        // assert (s32_.bInterop_.accepts(rightNodeValue));
                        s32_ = super.insert(new ForeignObject0Data(foreignObject0_cache));
                        s32_.aInterop_ = s32_.insertAccessor((INTEROP_LIBRARY_.create(leftNodeValue)));
                        s32_.bInterop_ = s32_.insertAccessor((INTEROP_LIBRARY_.create(rightNodeValue)));
                        this.foreignObject0_cache = s32_;
                        this.state_ = state = state | 0x80000000L /* add-active doForeignObject(Object, Object, InteropLibrary, InteropLibrary) */;
                    }
                }
                if (s32_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return JSIdenticalNode.doForeignObject(leftNodeValue, rightNodeValue, s32_.aInterop_, s32_.bInterop_);
                }
            }
            {
                InteropLibrary foreignObject1_bInterop__ = null;
                InteropLibrary foreignObject1_aInterop__ = null;
                {
                    EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                    Node prev_ = encapsulating_.set(this);
                    try {
                        if ((JSRuntime.isForeignObject(leftNodeValue)) && (JSRuntime.isForeignObject(rightNodeValue))) {
                            foreignObject1_aInterop__ = (INTEROP_LIBRARY_.getUncached(leftNodeValue));
                            foreignObject1_bInterop__ = (INTEROP_LIBRARY_.getUncached(rightNodeValue));
                            this.exclude_ = exclude = exclude | 0b1000000 /* add-excluded doForeignObject(Object, Object, InteropLibrary, InteropLibrary) */;
                            this.foreignObject0_cache = null;
                            state = state & 0xffffffff7fffffffL /* remove-active doForeignObject(Object, Object, InteropLibrary, InteropLibrary) */;
                            this.state_ = state = state | 0x100000000L /* add-active doForeignObject(Object, Object, InteropLibrary, InteropLibrary) */;
                            lock.unlock();
                            hasLock = false;
                            return JSIdenticalNode.doForeignObject(leftNodeValue, rightNodeValue, foreignObject1_aInterop__, foreignObject1_bInterop__);
                        }
                    } finally {
                        encapsulating_.set(prev_);
                    }
                }
            }
            this.state_ = state = state | 0x200000000L /* add-active doFallback(Object, Object) */;
            lock.unlock();
            hasLock = false;
            return JSIdenticalNode.doFallback(leftNodeValue, rightNodeValue);
        } finally {
            if (hasLock) {
                lock.unlock();
            }
        }
    }

    @Override
    public NodeCost getCost() {
        long state = state_;
        if ((state & 0x3ffffffffL) == 0b0) {
            return NodeCost.UNINITIALIZED;
        } else if (((state & 0x3ffffffffL) & ((state & 0x3ffffffffL) - 1)) == 0 /* is-single-active  */) {
            NullA0Data s14_ = this.nullA0_cache;
            NullB0Data s16_ = this.nullB0_cache;
            DifferentTypesCachedData s27_ = this.differentTypesCached_cache;
            NumberCachedData s30_ = this.numberCached_cache;
            ForeignObject0Data s32_ = this.foreignObject0_cache;
            if ((s14_ == null || s14_.next_ == null) && (s16_ == null || s16_.next_ == null) && (s27_ == null || s27_.next_ == null) && (s30_ == null || s30_.next_ == null) && (s32_ == null || s32_.next_ == null)) {
                return NodeCost.MONOMORPHIC;
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[35];
        Object[] s;
        data[0] = 0;
        long state = state_;
        int exclude = exclude_;
        s = new Object[3];
        s[0] = "doInt";
        if ((state & 0b1) != 0 /* is-active doInt(int, int) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doDouble";
        if ((state & 0b10) != 0 /* is-active doDouble(double, double) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doBoolean";
        if ((state & 0b100) != 0 /* is-active doBoolean(boolean, boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doBigInt";
        if ((state & 0b1000) != 0 /* is-active doBigInt(BigInt, BigInt) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doBigIntDouble";
        if ((state & 0b10000) != 0 /* is-active doBigIntDouble(BigInt, double) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "doDoubleBigInt";
        if ((state & 0b100000) != 0 /* is-active doDoubleBigInt(double, BigInt) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "doUndefinedA";
        if ((state & 0b1000000) != 0 /* is-active doUndefinedA(Object, Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        s = new Object[3];
        s[0] = "doUndefinedB";
        if ((state & 0b10000000) != 0 /* is-active doUndefinedB(Object, Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[8] = s;
        s = new Object[3];
        s[0] = "doJSObjectA";
        if ((state & 0b100000000) != 0 /* is-active doJSObjectA(DynamicObject, Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[9] = s;
        s = new Object[3];
        s[0] = "doJSObjectB";
        if ((state & 0b1000000000) != 0 /* is-active doJSObjectB(Object, DynamicObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[10] = s;
        s = new Object[3];
        s[0] = "doNullNull";
        if ((state & 0b10000000000) != 0 /* is-active doNullNull(Object, Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[11] = s;
        s = new Object[3];
        s[0] = "doNullUndefined";
        if ((state & 0b100000000000) != 0 /* is-active doNullUndefined(Object, Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[12] = s;
        s = new Object[3];
        s[0] = "doUndefinedNull";
        if ((state & 0b1000000000000) != 0 /* is-active doUndefinedNull(Object, Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[13] = s;
        s = new Object[3];
        s[0] = "doNullA";
        if ((state & 0b10000000000000) != 0 /* is-active doNullA(Object, Object, InteropLibrary) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            NullA0Data s14_ = this.nullA0_cache;
            while (s14_ != null) {
                cached.add(Arrays.asList(s14_.bInterop_));
                s14_ = s14_.next_;
            }
            s[2] = cached;
        } else if ((exclude & 0b1) != 0 /* is-excluded doNullA(Object, Object, InteropLibrary) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[14] = s;
        s = new Object[3];
        s[0] = "doNullA";
        if ((state & 0b100000000000000) != 0 /* is-active doNullA(Object, Object, InteropLibrary) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList());
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[15] = s;
        s = new Object[3];
        s[0] = "doNullB";
        if ((state & 0b1000000000000000) != 0 /* is-active doNullB(Object, Object, InteropLibrary) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            NullB0Data s16_ = this.nullB0_cache;
            while (s16_ != null) {
                cached.add(Arrays.asList(s16_.aInterop_));
                s16_ = s16_.next_;
            }
            s[2] = cached;
        } else if ((exclude & 0b10) != 0 /* is-excluded doNullB(Object, Object, InteropLibrary) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[16] = s;
        s = new Object[3];
        s[0] = "doNullB";
        if ((state & 0x10000L) != 0 /* is-active doNullB(Object, Object, InteropLibrary) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList());
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[17] = s;
        s = new Object[3];
        s[0] = "doLazyStringReference";
        if ((state & 0x20000L) != 0 /* is-active doLazyStringReference(JSLazyString, JSLazyString) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b100) != 0 /* is-excluded doLazyStringReference(JSLazyString, JSLazyString) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[18] = s;
        s = new Object[3];
        s[0] = "doLazyString";
        if ((state & 0x40000L) != 0 /* is-active doLazyString(JSLazyString, JSLazyString, ConditionProfile, ConditionProfile, ConditionProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.flattenA, this.flattenB, this.sameLen));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[19] = s;
        s = new Object[3];
        s[0] = "doStringLazyString";
        if ((state & 0x80000L) != 0 /* is-active doStringLazyString(String, JSLazyString, ConditionProfile, ConditionProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.flattenB, this.sameLen));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[20] = s;
        s = new Object[3];
        s[0] = "doLazyStringString";
        if ((state & 0x100000L) != 0 /* is-active doLazyStringString(JSLazyString, String, ConditionProfile, ConditionProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.flattenA, this.sameLen));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[21] = s;
        s = new Object[3];
        s[0] = "doStringIdentity";
        if ((state & 0x200000L) != 0 /* is-active doStringIdentity(String, String) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b1000) != 0 /* is-excluded doStringIdentity(String, String) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[22] = s;
        s = new Object[3];
        s[0] = "doString";
        if ((state & 0x400000L) != 0 /* is-active doString(String, String) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[23] = s;
        s = new Object[3];
        s[0] = "doSymbol";
        if ((state & 0x800000L) != 0 /* is-active doSymbol(Symbol, Symbol) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[24] = s;
        s = new Object[3];
        s[0] = "doBooleanNotBoolean";
        if ((state & 0x1000000L) != 0 /* is-active doBooleanNotBoolean(Object, Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[25] = s;
        s = new Object[3];
        s[0] = "doSymbolNotSymbol";
        if ((state & 0x2000000L) != 0 /* is-active doSymbolNotSymbol(Object, Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[26] = s;
        s = new Object[3];
        s[0] = "doDifferentTypesCached";
        if ((state & 0x4000000L) != 0 /* is-active doDifferentTypesCached(Object, Object, Class<>, Class<>) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            DifferentTypesCachedData s27_ = this.differentTypesCached_cache;
            while (s27_ != null) {
                cached.add(Arrays.asList(s27_.cachedClassA_, s27_.cachedClassB_));
                s27_ = s27_.next_;
            }
            s[2] = cached;
        } else if ((exclude & 0b10000) != 0 /* is-excluded doDifferentTypesCached(Object, Object, Class<>, Class<>) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[27] = s;
        s = new Object[3];
        s[0] = "doNumberNotNumber";
        if ((state & 0x8000000L) != 0 /* is-active doNumberNotNumber(Object, Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[28] = s;
        s = new Object[3];
        s[0] = "doStringNotString";
        if ((state & 0x10000000L) != 0 /* is-active doStringNotString(Object, Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[29] = s;
        s = new Object[3];
        s[0] = "doNumberCached";
        if ((state & 0x20000000L) != 0 /* is-active doNumberCached(Object, Object, Class<>, Class<>) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            NumberCachedData s30_ = this.numberCached_cache;
            while (s30_ != null) {
                cached.add(Arrays.asList(s30_.cachedClassA_, s30_.cachedClassB_));
                s30_ = s30_.next_;
            }
            s[2] = cached;
        } else if ((exclude & 0b100000) != 0 /* is-excluded doNumberCached(Object, Object, Class<>, Class<>) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[30] = s;
        s = new Object[3];
        s[0] = "doNumber";
        if ((state & 0x40000000L) != 0 /* is-active doNumber(Number, Number) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[31] = s;
        s = new Object[3];
        s[0] = "doForeignObject";
        if ((state & 0x80000000L) != 0 /* is-active doForeignObject(Object, Object, InteropLibrary, InteropLibrary) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            ForeignObject0Data s32_ = this.foreignObject0_cache;
            while (s32_ != null) {
                cached.add(Arrays.asList(s32_.aInterop_, s32_.bInterop_));
                s32_ = s32_.next_;
            }
            s[2] = cached;
        } else if ((exclude & 0b1000000) != 0 /* is-excluded doForeignObject(Object, Object, InteropLibrary, InteropLibrary) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[32] = s;
        s = new Object[3];
        s[0] = "doForeignObject";
        if ((state & 0x100000000L) != 0 /* is-active doForeignObject(Object, Object, InteropLibrary, InteropLibrary) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList());
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[33] = s;
        s = new Object[3];
        s[0] = "doFallback";
        if ((state & 0x200000000L) != 0 /* is-active doFallback(Object, Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[34] = s;
        return Provider.create(data);
    }

    private static boolean fallbackGuard_(long state, Object leftNodeValue, Object rightNodeValue) {
        if (JSTypesGen.isImplicitDouble(leftNodeValue) && JSTypesGen.isImplicitDouble(rightNodeValue)) {
            return false;
        }
        if (((state & 0b100)) == 0 /* is-not-active doBoolean(boolean, boolean) */ && leftNodeValue instanceof Boolean && rightNodeValue instanceof Boolean) {
            return false;
        }
        if (leftNodeValue instanceof BigInt) {
            if (((state & 0b1000)) == 0 /* is-not-active doBigInt(BigInt, BigInt) */ && rightNodeValue instanceof BigInt) {
                return false;
            }
            if (JSTypesGen.isImplicitDouble(rightNodeValue)) {
                return false;
            }
        }
        if (JSTypesGen.isImplicitDouble(leftNodeValue) && rightNodeValue instanceof BigInt) {
            return false;
        }
        if (((state & 0b1000000)) == 0 /* is-not-active doUndefinedA(Object, Object) */ && (JSGuards.isUndefined(leftNodeValue))) {
            return false;
        }
        if (((state & 0b10000000)) == 0 /* is-not-active doUndefinedB(Object, Object) */ && (JSGuards.isUndefined(rightNodeValue))) {
            return false;
        }
        if (JSTypes.isDynamicObject(leftNodeValue)) {
            DynamicObject leftNodeValue_ = (DynamicObject) leftNodeValue;
            if ((JSGuards.isJSObject(leftNodeValue_))) {
                return false;
            }
        }
        if (JSTypes.isDynamicObject(rightNodeValue)) {
            DynamicObject rightNodeValue_ = (DynamicObject) rightNodeValue;
            if ((JSGuards.isJSObject(rightNodeValue_))) {
                return false;
            }
        }
        if (((state & 0b10000000000)) == 0 /* is-not-active doNullNull(Object, Object) */ && (JSGuards.isJSNull(leftNodeValue)) && (JSGuards.isJSNull(rightNodeValue))) {
            return false;
        }
        if (((state & 0b100000000000)) == 0 /* is-not-active doNullUndefined(Object, Object) */ && (JSGuards.isJSNull(leftNodeValue)) && (JSGuards.isUndefined(rightNodeValue))) {
            return false;
        }
        if (((state & 0b1000000000000)) == 0 /* is-not-active doUndefinedNull(Object, Object) */ && (JSGuards.isUndefined(leftNodeValue)) && (JSGuards.isJSNull(rightNodeValue))) {
            return false;
        }
        if (((state & 0b100000000000000)) == 0 /* is-not-active doNullA(Object, Object, InteropLibrary) */ && (JSGuards.isJSNull(leftNodeValue)) && (!(JSGuards.isJSNull(rightNodeValue))) && (!(JSGuards.isUndefined(rightNodeValue)))) {
            return false;
        }
        if (((state & 0x10000L)) == 0 /* is-not-active doNullB(Object, Object, InteropLibrary) */ && (!(JSGuards.isJSNull(leftNodeValue))) && (!(JSGuards.isUndefined(leftNodeValue))) && (JSGuards.isJSNull(rightNodeValue))) {
            return false;
        }
        if (JSTypesGen.isImplicitString(leftNodeValue) && JSTypesGen.isImplicitString(rightNodeValue)) {
            return false;
        }
        if (((state & 0x800000L)) == 0 /* is-not-active doSymbol(Symbol, Symbol) */ && leftNodeValue instanceof Symbol && rightNodeValue instanceof Symbol) {
            return false;
        }
        if (((state & 0x1000000L)) == 0 /* is-not-active doBooleanNotBoolean(Object, Object) */ && (JSGuards.isBoolean(leftNodeValue) != JSGuards.isBoolean(rightNodeValue))) {
            return false;
        }
        if (((state & 0x2000000L)) == 0 /* is-not-active doSymbolNotSymbol(Object, Object) */ && (JSGuards.isSymbol(leftNodeValue) != JSGuards.isSymbol(rightNodeValue))) {
            return false;
        }
        if (((state & 0x8000000L)) == 0 /* is-not-active doNumberNotNumber(Object, Object) */ && (JSRuntime.isJavaNumber(leftNodeValue) != JSRuntime.isJavaNumber(rightNodeValue))) {
            return false;
        }
        if (((state & 0x10000000L)) == 0 /* is-not-active doStringNotString(Object, Object) */ && (JSRuntime.isString(leftNodeValue) != JSRuntime.isString(rightNodeValue))) {
            return false;
        }
        if (leftNodeValue instanceof Number && rightNodeValue instanceof Number) {
            Number leftNodeValue_ = (Number) leftNodeValue;
            if ((JSRuntime.isJavaNumber(leftNodeValue_))) {
                Number rightNodeValue_ = (Number) rightNodeValue;
                if ((JSRuntime.isJavaNumber(rightNodeValue_))) {
                    return false;
                }
            }
        }
        if (((state & 0x100000000L)) == 0 /* is-not-active doForeignObject(Object, Object, InteropLibrary, InteropLibrary) */ && (JSRuntime.isForeignObject(leftNodeValue)) && (JSRuntime.isForeignObject(rightNodeValue))) {
            return false;
        }
        return true;
    }

    public static JSIdenticalNode create(JavaScriptNode left, JavaScriptNode right, int type) {
        return new JSIdenticalNodeGen(left, right, type);
    }

    @GeneratedBy(JSIdenticalNode.class)
    private static final class NullA0Data extends Node {

        @Child NullA0Data next_;
        @Child InteropLibrary bInterop_;

        NullA0Data(NullA0Data next_) {
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
    @GeneratedBy(JSIdenticalNode.class)
    private static final class NullB0Data extends Node {

        @Child NullB0Data next_;
        @Child InteropLibrary aInterop_;

        NullB0Data(NullB0Data next_) {
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
    @GeneratedBy(JSIdenticalNode.class)
    private static final class DifferentTypesCachedData {

        @CompilationFinal DifferentTypesCachedData next_;
        @CompilationFinal Class<?> cachedClassA_;
        @CompilationFinal Class<?> cachedClassB_;

        DifferentTypesCachedData(DifferentTypesCachedData next_) {
            this.next_ = next_;
        }

    }
    @GeneratedBy(JSIdenticalNode.class)
    private static final class NumberCachedData {

        @CompilationFinal NumberCachedData next_;
        @CompilationFinal Class<?> cachedClassA_;
        @CompilationFinal Class<?> cachedClassB_;

        NumberCachedData(NumberCachedData next_) {
            this.next_ = next_;
        }

    }
    @GeneratedBy(JSIdenticalNode.class)
    private static final class ForeignObject0Data extends Node {

        @Child ForeignObject0Data next_;
        @Child InteropLibrary aInterop_;
        @Child InteropLibrary bInterop_;

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
