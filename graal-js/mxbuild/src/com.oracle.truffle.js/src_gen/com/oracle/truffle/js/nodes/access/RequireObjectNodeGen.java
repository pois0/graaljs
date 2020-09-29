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
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(RequireObjectNode.class)
public final class RequireObjectNodeGen extends RequireObjectNode implements Provider {

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private ObjectShapeData objectShape_cache;

    private RequireObjectNodeGen(JavaScriptNode operand) {
        super(operand);
    }

    @ExplodeLoop
    @Override
    public Object execute(Object operandNodeValue) {
        int state = state_;
        if ((state & 0b1) != 0 /* is-active doObjectShape(DynamicObject, Shape, boolean) */ && JSTypes.isDynamicObject(operandNodeValue)) {
            DynamicObject operandNodeValue_ = (DynamicObject) operandNodeValue;
            ObjectShapeData s1_ = this.objectShape_cache;
            while (s1_ != null) {
                if ((s1_.cachedShape_.check(operandNodeValue_))) {
                    return RequireObjectNode.doObjectShape(operandNodeValue_, s1_.cachedShape_, s1_.cachedResult_);
                }
                s1_ = s1_.next_;
            }
        }
        if ((state & 0b10) != 0 /* is-active doObject(Object) */) {
            return RequireObjectNode.doObject(operandNodeValue);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue);
    }

    @ExplodeLoop
    @Override
    public Object execute(VirtualFrame frameValue) {
        int state = state_;
        Object operandNodeValue_ = super.operandNode.execute(frameValue);
        if ((state & 0b1) != 0 /* is-active doObjectShape(DynamicObject, Shape, boolean) */ && JSTypes.isDynamicObject(operandNodeValue_)) {
            DynamicObject operandNodeValue__ = (DynamicObject) operandNodeValue_;
            ObjectShapeData s1_ = this.objectShape_cache;
            while (s1_ != null) {
                if ((s1_.cachedShape_.check(operandNodeValue__))) {
                    return RequireObjectNode.doObjectShape(operandNodeValue__, s1_.cachedShape_, s1_.cachedResult_);
                }
                s1_ = s1_.next_;
            }
        }
        if ((state & 0b10) != 0 /* is-active doObject(Object) */) {
            return RequireObjectNode.doObject(operandNodeValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue_);
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        execute(frameValue);
        return;
    }

    private Object executeAndSpecialize(Object operandNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        int exclude = exclude_;
        try {
            if ((exclude) == 0 /* is-not-excluded doObjectShape(DynamicObject, Shape, boolean) */ && JSTypes.isDynamicObject(operandNodeValue)) {
                DynamicObject operandNodeValue_ = (DynamicObject) operandNodeValue;
                int count1_ = 0;
                ObjectShapeData s1_ = this.objectShape_cache;
                if ((state & 0b1) != 0 /* is-active doObjectShape(DynamicObject, Shape, boolean) */) {
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
                        if ((cachedShape__.check(operandNodeValue_)) && count1_ < (RequireObjectNode.MAX_SHAPE_COUNT)) {
                            s1_ = new ObjectShapeData(objectShape_cache);
                            s1_.cachedShape_ = cachedShape__;
                            s1_.cachedResult_ = (JSGuards.isJSObject(operandNodeValue_));
                            this.objectShape_cache = s1_;
                            this.state_ = state = state | 0b1 /* add-active doObjectShape(DynamicObject, Shape, boolean) */;
                        }
                    }
                }
                if (s1_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return RequireObjectNode.doObjectShape(operandNodeValue_, s1_.cachedShape_, s1_.cachedResult_);
                }
            }
            this.exclude_ = exclude = exclude | 0b1 /* add-excluded doObjectShape(DynamicObject, Shape, boolean) */;
            this.objectShape_cache = null;
            state = state & 0xfffffffe /* remove-active doObjectShape(DynamicObject, Shape, boolean) */;
            this.state_ = state = state | 0b10 /* add-active doObject(Object) */;
            lock.unlock();
            hasLock = false;
            return RequireObjectNode.doObject(operandNodeValue);
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
            ObjectShapeData s1_ = this.objectShape_cache;
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
        s[0] = "doObjectShape";
        if ((state & 0b1) != 0 /* is-active doObjectShape(DynamicObject, Shape, boolean) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            ObjectShapeData s1_ = this.objectShape_cache;
            while (s1_ != null) {
                cached.add(Arrays.asList(s1_.cachedShape_, s1_.cachedResult_));
                s1_ = s1_.next_;
            }
            s[2] = cached;
        } else if (exclude != 0 /* is-excluded doObjectShape(DynamicObject, Shape, boolean) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doObject";
        if ((state & 0b10) != 0 /* is-active doObject(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        return Provider.create(data);
    }

    public static RequireObjectNode create(JavaScriptNode operand) {
        return new RequireObjectNodeGen(operand);
    }

    @GeneratedBy(RequireObjectNode.class)
    private static final class ObjectShapeData {

        @CompilationFinal ObjectShapeData next_;
        @CompilationFinal Shape cachedShape_;
        @CompilationFinal boolean cachedResult_;

        ObjectShapeData(ObjectShapeData next_) {
            this.next_ = next_;
        }

    }
}
