// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.js.runtime.JSContext;

@GeneratedBy(JSProxyCallNode.class)
public final class JSProxyCallNodeGen extends JSProxyCallNode implements Provider {

    @CompilationFinal private int state_;

    private JSProxyCallNodeGen(JSContext context, boolean isNew, boolean isNewTarget) {
        super(context, isNew, isNewTarget);
    }

    @Override
    public Object execute(Object[] arg0Value) {
        int state = state_;
        if (state != 0 /* is-active doCall(Object[]) || doConstruct(Object[]) */) {
            if ((state & 0b1) != 0 /* is-active doCall(Object[]) */) {
                assert (!(isNew));
                assert (!(isNewTarget));
                return doCall(arg0Value);
            }
            if ((state & 0b10) != 0 /* is-active doConstruct(Object[]) */) {
                assert (isNew || isNewTarget);
                return doConstruct(arg0Value);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    private Object executeAndSpecialize(Object[] arg0Value) {
        int state = state_;
        if ((!(isNew)) && (!(isNewTarget))) {
            this.state_ = state = state | 0b1 /* add-active doCall(Object[]) */;
            return doCall(arg0Value);
        }
        if ((isNew || isNewTarget)) {
            this.state_ = state = state | 0b10 /* add-active doConstruct(Object[]) */;
            return doConstruct(arg0Value);
        }
        throw new UnsupportedSpecializationException(this, new Node[] {null}, arg0Value);
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[3];
        Object[] s;
        data[0] = 0;
        int state = state_;
        s = new Object[3];
        s[0] = "doCall";
        if ((state & 0b1) != 0 /* is-active doCall(Object[]) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doConstruct";
        if ((state & 0b10) != 0 /* is-active doConstruct(Object[]) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        return Provider.create(data);
    }

    public static JSProxyCallNode create(JSContext context, boolean isNew, boolean isNewTarget) {
        return new JSProxyCallNodeGen(context, isNew, isNewTarget);
    }

}
