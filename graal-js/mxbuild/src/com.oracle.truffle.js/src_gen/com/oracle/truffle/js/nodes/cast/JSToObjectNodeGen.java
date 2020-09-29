// CheckStyle: start generated
package com.oracle.truffle.js.nodes.cast;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.runtime.BigInt;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.Symbol;
import com.oracle.truffle.js.runtime.objects.JSLazyString;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSToObjectNode.class)
public final class JSToObjectNodeGen extends JSToObjectNode implements Provider {

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private Class<?> jSObjectCached_cachedClass_;

    private JSToObjectNodeGen(JSContext context, boolean checkForNullOrUndefined, boolean fromWith, boolean allowForeign) {
        super(context, checkForNullOrUndefined, fromWith, allowForeign);
    }

    @Override
    public Object execute(Object arg0Value) {
        int state = state_;
        if ((state & 0b1) != 0 /* is-active doBoolean(boolean) */ && arg0Value instanceof Boolean) {
            boolean arg0Value_ = (boolean) arg0Value;
            return doBoolean(arg0Value_);
        }
        if ((state & 0b10) != 0 /* is-active doJSLazyString(JSLazyString) */ && arg0Value instanceof JSLazyString) {
            JSLazyString arg0Value_ = (JSLazyString) arg0Value;
            return doJSLazyString(arg0Value_);
        }
        if ((state & 0b100) != 0 /* is-active doString(String) */ && JSTypesGen.isImplicitString((state & 0x3c000) >>> 14 /* extract-implicit-active 0:String */, arg0Value)) {
            String arg0Value_ = JSTypesGen.asImplicitString((state & 0x3c000) >>> 14 /* extract-implicit-active 0:String */, arg0Value);
            return doString(arg0Value_);
        }
        if ((state & 0b1000) != 0 /* is-active doInt(int) */ && arg0Value instanceof Integer) {
            int arg0Value_ = (int) arg0Value;
            return doInt(arg0Value_);
        }
        if ((state & 0b10000) != 0 /* is-active doDouble(double) */ && JSTypesGen.isImplicitDouble((state & 0x3c0000) >>> 18 /* extract-implicit-active 0:double */, arg0Value)) {
            double arg0Value_ = JSTypesGen.asImplicitDouble((state & 0x3c0000) >>> 18 /* extract-implicit-active 0:double */, arg0Value);
            return doDouble(arg0Value_);
        }
        if ((state & 0b100000) != 0 /* is-active doBigInt(BigInt) */ && arg0Value instanceof BigInt) {
            BigInt arg0Value_ = (BigInt) arg0Value;
            return doBigInt(arg0Value_);
        }
        if ((state & 0b1000000) != 0 /* is-active doNumber(Object) */) {
            if ((JSGuards.isJavaNumber(arg0Value))) {
                return doNumber(arg0Value);
            }
        }
        if ((state & 0b10000000) != 0 /* is-active doSymbol(Symbol) */ && arg0Value instanceof Symbol) {
            Symbol arg0Value_ = (Symbol) arg0Value;
            return doSymbol(arg0Value_);
        }
        if ((state & 0b11100000000) != 0 /* is-active doJSObjectCached(Object, Class<>) || doJSObjectNoCheck(Object) || doJSObjectCheck(Object) */) {
            if ((state & 0b100000000) != 0 /* is-active doJSObjectCached(Object, Class<>) */) {
                assert (this.jSObjectCached_cachedClass_ != null);
                if ((this.jSObjectCached_cachedClass_.isInstance(arg0Value))) {
                    return JSToObjectNode.doJSObjectCached(arg0Value, this.jSObjectCached_cachedClass_);
                }
            }
            if ((state & 0b1000000000) != 0 /* is-active doJSObjectNoCheck(Object) */) {
                assert (!(isCheckForNullOrUndefined()));
                if ((JSGuards.isJSDynamicObject(arg0Value))) {
                    return doJSObjectNoCheck(arg0Value);
                }
            }
            if ((state & 0b10000000000) != 0 /* is-active doJSObjectCheck(Object) */) {
                assert (isCheckForNullOrUndefined());
                if ((JSGuards.isJSObject(arg0Value))) {
                    return doJSObjectCheck(arg0Value);
                }
            }
        }
        if ((state & 0b100000000000) != 0 /* is-active doNullOrUndefined(DynamicObject) */ && JSTypes.isDynamicObject(arg0Value)) {
            DynamicObject arg0Value_ = (DynamicObject) arg0Value;
            assert (isCheckForNullOrUndefined());
            if ((JSGuards.isNullOrUndefined(arg0Value_))) {
                return doNullOrUndefined(arg0Value_);
            }
        }
        if ((state & 0b11000000000000) != 0 /* is-active doForeignTruffleObject(Object) || doJavaGeneric(Object) */) {
            if ((state & 0b1000000000000) != 0 /* is-active doForeignTruffleObject(Object) */) {
                if ((JSGuards.isForeignObject(arg0Value))) {
                    return doForeignTruffleObject(arg0Value);
                }
            }
            if ((state & 0b10000000000000) != 0 /* is-active doJavaGeneric(Object) */) {
                if ((!(JSGuards.isBoolean(arg0Value))) && (!(JSGuards.isNumber(arg0Value))) && (!(JSGuards.isString(arg0Value))) && (!(JSGuards.isSymbol(arg0Value))) && (!(JSGuards.isJSObject(arg0Value))) && (!(JSGuards.isForeignObject(arg0Value)))) {
                    return doJavaGeneric(arg0Value);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    private Object executeAndSpecialize(Object arg0Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        int exclude = exclude_;
        try {
            if (arg0Value instanceof Boolean) {
                boolean arg0Value_ = (boolean) arg0Value;
                this.state_ = state = state | 0b1 /* add-active doBoolean(boolean) */;
                lock.unlock();
                hasLock = false;
                return doBoolean(arg0Value_);
            }
            if (arg0Value instanceof JSLazyString) {
                JSLazyString arg0Value_ = (JSLazyString) arg0Value;
                this.state_ = state = state | 0b10 /* add-active doJSLazyString(JSLazyString) */;
                lock.unlock();
                hasLock = false;
                return doJSLazyString(arg0Value_);
            }
            {
                int stringCast0;
                if ((stringCast0 = JSTypesGen.specializeImplicitString(arg0Value)) != 0) {
                    String arg0Value_ = JSTypesGen.asImplicitString(stringCast0, arg0Value);
                    state = (state | (stringCast0 << 14) /* set-implicit-active 0:String */);
                    this.state_ = state = state | 0b100 /* add-active doString(String) */;
                    lock.unlock();
                    hasLock = false;
                    return doString(arg0Value_);
                }
            }
            if (arg0Value instanceof Integer) {
                int arg0Value_ = (int) arg0Value;
                this.state_ = state = state | 0b1000 /* add-active doInt(int) */;
                lock.unlock();
                hasLock = false;
                return doInt(arg0Value_);
            }
            {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(arg0Value)) != 0) {
                    double arg0Value_ = JSTypesGen.asImplicitDouble(doubleCast0, arg0Value);
                    state = (state | (doubleCast0 << 18) /* set-implicit-active 0:double */);
                    this.state_ = state = state | 0b10000 /* add-active doDouble(double) */;
                    lock.unlock();
                    hasLock = false;
                    return doDouble(arg0Value_);
                }
            }
            if (arg0Value instanceof BigInt) {
                BigInt arg0Value_ = (BigInt) arg0Value;
                this.state_ = state = state | 0b100000 /* add-active doBigInt(BigInt) */;
                lock.unlock();
                hasLock = false;
                return doBigInt(arg0Value_);
            }
            if ((JSGuards.isJavaNumber(arg0Value))) {
                this.state_ = state = state | 0b1000000 /* add-active doNumber(Object) */;
                lock.unlock();
                hasLock = false;
                return doNumber(arg0Value);
            }
            if (arg0Value instanceof Symbol) {
                Symbol arg0Value_ = (Symbol) arg0Value;
                this.state_ = state = state | 0b10000000 /* add-active doSymbol(Symbol) */;
                lock.unlock();
                hasLock = false;
                return doSymbol(arg0Value_);
            }
            if ((exclude) == 0 /* is-not-excluded doJSObjectCached(Object, Class<>) */) {
                boolean JSObjectCached_duplicateFound_ = false;
                if ((state & 0b100000000) != 0 /* is-active doJSObjectCached(Object, Class<>) */) {
                    assert (this.jSObjectCached_cachedClass_ != null);
                    if ((this.jSObjectCached_cachedClass_.isInstance(arg0Value))) {
                        JSObjectCached_duplicateFound_ = true;
                    }
                }
                if (!JSObjectCached_duplicateFound_) {
                    {
                        Class<?> jSObjectCached_cachedClass__ = (getClassIfObject(arg0Value));
                        if ((jSObjectCached_cachedClass__ != null) && (jSObjectCached_cachedClass__.isInstance(arg0Value)) && ((state & 0b100000000)) == 0 /* is-not-active doJSObjectCached(Object, Class<>) */) {
                            this.jSObjectCached_cachedClass_ = jSObjectCached_cachedClass__;
                            this.state_ = state = state | 0b100000000 /* add-active doJSObjectCached(Object, Class<>) */;
                            JSObjectCached_duplicateFound_ = true;
                        }
                    }
                }
                if (JSObjectCached_duplicateFound_) {
                    lock.unlock();
                    hasLock = false;
                    return JSToObjectNode.doJSObjectCached(arg0Value, this.jSObjectCached_cachedClass_);
                }
            }
            if ((!(isCheckForNullOrUndefined())) && (JSGuards.isJSDynamicObject(arg0Value))) {
                this.exclude_ = exclude = exclude | 0b1 /* add-excluded doJSObjectCached(Object, Class<>) */;
                state = state & 0xfffffeff /* remove-active doJSObjectCached(Object, Class<>) */;
                this.state_ = state = state | 0b1000000000 /* add-active doJSObjectNoCheck(Object) */;
                lock.unlock();
                hasLock = false;
                return doJSObjectNoCheck(arg0Value);
            }
            if ((isCheckForNullOrUndefined()) && (JSGuards.isJSObject(arg0Value))) {
                this.exclude_ = exclude = exclude | 0b1 /* add-excluded doJSObjectCached(Object, Class<>) */;
                state = state & 0xfffffeff /* remove-active doJSObjectCached(Object, Class<>) */;
                this.state_ = state = state | 0b10000000000 /* add-active doJSObjectCheck(Object) */;
                lock.unlock();
                hasLock = false;
                return doJSObjectCheck(arg0Value);
            }
            if (JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if ((isCheckForNullOrUndefined()) && (JSGuards.isNullOrUndefined(arg0Value_))) {
                    this.state_ = state = state | 0b100000000000 /* add-active doNullOrUndefined(DynamicObject) */;
                    lock.unlock();
                    hasLock = false;
                    return doNullOrUndefined(arg0Value_);
                }
            }
            if ((JSGuards.isForeignObject(arg0Value))) {
                this.state_ = state = state | 0b1000000000000 /* add-active doForeignTruffleObject(Object) */;
                lock.unlock();
                hasLock = false;
                return doForeignTruffleObject(arg0Value);
            }
            if ((!(JSGuards.isBoolean(arg0Value))) && (!(JSGuards.isNumber(arg0Value))) && (!(JSGuards.isString(arg0Value))) && (!(JSGuards.isSymbol(arg0Value))) && (!(JSGuards.isJSObject(arg0Value))) && (!(JSGuards.isForeignObject(arg0Value)))) {
                this.state_ = state = state | 0b10000000000000 /* add-active doJavaGeneric(Object) */;
                lock.unlock();
                hasLock = false;
                return doJavaGeneric(arg0Value);
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
        if ((state & 0b11111111111111) == 0b0) {
            return NodeCost.UNINITIALIZED;
        } else if (((state & 0b11111111111111) & ((state & 0b11111111111111) - 1)) == 0 /* is-single-active  */) {
            return NodeCost.MONOMORPHIC;
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
        s[0] = "doBoolean";
        if ((state & 0b1) != 0 /* is-active doBoolean(boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doJSLazyString";
        if ((state & 0b10) != 0 /* is-active doJSLazyString(JSLazyString) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doString";
        if ((state & 0b100) != 0 /* is-active doString(String) */) {
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
        s[0] = "doDouble";
        if ((state & 0b10000) != 0 /* is-active doDouble(double) */) {
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
        s[0] = "doNumber";
        if ((state & 0b1000000) != 0 /* is-active doNumber(Object) */) {
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
        s[0] = "doJSObjectCached";
        if ((state & 0b100000000) != 0 /* is-active doJSObjectCached(Object, Class<>) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.jSObjectCached_cachedClass_));
            s[2] = cached;
        } else if (exclude != 0 /* is-excluded doJSObjectCached(Object, Class<>) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[9] = s;
        s = new Object[3];
        s[0] = "doJSObjectNoCheck";
        if ((state & 0b1000000000) != 0 /* is-active doJSObjectNoCheck(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[10] = s;
        s = new Object[3];
        s[0] = "doJSObjectCheck";
        if ((state & 0b10000000000) != 0 /* is-active doJSObjectCheck(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[11] = s;
        s = new Object[3];
        s[0] = "doNullOrUndefined";
        if ((state & 0b100000000000) != 0 /* is-active doNullOrUndefined(DynamicObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[12] = s;
        s = new Object[3];
        s[0] = "doForeignTruffleObject";
        if ((state & 0b1000000000000) != 0 /* is-active doForeignTruffleObject(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[13] = s;
        s = new Object[3];
        s[0] = "doJavaGeneric";
        if ((state & 0b10000000000000) != 0 /* is-active doJavaGeneric(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[14] = s;
        return Provider.create(data);
    }

    public static JSToObjectNode create(JSContext context, boolean checkForNullOrUndefined, boolean fromWith, boolean allowForeign) {
        return new JSToObjectNodeGen(context, checkForNullOrUndefined, fromWith, allowForeign);
    }

    @GeneratedBy(JSToObjectWrapperNode.class)
    public static final class JSToObjectWrapperNodeGen extends JSToObjectWrapperNode implements Provider {

        private JSToObjectWrapperNodeGen(JavaScriptNode operand, JSToObjectNode toObjectNode) {
            super(operand, toObjectNode);
        }

        @Override
        public Object execute(VirtualFrame frameValue, Object operandNodeValue) {
            return doDefault(operandNodeValue);
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object operandNodeValue_ = super.operandNode.execute(frameValue);
            return doDefault(operandNodeValue_);
        }

        @Override
        public DynamicObject executeDynamicObject(Object operandNodeValue) {
            return (DynamicObject) execute(null, operandNodeValue);
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
            s[0] = "doDefault";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSToObjectWrapperNode create(JavaScriptNode operand, JSToObjectNode toObjectNode) {
            return new JSToObjectWrapperNodeGen(operand, toObjectNode);
        }

    }
}
