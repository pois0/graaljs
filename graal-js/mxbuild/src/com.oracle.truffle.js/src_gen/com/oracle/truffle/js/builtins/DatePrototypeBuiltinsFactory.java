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
import com.oracle.truffle.js.builtins.DatePrototypeBuiltins.JSDateGetDateNode;
import com.oracle.truffle.js.builtins.DatePrototypeBuiltins.JSDateGetDayNode;
import com.oracle.truffle.js.builtins.DatePrototypeBuiltins.JSDateGetFullYearNode;
import com.oracle.truffle.js.builtins.DatePrototypeBuiltins.JSDateGetHoursNode;
import com.oracle.truffle.js.builtins.DatePrototypeBuiltins.JSDateGetMillisecondsNode;
import com.oracle.truffle.js.builtins.DatePrototypeBuiltins.JSDateGetMinutesNode;
import com.oracle.truffle.js.builtins.DatePrototypeBuiltins.JSDateGetMonthNode;
import com.oracle.truffle.js.builtins.DatePrototypeBuiltins.JSDateGetSecondsNode;
import com.oracle.truffle.js.builtins.DatePrototypeBuiltins.JSDateGetTimezoneOffsetNode;
import com.oracle.truffle.js.builtins.DatePrototypeBuiltins.JSDateGetYearNode;
import com.oracle.truffle.js.builtins.DatePrototypeBuiltins.JSDateSetDateNode;
import com.oracle.truffle.js.builtins.DatePrototypeBuiltins.JSDateSetFullYearNode;
import com.oracle.truffle.js.builtins.DatePrototypeBuiltins.JSDateSetHoursNode;
import com.oracle.truffle.js.builtins.DatePrototypeBuiltins.JSDateSetMillisecondsNode;
import com.oracle.truffle.js.builtins.DatePrototypeBuiltins.JSDateSetMinutesNode;
import com.oracle.truffle.js.builtins.DatePrototypeBuiltins.JSDateSetMonthNode;
import com.oracle.truffle.js.builtins.DatePrototypeBuiltins.JSDateSetSecondsNode;
import com.oracle.truffle.js.builtins.DatePrototypeBuiltins.JSDateSetTimeNode;
import com.oracle.truffle.js.builtins.DatePrototypeBuiltins.JSDateSetYearNode;
import com.oracle.truffle.js.builtins.DatePrototypeBuiltins.JSDateToDateStringNode;
import com.oracle.truffle.js.builtins.DatePrototypeBuiltins.JSDateToISOStringNode;
import com.oracle.truffle.js.builtins.DatePrototypeBuiltins.JSDateToJSONNode;
import com.oracle.truffle.js.builtins.DatePrototypeBuiltins.JSDateToLocaleDateStringIntlNode;
import com.oracle.truffle.js.builtins.DatePrototypeBuiltins.JSDateToLocaleDateStringNode;
import com.oracle.truffle.js.builtins.DatePrototypeBuiltins.JSDateToLocaleTimeStringIntlNode;
import com.oracle.truffle.js.builtins.DatePrototypeBuiltins.JSDateToLocaleTimeStringNode;
import com.oracle.truffle.js.builtins.DatePrototypeBuiltins.JSDateToPrimitiveNode;
import com.oracle.truffle.js.builtins.DatePrototypeBuiltins.JSDateToStringIntlNode;
import com.oracle.truffle.js.builtins.DatePrototypeBuiltins.JSDateToStringNode;
import com.oracle.truffle.js.builtins.DatePrototypeBuiltins.JSDateToTimeStringNode;
import com.oracle.truffle.js.builtins.DatePrototypeBuiltins.JSDateValueOfNode;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSContext;

@GeneratedBy(DatePrototypeBuiltins.class)
public final class DatePrototypeBuiltinsFactory {

    @GeneratedBy(JSDateValueOfNode.class)
    public static final class JSDateValueOfNodeGen extends JSDateValueOfNode implements Provider {

        @Child private JavaScriptNode arguments0_;

        private JSDateValueOfNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            return doOperation(arguments0Value_);
        }

        @Override
        public double executeDouble(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return doOperation(arguments0Value_);
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
            s[0] = "doOperation";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSDateValueOfNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSDateValueOfNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSDateToStringNode.class)
    public static final class JSDateToStringNodeGen extends JSDateToStringNode implements Provider {

        @Child private JavaScriptNode arguments0_;

