// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.js.runtime.JSContext;

@GeneratedBy(ErrorStackTraceLimitNode.class)
public final class ErrorStackTraceLimitNodeGen extends ErrorStackTraceLimitNode implements Provider {

    private ErrorStackTraceLimitNodeGen(JSContext context) {
        super(context);
    }

    @Override
    public int executeInt() {
        return doInt();
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
        s[0] = "doInt";
        s[1] = (byte)0b01 /* active */;
        data[1] = s;
        return Provider.create(data);
    }

    public static ErrorStackTraceLimitNode create(JSContext context) {
        return new ErrorStackTraceLimitNodeGen(context);
    }

}
