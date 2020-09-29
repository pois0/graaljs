// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.TruffleLanguage.LanguageReference;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.EncapsulatingNodeReference;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.lang.JavaScriptLanguage;
import com.oracle.truffle.js.nodes.IntToLongTypeSystemGen;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.cast.JSToPropertyKeyNode;
import com.oracle.truffle.js.nodes.cast.JSToStringNode;
import com.oracle.truffle.js.nodes.interop.ForeignObjectPrototypeNode;
import com.oracle.truffle.js.runtime.JSRuntime;
import com.oracle.truffle.js.runtime.Symbol;
import com.oracle.truffle.js.runtime.array.ScriptArray;
import com.oracle.truffle.js.runtime.builtins.JSClass;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSHasPropertyNode.class)
@SuppressWarnings("unused")
public final class JSHasPropertyNodeGen extends JSHasPropertyNode implements Provider {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private LanguageReference<JavaScriptLanguage> javaScriptLanguageReference_;
    @CompilationFinal private ArrayLongCachedData arrayLongCached_cache;
    @Child private ObjectStringCachedData objectStringCached_cache;
    @CompilationFinal private String arrayStringCached_cachedName_;
    @Child private HasPropertyCacheNode arrayStringCached_hasPropertyNode_;
    @Child private ForeignObject0Data foreignObject0_cache;
    @Child private ForeignObject1Data foreignObject1_cache;
    @Child private JSToPropertyKeyNode objectObject_toPropertyKeyNode_;

    private JSHasPropertyNodeGen(boolean hasOwnProperty) {
        super(hasOwnProperty);
    }

