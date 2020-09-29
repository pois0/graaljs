// CheckStyle: start generated
package com.oracle.truffle.js.test.polyglot;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.TruffleLanguage.ContextReference;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.interop.ArityException;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.InvalidArrayIndexException;
import com.oracle.truffle.api.interop.UnknownIdentifierException;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.interop.UnsupportedTypeException;
import com.oracle.truffle.api.library.DynamicDispatchLibrary;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.utilities.TriState;
import com.oracle.truffle.js.lang.JavaScriptLanguage;
import com.oracle.truffle.js.runtime.JSRealm;
import com.oracle.truffle.js.test.polyglot.ForeignTestMap.IsIdenticalOrUndefined;
import java.util.concurrent.locks.Lock;

@GeneratedBy(ForeignTestMap.class)
@SuppressWarnings("unused")
final class ForeignTestMapGen {

    private static final LibraryFactory<DynamicDispatchLibrary> DYNAMIC_DISPATCH_LIBRARY_ = LibraryFactory.resolve(DynamicDispatchLibrary.class);

    static  {
        LibraryExport.register(ForeignTestMap.class, new InteropLibraryExports());
    }

    private ForeignTestMapGen() {
    }

    @GeneratedBy(ForeignTestMap.class)
    private static final class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        private InteropLibraryExports() {
            super(InteropLibrary.class, ForeignTestMap.class, false);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof ForeignTestMap;
            InteropLibrary uncached = new Uncached(receiver);
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof ForeignTestMap;
            return new Cached(receiver);
        }

        @GeneratedBy(ForeignTestMap.class)
        private static final class Cached extends InteropLibrary {

            private final Class<? extends ForeignTestMap> receiverClass_;
            @CompilationFinal private volatile int state_;
            @CompilationFinal private ContextReference<JSRealm> javaScriptLanguageContextReference_;

            Cached(Object originalReceiver) {
                ForeignTestMap receiver = ((ForeignTestMap) originalReceiver) ;
                this.receiverClass_ = receiver.getClass();
            }

            @Override
            public boolean accepts(Object receiver) {
                assert receiver.getClass() != this.receiverClass_ || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return receiver.getClass() == this.receiverClass_;
            }

            @Override
            protected TriState isIdenticalOrUndefined(Object arg0Value_, Object arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                ForeignTestMap arg0Value = CompilerDirectives.castExact(arg0Value_, receiverClass_);
                int state = state_;
                if ((state & 0b11) != 0 /* is-active doSLObject(ForeignTestMap, ForeignTestMap) || doOther(ForeignTestMap, Object) */) {
                    if ((state & 0b1) != 0 /* is-active doSLObject(ForeignTestMap, ForeignTestMap) */ && arg1Value instanceof ForeignTestMap) {
                        ForeignTestMap arg1Value_ = (ForeignTestMap) arg1Value;
                        return IsIdenticalOrUndefined.doSLObject(arg0Value, arg1Value_);
                    }
                    if ((state & 0b10) != 0 /* is-active doOther(ForeignTestMap, Object) */) {
                        if (isIdenticalOrUndefinedFallbackGuard_(state, arg0Value, arg1Value)) {
                            return IsIdenticalOrUndefined.doOther(arg0Value, arg1Value);
                        }
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isIdenticalOrUndefinedAndSpecialize(arg0Value, arg1Value);
            }

            private TriState isIdenticalOrUndefinedAndSpecialize(ForeignTestMap arg0Value, Object arg1Value) {
                int state = state_;
                if (arg1Value instanceof ForeignTestMap) {
                    ForeignTestMap arg1Value_ = (ForeignTestMap) arg1Value;
                    this.state_ = state = state | 0b1 /* add-active doSLObject(ForeignTestMap, ForeignTestMap) */;
                    return IsIdenticalOrUndefined.doSLObject(arg0Value, arg1Value_);
                }
                this.state_ = state = state | 0b10 /* add-active doOther(ForeignTestMap, Object) */;
                return IsIdenticalOrUndefined.doOther(arg0Value, arg1Value);
            }

            @Override
            public NodeCost getCost() {
                int state = state_;
                if ((state & 0b11) == 0b0) {
                    return NodeCost.UNINITIALIZED;
                } else if (((state & 0b11) & ((state & 0b11) - 1)) == 0 /* is-single-active  */) {
                    return NodeCost.MONOMORPHIC;
                }
                return NodeCost.POLYMORPHIC;
            }

            @Override
            public boolean isNull(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (CompilerDirectives.castExact(receiver, receiverClass_)).isNull();
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
            public void writeMember(Object receiver, String member, Object value) throws UnsupportedMessageException, UnknownIdentifierException, UnsupportedTypeException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                (CompilerDirectives.castExact(receiver, receiverClass_)).writeMember(member, value);
                return;
            }

            @Override
            public void removeMember(Object receiver, String member) throws UnsupportedMessageException, UnknownIdentifierException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                (CompilerDirectives.castExact(receiver, receiverClass_)).removeMember(member);
                return;
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
                return (CompilerDirectives.castExact(receiver, receiverClass_)).isMemberExisting(member);
            }

            @Override
            public boolean isMemberModifiable(Object receiver, String member) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (CompilerDirectives.castExact(receiver, receiverClass_)).isMemberExisting(member);
            }

