// CheckStyle: start generated
package com.oracle.truffle.js.nodes.control;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.access.IsArrayNode;
import com.oracle.truffle.js.nodes.array.JSArrayDeleteIndexNode;
import com.oracle.truffle.js.nodes.cast.JSToPropertyKeyNode;
import com.oracle.truffle.js.nodes.cast.ToArrayIndexNode;
import com.oracle.truffle.js.runtime.BigInt;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.SafeInteger;
import com.oracle.truffle.js.runtime.Symbol;
import com.oracle.truffle.js.runtime.util.JSClassProfile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(DeletePropertyNode.class)
public final class DeletePropertyNodeGen extends DeletePropertyNode implements Provider {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @Child private JSToPropertyKeyNode toPropertyKey;
    @Child private ToArrayIndexNode toArrayIndex;
    @Child private InteropLibrary interop;
    @Child private IsArrayNode jSObject_isArrayNode_;
    @CompilationFinal private ConditionProfile jSObject_arrayProfile_;
    @Child private ToArrayIndexNode jSObject_toArrayIndexNode_;
    @CompilationFinal private ConditionProfile jSObject_arrayIndexProfile_;
    @Child private JSArrayDeleteIndexNode jSObject_deleteArrayIndexNode_;
    @CompilationFinal private JSClassProfile jSObject_jsclassProfile_;

    private DeletePropertyNodeGen(boolean strict, JSContext context, JavaScriptNode targetNode, JavaScriptNode propertyNode) {
        super(strict, context, targetNode, propertyNode);
    }

    @Override
    public Object executeWithTarget(VirtualFrame frameValue, Object targetNodeValue) {
        int state = state_;
        if ((state & 0b1110111111) == 0 /* only-active arrayElementInt(Object, int, InteropLibrary) */ && (state & 0b1111111111) != 0  /* is-not doJSObject(DynamicObject, Object, IsArrayNode, ConditionProfile, ToArrayIndexNode, ConditionProfile, JSArrayDeleteIndexNode, JSClassProfile, JSToPropertyKeyNode) && doSymbol(Symbol, Object, JSToPropertyKeyNode) && doSafeInteger(SafeInteger, Object, JSToPropertyKeyNode) && doBigInt(BigInt, Object, JSToPropertyKeyNode) && doString(String, Object, ToArrayIndexNode) && member(Object, String, InteropLibrary) && arrayElementInt(Object, int, InteropLibrary) && arrayElement(Object, Number, InteropLibrary) && foreignObject(Object, Object, InteropLibrary, ToArrayIndexNode) && doOther(Object, Object, JSToPropertyKeyNode) */) {
            return executeWithTarget_int0(frameValue, state, targetNodeValue);
        } else {
            return executeWithTarget_generic1(frameValue, state, targetNodeValue);
        }
    }

