// CheckStyle: start generated
package com.oracle.truffle.js.builtins;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.js.builtins.StringPrototypeBuiltins.CreateHTMLNode;
import com.oracle.truffle.js.builtins.StringPrototypeBuiltins.CreateStringIteratorNode;
import com.oracle.truffle.js.builtins.StringPrototypeBuiltins.JSStringCharAtNode;
import com.oracle.truffle.js.builtins.StringPrototypeBuiltins.JSStringCharCodeAtNode;
import com.oracle.truffle.js.builtins.StringPrototypeBuiltins.JSStringCodePointAtNode;
import com.oracle.truffle.js.builtins.StringPrototypeBuiltins.JSStringConcatNode;
import com.oracle.truffle.js.builtins.StringPrototypeBuiltins.JSStringEndsWithNode;
import com.oracle.truffle.js.builtins.StringPrototypeBuiltins.JSStringIncludesNode;
import com.oracle.truffle.js.builtins.StringPrototypeBuiltins.JSStringIndexOfNode;
import com.oracle.truffle.js.builtins.StringPrototypeBuiltins.JSStringLastIndexOfNode;
import com.oracle.truffle.js.builtins.StringPrototypeBuiltins.JSStringLocaleCompareIntlNode;
import com.oracle.truffle.js.builtins.StringPrototypeBuiltins.JSStringLocaleCompareNode;
import com.oracle.truffle.js.builtins.StringPrototypeBuiltins.JSStringMatchES5Node;
import com.oracle.truffle.js.builtins.StringPrototypeBuiltins.JSStringMatchNode;
import com.oracle.truffle.js.builtins.StringPrototypeBuiltins.JSStringNormalizeNode;
import com.oracle.truffle.js.builtins.StringPrototypeBuiltins.JSStringPadNode;
import com.oracle.truffle.js.builtins.StringPrototypeBuiltins.JSStringRepeatNode;
import com.oracle.truffle.js.builtins.StringPrototypeBuiltins.JSStringReplaceAllNode;
import com.oracle.truffle.js.builtins.StringPrototypeBuiltins.JSStringReplaceBaseNode;
import com.oracle.truffle.js.builtins.StringPrototypeBuiltins.JSStringReplaceES5Node;
import com.oracle.truffle.js.builtins.StringPrototypeBuiltins.JSStringReplaceNode;
import com.oracle.truffle.js.builtins.StringPrototypeBuiltins.JSStringSearchES5Node;
import com.oracle.truffle.js.builtins.StringPrototypeBuiltins.JSStringSearchNode;
import com.oracle.truffle.js.builtins.StringPrototypeBuiltins.JSStringSliceNode;
import com.oracle.truffle.js.builtins.StringPrototypeBuiltins.JSStringSplitNode;
import com.oracle.truffle.js.builtins.StringPrototypeBuiltins.JSStringStartsWithNode;
import com.oracle.truffle.js.builtins.StringPrototypeBuiltins.JSStringSubstrNode;
import com.oracle.truffle.js.builtins.StringPrototypeBuiltins.JSStringSubstringNode;
import com.oracle.truffle.js.builtins.StringPrototypeBuiltins.JSStringToLocaleLowerCaseIntlNode;
import com.oracle.truffle.js.builtins.StringPrototypeBuiltins.JSStringToLocaleUpperCaseIntlNode;
import com.oracle.truffle.js.builtins.StringPrototypeBuiltins.JSStringToLocaleXCaseIntl;
import com.oracle.truffle.js.builtins.StringPrototypeBuiltins.JSStringToLowerCaseNode;
import com.oracle.truffle.js.builtins.StringPrototypeBuiltins.JSStringToStringNode;
import com.oracle.truffle.js.builtins.StringPrototypeBuiltins.JSStringToUpperCaseNode;
import com.oracle.truffle.js.builtins.StringPrototypeBuiltins.JSStringTrimLeftNode;
import com.oracle.truffle.js.builtins.StringPrototypeBuiltins.JSStringTrimNode;
import com.oracle.truffle.js.builtins.StringPrototypeBuiltins.JSStringTrimRightNode;
import com.oracle.truffle.js.builtins.helper.ReplaceStringParser.Token;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.access.IsRegExpNode;
import com.oracle.truffle.js.nodes.access.RequireObjectCoercibleNode;
import com.oracle.truffle.js.nodes.cast.JSToNumberNode;
import com.oracle.truffle.js.nodes.cast.JSToRegExpNode;
import com.oracle.truffle.js.nodes.cast.JSToStringNode;
import com.oracle.truffle.js.nodes.cast.JSTrimWhitespaceNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.objects.JSLazyString;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(StringPrototypeBuiltins.class)
public final class StringPrototypeBuiltinsFactory {

    @GeneratedBy(JSStringCharAtNode.class)
    public static final class JSStringCharAtNodeGen extends JSStringCharAtNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private int state_;

