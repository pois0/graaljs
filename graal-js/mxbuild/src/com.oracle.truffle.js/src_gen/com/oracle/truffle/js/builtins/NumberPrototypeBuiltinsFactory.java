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
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.js.builtins.NumberPrototypeBuiltins.JSNumberToExponentialNode;
import com.oracle.truffle.js.builtins.NumberPrototypeBuiltins.JSNumberToFixedNode;
import com.oracle.truffle.js.builtins.NumberPrototypeBuiltins.JSNumberToLocaleStringIntlNode;
import com.oracle.truffle.js.builtins.NumberPrototypeBuiltins.JSNumberToLocaleStringNode;
import com.oracle.truffle.js.builtins.NumberPrototypeBuiltins.JSNumberToPrecisionNode;
import com.oracle.truffle.js.builtins.NumberPrototypeBuiltins.JSNumberToStringNode;
import com.oracle.truffle.js.builtins.NumberPrototypeBuiltins.JSNumberValueOfNode;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.cast.JSToIntegerAsIntNode;
import com.oracle.truffle.js.nodes.cast.JSToNumberNode;
import com.oracle.truffle.js.nodes.cast.JSToStringNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(NumberPrototypeBuiltins.class)
public final class NumberPrototypeBuiltinsFactory {

    @GeneratedBy(JSNumberToStringNode.class)
    public static final class JSNumberToStringNodeGen extends JSNumberToStringNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_;
        @CompilationFinal private volatile int exclude_;
        @Child private JSToIntegerAsIntNode toInt;

