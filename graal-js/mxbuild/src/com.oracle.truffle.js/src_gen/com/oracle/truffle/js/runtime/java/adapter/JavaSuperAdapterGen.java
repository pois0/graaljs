// CheckStyle: start generated
package com.oracle.truffle.js.runtime.java.adapter;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.interop.ArityException;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.UnknownIdentifierException;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.interop.UnsupportedTypeException;
import com.oracle.truffle.api.library.DynamicDispatchLibrary;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.js.runtime.java.adapter.JavaSuperAdapter.NameCache;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JavaSuperAdapter.class)
final class JavaSuperAdapterGen {

    private static final LibraryFactory<DynamicDispatchLibrary> DYNAMIC_DISPATCH_LIBRARY_ = LibraryFactory.resolve(DynamicDispatchLibrary.class);
    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    static  {
        LibraryExport.register(JavaSuperAdapter.class, new InteropLibraryExports());
    }

    private JavaSuperAdapterGen() {
    }

    @GeneratedBy(JavaSuperAdapter.class)
    private static final class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        private InteropLibraryExports() {
            super(InteropLibrary.class, JavaSuperAdapter.class, false);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof JavaSuperAdapter;
            InteropLibrary uncached = new Uncached();
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof JavaSuperAdapter;
            return new Cached(receiver);
        }

        @GeneratedBy(JavaSuperAdapter.class)
        private static final class Cached extends InteropLibrary {

            @Child private InteropLibrary receiverAdapterInteropLibrary_;
            @CompilationFinal private volatile int state_;
            @CompilationFinal private NameCache cache;

            Cached(Object originalReceiver) {
                JavaSuperAdapter receiver = ((JavaSuperAdapter) originalReceiver) ;
                this.receiverAdapterInteropLibrary_ = super.insert(INTEROP_LIBRARY_.create((receiver.adapter)));
            }

            @Override
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof JavaSuperAdapter) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                if (!(receiver instanceof JavaSuperAdapter)) {
                    return false;
                } else if (!this.receiverAdapterInteropLibrary_.accepts((((JavaSuperAdapter) receiver).adapter))) {
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public boolean hasMembers(Object receiver) {
                assert receiver instanceof JavaSuperAdapter : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((JavaSuperAdapter) receiver)).hasMembers();
            }

