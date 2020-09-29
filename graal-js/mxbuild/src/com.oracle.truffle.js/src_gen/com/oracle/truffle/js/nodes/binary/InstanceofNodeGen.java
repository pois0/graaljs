// CheckStyle: start generated
package com.oracle.truffle.js.nodes.binary;

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
import com.oracle.truffle.api.object.Shape;
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.access.GetMethodNode;
import com.oracle.truffle.js.nodes.access.GetPrototypeNode;
import com.oracle.truffle.js.nodes.access.IsJSObjectNode;
import com.oracle.truffle.js.nodes.cast.JSToBooleanNode;
import com.oracle.truffle.js.nodes.function.JSFunctionCallNode;
import com.oracle.truffle.js.runtime.BigInt;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.Symbol;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(InstanceofNode.class)
@SuppressWarnings("unused")
public final class InstanceofNodeGen extends InstanceofNode implements Provider {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @Child private JSObjectData jSObject_cache;
    @Child private ForeignTargetOther0Data foreignTargetOther0_cache;

    private InstanceofNodeGen(JSContext context, JavaScriptNode left, JavaScriptNode right) {
        super(context, left, right);
    }

    @ExplodeLoop
    @Override
    public boolean executeBoolean(Object leftNodeValue, Object rightNodeValue) {
        int state = state_;
        if ((state & 0b1111111) != 0 /* is-active doJSObject(Object, DynamicObject, IsJSObjectNode, GetMethodNode, JSToBooleanNode, JSFunctionCallNode, ConditionProfile, BranchProfile, BranchProfile) || doNullOrUndefinedTarget(Object, DynamicObject) || doStringTarget(Object, String) || doDoubleTarget(Object, double) || doBooleanTarget(Object, boolean) || doBigIntTarget(Object, BigInt) || doSymbolTarget(Object, Symbol) */) {
            if ((state & 0b11) != 0 /* is-active doJSObject(Object, DynamicObject, IsJSObjectNode, GetMethodNode, JSToBooleanNode, JSFunctionCallNode, ConditionProfile, BranchProfile, BranchProfile) || doNullOrUndefinedTarget(Object, DynamicObject) */ && JSTypes.isDynamicObject(rightNodeValue)) {
                DynamicObject rightNodeValue_ = (DynamicObject) rightNodeValue;
                if ((state & 0b1) != 0 /* is-active doJSObject(Object, DynamicObject, IsJSObjectNode, GetMethodNode, JSToBooleanNode, JSFunctionCallNode, ConditionProfile, BranchProfile, BranchProfile) */) {
                    JSObjectData s1_ = this.jSObject_cache;
                    if (s1_ != null) {
                        if ((s1_.isObjectNode_.executeBoolean(rightNodeValue_))) {
                            return doJSObject(leftNodeValue, rightNodeValue_, s1_.isObjectNode_, s1_.getMethodHasInstanceNode_, s1_.toBooleanNode_, s1_.callHasInstanceNode_, s1_.hasInstanceProfile_, s1_.errorBranch_, s1_.proxyBranch_);
                        }
                    }
                }
                if ((state & 0b10) != 0 /* is-active doNullOrUndefinedTarget(Object, DynamicObject) */) {
                    if ((JSGuards.isNullOrUndefined(rightNodeValue_))) {
                        return doNullOrUndefinedTarget(leftNodeValue, rightNodeValue_);
                    }
                }
            }
            if ((state & 0b100) != 0 /* is-active doStringTarget(Object, String) */ && JSTypesGen.isImplicitString((state & 0b11110000000000) >>> 10 /* extract-implicit-active 1:String */, rightNodeValue)) {
                String rightNodeValue_ = JSTypesGen.asImplicitString((state & 0b11110000000000) >>> 10 /* extract-implicit-active 1:String */, rightNodeValue);
                return doStringTarget(leftNodeValue, rightNodeValue_);
            }
            if ((state & 0b1000) != 0 /* is-active doDoubleTarget(Object, double) */ && JSTypesGen.isImplicitDouble((state & 0x3c000) >>> 14 /* extract-implicit-active 1:double */, rightNodeValue)) {
                double rightNodeValue_ = JSTypesGen.asImplicitDouble((state & 0x3c000) >>> 14 /* extract-implicit-active 1:double */, rightNodeValue);
                return doDoubleTarget(leftNodeValue, rightNodeValue_);
            }
            if ((state & 0b10000) != 0 /* is-active doBooleanTarget(Object, boolean) */ && rightNodeValue instanceof Boolean) {
                boolean rightNodeValue_ = (boolean) rightNodeValue;
                return doBooleanTarget(leftNodeValue, rightNodeValue_);
            }
            if ((state & 0b100000) != 0 /* is-active doBigIntTarget(Object, BigInt) */ && rightNodeValue instanceof BigInt) {
                BigInt rightNodeValue_ = (BigInt) rightNodeValue;
                return doBigIntTarget(leftNodeValue, rightNodeValue_);
            }
            if ((state & 0b1000000) != 0 /* is-active doSymbolTarget(Object, Symbol) */ && rightNodeValue instanceof Symbol) {
                Symbol rightNodeValue_ = (Symbol) rightNodeValue;
                return doSymbolTarget(leftNodeValue, rightNodeValue_);
            }
        }
        if ((state & 0b1110000000) != 0 /* is-active doForeignTargetJSType(DynamicObject, Object) || doForeignTargetOther(Object, Object, InteropLibrary) || doForeignTargetOther(Object, Object, InteropLibrary) */) {
            if ((state & 0b10000000) != 0 /* is-active doForeignTargetJSType(DynamicObject, Object) */ && JSTypes.isDynamicObject(leftNodeValue)) {
                DynamicObject leftNodeValue_ = (DynamicObject) leftNodeValue;
                if ((JSGuards.isForeignObject(rightNodeValue)) && (JSGuards.isJSDynamicObject(leftNodeValue_))) {
                    return doForeignTargetJSType(leftNodeValue_, rightNodeValue);
                }
            }
            if ((state & 0b1100000000) != 0 /* is-active doForeignTargetOther(Object, Object, InteropLibrary) || doForeignTargetOther(Object, Object, InteropLibrary) */) {
                if ((state & 0b100000000) != 0 /* is-active doForeignTargetOther(Object, Object, InteropLibrary) */) {
                    ForeignTargetOther0Data s9_ = this.foreignTargetOther0_cache;
                    while (s9_ != null) {
                        if ((s9_.interop_.accepts(rightNodeValue)) && (JSGuards.isForeignObject(rightNodeValue)) && (!(JSGuards.isJSDynamicObject(leftNodeValue)))) {
                            return doForeignTargetOther(leftNodeValue, rightNodeValue, s9_.interop_);
                        }
                        s9_ = s9_.next_;
                    }
                }
                if ((state & 0b1000000000) != 0 /* is-active doForeignTargetOther(Object, Object, InteropLibrary) */) {
                    if ((JSGuards.isForeignObject(rightNodeValue)) && (!(JSGuards.isJSDynamicObject(leftNodeValue)))) {
                        return this.foreignTargetOther1Boundary(state, leftNodeValue, rightNodeValue);
                    }
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(leftNodeValue, rightNodeValue);
    }

    @TruffleBoundary
    private boolean foreignTargetOther1Boundary(int state, Object leftNodeValue, Object rightNodeValue) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary foreignTargetOther1_interop__ = (INTEROP_LIBRARY_.getUncached(rightNodeValue));
                return doForeignTargetOther(leftNodeValue, rightNodeValue, foreignTargetOther1_interop__);
            }
        } finally {
            encapsulating_.set(prev_);
        }
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        int state = state_;
        if ((state & 0b1111110111) == 0 /* only-active doDoubleTarget(Object, double) */ && (state & 0b1111111111) != 0  /* is-not doJSObject(Object, DynamicObject, IsJSObjectNode, GetMethodNode, JSToBooleanNode, JSFunctionCallNode, ConditionProfile, BranchProfile, BranchProfile) && doNullOrUndefinedTarget(Object, DynamicObject) && doStringTarget(Object, String) && doDoubleTarget(Object, double) && doBooleanTarget(Object, boolean) && doBigIntTarget(Object, BigInt) && doSymbolTarget(Object, Symbol) && doForeignTargetJSType(DynamicObject, Object) && doForeignTargetOther(Object, Object, InteropLibrary) && doForeignTargetOther(Object, Object, InteropLibrary) */) {
            return execute_double0(frameValue, state);
        } else if ((state & 0b1111101111) == 0 /* only-active doBooleanTarget(Object, boolean) */ && (state & 0b1111111111) != 0  /* is-not doJSObject(Object, DynamicObject, IsJSObjectNode, GetMethodNode, JSToBooleanNode, JSFunctionCallNode, ConditionProfile, BranchProfile, BranchProfile) && doNullOrUndefinedTarget(Object, DynamicObject) && doStringTarget(Object, String) && doDoubleTarget(Object, double) && doBooleanTarget(Object, boolean) && doBigIntTarget(Object, BigInt) && doSymbolTarget(Object, Symbol) && doForeignTargetJSType(DynamicObject, Object) && doForeignTargetOther(Object, Object, InteropLibrary) && doForeignTargetOther(Object, Object, InteropLibrary) */) {
            return execute_boolean1(frameValue, state);
        } else {
            return execute_generic2(frameValue, state);
        }
    }