        private JSStringCharAtNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state & 0b10) == 0 /* only-active stringCharAt(String, int) */ && (state & 0b11) != 0  /* is-not stringCharAt(String, int) && charAt(Object, Object) */) {
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
            assert (state & 0b1) != 0 /* is-active stringCharAt(String, int) */;
            if (JSTypesGen.isImplicitString((state & 0b111100) >>> 2 /* extract-implicit-active 0:String */, arguments0Value_)) {
                String arguments0Value__ = JSTypesGen.asImplicitString((state & 0b111100) >>> 2 /* extract-implicit-active 0:String */, arguments0Value_);
                return stringCharAt(arguments0Value__, arguments1Value_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        private Object execute_generic1(VirtualFrame frameValue, int state) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if ((state & 0b1) != 0 /* is-active stringCharAt(String, int) */ && JSTypesGen.isImplicitString((state & 0b111100) >>> 2 /* extract-implicit-active 0:String */, arguments0Value_)) {
                String arguments0Value__ = JSTypesGen.asImplicitString((state & 0b111100) >>> 2 /* extract-implicit-active 0:String */, arguments0Value_);
                if (arguments1Value_ instanceof Integer) {
                    int arguments1Value__ = (int) arguments1Value_;
                    return stringCharAt(arguments0Value__, arguments1Value__);
                }
            }
            if ((state & 0b10) != 0 /* is-active charAt(Object, Object) */) {
                return charAt(arguments0Value_, arguments1Value_);
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
            int state = state_;
            {
                int stringCast0;
                if ((stringCast0 = JSTypesGen.specializeImplicitString(arguments0Value)) != 0) {
                    String arguments0Value_ = JSTypesGen.asImplicitString(stringCast0, arguments0Value);
                    if (arguments1Value instanceof Integer) {
                        int arguments1Value_ = (int) arguments1Value;
                        state = (state | (stringCast0 << 2) /* set-implicit-active 0:String */);
                        this.state_ = state = state | 0b1 /* add-active stringCharAt(String, int) */;
                        return stringCharAt(arguments0Value_, arguments1Value_);
                    }
                }
            }
            this.state_ = state = state | 0b10 /* add-active charAt(Object, Object) */;
            return charAt(arguments0Value, arguments1Value);
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
            s[0] = "stringCharAt";
            if ((state & 0b1) != 0 /* is-active stringCharAt(String, int) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "charAt";
            if ((state & 0b10) != 0 /* is-active charAt(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static JSStringCharAtNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSStringCharAtNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(com.oracle.truffle.js.builtins.StringPrototypeBuiltins.JSStringCharAtNode.Inlined.class)
        public static final class InlinedNodeGen extends com.oracle.truffle.js.builtins.StringPrototypeBuiltins.JSStringCharAtNode.Inlined implements Provider {

            @Child private JavaScriptNode arguments0_;
            @Child private JavaScriptNode arguments1_;
            @CompilationFinal private int state_;

            private InlinedNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
                super(context, builtin);
                this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
                this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
            }

            @Override
            public JavaScriptNode[] getArguments() {
                return new JavaScriptNode[] {this.arguments0_, this.arguments1_};
            }

            @Override
            protected Object executeWithArguments(Object arguments0Value, Object arguments1Value) {
                int state = state_;
                if ((state & 0b1) != 0 /* is-active stringCharAt(String, int) */ && JSTypesGen.isImplicitString((state & 0b111100) >>> 2 /* extract-implicit-active 0:String */, arguments0Value)) {
                    String arguments0Value_ = JSTypesGen.asImplicitString((state & 0b111100) >>> 2 /* extract-implicit-active 0:String */, arguments0Value);
                    if (arguments1Value instanceof Integer) {
                        int arguments1Value_ = (int) arguments1Value;
                        return stringCharAt(arguments0Value_, arguments1Value_);
                    }
                }
                if ((state & 0b10) != 0 /* is-active charAt(Object, Object) */) {
                    return charAt(arguments0Value, arguments1Value);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return executeAndSpecialize(arguments0Value, arguments1Value);
            }

            @Override
            public Object execute(VirtualFrame frameValue) {
                int state = state_;
                if ((state & 0b10) == 0 /* only-active stringCharAt(String, int) */ && (state & 0b11) != 0  /* is-not stringCharAt(String, int) && charAt(Object, Object) */) {
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
                assert (state & 0b1) != 0 /* is-active stringCharAt(String, int) */;
                if (JSTypesGen.isImplicitString((state & 0b111100) >>> 2 /* extract-implicit-active 0:String */, arguments0Value_)) {
                    String arguments0Value__ = JSTypesGen.asImplicitString((state & 0b111100) >>> 2 /* extract-implicit-active 0:String */, arguments0Value_);
                    return stringCharAt(arguments0Value__, arguments1Value_);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return executeAndSpecialize(arguments0Value_, arguments1Value_);
            }

            private Object execute_generic1(VirtualFrame frameValue, int state) {
                Object arguments0Value_ = this.arguments0_.execute(frameValue);
                Object arguments1Value_ = this.arguments1_.execute(frameValue);
                if ((state & 0b1) != 0 /* is-active stringCharAt(String, int) */ && JSTypesGen.isImplicitString((state & 0b111100) >>> 2 /* extract-implicit-active 0:String */, arguments0Value_)) {
                    String arguments0Value__ = JSTypesGen.asImplicitString((state & 0b111100) >>> 2 /* extract-implicit-active 0:String */, arguments0Value_);
                    if (arguments1Value_ instanceof Integer) {
                        int arguments1Value__ = (int) arguments1Value_;
                        return stringCharAt(arguments0Value__, arguments1Value__);
                    }
                }
                if ((state & 0b10) != 0 /* is-active charAt(Object, Object) */) {
                    return charAt(arguments0Value_, arguments1Value_);
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
                int state = state_;
                {
                    int stringCast0;
                    if ((stringCast0 = JSTypesGen.specializeImplicitString(arguments0Value)) != 0) {
                        String arguments0Value_ = JSTypesGen.asImplicitString(stringCast0, arguments0Value);
                        if (arguments1Value instanceof Integer) {
                            int arguments1Value_ = (int) arguments1Value;
                            state = (state | (stringCast0 << 2) /* set-implicit-active 0:String */);
                            this.state_ = state = state | 0b1 /* add-active stringCharAt(String, int) */;
                            return stringCharAt(arguments0Value_, arguments1Value_);
                        }
                    }
                }
                this.state_ = state = state | 0b10 /* add-active charAt(Object, Object) */;
                return charAt(arguments0Value, arguments1Value);
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
                s[0] = "stringCharAt";
                if ((state & 0b1) != 0 /* is-active stringCharAt(String, int) */) {
                    s[1] = (byte)0b01 /* active */;
                } else {
                    s[1] = (byte)0b00 /* inactive */;
                }
                data[1] = s;
                s = new Object[3];
                s[0] = "charAt";
                if ((state & 0b10) != 0 /* is-active charAt(Object, Object) */) {
                    s[1] = (byte)0b01 /* active */;
                } else {
                    s[1] = (byte)0b00 /* inactive */;
                }
                data[2] = s;
                return Provider.create(data);
            }

            public static com.oracle.truffle.js.builtins.StringPrototypeBuiltins.JSStringCharAtNode.Inlined create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
                return new com.oracle.truffle.js.builtins.StringPrototypeBuiltinsFactory.JSStringCharAtNodeGen.InlinedNodeGen(context, builtin, arguments);
            }

        }
    }
    @GeneratedBy(JSStringCharCodeAtNode.class)
    public static final class JSStringCharCodeAtNodeGen extends JSStringCharCodeAtNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_;
        @CompilationFinal private volatile int exclude_;
        @CompilationFinal private ConditionProfile charCodeAtLazyString_flatten_;
        @Child private JSToNumberNode charCodeAtGeneric_toNumberNode_;

        private JSStringCharCodeAtNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state & 0b1000) == 0 /* only-active charCodeAtLazyString(JSLazyString, int, ConditionProfile) && charCodeAtInBounds(String, int) && charCodeAtOutOfBounds(String, int) */ && (state & 0b1111) != 0  /* is-not charCodeAtLazyString(JSLazyString, int, ConditionProfile) && charCodeAtInBounds(String, int) && charCodeAtOutOfBounds(String, int) && charCodeAtGeneric(Object, Object, JSToNumberNode) */) {
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
            if ((state & 0b1) != 0 /* is-active charCodeAtLazyString(JSLazyString, int, ConditionProfile) */ && arguments0Value_ instanceof JSLazyString) {
                JSLazyString arguments0Value__ = (JSLazyString) arguments0Value_;
                return charCodeAtLazyString(arguments0Value__, arguments1Value_, this.charCodeAtLazyString_flatten_);
            }
            if ((state & 0b110) != 0 /* is-active charCodeAtInBounds(String, int) || charCodeAtOutOfBounds(String, int) */ && JSTypesGen.isImplicitString((state & 0b11110000) >>> 4 /* extract-implicit-active 0:String */, arguments0Value_)) {
                String arguments0Value__ = JSTypesGen.asImplicitString((state & 0b11110000) >>> 4 /* extract-implicit-active 0:String */, arguments0Value_);
                if ((state & 0b10) != 0 /* is-active charCodeAtInBounds(String, int) */) {
                    if ((JSStringCharCodeAtNode.posInBounds(arguments0Value__, arguments1Value_))) {
                        return charCodeAtInBounds(arguments0Value__, arguments1Value_);
                    }
                }
                if ((state & 0b100) != 0 /* is-active charCodeAtOutOfBounds(String, int) */) {
                    if ((!(JSStringCharCodeAtNode.posInBounds(arguments0Value__, arguments1Value_)))) {
                        return charCodeAtOutOfBounds(arguments0Value__, arguments1Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        private Object execute_generic1(VirtualFrame frameValue, int state) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if ((state & 0b111) != 0 /* is-active charCodeAtLazyString(JSLazyString, int, ConditionProfile) || charCodeAtInBounds(String, int) || charCodeAtOutOfBounds(String, int) */ && arguments1Value_ instanceof Integer) {
                int arguments1Value__ = (int) arguments1Value_;
                if ((state & 0b1) != 0 /* is-active charCodeAtLazyString(JSLazyString, int, ConditionProfile) */ && arguments0Value_ instanceof JSLazyString) {
                    JSLazyString arguments0Value__ = (JSLazyString) arguments0Value_;
                    return charCodeAtLazyString(arguments0Value__, arguments1Value__, this.charCodeAtLazyString_flatten_);
                }
                if ((state & 0b110) != 0 /* is-active charCodeAtInBounds(String, int) || charCodeAtOutOfBounds(String, int) */ && JSTypesGen.isImplicitString((state & 0b11110000) >>> 4 /* extract-implicit-active 0:String */, arguments0Value_)) {
                    String arguments0Value__ = JSTypesGen.asImplicitString((state & 0b11110000) >>> 4 /* extract-implicit-active 0:String */, arguments0Value_);
                    if ((state & 0b10) != 0 /* is-active charCodeAtInBounds(String, int) */) {
                        if ((JSStringCharCodeAtNode.posInBounds(arguments0Value__, arguments1Value__))) {
                            return charCodeAtInBounds(arguments0Value__, arguments1Value__);
                        }
                    }
                    if ((state & 0b100) != 0 /* is-active charCodeAtOutOfBounds(String, int) */) {
                        if ((!(JSStringCharCodeAtNode.posInBounds(arguments0Value__, arguments1Value__)))) {
                            return charCodeAtOutOfBounds(arguments0Value__, arguments1Value__);
                        }
                    }
                }
            }
            if ((state & 0b1000) != 0 /* is-active charCodeAtGeneric(Object, Object, JSToNumberNode) */) {
                return charCodeAtGeneric(arguments0Value_, arguments1Value_, this.charCodeAtGeneric_toNumberNode_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public double executeDouble(VirtualFrame frameValue) throws UnexpectedResultException {
            int state = state_;
            if ((state & 0b1001) != 0 /* is-active charCodeAtLazyString(JSLazyString, int, ConditionProfile) || charCodeAtGeneric(Object, Object, JSToNumberNode) */) {
                return JSTypesGen.expectDouble(execute(frameValue));
            }
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            int arguments1Value_;
            try {
                arguments1Value_ = this.arguments1_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                return JSTypesGen.expectDouble(executeAndSpecialize(arguments0Value_, ex.getResult()));
            }
            if ((state & 0b100) != 0 /* is-active charCodeAtOutOfBounds(String, int) */ && JSTypesGen.isImplicitString((state & 0b11110000) >>> 4 /* extract-implicit-active 0:String */, arguments0Value_)) {
                String arguments0Value__ = JSTypesGen.asImplicitString((state & 0b11110000) >>> 4 /* extract-implicit-active 0:String */, arguments0Value_);
                if ((!(JSStringCharCodeAtNode.posInBounds(arguments0Value__, arguments1Value_)))) {
                    return charCodeAtOutOfBounds(arguments0Value__, arguments1Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return JSTypesGen.expectDouble(executeAndSpecialize(arguments0Value_, arguments1Value_));
        }

        @Override
        public int executeInt(VirtualFrame frameValue) throws UnexpectedResultException {
            int state = state_;
            if ((state & 0b1001) != 0 /* is-active charCodeAtLazyString(JSLazyString, int, ConditionProfile) || charCodeAtGeneric(Object, Object, JSToNumberNode) */) {
                return JSTypesGen.expectInteger(execute(frameValue));
            }
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            int arguments1Value_;
            try {
                arguments1Value_ = this.arguments1_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                return JSTypesGen.expectInteger(executeAndSpecialize(arguments0Value_, ex.getResult()));
            }
            if ((state & 0b10) != 0 /* is-active charCodeAtInBounds(String, int) */ && JSTypesGen.isImplicitString((state & 0b11110000) >>> 4 /* extract-implicit-active 0:String */, arguments0Value_)) {
                String arguments0Value__ = JSTypesGen.asImplicitString((state & 0b11110000) >>> 4 /* extract-implicit-active 0:String */, arguments0Value_);
                if ((JSStringCharCodeAtNode.posInBounds(arguments0Value__, arguments1Value_))) {
                    return charCodeAtInBounds(arguments0Value__, arguments1Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return JSTypesGen.expectInteger(executeAndSpecialize(arguments0Value_, arguments1Value_));
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            int state = state_;
            try {
                if ((state & 0b1101) == 0 /* only-active charCodeAtInBounds(String, int) */ && (state & 0b1111) != 0  /* is-not charCodeAtLazyString(JSLazyString, int, ConditionProfile) && charCodeAtInBounds(String, int) && charCodeAtOutOfBounds(String, int) && charCodeAtGeneric(Object, Object, JSToNumberNode) */) {
                    executeInt(frameValue);
                    return;
                } else if ((state & 0b1011) == 0 /* only-active charCodeAtOutOfBounds(String, int) */ && (state & 0b1111) != 0  /* is-not charCodeAtLazyString(JSLazyString, int, ConditionProfile) && charCodeAtInBounds(String, int) && charCodeAtOutOfBounds(String, int) && charCodeAtGeneric(Object, Object, JSToNumberNode) */) {
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
            int exclude = exclude_;
            try {
                if (arguments1Value instanceof Integer) {
                    int arguments1Value_ = (int) arguments1Value;
                    if (((exclude & 0b1)) == 0 /* is-not-excluded charCodeAtLazyString(JSLazyString, int, ConditionProfile) */ && arguments0Value instanceof JSLazyString) {
                        JSLazyString arguments0Value_ = (JSLazyString) arguments0Value;
                        this.charCodeAtLazyString_flatten_ = (ConditionProfile.createBinaryProfile());
                        this.state_ = state = state | 0b1 /* add-active charCodeAtLazyString(JSLazyString, int, ConditionProfile) */;
                        lock.unlock();
                        hasLock = false;
                        return charCodeAtLazyString(arguments0Value_, arguments1Value_, this.charCodeAtLazyString_flatten_);
                    }
                    {
                        int stringCast0;
                        if ((stringCast0 = JSTypesGen.specializeImplicitString(arguments0Value)) != 0) {
                            String arguments0Value_ = JSTypesGen.asImplicitString(stringCast0, arguments0Value);
                            if (((exclude & 0b10)) == 0 /* is-not-excluded charCodeAtInBounds(String, int) */) {
                                if ((JSStringCharCodeAtNode.posInBounds(arguments0Value_, arguments1Value_))) {
                                    state = (state | (stringCast0 << 4) /* set-implicit-active 0:String */);
                                    this.state_ = state = state | 0b10 /* add-active charCodeAtInBounds(String, int) */;
                                    lock.unlock();
                                    hasLock = false;
                                    return charCodeAtInBounds(arguments0Value_, arguments1Value_);
                                }
                            }
                            if (((exclude & 0b100)) == 0 /* is-not-excluded charCodeAtOutOfBounds(String, int) */) {
                                if ((!(JSStringCharCodeAtNode.posInBounds(arguments0Value_, arguments1Value_)))) {
                                    state = (state | (stringCast0 << 4) /* set-implicit-active 0:String */);
                                    this.state_ = state = state | 0b100 /* add-active charCodeAtOutOfBounds(String, int) */;
                                    lock.unlock();
                                    hasLock = false;
                                    return charCodeAtOutOfBounds(arguments0Value_, arguments1Value_);
                                }
                            }
                        }
                    }
                }
                this.charCodeAtGeneric_toNumberNode_ = super.insert((JSToNumberNode.create()));
                this.exclude_ = exclude = exclude | 0b111 /* add-excluded charCodeAtLazyString(JSLazyString, int, ConditionProfile), charCodeAtInBounds(String, int), charCodeAtOutOfBounds(String, int) */;
                state = state & 0xfffffff8 /* remove-active charCodeAtLazyString(JSLazyString, int, ConditionProfile), charCodeAtInBounds(String, int), charCodeAtOutOfBounds(String, int) */;
                this.state_ = state = state | 0b1000 /* add-active charCodeAtGeneric(Object, Object, JSToNumberNode) */;
                lock.unlock();
                hasLock = false;
                return charCodeAtGeneric(arguments0Value, arguments1Value, this.charCodeAtGeneric_toNumberNode_);
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
            int exclude = exclude_;
            s = new Object[3];
            s[0] = "charCodeAtLazyString";
            if ((state & 0b1) != 0 /* is-active charCodeAtLazyString(JSLazyString, int, ConditionProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.charCodeAtLazyString_flatten_));
                s[2] = cached;
            } else if ((exclude & 0b1) != 0 /* is-excluded charCodeAtLazyString(JSLazyString, int, ConditionProfile) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "charCodeAtInBounds";
            if ((state & 0b10) != 0 /* is-active charCodeAtInBounds(String, int) */) {
                s[1] = (byte)0b01 /* active */;
            } else if ((exclude & 0b10) != 0 /* is-excluded charCodeAtInBounds(String, int) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "charCodeAtOutOfBounds";
            if ((state & 0b100) != 0 /* is-active charCodeAtOutOfBounds(String, int) */) {
                s[1] = (byte)0b01 /* active */;
            } else if ((exclude & 0b100) != 0 /* is-excluded charCodeAtOutOfBounds(String, int) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "charCodeAtGeneric";
            if ((state & 0b1000) != 0 /* is-active charCodeAtGeneric(Object, Object, JSToNumberNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.charCodeAtGeneric_toNumberNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            return Provider.create(data);
        }

        public static JSStringCharCodeAtNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSStringCharCodeAtNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(com.oracle.truffle.js.builtins.StringPrototypeBuiltins.JSStringCharCodeAtNode.Inlined.class)
        public static final class InlinedNodeGen extends com.oracle.truffle.js.builtins.StringPrototypeBuiltins.JSStringCharCodeAtNode.Inlined implements Provider {

            @Child private JavaScriptNode arguments0_;
            @Child private JavaScriptNode arguments1_;
            @CompilationFinal private volatile int state_;
            @CompilationFinal private ConditionProfile charCodeAtLazyString_flatten_;
            @Child private JSToNumberNode charCodeAtGeneric_toNumberNode_;

            private InlinedNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
                super(context, builtin);
                this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
                this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
            }

            @Override
            public JavaScriptNode[] getArguments() {
                return new JavaScriptNode[] {this.arguments0_, this.arguments1_};
            }

            @Override
            protected Object executeWithArguments(Object arguments0Value, Object arguments1Value) {
                int state = state_;
                if ((state & 0b111) != 0 /* is-active charCodeAtLazyString(JSLazyString, int, ConditionProfile) || charCodeAtInBounds(String, int) || charCodeAtOutOfBounds(String, int) */ && arguments1Value instanceof Integer) {
                    int arguments1Value_ = (int) arguments1Value;
                    if ((state & 0b1) != 0 /* is-active charCodeAtLazyString(JSLazyString, int, ConditionProfile) */ && arguments0Value instanceof JSLazyString) {
                        JSLazyString arguments0Value_ = (JSLazyString) arguments0Value;
                        return charCodeAtLazyString(arguments0Value_, arguments1Value_, this.charCodeAtLazyString_flatten_);
                    }
                    if ((state & 0b110) != 0 /* is-active charCodeAtInBounds(String, int) || charCodeAtOutOfBounds(String, int) */ && JSTypesGen.isImplicitString((state & 0b11110000) >>> 4 /* extract-implicit-active 0:String */, arguments0Value)) {
                        String arguments0Value_ = JSTypesGen.asImplicitString((state & 0b11110000) >>> 4 /* extract-implicit-active 0:String */, arguments0Value);
                        if ((state & 0b10) != 0 /* is-active charCodeAtInBounds(String, int) */) {
                            if ((JSStringCharCodeAtNode.posInBounds(arguments0Value_, arguments1Value_))) {
                                return charCodeAtInBounds(arguments0Value_, arguments1Value_);
                            }
                        }
                        if ((state & 0b100) != 0 /* is-active charCodeAtOutOfBounds(String, int) */) {
                            if ((!(JSStringCharCodeAtNode.posInBounds(arguments0Value_, arguments1Value_)))) {
                                return charCodeAtOutOfBounds(arguments0Value_, arguments1Value_);
                            }
                        }
                    }
                }
                if ((state & 0b1000) != 0 /* is-active charCodeAtGeneric(Object, Object, JSToNumberNode) */) {
                    return charCodeAtGeneric(arguments0Value, arguments1Value, this.charCodeAtGeneric_toNumberNode_);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return executeAndSpecialize(arguments0Value, arguments1Value);
            }

            @Override
            public Object execute(VirtualFrame frameValue) {
                int state = state_;
                if ((state & 0b1000) == 0 /* only-active charCodeAtLazyString(JSLazyString, int, ConditionProfile) && charCodeAtInBounds(String, int) && charCodeAtOutOfBounds(String, int) */ && (state & 0b1111) != 0  /* is-not charCodeAtLazyString(JSLazyString, int, ConditionProfile) && charCodeAtInBounds(String, int) && charCodeAtOutOfBounds(String, int) && charCodeAtGeneric(Object, Object, JSToNumberNode) */) {
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
                if ((state & 0b1) != 0 /* is-active charCodeAtLazyString(JSLazyString, int, ConditionProfile) */ && arguments0Value_ instanceof JSLazyString) {
                    JSLazyString arguments0Value__ = (JSLazyString) arguments0Value_;
                    return charCodeAtLazyString(arguments0Value__, arguments1Value_, this.charCodeAtLazyString_flatten_);
                }
                if ((state & 0b110) != 0 /* is-active charCodeAtInBounds(String, int) || charCodeAtOutOfBounds(String, int) */ && JSTypesGen.isImplicitString((state & 0b11110000) >>> 4 /* extract-implicit-active 0:String */, arguments0Value_)) {
                    String arguments0Value__ = JSTypesGen.asImplicitString((state & 0b11110000) >>> 4 /* extract-implicit-active 0:String */, arguments0Value_);
                    if ((state & 0b10) != 0 /* is-active charCodeAtInBounds(String, int) */) {
                        if ((JSStringCharCodeAtNode.posInBounds(arguments0Value__, arguments1Value_))) {
                            return charCodeAtInBounds(arguments0Value__, arguments1Value_);
                        }
                    }
                    if ((state & 0b100) != 0 /* is-active charCodeAtOutOfBounds(String, int) */) {
                        if ((!(JSStringCharCodeAtNode.posInBounds(arguments0Value__, arguments1Value_)))) {
                            return charCodeAtOutOfBounds(arguments0Value__, arguments1Value_);
                        }
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return executeAndSpecialize(arguments0Value_, arguments1Value_);
            }

            private Object execute_generic1(VirtualFrame frameValue, int state) {
                Object arguments0Value_ = this.arguments0_.execute(frameValue);
                Object arguments1Value_ = this.arguments1_.execute(frameValue);
                if ((state & 0b111) != 0 /* is-active charCodeAtLazyString(JSLazyString, int, ConditionProfile) || charCodeAtInBounds(String, int) || charCodeAtOutOfBounds(String, int) */ && arguments1Value_ instanceof Integer) {
                    int arguments1Value__ = (int) arguments1Value_;
                    if ((state & 0b1) != 0 /* is-active charCodeAtLazyString(JSLazyString, int, ConditionProfile) */ && arguments0Value_ instanceof JSLazyString) {
                        JSLazyString arguments0Value__ = (JSLazyString) arguments0Value_;
                        return charCodeAtLazyString(arguments0Value__, arguments1Value__, this.charCodeAtLazyString_flatten_);
                    }
                    if ((state & 0b110) != 0 /* is-active charCodeAtInBounds(String, int) || charCodeAtOutOfBounds(String, int) */ && JSTypesGen.isImplicitString((state & 0b11110000) >>> 4 /* extract-implicit-active 0:String */, arguments0Value_)) {
                        String arguments0Value__ = JSTypesGen.asImplicitString((state & 0b11110000) >>> 4 /* extract-implicit-active 0:String */, arguments0Value_);
                        if ((state & 0b10) != 0 /* is-active charCodeAtInBounds(String, int) */) {
                            if ((JSStringCharCodeAtNode.posInBounds(arguments0Value__, arguments1Value__))) {
                                return charCodeAtInBounds(arguments0Value__, arguments1Value__);
                            }
                        }
                        if ((state & 0b100) != 0 /* is-active charCodeAtOutOfBounds(String, int) */) {
                            if ((!(JSStringCharCodeAtNode.posInBounds(arguments0Value__, arguments1Value__)))) {
                                return charCodeAtOutOfBounds(arguments0Value__, arguments1Value__);
                            }
                        }
                    }
                }
                if ((state & 0b1000) != 0 /* is-active charCodeAtGeneric(Object, Object, JSToNumberNode) */) {
                    return charCodeAtGeneric(arguments0Value_, arguments1Value_, this.charCodeAtGeneric_toNumberNode_);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return executeAndSpecialize(arguments0Value_, arguments1Value_);
            }

            @Override
            public double executeDouble(VirtualFrame frameValue) throws UnexpectedResultException {
                int state = state_;
                if ((state & 0b1001) != 0 /* is-active charCodeAtLazyString(JSLazyString, int, ConditionProfile) || charCodeAtGeneric(Object, Object, JSToNumberNode) */) {
                    return JSTypesGen.expectDouble(execute(frameValue));
                }
                Object arguments0Value_ = this.arguments0_.execute(frameValue);
                int arguments1Value_;
                try {
                    arguments1Value_ = this.arguments1_.executeInt(frameValue);
                } catch (UnexpectedResultException ex) {
                    return JSTypesGen.expectDouble(executeAndSpecialize(arguments0Value_, ex.getResult()));
                }
                if ((state & 0b100) != 0 /* is-active charCodeAtOutOfBounds(String, int) */ && JSTypesGen.isImplicitString((state & 0b11110000) >>> 4 /* extract-implicit-active 0:String */, arguments0Value_)) {
                    String arguments0Value__ = JSTypesGen.asImplicitString((state & 0b11110000) >>> 4 /* extract-implicit-active 0:String */, arguments0Value_);
                    if ((!(JSStringCharCodeAtNode.posInBounds(arguments0Value__, arguments1Value_)))) {
                        return charCodeAtOutOfBounds(arguments0Value__, arguments1Value_);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return JSTypesGen.expectDouble(executeAndSpecialize(arguments0Value_, arguments1Value_));
            }

            @Override
            public int executeInt(VirtualFrame frameValue) throws UnexpectedResultException {
                int state = state_;
                if ((state & 0b1001) != 0 /* is-active charCodeAtLazyString(JSLazyString, int, ConditionProfile) || charCodeAtGeneric(Object, Object, JSToNumberNode) */) {
                    return JSTypesGen.expectInteger(execute(frameValue));
                }
                Object arguments0Value_ = this.arguments0_.execute(frameValue);
                int arguments1Value_;
                try {
                    arguments1Value_ = this.arguments1_.executeInt(frameValue);
                } catch (UnexpectedResultException ex) {
                    return JSTypesGen.expectInteger(executeAndSpecialize(arguments0Value_, ex.getResult()));
                }
                if ((state & 0b10) != 0 /* is-active charCodeAtInBounds(String, int) */ && JSTypesGen.isImplicitString((state & 0b11110000) >>> 4 /* extract-implicit-active 0:String */, arguments0Value_)) {
                    String arguments0Value__ = JSTypesGen.asImplicitString((state & 0b11110000) >>> 4 /* extract-implicit-active 0:String */, arguments0Value_);
                    if ((JSStringCharCodeAtNode.posInBounds(arguments0Value__, arguments1Value_))) {
                        return charCodeAtInBounds(arguments0Value__, arguments1Value_);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return JSTypesGen.expectInteger(executeAndSpecialize(arguments0Value_, arguments1Value_));
            }

            @Override
            public void executeVoid(VirtualFrame frameValue) {
                int state = state_;
                try {
                    if ((state & 0b1101) == 0 /* only-active charCodeAtInBounds(String, int) */ && (state & 0b1111) != 0  /* is-not charCodeAtLazyString(JSLazyString, int, ConditionProfile) && charCodeAtInBounds(String, int) && charCodeAtOutOfBounds(String, int) && charCodeAtGeneric(Object, Object, JSToNumberNode) */) {
                        executeInt(frameValue);
                        return;
                    } else if ((state & 0b1011) == 0 /* only-active charCodeAtOutOfBounds(String, int) */ && (state & 0b1111) != 0  /* is-not charCodeAtLazyString(JSLazyString, int, ConditionProfile) && charCodeAtInBounds(String, int) && charCodeAtOutOfBounds(String, int) && charCodeAtGeneric(Object, Object, JSToNumberNode) */) {
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
                    if (arguments1Value instanceof Integer) {
                        int arguments1Value_ = (int) arguments1Value;
                        if (arguments0Value instanceof JSLazyString) {
                            JSLazyString arguments0Value_ = (JSLazyString) arguments0Value;
                            this.charCodeAtLazyString_flatten_ = (ConditionProfile.createBinaryProfile());
                            this.state_ = state = state | 0b1 /* add-active charCodeAtLazyString(JSLazyString, int, ConditionProfile) */;
                            lock.unlock();
                            hasLock = false;
                            return charCodeAtLazyString(arguments0Value_, arguments1Value_, this.charCodeAtLazyString_flatten_);
                        }
                        {
                            int stringCast0;
                            if ((stringCast0 = JSTypesGen.specializeImplicitString(arguments0Value)) != 0) {
                                String arguments0Value_ = JSTypesGen.asImplicitString(stringCast0, arguments0Value);
                                if ((JSStringCharCodeAtNode.posInBounds(arguments0Value_, arguments1Value_))) {
                                    state = (state | (stringCast0 << 4) /* set-implicit-active 0:String */);
                                    this.state_ = state = state | 0b10 /* add-active charCodeAtInBounds(String, int) */;
                                    lock.unlock();
                                    hasLock = false;
                                    return charCodeAtInBounds(arguments0Value_, arguments1Value_);
                                }
                                if ((!(JSStringCharCodeAtNode.posInBounds(arguments0Value_, arguments1Value_)))) {
                                    state = (state | (stringCast0 << 4) /* set-implicit-active 0:String */);
                                    this.state_ = state = state | 0b100 /* add-active charCodeAtOutOfBounds(String, int) */;
                                    lock.unlock();
                                    hasLock = false;
                                    return charCodeAtOutOfBounds(arguments0Value_, arguments1Value_);
                                }
                            }
                        }
                    }
                    this.charCodeAtGeneric_toNumberNode_ = super.insert((JSToNumberNode.create()));
                    this.state_ = state = state | 0b1000 /* add-active charCodeAtGeneric(Object, Object, JSToNumberNode) */;
                    lock.unlock();
                    hasLock = false;
                    return charCodeAtGeneric(arguments0Value, arguments1Value, this.charCodeAtGeneric_toNumberNode_);
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
                s[0] = "charCodeAtLazyString";
                if ((state & 0b1) != 0 /* is-active charCodeAtLazyString(JSLazyString, int, ConditionProfile) */) {
                    s[1] = (byte)0b01 /* active */;
                    ArrayList<Object> cached = new ArrayList<>();
                    cached.add(Arrays.asList(this.charCodeAtLazyString_flatten_));
                    s[2] = cached;
                } else {
                    s[1] = (byte)0b00 /* inactive */;
                }
                data[1] = s;
                s = new Object[3];
                s[0] = "charCodeAtInBounds";
                if ((state & 0b10) != 0 /* is-active charCodeAtInBounds(String, int) */) {
                    s[1] = (byte)0b01 /* active */;
                } else {
                    s[1] = (byte)0b00 /* inactive */;
                }
                data[2] = s;
                s = new Object[3];
                s[0] = "charCodeAtOutOfBounds";
                if ((state & 0b100) != 0 /* is-active charCodeAtOutOfBounds(String, int) */) {
                    s[1] = (byte)0b01 /* active */;
                } else {
                    s[1] = (byte)0b00 /* inactive */;
                }
                data[3] = s;
                s = new Object[3];
                s[0] = "charCodeAtGeneric";
                if ((state & 0b1000) != 0 /* is-active charCodeAtGeneric(Object, Object, JSToNumberNode) */) {
                    s[1] = (byte)0b01 /* active */;
                    ArrayList<Object> cached = new ArrayList<>();
                    cached.add(Arrays.asList(this.charCodeAtGeneric_toNumberNode_));
                    s[2] = cached;
                } else {
                    s[1] = (byte)0b00 /* inactive */;
                }
                data[4] = s;
                return Provider.create(data);
            }

            public static com.oracle.truffle.js.builtins.StringPrototypeBuiltins.JSStringCharCodeAtNode.Inlined create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
                return new com.oracle.truffle.js.builtins.StringPrototypeBuiltinsFactory.JSStringCharCodeAtNodeGen.InlinedNodeGen(context, builtin, arguments);
            }

        }
    }
    @GeneratedBy(JSStringSubstringNode.class)
    public static final class JSStringSubstringNodeGen extends JSStringSubstringNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private volatile int state_;
        @CompilationFinal private volatile int exclude_;
        @Child private SubstringGenericData substringGeneric_cache;

        private JSStringSubstringNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state & 0b110) == 0 /* only-active substring(String, int, int) */ && (state & 0b111) != 0  /* is-not substring(String, int, int) && substringStart(String, int, Object) && substringGeneric(Object, Object, Object, JSToNumberNode, JSToNumberNode, ConditionProfile, ConditionProfile) */) {
                return execute_int_int0(frameValue, state);
            } else if ((state & 0b101) == 0 /* only-active substringStart(String, int, Object) */ && (state & 0b111) != 0  /* is-not substring(String, int, int) && substringStart(String, int, Object) && substringGeneric(Object, Object, Object, JSToNumberNode, JSToNumberNode, ConditionProfile, ConditionProfile) */) {
                return execute_int1(frameValue, state);
            } else {
                return execute_generic2(frameValue, state);
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
            assert (state & 0b1) != 0 /* is-active substring(String, int, int) */;
            if (JSTypesGen.isImplicitString((state & 0b1111000) >>> 3 /* extract-implicit-active 0:String */, arguments0Value_)) {
                String arguments0Value__ = JSTypesGen.asImplicitString((state & 0b1111000) >>> 3 /* extract-implicit-active 0:String */, arguments0Value_);
                return substring(arguments0Value__, arguments1Value_, arguments2Value_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        private Object execute_int1(VirtualFrame frameValue, int state) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            int arguments1Value_;
            try {
                arguments1Value_ = this.arguments1_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                Object arguments2Value = this.arguments2_.execute(frameValue);
                return executeAndSpecialize(arguments0Value_, ex.getResult(), arguments2Value);
            }
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            assert (state & 0b10) != 0 /* is-active substringStart(String, int, Object) */;
            if (JSTypesGen.isImplicitString((state & 0b1111000) >>> 3 /* extract-implicit-active 0:String */, arguments0Value_)) {
                String arguments0Value__ = JSTypesGen.asImplicitString((state & 0b1111000) >>> 3 /* extract-implicit-active 0:String */, arguments0Value_);
                if ((JSGuards.isUndefined(arguments2Value_))) {
                    return substringStart(arguments0Value__, arguments1Value_, arguments2Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        private Object execute_generic2(VirtualFrame frameValue, int state) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if ((state & 0b11) != 0 /* is-active substring(String, int, int) || substringStart(String, int, Object) */ && JSTypesGen.isImplicitString((state & 0b1111000) >>> 3 /* extract-implicit-active 0:String */, arguments0Value_)) {
                String arguments0Value__ = JSTypesGen.asImplicitString((state & 0b1111000) >>> 3 /* extract-implicit-active 0:String */, arguments0Value_);
                if (arguments1Value_ instanceof Integer) {
                    int arguments1Value__ = (int) arguments1Value_;
                    if ((state & 0b1) != 0 /* is-active substring(String, int, int) */ && arguments2Value_ instanceof Integer) {
                        int arguments2Value__ = (int) arguments2Value_;
                        return substring(arguments0Value__, arguments1Value__, arguments2Value__);
                    }
                    if ((state & 0b10) != 0 /* is-active substringStart(String, int, Object) */) {
                        if ((JSGuards.isUndefined(arguments2Value_))) {
                            return substringStart(arguments0Value__, arguments1Value__, arguments2Value_);
                        }
                    }
                }
            }
            if ((state & 0b100) != 0 /* is-active substringGeneric(Object, Object, Object, JSToNumberNode, JSToNumberNode, ConditionProfile, ConditionProfile) */) {
                SubstringGenericData s3_ = this.substringGeneric_cache;
                if (s3_ != null) {
                    return substringGeneric(arguments0Value_, arguments1Value_, arguments2Value_, s3_.toNumberNode_, s3_.toNumber2Node_, s3_.startUndefined_, s3_.endUndefined_);
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
                        if (arguments1Value instanceof Integer) {
                            int arguments1Value_ = (int) arguments1Value;
                            if (((exclude & 0b1)) == 0 /* is-not-excluded substring(String, int, int) */ && arguments2Value instanceof Integer) {
                                int arguments2Value_ = (int) arguments2Value;
                                state = (state | (stringCast0 << 3) /* set-implicit-active 0:String */);
                                this.state_ = state = state | 0b1 /* add-active substring(String, int, int) */;
                                lock.unlock();
                                hasLock = false;
                                return substring(arguments0Value_, arguments1Value_, arguments2Value_);
                            }
                            if (((exclude & 0b10)) == 0 /* is-not-excluded substringStart(String, int, Object) */) {
                                if ((JSGuards.isUndefined(arguments2Value))) {
                                    state = (state | (stringCast0 << 3) /* set-implicit-active 0:String */);
                                    this.state_ = state = state | 0b10 /* add-active substringStart(String, int, Object) */;
                                    lock.unlock();
                                    hasLock = false;
                                    return substringStart(arguments0Value_, arguments1Value_, arguments2Value);
                                }
                            }
                        }
                    }
                }
                SubstringGenericData s3_ = super.insert(new SubstringGenericData());
                s3_.toNumberNode_ = s3_.insertAccessor((JSToNumberNode.create()));
                s3_.toNumber2Node_ = s3_.insertAccessor((JSToNumberNode.create()));
                s3_.startUndefined_ = (ConditionProfile.createBinaryProfile());
                s3_.endUndefined_ = (ConditionProfile.createBinaryProfile());
                this.substringGeneric_cache = s3_;
                this.exclude_ = exclude = exclude | 0b11 /* add-excluded substring(String, int, int), substringStart(String, int, Object) */;
                state = state & 0xfffffffc /* remove-active substring(String, int, int), substringStart(String, int, Object) */;
                this.state_ = state = state | 0b100 /* add-active substringGeneric(Object, Object, Object, JSToNumberNode, JSToNumberNode, ConditionProfile, ConditionProfile) */;
                lock.unlock();
                hasLock = false;
                return substringGeneric(arguments0Value, arguments1Value, arguments2Value, s3_.toNumberNode_, s3_.toNumber2Node_, s3_.startUndefined_, s3_.endUndefined_);
            } finally {
                if (hasLock) {
                    lock.unlock();
                }
            }
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
            int exclude = exclude_;
            s = new Object[3];
            s[0] = "substring";
            if ((state & 0b1) != 0 /* is-active substring(String, int, int) */) {
                s[1] = (byte)0b01 /* active */;
            } else if ((exclude & 0b1) != 0 /* is-excluded substring(String, int, int) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "substringStart";
            if ((state & 0b10) != 0 /* is-active substringStart(String, int, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else if ((exclude & 0b10) != 0 /* is-excluded substringStart(String, int, Object) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "substringGeneric";
            if ((state & 0b100) != 0 /* is-active substringGeneric(Object, Object, Object, JSToNumberNode, JSToNumberNode, ConditionProfile, ConditionProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                SubstringGenericData s3_ = this.substringGeneric_cache;
                if (s3_ != null) {
                    cached.add(Arrays.asList(s3_.toNumberNode_, s3_.toNumber2Node_, s3_.startUndefined_, s3_.endUndefined_));
                }
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static JSStringSubstringNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSStringSubstringNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(JSStringSubstringNode.class)
        private static final class SubstringGenericData extends Node {

            @Child JSToNumberNode toNumberNode_;
            @Child JSToNumberNode toNumber2Node_;
            @CompilationFinal ConditionProfile startUndefined_;
            @CompilationFinal ConditionProfile endUndefined_;

            SubstringGenericData() {
            }

            @Override
            public NodeCost getCost() {
                return NodeCost.NONE;
            }

            <T extends Node> T insertAccessor(T node) {
                return super.insert(node);
            }

        }
        @GeneratedBy(com.oracle.truffle.js.builtins.StringPrototypeBuiltins.JSStringSubstringNode.Inlined.class)
        public static final class InlinedNodeGen extends com.oracle.truffle.js.builtins.StringPrototypeBuiltins.JSStringSubstringNode.Inlined implements Provider {

            @Child private JavaScriptNode arguments0_;
            @Child private JavaScriptNode arguments1_;
            @Child private JavaScriptNode arguments2_;
            @CompilationFinal private volatile int state_;
            @Child private SubstringGenericData substringGeneric_cache;

            private InlinedNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            protected Object executeWithArguments(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
                int state = state_;
                if ((state & 0b11) != 0 /* is-active substring(String, int, int) || substringStart(String, int, Object) */ && JSTypesGen.isImplicitString((state & 0b1111000) >>> 3 /* extract-implicit-active 0:String */, arguments0Value)) {
                    String arguments0Value_ = JSTypesGen.asImplicitString((state & 0b1111000) >>> 3 /* extract-implicit-active 0:String */, arguments0Value);
                    if (arguments1Value instanceof Integer) {
                        int arguments1Value_ = (int) arguments1Value;
                        if ((state & 0b1) != 0 /* is-active substring(String, int, int) */ && arguments2Value instanceof Integer) {
                            int arguments2Value_ = (int) arguments2Value;
                            return substring(arguments0Value_, arguments1Value_, arguments2Value_);
                        }
                        if ((state & 0b10) != 0 /* is-active substringStart(String, int, Object) */) {
                            if ((JSGuards.isUndefined(arguments2Value))) {
                                return substringStart(arguments0Value_, arguments1Value_, arguments2Value);
                            }
                        }
                    }
                }
                if ((state & 0b100) != 0 /* is-active substringGeneric(Object, Object, Object, JSToNumberNode, JSToNumberNode, ConditionProfile, ConditionProfile) */) {
                    SubstringGenericData s3_ = this.substringGeneric_cache;
                    if (s3_ != null) {
                        return substringGeneric(arguments0Value, arguments1Value, arguments2Value, s3_.toNumberNode_, s3_.toNumber2Node_, s3_.startUndefined_, s3_.endUndefined_);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return executeAndSpecialize(arguments0Value, arguments1Value, arguments2Value);
            }

            @Override
            public Object execute(VirtualFrame frameValue) {
                int state = state_;
                if ((state & 0b110) == 0 /* only-active substring(String, int, int) */ && (state & 0b111) != 0  /* is-not substring(String, int, int) && substringStart(String, int, Object) && substringGeneric(Object, Object, Object, JSToNumberNode, JSToNumberNode, ConditionProfile, ConditionProfile) */) {
                    return execute_int_int0(frameValue, state);
                } else if ((state & 0b101) == 0 /* only-active substringStart(String, int, Object) */ && (state & 0b111) != 0  /* is-not substring(String, int, int) && substringStart(String, int, Object) && substringGeneric(Object, Object, Object, JSToNumberNode, JSToNumberNode, ConditionProfile, ConditionProfile) */) {
                    return execute_int1(frameValue, state);
                } else {
                    return execute_generic2(frameValue, state);
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
                assert (state & 0b1) != 0 /* is-active substring(String, int, int) */;
                if (JSTypesGen.isImplicitString((state & 0b1111000) >>> 3 /* extract-implicit-active 0:String */, arguments0Value_)) {
                    String arguments0Value__ = JSTypesGen.asImplicitString((state & 0b1111000) >>> 3 /* extract-implicit-active 0:String */, arguments0Value_);
                    return substring(arguments0Value__, arguments1Value_, arguments2Value_);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
            }

            private Object execute_int1(VirtualFrame frameValue, int state) {
                Object arguments0Value_ = this.arguments0_.execute(frameValue);
                int arguments1Value_;
                try {
                    arguments1Value_ = this.arguments1_.executeInt(frameValue);
                } catch (UnexpectedResultException ex) {
                    Object arguments2Value = this.arguments2_.execute(frameValue);
                    return executeAndSpecialize(arguments0Value_, ex.getResult(), arguments2Value);
                }
                Object arguments2Value_ = this.arguments2_.execute(frameValue);
                assert (state & 0b10) != 0 /* is-active substringStart(String, int, Object) */;
                if (JSTypesGen.isImplicitString((state & 0b1111000) >>> 3 /* extract-implicit-active 0:String */, arguments0Value_)) {
                    String arguments0Value__ = JSTypesGen.asImplicitString((state & 0b1111000) >>> 3 /* extract-implicit-active 0:String */, arguments0Value_);
                    if ((JSGuards.isUndefined(arguments2Value_))) {
                        return substringStart(arguments0Value__, arguments1Value_, arguments2Value_);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
            }

            private Object execute_generic2(VirtualFrame frameValue, int state) {
                Object arguments0Value_ = this.arguments0_.execute(frameValue);
                Object arguments1Value_ = this.arguments1_.execute(frameValue);
                Object arguments2Value_ = this.arguments2_.execute(frameValue);
                if ((state & 0b11) != 0 /* is-active substring(String, int, int) || substringStart(String, int, Object) */ && JSTypesGen.isImplicitString((state & 0b1111000) >>> 3 /* extract-implicit-active 0:String */, arguments0Value_)) {
                    String arguments0Value__ = JSTypesGen.asImplicitString((state & 0b1111000) >>> 3 /* extract-implicit-active 0:String */, arguments0Value_);
                    if (arguments1Value_ instanceof Integer) {
                        int arguments1Value__ = (int) arguments1Value_;
                        if ((state & 0b1) != 0 /* is-active substring(String, int, int) */ && arguments2Value_ instanceof Integer) {
                            int arguments2Value__ = (int) arguments2Value_;
                            return substring(arguments0Value__, arguments1Value__, arguments2Value__);
                        }
                        if ((state & 0b10) != 0 /* is-active substringStart(String, int, Object) */) {
                            if ((JSGuards.isUndefined(arguments2Value_))) {
                                return substringStart(arguments0Value__, arguments1Value__, arguments2Value_);
                            }
                        }
                    }
                }
                if ((state & 0b100) != 0 /* is-active substringGeneric(Object, Object, Object, JSToNumberNode, JSToNumberNode, ConditionProfile, ConditionProfile) */) {
                    SubstringGenericData s3_ = this.substringGeneric_cache;
                    if (s3_ != null) {
                        return substringGeneric(arguments0Value_, arguments1Value_, arguments2Value_, s3_.toNumberNode_, s3_.toNumber2Node_, s3_.startUndefined_, s3_.endUndefined_);
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
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                int state = state_;
                try {
                    {
                        int stringCast0;
                        if ((stringCast0 = JSTypesGen.specializeImplicitString(arguments0Value)) != 0) {
                            String arguments0Value_ = JSTypesGen.asImplicitString(stringCast0, arguments0Value);
                            if (arguments1Value instanceof Integer) {
                                int arguments1Value_ = (int) arguments1Value;
                                if (arguments2Value instanceof Integer) {
                                    int arguments2Value_ = (int) arguments2Value;
                                    state = (state | (stringCast0 << 3) /* set-implicit-active 0:String */);
                                    this.state_ = state = state | 0b1 /* add-active substring(String, int, int) */;
                                    lock.unlock();
                                    hasLock = false;
                                    return substring(arguments0Value_, arguments1Value_, arguments2Value_);
                                }
                                if ((JSGuards.isUndefined(arguments2Value))) {
                                    state = (state | (stringCast0 << 3) /* set-implicit-active 0:String */);
                                    this.state_ = state = state | 0b10 /* add-active substringStart(String, int, Object) */;
                                    lock.unlock();
                                    hasLock = false;
                                    return substringStart(arguments0Value_, arguments1Value_, arguments2Value);
                                }
                            }
                        }
                    }
                    SubstringGenericData s3_ = super.insert(new SubstringGenericData());
                    s3_.toNumberNode_ = s3_.insertAccessor((JSToNumberNode.create()));
                    s3_.toNumber2Node_ = s3_.insertAccessor((JSToNumberNode.create()));
                    s3_.startUndefined_ = (ConditionProfile.createBinaryProfile());
                    s3_.endUndefined_ = (ConditionProfile.createBinaryProfile());
                    this.substringGeneric_cache = s3_;
                    this.state_ = state = state | 0b100 /* add-active substringGeneric(Object, Object, Object, JSToNumberNode, JSToNumberNode, ConditionProfile, ConditionProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return substringGeneric(arguments0Value, arguments1Value, arguments2Value, s3_.toNumberNode_, s3_.toNumber2Node_, s3_.startUndefined_, s3_.endUndefined_);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
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
                s[0] = "substring";
                if ((state & 0b1) != 0 /* is-active substring(String, int, int) */) {
                    s[1] = (byte)0b01 /* active */;
                } else {
                    s[1] = (byte)0b00 /* inactive */;
                }
                data[1] = s;
                s = new Object[3];
                s[0] = "substringStart";
                if ((state & 0b10) != 0 /* is-active substringStart(String, int, Object) */) {
                    s[1] = (byte)0b01 /* active */;
                } else {
                    s[1] = (byte)0b00 /* inactive */;
                }
                data[2] = s;
                s = new Object[3];
                s[0] = "substringGeneric";
                if ((state & 0b100) != 0 /* is-active substringGeneric(Object, Object, Object, JSToNumberNode, JSToNumberNode, ConditionProfile, ConditionProfile) */) {
                    s[1] = (byte)0b01 /* active */;
                    ArrayList<Object> cached = new ArrayList<>();
                    SubstringGenericData s3_ = this.substringGeneric_cache;
                    if (s3_ != null) {
                        cached.add(Arrays.asList(s3_.toNumberNode_, s3_.toNumber2Node_, s3_.startUndefined_, s3_.endUndefined_));
                    }
                    s[2] = cached;
                } else {
                    s[1] = (byte)0b00 /* inactive */;
                }
                data[3] = s;
                return Provider.create(data);
            }

            public static com.oracle.truffle.js.builtins.StringPrototypeBuiltins.JSStringSubstringNode.Inlined create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
                return new com.oracle.truffle.js.builtins.StringPrototypeBuiltinsFactory.JSStringSubstringNodeGen.InlinedNodeGen(context, builtin, arguments);
            }

            @GeneratedBy(com.oracle.truffle.js.builtins.StringPrototypeBuiltins.JSStringSubstringNode.Inlined.class)
            private static final class SubstringGenericData extends Node {

                @Child JSToNumberNode toNumberNode_;
                @Child JSToNumberNode toNumber2Node_;
                @CompilationFinal ConditionProfile startUndefined_;
                @CompilationFinal ConditionProfile endUndefined_;

                SubstringGenericData() {
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
    }
    @GeneratedBy(JSStringIndexOfNode.class)
    public static final class JSStringIndexOfNodeGen extends JSStringIndexOfNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private volatile int state_;
        @CompilationFinal private volatile int exclude_;
        @Child private JSToStringNode indexOfGeneric_toString2Node_;

        private JSStringIndexOfNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state & 0b101) == 0 /* only-active indexOfStringInt(String, String, int) */ && (state & 0b111) != 0  /* is-not indexOfStringUndefined(String, String, Object) && indexOfStringInt(String, String, int) && indexOfGeneric(Object, Object, Object, JSToStringNode) */) {
                return execute_int0(frameValue, state);
            } else {
                return execute_generic1(frameValue, state);
            }
        }

        private Object execute_int0(VirtualFrame frameValue, int state) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            int arguments2Value_;
            try {
                arguments2Value_ = this.arguments2_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(arguments0Value_, arguments1Value_, ex.getResult());
            }
            assert (state & 0b10) != 0 /* is-active indexOfStringInt(String, String, int) */;
            if (JSTypesGen.isImplicitString((state & 0b1111000) >>> 3 /* extract-implicit-active 0:String */, arguments0Value_)) {
                String arguments0Value__ = JSTypesGen.asImplicitString((state & 0b1111000) >>> 3 /* extract-implicit-active 0:String */, arguments0Value_);
                if (JSTypesGen.isImplicitString((state & 0b11110000000) >>> 7 /* extract-implicit-active 1:String */, arguments1Value_)) {
                    String arguments1Value__ = JSTypesGen.asImplicitString((state & 0b11110000000) >>> 7 /* extract-implicit-active 1:String */, arguments1Value_);
                    return indexOfStringInt(arguments0Value__, arguments1Value__, arguments2Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        private Object execute_generic1(VirtualFrame frameValue, int state) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if ((state & 0b11) != 0 /* is-active indexOfStringUndefined(String, String, Object) || indexOfStringInt(String, String, int) */ && JSTypesGen.isImplicitString((state & 0b1111000) >>> 3 /* extract-implicit-active 0:String */, arguments0Value_)) {
                String arguments0Value__ = JSTypesGen.asImplicitString((state & 0b1111000) >>> 3 /* extract-implicit-active 0:String */, arguments0Value_);
                if (JSTypesGen.isImplicitString((state & 0b11110000000) >>> 7 /* extract-implicit-active 1:String */, arguments1Value_)) {
                    String arguments1Value__ = JSTypesGen.asImplicitString((state & 0b11110000000) >>> 7 /* extract-implicit-active 1:String */, arguments1Value_);
                    if ((state & 0b1) != 0 /* is-active indexOfStringUndefined(String, String, Object) */) {
                        if ((JSGuards.isUndefined(arguments2Value_))) {
                            return indexOfStringUndefined(arguments0Value__, arguments1Value__, arguments2Value_);
                        }
                    }
                    if ((state & 0b10) != 0 /* is-active indexOfStringInt(String, String, int) */ && arguments2Value_ instanceof Integer) {
                        int arguments2Value__ = (int) arguments2Value_;
                        return indexOfStringInt(arguments0Value__, arguments1Value__, arguments2Value__);
                    }
                }
            }
            if ((state & 0b100) != 0 /* is-active indexOfGeneric(Object, Object, Object, JSToStringNode) */) {
                return indexOfGeneric(arguments0Value_, arguments1Value_, arguments2Value_, this.indexOfGeneric_toString2Node_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public int executeInt(VirtualFrame frameValue) {
            int state = state_;
            if ((state & 0b101) == 0 /* only-active indexOfStringInt(String, String, int) */ && (state & 0b111) != 0  /* is-not indexOfStringUndefined(String, String, Object) && indexOfStringInt(String, String, int) && indexOfGeneric(Object, Object, Object, JSToStringNode) */) {
                return executeInt_int2(frameValue, state);
            } else {
                return executeInt_generic3(frameValue, state);
            }
        }

        private int executeInt_int2(VirtualFrame frameValue, int state) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            int arguments2Value_;
            try {
                arguments2Value_ = this.arguments2_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(arguments0Value_, arguments1Value_, ex.getResult());
            }
            assert (state & 0b10) != 0 /* is-active indexOfStringInt(String, String, int) */;
            if (JSTypesGen.isImplicitString((state & 0b1111000) >>> 3 /* extract-implicit-active 0:String */, arguments0Value_)) {
                String arguments0Value__ = JSTypesGen.asImplicitString((state & 0b1111000) >>> 3 /* extract-implicit-active 0:String */, arguments0Value_);
                if (JSTypesGen.isImplicitString((state & 0b11110000000) >>> 7 /* extract-implicit-active 1:String */, arguments1Value_)) {
                    String arguments1Value__ = JSTypesGen.asImplicitString((state & 0b11110000000) >>> 7 /* extract-implicit-active 1:String */, arguments1Value_);
                    return indexOfStringInt(arguments0Value__, arguments1Value__, arguments2Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        private int executeInt_generic3(VirtualFrame frameValue, int state) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if ((state & 0b11) != 0 /* is-active indexOfStringUndefined(String, String, Object) || indexOfStringInt(String, String, int) */ && JSTypesGen.isImplicitString((state & 0b1111000) >>> 3 /* extract-implicit-active 0:String */, arguments0Value_)) {
                String arguments0Value__ = JSTypesGen.asImplicitString((state & 0b1111000) >>> 3 /* extract-implicit-active 0:String */, arguments0Value_);
                if (JSTypesGen.isImplicitString((state & 0b11110000000) >>> 7 /* extract-implicit-active 1:String */, arguments1Value_)) {
                    String arguments1Value__ = JSTypesGen.asImplicitString((state & 0b11110000000) >>> 7 /* extract-implicit-active 1:String */, arguments1Value_);
                    if ((state & 0b1) != 0 /* is-active indexOfStringUndefined(String, String, Object) */) {
                        if ((JSGuards.isUndefined(arguments2Value_))) {
                            return indexOfStringUndefined(arguments0Value__, arguments1Value__, arguments2Value_);
                        }
                    }
                    if ((state & 0b10) != 0 /* is-active indexOfStringInt(String, String, int) */ && arguments2Value_ instanceof Integer) {
                        int arguments2Value__ = (int) arguments2Value_;
                        return indexOfStringInt(arguments0Value__, arguments1Value__, arguments2Value__);
                    }
                }
            }
            if ((state & 0b100) != 0 /* is-active indexOfGeneric(Object, Object, Object, JSToStringNode) */) {
                return indexOfGeneric(arguments0Value_, arguments1Value_, arguments2Value_, this.indexOfGeneric_toString2Node_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            executeInt(frameValue);
            return;
        }

        private int executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
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
                        int stringCast1;
                        if ((stringCast1 = JSTypesGen.specializeImplicitString(arguments1Value)) != 0) {
                            String arguments1Value_ = JSTypesGen.asImplicitString(stringCast1, arguments1Value);
                            if ((JSGuards.isUndefined(arguments2Value))) {
                                state = (state | (stringCast0 << 3) /* set-implicit-active 0:String */);
                                state = (state | (stringCast1 << 7) /* set-implicit-active 1:String */);
                                this.state_ = state = state | 0b1 /* add-active indexOfStringUndefined(String, String, Object) */;
                                lock.unlock();
                                hasLock = false;
                                return indexOfStringUndefined(arguments0Value_, arguments1Value_, arguments2Value);
                            }
                            if ((exclude) == 0 /* is-not-excluded indexOfStringInt(String, String, int) */ && arguments2Value instanceof Integer) {
                                int arguments2Value_ = (int) arguments2Value;
                                state = (state | (stringCast0 << 3) /* set-implicit-active 0:String */);
                                state = (state | (stringCast1 << 7) /* set-implicit-active 1:String */);
                                this.state_ = state = state | 0b10 /* add-active indexOfStringInt(String, String, int) */;
                                lock.unlock();
                                hasLock = false;
                                return indexOfStringInt(arguments0Value_, arguments1Value_, arguments2Value_);
                            }
                        }
                    }
                }
                this.indexOfGeneric_toString2Node_ = super.insert((JSToStringNode.create()));
                this.exclude_ = exclude = exclude | 0b1 /* add-excluded indexOfStringInt(String, String, int) */;
                state = state & 0xfffffffd /* remove-active indexOfStringInt(String, String, int) */;
                this.state_ = state = state | 0b100 /* add-active indexOfGeneric(Object, Object, Object, JSToStringNode) */;
                lock.unlock();
                hasLock = false;
                return indexOfGeneric(arguments0Value, arguments1Value, arguments2Value, this.indexOfGeneric_toString2Node_);
            } finally {
                if (hasLock) {
                    lock.unlock();
                }
            }
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
            int exclude = exclude_;
            s = new Object[3];
            s[0] = "indexOfStringUndefined";
            if ((state & 0b1) != 0 /* is-active indexOfStringUndefined(String, String, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "indexOfStringInt";
            if ((state & 0b10) != 0 /* is-active indexOfStringInt(String, String, int) */) {
                s[1] = (byte)0b01 /* active */;
            } else if (exclude != 0 /* is-excluded indexOfStringInt(String, String, int) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "indexOfGeneric";
            if ((state & 0b100) != 0 /* is-active indexOfGeneric(Object, Object, Object, JSToStringNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.indexOfGeneric_toString2Node_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static JSStringIndexOfNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSStringIndexOfNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSStringLastIndexOfNode.class)
    public static final class JSStringLastIndexOfNodeGen extends JSStringLastIndexOfNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private volatile int state_;
        @CompilationFinal private volatile int exclude_;
        @CompilationFinal private ConditionProfile searchStrZero;
        @CompilationFinal private ConditionProfile searchStrOne;
        @Child private JSToStringNode lastIndexOf_toString2Node_;
        @Child private JSToNumberNode lastIndexOf_toNumberNode_;
        @CompilationFinal private ConditionProfile lastIndexOf_posNaN_;

        private JSStringLastIndexOfNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state & 0b1011) == 0 /* only-active lastIndexOfString(String, String, int, ConditionProfile, ConditionProfile) */ && (state & 0b1111) != 0  /* is-not lastIndexOfChar(String, String, Object) && lastIndexOfString(String, String, Object, ConditionProfile, ConditionProfile) && lastIndexOfString(String, String, int, ConditionProfile, ConditionProfile) && lastIndexOf(Object, Object, Object, JSToStringNode, JSToNumberNode, ConditionProfile, ConditionProfile, ConditionProfile) */) {
                return execute_int0(frameValue, state);
            } else {
                return execute_generic1(frameValue, state);
            }
        }

        private Object execute_int0(VirtualFrame frameValue, int state) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            int arguments2Value_;
            try {
                arguments2Value_ = this.arguments2_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(arguments0Value_, arguments1Value_, ex.getResult());
            }
            assert (state & 0b100) != 0 /* is-active lastIndexOfString(String, String, int, ConditionProfile, ConditionProfile) */;
            if (JSTypesGen.isImplicitString((state & 0b11110000) >>> 4 /* extract-implicit-active 0:String */, arguments0Value_)) {
                String arguments0Value__ = JSTypesGen.asImplicitString((state & 0b11110000) >>> 4 /* extract-implicit-active 0:String */, arguments0Value_);
                if (JSTypesGen.isImplicitString((state & 0b111100000000) >>> 8 /* extract-implicit-active 1:String */, arguments1Value_)) {
                    String arguments1Value__ = JSTypesGen.asImplicitString((state & 0b111100000000) >>> 8 /* extract-implicit-active 1:String */, arguments1Value_);
                    return lastIndexOfString(arguments0Value__, arguments1Value__, arguments2Value_, this.searchStrZero, this.searchStrOne);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        private Object execute_generic1(VirtualFrame frameValue, int state) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if ((state & 0b111) != 0 /* is-active lastIndexOfChar(String, String, Object) || lastIndexOfString(String, String, Object, ConditionProfile, ConditionProfile) || lastIndexOfString(String, String, int, ConditionProfile, ConditionProfile) */ && JSTypesGen.isImplicitString((state & 0b11110000) >>> 4 /* extract-implicit-active 0:String */, arguments0Value_)) {
                String arguments0Value__ = JSTypesGen.asImplicitString((state & 0b11110000) >>> 4 /* extract-implicit-active 0:String */, arguments0Value_);
                if (JSTypesGen.isImplicitString((state & 0b111100000000) >>> 8 /* extract-implicit-active 1:String */, arguments1Value_)) {
                    String arguments1Value__ = JSTypesGen.asImplicitString((state & 0b111100000000) >>> 8 /* extract-implicit-active 1:String */, arguments1Value_);
                    if ((state & 0b11) != 0 /* is-active lastIndexOfChar(String, String, Object) || lastIndexOfString(String, String, Object, ConditionProfile, ConditionProfile) */) {
                        if ((state & 0b1) != 0 /* is-active lastIndexOfChar(String, String, Object) */) {
                            if ((isStringLength1(arguments1Value__)) && (JSGuards.isUndefined(arguments2Value_))) {
                                return lastIndexOfChar(arguments0Value__, arguments1Value__, arguments2Value_);
                            }
                        }
                        if ((state & 0b10) != 0 /* is-active lastIndexOfString(String, String, Object, ConditionProfile, ConditionProfile) */) {
                            if ((JSGuards.isUndefined(arguments2Value_))) {
                                return lastIndexOfString(arguments0Value__, arguments1Value__, arguments2Value_, this.searchStrZero, this.searchStrOne);
                            }
                        }
                    }
                    if ((state & 0b100) != 0 /* is-active lastIndexOfString(String, String, int, ConditionProfile, ConditionProfile) */ && arguments2Value_ instanceof Integer) {
                        int arguments2Value__ = (int) arguments2Value_;
                        return lastIndexOfString(arguments0Value__, arguments1Value__, arguments2Value__, this.searchStrZero, this.searchStrOne);
                    }
                }
            }
            if ((state & 0b1000) != 0 /* is-active lastIndexOf(Object, Object, Object, JSToStringNode, JSToNumberNode, ConditionProfile, ConditionProfile, ConditionProfile) */) {
                return lastIndexOf(arguments0Value_, arguments1Value_, arguments2Value_, this.lastIndexOf_toString2Node_, this.lastIndexOf_toNumberNode_, this.lastIndexOf_posNaN_, this.searchStrZero, this.searchStrOne);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public int executeInt(VirtualFrame frameValue) {
            int state = state_;
            if ((state & 0b1011) == 0 /* only-active lastIndexOfString(String, String, int, ConditionProfile, ConditionProfile) */ && (state & 0b1111) != 0  /* is-not lastIndexOfChar(String, String, Object) && lastIndexOfString(String, String, Object, ConditionProfile, ConditionProfile) && lastIndexOfString(String, String, int, ConditionProfile, ConditionProfile) && lastIndexOf(Object, Object, Object, JSToStringNode, JSToNumberNode, ConditionProfile, ConditionProfile, ConditionProfile) */) {
                return executeInt_int2(frameValue, state);
            } else {
                return executeInt_generic3(frameValue, state);
            }
        }

        private int executeInt_int2(VirtualFrame frameValue, int state) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            int arguments2Value_;
            try {
                arguments2Value_ = this.arguments2_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(arguments0Value_, arguments1Value_, ex.getResult());
            }
            assert (state & 0b100) != 0 /* is-active lastIndexOfString(String, String, int, ConditionProfile, ConditionProfile) */;
            if (JSTypesGen.isImplicitString((state & 0b11110000) >>> 4 /* extract-implicit-active 0:String */, arguments0Value_)) {
                String arguments0Value__ = JSTypesGen.asImplicitString((state & 0b11110000) >>> 4 /* extract-implicit-active 0:String */, arguments0Value_);
                if (JSTypesGen.isImplicitString((state & 0b111100000000) >>> 8 /* extract-implicit-active 1:String */, arguments1Value_)) {
                    String arguments1Value__ = JSTypesGen.asImplicitString((state & 0b111100000000) >>> 8 /* extract-implicit-active 1:String */, arguments1Value_);
                    return lastIndexOfString(arguments0Value__, arguments1Value__, arguments2Value_, this.searchStrZero, this.searchStrOne);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        private int executeInt_generic3(VirtualFrame frameValue, int state) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if ((state & 0b111) != 0 /* is-active lastIndexOfChar(String, String, Object) || lastIndexOfString(String, String, Object, ConditionProfile, ConditionProfile) || lastIndexOfString(String, String, int, ConditionProfile, ConditionProfile) */ && JSTypesGen.isImplicitString((state & 0b11110000) >>> 4 /* extract-implicit-active 0:String */, arguments0Value_)) {
                String arguments0Value__ = JSTypesGen.asImplicitString((state & 0b11110000) >>> 4 /* extract-implicit-active 0:String */, arguments0Value_);
                if (JSTypesGen.isImplicitString((state & 0b111100000000) >>> 8 /* extract-implicit-active 1:String */, arguments1Value_)) {
                    String arguments1Value__ = JSTypesGen.asImplicitString((state & 0b111100000000) >>> 8 /* extract-implicit-active 1:String */, arguments1Value_);
                    if ((state & 0b11) != 0 /* is-active lastIndexOfChar(String, String, Object) || lastIndexOfString(String, String, Object, ConditionProfile, ConditionProfile) */) {
                        if ((state & 0b1) != 0 /* is-active lastIndexOfChar(String, String, Object) */) {
                            if ((isStringLength1(arguments1Value__)) && (JSGuards.isUndefined(arguments2Value_))) {
                                return lastIndexOfChar(arguments0Value__, arguments1Value__, arguments2Value_);
                            }
                        }
                        if ((state & 0b10) != 0 /* is-active lastIndexOfString(String, String, Object, ConditionProfile, ConditionProfile) */) {
                            if ((JSGuards.isUndefined(arguments2Value_))) {
                                return lastIndexOfString(arguments0Value__, arguments1Value__, arguments2Value_, this.searchStrZero, this.searchStrOne);
                            }
                        }
                    }
                    if ((state & 0b100) != 0 /* is-active lastIndexOfString(String, String, int, ConditionProfile, ConditionProfile) */ && arguments2Value_ instanceof Integer) {
                        int arguments2Value__ = (int) arguments2Value_;
                        return lastIndexOfString(arguments0Value__, arguments1Value__, arguments2Value__, this.searchStrZero, this.searchStrOne);
                    }
                }
            }
            if ((state & 0b1000) != 0 /* is-active lastIndexOf(Object, Object, Object, JSToStringNode, JSToNumberNode, ConditionProfile, ConditionProfile, ConditionProfile) */) {
                return lastIndexOf(arguments0Value_, arguments1Value_, arguments2Value_, this.lastIndexOf_toString2Node_, this.lastIndexOf_toNumberNode_, this.lastIndexOf_posNaN_, this.searchStrZero, this.searchStrOne);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            executeInt(frameValue);
            return;
        }

        private int executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
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
                        int stringCast1;
                        if ((stringCast1 = JSTypesGen.specializeImplicitString(arguments1Value)) != 0) {
                            String arguments1Value_ = JSTypesGen.asImplicitString(stringCast1, arguments1Value);
                            if (((exclude & 0b1)) == 0 /* is-not-excluded lastIndexOfChar(String, String, Object) */) {
                                if ((isStringLength1(arguments1Value_)) && (JSGuards.isUndefined(arguments2Value))) {
                                    state = (state | (stringCast0 << 4) /* set-implicit-active 0:String */);
                                    state = (state | (stringCast1 << 8) /* set-implicit-active 1:String */);
                                    this.state_ = state = state | 0b1 /* add-active lastIndexOfChar(String, String, Object) */;
                                    lock.unlock();
                                    hasLock = false;
                                    return lastIndexOfChar(arguments0Value_, arguments1Value_, arguments2Value);
                                }
                            }
                            if (((exclude & 0b10)) == 0 /* is-not-excluded lastIndexOfString(String, String, Object, ConditionProfile, ConditionProfile) */) {
                                if ((JSGuards.isUndefined(arguments2Value))) {
                                    if (this.searchStrZero == null) {
                                        this.searchStrZero = (ConditionProfile.createBinaryProfile());
                                    }
                                    if (this.searchStrOne == null) {
                                        this.searchStrOne = (ConditionProfile.createBinaryProfile());
                                    }
                                    state = (state | (stringCast0 << 4) /* set-implicit-active 0:String */);
                                    state = (state | (stringCast1 << 8) /* set-implicit-active 1:String */);
                                    this.state_ = state = state | 0b10 /* add-active lastIndexOfString(String, String, Object, ConditionProfile, ConditionProfile) */;
                                    lock.unlock();
                                    hasLock = false;
                                    return lastIndexOfString(arguments0Value_, arguments1Value_, arguments2Value, this.searchStrZero, this.searchStrOne);
                                }
                            }
                            if (((exclude & 0b100)) == 0 /* is-not-excluded lastIndexOfString(String, String, int, ConditionProfile, ConditionProfile) */ && arguments2Value instanceof Integer) {
                                int arguments2Value_ = (int) arguments2Value;
                                if (this.searchStrZero == null) {
                                    this.searchStrZero = (ConditionProfile.createBinaryProfile());
                                }
                                if (this.searchStrOne == null) {
                                    this.searchStrOne = (ConditionProfile.createBinaryProfile());
                                }
                                state = (state | (stringCast0 << 4) /* set-implicit-active 0:String */);
                                state = (state | (stringCast1 << 8) /* set-implicit-active 1:String */);
                                this.state_ = state = state | 0b100 /* add-active lastIndexOfString(String, String, int, ConditionProfile, ConditionProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return lastIndexOfString(arguments0Value_, arguments1Value_, arguments2Value_, this.searchStrZero, this.searchStrOne);
                            }
                        }
                    }
                }
                this.lastIndexOf_toString2Node_ = super.insert((JSToStringNode.create()));
                this.lastIndexOf_toNumberNode_ = super.insert((JSToNumberNode.create()));
                this.lastIndexOf_posNaN_ = (ConditionProfile.createBinaryProfile());
                if (this.searchStrZero == null) {
                    this.searchStrZero = (ConditionProfile.createBinaryProfile());
                }
                if (this.searchStrOne == null) {
                    this.searchStrOne = (ConditionProfile.createBinaryProfile());
                }
                this.exclude_ = exclude = exclude | 0b111 /* add-excluded lastIndexOfChar(String, String, Object), lastIndexOfString(String, String, Object, ConditionProfile, ConditionProfile), lastIndexOfString(String, String, int, ConditionProfile, ConditionProfile) */;
                state = state & 0xfffffff8 /* remove-active lastIndexOfChar(String, String, Object), lastIndexOfString(String, String, Object, ConditionProfile, ConditionProfile), lastIndexOfString(String, String, int, ConditionProfile, ConditionProfile) */;
                this.state_ = state = state | 0b1000 /* add-active lastIndexOf(Object, Object, Object, JSToStringNode, JSToNumberNode, ConditionProfile, ConditionProfile, ConditionProfile) */;
                lock.unlock();
                hasLock = false;
                return lastIndexOf(arguments0Value, arguments1Value, arguments2Value, this.lastIndexOf_toString2Node_, this.lastIndexOf_toNumberNode_, this.lastIndexOf_posNaN_, this.searchStrZero, this.searchStrOne);
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
            int exclude = exclude_;
            s = new Object[3];
            s[0] = "lastIndexOfChar";
            if ((state & 0b1) != 0 /* is-active lastIndexOfChar(String, String, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else if ((exclude & 0b1) != 0 /* is-excluded lastIndexOfChar(String, String, Object) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "lastIndexOfString";
            if ((state & 0b10) != 0 /* is-active lastIndexOfString(String, String, Object, ConditionProfile, ConditionProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.searchStrZero, this.searchStrOne));
                s[2] = cached;
            } else if ((exclude & 0b10) != 0 /* is-excluded lastIndexOfString(String, String, Object, ConditionProfile, ConditionProfile) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "lastIndexOfString";
            if ((state & 0b100) != 0 /* is-active lastIndexOfString(String, String, int, ConditionProfile, ConditionProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.searchStrZero, this.searchStrOne));
                s[2] = cached;
            } else if ((exclude & 0b100) != 0 /* is-excluded lastIndexOfString(String, String, int, ConditionProfile, ConditionProfile) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "lastIndexOf";
            if ((state & 0b1000) != 0 /* is-active lastIndexOf(Object, Object, Object, JSToStringNode, JSToNumberNode, ConditionProfile, ConditionProfile, ConditionProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.lastIndexOf_toString2Node_, this.lastIndexOf_toNumberNode_, this.lastIndexOf_posNaN_, this.searchStrZero, this.searchStrOne));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            return Provider.create(data);
        }

        public static JSStringLastIndexOfNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSStringLastIndexOfNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSStringSplitNode.class)
    public static final class JSStringSplitNodeGen extends JSStringSplitNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private int state_;

        private JSStringSplitNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state & 0b1) != 0 /* is-active splitES5(Object, Object, Object) */) {
                assert (!(isES6OrNewer()));
                return splitES5(arguments0Value_, arguments1Value_, arguments2Value_);
            }
            if ((state & 0b10) != 0 /* is-active splitES6StrStrUndefined(String, String, DynamicObject) */ && JSTypesGen.isImplicitString((state & 0b1111000) >>> 3 /* extract-implicit-active 0:String */, arguments0Value_)) {
                String arguments0Value__ = JSTypesGen.asImplicitString((state & 0b1111000) >>> 3 /* extract-implicit-active 0:String */, arguments0Value_);
                if (JSTypesGen.isImplicitString((state & 0b11110000000) >>> 7 /* extract-implicit-active 1:String */, arguments1Value_)) {
                    String arguments1Value__ = JSTypesGen.asImplicitString((state & 0b11110000000) >>> 7 /* extract-implicit-active 1:String */, arguments1Value_);
                    if (JSTypes.isDynamicObject(arguments2Value_)) {
                        DynamicObject arguments2Value__ = (DynamicObject) arguments2Value_;
                        assert (isES6OrNewer());
                        if ((isFastPath(arguments0Value__, arguments1Value__, arguments2Value__))) {
                            return splitES6StrStrUndefined(arguments0Value__, arguments1Value__, arguments2Value__);
                        }
                    }
                }
            }
            if ((state & 0b100) != 0 /* is-active splitES6Generic(Object, Object, Object) */) {
                assert (isES6OrNewer());
                if ((!(isFastPath(arguments0Value_, arguments1Value_, arguments2Value_)))) {
                    return splitES6Generic(arguments0Value_, arguments1Value_, arguments2Value_);
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
            if ((!(isES6OrNewer()))) {
                this.state_ = state = state | 0b1 /* add-active splitES5(Object, Object, Object) */;
                return splitES5(arguments0Value, arguments1Value, arguments2Value);
            }
            {
                int stringCast0;
                if ((stringCast0 = JSTypesGen.specializeImplicitString(arguments0Value)) != 0) {
                    String arguments0Value_ = JSTypesGen.asImplicitString(stringCast0, arguments0Value);
                    int stringCast1;
                    if ((stringCast1 = JSTypesGen.specializeImplicitString(arguments1Value)) != 0) {
                        String arguments1Value_ = JSTypesGen.asImplicitString(stringCast1, arguments1Value);
                        if (JSTypes.isDynamicObject(arguments2Value)) {
                            DynamicObject arguments2Value_ = (DynamicObject) arguments2Value;
                            if ((isES6OrNewer()) && (isFastPath(arguments0Value_, arguments1Value_, arguments2Value_))) {
                                state = (state | (stringCast0 << 3) /* set-implicit-active 0:String */);
                                state = (state | (stringCast1 << 7) /* set-implicit-active 1:String */);
                                this.state_ = state = state | 0b10 /* add-active splitES6StrStrUndefined(String, String, DynamicObject) */;
                                return splitES6StrStrUndefined(arguments0Value_, arguments1Value_, arguments2Value_);
                            }
                        }
                    }
                }
            }
            if ((isES6OrNewer()) && (!(isFastPath(arguments0Value, arguments1Value, arguments2Value)))) {
                this.state_ = state = state | 0b100 /* add-active splitES6Generic(Object, Object, Object) */;
                return splitES6Generic(arguments0Value, arguments1Value, arguments2Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_, this.arguments2_}, arguments0Value, arguments1Value, arguments2Value);
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
            s[0] = "splitES5";
            if ((state & 0b1) != 0 /* is-active splitES5(Object, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "splitES6StrStrUndefined";
            if ((state & 0b10) != 0 /* is-active splitES6StrStrUndefined(String, String, DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "splitES6Generic";
            if ((state & 0b100) != 0 /* is-active splitES6Generic(Object, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static JSStringSplitNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSStringSplitNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSStringConcatNode.class)
    public static final class JSStringConcatNodeGen extends JSStringConcatNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_;
        @Child private JSToStringNode toString2Node_;

        private JSStringConcatNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state != 0 /* is-active concat(Object, Object[], JSToStringNode) */ && arguments1Value_ instanceof Object[]) {
                Object[] arguments1Value__ = (Object[]) arguments1Value_;
                return concat(arguments0Value_, arguments1Value__, this.toString2Node_);
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
                if (arguments1Value instanceof Object[]) {
                    Object[] arguments1Value_ = (Object[]) arguments1Value;
                    this.toString2Node_ = super.insert((JSToStringNode.create()));
                    this.state_ = state = state | 0b1 /* add-active concat(Object, Object[], JSToStringNode) */;
                    lock.unlock();
                    hasLock = false;
                    return concat(arguments0Value, arguments1Value_, this.toString2Node_);
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
            s[0] = "concat";
            if (state != 0 /* is-active concat(Object, Object[], JSToStringNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.toString2Node_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static JSStringConcatNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSStringConcatNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSStringReplaceNode.class)
    public static final class JSStringReplaceNodeGen extends JSStringReplaceNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private volatile int state_;
        @CompilationFinal private volatile int exclude_;
        @CompilationFinal private ReplaceStringCachedData replaceStringCached_cache;

        private JSStringReplaceNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
            this.arguments2_ = arguments != null && 2 < arguments.length ? arguments[2] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_, this.arguments2_};
        }

        @ExplodeLoop
        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if ((state & 0b111) != 0 /* is-active replaceStringCached(Object, String, String, String, Token[]) || replaceString(Object, String, String) || replaceGeneric(Object, Object, Object) */) {
                if ((state & 0b11) != 0 /* is-active replaceStringCached(Object, String, String, String, Token[]) || replaceString(Object, String, String) */ && JSTypesGen.isImplicitString((state & 0b1111000) >>> 3 /* extract-implicit-active 1:String */, arguments1Value_)) {
                    String arguments1Value__ = JSTypesGen.asImplicitString((state & 0b1111000) >>> 3 /* extract-implicit-active 1:String */, arguments1Value_);
                    if (JSTypesGen.isImplicitString((state & 0b11110000000) >>> 7 /* extract-implicit-active 2:String */, arguments2Value_)) {
                        String arguments2Value__ = JSTypesGen.asImplicitString((state & 0b11110000000) >>> 7 /* extract-implicit-active 2:String */, arguments2Value_);
                        if ((state & 0b1) != 0 /* is-active replaceStringCached(Object, String, String, String, Token[]) */) {
                            ReplaceStringCachedData s1_ = this.replaceStringCached_cache;
                            while (s1_ != null) {
                                if ((s1_.cachedReplaceValue_.equals(arguments2Value__))) {
                                    return replaceStringCached(arguments0Value_, arguments1Value__, arguments2Value__, s1_.cachedReplaceValue_, s1_.cachedParsedReplaceValue_);
                                }
                                s1_ = s1_.next_;
                            }
                        }
                        if ((state & 0b10) != 0 /* is-active replaceString(Object, String, String) */) {
                            return replaceString(arguments0Value_, arguments1Value__, arguments2Value__);
                        }
                    }
                }
                if ((state & 0b100) != 0 /* is-active replaceGeneric(Object, Object, Object) */) {
                    if ((!(isStringString(arguments1Value_, arguments2Value_)))) {
                        return replaceGeneric(arguments0Value_, arguments1Value_, arguments2Value_);
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
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int exclude = exclude_;
            try {
                {
                    int stringCast1;
                    if ((stringCast1 = JSTypesGen.specializeImplicitString(arguments1Value)) != 0) {
                        String arguments1Value_ = JSTypesGen.asImplicitString(stringCast1, arguments1Value);
                        int stringCast2;
                        if ((stringCast2 = JSTypesGen.specializeImplicitString(arguments2Value)) != 0) {
                            String arguments2Value_ = JSTypesGen.asImplicitString(stringCast2, arguments2Value);
                            if ((exclude) == 0 /* is-not-excluded replaceStringCached(Object, String, String, String, Token[]) */) {
                                int count1_ = 0;
                                ReplaceStringCachedData s1_ = this.replaceStringCached_cache;
                                if ((state & 0b1) != 0 /* is-active replaceStringCached(Object, String, String, String, Token[]) */) {
                                    while (s1_ != null) {
                                        if ((s1_.cachedReplaceValue_.equals(arguments2Value_))) {
                                            break;
                                        }
                                        s1_ = s1_.next_;
                                        count1_++;
                                    }
                                }
                                if (s1_ == null) {
                                    // assert (s1_.cachedReplaceValue_.equals(arguments2Value_));
                                    if (count1_ < (3)) {
                                        s1_ = new ReplaceStringCachedData(replaceStringCached_cache);
                                        s1_.cachedReplaceValue_ = (arguments2Value_);
                                        s1_.cachedParsedReplaceValue_ = (JSStringReplaceBaseNode.parseReplaceValue(arguments2Value_));
                                        this.replaceStringCached_cache = s1_;
                                        state = (state | (stringCast1 << 3) /* set-implicit-active 1:String */);
                                        state = (state | (stringCast2 << 7) /* set-implicit-active 2:String */);
                                        this.state_ = state = state | 0b1 /* add-active replaceStringCached(Object, String, String, String, Token[]) */;
                                    }
                                } else {
                                    state = (state | (stringCast1 << 3) /* set-implicit-active 1:String */);
                                    state = (state | (stringCast2 << 7) /* set-implicit-active 2:String */);
                                    this.state_ = state = state | 0b1 /* add-active replaceStringCached(Object, String, String, String, Token[]) */;
                                }
                                if (s1_ != null) {
                                    lock.unlock();
                                    hasLock = false;
                                    return replaceStringCached(arguments0Value, arguments1Value_, arguments2Value_, s1_.cachedReplaceValue_, s1_.cachedParsedReplaceValue_);
                                }
                            }
                            this.exclude_ = exclude = exclude | 0b1 /* add-excluded replaceStringCached(Object, String, String, String, Token[]) */;
                            this.replaceStringCached_cache = null;
                            state = state & 0xfffffffe /* remove-active replaceStringCached(Object, String, String, String, Token[]) */;
                            state = (state | (stringCast1 << 3) /* set-implicit-active 1:String */);
                            state = (state | (stringCast2 << 7) /* set-implicit-active 2:String */);
                            this.state_ = state = state | 0b10 /* add-active replaceString(Object, String, String) */;
                            lock.unlock();
                            hasLock = false;
                            return replaceString(arguments0Value, arguments1Value_, arguments2Value_);
                        }
                    }
                }
                if ((!(isStringString(arguments1Value, arguments2Value)))) {
                    this.state_ = state = state | 0b100 /* add-active replaceGeneric(Object, Object, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return replaceGeneric(arguments0Value, arguments1Value, arguments2Value);
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
            if ((state & 0b111) == 0b0) {
                return NodeCost.UNINITIALIZED;
            } else if (((state & 0b111) & ((state & 0b111) - 1)) == 0 /* is-single-active  */) {
                ReplaceStringCachedData s1_ = this.replaceStringCached_cache;
                if ((s1_ == null || s1_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[4];
            Object[] s;
            data[0] = 0;
            int state = state_;
            int exclude = exclude_;
            s = new Object[3];
            s[0] = "replaceStringCached";
            if ((state & 0b1) != 0 /* is-active replaceStringCached(Object, String, String, String, Token[]) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                ReplaceStringCachedData s1_ = this.replaceStringCached_cache;
                while (s1_ != null) {
                    cached.add(Arrays.asList(s1_.cachedReplaceValue_, s1_.cachedParsedReplaceValue_));
                    s1_ = s1_.next_;
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-excluded replaceStringCached(Object, String, String, String, Token[]) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "replaceString";
            if ((state & 0b10) != 0 /* is-active replaceString(Object, String, String) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "replaceGeneric";
            if ((state & 0b100) != 0 /* is-active replaceGeneric(Object, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static JSStringReplaceNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSStringReplaceNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(JSStringReplaceNode.class)
        private static final class ReplaceStringCachedData {

            @CompilationFinal ReplaceStringCachedData next_;
            @CompilationFinal String cachedReplaceValue_;
            @CompilationFinal(dimensions = 1) Token[] cachedParsedReplaceValue_;

            ReplaceStringCachedData(ReplaceStringCachedData next_) {
                this.next_ = next_;
            }

        }
    }
    @GeneratedBy(JSStringReplaceAllNode.class)
    public static final class JSStringReplaceAllNodeGen extends JSStringReplaceAllNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private volatile int state_;
        @CompilationFinal private volatile int exclude_;
        @CompilationFinal private ReplaceStringCachedData replaceStringCached_cache;

        private JSStringReplaceAllNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
            this.arguments2_ = arguments != null && 2 < arguments.length ? arguments[2] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_, this.arguments2_};
        }

        @ExplodeLoop
        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if ((state & 0b111) != 0 /* is-active replaceStringCached(Object, String, String, String, Token[]) || replaceString(Object, String, String) || replaceGeneric(Object, Object, Object) */) {
                if ((state & 0b11) != 0 /* is-active replaceStringCached(Object, String, String, String, Token[]) || replaceString(Object, String, String) */ && JSTypesGen.isImplicitString((state & 0b1111000) >>> 3 /* extract-implicit-active 1:String */, arguments1Value_)) {
                    String arguments1Value__ = JSTypesGen.asImplicitString((state & 0b1111000) >>> 3 /* extract-implicit-active 1:String */, arguments1Value_);
                    if (JSTypesGen.isImplicitString((state & 0b11110000000) >>> 7 /* extract-implicit-active 2:String */, arguments2Value_)) {
                        String arguments2Value__ = JSTypesGen.asImplicitString((state & 0b11110000000) >>> 7 /* extract-implicit-active 2:String */, arguments2Value_);
                        if ((state & 0b1) != 0 /* is-active replaceStringCached(Object, String, String, String, Token[]) */) {
                            ReplaceStringCachedData s1_ = this.replaceStringCached_cache;
                            while (s1_ != null) {
                                if ((s1_.cachedReplaceValue_.equals(arguments2Value__))) {
                                    return replaceStringCached(arguments0Value_, arguments1Value__, arguments2Value__, s1_.cachedReplaceValue_, s1_.cachedParsedReplaceValue_);
                                }
                                s1_ = s1_.next_;
                            }
                        }
                        if ((state & 0b10) != 0 /* is-active replaceString(Object, String, String) */) {
                            return replaceString(arguments0Value_, arguments1Value__, arguments2Value__);
                        }
                    }
                }
                if ((state & 0b100) != 0 /* is-active replaceGeneric(Object, Object, Object) */) {
                    return replaceGeneric(arguments0Value_, arguments1Value_, arguments2Value_);
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
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int exclude = exclude_;
            try {
                {
                    int stringCast1;
                    if ((stringCast1 = JSTypesGen.specializeImplicitString(arguments1Value)) != 0) {
                        String arguments1Value_ = JSTypesGen.asImplicitString(stringCast1, arguments1Value);
                        int stringCast2;
                        if ((stringCast2 = JSTypesGen.specializeImplicitString(arguments2Value)) != 0) {
                            String arguments2Value_ = JSTypesGen.asImplicitString(stringCast2, arguments2Value);
                            if (((exclude & 0b1)) == 0 /* is-not-excluded replaceStringCached(Object, String, String, String, Token[]) */) {
                                int count1_ = 0;
                                ReplaceStringCachedData s1_ = this.replaceStringCached_cache;
                                if ((state & 0b1) != 0 /* is-active replaceStringCached(Object, String, String, String, Token[]) */) {
                                    while (s1_ != null) {
                                        if ((s1_.cachedReplaceValue_.equals(arguments2Value_))) {
                                            break;
                                        }
                                        s1_ = s1_.next_;
                                        count1_++;
                                    }
                                }
                                if (s1_ == null) {
                                    // assert (s1_.cachedReplaceValue_.equals(arguments2Value_));
                                    if (count1_ < (3)) {
                                        s1_ = new ReplaceStringCachedData(replaceStringCached_cache);
                                        s1_.cachedReplaceValue_ = (arguments2Value_);
                                        s1_.cachedParsedReplaceValue_ = (JSStringReplaceBaseNode.parseReplaceValue(arguments2Value_));
                                        this.replaceStringCached_cache = s1_;
                                        state = (state | (stringCast1 << 3) /* set-implicit-active 1:String */);
                                        state = (state | (stringCast2 << 7) /* set-implicit-active 2:String */);
                                        this.state_ = state = state | 0b1 /* add-active replaceStringCached(Object, String, String, String, Token[]) */;
                                    }
                                } else {
                                    state = (state | (stringCast1 << 3) /* set-implicit-active 1:String */);
                                    state = (state | (stringCast2 << 7) /* set-implicit-active 2:String */);
                                    this.state_ = state = state | 0b1 /* add-active replaceStringCached(Object, String, String, String, Token[]) */;
                                }
                                if (s1_ != null) {
                                    lock.unlock();
                                    hasLock = false;
                                    return replaceStringCached(arguments0Value, arguments1Value_, arguments2Value_, s1_.cachedReplaceValue_, s1_.cachedParsedReplaceValue_);
                                }
                            }
                            if (((exclude & 0b10)) == 0 /* is-not-excluded replaceString(Object, String, String) */) {
                                this.exclude_ = exclude = exclude | 0b1 /* add-excluded replaceStringCached(Object, String, String, String, Token[]) */;
                                this.replaceStringCached_cache = null;
                                state = state & 0xfffffffe /* remove-active replaceStringCached(Object, String, String, String, Token[]) */;
                                state = (state | (stringCast1 << 3) /* set-implicit-active 1:String */);
                                state = (state | (stringCast2 << 7) /* set-implicit-active 2:String */);
                                this.state_ = state = state | 0b10 /* add-active replaceString(Object, String, String) */;
                                lock.unlock();
                                hasLock = false;
                                return replaceString(arguments0Value, arguments1Value_, arguments2Value_);
                            }
                        }
                    }
                }
                this.exclude_ = exclude = exclude | 0b11 /* add-excluded replaceStringCached(Object, String, String, String, Token[]), replaceString(Object, String, String) */;
                this.replaceStringCached_cache = null;
                state = state & 0xfffffffc /* remove-active replaceStringCached(Object, String, String, String, Token[]), replaceString(Object, String, String) */;
                this.state_ = state = state | 0b100 /* add-active replaceGeneric(Object, Object, Object) */;
                lock.unlock();
                hasLock = false;
                return replaceGeneric(arguments0Value, arguments1Value, arguments2Value);
            } finally {
                if (hasLock) {
                    lock.unlock();
                }
            }
        }

        @Override
        public NodeCost getCost() {
            int state = state_;
            if ((state & 0b111) == 0b0) {
                return NodeCost.UNINITIALIZED;
            } else if (((state & 0b111) & ((state & 0b111) - 1)) == 0 /* is-single-active  */) {
                ReplaceStringCachedData s1_ = this.replaceStringCached_cache;
                if ((s1_ == null || s1_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[4];
            Object[] s;
            data[0] = 0;
            int state = state_;
            int exclude = exclude_;
            s = new Object[3];
            s[0] = "replaceStringCached";
            if ((state & 0b1) != 0 /* is-active replaceStringCached(Object, String, String, String, Token[]) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                ReplaceStringCachedData s1_ = this.replaceStringCached_cache;
                while (s1_ != null) {
                    cached.add(Arrays.asList(s1_.cachedReplaceValue_, s1_.cachedParsedReplaceValue_));
                    s1_ = s1_.next_;
                }
                s[2] = cached;
            } else if ((exclude & 0b1) != 0 /* is-excluded replaceStringCached(Object, String, String, String, Token[]) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "replaceString";
            if ((state & 0b10) != 0 /* is-active replaceString(Object, String, String) */) {
                s[1] = (byte)0b01 /* active */;
            } else if ((exclude & 0b10) != 0 /* is-excluded replaceString(Object, String, String) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "replaceGeneric";
            if ((state & 0b100) != 0 /* is-active replaceGeneric(Object, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static JSStringReplaceAllNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSStringReplaceAllNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(JSStringReplaceAllNode.class)
        private static final class ReplaceStringCachedData {

            @CompilationFinal ReplaceStringCachedData next_;
            @CompilationFinal String cachedReplaceValue_;
            @CompilationFinal(dimensions = 1) Token[] cachedParsedReplaceValue_;

            ReplaceStringCachedData(ReplaceStringCachedData next_) {
                this.next_ = next_;
            }

        }
    }
    @GeneratedBy(JSStringReplaceES5Node.class)
    public static final class JSStringReplaceES5NodeGen extends JSStringReplaceES5Node implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;

        private JSStringReplaceES5NodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            return replace(arguments0Value_, arguments1Value_, arguments2Value_);
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
            s[0] = "replace";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSStringReplaceES5Node create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSStringReplaceES5NodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSStringToStringNode.class)
    public static final class JSStringToStringNodeGen extends JSStringToStringNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_;
        @Child private JSStringToStringNode toStringString_nestedToString_;

        private JSStringToStringNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        protected String executeString(Object arguments0Value) {
            int state = state_;
            if ((state & 0b1) != 0 /* is-active toStringString(DynamicObject, JSStringToStringNode) */ && JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((JSGuards.isJSString(arguments0Value_))) {
                    return toStringString(arguments0Value_, this.toStringString_nestedToString_);
                }
            }
            if ((state & 0b10) != 0 /* is-active toStringCharseq(CharSequence) */ && JSTypesGen.isImplicitCharSequence((state & 0b1111000) >>> 3 /* extract-implicit-active 0:CharSequence */, arguments0Value)) {
                CharSequence arguments0Value_ = JSTypesGen.asImplicitCharSequence((state & 0b1111000) >>> 3 /* extract-implicit-active 0:CharSequence */, arguments0Value);
                return toStringCharseq(arguments0Value_);
            }
            if ((state & 0b100) != 0 /* is-active toStringGeneric(Object) */) {
                if ((!(JSGuards.isString(arguments0Value))) && (!(JSGuards.isJSString(arguments0Value)))) {
                    return toStringGeneric(arguments0Value);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value);
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state & 0b1) != 0 /* is-active toStringString(DynamicObject, JSStringToStringNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((JSGuards.isJSString(arguments0Value__))) {
                    return toStringString(arguments0Value__, this.toStringString_nestedToString_);
                }
            }
            if ((state & 0b10) != 0 /* is-active toStringCharseq(CharSequence) */ && JSTypesGen.isImplicitCharSequence((state & 0b1111000) >>> 3 /* extract-implicit-active 0:CharSequence */, arguments0Value_)) {
                CharSequence arguments0Value__ = JSTypesGen.asImplicitCharSequence((state & 0b1111000) >>> 3 /* extract-implicit-active 0:CharSequence */, arguments0Value_);
                return toStringCharseq(arguments0Value__);
            }
            if ((state & 0b100) != 0 /* is-active toStringGeneric(Object) */) {
                if ((!(JSGuards.isString(arguments0Value_))) && (!(JSGuards.isJSString(arguments0Value_)))) {
                    return toStringGeneric(arguments0Value_);
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
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            try {
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSString(arguments0Value_))) {
                        this.toStringString_nestedToString_ = super.insert((JSStringToStringNode.createStringToString(getContext())));
                        this.state_ = state = state | 0b1 /* add-active toStringString(DynamicObject, JSStringToStringNode) */;
                        lock.unlock();
                        hasLock = false;
                        return toStringString(arguments0Value_, this.toStringString_nestedToString_);
                    }
                }
                {
                    int charSequenceCast0;
                    if ((charSequenceCast0 = JSTypesGen.specializeImplicitCharSequence(arguments0Value)) != 0) {
                        CharSequence arguments0Value_ = JSTypesGen.asImplicitCharSequence(charSequenceCast0, arguments0Value);
                        state = (state | (charSequenceCast0 << 3) /* set-implicit-active 0:CharSequence */);
                        this.state_ = state = state | 0b10 /* add-active toStringCharseq(CharSequence) */;
                        lock.unlock();
                        hasLock = false;
                        return toStringCharseq(arguments0Value_);
                    }
                }
                if ((!(JSGuards.isString(arguments0Value))) && (!(JSGuards.isJSString(arguments0Value)))) {
                    this.state_ = state = state | 0b100 /* add-active toStringGeneric(Object) */;
                    lock.unlock();
                    hasLock = false;
                    return toStringGeneric(arguments0Value);
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
            s[0] = "toStringString";
            if ((state & 0b1) != 0 /* is-active toStringString(DynamicObject, JSStringToStringNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.toStringString_nestedToString_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "toStringCharseq";
            if ((state & 0b10) != 0 /* is-active toStringCharseq(CharSequence) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "toStringGeneric";
            if ((state & 0b100) != 0 /* is-active toStringGeneric(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static JSStringToStringNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSStringToStringNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSStringToLowerCaseNode.class)
    public static final class JSStringToLowerCaseNodeGen extends JSStringToLowerCaseNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private int state_;
        @CompilationFinal private int exclude_;

        private JSStringToLowerCaseNodeGen(JSContext context, JSBuiltin builtin, boolean locale, JavaScriptNode[] arguments) {
            super(context, builtin, locale);
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
            if ((state & 0b1) != 0 /* is-active toLowerCaseString(String) */ && JSTypesGen.isImplicitString((state & 0b111100) >>> 2 /* extract-implicit-active 0:String */, arguments0Value_)) {
                String arguments0Value__ = JSTypesGen.asImplicitString((state & 0b111100) >>> 2 /* extract-implicit-active 0:String */, arguments0Value_);
                return toLowerCaseString(arguments0Value__);
            }
            if ((state & 0b10) != 0 /* is-active toLowerCase(Object) */) {
                return toLowerCase(arguments0Value_);
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
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int exclude = exclude_;
            try {
                if ((exclude) == 0 /* is-not-excluded toLowerCaseString(String) */) {
                    int stringCast0;
                    if ((stringCast0 = JSTypesGen.specializeImplicitString(arguments0Value)) != 0) {
                        String arguments0Value_ = JSTypesGen.asImplicitString(stringCast0, arguments0Value);
                        state = (state | (stringCast0 << 2) /* set-implicit-active 0:String */);
                        this.state_ = state = state | 0b1 /* add-active toLowerCaseString(String) */;
                        lock.unlock();
                        hasLock = false;
                        return toLowerCaseString(arguments0Value_);
                    }
                }
                this.exclude_ = exclude = exclude | 0b1 /* add-excluded toLowerCaseString(String) */;
                state = state & 0xfffffffe /* remove-active toLowerCaseString(String) */;
                this.state_ = state = state | 0b10 /* add-active toLowerCase(Object) */;
                lock.unlock();
                hasLock = false;
                return toLowerCase(arguments0Value);
            } finally {
                if (hasLock) {
                    lock.unlock();
                }
            }
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
            int exclude = exclude_;
            s = new Object[3];
            s[0] = "toLowerCaseString";
            if ((state & 0b1) != 0 /* is-active toLowerCaseString(String) */) {
                s[1] = (byte)0b01 /* active */;
            } else if (exclude != 0 /* is-excluded toLowerCaseString(String) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "toLowerCase";
            if ((state & 0b10) != 0 /* is-active toLowerCase(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static JSStringToLowerCaseNode create(JSContext context, JSBuiltin builtin, boolean locale, JavaScriptNode[] arguments) {
            return new JSStringToLowerCaseNodeGen(context, builtin, locale, arguments);
        }

    }
    @GeneratedBy(JSStringToLocaleXCaseIntl.class)
    public static final class JSStringToLocaleXCaseIntlNodeGen extends JSStringToLocaleXCaseIntl implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;

        private JSStringToLocaleXCaseIntlNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            return toDesiredCase(arguments0Value_, arguments1Value_);
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
            s[0] = "toDesiredCase";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSStringToLocaleXCaseIntl create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSStringToLocaleXCaseIntlNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSStringToLocaleLowerCaseIntlNode.class)
    public static final class JSStringToLocaleLowerCaseIntlNodeGen extends JSStringToLocaleLowerCaseIntlNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;

        private JSStringToLocaleLowerCaseIntlNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            return toDesiredCase(arguments0Value_, arguments1Value_);
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
            s[0] = "toDesiredCase";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSStringToLocaleLowerCaseIntlNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSStringToLocaleLowerCaseIntlNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSStringToLocaleUpperCaseIntlNode.class)
    public static final class JSStringToLocaleUpperCaseIntlNodeGen extends JSStringToLocaleUpperCaseIntlNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;

        private JSStringToLocaleUpperCaseIntlNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            return toDesiredCase(arguments0Value_, arguments1Value_);
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
            s[0] = "toDesiredCase";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSStringToLocaleUpperCaseIntlNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSStringToLocaleUpperCaseIntlNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSStringToUpperCaseNode.class)
    public static final class JSStringToUpperCaseNodeGen extends JSStringToUpperCaseNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private int state_;
        @CompilationFinal private int exclude_;

        private JSStringToUpperCaseNodeGen(JSContext context, JSBuiltin builtin, boolean locale, JavaScriptNode[] arguments) {
            super(context, builtin, locale);
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
            if ((state & 0b1) != 0 /* is-active toUpperCaseString(String) */ && JSTypesGen.isImplicitString((state & 0b111100) >>> 2 /* extract-implicit-active 0:String */, arguments0Value_)) {
                String arguments0Value__ = JSTypesGen.asImplicitString((state & 0b111100) >>> 2 /* extract-implicit-active 0:String */, arguments0Value_);
                return toUpperCaseString(arguments0Value__);
            }
            if ((state & 0b10) != 0 /* is-active toUpperCaseGeneric(Object) */) {
                return toUpperCaseGeneric(arguments0Value_);
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
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int exclude = exclude_;
            try {
                if ((exclude) == 0 /* is-not-excluded toUpperCaseString(String) */) {
                    int stringCast0;
                    if ((stringCast0 = JSTypesGen.specializeImplicitString(arguments0Value)) != 0) {
                        String arguments0Value_ = JSTypesGen.asImplicitString(stringCast0, arguments0Value);
                        state = (state | (stringCast0 << 2) /* set-implicit-active 0:String */);
                        this.state_ = state = state | 0b1 /* add-active toUpperCaseString(String) */;
                        lock.unlock();
                        hasLock = false;
                        return toUpperCaseString(arguments0Value_);
                    }
                }
                this.exclude_ = exclude = exclude | 0b1 /* add-excluded toUpperCaseString(String) */;
                state = state & 0xfffffffe /* remove-active toUpperCaseString(String) */;
                this.state_ = state = state | 0b10 /* add-active toUpperCaseGeneric(Object) */;
                lock.unlock();
                hasLock = false;
                return toUpperCaseGeneric(arguments0Value);
            } finally {
                if (hasLock) {
                    lock.unlock();
                }
            }
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
            int exclude = exclude_;
            s = new Object[3];
            s[0] = "toUpperCaseString";
            if ((state & 0b1) != 0 /* is-active toUpperCaseString(String) */) {
                s[1] = (byte)0b01 /* active */;
            } else if (exclude != 0 /* is-excluded toUpperCaseString(String) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "toUpperCaseGeneric";
            if ((state & 0b10) != 0 /* is-active toUpperCaseGeneric(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static JSStringToUpperCaseNode create(JSContext context, JSBuiltin builtin, boolean locale, JavaScriptNode[] arguments) {
            return new JSStringToUpperCaseNodeGen(context, builtin, locale, arguments);
        }

    }
    @GeneratedBy(JSStringSearchNode.class)
    public static final class JSStringSearchNodeGen extends JSStringSearchNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;

        private JSStringSearchNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            return search(arguments0Value_, arguments1Value_);
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
            s[0] = "search";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSStringSearchNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSStringSearchNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSStringSearchES5Node.class)
    public static final class JSStringSearchES5NodeGen extends JSStringSearchES5Node implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_;
        @Child private JSToRegExpNode toRegExpNode_;

        private JSStringSearchES5NodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state != 0 /* is-active search(Object, Object[], JSToRegExpNode) */ && arguments1Value_ instanceof Object[]) {
                Object[] arguments1Value__ = (Object[]) arguments1Value_;
                return search(arguments0Value_, arguments1Value__, this.toRegExpNode_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public int executeInt(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if (state != 0 /* is-active search(Object, Object[], JSToRegExpNode) */ && arguments1Value_ instanceof Object[]) {
                Object[] arguments1Value__ = (Object[]) arguments1Value_;
                return search(arguments0Value_, arguments1Value__, this.toRegExpNode_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            executeInt(frameValue);
            return;
        }

        private int executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            try {
                if (arguments1Value instanceof Object[]) {
                    Object[] arguments1Value_ = (Object[]) arguments1Value;
                    this.toRegExpNode_ = super.insert((JSToRegExpNode.create(getContext())));
                    this.state_ = state = state | 0b1 /* add-active search(Object, Object[], JSToRegExpNode) */;
                    lock.unlock();
                    hasLock = false;
                    return search(arguments0Value, arguments1Value_, this.toRegExpNode_);
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
            s[0] = "search";
            if (state != 0 /* is-active search(Object, Object[], JSToRegExpNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.toRegExpNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static JSStringSearchES5Node create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSStringSearchES5NodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSStringSubstrNode.class)
    public static final class JSStringSubstrNodeGen extends JSStringSubstrNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private int state_;
        @CompilationFinal private int exclude_;

        private JSStringSubstrNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state & 0b110) == 0 /* only-active substrInt(String, int, int) */ && (state & 0b111) != 0  /* is-not substrInt(String, int, int) && substrLenUndef(String, int, Object) && substrGeneric(Object, Object, Object) */) {
                return execute_int_int0(frameValue, state);
            } else if ((state & 0b101) == 0 /* only-active substrLenUndef(String, int, Object) */ && (state & 0b111) != 0  /* is-not substrInt(String, int, int) && substrLenUndef(String, int, Object) && substrGeneric(Object, Object, Object) */) {
                return execute_int1(frameValue, state);
            } else {
                return execute_generic2(frameValue, state);
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
            assert (state & 0b1) != 0 /* is-active substrInt(String, int, int) */;
            if (JSTypesGen.isImplicitString((state & 0b1111000) >>> 3 /* extract-implicit-active 0:String */, arguments0Value_)) {
                String arguments0Value__ = JSTypesGen.asImplicitString((state & 0b1111000) >>> 3 /* extract-implicit-active 0:String */, arguments0Value_);
                return substrInt(arguments0Value__, arguments1Value_, arguments2Value_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        private Object execute_int1(VirtualFrame frameValue, int state) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            int arguments1Value_;
            try {
                arguments1Value_ = this.arguments1_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                Object arguments2Value = this.arguments2_.execute(frameValue);
                return executeAndSpecialize(arguments0Value_, ex.getResult(), arguments2Value);
            }
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            assert (state & 0b10) != 0 /* is-active substrLenUndef(String, int, Object) */;
            if (JSTypesGen.isImplicitString((state & 0b1111000) >>> 3 /* extract-implicit-active 0:String */, arguments0Value_)) {
                String arguments0Value__ = JSTypesGen.asImplicitString((state & 0b1111000) >>> 3 /* extract-implicit-active 0:String */, arguments0Value_);
                if ((JSGuards.isUndefined(arguments2Value_))) {
                    return substrLenUndef(arguments0Value__, arguments1Value_, arguments2Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        private Object execute_generic2(VirtualFrame frameValue, int state) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if ((state & 0b11) != 0 /* is-active substrInt(String, int, int) || substrLenUndef(String, int, Object) */ && JSTypesGen.isImplicitString((state & 0b1111000) >>> 3 /* extract-implicit-active 0:String */, arguments0Value_)) {
                String arguments0Value__ = JSTypesGen.asImplicitString((state & 0b1111000) >>> 3 /* extract-implicit-active 0:String */, arguments0Value_);
                if (arguments1Value_ instanceof Integer) {
                    int arguments1Value__ = (int) arguments1Value_;
                    if ((state & 0b1) != 0 /* is-active substrInt(String, int, int) */ && arguments2Value_ instanceof Integer) {
                        int arguments2Value__ = (int) arguments2Value_;
                        return substrInt(arguments0Value__, arguments1Value__, arguments2Value__);
                    }
                    if ((state & 0b10) != 0 /* is-active substrLenUndef(String, int, Object) */) {
                        if ((JSGuards.isUndefined(arguments2Value_))) {
                            return substrLenUndef(arguments0Value__, arguments1Value__, arguments2Value_);
                        }
                    }
                }
            }
            if ((state & 0b100) != 0 /* is-active substrGeneric(Object, Object, Object) */) {
                return substrGeneric(arguments0Value_, arguments1Value_, arguments2Value_);
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
                        if (arguments1Value instanceof Integer) {
                            int arguments1Value_ = (int) arguments1Value;
                            if (((exclude & 0b1)) == 0 /* is-not-excluded substrInt(String, int, int) */ && arguments2Value instanceof Integer) {
                                int arguments2Value_ = (int) arguments2Value;
                                state = (state | (stringCast0 << 3) /* set-implicit-active 0:String */);
                                this.state_ = state = state | 0b1 /* add-active substrInt(String, int, int) */;
                                lock.unlock();
                                hasLock = false;
                                return substrInt(arguments0Value_, arguments1Value_, arguments2Value_);
                            }
                            if (((exclude & 0b10)) == 0 /* is-not-excluded substrLenUndef(String, int, Object) */) {
                                if ((JSGuards.isUndefined(arguments2Value))) {
                                    state = (state | (stringCast0 << 3) /* set-implicit-active 0:String */);
                                    this.state_ = state = state | 0b10 /* add-active substrLenUndef(String, int, Object) */;
                                    lock.unlock();
                                    hasLock = false;
                                    return substrLenUndef(arguments0Value_, arguments1Value_, arguments2Value);
                                }
                            }
                        }
                    }
                }
                this.exclude_ = exclude = exclude | 0b11 /* add-excluded substrInt(String, int, int), substrLenUndef(String, int, Object) */;
                state = state & 0xfffffffc /* remove-active substrInt(String, int, int), substrLenUndef(String, int, Object) */;
                this.state_ = state = state | 0b100 /* add-active substrGeneric(Object, Object, Object) */;
                lock.unlock();
                hasLock = false;
                return substrGeneric(arguments0Value, arguments1Value, arguments2Value);
            } finally {
                if (hasLock) {
                    lock.unlock();
                }
            }
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
            int exclude = exclude_;
            s = new Object[3];
            s[0] = "substrInt";
            if ((state & 0b1) != 0 /* is-active substrInt(String, int, int) */) {
                s[1] = (byte)0b01 /* active */;
            } else if ((exclude & 0b1) != 0 /* is-excluded substrInt(String, int, int) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "substrLenUndef";
            if ((state & 0b10) != 0 /* is-active substrLenUndef(String, int, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else if ((exclude & 0b10) != 0 /* is-excluded substrLenUndef(String, int, Object) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "substrGeneric";
            if ((state & 0b100) != 0 /* is-active substrGeneric(Object, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static JSStringSubstrNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSStringSubstrNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSStringMatchNode.class)
    public static final class JSStringMatchNodeGen extends JSStringMatchNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;

        private JSStringMatchNodeGen(JSContext context, JSBuiltin builtin, boolean matchAll, JavaScriptNode[] arguments) {
            super(context, builtin, matchAll);
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
            return match(arguments0Value_, arguments1Value_);
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
            s[0] = "match";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSStringMatchNode create(JSContext context, JSBuiltin builtin, boolean matchAll, JavaScriptNode[] arguments) {
            return new JSStringMatchNodeGen(context, builtin, matchAll, arguments);
        }

    }
    @GeneratedBy(JSStringMatchES5Node.class)
    public static final class JSStringMatchES5NodeGen extends JSStringMatchES5Node implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;

        private JSStringMatchES5NodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            return matchRegExpNotGlobal(arguments0Value_, arguments1Value_);
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
            s[0] = "matchRegExpNotGlobal";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSStringMatchES5Node create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSStringMatchES5NodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSStringTrimNode.class)
    public static final class JSStringTrimNodeGen extends JSStringTrimNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_;
        @Child private JSTrimWhitespaceNode trimWhitespace;

        private JSStringTrimNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state & 0b1) != 0 /* is-active trimString(String, JSTrimWhitespaceNode) */ && JSTypesGen.isImplicitString((state & 0b111100) >>> 2 /* extract-implicit-active 0:String */, arguments0Value_)) {
                String arguments0Value__ = JSTypesGen.asImplicitString((state & 0b111100) >>> 2 /* extract-implicit-active 0:String */, arguments0Value_);
                return trimString(arguments0Value__, this.trimWhitespace);
            }
            if ((state & 0b10) != 0 /* is-active trimObject(Object, JSTrimWhitespaceNode) */) {
                return trimObject(arguments0Value_, this.trimWhitespace);
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
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            try {
                {
                    int stringCast0;
                    if ((stringCast0 = JSTypesGen.specializeImplicitString(arguments0Value)) != 0) {
                        String arguments0Value_ = JSTypesGen.asImplicitString(stringCast0, arguments0Value);
                        if (this.trimWhitespace == null) {
                            this.trimWhitespace = super.insert((JSTrimWhitespaceNode.create()));
                        }
                        state = (state | (stringCast0 << 2) /* set-implicit-active 0:String */);
                        this.state_ = state = state | 0b1 /* add-active trimString(String, JSTrimWhitespaceNode) */;
                        lock.unlock();
                        hasLock = false;
                        return trimString(arguments0Value_, this.trimWhitespace);
                    }
                }
                if (this.trimWhitespace == null) {
                    this.trimWhitespace = super.insert((JSTrimWhitespaceNode.create()));
                }
                this.state_ = state = state | 0b10 /* add-active trimObject(Object, JSTrimWhitespaceNode) */;
                lock.unlock();
                hasLock = false;
                return trimObject(arguments0Value, this.trimWhitespace);
            } finally {
                if (hasLock) {
                    lock.unlock();
                }
            }
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
            s[0] = "trimString";
            if ((state & 0b1) != 0 /* is-active trimString(String, JSTrimWhitespaceNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.trimWhitespace));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "trimObject";
            if ((state & 0b10) != 0 /* is-active trimObject(Object, JSTrimWhitespaceNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.trimWhitespace));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static JSStringTrimNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSStringTrimNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSStringTrimLeftNode.class)
    public static final class JSStringTrimLeftNodeGen extends JSStringTrimLeftNode implements Provider {

        @Child private JavaScriptNode arguments0_;

        private JSStringTrimLeftNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            return trimLeft(arguments0Value_);
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
            s[0] = "trimLeft";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSStringTrimLeftNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSStringTrimLeftNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSStringTrimRightNode.class)
    public static final class JSStringTrimRightNodeGen extends JSStringTrimRightNode implements Provider {

        @Child private JavaScriptNode arguments0_;

        private JSStringTrimRightNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            return trimRight(arguments0Value_);
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
            s[0] = "trimRight";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSStringTrimRightNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSStringTrimRightNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSStringLocaleCompareNode.class)
    public static final class JSStringLocaleCompareNodeGen extends JSStringLocaleCompareNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_;
        @Child private JSToStringNode toString2Node_;

        private JSStringLocaleCompareNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state != 0 /* is-active localeCompare(Object, Object, JSToStringNode) */) {
                return localeCompare(arguments0Value_, arguments1Value_, this.toString2Node_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public int executeInt(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if (state != 0 /* is-active localeCompare(Object, Object, JSToStringNode) */) {
                return localeCompare(arguments0Value_, arguments1Value_, this.toString2Node_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            executeInt(frameValue);
            return;
        }

        private int executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            try {
                this.toString2Node_ = super.insert((JSToStringNode.create()));
                this.state_ = state = state | 0b1 /* add-active localeCompare(Object, Object, JSToStringNode) */;
                lock.unlock();
                hasLock = false;
                return localeCompare(arguments0Value, arguments1Value, this.toString2Node_);
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
            s[0] = "localeCompare";
            if (state != 0 /* is-active localeCompare(Object, Object, JSToStringNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.toString2Node_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static JSStringLocaleCompareNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSStringLocaleCompareNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSStringLocaleCompareIntlNode.class)
    public static final class JSStringLocaleCompareIntlNodeGen extends JSStringLocaleCompareIntlNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @Child private JavaScriptNode arguments3_;
        @CompilationFinal private volatile int state_;
        @Child private JSToStringNode toString2Node_;

        private JSStringLocaleCompareIntlNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            Object arguments3Value_ = this.arguments3_.execute(frameValue);
            if (state != 0 /* is-active localeCompare(Object, Object, Object, Object, JSToStringNode) */) {
                return localeCompare(arguments0Value_, arguments1Value_, arguments2Value_, arguments3Value_, this.toString2Node_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_, arguments3Value_);
        }

        @Override
        public int executeInt(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            Object arguments3Value_ = this.arguments3_.execute(frameValue);
            if (state != 0 /* is-active localeCompare(Object, Object, Object, Object, JSToStringNode) */) {
                return localeCompare(arguments0Value_, arguments1Value_, arguments2Value_, arguments3Value_, this.toString2Node_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_, arguments3Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            executeInt(frameValue);
            return;
        }

        private int executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value, Object arguments3Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            try {
                this.toString2Node_ = super.insert((JSToStringNode.create()));
                this.state_ = state = state | 0b1 /* add-active localeCompare(Object, Object, Object, Object, JSToStringNode) */;
                lock.unlock();
                hasLock = false;
                return localeCompare(arguments0Value, arguments1Value, arguments2Value, arguments3Value, this.toString2Node_);
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
            s[0] = "localeCompare";
            if (state != 0 /* is-active localeCompare(Object, Object, Object, Object, JSToStringNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.toString2Node_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static JSStringLocaleCompareIntlNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSStringLocaleCompareIntlNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSStringSliceNode.class)
    public static final class JSStringSliceNodeGen extends JSStringSliceNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private volatile int state_;
        @CompilationFinal private volatile int exclude_;
        @CompilationFinal private ConditionProfile sliceGeneric_isUndefined_;

        private JSStringSliceNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state & 0b1100) == 0 /* only-active sliceStringIntInt(String, int, int) && sliceObjectIntInt(Object, int, int) */ && (state & 0b1111) != 0  /* is-not sliceStringIntInt(String, int, int) && sliceObjectIntInt(Object, int, int) && sliceStringIntUndefined(String, int, Object) && sliceGeneric(Object, Object, Object, ConditionProfile) */) {
                return execute_int_int0(frameValue, state);
            } else if ((state & 0b1011) == 0 /* only-active sliceStringIntUndefined(String, int, Object) */ && (state & 0b1111) != 0  /* is-not sliceStringIntInt(String, int, int) && sliceObjectIntInt(Object, int, int) && sliceStringIntUndefined(String, int, Object) && sliceGeneric(Object, Object, Object, ConditionProfile) */) {
                return execute_int1(frameValue, state);
            } else {
                return execute_generic2(frameValue, state);
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
            if ((state & 0b1) != 0 /* is-active sliceStringIntInt(String, int, int) */ && JSTypesGen.isImplicitString((state & 0b11110000) >>> 4 /* extract-implicit-active 0:String */, arguments0Value_)) {
                String arguments0Value__ = JSTypesGen.asImplicitString((state & 0b11110000) >>> 4 /* extract-implicit-active 0:String */, arguments0Value_);
                return sliceStringIntInt(arguments0Value__, arguments1Value_, arguments2Value_);
            }
            if ((state & 0b10) != 0 /* is-active sliceObjectIntInt(Object, int, int) */) {
                return sliceObjectIntInt(arguments0Value_, arguments1Value_, arguments2Value_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        private Object execute_int1(VirtualFrame frameValue, int state) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            int arguments1Value_;
            try {
                arguments1Value_ = this.arguments1_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                Object arguments2Value = this.arguments2_.execute(frameValue);
                return executeAndSpecialize(arguments0Value_, ex.getResult(), arguments2Value);
            }
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            assert (state & 0b100) != 0 /* is-active sliceStringIntUndefined(String, int, Object) */;
            if (JSTypesGen.isImplicitString((state & 0b11110000) >>> 4 /* extract-implicit-active 0:String */, arguments0Value_)) {
                String arguments0Value__ = JSTypesGen.asImplicitString((state & 0b11110000) >>> 4 /* extract-implicit-active 0:String */, arguments0Value_);
                if ((JSGuards.isUndefined(arguments2Value_))) {
                    return sliceStringIntUndefined(arguments0Value__, arguments1Value_, arguments2Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        private Object execute_generic2(VirtualFrame frameValue, int state) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if ((state & 0b111) != 0 /* is-active sliceStringIntInt(String, int, int) || sliceObjectIntInt(Object, int, int) || sliceStringIntUndefined(String, int, Object) */ && arguments1Value_ instanceof Integer) {
                int arguments1Value__ = (int) arguments1Value_;
                if ((state & 0b11) != 0 /* is-active sliceStringIntInt(String, int, int) || sliceObjectIntInt(Object, int, int) */ && arguments2Value_ instanceof Integer) {
                    int arguments2Value__ = (int) arguments2Value_;
                    if ((state & 0b1) != 0 /* is-active sliceStringIntInt(String, int, int) */ && JSTypesGen.isImplicitString((state & 0b11110000) >>> 4 /* extract-implicit-active 0:String */, arguments0Value_)) {
                        String arguments0Value__ = JSTypesGen.asImplicitString((state & 0b11110000) >>> 4 /* extract-implicit-active 0:String */, arguments0Value_);
                        return sliceStringIntInt(arguments0Value__, arguments1Value__, arguments2Value__);
                    }
                    if ((state & 0b10) != 0 /* is-active sliceObjectIntInt(Object, int, int) */) {
                        return sliceObjectIntInt(arguments0Value_, arguments1Value__, arguments2Value__);
                    }
                }
                if ((state & 0b100) != 0 /* is-active sliceStringIntUndefined(String, int, Object) */ && JSTypesGen.isImplicitString((state & 0b11110000) >>> 4 /* extract-implicit-active 0:String */, arguments0Value_)) {
                    String arguments0Value__ = JSTypesGen.asImplicitString((state & 0b11110000) >>> 4 /* extract-implicit-active 0:String */, arguments0Value_);
                    if ((JSGuards.isUndefined(arguments2Value_))) {
                        return sliceStringIntUndefined(arguments0Value__, arguments1Value__, arguments2Value_);
                    }
                }
            }
            if ((state & 0b1000) != 0 /* is-active sliceGeneric(Object, Object, Object, ConditionProfile) */) {
                return sliceGeneric(arguments0Value_, arguments1Value_, arguments2Value_, this.sliceGeneric_isUndefined_);
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
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int exclude = exclude_;
            try {
                if (arguments1Value instanceof Integer) {
                    int arguments1Value_ = (int) arguments1Value;
                    if (arguments2Value instanceof Integer) {
                        int arguments2Value_ = (int) arguments2Value;
                        if (((exclude & 0b1)) == 0 /* is-not-excluded sliceStringIntInt(String, int, int) */) {
                            int stringCast0;
                            if ((stringCast0 = JSTypesGen.specializeImplicitString(arguments0Value)) != 0) {
                                String arguments0Value_ = JSTypesGen.asImplicitString(stringCast0, arguments0Value);
                                state = (state | (stringCast0 << 4) /* set-implicit-active 0:String */);
                                this.state_ = state = state | 0b1 /* add-active sliceStringIntInt(String, int, int) */;
                                lock.unlock();
                                hasLock = false;
                                return sliceStringIntInt(arguments0Value_, arguments1Value_, arguments2Value_);
                            }
                        }
                        if (((exclude & 0b10)) == 0 /* is-not-excluded sliceObjectIntInt(Object, int, int) */) {
                            this.exclude_ = exclude = exclude | 0b1 /* add-excluded sliceStringIntInt(String, int, int) */;
                            state = state & 0xfffffffe /* remove-active sliceStringIntInt(String, int, int) */;
                            this.state_ = state = state | 0b10 /* add-active sliceObjectIntInt(Object, int, int) */;
                            lock.unlock();
                            hasLock = false;
                            return sliceObjectIntInt(arguments0Value, arguments1Value_, arguments2Value_);
                        }
                    }
                    if (((exclude & 0b100)) == 0 /* is-not-excluded sliceStringIntUndefined(String, int, Object) */) {
                        int stringCast0;
                        if ((stringCast0 = JSTypesGen.specializeImplicitString(arguments0Value)) != 0) {
                            String arguments0Value_ = JSTypesGen.asImplicitString(stringCast0, arguments0Value);
                            if ((JSGuards.isUndefined(arguments2Value))) {
                                state = (state | (stringCast0 << 4) /* set-implicit-active 0:String */);
                                this.state_ = state = state | 0b100 /* add-active sliceStringIntUndefined(String, int, Object) */;
                                lock.unlock();
                                hasLock = false;
                                return sliceStringIntUndefined(arguments0Value_, arguments1Value_, arguments2Value);
                            }
                        }
                    }
                }
                this.sliceGeneric_isUndefined_ = (ConditionProfile.createBinaryProfile());
                this.exclude_ = exclude = exclude | 0b111 /* add-excluded sliceStringIntInt(String, int, int), sliceObjectIntInt(Object, int, int), sliceStringIntUndefined(String, int, Object) */;
                state = state & 0xfffffff8 /* remove-active sliceStringIntInt(String, int, int), sliceObjectIntInt(Object, int, int), sliceStringIntUndefined(String, int, Object) */;
                this.state_ = state = state | 0b1000 /* add-active sliceGeneric(Object, Object, Object, ConditionProfile) */;
                lock.unlock();
                hasLock = false;
                return sliceGeneric(arguments0Value, arguments1Value, arguments2Value, this.sliceGeneric_isUndefined_);
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
            int exclude = exclude_;
            s = new Object[3];
            s[0] = "sliceStringIntInt";
            if ((state & 0b1) != 0 /* is-active sliceStringIntInt(String, int, int) */) {
                s[1] = (byte)0b01 /* active */;
            } else if ((exclude & 0b1) != 0 /* is-excluded sliceStringIntInt(String, int, int) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "sliceObjectIntInt";
            if ((state & 0b10) != 0 /* is-active sliceObjectIntInt(Object, int, int) */) {
                s[1] = (byte)0b01 /* active */;
            } else if ((exclude & 0b10) != 0 /* is-excluded sliceObjectIntInt(Object, int, int) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "sliceStringIntUndefined";
            if ((state & 0b100) != 0 /* is-active sliceStringIntUndefined(String, int, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else if ((exclude & 0b100) != 0 /* is-excluded sliceStringIntUndefined(String, int, Object) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "sliceGeneric";
            if ((state & 0b1000) != 0 /* is-active sliceGeneric(Object, Object, Object, ConditionProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.sliceGeneric_isUndefined_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            return Provider.create(data);
        }

        public static JSStringSliceNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSStringSliceNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSStringStartsWithNode.class)
    public static final class JSStringStartsWithNodeGen extends JSStringStartsWithNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private volatile int state_;
        @Child private JSToStringNode startsWithGeneric_toString2Node_;
        @Child private IsRegExpNode startsWithGeneric_isRegExpNode_;

        private JSStringStartsWithNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state & 0b1) != 0 /* is-active startsWithString(String, String, DynamicObject) */ && JSTypesGen.isImplicitString((state & 0b111100) >>> 2 /* extract-implicit-active 0:String */, arguments0Value_)) {
                String arguments0Value__ = JSTypesGen.asImplicitString((state & 0b111100) >>> 2 /* extract-implicit-active 0:String */, arguments0Value_);
                if (JSTypesGen.isImplicitString((state & 0b1111000000) >>> 6 /* extract-implicit-active 1:String */, arguments1Value_)) {
                    String arguments1Value__ = JSTypesGen.asImplicitString((state & 0b1111000000) >>> 6 /* extract-implicit-active 1:String */, arguments1Value_);
                    if (JSTypes.isDynamicObject(arguments2Value_)) {
                        DynamicObject arguments2Value__ = (DynamicObject) arguments2Value_;
                        if ((JSGuards.isUndefined(arguments2Value__))) {
                            return startsWithString(arguments0Value__, arguments1Value__, arguments2Value__);
                        }
                    }
                }
            }
            if ((state & 0b10) != 0 /* is-active startsWithGeneric(Object, Object, Object, JSToStringNode, IsRegExpNode) */) {
                return startsWithGeneric(arguments0Value_, arguments1Value_, arguments2Value_, this.startsWithGeneric_toString2Node_, this.startsWithGeneric_isRegExpNode_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if ((state & 0b1) != 0 /* is-active startsWithString(String, String, DynamicObject) */ && JSTypesGen.isImplicitString((state & 0b111100) >>> 2 /* extract-implicit-active 0:String */, arguments0Value_)) {
                String arguments0Value__ = JSTypesGen.asImplicitString((state & 0b111100) >>> 2 /* extract-implicit-active 0:String */, arguments0Value_);
                if (JSTypesGen.isImplicitString((state & 0b1111000000) >>> 6 /* extract-implicit-active 1:String */, arguments1Value_)) {
                    String arguments1Value__ = JSTypesGen.asImplicitString((state & 0b1111000000) >>> 6 /* extract-implicit-active 1:String */, arguments1Value_);
                    if (JSTypes.isDynamicObject(arguments2Value_)) {
                        DynamicObject arguments2Value__ = (DynamicObject) arguments2Value_;
                        if ((JSGuards.isUndefined(arguments2Value__))) {
                            return startsWithString(arguments0Value__, arguments1Value__, arguments2Value__);
                        }
                    }
                }
            }
            if ((state & 0b10) != 0 /* is-active startsWithGeneric(Object, Object, Object, JSToStringNode, IsRegExpNode) */) {
                return startsWithGeneric(arguments0Value_, arguments1Value_, arguments2Value_, this.startsWithGeneric_toString2Node_, this.startsWithGeneric_isRegExpNode_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            executeBoolean(frameValue);
            return;
        }

        private boolean executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            try {
                {
                    int stringCast0;
                    if ((stringCast0 = JSTypesGen.specializeImplicitString(arguments0Value)) != 0) {
                        String arguments0Value_ = JSTypesGen.asImplicitString(stringCast0, arguments0Value);
                        int stringCast1;
                        if ((stringCast1 = JSTypesGen.specializeImplicitString(arguments1Value)) != 0) {
                            String arguments1Value_ = JSTypesGen.asImplicitString(stringCast1, arguments1Value);
                            if (JSTypes.isDynamicObject(arguments2Value)) {
                                DynamicObject arguments2Value_ = (DynamicObject) arguments2Value;
                                if ((JSGuards.isUndefined(arguments2Value_))) {
                                    state = (state | (stringCast0 << 2) /* set-implicit-active 0:String */);
                                    state = (state | (stringCast1 << 6) /* set-implicit-active 1:String */);
                                    this.state_ = state = state | 0b1 /* add-active startsWithString(String, String, DynamicObject) */;
                                    lock.unlock();
                                    hasLock = false;
                                    return startsWithString(arguments0Value_, arguments1Value_, arguments2Value_);
                                }
                            }
                        }
                    }
                }
                this.startsWithGeneric_toString2Node_ = super.insert((JSToStringNode.create()));
                this.startsWithGeneric_isRegExpNode_ = super.insert((IsRegExpNode.create(getContext())));
                this.state_ = state = state | 0b10 /* add-active startsWithGeneric(Object, Object, Object, JSToStringNode, IsRegExpNode) */;
                lock.unlock();
                hasLock = false;
                return startsWithGeneric(arguments0Value, arguments1Value, arguments2Value, this.startsWithGeneric_toString2Node_, this.startsWithGeneric_isRegExpNode_);
            } finally {
                if (hasLock) {
                    lock.unlock();
                }
            }
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
            s[0] = "startsWithString";
            if ((state & 0b1) != 0 /* is-active startsWithString(String, String, DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "startsWithGeneric";
            if ((state & 0b10) != 0 /* is-active startsWithGeneric(Object, Object, Object, JSToStringNode, IsRegExpNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.startsWithGeneric_toString2Node_, this.startsWithGeneric_isRegExpNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static JSStringStartsWithNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSStringStartsWithNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSStringEndsWithNode.class)
    public static final class JSStringEndsWithNodeGen extends JSStringEndsWithNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private volatile int state_;
        @Child private JSToStringNode endsWithGeneric_toString2Node_;
        @Child private IsRegExpNode endsWithGeneric_isRegExpNode_;

        private JSStringEndsWithNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state & 0b11) != 0 /* is-active endsWithStringUndefined(String, String, Object) || endsWithGeneric(Object, Object, Object, JSToStringNode, IsRegExpNode) */) {
                if ((state & 0b1) != 0 /* is-active endsWithStringUndefined(String, String, Object) */ && JSTypesGen.isImplicitString((state & 0b111100) >>> 2 /* extract-implicit-active 0:String */, arguments0Value_)) {
                    String arguments0Value__ = JSTypesGen.asImplicitString((state & 0b111100) >>> 2 /* extract-implicit-active 0:String */, arguments0Value_);
                    if (JSTypesGen.isImplicitString((state & 0b1111000000) >>> 6 /* extract-implicit-active 1:String */, arguments1Value_)) {
                        String arguments1Value__ = JSTypesGen.asImplicitString((state & 0b1111000000) >>> 6 /* extract-implicit-active 1:String */, arguments1Value_);
                        if ((JSGuards.isUndefined(arguments2Value_))) {
                            return endsWithStringUndefined(arguments0Value__, arguments1Value__, arguments2Value_);
                        }
                    }
                }
                if ((state & 0b10) != 0 /* is-active endsWithGeneric(Object, Object, Object, JSToStringNode, IsRegExpNode) */) {
                    return endsWithGeneric(arguments0Value_, arguments1Value_, arguments2Value_, this.endsWithGeneric_toString2Node_, this.endsWithGeneric_isRegExpNode_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if ((state & 0b11) != 0 /* is-active endsWithStringUndefined(String, String, Object) || endsWithGeneric(Object, Object, Object, JSToStringNode, IsRegExpNode) */) {
                if ((state & 0b1) != 0 /* is-active endsWithStringUndefined(String, String, Object) */ && JSTypesGen.isImplicitString((state & 0b111100) >>> 2 /* extract-implicit-active 0:String */, arguments0Value_)) {
                    String arguments0Value__ = JSTypesGen.asImplicitString((state & 0b111100) >>> 2 /* extract-implicit-active 0:String */, arguments0Value_);
                    if (JSTypesGen.isImplicitString((state & 0b1111000000) >>> 6 /* extract-implicit-active 1:String */, arguments1Value_)) {
                        String arguments1Value__ = JSTypesGen.asImplicitString((state & 0b1111000000) >>> 6 /* extract-implicit-active 1:String */, arguments1Value_);
                        if ((JSGuards.isUndefined(arguments2Value_))) {
                            return endsWithStringUndefined(arguments0Value__, arguments1Value__, arguments2Value_);
                        }
                    }
                }
                if ((state & 0b10) != 0 /* is-active endsWithGeneric(Object, Object, Object, JSToStringNode, IsRegExpNode) */) {
                    return endsWithGeneric(arguments0Value_, arguments1Value_, arguments2Value_, this.endsWithGeneric_toString2Node_, this.endsWithGeneric_isRegExpNode_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            executeBoolean(frameValue);
            return;
        }

        private boolean executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            try {
                {
                    int stringCast0;
                    if ((stringCast0 = JSTypesGen.specializeImplicitString(arguments0Value)) != 0) {
                        String arguments0Value_ = JSTypesGen.asImplicitString(stringCast0, arguments0Value);
                        int stringCast1;
                        if ((stringCast1 = JSTypesGen.specializeImplicitString(arguments1Value)) != 0) {
                            String arguments1Value_ = JSTypesGen.asImplicitString(stringCast1, arguments1Value);
                            if ((JSGuards.isUndefined(arguments2Value))) {
                                state = (state | (stringCast0 << 2) /* set-implicit-active 0:String */);
                                state = (state | (stringCast1 << 6) /* set-implicit-active 1:String */);
                                this.state_ = state = state | 0b1 /* add-active endsWithStringUndefined(String, String, Object) */;
                                lock.unlock();
                                hasLock = false;
                                return endsWithStringUndefined(arguments0Value_, arguments1Value_, arguments2Value);
                            }
                        }
                    }
                }
                this.endsWithGeneric_toString2Node_ = super.insert((JSToStringNode.create()));
                this.endsWithGeneric_isRegExpNode_ = super.insert((IsRegExpNode.create(getContext())));
                this.state_ = state = state | 0b10 /* add-active endsWithGeneric(Object, Object, Object, JSToStringNode, IsRegExpNode) */;
                lock.unlock();
                hasLock = false;
                return endsWithGeneric(arguments0Value, arguments1Value, arguments2Value, this.endsWithGeneric_toString2Node_, this.endsWithGeneric_isRegExpNode_);
            } finally {
                if (hasLock) {
                    lock.unlock();
                }
            }
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
            s[0] = "endsWithStringUndefined";
            if ((state & 0b1) != 0 /* is-active endsWithStringUndefined(String, String, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "endsWithGeneric";
            if ((state & 0b10) != 0 /* is-active endsWithGeneric(Object, Object, Object, JSToStringNode, IsRegExpNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.endsWithGeneric_toString2Node_, this.endsWithGeneric_isRegExpNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static JSStringEndsWithNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSStringEndsWithNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSStringIncludesNode.class)
    public static final class JSStringIncludesNodeGen extends JSStringIncludesNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private volatile int state_;
        @Child private JSToStringNode includesGeneric_toString2Node_;
        @Child private IsRegExpNode includesGeneric_isRegExpNode_;

        private JSStringIncludesNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state & 0b11) != 0 /* is-active includesString(String, String, Object) || includesGeneric(Object, Object, Object, JSToStringNode, IsRegExpNode) */) {
                if ((state & 0b1) != 0 /* is-active includesString(String, String, Object) */ && JSTypesGen.isImplicitString((state & 0b111100) >>> 2 /* extract-implicit-active 0:String */, arguments0Value_)) {
                    String arguments0Value__ = JSTypesGen.asImplicitString((state & 0b111100) >>> 2 /* extract-implicit-active 0:String */, arguments0Value_);
                    if (JSTypesGen.isImplicitString((state & 0b1111000000) >>> 6 /* extract-implicit-active 1:String */, arguments1Value_)) {
                        String arguments1Value__ = JSTypesGen.asImplicitString((state & 0b1111000000) >>> 6 /* extract-implicit-active 1:String */, arguments1Value_);
                        if ((JSGuards.isUndefined(arguments2Value_))) {
                            return includesString(arguments0Value__, arguments1Value__, arguments2Value_);
                        }
                    }
                }
                if ((state & 0b10) != 0 /* is-active includesGeneric(Object, Object, Object, JSToStringNode, IsRegExpNode) */) {
                    return includesGeneric(arguments0Value_, arguments1Value_, arguments2Value_, this.includesGeneric_toString2Node_, this.includesGeneric_isRegExpNode_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if ((state & 0b11) != 0 /* is-active includesString(String, String, Object) || includesGeneric(Object, Object, Object, JSToStringNode, IsRegExpNode) */) {
                if ((state & 0b1) != 0 /* is-active includesString(String, String, Object) */ && JSTypesGen.isImplicitString((state & 0b111100) >>> 2 /* extract-implicit-active 0:String */, arguments0Value_)) {
                    String arguments0Value__ = JSTypesGen.asImplicitString((state & 0b111100) >>> 2 /* extract-implicit-active 0:String */, arguments0Value_);
                    if (JSTypesGen.isImplicitString((state & 0b1111000000) >>> 6 /* extract-implicit-active 1:String */, arguments1Value_)) {
                        String arguments1Value__ = JSTypesGen.asImplicitString((state & 0b1111000000) >>> 6 /* extract-implicit-active 1:String */, arguments1Value_);
                        if ((JSGuards.isUndefined(arguments2Value_))) {
                            return includesString(arguments0Value__, arguments1Value__, arguments2Value_);
                        }
                    }
                }
                if ((state & 0b10) != 0 /* is-active includesGeneric(Object, Object, Object, JSToStringNode, IsRegExpNode) */) {
                    return includesGeneric(arguments0Value_, arguments1Value_, arguments2Value_, this.includesGeneric_toString2Node_, this.includesGeneric_isRegExpNode_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            executeBoolean(frameValue);
            return;
        }

        private boolean executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            try {
                {
                    int stringCast0;
                    if ((stringCast0 = JSTypesGen.specializeImplicitString(arguments0Value)) != 0) {
                        String arguments0Value_ = JSTypesGen.asImplicitString(stringCast0, arguments0Value);
                        int stringCast1;
                        if ((stringCast1 = JSTypesGen.specializeImplicitString(arguments1Value)) != 0) {
                            String arguments1Value_ = JSTypesGen.asImplicitString(stringCast1, arguments1Value);
                            if ((JSGuards.isUndefined(arguments2Value))) {
                                state = (state | (stringCast0 << 2) /* set-implicit-active 0:String */);
                                state = (state | (stringCast1 << 6) /* set-implicit-active 1:String */);
                                this.state_ = state = state | 0b1 /* add-active includesString(String, String, Object) */;
                                lock.unlock();
                                hasLock = false;
                                return includesString(arguments0Value_, arguments1Value_, arguments2Value);
                            }
                        }
                    }
                }
                this.includesGeneric_toString2Node_ = super.insert((JSToStringNode.create()));
                this.includesGeneric_isRegExpNode_ = super.insert((IsRegExpNode.create(getContext())));
                this.state_ = state = state | 0b10 /* add-active includesGeneric(Object, Object, Object, JSToStringNode, IsRegExpNode) */;
                lock.unlock();
                hasLock = false;
                return includesGeneric(arguments0Value, arguments1Value, arguments2Value, this.includesGeneric_toString2Node_, this.includesGeneric_isRegExpNode_);
            } finally {
                if (hasLock) {
                    lock.unlock();
                }
            }
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
            s[0] = "includesString";
            if ((state & 0b1) != 0 /* is-active includesString(String, String, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "includesGeneric";
            if ((state & 0b10) != 0 /* is-active includesGeneric(Object, Object, Object, JSToStringNode, IsRegExpNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.includesGeneric_toString2Node_, this.includesGeneric_isRegExpNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static JSStringIncludesNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSStringIncludesNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSStringRepeatNode.class)
    public static final class JSStringRepeatNodeGen extends JSStringRepeatNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_;
        @Child private JSToNumberNode toNumberNode_;

        private JSStringRepeatNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state != 0 /* is-active repeat(Object, Object, JSToNumberNode) */) {
                return repeat(arguments0Value_, arguments1Value_, this.toNumberNode_);
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
                this.toNumberNode_ = super.insert((JSToNumberNode.create()));
                this.state_ = state = state | 0b1 /* add-active repeat(Object, Object, JSToNumberNode) */;
                lock.unlock();
                hasLock = false;
                return repeat(arguments0Value, arguments1Value, this.toNumberNode_);
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
            s[0] = "repeat";
            if (state != 0 /* is-active repeat(Object, Object, JSToNumberNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.toNumberNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static JSStringRepeatNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSStringRepeatNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSStringCodePointAtNode.class)
    public static final class JSStringCodePointAtNodeGen extends JSStringCodePointAtNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;

        private JSStringCodePointAtNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            return codePointAt(arguments0Value_, arguments1Value_);
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
            s[0] = "codePointAt";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSStringCodePointAtNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSStringCodePointAtNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSStringNormalizeNode.class)
    public static final class JSStringNormalizeNodeGen extends JSStringNormalizeNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;

        private JSStringNormalizeNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            return normalize(arguments0Value_, arguments1Value_);
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
            s[0] = "normalize";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSStringNormalizeNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSStringNormalizeNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSStringPadNode.class)
    public static final class JSStringPadNodeGen extends JSStringPadNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_;
        @Child private JSToStringNode toString2Node_;

        private JSStringPadNodeGen(JSContext context, JSBuiltin builtin, boolean atStart, JavaScriptNode[] arguments) {
            super(context, builtin, atStart);
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
            if (state != 0 /* is-active pad(Object, Object[], JSToStringNode) */ && arguments1Value_ instanceof Object[]) {
                Object[] arguments1Value__ = (Object[]) arguments1Value_;
                return pad(arguments0Value_, arguments1Value__, this.toString2Node_);
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
                if (arguments1Value instanceof Object[]) {
                    Object[] arguments1Value_ = (Object[]) arguments1Value;
                    this.toString2Node_ = super.insert((JSToStringNode.create()));
                    this.state_ = state = state | 0b1 /* add-active pad(Object, Object[], JSToStringNode) */;
                    lock.unlock();
                    hasLock = false;
                    return pad(arguments0Value, arguments1Value_, this.toString2Node_);
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
            s[0] = "pad";
            if (state != 0 /* is-active pad(Object, Object[], JSToStringNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.toString2Node_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static JSStringPadNode create(JSContext context, JSBuiltin builtin, boolean atStart, JavaScriptNode[] arguments) {
            return new JSStringPadNodeGen(context, builtin, atStart, arguments);
        }

    }
    @GeneratedBy(CreateStringIteratorNode.class)
    public static final class CreateStringIteratorNodeGen extends CreateStringIteratorNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_;
        @Child private RequireObjectCoercibleNode coerce_requireObjectCoercibleNode_;
        @Child private JSToStringNode coerce_toStringNode_;

        private CreateStringIteratorNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state & 0b1) != 0 /* is-active doString(VirtualFrame, String) */ && JSTypesGen.isImplicitString((state & 0b111100) >>> 2 /* extract-implicit-active 0:String */, arguments0Value_)) {
                String arguments0Value__ = JSTypesGen.asImplicitString((state & 0b111100) >>> 2 /* extract-implicit-active 0:String */, arguments0Value_);
                return doString(frameValue, arguments0Value__);
            }
            if ((state & 0b10) != 0 /* is-active doCoerce(VirtualFrame, Object, RequireObjectCoercibleNode, JSToStringNode) */) {
                if ((!(JSGuards.isString(arguments0Value_)))) {
                    return doCoerce(frameValue, arguments0Value_, this.coerce_requireObjectCoercibleNode_, this.coerce_toStringNode_);
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
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            try {
                {
                    int stringCast0;
                    if ((stringCast0 = JSTypesGen.specializeImplicitString(arguments0Value)) != 0) {
                        String arguments0Value_ = JSTypesGen.asImplicitString(stringCast0, arguments0Value);
                        state = (state | (stringCast0 << 2) /* set-implicit-active 0:String */);
                        this.state_ = state = state | 0b1 /* add-active doString(VirtualFrame, String) */;
                        lock.unlock();
                        hasLock = false;
                        return doString(frameValue, arguments0Value_);
                    }
                }
                if ((!(JSGuards.isString(arguments0Value)))) {
                    this.coerce_requireObjectCoercibleNode_ = super.insert((RequireObjectCoercibleNode.create()));
                    this.coerce_toStringNode_ = super.insert((JSToStringNode.create()));
                    this.state_ = state = state | 0b10 /* add-active doCoerce(VirtualFrame, Object, RequireObjectCoercibleNode, JSToStringNode) */;
                    lock.unlock();
                    hasLock = false;
                    return doCoerce(frameValue, arguments0Value, this.coerce_requireObjectCoercibleNode_, this.coerce_toStringNode_);
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
            s[0] = "doString";
            if ((state & 0b1) != 0 /* is-active doString(VirtualFrame, String) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doCoerce";
            if ((state & 0b10) != 0 /* is-active doCoerce(VirtualFrame, Object, RequireObjectCoercibleNode, JSToStringNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.coerce_requireObjectCoercibleNode_, this.coerce_toStringNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static CreateStringIteratorNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new CreateStringIteratorNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(CreateHTMLNode.class)
    static final class CreateHTMLNodeGen extends CreateHTMLNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_;
        @Child private RequireObjectCoercibleNode requireObjectCoercibleNode_;
        @Child private JSToStringNode toStringNode_;

        private CreateHTMLNodeGen(JSContext context, JSBuiltin builtin, String tag, String attribute, JavaScriptNode[] arguments) {
            super(context, builtin, tag, attribute);
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
            if (state != 0 /* is-active createHTML(Object, Object, RequireObjectCoercibleNode, JSToStringNode) */) {
                return createHTML(arguments0Value_, arguments1Value_, this.requireObjectCoercibleNode_, this.toStringNode_);
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
                this.requireObjectCoercibleNode_ = super.insert((RequireObjectCoercibleNode.create()));
                this.toStringNode_ = super.insert((JSToStringNode.create()));
                this.state_ = state = state | 0b1 /* add-active createHTML(Object, Object, RequireObjectCoercibleNode, JSToStringNode) */;
                lock.unlock();
                hasLock = false;
                return createHTML(arguments0Value, arguments1Value, this.requireObjectCoercibleNode_, this.toStringNode_);
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
            s[0] = "createHTML";
            if (state != 0 /* is-active createHTML(Object, Object, RequireObjectCoercibleNode, JSToStringNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.requireObjectCoercibleNode_, this.toStringNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static CreateHTMLNode create(JSContext context, JSBuiltin builtin, String tag, String attribute, JavaScriptNode[] arguments) {
            return new CreateHTMLNodeGen(context, builtin, tag, attribute, arguments);
        }

    }
}
