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
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.js.builtins.ObjectFunctionBuiltins.AssignPropertiesNode;
import com.oracle.truffle.js.builtins.ObjectFunctionBuiltins.ObjectAssignNode;
import com.oracle.truffle.js.builtins.ObjectFunctionBuiltins.ObjectBindPropertiesNode;
import com.oracle.truffle.js.builtins.ObjectFunctionBuiltins.ObjectCreateNode;
import com.oracle.truffle.js.builtins.ObjectFunctionBuiltins.ObjectDefinePropertiesNode;
import com.oracle.truffle.js.builtins.ObjectFunctionBuiltins.ObjectDefinePropertyNode;
import com.oracle.truffle.js.builtins.ObjectFunctionBuiltins.ObjectFromEntriesNode;
import com.oracle.truffle.js.builtins.ObjectFunctionBuiltins.ObjectGetOwnPropertyDescriptorNode;
import com.oracle.truffle.js.builtins.ObjectFunctionBuiltins.ObjectGetOwnPropertyDescriptorsNode;
import com.oracle.truffle.js.builtins.ObjectFunctionBuiltins.ObjectGetOwnPropertyNamesOrSymbolsNode;
import com.oracle.truffle.js.builtins.ObjectFunctionBuiltins.ObjectGetPrototypeOfNode;
import com.oracle.truffle.js.builtins.ObjectFunctionBuiltins.ObjectIsExtensibleNode;
import com.oracle.truffle.js.builtins.ObjectFunctionBuiltins.ObjectIsNode;
import com.oracle.truffle.js.builtins.ObjectFunctionBuiltins.ObjectKeysNode;
import com.oracle.truffle.js.builtins.ObjectFunctionBuiltins.ObjectPreventExtensionsNode;
import com.oracle.truffle.js.builtins.ObjectFunctionBuiltins.ObjectSetIntegrityLevelNode;
import com.oracle.truffle.js.builtins.ObjectFunctionBuiltins.ObjectSetPrototypeOfNode;
import com.oracle.truffle.js.builtins.ObjectFunctionBuiltins.ObjectTestIntegrityLevelNode;
import com.oracle.truffle.js.builtins.ObjectFunctionBuiltins.ObjectValuesOrEntriesNode;
import com.oracle.truffle.js.builtins.helper.ListGetNode;
import com.oracle.truffle.js.builtins.helper.ListSizeNode;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.access.GetPrototypeNode;
import com.oracle.truffle.js.nodes.access.IsExtensibleNode;
import com.oracle.truffle.js.nodes.access.JSGetOwnPropertyNode;
import com.oracle.truffle.js.nodes.access.ReadElementNode;
import com.oracle.truffle.js.nodes.access.WriteElementNode;
import com.oracle.truffle.js.nodes.binary.JSIdenticalNode;
import com.oracle.truffle.js.nodes.cast.JSToObjectNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.nodes.interop.ImportValueNode;
import com.oracle.truffle.js.runtime.BigInt;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.SafeInteger;
import com.oracle.truffle.js.runtime.Symbol;
import com.oracle.truffle.js.runtime.objects.JSDynamicObject;
import com.oracle.truffle.js.runtime.objects.JSLazyString;
import com.oracle.truffle.js.runtime.objects.JSObject;
import com.oracle.truffle.js.runtime.util.JSClassProfile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(ObjectFunctionBuiltins.class)
@SuppressWarnings("unused")
public final class ObjectFunctionBuiltinsFactory {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @GeneratedBy(ObjectGetPrototypeOfNode.class)
    public static final class ObjectGetPrototypeOfNodeGen extends ObjectGetPrototypeOfNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_;
        @Child private GetPrototypeNode getPrototypeOfJSObject_getPrototypeNode_;

        private ObjectGetPrototypeOfNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state & 0b1) != 0 /* is-active getPrototypeOfNonObject(Object) */) {
                if ((!(JSGuards.isJSObject(arguments0Value_)))) {
                    return getPrototypeOfNonObject(arguments0Value_);
                }
            }
            if ((state & 0b10) != 0 /* is-active getPrototypeOfJSObject(DynamicObject, GetPrototypeNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((JSGuards.isJSObject(arguments0Value__))) {
                    return getPrototypeOfJSObject(arguments0Value__, this.getPrototypeOfJSObject_getPrototypeNode_);
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

        private DynamicObject executeAndSpecialize(Object arguments0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            try {
                if ((!(JSGuards.isJSObject(arguments0Value)))) {
                    this.state_ = state = state | 0b1 /* add-active getPrototypeOfNonObject(Object) */;
                    lock.unlock();
                    hasLock = false;
                    return getPrototypeOfNonObject(arguments0Value);
                }
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSObject(arguments0Value_))) {
                        this.getPrototypeOfJSObject_getPrototypeNode_ = super.insert((GetPrototypeNode.create()));
                        this.state_ = state = state | 0b10 /* add-active getPrototypeOfJSObject(DynamicObject, GetPrototypeNode) */;
                        lock.unlock();
                        hasLock = false;
                        return getPrototypeOfJSObject(arguments0Value_, this.getPrototypeOfJSObject_getPrototypeNode_);
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
            s[0] = "getPrototypeOfNonObject";
            if ((state & 0b1) != 0 /* is-active getPrototypeOfNonObject(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "getPrototypeOfJSObject";
            if ((state & 0b10) != 0 /* is-active getPrototypeOfJSObject(DynamicObject, GetPrototypeNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.getPrototypeOfJSObject_getPrototypeNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static ObjectGetPrototypeOfNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ObjectGetPrototypeOfNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ObjectGetOwnPropertyDescriptorNode.class)
    public static final class ObjectGetOwnPropertyDescriptorNodeGen extends ObjectGetOwnPropertyDescriptorNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_;
        @CompilationFinal private volatile int exclude_;
        @Child private GetForeignObject0Data getForeignObject0_cache;
        @Child private ImportValueNode getForeignObject1_toJSType_;

        private ObjectGetOwnPropertyDescriptorNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state != 0 /* is-active getJSObject(DynamicObject, Object) || getForeignObject(Object, Object, InteropLibrary, ImportValueNode) || getForeignObject(Object, Object, InteropLibrary, ImportValueNode) || getDefault(Object, Object) */) {
                if ((state & 0b1) != 0 /* is-active getJSObject(DynamicObject, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((JSGuards.isJSObject(arguments0Value__))) {
                        return getJSObject(arguments0Value__, arguments1Value_);
                    }
                }
                if ((state & 0b1110) != 0 /* is-active getForeignObject(Object, Object, InteropLibrary, ImportValueNode) || getForeignObject(Object, Object, InteropLibrary, ImportValueNode) || getDefault(Object, Object) */) {
                    if ((state & 0b10) != 0 /* is-active getForeignObject(Object, Object, InteropLibrary, ImportValueNode) */) {
                        GetForeignObject0Data s2_ = this.getForeignObject0_cache;
                        while (s2_ != null) {
                            if ((s2_.interop_.accepts(arguments0Value_)) && (JSGuards.isForeignObject(arguments0Value_))) {
                                return getForeignObject(arguments0Value_, arguments1Value_, s2_.interop_, s2_.toJSType_);
                            }
                            s2_ = s2_.next_;
                        }
                    }
                    if ((state & 0b100) != 0 /* is-active getForeignObject(Object, Object, InteropLibrary, ImportValueNode) */) {
                        if ((JSGuards.isForeignObject(arguments0Value_))) {
                            return this.getForeignObject1Boundary(state, arguments0Value_, arguments1Value_);
                        }
                    }
                    if ((state & 0b1000) != 0 /* is-active getDefault(Object, Object) */) {
                        if ((!(JSGuards.isJSObject(arguments0Value_))) && (!(JSGuards.isForeignObject(arguments0Value_)))) {
                            return getDefault(arguments0Value_, arguments1Value_);
                        }
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @TruffleBoundary
        private Object getForeignObject1Boundary(int state, Object arguments0Value_, Object arguments1Value_) {
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(this);
            try {
                {
                    InteropLibrary getForeignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value_));
                    return getForeignObject(arguments0Value_, arguments1Value_, getForeignObject1_interop__, this.getForeignObject1_toJSType_);
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

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int exclude = exclude_;
            try {
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSObject(arguments0Value_))) {
                        this.state_ = state = state | 0b1 /* add-active getJSObject(DynamicObject, Object) */;
                        lock.unlock();
                        hasLock = false;
                        return getJSObject(arguments0Value_, arguments1Value);
                    }
                }
                if ((exclude) == 0 /* is-not-excluded getForeignObject(Object, Object, InteropLibrary, ImportValueNode) */) {
                    int count2_ = 0;
                    GetForeignObject0Data s2_ = this.getForeignObject0_cache;
                    if ((state & 0b10) != 0 /* is-active getForeignObject(Object, Object, InteropLibrary, ImportValueNode) */) {
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
                            s2_ = super.insert(new GetForeignObject0Data(getForeignObject0_cache));
                            s2_.interop_ = s2_.insertAccessor((INTEROP_LIBRARY_.create(arguments0Value)));
                            s2_.toJSType_ = s2_.insertAccessor((ImportValueNode.create()));
                            this.getForeignObject0_cache = s2_;
                            this.state_ = state = state | 0b10 /* add-active getForeignObject(Object, Object, InteropLibrary, ImportValueNode) */;
                        }
                    }
                    if (s2_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return getForeignObject(arguments0Value, arguments1Value, s2_.interop_, s2_.toJSType_);
                    }
                }
                {
                    InteropLibrary getForeignObject1_interop__ = null;
                    {
                        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                        Node prev_ = encapsulating_.set(this);
                        try {
                            if ((JSGuards.isForeignObject(arguments0Value))) {
                                getForeignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value));
                                this.getForeignObject1_toJSType_ = super.insert((ImportValueNode.create()));
                                this.exclude_ = exclude = exclude | 0b1 /* add-excluded getForeignObject(Object, Object, InteropLibrary, ImportValueNode) */;
                                this.getForeignObject0_cache = null;
                                state = state & 0xfffffffd /* remove-active getForeignObject(Object, Object, InteropLibrary, ImportValueNode) */;
                                this.state_ = state = state | 0b100 /* add-active getForeignObject(Object, Object, InteropLibrary, ImportValueNode) */;
                                lock.unlock();
                                hasLock = false;
                                return getForeignObject(arguments0Value, arguments1Value, getForeignObject1_interop__, this.getForeignObject1_toJSType_);
                            }
                        } finally {
                            encapsulating_.set(prev_);
                        }
                    }
                }
                if ((!(JSGuards.isJSObject(arguments0Value))) && (!(JSGuards.isForeignObject(arguments0Value)))) {
                    this.state_ = state = state | 0b1000 /* add-active getDefault(Object, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return getDefault(arguments0Value, arguments1Value);
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
                GetForeignObject0Data s2_ = this.getForeignObject0_cache;
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
            s[0] = "getJSObject";
            if ((state & 0b1) != 0 /* is-active getJSObject(DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "getForeignObject";
            if ((state & 0b10) != 0 /* is-active getForeignObject(Object, Object, InteropLibrary, ImportValueNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                GetForeignObject0Data s2_ = this.getForeignObject0_cache;
                while (s2_ != null) {
                    cached.add(Arrays.asList(s2_.interop_, s2_.toJSType_));
                    s2_ = s2_.next_;
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-excluded getForeignObject(Object, Object, InteropLibrary, ImportValueNode) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "getForeignObject";
            if ((state & 0b100) != 0 /* is-active getForeignObject(Object, Object, InteropLibrary, ImportValueNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.getForeignObject1_toJSType_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "getDefault";
            if ((state & 0b1000) != 0 /* is-active getDefault(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            return Provider.create(data);
        }

        public static ObjectGetOwnPropertyDescriptorNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ObjectGetOwnPropertyDescriptorNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(ObjectGetOwnPropertyDescriptorNode.class)
        private static final class GetForeignObject0Data extends Node {

            @Child GetForeignObject0Data next_;
            @Child InteropLibrary interop_;
            @Child ImportValueNode toJSType_;

            GetForeignObject0Data(GetForeignObject0Data next_) {
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
    @GeneratedBy(ObjectGetOwnPropertyDescriptorsNode.class)
    public static final class ObjectGetOwnPropertyDescriptorsNodeGen extends ObjectGetOwnPropertyDescriptorsNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_;
        @CompilationFinal private volatile int exclude_;
        @Child private GetJSObjectData getJSObject_cache;
        @Child private GetForeignObject0Data getForeignObject0_cache;
        @Child private InteropLibrary getForeignObject1_members_;
        @Child private ImportValueNode getForeignObject1_toJSType_;
        @Child private ObjectGetOwnPropertyDescriptorsNode getDefault_recursive_;

        private ObjectGetOwnPropertyDescriptorsNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @ExplodeLoop
        @Override
        protected DynamicObject executeEvaluated(Object arguments0Value) {
            int state = state_;
            if ((state & 0b1) != 0 /* is-active getJSObject(DynamicObject, JSGetOwnPropertyNode, ListSizeNode, ListGetNode, JSClassProfile) */ && JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                GetJSObjectData s1_ = this.getJSObject_cache;
                if (s1_ != null) {
                    if ((JSGuards.isJSObject(arguments0Value_))) {
                        return getJSObject(arguments0Value_, s1_.getOwnPropertyNode_, s1_.listSize_, s1_.listGet_, s1_.classProfile_);
                    }
                }
            }
            if ((state & 0b1110) != 0 /* is-active getForeignObject(Object, InteropLibrary, InteropLibrary, ImportValueNode) || getForeignObject(Object, InteropLibrary, InteropLibrary, ImportValueNode) || getDefault(Object, ObjectGetOwnPropertyDescriptorsNode) */) {
                if ((state & 0b10) != 0 /* is-active getForeignObject(Object, InteropLibrary, InteropLibrary, ImportValueNode) */) {
                    GetForeignObject0Data s2_ = this.getForeignObject0_cache;
                    while (s2_ != null) {
                        if ((s2_.interop_.accepts(arguments0Value)) && (JSGuards.isForeignObject(arguments0Value))) {
                            return getForeignObject(arguments0Value, s2_.interop_, s2_.members_, s2_.toJSType_);
                        }
                        s2_ = s2_.next_;
                    }
                }
                if ((state & 0b100) != 0 /* is-active getForeignObject(Object, InteropLibrary, InteropLibrary, ImportValueNode) */) {
                    if ((JSGuards.isForeignObject(arguments0Value))) {
                        return this.getForeignObject1Boundary(state, arguments0Value);
                    }
                }
                if ((state & 0b1000) != 0 /* is-active getDefault(Object, ObjectGetOwnPropertyDescriptorsNode) */) {
                    if ((!(JSGuards.isJSObject(arguments0Value))) && (!(JSGuards.isForeignObject(arguments0Value)))) {
                        return getDefault(arguments0Value, this.getDefault_recursive_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value);
        }

        @TruffleBoundary
        private DynamicObject getForeignObject1Boundary(int state, Object arguments0Value) {
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(this);
            try {
                {
                    InteropLibrary getForeignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value));
                    return getForeignObject(arguments0Value, getForeignObject1_interop__, this.getForeignObject1_members_, this.getForeignObject1_toJSType_);
                }
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @ExplodeLoop
        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state & 0b1) != 0 /* is-active getJSObject(DynamicObject, JSGetOwnPropertyNode, ListSizeNode, ListGetNode, JSClassProfile) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                GetJSObjectData s1_ = this.getJSObject_cache;
                if (s1_ != null) {
                    if ((JSGuards.isJSObject(arguments0Value__))) {
                        return getJSObject(arguments0Value__, s1_.getOwnPropertyNode_, s1_.listSize_, s1_.listGet_, s1_.classProfile_);
                    }
                }
            }
            if ((state & 0b1110) != 0 /* is-active getForeignObject(Object, InteropLibrary, InteropLibrary, ImportValueNode) || getForeignObject(Object, InteropLibrary, InteropLibrary, ImportValueNode) || getDefault(Object, ObjectGetOwnPropertyDescriptorsNode) */) {
                if ((state & 0b10) != 0 /* is-active getForeignObject(Object, InteropLibrary, InteropLibrary, ImportValueNode) */) {
                    GetForeignObject0Data s2_ = this.getForeignObject0_cache;
                    while (s2_ != null) {
                        if ((s2_.interop_.accepts(arguments0Value_)) && (JSGuards.isForeignObject(arguments0Value_))) {
                            return getForeignObject(arguments0Value_, s2_.interop_, s2_.members_, s2_.toJSType_);
                        }
                        s2_ = s2_.next_;
                    }
                }
                if ((state & 0b100) != 0 /* is-active getForeignObject(Object, InteropLibrary, InteropLibrary, ImportValueNode) */) {
                    if ((JSGuards.isForeignObject(arguments0Value_))) {
                        return this.getForeignObject1Boundary0(state, arguments0Value_);
                    }
                }
                if ((state & 0b1000) != 0 /* is-active getDefault(Object, ObjectGetOwnPropertyDescriptorsNode) */) {
                    if ((!(JSGuards.isJSObject(arguments0Value_))) && (!(JSGuards.isForeignObject(arguments0Value_)))) {
                        return getDefault(arguments0Value_, this.getDefault_recursive_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @TruffleBoundary
        private Object getForeignObject1Boundary0(int state, Object arguments0Value_) {
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(this);
            try {
                {
                    InteropLibrary getForeignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value_));
                    return getForeignObject(arguments0Value_, getForeignObject1_interop__, this.getForeignObject1_members_, this.getForeignObject1_toJSType_);
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

        private DynamicObject executeAndSpecialize(Object arguments0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int exclude = exclude_;
            try {
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSObject(arguments0Value_))) {
                        GetJSObjectData s1_ = super.insert(new GetJSObjectData());
                        s1_.getOwnPropertyNode_ = s1_.insertAccessor((JSGetOwnPropertyNode.create()));
                        s1_.listSize_ = s1_.insertAccessor((ListSizeNode.create()));
                        s1_.listGet_ = s1_.insertAccessor((ListGetNode.create()));
                        s1_.classProfile_ = (JSClassProfile.create());
                        this.getJSObject_cache = s1_;
                        this.state_ = state = state | 0b1 /* add-active getJSObject(DynamicObject, JSGetOwnPropertyNode, ListSizeNode, ListGetNode, JSClassProfile) */;
                        lock.unlock();
                        hasLock = false;
                        return getJSObject(arguments0Value_, s1_.getOwnPropertyNode_, s1_.listSize_, s1_.listGet_, s1_.classProfile_);
                    }
                }
                if ((exclude) == 0 /* is-not-excluded getForeignObject(Object, InteropLibrary, InteropLibrary, ImportValueNode) */) {
                    int count2_ = 0;
                    GetForeignObject0Data s2_ = this.getForeignObject0_cache;
                    if ((state & 0b10) != 0 /* is-active getForeignObject(Object, InteropLibrary, InteropLibrary, ImportValueNode) */) {
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
                            s2_ = super.insert(new GetForeignObject0Data(getForeignObject0_cache));
                            s2_.interop_ = s2_.insertAccessor((INTEROP_LIBRARY_.create(arguments0Value)));
                            s2_.members_ = s2_.insertAccessor((INTEROP_LIBRARY_.createDispatched(3)));
                            s2_.toJSType_ = s2_.insertAccessor((ImportValueNode.create()));
                            this.getForeignObject0_cache = s2_;
                            this.state_ = state = state | 0b10 /* add-active getForeignObject(Object, InteropLibrary, InteropLibrary, ImportValueNode) */;
                        }
                    }
                    if (s2_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return getForeignObject(arguments0Value, s2_.interop_, s2_.members_, s2_.toJSType_);
                    }
                }
                {
                    InteropLibrary getForeignObject1_interop__ = null;
                    {
                        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                        Node prev_ = encapsulating_.set(this);
                        try {
                            if ((JSGuards.isForeignObject(arguments0Value))) {
                                getForeignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value));
                                this.getForeignObject1_members_ = super.insert((INTEROP_LIBRARY_.createDispatched(3)));
                                this.getForeignObject1_toJSType_ = super.insert((ImportValueNode.create()));
                                this.exclude_ = exclude = exclude | 0b1 /* add-excluded getForeignObject(Object, InteropLibrary, InteropLibrary, ImportValueNode) */;
                                this.getForeignObject0_cache = null;
                                state = state & 0xfffffffd /* remove-active getForeignObject(Object, InteropLibrary, InteropLibrary, ImportValueNode) */;
                                this.state_ = state = state | 0b100 /* add-active getForeignObject(Object, InteropLibrary, InteropLibrary, ImportValueNode) */;
                                lock.unlock();
                                hasLock = false;
                                return getForeignObject(arguments0Value, getForeignObject1_interop__, this.getForeignObject1_members_, this.getForeignObject1_toJSType_);
                            }
                        } finally {
                            encapsulating_.set(prev_);
                        }
                    }
                }
                if ((!(JSGuards.isJSObject(arguments0Value))) && (!(JSGuards.isForeignObject(arguments0Value)))) {
                    this.getDefault_recursive_ = super.insert((createRecursive()));
                    this.state_ = state = state | 0b1000 /* add-active getDefault(Object, ObjectGetOwnPropertyDescriptorsNode) */;
                    lock.unlock();
                    hasLock = false;
                    return getDefault(arguments0Value, this.getDefault_recursive_);
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
                GetForeignObject0Data s2_ = this.getForeignObject0_cache;
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
            s[0] = "getJSObject";
            if ((state & 0b1) != 0 /* is-active getJSObject(DynamicObject, JSGetOwnPropertyNode, ListSizeNode, ListGetNode, JSClassProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                GetJSObjectData s1_ = this.getJSObject_cache;
                if (s1_ != null) {
                    cached.add(Arrays.asList(s1_.getOwnPropertyNode_, s1_.listSize_, s1_.listGet_, s1_.classProfile_));
                }
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "getForeignObject";
            if ((state & 0b10) != 0 /* is-active getForeignObject(Object, InteropLibrary, InteropLibrary, ImportValueNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                GetForeignObject0Data s2_ = this.getForeignObject0_cache;
                while (s2_ != null) {
                    cached.add(Arrays.asList(s2_.interop_, s2_.members_, s2_.toJSType_));
                    s2_ = s2_.next_;
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-excluded getForeignObject(Object, InteropLibrary, InteropLibrary, ImportValueNode) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "getForeignObject";
            if ((state & 0b100) != 0 /* is-active getForeignObject(Object, InteropLibrary, InteropLibrary, ImportValueNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.getForeignObject1_members_, this.getForeignObject1_toJSType_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "getDefault";
            if ((state & 0b1000) != 0 /* is-active getDefault(Object, ObjectGetOwnPropertyDescriptorsNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.getDefault_recursive_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            return Provider.create(data);
        }

        public static ObjectGetOwnPropertyDescriptorsNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ObjectGetOwnPropertyDescriptorsNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(ObjectGetOwnPropertyDescriptorsNode.class)
        private static final class GetJSObjectData extends Node {

            @Child JSGetOwnPropertyNode getOwnPropertyNode_;
            @Child ListSizeNode listSize_;
            @Child ListGetNode listGet_;
            @CompilationFinal JSClassProfile classProfile_;

            GetJSObjectData() {
            }

            @Override
            public NodeCost getCost() {
                return NodeCost.NONE;
            }

            <T extends Node> T insertAccessor(T node) {
                return super.insert(node);
            }

        }
        @GeneratedBy(ObjectGetOwnPropertyDescriptorsNode.class)
        private static final class GetForeignObject0Data extends Node {

            @Child GetForeignObject0Data next_;
            @Child InteropLibrary interop_;
            @Child InteropLibrary members_;
            @Child ImportValueNode toJSType_;

            GetForeignObject0Data(GetForeignObject0Data next_) {
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
    @GeneratedBy(ObjectGetOwnPropertyNamesOrSymbolsNode.class)
    public static final class ObjectGetOwnPropertyNamesOrSymbolsNodeGen extends ObjectGetOwnPropertyNamesOrSymbolsNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_;
        @CompilationFinal private volatile int exclude_;
        @CompilationFinal private JSClassProfile jsclassProfile;
        @Child private GetForeignObjectNames0Data getForeignObjectNames0_cache;
        @Child private InteropLibrary getForeignObjectNames1_members_;

        private ObjectGetOwnPropertyNamesOrSymbolsNodeGen(JSContext context, JSBuiltin builtin, boolean symbols, JavaScriptNode[] arguments) {
            super(context, builtin, symbols);
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
            if ((state & 0b1) != 0 /* is-active getJSObject(DynamicObject, JSClassProfile) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((JSGuards.isJSObject(arguments0Value__))) {
                    return getJSObject(arguments0Value__, this.jsclassProfile);
                }
            }
            if ((state & 0b11110) != 0 /* is-active getDefault(Object, JSClassProfile) || getForeignObjectSymbols(Object) || getForeignObjectNames(Object, InteropLibrary, InteropLibrary) || getForeignObjectNames(Object, InteropLibrary, InteropLibrary) */) {
                if ((state & 0b10) != 0 /* is-active getDefault(Object, JSClassProfile) */) {
                    if ((!(JSGuards.isJSObject(arguments0Value_))) && (!(JSGuards.isForeignObject(arguments0Value_)))) {
                        return getDefault(arguments0Value_, this.jsclassProfile);
                    }
                }
                if ((state & 0b100) != 0 /* is-active getForeignObjectSymbols(Object) */) {
                    if ((JSGuards.isForeignObject(arguments0Value_))) {
                        assert (symbols);
                        return getForeignObjectSymbols(arguments0Value_);
                    }
                }
                if ((state & 0b1000) != 0 /* is-active getForeignObjectNames(Object, InteropLibrary, InteropLibrary) */) {
                    GetForeignObjectNames0Data s4_ = this.getForeignObjectNames0_cache;
                    while (s4_ != null) {
                        if ((s4_.interop_.accepts(arguments0Value_)) && (JSGuards.isForeignObject(arguments0Value_))) {
                            assert (!(symbols));
                            return getForeignObjectNames(arguments0Value_, s4_.interop_, s4_.members_);
                        }
                        s4_ = s4_.next_;
                    }
                }
                if ((state & 0b10000) != 0 /* is-active getForeignObjectNames(Object, InteropLibrary, InteropLibrary) */) {
                    if ((JSGuards.isForeignObject(arguments0Value_))) {
                        assert (!(symbols));
                        return this.getForeignObjectNames1Boundary(state, arguments0Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @TruffleBoundary
        private Object getForeignObjectNames1Boundary(int state, Object arguments0Value_) {
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(this);
            try {
                {
                    InteropLibrary getForeignObjectNames1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value_));
                    return getForeignObjectNames(arguments0Value_, getForeignObjectNames1_interop__, this.getForeignObjectNames1_members_);
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

        private DynamicObject executeAndSpecialize(Object arguments0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int exclude = exclude_;
            try {
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSObject(arguments0Value_))) {
                        if (this.jsclassProfile == null) {
                            this.jsclassProfile = (JSClassProfile.create());
                        }
                        this.state_ = state = state | 0b1 /* add-active getJSObject(DynamicObject, JSClassProfile) */;
                        lock.unlock();
                        hasLock = false;
                        return getJSObject(arguments0Value_, this.jsclassProfile);
                    }
                }
                if ((!(JSGuards.isJSObject(arguments0Value))) && (!(JSGuards.isForeignObject(arguments0Value)))) {
                    if (this.jsclassProfile == null) {
                        this.jsclassProfile = (JSClassProfile.create());
                    }
                    this.state_ = state = state | 0b10 /* add-active getDefault(Object, JSClassProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return getDefault(arguments0Value, this.jsclassProfile);
                }
                if ((JSGuards.isForeignObject(arguments0Value)) && (symbols)) {
                    this.state_ = state = state | 0b100 /* add-active getForeignObjectSymbols(Object) */;
                    lock.unlock();
                    hasLock = false;
                    return getForeignObjectSymbols(arguments0Value);
                }
                if ((exclude) == 0 /* is-not-excluded getForeignObjectNames(Object, InteropLibrary, InteropLibrary) */) {
                    int count4_ = 0;
                    GetForeignObjectNames0Data s4_ = this.getForeignObjectNames0_cache;
                    if ((state & 0b1000) != 0 /* is-active getForeignObjectNames(Object, InteropLibrary, InteropLibrary) */) {
                        while (s4_ != null) {
                            if ((s4_.interop_.accepts(arguments0Value)) && (JSGuards.isForeignObject(arguments0Value))) {
                                assert (!(symbols));
                                break;
                            }
                            s4_ = s4_.next_;
                            count4_++;
                        }
                    }
                    if (s4_ == null) {
                        if ((JSGuards.isForeignObject(arguments0Value)) && (!(symbols)) && count4_ < (3)) {
                            // assert (s4_.interop_.accepts(arguments0Value));
                            s4_ = super.insert(new GetForeignObjectNames0Data(getForeignObjectNames0_cache));
                            s4_.interop_ = s4_.insertAccessor((INTEROP_LIBRARY_.create(arguments0Value)));
                            s4_.members_ = s4_.insertAccessor((INTEROP_LIBRARY_.createDispatched(3)));
                            this.getForeignObjectNames0_cache = s4_;
                            this.state_ = state = state | 0b1000 /* add-active getForeignObjectNames(Object, InteropLibrary, InteropLibrary) */;
                        }
                    }
                    if (s4_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return getForeignObjectNames(arguments0Value, s4_.interop_, s4_.members_);
                    }
                }
                {
                    InteropLibrary getForeignObjectNames1_interop__ = null;
                    {
                        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                        Node prev_ = encapsulating_.set(this);
                        try {
                            if ((JSGuards.isForeignObject(arguments0Value)) && (!(symbols))) {
                                getForeignObjectNames1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value));
                                this.getForeignObjectNames1_members_ = super.insert((INTEROP_LIBRARY_.createDispatched(3)));
                                this.exclude_ = exclude = exclude | 0b1 /* add-excluded getForeignObjectNames(Object, InteropLibrary, InteropLibrary) */;
                                this.getForeignObjectNames0_cache = null;
                                state = state & 0xfffffff7 /* remove-active getForeignObjectNames(Object, InteropLibrary, InteropLibrary) */;
                                this.state_ = state = state | 0b10000 /* add-active getForeignObjectNames(Object, InteropLibrary, InteropLibrary) */;
                                lock.unlock();
                                hasLock = false;
                                return getForeignObjectNames(arguments0Value, getForeignObjectNames1_interop__, this.getForeignObjectNames1_members_);
                            }
                        } finally {
                            encapsulating_.set(prev_);
                        }
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
            if (state == 0b0) {
                return NodeCost.UNINITIALIZED;
            } else if ((state & (state - 1)) == 0 /* is-single-active  */) {
                GetForeignObjectNames0Data s4_ = this.getForeignObjectNames0_cache;
                if ((s4_ == null || s4_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[6];
            Object[] s;
            data[0] = 0;
            int state = state_;
            int exclude = exclude_;
            s = new Object[3];
            s[0] = "getJSObject";
            if ((state & 0b1) != 0 /* is-active getJSObject(DynamicObject, JSClassProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.jsclassProfile));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "getDefault";
            if ((state & 0b10) != 0 /* is-active getDefault(Object, JSClassProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.jsclassProfile));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "getForeignObjectSymbols";
            if ((state & 0b100) != 0 /* is-active getForeignObjectSymbols(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "getForeignObjectNames";
            if ((state & 0b1000) != 0 /* is-active getForeignObjectNames(Object, InteropLibrary, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                GetForeignObjectNames0Data s4_ = this.getForeignObjectNames0_cache;
                while (s4_ != null) {
                    cached.add(Arrays.asList(s4_.interop_, s4_.members_));
                    s4_ = s4_.next_;
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-excluded getForeignObjectNames(Object, InteropLibrary, InteropLibrary) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            s = new Object[3];
            s[0] = "getForeignObjectNames";
            if ((state & 0b10000) != 0 /* is-active getForeignObjectNames(Object, InteropLibrary, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.getForeignObjectNames1_members_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[5] = s;
            return Provider.create(data);
        }

        public static ObjectGetOwnPropertyNamesOrSymbolsNode create(JSContext context, JSBuiltin builtin, boolean symbols, JavaScriptNode[] arguments) {
            return new ObjectGetOwnPropertyNamesOrSymbolsNodeGen(context, builtin, symbols, arguments);
        }

        @GeneratedBy(ObjectGetOwnPropertyNamesOrSymbolsNode.class)
        private static final class GetForeignObjectNames0Data extends Node {

            @Child GetForeignObjectNames0Data next_;
            @Child InteropLibrary interop_;
            @Child InteropLibrary members_;

            GetForeignObjectNames0Data(GetForeignObjectNames0Data next_) {
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
    @GeneratedBy(ObjectCreateNode.class)
    public static final class ObjectCreateNodeGen extends ObjectCreateNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private int state_;

        private ObjectCreateNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state & 0b11) != 0 /* is-active createPrototypeNull(Object, Object) || createInvalidPrototype(Object, Object) */) {
                if ((state & 0b1) != 0 /* is-active createPrototypeNull(Object, Object) */) {
                    if ((JSGuards.isJSNull(arguments0Value_))) {
                        return createPrototypeNull(arguments0Value_, arguments1Value_);
                    }
                }
                if ((state & 0b10) != 0 /* is-active createInvalidPrototype(Object, Object) */) {
                    if ((!(JSGuards.isJSNull(arguments0Value_))) && (!(JSGuards.isJSObject(arguments0Value_)))) {
                        return createInvalidPrototype(arguments0Value_, arguments1Value_);
                    }
                }
            }
            if ((state & 0b11100) != 0 /* is-active createObjectObject(VirtualFrame, DynamicObject, DynamicObject) || createObjectNotNull(VirtualFrame, DynamicObject, Object) || createObjectNull(DynamicObject, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state & 0b100) != 0 /* is-active createObjectObject(VirtualFrame, DynamicObject, DynamicObject) */ && JSTypes.isDynamicObject(arguments1Value_)) {
                    DynamicObject arguments1Value__ = (DynamicObject) arguments1Value_;
                    if ((JSGuards.isJSObject(arguments0Value__)) && (JSGuards.isJSObject(arguments1Value__))) {
                        return createObjectObject(frameValue, arguments0Value__, arguments1Value__);
                    }
                }
                if ((state & 0b11000) != 0 /* is-active createObjectNotNull(VirtualFrame, DynamicObject, Object) || createObjectNull(DynamicObject, Object) */) {
                    if ((state & 0b1000) != 0 /* is-active createObjectNotNull(VirtualFrame, DynamicObject, Object) */) {
                        if ((JSGuards.isJSObject(arguments0Value__)) && (!(JSGuards.isJSNull(arguments1Value_)))) {
                            return createObjectNotNull(frameValue, arguments0Value__, arguments1Value_);
                        }
                    }
                    if ((state & 0b10000) != 0 /* is-active createObjectNull(DynamicObject, Object) */) {
                        if ((JSGuards.isJSObject(arguments0Value__)) && (JSGuards.isJSNull(arguments1Value_))) {
                            return createObjectNull(arguments0Value__, arguments1Value_);
                        }
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

        private DynamicObject executeAndSpecialize(VirtualFrame frameValue, Object arguments0Value, Object arguments1Value) {
            int state = state_;
            if ((JSGuards.isJSNull(arguments0Value))) {
                this.state_ = state = state | 0b1 /* add-active createPrototypeNull(Object, Object) */;
                return createPrototypeNull(arguments0Value, arguments1Value);
            }
            if ((!(JSGuards.isJSNull(arguments0Value))) && (!(JSGuards.isJSObject(arguments0Value)))) {
                this.state_ = state = state | 0b10 /* add-active createInvalidPrototype(Object, Object) */;
                return createInvalidPrototype(arguments0Value, arguments1Value);
            }
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if (JSTypes.isDynamicObject(arguments1Value)) {
                    DynamicObject arguments1Value_ = (DynamicObject) arguments1Value;
                    if ((JSGuards.isJSObject(arguments0Value_)) && (JSGuards.isJSObject(arguments1Value_))) {
                        this.state_ = state = state | 0b100 /* add-active createObjectObject(VirtualFrame, DynamicObject, DynamicObject) */;
                        return createObjectObject(frameValue, arguments0Value_, arguments1Value_);
                    }
                }
                if ((JSGuards.isJSObject(arguments0Value_)) && (!(JSGuards.isJSNull(arguments1Value)))) {
                    this.state_ = state = state | 0b1000 /* add-active createObjectNotNull(VirtualFrame, DynamicObject, Object) */;
                    return createObjectNotNull(frameValue, arguments0Value_, arguments1Value);
                }
                if ((JSGuards.isJSObject(arguments0Value_)) && (JSGuards.isJSNull(arguments1Value))) {
                    this.state_ = state = state | 0b10000 /* add-active createObjectNull(DynamicObject, Object) */;
                    return createObjectNull(arguments0Value_, arguments1Value);
                }
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
            Object[] data = new Object[6];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "createPrototypeNull";
            if ((state & 0b1) != 0 /* is-active createPrototypeNull(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "createInvalidPrototype";
            if ((state & 0b10) != 0 /* is-active createInvalidPrototype(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "createObjectObject";
            if ((state & 0b100) != 0 /* is-active createObjectObject(VirtualFrame, DynamicObject, DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "createObjectNotNull";
            if ((state & 0b1000) != 0 /* is-active createObjectNotNull(VirtualFrame, DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            s = new Object[3];
            s[0] = "createObjectNull";
            if ((state & 0b10000) != 0 /* is-active createObjectNull(DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[5] = s;
            return Provider.create(data);
        }

        public static ObjectCreateNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ObjectCreateNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ObjectDefinePropertyNode.class)
    public static final class ObjectDefinePropertyNodeGen extends ObjectDefinePropertyNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private int state_;
        @CompilationFinal private int exclude_;

        private ObjectDefinePropertyNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state & 0b11) != 0 /* is-active definePropertyJSObjectString(DynamicObject, String, Object) || definePropertyGeneric(Object, Object, Object) */) {
                if ((state & 0b1) != 0 /* is-active definePropertyJSObjectString(DynamicObject, String, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if (JSTypesGen.isImplicitString((state & 0b111100) >>> 2 /* extract-implicit-active 1:String */, arguments1Value_)) {
                        String arguments1Value__ = JSTypesGen.asImplicitString((state & 0b111100) >>> 2 /* extract-implicit-active 1:String */, arguments1Value_);
                        if ((JSGuards.isJSObject(arguments0Value__))) {
                            return definePropertyJSObjectString(arguments0Value__, arguments1Value__, arguments2Value_);
                        }
                    }
                }
                if ((state & 0b10) != 0 /* is-active definePropertyGeneric(Object, Object, Object) */) {
                    return definePropertyGeneric(arguments0Value_, arguments1Value_, arguments2Value_);
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

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int exclude = exclude_;
            try {
                if ((exclude) == 0 /* is-not-excluded definePropertyJSObjectString(DynamicObject, String, Object) */ && JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    int stringCast1;
                    if ((stringCast1 = JSTypesGen.specializeImplicitString(arguments1Value)) != 0) {
                        String arguments1Value_ = JSTypesGen.asImplicitString(stringCast1, arguments1Value);
                        if ((JSGuards.isJSObject(arguments0Value_))) {
                            state = (state | (stringCast1 << 2) /* set-implicit-active 1:String */);
                            this.state_ = state = state | 0b1 /* add-active definePropertyJSObjectString(DynamicObject, String, Object) */;
                            lock.unlock();
                            hasLock = false;
                            return definePropertyJSObjectString(arguments0Value_, arguments1Value_, arguments2Value);
                        }
                    }
                }
                this.exclude_ = exclude = exclude | 0b1 /* add-excluded definePropertyJSObjectString(DynamicObject, String, Object) */;
                state = state & 0xfffffffe /* remove-active definePropertyJSObjectString(DynamicObject, String, Object) */;
                this.state_ = state = state | 0b10 /* add-active definePropertyGeneric(Object, Object, Object) */;
                lock.unlock();
                hasLock = false;
                return definePropertyGeneric(arguments0Value, arguments1Value, arguments2Value);
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
            s[0] = "definePropertyJSObjectString";
            if ((state & 0b1) != 0 /* is-active definePropertyJSObjectString(DynamicObject, String, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else if (exclude != 0 /* is-excluded definePropertyJSObjectString(DynamicObject, String, Object) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "definePropertyGeneric";
            if ((state & 0b10) != 0 /* is-active definePropertyGeneric(Object, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static ObjectDefinePropertyNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ObjectDefinePropertyNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ObjectDefinePropertiesNode.class)
    public static final class ObjectDefinePropertiesNodeGen extends ObjectDefinePropertiesNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private int state_;
        @CompilationFinal private int exclude_;

        private ObjectDefinePropertiesNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state & 0b1) != 0 /* is-active definePropertiesObjectObject(DynamicObject, DynamicObject) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if (JSTypes.isDynamicObject(arguments1Value_)) {
                    DynamicObject arguments1Value__ = (DynamicObject) arguments1Value_;
                    if ((JSGuards.isJSObject(arguments0Value__)) && (JSGuards.isJSObject(arguments1Value__))) {
                        return definePropertiesObjectObject(arguments0Value__, arguments1Value__);
                    }
                }
            }
            if ((state & 0b10) != 0 /* is-active definePropertiesGeneric(Object, Object) */) {
                return definePropertiesGeneric(arguments0Value_, arguments1Value_);
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
            int exclude = exclude_;
            try {
                if ((exclude) == 0 /* is-not-excluded definePropertiesObjectObject(DynamicObject, DynamicObject) */ && JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if (JSTypes.isDynamicObject(arguments1Value)) {
                        DynamicObject arguments1Value_ = (DynamicObject) arguments1Value;
                        if ((JSGuards.isJSObject(arguments0Value_)) && (JSGuards.isJSObject(arguments1Value_))) {
                            this.state_ = state = state | 0b1 /* add-active definePropertiesObjectObject(DynamicObject, DynamicObject) */;
                            lock.unlock();
                            hasLock = false;
                            return definePropertiesObjectObject(arguments0Value_, arguments1Value_);
                        }
                    }
                }
                this.exclude_ = exclude = exclude | 0b1 /* add-excluded definePropertiesObjectObject(DynamicObject, DynamicObject) */;
                state = state & 0xfffffffe /* remove-active definePropertiesObjectObject(DynamicObject, DynamicObject) */;
                this.state_ = state = state | 0b10 /* add-active definePropertiesGeneric(Object, Object) */;
                lock.unlock();
                hasLock = false;
                return definePropertiesGeneric(arguments0Value, arguments1Value);
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
            int exclude = exclude_;
            s = new Object[3];
            s[0] = "definePropertiesObjectObject";
            if ((state & 0b1) != 0 /* is-active definePropertiesObjectObject(DynamicObject, DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else if (exclude != 0 /* is-excluded definePropertiesObjectObject(DynamicObject, DynamicObject) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "definePropertiesGeneric";
            if ((state & 0b10) != 0 /* is-active definePropertiesGeneric(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static ObjectDefinePropertiesNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ObjectDefinePropertiesNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ObjectIsExtensibleNode.class)
    public static final class ObjectIsExtensibleNodeGen extends ObjectIsExtensibleNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_;
        @Child private IsExtensibleNode isExtensibleObject_isExtensibleNode_;

        private ObjectIsExtensibleNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state & 0b1) != 0 /* is-active isExtensibleObject(DynamicObject, IsExtensibleNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((JSGuards.isJSObject(arguments0Value__))) {
                    return isExtensibleObject(arguments0Value__, this.isExtensibleObject_isExtensibleNode_);
                }
            }
            if ((state & 0b10) != 0 /* is-active isExtensibleNonObject(Object) */) {
                if ((!(JSGuards.isJSObject(arguments0Value_)))) {
                    return isExtensibleNonObject(arguments0Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state & 0b1) != 0 /* is-active isExtensibleObject(DynamicObject, IsExtensibleNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((JSGuards.isJSObject(arguments0Value__))) {
                    return isExtensibleObject(arguments0Value__, this.isExtensibleObject_isExtensibleNode_);
                }
            }
            if ((state & 0b10) != 0 /* is-active isExtensibleNonObject(Object) */) {
                if ((!(JSGuards.isJSObject(arguments0Value_)))) {
                    return isExtensibleNonObject(arguments0Value_);
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
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSObject(arguments0Value_))) {
                        this.isExtensibleObject_isExtensibleNode_ = super.insert((IsExtensibleNode.create()));
                        this.state_ = state = state | 0b1 /* add-active isExtensibleObject(DynamicObject, IsExtensibleNode) */;
                        lock.unlock();
                        hasLock = false;
                        return isExtensibleObject(arguments0Value_, this.isExtensibleObject_isExtensibleNode_);
                    }
                }
                if ((!(JSGuards.isJSObject(arguments0Value)))) {
                    this.state_ = state = state | 0b10 /* add-active isExtensibleNonObject(Object) */;
                    lock.unlock();
                    hasLock = false;
                    return isExtensibleNonObject(arguments0Value);
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
            s[0] = "isExtensibleObject";
            if ((state & 0b1) != 0 /* is-active isExtensibleObject(DynamicObject, IsExtensibleNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.isExtensibleObject_isExtensibleNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "isExtensibleNonObject";
            if ((state & 0b10) != 0 /* is-active isExtensibleNonObject(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static ObjectIsExtensibleNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ObjectIsExtensibleNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ObjectPreventExtensionsNode.class)
    public static final class ObjectPreventExtensionsNodeGen extends ObjectPreventExtensionsNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private int state_;

        private ObjectPreventExtensionsNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state & 0b1) != 0 /* is-active preventExtensionsObject(DynamicObject) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((JSGuards.isJSObject(arguments0Value__))) {
                    return preventExtensionsObject(arguments0Value__);
                }
            }
            if ((state & 0b10) != 0 /* is-active preventExtensionsNonObject(Object) */) {
                if ((!(JSGuards.isJSObject(arguments0Value_)))) {
                    return preventExtensionsNonObject(arguments0Value_);
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
                if ((JSGuards.isJSObject(arguments0Value_))) {
                    this.state_ = state = state | 0b1 /* add-active preventExtensionsObject(DynamicObject) */;
                    return preventExtensionsObject(arguments0Value_);
                }
            }
            if ((!(JSGuards.isJSObject(arguments0Value)))) {
                this.state_ = state = state | 0b10 /* add-active preventExtensionsNonObject(Object) */;
                return preventExtensionsNonObject(arguments0Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_}, arguments0Value);
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
            s[0] = "preventExtensionsObject";
            if ((state & 0b1) != 0 /* is-active preventExtensionsObject(DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "preventExtensionsNonObject";
            if ((state & 0b10) != 0 /* is-active preventExtensionsNonObject(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static ObjectPreventExtensionsNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ObjectPreventExtensionsNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ObjectTestIntegrityLevelNode.class)
    public static final class ObjectTestIntegrityLevelNodeGen extends ObjectTestIntegrityLevelNode implements Provider {

        @Child private JavaScriptNode arguments0_;

        private ObjectTestIntegrityLevelNodeGen(JSContext context, JSBuiltin builtin, boolean frozen, JavaScriptNode[] arguments) {
            super(context, builtin, frozen);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return testIntegrityLevel(arguments0Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return testIntegrityLevel(arguments0Value_);
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
            s[0] = "testIntegrityLevel";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static ObjectTestIntegrityLevelNode create(JSContext context, JSBuiltin builtin, boolean frozen, JavaScriptNode[] arguments) {
            return new ObjectTestIntegrityLevelNodeGen(context, builtin, frozen, arguments);
        }

    }
    @GeneratedBy(ObjectSetIntegrityLevelNode.class)
    public static final class ObjectSetIntegrityLevelNodeGen extends ObjectSetIntegrityLevelNode implements Provider {

        @Child private JavaScriptNode arguments0_;

        private ObjectSetIntegrityLevelNodeGen(JSContext context, JSBuiltin builtin, boolean freeze, JavaScriptNode[] arguments) {
            super(context, builtin, freeze);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return setIntegrityLevel(arguments0Value_);
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
            s[0] = "setIntegrityLevel";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static ObjectSetIntegrityLevelNode create(JSContext context, JSBuiltin builtin, boolean freeze, JavaScriptNode[] arguments) {
            return new ObjectSetIntegrityLevelNodeGen(context, builtin, freeze, arguments);
        }

    }
    @GeneratedBy(ObjectKeysNode.class)
    public static final class ObjectKeysNodeGen extends ObjectKeysNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_;
        @CompilationFinal private volatile int exclude_;
        @Child private KeysForeign0Data keysForeign0_cache;
        @Child private InteropLibrary keysForeign1_members_;
        @CompilationFinal private BranchProfile keysForeign1_growProfile_;

        private ObjectKeysNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state & 0b1) != 0 /* is-active keysDynamicObject(DynamicObject) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((JSGuards.isJSDynamicObject(arguments0Value__))) {
                    return keysDynamicObject(arguments0Value__);
                }
            }
            if ((state & 0b10) != 0 /* is-active keysSymbol(Symbol) */ && arguments0Value_ instanceof Symbol) {
                Symbol arguments0Value__ = (Symbol) arguments0Value_;
                return keysSymbol(arguments0Value__);
            }
            if ((state & 0b100) != 0 /* is-active keysString(JSLazyString) */ && arguments0Value_ instanceof JSLazyString) {
                JSLazyString arguments0Value__ = (JSLazyString) arguments0Value_;
                return keysString(arguments0Value__);
            }
            if ((state & 0b1000) != 0 /* is-active keysSafeInt(SafeInteger) */ && arguments0Value_ instanceof SafeInteger) {
                SafeInteger arguments0Value__ = (SafeInteger) arguments0Value_;
                return keysSafeInt(arguments0Value__);
            }
            if ((state & 0b10000) != 0 /* is-active keysBigInt(BigInt) */ && arguments0Value_ instanceof BigInt) {
                BigInt arguments0Value__ = (BigInt) arguments0Value_;
                return keysBigInt(arguments0Value__);
            }
            if ((state & 0b11100000) != 0 /* is-active keysOther(Object) || keysForeign(Object, InteropLibrary, InteropLibrary, BranchProfile) || keysForeign(Object, InteropLibrary, InteropLibrary, BranchProfile) */) {
                if ((state & 0b100000) != 0 /* is-active keysOther(Object) */) {
                    if ((!(JSGuards.isTruffleObject(arguments0Value_)))) {
                        return keysOther(arguments0Value_);
                    }
                }
                if ((state & 0b1000000) != 0 /* is-active keysForeign(Object, InteropLibrary, InteropLibrary, BranchProfile) */) {
                    KeysForeign0Data s7_ = this.keysForeign0_cache;
                    while (s7_ != null) {
                        if ((s7_.interop_.accepts(arguments0Value_)) && (JSGuards.isForeignObject(arguments0Value_))) {
                            return keysForeign(arguments0Value_, s7_.interop_, s7_.members_, s7_.growProfile_);
                        }
                        s7_ = s7_.next_;
                    }
                }
                if ((state & 0b10000000) != 0 /* is-active keysForeign(Object, InteropLibrary, InteropLibrary, BranchProfile) */) {
                    if ((JSGuards.isForeignObject(arguments0Value_))) {
                        return this.keysForeign1Boundary(state, arguments0Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @TruffleBoundary
        private Object keysForeign1Boundary(int state, Object arguments0Value_) {
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(this);
            try {
                {
                    InteropLibrary keysForeign1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value_));
                    return keysForeign(arguments0Value_, keysForeign1_interop__, this.keysForeign1_members_, this.keysForeign1_growProfile_);
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

        private DynamicObject executeAndSpecialize(Object arguments0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int exclude = exclude_;
            try {
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSDynamicObject(arguments0Value_))) {
                        this.state_ = state = state | 0b1 /* add-active keysDynamicObject(DynamicObject) */;
                        lock.unlock();
                        hasLock = false;
                        return keysDynamicObject(arguments0Value_);
                    }
                }
                if (arguments0Value instanceof Symbol) {
                    Symbol arguments0Value_ = (Symbol) arguments0Value;
                    this.state_ = state = state | 0b10 /* add-active keysSymbol(Symbol) */;
                    lock.unlock();
                    hasLock = false;
                    return keysSymbol(arguments0Value_);
                }
                if (arguments0Value instanceof JSLazyString) {
                    JSLazyString arguments0Value_ = (JSLazyString) arguments0Value;
                    this.state_ = state = state | 0b100 /* add-active keysString(JSLazyString) */;
                    lock.unlock();
                    hasLock = false;
                    return keysString(arguments0Value_);
                }
                if (arguments0Value instanceof SafeInteger) {
                    SafeInteger arguments0Value_ = (SafeInteger) arguments0Value;
                    this.state_ = state = state | 0b1000 /* add-active keysSafeInt(SafeInteger) */;
                    lock.unlock();
                    hasLock = false;
                    return keysSafeInt(arguments0Value_);
                }
                if (arguments0Value instanceof BigInt) {
                    BigInt arguments0Value_ = (BigInt) arguments0Value;
                    this.state_ = state = state | 0b10000 /* add-active keysBigInt(BigInt) */;
                    lock.unlock();
                    hasLock = false;
                    return keysBigInt(arguments0Value_);
                }
                if ((!(JSGuards.isTruffleObject(arguments0Value)))) {
                    this.state_ = state = state | 0b100000 /* add-active keysOther(Object) */;
                    lock.unlock();
                    hasLock = false;
                    return keysOther(arguments0Value);
                }
                if ((exclude) == 0 /* is-not-excluded keysForeign(Object, InteropLibrary, InteropLibrary, BranchProfile) */) {
                    int count7_ = 0;
                    KeysForeign0Data s7_ = this.keysForeign0_cache;
                    if ((state & 0b1000000) != 0 /* is-active keysForeign(Object, InteropLibrary, InteropLibrary, BranchProfile) */) {
                        while (s7_ != null) {
                            if ((s7_.interop_.accepts(arguments0Value)) && (JSGuards.isForeignObject(arguments0Value))) {
                                break;
                            }
                            s7_ = s7_.next_;
                            count7_++;
                        }
                    }
                    if (s7_ == null) {
                        if ((JSGuards.isForeignObject(arguments0Value)) && count7_ < (3)) {
                            // assert (s7_.interop_.accepts(arguments0Value));
                            s7_ = super.insert(new KeysForeign0Data(keysForeign0_cache));
                            s7_.interop_ = s7_.insertAccessor((INTEROP_LIBRARY_.create(arguments0Value)));
                            s7_.members_ = s7_.insertAccessor((INTEROP_LIBRARY_.createDispatched(3)));
                            s7_.growProfile_ = (BranchProfile.create());
                            this.keysForeign0_cache = s7_;
                            this.state_ = state = state | 0b1000000 /* add-active keysForeign(Object, InteropLibrary, InteropLibrary, BranchProfile) */;
                        }
                    }
                    if (s7_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return keysForeign(arguments0Value, s7_.interop_, s7_.members_, s7_.growProfile_);
                    }
                }
                {
                    InteropLibrary keysForeign1_interop__ = null;
                    {
                        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                        Node prev_ = encapsulating_.set(this);
                        try {
                            if ((JSGuards.isForeignObject(arguments0Value))) {
                                keysForeign1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value));
                                this.keysForeign1_members_ = super.insert((INTEROP_LIBRARY_.createDispatched(3)));
                                this.keysForeign1_growProfile_ = (BranchProfile.create());
                                this.exclude_ = exclude = exclude | 0b1 /* add-excluded keysForeign(Object, InteropLibrary, InteropLibrary, BranchProfile) */;
                                this.keysForeign0_cache = null;
                                state = state & 0xffffffbf /* remove-active keysForeign(Object, InteropLibrary, InteropLibrary, BranchProfile) */;
                                this.state_ = state = state | 0b10000000 /* add-active keysForeign(Object, InteropLibrary, InteropLibrary, BranchProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return keysForeign(arguments0Value, keysForeign1_interop__, this.keysForeign1_members_, this.keysForeign1_growProfile_);
                            }
                        } finally {
                            encapsulating_.set(prev_);
                        }
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
            if (state == 0b0) {
                return NodeCost.UNINITIALIZED;
            } else if ((state & (state - 1)) == 0 /* is-single-active  */) {
                KeysForeign0Data s7_ = this.keysForeign0_cache;
                if ((s7_ == null || s7_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[9];
            Object[] s;
            data[0] = 0;
            int state = state_;
            int exclude = exclude_;
            s = new Object[3];
            s[0] = "keysDynamicObject";
            if ((state & 0b1) != 0 /* is-active keysDynamicObject(DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "keysSymbol";
            if ((state & 0b10) != 0 /* is-active keysSymbol(Symbol) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "keysString";
            if ((state & 0b100) != 0 /* is-active keysString(JSLazyString) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "keysSafeInt";
            if ((state & 0b1000) != 0 /* is-active keysSafeInt(SafeInteger) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            s = new Object[3];
            s[0] = "keysBigInt";
            if ((state & 0b10000) != 0 /* is-active keysBigInt(BigInt) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[5] = s;
            s = new Object[3];
            s[0] = "keysOther";
            if ((state & 0b100000) != 0 /* is-active keysOther(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[6] = s;
            s = new Object[3];
            s[0] = "keysForeign";
            if ((state & 0b1000000) != 0 /* is-active keysForeign(Object, InteropLibrary, InteropLibrary, BranchProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                KeysForeign0Data s7_ = this.keysForeign0_cache;
                while (s7_ != null) {
                    cached.add(Arrays.asList(s7_.interop_, s7_.members_, s7_.growProfile_));
                    s7_ = s7_.next_;
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-excluded keysForeign(Object, InteropLibrary, InteropLibrary, BranchProfile) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[7] = s;
            s = new Object[3];
            s[0] = "keysForeign";
            if ((state & 0b10000000) != 0 /* is-active keysForeign(Object, InteropLibrary, InteropLibrary, BranchProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.keysForeign1_members_, this.keysForeign1_growProfile_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[8] = s;
            return Provider.create(data);
        }

        public static ObjectKeysNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ObjectKeysNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(ObjectKeysNode.class)
        private static final class KeysForeign0Data extends Node {

            @Child KeysForeign0Data next_;
            @Child InteropLibrary interop_;
            @Child InteropLibrary members_;
            @CompilationFinal BranchProfile growProfile_;

            KeysForeign0Data(KeysForeign0Data next_) {
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
    @GeneratedBy(ObjectSetPrototypeOfNode.class)
    public static final class ObjectSetPrototypeOfNodeGen extends ObjectSetPrototypeOfNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private int state_;

        private ObjectSetPrototypeOfNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state & 0b11) != 0 /* is-active setPrototypeOfJSObject(JSObject, JSDynamicObject) || setPrototypeOfJSObjectToInvalidNewProto(JSObject, Object) */ && arguments0Value_ instanceof JSObject) {
                JSObject arguments0Value__ = (JSObject) arguments0Value_;
                if ((state & 0b1) != 0 /* is-active setPrototypeOfJSObject(JSObject, JSDynamicObject) */ && arguments1Value_ instanceof JSDynamicObject) {
                    JSDynamicObject arguments1Value__ = (JSDynamicObject) arguments1Value_;
                    if ((JSGuards.isValidPrototype(arguments1Value__))) {
                        return setPrototypeOfJSObject(arguments0Value__, arguments1Value__);
                    }
                }
                if ((state & 0b10) != 0 /* is-active setPrototypeOfJSObjectToInvalidNewProto(JSObject, Object) */) {
                    if ((!(JSGuards.isValidPrototype(arguments1Value_)))) {
                        return ObjectSetPrototypeOfNode.setPrototypeOfJSObjectToInvalidNewProto(arguments0Value__, arguments1Value_);
                    }
                }
            }
            if ((state & 0b11100) != 0 /* is-active setPrototypeOfNonObjectCoercible(Object, Object) || setPrototypeOfValue(Object, Object) || setPrototypeOfForeignObject(Object, Object) */) {
                if ((state & 0b100) != 0 /* is-active setPrototypeOfNonObjectCoercible(Object, Object) */) {
                    if ((JSGuards.isNullOrUndefined(arguments0Value_))) {
                        return setPrototypeOfNonObjectCoercible(arguments0Value_, arguments1Value_);
                    }
                }
                if ((state & 0b1000) != 0 /* is-active setPrototypeOfValue(Object, Object) */) {
                    if ((!(JSGuards.isJSObject(arguments0Value_))) && (!(JSGuards.isNullOrUndefined(arguments0Value_))) && (!(JSGuards.isForeignObject(arguments0Value_)))) {
                        return ObjectSetPrototypeOfNode.setPrototypeOfValue(arguments0Value_, arguments1Value_);
                    }
                }
                if ((state & 0b10000) != 0 /* is-active setPrototypeOfForeignObject(Object, Object) */) {
                    if ((JSGuards.isForeignObject(arguments0Value_))) {
                        return setPrototypeOfForeignObject(arguments0Value_, arguments1Value_);
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
            if (arguments0Value instanceof JSObject) {
                JSObject arguments0Value_ = (JSObject) arguments0Value;
                if (arguments1Value instanceof JSDynamicObject) {
                    JSDynamicObject arguments1Value_ = (JSDynamicObject) arguments1Value;
                    if ((JSGuards.isValidPrototype(arguments1Value_))) {
                        this.state_ = state = state | 0b1 /* add-active setPrototypeOfJSObject(JSObject, JSDynamicObject) */;
                        return setPrototypeOfJSObject(arguments0Value_, arguments1Value_);
                    }
                }
                if ((!(JSGuards.isValidPrototype(arguments1Value)))) {
                    this.state_ = state = state | 0b10 /* add-active setPrototypeOfJSObjectToInvalidNewProto(JSObject, Object) */;
                    return ObjectSetPrototypeOfNode.setPrototypeOfJSObjectToInvalidNewProto(arguments0Value_, arguments1Value);
                }
            }
            if ((JSGuards.isNullOrUndefined(arguments0Value))) {
                this.state_ = state = state | 0b100 /* add-active setPrototypeOfNonObjectCoercible(Object, Object) */;
                return setPrototypeOfNonObjectCoercible(arguments0Value, arguments1Value);
            }
            if ((!(JSGuards.isJSObject(arguments0Value))) && (!(JSGuards.isNullOrUndefined(arguments0Value))) && (!(JSGuards.isForeignObject(arguments0Value)))) {
                this.state_ = state = state | 0b1000 /* add-active setPrototypeOfValue(Object, Object) */;
                return ObjectSetPrototypeOfNode.setPrototypeOfValue(arguments0Value, arguments1Value);
            }
            if ((JSGuards.isForeignObject(arguments0Value))) {
                this.state_ = state = state | 0b10000 /* add-active setPrototypeOfForeignObject(Object, Object) */;
                return setPrototypeOfForeignObject(arguments0Value, arguments1Value);
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
            Object[] data = new Object[6];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "setPrototypeOfJSObject";
            if ((state & 0b1) != 0 /* is-active setPrototypeOfJSObject(JSObject, JSDynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "setPrototypeOfJSObjectToInvalidNewProto";
            if ((state & 0b10) != 0 /* is-active setPrototypeOfJSObjectToInvalidNewProto(JSObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "setPrototypeOfNonObjectCoercible";
            if ((state & 0b100) != 0 /* is-active setPrototypeOfNonObjectCoercible(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "setPrototypeOfValue";
            if ((state & 0b1000) != 0 /* is-active setPrototypeOfValue(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            s = new Object[3];
            s[0] = "setPrototypeOfForeignObject";
            if ((state & 0b10000) != 0 /* is-active setPrototypeOfForeignObject(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[5] = s;
            return Provider.create(data);
        }

        public static ObjectSetPrototypeOfNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ObjectSetPrototypeOfNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ObjectIsNode.class)
    public static final class ObjectIsNodeGen extends ObjectIsNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_;
        @Child private JSIdenticalNode isNumberNumber_doIdenticalNode_;
        @Child private JSIdenticalNode isObject_doIdenticalNode_;

        private ObjectIsNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state & 0b1110) == 0 /* only-active isInt(int, int) */ && (state & 0b1111) != 0  /* is-not isInt(int, int) && isDouble(double, double) && isNumberNumber(Number, Number, JSIdenticalNode) && isObject(Object, Object, JSIdenticalNode) */) {
                return execute_int_int0(frameValue, state);
            } else if ((state & 0b1101) == 0 /* only-active isDouble(double, double) */ && (state & 0b1111) != 0  /* is-not isInt(int, int) && isDouble(double, double) && isNumberNumber(Number, Number, JSIdenticalNode) && isObject(Object, Object, JSIdenticalNode) */) {
                return execute_double_double1(frameValue, state);
            } else {
                return execute_generic2(frameValue, state);
            }
        }

        private Object execute_int_int0(VirtualFrame frameValue, int state) {
            int arguments0Value_;
            try {
                arguments0Value_ = this.arguments0_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                Object arguments1Value = this.arguments1_.execute(frameValue);
                return executeAndSpecialize(ex.getResult(), arguments1Value);
            }
            int arguments1Value_;
            try {
                arguments1Value_ = this.arguments1_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(arguments0Value_, ex.getResult());
            }
            assert (state & 0b1) != 0 /* is-active isInt(int, int) */;
            return isInt(arguments0Value_, arguments1Value_);
        }

        private Object execute_double_double1(VirtualFrame frameValue, int state) {
            int arguments0Value_int = 0;
            long arguments0Value_long = 0L;
            double arguments0Value_;
            try {
                if ((state & 0b11100000) == 0 /* only-active 0:double */ && (state & 0b1111) != 0  /* is-not isInt(int, int) && isDouble(double, double) && isNumberNumber(Number, Number, JSIdenticalNode) && isObject(Object, Object, JSIdenticalNode) */) {
                    arguments0Value_long = this.arguments0_.executeLong(frameValue);
                    arguments0Value_ = JSTypes.longToDouble(arguments0Value_long);
                } else if ((state & 0b11010000) == 0 /* only-active 0:double */ && (state & 0b1111) != 0  /* is-not isInt(int, int) && isDouble(double, double) && isNumberNumber(Number, Number, JSIdenticalNode) && isObject(Object, Object, JSIdenticalNode) */) {
                    arguments0Value_int = this.arguments0_.executeInt(frameValue);
                    arguments0Value_ = JSTypes.intToDouble(arguments0Value_int);
                } else if ((state & 0b10110000) == 0 /* only-active 0:double */ && (state & 0b1111) != 0  /* is-not isInt(int, int) && isDouble(double, double) && isNumberNumber(Number, Number, JSIdenticalNode) && isObject(Object, Object, JSIdenticalNode) */) {
                    arguments0Value_ = this.arguments0_.executeDouble(frameValue);
                } else {
                    Object arguments0Value__ = this.arguments0_.execute(frameValue);
                    arguments0Value_ = JSTypesGen.expectImplicitDouble((state & 0b11110000) >>> 4 /* extract-implicit-active 0:double */, arguments0Value__);
                }
            } catch (UnexpectedResultException ex) {
                Object arguments1Value = this.arguments1_.execute(frameValue);
                return executeAndSpecialize(ex.getResult(), arguments1Value);
            }
            int arguments1Value_int = 0;
            long arguments1Value_long = 0L;
            double arguments1Value_;
            try {
                if ((state & 0b111000000000) == 0 /* only-active 1:double */ && (state & 0b1111) != 0  /* is-not isInt(int, int) && isDouble(double, double) && isNumberNumber(Number, Number, JSIdenticalNode) && isObject(Object, Object, JSIdenticalNode) */) {
                    arguments1Value_long = this.arguments1_.executeLong(frameValue);
                    arguments1Value_ = JSTypes.longToDouble(arguments1Value_long);
                } else if ((state & 0b110100000000) == 0 /* only-active 1:double */ && (state & 0b1111) != 0  /* is-not isInt(int, int) && isDouble(double, double) && isNumberNumber(Number, Number, JSIdenticalNode) && isObject(Object, Object, JSIdenticalNode) */) {
                    arguments1Value_int = this.arguments1_.executeInt(frameValue);
                    arguments1Value_ = JSTypes.intToDouble(arguments1Value_int);
                } else if ((state & 0b101100000000) == 0 /* only-active 1:double */ && (state & 0b1111) != 0  /* is-not isInt(int, int) && isDouble(double, double) && isNumberNumber(Number, Number, JSIdenticalNode) && isObject(Object, Object, JSIdenticalNode) */) {
                    arguments1Value_ = this.arguments1_.executeDouble(frameValue);
                } else {
                    Object arguments1Value__ = this.arguments1_.execute(frameValue);
                    arguments1Value_ = JSTypesGen.expectImplicitDouble((state & 0b111100000000) >>> 8 /* extract-implicit-active 1:double */, arguments1Value__);
                }
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(((state & 0b11100000) == 0 /* only-active 0:double */ && (state & 0b1111) != 0  /* is-not isInt(int, int) && isDouble(double, double) && isNumberNumber(Number, Number, JSIdenticalNode) && isObject(Object, Object, JSIdenticalNode) */ ? (Object) arguments0Value_long : ((state & 0b11010000) == 0 /* only-active 0:double */ && (state & 0b1111) != 0  /* is-not isInt(int, int) && isDouble(double, double) && isNumberNumber(Number, Number, JSIdenticalNode) && isObject(Object, Object, JSIdenticalNode) */ ? (Object) arguments0Value_int : (Object) arguments0Value_)), ex.getResult());
            }
            assert (state & 0b10) != 0 /* is-active isDouble(double, double) */;
            return isDouble(arguments0Value_, arguments1Value_);
        }

        private Object execute_generic2(VirtualFrame frameValue, int state) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if ((state & 0b1) != 0 /* is-active isInt(int, int) */ && arguments0Value_ instanceof Integer) {
                int arguments0Value__ = (int) arguments0Value_;
                if (arguments1Value_ instanceof Integer) {
                    int arguments1Value__ = (int) arguments1Value_;
                    return isInt(arguments0Value__, arguments1Value__);
                }
            }
            if ((state & 0b10) != 0 /* is-active isDouble(double, double) */ && JSTypesGen.isImplicitDouble((state & 0b11110000) >>> 4 /* extract-implicit-active 0:double */, arguments0Value_)) {
                double arguments0Value__ = JSTypesGen.asImplicitDouble((state & 0b11110000) >>> 4 /* extract-implicit-active 0:double */, arguments0Value_);
                if (JSTypesGen.isImplicitDouble((state & 0b111100000000) >>> 8 /* extract-implicit-active 1:double */, arguments1Value_)) {
                    double arguments1Value__ = JSTypesGen.asImplicitDouble((state & 0b111100000000) >>> 8 /* extract-implicit-active 1:double */, arguments1Value_);
                    return isDouble(arguments0Value__, arguments1Value__);
                }
            }
            if ((state & 0b100) != 0 /* is-active isNumberNumber(Number, Number, JSIdenticalNode) */ && arguments0Value_ instanceof Number) {
                Number arguments0Value__ = (Number) arguments0Value_;
                if (arguments1Value_ instanceof Number) {
                    Number arguments1Value__ = (Number) arguments1Value_;
                    if ((isNumberNumber(arguments0Value__, arguments1Value__))) {
                        return isNumberNumber(arguments0Value__, arguments1Value__, this.isNumberNumber_doIdenticalNode_);
                    }
                }
            }
            if ((state & 0b1000) != 0 /* is-active isObject(Object, Object, JSIdenticalNode) */) {
                if ((!(isNumberNumber(arguments0Value_, arguments1Value_)))) {
                    return isObject(arguments0Value_, arguments1Value_, this.isObject_doIdenticalNode_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            int state = state_;
            if ((state & 0b1110) == 0 /* only-active isInt(int, int) */ && (state & 0b1111) != 0  /* is-not isInt(int, int) && isDouble(double, double) && isNumberNumber(Number, Number, JSIdenticalNode) && isObject(Object, Object, JSIdenticalNode) */) {
                return executeBoolean_int_int3(frameValue, state);
            } else if ((state & 0b1101) == 0 /* only-active isDouble(double, double) */ && (state & 0b1111) != 0  /* is-not isInt(int, int) && isDouble(double, double) && isNumberNumber(Number, Number, JSIdenticalNode) && isObject(Object, Object, JSIdenticalNode) */) {
                return executeBoolean_double_double4(frameValue, state);
            } else {
                return executeBoolean_generic5(frameValue, state);
            }
        }

        private boolean executeBoolean_int_int3(VirtualFrame frameValue, int state) {
            int arguments0Value_;
            try {
                arguments0Value_ = this.arguments0_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                Object arguments1Value = this.arguments1_.execute(frameValue);
                return executeAndSpecialize(ex.getResult(), arguments1Value);
            }
            int arguments1Value_;
            try {
                arguments1Value_ = this.arguments1_.executeInt(frameValue);
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(arguments0Value_, ex.getResult());
            }
            assert (state & 0b1) != 0 /* is-active isInt(int, int) */;
            return isInt(arguments0Value_, arguments1Value_);
        }

        private boolean executeBoolean_double_double4(VirtualFrame frameValue, int state) {
            int arguments0Value_int = 0;
            long arguments0Value_long = 0L;
            double arguments0Value_;
            try {
                if ((state & 0b11100000) == 0 /* only-active 0:double */ && (state & 0b1111) != 0  /* is-not isInt(int, int) && isDouble(double, double) && isNumberNumber(Number, Number, JSIdenticalNode) && isObject(Object, Object, JSIdenticalNode) */) {
                    arguments0Value_long = this.arguments0_.executeLong(frameValue);
                    arguments0Value_ = JSTypes.longToDouble(arguments0Value_long);
                } else if ((state & 0b11010000) == 0 /* only-active 0:double */ && (state & 0b1111) != 0  /* is-not isInt(int, int) && isDouble(double, double) && isNumberNumber(Number, Number, JSIdenticalNode) && isObject(Object, Object, JSIdenticalNode) */) {
                    arguments0Value_int = this.arguments0_.executeInt(frameValue);
                    arguments0Value_ = JSTypes.intToDouble(arguments0Value_int);
                } else if ((state & 0b10110000) == 0 /* only-active 0:double */ && (state & 0b1111) != 0  /* is-not isInt(int, int) && isDouble(double, double) && isNumberNumber(Number, Number, JSIdenticalNode) && isObject(Object, Object, JSIdenticalNode) */) {
                    arguments0Value_ = this.arguments0_.executeDouble(frameValue);
                } else {
                    Object arguments0Value__ = this.arguments0_.execute(frameValue);
                    arguments0Value_ = JSTypesGen.expectImplicitDouble((state & 0b11110000) >>> 4 /* extract-implicit-active 0:double */, arguments0Value__);
                }
            } catch (UnexpectedResultException ex) {
                Object arguments1Value = this.arguments1_.execute(frameValue);
                return executeAndSpecialize(ex.getResult(), arguments1Value);
            }
            int arguments1Value_int = 0;
            long arguments1Value_long = 0L;
            double arguments1Value_;
            try {
                if ((state & 0b111000000000) == 0 /* only-active 1:double */ && (state & 0b1111) != 0  /* is-not isInt(int, int) && isDouble(double, double) && isNumberNumber(Number, Number, JSIdenticalNode) && isObject(Object, Object, JSIdenticalNode) */) {
                    arguments1Value_long = this.arguments1_.executeLong(frameValue);
                    arguments1Value_ = JSTypes.longToDouble(arguments1Value_long);
                } else if ((state & 0b110100000000) == 0 /* only-active 1:double */ && (state & 0b1111) != 0  /* is-not isInt(int, int) && isDouble(double, double) && isNumberNumber(Number, Number, JSIdenticalNode) && isObject(Object, Object, JSIdenticalNode) */) {
                    arguments1Value_int = this.arguments1_.executeInt(frameValue);
                    arguments1Value_ = JSTypes.intToDouble(arguments1Value_int);
                } else if ((state & 0b101100000000) == 0 /* only-active 1:double */ && (state & 0b1111) != 0  /* is-not isInt(int, int) && isDouble(double, double) && isNumberNumber(Number, Number, JSIdenticalNode) && isObject(Object, Object, JSIdenticalNode) */) {
                    arguments1Value_ = this.arguments1_.executeDouble(frameValue);
                } else {
                    Object arguments1Value__ = this.arguments1_.execute(frameValue);
                    arguments1Value_ = JSTypesGen.expectImplicitDouble((state & 0b111100000000) >>> 8 /* extract-implicit-active 1:double */, arguments1Value__);
                }
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(((state & 0b11100000) == 0 /* only-active 0:double */ && (state & 0b1111) != 0  /* is-not isInt(int, int) && isDouble(double, double) && isNumberNumber(Number, Number, JSIdenticalNode) && isObject(Object, Object, JSIdenticalNode) */ ? (Object) arguments0Value_long : ((state & 0b11010000) == 0 /* only-active 0:double */ && (state & 0b1111) != 0  /* is-not isInt(int, int) && isDouble(double, double) && isNumberNumber(Number, Number, JSIdenticalNode) && isObject(Object, Object, JSIdenticalNode) */ ? (Object) arguments0Value_int : (Object) arguments0Value_)), ex.getResult());
            }
            assert (state & 0b10) != 0 /* is-active isDouble(double, double) */;
            return isDouble(arguments0Value_, arguments1Value_);
        }

        private boolean executeBoolean_generic5(VirtualFrame frameValue, int state) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if ((state & 0b1) != 0 /* is-active isInt(int, int) */ && arguments0Value_ instanceof Integer) {
                int arguments0Value__ = (int) arguments0Value_;
                if (arguments1Value_ instanceof Integer) {
                    int arguments1Value__ = (int) arguments1Value_;
                    return isInt(arguments0Value__, arguments1Value__);
                }
            }
            if ((state & 0b10) != 0 /* is-active isDouble(double, double) */ && JSTypesGen.isImplicitDouble((state & 0b11110000) >>> 4 /* extract-implicit-active 0:double */, arguments0Value_)) {
                double arguments0Value__ = JSTypesGen.asImplicitDouble((state & 0b11110000) >>> 4 /* extract-implicit-active 0:double */, arguments0Value_);
                if (JSTypesGen.isImplicitDouble((state & 0b111100000000) >>> 8 /* extract-implicit-active 1:double */, arguments1Value_)) {
                    double arguments1Value__ = JSTypesGen.asImplicitDouble((state & 0b111100000000) >>> 8 /* extract-implicit-active 1:double */, arguments1Value_);
                    return isDouble(arguments0Value__, arguments1Value__);
                }
            }
            if ((state & 0b100) != 0 /* is-active isNumberNumber(Number, Number, JSIdenticalNode) */ && arguments0Value_ instanceof Number) {
                Number arguments0Value__ = (Number) arguments0Value_;
                if (arguments1Value_ instanceof Number) {
                    Number arguments1Value__ = (Number) arguments1Value_;
                    if ((isNumberNumber(arguments0Value__, arguments1Value__))) {
                        return isNumberNumber(arguments0Value__, arguments1Value__, this.isNumberNumber_doIdenticalNode_);
                    }
                }
            }
            if ((state & 0b1000) != 0 /* is-active isObject(Object, Object, JSIdenticalNode) */) {
                if ((!(isNumberNumber(arguments0Value_, arguments1Value_)))) {
                    return isObject(arguments0Value_, arguments1Value_, this.isObject_doIdenticalNode_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
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
            try {
                if (arguments0Value instanceof Integer) {
                    int arguments0Value_ = (int) arguments0Value;
                    if (arguments1Value instanceof Integer) {
                        int arguments1Value_ = (int) arguments1Value;
                        this.state_ = state = state | 0b1 /* add-active isInt(int, int) */;
                        lock.unlock();
                        hasLock = false;
                        return isInt(arguments0Value_, arguments1Value_);
                    }
                }
                {
                    int doubleCast0;
                    if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(arguments0Value)) != 0) {
                        double arguments0Value_ = JSTypesGen.asImplicitDouble(doubleCast0, arguments0Value);
                        int doubleCast1;
                        if ((doubleCast1 = JSTypesGen.specializeImplicitDouble(arguments1Value)) != 0) {
                            double arguments1Value_ = JSTypesGen.asImplicitDouble(doubleCast1, arguments1Value);
                            state = (state | (doubleCast0 << 4) /* set-implicit-active 0:double */);
                            state = (state | (doubleCast1 << 8) /* set-implicit-active 1:double */);
                            this.state_ = state = state | 0b10 /* add-active isDouble(double, double) */;
                            lock.unlock();
                            hasLock = false;
                            return isDouble(arguments0Value_, arguments1Value_);
                        }
                    }
                }
                if (arguments0Value instanceof Number) {
                    Number arguments0Value_ = (Number) arguments0Value;
                    if (arguments1Value instanceof Number) {
                        Number arguments1Value_ = (Number) arguments1Value;
                        if ((isNumberNumber(arguments0Value_, arguments1Value_))) {
                            this.isNumberNumber_doIdenticalNode_ = super.insert((JSIdenticalNode.createSameValue()));
                            this.state_ = state = state | 0b100 /* add-active isNumberNumber(Number, Number, JSIdenticalNode) */;
                            lock.unlock();
                            hasLock = false;
                            return isNumberNumber(arguments0Value_, arguments1Value_, this.isNumberNumber_doIdenticalNode_);
                        }
                    }
                }
                if ((!(isNumberNumber(arguments0Value, arguments1Value)))) {
                    this.isObject_doIdenticalNode_ = super.insert((JSIdenticalNode.createSameValue()));
                    this.state_ = state = state | 0b1000 /* add-active isObject(Object, Object, JSIdenticalNode) */;
                    lock.unlock();
                    hasLock = false;
                    return isObject(arguments0Value, arguments1Value, this.isObject_doIdenticalNode_);
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
            s[0] = "isInt";
            if ((state & 0b1) != 0 /* is-active isInt(int, int) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "isDouble";
            if ((state & 0b10) != 0 /* is-active isDouble(double, double) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "isNumberNumber";
            if ((state & 0b100) != 0 /* is-active isNumberNumber(Number, Number, JSIdenticalNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.isNumberNumber_doIdenticalNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "isObject";
            if ((state & 0b1000) != 0 /* is-active isObject(Object, Object, JSIdenticalNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.isObject_doIdenticalNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            return Provider.create(data);
        }

        public static ObjectIsNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ObjectIsNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ObjectAssignNode.class)
    public static final class ObjectAssignNodeGen extends ObjectAssignNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_;
        @Child private AssignData assign_cache;

        private ObjectAssignNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state != 0 /* is-active assign(Object, Object[], JSToObjectNode, WriteElementNode, AssignPropertiesNode) */ && arguments1Value_ instanceof Object[]) {
                Object[] arguments1Value__ = (Object[]) arguments1Value_;
                AssignData s1_ = this.assign_cache;
                if (s1_ != null) {
                    return assign(arguments0Value_, arguments1Value__, s1_.toObjectNode_, s1_.write_, s1_.assignProperties_);
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
                    AssignData s1_ = super.insert(new AssignData());
                    s1_.toObjectNode_ = s1_.insertAccessor((JSToObjectNode.createToObject(getContext())));
                    s1_.write_ = s1_.insertAccessor((WriteElementNode.create(getContext(), ObjectAssignNode.STRICT)));
                    s1_.assignProperties_ = s1_.insertAccessor((AssignPropertiesNodeGen.create(getContext())));
                    this.assign_cache = s1_;
                    this.state_ = state = state | 0b1 /* add-active assign(Object, Object[], JSToObjectNode, WriteElementNode, AssignPropertiesNode) */;
                    lock.unlock();
                    hasLock = false;
                    return assign(arguments0Value, arguments1Value_, s1_.toObjectNode_, s1_.write_, s1_.assignProperties_);
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
            s[0] = "assign";
            if (state != 0 /* is-active assign(Object, Object[], JSToObjectNode, WriteElementNode, AssignPropertiesNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                AssignData s1_ = this.assign_cache;
                if (s1_ != null) {
                    cached.add(Arrays.asList(s1_.toObjectNode_, s1_.write_, s1_.assignProperties_));
                }
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static ObjectAssignNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ObjectAssignNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(ObjectAssignNode.class)
        private static final class AssignData extends Node {

            @Child JSToObjectNode toObjectNode_;
            @Child WriteElementNode write_;
            @Child AssignPropertiesNode assignProperties_;

            AssignData() {
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
    @GeneratedBy(AssignPropertiesNode.class)
    static final class AssignPropertiesNodeGen extends AssignPropertiesNode implements Provider {

        @CompilationFinal private volatile int state_;
        @CompilationFinal private volatile int exclude_;
        @Child private CopyPropertiesFromJSObjectData copyPropertiesFromJSObject_cache;
        @Child private Object0Data object0_cache;
        @Child private InteropLibrary object1_keysInterop_;
        @Child private InteropLibrary object1_stringInterop_;

        private AssignPropertiesNodeGen(JSContext context) {
            super(context);
        }

        @ExplodeLoop
        @Override
        void executeVoid(Object arg0Value, Object arg1Value, WriteElementNode arg2Value) {
            int state = state_;
            if (state != 0 /* is-active copyPropertiesFromJSObject(Object, DynamicObject, WriteElementNode, ReadElementNode, JSGetOwnPropertyNode, ListSizeNode, ListGetNode, JSClassProfile) || doObject(Object, Object, WriteElementNode, InteropLibrary, InteropLibrary, InteropLibrary) || doObject(Object, Object, WriteElementNode, InteropLibrary, InteropLibrary, InteropLibrary) */) {
                if ((state & 0b1) != 0 /* is-active copyPropertiesFromJSObject(Object, DynamicObject, WriteElementNode, ReadElementNode, JSGetOwnPropertyNode, ListSizeNode, ListGetNode, JSClassProfile) */ && JSTypes.isDynamicObject(arg1Value)) {
                    DynamicObject arg1Value_ = (DynamicObject) arg1Value;
                    CopyPropertiesFromJSObjectData s1_ = this.copyPropertiesFromJSObject_cache;
                    if (s1_ != null) {
                        if ((JSGuards.isJSObject(arg1Value_))) {
                            AssignPropertiesNode.copyPropertiesFromJSObject(arg0Value, arg1Value_, arg2Value, s1_.read_, s1_.getOwnProperty_, s1_.listSize_, s1_.listGet_, s1_.classProfile_);
                            return;
                        }
                    }
                }
                if ((state & 0b110) != 0 /* is-active doObject(Object, Object, WriteElementNode, InteropLibrary, InteropLibrary, InteropLibrary) || doObject(Object, Object, WriteElementNode, InteropLibrary, InteropLibrary, InteropLibrary) */) {
                    if ((state & 0b10) != 0 /* is-active doObject(Object, Object, WriteElementNode, InteropLibrary, InteropLibrary, InteropLibrary) */) {
                        Object0Data s2_ = this.object0_cache;
                        while (s2_ != null) {
                            if ((s2_.fromInterop_.accepts(arg1Value)) && (!(JSGuards.isJSObject(arg1Value)))) {
                                doObject(arg0Value, arg1Value, arg2Value, s2_.fromInterop_, s2_.keysInterop_, s2_.stringInterop_);
                                return;
                            }
                            s2_ = s2_.next_;
                        }
                    }
                    if ((state & 0b100) != 0 /* is-active doObject(Object, Object, WriteElementNode, InteropLibrary, InteropLibrary, InteropLibrary) */) {
                        if ((!(JSGuards.isJSObject(arg1Value)))) {
                            this.object1Boundary(state, arg0Value, arg1Value, arg2Value);
                            return;
                        }
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            executeAndSpecialize(arg0Value, arg1Value, arg2Value);
            return;
        }

        @TruffleBoundary
        private void object1Boundary(int state, Object arg0Value, Object arg1Value, WriteElementNode arg2Value) {
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(this);
            try {
                {
                    InteropLibrary object1_fromInterop__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                    doObject(arg0Value, arg1Value, arg2Value, object1_fromInterop__, this.object1_keysInterop_, this.object1_stringInterop_);
                    return;
                }
            } finally {
                encapsulating_.set(prev_);
            }
        }

        private void executeAndSpecialize(Object arg0Value, Object arg1Value, WriteElementNode arg2Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int exclude = exclude_;
            try {
                if (JSTypes.isDynamicObject(arg1Value)) {
                    DynamicObject arg1Value_ = (DynamicObject) arg1Value;
                    if ((JSGuards.isJSObject(arg1Value_))) {
                        CopyPropertiesFromJSObjectData s1_ = super.insert(new CopyPropertiesFromJSObjectData());
                        s1_.read_ = s1_.insertAccessor((ReadElementNode.create(context)));
                        s1_.getOwnProperty_ = s1_.insertAccessor((JSGetOwnPropertyNode.create(false)));
                        s1_.listSize_ = s1_.insertAccessor((ListSizeNode.create()));
                        s1_.listGet_ = s1_.insertAccessor((ListGetNode.create()));
                        s1_.classProfile_ = (JSClassProfile.create());
                        this.copyPropertiesFromJSObject_cache = s1_;
                        this.state_ = state = state | 0b1 /* add-active copyPropertiesFromJSObject(Object, DynamicObject, WriteElementNode, ReadElementNode, JSGetOwnPropertyNode, ListSizeNode, ListGetNode, JSClassProfile) */;
                        lock.unlock();
                        hasLock = false;
                        AssignPropertiesNode.copyPropertiesFromJSObject(arg0Value, arg1Value_, arg2Value, s1_.read_, s1_.getOwnProperty_, s1_.listSize_, s1_.listGet_, s1_.classProfile_);
                        return;
                    }
                }
                if ((exclude) == 0 /* is-not-excluded doObject(Object, Object, WriteElementNode, InteropLibrary, InteropLibrary, InteropLibrary) */) {
                    int count2_ = 0;
                    Object0Data s2_ = this.object0_cache;
                    if ((state & 0b10) != 0 /* is-active doObject(Object, Object, WriteElementNode, InteropLibrary, InteropLibrary, InteropLibrary) */) {
                        while (s2_ != null) {
                            if ((s2_.fromInterop_.accepts(arg1Value)) && (!(JSGuards.isJSObject(arg1Value)))) {
                                break;
                            }
                            s2_ = s2_.next_;
                            count2_++;
                        }
                    }
                    if (s2_ == null) {
                        if ((!(JSGuards.isJSObject(arg1Value))) && count2_ < (3)) {
                            // assert (s2_.fromInterop_.accepts(arg1Value));
                            s2_ = super.insert(new Object0Data(object0_cache));
                            s2_.fromInterop_ = s2_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                            s2_.keysInterop_ = s2_.insertAccessor((INTEROP_LIBRARY_.createDispatched(3)));
                            s2_.stringInterop_ = s2_.insertAccessor((INTEROP_LIBRARY_.createDispatched(3)));
                            this.object0_cache = s2_;
                            this.state_ = state = state | 0b10 /* add-active doObject(Object, Object, WriteElementNode, InteropLibrary, InteropLibrary, InteropLibrary) */;
                        }
                    }
                    if (s2_ != null) {
                        lock.unlock();
                        hasLock = false;
                        doObject(arg0Value, arg1Value, arg2Value, s2_.fromInterop_, s2_.keysInterop_, s2_.stringInterop_);
                        return;
                    }
                }
                {
                    InteropLibrary object1_fromInterop__ = null;
                    {
                        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                        Node prev_ = encapsulating_.set(this);
                        try {
                            if ((!(JSGuards.isJSObject(arg1Value)))) {
                                object1_fromInterop__ = (INTEROP_LIBRARY_.getUncached(arg1Value));
                                this.object1_keysInterop_ = super.insert((INTEROP_LIBRARY_.createDispatched(3)));
                                this.object1_stringInterop_ = super.insert((INTEROP_LIBRARY_.createDispatched(3)));
                                this.exclude_ = exclude = exclude | 0b1 /* add-excluded doObject(Object, Object, WriteElementNode, InteropLibrary, InteropLibrary, InteropLibrary) */;
                                this.object0_cache = null;
                                state = state & 0xfffffffd /* remove-active doObject(Object, Object, WriteElementNode, InteropLibrary, InteropLibrary, InteropLibrary) */;
                                this.state_ = state = state | 0b100 /* add-active doObject(Object, Object, WriteElementNode, InteropLibrary, InteropLibrary, InteropLibrary) */;
                                lock.unlock();
                                hasLock = false;
                                doObject(arg0Value, arg1Value, arg2Value, object1_fromInterop__, this.object1_keysInterop_, this.object1_stringInterop_);
                                return;
                            }
                        } finally {
                            encapsulating_.set(prev_);
                        }
                    }
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null, null, null}, arg0Value, arg1Value, arg2Value);
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
                Object0Data s2_ = this.object0_cache;
                if ((s2_ == null || s2_.next_ == null)) {
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
            s[0] = "copyPropertiesFromJSObject";
            if ((state & 0b1) != 0 /* is-active copyPropertiesFromJSObject(Object, DynamicObject, WriteElementNode, ReadElementNode, JSGetOwnPropertyNode, ListSizeNode, ListGetNode, JSClassProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                CopyPropertiesFromJSObjectData s1_ = this.copyPropertiesFromJSObject_cache;
                if (s1_ != null) {
                    cached.add(Arrays.asList(s1_.read_, s1_.getOwnProperty_, s1_.listSize_, s1_.listGet_, s1_.classProfile_));
                }
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doObject";
            if ((state & 0b10) != 0 /* is-active doObject(Object, Object, WriteElementNode, InteropLibrary, InteropLibrary, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                Object0Data s2_ = this.object0_cache;
                while (s2_ != null) {
                    cached.add(Arrays.asList(s2_.fromInterop_, s2_.keysInterop_, s2_.stringInterop_));
                    s2_ = s2_.next_;
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-excluded doObject(Object, Object, WriteElementNode, InteropLibrary, InteropLibrary, InteropLibrary) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "doObject";
            if ((state & 0b100) != 0 /* is-active doObject(Object, Object, WriteElementNode, InteropLibrary, InteropLibrary, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.object1_keysInterop_, this.object1_stringInterop_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static AssignPropertiesNode create(JSContext context) {
            return new AssignPropertiesNodeGen(context);
        }

        @GeneratedBy(AssignPropertiesNode.class)
        private static final class CopyPropertiesFromJSObjectData extends Node {

            @Child ReadElementNode read_;
            @Child JSGetOwnPropertyNode getOwnProperty_;
            @Child ListSizeNode listSize_;
            @Child ListGetNode listGet_;
            @CompilationFinal JSClassProfile classProfile_;

            CopyPropertiesFromJSObjectData() {
            }

            @Override
            public NodeCost getCost() {
                return NodeCost.NONE;
            }

            <T extends Node> T insertAccessor(T node) {
                return super.insert(node);
            }

        }
        @GeneratedBy(AssignPropertiesNode.class)
        private static final class Object0Data extends Node {

            @Child Object0Data next_;
            @Child InteropLibrary fromInterop_;
            @Child InteropLibrary keysInterop_;
            @Child InteropLibrary stringInterop_;

            Object0Data(Object0Data next_) {
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
    @GeneratedBy(ObjectValuesOrEntriesNode.class)
    public static final class ObjectValuesOrEntriesNodeGen extends ObjectValuesOrEntriesNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_;
        @CompilationFinal private volatile int exclude_;
        @CompilationFinal private ConditionProfile valuesOrEntriesJSObject_lengthZero_;
        @Child private EnumerableOwnPropertyNamesForeign0Data enumerableOwnPropertyNamesForeign0_cache;
        @Child private EnumerableOwnPropertyNamesForeign1Data enumerableOwnPropertyNamesForeign1_cache;
        @Child private ObjectValuesOrEntriesNode valuesOrEntriesGeneric_recursive_;

        private ObjectValuesOrEntriesNodeGen(JSContext context, JSBuiltin builtin, boolean entries, JavaScriptNode[] arguments) {
            super(context, builtin, entries);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @ExplodeLoop
        @Override
        protected DynamicObject executeEvaluated(Object arguments0Value) {
            int state = state_;
            if ((state & 0b1) != 0 /* is-active valuesOrEntriesJSObject(DynamicObject, ConditionProfile) */ && JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((JSGuards.isJSObject(arguments0Value_))) {
                    return valuesOrEntriesJSObject(arguments0Value_, this.valuesOrEntriesJSObject_lengthZero_);
                }
            }
            if ((state & 0b1110) != 0 /* is-active enumerableOwnPropertyNamesForeign(Object, InteropLibrary, InteropLibrary, ImportValueNode, BranchProfile) || enumerableOwnPropertyNamesForeign(Object, InteropLibrary, InteropLibrary, ImportValueNode, BranchProfile) || valuesOrEntriesGeneric(Object, ObjectValuesOrEntriesNode) */) {
                if ((state & 0b10) != 0 /* is-active enumerableOwnPropertyNamesForeign(Object, InteropLibrary, InteropLibrary, ImportValueNode, BranchProfile) */) {
                    EnumerableOwnPropertyNamesForeign0Data s2_ = this.enumerableOwnPropertyNamesForeign0_cache;
                    while (s2_ != null) {
                        if ((s2_.interop_.accepts(arguments0Value)) && (JSGuards.isForeignObject(arguments0Value))) {
                            return enumerableOwnPropertyNamesForeign(arguments0Value, s2_.interop_, s2_.members_, s2_.importValue_, s2_.growProfile_);
                        }
                        s2_ = s2_.next_;
                    }
                }
                if ((state & 0b100) != 0 /* is-active enumerableOwnPropertyNamesForeign(Object, InteropLibrary, InteropLibrary, ImportValueNode, BranchProfile) */) {
                    EnumerableOwnPropertyNamesForeign1Data s3_ = this.enumerableOwnPropertyNamesForeign1_cache;
                    if (s3_ != null) {
                        if ((JSGuards.isForeignObject(arguments0Value))) {
                            return this.enumerableOwnPropertyNamesForeign1Boundary(state, s3_, arguments0Value);
                        }
                    }
                }
                if ((state & 0b1000) != 0 /* is-active valuesOrEntriesGeneric(Object, ObjectValuesOrEntriesNode) */) {
                    if ((!(JSGuards.isJSObject(arguments0Value))) && (!(JSGuards.isForeignObject(arguments0Value)))) {
                        return valuesOrEntriesGeneric(arguments0Value, this.valuesOrEntriesGeneric_recursive_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value);
        }

        @TruffleBoundary
        private DynamicObject enumerableOwnPropertyNamesForeign1Boundary(int state, EnumerableOwnPropertyNamesForeign1Data s3_, Object arguments0Value) {
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(this);
            try {
                {
                    InteropLibrary interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value));
                    return enumerableOwnPropertyNamesForeign(arguments0Value, interop__, s3_.members_, s3_.importValue_, s3_.growProfile_);
                }
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @ExplodeLoop
        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state & 0b1) != 0 /* is-active valuesOrEntriesJSObject(DynamicObject, ConditionProfile) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((JSGuards.isJSObject(arguments0Value__))) {
                    return valuesOrEntriesJSObject(arguments0Value__, this.valuesOrEntriesJSObject_lengthZero_);
                }
            }
            if ((state & 0b1110) != 0 /* is-active enumerableOwnPropertyNamesForeign(Object, InteropLibrary, InteropLibrary, ImportValueNode, BranchProfile) || enumerableOwnPropertyNamesForeign(Object, InteropLibrary, InteropLibrary, ImportValueNode, BranchProfile) || valuesOrEntriesGeneric(Object, ObjectValuesOrEntriesNode) */) {
                if ((state & 0b10) != 0 /* is-active enumerableOwnPropertyNamesForeign(Object, InteropLibrary, InteropLibrary, ImportValueNode, BranchProfile) */) {
                    EnumerableOwnPropertyNamesForeign0Data s2_ = this.enumerableOwnPropertyNamesForeign0_cache;
                    while (s2_ != null) {
                        if ((s2_.interop_.accepts(arguments0Value_)) && (JSGuards.isForeignObject(arguments0Value_))) {
                            return enumerableOwnPropertyNamesForeign(arguments0Value_, s2_.interop_, s2_.members_, s2_.importValue_, s2_.growProfile_);
                        }
                        s2_ = s2_.next_;
                    }
                }
                if ((state & 0b100) != 0 /* is-active enumerableOwnPropertyNamesForeign(Object, InteropLibrary, InteropLibrary, ImportValueNode, BranchProfile) */) {
                    EnumerableOwnPropertyNamesForeign1Data s3_ = this.enumerableOwnPropertyNamesForeign1_cache;
                    if (s3_ != null) {
                        if ((JSGuards.isForeignObject(arguments0Value_))) {
                            return this.enumerableOwnPropertyNamesForeign1Boundary0(state, s3_, arguments0Value_);
                        }
                    }
                }
                if ((state & 0b1000) != 0 /* is-active valuesOrEntriesGeneric(Object, ObjectValuesOrEntriesNode) */) {
                    if ((!(JSGuards.isJSObject(arguments0Value_))) && (!(JSGuards.isForeignObject(arguments0Value_)))) {
                        return valuesOrEntriesGeneric(arguments0Value_, this.valuesOrEntriesGeneric_recursive_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @TruffleBoundary
        private Object enumerableOwnPropertyNamesForeign1Boundary0(int state, EnumerableOwnPropertyNamesForeign1Data s3_, Object arguments0Value_) {
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(this);
            try {
                {
                    InteropLibrary interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value_));
                    return enumerableOwnPropertyNamesForeign(arguments0Value_, interop__, s3_.members_, s3_.importValue_, s3_.growProfile_);
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

        private DynamicObject executeAndSpecialize(Object arguments0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int exclude = exclude_;
            try {
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSObject(arguments0Value_))) {
                        this.valuesOrEntriesJSObject_lengthZero_ = (ConditionProfile.createBinaryProfile());
                        this.state_ = state = state | 0b1 /* add-active valuesOrEntriesJSObject(DynamicObject, ConditionProfile) */;
                        lock.unlock();
                        hasLock = false;
                        return valuesOrEntriesJSObject(arguments0Value_, this.valuesOrEntriesJSObject_lengthZero_);
                    }
                }
                if ((exclude) == 0 /* is-not-excluded enumerableOwnPropertyNamesForeign(Object, InteropLibrary, InteropLibrary, ImportValueNode, BranchProfile) */) {
                    int count2_ = 0;
                    EnumerableOwnPropertyNamesForeign0Data s2_ = this.enumerableOwnPropertyNamesForeign0_cache;
                    if ((state & 0b10) != 0 /* is-active enumerableOwnPropertyNamesForeign(Object, InteropLibrary, InteropLibrary, ImportValueNode, BranchProfile) */) {
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
                            s2_ = super.insert(new EnumerableOwnPropertyNamesForeign0Data(enumerableOwnPropertyNamesForeign0_cache));
                            s2_.interop_ = s2_.insertAccessor((INTEROP_LIBRARY_.create(arguments0Value)));
                            s2_.members_ = s2_.insertAccessor((INTEROP_LIBRARY_.createDispatched(3)));
                            s2_.importValue_ = s2_.insertAccessor((ImportValueNode.create()));
                            s2_.growProfile_ = (BranchProfile.create());
                            this.enumerableOwnPropertyNamesForeign0_cache = s2_;
                            this.state_ = state = state | 0b10 /* add-active enumerableOwnPropertyNamesForeign(Object, InteropLibrary, InteropLibrary, ImportValueNode, BranchProfile) */;
                        }
                    }
                    if (s2_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return enumerableOwnPropertyNamesForeign(arguments0Value, s2_.interop_, s2_.members_, s2_.importValue_, s2_.growProfile_);
                    }
                }
                {
                    InteropLibrary interop__ = null;
                    {
                        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                        Node prev_ = encapsulating_.set(this);
                        try {
                            if ((JSGuards.isForeignObject(arguments0Value))) {
                                EnumerableOwnPropertyNamesForeign1Data s3_ = super.insert(new EnumerableOwnPropertyNamesForeign1Data());
                                interop__ = (INTEROP_LIBRARY_.getUncached(arguments0Value));
                                s3_.members_ = s3_.insertAccessor((INTEROP_LIBRARY_.createDispatched(3)));
                                s3_.importValue_ = s3_.insertAccessor((ImportValueNode.create()));
                                s3_.growProfile_ = (BranchProfile.create());
                                this.enumerableOwnPropertyNamesForeign1_cache = s3_;
                                this.exclude_ = exclude = exclude | 0b1 /* add-excluded enumerableOwnPropertyNamesForeign(Object, InteropLibrary, InteropLibrary, ImportValueNode, BranchProfile) */;
                                this.enumerableOwnPropertyNamesForeign0_cache = null;
                                state = state & 0xfffffffd /* remove-active enumerableOwnPropertyNamesForeign(Object, InteropLibrary, InteropLibrary, ImportValueNode, BranchProfile) */;
                                this.state_ = state = state | 0b100 /* add-active enumerableOwnPropertyNamesForeign(Object, InteropLibrary, InteropLibrary, ImportValueNode, BranchProfile) */;
                                lock.unlock();
                                hasLock = false;
                                return enumerableOwnPropertyNamesForeign(arguments0Value, interop__, s3_.members_, s3_.importValue_, s3_.growProfile_);
                            }
                        } finally {
                            encapsulating_.set(prev_);
                        }
                    }
                }
                if ((!(JSGuards.isJSObject(arguments0Value))) && (!(JSGuards.isForeignObject(arguments0Value)))) {
                    this.valuesOrEntriesGeneric_recursive_ = super.insert((createRecursive()));
                    this.state_ = state = state | 0b1000 /* add-active valuesOrEntriesGeneric(Object, ObjectValuesOrEntriesNode) */;
                    lock.unlock();
                    hasLock = false;
                    return valuesOrEntriesGeneric(arguments0Value, this.valuesOrEntriesGeneric_recursive_);
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
                EnumerableOwnPropertyNamesForeign0Data s2_ = this.enumerableOwnPropertyNamesForeign0_cache;
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
            s[0] = "valuesOrEntriesJSObject";
            if ((state & 0b1) != 0 /* is-active valuesOrEntriesJSObject(DynamicObject, ConditionProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.valuesOrEntriesJSObject_lengthZero_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "enumerableOwnPropertyNamesForeign";
            if ((state & 0b10) != 0 /* is-active enumerableOwnPropertyNamesForeign(Object, InteropLibrary, InteropLibrary, ImportValueNode, BranchProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                EnumerableOwnPropertyNamesForeign0Data s2_ = this.enumerableOwnPropertyNamesForeign0_cache;
                while (s2_ != null) {
                    cached.add(Arrays.asList(s2_.interop_, s2_.members_, s2_.importValue_, s2_.growProfile_));
                    s2_ = s2_.next_;
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-excluded enumerableOwnPropertyNamesForeign(Object, InteropLibrary, InteropLibrary, ImportValueNode, BranchProfile) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "enumerableOwnPropertyNamesForeign";
            if ((state & 0b100) != 0 /* is-active enumerableOwnPropertyNamesForeign(Object, InteropLibrary, InteropLibrary, ImportValueNode, BranchProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                EnumerableOwnPropertyNamesForeign1Data s3_ = this.enumerableOwnPropertyNamesForeign1_cache;
                if (s3_ != null) {
                    cached.add(Arrays.asList(s3_.members_, s3_.importValue_, s3_.growProfile_));
                }
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "valuesOrEntriesGeneric";
            if ((state & 0b1000) != 0 /* is-active valuesOrEntriesGeneric(Object, ObjectValuesOrEntriesNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.valuesOrEntriesGeneric_recursive_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            return Provider.create(data);
        }

        public static ObjectValuesOrEntriesNode create(JSContext context, JSBuiltin builtin, boolean entries, JavaScriptNode[] arguments) {
            return new ObjectValuesOrEntriesNodeGen(context, builtin, entries, arguments);
        }

        @GeneratedBy(ObjectValuesOrEntriesNode.class)
        private static final class EnumerableOwnPropertyNamesForeign0Data extends Node {

            @Child EnumerableOwnPropertyNamesForeign0Data next_;
            @Child InteropLibrary interop_;
            @Child InteropLibrary members_;
            @Child ImportValueNode importValue_;
            @CompilationFinal BranchProfile growProfile_;

            EnumerableOwnPropertyNamesForeign0Data(EnumerableOwnPropertyNamesForeign0Data next_) {
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
        @GeneratedBy(ObjectValuesOrEntriesNode.class)
        private static final class EnumerableOwnPropertyNamesForeign1Data extends Node {

            @Child InteropLibrary members_;
            @Child ImportValueNode importValue_;
            @CompilationFinal BranchProfile growProfile_;

            EnumerableOwnPropertyNamesForeign1Data() {
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
    @GeneratedBy(ObjectFromEntriesNode.class)
    public static final class ObjectFromEntriesNodeGen extends ObjectFromEntriesNode implements Provider {

        @Child private JavaScriptNode arguments0_;

        private ObjectFromEntriesNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            return entries(arguments0Value_);
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
            s[0] = "entries";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static ObjectFromEntriesNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ObjectFromEntriesNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ObjectBindPropertiesNode.class)
    public static final class ObjectBindPropertiesNodeGen extends ObjectBindPropertiesNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_;
        @CompilationFinal private volatile int exclude_;
        @Child private BindProperties5Data bindProperties5_cache;
        @Child private InteropLibrary bindProperties6_members_;

        private ObjectBindPropertiesNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state & 0b1) != 0 /* is-active bindPropertiesInvalidTarget(Object, Object) */) {
                if ((!(JSGuards.isJSObject(arguments0Value_)))) {
                    return bindPropertiesInvalidTarget(arguments0Value_, arguments1Value_);
                }
            }
            if ((state & 0b111111110) != 0 /* is-active bindPropertiesDynamicObject(DynamicObject, DynamicObject) || bindProperties(DynamicObject, Symbol) || bindProperties(DynamicObject, JSLazyString) || bindProperties(DynamicObject, SafeInteger) || bindProperties(DynamicObject, BigInt) || bindProperties(DynamicObject, Object) || bindProperties(DynamicObject, Object, InteropLibrary, InteropLibrary) || bindProperties(DynamicObject, Object, InteropLibrary, InteropLibrary) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state & 0b10) != 0 /* is-active bindPropertiesDynamicObject(DynamicObject, DynamicObject) */ && JSTypes.isDynamicObject(arguments1Value_)) {
                    DynamicObject arguments1Value__ = (DynamicObject) arguments1Value_;
                    if ((JSGuards.isJSObject(arguments0Value__)) && (JSGuards.isJSDynamicObject(arguments1Value__))) {
                        return bindPropertiesDynamicObject(arguments0Value__, arguments1Value__);
                    }
                }
                if ((state & 0b100) != 0 /* is-active bindProperties(DynamicObject, Symbol) */ && arguments1Value_ instanceof Symbol) {
                    Symbol arguments1Value__ = (Symbol) arguments1Value_;
                    if ((JSGuards.isJSObject(arguments0Value__))) {
                        return bindProperties(arguments0Value__, arguments1Value__);
                    }
                }
                if ((state & 0b1000) != 0 /* is-active bindProperties(DynamicObject, JSLazyString) */ && arguments1Value_ instanceof JSLazyString) {
                    JSLazyString arguments1Value__ = (JSLazyString) arguments1Value_;
                    if ((JSGuards.isJSObject(arguments0Value__))) {
                        return bindProperties(arguments0Value__, arguments1Value__);
                    }
                }
                if ((state & 0b10000) != 0 /* is-active bindProperties(DynamicObject, SafeInteger) */ && arguments1Value_ instanceof SafeInteger) {
                    SafeInteger arguments1Value__ = (SafeInteger) arguments1Value_;
                    if ((JSGuards.isJSObject(arguments0Value__))) {
                        return bindProperties(arguments0Value__, arguments1Value__);
                    }
                }
                if ((state & 0b100000) != 0 /* is-active bindProperties(DynamicObject, BigInt) */ && arguments1Value_ instanceof BigInt) {
                    BigInt arguments1Value__ = (BigInt) arguments1Value_;
                    if ((JSGuards.isJSObject(arguments0Value__))) {
                        return bindProperties(arguments0Value__, arguments1Value__);
                    }
                }
                if ((state & 0b111000000) != 0 /* is-active bindProperties(DynamicObject, Object) || bindProperties(DynamicObject, Object, InteropLibrary, InteropLibrary) || bindProperties(DynamicObject, Object, InteropLibrary, InteropLibrary) */) {
                    if ((state & 0b1000000) != 0 /* is-active bindProperties(DynamicObject, Object) */) {
                        if ((JSGuards.isJSObject(arguments0Value__)) && (!(JSGuards.isTruffleObject(arguments1Value_)))) {
                            return bindProperties(arguments0Value__, arguments1Value_);
                        }
                    }
                    if ((state & 0b10000000) != 0 /* is-active bindProperties(DynamicObject, Object, InteropLibrary, InteropLibrary) */) {
                        BindProperties5Data s8_ = this.bindProperties5_cache;
                        while (s8_ != null) {
                            if ((s8_.interop_.accepts(arguments1Value_)) && (JSGuards.isJSObject(arguments0Value__)) && (JSGuards.isForeignObject(arguments1Value_))) {
                                return bindProperties(arguments0Value__, arguments1Value_, s8_.interop_, s8_.members_);
                            }
                            s8_ = s8_.next_;
                        }
                    }
                    if ((state & 0b100000000) != 0 /* is-active bindProperties(DynamicObject, Object, InteropLibrary, InteropLibrary) */) {
                        if ((JSGuards.isJSObject(arguments0Value__)) && (JSGuards.isForeignObject(arguments1Value_))) {
                            return this.bindProperties6Boundary(state, arguments0Value__, arguments1Value_);
                        }
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @TruffleBoundary
        private Object bindProperties6Boundary(int state, DynamicObject arguments0Value__, Object arguments1Value_) {
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(this);
            try {
                {
                    InteropLibrary bindProperties6_interop__ = (INTEROP_LIBRARY_.getUncached(arguments1Value_));
                    return bindProperties(arguments0Value__, arguments1Value_, bindProperties6_interop__, this.bindProperties6_members_);
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

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int exclude = exclude_;
            try {
                if ((!(JSGuards.isJSObject(arguments0Value)))) {
                    this.state_ = state = state | 0b1 /* add-active bindPropertiesInvalidTarget(Object, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return bindPropertiesInvalidTarget(arguments0Value, arguments1Value);
                }
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if (JSTypes.isDynamicObject(arguments1Value)) {
                        DynamicObject arguments1Value_ = (DynamicObject) arguments1Value;
                        if ((JSGuards.isJSObject(arguments0Value_)) && (JSGuards.isJSDynamicObject(arguments1Value_))) {
                            this.state_ = state = state | 0b10 /* add-active bindPropertiesDynamicObject(DynamicObject, DynamicObject) */;
                            lock.unlock();
                            hasLock = false;
                            return bindPropertiesDynamicObject(arguments0Value_, arguments1Value_);
                        }
                    }
                    if (arguments1Value instanceof Symbol) {
                        Symbol arguments1Value_ = (Symbol) arguments1Value;
                        if ((JSGuards.isJSObject(arguments0Value_))) {
                            this.state_ = state = state | 0b100 /* add-active bindProperties(DynamicObject, Symbol) */;
                            lock.unlock();
                            hasLock = false;
                            return bindProperties(arguments0Value_, arguments1Value_);
                        }
                    }
                    if (arguments1Value instanceof JSLazyString) {
                        JSLazyString arguments1Value_ = (JSLazyString) arguments1Value;
                        if ((JSGuards.isJSObject(arguments0Value_))) {
                            this.state_ = state = state | 0b1000 /* add-active bindProperties(DynamicObject, JSLazyString) */;
                            lock.unlock();
                            hasLock = false;
                            return bindProperties(arguments0Value_, arguments1Value_);
                        }
                    }
                    if (arguments1Value instanceof SafeInteger) {
                        SafeInteger arguments1Value_ = (SafeInteger) arguments1Value;
                        if ((JSGuards.isJSObject(arguments0Value_))) {
                            this.state_ = state = state | 0b10000 /* add-active bindProperties(DynamicObject, SafeInteger) */;
                            lock.unlock();
                            hasLock = false;
                            return bindProperties(arguments0Value_, arguments1Value_);
                        }
                    }
                    if (arguments1Value instanceof BigInt) {
                        BigInt arguments1Value_ = (BigInt) arguments1Value;
                        if ((JSGuards.isJSObject(arguments0Value_))) {
                            this.state_ = state = state | 0b100000 /* add-active bindProperties(DynamicObject, BigInt) */;
                            lock.unlock();
                            hasLock = false;
                            return bindProperties(arguments0Value_, arguments1Value_);
                        }
                    }
                    if ((JSGuards.isJSObject(arguments0Value_)) && (!(JSGuards.isTruffleObject(arguments1Value)))) {
                        this.state_ = state = state | 0b1000000 /* add-active bindProperties(DynamicObject, Object) */;
                        lock.unlock();
                        hasLock = false;
                        return bindProperties(arguments0Value_, arguments1Value);
                    }
                    if ((exclude) == 0 /* is-not-excluded bindProperties(DynamicObject, Object, InteropLibrary, InteropLibrary) */) {
                        int count8_ = 0;
                        BindProperties5Data s8_ = this.bindProperties5_cache;
                        if ((state & 0b10000000) != 0 /* is-active bindProperties(DynamicObject, Object, InteropLibrary, InteropLibrary) */) {
                            while (s8_ != null) {
                                if ((s8_.interop_.accepts(arguments1Value)) && (JSGuards.isJSObject(arguments0Value_)) && (JSGuards.isForeignObject(arguments1Value))) {
                                    break;
                                }
                                s8_ = s8_.next_;
                                count8_++;
                            }
                        }
                        if (s8_ == null) {
                            if ((JSGuards.isJSObject(arguments0Value_)) && (JSGuards.isForeignObject(arguments1Value)) && count8_ < (3)) {
                                // assert (s8_.interop_.accepts(arguments1Value));
                                s8_ = super.insert(new BindProperties5Data(bindProperties5_cache));
                                s8_.interop_ = s8_.insertAccessor((INTEROP_LIBRARY_.create(arguments1Value)));
                                s8_.members_ = s8_.insertAccessor((INTEROP_LIBRARY_.createDispatched(3)));
                                this.bindProperties5_cache = s8_;
                                this.state_ = state = state | 0b10000000 /* add-active bindProperties(DynamicObject, Object, InteropLibrary, InteropLibrary) */;
                            }
                        }
                        if (s8_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return bindProperties(arguments0Value_, arguments1Value, s8_.interop_, s8_.members_);
                        }
                    }
                    {
                        InteropLibrary bindProperties6_interop__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                if ((JSGuards.isJSObject(arguments0Value_)) && (JSGuards.isForeignObject(arguments1Value))) {
                                    bindProperties6_interop__ = (INTEROP_LIBRARY_.getUncached(arguments1Value));
                                    this.bindProperties6_members_ = super.insert((INTEROP_LIBRARY_.createDispatched(3)));
                                    this.exclude_ = exclude = exclude | 0b1 /* add-excluded bindProperties(DynamicObject, Object, InteropLibrary, InteropLibrary) */;
                                    this.bindProperties5_cache = null;
                                    state = state & 0xffffff7f /* remove-active bindProperties(DynamicObject, Object, InteropLibrary, InteropLibrary) */;
                                    this.state_ = state = state | 0b100000000 /* add-active bindProperties(DynamicObject, Object, InteropLibrary, InteropLibrary) */;
                                    lock.unlock();
                                    hasLock = false;
                                    return bindProperties(arguments0Value_, arguments1Value, bindProperties6_interop__, this.bindProperties6_members_);
                                }
                            } finally {
                                encapsulating_.set(prev_);
                            }
                        }
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
            if (state == 0b0) {
                return NodeCost.UNINITIALIZED;
            } else if ((state & (state - 1)) == 0 /* is-single-active  */) {
                BindProperties5Data s8_ = this.bindProperties5_cache;
                if ((s8_ == null || s8_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[10];
            Object[] s;
            data[0] = 0;
            int state = state_;
            int exclude = exclude_;
            s = new Object[3];
            s[0] = "bindPropertiesInvalidTarget";
            if ((state & 0b1) != 0 /* is-active bindPropertiesInvalidTarget(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "bindPropertiesDynamicObject";
            if ((state & 0b10) != 0 /* is-active bindPropertiesDynamicObject(DynamicObject, DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "bindProperties";
            if ((state & 0b100) != 0 /* is-active bindProperties(DynamicObject, Symbol) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "bindProperties";
            if ((state & 0b1000) != 0 /* is-active bindProperties(DynamicObject, JSLazyString) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            s = new Object[3];
            s[0] = "bindProperties";
            if ((state & 0b10000) != 0 /* is-active bindProperties(DynamicObject, SafeInteger) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[5] = s;
            s = new Object[3];
            s[0] = "bindProperties";
            if ((state & 0b100000) != 0 /* is-active bindProperties(DynamicObject, BigInt) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[6] = s;
            s = new Object[3];
            s[0] = "bindProperties";
            if ((state & 0b1000000) != 0 /* is-active bindProperties(DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[7] = s;
            s = new Object[3];
            s[0] = "bindProperties";
            if ((state & 0b10000000) != 0 /* is-active bindProperties(DynamicObject, Object, InteropLibrary, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                BindProperties5Data s8_ = this.bindProperties5_cache;
                while (s8_ != null) {
                    cached.add(Arrays.asList(s8_.interop_, s8_.members_));
                    s8_ = s8_.next_;
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-excluded bindProperties(DynamicObject, Object, InteropLibrary, InteropLibrary) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[8] = s;
            s = new Object[3];
            s[0] = "bindProperties";
            if ((state & 0b100000000) != 0 /* is-active bindProperties(DynamicObject, Object, InteropLibrary, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.bindProperties6_members_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[9] = s;
            return Provider.create(data);
        }

        public static ObjectBindPropertiesNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ObjectBindPropertiesNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(ObjectBindPropertiesNode.class)
        private static final class BindProperties5Data extends Node {

            @Child BindProperties5Data next_;
            @Child InteropLibrary interop_;
            @Child InteropLibrary members_;

            BindProperties5Data(BindProperties5Data next_) {
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
}
