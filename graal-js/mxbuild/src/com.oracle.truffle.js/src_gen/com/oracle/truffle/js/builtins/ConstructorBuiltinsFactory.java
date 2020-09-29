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
import com.oracle.truffle.api.interop.TruffleObject;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.EncapsulatingNodeReference;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.CallBigIntNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.CallBooleanNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.CallCollatorNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.CallDateNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.CallDateTimeFormatNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.CallNumberFormatNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.CallNumberNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.CallRequiresNewNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.CallStringNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.CallSymbolNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.CallTypedArrayNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructAggregateErrorNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructArrayBufferNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructArrayNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructBigIntNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructBooleanNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructCollatorNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructDataViewNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructDateNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructDateTimeFormatNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructDisplayNamesNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructErrorNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructFinalizationRegistryNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructFunctionNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructJSAdapterNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructJSProxyNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructJavaImporterNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructListFormatNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructLocaleNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructMapNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructNumberFormatNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructNumberNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructObjectNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructPluralRulesNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructRegExpNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructRelativeTimeFormatNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructSegmenterNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructSetNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructStringNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructSymbolNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructWeakMapNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructWeakRefNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.ConstructWeakSetNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.CreateDynamicFunctionNode;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.LRUCache;
import com.oracle.truffle.js.builtins.ConstructorBuiltins.PromiseConstructorNode;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.ScriptNode;
import com.oracle.truffle.js.nodes.access.GetMethodNode;
import com.oracle.truffle.js.nodes.access.IsJSObjectNode;
import com.oracle.truffle.js.nodes.access.IsRegExpNode;
import com.oracle.truffle.js.nodes.access.IteratorStepNode;
import com.oracle.truffle.js.nodes.access.IteratorValueNode;
import com.oracle.truffle.js.nodes.access.PropertyGetNode;
import com.oracle.truffle.js.nodes.array.ArrayCreateNode;
import com.oracle.truffle.js.nodes.cast.JSNumberToBigIntNode;
import com.oracle.truffle.js.nodes.cast.JSNumericToNumberNode;
import com.oracle.truffle.js.nodes.cast.JSToBigIntNode;
import com.oracle.truffle.js.nodes.cast.JSToBooleanNode;
import com.oracle.truffle.js.nodes.cast.JSToIndexNode;
import com.oracle.truffle.js.nodes.cast.JSToNumericNode;
import com.oracle.truffle.js.nodes.cast.JSToObjectNode;
import com.oracle.truffle.js.nodes.cast.JSToStringNode;
import com.oracle.truffle.js.nodes.cast.ToArrayLengthNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.nodes.function.JSFunctionCallNode;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.JSRuntime;
import com.oracle.truffle.js.runtime.Symbol;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(ConstructorBuiltins.class)
@SuppressWarnings("unused")
public final class ConstructorBuiltinsFactory {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @GeneratedBy(ConstructArrayNode.class)
    public static final class ConstructArrayNodeGen extends ConstructArrayNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_;
        @CompilationFinal private volatile int exclude_;
        @Child private ConstructWithLengthData constructWithLength_cache;
        @Child private ConstructWithForeignArg0Data constructWithForeignArg0_cache;
        @Child private ConstructWithForeignArg1Data constructWithForeignArg1_cache;
        @CompilationFinal private ConstructArrayVarargsData constructArrayVarargs_cache;

