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
import com.oracle.truffle.api.object.DynamicObject;
import java.util.concurrent.locks.Lock;

@GeneratedBy(ForeignBoxedObject.class)
final class ForeignBoxedObjectGen {

    private static final LibraryFactory<DynamicDispatchLibrary> DYNAMIC_DISPATCH_LIBRARY_ = LibraryFactory.resolve(DynamicDispatchLibrary.class);
    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    static  {
        LibraryExport.register(ForeignBoxedObject.class, new InteropLibraryExports());
    }

    private ForeignBoxedObjectGen() {
    }

    @GeneratedBy(ForeignBoxedObject.class)
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

        @GeneratedBy(ForeignBoxedObject.class)
        private static final class Cached extends InteropLibrary {

            @Child private DynamicDispatchLibrary dynamicDispatch_;
            @CompilationFinal private volatile int state_;
            @Child private InteropLibrary isNumberNode__interop_;
            @Child private InteropLibrary fitsInByteNode__interop_;
            @Child private InteropLibrary fitsInShortNode__interop_;
            @Child private InteropLibrary fitsInIntNode__interop_;
            @Child private InteropLibrary fitsInLongNode__interop_;
            @Child private InteropLibrary fitsInFloatNode__interop_;
            @Child private InteropLibrary fitsInDoubleNode__interop_;
            @Child private InteropLibrary asByteNode__interop_;
            @Child private InteropLibrary asShortNode__interop_;
            @Child private InteropLibrary asIntNode__interop_;
            @Child private InteropLibrary asLongNode__interop_;
            @Child private InteropLibrary asFloatNode__interop_;
            @Child private InteropLibrary asDoubleNode__interop_;

            Cached(Object originalReceiver) {
                DynamicObject receiver = ((DynamicObject) originalReceiver) ;
                this.dynamicDispatch_ = insert(DYNAMIC_DISPATCH_LIBRARY_.create(receiver));
            }

            @Override
            public boolean accepts(Object receiver) {
                return dynamicDispatch_.accepts(receiver) && dynamicDispatch_.dispatch(receiver) == ForeignBoxedObject.class;
            }

            @Override
            public boolean isBoolean(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return ForeignBoxedObject.isBoolean(((DynamicObject) dynamicDispatch_.cast(receiver)));
            }

            @Override
            public boolean asBoolean(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return ForeignBoxedObject.asBoolean(((DynamicObject) dynamicDispatch_.cast(receiver)));
            }

            @Override
            public boolean isString(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return ForeignBoxedObject.isString(((DynamicObject) dynamicDispatch_.cast(receiver)));
            }

            @Override
            public String asString(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return ForeignBoxedObject.asString(((DynamicObject) dynamicDispatch_.cast(receiver)));
            }

            @Override
            public boolean isNumber(Object arg0Value_) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                DynamicObject arg0Value = (DynamicObject) dynamicDispatch_.cast(arg0Value_);
                int state = state_;
                if ((state & 0b1) != 0 /* is-active isNumber(DynamicObject, InteropLibrary) */) {
                    return ForeignBoxedObject.isNumber(arg0Value, this.isNumberNode__interop_);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isNumberNode_AndSpecialize(arg0Value);
            }

