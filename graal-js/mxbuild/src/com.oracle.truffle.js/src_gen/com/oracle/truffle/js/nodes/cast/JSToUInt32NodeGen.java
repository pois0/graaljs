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
import com.oracle.truffle.js.runtime.SafeInteger;
import com.oracle.truffle.js.runtime.Symbol;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSToUInt32Node.class)
public final class JSToUInt32NodeGen extends JSToUInt32Node implements Provider {

    @CompilationFinal private volatile int state_;
    @Child private JSStringToNumberNode string_stringToNumberNode_;
    @Child private JSToNumberNode jSObject_toNumberNode_;
    @Child private JSToPrimitiveNode foreignObject_toPrimitiveNode_;
    @Child private JSToUInt32Node foreignObject_toUInt32Node_;

    private JSToUInt32NodeGen() {
    }

    @Override
    public Object execute(Object arg0Value) {
        int state = state_;
        if ((state & 0b11) != 0 /* is-active doInteger(int) || doIntegerNegative(int) */ && arg0Value instanceof Integer) {
            int arg0Value_ = (int) arg0Value;
            if ((state & 0b1) != 0 /* is-active doInteger(int) */) {
                if ((arg0Value_ >= 0)) {
                    return doInteger(arg0Value_);
                }
            }
            if ((state & 0b10) != 0 /* is-active doIntegerNegative(int) */) {
                if ((arg0Value_ < 0)) {
                    return doIntegerNegative(arg0Value_);
                }
            }
        }
        if ((state & 0b100) != 0 /* is-active doSafeInteger(SafeInteger) */ && arg0Value instanceof SafeInteger) {
            SafeInteger arg0Value_ = (SafeInteger) arg0Value;
            return doSafeInteger(arg0Value_);
        }
        if ((state & 0b1000) != 0 /* is-active doBoolean(boolean) */ && arg0Value instanceof Boolean) {
            boolean arg0Value_ = (boolean) arg0Value;
            return doBoolean(arg0Value_);
        }
        if ((state & 0b10000) != 0 /* is-active doLong(long) */ && arg0Value instanceof Long) {
            long arg0Value_ = (long) arg0Value;
            return doLong(arg0Value_);
        }
        if ((state & 0b11100000) != 0 /* is-active doDoubleFitsInt32Negative(double) || doDoubleRepresentableAsLong(double) || doDouble(double) */ && JSTypesGen.isImplicitDouble((state & 0x78000) >>> 15 /* extract-implicit-active 0:double */, arg0Value)) {
            double arg0Value_ = JSTypesGen.asImplicitDouble((state & 0x78000) >>> 15 /* extract-implicit-active 0:double */, arg0Value);
            if ((state & 0b100000) != 0 /* is-active doDoubleFitsInt32Negative(double) */) {
                if ((!(JSGuards.isDoubleLargerThan2e32(arg0Value_)))) {
                    return doDoubleFitsInt32Negative(arg0Value_);
                }
            }
            if ((state & 0b1000000) != 0 /* is-active doDoubleRepresentableAsLong(double) */) {
                if ((JSGuards.isDoubleLargerThan2e32(arg0Value_)) && (JSGuards.isDoubleRepresentableAsLong(arg0Value_))) {
                    return doDoubleRepresentableAsLong(arg0Value_);
                }
            }
            if ((state & 0b10000000) != 0 /* is-active doDouble(double) */) {
                if ((JSGuards.isDoubleLargerThan2e32(arg0Value_)) && (!(JSGuards.isDoubleRepresentableAsLong(arg0Value_)))) {
                    return doDouble(arg0Value_);
                }
            }
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
        if ((state & 0b10000000000) != 0 /* is-active doString(String, JSStringToNumberNode) */ && JSTypesGen.isImplicitString((state & 0x780000) >>> 19 /* extract-implicit-active 0:String */, arg0Value)) {
            String arg0Value_ = JSTypesGen.asImplicitString((state & 0x780000) >>> 19 /* extract-implicit-active 0:String */, arg0Value);
            return doString(arg0Value_, this.string_stringToNumberNode_);
        }
        if ((state & 0b100000000000) != 0 /* is-active doSymbol(Symbol) */ && arg0Value instanceof Symbol) {
            Symbol arg0Value_ = (Symbol) arg0Value;
            return doSymbol(arg0Value_);
        }
        if ((state & 0b1000000000000) != 0 /* is-active doBigInt(BigInt) */ && arg0Value instanceof BigInt) {
            BigInt arg0Value_ = (BigInt) arg0Value;
            return doBigInt(arg0Value_);
        }
        if ((state & 0b10000000000000) != 0 /* is-active doJSObject(DynamicObject, JSToNumberNode) */ && JSTypes.isDynamicObject(arg0Value)) {
            DynamicObject arg0Value_ = (DynamicObject) arg0Value;
            if ((JSGuards.isJSObject(arg0Value_))) {
                return doJSObject(arg0Value_, this.jSObject_toNumberNode_);
            }
        }
        if ((state & 0b100000000000000) != 0 /* is-active doForeignObject(Object, JSToPrimitiveNode, JSToUInt32Node) */) {
            if ((JSGuards.isForeignObject(arg0Value))) {
                return JSToUInt32Node.doForeignObject(arg0Value, this.foreignObject_toPrimitiveNode_, this.foreignObject_toUInt32Node_);
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
        try {
            if (arg0Value instanceof Integer) {
                int arg0Value_ = (int) arg0Value;
                if ((arg0Value_ >= 0)) {
                    this.state_ = state = state | 0b1 /* add-active doInteger(int) */;
                    lock.unlock();
                    hasLock = false;
                    return doInteger(arg0Value_);
                }
                if ((arg0Value_ < 0)) {
                    this.state_ = state = state | 0b10 /* add-active doIntegerNegative(int) */;
                    lock.unlock();
                    hasLock = false;
                    return doIntegerNegative(arg0Value_);
                }
            }
            if (arg0Value instanceof SafeInteger) {
                SafeInteger arg0Value_ = (SafeInteger) arg0Value;
                this.state_ = state = state | 0b100 /* add-active doSafeInteger(SafeInteger) */;
                lock.unlock();
                hasLock = false;
                return doSafeInteger(arg0Value_);
            }
            if (arg0Value instanceof Boolean) {
                boolean arg0Value_ = (boolean) arg0Value;
                this.state_ = state = state | 0b1000 /* add-active doBoolean(boolean) */;
                lock.unlock();
                hasLock = false;
                return doBoolean(arg0Value_);
            }
            if (arg0Value instanceof Long) {
                long arg0Value_ = (long) arg0Value;
                this.state_ = state = state | 0b10000 /* add-active doLong(long) */;
                lock.unlock();
                hasLock = false;
                return doLong(arg0Value_);
            }
            {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(arg0Value)) != 0) {
                    double arg0Value_ = JSTypesGen.asImplicitDouble(doubleCast0, arg0Value);
                    if ((!(JSGuards.isDoubleLargerThan2e32(arg0Value_)))) {
                        state = (state | (doubleCast0 << 15) /* set-implicit-active 0:double */);
                        this.state_ = state = state | 0b100000 /* add-active doDoubleFitsInt32Negative(double) */;
                        lock.unlock();
                        hasLock = false;
                        return doDoubleFitsInt32Negative(arg0Value_);
                    }
                    if ((JSGuards.isDoubleLargerThan2e32(arg0Value_)) && (JSGuards.isDoubleRepresentableAsLong(arg0Value_))) {
                        state = (state | (doubleCast0 << 15) /* set-implicit-active 0:double */);
                        this.state_ = state = state | 0b1000000 /* add-active doDoubleRepresentableAsLong(double) */;
                        lock.unlock();
                        hasLock = false;
                        return doDoubleRepresentableAsLong(arg0Value_);
                    }
                    if ((JSGuards.isDoubleLargerThan2e32(arg0Value_)) && (!(JSGuards.isDoubleRepresentableAsLong(arg0Value_)))) {
                        state = (state | (doubleCast0 << 15) /* set-implicit-active 0:double */);
                        this.state_ = state = state | 0b10000000 /* add-active doDouble(double) */;
                        lock.unlock();
                        hasLock = false;
                        return doDouble(arg0Value_);
                    }
                }
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
            {
                int stringCast0;
                if ((stringCast0 = JSTypesGen.specializeImplicitString(arg0Value)) != 0) {
                    String arg0Value_ = JSTypesGen.asImplicitString(stringCast0, arg0Value);
                    this.string_stringToNumberNode_ = super.insert((JSStringToNumberNode.create()));
                    state = (state | (stringCast0 << 19) /* set-implicit-active 0:String */);
                    this.state_ = state = state | 0b10000000000 /* add-active doString(String, JSStringToNumberNode) */;
                    lock.unlock();
                    hasLock = false;
                    return doString(arg0Value_, this.string_stringToNumberNode_);
                }
            }
            if (arg0Value instanceof Symbol) {
                Symbol arg0Value_ = (Symbol) arg0Value;
                this.state_ = state = state | 0b100000000000 /* add-active doSymbol(Symbol) */;
                lock.unlock();
                hasLock = false;
                return doSymbol(arg0Value_);
            }
            if (arg0Value instanceof BigInt) {
                BigInt arg0Value_ = (BigInt) arg0Value;
                this.state_ = state = state | 0b1000000000000 /* add-active doBigInt(BigInt) */;
                lock.unlock();
                hasLock = false;
                return doBigInt(arg0Value_);
            }
            if (JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if ((JSGuards.isJSObject(arg0Value_))) {
                    this.jSObject_toNumberNode_ = super.insert((JSToNumberNode.create()));
                    this.state_ = state = state | 0b10000000000000 /* add-active doJSObject(DynamicObject, JSToNumberNode) */;
                    lock.unlock();
                    hasLock = false;
                    return doJSObject(arg0Value_, this.jSObject_toNumberNode_);
                }
            }
            if ((JSGuards.isForeignObject(arg0Value))) {
                this.foreignObject_toPrimitiveNode_ = super.insert((JSToPrimitiveNode.createHintNumber()));
                this.foreignObject_toUInt32Node_ = super.insert((JSToUInt32Node.create()));
                this.state_ = state = state | 0b100000000000000 /* add-active doForeignObject(Object, JSToPrimitiveNode, JSToUInt32Node) */;
                lock.unlock();
                hasLock = false;
                return JSToUInt32Node.doForeignObject(arg0Value, this.foreignObject_toPrimitiveNode_, this.foreignObject_toUInt32Node_);
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
        if ((state & 0b111111111111111) == 0b0) {
            return NodeCost.UNINITIALIZED;
        } else if (((state & 0b111111111111111) & ((state & 0b111111111111111) - 1)) == 0 /* is-single-active  */) {
            return NodeCost.MONOMORPHIC;
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[16];
        Object[] s;
        data[0] = 0;
        int state = state_;
        s = new Object[3];
        s[0] = "doInteger";
        if ((state & 0b1) != 0 /* is-active doInteger(int) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doIntegerNegative";
        if ((state & 0b10) != 0 /* is-active doIntegerNegative(int) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doSafeInteger";
        if ((state & 0b100) != 0 /* is-active doSafeInteger(SafeInteger) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doBoolean";
        if ((state & 0b1000) != 0 /* is-active doBoolean(boolean) */) {
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
        s[0] = "doDoubleFitsInt32Negative";
        if ((state & 0b100000) != 0 /* is-active doDoubleFitsInt32Negative(double) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "doDoubleRepresentableAsLong";
        if ((state & 0b1000000) != 0 /* is-active doDoubleRepresentableAsLong(double) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        s = new Object[3];
        s[0] = "doDouble";
        if ((state & 0b10000000) != 0 /* is-active doDouble(double) */) {
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
        s[0] = "doString";
        if ((state & 0b10000000000) != 0 /* is-active doString(String, JSStringToNumberNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.string_stringToNumberNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[11] = s;
        s = new Object[3];
        s[0] = "doSymbol";
        if ((state & 0b100000000000) != 0 /* is-active doSymbol(Symbol) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[12] = s;
        s = new Object[3];
        s[0] = "doBigInt";
        if ((state & 0b1000000000000) != 0 /* is-active doBigInt(BigInt) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[13] = s;
        s = new Object[3];
        s[0] = "doJSObject";
        if ((state & 0b10000000000000) != 0 /* is-active doJSObject(DynamicObject, JSToNumberNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.jSObject_toNumberNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[14] = s;
        s = new Object[3];
        s[0] = "doForeignObject";
        if ((state & 0b100000000000000) != 0 /* is-active doForeignObject(Object, JSToPrimitiveNode, JSToUInt32Node) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.foreignObject_toPrimitiveNode_, this.foreignObject_toUInt32Node_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[15] = s;
        return Provider.create(data);
    }

    public static JSToUInt32Node create() {
        return new JSToUInt32NodeGen();
    }

    @GeneratedBy(JSToUInt32WrapperNode.class)
    public static final class JSToUInt32WrapperNodeGen extends JSToUInt32WrapperNode implements Provider {

        private JSToUInt32WrapperNodeGen(JavaScriptNode operand) {
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

        public static JSToUInt32WrapperNode create(JavaScriptNode operand) {
            return new JSToUInt32WrapperNodeGen(operand);
        }

    }
}
