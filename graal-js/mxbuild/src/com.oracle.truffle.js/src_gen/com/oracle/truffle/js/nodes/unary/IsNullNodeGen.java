// CheckStyle: start generated
package com.oracle.truffle.js.nodes.unary;

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
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(IsNullNode.class)
@SuppressWarnings("unused")
public final class IsNullNodeGen extends IsNullNode implements Provider {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @Child private Cached0Data cached0_cache;

    private IsNullNodeGen(JavaScriptNode operand, boolean leftConstant) {
        super(operand, leftConstant);
    }

    @ExplodeLoop
    @Override
    public Object execute(VirtualFrame frameValue, Object operandNodeValue) {
        int state = state_;
        if (state != 0 /* is-active doNull(Object) || doUndefined(Object) || doObject(Object) || doCached(Object, InteropLibrary) || doCached(Object, InteropLibrary) */) {
            if ((state & 0b1) != 0 /* is-active doNull(Object) */) {
                if ((JSGuards.isJSNull(operandNodeValue))) {
                    return IsNullNode.doNull(operandNodeValue);
                }
            }
            if ((state & 0b10) != 0 /* is-active doUndefined(Object) */) {
                if ((JSGuards.isUndefined(operandNodeValue))) {
                    return IsNullNode.doUndefined(operandNodeValue);
                }
            }
            if ((state & 0b100) != 0 /* is-active doObject(Object) */) {
                if ((JSGuards.isJSObject(operandNodeValue))) {
                    return IsNullNode.doObject(operandNodeValue);
                }
            }
            if ((state & 0b1000) != 0 /* is-active doCached(Object, InteropLibrary) */) {
                Cached0Data s4_ = this.cached0_cache;
                while (s4_ != null) {
                    if ((s4_.interop_.accepts(operandNodeValue)) && (!(JSGuards.isJSDynamicObject(operandNodeValue)))) {
                        return IsNullNode.doCached(operandNodeValue, s4_.interop_);
                    }
                    s4_ = s4_.next_;
                }
            }
            if ((state & 0b10000) != 0 /* is-active doCached(Object, InteropLibrary) */) {
                if ((!(JSGuards.isJSDynamicObject(operandNodeValue)))) {
                    return this.cached1Boundary(state, operandNodeValue);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue);
    }

    @TruffleBoundary
    private Object cached1Boundary(int state, Object operandNodeValue) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary cached1_interop__ = (INTEROP_LIBRARY_.getUncached(operandNodeValue));
                return IsNullNode.doCached(operandNodeValue, cached1_interop__);
            }
        } finally {
            encapsulating_.set(prev_);
        }
    }

    @ExplodeLoop
    @Override
    public Object execute(VirtualFrame frameValue) {
        int state = state_;
        Object operandNodeValue_ = super.operandNode.execute(frameValue);
        if (state != 0 /* is-active doNull(Object) || doUndefined(Object) || doObject(Object) || doCached(Object, InteropLibrary) || doCached(Object, InteropLibrary) */) {
            if ((state & 0b1) != 0 /* is-active doNull(Object) */) {
                if ((JSGuards.isJSNull(operandNodeValue_))) {
                    return IsNullNode.doNull(operandNodeValue_);
                }
            }
            if ((state & 0b10) != 0 /* is-active doUndefined(Object) */) {
                if ((JSGuards.isUndefined(operandNodeValue_))) {
                    return IsNullNode.doUndefined(operandNodeValue_);
                }
            }
            if ((state & 0b100) != 0 /* is-active doObject(Object) */) {
                if ((JSGuards.isJSObject(operandNodeValue_))) {
                    return IsNullNode.doObject(operandNodeValue_);
                }
            }
            if ((state & 0b1000) != 0 /* is-active doCached(Object, InteropLibrary) */) {
                Cached0Data s4_ = this.cached0_cache;
                while (s4_ != null) {
                    if ((s4_.interop_.accepts(operandNodeValue_)) && (!(JSGuards.isJSDynamicObject(operandNodeValue_)))) {
                        return IsNullNode.doCached(operandNodeValue_, s4_.interop_);
                    }
                    s4_ = s4_.next_;
                }
            }
            if ((state & 0b10000) != 0 /* is-active doCached(Object, InteropLibrary) */) {
                if ((!(JSGuards.isJSDynamicObject(operandNodeValue_)))) {
                    return this.cached1Boundary0(state, operandNodeValue_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue_);
    }

    @TruffleBoundary
    private Object cached1Boundary0(int state, Object operandNodeValue_) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary cached1_interop__ = (INTEROP_LIBRARY_.getUncached(operandNodeValue_));
                return IsNullNode.doCached(operandNodeValue_, cached1_interop__);
            }
        } finally {
            encapsulating_.set(prev_);
        }
    }

    @ExplodeLoop
    @Override
    public boolean executeBoolean(VirtualFrame frameValue) {
        int state = state_;
        Object operandNodeValue_ = super.operandNode.execute(frameValue);
        if (state != 0 /* is-active doNull(Object) || doUndefined(Object) || doObject(Object) || doCached(Object, InteropLibrary) || doCached(Object, InteropLibrary) */) {
            if ((state & 0b1) != 0 /* is-active doNull(Object) */) {
                if ((JSGuards.isJSNull(operandNodeValue_))) {
                    return IsNullNode.doNull(operandNodeValue_);
                }
            }
            if ((state & 0b10) != 0 /* is-active doUndefined(Object) */) {
                if ((JSGuards.isUndefined(operandNodeValue_))) {
                    return IsNullNode.doUndefined(operandNodeValue_);
                }
            }
            if ((state & 0b100) != 0 /* is-active doObject(Object) */) {
                if ((JSGuards.isJSObject(operandNodeValue_))) {
                    return IsNullNode.doObject(operandNodeValue_);
                }
            }
            if ((state & 0b1000) != 0 /* is-active doCached(Object, InteropLibrary) */) {
                Cached0Data s4_ = this.cached0_cache;
                while (s4_ != null) {
                    if ((s4_.interop_.accepts(operandNodeValue_)) && (!(JSGuards.isJSDynamicObject(operandNodeValue_)))) {
                        return IsNullNode.doCached(operandNodeValue_, s4_.interop_);
                    }
                    s4_ = s4_.next_;
                }
            }
            if ((state & 0b10000) != 0 /* is-active doCached(Object, InteropLibrary) */) {
                if ((!(JSGuards.isJSDynamicObject(operandNodeValue_)))) {
                    return this.cached1Boundary1(state, operandNodeValue_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue_);
    }

    @TruffleBoundary
    private boolean cached1Boundary1(int state, Object operandNodeValue_) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary cached1_interop__ = (INTEROP_LIBRARY_.getUncached(operandNodeValue_));
                return IsNullNode.doCached(operandNodeValue_, cached1_interop__);
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

    private boolean executeAndSpecialize(Object operandNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        int exclude = exclude_;
        try {
            if ((JSGuards.isJSNull(operandNodeValue))) {
                this.state_ = state = state | 0b1 /* add-active doNull(Object) */;
                lock.unlock();
                hasLock = false;
                return IsNullNode.doNull(operandNodeValue);
            }
            if ((JSGuards.isUndefined(operandNodeValue))) {
                this.state_ = state = state | 0b10 /* add-active doUndefined(Object) */;
                lock.unlock();
                hasLock = false;
                return IsNullNode.doUndefined(operandNodeValue);
            }
            if ((JSGuards.isJSObject(operandNodeValue))) {
                this.state_ = state = state | 0b100 /* add-active doObject(Object) */;
                lock.unlock();
                hasLock = false;
                return IsNullNode.doObject(operandNodeValue);
            }
            if ((exclude) == 0 /* is-not-excluded doCached(Object, InteropLibrary) */) {
                int count4_ = 0;
                Cached0Data s4_ = this.cached0_cache;
                if ((state & 0b1000) != 0 /* is-active doCached(Object, InteropLibrary) */) {
                    while (s4_ != null) {
                        if ((s4_.interop_.accepts(operandNodeValue)) && (!(JSGuards.isJSDynamicObject(operandNodeValue)))) {
                            break;
                        }
                        s4_ = s4_.next_;
                        count4_++;
                    }
                }
                if (s4_ == null) {
                    if ((!(JSGuards.isJSDynamicObject(operandNodeValue))) && count4_ < (IsNullNode.INTEROP_LIMIT)) {
                        // assert (s4_.interop_.accepts(operandNodeValue));
                        s4_ = super.insert(new Cached0Data(cached0_cache));
                        s4_.interop_ = s4_.insertAccessor((INTEROP_LIBRARY_.create(operandNodeValue)));
                        this.cached0_cache = s4_;
                        this.state_ = state = state | 0b1000 /* add-active doCached(Object, InteropLibrary) */;
                    }
                }
                if (s4_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return IsNullNode.doCached(operandNodeValue, s4_.interop_);
                }
            }
            {
                InteropLibrary cached1_interop__ = null;
                {
                    EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                    Node prev_ = encapsulating_.set(this);
                    try {
                        if ((!(JSGuards.isJSDynamicObject(operandNodeValue)))) {
                            cached1_interop__ = (INTEROP_LIBRARY_.getUncached(operandNodeValue));
                            this.exclude_ = exclude = exclude | 0b1 /* add-excluded doCached(Object, InteropLibrary) */;
                            this.cached0_cache = null;
                            state = state & 0xfffffff7 /* remove-active doCached(Object, InteropLibrary) */;
                            this.state_ = state = state | 0b10000 /* add-active doCached(Object, InteropLibrary) */;
                            lock.unlock();
                            hasLock = false;
                            return IsNullNode.doCached(operandNodeValue, cached1_interop__);
                        }
                    } finally {
                        encapsulating_.set(prev_);
                    }
                }
            }
            throw new UnsupportedSpecializationException(this, new Node[] {super.operandNode}, operandNodeValue);
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
            Cached0Data s4_ = this.cached0_cache;
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
        s[0] = "doNull";
        if ((state & 0b1) != 0 /* is-active doNull(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doUndefined";
        if ((state & 0b10) != 0 /* is-active doUndefined(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doObject";
        if ((state & 0b100) != 0 /* is-active doObject(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doCached";
        if ((state & 0b1000) != 0 /* is-active doCached(Object, InteropLibrary) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            Cached0Data s4_ = this.cached0_cache;
            while (s4_ != null) {
                cached.add(Arrays.asList(s4_.interop_));
                s4_ = s4_.next_;
            }
            s[2] = cached;
        } else if (exclude != 0 /* is-excluded doCached(Object, InteropLibrary) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doCached";
        if ((state & 0b10000) != 0 /* is-active doCached(Object, InteropLibrary) */) {
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

    public static IsNullNode create(JavaScriptNode operand, boolean leftConstant) {
        return new IsNullNodeGen(operand, leftConstant);
    }

    @GeneratedBy(IsNullNode.class)
    private static final class Cached0Data extends Node {

        @Child Cached0Data next_;
        @Child InteropLibrary interop_;

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