            @Override
            public Object readMember(Object arg0Value_, String arg1Value) throws UnsupportedMessageException, UnknownIdentifierException {
                assert arg0Value_ instanceof JavaSuperAdapter : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JavaSuperAdapter arg0Value = ((JavaSuperAdapter) arg0Value_);
                int state = state_;
                if ((state & 0b1) != 0 /* is-active readMember(JavaSuperAdapter, String, NameCache, InteropLibrary) */) {
                    {
                        InteropLibrary readMemberNode__interop__ = this.receiverAdapterInteropLibrary_;
                        return arg0Value.readMember(arg1Value, this.cache, readMemberNode__interop__);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return readMemberNode_AndSpecialize(arg0Value, arg1Value);
            }

            private Object readMemberNode_AndSpecialize(JavaSuperAdapter arg0Value, String arg1Value) throws UnsupportedMessageException, UnknownIdentifierException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                int state = state_;
                try {
                    {
                        InteropLibrary readMemberNode__interop__ = null;
                        if (this.cache == null) {
                            this.cache = (NameCache.create());
                        }
                        readMemberNode__interop__ = this.receiverAdapterInteropLibrary_;
                        this.state_ = state = state | 0b1 /* add-active readMember(JavaSuperAdapter, String, NameCache, InteropLibrary) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.readMember(arg1Value, this.cache, readMemberNode__interop__);
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
                if ((state & 0b1) == 0b0) {
                    return NodeCost.UNINITIALIZED;
                } else {
                    return NodeCost.MONOMORPHIC;
                }
            }

            @Override
            public Object invokeMember(Object arg0Value_, String arg1Value, Object... arg2Value) throws UnsupportedMessageException, ArityException, UnknownIdentifierException, UnsupportedTypeException {
                assert arg0Value_ instanceof JavaSuperAdapter : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JavaSuperAdapter arg0Value = ((JavaSuperAdapter) arg0Value_);
                int state = state_;
                if ((state & 0b10) != 0 /* is-active invokeMember(JavaSuperAdapter, String, Object[], NameCache, InteropLibrary) */) {
                    {
                        InteropLibrary invokeMemberNode__interop__ = this.receiverAdapterInteropLibrary_;
                        return arg0Value.invokeMember(arg1Value, arg2Value, this.cache, invokeMemberNode__interop__);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return invokeMemberNode_AndSpecialize(arg0Value, arg1Value, arg2Value);
            }

            private Object invokeMemberNode_AndSpecialize(JavaSuperAdapter arg0Value, String arg1Value, Object[] arg2Value) throws UnsupportedMessageException, ArityException, UnknownIdentifierException, UnsupportedTypeException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                int state = state_;
                try {
                    {
                        InteropLibrary invokeMemberNode__interop__ = null;
                        if (this.cache == null) {
                            this.cache = (NameCache.create());
                        }
                        invokeMemberNode__interop__ = this.receiverAdapterInteropLibrary_;
                        this.state_ = state = state | 0b10 /* add-active invokeMember(JavaSuperAdapter, String, Object[], NameCache, InteropLibrary) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.invokeMember(arg1Value, arg2Value, this.cache, invokeMemberNode__interop__);
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean isMemberReadable(Object arg0Value_, String arg1Value) {
                assert arg0Value_ instanceof JavaSuperAdapter : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JavaSuperAdapter arg0Value = ((JavaSuperAdapter) arg0Value_);
                int state = state_;
                if ((state & 0b100) != 0 /* is-active isMemberReadable(JavaSuperAdapter, String, NameCache, InteropLibrary) */) {
                    {
                        InteropLibrary isMemberReadableNode__interop__ = this.receiverAdapterInteropLibrary_;
                        return arg0Value.isMemberReadable(arg1Value, this.cache, isMemberReadableNode__interop__);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isMemberReadableNode_AndSpecialize(arg0Value, arg1Value);
            }

            private boolean isMemberReadableNode_AndSpecialize(JavaSuperAdapter arg0Value, String arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                int state = state_;
                try {
                    {
                        InteropLibrary isMemberReadableNode__interop__ = null;
                        if (this.cache == null) {
                            this.cache = (NameCache.create());
                        }
                        isMemberReadableNode__interop__ = this.receiverAdapterInteropLibrary_;
                        this.state_ = state = state | 0b100 /* add-active isMemberReadable(JavaSuperAdapter, String, NameCache, InteropLibrary) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.isMemberReadable(arg1Value, this.cache, isMemberReadableNode__interop__);
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean isMemberInvocable(Object arg0Value_, String arg1Value) {
                assert arg0Value_ instanceof JavaSuperAdapter : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JavaSuperAdapter arg0Value = ((JavaSuperAdapter) arg0Value_);
                int state = state_;
                if ((state & 0b1000) != 0 /* is-active isMemberInvocable(JavaSuperAdapter, String, NameCache, InteropLibrary) */) {
                    {
                        InteropLibrary isMemberInvocableNode__interop__ = this.receiverAdapterInteropLibrary_;
                        return arg0Value.isMemberInvocable(arg1Value, this.cache, isMemberInvocableNode__interop__);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isMemberInvocableNode_AndSpecialize(arg0Value, arg1Value);
            }

            private boolean isMemberInvocableNode_AndSpecialize(JavaSuperAdapter arg0Value, String arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                int state = state_;
                try {
                    {
                        InteropLibrary isMemberInvocableNode__interop__ = null;
                        if (this.cache == null) {
                            this.cache = (NameCache.create());
                        }
                        isMemberInvocableNode__interop__ = this.receiverAdapterInteropLibrary_;
                        this.state_ = state = state | 0b1000 /* add-active isMemberInvocable(JavaSuperAdapter, String, NameCache, InteropLibrary) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.isMemberInvocable(arg1Value, this.cache, isMemberInvocableNode__interop__);
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public Object getMembers(Object receiver, boolean includeInternal) throws UnsupportedMessageException {
                assert receiver instanceof JavaSuperAdapter : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((JavaSuperAdapter) receiver)).getMembers(includeInternal);
            }

        }
        @GeneratedBy(JavaSuperAdapter.class)
        private static final class Uncached extends InteropLibrary {

            Uncached() {
            }

            @TruffleBoundary
            @Override
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof JavaSuperAdapter) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof JavaSuperAdapter;
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
            public boolean hasMembers(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((JavaSuperAdapter) receiver) .hasMembers();
            }

            @TruffleBoundary
            @Override
            public Object readMember(Object arg0Value_, String arg1Value) throws UnsupportedMessageException, UnknownIdentifierException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JavaSuperAdapter arg0Value = ((JavaSuperAdapter) arg0Value_);
                return arg0Value.readMember(arg1Value, (NameCache.getUncached()), INTEROP_LIBRARY_.getUncached((arg0Value.adapter)));
            }

            @TruffleBoundary
            @Override
            public Object invokeMember(Object arg0Value_, String arg1Value, Object... arg2Value) throws UnsupportedMessageException, ArityException, UnknownIdentifierException, UnsupportedTypeException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JavaSuperAdapter arg0Value = ((JavaSuperAdapter) arg0Value_);
                return arg0Value.invokeMember(arg1Value, arg2Value, (NameCache.getUncached()), INTEROP_LIBRARY_.getUncached((arg0Value.adapter)));
            }

            @TruffleBoundary
            @Override
            public boolean isMemberReadable(Object arg0Value_, String arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JavaSuperAdapter arg0Value = ((JavaSuperAdapter) arg0Value_);
                return arg0Value.isMemberReadable(arg1Value, (NameCache.getUncached()), INTEROP_LIBRARY_.getUncached((arg0Value.adapter)));
            }

            @TruffleBoundary
            @Override
            public boolean isMemberInvocable(Object arg0Value_, String arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JavaSuperAdapter arg0Value = ((JavaSuperAdapter) arg0Value_);
                return arg0Value.isMemberInvocable(arg1Value, (NameCache.getUncached()), INTEROP_LIBRARY_.getUncached((arg0Value.adapter)));
            }

            @TruffleBoundary
            @Override
            public Object getMembers(Object receiver, boolean includeInternal) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((JavaSuperAdapter) receiver) .getMembers(includeInternal);
            }

        }
    }
}
