// CheckStyle: start generated
package com.oracle.truffle.js.builtins;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.EncapsulatingNodeReference;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.access.GetMethodNode;
import com.oracle.truffle.js.nodes.access.IsJSObjectNode;
import com.oracle.truffle.js.nodes.access.IteratorStepNode;
import com.oracle.truffle.js.nodes.access.IteratorValueNode;
import com.oracle.truffle.js.nodes.access.PropertyGetNode;
import com.oracle.truffle.js.nodes.access.ReadElementNode;
import com.oracle.truffle.js.nodes.access.WriteElementNode;
import com.oracle.truffle.js.nodes.array.JSGetLengthNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.nodes.function.JSFunctionCallNode;
import com.oracle.truffle.js.nodes.interop.ImportValueNode;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.JSRuntime;
import com.oracle.truffle.js.runtime.array.TypedArray;
import com.oracle.truffle.js.runtime.array.TypedArrayFactory;
import com.oracle.truffle.js.runtime.builtins.JSAbstractBuffer;
import com.oracle.truffle.js.runtime.builtins.JSArrayBuffer;
import com.oracle.truffle.js.runtime.builtins.JSObjectFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSConstructTypedArrayNode.class)
@SuppressWarnings("unused")
public final class JSConstructTypedArrayNodeGen extends JSConstructTypedArrayNode implements Provider {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @Child private JavaScriptNode arguments0_;
    @Child private JavaScriptNode arguments1_;
    @Child private JavaScriptNode arguments2_;
    @Child private JavaScriptNode arguments3_;
    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private ConditionProfile arrayBuffer_lengthIsUndefined_;
    @CompilationFinal private ConditionProfile directArrayBuffer_lengthIsUndefined_;
    @CompilationFinal private ConditionProfile sharedArrayBuffer_lengthCondition_;
    @Child private ObjectData object_cache;
    @Child private ForeignObject0Data foreignObject0_cache;
    @Child private WriteElementNode foreignObject1_writeOwnNode_;
    @Child private ImportValueNode foreignObject1_importValue_;

