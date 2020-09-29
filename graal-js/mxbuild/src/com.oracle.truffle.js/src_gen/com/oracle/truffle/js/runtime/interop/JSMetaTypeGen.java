// CheckStyle: start generated
package com.oracle.truffle.js.runtime.interop;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.library.DynamicDispatchLibrary;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.js.runtime.interop.JSMetaType.IsMetaInstance;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSMetaType.class)
final class JSMetaTypeGen {

    private static final LibraryFactory<DynamicDispatchLibrary> DYNAMIC_DISPATCH_LIBRARY_ = LibraryFactory.resolve(DynamicDispatchLibrary.class);
    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    static  {
        LibraryExport.register(JSMetaType.class, new InteropLibraryExports());
    }

    private JSMetaTypeGen() {
    }

    @GeneratedBy(JSMetaType.class)
    private static final class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        private InteropLibraryExports() {
            super(InteropLibrary.class, JSMetaType.class, false);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof JSMetaType;
            InteropLibrary uncached = new Uncached();
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof JSMetaType;
            return new Cached();
        }

        @GeneratedBy(JSMetaType.class)
        private static final class Cached extends InteropLibrary {

            @CompilationFinal private volatile int state_;
            @CompilationFinal private volatile int exclude_;
            @Child private CachedData cached_cache;

            Cached() {
            }

            @Override
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof JSMetaType) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof JSMetaType;
            }

            @ExplodeLoop
            @Override
            public boolean isMetaInstance(Object arg0Value_, Object arg1Value) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSMetaType arg0Value = ((JSMetaType) arg0Value_);
                int state = state_;
                if (state != 0 /* is-active doCached(JSMetaType, Object, JSMetaType, InteropLibrary) || doGeneric(JSMetaType, Object) */) {
                    if ((state & 0b1) != 0 /* is-active doCached(JSMetaType, Object, JSMetaType, InteropLibrary) */) {
                        CachedData s1_ = this.cached_cache;
                        while (s1_ != null) {
                            if ((s1_.valueLib_.accepts(arg1Value)) && (arg0Value == s1_.cachedType_)) {
                                return IsMetaInstance.doCached(arg0Value, arg1Value, s1_.cachedType_, s1_.valueLib_);
                            }
                            s1_ = s1_.next_;
                        }
                    }
                    if ((state & 0b10) != 0 /* is-active doGeneric(JSMetaType, Object) */) {
                        return IsMetaInstance.doGeneric(arg0Value, arg1Value);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return executeAndSpecialize(arg0Value, arg1Value);
            }

            private boolean executeAndSpecialize(JSMetaType arg0Value, Object arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                int state = state_;
                int exclude = exclude_;
                try {
                    if ((exclude) == 0 /* is-not-excluded doCached(JSMetaType, Object, JSMetaType, InteropLibrary) */) {
                        int count1_ = 0;
                        CachedData s1_ = this.cached_cache;
                        if ((state & 0b1) != 0 /* is-active doCached(JSMetaType, Object, JSMetaType, InteropLibrary) */) {
                            while (s1_ != null) {
                                if ((s1_.valueLib_.accepts(arg1Value)) && (arg0Value == s1_.cachedType_)) {
                                    break;
                                }
                                s1_ = s1_.next_;
                                count1_++;
                            }
                        }
                        if (s1_ == null) {
                            // assert (s1_.valueLib_.accepts(arg1Value));
                            // assert (arg0Value == s1_.cachedType_);
                            if (count1_ < (3)) {
                                s1_ = super.insert(new CachedData(cached_cache));
                                s1_.cachedType_ = (arg0Value);
                                s1_.valueLib_ = s1_.insertAccessor((INTEROP_LIBRARY_.create(arg1Value)));
                                this.cached_cache = s1_;
                                this.state_ = state = state | 0b1 /* add-active doCached(JSMetaType, Object, JSMetaType, InteropLibrary) */;
                            }
                        }
                        if (s1_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return IsMetaInstance.doCached(arg0Value, arg1Value, s1_.cachedType_, s1_.valueLib_);
                        }
                    }
                    this.exclude_ = exclude = exclude | 0b1 /* add-excluded doCached(JSMetaType, Object, JSMetaType, InteropLibrary) */;
                    this.cached_cache = null;
                    state = state & 0xfffffffe /* remove-active doCached(JSMetaType, Object, JSMetaType, InteropLibrary) */;
                    this.state_ = state = state | 0b10 /* add-active doGeneric(JSMetaType, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return IsMetaInstance.doGeneric(arg0Value, arg1Value);
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
            public boolean hasLanguage(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((JSMetaType) receiver)).hasLanguage();
            }

            @Override
            public Class<? extends TruffleLanguage<?>> getLanguage(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((JSMetaType) receiver)).getLanguage();
            }

            @Override
            public boolean isMetaObject(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((JSMetaType) receiver)).isMetaObject();
            }

            @Override
            public Object getMetaQualifiedName(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((JSMetaType) receiver)).getTypeName();
            }

            @Override
            public Object getMetaSimpleName(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((JSMetaType) receiver)).getTypeName();
            }

            @Override
            public Object toDisplayString(Object receiver, boolean allowSideEffects) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((JSMetaType) receiver)).toDisplayString(allowSideEffects);
            }

            @GeneratedBy(JSMetaType.class)
            private static final class CachedData extends Node {

                @Child CachedData next_;
                @CompilationFinal JSMetaType cachedType_;
                @Child InteropLibrary valueLib_;

                CachedData(CachedData next_) {
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
        @GeneratedBy(JSMetaType.class)
        private static final class Uncached extends InteropLibrary {

            Uncached() {
            }

            @TruffleBoundary
            @Override
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof JSMetaType) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof JSMetaType;
            }

            @Override
            public boolean isAdoptable() {
                return false;
            }

            @Override
            public NodeCost getCost() {
                return NodeCost.MEGAMORPHIC;
            }

            @TruffleBoundary
            @Override
            public boolean isMetaInstance(Object arg0Value_, Object arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSMetaType arg0Value = ((JSMetaType) arg0Value_);
                return IsMetaInstance.doGeneric(arg0Value, arg1Value);
            }

            @TruffleBoundary
            @Override
            public boolean hasLanguage(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((JSMetaType) receiver) .hasLanguage();
            }

            @TruffleBoundary
            @Override
            public Class<? extends TruffleLanguage<?>> getLanguage(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((JSMetaType) receiver) .getLanguage();
            }

            @TruffleBoundary
            @Override
            public boolean isMetaObject(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((JSMetaType) receiver) .isMetaObject();
            }

            @TruffleBoundary
            @Override
            public Object getMetaQualifiedName(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((JSMetaType) receiver) .getTypeName();
            }

            @TruffleBoundary
            @Override
            public Object getMetaSimpleName(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((JSMetaType) receiver) .getTypeName();
            }

            @TruffleBoundary
            @Override
            public Object toDisplayString(Object receiver, boolean allowSideEffects) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((JSMetaType) receiver) .toDisplayString(allowSideEffects);
            }

        }
    }
}
