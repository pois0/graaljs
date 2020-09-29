// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.cast.JSToBooleanNode;
import com.oracle.truffle.js.runtime.JSContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(IsRegExpNode.class)
public final class IsRegExpNodeGen extends IsRegExpNode implements Provider {

    @CompilationFinal private volatile int state_;
    @Child private IsObjectData isObject_cache;

    private IsRegExpNodeGen(JSContext context) {
        super(context);
    }

    @Override
    public boolean executeBoolean(Object arg0Value) {
        int state = state_;
        if ((state & 0b1) != 0 /* is-active doIsObject(DynamicObject, IsJSObjectNode, JSToBooleanNode, IsJSClassNode, ConditionProfile) */ && JSTypes.isDynamicObject(arg0Value)) {
            DynamicObject arg0Value_ = (DynamicObject) arg0Value;
            IsObjectData s1_ = this.isObject_cache;
            if (s1_ != null) {
                return doIsObject(arg0Value_, s1_.isObjectNode_, s1_.toBooleanNode_, s1_.isJSRegExpNode_, s1_.hasMatchSymbol_);
            }
        }
        if ((state & 0b10) != 0 /* is-active doNonObject(Object) */) {
            if (fallbackGuard_(state, arg0Value)) {
                return doNonObject(arg0Value);
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
        try {
            if (JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                IsObjectData s1_ = super.insert(new IsObjectData());
                s1_.isObjectNode_ = s1_.insertAccessor((IsJSObjectNode.create()));
                s1_.toBooleanNode_ = s1_.insertAccessor((JSToBooleanNode.create()));
                s1_.isJSRegExpNode_ = s1_.insertAccessor((IsRegExpNode.createIsJSRegExpNode()));
                s1_.hasMatchSymbol_ = (ConditionProfile.createBinaryProfile());
                this.isObject_cache = s1_;
                this.state_ = state = state | 0b1 /* add-active doIsObject(DynamicObject, IsJSObjectNode, JSToBooleanNode, IsJSClassNode, ConditionProfile) */;
                lock.unlock();
                hasLock = false;
                return doIsObject(arg0Value_, s1_.isObjectNode_, s1_.toBooleanNode_, s1_.isJSRegExpNode_, s1_.hasMatchSymbol_);
            }
            this.state_ = state = state | 0b10 /* add-active doNonObject(Object) */;
            lock.unlock();
            hasLock = false;
            return doNonObject(arg0Value);
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
        Object[] data = new Object[3];
        Object[] s;
        data[0] = 0;
        int state = state_;
        s = new Object[3];
        s[0] = "doIsObject";
        if ((state & 0b1) != 0 /* is-active doIsObject(DynamicObject, IsJSObjectNode, JSToBooleanNode, IsJSClassNode, ConditionProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            IsObjectData s1_ = this.isObject_cache;
            if (s1_ != null) {
                cached.add(Arrays.asList(s1_.isObjectNode_, s1_.toBooleanNode_, s1_.isJSRegExpNode_, s1_.hasMatchSymbol_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doNonObject";
        if ((state & 0b10) != 0 /* is-active doNonObject(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        return Provider.create(data);
    }

    private static boolean fallbackGuard_(int state, Object arg0Value) {
        if (((state & 0b1)) == 0 /* is-not-active doIsObject(DynamicObject, IsJSObjectNode, JSToBooleanNode, IsJSClassNode, ConditionProfile) */ && JSTypes.isDynamicObject(arg0Value)) {
            return false;
        }
        return true;
    }

    public static IsRegExpNode create(JSContext context) {
        return new IsRegExpNodeGen(context);
    }

    @GeneratedBy(IsRegExpNode.class)
    private static final class IsObjectData extends Node {

        @Child IsJSObjectNode isObjectNode_;
        @Child JSToBooleanNode toBooleanNode_;
        @Child IsJSClassNode isJSRegExpNode_;
        @CompilationFinal ConditionProfile hasMatchSymbol_;

        IsObjectData() {
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
