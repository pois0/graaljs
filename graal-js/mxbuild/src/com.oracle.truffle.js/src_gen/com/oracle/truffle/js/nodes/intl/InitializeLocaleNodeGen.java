// CheckStyle: start generated
package com.oracle.truffle.js.nodes.intl;

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
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.cast.JSToStringNode;
import com.oracle.truffle.js.runtime.JSContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(InitializeLocaleNode.class)
public final class InitializeLocaleNodeGen extends InitializeLocaleNode implements Provider {

    @CompilationFinal private volatile int state_;
    @Child private JSToStringNode initializeLocaleUsingObject_toStringNode_;

    private InitializeLocaleNodeGen(JSContext context) {
        super(context);
    }

    @Override
    public DynamicObject executeInit(DynamicObject arg0Value, Object arg1Value, Object arg2Value) {
        int state = state_;
        if ((state & 0b1111) != 0 /* is-active initializeLocaleUsingString(DynamicObject, String, Object) || initializeLocaleUsingLocale(DynamicObject, DynamicObject, Object) || initializeLocaleUsingObject(DynamicObject, DynamicObject, Object, JSToStringNode) || initializeLocaleOther(DynamicObject, Object, Object) */) {
            if ((state & 0b1) != 0 /* is-active initializeLocaleUsingString(DynamicObject, String, Object) */ && JSTypesGen.isImplicitString((state & 0b11110000) >>> 4 /* extract-implicit-active 1:String */, arg1Value)) {
                String arg1Value_ = JSTypesGen.asImplicitString((state & 0b11110000) >>> 4 /* extract-implicit-active 1:String */, arg1Value);
                return initializeLocaleUsingString(arg0Value, arg1Value_, arg2Value);
            }
            if ((state & 0b110) != 0 /* is-active initializeLocaleUsingLocale(DynamicObject, DynamicObject, Object) || initializeLocaleUsingObject(DynamicObject, DynamicObject, Object, JSToStringNode) */ && JSTypes.isDynamicObject(arg1Value)) {
                DynamicObject arg1Value_ = (DynamicObject) arg1Value;
                if ((state & 0b10) != 0 /* is-active initializeLocaleUsingLocale(DynamicObject, DynamicObject, Object) */) {
                    if ((JSGuards.isJSLocale(arg1Value_))) {
                        return initializeLocaleUsingLocale(arg0Value, arg1Value_, arg2Value);
                    }
                }
                if ((state & 0b100) != 0 /* is-active initializeLocaleUsingObject(DynamicObject, DynamicObject, Object, JSToStringNode) */) {
                    if ((JSGuards.isJSObject(arg1Value_)) && (!(JSGuards.isJSLocale(arg1Value_)))) {
                        return initializeLocaleUsingObject(arg0Value, arg1Value_, arg2Value, this.initializeLocaleUsingObject_toStringNode_);
                    }
                }
            }
            if ((state & 0b1000) != 0 /* is-active initializeLocaleOther(DynamicObject, Object, Object) */) {
                if ((!(JSGuards.isJSObject(arg1Value))) && (!(JSGuards.isString(arg1Value)))) {
                    return initializeLocaleOther(arg0Value, arg1Value, arg2Value);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value, arg2Value);
    }

    private DynamicObject executeAndSpecialize(DynamicObject arg0Value, Object arg1Value, Object arg2Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        try {
            {
                int stringCast1;
                if ((stringCast1 = JSTypesGen.specializeImplicitString(arg1Value)) != 0) {
                    String arg1Value_ = JSTypesGen.asImplicitString(stringCast1, arg1Value);
                    state = (state | (stringCast1 << 4) /* set-implicit-active 1:String */);
                    this.state_ = state = state | 0b1 /* add-active initializeLocaleUsingString(DynamicObject, String, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return initializeLocaleUsingString(arg0Value, arg1Value_, arg2Value);
                }
            }
            if (JSTypes.isDynamicObject(arg1Value)) {
                DynamicObject arg1Value_ = (DynamicObject) arg1Value;
                if ((JSGuards.isJSLocale(arg1Value_))) {
                    this.state_ = state = state | 0b10 /* add-active initializeLocaleUsingLocale(DynamicObject, DynamicObject, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return initializeLocaleUsingLocale(arg0Value, arg1Value_, arg2Value);
                }
                if ((JSGuards.isJSObject(arg1Value_)) && (!(JSGuards.isJSLocale(arg1Value_)))) {
                    this.initializeLocaleUsingObject_toStringNode_ = super.insert((JSToStringNode.create()));
                    this.state_ = state = state | 0b100 /* add-active initializeLocaleUsingObject(DynamicObject, DynamicObject, Object, JSToStringNode) */;
                    lock.unlock();
                    hasLock = false;
                    return initializeLocaleUsingObject(arg0Value, arg1Value_, arg2Value, this.initializeLocaleUsingObject_toStringNode_);
                }
            }
            if ((!(JSGuards.isJSObject(arg1Value))) && (!(JSGuards.isString(arg1Value)))) {
                this.state_ = state = state | 0b1000 /* add-active initializeLocaleOther(DynamicObject, Object, Object) */;
                lock.unlock();
                hasLock = false;
                return initializeLocaleOther(arg0Value, arg1Value, arg2Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {null, null, null}, arg0Value, arg1Value, arg2Value);
        } finally {
            if (hasLock) {
                lock.unlock();
            }
        }
    }

    @Override
    public NodeCost getCost() {
        int state = state_;
        if ((state & 0b1111) == 0b0) {
            return NodeCost.UNINITIALIZED;
        } else if (((state & 0b1111) & ((state & 0b1111) - 1)) == 0 /* is-single-active  */) {
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
        s = new Object[3];
        s[0] = "initializeLocaleUsingString";
        if ((state & 0b1) != 0 /* is-active initializeLocaleUsingString(DynamicObject, String, Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "initializeLocaleUsingLocale";
        if ((state & 0b10) != 0 /* is-active initializeLocaleUsingLocale(DynamicObject, DynamicObject, Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "initializeLocaleUsingObject";
        if ((state & 0b100) != 0 /* is-active initializeLocaleUsingObject(DynamicObject, DynamicObject, Object, JSToStringNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.initializeLocaleUsingObject_toStringNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "initializeLocaleOther";
        if ((state & 0b1000) != 0 /* is-active initializeLocaleOther(DynamicObject, Object, Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        return Provider.create(data);
    }

    public static InitializeLocaleNode create(JSContext context) {
        return new InitializeLocaleNodeGen(context);
    }

}
