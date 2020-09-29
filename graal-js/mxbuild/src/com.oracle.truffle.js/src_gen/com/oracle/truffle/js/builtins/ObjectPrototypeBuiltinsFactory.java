// CheckStyle: start generated
package com.oracle.truffle.js.builtins;

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
import com.oracle.truffle.js.builtins.ObjectPrototypeBuiltins.FormatCacheNode;
import com.oracle.truffle.js.builtins.ObjectPrototypeBuiltins.GetBuiltinToStringTagNode;
import com.oracle.truffle.js.builtins.ObjectPrototypeBuiltins.ObjectPrototypeDefineGetterOrSetterNode;
import com.oracle.truffle.js.builtins.ObjectPrototypeBuiltins.ObjectPrototypeHasOwnPropertyNode;
import com.oracle.truffle.js.builtins.ObjectPrototypeBuiltins.ObjectPrototypeIsPrototypeOfNode;
import com.oracle.truffle.js.builtins.ObjectPrototypeBuiltins.ObjectPrototypeLookupGetterOrSetterNode;
import com.oracle.truffle.js.builtins.ObjectPrototypeBuiltins.ObjectPrototypePropertyIsEnumerableNode;
import com.oracle.truffle.js.builtins.ObjectPrototypeBuiltins.ObjectPrototypeToLocaleStringNode;
import com.oracle.truffle.js.builtins.ObjectPrototypeBuiltins.ObjectPrototypeToStringNode;
import com.oracle.truffle.js.builtins.ObjectPrototypeBuiltins.ObjectPrototypeValueOfNode;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.BigInt;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.SafeInteger;
import com.oracle.truffle.js.runtime.Symbol;
import com.oracle.truffle.js.runtime.builtins.JSClass;
import com.oracle.truffle.js.runtime.objects.JSLazyString;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(ObjectPrototypeBuiltins.class)
@SuppressWarnings("unused")
public final class ObjectPrototypeBuiltinsFactory {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @GeneratedBy(ObjectPrototypeValueOfNode.class)
    public static final class ObjectPrototypeValueOfNodeGen extends ObjectPrototypeValueOfNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_;
        @Child private InteropLibrary valueOfForeign_interop_;

        private ObjectPrototypeValueOfNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state & 0b1) != 0 /* is-active valueOfJSObject(DynamicObject) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((JSGuards.isJSDynamicObject(arguments0Value__))) {
                    return valueOfJSObject(arguments0Value__);
                }
            }
            if ((state & 0b10) != 0 /* is-active valueOfSymbol(Symbol) */ && arguments0Value_ instanceof Symbol) {
                Symbol arguments0Value__ = (Symbol) arguments0Value_;
                return valueOfSymbol(arguments0Value__);
            }
            if ((state & 0b100) != 0 /* is-active valueOfLazyString(JSLazyString) */ && arguments0Value_ instanceof JSLazyString) {
                JSLazyString arguments0Value__ = (JSLazyString) arguments0Value_;
                return valueOfLazyString(arguments0Value__);
            }
            if ((state & 0b1000) != 0 /* is-active valueOfSafeInteger(SafeInteger) */ && arguments0Value_ instanceof SafeInteger) {
                SafeInteger arguments0Value__ = (SafeInteger) arguments0Value_;
                return valueOfSafeInteger(arguments0Value__);
            }
            if ((state & 0b10000) != 0 /* is-active valueOfBigInt(BigInt) */ && arguments0Value_ instanceof BigInt) {
                BigInt arguments0Value__ = (BigInt) arguments0Value_;
                return valueOfBigInt(arguments0Value__);
            }
            if ((state & 0b1100000) != 0 /* is-active valueOfOther(Object) || valueOfForeign(Object, InteropLibrary) */) {
                if ((state & 0b100000) != 0 /* is-active valueOfOther(Object) */) {
                    if ((!(JSGuards.isTruffleObject(arguments0Value_)))) {
                        return valueOfOther(arguments0Value_);
                    }
                }
                if ((state & 0b1000000) != 0 /* is-active valueOfForeign(Object, InteropLibrary) */) {
                    if ((JSGuards.isForeignObject(arguments0Value_))) {
                        return valueOfForeign(arguments0Value_, this.valueOfForeign_interop_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private Object executeAndSpecialize(Object arguments0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            try {
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSDynamicObject(arguments0Value_))) {
                        this.state_ = state = state | 0b1 /* add-active valueOfJSObject(DynamicObject) */;
                        lock.unlock();
                        hasLock = false;
                        return valueOfJSObject(arguments0Value_);
                    }
                }
                if (arguments0Value instanceof Symbol) {
                    Symbol arguments0Value_ = (Symbol) arguments0Value;
                    this.state_ = state = state | 0b10 /* add-active valueOfSymbol(Symbol) */;
                    lock.unlock();
                    hasLock = false;
                    return valueOfSymbol(arguments0Value_);
                }
                if (arguments0Value instanceof JSLazyString) {
                    JSLazyString arguments0Value_ = (JSLazyString) arguments0Value;
                    this.state_ = state = state | 0b100 /* add-active valueOfLazyString(JSLazyString) */;
                    lock.unlock();
                    hasLock = false;
                    return valueOfLazyString(arguments0Value_);
                }
                if (arguments0Value instanceof SafeInteger) {
                    SafeInteger arguments0Value_ = (SafeInteger) arguments0Value;
                    this.state_ = state = state | 0b1000 /* add-active valueOfSafeInteger(SafeInteger) */;
                    lock.unlock();
                    hasLock = false;
                    return valueOfSafeInteger(arguments0Value_);
                }
                if (arguments0Value instanceof BigInt) {
                    BigInt arguments0Value_ = (BigInt) arguments0Value;
                    this.state_ = state = state | 0b10000 /* add-active valueOfBigInt(BigInt) */;
                    lock.unlock();
                    hasLock = false;
                    return valueOfBigInt(arguments0Value_);
                }
                if ((!(JSGuards.isTruffleObject(arguments0Value)))) {
                    this.state_ = state = state | 0b100000 /* add-active valueOfOther(Object) */;
                    lock.unlock();
                    hasLock = false;
                    return valueOfOther(arguments0Value);
                }
                if ((JSGuards.isForeignObject(arguments0Value))) {
                    this.valueOfForeign_interop_ = super.insert((INTEROP_LIBRARY_.createDispatched(3)));
                    this.state_ = state = state | 0b1000000 /* add-active valueOfForeign(Object, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return valueOfForeign(arguments0Value, this.valueOfForeign_interop_);
                }
                throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_}, arguments0Value);
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
            Object[] data = new Object[8];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "valueOfJSObject";
            if ((state & 0b1) != 0 /* is-active valueOfJSObject(DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "valueOfSymbol";
            if ((state & 0b10) != 0 /* is-active valueOfSymbol(Symbol) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "valueOfLazyString";
            if ((state & 0b100) != 0 /* is-active valueOfLazyString(JSLazyString) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "valueOfSafeInteger";
            if ((state & 0b1000) != 0 /* is-active valueOfSafeInteger(SafeInteger) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            s = new Object[3];
            s[0] = "valueOfBigInt";
            if ((state & 0b10000) != 0 /* is-active valueOfBigInt(BigInt) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[5] = s;
            s = new Object[3];
            s[0] = "valueOfOther";
            if ((state & 0b100000) != 0 /* is-active valueOfOther(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[6] = s;
            s = new Object[3];
            s[0] = "valueOfForeign";
            if ((state & 0b1000000) != 0 /* is-active valueOfForeign(Object, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.valueOfForeign_interop_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[7] = s;
            return Provider.create(data);
        }

        public static ObjectPrototypeValueOfNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ObjectPrototypeValueOfNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ObjectPrototypeToStringNode.class)
    public static final class ObjectPrototypeToStringNodeGen extends ObjectPrototypeToStringNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_;
        @CompilationFinal private volatile int exclude_;
        @Child private GetBuiltinToStringTagNode builtinTag;
        @Child private InteropLibrary foreignObject0_interop_;

        private ObjectPrototypeToStringNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state & 0b11) != 0 /* is-active doJSObject(DynamicObject, GetBuiltinToStringTagNode) || doJSProxy(DynamicObject, GetBuiltinToStringTagNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state & 0b1) != 0 /* is-active doJSObject(DynamicObject, GetBuiltinToStringTagNode) */) {
                    if ((JSGuards.isJSObject(arguments0Value__)) && (!(JSGuards.isJSProxy(arguments0Value__)))) {
                        return doJSObject(arguments0Value__, this.builtinTag);
                    }
                }
                if ((state & 0b10) != 0 /* is-active doJSProxy(DynamicObject, GetBuiltinToStringTagNode) */) {
                    if ((JSGuards.isJSProxy(arguments0Value__))) {
                        return doJSProxy(arguments0Value__, this.builtinTag);
                    }
                }
            }
            if ((state & 0b111100) != 0 /* is-active doNull(Object) || doUndefined(Object) || doForeignObject(Object, InteropLibrary) || doForeignObject(Object, InteropLibrary) */) {
                if ((state & 0b100) != 0 /* is-active doNull(Object) */) {
                    if ((JSGuards.isJSNull(arguments0Value_))) {
                        return doNull(arguments0Value_);
                    }
                }
                if ((state & 0b1000) != 0 /* is-active doUndefined(Object) */) {
                    if ((JSGuards.isUndefined(arguments0Value_))) {
                        return doUndefined(arguments0Value_);
                    }
                }
                if ((state & 0b10000) != 0 /* is-active doForeignObject(Object, InteropLibrary) */) {
                    if ((this.foreignObject0_interop_.accepts(arguments0Value_)) && (JSGuards.isForeignObject(arguments0Value_))) {
                        return doForeignObject(arguments0Value_, this.foreignObject0_interop_);
                    }
                }
                if ((state & 0b100000) != 0 /* is-active doForeignObject(Object, InteropLibrary) */) {
                    if ((JSGuards.isForeignObject(arguments0Value_))) {
                        return this.foreignObject1Boundary(state, arguments0Value_);
                    }
                }
            }
            if ((state & 0b1000000) != 0 /* is-active doSymbol(Symbol) */ && arguments0Value_ instanceof Symbol) {
                Symbol arguments0Value__ = (Symbol) arguments0Value_;
                return doSymbol(arguments0Value__);
            }
            if ((state & 0b10000000) != 0 /* is-active doLazyString(JSLazyString) */ && arguments0Value_ instanceof JSLazyString) {
                JSLazyString arguments0Value__ = (JSLazyString) arguments0Value_;
                return doLazyString(arguments0Value__);
            }
            if ((state & 0b100000000) != 0 /* is-active doSafeInteger(SafeInteger) */ && arguments0Value_ instanceof SafeInteger) {
                SafeInteger arguments0Value__ = (SafeInteger) arguments0Value_;
                return doSafeInteger(arguments0Value__);
            }
            if ((state & 0b1000000000) != 0 /* is-active doBigInt(BigInt) */ && arguments0Value_ instanceof BigInt) {
                BigInt arguments0Value__ = (BigInt) arguments0Value_;
                return doBigInt(arguments0Value__);
            }
            if ((state & 0b10000000000) != 0 /* is-active doObject(Object) */) {
                if ((!(JSGuards.isTruffleObject(arguments0Value_)))) {
                    return doObject(arguments0Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @TruffleBoundary
        private Object foreignObject1Boundary(int state, Object arguments0Value_) {
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(this);
            try {
                {
                    InteropLibrary foreignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value_));
                    return doForeignObject(arguments0Value_, foreignObject1_interop__);
                }
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private String executeAndSpecialize(Object arguments0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int exclude = exclude_;
            try {
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSObject(arguments0Value_)) && (!(JSGuards.isJSProxy(arguments0Value_)))) {
                        if (this.builtinTag == null) {
                            this.builtinTag = super.insert((GetBuiltinToStringTagNode.create()));
                        }
                        this.state_ = state = state | 0b1 /* add-active doJSObject(DynamicObject, GetBuiltinToStringTagNode) */;
                        lock.unlock();
                        hasLock = false;
                        return doJSObject(arguments0Value_, this.builtinTag);
                    }
                    if ((JSGuards.isJSProxy(arguments0Value_))) {
                        if (this.builtinTag == null) {
                            this.builtinTag = super.insert((GetBuiltinToStringTagNode.create()));
                        }
                        this.state_ = state = state | 0b10 /* add-active doJSProxy(DynamicObject, GetBuiltinToStringTagNode) */;
                        lock.unlock();
                        hasLock = false;
                        return doJSProxy(arguments0Value_, this.builtinTag);
                    }
                }
                if ((JSGuards.isJSNull(arguments0Value))) {
                    this.state_ = state = state | 0b100 /* add-active doNull(Object) */;
                    lock.unlock();
                    hasLock = false;
                    return doNull(arguments0Value);
                }
                if ((JSGuards.isUndefined(arguments0Value))) {
                    this.state_ = state = state | 0b1000 /* add-active doUndefined(Object) */;
                    lock.unlock();
                    hasLock = false;
                    return doUndefined(arguments0Value);
                }
                if ((exclude) == 0 /* is-not-excluded doForeignObject(Object, InteropLibrary) */) {
                    boolean ForeignObject0_duplicateFound_ = false;
                    if ((state & 0b10000) != 0 /* is-active doForeignObject(Object, InteropLibrary) */) {
                        if ((this.foreignObject0_interop_.accepts(arguments0Value)) && (JSGuards.isForeignObject(arguments0Value))) {
                            ForeignObject0_duplicateFound_ = true;
                        }
                    }
                    if (!ForeignObject0_duplicateFound_) {
                        if ((JSGuards.isForeignObject(arguments0Value)) && ((state & 0b10000)) == 0 /* is-not-active doForeignObject(Object, InteropLibrary) */) {
                            // assert (this.foreignObject0_interop_.accepts(arguments0Value));
                            this.foreignObject0_interop_ = super.insert((INTEROP_LIBRARY_.create(arguments0Value)));
                            this.state_ = state = state | 0b10000 /* add-active doForeignObject(Object, InteropLibrary) */;
                            ForeignObject0_duplicateFound_ = true;
                        }
                    }
                    if (ForeignObject0_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return doForeignObject(arguments0Value, this.foreignObject0_interop_);
                    }
                }
                {
                    InteropLibrary foreignObject1_interop__ = null;
                    {
                        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                        Node prev_ = encapsulating_.set(this);
                        try {
                            if ((JSGuards.isForeignObject(arguments0Value))) {
                                foreignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value));
                                this.exclude_ = exclude = exclude | 0b1 /* add-excluded doForeignObject(Object, InteropLibrary) */;
                                state = state & 0xffffffef /* remove-active doForeignObject(Object, InteropLibrary) */;
                                this.state_ = state = state | 0b100000 /* add-active doForeignObject(Object, InteropLibrary) */;
                                lock.unlock();
                                hasLock = false;
                                return doForeignObject(arguments0Value, foreignObject1_interop__);
                            }
                        } finally {
                            encapsulating_.set(prev_);
                        }
                    }
                }
                if (arguments0Value instanceof Symbol) {
                    Symbol arguments0Value_ = (Symbol) arguments0Value;
                    this.state_ = state = state | 0b1000000 /* add-active doSymbol(Symbol) */;
                    lock.unlock();
                    hasLock = false;
                    return doSymbol(arguments0Value_);
                }
                if (arguments0Value instanceof JSLazyString) {
                    JSLazyString arguments0Value_ = (JSLazyString) arguments0Value;
                    this.state_ = state = state | 0b10000000 /* add-active doLazyString(JSLazyString) */;
                    lock.unlock();
                    hasLock = false;
                    return doLazyString(arguments0Value_);
                }
                if (arguments0Value instanceof SafeInteger) {
                    SafeInteger arguments0Value_ = (SafeInteger) arguments0Value;
                    this.state_ = state = state | 0b100000000 /* add-active doSafeInteger(SafeInteger) */;
                    lock.unlock();
                    hasLock = false;
                    return doSafeInteger(arguments0Value_);
                }
                if (arguments0Value instanceof BigInt) {
                    BigInt arguments0Value_ = (BigInt) arguments0Value;
                    this.state_ = state = state | 0b1000000000 /* add-active doBigInt(BigInt) */;
                    lock.unlock();
                    hasLock = false;
                    return doBigInt(arguments0Value_);
                }
                if ((!(JSGuards.isTruffleObject(arguments0Value)))) {
                    this.state_ = state = state | 0b10000000000 /* add-active doObject(Object) */;
                    lock.unlock();
                    hasLock = false;
                    return doObject(arguments0Value);
                }
                throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_}, arguments0Value);
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
            Object[] data = new Object[12];
            Object[] s;
            data[0] = 0;
            int state = state_;
            int exclude = exclude_;
            s = new Object[3];
            s[0] = "doJSObject";
            if ((state & 0b1) != 0 /* is-active doJSObject(DynamicObject, GetBuiltinToStringTagNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.builtinTag));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doJSProxy";
            if ((state & 0b10) != 0 /* is-active doJSProxy(DynamicObject, GetBuiltinToStringTagNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.builtinTag));
                s[2] = cached;
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
            s[0] = "doUndefined";
            if ((state & 0b1000) != 0 /* is-active doUndefined(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            s = new Object[3];
            s[0] = "doForeignObject";
            if ((state & 0b10000) != 0 /* is-active doForeignObject(Object, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.foreignObject0_interop_));
                s[2] = cached;
            } else if (exclude != 0 /* is-excluded doForeignObject(Object, InteropLibrary) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[5] = s;
            s = new Object[3];
            s[0] = "doForeignObject";
            if ((state & 0b100000) != 0 /* is-active doForeignObject(Object, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList());
                s[2] = cached;
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
            s[0] = "doLazyString";
            if ((state & 0b10000000) != 0 /* is-active doLazyString(JSLazyString) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[8] = s;
            s = new Object[3];
            s[0] = "doSafeInteger";
            if ((state & 0b100000000) != 0 /* is-active doSafeInteger(SafeInteger) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[9] = s;
            s = new Object[3];
            s[0] = "doBigInt";
            if ((state & 0b1000000000) != 0 /* is-active doBigInt(BigInt) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[10] = s;
            s = new Object[3];
            s[0] = "doObject";
            if ((state & 0b10000000000) != 0 /* is-active doObject(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[11] = s;
            return Provider.create(data);
        }

        public static ObjectPrototypeToStringNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ObjectPrototypeToStringNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(GetBuiltinToStringTagNode.class)
    public static final class GetBuiltinToStringTagNodeGen extends GetBuiltinToStringTagNode implements Provider {

        @CompilationFinal private volatile int state_;
        @CompilationFinal private volatile int exclude_;
        @CompilationFinal private CachedData cached_cache;

        private GetBuiltinToStringTagNodeGen() {
        }

        @ExplodeLoop
        @Override
        public String execute(Object arg0Value) {
            int state = state_;
            if (state != 0 /* is-active cached(DynamicObject, JSClass) || uncached(DynamicObject) || foreign(DynamicObject) */ && JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if ((state & 0b1) != 0 /* is-active cached(DynamicObject, JSClass) */) {
                    CachedData s1_ = this.cached_cache;
                    while (s1_ != null) {
                        assert (s1_.cachedClass_ != null);
                        if ((s1_.cachedClass_.isInstance(arg0Value_))) {
                            return GetBuiltinToStringTagNode.cached(arg0Value_, s1_.cachedClass_);
                        }
                        s1_ = s1_.next_;
                    }
                }
                if ((state & 0b10) != 0 /* is-active uncached(DynamicObject) */) {
                    if ((JSGuards.isJSDynamicObject(arg0Value_))) {
                        return GetBuiltinToStringTagNode.uncached(arg0Value_);
                    }
                }
                if ((state & 0b100) != 0 /* is-active foreign(DynamicObject) */) {
                    if ((!(JSGuards.isJSDynamicObject(arg0Value_)))) {
                        return GetBuiltinToStringTagNode.foreign(arg0Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value);
        }

        private String executeAndSpecialize(Object arg0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int exclude = exclude_;
            try {
                if (JSTypes.isDynamicObject(arg0Value)) {
                    DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                    if ((exclude) == 0 /* is-not-excluded cached(DynamicObject, JSClass) */) {
                        int count1_ = 0;
                        CachedData s1_ = this.cached_cache;
                        if ((state & 0b1) != 0 /* is-active cached(DynamicObject, JSClass) */) {
                            while (s1_ != null) {
                                assert (s1_.cachedClass_ != null);
                                if ((s1_.cachedClass_.isInstance(arg0Value_))) {
                                    break;
                                }
                                s1_ = s1_.next_;
                                count1_++;
                            }
                        }
                        if (s1_ == null) {
                            {
                                JSClass cachedClass__ = (JSGuards.getJSClassChecked(arg0Value_));
                                if ((cachedClass__ != null) && (cachedClass__.isInstance(arg0Value_)) && count1_ < (5)) {
                                    s1_ = new CachedData(cached_cache);
                                    s1_.cachedClass_ = cachedClass__;
                                    this.cached_cache = s1_;
                                    this.state_ = state = state | 0b1 /* add-active cached(DynamicObject, JSClass) */;
                                }
                            }
                        }
                        if (s1_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return GetBuiltinToStringTagNode.cached(arg0Value_, s1_.cachedClass_);
                        }
                    }
                    if ((JSGuards.isJSDynamicObject(arg0Value_))) {
                        this.exclude_ = exclude = exclude | 0b1 /* add-excluded cached(DynamicObject, JSClass) */;
                        this.cached_cache = null;
                        state = state & 0xfffffffe /* remove-active cached(DynamicObject, JSClass) */;
                        this.state_ = state = state | 0b10 /* add-active uncached(DynamicObject) */;
                        lock.unlock();
                        hasLock = false;
                        return GetBuiltinToStringTagNode.uncached(arg0Value_);
                    }
                    if ((!(JSGuards.isJSDynamicObject(arg0Value_)))) {
                        this.state_ = state = state | 0b100 /* add-active foreign(DynamicObject) */;
                        lock.unlock();
                        hasLock = false;
                        return GetBuiltinToStringTagNode.foreign(arg0Value_);
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
            if (state == 0b0) {
                return NodeCost.UNINITIALIZED;
            } else if ((state & (state - 1)) == 0 /* is-single-active  */) {
                CachedData s1_ = this.cached_cache;
                if ((s1_ == null || s1_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[4];
            Object[] s;
            data[0] = 0;
            int state = state_;
            int exclude = exclude_;
            s = new Object[3];
            s[0] = "cached";
            if ((state & 0b1) != 0 /* is-active cached(DynamicObject, JSClass) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                CachedData s1_ = this.cached_cache;
                while (s1_ != null) {
                    cached.add(Arrays.asList(s1_.cachedClass_));
                    s1_ = s1_.next_;
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-excluded cached(DynamicObject, JSClass) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "uncached";
            if ((state & 0b10) != 0 /* is-active uncached(DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "foreign";
            if ((state & 0b100) != 0 /* is-active foreign(DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static GetBuiltinToStringTagNode create() {
            return new GetBuiltinToStringTagNodeGen();
        }

        @GeneratedBy(GetBuiltinToStringTagNode.class)
        private static final class CachedData {

            @CompilationFinal CachedData next_;
            @CompilationFinal JSClass cachedClass_;

            CachedData(CachedData next_) {
                this.next_ = next_;
            }

        }
    }
    @GeneratedBy(FormatCacheNode.class)
    public static final class FormatCacheNodeGen extends FormatCacheNode implements Provider {

        @CompilationFinal private volatile int state_;
        @CompilationFinal private ExecuteCachedData executeCached_cache;

        private FormatCacheNodeGen() {
        }

        @ExplodeLoop
        @Override
        public String execute(String arg0Value) {
            int state = state_;
            if ((state & 0b11) != 0 /* is-active executeCached(String, String, String) || executeUncached(String) */) {
                if ((state & 0b1) != 0 /* is-active executeCached(String, String, String) */) {
                    ExecuteCachedData s1_ = this.executeCached_cache;
                    while (s1_ != null) {
                        if ((s1_.cachedName_.equals(arg0Value))) {
                            return executeCached(arg0Value, s1_.cachedName_, s1_.cachedResult_);
                        }
                        s1_ = s1_.next_;
                    }
                }
                if ((state & 0b10) != 0 /* is-active executeUncached(String) */) {
                    return executeUncached(arg0Value);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value);
        }

        private String executeAndSpecialize(String arg0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            try {
                int count1_ = 0;
                ExecuteCachedData s1_ = this.executeCached_cache;
                if ((state & 0b1) != 0 /* is-active executeCached(String, String, String) */) {
                    while (s1_ != null) {
                        if ((s1_.cachedName_.equals(arg0Value))) {
                            break;
                        }
                        s1_ = s1_.next_;
                        count1_++;
                    }
                }
                if (s1_ == null) {
                    // assert (s1_.cachedName_.equals(arg0Value));
                    if (count1_ < (10)) {
                        s1_ = new ExecuteCachedData(executeCached_cache);
                        s1_.cachedName_ = (arg0Value);
                        s1_.cachedResult_ = (executeUncached(arg0Value));
                        this.executeCached_cache = s1_;
                        this.state_ = state = state | 0b1 /* add-active executeCached(String, String, String) */;
                    }
                }
                if (s1_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return executeCached(arg0Value, s1_.cachedName_, s1_.cachedResult_);
                }
                this.state_ = state = state | 0b10 /* add-active executeUncached(String) */;
                lock.unlock();
                hasLock = false;
                return executeUncached(arg0Value);
            } finally {
                if (hasLock) {
                    lock.unlock();
                }
            }
        }

        @Override
        public NodeCost getCost() {
            int state = state_;
            if ((state & 0b11) == 0b0) {
                return NodeCost.UNINITIALIZED;
            } else if (((state & 0b11) & ((state & 0b11) - 1)) == 0 /* is-single-active  */) {
                ExecuteCachedData s1_ = this.executeCached_cache;
                if ((s1_ == null || s1_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
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
            s[0] = "executeCached";
            if ((state & 0b1) != 0 /* is-active executeCached(String, String, String) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                ExecuteCachedData s1_ = this.executeCached_cache;
                while (s1_ != null) {
                    cached.add(Arrays.asList(s1_.cachedName_, s1_.cachedResult_));
                    s1_ = s1_.next_;
                }
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "executeUncached";
            if ((state & 0b10) != 0 /* is-active executeUncached(String) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static FormatCacheNode create() {
            return new FormatCacheNodeGen();
        }

        @GeneratedBy(FormatCacheNode.class)
        private static final class ExecuteCachedData {

            @CompilationFinal ExecuteCachedData next_;
            @CompilationFinal String cachedName_;
            @CompilationFinal String cachedResult_;

            ExecuteCachedData(ExecuteCachedData next_) {
                this.next_ = next_;
            }

        }
    }
    @GeneratedBy(ObjectPrototypeToLocaleStringNode.class)
    public static final class ObjectPrototypeToLocaleStringNodeGen extends ObjectPrototypeToLocaleStringNode implements Provider {

        @Child private JavaScriptNode arguments0_;

        private ObjectPrototypeToLocaleStringNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return toLocaleString(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.MONOMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            s = new Object[3];
            s[0] = "toLocaleString";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static ObjectPrototypeToLocaleStringNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ObjectPrototypeToLocaleStringNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ObjectPrototypePropertyIsEnumerableNode.class)
    public static final class ObjectPrototypePropertyIsEnumerableNodeGen extends ObjectPrototypePropertyIsEnumerableNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;

        private ObjectPrototypePropertyIsEnumerableNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            return propertyIsEnumerable(arguments0Value_, arguments1Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            return propertyIsEnumerable(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            executeBoolean(frameValue);
            return;
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.MONOMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            s = new Object[3];
            s[0] = "propertyIsEnumerable";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static ObjectPrototypePropertyIsEnumerableNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ObjectPrototypePropertyIsEnumerableNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ObjectPrototypeHasOwnPropertyNode.class)
    public static final class ObjectPrototypeHasOwnPropertyNodeGen extends ObjectPrototypeHasOwnPropertyNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private int state_;
        @CompilationFinal private int exclude_;

        private ObjectPrototypeHasOwnPropertyNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            if ((state & 0b1111111101) == 0 /* only-active doJSObjectIntKey(DynamicObject, int) */ && (state & 0b1111111111) != 0  /* is-not doJSObjectStringKey(DynamicObject, String) && doJSObjectIntKey(DynamicObject, int) && doJSObjectAnyKey(DynamicObject, Object) && hasOwnPropertyNullOrUndefined(DynamicObject, Object) && hasOwnPropertyLazyString(JSLazyString, Object) && hasOwnPropertyPrimitive(Object, Object) && hasOwnPropertySymbol(Symbol, Object) && hasOwnPropertySafeInteger(SafeInteger, Object) && hasOwnPropertyBigInt(BigInt, Object) && hasOwnPropertyForeign(Object, Object) */) {
                return execute_int0(frameValue, state);
            } else {
                return execute_generic1(frameValue, state);
            }
        }

        private Object execute_int0(VirtualFrame frameValue, int state) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            int arguments1Value_;
            try {
                arguments1Value_ = this.arguments1_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(arguments0Value_, ex.getResult());
            }
            assert (state & 0b10) != 0 /* is-active doJSObjectIntKey(DynamicObject, int) */;
            if (JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((JSGuards.isJSObject(arguments0Value__))) {
                    return doJSObjectIntKey(arguments0Value__, arguments1Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        private Object execute_generic1(VirtualFrame frameValue, int state) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if ((state & 0b1111) != 0 /* is-active doJSObjectStringKey(DynamicObject, String) || doJSObjectIntKey(DynamicObject, int) || doJSObjectAnyKey(DynamicObject, Object) || hasOwnPropertyNullOrUndefined(DynamicObject, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state & 0b1) != 0 /* is-active doJSObjectStringKey(DynamicObject, String) */ && JSTypesGen.isImplicitString((state & 0b11110000000000) >>> 10 /* extract-implicit-active 1:String */, arguments1Value_)) {
                    String arguments1Value__ = JSTypesGen.asImplicitString((state & 0b11110000000000) >>> 10 /* extract-implicit-active 1:String */, arguments1Value_);
                    if ((JSGuards.isJSObject(arguments0Value__))) {
                        return doJSObjectStringKey(arguments0Value__, arguments1Value__);
                    }
                }
                if ((state & 0b10) != 0 /* is-active doJSObjectIntKey(DynamicObject, int) */ && arguments1Value_ instanceof Integer) {
                    int arguments1Value__ = (int) arguments1Value_;
                    if ((JSGuards.isJSObject(arguments0Value__))) {
                        return doJSObjectIntKey(arguments0Value__, arguments1Value__);
                    }
                }
                if ((state & 0b1100) != 0 /* is-active doJSObjectAnyKey(DynamicObject, Object) || hasOwnPropertyNullOrUndefined(DynamicObject, Object) */) {
                    if ((state & 0b100) != 0 /* is-active doJSObjectAnyKey(DynamicObject, Object) */) {
                        if ((JSGuards.isJSObject(arguments0Value__))) {
                            return doJSObjectAnyKey(arguments0Value__, arguments1Value_);
                        }
                    }
                    if ((state & 0b1000) != 0 /* is-active hasOwnPropertyNullOrUndefined(DynamicObject, Object) */) {
                        if ((JSGuards.isNullOrUndefined(arguments0Value__))) {
                            return hasOwnPropertyNullOrUndefined(arguments0Value__, arguments1Value_);
                        }
                    }
                }
            }
            if ((state & 0b1111110000) != 0 /* is-active hasOwnPropertyLazyString(JSLazyString, Object) || hasOwnPropertyPrimitive(Object, Object) || hasOwnPropertySymbol(Symbol, Object) || hasOwnPropertySafeInteger(SafeInteger, Object) || hasOwnPropertyBigInt(BigInt, Object) || hasOwnPropertyForeign(Object, Object) */) {
                if ((state & 0b10000) != 0 /* is-active hasOwnPropertyLazyString(JSLazyString, Object) */ && arguments0Value_ instanceof JSLazyString) {
                    JSLazyString arguments0Value__ = (JSLazyString) arguments0Value_;
                    return hasOwnPropertyLazyString(arguments0Value__, arguments1Value_);
                }
                if ((state & 0b100000) != 0 /* is-active hasOwnPropertyPrimitive(Object, Object) */) {
                    if ((!(JSGuards.isTruffleObject(arguments0Value_)))) {
                        return hasOwnPropertyPrimitive(arguments0Value_, arguments1Value_);
                    }
                }
                if ((state & 0b1000000) != 0 /* is-active hasOwnPropertySymbol(Symbol, Object) */ && arguments0Value_ instanceof Symbol) {
                    Symbol arguments0Value__ = (Symbol) arguments0Value_;
                    return hasOwnPropertySymbol(arguments0Value__, arguments1Value_);
                }
                if ((state & 0b10000000) != 0 /* is-active hasOwnPropertySafeInteger(SafeInteger, Object) */ && arguments0Value_ instanceof SafeInteger) {
                    SafeInteger arguments0Value__ = (SafeInteger) arguments0Value_;
                    return hasOwnPropertySafeInteger(arguments0Value__, arguments1Value_);
                }
                if ((state & 0b100000000) != 0 /* is-active hasOwnPropertyBigInt(BigInt, Object) */ && arguments0Value_ instanceof BigInt) {
                    BigInt arguments0Value__ = (BigInt) arguments0Value_;
                    return hasOwnPropertyBigInt(arguments0Value__, arguments1Value_);
                }
                if ((state & 0b1000000000) != 0 /* is-active hasOwnPropertyForeign(Object, Object) */) {
                    if ((JSGuards.isForeignObject(arguments0Value_))) {
                        return hasOwnPropertyForeign(arguments0Value_, arguments1Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            int state = state_;
            if ((state & 0b1111111101) == 0 /* only-active doJSObjectIntKey(DynamicObject, int) */ && (state & 0b1111111111) != 0  /* is-not doJSObjectStringKey(DynamicObject, String) && doJSObjectIntKey(DynamicObject, int) && doJSObjectAnyKey(DynamicObject, Object) && hasOwnPropertyNullOrUndefined(DynamicObject, Object) && hasOwnPropertyLazyString(JSLazyString, Object) && hasOwnPropertyPrimitive(Object, Object) && hasOwnPropertySymbol(Symbol, Object) && hasOwnPropertySafeInteger(SafeInteger, Object) && hasOwnPropertyBigInt(BigInt, Object) && hasOwnPropertyForeign(Object, Object) */) {
                return executeBoolean_int2(frameValue, state);
            } else {
                return executeBoolean_generic3(frameValue, state);
            }
        }

        private boolean executeBoolean_int2(VirtualFrame frameValue, int state) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            int arguments1Value_;
            try {
                arguments1Value_ = this.arguments1_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(arguments0Value_, ex.getResult());
            }
            assert (state & 0b10) != 0 /* is-active doJSObjectIntKey(DynamicObject, int) */;
            if (JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((JSGuards.isJSObject(arguments0Value__))) {
                    return doJSObjectIntKey(arguments0Value__, arguments1Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        private boolean executeBoolean_generic3(VirtualFrame frameValue, int state) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if ((state & 0b1111) != 0 /* is-active doJSObjectStringKey(DynamicObject, String) || doJSObjectIntKey(DynamicObject, int) || doJSObjectAnyKey(DynamicObject, Object) || hasOwnPropertyNullOrUndefined(DynamicObject, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state & 0b1) != 0 /* is-active doJSObjectStringKey(DynamicObject, String) */ && JSTypesGen.isImplicitString((state & 0b11110000000000) >>> 10 /* extract-implicit-active 1:String */, arguments1Value_)) {
                    String arguments1Value__ = JSTypesGen.asImplicitString((state & 0b11110000000000) >>> 10 /* extract-implicit-active 1:String */, arguments1Value_);
                    if ((JSGuards.isJSObject(arguments0Value__))) {
                        return doJSObjectStringKey(arguments0Value__, arguments1Value__);
                    }
                }
                if ((state & 0b10) != 0 /* is-active doJSObjectIntKey(DynamicObject, int) */ && arguments1Value_ instanceof Integer) {
                    int arguments1Value__ = (int) arguments1Value_;
                    if ((JSGuards.isJSObject(arguments0Value__))) {
                        return doJSObjectIntKey(arguments0Value__, arguments1Value__);
                    }
                }
                if ((state & 0b1100) != 0 /* is-active doJSObjectAnyKey(DynamicObject, Object) || hasOwnPropertyNullOrUndefined(DynamicObject, Object) */) {
                    if ((state & 0b100) != 0 /* is-active doJSObjectAnyKey(DynamicObject, Object) */) {
                        if ((JSGuards.isJSObject(arguments0Value__))) {
                            return doJSObjectAnyKey(arguments0Value__, arguments1Value_);
                        }
                    }
                    if ((state & 0b1000) != 0 /* is-active hasOwnPropertyNullOrUndefined(DynamicObject, Object) */) {
                        if ((JSGuards.isNullOrUndefined(arguments0Value__))) {
                            return hasOwnPropertyNullOrUndefined(arguments0Value__, arguments1Value_);
                        }
                    }
                }
            }
            if ((state & 0b1111110000) != 0 /* is-active hasOwnPropertyLazyString(JSLazyString, Object) || hasOwnPropertyPrimitive(Object, Object) || hasOwnPropertySymbol(Symbol, Object) || hasOwnPropertySafeInteger(SafeInteger, Object) || hasOwnPropertyBigInt(BigInt, Object) || hasOwnPropertyForeign(Object, Object) */) {
                if ((state & 0b10000) != 0 /* is-active hasOwnPropertyLazyString(JSLazyString, Object) */ && arguments0Value_ instanceof JSLazyString) {
                    JSLazyString arguments0Value__ = (JSLazyString) arguments0Value_;
                    return hasOwnPropertyLazyString(arguments0Value__, arguments1Value_);
                }
                if ((state & 0b100000) != 0 /* is-active hasOwnPropertyPrimitive(Object, Object) */) {
                    if ((!(JSGuards.isTruffleObject(arguments0Value_)))) {
                        return hasOwnPropertyPrimitive(arguments0Value_, arguments1Value_);
                    }
                }
                if ((state & 0b1000000) != 0 /* is-active hasOwnPropertySymbol(Symbol, Object) */ && arguments0Value_ instanceof Symbol) {
                    Symbol arguments0Value__ = (Symbol) arguments0Value_;
                    return hasOwnPropertySymbol(arguments0Value__, arguments1Value_);
                }
                if ((state & 0b10000000) != 0 /* is-active hasOwnPropertySafeInteger(SafeInteger, Object) */ && arguments0Value_ instanceof SafeInteger) {
                    SafeInteger arguments0Value__ = (SafeInteger) arguments0Value_;
                    return hasOwnPropertySafeInteger(arguments0Value__, arguments1Value_);
                }
                if ((state & 0b100000000) != 0 /* is-active hasOwnPropertyBigInt(BigInt, Object) */ && arguments0Value_ instanceof BigInt) {
                    BigInt arguments0Value__ = (BigInt) arguments0Value_;
                    return hasOwnPropertyBigInt(arguments0Value__, arguments1Value_);
                }
                if ((state & 0b1000000000) != 0 /* is-active hasOwnPropertyForeign(Object, Object) */) {
                    if ((JSGuards.isForeignObject(arguments0Value_))) {
                        return hasOwnPropertyForeign(arguments0Value_, arguments1Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            executeBoolean(frameValue);
            return;
        }

        private boolean executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int exclude = exclude_;
            try {
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if (((exclude & 0b1)) == 0 /* is-not-excluded doJSObjectStringKey(DynamicObject, String) */) {
                        int stringCast1;
                        if ((stringCast1 = JSTypesGen.specializeImplicitString(arguments1Value)) != 0) {
                            String arguments1Value_ = JSTypesGen.asImplicitString(stringCast1, arguments1Value);
                            if ((JSGuards.isJSObject(arguments0Value_))) {
                                state = (state | (stringCast1 << 10) /* set-implicit-active 1:String */);
                                this.state_ = state = state | 0b1 /* add-active doJSObjectStringKey(DynamicObject, String) */;
                                lock.unlock();
                                hasLock = false;
                                return doJSObjectStringKey(arguments0Value_, arguments1Value_);
                            }
                        }
                    }
                    if (((exclude & 0b10)) == 0 /* is-not-excluded doJSObjectIntKey(DynamicObject, int) */ && arguments1Value instanceof Integer) {
                        int arguments1Value_ = (int) arguments1Value;
                        if ((JSGuards.isJSObject(arguments0Value_))) {
                            this.state_ = state = state | 0b10 /* add-active doJSObjectIntKey(DynamicObject, int) */;
                            lock.unlock();
                            hasLock = false;
                            return doJSObjectIntKey(arguments0Value_, arguments1Value_);
                        }
                    }
                    if ((JSGuards.isJSObject(arguments0Value_))) {
                        this.exclude_ = exclude = exclude | 0b11 /* add-excluded doJSObjectStringKey(DynamicObject, String), doJSObjectIntKey(DynamicObject, int) */;
                        state = state & 0xfffffffc /* remove-active doJSObjectStringKey(DynamicObject, String), doJSObjectIntKey(DynamicObject, int) */;
                        this.state_ = state = state | 0b100 /* add-active doJSObjectAnyKey(DynamicObject, Object) */;
                        lock.unlock();
                        hasLock = false;
                        return doJSObjectAnyKey(arguments0Value_, arguments1Value);
                    }
                    if ((JSGuards.isNullOrUndefined(arguments0Value_))) {
                        this.state_ = state = state | 0b1000 /* add-active hasOwnPropertyNullOrUndefined(DynamicObject, Object) */;
                        lock.unlock();
                        hasLock = false;
                        return hasOwnPropertyNullOrUndefined(arguments0Value_, arguments1Value);
                    }
                }
                if (arguments0Value instanceof JSLazyString) {
                    JSLazyString arguments0Value_ = (JSLazyString) arguments0Value;
                    this.state_ = state = state | 0b10000 /* add-active hasOwnPropertyLazyString(JSLazyString, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return hasOwnPropertyLazyString(arguments0Value_, arguments1Value);
                }
                if ((!(JSGuards.isTruffleObject(arguments0Value)))) {
                    this.state_ = state = state | 0b100000 /* add-active hasOwnPropertyPrimitive(Object, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return hasOwnPropertyPrimitive(arguments0Value, arguments1Value);
                }
                if (arguments0Value instanceof Symbol) {
                    Symbol arguments0Value_ = (Symbol) arguments0Value;
                    this.state_ = state = state | 0b1000000 /* add-active hasOwnPropertySymbol(Symbol, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return hasOwnPropertySymbol(arguments0Value_, arguments1Value);
                }
                if (arguments0Value instanceof SafeInteger) {
                    SafeInteger arguments0Value_ = (SafeInteger) arguments0Value;
                    this.state_ = state = state | 0b10000000 /* add-active hasOwnPropertySafeInteger(SafeInteger, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return hasOwnPropertySafeInteger(arguments0Value_, arguments1Value);
                }
                if (arguments0Value instanceof BigInt) {
                    BigInt arguments0Value_ = (BigInt) arguments0Value;
                    this.state_ = state = state | 0b100000000 /* add-active hasOwnPropertyBigInt(BigInt, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return hasOwnPropertyBigInt(arguments0Value_, arguments1Value);
                }
                if ((JSGuards.isForeignObject(arguments0Value))) {
                    this.state_ = state = state | 0b1000000000 /* add-active hasOwnPropertyForeign(Object, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return hasOwnPropertyForeign(arguments0Value, arguments1Value);
                }
                throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_}, arguments0Value, arguments1Value);
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
                return NodeCost.MONOMORPHIC;
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
            s[0] = "doJSObjectStringKey";
            if ((state & 0b1) != 0 /* is-active doJSObjectStringKey(DynamicObject, String) */) {
                s[1] = (byte)0b01 /* active */;
            } else if ((exclude & 0b1) != 0 /* is-excluded doJSObjectStringKey(DynamicObject, String) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doJSObjectIntKey";
            if ((state & 0b10) != 0 /* is-active doJSObjectIntKey(DynamicObject, int) */) {
                s[1] = (byte)0b01 /* active */;
            } else if ((exclude & 0b10) != 0 /* is-excluded doJSObjectIntKey(DynamicObject, int) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "doJSObjectAnyKey";
            if ((state & 0b100) != 0 /* is-active doJSObjectAnyKey(DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "hasOwnPropertyNullOrUndefined";
            if ((state & 0b1000) != 0 /* is-active hasOwnPropertyNullOrUndefined(DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            s = new Object[3];
            s[0] = "hasOwnPropertyLazyString";
            if ((state & 0b10000) != 0 /* is-active hasOwnPropertyLazyString(JSLazyString, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[5] = s;
            s = new Object[3];
            s[0] = "hasOwnPropertyPrimitive";
            if ((state & 0b100000) != 0 /* is-active hasOwnPropertyPrimitive(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[6] = s;
            s = new Object[3];
            s[0] = "hasOwnPropertySymbol";
            if ((state & 0b1000000) != 0 /* is-active hasOwnPropertySymbol(Symbol, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[7] = s;
            s = new Object[3];
            s[0] = "hasOwnPropertySafeInteger";
            if ((state & 0b10000000) != 0 /* is-active hasOwnPropertySafeInteger(SafeInteger, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[8] = s;
            s = new Object[3];
            s[0] = "hasOwnPropertyBigInt";
            if ((state & 0b100000000) != 0 /* is-active hasOwnPropertyBigInt(BigInt, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[9] = s;
            s = new Object[3];
            s[0] = "hasOwnPropertyForeign";
            if ((state & 0b1000000000) != 0 /* is-active hasOwnPropertyForeign(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[10] = s;
            return Provider.create(data);
        }

        public static ObjectPrototypeHasOwnPropertyNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ObjectPrototypeHasOwnPropertyNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ObjectPrototypeIsPrototypeOfNode.class)
    public static final class ObjectPrototypeIsPrototypeOfNodeGen extends ObjectPrototypeIsPrototypeOfNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private int state_;

        private ObjectPrototypeIsPrototypeOfNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if (state != 0 /* is-active isPrototypeOf(Object, DynamicObject) || isPrototypeOfNoObject(Object, Object) */) {
                if ((state & 0b1) != 0 /* is-active isPrototypeOf(Object, DynamicObject) */ && JSTypes.isDynamicObject(arguments1Value_)) {
                    DynamicObject arguments1Value__ = (DynamicObject) arguments1Value_;
                    if ((JSGuards.isJSObject(arguments1Value__))) {
                        return isPrototypeOf(arguments0Value_, arguments1Value__);
                    }
                }
                if ((state & 0b10) != 0 /* is-active isPrototypeOfNoObject(Object, Object) */) {
                    if ((!(JSGuards.isJSObject(arguments1Value_)))) {
                        return isPrototypeOfNoObject(arguments0Value_, arguments1Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if (state != 0 /* is-active isPrototypeOf(Object, DynamicObject) || isPrototypeOfNoObject(Object, Object) */) {
                if ((state & 0b1) != 0 /* is-active isPrototypeOf(Object, DynamicObject) */ && JSTypes.isDynamicObject(arguments1Value_)) {
                    DynamicObject arguments1Value__ = (DynamicObject) arguments1Value_;
                    if ((JSGuards.isJSObject(arguments1Value__))) {
                        return isPrototypeOf(arguments0Value_, arguments1Value__);
                    }
                }
                if ((state & 0b10) != 0 /* is-active isPrototypeOfNoObject(Object, Object) */) {
                    if ((!(JSGuards.isJSObject(arguments1Value_)))) {
                        return isPrototypeOfNoObject(arguments0Value_, arguments1Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            executeBoolean(frameValue);
            return;
        }

        private boolean executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            int state = state_;
            if (JSTypes.isDynamicObject(arguments1Value)) {
                DynamicObject arguments1Value_ = (DynamicObject) arguments1Value;
                if ((JSGuards.isJSObject(arguments1Value_))) {
                    this.state_ = state = state | 0b1 /* add-active isPrototypeOf(Object, DynamicObject) */;
                    return isPrototypeOf(arguments0Value, arguments1Value_);
                }
            }
            if ((!(JSGuards.isJSObject(arguments1Value)))) {
                this.state_ = state = state | 0b10 /* add-active isPrototypeOfNoObject(Object, Object) */;
                return isPrototypeOfNoObject(arguments0Value, arguments1Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_}, arguments0Value, arguments1Value);
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
            s[0] = "isPrototypeOf";
            if ((state & 0b1) != 0 /* is-active isPrototypeOf(Object, DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "isPrototypeOfNoObject";
            if ((state & 0b10) != 0 /* is-active isPrototypeOfNoObject(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static ObjectPrototypeIsPrototypeOfNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ObjectPrototypeIsPrototypeOfNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ObjectPrototypeDefineGetterOrSetterNode.class)
    public static final class ObjectPrototypeDefineGetterOrSetterNodeGen extends ObjectPrototypeDefineGetterOrSetterNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;

        private ObjectPrototypeDefineGetterOrSetterNodeGen(JSContext context, JSBuiltin builtin, boolean getter, JavaScriptNode[] arguments) {
            super(context, builtin, getter);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
            this.arguments2_ = arguments != null && 2 < arguments.length ? arguments[2] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_, this.arguments2_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            return define(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.MONOMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            s = new Object[3];
            s[0] = "define";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static ObjectPrototypeDefineGetterOrSetterNode create(JSContext context, JSBuiltin builtin, boolean getter, JavaScriptNode[] arguments) {
            return new ObjectPrototypeDefineGetterOrSetterNodeGen(context, builtin, getter, arguments);
        }

    }
    @GeneratedBy(ObjectPrototypeLookupGetterOrSetterNode.class)
    public static final class ObjectPrototypeLookupGetterOrSetterNodeGen extends ObjectPrototypeLookupGetterOrSetterNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;

        private ObjectPrototypeLookupGetterOrSetterNodeGen(JSContext context, JSBuiltin builtin, boolean getter, JavaScriptNode[] arguments) {
            super(context, builtin, getter);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            return lookup(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.MONOMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            s = new Object[3];
            s[0] = "lookup";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static ObjectPrototypeLookupGetterOrSetterNode create(JSContext context, JSBuiltin builtin, boolean getter, JavaScriptNode[] arguments) {
            return new ObjectPrototypeLookupGetterOrSetterNodeGen(context, builtin, getter, arguments);
        }

    }
}
