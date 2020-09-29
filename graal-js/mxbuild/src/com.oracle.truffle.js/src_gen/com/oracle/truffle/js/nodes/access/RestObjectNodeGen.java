// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.cast.JSToObjectNode;
import com.oracle.truffle.js.runtime.JSContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(RestObjectNode.class)
public final class RestObjectNodeGen extends RestObjectNode implements Provider {

    @CompilationFinal private volatile int state_;
    @Child private JSToObjectNode other_toObjectNode_;

    private RestObjectNodeGen(JSContext context, JavaScriptNode targetNode, JavaScriptNode sourceNode) {
        super(context, targetNode, sourceNode);
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        int state = state_;
        Object targetNodeValue_ = super.targetNode.execute(frameValue);
        Object sourceNodeValue_ = super.sourceNode.execute(frameValue);
        if (state != 0 /* is-active doNullOrUndefined(DynamicObject, Object) || copyDataProperties(DynamicObject, DynamicObject) || doOther(DynamicObject, Object, JSToObjectNode) */ && JSTypes.isDynamicObject(targetNodeValue_)) {
            DynamicObject targetNodeValue__ = (DynamicObject) targetNodeValue_;
            if ((state & 0b1) != 0 /* is-active doNullOrUndefined(DynamicObject, Object) */) {
                if ((JSGuards.isNullOrUndefined(sourceNodeValue_))) {
                    return RestObjectNode.doNullOrUndefined(targetNodeValue__, sourceNodeValue_);
                }
            }
            if ((state & 0b10) != 0 /* is-active copyDataProperties(DynamicObject, DynamicObject) */ && JSTypes.isDynamicObject(sourceNodeValue_)) {
                DynamicObject sourceNodeValue__ = (DynamicObject) sourceNodeValue_;
                if ((JSGuards.isJSObject(sourceNodeValue__))) {
                    return copyDataProperties(targetNodeValue__, sourceNodeValue__);
                }
            }
            if ((state & 0b100) != 0 /* is-active doOther(DynamicObject, Object, JSToObjectNode) */) {
                if ((!(JSGuards.isJSDynamicObject(sourceNodeValue_)))) {
                    return doOther(targetNodeValue__, sourceNodeValue_, this.other_toObjectNode_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(targetNodeValue_, sourceNodeValue_);
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        execute(frameValue);
        return;
    }

    private Object executeAndSpecialize(Object targetNodeValue, Object sourceNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        try {
            if (JSTypes.isDynamicObject(targetNodeValue)) {
                DynamicObject targetNodeValue_ = (DynamicObject) targetNodeValue;
                if ((JSGuards.isNullOrUndefined(sourceNodeValue))) {
                    this.state_ = state = state | 0b1 /* add-active doNullOrUndefined(DynamicObject, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return RestObjectNode.doNullOrUndefined(targetNodeValue_, sourceNodeValue);
                }
                if (JSTypes.isDynamicObject(sourceNodeValue)) {
                    DynamicObject sourceNodeValue_ = (DynamicObject) sourceNodeValue;
                    if ((JSGuards.isJSObject(sourceNodeValue_))) {
                        this.state_ = state = state | 0b10 /* add-active copyDataProperties(DynamicObject, DynamicObject) */;
                        lock.unlock();
                        hasLock = false;
                        return copyDataProperties(targetNodeValue_, sourceNodeValue_);
                    }
                }
                if ((!(JSGuards.isJSDynamicObject(sourceNodeValue)))) {
                    this.other_toObjectNode_ = super.insert((JSToObjectNode.createToObjectNoCheck(context)));
                    this.state_ = state = state | 0b100 /* add-active doOther(DynamicObject, Object, JSToObjectNode) */;
                    lock.unlock();
                    hasLock = false;
                    return doOther(targetNodeValue_, sourceNodeValue, this.other_toObjectNode_);
                }
            }
            throw new UnsupportedSpecializationException(this, new Node[] {super.targetNode, super.sourceNode}, targetNodeValue, sourceNodeValue);
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
        s[0] = "doNullOrUndefined";
        if ((state & 0b1) != 0 /* is-active doNullOrUndefined(DynamicObject, Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "copyDataProperties";
        if ((state & 0b10) != 0 /* is-active copyDataProperties(DynamicObject, DynamicObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doOther";
        if ((state & 0b100) != 0 /* is-active doOther(DynamicObject, Object, JSToObjectNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.other_toObjectNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        return Provider.create(data);
    }

    public static RestObjectNode create(JSContext context, JavaScriptNode targetNode, JavaScriptNode sourceNode) {
        return new RestObjectNodeGen(context, targetNode, sourceNode);
    }

}