        private JSDateToStringNodeGen(JSContext context, JSBuiltin builtin, boolean isUTC, JavaScriptNode[] arguments) {
            super(context, builtin, isUTC);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return doOperation(arguments0Value_);
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
            s[0] = "doOperation";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSDateToStringNode create(JSContext context, JSBuiltin builtin, boolean isUTC, JavaScriptNode[] arguments) {
            return new JSDateToStringNodeGen(context, builtin, isUTC, arguments);
        }

    }
    @GeneratedBy(JSDateToStringIntlNode.class)
    public static final class JSDateToStringIntlNodeGen extends JSDateToStringIntlNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;

        private JSDateToStringIntlNodeGen(JSContext context, JSBuiltin builtin, boolean isUTC, JavaScriptNode[] arguments) {
            super(context, builtin, isUTC);
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
            return doOperation(arguments0Value_, arguments1Value_, arguments2Value_);
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
            s[0] = "doOperation";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSDateToStringIntlNode create(JSContext context, JSBuiltin builtin, boolean isUTC, JavaScriptNode[] arguments) {
            return new JSDateToStringIntlNodeGen(context, builtin, isUTC, arguments);
        }

    }
    @GeneratedBy(JSDateToDateStringNode.class)
    public static final class JSDateToDateStringNodeGen extends JSDateToDateStringNode implements Provider {

        @Child private JavaScriptNode arguments0_;

        private JSDateToDateStringNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            return doOperation(arguments0Value_);
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
            s[0] = "doOperation";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSDateToDateStringNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSDateToDateStringNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSDateToTimeStringNode.class)
    public static final class JSDateToTimeStringNodeGen extends JSDateToTimeStringNode implements Provider {

        @Child private JavaScriptNode arguments0_;

        private JSDateToTimeStringNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            return doOperation(arguments0Value_);
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
            s[0] = "doOperation";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSDateToTimeStringNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSDateToTimeStringNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSDateToLocaleDateStringNode.class)
    public static final class JSDateToLocaleDateStringNodeGen extends JSDateToLocaleDateStringNode implements Provider {

        @Child private JavaScriptNode arguments0_;

        private JSDateToLocaleDateStringNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            return doOperation(arguments0Value_);
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
            s[0] = "doOperation";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSDateToLocaleDateStringNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSDateToLocaleDateStringNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSDateToLocaleDateStringIntlNode.class)
    public static final class JSDateToLocaleDateStringIntlNodeGen extends JSDateToLocaleDateStringIntlNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;

        private JSDateToLocaleDateStringIntlNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            return doOperation(arguments0Value_, arguments1Value_, arguments2Value_);
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
            s[0] = "doOperation";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSDateToLocaleDateStringIntlNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSDateToLocaleDateStringIntlNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSDateToLocaleTimeStringNode.class)
    public static final class JSDateToLocaleTimeStringNodeGen extends JSDateToLocaleTimeStringNode implements Provider {

        @Child private JavaScriptNode arguments0_;

        private JSDateToLocaleTimeStringNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            return doOperation(arguments0Value_);
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
            s[0] = "doOperation";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSDateToLocaleTimeStringNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSDateToLocaleTimeStringNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSDateToLocaleTimeStringIntlNode.class)
    public static final class JSDateToLocaleTimeStringIntlNodeGen extends JSDateToLocaleTimeStringIntlNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;

        private JSDateToLocaleTimeStringIntlNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            return doOperation(arguments0Value_, arguments1Value_, arguments2Value_);
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
            s[0] = "doOperation";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSDateToLocaleTimeStringIntlNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSDateToLocaleTimeStringIntlNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSDateToISOStringNode.class)
    public static final class JSDateToISOStringNodeGen extends JSDateToISOStringNode implements Provider {

        @Child private JavaScriptNode arguments0_;

        private JSDateToISOStringNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            return doOperation(arguments0Value_);
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
            s[0] = "doOperation";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSDateToISOStringNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSDateToISOStringNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSDateGetFullYearNode.class)
    public static final class JSDateGetFullYearNodeGen extends JSDateGetFullYearNode implements Provider {

        @Child private JavaScriptNode arguments0_;

        private JSDateGetFullYearNodeGen(JSContext context, JSBuiltin builtin, boolean isUTC, JavaScriptNode[] arguments) {
            super(context, builtin, isUTC);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return doOperation(arguments0Value_);
        }

        @Override
        public double executeDouble(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return doOperation(arguments0Value_);
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
            s[0] = "doOperation";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSDateGetFullYearNode create(JSContext context, JSBuiltin builtin, boolean isUTC, JavaScriptNode[] arguments) {
            return new JSDateGetFullYearNodeGen(context, builtin, isUTC, arguments);
        }

    }
    @GeneratedBy(JSDateGetYearNode.class)
    public static final class JSDateGetYearNodeGen extends JSDateGetYearNode implements Provider {

        @Child private JavaScriptNode arguments0_;

        private JSDateGetYearNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            return doOperation(arguments0Value_);
        }

        @Override
        public double executeDouble(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return doOperation(arguments0Value_);
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
            s[0] = "doOperation";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSDateGetYearNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSDateGetYearNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSDateGetMonthNode.class)
    public static final class JSDateGetMonthNodeGen extends JSDateGetMonthNode implements Provider {

        @Child private JavaScriptNode arguments0_;

        private JSDateGetMonthNodeGen(JSContext context, JSBuiltin builtin, boolean isUTC, JavaScriptNode[] arguments) {
            super(context, builtin, isUTC);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return doOperation(arguments0Value_);
        }

        @Override
        public double executeDouble(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return doOperation(arguments0Value_);
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
            s[0] = "doOperation";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSDateGetMonthNode create(JSContext context, JSBuiltin builtin, boolean isUTC, JavaScriptNode[] arguments) {
            return new JSDateGetMonthNodeGen(context, builtin, isUTC, arguments);
        }

    }
    @GeneratedBy(JSDateGetDateNode.class)
    public static final class JSDateGetDateNodeGen extends JSDateGetDateNode implements Provider {

        @Child private JavaScriptNode arguments0_;

        private JSDateGetDateNodeGen(JSContext context, JSBuiltin builtin, boolean isUTC, JavaScriptNode[] arguments) {
            super(context, builtin, isUTC);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return doOperation(arguments0Value_);
        }

        @Override
        public double executeDouble(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return doOperation(arguments0Value_);
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
            s[0] = "doOperation";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSDateGetDateNode create(JSContext context, JSBuiltin builtin, boolean isUTC, JavaScriptNode[] arguments) {
            return new JSDateGetDateNodeGen(context, builtin, isUTC, arguments);
        }

    }
    @GeneratedBy(JSDateGetDayNode.class)
    public static final class JSDateGetDayNodeGen extends JSDateGetDayNode implements Provider {

        @Child private JavaScriptNode arguments0_;

        private JSDateGetDayNodeGen(JSContext context, JSBuiltin builtin, boolean isUTC, JavaScriptNode[] arguments) {
            super(context, builtin, isUTC);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return doOperation(arguments0Value_);
        }

        @Override
        public double executeDouble(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return doOperation(arguments0Value_);
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
            s[0] = "doOperation";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSDateGetDayNode create(JSContext context, JSBuiltin builtin, boolean isUTC, JavaScriptNode[] arguments) {
            return new JSDateGetDayNodeGen(context, builtin, isUTC, arguments);
        }

    }
    @GeneratedBy(JSDateGetHoursNode.class)
    public static final class JSDateGetHoursNodeGen extends JSDateGetHoursNode implements Provider {

        @Child private JavaScriptNode arguments0_;

        private JSDateGetHoursNodeGen(JSContext context, JSBuiltin builtin, boolean isUTC, JavaScriptNode[] arguments) {
            super(context, builtin, isUTC);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return doOperation(arguments0Value_);
        }

        @Override
        public double executeDouble(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return doOperation(arguments0Value_);
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
            s[0] = "doOperation";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSDateGetHoursNode create(JSContext context, JSBuiltin builtin, boolean isUTC, JavaScriptNode[] arguments) {
            return new JSDateGetHoursNodeGen(context, builtin, isUTC, arguments);
        }

    }
    @GeneratedBy(JSDateGetMinutesNode.class)
    public static final class JSDateGetMinutesNodeGen extends JSDateGetMinutesNode implements Provider {

        @Child private JavaScriptNode arguments0_;

        private JSDateGetMinutesNodeGen(JSContext context, JSBuiltin builtin, boolean isUTC, JavaScriptNode[] arguments) {
            super(context, builtin, isUTC);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return doOperation(arguments0Value_);
        }

        @Override
        public double executeDouble(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return doOperation(arguments0Value_);
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
            s[0] = "doOperation";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSDateGetMinutesNode create(JSContext context, JSBuiltin builtin, boolean isUTC, JavaScriptNode[] arguments) {
            return new JSDateGetMinutesNodeGen(context, builtin, isUTC, arguments);
        }

    }
    @GeneratedBy(JSDateGetSecondsNode.class)
    public static final class JSDateGetSecondsNodeGen extends JSDateGetSecondsNode implements Provider {

        @Child private JavaScriptNode arguments0_;

        private JSDateGetSecondsNodeGen(JSContext context, JSBuiltin builtin, boolean isUTC, JavaScriptNode[] arguments) {
            super(context, builtin, isUTC);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return doOperation(arguments0Value_);
        }

        @Override
        public double executeDouble(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return doOperation(arguments0Value_);
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
            s[0] = "doOperation";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSDateGetSecondsNode create(JSContext context, JSBuiltin builtin, boolean isUTC, JavaScriptNode[] arguments) {
            return new JSDateGetSecondsNodeGen(context, builtin, isUTC, arguments);
        }

    }
    @GeneratedBy(JSDateGetMillisecondsNode.class)
    public static final class JSDateGetMillisecondsNodeGen extends JSDateGetMillisecondsNode implements Provider {

        @Child private JavaScriptNode arguments0_;

        private JSDateGetMillisecondsNodeGen(JSContext context, JSBuiltin builtin, boolean isUTC, JavaScriptNode[] arguments) {
            super(context, builtin, isUTC);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return doOperation(arguments0Value_);
        }

        @Override
        public double executeDouble(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return doOperation(arguments0Value_);
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
            s[0] = "doOperation";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSDateGetMillisecondsNode create(JSContext context, JSBuiltin builtin, boolean isUTC, JavaScriptNode[] arguments) {
            return new JSDateGetMillisecondsNodeGen(context, builtin, isUTC, arguments);
        }

    }
    @GeneratedBy(JSDateSetTimeNode.class)
    public static final class JSDateSetTimeNodeGen extends JSDateSetTimeNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;

        private JSDateSetTimeNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            return doOperation(arguments0Value_, arguments1Value_);
        }

        @Override
        public double executeDouble(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            return doOperation(arguments0Value_, arguments1Value_);
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
            s[0] = "doOperation";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSDateSetTimeNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSDateSetTimeNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSDateSetDateNode.class)
    public static final class JSDateSetDateNodeGen extends JSDateSetDateNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;

        private JSDateSetDateNodeGen(JSContext context, JSBuiltin builtin, boolean isUTC, JavaScriptNode[] arguments) {
            super(context, builtin, isUTC);
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
            return doOperation(arguments0Value_, arguments1Value_);
        }

        @Override
        public double executeDouble(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            return doOperation(arguments0Value_, arguments1Value_);
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
            s[0] = "doOperation";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSDateSetDateNode create(JSContext context, JSBuiltin builtin, boolean isUTC, JavaScriptNode[] arguments) {
            return new JSDateSetDateNodeGen(context, builtin, isUTC, arguments);
        }

    }
    @GeneratedBy(JSDateSetYearNode.class)
    public static final class JSDateSetYearNodeGen extends JSDateSetYearNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;

        private JSDateSetYearNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            return setYear(arguments0Value_, arguments1Value_);
        }

        @Override
        public double executeDouble(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            return setYear(arguments0Value_, arguments1Value_);
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
            s[0] = "setYear";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSDateSetYearNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSDateSetYearNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSDateSetFullYearNode.class)
    public static final class JSDateSetFullYearNodeGen extends JSDateSetFullYearNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private int state_;

        private JSDateSetFullYearNodeGen(JSContext context, JSBuiltin builtin, boolean isUTC, JavaScriptNode[] arguments) {
            super(context, builtin, isUTC);
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
            if (state != 0 /* is-active setFullYear(Object, Object[]) */ && arguments1Value_ instanceof Object[]) {
                Object[] arguments1Value__ = (Object[]) arguments1Value_;
                return setFullYear(arguments0Value_, arguments1Value__);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public double executeDouble(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if (state != 0 /* is-active setFullYear(Object, Object[]) */ && arguments1Value_ instanceof Object[]) {
                Object[] arguments1Value__ = (Object[]) arguments1Value_;
                return setFullYear(arguments0Value_, arguments1Value__);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            executeDouble(frameValue);
            return;
        }

        private double executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            int state = state_;
            if (arguments1Value instanceof Object[]) {
                Object[] arguments1Value_ = (Object[]) arguments1Value;
                this.state_ = state = state | 0b1 /* add-active setFullYear(Object, Object[]) */;
                return setFullYear(arguments0Value, arguments1Value_);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_}, arguments0Value, arguments1Value);
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
            s[0] = "setFullYear";
            if (state != 0 /* is-active setFullYear(Object, Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static JSDateSetFullYearNode create(JSContext context, JSBuiltin builtin, boolean isUTC, JavaScriptNode[] arguments) {
            return new JSDateSetFullYearNodeGen(context, builtin, isUTC, arguments);
        }

    }
    @GeneratedBy(JSDateSetMonthNode.class)
    public static final class JSDateSetMonthNodeGen extends JSDateSetMonthNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private int state_;

        private JSDateSetMonthNodeGen(JSContext context, JSBuiltin builtin, boolean isUTC, JavaScriptNode[] arguments) {
            super(context, builtin, isUTC);
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
            if (state != 0 /* is-active setMonth(Object, Object[]) */ && arguments1Value_ instanceof Object[]) {
                Object[] arguments1Value__ = (Object[]) arguments1Value_;
                return setMonth(arguments0Value_, arguments1Value__);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public double executeDouble(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if (state != 0 /* is-active setMonth(Object, Object[]) */ && arguments1Value_ instanceof Object[]) {
                Object[] arguments1Value__ = (Object[]) arguments1Value_;
                return setMonth(arguments0Value_, arguments1Value__);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            executeDouble(frameValue);
            return;
        }

        private double executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            int state = state_;
            if (arguments1Value instanceof Object[]) {
                Object[] arguments1Value_ = (Object[]) arguments1Value;
                this.state_ = state = state | 0b1 /* add-active setMonth(Object, Object[]) */;
                return setMonth(arguments0Value, arguments1Value_);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_}, arguments0Value, arguments1Value);
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
            s[0] = "setMonth";
            if (state != 0 /* is-active setMonth(Object, Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static JSDateSetMonthNode create(JSContext context, JSBuiltin builtin, boolean isUTC, JavaScriptNode[] arguments) {
            return new JSDateSetMonthNodeGen(context, builtin, isUTC, arguments);
        }

    }
    @GeneratedBy(JSDateSetHoursNode.class)
    public static final class JSDateSetHoursNodeGen extends JSDateSetHoursNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private int state_;

        private JSDateSetHoursNodeGen(JSContext context, JSBuiltin builtin, boolean isUTC, JavaScriptNode[] arguments) {
            super(context, builtin, isUTC);
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
            if (state != 0 /* is-active setHours(Object, Object[]) */ && arguments1Value_ instanceof Object[]) {
                Object[] arguments1Value__ = (Object[]) arguments1Value_;
                return setHours(arguments0Value_, arguments1Value__);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public double executeDouble(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if (state != 0 /* is-active setHours(Object, Object[]) */ && arguments1Value_ instanceof Object[]) {
                Object[] arguments1Value__ = (Object[]) arguments1Value_;
                return setHours(arguments0Value_, arguments1Value__);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            executeDouble(frameValue);
            return;
        }

        private double executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            int state = state_;
            if (arguments1Value instanceof Object[]) {
                Object[] arguments1Value_ = (Object[]) arguments1Value;
                this.state_ = state = state | 0b1 /* add-active setHours(Object, Object[]) */;
                return setHours(arguments0Value, arguments1Value_);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_}, arguments0Value, arguments1Value);
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
            s[0] = "setHours";
            if (state != 0 /* is-active setHours(Object, Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static JSDateSetHoursNode create(JSContext context, JSBuiltin builtin, boolean isUTC, JavaScriptNode[] arguments) {
            return new JSDateSetHoursNodeGen(context, builtin, isUTC, arguments);
        }

    }
    @GeneratedBy(JSDateSetMinutesNode.class)
    public static final class JSDateSetMinutesNodeGen extends JSDateSetMinutesNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private int state_;

        private JSDateSetMinutesNodeGen(JSContext context, JSBuiltin builtin, boolean isUTC, JavaScriptNode[] arguments) {
            super(context, builtin, isUTC);
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
            if (state != 0 /* is-active doOperation(Object, Object[]) */ && arguments1Value_ instanceof Object[]) {
                Object[] arguments1Value__ = (Object[]) arguments1Value_;
                return doOperation(arguments0Value_, arguments1Value__);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public double executeDouble(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if (state != 0 /* is-active doOperation(Object, Object[]) */ && arguments1Value_ instanceof Object[]) {
                Object[] arguments1Value__ = (Object[]) arguments1Value_;
                return doOperation(arguments0Value_, arguments1Value__);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            executeDouble(frameValue);
            return;
        }

        private double executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            int state = state_;
            if (arguments1Value instanceof Object[]) {
                Object[] arguments1Value_ = (Object[]) arguments1Value;
                this.state_ = state = state | 0b1 /* add-active doOperation(Object, Object[]) */;
                return doOperation(arguments0Value, arguments1Value_);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_}, arguments0Value, arguments1Value);
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
            s[0] = "doOperation";
            if (state != 0 /* is-active doOperation(Object, Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static JSDateSetMinutesNode create(JSContext context, JSBuiltin builtin, boolean isUTC, JavaScriptNode[] arguments) {
            return new JSDateSetMinutesNodeGen(context, builtin, isUTC, arguments);
        }

    }
    @GeneratedBy(JSDateSetSecondsNode.class)
    public static final class JSDateSetSecondsNodeGen extends JSDateSetSecondsNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private int state_;

        private JSDateSetSecondsNodeGen(JSContext context, JSBuiltin builtin, boolean isUTC, JavaScriptNode[] arguments) {
            super(context, builtin, isUTC);
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
            if (state != 0 /* is-active setSeconds(Object, Object[]) */ && arguments1Value_ instanceof Object[]) {
                Object[] arguments1Value__ = (Object[]) arguments1Value_;
                return setSeconds(arguments0Value_, arguments1Value__);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public double executeDouble(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if (state != 0 /* is-active setSeconds(Object, Object[]) */ && arguments1Value_ instanceof Object[]) {
                Object[] arguments1Value__ = (Object[]) arguments1Value_;
                return setSeconds(arguments0Value_, arguments1Value__);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            executeDouble(frameValue);
            return;
        }

        private double executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            int state = state_;
            if (arguments1Value instanceof Object[]) {
                Object[] arguments1Value_ = (Object[]) arguments1Value;
                this.state_ = state = state | 0b1 /* add-active setSeconds(Object, Object[]) */;
                return setSeconds(arguments0Value, arguments1Value_);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_}, arguments0Value, arguments1Value);
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
            s[0] = "setSeconds";
            if (state != 0 /* is-active setSeconds(Object, Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static JSDateSetSecondsNode create(JSContext context, JSBuiltin builtin, boolean isUTC, JavaScriptNode[] arguments) {
            return new JSDateSetSecondsNodeGen(context, builtin, isUTC, arguments);
        }

    }
    @GeneratedBy(JSDateSetMillisecondsNode.class)
    public static final class JSDateSetMillisecondsNodeGen extends JSDateSetMillisecondsNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;

        private JSDateSetMillisecondsNodeGen(JSContext context, JSBuiltin builtin, boolean isUTC, JavaScriptNode[] arguments) {
            super(context, builtin, isUTC);
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
            return setMilliseconds(arguments0Value_, arguments1Value_);
        }

        @Override
        public double executeDouble(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            return setMilliseconds(arguments0Value_, arguments1Value_);
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
            s[0] = "setMilliseconds";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSDateSetMillisecondsNode create(JSContext context, JSBuiltin builtin, boolean isUTC, JavaScriptNode[] arguments) {
            return new JSDateSetMillisecondsNodeGen(context, builtin, isUTC, arguments);
        }

    }
    @GeneratedBy(JSDateGetTimezoneOffsetNode.class)
    public static final class JSDateGetTimezoneOffsetNodeGen extends JSDateGetTimezoneOffsetNode implements Provider {

        @Child private JavaScriptNode arguments0_;

        private JSDateGetTimezoneOffsetNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            return getTimezoneOffset(arguments0Value_);
        }

        @Override
        public double executeDouble(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return getTimezoneOffset(arguments0Value_);
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
            s[0] = "getTimezoneOffset";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSDateGetTimezoneOffsetNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSDateGetTimezoneOffsetNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSDateToJSONNode.class)
    public static final class JSDateToJSONNodeGen extends JSDateToJSONNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;

        private JSDateToJSONNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            return toJSON(arguments0Value_, arguments1Value_);
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
            s[0] = "toJSON";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSDateToJSONNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSDateToJSONNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSDateToPrimitiveNode.class)
    public static final class JSDateToPrimitiveNodeGen extends JSDateToPrimitiveNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;

        private JSDateToPrimitiveNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            return toPrimitive(arguments0Value_, arguments1Value_);
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

        public static JSDateToPrimitiveNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSDateToPrimitiveNodeGen(context, builtin, arguments);
        }

    }
}
