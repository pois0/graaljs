// CheckStyle: start generated
package com.oracle.truffle.js.builtins;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.TruffleObject;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.EncapsulatingNodeReference;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.js.builtins.GlobalBuiltins.GlobalNashornExtensionParseToJSONNode;
import com.oracle.truffle.js.builtins.GlobalBuiltins.GlobalScriptingEXECNode;
import com.oracle.truffle.js.builtins.GlobalBuiltins.JSGlobalDecodeURINode;
import com.oracle.truffle.js.builtins.GlobalBuiltins.JSGlobalEncodeURINode;
import com.oracle.truffle.js.builtins.GlobalBuiltins.JSGlobalExitNode;
import com.oracle.truffle.js.builtins.GlobalBuiltins.JSGlobalImportScriptEngineGlobalBindingsNode;
import com.oracle.truffle.js.builtins.GlobalBuiltins.JSGlobalIndirectEvalNode;
import com.oracle.truffle.js.builtins.GlobalBuiltins.JSGlobalIsFiniteNode;
import com.oracle.truffle.js.builtins.GlobalBuiltins.JSGlobalIsNaNNode;
import com.oracle.truffle.js.builtins.GlobalBuiltins.JSGlobalLoadNode;
import com.oracle.truffle.js.builtins.GlobalBuiltins.JSGlobalLoadWithNewGlobalNode;
import com.oracle.truffle.js.builtins.GlobalBuiltins.JSGlobalParseFloatNode;
import com.oracle.truffle.js.builtins.GlobalBuiltins.JSGlobalParseIntNode;
import com.oracle.truffle.js.builtins.GlobalBuiltins.JSGlobalPrintNode;
import com.oracle.truffle.js.builtins.GlobalBuiltins.JSGlobalReadBufferNode;
import com.oracle.truffle.js.builtins.GlobalBuiltins.JSGlobalReadFullyNode;
import com.oracle.truffle.js.builtins.GlobalBuiltins.JSGlobalReadLineNode;
import com.oracle.truffle.js.builtins.GlobalBuiltins.JSGlobalUnEscapeNode;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.cast.JSToDoubleNode;
import com.oracle.truffle.js.nodes.cast.JSToNumberNode;
import com.oracle.truffle.js.nodes.cast.JSToStringNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.BigInt;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.SafeInteger;
import com.oracle.truffle.js.runtime.Symbol;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(GlobalBuiltins.class)
@SuppressWarnings("unused")
public final class GlobalBuiltinsFactory {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @GeneratedBy(GlobalNashornExtensionParseToJSONNode.class)
    public static final class GlobalNashornExtensionParseToJSONNodeGen extends GlobalNashornExtensionParseToJSONNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;

        private GlobalNashornExtensionParseToJSONNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            return parseToJSON(arguments0Value_, arguments1Value_, arguments2Value_);
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
            s[0] = "parseToJSON";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static GlobalNashornExtensionParseToJSONNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new GlobalNashornExtensionParseToJSONNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(GlobalScriptingEXECNode.class)
    public static final class GlobalScriptingEXECNodeGen extends GlobalScriptingEXECNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;

