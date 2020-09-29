// CheckStyle: start generated
package com.oracle.truffle.js.nodes.intl;

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
import com.oracle.truffle.js.runtime.JSContext;

@GeneratedBy(ToDateTimeOptionsNode.class)
public final class ToDateTimeOptionsNodeGen extends ToDateTimeOptionsNode implements Provider {

    @CompilationFinal private int state_;

    private ToDateTimeOptionsNodeGen(JSContext context) {
        super(context);
    }

    @Override
    public DynamicObject execute(Object arg0Value, String arg1Value, String arg2Value) {
        int state = state_;
        if ((state & 0b11) != 0 /* is-active fromUndefined(Object, String, String) || fromOtherThenUndefined(Object, String, String) */) {
            if ((state & 0b1) != 0 /* is-active fromUndefined(Object, String, String) */) {
                if ((JSGuards.isUndefined(arg0Value))) {
                    return fromUndefined(arg0Value, arg1Value, arg2Value);
                }
            }
            if ((state & 0b10) != 0 /* is-active fromOtherThenUndefined(Object, String, String) */) {
                if ((!(JSGuards.isUndefined(arg0Value)))) {
                    return fromOtherThenUndefined(arg0Value, arg1Value, arg2Value);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value, arg2Value);
    }

    private DynamicObject executeAndSpecialize(Object arg0Value, String arg1Value, String arg2Value) {
        int state = state_;
        if ((JSGuards.isUndefined(arg0Value))) {
            this.state_ = state = state | 0b1 /* add-active fromUndefined(Object, String, String) */;
            return fromUndefined(arg0Value, arg1Value, arg2Value);
        }
        if ((!(JSGuards.isUndefined(arg0Value)))) {
            this.state_ = state = state | 0b10 /* add-active fromOtherThenUndefined(Object, String, String) */;
            return fromOtherThenUndefined(arg0Value, arg1Value, arg2Value);
        }
        throw new UnsupportedSpecializationException(this, new Node[] {null, null, null}, arg0Value, arg1Value, arg2Value);
    }

    @Override
    public NodeCost getCost() {
        int state = state_;
        if ((state & 0b11) == 0b0) {
            return NodeCost.UNINITIALIZED;
        } else if (((state & 0b11) & ((state & 0b11) - 1)) == 0 /* is-single-active  */) {
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
        s[0] = "fromUndefined";
        if ((state & 0b1) != 0 /* is-active fromUndefined(Object, String, String) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "fromOtherThenUndefined";
        if ((state & 0b10) != 0 /* is-active fromOtherThenUndefined(Object, String, String) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        return Provider.create(data);
    }

    public static ToDateTimeOptionsNode create(JSContext context) {
        return new ToDateTimeOptionsNodeGen(context);
    }

}
