// CheckStyle: start generated
package com.oracle.truffle.js.nodes.function;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.nodes.DirectCallNode;
import com.oracle.truffle.api.nodes.IndirectCallNode;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.source.Source;
import com.oracle.truffle.js.nodes.interop.ImportValueNode;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.JSRealm;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSLoadNode.class)
public final class JSLoadNodeGen extends JSLoadNode implements Provider {

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @Child private ImportValueNode importValue;
    @CompilationFinal private Source cachedLoad_cachedSource_;
    @Child private DirectCallNode cachedLoad_callNode_;
    @Child private IndirectCallNode uncachedLoad_callNode_;

    private JSLoadNodeGen(JSContext context) {
        super(context);
    }

    @Override
    public Object executeLoad(Source arg0Value, JSRealm arg1Value) {
        int state = state_;
        if (state != 0 /* is-active cachedLoad(Source, JSRealm, ImportValueNode, Source, DirectCallNode) || uncachedLoad(Source, JSRealm, ImportValueNode, IndirectCallNode) */) {
            if ((state & 0b1) != 0 /* is-active cachedLoad(Source, JSRealm, ImportValueNode, Source, DirectCallNode) */) {
                assert (this.cachedLoad_cachedSource_.isCached());
                if ((JSLoadNode.equals(arg0Value, this.cachedLoad_cachedSource_))) {
                    return JSLoadNode.cachedLoad(arg0Value, arg1Value, this.importValue, this.cachedLoad_cachedSource_, this.cachedLoad_callNode_);
                }
            }
            if ((state & 0b10) != 0 /* is-active uncachedLoad(Source, JSRealm, ImportValueNode, IndirectCallNode) */) {
                return JSLoadNode.uncachedLoad(arg0Value, arg1Value, this.importValue, this.uncachedLoad_callNode_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value);
    }

    private Object executeAndSpecialize(Source arg0Value, JSRealm arg1Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        int exclude = exclude_;
        try {
            if ((exclude) == 0 /* is-not-excluded cachedLoad(Source, JSRealm, ImportValueNode, Source, DirectCallNode) */) {
                boolean CachedLoad_duplicateFound_ = false;
                if ((state & 0b1) != 0 /* is-active cachedLoad(Source, JSRealm, ImportValueNode, Source, DirectCallNode) */) {
                    assert (this.cachedLoad_cachedSource_.isCached());
                    if ((JSLoadNode.equals(arg0Value, this.cachedLoad_cachedSource_))) {
                        CachedLoad_duplicateFound_ = true;
                    }
                }
                if (!CachedLoad_duplicateFound_) {
                    {
                        Source cachedLoad_cachedSource__ = (arg0Value);
                        if ((cachedLoad_cachedSource__.isCached()) && (JSLoadNode.equals(arg0Value, cachedLoad_cachedSource__)) && ((state & 0b1)) == 0 /* is-not-active cachedLoad(Source, JSRealm, ImportValueNode, Source, DirectCallNode) */) {
                            if (this.importValue == null) {
                                this.importValue = super.insert((ImportValueNode.create()));
                            }
                            this.cachedLoad_cachedSource_ = cachedLoad_cachedSource__;
                            this.cachedLoad_callNode_ = super.insert((DirectCallNode.create(JSLoadNode.loadScript(arg0Value, arg1Value))));
                            this.state_ = state = state | 0b1 /* add-active cachedLoad(Source, JSRealm, ImportValueNode, Source, DirectCallNode) */;
                            CachedLoad_duplicateFound_ = true;
                        }
                    }
                }
                if (CachedLoad_duplicateFound_) {
                    lock.unlock();
                    hasLock = false;
                    return JSLoadNode.cachedLoad(arg0Value, arg1Value, this.importValue, this.cachedLoad_cachedSource_, this.cachedLoad_callNode_);
                }
            }
            if (this.importValue == null) {
                this.importValue = super.insert((ImportValueNode.create()));
            }
            this.uncachedLoad_callNode_ = super.insert((IndirectCallNode.create()));
            this.exclude_ = exclude = exclude | 0b1 /* add-excluded cachedLoad(Source, JSRealm, ImportValueNode, Source, DirectCallNode) */;
            state = state & 0xfffffffe /* remove-active cachedLoad(Source, JSRealm, ImportValueNode, Source, DirectCallNode) */;
            this.state_ = state = state | 0b10 /* add-active uncachedLoad(Source, JSRealm, ImportValueNode, IndirectCallNode) */;
            lock.unlock();
            hasLock = false;
            return JSLoadNode.uncachedLoad(arg0Value, arg1Value, this.importValue, this.uncachedLoad_callNode_);
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
        int exclude = exclude_;
        s = new Object[3];
        s[0] = "cachedLoad";
        if ((state & 0b1) != 0 /* is-active cachedLoad(Source, JSRealm, ImportValueNode, Source, DirectCallNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.importValue, this.cachedLoad_cachedSource_, this.cachedLoad_callNode_));
            s[2] = cached;
        } else if (exclude != 0 /* is-excluded cachedLoad(Source, JSRealm, ImportValueNode, Source, DirectCallNode) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "uncachedLoad";
        if ((state & 0b10) != 0 /* is-active uncachedLoad(Source, JSRealm, ImportValueNode, IndirectCallNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.importValue, this.uncachedLoad_callNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        return Provider.create(data);
    }

    public static JSLoadNode create(JSContext context) {
        return new JSLoadNodeGen(context);
    }

}
