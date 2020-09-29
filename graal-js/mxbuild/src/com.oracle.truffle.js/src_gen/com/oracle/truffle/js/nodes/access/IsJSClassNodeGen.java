// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.object.Shape;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.runtime.builtins.JSClass;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(IsJSClassNode.class)
public final class IsJSClassNodeGen extends IsJSClassNode implements Provider {

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private IsInstanceShapeData isInstanceShape_cache;

    private IsJSClassNodeGen(JSClass jsclass, JavaScriptNode operand) {
        super(jsclass, operand);
    }

    @ExplodeLoop
    @Override
    public Object execute(VirtualFrame frameValue, Object operandNodeValue) {
        int state = state_;
        if ((state & 0b11) != 0 /* is-active doIsInstanceShape(DynamicObject, Shape, boolean) || doIsInstanceObject(DynamicObject) */ && JSTypes.isDynamicObject(operandNodeValue)) {
            DynamicObject operandNodeValue_ = (DynamicObject) operandNodeValue;
            if ((state & 0b1) != 0 /* is-active doIsInstanceShape(DynamicObject, Shape, boolean) */) {
                IsInstanceShapeData s1_ = this.isInstanceShape_cache;
                while (s1_ != null) {
                    if ((s1_.cachedShape_.check(operandNodeValue_))) {
                        return IsJSClassNode.doIsInstanceShape(operandNodeValue_, s1_.cachedShape_, s1_.cachedResult_);
                    }
                    s1_ = s1_.next_;
                }
            }
            if ((state & 0b10) != 0 /* is-active doIsInstanceObject(DynamicObject) */) {
                return doIsInstanceObject(operandNodeValue_);
            }
        }
        if ((state & 0b100) != 0 /* is-active doIsInstance(Object) */) {
            return doIsInstance(operandNodeValue);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue);
    }

    @ExplodeLoop
    @Override
    public boolean executeBoolean(Object operandNodeValue) {
        int state = state_;
        if ((state & 0b11) != 0 /* is-active doIsInstanceShape(DynamicObject, Shape, boolean) || doIsInstanceObject(DynamicObject) */ && JSTypes.isDynamicObject(operandNodeValue)) {
            DynamicObject operandNodeValue_ = (DynamicObject) operandNodeValue;
            if ((state & 0b1) != 0 /* is-active doIsInstanceShape(DynamicObject, Shape, boolean) */) {
                IsInstanceShapeData s1_ = this.isInstanceShape_cache;
                while (s1_ != null) {
                    if ((s1_.cachedShape_.check(operandNodeValue_))) {
                        return IsJSClassNode.doIsInstanceShape(operandNodeValue_, s1_.cachedShape_, s1_.cachedResult_);
                    }
                    s1_ = s1_.next_;
                }
            }
            if ((state & 0b10) != 0 /* is-active doIsInstanceObject(DynamicObject) */) {
                return doIsInstanceObject(operandNodeValue_);
            }
        }
        if ((state & 0b100) != 0 /* is-active doIsInstance(Object) */) {
            return doIsInstance(operandNodeValue);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue);
    }

