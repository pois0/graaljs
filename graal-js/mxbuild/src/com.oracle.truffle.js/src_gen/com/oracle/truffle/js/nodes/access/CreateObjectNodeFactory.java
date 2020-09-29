// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.object.DynamicObjectLibrary;
import com.oracle.truffle.api.object.Shape;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.access.CreateObjectNode.CreateObjectWithCachedPrototypeNode;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.builtins.JSClass;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(CreateObjectNode.class)
public final class CreateObjectNodeFactory {

    private static final LibraryFactory<DynamicObjectLibrary> DYNAMIC_OBJECT_LIBRARY_ = LibraryFactory.resolve(DynamicObjectLibrary.class);

    @GeneratedBy(CreateObjectWithCachedPrototypeNode.class)
    protected static final class CreateObjectWithCachedPrototypeNodeGen extends CreateObjectWithCachedPrototypeNode implements Provider {

        @CompilationFinal private volatile int state_;
        @CompilationFinal private volatile int exclude_;
        @Child private DynamicObjectLibrary setProtoNode;
        @CompilationFinal private DynamicObject cachedPrototype_cachedPrototype_;
        @CompilationFinal private Shape cachedPrototype_protoChildShape_;

        private CreateObjectWithCachedPrototypeNodeGen(JSContext context, JavaScriptNode prototypeExpression, JSClass jsclass) {
            super(context, prototypeExpression, jsclass);
        }

