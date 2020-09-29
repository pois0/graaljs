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
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.api.profiles.ValueProfile;
import com.oracle.truffle.js.builtins.ArrayPrototypeBuiltins.JSArrayOperation;
import com.oracle.truffle.js.builtins.TypedArrayPrototypeBuiltins.JSArrayBufferViewFillNode;
import com.oracle.truffle.js.builtins.TypedArrayPrototypeBuiltins.JSArrayBufferViewForEachNode;
import com.oracle.truffle.js.builtins.TypedArrayPrototypeBuiltins.JSArrayBufferViewIteratorNode;
import com.oracle.truffle.js.builtins.TypedArrayPrototypeBuiltins.JSArrayBufferViewReverseNode;
import com.oracle.truffle.js.builtins.TypedArrayPrototypeBuiltins.JSArrayBufferViewSetNode;
import com.oracle.truffle.js.builtins.TypedArrayPrototypeBuiltins.JSArrayBufferViewSubarrayNode;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.control.DeletePropertyNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(TypedArrayPrototypeBuiltins.class)
public final class TypedArrayPrototypeBuiltinsFactory {

    @GeneratedBy(JSArrayBufferViewSubarrayNode.class)
    public static final class JSArrayBufferViewSubarrayNodeGen extends JSArrayBufferViewSubarrayNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private volatile int state_;
        @CompilationFinal private ValueProfile subarray0_arrayTypeProfile_;
        @CompilationFinal private Subarray1Data subarray1_cache;

        private JSArrayBufferViewSubarrayNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
            this.arguments2_ = arguments != null && 2 < arguments.length ? arguments[2] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_, this.arguments2_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            if ((state & 0b110) == 0 /* only-active subarray(DynamicObject, int, int, ValueProfile) */ && state != 0  /* is-not subarray(DynamicObject, int, int, ValueProfile) && subarray(DynamicObject, Object, Object, ValueProfile, ConditionProfile, ConditionProfile, ConditionProfile) && subarrayGeneric(Object, Object, Object) */) {
                return execute_int_int0(frameValue, state);
            } else {
                return execute_generic1(frameValue, state);
            }
        }

        private Object execute_int_int0(VirtualFrame frameValue, int state) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            int arguments1Value_;
            try {
                arguments1Value_ = this.arguments1_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                Object arguments2Value = this.arguments2_.execute(frameValue);
                return executeAndSpecialize(arguments0Value_, ex.getResult(), arguments2Value);
            }
            int arguments2Value_;
            try {
                arguments2Value_ = this.arguments2_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(arguments0Value_, arguments1Value_, ex.getResult());
            }
            assert (state & 0b1) != 0 /* is-active subarray(DynamicObject, int, int, ValueProfile) */;
            if (JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((JSGuards.isJSArrayBufferView(arguments0Value__))) {
                    return subarray(arguments0Value__, arguments1Value_, arguments2Value_, this.subarray0_arrayTypeProfile_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        private Object execute_generic1(VirtualFrame frameValue, int state) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if ((state & 0b11) != 0 /* is-active subarray(DynamicObject, int, int, ValueProfile) || subarray(DynamicObject, Object, Object, ValueProfile, ConditionProfile, ConditionProfile, ConditionProfile) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state & 0b1) != 0 /* is-active subarray(DynamicObject, int, int, ValueProfile) */ && arguments1Value_ instanceof Integer) {
                    int arguments1Value__ = (int) arguments1Value_;
                    if (arguments2Value_ instanceof Integer) {
                        int arguments2Value__ = (int) arguments2Value_;
                        if ((JSGuards.isJSArrayBufferView(arguments0Value__))) {
                            return subarray(arguments0Value__, arguments1Value__, arguments2Value__, this.subarray0_arrayTypeProfile_);
                        }
                    }
                }
                if ((state & 0b10) != 0 /* is-active subarray(DynamicObject, Object, Object, ValueProfile, ConditionProfile, ConditionProfile, ConditionProfile) */) {
                    Subarray1Data s2_ = this.subarray1_cache;
                    if (s2_ != null) {
                        if ((JSGuards.isJSArrayBufferView(arguments0Value__))) {
                            return subarray(arguments0Value__, arguments1Value_, arguments2Value_, s2_.arrayTypeProfile_, s2_.negativeBegin_, s2_.negativeEnd_, s2_.smallerEnd_);
                        }
                    }
                }
            }
            if ((state & 0b100) != 0 /* is-active subarrayGeneric(Object, Object, Object) */) {
                if ((!(JSGuards.isJSArrayBufferView(arguments0Value_)))) {
                    return subarrayGeneric(arguments0Value_, arguments1Value_, arguments2Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            try {
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if (arguments1Value instanceof Integer) {
                        int arguments1Value_ = (int) arguments1Value;
                        if (arguments2Value instanceof Integer) {
                            int arguments2Value_ = (int) arguments2Value;
                            if ((JSGuards.isJSArrayBufferView(arguments0Value_))) {
                                this.subarray0_arrayTypeProfile_ = (ValueProfile.createIdentityProfile());
                                this.state_ = state = state | 0b1 /* add-active subarray(DynamicObject, int, int, ValueProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return subarray(arguments0Value_, arguments1Value_, arguments2Value_, this.subarray0_arrayTypeProfile_);
                            }
                        }
                    }
                    if ((JSGuards.isJSArrayBufferView(arguments0Value_))) {
                        Subarray1Data s2_ = new Subarray1Data();
                        s2_.arrayTypeProfile_ = (ValueProfile.createIdentityProfile());
                        s2_.negativeBegin_ = (ConditionProfile.createBinaryProfile());
                        s2_.negativeEnd_ = (ConditionProfile.createBinaryProfile());
                        s2_.smallerEnd_ = (ConditionProfile.createBinaryProfile());
                        this.subarray1_cache = s2_;
                        this.state_ = state = state | 0b10 /* add-active subarray(DynamicObject, Object, Object, ValueProfile, ConditionProfile, ConditionProfile, ConditionProfile) */;
                        lock.unlock();
                        hasLock = false;
                        return subarray(arguments0Value_, arguments1Value, arguments2Value, s2_.arrayTypeProfile_, s2_.negativeBegin_, s2_.negativeEnd_, s2_.smallerEnd_);
                    }
                }
                if ((!(JSGuards.isJSArrayBufferView(arguments0Value)))) {
                    this.state_ = state = state | 0b100 /* add-active subarrayGeneric(Object, Object, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return subarrayGeneric(arguments0Value, arguments1Value, arguments2Value);
                }
                throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_, this.arguments2_}, arguments0Value, arguments1Value, arguments2Value);
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
            Object[] data = new Object[4];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "subarray";
            if ((state & 0b1) != 0 /* is-active subarray(DynamicObject, int, int, ValueProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.subarray0_arrayTypeProfile_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "subarray";
            if ((state & 0b10) != 0 /* is-active subarray(DynamicObject, Object, Object, ValueProfile, ConditionProfile, ConditionProfile, ConditionProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                Subarray1Data s2_ = this.subarray1_cache;
                if (s2_ != null) {
                    cached.add(Arrays.asList(s2_.arrayTypeProfile_, s2_.negativeBegin_, s2_.negativeEnd_, s2_.smallerEnd_));
                }
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "subarrayGeneric";
            if ((state & 0b100) != 0 /* is-active subarrayGeneric(Object, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static JSArrayBufferViewSubarrayNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSArrayBufferViewSubarrayNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(JSArrayBufferViewSubarrayNode.class)
        private static final class Subarray1Data {

            @CompilationFinal ValueProfile arrayTypeProfile_;
            @CompilationFinal ConditionProfile negativeBegin_;
            @CompilationFinal ConditionProfile negativeEnd_;
            @CompilationFinal ConditionProfile smallerEnd_;

            Subarray1Data() {
            }

        }
    }
    @GeneratedBy(JSArrayBufferViewSetNode.class)
    public static final class JSArrayBufferViewSetNodeGen extends JSArrayBufferViewSetNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private int state_;

        private JSArrayBufferViewSetNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
            this.arguments2_ = arguments != null && 2 < arguments.length ? arguments[2] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_, this.arguments2_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if (state != 0 /* is-active set(DynamicObject, Object, Object) || set(Object, Object, Object) */) {
                if ((state & 0b1) != 0 /* is-active set(DynamicObject, Object, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((JSGuards.isJSArrayBufferView(arguments0Value__))) {
                        return set(arguments0Value__, arguments1Value_, arguments2Value_);
                    }
                }
                if ((state & 0b10) != 0 /* is-active set(Object, Object, Object) */) {
                    if ((!(JSGuards.isJSArrayBufferView(arguments0Value_)))) {
                        return set(arguments0Value_, arguments1Value_, arguments2Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private Object executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            int state = state_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((JSGuards.isJSArrayBufferView(arguments0Value_))) {
                    this.state_ = state = state | 0b1 /* add-active set(DynamicObject, Object, Object) */;
                    return set(arguments0Value_, arguments1Value, arguments2Value);
                }
            }
            if ((!(JSGuards.isJSArrayBufferView(arguments0Value)))) {
                this.state_ = state = state | 0b10 /* add-active set(Object, Object, Object) */;
                return set(arguments0Value, arguments1Value, arguments2Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_, this.arguments2_}, arguments0Value, arguments1Value, arguments2Value);
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
            s[0] = "set";
            if ((state & 0b1) != 0 /* is-active set(DynamicObject, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "set";
            if ((state & 0b10) != 0 /* is-active set(Object, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static JSArrayBufferViewSetNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSArrayBufferViewSetNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSArrayBufferViewForEachNode.class)
    public static final class JSArrayBufferViewForEachNodeGen extends JSArrayBufferViewForEachNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private int state_;

        private JSArrayBufferViewForEachNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
            this.arguments2_ = arguments != null && 2 < arguments.length ? arguments[2] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_, this.arguments2_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if (state != 0 /* is-active forEach(DynamicObject, Object, Object) || forEachNonTypedArray(Object, Object, Object) */) {
                if ((state & 0b1) != 0 /* is-active forEach(DynamicObject, Object, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((JSGuards.isJSArrayBufferView(arguments0Value__))) {
                        return forEach(arguments0Value__, arguments1Value_, arguments2Value_);
                    }
                }
                if ((state & 0b10) != 0 /* is-active forEachNonTypedArray(Object, Object, Object) */) {
                    if ((!(JSGuards.isJSArrayBufferView(arguments0Value_)))) {
                        return forEachNonTypedArray(arguments0Value_, arguments1Value_, arguments2Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private Object executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            int state = state_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((JSGuards.isJSArrayBufferView(arguments0Value_))) {
                    this.state_ = state = state | 0b1 /* add-active forEach(DynamicObject, Object, Object) */;
                    return forEach(arguments0Value_, arguments1Value, arguments2Value);
                }
            }
            if ((!(JSGuards.isJSArrayBufferView(arguments0Value)))) {
                this.state_ = state = state | 0b10 /* add-active forEachNonTypedArray(Object, Object, Object) */;
                return forEachNonTypedArray(arguments0Value, arguments1Value, arguments2Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_, this.arguments2_}, arguments0Value, arguments1Value, arguments2Value);
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
            s[0] = "forEach";
            if ((state & 0b1) != 0 /* is-active forEach(DynamicObject, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "forEachNonTypedArray";
            if ((state & 0b10) != 0 /* is-active forEachNonTypedArray(Object, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static JSArrayBufferViewForEachNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSArrayBufferViewForEachNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSArrayBufferViewReverseNode.class)
    public static final class JSArrayBufferViewReverseNodeGen extends JSArrayBufferViewReverseNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_;
        @Child private DeletePropertyNode reverse0_deletePropertyNode_;

        private JSArrayBufferViewReverseNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state & 0b1) != 0 /* is-active reverse(DynamicObject, DeletePropertyNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((JSGuards.isJSArrayBufferView(arguments0Value__))) {
                    return reverse(arguments0Value__, this.reverse0_deletePropertyNode_);
                }
            }
            if ((state & 0b10) != 0 /* is-active reverse(Object) */) {
                if ((!(JSGuards.isJSArrayBufferView(arguments0Value_)))) {
                    return reverse(arguments0Value_);
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
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            try {
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSArrayBufferView(arguments0Value_))) {
                        this.reverse0_deletePropertyNode_ = super.insert((DeletePropertyNode.create(JSArrayOperation.THROW_ERROR, getContext())));
                        this.state_ = state = state | 0b1 /* add-active reverse(DynamicObject, DeletePropertyNode) */;
                        lock.unlock();
                        hasLock = false;
                        return reverse(arguments0Value_, this.reverse0_deletePropertyNode_);
                    }
                }
                if ((!(JSGuards.isJSArrayBufferView(arguments0Value)))) {
                    this.state_ = state = state | 0b10 /* add-active reverse(Object) */;
                    lock.unlock();
                    hasLock = false;
                    return reverse(arguments0Value);
                }
                throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_}, arguments0Value);
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
            s[0] = "reverse";
            if ((state & 0b1) != 0 /* is-active reverse(DynamicObject, DeletePropertyNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.reverse0_deletePropertyNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "reverse";
            if ((state & 0b10) != 0 /* is-active reverse(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static JSArrayBufferViewReverseNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSArrayBufferViewReverseNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSArrayBufferViewFillNode.class)
    public static final class JSArrayBufferViewFillNodeGen extends JSArrayBufferViewFillNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @Child private JavaScriptNode arguments3_;

        private JSArrayBufferViewFillNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
            this.arguments2_ = arguments != null && 2 < arguments.length ? arguments[2] : null;
            this.arguments3_ = arguments != null && 3 < arguments.length ? arguments[3] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_, this.arguments2_, this.arguments3_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            Object arguments3Value_ = this.arguments3_.execute(frameValue);
            return fill(arguments0Value_, arguments1Value_, arguments2Value_, arguments3Value_);
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
            s[0] = "fill";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSArrayBufferViewFillNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSArrayBufferViewFillNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSArrayBufferViewIteratorNode.class)
    public static final class JSArrayBufferViewIteratorNodeGen extends JSArrayBufferViewIteratorNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private int state_;

        private JSArrayBufferViewIteratorNodeGen(JSContext context, JSBuiltin builtin, int iterationKind, JavaScriptNode[] arguments) {
            super(context, builtin, iterationKind);
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
            if ((state & 0b1) != 0 /* is-active doObject(VirtualFrame, DynamicObject) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((JSGuards.isJSArrayBufferView(arguments0Value__))) {
                    return doObject(frameValue, arguments0Value__);
                }
            }
            if ((state & 0b10) != 0 /* is-active doNotObject(Object) */) {
                if ((!(JSGuards.isJSArrayBufferView(arguments0Value_)))) {
                    return doNotObject(arguments0Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(frameValue, arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(VirtualFrame frameValue, Object arguments0Value) {
            int state = state_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((JSGuards.isJSArrayBufferView(arguments0Value_))) {
                    this.state_ = state = state | 0b1 /* add-active doObject(VirtualFrame, DynamicObject) */;
                    return doObject(frameValue, arguments0Value_);
                }
            }
            if ((!(JSGuards.isJSArrayBufferView(arguments0Value)))) {
                this.state_ = state = state | 0b10 /* add-active doNotObject(Object) */;
                return doNotObject(arguments0Value);
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
            s[0] = "doObject";
            if ((state & 0b1) != 0 /* is-active doObject(VirtualFrame, DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doNotObject";
            if ((state & 0b10) != 0 /* is-active doNotObject(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static JSArrayBufferViewIteratorNode create(JSContext context, JSBuiltin builtin, int iterationKind, JavaScriptNode[] arguments) {
            return new JSArrayBufferViewIteratorNodeGen(context, builtin, iterationKind, arguments);
        }

    }
}
