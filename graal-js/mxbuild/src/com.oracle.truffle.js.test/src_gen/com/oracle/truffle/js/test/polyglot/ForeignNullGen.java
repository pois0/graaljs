// CheckStyle: start generated
package com.oracle.truffle.js.test.polyglot;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.library.DynamicDispatchLibrary;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.utilities.TriState;
import com.oracle.truffle.js.test.polyglot.ForeignNull.IsIdenticalOrUndefined;

@GeneratedBy(ForeignNull.class)
@SuppressWarnings("unused")
final class ForeignNullGen {

    private static final LibraryFactory<DynamicDispatchLibrary> DYNAMIC_DISPATCH_LIBRARY_ = LibraryFactory.resolve(DynamicDispatchLibrary.class);

    static  {
        LibraryExport.register(ForeignNull.class, new InteropLibraryExports());
    }

    private ForeignNullGen() {
    }

    @GeneratedBy(ForeignNull.class)
    private static final class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        private InteropLibraryExports() {
            super(InteropLibrary.class, ForeignNull.class, false);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof ForeignNull;
            InteropLibrary uncached = new Uncached(receiver);
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof ForeignNull;
            return new Cached(receiver);
        }

        @GeneratedBy(ForeignNull.class)
        private static final class Cached extends InteropLibrary {

            private final Class<? extends ForeignNull> receiverClass_;
            @CompilationFinal private int state_;

            Cached(Object originalReceiver) {
                ForeignNull receiver = ((ForeignNull) originalReceiver) ;
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
                ForeignNull arg0Value = CompilerDirectives.castExact(arg0Value_, receiverClass_);
                int state = state_;
                if (state != 0 /* is-active doMyObject(ForeignNull, ForeignNull) || doOther(ForeignNull, Object) */) {
                    if ((state & 0b1) != 0 /* is-active doMyObject(ForeignNull, ForeignNull) */ && arg1Value instanceof ForeignNull) {
                        ForeignNull arg1Value_ = (ForeignNull) arg1Value;
                        return IsIdenticalOrUndefined.doMyObject(arg0Value, arg1Value_);
                    }
                    if ((state & 0b10) != 0 /* is-active doOther(ForeignNull, Object) */) {
                        if (fallbackGuard_(state, arg0Value, arg1Value)) {
                            return IsIdenticalOrUndefined.doOther(arg0Value, arg1Value);
                        }
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return executeAndSpecialize(arg0Value, arg1Value);
            }

            private TriState executeAndSpecialize(ForeignNull arg0Value, Object arg1Value) {
                int state = state_;
                if (arg1Value instanceof ForeignNull) {
                    ForeignNull arg1Value_ = (ForeignNull) arg1Value;
                    this.state_ = state = state | 0b1 /* add-active doMyObject(ForeignNull, ForeignNull) */;
                    return IsIdenticalOrUndefined.doMyObject(arg0Value, arg1Value_);
                }
                this.state_ = state = state | 0b10 /* add-active doOther(ForeignNull, Object) */;
                return IsIdenticalOrUndefined.doOther(arg0Value, arg1Value);
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
            public boolean isNull(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (CompilerDirectives.castExact(receiver, receiverClass_)).isNull();
            }

            @Override
            public int identityHashCode(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (CompilerDirectives.castExact(receiver, receiverClass_)).identityHashCode();
            }

            private static boolean fallbackGuard_(int state, ForeignNull arg0Value, Object arg1Value) {
                if (((state & 0b1)) == 0 /* is-not-active doMyObject(ForeignNull, ForeignNull) */ && arg1Value instanceof ForeignNull) {
                    return false;
                }
                return true;
            }

        }
        @GeneratedBy(ForeignNull.class)
        private static final class Uncached extends InteropLibrary {

            private final Class<? extends ForeignNull> receiverClass_;

            Uncached(Object receiver) {
                this.receiverClass_ = ((ForeignNull) receiver).getClass();
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
                ForeignNull arg0Value = ((ForeignNull) arg0Value_);
                if (arg1Value instanceof ForeignNull) {
                    ForeignNull arg1Value_ = (ForeignNull) arg1Value;
                    return IsIdenticalOrUndefined.doMyObject(arg0Value, arg1Value_);
                }
                return IsIdenticalOrUndefined.doOther(arg0Value, arg1Value);
            }

            @TruffleBoundary
            @Override
            public boolean isNull(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((ForeignNull) receiver) .isNull();
            }

            @TruffleBoundary
            @Override
            public int identityHashCode(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((ForeignNull) receiver) .identityHashCode();
            }

        }
    }
}
