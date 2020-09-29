// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.EncapsulatingNodeReference;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.object.DynamicObjectLibrary;
import com.oracle.truffle.js.nodes.access.InitErrorObjectNode.DefineStackPropertyNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(InitErrorObjectNode.class)
@SuppressWarnings("unused")
public final class InitErrorObjectNodeFactory {

    private static final LibraryFactory<DynamicObjectLibrary> DYNAMIC_OBJECT_LIBRARY_ = LibraryFactory.resolve(DynamicObjectLibrary.class);

    @GeneratedBy(DefineStackPropertyNode.class)
    public static final class DefineStackPropertyNodeGen extends DefineStackPropertyNode implements Provider {

        @CompilationFinal private volatile int state_;
        @CompilationFinal private volatile int exclude_;
        @Child private Cached0Data cached0_cache;

        private DefineStackPropertyNodeGen() {
        }

        @ExplodeLoop
        @Override
        void execute(DynamicObject arg0Value) {
            int state = state_;
            if (state != 0 /* is-active doCached(DynamicObject, DynamicObjectLibrary) || doCached(DynamicObject, DynamicObjectLibrary) */) {
                if ((state & 0b1) != 0 /* is-active doCached(DynamicObject, DynamicObjectLibrary) */) {
                    Cached0Data s1_ = this.cached0_cache;
                    while (s1_ != null) {
                        if ((s1_.objectLibrary_.accepts(arg0Value))) {
                            doCached(arg0Value, s1_.objectLibrary_);
                            return;
                        }
                        s1_ = s1_.next_;
                    }
                }
                if ((state & 0b10) != 0 /* is-active doCached(DynamicObject, DynamicObjectLibrary) */) {
                    this.cached1Boundary(state, arg0Value);
                    return;
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            executeAndSpecialize(arg0Value);
            return;
        }

        @TruffleBoundary
        private void cached1Boundary(int state, DynamicObject arg0Value) {
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(this);
            try {
                {
                    DynamicObjectLibrary cached1_objectLibrary__ = (DYNAMIC_OBJECT_LIBRARY_.getUncached(arg0Value));
                    doCached(arg0Value, cached1_objectLibrary__);
                    return;
                }
            } finally {
                encapsulating_.set(prev_);
            }
        }

        private void executeAndSpecialize(DynamicObject arg0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int exclude = exclude_;
            try {
                if ((exclude) == 0 /* is-not-excluded doCached(DynamicObject, DynamicObjectLibrary) */) {
                    int count1_ = 0;
                    Cached0Data s1_ = this.cached0_cache;
                    if ((state & 0b1) != 0 /* is-active doCached(DynamicObject, DynamicObjectLibrary) */) {
                        while (s1_ != null) {
                            if ((s1_.objectLibrary_.accepts(arg0Value))) {
                                break;
                            }
                            s1_ = s1_.next_;
                            count1_++;
                        }
                    }
                    if (s1_ == null) {
                        // assert (s1_.objectLibrary_.accepts(arg0Value));
                        if (count1_ < (3)) {
                            s1_ = super.insert(new Cached0Data(cached0_cache));
                            s1_.objectLibrary_ = s1_.insertAccessor((DYNAMIC_OBJECT_LIBRARY_.create(arg0Value)));
                            this.cached0_cache = s1_;
                            this.state_ = state = state | 0b1 /* add-active doCached(DynamicObject, DynamicObjectLibrary) */;
                        }
                    }
                    if (s1_ != null) {
                        lock.unlock();
                        hasLock = false;
                        doCached(arg0Value, s1_.objectLibrary_);
                        return;
                    }
                }
                {
                    DynamicObjectLibrary cached1_objectLibrary__ = null;
                    {
                        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                        Node prev_ = encapsulating_.set(this);
                        try {
                            cached1_objectLibrary__ = (DYNAMIC_OBJECT_LIBRARY_.getUncached(arg0Value));
                            this.exclude_ = exclude = exclude | 0b1 /* add-excluded doCached(DynamicObject, DynamicObjectLibrary) */;
                            this.cached0_cache = null;
                            state = state & 0xfffffffe /* remove-active doCached(DynamicObject, DynamicObjectLibrary) */;
                            this.state_ = state = state | 0b10 /* add-active doCached(DynamicObject, DynamicObjectLibrary) */;
                            lock.unlock();
                            hasLock = false;
                            doCached(arg0Value, cached1_objectLibrary__);
                            return;
                        } finally {
                            encapsulating_.set(prev_);
                        }
                    }
                }
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
                Cached0Data s1_ = this.cached0_cache;
                if ((s1_ == null || s1_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
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
            s[0] = "doCached";
            if ((state & 0b1) != 0 /* is-active doCached(DynamicObject, DynamicObjectLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                Cached0Data s1_ = this.cached0_cache;
                while (s1_ != null) {
                    cached.add(Arrays.asList(s1_.objectLibrary_));
                    s1_ = s1_.next_;
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-excluded doCached(DynamicObject, DynamicObjectLibrary) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doCached";
            if ((state & 0b10) != 0 /* is-active doCached(DynamicObject, DynamicObjectLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList());
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static DefineStackPropertyNode create() {
            return new DefineStackPropertyNodeGen();
        }

        @GeneratedBy(DefineStackPropertyNode.class)
        private static final class Cached0Data extends Node {

            @Child Cached0Data next_;
            @Child DynamicObjectLibrary objectLibrary_;

            Cached0Data(Cached0Data next_) {
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
