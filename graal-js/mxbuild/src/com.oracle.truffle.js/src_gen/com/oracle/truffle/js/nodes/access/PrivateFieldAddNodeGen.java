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
import com.oracle.truffle.api.object.HiddenKey;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.runtime.JSContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(PrivateFieldAddNode.class)
@SuppressWarnings("unused")
public final class PrivateFieldAddNodeGen extends PrivateFieldAddNode implements Provider {

    private static final LibraryFactory<DynamicObjectLibrary> DYNAMIC_OBJECT_LIBRARY_ = LibraryFactory.resolve(DynamicObjectLibrary.class);

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @Child private FieldAdd0Data fieldAdd0_cache;

    private PrivateFieldAddNodeGen(JSContext context) {
        super(context);
    }

    @ExplodeLoop
    @Override
    public void execute(Object arg0Value, Object arg1Value, Object arg2Value) {
        int state = state_;
        if (state != 0 /* is-active doFieldAdd(DynamicObject, HiddenKey, Object, DynamicObjectLibrary) || doFieldAdd(DynamicObject, HiddenKey, Object, DynamicObjectLibrary) || doFallback(Object, Object, Object) */) {
            if ((state & 0b11) != 0 /* is-active doFieldAdd(DynamicObject, HiddenKey, Object, DynamicObjectLibrary) || doFieldAdd(DynamicObject, HiddenKey, Object, DynamicObjectLibrary) */ && JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if (arg1Value instanceof HiddenKey) {
                    HiddenKey arg1Value_ = (HiddenKey) arg1Value;
                    if ((state & 0b1) != 0 /* is-active doFieldAdd(DynamicObject, HiddenKey, Object, DynamicObjectLibrary) */) {
                        FieldAdd0Data s1_ = this.fieldAdd0_cache;
                        while (s1_ != null) {
                            if ((s1_.access_.accepts(arg0Value_)) && (JSGuards.isJSObject(arg0Value_))) {
                                doFieldAdd(arg0Value_, arg1Value_, arg2Value, s1_.access_);
                                return;
                            }
                            s1_ = s1_.next_;
                        }
                    }
                    if ((state & 0b10) != 0 /* is-active doFieldAdd(DynamicObject, HiddenKey, Object, DynamicObjectLibrary) */) {
                        if ((JSGuards.isJSObject(arg0Value_))) {
                            this.fieldAdd1Boundary(state, arg0Value_, arg1Value_, arg2Value);
                            return;
                        }
                    }
                }
            }
            if ((state & 0b100) != 0 /* is-active doFallback(Object, Object, Object) */) {
                if (fallbackGuard_(arg0Value, arg1Value, arg2Value)) {
                    doFallback(arg0Value, arg1Value, arg2Value);
                    return;
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        executeAndSpecialize(arg0Value, arg1Value, arg2Value);
        return;
    }

    @TruffleBoundary
    private void fieldAdd1Boundary(int state, DynamicObject arg0Value_, HiddenKey arg1Value_, Object arg2Value) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                DynamicObjectLibrary fieldAdd1_access__ = (DYNAMIC_OBJECT_LIBRARY_.getUncached(arg0Value_));
                doFieldAdd(arg0Value_, arg1Value_, arg2Value, fieldAdd1_access__);
                return;
            }
        } finally {
            encapsulating_.set(prev_);
        }
    }

