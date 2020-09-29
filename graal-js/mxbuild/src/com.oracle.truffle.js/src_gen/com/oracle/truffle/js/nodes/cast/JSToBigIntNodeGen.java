// CheckStyle: start generated
package com.oracle.truffle.js.nodes.cast;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.runtime.BigInt;
import com.oracle.truffle.js.runtime.Symbol;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSToBigIntNode.class)
public final class JSToBigIntNodeGen extends JSToBigIntNode implements Provider {

    @CompilationFinal private volatile int state_;
    @Child private JSToPrimitiveNode toPrimitiveNode_;
    @Child private JSToBigIntInnerConversionNode innerConversionNode_;

    private JSToBigIntNodeGen() {
    }

    @Override
    public Object execute(Object arg0Value) {
        int state = state_;
        if (state != 0 /* is-active doIt(Object, JSToPrimitiveNode, JSToBigIntInnerConversionNode) */) {
            return doIt(arg0Value, this.toPrimitiveNode_, this.innerConversionNode_);
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
            this.toPrimitiveNode_ = super.insert((JSToPrimitiveNode.createHintNumber()));
            this.innerConversionNode_ = super.insert((JSToBigIntInnerConversionNode.create()));
            this.state_ = state = state | 0b1 /* add-active doIt(Object, JSToPrimitiveNode, JSToBigIntInnerConversionNode) */;
            lock.unlock();
            hasLock = false;
            return doIt(arg0Value, this.toPrimitiveNode_, this.innerConversionNode_);
        } finally {
            if (hasLock) {
                lock.unlock();
            }
        }
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
        s[0] = "doIt";
        if (state != 0 /* is-active doIt(Object, JSToPrimitiveNode, JSToBigIntInnerConversionNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.toPrimitiveNode_, this.innerConversionNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        return Provider.create(data);
    }

    public static JSToBigIntNode create() {
        return new JSToBigIntNodeGen();
    }

    @GeneratedBy(JSToBigIntInnerConversionNode.class)
    public static final class JSToBigIntInnerConversionNodeGen extends JSToBigIntInnerConversionNode implements Provider {

        @CompilationFinal private int state_;

        private JSToBigIntInnerConversionNodeGen() {
        }

        @Override
        public Object execute(Object arg0Value) {
            int state = state_;
            if ((state & 0b1) != 0 /* is-active doBoolean(boolean) */ && arg0Value instanceof Boolean) {
                boolean arg0Value_ = (boolean) arg0Value;
                return JSToBigIntInnerConversionNode.doBoolean(arg0Value_);
            }
            if ((state & 0b10) != 0 /* is-active doBigInt(BigInt) */ && arg0Value instanceof BigInt) {
                BigInt arg0Value_ = (BigInt) arg0Value;
                return JSToBigIntInnerConversionNode.doBigInt(arg0Value_);
            }
            if ((state & 0b100) != 0 /* is-active doDouble(Object) */) {
                if ((JSGuards.isNumber(arg0Value))) {
                    return JSToBigIntInnerConversionNode.doDouble(arg0Value);
                }
            }
            if ((state & 0b1000) != 0 /* is-active doSymbol(Symbol) */ && arg0Value instanceof Symbol) {
                Symbol arg0Value_ = (Symbol) arg0Value;
                return JSToBigIntInnerConversionNode.doSymbol(arg0Value_);
            }
            if ((state & 0b10000) != 0 /* is-active doNullOrUndefined(Object) */) {
                if ((JSGuards.isNullOrUndefined(arg0Value))) {
                    return JSToBigIntInnerConversionNode.doNullOrUndefined(arg0Value);
                }
            }
            if ((state & 0b100000) != 0 /* is-active doString(String) */ && JSTypesGen.isImplicitString((state & 0b1111000000) >>> 6 /* extract-implicit-active 0:String */, arg0Value)) {
                String arg0Value_ = JSTypesGen.asImplicitString((state & 0b1111000000) >>> 6 /* extract-implicit-active 0:String */, arg0Value);
                return JSToBigIntInnerConversionNode.doString(arg0Value_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value);
        }

        private BigInt executeAndSpecialize(Object arg0Value) {
            int state = state_;
            if (arg0Value instanceof Boolean) {
                boolean arg0Value_ = (boolean) arg0Value;
                this.state_ = state = state | 0b1 /* add-active doBoolean(boolean) */;
                return JSToBigIntInnerConversionNode.doBoolean(arg0Value_);
            }
            if (arg0Value instanceof BigInt) {
                BigInt arg0Value_ = (BigInt) arg0Value;
                this.state_ = state = state | 0b10 /* add-active doBigInt(BigInt) */;
                return JSToBigIntInnerConversionNode.doBigInt(arg0Value_);
            }
            if ((JSGuards.isNumber(arg0Value))) {
                this.state_ = state = state | 0b100 /* add-active doDouble(Object) */;
                return JSToBigIntInnerConversionNode.doDouble(arg0Value);
            }
            if (arg0Value instanceof Symbol) {
                Symbol arg0Value_ = (Symbol) arg0Value;
                this.state_ = state = state | 0b1000 /* add-active doSymbol(Symbol) */;
                return JSToBigIntInnerConversionNode.doSymbol(arg0Value_);
            }
            if ((JSGuards.isNullOrUndefined(arg0Value))) {
                this.state_ = state = state | 0b10000 /* add-active doNullOrUndefined(Object) */;
                return JSToBigIntInnerConversionNode.doNullOrUndefined(arg0Value);
            }
            {
                int stringCast0;
                if ((stringCast0 = JSTypesGen.specializeImplicitString(arg0Value)) != 0) {
                    String arg0Value_ = JSTypesGen.asImplicitString(stringCast0, arg0Value);
                    state = (state | (stringCast0 << 6) /* set-implicit-active 0:String */);
                    this.state_ = state = state | 0b100000 /* add-active doString(String) */;
                    return JSToBigIntInnerConversionNode.doString(arg0Value_);
                }
            }
            throw new UnsupportedSpecializationException(this, new Node[] {null}, arg0Value);
        }

        @Override
        public NodeCost getCost() {
            int state = state_;
            if ((state & 0b111111) == 0b0) {
                return NodeCost.UNINITIALIZED;
            } else if (((state & 0b111111) & ((state & 0b111111) - 1)) == 0 /* is-single-active  */) {
                return NodeCost.MONOMORPHIC;
            }
            return NodeCost.POLYMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[7];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "doBoolean";
            if ((state & 0b1) != 0 /* is-active doBoolean(boolean) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doBigInt";
            if ((state & 0b10) != 0 /* is-active doBigInt(BigInt) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "doDouble";
            if ((state & 0b100) != 0 /* is-active doDouble(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "doSymbol";
            if ((state & 0b1000) != 0 /* is-active doSymbol(Symbol) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            s = new Object[3];
            s[0] = "doNullOrUndefined";
            if ((state & 0b10000) != 0 /* is-active doNullOrUndefined(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[5] = s;
            s = new Object[3];
            s[0] = "doString";
            if ((state & 0b100000) != 0 /* is-active doString(String) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[6] = s;
            return Provider.create(data);
        }

        public static JSToBigIntInnerConversionNode create() {
            return new JSToBigIntInnerConversionNodeGen();
        }

    }
}
