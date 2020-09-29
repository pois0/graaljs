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
import com.oracle.truffle.js.builtins.DataViewPrototypeBuiltins.DataViewGetNode;
import com.oracle.truffle.js.builtins.DataViewPrototypeBuiltins.DataViewSetNode;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.builtins.JSDataView;

@GeneratedBy(DataViewPrototypeBuiltins.class)
public final class DataViewPrototypeBuiltinsFactory {

    @GeneratedBy(DataViewGetNode.class)
    public static final class DataViewGetNodeGen extends DataViewGetNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private int state_;

        private DataViewGetNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state != 0 /* is-active doDataView(DynamicObject, Object, Object) || doIncompatibleReceiver(Object, Object, Object) */) {
                if ((state & 0b1) != 0 /* is-active doDataView(DynamicObject, Object, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((JSDataView.isJSDataView(arguments0Value__))) {
                        return doDataView(arguments0Value__, arguments1Value_, arguments2Value_);
                    }
                }
                if ((state & 0b10) != 0 /* is-active doIncompatibleReceiver(Object, Object, Object) */) {
                    if ((!(JSDataView.isJSDataView(arguments0Value_)))) {
                        return doIncompatibleReceiver(arguments0Value_, arguments1Value_, arguments2Value_);
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
                if ((JSDataView.isJSDataView(arguments0Value_))) {
                    this.state_ = state = state | 0b1 /* add-active doDataView(DynamicObject, Object, Object) */;
                    return doDataView(arguments0Value_, arguments1Value, arguments2Value);
                }
            }
            if ((!(JSDataView.isJSDataView(arguments0Value)))) {
                this.state_ = state = state | 0b10 /* add-active doIncompatibleReceiver(Object, Object, Object) */;
                return doIncompatibleReceiver(arguments0Value, arguments1Value, arguments2Value);
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
            s[0] = "doDataView";
            if ((state & 0b1) != 0 /* is-active doDataView(DynamicObject, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doIncompatibleReceiver";
            if ((state & 0b10) != 0 /* is-active doIncompatibleReceiver(Object, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static DataViewGetNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new DataViewGetNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(DataViewSetNode.class)
    public static final class DataViewSetNodeGen extends DataViewSetNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @Child private JavaScriptNode arguments3_;
        @CompilationFinal private int state_;

        private DataViewSetNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state != 0 /* is-active doDataView(DynamicObject, Object, Object, Object) || doIncompatibleReceiver(Object, Object, Object, Object) */) {
                if ((state & 0b1) != 0 /* is-active doDataView(DynamicObject, Object, Object, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((JSDataView.isJSDataView(arguments0Value__))) {
                        return doDataView(arguments0Value__, arguments1Value_, arguments2Value_, arguments3Value_);
                    }
                }
                if ((state & 0b10) != 0 /* is-active doIncompatibleReceiver(Object, Object, Object, Object) */) {
                    if ((!(JSDataView.isJSDataView(arguments0Value_)))) {
                        return doIncompatibleReceiver(arguments0Value_, arguments1Value_, arguments2Value_, arguments3Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_, arguments3Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private Object executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value, Object arguments3Value) {
            int state = state_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((JSDataView.isJSDataView(arguments0Value_))) {
                    this.state_ = state = state | 0b1 /* add-active doDataView(DynamicObject, Object, Object, Object) */;
                    return doDataView(arguments0Value_, arguments1Value, arguments2Value, arguments3Value);
                }
            }
            if ((!(JSDataView.isJSDataView(arguments0Value)))) {
                this.state_ = state = state | 0b10 /* add-active doIncompatibleReceiver(Object, Object, Object, Object) */;
                return doIncompatibleReceiver(arguments0Value, arguments1Value, arguments2Value, arguments3Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_, this.arguments2_, this.arguments3_}, arguments0Value, arguments1Value, arguments2Value, arguments3Value);
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
            s[0] = "doDataView";
            if ((state & 0b1) != 0 /* is-active doDataView(DynamicObject, Object, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doIncompatibleReceiver";
            if ((state & 0b10) != 0 /* is-active doIncompatibleReceiver(Object, Object, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static DataViewSetNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new DataViewSetNodeGen(context, builtin, arguments);
        }

    }
}