        private GlobalScriptingEXECNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            return exec(arguments0Value_, arguments1Value_);
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
            s[0] = "exec";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static GlobalScriptingEXECNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new GlobalScriptingEXECNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSGlobalIsNaNNode.class)
    public static final class JSGlobalIsNaNNodeGen extends JSGlobalIsNaNNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_;
        @Child private JSToDoubleNode isNaNGeneric_toDoubleNode_;

        private JSGlobalIsNaNNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state & 0b1110) == 0 /* only-active isNaNInt(int) */ && (state & 0b1111) != 0  /* is-not isNaNInt(int) && isNaNDouble(double) && isNaNGeneric(Object, JSToDoubleNode) && isNaNUndefined(Object) */) {
                return execute_int0(frameValue, state);
            } else if ((state & 0b1101) == 0 /* only-active isNaNDouble(double) */ && (state & 0b1111) != 0  /* is-not isNaNInt(int) && isNaNDouble(double) && isNaNGeneric(Object, JSToDoubleNode) && isNaNUndefined(Object) */) {
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
            assert (state & 0b1) != 0 /* is-active isNaNInt(int) */;
            return JSGlobalIsNaNNode.isNaNInt(arguments0Value_);
        }

        private Object execute_double1(VirtualFrame frameValue, int state) {
            int arguments0Value_int = 0;
            long arguments0Value_long = 0L;
            double arguments0Value_;
            try {
                if ((state & 0b11100000) == 0 /* only-active 0:double */ && (state & 0b1111) != 0  /* is-not isNaNInt(int) && isNaNDouble(double) && isNaNGeneric(Object, JSToDoubleNode) && isNaNUndefined(Object) */) {
                    arguments0Value_long = this.arguments0_.executeLong(frameValue);
                    arguments0Value_ = JSTypes.longToDouble(arguments0Value_long);
                } else if ((state & 0b11010000) == 0 /* only-active 0:double */ && (state & 0b1111) != 0  /* is-not isNaNInt(int) && isNaNDouble(double) && isNaNGeneric(Object, JSToDoubleNode) && isNaNUndefined(Object) */) {
                    arguments0Value_int = this.arguments0_.executeInt(frameValue);
                    arguments0Value_ = JSTypes.intToDouble(arguments0Value_int);
                } else if ((state & 0b10110000) == 0 /* only-active 0:double */ && (state & 0b1111) != 0  /* is-not isNaNInt(int) && isNaNDouble(double) && isNaNGeneric(Object, JSToDoubleNode) && isNaNUndefined(Object) */) {
                    arguments0Value_ = this.arguments0_.executeDouble(frameValue);
                } else {
                    Object arguments0Value__ = this.arguments0_.execute(frameValue);
                    arguments0Value_ = JSTypesGen.expectImplicitDouble((state & 0b11110000) >>> 4 /* extract-implicit-active 0:double */, arguments0Value__);
                }
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(ex.getResult());
            }
            assert (state & 0b10) != 0 /* is-active isNaNDouble(double) */;
            return JSGlobalIsNaNNode.isNaNDouble(arguments0Value_);
        }

        private Object execute_generic2(VirtualFrame frameValue, int state) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state & 0b1) != 0 /* is-active isNaNInt(int) */ && arguments0Value_ instanceof Integer) {
                int arguments0Value__ = (int) arguments0Value_;
                return JSGlobalIsNaNNode.isNaNInt(arguments0Value__);
            }
            if ((state & 0b10) != 0 /* is-active isNaNDouble(double) */ && JSTypesGen.isImplicitDouble((state & 0b11110000) >>> 4 /* extract-implicit-active 0:double */, arguments0Value_)) {
                double arguments0Value__ = JSTypesGen.asImplicitDouble((state & 0b11110000) >>> 4 /* extract-implicit-active 0:double */, arguments0Value_);
                return JSGlobalIsNaNNode.isNaNDouble(arguments0Value__);
            }
            if ((state & 0b1100) != 0 /* is-active isNaNGeneric(Object, JSToDoubleNode) || isNaNUndefined(Object) */) {
                if ((state & 0b100) != 0 /* is-active isNaNGeneric(Object, JSToDoubleNode) */) {
                    if ((!(JSGuards.isUndefined(arguments0Value_)))) {
                        return JSGlobalIsNaNNode.isNaNGeneric(arguments0Value_, this.isNaNGeneric_toDoubleNode_);
                    }
                }
                if ((state & 0b1000) != 0 /* is-active isNaNUndefined(Object) */) {
                    if ((JSGuards.isUndefined(arguments0Value_))) {
                        return JSGlobalIsNaNNode.isNaNUndefined(arguments0Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            int state = state_;
            if ((state & 0b1110) == 0 /* only-active isNaNInt(int) */ && (state & 0b1111) != 0  /* is-not isNaNInt(int) && isNaNDouble(double) && isNaNGeneric(Object, JSToDoubleNode) && isNaNUndefined(Object) */) {
                return executeBoolean_int3(frameValue, state);
            } else if ((state & 0b1101) == 0 /* only-active isNaNDouble(double) */ && (state & 0b1111) != 0  /* is-not isNaNInt(int) && isNaNDouble(double) && isNaNGeneric(Object, JSToDoubleNode) && isNaNUndefined(Object) */) {
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
            assert (state & 0b1) != 0 /* is-active isNaNInt(int) */;
            return JSGlobalIsNaNNode.isNaNInt(arguments0Value_);
        }

        private boolean executeBoolean_double4(VirtualFrame frameValue, int state) {
            int arguments0Value_int = 0;
            long arguments0Value_long = 0L;
            double arguments0Value_;
            try {
                if ((state & 0b11100000) == 0 /* only-active 0:double */ && (state & 0b1111) != 0  /* is-not isNaNInt(int) && isNaNDouble(double) && isNaNGeneric(Object, JSToDoubleNode) && isNaNUndefined(Object) */) {
                    arguments0Value_long = this.arguments0_.executeLong(frameValue);
                    arguments0Value_ = JSTypes.longToDouble(arguments0Value_long);
                } else if ((state & 0b11010000) == 0 /* only-active 0:double */ && (state & 0b1111) != 0  /* is-not isNaNInt(int) && isNaNDouble(double) && isNaNGeneric(Object, JSToDoubleNode) && isNaNUndefined(Object) */) {
                    arguments0Value_int = this.arguments0_.executeInt(frameValue);
                    arguments0Value_ = JSTypes.intToDouble(arguments0Value_int);
                } else if ((state & 0b10110000) == 0 /* only-active 0:double */ && (state & 0b1111) != 0  /* is-not isNaNInt(int) && isNaNDouble(double) && isNaNGeneric(Object, JSToDoubleNode) && isNaNUndefined(Object) */) {
                    arguments0Value_ = this.arguments0_.executeDouble(frameValue);
                } else {
                    Object arguments0Value__ = this.arguments0_.execute(frameValue);
                    arguments0Value_ = JSTypesGen.expectImplicitDouble((state & 0b11110000) >>> 4 /* extract-implicit-active 0:double */, arguments0Value__);
                }
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(ex.getResult());
            }
            assert (state & 0b10) != 0 /* is-active isNaNDouble(double) */;
            return JSGlobalIsNaNNode.isNaNDouble(arguments0Value_);
        }

        private boolean executeBoolean_generic5(VirtualFrame frameValue, int state) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state & 0b1) != 0 /* is-active isNaNInt(int) */ && arguments0Value_ instanceof Integer) {
                int arguments0Value__ = (int) arguments0Value_;
                return JSGlobalIsNaNNode.isNaNInt(arguments0Value__);
            }
            if ((state & 0b10) != 0 /* is-active isNaNDouble(double) */ && JSTypesGen.isImplicitDouble((state & 0b11110000) >>> 4 /* extract-implicit-active 0:double */, arguments0Value_)) {
                double arguments0Value__ = JSTypesGen.asImplicitDouble((state & 0b11110000) >>> 4 /* extract-implicit-active 0:double */, arguments0Value_);
                return JSGlobalIsNaNNode.isNaNDouble(arguments0Value__);
            }
            if ((state & 0b1100) != 0 /* is-active isNaNGeneric(Object, JSToDoubleNode) || isNaNUndefined(Object) */) {
                if ((state & 0b100) != 0 /* is-active isNaNGeneric(Object, JSToDoubleNode) */) {
                    if ((!(JSGuards.isUndefined(arguments0Value_)))) {
                        return JSGlobalIsNaNNode.isNaNGeneric(arguments0Value_, this.isNaNGeneric_toDoubleNode_);
                    }
                }
                if ((state & 0b1000) != 0 /* is-active isNaNUndefined(Object) */) {
                    if ((JSGuards.isUndefined(arguments0Value_))) {
                        return JSGlobalIsNaNNode.isNaNUndefined(arguments0Value_);
                    }
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
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            try {
                if (arguments0Value instanceof Integer) {
                    int arguments0Value_ = (int) arguments0Value;
                    this.state_ = state = state | 0b1 /* add-active isNaNInt(int) */;
                    lock.unlock();
                    hasLock = false;
                    return JSGlobalIsNaNNode.isNaNInt(arguments0Value_);
                }
                {
                    int doubleCast0;
                    if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(arguments0Value)) != 0) {
                        double arguments0Value_ = JSTypesGen.asImplicitDouble(doubleCast0, arguments0Value);
                        state = (state | (doubleCast0 << 4) /* set-implicit-active 0:double */);
                        this.state_ = state = state | 0b10 /* add-active isNaNDouble(double) */;
                        lock.unlock();
                        hasLock = false;
                        return JSGlobalIsNaNNode.isNaNDouble(arguments0Value_);
                    }
                }
                if ((!(JSGuards.isUndefined(arguments0Value)))) {
                    this.isNaNGeneric_toDoubleNode_ = super.insert((JSToDoubleNode.create()));
                    this.state_ = state = state | 0b100 /* add-active isNaNGeneric(Object, JSToDoubleNode) */;
                    lock.unlock();
                    hasLock = false;
                    return JSGlobalIsNaNNode.isNaNGeneric(arguments0Value, this.isNaNGeneric_toDoubleNode_);
                }
                if ((JSGuards.isUndefined(arguments0Value))) {
                    this.state_ = state = state | 0b1000 /* add-active isNaNUndefined(Object) */;
                    lock.unlock();
                    hasLock = false;
                    return JSGlobalIsNaNNode.isNaNUndefined(arguments0Value);
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
            if ((state & 0b1111) == 0b0) {
                return NodeCost.UNINITIALIZED;
            } else if (((state & 0b1111) & ((state & 0b1111) - 1)) == 0 /* is-single-active  */) {
                return NodeCost.MONOMORPHIC;
            }
            return NodeCost.POLYMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[5];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "isNaNInt";
            if ((state & 0b1) != 0 /* is-active isNaNInt(int) */) {
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
            s = new Object[3];
            s[0] = "isNaNGeneric";
            if ((state & 0b100) != 0 /* is-active isNaNGeneric(Object, JSToDoubleNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.isNaNGeneric_toDoubleNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "isNaNUndefined";
            if ((state & 0b1000) != 0 /* is-active isNaNUndefined(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            return Provider.create(data);
        }

        public static JSGlobalIsNaNNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSGlobalIsNaNNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSGlobalIsFiniteNode.class)
    public static final class JSGlobalIsFiniteNodeGen extends JSGlobalIsFiniteNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_;
        @Child private JSToDoubleNode isFiniteGeneric_toDoubleNode_;

        private JSGlobalIsFiniteNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state & 0b1110) == 0 /* only-active isFiniteInt(int) */ && (state & 0b1111) != 0  /* is-not isFiniteInt(int) && isFiniteDouble(double) && isFiniteGeneric(Object, JSToDoubleNode) && isFiniteUndefined(Object) */) {
                return execute_int0(frameValue, state);
            } else if ((state & 0b1101) == 0 /* only-active isFiniteDouble(double) */ && (state & 0b1111) != 0  /* is-not isFiniteInt(int) && isFiniteDouble(double) && isFiniteGeneric(Object, JSToDoubleNode) && isFiniteUndefined(Object) */) {
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
            assert (state & 0b1) != 0 /* is-active isFiniteInt(int) */;
            return JSGlobalIsFiniteNode.isFiniteInt(arguments0Value_);
        }

        private Object execute_double1(VirtualFrame frameValue, int state) {
            int arguments0Value_int = 0;
            long arguments0Value_long = 0L;
            double arguments0Value_;
            try {
                if ((state & 0b11100000) == 0 /* only-active 0:double */ && (state & 0b1111) != 0  /* is-not isFiniteInt(int) && isFiniteDouble(double) && isFiniteGeneric(Object, JSToDoubleNode) && isFiniteUndefined(Object) */) {
                    arguments0Value_long = this.arguments0_.executeLong(frameValue);
                    arguments0Value_ = JSTypes.longToDouble(arguments0Value_long);
                } else if ((state & 0b11010000) == 0 /* only-active 0:double */ && (state & 0b1111) != 0  /* is-not isFiniteInt(int) && isFiniteDouble(double) && isFiniteGeneric(Object, JSToDoubleNode) && isFiniteUndefined(Object) */) {
                    arguments0Value_int = this.arguments0_.executeInt(frameValue);
                    arguments0Value_ = JSTypes.intToDouble(arguments0Value_int);
                } else if ((state & 0b10110000) == 0 /* only-active 0:double */ && (state & 0b1111) != 0  /* is-not isFiniteInt(int) && isFiniteDouble(double) && isFiniteGeneric(Object, JSToDoubleNode) && isFiniteUndefined(Object) */) {
                    arguments0Value_ = this.arguments0_.executeDouble(frameValue);
                } else {
                    Object arguments0Value__ = this.arguments0_.execute(frameValue);
                    arguments0Value_ = JSTypesGen.expectImplicitDouble((state & 0b11110000) >>> 4 /* extract-implicit-active 0:double */, arguments0Value__);
                }
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(ex.getResult());
            }
            assert (state & 0b10) != 0 /* is-active isFiniteDouble(double) */;
            return JSGlobalIsFiniteNode.isFiniteDouble(arguments0Value_);
        }

        private Object execute_generic2(VirtualFrame frameValue, int state) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state & 0b1) != 0 /* is-active isFiniteInt(int) */ && arguments0Value_ instanceof Integer) {
                int arguments0Value__ = (int) arguments0Value_;
                return JSGlobalIsFiniteNode.isFiniteInt(arguments0Value__);
            }
            if ((state & 0b10) != 0 /* is-active isFiniteDouble(double) */ && JSTypesGen.isImplicitDouble((state & 0b11110000) >>> 4 /* extract-implicit-active 0:double */, arguments0Value_)) {
                double arguments0Value__ = JSTypesGen.asImplicitDouble((state & 0b11110000) >>> 4 /* extract-implicit-active 0:double */, arguments0Value_);
                return JSGlobalIsFiniteNode.isFiniteDouble(arguments0Value__);
            }
            if ((state & 0b1100) != 0 /* is-active isFiniteGeneric(Object, JSToDoubleNode) || isFiniteUndefined(Object) */) {
                if ((state & 0b100) != 0 /* is-active isFiniteGeneric(Object, JSToDoubleNode) */) {
                    if ((!(JSGuards.isUndefined(arguments0Value_)))) {
                        return JSGlobalIsFiniteNode.isFiniteGeneric(arguments0Value_, this.isFiniteGeneric_toDoubleNode_);
                    }
                }
                if ((state & 0b1000) != 0 /* is-active isFiniteUndefined(Object) */) {
                    if ((JSGuards.isUndefined(arguments0Value_))) {
                        return JSGlobalIsFiniteNode.isFiniteUndefined(arguments0Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            int state = state_;
            if ((state & 0b1110) == 0 /* only-active isFiniteInt(int) */ && (state & 0b1111) != 0  /* is-not isFiniteInt(int) && isFiniteDouble(double) && isFiniteGeneric(Object, JSToDoubleNode) && isFiniteUndefined(Object) */) {
                return executeBoolean_int3(frameValue, state);
            } else if ((state & 0b1101) == 0 /* only-active isFiniteDouble(double) */ && (state & 0b1111) != 0  /* is-not isFiniteInt(int) && isFiniteDouble(double) && isFiniteGeneric(Object, JSToDoubleNode) && isFiniteUndefined(Object) */) {
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
            assert (state & 0b1) != 0 /* is-active isFiniteInt(int) */;
            return JSGlobalIsFiniteNode.isFiniteInt(arguments0Value_);
        }

        private boolean executeBoolean_double4(VirtualFrame frameValue, int state) {
            int arguments0Value_int = 0;
            long arguments0Value_long = 0L;
            double arguments0Value_;
            try {
                if ((state & 0b11100000) == 0 /* only-active 0:double */ && (state & 0b1111) != 0  /* is-not isFiniteInt(int) && isFiniteDouble(double) && isFiniteGeneric(Object, JSToDoubleNode) && isFiniteUndefined(Object) */) {
                    arguments0Value_long = this.arguments0_.executeLong(frameValue);
                    arguments0Value_ = JSTypes.longToDouble(arguments0Value_long);
                } else if ((state & 0b11010000) == 0 /* only-active 0:double */ && (state & 0b1111) != 0  /* is-not isFiniteInt(int) && isFiniteDouble(double) && isFiniteGeneric(Object, JSToDoubleNode) && isFiniteUndefined(Object) */) {
                    arguments0Value_int = this.arguments0_.executeInt(frameValue);
                    arguments0Value_ = JSTypes.intToDouble(arguments0Value_int);
                } else if ((state & 0b10110000) == 0 /* only-active 0:double */ && (state & 0b1111) != 0  /* is-not isFiniteInt(int) && isFiniteDouble(double) && isFiniteGeneric(Object, JSToDoubleNode) && isFiniteUndefined(Object) */) {
                    arguments0Value_ = this.arguments0_.executeDouble(frameValue);
                } else {
                    Object arguments0Value__ = this.arguments0_.execute(frameValue);
                    arguments0Value_ = JSTypesGen.expectImplicitDouble((state & 0b11110000) >>> 4 /* extract-implicit-active 0:double */, arguments0Value__);
                }
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(ex.getResult());
            }
            assert (state & 0b10) != 0 /* is-active isFiniteDouble(double) */;
            return JSGlobalIsFiniteNode.isFiniteDouble(arguments0Value_);
        }

        private boolean executeBoolean_generic5(VirtualFrame frameValue, int state) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state & 0b1) != 0 /* is-active isFiniteInt(int) */ && arguments0Value_ instanceof Integer) {
                int arguments0Value__ = (int) arguments0Value_;
                return JSGlobalIsFiniteNode.isFiniteInt(arguments0Value__);
            }
            if ((state & 0b10) != 0 /* is-active isFiniteDouble(double) */ && JSTypesGen.isImplicitDouble((state & 0b11110000) >>> 4 /* extract-implicit-active 0:double */, arguments0Value_)) {
                double arguments0Value__ = JSTypesGen.asImplicitDouble((state & 0b11110000) >>> 4 /* extract-implicit-active 0:double */, arguments0Value_);
                return JSGlobalIsFiniteNode.isFiniteDouble(arguments0Value__);
            }
            if ((state & 0b1100) != 0 /* is-active isFiniteGeneric(Object, JSToDoubleNode) || isFiniteUndefined(Object) */) {
                if ((state & 0b100) != 0 /* is-active isFiniteGeneric(Object, JSToDoubleNode) */) {
                    if ((!(JSGuards.isUndefined(arguments0Value_)))) {
                        return JSGlobalIsFiniteNode.isFiniteGeneric(arguments0Value_, this.isFiniteGeneric_toDoubleNode_);
                    }
                }
                if ((state & 0b1000) != 0 /* is-active isFiniteUndefined(Object) */) {
                    if ((JSGuards.isUndefined(arguments0Value_))) {
                        return JSGlobalIsFiniteNode.isFiniteUndefined(arguments0Value_);
                    }
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
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            try {
                if (arguments0Value instanceof Integer) {
                    int arguments0Value_ = (int) arguments0Value;
                    this.state_ = state = state | 0b1 /* add-active isFiniteInt(int) */;
                    lock.unlock();
                    hasLock = false;
                    return JSGlobalIsFiniteNode.isFiniteInt(arguments0Value_);
                }
                {
                    int doubleCast0;
                    if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(arguments0Value)) != 0) {
                        double arguments0Value_ = JSTypesGen.asImplicitDouble(doubleCast0, arguments0Value);
                        state = (state | (doubleCast0 << 4) /* set-implicit-active 0:double */);
                        this.state_ = state = state | 0b10 /* add-active isFiniteDouble(double) */;
                        lock.unlock();
                        hasLock = false;
                        return JSGlobalIsFiniteNode.isFiniteDouble(arguments0Value_);
                    }
                }
                if ((!(JSGuards.isUndefined(arguments0Value)))) {
                    this.isFiniteGeneric_toDoubleNode_ = super.insert((JSToDoubleNode.create()));
                    this.state_ = state = state | 0b100 /* add-active isFiniteGeneric(Object, JSToDoubleNode) */;
                    lock.unlock();
                    hasLock = false;
                    return JSGlobalIsFiniteNode.isFiniteGeneric(arguments0Value, this.isFiniteGeneric_toDoubleNode_);
                }
                if ((JSGuards.isUndefined(arguments0Value))) {
                    this.state_ = state = state | 0b1000 /* add-active isFiniteUndefined(Object) */;
                    lock.unlock();
                    hasLock = false;
                    return JSGlobalIsFiniteNode.isFiniteUndefined(arguments0Value);
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
            if ((state & 0b1111) == 0b0) {
                return NodeCost.UNINITIALIZED;
            } else if (((state & 0b1111) & ((state & 0b1111) - 1)) == 0 /* is-single-active  */) {
                return NodeCost.MONOMORPHIC;
            }
            return NodeCost.POLYMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[5];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "isFiniteInt";
            if ((state & 0b1) != 0 /* is-active isFiniteInt(int) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "isFiniteDouble";
            if ((state & 0b10) != 0 /* is-active isFiniteDouble(double) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "isFiniteGeneric";
            if ((state & 0b100) != 0 /* is-active isFiniteGeneric(Object, JSToDoubleNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.isFiniteGeneric_toDoubleNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "isFiniteUndefined";
            if ((state & 0b1000) != 0 /* is-active isFiniteUndefined(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            return Provider.create(data);
        }

        public static JSGlobalIsFiniteNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSGlobalIsFiniteNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSGlobalParseFloatNode.class)
    public static final class JSGlobalParseFloatNodeGen extends JSGlobalParseFloatNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_;
        @CompilationFinal private ConditionProfile parseFloatDouble_negativeZero_;

        private JSGlobalParseFloatNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state & 0b1111110) == 0 /* only-active parseFloatInt(int) */ && (state & 0b1111111) != 0  /* is-not parseFloatInt(int) && parseFloatDouble(double, ConditionProfile) && parseFloatBoolean(boolean) && parseFloatUndefined(Object) && parseFloatNull(Object) && parseFloatString(String) && parseFloatGeneric(TruffleObject) */) {
                return execute_int0(frameValue, state);
            } else if ((state & 0b1111101) == 0 /* only-active parseFloatDouble(double, ConditionProfile) */ && (state & 0b1111111) != 0  /* is-not parseFloatInt(int) && parseFloatDouble(double, ConditionProfile) && parseFloatBoolean(boolean) && parseFloatUndefined(Object) && parseFloatNull(Object) && parseFloatString(String) && parseFloatGeneric(TruffleObject) */) {
                return execute_double1(frameValue, state);
            } else if ((state & 0b1111011) == 0 /* only-active parseFloatBoolean(boolean) */ && (state & 0b1111111) != 0  /* is-not parseFloatInt(int) && parseFloatDouble(double, ConditionProfile) && parseFloatBoolean(boolean) && parseFloatUndefined(Object) && parseFloatNull(Object) && parseFloatString(String) && parseFloatGeneric(TruffleObject) */) {
                return execute_boolean2(frameValue, state);
            } else {
                return execute_generic3(frameValue, state);
            }
        }

        private Object execute_int0(VirtualFrame frameValue, int state) {
            int arguments0Value_;
            try {
                arguments0Value_ = this.arguments0_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(ex.getResult());
            }
            assert (state & 0b1) != 0 /* is-active parseFloatInt(int) */;
            return parseFloatInt(arguments0Value_);
        }

        private Object execute_double1(VirtualFrame frameValue, int state) {
            int arguments0Value_int = 0;
            long arguments0Value_long = 0L;
            double arguments0Value_;
            try {
                if ((state & 0b11100000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not parseFloatInt(int) && parseFloatDouble(double, ConditionProfile) && parseFloatBoolean(boolean) && parseFloatUndefined(Object) && parseFloatNull(Object) && parseFloatString(String) && parseFloatGeneric(TruffleObject) */) {
                    arguments0Value_long = this.arguments0_.executeLong(frameValue);
                    arguments0Value_ = JSTypes.longToDouble(arguments0Value_long);
                } else if ((state & 0b11010000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not parseFloatInt(int) && parseFloatDouble(double, ConditionProfile) && parseFloatBoolean(boolean) && parseFloatUndefined(Object) && parseFloatNull(Object) && parseFloatString(String) && parseFloatGeneric(TruffleObject) */) {
                    arguments0Value_int = this.arguments0_.executeInt(frameValue);
                    arguments0Value_ = JSTypes.intToDouble(arguments0Value_int);
                } else if ((state & 0b10110000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not parseFloatInt(int) && parseFloatDouble(double, ConditionProfile) && parseFloatBoolean(boolean) && parseFloatUndefined(Object) && parseFloatNull(Object) && parseFloatString(String) && parseFloatGeneric(TruffleObject) */) {
                    arguments0Value_ = this.arguments0_.executeDouble(frameValue);
                } else {
                    Object arguments0Value__ = this.arguments0_.execute(frameValue);
                    arguments0Value_ = JSTypesGen.expectImplicitDouble((state & 0b11110000000) >>> 7 /* extract-implicit-active 0:double */, arguments0Value__);
                }
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(ex.getResult());
            }
            assert (state & 0b10) != 0 /* is-active parseFloatDouble(double, ConditionProfile) */;
            return parseFloatDouble(arguments0Value_, this.parseFloatDouble_negativeZero_);
        }

        private Object execute_boolean2(VirtualFrame frameValue, int state) {
            boolean arguments0Value_;
            try {
                arguments0Value_ = this.arguments0_.executeBoolean(frameValue);
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(ex.getResult());
            }
            assert (state & 0b100) != 0 /* is-active parseFloatBoolean(boolean) */;
            return parseFloatBoolean(arguments0Value_);
        }

        private Object execute_generic3(VirtualFrame frameValue, int state) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state & 0b1) != 0 /* is-active parseFloatInt(int) */ && arguments0Value_ instanceof Integer) {
                int arguments0Value__ = (int) arguments0Value_;
                return parseFloatInt(arguments0Value__);
            }
            if ((state & 0b10) != 0 /* is-active parseFloatDouble(double, ConditionProfile) */ && JSTypesGen.isImplicitDouble((state & 0b11110000000) >>> 7 /* extract-implicit-active 0:double */, arguments0Value_)) {
                double arguments0Value__ = JSTypesGen.asImplicitDouble((state & 0b11110000000) >>> 7 /* extract-implicit-active 0:double */, arguments0Value_);
                return parseFloatDouble(arguments0Value__, this.parseFloatDouble_negativeZero_);
            }
            if ((state & 0b100) != 0 /* is-active parseFloatBoolean(boolean) */ && arguments0Value_ instanceof Boolean) {
                boolean arguments0Value__ = (boolean) arguments0Value_;
                return parseFloatBoolean(arguments0Value__);
            }
            if ((state & 0b11000) != 0 /* is-active parseFloatUndefined(Object) || parseFloatNull(Object) */) {
                if ((state & 0b1000) != 0 /* is-active parseFloatUndefined(Object) */) {
                    if ((JSGuards.isUndefined(arguments0Value_))) {
                        return parseFloatUndefined(arguments0Value_);
                    }
                }
                if ((state & 0b10000) != 0 /* is-active parseFloatNull(Object) */) {
                    if ((JSGuards.isJSNull(arguments0Value_))) {
                        return parseFloatNull(arguments0Value_);
                    }
                }
            }
            if ((state & 0b100000) != 0 /* is-active parseFloatString(String) */ && JSTypesGen.isImplicitString((state & 0b111100000000000) >>> 11 /* extract-implicit-active 0:String */, arguments0Value_)) {
                String arguments0Value__ = JSTypesGen.asImplicitString((state & 0b111100000000000) >>> 11 /* extract-implicit-active 0:String */, arguments0Value_);
                return parseFloatString(arguments0Value__);
            }
            if ((state & 0b1000000) != 0 /* is-active parseFloatGeneric(TruffleObject) */ && arguments0Value_ instanceof TruffleObject) {
                TruffleObject arguments0Value__ = (TruffleObject) arguments0Value_;
                if ((!(JSGuards.isJSNull(arguments0Value__))) && (!(JSGuards.isUndefined(arguments0Value__)))) {
                    return parseFloatGeneric(arguments0Value__);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public double executeDouble(VirtualFrame frameValue) throws UnexpectedResultException {
            int state = state_;
            if ((state & 0b1111100) == 0 /* only-active parseFloatDouble(double, ConditionProfile) */ && (state & 0b1111110) != 0  /* is-not parseFloatDouble(double, ConditionProfile) && parseFloatBoolean(boolean) && parseFloatUndefined(Object) && parseFloatNull(Object) && parseFloatString(String) && parseFloatGeneric(TruffleObject) */) {
                return executeDouble_double4(frameValue, state);
            } else if ((state & 0b1111010) == 0 /* only-active parseFloatBoolean(boolean) */ && (state & 0b1111110) != 0  /* is-not parseFloatDouble(double, ConditionProfile) && parseFloatBoolean(boolean) && parseFloatUndefined(Object) && parseFloatNull(Object) && parseFloatString(String) && parseFloatGeneric(TruffleObject) */) {
                return executeDouble_boolean5(frameValue, state);
            } else {
                return executeDouble_generic6(frameValue, state);
            }
        }

        private double executeDouble_double4(VirtualFrame frameValue, int state) throws UnexpectedResultException {
            int arguments0Value_int = 0;
            long arguments0Value_long = 0L;
            double arguments0Value_;
            try {
                if ((state & 0b11100000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not parseFloatInt(int) && parseFloatDouble(double, ConditionProfile) && parseFloatBoolean(boolean) && parseFloatUndefined(Object) && parseFloatNull(Object) && parseFloatString(String) && parseFloatGeneric(TruffleObject) */) {
                    arguments0Value_long = this.arguments0_.executeLong(frameValue);
                    arguments0Value_ = JSTypes.longToDouble(arguments0Value_long);
                } else if ((state & 0b11010000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not parseFloatInt(int) && parseFloatDouble(double, ConditionProfile) && parseFloatBoolean(boolean) && parseFloatUndefined(Object) && parseFloatNull(Object) && parseFloatString(String) && parseFloatGeneric(TruffleObject) */) {
                    arguments0Value_int = this.arguments0_.executeInt(frameValue);
                    arguments0Value_ = JSTypes.intToDouble(arguments0Value_int);
                } else if ((state & 0b10110000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not parseFloatInt(int) && parseFloatDouble(double, ConditionProfile) && parseFloatBoolean(boolean) && parseFloatUndefined(Object) && parseFloatNull(Object) && parseFloatString(String) && parseFloatGeneric(TruffleObject) */) {
                    arguments0Value_ = this.arguments0_.executeDouble(frameValue);
                } else {
                    Object arguments0Value__ = this.arguments0_.execute(frameValue);
                    arguments0Value_ = JSTypesGen.expectImplicitDouble((state & 0b11110000000) >>> 7 /* extract-implicit-active 0:double */, arguments0Value__);
                }
            } catch (UnexpectedResultException ex) {
                return JSTypesGen.expectDouble(executeAndSpecialize(ex.getResult()));
            }
            assert (state & 0b10) != 0 /* is-active parseFloatDouble(double, ConditionProfile) */;
            return parseFloatDouble(arguments0Value_, this.parseFloatDouble_negativeZero_);
        }

        private double executeDouble_boolean5(VirtualFrame frameValue, int state) throws UnexpectedResultException {
            boolean arguments0Value_;
            try {
                arguments0Value_ = this.arguments0_.executeBoolean(frameValue);
            } catch (UnexpectedResultException ex) {
                return JSTypesGen.expectDouble(executeAndSpecialize(ex.getResult()));
            }
            assert (state & 0b100) != 0 /* is-active parseFloatBoolean(boolean) */;
            return parseFloatBoolean(arguments0Value_);
        }

        private double executeDouble_generic6(VirtualFrame frameValue, int state) throws UnexpectedResultException {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state & 0b10) != 0 /* is-active parseFloatDouble(double, ConditionProfile) */ && JSTypesGen.isImplicitDouble((state & 0b11110000000) >>> 7 /* extract-implicit-active 0:double */, arguments0Value_)) {
                double arguments0Value__ = JSTypesGen.asImplicitDouble((state & 0b11110000000) >>> 7 /* extract-implicit-active 0:double */, arguments0Value_);
                return parseFloatDouble(arguments0Value__, this.parseFloatDouble_negativeZero_);
            }
            if ((state & 0b100) != 0 /* is-active parseFloatBoolean(boolean) */ && arguments0Value_ instanceof Boolean) {
                boolean arguments0Value__ = (boolean) arguments0Value_;
                return parseFloatBoolean(arguments0Value__);
            }
            if ((state & 0b11000) != 0 /* is-active parseFloatUndefined(Object) || parseFloatNull(Object) */) {
                if ((state & 0b1000) != 0 /* is-active parseFloatUndefined(Object) */) {
                    if ((JSGuards.isUndefined(arguments0Value_))) {
                        return parseFloatUndefined(arguments0Value_);
                    }
                }
                if ((state & 0b10000) != 0 /* is-active parseFloatNull(Object) */) {
                    if ((JSGuards.isJSNull(arguments0Value_))) {
                        return parseFloatNull(arguments0Value_);
                    }
                }
            }
            if ((state & 0b100000) != 0 /* is-active parseFloatString(String) */ && JSTypesGen.isImplicitString((state & 0b111100000000000) >>> 11 /* extract-implicit-active 0:String */, arguments0Value_)) {
                String arguments0Value__ = JSTypesGen.asImplicitString((state & 0b111100000000000) >>> 11 /* extract-implicit-active 0:String */, arguments0Value_);
                return parseFloatString(arguments0Value__);
            }
            if ((state & 0b1000000) != 0 /* is-active parseFloatGeneric(TruffleObject) */ && arguments0Value_ instanceof TruffleObject) {
                TruffleObject arguments0Value__ = (TruffleObject) arguments0Value_;
                if ((!(JSGuards.isJSNull(arguments0Value__))) && (!(JSGuards.isUndefined(arguments0Value__)))) {
                    return parseFloatGeneric(arguments0Value__);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return JSTypesGen.expectDouble(executeAndSpecialize(arguments0Value_));
        }

        @Override
        public int executeInt(VirtualFrame frameValue) throws UnexpectedResultException {
            int state = state_;
            int arguments0Value_;
            try {
                arguments0Value_ = this.arguments0_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                return JSTypesGen.expectInteger(executeAndSpecialize(ex.getResult()));
            }
            if ((state & 0b1) != 0 /* is-active parseFloatInt(int) */) {
                return parseFloatInt(arguments0Value_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return JSTypesGen.expectInteger(executeAndSpecialize(arguments0Value_));
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            int state = state_;
            try {
                if ((state & 0b1111110) == 0 /* only-active parseFloatInt(int) */ && (state & 0b1111111) != 0  /* is-not parseFloatInt(int) && parseFloatDouble(double, ConditionProfile) && parseFloatBoolean(boolean) && parseFloatUndefined(Object) && parseFloatNull(Object) && parseFloatString(String) && parseFloatGeneric(TruffleObject) */) {
                    executeInt(frameValue);
                    return;
                } else if ((state & 0b1) == 0 /* only-active parseFloatDouble(double, ConditionProfile) && parseFloatBoolean(boolean) && parseFloatUndefined(Object) && parseFloatNull(Object) && parseFloatString(String) && parseFloatGeneric(TruffleObject) */ && (state & 0b1111111) != 0  /* is-not parseFloatInt(int) && parseFloatDouble(double, ConditionProfile) && parseFloatBoolean(boolean) && parseFloatUndefined(Object) && parseFloatNull(Object) && parseFloatString(String) && parseFloatGeneric(TruffleObject) */) {
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
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            try {
                if (arguments0Value instanceof Integer) {
                    int arguments0Value_ = (int) arguments0Value;
                    this.state_ = state = state | 0b1 /* add-active parseFloatInt(int) */;
                    lock.unlock();
                    hasLock = false;
                    return parseFloatInt(arguments0Value_);
                }
                {
                    int doubleCast0;
                    if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(arguments0Value)) != 0) {
                        double arguments0Value_ = JSTypesGen.asImplicitDouble(doubleCast0, arguments0Value);
                        this.parseFloatDouble_negativeZero_ = (ConditionProfile.createBinaryProfile());
                        state = (state | (doubleCast0 << 7) /* set-implicit-active 0:double */);
                        this.state_ = state = state | 0b10 /* add-active parseFloatDouble(double, ConditionProfile) */;
                        lock.unlock();
                        hasLock = false;
                        return parseFloatDouble(arguments0Value_, this.parseFloatDouble_negativeZero_);
                    }
                }
                if (arguments0Value instanceof Boolean) {
                    boolean arguments0Value_ = (boolean) arguments0Value;
                    this.state_ = state = state | 0b100 /* add-active parseFloatBoolean(boolean) */;
                    lock.unlock();
                    hasLock = false;
                    return parseFloatBoolean(arguments0Value_);
                }
                if ((JSGuards.isUndefined(arguments0Value))) {
                    this.state_ = state = state | 0b1000 /* add-active parseFloatUndefined(Object) */;
                    lock.unlock();
                    hasLock = false;
                    return parseFloatUndefined(arguments0Value);
                }
                if ((JSGuards.isJSNull(arguments0Value))) {
                    this.state_ = state = state | 0b10000 /* add-active parseFloatNull(Object) */;
                    lock.unlock();
                    hasLock = false;
                    return parseFloatNull(arguments0Value);
                }
                {
                    int stringCast0;
                    if ((stringCast0 = JSTypesGen.specializeImplicitString(arguments0Value)) != 0) {
                        String arguments0Value_ = JSTypesGen.asImplicitString(stringCast0, arguments0Value);
                        state = (state | (stringCast0 << 11) /* set-implicit-active 0:String */);
                        this.state_ = state = state | 0b100000 /* add-active parseFloatString(String) */;
                        lock.unlock();
                        hasLock = false;
                        return parseFloatString(arguments0Value_);
                    }
                }
                if (arguments0Value instanceof TruffleObject) {
                    TruffleObject arguments0Value_ = (TruffleObject) arguments0Value;
                    if ((!(JSGuards.isJSNull(arguments0Value_))) && (!(JSGuards.isUndefined(arguments0Value_)))) {
                        this.state_ = state = state | 0b1000000 /* add-active parseFloatGeneric(TruffleObject) */;
                        lock.unlock();
                        hasLock = false;
                        return parseFloatGeneric(arguments0Value_);
                    }
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
            if ((state & 0b1111111) == 0b0) {
                return NodeCost.UNINITIALIZED;
            } else if (((state & 0b1111111) & ((state & 0b1111111) - 1)) == 0 /* is-single-active  */) {
                return NodeCost.MONOMORPHIC;
            }
            return NodeCost.POLYMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[8];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "parseFloatInt";
            if ((state & 0b1) != 0 /* is-active parseFloatInt(int) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "parseFloatDouble";
            if ((state & 0b10) != 0 /* is-active parseFloatDouble(double, ConditionProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.parseFloatDouble_negativeZero_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "parseFloatBoolean";
            if ((state & 0b100) != 0 /* is-active parseFloatBoolean(boolean) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "parseFloatUndefined";
            if ((state & 0b1000) != 0 /* is-active parseFloatUndefined(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            s = new Object[3];
            s[0] = "parseFloatNull";
            if ((state & 0b10000) != 0 /* is-active parseFloatNull(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[5] = s;
            s = new Object[3];
            s[0] = "parseFloatString";
            if ((state & 0b100000) != 0 /* is-active parseFloatString(String) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[6] = s;
            s = new Object[3];
            s[0] = "parseFloatGeneric";
            if ((state & 0b1000000) != 0 /* is-active parseFloatGeneric(TruffleObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[7] = s;
            return Provider.create(data);
        }

        public static JSGlobalParseFloatNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSGlobalParseFloatNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSGlobalParseIntNode.class)
    public static final class JSGlobalParseIntNodeGen extends JSGlobalParseIntNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_;
        @CompilationFinal private BranchProfile parseIntInt_needsRadixConversion_;
        @CompilationFinal private BranchProfile parseIntDouble_needsRadixConversion_;
        @Child private ParseIntGenericData parseIntGeneric_cache;

        private JSGlobalParseIntNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state & 0b1111100) == 0 /* only-active parseIntNoRadix(int, Object) && parseIntInt(int, Object, BranchProfile) */ && (state & 0b1111111) != 0  /* is-not parseIntNoRadix(int, Object) && parseIntInt(int, Object, BranchProfile) && parseIntDoubleToInt(double, Object) && parseIntDoubleNoRadix(double, Object) && parseIntDouble(double, Object, BranchProfile) && parseIntStringInt10(String, int) && parseIntGeneric(Object, Object, JSToStringNode, BranchProfile, BranchProfile) */) {
                return execute_int0(frameValue, state);
            } else if ((state & 0b1100011) == 0 /* only-active parseIntDoubleToInt(double, Object) && parseIntDoubleNoRadix(double, Object) && parseIntDouble(double, Object, BranchProfile) */ && (state & 0b1111111) != 0  /* is-not parseIntNoRadix(int, Object) && parseIntInt(int, Object, BranchProfile) && parseIntDoubleToInt(double, Object) && parseIntDoubleNoRadix(double, Object) && parseIntDouble(double, Object, BranchProfile) && parseIntStringInt10(String, int) && parseIntGeneric(Object, Object, JSToStringNode, BranchProfile, BranchProfile) */) {
                return execute_double1(frameValue, state);
            } else if ((state & 0b1011111) == 0 /* only-active parseIntStringInt10(String, int) */ && (state & 0b1111111) != 0  /* is-not parseIntNoRadix(int, Object) && parseIntInt(int, Object, BranchProfile) && parseIntDoubleToInt(double, Object) && parseIntDoubleNoRadix(double, Object) && parseIntDouble(double, Object, BranchProfile) && parseIntStringInt10(String, int) && parseIntGeneric(Object, Object, JSToStringNode, BranchProfile, BranchProfile) */) {
                return execute_int2(frameValue, state);
            } else {
                return execute_generic3(frameValue, state);
            }
        }

        private Object execute_int0(VirtualFrame frameValue, int state) {
            int arguments0Value_;
            try {
                arguments0Value_ = this.arguments0_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                Object arguments1Value = this.arguments1_.execute(frameValue);
                return executeAndSpecialize(ex.getResult(), arguments1Value);
            }
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if ((state & 0b11) != 0 /* is-active parseIntNoRadix(int, Object) || parseIntInt(int, Object, BranchProfile) */) {
                if ((state & 0b1) != 0 /* is-active parseIntNoRadix(int, Object) */) {
                    if ((JSGuards.isUndefined(arguments1Value_))) {
                        return parseIntNoRadix(arguments0Value_, arguments1Value_);
                    }
                }
                if ((state & 0b10) != 0 /* is-active parseIntInt(int, Object, BranchProfile) */) {
                    if ((!(JSGuards.isUndefined(arguments1Value_)))) {
                        return parseIntInt(arguments0Value_, arguments1Value_, this.parseIntInt_needsRadixConversion_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        private Object execute_double1(VirtualFrame frameValue, int state) {
            int arguments0Value_int = 0;
            long arguments0Value_long = 0L;
            double arguments0Value_;
            try {
                if ((state & 0b11100000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not parseIntNoRadix(int, Object) && parseIntInt(int, Object, BranchProfile) && parseIntDoubleToInt(double, Object) && parseIntDoubleNoRadix(double, Object) && parseIntDouble(double, Object, BranchProfile) && parseIntStringInt10(String, int) && parseIntGeneric(Object, Object, JSToStringNode, BranchProfile, BranchProfile) */) {
                    arguments0Value_long = this.arguments0_.executeLong(frameValue);
                    arguments0Value_ = JSTypes.longToDouble(arguments0Value_long);
                } else if ((state & 0b11010000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not parseIntNoRadix(int, Object) && parseIntInt(int, Object, BranchProfile) && parseIntDoubleToInt(double, Object) && parseIntDoubleNoRadix(double, Object) && parseIntDouble(double, Object, BranchProfile) && parseIntStringInt10(String, int) && parseIntGeneric(Object, Object, JSToStringNode, BranchProfile, BranchProfile) */) {
                    arguments0Value_int = this.arguments0_.executeInt(frameValue);
                    arguments0Value_ = JSTypes.intToDouble(arguments0Value_int);
                } else if ((state & 0b10110000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not parseIntNoRadix(int, Object) && parseIntInt(int, Object, BranchProfile) && parseIntDoubleToInt(double, Object) && parseIntDoubleNoRadix(double, Object) && parseIntDouble(double, Object, BranchProfile) && parseIntStringInt10(String, int) && parseIntGeneric(Object, Object, JSToStringNode, BranchProfile, BranchProfile) */) {
                    arguments0Value_ = this.arguments0_.executeDouble(frameValue);
                } else {
                    Object arguments0Value__ = this.arguments0_.execute(frameValue);
                    arguments0Value_ = JSTypesGen.expectImplicitDouble((state & 0b11110000000) >>> 7 /* extract-implicit-active 0:double */, arguments0Value__);
                }
            } catch (UnexpectedResultException ex) {
                Object arguments1Value = this.arguments1_.execute(frameValue);
                return executeAndSpecialize(ex.getResult(), arguments1Value);
            }
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if ((state & 0b11100) != 0 /* is-active parseIntDoubleToInt(double, Object) || parseIntDoubleNoRadix(double, Object) || parseIntDouble(double, Object, BranchProfile) */) {
                if ((state & 0b100) != 0 /* is-active parseIntDoubleToInt(double, Object) */) {
                    if ((JSGlobalParseIntNode.hasRegularToStringInInt32Range(arguments0Value_)) && (JSGuards.isUndefined(arguments1Value_))) {
                        return parseIntDoubleToInt(arguments0Value_, arguments1Value_);
                    }
                }
                if ((state & 0b1000) != 0 /* is-active parseIntDoubleNoRadix(double, Object) */) {
                    if ((JSGlobalParseIntNode.hasRegularToString(arguments0Value_)) && (JSGuards.isUndefined(arguments1Value_))) {
                        return parseIntDoubleNoRadix(arguments0Value_, arguments1Value_);
                    }
                }
                if ((state & 0b10000) != 0 /* is-active parseIntDouble(double, Object, BranchProfile) */) {
                    if ((JSGlobalParseIntNode.hasRegularToString(arguments0Value_))) {
                        return parseIntDouble(arguments0Value_, arguments1Value_, this.parseIntDouble_needsRadixConversion_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(((state & 0b11100000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not parseIntNoRadix(int, Object) && parseIntInt(int, Object, BranchProfile) && parseIntDoubleToInt(double, Object) && parseIntDoubleNoRadix(double, Object) && parseIntDouble(double, Object, BranchProfile) && parseIntStringInt10(String, int) && parseIntGeneric(Object, Object, JSToStringNode, BranchProfile, BranchProfile) */ ? (Object) arguments0Value_long : ((state & 0b11010000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not parseIntNoRadix(int, Object) && parseIntInt(int, Object, BranchProfile) && parseIntDoubleToInt(double, Object) && parseIntDoubleNoRadix(double, Object) && parseIntDouble(double, Object, BranchProfile) && parseIntStringInt10(String, int) && parseIntGeneric(Object, Object, JSToStringNode, BranchProfile, BranchProfile) */ ? (Object) arguments0Value_int : (Object) arguments0Value_)), arguments1Value_);
        }

        private Object execute_int2(VirtualFrame frameValue, int state) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            int arguments1Value_;
            try {
                arguments1Value_ = this.arguments1_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(arguments0Value_, ex.getResult());
            }
            assert (state & 0b100000) != 0 /* is-active parseIntStringInt10(String, int) */;
            if (JSTypesGen.isImplicitString((state & 0b111100000000000) >>> 11 /* extract-implicit-active 0:String */, arguments0Value_)) {
                String arguments0Value__ = JSTypesGen.asImplicitString((state & 0b111100000000000) >>> 11 /* extract-implicit-active 0:String */, arguments0Value_);
                if ((arguments1Value_ == 10) && (arguments0Value__.length() < 15)) {
                    return parseIntStringInt10(arguments0Value__, arguments1Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        private Object execute_generic3(VirtualFrame frameValue, int state) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if ((state & 0b11111) != 0 /* is-active parseIntNoRadix(int, Object) || parseIntInt(int, Object, BranchProfile) || parseIntDoubleToInt(double, Object) || parseIntDoubleNoRadix(double, Object) || parseIntDouble(double, Object, BranchProfile) */) {
                if ((state & 0b11) != 0 /* is-active parseIntNoRadix(int, Object) || parseIntInt(int, Object, BranchProfile) */ && arguments0Value_ instanceof Integer) {
                    int arguments0Value__ = (int) arguments0Value_;
                    if ((state & 0b1) != 0 /* is-active parseIntNoRadix(int, Object) */) {
                        if ((JSGuards.isUndefined(arguments1Value_))) {
                            return parseIntNoRadix(arguments0Value__, arguments1Value_);
                        }
                    }
                    if ((state & 0b10) != 0 /* is-active parseIntInt(int, Object, BranchProfile) */) {
                        if ((!(JSGuards.isUndefined(arguments1Value_)))) {
                            return parseIntInt(arguments0Value__, arguments1Value_, this.parseIntInt_needsRadixConversion_);
                        }
                    }
                }
                if ((state & 0b11100) != 0 /* is-active parseIntDoubleToInt(double, Object) || parseIntDoubleNoRadix(double, Object) || parseIntDouble(double, Object, BranchProfile) */ && JSTypesGen.isImplicitDouble((state & 0b11110000000) >>> 7 /* extract-implicit-active 0:double */, arguments0Value_)) {
                    double arguments0Value__ = JSTypesGen.asImplicitDouble((state & 0b11110000000) >>> 7 /* extract-implicit-active 0:double */, arguments0Value_);
                    if ((state & 0b100) != 0 /* is-active parseIntDoubleToInt(double, Object) */) {
                        if ((JSGlobalParseIntNode.hasRegularToStringInInt32Range(arguments0Value__)) && (JSGuards.isUndefined(arguments1Value_))) {
                            return parseIntDoubleToInt(arguments0Value__, arguments1Value_);
                        }
                    }
                    if ((state & 0b1000) != 0 /* is-active parseIntDoubleNoRadix(double, Object) */) {
                        if ((JSGlobalParseIntNode.hasRegularToString(arguments0Value__)) && (JSGuards.isUndefined(arguments1Value_))) {
                            return parseIntDoubleNoRadix(arguments0Value__, arguments1Value_);
                        }
                    }
                    if ((state & 0b10000) != 0 /* is-active parseIntDouble(double, Object, BranchProfile) */) {
                        if ((JSGlobalParseIntNode.hasRegularToString(arguments0Value__))) {
                            return parseIntDouble(arguments0Value__, arguments1Value_, this.parseIntDouble_needsRadixConversion_);
                        }
                    }
                }
            }
            if ((state & 0b100000) != 0 /* is-active parseIntStringInt10(String, int) */ && JSTypesGen.isImplicitString((state & 0b111100000000000) >>> 11 /* extract-implicit-active 0:String */, arguments0Value_)) {
                String arguments0Value__ = JSTypesGen.asImplicitString((state & 0b111100000000000) >>> 11 /* extract-implicit-active 0:String */, arguments0Value_);
                if (arguments1Value_ instanceof Integer) {
                    int arguments1Value__ = (int) arguments1Value_;
                    if ((arguments1Value__ == 10) && (arguments0Value__.length() < 15)) {
                        return parseIntStringInt10(arguments0Value__, arguments1Value__);
                    }
                }
            }
            if ((state & 0b1000000) != 0 /* is-active parseIntGeneric(Object, Object, JSToStringNode, BranchProfile, BranchProfile) */) {
                ParseIntGenericData s7_ = this.parseIntGeneric_cache;
                if (s7_ != null) {
                    if ((!(JSGlobalParseIntNode.isShortStringInt10(arguments0Value_, arguments1Value_)))) {
                        return parseIntGeneric(arguments0Value_, arguments1Value_, s7_.toStringNode_, s7_.needsRadix16_, s7_.needsDontFitLong_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public double executeDouble(VirtualFrame frameValue) throws UnexpectedResultException {
            int state = state_;
            if ((state & 0b1100010) != 0 /* is-active parseIntInt(int, Object, BranchProfile) || parseIntStringInt10(String, int) || parseIntGeneric(Object, Object, JSToStringNode, BranchProfile, BranchProfile) */) {
                return JSTypesGen.expectDouble(execute(frameValue));
            }
            int arguments0Value_int = 0;
            long arguments0Value_long = 0L;
            double arguments0Value_;
            try {
                if ((state & 0b11100000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not parseIntNoRadix(int, Object) && parseIntInt(int, Object, BranchProfile) && parseIntDoubleToInt(double, Object) && parseIntDoubleNoRadix(double, Object) && parseIntDouble(double, Object, BranchProfile) && parseIntStringInt10(String, int) && parseIntGeneric(Object, Object, JSToStringNode, BranchProfile, BranchProfile) */) {
                    arguments0Value_long = this.arguments0_.executeLong(frameValue);
                    arguments0Value_ = JSTypes.longToDouble(arguments0Value_long);
                } else if ((state & 0b11010000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not parseIntNoRadix(int, Object) && parseIntInt(int, Object, BranchProfile) && parseIntDoubleToInt(double, Object) && parseIntDoubleNoRadix(double, Object) && parseIntDouble(double, Object, BranchProfile) && parseIntStringInt10(String, int) && parseIntGeneric(Object, Object, JSToStringNode, BranchProfile, BranchProfile) */) {
                    arguments0Value_int = this.arguments0_.executeInt(frameValue);
                    arguments0Value_ = JSTypes.intToDouble(arguments0Value_int);
                } else if ((state & 0b10110000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not parseIntNoRadix(int, Object) && parseIntInt(int, Object, BranchProfile) && parseIntDoubleToInt(double, Object) && parseIntDoubleNoRadix(double, Object) && parseIntDouble(double, Object, BranchProfile) && parseIntStringInt10(String, int) && parseIntGeneric(Object, Object, JSToStringNode, BranchProfile, BranchProfile) */) {
                    arguments0Value_ = this.arguments0_.executeDouble(frameValue);
                } else {
                    Object arguments0Value__ = this.arguments0_.execute(frameValue);
                    arguments0Value_ = JSTypesGen.expectImplicitDouble((state & 0b11110000000) >>> 7 /* extract-implicit-active 0:double */, arguments0Value__);
                }
            } catch (UnexpectedResultException ex) {
                Object arguments1Value = this.arguments1_.execute(frameValue);
                return JSTypesGen.expectDouble(executeAndSpecialize(ex.getResult(), arguments1Value));
            }
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if ((state & 0b11000) != 0 /* is-active parseIntDoubleNoRadix(double, Object) || parseIntDouble(double, Object, BranchProfile) */) {
                if ((state & 0b1000) != 0 /* is-active parseIntDoubleNoRadix(double, Object) */) {
                    if ((JSGlobalParseIntNode.hasRegularToString(arguments0Value_)) && (JSGuards.isUndefined(arguments1Value_))) {
                        return parseIntDoubleNoRadix(arguments0Value_, arguments1Value_);
                    }
                }
                if ((state & 0b10000) != 0 /* is-active parseIntDouble(double, Object, BranchProfile) */) {
                    if ((JSGlobalParseIntNode.hasRegularToString(arguments0Value_))) {
                        return parseIntDouble(arguments0Value_, arguments1Value_, this.parseIntDouble_needsRadixConversion_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return JSTypesGen.expectDouble(executeAndSpecialize(((state & 0b11100000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not parseIntNoRadix(int, Object) && parseIntInt(int, Object, BranchProfile) && parseIntDoubleToInt(double, Object) && parseIntDoubleNoRadix(double, Object) && parseIntDouble(double, Object, BranchProfile) && parseIntStringInt10(String, int) && parseIntGeneric(Object, Object, JSToStringNode, BranchProfile, BranchProfile) */ ? (Object) arguments0Value_long : ((state & 0b11010000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not parseIntNoRadix(int, Object) && parseIntInt(int, Object, BranchProfile) && parseIntDoubleToInt(double, Object) && parseIntDoubleNoRadix(double, Object) && parseIntDouble(double, Object, BranchProfile) && parseIntStringInt10(String, int) && parseIntGeneric(Object, Object, JSToStringNode, BranchProfile, BranchProfile) */ ? (Object) arguments0Value_int : (Object) arguments0Value_)), arguments1Value_));
        }

        @Override
        public int executeInt(VirtualFrame frameValue) throws UnexpectedResultException {
            int state = state_;
            if ((state & 0b1100010) != 0 /* is-active parseIntInt(int, Object, BranchProfile) || parseIntStringInt10(String, int) || parseIntGeneric(Object, Object, JSToStringNode, BranchProfile, BranchProfile) */) {
                return JSTypesGen.expectInteger(execute(frameValue));
            }
            if ((state & 0b100) == 0 /* only-active parseIntNoRadix(int, Object) */ && (state & 0b101) != 0  /* is-not parseIntNoRadix(int, Object) && parseIntDoubleToInt(double, Object) */) {
                return executeInt_int4(frameValue, state);
            } else if ((state & 0b1) == 0 /* only-active parseIntDoubleToInt(double, Object) */ && (state & 0b101) != 0  /* is-not parseIntNoRadix(int, Object) && parseIntDoubleToInt(double, Object) */) {
                return executeInt_double5(frameValue, state);
            } else {
                return executeInt_generic6(frameValue, state);
            }
        }

        private int executeInt_int4(VirtualFrame frameValue, int state) throws UnexpectedResultException {
            int arguments0Value_;
            try {
                arguments0Value_ = this.arguments0_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                Object arguments1Value = this.arguments1_.execute(frameValue);
                return JSTypesGen.expectInteger(executeAndSpecialize(ex.getResult(), arguments1Value));
            }
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            assert (state & 0b1) != 0 /* is-active parseIntNoRadix(int, Object) */;
            if ((JSGuards.isUndefined(arguments1Value_))) {
                return parseIntNoRadix(arguments0Value_, arguments1Value_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return JSTypesGen.expectInteger(executeAndSpecialize(arguments0Value_, arguments1Value_));
        }

        private int executeInt_double5(VirtualFrame frameValue, int state) throws UnexpectedResultException {
            int arguments0Value_int = 0;
            long arguments0Value_long = 0L;
            double arguments0Value_;
            try {
                if ((state & 0b11100000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not parseIntNoRadix(int, Object) && parseIntInt(int, Object, BranchProfile) && parseIntDoubleToInt(double, Object) && parseIntDoubleNoRadix(double, Object) && parseIntDouble(double, Object, BranchProfile) && parseIntStringInt10(String, int) && parseIntGeneric(Object, Object, JSToStringNode, BranchProfile, BranchProfile) */) {
                    arguments0Value_long = this.arguments0_.executeLong(frameValue);
                    arguments0Value_ = JSTypes.longToDouble(arguments0Value_long);
                } else if ((state & 0b11010000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not parseIntNoRadix(int, Object) && parseIntInt(int, Object, BranchProfile) && parseIntDoubleToInt(double, Object) && parseIntDoubleNoRadix(double, Object) && parseIntDouble(double, Object, BranchProfile) && parseIntStringInt10(String, int) && parseIntGeneric(Object, Object, JSToStringNode, BranchProfile, BranchProfile) */) {
                    arguments0Value_int = this.arguments0_.executeInt(frameValue);
                    arguments0Value_ = JSTypes.intToDouble(arguments0Value_int);
                } else if ((state & 0b10110000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not parseIntNoRadix(int, Object) && parseIntInt(int, Object, BranchProfile) && parseIntDoubleToInt(double, Object) && parseIntDoubleNoRadix(double, Object) && parseIntDouble(double, Object, BranchProfile) && parseIntStringInt10(String, int) && parseIntGeneric(Object, Object, JSToStringNode, BranchProfile, BranchProfile) */) {
                    arguments0Value_ = this.arguments0_.executeDouble(frameValue);
                } else {
                    Object arguments0Value__ = this.arguments0_.execute(frameValue);
                    arguments0Value_ = JSTypesGen.expectImplicitDouble((state & 0b11110000000) >>> 7 /* extract-implicit-active 0:double */, arguments0Value__);
                }
            } catch (UnexpectedResultException ex) {
                Object arguments1Value = this.arguments1_.execute(frameValue);
                return JSTypesGen.expectInteger(executeAndSpecialize(ex.getResult(), arguments1Value));
            }
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            assert (state & 0b100) != 0 /* is-active parseIntDoubleToInt(double, Object) */;
            if ((JSGlobalParseIntNode.hasRegularToStringInInt32Range(arguments0Value_)) && (JSGuards.isUndefined(arguments1Value_))) {
                return parseIntDoubleToInt(arguments0Value_, arguments1Value_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return JSTypesGen.expectInteger(executeAndSpecialize(((state & 0b11100000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not parseIntNoRadix(int, Object) && parseIntInt(int, Object, BranchProfile) && parseIntDoubleToInt(double, Object) && parseIntDoubleNoRadix(double, Object) && parseIntDouble(double, Object, BranchProfile) && parseIntStringInt10(String, int) && parseIntGeneric(Object, Object, JSToStringNode, BranchProfile, BranchProfile) */ ? (Object) arguments0Value_long : ((state & 0b11010000000) == 0 /* only-active 0:double */ && (state & 0b1111111) != 0  /* is-not parseIntNoRadix(int, Object) && parseIntInt(int, Object, BranchProfile) && parseIntDoubleToInt(double, Object) && parseIntDoubleNoRadix(double, Object) && parseIntDouble(double, Object, BranchProfile) && parseIntStringInt10(String, int) && parseIntGeneric(Object, Object, JSToStringNode, BranchProfile, BranchProfile) */ ? (Object) arguments0Value_int : (Object) arguments0Value_)), arguments1Value_));
        }

        private int executeInt_generic6(VirtualFrame frameValue, int state) throws UnexpectedResultException {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if ((state & 0b101) != 0 /* is-active parseIntNoRadix(int, Object) || parseIntDoubleToInt(double, Object) */) {
                if ((state & 0b1) != 0 /* is-active parseIntNoRadix(int, Object) */ && arguments0Value_ instanceof Integer) {
                    int arguments0Value__ = (int) arguments0Value_;
                    if ((JSGuards.isUndefined(arguments1Value_))) {
                        return parseIntNoRadix(arguments0Value__, arguments1Value_);
                    }
                }
                if ((state & 0b100) != 0 /* is-active parseIntDoubleToInt(double, Object) */ && JSTypesGen.isImplicitDouble((state & 0b11110000000) >>> 7 /* extract-implicit-active 0:double */, arguments0Value_)) {
                    double arguments0Value__ = JSTypesGen.asImplicitDouble((state & 0b11110000000) >>> 7 /* extract-implicit-active 0:double */, arguments0Value_);
                    if ((JSGlobalParseIntNode.hasRegularToStringInInt32Range(arguments0Value__)) && (JSGuards.isUndefined(arguments1Value_))) {
                        return parseIntDoubleToInt(arguments0Value__, arguments1Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return JSTypesGen.expectInteger(executeAndSpecialize(arguments0Value_, arguments1Value_));
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            int state = state_;
            try {
                if ((state & 0b1111010) == 0 /* only-active parseIntNoRadix(int, Object) && parseIntDoubleToInt(double, Object) */ && (state & 0b1111111) != 0  /* is-not parseIntNoRadix(int, Object) && parseIntInt(int, Object, BranchProfile) && parseIntDoubleToInt(double, Object) && parseIntDoubleNoRadix(double, Object) && parseIntDouble(double, Object, BranchProfile) && parseIntStringInt10(String, int) && parseIntGeneric(Object, Object, JSToStringNode, BranchProfile, BranchProfile) */) {
                    executeInt(frameValue);
                    return;
                } else if ((state & 0b1100111) == 0 /* only-active parseIntDoubleNoRadix(double, Object) && parseIntDouble(double, Object, BranchProfile) */ && (state & 0b1111111) != 0  /* is-not parseIntNoRadix(int, Object) && parseIntInt(int, Object, BranchProfile) && parseIntDoubleToInt(double, Object) && parseIntDoubleNoRadix(double, Object) && parseIntDouble(double, Object, BranchProfile) && parseIntStringInt10(String, int) && parseIntGeneric(Object, Object, JSToStringNode, BranchProfile, BranchProfile) */) {
                    executeDouble(frameValue);
                    return;
                }
                execute(frameValue);
                return;
            } catch (UnexpectedResultException ex) {
                return;
            }
        }

        private Object executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            try {
                if (arguments0Value instanceof Integer) {
                    int arguments0Value_ = (int) arguments0Value;
                    if ((JSGuards.isUndefined(arguments1Value))) {
                        this.state_ = state = state | 0b1 /* add-active parseIntNoRadix(int, Object) */;
                        lock.unlock();
                        hasLock = false;
                        return parseIntNoRadix(arguments0Value_, arguments1Value);
                    }
                    if ((!(JSGuards.isUndefined(arguments1Value)))) {
                        this.parseIntInt_needsRadixConversion_ = (BranchProfile.create());
                        this.state_ = state = state | 0b10 /* add-active parseIntInt(int, Object, BranchProfile) */;
                        lock.unlock();
                        hasLock = false;
                        return parseIntInt(arguments0Value_, arguments1Value, this.parseIntInt_needsRadixConversion_);
                    }
                }
                {
                    int doubleCast0;
                    if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(arguments0Value)) != 0) {
                        double arguments0Value_ = JSTypesGen.asImplicitDouble(doubleCast0, arguments0Value);
                        if ((JSGlobalParseIntNode.hasRegularToStringInInt32Range(arguments0Value_)) && (JSGuards.isUndefined(arguments1Value))) {
                            state = (state | (doubleCast0 << 7) /* set-implicit-active 0:double */);
                            this.state_ = state = state | 0b100 /* add-active parseIntDoubleToInt(double, Object) */;
                            lock.unlock();
                            hasLock = false;
                            return parseIntDoubleToInt(arguments0Value_, arguments1Value);
                        }
                        if ((JSGlobalParseIntNode.hasRegularToString(arguments0Value_)) && (JSGuards.isUndefined(arguments1Value))) {
                            state = (state | (doubleCast0 << 7) /* set-implicit-active 0:double */);
                            this.state_ = state = state | 0b1000 /* add-active parseIntDoubleNoRadix(double, Object) */;
                            lock.unlock();
                            hasLock = false;
                            return parseIntDoubleNoRadix(arguments0Value_, arguments1Value);
                        }
                        if ((JSGlobalParseIntNode.hasRegularToString(arguments0Value_))) {
                            this.parseIntDouble_needsRadixConversion_ = (BranchProfile.create());
                            state = (state | (doubleCast0 << 7) /* set-implicit-active 0:double */);
                            this.state_ = state = state | 0b10000 /* add-active parseIntDouble(double, Object, BranchProfile) */;
                            lock.unlock();
                            hasLock = false;
                            return parseIntDouble(arguments0Value_, arguments1Value, this.parseIntDouble_needsRadixConversion_);
                        }
                    }
                }
                {
                    int stringCast0;
                    if ((stringCast0 = JSTypesGen.specializeImplicitString(arguments0Value)) != 0) {
                        String arguments0Value_ = JSTypesGen.asImplicitString(stringCast0, arguments0Value);
                        if (arguments1Value instanceof Integer) {
                            int arguments1Value_ = (int) arguments1Value;
                            if ((arguments1Value_ == 10) && (arguments0Value_.length() < 15)) {
                                state = (state | (stringCast0 << 11) /* set-implicit-active 0:String */);
                                this.state_ = state = state | 0b100000 /* add-active parseIntStringInt10(String, int) */;
                                lock.unlock();
                                hasLock = false;
                                return parseIntStringInt10(arguments0Value_, arguments1Value_);
                            }
                        }
                    }
                }
                if ((!(JSGlobalParseIntNode.isShortStringInt10(arguments0Value, arguments1Value)))) {
                    ParseIntGenericData s7_ = super.insert(new ParseIntGenericData());
                    s7_.toStringNode_ = s7_.insertAccessor((JSToStringNode.create()));
                    s7_.needsRadix16_ = (BranchProfile.create());
                    s7_.needsDontFitLong_ = (BranchProfile.create());
                    this.parseIntGeneric_cache = s7_;
                    this.state_ = state = state | 0b1000000 /* add-active parseIntGeneric(Object, Object, JSToStringNode, BranchProfile, BranchProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return parseIntGeneric(arguments0Value, arguments1Value, s7_.toStringNode_, s7_.needsRadix16_, s7_.needsDontFitLong_);
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
            if ((state & 0b1111111) == 0b0) {
                return NodeCost.UNINITIALIZED;
            } else if (((state & 0b1111111) & ((state & 0b1111111) - 1)) == 0 /* is-single-active  */) {
                return NodeCost.MONOMORPHIC;
            }
            return NodeCost.POLYMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[8];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "parseIntNoRadix";
            if ((state & 0b1) != 0 /* is-active parseIntNoRadix(int, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "parseIntInt";
            if ((state & 0b10) != 0 /* is-active parseIntInt(int, Object, BranchProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.parseIntInt_needsRadixConversion_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "parseIntDoubleToInt";
            if ((state & 0b100) != 0 /* is-active parseIntDoubleToInt(double, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "parseIntDoubleNoRadix";
            if ((state & 0b1000) != 0 /* is-active parseIntDoubleNoRadix(double, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            s = new Object[3];
            s[0] = "parseIntDouble";
            if ((state & 0b10000) != 0 /* is-active parseIntDouble(double, Object, BranchProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.parseIntDouble_needsRadixConversion_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[5] = s;
            s = new Object[3];
            s[0] = "parseIntStringInt10";
            if ((state & 0b100000) != 0 /* is-active parseIntStringInt10(String, int) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[6] = s;
            s = new Object[3];
            s[0] = "parseIntGeneric";
            if ((state & 0b1000000) != 0 /* is-active parseIntGeneric(Object, Object, JSToStringNode, BranchProfile, BranchProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                ParseIntGenericData s7_ = this.parseIntGeneric_cache;
                if (s7_ != null) {
                    cached.add(Arrays.asList(s7_.toStringNode_, s7_.needsRadix16_, s7_.needsDontFitLong_));
                }
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[7] = s;
            return Provider.create(data);
        }

        public static JSGlobalParseIntNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSGlobalParseIntNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(JSGlobalParseIntNode.class)
        private static final class ParseIntGenericData extends Node {

            @Child JSToStringNode toStringNode_;
            @CompilationFinal BranchProfile needsRadix16_;
            @CompilationFinal BranchProfile needsDontFitLong_;

            ParseIntGenericData() {
            }

            @Override
            public NodeCost getCost() {
                return NodeCost.NONE;
            }

            <T extends Node> T insertAccessor(T node) {
                return super.insert(node);
            }

        }
    }
    @GeneratedBy(JSGlobalEncodeURINode.class)
    public static final class JSGlobalEncodeURINodeGen extends JSGlobalEncodeURINode implements Provider {

        @Child private JavaScriptNode arguments0_;

        private JSGlobalEncodeURINodeGen(JSContext context, JSBuiltin builtin, boolean isSpecial, JavaScriptNode[] arguments) {
            super(context, builtin, isSpecial);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return encodeURI(arguments0Value_);
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
            s[0] = "encodeURI";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSGlobalEncodeURINode create(JSContext context, JSBuiltin builtin, boolean isSpecial, JavaScriptNode[] arguments) {
            return new JSGlobalEncodeURINodeGen(context, builtin, isSpecial, arguments);
        }

    }
    @GeneratedBy(JSGlobalDecodeURINode.class)
    public static final class JSGlobalDecodeURINodeGen extends JSGlobalDecodeURINode implements Provider {

        @Child private JavaScriptNode arguments0_;

        private JSGlobalDecodeURINodeGen(JSContext context, JSBuiltin builtin, boolean isSpecial, JavaScriptNode[] arguments) {
            super(context, builtin, isSpecial);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return decodeURI(arguments0Value_);
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
            s[0] = "decodeURI";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSGlobalDecodeURINode create(JSContext context, JSBuiltin builtin, boolean isSpecial, JavaScriptNode[] arguments) {
            return new JSGlobalDecodeURINodeGen(context, builtin, isSpecial, arguments);
        }

    }
    @GeneratedBy(JSGlobalIndirectEvalNode.class)
    public static final class JSGlobalIndirectEvalNodeGen extends JSGlobalIndirectEvalNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_;
        @CompilationFinal private volatile int exclude_;
        @Child private IndirectEvalForeignObject0Data indirectEvalForeignObject0_cache;

        private JSGlobalIndirectEvalNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state & 0b11111110111) == 0 /* only-active indirectEvalInt(int) */ && (state & 0b11111111111) != 0  /* is-not indirectEvalString(String) && indirectEvalForeignObject(Object, InteropLibrary) && indirectEvalForeignObject(Object, InteropLibrary) && indirectEvalInt(int) && indirectEvalSafeInteger(SafeInteger) && indirectEvalLong(long) && indirectEvalDouble(double) && indirectEvalBoolean(boolean) && indirectEvalSymbol(Symbol) && indirectEvalBigInt(BigInt) && indirectEvalJSType(DynamicObject) */) {
                return execute_int0(frameValue, state);
            } else if ((state & 0b11111011111) == 0 /* only-active indirectEvalLong(long) */ && (state & 0b11111111111) != 0  /* is-not indirectEvalString(String) && indirectEvalForeignObject(Object, InteropLibrary) && indirectEvalForeignObject(Object, InteropLibrary) && indirectEvalInt(int) && indirectEvalSafeInteger(SafeInteger) && indirectEvalLong(long) && indirectEvalDouble(double) && indirectEvalBoolean(boolean) && indirectEvalSymbol(Symbol) && indirectEvalBigInt(BigInt) && indirectEvalJSType(DynamicObject) */) {
                return execute_long1(frameValue, state);
            } else if ((state & 0b11110111111) == 0 /* only-active indirectEvalDouble(double) */ && (state & 0b11111111111) != 0  /* is-not indirectEvalString(String) && indirectEvalForeignObject(Object, InteropLibrary) && indirectEvalForeignObject(Object, InteropLibrary) && indirectEvalInt(int) && indirectEvalSafeInteger(SafeInteger) && indirectEvalLong(long) && indirectEvalDouble(double) && indirectEvalBoolean(boolean) && indirectEvalSymbol(Symbol) && indirectEvalBigInt(BigInt) && indirectEvalJSType(DynamicObject) */) {
                return execute_double2(frameValue, state);
            } else if ((state & 0b11101111111) == 0 /* only-active indirectEvalBoolean(boolean) */ && (state & 0b11111111111) != 0  /* is-not indirectEvalString(String) && indirectEvalForeignObject(Object, InteropLibrary) && indirectEvalForeignObject(Object, InteropLibrary) && indirectEvalInt(int) && indirectEvalSafeInteger(SafeInteger) && indirectEvalLong(long) && indirectEvalDouble(double) && indirectEvalBoolean(boolean) && indirectEvalSymbol(Symbol) && indirectEvalBigInt(BigInt) && indirectEvalJSType(DynamicObject) */) {
                return execute_boolean3(frameValue, state);
            } else {
                return execute_generic4(frameValue, state);
            }
        }

        private Object execute_int0(VirtualFrame frameValue, int state) {
            int arguments0Value_;
            try {
                arguments0Value_ = this.arguments0_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(ex.getResult());
            }
            assert (state & 0b1000) != 0 /* is-active indirectEvalInt(int) */;
            return indirectEvalInt(arguments0Value_);
        }

        private Object execute_long1(VirtualFrame frameValue, int state) {
            long arguments0Value_;
            try {
                arguments0Value_ = this.arguments0_.executeLong(frameValue);
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(ex.getResult());
            }
            assert (state & 0b100000) != 0 /* is-active indirectEvalLong(long) */;
            return indirectEvalLong(arguments0Value_);
        }

        private Object execute_double2(VirtualFrame frameValue, int state) {
            int arguments0Value_int = 0;
            long arguments0Value_long = 0L;
            double arguments0Value_;
            try {
                if ((state & 0x70000) == 0 /* only-active 0:double */ && (state & 0b11111111111) != 0  /* is-not indirectEvalString(String) && indirectEvalForeignObject(Object, InteropLibrary) && indirectEvalForeignObject(Object, InteropLibrary) && indirectEvalInt(int) && indirectEvalSafeInteger(SafeInteger) && indirectEvalLong(long) && indirectEvalDouble(double) && indirectEvalBoolean(boolean) && indirectEvalSymbol(Symbol) && indirectEvalBigInt(BigInt) && indirectEvalJSType(DynamicObject) */) {
                    arguments0Value_long = this.arguments0_.executeLong(frameValue);
                    arguments0Value_ = JSTypes.longToDouble(arguments0Value_long);
                } else if ((state & 0x68000) == 0 /* only-active 0:double */ && (state & 0b11111111111) != 0  /* is-not indirectEvalString(String) && indirectEvalForeignObject(Object, InteropLibrary) && indirectEvalForeignObject(Object, InteropLibrary) && indirectEvalInt(int) && indirectEvalSafeInteger(SafeInteger) && indirectEvalLong(long) && indirectEvalDouble(double) && indirectEvalBoolean(boolean) && indirectEvalSymbol(Symbol) && indirectEvalBigInt(BigInt) && indirectEvalJSType(DynamicObject) */) {
                    arguments0Value_int = this.arguments0_.executeInt(frameValue);
                    arguments0Value_ = JSTypes.intToDouble(arguments0Value_int);
                } else if ((state & 0x58000) == 0 /* only-active 0:double */ && (state & 0b11111111111) != 0  /* is-not indirectEvalString(String) && indirectEvalForeignObject(Object, InteropLibrary) && indirectEvalForeignObject(Object, InteropLibrary) && indirectEvalInt(int) && indirectEvalSafeInteger(SafeInteger) && indirectEvalLong(long) && indirectEvalDouble(double) && indirectEvalBoolean(boolean) && indirectEvalSymbol(Symbol) && indirectEvalBigInt(BigInt) && indirectEvalJSType(DynamicObject) */) {
                    arguments0Value_ = this.arguments0_.executeDouble(frameValue);
                } else {
                    Object arguments0Value__ = this.arguments0_.execute(frameValue);
                    arguments0Value_ = JSTypesGen.expectImplicitDouble((state & 0x78000) >>> 15 /* extract-implicit-active 0:double */, arguments0Value__);
                }
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(ex.getResult());
            }
            assert (state & 0b1000000) != 0 /* is-active indirectEvalDouble(double) */;
            return indirectEvalDouble(arguments0Value_);
        }

        private Object execute_boolean3(VirtualFrame frameValue, int state) {
            boolean arguments0Value_;
            try {
                arguments0Value_ = this.arguments0_.executeBoolean(frameValue);
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(ex.getResult());
            }
            assert (state & 0b10000000) != 0 /* is-active indirectEvalBoolean(boolean) */;
            return indirectEvalBoolean(arguments0Value_);
        }

        @TruffleBoundary
        private Object indirectEvalForeignObject1Boundary(int state, Object arguments0Value_) {
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(this);
            try {
                {
                    InteropLibrary indirectEvalForeignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value_));
                    return indirectEvalForeignObject(arguments0Value_, indirectEvalForeignObject1_interop__);
                }
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @ExplodeLoop
        private Object execute_generic4(VirtualFrame frameValue, int state) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state & 0b1) != 0 /* is-active indirectEvalString(String) */ && JSTypesGen.isImplicitString((state & 0b111100000000000) >>> 11 /* extract-implicit-active 0:String */, arguments0Value_)) {
                String arguments0Value__ = JSTypesGen.asImplicitString((state & 0b111100000000000) >>> 11 /* extract-implicit-active 0:String */, arguments0Value_);
                return indirectEvalString(arguments0Value__);
            }
            if ((state & 0b110) != 0 /* is-active indirectEvalForeignObject(Object, InteropLibrary) || indirectEvalForeignObject(Object, InteropLibrary) */) {
                if ((state & 0b10) != 0 /* is-active indirectEvalForeignObject(Object, InteropLibrary) */) {
                    IndirectEvalForeignObject0Data s2_ = this.indirectEvalForeignObject0_cache;
                    while (s2_ != null) {
                        if ((s2_.interop_.accepts(arguments0Value_)) && (JSGuards.isForeignObject(arguments0Value_))) {
                            return indirectEvalForeignObject(arguments0Value_, s2_.interop_);
                        }
                        s2_ = s2_.next_;
                    }
                }
                if ((state & 0b100) != 0 /* is-active indirectEvalForeignObject(Object, InteropLibrary) */) {
                    if ((JSGuards.isForeignObject(arguments0Value_))) {
                        return this.indirectEvalForeignObject1Boundary(state, arguments0Value_);
                    }
                }
            }
            if ((state & 0b1000) != 0 /* is-active indirectEvalInt(int) */ && arguments0Value_ instanceof Integer) {
                int arguments0Value__ = (int) arguments0Value_;
                return indirectEvalInt(arguments0Value__);
            }
            if ((state & 0b10000) != 0 /* is-active indirectEvalSafeInteger(SafeInteger) */ && arguments0Value_ instanceof SafeInteger) {
                SafeInteger arguments0Value__ = (SafeInteger) arguments0Value_;
                return indirectEvalSafeInteger(arguments0Value__);
            }
            if ((state & 0b100000) != 0 /* is-active indirectEvalLong(long) */ && arguments0Value_ instanceof Long) {
                long arguments0Value__ = (long) arguments0Value_;
                return indirectEvalLong(arguments0Value__);
            }
            if ((state & 0b1000000) != 0 /* is-active indirectEvalDouble(double) */ && JSTypesGen.isImplicitDouble((state & 0x78000) >>> 15 /* extract-implicit-active 0:double */, arguments0Value_)) {
                double arguments0Value__ = JSTypesGen.asImplicitDouble((state & 0x78000) >>> 15 /* extract-implicit-active 0:double */, arguments0Value_);
                return indirectEvalDouble(arguments0Value__);
            }
            if ((state & 0b10000000) != 0 /* is-active indirectEvalBoolean(boolean) */ && arguments0Value_ instanceof Boolean) {
                boolean arguments0Value__ = (boolean) arguments0Value_;
                return indirectEvalBoolean(arguments0Value__);
            }
            if ((state & 0b100000000) != 0 /* is-active indirectEvalSymbol(Symbol) */ && arguments0Value_ instanceof Symbol) {
                Symbol arguments0Value__ = (Symbol) arguments0Value_;
                return indirectEvalSymbol(arguments0Value__);
            }
            if ((state & 0b1000000000) != 0 /* is-active indirectEvalBigInt(BigInt) */ && arguments0Value_ instanceof BigInt) {
                BigInt arguments0Value__ = (BigInt) arguments0Value_;
                return indirectEvalBigInt(arguments0Value__);
            }
            if ((state & 0b10000000000) != 0 /* is-active indirectEvalJSType(DynamicObject) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((JSGuards.isJSDynamicObject(arguments0Value__))) {
                    return indirectEvalJSType(arguments0Value__);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) throws UnexpectedResultException {
            int state = state_;
            if ((state & 0b111) != 0 /* is-active indirectEvalString(String) || indirectEvalForeignObject(Object, InteropLibrary) || indirectEvalForeignObject(Object, InteropLibrary) */) {
                return JSTypesGen.expectBoolean(execute(frameValue));
            }
            boolean arguments0Value_;
            try {
                arguments0Value_ = this.arguments0_.executeBoolean(frameValue);
            } catch (UnexpectedResultException ex) {
                return JSTypesGen.expectBoolean(executeAndSpecialize(ex.getResult()));
            }
            if ((state & 0b10000000) != 0 /* is-active indirectEvalBoolean(boolean) */) {
                return indirectEvalBoolean(arguments0Value_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return JSTypesGen.expectBoolean(executeAndSpecialize(arguments0Value_));
        }

        @Override
        public double executeDouble(VirtualFrame frameValue) throws UnexpectedResultException {
            int state = state_;
            if ((state & 0b111) != 0 /* is-active indirectEvalString(String) || indirectEvalForeignObject(Object, InteropLibrary) || indirectEvalForeignObject(Object, InteropLibrary) */) {
                return JSTypesGen.expectDouble(execute(frameValue));
            }
            int arguments0Value_int = 0;
            long arguments0Value_long = 0L;
            double arguments0Value_;
            try {
                if ((state & 0x70000) == 0 /* only-active 0:double */ && (state & 0b11111111111) != 0  /* is-not indirectEvalString(String) && indirectEvalForeignObject(Object, InteropLibrary) && indirectEvalForeignObject(Object, InteropLibrary) && indirectEvalInt(int) && indirectEvalSafeInteger(SafeInteger) && indirectEvalLong(long) && indirectEvalDouble(double) && indirectEvalBoolean(boolean) && indirectEvalSymbol(Symbol) && indirectEvalBigInt(BigInt) && indirectEvalJSType(DynamicObject) */) {
                    arguments0Value_long = this.arguments0_.executeLong(frameValue);
                    arguments0Value_ = JSTypes.longToDouble(arguments0Value_long);
                } else if ((state & 0x68000) == 0 /* only-active 0:double */ && (state & 0b11111111111) != 0  /* is-not indirectEvalString(String) && indirectEvalForeignObject(Object, InteropLibrary) && indirectEvalForeignObject(Object, InteropLibrary) && indirectEvalInt(int) && indirectEvalSafeInteger(SafeInteger) && indirectEvalLong(long) && indirectEvalDouble(double) && indirectEvalBoolean(boolean) && indirectEvalSymbol(Symbol) && indirectEvalBigInt(BigInt) && indirectEvalJSType(DynamicObject) */) {
                    arguments0Value_int = this.arguments0_.executeInt(frameValue);
                    arguments0Value_ = JSTypes.intToDouble(arguments0Value_int);
                } else if ((state & 0x58000) == 0 /* only-active 0:double */ && (state & 0b11111111111) != 0  /* is-not indirectEvalString(String) && indirectEvalForeignObject(Object, InteropLibrary) && indirectEvalForeignObject(Object, InteropLibrary) && indirectEvalInt(int) && indirectEvalSafeInteger(SafeInteger) && indirectEvalLong(long) && indirectEvalDouble(double) && indirectEvalBoolean(boolean) && indirectEvalSymbol(Symbol) && indirectEvalBigInt(BigInt) && indirectEvalJSType(DynamicObject) */) {
                    arguments0Value_ = this.arguments0_.executeDouble(frameValue);
                } else {
                    Object arguments0Value__ = this.arguments0_.execute(frameValue);
                    arguments0Value_ = JSTypesGen.expectImplicitDouble((state & 0x78000) >>> 15 /* extract-implicit-active 0:double */, arguments0Value__);
                }
            } catch (UnexpectedResultException ex) {
                return JSTypesGen.expectDouble(executeAndSpecialize(ex.getResult()));
            }
            if ((state & 0b1000000) != 0 /* is-active indirectEvalDouble(double) */) {
                return indirectEvalDouble(arguments0Value_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return JSTypesGen.expectDouble(executeAndSpecialize(((state & 0x70000) == 0 /* only-active 0:double */ && (state & 0b11111111111) != 0  /* is-not indirectEvalString(String) && indirectEvalForeignObject(Object, InteropLibrary) && indirectEvalForeignObject(Object, InteropLibrary) && indirectEvalInt(int) && indirectEvalSafeInteger(SafeInteger) && indirectEvalLong(long) && indirectEvalDouble(double) && indirectEvalBoolean(boolean) && indirectEvalSymbol(Symbol) && indirectEvalBigInt(BigInt) && indirectEvalJSType(DynamicObject) */ ? (Object) arguments0Value_long : ((state & 0x68000) == 0 /* only-active 0:double */ && (state & 0b11111111111) != 0  /* is-not indirectEvalString(String) && indirectEvalForeignObject(Object, InteropLibrary) && indirectEvalForeignObject(Object, InteropLibrary) && indirectEvalInt(int) && indirectEvalSafeInteger(SafeInteger) && indirectEvalLong(long) && indirectEvalDouble(double) && indirectEvalBoolean(boolean) && indirectEvalSymbol(Symbol) && indirectEvalBigInt(BigInt) && indirectEvalJSType(DynamicObject) */ ? (Object) arguments0Value_int : (Object) arguments0Value_))));
        }

        @Override
        public int executeInt(VirtualFrame frameValue) throws UnexpectedResultException {
            int state = state_;
            if ((state & 0b111) != 0 /* is-active indirectEvalString(String) || indirectEvalForeignObject(Object, InteropLibrary) || indirectEvalForeignObject(Object, InteropLibrary) */) {
                return JSTypesGen.expectInteger(execute(frameValue));
            }
            int arguments0Value_;
            try {
                arguments0Value_ = this.arguments0_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                return JSTypesGen.expectInteger(executeAndSpecialize(ex.getResult()));
            }
            if ((state & 0b1000) != 0 /* is-active indirectEvalInt(int) */) {
                return indirectEvalInt(arguments0Value_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return JSTypesGen.expectInteger(executeAndSpecialize(arguments0Value_));
        }

        @Override
        public long executeLong(VirtualFrame frameValue) throws UnexpectedResultException {
            int state = state_;
            if ((state & 0b111) != 0 /* is-active indirectEvalString(String) || indirectEvalForeignObject(Object, InteropLibrary) || indirectEvalForeignObject(Object, InteropLibrary) */) {
                return JSTypesGen.expectLong(execute(frameValue));
            }
            long arguments0Value_;
            try {
                arguments0Value_ = this.arguments0_.executeLong(frameValue);
            } catch (UnexpectedResultException ex) {
                return JSTypesGen.expectLong(executeAndSpecialize(ex.getResult()));
            }
            if ((state & 0b100000) != 0 /* is-active indirectEvalLong(long) */) {
                return indirectEvalLong(arguments0Value_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return JSTypesGen.expectLong(executeAndSpecialize(arguments0Value_));
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            int state = state_;
            try {
                if ((state & 0b11111011111) == 0 /* only-active indirectEvalLong(long) */ && (state & 0b11111111111) != 0  /* is-not indirectEvalString(String) && indirectEvalForeignObject(Object, InteropLibrary) && indirectEvalForeignObject(Object, InteropLibrary) && indirectEvalInt(int) && indirectEvalSafeInteger(SafeInteger) && indirectEvalLong(long) && indirectEvalDouble(double) && indirectEvalBoolean(boolean) && indirectEvalSymbol(Symbol) && indirectEvalBigInt(BigInt) && indirectEvalJSType(DynamicObject) */) {
                    executeLong(frameValue);
                    return;
                } else if ((state & 0b11111110111) == 0 /* only-active indirectEvalInt(int) */ && (state & 0b11111111111) != 0  /* is-not indirectEvalString(String) && indirectEvalForeignObject(Object, InteropLibrary) && indirectEvalForeignObject(Object, InteropLibrary) && indirectEvalInt(int) && indirectEvalSafeInteger(SafeInteger) && indirectEvalLong(long) && indirectEvalDouble(double) && indirectEvalBoolean(boolean) && indirectEvalSymbol(Symbol) && indirectEvalBigInt(BigInt) && indirectEvalJSType(DynamicObject) */) {
                    executeInt(frameValue);
                    return;
                } else if ((state & 0b11110111111) == 0 /* only-active indirectEvalDouble(double) */ && (state & 0b11111111111) != 0  /* is-not indirectEvalString(String) && indirectEvalForeignObject(Object, InteropLibrary) && indirectEvalForeignObject(Object, InteropLibrary) && indirectEvalInt(int) && indirectEvalSafeInteger(SafeInteger) && indirectEvalLong(long) && indirectEvalDouble(double) && indirectEvalBoolean(boolean) && indirectEvalSymbol(Symbol) && indirectEvalBigInt(BigInt) && indirectEvalJSType(DynamicObject) */) {
                    executeDouble(frameValue);
                    return;
                } else if ((state & 0b11101111111) == 0 /* only-active indirectEvalBoolean(boolean) */ && (state & 0b11111111111) != 0  /* is-not indirectEvalString(String) && indirectEvalForeignObject(Object, InteropLibrary) && indirectEvalForeignObject(Object, InteropLibrary) && indirectEvalInt(int) && indirectEvalSafeInteger(SafeInteger) && indirectEvalLong(long) && indirectEvalDouble(double) && indirectEvalBoolean(boolean) && indirectEvalSymbol(Symbol) && indirectEvalBigInt(BigInt) && indirectEvalJSType(DynamicObject) */) {
                    executeBoolean(frameValue);
                    return;
                }
                execute(frameValue);
                return;
            } catch (UnexpectedResultException ex) {
                return;
            }
        }

        private Object executeAndSpecialize(Object arguments0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int exclude = exclude_;
            try {
                {
                    int stringCast0;
                    if ((stringCast0 = JSTypesGen.specializeImplicitString(arguments0Value)) != 0) {
                        String arguments0Value_ = JSTypesGen.asImplicitString(stringCast0, arguments0Value);
                        state = (state | (stringCast0 << 11) /* set-implicit-active 0:String */);
                        this.state_ = state = state | 0b1 /* add-active indirectEvalString(String) */;
                        lock.unlock();
                        hasLock = false;
                        return indirectEvalString(arguments0Value_);
                    }
                }
                if ((exclude) == 0 /* is-not-excluded indirectEvalForeignObject(Object, InteropLibrary) */) {
                    int count2_ = 0;
                    IndirectEvalForeignObject0Data s2_ = this.indirectEvalForeignObject0_cache;
                    if ((state & 0b10) != 0 /* is-active indirectEvalForeignObject(Object, InteropLibrary) */) {
                        while (s2_ != null) {
                            if ((s2_.interop_.accepts(arguments0Value)) && (JSGuards.isForeignObject(arguments0Value))) {
                                break;
                            }
                            s2_ = s2_.next_;
                            count2_++;
                        }
                    }
                    if (s2_ == null) {
                        if ((JSGuards.isForeignObject(arguments0Value)) && count2_ < (3)) {
                            // assert (s2_.interop_.accepts(arguments0Value));
                            s2_ = super.insert(new IndirectEvalForeignObject0Data(indirectEvalForeignObject0_cache));
                            s2_.interop_ = s2_.insertAccessor((INTEROP_LIBRARY_.create(arguments0Value)));
                            this.indirectEvalForeignObject0_cache = s2_;
                            this.state_ = state = state | 0b10 /* add-active indirectEvalForeignObject(Object, InteropLibrary) */;
                        }
                    }
                    if (s2_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return indirectEvalForeignObject(arguments0Value, s2_.interop_);
                    }
                }
                {
                    InteropLibrary indirectEvalForeignObject1_interop__ = null;
                    {
                        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                        Node prev_ = encapsulating_.set(this);
                        try {
                            if ((JSGuards.isForeignObject(arguments0Value))) {
                                indirectEvalForeignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value));
                                this.exclude_ = exclude = exclude | 0b1 /* add-excluded indirectEvalForeignObject(Object, InteropLibrary) */;
                                this.indirectEvalForeignObject0_cache = null;
                                state = state & 0xfffffffd /* remove-active indirectEvalForeignObject(Object, InteropLibrary) */;
                                this.state_ = state = state | 0b100 /* add-active indirectEvalForeignObject(Object, InteropLibrary) */;
                                lock.unlock();
                                hasLock = false;
                                return indirectEvalForeignObject(arguments0Value, indirectEvalForeignObject1_interop__);
                            }
                        } finally {
                            encapsulating_.set(prev_);
                        }
                    }
                }
                if (arguments0Value instanceof Integer) {
                    int arguments0Value_ = (int) arguments0Value;
                    this.state_ = state = state | 0b1000 /* add-active indirectEvalInt(int) */;
                    lock.unlock();
                    hasLock = false;
                    return indirectEvalInt(arguments0Value_);
                }
                if (arguments0Value instanceof SafeInteger) {
                    SafeInteger arguments0Value_ = (SafeInteger) arguments0Value;
                    this.state_ = state = state | 0b10000 /* add-active indirectEvalSafeInteger(SafeInteger) */;
                    lock.unlock();
                    hasLock = false;
                    return indirectEvalSafeInteger(arguments0Value_);
                }
                if (arguments0Value instanceof Long) {
                    long arguments0Value_ = (long) arguments0Value;
                    this.state_ = state = state | 0b100000 /* add-active indirectEvalLong(long) */;
                    lock.unlock();
                    hasLock = false;
                    return indirectEvalLong(arguments0Value_);
                }
                {
                    int doubleCast0;
                    if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(arguments0Value)) != 0) {
                        double arguments0Value_ = JSTypesGen.asImplicitDouble(doubleCast0, arguments0Value);
                        state = (state | (doubleCast0 << 15) /* set-implicit-active 0:double */);
                        this.state_ = state = state | 0b1000000 /* add-active indirectEvalDouble(double) */;
                        lock.unlock();
                        hasLock = false;
                        return indirectEvalDouble(arguments0Value_);
                    }
                }
                if (arguments0Value instanceof Boolean) {
                    boolean arguments0Value_ = (boolean) arguments0Value;
                    this.state_ = state = state | 0b10000000 /* add-active indirectEvalBoolean(boolean) */;
                    lock.unlock();
                    hasLock = false;
                    return indirectEvalBoolean(arguments0Value_);
                }
                if (arguments0Value instanceof Symbol) {
                    Symbol arguments0Value_ = (Symbol) arguments0Value;
                    this.state_ = state = state | 0b100000000 /* add-active indirectEvalSymbol(Symbol) */;
                    lock.unlock();
                    hasLock = false;
                    return indirectEvalSymbol(arguments0Value_);
                }
                if (arguments0Value instanceof BigInt) {
                    BigInt arguments0Value_ = (BigInt) arguments0Value;
                    this.state_ = state = state | 0b1000000000 /* add-active indirectEvalBigInt(BigInt) */;
                    lock.unlock();
                    hasLock = false;
                    return indirectEvalBigInt(arguments0Value_);
                }
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSDynamicObject(arguments0Value_))) {
                        this.state_ = state = state | 0b10000000000 /* add-active indirectEvalJSType(DynamicObject) */;
                        lock.unlock();
                        hasLock = false;
                        return indirectEvalJSType(arguments0Value_);
                    }
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
            if ((state & 0b11111111111) == 0b0) {
                return NodeCost.UNINITIALIZED;
            } else if (((state & 0b11111111111) & ((state & 0b11111111111) - 1)) == 0 /* is-single-active  */) {
                IndirectEvalForeignObject0Data s2_ = this.indirectEvalForeignObject0_cache;
                if ((s2_ == null || s2_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[12];
            Object[] s;
            data[0] = 0;
            int state = state_;
            int exclude = exclude_;
            s = new Object[3];
            s[0] = "indirectEvalString";
            if ((state & 0b1) != 0 /* is-active indirectEvalString(String) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "indirectEvalForeignObject";
            if ((state & 0b10) != 0 /* is-active indirectEvalForeignObject(Object, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                IndirectEvalForeignObject0Data s2_ = this.indirectEvalForeignObject0_cache;
                while (s2_ != null) {
                    cached.add(Arrays.asList(s2_.interop_));
                    s2_ = s2_.next_;
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-excluded indirectEvalForeignObject(Object, InteropLibrary) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "indirectEvalForeignObject";
            if ((state & 0b100) != 0 /* is-active indirectEvalForeignObject(Object, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList());
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "indirectEvalInt";
            if ((state & 0b1000) != 0 /* is-active indirectEvalInt(int) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            s = new Object[3];
            s[0] = "indirectEvalSafeInteger";
            if ((state & 0b10000) != 0 /* is-active indirectEvalSafeInteger(SafeInteger) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[5] = s;
            s = new Object[3];
            s[0] = "indirectEvalLong";
            if ((state & 0b100000) != 0 /* is-active indirectEvalLong(long) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[6] = s;
            s = new Object[3];
            s[0] = "indirectEvalDouble";
            if ((state & 0b1000000) != 0 /* is-active indirectEvalDouble(double) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[7] = s;
            s = new Object[3];
            s[0] = "indirectEvalBoolean";
            if ((state & 0b10000000) != 0 /* is-active indirectEvalBoolean(boolean) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[8] = s;
            s = new Object[3];
            s[0] = "indirectEvalSymbol";
            if ((state & 0b100000000) != 0 /* is-active indirectEvalSymbol(Symbol) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[9] = s;
            s = new Object[3];
            s[0] = "indirectEvalBigInt";
            if ((state & 0b1000000000) != 0 /* is-active indirectEvalBigInt(BigInt) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[10] = s;
            s = new Object[3];
            s[0] = "indirectEvalJSType";
            if ((state & 0b10000000000) != 0 /* is-active indirectEvalJSType(DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[11] = s;
            return Provider.create(data);
        }

        public static JSGlobalIndirectEvalNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSGlobalIndirectEvalNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(JSGlobalIndirectEvalNode.class)
        private static final class IndirectEvalForeignObject0Data extends Node {

            @Child IndirectEvalForeignObject0Data next_;
            @Child InteropLibrary interop_;

            IndirectEvalForeignObject0Data(IndirectEvalForeignObject0Data next_) {
                this.next_ = next_;
            }

            @Override
            public NodeCost getCost() {
                return NodeCost.NONE;
            }

            <T extends Node> T insertAccessor(T node) {
                return super.insert(node);
            }

        }
    }
    @GeneratedBy(JSGlobalUnEscapeNode.class)
    public static final class JSGlobalUnEscapeNodeGen extends JSGlobalUnEscapeNode implements Provider {

        @Child private JavaScriptNode arguments0_;

        private JSGlobalUnEscapeNodeGen(JSContext context, JSBuiltin builtin, boolean unescape, JavaScriptNode[] arguments) {
            super(context, builtin, unescape);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return escape(arguments0Value_);
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
            s[0] = "escape";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSGlobalUnEscapeNode create(JSContext context, JSBuiltin builtin, boolean unescape, JavaScriptNode[] arguments) {
            return new JSGlobalUnEscapeNodeGen(context, builtin, unescape, arguments);
        }

    }
    @GeneratedBy(JSGlobalPrintNode.class)
    public static final class JSGlobalPrintNodeGen extends JSGlobalPrintNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private int state_;

        private JSGlobalPrintNodeGen(JSContext context, JSBuiltin builtin, boolean useErr, JavaScriptNode[] arguments) {
            super(context, builtin, useErr);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object executeObjectArray(Object[] arguments0Value) {
            int state = state_;
            if (state != 0 /* is-active print(Object[]) */) {
                return print(arguments0Value);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value);
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if (state != 0 /* is-active print(Object[]) */ && arguments0Value_ instanceof Object[]) {
                Object[] arguments0Value__ = (Object[]) arguments0Value_;
                return print(arguments0Value__);
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
            if (arguments0Value instanceof Object[]) {
                Object[] arguments0Value_ = (Object[]) arguments0Value;
                this.state_ = state = state | 0b1 /* add-active print(Object[]) */;
                return print(arguments0Value_);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_}, arguments0Value);
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
            s[0] = "print";
            if (state != 0 /* is-active print(Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static JSGlobalPrintNode create(JSContext context, JSBuiltin builtin, boolean useErr, JavaScriptNode[] arguments) {
            return new JSGlobalPrintNodeGen(context, builtin, useErr, arguments);
        }

    }
    @GeneratedBy(JSGlobalLoadNode.class)
    public static final class JSGlobalLoadNodeGen extends JSGlobalLoadNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_;
        @Child private InteropLibrary loadTruffleObject_interop_;
        @Child private JSToStringNode loadScriptObj_sourceToStringNode_;

        private JSGlobalLoadNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state & 0b1111) != 0 /* is-active loadString(String, Object[]) || loadTruffleObject(Object, Object[], InteropLibrary) || loadScriptObj(DynamicObject, Object[], JSToStringNode) || loadConvertToString(Object, Object[]) */ && arguments1Value_ instanceof Object[]) {
                Object[] arguments1Value__ = (Object[]) arguments1Value_;
                if ((state & 0b1) != 0 /* is-active loadString(String, Object[]) */ && JSTypesGen.isImplicitString((state & 0b11110000) >>> 4 /* extract-implicit-active 0:String */, arguments0Value_)) {
                    String arguments0Value__ = JSTypesGen.asImplicitString((state & 0b11110000) >>> 4 /* extract-implicit-active 0:String */, arguments0Value_);
                    return loadString(arguments0Value__, arguments1Value__);
                }
                if ((state & 0b10) != 0 /* is-active loadTruffleObject(Object, Object[], InteropLibrary) */) {
                    if ((JSGuards.isForeignObject(arguments0Value_))) {
                        return loadTruffleObject(arguments0Value_, arguments1Value__, this.loadTruffleObject_interop_);
                    }
                }
                if ((state & 0b100) != 0 /* is-active loadScriptObj(DynamicObject, Object[], JSToStringNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((JSGuards.isJSObject(arguments0Value__))) {
                        return loadScriptObj(arguments0Value__, arguments1Value__, this.loadScriptObj_sourceToStringNode_);
                    }
                }
                if ((state & 0b1000) != 0 /* is-active loadConvertToString(Object, Object[]) */) {
                    if ((!(JSGuards.isString(arguments0Value_))) && (!(JSGuards.isForeignObject(arguments0Value_))) && (!(JSGuards.isJSObject(arguments0Value_)))) {
                        return loadConvertToString(arguments0Value_, arguments1Value__);
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

        private Object executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            try {
                if (arguments1Value instanceof Object[]) {
                    Object[] arguments1Value_ = (Object[]) arguments1Value;
                    {
                        int stringCast0;
                        if ((stringCast0 = JSTypesGen.specializeImplicitString(arguments0Value)) != 0) {
                            String arguments0Value_ = JSTypesGen.asImplicitString(stringCast0, arguments0Value);
                            state = (state | (stringCast0 << 4) /* set-implicit-active 0:String */);
                            this.state_ = state = state | 0b1 /* add-active loadString(String, Object[]) */;
                            lock.unlock();
                            hasLock = false;
                            return loadString(arguments0Value_, arguments1Value_);
                        }
                    }
                    if ((JSGuards.isForeignObject(arguments0Value))) {
                        this.loadTruffleObject_interop_ = super.insert((INTEROP_LIBRARY_.createDispatched(3)));
                        this.state_ = state = state | 0b10 /* add-active loadTruffleObject(Object, Object[], InteropLibrary) */;
                        lock.unlock();
                        hasLock = false;
                        return loadTruffleObject(arguments0Value, arguments1Value_, this.loadTruffleObject_interop_);
                    }
                    if (JSTypes.isDynamicObject(arguments0Value)) {
                        DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                        if ((JSGuards.isJSObject(arguments0Value_))) {
                            this.loadScriptObj_sourceToStringNode_ = super.insert((JSToStringNode.create()));
                            this.state_ = state = state | 0b100 /* add-active loadScriptObj(DynamicObject, Object[], JSToStringNode) */;
                            lock.unlock();
                            hasLock = false;
                            return loadScriptObj(arguments0Value_, arguments1Value_, this.loadScriptObj_sourceToStringNode_);
                        }
                    }
                    if ((!(JSGuards.isString(arguments0Value))) && (!(JSGuards.isForeignObject(arguments0Value))) && (!(JSGuards.isJSObject(arguments0Value)))) {
                        this.state_ = state = state | 0b1000 /* add-active loadConvertToString(Object, Object[]) */;
                        lock.unlock();
                        hasLock = false;
                        return loadConvertToString(arguments0Value, arguments1Value_);
                    }
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
            if ((state & 0b1111) == 0b0) {
                return NodeCost.UNINITIALIZED;
            } else if (((state & 0b1111) & ((state & 0b1111) - 1)) == 0 /* is-single-active  */) {
                return NodeCost.MONOMORPHIC;
            }
            return NodeCost.POLYMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[5];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "loadString";
            if ((state & 0b1) != 0 /* is-active loadString(String, Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "loadTruffleObject";
            if ((state & 0b10) != 0 /* is-active loadTruffleObject(Object, Object[], InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.loadTruffleObject_interop_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "loadScriptObj";
            if ((state & 0b100) != 0 /* is-active loadScriptObj(DynamicObject, Object[], JSToStringNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.loadScriptObj_sourceToStringNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "loadConvertToString";
            if ((state & 0b1000) != 0 /* is-active loadConvertToString(Object, Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            return Provider.create(data);
        }

        public static JSGlobalLoadNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSGlobalLoadNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSGlobalLoadWithNewGlobalNode.class)
    public static final class JSGlobalLoadWithNewGlobalNodeGen extends JSGlobalLoadWithNewGlobalNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_;
        @Child private InteropLibrary loadTruffleObject_interop_;
        @Child private JSToStringNode loadScriptObj_sourceToStringNode_;

        private JSGlobalLoadWithNewGlobalNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state & 0b1111) != 0 /* is-active loadString(String, Object[]) || loadTruffleObject(Object, Object[], InteropLibrary) || loadScriptObj(DynamicObject, Object[], JSToStringNode) || loadConvertToString(Object, Object[]) */ && arguments1Value_ instanceof Object[]) {
                Object[] arguments1Value__ = (Object[]) arguments1Value_;
                if ((state & 0b1) != 0 /* is-active loadString(String, Object[]) */ && JSTypesGen.isImplicitString((state & 0b11110000) >>> 4 /* extract-implicit-active 0:String */, arguments0Value_)) {
                    String arguments0Value__ = JSTypesGen.asImplicitString((state & 0b11110000) >>> 4 /* extract-implicit-active 0:String */, arguments0Value_);
                    return loadString(arguments0Value__, arguments1Value__);
                }
                if ((state & 0b10) != 0 /* is-active loadTruffleObject(Object, Object[], InteropLibrary) */) {
                    if ((JSGuards.isForeignObject(arguments0Value_))) {
                        return loadTruffleObject(arguments0Value_, arguments1Value__, this.loadTruffleObject_interop_);
                    }
                }
                if ((state & 0b100) != 0 /* is-active loadScriptObj(DynamicObject, Object[], JSToStringNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((JSGuards.isJSObject(arguments0Value__))) {
                        return loadScriptObj(arguments0Value__, arguments1Value__, this.loadScriptObj_sourceToStringNode_);
                    }
                }
                if ((state & 0b1000) != 0 /* is-active loadConvertToString(Object, Object[]) */) {
                    if ((!(JSGuards.isString(arguments0Value_))) && (!(JSGuards.isForeignObject(arguments0Value_))) && (!(JSGuards.isJSObject(arguments0Value_)))) {
                        return loadConvertToString(arguments0Value_, arguments1Value__);
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

        private Object executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            try {
                if (arguments1Value instanceof Object[]) {
                    Object[] arguments1Value_ = (Object[]) arguments1Value;
                    {
                        int stringCast0;
                        if ((stringCast0 = JSTypesGen.specializeImplicitString(arguments0Value)) != 0) {
                            String arguments0Value_ = JSTypesGen.asImplicitString(stringCast0, arguments0Value);
                            state = (state | (stringCast0 << 4) /* set-implicit-active 0:String */);
                            this.state_ = state = state | 0b1 /* add-active loadString(String, Object[]) */;
                            lock.unlock();
                            hasLock = false;
                            return loadString(arguments0Value_, arguments1Value_);
                        }
                    }
                    if ((JSGuards.isForeignObject(arguments0Value))) {
                        this.loadTruffleObject_interop_ = super.insert((INTEROP_LIBRARY_.createDispatched(3)));
                        this.state_ = state = state | 0b10 /* add-active loadTruffleObject(Object, Object[], InteropLibrary) */;
                        lock.unlock();
                        hasLock = false;
                        return loadTruffleObject(arguments0Value, arguments1Value_, this.loadTruffleObject_interop_);
                    }
                    if (JSTypes.isDynamicObject(arguments0Value)) {
                        DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                        if ((JSGuards.isJSObject(arguments0Value_))) {
                            this.loadScriptObj_sourceToStringNode_ = super.insert((JSToStringNode.create()));
                            this.state_ = state = state | 0b100 /* add-active loadScriptObj(DynamicObject, Object[], JSToStringNode) */;
                            lock.unlock();
                            hasLock = false;
                            return loadScriptObj(arguments0Value_, arguments1Value_, this.loadScriptObj_sourceToStringNode_);
                        }
                    }
                    if ((!(JSGuards.isString(arguments0Value))) && (!(JSGuards.isForeignObject(arguments0Value))) && (!(JSGuards.isJSObject(arguments0Value)))) {
                        this.state_ = state = state | 0b1000 /* add-active loadConvertToString(Object, Object[]) */;
                        lock.unlock();
                        hasLock = false;
                        return loadConvertToString(arguments0Value, arguments1Value_);
                    }
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
            if ((state & 0b1111) == 0b0) {
                return NodeCost.UNINITIALIZED;
            } else if (((state & 0b1111) & ((state & 0b1111) - 1)) == 0 /* is-single-active  */) {
                return NodeCost.MONOMORPHIC;
            }
            return NodeCost.POLYMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[5];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "loadString";
            if ((state & 0b1) != 0 /* is-active loadString(String, Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "loadTruffleObject";
            if ((state & 0b10) != 0 /* is-active loadTruffleObject(Object, Object[], InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.loadTruffleObject_interop_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "loadScriptObj";
            if ((state & 0b100) != 0 /* is-active loadScriptObj(DynamicObject, Object[], JSToStringNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.loadScriptObj_sourceToStringNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "loadConvertToString";
            if ((state & 0b1000) != 0 /* is-active loadConvertToString(Object, Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            return Provider.create(data);
        }

        public static JSGlobalLoadWithNewGlobalNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSGlobalLoadWithNewGlobalNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSGlobalExitNode.class)
    public static final class JSGlobalExitNodeGen extends JSGlobalExitNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_;
        @Child private JSToNumberNode exit2_toNumberNode_;

        private JSGlobalExitNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state & 0b101) == 0 /* only-active exit(int) */ && state != 0  /* is-not exit(Object) && exit(int) && exit(Object, JSToNumberNode) */) {
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
            assert (state & 0b10) != 0 /* is-active exit(int) */;
            return exit(arguments0Value_);
        }

        private Object execute_generic1(VirtualFrame frameValue, int state) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state & 0b1) != 0 /* is-active exit(Object) */) {
                if ((JSGuards.isUndefined(arguments0Value_))) {
                    return exit(arguments0Value_);
                }
            }
            if ((state & 0b10) != 0 /* is-active exit(int) */ && arguments0Value_ instanceof Integer) {
                int arguments0Value__ = (int) arguments0Value_;
                return exit(arguments0Value__);
            }
            if ((state & 0b100) != 0 /* is-active exit(Object, JSToNumberNode) */) {
                return exit(arguments0Value_, this.exit2_toNumberNode_);
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
                if ((JSGuards.isUndefined(arguments0Value))) {
                    this.state_ = state = state | 0b1 /* add-active exit(Object) */;
                    lock.unlock();
                    hasLock = false;
                    return exit(arguments0Value);
                }
                if (arguments0Value instanceof Integer) {
                    int arguments0Value_ = (int) arguments0Value;
                    this.state_ = state = state | 0b10 /* add-active exit(int) */;
                    lock.unlock();
                    hasLock = false;
                    return exit(arguments0Value_);
                }
                this.exit2_toNumberNode_ = super.insert((JSToNumberNode.create()));
                this.state_ = state = state | 0b100 /* add-active exit(Object, JSToNumberNode) */;
                lock.unlock();
                hasLock = false;
                return exit(arguments0Value, this.exit2_toNumberNode_);
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
            s[0] = "exit";
            if ((state & 0b1) != 0 /* is-active exit(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "exit";
            if ((state & 0b10) != 0 /* is-active exit(int) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "exit";
            if ((state & 0b100) != 0 /* is-active exit(Object, JSToNumberNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.exit2_toNumberNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static JSGlobalExitNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSGlobalExitNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSGlobalReadLineNode.class)
    public static final class JSGlobalReadLineNodeGen extends JSGlobalReadLineNode implements Provider {

        @Child private JavaScriptNode arguments0_;

        private JSGlobalReadLineNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            return readLine(arguments0Value_);
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
            s[0] = "readLine";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSGlobalReadLineNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSGlobalReadLineNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSGlobalReadFullyNode.class)
    public static final class JSGlobalReadFullyNodeGen extends JSGlobalReadFullyNode implements Provider {

        @Child private JavaScriptNode arguments0_;

        private JSGlobalReadFullyNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            return read(arguments0Value_);
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
            s[0] = "read";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSGlobalReadFullyNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSGlobalReadFullyNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSGlobalReadBufferNode.class)
    public static final class JSGlobalReadBufferNodeGen extends JSGlobalReadBufferNode implements Provider {

        @Child private JavaScriptNode arguments0_;

        private JSGlobalReadBufferNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            return readbuffer(arguments0Value_);
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
            s[0] = "readbuffer";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSGlobalReadBufferNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSGlobalReadBufferNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSGlobalImportScriptEngineGlobalBindingsNode.class)
    static final class JSGlobalImportScriptEngineGlobalBindingsNodeGen extends JSGlobalImportScriptEngineGlobalBindingsNode implements Provider {

        @Child private JavaScriptNode arguments0_;

        private JSGlobalImportScriptEngineGlobalBindingsNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            return importGlobalContext(arguments0Value_);
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
            s[0] = "importGlobalContext";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSGlobalImportScriptEngineGlobalBindingsNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSGlobalImportScriptEngineGlobalBindingsNodeGen(context, builtin, arguments);
        }

    }
}
