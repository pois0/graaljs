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
import com.oracle.truffle.js.runtime.JSContext;

@GeneratedBy(CreateRegExpNode.class)
public final class CreateRegExpNodeGen extends CreateRegExpNode implements Provider {

    @CompilationFinal private int state_;

    private CreateRegExpNodeGen(JSContext context) {
        super(context);
    }

    @Override
    protected DynamicObject execute(Object arg0Value, boolean arg1Value) {
        int state = state_;
        if (state != 0 /* is-active createWithoutNamedCG(Object, boolean) || createWithNamedCG(Object, boolean) */) {
            if ((state & 0b1) != 0 /* is-active createWithoutNamedCG(Object, boolean) */) {
                if ((!(hasNamedCG(arg0Value)))) {
                    return createWithoutNamedCG(arg0Value, arg1Value);
                }
            }
            if ((state & 0b10) != 0 /* is-active createWithNamedCG(Object, boolean) */) {
                if ((hasNamedCG(arg0Value))) {
                    return createWithNamedCG(arg0Value, arg1Value);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value);
    }

    private DynamicObject executeAndSpecialize(Object arg0Value, boolean arg1Value) {
        int state = state_;
        if ((!(hasNamedCG(arg0Value)))) {
            this.state_ = state = state | 0b1 /* add-active createWithoutNamedCG(Object, boolean) */;
            return createWithoutNamedCG(arg0Value, arg1Value);
        }
        if ((hasNamedCG(arg0Value))) {
            this.state_ = state = state | 0b10 /* add-active createWithNamedCG(Object, boolean) */;
            return createWithNamedCG(arg0Value, arg1Value);
        }
        throw new UnsupportedSpecializationException(this, new Node[] {null, null}, arg0Value, arg1Value);
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
        s[0] = "createWithoutNamedCG";
        if ((state & 0b1) != 0 /* is-active createWithoutNamedCG(Object, boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "createWithNamedCG";
        if ((state & 0b10) != 0 /* is-active createWithNamedCG(Object, boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        return Provider.create(data);
    }

    public static CreateRegExpNode create(JSContext context) {
        return new CreateRegExpNodeGen(context);
    }

}
