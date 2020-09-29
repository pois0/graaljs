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
import com.oracle.truffle.js.builtins.GeneratorPrototypeBuiltins.GeneratorResumeNode;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.objects.Completion.Type;

@GeneratedBy(GeneratorPrototypeBuiltins.class)
public final class GeneratorPrototypeBuiltinsFactory {

    @GeneratedBy(GeneratorResumeNode.class)
    public static final class GeneratorResumeNodeGen extends GeneratorResumeNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private int state_;

        private GeneratorResumeNodeGen(JSContext context, JSBuiltin builtin, Type resumeType, JavaScriptNode[] arguments) {
            super(context, builtin, resumeType);
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
            if (state != 0 /* is-active resume(DynamicObject, Object) || resume(Object, Object) */) {
                if ((state & 0b1) != 0 /* is-active resume(DynamicObject, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((JSGuards.isJSObject(arguments0Value__))) {
                        return resume(arguments0Value__, arguments1Value_);
                    }
                }
                if ((state & 0b10) != 0 /* is-active resume(Object, Object) */) {
                    if ((!(JSGuards.isJSObject(arguments0Value_)))) {
                        return resume(arguments0Value_, arguments1Value_);
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
                if ((JSGuards.isJSObject(arguments0Value_))) {
                    this.state_ = state = state | 0b1 /* add-active resume(DynamicObject, Object) */;
                    return resume(arguments0Value_, arguments1Value);
                }
            }
            if ((!(JSGuards.isJSObject(arguments0Value)))) {
                this.state_ = state = state | 0b10 /* add-active resume(Object, Object) */;
                return resume(arguments0Value, arguments1Value);
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
            s[0] = "resume";
            if ((state & 0b1) != 0 /* is-active resume(DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "resume";
            if ((state & 0b10) != 0 /* is-active resume(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static GeneratorResumeNode create(JSContext context, JSBuiltin builtin, Type resumeType, JavaScriptNode[] arguments) {
            return new GeneratorResumeNodeGen(context, builtin, resumeType, arguments);
        }

    }
}
