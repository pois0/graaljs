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
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.EncapsulatingNodeReference;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.builtins.ReflectBuiltins.ReflectApplyNode;
import com.oracle.truffle.js.builtins.ReflectBuiltins.ReflectConstructNode;
import com.oracle.truffle.js.builtins.ReflectBuiltins.ReflectDefinePropertyNode;
import com.oracle.truffle.js.builtins.ReflectBuiltins.ReflectDeletePropertyNode;
import com.oracle.truffle.js.builtins.ReflectBuiltins.ReflectGetNode;
import com.oracle.truffle.js.builtins.ReflectBuiltins.ReflectGetOwnPropertyDescriptorNode;
import com.oracle.truffle.js.builtins.ReflectBuiltins.ReflectGetPrototypeOfNode;
import com.oracle.truffle.js.builtins.ReflectBuiltins.ReflectHasNode;
import com.oracle.truffle.js.builtins.ReflectBuiltins.ReflectIsExtensibleNode;
import com.oracle.truffle.js.builtins.ReflectBuiltins.ReflectOwnKeysNode;
import com.oracle.truffle.js.builtins.ReflectBuiltins.ReflectPreventExtensionsNode;
import com.oracle.truffle.js.builtins.ReflectBuiltins.ReflectSetNode;
import com.oracle.truffle.js.builtins.ReflectBuiltins.ReflectSetPrototypeOfNode;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.access.FromPropertyDescriptorNode;
import com.oracle.truffle.js.nodes.access.IsExtensibleNode;
import com.oracle.truffle.js.nodes.access.JSGetOwnPropertyNode;
import com.oracle.truffle.js.nodes.access.ToPropertyDescriptorNode;
import com.oracle.truffle.js.nodes.cast.JSToPropertyKeyNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.nodes.interop.ExportValueNode;
import com.oracle.truffle.js.nodes.interop.ImportValueNode;
import com.oracle.truffle.js.nodes.unary.IsCallableNode;
import com.oracle.truffle.js.nodes.unary.IsConstructorNode;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.util.JSClassProfile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(ReflectBuiltins.class)
@SuppressWarnings("unused")
public final class ReflectBuiltinsFactory {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @GeneratedBy(ReflectApplyNode.class)
    public static final class ReflectApplyNodeGen extends ReflectApplyNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private volatile int state_;
        @CompilationFinal private volatile int exclude_;
        @Child private IsCallableNode isCallable;

