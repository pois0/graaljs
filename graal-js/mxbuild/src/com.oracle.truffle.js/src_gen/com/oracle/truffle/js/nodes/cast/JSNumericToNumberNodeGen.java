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
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.runtime.BigInt;

@GeneratedBy(JSNumericToNumberNode.class)
public final class JSNumericToNumberNodeGen extends JSNumericToNumberNode implements Provider {

    @CompilationFinal private int state_;

    private JSNumericToNumberNodeGen() {
    }

    @Override
    public Number executeNumeric(Object arg0Value) {
        int state = state_;
        if ((state & 0b1) != 0 /* is-active doBigInt(BigInt) */ && arg0Value instanceof BigInt) {
            BigInt arg0Value_ = (BigInt) arg0Value;
            return JSNumericToNumberNode.doBigInt(arg0Value_);
        }
        if ((state & 0b10) != 0 /* is-active doOther(Number) */ && arg0Value instanceof Number) {
            Number arg0Value_ = (Number) arg0Value;
            if ((!(JSGuards.isBigInt(arg0Value_)))) {
                return JSNumericToNumberNode.doOther(arg0Value_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    private Number executeAndSpecialize(Object arg0Value) {
        int state = state_;
        if (arg0Value instanceof BigInt) {
            BigInt arg0Value_ = (BigInt) arg0Value;
            this.state_ = state = state | 0b1 /* add-active doBigInt(BigInt) */;
            return JSNumericToNumberNode.doBigInt(arg0Value_);
        }
        if (arg0Value instanceof Number) {
            Number arg0Value_ = (Number) arg0Value;
            if ((!(JSGuards.isBigInt(arg0Value_)))) {
                this.state_ = state = state | 0b10 /* add-active doOther(Number) */;
                return JSNumericToNumberNode.doOther(arg0Value_);
            }
        }
        throw new UnsupportedSpecializationException(this, new Node[] {null}, arg0Value);
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
        s[0] = "doBigInt";
        if ((state & 0b1) != 0 /* is-active doBigInt(BigInt) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doOther";
        if ((state & 0b10) != 0 /* is-active doOther(Number) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        return Provider.create(data);
    }

    public static JSNumericToNumberNode create() {
        return new JSNumericToNumberNodeGen();
    }

}