    private Object execute_double0(VirtualFrame frameValue, int state) {
        Object leftNodeValue_ = super.leftNode.execute(frameValue);
        int rightNodeValue_int = 0;
        long rightNodeValue_long = 0L;
        double rightNodeValue_;
        try {
            if ((state & 0x38000) == 0 /* only-active 1:double */ && (state & 0b1111111111) != 0  /* is-not doJSObject(Object, DynamicObject, IsJSObjectNode, GetMethodNode, JSToBooleanNode, JSFunctionCallNode, ConditionProfile, BranchProfile, BranchProfile) && doNullOrUndefinedTarget(Object, DynamicObject) && doStringTarget(Object, String) && doDoubleTarget(Object, double) && doBooleanTarget(Object, boolean) && doBigIntTarget(Object, BigInt) && doSymbolTarget(Object, Symbol) && doForeignTargetJSType(DynamicObject, Object) && doForeignTargetOther(Object, Object, InteropLibrary) && doForeignTargetOther(Object, Object, InteropLibrary) */) {
                rightNodeValue_long = super.rightNode.executeLong(frameValue);
                rightNodeValue_ = JSTypes.longToDouble(rightNodeValue_long);
            } else if ((state & 0x34000) == 0 /* only-active 1:double */ && (state & 0b1111111111) != 0  /* is-not doJSObject(Object, DynamicObject, IsJSObjectNode, GetMethodNode, JSToBooleanNode, JSFunctionCallNode, ConditionProfile, BranchProfile, BranchProfile) && doNullOrUndefinedTarget(Object, DynamicObject) && doStringTarget(Object, String) && doDoubleTarget(Object, double) && doBooleanTarget(Object, boolean) && doBigIntTarget(Object, BigInt) && doSymbolTarget(Object, Symbol) && doForeignTargetJSType(DynamicObject, Object) && doForeignTargetOther(Object, Object, InteropLibrary) && doForeignTargetOther(Object, Object, InteropLibrary) */) {
                rightNodeValue_int = super.rightNode.executeInt(frameValue);
                rightNodeValue_ = JSTypes.intToDouble(rightNodeValue_int);
            } else if ((state & 0x2c000) == 0 /* only-active 1:double */ && (state & 0b1111111111) != 0  /* is-not doJSObject(Object, DynamicObject, IsJSObjectNode, GetMethodNode, JSToBooleanNode, JSFunctionCallNode, ConditionProfile, BranchProfile, BranchProfile) && doNullOrUndefinedTarget(Object, DynamicObject) && doStringTarget(Object, String) && doDoubleTarget(Object, double) && doBooleanTarget(Object, boolean) && doBigIntTarget(Object, BigInt) && doSymbolTarget(Object, Symbol) && doForeignTargetJSType(DynamicObject, Object) && doForeignTargetOther(Object, Object, InteropLibrary) && doForeignTargetOther(Object, Object, InteropLibrary) */) {
                rightNodeValue_ = super.rightNode.executeDouble(frameValue);
            } else {
                Object rightNodeValue__ = super.rightNode.execute(frameValue);
                rightNodeValue_ = JSTypesGen.expectImplicitDouble((state & 0x3c000) >>> 14 /* extract-implicit-active 1:double */, rightNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(leftNodeValue_, ex.getResult());
        }
        assert (state & 0b1000) != 0 /* is-active doDoubleTarget(Object, double) */;
        return doDoubleTarget(leftNodeValue_, rightNodeValue_);
    }

    private Object execute_boolean1(VirtualFrame frameValue, int state) {
        Object leftNodeValue_ = super.leftNode.execute(frameValue);
        boolean rightNodeValue_;
        try {
            rightNodeValue_ = super.rightNode.executeBoolean(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(leftNodeValue_, ex.getResult());
        }
        assert (state & 0b10000) != 0 /* is-active doBooleanTarget(Object, boolean) */;
        return doBooleanTarget(leftNodeValue_, rightNodeValue_);
    }

    @TruffleBoundary
    private Object foreignTargetOther1Boundary0(int state, Object leftNodeValue_, Object rightNodeValue_) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary foreignTargetOther1_interop__ = (INTEROP_LIBRARY_.getUncached(rightNodeValue_));
                return doForeignTargetOther(leftNodeValue_, rightNodeValue_, foreignTargetOther1_interop__);
            }
        } finally {
            encapsulating_.set(prev_);
        }
    }

