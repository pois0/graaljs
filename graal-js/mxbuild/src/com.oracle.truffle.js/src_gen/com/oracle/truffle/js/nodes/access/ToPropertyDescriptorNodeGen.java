// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.cast.JSToStringNode;
import com.oracle.truffle.js.runtime.JSContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(ToPropertyDescriptorNode.class)
public final class ToPropertyDescriptorNodeGen extends ToPropertyDescriptorNode implements Provider {

    @CompilationFinal private volatile int state_;
    @CompilationFinal private DefaultData default_cache;
    @Child private JSToStringNode nonObject_toStringNode_;

    private ToPropertyDescriptorNodeGen(JSContext context) {
        super(context);
    }

    @Override
    public Object execute(Object arg0Value) {
        int state = state_;
        if ((state & 0b11) != 0 /* is-active nonSpecialized(DynamicObject) || doDefault(DynamicObject, BranchProfile, BranchProfile, BranchProfile, BranchProfile, BranchProfile, BranchProfile) */ && JSTypes.isDynamicObject(arg0Value)) {
            DynamicObject arg0Value_ = (DynamicObject) arg0Value;
            if ((state & 0b1) != 0 /* is-active nonSpecialized(DynamicObject) */) {
                if ((!(wasExecuted(arg0Value_))) && (JSGuards.isJSObject(arg0Value_))) {
                    return nonSpecialized(arg0Value_);
                }
            }
            if ((state & 0b10) != 0 /* is-active doDefault(DynamicObject, BranchProfile, BranchProfile, BranchProfile, BranchProfile, BranchProfile, BranchProfile) */) {
                DefaultData s2_ = this.default_cache;
                if (s2_ != null) {
                    if ((wasExecuted(arg0Value_)) && (JSGuards.isJSObject(arg0Value_))) {
                        return doDefault(arg0Value_, s2_.hasGetBranch_, s2_.hasSetBranch_, s2_.hasEnumerableBranch_, s2_.hasConfigurableBranch_, s2_.hasValueBranch_, s2_.hasWritableBranch_);
                    }
                }
            }
        }
        if ((state & 0b100) != 0 /* is-active doNonObject(Object, JSToStringNode) */) {
            if ((!(JSGuards.isJSObject(arg0Value)))) {
                return doNonObject(arg0Value, this.nonObject_toStringNode_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    private Object executeAndSpecialize(Object arg0Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        try {
            if (JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if ((!(wasExecuted(arg0Value_))) && (JSGuards.isJSObject(arg0Value_))) {
                    this.state_ = state = state | 0b1 /* add-active nonSpecialized(DynamicObject) */;
                    lock.unlock();
                    hasLock = false;
                    return nonSpecialized(arg0Value_);
                }
                if ((wasExecuted(arg0Value_)) && (JSGuards.isJSObject(arg0Value_))) {
                    DefaultData s2_ = new DefaultData();
                    s2_.hasGetBranch_ = (BranchProfile.create());
                    s2_.hasSetBranch_ = (BranchProfile.create());
                    s2_.hasEnumerableBranch_ = (BranchProfile.create());
                    s2_.hasConfigurableBranch_ = (BranchProfile.create());
                    s2_.hasValueBranch_ = (BranchProfile.create());
                    s2_.hasWritableBranch_ = (BranchProfile.create());
                    this.default_cache = s2_;
                    this.state_ = state = state | 0b10 /* add-active doDefault(DynamicObject, BranchProfile, BranchProfile, BranchProfile, BranchProfile, BranchProfile, BranchProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return doDefault(arg0Value_, s2_.hasGetBranch_, s2_.hasSetBranch_, s2_.hasEnumerableBranch_, s2_.hasConfigurableBranch_, s2_.hasValueBranch_, s2_.hasWritableBranch_);
                }
            }
            if ((!(JSGuards.isJSObject(arg0Value)))) {
                this.nonObject_toStringNode_ = super.insert((JSToStringNode.create()));
                this.state_ = state = state | 0b100 /* add-active doNonObject(Object, JSToStringNode) */;
                lock.unlock();
                hasLock = false;
                return doNonObject(arg0Value, this.nonObject_toStringNode_);
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
        Object[] data = new Object[4];
        Object[] s;
        data[0] = 0;
        int state = state_;
        s = new Object[3];
        s[0] = "nonSpecialized";
        if ((state & 0b1) != 0 /* is-active nonSpecialized(DynamicObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doDefault";
        if ((state & 0b10) != 0 /* is-active doDefault(DynamicObject, BranchProfile, BranchProfile, BranchProfile, BranchProfile, BranchProfile, BranchProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            DefaultData s2_ = this.default_cache;
            if (s2_ != null) {
                cached.add(Arrays.asList(s2_.hasGetBranch_, s2_.hasSetBranch_, s2_.hasEnumerableBranch_, s2_.hasConfigurableBranch_, s2_.hasValueBranch_, s2_.hasWritableBranch_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doNonObject";
        if ((state & 0b100) != 0 /* is-active doNonObject(Object, JSToStringNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.nonObject_toStringNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        return Provider.create(data);
    }

    public static ToPropertyDescriptorNode create(JSContext context) {
        return new ToPropertyDescriptorNodeGen(context);
    }

    @GeneratedBy(ToPropertyDescriptorNode.class)
    private static final class DefaultData {

        @CompilationFinal BranchProfile hasGetBranch_;
        @CompilationFinal BranchProfile hasSetBranch_;
        @CompilationFinal BranchProfile hasEnumerableBranch_;
        @CompilationFinal BranchProfile hasConfigurableBranch_;
        @CompilationFinal BranchProfile hasValueBranch_;
        @CompilationFinal BranchProfile hasWritableBranch_;

        DefaultData() {
        }

    }
}