    @ExplodeLoop
    @Override
    public Object execute(VirtualFrame frameValue) {
        int state = state_;
        Object operandNodeValue_ = super.operandNode.execute(frameValue);
        if ((state & 0b11) != 0 /* is-active doIsInstanceShape(DynamicObject, Shape, boolean) || doIsInstanceObject(DynamicObject) */ && JSTypes.isDynamicObject(operandNodeValue_)) {
            DynamicObject operandNodeValue__ = (DynamicObject) operandNodeValue_;
            if ((state & 0b1) != 0 /* is-active doIsInstanceShape(DynamicObject, Shape, boolean) */) {
                IsInstanceShapeData s1_ = this.isInstanceShape_cache;
                while (s1_ != null) {
                    if ((s1_.cachedShape_.check(operandNodeValue__))) {
                        return IsJSClassNode.doIsInstanceShape(operandNodeValue__, s1_.cachedShape_, s1_.cachedResult_);
                    }
                    s1_ = s1_.next_;
                }
            }
            if ((state & 0b10) != 0 /* is-active doIsInstanceObject(DynamicObject) */) {
                return doIsInstanceObject(operandNodeValue__);
            }
        }
        if ((state & 0b100) != 0 /* is-active doIsInstance(Object) */) {
            return doIsInstance(operandNodeValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue_);
    }

    @ExplodeLoop
    @Override
    public boolean executeBoolean(VirtualFrame frameValue) {
        int state = state_;
        Object operandNodeValue_ = super.operandNode.execute(frameValue);
        if ((state & 0b11) != 0 /* is-active doIsInstanceShape(DynamicObject, Shape, boolean) || doIsInstanceObject(DynamicObject) */ && JSTypes.isDynamicObject(operandNodeValue_)) {
            DynamicObject operandNodeValue__ = (DynamicObject) operandNodeValue_;
            if ((state & 0b1) != 0 /* is-active doIsInstanceShape(DynamicObject, Shape, boolean) */) {
                IsInstanceShapeData s1_ = this.isInstanceShape_cache;
                while (s1_ != null) {
                    if ((s1_.cachedShape_.check(operandNodeValue__))) {
                        return IsJSClassNode.doIsInstanceShape(operandNodeValue__, s1_.cachedShape_, s1_.cachedResult_);
                    }
                    s1_ = s1_.next_;
                }
            }
            if ((state & 0b10) != 0 /* is-active doIsInstanceObject(DynamicObject) */) {
                return doIsInstanceObject(operandNodeValue__);
            }
        }
        if ((state & 0b100) != 0 /* is-active doIsInstance(Object) */) {
            return doIsInstance(operandNodeValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue_);
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
            if (JSTypes.isDynamicObject(operandNodeValue)) {
                DynamicObject operandNodeValue_ = (DynamicObject) operandNodeValue;
                if (((exclude & 0b1)) == 0 /* is-not-excluded doIsInstanceShape(DynamicObject, Shape, boolean) */) {
                    int count1_ = 0;
                    IsInstanceShapeData s1_ = this.isInstanceShape_cache;
                    if ((state & 0b1) != 0 /* is-active doIsInstanceShape(DynamicObject, Shape, boolean) */) {
                        while (s1_ != null) {
                            if ((s1_.cachedShape_.check(operandNodeValue_))) {
                                break;
                            }
                            s1_ = s1_.next_;
                            count1_++;
                        }
                    }
                    if (s1_ == null) {
                        {
                            Shape cachedShape__ = (operandNodeValue_.getShape());
                            if ((cachedShape__.check(operandNodeValue_)) && count1_ < (IsJSClassNode.MAX_SHAPE_COUNT)) {
                                s1_ = new IsInstanceShapeData(isInstanceShape_cache);
                                s1_.cachedShape_ = cachedShape__;
                                s1_.cachedResult_ = (doIsInstance(operandNodeValue_));
                                this.isInstanceShape_cache = s1_;
                                this.state_ = state = state | 0b1 /* add-active doIsInstanceShape(DynamicObject, Shape, boolean) */;
                            }
                        }
                    }
                    if (s1_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return IsJSClassNode.doIsInstanceShape(operandNodeValue_, s1_.cachedShape_, s1_.cachedResult_);
                    }
                }
                if (((exclude & 0b10)) == 0 /* is-not-excluded doIsInstanceObject(DynamicObject) */) {
                    this.exclude_ = exclude = exclude | 0b1 /* add-excluded doIsInstanceShape(DynamicObject, Shape, boolean) */;
                    this.isInstanceShape_cache = null;
                    state = state & 0xfffffffe /* remove-active doIsInstanceShape(DynamicObject, Shape, boolean) */;
                    this.state_ = state = state | 0b10 /* add-active doIsInstanceObject(DynamicObject) */;
                    lock.unlock();
                    hasLock = false;
                    return doIsInstanceObject(operandNodeValue_);
                }
            }
            this.exclude_ = exclude = exclude | 0b11 /* add-excluded doIsInstanceShape(DynamicObject, Shape, boolean), doIsInstanceObject(DynamicObject) */;
            this.isInstanceShape_cache = null;
            state = state & 0xfffffffc /* remove-active doIsInstanceShape(DynamicObject, Shape, boolean), doIsInstanceObject(DynamicObject) */;
            this.state_ = state = state | 0b100 /* add-active doIsInstance(Object) */;
            lock.unlock();
            hasLock = false;
            return doIsInstance(operandNodeValue);
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
            IsInstanceShapeData s1_ = this.isInstanceShape_cache;
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
        s[0] = "doIsInstanceShape";
        if ((state & 0b1) != 0 /* is-active doIsInstanceShape(DynamicObject, Shape, boolean) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            IsInstanceShapeData s1_ = this.isInstanceShape_cache;
            while (s1_ != null) {
                cached.add(Arrays.asList(s1_.cachedShape_, s1_.cachedResult_));
                s1_ = s1_.next_;
            }
            s[2] = cached;
        } else if ((exclude & 0b1) != 0 /* is-excluded doIsInstanceShape(DynamicObject, Shape, boolean) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doIsInstanceObject";
        if ((state & 0b10) != 0 /* is-active doIsInstanceObject(DynamicObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b10) != 0 /* is-excluded doIsInstanceObject(DynamicObject) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doIsInstance";
        if ((state & 0b100) != 0 /* is-active doIsInstance(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        return Provider.create(data);
    }

    public static IsJSClassNode create(JSClass jsclass, JavaScriptNode operand) {
        return new IsJSClassNodeGen(jsclass, operand);
    }

    @GeneratedBy(IsJSClassNode.class)
    private static final class IsInstanceShapeData {

        @CompilationFinal IsInstanceShapeData next_;
        @CompilationFinal Shape cachedShape_;
        @CompilationFinal boolean cachedResult_;

        IsInstanceShapeData(IsInstanceShapeData next_) {
            this.next_ = next_;
        }

    }
}