    @ExplodeLoop
    @Override
    public boolean executeBoolean(Object arg0Value, Object arg1Value) {
        int state = state_;
        if ((state & 0b1111111) != 0 /* is-active arrayLongCached(DynamicObject, long, ScriptArray) || arrayLong(DynamicObject, long) || objectStringCached(DynamicObject, String, JSClass, String, HasPropertyCacheNode) || arrayStringCached(DynamicObject, String, String, HasPropertyCacheNode) || objectOrArrayString(DynamicObject, String) || objectSymbol(DynamicObject, Symbol) || objectLong(DynamicObject, long) */ && arg0Value instanceof DynamicObject) {
            DynamicObject arg0Value_ = (DynamicObject) arg0Value;
            if ((state & 0b11) != 0 /* is-active arrayLongCached(DynamicObject, long, ScriptArray) || arrayLong(DynamicObject, long) */ && IntToLongTypeSystemGen.isImplicitLong((state & 0b110000000000) >>> 10 /* extract-implicit-active 1:long */, arg1Value)) {
                long arg1Value_ = IntToLongTypeSystemGen.asImplicitLong((state & 0b110000000000) >>> 10 /* extract-implicit-active 1:long */, arg1Value);
                if ((state & 0b1) != 0 /* is-active arrayLongCached(DynamicObject, long, ScriptArray) */ && (JSGuards.isJSFastArray(arg0Value_)) && (JSRuntime.isArrayIndex(arg1Value_))) {
                    ArrayLongCachedData s1_ = this.arrayLongCached_cache;
                    while (s1_ != null) {
                        if ((s1_.cachedArrayType_.isInstance(JSHasPropertyNode.getArrayType(arg0Value_)))) {
                            return arrayLongCached(arg0Value_, arg1Value_, s1_.cachedArrayType_);
                        }
                        s1_ = s1_.next_;
                    }
                }
                if ((state & 0b10) != 0 /* is-active arrayLong(DynamicObject, long) */) {
                    if ((JSGuards.isJSFastArray(arg0Value_)) && (JSRuntime.isArrayIndex(arg1Value_))) {
                        return arrayLong(arg0Value_, arg1Value_);
                    }
                }
            }
            if ((state & 0b11100) != 0 /* is-active objectStringCached(DynamicObject, String, JSClass, String, HasPropertyCacheNode) || arrayStringCached(DynamicObject, String, String, HasPropertyCacheNode) || objectOrArrayString(DynamicObject, String) */ && arg1Value instanceof String) {
                String arg1Value_ = (String) arg1Value;
                if ((state & 0b100) != 0 /* is-active objectStringCached(DynamicObject, String, JSClass, String, HasPropertyCacheNode) */) {
                    ObjectStringCachedData s3_ = this.objectStringCached_cache;
                    if (s3_ != null) {
                        assert (s3_.cachedObjectType_ != null);
                        if ((s3_.cachedObjectType_.isInstance(arg0Value_)) && (s3_.cachedName_.equals(arg1Value_))) {
                            return objectStringCached(arg0Value_, arg1Value_, s3_.cachedObjectType_, s3_.cachedName_, s3_.hasPropertyNode_);
                        }
                    }
                }
                if ((state & 0b1000) != 0 /* is-active arrayStringCached(DynamicObject, String, String, HasPropertyCacheNode) */) {
                    if ((JSGuards.isJSArray(arg0Value_))) {
                        assert (!(JSRuntime.isArrayIndex(this.arrayStringCached_cachedName_)));
                        if ((this.arrayStringCached_cachedName_.equals(arg1Value_))) {
                            return arrayStringCached(arg0Value_, arg1Value_, this.arrayStringCached_cachedName_, this.arrayStringCached_hasPropertyNode_);
                        }
                    }
                }
                if ((state & 0b10000) != 0 /* is-active objectOrArrayString(DynamicObject, String) */) {
                    if ((JSGuards.isJSDynamicObject(arg0Value_))) {
                        return objectOrArrayString(arg0Value_, arg1Value_);
                    }
                }
            }
            if ((state & 0b100000) != 0 /* is-active objectSymbol(DynamicObject, Symbol) */ && arg1Value instanceof Symbol) {
                Symbol arg1Value_ = (Symbol) arg1Value;
                if ((JSGuards.isJSDynamicObject(arg0Value_))) {
                    return objectSymbol(arg0Value_, arg1Value_);
                }
            }
            if ((state & 0b1000000) != 0 /* is-active objectLong(DynamicObject, long) */ && IntToLongTypeSystemGen.isImplicitLong((state & 0b110000000000) >>> 10 /* extract-implicit-active 1:long */, arg1Value)) {
                long arg1Value_ = IntToLongTypeSystemGen.asImplicitLong((state & 0b110000000000) >>> 10 /* extract-implicit-active 1:long */, arg1Value);
                if ((JSGuards.isJSDynamicObject(arg0Value_)) && (!(JSGuards.isJSFastArray(arg0Value_)))) {
                    return objectLong(arg0Value_, arg1Value_);
                }
            }
        }
        if ((state & 0b1110000000) != 0 /* is-active foreignObject(Object, Object, InteropLibrary, JSToStringNode, ForeignObjectPrototypeNode, JSHasPropertyNode, LanguageReference<JavaScriptLanguage>) || foreignObject(Object, Object, InteropLibrary, JSToStringNode, ForeignObjectPrototypeNode, JSHasPropertyNode, LanguageReference<JavaScriptLanguage>) || objectObject(DynamicObject, Object, JSToPropertyKeyNode) */) {
            if ((state & 0b110000000) != 0 /* is-active foreignObject(Object, Object, InteropLibrary, JSToStringNode, ForeignObjectPrototypeNode, JSHasPropertyNode, LanguageReference<JavaScriptLanguage>) || foreignObject(Object, Object, InteropLibrary, JSToStringNode, ForeignObjectPrototypeNode, JSHasPropertyNode, LanguageReference<JavaScriptLanguage>) */) {
                if ((state & 0b10000000) != 0 /* is-active foreignObject(Object, Object, InteropLibrary, JSToStringNode, ForeignObjectPrototypeNode, JSHasPropertyNode, LanguageReference<JavaScriptLanguage>) */) {
                    ForeignObject0Data s8_ = this.foreignObject0_cache;
                    while (s8_ != null) {
                        if ((s8_.interop_.accepts(arg0Value)) && (JSRuntime.isForeignObject(arg0Value))) {
                            LanguageReference<JavaScriptLanguage> javaScriptLanguageReference__ = this.javaScriptLanguageReference_;
                            LanguageReference<JavaScriptLanguage> languageRef__ = javaScriptLanguageReference__;
                            return foreignObject(arg0Value, arg1Value, s8_.interop_, s8_.toStringNode_, s8_.foreignObjectPrototypeNode_, s8_.hasInPrototype_, languageRef__);
                        }
                        s8_ = s8_.next_;
                    }
                }
                if ((state & 0b100000000) != 0 /* is-active foreignObject(Object, Object, InteropLibrary, JSToStringNode, ForeignObjectPrototypeNode, JSHasPropertyNode, LanguageReference<JavaScriptLanguage>) */) {
                    ForeignObject1Data s9_ = this.foreignObject1_cache;
                    if (s9_ != null) {
                        if ((JSRuntime.isForeignObject(arg0Value))) {
                            return this.foreignObject1Boundary(state, s9_, arg0Value, arg1Value);
                        }
                    }
                }
            }
            if ((state & 0b1000000000) != 0 /* is-active objectObject(DynamicObject, Object, JSToPropertyKeyNode) */ && arg0Value instanceof DynamicObject) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if ((JSGuards.isJSDynamicObject(arg0Value_))) {
                    return objectObject(arg0Value_, arg1Value, this.objectObject_toPropertyKeyNode_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value);
    }

    @TruffleBoundary
    private boolean foreignObject1Boundary(int state, ForeignObject1Data s9_, Object arg0Value, Object arg1Value) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary interop__ = (INTEROP_LIBRARY_.getUncached(arg0Value));
                LanguageReference<JavaScriptLanguage> javaScriptLanguageReference__1 = this.javaScriptLanguageReference_;
                LanguageReference<JavaScriptLanguage> languageRef__ = javaScriptLanguageReference__1;
                return foreignObject(arg0Value, arg1Value, interop__, s9_.toStringNode_, s9_.foreignObjectPrototypeNode_, s9_.hasInPrototype_, languageRef__);
            }
        } finally {
            encapsulating_.set(prev_);
        }
    }

    @ExplodeLoop
    @Override
    public boolean executeBoolean(Object arg0Value, long arg1Value) {
        int state = state_;
        if ((state & 0b1000011) != 0 /* is-active arrayLongCached(DynamicObject, long, ScriptArray) || arrayLong(DynamicObject, long) || objectLong(DynamicObject, long) */ && arg0Value instanceof DynamicObject) {
            DynamicObject arg0Value_ = (DynamicObject) arg0Value;
            if (IntToLongTypeSystemGen.isImplicitLong((state & 0b110000000000) >>> 10 /* extract-implicit-active 1:long */, arg1Value)) {
                long arg1Value_ = IntToLongTypeSystemGen.asImplicitLong((state & 0b110000000000) >>> 10 /* extract-implicit-active 1:long */, arg1Value);
                if ((state & 0b1) != 0 /* is-active arrayLongCached(DynamicObject, long, ScriptArray) */ && (JSGuards.isJSFastArray(arg0Value_)) && (JSRuntime.isArrayIndex(arg1Value_))) {
                    ArrayLongCachedData s1_ = this.arrayLongCached_cache;
                    while (s1_ != null) {
                        if ((s1_.cachedArrayType_.isInstance(JSHasPropertyNode.getArrayType(arg0Value_)))) {
                            return arrayLongCached(arg0Value_, arg1Value_, s1_.cachedArrayType_);
                        }
                        s1_ = s1_.next_;
                    }
                }
                if ((state & 0b10) != 0 /* is-active arrayLong(DynamicObject, long) */) {
                    if ((JSGuards.isJSFastArray(arg0Value_)) && (JSRuntime.isArrayIndex(arg1Value_))) {
                        return arrayLong(arg0Value_, arg1Value_);
                    }
                }
                if ((state & 0b1000000) != 0 /* is-active objectLong(DynamicObject, long) */) {
                    if ((JSGuards.isJSDynamicObject(arg0Value_)) && (!(JSGuards.isJSFastArray(arg0Value_)))) {
                        return objectLong(arg0Value_, arg1Value_);
                    }
                }
            }
        }
        if ((state & 0b1110000000) != 0 /* is-active foreignObject(Object, Object, InteropLibrary, JSToStringNode, ForeignObjectPrototypeNode, JSHasPropertyNode, LanguageReference<JavaScriptLanguage>) || foreignObject(Object, Object, InteropLibrary, JSToStringNode, ForeignObjectPrototypeNode, JSHasPropertyNode, LanguageReference<JavaScriptLanguage>) || objectObject(DynamicObject, Object, JSToPropertyKeyNode) */) {
            if ((state & 0b110000000) != 0 /* is-active foreignObject(Object, Object, InteropLibrary, JSToStringNode, ForeignObjectPrototypeNode, JSHasPropertyNode, LanguageReference<JavaScriptLanguage>) || foreignObject(Object, Object, InteropLibrary, JSToStringNode, ForeignObjectPrototypeNode, JSHasPropertyNode, LanguageReference<JavaScriptLanguage>) */) {
                if ((state & 0b10000000) != 0 /* is-active foreignObject(Object, Object, InteropLibrary, JSToStringNode, ForeignObjectPrototypeNode, JSHasPropertyNode, LanguageReference<JavaScriptLanguage>) */) {
                    ForeignObject0Data s8_ = this.foreignObject0_cache;
                    while (s8_ != null) {
                        if ((s8_.interop_.accepts(arg0Value)) && (JSRuntime.isForeignObject(arg0Value))) {
                            LanguageReference<JavaScriptLanguage> javaScriptLanguageReference__2 = this.javaScriptLanguageReference_;
                            LanguageReference<JavaScriptLanguage> languageRef__ = javaScriptLanguageReference__2;
                            return foreignObject(arg0Value, arg1Value, s8_.interop_, s8_.toStringNode_, s8_.foreignObjectPrototypeNode_, s8_.hasInPrototype_, languageRef__);
                        }
                        s8_ = s8_.next_;
                    }
                }
                if ((state & 0b100000000) != 0 /* is-active foreignObject(Object, Object, InteropLibrary, JSToStringNode, ForeignObjectPrototypeNode, JSHasPropertyNode, LanguageReference<JavaScriptLanguage>) */) {
                    ForeignObject1Data s9_ = this.foreignObject1_cache;
                    if (s9_ != null) {
                        if ((JSRuntime.isForeignObject(arg0Value))) {
                            return this.foreignObject1Boundary0(state, s9_, arg0Value, arg1Value);
                        }
                    }
                }
            }
            if ((state & 0b1000000000) != 0 /* is-active objectObject(DynamicObject, Object, JSToPropertyKeyNode) */ && arg0Value instanceof DynamicObject) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if ((JSGuards.isJSDynamicObject(arg0Value_))) {
                    return objectObject(arg0Value_, arg1Value, this.objectObject_toPropertyKeyNode_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value);
    }

    @TruffleBoundary
    private boolean foreignObject1Boundary0(int state, ForeignObject1Data s9_, Object arg0Value, long arg1Value) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary interop__ = (INTEROP_LIBRARY_.getUncached(arg0Value));
                LanguageReference<JavaScriptLanguage> javaScriptLanguageReference__3 = this.javaScriptLanguageReference_;
                LanguageReference<JavaScriptLanguage> languageRef__ = javaScriptLanguageReference__3;
                return foreignObject(arg0Value, arg1Value, interop__, s9_.toStringNode_, s9_.foreignObjectPrototypeNode_, s9_.hasInPrototype_, languageRef__);
            }
        } finally {
            encapsulating_.set(prev_);
        }
    }

    private boolean executeAndSpecialize(Object arg0Value, Object arg1Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        int exclude = exclude_;
        int oldState = (state & 0b1111111111);
        try {
            if (arg0Value instanceof DynamicObject) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                {
                    int longCast1;
                    if ((longCast1 = IntToLongTypeSystemGen.specializeImplicitLong(arg1Value)) != 0) {
                        long arg1Value_ = IntToLongTypeSystemGen.asImplicitLong(longCast1, arg1Value);
                        if (((exclude & 0b1)) == 0 /* is-not-excluded arrayLongCached(DynamicObject, long, ScriptArray) */ && (JSGuards.isJSFastArray(arg0Value_)) && (JSRuntime.isArrayIndex(arg1Value_))) {
                            int count1_ = 0;
                            ArrayLongCachedData s1_ = this.arrayLongCached_cache;
                            if ((state & 0b1) != 0 /* is-active arrayLongCached(DynamicObject, long, ScriptArray) */) {
                                while (s1_ != null) {
                                    if ((s1_.cachedArrayType_.isInstance(JSHasPropertyNode.getArrayType(arg0Value_)))) {
                                        break;
                                    }
                                    s1_ = s1_.next_;
                                    count1_++;
                                }
                            }
                            if (s1_ == null) {
                                {
                                    ScriptArray cachedArrayType__ = (JSHasPropertyNode.getArrayType(arg0Value_));
                                    if ((cachedArrayType__.isInstance(JSHasPropertyNode.getArrayType(arg0Value_))) && count1_ < (JSHasPropertyNode.MAX_ARRAY_TYPES)) {
                                        s1_ = new ArrayLongCachedData(arrayLongCached_cache);
                                        s1_.cachedArrayType_ = cachedArrayType__;
                                        this.arrayLongCached_cache = s1_;
                                        state = (state | (longCast1 << 10) /* set-implicit-active 1:long */);
                                        this.state_ = state = state | 0b1 /* add-active arrayLongCached(DynamicObject, long, ScriptArray) */;
                                    }
                                }
                            } else {
                                state = (state | (longCast1 << 10) /* set-implicit-active 1:long */);
                                this.state_ = state = state | 0b1 /* add-active arrayLongCached(DynamicObject, long, ScriptArray) */;
                            }
                            if (s1_ != null) {
                                lock.unlock();
                                hasLock = false;
                                return arrayLongCached(arg0Value_, arg1Value_, s1_.cachedArrayType_);
                            }
                        }
                        if ((JSGuards.isJSFastArray(arg0Value_)) && (JSRuntime.isArrayIndex(arg1Value_))) {
                            this.exclude_ = exclude = exclude | 0b1 /* add-excluded arrayLongCached(DynamicObject, long, ScriptArray) */;
                            this.arrayLongCached_cache = null;
                            state = state & 0xfffffffe /* remove-active arrayLongCached(DynamicObject, long, ScriptArray) */;
                            state = (state | (longCast1 << 10) /* set-implicit-active 1:long */);
                            this.state_ = state = state | 0b10 /* add-active arrayLong(DynamicObject, long) */;
                            lock.unlock();
                            hasLock = false;
                            return arrayLong(arg0Value_, arg1Value_);
                        }
                    }
                }
                if (arg1Value instanceof String) {
                    String arg1Value_ = (String) arg1Value;
                    if (((exclude & 0b10)) == 0 /* is-not-excluded objectStringCached(DynamicObject, String, JSClass, String, HasPropertyCacheNode) */) {
                        ObjectStringCachedData s3_ = this.objectStringCached_cache;
                        boolean ObjectStringCached_duplicateFound_ = false;
                        if ((state & 0b100) != 0 /* is-active objectStringCached(DynamicObject, String, JSClass, String, HasPropertyCacheNode) */) {
                            assert (s3_.cachedObjectType_ != null);
                            if ((s3_.cachedObjectType_.isInstance(arg0Value_)) && (s3_.cachedName_.equals(arg1Value_))) {
                                ObjectStringCached_duplicateFound_ = true;
                            }
                        }
                        if (!ObjectStringCached_duplicateFound_) {
                            {
                                JSClass cachedObjectType__ = (JSHasPropertyNode.getCacheableObjectType(arg0Value_));
                                if ((cachedObjectType__ != null) && (cachedObjectType__.isInstance(arg0Value_))) {
                                    // assert (s3_.cachedName_.equals(arg1Value_));
                                    if (((state & 0b100)) == 0 /* is-not-active objectStringCached(DynamicObject, String, JSClass, String, HasPropertyCacheNode) */) {
                                        s3_ = super.insert(new ObjectStringCachedData());
                                        s3_.cachedObjectType_ = cachedObjectType__;
                                        s3_.cachedName_ = (arg1Value_);
                                        s3_.hasPropertyNode_ = s3_.insertAccessor((getCachedPropertyGetter(arg0Value_, arg1Value_)));
                                        this.objectStringCached_cache = s3_;
                                        this.state_ = state = state | 0b100 /* add-active objectStringCached(DynamicObject, String, JSClass, String, HasPropertyCacheNode) */;
                                        ObjectStringCached_duplicateFound_ = true;
                                    }
                                }
                            }
                        }
                        if (ObjectStringCached_duplicateFound_) {
                            lock.unlock();
                            hasLock = false;
                            return objectStringCached(arg0Value_, arg1Value_, s3_.cachedObjectType_, s3_.cachedName_, s3_.hasPropertyNode_);
                        }
                    }
                    if (((exclude & 0b100)) == 0 /* is-not-excluded arrayStringCached(DynamicObject, String, String, HasPropertyCacheNode) */) {
                        boolean ArrayStringCached_duplicateFound_ = false;
                        if ((state & 0b1000) != 0 /* is-active arrayStringCached(DynamicObject, String, String, HasPropertyCacheNode) */) {
                            if ((JSGuards.isJSArray(arg0Value_))) {
                                assert (!(JSRuntime.isArrayIndex(this.arrayStringCached_cachedName_)));
                                if ((this.arrayStringCached_cachedName_.equals(arg1Value_))) {
                                    ArrayStringCached_duplicateFound_ = true;
                                }
                            }
                        }
                        if (!ArrayStringCached_duplicateFound_) {
                            if ((JSGuards.isJSArray(arg0Value_))) {
                                String arrayStringCached_cachedName__ = (arg1Value_);
                                if ((!(JSRuntime.isArrayIndex(arrayStringCached_cachedName__)))) {
                                    // assert (arrayStringCached_cachedName__.equals(arg1Value_));
                                    if (((state & 0b1000)) == 0 /* is-not-active arrayStringCached(DynamicObject, String, String, HasPropertyCacheNode) */) {
                                        this.arrayStringCached_cachedName_ = arrayStringCached_cachedName__;
                                        this.arrayStringCached_hasPropertyNode_ = super.insert((getCachedPropertyGetter(arg0Value_, arg1Value_)));
                                        this.state_ = state = state | 0b1000 /* add-active arrayStringCached(DynamicObject, String, String, HasPropertyCacheNode) */;
                                        ArrayStringCached_duplicateFound_ = true;
                                    }
                                }
                            }
                        }
                        if (ArrayStringCached_duplicateFound_) {
                            lock.unlock();
                            hasLock = false;
                            return arrayStringCached(arg0Value_, arg1Value_, this.arrayStringCached_cachedName_, this.arrayStringCached_hasPropertyNode_);
                        }
                    }
                    if ((JSGuards.isJSDynamicObject(arg0Value_))) {
                        this.exclude_ = exclude = exclude | 0b110 /* add-excluded objectStringCached(DynamicObject, String, JSClass, String, HasPropertyCacheNode), arrayStringCached(DynamicObject, String, String, HasPropertyCacheNode) */;
                        this.objectStringCached_cache = null;
                        state = state & 0xfffffff3 /* remove-active objectStringCached(DynamicObject, String, JSClass, String, HasPropertyCacheNode), arrayStringCached(DynamicObject, String, String, HasPropertyCacheNode) */;
                        this.state_ = state = state | 0b10000 /* add-active objectOrArrayString(DynamicObject, String) */;
                        lock.unlock();
                        hasLock = false;
                        return objectOrArrayString(arg0Value_, arg1Value_);
                    }
                }
                if (arg1Value instanceof Symbol) {
                    Symbol arg1Value_ = (Symbol) arg1Value;
                    if ((JSGuards.isJSDynamicObject(arg0Value_))) {
                        this.state_ = state = state | 0b100000 /* add-active objectSymbol(DynamicObject, Symbol) */;
                        lock.unlock();
                        hasLock = false;
                        return objectSymbol(arg0Value_, arg1Value_);
                    }
                }
                {
                    int longCast1;
                    if ((longCast1 = IntToLongTypeSystemGen.specializeImplicitLong(arg1Value)) != 0) {
                        long arg1Value_ = IntToLongTypeSystemGen.asImplicitLong(longCast1, arg1Value);
                        if ((JSGuards.isJSDynamicObject(arg0Value_)) && (!(JSGuards.isJSFastArray(arg0Value_)))) {
                            state = (state | (longCast1 << 10) /* set-implicit-active 1:long */);
                            this.state_ = state = state | 0b1000000 /* add-active objectLong(DynamicObject, long) */;
                            lock.unlock();
                            hasLock = false;
                            return objectLong(arg0Value_, arg1Value_);
                        }
                    }
                }
            }
            {
                LanguageReference<JavaScriptLanguage> languageRef__ = null;
                if (((exclude & 0b1000)) == 0 /* is-not-excluded foreignObject(Object, Object, InteropLibrary, JSToStringNode, ForeignObjectPrototypeNode, JSHasPropertyNode, LanguageReference<JavaScriptLanguage>) */) {
                    int count8_ = 0;
                    ForeignObject0Data s8_ = this.foreignObject0_cache;
                    if ((state & 0b10000000) != 0 /* is-active foreignObject(Object, Object, InteropLibrary, JSToStringNode, ForeignObjectPrototypeNode, JSHasPropertyNode, LanguageReference<JavaScriptLanguage>) */) {
                        while (s8_ != null) {
                            if ((s8_.interop_.accepts(arg0Value)) && (JSRuntime.isForeignObject(arg0Value))) {
                                LanguageReference<JavaScriptLanguage> javaScriptLanguageReference__4 = this.javaScriptLanguageReference_;
                                if (javaScriptLanguageReference__4 == null) {
                                    this.javaScriptLanguageReference_ = javaScriptLanguageReference__4 = super.lookupLanguageReference(JavaScriptLanguage.class);
                                }
                                languageRef__ = javaScriptLanguageReference__4;
                                break;
                            }
                            s8_ = s8_.next_;
                            count8_++;
                        }
                    }
                    if (s8_ == null) {
                        if ((JSRuntime.isForeignObject(arg0Value)) && count8_ < (3)) {
                            // assert (s8_.interop_.accepts(arg0Value));
                            s8_ = super.insert(new ForeignObject0Data(foreignObject0_cache));
                            s8_.interop_ = s8_.insertAccessor((INTEROP_LIBRARY_.create(arg0Value)));
                            s8_.toStringNode_ = s8_.insertAccessor((JSToStringNode.create()));
                            s8_.foreignObjectPrototypeNode_ = s8_.insertAccessor((ForeignObjectPrototypeNode.create()));
                            s8_.hasInPrototype_ = s8_.insertAccessor((JSHasPropertyNode.create()));
                            LanguageReference<JavaScriptLanguage> javaScriptLanguageReference__5 = this.javaScriptLanguageReference_;
                            if (javaScriptLanguageReference__5 == null) {
                                this.javaScriptLanguageReference_ = javaScriptLanguageReference__5 = super.lookupLanguageReference(JavaScriptLanguage.class);
                            }
                            languageRef__ = javaScriptLanguageReference__5;
                            this.foreignObject0_cache = s8_;
                            this.state_ = state = state | 0b10000000 /* add-active foreignObject(Object, Object, InteropLibrary, JSToStringNode, ForeignObjectPrototypeNode, JSHasPropertyNode, LanguageReference<JavaScriptLanguage>) */;
                        }
                    }
                    if (s8_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return foreignObject(arg0Value, arg1Value, s8_.interop_, s8_.toStringNode_, s8_.foreignObjectPrototypeNode_, s8_.hasInPrototype_, languageRef__);
                    }
                }
            }
            {
                LanguageReference<JavaScriptLanguage> languageRef__ = null;
                InteropLibrary interop__ = null;
                {
                    EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                    Node prev_ = encapsulating_.set(this);
                    try {
                        if ((JSRuntime.isForeignObject(arg0Value))) {
                            ForeignObject1Data s9_ = super.insert(new ForeignObject1Data());
                            interop__ = (INTEROP_LIBRARY_.getUncached(arg0Value));
                            s9_.toStringNode_ = s9_.insertAccessor((JSToStringNode.create()));
                            s9_.foreignObjectPrototypeNode_ = s9_.insertAccessor((ForeignObjectPrototypeNode.create()));
                            s9_.hasInPrototype_ = s9_.insertAccessor((JSHasPropertyNode.create()));
                            LanguageReference<JavaScriptLanguage> javaScriptLanguageReference__6 = this.javaScriptLanguageReference_;
                            if (javaScriptLanguageReference__6 == null) {
                                this.javaScriptLanguageReference_ = javaScriptLanguageReference__6 = super.lookupLanguageReference(JavaScriptLanguage.class);
                            }
                            languageRef__ = javaScriptLanguageReference__6;
                            this.foreignObject1_cache = s9_;
                            this.exclude_ = exclude = exclude | 0b1000 /* add-excluded foreignObject(Object, Object, InteropLibrary, JSToStringNode, ForeignObjectPrototypeNode, JSHasPropertyNode, LanguageReference<JavaScriptLanguage>) */;
                            this.foreignObject0_cache = null;
                            state = state & 0xffffff7f /* remove-active foreignObject(Object, Object, InteropLibrary, JSToStringNode, ForeignObjectPrototypeNode, JSHasPropertyNode, LanguageReference<JavaScriptLanguage>) */;
                            this.state_ = state = state | 0b100000000 /* add-active foreignObject(Object, Object, InteropLibrary, JSToStringNode, ForeignObjectPrototypeNode, JSHasPropertyNode, LanguageReference<JavaScriptLanguage>) */;
                            lock.unlock();
                            hasLock = false;
                            return foreignObject(arg0Value, arg1Value, interop__, s9_.toStringNode_, s9_.foreignObjectPrototypeNode_, s9_.hasInPrototype_, languageRef__);
                        }
                    } finally {
                        encapsulating_.set(prev_);
                    }
                }
            }
            if (arg0Value instanceof DynamicObject) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if ((JSGuards.isJSDynamicObject(arg0Value_))) {
                    this.objectObject_toPropertyKeyNode_ = super.insert((JSToPropertyKeyNode.create()));
                    this.state_ = state = state | 0b1000000000 /* add-active objectObject(DynamicObject, Object, JSToPropertyKeyNode) */;
                    lock.unlock();
                    hasLock = false;
                    return objectObject(arg0Value_, arg1Value, this.objectObject_toPropertyKeyNode_);
                }
            }
            throw new UnsupportedSpecializationException(this, new Node[] {null, null}, arg0Value, arg1Value);
        } finally {
            if (oldState != 0) {
                checkForPolymorphicSpecialize(oldState);
            }
            if (hasLock) {
                lock.unlock();
            }
        }
    }

    private void checkForPolymorphicSpecialize(int oldState) {
        int megamorphicMask = 0b1000110000;
        int megamorphicState = (this.state_ & 0b1000110000);
        if ((((oldState & megamorphicMask) == 0) && (megamorphicState != 0))) {
            this.reportPolymorphicSpecialize();
        }
    }

    @Override
    public NodeCost getCost() {
        int state = state_;
        if ((state & 0b1111111111) == 0b0) {
            return NodeCost.UNINITIALIZED;
        } else if (((state & 0b1111111111) & ((state & 0b1111111111) - 1)) == 0 /* is-single-active  */) {
            ArrayLongCachedData s1_ = this.arrayLongCached_cache;
            ForeignObject0Data s8_ = this.foreignObject0_cache;
            if ((s1_ == null || s1_.next_ == null) && (s8_ == null || s8_.next_ == null)) {
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
        s[0] = "arrayLongCached";
        if ((state & 0b1) != 0 /* is-active arrayLongCached(DynamicObject, long, ScriptArray) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            ArrayLongCachedData s1_ = this.arrayLongCached_cache;
            while (s1_ != null) {
                cached.add(Arrays.asList(s1_.cachedArrayType_));
                s1_ = s1_.next_;
            }
            s[2] = cached;
        } else if ((exclude & 0b1) != 0 /* is-excluded arrayLongCached(DynamicObject, long, ScriptArray) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "arrayLong";
        if ((state & 0b10) != 0 /* is-active arrayLong(DynamicObject, long) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "objectStringCached";
        if ((state & 0b100) != 0 /* is-active objectStringCached(DynamicObject, String, JSClass, String, HasPropertyCacheNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            ObjectStringCachedData s3_ = this.objectStringCached_cache;
            if (s3_ != null) {
                cached.add(Arrays.asList(s3_.cachedObjectType_, s3_.cachedName_, s3_.hasPropertyNode_));
            }
            s[2] = cached;
        } else if ((exclude & 0b10) != 0 /* is-excluded objectStringCached(DynamicObject, String, JSClass, String, HasPropertyCacheNode) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "arrayStringCached";
        if ((state & 0b1000) != 0 /* is-active arrayStringCached(DynamicObject, String, String, HasPropertyCacheNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.arrayStringCached_cachedName_, this.arrayStringCached_hasPropertyNode_));
            s[2] = cached;
        } else if ((exclude & 0b100) != 0 /* is-excluded arrayStringCached(DynamicObject, String, String, HasPropertyCacheNode) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "objectOrArrayString";
        if ((state & 0b10000) != 0 /* is-active objectOrArrayString(DynamicObject, String) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        s = new Object[3];
        s[0] = "objectSymbol";
        if ((state & 0b100000) != 0 /* is-active objectSymbol(DynamicObject, Symbol) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[6] = s;
        s = new Object[3];
        s[0] = "objectLong";
        if ((state & 0b1000000) != 0 /* is-active objectLong(DynamicObject, long) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[7] = s;
        s = new Object[3];
        s[0] = "foreignObject";
        if ((state & 0b10000000) != 0 /* is-active foreignObject(Object, Object, InteropLibrary, JSToStringNode, ForeignObjectPrototypeNode, JSHasPropertyNode, LanguageReference<JavaScriptLanguage>) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            ForeignObject0Data s8_ = this.foreignObject0_cache;
            while (s8_ != null) {
                cached.add(Arrays.asList(s8_.interop_, s8_.toStringNode_, s8_.foreignObjectPrototypeNode_, s8_.hasInPrototype_));
                s8_ = s8_.next_;
            }
            s[2] = cached;
        } else if ((exclude & 0b1000) != 0 /* is-excluded foreignObject(Object, Object, InteropLibrary, JSToStringNode, ForeignObjectPrototypeNode, JSHasPropertyNode, LanguageReference<JavaScriptLanguage>) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[8] = s;
        s = new Object[3];
        s[0] = "foreignObject";
        if ((state & 0b100000000) != 0 /* is-active foreignObject(Object, Object, InteropLibrary, JSToStringNode, ForeignObjectPrototypeNode, JSHasPropertyNode, LanguageReference<JavaScriptLanguage>) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            ForeignObject1Data s9_ = this.foreignObject1_cache;
            if (s9_ != null) {
                cached.add(Arrays.asList(s9_.toStringNode_, s9_.foreignObjectPrototypeNode_, s9_.hasInPrototype_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[9] = s;
        s = new Object[3];
        s[0] = "objectObject";
        if ((state & 0b1000000000) != 0 /* is-active objectObject(DynamicObject, Object, JSToPropertyKeyNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            cached.add(Arrays.asList(this.objectObject_toPropertyKeyNode_));
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[10] = s;
        return Provider.create(data);
    }

    public static JSHasPropertyNode create(boolean hasOwnProperty) {
        return new JSHasPropertyNodeGen(hasOwnProperty);
    }

    @GeneratedBy(JSHasPropertyNode.class)
    private static final class ArrayLongCachedData {

        @CompilationFinal ArrayLongCachedData next_;
        @CompilationFinal ScriptArray cachedArrayType_;

        ArrayLongCachedData(ArrayLongCachedData next_) {
            this.next_ = next_;
        }

    }
    @GeneratedBy(JSHasPropertyNode.class)
    private static final class ObjectStringCachedData extends Node {

        @CompilationFinal JSClass cachedObjectType_;
        @CompilationFinal String cachedName_;
        @Child HasPropertyCacheNode hasPropertyNode_;

        ObjectStringCachedData() {
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.NONE;
        }

        <T extends Node> T insertAccessor(T node) {
            return super.insert(node);
        }

    }
    @GeneratedBy(JSHasPropertyNode.class)
    private static final class ForeignObject0Data extends Node {

        @Child ForeignObject0Data next_;
        @Child InteropLibrary interop_;
        @Child JSToStringNode toStringNode_;
        @Child ForeignObjectPrototypeNode foreignObjectPrototypeNode_;
        @Child JSHasPropertyNode hasInPrototype_;

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
    @GeneratedBy(JSHasPropertyNode.class)
    private static final class ForeignObject1Data extends Node {

        @Child JSToStringNode toStringNode_;
        @Child ForeignObjectPrototypeNode foreignObjectPrototypeNode_;
        @Child JSHasPropertyNode hasInPrototype_;

        ForeignObject1Data() {
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