    private JSConstructTypedArrayNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
        super(context, builtin);
        this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
        this.arguments2_ = arguments != null && 2 < arguments.length ? arguments[2] : null;
        this.arguments3_ = arguments != null && 3 < arguments.length ? arguments[3] : null;
    }

    @Override
    public JavaScriptNode[] getArguments() {
        return new JavaScriptNode[] {this.arguments0_, this.arguments1_, this.arguments2_, this.arguments3_};
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        int state = state_;
        if ((state & 0b11111011111) == 0 /* only-active doIntLength(DynamicObject, int, Object, Object) */ && state != 0  /* is-not doArrayBuffer(DynamicObject, DynamicObject, Object, Object, ConditionProfile) && doDirectArrayBuffer(DynamicObject, DynamicObject, Object, Object, ConditionProfile) && doSharedArrayBuffer(DynamicObject, DynamicObject, Object, Object, ConditionProfile) && doArrayBufferView(DynamicObject, DynamicObject, Object, Object) && doEmpty(DynamicObject, DynamicObject, Object, Object) && doIntLength(DynamicObject, int, Object, Object) && doLength(DynamicObject, Object, Object, Object) && doObject(DynamicObject, DynamicObject, Object, Object, GetMethodNode, ConditionProfile, WriteElementNode, JSFunctionCallNode, IsJSObjectNode, IteratorStepNode, IteratorValueNode, JSGetLengthNode, ReadElementNode, PropertyGetNode, BranchProfile) && doForeignObject(DynamicObject, Object, Object, Object, InteropLibrary, WriteElementNode, ImportValueNode) && doForeignObject(DynamicObject, Object, Object, Object, InteropLibrary, WriteElementNode, ImportValueNode) && doUndefinedNewTarget(Object, Object, Object, Object) */) {
            return execute_int0(frameValue, state);
        } else {
            return execute_generic1(frameValue, state);
        }
    }

    private Object execute_int0(VirtualFrame frameValue, int state) {
        Object arguments0Value_ = this.arguments0_.execute(frameValue);
        int arguments1Value_;
        try {
            arguments1Value_ = this.arguments1_.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            Object arguments2Value = this.arguments2_.execute(frameValue);
            Object arguments3Value = this.arguments3_.execute(frameValue);
            return executeAndSpecialize(arguments0Value_, ex.getResult(), arguments2Value, arguments3Value);
        }
        Object arguments2Value_ = this.arguments2_.execute(frameValue);
        Object arguments3Value_ = this.arguments3_.execute(frameValue);
        assert (state & 0b100000) != 0 /* is-active doIntLength(DynamicObject, int, Object, Object) */;
        if (JSTypes.isDynamicObject(arguments0Value_)) {
            DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
            if ((JSGuards.isJSFunction(arguments0Value__)) && (arguments1Value_ >= 0)) {
                return doIntLength(arguments0Value__, arguments1Value_, arguments2Value_, arguments3Value_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_, arguments3Value_);
    }

    @TruffleBoundary
    private Object foreignObject1Boundary(int state, DynamicObject arguments0Value__, Object arguments1Value_, Object arguments2Value_, Object arguments3Value_) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary foreignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments1Value_));
                return doForeignObject(arguments0Value__, arguments1Value_, arguments2Value_, arguments3Value_, foreignObject1_interop__, this.foreignObject1_writeOwnNode_, this.foreignObject1_importValue_);
            }
        } finally {
            encapsulating_.set(prev_);
        }
    }

    @ExplodeLoop
    private Object execute_generic1(VirtualFrame frameValue, int state) {
        Object arguments0Value_ = this.arguments0_.execute(frameValue);
        Object arguments1Value_ = this.arguments1_.execute(frameValue);
        Object arguments2Value_ = this.arguments2_.execute(frameValue);
        Object arguments3Value_ = this.arguments3_.execute(frameValue);
        if (state != 0 /* is-active doArrayBuffer(DynamicObject, DynamicObject, Object, Object, ConditionProfile) || doDirectArrayBuffer(DynamicObject, DynamicObject, Object, Object, ConditionProfile) || doSharedArrayBuffer(DynamicObject, DynamicObject, Object, Object, ConditionProfile) || doArrayBufferView(DynamicObject, DynamicObject, Object, Object) || doEmpty(DynamicObject, DynamicObject, Object, Object) || doIntLength(DynamicObject, int, Object, Object) || doLength(DynamicObject, Object, Object, Object) || doObject(DynamicObject, DynamicObject, Object, Object, GetMethodNode, ConditionProfile, WriteElementNode, JSFunctionCallNode, IsJSObjectNode, IteratorStepNode, IteratorValueNode, JSGetLengthNode, ReadElementNode, PropertyGetNode, BranchProfile) || doForeignObject(DynamicObject, Object, Object, Object, InteropLibrary, WriteElementNode, ImportValueNode) || doForeignObject(DynamicObject, Object, Object, Object, InteropLibrary, WriteElementNode, ImportValueNode) || doUndefinedNewTarget(Object, Object, Object, Object) */) {
            if ((state & 0b1111111111) != 0 /* is-active doArrayBuffer(DynamicObject, DynamicObject, Object, Object, ConditionProfile) || doDirectArrayBuffer(DynamicObject, DynamicObject, Object, Object, ConditionProfile) || doSharedArrayBuffer(DynamicObject, DynamicObject, Object, Object, ConditionProfile) || doArrayBufferView(DynamicObject, DynamicObject, Object, Object) || doEmpty(DynamicObject, DynamicObject, Object, Object) || doIntLength(DynamicObject, int, Object, Object) || doLength(DynamicObject, Object, Object, Object) || doObject(DynamicObject, DynamicObject, Object, Object, GetMethodNode, ConditionProfile, WriteElementNode, JSFunctionCallNode, IsJSObjectNode, IteratorStepNode, IteratorValueNode, JSGetLengthNode, ReadElementNode, PropertyGetNode, BranchProfile) || doForeignObject(DynamicObject, Object, Object, Object, InteropLibrary, WriteElementNode, ImportValueNode) || doForeignObject(DynamicObject, Object, Object, Object, InteropLibrary, WriteElementNode, ImportValueNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state & 0b11111) != 0 /* is-active doArrayBuffer(DynamicObject, DynamicObject, Object, Object, ConditionProfile) || doDirectArrayBuffer(DynamicObject, DynamicObject, Object, Object, ConditionProfile) || doSharedArrayBuffer(DynamicObject, DynamicObject, Object, Object, ConditionProfile) || doArrayBufferView(DynamicObject, DynamicObject, Object, Object) || doEmpty(DynamicObject, DynamicObject, Object, Object) */ && JSTypes.isDynamicObject(arguments1Value_)) {
                    DynamicObject arguments1Value__ = (DynamicObject) arguments1Value_;
                    if ((state & 0b1) != 0 /* is-active doArrayBuffer(DynamicObject, DynamicObject, Object, Object, ConditionProfile) */) {
                        if ((JSGuards.isJSFunction(arguments0Value__)) && (JSArrayBuffer.isJSHeapArrayBuffer(arguments1Value__))) {
                            return doArrayBuffer(arguments0Value__, arguments1Value__, arguments2Value_, arguments3Value_, this.arrayBuffer_lengthIsUndefined_);
                        }
                    }
                    if ((state & 0b10) != 0 /* is-active doDirectArrayBuffer(DynamicObject, DynamicObject, Object, Object, ConditionProfile) */) {
                        if ((JSGuards.isJSFunction(arguments0Value__)) && (JSArrayBuffer.isJSDirectArrayBuffer(arguments1Value__))) {
                            return doDirectArrayBuffer(arguments0Value__, arguments1Value__, arguments2Value_, arguments3Value_, this.directArrayBuffer_lengthIsUndefined_);
                        }
                    }
                    if ((state & 0b100) != 0 /* is-active doSharedArrayBuffer(DynamicObject, DynamicObject, Object, Object, ConditionProfile) */) {
                        if ((JSGuards.isJSFunction(arguments0Value__)) && (JSGuards.isJSSharedArrayBuffer(arguments1Value__))) {
                            return doSharedArrayBuffer(arguments0Value__, arguments1Value__, arguments2Value_, arguments3Value_, this.sharedArrayBuffer_lengthCondition_);
                        }
                    }
                    if ((state & 0b1000) != 0 /* is-active doArrayBufferView(DynamicObject, DynamicObject, Object, Object) */) {
                        if ((JSGuards.isJSFunction(arguments0Value__)) && (JSGuards.isJSArrayBufferView(arguments1Value__))) {
                            return doArrayBufferView(arguments0Value__, arguments1Value__, arguments2Value_, arguments3Value_);
                        }
                    }
                    if ((state & 0b10000) != 0 /* is-active doEmpty(DynamicObject, DynamicObject, Object, Object) */) {
                        if ((JSGuards.isJSFunction(arguments0Value__)) && (JSGuards.isUndefined(arguments1Value__))) {
                            return doEmpty(arguments0Value__, arguments1Value__, arguments2Value_, arguments3Value_);
                        }
                    }
                }
                if ((state & 0b100000) != 0 /* is-active doIntLength(DynamicObject, int, Object, Object) */ && arguments1Value_ instanceof Integer) {
                    int arguments1Value__ = (int) arguments1Value_;
                    if ((JSGuards.isJSFunction(arguments0Value__)) && (arguments1Value__ >= 0)) {
                        return doIntLength(arguments0Value__, arguments1Value__, arguments2Value_, arguments3Value_);
                    }
                }
                if ((state & 0b1000000) != 0 /* is-active doLength(DynamicObject, Object, Object, Object) */) {
                    if ((JSGuards.isJSFunction(arguments0Value__)) && (!(JSGuards.isJSObject(arguments1Value_))) && (!(JSRuntime.isForeignObject(arguments1Value_)))) {
                        return doLength(arguments0Value__, arguments1Value_, arguments2Value_, arguments3Value_);
                    }
                }
                if ((state & 0b10000000) != 0 /* is-active doObject(DynamicObject, DynamicObject, Object, Object, GetMethodNode, ConditionProfile, WriteElementNode, JSFunctionCallNode, IsJSObjectNode, IteratorStepNode, IteratorValueNode, JSGetLengthNode, ReadElementNode, PropertyGetNode, BranchProfile) */ && JSTypes.isDynamicObject(arguments1Value_)) {
                    DynamicObject arguments1Value__ = (DynamicObject) arguments1Value_;
                    ObjectData s8_ = this.object_cache;
                    if (s8_ != null) {
                        if ((JSGuards.isJSFunction(arguments0Value__)) && (JSGuards.isJSObject(arguments1Value__)) && (!(JSAbstractBuffer.isJSAbstractBuffer(arguments1Value__))) && (!(JSGuards.isJSArrayBufferView(arguments1Value__)))) {
                            return doObject(arguments0Value__, arguments1Value__, arguments2Value_, arguments3Value_, s8_.getIteratorMethodNode_, s8_.isIterableProfile_, s8_.writeOwnNode_, s8_.iteratorCallNode_, s8_.isObjectNode_, s8_.iteratorStepNode_, s8_.getIteratorValueNode_, s8_.getLengthNode_, s8_.readNode_, s8_.getNextMethodNode_, s8_.growProfile_);
                        }
                    }
                }
                if ((state & 0b1100000000) != 0 /* is-active doForeignObject(DynamicObject, Object, Object, Object, InteropLibrary, WriteElementNode, ImportValueNode) || doForeignObject(DynamicObject, Object, Object, Object, InteropLibrary, WriteElementNode, ImportValueNode) */) {
                    if ((state & 0b100000000) != 0 /* is-active doForeignObject(DynamicObject, Object, Object, Object, InteropLibrary, WriteElementNode, ImportValueNode) */) {
                        ForeignObject0Data s9_ = this.foreignObject0_cache;
                        while (s9_ != null) {
                            if ((s9_.interop_.accepts(arguments1Value_)) && (JSGuards.isJSFunction(arguments0Value__)) && (JSRuntime.isForeignObject(arguments1Value_))) {
                                return doForeignObject(arguments0Value__, arguments1Value_, arguments2Value_, arguments3Value_, s9_.interop_, s9_.writeOwnNode_, s9_.importValue_);
                            }
                            s9_ = s9_.next_;
                        }
                    }
                    if ((state & 0b1000000000) != 0 /* is-active doForeignObject(DynamicObject, Object, Object, Object, InteropLibrary, WriteElementNode, ImportValueNode) */) {
                        if ((JSGuards.isJSFunction(arguments0Value__)) && (JSRuntime.isForeignObject(arguments1Value_))) {
                            return this.foreignObject1Boundary(state, arguments0Value__, arguments1Value_, arguments2Value_, arguments3Value_);
                        }
                    }
                }
            }
            if ((state & 0b10000000000) != 0 /* is-active doUndefinedNewTarget(Object, Object, Object, Object) */) {
                if ((!(JSGuards.isJSFunction(arguments0Value_)))) {
                    return doUndefinedNewTarget(arguments0Value_, arguments1Value_, arguments2Value_, arguments3Value_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_, arguments3Value_);
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        execute(frameValue);
        return;
    }

    private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value, Object arguments3Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        int exclude = exclude_;
        try {
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if (JSTypes.isDynamicObject(arguments1Value)) {
                    DynamicObject arguments1Value_ = (DynamicObject) arguments1Value;
                    if ((JSGuards.isJSFunction(arguments0Value_)) && (JSArrayBuffer.isJSHeapArrayBuffer(arguments1Value_))) {
                        this.arrayBuffer_lengthIsUndefined_ = (ConditionProfile.createBinaryProfile());
                        this.state_ = state = state | 0b1 /* add-active doArrayBuffer(DynamicObject, DynamicObject, Object, Object, ConditionProfile) */;
                        lock.unlock();
                        hasLock = false;
                        return doArrayBuffer(arguments0Value_, arguments1Value_, arguments2Value, arguments3Value, this.arrayBuffer_lengthIsUndefined_);
                    }
                    if ((JSGuards.isJSFunction(arguments0Value_)) && (JSArrayBuffer.isJSDirectArrayBuffer(arguments1Value_))) {
                        this.directArrayBuffer_lengthIsUndefined_ = (ConditionProfile.createBinaryProfile());
                        this.state_ = state = state | 0b10 /* add-active doDirectArrayBuffer(DynamicObject, DynamicObject, Object, Object, ConditionProfile) */;
                        lock.unlock();
                        hasLock = false;
                        return doDirectArrayBuffer(arguments0Value_, arguments1Value_, arguments2Value, arguments3Value, this.directArrayBuffer_lengthIsUndefined_);
                    }
                    if ((JSGuards.isJSFunction(arguments0Value_)) && (JSGuards.isJSSharedArrayBuffer(arguments1Value_))) {
                        this.sharedArrayBuffer_lengthCondition_ = (ConditionProfile.createBinaryProfile());
                        this.state_ = state = state | 0b100 /* add-active doSharedArrayBuffer(DynamicObject, DynamicObject, Object, Object, ConditionProfile) */;
                        lock.unlock();
                        hasLock = false;
                        return doSharedArrayBuffer(arguments0Value_, arguments1Value_, arguments2Value, arguments3Value, this.sharedArrayBuffer_lengthCondition_);
                    }
                    if ((JSGuards.isJSFunction(arguments0Value_)) && (JSGuards.isJSArrayBufferView(arguments1Value_))) {
                        this.state_ = state = state | 0b1000 /* add-active doArrayBufferView(DynamicObject, DynamicObject, Object, Object) */;
                        lock.unlock();
                        hasLock = false;
                        return doArrayBufferView(arguments0Value_, arguments1Value_, arguments2Value, arguments3Value);
                    }
                    if ((JSGuards.isJSFunction(arguments0Value_)) && (JSGuards.isUndefined(arguments1Value_))) {
                        this.state_ = state = state | 0b10000 /* add-active doEmpty(DynamicObject, DynamicObject, Object, Object) */;
                        lock.unlock();
                        hasLock = false;
                        return doEmpty(arguments0Value_, arguments1Value_, arguments2Value, arguments3Value);
                    }
                }
                if (((exclude & 0b1)) == 0 /* is-not-excluded doIntLength(DynamicObject, int, Object, Object) */ && arguments1Value instanceof Integer) {
                    int arguments1Value_ = (int) arguments1Value;
                    if ((JSGuards.isJSFunction(arguments0Value_)) && (arguments1Value_ >= 0)) {
                        this.state_ = state = state | 0b100000 /* add-active doIntLength(DynamicObject, int, Object, Object) */;
                        lock.unlock();
                        hasLock = false;
                        return doIntLength(arguments0Value_, arguments1Value_, arguments2Value, arguments3Value);
                    }
                }
                if ((JSGuards.isJSFunction(arguments0Value_)) && (!(JSGuards.isJSObject(arguments1Value))) && (!(JSRuntime.isForeignObject(arguments1Value)))) {
                    this.exclude_ = exclude = exclude | 0b1 /* add-excluded doIntLength(DynamicObject, int, Object, Object) */;
                    state = state & 0xffffffdf /* remove-active doIntLength(DynamicObject, int, Object, Object) */;
                    this.state_ = state = state | 0b1000000 /* add-active doLength(DynamicObject, Object, Object, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return doLength(arguments0Value_, arguments1Value, arguments2Value, arguments3Value);
                }
                if (JSTypes.isDynamicObject(arguments1Value)) {
                    DynamicObject arguments1Value_ = (DynamicObject) arguments1Value;
                    if ((JSGuards.isJSFunction(arguments0Value_)) && (JSGuards.isJSObject(arguments1Value_)) && (!(JSAbstractBuffer.isJSAbstractBuffer(arguments1Value_))) && (!(JSGuards.isJSArrayBufferView(arguments1Value_)))) {
                        ObjectData s8_ = super.insert(new ObjectData());
                        s8_.getIteratorMethodNode_ = s8_.insertAccessor((createGetIteratorMethod()));
                        s8_.isIterableProfile_ = (ConditionProfile.createBinaryProfile());
                        s8_.writeOwnNode_ = s8_.insertAccessor((createWriteOwn()));
                        s8_.iteratorCallNode_ = s8_.insertAccessor((JSFunctionCallNode.createCall()));
                        s8_.isObjectNode_ = s8_.insertAccessor((IsJSObjectNode.create()));
                        s8_.iteratorStepNode_ = s8_.insertAccessor((IteratorStepNode.create(getContext())));
                        s8_.getIteratorValueNode_ = s8_.insertAccessor((IteratorValueNode.create(getContext())));
                        s8_.getLengthNode_ = s8_.insertAccessor((createGetLength()));
                        s8_.readNode_ = s8_.insertAccessor((ReadElementNode.create(getContext())));
                        s8_.getNextMethodNode_ = s8_.insertAccessor((PropertyGetNode.create(JSRuntime.NEXT, getContext())));
                        s8_.growProfile_ = (BranchProfile.create());
                        this.object_cache = s8_;
                        this.state_ = state = state | 0b10000000 /* add-active doObject(DynamicObject, DynamicObject, Object, Object, GetMethodNode, ConditionProfile, WriteElementNode, JSFunctionCallNode, IsJSObjectNode, IteratorStepNode, IteratorValueNode, JSGetLengthNode, ReadElementNode, PropertyGetNode, BranchProfile) */;
                        lock.unlock();
                        hasLock = false;
                        return doObject(arguments0Value_, arguments1Value_, arguments2Value, arguments3Value, s8_.getIteratorMethodNode_, s8_.isIterableProfile_, s8_.writeOwnNode_, s8_.iteratorCallNode_, s8_.isObjectNode_, s8_.iteratorStepNode_, s8_.getIteratorValueNode_, s8_.getLengthNode_, s8_.readNode_, s8_.getNextMethodNode_, s8_.growProfile_);
                    }
                }
                if (((exclude & 0b10)) == 0 /* is-not-excluded doForeignObject(DynamicObject, Object, Object, Object, InteropLibrary, WriteElementNode, ImportValueNode) */) {
                    int count9_ = 0;
                    ForeignObject0Data s9_ = this.foreignObject0_cache;
                    if ((state & 0b100000000) != 0 /* is-active doForeignObject(DynamicObject, Object, Object, Object, InteropLibrary, WriteElementNode, ImportValueNode) */) {
                        while (s9_ != null) {
                            if ((s9_.interop_.accepts(arguments1Value)) && (JSGuards.isJSFunction(arguments0Value_)) && (JSRuntime.isForeignObject(arguments1Value))) {
                                break;
                            }
                            s9_ = s9_.next_;
                            count9_++;
                        }
                    }
                    if (s9_ == null) {
                        if ((JSGuards.isJSFunction(arguments0Value_)) && (JSRuntime.isForeignObject(arguments1Value)) && count9_ < (3)) {
                            // assert (s9_.interop_.accepts(arguments1Value));
                            s9_ = super.insert(new ForeignObject0Data(foreignObject0_cache));
                            s9_.interop_ = s9_.insertAccessor((INTEROP_LIBRARY_.create(arguments1Value)));
                            s9_.writeOwnNode_ = s9_.insertAccessor((createWriteOwn()));
                            s9_.importValue_ = s9_.insertAccessor((ImportValueNode.create()));
                            this.foreignObject0_cache = s9_;
                            this.state_ = state = state | 0b100000000 /* add-active doForeignObject(DynamicObject, Object, Object, Object, InteropLibrary, WriteElementNode, ImportValueNode) */;
                        }
                    }
                    if (s9_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return doForeignObject(arguments0Value_, arguments1Value, arguments2Value, arguments3Value, s9_.interop_, s9_.writeOwnNode_, s9_.importValue_);
                    }
                }
                {
                    InteropLibrary foreignObject1_interop__ = null;
                    {
                        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                        Node prev_ = encapsulating_.set(this);
                        try {
                            if ((JSGuards.isJSFunction(arguments0Value_)) && (JSRuntime.isForeignObject(arguments1Value))) {
                                foreignObject1_interop__ = (INTEROP_LIBRARY_.getUncached(arguments1Value));
                                this.foreignObject1_writeOwnNode_ = super.insert((createWriteOwn()));
                                this.foreignObject1_importValue_ = super.insert((ImportValueNode.create()));
                                this.exclude_ = exclude = exclude | 0b10 /* add-excluded doForeignObject(DynamicObject, Object, Object, Object, InteropLibrary, WriteElementNode, ImportValueNode) */;
                                this.foreignObject0_cache = null;
                                state = state & 0xfffffeff /* remove-active doForeignObject(DynamicObject, Object, Object, Object, InteropLibrary, WriteElementNode, ImportValueNode) */;
                                this.state_ = state = state | 0b1000000000 /* add-active doForeignObject(DynamicObject, Object, Object, Object, InteropLibrary, WriteElementNode, ImportValueNode) */;
                                lock.unlock();
                                hasLock = false;
                                return doForeignObject(arguments0Value_, arguments1Value, arguments2Value, arguments3Value, foreignObject1_interop__, this.foreignObject1_writeOwnNode_, this.foreignObject1_importValue_);
                            }
                        } finally {
                            encapsulating_.set(prev_);
                        }
                    }
                }
            }
            if ((!(JSGuards.isJSFunction(arguments0Value)))) {
                this.state_ = state = state | 0b10000000000 /* add-active doUndefinedNewTarget(Object, Object, Object, Object) */;
                lock.unlock();
                hasLock = false;
                return doUndefinedNewTarget(arguments0Value, arguments1Value, arguments2Value, arguments3Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_, this.arguments2_, this.arguments3_}, arguments0Value, arguments1Value, arguments2Value, arguments3Value);
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
            ForeignObject0Data s9_ = this.foreignObject0_cache;
            if ((s9_ == null || s9_.next_ == null)) {
                return NodeCost.MONOMORPHIC;
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[12];
        Object[] s;
        data[0] = 0;
        int state = state_;
        int exclude = exclude_;
        s = new Object[3];
        s[0] = "doArrayBuffer";
        if ((state & 0b1) != 0 /* is-active doArrayBuffer(DynamicObject, DynamicObject, Object, Object, ConditionProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.arrayBuffer_lengthIsUndefined_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doDirectArrayBuffer";
        if ((state & 0b10) != 0 /* is-active doDirectArrayBuffer(DynamicObject, DynamicObject, Object, Object, ConditionProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.directArrayBuffer_lengthIsUndefined_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doSharedArrayBuffer";
        if ((state & 0b100) != 0 /* is-active doSharedArrayBuffer(DynamicObject, DynamicObject, Object, Object, ConditionProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.sharedArrayBuffer_lengthCondition_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doArrayBufferView";
        if ((state & 0b1000) != 0 /* is-active doArrayBufferView(DynamicObject, DynamicObject, Object, Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doEmpty";
        if ((state & 0b10000) != 0 /* is-active doEmpty(DynamicObject, DynamicObject, Object, Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "doIntLength";
        if ((state & 0b100000) != 0 /* is-active doIntLength(DynamicObject, int, Object, Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else if ((exclude & 0b1) != 0 /* is-excluded doIntLength(DynamicObject, int, Object, Object) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "doLength";
        if ((state & 0b1000000) != 0 /* is-active doLength(DynamicObject, Object, Object, Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        s = new Object[3];
        s[0] = "doObject";
        if ((state & 0b10000000) != 0 /* is-active doObject(DynamicObject, DynamicObject, Object, Object, GetMethodNode, ConditionProfile, WriteElementNode, JSFunctionCallNode, IsJSObjectNode, IteratorStepNode, IteratorValueNode, JSGetLengthNode, ReadElementNode, PropertyGetNode, BranchProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            ObjectData s8_ = this.object_cache;
            if (s8_ != null) {
                cached.add(Arrays.asList(s8_.getIteratorMethodNode_, s8_.isIterableProfile_, s8_.writeOwnNode_, s8_.iteratorCallNode_, s8_.isObjectNode_, s8_.iteratorStepNode_, s8_.getIteratorValueNode_, s8_.getLengthNode_, s8_.readNode_, s8_.getNextMethodNode_, s8_.growProfile_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[8] = s;
        s = new Object[3];
        s[0] = "doForeignObject";
        if ((state & 0b100000000) != 0 /* is-active doForeignObject(DynamicObject, Object, Object, Object, InteropLibrary, WriteElementNode, ImportValueNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            ForeignObject0Data s9_ = this.foreignObject0_cache;
            while (s9_ != null) {
                cached.add(Arrays.asList(s9_.interop_, s9_.writeOwnNode_, s9_.importValue_));
                s9_ = s9_.next_;
            }
            s[2] = cached;
        } else if ((exclude & 0b10) != 0 /* is-excluded doForeignObject(DynamicObject, Object, Object, Object, InteropLibrary, WriteElementNode, ImportValueNode) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[9] = s;
        s = new Object[3];
        s[0] = "doForeignObject";
        if ((state & 0b1000000000) != 0 /* is-active doForeignObject(DynamicObject, Object, Object, Object, InteropLibrary, WriteElementNode, ImportValueNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.foreignObject1_writeOwnNode_, this.foreignObject1_importValue_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[10] = s;
        s = new Object[3];
        s[0] = "doUndefinedNewTarget";
        if ((state & 0b10000000000) != 0 /* is-active doUndefinedNewTarget(Object, Object, Object, Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[11] = s;
        return Provider.create(data);
    }

    public static JSConstructTypedArrayNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
        return new JSConstructTypedArrayNodeGen(context, builtin, arguments);
    }

    @GeneratedBy(JSConstructTypedArrayNode.class)
    private static final class ObjectData extends Node {

        @Child GetMethodNode getIteratorMethodNode_;
        @CompilationFinal ConditionProfile isIterableProfile_;
        @Child WriteElementNode writeOwnNode_;
        @Child JSFunctionCallNode iteratorCallNode_;
        @Child IsJSObjectNode isObjectNode_;
        @Child IteratorStepNode iteratorStepNode_;
        @Child IteratorValueNode getIteratorValueNode_;
        @Child JSGetLengthNode getLengthNode_;
        @Child ReadElementNode readNode_;
        @Child PropertyGetNode getNextMethodNode_;
        @CompilationFinal BranchProfile growProfile_;

        ObjectData() {
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.NONE;
        }

        <T extends Node> T insertAccessor(T node) {
            return super.insert(node);
        }

    }
    @GeneratedBy(JSConstructTypedArrayNode.class)
    private static final class ForeignObject0Data extends Node {

        @Child ForeignObject0Data next_;
        @Child InteropLibrary interop_;
        @Child WriteElementNode writeOwnNode_;
        @Child ImportValueNode importValue_;

        ForeignObject0Data(ForeignObject0Data next_) {
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
    @GeneratedBy(IntegerIndexedObjectCreateNode.class)
    static final class IntegerIndexedObjectCreateNodeGen extends IntegerIndexedObjectCreateNode implements Provider {

        @CompilationFinal private volatile int state_;
        @CompilationFinal private volatile int exclude_;
        @CompilationFinal private DynamicObject cachedProto_cachedProto_;
        @CompilationFinal private JSObjectFactory cachedProto_objectFactory_;

        private IntegerIndexedObjectCreateNodeGen(JSContext context, TypedArrayFactory factory) {
            super(context, factory);
        }

        @Override
        DynamicObject execute(DynamicObject arg0Value, TypedArray arg1Value, int arg2Value, int arg3Value, DynamicObject arg4Value) {
            int state = state_;
            if (state != 0 /* is-active doDefaultProto(DynamicObject, TypedArray, int, int, DynamicObject) || doCachedProto(DynamicObject, TypedArray, int, int, DynamicObject, DynamicObject, JSObjectFactory) || doUncachedProto(DynamicObject, TypedArray, int, int, DynamicObject) */) {
                if ((state & 0b1) != 0 /* is-active doDefaultProto(DynamicObject, TypedArray, int, int, DynamicObject) */) {
                    if ((isDefaultPrototype(arg4Value))) {
                        return doDefaultProto(arg0Value, arg1Value, arg2Value, arg3Value, arg4Value);
                    }
                }
                if ((state & 0b10) != 0 /* is-active doCachedProto(DynamicObject, TypedArray, int, int, DynamicObject, DynamicObject, JSObjectFactory) */) {
                    if ((!(isDefaultPrototype(arg4Value))) && (arg4Value == this.cachedProto_cachedProto_)) {
                        return doCachedProto(arg0Value, arg1Value, arg2Value, arg3Value, arg4Value, this.cachedProto_cachedProto_, this.cachedProto_objectFactory_);
                    }
                }
                if ((state & 0b100) != 0 /* is-active doUncachedProto(DynamicObject, TypedArray, int, int, DynamicObject) */) {
                    if ((!(isDefaultPrototype(arg4Value)))) {
                        return doUncachedProto(arg0Value, arg1Value, arg2Value, arg3Value, arg4Value);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value, arg1Value, arg2Value, arg3Value, arg4Value);
        }

        private DynamicObject executeAndSpecialize(DynamicObject arg0Value, TypedArray arg1Value, int arg2Value, int arg3Value, DynamicObject arg4Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int exclude = exclude_;
            try {
                if ((isDefaultPrototype(arg4Value))) {
                    this.state_ = state = state | 0b1 /* add-active doDefaultProto(DynamicObject, TypedArray, int, int, DynamicObject) */;
                    lock.unlock();
                    hasLock = false;
                    return doDefaultProto(arg0Value, arg1Value, arg2Value, arg3Value, arg4Value);
                }
                if ((exclude) == 0 /* is-not-excluded doCachedProto(DynamicObject, TypedArray, int, int, DynamicObject, DynamicObject, JSObjectFactory) */) {
                    boolean CachedProto_duplicateFound_ = false;
                    if ((state & 0b10) != 0 /* is-active doCachedProto(DynamicObject, TypedArray, int, int, DynamicObject, DynamicObject, JSObjectFactory) */) {
                        if ((!(isDefaultPrototype(arg4Value))) && (arg4Value == this.cachedProto_cachedProto_)) {
                            CachedProto_duplicateFound_ = true;
                        }
                    }
                    if (!CachedProto_duplicateFound_) {
                        if ((!(isDefaultPrototype(arg4Value)))) {
                            // assert (arg4Value == this.cachedProto_cachedProto_);
                            if (((state & 0b10)) == 0 /* is-not-active doCachedProto(DynamicObject, TypedArray, int, int, DynamicObject, DynamicObject, JSObjectFactory) */) {
                                this.cachedProto_cachedProto_ = (arg4Value);
                                this.cachedProto_objectFactory_ = (makeObjectFactory(this.cachedProto_cachedProto_));
                                this.state_ = state = state | 0b10 /* add-active doCachedProto(DynamicObject, TypedArray, int, int, DynamicObject, DynamicObject, JSObjectFactory) */;
                                CachedProto_duplicateFound_ = true;
                            }
                        }
                    }
                    if (CachedProto_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return doCachedProto(arg0Value, arg1Value, arg2Value, arg3Value, arg4Value, this.cachedProto_cachedProto_, this.cachedProto_objectFactory_);
                    }
                }
                if ((!(isDefaultPrototype(arg4Value)))) {
                    this.exclude_ = exclude = exclude | 0b1 /* add-excluded doCachedProto(DynamicObject, TypedArray, int, int, DynamicObject, DynamicObject, JSObjectFactory) */;
                    state = state & 0xfffffffd /* remove-active doCachedProto(DynamicObject, TypedArray, int, int, DynamicObject, DynamicObject, JSObjectFactory) */;
                    this.state_ = state = state | 0b100 /* add-active doUncachedProto(DynamicObject, TypedArray, int, int, DynamicObject) */;
                    lock.unlock();
                    hasLock = false;
                    return doUncachedProto(arg0Value, arg1Value, arg2Value, arg3Value, arg4Value);
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null, null, null, null, null}, arg0Value, arg1Value, arg2Value, arg3Value, arg4Value);
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
            Object[] data = new Object[4];
            Object[] s;
            data[0] = 0;
            int state = state_;
            int exclude = exclude_;
            s = new Object[3];
            s[0] = "doDefaultProto";
            if ((state & 0b1) != 0 /* is-active doDefaultProto(DynamicObject, TypedArray, int, int, DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doCachedProto";
            if ((state & 0b10) != 0 /* is-active doCachedProto(DynamicObject, TypedArray, int, int, DynamicObject, DynamicObject, JSObjectFactory) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.cachedProto_cachedProto_, this.cachedProto_objectFactory_));
                s[2] = cached;
            } else if (exclude != 0 /* is-excluded doCachedProto(DynamicObject, TypedArray, int, int, DynamicObject, DynamicObject, JSObjectFactory) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "doUncachedProto";
            if ((state & 0b100) != 0 /* is-active doUncachedProto(DynamicObject, TypedArray, int, int, DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static IntegerIndexedObjectCreateNode create(JSContext context, TypedArrayFactory factory) {
            return new IntegerIndexedObjectCreateNodeGen(context, factory);
        }

    }
}
