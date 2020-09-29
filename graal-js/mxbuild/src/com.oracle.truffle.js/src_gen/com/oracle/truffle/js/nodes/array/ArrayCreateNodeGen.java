// CheckStyle: start generated
package com.oracle.truffle.js.nodes.array;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.JSRuntime;

@GeneratedBy(ArrayCreateNode.class)
public final class ArrayCreateNodeGen extends ArrayCreateNode implements Provider {

    @CompilationFinal private int state_;

    private ArrayCreateNodeGen(JSContext context) {
        super(context);
    }

    @Override
    public DynamicObject execute(long arg0Value) {
        int state = state_;
        if (state != 0 /* is-active doDefault(long) || doLargeLength(long) || doInvalidLength(long) */) {
            if ((state & 0b1) != 0 /* is-active doDefault(long) */) {
                if ((JSRuntime.isValidArrayLength(arg0Value)) && (arg0Value <= Integer.MAX_VALUE)) {
                    return doDefault(arg0Value);
                }
            }
            if ((state & 0b10) != 0 /* is-active doLargeLength(long) */) {
                if ((JSRuntime.isValidArrayLength(arg0Value)) && (arg0Value > Integer.MAX_VALUE)) {
                    return doLargeLength(arg0Value);
                }
            }
            if ((state & 0b100) != 0 /* is-active doInvalidLength(long) */) {
                if ((!(JSRuntime.isValidArrayLength(arg0Value)))) {
                    return doInvalidLength(arg0Value);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    private DynamicObject executeAndSpecialize(long arg0Value) {
        int state = state_;
        if ((JSRuntime.isValidArrayLength(arg0Value)) && (arg0Value <= Integer.MAX_VALUE)) {
            this.state_ = state = state | 0b1 /* add-active doDefault(long) */;
            return doDefault(arg0Value);
        }
        if ((JSRuntime.isValidArrayLength(arg0Value)) && (arg0Value > Integer.MAX_VALUE)) {
            this.state_ = state = state | 0b10 /* add-active doLargeLength(long) */;
            return doLargeLength(arg0Value);
        }
        if ((!(JSRuntime.isValidArrayLength(arg0Value)))) {
            this.state_ = state = state | 0b100 /* add-active doInvalidLength(long) */;
            return doInvalidLength(arg0Value);
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
        Object[] data = new Object[4];
        Object[] s;
        data[0] = 0;
        int state = state_;
        s = new Object[3];
        s[0] = "doDefault";
        if ((state & 0b1) != 0 /* is-active doDefault(long) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doLargeLength";
        if ((state & 0b10) != 0 /* is-active doLargeLength(long) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doInvalidLength";
        if ((state & 0b100) != 0 /* is-active doInvalidLength(long) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        return Provider.create(data);
    }

    public static ArrayCreateNode create(JSContext context) {
        return new ArrayCreateNodeGen(context);
    }

}
