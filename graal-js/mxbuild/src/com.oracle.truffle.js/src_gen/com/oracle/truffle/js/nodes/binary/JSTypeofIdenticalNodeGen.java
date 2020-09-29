// CheckStyle: start generated
package com.oracle.truffle.js.nodes.binary;

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
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.runtime.BigInt;
import com.oracle.truffle.js.runtime.SafeInteger;
import com.oracle.truffle.js.runtime.Symbol;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSTypeofIdenticalNode.class)
@SuppressWarnings("unused")
public final class JSTypeofIdenticalNodeGen extends JSTypeofIdenticalNode implements Provider {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private BranchProfile jSType_proxyBranch_;
    @Child private ForeignObject0Data foreignObject0_cache;

    private JSTypeofIdenticalNodeGen(JavaScriptNode childNode, Type type) {
        super(childNode, type);
    }

    @ExplodeLoop
    @Override
    public Object execute(VirtualFrame frameValue, Object operandNodeValue) {
        int state = state_;
        if ((state & 0b1) != 0 /* is-active doBoolean(boolean) */ && operandNodeValue instanceof Boolean) {
            boolean operandNodeValue_ = (boolean) operandNodeValue;
            return doBoolean(operandNodeValue_);
        }
        if ((state & 0b10) != 0 /* is-active doNumber(int) */ && operandNodeValue instanceof Integer) {
            int operandNodeValue_ = (int) operandNodeValue;
            return doNumber(operandNodeValue_);
        }
        if ((state & 0b100) != 0 /* is-active doNumber(SafeInteger) */ && operandNodeValue instanceof SafeInteger) {
            SafeInteger operandNodeValue_ = (SafeInteger) operandNodeValue;
            return doNumber(operandNodeValue_);
        }
        if ((state & 0b1000) != 0 /* is-active doNumber(long) */ && operandNodeValue instanceof Long) {
            long operandNodeValue_ = (long) operandNodeValue;
            return doNumber(operandNodeValue_);
        }
        if ((state & 0b10000) != 0 /* is-active doNumber(double) */ && JSTypesGen.isImplicitDouble((state & 0b111100000000000) >>> 11 /* extract-implicit-active 0:double */, operandNodeValue)) {
            double operandNodeValue_ = JSTypesGen.asImplicitDouble((state & 0b111100000000000) >>> 11 /* extract-implicit-active 0:double */, operandNodeValue);
            return doNumber(operandNodeValue_);
        }
        if ((state & 0b100000) != 0 /* is-active doSymbol(Symbol) */ && operandNodeValue instanceof Symbol) {
            Symbol operandNodeValue_ = (Symbol) operandNodeValue;
            return doSymbol(operandNodeValue_);
        }
        if ((state & 0b1000000) != 0 /* is-active doBigInt(BigInt) */ && operandNodeValue instanceof BigInt) {
            BigInt operandNodeValue_ = (BigInt) operandNodeValue;
            return doBigInt(operandNodeValue_);
        }
        if ((state & 0b10000000) != 0 /* is-active doString(CharSequence) */ && JSTypesGen.isImplicitCharSequence((state & 0x78000) >>> 15 /* extract-implicit-active 0:CharSequence */, operandNodeValue)) {
            CharSequence operandNodeValue_ = JSTypesGen.asImplicitCharSequence((state & 0x78000) >>> 15 /* extract-implicit-active 0:CharSequence */, operandNodeValue);
            return doString(operandNodeValue_);
        }
        if ((state & 0b100000000) != 0 /* is-active doJSType(DynamicObject, BranchProfile) */ && JSTypes.isDynamicObject(operandNodeValue)) {
            DynamicObject operandNodeValue_ = (DynamicObject) operandNodeValue;
            if ((JSGuards.isJSDynamicObject(operandNodeValue_))) {
                return doJSType(operandNodeValue_, this.jSType_proxyBranch_);
            }
        }
        if ((state & 0b11000000000) != 0 /* is-active doForeignObject(Object, InteropLibrary) || doForeignObject(Object, InteropLibrary) */) {
            if ((state & 0b1000000000) != 0 /* is-active doForeignObject(Object, InteropLibrary) */) {
                ForeignObject0Data s10_ = this.foreignObject0_cache;
                while (s10_ != null) {
                    if ((s10_.interop_.accepts(operandNodeValue)) && (JSGuards.isForeignObject(operandNodeValue))) {
                        return doForeignObject(operandNodeValue, s10_.interop_);
                    }
                    s10_ = s10_.next_;
                }
            }
            if ((state & 0b10000000000) != 0 /* is-active doForeignObject(Object, InteropLibrary) */) {
                if ((JSGuards.isForeignObject(operandNodeValue))) {
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

    @Override
    public boolean executeBoolean(VirtualFrame frameValue) {
        int state = state_;
        if ((state & 0b11111111110) == 0 /* only-active doBoolean(boolean) */ && (state & 0b11111111111) != 0  /* is-not doBoolean(boolean) && doNumber(int) && doNumber(SafeInteger) && doNumber(long) && doNumber(double) && doSymbol(Symbol) && doBigInt(BigInt) && doString(CharSequence) && doJSType(DynamicObject, BranchProfile) && doForeignObject(Object, InteropLibrary) && doForeignObject(Object, InteropLibrary) */) {
            return executeBoolean_boolean0(frameValue, state);
        } else if ((state & 0b11111111101) == 0 /* only-active doNumber(int) */ && (state & 0b11111111111) != 0  /* is-not doBoolean(boolean) && doNumber(int) && doNumber(SafeInteger) && doNumber(long) && doNumber(double) && doSymbol(Symbol) && doBigInt(BigInt) && doString(CharSequence) && doJSType(DynamicObject, BranchProfile) && doForeignObject(Object, InteropLibrary) && doForeignObject(Object, InteropLibrary) */) {
            return executeBoolean_int1(frameValue, state);
        } else if ((state & 0b11111110111) == 0 /* only-active doNumber(long) */ && (state & 0b11111111111) != 0  /* is-not doBoolean(boolean) && doNumber(int) && doNumber(SafeInteger) && doNumber(long) && doNumber(double) && doSymbol(Symbol) && doBigInt(BigInt) && doString(CharSequence) && doJSType(DynamicObject, BranchProfile) && doForeignObject(Object, InteropLibrary) && doForeignObject(Object, InteropLibrary) */) {
            return executeBoolean_long2(frameValue, state);
        } else if ((state & 0b11111101111) == 0 /* only-active doNumber(double) */ && (state & 0b11111111111) != 0  /* is-not doBoolean(boolean) && doNumber(int) && doNumber(SafeInteger) && doNumber(long) && doNumber(double) && doSymbol(Symbol) && doBigInt(BigInt) && doString(CharSequence) && doJSType(DynamicObject, BranchProfile) && doForeignObject(Object, InteropLibrary) && doForeignObject(Object, InteropLibrary) */) {
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
        assert (state & 0b10) != 0 /* is-active doNumber(int) */;
        return doNumber(operandNodeValue_);
    }

    private boolean executeBoolean_long2(VirtualFrame frameValue, int state) {
        long operandNodeValue_;
        try {
            operandNodeValue_ = super.operandNode.executeLong(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(ex.getResult());
        }
        assert (state & 0b1000) != 0 /* is-active doNumber(long) */;
        return doNumber(operandNodeValue_);
    }

    private boolean executeBoolean_double3(VirtualFrame frameValue, int state) {
        int operandNodeValue_int = 0;
        long operandNodeValue_long = 0L;
        double operandNodeValue_;
        try {
            if ((state & 0b111000000000000) == 0 /* only-active 0:double */ && (state & 0b11111111111) != 0  /* is-not doBoolean(boolean) && doNumber(int) && doNumber(SafeInteger) && doNumber(long) && doNumber(double) && doSymbol(Symbol) && doBigInt(BigInt) && doString(CharSequence) && doJSType(DynamicObject, BranchProfile) && doForeignObject(Object, InteropLibrary) && doForeignObject(Object, InteropLibrary) */) {
                operandNodeValue_long = super.operandNode.executeLong(frameValue);
                operandNodeValue_ = JSTypes.longToDouble(operandNodeValue_long);
            } else if ((state & 0b110100000000000) == 0 /* only-active 0:double */ && (state & 0b11111111111) != 0  /* is-not doBoolean(boolean) && doNumber(int) && doNumber(SafeInteger) && doNumber(long) && doNumber(double) && doSymbol(Symbol) && doBigInt(BigInt) && doString(CharSequence) && doJSType(DynamicObject, BranchProfile) && doForeignObject(Object, InteropLibrary) && doForeignObject(Object, InteropLibrary) */) {
                operandNodeValue_int = super.operandNode.executeInt(frameValue);
                operandNodeValue_ = JSTypes.intToDouble(operandNodeValue_int);
            } else if ((state & 0b101100000000000) == 0 /* only-active 0:double */ && (state & 0b11111111111) != 0  /* is-not doBoolean(boolean) && doNumber(int) && doNumber(SafeInteger) && doNumber(long) && doNumber(double) && doSymbol(Symbol) && doBigInt(BigInt) && doString(CharSequence) && doJSType(DynamicObject, BranchProfile) && doForeignObject(Object, InteropLibrary) && doForeignObject(Object, InteropLibrary) */) {
                operandNodeValue_ = super.operandNode.executeDouble(frameValue);
            } else {
                Object operandNodeValue__ = super.operandNode.execute(frameValue);
                operandNodeValue_ = JSTypesGen.expectImplicitDouble((state & 0b111100000000000) >>> 11 /* extract-implicit-active 0:double */, operandNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(ex.getResult());
        }
        assert (state & 0b10000) != 0 /* is-active doNumber(double) */;
        return doNumber(operandNodeValue_);
    }

    @TruffleBoundary
    private boolean foreignObject1Boundary0(int state, Object operandNodeValue_) {
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
        if ((state & 0b10) != 0 /* is-active doNumber(int) */ && operandNodeValue_ instanceof Integer) {
            int operandNodeValue__ = (int) operandNodeValue_;
            return doNumber(operandNodeValue__);
        }
        if ((state & 0b100) != 0 /* is-active doNumber(SafeInteger) */ && operandNodeValue_ instanceof SafeInteger) {
            SafeInteger operandNodeValue__ = (SafeInteger) operandNodeValue_;
            return doNumber(operandNodeValue__);
        }
        if ((state & 0b1000) != 0 /* is-active doNumber(long) */ && operandNodeValue_ instanceof Long) {
            long operandNodeValue__ = (long) operandNodeValue_;
            return doNumber(operandNodeValue__);
        }
        if ((state & 0b10000) != 0 /* is-active doNumber(double) */ && JSTypesGen.isImplicitDouble((state & 0b111100000000000) >>> 11 /* extract-implicit-active 0:double */, operandNodeValue_)) {
            double operandNodeValue__ = JSTypesGen.asImplicitDouble((state & 0b111100000000000) >>> 11 /* extract-implicit-active 0:double */, operandNodeValue_);
            return doNumber(operandNodeValue__);
        }
        if ((state & 0b100000) != 0 /* is-active doSymbol(Symbol) */ && operandNodeValue_ instanceof Symbol) {
            Symbol operandNodeValue__ = (Symbol) operandNodeValue_;
            return doSymbol(operandNodeValue__);
        }
        if ((state & 0b1000000) != 0 /* is-active doBigInt(BigInt) */ && operandNodeValue_ instanceof BigInt) {
            BigInt operandNodeValue__ = (BigInt) operandNodeValue_;
            return doBigInt(operandNodeValue__);
        }
        if ((state & 0b10000000) != 0 /* is-active doString(CharSequence) */ && JSTypesGen.isImplicitCharSequence((state & 0x78000) >>> 15 /* extract-implicit-active 0:CharSequence */, operandNodeValue_)) {
            CharSequence operandNodeValue__ = JSTypesGen.asImplicitCharSequence((state & 0x78000) >>> 15 /* extract-implicit-active 0:CharSequence */, operandNodeValue_);
            return doString(operandNodeValue__);
        }
        if ((state & 0b100000000) != 0 /* is-active doJSType(DynamicObject, BranchProfile) */ && JSTypes.isDynamicObject(operandNodeValue_)) {
            DynamicObject operandNodeValue__ = (DynamicObject) operandNodeValue_;
            if ((JSGuards.isJSDynamicObject(operandNodeValue__))) {
                return doJSType(operandNodeValue__, this.jSType_proxyBranch_);
            }
        }
        if ((state & 0b11000000000) != 0 /* is-active doForeignObject(Object, InteropLibrary) || doForeignObject(Object, InteropLibrary) */) {
            if ((state & 0b1000000000) != 0 /* is-active doForeignObject(Object, InteropLibrary) */) {
                ForeignObject0Data s10_ = this.foreignObject0_cache;
                while (s10_ != null) {
                    if ((s10_.interop_.accepts(operandNodeValue_)) && (JSGuards.isForeignObject(operandNodeValue_))) {
                        return doForeignObject(operandNodeValue_, s10_.interop_);
                    }
                    s10_ = s10_.next_;
                }
            }
            if ((state & 0b10000000000) != 0 /* is-active doForeignObject(Object, InteropLibrary) */) {
                if ((JSGuards.isForeignObject(operandNodeValue_))) {
                    return this.foreignObject1Boundary0(state, operandNodeValue_);
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
            if (operandNodeValue instanceof Integer) {
                int operandNodeValue_ = (int) operandNodeValue;
                this.state_ = state = state | 0b10 /* add-active doNumber(int) */;
                lock.unlock();
                hasLock = false;
                return doNumber(operandNodeValue_);
            }
            if (operandNodeValue instanceof SafeInteger) {
                SafeInteger operandNodeValue_ = (SafeInteger) operandNodeValue;
                this.state_ = state = state | 0b100 /* add-active doNumber(SafeInteger) */;
                lock.unlock();
                hasLock = false;
                return doNumber(operandNodeValue_);
            }
            if (operandNodeValue instanceof Long) {
                long operandNodeValue_ = (long) operandNodeValue;
                this.state_ = state = state | 0b1000 /* add-active doNumber(long) */;
                lock.unlock();
                hasLock = false;
                return doNumber(operandNodeValue_);
            }
            {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(operandNodeValue)) != 0) {
                    double operandNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast0, operandNodeValue);
                    state = (state | (doubleCast0 << 11) /* set-implicit-active 0:double */);
                    this.state_ = state = state | 0b10000 /* add-active doNumber(double) */;
                    lock.unlock();
                    hasLock = false;
                    return doNumber(operandNodeValue_);
                }
            }
            if (operandNodeValue instanceof Symbol) {
                Symbol operandNodeValue_ = (Symbol) operandNodeValue;
                this.state_ = state = state | 0b100000 /* add-active doSymbol(Symbol) */;
                lock.unlock();
                hasLock = false;
                return doSymbol(operandNodeValue_);
            }
            if (operandNodeValue instanceof BigInt) {
                BigInt operandNodeValue_ = (BigInt) operandNodeValue;
                this.state_ = state = state | 0b1000000 /* add-active doBigInt(BigInt) */;
                lock.unlock();
                hasLock = false;
                return doBigInt(operandNodeValue_);
            }
            {
                int charSequenceCast0;
                if ((charSequenceCast0 = JSTypesGen.specializeImplicitCharSequence(operandNodeValue)) != 0) {
                    CharSequence operandNodeValue_ = JSTypesGen.asImplicitCharSequence(charSequenceCast0, operandNodeValue);
                    state = (state | (charSequenceCast0 << 15) /* set-implicit-active 0:CharSequence */);
                    this.state_ = state = state | 0b10000000 /* add-active doString(CharSequence) */;
                    lock.unlock();
                    hasLock = false;
                    return doString(operandNodeValue_);
                }
            }
            if (JSTypes.isDynamicObject(operandNodeValue)) {
                DynamicObject operandNodeValue_ = (DynamicObject) operandNodeValue;
                if ((JSGuards.isJSDynamicObject(operandNodeValue_))) {
                    this.jSType_proxyBranch_ = (BranchProfile.create());
                    this.state_ = state = state | 0b100000000 /* add-active doJSType(DynamicObject, BranchProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return doJSType(operandNodeValue_, this.jSType_proxyBranch_);
                }
            }
            if ((exclude) == 0 /* is-not-excluded doForeignObject(Object, InteropLibrary) */) {
                int count10_ = 0;
                ForeignObject0Data s10_ = this.foreignObject0_cache;
                if ((state & 0b1000000000) != 0 /* is-active doForeignObject(Object, InteropLibrary) */) {
                    while (s10_ != null) {
                        if ((s10_.interop_.accepts(operandNodeValue)) && (JSGuards.isForeignObject(operandNodeValue))) {
                            break;
                        }
                        s10_ = s10_.next_;
                        count10_++;
                    }
                }
                if (s10_ == null) {
                    if ((JSGuards.isForeignObject(operandNodeValue)) && count10_ < (5)) {
                        // assert (s10_.interop_.accepts(operandNodeValue));
                        s10_ = super.insert(new ForeignObject0Data(foreignObject0_cache));
                        s10_.interop_ = s10_.insertAccessor((INTEROP_LIBRARY_.create(operandNodeValue)));
                        this.foreignObject0_cache = s10_;
                        this.state_ = state = state | 0b1000000000 /* add-active doForeignObject(Object, InteropLibrary) */;
                    }
                }
                if (s10_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return doForeignObject(operandNodeValue, s10_.interop_);
                }
            }
            {
                InteropLibrary foreignObject1_interop__ = null;
                {
                    EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                    Node prev_ = encapsulating_.set(this);
                    try {
                        if ((JSGuards.isForeignObject(operandNodeValue))) {
                            foreignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(operandNodeValue));
                            this.exclude_ = exclude = exclude | 0b1 /* add-excluded doForeignObject(Object, InteropLibrary) */;
                            this.foreignObject0_cache = null;
                            state = state & 0xfffffdff /* remove-active doForeignObject(Object, InteropLibrary) */;
                            this.state_ = state = state | 0b10000000000 /* add-active doForeignObject(Object, InteropLibrary) */;
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
        if ((state & 0b11111111111) == 0b0) {
            return NodeCost.UNINITIALIZED;
        } else if (((state & 0b11111111111) & ((state & 0b11111111111) - 1)) == 0 /* is-single-active  */) {
            ForeignObject0Data s10_ = this.foreignObject0_cache;
            if ((s10_ == null || s10_.next_ == null)) {
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
        s[0] = "doBoolean";
        if ((state & 0b1) != 0 /* is-active doBoolean(boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doNumber";
        if ((state & 0b10) != 0 /* is-active doNumber(int) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doNumber";
        if ((state & 0b100) != 0 /* is-active doNumber(SafeInteger) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doNumber";
        if ((state & 0b1000) != 0 /* is-active doNumber(long) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doNumber";
        if ((state & 0b10000) != 0 /* is-active doNumber(double) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "doSymbol";
        if ((state & 0b100000) != 0 /* is-active doSymbol(Symbol) */) {
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
        s[0] = "doString";
        if ((state & 0b10000000) != 0 /* is-active doString(CharSequence) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[8] = s;
        s = new Object[3];
        s[0] = "doJSType";
        if ((state & 0b100000000) != 0 /* is-active doJSType(DynamicObject, BranchProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.jSType_proxyBranch_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[9] = s;
        s = new Object[3];
        s[0] = "doForeignObject";
        if ((state & 0b1000000000) != 0 /* is-active doForeignObject(Object, InteropLibrary) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            ForeignObject0Data s10_ = this.foreignObject0_cache;
            while (s10_ != null) {
                cached.add(Arrays.asList(s10_.interop_));
                s10_ = s10_.next_;
            }
            s[2] = cached;
        } else if (exclude != 0 /* is-excluded doForeignObject(Object, InteropLibrary) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[10] = s;
        s = new Object[3];
        s[0] = "doForeignObject";
        if ((state & 0b10000000000) != 0 /* is-active doForeignObject(Object, InteropLibrary) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList());
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[11] = s;
        return Provider.create(data);
    }

    public static JSTypeofIdenticalNode create(JavaScriptNode childNode, Type type) {
        return new JSTypeofIdenticalNodeGen(childNode, type);
    }

    @GeneratedBy(JSTypeofIdenticalNode.class)
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
