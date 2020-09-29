// CheckStyle: start generated
package com.oracle.truffle.js.builtins;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.SlowPathException;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.api.profiles.ValueProfile;
import com.oracle.truffle.js.builtins.ArrayPrototypeBuiltins.DeleteAndSetLengthNode;
import com.oracle.truffle.js.builtins.ArrayPrototypeBuiltins.FlattenIntoArrayNode;
import com.oracle.truffle.js.builtins.ArrayPrototypeBuiltins.JSArrayConcatNode;
import com.oracle.truffle.js.builtins.ArrayPrototypeBuiltins.JSArrayCopyWithinNode;
import com.oracle.truffle.js.builtins.ArrayPrototypeBuiltins.JSArrayEveryNode;
import com.oracle.truffle.js.builtins.ArrayPrototypeBuiltins.JSArrayFillNode;
import com.oracle.truffle.js.builtins.ArrayPrototypeBuiltins.JSArrayFilterNode;
import com.oracle.truffle.js.builtins.ArrayPrototypeBuiltins.JSArrayFindIndexNode;
import com.oracle.truffle.js.builtins.ArrayPrototypeBuiltins.JSArrayFindNode;
import com.oracle.truffle.js.builtins.ArrayPrototypeBuiltins.JSArrayFlatMapNode;
import com.oracle.truffle.js.builtins.ArrayPrototypeBuiltins.JSArrayFlatNode;
import com.oracle.truffle.js.builtins.ArrayPrototypeBuiltins.JSArrayForEachNode;
import com.oracle.truffle.js.builtins.ArrayPrototypeBuiltins.JSArrayIncludesNode;
import com.oracle.truffle.js.builtins.ArrayPrototypeBuiltins.JSArrayIndexOfNode;
import com.oracle.truffle.js.builtins.ArrayPrototypeBuiltins.JSArrayIteratorNode;
import com.oracle.truffle.js.builtins.ArrayPrototypeBuiltins.JSArrayJoinNode;
import com.oracle.truffle.js.builtins.ArrayPrototypeBuiltins.JSArrayMapNode;
import com.oracle.truffle.js.builtins.ArrayPrototypeBuiltins.JSArrayOperation;
import com.oracle.truffle.js.builtins.ArrayPrototypeBuiltins.JSArrayPopNode;
import com.oracle.truffle.js.builtins.ArrayPrototypeBuiltins.JSArrayPushNode;
import com.oracle.truffle.js.builtins.ArrayPrototypeBuiltins.JSArrayReduceNode;
import com.oracle.truffle.js.builtins.ArrayPrototypeBuiltins.JSArrayReverseNode;
import com.oracle.truffle.js.builtins.ArrayPrototypeBuiltins.JSArrayShiftNode;
import com.oracle.truffle.js.builtins.ArrayPrototypeBuiltins.JSArraySliceNode;
import com.oracle.truffle.js.builtins.ArrayPrototypeBuiltins.JSArraySomeNode;
import com.oracle.truffle.js.builtins.ArrayPrototypeBuiltins.JSArraySortNode;
import com.oracle.truffle.js.builtins.ArrayPrototypeBuiltins.JSArraySpliceNode;
import com.oracle.truffle.js.builtins.ArrayPrototypeBuiltins.JSArrayToLocaleStringNode;
import com.oracle.truffle.js.builtins.ArrayPrototypeBuiltins.JSArrayToStringNode;
import com.oracle.truffle.js.builtins.ArrayPrototypeBuiltins.JSArrayUnshiftNode;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.access.GetPrototypeNode;
import com.oracle.truffle.js.nodes.access.IsArrayNode;
import com.oracle.truffle.js.nodes.access.WritePropertyNode;
import com.oracle.truffle.js.nodes.array.JSArrayDeleteRangeNode;
import com.oracle.truffle.js.nodes.array.JSArrayFirstElementIndexNode;
import com.oracle.truffle.js.nodes.array.JSArrayLastElementIndexNode;
import com.oracle.truffle.js.nodes.array.JSArrayToDenseObjectArrayNode;
import com.oracle.truffle.js.nodes.array.TestArrayNode;
import com.oracle.truffle.js.nodes.array.ArrayLengthNode.ArrayLengthWriteNode;
import com.oracle.truffle.js.nodes.binary.JSIdenticalNode;
import com.oracle.truffle.js.nodes.cast.JSToIntegerAsLongNode;
import com.oracle.truffle.js.nodes.cast.JSToObjectNode;
import com.oracle.truffle.js.nodes.cast.JSToStringNode;
import com.oracle.truffle.js.nodes.control.DeletePropertyNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.JSRuntime;
import com.oracle.truffle.js.runtime.array.ScriptArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(ArrayPrototypeBuiltins.class)
public final class ArrayPrototypeBuiltinsFactory {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @GeneratedBy(JSArrayPushNode.class)
    public static final class JSArrayPushNodeGen extends JSArrayPushNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private int state_;
        @CompilationFinal private int exclude_;

