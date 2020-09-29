// CheckStyle: start generated
package com.oracle.truffle.js.nodes.function;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.object.DynamicObjectLibrary;
import com.oracle.truffle.api.object.Shape;
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.runtime.JSContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(SpecializedNewObjectNode.class)
public final class SpecializedNewObjectNodeGen extends SpecializedNewObjectNode implements Provider {

    private static final LibraryFactory<DynamicObjectLibrary> DYNAMIC_OBJECT_LIBRARY_ = LibraryFactory.resolve(DynamicObjectLibrary.class);

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @Child private DynamicObjectLibrary setProtoNode;
    @CompilationFinal private CachedProtoData cachedProto_cache;
    @CompilationFinal private BranchProfile uncachedProto_slowBranch_;
    @CompilationFinal private Class<?> createWithProtoCachedClass_prototypeClass_;

    private SpecializedNewObjectNodeGen(JSContext context, boolean isBuiltin, boolean isConstructor, boolean isGenerator, boolean isAsyncGenerator) {
        super(context, isBuiltin, isConstructor, isGenerator, isAsyncGenerator);
    }

    @ExplodeLoop
    @Override
    protected DynamicObject execute(DynamicObject arg0Value, Object arg1Value) {
        int state = state_;
        if (state != 0 /* is-active doCachedProto(DynamicObject, Object, Object, Shape) || doUncachedProto(DynamicObject, DynamicObject, BranchProfile) || createWithProtoCachedClass(DynamicObject, Object, DynamicObjectLibrary, Class<>) || createWithProto(DynamicObject, DynamicObject, DynamicObjectLibrary) || createDefaultProto(DynamicObject, Object) || builtinConstructor(DynamicObject, Object) || throwNotConstructorFunctionTypeError(DynamicObject, Object) */) {
            if ((state & 0b1) != 0 /* is-active doCachedProto(DynamicObject, Object, Object, Shape) */) {
                assert (!(isBuiltin));
                assert (isConstructor);
                assert (!(context.isMultiContext()));
                CachedProtoData s1_ = this.cachedProto_cache;
                while (s1_ != null) {
                    assert (JSGuards.isJSObject(s1_.cachedPrototype_));
                    if ((arg1Value == s1_.cachedPrototype_)) {
                        return doCachedProto(arg0Value, arg1Value, s1_.cachedPrototype_, s1_.shape_);
                    }
                    s1_ = s1_.next_;
                }
            }
            if ((state & 0b10) != 0 /* is-active doUncachedProto(DynamicObject, DynamicObject, BranchProfile) */ && JSTypes.isDynamicObject(arg1Value)) {
                DynamicObject arg1Value_ = (DynamicObject) arg1Value;
                assert (!(isBuiltin));
                assert (isConstructor);
                assert (!(context.isMultiContext()));
                if ((JSGuards.isJSObject(arg1Value_))) {
                    return doUncachedProto(arg0Value, arg1Value_, this.uncachedProto_slowBranch_);
                }
            }
            if ((state & 0b100) != 0 /* is-active createWithProtoCachedClass(DynamicObject, Object, DynamicObjectLibrary, Class<>) */) {
                assert (!(isBuiltin));
                assert (isConstructor);
                assert (context.isMultiContext());
                assert (this.createWithProtoCachedClass_prototypeClass_ != null);
                if ((this.createWithProtoCachedClass_prototypeClass_.isInstance(arg1Value))) {
                    return createWithProtoCachedClass(arg0Value, arg1Value, this.setProtoNode, this.createWithProtoCachedClass_prototypeClass_);
                }
            }
            if ((state & 0b1000) != 0 /* is-active createWithProto(DynamicObject, DynamicObject, DynamicObjectLibrary) */ && JSTypes.isDynamicObject(arg1Value)) {
                DynamicObject arg1Value_ = (DynamicObject) arg1Value;
                assert (!(isBuiltin));
                assert (isConstructor);
                assert (context.isMultiContext());
                if ((JSGuards.isJSObject(arg1Value_))) {
                    return createWithProto(arg0Value, arg1Value_, this.setProtoNode);
                }
            }
            if ((state & 0b1110000) != 0 /* is-active createDefaultProto(DynamicObject, Object) || builtinConstructor(DynamicObject, Object) || throwNotConstructorFunctionTypeError(DynamicObject, Object) */) {
                if ((state & 0b10000) != 0 /* is-active createDefaultProto(DynamicObject, Object) */) {
                    assert (!(isBuiltin));
                    assert (isConstructor);
                    if ((!(JSGuards.isJSObject(arg1Value)))) {
                        return createDefaultProto(arg0Value, arg1Value);
                    }
                }
                if ((state & 0b100000) != 0 /* is-active builtinConstructor(DynamicObject, Object) */) {
                    assert (isBuiltin);
                    assert (isConstructor);
                    return SpecializedNewObjectNode.builtinConstructor(arg0Value, arg1Value);
                }
                if ((state & 0b1000000) != 0 /* is-active throwNotConstructorFunctionTypeError(DynamicObject, Object) */) {
                    assert (!(isConstructor));
                    return throwNotConstructorFunctionTypeError(arg0Value, arg1Value);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value);
    }

    private DynamicObject executeAndSpecialize(DynamicObject arg0Value, Object arg1Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        int exclude = exclude_;
        int oldState = state;
        try {
            if ((exclude) == 0 /* is-not-excluded doCachedProto(DynamicObject, Object, Object, Shape) */ && (!(isBuiltin)) && (isConstructor) && (!(context.isMultiContext()))) {
                int count1_ = 0;
                CachedProtoData s1_ = this.cachedProto_cache;
                if ((state & 0b1) != 0 /* is-active doCachedProto(DynamicObject, Object, Object, Shape) */) {
                    while (s1_ != null) {
                        assert (JSGuards.isJSObject(s1_.cachedPrototype_));
                        if ((arg1Value == s1_.cachedPrototype_)) {
                            break;
                        }
                        s1_ = s1_.next_;
                        count1_++;
                    }
                }
                if (s1_ == null) {
                    {
                        Object cachedPrototype__ = (arg1Value);
                        if ((JSGuards.isJSObject(cachedPrototype__))) {
                            // assert (arg1Value == cachedPrototype__);
                            if (count1_ < (context.getPropertyCacheLimit())) {
                                s1_ = new CachedProtoData(cachedProto_cache);
                                s1_.cachedPrototype_ = cachedPrototype__;
                                s1_.shape_ = (getProtoChildShape(arg1Value));
                                this.cachedProto_cache = s1_;
                                this.state_ = state = state | 0b1 /* add-active doCachedProto(DynamicObject, Object, Object, Shape) */;
                            }
                        }
                    }
                }
                if (s1_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return doCachedProto(arg0Value, arg1Value, s1_.cachedPrototype_, s1_.shape_);
                }
            }
            if (JSTypes.isDynamicObject(arg1Value)) {
                DynamicObject arg1Value_ = (DynamicObject) arg1Value;
                if ((!(isBuiltin)) && (isConstructor) && (!(context.isMultiContext())) && (JSGuards.isJSObject(arg1Value_))) {
                    this.uncachedProto_slowBranch_ = (BranchProfile.create());
                    this.exclude_ = exclude = exclude | 0b1 /* add-excluded doCachedProto(DynamicObject, Object, Object, Shape) */;
                    this.cachedProto_cache = null;
                    state = state & 0xfffffffe /* remove-active doCachedProto(DynamicObject, Object, Object, Shape) */;
                    this.state_ = state = state | 0b10 /* add-active doUncachedProto(DynamicObject, DynamicObject, BranchProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return doUncachedProto(arg0Value, arg1Value_, this.uncachedProto_slowBranch_);
                }
            }
            boolean CreateWithProtoCachedClass_duplicateFound_ = false;
            if ((state & 0b100) != 0 /* is-active createWithProtoCachedClass(DynamicObject, Object, DynamicObjectLibrary, Class<>) */) {
                assert (!(isBuiltin));
                assert (isConstructor);
                assert (context.isMultiContext());
                assert (this.createWithProtoCachedClass_prototypeClass_ != null);
                if ((this.createWithProtoCachedClass_prototypeClass_.isInstance(arg1Value))) {
                    CreateWithProtoCachedClass_duplicateFound_ = true;
                }
            }
            if (!CreateWithProtoCachedClass_duplicateFound_) {
                if ((!(isBuiltin)) && (isConstructor) && (context.isMultiContext())) {
                    Class<?> createWithProtoCachedClass_prototypeClass__ = (JSGuards.getClassIfJSObject(arg1Value));
                    if ((createWithProtoCachedClass_prototypeClass__ != null) && (createWithProtoCachedClass_prototypeClass__.isInstance(arg1Value)) && ((state & 0b100)) == 0 /* is-not-active createWithProtoCachedClass(DynamicObject, Object, DynamicObjectLibrary, Class<>) */) {
                        if (this.setProtoNode == null) {
                            this.setProtoNode = super.insert((DYNAMIC_OBJECT_LIBRARY_.createDispatched(3)));
                        }
                        this.createWithProtoCachedClass_prototypeClass_ = createWithProtoCachedClass_prototypeClass__;
                        this.state_ = state = state | 0b100 /* add-active createWithProtoCachedClass(DynamicObject, Object, DynamicObjectLibrary, Class<>) */;
                        CreateWithProtoCachedClass_duplicateFound_ = true;
                    }
                }
            }
            if (CreateWithProtoCachedClass_duplicateFound_) {
                lock.unlock();
                hasLock = false;
                return createWithProtoCachedClass(arg0Value, arg1Value, this.setProtoNode, this.createWithProtoCachedClass_prototypeClass_);
            }
            if (JSTypes.isDynamicObject(arg1Value)) {
                DynamicObject arg1Value_ = (DynamicObject) arg1Value;
                if ((!(isBuiltin)) && (isConstructor) && (context.isMultiContext()) && (JSGuards.isJSObject(arg1Value_))) {
                    if (this.setProtoNode == null) {
                        this.setProtoNode = super.insert((DYNAMIC_OBJECT_LIBRARY_.createDispatched(3)));
                    }
                    this.state_ = state = state | 0b1000 /* add-active createWithProto(DynamicObject, DynamicObject, DynamicObjectLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return createWithProto(arg0Value, arg1Value_, this.setProtoNode);
                }
            }
            if ((!(isBuiltin)) && (isConstructor) && (!(JSGuards.isJSObject(arg1Value)))) {
                this.state_ = state = state | 0b10000 /* add-active createDefaultProto(DynamicObject, Object) */;
                lock.unlock();
                hasLock = false;
                return createDefaultProto(arg0Value, arg1Value);
            }
            if ((isBuiltin) && (isConstructor)) {
                this.state_ = state = state | 0b100000 /* add-active builtinConstructor(DynamicObject, Object) */;
                lock.unlock();
                hasLock = false;
                return SpecializedNewObjectNode.builtinConstructor(arg0Value, arg1Value);
            }
            if ((!(isConstructor))) {
                this.state_ = state = state | 0b1000000 /* add-active throwNotConstructorFunctionTypeError(DynamicObject, Object) */;
                lock.unlock();
                hasLock = false;
                return throwNotConstructorFunctionTypeError(arg0Value, arg1Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {null, null}, arg0Value, arg1Value);
        } finally {
            if (oldState != 0) {
                checkForPolymorphicSpecialize(oldState);
            }
            if (hasLock) {
                lock.unlock();
            }
        }
    }

    private void checkForPolymorphicSpecialize(int oldState) {
        int megamorphicMask = 0b10;
        int megamorphicState = (this.state_ & 0b10);
        if ((((oldState & megamorphicMask) == 0) && (megamorphicState != 0))) {
            this.reportPolymorphicSpecialize();
        }
    }

    @Override
    public NodeCost getCost() {
        int state = state_;
        if (state == 0b0) {
            return NodeCost.UNINITIALIZED;
        } else if ((state & (state - 1)) == 0 /* is-single-active  */) {
            CachedProtoData s1_ = this.cachedProto_cache;
            if ((s1_ == null || s1_.next_ == null)) {
                return NodeCost.MONOMORPHIC;
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[8];
        Object[] s;
        data[0] = 0;
        int state = state_;
        int exclude = exclude_;
        s = new Object[3];
        s[0] = "doCachedProto";
        if ((state & 0b1) != 0 /* is-active doCachedProto(DynamicObject, Object, Object, Shape) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            CachedProtoData s1_ = this.cachedProto_cache;
            while (s1_ != null) {
                cached.add(Arrays.asList(s1_.cachedPrototype_, s1_.shape_));
                s1_ = s1_.next_;
            }
            s[2] = cached;
        } else if (exclude != 0 /* is-excluded doCachedProto(DynamicObject, Object, Object, Shape) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doUncachedProto";
        if ((state & 0b10) != 0 /* is-active doUncachedProto(DynamicObject, DynamicObject, BranchProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.uncachedProto_slowBranch_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "createWithProtoCachedClass";
        if ((state & 0b100) != 0 /* is-active createWithProtoCachedClass(DynamicObject, Object, DynamicObjectLibrary, Class<>) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.setProtoNode, this.createWithProtoCachedClass_prototypeClass_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "createWithProto";
        if ((state & 0b1000) != 0 /* is-active createWithProto(DynamicObject, DynamicObject, DynamicObjectLibrary) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.setProtoNode));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "createDefaultProto";
        if ((state & 0b10000) != 0 /* is-active createDefaultProto(DynamicObject, Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "builtinConstructor";
        if ((state & 0b100000) != 0 /* is-active builtinConstructor(DynamicObject, Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "throwNotConstructorFunctionTypeError";
        if ((state & 0b1000000) != 0 /* is-active throwNotConstructorFunctionTypeError(DynamicObject, Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        return Provider.create(data);
    }

    public static SpecializedNewObjectNode create(JSContext context, boolean isBuiltin, boolean isConstructor, boolean isGenerator, boolean isAsyncGenerator) {
        return new SpecializedNewObjectNodeGen(context, isBuiltin, isConstructor, isGenerator, isAsyncGenerator);
    }

    @GeneratedBy(SpecializedNewObjectNode.class)
    private static final class CachedProtoData {

        @CompilationFinal CachedProtoData next_;
        @CompilationFinal Object cachedPrototype_;
        @CompilationFinal Shape shape_;

        CachedProtoData(CachedProtoData next_) {
            this.next_ = next_;
        }

    }
}
