// CheckStyle: start generated
package com.oracle.truffle.js.builtins;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.js.builtins.BigIntFunctionBuiltins.JSBigIntAsIntNNode;
import com.oracle.truffle.js.builtins.BigIntFunctionBuiltins.JSBigIntAsUintNNode;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.cast.JSToBigIntNode;
import com.oracle.truffle.js.nodes.cast.JSToIndexNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.BigInt;
import com.oracle.truffle.js.runtime.JSContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(BigIntFunctionBuiltins.class)
public final class BigIntFunctionBuiltinsFactory {

    @GeneratedBy(JSBigIntAsUintNNode.class)
    public static final class JSBigIntAsUintNNodeGen extends JSBigIntAsUintNNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_;
        @Child private JSToIndexNode toIndexNode_;
        @Child private JSToBigIntNode toBigIntNode_;

        private JSBigIntAsUintNNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if (state != 0 /* is-active doIt(Object, Object, JSToIndexNode, JSToBigIntNode) */) {
                return doIt(arguments0Value_, arguments1Value_, this.toIndexNode_, this.toBigIntNode_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private BigInt executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            try {
                this.toIndexNode_ = super.insert((JSToIndexNode.create()));
                this.toBigIntNode_ = super.insert((JSToBigIntNode.create()));
                this.state_ = state = state | 0b1 /* add-active doIt(Object, Object, JSToIndexNode, JSToBigIntNode) */;
                lock.unlock();
                hasLock = false;
                return doIt(arguments0Value, arguments1Value, this.toIndexNode_, this.toBigIntNode_);
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
            if (state != 0 /* is-active doIt(Object, Object, JSToIndexNode, JSToBigIntNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.toIndexNode_, this.toBigIntNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static JSBigIntAsUintNNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSBigIntAsUintNNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSBigIntAsIntNNode.class)
    public static final class JSBigIntAsIntNNodeGen extends JSBigIntAsIntNNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_;
        @Child private JSToIndexNode toIndexNode_;
        @Child private JSToBigIntNode toBigIntNode_;

        private JSBigIntAsIntNNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if (state != 0 /* is-active doIt(Object, Object, JSToIndexNode, JSToBigIntNode) */) {
                return doIt(arguments0Value_, arguments1Value_, this.toIndexNode_, this.toBigIntNode_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private BigInt executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            try {
                this.toIndexNode_ = super.insert((JSToIndexNode.create()));
                this.toBigIntNode_ = super.insert((JSToBigIntNode.create()));
                this.state_ = state = state | 0b1 /* add-active doIt(Object, Object, JSToIndexNode, JSToBigIntNode) */;
                lock.unlock();
                hasLock = false;
                return doIt(arguments0Value, arguments1Value, this.toIndexNode_, this.toBigIntNode_);
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
            if (state != 0 /* is-active doIt(Object, Object, JSToIndexNode, JSToBigIntNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.toIndexNode_, this.toBigIntNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static JSBigIntAsIntNNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSBigIntAsIntNNodeGen(context, builtin, arguments);
        }

    }
}
