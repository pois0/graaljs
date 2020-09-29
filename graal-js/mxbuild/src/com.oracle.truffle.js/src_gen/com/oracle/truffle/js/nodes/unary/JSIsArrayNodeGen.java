// CheckStyle: start generated
package com.oracle.truffle.js.nodes.unary;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSIsArrayNode.class)
public final class JSIsArrayNodeGen extends JSIsArrayNode implements Provider {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private Class<?> isArrayClass_cachedClass_;
    @CompilationFinal private boolean isArrayClass_cachedIsArray_;
    @CompilationFinal private boolean isArrayClass_cachedIsProxy_;
    @Child private InteropLibrary primitiveOrForeign_interop_;

    private JSIsArrayNodeGen(boolean jsType) {
        super(jsType);
    }

    @Override
    public boolean execute(Object arg0Value) {
        int state = state_;
        if ((state & 0b11) != 0 /* is-active doIsArrayClass(Object, Class<>, boolean, boolean) || doJSArray(Object) */) {
            if ((state & 0b1) != 0 /* is-active doIsArrayClass(Object, Class<>, boolean, boolean) */) {
                assert (!(this.isArrayClass_cachedIsProxy_));
                assert (this.isArrayClass_cachedClass_ != null);
                if ((this.isArrayClass_cachedClass_.isInstance(arg0Value))) {
                    return JSIsArrayNode.doIsArrayClass(arg0Value, this.isArrayClass_cachedClass_, this.isArrayClass_cachedIsArray_, this.isArrayClass_cachedIsProxy_);
                }
            }
            if ((state & 0b10) != 0 /* is-active doJSArray(Object) */) {
                if ((JSGuards.isJSArray(arg0Value))) {
                    return doJSArray(arg0Value);
                }
            }
        }
        if ((state & 0b1100) != 0 /* is-active doJSProxy(DynamicObject) || doJSObject(DynamicObject) */ && JSTypes.isDynamicObject(arg0Value)) {
            DynamicObject arg0Value_ = (DynamicObject) arg0Value;
            if ((state & 0b100) != 0 /* is-active doJSProxy(DynamicObject) */) {
                if ((JSGuards.isJSProxy(arg0Value_))) {
                    return doJSProxy(arg0Value_);
                }
            }
            if ((state & 0b1000) != 0 /* is-active doJSObject(DynamicObject) */) {
                if ((JSGuards.isJSDynamicObject(arg0Value_)) && (!(JSGuards.isJSArray(arg0Value_))) && (!(JSGuards.isJSProxy(arg0Value_)))) {
                    return doJSObject(arg0Value_);
                }
            }
        }
        if ((state & 0b110000) != 0 /* is-active doNotObject(Object) || doPrimitiveOrForeign(Object, InteropLibrary) */) {
            if ((state & 0b10000) != 0 /* is-active doNotObject(Object) */) {
                if ((!(JSGuards.isJSDynamicObject(arg0Value)))) {
                    assert (jsType);
                    return doNotObject(arg0Value);
                }
            }
            if ((state & 0b100000) != 0 /* is-active doPrimitiveOrForeign(Object, InteropLibrary) */) {
                if ((!(JSGuards.isJSDynamicObject(arg0Value)))) {
                    assert (!(jsType));
                    return doPrimitiveOrForeign(arg0Value, this.primitiveOrForeign_interop_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    private boolean executeAndSpecialize(Object arg0Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        int exclude = exclude_;
        try {
            if ((exclude) == 0 /* is-not-excluded doIsArrayClass(Object, Class<>, boolean, boolean) */) {
                boolean IsArrayClass_duplicateFound_ = false;
                if ((state & 0b1) != 0 /* is-active doIsArrayClass(Object, Class<>, boolean, boolean) */) {
                    assert (!(this.isArrayClass_cachedIsProxy_));
                    assert (this.isArrayClass_cachedClass_ != null);
                    if ((this.isArrayClass_cachedClass_.isInstance(arg0Value))) {
                        IsArrayClass_duplicateFound_ = true;
                    }
                }
                if (!IsArrayClass_duplicateFound_) {
                    {
                        boolean isArrayClass_cachedIsProxy__ = (JSGuards.isJSProxy(arg0Value));
                        if ((!(isArrayClass_cachedIsProxy__))) {
                            Class<?> isArrayClass_cachedClass__ = (JSGuards.getClassIfJSDynamicObject(arg0Value));
                            if ((isArrayClass_cachedClass__ != null) && (isArrayClass_cachedClass__.isInstance(arg0Value)) && ((state & 0b1)) == 0 /* is-not-active doIsArrayClass(Object, Class<>, boolean, boolean) */) {
                                this.isArrayClass_cachedClass_ = isArrayClass_cachedClass__;
                                this.isArrayClass_cachedIsArray_ = (JSGuards.isJSArray(arg0Value));
                                this.isArrayClass_cachedIsProxy_ = isArrayClass_cachedIsProxy__;
                                this.state_ = state = state | 0b1 /* add-active doIsArrayClass(Object, Class<>, boolean, boolean) */;
                                IsArrayClass_duplicateFound_ = true;
                            }
                        }
                    }
                }
                if (IsArrayClass_duplicateFound_) {
                    lock.unlock();
                    hasLock = false;
                    return JSIsArrayNode.doIsArrayClass(arg0Value, this.isArrayClass_cachedClass_, this.isArrayClass_cachedIsArray_, this.isArrayClass_cachedIsProxy_);
                }
            }
            if ((JSGuards.isJSArray(arg0Value))) {
                this.exclude_ = exclude = exclude | 0b1 /* add-excluded doIsArrayClass(Object, Class<>, boolean, boolean) */;
                state = state & 0xfffffffe /* remove-active doIsArrayClass(Object, Class<>, boolean, boolean) */;
                this.state_ = state = state | 0b10 /* add-active doJSArray(Object) */;
                lock.unlock();
                hasLock = false;
                return doJSArray(arg0Value);
            }
            if (JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if ((JSGuards.isJSProxy(arg0Value_))) {
                    this.state_ = state = state | 0b100 /* add-active doJSProxy(DynamicObject) */;
                    lock.unlock();
                    hasLock = false;
                    return doJSProxy(arg0Value_);
                }
                if ((JSGuards.isJSDynamicObject(arg0Value_)) && (!(JSGuards.isJSArray(arg0Value_))) && (!(JSGuards.isJSProxy(arg0Value_)))) {
                    this.exclude_ = exclude = exclude | 0b1 /* add-excluded doIsArrayClass(Object, Class<>, boolean, boolean) */;
                    state = state & 0xfffffffe /* remove-active doIsArrayClass(Object, Class<>, boolean, boolean) */;
                    this.state_ = state = state | 0b1000 /* add-active doJSObject(DynamicObject) */;
                    lock.unlock();
                    hasLock = false;
                    return doJSObject(arg0Value_);
                }
            }
            if ((!(JSGuards.isJSDynamicObject(arg0Value))) && (jsType)) {
                this.state_ = state = state | 0b10000 /* add-active doNotObject(Object) */;
                lock.unlock();
                hasLock = false;
                return doNotObject(arg0Value);
            }
            if ((!(JSGuards.isJSDynamicObject(arg0Value))) && (!(jsType))) {
                this.primitiveOrForeign_interop_ = super.insert((INTEROP_LIBRARY_.createDispatched(6)));
                this.state_ = state = state | 0b100000 /* add-active doPrimitiveOrForeign(Object, InteropLibrary) */;
                lock.unlock();
                hasLock = false;
                return doPrimitiveOrForeign(arg0Value, this.primitiveOrForeign_interop_);
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
            return NodeCost.MONOMORPHIC;
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[7];
        Object[] s;
        data[0] = 0;
        int state = state_;
        int exclude = exclude_;
        s = new Object[3];
        s[0] = "doIsArrayClass";
        if ((state & 0b1) != 0 /* is-active doIsArrayClass(Object, Class<>, boolean, boolean) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.isArrayClass_cachedClass_, this.isArrayClass_cachedIsArray_, this.isArrayClass_cachedIsProxy_));
            s[2] = cached;
        } else if (exclude != 0 /* is-excluded doIsArrayClass(Object, Class<>, boolean, boolean) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doJSArray";
        if ((state & 0b10) != 0 /* is-active doJSArray(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doJSProxy";
        if ((state & 0b100) != 0 /* is-active doJSProxy(DynamicObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doJSObject";
        if ((state & 0b1000) != 0 /* is-active doJSObject(DynamicObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doNotObject";
        if ((state & 0b10000) != 0 /* is-active doNotObject(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "doPrimitiveOrForeign";
        if ((state & 0b100000) != 0 /* is-active doPrimitiveOrForeign(Object, InteropLibrary) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.primitiveOrForeign_interop_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        return Provider.create(data);
    }

    public static JSIsArrayNode create(boolean jsType) {
        return new JSIsArrayNodeGen(jsType);
    }

}
