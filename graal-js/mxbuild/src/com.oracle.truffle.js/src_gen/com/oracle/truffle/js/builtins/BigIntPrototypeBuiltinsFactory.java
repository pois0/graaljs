// CheckStyle: start generated
package com.oracle.truffle.js.builtins;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.builtins.BigIntPrototypeBuiltins.JSBigIntToLocaleStringIntlNode;
import com.oracle.truffle.js.builtins.BigIntPrototypeBuiltins.JSBigIntToLocaleStringNode;
import com.oracle.truffle.js.builtins.BigIntPrototypeBuiltins.JSBigIntToStringNode;
import com.oracle.truffle.js.builtins.BigIntPrototypeBuiltins.JSBigIntValueOfNode;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.BigInt;
import com.oracle.truffle.js.runtime.JSContext;

@GeneratedBy(BigIntPrototypeBuiltins.class)
@SuppressWarnings("unused")
public final class BigIntPrototypeBuiltinsFactory {

    @GeneratedBy(JSBigIntToStringNode.class)
    public static final class JSBigIntToStringNodeGen extends JSBigIntToStringNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private int state_;

        private JSBigIntToStringNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state & 0b1111) != 0 /* is-active toStringBigIntRadix10(BigInt, Object) || toStringBigInt(BigInt, Object) || toStringRadix10(DynamicObject, Object) || toString(DynamicObject, Object) */) {
                if ((state & 0b11) != 0 /* is-active toStringBigIntRadix10(BigInt, Object) || toStringBigInt(BigInt, Object) */ && arguments0Value_ instanceof BigInt) {
                    BigInt arguments0Value__ = (BigInt) arguments0Value_;
                    if ((state & 0b1) != 0 /* is-active toStringBigIntRadix10(BigInt, Object) */) {
                        if ((JSGuards.isUndefined(arguments1Value_))) {
                            return toStringBigIntRadix10(arguments0Value__, arguments1Value_);
                        }
                    }
                    if ((state & 0b10) != 0 /* is-active toStringBigInt(BigInt, Object) */) {
                        if ((!(JSGuards.isUndefined(arguments1Value_)))) {
                            return toStringBigInt(arguments0Value__, arguments1Value_);
                        }
                    }
                }
                if ((state & 0b1100) != 0 /* is-active toStringRadix10(DynamicObject, Object) || toString(DynamicObject, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((state & 0b100) != 0 /* is-active toStringRadix10(DynamicObject, Object) */) {
                        if ((JSGuards.isJSBigInt(arguments0Value__)) && (JSGuards.isUndefined(arguments1Value_))) {
                            return toStringRadix10(arguments0Value__, arguments1Value_);
                        }
                    }
                    if ((state & 0b1000) != 0 /* is-active toString(DynamicObject, Object) */) {
                        if ((JSGuards.isJSBigInt(arguments0Value__)) && (!(JSGuards.isUndefined(arguments1Value_)))) {
                            return toString(arguments0Value__, arguments1Value_);
                        }
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            int state = state_;
            if ((state & 0b1111) != 0 /* is-active toStringBigIntRadix10(BigInt, Object) || toStringBigInt(BigInt, Object) || toStringRadix10(DynamicObject, Object) || toString(DynamicObject, Object) */) {
                execute(frameValue);
                return;
            }
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if ((state & 0b10000) != 0 /* is-active toStringNoBigInt(Object, Object) */) {
                if (fallbackGuard_(state, arguments0Value_, arguments1Value_)) {
                    toStringNoBigInt(arguments0Value_, arguments1Value_);
                    return;
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            executeAndSpecialize(arguments0Value_, arguments1Value_);
            return;
        }

        private String executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            int state = state_;
            if (arguments0Value instanceof BigInt) {
                BigInt arguments0Value_ = (BigInt) arguments0Value;
                if ((JSGuards.isUndefined(arguments1Value))) {
                    this.state_ = state = state | 0b1 /* add-active toStringBigIntRadix10(BigInt, Object) */;
                    return toStringBigIntRadix10(arguments0Value_, arguments1Value);
                }
                if ((!(JSGuards.isUndefined(arguments1Value)))) {
                    this.state_ = state = state | 0b10 /* add-active toStringBigInt(BigInt, Object) */;
                    return toStringBigInt(arguments0Value_, arguments1Value);
                }
            }
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((JSGuards.isJSBigInt(arguments0Value_)) && (JSGuards.isUndefined(arguments1Value))) {
                    this.state_ = state = state | 0b100 /* add-active toStringRadix10(DynamicObject, Object) */;
                    return toStringRadix10(arguments0Value_, arguments1Value);
                }
                if ((JSGuards.isJSBigInt(arguments0Value_)) && (!(JSGuards.isUndefined(arguments1Value)))) {
                    this.state_ = state = state | 0b1000 /* add-active toString(DynamicObject, Object) */;
                    return toString(arguments0Value_, arguments1Value);
                }
            }
            this.state_ = state = state | 0b10000 /* add-active toStringNoBigInt(Object, Object) */;
            toStringNoBigInt(arguments0Value, arguments1Value);
            return null;
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
            s[0] = "toStringBigIntRadix10";
            if ((state & 0b1) != 0 /* is-active toStringBigIntRadix10(BigInt, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "toStringBigInt";
            if ((state & 0b10) != 0 /* is-active toStringBigInt(BigInt, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "toStringRadix10";
            if ((state & 0b100) != 0 /* is-active toStringRadix10(DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "toString";
            if ((state & 0b1000) != 0 /* is-active toString(DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            s = new Object[3];
            s[0] = "toStringNoBigInt";
            if ((state & 0b10000) != 0 /* is-active toStringNoBigInt(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[5] = s;
            return Provider.create(data);
        }

        private static boolean fallbackGuard_(int state, Object arguments0Value, Object arguments1Value) {
            if (arguments0Value instanceof BigInt) {
                if (((state & 0b1)) == 0 /* is-not-active toStringBigIntRadix10(BigInt, Object) */ && (JSGuards.isUndefined(arguments1Value))) {
                    return false;
                }
                if (((state & 0b10)) == 0 /* is-not-active toStringBigInt(BigInt, Object) */ && (!(JSGuards.isUndefined(arguments1Value)))) {
                    return false;
                }
            }
            if (JSTypes.isDynamicObject(arguments0Value)) {
                {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSBigInt(arguments0Value_)) && (JSGuards.isUndefined(arguments1Value))) {
                        return false;
                    }
                }
                {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSBigInt(arguments0Value_)) && (!(JSGuards.isUndefined(arguments1Value)))) {
                        return false;
                    }
                }
            }
            return true;
        }

        public static JSBigIntToStringNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSBigIntToStringNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSBigIntToLocaleStringIntlNode.class)
    public static final class JSBigIntToLocaleStringIntlNodeGen extends JSBigIntToLocaleStringIntlNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private int state_;

        private JSBigIntToLocaleStringIntlNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state != 0 /* is-active bigIntToLocaleString(BigInt, Object, Object) || jsBigIntToLocaleString(DynamicObject, Object, Object) || failForNonBigInts(Object, Object, Object) */) {
                if ((state & 0b1) != 0 /* is-active bigIntToLocaleString(BigInt, Object, Object) */ && arguments0Value_ instanceof BigInt) {
                    BigInt arguments0Value__ = (BigInt) arguments0Value_;
                    return bigIntToLocaleString(arguments0Value__, arguments1Value_, arguments2Value_);
                }
                if ((state & 0b10) != 0 /* is-active jsBigIntToLocaleString(DynamicObject, Object, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((JSGuards.isJSBigInt(arguments0Value__))) {
                        return jsBigIntToLocaleString(arguments0Value__, arguments1Value_, arguments2Value_);
                    }
                }
                if ((state & 0b100) != 0 /* is-active failForNonBigInts(Object, Object, Object) */) {
                    if (fallbackGuard_(state, arguments0Value_, arguments1Value_, arguments2Value_)) {
                        return failForNonBigInts(arguments0Value_, arguments1Value_, arguments2Value_);
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
            if (arguments0Value instanceof BigInt) {
                BigInt arguments0Value_ = (BigInt) arguments0Value;
                this.state_ = state = state | 0b1 /* add-active bigIntToLocaleString(BigInt, Object, Object) */;
                return bigIntToLocaleString(arguments0Value_, arguments1Value, arguments2Value);
            }
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((JSGuards.isJSBigInt(arguments0Value_))) {
                    this.state_ = state = state | 0b10 /* add-active jsBigIntToLocaleString(DynamicObject, Object, Object) */;
                    return jsBigIntToLocaleString(arguments0Value_, arguments1Value, arguments2Value);
                }
            }
            this.state_ = state = state | 0b100 /* add-active failForNonBigInts(Object, Object, Object) */;
            return failForNonBigInts(arguments0Value, arguments1Value, arguments2Value);
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
            s[0] = "bigIntToLocaleString";
            if ((state & 0b1) != 0 /* is-active bigIntToLocaleString(BigInt, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "jsBigIntToLocaleString";
            if ((state & 0b10) != 0 /* is-active jsBigIntToLocaleString(DynamicObject, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "failForNonBigInts";
            if ((state & 0b100) != 0 /* is-active failForNonBigInts(Object, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        private static boolean fallbackGuard_(int state, Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            if (((state & 0b1)) == 0 /* is-not-active bigIntToLocaleString(BigInt, Object, Object) */ && arguments0Value instanceof BigInt) {
                return false;
            }
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((JSGuards.isJSBigInt(arguments0Value_))) {
                    return false;
                }
            }
            return true;
        }

        public static JSBigIntToLocaleStringIntlNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSBigIntToLocaleStringIntlNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSBigIntToLocaleStringNode.class)
    public static final class JSBigIntToLocaleStringNodeGen extends JSBigIntToLocaleStringNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private int state_;

        private JSBigIntToLocaleStringNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state & 0b1) != 0 /* is-active toLocaleStringBigInt(BigInt) */ && arguments0Value_ instanceof BigInt) {
                BigInt arguments0Value__ = (BigInt) arguments0Value_;
                return toLocaleStringBigInt(arguments0Value__);
            }
            if ((state & 0b10) != 0 /* is-active toLocaleStringJSBigInt(DynamicObject) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((JSGuards.isJSBigInt(arguments0Value__))) {
                    return toLocaleStringJSBigInt(arguments0Value__);
                }
            }
            if ((state & 0b100) != 0 /* is-active failForNonBigInts(Object) */) {
                if (fallbackGuard_(state, arguments0Value_)) {
                    return failForNonBigInts(arguments0Value_);
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
            if (arguments0Value instanceof BigInt) {
                BigInt arguments0Value_ = (BigInt) arguments0Value;
                this.state_ = state = state | 0b1 /* add-active toLocaleStringBigInt(BigInt) */;
                return toLocaleStringBigInt(arguments0Value_);
            }
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((JSGuards.isJSBigInt(arguments0Value_))) {
                    this.state_ = state = state | 0b10 /* add-active toLocaleStringJSBigInt(DynamicObject) */;
                    return toLocaleStringJSBigInt(arguments0Value_);
                }
            }
            this.state_ = state = state | 0b100 /* add-active failForNonBigInts(Object) */;
            return failForNonBigInts(arguments0Value);
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
            s[0] = "toLocaleStringBigInt";
            if ((state & 0b1) != 0 /* is-active toLocaleStringBigInt(BigInt) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "toLocaleStringJSBigInt";
            if ((state & 0b10) != 0 /* is-active toLocaleStringJSBigInt(DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "failForNonBigInts";
            if ((state & 0b100) != 0 /* is-active failForNonBigInts(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        private static boolean fallbackGuard_(int state, Object arguments0Value) {
            if (((state & 0b1)) == 0 /* is-not-active toLocaleStringBigInt(BigInt) */ && arguments0Value instanceof BigInt) {
                return false;
            }
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((JSGuards.isJSBigInt(arguments0Value_))) {
                    return false;
                }
            }
            return true;
        }

        public static JSBigIntToLocaleStringNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSBigIntToLocaleStringNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSBigIntValueOfNode.class)
    public static final class JSBigIntValueOfNodeGen extends JSBigIntValueOfNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private int state_;

        private JSBigIntValueOfNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state & 0b1) != 0 /* is-active valueOfBigInt(BigInt) */ && arguments0Value_ instanceof BigInt) {
                BigInt arguments0Value__ = (BigInt) arguments0Value_;
                return valueOfBigInt(arguments0Value__);
            }
            if ((state & 0b10) != 0 /* is-active valueOf(DynamicObject) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((JSGuards.isJSBigInt(arguments0Value__))) {
                    return valueOf(arguments0Value__);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            int state = state_;
            if ((state & 0b11) != 0 /* is-active valueOfBigInt(BigInt) || valueOf(DynamicObject) */) {
                execute(frameValue);
                return;
            }
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state & 0b100) != 0 /* is-active valueOf(Object) */) {
                if (fallbackGuard_(state, arguments0Value_)) {
                    valueOf(arguments0Value_);
                    return;
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            executeAndSpecialize(arguments0Value_);
            return;
        }

        private BigInt executeAndSpecialize(Object arguments0Value) {
            int state = state_;
            if (arguments0Value instanceof BigInt) {
                BigInt arguments0Value_ = (BigInt) arguments0Value;
                this.state_ = state = state | 0b1 /* add-active valueOfBigInt(BigInt) */;
                return valueOfBigInt(arguments0Value_);
            }
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((JSGuards.isJSBigInt(arguments0Value_))) {
                    this.state_ = state = state | 0b10 /* add-active valueOf(DynamicObject) */;
                    return valueOf(arguments0Value_);
                }
            }
            this.state_ = state = state | 0b100 /* add-active valueOf(Object) */;
            valueOf(arguments0Value);
            return null;
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
            s[0] = "valueOfBigInt";
            if ((state & 0b1) != 0 /* is-active valueOfBigInt(BigInt) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "valueOf";
            if ((state & 0b10) != 0 /* is-active valueOf(DynamicObject) */) {
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

        private static boolean fallbackGuard_(int state, Object arguments0Value) {
            if (((state & 0b1)) == 0 /* is-not-active valueOfBigInt(BigInt) */ && arguments0Value instanceof BigInt) {
                return false;
            }
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((JSGuards.isJSBigInt(arguments0Value_))) {
                    return false;
                }
            }
            return true;
        }

        public static JSBigIntValueOfNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSBigIntValueOfNodeGen(context, builtin, arguments);
        }

    }
}