        @Override
        public DynamicObject executeDynamicObject(VirtualFrame frameValue, DynamicObject prototypeExpressionValue) {
            int state = state_;
            if ((state & 0b111) != 0 /* is-active doCachedPrototype(DynamicObject, DynamicObject, Shape) || doOrdinaryInstancePrototype(DynamicObject, DynamicObjectLibrary) || doPromiseInstancePrototype(DynamicObject, DynamicObjectLibrary) */) {
                if ((state & 0b1) != 0 /* is-active doCachedPrototype(DynamicObject, DynamicObject, Shape) */) {
                    assert (!(context.isMultiContext()));
                    assert (JSGuards.isValidPrototype(this.cachedPrototype_cachedPrototype_));
                    if ((prototypeExpressionValue == this.cachedPrototype_cachedPrototype_)) {
                        return doCachedPrototype(prototypeExpressionValue, this.cachedPrototype_cachedPrototype_, this.cachedPrototype_protoChildShape_);
                    }
                }
                if ((state & 0b10) != 0 /* is-active doOrdinaryInstancePrototype(DynamicObject, DynamicObjectLibrary) */) {
                    assert (isOrdinaryObject());
                    if ((JSGuards.isValidPrototype(prototypeExpressionValue))) {
                        return doOrdinaryInstancePrototype(prototypeExpressionValue, this.setProtoNode);
                    }
                }
                if ((state & 0b100) != 0 /* is-active doPromiseInstancePrototype(DynamicObject, DynamicObjectLibrary) */) {
                    assert (isPromiseObject());
                    if ((JSGuards.isValidPrototype(prototypeExpressionValue))) {
                        return doPromiseInstancePrototype(prototypeExpressionValue, this.setProtoNode);
                    }
                }
            }
            if ((state & 0b1000) != 0 /* is-active doNotJSObjectOrNull(Object) */) {
                assert (isOrdinaryObject() || isPromiseObject());
                if ((!(JSGuards.isValidPrototype(prototypeExpressionValue)))) {
                    return doNotJSObjectOrNull(prototypeExpressionValue);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(prototypeExpressionValue);
        }

        @Override
        public DynamicObject executeDynamicObject(VirtualFrame frameValue) {
            int state = state_;
            Object prototypeExpressionValue_ = super.prototypeExpression.execute(frameValue);
            if ((state & 0b111) != 0 /* is-active doCachedPrototype(DynamicObject, DynamicObject, Shape) || doOrdinaryInstancePrototype(DynamicObject, DynamicObjectLibrary) || doPromiseInstancePrototype(DynamicObject, DynamicObjectLibrary) */ && JSTypes.isDynamicObject(prototypeExpressionValue_)) {
                DynamicObject prototypeExpressionValue__ = (DynamicObject) prototypeExpressionValue_;
                if ((state & 0b1) != 0 /* is-active doCachedPrototype(DynamicObject, DynamicObject, Shape) */) {
                    assert (!(context.isMultiContext()));
                    assert (JSGuards.isValidPrototype(this.cachedPrototype_cachedPrototype_));
                    if ((prototypeExpressionValue__ == this.cachedPrototype_cachedPrototype_)) {
                        return doCachedPrototype(prototypeExpressionValue__, this.cachedPrototype_cachedPrototype_, this.cachedPrototype_protoChildShape_);
                    }
                }
                if ((state & 0b10) != 0 /* is-active doOrdinaryInstancePrototype(DynamicObject, DynamicObjectLibrary) */) {
                    assert (isOrdinaryObject());
                    if ((JSGuards.isValidPrototype(prototypeExpressionValue__))) {
                        return doOrdinaryInstancePrototype(prototypeExpressionValue__, this.setProtoNode);
                    }
                }
                if ((state & 0b100) != 0 /* is-active doPromiseInstancePrototype(DynamicObject, DynamicObjectLibrary) */) {
                    assert (isPromiseObject());
                    if ((JSGuards.isValidPrototype(prototypeExpressionValue__))) {
                        return doPromiseInstancePrototype(prototypeExpressionValue__, this.setProtoNode);
                    }
                }
            }
            if ((state & 0b1000) != 0 /* is-active doNotJSObjectOrNull(Object) */) {
                assert (isOrdinaryObject() || isPromiseObject());
                if ((!(JSGuards.isValidPrototype(prototypeExpressionValue_)))) {
                    return doNotJSObjectOrNull(prototypeExpressionValue_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(prototypeExpressionValue_);
        }

        private DynamicObject executeAndSpecialize(Object prototypeExpressionValue) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int exclude = exclude_;
            try {
                if (JSTypes.isDynamicObject(prototypeExpressionValue)) {
                    DynamicObject prototypeExpressionValue_ = (DynamicObject) prototypeExpressionValue;
                    if ((exclude) == 0 /* is-not-excluded doCachedPrototype(DynamicObject, DynamicObject, Shape) */) {
                        boolean CachedPrototype_duplicateFound_ = false;
                        if ((state & 0b1) != 0 /* is-active doCachedPrototype(DynamicObject, DynamicObject, Shape) */) {
                            assert (!(context.isMultiContext()));
                            assert (JSGuards.isValidPrototype(this.cachedPrototype_cachedPrototype_));
                            if ((prototypeExpressionValue_ == this.cachedPrototype_cachedPrototype_)) {
                                CachedPrototype_duplicateFound_ = true;
                            }
                        }
                        if (!CachedPrototype_duplicateFound_) {
                            if ((!(context.isMultiContext()))) {
                                DynamicObject cachedPrototype_cachedPrototype__ = (prototypeExpressionValue_);
                                if ((JSGuards.isValidPrototype(cachedPrototype_cachedPrototype__))) {
                                    // assert (prototypeExpressionValue_ == cachedPrototype_cachedPrototype__);
                                    if (((state & 0b1)) == 0 /* is-not-active doCachedPrototype(DynamicObject, DynamicObject, Shape) */) {
                                        this.cachedPrototype_cachedPrototype_ = cachedPrototype_cachedPrototype__;
                                        this.cachedPrototype_protoChildShape_ = (getProtoChildShape(cachedPrototype_cachedPrototype__));
                                        this.state_ = state = state | 0b1 /* add-active doCachedPrototype(DynamicObject, DynamicObject, Shape) */;
                                        CachedPrototype_duplicateFound_ = true;
                                    }
                                }
                            }
                        }
                        if (CachedPrototype_duplicateFound_) {
                            lock.unlock();
                            hasLock = false;
                            return doCachedPrototype(prototypeExpressionValue_, this.cachedPrototype_cachedPrototype_, this.cachedPrototype_protoChildShape_);
                        }
                    }
                    if ((isOrdinaryObject()) && (JSGuards.isValidPrototype(prototypeExpressionValue_))) {
                        if (this.setProtoNode == null) {
                            this.setProtoNode = super.insert((DYNAMIC_OBJECT_LIBRARY_.createDispatched(3)));
                        }
                        this.exclude_ = exclude = exclude | 0b1 /* add-excluded doCachedPrototype(DynamicObject, DynamicObject, Shape) */;
                        state = state & 0xfffffffe /* remove-active doCachedPrototype(DynamicObject, DynamicObject, Shape) */;
                        this.state_ = state = state | 0b10 /* add-active doOrdinaryInstancePrototype(DynamicObject, DynamicObjectLibrary) */;
                        lock.unlock();
                        hasLock = false;
                        return doOrdinaryInstancePrototype(prototypeExpressionValue_, this.setProtoNode);
                    }
                    if ((isPromiseObject()) && (JSGuards.isValidPrototype(prototypeExpressionValue_))) {
                        if (this.setProtoNode == null) {
                            this.setProtoNode = super.insert((DYNAMIC_OBJECT_LIBRARY_.createDispatched(3)));
                        }
                        this.exclude_ = exclude = exclude | 0b1 /* add-excluded doCachedPrototype(DynamicObject, DynamicObject, Shape) */;
                        state = state & 0xfffffffe /* remove-active doCachedPrototype(DynamicObject, DynamicObject, Shape) */;
                        this.state_ = state = state | 0b100 /* add-active doPromiseInstancePrototype(DynamicObject, DynamicObjectLibrary) */;
                        lock.unlock();
                        hasLock = false;
                        return doPromiseInstancePrototype(prototypeExpressionValue_, this.setProtoNode);
                    }
                }
                if ((isOrdinaryObject() || isPromiseObject()) && (!(JSGuards.isValidPrototype(prototypeExpressionValue)))) {
                    this.state_ = state = state | 0b1000 /* add-active doNotJSObjectOrNull(Object) */;
                    lock.unlock();
                    hasLock = false;
                    return doNotJSObjectOrNull(prototypeExpressionValue);
                }
                throw new UnsupportedSpecializationException(this, new Node[] {super.prototypeExpression}, prototypeExpressionValue);
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
            int exclude = exclude_;
            s = new Object[3];
            s[0] = "doCachedPrototype";
            if ((state & 0b1) != 0 /* is-active doCachedPrototype(DynamicObject, DynamicObject, Shape) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.cachedPrototype_cachedPrototype_, this.cachedPrototype_protoChildShape_));
                s[2] = cached;
            } else if (exclude != 0 /* is-excluded doCachedPrototype(DynamicObject, DynamicObject, Shape) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doOrdinaryInstancePrototype";
            if ((state & 0b10) != 0 /* is-active doOrdinaryInstancePrototype(DynamicObject, DynamicObjectLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.setProtoNode));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "doPromiseInstancePrototype";
            if ((state & 0b100) != 0 /* is-active doPromiseInstancePrototype(DynamicObject, DynamicObjectLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.setProtoNode));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "doNotJSObjectOrNull";
            if ((state & 0b1000) != 0 /* is-active doNotJSObjectOrNull(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            return Provider.create(data);
        }

        public static CreateObjectWithCachedPrototypeNode create(JSContext context, JavaScriptNode prototypeExpression, JSClass jsclass) {
            return new CreateObjectWithCachedPrototypeNodeGen(context, prototypeExpression, jsclass);
        }

    }
}
