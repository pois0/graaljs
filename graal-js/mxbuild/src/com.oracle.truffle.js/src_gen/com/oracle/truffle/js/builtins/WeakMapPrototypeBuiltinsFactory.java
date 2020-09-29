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
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.api.profiles.ValueProfile;
import com.oracle.truffle.js.builtins.WeakMapPrototypeBuiltins.JSWeakMapDeleteNode;
import com.oracle.truffle.js.builtins.WeakMapPrototypeBuiltins.JSWeakMapGetNode;
import com.oracle.truffle.js.builtins.WeakMapPrototypeBuiltins.JSWeakMapHasNode;
import com.oracle.truffle.js.builtins.WeakMapPrototypeBuiltins.JSWeakMapSetNode;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.access.HasHiddenKeyCacheNode;
import com.oracle.truffle.js.nodes.access.PropertyGetNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(WeakMapPrototypeBuiltins.class)
public final class WeakMapPrototypeBuiltinsFactory {

    @GeneratedBy(JSWeakMapDeleteNode.class)
    public static final class JSWeakMapDeleteNodeGen extends JSWeakMapDeleteNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private int state_;

        private JSWeakMapDeleteNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state & 0b11) != 0 /* is-active delete(DynamicObject, DynamicObject) || deleteNonObjectKey(DynamicObject, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state & 0b1) != 0 /* is-active delete(DynamicObject, DynamicObject) */ && JSTypes.isDynamicObject(arguments1Value_)) {
                    DynamicObject arguments1Value__ = (DynamicObject) arguments1Value_;
                    if ((JSGuards.isJSWeakMap(arguments0Value__)) && (JSGuards.isJSObject(arguments1Value__))) {
                        return JSWeakMapDeleteNode.delete(arguments0Value__, arguments1Value__);
                    }
                }
                if ((state & 0b10) != 0 /* is-active deleteNonObjectKey(DynamicObject, Object) */) {
                    if ((JSGuards.isJSWeakMap(arguments0Value__)) && (!(JSGuards.isJSObject(arguments1Value_)))) {
                        return JSWeakMapDeleteNode.deleteNonObjectKey(arguments0Value__, arguments1Value_);
                    }
                }
            }
            if ((state & 0b100) != 0 /* is-active notWeakMap(Object, Object) */) {
                if ((!(JSGuards.isJSWeakMap(arguments0Value_)))) {
                    return JSWeakMapDeleteNode.notWeakMap(arguments0Value_, arguments1Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) throws UnexpectedResultException {
            int state = state_;
            if ((state & 0b10) != 0 /* is-active deleteNonObjectKey(DynamicObject, Object) */) {
                return JSTypesGen.expectBoolean(execute(frameValue));
            }
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if ((state & 0b1) != 0 /* is-active delete(DynamicObject, DynamicObject) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if (JSTypes.isDynamicObject(arguments1Value_)) {
                    DynamicObject arguments1Value__ = (DynamicObject) arguments1Value_;
                    if ((JSGuards.isJSWeakMap(arguments0Value__)) && (JSGuards.isJSObject(arguments1Value__))) {
                        return JSWeakMapDeleteNode.delete(arguments0Value__, arguments1Value__);
                    }
                }
            }
            if ((state & 0b100) != 0 /* is-active notWeakMap(Object, Object) */) {
                if ((!(JSGuards.isJSWeakMap(arguments0Value_)))) {
                    return JSWeakMapDeleteNode.notWeakMap(arguments0Value_, arguments1Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return JSTypesGen.expectBoolean(executeAndSpecialize(arguments0Value_, arguments1Value_));
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            int state = state_;
            try {
                if ((state & 0b10) == 0 /* only-active delete(DynamicObject, DynamicObject) && notWeakMap(Object, Object) */ && state != 0  /* is-not delete(DynamicObject, DynamicObject) && deleteNonObjectKey(DynamicObject, Object) && notWeakMap(Object, Object) */) {
                    executeBoolean(frameValue);
                    return;
                }
                execute(frameValue);
                return;
            } catch (UnexpectedResultException ex) {
                return;
            }
        }

        private Object executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            int state = state_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if (JSTypes.isDynamicObject(arguments1Value)) {
                    DynamicObject arguments1Value_ = (DynamicObject) arguments1Value;
                    if ((JSGuards.isJSWeakMap(arguments0Value_)) && (JSGuards.isJSObject(arguments1Value_))) {
                        this.state_ = state = state | 0b1 /* add-active delete(DynamicObject, DynamicObject) */;
                        return JSWeakMapDeleteNode.delete(arguments0Value_, arguments1Value_);
                    }
                }
                if ((JSGuards.isJSWeakMap(arguments0Value_)) && (!(JSGuards.isJSObject(arguments1Value)))) {
                    this.state_ = state = state | 0b10 /* add-active deleteNonObjectKey(DynamicObject, Object) */;
                    return JSWeakMapDeleteNode.deleteNonObjectKey(arguments0Value_, arguments1Value);
                }
            }
            if ((!(JSGuards.isJSWeakMap(arguments0Value)))) {
                this.state_ = state = state | 0b100 /* add-active notWeakMap(Object, Object) */;
                return JSWeakMapDeleteNode.notWeakMap(arguments0Value, arguments1Value);
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
            Object[] data = new Object[4];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "delete";
            if ((state & 0b1) != 0 /* is-active delete(DynamicObject, DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "deleteNonObjectKey";
            if ((state & 0b10) != 0 /* is-active deleteNonObjectKey(DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "notWeakMap";
            if ((state & 0b100) != 0 /* is-active notWeakMap(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static JSWeakMapDeleteNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSWeakMapDeleteNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSWeakMapGetNode.class)
    public static final class JSWeakMapGetNodeGen extends JSWeakMapGetNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_;
        @Child private GetCachedData getCached_cache;

        private JSWeakMapGetNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state & 0b111) != 0 /* is-active getCached(DynamicObject, DynamicObject, PropertyGetNode, HasHiddenKeyCacheNode, ValueProfile, ConditionProfile) || getGeneric(DynamicObject, DynamicObject) || getNonObjectKey(DynamicObject, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state & 0b11) != 0 /* is-active getCached(DynamicObject, DynamicObject, PropertyGetNode, HasHiddenKeyCacheNode, ValueProfile, ConditionProfile) || getGeneric(DynamicObject, DynamicObject) */ && JSTypes.isDynamicObject(arguments1Value_)) {
                    DynamicObject arguments1Value__ = (DynamicObject) arguments1Value_;
                    if ((state & 0b1) != 0 /* is-active getCached(DynamicObject, DynamicObject, PropertyGetNode, HasHiddenKeyCacheNode, ValueProfile, ConditionProfile) */) {
                        GetCachedData s1_ = this.getCached_cache;
                        if (s1_ != null) {
                            if ((JSGuards.isJSWeakMap(arguments0Value__)) && (JSGuards.isJSObject(arguments1Value__)) && (!(JSGuards.isJSProxy(arguments1Value__)))) {
                                return getCached(arguments0Value__, arguments1Value__, s1_.invertedGetter_, s1_.invertedHas_, s1_.invertedKlassProfile_, s1_.hasInvertedProfile_);
                            }
                        }
                    }
                    if ((state & 0b10) != 0 /* is-active getGeneric(DynamicObject, DynamicObject) */) {
                        if ((JSGuards.isJSWeakMap(arguments0Value__)) && (JSGuards.isJSObject(arguments1Value__))) {
                            return getGeneric(arguments0Value__, arguments1Value__);
                        }
                    }
                }
                if ((state & 0b100) != 0 /* is-active getNonObjectKey(DynamicObject, Object) */) {
                    if ((JSGuards.isJSWeakMap(arguments0Value__)) && (!(JSGuards.isJSObject(arguments1Value_)))) {
                        return JSWeakMapGetNode.getNonObjectKey(arguments0Value__, arguments1Value_);
                    }
                }
            }
            if ((state & 0b1000) != 0 /* is-active notWeakMap(Object, Object) */) {
                if ((!(JSGuards.isJSWeakMap(arguments0Value_)))) {
                    return JSWeakMapGetNode.notWeakMap(arguments0Value_, arguments1Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) throws UnexpectedResultException {
            int state = state_;
            if ((state & 0b111) != 0 /* is-active getCached(DynamicObject, DynamicObject, PropertyGetNode, HasHiddenKeyCacheNode, ValueProfile, ConditionProfile) || getGeneric(DynamicObject, DynamicObject) || getNonObjectKey(DynamicObject, Object) */) {
                return JSTypesGen.expectBoolean(execute(frameValue));
            }
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if ((state & 0b1000) != 0 /* is-active notWeakMap(Object, Object) */) {
                if ((!(JSGuards.isJSWeakMap(arguments0Value_)))) {
                    return JSWeakMapGetNode.notWeakMap(arguments0Value_, arguments1Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return JSTypesGen.expectBoolean(executeAndSpecialize(arguments0Value_, arguments1Value_));
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            int state = state_;
            try {
                if ((state & 0b111) == 0 /* only-active notWeakMap(Object, Object) */ && state != 0  /* is-not getCached(DynamicObject, DynamicObject, PropertyGetNode, HasHiddenKeyCacheNode, ValueProfile, ConditionProfile) && getGeneric(DynamicObject, DynamicObject) && getNonObjectKey(DynamicObject, Object) && notWeakMap(Object, Object) */) {
                    executeBoolean(frameValue);
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
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if (JSTypes.isDynamicObject(arguments1Value)) {
                        DynamicObject arguments1Value_ = (DynamicObject) arguments1Value;
                        if ((JSGuards.isJSWeakMap(arguments0Value_)) && (JSGuards.isJSObject(arguments1Value_)) && (!(JSGuards.isJSProxy(arguments1Value_)))) {
                            GetCachedData s1_ = super.insert(new GetCachedData());
                            s1_.invertedGetter_ = s1_.insertAccessor((createInvertedGet()));
                            s1_.invertedHas_ = s1_.insertAccessor((createInvertedHas()));
                            s1_.invertedKlassProfile_ = (ValueProfile.createClassProfile());
                            s1_.hasInvertedProfile_ = (ConditionProfile.createBinaryProfile());
                            this.getCached_cache = s1_;
                            this.state_ = state = state | 0b1 /* add-active getCached(DynamicObject, DynamicObject, PropertyGetNode, HasHiddenKeyCacheNode, ValueProfile, ConditionProfile) */;
                            lock.unlock();
                            hasLock = false;
                            return getCached(arguments0Value_, arguments1Value_, s1_.invertedGetter_, s1_.invertedHas_, s1_.invertedKlassProfile_, s1_.hasInvertedProfile_);
                        }
                        if ((JSGuards.isJSWeakMap(arguments0Value_)) && (JSGuards.isJSObject(arguments1Value_))) {
                            this.state_ = state = state | 0b10 /* add-active getGeneric(DynamicObject, DynamicObject) */;
                            lock.unlock();
                            hasLock = false;
                            return getGeneric(arguments0Value_, arguments1Value_);
                        }
                    }
                    if ((JSGuards.isJSWeakMap(arguments0Value_)) && (!(JSGuards.isJSObject(arguments1Value)))) {
                        this.state_ = state = state | 0b100 /* add-active getNonObjectKey(DynamicObject, Object) */;
                        lock.unlock();
                        hasLock = false;
                        return JSWeakMapGetNode.getNonObjectKey(arguments0Value_, arguments1Value);
                    }
                }
                if ((!(JSGuards.isJSWeakMap(arguments0Value)))) {
                    this.state_ = state = state | 0b1000 /* add-active notWeakMap(Object, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return JSWeakMapGetNode.notWeakMap(arguments0Value, arguments1Value);
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
            s[0] = "getCached";
            if ((state & 0b1) != 0 /* is-active getCached(DynamicObject, DynamicObject, PropertyGetNode, HasHiddenKeyCacheNode, ValueProfile, ConditionProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                GetCachedData s1_ = this.getCached_cache;
                if (s1_ != null) {
                    cached.add(Arrays.asList(s1_.invertedGetter_, s1_.invertedHas_, s1_.invertedKlassProfile_, s1_.hasInvertedProfile_));
                }
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "getGeneric";
            if ((state & 0b10) != 0 /* is-active getGeneric(DynamicObject, DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "getNonObjectKey";
            if ((state & 0b100) != 0 /* is-active getNonObjectKey(DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "notWeakMap";
            if ((state & 0b1000) != 0 /* is-active notWeakMap(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            return Provider.create(data);
        }

        public static JSWeakMapGetNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSWeakMapGetNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(JSWeakMapGetNode.class)
        private static final class GetCachedData extends Node {

            @Child PropertyGetNode invertedGetter_;
            @Child HasHiddenKeyCacheNode invertedHas_;
            @CompilationFinal ValueProfile invertedKlassProfile_;
            @CompilationFinal ConditionProfile hasInvertedProfile_;

            GetCachedData() {
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
    @GeneratedBy(JSWeakMapSetNode.class)
    public static final class JSWeakMapSetNodeGen extends JSWeakMapSetNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private volatile int state_;
        @Child private SetCachedData setCached_cache;

        private JSWeakMapSetNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state != 0 /* is-active setCached(DynamicObject, DynamicObject, Object, PropertyGetNode, HasHiddenKeyCacheNode, ValueProfile, ConditionProfile) || set(DynamicObject, DynamicObject, Object) || setNonObjectKey(DynamicObject, Object, Object) || notWeakMap(Object, Object, Object) */) {
                if ((state & 0b111) != 0 /* is-active setCached(DynamicObject, DynamicObject, Object, PropertyGetNode, HasHiddenKeyCacheNode, ValueProfile, ConditionProfile) || set(DynamicObject, DynamicObject, Object) || setNonObjectKey(DynamicObject, Object, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((state & 0b11) != 0 /* is-active setCached(DynamicObject, DynamicObject, Object, PropertyGetNode, HasHiddenKeyCacheNode, ValueProfile, ConditionProfile) || set(DynamicObject, DynamicObject, Object) */ && JSTypes.isDynamicObject(arguments1Value_)) {
                        DynamicObject arguments1Value__ = (DynamicObject) arguments1Value_;
                        if ((state & 0b1) != 0 /* is-active setCached(DynamicObject, DynamicObject, Object, PropertyGetNode, HasHiddenKeyCacheNode, ValueProfile, ConditionProfile) */) {
                            SetCachedData s1_ = this.setCached_cache;
                            if (s1_ != null) {
                                if ((JSGuards.isJSWeakMap(arguments0Value__)) && (JSGuards.isJSObject(arguments1Value__)) && (!(JSGuards.isJSProxy(arguments1Value__)))) {
                                    return setCached(arguments0Value__, arguments1Value__, arguments2Value_, s1_.invertedGetter_, s1_.invertedHas_, s1_.invertedKlassProfile_, s1_.hasInvertedProfile_);
                                }
                            }
                        }
                        if ((state & 0b10) != 0 /* is-active set(DynamicObject, DynamicObject, Object) */) {
                            if ((JSGuards.isJSWeakMap(arguments0Value__)) && (JSGuards.isJSObject(arguments1Value__))) {
                                return JSWeakMapSetNode.set(arguments0Value__, arguments1Value__, arguments2Value_);
                            }
                        }
                    }
                    if ((state & 0b100) != 0 /* is-active setNonObjectKey(DynamicObject, Object, Object) */) {
                        if ((JSGuards.isJSWeakMap(arguments0Value__)) && (!(JSGuards.isJSObject(arguments1Value_)))) {
                            return JSWeakMapSetNode.setNonObjectKey(arguments0Value__, arguments1Value_, arguments2Value_);
                        }
                    }
                }
                if ((state & 0b1000) != 0 /* is-active notWeakMap(Object, Object, Object) */) {
                    if ((!(JSGuards.isJSWeakMap(arguments0Value_)))) {
                        return JSWeakMapSetNode.notWeakMap(arguments0Value_, arguments1Value_, arguments2Value_);
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
                    if (JSTypes.isDynamicObject(arguments1Value)) {
                        DynamicObject arguments1Value_ = (DynamicObject) arguments1Value;
                        if ((JSGuards.isJSWeakMap(arguments0Value_)) && (JSGuards.isJSObject(arguments1Value_)) && (!(JSGuards.isJSProxy(arguments1Value_)))) {
                            SetCachedData s1_ = super.insert(new SetCachedData());
                            s1_.invertedGetter_ = s1_.insertAccessor((createInvertedGet()));
                            s1_.invertedHas_ = s1_.insertAccessor((createInvertedHas()));
                            s1_.invertedKlassProfile_ = (ValueProfile.createClassProfile());
                            s1_.hasInvertedProfile_ = (ConditionProfile.createBinaryProfile());
                            this.setCached_cache = s1_;
                            this.state_ = state = state | 0b1 /* add-active setCached(DynamicObject, DynamicObject, Object, PropertyGetNode, HasHiddenKeyCacheNode, ValueProfile, ConditionProfile) */;
                            lock.unlock();
                            hasLock = false;
                            return setCached(arguments0Value_, arguments1Value_, arguments2Value, s1_.invertedGetter_, s1_.invertedHas_, s1_.invertedKlassProfile_, s1_.hasInvertedProfile_);
                        }
                        if ((JSGuards.isJSWeakMap(arguments0Value_)) && (JSGuards.isJSObject(arguments1Value_))) {
                            this.state_ = state = state | 0b10 /* add-active set(DynamicObject, DynamicObject, Object) */;
                            lock.unlock();
                            hasLock = false;
                            return JSWeakMapSetNode.set(arguments0Value_, arguments1Value_, arguments2Value);
                        }
                    }
                    if ((JSGuards.isJSWeakMap(arguments0Value_)) && (!(JSGuards.isJSObject(arguments1Value)))) {
                        this.state_ = state = state | 0b100 /* add-active setNonObjectKey(DynamicObject, Object, Object) */;
                        lock.unlock();
                        hasLock = false;
                        return JSWeakMapSetNode.setNonObjectKey(arguments0Value_, arguments1Value, arguments2Value);
                    }
                }
                if ((!(JSGuards.isJSWeakMap(arguments0Value)))) {
                    this.state_ = state = state | 0b1000 /* add-active notWeakMap(Object, Object, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return JSWeakMapSetNode.notWeakMap(arguments0Value, arguments1Value, arguments2Value);
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
            Object[] data = new Object[5];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "setCached";
            if ((state & 0b1) != 0 /* is-active setCached(DynamicObject, DynamicObject, Object, PropertyGetNode, HasHiddenKeyCacheNode, ValueProfile, ConditionProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                SetCachedData s1_ = this.setCached_cache;
                if (s1_ != null) {
                    cached.add(Arrays.asList(s1_.invertedGetter_, s1_.invertedHas_, s1_.invertedKlassProfile_, s1_.hasInvertedProfile_));
                }
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "set";
            if ((state & 0b10) != 0 /* is-active set(DynamicObject, DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "setNonObjectKey";
            if ((state & 0b100) != 0 /* is-active setNonObjectKey(DynamicObject, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "notWeakMap";
            if ((state & 0b1000) != 0 /* is-active notWeakMap(Object, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            return Provider.create(data);
        }

        public static JSWeakMapSetNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSWeakMapSetNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(JSWeakMapSetNode.class)
        private static final class SetCachedData extends Node {

            @Child PropertyGetNode invertedGetter_;
            @Child HasHiddenKeyCacheNode invertedHas_;
            @CompilationFinal ValueProfile invertedKlassProfile_;
            @CompilationFinal ConditionProfile hasInvertedProfile_;

            SetCachedData() {
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
    @GeneratedBy(JSWeakMapHasNode.class)
    public static final class JSWeakMapHasNodeGen extends JSWeakMapHasNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_;
        @Child private HasCachedData hasCached_cache;

        private JSWeakMapHasNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state & 0b111) != 0 /* is-active hasCached(DynamicObject, DynamicObject, PropertyGetNode, HasHiddenKeyCacheNode, ValueProfile, ConditionProfile) || has(DynamicObject, DynamicObject) || hasNonObjectKey(DynamicObject, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state & 0b11) != 0 /* is-active hasCached(DynamicObject, DynamicObject, PropertyGetNode, HasHiddenKeyCacheNode, ValueProfile, ConditionProfile) || has(DynamicObject, DynamicObject) */ && JSTypes.isDynamicObject(arguments1Value_)) {
                    DynamicObject arguments1Value__ = (DynamicObject) arguments1Value_;
                    if ((state & 0b1) != 0 /* is-active hasCached(DynamicObject, DynamicObject, PropertyGetNode, HasHiddenKeyCacheNode, ValueProfile, ConditionProfile) */) {
                        HasCachedData s1_ = this.hasCached_cache;
                        if (s1_ != null) {
                            if ((JSGuards.isJSWeakMap(arguments0Value__)) && (JSGuards.isJSObject(arguments1Value__)) && (!(JSGuards.isJSProxy(arguments1Value__)))) {
                                return hasCached(arguments0Value__, arguments1Value__, s1_.invertedGetter_, s1_.invertedHas_, s1_.invertedKlassProfile_, s1_.hasInvertedProfile_);
                            }
                        }
                    }
                    if ((state & 0b10) != 0 /* is-active has(DynamicObject, DynamicObject) */) {
                        if ((JSGuards.isJSWeakMap(arguments0Value__)) && (JSGuards.isJSObject(arguments1Value__))) {
                            return JSWeakMapHasNode.has(arguments0Value__, arguments1Value__);
                        }
                    }
                }
                if ((state & 0b100) != 0 /* is-active hasNonObjectKey(DynamicObject, Object) */) {
                    if ((JSGuards.isJSWeakMap(arguments0Value__)) && (!(JSGuards.isJSObject(arguments1Value_)))) {
                        return JSWeakMapHasNode.hasNonObjectKey(arguments0Value__, arguments1Value_);
                    }
                }
            }
            if ((state & 0b1000) != 0 /* is-active notWeakMap(Object, Object) */) {
                if ((!(JSGuards.isJSWeakMap(arguments0Value_)))) {
                    return JSWeakMapHasNode.notWeakMap(arguments0Value_, arguments1Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) throws UnexpectedResultException {
            int state = state_;
            if ((state & 0b1) != 0 /* is-active hasCached(DynamicObject, DynamicObject, PropertyGetNode, HasHiddenKeyCacheNode, ValueProfile, ConditionProfile) */) {
                return JSTypesGen.expectBoolean(execute(frameValue));
            }
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if ((state & 0b110) != 0 /* is-active has(DynamicObject, DynamicObject) || hasNonObjectKey(DynamicObject, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state & 0b10) != 0 /* is-active has(DynamicObject, DynamicObject) */ && JSTypes.isDynamicObject(arguments1Value_)) {
                    DynamicObject arguments1Value__ = (DynamicObject) arguments1Value_;
                    if ((JSGuards.isJSWeakMap(arguments0Value__)) && (JSGuards.isJSObject(arguments1Value__))) {
                        return JSWeakMapHasNode.has(arguments0Value__, arguments1Value__);
                    }
                }
                if ((state & 0b100) != 0 /* is-active hasNonObjectKey(DynamicObject, Object) */) {
                    if ((JSGuards.isJSWeakMap(arguments0Value__)) && (!(JSGuards.isJSObject(arguments1Value_)))) {
                        return JSWeakMapHasNode.hasNonObjectKey(arguments0Value__, arguments1Value_);
                    }
                }
            }
            if ((state & 0b1000) != 0 /* is-active notWeakMap(Object, Object) */) {
                if ((!(JSGuards.isJSWeakMap(arguments0Value_)))) {
                    return JSWeakMapHasNode.notWeakMap(arguments0Value_, arguments1Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return JSTypesGen.expectBoolean(executeAndSpecialize(arguments0Value_, arguments1Value_));
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            int state = state_;
            try {
                if ((state & 0b1) == 0 /* only-active has(DynamicObject, DynamicObject) && hasNonObjectKey(DynamicObject, Object) && notWeakMap(Object, Object) */ && state != 0  /* is-not hasCached(DynamicObject, DynamicObject, PropertyGetNode, HasHiddenKeyCacheNode, ValueProfile, ConditionProfile) && has(DynamicObject, DynamicObject) && hasNonObjectKey(DynamicObject, Object) && notWeakMap(Object, Object) */) {
                    executeBoolean(frameValue);
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
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if (JSTypes.isDynamicObject(arguments1Value)) {
                        DynamicObject arguments1Value_ = (DynamicObject) arguments1Value;
                        if ((JSGuards.isJSWeakMap(arguments0Value_)) && (JSGuards.isJSObject(arguments1Value_)) && (!(JSGuards.isJSProxy(arguments1Value_)))) {
                            HasCachedData s1_ = super.insert(new HasCachedData());
                            s1_.invertedGetter_ = s1_.insertAccessor((createInvertedGet()));
                            s1_.invertedHas_ = s1_.insertAccessor((createInvertedHas()));
                            s1_.invertedKlassProfile_ = (ValueProfile.createClassProfile());
                            s1_.hasInvertedProfile_ = (ConditionProfile.createBinaryProfile());
                            this.hasCached_cache = s1_;
                            this.state_ = state = state | 0b1 /* add-active hasCached(DynamicObject, DynamicObject, PropertyGetNode, HasHiddenKeyCacheNode, ValueProfile, ConditionProfile) */;
                            lock.unlock();
                            hasLock = false;
                            return hasCached(arguments0Value_, arguments1Value_, s1_.invertedGetter_, s1_.invertedHas_, s1_.invertedKlassProfile_, s1_.hasInvertedProfile_);
                        }
                        if ((JSGuards.isJSWeakMap(arguments0Value_)) && (JSGuards.isJSObject(arguments1Value_))) {
                            this.state_ = state = state | 0b10 /* add-active has(DynamicObject, DynamicObject) */;
                            lock.unlock();
                            hasLock = false;
                            return JSWeakMapHasNode.has(arguments0Value_, arguments1Value_);
                        }
                    }
                    if ((JSGuards.isJSWeakMap(arguments0Value_)) && (!(JSGuards.isJSObject(arguments1Value)))) {
                        this.state_ = state = state | 0b100 /* add-active hasNonObjectKey(DynamicObject, Object) */;
                        lock.unlock();
                        hasLock = false;
                        return JSWeakMapHasNode.hasNonObjectKey(arguments0Value_, arguments1Value);
                    }
                }
                if ((!(JSGuards.isJSWeakMap(arguments0Value)))) {
                    this.state_ = state = state | 0b1000 /* add-active notWeakMap(Object, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return JSWeakMapHasNode.notWeakMap(arguments0Value, arguments1Value);
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
            s[0] = "hasCached";
            if ((state & 0b1) != 0 /* is-active hasCached(DynamicObject, DynamicObject, PropertyGetNode, HasHiddenKeyCacheNode, ValueProfile, ConditionProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                HasCachedData s1_ = this.hasCached_cache;
                if (s1_ != null) {
                    cached.add(Arrays.asList(s1_.invertedGetter_, s1_.invertedHas_, s1_.invertedKlassProfile_, s1_.hasInvertedProfile_));
                }
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "has";
            if ((state & 0b10) != 0 /* is-active has(DynamicObject, DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "hasNonObjectKey";
            if ((state & 0b100) != 0 /* is-active hasNonObjectKey(DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "notWeakMap";
            if ((state & 0b1000) != 0 /* is-active notWeakMap(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            return Provider.create(data);
        }

        public static JSWeakMapHasNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSWeakMapHasNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(JSWeakMapHasNode.class)
        private static final class HasCachedData extends Node {

            @Child PropertyGetNode invertedGetter_;
            @Child HasHiddenKeyCacheNode invertedHas_;
            @CompilationFinal ValueProfile invertedKlassProfile_;
            @CompilationFinal ConditionProfile hasInvertedProfile_;

            HasCachedData() {
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
