// CheckStyle: start generated
package com.oracle.truffle.js.nodes.cast;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.runtime.Symbol;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSToPropertyKeyNode.class)
public final class JSToPropertyKeyNodeGen extends JSToPropertyKeyNode implements Provider {

    @CompilationFinal private volatile int state_;
    @Child private OtherData other_cache;

    private JSToPropertyKeyNodeGen() {
    }

    @Override
    public Object execute(Object arg0Value) {
        int state = state_;
        if ((state & 0b1) != 0 /* is-active doString(String) */ && JSTypesGen.isImplicitString((state & 0b1111000) >>> 3 /* extract-implicit-active 0:String */, arg0Value)) {
            String arg0Value_ = JSTypesGen.asImplicitString((state & 0b1111000) >>> 3 /* extract-implicit-active 0:String */, arg0Value);
            return doString(arg0Value_);
        }
        if ((state & 0b10) != 0 /* is-active doSymbol(Symbol) */ && arg0Value instanceof Symbol) {
            Symbol arg0Value_ = (Symbol) arg0Value;
            return doSymbol(arg0Value_);
        }
        if ((state & 0b100) != 0 /* is-active doOther(Object, JSToPrimitiveNode, JSToStringNode, ConditionProfile) */) {
            OtherData s3_ = this.other_cache;
            if (s3_ != null) {
                if ((!(JSGuards.isSymbol(arg0Value)))) {
                    return doOther(arg0Value, s3_.toPrimitiveNode_, s3_.toStringNode_, s3_.isSymbol_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    private Object executeAndSpecialize(Object arg0Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        try {
            {
                int stringCast0;
                if ((stringCast0 = JSTypesGen.specializeImplicitString(arg0Value)) != 0) {
                    String arg0Value_ = JSTypesGen.asImplicitString(stringCast0, arg0Value);
                    state = (state | (stringCast0 << 3) /* set-implicit-active 0:String */);
                    this.state_ = state = state | 0b1 /* add-active doString(String) */;
                    lock.unlock();
                    hasLock = false;
                    return doString(arg0Value_);
                }
            }
            if (arg0Value instanceof Symbol) {
                Symbol arg0Value_ = (Symbol) arg0Value;
                this.state_ = state = state | 0b10 /* add-active doSymbol(Symbol) */;
                lock.unlock();
                hasLock = false;
                return doSymbol(arg0Value_);
            }
            if ((!(JSGuards.isSymbol(arg0Value)))) {
                OtherData s3_ = super.insert(new OtherData());
                s3_.toPrimitiveNode_ = s3_.insertAccessor((JSToPrimitiveNode.createHintString()));
                s3_.toStringNode_ = s3_.insertAccessor((JSToStringNode.create()));
                s3_.isSymbol_ = (ConditionProfile.createBinaryProfile());
                this.other_cache = s3_;
                this.state_ = state = state | 0b100 /* add-active doOther(Object, JSToPrimitiveNode, JSToStringNode, ConditionProfile) */;
                lock.unlock();
                hasLock = false;
                return doOther(arg0Value, s3_.toPrimitiveNode_, s3_.toStringNode_, s3_.isSymbol_);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {null}, arg0Value);
        } finally {
            if (hasLock) {
                lock.unlock();
            }
        }
    }

    @Override
    public NodeCost getCost() {
        int state = state_;
        if ((state & 0b111) == 0b0) {
            return NodeCost.UNINITIALIZED;
        } else if (((state & 0b111) & ((state & 0b111) - 1)) == 0 /* is-single-active  */) {
            return NodeCost.MONOMORPHIC;
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[4];
        Object[] s;
        data[0] = 0;
        int state = state_;
        s = new Object[3];
        s[0] = "doString";
        if ((state & 0b1) != 0 /* is-active doString(String) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doSymbol";
        if ((state & 0b10) != 0 /* is-active doSymbol(Symbol) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doOther";
        if ((state & 0b100) != 0 /* is-active doOther(Object, JSToPrimitiveNode, JSToStringNode, ConditionProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            OtherData s3_ = this.other_cache;
            if (s3_ != null) {
                cached.add(Arrays.asList(s3_.toPrimitiveNode_, s3_.toStringNode_, s3_.isSymbol_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        return Provider.create(data);
    }

    public static JSToPropertyKeyNode create() {
        return new JSToPropertyKeyNodeGen();
    }

    @GeneratedBy(JSToPropertyKeyNode.class)
    private static final class OtherData extends Node {

        @Child JSToPrimitiveNode toPrimitiveNode_;
        @Child JSToStringNode toStringNode_;
        @CompilationFinal ConditionProfile isSymbol_;

        OtherData() {
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.NONE;
        }

        <T extends Node> T insertAccessor(T node) {
            return super.insert(node);
        }

    }
    @GeneratedBy(JSToPropertyKeyWrapperNode.class)
    public static final class JSToPropertyKeyWrapperNodeGen extends JSToPropertyKeyWrapperNode implements Provider {

        private JSToPropertyKeyWrapperNodeGen(JavaScriptNode operand) {
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

        public static JSToPropertyKeyWrapperNode create(JavaScriptNode operand) {
            return new JSToPropertyKeyWrapperNodeGen(operand);
        }

    }
}
