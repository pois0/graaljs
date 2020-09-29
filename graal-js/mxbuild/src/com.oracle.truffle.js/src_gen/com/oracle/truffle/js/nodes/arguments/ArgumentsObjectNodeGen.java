// CheckStyle: start generated
package com.oracle.truffle.js.nodes.arguments;

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
import com.oracle.truffle.js.runtime.JSContext;

@GeneratedBy(ArgumentsObjectNode.class)
public final class ArgumentsObjectNodeGen extends ArgumentsObjectNode implements Provider {

    @CompilationFinal private int state_;

    private ArgumentsObjectNodeGen(JSContext context, boolean strict, int leadingArgCount, int trailingArgCount) {
        super(context, strict, leadingArgCount, trailingArgCount);
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        int state = state_;
        if ((state & 0b1) != 0 /* is-active doStrict(VirtualFrame) */) {
            if ((isStrict(frameValue))) {
                return doStrict(frameValue);
            }
        }
        if ((state & 0b10) != 0 /* is-active doNonStrict(VirtualFrame) */) {
            if ((!(isStrict(frameValue)))) {
                return doNonStrict(frameValue);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(frameValue);
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        execute(frameValue);
        return;
    }

    private DynamicObject executeAndSpecialize(VirtualFrame frameValue) {
        int state = state_;
        if ((isStrict(frameValue))) {
            this.state_ = state = state | 0b1 /* add-active doStrict(VirtualFrame) */;
            return doStrict(frameValue);
        }
        if ((!(isStrict(frameValue)))) {
            this.state_ = state = state | 0b10 /* add-active doNonStrict(VirtualFrame) */;
            return doNonStrict(frameValue);
        }
        throw new UnsupportedSpecializationException(this, new Node[] {});
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
        s[0] = "doStrict";
        if ((state & 0b1) != 0 /* is-active doStrict(VirtualFrame) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doNonStrict";
        if ((state & 0b10) != 0 /* is-active doNonStrict(VirtualFrame) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        return Provider.create(data);
    }

    public static ArgumentsObjectNode create(JSContext context, boolean strict, int leadingArgCount, int trailingArgCount) {
        return new ArgumentsObjectNodeGen(context, strict, leadingArgCount, trailingArgCount);
    }

}
