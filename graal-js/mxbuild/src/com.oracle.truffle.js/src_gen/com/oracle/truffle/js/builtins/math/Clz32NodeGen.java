// CheckStyle: start generated
package com.oracle.truffle.js.builtins.math;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.cast.JSToUInt32Node;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(Clz32Node.class)
public final class Clz32NodeGen extends Clz32Node implements Provider {

    @Child private JavaScriptNode arguments0_;
    @CompilationFinal private volatile int state_;
    @Child private JSToUInt32Node clz321_toUInt32Node_;

    private Clz32NodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
        super(context, builtin);
        this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
    }

    @Override
    public JavaScriptNode[] getArguments() {
        return new JavaScriptNode[] {this.arguments0_};
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        int state = state_;
        if ((state & 0b10) == 0 /* only-active clz32(int) */ && state != 0  /* is-not clz32(int) && clz32(Object, JSToUInt32Node) */) {
            return execute_int0(frameValue, state);
        } else {
            return execute_generic1(frameValue, state);
        }
    }

    private Object execute_int0(VirtualFrame frameValue, int state) {
        int arguments0Value_;
        try {
            arguments0Value_ = this.arguments0_.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(ex.getResult());
        }
        assert (state & 0b1) != 0 /* is-active clz32(int) */;
        return Clz32Node.clz32(arguments0Value_);
    }

    private Object execute_generic1(VirtualFrame frameValue, int state) {
        Object arguments0Value_ = this.arguments0_.execute(frameValue);
        if ((state & 0b1) != 0 /* is-active clz32(int) */ && arguments0Value_ instanceof Integer) {
            int arguments0Value__ = (int) arguments0Value_;
            return Clz32Node.clz32(arguments0Value__);
        }
        if ((state & 0b10) != 0 /* is-active clz32(Object, JSToUInt32Node) */) {
            return clz32(arguments0Value_, this.clz321_toUInt32Node_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arguments0Value_);
    }

    @Override
    public int executeInt(VirtualFrame frameValue) {
        int state = state_;
        if ((state & 0b10) == 0 /* only-active clz32(int) */ && state != 0  /* is-not clz32(int) && clz32(Object, JSToUInt32Node) */) {
            return executeInt_int2(frameValue, state);
        } else {
            return executeInt_generic3(frameValue, state);
        }
    }

    private int executeInt_int2(VirtualFrame frameValue, int state) {
        int arguments0Value_;
        try {
            arguments0Value_ = this.arguments0_.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(ex.getResult());
        }
        assert (state & 0b1) != 0 /* is-active clz32(int) */;
        return Clz32Node.clz32(arguments0Value_);
    }

    private int executeInt_generic3(VirtualFrame frameValue, int state) {
        Object arguments0Value_ = this.arguments0_.execute(frameValue);
        if ((state & 0b1) != 0 /* is-active clz32(int) */ && arguments0Value_ instanceof Integer) {
            int arguments0Value__ = (int) arguments0Value_;
            return Clz32Node.clz32(arguments0Value__);
        }
        if ((state & 0b10) != 0 /* is-active clz32(Object, JSToUInt32Node) */) {
            return clz32(arguments0Value_, this.clz321_toUInt32Node_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arguments0Value_);
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        executeInt(frameValue);
        return;
    }

    private int executeAndSpecialize(Object arguments0Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        try {
            if (arguments0Value instanceof Integer) {
                int arguments0Value_ = (int) arguments0Value;
                this.state_ = state = state | 0b1 /* add-active clz32(int) */;
                lock.unlock();
                hasLock = false;
                return Clz32Node.clz32(arguments0Value_);
            }
            this.clz321_toUInt32Node_ = super.insert((JSToUInt32Node.create()));
            this.state_ = state = state | 0b10 /* add-active clz32(Object, JSToUInt32Node) */;
            lock.unlock();
            hasLock = false;
            return clz32(arguments0Value, this.clz321_toUInt32Node_);
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
        s[0] = "clz32";
        if ((state & 0b1) != 0 /* is-active clz32(int) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "clz32";
        if ((state & 0b10) != 0 /* is-active clz32(Object, JSToUInt32Node) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.clz321_toUInt32Node_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        return Provider.create(data);
    }

    public static Clz32Node create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
        return new Clz32NodeGen(context, builtin, arguments);
    }

}
