// CheckStyle: start generated
package com.oracle.truffle.js.nodes.interop;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.nodes.JSTypesGen;

@GeneratedBy(KeyInfoNode.class)
public final class KeyInfoNodeGen extends KeyInfoNode implements Provider {

    private static final Uncached UNCACHED = new Uncached();

    @CompilationFinal private int state_;

    private KeyInfoNodeGen() {
    }

    @Override
    public boolean execute(DynamicObject arg0Value, String arg1Value, int arg2Value) {
        int state = state_;
        if ((state & 0b1) != 0 /* is-active member(DynamicObject, String, int) */) {
            return KeyInfoNode.member(arg0Value, arg1Value, arg2Value);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value, arg2Value);
    }

    @Override
    public boolean execute(DynamicObject arg0Value, long arg1Value, int arg2Value) {
        int state = state_;
        if ((state & 0b10) != 0 /* is-active element(DynamicObject, long, int) */) {
            return KeyInfoNode.element(arg0Value, arg1Value, arg2Value);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value, arg2Value);
    }

    private boolean executeAndSpecialize(DynamicObject arg0Value, Object arg1Value, int arg2Value) {
        int state = state_;
        {
            int stringCast1;
            if ((stringCast1 = JSTypesGen.specializeImplicitString(arg1Value)) != 0) {
                String arg1Value_ = JSTypesGen.asImplicitString(stringCast1, arg1Value);
                state = (state | (stringCast1 << 2) /* set-implicit-active 1:String */);
                this.state_ = state = state | 0b1 /* add-active member(DynamicObject, String, int) */;
                return KeyInfoNode.member(arg0Value, arg1Value_, arg2Value);
            }
        }
        if (arg1Value instanceof Long) {
            long arg1Value_ = (long) arg1Value;
            this.state_ = state = state | 0b10 /* add-active element(DynamicObject, long, int) */;
            return KeyInfoNode.element(arg0Value, arg1Value_, arg2Value);
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
        s[0] = "member";
        if ((state & 0b1) != 0 /* is-active member(DynamicObject, String, int) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "element";
        if ((state & 0b10) != 0 /* is-active element(DynamicObject, long, int) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
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

        @TruffleBoundary
        @Override
        public boolean execute(DynamicObject arg0Value, long arg1Value, int arg2Value) {
            return KeyInfoNode.element(arg0Value, arg1Value, arg2Value);
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
