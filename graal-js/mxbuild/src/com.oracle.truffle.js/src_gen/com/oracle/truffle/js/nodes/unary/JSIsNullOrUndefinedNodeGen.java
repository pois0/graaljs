// CheckStyle: start generated
package com.oracle.truffle.js.nodes.unary;

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
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.runtime.BigInt;
import com.oracle.truffle.js.runtime.SafeInteger;
import com.oracle.truffle.js.runtime.Symbol;
import com.oracle.truffle.js.runtime.objects.JSLazyString;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSIsNullOrUndefinedNode.class)
@SuppressWarnings("unused")
public final class JSIsNullOrUndefinedNodeGen extends JSIsNullOrUndefinedNode implements Provider {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private Class<?> jSObjectCached_cachedClass_;
    @CompilationFinal private JSValueCachedData jSValueCached_cache;
    @Child private Foreign0Data foreign0_cache;

    private JSIsNullOrUndefinedNodeGen(JavaScriptNode operand, boolean isUndefined, boolean isLeft) {
        super(operand, isUndefined, isLeft);
    }

    @ExplodeLoop
    @Override
    public Object execute(VirtualFrame frameValue, Object operandNodeValue) {
        int state = state_;
        if ((state & 0b11) != 0 /* is-active doNull(Object) || doUndefined(Object) */) {
            if ((state & 0b1) != 0 /* is-active doNull(Object) */) {
                if ((JSGuards.isJSNull(operandNodeValue))) {
                    return JSIsNullOrUndefinedNode.doNull(operandNodeValue);
                }
            }
            if ((state & 0b10) != 0 /* is-active doUndefined(Object) */) {
                if ((JSGuards.isUndefined(operandNodeValue))) {
                    return JSIsNullOrUndefinedNode.doUndefined(operandNodeValue);
                }
            }
        }
        if ((state & 0b100) != 0 /* is-active doSymbol(Symbol) */ && operandNodeValue instanceof Symbol) {
            Symbol operandNodeValue_ = (Symbol) operandNodeValue;
            return JSIsNullOrUndefinedNode.doSymbol(operandNodeValue_);
        }
        if ((state & 0b1000) != 0 /* is-active doLazyString(JSLazyString) */ && operandNodeValue instanceof JSLazyString) {
            JSLazyString operandNodeValue_ = (JSLazyString) operandNodeValue;
            return JSIsNullOrUndefinedNode.doLazyString(operandNodeValue_);
        }
        if ((state & 0b10000) != 0 /* is-active doSafeInteger(SafeInteger) */ && operandNodeValue instanceof SafeInteger) {
            SafeInteger operandNodeValue_ = (SafeInteger) operandNodeValue;
            return JSIsNullOrUndefinedNode.doSafeInteger(operandNodeValue_);
        }
        if ((state & 0b100000) != 0 /* is-active doBigInt(BigInt) */ && operandNodeValue instanceof BigInt) {
            BigInt operandNodeValue_ = (BigInt) operandNodeValue;
            return JSIsNullOrUndefinedNode.doBigInt(operandNodeValue_);
        }
        if ((state & 0b111111000000) != 0 /* is-active doJSObjectCached(Object, Class<>) || doJSObject(Object) || doJSValueCached(Object, Class<>) || doJSValue(Object) || doForeign(Object, InteropLibrary) || doForeign(Object, InteropLibrary) */) {
            if ((state & 0b1000000) != 0 /* is-active doJSObjectCached(Object, Class<>) */) {
                assert (this.jSObjectCached_cachedClass_ != null);
                if ((this.jSObjectCached_cachedClass_.isInstance(operandNodeValue))) {
                    return JSIsNullOrUndefinedNode.doJSObjectCached(operandNodeValue, this.jSObjectCached_cachedClass_);
                }
            }
            if ((state & 0b10000000) != 0 /* is-active doJSObject(Object) */) {
                if ((JSGuards.isJSObject(operandNodeValue))) {
                    return JSIsNullOrUndefinedNode.doJSObject(operandNodeValue);
                }
            }
            if ((state & 0b100000000) != 0 /* is-active doJSValueCached(Object, Class<>) */ && (operandNodeValue != null)) {
                JSValueCachedData s9_ = this.jSValueCached_cache;
                while (s9_ != null) {
                    assert (s9_.cachedClass_ != null);
                    if ((s9_.cachedClass_ == operandNodeValue.getClass())) {
                        return JSIsNullOrUndefinedNode.doJSValueCached(operandNodeValue, s9_.cachedClass_);
                    }
                    s9_ = s9_.next_;
                }
            }
            if ((state & 0b1000000000) != 0 /* is-active doJSValue(Object) */) {
                if ((!(JSGuards.isTruffleObject(operandNodeValue)))) {
                    return JSIsNullOrUndefinedNode.doJSValue(operandNodeValue);
                }
            }
            if ((state & 0b10000000000) != 0 /* is-active doForeign(Object, InteropLibrary) */) {
                Foreign0Data s11_ = this.foreign0_cache;
                while (s11_ != null) {
                    if ((s11_.interop_.accepts(operandNodeValue)) && (JSGuards.isForeignObject(operandNodeValue))) {
                        return doForeign(operandNodeValue, s11_.interop_);
                    }
                    s11_ = s11_.next_;
                }
            }
            if ((state & 0b100000000000) != 0 /* is-active doForeign(Object, InteropLibrary) */) {
                if ((JSGuards.isForeignObject(operandNodeValue))) {
                    return this.foreign1Boundary(state, operandNodeValue);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue);
    }

    @TruffleBoundary
    private Object foreign1Boundary(int state, Object operandNodeValue) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary foreign1_interop__ = (INTEROP_LIBRARY_.getUncached(operandNodeValue));
                return doForeign(operandNodeValue, foreign1_interop__);
            }
        } finally {
            encapsulating_.set(prev_);
        }
    }

    @ExplodeLoop
    @Override
    public boolean executeBoolean(Object operandNodeValue) {
        int state = state_;
        if ((state & 0b11) != 0 /* is-active doNull(Object) || doUndefined(Object) */) {
            if ((state & 0b1) != 0 /* is-active doNull(Object) */) {
                if ((JSGuards.isJSNull(operandNodeValue))) {
                    return JSIsNullOrUndefinedNode.doNull(operandNodeValue);
                }
            }
            if ((state & 0b10) != 0 /* is-active doUndefined(Object) */) {
                if ((JSGuards.isUndefined(operandNodeValue))) {
                    return JSIsNullOrUndefinedNode.doUndefined(operandNodeValue);
                }
            }
        }
        if ((state & 0b100) != 0 /* is-active doSymbol(Symbol) */ && operandNodeValue instanceof Symbol) {
            Symbol operandNodeValue_ = (Symbol) operandNodeValue;
            return JSIsNullOrUndefinedNode.doSymbol(operandNodeValue_);
        }
        if ((state & 0b1000) != 0 /* is-active doLazyString(JSLazyString) */ && operandNodeValue instanceof JSLazyString) {
            JSLazyString operandNodeValue_ = (JSLazyString) operandNodeValue;
            return JSIsNullOrUndefinedNode.doLazyString(operandNodeValue_);
        }
        if ((state & 0b10000) != 0 /* is-active doSafeInteger(SafeInteger) */ && operandNodeValue instanceof SafeInteger) {
            SafeInteger operandNodeValue_ = (SafeInteger) operandNodeValue;
            return JSIsNullOrUndefinedNode.doSafeInteger(operandNodeValue_);
        }
        if ((state & 0b100000) != 0 /* is-active doBigInt(BigInt) */ && operandNodeValue instanceof BigInt) {
            BigInt operandNodeValue_ = (BigInt) operandNodeValue;
            return JSIsNullOrUndefinedNode.doBigInt(operandNodeValue_);
        }
        if ((state & 0b111111000000) != 0 /* is-active doJSObjectCached(Object, Class<>) || doJSObject(Object) || doJSValueCached(Object, Class<>) || doJSValue(Object) || doForeign(Object, InteropLibrary) || doForeign(Object, InteropLibrary) */) {
            if ((state & 0b1000000) != 0 /* is-active doJSObjectCached(Object, Class<>) */) {
                assert (this.jSObjectCached_cachedClass_ != null);
                if ((this.jSObjectCached_cachedClass_.isInstance(operandNodeValue))) {
                    return JSIsNullOrUndefinedNode.doJSObjectCached(operandNodeValue, this.jSObjectCached_cachedClass_);
                }
            }
            if ((state & 0b10000000) != 0 /* is-active doJSObject(Object) */) {
                if ((JSGuards.isJSObject(operandNodeValue))) {
                    return JSIsNullOrUndefinedNode.doJSObject(operandNodeValue);
                }
            }
            if ((state & 0b100000000) != 0 /* is-active doJSValueCached(Object, Class<>) */ && (operandNodeValue != null)) {
                JSValueCachedData s9_ = this.jSValueCached_cache;
                while (s9_ != null) {
                    assert (s9_.cachedClass_ != null);
                    if ((s9_.cachedClass_ == operandNodeValue.getClass())) {
                        return JSIsNullOrUndefinedNode.doJSValueCached(operandNodeValue, s9_.cachedClass_);
                    }
                    s9_ = s9_.next_;
                }
            }
            if ((state & 0b1000000000) != 0 /* is-active doJSValue(Object) */) {
                if ((!(JSGuards.isTruffleObject(operandNodeValue)))) {
                    return JSIsNullOrUndefinedNode.doJSValue(operandNodeValue);
                }
            }
            if ((state & 0b10000000000) != 0 /* is-active doForeign(Object, InteropLibrary) */) {
                Foreign0Data s11_ = this.foreign0_cache;
                while (s11_ != null) {
                    if ((s11_.interop_.accepts(operandNodeValue)) && (JSGuards.isForeignObject(operandNodeValue))) {
                        return doForeign(operandNodeValue, s11_.interop_);
                    }
                    s11_ = s11_.next_;
                }
            }
            if ((state & 0b100000000000) != 0 /* is-active doForeign(Object, InteropLibrary) */) {
                if ((JSGuards.isForeignObject(operandNodeValue))) {
                    return this.foreign1Boundary0(state, operandNodeValue);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue);
    }

    @TruffleBoundary
    private boolean foreign1Boundary0(int state, Object operandNodeValue) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary foreign1_interop__ = (INTEROP_LIBRARY_.getUncached(operandNodeValue));
                return doForeign(operandNodeValue, foreign1_interop__);
            }
        } finally {
            encapsulating_.set(prev_);
        }
    }

    @ExplodeLoop
    @Override
    public Object execute(VirtualFrame frameValue) {
        int state = state_;
        Object operandNodeValue_ = super.operandNode.execute(frameValue);
        if ((state & 0b11) != 0 /* is-active doNull(Object) || doUndefined(Object) */) {
            if ((state & 0b1) != 0 /* is-active doNull(Object) */) {
                if ((JSGuards.isJSNull(operandNodeValue_))) {
                    return JSIsNullOrUndefinedNode.doNull(operandNodeValue_);
                }
            }
            if ((state & 0b10) != 0 /* is-active doUndefined(Object) */) {
                if ((JSGuards.isUndefined(operandNodeValue_))) {
                    return JSIsNullOrUndefinedNode.doUndefined(operandNodeValue_);
                }
            }
        }
        if ((state & 0b100) != 0 /* is-active doSymbol(Symbol) */ && operandNodeValue_ instanceof Symbol) {
            Symbol operandNodeValue__ = (Symbol) operandNodeValue_;
            return JSIsNullOrUndefinedNode.doSymbol(operandNodeValue__);
        }
        if ((state & 0b1000) != 0 /* is-active doLazyString(JSLazyString) */ && operandNodeValue_ instanceof JSLazyString) {
            JSLazyString operandNodeValue__ = (JSLazyString) operandNodeValue_;
            return JSIsNullOrUndefinedNode.doLazyString(operandNodeValue__);
        }
        if ((state & 0b10000) != 0 /* is-active doSafeInteger(SafeInteger) */ && operandNodeValue_ instanceof SafeInteger) {
            SafeInteger operandNodeValue__ = (SafeInteger) operandNodeValue_;
            return JSIsNullOrUndefinedNode.doSafeInteger(operandNodeValue__);
        }
        if ((state & 0b100000) != 0 /* is-active doBigInt(BigInt) */ && operandNodeValue_ instanceof BigInt) {
            BigInt operandNodeValue__ = (BigInt) operandNodeValue_;
            return JSIsNullOrUndefinedNode.doBigInt(operandNodeValue__);
        }
        if ((state & 0b111111000000) != 0 /* is-active doJSObjectCached(Object, Class<>) || doJSObject(Object) || doJSValueCached(Object, Class<>) || doJSValue(Object) || doForeign(Object, InteropLibrary) || doForeign(Object, InteropLibrary) */) {
            if ((state & 0b1000000) != 0 /* is-active doJSObjectCached(Object, Class<>) */) {
                assert (this.jSObjectCached_cachedClass_ != null);
                if ((this.jSObjectCached_cachedClass_.isInstance(operandNodeValue_))) {
                    return JSIsNullOrUndefinedNode.doJSObjectCached(operandNodeValue_, this.jSObjectCached_cachedClass_);
                }
            }
            if ((state & 0b10000000) != 0 /* is-active doJSObject(Object) */) {
                if ((JSGuards.isJSObject(operandNodeValue_))) {
                    return JSIsNullOrUndefinedNode.doJSObject(operandNodeValue_);
                }
            }
            if ((state & 0b100000000) != 0 /* is-active doJSValueCached(Object, Class<>) */ && (operandNodeValue_ != null)) {
                JSValueCachedData s9_ = this.jSValueCached_cache;
                while (s9_ != null) {
                    assert (s9_.cachedClass_ != null);
                    if ((s9_.cachedClass_ == operandNodeValue_.getClass())) {
                        return JSIsNullOrUndefinedNode.doJSValueCached(operandNodeValue_, s9_.cachedClass_);
                    }
                    s9_ = s9_.next_;
                }
            }
            if ((state & 0b1000000000) != 0 /* is-active doJSValue(Object) */) {
                if ((!(JSGuards.isTruffleObject(operandNodeValue_)))) {
                    return JSIsNullOrUndefinedNode.doJSValue(operandNodeValue_);
                }
            }
            if ((state & 0b10000000000) != 0 /* is-active doForeign(Object, InteropLibrary) */) {
                Foreign0Data s11_ = this.foreign0_cache;
                while (s11_ != null) {
                    if ((s11_.interop_.accepts(operandNodeValue_)) && (JSGuards.isForeignObject(operandNodeValue_))) {
                        return doForeign(operandNodeValue_, s11_.interop_);
                    }
                    s11_ = s11_.next_;
                }
            }
            if ((state & 0b100000000000) != 0 /* is-active doForeign(Object, InteropLibrary) */) {
                if ((JSGuards.isForeignObject(operandNodeValue_))) {
                    return this.foreign1Boundary1(state, operandNodeValue_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue_);
    }

    @TruffleBoundary
    private Object foreign1Boundary1(int state, Object operandNodeValue_) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary foreign1_interop__ = (INTEROP_LIBRARY_.getUncached(operandNodeValue_));
                return doForeign(operandNodeValue_, foreign1_interop__);
            }
        } finally {
            encapsulating_.set(prev_);
        }
    }

    @ExplodeLoop
    @Override
    public boolean executeBoolean(VirtualFrame frameValue) {
        int state = state_;
        Object operandNodeValue_ = super.operandNode.execute(frameValue);
        if ((state & 0b11) != 0 /* is-active doNull(Object) || doUndefined(Object) */) {
            if ((state & 0b1) != 0 /* is-active doNull(Object) */) {
                if ((JSGuards.isJSNull(operandNodeValue_))) {
                    return JSIsNullOrUndefinedNode.doNull(operandNodeValue_);
                }
            }
            if ((state & 0b10) != 0 /* is-active doUndefined(Object) */) {
                if ((JSGuards.isUndefined(operandNodeValue_))) {
                    return JSIsNullOrUndefinedNode.doUndefined(operandNodeValue_);
                }
            }
        }
        if ((state & 0b100) != 0 /* is-active doSymbol(Symbol) */ && operandNodeValue_ instanceof Symbol) {
            Symbol operandNodeValue__ = (Symbol) operandNodeValue_;
            return JSIsNullOrUndefinedNode.doSymbol(operandNodeValue__);
        }
        if ((state & 0b1000) != 0 /* is-active doLazyString(JSLazyString) */ && operandNodeValue_ instanceof JSLazyString) {
            JSLazyString operandNodeValue__ = (JSLazyString) operandNodeValue_;
            return JSIsNullOrUndefinedNode.doLazyString(operandNodeValue__);
        }
        if ((state & 0b10000) != 0 /* is-active doSafeInteger(SafeInteger) */ && operandNodeValue_ instanceof SafeInteger) {
            SafeInteger operandNodeValue__ = (SafeInteger) operandNodeValue_;
            return JSIsNullOrUndefinedNode.doSafeInteger(operandNodeValue__);
        }
        if ((state & 0b100000) != 0 /* is-active doBigInt(BigInt) */ && operandNodeValue_ instanceof BigInt) {
            BigInt operandNodeValue__ = (BigInt) operandNodeValue_;
            return JSIsNullOrUndefinedNode.doBigInt(operandNodeValue__);
        }
        if ((state & 0b111111000000) != 0 /* is-active doJSObjectCached(Object, Class<>) || doJSObject(Object) || doJSValueCached(Object, Class<>) || doJSValue(Object) || doForeign(Object, InteropLibrary) || doForeign(Object, InteropLibrary) */) {
            if ((state & 0b1000000) != 0 /* is-active doJSObjectCached(Object, Class<>) */) {
                assert (this.jSObjectCached_cachedClass_ != null);
                if ((this.jSObjectCached_cachedClass_.isInstance(operandNodeValue_))) {
                    return JSIsNullOrUndefinedNode.doJSObjectCached(operandNodeValue_, this.jSObjectCached_cachedClass_);
                }
            }
            if ((state & 0b10000000) != 0 /* is-active doJSObject(Object) */) {
                if ((JSGuards.isJSObject(operandNodeValue_))) {
                    return JSIsNullOrUndefinedNode.doJSObject(operandNodeValue_);
                }
            }
            if ((state & 0b100000000) != 0 /* is-active doJSValueCached(Object, Class<>) */ && (operandNodeValue_ != null)) {
                JSValueCachedData s9_ = this.jSValueCached_cache;
                while (s9_ != null) {
                    assert (s9_.cachedClass_ != null);
                    if ((s9_.cachedClass_ == operandNodeValue_.getClass())) {
                        return JSIsNullOrUndefinedNode.doJSValueCached(operandNodeValue_, s9_.cachedClass_);
                    }
                    s9_ = s9_.next_;
                }
            }
            if ((state & 0b1000000000) != 0 /* is-active doJSValue(Object) */) {
                if ((!(JSGuards.isTruffleObject(operandNodeValue_)))) {
                    return JSIsNullOrUndefinedNode.doJSValue(operandNodeValue_);
                }
            }
            if ((state & 0b10000000000) != 0 /* is-active doForeign(Object, InteropLibrary) */) {
                Foreign0Data s11_ = this.foreign0_cache;
                while (s11_ != null) {
                    if ((s11_.interop_.accepts(operandNodeValue_)) && (JSGuards.isForeignObject(operandNodeValue_))) {
                        return doForeign(operandNodeValue_, s11_.interop_);
                    }
                    s11_ = s11_.next_;
                }
            }
            if ((state & 0b100000000000) != 0 /* is-active doForeign(Object, InteropLibrary) */) {
                if ((JSGuards.isForeignObject(operandNodeValue_))) {
                    return this.foreign1Boundary2(state, operandNodeValue_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue_);
    }

    @TruffleBoundary
    private boolean foreign1Boundary2(int state, Object operandNodeValue_) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary foreign1_interop__ = (INTEROP_LIBRARY_.getUncached(operandNodeValue_));
                return doForeign(operandNodeValue_, foreign1_interop__);
            }
        } finally {
            encapsulating_.set(prev_);
        }
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        executeBoolean(frameValue);
        return;
    }

    private boolean executeAndSpecialize(Object operandNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        int exclude = exclude_;
        try {
            if ((JSGuards.isJSNull(operandNodeValue))) {
                this.state_ = state = state | 0b1 /* add-active doNull(Object) */;
                lock.unlock();
                hasLock = false;
                return JSIsNullOrUndefinedNode.doNull(operandNodeValue);
            }
            if ((JSGuards.isUndefined(operandNodeValue))) {
                this.state_ = state = state | 0b10 /* add-active doUndefined(Object) */;
                lock.unlock();
                hasLock = false;
                return JSIsNullOrUndefinedNode.doUndefined(operandNodeValue);
            }
            if (operandNodeValue instanceof Symbol) {
                Symbol operandNodeValue_ = (Symbol) operandNodeValue;
                this.state_ = state = state | 0b100 /* add-active doSymbol(Symbol) */;
                lock.unlock();
                hasLock = false;
                return JSIsNullOrUndefinedNode.doSymbol(operandNodeValue_);
            }
            if (operandNodeValue instanceof JSLazyString) {
                JSLazyString operandNodeValue_ = (JSLazyString) operandNodeValue;
                this.state_ = state = state | 0b1000 /* add-active doLazyString(JSLazyString) */;
                lock.unlock();
                hasLock = false;
                return JSIsNullOrUndefinedNode.doLazyString(operandNodeValue_);
            }
            if (operandNodeValue instanceof SafeInteger) {
                SafeInteger operandNodeValue_ = (SafeInteger) operandNodeValue;
                this.state_ = state = state | 0b10000 /* add-active doSafeInteger(SafeInteger) */;
                lock.unlock();
                hasLock = false;
                return JSIsNullOrUndefinedNode.doSafeInteger(operandNodeValue_);
            }
            if (operandNodeValue instanceof BigInt) {
                BigInt operandNodeValue_ = (BigInt) operandNodeValue;
                this.state_ = state = state | 0b100000 /* add-active doBigInt(BigInt) */;
                lock.unlock();
                hasLock = false;
                return JSIsNullOrUndefinedNode.doBigInt(operandNodeValue_);
            }
            if (((exclude & 0b1)) == 0 /* is-not-excluded doJSObjectCached(Object, Class<>) */) {
                boolean JSObjectCached_duplicateFound_ = false;
                if ((state & 0b1000000) != 0 /* is-active doJSObjectCached(Object, Class<>) */) {
                    assert (this.jSObjectCached_cachedClass_ != null);
                    if ((this.jSObjectCached_cachedClass_.isInstance(operandNodeValue))) {
                        JSObjectCached_duplicateFound_ = true;
                    }
                }
                if (!JSObjectCached_duplicateFound_) {
                    {
                        Class<?> jSObjectCached_cachedClass__ = (JSGuards.getClassIfJSObject(operandNodeValue));
                        if ((jSObjectCached_cachedClass__ != null) && (jSObjectCached_cachedClass__.isInstance(operandNodeValue)) && ((state & 0b1000000)) == 0 /* is-not-active doJSObjectCached(Object, Class<>) */) {
                            this.jSObjectCached_cachedClass_ = jSObjectCached_cachedClass__;
                            this.state_ = state = state | 0b1000000 /* add-active doJSObjectCached(Object, Class<>) */;
                            JSObjectCached_duplicateFound_ = true;
                        }
                    }
                }
                if (JSObjectCached_duplicateFound_) {
                    lock.unlock();
                    hasLock = false;
                    return JSIsNullOrUndefinedNode.doJSObjectCached(operandNodeValue, this.jSObjectCached_cachedClass_);
                }
            }
            if ((JSGuards.isJSObject(operandNodeValue))) {
                this.exclude_ = exclude = exclude | 0b1 /* add-excluded doJSObjectCached(Object, Class<>) */;
                state = state & 0xffffffbf /* remove-active doJSObjectCached(Object, Class<>) */;
                this.state_ = state = state | 0b10000000 /* add-active doJSObject(Object) */;
                lock.unlock();
                hasLock = false;
                return JSIsNullOrUndefinedNode.doJSObject(operandNodeValue);
            }
            if (((exclude & 0b10)) == 0 /* is-not-excluded doJSValueCached(Object, Class<>) */ && (operandNodeValue != null)) {
                int count9_ = 0;
                JSValueCachedData s9_ = this.jSValueCached_cache;
                if ((state & 0b100000000) != 0 /* is-active doJSValueCached(Object, Class<>) */) {
                    while (s9_ != null) {
                        assert (s9_.cachedClass_ != null);
                        if ((s9_.cachedClass_ == operandNodeValue.getClass())) {
                            break;
                        }
                        s9_ = s9_.next_;
                        count9_++;
                    }
                }
                if (s9_ == null) {
                    {
                        Class<?> cachedClass__ = (JSGuards.getNonTruffleObjectClass(operandNodeValue));
                        if ((cachedClass__ != null) && (cachedClass__ == operandNodeValue.getClass()) && count9_ < (JSIsNullOrUndefinedNode.MAX_CLASSES)) {
                            s9_ = new JSValueCachedData(jSValueCached_cache);
                            s9_.cachedClass_ = cachedClass__;
                            this.jSValueCached_cache = s9_;
                            this.state_ = state = state | 0b100000000 /* add-active doJSValueCached(Object, Class<>) */;
                        }
                    }
                }
                if (s9_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return JSIsNullOrUndefinedNode.doJSValueCached(operandNodeValue, s9_.cachedClass_);
                }
            }
            if ((!(JSGuards.isTruffleObject(operandNodeValue)))) {
                this.exclude_ = exclude = exclude | 0b10 /* add-excluded doJSValueCached(Object, Class<>) */;
                this.jSValueCached_cache = null;
                state = state & 0xfffffeff /* remove-active doJSValueCached(Object, Class<>) */;
                this.state_ = state = state | 0b1000000000 /* add-active doJSValue(Object) */;
                lock.unlock();
                hasLock = false;
                return JSIsNullOrUndefinedNode.doJSValue(operandNodeValue);
            }
            if (((exclude & 0b100)) == 0 /* is-not-excluded doForeign(Object, InteropLibrary) */) {
                int count11_ = 0;
                Foreign0Data s11_ = this.foreign0_cache;
                if ((state & 0b10000000000) != 0 /* is-active doForeign(Object, InteropLibrary) */) {
                    while (s11_ != null) {
                        if ((s11_.interop_.accepts(operandNodeValue)) && (JSGuards.isForeignObject(operandNodeValue))) {
                            break;
                        }
                        s11_ = s11_.next_;
                        count11_++;
                    }
                }
                if (s11_ == null) {
                    if ((JSGuards.isForeignObject(operandNodeValue)) && count11_ < (5)) {
                        // assert (s11_.interop_.accepts(operandNodeValue));
                        s11_ = super.insert(new Foreign0Data(foreign0_cache));
                        s11_.interop_ = s11_.insertAccessor((INTEROP_LIBRARY_.create(operandNodeValue)));
                        this.foreign0_cache = s11_;
                        this.state_ = state = state | 0b10000000000 /* add-active doForeign(Object, InteropLibrary) */;
                    }
                }
                if (s11_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return doForeign(operandNodeValue, s11_.interop_);
                }
            }
            {
                InteropLibrary foreign1_interop__ = null;
                {
                    EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                    Node prev_ = encapsulating_.set(this);
                    try {
                        if ((JSGuards.isForeignObject(operandNodeValue))) {
                            foreign1_interop__ = (INTEROP_LIBRARY_.getUncached(operandNodeValue));
                            this.exclude_ = exclude = exclude | 0b100 /* add-excluded doForeign(Object, InteropLibrary) */;
                            this.foreign0_cache = null;
                            state = state & 0xfffffbff /* remove-active doForeign(Object, InteropLibrary) */;
                            this.state_ = state = state | 0b100000000000 /* add-active doForeign(Object, InteropLibrary) */;
                            lock.unlock();
                            hasLock = false;
                            return doForeign(operandNodeValue, foreign1_interop__);
                        }
                    } finally {
                        encapsulating_.set(prev_);
                    }
                }
            }
            throw new UnsupportedSpecializationException(this, new Node[] {super.operandNode}, operandNodeValue);
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
            JSValueCachedData s9_ = this.jSValueCached_cache;
            Foreign0Data s11_ = this.foreign0_cache;
            if ((s9_ == null || s9_.next_ == null) && (s11_ == null || s11_.next_ == null)) {
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
        s[0] = "doSymbol";
        if ((state & 0b100) != 0 /* is-active doSymbol(Symbol) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doLazyString";
        if ((state & 0b1000) != 0 /* is-active doLazyString(JSLazyString) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doSafeInteger";
        if ((state & 0b10000) != 0 /* is-active doSafeInteger(SafeInteger) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "doBigInt";
        if ((state & 0b100000) != 0 /* is-active doBigInt(BigInt) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "doJSObjectCached";
        if ((state & 0b1000000) != 0 /* is-active doJSObjectCached(Object, Class<>) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.jSObjectCached_cachedClass_));
            s[2] = cached;
        } else if ((exclude & 0b1) != 0 /* is-excluded doJSObjectCached(Object, Class<>) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        s = new Object[3];
        s[0] = "doJSObject";
        if ((state & 0b10000000) != 0 /* is-active doJSObject(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[8] = s;
        s = new Object[3];
        s[0] = "doJSValueCached";
        if ((state & 0b100000000) != 0 /* is-active doJSValueCached(Object, Class<>) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            JSValueCachedData s9_ = this.jSValueCached_cache;
            while (s9_ != null) {
                cached.add(Arrays.asList(s9_.cachedClass_));
                s9_ = s9_.next_;
            }
            s[2] = cached;
        } else if ((exclude & 0b10) != 0 /* is-excluded doJSValueCached(Object, Class<>) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[9] = s;
        s = new Object[3];
        s[0] = "doJSValue";
        if ((state & 0b1000000000) != 0 /* is-active doJSValue(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[10] = s;
        s = new Object[3];
        s[0] = "doForeign";
        if ((state & 0b10000000000) != 0 /* is-active doForeign(Object, InteropLibrary) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            Foreign0Data s11_ = this.foreign0_cache;
            while (s11_ != null) {
                cached.add(Arrays.asList(s11_.interop_));
                s11_ = s11_.next_;
            }
            s[2] = cached;
        } else if ((exclude & 0b100) != 0 /* is-excluded doForeign(Object, InteropLibrary) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[11] = s;
        s = new Object[3];
        s[0] = "doForeign";
        if ((state & 0b100000000000) != 0 /* is-active doForeign(Object, InteropLibrary) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList());
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[12] = s;
        return Provider.create(data);
    }

    public static JSIsNullOrUndefinedNode create(JavaScriptNode operand, boolean isUndefined, boolean isLeft) {
        return new JSIsNullOrUndefinedNodeGen(operand, isUndefined, isLeft);
    }

    @GeneratedBy(JSIsNullOrUndefinedNode.class)
    private static final class JSValueCachedData {

        @CompilationFinal JSValueCachedData next_;
        @CompilationFinal Class<?> cachedClass_;

        JSValueCachedData(JSValueCachedData next_) {
            this.next_ = next_;
        }

    }
    @GeneratedBy(JSIsNullOrUndefinedNode.class)
    private static final class Foreign0Data extends Node {

        @Child Foreign0Data next_;
        @Child InteropLibrary interop_;

        Foreign0Data(Foreign0Data next_) {
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
