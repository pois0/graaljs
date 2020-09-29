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
import com.oracle.truffle.js.builtins.NumberFunctionBuiltins.JSNumberIsFiniteNode;
import com.oracle.truffle.js.builtins.NumberFunctionBuiltins.JSNumberIsIntegerNode;
import com.oracle.truffle.js.builtins.NumberFunctionBuiltins.JSNumberIsNaNNode;
import com.oracle.truffle.js.builtins.NumberFunctionBuiltins.JSNumberIsSafeIntegerNode;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSContext;

@GeneratedBy(NumberFunctionBuiltins.class)
public final class NumberFunctionBuiltinsFactory {

    @GeneratedBy(JSNumberIsNaNNode.class)
    public static final class JSNumberIsNaNNodeGen extends JSNumberIsNaNNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private int state_;

        private JSNumberIsNaNNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state & 0b1) == 0 /* only-active isNaNDouble(double) */ && (state & 0b11) != 0  /* is-not isNaNNotDouble(Object) && isNaNDouble(double) */) {
                return execute_double0(frameValue, state);
            } else {
                return execute_generic1(frameValue, state);
            }
        }

        private Object execute_double0(VirtualFrame frameValue, int state) {
            int arguments0Value_int = 0;
            long arguments0Value_long = 0L;
            double arguments0Value_;
            try {
                if ((state & 0b111000) == 0 /* only-active 0:double */ && (state & 0b11) != 0  /* is-not isNaNNotDouble(Object) && isNaNDouble(double) */) {
                    arguments0Value_long = this.arguments0_.executeLong(frameValue);
                    arguments0Value_ = JSTypes.longToDouble(arguments0Value_long);
                } else if ((state & 0b110100) == 0 /* only-active 0:double */ && (state & 0b11) != 0  /* is-not isNaNNotDouble(Object) && isNaNDouble(double) */) {
                    arguments0Value_int = this.arguments0_.executeInt(frameValue);
                    arguments0Value_ = JSTypes.intToDouble(arguments0Value_int);
                } else if ((state & 0b101100) == 0 /* only-active 0:double */ && (state & 0b11) != 0  /* is-not isNaNNotDouble(Object) && isNaNDouble(double) */) {
                    arguments0Value_ = this.arguments0_.executeDouble(frameValue);
                } else {
                    Object arguments0Value__ = this.arguments0_.execute(frameValue);
                    arguments0Value_ = JSTypesGen.expectImplicitDouble((state & 0b111100) >>> 2 /* extract-implicit-active 0:double */, arguments0Value__);
                }
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(ex.getResult());
            }
            assert (state & 0b10) != 0 /* is-active isNaNDouble(double) */;
            return isNaNDouble(arguments0Value_);
        }

        private Object execute_generic1(VirtualFrame frameValue, int state) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state & 0b1) != 0 /* is-active isNaNNotDouble(Object) */) {
                if ((!(isDouble(arguments0Value_)))) {
                    return isNaNNotDouble(arguments0Value_);
                }
            }
            if ((state & 0b10) != 0 /* is-active isNaNDouble(double) */ && JSTypesGen.isImplicitDouble((state & 0b111100) >>> 2 /* extract-implicit-active 0:double */, arguments0Value_)) {
                double arguments0Value__ = JSTypesGen.asImplicitDouble((state & 0b111100) >>> 2 /* extract-implicit-active 0:double */, arguments0Value_);
                return isNaNDouble(arguments0Value__);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            int state = state_;
            if ((state & 0b1) == 0 /* only-active isNaNDouble(double) */ && (state & 0b11) != 0  /* is-not isNaNNotDouble(Object) && isNaNDouble(double) */) {
                return executeBoolean_double2(frameValue, state);
            } else {
                return executeBoolean_generic3(frameValue, state);
            }
        }

        private boolean executeBoolean_double2(VirtualFrame frameValue, int state) {
            int arguments0Value_int = 0;
            long arguments0Value_long = 0L;
            double arguments0Value_;
            try {
                if ((state & 0b111000) == 0 /* only-active 0:double */ && (state & 0b11) != 0  /* is-not isNaNNotDouble(Object) && isNaNDouble(double) */) {
                    arguments0Value_long = this.arguments0_.executeLong(frameValue);
                    arguments0Value_ = JSTypes.longToDouble(arguments0Value_long);
                } else if ((state & 0b110100) == 0 /* only-active 0:double */ && (state & 0b11) != 0  /* is-not isNaNNotDouble(Object) && isNaNDouble(double) */) {
                    arguments0Value_int = this.arguments0_.executeInt(frameValue);
                    arguments0Value_ = JSTypes.intToDouble(arguments0Value_int);
                } else if ((state & 0b101100) == 0 /* only-active 0:double */ && (state & 0b11) != 0  /* is-not isNaNNotDouble(Object) && isNaNDouble(double) */) {
                    arguments0Value_ = this.arguments0_.executeDouble(frameValue);
                } else {
                    Object arguments0Value__ = this.arguments0_.execute(frameValue);
                    arguments0Value_ = JSTypesGen.expectImplicitDouble((state & 0b111100) >>> 2 /* extract-implicit-active 0:double */, arguments0Value__);
                }
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(ex.getResult());
            }
            assert (state & 0b10) != 0 /* is-active isNaNDouble(double) */;
            return isNaNDouble(arguments0Value_);
        }

        private boolean executeBoolean_generic3(VirtualFrame frameValue, int state) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state & 0b1) != 0 /* is-active isNaNNotDouble(Object) */) {
                if ((!(isDouble(arguments0Value_)))) {
                    return isNaNNotDouble(arguments0Value_);
                }
            }
            if ((state & 0b10) != 0 /* is-active isNaNDouble(double) */ && JSTypesGen.isImplicitDouble((state & 0b111100) >>> 2 /* extract-implicit-active 0:double */, arguments0Value_)) {
                double arguments0Value__ = JSTypesGen.asImplicitDouble((state & 0b111100) >>> 2 /* extract-implicit-active 0:double */, arguments0Value_);
                return isNaNDouble(arguments0Value__);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            executeBoolean(frameValue);
            return;
        }

        private boolean executeAndSpecialize(Object arguments0Value) {
            int state = state_;
            if ((!(isDouble(arguments0Value)))) {
                this.state_ = state = state | 0b1 /* add-active isNaNNotDouble(Object) */;
                return isNaNNotDouble(arguments0Value);
            }
            {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(arguments0Value)) != 0) {
                    double arguments0Value_ = JSTypesGen.asImplicitDouble(doubleCast0, arguments0Value);
                    state = (state | (doubleCast0 << 2) /* set-implicit-active 0:double */);
                    this.state_ = state = state | 0b10 /* add-active isNaNDouble(double) */;
                    return isNaNDouble(arguments0Value_);
                }
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_}, arguments0Value);
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
            s[0] = "isNaNNotDouble";
            if ((state & 0b1) != 0 /* is-active isNaNNotDouble(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "isNaNDouble";
            if ((state & 0b10) != 0 /* is-active isNaNDouble(double) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static JSNumberIsNaNNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSNumberIsNaNNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSNumberIsFiniteNode.class)
    public static final class JSNumberIsFiniteNodeGen extends JSNumberIsFiniteNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private int state_;

        private JSNumberIsFiniteNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state & 0b110) == 0 /* only-active isFinite(int) */ && (state & 0b111) != 0  /* is-not isFinite(int) && isFinite(double) && isFinite(Object) */) {
                return execute_int0(frameValue, state);
            } else if ((state & 0b101) == 0 /* only-active isFinite(double) */ && (state & 0b111) != 0  /* is-not isFinite(int) && isFinite(double) && isFinite(Object) */) {
                return execute_double1(frameValue, state);
            } else {
                return execute_generic2(frameValue, state);
            }
        }

        private Object execute_int0(VirtualFrame frameValue, int state) {
            int arguments0Value_;
            try {
                arguments0Value_ = this.arguments0_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(ex.getResult());
            }
            assert (state & 0b1) != 0 /* is-active isFinite(int) */;
            return isFinite(arguments0Value_);
        }

        private Object execute_double1(VirtualFrame frameValue, int state) {
            int arguments0Value_int = 0;
            long arguments0Value_long = 0L;
            double arguments0Value_;
            try {
                if ((state & 0b1110000) == 0 /* only-active 0:double */ && (state & 0b111) != 0  /* is-not isFinite(int) && isFinite(double) && isFinite(Object) */) {
                    arguments0Value_long = this.arguments0_.executeLong(frameValue);
                    arguments0Value_ = JSTypes.longToDouble(arguments0Value_long);
                } else if ((state & 0b1101000) == 0 /* only-active 0:double */ && (state & 0b111) != 0  /* is-not isFinite(int) && isFinite(double) && isFinite(Object) */) {
                    arguments0Value_int = this.arguments0_.executeInt(frameValue);
                    arguments0Value_ = JSTypes.intToDouble(arguments0Value_int);
                } else if ((state & 0b1011000) == 0 /* only-active 0:double */ && (state & 0b111) != 0  /* is-not isFinite(int) && isFinite(double) && isFinite(Object) */) {
                    arguments0Value_ = this.arguments0_.executeDouble(frameValue);
                } else {
                    Object arguments0Value__ = this.arguments0_.execute(frameValue);
                    arguments0Value_ = JSTypesGen.expectImplicitDouble((state & 0b1111000) >>> 3 /* extract-implicit-active 0:double */, arguments0Value__);
                }
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(ex.getResult());
            }
            assert (state & 0b10) != 0 /* is-active isFinite(double) */;
            return isFinite(arguments0Value_);
        }

        private Object execute_generic2(VirtualFrame frameValue, int state) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state & 0b1) != 0 /* is-active isFinite(int) */ && arguments0Value_ instanceof Integer) {
                int arguments0Value__ = (int) arguments0Value_;
                return isFinite(arguments0Value__);
            }
            if ((state & 0b10) != 0 /* is-active isFinite(double) */ && JSTypesGen.isImplicitDouble((state & 0b1111000) >>> 3 /* extract-implicit-active 0:double */, arguments0Value_)) {
                double arguments0Value__ = JSTypesGen.asImplicitDouble((state & 0b1111000) >>> 3 /* extract-implicit-active 0:double */, arguments0Value_);
                return isFinite(arguments0Value__);
            }
            if ((state & 0b100) != 0 /* is-active isFinite(Object) */) {
                if ((!(JSGuards.isNumber(arguments0Value_)))) {
                    return isFinite(arguments0Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            int state = state_;
            if ((state & 0b110) == 0 /* only-active isFinite(int) */ && (state & 0b111) != 0  /* is-not isFinite(int) && isFinite(double) && isFinite(Object) */) {
                return executeBoolean_int3(frameValue, state);
            } else if ((state & 0b101) == 0 /* only-active isFinite(double) */ && (state & 0b111) != 0  /* is-not isFinite(int) && isFinite(double) && isFinite(Object) */) {
                return executeBoolean_double4(frameValue, state);
            } else {
                return executeBoolean_generic5(frameValue, state);
            }
        }

        private boolean executeBoolean_int3(VirtualFrame frameValue, int state) {
            int arguments0Value_;
            try {
                arguments0Value_ = this.arguments0_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(ex.getResult());
            }
            assert (state & 0b1) != 0 /* is-active isFinite(int) */;
            return isFinite(arguments0Value_);
        }

        private boolean executeBoolean_double4(VirtualFrame frameValue, int state) {
            int arguments0Value_int = 0;
            long arguments0Value_long = 0L;
            double arguments0Value_;
            try {
                if ((state & 0b1110000) == 0 /* only-active 0:double */ && (state & 0b111) != 0  /* is-not isFinite(int) && isFinite(double) && isFinite(Object) */) {
                    arguments0Value_long = this.arguments0_.executeLong(frameValue);
                    arguments0Value_ = JSTypes.longToDouble(arguments0Value_long);
                } else if ((state & 0b1101000) == 0 /* only-active 0:double */ && (state & 0b111) != 0  /* is-not isFinite(int) && isFinite(double) && isFinite(Object) */) {
                    arguments0Value_int = this.arguments0_.executeInt(frameValue);
                    arguments0Value_ = JSTypes.intToDouble(arguments0Value_int);
                } else if ((state & 0b1011000) == 0 /* only-active 0:double */ && (state & 0b111) != 0  /* is-not isFinite(int) && isFinite(double) && isFinite(Object) */) {
                    arguments0Value_ = this.arguments0_.executeDouble(frameValue);
                } else {
                    Object arguments0Value__ = this.arguments0_.execute(frameValue);
                    arguments0Value_ = JSTypesGen.expectImplicitDouble((state & 0b1111000) >>> 3 /* extract-implicit-active 0:double */, arguments0Value__);
                }
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(ex.getResult());
            }
            assert (state & 0b10) != 0 /* is-active isFinite(double) */;
            return isFinite(arguments0Value_);
        }

        private boolean executeBoolean_generic5(VirtualFrame frameValue, int state) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state & 0b1) != 0 /* is-active isFinite(int) */ && arguments0Value_ instanceof Integer) {
                int arguments0Value__ = (int) arguments0Value_;
                return isFinite(arguments0Value__);
            }
            if ((state & 0b10) != 0 /* is-active isFinite(double) */ && JSTypesGen.isImplicitDouble((state & 0b1111000) >>> 3 /* extract-implicit-active 0:double */, arguments0Value_)) {
                double arguments0Value__ = JSTypesGen.asImplicitDouble((state & 0b1111000) >>> 3 /* extract-implicit-active 0:double */, arguments0Value_);
                return isFinite(arguments0Value__);
            }
            if ((state & 0b100) != 0 /* is-active isFinite(Object) */) {
                if ((!(JSGuards.isNumber(arguments0Value_)))) {
                    return isFinite(arguments0Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            executeBoolean(frameValue);
            return;
        }

        private boolean executeAndSpecialize(Object arguments0Value) {
            int state = state_;
            if (arguments0Value instanceof Integer) {
                int arguments0Value_ = (int) arguments0Value;
                this.state_ = state = state | 0b1 /* add-active isFinite(int) */;
                return isFinite(arguments0Value_);
            }
            {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(arguments0Value)) != 0) {
                    double arguments0Value_ = JSTypesGen.asImplicitDouble(doubleCast0, arguments0Value);
                    state = (state | (doubleCast0 << 3) /* set-implicit-active 0:double */);
                    this.state_ = state = state | 0b10 /* add-active isFinite(double) */;
                    return isFinite(arguments0Value_);
                }
            }
            if ((!(JSGuards.isNumber(arguments0Value)))) {
                this.state_ = state = state | 0b100 /* add-active isFinite(Object) */;
                return isFinite(arguments0Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_}, arguments0Value);
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
            s[0] = "isFinite";
            if ((state & 0b1) != 0 /* is-active isFinite(int) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "isFinite";
            if ((state & 0b10) != 0 /* is-active isFinite(double) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "isFinite";
            if ((state & 0b100) != 0 /* is-active isFinite(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static JSNumberIsFiniteNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSNumberIsFiniteNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSNumberIsIntegerNode.class)
    public static final class JSNumberIsIntegerNodeGen extends JSNumberIsIntegerNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private int state_;

        private JSNumberIsIntegerNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state & 0b110) == 0 /* only-active isInteger(int) */ && (state & 0b111) != 0  /* is-not isInteger(int) && isInteger(double) && isInteger(Object) */) {
                return execute_int0(frameValue, state);
            } else if ((state & 0b101) == 0 /* only-active isInteger(double) */ && (state & 0b111) != 0  /* is-not isInteger(int) && isInteger(double) && isInteger(Object) */) {
                return execute_double1(frameValue, state);
            } else {
                return execute_generic2(frameValue, state);
            }
        }

        private Object execute_int0(VirtualFrame frameValue, int state) {
            int arguments0Value_;
            try {
                arguments0Value_ = this.arguments0_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(ex.getResult());
            }
            assert (state & 0b1) != 0 /* is-active isInteger(int) */;
            return isInteger(arguments0Value_);
        }

        private Object execute_double1(VirtualFrame frameValue, int state) {
            int arguments0Value_int = 0;
            long arguments0Value_long = 0L;
            double arguments0Value_;
            try {
                if ((state & 0b1110000) == 0 /* only-active 0:double */ && (state & 0b111) != 0  /* is-not isInteger(int) && isInteger(double) && isInteger(Object) */) {
                    arguments0Value_long = this.arguments0_.executeLong(frameValue);
                    arguments0Value_ = JSTypes.longToDouble(arguments0Value_long);
                } else if ((state & 0b1101000) == 0 /* only-active 0:double */ && (state & 0b111) != 0  /* is-not isInteger(int) && isInteger(double) && isInteger(Object) */) {
                    arguments0Value_int = this.arguments0_.executeInt(frameValue);
                    arguments0Value_ = JSTypes.intToDouble(arguments0Value_int);
                } else if ((state & 0b1011000) == 0 /* only-active 0:double */ && (state & 0b111) != 0  /* is-not isInteger(int) && isInteger(double) && isInteger(Object) */) {
                    arguments0Value_ = this.arguments0_.executeDouble(frameValue);
                } else {
                    Object arguments0Value__ = this.arguments0_.execute(frameValue);
                    arguments0Value_ = JSTypesGen.expectImplicitDouble((state & 0b1111000) >>> 3 /* extract-implicit-active 0:double */, arguments0Value__);
                }
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(ex.getResult());
            }
            assert (state & 0b10) != 0 /* is-active isInteger(double) */;
            return isInteger(arguments0Value_);
        }

        private Object execute_generic2(VirtualFrame frameValue, int state) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state & 0b1) != 0 /* is-active isInteger(int) */ && arguments0Value_ instanceof Integer) {
                int arguments0Value__ = (int) arguments0Value_;
                return isInteger(arguments0Value__);
            }
            if ((state & 0b10) != 0 /* is-active isInteger(double) */ && JSTypesGen.isImplicitDouble((state & 0b1111000) >>> 3 /* extract-implicit-active 0:double */, arguments0Value_)) {
                double arguments0Value__ = JSTypesGen.asImplicitDouble((state & 0b1111000) >>> 3 /* extract-implicit-active 0:double */, arguments0Value_);
                return isInteger(arguments0Value__);
            }
            if ((state & 0b100) != 0 /* is-active isInteger(Object) */) {
                if ((!(JSGuards.isNumber(arguments0Value_)))) {
                    return isInteger(arguments0Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            int state = state_;
            if ((state & 0b110) == 0 /* only-active isInteger(int) */ && (state & 0b111) != 0  /* is-not isInteger(int) && isInteger(double) && isInteger(Object) */) {
                return executeBoolean_int3(frameValue, state);
            } else if ((state & 0b101) == 0 /* only-active isInteger(double) */ && (state & 0b111) != 0  /* is-not isInteger(int) && isInteger(double) && isInteger(Object) */) {
                return executeBoolean_double4(frameValue, state);
            } else {
                return executeBoolean_generic5(frameValue, state);
            }
        }

        private boolean executeBoolean_int3(VirtualFrame frameValue, int state) {
            int arguments0Value_;
            try {
                arguments0Value_ = this.arguments0_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(ex.getResult());
            }
            assert (state & 0b1) != 0 /* is-active isInteger(int) */;
            return isInteger(arguments0Value_);
        }

        private boolean executeBoolean_double4(VirtualFrame frameValue, int state) {
            int arguments0Value_int = 0;
            long arguments0Value_long = 0L;
            double arguments0Value_;
            try {
                if ((state & 0b1110000) == 0 /* only-active 0:double */ && (state & 0b111) != 0  /* is-not isInteger(int) && isInteger(double) && isInteger(Object) */) {
                    arguments0Value_long = this.arguments0_.executeLong(frameValue);
                    arguments0Value_ = JSTypes.longToDouble(arguments0Value_long);
                } else if ((state & 0b1101000) == 0 /* only-active 0:double */ && (state & 0b111) != 0  /* is-not isInteger(int) && isInteger(double) && isInteger(Object) */) {
                    arguments0Value_int = this.arguments0_.executeInt(frameValue);
                    arguments0Value_ = JSTypes.intToDouble(arguments0Value_int);
                } else if ((state & 0b1011000) == 0 /* only-active 0:double */ && (state & 0b111) != 0  /* is-not isInteger(int) && isInteger(double) && isInteger(Object) */) {
                    arguments0Value_ = this.arguments0_.executeDouble(frameValue);
                } else {
                    Object arguments0Value__ = this.arguments0_.execute(frameValue);
                    arguments0Value_ = JSTypesGen.expectImplicitDouble((state & 0b1111000) >>> 3 /* extract-implicit-active 0:double */, arguments0Value__);
                }
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(ex.getResult());
            }
            assert (state & 0b10) != 0 /* is-active isInteger(double) */;
            return isInteger(arguments0Value_);
        }

        private boolean executeBoolean_generic5(VirtualFrame frameValue, int state) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state & 0b1) != 0 /* is-active isInteger(int) */ && arguments0Value_ instanceof Integer) {
                int arguments0Value__ = (int) arguments0Value_;
                return isInteger(arguments0Value__);
            }
            if ((state & 0b10) != 0 /* is-active isInteger(double) */ && JSTypesGen.isImplicitDouble((state & 0b1111000) >>> 3 /* extract-implicit-active 0:double */, arguments0Value_)) {
                double arguments0Value__ = JSTypesGen.asImplicitDouble((state & 0b1111000) >>> 3 /* extract-implicit-active 0:double */, arguments0Value_);
                return isInteger(arguments0Value__);
            }
            if ((state & 0b100) != 0 /* is-active isInteger(Object) */) {
                if ((!(JSGuards.isNumber(arguments0Value_)))) {
                    return isInteger(arguments0Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            executeBoolean(frameValue);
            return;
        }

        private boolean executeAndSpecialize(Object arguments0Value) {
            int state = state_;
            if (arguments0Value instanceof Integer) {
                int arguments0Value_ = (int) arguments0Value;
                this.state_ = state = state | 0b1 /* add-active isInteger(int) */;
                return isInteger(arguments0Value_);
            }
            {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(arguments0Value)) != 0) {
                    double arguments0Value_ = JSTypesGen.asImplicitDouble(doubleCast0, arguments0Value);
                    state = (state | (doubleCast0 << 3) /* set-implicit-active 0:double */);
                    this.state_ = state = state | 0b10 /* add-active isInteger(double) */;
                    return isInteger(arguments0Value_);
                }
            }
            if ((!(JSGuards.isNumber(arguments0Value)))) {
                this.state_ = state = state | 0b100 /* add-active isInteger(Object) */;
                return isInteger(arguments0Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_}, arguments0Value);
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
            s[0] = "isInteger";
            if ((state & 0b1) != 0 /* is-active isInteger(int) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "isInteger";
            if ((state & 0b10) != 0 /* is-active isInteger(double) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "isInteger";
            if ((state & 0b100) != 0 /* is-active isInteger(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static JSNumberIsIntegerNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSNumberIsIntegerNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSNumberIsSafeIntegerNode.class)
    public static final class JSNumberIsSafeIntegerNodeGen extends JSNumberIsSafeIntegerNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private int state_;

        private JSNumberIsSafeIntegerNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state & 0b110) == 0 /* only-active isSafeIntegerInt(int) */ && (state & 0b111) != 0  /* is-not isSafeIntegerInt(int) && isSafeIntegerDouble(double) && isSafeIntegerNotANumber(Object) */) {
                return execute_int0(frameValue, state);
            } else if ((state & 0b101) == 0 /* only-active isSafeIntegerDouble(double) */ && (state & 0b111) != 0  /* is-not isSafeIntegerInt(int) && isSafeIntegerDouble(double) && isSafeIntegerNotANumber(Object) */) {
                return execute_double1(frameValue, state);
            } else {
                return execute_generic2(frameValue, state);
            }
        }

        private Object execute_int0(VirtualFrame frameValue, int state) {
            int arguments0Value_;
            try {
                arguments0Value_ = this.arguments0_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(ex.getResult());
            }
            assert (state & 0b1) != 0 /* is-active isSafeIntegerInt(int) */;
            return isSafeIntegerInt(arguments0Value_);
        }

        private Object execute_double1(VirtualFrame frameValue, int state) {
            int arguments0Value_int = 0;
            long arguments0Value_long = 0L;
            double arguments0Value_;
            try {
                if ((state & 0b1110000) == 0 /* only-active 0:double */ && (state & 0b111) != 0  /* is-not isSafeIntegerInt(int) && isSafeIntegerDouble(double) && isSafeIntegerNotANumber(Object) */) {
                    arguments0Value_long = this.arguments0_.executeLong(frameValue);
                    arguments0Value_ = JSTypes.longToDouble(arguments0Value_long);
                } else if ((state & 0b1101000) == 0 /* only-active 0:double */ && (state & 0b111) != 0  /* is-not isSafeIntegerInt(int) && isSafeIntegerDouble(double) && isSafeIntegerNotANumber(Object) */) {
                    arguments0Value_int = this.arguments0_.executeInt(frameValue);
                    arguments0Value_ = JSTypes.intToDouble(arguments0Value_int);
                } else if ((state & 0b1011000) == 0 /* only-active 0:double */ && (state & 0b111) != 0  /* is-not isSafeIntegerInt(int) && isSafeIntegerDouble(double) && isSafeIntegerNotANumber(Object) */) {
                    arguments0Value_ = this.arguments0_.executeDouble(frameValue);
                } else {
                    Object arguments0Value__ = this.arguments0_.execute(frameValue);
                    arguments0Value_ = JSTypesGen.expectImplicitDouble((state & 0b1111000) >>> 3 /* extract-implicit-active 0:double */, arguments0Value__);
                }
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(ex.getResult());
            }
            assert (state & 0b10) != 0 /* is-active isSafeIntegerDouble(double) */;
            return isSafeIntegerDouble(arguments0Value_);
        }

        private Object execute_generic2(VirtualFrame frameValue, int state) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state & 0b1) != 0 /* is-active isSafeIntegerInt(int) */ && arguments0Value_ instanceof Integer) {
                int arguments0Value__ = (int) arguments0Value_;
                return isSafeIntegerInt(arguments0Value__);
            }
            if ((state & 0b10) != 0 /* is-active isSafeIntegerDouble(double) */ && JSTypesGen.isImplicitDouble((state & 0b1111000) >>> 3 /* extract-implicit-active 0:double */, arguments0Value_)) {
                double arguments0Value__ = JSTypesGen.asImplicitDouble((state & 0b1111000) >>> 3 /* extract-implicit-active 0:double */, arguments0Value_);
                return isSafeIntegerDouble(arguments0Value__);
            }
            if ((state & 0b100) != 0 /* is-active isSafeIntegerNotANumber(Object) */) {
                if ((!(JSGuards.isNumber(arguments0Value_)))) {
                    return isSafeIntegerNotANumber(arguments0Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            int state = state_;
            if ((state & 0b110) == 0 /* only-active isSafeIntegerInt(int) */ && (state & 0b111) != 0  /* is-not isSafeIntegerInt(int) && isSafeIntegerDouble(double) && isSafeIntegerNotANumber(Object) */) {
                return executeBoolean_int3(frameValue, state);
            } else if ((state & 0b101) == 0 /* only-active isSafeIntegerDouble(double) */ && (state & 0b111) != 0  /* is-not isSafeIntegerInt(int) && isSafeIntegerDouble(double) && isSafeIntegerNotANumber(Object) */) {
                return executeBoolean_double4(frameValue, state);
            } else {
                return executeBoolean_generic5(frameValue, state);
            }
        }

        private boolean executeBoolean_int3(VirtualFrame frameValue, int state) {
            int arguments0Value_;
            try {
                arguments0Value_ = this.arguments0_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(ex.getResult());
            }
            assert (state & 0b1) != 0 /* is-active isSafeIntegerInt(int) */;
            return isSafeIntegerInt(arguments0Value_);
        }

        private boolean executeBoolean_double4(VirtualFrame frameValue, int state) {
            int arguments0Value_int = 0;
            long arguments0Value_long = 0L;
            double arguments0Value_;
            try {
                if ((state & 0b1110000) == 0 /* only-active 0:double */ && (state & 0b111) != 0  /* is-not isSafeIntegerInt(int) && isSafeIntegerDouble(double) && isSafeIntegerNotANumber(Object) */) {
                    arguments0Value_long = this.arguments0_.executeLong(frameValue);
                    arguments0Value_ = JSTypes.longToDouble(arguments0Value_long);
                } else if ((state & 0b1101000) == 0 /* only-active 0:double */ && (state & 0b111) != 0  /* is-not isSafeIntegerInt(int) && isSafeIntegerDouble(double) && isSafeIntegerNotANumber(Object) */) {
                    arguments0Value_int = this.arguments0_.executeInt(frameValue);
                    arguments0Value_ = JSTypes.intToDouble(arguments0Value_int);
                } else if ((state & 0b1011000) == 0 /* only-active 0:double */ && (state & 0b111) != 0  /* is-not isSafeIntegerInt(int) && isSafeIntegerDouble(double) && isSafeIntegerNotANumber(Object) */) {
                    arguments0Value_ = this.arguments0_.executeDouble(frameValue);
                } else {
                    Object arguments0Value__ = this.arguments0_.execute(frameValue);
                    arguments0Value_ = JSTypesGen.expectImplicitDouble((state & 0b1111000) >>> 3 /* extract-implicit-active 0:double */, arguments0Value__);
                }
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(ex.getResult());
            }
            assert (state & 0b10) != 0 /* is-active isSafeIntegerDouble(double) */;
            return isSafeIntegerDouble(arguments0Value_);
        }

        private boolean executeBoolean_generic5(VirtualFrame frameValue, int state) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state & 0b1) != 0 /* is-active isSafeIntegerInt(int) */ && arguments0Value_ instanceof Integer) {
                int arguments0Value__ = (int) arguments0Value_;
                return isSafeIntegerInt(arguments0Value__);
            }
            if ((state & 0b10) != 0 /* is-active isSafeIntegerDouble(double) */ && JSTypesGen.isImplicitDouble((state & 0b1111000) >>> 3 /* extract-implicit-active 0:double */, arguments0Value_)) {
                double arguments0Value__ = JSTypesGen.asImplicitDouble((state & 0b1111000) >>> 3 /* extract-implicit-active 0:double */, arguments0Value_);
                return isSafeIntegerDouble(arguments0Value__);
            }
            if ((state & 0b100) != 0 /* is-active isSafeIntegerNotANumber(Object) */) {
                if ((!(JSGuards.isNumber(arguments0Value_)))) {
                    return isSafeIntegerNotANumber(arguments0Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            executeBoolean(frameValue);
            return;
        }

        private boolean executeAndSpecialize(Object arguments0Value) {
            int state = state_;
            if (arguments0Value instanceof Integer) {
                int arguments0Value_ = (int) arguments0Value;
                this.state_ = state = state | 0b1 /* add-active isSafeIntegerInt(int) */;
                return isSafeIntegerInt(arguments0Value_);
            }
            {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(arguments0Value)) != 0) {
                    double arguments0Value_ = JSTypesGen.asImplicitDouble(doubleCast0, arguments0Value);
                    state = (state | (doubleCast0 << 3) /* set-implicit-active 0:double */);
                    this.state_ = state = state | 0b10 /* add-active isSafeIntegerDouble(double) */;
                    return isSafeIntegerDouble(arguments0Value_);
                }
            }
            if ((!(JSGuards.isNumber(arguments0Value)))) {
                this.state_ = state = state | 0b100 /* add-active isSafeIntegerNotANumber(Object) */;
                return isSafeIntegerNotANumber(arguments0Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_}, arguments0Value);
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
            s[0] = "isSafeIntegerInt";
            if ((state & 0b1) != 0 /* is-active isSafeIntegerInt(int) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "isSafeIntegerDouble";
            if ((state & 0b10) != 0 /* is-active isSafeIntegerDouble(double) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "isSafeIntegerNotANumber";
            if ((state & 0b100) != 0 /* is-active isSafeIntegerNotANumber(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static JSNumberIsSafeIntegerNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSNumberIsSafeIntegerNodeGen(context, builtin, arguments);
        }

    }
}