    @ExplodeLoop
    private Object execute_generic2(VirtualFrame frameValue, int state) {
        Object leftNodeValue_ = super.leftNode.execute(frameValue);
        Object rightNodeValue_ = super.rightNode.execute(frameValue);
        if ((state & 0b1111111) != 0 /* is-active doJSObject(Object, DynamicObject, IsJSObjectNode, GetMethodNode, JSToBooleanNode, JSFunctionCallNode, ConditionProfile, BranchProfile, BranchProfile) || doNullOrUndefinedTarget(Object, DynamicObject) || doStringTarget(Object, String) || doDoubleTarget(Object, double) || doBooleanTarget(Object, boolean) || doBigIntTarget(Object, BigInt) || doSymbolTarget(Object, Symbol) */) {
            if ((state & 0b11) != 0 /* is-active doJSObject(Object, DynamicObject, IsJSObjectNode, GetMethodNode, JSToBooleanNode, JSFunctionCallNode, ConditionProfile, BranchProfile, BranchProfile) || doNullOrUndefinedTarget(Object, DynamicObject) */ && JSTypes.isDynamicObject(rightNodeValue_)) {
                DynamicObject rightNodeValue__ = (DynamicObject) rightNodeValue_;
                if ((state & 0b1) != 0 /* is-active doJSObject(Object, DynamicObject, IsJSObjectNode, GetMethodNode, JSToBooleanNode, JSFunctionCallNode, ConditionProfile, BranchProfile, BranchProfile) */) {
                    JSObjectData s1_ = this.jSObject_cache;
                    if (s1_ != null) {
                        if ((s1_.isObjectNode_.executeBoolean(rightNodeValue__))) {
                            return doJSObject(leftNodeValue_, rightNodeValue__, s1_.isObjectNode_, s1_.getMethodHasInstanceNode_, s1_.toBooleanNode_, s1_.callHasInstanceNode_, s1_.hasInstanceProfile_, s1_.errorBranch_, s1_.proxyBranch_);
                        }
                    }
                }
                if ((state & 0b10) != 0 /* is-active doNullOrUndefinedTarget(Object, DynamicObject) */) {
                    if ((JSGuards.isNullOrUndefined(rightNodeValue__))) {
                        return doNullOrUndefinedTarget(leftNodeValue_, rightNodeValue__);
                    }
                }
            }
            if ((state & 0b100) != 0 /* is-active doStringTarget(Object, String) */ && JSTypesGen.isImplicitString((state & 0b11110000000000) >>> 10 /* extract-implicit-active 1:String */, rightNodeValue_)) {
                String rightNodeValue__ = JSTypesGen.asImplicitString((state & 0b11110000000000) >>> 10 /* extract-implicit-active 1:String */, rightNodeValue_);
                return doStringTarget(leftNodeValue_, rightNodeValue__);
            }
            if ((state & 0b1000) != 0 /* is-active doDoubleTarget(Object, double) */ && JSTypesGen.isImplicitDouble((state & 0x3c000) >>> 14 /* extract-implicit-active 1:double */, rightNodeValue_)) {
                double rightNodeValue__ = JSTypesGen.asImplicitDouble((state & 0x3c000) >>> 14 /* extract-implicit-active 1:double */, rightNodeValue_);
                return doDoubleTarget(leftNodeValue_, rightNodeValue__);
            }
            if ((state & 0b10000) != 0 /* is-active doBooleanTarget(Object, boolean) */ && rightNodeValue_ instanceof Boolean) {
                boolean rightNodeValue__ = (boolean) rightNodeValue_;
                return doBooleanTarget(leftNodeValue_, rightNodeValue__);
            }
            if ((state & 0b100000) != 0 /* is-active doBigIntTarget(Object, BigInt) */ && rightNodeValue_ instanceof BigInt) {
                BigInt rightNodeValue__ = (BigInt) rightNodeValue_;
                return doBigIntTarget(leftNodeValue_, rightNodeValue__);
            }
            if ((state & 0b1000000) != 0 /* is-active doSymbolTarget(Object, Symbol) */ && rightNodeValue_ instanceof Symbol) {
                Symbol rightNodeValue__ = (Symbol) rightNodeValue_;
                return doSymbolTarget(leftNodeValue_, rightNodeValue__);
            }
        }
        if ((state & 0b1110000000) != 0 /* is-active doForeignTargetJSType(DynamicObject, Object) || doForeignTargetOther(Object, Object, InteropLibrary) || doForeignTargetOther(Object, Object, InteropLibrary) */) {
            if ((state & 0b10000000) != 0 /* is-active doForeignTargetJSType(DynamicObject, Object) */ && JSTypes.isDynamicObject(leftNodeValue_)) {
                DynamicObject leftNodeValue__ = (DynamicObject) leftNodeValue_;
                if ((JSGuards.isForeignObject(rightNodeValue_)) && (JSGuards.isJSDynamicObject(leftNodeValue__))) {
                    return doForeignTargetJSType(leftNodeValue__, rightNodeValue_);
                }
            }
            if ((state & 0b1100000000) != 0 /* is-active doForeignTargetOther(Object, Object, InteropLibrary) || doForeignTargetOther(Object, Object, InteropLibrary) */) {
                if ((state & 0b100000000) != 0 /* is-active doForeignTargetOther(Object, Object, InteropLibrary) */) {
                    ForeignTargetOther0Data s9_ = this.foreignTargetOther0_cache;
                    while (s9_ != null) {
                        if ((s9_.interop_.accepts(rightNodeValue_)) && (JSGuards.isForeignObject(rightNodeValue_)) && (!(JSGuards.isJSDynamicObject(leftNodeValue_)))) {
                            return doForeignTargetOther(leftNodeValue_, rightNodeValue_, s9_.interop_);
                        }
                        s9_ = s9_.next_;
                    }
                }
                if ((state & 0b1000000000) != 0 /* is-active doForeignTargetOther(Object, Object, InteropLibrary) */) {
                    if ((JSGuards.isForeignObject(rightNodeValue_)) && (!(JSGuards.isJSDynamicObject(leftNodeValue_)))) {
                        return this.foreignTargetOther1Boundary0(state, leftNodeValue_, rightNodeValue_);
                    }
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
    }

    @Override
    public boolean executeBoolean(VirtualFrame frameValue) {
        int state = state_;
        if ((state & 0b1111110111) == 0 /* only-active doDoubleTarget(Object, double) */ && (state & 0b1111111111) != 0  /* is-not doJSObject(Object, DynamicObject, IsJSObjectNode, GetMethodNode, JSToBooleanNode, JSFunctionCallNode, ConditionProfile, BranchProfile, BranchProfile) && doNullOrUndefinedTarget(Object, DynamicObject) && doStringTarget(Object, String) && doDoubleTarget(Object, double) && doBooleanTarget(Object, boolean) && doBigIntTarget(Object, BigInt) && doSymbolTarget(Object, Symbol) && doForeignTargetJSType(DynamicObject, Object) && doForeignTargetOther(Object, Object, InteropLibrary) && doForeignTargetOther(Object, Object, InteropLibrary) */) {
            return executeBoolean_double3(frameValue, state);
        } else if ((state & 0b1111101111) == 0 /* only-active doBooleanTarget(Object, boolean) */ && (state & 0b1111111111) != 0  /* is-not doJSObject(Object, DynamicObject, IsJSObjectNode, GetMethodNode, JSToBooleanNode, JSFunctionCallNode, ConditionProfile, BranchProfile, BranchProfile) && doNullOrUndefinedTarget(Object, DynamicObject) && doStringTarget(Object, String) && doDoubleTarget(Object, double) && doBooleanTarget(Object, boolean) && doBigIntTarget(Object, BigInt) && doSymbolTarget(Object, Symbol) && doForeignTargetJSType(DynamicObject, Object) && doForeignTargetOther(Object, Object, InteropLibrary) && doForeignTargetOther(Object, Object, InteropLibrary) */) {
            return executeBoolean_boolean4(frameValue, state);
        } else {
            return executeBoolean_generic5(frameValue, state);
        }
    }

    private boolean executeBoolean_double3(VirtualFrame frameValue, int state) {
        Object leftNodeValue_ = super.leftNode.execute(frameValue);
        int rightNodeValue_int = 0;
        long rightNodeValue_long = 0L;
        double rightNodeValue_;
        try {
            if ((state & 0x38000) == 0 /* only-active 1:double */ && (state & 0b1111111111) != 0  /* is-not doJSObject(Object, DynamicObject, IsJSObjectNode, GetMethodNode, JSToBooleanNode, JSFunctionCallNode, ConditionProfile, BranchProfile, BranchProfile) && doNullOrUndefinedTarget(Object, DynamicObject) && doStringTarget(Object, String) && doDoubleTarget(Object, double) && doBooleanTarget(Object, boolean) && doBigIntTarget(Object, BigInt) && doSymbolTarget(Object, Symbol) && doForeignTargetJSType(DynamicObject, Object) && doForeignTargetOther(Object, Object, InteropLibrary) && doForeignTargetOther(Object, Object, InteropLibrary) */) {
                rightNodeValue_long = super.rightNode.executeLong(frameValue);
                rightNodeValue_ = JSTypes.longToDouble(rightNodeValue_long);
            } else if ((state & 0x34000) == 0 /* only-active 1:double */ && (state & 0b1111111111) != 0  /* is-not doJSObject(Object, DynamicObject, IsJSObjectNode, GetMethodNode, JSToBooleanNode, JSFunctionCallNode, ConditionProfile, BranchProfile, BranchProfile) && doNullOrUndefinedTarget(Object, DynamicObject) && doStringTarget(Object, String) && doDoubleTarget(Object, double) && doBooleanTarget(Object, boolean) && doBigIntTarget(Object, BigInt) && doSymbolTarget(Object, Symbol) && doForeignTargetJSType(DynamicObject, Object) && doForeignTargetOther(Object, Object, InteropLibrary) && doForeignTargetOther(Object, Object, InteropLibrary) */) {
                rightNodeValue_int = super.rightNode.executeInt(frameValue);
                rightNodeValue_ = JSTypes.intToDouble(rightNodeValue_int);
            } else if ((state & 0x2c000) == 0 /* only-active 1:double */ && (state & 0b1111111111) != 0  /* is-not doJSObject(Object, DynamicObject, IsJSObjectNode, GetMethodNode, JSToBooleanNode, JSFunctionCallNode, ConditionProfile, BranchProfile, BranchProfile) && doNullOrUndefinedTarget(Object, DynamicObject) && doStringTarget(Object, String) && doDoubleTarget(Object, double) && doBooleanTarget(Object, boolean) && doBigIntTarget(Object, BigInt) && doSymbolTarget(Object, Symbol) && doForeignTargetJSType(DynamicObject, Object) && doForeignTargetOther(Object, Object, InteropLibrary) && doForeignTargetOther(Object, Object, InteropLibrary) */) {
                rightNodeValue_ = super.rightNode.executeDouble(frameValue);
            } else {
                Object rightNodeValue__ = super.rightNode.execute(frameValue);
                rightNodeValue_ = JSTypesGen.expectImplicitDouble((state & 0x3c000) >>> 14 /* extract-implicit-active 1:double */, rightNodeValue__);
            }
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(leftNodeValue_, ex.getResult());
        }
        assert (state & 0b1000) != 0 /* is-active doDoubleTarget(Object, double) */;
        return doDoubleTarget(leftNodeValue_, rightNodeValue_);
    }

    private boolean executeBoolean_boolean4(VirtualFrame frameValue, int state) {
        Object leftNodeValue_ = super.leftNode.execute(frameValue);
        boolean rightNodeValue_;
        try {
            rightNodeValue_ = super.rightNode.executeBoolean(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(leftNodeValue_, ex.getResult());
        }
        assert (state & 0b10000) != 0 /* is-active doBooleanTarget(Object, boolean) */;
        return doBooleanTarget(leftNodeValue_, rightNodeValue_);
    }

    @TruffleBoundary
    private boolean foreignTargetOther1Boundary1(int state, Object leftNodeValue_, Object rightNodeValue_) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary foreignTargetOther1_interop__ = (INTEROP_LIBRARY_.getUncached(rightNodeValue_));
                return doForeignTargetOther(leftNodeValue_, rightNodeValue_, foreignTargetOther1_interop__);
            }
        } finally {
            encapsulating_.set(prev_);
        }
    }

    @ExplodeLoop
    private boolean executeBoolean_generic5(VirtualFrame frameValue, int state) {
        Object leftNodeValue_ = super.leftNode.execute(frameValue);
        Object rightNodeValue_ = super.rightNode.execute(frameValue);
        if ((state & 0b1111111) != 0 /* is-active doJSObject(Object, DynamicObject, IsJSObjectNode, GetMethodNode, JSToBooleanNode, JSFunctionCallNode, ConditionProfile, BranchProfile, BranchProfile) || doNullOrUndefinedTarget(Object, DynamicObject) || doStringTarget(Object, String) || doDoubleTarget(Object, double) || doBooleanTarget(Object, boolean) || doBigIntTarget(Object, BigInt) || doSymbolTarget(Object, Symbol) */) {
            if ((state & 0b11) != 0 /* is-active doJSObject(Object, DynamicObject, IsJSObjectNode, GetMethodNode, JSToBooleanNode, JSFunctionCallNode, ConditionProfile, BranchProfile, BranchProfile) || doNullOrUndefinedTarget(Object, DynamicObject) */ && JSTypes.isDynamicObject(rightNodeValue_)) {
                DynamicObject rightNodeValue__ = (DynamicObject) rightNodeValue_;
                if ((state & 0b1) != 0 /* is-active doJSObject(Object, DynamicObject, IsJSObjectNode, GetMethodNode, JSToBooleanNode, JSFunctionCallNode, ConditionProfile, BranchProfile, BranchProfile) */) {
                    JSObjectData s1_ = this.jSObject_cache;
                    if (s1_ != null) {
                        if ((s1_.isObjectNode_.executeBoolean(rightNodeValue__))) {
                            return doJSObject(leftNodeValue_, rightNodeValue__, s1_.isObjectNode_, s1_.getMethodHasInstanceNode_, s1_.toBooleanNode_, s1_.callHasInstanceNode_, s1_.hasInstanceProfile_, s1_.errorBranch_, s1_.proxyBranch_);
                        }
                    }
                }
                if ((state & 0b10) != 0 /* is-active doNullOrUndefinedTarget(Object, DynamicObject) */) {
                    if ((JSGuards.isNullOrUndefined(rightNodeValue__))) {
                        return doNullOrUndefinedTarget(leftNodeValue_, rightNodeValue__);
                    }
                }
            }
            if ((state & 0b100) != 0 /* is-active doStringTarget(Object, String) */ && JSTypesGen.isImplicitString((state & 0b11110000000000) >>> 10 /* extract-implicit-active 1:String */, rightNodeValue_)) {
                String rightNodeValue__ = JSTypesGen.asImplicitString((state & 0b11110000000000) >>> 10 /* extract-implicit-active 1:String */, rightNodeValue_);
                return doStringTarget(leftNodeValue_, rightNodeValue__);
            }
            if ((state & 0b1000) != 0 /* is-active doDoubleTarget(Object, double) */ && JSTypesGen.isImplicitDouble((state & 0x3c000) >>> 14 /* extract-implicit-active 1:double */, rightNodeValue_)) {
                double rightNodeValue__ = JSTypesGen.asImplicitDouble((state & 0x3c000) >>> 14 /* extract-implicit-active 1:double */, rightNodeValue_);
                return doDoubleTarget(leftNodeValue_, rightNodeValue__);
            }
            if ((state & 0b10000) != 0 /* is-active doBooleanTarget(Object, boolean) */ && rightNodeValue_ instanceof Boolean) {
                boolean rightNodeValue__ = (boolean) rightNodeValue_;
                return doBooleanTarget(leftNodeValue_, rightNodeValue__);
            }
            if ((state & 0b100000) != 0 /* is-active doBigIntTarget(Object, BigInt) */ && rightNodeValue_ instanceof BigInt) {
                BigInt rightNodeValue__ = (BigInt) rightNodeValue_;
                return doBigIntTarget(leftNodeValue_, rightNodeValue__);
            }
            if ((state & 0b1000000) != 0 /* is-active doSymbolTarget(Object, Symbol) */ && rightNodeValue_ instanceof Symbol) {
                Symbol rightNodeValue__ = (Symbol) rightNodeValue_;
                return doSymbolTarget(leftNodeValue_, rightNodeValue__);
            }
        }
        if ((state & 0b1110000000) != 0 /* is-active doForeignTargetJSType(DynamicObject, Object) || doForeignTargetOther(Object, Object, InteropLibrary) || doForeignTargetOther(Object, Object, InteropLibrary) */) {
            if ((state & 0b10000000) != 0 /* is-active doForeignTargetJSType(DynamicObject, Object) */ && JSTypes.isDynamicObject(leftNodeValue_)) {
                DynamicObject leftNodeValue__ = (DynamicObject) leftNodeValue_;
                if ((JSGuards.isForeignObject(rightNodeValue_)) && (JSGuards.isJSDynamicObject(leftNodeValue__))) {
                    return doForeignTargetJSType(leftNodeValue__, rightNodeValue_);
                }
            }
            if ((state & 0b1100000000) != 0 /* is-active doForeignTargetOther(Object, Object, InteropLibrary) || doForeignTargetOther(Object, Object, InteropLibrary) */) {
                if ((state & 0b100000000) != 0 /* is-active doForeignTargetOther(Object, Object, InteropLibrary) */) {
                    ForeignTargetOther0Data s9_ = this.foreignTargetOther0_cache;
                    while (s9_ != null) {
                        if ((s9_.interop_.accepts(rightNodeValue_)) && (JSGuards.isForeignObject(rightNodeValue_)) && (!(JSGuards.isJSDynamicObject(leftNodeValue_)))) {
                            return doForeignTargetOther(leftNodeValue_, rightNodeValue_, s9_.interop_);
                        }
                        s9_ = s9_.next_;
                    }
                }
                if ((state & 0b1000000000) != 0 /* is-active doForeignTargetOther(Object, Object, InteropLibrary) */) {
                    if ((JSGuards.isForeignObject(rightNodeValue_)) && (!(JSGuards.isJSDynamicObject(leftNodeValue_)))) {
                        return this.foreignTargetOther1Boundary1(state, leftNodeValue_, rightNodeValue_);
                    }
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        executeBoolean(frameValue);
        return;
    }

    private boolean executeAndSpecialize(Object leftNodeValue, Object rightNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        int exclude = exclude_;
        try {
            if (JSTypes.isDynamicObject(rightNodeValue)) {
                DynamicObject rightNodeValue_ = (DynamicObject) rightNodeValue;
                JSObjectData s1_ = this.jSObject_cache;
                boolean JSObject_duplicateFound_ = false;
                if ((state & 0b1) != 0 /* is-active doJSObject(Object, DynamicObject, IsJSObjectNode, GetMethodNode, JSToBooleanNode, JSFunctionCallNode, ConditionProfile, BranchProfile, BranchProfile) */) {
                    if ((s1_.isObjectNode_.executeBoolean(rightNodeValue_))) {
                        JSObject_duplicateFound_ = true;
                    }
                }
                if (!JSObject_duplicateFound_) {
                    {
                        IsJSObjectNode isObjectNode__ = super.insert((IsJSObjectNode.create()));
                        if ((isObjectNode__.executeBoolean(rightNodeValue_)) && ((state & 0b1)) == 0 /* is-not-active doJSObject(Object, DynamicObject, IsJSObjectNode, GetMethodNode, JSToBooleanNode, JSFunctionCallNode, ConditionProfile, BranchProfile, BranchProfile) */) {
                            s1_ = super.insert(new JSObjectData());
                            s1_.isObjectNode_ = s1_.insertAccessor(isObjectNode__);
                            s1_.getMethodHasInstanceNode_ = s1_.insertAccessor((createGetMethodHasInstance()));
                            s1_.toBooleanNode_ = s1_.insertAccessor((JSToBooleanNode.create()));
                            s1_.callHasInstanceNode_ = s1_.insertAccessor((JSFunctionCallNode.createCall()));
                            s1_.hasInstanceProfile_ = (ConditionProfile.createBinaryProfile());
                            s1_.errorBranch_ = (BranchProfile.create());
                            s1_.proxyBranch_ = (BranchProfile.create());
                            this.jSObject_cache = s1_;
                            this.state_ = state = state | 0b1 /* add-active doJSObject(Object, DynamicObject, IsJSObjectNode, GetMethodNode, JSToBooleanNode, JSFunctionCallNode, ConditionProfile, BranchProfile, BranchProfile) */;
                            JSObject_duplicateFound_ = true;
                        }
                    }
                }
                if (JSObject_duplicateFound_) {
                    lock.unlock();
                    hasLock = false;
                    return doJSObject(leftNodeValue, rightNodeValue_, s1_.isObjectNode_, s1_.getMethodHasInstanceNode_, s1_.toBooleanNode_, s1_.callHasInstanceNode_, s1_.hasInstanceProfile_, s1_.errorBranch_, s1_.proxyBranch_);
                }
                if ((JSGuards.isNullOrUndefined(rightNodeValue_))) {
                    this.state_ = state = state | 0b10 /* add-active doNullOrUndefinedTarget(Object, DynamicObject) */;
                    lock.unlock();
                    hasLock = false;
                    return doNullOrUndefinedTarget(leftNodeValue, rightNodeValue_);
                }
            }
            {
                int stringCast1;
                if ((stringCast1 = JSTypesGen.specializeImplicitString(rightNodeValue)) != 0) {
                    String rightNodeValue_ = JSTypesGen.asImplicitString(stringCast1, rightNodeValue);
                    state = (state | (stringCast1 << 10) /* set-implicit-active 1:String */);
                    this.state_ = state = state | 0b100 /* add-active doStringTarget(Object, String) */;
                    lock.unlock();
                    hasLock = false;
                    return doStringTarget(leftNodeValue, rightNodeValue_);
                }
            }
            {
                int doubleCast1;
                if ((doubleCast1 = JSTypesGen.specializeImplicitDouble(rightNodeValue)) != 0) {
                    double rightNodeValue_ = JSTypesGen.asImplicitDouble(doubleCast1, rightNodeValue);
                    state = (state | (doubleCast1 << 14) /* set-implicit-active 1:double */);
                    this.state_ = state = state | 0b1000 /* add-active doDoubleTarget(Object, double) */;
                    lock.unlock();
                    hasLock = false;
                    return doDoubleTarget(leftNodeValue, rightNodeValue_);
                }
            }
            if (rightNodeValue instanceof Boolean) {
                boolean rightNodeValue_ = (boolean) rightNodeValue;
                this.state_ = state = state | 0b10000 /* add-active doBooleanTarget(Object, boolean) */;
                lock.unlock();
                hasLock = false;
                return doBooleanTarget(leftNodeValue, rightNodeValue_);
            }
            if (rightNodeValue instanceof BigInt) {
                BigInt rightNodeValue_ = (BigInt) rightNodeValue;
                this.state_ = state = state | 0b100000 /* add-active doBigIntTarget(Object, BigInt) */;
                lock.unlock();
                hasLock = false;
                return doBigIntTarget(leftNodeValue, rightNodeValue_);
            }
            if (rightNodeValue instanceof Symbol) {
                Symbol rightNodeValue_ = (Symbol) rightNodeValue;
                this.state_ = state = state | 0b1000000 /* add-active doSymbolTarget(Object, Symbol) */;
                lock.unlock();
                hasLock = false;
                return doSymbolTarget(leftNodeValue, rightNodeValue_);
            }
            if (JSTypes.isDynamicObject(leftNodeValue)) {
                DynamicObject leftNodeValue_ = (DynamicObject) leftNodeValue;
                if ((JSGuards.isForeignObject(rightNodeValue)) && (JSGuards.isJSDynamicObject(leftNodeValue_))) {
                    this.state_ = state = state | 0b10000000 /* add-active doForeignTargetJSType(DynamicObject, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return doForeignTargetJSType(leftNodeValue_, rightNodeValue);
                }
            }
            if ((exclude) == 0 /* is-not-excluded doForeignTargetOther(Object, Object, InteropLibrary) */) {
                int count9_ = 0;
                ForeignTargetOther0Data s9_ = this.foreignTargetOther0_cache;
                if ((state & 0b100000000) != 0 /* is-active doForeignTargetOther(Object, Object, InteropLibrary) */) {
                    while (s9_ != null) {
                        if ((s9_.interop_.accepts(rightNodeValue)) && (JSGuards.isForeignObject(rightNodeValue)) && (!(JSGuards.isJSDynamicObject(leftNodeValue)))) {
                            break;
                        }
                        s9_ = s9_.next_;
                        count9_++;
                    }
                }
                if (s9_ == null) {
                    if ((JSGuards.isForeignObject(rightNodeValue)) && (!(JSGuards.isJSDynamicObject(leftNodeValue))) && count9_ < (3)) {
                        // assert (s9_.interop_.accepts(rightNodeValue));
                        s9_ = super.insert(new ForeignTargetOther0Data(foreignTargetOther0_cache));
                        s9_.interop_ = s9_.insertAccessor((INTEROP_LIBRARY_.create(rightNodeValue)));
                        this.foreignTargetOther0_cache = s9_;
                        this.state_ = state = state | 0b100000000 /* add-active doForeignTargetOther(Object, Object, InteropLibrary) */;
                    }
                }
                if (s9_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return doForeignTargetOther(leftNodeValue, rightNodeValue, s9_.interop_);
                }
            }
            {
                InteropLibrary foreignTargetOther1_interop__ = null;
                {
                    EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                    Node prev_ = encapsulating_.set(this);
                    try {
                        if ((JSGuards.isForeignObject(rightNodeValue)) && (!(JSGuards.isJSDynamicObject(leftNodeValue)))) {
                            foreignTargetOther1_interop__ = (INTEROP_LIBRARY_.getUncached(rightNodeValue));
                            this.exclude_ = exclude = exclude | 0b1 /* add-excluded doForeignTargetOther(Object, Object, InteropLibrary) */;
                            this.foreignTargetOther0_cache = null;
                            state = state & 0xfffffeff /* remove-active doForeignTargetOther(Object, Object, InteropLibrary) */;
                            this.state_ = state = state | 0b1000000000 /* add-active doForeignTargetOther(Object, Object, InteropLibrary) */;
                            lock.unlock();
                            hasLock = false;
                            return doForeignTargetOther(leftNodeValue, rightNodeValue, foreignTargetOther1_interop__);
                        }
                    } finally {
                        encapsulating_.set(prev_);
                    }
                }
            }
            throw new UnsupportedSpecializationException(this, new Node[] {super.leftNode, super.rightNode}, leftNodeValue, rightNodeValue);
        } finally {
            if (hasLock) {
                lock.unlock();
            }
        }
    }

    @Override
    public NodeCost getCost() {
        int state = state_;
        if ((state & 0b1111111111) == 0b0) {
            return NodeCost.UNINITIALIZED;
        } else if (((state & 0b1111111111) & ((state & 0b1111111111) - 1)) == 0 /* is-single-active  */) {
            ForeignTargetOther0Data s9_ = this.foreignTargetOther0_cache;
            if ((s9_ == null || s9_.next_ == null)) {
                return NodeCost.MONOMORPHIC;
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[11];
        Object[] s;
        data[0] = 0;
        int state = state_;
        int exclude = exclude_;
        s = new Object[3];
        s[0] = "doJSObject";
        if ((state & 0b1) != 0 /* is-active doJSObject(Object, DynamicObject, IsJSObjectNode, GetMethodNode, JSToBooleanNode, JSFunctionCallNode, ConditionProfile, BranchProfile, BranchProfile) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            JSObjectData s1_ = this.jSObject_cache;
            if (s1_ != null) {
                cached.add(Arrays.asList(s1_.isObjectNode_, s1_.getMethodHasInstanceNode_, s1_.toBooleanNode_, s1_.callHasInstanceNode_, s1_.hasInstanceProfile_, s1_.errorBranch_, s1_.proxyBranch_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doNullOrUndefinedTarget";
        if ((state & 0b10) != 0 /* is-active doNullOrUndefinedTarget(Object, DynamicObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doStringTarget";
        if ((state & 0b100) != 0 /* is-active doStringTarget(Object, String) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doDoubleTarget";
        if ((state & 0b1000) != 0 /* is-active doDoubleTarget(Object, double) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doBooleanTarget";
        if ((state & 0b10000) != 0 /* is-active doBooleanTarget(Object, boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "doBigIntTarget";
        if ((state & 0b100000) != 0 /* is-active doBigIntTarget(Object, BigInt) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "doSymbolTarget";
        if ((state & 0b1000000) != 0 /* is-active doSymbolTarget(Object, Symbol) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        s = new Object[3];
        s[0] = "doForeignTargetJSType";
        if ((state & 0b10000000) != 0 /* is-active doForeignTargetJSType(DynamicObject, Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[8] = s;
        s = new Object[3];
        s[0] = "doForeignTargetOther";
        if ((state & 0b100000000) != 0 /* is-active doForeignTargetOther(Object, Object, InteropLibrary) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            ForeignTargetOther0Data s9_ = this.foreignTargetOther0_cache;
            while (s9_ != null) {
                cached.add(Arrays.asList(s9_.interop_));
                s9_ = s9_.next_;
            }
            s[2] = cached;
        } else if (exclude != 0 /* is-excluded doForeignTargetOther(Object, Object, InteropLibrary) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[9] = s;
        s = new Object[3];
        s[0] = "doForeignTargetOther";
        if ((state & 0b1000000000) != 0 /* is-active doForeignTargetOther(Object, Object, InteropLibrary) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList());
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[10] = s;
        return Provider.create(data);
    }

    public static InstanceofNode create(JSContext context, JavaScriptNode left, JavaScriptNode right) {
        return new InstanceofNodeGen(context, left, right);
    }

    @GeneratedBy(InstanceofNode.class)
    private static final class JSObjectData extends Node {

        @Child IsJSObjectNode isObjectNode_;
        @Child GetMethodNode getMethodHasInstanceNode_;
        @Child JSToBooleanNode toBooleanNode_;
        @Child JSFunctionCallNode callHasInstanceNode_;
        @CompilationFinal ConditionProfile hasInstanceProfile_;
        @CompilationFinal BranchProfile errorBranch_;
        @CompilationFinal BranchProfile proxyBranch_;

        JSObjectData() {
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.NONE;
        }

        <T extends Node> T insertAccessor(T node) {
            return super.insert(node);
        }

    }
    @GeneratedBy(InstanceofNode.class)
    private static final class ForeignTargetOther0Data extends Node {

        @Child ForeignTargetOther0Data next_;
        @Child InteropLibrary interop_;

        ForeignTargetOther0Data(ForeignTargetOther0Data next_) {
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
    @GeneratedBy(OrdinaryHasInstanceNode.class)
    public static final class OrdinaryHasInstanceNodeGen extends OrdinaryHasInstanceNode implements Provider {

        @CompilationFinal private volatile int state_;
        @Child private IsJSObjectNode isObjectNode;
        @Child private GetPrototypeNode getPrototype1Node;
        @Child private GetPrototypeNode getPrototype2Node;
        @Child private GetPrototypeNode getPrototype3Node;
        @CompilationFinal private BranchProfile firstTrue;
        @CompilationFinal private BranchProfile firstFalse;
        @CompilationFinal private BranchProfile need2Hops;
        @CompilationFinal private BranchProfile need3Hops;
        @CompilationFinal private BranchProfile errorBranch;
        @CompilationFinal private BranchProfile invalidPrototypeBranch;
        @Child private InstanceofNode isBound_instanceofNode_;

        private OrdinaryHasInstanceNodeGen(JSContext context) {
            super(context);
        }

        @Override
        public boolean executeBoolean(Object arg0Value, Object arg1Value) {
            int state = state_;
            if ((state & 0b1111) != 0 /* is-active doNotCallable(Object, Object) || doIsBound(Object, DynamicObject, InstanceofNode) || doNotAnObject(Object, DynamicObject) || doNotAnObjectProxy(Object, DynamicObject) */) {
                if ((state & 0b1) != 0 /* is-active doNotCallable(Object, Object) */) {
                    if ((!(JSGuards.isCallable(arg1Value)))) {
                        return doNotCallable(arg0Value, arg1Value);
                    }
                }
                if ((state & 0b1110) != 0 /* is-active doIsBound(Object, DynamicObject, InstanceofNode) || doNotAnObject(Object, DynamicObject) || doNotAnObjectProxy(Object, DynamicObject) */ && JSTypes.isDynamicObject(arg1Value)) {
                    DynamicObject arg1Value_ = (DynamicObject) arg1Value;
                    if ((state & 0b10) != 0 /* is-active doIsBound(Object, DynamicObject, InstanceofNode) */) {
                        if ((JSGuards.isJSFunction(arg1Value_)) && (isBoundFunction(arg1Value_))) {
                            return doIsBound(arg0Value, arg1Value_, this.isBound_instanceofNode_);
                        }
                    }
                    if ((state & 0b100) != 0 /* is-active doNotAnObject(Object, DynamicObject) */) {
                        if ((!(JSGuards.isJSObject(arg0Value))) && (JSGuards.isJSFunction(arg1Value_)) && (!(isBoundFunction(arg1Value_)))) {
                            return doNotAnObject(arg0Value, arg1Value_);
                        }
                    }
                    if ((state & 0b1000) != 0 /* is-active doNotAnObjectProxy(Object, DynamicObject) */) {
                        if ((!(JSGuards.isJSObject(arg0Value))) && (JSGuards.isJSProxy(arg1Value_)) && (JSGuards.isCallableProxy(arg1Value_))) {
                            return doNotAnObjectProxy(arg0Value, arg1Value_);
                        }
                    }
                }
            }
            if ((state & 0b110000) != 0 /* is-active doJSObject(DynamicObject, DynamicObject, IsJSObjectNode, GetPrototypeNode, GetPrototypeNode, GetPrototypeNode, BranchProfile, BranchProfile, BranchProfile, BranchProfile, BranchProfile, BranchProfile) || doJSObjectProxy(DynamicObject, DynamicObject, IsJSObjectNode, GetPrototypeNode, GetPrototypeNode, GetPrototypeNode, BranchProfile, BranchProfile, BranchProfile, BranchProfile, BranchProfile, BranchProfile) */ && JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if (JSTypes.isDynamicObject(arg1Value)) {
                    DynamicObject arg1Value_ = (DynamicObject) arg1Value;
                    if ((state & 0b10000) != 0 /* is-active doJSObject(DynamicObject, DynamicObject, IsJSObjectNode, GetPrototypeNode, GetPrototypeNode, GetPrototypeNode, BranchProfile, BranchProfile, BranchProfile, BranchProfile, BranchProfile, BranchProfile) */) {
                        if ((this.isObjectNode.executeBoolean(arg0Value_)) && (JSGuards.isJSFunction(arg1Value_)) && (!(isBoundFunction(arg1Value_)))) {
                            return doJSObject(arg0Value_, arg1Value_, this.isObjectNode, this.getPrototype1Node, this.getPrototype2Node, this.getPrototype3Node, this.firstTrue, this.firstFalse, this.need2Hops, this.need3Hops, this.errorBranch, this.invalidPrototypeBranch);
                        }
                    }
                    if ((state & 0b100000) != 0 /* is-active doJSObjectProxy(DynamicObject, DynamicObject, IsJSObjectNode, GetPrototypeNode, GetPrototypeNode, GetPrototypeNode, BranchProfile, BranchProfile, BranchProfile, BranchProfile, BranchProfile, BranchProfile) */) {
                        if ((this.isObjectNode.executeBoolean(arg0Value_)) && (JSGuards.isJSProxy(arg1Value_)) && (JSGuards.isCallableProxy(arg1Value_))) {
                            return doJSObjectProxy(arg0Value_, arg1Value_, this.isObjectNode, this.getPrototype1Node, this.getPrototype2Node, this.getPrototype3Node, this.firstTrue, this.firstFalse, this.need2Hops, this.need3Hops, this.errorBranch, this.invalidPrototypeBranch);
                        }
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value, arg1Value);
        }

        private boolean executeAndSpecialize(Object arg0Value, Object arg1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            try {
                if ((!(JSGuards.isCallable(arg1Value)))) {
                    this.state_ = state = state | 0b1 /* add-active doNotCallable(Object, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return doNotCallable(arg0Value, arg1Value);
                }
                if (JSTypes.isDynamicObject(arg1Value)) {
                    DynamicObject arg1Value_ = (DynamicObject) arg1Value;
                    if ((JSGuards.isJSFunction(arg1Value_)) && (isBoundFunction(arg1Value_))) {
                        this.isBound_instanceofNode_ = super.insert((InstanceofNode.create(context)));
                        this.state_ = state = state | 0b10 /* add-active doIsBound(Object, DynamicObject, InstanceofNode) */;
                        lock.unlock();
                        hasLock = false;
                        return doIsBound(arg0Value, arg1Value_, this.isBound_instanceofNode_);
                    }
                    if ((!(JSGuards.isJSObject(arg0Value))) && (JSGuards.isJSFunction(arg1Value_)) && (!(isBoundFunction(arg1Value_)))) {
                        this.state_ = state = state | 0b100 /* add-active doNotAnObject(Object, DynamicObject) */;
                        lock.unlock();
                        hasLock = false;
                        return doNotAnObject(arg0Value, arg1Value_);
                    }
                    if ((!(JSGuards.isJSObject(arg0Value))) && (JSGuards.isJSProxy(arg1Value_)) && (JSGuards.isCallableProxy(arg1Value_))) {
                        this.state_ = state = state | 0b1000 /* add-active doNotAnObjectProxy(Object, DynamicObject) */;
                        lock.unlock();
                        hasLock = false;
                        return doNotAnObjectProxy(arg0Value, arg1Value_);
                    }
                }
                if (JSTypes.isDynamicObject(arg0Value)) {
                    DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                    if (JSTypes.isDynamicObject(arg1Value)) {
                        DynamicObject arg1Value_ = (DynamicObject) arg1Value;
                        boolean JSObject_duplicateFound_ = false;
                        if ((state & 0b10000) != 0 /* is-active doJSObject(DynamicObject, DynamicObject, IsJSObjectNode, GetPrototypeNode, GetPrototypeNode, GetPrototypeNode, BranchProfile, BranchProfile, BranchProfile, BranchProfile, BranchProfile, BranchProfile) */) {
                            if ((this.isObjectNode.executeBoolean(arg0Value_)) && (JSGuards.isJSFunction(arg1Value_)) && (!(isBoundFunction(arg1Value_)))) {
                                JSObject_duplicateFound_ = true;
                            }
                        }
                        if (!JSObject_duplicateFound_) {
                            {
                                IsJSObjectNode jSObject_isObjectNode__ = super.insert((IsJSObjectNode.create()));
                                if ((jSObject_isObjectNode__.executeBoolean(arg0Value_)) && (JSGuards.isJSFunction(arg1Value_)) && (!(isBoundFunction(arg1Value_))) && ((state & 0b10000)) == 0 /* is-not-active doJSObject(DynamicObject, DynamicObject, IsJSObjectNode, GetPrototypeNode, GetPrototypeNode, GetPrototypeNode, BranchProfile, BranchProfile, BranchProfile, BranchProfile, BranchProfile, BranchProfile) */) {
                                    if (this.isObjectNode == null) {
                                        this.isObjectNode = super.insert(jSObject_isObjectNode__);
                                    }
                                    if (this.getPrototype1Node == null) {
                                        this.getPrototype1Node = super.insert((GetPrototypeNode.create()));
                                    }
                                    if (this.getPrototype2Node == null) {
                                        this.getPrototype2Node = super.insert((GetPrototypeNode.create()));
                                    }
                                    if (this.getPrototype3Node == null) {
                                        this.getPrototype3Node = super.insert((GetPrototypeNode.create()));
                                    }
                                    if (this.firstTrue == null) {
                                        this.firstTrue = (BranchProfile.create());
                                    }
                                    if (this.firstFalse == null) {
                                        this.firstFalse = (BranchProfile.create());
                                    }
                                    if (this.need2Hops == null) {
                                        this.need2Hops = (BranchProfile.create());
                                    }
                                    if (this.need3Hops == null) {
                                        this.need3Hops = (BranchProfile.create());
                                    }
                                    if (this.errorBranch == null) {
                                        this.errorBranch = (BranchProfile.create());
                                    }
                                    if (this.invalidPrototypeBranch == null) {
                                        this.invalidPrototypeBranch = (BranchProfile.create());
                                    }
                                    this.state_ = state = state | 0b10000 /* add-active doJSObject(DynamicObject, DynamicObject, IsJSObjectNode, GetPrototypeNode, GetPrototypeNode, GetPrototypeNode, BranchProfile, BranchProfile, BranchProfile, BranchProfile, BranchProfile, BranchProfile) */;
                                    JSObject_duplicateFound_ = true;
                                }
                            }
                        }
                        if (JSObject_duplicateFound_) {
                            lock.unlock();
                            hasLock = false;
                            return doJSObject(arg0Value_, arg1Value_, this.isObjectNode, this.getPrototype1Node, this.getPrototype2Node, this.getPrototype3Node, this.firstTrue, this.firstFalse, this.need2Hops, this.need3Hops, this.errorBranch, this.invalidPrototypeBranch);
                        }
                        boolean JSObjectProxy_duplicateFound_ = false;
                        if ((state & 0b100000) != 0 /* is-active doJSObjectProxy(DynamicObject, DynamicObject, IsJSObjectNode, GetPrototypeNode, GetPrototypeNode, GetPrototypeNode, BranchProfile, BranchProfile, BranchProfile, BranchProfile, BranchProfile, BranchProfile) */) {
                            if ((this.isObjectNode.executeBoolean(arg0Value_)) && (JSGuards.isJSProxy(arg1Value_)) && (JSGuards.isCallableProxy(arg1Value_))) {
                                JSObjectProxy_duplicateFound_ = true;
                            }
                        }
                        if (!JSObjectProxy_duplicateFound_) {
                            {
                                IsJSObjectNode jSObjectProxy_isObjectNode__ = super.insert((IsJSObjectNode.create()));
                                if ((jSObjectProxy_isObjectNode__.executeBoolean(arg0Value_)) && (JSGuards.isJSProxy(arg1Value_)) && (JSGuards.isCallableProxy(arg1Value_)) && ((state & 0b100000)) == 0 /* is-not-active doJSObjectProxy(DynamicObject, DynamicObject, IsJSObjectNode, GetPrototypeNode, GetPrototypeNode, GetPrototypeNode, BranchProfile, BranchProfile, BranchProfile, BranchProfile, BranchProfile, BranchProfile) */) {
                                    if (this.isObjectNode == null) {
                                        this.isObjectNode = super.insert(jSObjectProxy_isObjectNode__);
                                    }
                                    if (this.getPrototype1Node == null) {
                                        this.getPrototype1Node = super.insert((GetPrototypeNode.create()));
                                    }
                                    if (this.getPrototype2Node == null) {
                                        this.getPrototype2Node = super.insert((GetPrototypeNode.create()));
                                    }
                                    if (this.getPrototype3Node == null) {
                                        this.getPrototype3Node = super.insert((GetPrototypeNode.create()));
                                    }
                                    if (this.firstTrue == null) {
                                        this.firstTrue = (BranchProfile.create());
                                    }
                                    if (this.firstFalse == null) {
                                        this.firstFalse = (BranchProfile.create());
                                    }
                                    if (this.need2Hops == null) {
                                        this.need2Hops = (BranchProfile.create());
                                    }
                                    if (this.need3Hops == null) {
                                        this.need3Hops = (BranchProfile.create());
                                    }
                                    if (this.errorBranch == null) {
                                        this.errorBranch = (BranchProfile.create());
                                    }
                                    if (this.invalidPrototypeBranch == null) {
                                        this.invalidPrototypeBranch = (BranchProfile.create());
                                    }
                                    this.state_ = state = state | 0b100000 /* add-active doJSObjectProxy(DynamicObject, DynamicObject, IsJSObjectNode, GetPrototypeNode, GetPrototypeNode, GetPrototypeNode, BranchProfile, BranchProfile, BranchProfile, BranchProfile, BranchProfile, BranchProfile) */;
                                    JSObjectProxy_duplicateFound_ = true;
                                }
                            }
                        }
                        if (JSObjectProxy_duplicateFound_) {
                            lock.unlock();
                            hasLock = false;
                            return doJSObjectProxy(arg0Value_, arg1Value_, this.isObjectNode, this.getPrototype1Node, this.getPrototype2Node, this.getPrototype3Node, this.firstTrue, this.firstFalse, this.need2Hops, this.need3Hops, this.errorBranch, this.invalidPrototypeBranch);
                        }
                    }
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
            Object[] data = new Object[7];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "doNotCallable";
            if ((state & 0b1) != 0 /* is-active doNotCallable(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doIsBound";
            if ((state & 0b10) != 0 /* is-active doIsBound(Object, DynamicObject, InstanceofNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.isBound_instanceofNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "doNotAnObject";
            if ((state & 0b100) != 0 /* is-active doNotAnObject(Object, DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "doNotAnObjectProxy";
            if ((state & 0b1000) != 0 /* is-active doNotAnObjectProxy(Object, DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            s = new Object[3];
            s[0] = "doJSObject";
            if ((state & 0b10000) != 0 /* is-active doJSObject(DynamicObject, DynamicObject, IsJSObjectNode, GetPrototypeNode, GetPrototypeNode, GetPrototypeNode, BranchProfile, BranchProfile, BranchProfile, BranchProfile, BranchProfile, BranchProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.isObjectNode, this.getPrototype1Node, this.getPrototype2Node, this.getPrototype3Node, this.firstTrue, this.firstFalse, this.need2Hops, this.need3Hops, this.errorBranch, this.invalidPrototypeBranch));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[5] = s;
            s = new Object[3];
            s[0] = "doJSObjectProxy";
            if ((state & 0b100000) != 0 /* is-active doJSObjectProxy(DynamicObject, DynamicObject, IsJSObjectNode, GetPrototypeNode, GetPrototypeNode, GetPrototypeNode, BranchProfile, BranchProfile, BranchProfile, BranchProfile, BranchProfile, BranchProfile) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.isObjectNode, this.getPrototype1Node, this.getPrototype2Node, this.getPrototype3Node, this.firstTrue, this.firstFalse, this.need2Hops, this.need3Hops, this.errorBranch, this.invalidPrototypeBranch));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[6] = s;
            return Provider.create(data);
        }

        public static OrdinaryHasInstanceNode create(JSContext context) {
            return new OrdinaryHasInstanceNodeGen(context);
        }

    }
    @GeneratedBy(IsBoundFunctionCacheNode.class)
    public static final class IsBoundFunctionCacheNodeGen extends IsBoundFunctionCacheNode implements Provider {

        @CompilationFinal private volatile int state_;
        @CompilationFinal private volatile int exclude_;
        @CompilationFinal private DynamicObject cachedInstance_cachedFunction_;
        @CompilationFinal private boolean cachedInstance_cachedIsBound_;
        @CompilationFinal private CachedShapeData cachedShape_cache;

        private IsBoundFunctionCacheNodeGen(boolean multiContext) {
            super(multiContext);
        }

        @ExplodeLoop
        @Override
        public boolean executeBoolean(DynamicObject arg0Value) {
            int state = state_;
            if (state != 0 /* is-active doCachedInstance(DynamicObject, DynamicObject, boolean) || doCachedShape(DynamicObject, Shape, boolean) || isBoundFunction(DynamicObject) */) {
                if ((state & 0b1) != 0 /* is-active doCachedInstance(DynamicObject, DynamicObject, boolean) */) {
                    assert (!(multiContext));
                    if ((arg0Value == this.cachedInstance_cachedFunction_)) {
                        return IsBoundFunctionCacheNode.doCachedInstance(arg0Value, this.cachedInstance_cachedFunction_, this.cachedInstance_cachedIsBound_);
                    }
                }
                if ((state & 0b10) != 0 /* is-active doCachedShape(DynamicObject, Shape, boolean) */) {
                    CachedShapeData s2_ = this.cachedShape_cache;
                    while (s2_ != null) {
                        if ((s2_.cachedShape_.check(arg0Value))) {
                            return IsBoundFunctionCacheNode.doCachedShape(arg0Value, s2_.cachedShape_, s2_.cachedIsBound_);
                        }
                        s2_ = s2_.next_;
                    }
                }
                if ((state & 0b100) != 0 /* is-active isBoundFunction(DynamicObject) */) {
                    return IsBoundFunctionCacheNode.isBoundFunction(arg0Value);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value);
        }

        private boolean executeAndSpecialize(DynamicObject arg0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int exclude = exclude_;
            try {
                if (((exclude & 0b1)) == 0 /* is-not-excluded doCachedInstance(DynamicObject, DynamicObject, boolean) */) {
                    boolean CachedInstance_duplicateFound_ = false;
                    if ((state & 0b1) != 0 /* is-active doCachedInstance(DynamicObject, DynamicObject, boolean) */) {
                        assert (!(multiContext));
                        if ((arg0Value == this.cachedInstance_cachedFunction_)) {
                            CachedInstance_duplicateFound_ = true;
                        }
                    }
                    if (!CachedInstance_duplicateFound_) {
                        if ((!(multiContext))) {
                            // assert (arg0Value == this.cachedInstance_cachedFunction_);
                            if (((state & 0b1)) == 0 /* is-not-active doCachedInstance(DynamicObject, DynamicObject, boolean) */) {
                                this.cachedInstance_cachedFunction_ = (arg0Value);
                                this.cachedInstance_cachedIsBound_ = (IsBoundFunctionCacheNode.isBoundFunction(arg0Value));
                                this.state_ = state = state | 0b1 /* add-active doCachedInstance(DynamicObject, DynamicObject, boolean) */;
                                CachedInstance_duplicateFound_ = true;
                            }
                        }
                    }
                    if (CachedInstance_duplicateFound_) {
                        lock.unlock();
                        hasLock = false;
                        return IsBoundFunctionCacheNode.doCachedInstance(arg0Value, this.cachedInstance_cachedFunction_, this.cachedInstance_cachedIsBound_);
                    }
                }
                if (((exclude & 0b10)) == 0 /* is-not-excluded doCachedShape(DynamicObject, Shape, boolean) */) {
                    int count2_ = 0;
                    CachedShapeData s2_ = this.cachedShape_cache;
                    if ((state & 0b10) != 0 /* is-active doCachedShape(DynamicObject, Shape, boolean) */) {
                        while (s2_ != null) {
                            if ((s2_.cachedShape_.check(arg0Value))) {
                                break;
                            }
                            s2_ = s2_.next_;
                            count2_++;
                        }
                    }
                    if (s2_ == null) {
                        {
                            Shape cachedShape__ = (arg0Value.getShape());
                            if ((cachedShape__.check(arg0Value)) && count2_ < (3)) {
                                s2_ = new CachedShapeData(cachedShape_cache);
                                s2_.cachedShape_ = cachedShape__;
                                s2_.cachedIsBound_ = (IsBoundFunctionCacheNode.isBoundFunction(arg0Value));
                                this.cachedShape_cache = s2_;
                                this.exclude_ = exclude = exclude | 0b1 /* add-excluded doCachedInstance(DynamicObject, DynamicObject, boolean) */;
                                state = state & 0xfffffffe /* remove-active doCachedInstance(DynamicObject, DynamicObject, boolean) */;
                                this.state_ = state = state | 0b10 /* add-active doCachedShape(DynamicObject, Shape, boolean) */;
                            }
                        }
                    }
                    if (s2_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return IsBoundFunctionCacheNode.doCachedShape(arg0Value, s2_.cachedShape_, s2_.cachedIsBound_);
                    }
                }
                this.exclude_ = exclude = exclude | 0b11 /* add-excluded doCachedInstance(DynamicObject, DynamicObject, boolean), doCachedShape(DynamicObject, Shape, boolean) */;
                this.cachedShape_cache = null;
                state = state & 0xfffffffc /* remove-active doCachedInstance(DynamicObject, DynamicObject, boolean), doCachedShape(DynamicObject, Shape, boolean) */;
                this.state_ = state = state | 0b100 /* add-active isBoundFunction(DynamicObject) */;
                lock.unlock();
                hasLock = false;
                return IsBoundFunctionCacheNode.isBoundFunction(arg0Value);
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
                CachedShapeData s2_ = this.cachedShape_cache;
                if ((s2_ == null || s2_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
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
            s[0] = "doCachedInstance";
            if ((state & 0b1) != 0 /* is-active doCachedInstance(DynamicObject, DynamicObject, boolean) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.cachedInstance_cachedFunction_, this.cachedInstance_cachedIsBound_));
                s[2] = cached;
            } else if ((exclude & 0b1) != 0 /* is-excluded doCachedInstance(DynamicObject, DynamicObject, boolean) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doCachedShape";
            if ((state & 0b10) != 0 /* is-active doCachedShape(DynamicObject, Shape, boolean) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                CachedShapeData s2_ = this.cachedShape_cache;
                while (s2_ != null) {
                    cached.add(Arrays.asList(s2_.cachedShape_, s2_.cachedIsBound_));
                    s2_ = s2_.next_;
                }
                s[2] = cached;
            } else if ((exclude & 0b10) != 0 /* is-excluded doCachedShape(DynamicObject, Shape, boolean) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "isBoundFunction";
            if ((state & 0b100) != 0 /* is-active isBoundFunction(DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static IsBoundFunctionCacheNode create(boolean multiContext) {
            return new IsBoundFunctionCacheNodeGen(multiContext);
        }

        @GeneratedBy(IsBoundFunctionCacheNode.class)
        private static final class CachedShapeData {

            @CompilationFinal CachedShapeData next_;
            @CompilationFinal Shape cachedShape_;
            @CompilationFinal boolean cachedIsBound_;

            CachedShapeData(CachedShapeData next_) {
                this.next_ = next_;
            }

        }
    }
}
