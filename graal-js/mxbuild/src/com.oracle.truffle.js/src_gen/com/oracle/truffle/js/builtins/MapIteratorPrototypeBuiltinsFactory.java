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
import com.oracle.truffle.js.builtins.MapIteratorPrototypeBuiltins.MapIteratorNextNode;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSContext;

@GeneratedBy(MapIteratorPrototypeBuiltins.class)
public final class MapIteratorPrototypeBuiltinsFactory {

    @GeneratedBy(MapIteratorNextNode.class)
    public static final class MapIteratorNextNodeGen extends MapIteratorNextNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private int state_;

        private MapIteratorNextNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        private boolean fallbackGuard_(Object arguments0Value) {
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((isMapIterator(arguments0Value_))) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state & 0b1) != 0 /* is-active doMapIterator(VirtualFrame, DynamicObject) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((isMapIterator(arguments0Value__))) {
                    return doMapIterator(frameValue, arguments0Value__);
                }
            }
            if ((state & 0b10) != 0 /* is-active doIncompatibleReceiver(Object) */) {
                if (fallbackGuard_(arguments0Value_)) {
                    return doIncompatibleReceiver(arguments0Value_);
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
                if ((isMapIterator(arguments0Value_))) {
                    this.state_ = state = state | 0b1 /* add-active doMapIterator(VirtualFrame, DynamicObject) */;
                    return doMapIterator(frameValue, arguments0Value_);
                }
            }
            this.state_ = state = state | 0b10 /* add-active doIncompatibleReceiver(Object) */;
            return doIncompatibleReceiver(arguments0Value);
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
            s[0] = "doMapIterator";
            if ((state & 0b1) != 0 /* is-active doMapIterator(VirtualFrame, DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doIncompatibleReceiver";
            if ((state & 0b10) != 0 /* is-active doIncompatibleReceiver(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static MapIteratorNextNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new MapIteratorNextNodeGen(context, builtin, arguments);
        }

    }
}
