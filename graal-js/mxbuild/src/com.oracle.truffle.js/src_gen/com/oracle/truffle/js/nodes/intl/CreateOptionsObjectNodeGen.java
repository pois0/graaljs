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

@GeneratedBy(CreateOptionsObjectNode.class)
public final class CreateOptionsObjectNodeGen extends CreateOptionsObjectNode implements Provider {

    @CompilationFinal private int state_;

    private CreateOptionsObjectNodeGen(JSContext context) {
        super(context);
    }

    @Override
    public DynamicObject execute(Object arg0Value) {
        int state = state_;
        if (state != 0 /* is-active fromUndefined(Object) || fromOtherThenUndefined(Object) */) {
            if ((state & 0b1) != 0 /* is-active fromUndefined(Object) */) {
                if ((JSGuards.isUndefined(arg0Value))) {
                    return fromUndefined(arg0Value);
                }
            }
            if ((state & 0b10) != 0 /* is-active fromOtherThenUndefined(Object) */) {
                if ((!(JSGuards.isUndefined(arg0Value)))) {
                    return fromOtherThenUndefined(arg0Value);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    private DynamicObject executeAndSpecialize(Object arg0Value) {
        int state = state_;
        if ((JSGuards.isUndefined(arg0Value))) {
            this.state_ = state = state | 0b1 /* add-active fromUndefined(Object) */;
            return fromUndefined(arg0Value);
        }
        if ((!(JSGuards.isUndefined(arg0Value)))) {
            this.state_ = state = state | 0b10 /* add-active fromOtherThenUndefined(Object) */;
            return fromOtherThenUndefined(arg0Value);
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
        s[0] = "fromUndefined";
        if ((state & 0b1) != 0 /* is-active fromUndefined(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "fromOtherThenUndefined";
        if ((state & 0b10) != 0 /* is-active fromOtherThenUndefined(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        return Provider.create(data);
    }

    public static CreateOptionsObjectNode create(JSContext context) {
        return new CreateOptionsObjectNodeGen(context);
    }

}
