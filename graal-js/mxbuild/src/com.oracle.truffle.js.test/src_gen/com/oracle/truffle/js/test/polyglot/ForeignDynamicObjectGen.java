// CheckStyle: start generated
package com.oracle.truffle.js.test.polyglot;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.library.DynamicDispatchLibrary;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;

@GeneratedBy(ForeignDynamicObject.class)
final class ForeignDynamicObjectGen {

    private static final LibraryFactory<DynamicDispatchLibrary> DYNAMIC_DISPATCH_LIBRARY_ = LibraryFactory.resolve(DynamicDispatchLibrary.class);

    static  {
        LibraryExport.register(ForeignDynamicObject.class, new InteropLibraryExports());
    }

    private ForeignDynamicObjectGen() {
    }

    @GeneratedBy(ForeignDynamicObject.class)
    private static final class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        private InteropLibraryExports() {
            super(InteropLibrary.class, DynamicObject.class, false);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof DynamicObject;
            InteropLibrary uncached = new Uncached(receiver);
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof DynamicObject;
            return new Cached(receiver);
        }

        @GeneratedBy(ForeignDynamicObject.class)
        private static final class Cached extends InteropLibrary {

            @Child private DynamicDispatchLibrary dynamicDispatch_;

            Cached(Object originalReceiver) {
                DynamicObject receiver = ((DynamicObject) originalReceiver) ;
                this.dynamicDispatch_ = insert(DYNAMIC_DISPATCH_LIBRARY_.create(receiver));
            }

            @Override
            public boolean accepts(Object receiver) {
                return dynamicDispatch_.accepts(receiver) && dynamicDispatch_.dispatch(receiver) == ForeignDynamicObject.class;
            }

            @Override
            public Object toDisplayString(Object receiver, boolean allowSideEffects) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ForeignDynamicObject.toDisplayString(((DynamicObject) dynamicDispatch_.cast(receiver)), allowSideEffects);
            }

        }
        @GeneratedBy(ForeignDynamicObject.class)
        private static final class Uncached extends InteropLibrary {

            @Child private DynamicDispatchLibrary dynamicDispatch_;

            Uncached(Object receiver) {
                this.dynamicDispatch_ = DYNAMIC_DISPATCH_LIBRARY_.getUncached(receiver);
            }

            @TruffleBoundary
            @Override
            public boolean accepts(Object receiver) {
                return dynamicDispatch_.accepts(receiver) && dynamicDispatch_.dispatch(receiver) == ForeignDynamicObject.class;
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
            public Object toDisplayString(Object receiver, boolean allowSideEffects) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ForeignDynamicObject.toDisplayString(((DynamicObject) receiver) , allowSideEffects);
            }

        }
    }
}
