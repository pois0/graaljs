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
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.runtime.BigInt;
import com.oracle.truffle.js.runtime.Symbol;
import com.oracle.truffle.js.runtime.objects.JSLazyString;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSToStringNode.class)
public final class JSToStringNodeGen extends JSToStringNode implements Provider {

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private ConditionProfile lazyString_flattenProfile_;
    @Child private JSDoubleToStringNode double_doubleToStringNode_;
    @Child private JSToPrimitiveNode jSObject_toPrimitiveHintStringNode_;
    @Child private JSToPrimitiveNode truffleObject_toPrimitiveNode_;

    private JSToStringNodeGen(boolean undefinedToEmpty, boolean symbolToString) {
        super(undefinedToEmpty, symbolToString);
    }

    @Override
    public String executeString(Object arg0Value) {
        int state = state_;
        if ((state & 0b1) != 0 /* is-active doLazyString(JSLazyString, ConditionProfile) */ && arg0Value instanceof JSLazyString) {
            JSLazyString arg0Value_ = (JSLazyString) arg0Value;
            return doLazyString(arg0Value_, this.lazyString_flattenProfile_);
        }
        if ((state & 0b10) != 0 /* is-active doString(String) */ && JSTypesGen.isImplicitString((state & 0b1111000000000000) >>> 12 /* extract-implicit-active 0:String */, arg0Value)) {
            String arg0Value_ = JSTypesGen.asImplicitString((state & 0b1111000000000000) >>> 12 /* extract-implicit-active 0:String */, arg0Value);
            return doString(arg0Value_);
        }
        if ((state & 0b1100) != 0 /* is-active doNull(Object) || doUndefined(Object) */) {
            if ((state & 0b100) != 0 /* is-active doNull(Object) */) {
                if ((JSGuards.isJSNull(arg0Value))) {
                    return doNull(arg0Value);
                }
            }
            if ((state & 0b1000) != 0 /* is-active doUndefined(Object) */) {
                if ((JSGuards.isUndefined(arg0Value))) {
                    return doUndefined(arg0Value);
                }
            }
        }
        if ((state & 0b10000) != 0 /* is-active doBoolean(boolean) */ && arg0Value instanceof Boolean) {
            boolean arg0Value_ = (boolean) arg0Value;
            return doBoolean(arg0Value_);
        }
        if ((state & 0b100000) != 0 /* is-active doInteger(int) */ && arg0Value instanceof Integer) {
            int arg0Value_ = (int) arg0Value;
            return doInteger(arg0Value_);
        }
        if ((state & 0b1000000) != 0 /* is-active doBigInt(BigInt) */ && arg0Value instanceof BigInt) {
            BigInt arg0Value_ = (BigInt) arg0Value;
            return doBigInt(arg0Value_);
        }
        if ((state & 0b10000000) != 0 /* is-active doLong(long) */ && arg0Value instanceof Long) {
            long arg0Value_ = (long) arg0Value;
            return doLong(arg0Value_);
        }
        if ((state & 0b100000000) != 0 /* is-active doDouble(double, JSDoubleToStringNode) */ && JSTypesGen.isImplicitDouble((state & 0xf0000) >>> 16 /* extract-implicit-active 0:double */, arg0Value)) {
            double arg0Value_ = JSTypesGen.asImplicitDouble((state & 0xf0000) >>> 16 /* extract-implicit-active 0:double */, arg0Value);
            return doDouble(arg0Value_, this.double_doubleToStringNode_);
        }
        if ((state & 0b1000000000) != 0 /* is-active doJSObject(DynamicObject, JSToPrimitiveNode) */ && JSTypes.isDynamicObject(arg0Value)) {
            DynamicObject arg0Value_ = (DynamicObject) arg0Value;
            if ((JSGuards.isJSDynamicObject(arg0Value_))) {
                return doJSObject(arg0Value_, this.jSObject_toPrimitiveHintStringNode_);
            }
        }
        if ((state & 0b10000000000) != 0 /* is-active doSymbol(Symbol) */ && arg0Value instanceof Symbol) {
            Symbol arg0Value_ = (Symbol) arg0Value;
            return doSymbol(arg0Value_);
        }
        if ((state & 0b100000000000) != 0 /* is-active doTruffleObject(Object, JSToPrimitiveNode) */) {
            if ((JSGuards.isForeignObject(arg0Value))) {
                return doTruffleObject(arg0Value, this.truffleObject_toPrimitiveNode_);
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
            if (arg0Value instanceof JSLazyString) {
                JSLazyString arg0Value_ = (JSLazyString) arg0Value;
                this.lazyString_flattenProfile_ = (ConditionProfile.createBinaryProfile());
                this.state_ = state = state | 0b1 /* add-active doLazyString(JSLazyString, ConditionProfile) */;
                lock.unlock();
                hasLock = false;
                return doLazyString(arg0Value_, this.lazyString_flattenProfile_);
            }
            {
                int stringCast0;
                if ((stringCast0 = JSTypesGen.specializeImplicitString(arg0Value)) != 0) {
                    String arg0Value_ = JSTypesGen.asImplicitString(stringCast0, arg0Value);
                    state = (state | (stringCast0 << 12) /* set-implicit-active 0:String */);
                    this.state_ = state = state | 0b10 /* add-active doString(String) */;
                    lock.unlock();
                    hasLock = false;
                    return doString(arg0Value_);
                }
            }
            if ((JSGuards.isJSNull(arg0Value))) {
                this.state_ = state = state | 0b100 /* add-active doNull(Object) */;
                lock.unlock();
                hasLock = false;
                return doNull(arg0Value);
            }
            if ((exclude) == 0 /* is-not-excluded doUndefined(Object) */) {
                if ((JSGuards.isUndefined(arg0Value))) {
                    this.state_ = state = state | 0b1000 /* add-active doUndefined(Object) */;
                    lock.unlock();
                    hasLock = false;
                    return doUndefined(arg0Value);
                }
            }
            if (arg0Value instanceof Boolean) {
                boolean arg0Value_ = (boolean) arg0Value;
                this.state_ = state = state | 0b10000 /* add-active doBoolean(boolean) */;
                lock.unlock();
                hasLock = false;
                return doBoolean(arg0Value_);
            }
            if (arg0Value instanceof Integer) {
                int arg0Value_ = (int) arg0Value;
                this.state_ = state = state | 0b100000 /* add-active doInteger(int) */;
                lock.unlock();
                hasLock = false;
                return doInteger(arg0Value_);
            }
            if (arg0Value instanceof BigInt) {
                BigInt arg0Value_ = (BigInt) arg0Value;
                this.state_ = state = state | 0b1000000 /* add-active doBigInt(BigInt) */;
                lock.unlock();
                hasLock = false;
                return doBigInt(arg0Value_);
            }
            if (arg0Value instanceof Long) {
                long arg0Value_ = (long) arg0Value;
                this.state_ = state = state | 0b10000000 /* add-active doLong(long) */;
                lock.unlock();
                hasLock = false;
                return doLong(arg0Value_);
            }
            {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(arg0Value)) != 0) {
                    double arg0Value_ = JSTypesGen.asImplicitDouble(doubleCast0, arg0Value);
                    this.double_doubleToStringNode_ = super.insert((JSDoubleToStringNode.create()));
                    state = (state | (doubleCast0 << 16) /* set-implicit-active 0:double */);
                    this.state_ = state = state | 0b100000000 /* add-active doDouble(double, JSDoubleToStringNode) */;
                    lock.unlock();
                    hasLock = false;
                    return doDouble(arg0Value_, this.double_doubleToStringNode_);
                }
            }
            if (JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if ((JSGuards.isJSDynamicObject(arg0Value_))) {
                    this.jSObject_toPrimitiveHintStringNode_ = super.insert((JSToPrimitiveNode.createHintString()));
                    this.exclude_ = exclude = exclude | 0b1 /* add-excluded doUndefined(Object) */;
                    state = state & 0xfffffff7 /* remove-active doUndefined(Object) */;
                    this.state_ = state = state | 0b1000000000 /* add-active doJSObject(DynamicObject, JSToPrimitiveNode) */;
                    lock.unlock();
                    hasLock = false;
                    return doJSObject(arg0Value_, this.jSObject_toPrimitiveHintStringNode_);
                }
            }
            if (arg0Value instanceof Symbol) {
                Symbol arg0Value_ = (Symbol) arg0Value;
                this.state_ = state = state | 0b10000000000 /* add-active doSymbol(Symbol) */;
                lock.unlock();
                hasLock = false;
                return doSymbol(arg0Value_);
            }
            if ((JSGuards.isForeignObject(arg0Value))) {
                this.truffleObject_toPrimitiveNode_ = super.insert((JSToPrimitiveNode.createHintString()));
                this.state_ = state = state | 0b100000000000 /* add-active doTruffleObject(Object, JSToPrimitiveNode) */;
                lock.unlock();
                hasLock = false;
                return doTruffleObject(arg0Value, this.truffleObject_toPrimitiveNode_);
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
        if ((state & 0b111111111111) == 0b0) {
            return NodeCost.UNINITIALIZED;
        } else if (((state & 0b111111111111) & ((state & 0b111111111111) - 1)) == 0 /* is-single-active  */) {
            return NodeCost.MONOMORPHIC;
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
        s[0] = "doLazyString";
        if ((state & 0b1) != 0 /* is-active doLazyString(JSLazyString, ConditionProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.lazyString_flattenProfile_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doString";
        if ((state & 0b10) != 0 /* is-active doString(String) */) {
            s[1] = (byte)0b01 /* active */;
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
        } else if (exclude != 0 /* is-excluded doUndefined(Object) */) {
            s[1] = (byte)0b10 /* excluded */;
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
        s[0] = "doInteger";
        if ((state & 0b100000) != 0 /* is-active doInteger(int) */) {
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
        s[0] = "doLong";
        if ((state & 0b10000000) != 0 /* is-active doLong(long) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[8] = s;
        s = new Object[3];
        s[0] = "doDouble";
        if ((state & 0b100000000) != 0 /* is-active doDouble(double, JSDoubleToStringNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.double_doubleToStringNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[9] = s;
        s = new Object[3];
        s[0] = "doJSObject";
        if ((state & 0b1000000000) != 0 /* is-active doJSObject(DynamicObject, JSToPrimitiveNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.jSObject_toPrimitiveHintStringNode_));
            s[2] = cached;
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
        s[0] = "doTruffleObject";
        if ((state & 0b100000000000) != 0 /* is-active doTruffleObject(Object, JSToPrimitiveNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.truffleObject_toPrimitiveNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[12] = s;
        return Provider.create(data);
    }

    public static JSToStringNode create(boolean undefinedToEmpty, boolean symbolToString) {
        return new JSToStringNodeGen(undefinedToEmpty, symbolToString);
    }

    @GeneratedBy(JSToStringWrapperNode.class)
    public static final class JSToStringWrapperNodeGen extends JSToStringWrapperNode implements Provider {

        private JSToStringWrapperNodeGen(JavaScriptNode operand) {
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

        public static JSToStringWrapperNode create(JavaScriptNode operand) {
            return new JSToStringWrapperNodeGen(operand);
        }

    }
}
