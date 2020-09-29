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
import com.oracle.truffle.js.builtins.ArrayPrototypeBuiltins.ArraySpeciesConstructorNode;
import com.oracle.truffle.js.builtins.RegExpPrototypeBuiltins.CompiledRegexFlagPropertyAccessor;
import com.oracle.truffle.js.builtins.RegExpPrototypeBuiltins.CompiledRegexPatternAccessor;
import com.oracle.truffle.js.builtins.RegExpPrototypeBuiltins.JSRegExpCompileNode;
import com.oracle.truffle.js.builtins.RegExpPrototypeBuiltins.JSRegExpExecES5Node;
import com.oracle.truffle.js.builtins.RegExpPrototypeBuiltins.JSRegExpExecNode;
import com.oracle.truffle.js.builtins.RegExpPrototypeBuiltins.JSRegExpMatchAllNode;
import com.oracle.truffle.js.builtins.RegExpPrototypeBuiltins.JSRegExpMatchNode;
import com.oracle.truffle.js.builtins.RegExpPrototypeBuiltins.JSRegExpReplaceNode;
import com.oracle.truffle.js.builtins.RegExpPrototypeBuiltins.JSRegExpSearchNode;
import com.oracle.truffle.js.builtins.RegExpPrototypeBuiltins.JSRegExpSplitNode;
import com.oracle.truffle.js.builtins.RegExpPrototypeBuiltins.JSRegExpTestNode;
import com.oracle.truffle.js.builtins.RegExpPrototypeBuiltins.JSRegExpToStringNode;
import com.oracle.truffle.js.builtins.RegExpPrototypeBuiltins.RegExpFlagsGetterNode;
import com.oracle.truffle.js.builtins.StringPrototypeBuiltins.CreateRegExpStringIteratorNode;
import com.oracle.truffle.js.builtins.helper.JSRegExpExecIntlNode;
import com.oracle.truffle.js.builtins.helper.ReplaceStringParser.Token;
import com.oracle.truffle.js.nodes.CompileRegexNode;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.access.IsJSObjectNode;
import com.oracle.truffle.js.nodes.access.PropertyGetNode;
import com.oracle.truffle.js.nodes.access.PropertySetNode;
import com.oracle.truffle.js.nodes.cast.JSToLengthNode;
import com.oracle.truffle.js.nodes.cast.JSToStringNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.builtins.JSRegExp;
import com.oracle.truffle.js.runtime.util.TRegexUtil.TRegexCompiledRegexAccessor;
import com.oracle.truffle.js.runtime.util.TRegexUtil.TRegexFlagsAccessor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(RegExpPrototypeBuiltins.class)
@SuppressWarnings("unused")
public final class RegExpPrototypeBuiltinsFactory {

    @GeneratedBy(JSRegExpCompileNode.class)
    public static final class JSRegExpCompileNodeGen extends JSRegExpCompileNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private volatile int state_;
        @Child private Compile0Data compile0_cache;