        private ReflectApplyNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state != 0 /* is-active applyFunction(DynamicObject, Object, Object) || applyCallable(Object, Object, Object, IsCallableNode) || error(Object, Object, Object, IsCallableNode) */) {
                if ((state & 0b1) != 0 /* is-active applyFunction(DynamicObject, Object, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((JSGuards.isJSFunction(arguments0Value__))) {
                        return applyFunction(arguments0Value__, arguments1Value_, arguments2Value_);
                    }
                }
                if ((state & 0b110) != 0 /* is-active applyCallable(Object, Object, Object, IsCallableNode) || error(Object, Object, Object, IsCallableNode) */) {
                    if ((state & 0b10) != 0 /* is-active applyCallable(Object, Object, Object, IsCallableNode) */) {
                        if ((this.isCallable.executeBoolean(arguments0Value_))) {
                            return applyCallable(arguments0Value_, arguments1Value_, arguments2Value_, this.isCallable);
                        }
                    }
                    if ((state & 0b100) != 0 /* is-active error(Object, Object, Object, IsCallableNode) */) {
                        if ((!(this.isCallable.executeBoolean(arguments0Value_)))) {
                            return ReflectApplyNode.error(arguments0Value_, arguments1Value_, arguments2Value_, this.isCallable);
                        }
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
                if ((exclude) == 0 /* is-not-excluded applyFunction(DynamicObject, Object, Object) */ && JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSFunction(arguments0Value_))) {
                        this.state_ = state = state | 0b1 /* add-active applyFunction(DynamicObject, Object, Object) */;
                        lock.unlock();
                        hasLock = false;
                        return applyFunction(arguments0Value_, arguments1Value, arguments2Value);
                    }
                }
                boolean ApplyCallable_duplicateFound_ = false;
                if ((state & 0b10) != 0 /* is-active applyCallable(Object, Object, Object, IsCallableNode) */) {
                    if ((this.isCallable.executeBoolean(arguments0Value))) {
                        ApplyCallable_duplicateFound_ = true;
                    }
                }
                if (!ApplyCallable_duplicateFound_) {
                    {
                        IsCallableNode applyCallable_isCallable__ = super.insert((IsCallableNode.create()));
                        if ((applyCallable_isCallable__.executeBoolean(arguments0Value)) && ((state & 0b10)) == 0 /* is-not-active applyCallable(Object, Object, Object, IsCallableNode) */) {
                            if (this.isCallable == null) {
                                this.isCallable = super.insert(applyCallable_isCallable__);
                            }
                            this.exclude_ = exclude = exclude | 0b1 /* add-excluded applyFunction(DynamicObject, Object, Object) */;
                            state = state & 0xfffffffe /* remove-active applyFunction(DynamicObject, Object, Object) */;
                            this.state_ = state = state | 0b10 /* add-active applyCallable(Object, Object, Object, IsCallableNode) */;
                            ApplyCallable_duplicateFound_ = true;
                        }
                    }
                }
                if (ApplyCallable_duplicateFound_) {
                    lock.unlock();
                    hasLock = false;
                    return applyCallable(arguments0Value, arguments1Value, arguments2Value, this.isCallable);
                }
                boolean Error_duplicateFound_ = false;
                if ((state & 0b100) != 0 /* is-active error(Object, Object, Object, IsCallableNode) */) {
                    if ((!(this.isCallable.executeBoolean(arguments0Value)))) {
                        Error_duplicateFound_ = true;
                    }
                }
                if (!Error_duplicateFound_) {
                    {
                        IsCallableNode error_isCallable__ = super.insert((IsCallableNode.create()));
                        if ((!(error_isCallable__.executeBoolean(arguments0Value))) && ((state & 0b100)) == 0 /* is-not-active error(Object, Object, Object, IsCallableNode) */) {
                            if (this.isCallable == null) {
                                this.isCallable = super.insert(error_isCallable__);
                            }
                            this.state_ = state = state | 0b100 /* add-active error(Object, Object, Object, IsCallableNode) */;
                            Error_duplicateFound_ = true;
                        }
                    }
                }
                if (Error_duplicateFound_) {
                    lock.unlock();
                    hasLock = false;
                    return ReflectApplyNode.error(arguments0Value, arguments1Value, arguments2Value, this.isCallable);
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
            Object[] data = new Object[4];
            Object[] s;
            data[0] = 0;
            int state = state_;
            int exclude = exclude_;
            s = new Object[3];
            s[0] = "applyFunction";
            if ((state & 0b1) != 0 /* is-active applyFunction(DynamicObject, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else if (exclude != 0 /* is-excluded applyFunction(DynamicObject, Object, Object) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "applyCallable";
            if ((state & 0b10) != 0 /* is-active applyCallable(Object, Object, Object, IsCallableNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.isCallable));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "error";
            if ((state & 0b100) != 0 /* is-active error(Object, Object, Object, IsCallableNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.isCallable));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static ReflectApplyNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ReflectApplyNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ReflectConstructNode.class)
    public static final class ReflectConstructNodeGen extends ReflectConstructNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private volatile int state_;
        @Child private IsConstructorNode isConstructorNode_;

        private ReflectConstructNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state != 0 /* is-active reflectConstruct(Object, Object, Object[], IsConstructorNode) */ && arguments2Value_ instanceof Object[]) {
                Object[] arguments2Value__ = (Object[]) arguments2Value_;
                return reflectConstruct(arguments0Value_, arguments1Value_, arguments2Value__, this.isConstructorNode_);
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
                if (arguments2Value instanceof Object[]) {
                    Object[] arguments2Value_ = (Object[]) arguments2Value;
                    this.isConstructorNode_ = super.insert((IsConstructorNode.create()));
                    this.state_ = state = state | 0b1 /* add-active reflectConstruct(Object, Object, Object[], IsConstructorNode) */;
                    lock.unlock();
                    hasLock = false;
                    return reflectConstruct(arguments0Value, arguments1Value, arguments2Value_, this.isConstructorNode_);
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
            s[0] = "reflectConstruct";
            if (state != 0 /* is-active reflectConstruct(Object, Object, Object[], IsConstructorNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.isConstructorNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static ReflectConstructNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ReflectConstructNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ReflectDefinePropertyNode.class)
    public static final class ReflectDefinePropertyNodeGen extends ReflectDefinePropertyNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private volatile int state_;
        @Child private JSToPropertyKeyNode toPropertyKeyNode_;
        @Child private ToPropertyDescriptorNode toPropertyDescriptorNode_;

        private ReflectDefinePropertyNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state != 0 /* is-active reflectDefineProperty(Object, Object, Object, JSToPropertyKeyNode, ToPropertyDescriptorNode) */) {
                return reflectDefineProperty(arguments0Value_, arguments1Value_, arguments2Value_, this.toPropertyKeyNode_, this.toPropertyDescriptorNode_);
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
            if (state != 0 /* is-active reflectDefineProperty(Object, Object, Object, JSToPropertyKeyNode, ToPropertyDescriptorNode) */) {
                return reflectDefineProperty(arguments0Value_, arguments1Value_, arguments2Value_, this.toPropertyKeyNode_, this.toPropertyDescriptorNode_);
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
                this.toPropertyKeyNode_ = super.insert((JSToPropertyKeyNode.create()));
                this.toPropertyDescriptorNode_ = super.insert((ToPropertyDescriptorNode.create(getContext())));
                this.state_ = state = state | 0b1 /* add-active reflectDefineProperty(Object, Object, Object, JSToPropertyKeyNode, ToPropertyDescriptorNode) */;
                lock.unlock();
                hasLock = false;
                return reflectDefineProperty(arguments0Value, arguments1Value, arguments2Value, this.toPropertyKeyNode_, this.toPropertyDescriptorNode_);
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
            s[0] = "reflectDefineProperty";
            if (state != 0 /* is-active reflectDefineProperty(Object, Object, Object, JSToPropertyKeyNode, ToPropertyDescriptorNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.toPropertyKeyNode_, this.toPropertyDescriptorNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static ReflectDefinePropertyNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ReflectDefinePropertyNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ReflectDeletePropertyNode.class)
    public static final class ReflectDeletePropertyNodeGen extends ReflectDeletePropertyNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_;
        @CompilationFinal private volatile int exclude_;
        @CompilationFinal private JSClassProfile object_classProfile_;
        @Child private ForeignObject0Data foreignObject0_cache;

        private ReflectDeletePropertyNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_};
        }

        @ExplodeLoop
        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if (state != 0 /* is-active doObject(DynamicObject, Object, JSClassProfile) || doForeignObject(Object, Object, InteropLibrary) || doForeignObject(Object, Object, InteropLibrary) || doNonObject(Object, Object) */) {
                if ((state & 0b1) != 0 /* is-active doObject(DynamicObject, Object, JSClassProfile) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((JSGuards.isJSObject(arguments0Value__))) {
                        return doObject(arguments0Value__, arguments1Value_, this.object_classProfile_);
                    }
                }
                if ((state & 0b1110) != 0 /* is-active doForeignObject(Object, Object, InteropLibrary) || doForeignObject(Object, Object, InteropLibrary) || doNonObject(Object, Object) */) {
                    if ((state & 0b10) != 0 /* is-active doForeignObject(Object, Object, InteropLibrary) */) {
                        ForeignObject0Data s2_ = this.foreignObject0_cache;
                        while (s2_ != null) {
                            if ((s2_.interop_.accepts(arguments0Value_)) && (JSGuards.isForeignObject(arguments0Value_))) {
                                return doForeignObject(arguments0Value_, arguments1Value_, s2_.interop_);
                            }
                            s2_ = s2_.next_;
                        }
                    }
                    if ((state & 0b100) != 0 /* is-active doForeignObject(Object, Object, InteropLibrary) */) {
                        if ((JSGuards.isForeignObject(arguments0Value_))) {
                            return this.foreignObject1Boundary(state, arguments0Value_, arguments1Value_);
                        }
                    }
                    if ((state & 0b1000) != 0 /* is-active doNonObject(Object, Object) */) {
                        if ((!(JSGuards.isJSObject(arguments0Value_))) && (!(JSGuards.isForeignObject(arguments0Value_)))) {
                            return doNonObject(arguments0Value_, arguments1Value_);
                        }
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @TruffleBoundary
        private Object foreignObject1Boundary(int state, Object arguments0Value_, Object arguments1Value_) {
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(this);
            try {
                {
                    InteropLibrary foreignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value_));
                    return doForeignObject(arguments0Value_, arguments1Value_, foreignObject1_interop__);
                }
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @ExplodeLoop
        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if (state != 0 /* is-active doObject(DynamicObject, Object, JSClassProfile) || doForeignObject(Object, Object, InteropLibrary) || doForeignObject(Object, Object, InteropLibrary) || doNonObject(Object, Object) */) {
                if ((state & 0b1) != 0 /* is-active doObject(DynamicObject, Object, JSClassProfile) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((JSGuards.isJSObject(arguments0Value__))) {
                        return doObject(arguments0Value__, arguments1Value_, this.object_classProfile_);
                    }
                }
                if ((state & 0b1110) != 0 /* is-active doForeignObject(Object, Object, InteropLibrary) || doForeignObject(Object, Object, InteropLibrary) || doNonObject(Object, Object) */) {
                    if ((state & 0b10) != 0 /* is-active doForeignObject(Object, Object, InteropLibrary) */) {
                        ForeignObject0Data s2_ = this.foreignObject0_cache;
                        while (s2_ != null) {
                            if ((s2_.interop_.accepts(arguments0Value_)) && (JSGuards.isForeignObject(arguments0Value_))) {
                                return doForeignObject(arguments0Value_, arguments1Value_, s2_.interop_);
                            }
                            s2_ = s2_.next_;
                        }
                    }
                    if ((state & 0b100) != 0 /* is-active doForeignObject(Object, Object, InteropLibrary) */) {
                        if ((JSGuards.isForeignObject(arguments0Value_))) {
                            return this.foreignObject1Boundary0(state, arguments0Value_, arguments1Value_);
                        }
                    }
                    if ((state & 0b1000) != 0 /* is-active doNonObject(Object, Object) */) {
                        if ((!(JSGuards.isJSObject(arguments0Value_))) && (!(JSGuards.isForeignObject(arguments0Value_)))) {
                            return doNonObject(arguments0Value_, arguments1Value_);
                        }
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @TruffleBoundary
        private boolean foreignObject1Boundary0(int state, Object arguments0Value_, Object arguments1Value_) {
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(this);
            try {
                {
                    InteropLibrary foreignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value_));
                    return doForeignObject(arguments0Value_, arguments1Value_, foreignObject1_interop__);
                }
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            executeBoolean(frameValue);
            return;
        }

        private boolean executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int exclude = exclude_;
            try {
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSObject(arguments0Value_))) {
                        this.object_classProfile_ = (JSClassProfile.create());
                        this.state_ = state = state | 0b1 /* add-active doObject(DynamicObject, Object, JSClassProfile) */;
                        lock.unlock();
                        hasLock = false;
                        return doObject(arguments0Value_, arguments1Value, this.object_classProfile_);
                    }
                }
                if ((exclude) == 0 /* is-not-excluded doForeignObject(Object, Object, InteropLibrary) */) {
                    int count2_ = 0;
                    ForeignObject0Data s2_ = this.foreignObject0_cache;
                    if ((state & 0b10) != 0 /* is-active doForeignObject(Object, Object, InteropLibrary) */) {
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
                            s2_ = super.insert(new ForeignObject0Data(foreignObject0_cache));
                            s2_.interop_ = s2_.insertAccessor((INTEROP_LIBRARY_.create(arguments0Value)));
                            this.foreignObject0_cache = s2_;
                            this.state_ = state = state | 0b10 /* add-active doForeignObject(Object, Object, InteropLibrary) */;
                        }
                    }
                    if (s2_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return doForeignObject(arguments0Value, arguments1Value, s2_.interop_);
                    }
                }
                {
                    InteropLibrary foreignObject1_interop__ = null;
                    {
                        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                        Node prev_ = encapsulating_.set(this);
                        try {
                            if ((JSGuards.isForeignObject(arguments0Value))) {
                                foreignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value));
                                this.exclude_ = exclude = exclude | 0b1 /* add-excluded doForeignObject(Object, Object, InteropLibrary) */;
                                this.foreignObject0_cache = null;
                                state = state & 0xfffffffd /* remove-active doForeignObject(Object, Object, InteropLibrary) */;
                                this.state_ = state = state | 0b100 /* add-active doForeignObject(Object, Object, InteropLibrary) */;
                                lock.unlock();
                                hasLock = false;
                                return doForeignObject(arguments0Value, arguments1Value, foreignObject1_interop__);
                            }
                        } finally {
                            encapsulating_.set(prev_);
                        }
                    }
                }
                if ((!(JSGuards.isJSObject(arguments0Value))) && (!(JSGuards.isForeignObject(arguments0Value)))) {
                    this.state_ = state = state | 0b1000 /* add-active doNonObject(Object, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return doNonObject(arguments0Value, arguments1Value);
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
            } else if ((state & (state - 1)) == 0 /* is-single-active  */) {
                ForeignObject0Data s2_ = this.foreignObject0_cache;
                if ((s2_ == null || s2_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
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
            s[0] = "doObject";
            if ((state & 0b1) != 0 /* is-active doObject(DynamicObject, Object, JSClassProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.object_classProfile_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doForeignObject";
            if ((state & 0b10) != 0 /* is-active doForeignObject(Object, Object, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                ForeignObject0Data s2_ = this.foreignObject0_cache;
                while (s2_ != null) {
                    cached.add(Arrays.asList(s2_.interop_));
                    s2_ = s2_.next_;
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-excluded doForeignObject(Object, Object, InteropLibrary) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "doForeignObject";
            if ((state & 0b100) != 0 /* is-active doForeignObject(Object, Object, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList());
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "doNonObject";
            if ((state & 0b1000) != 0 /* is-active doNonObject(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            return Provider.create(data);
        }

        public static ReflectDeletePropertyNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ReflectDeletePropertyNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(ReflectDeletePropertyNode.class)
        private static final class ForeignObject0Data extends Node {

            @Child ForeignObject0Data next_;
            @Child InteropLibrary interop_;

            ForeignObject0Data(ForeignObject0Data next_) {
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
    @GeneratedBy(ReflectGetNode.class)
    public static final class ReflectGetNodeGen extends ReflectGetNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private volatile int state_;
        @CompilationFinal private volatile int exclude_;
        @CompilationFinal private JSClassProfile object_classProfile_;
        @Child private ForeignObject0Data foreignObject0_cache;
        @Child private ImportValueNode foreignObject1_importValue_;

        private ReflectGetNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state != 0 /* is-active doObject(DynamicObject, Object, Object[], JSClassProfile) || doForeignObject(Object, Object, Object[], InteropLibrary, ImportValueNode) || doForeignObject(Object, Object, Object[], InteropLibrary, ImportValueNode) || doNonObject(Object, Object, Object[]) */ && arguments2Value_ instanceof Object[]) {
                Object[] arguments2Value__ = (Object[]) arguments2Value_;
                if ((state & 0b1) != 0 /* is-active doObject(DynamicObject, Object, Object[], JSClassProfile) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((JSGuards.isJSObject(arguments0Value__))) {
                        return doObject(arguments0Value__, arguments1Value_, arguments2Value__, this.object_classProfile_);
                    }
                }
                if ((state & 0b1110) != 0 /* is-active doForeignObject(Object, Object, Object[], InteropLibrary, ImportValueNode) || doForeignObject(Object, Object, Object[], InteropLibrary, ImportValueNode) || doNonObject(Object, Object, Object[]) */) {
                    if ((state & 0b10) != 0 /* is-active doForeignObject(Object, Object, Object[], InteropLibrary, ImportValueNode) */) {
                        ForeignObject0Data s2_ = this.foreignObject0_cache;
                        while (s2_ != null) {
                            if ((s2_.interop_.accepts(arguments0Value_)) && (JSGuards.isForeignObject(arguments0Value_))) {
                                return doForeignObject(arguments0Value_, arguments1Value_, arguments2Value__, s2_.interop_, s2_.importValue_);
                            }
                            s2_ = s2_.next_;
                        }
                    }
                    if ((state & 0b100) != 0 /* is-active doForeignObject(Object, Object, Object[], InteropLibrary, ImportValueNode) */) {
                        if ((JSGuards.isForeignObject(arguments0Value_))) {
                            return this.foreignObject1Boundary(state, arguments0Value_, arguments1Value_, arguments2Value__);
                        }
                    }
                    if ((state & 0b1000) != 0 /* is-active doNonObject(Object, Object, Object[]) */) {
                        if ((!(JSGuards.isJSObject(arguments0Value_))) && (!(JSGuards.isForeignObject(arguments0Value_)))) {
                            return doNonObject(arguments0Value_, arguments1Value_, arguments2Value__);
                        }
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @TruffleBoundary
        private Object foreignObject1Boundary(int state, Object arguments0Value_, Object arguments1Value_, Object[] arguments2Value__) {
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(this);
            try {
                {
                    InteropLibrary foreignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value_));
                    return doForeignObject(arguments0Value_, arguments1Value_, arguments2Value__, foreignObject1_interop__, this.foreignObject1_importValue_);
                }
            } finally {
                encapsulating_.set(prev_);
            }
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
                if (arguments2Value instanceof Object[]) {
                    Object[] arguments2Value_ = (Object[]) arguments2Value;
                    if (JSTypes.isDynamicObject(arguments0Value)) {
                        DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                        if ((JSGuards.isJSObject(arguments0Value_))) {
                            this.object_classProfile_ = (JSClassProfile.create());
                            this.state_ = state = state | 0b1 /* add-active doObject(DynamicObject, Object, Object[], JSClassProfile) */;
                            lock.unlock();
                            hasLock = false;
                            return doObject(arguments0Value_, arguments1Value, arguments2Value_, this.object_classProfile_);
                        }
                    }
                    if ((exclude) == 0 /* is-not-excluded doForeignObject(Object, Object, Object[], InteropLibrary, ImportValueNode) */) {
                        int count2_ = 0;
                        ForeignObject0Data s2_ = this.foreignObject0_cache;
                        if ((state & 0b10) != 0 /* is-active doForeignObject(Object, Object, Object[], InteropLibrary, ImportValueNode) */) {
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
                                s2_ = super.insert(new ForeignObject0Data(foreignObject0_cache));
                                s2_.interop_ = s2_.insertAccessor((INTEROP_LIBRARY_.create(arguments0Value)));
                                s2_.importValue_ = s2_.insertAccessor((ImportValueNode.create()));
                                this.foreignObject0_cache = s2_;
                                this.state_ = state = state | 0b10 /* add-active doForeignObject(Object, Object, Object[], InteropLibrary, ImportValueNode) */;
                            }
                        }
                        if (s2_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return doForeignObject(arguments0Value, arguments1Value, arguments2Value_, s2_.interop_, s2_.importValue_);
                        }
                    }
                    {
                        InteropLibrary foreignObject1_interop__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                if ((JSGuards.isForeignObject(arguments0Value))) {
                                    foreignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value));
                                    this.foreignObject1_importValue_ = super.insert((ImportValueNode.create()));
                                    this.exclude_ = exclude = exclude | 0b1 /* add-excluded doForeignObject(Object, Object, Object[], InteropLibrary, ImportValueNode) */;
                                    this.foreignObject0_cache = null;
                                    state = state & 0xfffffffd /* remove-active doForeignObject(Object, Object, Object[], InteropLibrary, ImportValueNode) */;
                                    this.state_ = state = state | 0b100 /* add-active doForeignObject(Object, Object, Object[], InteropLibrary, ImportValueNode) */;
                                    lock.unlock();
                                    hasLock = false;
                                    return doForeignObject(arguments0Value, arguments1Value, arguments2Value_, foreignObject1_interop__, this.foreignObject1_importValue_);
                                }
                            } finally {
                                encapsulating_.set(prev_);
                            }
                        }
                    }
                    if ((!(JSGuards.isJSObject(arguments0Value))) && (!(JSGuards.isForeignObject(arguments0Value)))) {
                        this.state_ = state = state | 0b1000 /* add-active doNonObject(Object, Object, Object[]) */;
                        lock.unlock();
                        hasLock = false;
                        return doNonObject(arguments0Value, arguments1Value, arguments2Value_);
                    }
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
                ForeignObject0Data s2_ = this.foreignObject0_cache;
                if ((s2_ == null || s2_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
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
            s[0] = "doObject";
            if ((state & 0b1) != 0 /* is-active doObject(DynamicObject, Object, Object[], JSClassProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.object_classProfile_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doForeignObject";
            if ((state & 0b10) != 0 /* is-active doForeignObject(Object, Object, Object[], InteropLibrary, ImportValueNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                ForeignObject0Data s2_ = this.foreignObject0_cache;
                while (s2_ != null) {
                    cached.add(Arrays.asList(s2_.interop_, s2_.importValue_));
                    s2_ = s2_.next_;
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-excluded doForeignObject(Object, Object, Object[], InteropLibrary, ImportValueNode) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "doForeignObject";
            if ((state & 0b100) != 0 /* is-active doForeignObject(Object, Object, Object[], InteropLibrary, ImportValueNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.foreignObject1_importValue_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "doNonObject";
            if ((state & 0b1000) != 0 /* is-active doNonObject(Object, Object, Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            return Provider.create(data);
        }

        public static ReflectGetNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ReflectGetNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(ReflectGetNode.class)
        private static final class ForeignObject0Data extends Node {

            @Child ForeignObject0Data next_;
            @Child InteropLibrary interop_;
            @Child ImportValueNode importValue_;

            ForeignObject0Data(ForeignObject0Data next_) {
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
    @GeneratedBy(ReflectGetOwnPropertyDescriptorNode.class)
    public static final class ReflectGetOwnPropertyDescriptorNodeGen extends ReflectGetOwnPropertyDescriptorNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_;
        @Child private ReflectGetOwnPropertyDescriptorData reflectGetOwnPropertyDescriptor_cache;

        private ReflectGetOwnPropertyDescriptorNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state != 0 /* is-active reflectGetOwnPropertyDescriptor(Object, Object, JSToPropertyKeyNode, JSGetOwnPropertyNode, FromPropertyDescriptorNode) */) {
                ReflectGetOwnPropertyDescriptorData s1_ = this.reflectGetOwnPropertyDescriptor_cache;
                if (s1_ != null) {
                    return reflectGetOwnPropertyDescriptor(arguments0Value_, arguments1Value_, s1_.toPropertyKeyNode_, s1_.getOwnPropertyNode_, s1_.fromPropertyDescriptorNode_);
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

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            try {
                ReflectGetOwnPropertyDescriptorData s1_ = super.insert(new ReflectGetOwnPropertyDescriptorData());
                s1_.toPropertyKeyNode_ = s1_.insertAccessor((JSToPropertyKeyNode.create()));
                s1_.getOwnPropertyNode_ = s1_.insertAccessor((JSGetOwnPropertyNode.create()));
                s1_.fromPropertyDescriptorNode_ = s1_.insertAccessor((FromPropertyDescriptorNode.create()));
                this.reflectGetOwnPropertyDescriptor_cache = s1_;
                this.state_ = state = state | 0b1 /* add-active reflectGetOwnPropertyDescriptor(Object, Object, JSToPropertyKeyNode, JSGetOwnPropertyNode, FromPropertyDescriptorNode) */;
                lock.unlock();
                hasLock = false;
                return reflectGetOwnPropertyDescriptor(arguments0Value, arguments1Value, s1_.toPropertyKeyNode_, s1_.getOwnPropertyNode_, s1_.fromPropertyDescriptorNode_);
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
            s[0] = "reflectGetOwnPropertyDescriptor";
            if (state != 0 /* is-active reflectGetOwnPropertyDescriptor(Object, Object, JSToPropertyKeyNode, JSGetOwnPropertyNode, FromPropertyDescriptorNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                ReflectGetOwnPropertyDescriptorData s1_ = this.reflectGetOwnPropertyDescriptor_cache;
                if (s1_ != null) {
                    cached.add(Arrays.asList(s1_.toPropertyKeyNode_, s1_.getOwnPropertyNode_, s1_.fromPropertyDescriptorNode_));
                }
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static ReflectGetOwnPropertyDescriptorNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ReflectGetOwnPropertyDescriptorNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(ReflectGetOwnPropertyDescriptorNode.class)
        private static final class ReflectGetOwnPropertyDescriptorData extends Node {

            @Child JSToPropertyKeyNode toPropertyKeyNode_;
            @Child JSGetOwnPropertyNode getOwnPropertyNode_;
            @Child FromPropertyDescriptorNode fromPropertyDescriptorNode_;

            ReflectGetOwnPropertyDescriptorData() {
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
    @GeneratedBy(ReflectGetPrototypeOfNode.class)
    public static final class ReflectGetPrototypeOfNodeGen extends ReflectGetPrototypeOfNode implements Provider {

        @Child private JavaScriptNode arguments0_;

        private ReflectGetPrototypeOfNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            return reflectGetPrototypeOf(arguments0Value_);
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
            s[0] = "reflectGetPrototypeOf";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static ReflectGetPrototypeOfNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ReflectGetPrototypeOfNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ReflectHasNode.class)
    public static final class ReflectHasNodeGen extends ReflectHasNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_;
        @CompilationFinal private volatile int exclude_;
        @CompilationFinal private JSClassProfile object_jsclassProfile_;
        @Child private ForeignObject0Data foreignObject0_cache;

        private ReflectHasNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_};
        }

        @ExplodeLoop
        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if (state != 0 /* is-active doObject(DynamicObject, Object, JSClassProfile) || doForeignObject(Object, Object, InteropLibrary) || doForeignObject(Object, Object, InteropLibrary) || doNonObject(Object, Object) */) {
                if ((state & 0b1) != 0 /* is-active doObject(DynamicObject, Object, JSClassProfile) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((JSGuards.isJSObject(arguments0Value__))) {
                        return doObject(arguments0Value__, arguments1Value_, this.object_jsclassProfile_);
                    }
                }
                if ((state & 0b1110) != 0 /* is-active doForeignObject(Object, Object, InteropLibrary) || doForeignObject(Object, Object, InteropLibrary) || doNonObject(Object, Object) */) {
                    if ((state & 0b10) != 0 /* is-active doForeignObject(Object, Object, InteropLibrary) */) {
                        ForeignObject0Data s2_ = this.foreignObject0_cache;
                        while (s2_ != null) {
                            if ((s2_.interop_.accepts(arguments0Value_)) && (JSGuards.isForeignObject(arguments0Value_))) {
                                return doForeignObject(arguments0Value_, arguments1Value_, s2_.interop_);
                            }
                            s2_ = s2_.next_;
                        }
                    }
                    if ((state & 0b100) != 0 /* is-active doForeignObject(Object, Object, InteropLibrary) */) {
                        if ((JSGuards.isForeignObject(arguments0Value_))) {
                            return this.foreignObject1Boundary(state, arguments0Value_, arguments1Value_);
                        }
                    }
                    if ((state & 0b1000) != 0 /* is-active doNonObject(Object, Object) */) {
                        if ((!(JSGuards.isJSObject(arguments0Value_))) && (!(JSGuards.isForeignObject(arguments0Value_)))) {
                            return doNonObject(arguments0Value_, arguments1Value_);
                        }
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @TruffleBoundary
        private Object foreignObject1Boundary(int state, Object arguments0Value_, Object arguments1Value_) {
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(this);
            try {
                {
                    InteropLibrary foreignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value_));
                    return doForeignObject(arguments0Value_, arguments1Value_, foreignObject1_interop__);
                }
            } finally {
                encapsulating_.set(prev_);
            }
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
            int exclude = exclude_;
            try {
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSObject(arguments0Value_))) {
                        this.object_jsclassProfile_ = (JSClassProfile.create());
                        this.state_ = state = state | 0b1 /* add-active doObject(DynamicObject, Object, JSClassProfile) */;
                        lock.unlock();
                        hasLock = false;
                        return doObject(arguments0Value_, arguments1Value, this.object_jsclassProfile_);
                    }
                }
                if ((exclude) == 0 /* is-not-excluded doForeignObject(Object, Object, InteropLibrary) */) {
                    int count2_ = 0;
                    ForeignObject0Data s2_ = this.foreignObject0_cache;
                    if ((state & 0b10) != 0 /* is-active doForeignObject(Object, Object, InteropLibrary) */) {
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
                            s2_ = super.insert(new ForeignObject0Data(foreignObject0_cache));
                            s2_.interop_ = s2_.insertAccessor((INTEROP_LIBRARY_.create(arguments0Value)));
                            this.foreignObject0_cache = s2_;
                            this.state_ = state = state | 0b10 /* add-active doForeignObject(Object, Object, InteropLibrary) */;
                        }
                    }
                    if (s2_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return doForeignObject(arguments0Value, arguments1Value, s2_.interop_);
                    }
                }
                {
                    InteropLibrary foreignObject1_interop__ = null;
                    {
                        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                        Node prev_ = encapsulating_.set(this);
                        try {
                            if ((JSGuards.isForeignObject(arguments0Value))) {
                                foreignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value));
                                this.exclude_ = exclude = exclude | 0b1 /* add-excluded doForeignObject(Object, Object, InteropLibrary) */;
                                this.foreignObject0_cache = null;
                                state = state & 0xfffffffd /* remove-active doForeignObject(Object, Object, InteropLibrary) */;
                                this.state_ = state = state | 0b100 /* add-active doForeignObject(Object, Object, InteropLibrary) */;
                                lock.unlock();
                                hasLock = false;
                                return doForeignObject(arguments0Value, arguments1Value, foreignObject1_interop__);
                            }
                        } finally {
                            encapsulating_.set(prev_);
                        }
                    }
                }
                if ((!(JSGuards.isJSObject(arguments0Value))) && (!(JSGuards.isForeignObject(arguments0Value)))) {
                    this.state_ = state = state | 0b1000 /* add-active doNonObject(Object, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return doNonObject(arguments0Value, arguments1Value);
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
            } else if ((state & (state - 1)) == 0 /* is-single-active  */) {
                ForeignObject0Data s2_ = this.foreignObject0_cache;
                if ((s2_ == null || s2_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
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
            s[0] = "doObject";
            if ((state & 0b1) != 0 /* is-active doObject(DynamicObject, Object, JSClassProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.object_jsclassProfile_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doForeignObject";
            if ((state & 0b10) != 0 /* is-active doForeignObject(Object, Object, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                ForeignObject0Data s2_ = this.foreignObject0_cache;
                while (s2_ != null) {
                    cached.add(Arrays.asList(s2_.interop_));
                    s2_ = s2_.next_;
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-excluded doForeignObject(Object, Object, InteropLibrary) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "doForeignObject";
            if ((state & 0b100) != 0 /* is-active doForeignObject(Object, Object, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList());
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "doNonObject";
            if ((state & 0b1000) != 0 /* is-active doNonObject(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            return Provider.create(data);
        }

        public static ReflectHasNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ReflectHasNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(ReflectHasNode.class)
        private static final class ForeignObject0Data extends Node {

            @Child ForeignObject0Data next_;
            @Child InteropLibrary interop_;

            ForeignObject0Data(ForeignObject0Data next_) {
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
    @GeneratedBy(ReflectIsExtensibleNode.class)
    public static final class ReflectIsExtensibleNodeGen extends ReflectIsExtensibleNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_;
        @Child private IsExtensibleNode isExtensibleNode_;

        private ReflectIsExtensibleNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state != 0 /* is-active reflectIsExtensible(Object, IsExtensibleNode) */) {
                return reflectIsExtensible(arguments0Value_, this.isExtensibleNode_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if (state != 0 /* is-active reflectIsExtensible(Object, IsExtensibleNode) */) {
                return reflectIsExtensible(arguments0Value_, this.isExtensibleNode_);
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
                this.isExtensibleNode_ = super.insert((IsExtensibleNode.create()));
                this.state_ = state = state | 0b1 /* add-active reflectIsExtensible(Object, IsExtensibleNode) */;
                lock.unlock();
                hasLock = false;
                return reflectIsExtensible(arguments0Value, this.isExtensibleNode_);
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
            s[0] = "reflectIsExtensible";
            if (state != 0 /* is-active reflectIsExtensible(Object, IsExtensibleNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.isExtensibleNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static ReflectIsExtensibleNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ReflectIsExtensibleNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ReflectOwnKeysNode.class)
    public static final class ReflectOwnKeysNodeGen extends ReflectOwnKeysNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_;
        @CompilationFinal private volatile int exclude_;
        @CompilationFinal private JSClassProfile reflectOwnKeys_jsclassProfile_;
        @Child private ForeignObject0Data foreignObject0_cache;

        private ReflectOwnKeysNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @ExplodeLoop
        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if (state != 0 /* is-active reflectOwnKeys(Object, JSClassProfile) || doForeignObject(Object, InteropLibrary) || doForeignObject(Object, InteropLibrary) || doNonObject(Object) */) {
                if ((state & 0b1) != 0 /* is-active reflectOwnKeys(Object, JSClassProfile) */) {
                    if ((JSGuards.isJSObject(arguments0Value_))) {
                        return reflectOwnKeys(arguments0Value_, this.reflectOwnKeys_jsclassProfile_);
                    }
                }
                if ((state & 0b10) != 0 /* is-active doForeignObject(Object, InteropLibrary) */) {
                    ForeignObject0Data s2_ = this.foreignObject0_cache;
                    while (s2_ != null) {
                        if ((s2_.interop_.accepts(arguments0Value_)) && (JSGuards.isForeignObject(arguments0Value_))) {
                            return doForeignObject(arguments0Value_, s2_.interop_);
                        }
                        s2_ = s2_.next_;
                    }
                }
                if ((state & 0b100) != 0 /* is-active doForeignObject(Object, InteropLibrary) */) {
                    if ((JSGuards.isForeignObject(arguments0Value_))) {
                        return this.foreignObject1Boundary(state, arguments0Value_);
                    }
                }
                if ((state & 0b1000) != 0 /* is-active doNonObject(Object) */) {
                    if ((!(JSGuards.isJSObject(arguments0Value_))) && (!(JSGuards.isForeignObject(arguments0Value_)))) {
                        return doNonObject(arguments0Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @TruffleBoundary
        private Object foreignObject1Boundary(int state, Object arguments0Value_) {
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(this);
            try {
                {
                    InteropLibrary foreignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value_));
                    return doForeignObject(arguments0Value_, foreignObject1_interop__);
                }
            } finally {
                encapsulating_.set(prev_);
            }
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
            int exclude = exclude_;
            try {
                if ((JSGuards.isJSObject(arguments0Value))) {
                    this.reflectOwnKeys_jsclassProfile_ = (JSClassProfile.create());
                    this.state_ = state = state | 0b1 /* add-active reflectOwnKeys(Object, JSClassProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return reflectOwnKeys(arguments0Value, this.reflectOwnKeys_jsclassProfile_);
                }
                if ((exclude) == 0 /* is-not-excluded doForeignObject(Object, InteropLibrary) */) {
                    int count2_ = 0;
                    ForeignObject0Data s2_ = this.foreignObject0_cache;
                    if ((state & 0b10) != 0 /* is-active doForeignObject(Object, InteropLibrary) */) {
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
                            s2_ = super.insert(new ForeignObject0Data(foreignObject0_cache));
                            s2_.interop_ = s2_.insertAccessor((INTEROP_LIBRARY_.create(arguments0Value)));
                            this.foreignObject0_cache = s2_;
                            this.state_ = state = state | 0b10 /* add-active doForeignObject(Object, InteropLibrary) */;
                        }
                    }
                    if (s2_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return doForeignObject(arguments0Value, s2_.interop_);
                    }
                }
                {
                    InteropLibrary foreignObject1_interop__ = null;
                    {
                        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                        Node prev_ = encapsulating_.set(this);
                        try {
                            if ((JSGuards.isForeignObject(arguments0Value))) {
                                foreignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value));
                                this.exclude_ = exclude = exclude | 0b1 /* add-excluded doForeignObject(Object, InteropLibrary) */;
                                this.foreignObject0_cache = null;
                                state = state & 0xfffffffd /* remove-active doForeignObject(Object, InteropLibrary) */;
                                this.state_ = state = state | 0b100 /* add-active doForeignObject(Object, InteropLibrary) */;
                                lock.unlock();
                                hasLock = false;
                                return doForeignObject(arguments0Value, foreignObject1_interop__);
                            }
                        } finally {
                            encapsulating_.set(prev_);
                        }
                    }
                }
                if ((!(JSGuards.isJSObject(arguments0Value))) && (!(JSGuards.isForeignObject(arguments0Value)))) {
                    this.state_ = state = state | 0b1000 /* add-active doNonObject(Object) */;
                    lock.unlock();
                    hasLock = false;
                    return doNonObject(arguments0Value);
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
            if (state == 0b0) {
                return NodeCost.UNINITIALIZED;
            } else if ((state & (state - 1)) == 0 /* is-single-active  */) {
                ForeignObject0Data s2_ = this.foreignObject0_cache;
                if ((s2_ == null || s2_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
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
            s[0] = "reflectOwnKeys";
            if ((state & 0b1) != 0 /* is-active reflectOwnKeys(Object, JSClassProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.reflectOwnKeys_jsclassProfile_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doForeignObject";
            if ((state & 0b10) != 0 /* is-active doForeignObject(Object, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                ForeignObject0Data s2_ = this.foreignObject0_cache;
                while (s2_ != null) {
                    cached.add(Arrays.asList(s2_.interop_));
                    s2_ = s2_.next_;
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-excluded doForeignObject(Object, InteropLibrary) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "doForeignObject";
            if ((state & 0b100) != 0 /* is-active doForeignObject(Object, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList());
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "doNonObject";
            if ((state & 0b1000) != 0 /* is-active doNonObject(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            return Provider.create(data);
        }

        public static ReflectOwnKeysNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ReflectOwnKeysNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(ReflectOwnKeysNode.class)
        private static final class ForeignObject0Data extends Node {

            @Child ForeignObject0Data next_;
            @Child InteropLibrary interop_;

            ForeignObject0Data(ForeignObject0Data next_) {
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
    @GeneratedBy(ReflectPreventExtensionsNode.class)
    public static final class ReflectPreventExtensionsNodeGen extends ReflectPreventExtensionsNode implements Provider {

        @Child private JavaScriptNode arguments0_;

        private ReflectPreventExtensionsNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            return reflectPreventExtensions(arguments0Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return reflectPreventExtensions(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            executeBoolean(frameValue);
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
            s[0] = "reflectPreventExtensions";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static ReflectPreventExtensionsNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ReflectPreventExtensionsNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ReflectSetNode.class)
    public static final class ReflectSetNodeGen extends ReflectSetNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @Child private JavaScriptNode arguments3_;
        @CompilationFinal private volatile int state_;
        @CompilationFinal private volatile int exclude_;
        @CompilationFinal private JSClassProfile reflectSet_jsclassProfile_;
        @Child private ForeignObject0Data foreignObject0_cache;
        @Child private ExportValueNode foreignObject1_exportValue_;

        private ReflectSetNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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

        @ExplodeLoop
        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            Object arguments3Value_ = this.arguments3_.execute(frameValue);
            if (state != 0 /* is-active reflectSet(DynamicObject, Object, Object, Object[], JSClassProfile) || doForeignObject(Object, Object, Object, Object[], InteropLibrary, ExportValueNode) || doForeignObject(Object, Object, Object, Object[], InteropLibrary, ExportValueNode) || doNonObject(Object, Object, Object, Object[]) */ && arguments3Value_ instanceof Object[]) {
                Object[] arguments3Value__ = (Object[]) arguments3Value_;
                if ((state & 0b1) != 0 /* is-active reflectSet(DynamicObject, Object, Object, Object[], JSClassProfile) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((JSGuards.isJSObject(arguments0Value__))) {
                        return reflectSet(arguments0Value__, arguments1Value_, arguments2Value_, arguments3Value__, this.reflectSet_jsclassProfile_);
                    }
                }
                if ((state & 0b1110) != 0 /* is-active doForeignObject(Object, Object, Object, Object[], InteropLibrary, ExportValueNode) || doForeignObject(Object, Object, Object, Object[], InteropLibrary, ExportValueNode) || doNonObject(Object, Object, Object, Object[]) */) {
                    if ((state & 0b10) != 0 /* is-active doForeignObject(Object, Object, Object, Object[], InteropLibrary, ExportValueNode) */) {
                        ForeignObject0Data s2_ = this.foreignObject0_cache;
                        while (s2_ != null) {
                            if ((s2_.interop_.accepts(arguments0Value_)) && (JSGuards.isForeignObject(arguments0Value_))) {
                                return doForeignObject(arguments0Value_, arguments1Value_, arguments2Value_, arguments3Value__, s2_.interop_, s2_.exportValue_);
                            }
                            s2_ = s2_.next_;
                        }
                    }
                    if ((state & 0b100) != 0 /* is-active doForeignObject(Object, Object, Object, Object[], InteropLibrary, ExportValueNode) */) {
                        if ((JSGuards.isForeignObject(arguments0Value_))) {
                            return this.foreignObject1Boundary(state, arguments0Value_, arguments1Value_, arguments2Value_, arguments3Value__);
                        }
                    }
                    if ((state & 0b1000) != 0 /* is-active doNonObject(Object, Object, Object, Object[]) */) {
                        if ((!(JSGuards.isJSObject(arguments0Value_))) && (!(JSGuards.isForeignObject(arguments0Value_)))) {
                            return doNonObject(arguments0Value_, arguments1Value_, arguments2Value_, arguments3Value__);
                        }
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_, arguments3Value_);
        }

        @TruffleBoundary
        private Object foreignObject1Boundary(int state, Object arguments0Value_, Object arguments1Value_, Object arguments2Value_, Object[] arguments3Value__) {
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(this);
            try {
                {
                    InteropLibrary foreignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value_));
                    return doForeignObject(arguments0Value_, arguments1Value_, arguments2Value_, arguments3Value__, foreignObject1_interop__, this.foreignObject1_exportValue_);
                }
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) throws UnexpectedResultException {
            int state = state_;
            if ((state & 0b1110) != 0 /* is-active doForeignObject(Object, Object, Object, Object[], InteropLibrary, ExportValueNode) || doForeignObject(Object, Object, Object, Object[], InteropLibrary, ExportValueNode) || doNonObject(Object, Object, Object, Object[]) */) {
                return JSTypesGen.expectBoolean(execute(frameValue));
            }
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            Object arguments3Value_ = this.arguments3_.execute(frameValue);
            if ((state & 0b1) != 0 /* is-active reflectSet(DynamicObject, Object, Object, Object[], JSClassProfile) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if (arguments3Value_ instanceof Object[]) {
                    Object[] arguments3Value__ = (Object[]) arguments3Value_;
                    if ((JSGuards.isJSObject(arguments0Value__))) {
                        return reflectSet(arguments0Value__, arguments1Value_, arguments2Value_, arguments3Value__, this.reflectSet_jsclassProfile_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return JSTypesGen.expectBoolean(executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_, arguments3Value_));
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            int state = state_;
            try {
                if ((state & 0b1110) == 0 /* only-active reflectSet(DynamicObject, Object, Object, Object[], JSClassProfile) */ && state != 0  /* is-not reflectSet(DynamicObject, Object, Object, Object[], JSClassProfile) && doForeignObject(Object, Object, Object, Object[], InteropLibrary, ExportValueNode) && doForeignObject(Object, Object, Object, Object[], InteropLibrary, ExportValueNode) && doNonObject(Object, Object, Object, Object[]) */) {
                    executeBoolean(frameValue);
                    return;
                }
                execute(frameValue);
                return;
            } catch (UnexpectedResultException ex) {
                return;
            }
        }

        private Object executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value, Object arguments3Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int exclude = exclude_;
            try {
                if (arguments3Value instanceof Object[]) {
                    Object[] arguments3Value_ = (Object[]) arguments3Value;
                    if (JSTypes.isDynamicObject(arguments0Value)) {
                        DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                        if ((JSGuards.isJSObject(arguments0Value_))) {
                            this.reflectSet_jsclassProfile_ = (JSClassProfile.create());
                            this.state_ = state = state | 0b1 /* add-active reflectSet(DynamicObject, Object, Object, Object[], JSClassProfile) */;
                            lock.unlock();
                            hasLock = false;
                            return reflectSet(arguments0Value_, arguments1Value, arguments2Value, arguments3Value_, this.reflectSet_jsclassProfile_);
                        }
                    }
                    if ((exclude) == 0 /* is-not-excluded doForeignObject(Object, Object, Object, Object[], InteropLibrary, ExportValueNode) */) {
                        int count2_ = 0;
                        ForeignObject0Data s2_ = this.foreignObject0_cache;
                        if ((state & 0b10) != 0 /* is-active doForeignObject(Object, Object, Object, Object[], InteropLibrary, ExportValueNode) */) {
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
                                s2_ = super.insert(new ForeignObject0Data(foreignObject0_cache));
                                s2_.interop_ = s2_.insertAccessor((INTEROP_LIBRARY_.create(arguments0Value)));
                                s2_.exportValue_ = s2_.insertAccessor((ExportValueNode.create()));
                                this.foreignObject0_cache = s2_;
                                this.state_ = state = state | 0b10 /* add-active doForeignObject(Object, Object, Object, Object[], InteropLibrary, ExportValueNode) */;
                            }
                        }
                        if (s2_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return doForeignObject(arguments0Value, arguments1Value, arguments2Value, arguments3Value_, s2_.interop_, s2_.exportValue_);
                        }
                    }
                    {
                        InteropLibrary foreignObject1_interop__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                if ((JSGuards.isForeignObject(arguments0Value))) {
                                    foreignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value));
                                    this.foreignObject1_exportValue_ = super.insert((ExportValueNode.create()));
                                    this.exclude_ = exclude = exclude | 0b1 /* add-excluded doForeignObject(Object, Object, Object, Object[], InteropLibrary, ExportValueNode) */;
                                    this.foreignObject0_cache = null;
                                    state = state & 0xfffffffd /* remove-active doForeignObject(Object, Object, Object, Object[], InteropLibrary, ExportValueNode) */;
                                    this.state_ = state = state | 0b100 /* add-active doForeignObject(Object, Object, Object, Object[], InteropLibrary, ExportValueNode) */;
                                    lock.unlock();
                                    hasLock = false;
                                    return doForeignObject(arguments0Value, arguments1Value, arguments2Value, arguments3Value_, foreignObject1_interop__, this.foreignObject1_exportValue_);
                                }
                            } finally {
                                encapsulating_.set(prev_);
                            }
                        }
                    }
                    if ((!(JSGuards.isJSObject(arguments0Value))) && (!(JSGuards.isForeignObject(arguments0Value)))) {
                        this.state_ = state = state | 0b1000 /* add-active doNonObject(Object, Object, Object, Object[]) */;
                        lock.unlock();
                        hasLock = false;
                        return doNonObject(arguments0Value, arguments1Value, arguments2Value, arguments3Value_);
                    }
                }
                throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_, this.arguments2_, this.arguments3_}, arguments0Value, arguments1Value, arguments2Value, arguments3Value);
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
                ForeignObject0Data s2_ = this.foreignObject0_cache;
                if ((s2_ == null || s2_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
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
            s[0] = "reflectSet";
            if ((state & 0b1) != 0 /* is-active reflectSet(DynamicObject, Object, Object, Object[], JSClassProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.reflectSet_jsclassProfile_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doForeignObject";
            if ((state & 0b10) != 0 /* is-active doForeignObject(Object, Object, Object, Object[], InteropLibrary, ExportValueNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                ForeignObject0Data s2_ = this.foreignObject0_cache;
                while (s2_ != null) {
                    cached.add(Arrays.asList(s2_.interop_, s2_.exportValue_));
                    s2_ = s2_.next_;
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-excluded doForeignObject(Object, Object, Object, Object[], InteropLibrary, ExportValueNode) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "doForeignObject";
            if ((state & 0b100) != 0 /* is-active doForeignObject(Object, Object, Object, Object[], InteropLibrary, ExportValueNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.foreignObject1_exportValue_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "doNonObject";
            if ((state & 0b1000) != 0 /* is-active doNonObject(Object, Object, Object, Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            return Provider.create(data);
        }

        public static ReflectSetNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ReflectSetNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(ReflectSetNode.class)
        private static final class ForeignObject0Data extends Node {

            @Child ForeignObject0Data next_;
            @Child InteropLibrary interop_;
            @Child ExportValueNode exportValue_;

            ForeignObject0Data(ForeignObject0Data next_) {
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
    @GeneratedBy(ReflectSetPrototypeOfNode.class)
    public static final class ReflectSetPrototypeOfNodeGen extends ReflectSetPrototypeOfNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;

        private ReflectSetPrototypeOfNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            return reflectSetPrototypeOf(arguments0Value_, arguments1Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            return reflectSetPrototypeOf(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            executeBoolean(frameValue);
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
            s[0] = "reflectSetPrototypeOf";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static ReflectSetPrototypeOfNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ReflectSetPrototypeOfNodeGen(context, builtin, arguments);
        }

    }
}
