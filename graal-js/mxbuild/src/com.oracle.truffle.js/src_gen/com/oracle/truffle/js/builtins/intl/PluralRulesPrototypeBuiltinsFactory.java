// CheckStyle: start generated
package com.oracle.truffle.js.builtins.intl;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.builtins.intl.PluralRulesPrototypeBuiltins.JSPluralRulesResolvedOptionsNode;
import com.oracle.truffle.js.builtins.intl.PluralRulesPrototypeBuiltins.JSPluralRulesSelectNode;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSContext;

@GeneratedBy(PluralRulesPrototypeBuiltins.class)
@SuppressWarnings("unused")
public final class PluralRulesPrototypeBuiltinsFactory {

    @GeneratedBy(JSPluralRulesResolvedOptionsNode.class)
    public static final class JSPluralRulesResolvedOptionsNodeGen extends JSPluralRulesResolvedOptionsNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private int state_;

        private JSPluralRulesResolvedOptionsNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state & 0b1) != 0 /* is-active doResolvedOptions(DynamicObject) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((JSGuards.isJSPluralRules(arguments0Value__))) {
                    return doResolvedOptions(arguments0Value__);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            int state = state_;
            if ((state & 0b1) != 0 /* is-active doResolvedOptions(DynamicObject) */) {
                execute(frameValue);
                return;
            }
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state & 0b10) != 0 /* is-active doResolvedOptions(Object) */) {
                if (fallbackGuard_(arguments0Value_)) {
                    doResolvedOptions(arguments0Value_);
                    return;
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            executeAndSpecialize(arguments0Value_);
            return;
        }

        private Object executeAndSpecialize(Object arguments0Value) {
            int state = state_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((JSGuards.isJSPluralRules(arguments0Value_))) {
                    this.state_ = state = state | 0b1 /* add-active doResolvedOptions(DynamicObject) */;
                    return doResolvedOptions(arguments0Value_);
                }
            }
            this.state_ = state = state | 0b10 /* add-active doResolvedOptions(Object) */;
            doResolvedOptions(arguments0Value);
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
            Object[] data = new Object[3];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "doResolvedOptions";
            if ((state & 0b1) != 0 /* is-active doResolvedOptions(DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doResolvedOptions";
            if ((state & 0b10) != 0 /* is-active doResolvedOptions(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        private static boolean fallbackGuard_(Object arguments0Value) {
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((JSGuards.isJSPluralRules(arguments0Value_))) {
                    return false;
                }
            }
            return true;
        }

        public static JSPluralRulesResolvedOptionsNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSPluralRulesResolvedOptionsNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSPluralRulesSelectNode.class)
    public static final class JSPluralRulesSelectNodeGen extends JSPluralRulesSelectNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private int state_;

        private JSPluralRulesSelectNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state & 0b1) != 0 /* is-active doSelect(DynamicObject, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((JSGuards.isJSPluralRules(arguments0Value__))) {
                    return doSelect(arguments0Value__, arguments1Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            int state = state_;
            if ((state & 0b1) != 0 /* is-active doSelect(DynamicObject, Object) */) {
                execute(frameValue);
                return;
            }
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if ((state & 0b10) != 0 /* is-active throwTypeError(Object, Object) */) {
                if (fallbackGuard_(arguments0Value_, arguments1Value_)) {
                    throwTypeError(arguments0Value_, arguments1Value_);
                    return;
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            executeAndSpecialize(arguments0Value_, arguments1Value_);
            return;
        }

        private Object executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            int state = state_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((JSGuards.isJSPluralRules(arguments0Value_))) {
                    this.state_ = state = state | 0b1 /* add-active doSelect(DynamicObject, Object) */;
                    return doSelect(arguments0Value_, arguments1Value);
                }
            }
            this.state_ = state = state | 0b10 /* add-active throwTypeError(Object, Object) */;
            throwTypeError(arguments0Value, arguments1Value);
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
            Object[] data = new Object[3];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "doSelect";
            if ((state & 0b1) != 0 /* is-active doSelect(DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "throwTypeError";
            if ((state & 0b10) != 0 /* is-active throwTypeError(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        private static boolean fallbackGuard_(Object arguments0Value, Object arguments1Value) {
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((JSGuards.isJSPluralRules(arguments0Value_))) {
                    return false;
                }
            }
            return true;
        }

        public static JSPluralRulesSelectNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSPluralRulesSelectNodeGen(context, builtin, arguments);
        }

    }
}
