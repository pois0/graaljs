// CheckStyle: start generated
package com.oracle.truffle.js.runtime.objects;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.UnknownIdentifierException;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.interop.UnsupportedTypeException;
import com.oracle.truffle.api.library.DynamicDispatchLibrary;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObjectLibrary;
import com.oracle.truffle.js.runtime.objects.JSScope.DynamicScopeWrapper;

@GeneratedBy(DynamicScopeWrapper.class)
final class DynamicScopeWrapperGen {

    private static final LibraryFactory<DynamicDispatchLibrary> DYNAMIC_DISPATCH_LIBRARY_ = LibraryFactory.resolve(DynamicDispatchLibrary.class);
    private static final LibraryFactory<DynamicObjectLibrary> DYNAMIC_OBJECT_LIBRARY_ = LibraryFactory.resolve(DynamicObjectLibrary.class);

    static  {
        LibraryExport.register(DynamicScopeWrapper.class, new InteropLibraryExports());
    }

    private DynamicScopeWrapperGen() {
    }

    @GeneratedBy(DynamicScopeWrapper.class)
    private static final class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        private static final Uncached UNCACHED = new Uncached();

        private InteropLibraryExports() {
            super(InteropLibrary.class, DynamicScopeWrapper.class, false);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof DynamicScopeWrapper;
            InteropLibrary uncached = InteropLibraryExports.UNCACHED;
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof DynamicScopeWrapper;
            return new Cached(receiver);
        }

        @GeneratedBy(DynamicScopeWrapper.class)
        private static final class Cached extends InteropLibrary {

            @Child private DynamicObjectLibrary receiverScopeDynamicObjectLibrary_;

            Cached(Object originalReceiver) {
                DynamicScopeWrapper receiver = ((DynamicScopeWrapper) originalReceiver) ;
                this.receiverScopeDynamicObjectLibrary_ = super.insert(DYNAMIC_OBJECT_LIBRARY_.create((receiver.scope)));
            }

            @Override
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof DynamicScopeWrapper) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                if (!(receiver instanceof DynamicScopeWrapper)) {
                    return false;
                } else if (!this.receiverScopeDynamicObjectLibrary_.accepts((((DynamicScopeWrapper) receiver).scope))) {
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public boolean hasMembers(Object receiver) {
                assert receiver instanceof DynamicScopeWrapper : "Invalid library usage. Library does not accept given receiver.";
                return (((DynamicScopeWrapper) receiver)).hasMembers();
            }

            @Override
            public Object getMembers(Object arg0Value_, boolean arg1Value) throws UnsupportedMessageException {
                assert arg0Value_ instanceof DynamicScopeWrapper : "Invalid library usage. Library does not accept given receiver.";
                DynamicScopeWrapper arg0Value = ((DynamicScopeWrapper) arg0Value_);
                {
                    DynamicObjectLibrary getMembersNode__access__ = this.receiverScopeDynamicObjectLibrary_;
                    return arg0Value.getMembers(arg1Value, getMembersNode__access__);
                }
            }

            @Override
            public NodeCost getCost() {
                return NodeCost.MONOMORPHIC;
            }

            @Override
            public boolean isMemberReadable(Object arg0Value_, String arg1Value) {
                assert arg0Value_ instanceof DynamicScopeWrapper : "Invalid library usage. Library does not accept given receiver.";
                DynamicScopeWrapper arg0Value = ((DynamicScopeWrapper) arg0Value_);
                {
                    DynamicObjectLibrary isMemberReadableNode__access__ = this.receiverScopeDynamicObjectLibrary_;
                    return arg0Value.isMemberReadable(arg1Value, isMemberReadableNode__access__);
                }
            }

            @Override
            public boolean isMemberModifiable(Object arg0Value_, String arg1Value) {
                assert arg0Value_ instanceof DynamicScopeWrapper : "Invalid library usage. Library does not accept given receiver.";
                DynamicScopeWrapper arg0Value = ((DynamicScopeWrapper) arg0Value_);
                {
                    DynamicObjectLibrary isMemberModifiableNode__access__ = this.receiverScopeDynamicObjectLibrary_;
                    return arg0Value.isMemberModifiable(arg1Value, isMemberModifiableNode__access__);
                }
            }

            @Override
            public boolean isMemberInsertable(Object receiver, String member) {
                assert receiver instanceof DynamicScopeWrapper : "Invalid library usage. Library does not accept given receiver.";
                return (((DynamicScopeWrapper) receiver)).isMemberInsertable(member);
            }

            @Override
            public Object readMember(Object arg0Value_, String arg1Value) throws UnsupportedMessageException, UnknownIdentifierException {
                assert arg0Value_ instanceof DynamicScopeWrapper : "Invalid library usage. Library does not accept given receiver.";
                DynamicScopeWrapper arg0Value = ((DynamicScopeWrapper) arg0Value_);
                {
                    DynamicObjectLibrary readMemberNode__access__ = this.receiverScopeDynamicObjectLibrary_;
                    return arg0Value.readMember(arg1Value, readMemberNode__access__);
                }
            }

            @Override
            public void writeMember(Object arg0Value_, String arg1Value, Object arg2Value) throws UnsupportedMessageException, UnknownIdentifierException, UnsupportedTypeException {
                assert arg0Value_ instanceof DynamicScopeWrapper : "Invalid library usage. Library does not accept given receiver.";
                DynamicScopeWrapper arg0Value = ((DynamicScopeWrapper) arg0Value_);
                {
                    DynamicObjectLibrary writeMemberNode__access__ = this.receiverScopeDynamicObjectLibrary_;
                    arg0Value.writeMember(arg1Value, arg2Value, writeMemberNode__access__);
                    return;
                }
            }

        }
        @GeneratedBy(DynamicScopeWrapper.class)
        private static final class Uncached extends InteropLibrary {

