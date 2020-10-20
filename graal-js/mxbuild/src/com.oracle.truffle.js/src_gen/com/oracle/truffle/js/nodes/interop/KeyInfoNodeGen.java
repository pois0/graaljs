// CheckStyle: start generated
package com.oracle.truffle.js.nodes.interop;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;

@GeneratedBy(KeyInfoNode.class)
public final class KeyInfoNodeGen extends KeyInfoNode implements Provider {

    private static final Uncached UNCACHED = new Uncached();

    private KeyInfoNodeGen() {
    }

    @Override
    public boolean execute(DynamicObject arg0Value, String arg1Value, int arg2Value) {
        return KeyInfoNode.member(arg0Value, arg1Value, arg2Value);
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
        s[0] = "member";
        s[1] = (byte)0b01 /* active */;
        data[1] = s;
        return Provider.create(data);
    }

    public static KeyInfoNode create() {
        return new KeyInfoNodeGen();
    }

    public static KeyInfoNode getUncached() {
        return KeyInfoNodeGen.UNCACHED;
    }

    @GeneratedBy(KeyInfoNode.class)
    private static final class Uncached extends KeyInfoNode {

        @TruffleBoundary
        @Override
        public boolean execute(DynamicObject arg0Value, String arg1Value, int arg2Value) {
            return KeyInfoNode.member(arg0Value, arg1Value, arg2Value);
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.MEGAMORPHIC;
        }

        @Override
        public boolean isAdoptable() {
            return false;
        }

    }
}