    private void executeAndSpecialize(Object arg0Value, Object arg1Value, Object arg2Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        int exclude = exclude_;
        try {
            if (JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if (arg1Value instanceof HiddenKey) {
                    HiddenKey arg1Value_ = (HiddenKey) arg1Value;
                    if ((exclude) == 0 /* is-not-excluded doFieldAdd(DynamicObject, HiddenKey, Object, DynamicObjectLibrary) */) {
                        int count1_ = 0;
                        FieldAdd0Data s1_ = this.fieldAdd0_cache;
                        if ((state & 0b1) != 0 /* is-active doFieldAdd(DynamicObject, HiddenKey, Object, DynamicObjectLibrary) */) {
                            while (s1_ != null) {
                                if ((s1_.access_.accepts(arg0Value_)) && (JSGuards.isJSObject(arg0Value_))) {
                                    break;
                                }
                                s1_ = s1_.next_;
                                count1_++;
                            }
                        }
                        if (s1_ == null) {
                            if ((JSGuards.isJSObject(arg0Value_)) && count1_ < (3)) {
                                // assert (s1_.access_.accepts(arg0Value_));
                                s1_ = super.insert(new FieldAdd0Data(fieldAdd0_cache));
                                s1_.access_ = s1_.insertAccessor((DYNAMIC_OBJECT_LIBRARY_.create(arg0Value_)));
                                this.fieldAdd0_cache = s1_;
                                this.state_ = state = state | 0b1 /* add-active doFieldAdd(DynamicObject, HiddenKey, Object, DynamicObjectLibrary) */;
                            }
                        }
                        if (s1_ != null) {
                            lock.unlock();
                            hasLock = false;
                            doFieldAdd(arg0Value_, arg1Value_, arg2Value, s1_.access_);
                            return;
                        }
                    }
                    {
                        DynamicObjectLibrary fieldAdd1_access__ = null;
                        {
                            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                            Node prev_ = encapsulating_.set(this);
                            try {
                                if ((JSGuards.isJSObject(arg0Value_))) {
                                    fieldAdd1_access__ = (DYNAMIC_OBJECT_LIBRARY_.getUncached(arg0Value_));
                                    this.exclude_ = exclude = exclude | 0b1 /* add-excluded doFieldAdd(DynamicObject, HiddenKey, Object, DynamicObjectLibrary) */;
                                    this.fieldAdd0_cache = null;
                                    state = state & 0xfffffffe /* remove-active doFieldAdd(DynamicObject, HiddenKey, Object, DynamicObjectLibrary) */;
                                    this.state_ = state = state | 0b10 /* add-active doFieldAdd(DynamicObject, HiddenKey, Object, DynamicObjectLibrary) */;
                                    lock.unlock();
                                    hasLock = false;
                                    doFieldAdd(arg0Value_, arg1Value_, arg2Value, fieldAdd1_access__);
                                    return;
                                }
                            } finally {
                                encapsulating_.set(prev_);
                            }
                        }
                    }
                }
            }
            this.state_ = state = state | 0b100 /* add-active doFallback(Object, Object, Object) */;
            lock.unlock();
            hasLock = false;
            doFallback(arg0Value, arg1Value, arg2Value);
            return;
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
            FieldAdd0Data s1_ = this.fieldAdd0_cache;
            if ((s1_ == null || s1_.next_ == null)) {
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
        s[0] = "doFieldAdd";
        if ((state & 0b1) != 0 /* is-active doFieldAdd(DynamicObject, HiddenKey, Object, DynamicObjectLibrary) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            FieldAdd0Data s1_ = this.fieldAdd0_cache;
            while (s1_ != null) {
                cached.add(Arrays.asList(s1_.access_));
                s1_ = s1_.next_;
            }
            s[2] = cached;
        } else if (exclude != 0 /* is-excluded doFieldAdd(DynamicObject, HiddenKey, Object, DynamicObjectLibrary) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doFieldAdd";
        if ((state & 0b10) != 0 /* is-active doFieldAdd(DynamicObject, HiddenKey, Object, DynamicObjectLibrary) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList());
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doFallback";
        if ((state & 0b100) != 0 /* is-active doFallback(Object, Object, Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        return Provider.create(data);
    }

    private static boolean fallbackGuard_(Object arg0Value, Object arg1Value, Object arg2Value) {
        if (JSTypes.isDynamicObject(arg0Value) && arg1Value instanceof HiddenKey) {
            DynamicObject arg0Value_ = (DynamicObject) arg0Value;
            if ((JSGuards.isJSObject(arg0Value_))) {
                return false;
            }
        }
        return true;
    }

    public static PrivateFieldAddNode create(JSContext context) {
        return new PrivateFieldAddNodeGen(context);
    }

    @GeneratedBy(PrivateFieldAddNode.class)
    private static final class FieldAdd0Data extends Node {

        @Child FieldAdd0Data next_;
        @Child DynamicObjectLibrary access_;

        FieldAdd0Data(FieldAdd0Data next_) {
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