            @Override
            public boolean isMemberRemovable(Object receiver, String member) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (CompilerDirectives.castExact(receiver, receiverClass_)).isMemberExisting(member);
            }

            @Override
            public boolean isMemberInsertable(Object receiver, String member) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (CompilerDirectives.castExact(receiver, receiverClass_)).isMemberInsertable(member);
            }

            @Override
            public Object getMembers(Object arg0Value_, boolean arg1Value) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                ForeignTestMap arg0Value = CompilerDirectives.castExact(arg0Value_, receiverClass_);
                int state = state_;
                if ((state & 0b100) != 0 /* is-active getMembers(ForeignTestMap, boolean, JSRealm) */) {
                    {
                        ContextReference<JSRealm> javaScriptLanguageContextReference__ = this.javaScriptLanguageContextReference_;
                        JSRealm getMembersNode__realm__ = javaScriptLanguageContextReference__.get();
                        return arg0Value.getMembers(arg1Value, getMembersNode__realm__);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return getMembersNode_AndSpecialize(arg0Value, arg1Value);
            }

            private Object getMembersNode_AndSpecialize(ForeignTestMap arg0Value, boolean arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                int state = state_;
                try {
                    {
                        JSRealm getMembersNode__realm__ = null;
                        ContextReference<JSRealm> javaScriptLanguageContextReference__1 = this.javaScriptLanguageContextReference_;
                        if (javaScriptLanguageContextReference__1 == null) {
                            this.javaScriptLanguageContextReference_ = javaScriptLanguageContextReference__1 = super.lookupContextReference(JavaScriptLanguage.class);
                        }
                        getMembersNode__realm__ = javaScriptLanguageContextReference__1.get();
                        this.state_ = state = state | 0b100 /* add-active getMembers(ForeignTestMap, boolean, JSRealm) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.getMembers(arg1Value, getMembersNode__realm__);
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean hasArrayElements(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (CompilerDirectives.castExact(receiver, receiverClass_)).hasArrayElements();
            }

            @Override
            public long getArraySize(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (CompilerDirectives.castExact(receiver, receiverClass_)).getArraySize();
            }

            @Override
            public Object readArrayElement(Object receiver, long index) throws UnsupportedMessageException, InvalidArrayIndexException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (CompilerDirectives.castExact(receiver, receiverClass_)).readArrayElement(index);
            }

            @Override
            public void writeArrayElement(Object receiver, long index, Object arg2) throws UnsupportedMessageException, UnsupportedTypeException, InvalidArrayIndexException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                (CompilerDirectives.castExact(receiver, receiverClass_)).writeArrayElement(index, arg2);
                return;
            }

            @Override
            public boolean isArrayElementModifiable(Object receiver, long index) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (CompilerDirectives.castExact(receiver, receiverClass_)).isArrayElementReadable(index);
            }

            @Override
            public boolean isArrayElementReadable(Object receiver, long index) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (CompilerDirectives.castExact(receiver, receiverClass_)).isArrayElementReadable(index);
            }

            @Override
            public boolean isArrayElementInsertable(Object receiver, long index) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (CompilerDirectives.castExact(receiver, receiverClass_)).isArrayElementInsertable(index);
            }

            @Override
            public boolean isString(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (CompilerDirectives.castExact(receiver, receiverClass_)).isString();
            }

            @Override
            public String asString(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (CompilerDirectives.castExact(receiver, receiverClass_)).asString();
            }

            @Override
            public int identityHashCode(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (CompilerDirectives.castExact(receiver, receiverClass_)).identityHashCode();
            }

            private static boolean isIdenticalOrUndefinedFallbackGuard_(int state, ForeignTestMap arg0Value, Object arg1Value) {
                if (((state & 0b1)) == 0 /* is-not-active doSLObject(ForeignTestMap, ForeignTestMap) */ && arg1Value instanceof ForeignTestMap) {
                    return false;
                }
                return true;
            }

        }
        @GeneratedBy(ForeignTestMap.class)
        private static final class Uncached extends InteropLibrary {

            private final Class<? extends ForeignTestMap> receiverClass_;
            private final ContextReference<JSRealm> javaScriptLanguageContextReference_ = lookupContextReference(JavaScriptLanguage.class);

            Uncached(Object receiver) {
                this.receiverClass_ = ((ForeignTestMap) receiver).getClass();
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
            public TriState isIdenticalOrUndefined(Object arg0Value_, Object arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                ForeignTestMap arg0Value = ((ForeignTestMap) arg0Value_);
                if (arg1Value instanceof ForeignTestMap) {
                    ForeignTestMap arg1Value_ = (ForeignTestMap) arg1Value;
                    return IsIdenticalOrUndefined.doSLObject(arg0Value, arg1Value_);
                }
                return IsIdenticalOrUndefined.doOther(arg0Value, arg1Value);
            }

            @TruffleBoundary
            @Override
            public boolean isNull(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((ForeignTestMap) receiver) .isNull();
            }

            @TruffleBoundary
            @Override
            public boolean hasMembers(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((ForeignTestMap) receiver) .hasMembers();
            }

            @TruffleBoundary
            @Override
            public Object readMember(Object receiver, String member) throws UnsupportedMessageException, UnknownIdentifierException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((ForeignTestMap) receiver) .readMember(member);
            }

            @TruffleBoundary
            @Override
            public void writeMember(Object receiver, String member, Object value) throws UnsupportedMessageException, UnknownIdentifierException, UnsupportedTypeException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                ((ForeignTestMap) receiver) .writeMember(member, value);
                return;
            }

            @TruffleBoundary
            @Override
            public void removeMember(Object receiver, String member) throws UnsupportedMessageException, UnknownIdentifierException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                ((ForeignTestMap) receiver) .removeMember(member);
                return;
            }

            @TruffleBoundary
            @Override
            public Object invokeMember(Object receiver, String member, Object... arguments) throws UnsupportedMessageException, ArityException, UnknownIdentifierException, UnsupportedTypeException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((ForeignTestMap) receiver) .invokeMember(member, arguments);
            }

            @TruffleBoundary
            @Override
            public boolean isMemberInvocable(Object receiver, String member) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((ForeignTestMap) receiver) .isMemberInvocable(member);
            }

            @TruffleBoundary
            @Override
            public boolean isMemberReadable(Object receiver, String member) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((ForeignTestMap) receiver) .isMemberExisting(member);
            }

            @TruffleBoundary
            @Override
            public boolean isMemberModifiable(Object receiver, String member) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((ForeignTestMap) receiver) .isMemberExisting(member);
            }

            @TruffleBoundary
            @Override
            public boolean isMemberRemovable(Object receiver, String member) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((ForeignTestMap) receiver) .isMemberExisting(member);
            }

            @TruffleBoundary
            @Override
            public boolean isMemberInsertable(Object receiver, String member) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((ForeignTestMap) receiver) .isMemberInsertable(member);
            }

            @TruffleBoundary
            @Override
            public Object getMembers(Object arg0Value_, boolean arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                ForeignTestMap arg0Value = ((ForeignTestMap) arg0Value_);
                return arg0Value.getMembers(arg1Value, this.javaScriptLanguageContextReference_.get());
            }

            @TruffleBoundary
            @Override
            public boolean hasArrayElements(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((ForeignTestMap) receiver) .hasArrayElements();
            }

            @TruffleBoundary
            @Override
            public long getArraySize(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((ForeignTestMap) receiver) .getArraySize();
            }

            @TruffleBoundary
            @Override
            public Object readArrayElement(Object receiver, long index) throws UnsupportedMessageException, InvalidArrayIndexException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((ForeignTestMap) receiver) .readArrayElement(index);
            }

            @TruffleBoundary
            @Override
            public void writeArrayElement(Object receiver, long index, Object arg2) throws UnsupportedMessageException, UnsupportedTypeException, InvalidArrayIndexException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                ((ForeignTestMap) receiver) .writeArrayElement(index, arg2);
                return;
            }

            @TruffleBoundary
            @Override
            public boolean isArrayElementModifiable(Object receiver, long index) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((ForeignTestMap) receiver) .isArrayElementReadable(index);
            }

            @TruffleBoundary
            @Override
            public boolean isArrayElementReadable(Object receiver, long index) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((ForeignTestMap) receiver) .isArrayElementReadable(index);
            }

            @TruffleBoundary
            @Override
            public boolean isArrayElementInsertable(Object receiver, long index) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((ForeignTestMap) receiver) .isArrayElementInsertable(index);
            }

            @TruffleBoundary
            @Override
            public boolean isString(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((ForeignTestMap) receiver) .isString();
            }

            @TruffleBoundary
            @Override
            public String asString(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((ForeignTestMap) receiver) .asString();
            }

            @TruffleBoundary
            @Override
            public int identityHashCode(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((ForeignTestMap) receiver) .identityHashCode();
            }

        }
    }
}
