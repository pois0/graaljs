// CheckStyle: start generated
package com.oracle.truffle.js.nodes.cast;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.runtime.BigInt;
import com.oracle.truffle.js.runtime.Symbol;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSToDoubleNode.class)
public final class JSToDoubleNodeGen extends JSToDoubleNode implements Provider {

    @CompilationFinal private volatile int state_;
    @Child private JSStringToNumberNode stringDouble_stringToNumberNode_;
    @Child private JSToPrimitiveNode jSObject_toPrimitiveNode_;
    @Child private JSToPrimitiveNode foreignObject_toPrimitiveNode_;

    private JSToDoubleNodeGen() {
    }

    @Override
    public Object execute(Object arg0Value) {
        int state = state_;
        if ((state & 0b1) != 0 /* is-active doInteger(int) */ && arg0Value instanceof Integer) {
            int arg0Value_ = (int) arg0Value;
            return JSToDoubleNode.doInteger(arg0Value_);
        }
        if ((state & 0b10) != 0 /* is-active doBoolean(boolean) */ && arg0Value instanceof Boolean) {
            boolean arg0Value_ = (boolean) arg0Value;
            return JSToDoubleNode.doBoolean(arg0Value_);
        }
        if ((state & 0b100) != 0 /* is-active doDouble(double) */ && JSTypesGen.isImplicitDouble((state & 0b111100000000000) >>> 11 /* extract-implicit-active 0:double */, arg0Value)) {
            double arg0Value_ = JSTypesGen.asImplicitDouble((state & 0b111100000000000) >>> 11 /* extract-implicit-active 0:double */, arg0Value);
            return JSToDoubleNode.doDouble(arg0Value_);
        }
        if ((state & 0b1000) != 0 /* is-active doBigInt(BigInt) */ && arg0Value instanceof BigInt) {
            BigInt arg0Value_ = (BigInt) arg0Value;
            return doBigInt(arg0Value_);
        }
        if ((state & 0b110000) != 0 /* is-active doNull(Object) || doUndefined(Object) */) {
            if ((state & 0b10000) != 0 /* is-active doNull(Object) */) {
                if ((JSGuards.isJSNull(arg0Value))) {
                    return JSToDoubleNode.doNull(arg0Value);
                }
            }
            if ((state & 0b100000) != 0 /* is-active doUndefined(Object) */) {
                if ((JSGuards.isUndefined(arg0Value))) {
                    return JSToDoubleNode.doUndefined(arg0Value);
                }
            }
        }
        if ((state & 0b1000000) != 0 /* is-active doStringDouble(String, JSStringToNumberNode) */ && JSTypesGen.isImplicitString((state & 0x78000) >>> 15 /* extract-implicit-active 0:String */, arg0Value)) {
            String arg0Value_ = JSTypesGen.asImplicitString((state & 0x78000) >>> 15 /* extract-implicit-active 0:String */, arg0Value);
            return JSToDoubleNode.doStringDouble(arg0Value_, this.stringDouble_stringToNumberNode_);
        }
        if ((state & 0b10000000) != 0 /* is-active doJSObject(DynamicObject, JSToPrimitiveNode) */ && JSTypes.isDynamicObject(arg0Value)) {
            DynamicObject arg0Value_ = (DynamicObject) arg0Value;
            if ((JSGuards.isJSObject(arg0Value_))) {
                return doJSObject(arg0Value_, this.jSObject_toPrimitiveNode_);
            }
        }
        if ((state & 0b100000000) != 0 /* is-active doSymbol(Symbol) */ && arg0Value instanceof Symbol) {
            Symbol arg0Value_ = (Symbol) arg0Value;
            return doSymbol(arg0Value_);
        }
        if ((state & 0b11000000000) != 0 /* is-active doForeignObject(Object, JSToPrimitiveNode) || doJavaNumber(Object) */) {
            if ((state & 0b1000000000) != 0 /* is-active doForeignObject(Object, JSToPrimitiveNode) */) {
                if ((JSGuards.isForeignObject(arg0Value))) {
                    return doForeignObject(arg0Value, this.foreignObject_toPrimitiveNode_);
                }
            }
            if ((state & 0b10000000000) != 0 /* is-active doJavaNumber(Object) */) {
                if ((JSGuards.isJavaNumber(arg0Value))) {
                    return JSToDoubleNode.doJavaNumber(arg0Value);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    @Override
    public double executeDouble(Object arg0Value) {
        int state = state_;
        if ((state & 0b1) != 0 /* is-active doInteger(int) */ && arg0Value instanceof Integer) {
            int arg0Value_ = (int) arg0Value;
            return JSToDoubleNode.doInteger(arg0Value_);
        }
        if ((state & 0b10) != 0 /* is-active doBoolean(boolean) */ && arg0Value instanceof Boolean) {
            boolean arg0Value_ = (boolean) arg0Value;
            return JSToDoubleNode.doBoolean(arg0Value_);
        }
        if ((state & 0b100) != 0 /* is-active doDouble(double) */ && JSTypesGen.isImplicitDouble((state & 0b111100000000000) >>> 11 /* extract-implicit-active 0:double */, arg0Value)) {
            double arg0Value_ = JSTypesGen.asImplicitDouble((state & 0b111100000000000) >>> 11 /* extract-implicit-active 0:double */, arg0Value);
            return JSToDoubleNode.doDouble(arg0Value_);
        }
        if ((state & 0b1000) != 0 /* is-active doBigInt(BigInt) */ && arg0Value instanceof BigInt) {
            BigInt arg0Value_ = (BigInt) arg0Value;
            return doBigInt(arg0Value_);
        }
        if ((state & 0b110000) != 0 /* is-active doNull(Object) || doUndefined(Object) */) {
            if ((state & 0b10000) != 0 /* is-active doNull(Object) */) {
                if ((JSGuards.isJSNull(arg0Value))) {
                    return JSToDoubleNode.doNull(arg0Value);
                }
            }
            if ((state & 0b100000) != 0 /* is-active doUndefined(Object) */) {
                if ((JSGuards.isUndefined(arg0Value))) {
                    return JSToDoubleNode.doUndefined(arg0Value);
                }
            }
        }
        if ((state & 0b1000000) != 0 /* is-active doStringDouble(String, JSStringToNumberNode) */ && JSTypesGen.isImplicitString((state & 0x78000) >>> 15 /* extract-implicit-active 0:String */, arg0Value)) {
            String arg0Value_ = JSTypesGen.asImplicitString((state & 0x78000) >>> 15 /* extract-implicit-active 0:String */, arg0Value);
            return JSToDoubleNode.doStringDouble(arg0Value_, this.stringDouble_stringToNumberNode_);
        }
        if ((state & 0b10000000) != 0 /* is-active doJSObject(DynamicObject, JSToPrimitiveNode) */ && JSTypes.isDynamicObject(arg0Value)) {
            DynamicObject arg0Value_ = (DynamicObject) arg0Value;
            if ((JSGuards.isJSObject(arg0Value_))) {
                return doJSObject(arg0Value_, this.jSObject_toPrimitiveNode_);
            }
        }
        if ((state & 0b100000000) != 0 /* is-active doSymbol(Symbol) */ && arg0Value instanceof Symbol) {
            Symbol arg0Value_ = (Symbol) arg0Value;
            return doSymbol(arg0Value_);
        }
        if ((state & 0b11000000000) != 0 /* is-active doForeignObject(Object, JSToPrimitiveNode) || doJavaNumber(Object) */) {
            if ((state & 0b1000000000) != 0 /* is-active doForeignObject(Object, JSToPrimitiveNode) */) {
                if ((JSGuards.isForeignObject(arg0Value))) {
                    return doForeignObject(arg0Value, this.foreignObject_toPrimitiveNode_);
                }
            }
            if ((state & 0b10000000000) != 0 /* is-active doJavaNumber(Object) */) {
                if ((JSGuards.isJavaNumber(arg0Value))) {
                    return JSToDoubleNode.doJavaNumber(arg0Value);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    private double executeAndSpecialize(Object arg0Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        try {
            if (arg0Value instanceof Integer) {
                int arg0Value_ = (int) arg0Value;
                this.state_ = state = state | 0b1 /* add-active doInteger(int) */;
                lock.unlock();
                hasLock = false;
                return JSToDoubleNode.doInteger(arg0Value_);
            }
            if (arg0Value instanceof Boolean) {
                boolean arg0Value_ = (boolean) arg0Value;
                this.state_ = state = state | 0b10 /* add-active doBoolean(boolean) */;
                lock.unlock();
                hasLock = false;
                return JSToDoubleNode.doBoolean(arg0Value_);
            }
            {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(arg0Value)) != 0) {
                    double arg0Value_ = JSTypesGen.asImplicitDouble(doubleCast0, arg0Value);
                    state = (state | (doubleCast0 << 11) /* set-implicit-active 0:double */);
                    this.state_ = state = state | 0b100 /* add-active doDouble(double) */;
                    lock.unlock();
                    hasLock = false;
                    return JSToDoubleNode.doDouble(arg0Value_);
                }
            }
            if (arg0Value instanceof BigInt) {
                BigInt arg0Value_ = (BigInt) arg0Value;
                this.state_ = state = state | 0b1000 /* add-active doBigInt(BigInt) */;
                lock.unlock();
                hasLock = false;
                return doBigInt(arg0Value_);
            }
            if ((JSGuards.isJSNull(arg0Value))) {
                this.state_ = state = state | 0b10000 /* add-active doNull(Object) */;
                lock.unlock();
                hasLock = false;
                return JSToDoubleNode.doNull(arg0Value);
            }
            if ((JSGuards.isUndefined(arg0Value))) {
                this.state_ = state = state | 0b100000 /* add-active doUndefined(Object) */;
                lock.unlock();
                hasLock = false;
                return JSToDoubleNode.doUndefined(arg0Value);
            }
            {
                int stringCast0;
                if ((stringCast0 = JSTypesGen.specializeImplicitString(arg0Value)) != 0) {
                    String arg0Value_ = JSTypesGen.asImplicitString(stringCast0, arg0Value);
                    this.stringDouble_stringToNumberNode_ = super.insert((JSStringToNumberNode.create()));
                    state = (state | (stringCast0 << 15) /* set-implicit-active 0:String */);
                    this.state_ = state = state | 0b1000000 /* add-active doStringDouble(String, JSStringToNumberNode) */;
                    lock.unlock();
                    hasLock = false;
                    return JSToDoubleNode.doStringDouble(arg0Value_, this.stringDouble_stringToNumberNode_);
                }
            }
            if (JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if ((JSGuards.isJSObject(arg0Value_))) {
                    this.jSObject_toPrimitiveNode_ = super.insert((JSToPrimitiveNode.createHintNumber()));
                    this.state_ = state = state | 0b10000000 /* add-active doJSObject(DynamicObject, JSToPrimitiveNode) */;
                    lock.unlock();
                    hasLock = false;
                    return doJSObject(arg0Value_, this.jSObject_toPrimitiveNode_);
                }
            }
            if (arg0Value instanceof Symbol) {
                Symbol arg0Value_ = (Symbol) arg0Value;
                this.state_ = state = state | 0b100000000 /* add-active doSymbol(Symbol) */;
                lock.unlock();
                hasLock = false;
                return doSymbol(arg0Value_);
            }
            if ((JSGuards.isForeignObject(arg0Value))) {
                this.foreignObject_toPrimitiveNode_ = super.insert((JSToPrimitiveNode.createHintNumber()));
                this.state_ = state = state | 0b1000000000 /* add-active doForeignObject(Object, JSToPrimitiveNode) */;
                lock.unlock();
                hasLock = false;
                return doForeignObject(arg0Value, this.foreignObject_toPrimitiveNode_);
            }
            if ((JSGuards.isJavaNumber(arg0Value))) {
                this.state_ = state = state | 0b10000000000 /* add-active doJavaNumber(Object) */;
                lock.unlock();
                hasLock = false;
                return JSToDoubleNode.doJavaNumber(arg0Value);
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
        s = new Object[3];
        s[0] = "doInteger";
        if ((state & 0b1) != 0 /* is-active doInteger(int) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doBoolean";
        if ((state & 0b10) != 0 /* is-active doBoolean(boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doDouble";
        if ((state & 0b100) != 0 /* is-active doDouble(double) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doBigInt";
        if ((state & 0b1000) != 0 /* is-active doBigInt(BigInt) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doNull";
        if ((state & 0b10000) != 0 /* is-active doNull(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "doUndefined";
        if ((state & 0b100000) != 0 /* is-active doUndefined(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "doStringDouble";
        if ((state & 0b1000000) != 0 /* is-active doStringDouble(String, JSStringToNumberNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.stringDouble_stringToNumberNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        s = new Object[3];
        s[0] = "doJSObject";
        if ((state & 0b10000000) != 0 /* is-active doJSObject(DynamicObject, JSToPrimitiveNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.jSObject_toPrimitiveNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[8] = s;
        s = new Object[3];
        s[0] = "doSymbol";
        if ((state & 0b100000000) != 0 /* is-active doSymbol(Symbol) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[9] = s;
        s = new Object[3];
        s[0] = "doForeignObject";
        if ((state & 0b1000000000) != 0 /* is-active doForeignObject(Object, JSToPrimitiveNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.foreignObject_toPrimitiveNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[10] = s;
        s = new Object[3];
        s[0] = "doJavaNumber";
        if ((state & 0b10000000000) != 0 /* is-active doJavaNumber(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[11] = s;
        return Provider.create(data);
    }

    public static JSToDoubleNode create() {
        return new JSToDoubleNodeGen();
    }

}
