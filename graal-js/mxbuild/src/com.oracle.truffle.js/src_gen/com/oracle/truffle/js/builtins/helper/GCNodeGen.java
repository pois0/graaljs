// CheckStyle: start generated
package com.oracle.truffle.js.builtins.helper;

import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSContext;

@GeneratedBy(GCNode.class)
@SuppressWarnings("unused")
public final class GCNodeGen extends GCNode implements Provider {

    private GCNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
        super(context, builtin);
    }

    @Override
    public JavaScriptNode[] getArguments() {
        return new JavaScriptNode[] {};
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        return gc();
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
        s[0] = "gc";
        s[1] = (byte)0b01 /* active */;
        data[1] = s;
        return Provider.create(data);
    }

    public static GCNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
        return new GCNodeGen(context, builtin, arguments);
    }

}
