// CheckStyle: start generated
package com.oracle.truffle.js.nodes.function;

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
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.function.DefineMethodNode.FunctionCreateNode;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.builtins.JSFunctionData;
import com.oracle.truffle.js.runtime.builtins.JSFunctionFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(DefineMethodNode.class)
public final class DefineMethodNodeFactory {

    @GeneratedBy(FunctionCreateNode.class)
    protected static final class FunctionCreateNodeGen extends FunctionCreateNode implements Provider {

        @CompilationFinal private volatile int state_;
        @CompilationFinal private volatile int exclude_;
        @CompilationFinal private CachedData cached_cache;
        @CompilationFinal private JSFunctionFactory multiContext_factory_;

        private FunctionCreateNodeGen(JSContext context, JSFunctionData functionData) {
            super(context, functionData);
        }

        @ExplodeLoop
        @Override
        public DynamicObject executeWithPrototype(VirtualFrame frameValue, Object arg0Value) {
            int state = state_;
            if ((state & 0b111) != 0 /* is-active doCached(VirtualFrame, DynamicObject, DynamicObject, JSFunctionFactory) || doUncached(VirtualFrame, DynamicObject) || doMultiContext(VirtualFrame, DynamicObject, JSFunctionFactory) */ && JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if ((state & 0b1) != 0 /* is-active doCached(VirtualFrame, DynamicObject, DynamicObject, JSFunctionFactory) */) {
                    assert (!(getContext().isMultiContext()));
                    CachedData s1_ = this.cached_cache;
                    while (s1_ != null) {
                        if ((arg0Value_ == s1_.cachedPrototype_)) {
                            assert (JSGuards.isJSObject(s1_.cachedPrototype_));
                            return doCached(frameValue, arg0Value_, s1_.cachedPrototype_, s1_.factory_);
                        }
                        s1_ = s1_.next_;
                    }
                }
                if ((state & 0b10) != 0 /* is-active doUncached(VirtualFrame, DynamicObject) */) {
                    assert (!(getContext().isMultiContext()));
                    if ((JSGuards.isJSObject(arg0Value_))) {
                        return doUncached(frameValue, arg0Value_);
                    }
                }
                if ((state & 0b100) != 0 /* is-active doMultiContext(VirtualFrame, DynamicObject, JSFunctionFactory) */) {
                    assert (getContext().isMultiContext());
                    if ((JSGuards.isJSObject(arg0Value_))) {
                        return doMultiContext(frameValue, arg0Value_, this.multiContext_factory_);
                    }
                }
            }
            if ((state & 0b1000) != 0 /* is-active doNonObject(Object) */) {
                if ((!(JSGuards.isJSObject(arg0Value)))) {
                    return doNonObject(arg0Value);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(frameValue, arg0Value);
        }

        private DynamicObject executeAndSpecialize(VirtualFrame frameValue, Object arg0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int exclude = exclude_;
            try {
                if (JSTypes.isDynamicObject(arg0Value)) {
                    DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                    if ((exclude) == 0 /* is-not-excluded doCached(VirtualFrame, DynamicObject, DynamicObject, JSFunctionFactory) */ && (!(getContext().isMultiContext()))) {
                        int count1_ = 0;
                        CachedData s1_ = this.cached_cache;
                        if ((state & 0b1) != 0 /* is-active doCached(VirtualFrame, DynamicObject, DynamicObject, JSFunctionFactory) */) {
                            while (s1_ != null) {
                                if ((arg0Value_ == s1_.cachedPrototype_)) {
                                    assert (JSGuards.isJSObject(s1_.cachedPrototype_));
                                    break;
                                }
                                s1_ = s1_.next_;
                                count1_++;
                            }
                        }
                        if (s1_ == null) {
                            {
                                DynamicObject cachedPrototype__ = (arg0Value_);
                                // assert (arg0Value_ == s1_.cachedPrototype_);
                                if ((JSGuards.isJSObject(cachedPrototype__)) && count1_ < (getContext().getPropertyCacheLimit())) {
                                    s1_ = new CachedData(cached_cache);
                                    s1_.cachedPrototype_ = cachedPrototype__;
                                    s1_.factory_ = (makeFactory(arg0Value_));
                                    this.cached_cache = s1_;
                                    this.state_ = state = state | 0b1 /* add-active doCached(VirtualFrame, DynamicObject, DynamicObject, JSFunctionFactory) */;
                                }
                            }
                        }
                        if (s1_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return doCached(frameValue, arg0Value_, s1_.cachedPrototype_, s1_.factory_);
                        }
                    }
                    if ((!(getContext().isMultiContext())) && (JSGuards.isJSObject(arg0Value_))) {
                        this.exclude_ = exclude = exclude | 0b1 /* add-excluded doCached(VirtualFrame, DynamicObject, DynamicObject, JSFunctionFactory) */;
                        this.cached_cache = null;
                        state = state & 0xfffffffe /* remove-active doCached(VirtualFrame, DynamicObject, DynamicObject, JSFunctionFactory) */;
                        this.state_ = state = state | 0b10 /* add-active doUncached(VirtualFrame, DynamicObject) */;
                        lock.unlock();
                        hasLock = false;
                        return doUncached(frameValue, arg0Value_);
                    }
                    if ((getContext().isMultiContext()) && (JSGuards.isJSObject(arg0Value_))) {
                        this.multiContext_factory_ = (makeFactoryMultiContext());
                        this.state_ = state = state | 0b100 /* add-active doMultiContext(VirtualFrame, DynamicObject, JSFunctionFactory) */;
                        lock.unlock();
                        hasLock = false;
                        return doMultiContext(frameValue, arg0Value_, this.multiContext_factory_);
                    }
                }
                if ((!(JSGuards.isJSObject(arg0Value)))) {
                    this.state_ = state = state | 0b1000 /* add-active doNonObject(Object) */;
                    lock.unlock();
                    hasLock = false;
                    return doNonObject(arg0Value);
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
                CachedData s1_ = this.cached_cache;
                if ((s1_ == null || s1_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[5];
            Object[] s;
            data[0] = 0;
            int state = state_;
            int exclude = exclude_;
            s = new Object[3];
            s[0] = "doCached";
            if ((state & 0b1) != 0 /* is-active doCached(VirtualFrame, DynamicObject, DynamicObject, JSFunctionFactory) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                CachedData s1_ = this.cached_cache;
                while (s1_ != null) {
                    cached.add(Arrays.asList(s1_.cachedPrototype_, s1_.factory_));
                    s1_ = s1_.next_;
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-excluded doCached(VirtualFrame, DynamicObject, DynamicObject, JSFunctionFactory) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doUncached";
            if ((state & 0b10) != 0 /* is-active doUncached(VirtualFrame, DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "doMultiContext";
            if ((state & 0b100) != 0 /* is-active doMultiContext(VirtualFrame, DynamicObject, JSFunctionFactory) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.multiContext_factory_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "doNonObject";
            if ((state & 0b1000) != 0 /* is-active doNonObject(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            return Provider.create(data);
        }

        public static FunctionCreateNode create(JSContext context, JSFunctionData functionData) {
            return new FunctionCreateNodeGen(context, functionData);
        }

        @GeneratedBy(FunctionCreateNode.class)
        private static final class CachedData {

            @CompilationFinal CachedData next_;
            @CompilationFinal DynamicObject cachedPrototype_;
            @CompilationFinal JSFunctionFactory factory_;

            CachedData(CachedData next_) {
                this.next_ = next_;
            }

        }
    }
}
