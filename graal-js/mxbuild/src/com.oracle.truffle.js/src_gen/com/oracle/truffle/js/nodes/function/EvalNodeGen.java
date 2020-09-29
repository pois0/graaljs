// CheckStyle: start generated
package com.oracle.truffle.js.nodes.function;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
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
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.runtime.BigInt;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.SafeInteger;
import com.oracle.truffle.js.runtime.Symbol;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(EvalNode.class)
public final class EvalNodeGen extends EvalNode implements Provider {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @CompilationFinal private volatile int state_;
    @Child private JSFunctionCallNode evalOverridden_redirectCall_;

    private EvalNodeGen(JSContext context, JavaScriptNode function, JavaScriptNode[] args, JavaScriptNode thisObject, Object env) {
        super(context, function, args, thisObject, env);
    }

    private EvalNodeGen(JSContext context, JavaScriptNode functionNode, AbstractFunctionArgumentsNode arguments, DirectEvalNode directEvalNode) {
        super(context, functionNode, arguments, directEvalNode);
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        int state = state_;
        Object functionNodeValue_ = super.functionNode.execute(frameValue);
        if (state != 0 /* is-active evalNotOverridden(VirtualFrame, Object) || evalOverridden(VirtualFrame, Object, JSFunctionCallNode) */) {
            if ((state & 0b1) != 0 /* is-active evalNotOverridden(VirtualFrame, Object) */) {
                if ((!(isEvalOverridden(functionNodeValue_)))) {
                    return evalNotOverridden(frameValue, functionNodeValue_);
                }
            }
            if ((state & 0b10) != 0 /* is-active evalOverridden(VirtualFrame, Object, JSFunctionCallNode) */) {
                if ((isEvalOverridden(functionNodeValue_))) {
                    return evalOverridden(frameValue, functionNodeValue_, this.evalOverridden_redirectCall_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(frameValue, functionNodeValue_);
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        execute(frameValue);
        return;
    }

    private Object executeAndSpecialize(VirtualFrame frameValue, Object functionNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        try {
            if ((!(isEvalOverridden(functionNodeValue)))) {
                this.state_ = state = state | 0b1 /* add-active evalNotOverridden(VirtualFrame, Object) */;
                lock.unlock();
                hasLock = false;
                return evalNotOverridden(frameValue, functionNodeValue);
            }
            if ((isEvalOverridden(functionNodeValue))) {
                this.evalOverridden_redirectCall_ = super.insert((JSFunctionCallNode.createCall()));
                this.state_ = state = state | 0b10 /* add-active evalOverridden(VirtualFrame, Object, JSFunctionCallNode) */;
                lock.unlock();
                hasLock = false;
                return evalOverridden(frameValue, functionNodeValue, this.evalOverridden_redirectCall_);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {super.functionNode}, functionNodeValue);
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
            return NodeCost.MONOMORPHIC;
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[3];
        Object[] s;
        data[0] = 0;
        int state = state_;
        s = new Object[3];
        s[0] = "evalNotOverridden";
        if ((state & 0b1) != 0 /* is-active evalNotOverridden(VirtualFrame, Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "evalOverridden";
        if ((state & 0b10) != 0 /* is-active evalOverridden(VirtualFrame, Object, JSFunctionCallNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.evalOverridden_redirectCall_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        return Provider.create(data);
    }

    public static EvalNode create(JSContext context, JavaScriptNode function, JavaScriptNode[] args, JavaScriptNode thisObject, Object env) {
        return new EvalNodeGen(context, function, args, thisObject, env);
    }

    public static EvalNode create(JSContext context, JavaScriptNode functionNode, AbstractFunctionArgumentsNode arguments, DirectEvalNode directEvalNode) {
        return new EvalNodeGen(context, functionNode, arguments, directEvalNode);
    }

    @GeneratedBy(DirectEvalNode.class)
    protected static final class DirectEvalNodeGen extends DirectEvalNode implements Provider {

        @CompilationFinal private volatile int state_;
        @CompilationFinal private volatile int exclude_;
        @Child private DirectEvalForeignObject0Data directEvalForeignObject0_cache;

        private DirectEvalNodeGen(JSContext context, JavaScriptNode thisNode, Object currEnv) {
            super(context, thisNode, currEnv);
        }

        @ExplodeLoop
        @Override
        public Object executeWithSource(VirtualFrame frameValue, Object arg0Value) {
            int state = state_;
            if ((state & 0b1) != 0 /* is-active directEvalInt(int) */ && arg0Value instanceof Integer) {
                int arg0Value_ = (int) arg0Value;
                return directEvalInt(arg0Value_);
            }
            if ((state & 0b10) != 0 /* is-active directEvalSafeInteger(SafeInteger) */ && arg0Value instanceof SafeInteger) {
                SafeInteger arg0Value_ = (SafeInteger) arg0Value;
                return directEvalSafeInteger(arg0Value_);
            }
            if ((state & 0b100) != 0 /* is-active directEvalLong(long) */ && arg0Value instanceof Long) {
                long arg0Value_ = (long) arg0Value;
                return directEvalLong(arg0Value_);
            }
            if ((state & 0b1000) != 0 /* is-active directEvalDouble(double) */ && JSTypesGen.isImplicitDouble((state & 0b111100000000000) >>> 11 /* extract-implicit-active 0:double */, arg0Value)) {
                double arg0Value_ = JSTypesGen.asImplicitDouble((state & 0b111100000000000) >>> 11 /* extract-implicit-active 0:double */, arg0Value);
                return directEvalDouble(arg0Value_);
            }
            if ((state & 0b10000) != 0 /* is-active directEvalBoolean(boolean) */ && arg0Value instanceof Boolean) {
                boolean arg0Value_ = (boolean) arg0Value;
                return directEvalBoolean(arg0Value_);
            }
            if ((state & 0b100000) != 0 /* is-active directEvalSymbol(Symbol) */ && arg0Value instanceof Symbol) {
                Symbol arg0Value_ = (Symbol) arg0Value;
                return directEvalSymbol(arg0Value_);
            }
            if ((state & 0b1000000) != 0 /* is-active directEvalBigInt(BigInt) */ && arg0Value instanceof BigInt) {
                BigInt arg0Value_ = (BigInt) arg0Value;
                return directEvalBigInt(arg0Value_);
            }
            if ((state & 0b10000000) != 0 /* is-active directEvalJSType(DynamicObject) */ && JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if ((JSGuards.isJSDynamicObject(arg0Value_))) {
                    return directEvalJSType(arg0Value_);
                }
            }
            if ((state & 0b100000000) != 0 /* is-active directEvalCharSequence(VirtualFrame, CharSequence) */ && JSTypesGen.isImplicitCharSequence((state & 0x78000) >>> 15 /* extract-implicit-active 0:CharSequence */, arg0Value)) {
                CharSequence arg0Value_ = JSTypesGen.asImplicitCharSequence((state & 0x78000) >>> 15 /* extract-implicit-active 0:CharSequence */, arg0Value);
                return directEvalCharSequence(frameValue, arg0Value_);
            }
            if ((state & 0b11000000000) != 0 /* is-active directEvalForeignObject(VirtualFrame, Object, InteropLibrary) || directEvalForeignObject(VirtualFrame, Object, InteropLibrary) */) {
                if ((state & 0b1000000000) != 0 /* is-active directEvalForeignObject(VirtualFrame, Object, InteropLibrary) */) {
                    DirectEvalForeignObject0Data s10_ = this.directEvalForeignObject0_cache;
                    while (s10_ != null) {
                        if ((s10_.interop_.accepts(arg0Value)) && (JSGuards.isForeignObject(arg0Value))) {
                            return directEvalForeignObject(frameValue, arg0Value, s10_.interop_);
                        }
                        s10_ = s10_.next_;
                    }
                }
                if ((state & 0b10000000000) != 0 /* is-active directEvalForeignObject(VirtualFrame, Object, InteropLibrary) */) {
                    if ((JSGuards.isForeignObject(arg0Value))) {
                        InteropLibrary directEvalForeignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arg0Value));
                        return directEvalForeignObject(frameValue, arg0Value, directEvalForeignObject1_interop__);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(frameValue, arg0Value);
        }

        private Object executeAndSpecialize(VirtualFrame frameValue, Object arg0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int exclude = exclude_;
            try {
                if (arg0Value instanceof Integer) {
                    int arg0Value_ = (int) arg0Value;
                    this.state_ = state = state | 0b1 /* add-active directEvalInt(int) */;
                    lock.unlock();
                    hasLock = false;
                    return directEvalInt(arg0Value_);
                }
                if (arg0Value instanceof SafeInteger) {
                    SafeInteger arg0Value_ = (SafeInteger) arg0Value;
                    this.state_ = state = state | 0b10 /* add-active directEvalSafeInteger(SafeInteger) */;
                    lock.unlock();
                    hasLock = false;
                    return directEvalSafeInteger(arg0Value_);
                }
                if (arg0Value instanceof Long) {
                    long arg0Value_ = (long) arg0Value;
                    this.state_ = state = state | 0b100 /* add-active directEvalLong(long) */;
                    lock.unlock();
                    hasLock = false;
                    return directEvalLong(arg0Value_);
                }
                {
                    int doubleCast0;
                    if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(arg0Value)) != 0) {
                        double arg0Value_ = JSTypesGen.asImplicitDouble(doubleCast0, arg0Value);
                        state = (state | (doubleCast0 << 11) /* set-implicit-active 0:double */);
                        this.state_ = state = state | 0b1000 /* add-active directEvalDouble(double) */;
                        lock.unlock();
                        hasLock = false;
                        return directEvalDouble(arg0Value_);
                    }
                }
                if (arg0Value instanceof Boolean) {
                    boolean arg0Value_ = (boolean) arg0Value;
                    this.state_ = state = state | 0b10000 /* add-active directEvalBoolean(boolean) */;
                    lock.unlock();
                    hasLock = false;
                    return directEvalBoolean(arg0Value_);
                }
                if (arg0Value instanceof Symbol) {
                    Symbol arg0Value_ = (Symbol) arg0Value;
                    this.state_ = state = state | 0b100000 /* add-active directEvalSymbol(Symbol) */;
                    lock.unlock();
                    hasLock = false;
                    return directEvalSymbol(arg0Value_);
                }
                if (arg0Value instanceof BigInt) {
                    BigInt arg0Value_ = (BigInt) arg0Value;
                    this.state_ = state = state | 0b1000000 /* add-active directEvalBigInt(BigInt) */;
                    lock.unlock();
                    hasLock = false;
                    return directEvalBigInt(arg0Value_);
                }
                if (JSTypes.isDynamicObject(arg0Value)) {
                    DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                    if ((JSGuards.isJSDynamicObject(arg0Value_))) {
                        this.state_ = state = state | 0b10000000 /* add-active directEvalJSType(DynamicObject) */;
                        lock.unlock();
                        hasLock = false;
                        return directEvalJSType(arg0Value_);
                    }
                }
                {
                    int charSequenceCast0;
                    if ((charSequenceCast0 = JSTypesGen.specializeImplicitCharSequence(arg0Value)) != 0) {
                        CharSequence arg0Value_ = JSTypesGen.asImplicitCharSequence(charSequenceCast0, arg0Value);
                        state = (state | (charSequenceCast0 << 15) /* set-implicit-active 0:CharSequence */);
                        this.state_ = state = state | 0b100000000 /* add-active directEvalCharSequence(VirtualFrame, CharSequence) */;
                        lock.unlock();
                        hasLock = false;
                        return directEvalCharSequence(frameValue, arg0Value_);
                    }
                }
                if ((exclude) == 0 /* is-not-excluded directEvalForeignObject(VirtualFrame, Object, InteropLibrary) */) {
                    int count10_ = 0;
                    DirectEvalForeignObject0Data s10_ = this.directEvalForeignObject0_cache;
                    if ((state & 0b1000000000) != 0 /* is-active directEvalForeignObject(VirtualFrame, Object, InteropLibrary) */) {
                        while (s10_ != null) {
                            if ((s10_.interop_.accepts(arg0Value)) && (JSGuards.isForeignObject(arg0Value))) {
                                break;
                            }
                            s10_ = s10_.next_;
                            count10_++;
                        }
                    }
                    if (s10_ == null) {
                        if ((JSGuards.isForeignObject(arg0Value)) && count10_ < (3)) {
                            // assert (s10_.interop_.accepts(arg0Value));
                            s10_ = super.insert(new DirectEvalForeignObject0Data(directEvalForeignObject0_cache));
                            s10_.interop_ = s10_.insertAccessor((INTEROP_LIBRARY_.create(arg0Value)));
                            this.directEvalForeignObject0_cache = s10_;
                            this.state_ = state = state | 0b1000000000 /* add-active directEvalForeignObject(VirtualFrame, Object, InteropLibrary) */;
                        }
                    }
                    if (s10_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return directEvalForeignObject(frameValue, arg0Value, s10_.interop_);
                    }
                }
                {
                    InteropLibrary directEvalForeignObject1_interop__ = null;
                    {
                        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                        Node prev_ = encapsulating_.set(this);
                        try {
                            if ((JSGuards.isForeignObject(arg0Value))) {
                                directEvalForeignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arg0Value));
                                this.exclude_ = exclude = exclude | 0b1 /* add-excluded directEvalForeignObject(VirtualFrame, Object, InteropLibrary) */;
                                this.directEvalForeignObject0_cache = null;
                                state = state & 0xfffffdff /* remove-active directEvalForeignObject(VirtualFrame, Object, InteropLibrary) */;
                                this.state_ = state = state | 0b10000000000 /* add-active directEvalForeignObject(VirtualFrame, Object, InteropLibrary) */;
                                lock.unlock();
                                hasLock = false;
                                return directEvalForeignObject(frameValue, arg0Value, directEvalForeignObject1_interop__);
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
            if ((state & 0b11111111111) == 0b0) {
                return NodeCost.UNINITIALIZED;
            } else if (((state & 0b11111111111) & ((state & 0b11111111111) - 1)) == 0 /* is-single-active  */) {
                DirectEvalForeignObject0Data s10_ = this.directEvalForeignObject0_cache;
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
            s[0] = "directEvalInt";
            if ((state & 0b1) != 0 /* is-active directEvalInt(int) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "directEvalSafeInteger";
            if ((state & 0b10) != 0 /* is-active directEvalSafeInteger(SafeInteger) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "directEvalLong";
            if ((state & 0b100) != 0 /* is-active directEvalLong(long) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "directEvalDouble";
            if ((state & 0b1000) != 0 /* is-active directEvalDouble(double) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            s = new Object[3];
            s[0] = "directEvalBoolean";
            if ((state & 0b10000) != 0 /* is-active directEvalBoolean(boolean) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[5] = s;
            s = new Object[3];
            s[0] = "directEvalSymbol";
            if ((state & 0b100000) != 0 /* is-active directEvalSymbol(Symbol) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[6] = s;
            s = new Object[3];
            s[0] = "directEvalBigInt";
            if ((state & 0b1000000) != 0 /* is-active directEvalBigInt(BigInt) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[7] = s;
            s = new Object[3];
            s[0] = "directEvalJSType";
            if ((state & 0b10000000) != 0 /* is-active directEvalJSType(DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[8] = s;
            s = new Object[3];
            s[0] = "directEvalCharSequence";
            if ((state & 0b100000000) != 0 /* is-active directEvalCharSequence(VirtualFrame, CharSequence) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[9] = s;
            s = new Object[3];
            s[0] = "directEvalForeignObject";
            if ((state & 0b1000000000) != 0 /* is-active directEvalForeignObject(VirtualFrame, Object, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                DirectEvalForeignObject0Data s10_ = this.directEvalForeignObject0_cache;
                while (s10_ != null) {
                    cached.add(Arrays.asList(s10_.interop_));
                    s10_ = s10_.next_;
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-excluded directEvalForeignObject(VirtualFrame, Object, InteropLibrary) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[10] = s;
            s = new Object[3];
            s[0] = "directEvalForeignObject";
            if ((state & 0b10000000000) != 0 /* is-active directEvalForeignObject(VirtualFrame, Object, InteropLibrary) */) {
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

        public static DirectEvalNode create(JSContext context, JavaScriptNode thisNode, Object currEnv) {
            return new DirectEvalNodeGen(context, thisNode, currEnv);
        }

        @GeneratedBy(DirectEvalNode.class)
        private static final class DirectEvalForeignObject0Data extends Node {

            @Child DirectEvalForeignObject0Data next_;
            @Child InteropLibrary interop_;

            DirectEvalForeignObject0Data(DirectEvalForeignObject0Data next_) {
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
}
