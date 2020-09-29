// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.object.DynamicObjectLibrary;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.objects.PropertyDescriptor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(FromPropertyDescriptorNode.class)
public final class FromPropertyDescriptorNodeGen extends FromPropertyDescriptorNode implements Provider {

    private static final Uncached UNCACHED = new Uncached();
    private static final LibraryFactory<DynamicObjectLibrary> DYNAMIC_OBJECT_LIBRARY_ = LibraryFactory.resolve(DynamicObjectLibrary.class);

    @CompilationFinal private volatile int state_;
    @Child private ToJSObjectData toJSObject_cache;

    private FromPropertyDescriptorNodeGen() {
    }

    @Override
    public DynamicObject execute(PropertyDescriptor arg0Value, JSContext arg1Value) {
        int state = state_;
        if (state != 0 /* is-active toJSObject(PropertyDescriptor, JSContext, DynamicObjectLibrary, DynamicObjectLibrary, DynamicObjectLibrary, DynamicObjectLibrary, DynamicObjectLibrary, DynamicObjectLibrary) */) {
            ToJSObjectData s1_ = this.toJSObject_cache;
            if (s1_ != null) {
                return FromPropertyDescriptorNode.toJSObject(arg0Value, arg1Value, s1_.putValueNode_, s1_.putWritableNode_, s1_.putGetNode_, s1_.putSetNode_, s1_.putEnumerableNode_, s1_.putConfigurableNode_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value);
    }

    private DynamicObject executeAndSpecialize(PropertyDescriptor arg0Value, JSContext arg1Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        try {
            ToJSObjectData s1_ = super.insert(new ToJSObjectData());
            s1_.putValueNode_ = s1_.insertAccessor((DYNAMIC_OBJECT_LIBRARY_.createDispatched(FromPropertyDescriptorNode.SHAPE_LIMIT)));
            s1_.putWritableNode_ = s1_.insertAccessor((DYNAMIC_OBJECT_LIBRARY_.createDispatched(FromPropertyDescriptorNode.SHAPE_LIMIT)));
            s1_.putGetNode_ = s1_.insertAccessor((DYNAMIC_OBJECT_LIBRARY_.createDispatched(FromPropertyDescriptorNode.SHAPE_LIMIT)));
            s1_.putSetNode_ = s1_.insertAccessor((DYNAMIC_OBJECT_LIBRARY_.createDispatched(FromPropertyDescriptorNode.SHAPE_LIMIT)));
            s1_.putEnumerableNode_ = s1_.insertAccessor((DYNAMIC_OBJECT_LIBRARY_.createDispatched(FromPropertyDescriptorNode.SHAPE_LIMIT)));
            s1_.putConfigurableNode_ = s1_.insertAccessor((DYNAMIC_OBJECT_LIBRARY_.createDispatched(FromPropertyDescriptorNode.SHAPE_LIMIT)));
            this.toJSObject_cache = s1_;
            this.state_ = state = state | 0b1 /* add-active toJSObject(PropertyDescriptor, JSContext, DynamicObjectLibrary, DynamicObjectLibrary, DynamicObjectLibrary, DynamicObjectLibrary, DynamicObjectLibrary, DynamicObjectLibrary) */;
            lock.unlock();
            hasLock = false;
            return FromPropertyDescriptorNode.toJSObject(arg0Value, arg1Value, s1_.putValueNode_, s1_.putWritableNode_, s1_.putGetNode_, s1_.putSetNode_, s1_.putEnumerableNode_, s1_.putConfigurableNode_);
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
        s[0] = "toJSObject";
        if (state != 0 /* is-active toJSObject(PropertyDescriptor, JSContext, DynamicObjectLibrary, DynamicObjectLibrary, DynamicObjectLibrary, DynamicObjectLibrary, DynamicObjectLibrary, DynamicObjectLibrary) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            ToJSObjectData s1_ = this.toJSObject_cache;
            if (s1_ != null) {
                cached.add(Arrays.asList(s1_.putValueNode_, s1_.putWritableNode_, s1_.putGetNode_, s1_.putSetNode_, s1_.putEnumerableNode_, s1_.putConfigurableNode_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        return Provider.create(data);
    }

    public static FromPropertyDescriptorNode create() {
        return new FromPropertyDescriptorNodeGen();
    }

    public static FromPropertyDescriptorNode getUncached() {
        return FromPropertyDescriptorNodeGen.UNCACHED;
    }

    @GeneratedBy(FromPropertyDescriptorNode.class)
    private static final class ToJSObjectData extends Node {

        @Child DynamicObjectLibrary putValueNode_;
        @Child DynamicObjectLibrary putWritableNode_;
        @Child DynamicObjectLibrary putGetNode_;
        @Child DynamicObjectLibrary putSetNode_;
        @Child DynamicObjectLibrary putEnumerableNode_;
        @Child DynamicObjectLibrary putConfigurableNode_;

        ToJSObjectData() {
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.NONE;
        }

        <T extends Node> T insertAccessor(T node) {
            return super.insert(node);
        }

    }
    @GeneratedBy(FromPropertyDescriptorNode.class)
    private static final class Uncached extends FromPropertyDescriptorNode {

        @TruffleBoundary
        @Override
        public DynamicObject execute(PropertyDescriptor arg0Value, JSContext arg1Value) {
            return FromPropertyDescriptorNode.toJSObject(arg0Value, arg1Value, (DYNAMIC_OBJECT_LIBRARY_.getUncached()), (DYNAMIC_OBJECT_LIBRARY_.getUncached()), (DYNAMIC_OBJECT_LIBRARY_.getUncached()), (DYNAMIC_OBJECT_LIBRARY_.getUncached()), (DYNAMIC_OBJECT_LIBRARY_.getUncached()), (DYNAMIC_OBJECT_LIBRARY_.getUncached()));
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.MEGAMORPHIC;
        }

        @Override
        public boolean isAdoptable() {
            return false;
        }

    }
}
