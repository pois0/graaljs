// CheckStyle: start generated
package com.oracle.truffle.js.nodes.unary;

import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.js.nodes.JavaScriptNode;

@GeneratedBy(JSUnaryPlusNode.class)
public final class JSUnaryPlusNodeGen extends JSUnaryPlusNode implements Provider {

    private JSUnaryPlusNodeGen(JavaScriptNode operand) {
        super(operand);
    }

    @Override
    public Object execute(VirtualFrame frameValue, Object operandNodeValue) {
        return doDefault(operandNodeValue);
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        Object operandNodeValue_ = super.operandNode.execute(frameValue);
        return doDefault(operandNodeValue_);
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
        s[0] = "doDefault";
        s[1] = (byte)0b01 /* active */;
        data[1] = s;
        return Provider.create(data);
    }

    public static JSUnaryPlusNode create(JavaScriptNode operand) {
        return new JSUnaryPlusNodeGen(operand);
    }

}
