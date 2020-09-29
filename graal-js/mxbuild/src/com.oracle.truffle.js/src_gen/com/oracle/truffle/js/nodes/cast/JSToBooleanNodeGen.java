// CheckStyle: start generated
package com.oracle.truffle.js.nodes.cast;

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
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.api.object.DynamicObject;
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

@GeneratedBy(JSToBooleanNode.class)
@SuppressWarnings("unused")
public final class JSToBooleanNodeGen extends JSToBooleanNode implements Provider {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @Child private ForeignObject0Data foreignObject0_cache;

    private JSToBooleanNodeGen(JavaScriptNode operand) {
        super(operand);
    }

    @ExplodeLoop
    @Override
    public Object execute(VirtualFrame frameValue, Object operandNodeValue) {
        int state = state_;
        if ((state & 0b1) != 0 /* is-active doBoolean(boolean) */ && operandNodeValue instanceof Boolean) {
            boolean operandNodeValue_ = (boolean) operandNodeValue;
            return doBoolean(operandNodeValue_);
        }
        if ((state & 0b110) != 0 /* is-active doNull(Object) || doUndefined(Object) */) {
            if ((state & 0b10) != 0 /* is-active doNull(Object) */) {
                if ((JSGuards.isJSNull(operandNodeValue))) {
                    return doNull(operandNodeValue);
                }
            }
            if ((state & 0b100) != 0 /* is-active doUndefined(Object) */) {
                if ((JSGuards.isUndefined(operandNodeValue))) {
                    return doUndefined(operandNodeValue);
                }
            }
        }
        if ((state & 0b1000) != 0 /* is-active doInt(int) */ && operandNodeValue instanceof Integer) {
            int operandNodeValue_ = (int) operandNodeValue;
            return doInt(operandNodeValue_);
        }
        if ((state & 0b10000) != 0 /* is-active doLong(long) */ && operandNodeValue instanceof Long) {
            long operandNodeValue_ = (long) operandNodeValue;
            return doLong(operandNodeValue_);
        }
        if ((state & 0b100000) != 0 /* is-active doDouble(double) */ && JSTypesGen.isImplicitDouble((state & 0x1e000) >>> 13 /* extract-implicit-active 0:double */, operandNodeValue)) {
            double operandNodeValue_ = JSTypesGen.asImplicitDouble((state & 0x1e000) >>> 13 /* extract-implicit-active 0:double */, operandNodeValue);
            return doDouble(operandNodeValue_);
        }
        if ((state & 0b1000000) != 0 /* is-active doBigInt(BigInt) */ && operandNodeValue instanceof BigInt) {
            BigInt operandNodeValue_ = (BigInt) operandNodeValue;
            return doBigInt(operandNodeValue_);
        }
        if ((state & 0b10000000) != 0 /* is-active doLazyString(JSLazyString) */ && operandNodeValue instanceof JSLazyString) {
            JSLazyString operandNodeValue_ = (JSLazyString) operandNodeValue;
            return doLazyString(operandNodeValue_);
        }
        if ((state & 0b100000000) != 0 /* is-active doString(String) */ && JSTypesGen.isImplicitString((state & 0x1e0000) >>> 17 /* extract-implicit-active 0:String */, operandNodeValue)) {
            String operandNodeValue_ = JSTypesGen.asImplicitString((state & 0x1e0000) >>> 17 /* extract-implicit-active 0:String */, operandNodeValue);
            return doString(operandNodeValue_);
        }
        if ((state & 0b1000000000) != 0 /* is-active doObject(DynamicObject) */ && JSTypes.isDynamicObject(operandNodeValue)) {
            DynamicObject operandNodeValue_ = (DynamicObject) operandNodeValue;
            if ((JSGuards.isJSObject(operandNodeValue_))) {
                return doObject(operandNodeValue_);
            }
        }
        if ((state & 0b10000000000) != 0 /* is-active doSymbol(Symbol) */ && operandNodeValue instanceof Symbol) {
            Symbol operandNodeValue_ = (Symbol) operandNodeValue;
            return doSymbol(operandNodeValue_);
        }
        if ((state & 0b1100000000000) != 0 /* is-active doForeignObject(Object, InteropLibrary) || doForeignObject(Object, InteropLibrary) */) {
            if ((state & 0b100000000000) != 0 /* is-active doForeignObject(Object, InteropLibrary) */) {
                ForeignObject0Data s12_ = this.foreignObject0_cache;
                while (s12_ != null) {
                    if ((s12_.interop_.accepts(operandNodeValue)) && (JSRuntime.isForeignObject(operandNodeValue))) {
                        return doForeignObject(operandNodeValue, s12_.interop_);
                    }
                    s12_ = s12_.next_;
                }
            }
            if ((state & 0b1000000000000) != 0 /* is-active doForeignObject(Object, InteropLibrary) */) {
                if ((JSRuntime.isForeignObject(operandNodeValue))) {
                    return this.foreignObject1Boundary(state, operandNodeValue);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue);
    }

    @TruffleBoundary
    private Object foreignObject1Boundary(int state, Object operandNodeValue) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary foreignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(operandNodeValue));
                return doForeignObject(operandNodeValue, foreignObject1_interop__);
            }
        } finally {
            encapsulating_.set(prev_);
        }
    }

    @ExplodeLoop
    @Override
    public boolean executeBoolean(Object operandNodeValue) {
        int state = state_;
        if ((state & 0b1) != 0 /* is-active doBoolean(boolean) */ && operandNodeValue instanceof Boolean) {
            boolean operandNodeValue_ = (boolean) operandNodeValue;
            return doBoolean(operandNodeValue_);
        }
        if ((state & 0b110) != 0 /* is-active doNull(Object) || doUndefined(Object) */) {
            if ((state & 0b10) != 0 /* is-active doNull(Object) */) {
                if ((JSGuards.isJSNull(operandNodeValue))) {
                    return doNull(operandNodeValue);
                }
            }
            if ((state & 0b100) != 0 /* is-active doUndefined(Object) */) {
                if ((JSGuards.isUndefined(operandNodeValue))) {
                    return doUndefined(operandNodeValue);
                }
            }
        }
        if ((state & 0b1000) != 0 /* is-active doInt(int) */ && operandNodeValue instanceof Integer) {
            int operandNodeValue_ = (int) operandNodeValue;
            return doInt(operandNodeValue_);
        }
        if ((state & 0b10000) != 0 /* is-active doLong(long) */ && operandNodeValue instanceof Long) {
            long operandNodeValue_ = (long) operandNodeValue;
            return doLong(operandNodeValue_);
        }
        if ((state & 0b100000) != 0 /* is-active doDouble(double) */ && JSTypesGen.isImplicitDouble((state & 0x1e000) >>> 13 /* extract-implicit-active 0:double */, operandNodeValue)) {
            double operandNodeValue_ = JSTypesGen.asImplicitDouble((state & 0x1e000) >>> 13 /* extract-implicit-active 0:double */, operandNodeValue);
            return doDouble(operandNodeValue_);
        }
        if ((state & 0b1000000) != 0 /* is-active doBigInt(BigInt) */ && operandNodeValue instanceof BigInt) {
            BigInt operandNodeValue_ = (BigInt) operandNodeValue;
            return doBigInt(operandNodeValue_);
        }
        if ((state & 0b10000000) != 0 /* is-active doLazyString(JSLazyString) */ && operandNodeValue instanceof JSLazyString) {
            JSLazyString operandNodeValue_ = (JSLazyString) operandNodeValue;
            return doLazyString(operandNodeValue_);
        }
        if ((state & 0b100000000) != 0 /* is-active doString(String) */ && JSTypesGen.isImplicitString((state & 0x1e0000) >>> 17 /* extract-implicit-active 0:String */, operandNodeValue)) {
            String operandNodeValue_ = JSTypesGen.asImplicitString((state & 0x1e0000) >>> 17 /* extract-implicit-active 0:String */, operandNodeValue);
            return doString(operandNodeValue_);
        }
        if ((state & 0b1000000000) != 0 /* is-active doObject(DynamicObject) */ && JSTypes.isDynamicObject(operandNodeValue)) {
            DynamicObject operandNodeValue_ = (DynamicObject) operandNodeValue;
            if ((JSGuards.isJSObject(operandNodeValue_))) {
                return doObject(operandNodeValue_);
            }
        }
        if ((state & 0b10000000000) != 0 /* is-active doSymbol(Symbol) */ && operandNodeValue instanceof Symbol) {
            Symbol operandNodeValue_ = (Symbol) operandNodeValue;
            return doSymbol(operandNodeValue_);
        }
        if ((state & 0b1100000000000) != 0 /* is-active doForeignObject(Object, InteropLibrary) || doForeignObject(Object, InteropLibrary) */) {
            if ((state & 0b100000000000) != 0 /* is-active doForeignObject(Object, InteropLibrary) */) {
                ForeignObject0Data s12_ = this.foreignObject0_cache;
                while (s12_ != null) {
                    if ((s12_.interop_.accepts(operandNodeValue)) && (JSRuntime.isForeignObject(operandNodeValue))) {
                        return doForeignObject(operandNodeValue, s12_.interop_);
                    }
                    s12_ = s12_.next_;
                }
            }
            if ((state & 0b1000000000000) != 0 /* is-active doForeignObject(Object, InteropLibrary) */) {
                if ((JSRuntime.isForeignObject(operandNodeValue))) {
                    return this.foreignObject1Boundary0(state, operandNodeValue);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue);
    }

    @TruffleBoundary
    private boolean foreignObject1Boundary0(int state, Object operandNodeValue) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary foreignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(operandNodeValue));
                return doForeignObject(operandNodeValue, foreignObject1_interop__);
            }
        } finally {
            encapsulating_.set(prev_);
        }
    }

    @Override
    public boolean executeBoolean(VirtualFrame frameValue) {
        int state = state_;
        if ((state & 0b1111111111110) == 0 /* only-active doBoolean(boolean) */ && (state & 0b1111111111111) != 0  /* is-not doBoolean(boolean) && doNull(Object) && doUndefined(Object) && doInt(int) && doLong(long) && doDouble(double) && doBigInt(BigInt) && doLazyString(JSLazyString) && doString(String) && doObject(DynamicObject) && doSymbol(Symbol) && doForeignObject(Object, InteropLibrary) && doForeignObject(Object, InteropLibrary) */) {
            return executeBoolean_boolean0(frameValue, state);
        } else if ((state & 0b1111111110111) == 0 /* only-active doInt(int) */ && (state & 0b1111111111111) != 0  /* is-not doBoolean(boolean) && doNull(Object) && doUndefined(Object) && doInt(int) && doLong(long) && doDouble(double) && doBigInt(BigInt) && doLazyString(JSLazyString) && doString(String) && doObject(DynamicObject) && doSymbol(Symbol) && doForeignObject(Object, InteropLibrary) && doForeignObject(Object, InteropLibrary) */) {
            return executeBoolean_int1(frameValue, state);
        } else if ((state & 0b1111111101111) == 0 /* only-active doLong(long) */ && (state & 0b1111111111111) != 0  /* is-not doBoolean(boolean) && doNull(Object) && doUndefined(Object) && doInt(int) && doLong(long) && doDouble(double) && doBigInt(BigInt) && doLazyString(JSLazyString) && doString(String) && doObject(DynamicObject) && doSymbol(Symbol) && doForeignObject(Object, InteropLibrary) && doForeignObject(Object, InteropLibrary) */) {
            return executeBoolean_long2(frameValue, state);
        } else if ((state & 0b1111111011111) == 0 /* only-active doDouble(double) */ && (state & 0b1111111111111) != 0  /* is-not doBoolean(boolean) && doNull(Object) && doUndefined(Object) && doInt(int) && doLong(long) && doDouble(double) && doBigInt(BigInt) && doLazyString(JSLazyString) && doString(String) && doObject(DynamicObject) && doSymbol(Symbol) && doForeignObject(Object, InteropLibrary) && doForeignObject(Object, InteropLibrary) */) {
            return executeBoolean_double3(frameValue, state);
        } else {
            return executeBoolean_generic4(frameValue, state);
        }
    }

    private boolean executeBoolean_boolean0(VirtualFrame frameValue, int state) {
        boolean operandNodeValue_;
        try {
            operandNodeValue_ = super.operandNode.executeBoolean(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(ex.getResult());
        }
        assert (state & 0b1) != 0 /* is-active doBoolean(boolean) */;
        return doBoolean(operandNodeValue_);
    }

    private boolean executeBoolean_int1(VirtualFrame frameValue, int state) {
        int operandNodeValue_;
        try {
            operandNodeValue_ = super.operandNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(ex.getResult());
        }
        assert (state & 0b1000) != 0 /* is-active doInt(int) */;
        return doInt(operandNodeValue_);
    }

    private boolean executeBoolean_long2(VirtualFrame frameValue, int state) {
        long operandNodeValue_;
        try {
            operandNodeValue_ = super.operandNode.executeLong(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(ex.getResult());
        }
        assert (state & 0b10000) != 0 /* is-active doLong(long) */;
        return doLong(operandNodeValue_);
    }

    private boolean executeBoolean_double3(VirtualFrame frameValue, int state) {
        int operandNodeValue_int = 0;
        long operandNodeValue_long = 0L;
        double operandNodeValue_;
        try {
            if ((state & 0x1c000) == 0 /* only-active 0:double */ && (state & 0b1111111111111) != 0  /* is-not doBoolean(boolean) && doNull(Object) && doUndefined(Object) && doInt(int) && doLong(long) && doDouble(double) && doBigInt(BigInt) && doLazyString(JSLazyString) && doString(String) && doObject(DynamicObject) && doSymbol(Symbol) && doForeignObject(Object, InteropLibrary) && doForeignObject(Object, InteropLibrary) */) {
                operandNodeValue_long = super.operandNode.executeLong(frameValue);
                operandNodeValue_ = JSTypes.longToDouble(operandNodeValue_long);
            } else if ((state & 0x1a000) == 0 /* only-active 0:double */ && (state & 0b1111111111111) != 0  /* is-not doBoolean(boolean) && doNull(Object) && doUndefined(Object) && doInt(int) && doLong(long) && doDouble(double) && doBigInt(BigInt) && doLazyString(JSLazyString) && doString(String) && doObject(DynamicObject) && doSymbol(Symbol) && doForeignObject(Object, InteropLibrary) && doForeignObject(Object, InteropLibrary) */) {
                operandNodeValue_int = super.operandNode.executeInt(frameValue);
                operandNodeValue_ = JSTypes.intToDouble(operandNodeValue_int);
            } else if ((state & 0x16000) == 0 /* only-active 0:double */ && (state & 0b1111111111111) != 0  /* is-not doBoolean(boolean) && doNull(Object) && doUndefined(Object) && doInt(int) && doLong(long) && doDouble(double) && doBigInt(BigInt) && doLazyString(JSLazyString) && doString(String) && doObject(DynamicObject) && doSymbol(Symbol) && doForeignObject(Object, InteropLibrary) && doForeignObject(Object, InteropLibrary) */) {
                operandNodeValue_ = super.operandNode.executeDouble(frameValue);
            } else {
                Object operandNodeValue__ = super.operandNode.execute(frameValue);
                operandNodeValue_ = JSTypesGen.expectImplicitDouble((state & 0x1e000) >>> 13 /* extract-implicit-active 0:double */, operandNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(ex.getResult());
        }
        assert (state & 0b100000) != 0 /* is-active doDouble(double) */;
        return doDouble(operandNodeValue_);
    }

    @TruffleBoundary
    private boolean foreignObject1Boundary1(int state, Object operandNodeValue_) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary foreignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(operandNodeValue_));
                return doForeignObject(operandNodeValue_, foreignObject1_interop__);
            }
        } finally {
            encapsulating_.set(prev_);
        }
    }

    @ExplodeLoop
    private boolean executeBoolean_generic4(VirtualFrame frameValue, int state) {
        Object operandNodeValue_ = super.operandNode.execute(frameValue);
        if ((state & 0b1) != 0 /* is-active doBoolean(boolean) */ && operandNodeValue_ instanceof Boolean) {
            boolean operandNodeValue__ = (boolean) operandNodeValue_;
            return doBoolean(operandNodeValue__);
        }
        if ((state & 0b110) != 0 /* is-active doNull(Object) || doUndefined(Object) */) {
            if ((state & 0b10) != 0 /* is-active doNull(Object) */) {
                if ((JSGuards.isJSNull(operandNodeValue_))) {
                    return doNull(operandNodeValue_);
                }
            }
            if ((state & 0b100) != 0 /* is-active doUndefined(Object) */) {
                if ((JSGuards.isUndefined(operandNodeValue_))) {
                    return doUndefined(operandNodeValue_);
                }
            }
        }
        if ((state & 0b1000) != 0 /* is-active doInt(int) */ && operandNodeValue_ instanceof Integer) {
            int operandNodeValue__ = (int) operandNodeValue_;
            return doInt(operandNodeValue__);
        }
        if ((state & 0b10000) != 0 /* is-active doLong(long) */ && operandNodeValue_ instanceof Long) {
            long operandNodeValue__ = (long) operandNodeValue_;
            return doLong(operandNodeValue__);
        }
        if ((state & 0b100000) != 0 /* is-active doDouble(double) */ && JSTypesGen.isImplicitDouble((state & 0x1e000) >>> 13 /* extract-implicit-active 0:double */, operandNodeValue_)) {
            double operandNodeValue__ = JSTypesGen.asImplicitDouble((state & 0x1e000) >>> 13 /* extract-implicit-active 0:double */, operandNodeValue_);
            return doDouble(operandNodeValue__);
        }
        if ((state & 0b1000000) != 0 /* is-active doBigInt(BigInt) */ && operandNodeValue_ instanceof BigInt) {
            BigInt operandNodeValue__ = (BigInt) operandNodeValue_;
            return doBigInt(operandNodeValue__);
        }
        if ((state & 0b10000000) != 0 /* is-active doLazyString(JSLazyString) */ && operandNodeValue_ instanceof JSLazyString) {
            JSLazyString operandNodeValue__ = (JSLazyString) operandNodeValue_;
            return doLazyString(operandNodeValue__);
        }
        if ((state & 0b100000000) != 0 /* is-active doString(String) */ && JSTypesGen.isImplicitString((state & 0x1e0000) >>> 17 /* extract-implicit-active 0:String */, operandNodeValue_)) {
            String operandNodeValue__ = JSTypesGen.asImplicitString((state & 0x1e0000) >>> 17 /* extract-implicit-active 0:String */, operandNodeValue_);
            return doString(operandNodeValue__);
        }
        if ((state & 0b1000000000) != 0 /* is-active doObject(DynamicObject) */ && JSTypes.isDynamicObject(operandNodeValue_)) {
            DynamicObject operandNodeValue__ = (DynamicObject) operandNodeValue_;
            if ((JSGuards.isJSObject(operandNodeValue__))) {
                return doObject(operandNodeValue__);
            }
        }
        if ((state & 0b10000000000) != 0 /* is-active doSymbol(Symbol) */ && operandNodeValue_ instanceof Symbol) {
            Symbol operandNodeValue__ = (Symbol) operandNodeValue_;
            return doSymbol(operandNodeValue__);
        }
        if ((state & 0b1100000000000) != 0 /* is-active doForeignObject(Object, InteropLibrary) || doForeignObject(Object, InteropLibrary) */) {
            if ((state & 0b100000000000) != 0 /* is-active doForeignObject(Object, InteropLibrary) */) {
                ForeignObject0Data s12_ = this.foreignObject0_cache;
                while (s12_ != null) {
                    if ((s12_.interop_.accepts(operandNodeValue_)) && (JSRuntime.isForeignObject(operandNodeValue_))) {
                        return doForeignObject(operandNodeValue_, s12_.interop_);
                    }
                    s12_ = s12_.next_;
                }
            }
            if ((state & 0b1000000000000) != 0 /* is-active doForeignObject(Object, InteropLibrary) */) {
                if ((JSRuntime.isForeignObject(operandNodeValue_))) {
                    return this.foreignObject1Boundary1(state, operandNodeValue_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue_);
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
            if (operandNodeValue instanceof Boolean) {
                boolean operandNodeValue_ = (boolean) operandNodeValue;
                this.state_ = state = state | 0b1 /* add-active doBoolean(boolean) */;
                lock.unlock();
                hasLock = false;
                return doBoolean(operandNodeValue_);
            }
            if ((JSGuards.isJSNull(operandNodeValue))) {
                this.state_ = state = state | 0b10 /* add-active doNull(Object) */;
                lock.unlock();
                hasLock = false;
                return doNull(operandNodeValue);
            }
            if ((JSGuards.isUndefined(operandNodeValue))) {
                this.state_ = state = state | 0b100 /* add-active doUndefined(Object) */;
                lock.unlock();
                hasLock = false;
                return doUndefined(operandNodeValue);
            }
            if (operandNodeValue instanceof Integer) {
                int operandNodeValue_ = (int) operandNodeValue;
                this.state_ = state = state | 0b1000 /* add-active doInt(int) */;
                lock.unlock();
                hasLock = false;
                return doInt(operandNodeValue_);
            }
            if (operandNodeValue instanceof Long) {
                long operandNodeValue_ = (long) operandNodeValue;
                this.state_ = state = state | 0b10000 /* add-active doLong(long) */;
                lock.unlock();
                hasLock = false;
                return doLong(operandNodeValue_);
            }
            {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(operandNodeValue)) != 0) {
                    double operandNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast0, operandNodeValue);
                    state = (state | (doubleCast0 << 13) /* set-implicit-active 0:double */);
                    this.state_ = state = state | 0b100000 /* add-active doDouble(double) */;
                    lock.unlock();
                    hasLock = false;
                    return doDouble(operandNodeValue_);
                }
            }
            if (operandNodeValue instanceof BigInt) {
                BigInt operandNodeValue_ = (BigInt) operandNodeValue;
                this.state_ = state = state | 0b1000000 /* add-active doBigInt(BigInt) */;
                lock.unlock();
                hasLock = false;
                return doBigInt(operandNodeValue_);
            }
            if (operandNodeValue instanceof JSLazyString) {
                JSLazyString operandNodeValue_ = (JSLazyString) operandNodeValue;
                this.state_ = state = state | 0b10000000 /* add-active doLazyString(JSLazyString) */;
                lock.unlock();
                hasLock = false;
                return doLazyString(operandNodeValue_);
            }
            {
                int stringCast0;
                if ((stringCast0 = JSTypesGen.specializeImplicitString(operandNodeValue)) != 0) {
                    String operandNodeValue_ = JSTypesGen.asImplicitString(stringCast0, operandNodeValue);
                    state = (state | (stringCast0 << 17) /* set-implicit-active 0:String */);
                    this.state_ = state = state | 0b100000000 /* add-active doString(String) */;
                    lock.unlock();
                    hasLock = false;
                    return doString(operandNodeValue_);
                }
            }
            if (JSTypes.isDynamicObject(operandNodeValue)) {
                DynamicObject operandNodeValue_ = (DynamicObject) operandNodeValue;
                if ((JSGuards.isJSObject(operandNodeValue_))) {
                    this.state_ = state = state | 0b1000000000 /* add-active doObject(DynamicObject) */;
                    lock.unlock();
                    hasLock = false;
                    return doObject(operandNodeValue_);
                }
            }
            if (operandNodeValue instanceof Symbol) {
                Symbol operandNodeValue_ = (Symbol) operandNodeValue;
                this.state_ = state = state | 0b10000000000 /* add-active doSymbol(Symbol) */;
                lock.unlock();
                hasLock = false;
                return doSymbol(operandNodeValue_);
            }
            if ((exclude) == 0 /* is-not-excluded doForeignObject(Object, InteropLibrary) */) {
                int count12_ = 0;
                ForeignObject0Data s12_ = this.foreignObject0_cache;
                if ((state & 0b100000000000) != 0 /* is-active doForeignObject(Object, InteropLibrary) */) {
                    while (s12_ != null) {
                        if ((s12_.interop_.accepts(operandNodeValue)) && (JSRuntime.isForeignObject(operandNodeValue))) {
                            break;
                        }
                        s12_ = s12_.next_;
                        count12_++;
                    }
                }
                if (s12_ == null) {
                    if ((JSRuntime.isForeignObject(operandNodeValue)) && count12_ < (5)) {
                        // assert (s12_.interop_.accepts(operandNodeValue));
                        s12_ = super.insert(new ForeignObject0Data(foreignObject0_cache));
                        s12_.interop_ = s12_.insertAccessor((INTEROP_LIBRARY_.create(operandNodeValue)));
                        this.foreignObject0_cache = s12_;
                        this.state_ = state = state | 0b100000000000 /* add-active doForeignObject(Object, InteropLibrary) */;
                    }
                }
                if (s12_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return doForeignObject(operandNodeValue, s12_.interop_);
                }
            }
            {
                InteropLibrary foreignObject1_interop__ = null;
                {
                    EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                    Node prev_ = encapsulating_.set(this);
                    try {
                        if ((JSRuntime.isForeignObject(operandNodeValue))) {
                            foreignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(operandNodeValue));
                            this.exclude_ = exclude = exclude | 0b1 /* add-excluded doForeignObject(Object, InteropLibrary) */;
                            this.foreignObject0_cache = null;
                            state = state & 0xfffff7ff /* remove-active doForeignObject(Object, InteropLibrary) */;
                            this.state_ = state = state | 0b1000000000000 /* add-active doForeignObject(Object, InteropLibrary) */;
                            lock.unlock();
                            hasLock = false;
                            return doForeignObject(operandNodeValue, foreignObject1_interop__);
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
        s[0] = "doBoolean";
        if ((state & 0b1) != 0 /* is-active doBoolean(boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doNull";
        if ((state & 0b10) != 0 /* is-active doNull(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doUndefined";
        if ((state & 0b100) != 0 /* is-active doUndefined(Object) */) {
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
        s[0] = "doDouble";
        if ((state & 0b100000) != 0 /* is-active doDouble(double) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "doBigInt";
        if ((state & 0b1000000) != 0 /* is-active doBigInt(BigInt) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        s = new Object[3];
        s[0] = "doLazyString";
        if ((state & 0b10000000) != 0 /* is-active doLazyString(JSLazyString) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[8] = s;
        s = new Object[3];
        s[0] = "doString";
        if ((state & 0b100000000) != 0 /* is-active doString(String) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[9] = s;
        s = new Object[3];
        s[0] = "doObject";
        if ((state & 0b1000000000) != 0 /* is-active doObject(DynamicObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[10] = s;
        s = new Object[3];
        s[0] = "doSymbol";
        if ((state & 0b10000000000) != 0 /* is-active doSymbol(Symbol) */) {
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

    public static JSToBooleanNode create(JavaScriptNode operand) {
        return new JSToBooleanNodeGen(operand);
    }

    @GeneratedBy(JSToBooleanNode.class)
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
