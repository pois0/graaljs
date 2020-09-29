// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

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
import com.oracle.truffle.js.runtime.SafeInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(RequireObjectCoercibleNode.class)
public final class RequireObjectCoercibleNodeGen extends RequireObjectCoercibleNode implements Provider {

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private Class<?> cachedJSClass_cachedClass_;

    private RequireObjectCoercibleNodeGen() {
    }

    @Override
    public void executeVoid(Object arg0Value) {
        int state = state_;
        if ((state & 0b1) != 0 /* is-active doInt(int) */ && arg0Value instanceof Integer) {
            int arg0Value_ = (int) arg0Value;
            RequireObjectCoercibleNode.doInt(arg0Value_);
            return;
        }
        if ((state & 0b10) != 0 /* is-active doSafeInteger(SafeInteger) */ && arg0Value instanceof SafeInteger) {
            SafeInteger arg0Value_ = (SafeInteger) arg0Value;
            RequireObjectCoercibleNode.doSafeInteger(arg0Value_);
            return;
        }
        if ((state & 0b100) != 0 /* is-active doLong(long) */ && arg0Value instanceof Long) {
            long arg0Value_ = (long) arg0Value;
            RequireObjectCoercibleNode.doLong(arg0Value_);
            return;
        }
        if ((state & 0b1000) != 0 /* is-active doDouble(double) */ && JSTypesGen.isImplicitDouble((state & 0b1111000000000) >>> 9 /* extract-implicit-active 0:double */, arg0Value)) {
            double arg0Value_ = JSTypesGen.asImplicitDouble((state & 0b1111000000000) >>> 9 /* extract-implicit-active 0:double */, arg0Value);
            RequireObjectCoercibleNode.doDouble(arg0Value_);
            return;
        }
        if ((state & 0b10000) != 0 /* is-active doCharSequence(CharSequence) */ && JSTypesGen.isImplicitCharSequence((state & 0x1e000) >>> 13 /* extract-implicit-active 0:CharSequence */, arg0Value)) {
            CharSequence arg0Value_ = JSTypesGen.asImplicitCharSequence((state & 0x1e000) >>> 13 /* extract-implicit-active 0:CharSequence */, arg0Value);
            RequireObjectCoercibleNode.doCharSequence(arg0Value_);
            return;
        }
        if ((state & 0b100000) != 0 /* is-active doBoolean(boolean) */ && arg0Value instanceof Boolean) {
            boolean arg0Value_ = (boolean) arg0Value;
            RequireObjectCoercibleNode.doBoolean(arg0Value_);
            return;
        }
        if ((state & 0b11000000) != 0 /* is-active doCachedJSClass(Object, Class<>) || doObjectCoercible(Object) */) {
            if ((state & 0b1000000) != 0 /* is-active doCachedJSClass(Object, Class<>) */) {
                assert (this.cachedJSClass_cachedClass_ != null);
                if ((this.cachedJSClass_cachedClass_.isInstance(arg0Value))) {
                    RequireObjectCoercibleNode.doCachedJSClass(arg0Value, this.cachedJSClass_cachedClass_);
                    return;
                }
            }
            if ((state & 0b10000000) != 0 /* is-active doObjectCoercible(Object) */) {
                if ((!(JSGuards.isNullOrUndefined(arg0Value)))) {
                    RequireObjectCoercibleNode.doObjectCoercible(arg0Value);
                    return;
                }
            }
        }
        if ((state & 0b100000000) != 0 /* is-active doNullOrUndefined(DynamicObject) */ && JSTypes.isDynamicObject(arg0Value)) {
            DynamicObject arg0Value_ = (DynamicObject) arg0Value;
            if ((JSGuards.isNullOrUndefined(arg0Value_))) {
                doNullOrUndefined(arg0Value_);
                return;
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        executeAndSpecialize(arg0Value);
        return;
    }

    private void executeAndSpecialize(Object arg0Value) {
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
                RequireObjectCoercibleNode.doInt(arg0Value_);
                return;
            }
            if (arg0Value instanceof SafeInteger) {
                SafeInteger arg0Value_ = (SafeInteger) arg0Value;
                this.state_ = state = state | 0b10 /* add-active doSafeInteger(SafeInteger) */;
                lock.unlock();
                hasLock = false;
                RequireObjectCoercibleNode.doSafeInteger(arg0Value_);
                return;
            }
            if (arg0Value instanceof Long) {
                long arg0Value_ = (long) arg0Value;
                this.state_ = state = state | 0b100 /* add-active doLong(long) */;
                lock.unlock();
                hasLock = false;
                RequireObjectCoercibleNode.doLong(arg0Value_);
                return;
            }
            {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(arg0Value)) != 0) {
                    double arg0Value_ = JSTypesGen.asImplicitDouble(doubleCast0, arg0Value);
                    state = (state | (doubleCast0 << 9) /* set-implicit-active 0:double */);
                    this.state_ = state = state | 0b1000 /* add-active doDouble(double) */;
                    lock.unlock();
                    hasLock = false;
                    RequireObjectCoercibleNode.doDouble(arg0Value_);
                    return;
                }
            }
            {
                int charSequenceCast0;
                if ((charSequenceCast0 = JSTypesGen.specializeImplicitCharSequence(arg0Value)) != 0) {
                    CharSequence arg0Value_ = JSTypesGen.asImplicitCharSequence(charSequenceCast0, arg0Value);
                    state = (state | (charSequenceCast0 << 13) /* set-implicit-active 0:CharSequence */);
                    this.state_ = state = state | 0b10000 /* add-active doCharSequence(CharSequence) */;
                    lock.unlock();
                    hasLock = false;
                    RequireObjectCoercibleNode.doCharSequence(arg0Value_);
                    return;
                }
            }
            if (arg0Value instanceof Boolean) {
                boolean arg0Value_ = (boolean) arg0Value;
                this.state_ = state = state | 0b100000 /* add-active doBoolean(boolean) */;
                lock.unlock();
                hasLock = false;
                RequireObjectCoercibleNode.doBoolean(arg0Value_);
                return;
            }
            if ((exclude) == 0 /* is-not-excluded doCachedJSClass(Object, Class<>) */) {
                boolean CachedJSClass_duplicateFound_ = false;
                if ((state & 0b1000000) != 0 /* is-active doCachedJSClass(Object, Class<>) */) {
                    assert (this.cachedJSClass_cachedClass_ != null);
                    if ((this.cachedJSClass_cachedClass_.isInstance(arg0Value))) {
                        CachedJSClass_duplicateFound_ = true;
                    }
                }
                if (!CachedJSClass_duplicateFound_) {
                    {
                        Class<?> cachedJSClass_cachedClass__ = (JSGuards.getClassIfJSObject(arg0Value));
                        if ((cachedJSClass_cachedClass__ != null) && (cachedJSClass_cachedClass__.isInstance(arg0Value)) && ((state & 0b1000000)) == 0 /* is-not-active doCachedJSClass(Object, Class<>) */) {
                            this.cachedJSClass_cachedClass_ = cachedJSClass_cachedClass__;
                            this.state_ = state = state | 0b1000000 /* add-active doCachedJSClass(Object, Class<>) */;
                            CachedJSClass_duplicateFound_ = true;
                        }
                    }
                }
                if (CachedJSClass_duplicateFound_) {
                    lock.unlock();
                    hasLock = false;
                    RequireObjectCoercibleNode.doCachedJSClass(arg0Value, this.cachedJSClass_cachedClass_);
                    return;
                }
            }
            if ((!(JSGuards.isNullOrUndefined(arg0Value)))) {
                this.exclude_ = exclude = exclude | 0b1 /* add-excluded doCachedJSClass(Object, Class<>) */;
                state = state & 0xffffffbf /* remove-active doCachedJSClass(Object, Class<>) */;
                this.state_ = state = state | 0b10000000 /* add-active doObjectCoercible(Object) */;
                lock.unlock();
                hasLock = false;
                RequireObjectCoercibleNode.doObjectCoercible(arg0Value);
                return;
            }
            if (JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if ((JSGuards.isNullOrUndefined(arg0Value_))) {
                    this.state_ = state = state | 0b100000000 /* add-active doNullOrUndefined(DynamicObject) */;
                    lock.unlock();
                    hasLock = false;
                    doNullOrUndefined(arg0Value_);
                    return;
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
        if ((state & 0b111111111) == 0b0) {
            return NodeCost.UNINITIALIZED;
        } else if (((state & 0b111111111) & ((state & 0b111111111) - 1)) == 0 /* is-single-active  */) {
            return NodeCost.MONOMORPHIC;
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[10];
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
        s[0] = "doCharSequence";
        if ((state & 0b10000) != 0 /* is-active doCharSequence(CharSequence) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "doBoolean";
        if ((state & 0b100000) != 0 /* is-active doBoolean(boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "doCachedJSClass";
        if ((state & 0b1000000) != 0 /* is-active doCachedJSClass(Object, Class<>) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.cachedJSClass_cachedClass_));
            s[2] = cached;
        } else if (exclude != 0 /* is-excluded doCachedJSClass(Object, Class<>) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        s = new Object[3];
        s[0] = "doObjectCoercible";
        if ((state & 0b10000000) != 0 /* is-active doObjectCoercible(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[8] = s;
        s = new Object[3];
        s[0] = "doNullOrUndefined";
        if ((state & 0b100000000) != 0 /* is-active doNullOrUndefined(DynamicObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[9] = s;
        return Provider.create(data);
    }

    public static RequireObjectCoercibleNode create() {
        return new RequireObjectCoercibleNodeGen();
    }

    @GeneratedBy(RequireObjectCoercibleWrapperNode.class)
    public static final class RequireObjectCoercibleWrapperNodeGen extends RequireObjectCoercibleWrapperNode implements Provider {

        private RequireObjectCoercibleWrapperNodeGen(JavaScriptNode operand) {
            super(operand);
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

        public static RequireObjectCoercibleWrapperNode create(JavaScriptNode operand) {
            return new RequireObjectCoercibleWrapperNodeGen(operand);
        }

    }
}
