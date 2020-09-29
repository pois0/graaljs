// CheckStyle: start generated
package com.oracle.truffle.js.builtins;

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
import com.oracle.truffle.js.builtins.TestV8Builtins.TestV8ConstructDoubleNode;
import com.oracle.truffle.js.builtins.TestV8Builtins.TestV8CreateAsyncFromSyncIterator;
import com.oracle.truffle.js.builtins.TestV8Builtins.TestV8DoublePartNode;
import com.oracle.truffle.js.builtins.TestV8Builtins.TestV8EnqueueJobNode;
import com.oracle.truffle.js.builtins.TestV8Builtins.TestV8ReferenceEqualNode;
import com.oracle.truffle.js.builtins.TestV8Builtins.TestV8RunMicrotasksNode;
import com.oracle.truffle.js.builtins.TestV8Builtins.TestV8SetTimeoutNode;
import com.oracle.truffle.js.builtins.TestV8Builtins.TestV8ToLengthNode;
import com.oracle.truffle.js.builtins.TestV8Builtins.TestV8ToNameNode;
import com.oracle.truffle.js.builtins.TestV8Builtins.TestV8ToNumberNode;
import com.oracle.truffle.js.builtins.TestV8Builtins.TestV8ToPrimitiveNode;
import com.oracle.truffle.js.builtins.TestV8Builtins.TestV8ToStringNode;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.cast.JSToPrimitiveNode.Hint;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSContext;

@GeneratedBy(TestV8Builtins.class)
@SuppressWarnings("unused")
public final class TestV8BuiltinsFactory {

    @GeneratedBy(TestV8ConstructDoubleNode.class)
    public static final class TestV8ConstructDoubleNodeGen extends TestV8ConstructDoubleNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;

