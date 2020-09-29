// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.runtime.JSContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(GetTemplateObjectNode.class)
public final class GetTemplateObjectNodeGen extends GetTemplateObjectNode implements Provider {

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private DynamicObject cached_cachedTemplate_;
    @CompilationFinal private Assumption cached_assumption0_;

    private GetTemplateObjectNodeGen(JSContext context, ArrayLiteralNode rawStrings, ArrayLiteralNode cookedStrings) {
        super(context, rawStrings, cookedStrings);
    }

    private GetTemplateObjectNodeGen(JSContext context, ArrayLiteralNode rawStrings, ArrayLiteralNode cookedStrings, Object identity) {
        super(context, rawStrings, cookedStrings, identity);
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        int state = state_;
        if ((state & 0b1) != 0 /* is-active doCached(VirtualFrame, DynamicObject) */) {
            if (!Assumption.isValidAssumption(this.cached_assumption0_)) {
                CompilerDirectives.transferToInterpreterAndInvalidate();
                removeCached_();
                return executeAndSpecialize(frameValue);
            }
            assert (!(context.isMultiContext()));
            return doCached(frameValue, this.cached_cachedTemplate_);
        }
        if ((state & 0b10) != 0 /* is-active doUncached(VirtualFrame) */) {
            return doUncached(frameValue);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(frameValue);
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        execute(frameValue);
        return;
    }

    private DynamicObject executeAndSpecialize(VirtualFrame frameValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        int exclude = exclude_;
        try {
            if ((exclude) == 0 /* is-not-excluded doCached(VirtualFrame, DynamicObject) */) {
                if ((!(context.isMultiContext()))) {
                    Assumption cached_assumption0 = (context.getSingleRealmAssumption());
                    if (Assumption.isValidAssumption(cached_assumption0)) {
                        this.cached_cachedTemplate_ = (doUncached(frameValue));
                        this.cached_assumption0_ = cached_assumption0;
                        this.state_ = state = state | 0b1 /* add-active doCached(VirtualFrame, DynamicObject) */;
                        lock.unlock();
                        hasLock = false;
                        return doCached(frameValue, this.cached_cachedTemplate_);
                    }
                }
            }
            this.exclude_ = exclude = exclude | 0b1 /* add-excluded doCached(VirtualFrame, DynamicObject) */;
            state = state & 0xfffffffe /* remove-active doCached(VirtualFrame, DynamicObject) */;
            this.state_ = state = state | 0b10 /* add-active doUncached(VirtualFrame) */;
            lock.unlock();
            hasLock = false;
            return doUncached(frameValue);
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

    void removeCached_() {
        Lock lock = getLock();
        lock.lock();
        try {
            this.state_ = this.state_ & 0xfffffffe /* remove-active doCached(VirtualFrame, DynamicObject) */;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[3];
        Object[] s;
        data[0] = 0;
        int state = state_;
        int exclude = exclude_;
        s = new Object[3];
        s[0] = "doCached";
        if ((state & 0b1) != 0 /* is-active doCached(VirtualFrame, DynamicObject) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.cached_cachedTemplate_));
            s[2] = cached;
        } else if (exclude != 0 /* is-excluded doCached(VirtualFrame, DynamicObject) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doUncached";
        if ((state & 0b10) != 0 /* is-active doUncached(VirtualFrame) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        return Provider.create(data);
    }

    public static GetTemplateObjectNode create(JSContext context, ArrayLiteralNode rawStrings, ArrayLiteralNode cookedStrings) {
        return new GetTemplateObjectNodeGen(context, rawStrings, cookedStrings);
    }

    public static GetTemplateObjectNode create(JSContext context, ArrayLiteralNode rawStrings, ArrayLiteralNode cookedStrings, Object identity) {
        return new GetTemplateObjectNodeGen(context, rawStrings, cookedStrings, identity);
    }

}