            private boolean isNumberNode_AndSpecialize(DynamicObject arg0Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                int state = state_;
                try {
                    this.isNumberNode__interop_ = super.insert((INTEROP_LIBRARY_.createDispatched(1)));
                    this.state_ = state = state | 0b1 /* add-active isNumber(DynamicObject, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return ForeignBoxedObject.isNumber(arg0Value, this.isNumberNode__interop_);
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
            public boolean fitsInByte(Object arg0Value_) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                DynamicObject arg0Value = (DynamicObject) dynamicDispatch_.cast(arg0Value_);
                int state = state_;
                if ((state & 0b10) != 0 /* is-active fitsInByte(DynamicObject, InteropLibrary) */) {
                    return ForeignBoxedObject.fitsInByte(arg0Value, this.fitsInByteNode__interop_);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return fitsInByteNode_AndSpecialize(arg0Value);
            }

            private boolean fitsInByteNode_AndSpecialize(DynamicObject arg0Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                int state = state_;
                try {
                    this.fitsInByteNode__interop_ = super.insert((INTEROP_LIBRARY_.createDispatched(1)));
                    this.state_ = state = state | 0b10 /* add-active fitsInByte(DynamicObject, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return ForeignBoxedObject.fitsInByte(arg0Value, this.fitsInByteNode__interop_);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean fitsInShort(Object arg0Value_) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                DynamicObject arg0Value = (DynamicObject) dynamicDispatch_.cast(arg0Value_);
                int state = state_;
                if ((state & 0b100) != 0 /* is-active fitsInShort(DynamicObject, InteropLibrary) */) {
                    return ForeignBoxedObject.fitsInShort(arg0Value, this.fitsInShortNode__interop_);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return fitsInShortNode_AndSpecialize(arg0Value);
            }

            private boolean fitsInShortNode_AndSpecialize(DynamicObject arg0Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                int state = state_;
                try {
                    this.fitsInShortNode__interop_ = super.insert((INTEROP_LIBRARY_.createDispatched(1)));
                    this.state_ = state = state | 0b100 /* add-active fitsInShort(DynamicObject, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return ForeignBoxedObject.fitsInShort(arg0Value, this.fitsInShortNode__interop_);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean fitsInInt(Object arg0Value_) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                DynamicObject arg0Value = (DynamicObject) dynamicDispatch_.cast(arg0Value_);
                int state = state_;
                if ((state & 0b1000) != 0 /* is-active fitsInInt(DynamicObject, InteropLibrary) */) {
                    return ForeignBoxedObject.fitsInInt(arg0Value, this.fitsInIntNode__interop_);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return fitsInIntNode_AndSpecialize(arg0Value);
            }

            private boolean fitsInIntNode_AndSpecialize(DynamicObject arg0Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                int state = state_;
                try {
                    this.fitsInIntNode__interop_ = super.insert((INTEROP_LIBRARY_.createDispatched(1)));
                    this.state_ = state = state | 0b1000 /* add-active fitsInInt(DynamicObject, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return ForeignBoxedObject.fitsInInt(arg0Value, this.fitsInIntNode__interop_);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean fitsInLong(Object arg0Value_) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                DynamicObject arg0Value = (DynamicObject) dynamicDispatch_.cast(arg0Value_);
                int state = state_;
                if ((state & 0b10000) != 0 /* is-active fitsInLong(DynamicObject, InteropLibrary) */) {
                    return ForeignBoxedObject.fitsInLong(arg0Value, this.fitsInLongNode__interop_);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return fitsInLongNode_AndSpecialize(arg0Value);
            }

            private boolean fitsInLongNode_AndSpecialize(DynamicObject arg0Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                int state = state_;
                try {
                    this.fitsInLongNode__interop_ = super.insert((INTEROP_LIBRARY_.createDispatched(1)));
                    this.state_ = state = state | 0b10000 /* add-active fitsInLong(DynamicObject, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return ForeignBoxedObject.fitsInLong(arg0Value, this.fitsInLongNode__interop_);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean fitsInFloat(Object arg0Value_) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                DynamicObject arg0Value = (DynamicObject) dynamicDispatch_.cast(arg0Value_);
                int state = state_;
                if ((state & 0b100000) != 0 /* is-active fitsInFloat(DynamicObject, InteropLibrary) */) {
                    return ForeignBoxedObject.fitsInFloat(arg0Value, this.fitsInFloatNode__interop_);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return fitsInFloatNode_AndSpecialize(arg0Value);
            }

            private boolean fitsInFloatNode_AndSpecialize(DynamicObject arg0Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                int state = state_;
                try {
                    this.fitsInFloatNode__interop_ = super.insert((INTEROP_LIBRARY_.createDispatched(1)));
                    this.state_ = state = state | 0b100000 /* add-active fitsInFloat(DynamicObject, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return ForeignBoxedObject.fitsInFloat(arg0Value, this.fitsInFloatNode__interop_);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean fitsInDouble(Object arg0Value_) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                DynamicObject arg0Value = (DynamicObject) dynamicDispatch_.cast(arg0Value_);
                int state = state_;
                if ((state & 0b1000000) != 0 /* is-active fitsInDouble(DynamicObject, InteropLibrary) */) {
                    return ForeignBoxedObject.fitsInDouble(arg0Value, this.fitsInDoubleNode__interop_);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return fitsInDoubleNode_AndSpecialize(arg0Value);
            }

            private boolean fitsInDoubleNode_AndSpecialize(DynamicObject arg0Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                int state = state_;
                try {
                    this.fitsInDoubleNode__interop_ = super.insert((INTEROP_LIBRARY_.createDispatched(1)));
                    this.state_ = state = state | 0b1000000 /* add-active fitsInDouble(DynamicObject, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return ForeignBoxedObject.fitsInDouble(arg0Value, this.fitsInDoubleNode__interop_);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public byte asByte(Object arg0Value_) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                DynamicObject arg0Value = (DynamicObject) dynamicDispatch_.cast(arg0Value_);
                int state = state_;
                if ((state & 0b10000000) != 0 /* is-active asByte(DynamicObject, InteropLibrary) */) {
                    return ForeignBoxedObject.asByte(arg0Value, this.asByteNode__interop_);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return asByteNode_AndSpecialize(arg0Value);
            }

            private byte asByteNode_AndSpecialize(DynamicObject arg0Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                int state = state_;
                try {
                    this.asByteNode__interop_ = super.insert((INTEROP_LIBRARY_.createDispatched(1)));
                    this.state_ = state = state | 0b10000000 /* add-active asByte(DynamicObject, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return ForeignBoxedObject.asByte(arg0Value, this.asByteNode__interop_);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public short asShort(Object arg0Value_) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                DynamicObject arg0Value = (DynamicObject) dynamicDispatch_.cast(arg0Value_);
                int state = state_;
                if ((state & 0b100000000) != 0 /* is-active asShort(DynamicObject, InteropLibrary) */) {
                    return ForeignBoxedObject.asShort(arg0Value, this.asShortNode__interop_);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return asShortNode_AndSpecialize(arg0Value);
            }

            private short asShortNode_AndSpecialize(DynamicObject arg0Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                int state = state_;
                try {
                    this.asShortNode__interop_ = super.insert((INTEROP_LIBRARY_.createDispatched(1)));
                    this.state_ = state = state | 0b100000000 /* add-active asShort(DynamicObject, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return ForeignBoxedObject.asShort(arg0Value, this.asShortNode__interop_);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public int asInt(Object arg0Value_) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                DynamicObject arg0Value = (DynamicObject) dynamicDispatch_.cast(arg0Value_);
                int state = state_;
                if ((state & 0b1000000000) != 0 /* is-active asInt(DynamicObject, InteropLibrary) */) {
                    return ForeignBoxedObject.asInt(arg0Value, this.asIntNode__interop_);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return asIntNode_AndSpecialize(arg0Value);
            }

            private int asIntNode_AndSpecialize(DynamicObject arg0Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                int state = state_;
                try {
                    this.asIntNode__interop_ = super.insert((INTEROP_LIBRARY_.createDispatched(1)));
                    this.state_ = state = state | 0b1000000000 /* add-active asInt(DynamicObject, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return ForeignBoxedObject.asInt(arg0Value, this.asIntNode__interop_);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public long asLong(Object arg0Value_) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                DynamicObject arg0Value = (DynamicObject) dynamicDispatch_.cast(arg0Value_);
                int state = state_;
                if ((state & 0b10000000000) != 0 /* is-active asLong(DynamicObject, InteropLibrary) */) {
                    return ForeignBoxedObject.asLong(arg0Value, this.asLongNode__interop_);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return asLongNode_AndSpecialize(arg0Value);
            }

            private long asLongNode_AndSpecialize(DynamicObject arg0Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                int state = state_;
                try {
                    this.asLongNode__interop_ = super.insert((INTEROP_LIBRARY_.createDispatched(1)));
                    this.state_ = state = state | 0b10000000000 /* add-active asLong(DynamicObject, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return ForeignBoxedObject.asLong(arg0Value, this.asLongNode__interop_);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public float asFloat(Object arg0Value_) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                DynamicObject arg0Value = (DynamicObject) dynamicDispatch_.cast(arg0Value_);
                int state = state_;
                if ((state & 0b100000000000) != 0 /* is-active asFloat(DynamicObject, InteropLibrary) */) {
                    return ForeignBoxedObject.asFloat(arg0Value, this.asFloatNode__interop_);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return asFloatNode_AndSpecialize(arg0Value);
            }

            private float asFloatNode_AndSpecialize(DynamicObject arg0Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                int state = state_;
                try {
                    this.asFloatNode__interop_ = super.insert((INTEROP_LIBRARY_.createDispatched(1)));
                    this.state_ = state = state | 0b100000000000 /* add-active asFloat(DynamicObject, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return ForeignBoxedObject.asFloat(arg0Value, this.asFloatNode__interop_);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public double asDouble(Object arg0Value_) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                DynamicObject arg0Value = (DynamicObject) dynamicDispatch_.cast(arg0Value_);
                int state = state_;
                if ((state & 0b1000000000000) != 0 /* is-active asDouble(DynamicObject, InteropLibrary) */) {
                    return ForeignBoxedObject.asDouble(arg0Value, this.asDoubleNode__interop_);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return asDoubleNode_AndSpecialize(arg0Value);
            }

            private double asDoubleNode_AndSpecialize(DynamicObject arg0Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                int state = state_;
                try {
                    this.asDoubleNode__interop_ = super.insert((INTEROP_LIBRARY_.createDispatched(1)));
                    this.state_ = state = state | 0b1000000000000 /* add-active asDouble(DynamicObject, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return ForeignBoxedObject.asDouble(arg0Value, this.asDoubleNode__interop_);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

        }
        @GeneratedBy(ForeignBoxedObject.class)
        private static final class Uncached extends InteropLibrary {

            @Child private DynamicDispatchLibrary dynamicDispatch_;

            Uncached(Object receiver) {
                this.dynamicDispatch_ = DYNAMIC_DISPATCH_LIBRARY_.getUncached(receiver);
            }

            @TruffleBoundary
            @Override
            public boolean accepts(Object receiver) {
                return dynamicDispatch_.accepts(receiver) && dynamicDispatch_.dispatch(receiver) == ForeignBoxedObject.class;
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
            public boolean isBoolean(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ForeignBoxedObject.isBoolean(((DynamicObject) receiver) );
            }

            @TruffleBoundary
            @Override
            public boolean asBoolean(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ForeignBoxedObject.asBoolean(((DynamicObject) receiver) );
            }

            @TruffleBoundary
            @Override
            public boolean isString(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ForeignBoxedObject.isString(((DynamicObject) receiver) );
            }

            @TruffleBoundary
            @Override
            public String asString(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ForeignBoxedObject.asString(((DynamicObject) receiver) );
            }

            @TruffleBoundary
            @Override
            public boolean isNumber(Object arg0Value_) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                DynamicObject arg0Value = ((DynamicObject) arg0Value_);
                return ForeignBoxedObject.isNumber(arg0Value, (INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean fitsInByte(Object arg0Value_) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                DynamicObject arg0Value = ((DynamicObject) arg0Value_);
                return ForeignBoxedObject.fitsInByte(arg0Value, (INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean fitsInShort(Object arg0Value_) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                DynamicObject arg0Value = ((DynamicObject) arg0Value_);
                return ForeignBoxedObject.fitsInShort(arg0Value, (INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean fitsInInt(Object arg0Value_) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                DynamicObject arg0Value = ((DynamicObject) arg0Value_);
                return ForeignBoxedObject.fitsInInt(arg0Value, (INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean fitsInLong(Object arg0Value_) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                DynamicObject arg0Value = ((DynamicObject) arg0Value_);
                return ForeignBoxedObject.fitsInLong(arg0Value, (INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean fitsInFloat(Object arg0Value_) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                DynamicObject arg0Value = ((DynamicObject) arg0Value_);
                return ForeignBoxedObject.fitsInFloat(arg0Value, (INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean fitsInDouble(Object arg0Value_) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                DynamicObject arg0Value = ((DynamicObject) arg0Value_);
                return ForeignBoxedObject.fitsInDouble(arg0Value, (INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public byte asByte(Object arg0Value_) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                DynamicObject arg0Value = ((DynamicObject) arg0Value_);
                return ForeignBoxedObject.asByte(arg0Value, (INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public short asShort(Object arg0Value_) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                DynamicObject arg0Value = ((DynamicObject) arg0Value_);
                return ForeignBoxedObject.asShort(arg0Value, (INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public int asInt(Object arg0Value_) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                DynamicObject arg0Value = ((DynamicObject) arg0Value_);
                return ForeignBoxedObject.asInt(arg0Value, (INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public long asLong(Object arg0Value_) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                DynamicObject arg0Value = ((DynamicObject) arg0Value_);
                return ForeignBoxedObject.asLong(arg0Value, (INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public float asFloat(Object arg0Value_) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                DynamicObject arg0Value = ((DynamicObject) arg0Value_);
                return ForeignBoxedObject.asFloat(arg0Value, (INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public double asDouble(Object arg0Value_) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                DynamicObject arg0Value = ((DynamicObject) arg0Value_);
                return ForeignBoxedObject.asDouble(arg0Value, (INTEROP_LIBRARY_.getUncached()));
            }

        }
    }
}
