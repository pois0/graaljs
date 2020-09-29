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
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.runtime.BigInt;

@GeneratedBy(JSToNumericNode.class)
public final class JSToNumericNodeGen extends JSToNumericNode implements Provider {

    @CompilationFinal private int state_;

    private JSToNumericNodeGen() {
    }

    @Override
    public Object execute(Object arg0Value) {
        int state = state_;
        if ((state & 0b1) != 0 /* is-active doInt(int) */ && arg0Value instanceof Integer) {
            int arg0Value_ = (int) arg0Value;
            return JSToNumericNode.doInt(arg0Value_);
        }
        if ((state & 0b10) != 0 /* is-active doDouble(double) */ && JSTypesGen.isImplicitDouble((state & 0b111100000) >>> 5 /* extract-implicit-active 0:double */, arg0Value)) {
            double arg0Value_ = JSTypesGen.asImplicitDouble((state & 0b111100000) >>> 5 /* extract-implicit-active 0:double */, arg0Value);
            return JSToNumericNode.doDouble(arg0Value_);
        }
        if ((state & 0b100) != 0 /* is-active doBigInt(BigInt) */ && arg0Value instanceof BigInt) {
            BigInt arg0Value_ = (BigInt) arg0Value;
            return doBigInt(arg0Value_);
        }
        if ((state & 0b11000) != 0 /* is-active doJSBigInt(Object) || doOther(Object) */) {
            if ((state & 0b1000) != 0 /* is-active doJSBigInt(Object) */) {
                if ((JSGuards.isJSBigInt(arg0Value))) {
                    return doJSBigInt(arg0Value);
                }
            }
            if ((state & 0b10000) != 0 /* is-active doOther(Object) */) {
                if ((!(JSGuards.isJSBigInt(arg0Value)))) {
                    return doOther(arg0Value);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    private Object executeAndSpecialize(Object arg0Value) {
        int state = state_;
        if (arg0Value instanceof Integer) {
            int arg0Value_ = (int) arg0Value;
            this.state_ = state = state | 0b1 /* add-active doInt(int) */;
            return JSToNumericNode.doInt(arg0Value_);
        }
        {
            int doubleCast0;
            if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(arg0Value)) != 0) {
                double arg0Value_ = JSTypesGen.asImplicitDouble(doubleCast0, arg0Value);
                state = (state | (doubleCast0 << 5) /* set-implicit-active 0:double */);
                this.state_ = state = state | 0b10 /* add-active doDouble(double) */;
                return JSToNumericNode.doDouble(arg0Value_);
            }
        }
        if (arg0Value instanceof BigInt) {
            BigInt arg0Value_ = (BigInt) arg0Value;
            this.state_ = state = state | 0b100 /* add-active doBigInt(BigInt) */;
            return doBigInt(arg0Value_);
        }
        if ((JSGuards.isJSBigInt(arg0Value))) {
            this.state_ = state = state | 0b1000 /* add-active doJSBigInt(Object) */;
            return doJSBigInt(arg0Value);
        }
        if ((!(JSGuards.isJSBigInt(arg0Value)))) {
            this.state_ = state = state | 0b10000 /* add-active doOther(Object) */;
            return doOther(arg0Value);
        }
        throw new UnsupportedSpecializationException(this, new Node[] {null}, arg0Value);
    }

    @Override
    public NodeCost getCost() {
        int state = state_;
        if ((state & 0b11111) == 0b0) {
            return NodeCost.UNINITIALIZED;
        } else if (((state & 0b11111) & ((state & 0b11111) - 1)) == 0 /* is-single-active  */) {
            return NodeCost.MONOMORPHIC;
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[6];
        Object[] s;
        data[0] = 0;
        int state = state_;
        s = new Object[3];
        s[0] = "doInt";
        if ((state & 0b1) != 0 /* is-active doInt(int) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doDouble";
        if ((state & 0b10) != 0 /* is-active doDouble(double) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doBigInt";
        if ((state & 0b100) != 0 /* is-active doBigInt(BigInt) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doJSBigInt";
        if ((state & 0b1000) != 0 /* is-active doJSBigInt(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doOther";
        if ((state & 0b10000) != 0 /* is-active doOther(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        return Provider.create(data);
    }

    public static JSToNumericNode create() {
        return new JSToNumericNodeGen();
    }

    @GeneratedBy(JSToNumericWrapperNode.class)
    public static final class JSToNumericWrapperNodeGen extends JSToNumericWrapperNode implements Provider {

        private JSToNumericWrapperNodeGen(JavaScriptNode operand) {
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

        public static JSToNumericWrapperNode create(JavaScriptNode operand) {
            return new JSToNumericWrapperNodeGen(operand);
        }

    }
}
