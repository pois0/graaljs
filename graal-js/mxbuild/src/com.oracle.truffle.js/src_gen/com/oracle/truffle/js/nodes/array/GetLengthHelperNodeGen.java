// CheckStyle: start generated
package com.oracle.truffle.js.nodes.array;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.EncapsulatingNodeReference;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.access.PropertyNode;
import com.oracle.truffle.js.nodes.array.ArrayLengthNode.ArrayLengthReadNode;
import com.oracle.truffle.js.runtime.JSContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(GetLengthHelperNode.class)
@SuppressWarnings("unused")
final class GetLengthHelperNodeGen extends GetLengthHelperNode implements Provider {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @Child private ArrayLengthReadNode getArrayLengthInt_arrayLengthReadNode_;
    @Child private ArrayLengthReadNode getArrayLength_arrayLengthReadNode_;
    @Child private PropertyNode getLengthDynamicObject_getLengthPropertyNode_;
    @Child private GetLengthForeign0Data getLengthForeign0_cache;

    private GetLengthHelperNodeGen(JSContext context) {
        super(context);
    }

    @ExplodeLoop
    @Override
    public Object execute(Object arg0Value, boolean arg1Value) {
        int state = state_;
        if (state != 0 /* is-active getArrayLengthInt(DynamicObject, boolean, ArrayLengthReadNode) || getArrayLength(DynamicObject, boolean, ArrayLengthReadNode) || getLengthDynamicObject(DynamicObject, boolean, PropertyNode) || getLengthForeign(Object, boolean, InteropLibrary) || getLengthForeign(Object, boolean, InteropLibrary) */) {
            if ((state & 0b111) != 0 /* is-active getArrayLengthInt(DynamicObject, boolean, ArrayLengthReadNode) || getArrayLength(DynamicObject, boolean, ArrayLengthReadNode) || getLengthDynamicObject(DynamicObject, boolean, PropertyNode) */ && JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if ((state & 0b1) != 0 /* is-active getArrayLengthInt(DynamicObject, boolean, ArrayLengthReadNode) */) {
                    if ((arg1Value)) {
                        try {
                            return getArrayLengthInt(arg0Value_, arg1Value, this.getArrayLengthInt_arrayLengthReadNode_);
                        } catch (UnexpectedResultException ex) {
                            // implicit transferToInterpreterAndInvalidate()
                            Lock lock = getLock();
                            lock.lock();
                            try {
                                this.exclude_ = this.exclude_ | 0b1 /* add-excluded getArrayLengthInt(DynamicObject, boolean, ArrayLengthReadNode) */;
                                this.state_ = this.state_ & 0xfffffffe /* remove-active getArrayLengthInt(DynamicObject, boolean, ArrayLengthReadNode) */;
                            } finally {
                                lock.unlock();
                            }
                            return ex.getResult();
                        }
                    }
                }
                if ((state & 0b10) != 0 /* is-active getArrayLength(DynamicObject, boolean, ArrayLengthReadNode) */) {
                    if ((arg1Value)) {
                        return getArrayLength(arg0Value_, arg1Value, this.getArrayLength_arrayLengthReadNode_);
                    }
                }
                if ((state & 0b100) != 0 /* is-active getLengthDynamicObject(DynamicObject, boolean, PropertyNode) */) {
                    if ((!(arg1Value))) {
                        return getLengthDynamicObject(arg0Value_, arg1Value, this.getLengthDynamicObject_getLengthPropertyNode_);
                    }
                }
            }
            if ((state & 0b11000) != 0 /* is-active getLengthForeign(Object, boolean, InteropLibrary) || getLengthForeign(Object, boolean, InteropLibrary) */) {
                if ((state & 0b1000) != 0 /* is-active getLengthForeign(Object, boolean, InteropLibrary) */) {
                    GetLengthForeign0Data s4_ = this.getLengthForeign0_cache;
                    while (s4_ != null) {
                        if ((s4_.interop_.accepts(arg0Value)) && (!(JSGuards.isDynamicObject(arg0Value)))) {
                            return getLengthForeign(arg0Value, arg1Value, s4_.interop_);
                        }
                        s4_ = s4_.next_;
                    }
                }
                if ((state & 0b10000) != 0 /* is-active getLengthForeign(Object, boolean, InteropLibrary) */) {
                    if ((!(JSGuards.isDynamicObject(arg0Value)))) {
                        return this.getLengthForeign1Boundary(state, arg0Value, arg1Value);
                    }
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value);
    }

    @TruffleBoundary
    private Object getLengthForeign1Boundary(int state, Object arg0Value, boolean arg1Value) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary getLengthForeign1_interop__ = (INTEROP_LIBRARY_.getUncached(arg0Value));
                return getLengthForeign(arg0Value, arg1Value, getLengthForeign1_interop__);
            }
        } finally {
            encapsulating_.set(prev_);
        }
    }

    private Object executeAndSpecialize(Object arg0Value, boolean arg1Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        int exclude = exclude_;
        try {
            if (JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if (((exclude & 0b1)) == 0 /* is-not-excluded getArrayLengthInt(DynamicObject, boolean, ArrayLengthReadNode) */) {
                    if ((arg1Value)) {
                        this.getArrayLengthInt_arrayLengthReadNode_ = super.insert((ArrayLengthReadNode.create()));
                        this.state_ = state = state | 0b1 /* add-active getArrayLengthInt(DynamicObject, boolean, ArrayLengthReadNode) */;
                        try {
                            lock.unlock();
                            hasLock = false;
                            return getArrayLengthInt(arg0Value_, arg1Value, this.getArrayLengthInt_arrayLengthReadNode_);
                        } catch (UnexpectedResultException ex) {
                            // implicit transferToInterpreterAndInvalidate()
                            lock.lock();
                            try {
                                this.exclude_ = this.exclude_ | 0b1 /* add-excluded getArrayLengthInt(DynamicObject, boolean, ArrayLengthReadNode) */;
                                this.state_ = this.state_ & 0xfffffffe /* remove-active getArrayLengthInt(DynamicObject, boolean, ArrayLengthReadNode) */;
                            } finally {
                                lock.unlock();
                            }
                            return ex.getResult();
                        }
                    }
                }
                if ((arg1Value)) {
                    this.getArrayLength_arrayLengthReadNode_ = super.insert((ArrayLengthReadNode.create()));
                    this.state_ = state = state | 0b10 /* add-active getArrayLength(DynamicObject, boolean, ArrayLengthReadNode) */;
                    lock.unlock();
                    hasLock = false;
                    return getArrayLength(arg0Value_, arg1Value, this.getArrayLength_arrayLengthReadNode_);
                }
                if ((!(arg1Value))) {
                    this.getLengthDynamicObject_getLengthPropertyNode_ = super.insert((createLengthProperty()));
                    this.state_ = state = state | 0b100 /* add-active getLengthDynamicObject(DynamicObject, boolean, PropertyNode) */;
                    lock.unlock();
                    hasLock = false;
                    return getLengthDynamicObject(arg0Value_, arg1Value, this.getLengthDynamicObject_getLengthPropertyNode_);
                }
            }
            if (((exclude & 0b10)) == 0 /* is-not-excluded getLengthForeign(Object, boolean, InteropLibrary) */) {
                int count4_ = 0;
                GetLengthForeign0Data s4_ = this.getLengthForeign0_cache;
                if ((state & 0b1000) != 0 /* is-active getLengthForeign(Object, boolean, InteropLibrary) */) {
                    while (s4_ != null) {
                        if ((s4_.interop_.accepts(arg0Value)) && (!(JSGuards.isDynamicObject(arg0Value)))) {
                            break;
                        }
                        s4_ = s4_.next_;
                        count4_++;
                    }
                }
                if (s4_ == null) {
                    if ((!(JSGuards.isDynamicObject(arg0Value))) && count4_ < (3)) {
                        // assert (s4_.interop_.accepts(arg0Value));
                        s4_ = super.insert(new GetLengthForeign0Data(getLengthForeign0_cache));
                        s4_.interop_ = s4_.insertAccessor((INTEROP_LIBRARY_.create(arg0Value)));
                        this.getLengthForeign0_cache = s4_;
                        this.state_ = state = state | 0b1000 /* add-active getLengthForeign(Object, boolean, InteropLibrary) */;
                    }
                }
                if (s4_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return getLengthForeign(arg0Value, arg1Value, s4_.interop_);
                }
            }
            {
                InteropLibrary getLengthForeign1_interop__ = null;
                {
                    EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                    Node prev_ = encapsulating_.set(this);
                    try {
                        if ((!(JSGuards.isDynamicObject(arg0Value)))) {
                            getLengthForeign1_interop__ = (INTEROP_LIBRARY_.getUncached(arg0Value));
                            this.exclude_ = exclude = exclude | 0b10 /* add-excluded getLengthForeign(Object, boolean, InteropLibrary) */;
                            this.getLengthForeign0_cache = null;
                            state = state & 0xfffffff7 /* remove-active getLengthForeign(Object, boolean, InteropLibrary) */;
                            this.state_ = state = state | 0b10000 /* add-active getLengthForeign(Object, boolean, InteropLibrary) */;
                            lock.unlock();
                            hasLock = false;
                            return getLengthForeign(arg0Value, arg1Value, getLengthForeign1_interop__);
                        }
                    } finally {
                        encapsulating_.set(prev_);
                    }
                }
            }
            throw new UnsupportedSpecializationException(this, new Node[] {null, null}, arg0Value, arg1Value);
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
            GetLengthForeign0Data s4_ = this.getLengthForeign0_cache;
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
        s[0] = "getArrayLengthInt";
        if ((state & 0b1) != 0 /* is-active getArrayLengthInt(DynamicObject, boolean, ArrayLengthReadNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.getArrayLengthInt_arrayLengthReadNode_));
            s[2] = cached;
        } else if ((exclude & 0b1) != 0 /* is-excluded getArrayLengthInt(DynamicObject, boolean, ArrayLengthReadNode) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "getArrayLength";
        if ((state & 0b10) != 0 /* is-active getArrayLength(DynamicObject, boolean, ArrayLengthReadNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.getArrayLength_arrayLengthReadNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "getLengthDynamicObject";
        if ((state & 0b100) != 0 /* is-active getLengthDynamicObject(DynamicObject, boolean, PropertyNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.getLengthDynamicObject_getLengthPropertyNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "getLengthForeign";
        if ((state & 0b1000) != 0 /* is-active getLengthForeign(Object, boolean, InteropLibrary) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            GetLengthForeign0Data s4_ = this.getLengthForeign0_cache;
            while (s4_ != null) {
                cached.add(Arrays.asList(s4_.interop_));
                s4_ = s4_.next_;
            }
            s[2] = cached;
        } else if ((exclude & 0b10) != 0 /* is-excluded getLengthForeign(Object, boolean, InteropLibrary) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "getLengthForeign";
        if ((state & 0b10000) != 0 /* is-active getLengthForeign(Object, boolean, InteropLibrary) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList());
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        return Provider.create(data);
    }

    public static GetLengthHelperNode create(JSContext context) {
        return new GetLengthHelperNodeGen(context);
    }

    @GeneratedBy(GetLengthHelperNode.class)
    private static final class GetLengthForeign0Data extends Node {

        @Child GetLengthForeign0Data next_;
        @Child InteropLibrary interop_;

        GetLengthForeign0Data(GetLengthForeign0Data next_) {
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
