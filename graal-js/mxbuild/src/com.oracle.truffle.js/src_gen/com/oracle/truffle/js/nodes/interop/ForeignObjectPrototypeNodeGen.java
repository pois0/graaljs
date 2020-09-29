// CheckStyle: start generated
package com.oracle.truffle.js.nodes.interop;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.TruffleLanguage.ContextReference;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.EncapsulatingNodeReference;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.lang.JavaScriptLanguage;
import com.oracle.truffle.js.runtime.JSRealm;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(ForeignObjectPrototypeNode.class)
@SuppressWarnings("unused")
public final class ForeignObjectPrototypeNodeGen extends ForeignObjectPrototypeNode implements Provider {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private ContextReference<JSRealm> javaScriptLanguageContextReference_;
    @Child private TruffleObject0Data truffleObject0_cache;

    private ForeignObjectPrototypeNodeGen() {
    }

    @ExplodeLoop
    @Override
    public DynamicObject executeDynamicObject(Object arg0Value) {
        int state = state_;
        if (state != 0 /* is-active doTruffleObject(Object, JSRealm, InteropLibrary) || doTruffleObject(Object, JSRealm, InteropLibrary) */) {
            if ((state & 0b1) != 0 /* is-active doTruffleObject(Object, JSRealm, InteropLibrary) */) {
                TruffleObject0Data s1_ = this.truffleObject0_cache;
                while (s1_ != null) {
                    if ((s1_.interop_.accepts(arg0Value))) {
                        ContextReference<JSRealm> javaScriptLanguageContextReference__ = this.javaScriptLanguageContextReference_;
                        JSRealm realm__ = javaScriptLanguageContextReference__.get();
                        return doTruffleObject(arg0Value, realm__, s1_.interop_);
                    }
                    s1_ = s1_.next_;
                }
            }
            if ((state & 0b10) != 0 /* is-active doTruffleObject(Object, JSRealm, InteropLibrary) */) {
                return this.truffleObject1Boundary(state, arg0Value);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    @TruffleBoundary
    private DynamicObject truffleObject1Boundary(int state, Object arg0Value) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                ContextReference<JSRealm> javaScriptLanguageContextReference__1 = this.javaScriptLanguageContextReference_;
                JSRealm truffleObject1_realm__ = javaScriptLanguageContextReference__1.get();
                InteropLibrary truffleObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arg0Value));
                return doTruffleObject(arg0Value, truffleObject1_realm__, truffleObject1_interop__);
            }
        } finally {
            encapsulating_.set(prev_);
        }
    }

    private DynamicObject executeAndSpecialize(Object arg0Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        int exclude = exclude_;
        try {
            {
                JSRealm realm__ = null;
                if ((exclude) == 0 /* is-not-excluded doTruffleObject(Object, JSRealm, InteropLibrary) */) {
                    int count1_ = 0;
                    TruffleObject0Data s1_ = this.truffleObject0_cache;
                    if ((state & 0b1) != 0 /* is-active doTruffleObject(Object, JSRealm, InteropLibrary) */) {
                        while (s1_ != null) {
                            if ((s1_.interop_.accepts(arg0Value))) {
                                ContextReference<JSRealm> javaScriptLanguageContextReference__2 = this.javaScriptLanguageContextReference_;
                                if (javaScriptLanguageContextReference__2 == null) {
                                    this.javaScriptLanguageContextReference_ = javaScriptLanguageContextReference__2 = super.lookupContextReference(JavaScriptLanguage.class);
                                }
                                realm__ = javaScriptLanguageContextReference__2.get();
                                break;
                            }
                            s1_ = s1_.next_;
                            count1_++;
                        }
                    }
                    if (s1_ == null) {
                        // assert (s1_.interop_.accepts(arg0Value));
                        if (count1_ < (3)) {
                            s1_ = super.insert(new TruffleObject0Data(truffleObject0_cache));
                            ContextReference<JSRealm> javaScriptLanguageContextReference__3 = this.javaScriptLanguageContextReference_;
                            if (javaScriptLanguageContextReference__3 == null) {
                                this.javaScriptLanguageContextReference_ = javaScriptLanguageContextReference__3 = super.lookupContextReference(JavaScriptLanguage.class);
                            }
                            realm__ = javaScriptLanguageContextReference__3.get();
                            s1_.interop_ = s1_.insertAccessor((INTEROP_LIBRARY_.create(arg0Value)));
                            this.truffleObject0_cache = s1_;
                            this.state_ = state = state | 0b1 /* add-active doTruffleObject(Object, JSRealm, InteropLibrary) */;
                        }
                    }
                    if (s1_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return doTruffleObject(arg0Value, realm__, s1_.interop_);
                    }
                }
            }
            {
                InteropLibrary truffleObject1_interop__ = null;
                JSRealm truffleObject1_realm__ = null;
                {
                    EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                    Node prev_ = encapsulating_.set(this);
                    try {
                        ContextReference<JSRealm> javaScriptLanguageContextReference__4 = this.javaScriptLanguageContextReference_;
                        if (javaScriptLanguageContextReference__4 == null) {
                            this.javaScriptLanguageContextReference_ = javaScriptLanguageContextReference__4 = super.lookupContextReference(JavaScriptLanguage.class);
                        }
                        truffleObject1_realm__ = javaScriptLanguageContextReference__4.get();
                        truffleObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arg0Value));
                        this.exclude_ = exclude = exclude | 0b1 /* add-excluded doTruffleObject(Object, JSRealm, InteropLibrary) */;
                        this.truffleObject0_cache = null;
                        state = state & 0xfffffffe /* remove-active doTruffleObject(Object, JSRealm, InteropLibrary) */;
                        this.state_ = state = state | 0b10 /* add-active doTruffleObject(Object, JSRealm, InteropLibrary) */;
                        lock.unlock();
                        hasLock = false;
                        return doTruffleObject(arg0Value, truffleObject1_realm__, truffleObject1_interop__);
                    } finally {
                        encapsulating_.set(prev_);
                    }
                }
            }
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
            TruffleObject0Data s1_ = this.truffleObject0_cache;
            if ((s1_ == null || s1_.next_ == null)) {
                return NodeCost.MONOMORPHIC;
            }
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
        s[0] = "doTruffleObject";
        if ((state & 0b1) != 0 /* is-active doTruffleObject(Object, JSRealm, InteropLibrary) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            TruffleObject0Data s1_ = this.truffleObject0_cache;
            while (s1_ != null) {
                cached.add(Arrays.asList(s1_.interop_));
                s1_ = s1_.next_;
            }
            s[2] = cached;
        } else if (exclude != 0 /* is-excluded doTruffleObject(Object, JSRealm, InteropLibrary) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doTruffleObject";
        if ((state & 0b10) != 0 /* is-active doTruffleObject(Object, JSRealm, InteropLibrary) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList());
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        return Provider.create(data);
    }

    public static ForeignObjectPrototypeNode create() {
        return new ForeignObjectPrototypeNodeGen();
    }

    @GeneratedBy(ForeignObjectPrototypeNode.class)
    private static final class TruffleObject0Data extends Node {

        @Child TruffleObject0Data next_;
        @Child InteropLibrary interop_;

        TruffleObject0Data(TruffleObject0Data next_) {
            this.next_ = next_;
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