        private JSRegExpCompileNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state != 0 /* is-active compile(DynamicObject, Object, Object, CompileRegexNode, JSToStringNode, ConditionProfile, TRegexCompiledRegexAccessor, TRegexFlagsAccessor) || compile(Object, Object, Object) */) {
                if ((state & 0b1) != 0 /* is-active compile(DynamicObject, Object, Object, CompileRegexNode, JSToStringNode, ConditionProfile, TRegexCompiledRegexAccessor, TRegexFlagsAccessor) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    Compile0Data s1_ = this.compile0_cache;
                    if (s1_ != null) {
                        if ((JSGuards.isJSRegExp(arguments0Value__))) {
                            return compile(arguments0Value__, arguments1Value_, arguments2Value_, s1_.compileRegexNode_, s1_.toStringNode_, s1_.isRegExpProfile_, s1_.compiledRegexAccessor_, s1_.flagsAccessor_);
                        }
                    }
                }
                if ((state & 0b10) != 0 /* is-active compile(Object, Object, Object) */) {
                    if ((!(JSGuards.isJSRegExp(arguments0Value_)))) {
                        return compile(arguments0Value_, arguments1Value_, arguments2Value_);
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
            try {
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSRegExp(arguments0Value_))) {
                        Compile0Data s1_ = super.insert(new Compile0Data());
                        s1_.compileRegexNode_ = s1_.insertAccessor((CompileRegexNode.create(getContext())));
                        s1_.toStringNode_ = s1_.insertAccessor((JSToStringNode.createUndefinedToEmpty()));
                        s1_.isRegExpProfile_ = (ConditionProfile.createBinaryProfile());
                        s1_.compiledRegexAccessor_ = s1_.insertAccessor((TRegexCompiledRegexAccessor.create()));
                        s1_.flagsAccessor_ = s1_.insertAccessor((TRegexFlagsAccessor.create()));
                        this.compile0_cache = s1_;
                        this.state_ = state = state | 0b1 /* add-active compile(DynamicObject, Object, Object, CompileRegexNode, JSToStringNode, ConditionProfile, TRegexCompiledRegexAccessor, TRegexFlagsAccessor) */;
                        lock.unlock();
                        hasLock = false;
                        return compile(arguments0Value_, arguments1Value, arguments2Value, s1_.compileRegexNode_, s1_.toStringNode_, s1_.isRegExpProfile_, s1_.compiledRegexAccessor_, s1_.flagsAccessor_);
                    }
                }
                if ((!(JSGuards.isJSRegExp(arguments0Value)))) {
                    this.state_ = state = state | 0b10 /* add-active compile(Object, Object, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return compile(arguments0Value, arguments1Value, arguments2Value);
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
            Object[] data = new Object[3];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "compile";
            if ((state & 0b1) != 0 /* is-active compile(DynamicObject, Object, Object, CompileRegexNode, JSToStringNode, ConditionProfile, TRegexCompiledRegexAccessor, TRegexFlagsAccessor) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                Compile0Data s1_ = this.compile0_cache;
                if (s1_ != null) {
                    cached.add(Arrays.asList(s1_.compileRegexNode_, s1_.toStringNode_, s1_.isRegExpProfile_, s1_.compiledRegexAccessor_, s1_.flagsAccessor_));
                }
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "compile";
            if ((state & 0b10) != 0 /* is-active compile(Object, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static JSRegExpCompileNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSRegExpCompileNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(JSRegExpCompileNode.class)
        private static final class Compile0Data extends Node {

            @Child CompileRegexNode compileRegexNode_;
            @Child JSToStringNode toStringNode_;
            @CompilationFinal ConditionProfile isRegExpProfile_;
            @Child TRegexCompiledRegexAccessor compiledRegexAccessor_;
            @Child TRegexFlagsAccessor flagsAccessor_;

            Compile0Data() {
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
    @GeneratedBy(JSRegExpExecNode.class)
    public static final class JSRegExpExecNodeGen extends JSRegExpExecNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_;
        @Child private JSToStringNode object_toStringNode_;

        private JSRegExpExecNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state & 0b11) != 0 /* is-active doString(DynamicObject, String) || doObject(DynamicObject, Object, JSToStringNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state & 0b1) != 0 /* is-active doString(DynamicObject, String) */ && JSTypesGen.isImplicitString((state & 0b1111000) >>> 3 /* extract-implicit-active 1:String */, arguments1Value_)) {
                    String arguments1Value__ = JSTypesGen.asImplicitString((state & 0b1111000) >>> 3 /* extract-implicit-active 1:String */, arguments1Value_);
                    if ((JSGuards.isJSRegExp(arguments0Value__))) {
                        return doString(arguments0Value__, arguments1Value__);
                    }
                }
                if ((state & 0b10) != 0 /* is-active doObject(DynamicObject, Object, JSToStringNode) */) {
                    if ((JSGuards.isJSRegExp(arguments0Value__))) {
                        return doObject(arguments0Value__, arguments1Value_, this.object_toStringNode_);
                    }
                }
            }
            if ((state & 0b100) != 0 /* is-active doNoRegExp(Object, Object) */) {
                if (fallbackGuard_(arguments0Value_, arguments1Value_)) {
                    return doNoRegExp(arguments0Value_, arguments1Value_);
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
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    {
                        int stringCast1;
                        if ((stringCast1 = JSTypesGen.specializeImplicitString(arguments1Value)) != 0) {
                            String arguments1Value_ = JSTypesGen.asImplicitString(stringCast1, arguments1Value);
                            if ((JSGuards.isJSRegExp(arguments0Value_))) {
                                state = (state | (stringCast1 << 3) /* set-implicit-active 1:String */);
                                this.state_ = state = state | 0b1 /* add-active doString(DynamicObject, String) */;
                                lock.unlock();
                                hasLock = false;
                                return doString(arguments0Value_, arguments1Value_);
                            }
                        }
                    }
                    if ((JSGuards.isJSRegExp(arguments0Value_))) {
                        this.object_toStringNode_ = super.insert((JSToStringNode.create()));
                        this.state_ = state = state | 0b10 /* add-active doObject(DynamicObject, Object, JSToStringNode) */;
                        lock.unlock();
                        hasLock = false;
                        return doObject(arguments0Value_, arguments1Value, this.object_toStringNode_);
                    }
                }
                this.state_ = state = state | 0b100 /* add-active doNoRegExp(Object, Object) */;
                lock.unlock();
                hasLock = false;
                return doNoRegExp(arguments0Value, arguments1Value);
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
            s[0] = "doString";
            if ((state & 0b1) != 0 /* is-active doString(DynamicObject, String) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doObject";
            if ((state & 0b10) != 0 /* is-active doObject(DynamicObject, Object, JSToStringNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.object_toStringNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "doNoRegExp";
            if ((state & 0b100) != 0 /* is-active doNoRegExp(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        private static boolean fallbackGuard_(Object arguments0Value, Object arguments1Value) {
            if (JSTypes.isDynamicObject(arguments0Value)) {
                if (JSTypesGen.isImplicitString(arguments1Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSRegExp(arguments0Value_))) {
                        return false;
                    }
                }
                {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSRegExp(arguments0Value_))) {
                        return false;
                    }
                }
            }
            return true;
        }

        public static JSRegExpExecNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSRegExpExecNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSRegExpExecES5Node.class)
    public static final class JSRegExpExecES5NodeGen extends JSRegExpExecES5Node implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private int state_;

        private JSRegExpExecES5NodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state != 0 /* is-active exec(DynamicObject, Object) || exec(Object, Object) */) {
                if ((state & 0b1) != 0 /* is-active exec(DynamicObject, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((JSGuards.isJSRegExp(arguments0Value__))) {
                        return exec(arguments0Value__, arguments1Value_);
                    }
                }
                if ((state & 0b10) != 0 /* is-active exec(Object, Object) */) {
                    if ((!(JSGuards.isJSRegExp(arguments0Value_)))) {
                        return exec(arguments0Value_, arguments1Value_);
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
            int state = state_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((JSGuards.isJSRegExp(arguments0Value_))) {
                    this.state_ = state = state | 0b1 /* add-active exec(DynamicObject, Object) */;
                    return exec(arguments0Value_, arguments1Value);
                }
            }
            if ((!(JSGuards.isJSRegExp(arguments0Value)))) {
                this.state_ = state = state | 0b10 /* add-active exec(Object, Object) */;
                return exec(arguments0Value, arguments1Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_}, arguments0Value, arguments1Value);
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
            s[0] = "exec";
            if ((state & 0b1) != 0 /* is-active exec(DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "exec";
            if ((state & 0b10) != 0 /* is-active exec(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static JSRegExpExecES5Node create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSRegExpExecES5NodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSRegExpTestNode.class)
    public static final class JSRegExpTestNodeGen extends JSRegExpTestNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_;
        @Child private TestGenericData testGeneric_cache;

        private JSRegExpTestNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_};
        }

        private boolean fallbackGuard_(int state, Object arguments0Value, Object arguments1Value) {
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((((state & 0b10)) == 0 /* is-not-active Guard[(isObjectNode.executeBoolean(thisObj))] */ || (this.testGeneric_cache.isObjectNode_.executeBoolean(arguments0Value_)))) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if ((state & 0b101) != 0 /* is-active testGeneric(DynamicObject, Object, IsJSObjectNode, JSToStringNode, JSRegExpExecIntlNode) || testError(Object, Object) */) {
                if ((state & 0b1) != 0 /* is-active testGeneric(DynamicObject, Object, IsJSObjectNode, JSToStringNode, JSRegExpExecIntlNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    TestGenericData s1_ = this.testGeneric_cache;
                    if (s1_ != null) {
                        if ((s1_.isObjectNode_.executeBoolean(arguments0Value__))) {
                            return testGeneric(arguments0Value__, arguments1Value_, s1_.isObjectNode_, s1_.toStringNode_, s1_.regExpNode_);
                        }
                    }
                }
                if ((state & 0b100) != 0 /* is-active testError(Object, Object) */) {
                    if (fallbackGuard_(state, arguments0Value_, arguments1Value_)) {
                        return testError(arguments0Value_, arguments1Value_);
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
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    TestGenericData s1_ = this.testGeneric_cache;
                    boolean TestGeneric_duplicateFound_ = false;
                    if ((state & 0b1) != 0 /* is-active testGeneric(DynamicObject, Object, IsJSObjectNode, JSToStringNode, JSRegExpExecIntlNode) */) {
                        if ((s1_.isObjectNode_.executeBoolean(arguments0Value_))) {
                            TestGeneric_duplicateFound_ = true;
                        }
                    }
                    if (!TestGeneric_duplicateFound_) {
                        {
                            if (((state & 0b10)) == 0 /* is-not-active Guard[(isObjectNode.executeBoolean(thisObj))] */) {
                                s1_ = super.insert(new TestGenericData());
                                this.testGeneric_cache = s1_;
                                s1_.isObjectNode_ = s1_.insertAccessor((IsJSObjectNode.create()));
                                this.state_ = state = state | 0b10 /* add-active Guard[(isObjectNode.executeBoolean(thisObj))] */;
                            }
                            if ((s1_.isObjectNode_.executeBoolean(arguments0Value_)) && ((state & 0b1)) == 0 /* is-not-active testGeneric(DynamicObject, Object, IsJSObjectNode, JSToStringNode, JSRegExpExecIntlNode) */) {
                                s1_ = super.insert(new TestGenericData());
                                s1_.isObjectNode_ = s1_.insertAccessor((IsJSObjectNode.create()));
                                s1_.toStringNode_ = s1_.insertAccessor((JSToStringNode.create()));
                                s1_.regExpNode_ = s1_.insertAccessor((JSRegExpExecIntlNode.create(getContext())));
                                this.testGeneric_cache = s1_;
                                this.state_ = state = state | 0b1 /* add-active testGeneric(DynamicObject, Object, IsJSObjectNode, JSToStringNode, JSRegExpExecIntlNode) */;
                                TestGeneric_duplicateFound_ = true;
                            }
                        }
                    }
                    if (TestGeneric_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return testGeneric(arguments0Value_, arguments1Value, s1_.isObjectNode_, s1_.toStringNode_, s1_.regExpNode_);
                    }
                }
                this.state_ = state = state | 0b100 /* add-active testError(Object, Object) */;
                lock.unlock();
                hasLock = false;
                return testError(arguments0Value, arguments1Value);
            } finally {
                if (hasLock) {
                    lock.unlock();
                }
            }
        }

        @Override
        public NodeCost getCost() {
            int state = state_;
            if ((state & 0b101) == 0b0) {
                return NodeCost.UNINITIALIZED;
            } else if (((state & 0b101) & ((state & 0b101) - 1)) == 0 /* is-single-active  */) {
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
            s[0] = "testGeneric";
            if ((state & 0b1) != 0 /* is-active testGeneric(DynamicObject, Object, IsJSObjectNode, JSToStringNode, JSRegExpExecIntlNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                TestGenericData s1_ = this.testGeneric_cache;
                if (s1_ != null) {
                    cached.add(Arrays.asList(s1_.isObjectNode_, s1_.toStringNode_, s1_.regExpNode_));
                }
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "testError";
            if ((state & 0b100) != 0 /* is-active testError(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static JSRegExpTestNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSRegExpTestNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(JSRegExpTestNode.class)
        private static final class TestGenericData extends Node {

            @Child IsJSObjectNode isObjectNode_;
            @Child JSToStringNode toStringNode_;
            @Child JSRegExpExecIntlNode regExpNode_;

            TestGenericData() {
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
    @GeneratedBy(JSRegExpToStringNode.class)
    public static final class JSRegExpToStringNodeGen extends JSRegExpToStringNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_;
        @Child private ToStringData toString_cache;

        private JSRegExpToStringNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        private boolean fallbackGuard_(int state, Object arguments0Value) {
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((((state & 0b10)) == 0 /* is-not-active Guard[(isObjectNode.executeBoolean(thisObj))] */ || (this.toString_cache.isObjectNode_.executeBoolean(arguments0Value_)))) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state & 0b1) != 0 /* is-active toString(DynamicObject, IsJSObjectNode, JSToStringNode, JSToStringNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                ToStringData s1_ = this.toString_cache;
                if (s1_ != null) {
                    if ((s1_.isObjectNode_.executeBoolean(arguments0Value__))) {
                        return toString(arguments0Value__, s1_.isObjectNode_, s1_.toString1Node_, s1_.toString2Node_);
                    }
                }
            }
            if ((state & 0b100) != 0 /* is-active toString(Object) */) {
                if (fallbackGuard_(state, arguments0Value_)) {
                    return toString(arguments0Value_);
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
                    ToStringData s1_ = this.toString_cache;
                    boolean ToString_duplicateFound_ = false;
                    if ((state & 0b1) != 0 /* is-active toString(DynamicObject, IsJSObjectNode, JSToStringNode, JSToStringNode) */) {
                        if ((s1_.isObjectNode_.executeBoolean(arguments0Value_))) {
                            ToString_duplicateFound_ = true;
                        }
                    }
                    if (!ToString_duplicateFound_) {
                        {
                            if (((state & 0b10)) == 0 /* is-not-active Guard[(isObjectNode.executeBoolean(thisObj))] */) {
                                s1_ = super.insert(new ToStringData());
                                this.toString_cache = s1_;
                                s1_.isObjectNode_ = s1_.insertAccessor((IsJSObjectNode.create()));
                                this.state_ = state = state | 0b10 /* add-active Guard[(isObjectNode.executeBoolean(thisObj))] */;
                            }
                            if ((s1_.isObjectNode_.executeBoolean(arguments0Value_)) && ((state & 0b1)) == 0 /* is-not-active toString(DynamicObject, IsJSObjectNode, JSToStringNode, JSToStringNode) */) {
                                s1_ = super.insert(new ToStringData());
                                s1_.isObjectNode_ = s1_.insertAccessor((IsJSObjectNode.create()));
                                s1_.toString1Node_ = s1_.insertAccessor((JSToStringNode.create()));
                                s1_.toString2Node_ = s1_.insertAccessor((JSToStringNode.create()));
                                this.toString_cache = s1_;
                                this.state_ = state = state | 0b1 /* add-active toString(DynamicObject, IsJSObjectNode, JSToStringNode, JSToStringNode) */;
                                ToString_duplicateFound_ = true;
                            }
                        }
                    }
                    if (ToString_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return toString(arguments0Value_, s1_.isObjectNode_, s1_.toString1Node_, s1_.toString2Node_);
                    }
                }
                this.state_ = state = state | 0b100 /* add-active toString(Object) */;
                lock.unlock();
                hasLock = false;
                return toString(arguments0Value);
            } finally {
                if (hasLock) {
                    lock.unlock();
                }
            }
        }

        @Override
        public NodeCost getCost() {
            int state = state_;
            if ((state & 0b101) == 0b0) {
                return NodeCost.UNINITIALIZED;
            } else if (((state & 0b101) & ((state & 0b101) - 1)) == 0 /* is-single-active  */) {
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
            s[0] = "toString";
            if ((state & 0b1) != 0 /* is-active toString(DynamicObject, IsJSObjectNode, JSToStringNode, JSToStringNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                ToStringData s1_ = this.toString_cache;
                if (s1_ != null) {
                    cached.add(Arrays.asList(s1_.isObjectNode_, s1_.toString1Node_, s1_.toString2Node_));
                }
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "toString";
            if ((state & 0b100) != 0 /* is-active toString(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static JSRegExpToStringNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSRegExpToStringNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(JSRegExpToStringNode.class)
        private static final class ToStringData extends Node {

            @Child IsJSObjectNode isObjectNode_;
            @Child JSToStringNode toString1Node_;
            @Child JSToStringNode toString2Node_;

            ToStringData() {
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
    @GeneratedBy(JSRegExpSplitNode.class)
    public static final class JSRegExpSplitNodeGen extends JSRegExpSplitNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private int state_;

        private JSRegExpSplitNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state & 0b11110) == 0 /* only-active splitIntLimit(DynamicObject, Object, int) */ && state != 0  /* is-not splitIntLimit(DynamicObject, Object, int) && splitLongLimit(DynamicObject, Object, long) && splitUndefinedLimit(DynamicObject, Object, Object) && splitObjectLimit(DynamicObject, Object, Object) && doNoObject(Object, Object, Object) */) {
                return execute_int0(frameValue, state);
            } else if ((state & 0b11101) == 0 /* only-active splitLongLimit(DynamicObject, Object, long) */ && state != 0  /* is-not splitIntLimit(DynamicObject, Object, int) && splitLongLimit(DynamicObject, Object, long) && splitUndefinedLimit(DynamicObject, Object, Object) && splitObjectLimit(DynamicObject, Object, Object) && doNoObject(Object, Object, Object) */) {
                return execute_long1(frameValue, state);
            } else {
                return execute_generic2(frameValue, state);
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
            assert (state & 0b1) != 0 /* is-active splitIntLimit(DynamicObject, Object, int) */;
            if (JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                return splitIntLimit(arguments0Value__, arguments1Value_, arguments2Value_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        private Object execute_long1(VirtualFrame frameValue, int state) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            long arguments2Value_;
            try {
                arguments2Value_ = this.arguments2_.executeLong(frameValue);
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(arguments0Value_, arguments1Value_, ex.getResult());
            }
            assert (state & 0b10) != 0 /* is-active splitLongLimit(DynamicObject, Object, long) */;
            if (JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                return splitLongLimit(arguments0Value__, arguments1Value_, arguments2Value_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        private Object execute_generic2(VirtualFrame frameValue, int state) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if (state != 0 /* is-active splitIntLimit(DynamicObject, Object, int) || splitLongLimit(DynamicObject, Object, long) || splitUndefinedLimit(DynamicObject, Object, Object) || splitObjectLimit(DynamicObject, Object, Object) || doNoObject(Object, Object, Object) */) {
                if ((state & 0b1111) != 0 /* is-active splitIntLimit(DynamicObject, Object, int) || splitLongLimit(DynamicObject, Object, long) || splitUndefinedLimit(DynamicObject, Object, Object) || splitObjectLimit(DynamicObject, Object, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((state & 0b1) != 0 /* is-active splitIntLimit(DynamicObject, Object, int) */ && arguments2Value_ instanceof Integer) {
                        int arguments2Value__ = (int) arguments2Value_;
                        return splitIntLimit(arguments0Value__, arguments1Value_, arguments2Value__);
                    }
                    if ((state & 0b10) != 0 /* is-active splitLongLimit(DynamicObject, Object, long) */ && arguments2Value_ instanceof Long) {
                        long arguments2Value__ = (long) arguments2Value_;
                        return splitLongLimit(arguments0Value__, arguments1Value_, arguments2Value__);
                    }
                    if ((state & 0b1100) != 0 /* is-active splitUndefinedLimit(DynamicObject, Object, Object) || splitObjectLimit(DynamicObject, Object, Object) */) {
                        if ((state & 0b100) != 0 /* is-active splitUndefinedLimit(DynamicObject, Object, Object) */) {
                            if ((JSGuards.isUndefined(arguments2Value_))) {
                                return splitUndefinedLimit(arguments0Value__, arguments1Value_, arguments2Value_);
                            }
                        }
                        if ((state & 0b1000) != 0 /* is-active splitObjectLimit(DynamicObject, Object, Object) */) {
                            if ((!(JSGuards.isUndefined(arguments2Value_)))) {
                                return splitObjectLimit(arguments0Value__, arguments1Value_, arguments2Value_);
                            }
                        }
                    }
                }
                if ((state & 0b10000) != 0 /* is-active doNoObject(Object, Object, Object) */) {
                    if (fallbackGuard_(state, arguments0Value_, arguments1Value_, arguments2Value_)) {
                        return doNoObject(arguments0Value_, arguments1Value_, arguments2Value_);
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
                if (arguments2Value instanceof Integer) {
                    int arguments2Value_ = (int) arguments2Value;
                    this.state_ = state = state | 0b1 /* add-active splitIntLimit(DynamicObject, Object, int) */;
                    return splitIntLimit(arguments0Value_, arguments1Value, arguments2Value_);
                }
                if (arguments2Value instanceof Long) {
                    long arguments2Value_ = (long) arguments2Value;
                    this.state_ = state = state | 0b10 /* add-active splitLongLimit(DynamicObject, Object, long) */;
                    return splitLongLimit(arguments0Value_, arguments1Value, arguments2Value_);
                }
                if ((JSGuards.isUndefined(arguments2Value))) {
                    this.state_ = state = state | 0b100 /* add-active splitUndefinedLimit(DynamicObject, Object, Object) */;
                    return splitUndefinedLimit(arguments0Value_, arguments1Value, arguments2Value);
                }
                if ((!(JSGuards.isUndefined(arguments2Value)))) {
                    this.state_ = state = state | 0b1000 /* add-active splitObjectLimit(DynamicObject, Object, Object) */;
                    return splitObjectLimit(arguments0Value_, arguments1Value, arguments2Value);
                }
            }
            this.state_ = state = state | 0b10000 /* add-active doNoObject(Object, Object, Object) */;
            return doNoObject(arguments0Value, arguments1Value, arguments2Value);
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
            s[0] = "splitIntLimit";
            if ((state & 0b1) != 0 /* is-active splitIntLimit(DynamicObject, Object, int) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "splitLongLimit";
            if ((state & 0b10) != 0 /* is-active splitLongLimit(DynamicObject, Object, long) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "splitUndefinedLimit";
            if ((state & 0b100) != 0 /* is-active splitUndefinedLimit(DynamicObject, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "splitObjectLimit";
            if ((state & 0b1000) != 0 /* is-active splitObjectLimit(DynamicObject, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            s = new Object[3];
            s[0] = "doNoObject";
            if ((state & 0b10000) != 0 /* is-active doNoObject(Object, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[5] = s;
            return Provider.create(data);
        }

        private static boolean fallbackGuard_(int state, Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            if (JSTypes.isDynamicObject(arguments0Value)) {
                if (((state & 0b1)) == 0 /* is-not-active splitIntLimit(DynamicObject, Object, int) */ && arguments2Value instanceof Integer) {
                    return false;
                }
                if (((state & 0b10)) == 0 /* is-not-active splitLongLimit(DynamicObject, Object, long) */ && arguments2Value instanceof Long) {
                    return false;
                }
                if (((state & 0b100)) == 0 /* is-not-active splitUndefinedLimit(DynamicObject, Object, Object) */ && (JSGuards.isUndefined(arguments2Value))) {
                    return false;
                }
                if (((state & 0b1000)) == 0 /* is-not-active splitObjectLimit(DynamicObject, Object, Object) */ && (!(JSGuards.isUndefined(arguments2Value)))) {
                    return false;
                }
            }
            return true;
        }

        public static JSRegExpSplitNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSRegExpSplitNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSRegExpReplaceNode.class)
    public static final class JSRegExpReplaceNodeGen extends JSRegExpReplaceNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private volatile int state_;
        @CompilationFinal private volatile int exclude_;
        @Child private ReplaceCachedData replaceCached_cache;
        @Child private JSToStringNode replaceDynamic_toString1Node_;

        private JSRegExpReplaceNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state & 0b111) != 0 /* is-active replaceCached(DynamicObject, Object, String, String, Token[], Token[], JSToStringNode) || replaceDynamic(DynamicObject, Object, Object, JSToStringNode) || doNoObject(Object, Object, Object) */) {
                if ((state & 0b11) != 0 /* is-active replaceCached(DynamicObject, Object, String, String, Token[], Token[], JSToStringNode) || replaceDynamic(DynamicObject, Object, Object, JSToStringNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((state & 0b1) != 0 /* is-active replaceCached(DynamicObject, Object, String, String, Token[], Token[], JSToStringNode) */ && JSTypesGen.isImplicitString((state & 0b1111000) >>> 3 /* extract-implicit-active 2:String */, arguments2Value_)) {
                        String arguments2Value__ = JSTypesGen.asImplicitString((state & 0b1111000) >>> 3 /* extract-implicit-active 2:String */, arguments2Value_);
                        ReplaceCachedData s1_ = this.replaceCached_cache;
                        while (s1_ != null) {
                            if ((s1_.cachedReplaceValue_.equals(arguments2Value__))) {
                                return replaceCached(arguments0Value__, arguments1Value_, arguments2Value__, s1_.cachedReplaceValue_, s1_.cachedParsedReplaceValueWithNamedCG_, s1_.cachedParsedReplaceValueWithoutNamedCG_, s1_.toString1Node_);
                            }
                            s1_ = s1_.next_;
                        }
                    }
                    if ((state & 0b10) != 0 /* is-active replaceDynamic(DynamicObject, Object, Object, JSToStringNode) */) {
                        return replaceDynamic(arguments0Value__, arguments1Value_, arguments2Value_, this.replaceDynamic_toString1Node_);
                    }
                }
                if ((state & 0b100) != 0 /* is-active doNoObject(Object, Object, Object) */) {
                    if (fallbackGuard_(state, arguments0Value_, arguments1Value_, arguments2Value_)) {
                        return doNoObject(arguments0Value_, arguments1Value_, arguments2Value_);
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
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int exclude = exclude_;
            try {
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((exclude) == 0 /* is-not-excluded replaceCached(DynamicObject, Object, String, String, Token[], Token[], JSToStringNode) */) {
                        int stringCast2;
                        if ((stringCast2 = JSTypesGen.specializeImplicitString(arguments2Value)) != 0) {
                            String arguments2Value_ = JSTypesGen.asImplicitString(stringCast2, arguments2Value);
                            int count1_ = 0;
                            ReplaceCachedData s1_ = this.replaceCached_cache;
                            if ((state & 0b1) != 0 /* is-active replaceCached(DynamicObject, Object, String, String, Token[], Token[], JSToStringNode) */) {
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
                                    s1_ = super.insert(new ReplaceCachedData(replaceCached_cache));
                                    s1_.cachedReplaceValue_ = (arguments2Value_);
                                    s1_.cachedParsedReplaceValueWithNamedCG_ = (JSRegExpReplaceNode.parseReplaceValueWithNCG(arguments2Value_));
                                    s1_.cachedParsedReplaceValueWithoutNamedCG_ = (JSRegExpReplaceNode.parseReplaceValueWithoutNCG(arguments2Value_));
                                    s1_.toString1Node_ = s1_.insertAccessor((JSToStringNode.create()));
                                    this.replaceCached_cache = s1_;
                                    state = (state | (stringCast2 << 3) /* set-implicit-active 2:String */);
                                    this.state_ = state = state | 0b1 /* add-active replaceCached(DynamicObject, Object, String, String, Token[], Token[], JSToStringNode) */;
                                }
                            } else {
                                state = (state | (stringCast2 << 3) /* set-implicit-active 2:String */);
                                this.state_ = state = state | 0b1 /* add-active replaceCached(DynamicObject, Object, String, String, Token[], Token[], JSToStringNode) */;
                            }
                            if (s1_ != null) {
                                lock.unlock();
                                hasLock = false;
                                return replaceCached(arguments0Value_, arguments1Value, arguments2Value_, s1_.cachedReplaceValue_, s1_.cachedParsedReplaceValueWithNamedCG_, s1_.cachedParsedReplaceValueWithoutNamedCG_, s1_.toString1Node_);
                            }
                        }
                    }
                    this.replaceDynamic_toString1Node_ = super.insert((JSToStringNode.create()));
                    this.exclude_ = exclude = exclude | 0b1 /* add-excluded replaceCached(DynamicObject, Object, String, String, Token[], Token[], JSToStringNode) */;
                    this.replaceCached_cache = null;
                    state = state & 0xfffffffe /* remove-active replaceCached(DynamicObject, Object, String, String, Token[], Token[], JSToStringNode) */;
                    this.state_ = state = state | 0b10 /* add-active replaceDynamic(DynamicObject, Object, Object, JSToStringNode) */;
                    lock.unlock();
                    hasLock = false;
                    return replaceDynamic(arguments0Value_, arguments1Value, arguments2Value, this.replaceDynamic_toString1Node_);
                }
                this.state_ = state = state | 0b100 /* add-active doNoObject(Object, Object, Object) */;
                lock.unlock();
                hasLock = false;
                return doNoObject(arguments0Value, arguments1Value, arguments2Value);
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
                ReplaceCachedData s1_ = this.replaceCached_cache;
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
            s[0] = "replaceCached";
            if ((state & 0b1) != 0 /* is-active replaceCached(DynamicObject, Object, String, String, Token[], Token[], JSToStringNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                ReplaceCachedData s1_ = this.replaceCached_cache;
                while (s1_ != null) {
                    cached.add(Arrays.asList(s1_.cachedReplaceValue_, s1_.cachedParsedReplaceValueWithNamedCG_, s1_.cachedParsedReplaceValueWithoutNamedCG_, s1_.toString1Node_));
                    s1_ = s1_.next_;
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-excluded replaceCached(DynamicObject, Object, String, String, Token[], Token[], JSToStringNode) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "replaceDynamic";
            if ((state & 0b10) != 0 /* is-active replaceDynamic(DynamicObject, Object, Object, JSToStringNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.replaceDynamic_toString1Node_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "doNoObject";
            if ((state & 0b100) != 0 /* is-active doNoObject(Object, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        private static boolean fallbackGuard_(int state, Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            if (((state & 0b10)) == 0 /* is-not-active replaceDynamic(DynamicObject, Object, Object, JSToStringNode) */ && JSTypes.isDynamicObject(arguments0Value)) {
                return false;
            }
            return true;
        }

        public static JSRegExpReplaceNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSRegExpReplaceNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(JSRegExpReplaceNode.class)
        private static final class ReplaceCachedData extends Node {

            @Child ReplaceCachedData next_;
            @CompilationFinal String cachedReplaceValue_;
            @CompilationFinal(dimensions = 1) Token[] cachedParsedReplaceValueWithNamedCG_;
            @CompilationFinal(dimensions = 1) Token[] cachedParsedReplaceValueWithoutNamedCG_;
            @Child JSToStringNode toString1Node_;

            ReplaceCachedData(ReplaceCachedData next_) {
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
    @GeneratedBy(JSRegExpMatchNode.class)
    public static final class JSRegExpMatchNodeGen extends JSRegExpMatchNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_;
        @Child private MatchData match_cache;

        private JSRegExpMatchNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_};
        }

        private boolean fallbackGuard_(int state, Object arguments0Value, Object arguments1Value) {
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((((state & 0b10)) == 0 /* is-not-active Guard[(isObjectNode.executeBoolean(rx))] */ || (this.match_cache.isObjectNode_.executeBoolean(arguments0Value_)))) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if ((state & 0b101) != 0 /* is-active match(DynamicObject, Object, IsJSObjectNode, JSToStringNode, JSToStringNode) || match(Object, Object) */) {
                if ((state & 0b1) != 0 /* is-active match(DynamicObject, Object, IsJSObjectNode, JSToStringNode, JSToStringNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    MatchData s1_ = this.match_cache;
                    if (s1_ != null) {
                        if ((s1_.isObjectNode_.executeBoolean(arguments0Value__))) {
                            return match(arguments0Value__, arguments1Value_, s1_.isObjectNode_, s1_.toString1Node_, s1_.toString2Node_);
                        }
                    }
                }
                if ((state & 0b100) != 0 /* is-active match(Object, Object) */) {
                    if (fallbackGuard_(state, arguments0Value_, arguments1Value_)) {
                        return match(arguments0Value_, arguments1Value_);
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
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    MatchData s1_ = this.match_cache;
                    boolean Match_duplicateFound_ = false;
                    if ((state & 0b1) != 0 /* is-active match(DynamicObject, Object, IsJSObjectNode, JSToStringNode, JSToStringNode) */) {
                        if ((s1_.isObjectNode_.executeBoolean(arguments0Value_))) {
                            Match_duplicateFound_ = true;
                        }
                    }
                    if (!Match_duplicateFound_) {
                        {
                            if (((state & 0b10)) == 0 /* is-not-active Guard[(isObjectNode.executeBoolean(rx))] */) {
                                s1_ = super.insert(new MatchData());
                                this.match_cache = s1_;
                                s1_.isObjectNode_ = s1_.insertAccessor((IsJSObjectNode.create()));
                                this.state_ = state = state | 0b10 /* add-active Guard[(isObjectNode.executeBoolean(rx))] */;
                            }
                            if ((s1_.isObjectNode_.executeBoolean(arguments0Value_)) && ((state & 0b1)) == 0 /* is-not-active match(DynamicObject, Object, IsJSObjectNode, JSToStringNode, JSToStringNode) */) {
                                s1_ = super.insert(new MatchData());
                                s1_.isObjectNode_ = s1_.insertAccessor((IsJSObjectNode.create()));
                                s1_.toString1Node_ = s1_.insertAccessor((JSToStringNode.create()));
                                s1_.toString2Node_ = s1_.insertAccessor((JSToStringNode.create()));
                                this.match_cache = s1_;
                                this.state_ = state = state | 0b1 /* add-active match(DynamicObject, Object, IsJSObjectNode, JSToStringNode, JSToStringNode) */;
                                Match_duplicateFound_ = true;
                            }
                        }
                    }
                    if (Match_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return match(arguments0Value_, arguments1Value, s1_.isObjectNode_, s1_.toString1Node_, s1_.toString2Node_);
                    }
                }
                this.state_ = state = state | 0b100 /* add-active match(Object, Object) */;
                lock.unlock();
                hasLock = false;
                return match(arguments0Value, arguments1Value);
            } finally {
                if (hasLock) {
                    lock.unlock();
                }
            }
        }

        @Override
        public NodeCost getCost() {
            int state = state_;
            if ((state & 0b101) == 0b0) {
                return NodeCost.UNINITIALIZED;
            } else if (((state & 0b101) & ((state & 0b101) - 1)) == 0 /* is-single-active  */) {
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
            s[0] = "match";
            if ((state & 0b1) != 0 /* is-active match(DynamicObject, Object, IsJSObjectNode, JSToStringNode, JSToStringNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                MatchData s1_ = this.match_cache;
                if (s1_ != null) {
                    cached.add(Arrays.asList(s1_.isObjectNode_, s1_.toString1Node_, s1_.toString2Node_));
                }
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "match";
            if ((state & 0b100) != 0 /* is-active match(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static JSRegExpMatchNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSRegExpMatchNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(JSRegExpMatchNode.class)
        private static final class MatchData extends Node {

            @Child IsJSObjectNode isObjectNode_;
            @Child JSToStringNode toString1Node_;
            @Child JSToStringNode toString2Node_;

            MatchData() {
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
    @GeneratedBy(JSRegExpSearchNode.class)
    public static final class JSRegExpSearchNodeGen extends JSRegExpSearchNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_;
        @Child private IsJSObjectNode search_isObjectNode_;
        @Child private JSToStringNode search_toString1Node_;

        private JSRegExpSearchNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_};
        }

        private boolean fallbackGuard_(int state, Object arguments0Value, Object arguments1Value) {
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((((state & 0b10)) == 0 /* is-not-active Guard[(isObjectNode.executeBoolean(rx))] */ || (this.search_isObjectNode_.executeBoolean(arguments0Value_)))) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if ((state & 0b101) != 0 /* is-active search(DynamicObject, Object, IsJSObjectNode, JSToStringNode) || search(Object, Object) */) {
                if ((state & 0b1) != 0 /* is-active search(DynamicObject, Object, IsJSObjectNode, JSToStringNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((this.search_isObjectNode_.executeBoolean(arguments0Value__))) {
                        return search(arguments0Value__, arguments1Value_, this.search_isObjectNode_, this.search_toString1Node_);
                    }
                }
                if ((state & 0b100) != 0 /* is-active search(Object, Object) */) {
                    if (fallbackGuard_(state, arguments0Value_, arguments1Value_)) {
                        return search(arguments0Value_, arguments1Value_);
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
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    boolean Search_duplicateFound_ = false;
                    if ((state & 0b1) != 0 /* is-active search(DynamicObject, Object, IsJSObjectNode, JSToStringNode) */) {
                        if ((this.search_isObjectNode_.executeBoolean(arguments0Value_))) {
                            Search_duplicateFound_ = true;
                        }
                    }
                    if (!Search_duplicateFound_) {
                        {
                            if (((state & 0b10)) == 0 /* is-not-active Guard[(isObjectNode.executeBoolean(rx))] */) {
                                this.search_isObjectNode_ = super.insert((IsJSObjectNode.create()));
                                this.state_ = state = state | 0b10 /* add-active Guard[(isObjectNode.executeBoolean(rx))] */;
                            }
                            if ((this.search_isObjectNode_.executeBoolean(arguments0Value_)) && ((state & 0b1)) == 0 /* is-not-active search(DynamicObject, Object, IsJSObjectNode, JSToStringNode) */) {
                                this.search_isObjectNode_ = super.insert((IsJSObjectNode.create()));
                                this.search_toString1Node_ = super.insert((JSToStringNode.create()));
                                this.state_ = state = state | 0b1 /* add-active search(DynamicObject, Object, IsJSObjectNode, JSToStringNode) */;
                                Search_duplicateFound_ = true;
                            }
                        }
                    }
                    if (Search_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return search(arguments0Value_, arguments1Value, this.search_isObjectNode_, this.search_toString1Node_);
                    }
                }
                this.state_ = state = state | 0b100 /* add-active search(Object, Object) */;
                lock.unlock();
                hasLock = false;
                return search(arguments0Value, arguments1Value);
            } finally {
                if (hasLock) {
                    lock.unlock();
                }
            }
        }

        @Override
        public NodeCost getCost() {
            int state = state_;
            if ((state & 0b101) == 0b0) {
                return NodeCost.UNINITIALIZED;
            } else if (((state & 0b101) & ((state & 0b101) - 1)) == 0 /* is-single-active  */) {
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
            s[0] = "search";
            if ((state & 0b1) != 0 /* is-active search(DynamicObject, Object, IsJSObjectNode, JSToStringNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.search_isObjectNode_, this.search_toString1Node_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "search";
            if ((state & 0b100) != 0 /* is-active search(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static JSRegExpSearchNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSRegExpSearchNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSRegExpMatchAllNode.class)
    public static final class JSRegExpMatchAllNodeGen extends JSRegExpMatchAllNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_;
        @Child private MatchAllData matchAll_cache;

        private JSRegExpMatchAllNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_};
        }

        private boolean fallbackGuard_(int state, Object arguments0Value, Object arguments1Value) {
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((((state & 0b10)) == 0 /* is-not-active Guard[(isObjectNode.executeBoolean(regex))] */ || (this.matchAll_cache.isObjectNode_.executeBoolean(arguments0Value_)))) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if ((state & 0b101) != 0 /* is-active matchAll(VirtualFrame, DynamicObject, Object, JSToStringNode, ArraySpeciesConstructorNode, PropertyGetNode, JSToStringNode, PropertyGetNode, JSToLengthNode, PropertySetNode, CreateRegExpStringIteratorNode, IsJSObjectNode, ConditionProfile) || matchAll(Object, Object) */) {
                if ((state & 0b1) != 0 /* is-active matchAll(VirtualFrame, DynamicObject, Object, JSToStringNode, ArraySpeciesConstructorNode, PropertyGetNode, JSToStringNode, PropertyGetNode, JSToLengthNode, PropertySetNode, CreateRegExpStringIteratorNode, IsJSObjectNode, ConditionProfile) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    MatchAllData s1_ = this.matchAll_cache;
                    if (s1_ != null) {
                        if ((s1_.isObjectNode_.executeBoolean(arguments0Value__))) {
                            return matchAll(frameValue, arguments0Value__, arguments1Value_, s1_.toStringNodeForInput_, s1_.speciesConstructNode_, s1_.getFlagsNode_, s1_.toStringNodeForFlags_, s1_.getLastIndexNode_, s1_.toLengthNode_, s1_.setLastIndexNode_, s1_.createRegExpStringIteratorNode_, s1_.isObjectNode_, s1_.indexInIntRangeProf_);
                        }
                    }
                }
                if ((state & 0b100) != 0 /* is-active matchAll(Object, Object) */) {
                    if (fallbackGuard_(state, arguments0Value_, arguments1Value_)) {
                        return matchAll(arguments0Value_, arguments1Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(frameValue, arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private Object executeAndSpecialize(VirtualFrame frameValue, Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            try {
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    MatchAllData s1_ = this.matchAll_cache;
                    boolean MatchAll_duplicateFound_ = false;
                    if ((state & 0b1) != 0 /* is-active matchAll(VirtualFrame, DynamicObject, Object, JSToStringNode, ArraySpeciesConstructorNode, PropertyGetNode, JSToStringNode, PropertyGetNode, JSToLengthNode, PropertySetNode, CreateRegExpStringIteratorNode, IsJSObjectNode, ConditionProfile) */) {
                        if ((s1_.isObjectNode_.executeBoolean(arguments0Value_))) {
                            MatchAll_duplicateFound_ = true;
                        }
                    }
                    if (!MatchAll_duplicateFound_) {
                        {
                            if (((state & 0b10)) == 0 /* is-not-active Guard[(isObjectNode.executeBoolean(regex))] */) {
                                s1_ = super.insert(new MatchAllData());
                                this.matchAll_cache = s1_;
                                s1_.isObjectNode_ = s1_.insertAccessor((IsJSObjectNode.create()));
                                this.state_ = state = state | 0b10 /* add-active Guard[(isObjectNode.executeBoolean(regex))] */;
                            }
                            if ((s1_.isObjectNode_.executeBoolean(arguments0Value_)) && ((state & 0b1)) == 0 /* is-not-active matchAll(VirtualFrame, DynamicObject, Object, JSToStringNode, ArraySpeciesConstructorNode, PropertyGetNode, JSToStringNode, PropertyGetNode, JSToLengthNode, PropertySetNode, CreateRegExpStringIteratorNode, IsJSObjectNode, ConditionProfile) */) {
                                s1_ = super.insert(new MatchAllData());
                                s1_.toStringNodeForInput_ = s1_.insertAccessor((JSToStringNode.create()));
                                s1_.speciesConstructNode_ = s1_.insertAccessor((createSpeciesConstructNode()));
                                s1_.getFlagsNode_ = s1_.insertAccessor((PropertyGetNode.create(JSRegExp.FLAGS, getContext())));
                                s1_.toStringNodeForFlags_ = s1_.insertAccessor((JSToStringNode.create()));
                                s1_.getLastIndexNode_ = s1_.insertAccessor((PropertyGetNode.create(JSRegExp.LAST_INDEX, getContext())));
                                s1_.toLengthNode_ = s1_.insertAccessor((JSToLengthNode.create()));
                                s1_.setLastIndexNode_ = s1_.insertAccessor((PropertySetNode.create(JSRegExp.LAST_INDEX, JSGuards.FALSE, getContext(), JSGuards.TRUE)));
                                s1_.createRegExpStringIteratorNode_ = s1_.insertAccessor((createCreateRegExpStringIteratorNode()));
                                s1_.isObjectNode_ = s1_.insertAccessor((IsJSObjectNode.create()));
                                s1_.indexInIntRangeProf_ = (ConditionProfile.createBinaryProfile());
                                this.matchAll_cache = s1_;
                                this.state_ = state = state | 0b1 /* add-active matchAll(VirtualFrame, DynamicObject, Object, JSToStringNode, ArraySpeciesConstructorNode, PropertyGetNode, JSToStringNode, PropertyGetNode, JSToLengthNode, PropertySetNode, CreateRegExpStringIteratorNode, IsJSObjectNode, ConditionProfile) */;
                                MatchAll_duplicateFound_ = true;
                            }
                        }
                    }
                    if (MatchAll_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return matchAll(frameValue, arguments0Value_, arguments1Value, s1_.toStringNodeForInput_, s1_.speciesConstructNode_, s1_.getFlagsNode_, s1_.toStringNodeForFlags_, s1_.getLastIndexNode_, s1_.toLengthNode_, s1_.setLastIndexNode_, s1_.createRegExpStringIteratorNode_, s1_.isObjectNode_, s1_.indexInIntRangeProf_);
                    }
                }
                this.state_ = state = state | 0b100 /* add-active matchAll(Object, Object) */;
                lock.unlock();
                hasLock = false;
                return matchAll(arguments0Value, arguments1Value);
            } finally {
                if (hasLock) {
                    lock.unlock();
                }
            }
        }

        @Override
        public NodeCost getCost() {
            int state = state_;
            if ((state & 0b101) == 0b0) {
                return NodeCost.UNINITIALIZED;
            } else if (((state & 0b101) & ((state & 0b101) - 1)) == 0 /* is-single-active  */) {
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
            s[0] = "matchAll";
            if ((state & 0b1) != 0 /* is-active matchAll(VirtualFrame, DynamicObject, Object, JSToStringNode, ArraySpeciesConstructorNode, PropertyGetNode, JSToStringNode, PropertyGetNode, JSToLengthNode, PropertySetNode, CreateRegExpStringIteratorNode, IsJSObjectNode, ConditionProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                MatchAllData s1_ = this.matchAll_cache;
                if (s1_ != null) {
                    cached.add(Arrays.asList(s1_.toStringNodeForInput_, s1_.speciesConstructNode_, s1_.getFlagsNode_, s1_.toStringNodeForFlags_, s1_.getLastIndexNode_, s1_.toLengthNode_, s1_.setLastIndexNode_, s1_.createRegExpStringIteratorNode_, s1_.isObjectNode_, s1_.indexInIntRangeProf_));
                }
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "matchAll";
            if ((state & 0b100) != 0 /* is-active matchAll(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static JSRegExpMatchAllNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSRegExpMatchAllNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(JSRegExpMatchAllNode.class)
        private static final class MatchAllData extends Node {

            @Child JSToStringNode toStringNodeForInput_;
            @Child ArraySpeciesConstructorNode speciesConstructNode_;
            @Child PropertyGetNode getFlagsNode_;
            @Child JSToStringNode toStringNodeForFlags_;
            @Child PropertyGetNode getLastIndexNode_;
            @Child JSToLengthNode toLengthNode_;
            @Child PropertySetNode setLastIndexNode_;
            @Child CreateRegExpStringIteratorNode createRegExpStringIteratorNode_;
            @Child IsJSObjectNode isObjectNode_;
            @CompilationFinal ConditionProfile indexInIntRangeProf_;

            MatchAllData() {
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
    @GeneratedBy(RegExpFlagsGetterNode.class)
    public static final class RegExpFlagsGetterNodeGen extends RegExpFlagsGetterNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_;
        @Child private IsJSObjectNode object_isObjectNode_;

        private RegExpFlagsGetterNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        private boolean fallbackGuard_(int state, Object arguments0Value) {
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((((state & 0b10)) == 0 /* is-not-active Guard[(isObjectNode.executeBoolean(rx))] */ || (this.object_isObjectNode_.executeBoolean(arguments0Value_)))) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state & 0b1) != 0 /* is-active doObject(DynamicObject, IsJSObjectNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((this.object_isObjectNode_.executeBoolean(arguments0Value__))) {
                    return doObject(arguments0Value__, this.object_isObjectNode_);
                }
            }
            if ((state & 0b100) != 0 /* is-active doNotObject(Object) */) {
                if (fallbackGuard_(state, arguments0Value_)) {
                    return doNotObject(arguments0Value_);
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
                    boolean Object_duplicateFound_ = false;
                    if ((state & 0b1) != 0 /* is-active doObject(DynamicObject, IsJSObjectNode) */) {
                        if ((this.object_isObjectNode_.executeBoolean(arguments0Value_))) {
                            Object_duplicateFound_ = true;
                        }
                    }
                    if (!Object_duplicateFound_) {
                        {
                            if (((state & 0b10)) == 0 /* is-not-active Guard[(isObjectNode.executeBoolean(rx))] */) {
                                this.object_isObjectNode_ = super.insert((IsJSObjectNode.create()));
                                this.state_ = state = state | 0b10 /* add-active Guard[(isObjectNode.executeBoolean(rx))] */;
                            }
                            if ((this.object_isObjectNode_.executeBoolean(arguments0Value_)) && ((state & 0b1)) == 0 /* is-not-active doObject(DynamicObject, IsJSObjectNode) */) {
                                this.object_isObjectNode_ = super.insert((IsJSObjectNode.create()));
                                this.state_ = state = state | 0b1 /* add-active doObject(DynamicObject, IsJSObjectNode) */;
                                Object_duplicateFound_ = true;
                            }
                        }
                    }
                    if (Object_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return doObject(arguments0Value_, this.object_isObjectNode_);
                    }
                }
                this.state_ = state = state | 0b100 /* add-active doNotObject(Object) */;
                lock.unlock();
                hasLock = false;
                return doNotObject(arguments0Value);
            } finally {
                if (hasLock) {
                    lock.unlock();
                }
            }
        }

        @Override
        public NodeCost getCost() {
            int state = state_;
            if ((state & 0b101) == 0b0) {
                return NodeCost.UNINITIALIZED;
            } else if (((state & 0b101) & ((state & 0b101) - 1)) == 0 /* is-single-active  */) {
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
            if ((state & 0b1) != 0 /* is-active doObject(DynamicObject, IsJSObjectNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.object_isObjectNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doNotObject";
            if ((state & 0b100) != 0 /* is-active doNotObject(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static RegExpFlagsGetterNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new RegExpFlagsGetterNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(CompiledRegexFlagPropertyAccessor.class)
    static final class CompiledRegexFlagPropertyAccessorNodeGen extends CompiledRegexFlagPropertyAccessor implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private int state_;

        private CompiledRegexFlagPropertyAccessorNodeGen(JSContext context, JSBuiltin builtin, String flagName, JavaScriptNode[] arguments) {
            super(context, builtin, flagName);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        private boolean fallbackGuard_(Object arguments0Value) {
            if (JSTypes.isDynamicObject(arguments0Value)) {
                {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSRegExp(arguments0Value_))) {
                        return false;
                    }
                }
                {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((isRegExpPrototype(arguments0Value_))) {
                        return false;
                    }
                }
            }
            return true;
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state & 0b11) != 0 /* is-active doDynamicObject(DynamicObject) || doPrototype(DynamicObject) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state & 0b1) != 0 /* is-active doDynamicObject(DynamicObject) */) {
                    if ((JSGuards.isJSRegExp(arguments0Value__))) {
                        return doDynamicObject(arguments0Value__);
                    }
                }
                if ((state & 0b10) != 0 /* is-active doPrototype(DynamicObject) */) {
                    if ((isRegExpPrototype(arguments0Value__))) {
                        return doPrototype(arguments0Value__);
                    }
                }
            }
            if ((state & 0b100) != 0 /* is-active doObject(Object) */) {
                if (fallbackGuard_(arguments0Value_)) {
                    return doObject(arguments0Value_);
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
                if ((JSGuards.isJSRegExp(arguments0Value_))) {
                    this.state_ = state = state | 0b1 /* add-active doDynamicObject(DynamicObject) */;
                    return doDynamicObject(arguments0Value_);
                }
                if ((isRegExpPrototype(arguments0Value_))) {
                    this.state_ = state = state | 0b10 /* add-active doPrototype(DynamicObject) */;
                    return doPrototype(arguments0Value_);
                }
            }
            this.state_ = state = state | 0b100 /* add-active doObject(Object) */;
            return doObject(arguments0Value);
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
            s[0] = "doDynamicObject";
            if ((state & 0b1) != 0 /* is-active doDynamicObject(DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doPrototype";
            if ((state & 0b10) != 0 /* is-active doPrototype(DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "doObject";
            if ((state & 0b100) != 0 /* is-active doObject(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static CompiledRegexFlagPropertyAccessor create(JSContext context, JSBuiltin builtin, String flagName, JavaScriptNode[] arguments) {
            return new CompiledRegexFlagPropertyAccessorNodeGen(context, builtin, flagName, arguments);
        }

    }
    @GeneratedBy(CompiledRegexPatternAccessor.class)
    static final class CompiledRegexPatternAccessorNodeGen extends CompiledRegexPatternAccessor implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private int state_;

        private CompiledRegexPatternAccessorNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        private boolean fallbackGuard_(Object arguments0Value) {
            if (JSTypes.isDynamicObject(arguments0Value)) {
                {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSRegExp(arguments0Value_))) {
                        return false;
                    }
                }
                {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((isRegExpPrototype(arguments0Value_))) {
                        return false;
                    }
                }
            }
            return true;
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state & 0b11) != 0 /* is-active doDynamicObject(DynamicObject) || doPrototype(DynamicObject) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state & 0b1) != 0 /* is-active doDynamicObject(DynamicObject) */) {
                    if ((JSGuards.isJSRegExp(arguments0Value__))) {
                        return doDynamicObject(arguments0Value__);
                    }
                }
                if ((state & 0b10) != 0 /* is-active doPrototype(DynamicObject) */) {
                    if ((isRegExpPrototype(arguments0Value__))) {
                        return doPrototype(arguments0Value__);
                    }
                }
            }
            if ((state & 0b100) != 0 /* is-active doObject(Object) */) {
                if (fallbackGuard_(arguments0Value_)) {
                    return doObject(arguments0Value_);
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
                if ((JSGuards.isJSRegExp(arguments0Value_))) {
                    this.state_ = state = state | 0b1 /* add-active doDynamicObject(DynamicObject) */;
                    return doDynamicObject(arguments0Value_);
                }
                if ((isRegExpPrototype(arguments0Value_))) {
                    this.state_ = state = state | 0b10 /* add-active doPrototype(DynamicObject) */;
                    return doPrototype(arguments0Value_);
                }
            }
            this.state_ = state = state | 0b100 /* add-active doObject(Object) */;
            return doObject(arguments0Value);
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
            s[0] = "doDynamicObject";
            if ((state & 0b1) != 0 /* is-active doDynamicObject(DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doPrototype";
            if ((state & 0b10) != 0 /* is-active doPrototype(DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "doObject";
            if ((state & 0b100) != 0 /* is-active doObject(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static CompiledRegexPatternAccessor create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new CompiledRegexPatternAccessorNodeGen(context, builtin, arguments);
        }

    }
}
