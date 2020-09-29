// CheckStyle: start generated
package com.oracle.truffle.js.nodes.array;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.access.WritePropertyNode;
import com.oracle.truffle.js.nodes.array.ArrayLengthNode.ArrayLengthWriteNode;
import com.oracle.truffle.js.runtime.JSContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSSetLengthNode.class)
public final class JSSetLengthNodeGen extends JSSetLengthNode implements Provider {

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @Child private ArrayLengthWriteNode setArrayLength_arrayLengthWriteNode_;
    @Child private WritePropertyNode setIntLength_setLengthProperty_;
    @Child private WritePropertyNode setLength_setLengthProperty_;

    private JSSetLengthNodeGen(JSContext context, boolean isStrict) {
        super(context, isStrict);
    }

    @Override
    public Object execute(Object arg0Value, Object arg1Value) {
        int state = state_;
        if ((state & 0b111) != 0 /* is-active setArrayLength(DynamicObject, int, ArrayLengthWriteNode) || setIntLength(DynamicObject, int, WritePropertyNode) || setLength(DynamicObject, Object, WritePropertyNode) */ && JSTypes.isDynamicObject(arg0Value)) {
            DynamicObject arg0Value_ = (DynamicObject) arg0Value;
            if ((state & 0b11) != 0 /* is-active setArrayLength(DynamicObject, int, ArrayLengthWriteNode) || setIntLength(DynamicObject, int, WritePropertyNode) */ && arg1Value instanceof Integer) {
                int arg1Value_ = (int) arg1Value;
                if ((state & 0b1) != 0 /* is-active setArrayLength(DynamicObject, int, ArrayLengthWriteNode) */) {
                    if ((JSSetLengthNode.isArray(arg0Value_))) {
                        return JSSetLengthNode.setArrayLength(arg0Value_, arg1Value_, this.setArrayLength_arrayLengthWriteNode_);
                    }
                }
                if ((state & 0b10) != 0 /* is-active setIntLength(DynamicObject, int, WritePropertyNode) */) {
                    return JSSetLengthNode.setIntLength(arg0Value_, arg1Value_, this.setIntLength_setLengthProperty_);
                }
            }
            if ((state & 0b100) != 0 /* is-active setLength(DynamicObject, Object, WritePropertyNode) */) {
                return JSSetLengthNode.setLength(arg0Value_, arg1Value, this.setLength_setLengthProperty_);
            }
        }
        if ((state & 0b1000) != 0 /* is-active setLengthForeign(Object, Object) */) {
            if ((!(JSGuards.isDynamicObject(arg0Value)))) {
                return JSSetLengthNode.setLengthForeign(arg0Value, arg1Value);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value);
    }

    private Object executeAndSpecialize(Object arg0Value, Object arg1Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        int exclude = exclude_;
        try {
            if (JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if (arg1Value instanceof Integer) {
                    int arg1Value_ = (int) arg1Value;
                    if ((JSSetLengthNode.isArray(arg0Value_))) {
                        this.setArrayLength_arrayLengthWriteNode_ = super.insert((ArrayLengthWriteNode.create(isStrict)));
                        this.state_ = state = state | 0b1 /* add-active setArrayLength(DynamicObject, int, ArrayLengthWriteNode) */;
                        lock.unlock();
                        hasLock = false;
                        return JSSetLengthNode.setArrayLength(arg0Value_, arg1Value_, this.setArrayLength_arrayLengthWriteNode_);
                    }
                    if ((exclude) == 0 /* is-not-excluded setIntLength(DynamicObject, int, WritePropertyNode) */) {
                        this.setIntLength_setLengthProperty_ = super.insert((createWritePropertyNode()));
                        this.state_ = state = state | 0b10 /* add-active setIntLength(DynamicObject, int, WritePropertyNode) */;
                        lock.unlock();
                        hasLock = false;
                        return JSSetLengthNode.setIntLength(arg0Value_, arg1Value_, this.setIntLength_setLengthProperty_);
                    }
                }
                this.setLength_setLengthProperty_ = super.insert((createWritePropertyNode()));
                this.exclude_ = exclude = exclude | 0b1 /* add-excluded setIntLength(DynamicObject, int, WritePropertyNode) */;
                state = state & 0xfffffffd /* remove-active setIntLength(DynamicObject, int, WritePropertyNode) */;
                this.state_ = state = state | 0b100 /* add-active setLength(DynamicObject, Object, WritePropertyNode) */;
                lock.unlock();
                hasLock = false;
                return JSSetLengthNode.setLength(arg0Value_, arg1Value, this.setLength_setLengthProperty_);
            }
            if ((!(JSGuards.isDynamicObject(arg0Value)))) {
                this.state_ = state = state | 0b1000 /* add-active setLengthForeign(Object, Object) */;
                lock.unlock();
                hasLock = false;
                return JSSetLengthNode.setLengthForeign(arg0Value, arg1Value);
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
        s[0] = "setArrayLength";
        if ((state & 0b1) != 0 /* is-active setArrayLength(DynamicObject, int, ArrayLengthWriteNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.setArrayLength_arrayLengthWriteNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "setIntLength";
        if ((state & 0b10) != 0 /* is-active setIntLength(DynamicObject, int, WritePropertyNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.setIntLength_setLengthProperty_));
            s[2] = cached;
        } else if (exclude != 0 /* is-excluded setIntLength(DynamicObject, int, WritePropertyNode) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "setLength";
        if ((state & 0b100) != 0 /* is-active setLength(DynamicObject, Object, WritePropertyNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.setLength_setLengthProperty_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "setLengthForeign";
        if ((state & 0b1000) != 0 /* is-active setLengthForeign(Object, Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        return Provider.create(data);
    }

    public static JSSetLengthNode create(JSContext context, boolean isStrict) {
        return new JSSetLengthNodeGen(context, isStrict);
    }

}
