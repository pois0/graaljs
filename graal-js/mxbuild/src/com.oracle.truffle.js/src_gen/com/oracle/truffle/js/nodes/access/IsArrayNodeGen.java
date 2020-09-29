// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.Shape;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.runtime.builtins.JSClass;
import com.oracle.truffle.js.runtime.objects.JSDynamicObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(IsArrayNode.class)
public final class IsArrayNodeGen extends IsArrayNode implements Provider {

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private IsArrayShapeData isArrayShape_cache;
    @CompilationFinal private IsArrayJSClassData isArrayJSClass_cache;

    private IsArrayNodeGen(Kind kind) {
        super(kind);
    }

    @ExplodeLoop
    @Override
    public boolean execute(Object arg0Value) {
        int state = state_;
        if ((state & 0b1) != 0 /* is-active doJSArray(Object) */) {
            assert (kind == Kind.Array);
            if ((JSGuards.isJSArray(arg0Value))) {
                return IsArrayNode.doJSArray(arg0Value);
            }
        }
        if ((state & 0b1110) != 0 /* is-active doIsArrayShape(JSDynamicObject, Shape, boolean) || doIsArrayJSClass(JSDynamicObject, boolean, JSClass) || isArray(JSDynamicObject) */ && arg0Value instanceof JSDynamicObject) {
            JSDynamicObject arg0Value_ = (JSDynamicObject) arg0Value;
            if ((state & 0b10) != 0 /* is-active doIsArrayShape(JSDynamicObject, Shape, boolean) */) {
                IsArrayShapeData s2_ = this.isArrayShape_cache;
                while (s2_ != null) {
                    if ((s2_.cachedShape_.check(arg0Value_))) {
                        return IsArrayNode.doIsArrayShape(arg0Value_, s2_.cachedShape_, s2_.cachedResult_);
                    }
                    s2_ = s2_.next_;
                }
            }
            if ((state & 0b100) != 0 /* is-active doIsArrayJSClass(JSDynamicObject, boolean, JSClass) */) {
                IsArrayJSClassData s3_ = this.isArrayJSClass_cache;
                while (s3_ != null) {
                    assert (s3_.cachedClass_ != null);
                    if ((s3_.cachedClass_.isInstance(arg0Value_))) {
                        return IsArrayNode.doIsArrayJSClass(arg0Value_, s3_.cachedResult_, s3_.cachedClass_);
                    }
                    s3_ = s3_.next_;
                }
            }
            if ((state & 0b1000) != 0 /* is-active isArray(JSDynamicObject) */) {
                return isArray(arg0Value_);
            }
        }
        if ((state & 0b10000) != 0 /* is-active isNotDynamicObject(Object) */) {
            if ((!(JSGuards.isJSDynamicObject(arg0Value)))) {
                return IsArrayNode.isNotDynamicObject(arg0Value);
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
            if ((kind == Kind.Array) && (JSGuards.isJSArray(arg0Value))) {
                this.state_ = state = state | 0b1 /* add-active doJSArray(Object) */;
                lock.unlock();
                hasLock = false;
                return IsArrayNode.doJSArray(arg0Value);
            }
            if (arg0Value instanceof JSDynamicObject) {
                JSDynamicObject arg0Value_ = (JSDynamicObject) arg0Value;
                if (((exclude & 0b1)) == 0 /* is-not-excluded doIsArrayShape(JSDynamicObject, Shape, boolean) */) {
                    int count2_ = 0;
                    IsArrayShapeData s2_ = this.isArrayShape_cache;
                    if ((state & 0b10) != 0 /* is-active doIsArrayShape(JSDynamicObject, Shape, boolean) */) {
                        while (s2_ != null) {
                            if ((s2_.cachedShape_.check(arg0Value_))) {
                                break;
                            }
                            s2_ = s2_.next_;
                            count2_++;
                        }
                    }
                    if (s2_ == null) {
                        {
                            Shape cachedShape__ = (arg0Value_.getShape());
                            if ((cachedShape__.check(arg0Value_)) && count2_ < (IsArrayNode.MAX_SHAPE_COUNT)) {
                                s2_ = new IsArrayShapeData(isArrayShape_cache);
                                s2_.cachedShape_ = cachedShape__;
                                s2_.cachedResult_ = (isArray(arg0Value_));
                                this.isArrayShape_cache = s2_;
                                this.state_ = state = state | 0b10 /* add-active doIsArrayShape(JSDynamicObject, Shape, boolean) */;
                            }
                        }
                    }
                    if (s2_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return IsArrayNode.doIsArrayShape(arg0Value_, s2_.cachedShape_, s2_.cachedResult_);
                    }
                }
                if (((exclude & 0b10)) == 0 /* is-not-excluded doIsArrayJSClass(JSDynamicObject, boolean, JSClass) */) {
                    int count3_ = 0;
                    IsArrayJSClassData s3_ = this.isArrayJSClass_cache;
                    if ((state & 0b100) != 0 /* is-active doIsArrayJSClass(JSDynamicObject, boolean, JSClass) */) {
                        while (s3_ != null) {
                            assert (s3_.cachedClass_ != null);
                            if ((s3_.cachedClass_.isInstance(arg0Value_))) {
                                break;
                            }
                            s3_ = s3_.next_;
                            count3_++;
                        }
                    }
                    if (s3_ == null) {
                        {
                            JSClass cachedClass__ = (JSGuards.getJSClassChecked(arg0Value_));
                            if ((cachedClass__ != null) && (cachedClass__.isInstance(arg0Value_)) && count3_ < (IsArrayNode.MAX_JSCLASS_COUNT)) {
                                s3_ = new IsArrayJSClassData(isArrayJSClass_cache);
                                s3_.cachedResult_ = (isArray(arg0Value_));
                                s3_.cachedClass_ = cachedClass__;
                                this.isArrayJSClass_cache = s3_;
                                this.exclude_ = exclude = exclude | 0b1 /* add-excluded doIsArrayShape(JSDynamicObject, Shape, boolean) */;
                                this.isArrayShape_cache = null;
                                state = state & 0xfffffffd /* remove-active doIsArrayShape(JSDynamicObject, Shape, boolean) */;
                                this.state_ = state = state | 0b100 /* add-active doIsArrayJSClass(JSDynamicObject, boolean, JSClass) */;
                            }
                        }
                    }
                    if (s3_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return IsArrayNode.doIsArrayJSClass(arg0Value_, s3_.cachedResult_, s3_.cachedClass_);
                    }
                }
                this.exclude_ = exclude = exclude | 0b11 /* add-excluded doIsArrayShape(JSDynamicObject, Shape, boolean), doIsArrayJSClass(JSDynamicObject, boolean, JSClass) */;
                this.isArrayShape_cache = null;
                this.isArrayJSClass_cache = null;
                state = state & 0xfffffff9 /* remove-active doIsArrayShape(JSDynamicObject, Shape, boolean), doIsArrayJSClass(JSDynamicObject, boolean, JSClass) */;
                this.state_ = state = state | 0b1000 /* add-active isArray(JSDynamicObject) */;
                lock.unlock();
                hasLock = false;
                return isArray(arg0Value_);
            }
            if ((!(JSGuards.isJSDynamicObject(arg0Value)))) {
                this.state_ = state = state | 0b10000 /* add-active isNotDynamicObject(Object) */;
                lock.unlock();
                hasLock = false;
                return IsArrayNode.isNotDynamicObject(arg0Value);
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
            IsArrayShapeData s2_ = this.isArrayShape_cache;
            IsArrayJSClassData s3_ = this.isArrayJSClass_cache;
            if ((s2_ == null || s2_.next_ == null) && (s3_ == null || s3_.next_ == null)) {
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
        s[0] = "doJSArray";
        if ((state & 0b1) != 0 /* is-active doJSArray(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doIsArrayShape";
        if ((state & 0b10) != 0 /* is-active doIsArrayShape(JSDynamicObject, Shape, boolean) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            IsArrayShapeData s2_ = this.isArrayShape_cache;
            while (s2_ != null) {
                cached.add(Arrays.asList(s2_.cachedShape_, s2_.cachedResult_));
                s2_ = s2_.next_;
            }
            s[2] = cached;
        } else if ((exclude & 0b1) != 0 /* is-excluded doIsArrayShape(JSDynamicObject, Shape, boolean) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doIsArrayJSClass";
        if ((state & 0b100) != 0 /* is-active doIsArrayJSClass(JSDynamicObject, boolean, JSClass) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            IsArrayJSClassData s3_ = this.isArrayJSClass_cache;
            while (s3_ != null) {
                cached.add(Arrays.asList(s3_.cachedResult_, s3_.cachedClass_));
                s3_ = s3_.next_;
            }
            s[2] = cached;
        } else if ((exclude & 0b10) != 0 /* is-excluded doIsArrayJSClass(JSDynamicObject, boolean, JSClass) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "isArray";
        if ((state & 0b1000) != 0 /* is-active isArray(JSDynamicObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "isNotDynamicObject";
        if ((state & 0b10000) != 0 /* is-active isNotDynamicObject(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        return Provider.create(data);
    }

    public static IsArrayNode create(Kind kind) {
        return new IsArrayNodeGen(kind);
    }

    @GeneratedBy(IsArrayNode.class)
    private static final class IsArrayShapeData {

        @CompilationFinal IsArrayShapeData next_;
        @CompilationFinal Shape cachedShape_;
        @CompilationFinal boolean cachedResult_;

        IsArrayShapeData(IsArrayShapeData next_) {
            this.next_ = next_;
        }

    }
    @GeneratedBy(IsArrayNode.class)
    private static final class IsArrayJSClassData {

        @CompilationFinal IsArrayJSClassData next_;
        @CompilationFinal boolean cachedResult_;
        @CompilationFinal JSClass cachedClass_;

        IsArrayJSClassData(IsArrayJSClassData next_) {
            this.next_ = next_;
        }

    }
    @GeneratedBy(IsArrayWrappedNode.class)
    public static final class IsArrayWrappedNodeGen extends IsArrayWrappedNode implements Provider {

        private IsArrayWrappedNodeGen(JavaScriptNode operandNode, IsArrayNode isArrayNode) {
            super(operandNode, isArrayNode);
        }

        @Override
        public Object execute(VirtualFrame frameValue, Object operandNodeValue) {
            return doObject(operandNodeValue);
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object operandNodeValue_ = super.operandNode.execute(frameValue);
            return doObject(operandNodeValue_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            Object operandNodeValue_ = super.operandNode.execute(frameValue);
            return doObject(operandNodeValue_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            executeBoolean(frameValue);
            return;
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.MONOMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            s = new Object[3];
            s[0] = "doObject";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static IsArrayWrappedNode create(JavaScriptNode operandNode, IsArrayNode isArrayNode) {
            return new IsArrayWrappedNodeGen(operandNode, isArrayNode);
        }

    }
}
