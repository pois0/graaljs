// CheckStyle: start generated
package com.oracle.truffle.js.test.interop;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.TruffleLanguage.ContextReference;
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
import com.oracle.truffle.js.lang.JavaScriptLanguage;
import com.oracle.truffle.js.runtime.JSRealm;
import com.oracle.truffle.js.test.interop.JSONStringifyInteropTest.InvocableMemberObject;
import java.util.concurrent.locks.Lock;

@GeneratedBy(InvocableMemberObject.class)
final class InvocableMemberObjectGen {

    private static final LibraryFactory<DynamicDispatchLibrary> DYNAMIC_DISPATCH_LIBRARY_ = LibraryFactory.resolve(DynamicDispatchLibrary.class);

    static  {
        LibraryExport.register(InvocableMemberObject.class, new InteropLibraryExports());
    }

    private InvocableMemberObjectGen() {
    }

    @GeneratedBy(InvocableMemberObject.class)
    private static final class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        private InteropLibraryExports() {
            super(InteropLibrary.class, InvocableMemberObject.class, false);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof InvocableMemberObject;
            InteropLibrary uncached = new Uncached(receiver);
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof InvocableMemberObject;
            return new Cached(receiver);
        }

        @GeneratedBy(InvocableMemberObject.class)
        private static final class Cached extends InteropLibrary {

            private final Class<? extends InvocableMemberObject> receiverClass_;
            @CompilationFinal private volatile int state_;
            @CompilationFinal private ContextReference<JSRealm> javaScriptLanguageContextReference_;

            Cached(Object originalReceiver) {
                InvocableMemberObject receiver = ((InvocableMemberObject) originalReceiver) ;
                this.receiverClass_ = receiver.getClass();
            }

            @Override
            public boolean accepts(Object receiver) {
                assert receiver.getClass() != this.receiverClass_ || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return receiver.getClass() == this.receiverClass_;
            }

            @Override
            public boolean hasMembers(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (CompilerDirectives.castExact(receiver, receiverClass_)).hasMembers();
            }

            @Override
            public Object readMember(Object receiver, String member) throws UnsupportedMessageException, UnknownIdentifierException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (CompilerDirectives.castExact(receiver, receiverClass_)).readMember(member);
            }

            @Override
            public Object invokeMember(Object receiver, String member, Object... arguments) throws UnsupportedMessageException, ArityException, UnknownIdentifierException, UnsupportedTypeException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (CompilerDirectives.castExact(receiver, receiverClass_)).invokeMember(member, arguments);
            }

            @Override
            public boolean isMemberInvocable(Object receiver, String member) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (CompilerDirectives.castExact(receiver, receiverClass_)).isMemberInvocable(member);
            }

            @Override
            public boolean isMemberReadable(Object receiver, String member) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (CompilerDirectives.castExact(receiver, receiverClass_)).isMemberReadable(member);
            }

            @Override
            public Object getMembers(Object arg0Value_, boolean arg1Value) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                InvocableMemberObject arg0Value = CompilerDirectives.castExact(arg0Value_, receiverClass_);
                int state = state_;
                if (state != 0 /* is-active getMembers(InvocableMemberObject, boolean, JSRealm) */) {
                    {
                        ContextReference<JSRealm> javaScriptLanguageContextReference__ = this.javaScriptLanguageContextReference_;
                        JSRealm realm__ = javaScriptLanguageContextReference__.get();
                        return arg0Value.getMembers(arg1Value, realm__);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return executeAndSpecialize(arg0Value, arg1Value);
            }

            private Object executeAndSpecialize(InvocableMemberObject arg0Value, boolean arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                int state = state_;
                try {
                    {
                        JSRealm realm__ = null;
                        ContextReference<JSRealm> javaScriptLanguageContextReference__1 = this.javaScriptLanguageContextReference_;
                        if (javaScriptLanguageContextReference__1 == null) {
                            this.javaScriptLanguageContextReference_ = javaScriptLanguageContextReference__1 = super.lookupContextReference(JavaScriptLanguage.class);
                        }
                        realm__ = javaScriptLanguageContextReference__1.get();
                        this.state_ = state = state | 0b1 /* add-active getMembers(InvocableMemberObject, boolean, JSRealm) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.getMembers(arg1Value, realm__);
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
                } else {
                    return NodeCost.MONOMORPHIC;
                }
            }

        }
        @GeneratedBy(InvocableMemberObject.class)
        private static final class Uncached extends InteropLibrary {

            private final Class<? extends InvocableMemberObject> receiverClass_;
            private final ContextReference<JSRealm> javaScriptLanguageContextReference_ = lookupContextReference(JavaScriptLanguage.class);

            Uncached(Object receiver) {
                this.receiverClass_ = ((InvocableMemberObject) receiver).getClass();
            }

            @TruffleBoundary
            @Override
            public boolean accepts(Object receiver) {
                assert receiver.getClass() != this.receiverClass_ || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return receiver.getClass() == this.receiverClass_;
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
                return ((InvocableMemberObject) receiver) .hasMembers();
            }

            @TruffleBoundary
            @Override
            public Object readMember(Object receiver, String member) throws UnsupportedMessageException, UnknownIdentifierException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((InvocableMemberObject) receiver) .readMember(member);
            }

            @TruffleBoundary
            @Override
            public Object invokeMember(Object receiver, String member, Object... arguments) throws UnsupportedMessageException, ArityException, UnknownIdentifierException, UnsupportedTypeException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((InvocableMemberObject) receiver) .invokeMember(member, arguments);
            }

            @TruffleBoundary
            @Override
            public boolean isMemberInvocable(Object receiver, String member) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((InvocableMemberObject) receiver) .isMemberInvocable(member);
            }

            @TruffleBoundary
            @Override
            public boolean isMemberReadable(Object receiver, String member) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((InvocableMemberObject) receiver) .isMemberReadable(member);
            }

            @TruffleBoundary
            @Override
            public Object getMembers(Object arg0Value_, boolean arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                InvocableMemberObject arg0Value = ((InvocableMemberObject) arg0Value_);
                return arg0Value.getMembers(arg1Value, this.javaScriptLanguageContextReference_.get());
            }

        }
    }
}
