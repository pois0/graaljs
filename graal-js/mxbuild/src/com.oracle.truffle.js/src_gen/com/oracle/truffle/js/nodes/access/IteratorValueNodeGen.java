// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

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
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.runtime.JSContext;

@GeneratedBy(IteratorValueNode.class)
public final class IteratorValueNodeGen extends IteratorValueNode implements Provider {

    @CompilationFinal private int state_;

    private IteratorValueNodeGen(JSContext context, JavaScriptNode iterResultNode) {
        super(context, iterResultNode);
    }

    @Override
    public Object execute(DynamicObject iterResultNodeValue) {
        int state = state_;
        if (state != 0 /* is-active doIteratorNext(DynamicObject) */) {
            return doIteratorNext(iterResultNodeValue);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(iterResultNodeValue);
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        int state = state_;
        Object iterResultNodeValue_ = super.iterResultNode.execute(frameValue);
        if (state != 0 /* is-active doIteratorNext(DynamicObject) */ && JSTypes.isDynamicObject(iterResultNodeValue_)) {
            DynamicObject iterResultNodeValue__ = (DynamicObject) iterResultNodeValue_;
            return doIteratorNext(iterResultNodeValue__);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(iterResultNodeValue_);
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        execute(frameValue);
        return;
    }

    private Object executeAndSpecialize(Object iterResultNodeValue) {
        int state = state_;
        if (JSTypes.isDynamicObject(iterResultNodeValue)) {
            DynamicObject iterResultNodeValue_ = (DynamicObject) iterResultNodeValue;
            this.state_ = state = state | 0b1 /* add-active doIteratorNext(DynamicObject) */;
            return doIteratorNext(iterResultNodeValue_);
        }
        throw new UnsupportedSpecializationException(this, new Node[] {super.iterResultNode}, iterResultNodeValue);
    }

    @Override
    public NodeCost getCost() {
        int state = state_;
        if (state == 0b0) {
            return NodeCost.UNINITIALIZED;
        } else {
            return NodeCost.MONOMORPHIC;
        }
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[2];
        Object[] s;
        data[0] = 0;
        int state = state_;
        s = new Object[3];
        s[0] = "doIteratorNext";
        if (state != 0 /* is-active doIteratorNext(DynamicObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        return Provider.create(data);
    }

    public static IteratorValueNode create(JSContext context, JavaScriptNode iterResultNode) {
        return new IteratorValueNodeGen(context, iterResultNode);
    }

}
