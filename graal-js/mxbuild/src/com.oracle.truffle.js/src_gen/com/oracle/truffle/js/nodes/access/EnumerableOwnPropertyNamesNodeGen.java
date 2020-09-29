// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.builtins.helper.ListGetNode;
import com.oracle.truffle.js.builtins.helper.ListSizeNode;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.util.JSClassProfile;
import com.oracle.truffle.js.runtime.util.UnmodifiableArrayList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(EnumerableOwnPropertyNamesNode.class)
public final class EnumerableOwnPropertyNamesNodeGen extends EnumerableOwnPropertyNamesNode implements Provider {

    @CompilationFinal private volatile int state_;
    @Child private EnumerableOwnPropertyNamesData enumerableOwnPropertyNames_cache;

    private EnumerableOwnPropertyNamesNodeGen(JSContext context, boolean keys, boolean values) {
        super(context, keys, values);
    }

    @Override
    public UnmodifiableArrayList<? extends Object> execute(DynamicObject arg0Value) {
        int state = state_;
        if (state != 0 /* is-active enumerableOwnPropertyNames(DynamicObject, JSClassProfile, ListSizeNode, ListGetNode, HasOnlyShapePropertiesNode) */) {
            EnumerableOwnPropertyNamesData s1_ = this.enumerableOwnPropertyNames_cache;
            if (s1_ != null) {
                return enumerableOwnPropertyNames(arg0Value, s1_.jsclassProfile_, s1_.listSize_, s1_.listGet_, s1_.hasOnlyShapeProperties_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    private UnmodifiableArrayList<? extends Object> executeAndSpecialize(DynamicObject arg0Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        try {
            EnumerableOwnPropertyNamesData s1_ = super.insert(new EnumerableOwnPropertyNamesData());
            s1_.jsclassProfile_ = (JSClassProfile.create());
            s1_.listSize_ = s1_.insertAccessor((ListSizeNode.create()));
            s1_.listGet_ = s1_.insertAccessor((ListGetNode.create()));
            s1_.hasOnlyShapeProperties_ = s1_.insertAccessor((HasOnlyShapePropertiesNode.create()));
            this.enumerableOwnPropertyNames_cache = s1_;
            this.state_ = state = state | 0b1 /* add-active enumerableOwnPropertyNames(DynamicObject, JSClassProfile, ListSizeNode, ListGetNode, HasOnlyShapePropertiesNode) */;
            lock.unlock();
            hasLock = false;
            return enumerableOwnPropertyNames(arg0Value, s1_.jsclassProfile_, s1_.listSize_, s1_.listGet_, s1_.hasOnlyShapeProperties_);
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
        s[0] = "enumerableOwnPropertyNames";
        if (state != 0 /* is-active enumerableOwnPropertyNames(DynamicObject, JSClassProfile, ListSizeNode, ListGetNode, HasOnlyShapePropertiesNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            EnumerableOwnPropertyNamesData s1_ = this.enumerableOwnPropertyNames_cache;
            if (s1_ != null) {
                cached.add(Arrays.asList(s1_.jsclassProfile_, s1_.listSize_, s1_.listGet_, s1_.hasOnlyShapeProperties_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        return Provider.create(data);
    }

    public static EnumerableOwnPropertyNamesNode create(JSContext context, boolean keys, boolean values) {
        return new EnumerableOwnPropertyNamesNodeGen(context, keys, values);
    }

    @GeneratedBy(EnumerableOwnPropertyNamesNode.class)
    private static final class EnumerableOwnPropertyNamesData extends Node {

        @CompilationFinal JSClassProfile jsclassProfile_;
        @Child ListSizeNode listSize_;
        @Child ListGetNode listGet_;
        @Child HasOnlyShapePropertiesNode hasOnlyShapeProperties_;

        EnumerableOwnPropertyNamesData() {
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
