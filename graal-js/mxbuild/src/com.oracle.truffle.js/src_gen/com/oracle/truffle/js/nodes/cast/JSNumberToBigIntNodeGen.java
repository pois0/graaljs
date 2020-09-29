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
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.runtime.BigInt;

@GeneratedBy(JSNumberToBigIntNode.class)
public final class JSNumberToBigIntNodeGen extends JSNumberToBigIntNode implements Provider {

    @CompilationFinal private int state_;

    private JSNumberToBigIntNodeGen() {
    }

    @Override
    public Object execute(Object arg0Value) {
        int state = state_;
        if ((state & 0b1) != 0 /* is-active doInteger(int) */ && arg0Value instanceof Integer) {
            int arg0Value_ = (int) arg0Value;
            return doInteger(arg0Value_);
        }
        if ((state & 0b110) != 0 /* is-active doDoubleAsLong(double) || doDoubleOther(double) */ && JSTypesGen.isImplicitDouble((state & 0b11110000) >>> 4 /* extract-implicit-active 0:double */, arg0Value)) {
            double arg0Value_ = JSTypesGen.asImplicitDouble((state & 0b11110000) >>> 4 /* extract-implicit-active 0:double */, arg0Value);
            if ((state & 0b10) != 0 /* is-active doDoubleAsLong(double) */) {
                if ((JSGuards.isDoubleRepresentableAsLong(arg0Value_))) {
                    return doDoubleAsLong(arg0Value_);
                }
            }
            if ((state & 0b100) != 0 /* is-active doDoubleOther(double) */) {
                if ((!(JSGuards.isDoubleRepresentableAsLong(arg0Value_)))) {
                    return doDoubleOther(arg0Value_);
                }
            }
        }
        if ((state & 0b1000) != 0 /* is-active doNull(Object) */) {
            if ((JSGuards.isJSNull(arg0Value))) {
                return JSNumberToBigIntNode.doNull(arg0Value);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    private BigInt executeAndSpecialize(Object arg0Value) {
        int state = state_;
        if (arg0Value instanceof Integer) {
            int arg0Value_ = (int) arg0Value;
            this.state_ = state = state | 0b1 /* add-active doInteger(int) */;
            return doInteger(arg0Value_);
        }
        {
            int doubleCast0;
            if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(arg0Value)) != 0) {
                double arg0Value_ = JSTypesGen.asImplicitDouble(doubleCast0, arg0Value);
                if ((JSGuards.isDoubleRepresentableAsLong(arg0Value_))) {
                    state = (state | (doubleCast0 << 4) /* set-implicit-active 0:double */);
                    this.state_ = state = state | 0b10 /* add-active doDoubleAsLong(double) */;
                    return doDoubleAsLong(arg0Value_);
                }
                if ((!(JSGuards.isDoubleRepresentableAsLong(arg0Value_)))) {
                    state = (state | (doubleCast0 << 4) /* set-implicit-active 0:double */);
                    this.state_ = state = state | 0b100 /* add-active doDoubleOther(double) */;
                    return doDoubleOther(arg0Value_);
                }
            }
        }
        if ((JSGuards.isJSNull(arg0Value))) {
            this.state_ = state = state | 0b1000 /* add-active doNull(Object) */;
            return JSNumberToBigIntNode.doNull(arg0Value);
        }
        throw new UnsupportedSpecializationException(this, new Node[] {null}, arg0Value);
    }

    @Override
    public NodeCost getCost() {
        int state = state_;
        if ((state & 0b1111) == 0b0) {
            return NodeCost.UNINITIALIZED;
        } else if (((state & 0b1111) & ((state & 0b1111) - 1)) == 0 /* is-single-active  */) {
            return NodeCost.MONOMORPHIC;
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[5];
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
        s[0] = "doDoubleAsLong";
        if ((state & 0b10) != 0 /* is-active doDoubleAsLong(double) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doDoubleOther";
        if ((state & 0b100) != 0 /* is-active doDoubleOther(double) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doNull";
        if ((state & 0b1000) != 0 /* is-active doNull(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        return Provider.create(data);
    }

    public static JSNumberToBigIntNode create() {
        return new JSNumberToBigIntNodeGen();
    }

}
