// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSGuardDisconnectedArgumentWrite.class)
public final class JSGuardDisconnectedArgumentWriteNodeGen extends JSGuardDisconnectedArgumentWrite implements Provider {

    @CompilationFinal private volatile int state_;
    @CompilationFinal private ConditionProfile unconnected;
    @CompilationFinal private ConditionProfile objectDisconnected_wasDisconnected_;

    private JSGuardDisconnectedArgumentWriteNodeGen(int index, WriteElementNode argumentsArrayAccess, JavaScriptNode argumentsArray, JavaScriptNode rhs, FrameSlot slot) {
        super(index, argumentsArrayAccess, argumentsArray, rhs, slot);
    }

    @Override
    protected Object executeWrite(VirtualFrame frameValue, Object argumentsArrayNodeValue, Object rhsNodeValue) {
        int state = state_;
        if (state != 0 /* is-active doObject(DynamicObject, Object, ConditionProfile) || doObjectDisconnected(DynamicObject, Object, ConditionProfile, ConditionProfile) */ && JSTypes.isDynamicObject(argumentsArrayNodeValue)) {
            DynamicObject argumentsArrayNodeValue_ = (DynamicObject) argumentsArrayNodeValue;
            if ((state & 0b1) != 0 /* is-active doObject(DynamicObject, Object, ConditionProfile) */) {
                if ((!(JSGuards.isArgumentsDisconnected(argumentsArrayNodeValue_)))) {
                    return doObject(argumentsArrayNodeValue_, rhsNodeValue, this.unconnected);
                }
            }
            if ((state & 0b10) != 0 /* is-active doObjectDisconnected(DynamicObject, Object, ConditionProfile, ConditionProfile) */) {
                if ((JSGuards.isArgumentsDisconnected(argumentsArrayNodeValue_))) {
                    return doObjectDisconnected(argumentsArrayNodeValue_, rhsNodeValue, this.objectDisconnected_wasDisconnected_, this.unconnected);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(argumentsArrayNodeValue, rhsNodeValue);
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        int state = state_;
        Object argumentsArrayNodeValue_ = super.argumentsArrayNode.execute(frameValue);
        Object rhsNodeValue_ = super.rhsNode.execute(frameValue);
        if (state != 0 /* is-active doObject(DynamicObject, Object, ConditionProfile) || doObjectDisconnected(DynamicObject, Object, ConditionProfile, ConditionProfile) */ && JSTypes.isDynamicObject(argumentsArrayNodeValue_)) {
            DynamicObject argumentsArrayNodeValue__ = (DynamicObject) argumentsArrayNodeValue_;
            if ((state & 0b1) != 0 /* is-active doObject(DynamicObject, Object, ConditionProfile) */) {
                if ((!(JSGuards.isArgumentsDisconnected(argumentsArrayNodeValue__)))) {
                    return doObject(argumentsArrayNodeValue__, rhsNodeValue_, this.unconnected);
                }
            }
            if ((state & 0b10) != 0 /* is-active doObjectDisconnected(DynamicObject, Object, ConditionProfile, ConditionProfile) */) {
                if ((JSGuards.isArgumentsDisconnected(argumentsArrayNodeValue__))) {
                    return doObjectDisconnected(argumentsArrayNodeValue__, rhsNodeValue_, this.objectDisconnected_wasDisconnected_, this.unconnected);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(argumentsArrayNodeValue_, rhsNodeValue_);
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        execute(frameValue);
        return;
    }

    private Object executeAndSpecialize(Object argumentsArrayNodeValue, Object rhsNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        try {
            if (JSTypes.isDynamicObject(argumentsArrayNodeValue)) {
                DynamicObject argumentsArrayNodeValue_ = (DynamicObject) argumentsArrayNodeValue;
                if ((!(JSGuards.isArgumentsDisconnected(argumentsArrayNodeValue_)))) {
                    if (this.unconnected == null) {
                        this.unconnected = (ConditionProfile.createBinaryProfile());
                    }
                    this.state_ = state = state | 0b1 /* add-active doObject(DynamicObject, Object, ConditionProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return doObject(argumentsArrayNodeValue_, rhsNodeValue, this.unconnected);
                }
                if ((JSGuards.isArgumentsDisconnected(argumentsArrayNodeValue_))) {
                    this.objectDisconnected_wasDisconnected_ = (ConditionProfile.createBinaryProfile());
                    if (this.unconnected == null) {
                        this.unconnected = (ConditionProfile.createBinaryProfile());
                    }
                    this.state_ = state = state | 0b10 /* add-active doObjectDisconnected(DynamicObject, Object, ConditionProfile, ConditionProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return doObjectDisconnected(argumentsArrayNodeValue_, rhsNodeValue, this.objectDisconnected_wasDisconnected_, this.unconnected);
                }
            }
            throw new UnsupportedSpecializationException(this, new Node[] {super.argumentsArrayNode, super.rhsNode}, argumentsArrayNodeValue, rhsNodeValue);
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
        s[0] = "doObject";
        if ((state & 0b1) != 0 /* is-active doObject(DynamicObject, Object, ConditionProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.unconnected));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doObjectDisconnected";
        if ((state & 0b10) != 0 /* is-active doObjectDisconnected(DynamicObject, Object, ConditionProfile, ConditionProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.objectDisconnected_wasDisconnected_, this.unconnected));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        return Provider.create(data);
    }

    public static JSGuardDisconnectedArgumentWrite create(int index, WriteElementNode argumentsArrayAccess, JavaScriptNode argumentsArray, JavaScriptNode rhs, FrameSlot slot) {
        return new JSGuardDisconnectedArgumentWriteNodeGen(index, argumentsArrayAccess, argumentsArray, rhs, slot);
    }

}
