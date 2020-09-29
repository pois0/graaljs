// CheckStyle: start generated
package com.oracle.truffle.js.nodes.module;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.access.JSReadFrameSlotNode;
import com.oracle.truffle.js.runtime.objects.ExportResolution;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(ReadImportBindingNode.class)
public final class ReadImportBindingNodeGen extends ReadImportBindingNode implements Provider {

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @Child private CachedData cached_cache;

    private ReadImportBindingNodeGen(JavaScriptNode resolutionNode) {
        super(resolutionNode);
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        int state = state_;
        Object resolutionNodeValue_ = super.resolutionNode.execute(frameValue);
        if ((state & 0b11) != 0 /* is-active doCached(ExportResolution, FrameDescriptor, String, JSReadFrameSlotNode) || doUncached(ExportResolution) */ && resolutionNodeValue_ instanceof ExportResolution) {
            ExportResolution resolutionNodeValue__ = (ExportResolution) resolutionNodeValue_;
            if ((state & 0b1) != 0 /* is-active doCached(ExportResolution, FrameDescriptor, String, JSReadFrameSlotNode) */) {
                CachedData s1_ = this.cached_cache;
                if (s1_ != null) {
                    if ((s1_.frameDescriptor_ == resolutionNodeValue__.getModule().getFrameDescriptor()) && (s1_.bindingName_.equals(resolutionNodeValue__.getBindingName()))) {
                        return ReadImportBindingNode.doCached(resolutionNodeValue__, s1_.frameDescriptor_, s1_.bindingName_, s1_.readFrameSlot_);
                    }
                }
            }
            if ((state & 0b10) != 0 /* is-active doUncached(ExportResolution) */) {
                return doUncached(resolutionNodeValue__);
            }
        }
        if ((state & 0b100) != 0 /* is-active doNamespace(DynamicObject) */ && JSTypes.isDynamicObject(resolutionNodeValue_)) {
            DynamicObject resolutionNodeValue__ = (DynamicObject) resolutionNodeValue_;
            if ((JSGuards.isJSModuleNamespace(resolutionNodeValue__))) {
                return ReadImportBindingNode.doNamespace(resolutionNodeValue__);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(resolutionNodeValue_);
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        execute(frameValue);
        return;
    }

    private Object executeAndSpecialize(Object resolutionNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        int exclude = exclude_;
        try {
            if (resolutionNodeValue instanceof ExportResolution) {
                ExportResolution resolutionNodeValue_ = (ExportResolution) resolutionNodeValue;
                if ((exclude) == 0 /* is-not-excluded doCached(ExportResolution, FrameDescriptor, String, JSReadFrameSlotNode) */) {
                    CachedData s1_ = this.cached_cache;
                    boolean Cached_duplicateFound_ = false;
                    if ((state & 0b1) != 0 /* is-active doCached(ExportResolution, FrameDescriptor, String, JSReadFrameSlotNode) */) {
                        if ((s1_.frameDescriptor_ == resolutionNodeValue_.getModule().getFrameDescriptor()) && (s1_.bindingName_.equals(resolutionNodeValue_.getBindingName()))) {
                            Cached_duplicateFound_ = true;
                        }
                    }
                    if (!Cached_duplicateFound_) {
                        {
                            FrameDescriptor frameDescriptor__ = (resolutionNodeValue_.getModule().getFrameDescriptor());
                            if ((frameDescriptor__ == resolutionNodeValue_.getModule().getFrameDescriptor())) {
                                String bindingName__ = (resolutionNodeValue_.getBindingName());
                                if ((bindingName__.equals(resolutionNodeValue_.getBindingName())) && ((state & 0b1)) == 0 /* is-not-active doCached(ExportResolution, FrameDescriptor, String, JSReadFrameSlotNode) */) {
                                    s1_ = super.insert(new CachedData());
                                    s1_.frameDescriptor_ = frameDescriptor__;
                                    s1_.bindingName_ = bindingName__;
                                    s1_.readFrameSlot_ = s1_.insertAccessor((JSReadFrameSlotNode.create(frameDescriptor__.findFrameSlot(bindingName__))));
                                    this.cached_cache = s1_;
                                    this.state_ = state = state | 0b1 /* add-active doCached(ExportResolution, FrameDescriptor, String, JSReadFrameSlotNode) */;
                                    Cached_duplicateFound_ = true;
                                }
                            }
                        }
                    }
                    if (Cached_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return ReadImportBindingNode.doCached(resolutionNodeValue_, s1_.frameDescriptor_, s1_.bindingName_, s1_.readFrameSlot_);
                    }
                }
                this.exclude_ = exclude = exclude | 0b1 /* add-excluded doCached(ExportResolution, FrameDescriptor, String, JSReadFrameSlotNode) */;
                this.cached_cache = null;
                state = state & 0xfffffffe /* remove-active doCached(ExportResolution, FrameDescriptor, String, JSReadFrameSlotNode) */;
                this.state_ = state = state | 0b10 /* add-active doUncached(ExportResolution) */;
                lock.unlock();
                hasLock = false;
                return doUncached(resolutionNodeValue_);
            }
            if (JSTypes.isDynamicObject(resolutionNodeValue)) {
                DynamicObject resolutionNodeValue_ = (DynamicObject) resolutionNodeValue;
                if ((JSGuards.isJSModuleNamespace(resolutionNodeValue_))) {
                    this.state_ = state = state | 0b100 /* add-active doNamespace(DynamicObject) */;
                    lock.unlock();
                    hasLock = false;
                    return ReadImportBindingNode.doNamespace(resolutionNodeValue_);
                }
            }
            throw new UnsupportedSpecializationException(this, new Node[] {super.resolutionNode}, resolutionNodeValue);
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
        int exclude = exclude_;
        s = new Object[3];
        s[0] = "doCached";
        if ((state & 0b1) != 0 /* is-active doCached(ExportResolution, FrameDescriptor, String, JSReadFrameSlotNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            CachedData s1_ = this.cached_cache;
            if (s1_ != null) {
                cached.add(Arrays.asList(s1_.frameDescriptor_, s1_.bindingName_, s1_.readFrameSlot_));
            }
            s[2] = cached;
        } else if (exclude != 0 /* is-excluded doCached(ExportResolution, FrameDescriptor, String, JSReadFrameSlotNode) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doUncached";
        if ((state & 0b10) != 0 /* is-active doUncached(ExportResolution) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doNamespace";
        if ((state & 0b100) != 0 /* is-active doNamespace(DynamicObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        return Provider.create(data);
    }

    public static ReadImportBindingNode create(JavaScriptNode resolutionNode) {
        return new ReadImportBindingNodeGen(resolutionNode);
    }

    @GeneratedBy(ReadImportBindingNode.class)
    private static final class CachedData extends Node {

        @CompilationFinal FrameDescriptor frameDescriptor_;
        @CompilationFinal String bindingName_;
        @Child JSReadFrameSlotNode readFrameSlot_;

        CachedData() {
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