        private TestV8ConstructDoubleNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            return constructDouble(arguments0Value_, arguments1Value_);
        }

        @Override
        public double executeDouble(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            return constructDouble(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            executeDouble(frameValue);
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
            s[0] = "constructDouble";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static TestV8ConstructDoubleNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new TestV8ConstructDoubleNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(TestV8DoublePartNode.class)
    public static final class TestV8DoublePartNodeGen extends TestV8DoublePartNode implements Provider {

        @Child private JavaScriptNode arguments0_;

        private TestV8DoublePartNodeGen(JSContext context, JSBuiltin builtin, boolean upper, JavaScriptNode[] arguments) {
            super(context, builtin, upper);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return doublePart(arguments0Value_);
        }

        @Override
        public int executeInt(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return doublePart(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            executeInt(frameValue);
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
            s[0] = "doublePart";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static TestV8DoublePartNode create(JSContext context, JSBuiltin builtin, boolean upper, JavaScriptNode[] arguments) {
            return new TestV8DoublePartNodeGen(context, builtin, upper, arguments);
        }

    }
    @GeneratedBy(TestV8ToStringNode.class)
    public static final class TestV8ToStringNodeGen extends TestV8ToStringNode implements Provider {

        @Child private JavaScriptNode arguments0_;

        private TestV8ToStringNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return toStringConv(arguments0Value_);
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
            s[0] = "toStringConv";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static TestV8ToStringNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new TestV8ToStringNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(TestV8ToNumberNode.class)
    public static final class TestV8ToNumberNodeGen extends TestV8ToNumberNode implements Provider {

        @Child private JavaScriptNode arguments0_;

        private TestV8ToNumberNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return toNumberOp(arguments0Value_);
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
            s[0] = "toNumberOp";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static TestV8ToNumberNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new TestV8ToNumberNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(TestV8ToPrimitiveNode.class)
    public static final class TestV8ToPrimitiveNodeGen extends TestV8ToPrimitiveNode implements Provider {

        @Child private JavaScriptNode arguments0_;

        private TestV8ToPrimitiveNodeGen(JSContext context, JSBuiltin builtin, Hint hint, JavaScriptNode[] arguments) {
            super(context, builtin, hint);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return toPrimitive(arguments0Value_);
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
            s[0] = "toPrimitive";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static TestV8ToPrimitiveNode create(JSContext context, JSBuiltin builtin, Hint hint, JavaScriptNode[] arguments) {
            return new TestV8ToPrimitiveNodeGen(context, builtin, hint, arguments);
        }

    }
    @GeneratedBy(TestV8ToNameNode.class)
    public static final class TestV8ToNameNodeGen extends TestV8ToNameNode implements Provider {

        @Child private JavaScriptNode arguments0_;

        private TestV8ToNameNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return toName(arguments0Value_);
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
            s[0] = "toName";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static TestV8ToNameNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new TestV8ToNameNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(TestV8RunMicrotasksNode.class)
    public static final class TestV8RunMicrotasksNodeGen extends TestV8RunMicrotasksNode implements Provider {

        private TestV8RunMicrotasksNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            return runMicrotasks();
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
            s[0] = "runMicrotasks";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static TestV8RunMicrotasksNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new TestV8RunMicrotasksNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(TestV8EnqueueJobNode.class)
    public static final class TestV8EnqueueJobNodeGen extends TestV8EnqueueJobNode implements Provider {

        @Child private JavaScriptNode arguments0_;

        private TestV8EnqueueJobNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return enqueueJob(arguments0Value_);
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
            s[0] = "enqueueJob";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static TestV8EnqueueJobNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new TestV8EnqueueJobNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(TestV8CreateAsyncFromSyncIterator.class)
    public static final class TestV8CreateAsyncFromSyncIteratorNodeGen extends TestV8CreateAsyncFromSyncIterator implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private int state_;

        private TestV8CreateAsyncFromSyncIteratorNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state & 0b1) != 0 /* is-active createAsyncFromSyncIterator(DynamicObject) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((JSGuards.isJSObject(arguments0Value__))) {
                    return createAsyncFromSyncIterator(arguments0Value__);
                }
            }
            if ((state & 0b10) != 0 /* is-active notObject(Object) */) {
                if ((!(JSGuards.isJSObject(arguments0Value_)))) {
                    return notObject(arguments0Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private Object executeAndSpecialize(Object arguments0Value) {
            int state = state_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((JSGuards.isJSObject(arguments0Value_))) {
                    this.state_ = state = state | 0b1 /* add-active createAsyncFromSyncIterator(DynamicObject) */;
                    return createAsyncFromSyncIterator(arguments0Value_);
                }
            }
            if ((!(JSGuards.isJSObject(arguments0Value)))) {
                this.state_ = state = state | 0b10 /* add-active notObject(Object) */;
                return notObject(arguments0Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_}, arguments0Value);
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
            s[0] = "createAsyncFromSyncIterator";
            if ((state & 0b1) != 0 /* is-active createAsyncFromSyncIterator(DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "notObject";
            if ((state & 0b10) != 0 /* is-active notObject(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static TestV8CreateAsyncFromSyncIterator create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new TestV8CreateAsyncFromSyncIteratorNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(TestV8ToLengthNode.class)
    public static final class TestV8ToLengthNodeGen extends TestV8ToLengthNode implements Provider {

        @Child private JavaScriptNode arguments0_;

        private TestV8ToLengthNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return toLengthOp(arguments0Value_);
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
            s[0] = "toLengthOp";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static TestV8ToLengthNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new TestV8ToLengthNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(TestV8ReferenceEqualNode.class)
    public static final class TestV8ReferenceEqualNodeGen extends TestV8ReferenceEqualNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;

        private TestV8ReferenceEqualNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            return referenceEqual(arguments0Value_, arguments1Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            return referenceEqual(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            executeBoolean(frameValue);
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
            s[0] = "referenceEqual";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static TestV8ReferenceEqualNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new TestV8ReferenceEqualNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(TestV8SetTimeoutNode.class)
    public static final class TestV8SetTimeoutNodeGen extends TestV8SetTimeoutNode implements Provider {

        @Child private JavaScriptNode arguments0_;

        private TestV8SetTimeoutNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return setTimeout(arguments0Value_);
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
            s[0] = "setTimeout";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static TestV8SetTimeoutNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new TestV8SetTimeoutNodeGen(context, builtin, arguments);
        }

    }
}