        private JSArrayPushNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            boolean arguments2Value_;
            try {
                arguments2Value_ = this.arguments2_.executeBoolean(frameValue);
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(arguments0Value_, arguments1Value_, ex.getResult());
            }
            if (state != 0 /* is-active pushArrayNone(DynamicObject, Object[], boolean) || pushArraySingle(DynamicObject, Object[], boolean) || pushArraySingleLong(DynamicObject, Object[], boolean) || pushArrayAll(DynamicObject, Object[], boolean) || pushArrayAllLong(DynamicObject, Object[], boolean) || pushProperty(Object, Object[], boolean) */ && arguments1Value_ instanceof Object[]) {
                Object[] arguments1Value__ = (Object[]) arguments1Value_;
                if ((state & 0b11111) != 0 /* is-active pushArrayNone(DynamicObject, Object[], boolean) || pushArraySingle(DynamicObject, Object[], boolean) || pushArraySingleLong(DynamicObject, Object[], boolean) || pushArrayAll(DynamicObject, Object[], boolean) || pushArrayAllLong(DynamicObject, Object[], boolean) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((state & 0b1) != 0 /* is-active pushArrayNone(DynamicObject, Object[], boolean) */) {
                        if ((arguments2Value_) && (arguments1Value__.length == 0)) {
                            return pushArrayNone(arguments0Value__, arguments1Value__, arguments2Value_);
                        }
                    }
                    if ((state & 0b10) != 0 /* is-active pushArraySingle(DynamicObject, Object[], boolean) */) {
                        if ((arguments2Value_) && (arguments1Value__.length == 1)) {
                            try {
                                return pushArraySingle(arguments0Value__, arguments1Value__, arguments2Value_);
                            } catch (SlowPathException ex) {
                                // implicit transferToInterpreterAndInvalidate()
                                Lock lock = getLock();
                                lock.lock();
                                try {
                                    this.exclude_ = this.exclude_ | 0b1 /* add-excluded pushArraySingle(DynamicObject, Object[], boolean) */;
                                    this.state_ = this.state_ & 0xfffffffd /* remove-active pushArraySingle(DynamicObject, Object[], boolean) */;
                                } finally {
                                    lock.unlock();
                                }
                                return executeAndSpecialize(arguments0Value__, arguments1Value__, arguments2Value_);
                            }
                        }
                    }
                    if ((state & 0b100) != 0 /* is-active pushArraySingleLong(DynamicObject, Object[], boolean) */) {
                        if ((arguments2Value_) && (arguments1Value__.length == 1)) {
                            return pushArraySingleLong(arguments0Value__, arguments1Value__, arguments2Value_);
                        }
                    }
                    if ((state & 0b1000) != 0 /* is-active pushArrayAll(DynamicObject, Object[], boolean) */) {
                        if ((arguments2Value_) && (arguments1Value__.length >= 2)) {
                            try {
                                return pushArrayAll(arguments0Value__, arguments1Value__, arguments2Value_);
                            } catch (SlowPathException ex) {
                                // implicit transferToInterpreterAndInvalidate()
                                Lock lock = getLock();
                                lock.lock();
                                try {
                                    this.exclude_ = this.exclude_ | 0b10 /* add-excluded pushArrayAll(DynamicObject, Object[], boolean) */;
                                    this.state_ = this.state_ & 0xfffffff7 /* remove-active pushArrayAll(DynamicObject, Object[], boolean) */;
                                } finally {
                                    lock.unlock();
                                }
                                return executeAndSpecialize(arguments0Value__, arguments1Value__, arguments2Value_);
                            }
                        }
                    }
                    if ((state & 0b10000) != 0 /* is-active pushArrayAllLong(DynamicObject, Object[], boolean) */) {
                        if ((arguments2Value_) && (arguments1Value__.length >= 2)) {
                            return pushArrayAllLong(arguments0Value__, arguments1Value__, arguments2Value_);
                        }
                    }
                }
                if ((state & 0b100000) != 0 /* is-active pushProperty(Object, Object[], boolean) */) {
                    if ((!(arguments2Value_))) {
                        return pushProperty(arguments0Value_, arguments1Value__, arguments2Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public double executeDouble(VirtualFrame frameValue) throws UnexpectedResultException {
            int state = state_;
            if ((state & 0b1) != 0 /* is-active pushArrayNone(DynamicObject, Object[], boolean) */) {
                return JSTypesGen.expectDouble(execute(frameValue));
            }
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            boolean arguments2Value_;
            try {
                arguments2Value_ = this.arguments2_.executeBoolean(frameValue);
            } catch (UnexpectedResultException ex) {
                return JSTypesGen.expectDouble(executeAndSpecialize(arguments0Value_, arguments1Value_, ex.getResult()));
            }
            if ((state & 0b110100) != 0 /* is-active pushArraySingleLong(DynamicObject, Object[], boolean) || pushArrayAllLong(DynamicObject, Object[], boolean) || pushProperty(Object, Object[], boolean) */ && arguments1Value_ instanceof Object[]) {
                Object[] arguments1Value__ = (Object[]) arguments1Value_;
                if ((state & 0b10100) != 0 /* is-active pushArraySingleLong(DynamicObject, Object[], boolean) || pushArrayAllLong(DynamicObject, Object[], boolean) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((state & 0b100) != 0 /* is-active pushArraySingleLong(DynamicObject, Object[], boolean) */) {
                        if ((arguments2Value_) && (arguments1Value__.length == 1)) {
                            return pushArraySingleLong(arguments0Value__, arguments1Value__, arguments2Value_);
                        }
                    }
                    if ((state & 0b10000) != 0 /* is-active pushArrayAllLong(DynamicObject, Object[], boolean) */) {
                        if ((arguments2Value_) && (arguments1Value__.length >= 2)) {
                            return pushArrayAllLong(arguments0Value__, arguments1Value__, arguments2Value_);
                        }
                    }
                }
                if ((state & 0b100000) != 0 /* is-active pushProperty(Object, Object[], boolean) */) {
                    if ((!(arguments2Value_))) {
                        return pushProperty(arguments0Value_, arguments1Value__, arguments2Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return JSTypesGen.expectDouble(executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_));
        }

        @Override
        public int executeInt(VirtualFrame frameValue) throws UnexpectedResultException {
            int state = state_;
            if ((state & 0b1) != 0 /* is-active pushArrayNone(DynamicObject, Object[], boolean) */) {
                return JSTypesGen.expectInteger(execute(frameValue));
            }
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            boolean arguments2Value_;
            try {
                arguments2Value_ = this.arguments2_.executeBoolean(frameValue);
            } catch (UnexpectedResultException ex) {
                return JSTypesGen.expectInteger(executeAndSpecialize(arguments0Value_, arguments1Value_, ex.getResult()));
            }
            if ((state & 0b1010) != 0 /* is-active pushArraySingle(DynamicObject, Object[], boolean) || pushArrayAll(DynamicObject, Object[], boolean) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if (arguments1Value_ instanceof Object[]) {
                    Object[] arguments1Value__ = (Object[]) arguments1Value_;
                    if ((state & 0b10) != 0 /* is-active pushArraySingle(DynamicObject, Object[], boolean) */) {
                        if ((arguments2Value_) && (arguments1Value__.length == 1)) {
                            try {
                                return pushArraySingle(arguments0Value__, arguments1Value__, arguments2Value_);
                            } catch (SlowPathException ex) {
                                // implicit transferToInterpreterAndInvalidate()
                                Lock lock = getLock();
                                lock.lock();
                                try {
                                    this.exclude_ = this.exclude_ | 0b1 /* add-excluded pushArraySingle(DynamicObject, Object[], boolean) */;
                                    this.state_ = this.state_ & 0xfffffffd /* remove-active pushArraySingle(DynamicObject, Object[], boolean) */;
                                } finally {
                                    lock.unlock();
                                }
                                return JSTypesGen.expectInteger(executeAndSpecialize(arguments0Value__, arguments1Value__, arguments2Value_));
                            }
                        }
                    }
                    if ((state & 0b1000) != 0 /* is-active pushArrayAll(DynamicObject, Object[], boolean) */) {
                        if ((arguments2Value_) && (arguments1Value__.length >= 2)) {
                            try {
                                return pushArrayAll(arguments0Value__, arguments1Value__, arguments2Value_);
                            } catch (SlowPathException ex) {
                                // implicit transferToInterpreterAndInvalidate()
                                Lock lock = getLock();
                                lock.lock();
                                try {
                                    this.exclude_ = this.exclude_ | 0b10 /* add-excluded pushArrayAll(DynamicObject, Object[], boolean) */;
                                    this.state_ = this.state_ & 0xfffffff7 /* remove-active pushArrayAll(DynamicObject, Object[], boolean) */;
                                } finally {
                                    lock.unlock();
                                }
                                return JSTypesGen.expectInteger(executeAndSpecialize(arguments0Value__, arguments1Value__, arguments2Value_));
                            }
                        }
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return JSTypesGen.expectInteger(executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_));
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            int state = state_;
            try {
                if ((state & 0b110101) == 0 /* only-active pushArraySingle(DynamicObject, Object[], boolean) && pushArrayAll(DynamicObject, Object[], boolean) */ && state != 0  /* is-not pushArrayNone(DynamicObject, Object[], boolean) && pushArraySingle(DynamicObject, Object[], boolean) && pushArraySingleLong(DynamicObject, Object[], boolean) && pushArrayAll(DynamicObject, Object[], boolean) && pushArrayAllLong(DynamicObject, Object[], boolean) && pushProperty(Object, Object[], boolean) */) {
                    executeInt(frameValue);
                    return;
                } else if ((state & 0b1011) == 0 /* only-active pushArraySingleLong(DynamicObject, Object[], boolean) && pushArrayAllLong(DynamicObject, Object[], boolean) && pushProperty(Object, Object[], boolean) */ && state != 0  /* is-not pushArrayNone(DynamicObject, Object[], boolean) && pushArraySingle(DynamicObject, Object[], boolean) && pushArraySingleLong(DynamicObject, Object[], boolean) && pushArrayAll(DynamicObject, Object[], boolean) && pushArrayAllLong(DynamicObject, Object[], boolean) && pushProperty(Object, Object[], boolean) */) {
                    executeDouble(frameValue);
                    return;
                }
                execute(frameValue);
                return;
            } catch (UnexpectedResultException ex) {
                return;
            }
        }

        private Object executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int exclude = exclude_;
            try {
                if (arguments1Value instanceof Object[]) {
                    Object[] arguments1Value_ = (Object[]) arguments1Value;
                    if (arguments2Value instanceof Boolean) {
                        boolean arguments2Value_ = (boolean) arguments2Value;
                        if (JSTypes.isDynamicObject(arguments0Value)) {
                            DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                            if ((arguments2Value_) && (arguments1Value_.length == 0)) {
                                this.state_ = state = state | 0b1 /* add-active pushArrayNone(DynamicObject, Object[], boolean) */;
                                lock.unlock();
                                hasLock = false;
                                return pushArrayNone(arguments0Value_, arguments1Value_, arguments2Value_);
                            }
                            if (((exclude & 0b1)) == 0 /* is-not-excluded pushArraySingle(DynamicObject, Object[], boolean) */) {
                                if ((arguments2Value_) && (arguments1Value_.length == 1)) {
                                    this.state_ = state = state | 0b10 /* add-active pushArraySingle(DynamicObject, Object[], boolean) */;
                                    try {
                                        lock.unlock();
                                        hasLock = false;
                                        return pushArraySingle(arguments0Value_, arguments1Value_, arguments2Value_);
                                    } catch (SlowPathException ex) {
                                        // implicit transferToInterpreterAndInvalidate()
                                        lock.lock();
                                        try {
                                            this.exclude_ = this.exclude_ | 0b1 /* add-excluded pushArraySingle(DynamicObject, Object[], boolean) */;
                                            this.state_ = this.state_ & 0xfffffffd /* remove-active pushArraySingle(DynamicObject, Object[], boolean) */;
                                        } finally {
                                            lock.unlock();
                                        }
                                        return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
                                    }
                                }
                            }
                            if ((arguments2Value_) && (arguments1Value_.length == 1)) {
                                this.state_ = state = state | 0b100 /* add-active pushArraySingleLong(DynamicObject, Object[], boolean) */;
                                lock.unlock();
                                hasLock = false;
                                return pushArraySingleLong(arguments0Value_, arguments1Value_, arguments2Value_);
                            }
                            if (((exclude & 0b10)) == 0 /* is-not-excluded pushArrayAll(DynamicObject, Object[], boolean) */) {
                                if ((arguments2Value_) && (arguments1Value_.length >= 2)) {
                                    this.state_ = state = state | 0b1000 /* add-active pushArrayAll(DynamicObject, Object[], boolean) */;
                                    try {
                                        lock.unlock();
                                        hasLock = false;
                                        return pushArrayAll(arguments0Value_, arguments1Value_, arguments2Value_);
                                    } catch (SlowPathException ex) {
                                        // implicit transferToInterpreterAndInvalidate()
                                        lock.lock();
                                        try {
                                            this.exclude_ = this.exclude_ | 0b10 /* add-excluded pushArrayAll(DynamicObject, Object[], boolean) */;
                                            this.state_ = this.state_ & 0xfffffff7 /* remove-active pushArrayAll(DynamicObject, Object[], boolean) */;
                                        } finally {
                                            lock.unlock();
                                        }
                                        return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
                                    }
                                }
                            }
                            if ((arguments2Value_) && (arguments1Value_.length >= 2)) {
                                this.state_ = state = state | 0b10000 /* add-active pushArrayAllLong(DynamicObject, Object[], boolean) */;
                                lock.unlock();
                                hasLock = false;
                                return pushArrayAllLong(arguments0Value_, arguments1Value_, arguments2Value_);
                            }
                        }
                        if ((!(arguments2Value_))) {
                            this.state_ = state = state | 0b100000 /* add-active pushProperty(Object, Object[], boolean) */;
                            lock.unlock();
                            hasLock = false;
                            return pushProperty(arguments0Value, arguments1Value_, arguments2Value_);
                        }
                    }
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
            } else if ((state & (state - 1)) == 0 /* is-single-active  */) {
                return NodeCost.MONOMORPHIC;
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
            s[0] = "pushArrayNone";
            if ((state & 0b1) != 0 /* is-active pushArrayNone(DynamicObject, Object[], boolean) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "pushArraySingle";
            if ((state & 0b10) != 0 /* is-active pushArraySingle(DynamicObject, Object[], boolean) */) {
                s[1] = (byte)0b01 /* active */;
            } else if ((exclude & 0b1) != 0 /* is-excluded pushArraySingle(DynamicObject, Object[], boolean) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "pushArraySingleLong";
            if ((state & 0b100) != 0 /* is-active pushArraySingleLong(DynamicObject, Object[], boolean) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "pushArrayAll";
            if ((state & 0b1000) != 0 /* is-active pushArrayAll(DynamicObject, Object[], boolean) */) {
                s[1] = (byte)0b01 /* active */;
            } else if ((exclude & 0b10) != 0 /* is-excluded pushArrayAll(DynamicObject, Object[], boolean) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            s = new Object[3];
            s[0] = "pushArrayAllLong";
            if ((state & 0b10000) != 0 /* is-active pushArrayAllLong(DynamicObject, Object[], boolean) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[5] = s;
            s = new Object[3];
            s[0] = "pushProperty";
            if ((state & 0b100000) != 0 /* is-active pushProperty(Object, Object[], boolean) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[6] = s;
            return Provider.create(data);
        }

        public static JSArrayPushNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSArrayPushNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSArrayPopNode.class)
    public static final class JSArrayPopNodeGen extends JSArrayPopNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_;
        @Child private DeleteAndSetLengthNode deleteAndSetLength_;
        @CompilationFinal private ConditionProfile lengthIsZero_;

        private JSArrayPopNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state != 0 /* is-active popGeneric(Object, DeleteAndSetLengthNode, ConditionProfile) */) {
                return popGeneric(arguments0Value_, this.deleteAndSetLength_, this.lengthIsZero_);
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
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            try {
                this.deleteAndSetLength_ = super.insert((DeleteAndSetLengthNode.create(getContext())));
                this.lengthIsZero_ = (ConditionProfile.createBinaryProfile());
                this.state_ = state = state | 0b1 /* add-active popGeneric(Object, DeleteAndSetLengthNode, ConditionProfile) */;
                lock.unlock();
                hasLock = false;
                return popGeneric(arguments0Value, this.deleteAndSetLength_, this.lengthIsZero_);
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
            s[0] = "popGeneric";
            if (state != 0 /* is-active popGeneric(Object, DeleteAndSetLengthNode, ConditionProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.deleteAndSetLength_, this.lengthIsZero_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static JSArrayPopNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSArrayPopNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(DeleteAndSetLengthNode.class)
    protected static final class DeleteAndSetLengthNodeGen extends DeleteAndSetLengthNode implements Provider {

        @CompilationFinal private volatile int state_;
        @CompilationFinal private volatile int exclude_;
        @Child private ArrayLengthWriteNode setArrayLength_arrayLengthWriteNode_;
        @Child private DeletePropertyNode setIntLength_deletePropertyNode_;
        @Child private WritePropertyNode setIntLength_setLengthProperty_;
        @Child private SetLengthData setLength_cache;
        @Child private InteropLibrary foreignArray_arrays_;

        private DeleteAndSetLengthNodeGen(JSContext context) {
            super(context);
        }

        @Override
        public void executeVoid(Object arg0Value, long arg1Value) {
            int state = state_;
            if (state != 0 /* is-active setArrayLength(DynamicObject, long, ArrayLengthWriteNode) || setIntLength(DynamicObject, long, DeletePropertyNode, WritePropertyNode) || setLength(DynamicObject, long, DeletePropertyNode, WritePropertyNode, ConditionProfile) || foreignArray(Object, long, InteropLibrary) */) {
                if ((state & 0b111) != 0 /* is-active setArrayLength(DynamicObject, long, ArrayLengthWriteNode) || setIntLength(DynamicObject, long, DeletePropertyNode, WritePropertyNode) || setLength(DynamicObject, long, DeletePropertyNode, WritePropertyNode, ConditionProfile) */ && JSTypes.isDynamicObject(arg0Value)) {
                    DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                    if ((state & 0b1) != 0 /* is-active setArrayLength(DynamicObject, long, ArrayLengthWriteNode) */) {
                        if ((DeleteAndSetLengthNode.isArray(arg0Value_)) && (JSRuntime.longIsRepresentableAsInt(arg1Value))) {
                            DeleteAndSetLengthNode.setArrayLength(arg0Value_, arg1Value, this.setArrayLength_arrayLengthWriteNode_);
                            return;
                        }
                    }
                    if ((state & 0b10) != 0 /* is-active setIntLength(DynamicObject, long, DeletePropertyNode, WritePropertyNode) */) {
                        if ((JSGuards.isJSObject(arg0Value_)) && (JSRuntime.longIsRepresentableAsInt(arg1Value))) {
                            DeleteAndSetLengthNode.setIntLength(arg0Value_, arg1Value, this.setIntLength_deletePropertyNode_, this.setIntLength_setLengthProperty_);
                            return;
                        }
                    }
                    if ((state & 0b100) != 0 /* is-active setLength(DynamicObject, long, DeletePropertyNode, WritePropertyNode, ConditionProfile) */) {
                        SetLengthData s3_ = this.setLength_cache;
                        if (s3_ != null) {
                            if ((JSGuards.isJSObject(arg0Value_))) {
                                DeleteAndSetLengthNode.setLength(arg0Value_, arg1Value, s3_.deletePropertyNode_, s3_.setLengthProperty_, s3_.indexInIntRangeCondition_);
                                return;
                            }
                        }
                    }
                }
                if ((state & 0b1000) != 0 /* is-active foreignArray(Object, long, InteropLibrary) */) {
                    if ((!(JSGuards.isJSObject(arg0Value)))) {
                        DeleteAndSetLengthNode.foreignArray(arg0Value, arg1Value, this.foreignArray_arrays_);
                        return;
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            executeAndSpecialize(arg0Value, arg1Value);
            return;
        }

        private void executeAndSpecialize(Object arg0Value, long arg1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int exclude = exclude_;
            try {
                if (JSTypes.isDynamicObject(arg0Value)) {
                    DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                    if ((DeleteAndSetLengthNode.isArray(arg0Value_)) && (JSRuntime.longIsRepresentableAsInt(arg1Value))) {
                        this.setArrayLength_arrayLengthWriteNode_ = super.insert((DeleteAndSetLengthNode.createArrayLengthWriteNode()));
                        this.state_ = state = state | 0b1 /* add-active setArrayLength(DynamicObject, long, ArrayLengthWriteNode) */;
                        lock.unlock();
                        hasLock = false;
                        DeleteAndSetLengthNode.setArrayLength(arg0Value_, arg1Value, this.setArrayLength_arrayLengthWriteNode_);
                        return;
                    }
                    if ((exclude) == 0 /* is-not-excluded setIntLength(DynamicObject, long, DeletePropertyNode, WritePropertyNode) */) {
                        if ((JSGuards.isJSObject(arg0Value_)) && (JSRuntime.longIsRepresentableAsInt(arg1Value))) {
                            this.setIntLength_deletePropertyNode_ = super.insert((DeletePropertyNode.create(DeleteAndSetLengthNode.THROW_ERROR, context)));
                            this.setIntLength_setLengthProperty_ = super.insert((createWritePropertyNode()));
                            this.state_ = state = state | 0b10 /* add-active setIntLength(DynamicObject, long, DeletePropertyNode, WritePropertyNode) */;
                            lock.unlock();
                            hasLock = false;
                            DeleteAndSetLengthNode.setIntLength(arg0Value_, arg1Value, this.setIntLength_deletePropertyNode_, this.setIntLength_setLengthProperty_);
                            return;
                        }
                    }
                    if ((JSGuards.isJSObject(arg0Value_))) {
                        SetLengthData s3_ = super.insert(new SetLengthData());
                        s3_.deletePropertyNode_ = s3_.insertAccessor((DeletePropertyNode.create(DeleteAndSetLengthNode.THROW_ERROR, context)));
                        s3_.setLengthProperty_ = s3_.insertAccessor((createWritePropertyNode()));
                        s3_.indexInIntRangeCondition_ = (ConditionProfile.createBinaryProfile());
                        this.setLength_cache = s3_;
                        this.exclude_ = exclude = exclude | 0b1 /* add-excluded setIntLength(DynamicObject, long, DeletePropertyNode, WritePropertyNode) */;
                        state = state & 0xfffffffd /* remove-active setIntLength(DynamicObject, long, DeletePropertyNode, WritePropertyNode) */;
                        this.state_ = state = state | 0b100 /* add-active setLength(DynamicObject, long, DeletePropertyNode, WritePropertyNode, ConditionProfile) */;
                        lock.unlock();
                        hasLock = false;
                        DeleteAndSetLengthNode.setLength(arg0Value_, arg1Value, s3_.deletePropertyNode_, s3_.setLengthProperty_, s3_.indexInIntRangeCondition_);
                        return;
                    }
                }
                if ((!(JSGuards.isJSObject(arg0Value)))) {
                    this.foreignArray_arrays_ = super.insert((INTEROP_LIBRARY_.createDispatched(3)));
                    this.state_ = state = state | 0b1000 /* add-active foreignArray(Object, long, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    DeleteAndSetLengthNode.foreignArray(arg0Value, arg1Value, this.foreignArray_arrays_);
                    return;
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null, null}, arg0Value, arg1Value);
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
            int exclude = exclude_;
            s = new Object[3];
            s[0] = "setArrayLength";
            if ((state & 0b1) != 0 /* is-active setArrayLength(DynamicObject, long, ArrayLengthWriteNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.setArrayLength_arrayLengthWriteNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "setIntLength";
            if ((state & 0b10) != 0 /* is-active setIntLength(DynamicObject, long, DeletePropertyNode, WritePropertyNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.setIntLength_deletePropertyNode_, this.setIntLength_setLengthProperty_));
                s[2] = cached;
            } else if (exclude != 0 /* is-excluded setIntLength(DynamicObject, long, DeletePropertyNode, WritePropertyNode) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "setLength";
            if ((state & 0b100) != 0 /* is-active setLength(DynamicObject, long, DeletePropertyNode, WritePropertyNode, ConditionProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                SetLengthData s3_ = this.setLength_cache;
                if (s3_ != null) {
                    cached.add(Arrays.asList(s3_.deletePropertyNode_, s3_.setLengthProperty_, s3_.indexInIntRangeCondition_));
                }
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "foreignArray";
            if ((state & 0b1000) != 0 /* is-active foreignArray(Object, long, InteropLibrary) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.foreignArray_arrays_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            return Provider.create(data);
        }

        public static DeleteAndSetLengthNode create(JSContext context) {
            return new DeleteAndSetLengthNodeGen(context);
        }

        @GeneratedBy(DeleteAndSetLengthNode.class)
        private static final class SetLengthData extends Node {

            @Child DeletePropertyNode deletePropertyNode_;
            @Child WritePropertyNode setLengthProperty_;
            @CompilationFinal ConditionProfile indexInIntRangeCondition_;

            SetLengthData() {
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
    @GeneratedBy(JSArraySliceNode.class)
    public static final class JSArraySliceNodeGen extends JSArraySliceNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private volatile int state_;
        @Child private JSToIntegerAsLongNode toIntegerAsLong_;

        private JSArraySliceNodeGen(JSContext context, JSBuiltin builtin, boolean isTypedArrayImplementation, JavaScriptNode[] arguments) {
            super(context, builtin, isTypedArrayImplementation);
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
            if (state != 0 /* is-active sliceGeneric(Object, Object, Object, JSToIntegerAsLongNode) */) {
                return sliceGeneric(arguments0Value_, arguments1Value_, arguments2Value_, this.toIntegerAsLong_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private Object executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            try {
                this.toIntegerAsLong_ = super.insert((JSToIntegerAsLongNode.create()));
                this.state_ = state = state | 0b1 /* add-active sliceGeneric(Object, Object, Object, JSToIntegerAsLongNode) */;
                lock.unlock();
                hasLock = false;
                return sliceGeneric(arguments0Value, arguments1Value, arguments2Value, this.toIntegerAsLong_);
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
            s[0] = "sliceGeneric";
            if (state != 0 /* is-active sliceGeneric(Object, Object, Object, JSToIntegerAsLongNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.toIntegerAsLong_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static JSArraySliceNode create(JSContext context, JSBuiltin builtin, boolean isTypedArrayImplementation, JavaScriptNode[] arguments) {
            return new JSArraySliceNodeGen(context, builtin, isTypedArrayImplementation, arguments);
        }

    }
    @GeneratedBy(JSArrayShiftNode.class)
    public static final class JSArrayShiftNodeGen extends JSArrayShiftNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_;
        @Child private IsArrayNode isArray;
        @Child private TestArrayNode hasHoles;
        @CompilationFinal private ConditionProfile lengthIsZero;
        @Child private DeletePropertyNode deleteProperty;
        @CompilationFinal private ValueProfile shiftWithoutHoles_arrayTypeProfile_;
        @CompilationFinal private ConditionProfile shiftWithoutHoles_lengthLargerOne_;
        @Child private JSArrayFirstElementIndexNode shiftSparse_firstElementIndexNode_;
        @Child private JSArrayLastElementIndexNode shiftSparse_lastElementIndexNode_;
        @Child private InteropLibrary shiftForeign_arrays_;

        private JSArrayShiftNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if ((state & 0b111) != 0 /* is-active shiftWithoutHoles(DynamicObject, IsArrayNode, TestArrayNode, ValueProfile, ConditionProfile, ConditionProfile) || shiftWithHoles(DynamicObject, IsArrayNode, TestArrayNode, DeletePropertyNode, ConditionProfile) || shiftSparse(DynamicObject, IsArrayNode, DeletePropertyNode, ConditionProfile, JSArrayFirstElementIndexNode, JSArrayLastElementIndexNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state & 0b1) != 0 /* is-active shiftWithoutHoles(DynamicObject, IsArrayNode, TestArrayNode, ValueProfile, ConditionProfile, ConditionProfile) */) {
                    if ((JSArrayShiftNode.isArrayWithoutHoles(arguments0Value__, this.isArray, this.hasHoles))) {
                        return shiftWithoutHoles(arguments0Value__, this.isArray, this.hasHoles, this.shiftWithoutHoles_arrayTypeProfile_, this.lengthIsZero, this.shiftWithoutHoles_lengthLargerOne_);
                    }
                }
                if ((state & 0b10) != 0 /* is-active shiftWithHoles(DynamicObject, IsArrayNode, TestArrayNode, DeletePropertyNode, ConditionProfile) */) {
                    if ((JSArrayShiftNode.isArrayWithHoles(arguments0Value__, this.isArray, this.hasHoles))) {
                        return shiftWithHoles(arguments0Value__, this.isArray, this.hasHoles, this.deleteProperty, this.lengthIsZero);
                    }
                }
                if ((state & 0b100) != 0 /* is-active shiftSparse(DynamicObject, IsArrayNode, DeletePropertyNode, ConditionProfile, JSArrayFirstElementIndexNode, JSArrayLastElementIndexNode) */) {
                    if ((this.isArray.execute(arguments0Value__)) && (JSArrayShiftNode.isSparseArray(arguments0Value__))) {
                        return shiftSparse(arguments0Value__, this.isArray, this.deleteProperty, this.lengthIsZero, this.shiftSparse_firstElementIndexNode_, this.shiftSparse_lastElementIndexNode_);
                    }
                }
            }
            if ((state & 0b11000) != 0 /* is-active shiftGeneric(Object, DeletePropertyNode, ConditionProfile) || shiftForeign(Object, InteropLibrary, ConditionProfile) */) {
                if ((state & 0b1000) != 0 /* is-active shiftGeneric(Object, DeletePropertyNode, ConditionProfile) */) {
                    if ((!(JSGuards.isJSArray(arguments0Value_))) && (!(JSGuards.isForeignObject(arguments0Value_)))) {
                        return shiftGeneric(arguments0Value_, this.deleteProperty, this.lengthIsZero);
                    }
                }
                if ((state & 0b10000) != 0 /* is-active shiftForeign(Object, InteropLibrary, ConditionProfile) */) {
                    if ((JSGuards.isForeignObject(arguments0Value_))) {
                        return shiftForeign(arguments0Value_, this.shiftForeign_arrays_, this.lengthIsZero);
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

        private Object executeAndSpecialize(Object arguments0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            try {
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    boolean ShiftWithoutHoles_duplicateFound_ = false;
                    if ((state & 0b1) != 0 /* is-active shiftWithoutHoles(DynamicObject, IsArrayNode, TestArrayNode, ValueProfile, ConditionProfile, ConditionProfile) */) {
                        if ((JSArrayShiftNode.isArrayWithoutHoles(arguments0Value_, this.isArray, this.hasHoles))) {
                            ShiftWithoutHoles_duplicateFound_ = true;
                        }
                    }
                    if (!ShiftWithoutHoles_duplicateFound_) {
                        {
                            IsArrayNode shiftWithoutHoles_isArrayNode__ = super.insert((IsArrayNode.createIsArray()));
                            TestArrayNode shiftWithoutHoles_hasHolesNode__ = super.insert((TestArrayNode.createHasHoles()));
                            if ((JSArrayShiftNode.isArrayWithoutHoles(arguments0Value_, shiftWithoutHoles_isArrayNode__, shiftWithoutHoles_hasHolesNode__)) && ((state & 0b1)) == 0 /* is-not-active shiftWithoutHoles(DynamicObject, IsArrayNode, TestArrayNode, ValueProfile, ConditionProfile, ConditionProfile) */) {
                                if (this.isArray == null) {
                                    this.isArray = super.insert(shiftWithoutHoles_isArrayNode__);
                                }
                                if (this.hasHoles == null) {
                                    this.hasHoles = super.insert(shiftWithoutHoles_hasHolesNode__);
                                }
                                this.shiftWithoutHoles_arrayTypeProfile_ = (ValueProfile.createClassProfile());
                                if (this.lengthIsZero == null) {
                                    this.lengthIsZero = (ConditionProfile.createBinaryProfile());
                                }
                                this.shiftWithoutHoles_lengthLargerOne_ = (ConditionProfile.createBinaryProfile());
                                this.state_ = state = state | 0b1 /* add-active shiftWithoutHoles(DynamicObject, IsArrayNode, TestArrayNode, ValueProfile, ConditionProfile, ConditionProfile) */;
                                ShiftWithoutHoles_duplicateFound_ = true;
                            }
                        }
                    }
                    if (ShiftWithoutHoles_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return shiftWithoutHoles(arguments0Value_, this.isArray, this.hasHoles, this.shiftWithoutHoles_arrayTypeProfile_, this.lengthIsZero, this.shiftWithoutHoles_lengthLargerOne_);
                    }
                    boolean ShiftWithHoles_duplicateFound_ = false;
                    if ((state & 0b10) != 0 /* is-active shiftWithHoles(DynamicObject, IsArrayNode, TestArrayNode, DeletePropertyNode, ConditionProfile) */) {
                        if ((JSArrayShiftNode.isArrayWithHoles(arguments0Value_, this.isArray, this.hasHoles))) {
                            ShiftWithHoles_duplicateFound_ = true;
                        }
                    }
                    if (!ShiftWithHoles_duplicateFound_) {
                        {
                            IsArrayNode shiftWithHoles_isArrayNode__ = super.insert((IsArrayNode.createIsArray()));
                            TestArrayNode shiftWithHoles_hasHolesNode__ = super.insert((TestArrayNode.createHasHoles()));
                            if ((JSArrayShiftNode.isArrayWithHoles(arguments0Value_, shiftWithHoles_isArrayNode__, shiftWithHoles_hasHolesNode__)) && ((state & 0b10)) == 0 /* is-not-active shiftWithHoles(DynamicObject, IsArrayNode, TestArrayNode, DeletePropertyNode, ConditionProfile) */) {
                                if (this.isArray == null) {
                                    this.isArray = super.insert(shiftWithHoles_isArrayNode__);
                                }
                                if (this.hasHoles == null) {
                                    this.hasHoles = super.insert(shiftWithHoles_hasHolesNode__);
                                }
                                if (this.deleteProperty == null) {
                                    this.deleteProperty = super.insert((DeletePropertyNode.create(JSArrayOperation.THROW_ERROR, getContext())));
                                }
                                if (this.lengthIsZero == null) {
                                    this.lengthIsZero = (ConditionProfile.createBinaryProfile());
                                }
                                this.state_ = state = state | 0b10 /* add-active shiftWithHoles(DynamicObject, IsArrayNode, TestArrayNode, DeletePropertyNode, ConditionProfile) */;
                                ShiftWithHoles_duplicateFound_ = true;
                            }
                        }
                    }
                    if (ShiftWithHoles_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return shiftWithHoles(arguments0Value_, this.isArray, this.hasHoles, this.deleteProperty, this.lengthIsZero);
                    }
                    boolean ShiftSparse_duplicateFound_ = false;
                    if ((state & 0b100) != 0 /* is-active shiftSparse(DynamicObject, IsArrayNode, DeletePropertyNode, ConditionProfile, JSArrayFirstElementIndexNode, JSArrayLastElementIndexNode) */) {
                        if ((this.isArray.execute(arguments0Value_)) && (JSArrayShiftNode.isSparseArray(arguments0Value_))) {
                            ShiftSparse_duplicateFound_ = true;
                        }
                    }
                    if (!ShiftSparse_duplicateFound_) {
                        {
                            IsArrayNode shiftSparse_isArrayNode__ = super.insert((IsArrayNode.createIsArray()));
                            if ((shiftSparse_isArrayNode__.execute(arguments0Value_)) && (JSArrayShiftNode.isSparseArray(arguments0Value_)) && ((state & 0b100)) == 0 /* is-not-active shiftSparse(DynamicObject, IsArrayNode, DeletePropertyNode, ConditionProfile, JSArrayFirstElementIndexNode, JSArrayLastElementIndexNode) */) {
                                if (this.isArray == null) {
                                    this.isArray = super.insert(shiftSparse_isArrayNode__);
                                }
                                if (this.deleteProperty == null) {
                                    this.deleteProperty = super.insert((DeletePropertyNode.create(JSArrayOperation.THROW_ERROR, getContext())));
                                }
                                if (this.lengthIsZero == null) {
                                    this.lengthIsZero = (ConditionProfile.createBinaryProfile());
                                }
                                this.shiftSparse_firstElementIndexNode_ = super.insert((JSArrayFirstElementIndexNode.create(getContext())));
                                this.shiftSparse_lastElementIndexNode_ = super.insert((JSArrayLastElementIndexNode.create(getContext())));
                                this.state_ = state = state | 0b100 /* add-active shiftSparse(DynamicObject, IsArrayNode, DeletePropertyNode, ConditionProfile, JSArrayFirstElementIndexNode, JSArrayLastElementIndexNode) */;
                                ShiftSparse_duplicateFound_ = true;
                            }
                        }
                    }
                    if (ShiftSparse_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return shiftSparse(arguments0Value_, this.isArray, this.deleteProperty, this.lengthIsZero, this.shiftSparse_firstElementIndexNode_, this.shiftSparse_lastElementIndexNode_);
                    }
                }
                if ((!(JSGuards.isJSArray(arguments0Value))) && (!(JSGuards.isForeignObject(arguments0Value)))) {
                    if (this.deleteProperty == null) {
                        this.deleteProperty = super.insert((DeletePropertyNode.create(JSArrayOperation.THROW_ERROR, getContext())));
                    }
                    if (this.lengthIsZero == null) {
                        this.lengthIsZero = (ConditionProfile.createBinaryProfile());
                    }
                    this.state_ = state = state | 0b1000 /* add-active shiftGeneric(Object, DeletePropertyNode, ConditionProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return shiftGeneric(arguments0Value, this.deleteProperty, this.lengthIsZero);
                }
                if ((JSGuards.isForeignObject(arguments0Value))) {
                    this.shiftForeign_arrays_ = super.insert((INTEROP_LIBRARY_.createDispatched(3)));
                    if (this.lengthIsZero == null) {
                        this.lengthIsZero = (ConditionProfile.createBinaryProfile());
                    }
                    this.state_ = state = state | 0b10000 /* add-active shiftForeign(Object, InteropLibrary, ConditionProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return shiftForeign(arguments0Value, this.shiftForeign_arrays_, this.lengthIsZero);
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
            Object[] data = new Object[6];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "shiftWithoutHoles";
            if ((state & 0b1) != 0 /* is-active shiftWithoutHoles(DynamicObject, IsArrayNode, TestArrayNode, ValueProfile, ConditionProfile, ConditionProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.isArray, this.hasHoles, this.shiftWithoutHoles_arrayTypeProfile_, this.lengthIsZero, this.shiftWithoutHoles_lengthLargerOne_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "shiftWithHoles";
            if ((state & 0b10) != 0 /* is-active shiftWithHoles(DynamicObject, IsArrayNode, TestArrayNode, DeletePropertyNode, ConditionProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.isArray, this.hasHoles, this.deleteProperty, this.lengthIsZero));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "shiftSparse";
            if ((state & 0b100) != 0 /* is-active shiftSparse(DynamicObject, IsArrayNode, DeletePropertyNode, ConditionProfile, JSArrayFirstElementIndexNode, JSArrayLastElementIndexNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.isArray, this.deleteProperty, this.lengthIsZero, this.shiftSparse_firstElementIndexNode_, this.shiftSparse_lastElementIndexNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "shiftGeneric";
            if ((state & 0b1000) != 0 /* is-active shiftGeneric(Object, DeletePropertyNode, ConditionProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.deleteProperty, this.lengthIsZero));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            s = new Object[3];
            s[0] = "shiftForeign";
            if ((state & 0b10000) != 0 /* is-active shiftForeign(Object, InteropLibrary, ConditionProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.shiftForeign_arrays_, this.lengthIsZero));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[5] = s;
            return Provider.create(data);
        }

        public static JSArrayShiftNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSArrayShiftNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSArrayUnshiftNode.class)
    public static final class JSArrayUnshiftNodeGen extends JSArrayUnshiftNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_;
        @CompilationFinal private volatile int exclude_;
        @Child private UnshiftHolesData unshiftHoles_cache;

        private JSArrayUnshiftNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state != 0 /* is-active unshiftInt(DynamicObject, Object[]) || unshiftDouble(DynamicObject, Object[]) || unshiftHoles(Object, Object[], DeletePropertyNode, JSArrayLastElementIndexNode, JSArrayFirstElementIndexNode) */ && arguments1Value_ instanceof Object[]) {
                Object[] arguments1Value__ = (Object[]) arguments1Value_;
                if ((state & 0b11) != 0 /* is-active unshiftInt(DynamicObject, Object[]) || unshiftDouble(DynamicObject, Object[]) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((state & 0b1) != 0 /* is-active unshiftInt(DynamicObject, Object[]) */) {
                        if ((isFastPath(arguments0Value__))) {
                            try {
                                return unshiftInt(arguments0Value__, arguments1Value__);
                            } catch (UnexpectedResultException ex) {
                                // implicit transferToInterpreterAndInvalidate()
                                Lock lock = getLock();
                                lock.lock();
                                try {
                                    this.exclude_ = this.exclude_ | 0b1 /* add-excluded unshiftInt(DynamicObject, Object[]) */;
                                    this.state_ = this.state_ & 0xfffffffe /* remove-active unshiftInt(DynamicObject, Object[]) */;
                                } finally {
                                    lock.unlock();
                                }
                                return ex.getResult();
                            }
                        }
                    }
                    if ((state & 0b10) != 0 /* is-active unshiftDouble(DynamicObject, Object[]) */) {
                        if ((isFastPath(arguments0Value__))) {
                            return unshiftDouble(arguments0Value__, arguments1Value__);
                        }
                    }
                }
                if ((state & 0b100) != 0 /* is-active unshiftHoles(Object, Object[], DeletePropertyNode, JSArrayLastElementIndexNode, JSArrayFirstElementIndexNode) */) {
                    UnshiftHolesData s3_ = this.unshiftHoles_cache;
                    if (s3_ != null) {
                        if ((!(isFastPath(arguments0Value_)))) {
                            return unshiftHoles(arguments0Value_, arguments1Value__, s3_.deletePropertyNode_, s3_.lastElementIndexNode_, s3_.firstElementIndexNode_);
                        }
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public double executeDouble(VirtualFrame frameValue) throws UnexpectedResultException {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if ((state & 0b110) != 0 /* is-active unshiftDouble(DynamicObject, Object[]) || unshiftHoles(Object, Object[], DeletePropertyNode, JSArrayLastElementIndexNode, JSArrayFirstElementIndexNode) */ && arguments1Value_ instanceof Object[]) {
                Object[] arguments1Value__ = (Object[]) arguments1Value_;
                if ((state & 0b10) != 0 /* is-active unshiftDouble(DynamicObject, Object[]) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((isFastPath(arguments0Value__))) {
                        return unshiftDouble(arguments0Value__, arguments1Value__);
                    }
                }
                if ((state & 0b100) != 0 /* is-active unshiftHoles(Object, Object[], DeletePropertyNode, JSArrayLastElementIndexNode, JSArrayFirstElementIndexNode) */) {
                    UnshiftHolesData s3_ = this.unshiftHoles_cache;
                    if (s3_ != null) {
                        if ((!(isFastPath(arguments0Value_)))) {
                            return unshiftHoles(arguments0Value_, arguments1Value__, s3_.deletePropertyNode_, s3_.lastElementIndexNode_, s3_.firstElementIndexNode_);
                        }
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return JSTypesGen.expectDouble(executeAndSpecialize(arguments0Value_, arguments1Value_));
        }

        @Override
        public int executeInt(VirtualFrame frameValue) throws UnexpectedResultException {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if ((state & 0b1) != 0 /* is-active unshiftInt(DynamicObject, Object[]) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if (arguments1Value_ instanceof Object[]) {
                    Object[] arguments1Value__ = (Object[]) arguments1Value_;
                    if ((isFastPath(arguments0Value__))) {
                        try {
                            return unshiftInt(arguments0Value__, arguments1Value__);
                        } catch (UnexpectedResultException ex) {
                            // implicit transferToInterpreterAndInvalidate()
                            Lock lock = getLock();
                            lock.lock();
                            try {
                                this.exclude_ = this.exclude_ | 0b1 /* add-excluded unshiftInt(DynamicObject, Object[]) */;
                                this.state_ = this.state_ & 0xfffffffe /* remove-active unshiftInt(DynamicObject, Object[]) */;
                            } finally {
                                lock.unlock();
                            }
                            return JSTypesGen.expectInteger(ex.getResult());
                        }
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return JSTypesGen.expectInteger(executeAndSpecialize(arguments0Value_, arguments1Value_));
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            int state = state_;
            try {
                if ((state & 0b110) == 0 /* only-active unshiftInt(DynamicObject, Object[]) */ && state != 0  /* is-not unshiftInt(DynamicObject, Object[]) && unshiftDouble(DynamicObject, Object[]) && unshiftHoles(Object, Object[], DeletePropertyNode, JSArrayLastElementIndexNode, JSArrayFirstElementIndexNode) */) {
                    executeInt(frameValue);
                    return;
                } else if ((state & 0b1) == 0 /* only-active unshiftDouble(DynamicObject, Object[]) && unshiftHoles(Object, Object[], DeletePropertyNode, JSArrayLastElementIndexNode, JSArrayFirstElementIndexNode) */ && state != 0  /* is-not unshiftInt(DynamicObject, Object[]) && unshiftDouble(DynamicObject, Object[]) && unshiftHoles(Object, Object[], DeletePropertyNode, JSArrayLastElementIndexNode, JSArrayFirstElementIndexNode) */) {
                    executeDouble(frameValue);
                    return;
                }
                execute(frameValue);
                return;
            } catch (UnexpectedResultException ex) {
                return;
            }
        }

        private Object executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int exclude = exclude_;
            try {
                if (arguments1Value instanceof Object[]) {
                    Object[] arguments1Value_ = (Object[]) arguments1Value;
                    if (JSTypes.isDynamicObject(arguments0Value)) {
                        DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                        if ((exclude) == 0 /* is-not-excluded unshiftInt(DynamicObject, Object[]) */) {
                            if ((isFastPath(arguments0Value_))) {
                                this.state_ = state = state | 0b1 /* add-active unshiftInt(DynamicObject, Object[]) */;
                                try {
                                    lock.unlock();
                                    hasLock = false;
                                    return unshiftInt(arguments0Value_, arguments1Value_);
                                } catch (UnexpectedResultException ex) {
                                    // implicit transferToInterpreterAndInvalidate()
                                    lock.lock();
                                    try {
                                        this.exclude_ = this.exclude_ | 0b1 /* add-excluded unshiftInt(DynamicObject, Object[]) */;
                                        this.state_ = this.state_ & 0xfffffffe /* remove-active unshiftInt(DynamicObject, Object[]) */;
                                    } finally {
                                        lock.unlock();
                                    }
                                    return ex.getResult();
                                }
                            }
                        }
                        if ((isFastPath(arguments0Value_))) {
                            this.exclude_ = exclude = exclude | 0b1 /* add-excluded unshiftInt(DynamicObject, Object[]) */;
                            state = state & 0xfffffffe /* remove-active unshiftInt(DynamicObject, Object[]) */;
                            this.state_ = state = state | 0b10 /* add-active unshiftDouble(DynamicObject, Object[]) */;
                            lock.unlock();
                            hasLock = false;
                            return unshiftDouble(arguments0Value_, arguments1Value_);
                        }
                    }
                    if ((!(isFastPath(arguments0Value)))) {
                        UnshiftHolesData s3_ = super.insert(new UnshiftHolesData());
                        s3_.deletePropertyNode_ = s3_.insertAccessor((DeletePropertyNode.create(JSArrayOperation.THROW_ERROR, getContext())));
                        s3_.lastElementIndexNode_ = s3_.insertAccessor((JSArrayLastElementIndexNode.create(getContext())));
                        s3_.firstElementIndexNode_ = s3_.insertAccessor((JSArrayFirstElementIndexNode.create(getContext())));
                        this.unshiftHoles_cache = s3_;
                        this.state_ = state = state | 0b100 /* add-active unshiftHoles(Object, Object[], DeletePropertyNode, JSArrayLastElementIndexNode, JSArrayFirstElementIndexNode) */;
                        lock.unlock();
                        hasLock = false;
                        return unshiftHoles(arguments0Value, arguments1Value_, s3_.deletePropertyNode_, s3_.lastElementIndexNode_, s3_.firstElementIndexNode_);
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
            int exclude = exclude_;
            s = new Object[3];
            s[0] = "unshiftInt";
            if ((state & 0b1) != 0 /* is-active unshiftInt(DynamicObject, Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else if (exclude != 0 /* is-excluded unshiftInt(DynamicObject, Object[]) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "unshiftDouble";
            if ((state & 0b10) != 0 /* is-active unshiftDouble(DynamicObject, Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "unshiftHoles";
            if ((state & 0b100) != 0 /* is-active unshiftHoles(Object, Object[], DeletePropertyNode, JSArrayLastElementIndexNode, JSArrayFirstElementIndexNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                UnshiftHolesData s3_ = this.unshiftHoles_cache;
                if (s3_ != null) {
                    cached.add(Arrays.asList(s3_.deletePropertyNode_, s3_.lastElementIndexNode_, s3_.firstElementIndexNode_));
                }
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static JSArrayUnshiftNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSArrayUnshiftNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(JSArrayUnshiftNode.class)
        private static final class UnshiftHolesData extends Node {

            @Child DeletePropertyNode deletePropertyNode_;
            @Child JSArrayLastElementIndexNode lastElementIndexNode_;
            @Child JSArrayFirstElementIndexNode firstElementIndexNode_;

            UnshiftHolesData() {
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
    @GeneratedBy(JSArrayToStringNode.class)
    public static final class JSArrayToStringNodeGen extends JSArrayToStringNode implements Provider {

        @Child private JavaScriptNode arguments0_;

        private JSArrayToStringNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return toString(arguments0Value_);
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
            s[0] = "toString";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSArrayToStringNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSArrayToStringNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSArrayConcatNode.class)
    public static final class JSArrayConcatNodeGen extends JSArrayConcatNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private int state_;

        private JSArrayConcatNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state != 0 /* is-active concat(Object, Object[]) */ && arguments1Value_ instanceof Object[]) {
                Object[] arguments1Value__ = (Object[]) arguments1Value_;
                return concat(arguments0Value_, arguments1Value__);
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
            if (arguments1Value instanceof Object[]) {
                Object[] arguments1Value_ = (Object[]) arguments1Value;
                this.state_ = state = state | 0b1 /* add-active concat(Object, Object[]) */;
                return concat(arguments0Value, arguments1Value_);
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
            s[0] = "concat";
            if (state != 0 /* is-active concat(Object, Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static JSArrayConcatNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSArrayConcatNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSArrayIndexOfNode.class)
    public static final class JSArrayIndexOfNodeGen extends JSArrayIndexOfNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private int state_;

        private JSArrayIndexOfNodeGen(JSContext context, JSBuiltin builtin, boolean isTypedArrayImplementation, boolean isForward, JavaScriptNode[] arguments) {
            super(context, builtin, isTypedArrayImplementation, isForward);
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
            if (state != 0 /* is-active indexOf(Object, Object[]) */ && arguments1Value_ instanceof Object[]) {
                Object[] arguments1Value__ = (Object[]) arguments1Value_;
                return indexOf(arguments0Value_, arguments1Value__);
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
            int state = state_;
            if (arguments1Value instanceof Object[]) {
                Object[] arguments1Value_ = (Object[]) arguments1Value;
                this.state_ = state = state | 0b1 /* add-active indexOf(Object, Object[]) */;
                return indexOf(arguments0Value, arguments1Value_);
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
            s[0] = "indexOf";
            if (state != 0 /* is-active indexOf(Object, Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static JSArrayIndexOfNode create(JSContext context, JSBuiltin builtin, boolean isTypedArrayImplementation, boolean isForward, JavaScriptNode[] arguments) {
            return new JSArrayIndexOfNodeGen(context, builtin, isTypedArrayImplementation, isForward, arguments);
        }

    }
    @GeneratedBy(JSArrayJoinNode.class)
    public static final class JSArrayJoinNodeGen extends JSArrayJoinNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;

        private JSArrayJoinNodeGen(JSContext context, JSBuiltin builtin, boolean isTypedArrayImplementation, JavaScriptNode[] arguments) {
            super(context, builtin, isTypedArrayImplementation);
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
            return join(arguments0Value_, arguments1Value_);
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
            s[0] = "join";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSArrayJoinNode create(JSContext context, JSBuiltin builtin, boolean isTypedArrayImplementation, JavaScriptNode[] arguments) {
            return new JSArrayJoinNodeGen(context, builtin, isTypedArrayImplementation, arguments);
        }

    }
    @GeneratedBy(JSArrayToLocaleStringNode.class)
    public static final class JSArrayToLocaleStringNodeGen extends JSArrayToLocaleStringNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_;
        @Child private JSToStringNode toStringNode_;

        private JSArrayToLocaleStringNodeGen(JSContext context, JSBuiltin builtin, boolean isTypedArrayImplementation, JavaScriptNode[] arguments) {
            super(context, builtin, isTypedArrayImplementation);
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
            if (state != 0 /* is-active toLocaleString(VirtualFrame, Object, JSToStringNode) */) {
                return toLocaleString(frameValue, arguments0Value_, this.toStringNode_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(frameValue, arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private String executeAndSpecialize(VirtualFrame frameValue, Object arguments0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            try {
                this.toStringNode_ = super.insert((JSToStringNode.create()));
                this.state_ = state = state | 0b1 /* add-active toLocaleString(VirtualFrame, Object, JSToStringNode) */;
                lock.unlock();
                hasLock = false;
                return toLocaleString(frameValue, arguments0Value, this.toStringNode_);
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
            s[0] = "toLocaleString";
            if (state != 0 /* is-active toLocaleString(VirtualFrame, Object, JSToStringNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.toStringNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static JSArrayToLocaleStringNode create(JSContext context, JSBuiltin builtin, boolean isTypedArrayImplementation, JavaScriptNode[] arguments) {
            return new JSArrayToLocaleStringNodeGen(context, builtin, isTypedArrayImplementation, arguments);
        }

    }
    @GeneratedBy(JSArraySpliceNode.class)
    public static final class JSArraySpliceNodeGen extends JSArraySpliceNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_;
        @Child private SpliceJSArrayNode spliceJSArray_;

        private JSArraySpliceNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state != 0 /* is-active splice(Object, Object[], SpliceJSArrayNode) */ && arguments1Value_ instanceof Object[]) {
                Object[] arguments1Value__ = (Object[]) arguments1Value_;
                return splice(arguments0Value_, arguments1Value__, this.spliceJSArray_);
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
                if (arguments1Value instanceof Object[]) {
                    Object[] arguments1Value_ = (Object[]) arguments1Value;
                    this.spliceJSArray_ = super.insert((SpliceJSArrayNodeGen.create(getContext())));
                    this.state_ = state = state | 0b1 /* add-active splice(Object, Object[], SpliceJSArrayNode) */;
                    lock.unlock();
                    hasLock = false;
                    return splice(arguments0Value, arguments1Value_, this.spliceJSArray_);
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
            s[0] = "splice";
            if (state != 0 /* is-active splice(Object, Object[], SpliceJSArrayNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.spliceJSArray_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static JSArraySpliceNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSArraySpliceNodeGen(context, builtin, arguments);
        }

        @GeneratedBy(SpliceJSArrayNode.class)
        static final class SpliceJSArrayNodeGen extends SpliceJSArrayNode implements Provider {

            @CompilationFinal private volatile int state_;
            @CompilationFinal private volatile int exclude_;
            @Child private CachedData cached_cache;
            @Child private GetPrototypeNode uncached_getPrototypeNode_;
            @CompilationFinal private ConditionProfile uncached_arrayElementwise_;

            private SpliceJSArrayNodeGen(JSContext context) {
                super(context);
            }

            @ExplodeLoop
            @Override
            void execute(DynamicObject arg0Value, long arg1Value, long arg2Value, long arg3Value, long arg4Value, ScriptArray arg5Value, JSArraySpliceNode arg6Value) {
                int state = state_;
                if (state != 0 /* is-active doCached(DynamicObject, long, long, long, long, ScriptArray, JSArraySpliceNode, ScriptArray, GetPrototypeNode, ConditionProfile) || doUncached(DynamicObject, long, long, long, long, ScriptArray, JSArraySpliceNode, GetPrototypeNode, ConditionProfile) */) {
                    if ((state & 0b1) != 0 /* is-active doCached(DynamicObject, long, long, long, long, ScriptArray, JSArraySpliceNode, ScriptArray, GetPrototypeNode, ConditionProfile) */) {
                        CachedData s1_ = this.cached_cache;
                        while (s1_ != null) {
                            if ((s1_.cachedArrayType_.isInstance(arg5Value))) {
                                SpliceJSArrayNode.doCached(arg0Value, arg1Value, arg2Value, arg3Value, arg4Value, arg5Value, arg6Value, s1_.cachedArrayType_, s1_.getPrototypeNode_, s1_.arrayElementwise_);
                                return;
                            }
                            s1_ = s1_.next_;
                        }
                    }
                    if ((state & 0b10) != 0 /* is-active doUncached(DynamicObject, long, long, long, long, ScriptArray, JSArraySpliceNode, GetPrototypeNode, ConditionProfile) */) {
                        SpliceJSArrayNode.doUncached(arg0Value, arg1Value, arg2Value, arg3Value, arg4Value, arg5Value, arg6Value, this.uncached_getPrototypeNode_, this.uncached_arrayElementwise_);
                        return;
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                executeAndSpecialize(arg0Value, arg1Value, arg2Value, arg3Value, arg4Value, arg5Value, arg6Value);
                return;
            }

            private void executeAndSpecialize(DynamicObject arg0Value, long arg1Value, long arg2Value, long arg3Value, long arg4Value, ScriptArray arg5Value, JSArraySpliceNode arg6Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                int state = state_;
                int exclude = exclude_;
                try {
                    if ((exclude) == 0 /* is-not-excluded doCached(DynamicObject, long, long, long, long, ScriptArray, JSArraySpliceNode, ScriptArray, GetPrototypeNode, ConditionProfile) */) {
                        int count1_ = 0;
                        CachedData s1_ = this.cached_cache;
                        if ((state & 0b1) != 0 /* is-active doCached(DynamicObject, long, long, long, long, ScriptArray, JSArraySpliceNode, ScriptArray, GetPrototypeNode, ConditionProfile) */) {
                            while (s1_ != null) {
                                if ((s1_.cachedArrayType_.isInstance(arg5Value))) {
                                    break;
                                }
                                s1_ = s1_.next_;
                                count1_++;
                            }
                        }
                        if (s1_ == null) {
                            {
                                ScriptArray cachedArrayType__ = (arg5Value);
                                if ((cachedArrayType__.isInstance(arg5Value)) && count1_ < (5)) {
                                    s1_ = super.insert(new CachedData(cached_cache));
                                    s1_.cachedArrayType_ = cachedArrayType__;
                                    s1_.getPrototypeNode_ = s1_.insertAccessor((GetPrototypeNode.create()));
                                    s1_.arrayElementwise_ = (ConditionProfile.create());
                                    this.cached_cache = s1_;
                                    this.state_ = state = state | 0b1 /* add-active doCached(DynamicObject, long, long, long, long, ScriptArray, JSArraySpliceNode, ScriptArray, GetPrototypeNode, ConditionProfile) */;
                                }
                            }
                        }
                        if (s1_ != null) {
                            lock.unlock();
                            hasLock = false;
                            SpliceJSArrayNode.doCached(arg0Value, arg1Value, arg2Value, arg3Value, arg4Value, arg5Value, arg6Value, s1_.cachedArrayType_, s1_.getPrototypeNode_, s1_.arrayElementwise_);
                            return;
                        }
                    }
                    this.uncached_getPrototypeNode_ = super.insert((GetPrototypeNode.create()));
                    this.uncached_arrayElementwise_ = (ConditionProfile.create());
                    this.exclude_ = exclude = exclude | 0b1 /* add-excluded doCached(DynamicObject, long, long, long, long, ScriptArray, JSArraySpliceNode, ScriptArray, GetPrototypeNode, ConditionProfile) */;
                    this.cached_cache = null;
                    state = state & 0xfffffffe /* remove-active doCached(DynamicObject, long, long, long, long, ScriptArray, JSArraySpliceNode, ScriptArray, GetPrototypeNode, ConditionProfile) */;
                    this.state_ = state = state | 0b10 /* add-active doUncached(DynamicObject, long, long, long, long, ScriptArray, JSArraySpliceNode, GetPrototypeNode, ConditionProfile) */;
                    lock.unlock();
                    hasLock = false;
                    SpliceJSArrayNode.doUncached(arg0Value, arg1Value, arg2Value, arg3Value, arg4Value, arg5Value, arg6Value, this.uncached_getPrototypeNode_, this.uncached_arrayElementwise_);
                    return;
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
            public Introspection getIntrospectionData() {
                Object[] data = new Object[3];
                Object[] s;
                data[0] = 0;
                int state = state_;
                int exclude = exclude_;
                s = new Object[3];
                s[0] = "doCached";
                if ((state & 0b1) != 0 /* is-active doCached(DynamicObject, long, long, long, long, ScriptArray, JSArraySpliceNode, ScriptArray, GetPrototypeNode, ConditionProfile) */) {
                    s[1] = (byte)0b01 /* active */;
                    ArrayList<Object> cached = new ArrayList<>();
                    CachedData s1_ = this.cached_cache;
                    while (s1_ != null) {
                        cached.add(Arrays.asList(s1_.cachedArrayType_, s1_.getPrototypeNode_, s1_.arrayElementwise_));
                        s1_ = s1_.next_;
                    }
                    s[2] = cached;
                } else if (exclude != 0 /* is-excluded doCached(DynamicObject, long, long, long, long, ScriptArray, JSArraySpliceNode, ScriptArray, GetPrototypeNode, ConditionProfile) */) {
                    s[1] = (byte)0b10 /* excluded */;
                } else {
                    s[1] = (byte)0b00 /* inactive */;
                }
                data[1] = s;
                s = new Object[3];
                s[0] = "doUncached";
                if ((state & 0b10) != 0 /* is-active doUncached(DynamicObject, long, long, long, long, ScriptArray, JSArraySpliceNode, GetPrototypeNode, ConditionProfile) */) {
                    s[1] = (byte)0b01 /* active */;
                    ArrayList<Object> cached = new ArrayList<>();
                    cached.add(Arrays.asList(this.uncached_getPrototypeNode_, this.uncached_arrayElementwise_));
                    s[2] = cached;
                } else {
                    s[1] = (byte)0b00 /* inactive */;
                }
                data[2] = s;
                return Provider.create(data);
            }

            public static SpliceJSArrayNode create(JSContext context) {
                return new SpliceJSArrayNodeGen(context);
            }

            @GeneratedBy(SpliceJSArrayNode.class)
            private static final class CachedData extends Node {

                @Child CachedData next_;
                @CompilationFinal ScriptArray cachedArrayType_;
                @Child GetPrototypeNode getPrototypeNode_;
                @CompilationFinal ConditionProfile arrayElementwise_;

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
    }
    @GeneratedBy(JSArrayEveryNode.class)
    public static final class JSArrayEveryNodeGen extends JSArrayEveryNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;

        private JSArrayEveryNodeGen(JSContext context, JSBuiltin builtin, boolean isTypedArrayImplementation, JavaScriptNode[] arguments) {
            super(context, builtin, isTypedArrayImplementation);
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
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            return every(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            return every(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            executeBoolean(frameValue);
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
            s[0] = "every";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSArrayEveryNode create(JSContext context, JSBuiltin builtin, boolean isTypedArrayImplementation, JavaScriptNode[] arguments) {
            return new JSArrayEveryNodeGen(context, builtin, isTypedArrayImplementation, arguments);
        }

    }
    @GeneratedBy(JSArrayFilterNode.class)
    public static final class JSArrayFilterNodeGen extends JSArrayFilterNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;

        private JSArrayFilterNodeGen(JSContext context, JSBuiltin builtin, boolean isTypedArrayImplementation, JavaScriptNode[] arguments) {
            super(context, builtin, isTypedArrayImplementation);
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
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            return filter(arguments0Value_, arguments1Value_, arguments2Value_);
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
            s[0] = "filter";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSArrayFilterNode create(JSContext context, JSBuiltin builtin, boolean isTypedArrayImplementation, JavaScriptNode[] arguments) {
            return new JSArrayFilterNodeGen(context, builtin, isTypedArrayImplementation, arguments);
        }

    }
    @GeneratedBy(JSArrayForEachNode.class)
    public static final class JSArrayForEachNodeGen extends JSArrayForEachNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;

        private JSArrayForEachNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            return forEach(arguments0Value_, arguments1Value_, arguments2Value_);
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
            s[0] = "forEach";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSArrayForEachNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSArrayForEachNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSArraySomeNode.class)
    public static final class JSArraySomeNodeGen extends JSArraySomeNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;

        private JSArraySomeNodeGen(JSContext context, JSBuiltin builtin, boolean isTypedArrayImplementation, JavaScriptNode[] arguments) {
            super(context, builtin, isTypedArrayImplementation);
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
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            return some(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            return some(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            executeBoolean(frameValue);
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
            s[0] = "some";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSArraySomeNode create(JSContext context, JSBuiltin builtin, boolean isTypedArrayImplementation, JavaScriptNode[] arguments) {
            return new JSArraySomeNodeGen(context, builtin, isTypedArrayImplementation, arguments);
        }

    }
    @GeneratedBy(JSArrayMapNode.class)
    public static final class JSArrayMapNodeGen extends JSArrayMapNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;

        private JSArrayMapNodeGen(JSContext context, JSBuiltin builtin, boolean isTypedArrayImplementation, JavaScriptNode[] arguments) {
            super(context, builtin, isTypedArrayImplementation);
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
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            return map(arguments0Value_, arguments1Value_, arguments2Value_);
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
            s[0] = "map";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSArrayMapNode create(JSContext context, JSBuiltin builtin, boolean isTypedArrayImplementation, JavaScriptNode[] arguments) {
            return new JSArrayMapNodeGen(context, builtin, isTypedArrayImplementation, arguments);
        }

    }
    @GeneratedBy(FlattenIntoArrayNode.class)
    public static final class FlattenIntoArrayNodeGen extends FlattenIntoArrayNode implements Provider {

        private FlattenIntoArrayNodeGen(JSContext context, boolean withMapCallback) {
            super(context, withMapCallback);
        }

        @Override
        protected long executeLong(DynamicObject arg0Value, Object arg1Value, long arg2Value, long arg3Value, long arg4Value, Object arg5Value, Object arg6Value) {
            return flatten(arg0Value, arg1Value, arg2Value, arg3Value, arg4Value, arg5Value, arg6Value);
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
            s[0] = "flatten";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static FlattenIntoArrayNode create(JSContext context, boolean withMapCallback) {
            return new FlattenIntoArrayNodeGen(context, withMapCallback);
        }

    }
    @GeneratedBy(JSArrayFlatMapNode.class)
    public static final class JSArrayFlatMapNodeGen extends JSArrayFlatMapNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private volatile int state_;
        @Child private FlattenIntoArrayNode flattenIntoArrayNode_;

        private JSArrayFlatMapNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state != 0 /* is-active flatMap(Object, Object, Object, FlattenIntoArrayNode) */) {
                return flatMap(arguments0Value_, arguments1Value_, arguments2Value_, this.flattenIntoArrayNode_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private Object executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            try {
                this.flattenIntoArrayNode_ = super.insert((JSArrayFlatMapNode.createFlattenIntoArrayNode(getContext())));
                this.state_ = state = state | 0b1 /* add-active flatMap(Object, Object, Object, FlattenIntoArrayNode) */;
                lock.unlock();
                hasLock = false;
                return flatMap(arguments0Value, arguments1Value, arguments2Value, this.flattenIntoArrayNode_);
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
            s[0] = "flatMap";
            if (state != 0 /* is-active flatMap(Object, Object, Object, FlattenIntoArrayNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.flattenIntoArrayNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static JSArrayFlatMapNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSArrayFlatMapNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSArrayFlatNode.class)
    public static final class JSArrayFlatNodeGen extends JSArrayFlatNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_;
        @Child private FlattenIntoArrayNode flattenIntoArrayNode_;

        private JSArrayFlatNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
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
            if (state != 0 /* is-active flat(Object, Object, FlattenIntoArrayNode) */) {
                return flat(arguments0Value_, arguments1Value_, this.flattenIntoArrayNode_);
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
                this.flattenIntoArrayNode_ = super.insert((JSArrayFlatNode.createFlattenIntoArrayNode(getContext())));
                this.state_ = state = state | 0b1 /* add-active flat(Object, Object, FlattenIntoArrayNode) */;
                lock.unlock();
                hasLock = false;
                return flat(arguments0Value, arguments1Value, this.flattenIntoArrayNode_);
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
            s[0] = "flat";
            if (state != 0 /* is-active flat(Object, Object, FlattenIntoArrayNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.flattenIntoArrayNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static JSArrayFlatNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSArrayFlatNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSArrayFindNode.class)
    public static final class JSArrayFindNodeGen extends JSArrayFindNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;

        private JSArrayFindNodeGen(JSContext context, JSBuiltin builtin, boolean isTypedArrayImplementation, JavaScriptNode[] arguments) {
            super(context, builtin, isTypedArrayImplementation);
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
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            return find(arguments0Value_, arguments1Value_, arguments2Value_);
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
            s[0] = "find";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSArrayFindNode create(JSContext context, JSBuiltin builtin, boolean isTypedArrayImplementation, JavaScriptNode[] arguments) {
            return new JSArrayFindNodeGen(context, builtin, isTypedArrayImplementation, arguments);
        }

    }
    @GeneratedBy(JSArrayFindIndexNode.class)
    public static final class JSArrayFindIndexNodeGen extends JSArrayFindIndexNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;

        private JSArrayFindIndexNodeGen(JSContext context, JSBuiltin builtin, boolean isTypedArrayImplementation, JavaScriptNode[] arguments) {
            super(context, builtin, isTypedArrayImplementation);
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
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            return findIndex(arguments0Value_, arguments1Value_, arguments2Value_);
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
            s[0] = "findIndex";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSArrayFindIndexNode create(JSContext context, JSBuiltin builtin, boolean isTypedArrayImplementation, JavaScriptNode[] arguments) {
            return new JSArrayFindIndexNodeGen(context, builtin, isTypedArrayImplementation, arguments);
        }

    }
    @GeneratedBy(JSArraySortNode.class)
    public static final class JSArraySortNodeGen extends JSArraySortNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_;
        @Child private JSArrayToDenseObjectArrayNode sortArray_arrayToObjectArrayNode_;
        @Child private JSArrayDeleteRangeNode sortArray_arrayDeleteRangeNode_;
        @CompilationFinal private Assumption sortArray_assumption0_;
        @CompilationFinal private ConditionProfile sort_isJSObject_;

        private JSArraySortNodeGen(JSContext context, JSBuiltin builtin, boolean isTypedArrayImplementation, JavaScriptNode[] arguments) {
            super(context, builtin, isTypedArrayImplementation);
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
            if (state != 0 /* is-active sortArray(DynamicObject, Object, JSArrayToDenseObjectArrayNode, JSArrayDeleteRangeNode) || sort(Object, Object, ConditionProfile) */) {
                if ((state & 0b1) != 0 /* is-active sortArray(DynamicObject, Object, JSArrayToDenseObjectArrayNode, JSArrayDeleteRangeNode) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if (!Assumption.isValidAssumption(this.sortArray_assumption0_)) {
                        CompilerDirectives.transferToInterpreterAndInvalidate();
                        removeSortArray_();
                        return executeAndSpecialize(arguments0Value__, arguments1Value_);
                    }
                    if ((JSGuards.isJSFastArray(arguments0Value__))) {
                        return sortArray(arguments0Value__, arguments1Value_, this.sortArray_arrayToObjectArrayNode_, this.sortArray_arrayDeleteRangeNode_);
                    }
                }
                if ((state & 0b10) != 0 /* is-active sort(Object, Object, ConditionProfile) */) {
                    return sort(arguments0Value_, arguments1Value_, this.sort_isJSObject_);
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
                    if ((JSGuards.isJSFastArray(arguments0Value_))) {
                        Assumption sortArray_assumption0 = (getContext().getArrayPrototypeNoElementsAssumption());
                        if (Assumption.isValidAssumption(sortArray_assumption0)) {
                            this.sortArray_arrayToObjectArrayNode_ = super.insert((JSArrayToDenseObjectArrayNode.create(getContext())));
                            this.sortArray_arrayDeleteRangeNode_ = super.insert((JSArrayDeleteRangeNode.create(getContext(), !(getContext().isOptionV8CompatibilityMode()))));
                            this.sortArray_assumption0_ = sortArray_assumption0;
                            this.state_ = state = state | 0b1 /* add-active sortArray(DynamicObject, Object, JSArrayToDenseObjectArrayNode, JSArrayDeleteRangeNode) */;
                            lock.unlock();
                            hasLock = false;
                            return sortArray(arguments0Value_, arguments1Value, this.sortArray_arrayToObjectArrayNode_, this.sortArray_arrayDeleteRangeNode_);
                        }
                    }
                }
                this.sort_isJSObject_ = (ConditionProfile.createBinaryProfile());
                this.state_ = state = state | 0b10 /* add-active sort(Object, Object, ConditionProfile) */;
                lock.unlock();
                hasLock = false;
                return sort(arguments0Value, arguments1Value, this.sort_isJSObject_);
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

        void removeSortArray_() {
            Lock lock = getLock();
            lock.lock();
            try {
                this.state_ = this.state_ & 0xfffffffe /* remove-active sortArray(DynamicObject, Object, JSArrayToDenseObjectArrayNode, JSArrayDeleteRangeNode) */;
            } finally {
                lock.unlock();
            }
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[3];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "sortArray";
            if ((state & 0b1) != 0 /* is-active sortArray(DynamicObject, Object, JSArrayToDenseObjectArrayNode, JSArrayDeleteRangeNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.sortArray_arrayToObjectArrayNode_, this.sortArray_arrayDeleteRangeNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "sort";
            if ((state & 0b10) != 0 /* is-active sort(Object, Object, ConditionProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.sort_isJSObject_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static JSArraySortNode create(JSContext context, JSBuiltin builtin, boolean isTypedArrayImplementation, JavaScriptNode[] arguments) {
            return new JSArraySortNodeGen(context, builtin, isTypedArrayImplementation, arguments);
        }

    }
    @GeneratedBy(JSArrayReduceNode.class)
    public static final class JSArrayReduceNodeGen extends JSArrayReduceNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private int state_;

        private JSArrayReduceNodeGen(JSContext context, JSBuiltin builtin, boolean isTypedArrayImplementation, boolean isForward, JavaScriptNode[] arguments) {
            super(context, builtin, isTypedArrayImplementation, isForward);
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
            if (state != 0 /* is-active reduce(Object, Object, Object[]) */ && arguments2Value_ instanceof Object[]) {
                Object[] arguments2Value__ = (Object[]) arguments2Value_;
                return reduce(arguments0Value_, arguments1Value_, arguments2Value__);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private Object executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            int state = state_;
            if (arguments2Value instanceof Object[]) {
                Object[] arguments2Value_ = (Object[]) arguments2Value;
                this.state_ = state = state | 0b1 /* add-active reduce(Object, Object, Object[]) */;
                return reduce(arguments0Value, arguments1Value, arguments2Value_);
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
            s[0] = "reduce";
            if (state != 0 /* is-active reduce(Object, Object, Object[]) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static JSArrayReduceNode create(JSContext context, JSBuiltin builtin, boolean isTypedArrayImplementation, boolean isForward, JavaScriptNode[] arguments) {
            return new JSArrayReduceNodeGen(context, builtin, isTypedArrayImplementation, isForward, arguments);
        }

    }
    @GeneratedBy(JSArrayFillNode.class)
    public static final class JSArrayFillNodeGen extends JSArrayFillNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @Child private JavaScriptNode arguments3_;

        private JSArrayFillNodeGen(JSContext context, JSBuiltin builtin, boolean isTypedArrayImplementation, JavaScriptNode[] arguments) {
            super(context, builtin, isTypedArrayImplementation);
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
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            Object arguments3Value_ = this.arguments3_.execute(frameValue);
            return fill(arguments0Value_, arguments1Value_, arguments2Value_, arguments3Value_);
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
            s[0] = "fill";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSArrayFillNode create(JSContext context, JSBuiltin builtin, boolean isTypedArrayImplementation, JavaScriptNode[] arguments) {
            return new JSArrayFillNodeGen(context, builtin, isTypedArrayImplementation, arguments);
        }

    }
    @GeneratedBy(JSArrayCopyWithinNode.class)
    public static final class JSArrayCopyWithinNodeGen extends JSArrayCopyWithinNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @Child private JavaScriptNode arguments3_;

        private JSArrayCopyWithinNodeGen(JSContext context, JSBuiltin builtin, boolean isTypedArrayImplementation, JavaScriptNode[] arguments) {
            super(context, builtin, isTypedArrayImplementation);
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
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            Object arguments3Value_ = this.arguments3_.execute(frameValue);
            return copyWithin(arguments0Value_, arguments1Value_, arguments2Value_, arguments3Value_);
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
            s[0] = "copyWithin";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSArrayCopyWithinNode create(JSContext context, JSBuiltin builtin, boolean isTypedArrayImplementation, JavaScriptNode[] arguments) {
            return new JSArrayCopyWithinNodeGen(context, builtin, isTypedArrayImplementation, arguments);
        }

    }
    @GeneratedBy(JSArrayIncludesNode.class)
    public static final class JSArrayIncludesNodeGen extends JSArrayIncludesNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @Child private JavaScriptNode arguments2_;
        @CompilationFinal private volatile int state_;
        @Child private JSIdenticalNode identicalNode_;

        private JSArrayIncludesNodeGen(JSContext context, JSBuiltin builtin, boolean isTypedArrayImplementation, JavaScriptNode[] arguments) {
            super(context, builtin, isTypedArrayImplementation);
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
            if (state != 0 /* is-active includes(Object, Object, Object, JSIdenticalNode) */) {
                return includes(arguments0Value_, arguments1Value_, arguments2Value_, this.identicalNode_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            Object arguments2Value_ = this.arguments2_.execute(frameValue);
            if (state != 0 /* is-active includes(Object, Object, Object, JSIdenticalNode) */) {
                return includes(arguments0Value_, arguments1Value_, arguments2Value_, this.identicalNode_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_, arguments2Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            executeBoolean(frameValue);
            return;
        }

        private boolean executeAndSpecialize(Object arguments0Value, Object arguments1Value, Object arguments2Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            try {
                this.identicalNode_ = super.insert((JSIdenticalNode.createSameValueZero()));
                this.state_ = state = state | 0b1 /* add-active includes(Object, Object, Object, JSIdenticalNode) */;
                lock.unlock();
                hasLock = false;
                return includes(arguments0Value, arguments1Value, arguments2Value, this.identicalNode_);
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
            s[0] = "includes";
            if (state != 0 /* is-active includes(Object, Object, Object, JSIdenticalNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.identicalNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static JSArrayIncludesNode create(JSContext context, JSBuiltin builtin, boolean isTypedArrayImplementation, JavaScriptNode[] arguments) {
            return new JSArrayIncludesNodeGen(context, builtin, isTypedArrayImplementation, arguments);
        }

    }
    @GeneratedBy(JSArrayReverseNode.class)
    public static final class JSArrayReverseNodeGen extends JSArrayReverseNode implements Provider {

        @Child private JavaScriptNode arguments0_;

        private JSArrayReverseNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            return reverse(arguments0Value_);
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
            s[0] = "reverse";
            s[1] = (byte)0b01 /* active */;
            data[1] = s;
            return Provider.create(data);
        }

        public static JSArrayReverseNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new JSArrayReverseNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(JSArrayIteratorNode.class)
    public static final class JSArrayIteratorNodeGen extends JSArrayIteratorNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private volatile int state_;
        @Child private JSToObjectNode notJSObject_toObjectNode_;

        private JSArrayIteratorNodeGen(JSContext context, JSBuiltin builtin, int iterationKind, JavaScriptNode[] arguments) {
            super(context, builtin, iterationKind);
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
            if ((state & 0b1) != 0 /* is-active doJSObject(VirtualFrame, DynamicObject) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((JSGuards.isJSObject(arguments0Value__))) {
                    return doJSObject(frameValue, arguments0Value__);
                }
            }
            if ((state & 0b10) != 0 /* is-active doNotJSObject(VirtualFrame, Object, JSToObjectNode) */) {
                if ((!(JSGuards.isJSObject(arguments0Value_)))) {
                    return doNotJSObject(frameValue, arguments0Value_, this.notJSObject_toObjectNode_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(frameValue, arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(VirtualFrame frameValue, Object arguments0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            try {
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((JSGuards.isJSObject(arguments0Value_))) {
                        this.state_ = state = state | 0b1 /* add-active doJSObject(VirtualFrame, DynamicObject) */;
                        lock.unlock();
                        hasLock = false;
                        return doJSObject(frameValue, arguments0Value_);
                    }
                }
                if ((!(JSGuards.isJSObject(arguments0Value)))) {
                    this.notJSObject_toObjectNode_ = super.insert((JSToObjectNode.createToObject(getContext())));
                    this.state_ = state = state | 0b10 /* add-active doNotJSObject(VirtualFrame, Object, JSToObjectNode) */;
                    lock.unlock();
                    hasLock = false;
                    return doNotJSObject(frameValue, arguments0Value, this.notJSObject_toObjectNode_);
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
            s[0] = "doJSObject";
            if ((state & 0b1) != 0 /* is-active doJSObject(VirtualFrame, DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doNotJSObject";
            if ((state & 0b10) != 0 /* is-active doNotJSObject(VirtualFrame, Object, JSToObjectNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.notJSObject_toObjectNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static JSArrayIteratorNode create(JSContext context, JSBuiltin builtin, int iterationKind, JavaScriptNode[] arguments) {
            return new JSArrayIteratorNodeGen(context, builtin, iterationKind, arguments);
        }

    }
}
