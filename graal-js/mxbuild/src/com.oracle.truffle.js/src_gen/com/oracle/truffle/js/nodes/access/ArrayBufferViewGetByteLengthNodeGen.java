// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.array.TypedArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(ArrayBufferViewGetByteLengthNode.class)
public final class ArrayBufferViewGetByteLengthNodeGen extends ArrayBufferViewGetByteLengthNode implements Provider {

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private GetByteLengthData getByteLength_cache;

    private ArrayBufferViewGetByteLengthNodeGen(JSContext context) {
        super(context);
    }

    @ExplodeLoop
    @Override
    public int executeInt(DynamicObject arg0Value) {
        int state = state_;
        if (state != 0 /* is-active getByteLengthDetached(DynamicObject) || getByteLength(DynamicObject, TypedArray) || getByteLengthOverLimit(DynamicObject) || getByteLengthNoObj(DynamicObject) */) {
            if ((state & 0b1) != 0 /* is-active getByteLengthDetached(DynamicObject) */) {
                if ((JSGuards.isJSArrayBufferView(arg0Value)) && (hasDetachedBuffer(arg0Value))) {
                    return getByteLengthDetached(arg0Value);
                }
            }
            if ((state & 0b10) != 0 /* is-active getByteLength(DynamicObject, TypedArray) */ && (JSGuards.isJSArrayBufferView(arg0Value)) && (!(hasDetachedBuffer(arg0Value)))) {
                GetByteLengthData s2_ = this.getByteLength_cache;
                while (s2_ != null) {
                    if ((s2_.cachedArray_ == ArrayBufferViewGetByteLengthNode.getArrayType(arg0Value))) {
                        return getByteLength(arg0Value, s2_.cachedArray_);
                    }
                    s2_ = s2_.next_;
                }
            }
            if ((state & 0b100) != 0 /* is-active getByteLengthOverLimit(DynamicObject) */) {
                if ((JSGuards.isJSArrayBufferView(arg0Value)) && (!(hasDetachedBuffer(arg0Value)))) {
                    return getByteLengthOverLimit(arg0Value);
                }
            }
            if ((state & 0b1000) != 0 /* is-active getByteLengthNoObj(DynamicObject) */) {
                if ((!(JSGuards.isJSArrayBufferView(arg0Value)))) {
                    return getByteLengthNoObj(arg0Value);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    private int executeAndSpecialize(DynamicObject arg0Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        int exclude = exclude_;
        try {
            if ((JSGuards.isJSArrayBufferView(arg0Value)) && (hasDetachedBuffer(arg0Value))) {
                this.state_ = state = state | 0b1 /* add-active getByteLengthDetached(DynamicObject) */;
                lock.unlock();
                hasLock = false;
                return getByteLengthDetached(arg0Value);
            }
            if ((exclude) == 0 /* is-not-excluded getByteLength(DynamicObject, TypedArray) */ && (JSGuards.isJSArrayBufferView(arg0Value)) && (!(hasDetachedBuffer(arg0Value)))) {
                int count2_ = 0;
                GetByteLengthData s2_ = this.getByteLength_cache;
                if ((state & 0b10) != 0 /* is-active getByteLength(DynamicObject, TypedArray) */) {
                    while (s2_ != null) {
                        if ((s2_.cachedArray_ == ArrayBufferViewGetByteLengthNode.getArrayType(arg0Value))) {
                            break;
                        }
                        s2_ = s2_.next_;
                        count2_++;
                    }
                }
                if (s2_ == null) {
                    {
                        TypedArray cachedArray__ = (ArrayBufferViewGetByteLengthNode.getArrayType(arg0Value));
                        if ((cachedArray__ == ArrayBufferViewGetByteLengthNode.getArrayType(arg0Value)) && count2_ < (3)) {
                            s2_ = new GetByteLengthData(getByteLength_cache);
                            s2_.cachedArray_ = cachedArray__;
                            this.getByteLength_cache = s2_;
                            this.state_ = state = state | 0b10 /* add-active getByteLength(DynamicObject, TypedArray) */;
                        }
                    }
                }
                if (s2_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return getByteLength(arg0Value, s2_.cachedArray_);
                }
            }
            if ((JSGuards.isJSArrayBufferView(arg0Value)) && (!(hasDetachedBuffer(arg0Value)))) {
                this.exclude_ = exclude = exclude | 0b1 /* add-excluded getByteLength(DynamicObject, TypedArray) */;
                this.getByteLength_cache = null;
                state = state & 0xfffffffd /* remove-active getByteLength(DynamicObject, TypedArray) */;
                this.state_ = state = state | 0b100 /* add-active getByteLengthOverLimit(DynamicObject) */;
                lock.unlock();
                hasLock = false;
                return getByteLengthOverLimit(arg0Value);
            }
            if ((!(JSGuards.isJSArrayBufferView(arg0Value)))) {
                this.state_ = state = state | 0b1000 /* add-active getByteLengthNoObj(DynamicObject) */;
                lock.unlock();
                hasLock = false;
                return getByteLengthNoObj(arg0Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {null}, arg0Value);
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
            GetByteLengthData s2_ = this.getByteLength_cache;
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
        s[0] = "getByteLengthDetached";
        if ((state & 0b1) != 0 /* is-active getByteLengthDetached(DynamicObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "getByteLength";
        if ((state & 0b10) != 0 /* is-active getByteLength(DynamicObject, TypedArray) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            GetByteLengthData s2_ = this.getByteLength_cache;
            while (s2_ != null) {
                cached.add(Arrays.asList(s2_.cachedArray_));
                s2_ = s2_.next_;
            }
            s[2] = cached;
        } else if (exclude != 0 /* is-excluded getByteLength(DynamicObject, TypedArray) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "getByteLengthOverLimit";
        if ((state & 0b100) != 0 /* is-active getByteLengthOverLimit(DynamicObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "getByteLengthNoObj";
        if ((state & 0b1000) != 0 /* is-active getByteLengthNoObj(DynamicObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        return Provider.create(data);
    }

    public static ArrayBufferViewGetByteLengthNode create(JSContext context) {
        return new ArrayBufferViewGetByteLengthNodeGen(context);
    }

    @GeneratedBy(ArrayBufferViewGetByteLengthNode.class)
    private static final class GetByteLengthData {

        @CompilationFinal GetByteLengthData next_;
        @CompilationFinal TypedArray cachedArray_;

        GetByteLengthData(GetByteLengthData next_) {
            this.next_ = next_;
        }

    }
}