    private Object executeWithTarget_int0(VirtualFrame frameValue, int state, Object targetNodeValue) {
        int propertyNodeValue_;
        try {
            propertyNodeValue_ = super.propertyNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(targetNodeValue, ex.getResult());
        }
        assert (state & 0b1000000) != 0 /* is-active arrayElementInt(Object, int, InteropLibrary) */;
        if ((JSGuards.isForeignObject(targetNodeValue))) {
            return arrayElementInt(targetNodeValue, propertyNodeValue_, this.interop);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(targetNodeValue, propertyNodeValue_);
    }

    private Object executeWithTarget_generic1(VirtualFrame frameValue, int state, Object targetNodeValue) {
        Object propertyNodeValue_ = super.propertyNode.execute(frameValue);
        if ((state & 0b11111) != 0 /* is-active doJSObject(DynamicObject, Object, IsArrayNode, ConditionProfile, ToArrayIndexNode, ConditionProfile, JSArrayDeleteIndexNode, JSClassProfile, JSToPropertyKeyNode) || doSymbol(Symbol, Object, JSToPropertyKeyNode) || doSafeInteger(SafeInteger, Object, JSToPropertyKeyNode) || doBigInt(BigInt, Object, JSToPropertyKeyNode) || doString(String, Object, ToArrayIndexNode) */) {
            if ((state & 0b1) != 0 /* is-active doJSObject(DynamicObject, Object, IsArrayNode, ConditionProfile, ToArrayIndexNode, ConditionProfile, JSArrayDeleteIndexNode, JSClassProfile, JSToPropertyKeyNode) */ && JSTypes.isDynamicObject(targetNodeValue)) {
                DynamicObject targetNodeValue_ = (DynamicObject) targetNodeValue;
                if ((JSGuards.isJSDynamicObject(targetNodeValue_))) {
                    return doJSObject(targetNodeValue_, propertyNodeValue_, this.jSObject_isArrayNode_, this.jSObject_arrayProfile_, this.jSObject_toArrayIndexNode_, this.jSObject_arrayIndexProfile_, this.jSObject_deleteArrayIndexNode_, this.jSObject_jsclassProfile_, this.toPropertyKey);
                }
            }
            if ((state & 0b10) != 0 /* is-active doSymbol(Symbol, Object, JSToPropertyKeyNode) */ && targetNodeValue instanceof Symbol) {
                Symbol targetNodeValue_ = (Symbol) targetNodeValue;
                return DeletePropertyNode.doSymbol(targetNodeValue_, propertyNodeValue_, this.toPropertyKey);
            }
            if ((state & 0b100) != 0 /* is-active doSafeInteger(SafeInteger, Object, JSToPropertyKeyNode) */ && targetNodeValue instanceof SafeInteger) {
                SafeInteger targetNodeValue_ = (SafeInteger) targetNodeValue;
                return DeletePropertyNode.doSafeInteger(targetNodeValue_, propertyNodeValue_, this.toPropertyKey);
            }
            if ((state & 0b1000) != 0 /* is-active doBigInt(BigInt, Object, JSToPropertyKeyNode) */ && targetNodeValue instanceof BigInt) {
                BigInt targetNodeValue_ = (BigInt) targetNodeValue;
                return DeletePropertyNode.doBigInt(targetNodeValue_, propertyNodeValue_, this.toPropertyKey);
            }
            if ((state & 0b10000) != 0 /* is-active doString(String, Object, ToArrayIndexNode) */ && JSTypesGen.isImplicitString((state & 0b11110000000000) >>> 10 /* extract-implicit-active 0:String */, targetNodeValue)) {
                String targetNodeValue_ = JSTypesGen.asImplicitString((state & 0b11110000000000) >>> 10 /* extract-implicit-active 0:String */, targetNodeValue);
                return doString(targetNodeValue_, propertyNodeValue_, this.toArrayIndex);
            }
        }
        if ((state & 0b1111100000) != 0 /* is-active member(Object, String, InteropLibrary) || arrayElementInt(Object, int, InteropLibrary) || arrayElement(Object, Number, InteropLibrary) || foreignObject(Object, Object, InteropLibrary, ToArrayIndexNode) || doOther(Object, Object, JSToPropertyKeyNode) */) {
            if ((state & 0b100000) != 0 /* is-active member(Object, String, InteropLibrary) */ && JSTypesGen.isImplicitString((state & 0x3c000) >>> 14 /* extract-implicit-active 1:String */, propertyNodeValue_)) {
                String propertyNodeValue__ = JSTypesGen.asImplicitString((state & 0x3c000) >>> 14 /* extract-implicit-active 1:String */, propertyNodeValue_);
                if ((JSGuards.isForeignObject(targetNodeValue))) {
                    return member(targetNodeValue, propertyNodeValue__, this.interop);
                }
            }
            if ((state & 0b1000000) != 0 /* is-active arrayElementInt(Object, int, InteropLibrary) */ && propertyNodeValue_ instanceof Integer) {
                int propertyNodeValue__ = (int) propertyNodeValue_;
                if ((JSGuards.isForeignObject(targetNodeValue))) {
                    return arrayElementInt(targetNodeValue, propertyNodeValue__, this.interop);
                }
            }
            if ((state & 0b10000000) != 0 /* is-active arrayElement(Object, Number, InteropLibrary) */ && propertyNodeValue_ instanceof Number) {
                Number propertyNodeValue__ = (Number) propertyNodeValue_;
                if ((JSGuards.isForeignObject(targetNodeValue)) && (JSGuards.isNumber(propertyNodeValue__))) {
                    return arrayElement(targetNodeValue, propertyNodeValue__, this.interop);
                }
            }
            if ((state & 0b1100000000) != 0 /* is-active foreignObject(Object, Object, InteropLibrary, ToArrayIndexNode) || doOther(Object, Object, JSToPropertyKeyNode) */) {
                if ((state & 0b100000000) != 0 /* is-active foreignObject(Object, Object, InteropLibrary, ToArrayIndexNode) */) {
                    if ((JSGuards.isForeignObject(targetNodeValue)) && (!(JSGuards.isString(propertyNodeValue_))) && (!(JSGuards.isNumber(propertyNodeValue_)))) {
                        return foreignObject(targetNodeValue, propertyNodeValue_, this.interop, this.toArrayIndex);
                    }
                }
                if ((state & 0b1000000000) != 0 /* is-active doOther(Object, Object, JSToPropertyKeyNode) */) {
                    if ((!(JSGuards.isTruffleObject(targetNodeValue))) && (!(JSGuards.isString(targetNodeValue)))) {
                        return doOther(targetNodeValue, propertyNodeValue_, this.toPropertyKey);
                    }
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(targetNodeValue, propertyNodeValue_);
    }

    @Override
    public boolean executeBoolean(VirtualFrame frameValue) throws UnexpectedResultException {
        int state = state_;
        if ((state & 0b1010111111) == 0 /* only-active arrayElementInt(Object, int, InteropLibrary) */ && (state & 0b1011111111) != 0  /* is-not doJSObject(DynamicObject, Object, IsArrayNode, ConditionProfile, ToArrayIndexNode, ConditionProfile, JSArrayDeleteIndexNode, JSClassProfile, JSToPropertyKeyNode) && doSymbol(Symbol, Object, JSToPropertyKeyNode) && doSafeInteger(SafeInteger, Object, JSToPropertyKeyNode) && doBigInt(BigInt, Object, JSToPropertyKeyNode) && doString(String, Object, ToArrayIndexNode) && member(Object, String, InteropLibrary) && arrayElementInt(Object, int, InteropLibrary) && arrayElement(Object, Number, InteropLibrary) && doOther(Object, Object, JSToPropertyKeyNode) */) {
            return executeBoolean_int2(frameValue, state);
        } else {
            return executeBoolean_generic3(frameValue, state);
        }
    }

    private boolean executeBoolean_int2(VirtualFrame frameValue, int state) throws UnexpectedResultException {
        Object targetNodeValue_ = super.targetNode.execute(frameValue);
        int propertyNodeValue_;
        try {
            propertyNodeValue_ = super.propertyNode.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            return JSTypesGen.expectBoolean(executeAndSpecialize(targetNodeValue_, ex.getResult()));
        }
        assert (state & 0b1000000) != 0 /* is-active arrayElementInt(Object, int, InteropLibrary) */;
        if ((JSGuards.isForeignObject(targetNodeValue_))) {
            return arrayElementInt(targetNodeValue_, propertyNodeValue_, this.interop);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectBoolean(executeAndSpecialize(targetNodeValue_, propertyNodeValue_));
    }

    private boolean executeBoolean_generic3(VirtualFrame frameValue, int state) throws UnexpectedResultException {
        Object targetNodeValue_ = super.targetNode.execute(frameValue);
        Object propertyNodeValue_ = super.propertyNode.execute(frameValue);
        if ((state & 0b11111) != 0 /* is-active doJSObject(DynamicObject, Object, IsArrayNode, ConditionProfile, ToArrayIndexNode, ConditionProfile, JSArrayDeleteIndexNode, JSClassProfile, JSToPropertyKeyNode) || doSymbol(Symbol, Object, JSToPropertyKeyNode) || doSafeInteger(SafeInteger, Object, JSToPropertyKeyNode) || doBigInt(BigInt, Object, JSToPropertyKeyNode) || doString(String, Object, ToArrayIndexNode) */) {
            if ((state & 0b1) != 0 /* is-active doJSObject(DynamicObject, Object, IsArrayNode, ConditionProfile, ToArrayIndexNode, ConditionProfile, JSArrayDeleteIndexNode, JSClassProfile, JSToPropertyKeyNode) */ && JSTypes.isDynamicObject(targetNodeValue_)) {
                DynamicObject targetNodeValue__ = (DynamicObject) targetNodeValue_;
                if ((JSGuards.isJSDynamicObject(targetNodeValue__))) {
                    return doJSObject(targetNodeValue__, propertyNodeValue_, this.jSObject_isArrayNode_, this.jSObject_arrayProfile_, this.jSObject_toArrayIndexNode_, this.jSObject_arrayIndexProfile_, this.jSObject_deleteArrayIndexNode_, this.jSObject_jsclassProfile_, this.toPropertyKey);
                }
            }
            if ((state & 0b10) != 0 /* is-active doSymbol(Symbol, Object, JSToPropertyKeyNode) */ && targetNodeValue_ instanceof Symbol) {
                Symbol targetNodeValue__ = (Symbol) targetNodeValue_;
                return DeletePropertyNode.doSymbol(targetNodeValue__, propertyNodeValue_, this.toPropertyKey);
            }
            if ((state & 0b100) != 0 /* is-active doSafeInteger(SafeInteger, Object, JSToPropertyKeyNode) */ && targetNodeValue_ instanceof SafeInteger) {
                SafeInteger targetNodeValue__ = (SafeInteger) targetNodeValue_;
                return DeletePropertyNode.doSafeInteger(targetNodeValue__, propertyNodeValue_, this.toPropertyKey);
            }
            if ((state & 0b1000) != 0 /* is-active doBigInt(BigInt, Object, JSToPropertyKeyNode) */ && targetNodeValue_ instanceof BigInt) {
                BigInt targetNodeValue__ = (BigInt) targetNodeValue_;
                return DeletePropertyNode.doBigInt(targetNodeValue__, propertyNodeValue_, this.toPropertyKey);
            }
            if ((state & 0b10000) != 0 /* is-active doString(String, Object, ToArrayIndexNode) */ && JSTypesGen.isImplicitString((state & 0b11110000000000) >>> 10 /* extract-implicit-active 0:String */, targetNodeValue_)) {
                String targetNodeValue__ = JSTypesGen.asImplicitString((state & 0b11110000000000) >>> 10 /* extract-implicit-active 0:String */, targetNodeValue_);
                return doString(targetNodeValue__, propertyNodeValue_, this.toArrayIndex);
            }
        }
        if ((state & 0b1011100000) != 0 /* is-active member(Object, String, InteropLibrary) || arrayElementInt(Object, int, InteropLibrary) || arrayElement(Object, Number, InteropLibrary) || doOther(Object, Object, JSToPropertyKeyNode) */) {
            if ((state & 0b100000) != 0 /* is-active member(Object, String, InteropLibrary) */ && JSTypesGen.isImplicitString((state & 0x3c000) >>> 14 /* extract-implicit-active 1:String */, propertyNodeValue_)) {
                String propertyNodeValue__ = JSTypesGen.asImplicitString((state & 0x3c000) >>> 14 /* extract-implicit-active 1:String */, propertyNodeValue_);
                if ((JSGuards.isForeignObject(targetNodeValue_))) {
                    return member(targetNodeValue_, propertyNodeValue__, this.interop);
                }
            }
            if ((state & 0b1000000) != 0 /* is-active arrayElementInt(Object, int, InteropLibrary) */ && propertyNodeValue_ instanceof Integer) {
                int propertyNodeValue__ = (int) propertyNodeValue_;
                if ((JSGuards.isForeignObject(targetNodeValue_))) {
                    return arrayElementInt(targetNodeValue_, propertyNodeValue__, this.interop);
                }
            }
            if ((state & 0b10000000) != 0 /* is-active arrayElement(Object, Number, InteropLibrary) */ && propertyNodeValue_ instanceof Number) {
                Number propertyNodeValue__ = (Number) propertyNodeValue_;
                if ((JSGuards.isForeignObject(targetNodeValue_)) && (JSGuards.isNumber(propertyNodeValue__))) {
                    return arrayElement(targetNodeValue_, propertyNodeValue__, this.interop);
                }
            }
            if ((state & 0b1000000000) != 0 /* is-active doOther(Object, Object, JSToPropertyKeyNode) */) {
                if ((!(JSGuards.isTruffleObject(targetNodeValue_))) && (!(JSGuards.isString(targetNodeValue_)))) {
                    return doOther(targetNodeValue_, propertyNodeValue_, this.toPropertyKey);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectBoolean(executeAndSpecialize(targetNodeValue_, propertyNodeValue_));
    }

    @Override
    public boolean executeEvaluated(Object targetNodeValue, Object propertyNodeValue) {
        int state = state_;
        if ((state & 0b11111) != 0 /* is-active doJSObject(DynamicObject, Object, IsArrayNode, ConditionProfile, ToArrayIndexNode, ConditionProfile, JSArrayDeleteIndexNode, JSClassProfile, JSToPropertyKeyNode) || doSymbol(Symbol, Object, JSToPropertyKeyNode) || doSafeInteger(SafeInteger, Object, JSToPropertyKeyNode) || doBigInt(BigInt, Object, JSToPropertyKeyNode) || doString(String, Object, ToArrayIndexNode) */) {
            if ((state & 0b1) != 0 /* is-active doJSObject(DynamicObject, Object, IsArrayNode, ConditionProfile, ToArrayIndexNode, ConditionProfile, JSArrayDeleteIndexNode, JSClassProfile, JSToPropertyKeyNode) */ && JSTypes.isDynamicObject(targetNodeValue)) {
                DynamicObject targetNodeValue_ = (DynamicObject) targetNodeValue;
                if ((JSGuards.isJSDynamicObject(targetNodeValue_))) {
                    return doJSObject(targetNodeValue_, propertyNodeValue, this.jSObject_isArrayNode_, this.jSObject_arrayProfile_, this.jSObject_toArrayIndexNode_, this.jSObject_arrayIndexProfile_, this.jSObject_deleteArrayIndexNode_, this.jSObject_jsclassProfile_, this.toPropertyKey);
                }
            }
            if ((state & 0b10) != 0 /* is-active doSymbol(Symbol, Object, JSToPropertyKeyNode) */ && targetNodeValue instanceof Symbol) {
                Symbol targetNodeValue_ = (Symbol) targetNodeValue;
                return DeletePropertyNode.doSymbol(targetNodeValue_, propertyNodeValue, this.toPropertyKey);
            }
            if ((state & 0b100) != 0 /* is-active doSafeInteger(SafeInteger, Object, JSToPropertyKeyNode) */ && targetNodeValue instanceof SafeInteger) {
                SafeInteger targetNodeValue_ = (SafeInteger) targetNodeValue;
                return DeletePropertyNode.doSafeInteger(targetNodeValue_, propertyNodeValue, this.toPropertyKey);
            }
            if ((state & 0b1000) != 0 /* is-active doBigInt(BigInt, Object, JSToPropertyKeyNode) */ && targetNodeValue instanceof BigInt) {
                BigInt targetNodeValue_ = (BigInt) targetNodeValue;
                return DeletePropertyNode.doBigInt(targetNodeValue_, propertyNodeValue, this.toPropertyKey);
            }
            if ((state & 0b10000) != 0 /* is-active doString(String, Object, ToArrayIndexNode) */ && JSTypesGen.isImplicitString((state & 0b11110000000000) >>> 10 /* extract-implicit-active 0:String */, targetNodeValue)) {
                String targetNodeValue_ = JSTypesGen.asImplicitString((state & 0b11110000000000) >>> 10 /* extract-implicit-active 0:String */, targetNodeValue);
                return doString(targetNodeValue_, propertyNodeValue, this.toArrayIndex);
            }
        }
        if ((state & 0b1011100000) != 0 /* is-active member(Object, String, InteropLibrary) || arrayElementInt(Object, int, InteropLibrary) || arrayElement(Object, Number, InteropLibrary) || doOther(Object, Object, JSToPropertyKeyNode) */) {
            if ((state & 0b100000) != 0 /* is-active member(Object, String, InteropLibrary) */ && JSTypesGen.isImplicitString((state & 0x3c000) >>> 14 /* extract-implicit-active 1:String */, propertyNodeValue)) {
                String propertyNodeValue_ = JSTypesGen.asImplicitString((state & 0x3c000) >>> 14 /* extract-implicit-active 1:String */, propertyNodeValue);
                if ((JSGuards.isForeignObject(targetNodeValue))) {
                    return member(targetNodeValue, propertyNodeValue_, this.interop);
                }
            }
            if ((state & 0b1000000) != 0 /* is-active arrayElementInt(Object, int, InteropLibrary) */ && propertyNodeValue instanceof Integer) {
                int propertyNodeValue_ = (int) propertyNodeValue;
                if ((JSGuards.isForeignObject(targetNodeValue))) {
                    return arrayElementInt(targetNodeValue, propertyNodeValue_, this.interop);
                }
            }
            if ((state & 0b10000000) != 0 /* is-active arrayElement(Object, Number, InteropLibrary) */ && propertyNodeValue instanceof Number) {
                Number propertyNodeValue_ = (Number) propertyNodeValue;
                if ((JSGuards.isForeignObject(targetNodeValue)) && (JSGuards.isNumber(propertyNodeValue_))) {
                    return arrayElement(targetNodeValue, propertyNodeValue_, this.interop);
                }
            }
            if ((state & 0b1000000000) != 0 /* is-active doOther(Object, Object, JSToPropertyKeyNode) */) {
                if ((!(JSGuards.isTruffleObject(targetNodeValue))) && (!(JSGuards.isString(targetNodeValue)))) {
                    return doOther(targetNodeValue, propertyNodeValue, this.toPropertyKey);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return (boolean) executeAndSpecialize(targetNodeValue, propertyNodeValue);
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        int state = state_;
        try {
            if ((state & 0b100000000) == 0 /* only-active doJSObject(DynamicObject, Object, IsArrayNode, ConditionProfile, ToArrayIndexNode, ConditionProfile, JSArrayDeleteIndexNode, JSClassProfile, JSToPropertyKeyNode) && doSymbol(Symbol, Object, JSToPropertyKeyNode) && doSafeInteger(SafeInteger, Object, JSToPropertyKeyNode) && doBigInt(BigInt, Object, JSToPropertyKeyNode) && doString(String, Object, ToArrayIndexNode) && member(Object, String, InteropLibrary) && arrayElementInt(Object, int, InteropLibrary) && arrayElement(Object, Number, InteropLibrary) && doOther(Object, Object, JSToPropertyKeyNode) */ && (state & 0b1111111111) != 0  /* is-not doJSObject(DynamicObject, Object, IsArrayNode, ConditionProfile, ToArrayIndexNode, ConditionProfile, JSArrayDeleteIndexNode, JSClassProfile, JSToPropertyKeyNode) && doSymbol(Symbol, Object, JSToPropertyKeyNode) && doSafeInteger(SafeInteger, Object, JSToPropertyKeyNode) && doBigInt(BigInt, Object, JSToPropertyKeyNode) && doString(String, Object, ToArrayIndexNode) && member(Object, String, InteropLibrary) && arrayElementInt(Object, int, InteropLibrary) && arrayElement(Object, Number, InteropLibrary) && foreignObject(Object, Object, InteropLibrary, ToArrayIndexNode) && doOther(Object, Object, JSToPropertyKeyNode) */) {
                executeBoolean(frameValue);
                return;
            }
            executeBoolean(frameValue);
            return;
        } catch (UnexpectedResultException ex) {
            return;
        }
    }

    private Object executeAndSpecialize(Object targetNodeValue, Object propertyNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        int exclude = exclude_;
        try {
            if (JSTypes.isDynamicObject(targetNodeValue)) {
                DynamicObject targetNodeValue_ = (DynamicObject) targetNodeValue;
                if ((JSGuards.isJSDynamicObject(targetNodeValue_))) {
                    this.jSObject_isArrayNode_ = super.insert((IsArrayNode.createIsFastArray()));
                    this.jSObject_arrayProfile_ = (ConditionProfile.createBinaryProfile());
                    this.jSObject_toArrayIndexNode_ = super.insert((ToArrayIndexNode.create()));
                    this.jSObject_arrayIndexProfile_ = (ConditionProfile.createBinaryProfile());
                    this.jSObject_deleteArrayIndexNode_ = super.insert((JSArrayDeleteIndexNode.create(context, strict)));
                    this.jSObject_jsclassProfile_ = (JSClassProfile.create());
                    if (this.toPropertyKey == null) {
                        this.toPropertyKey = super.insert((JSToPropertyKeyNode.create()));
                    }
                    this.state_ = state = state | 0b1 /* add-active doJSObject(DynamicObject, Object, IsArrayNode, ConditionProfile, ToArrayIndexNode, ConditionProfile, JSArrayDeleteIndexNode, JSClassProfile, JSToPropertyKeyNode) */;
                    lock.unlock();
                    hasLock = false;
                    return doJSObject(targetNodeValue_, propertyNodeValue, this.jSObject_isArrayNode_, this.jSObject_arrayProfile_, this.jSObject_toArrayIndexNode_, this.jSObject_arrayIndexProfile_, this.jSObject_deleteArrayIndexNode_, this.jSObject_jsclassProfile_, this.toPropertyKey);
                }
            }
            if (targetNodeValue instanceof Symbol) {
                Symbol targetNodeValue_ = (Symbol) targetNodeValue;
                if (this.toPropertyKey == null) {
                    this.toPropertyKey = super.insert((JSToPropertyKeyNode.create()));
                }
                this.state_ = state = state | 0b10 /* add-active doSymbol(Symbol, Object, JSToPropertyKeyNode) */;
                lock.unlock();
                hasLock = false;
                return DeletePropertyNode.doSymbol(targetNodeValue_, propertyNodeValue, this.toPropertyKey);
            }
            if (targetNodeValue instanceof SafeInteger) {
                SafeInteger targetNodeValue_ = (SafeInteger) targetNodeValue;
                if (this.toPropertyKey == null) {
                    this.toPropertyKey = super.insert((JSToPropertyKeyNode.create()));
                }
                this.state_ = state = state | 0b100 /* add-active doSafeInteger(SafeInteger, Object, JSToPropertyKeyNode) */;
                lock.unlock();
                hasLock = false;
                return DeletePropertyNode.doSafeInteger(targetNodeValue_, propertyNodeValue, this.toPropertyKey);
            }
            if (targetNodeValue instanceof BigInt) {
                BigInt targetNodeValue_ = (BigInt) targetNodeValue;
                if (this.toPropertyKey == null) {
                    this.toPropertyKey = super.insert((JSToPropertyKeyNode.create()));
                }
                this.state_ = state = state | 0b1000 /* add-active doBigInt(BigInt, Object, JSToPropertyKeyNode) */;
                lock.unlock();
                hasLock = false;
                return DeletePropertyNode.doBigInt(targetNodeValue_, propertyNodeValue, this.toPropertyKey);
            }
            {
                int stringCast0;
                if ((stringCast0 = JSTypesGen.specializeImplicitString(targetNodeValue)) != 0) {
                    String targetNodeValue_ = JSTypesGen.asImplicitString(stringCast0, targetNodeValue);
                    if (this.toArrayIndex == null) {
                        this.toArrayIndex = super.insert((ToArrayIndexNode.create()));
                    }
                    state = (state | (stringCast0 << 10) /* set-implicit-active 0:String */);
                    this.state_ = state = state | 0b10000 /* add-active doString(String, Object, ToArrayIndexNode) */;
                    lock.unlock();
                    hasLock = false;
                    return doString(targetNodeValue_, propertyNodeValue, this.toArrayIndex);
                }
            }
            {
                int stringCast1;
                if ((stringCast1 = JSTypesGen.specializeImplicitString(propertyNodeValue)) != 0) {
                    String propertyNodeValue_ = JSTypesGen.asImplicitString(stringCast1, propertyNodeValue);
                    if ((JSGuards.isForeignObject(targetNodeValue))) {
                        if (this.interop == null) {
                            this.interop = super.insert((INTEROP_LIBRARY_.createDispatched(3)));
                        }
                        state = (state | (stringCast1 << 14) /* set-implicit-active 1:String */);
                        this.state_ = state = state | 0b100000 /* add-active member(Object, String, InteropLibrary) */;
                        lock.unlock();
                        hasLock = false;
                        return member(targetNodeValue, propertyNodeValue_, this.interop);
                    }
                }
            }
            if ((exclude) == 0 /* is-not-excluded arrayElementInt(Object, int, InteropLibrary) */ && propertyNodeValue instanceof Integer) {
                int propertyNodeValue_ = (int) propertyNodeValue;
                if ((JSGuards.isForeignObject(targetNodeValue))) {
                    if (this.interop == null) {
                        this.interop = super.insert((INTEROP_LIBRARY_.createDispatched(3)));
                    }
                    this.state_ = state = state | 0b1000000 /* add-active arrayElementInt(Object, int, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arrayElementInt(targetNodeValue, propertyNodeValue_, this.interop);
                }
            }
            if (propertyNodeValue instanceof Number) {
                Number propertyNodeValue_ = (Number) propertyNodeValue;
                if ((JSGuards.isForeignObject(targetNodeValue)) && (JSGuards.isNumber(propertyNodeValue_))) {
                    if (this.interop == null) {
                        this.interop = super.insert((INTEROP_LIBRARY_.createDispatched(3)));
                    }
                    this.exclude_ = exclude = exclude | 0b1 /* add-excluded arrayElementInt(Object, int, InteropLibrary) */;
                    state = state & 0xffffffbf /* remove-active arrayElementInt(Object, int, InteropLibrary) */;
                    this.state_ = state = state | 0b10000000 /* add-active arrayElement(Object, Number, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arrayElement(targetNodeValue, propertyNodeValue_, this.interop);
                }
            }
            if ((JSGuards.isForeignObject(targetNodeValue)) && (!(JSGuards.isString(propertyNodeValue))) && (!(JSGuards.isNumber(propertyNodeValue)))) {
                if (this.interop == null) {
                    this.interop = super.insert((INTEROP_LIBRARY_.createDispatched(3)));
                }
                if (this.toArrayIndex == null) {
                    this.toArrayIndex = super.insert((ToArrayIndexNode.create()));
                }
                this.state_ = state = state | 0b100000000 /* add-active foreignObject(Object, Object, InteropLibrary, ToArrayIndexNode) */;
                lock.unlock();
                hasLock = false;
                return foreignObject(targetNodeValue, propertyNodeValue, this.interop, this.toArrayIndex);
            }
            if ((!(JSGuards.isTruffleObject(targetNodeValue))) && (!(JSGuards.isString(targetNodeValue)))) {
                if (this.toPropertyKey == null) {
                    this.toPropertyKey = super.insert((JSToPropertyKeyNode.create()));
                }
                this.state_ = state = state | 0b1000000000 /* add-active doOther(Object, Object, JSToPropertyKeyNode) */;
                lock.unlock();
                hasLock = false;
                return doOther(targetNodeValue, propertyNodeValue, this.toPropertyKey);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {super.targetNode, super.propertyNode}, targetNodeValue, propertyNodeValue);
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
            return NodeCost.MONOMORPHIC;
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
        if ((state & 0b1) != 0 /* is-active doJSObject(DynamicObject, Object, IsArrayNode, ConditionProfile, ToArrayIndexNode, ConditionProfile, JSArrayDeleteIndexNode, JSClassProfile, JSToPropertyKeyNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.jSObject_isArrayNode_, this.jSObject_arrayProfile_, this.jSObject_toArrayIndexNode_, this.jSObject_arrayIndexProfile_, this.jSObject_deleteArrayIndexNode_, this.jSObject_jsclassProfile_, this.toPropertyKey));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doSymbol";
        if ((state & 0b10) != 0 /* is-active doSymbol(Symbol, Object, JSToPropertyKeyNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.toPropertyKey));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doSafeInteger";
        if ((state & 0b100) != 0 /* is-active doSafeInteger(SafeInteger, Object, JSToPropertyKeyNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.toPropertyKey));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doBigInt";
        if ((state & 0b1000) != 0 /* is-active doBigInt(BigInt, Object, JSToPropertyKeyNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.toPropertyKey));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doString";
        if ((state & 0b10000) != 0 /* is-active doString(String, Object, ToArrayIndexNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.toArrayIndex));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "member";
        if ((state & 0b100000) != 0 /* is-active member(Object, String, InteropLibrary) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.interop));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "arrayElementInt";
        if ((state & 0b1000000) != 0 /* is-active arrayElementInt(Object, int, InteropLibrary) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.interop));
            s[2] = cached;
        } else if (exclude != 0 /* is-excluded arrayElementInt(Object, int, InteropLibrary) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        s = new Object[3];
        s[0] = "arrayElement";
        if ((state & 0b10000000) != 0 /* is-active arrayElement(Object, Number, InteropLibrary) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.interop));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[8] = s;
        s = new Object[3];
        s[0] = "foreignObject";
        if ((state & 0b100000000) != 0 /* is-active foreignObject(Object, Object, InteropLibrary, ToArrayIndexNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.interop, this.toArrayIndex));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[9] = s;
        s = new Object[3];
        s[0] = "doOther";
        if ((state & 0b1000000000) != 0 /* is-active doOther(Object, Object, JSToPropertyKeyNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.toPropertyKey));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[10] = s;
        return Provider.create(data);
    }

    public static DeletePropertyNode create(boolean strict, JSContext context, JavaScriptNode targetNode, JavaScriptNode propertyNode) {
        return new DeletePropertyNodeGen(strict, context, targetNode, propertyNode);
    }

}