        private ConstructArrayNodeGen(JSContext context, JSBuiltin builtin, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, isNewTargetCase);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_};
        }

        @ExplodeLoop
        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if (state != 0 /* is-active constructArray0(DynamicObject, Object[]) || constructArrayWithIntLength(DynamicObject, Object[]) || constructWithLength(DynamicObject, Object[], ToArrayLengthNode, ArrayCreateNode, long) || constructWithForeignArg(DynamicObject, Object[], InteropLibrary, ArrayCreateNode, ConditionProfile, BranchProfile) || constructWithForeignArg(DynamicObject, Object[], InteropLibrary, ArrayCreateNode, ConditionProfile, BranchProfile) || constructArrayVarargs(DynamicObject, Object[], BranchProfile, BranchProfile, BranchProfile, ConditionProfile) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if (arguments1Value_ instanceof Object[]) {
                    Object[] arguments1Value__ = (Object[]) arguments1Value_;
                    if ((state & 0b1) != 0 /* is-active constructArray0(DynamicObject, Object[]) */) {
                        if ((arguments1Value__.length == 0)) {
                            return constructArray0(arguments0Value__, arguments1Value__);
                        }
                    }
                    if ((state & 0b10) != 0 /* is-active constructArrayWithIntLength(DynamicObject, Object[]) */) {
                        if ((ConstructArrayNode.isOneIntegerArg(arguments1Value__))) {
                            return constructArrayWithIntLength(arguments0Value__, arguments1Value__);
                        }
                    }
                    if ((state & 0b100) != 0 /* is-active constructWithLength(DynamicObject, Object[], ToArrayLengthNode, ArrayCreateNode, long) */ && (arguments1Value__.length == 1)) {
                        ConstructWithLengthData s3_ = this.constructWithLength_cache;
                        while (s3_ != null) {
                            {
                                long len__ = (s3_.toArrayLengthNode_.executeLong(ConstructArrayNode.firstArg(arguments1Value__)));
                                if ((s3_.toArrayLengthNode_.isTypeNumber(len__))) {
                                    return constructWithLength(arguments0Value__, arguments1Value__, s3_.toArrayLengthNode_, s3_.arrayCreateNode_, len__);
                                }
                            }
                            s3_ = s3_.next_;
                        }
                    }
                    if ((state & 0b1000) != 0 /* is-active constructWithForeignArg(DynamicObject, Object[], InteropLibrary, ArrayCreateNode, ConditionProfile, BranchProfile) */) {
                        ConstructWithForeignArg0Data s4_ = this.constructWithForeignArg0_cache;
                        while (s4_ != null) {
                            if ((s4_.interop_.accepts(ConstructArrayNode.firstArg(arguments1Value__))) && (ConstructArrayNode.isOneForeignArg(arguments1Value__))) {
                                return constructWithForeignArg(arguments0Value__, arguments1Value__, s4_.interop_, s4_.arrayCreateNode_, s4_.isNumber_, s4_.rangeErrorProfile_);
                            }
                            s4_ = s4_.next_;
                        }
                    }
                    if ((state & 0b10000) != 0 /* is-active constructWithForeignArg(DynamicObject, Object[], InteropLibrary, ArrayCreateNode, ConditionProfile, BranchProfile) */) {
                        ConstructWithForeignArg1Data s5_ = this.constructWithForeignArg1_cache;
                        if (s5_ != null) {
                            if ((ConstructArrayNode.isOneForeignArg(arguments1Value__))) {
                                return this.constructWithForeignArg1Boundary(state, s5_, arguments0Value__, arguments1Value__);
                            }
                        }
                    }
                    if ((state & 0b100000) != 0 /* is-active constructArrayVarargs(DynamicObject, Object[], BranchProfile, BranchProfile, BranchProfile, ConditionProfile) */) {
                        ConstructArrayVarargsData s6_ = this.constructArrayVarargs_cache;
                        if (s6_ != null) {
                            if ((!(ConstructArrayNode.isOneNumberArg(arguments1Value__))) && (!(ConstructArrayNode.isOneForeignArg(arguments1Value__)))) {
                                return constructArrayVarargs(arguments0Value__, arguments1Value__, s6_.isIntegerCase_, s6_.isDoubleCase_, s6_.isObjectCase_, s6_.isLengthZero_);
                            }
                        }
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @TruffleBoundary
        private Object constructWithForeignArg1Boundary(int state, ConstructWithForeignArg1Data s5_, DynamicObject arguments0Value__, Object[] arguments1Value__) {
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(this);
            try {
                {
                    InteropLibrary interop__ = (INTEROP_LIBRARY_.getUncached(ConstructArrayNode.firstArg(arguments1Value__)));
                    return constructWithForeignArg(arguments0Value__, arguments1Value__, interop__, s5_.arrayCreateNode_, s5_.isNumber_, s5_.rangeErrorProfile_);
                }
            } finally {
                encapsulating_.set(prev_);
            }
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int exclude = exclude_;
            try {
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if (arguments1Value instanceof Object[]) {
                        Object[] arguments1Value_ = (Object[]) arguments1Value;
                        if ((arguments1Value_.length == 0)) {
                            this.state_ = state = state | 0b1 /* add-active constructArray0(DynamicObject, Object[]) */;
                            lock.unlock();
                            hasLock = false;
                            return constructArray0(arguments0Value_, arguments1Value_);
                        }
                        if (((exclude & 0b1)) == 0 /* is-not-excluded constructArrayWithIntLength(DynamicObject, Object[]) */) {
                            if ((ConstructArrayNode.isOneIntegerArg(arguments1Value_))) {
                                this.state_ = state = state | 0b10 /* add-active constructArrayWithIntLength(DynamicObject, Object[]) */;
                                lock.unlock();
                                hasLock = false;
                                return constructArrayWithIntLength(arguments0Value_, arguments1Value_);
                            }
                        }
                        {
                            long len__ = 0L;
                            if ((arguments1Value_.length == 1)) {
                                int count3_ = 0;
                                ConstructWithLengthData s3_ = this.constructWithLength_cache;
                                if ((state & 0b100) != 0 /* is-active constructWithLength(DynamicObject, Object[], ToArrayLengthNode, ArrayCreateNode, long) */) {
                                    while (s3_ != null) {
                                        {
                                            len__ = (s3_.toArrayLengthNode_.executeLong(ConstructArrayNode.firstArg(arguments1Value_)));
                                            if ((s3_.toArrayLengthNode_.isTypeNumber(len__))) {
                                                break;
                                            }
                                        }
                                        s3_ = s3_.next_;
                                        count3_++;
                                    }
                                }
                                if (s3_ == null) {
                                    {
                                        ToArrayLengthNode toArrayLengthNode__ = super.insert((ToArrayLengthNode.create()));
                                        len__ = (toArrayLengthNode__.executeLong(ConstructArrayNode.firstArg(arguments1Value_)));
                                        if ((toArrayLengthNode__.isTypeNumber(len__)) && count3_ < (3)) {
                                            s3_ = super.insert(new ConstructWithLengthData(constructWithLength_cache));
                                            s3_.toArrayLengthNode_ = s3_.insertAccessor(toArrayLengthNode__);
                                            s3_.arrayCreateNode_ = s3_.insertAccessor((ArrayCreateNode.create(getContext())));
                                            this.constructWithLength_cache = s3_;
                                            this.exclude_ = exclude = exclude | 0b1 /* add-excluded constructArrayWithIntLength(DynamicObject, Object[]) */;
                                            state = state & 0xfffffffd /* remove-active constructArrayWithIntLength(DynamicObject, Object[]) */;
                                            this.state_ = state = state | 0b100 /* add-active constructWithLength(DynamicObject, Object[], ToArrayLengthNode, ArrayCreateNode, long) */;
                                        }
                                    }
                                }
                                if (s3_ != null) {
                                    lock.unlock();
                                    hasLock = false;
                                    return constructWithLength(arguments0Value_, arguments1Value_, s3_.toArrayLengthNode_, s3_.arrayCreateNode_, len__);
                                }
                            }
                        }
                        if (((exclude & 0b10)) == 0 /* is-not-excluded constructWithForeignArg(DynamicObject, Object[], InteropLibrary, ArrayCreateNode, ConditionProfile, BranchProfile) */) {
                            int count4_ = 0;
                            ConstructWithForeignArg0Data s4_ = this.constructWithForeignArg0_cache;
                            if ((state & 0b1000) != 0 /* is-active constructWithForeignArg(DynamicObject, Object[], InteropLibrary, ArrayCreateNode, ConditionProfile, BranchProfile) */) {
                                while (s4_ != null) {
                                    if ((s4_.interop_.accepts(ConstructArrayNode.firstArg(arguments1Value_))) && (ConstructArrayNode.isOneForeignArg(arguments1Value_))) {
                                        break;
                                    }
                                    s4_ = s4_.next_;
                                    count4_++;
                                }
                            }
                            if (s4_ == null) {
                                if ((ConstructArrayNode.isOneForeignArg(arguments1Value_)) && count4_ < (3)) {
                                    // assert (s4_.interop_.accepts(ConstructArrayNode.firstArg(arguments1Value_)));
                                    s4_ = super.insert(new ConstructWithForeignArg0Data(constructWithForeignArg0_cache));
                                    s4_.interop_ = s4_.insertAccessor((INTEROP_LIBRARY_.create(ConstructArrayNode.firstArg(arguments1Value_))));
                                    s4_.arrayCreateNode_ = s4_.insertAccessor((ArrayCreateNode.create(getContext())));
                                    s4_.isNumber_ = (ConditionProfile.createBinaryProfile());
                                    s4_.rangeErrorProfile_ = (BranchProfile.create());
                                    this.constructWithForeignArg0_cache = s4_;
                                    this.state_ = state = state | 0b1000 /* add-active constructWithForeignArg(DynamicObject, Object[], InteropLibrary, ArrayCreateNode, ConditionProfile, BranchProfile) */;
                                }
                            }
                            if (s4_ != null) {
                                lock.unlock();
                                hasLock = false;
                                return constructWithForeignArg(arguments0Value_, arguments1Value_, s4_.interop_, s4_.arrayCreateNode_, s4_.isNumber_, s4_.rangeErrorProfile_);
                            }
                        }
                        {
                            InteropLibrary interop__ = null;
                            {
                                EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                                Node prev_ = encapsulating_.set(this);
                                try {
                                    if ((ConstructArrayNode.isOneForeignArg(arguments1Value_))) {
                                        ConstructWithForeignArg1Data s5_ = super.insert(new ConstructWithForeignArg1Data());
                                        interop__ = (INTEROP_LIBRARY_.getUncached(ConstructArrayNode.firstArg(arguments1Value_)));
                                        s5_.arrayCreateNode_ = s5_.insertAccessor((ArrayCreateNode.create(getContext())));
                                        s5_.isNumber_ = (ConditionProfile.createBinaryProfile());
                                        s5_.rangeErrorProfile_ = (BranchProfile.create());
                                        this.constructWithForeignArg1_cache = s5_;
                                        this.exclude_ = exclude = exclude | 0b10 /* add-excluded constructWithForeignArg(DynamicObject, Object[], InteropLibrary, ArrayCreateNode, ConditionProfile, BranchProfile) */;
                                        this.constructWithForeignArg0_cache = null;
                                        state = state & 0xfffffff7 /* remove-active constructWithForeignArg(DynamicObject, Object[], InteropLibrary, ArrayCreateNode, ConditionProfile, BranchProfile) */;
                                        this.state_ = state = state | 0b10000 /* add-active constructWithForeignArg(DynamicObject, Object[], InteropLibrary, ArrayCreateNode, ConditionProfile, BranchProfile) */;
                                        lock.unlock();
                                        hasLock = false;
                                        return constructWithForeignArg(arguments0Value_, arguments1Value_, interop__, s5_.arrayCreateNode_, s5_.isNumber_, s5_.rangeErrorProfile_);
                                    }
                                } finally {
                                    encapsulating_.set(prev_);
                                }
                            }
                        }
                        if ((!(ConstructArrayNode.isOneNumberArg(arguments1Value_))) && (!(ConstructArrayNode.isOneForeignArg(arguments1Value_)))) {
                            ConstructArrayVarargsData s6_ = new ConstructArrayVarargsData();
                            s6_.isIntegerCase_ = (BranchProfile.create());
                            s6_.isDoubleCase_ = (BranchProfile.create());
                            s6_.isObjectCase_ = (BranchProfile.create());
                            s6_.isLengthZero_ = (ConditionProfile.createBinaryProfile());
                            this.constructArrayVarargs_cache = s6_;
                            this.state_ = state = state | 0b100000 /* add-active constructArrayVarargs(DynamicObject, Object[], BranchProfile, BranchProfile, BranchProfile, ConditionProfile) */;
                            lock.unlock();
                            hasLock = false;
                            return constructArrayVarargs(arguments0Value_, arguments1Value_, s6_.isIntegerCase_, s6_.isDoubleCase_, s6_.isObjectCase_, s6_.isLengthZero_);
                        }
                    }
                }
                throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_}, arguments0Value, arguments1Value);
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
                ConstructWithLengthData s3_ = this.constructWithLength_cache;
                ConstructWithForeignArg0Data s4_ = this.constructWithForeignArg0_cache;
                if ((s3_ == null || s3_.next_ == null) && (s4_ == null || s4_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[7];
            Object[] s;
            data[0] = 0;
            int state = state_;
            int exclude = exclude_;
            s = new Object[3];
            s[0] = "constructArray0";
            if ((state & 0b1) != 0 /* is-active constructArray0(DynamicObject, Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "constructArrayWithIntLength";
            if ((state & 0b10) != 0 /* is-active constructArrayWithIntLength(DynamicObject, Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else if ((exclude & 0b1) != 0 /* is-excluded constructArrayWithIntLength(DynamicObject, Object[]) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "constructWithLength";
            if ((state & 0b100) != 0 /* is-active constructWithLength(DynamicObject, Object[], ToArrayLengthNode, ArrayCreateNode, long) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                ConstructWithLengthData s3_ = this.constructWithLength_cache;
                while (s3_ != null) {
                    cached.add(Arrays.asList(s3_.toArrayLengthNode_, s3_.arrayCreateNode_));
                    s3_ = s3_.next_;
                }
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "constructWithForeignArg";
            if ((state & 0b1000) != 0 /* is-active constructWithForeignArg(DynamicObject, Object[], InteropLibrary, ArrayCreateNode, ConditionProfile, BranchProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                ConstructWithForeignArg0Data s4_ = this.constructWithForeignArg0_cache;
                while (s4_ != null) {
                    cached.add(Arrays.asList(s4_.interop_, s4_.arrayCreateNode_, s4_.isNumber_, s4_.rangeErrorProfile_));
                    s4_ = s4_.next_;
                }
                s[2] = cached;
            } else if ((exclude & 0b10) != 0 /* is-excluded constructWithForeignArg(DynamicObject, Object[], InteropLibrary, ArrayCreateNode, ConditionProfile, BranchProfile) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            s = new Object[3];
            s[0] = "constructWithForeignArg";
            if ((state & 0b10000) != 0 /* is-active constructWithForeignArg(DynamicObject, Object[], InteropLibrary, ArrayCreateNode, ConditionProfile, BranchProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                ConstructWithForeignArg1Data s5_ = this.constructWithForeignArg1_cache;
                if (s5_ != null) {
                    cached.add(Arrays.asList(s5_.arrayCreateNode_, s5_.isNumber_, s5_.rangeErrorProfile_));
                }
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[5] = s;
            s = new Object[3];
            s[0] = "constructArrayVarargs";
            if ((state & 0b100000) != 0 /* is-active constructArrayVarargs(DynamicObject, Object[], BranchProfile, BranchProfile, BranchProfile, ConditionProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                ConstructArrayVarargsData s6_ = this.constructArrayVarargs_cache;
                if (s6_ != null) {
                    cached.add(Arrays.asList(s6_.isIntegerCase_, s6_.isDoubleCase_, s6_.isObjectCase_, s6_.isLengthZero_));
                }
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[6] = s;
            return Provider.create(data);
        }

        public static ConstructArrayNode create(JSContext context, JSBuiltin builtin, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            return new ConstructArrayNodeGen(context, builtin, isNewTargetCase, arguments);
        }

        @GeneratedBy(ConstructArrayNode.class)
        private static final class ConstructWithLengthData extends Node {

            @Child ConstructWithLengthData next_;
            @Child ToArrayLengthNode toArrayLengthNode_;
            @Child ArrayCreateNode arrayCreateNode_;

            ConstructWithLengthData(ConstructWithLengthData next_) {
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
        @GeneratedBy(ConstructArrayNode.class)
        private static final class ConstructWithForeignArg0Data extends Node {

            @Child ConstructWithForeignArg0Data next_;
            @Child InteropLibrary interop_;
            @Child ArrayCreateNode arrayCreateNode_;
            @CompilationFinal ConditionProfile isNumber_;
            @CompilationFinal BranchProfile rangeErrorProfile_;

            ConstructWithForeignArg0Data(ConstructWithForeignArg0Data next_) {
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
        @GeneratedBy(ConstructArrayNode.class)
        private static final class ConstructWithForeignArg1Data extends Node {

            @Child ArrayCreateNode arrayCreateNode_;
            @CompilationFinal ConditionProfile isNumber_;
            @CompilationFinal BranchProfile rangeErrorProfile_;

            ConstructWithForeignArg1Data() {
            }

            @Override
            public NodeCost getCost() {
                return NodeCost.NONE;
            }

            <T extends Node> T insertAccessor(T node) {
                return super.insert(node);
            }

        }
        @GeneratedBy(ConstructArrayNode.class)
        private static final class ConstructArrayVarargsData {

            @CompilationFinal BranchProfile isIntegerCase_;
            @CompilationFinal BranchProfile isDoubleCase_;
            @CompilationFinal BranchProfile isObjectCase_;
            @CompilationFinal ConditionProfile isLengthZero_;

            ConstructArrayVarargsData() {
            }

        }
    }
    @GeneratedBy(CallBooleanNode.class)
    public static final class CallBooleanNodeGen extends CallBooleanNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_;
        @Child private JSToBooleanNode toBoolean_;

        private CallBooleanNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if (state != 0 /* is-active callBoolean(Object, JSToBooleanNode) */) {
                return callBoolean(arguments0Value_, this.toBoolean_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if (state != 0 /* is-active callBoolean(Object, JSToBooleanNode) */) {
                return callBoolean(arguments0Value_, this.toBoolean_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            executeBoolean(frameValue);
            return;
        }

        private boolean executeAndSpecialize(Object arguments0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            try {
                this.toBoolean_ = super.insert((JSToBooleanNode.create()));
                this.state_ = state = state | 0b1 /* add-active callBoolean(Object, JSToBooleanNode) */;
                lock.unlock();
                hasLock = false;
                return callBoolean(arguments0Value, this.toBoolean_);
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

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "callBoolean";
            if (state != 0 /* is-active callBoolean(Object, JSToBooleanNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.toBoolean_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static CallBooleanNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new CallBooleanNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ConstructBooleanNode.class)
    public static final class ConstructBooleanNodeGen extends ConstructBooleanNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_;
        @Child private JSToBooleanNode toBoolean_;

        private ConstructBooleanNodeGen(JSContext context, JSBuiltin builtin, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, isNewTargetCase);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if (state != 0 /* is-active constructBoolean(DynamicObject, Object, JSToBooleanNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                return constructBoolean(arguments0Value__, arguments1Value_, this.toBoolean_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            try {
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    this.toBoolean_ = super.insert((JSToBooleanNode.create()));
                    this.state_ = state = state | 0b1 /* add-active constructBoolean(DynamicObject, Object, JSToBooleanNode) */;
                    lock.unlock();
                    hasLock = false;
                    return constructBoolean(arguments0Value_, arguments1Value, this.toBoolean_);
                }
                throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_}, arguments0Value, arguments1Value);
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

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "constructBoolean";
            if (state != 0 /* is-active constructBoolean(DynamicObject, Object, JSToBooleanNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.toBoolean_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static ConstructBooleanNode create(JSContext context, JSBuiltin builtin, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            return new ConstructBooleanNodeGen(context, builtin, isNewTargetCase, arguments);
        }

    }
    @GeneratedBy(CallDateNode.class)
    public static final class CallDateNodeGen extends CallDateNode implements Provider {

        private CallDateNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            return callDate();
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.MONOMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            s = new Object[3];
            s[0] = "callDate";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static CallDateNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new CallDateNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ConstructDateNode.class)
    public static final class ConstructDateNodeGen extends ConstructDateNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_;
        @CompilationFinal private ConditionProfile constructDateOne_isSpecialCase_;
        @Child private InteropLibrary constructDateOne_interop_;

        private ConstructDateNodeGen(JSContext context, JSBuiltin builtin, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, isNewTargetCase);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if (state != 0 /* is-active constructDateZero(DynamicObject, Object[]) || constructDateOne(DynamicObject, Object[], ConditionProfile, InteropLibrary) || constructDateMult(DynamicObject, Object[]) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if (arguments1Value_ instanceof Object[]) {
                    Object[] arguments1Value__ = (Object[]) arguments1Value_;
                    if ((state & 0b1) != 0 /* is-active constructDateZero(DynamicObject, Object[]) */) {
                        if ((arguments1Value__.length == 0)) {
                            return constructDateZero(arguments0Value__, arguments1Value__);
                        }
                    }
                    if ((state & 0b10) != 0 /* is-active constructDateOne(DynamicObject, Object[], ConditionProfile, InteropLibrary) */) {
                        if ((arguments1Value__.length == 1)) {
                            return constructDateOne(arguments0Value__, arguments1Value__, this.constructDateOne_isSpecialCase_, this.constructDateOne_interop_);
                        }
                    }
                    if ((state & 0b100) != 0 /* is-active constructDateMult(DynamicObject, Object[]) */) {
                        if ((arguments1Value__.length >= 2)) {
                            return constructDateMult(arguments0Value__, arguments1Value__);
                        }
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            try {
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if (arguments1Value instanceof Object[]) {
                        Object[] arguments1Value_ = (Object[]) arguments1Value;
                        if ((arguments1Value_.length == 0)) {
                            this.state_ = state = state | 0b1 /* add-active constructDateZero(DynamicObject, Object[]) */;
                            lock.unlock();
                            hasLock = false;
                            return constructDateZero(arguments0Value_, arguments1Value_);
                        }
                        if ((arguments1Value_.length == 1)) {
                            this.constructDateOne_isSpecialCase_ = (ConditionProfile.createBinaryProfile());
                            this.constructDateOne_interop_ = super.insert((INTEROP_LIBRARY_.createDispatched(3)));
                            this.state_ = state = state | 0b10 /* add-active constructDateOne(DynamicObject, Object[], ConditionProfile, InteropLibrary) */;
                            lock.unlock();
                            hasLock = false;
                            return constructDateOne(arguments0Value_, arguments1Value_, this.constructDateOne_isSpecialCase_, this.constructDateOne_interop_);
                        }
                        if ((arguments1Value_.length >= 2)) {
                            this.state_ = state = state | 0b100 /* add-active constructDateMult(DynamicObject, Object[]) */;
                            lock.unlock();
                            hasLock = false;
                            return constructDateMult(arguments0Value_, arguments1Value_);
                        }
                    }
                }
                throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_}, arguments0Value, arguments1Value);
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
            s = new Object[3];
            s[0] = "constructDateZero";
            if ((state & 0b1) != 0 /* is-active constructDateZero(DynamicObject, Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "constructDateOne";
            if ((state & 0b10) != 0 /* is-active constructDateOne(DynamicObject, Object[], ConditionProfile, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.constructDateOne_isSpecialCase_, this.constructDateOne_interop_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "constructDateMult";
            if ((state & 0b100) != 0 /* is-active constructDateMult(DynamicObject, Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static ConstructDateNode create(JSContext context, JSBuiltin builtin, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            return new ConstructDateNodeGen(context, builtin, isNewTargetCase, arguments);
        }

    }
    @GeneratedBy(ConstructRegExpNode.class)
    public static final class ConstructRegExpNodeGen extends ConstructRegExpNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private volatile int state_;
        @Child private IsRegExpNode isRegExpNode_;

        private ConstructRegExpNodeGen(JSContext context, JSBuiltin builtin, boolean isCall, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, isCall, isNewTargetCase);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
            this.arguments2_ = arguments != null && 2 < arguments.length ? arguments[2] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_, this.arguments2_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if (state != 0 /* is-active constructRegExp(DynamicObject, Object, Object, IsRegExpNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                return constructRegExp(arguments0Value__, arguments1Value_, arguments2Value_, this.isRegExpNode_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            try {
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    this.isRegExpNode_ = super.insert((IsRegExpNode.create(getContext())));
                    this.state_ = state = state | 0b1 /* add-active constructRegExp(DynamicObject, Object, Object, IsRegExpNode) */;
                    lock.unlock();
                    hasLock = false;
                    return constructRegExp(arguments0Value_, arguments1Value, arguments2Value, this.isRegExpNode_);
                }
                throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_, this.arguments2_}, arguments0Value, arguments1Value, arguments2Value);
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

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "constructRegExp";
            if (state != 0 /* is-active constructRegExp(DynamicObject, Object, Object, IsRegExpNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.isRegExpNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static ConstructRegExpNode create(JSContext context, JSBuiltin builtin, boolean isCall, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            return new ConstructRegExpNodeGen(context, builtin, isCall, isNewTargetCase, arguments);
        }

    }
    @GeneratedBy(CallStringNode.class)
    public static final class CallStringNodeGen extends CallStringNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_;
        @Child private JSToStringNode callStringGeneric_toStringNode_;

        private CallStringNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if (state != 0 /* is-active callStringInt0(Object[]) || callStringGeneric(Object[], JSToStringNode) */ && arguments0Value_ instanceof Object[]) {
                Object[] arguments0Value__ = (Object[]) arguments0Value_;
                if ((state & 0b1) != 0 /* is-active callStringInt0(Object[]) */) {
                    if ((arguments0Value__.length == 0)) {
                        return callStringInt0(arguments0Value__);
                    }
                }
                if ((state & 0b10) != 0 /* is-active callStringGeneric(Object[], JSToStringNode) */) {
                    if ((arguments0Value__.length != 0)) {
                        return callStringGeneric(arguments0Value__, this.callStringGeneric_toStringNode_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private String executeAndSpecialize(Object arguments0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            try {
                if (arguments0Value instanceof Object[]) {
                    Object[] arguments0Value_ = (Object[]) arguments0Value;
                    if ((arguments0Value_.length == 0)) {
                        this.state_ = state = state | 0b1 /* add-active callStringInt0(Object[]) */;
                        lock.unlock();
                        hasLock = false;
                        return callStringInt0(arguments0Value_);
                    }
                    if ((arguments0Value_.length != 0)) {
                        this.callStringGeneric_toStringNode_ = super.insert((JSToStringNode.createSymbolToString()));
                        this.state_ = state = state | 0b10 /* add-active callStringGeneric(Object[], JSToStringNode) */;
                        lock.unlock();
                        hasLock = false;
                        return callStringGeneric(arguments0Value_, this.callStringGeneric_toStringNode_);
                    }
                }
                throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_}, arguments0Value);
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
            Object[] data = new Object[3];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "callStringInt0";
            if ((state & 0b1) != 0 /* is-active callStringInt0(Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "callStringGeneric";
            if ((state & 0b10) != 0 /* is-active callStringGeneric(Object[], JSToStringNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.callStringGeneric_toStringNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static CallStringNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new CallStringNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ConstructStringNode.class)
    public static final class ConstructStringNodeGen extends ConstructStringNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_;
        @Child private JSToStringNode constructString_toStringNode_;

        private ConstructStringNodeGen(JSContext context, JSBuiltin builtin, boolean newTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, newTargetCase);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if (state != 0 /* is-active constructStringInt0(DynamicObject, Object[]) || constructString(DynamicObject, Object[], JSToStringNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if (arguments1Value_ instanceof Object[]) {
                    Object[] arguments1Value__ = (Object[]) arguments1Value_;
                    if ((state & 0b1) != 0 /* is-active constructStringInt0(DynamicObject, Object[]) */) {
                        if ((arguments1Value__.length == 0)) {
                            return constructStringInt0(arguments0Value__, arguments1Value__);
                        }
                    }
                    if ((state & 0b10) != 0 /* is-active constructString(DynamicObject, Object[], JSToStringNode) */) {
                        if ((arguments1Value__.length != 0)) {
                            return constructString(arguments0Value__, arguments1Value__, this.constructString_toStringNode_);
                        }
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            try {
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if (arguments1Value instanceof Object[]) {
                        Object[] arguments1Value_ = (Object[]) arguments1Value;
                        if ((arguments1Value_.length == 0)) {
                            this.state_ = state = state | 0b1 /* add-active constructStringInt0(DynamicObject, Object[]) */;
                            lock.unlock();
                            hasLock = false;
                            return constructStringInt0(arguments0Value_, arguments1Value_);
                        }
                        if ((arguments1Value_.length != 0)) {
                            this.constructString_toStringNode_ = super.insert((JSToStringNode.create()));
                            this.state_ = state = state | 0b10 /* add-active constructString(DynamicObject, Object[], JSToStringNode) */;
                            lock.unlock();
                            hasLock = false;
                            return constructString(arguments0Value_, arguments1Value_, this.constructString_toStringNode_);
                        }
                    }
                }
                throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_}, arguments0Value, arguments1Value);
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
            Object[] data = new Object[3];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "constructStringInt0";
            if ((state & 0b1) != 0 /* is-active constructStringInt0(DynamicObject, Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "constructString";
            if ((state & 0b10) != 0 /* is-active constructString(DynamicObject, Object[], JSToStringNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.constructString_toStringNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static ConstructStringNode create(JSContext context, JSBuiltin builtin, boolean newTargetCase, JavaScriptNode[] arguments) {
            return new ConstructStringNodeGen(context, builtin, newTargetCase, arguments);
        }

    }
    @GeneratedBy(ConstructWeakRefNode.class)
    public static final class ConstructWeakRefNodeGen extends ConstructWeakRefNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private int state_;

        private ConstructWeakRefNodeGen(JSContext context, JSBuiltin builtin, boolean newTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, newTargetCase);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if (state != 0 /* is-active constructWeakRef(DynamicObject, Object) || constructWeakRefNonObject(DynamicObject, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state & 0b1) != 0 /* is-active constructWeakRef(DynamicObject, Object) */) {
                    if ((JSGuards.isJSObject(arguments1Value_))) {
                        return constructWeakRef(arguments0Value__, arguments1Value_);
                    }
                }
                if ((state & 0b10) != 0 /* is-active constructWeakRefNonObject(DynamicObject, Object) */) {
                    if ((!(JSGuards.isJSObject(arguments1Value_)))) {
                        return constructWeakRefNonObject(arguments0Value__, arguments1Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            int state = state_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((JSGuards.isJSObject(arguments1Value))) {
                    this.state_ = state = state | 0b1 /* add-active constructWeakRef(DynamicObject, Object) */;
                    return constructWeakRef(arguments0Value_, arguments1Value);
                }
                if ((!(JSGuards.isJSObject(arguments1Value)))) {
                    this.state_ = state = state | 0b10 /* add-active constructWeakRefNonObject(DynamicObject, Object) */;
                    return constructWeakRefNonObject(arguments0Value_, arguments1Value);
                }
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_}, arguments0Value, arguments1Value);
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
            Object[] data = new Object[3];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "constructWeakRef";
            if ((state & 0b1) != 0 /* is-active constructWeakRef(DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "constructWeakRefNonObject";
            if ((state & 0b10) != 0 /* is-active constructWeakRefNonObject(DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static ConstructWeakRefNode create(JSContext context, JSBuiltin builtin, boolean newTargetCase, JavaScriptNode[] arguments) {
            return new ConstructWeakRefNodeGen(context, builtin, newTargetCase, arguments);
        }

    }
    @GeneratedBy(ConstructFinalizationRegistryNode.class)
    public static final class ConstructFinalizationRegistryNodeGen extends ConstructFinalizationRegistryNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private int state_;

        private ConstructFinalizationRegistryNodeGen(JSContext context, JSBuiltin builtin, boolean newTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, newTargetCase);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if (state != 0 /* is-active constructFinalizationRegistry(DynamicObject, TruffleObject) || constructFinalizationRegistryNonObject(DynamicObject, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state & 0b1) != 0 /* is-active constructFinalizationRegistry(DynamicObject, TruffleObject) */ && arguments1Value_ instanceof TruffleObject) {
                    TruffleObject arguments1Value__ = (TruffleObject) arguments1Value_;
                    if ((JSGuards.isCallable(arguments1Value__))) {
                        return constructFinalizationRegistry(arguments0Value__, arguments1Value__);
                    }
                }
                if ((state & 0b10) != 0 /* is-active constructFinalizationRegistryNonObject(DynamicObject, Object) */) {
                    if ((!(JSGuards.isCallable(arguments1Value_)))) {
                        return constructFinalizationRegistryNonObject(arguments0Value__, arguments1Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            int state = state_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if (arguments1Value instanceof TruffleObject) {
                    TruffleObject arguments1Value_ = (TruffleObject) arguments1Value;
                    if ((JSGuards.isCallable(arguments1Value_))) {
                        this.state_ = state = state | 0b1 /* add-active constructFinalizationRegistry(DynamicObject, TruffleObject) */;
                        return constructFinalizationRegistry(arguments0Value_, arguments1Value_);
                    }
                }
                if ((!(JSGuards.isCallable(arguments1Value)))) {
                    this.state_ = state = state | 0b10 /* add-active constructFinalizationRegistryNonObject(DynamicObject, Object) */;
                    return constructFinalizationRegistryNonObject(arguments0Value_, arguments1Value);
                }
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_}, arguments0Value, arguments1Value);
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
            Object[] data = new Object[3];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "constructFinalizationRegistry";
            if ((state & 0b1) != 0 /* is-active constructFinalizationRegistry(DynamicObject, TruffleObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "constructFinalizationRegistryNonObject";
            if ((state & 0b10) != 0 /* is-active constructFinalizationRegistryNonObject(DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static ConstructFinalizationRegistryNode create(JSContext context, JSBuiltin builtin, boolean newTargetCase, JavaScriptNode[] arguments) {
            return new ConstructFinalizationRegistryNodeGen(context, builtin, newTargetCase, arguments);
        }

    }
    @GeneratedBy(CallCollatorNode.class)
    public static final class CallCollatorNodeGen extends CallCollatorNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;

        private CallCollatorNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            return callCollator(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.MONOMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            s = new Object[3];
            s[0] = "callCollator";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static CallCollatorNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new CallCollatorNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ConstructCollatorNode.class)
    public static final class ConstructCollatorNodeGen extends ConstructCollatorNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private int state_;

        private ConstructCollatorNodeGen(JSContext context, JSBuiltin builtin, boolean newTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, newTargetCase);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
            this.arguments2_ = arguments != null && 2 < arguments.length ? arguments[2] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_, this.arguments2_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if (state != 0 /* is-active constructCollator(DynamicObject, Object, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                return constructCollator(arguments0Value__, arguments1Value_, arguments2Value_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            int state = state_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                this.state_ = state = state | 0b1 /* add-active constructCollator(DynamicObject, Object, Object) */;
                return constructCollator(arguments0Value_, arguments1Value, arguments2Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_, this.arguments2_}, arguments0Value, arguments1Value, arguments2Value);
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

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "constructCollator";
            if (state != 0 /* is-active constructCollator(DynamicObject, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static ConstructCollatorNode create(JSContext context, JSBuiltin builtin, boolean newTargetCase, JavaScriptNode[] arguments) {
            return new ConstructCollatorNodeGen(context, builtin, newTargetCase, arguments);
        }

    }
    @GeneratedBy(ConstructListFormatNode.class)
    public static final class ConstructListFormatNodeGen extends ConstructListFormatNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private int state_;

        private ConstructListFormatNodeGen(JSContext context, JSBuiltin builtin, boolean newTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, newTargetCase);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
            this.arguments2_ = arguments != null && 2 < arguments.length ? arguments[2] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_, this.arguments2_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if (state != 0 /* is-active constructListFormat(DynamicObject, Object, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                return constructListFormat(arguments0Value__, arguments1Value_, arguments2Value_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            int state = state_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                this.state_ = state = state | 0b1 /* add-active constructListFormat(DynamicObject, Object, Object) */;
                return constructListFormat(arguments0Value_, arguments1Value, arguments2Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_, this.arguments2_}, arguments0Value, arguments1Value, arguments2Value);
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

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "constructListFormat";
            if (state != 0 /* is-active constructListFormat(DynamicObject, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static ConstructListFormatNode create(JSContext context, JSBuiltin builtin, boolean newTargetCase, JavaScriptNode[] arguments) {
            return new ConstructListFormatNodeGen(context, builtin, newTargetCase, arguments);
        }

    }
    @GeneratedBy(ConstructRelativeTimeFormatNode.class)
    public static final class ConstructRelativeTimeFormatNodeGen extends ConstructRelativeTimeFormatNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private int state_;

        private ConstructRelativeTimeFormatNodeGen(JSContext context, JSBuiltin builtin, boolean newTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, newTargetCase);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
            this.arguments2_ = arguments != null && 2 < arguments.length ? arguments[2] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_, this.arguments2_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if (state != 0 /* is-active constructRelativeTimeFormat(DynamicObject, Object, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                return constructRelativeTimeFormat(arguments0Value__, arguments1Value_, arguments2Value_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            int state = state_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                this.state_ = state = state | 0b1 /* add-active constructRelativeTimeFormat(DynamicObject, Object, Object) */;
                return constructRelativeTimeFormat(arguments0Value_, arguments1Value, arguments2Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_, this.arguments2_}, arguments0Value, arguments1Value, arguments2Value);
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

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "constructRelativeTimeFormat";
            if (state != 0 /* is-active constructRelativeTimeFormat(DynamicObject, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static ConstructRelativeTimeFormatNode create(JSContext context, JSBuiltin builtin, boolean newTargetCase, JavaScriptNode[] arguments) {
            return new ConstructRelativeTimeFormatNodeGen(context, builtin, newTargetCase, arguments);
        }

    }
    @GeneratedBy(ConstructSegmenterNode.class)
    public static final class ConstructSegmenterNodeGen extends ConstructSegmenterNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private int state_;

        private ConstructSegmenterNodeGen(JSContext context, JSBuiltin builtin, boolean newTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, newTargetCase);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
            this.arguments2_ = arguments != null && 2 < arguments.length ? arguments[2] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_, this.arguments2_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if (state != 0 /* is-active constructSegmenter(DynamicObject, Object, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                return constructSegmenter(arguments0Value__, arguments1Value_, arguments2Value_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            int state = state_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                this.state_ = state = state | 0b1 /* add-active constructSegmenter(DynamicObject, Object, Object) */;
                return constructSegmenter(arguments0Value_, arguments1Value, arguments2Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_, this.arguments2_}, arguments0Value, arguments1Value, arguments2Value);
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

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "constructSegmenter";
            if (state != 0 /* is-active constructSegmenter(DynamicObject, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static ConstructSegmenterNode create(JSContext context, JSBuiltin builtin, boolean newTargetCase, JavaScriptNode[] arguments) {
            return new ConstructSegmenterNodeGen(context, builtin, newTargetCase, arguments);
        }

    }
    @GeneratedBy(ConstructDisplayNamesNode.class)
    public static final class ConstructDisplayNamesNodeGen extends ConstructDisplayNamesNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private int state_;

        private ConstructDisplayNamesNodeGen(JSContext context, JSBuiltin builtin, boolean newTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, newTargetCase);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
            this.arguments2_ = arguments != null && 2 < arguments.length ? arguments[2] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_, this.arguments2_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if (state != 0 /* is-active constructDisplayNames(DynamicObject, Object, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                return constructDisplayNames(arguments0Value__, arguments1Value_, arguments2Value_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            int state = state_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                this.state_ = state = state | 0b1 /* add-active constructDisplayNames(DynamicObject, Object, Object) */;
                return constructDisplayNames(arguments0Value_, arguments1Value, arguments2Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_, this.arguments2_}, arguments0Value, arguments1Value, arguments2Value);
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

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "constructDisplayNames";
            if (state != 0 /* is-active constructDisplayNames(DynamicObject, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static ConstructDisplayNamesNode create(JSContext context, JSBuiltin builtin, boolean newTargetCase, JavaScriptNode[] arguments) {
            return new ConstructDisplayNamesNodeGen(context, builtin, newTargetCase, arguments);
        }

    }
    @GeneratedBy(ConstructLocaleNode.class)
    public static final class ConstructLocaleNodeGen extends ConstructLocaleNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private int state_;

        private ConstructLocaleNodeGen(JSContext context, JSBuiltin builtin, boolean newTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, newTargetCase);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
            this.arguments2_ = arguments != null && 2 < arguments.length ? arguments[2] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_, this.arguments2_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if (state != 0 /* is-active constructLocale(DynamicObject, Object, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                return constructLocale(arguments0Value__, arguments1Value_, arguments2Value_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            int state = state_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                this.state_ = state = state | 0b1 /* add-active constructLocale(DynamicObject, Object, Object) */;
                return constructLocale(arguments0Value_, arguments1Value, arguments2Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_, this.arguments2_}, arguments0Value, arguments1Value, arguments2Value);
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

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "constructLocale";
            if (state != 0 /* is-active constructLocale(DynamicObject, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static ConstructLocaleNode create(JSContext context, JSBuiltin builtin, boolean newTargetCase, JavaScriptNode[] arguments) {
            return new ConstructLocaleNodeGen(context, builtin, newTargetCase, arguments);
        }

    }
    @GeneratedBy(CallNumberFormatNode.class)
    public static final class CallNumberFormatNodeGen extends CallNumberFormatNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;

        private CallNumberFormatNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            return callNumberFormat(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.MONOMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            s = new Object[3];
            s[0] = "callNumberFormat";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static CallNumberFormatNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new CallNumberFormatNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ConstructNumberFormatNode.class)
    public static final class ConstructNumberFormatNodeGen extends ConstructNumberFormatNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private int state_;

        private ConstructNumberFormatNodeGen(JSContext context, JSBuiltin builtin, boolean newTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, newTargetCase);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
            this.arguments2_ = arguments != null && 2 < arguments.length ? arguments[2] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_, this.arguments2_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if (state != 0 /* is-active constructNumberFormat(DynamicObject, Object, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                return constructNumberFormat(arguments0Value__, arguments1Value_, arguments2Value_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            int state = state_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                this.state_ = state = state | 0b1 /* add-active constructNumberFormat(DynamicObject, Object, Object) */;
                return constructNumberFormat(arguments0Value_, arguments1Value, arguments2Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_, this.arguments2_}, arguments0Value, arguments1Value, arguments2Value);
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

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "constructNumberFormat";
            if (state != 0 /* is-active constructNumberFormat(DynamicObject, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static ConstructNumberFormatNode create(JSContext context, JSBuiltin builtin, boolean newTargetCase, JavaScriptNode[] arguments) {
            return new ConstructNumberFormatNodeGen(context, builtin, newTargetCase, arguments);
        }

    }
    @GeneratedBy(ConstructPluralRulesNode.class)
    public static final class ConstructPluralRulesNodeGen extends ConstructPluralRulesNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private int state_;

        private ConstructPluralRulesNodeGen(JSContext context, JSBuiltin builtin, boolean newTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, newTargetCase);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
            this.arguments2_ = arguments != null && 2 < arguments.length ? arguments[2] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_, this.arguments2_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if (state != 0 /* is-active constructPluralRules(DynamicObject, Object, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                return constructPluralRules(arguments0Value__, arguments1Value_, arguments2Value_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            int state = state_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                this.state_ = state = state | 0b1 /* add-active constructPluralRules(DynamicObject, Object, Object) */;
                return constructPluralRules(arguments0Value_, arguments1Value, arguments2Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_, this.arguments2_}, arguments0Value, arguments1Value, arguments2Value);
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

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "constructPluralRules";
            if (state != 0 /* is-active constructPluralRules(DynamicObject, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static ConstructPluralRulesNode create(JSContext context, JSBuiltin builtin, boolean newTargetCase, JavaScriptNode[] arguments) {
            return new ConstructPluralRulesNodeGen(context, builtin, newTargetCase, arguments);
        }

    }
    @GeneratedBy(CallDateTimeFormatNode.class)
    public static final class CallDateTimeFormatNodeGen extends CallDateTimeFormatNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;

        private CallDateTimeFormatNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            return callDateTimeFormat(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.MONOMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            s = new Object[3];
            s[0] = "callDateTimeFormat";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static CallDateTimeFormatNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new CallDateTimeFormatNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ConstructDateTimeFormatNode.class)
    public static final class ConstructDateTimeFormatNodeGen extends ConstructDateTimeFormatNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private int state_;

        private ConstructDateTimeFormatNodeGen(JSContext context, JSBuiltin builtin, boolean newTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, newTargetCase);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
            this.arguments2_ = arguments != null && 2 < arguments.length ? arguments[2] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_, this.arguments2_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if (state != 0 /* is-active constructDateTimeFormat(DynamicObject, Object, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                return constructDateTimeFormat(arguments0Value__, arguments1Value_, arguments2Value_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            int state = state_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                this.state_ = state = state | 0b1 /* add-active constructDateTimeFormat(DynamicObject, Object, Object) */;
                return constructDateTimeFormat(arguments0Value_, arguments1Value, arguments2Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_, this.arguments2_}, arguments0Value, arguments1Value, arguments2Value);
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

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "constructDateTimeFormat";
            if (state != 0 /* is-active constructDateTimeFormat(DynamicObject, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static ConstructDateTimeFormatNode create(JSContext context, JSBuiltin builtin, boolean newTargetCase, JavaScriptNode[] arguments) {
            return new ConstructDateTimeFormatNodeGen(context, builtin, newTargetCase, arguments);
        }

    }
    @GeneratedBy(ConstructObjectNode.class)
    public static final class ConstructObjectNodeGen extends ConstructObjectNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_;
        @Child private JSToObjectNode constructObjectJSObject_toObjectNode_;

        private ConstructObjectNodeGen(JSContext context, JSBuiltin builtin, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, isNewTargetCase);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if (state != 0 /* is-active constructObjectNewTarget(DynamicObject, Object[]) || constructObject0(DynamicObject, Object[]) || constructObjectJSObject(DynamicObject, Object[], JSToObjectNode) || constructObjectNullOrUndefined(DynamicObject, Object[]) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if (arguments1Value_ instanceof Object[]) {
                    Object[] arguments1Value__ = (Object[]) arguments1Value_;
                    if ((state & 0b1) != 0 /* is-active constructObjectNewTarget(DynamicObject, Object[]) */) {
                        assert (isNewTargetCase);
                        return constructObjectNewTarget(arguments0Value__, arguments1Value__);
                    }
                    if ((state & 0b10) != 0 /* is-active constructObject0(DynamicObject, Object[]) */) {
                        if ((arguments1Value__.length == 0)) {
                            return constructObject0(arguments0Value__, arguments1Value__);
                        }
                    }
                    if ((state & 0b100) != 0 /* is-active constructObjectJSObject(DynamicObject, Object[], JSToObjectNode) */) {
                        assert (!(isNewTargetCase));
                        if ((arguments1Value__.length > 0) && (!(ConstructObjectNode.arg0NullOrUndefined(arguments1Value__)))) {
                            return constructObjectJSObject(arguments0Value__, arguments1Value__, this.constructObjectJSObject_toObjectNode_);
                        }
                    }
                    if ((state & 0b1000) != 0 /* is-active constructObjectNullOrUndefined(DynamicObject, Object[]) */) {
                        if ((arguments1Value__.length > 0) && (ConstructObjectNode.arg0NullOrUndefined(arguments1Value__))) {
                            return constructObjectNullOrUndefined(arguments0Value__, arguments1Value__);
                        }
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private Object executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            try {
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if (arguments1Value instanceof Object[]) {
                        Object[] arguments1Value_ = (Object[]) arguments1Value;
                        if ((isNewTargetCase)) {
                            this.state_ = state = state | 0b1 /* add-active constructObjectNewTarget(DynamicObject, Object[]) */;
                            lock.unlock();
                            hasLock = false;
                            return constructObjectNewTarget(arguments0Value_, arguments1Value_);
                        }
                        if ((arguments1Value_.length == 0)) {
                            this.state_ = state = state | 0b10 /* add-active constructObject0(DynamicObject, Object[]) */;
                            lock.unlock();
                            hasLock = false;
                            return constructObject0(arguments0Value_, arguments1Value_);
                        }
                        if ((!(isNewTargetCase)) && (arguments1Value_.length > 0) && (!(ConstructObjectNode.arg0NullOrUndefined(arguments1Value_)))) {
                            this.constructObjectJSObject_toObjectNode_ = super.insert((JSToObjectNode.createToObject(getContext())));
                            this.state_ = state = state | 0b100 /* add-active constructObjectJSObject(DynamicObject, Object[], JSToObjectNode) */;
                            lock.unlock();
                            hasLock = false;
                            return constructObjectJSObject(arguments0Value_, arguments1Value_, this.constructObjectJSObject_toObjectNode_);
                        }
                        if ((arguments1Value_.length > 0) && (ConstructObjectNode.arg0NullOrUndefined(arguments1Value_))) {
                            this.state_ = state = state | 0b1000 /* add-active constructObjectNullOrUndefined(DynamicObject, Object[]) */;
                            lock.unlock();
                            hasLock = false;
                            return constructObjectNullOrUndefined(arguments0Value_, arguments1Value_);
                        }
                    }
                }
                throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_}, arguments0Value, arguments1Value);
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
            Object[] data = new Object[5];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "constructObjectNewTarget";
            if ((state & 0b1) != 0 /* is-active constructObjectNewTarget(DynamicObject, Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "constructObject0";
            if ((state & 0b10) != 0 /* is-active constructObject0(DynamicObject, Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "constructObjectJSObject";
            if ((state & 0b100) != 0 /* is-active constructObjectJSObject(DynamicObject, Object[], JSToObjectNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.constructObjectJSObject_toObjectNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "constructObjectNullOrUndefined";
            if ((state & 0b1000) != 0 /* is-active constructObjectNullOrUndefined(DynamicObject, Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            return Provider.create(data);
        }

        public static ConstructObjectNode create(JSContext context, JSBuiltin builtin, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            return new ConstructObjectNodeGen(context, builtin, isNewTargetCase, arguments);
        }

    }
    @GeneratedBy(CallNumberNode.class)
    public static final class CallNumberNodeGen extends CallNumberNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_;
        @Child private JSToNumericNode callNumber_toNumericNode_;
        @Child private JSNumericToNumberNode callNumber_toNumberFromNumericNode_;

        private CallNumberNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if (state != 0 /* is-active callNumberZero(Object[]) || callNumber(Object[], JSToNumericNode, JSNumericToNumberNode) */ && arguments0Value_ instanceof Object[]) {
                Object[] arguments0Value__ = (Object[]) arguments0Value_;
                if ((state & 0b1) != 0 /* is-active callNumberZero(Object[]) */) {
                    if ((arguments0Value__.length == 0)) {
                        return callNumberZero(arguments0Value__);
                    }
                }
                if ((state & 0b10) != 0 /* is-active callNumber(Object[], JSToNumericNode, JSNumericToNumberNode) */) {
                    if ((arguments0Value__.length > 0)) {
                        return callNumber(arguments0Value__, this.callNumber_toNumericNode_, this.callNumber_toNumberFromNumericNode_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public int executeInt(VirtualFrame frameValue) throws UnexpectedResultException {
            int state = state_;
            if ((state & 0b10) != 0 /* is-active callNumber(Object[], JSToNumericNode, JSNumericToNumberNode) */) {
                return JSTypesGen.expectInteger(execute(frameValue));
            }
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state & 0b1) != 0 /* is-active callNumberZero(Object[]) */ && arguments0Value_ instanceof Object[]) {
                Object[] arguments0Value__ = (Object[]) arguments0Value_;
                if ((arguments0Value__.length == 0)) {
                    return callNumberZero(arguments0Value__);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return JSTypesGen.expectInteger(executeAndSpecialize(arguments0Value_));
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            int state = state_;
            try {
                if ((state & 0b10) == 0 /* only-active callNumberZero(Object[]) */ && state != 0  /* is-not callNumberZero(Object[]) && callNumber(Object[], JSToNumericNode, JSNumericToNumberNode) */) {
                    executeInt(frameValue);
                    return;
                }
                execute(frameValue);
                return;
            } catch (UnexpectedResultException ex) {
                return;
            }
        }

        private Object executeAndSpecialize(Object arguments0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            try {
                if (arguments0Value instanceof Object[]) {
                    Object[] arguments0Value_ = (Object[]) arguments0Value;
                    if ((arguments0Value_.length == 0)) {
                        this.state_ = state = state | 0b1 /* add-active callNumberZero(Object[]) */;
                        lock.unlock();
                        hasLock = false;
                        return callNumberZero(arguments0Value_);
                    }
                    if ((arguments0Value_.length > 0)) {
                        this.callNumber_toNumericNode_ = super.insert((JSToNumericNode.create()));
                        this.callNumber_toNumberFromNumericNode_ = super.insert((JSNumericToNumberNode.create()));
                        this.state_ = state = state | 0b10 /* add-active callNumber(Object[], JSToNumericNode, JSNumericToNumberNode) */;
                        lock.unlock();
                        hasLock = false;
                        return callNumber(arguments0Value_, this.callNumber_toNumericNode_, this.callNumber_toNumberFromNumericNode_);
                    }
                }
                throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_}, arguments0Value);
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
            Object[] data = new Object[3];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "callNumberZero";
            if ((state & 0b1) != 0 /* is-active callNumberZero(Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "callNumber";
            if ((state & 0b10) != 0 /* is-active callNumber(Object[], JSToNumericNode, JSNumericToNumberNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.callNumber_toNumericNode_, this.callNumber_toNumberFromNumericNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static CallNumberNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new CallNumberNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ConstructNumberNode.class)
    public static final class ConstructNumberNodeGen extends ConstructNumberNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_;
        @Child private JSToNumericNode constructNumber_toNumericNode_;
        @Child private JSNumericToNumberNode constructNumber_toNumberFromNumericNode_;

        private ConstructNumberNodeGen(JSContext context, JSBuiltin builtin, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, isNewTargetCase);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if (state != 0 /* is-active constructNumberZero(DynamicObject, Object[]) || constructNumber(DynamicObject, Object[], JSToNumericNode, JSNumericToNumberNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if (arguments1Value_ instanceof Object[]) {
                    Object[] arguments1Value__ = (Object[]) arguments1Value_;
                    if ((state & 0b1) != 0 /* is-active constructNumberZero(DynamicObject, Object[]) */) {
                        if ((arguments1Value__.length == 0)) {
                            return constructNumberZero(arguments0Value__, arguments1Value__);
                        }
                    }
                    if ((state & 0b10) != 0 /* is-active constructNumber(DynamicObject, Object[], JSToNumericNode, JSNumericToNumberNode) */) {
                        if ((arguments1Value__.length > 0)) {
                            return constructNumber(arguments0Value__, arguments1Value__, this.constructNumber_toNumericNode_, this.constructNumber_toNumberFromNumericNode_);
                        }
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            try {
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if (arguments1Value instanceof Object[]) {
                        Object[] arguments1Value_ = (Object[]) arguments1Value;
                        if ((arguments1Value_.length == 0)) {
                            this.state_ = state = state | 0b1 /* add-active constructNumberZero(DynamicObject, Object[]) */;
                            lock.unlock();
                            hasLock = false;
                            return constructNumberZero(arguments0Value_, arguments1Value_);
                        }
                        if ((arguments1Value_.length > 0)) {
                            this.constructNumber_toNumericNode_ = super.insert((JSToNumericNode.create()));
                            this.constructNumber_toNumberFromNumericNode_ = super.insert((JSNumericToNumberNode.create()));
                            this.state_ = state = state | 0b10 /* add-active constructNumber(DynamicObject, Object[], JSToNumericNode, JSNumericToNumberNode) */;
                            lock.unlock();
                            hasLock = false;
                            return constructNumber(arguments0Value_, arguments1Value_, this.constructNumber_toNumericNode_, this.constructNumber_toNumberFromNumericNode_);
                        }
                    }
                }
                throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_}, arguments0Value, arguments1Value);
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
            Object[] data = new Object[3];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "constructNumberZero";
            if ((state & 0b1) != 0 /* is-active constructNumberZero(DynamicObject, Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "constructNumber";
            if ((state & 0b10) != 0 /* is-active constructNumber(DynamicObject, Object[], JSToNumericNode, JSNumericToNumberNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.constructNumber_toNumericNode_, this.constructNumber_toNumberFromNumericNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static ConstructNumberNode create(JSContext context, JSBuiltin builtin, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            return new ConstructNumberNodeGen(context, builtin, isNewTargetCase, arguments);
        }

    }
    @GeneratedBy(CallBigIntNode.class)
    public static final class CallBigIntNodeGen extends CallBigIntNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_;
        @Child private JSNumberToBigIntNode callBigInt_numberToBigIntNode_;
        @Child private JSToBigIntNode callBigInt_toBigIntNode_;

        private CallBigIntNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state & 0b10) != 0 /* is-active callBigInt(Object[], JSNumberToBigIntNode, JSToBigIntNode) */ && arguments0Value_ instanceof Object[]) {
                Object[] arguments0Value__ = (Object[]) arguments0Value_;
                if ((arguments0Value__.length > 0)) {
                    return callBigInt(arguments0Value__, this.callBigInt_numberToBigIntNode_, this.callBigInt_toBigIntNode_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            int state = state_;
            if ((state & 0b10) != 0 /* is-active callBigInt(Object[], JSNumberToBigIntNode, JSToBigIntNode) */) {
                execute(frameValue);
                return;
            }
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state & 0b1) != 0 /* is-active callBigIntZero(Object[]) */ && arguments0Value_ instanceof Object[]) {
                Object[] arguments0Value__ = (Object[]) arguments0Value_;
                if ((arguments0Value__.length == 0)) {
                    callBigIntZero(arguments0Value__);
                    return;
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            executeAndSpecialize(arguments0Value_);
            return;
        }

        private Object executeAndSpecialize(Object arguments0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            try {
                if (arguments0Value instanceof Object[]) {
                    Object[] arguments0Value_ = (Object[]) arguments0Value;
                    if ((arguments0Value_.length == 0)) {
                        this.state_ = state = state | 0b1 /* add-active callBigIntZero(Object[]) */;
                        lock.unlock();
                        hasLock = false;
                        callBigIntZero(arguments0Value_);
                        return null;
                    }
                    if ((arguments0Value_.length > 0)) {
                        this.callBigInt_numberToBigIntNode_ = super.insert((JSNumberToBigIntNode.create()));
                        this.callBigInt_toBigIntNode_ = super.insert((JSToBigIntNode.create()));
                        this.state_ = state = state | 0b10 /* add-active callBigInt(Object[], JSNumberToBigIntNode, JSToBigIntNode) */;
                        lock.unlock();
                        hasLock = false;
                        return callBigInt(arguments0Value_, this.callBigInt_numberToBigIntNode_, this.callBigInt_toBigIntNode_);
                    }
                }
                throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_}, arguments0Value);
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
            Object[] data = new Object[3];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "callBigIntZero";
            if ((state & 0b1) != 0 /* is-active callBigIntZero(Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "callBigInt";
            if ((state & 0b10) != 0 /* is-active callBigInt(Object[], JSNumberToBigIntNode, JSToBigIntNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.callBigInt_numberToBigIntNode_, this.callBigInt_toBigIntNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static CallBigIntNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new CallBigIntNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ConstructBigIntNode.class)
    public static final class ConstructBigIntNodeGen extends ConstructBigIntNode implements Provider {

        private ConstructBigIntNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            return ConstructBigIntNode.construct();
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.MONOMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            s = new Object[3];
            s[0] = "construct";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static ConstructBigIntNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ConstructBigIntNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ConstructFunctionNode.class)
    public static final class ConstructFunctionNodeGen extends ConstructFunctionNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_;
        @CompilationFinal private ConditionProfile hasArgsProfile_;
        @CompilationFinal private ConditionProfile hasParamsProfile_;

        private ConstructFunctionNodeGen(JSContext context, JSBuiltin builtin, boolean generatorFunction, boolean asyncFunction, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, generatorFunction, asyncFunction, isNewTargetCase);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if (state != 0 /* is-active constructFunction(DynamicObject, Object[], ConditionProfile, ConditionProfile) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if (arguments1Value_ instanceof Object[]) {
                    Object[] arguments1Value__ = (Object[]) arguments1Value_;
                    return constructFunction(arguments0Value__, arguments1Value__, this.hasArgsProfile_, this.hasParamsProfile_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            try {
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if (arguments1Value instanceof Object[]) {
                        Object[] arguments1Value_ = (Object[]) arguments1Value;
                        this.hasArgsProfile_ = (ConditionProfile.createBinaryProfile());
                        this.hasParamsProfile_ = (ConditionProfile.createBinaryProfile());
                        this.state_ = state = state | 0b1 /* add-active constructFunction(DynamicObject, Object[], ConditionProfile, ConditionProfile) */;
                        lock.unlock();
                        hasLock = false;
                        return constructFunction(arguments0Value_, arguments1Value_, this.hasArgsProfile_, this.hasParamsProfile_);
                    }
                }
                throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_}, arguments0Value, arguments1Value);
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

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "constructFunction";
            if (state != 0 /* is-active constructFunction(DynamicObject, Object[], ConditionProfile, ConditionProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.hasArgsProfile_, this.hasParamsProfile_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static ConstructFunctionNode create(JSContext context, JSBuiltin builtin, boolean generatorFunction, boolean asyncFunction, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            return new ConstructFunctionNodeGen(context, builtin, generatorFunction, asyncFunction, isNewTargetCase, arguments);
        }

    }
    @GeneratedBy(CreateDynamicFunctionNode.class)
    static final class CreateDynamicFunctionNodeGen extends CreateDynamicFunctionNode implements Provider {

        @CompilationFinal private volatile int state_;
        @CompilationFinal private volatile int exclude_;
        @CompilationFinal private CachedData cached_cache;
        @CompilationFinal private LRUCache<CachedSourceKey, ScriptNode> uncached_cache_;
        @CompilationFinal private ConditionProfile uncached_cacheHit_;

        private CreateDynamicFunctionNodeGen(JSContext context, boolean generatorFunction, boolean asyncFunction) {
            super(context, generatorFunction, asyncFunction);
        }

        @Override
        protected DynamicObject executeFunction(String arg0Value, String arg1Value, String arg2Value) {
            int state = state_;
            if ((state & 0b11) != 0 /* is-active doCached(String, String, String, String, String, String, ScriptNode) || doUncached(String, String, String, LRUCache<CachedSourceKey, ScriptNode>, ConditionProfile) */) {
                if ((state & 0b1) != 0 /* is-active doCached(String, String, String, String, String, String, ScriptNode) */) {
                    CachedData s1_ = this.cached_cache;
                    if (s1_ != null) {
                        if ((CreateDynamicFunctionNode.equals(s1_.cachedParamList_, arg0Value)) && (CreateDynamicFunctionNode.equals(s1_.cachedBody_, arg1Value)) && (CreateDynamicFunctionNode.equals(s1_.cachedSourceName_, arg2Value))) {
                            return doCached(arg0Value, arg1Value, arg2Value, s1_.cachedParamList_, s1_.cachedBody_, s1_.cachedSourceName_, s1_.parsedFunction_);
                        }
                    }
                }
                if ((state & 0b10) != 0 /* is-active doUncached(String, String, String, LRUCache<CachedSourceKey, ScriptNode>, ConditionProfile) */) {
                    return doUncached(arg0Value, arg1Value, arg2Value, this.uncached_cache_, this.uncached_cacheHit_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value, arg1Value, arg2Value);
        }

        private DynamicObject executeAndSpecialize(String arg0Value, String arg1Value, String arg2Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int exclude = exclude_;
            try {
                if ((exclude) == 0 /* is-not-excluded doCached(String, String, String, String, String, String, ScriptNode) */) {
                    CachedData s1_ = this.cached_cache;
                    boolean Cached_duplicateFound_ = false;
                    if ((state & 0b1) != 0 /* is-active doCached(String, String, String, String, String, String, ScriptNode) */) {
                        if ((CreateDynamicFunctionNode.equals(s1_.cachedParamList_, arg0Value)) && (CreateDynamicFunctionNode.equals(s1_.cachedBody_, arg1Value)) && (CreateDynamicFunctionNode.equals(s1_.cachedSourceName_, arg2Value))) {
                            Cached_duplicateFound_ = true;
                        }
                    }
                    if (!Cached_duplicateFound_) {
                        {
                            String cachedParamList__ = (arg0Value);
                            if ((CreateDynamicFunctionNode.equals(cachedParamList__, arg0Value))) {
                                String cachedBody__ = (arg1Value);
                                if ((CreateDynamicFunctionNode.equals(cachedBody__, arg1Value))) {
                                    String cachedSourceName__ = (arg2Value);
                                    if ((CreateDynamicFunctionNode.equals(cachedSourceName__, arg2Value)) && ((state & 0b1)) == 0 /* is-not-active doCached(String, String, String, String, String, String, ScriptNode) */) {
                                        s1_ = new CachedData();
                                        s1_.cachedParamList_ = cachedParamList__;
                                        s1_.cachedBody_ = cachedBody__;
                                        s1_.cachedSourceName_ = cachedSourceName__;
                                        s1_.parsedFunction_ = (parseFunction(arg0Value, arg1Value, arg2Value));
                                        this.cached_cache = s1_;
                                        this.state_ = state = state | 0b1 /* add-active doCached(String, String, String, String, String, String, ScriptNode) */;
                                        Cached_duplicateFound_ = true;
                                    }
                                }
                            }
                        }
                    }
                    if (Cached_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return doCached(arg0Value, arg1Value, arg2Value, s1_.cachedParamList_, s1_.cachedBody_, s1_.cachedSourceName_, s1_.parsedFunction_);
                    }
                }
                this.uncached_cache_ = (createCache());
                this.uncached_cacheHit_ = (ConditionProfile.createCountingProfile());
                this.exclude_ = exclude = exclude | 0b1 /* add-excluded doCached(String, String, String, String, String, String, ScriptNode) */;
                this.cached_cache = null;
                state = state & 0xfffffffe /* remove-active doCached(String, String, String, String, String, String, ScriptNode) */;
                this.state_ = state = state | 0b10 /* add-active doUncached(String, String, String, LRUCache<CachedSourceKey, ScriptNode>, ConditionProfile) */;
                lock.unlock();
                hasLock = false;
                return doUncached(arg0Value, arg1Value, arg2Value, this.uncached_cache_, this.uncached_cacheHit_);
            } finally {
                if (hasLock) {
                    lock.unlock();
                }
            }
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
        public Introspection getIntrospectionData() {
            Object[] data = new Object[3];
            Object[] s;
            data[0] = 0;
            int state = state_;
            int exclude = exclude_;
            s = new Object[3];
            s[0] = "doCached";
            if ((state & 0b1) != 0 /* is-active doCached(String, String, String, String, String, String, ScriptNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                CachedData s1_ = this.cached_cache;
                if (s1_ != null) {
                    cached.add(Arrays.asList(s1_.cachedParamList_, s1_.cachedBody_, s1_.cachedSourceName_, s1_.parsedFunction_));
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-excluded doCached(String, String, String, String, String, String, ScriptNode) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doUncached";
            if ((state & 0b10) != 0 /* is-active doUncached(String, String, String, LRUCache<CachedSourceKey, ScriptNode>, ConditionProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.uncached_cache_, this.uncached_cacheHit_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static CreateDynamicFunctionNode create(JSContext context, boolean generatorFunction, boolean asyncFunction) {
            return new CreateDynamicFunctionNodeGen(context, generatorFunction, asyncFunction);
        }

        @GeneratedBy(CreateDynamicFunctionNode.class)
        private static final class CachedData {

            @CompilationFinal String cachedParamList_;
            @CompilationFinal String cachedBody_;
            @CompilationFinal String cachedSourceName_;
            @CompilationFinal ScriptNode parsedFunction_;

            CachedData() {
            }

        }
    }
    @GeneratedBy(CallTypedArrayNode.class)
    public static final class CallTypedArrayNodeGen extends CallTypedArrayNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private int state_;

        private CallTypedArrayNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if (state != 0 /* is-active callTypedArray(Object[]) */ && arguments0Value_ instanceof Object[]) {
                Object[] arguments0Value__ = (Object[]) arguments0Value_;
                return callTypedArray(arguments0Value__);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private Object executeAndSpecialize(Object arguments0Value) {
            int state = state_;
            if (arguments0Value instanceof Object[]) {
                Object[] arguments0Value_ = (Object[]) arguments0Value;
                this.state_ = state = state | 0b1 /* add-active callTypedArray(Object[]) */;
                return callTypedArray(arguments0Value_);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_}, arguments0Value);
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

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "callTypedArray";
            if (state != 0 /* is-active callTypedArray(Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static CallTypedArrayNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new CallTypedArrayNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ConstructArrayBufferNode.class)
    public static final class ConstructArrayBufferNodeGen extends ConstructArrayBufferNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_;
        @Child private JSToIndexNode constructFromLength_toIndexNode_;
        @CompilationFinal private BranchProfile constructFromHostByteBuffer_errorBranch_;
        @CompilationFinal private ConditionProfile constructFromHostByteBuffer_isDirect_;

        private ConstructArrayBufferNodeGen(JSContext context, JSBuiltin builtin, boolean useShared, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, useShared, isNewTargetCase);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if (state != 0 /* is-active constructFromLength(DynamicObject, Object, JSToIndexNode) || constructFromHostByteBuffer(DynamicObject, Object, BranchProfile, ConditionProfile) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state & 0b1) != 0 /* is-active constructFromLength(DynamicObject, Object, JSToIndexNode) */) {
                    if ((!(JSGuards.isByteBuffer(arguments1Value_))) && (!(isHostByteBuffer(arguments1Value_)))) {
                        return constructFromLength(arguments0Value__, arguments1Value_, this.constructFromLength_toIndexNode_);
                    }
                }
                if ((state & 0b10) != 0 /* is-active constructFromHostByteBuffer(DynamicObject, Object, BranchProfile, ConditionProfile) */) {
                    if ((isHostByteBuffer(arguments1Value_))) {
                        return constructFromHostByteBuffer(arguments0Value__, arguments1Value_, this.constructFromHostByteBuffer_errorBranch_, this.constructFromHostByteBuffer_isDirect_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            try {
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((!(JSGuards.isByteBuffer(arguments1Value))) && (!(isHostByteBuffer(arguments1Value)))) {
                        this.constructFromLength_toIndexNode_ = super.insert((JSToIndexNode.create()));
                        this.state_ = state = state | 0b1 /* add-active constructFromLength(DynamicObject, Object, JSToIndexNode) */;
                        lock.unlock();
                        hasLock = false;
                        return constructFromLength(arguments0Value_, arguments1Value, this.constructFromLength_toIndexNode_);
                    }
                    if ((isHostByteBuffer(arguments1Value))) {
                        this.constructFromHostByteBuffer_errorBranch_ = (BranchProfile.create());
                        this.constructFromHostByteBuffer_isDirect_ = (ConditionProfile.createBinaryProfile());
                        this.state_ = state = state | 0b10 /* add-active constructFromHostByteBuffer(DynamicObject, Object, BranchProfile, ConditionProfile) */;
                        lock.unlock();
                        hasLock = false;
                        return constructFromHostByteBuffer(arguments0Value_, arguments1Value, this.constructFromHostByteBuffer_errorBranch_, this.constructFromHostByteBuffer_isDirect_);
                    }
                }
                throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_}, arguments0Value, arguments1Value);
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
            Object[] data = new Object[3];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "constructFromLength";
            if ((state & 0b1) != 0 /* is-active constructFromLength(DynamicObject, Object, JSToIndexNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.constructFromLength_toIndexNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "constructFromHostByteBuffer";
            if ((state & 0b10) != 0 /* is-active constructFromHostByteBuffer(DynamicObject, Object, BranchProfile, ConditionProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.constructFromHostByteBuffer_errorBranch_, this.constructFromHostByteBuffer_isDirect_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static ConstructArrayBufferNode create(JSContext context, JSBuiltin builtin, boolean useShared, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            return new ConstructArrayBufferNodeGen(context, builtin, useShared, isNewTargetCase, arguments);
        }

    }
    @GeneratedBy(ConstructErrorNode.class)
    public static final class ConstructErrorNodeGen extends ConstructErrorNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_;
        @Child private JSToStringNode constructError1_toStringNode_;

        private ConstructErrorNodeGen(JSContext context, JSBuiltin builtin, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, isNewTargetCase);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if ((state & 0b11) != 0 /* is-active constructError(DynamicObject, String) || constructError(DynamicObject, Object, JSToStringNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state & 0b1) != 0 /* is-active constructError(DynamicObject, String) */ && JSTypesGen.isImplicitString((state & 0b111100) >>> 2 /* extract-implicit-active 1:String */, arguments1Value_)) {
                    String arguments1Value__ = JSTypesGen.asImplicitString((state & 0b111100) >>> 2 /* extract-implicit-active 1:String */, arguments1Value_);
                    return constructError(arguments0Value__, arguments1Value__);
                }
                if ((state & 0b10) != 0 /* is-active constructError(DynamicObject, Object, JSToStringNode) */) {
                    return constructError(arguments0Value__, arguments1Value_, this.constructError1_toStringNode_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            try {
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    {
                        int stringCast1;
                        if ((stringCast1 = JSTypesGen.specializeImplicitString(arguments1Value)) != 0) {
                            String arguments1Value_ = JSTypesGen.asImplicitString(stringCast1, arguments1Value);
                            state = (state | (stringCast1 << 2) /* set-implicit-active 1:String */);
                            this.state_ = state = state | 0b1 /* add-active constructError(DynamicObject, String) */;
                            lock.unlock();
                            hasLock = false;
                            return constructError(arguments0Value_, arguments1Value_);
                        }
                    }
                    this.constructError1_toStringNode_ = super.insert((JSToStringNode.create()));
                    this.state_ = state = state | 0b10 /* add-active constructError(DynamicObject, Object, JSToStringNode) */;
                    lock.unlock();
                    hasLock = false;
                    return constructError(arguments0Value_, arguments1Value, this.constructError1_toStringNode_);
                }
                throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_}, arguments0Value, arguments1Value);
            } finally {
                if (hasLock) {
                    lock.unlock();
                }
            }
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
        public Introspection getIntrospectionData() {
            Object[] data = new Object[3];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "constructError";
            if ((state & 0b1) != 0 /* is-active constructError(DynamicObject, String) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "constructError";
            if ((state & 0b10) != 0 /* is-active constructError(DynamicObject, Object, JSToStringNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.constructError1_toStringNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static ConstructErrorNode create(JSContext context, JSBuiltin builtin, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            return new ConstructErrorNodeGen(context, builtin, isNewTargetCase, arguments);
        }

    }
    @GeneratedBy(ConstructAggregateErrorNode.class)
    public static final class ConstructAggregateErrorNodeGen extends ConstructAggregateErrorNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private volatile int state_;
        @Child private ConstructErrorData constructError_cache;

        private ConstructAggregateErrorNodeGen(JSContext context, JSBuiltin builtin, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, isNewTargetCase);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
            this.arguments2_ = arguments != null && 2 < arguments.length ? arguments[2] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_, this.arguments2_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if (state != 0 /* is-active constructError(DynamicObject, Object, Object, JSToStringNode, GetMethodNode, JSFunctionCallNode, IsJSObjectNode, IteratorStepNode, IteratorValueNode, PropertyGetNode, BranchProfile) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                ConstructErrorData s1_ = this.constructError_cache;
                if (s1_ != null) {
                    return constructError(arguments0Value__, arguments1Value_, arguments2Value_, s1_.toStringNode_, s1_.getIteratorMethodNode_, s1_.iteratorCallNode_, s1_.isObjectNode_, s1_.iteratorStepNode_, s1_.getIteratorValueNode_, s1_.getNextMethodNode_, s1_.growProfile_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            try {
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    ConstructErrorData s1_ = super.insert(new ConstructErrorData());
                    s1_.toStringNode_ = s1_.insertAccessor((JSToStringNode.create()));
                    s1_.getIteratorMethodNode_ = s1_.insertAccessor((createGetIteratorMethod()));
                    s1_.iteratorCallNode_ = s1_.insertAccessor((JSFunctionCallNode.createCall()));
                    s1_.isObjectNode_ = s1_.insertAccessor((IsJSObjectNode.create()));
                    s1_.iteratorStepNode_ = s1_.insertAccessor((IteratorStepNode.create(getContext())));
                    s1_.getIteratorValueNode_ = s1_.insertAccessor((IteratorValueNode.create(getContext())));
                    s1_.getNextMethodNode_ = s1_.insertAccessor((PropertyGetNode.create(JSRuntime.NEXT, getContext())));
                    s1_.growProfile_ = (BranchProfile.create());
                    this.constructError_cache = s1_;
                    this.state_ = state = state | 0b1 /* add-active constructError(DynamicObject, Object, Object, JSToStringNode, GetMethodNode, JSFunctionCallNode, IsJSObjectNode, IteratorStepNode, IteratorValueNode, PropertyGetNode, BranchProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return constructError(arguments0Value_, arguments1Value, arguments2Value, s1_.toStringNode_, s1_.getIteratorMethodNode_, s1_.iteratorCallNode_, s1_.isObjectNode_, s1_.iteratorStepNode_, s1_.getIteratorValueNode_, s1_.getNextMethodNode_, s1_.growProfile_);
                }
                throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_, this.arguments2_}, arguments0Value, arguments1Value, arguments2Value);
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

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "constructError";
            if (state != 0 /* is-active constructError(DynamicObject, Object, Object, JSToStringNode, GetMethodNode, JSFunctionCallNode, IsJSObjectNode, IteratorStepNode, IteratorValueNode, PropertyGetNode, BranchProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                ConstructErrorData s1_ = this.constructError_cache;
                if (s1_ != null) {
                    cached.add(Arrays.asList(s1_.toStringNode_, s1_.getIteratorMethodNode_, s1_.iteratorCallNode_, s1_.isObjectNode_, s1_.iteratorStepNode_, s1_.getIteratorValueNode_, s1_.getNextMethodNode_, s1_.growProfile_));
                }
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static ConstructAggregateErrorNode create(JSContext context, JSBuiltin builtin, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            return new ConstructAggregateErrorNodeGen(context, builtin, isNewTargetCase, arguments);
        }

        @GeneratedBy(ConstructAggregateErrorNode.class)
        private static final class ConstructErrorData extends Node {

            @Child JSToStringNode toStringNode_;
            @Child GetMethodNode getIteratorMethodNode_;
            @Child JSFunctionCallNode iteratorCallNode_;
            @Child IsJSObjectNode isObjectNode_;
            @Child IteratorStepNode iteratorStepNode_;
            @Child IteratorValueNode getIteratorValueNode_;
            @Child PropertyGetNode getNextMethodNode_;
            @CompilationFinal BranchProfile growProfile_;

            ConstructErrorData() {
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
    @GeneratedBy(ConstructDataViewNode.class)
    public static final class ConstructDataViewNodeGen extends ConstructDataViewNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @Child private JavaScriptNode arguments3_;
        @CompilationFinal private volatile int state_;
        @Child private ConstructDataViewData constructDataView_cache;

        private ConstructDataViewNodeGen(JSContext context, JSBuiltin builtin, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, isNewTargetCase);
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
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            Object arguments3Value_ = this.arguments3_.execute(frameValue);
            if (state != 0 /* is-active constructDataView(DynamicObject, Object, Object, Object, BranchProfile, ConditionProfile, ConditionProfile, JSToIndexNode, JSToIndexNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                ConstructDataViewData s1_ = this.constructDataView_cache;
                if (s1_ != null) {
                    return constructDataView(arguments0Value__, arguments1Value_, arguments2Value_, arguments3Value_, s1_.errorBranch_, s1_.arrayBufferCondition_, s1_.byteLengthCondition_, s1_.offsetToIndexNode_, s1_.lengthToIndexNode_);
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
            try {
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    ConstructDataViewData s1_ = super.insert(new ConstructDataViewData());
                    s1_.errorBranch_ = (BranchProfile.create());
                    s1_.arrayBufferCondition_ = (ConditionProfile.createBinaryProfile());
                    s1_.byteLengthCondition_ = (ConditionProfile.createBinaryProfile());
                    s1_.offsetToIndexNode_ = s1_.insertAccessor((JSToIndexNode.create()));
                    s1_.lengthToIndexNode_ = s1_.insertAccessor((JSToIndexNode.create()));
                    this.constructDataView_cache = s1_;
                    this.state_ = state = state | 0b1 /* add-active constructDataView(DynamicObject, Object, Object, Object, BranchProfile, ConditionProfile, ConditionProfile, JSToIndexNode, JSToIndexNode) */;
                    lock.unlock();
                    hasLock = false;
                    return constructDataView(arguments0Value_, arguments1Value, arguments2Value, arguments3Value, s1_.errorBranch_, s1_.arrayBufferCondition_, s1_.byteLengthCondition_, s1_.offsetToIndexNode_, s1_.lengthToIndexNode_);
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
            } else {
                return NodeCost.MONOMORPHIC;
            }
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "constructDataView";
            if (state != 0 /* is-active constructDataView(DynamicObject, Object, Object, Object, BranchProfile, ConditionProfile, ConditionProfile, JSToIndexNode, JSToIndexNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                ConstructDataViewData s1_ = this.constructDataView_cache;
                if (s1_ != null) {
                    cached.add(Arrays.asList(s1_.errorBranch_, s1_.arrayBufferCondition_, s1_.byteLengthCondition_, s1_.offsetToIndexNode_, s1_.lengthToIndexNode_));
                }
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static ConstructDataViewNode create(JSContext context, JSBuiltin builtin, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            return new ConstructDataViewNodeGen(context, builtin, isNewTargetCase, arguments);
        }

        @GeneratedBy(ConstructDataViewNode.class)
        private static final class ConstructDataViewData extends Node {

            @CompilationFinal BranchProfile errorBranch_;
            @CompilationFinal ConditionProfile arrayBufferCondition_;
            @CompilationFinal ConditionProfile byteLengthCondition_;
            @Child JSToIndexNode offsetToIndexNode_;
            @Child JSToIndexNode lengthToIndexNode_;

            ConstructDataViewData() {
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
    @GeneratedBy(CallRequiresNewNode.class)
    public static final class CallRequiresNewNodeGen extends CallRequiresNewNode implements Provider {

        private CallRequiresNewNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            return call();
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.MONOMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            s = new Object[3];
            s[0] = "call";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static CallRequiresNewNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new CallRequiresNewNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ConstructJSAdapterNode.class)
    public static final class ConstructJSAdapterNodeGen extends ConstructJSAdapterNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private int state_;

        private ConstructJSAdapterNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
            this.arguments2_ = arguments != null && 2 < arguments.length ? arguments[2] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_, this.arguments2_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if ((state & 0b111) != 0 /* is-active constructJSAdapter(DynamicObject, Object, Object) || constructJSAdapter(DynamicObject, DynamicObject, Object) || constructJSAdapter(DynamicObject, DynamicObject, DynamicObject) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state & 0b11) != 0 /* is-active constructJSAdapter(DynamicObject, Object, Object) || constructJSAdapter(DynamicObject, DynamicObject, Object) */) {
                    if ((state & 0b1) != 0 /* is-active constructJSAdapter(DynamicObject, Object, Object) */) {
                        if ((JSGuards.isJSObject(arguments0Value__)) && (JSGuards.isUndefined(arguments1Value_)) && (JSGuards.isUndefined(arguments2Value_))) {
                            return constructJSAdapter(arguments0Value__, arguments1Value_, arguments2Value_);
                        }
                    }
                    if ((state & 0b10) != 0 /* is-active constructJSAdapter(DynamicObject, DynamicObject, Object) */ && JSTypes.isDynamicObject(arguments1Value_)) {
                        DynamicObject arguments1Value__ = (DynamicObject) arguments1Value_;
                        if ((JSGuards.isJSObject(arguments0Value__)) && (JSGuards.isJSObject(arguments1Value__)) && (JSGuards.isUndefined(arguments2Value_))) {
                            return constructJSAdapter(arguments0Value__, arguments1Value__, arguments2Value_);
                        }
                    }
                }
                if ((state & 0b100) != 0 /* is-active constructJSAdapter(DynamicObject, DynamicObject, DynamicObject) */ && JSTypes.isDynamicObject(arguments1Value_)) {
                    DynamicObject arguments1Value__ = (DynamicObject) arguments1Value_;
                    if (JSTypes.isDynamicObject(arguments2Value_)) {
                        DynamicObject arguments2Value__ = (DynamicObject) arguments2Value_;
                        if ((JSGuards.isJSObject(arguments0Value__)) && (JSGuards.isJSObject(arguments1Value__)) && (JSGuards.isJSObject(arguments2Value__))) {
                            return constructJSAdapter(arguments0Value__, arguments1Value__, arguments2Value__);
                        }
                    }
                }
            }
            if ((state & 0b1000) != 0 /* is-active constructJSAdapter(Object, Object, Object) */) {
                if (fallbackGuard_(arguments0Value_, arguments1Value_, arguments2Value_)) {
                    return constructJSAdapter(arguments0Value_, arguments1Value_, arguments2Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            int state = state_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((JSGuards.isJSObject(arguments0Value_)) && (JSGuards.isUndefined(arguments1Value)) && (JSGuards.isUndefined(arguments2Value))) {
                    this.state_ = state = state | 0b1 /* add-active constructJSAdapter(DynamicObject, Object, Object) */;
                    return constructJSAdapter(arguments0Value_, arguments1Value, arguments2Value);
                }
                if (JSTypes.isDynamicObject(arguments1Value)) {
                    DynamicObject arguments1Value_ = (DynamicObject) arguments1Value;
                    if ((JSGuards.isJSObject(arguments0Value_)) && (JSGuards.isJSObject(arguments1Value_)) && (JSGuards.isUndefined(arguments2Value))) {
                        this.state_ = state = state | 0b10 /* add-active constructJSAdapter(DynamicObject, DynamicObject, Object) */;
                        return constructJSAdapter(arguments0Value_, arguments1Value_, arguments2Value);
                    }
                }
                if (JSTypes.isDynamicObject(arguments1Value)) {
                    DynamicObject arguments1Value_ = (DynamicObject) arguments1Value;
                    if (JSTypes.isDynamicObject(arguments2Value)) {
                        DynamicObject arguments2Value_ = (DynamicObject) arguments2Value;
                        if ((JSGuards.isJSObject(arguments0Value_)) && (JSGuards.isJSObject(arguments1Value_)) && (JSGuards.isJSObject(arguments2Value_))) {
                            this.state_ = state = state | 0b100 /* add-active constructJSAdapter(DynamicObject, DynamicObject, DynamicObject) */;
                            return constructJSAdapter(arguments0Value_, arguments1Value_, arguments2Value_);
                        }
                    }
                }
            }
            this.state_ = state = state | 0b1000 /* add-active constructJSAdapter(Object, Object, Object) */;
            return constructJSAdapter(arguments0Value, arguments1Value, arguments2Value);
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
            Object[] data = new Object[5];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "constructJSAdapter";
            if ((state & 0b1) != 0 /* is-active constructJSAdapter(DynamicObject, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "constructJSAdapter";
            if ((state & 0b10) != 0 /* is-active constructJSAdapter(DynamicObject, DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "constructJSAdapter";
            if ((state & 0b100) != 0 /* is-active constructJSAdapter(DynamicObject, DynamicObject, DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "constructJSAdapter";
            if ((state & 0b1000) != 0 /* is-active constructJSAdapter(Object, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            return Provider.create(data);
        }

        private static boolean fallbackGuard_(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            if (JSTypes.isDynamicObject(arguments0Value)) {
                {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSObject(arguments0Value_)) && (JSGuards.isUndefined(arguments1Value)) && (JSGuards.isUndefined(arguments2Value))) {
                        return false;
                    }
                }
                if (JSTypes.isDynamicObject(arguments1Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSObject(arguments0Value_))) {
                        DynamicObject arguments1Value_ = (DynamicObject) arguments1Value;
                        if ((JSGuards.isJSObject(arguments1Value_)) && (JSGuards.isUndefined(arguments2Value))) {
                            return false;
                        }
                    }
                }
                if (JSTypes.isDynamicObject(arguments1Value) && JSTypes.isDynamicObject(arguments2Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSObject(arguments0Value_))) {
                        DynamicObject arguments1Value_ = (DynamicObject) arguments1Value;
                        if ((JSGuards.isJSObject(arguments1Value_))) {
                            DynamicObject arguments2Value_ = (DynamicObject) arguments2Value;
                            if ((JSGuards.isJSObject(arguments2Value_))) {
                                return false;
                            }
                        }
                    }
                }
            }
            return true;
        }

        public static ConstructJSAdapterNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ConstructJSAdapterNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ConstructJSProxyNode.class)
    public static final class ConstructJSProxyNodeGen extends ConstructJSProxyNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private int state_;

        private ConstructJSProxyNodeGen(JSContext context, JSBuiltin builtin, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, isNewTargetCase);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
            this.arguments2_ = arguments != null && 2 < arguments.length ? arguments[2] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_, this.arguments2_};
        }

        @Override
        public DynamicObject execute(DynamicObject arguments0Value, Object arguments1Value, Object arguments2Value) {
            int state = state_;
            if (state != 0 /* is-active constructJSProxy(DynamicObject, Object, Object) */) {
                return constructJSProxy(arguments0Value, arguments1Value, arguments2Value);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value, arguments1Value, arguments2Value);
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if (state != 0 /* is-active constructJSProxy(DynamicObject, Object, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                return constructJSProxy(arguments0Value__, arguments1Value_, arguments2Value_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            int state = state_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                this.state_ = state = state | 0b1 /* add-active constructJSProxy(DynamicObject, Object, Object) */;
                return constructJSProxy(arguments0Value_, arguments1Value, arguments2Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_, this.arguments2_}, arguments0Value, arguments1Value, arguments2Value);
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

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "constructJSProxy";
            if (state != 0 /* is-active constructJSProxy(DynamicObject, Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static ConstructJSProxyNode create(JSContext context, JSBuiltin builtin, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            return new ConstructJSProxyNodeGen(context, builtin, isNewTargetCase, arguments);
        }

    }
    @GeneratedBy(ConstructJavaImporterNode.class)
    public static final class ConstructJavaImporterNodeGen extends ConstructJavaImporterNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private int state_;

        private ConstructJavaImporterNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if (state != 0 /* is-active constructJavaImporter(Object[]) */ && arguments0Value_ instanceof Object[]) {
                Object[] arguments0Value__ = (Object[]) arguments0Value_;
                return constructJavaImporter(arguments0Value__);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value) {
            int state = state_;
            if (arguments0Value instanceof Object[]) {
                Object[] arguments0Value_ = (Object[]) arguments0Value;
                this.state_ = state = state | 0b1 /* add-active constructJavaImporter(Object[]) */;
                return constructJavaImporter(arguments0Value_);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_}, arguments0Value);
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

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "constructJavaImporter";
            if (state != 0 /* is-active constructJavaImporter(Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static ConstructJavaImporterNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ConstructJavaImporterNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ConstructMapNode.class)
    public static final class ConstructMapNodeGen extends ConstructMapNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private int state_;

        private ConstructMapNodeGen(JSContext context, JSBuiltin builtin, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, isNewTargetCase);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if (state != 0 /* is-active constructMap(DynamicObject, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                return constructMap(arguments0Value__, arguments1Value_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            int state = state_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                this.state_ = state = state | 0b1 /* add-active constructMap(DynamicObject, Object) */;
                return constructMap(arguments0Value_, arguments1Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_}, arguments0Value, arguments1Value);
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

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "constructMap";
            if (state != 0 /* is-active constructMap(DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static ConstructMapNode create(JSContext context, JSBuiltin builtin, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            return new ConstructMapNodeGen(context, builtin, isNewTargetCase, arguments);
        }

    }
    @GeneratedBy(ConstructSetNode.class)
    public static final class ConstructSetNodeGen extends ConstructSetNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private int state_;

        private ConstructSetNodeGen(JSContext context, JSBuiltin builtin, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, isNewTargetCase);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if (state != 0 /* is-active constructSet(DynamicObject, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                return constructSet(arguments0Value__, arguments1Value_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            int state = state_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                this.state_ = state = state | 0b1 /* add-active constructSet(DynamicObject, Object) */;
                return constructSet(arguments0Value_, arguments1Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_}, arguments0Value, arguments1Value);
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

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "constructSet";
            if (state != 0 /* is-active constructSet(DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static ConstructSetNode create(JSContext context, JSBuiltin builtin, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            return new ConstructSetNodeGen(context, builtin, isNewTargetCase, arguments);
        }

    }
    @GeneratedBy(ConstructWeakSetNode.class)
    public static final class ConstructWeakSetNodeGen extends ConstructWeakSetNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private int state_;

        private ConstructWeakSetNodeGen(JSContext context, JSBuiltin builtin, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, isNewTargetCase);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if (state != 0 /* is-active constructSet(DynamicObject, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                return constructSet(arguments0Value__, arguments1Value_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            int state = state_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                this.state_ = state = state | 0b1 /* add-active constructSet(DynamicObject, Object) */;
                return constructSet(arguments0Value_, arguments1Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_}, arguments0Value, arguments1Value);
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

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "constructSet";
            if (state != 0 /* is-active constructSet(DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static ConstructWeakSetNode create(JSContext context, JSBuiltin builtin, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            return new ConstructWeakSetNodeGen(context, builtin, isNewTargetCase, arguments);
        }

    }
    @GeneratedBy(ConstructWeakMapNode.class)
    public static final class ConstructWeakMapNodeGen extends ConstructWeakMapNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private int state_;

        private ConstructWeakMapNodeGen(JSContext context, JSBuiltin builtin, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            super(context, builtin, isNewTargetCase);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if (state != 0 /* is-active constructMap(DynamicObject, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                return constructMap(arguments0Value__, arguments1Value_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            int state = state_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                this.state_ = state = state | 0b1 /* add-active constructMap(DynamicObject, Object) */;
                return constructMap(arguments0Value_, arguments1Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_}, arguments0Value, arguments1Value);
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

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "constructMap";
            if (state != 0 /* is-active constructMap(DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static ConstructWeakMapNode create(JSContext context, JSBuiltin builtin, boolean isNewTargetCase, JavaScriptNode[] arguments) {
            return new ConstructWeakMapNodeGen(context, builtin, isNewTargetCase, arguments);
        }

    }
    @GeneratedBy(CallSymbolNode.class)
    public static final class CallSymbolNodeGen extends CallSymbolNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_;
        @Child private JSToStringNode callSymbolGeneric_toStringNode_;

        private CallSymbolNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state & 0b1) != 0 /* is-active callSymbolString(String) */ && JSTypesGen.isImplicitString((state & 0b111100) >>> 2 /* extract-implicit-active 0:String */, arguments0Value_)) {
                String arguments0Value__ = JSTypesGen.asImplicitString((state & 0b111100) >>> 2 /* extract-implicit-active 0:String */, arguments0Value_);
                return callSymbolString(arguments0Value__);
            }
            if ((state & 0b10) != 0 /* is-active callSymbolGeneric(Object, JSToStringNode) */) {
                if ((!(JSGuards.isString(arguments0Value_)))) {
                    return callSymbolGeneric(arguments0Value_, this.callSymbolGeneric_toStringNode_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private Symbol executeAndSpecialize(Object arguments0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            try {
                {
                    int stringCast0;
                    if ((stringCast0 = JSTypesGen.specializeImplicitString(arguments0Value)) != 0) {
                        String arguments0Value_ = JSTypesGen.asImplicitString(stringCast0, arguments0Value);
                        state = (state | (stringCast0 << 2) /* set-implicit-active 0:String */);
                        this.state_ = state = state | 0b1 /* add-active callSymbolString(String) */;
                        lock.unlock();
                        hasLock = false;
                        return callSymbolString(arguments0Value_);
                    }
                }
                if ((!(JSGuards.isString(arguments0Value)))) {
                    this.callSymbolGeneric_toStringNode_ = super.insert((JSToStringNode.create()));
                    this.state_ = state = state | 0b10 /* add-active callSymbolGeneric(Object, JSToStringNode) */;
                    lock.unlock();
                    hasLock = false;
                    return callSymbolGeneric(arguments0Value, this.callSymbolGeneric_toStringNode_);
                }
                throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_}, arguments0Value);
            } finally {
                if (hasLock) {
                    lock.unlock();
                }
            }
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
        public Introspection getIntrospectionData() {
            Object[] data = new Object[3];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "callSymbolString";
            if ((state & 0b1) != 0 /* is-active callSymbolString(String) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "callSymbolGeneric";
            if ((state & 0b10) != 0 /* is-active callSymbolGeneric(Object, JSToStringNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.callSymbolGeneric_toStringNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static CallSymbolNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new CallSymbolNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(ConstructSymbolNode.class)
    public static final class ConstructSymbolNodeGen extends ConstructSymbolNode implements Provider {

        private ConstructSymbolNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            return ConstructSymbolNode.construct();
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.MONOMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            s = new Object[3];
            s[0] = "construct";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static ConstructSymbolNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new ConstructSymbolNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(PromiseConstructorNode.class)
    public static final class PromiseConstructorNodeGen extends PromiseConstructorNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private int state_;

        private PromiseConstructorNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if (state != 0 /* is-active construct(VirtualFrame, DynamicObject, Object) || notCallable(DynamicObject, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state & 0b1) != 0 /* is-active construct(VirtualFrame, DynamicObject, Object) */) {
                    if ((isCallable.executeBoolean(arguments1Value_))) {
                        return construct(frameValue, arguments0Value__, arguments1Value_);
                    }
                }
                if ((state & 0b10) != 0 /* is-active notCallable(DynamicObject, Object) */) {
                    if ((!(isCallable.executeBoolean(arguments1Value_)))) {
                        return notCallable(arguments0Value__, arguments1Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(frameValue, arguments0Value_, arguments1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(VirtualFrame frameValue, Object arguments0Value, Object arguments1Value) {
            int state = state_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((isCallable.executeBoolean(arguments1Value))) {
                    this.state_ = state = state | 0b1 /* add-active construct(VirtualFrame, DynamicObject, Object) */;
                    return construct(frameValue, arguments0Value_, arguments1Value);
                }
                if ((!(isCallable.executeBoolean(arguments1Value)))) {
                    this.state_ = state = state | 0b10 /* add-active notCallable(DynamicObject, Object) */;
                    return notCallable(arguments0Value_, arguments1Value);
                }
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_}, arguments0Value, arguments1Value);
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
            Object[] data = new Object[3];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "construct";
            if ((state & 0b1) != 0 /* is-active construct(VirtualFrame, DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "notCallable";
            if ((state & 0b10) != 0 /* is-active notCallable(DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static PromiseConstructorNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new PromiseConstructorNodeGen(context, builtin, arguments);
        }

    }
}
