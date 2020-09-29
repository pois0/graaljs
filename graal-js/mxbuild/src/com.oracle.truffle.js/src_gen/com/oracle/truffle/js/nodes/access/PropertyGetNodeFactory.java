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
import com.oracle.truffle.js.nodes.access.PropertyGetNode.GetPropertyFromJSObjectNode;
import com.oracle.truffle.js.runtime.builtins.JSClass;
import com.oracle.truffle.js.runtime.util.JSClassProfile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(PropertyGetNode.class)
public final class PropertyGetNodeFactory {

    @GeneratedBy(GetPropertyFromJSObjectNode.class)
    static final class GetPropertyFromJSObjectNodeGen extends GetPropertyFromJSObjectNode implements Provider {

        @CompilationFinal private volatile int state_;
        @CompilationFinal private volatile int exclude_;
        @CompilationFinal private JSObjectCachedData jSObjectCached_cache;
        @Child private JSHasPropertyNode required_hasPropertyNode_;
        @CompilationFinal private JSClassProfile required_classProfile_;

        private GetPropertyFromJSObjectNodeGen(PropertyGetNode root) {
            super(root);
        }

        @ExplodeLoop
        @Override
        public Object executeWithJSObject(DynamicObject arg0Value, Object arg1Value, Object arg2Value, PropertyGetNode arg3Value) {
            int state = state_;
            if (state != 0 /* is-active doJSObjectCached(DynamicObject, Object, Object, PropertyGetNode, JSClass) || doJSObjectDirect(DynamicObject, Object, Object, PropertyGetNode) || doRequired(DynamicObject, Object, Object, PropertyGetNode, JSHasPropertyNode, JSClassProfile) */) {
                if ((state & 0b1) != 0 /* is-active doJSObjectCached(DynamicObject, Object, Object, PropertyGetNode, JSClass) */) {
                    assert (!(isGlobal()));
                    JSObjectCachedData s1_ = this.jSObjectCached_cache;
                    while (s1_ != null) {
                        if ((s1_.cachedClass_ == getJSClass(arg0Value))) {
                            return doJSObjectCached(arg0Value, arg1Value, arg2Value, arg3Value, s1_.cachedClass_);
                        }
                        s1_ = s1_.next_;
                    }
                }
                if ((state & 0b10) != 0 /* is-active doJSObjectDirect(DynamicObject, Object, Object, PropertyGetNode) */) {
                    assert (!(isGlobal()));
                    return doJSObjectDirect(arg0Value, arg1Value, arg2Value, arg3Value);
                }
                if ((state & 0b100) != 0 /* is-active doRequired(DynamicObject, Object, Object, PropertyGetNode, JSHasPropertyNode, JSClassProfile) */) {
                    assert (isGlobal());
                    return doRequired(arg0Value, arg1Value, arg2Value, arg3Value, this.required_hasPropertyNode_, this.required_classProfile_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value, arg1Value, arg2Value, arg3Value);
        }

        private Object executeAndSpecialize(DynamicObject arg0Value, Object arg1Value, Object arg2Value, PropertyGetNode arg3Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int exclude = exclude_;
            try {
                if ((exclude) == 0 /* is-not-excluded doJSObjectCached(DynamicObject, Object, Object, PropertyGetNode, JSClass) */ && (!(isGlobal()))) {
                    int count1_ = 0;
                    JSObjectCachedData s1_ = this.jSObjectCached_cache;
                    if ((state & 0b1) != 0 /* is-active doJSObjectCached(DynamicObject, Object, Object, PropertyGetNode, JSClass) */) {
                        while (s1_ != null) {
                            if ((s1_.cachedClass_ == getJSClass(arg0Value))) {
                                break;
                            }
                            s1_ = s1_.next_;
                            count1_++;
                        }
                    }
                    if (s1_ == null) {
                        {
                            JSClass cachedClass__ = (getJSClass(arg0Value));
                            if ((cachedClass__ == getJSClass(arg0Value)) && count1_ < (2)) {
                                s1_ = new JSObjectCachedData(jSObjectCached_cache);
                                s1_.cachedClass_ = cachedClass__;
                                this.jSObjectCached_cache = s1_;
                                this.state_ = state = state | 0b1 /* add-active doJSObjectCached(DynamicObject, Object, Object, PropertyGetNode, JSClass) */;
                            }
                        }
                    }
                    if (s1_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return doJSObjectCached(arg0Value, arg1Value, arg2Value, arg3Value, s1_.cachedClass_);
                    }
                }
                if ((!(isGlobal()))) {
                    this.exclude_ = exclude = exclude | 0b1 /* add-excluded doJSObjectCached(DynamicObject, Object, Object, PropertyGetNode, JSClass) */;
                    this.jSObjectCached_cache = null;
                    state = state & 0xfffffffe /* remove-active doJSObjectCached(DynamicObject, Object, Object, PropertyGetNode, JSClass) */;
                    this.state_ = state = state | 0b10 /* add-active doJSObjectDirect(DynamicObject, Object, Object, PropertyGetNode) */;
                    lock.unlock();
                    hasLock = false;
                    return doJSObjectDirect(arg0Value, arg1Value, arg2Value, arg3Value);
                }
                if ((isGlobal())) {
                    this.required_hasPropertyNode_ = super.insert((JSHasPropertyNode.create()));
                    this.required_classProfile_ = (JSClassProfile.create());
                    this.state_ = state = state | 0b100 /* add-active doRequired(DynamicObject, Object, Object, PropertyGetNode, JSHasPropertyNode, JSClassProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return doRequired(arg0Value, arg1Value, arg2Value, arg3Value, this.required_hasPropertyNode_, this.required_classProfile_);
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null, null, null, null}, arg0Value, arg1Value, arg2Value, arg3Value);
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
                JSObjectCachedData s1_ = this.jSObjectCached_cache;
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
            s[0] = "doJSObjectCached";
            if ((state & 0b1) != 0 /* is-active doJSObjectCached(DynamicObject, Object, Object, PropertyGetNode, JSClass) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                JSObjectCachedData s1_ = this.jSObjectCached_cache;
                while (s1_ != null) {
                    cached.add(Arrays.asList(s1_.cachedClass_));
                    s1_ = s1_.next_;
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-excluded doJSObjectCached(DynamicObject, Object, Object, PropertyGetNode, JSClass) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doJSObjectDirect";
            if ((state & 0b10) != 0 /* is-active doJSObjectDirect(DynamicObject, Object, Object, PropertyGetNode) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "doRequired";
            if ((state & 0b100) != 0 /* is-active doRequired(DynamicObject, Object, Object, PropertyGetNode, JSHasPropertyNode, JSClassProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.required_hasPropertyNode_, this.required_classProfile_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static GetPropertyFromJSObjectNode create(PropertyGetNode root) {
            return new GetPropertyFromJSObjectNodeGen(root);
        }

        @GeneratedBy(GetPropertyFromJSObjectNode.class)
        private static final class JSObjectCachedData {

            @CompilationFinal JSObjectCachedData next_;
            @CompilationFinal JSClass cachedClass_;

            JSObjectCachedData(JSObjectCachedData next_) {
                this.next_ = next_;
            }

        }
    }
}