            Uncached() {
            }

            @TruffleBoundary
            @Override
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof DynamicScopeWrapper) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof DynamicScopeWrapper;
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
                return ((DynamicScopeWrapper) receiver) .hasMembers();
            }

            @TruffleBoundary
            @Override
            public Object getMembers(Object arg0Value_, boolean arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                DynamicScopeWrapper arg0Value = ((DynamicScopeWrapper) arg0Value_);
                return arg0Value.getMembers(arg1Value, DYNAMIC_OBJECT_LIBRARY_.getUncached((arg0Value.scope)));
            }

            @TruffleBoundary
            @Override
            public boolean isMemberReadable(Object arg0Value_, String arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                DynamicScopeWrapper arg0Value = ((DynamicScopeWrapper) arg0Value_);
                return arg0Value.isMemberReadable(arg1Value, DYNAMIC_OBJECT_LIBRARY_.getUncached((arg0Value.scope)));
            }

            @TruffleBoundary
            @Override
            public boolean isMemberModifiable(Object arg0Value_, String arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                DynamicScopeWrapper arg0Value = ((DynamicScopeWrapper) arg0Value_);
                return arg0Value.isMemberModifiable(arg1Value, DYNAMIC_OBJECT_LIBRARY_.getUncached((arg0Value.scope)));
            }

            @TruffleBoundary
            @Override
            public boolean isMemberInsertable(Object receiver, String member) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((DynamicScopeWrapper) receiver) .isMemberInsertable(member);
            }

            @TruffleBoundary
            @Override
            public Object readMember(Object arg0Value_, String arg1Value) throws UnknownIdentifierException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                DynamicScopeWrapper arg0Value = ((DynamicScopeWrapper) arg0Value_);
                return arg0Value.readMember(arg1Value, DYNAMIC_OBJECT_LIBRARY_.getUncached((arg0Value.scope)));
            }

            @TruffleBoundary
            @Override
            public void writeMember(Object arg0Value_, String arg1Value, Object arg2Value) throws UnsupportedMessageException, UnknownIdentifierException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                DynamicScopeWrapper arg0Value = ((DynamicScopeWrapper) arg0Value_);
                arg0Value.writeMember(arg1Value, arg2Value, DYNAMIC_OBJECT_LIBRARY_.getUncached((arg0Value.scope)));
                return;
            }

        }
    }
}
