// CheckStyle: start generated
package com.oracle.truffle.js.nodes.interop;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.TruffleLanguage.LanguageReference;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.interop.TruffleObject;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.lang.JavaScriptLanguage;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.runtime.BigInt;
import com.oracle.truffle.js.runtime.SafeInteger;
import com.oracle.truffle.js.runtime.builtins.JSFunction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(ExportValueNode.class)
public final class ExportValueNodeGen extends ExportValueNode implements Provider {

    private static final Uncached UNCACHED = new Uncached();

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private LanguageReference<JavaScriptLanguage> javaScriptLanguageReference_;

    private ExportValueNodeGen() {
    }

    @Override
    public Object execute(Object arg0Value, Object arg1Value, boolean arg2Value) {
        int state = state_;
        if ((state & 0b111111111111111) != 0 /* is-active doFunctionNoBind(DynamicObject, Object, boolean, JavaScriptLanguage) || doFunctionUndefinedThis(DynamicObject, Object, boolean, JavaScriptLanguage) || doBindUnboundFunction(DynamicObject, Object, boolean, JavaScriptLanguage) || doBoundFunction(DynamicObject, Object, boolean, JavaScriptLanguage) || doAsyncFunction(DynamicObject, Object, boolean, JavaScriptLanguage) || doSafeInteger(SafeInteger, Object, boolean) || doObject(DynamicObject, Object, boolean) || doInt(int, Object, boolean) || doLong(long, Object, boolean) || doDouble(double, Object, boolean) || doBoolean(boolean, Object, boolean) || doBigInt(BigInt, Object, boolean) || doString(String, Object, boolean) || doTruffleObject(TruffleObject, Object, boolean) || doOther(Object, Object, boolean) */) {
            if ((state & 0b11111) != 0 /* is-active doFunctionNoBind(DynamicObject, Object, boolean, JavaScriptLanguage) || doFunctionUndefinedThis(DynamicObject, Object, boolean, JavaScriptLanguage) || doBindUnboundFunction(DynamicObject, Object, boolean, JavaScriptLanguage) || doBoundFunction(DynamicObject, Object, boolean, JavaScriptLanguage) || doAsyncFunction(DynamicObject, Object, boolean, JavaScriptLanguage) */ && JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if ((state & 0b1) != 0 /* is-active doFunctionNoBind(DynamicObject, Object, boolean, JavaScriptLanguage) */) {
                    if ((JSGuards.isJSFunction(arg0Value_)) && (!(arg2Value))) {
                        LanguageReference<JavaScriptLanguage> javaScriptLanguageReference__ = this.javaScriptLanguageReference_;
                        JavaScriptLanguage functionNoBind_language__ = javaScriptLanguageReference__.get();
                        if ((!(ExportValueNode.isInteropCompletePromises(functionNoBind_language__)) || !(JSFunction.isAsyncFunction(arg0Value_)))) {
                            return ExportValueNode.doFunctionNoBind(arg0Value_, arg1Value, arg2Value, functionNoBind_language__);
                        }
                    }
                }
                if ((state & 0b10) != 0 /* is-active doFunctionUndefinedThis(DynamicObject, Object, boolean, JavaScriptLanguage) */) {
                    if ((JSGuards.isJSFunction(arg0Value_)) && (arg2Value) && (JSGuards.isUndefined(arg1Value))) {
                        LanguageReference<JavaScriptLanguage> javaScriptLanguageReference__1 = this.javaScriptLanguageReference_;
                        JavaScriptLanguage functionUndefinedThis_language__ = javaScriptLanguageReference__1.get();
                        if ((!(ExportValueNode.isInteropCompletePromises(functionUndefinedThis_language__)) || !(JSFunction.isAsyncFunction(arg0Value_)))) {
                            return ExportValueNode.doFunctionUndefinedThis(arg0Value_, arg1Value, arg2Value, functionUndefinedThis_language__);
                        }
                    }
                }
                if ((state & 0b100) != 0 /* is-active doBindUnboundFunction(DynamicObject, Object, boolean, JavaScriptLanguage) */) {
                    if ((JSGuards.isJSFunction(arg0Value_)) && (arg2Value) && (!(JSGuards.isUndefined(arg1Value))) && (!(JSGuards.isBoundJSFunction(arg0Value_)))) {
                        LanguageReference<JavaScriptLanguage> javaScriptLanguageReference__2 = this.javaScriptLanguageReference_;
                        JavaScriptLanguage bindUnboundFunction_language__ = javaScriptLanguageReference__2.get();
                        if ((!(ExportValueNode.isInteropCompletePromises(bindUnboundFunction_language__)) || !(JSFunction.isAsyncFunction(arg0Value_)))) {
                            return ExportValueNode.doBindUnboundFunction(arg0Value_, arg1Value, arg2Value, bindUnboundFunction_language__);
                        }
                    }
                }
                if ((state & 0b1000) != 0 /* is-active doBoundFunction(DynamicObject, Object, boolean, JavaScriptLanguage) */) {
                    if ((JSGuards.isJSFunction(arg0Value_)) && (arg2Value) && (JSGuards.isBoundJSFunction(arg0Value_))) {
                        LanguageReference<JavaScriptLanguage> javaScriptLanguageReference__3 = this.javaScriptLanguageReference_;
                        JavaScriptLanguage boundFunction_language__ = javaScriptLanguageReference__3.get();
                        if ((!(ExportValueNode.isInteropCompletePromises(boundFunction_language__)) || !(JSFunction.isAsyncFunction(arg0Value_)))) {
                            return ExportValueNode.doBoundFunction(arg0Value_, arg1Value, arg2Value, boundFunction_language__);
                        }
                    }
                }
                if ((state & 0b10000) != 0 /* is-active doAsyncFunction(DynamicObject, Object, boolean, JavaScriptLanguage) */) {
                    if ((JSGuards.isJSFunction(arg0Value_))) {
                        LanguageReference<JavaScriptLanguage> javaScriptLanguageReference__4 = this.javaScriptLanguageReference_;
                        JavaScriptLanguage asyncFunction_language__ = javaScriptLanguageReference__4.get();
                        if ((ExportValueNode.isInteropCompletePromises(asyncFunction_language__)) && (JSFunction.isAsyncFunction(arg0Value_))) {
                            return ExportValueNode.doAsyncFunction(arg0Value_, arg1Value, arg2Value, asyncFunction_language__);
                        }
                    }
                }
            }
            if ((state & 0b100000) != 0 /* is-active doSafeInteger(SafeInteger, Object, boolean) */ && arg0Value instanceof SafeInteger) {
                SafeInteger arg0Value_ = (SafeInteger) arg0Value;
                return ExportValueNode.doSafeInteger(arg0Value_, arg1Value, arg2Value);
            }
            if ((state & 0b1000000) != 0 /* is-active doObject(DynamicObject, Object, boolean) */ && JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if ((!(JSGuards.isJSFunction(arg0Value_)))) {
                    return ExportValueNode.doObject(arg0Value_, arg1Value, arg2Value);
                }
            }
            if ((state & 0b10000000) != 0 /* is-active doInt(int, Object, boolean) */ && arg0Value instanceof Integer) {
                int arg0Value_ = (int) arg0Value;
                return ExportValueNode.doInt(arg0Value_, arg1Value, arg2Value);
            }
            if ((state & 0b100000000) != 0 /* is-active doLong(long, Object, boolean) */ && arg0Value instanceof Long) {
                long arg0Value_ = (long) arg0Value;
                return ExportValueNode.doLong(arg0Value_, arg1Value, arg2Value);
            }
            if ((state & 0b1000000000) != 0 /* is-active doDouble(double, Object, boolean) */ && JSTypesGen.isImplicitDouble((state & 0x78000) >>> 15 /* extract-implicit-active 0:double */, arg0Value)) {
                double arg0Value_ = JSTypesGen.asImplicitDouble((state & 0x78000) >>> 15 /* extract-implicit-active 0:double */, arg0Value);
                return ExportValueNode.doDouble(arg0Value_, arg1Value, arg2Value);
            }
            if ((state & 0b10000000000) != 0 /* is-active doBoolean(boolean, Object, boolean) */ && arg0Value instanceof Boolean) {
                boolean arg0Value_ = (boolean) arg0Value;
                return ExportValueNode.doBoolean(arg0Value_, arg1Value, arg2Value);
            }
            if ((state & 0b100000000000) != 0 /* is-active doBigInt(BigInt, Object, boolean) */ && arg0Value instanceof BigInt) {
                BigInt arg0Value_ = (BigInt) arg0Value;
                return ExportValueNode.doBigInt(arg0Value_, arg1Value, arg2Value);
            }
            if ((state & 0b1000000000000) != 0 /* is-active doString(String, Object, boolean) */ && JSTypesGen.isImplicitString((state & 0x780000) >>> 19 /* extract-implicit-active 0:String */, arg0Value)) {
                String arg0Value_ = JSTypesGen.asImplicitString((state & 0x780000) >>> 19 /* extract-implicit-active 0:String */, arg0Value);
                return ExportValueNode.doString(arg0Value_, arg1Value, arg2Value);
            }
            if ((state & 0b10000000000000) != 0 /* is-active doTruffleObject(TruffleObject, Object, boolean) */ && arg0Value instanceof TruffleObject) {
                TruffleObject arg0Value_ = (TruffleObject) arg0Value;
                if ((!(JSGuards.isJSFunction(arg0Value_)))) {
                    return ExportValueNode.doTruffleObject(arg0Value_, arg1Value, arg2Value);
                }
            }
            if ((state & 0b100000000000000) != 0 /* is-active doOther(Object, Object, boolean) */) {
                if ((!(JSGuards.isTruffleObject(arg1Value))) && (!(JSGuards.isString(arg1Value))) && (!(JSGuards.isBoolean(arg1Value))) && (!(JSGuards.isNumberDouble(arg1Value))) && (!(JSGuards.isNumberLong(arg1Value))) && (!(JSGuards.isNumberInteger(arg1Value)))) {
                    return ExportValueNode.doOther(arg0Value, arg1Value, arg2Value);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value, arg2Value);
    }

    private Object executeAndSpecialize(Object arg0Value, Object arg1Value, boolean arg2Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        int exclude = exclude_;
        try {
            if (JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                {
                    JavaScriptLanguage functionNoBind_language__ = null;
                    if ((JSGuards.isJSFunction(arg0Value_)) && (!(arg2Value))) {
                        LanguageReference<JavaScriptLanguage> javaScriptLanguageReference__5 = this.javaScriptLanguageReference_;
                        if (javaScriptLanguageReference__5 == null) {
                            this.javaScriptLanguageReference_ = javaScriptLanguageReference__5 = super.lookupLanguageReference(JavaScriptLanguage.class);
                        }
                        functionNoBind_language__ = javaScriptLanguageReference__5.get();
                        if ((!(ExportValueNode.isInteropCompletePromises(functionNoBind_language__)) || !(JSFunction.isAsyncFunction(arg0Value_)))) {
                            this.state_ = state = state | 0b1 /* add-active doFunctionNoBind(DynamicObject, Object, boolean, JavaScriptLanguage) */;
                            lock.unlock();
                            hasLock = false;
                            return ExportValueNode.doFunctionNoBind(arg0Value_, arg1Value, arg2Value, functionNoBind_language__);
                        }
                    }
                }
                {
                    JavaScriptLanguage functionUndefinedThis_language__ = null;
                    if ((JSGuards.isJSFunction(arg0Value_)) && (arg2Value) && (JSGuards.isUndefined(arg1Value))) {
                        LanguageReference<JavaScriptLanguage> javaScriptLanguageReference__6 = this.javaScriptLanguageReference_;
                        if (javaScriptLanguageReference__6 == null) {
                            this.javaScriptLanguageReference_ = javaScriptLanguageReference__6 = super.lookupLanguageReference(JavaScriptLanguage.class);
                        }
                        functionUndefinedThis_language__ = javaScriptLanguageReference__6.get();
                        if ((!(ExportValueNode.isInteropCompletePromises(functionUndefinedThis_language__)) || !(JSFunction.isAsyncFunction(arg0Value_)))) {
                            this.state_ = state = state | 0b10 /* add-active doFunctionUndefinedThis(DynamicObject, Object, boolean, JavaScriptLanguage) */;
                            lock.unlock();
                            hasLock = false;
                            return ExportValueNode.doFunctionUndefinedThis(arg0Value_, arg1Value, arg2Value, functionUndefinedThis_language__);
                        }
                    }
                }
                {
                    JavaScriptLanguage bindUnboundFunction_language__ = null;
                    if ((JSGuards.isJSFunction(arg0Value_)) && (arg2Value) && (!(JSGuards.isUndefined(arg1Value))) && (!(JSGuards.isBoundJSFunction(arg0Value_)))) {
                        LanguageReference<JavaScriptLanguage> javaScriptLanguageReference__7 = this.javaScriptLanguageReference_;
                        if (javaScriptLanguageReference__7 == null) {
                            this.javaScriptLanguageReference_ = javaScriptLanguageReference__7 = super.lookupLanguageReference(JavaScriptLanguage.class);
                        }
                        bindUnboundFunction_language__ = javaScriptLanguageReference__7.get();
                        if ((!(ExportValueNode.isInteropCompletePromises(bindUnboundFunction_language__)) || !(JSFunction.isAsyncFunction(arg0Value_)))) {
                            this.state_ = state = state | 0b100 /* add-active doBindUnboundFunction(DynamicObject, Object, boolean, JavaScriptLanguage) */;
                            lock.unlock();
                            hasLock = false;
                            return ExportValueNode.doBindUnboundFunction(arg0Value_, arg1Value, arg2Value, bindUnboundFunction_language__);
                        }
                    }
                }
                {
                    JavaScriptLanguage boundFunction_language__ = null;
                    if ((JSGuards.isJSFunction(arg0Value_)) && (arg2Value) && (JSGuards.isBoundJSFunction(arg0Value_))) {
                        LanguageReference<JavaScriptLanguage> javaScriptLanguageReference__8 = this.javaScriptLanguageReference_;
                        if (javaScriptLanguageReference__8 == null) {
                            this.javaScriptLanguageReference_ = javaScriptLanguageReference__8 = super.lookupLanguageReference(JavaScriptLanguage.class);
                        }
                        boundFunction_language__ = javaScriptLanguageReference__8.get();
                        if ((!(ExportValueNode.isInteropCompletePromises(boundFunction_language__)) || !(JSFunction.isAsyncFunction(arg0Value_)))) {
                            this.state_ = state = state | 0b1000 /* add-active doBoundFunction(DynamicObject, Object, boolean, JavaScriptLanguage) */;
                            lock.unlock();
                            hasLock = false;
                            return ExportValueNode.doBoundFunction(arg0Value_, arg1Value, arg2Value, boundFunction_language__);
                        }
                    }
                }
                {
                    JavaScriptLanguage asyncFunction_language__ = null;
                    if ((JSGuards.isJSFunction(arg0Value_))) {
                        LanguageReference<JavaScriptLanguage> javaScriptLanguageReference__9 = this.javaScriptLanguageReference_;
                        if (javaScriptLanguageReference__9 == null) {
                            this.javaScriptLanguageReference_ = javaScriptLanguageReference__9 = super.lookupLanguageReference(JavaScriptLanguage.class);
                        }
                        asyncFunction_language__ = javaScriptLanguageReference__9.get();
                        if ((ExportValueNode.isInteropCompletePromises(asyncFunction_language__)) && (JSFunction.isAsyncFunction(arg0Value_))) {
                            this.state_ = state = state | 0b10000 /* add-active doAsyncFunction(DynamicObject, Object, boolean, JavaScriptLanguage) */;
                            lock.unlock();
                            hasLock = false;
                            return ExportValueNode.doAsyncFunction(arg0Value_, arg1Value, arg2Value, asyncFunction_language__);
                        }
                    }
                }
            }
            if (arg0Value instanceof SafeInteger) {
                SafeInteger arg0Value_ = (SafeInteger) arg0Value;
                this.state_ = state = state | 0b100000 /* add-active doSafeInteger(SafeInteger, Object, boolean) */;
                lock.unlock();
                hasLock = false;
                return ExportValueNode.doSafeInteger(arg0Value_, arg1Value, arg2Value);
            }
            if ((exclude) == 0 /* is-not-excluded doObject(DynamicObject, Object, boolean) */ && JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if ((!(JSGuards.isJSFunction(arg0Value_)))) {
                    this.state_ = state = state | 0b1000000 /* add-active doObject(DynamicObject, Object, boolean) */;
                    lock.unlock();
                    hasLock = false;
                    return ExportValueNode.doObject(arg0Value_, arg1Value, arg2Value);
                }
            }
            if (arg0Value instanceof Integer) {
                int arg0Value_ = (int) arg0Value;
                this.state_ = state = state | 0b10000000 /* add-active doInt(int, Object, boolean) */;
                lock.unlock();
                hasLock = false;
                return ExportValueNode.doInt(arg0Value_, arg1Value, arg2Value);
            }
            if (arg0Value instanceof Long) {
                long arg0Value_ = (long) arg0Value;
                this.state_ = state = state | 0b100000000 /* add-active doLong(long, Object, boolean) */;
                lock.unlock();
                hasLock = false;
                return ExportValueNode.doLong(arg0Value_, arg1Value, arg2Value);
            }
            {
                int doubleCast0;
                if ((doubleCast0 = JSTypesGen.specializeImplicitDouble(arg0Value)) != 0) {
                    double arg0Value_ = JSTypesGen.asImplicitDouble(doubleCast0, arg0Value);
                    state = (state | (doubleCast0 << 15) /* set-implicit-active 0:double */);
                    this.state_ = state = state | 0b1000000000 /* add-active doDouble(double, Object, boolean) */;
                    lock.unlock();
                    hasLock = false;
                    return ExportValueNode.doDouble(arg0Value_, arg1Value, arg2Value);
                }
            }
            if (arg0Value instanceof Boolean) {
                boolean arg0Value_ = (boolean) arg0Value;
                this.state_ = state = state | 0b10000000000 /* add-active doBoolean(boolean, Object, boolean) */;
                lock.unlock();
                hasLock = false;
                return ExportValueNode.doBoolean(arg0Value_, arg1Value, arg2Value);
            }
            if (arg0Value instanceof BigInt) {
                BigInt arg0Value_ = (BigInt) arg0Value;
                this.state_ = state = state | 0b100000000000 /* add-active doBigInt(BigInt, Object, boolean) */;
                lock.unlock();
                hasLock = false;
                return ExportValueNode.doBigInt(arg0Value_, arg1Value, arg2Value);
            }
            {
                int stringCast0;
                if ((stringCast0 = JSTypesGen.specializeImplicitString(arg0Value)) != 0) {
                    String arg0Value_ = JSTypesGen.asImplicitString(stringCast0, arg0Value);
                    state = (state | (stringCast0 << 19) /* set-implicit-active 0:String */);
                    this.state_ = state = state | 0b1000000000000 /* add-active doString(String, Object, boolean) */;
                    lock.unlock();
                    hasLock = false;
                    return ExportValueNode.doString(arg0Value_, arg1Value, arg2Value);
                }
            }
            if (arg0Value instanceof TruffleObject) {
                TruffleObject arg0Value_ = (TruffleObject) arg0Value;
                if ((!(JSGuards.isJSFunction(arg0Value_)))) {
                    this.exclude_ = exclude = exclude | 0b1 /* add-excluded doObject(DynamicObject, Object, boolean) */;
                    state = state & 0xffffffbf /* remove-active doObject(DynamicObject, Object, boolean) */;
                    this.state_ = state = state | 0b10000000000000 /* add-active doTruffleObject(TruffleObject, Object, boolean) */;
                    lock.unlock();
                    hasLock = false;
                    return ExportValueNode.doTruffleObject(arg0Value_, arg1Value, arg2Value);
                }
            }
            if ((!(JSGuards.isTruffleObject(arg1Value))) && (!(JSGuards.isString(arg1Value))) && (!(JSGuards.isBoolean(arg1Value))) && (!(JSGuards.isNumberDouble(arg1Value))) && (!(JSGuards.isNumberLong(arg1Value))) && (!(JSGuards.isNumberInteger(arg1Value)))) {
                this.state_ = state = state | 0b100000000000000 /* add-active doOther(Object, Object, boolean) */;
                lock.unlock();
                hasLock = false;
                return ExportValueNode.doOther(arg0Value, arg1Value, arg2Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {null, null, null}, arg0Value, arg1Value, arg2Value);
        } finally {
            if (hasLock) {
                lock.unlock();
            }
        }
    }

    @Override
    public NodeCost getCost() {
        int state = state_;
        if ((state & 0b111111111111111) == 0b0) {
            return NodeCost.UNINITIALIZED;
        } else if (((state & 0b111111111111111) & ((state & 0b111111111111111) - 1)) == 0 /* is-single-active  */) {
            return NodeCost.MONOMORPHIC;
        }
        return NodeCost.POLYMORPHIC;
    }

    @Override
    public Introspection getIntrospectionData() {
        Object[] data = new Object[16];
        Object[] s;
        data[0] = 0;
        int state = state_;
        int exclude = exclude_;
        s = new Object[3];
        s[0] = "doFunctionNoBind";
        if ((state & 0b1) != 0 /* is-active doFunctionNoBind(DynamicObject, Object, boolean, JavaScriptLanguage) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList());
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doFunctionUndefinedThis";
        if ((state & 0b10) != 0 /* is-active doFunctionUndefinedThis(DynamicObject, Object, boolean, JavaScriptLanguage) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList());
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doBindUnboundFunction";
        if ((state & 0b100) != 0 /* is-active doBindUnboundFunction(DynamicObject, Object, boolean, JavaScriptLanguage) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList());
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doBoundFunction";
        if ((state & 0b1000) != 0 /* is-active doBoundFunction(DynamicObject, Object, boolean, JavaScriptLanguage) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList());
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doAsyncFunction";
        if ((state & 0b10000) != 0 /* is-active doAsyncFunction(DynamicObject, Object, boolean, JavaScriptLanguage) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList());
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "doSafeInteger";
        if ((state & 0b100000) != 0 /* is-active doSafeInteger(SafeInteger, Object, boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "doObject";
        if ((state & 0b1000000) != 0 /* is-active doObject(DynamicObject, Object, boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else if (exclude != 0 /* is-excluded doObject(DynamicObject, Object, boolean) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        s = new Object[3];
        s[0] = "doInt";
        if ((state & 0b10000000) != 0 /* is-active doInt(int, Object, boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[8] = s;
        s = new Object[3];
        s[0] = "doLong";
        if ((state & 0b100000000) != 0 /* is-active doLong(long, Object, boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[9] = s;
        s = new Object[3];
        s[0] = "doDouble";
        if ((state & 0b1000000000) != 0 /* is-active doDouble(double, Object, boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[10] = s;
        s = new Object[3];
        s[0] = "doBoolean";
        if ((state & 0b10000000000) != 0 /* is-active doBoolean(boolean, Object, boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[11] = s;
        s = new Object[3];
        s[0] = "doBigInt";
        if ((state & 0b100000000000) != 0 /* is-active doBigInt(BigInt, Object, boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[12] = s;
        s = new Object[3];
        s[0] = "doString";
        if ((state & 0b1000000000000) != 0 /* is-active doString(String, Object, boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[13] = s;
        s = new Object[3];
        s[0] = "doTruffleObject";
        if ((state & 0b10000000000000) != 0 /* is-active doTruffleObject(TruffleObject, Object, boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[14] = s;
        s = new Object[3];
        s[0] = "doOther";
        if ((state & 0b100000000000000) != 0 /* is-active doOther(Object, Object, boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[15] = s;
        return Provider.create(data);
    }

    public static ExportValueNode create() {
        return new ExportValueNodeGen();
    }

    public static ExportValueNode getUncached() {
        return ExportValueNodeGen.UNCACHED;
    }

    @GeneratedBy(ExportValueNode.class)
    private static final class Uncached extends ExportValueNode {

        private final LanguageReference<JavaScriptLanguage> javaScriptLanguageReference_ = lookupLanguageReference(JavaScriptLanguage.class);

        @TruffleBoundary
        @Override
        public Object execute(Object arg0Value, Object arg1Value, boolean arg2Value) {
            if (JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if ((JSGuards.isJSFunction(arg0Value_)) && (!(arg2Value)) && (!(ExportValueNode.isInteropCompletePromises(this.javaScriptLanguageReference_.get())) || !(JSFunction.isAsyncFunction(arg0Value_)))) {
                    return ExportValueNode.doFunctionNoBind(arg0Value_, arg1Value, arg2Value, this.javaScriptLanguageReference_.get());
                }
                if ((JSGuards.isJSFunction(arg0Value_)) && (arg2Value) && (JSGuards.isUndefined(arg1Value)) && (!(ExportValueNode.isInteropCompletePromises(this.javaScriptLanguageReference_.get())) || !(JSFunction.isAsyncFunction(arg0Value_)))) {
                    return ExportValueNode.doFunctionUndefinedThis(arg0Value_, arg1Value, arg2Value, this.javaScriptLanguageReference_.get());
                }
                if ((JSGuards.isJSFunction(arg0Value_)) && (arg2Value) && (!(JSGuards.isUndefined(arg1Value))) && (!(JSGuards.isBoundJSFunction(arg0Value_))) && (!(ExportValueNode.isInteropCompletePromises(this.javaScriptLanguageReference_.get())) || !(JSFunction.isAsyncFunction(arg0Value_)))) {
                    return ExportValueNode.doBindUnboundFunction(arg0Value_, arg1Value, arg2Value, this.javaScriptLanguageReference_.get());
                }
                if ((JSGuards.isJSFunction(arg0Value_)) && (arg2Value) && (JSGuards.isBoundJSFunction(arg0Value_)) && (!(ExportValueNode.isInteropCompletePromises(this.javaScriptLanguageReference_.get())) || !(JSFunction.isAsyncFunction(arg0Value_)))) {
                    return ExportValueNode.doBoundFunction(arg0Value_, arg1Value, arg2Value, this.javaScriptLanguageReference_.get());
                }
                if ((JSGuards.isJSFunction(arg0Value_)) && (ExportValueNode.isInteropCompletePromises(this.javaScriptLanguageReference_.get())) && (JSFunction.isAsyncFunction(arg0Value_))) {
                    return ExportValueNode.doAsyncFunction(arg0Value_, arg1Value, arg2Value, this.javaScriptLanguageReference_.get());
                }
            }
            if (arg0Value instanceof SafeInteger) {
                SafeInteger arg0Value_ = (SafeInteger) arg0Value;
                return ExportValueNode.doSafeInteger(arg0Value_, arg1Value, arg2Value);
            }
            if (arg0Value instanceof Integer) {
                int arg0Value_ = (int) arg0Value;
                return ExportValueNode.doInt(arg0Value_, arg1Value, arg2Value);
            }
            if (arg0Value instanceof Long) {
                long arg0Value_ = (long) arg0Value;
                return ExportValueNode.doLong(arg0Value_, arg1Value, arg2Value);
            }
            if (JSTypesGen.isImplicitDouble(arg0Value)) {
                double arg0Value_ = JSTypesGen.asImplicitDouble(arg0Value);
                return ExportValueNode.doDouble(arg0Value_, arg1Value, arg2Value);
            }
            if (arg0Value instanceof Boolean) {
                boolean arg0Value_ = (boolean) arg0Value;
                return ExportValueNode.doBoolean(arg0Value_, arg1Value, arg2Value);
            }
            if (arg0Value instanceof BigInt) {
                BigInt arg0Value_ = (BigInt) arg0Value;
                return ExportValueNode.doBigInt(arg0Value_, arg1Value, arg2Value);
            }
            if (JSTypesGen.isImplicitString(arg0Value)) {
                String arg0Value_ = JSTypesGen.asImplicitString(arg0Value);
                return ExportValueNode.doString(arg0Value_, arg1Value, arg2Value);
            }
            if (arg0Value instanceof TruffleObject) {
                TruffleObject arg0Value_ = (TruffleObject) arg0Value;
                if ((!(JSGuards.isJSFunction(arg0Value_)))) {
                    return ExportValueNode.doTruffleObject(arg0Value_, arg1Value, arg2Value);
                }
            }
            if ((!(JSGuards.isTruffleObject(arg1Value))) && (!(JSGuards.isString(arg1Value))) && (!(JSGuards.isBoolean(arg1Value))) && (!(JSGuards.isNumberDouble(arg1Value))) && (!(JSGuards.isNumberLong(arg1Value))) && (!(JSGuards.isNumberInteger(arg1Value)))) {
                return ExportValueNode.doOther(arg0Value, arg1Value, arg2Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {null, null, null}, arg0Value, arg1Value, arg2Value);
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.MEGAMORPHIC;
        }

        @Override
        public boolean isAdoptable() {
            return false;
        }

    }
}