        private JSNumberToStringNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state & 0b11011111) == 0 /* only-active toStringPrimitiveRadixInt(Number, int) */ && state != 0  /* is-not toStringIntRadix10(DynamicObject, Object) && toStringRadix10(DynamicObject, Object) && toString(DynamicObject, Object, JSToIntegerAsIntNode) && toStringPrimitiveIntRadix10(Object, Object) && toStringPrimitiveRadix10(Object, Object) && toStringPrimitiveRadixInt(Number, int) && toStringPrimitive(Number, Object, JSToIntegerAsIntNode) && toStringNoNumber(Object, Object) */) {
                return execute_int0(frameValue, state);
            } else {
                return execute_generic1(frameValue, state);
            }
        }

        private Object execute_int0(VirtualFrame frameValue, int state) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            int arguments1Value_;
            try {
                arguments1Value_ = this.arguments1_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(arguments0Value_, ex.getResult());
            }
            assert (state & 0b100000) != 0 /* is-active toStringPrimitiveRadixInt(Number, int) */;
            if (arguments0Value_ instanceof Number) {
                Number arguments0Value__ = (Number) arguments0Value_;
                return toStringPrimitiveRadixInt(arguments0Value__, arguments1Value_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        private Object execute_generic1(VirtualFrame frameValue, int state) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if ((state & 0b11111) != 0 /* is-active toStringIntRadix10(DynamicObject, Object) || toStringRadix10(DynamicObject, Object) || toString(DynamicObject, Object, JSToIntegerAsIntNode) || toStringPrimitiveIntRadix10(Object, Object) || toStringPrimitiveRadix10(Object, Object) */) {
                if ((state & 0b111) != 0 /* is-active toStringIntRadix10(DynamicObject, Object) || toStringRadix10(DynamicObject, Object) || toString(DynamicObject, Object, JSToIntegerAsIntNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((state & 0b1) != 0 /* is-active toStringIntRadix10(DynamicObject, Object) */) {
                        if ((JSGuards.isJSNumber(arguments0Value__)) && (JSGuards.isJSNumberInteger(arguments0Value__)) && (isRadix10(arguments1Value_))) {
                            return toStringIntRadix10(arguments0Value__, arguments1Value_);
                        }
                    }
                    if ((state & 0b10) != 0 /* is-active toStringRadix10(DynamicObject, Object) */) {
                        if ((JSGuards.isJSNumber(arguments0Value__)) && (isRadix10(arguments1Value_))) {
                            return toStringRadix10(arguments0Value__, arguments1Value_);
                        }
                    }
                    if ((state & 0b100) != 0 /* is-active toString(DynamicObject, Object, JSToIntegerAsIntNode) */) {
                        if ((JSGuards.isJSNumber(arguments0Value__)) && (!(JSGuards.isUndefined(arguments1Value_)))) {
                            return toString(arguments0Value__, arguments1Value_, this.toInt);
                        }
                    }
                }
                if ((state & 0b11000) != 0 /* is-active toStringPrimitiveIntRadix10(Object, Object) || toStringPrimitiveRadix10(Object, Object) */) {
                    if ((state & 0b1000) != 0 /* is-active toStringPrimitiveIntRadix10(Object, Object) */) {
                        if ((JSGuards.isJavaNumber(arguments0Value_)) && (JSGuards.isNumberInteger(arguments0Value_)) && (isRadix10(arguments1Value_))) {
                            return toStringPrimitiveIntRadix10(arguments0Value_, arguments1Value_);
                        }
                    }
                    if ((state & 0b10000) != 0 /* is-active toStringPrimitiveRadix10(Object, Object) */) {
                        if ((JSGuards.isJavaNumber(arguments0Value_)) && (isRadix10(arguments1Value_))) {
                            return toStringPrimitiveRadix10(arguments0Value_, arguments1Value_);
                        }
                    }
                }
            }
            if ((state & 0b1100000) != 0 /* is-active toStringPrimitiveRadixInt(Number, int) || toStringPrimitive(Number, Object, JSToIntegerAsIntNode) */ && arguments0Value_ instanceof Number) {
                Number arguments0Value__ = (Number) arguments0Value_;
                if ((state & 0b100000) != 0 /* is-active toStringPrimitiveRadixInt(Number, int) */ && arguments1Value_ instanceof Integer) {
                    int arguments1Value__ = (int) arguments1Value_;
                    return toStringPrimitiveRadixInt(arguments0Value__, arguments1Value__);
                }
                if ((state & 0b1000000) != 0 /* is-active toStringPrimitive(Number, Object, JSToIntegerAsIntNode) */) {
                    if ((!(JSGuards.isUndefined(arguments1Value_)))) {
                        return toStringPrimitive(arguments0Value__, arguments1Value_, this.toInt);
                    }
                }
            }
            if ((state & 0b10000000) != 0 /* is-active toStringNoNumber(Object, Object) */) {
                if ((!(JSGuards.isJSNumber(arguments0Value_))) && (!(JSGuards.isJavaNumber(arguments0Value_)))) {
                    return toStringNoNumber(arguments0Value_, arguments1Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private String executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int exclude = exclude_;
            try {
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSNumber(arguments0Value_)) && (JSGuards.isJSNumberInteger(arguments0Value_)) && (isRadix10(arguments1Value))) {
                        this.state_ = state = state | 0b1 /* add-active toStringIntRadix10(DynamicObject, Object) */;
                        lock.unlock();
                        hasLock = false;
                        return toStringIntRadix10(arguments0Value_, arguments1Value);
                    }
                    if ((JSGuards.isJSNumber(arguments0Value_)) && (isRadix10(arguments1Value))) {
                        this.state_ = state = state | 0b10 /* add-active toStringRadix10(DynamicObject, Object) */;
                        lock.unlock();
                        hasLock = false;
                        return toStringRadix10(arguments0Value_, arguments1Value);
                    }
                    if ((JSGuards.isJSNumber(arguments0Value_)) && (!(JSGuards.isUndefined(arguments1Value)))) {
                        if (this.toInt == null) {
                            this.toInt = super.insert((JSToIntegerAsIntNode.create()));
                        }
                        this.state_ = state = state | 0b100 /* add-active toString(DynamicObject, Object, JSToIntegerAsIntNode) */;
                        lock.unlock();
                        hasLock = false;
                        return toString(arguments0Value_, arguments1Value, this.toInt);
                    }
                }
                if ((JSGuards.isJavaNumber(arguments0Value)) && (JSGuards.isNumberInteger(arguments0Value)) && (isRadix10(arguments1Value))) {
                    this.state_ = state = state | 0b1000 /* add-active toStringPrimitiveIntRadix10(Object, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return toStringPrimitiveIntRadix10(arguments0Value, arguments1Value);
                }
                if ((JSGuards.isJavaNumber(arguments0Value)) && (isRadix10(arguments1Value))) {
                    this.state_ = state = state | 0b10000 /* add-active toStringPrimitiveRadix10(Object, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return toStringPrimitiveRadix10(arguments0Value, arguments1Value);
                }
                if (arguments0Value instanceof Number) {
                    Number arguments0Value_ = (Number) arguments0Value;
                    if ((exclude) == 0 /* is-not-excluded toStringPrimitiveRadixInt(Number, int) */ && arguments1Value instanceof Integer) {
                        int arguments1Value_ = (int) arguments1Value;
                        this.state_ = state = state | 0b100000 /* add-active toStringPrimitiveRadixInt(Number, int) */;
                        lock.unlock();
                        hasLock = false;
                        return toStringPrimitiveRadixInt(arguments0Value_, arguments1Value_);
                    }
                    if ((!(JSGuards.isUndefined(arguments1Value)))) {
                        if (this.toInt == null) {
                            this.toInt = super.insert((JSToIntegerAsIntNode.create()));
                        }
                        this.exclude_ = exclude = exclude | 0b1 /* add-excluded toStringPrimitiveRadixInt(Number, int) */;
                        state = state & 0xffffffdf /* remove-active toStringPrimitiveRadixInt(Number, int) */;
                        this.state_ = state = state | 0b1000000 /* add-active toStringPrimitive(Number, Object, JSToIntegerAsIntNode) */;
                        lock.unlock();
                        hasLock = false;
                        return toStringPrimitive(arguments0Value_, arguments1Value, this.toInt);
                    }
                }
                if ((!(JSGuards.isJSNumber(arguments0Value))) && (!(JSGuards.isJavaNumber(arguments0Value)))) {
                    this.state_ = state = state | 0b10000000 /* add-active toStringNoNumber(Object, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return toStringNoNumber(arguments0Value, arguments1Value);
                }
                throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_}, arguments0Value, arguments1Value);
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
            Object[] data = new Object[9];
            Object[] s;
            data[0] = 0;
            int state = state_;
            int exclude = exclude_;
            s = new Object[3];
            s[0] = "toStringIntRadix10";
            if ((state & 0b1) != 0 /* is-active toStringIntRadix10(DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "toStringRadix10";
            if ((state & 0b10) != 0 /* is-active toStringRadix10(DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "toString";
            if ((state & 0b100) != 0 /* is-active toString(DynamicObject, Object, JSToIntegerAsIntNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.toInt));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "toStringPrimitiveIntRadix10";
            if ((state & 0b1000) != 0 /* is-active toStringPrimitiveIntRadix10(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            s = new Object[3];
            s[0] = "toStringPrimitiveRadix10";
            if ((state & 0b10000) != 0 /* is-active toStringPrimitiveRadix10(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[5] = s;
            s = new Object[3];
            s[0] = "toStringPrimitiveRadixInt";
            if ((state & 0b100000) != 0 /* is-active toStringPrimitiveRadixInt(Number, int) */) {
                s[1] = (byte)0b01 /* active */;
            } else if (exclude != 0 /* is-excluded toStringPrimitiveRadixInt(Number, int) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[6] = s;
            s = new Object[3];
            s[0] = "toStringPrimitive";
            if ((state & 0b1000000) != 0 /* is-active toStringPrimitive(Number, Object, JSToIntegerAsIntNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.toInt));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[7] = s;
            s = new Object[3];
            s[0] = "toStringNoNumber";
            if ((state & 0b10000000) != 0 /* is-active toStringNoNumber(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[8] = s;
            return Provider.create(data);
        }

        public static JSNumberToStringNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSNumberToStringNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSNumberToLocaleStringNode.class)
    public static final class JSNumberToLocaleStringNodeGen extends JSNumberToLocaleStringNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private int state_;

        private JSNumberToLocaleStringNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state & 0b1) != 0 /* is-active toLocaleString(DynamicObject) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((JSGuards.isJSNumber(arguments0Value__))) {
                    return toLocaleString(arguments0Value__);
                }
            }
            if ((state & 0b110) != 0 /* is-active toLocaleStringPrimitive(Object) || toLocaleString(Object) */) {
                if ((state & 0b10) != 0 /* is-active toLocaleStringPrimitive(Object) */) {
                    if ((JSGuards.isJavaNumber(arguments0Value_))) {
                        return toLocaleStringPrimitive(arguments0Value_);
                    }
                }
                if ((state & 0b100) != 0 /* is-active toLocaleString(Object) */) {
                    if ((!(JSGuards.isJSNumber(arguments0Value_))) && (!(JSGuards.isJavaNumber(arguments0Value_)))) {
                        return toLocaleString(arguments0Value_);
                    }
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

        private String executeAndSpecialize(Object arguments0Value) {
            int state = state_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((JSGuards.isJSNumber(arguments0Value_))) {
                    this.state_ = state = state | 0b1 /* add-active toLocaleString(DynamicObject) */;
                    return toLocaleString(arguments0Value_);
                }
            }
            if ((JSGuards.isJavaNumber(arguments0Value))) {
                this.state_ = state = state | 0b10 /* add-active toLocaleStringPrimitive(Object) */;
                return toLocaleStringPrimitive(arguments0Value);
            }
            if ((!(JSGuards.isJSNumber(arguments0Value))) && (!(JSGuards.isJavaNumber(arguments0Value)))) {
                this.state_ = state = state | 0b100 /* add-active toLocaleString(Object) */;
                return toLocaleString(arguments0Value);
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
            Object[] data = new Object[4];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "toLocaleString";
            if ((state & 0b1) != 0 /* is-active toLocaleString(DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "toLocaleStringPrimitive";
            if ((state & 0b10) != 0 /* is-active toLocaleStringPrimitive(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "toLocaleString";
            if ((state & 0b100) != 0 /* is-active toLocaleString(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static JSNumberToLocaleStringNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSNumberToLocaleStringNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSNumberToLocaleStringIntlNode.class)
    public static final class JSNumberToLocaleStringIntlNodeGen extends JSNumberToLocaleStringIntlNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private int state_;

        private JSNumberToLocaleStringIntlNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state != 0 /* is-active jsNumberToLocaleString(DynamicObject, Object, Object) || javaNumberToLocaleString(Object, Object, Object) || failForNonNumbers(Object, Object, Object) */) {
                if ((state & 0b1) != 0 /* is-active jsNumberToLocaleString(DynamicObject, Object, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((JSGuards.isJSNumber(arguments0Value__))) {
                        return jsNumberToLocaleString(arguments0Value__, arguments1Value_, arguments2Value_);
                    }
                }
                if ((state & 0b110) != 0 /* is-active javaNumberToLocaleString(Object, Object, Object) || failForNonNumbers(Object, Object, Object) */) {
                    if ((state & 0b10) != 0 /* is-active javaNumberToLocaleString(Object, Object, Object) */) {
                        if ((JSGuards.isJavaNumber(arguments0Value_))) {
                            return javaNumberToLocaleString(arguments0Value_, arguments1Value_, arguments2Value_);
                        }
                    }
                    if ((state & 0b100) != 0 /* is-active failForNonNumbers(Object, Object, Object) */) {
                        if ((!(JSGuards.isJSNumber(arguments0Value_))) && (!(JSGuards.isJavaNumber(arguments0Value_)))) {
                            return failForNonNumbers(arguments0Value_, arguments1Value_, arguments2Value_);
                        }
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

        private String executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            int state = state_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((JSGuards.isJSNumber(arguments0Value_))) {
                    this.state_ = state = state | 0b1 /* add-active jsNumberToLocaleString(DynamicObject, Object, Object) */;
                    return jsNumberToLocaleString(arguments0Value_, arguments1Value, arguments2Value);
                }
            }
            if ((JSGuards.isJavaNumber(arguments0Value))) {
                this.state_ = state = state | 0b10 /* add-active javaNumberToLocaleString(Object, Object, Object) */;
                return javaNumberToLocaleString(arguments0Value, arguments1Value, arguments2Value);
            }
            if ((!(JSGuards.isJSNumber(arguments0Value))) && (!(JSGuards.isJavaNumber(arguments0Value)))) {
                this.state_ = state = state | 0b100 /* add-active failForNonNumbers(Object, Object, Object) */;
                return failForNonNumbers(arguments0Value, arguments1Value, arguments2Value);
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
            Object[] data = new Object[4];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "jsNumberToLocaleString";
            if ((state & 0b1) != 0 /* is-active jsNumberToLocaleString(DynamicObject, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "javaNumberToLocaleString";
            if ((state & 0b10) != 0 /* is-active javaNumberToLocaleString(Object, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "failForNonNumbers";
            if ((state & 0b100) != 0 /* is-active failForNonNumbers(Object, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static JSNumberToLocaleStringIntlNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSNumberToLocaleStringIntlNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSNumberValueOfNode.class)
    public static final class JSNumberValueOfNodeGen extends JSNumberValueOfNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private int state_;

        private JSNumberValueOfNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state & 0b1) != 0 /* is-active valueOf(DynamicObject) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((JSGuards.isJSNumber(arguments0Value__))) {
                    return valueOf(arguments0Value__);
                }
            }
            if ((state & 0b110) != 0 /* is-active valueOfPrimitive(Object) || valueOf(Object) */) {
                if ((state & 0b10) != 0 /* is-active valueOfPrimitive(Object) */) {
                    if ((JSGuards.isJavaNumber(arguments0Value_))) {
                        return valueOfPrimitive(arguments0Value_);
                    }
                }
                if ((state & 0b100) != 0 /* is-active valueOf(Object) */) {
                    if ((!(JSGuards.isJSNumber(arguments0Value_))) && (!(JSGuards.isJavaNumber(arguments0Value_)))) {
                        return valueOf(arguments0Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public double executeDouble(VirtualFrame frameValue) throws UnexpectedResultException {
            int state = state_;
            if ((state & 0b101) != 0 /* is-active valueOf(DynamicObject) || valueOf(Object) */) {
                return JSTypesGen.expectDouble(execute(frameValue));
            }
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state & 0b10) != 0 /* is-active valueOfPrimitive(Object) */) {
                if ((JSGuards.isJavaNumber(arguments0Value_))) {
                    return valueOfPrimitive(arguments0Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return JSTypesGen.expectDouble(executeAndSpecialize(arguments0Value_));
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            int state = state_;
            try {
                if ((state & 0b101) == 0 /* only-active valueOfPrimitive(Object) */ && state != 0  /* is-not valueOf(DynamicObject) && valueOfPrimitive(Object) && valueOf(Object) */) {
                    executeDouble(frameValue);
                    return;
                }
                execute(frameValue);
                return;
            } catch (UnexpectedResultException ex) {
                return;
            }
        }

        private Object executeAndSpecialize(Object arguments0Value) {
            int state = state_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((JSGuards.isJSNumber(arguments0Value_))) {
                    this.state_ = state = state | 0b1 /* add-active valueOf(DynamicObject) */;
                    return valueOf(arguments0Value_);
                }
            }
            if ((JSGuards.isJavaNumber(arguments0Value))) {
                this.state_ = state = state | 0b10 /* add-active valueOfPrimitive(Object) */;
                return valueOfPrimitive(arguments0Value);
            }
            if ((!(JSGuards.isJSNumber(arguments0Value))) && (!(JSGuards.isJavaNumber(arguments0Value)))) {
                this.state_ = state = state | 0b100 /* add-active valueOf(Object) */;
                return valueOf(arguments0Value);
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
            Object[] data = new Object[4];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "valueOf";
            if ((state & 0b1) != 0 /* is-active valueOf(DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "valueOfPrimitive";
            if ((state & 0b10) != 0 /* is-active valueOfPrimitive(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "valueOf";
            if ((state & 0b100) != 0 /* is-active valueOf(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static JSNumberValueOfNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSNumberValueOfNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSNumberToFixedNode.class)
    public static final class JSNumberToFixedNodeGen extends JSNumberToFixedNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_;
        @Child private JSToIntegerAsIntNode toInt;

        private JSNumberToFixedNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state != 0 /* is-active toFixed(DynamicObject, Object, JSToIntegerAsIntNode) || toFixedJava(Object, Object, JSToIntegerAsIntNode) || toFixedGeneric(Object, Object) */) {
                if ((state & 0b1) != 0 /* is-active toFixed(DynamicObject, Object, JSToIntegerAsIntNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((JSGuards.isJSNumber(arguments0Value__))) {
                        return toFixed(arguments0Value__, arguments1Value_, this.toInt);
                    }
                }
                if ((state & 0b110) != 0 /* is-active toFixedJava(Object, Object, JSToIntegerAsIntNode) || toFixedGeneric(Object, Object) */) {
                    if ((state & 0b10) != 0 /* is-active toFixedJava(Object, Object, JSToIntegerAsIntNode) */) {
                        if ((JSGuards.isJavaNumber(arguments0Value_))) {
                            return toFixedJava(arguments0Value_, arguments1Value_, this.toInt);
                        }
                    }
                    if ((state & 0b100) != 0 /* is-active toFixedGeneric(Object, Object) */) {
                        if ((!(JSGuards.isJSNumber(arguments0Value_))) && (!(JSGuards.isJavaNumber(arguments0Value_)))) {
                            return toFixedGeneric(arguments0Value_, arguments1Value_);
                        }
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private String executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            try {
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSNumber(arguments0Value_))) {
                        if (this.toInt == null) {
                            this.toInt = super.insert((JSToIntegerAsIntNode.create()));
                        }
                        this.state_ = state = state | 0b1 /* add-active toFixed(DynamicObject, Object, JSToIntegerAsIntNode) */;
                        lock.unlock();
                        hasLock = false;
                        return toFixed(arguments0Value_, arguments1Value, this.toInt);
                    }
                }
                if ((JSGuards.isJavaNumber(arguments0Value))) {
                    if (this.toInt == null) {
                        this.toInt = super.insert((JSToIntegerAsIntNode.create()));
                    }
                    this.state_ = state = state | 0b10 /* add-active toFixedJava(Object, Object, JSToIntegerAsIntNode) */;
                    lock.unlock();
                    hasLock = false;
                    return toFixedJava(arguments0Value, arguments1Value, this.toInt);
                }
                if ((!(JSGuards.isJSNumber(arguments0Value))) && (!(JSGuards.isJavaNumber(arguments0Value)))) {
                    this.state_ = state = state | 0b100 /* add-active toFixedGeneric(Object, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return toFixedGeneric(arguments0Value, arguments1Value);
                }
                throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_}, arguments0Value, arguments1Value);
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
            s[0] = "toFixed";
            if ((state & 0b1) != 0 /* is-active toFixed(DynamicObject, Object, JSToIntegerAsIntNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.toInt));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "toFixedJava";
            if ((state & 0b10) != 0 /* is-active toFixedJava(Object, Object, JSToIntegerAsIntNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.toInt));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "toFixedGeneric";
            if ((state & 0b100) != 0 /* is-active toFixedGeneric(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static JSNumberToFixedNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSNumberToFixedNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSNumberToExponentialNode.class)
    public static final class JSNumberToExponentialNodeGen extends JSNumberToExponentialNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_;
        @CompilationFinal private BranchProfile digitsError;
        @Child private JSToIntegerAsIntNode toInt;

        private JSNumberToExponentialNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state != 0 /* is-active toExponentialUndefined(DynamicObject, Object) || toExponential(DynamicObject, Object, BranchProfile, JSToIntegerAsIntNode) || toExponentialPrimitiveUndefined(Object, Object) || toExponentialPrimitive(Object, Object, BranchProfile, JSToIntegerAsIntNode) || toExponential(Object, Object) */) {
                if ((state & 0b11) != 0 /* is-active toExponentialUndefined(DynamicObject, Object) || toExponential(DynamicObject, Object, BranchProfile, JSToIntegerAsIntNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((state & 0b1) != 0 /* is-active toExponentialUndefined(DynamicObject, Object) */) {
                        if ((JSGuards.isJSNumber(arguments0Value__)) && (JSGuards.isUndefined(arguments1Value_))) {
                            return toExponentialUndefined(arguments0Value__, arguments1Value_);
                        }
                    }
                    if ((state & 0b10) != 0 /* is-active toExponential(DynamicObject, Object, BranchProfile, JSToIntegerAsIntNode) */) {
                        if ((JSGuards.isJSNumber(arguments0Value__)) && (!(JSGuards.isUndefined(arguments1Value_)))) {
                            return toExponential(arguments0Value__, arguments1Value_, this.digitsError, this.toInt);
                        }
                    }
                }
                if ((state & 0b11100) != 0 /* is-active toExponentialPrimitiveUndefined(Object, Object) || toExponentialPrimitive(Object, Object, BranchProfile, JSToIntegerAsIntNode) || toExponential(Object, Object) */) {
                    if ((state & 0b100) != 0 /* is-active toExponentialPrimitiveUndefined(Object, Object) */) {
                        if ((JSGuards.isJavaNumber(arguments0Value_)) && (JSGuards.isUndefined(arguments1Value_))) {
                            return toExponentialPrimitiveUndefined(arguments0Value_, arguments1Value_);
                        }
                    }
                    if ((state & 0b1000) != 0 /* is-active toExponentialPrimitive(Object, Object, BranchProfile, JSToIntegerAsIntNode) */) {
                        if ((JSGuards.isJavaNumber(arguments0Value_)) && (!(JSGuards.isUndefined(arguments1Value_)))) {
                            return toExponentialPrimitive(arguments0Value_, arguments1Value_, this.digitsError, this.toInt);
                        }
                    }
                    if ((state & 0b10000) != 0 /* is-active toExponential(Object, Object) */) {
                        if ((!(JSGuards.isJSNumber(arguments0Value_))) && (!(JSGuards.isJavaNumber(arguments0Value_)))) {
                            return toExponential(arguments0Value_, arguments1Value_);
                        }
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private String executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            try {
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSNumber(arguments0Value_)) && (JSGuards.isUndefined(arguments1Value))) {
                        this.state_ = state = state | 0b1 /* add-active toExponentialUndefined(DynamicObject, Object) */;
                        lock.unlock();
                        hasLock = false;
                        return toExponentialUndefined(arguments0Value_, arguments1Value);
                    }
                    if ((JSGuards.isJSNumber(arguments0Value_)) && (!(JSGuards.isUndefined(arguments1Value)))) {
                        if (this.digitsError == null) {
                            this.digitsError = (BranchProfile.create());
                        }
                        if (this.toInt == null) {
                            this.toInt = super.insert((JSToIntegerAsIntNode.create()));
                        }
                        this.state_ = state = state | 0b10 /* add-active toExponential(DynamicObject, Object, BranchProfile, JSToIntegerAsIntNode) */;
                        lock.unlock();
                        hasLock = false;
                        return toExponential(arguments0Value_, arguments1Value, this.digitsError, this.toInt);
                    }
                }
                if ((JSGuards.isJavaNumber(arguments0Value)) && (JSGuards.isUndefined(arguments1Value))) {
                    this.state_ = state = state | 0b100 /* add-active toExponentialPrimitiveUndefined(Object, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return toExponentialPrimitiveUndefined(arguments0Value, arguments1Value);
                }
                if ((JSGuards.isJavaNumber(arguments0Value)) && (!(JSGuards.isUndefined(arguments1Value)))) {
                    if (this.digitsError == null) {
                        this.digitsError = (BranchProfile.create());
                    }
                    if (this.toInt == null) {
                        this.toInt = super.insert((JSToIntegerAsIntNode.create()));
                    }
                    this.state_ = state = state | 0b1000 /* add-active toExponentialPrimitive(Object, Object, BranchProfile, JSToIntegerAsIntNode) */;
                    lock.unlock();
                    hasLock = false;
                    return toExponentialPrimitive(arguments0Value, arguments1Value, this.digitsError, this.toInt);
                }
                if ((!(JSGuards.isJSNumber(arguments0Value))) && (!(JSGuards.isJavaNumber(arguments0Value)))) {
                    this.state_ = state = state | 0b10000 /* add-active toExponential(Object, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return toExponential(arguments0Value, arguments1Value);
                }
                throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_}, arguments0Value, arguments1Value);
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
            Object[] data = new Object[6];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "toExponentialUndefined";
            if ((state & 0b1) != 0 /* is-active toExponentialUndefined(DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "toExponential";
            if ((state & 0b10) != 0 /* is-active toExponential(DynamicObject, Object, BranchProfile, JSToIntegerAsIntNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.digitsError, this.toInt));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "toExponentialPrimitiveUndefined";
            if ((state & 0b100) != 0 /* is-active toExponentialPrimitiveUndefined(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "toExponentialPrimitive";
            if ((state & 0b1000) != 0 /* is-active toExponentialPrimitive(Object, Object, BranchProfile, JSToIntegerAsIntNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.digitsError, this.toInt));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            s = new Object[3];
            s[0] = "toExponential";
            if ((state & 0b10000) != 0 /* is-active toExponential(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[5] = s;
            return Provider.create(data);
        }

        public static JSNumberToExponentialNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSNumberToExponentialNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSNumberToPrecisionNode.class)
    public static final class JSNumberToPrecisionNodeGen extends JSNumberToPrecisionNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_;
        @Child private JSToStringNode toString;
        @Child private JSToNumberNode toNumber;

        private JSNumberToPrecisionNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state != 0 /* is-active toPrecisionUndefined(DynamicObject, Object, JSToStringNode) || toPrecision(DynamicObject, Object, JSToNumberNode) || toPrecisionPrimitiveUndefined(Object, Object, JSToStringNode) || toPrecisionPrimitive(Object, Object, JSToNumberNode) || toPrecision(Object, Object) */) {
                if ((state & 0b11) != 0 /* is-active toPrecisionUndefined(DynamicObject, Object, JSToStringNode) || toPrecision(DynamicObject, Object, JSToNumberNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((state & 0b1) != 0 /* is-active toPrecisionUndefined(DynamicObject, Object, JSToStringNode) */) {
                        if ((JSGuards.isJSNumber(arguments0Value__)) && (JSGuards.isUndefined(arguments1Value_))) {
                            return toPrecisionUndefined(arguments0Value__, arguments1Value_, this.toString);
                        }
                    }
                    if ((state & 0b10) != 0 /* is-active toPrecision(DynamicObject, Object, JSToNumberNode) */) {
                        if ((JSGuards.isJSNumber(arguments0Value__)) && (!(JSGuards.isUndefined(arguments1Value_)))) {
                            return toPrecision(arguments0Value__, arguments1Value_, this.toNumber);
                        }
                    }
                }
                if ((state & 0b11100) != 0 /* is-active toPrecisionPrimitiveUndefined(Object, Object, JSToStringNode) || toPrecisionPrimitive(Object, Object, JSToNumberNode) || toPrecision(Object, Object) */) {
                    if ((state & 0b100) != 0 /* is-active toPrecisionPrimitiveUndefined(Object, Object, JSToStringNode) */) {
                        if ((JSGuards.isJavaNumber(arguments0Value_)) && (JSGuards.isUndefined(arguments1Value_))) {
                            return toPrecisionPrimitiveUndefined(arguments0Value_, arguments1Value_, this.toString);
                        }
                    }
                    if ((state & 0b1000) != 0 /* is-active toPrecisionPrimitive(Object, Object, JSToNumberNode) */) {
                        if ((JSGuards.isJavaNumber(arguments0Value_)) && (!(JSGuards.isUndefined(arguments1Value_)))) {
                            return toPrecisionPrimitive(arguments0Value_, arguments1Value_, this.toNumber);
                        }
                    }
                    if ((state & 0b10000) != 0 /* is-active toPrecision(Object, Object) */) {
                        if ((!(JSGuards.isJSNumber(arguments0Value_))) && (!(JSGuards.isJavaNumber(arguments0Value_)))) {
                            return toPrecision(arguments0Value_, arguments1Value_);
                        }
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private String executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            try {
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSNumber(arguments0Value_)) && (JSGuards.isUndefined(arguments1Value))) {
                        if (this.toString == null) {
                            this.toString = super.insert((JSToStringNode.create()));
                        }
                        this.state_ = state = state | 0b1 /* add-active toPrecisionUndefined(DynamicObject, Object, JSToStringNode) */;
                        lock.unlock();
                        hasLock = false;
                        return toPrecisionUndefined(arguments0Value_, arguments1Value, this.toString);
                    }
                    if ((JSGuards.isJSNumber(arguments0Value_)) && (!(JSGuards.isUndefined(arguments1Value)))) {
                        if (this.toNumber == null) {
                            this.toNumber = super.insert((JSToNumberNode.create()));
                        }
                        this.state_ = state = state | 0b10 /* add-active toPrecision(DynamicObject, Object, JSToNumberNode) */;
                        lock.unlock();
                        hasLock = false;
                        return toPrecision(arguments0Value_, arguments1Value, this.toNumber);
                    }
                }
                if ((JSGuards.isJavaNumber(arguments0Value)) && (JSGuards.isUndefined(arguments1Value))) {
                    if (this.toString == null) {
                        this.toString = super.insert((JSToStringNode.create()));
                    }
                    this.state_ = state = state | 0b100 /* add-active toPrecisionPrimitiveUndefined(Object, Object, JSToStringNode) */;
                    lock.unlock();
                    hasLock = false;
                    return toPrecisionPrimitiveUndefined(arguments0Value, arguments1Value, this.toString);
                }
                if ((JSGuards.isJavaNumber(arguments0Value)) && (!(JSGuards.isUndefined(arguments1Value)))) {
                    if (this.toNumber == null) {
                        this.toNumber = super.insert((JSToNumberNode.create()));
                    }
                    this.state_ = state = state | 0b1000 /* add-active toPrecisionPrimitive(Object, Object, JSToNumberNode) */;
                    lock.unlock();
                    hasLock = false;
                    return toPrecisionPrimitive(arguments0Value, arguments1Value, this.toNumber);
                }
                if ((!(JSGuards.isJSNumber(arguments0Value))) && (!(JSGuards.isJavaNumber(arguments0Value)))) {
                    this.state_ = state = state | 0b10000 /* add-active toPrecision(Object, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return toPrecision(arguments0Value, arguments1Value);
                }
                throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_}, arguments0Value, arguments1Value);
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
            Object[] data = new Object[6];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "toPrecisionUndefined";
            if ((state & 0b1) != 0 /* is-active toPrecisionUndefined(DynamicObject, Object, JSToStringNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.toString));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "toPrecision";
            if ((state & 0b10) != 0 /* is-active toPrecision(DynamicObject, Object, JSToNumberNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.toNumber));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "toPrecisionPrimitiveUndefined";
            if ((state & 0b100) != 0 /* is-active toPrecisionPrimitiveUndefined(Object, Object, JSToStringNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.toString));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "toPrecisionPrimitive";
            if ((state & 0b1000) != 0 /* is-active toPrecisionPrimitive(Object, Object, JSToNumberNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.toNumber));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            s = new Object[3];
            s[0] = "toPrecision";
            if ((state & 0b10000) != 0 /* is-active toPrecision(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[5] = s;
            return Provider.create(data);
        }

        public static JSNumberToPrecisionNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSNumberToPrecisionNodeGen(context, builtin, arguments);
        }

    }
}
