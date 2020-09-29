// CheckStyle: start generated
package com.oracle.truffle.js.nodes.intl;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.access.JSHasPropertyNode;
import com.oracle.truffle.js.nodes.array.JSGetLengthNode;
import com.oracle.truffle.js.nodes.cast.JSToObjectNode;
import com.oracle.truffle.js.nodes.cast.JSToStringNode;
import com.oracle.truffle.js.nodes.unary.TypeOfNode;
import com.oracle.truffle.js.runtime.JSContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSToCanonicalizedLocaleListNode.class)
public final class JSToCanonicalizedLocaleListNodeGen extends JSToCanonicalizedLocaleListNode implements Provider {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @CompilationFinal private volatile int state_;
    @Child private OtherTypeData otherType_cache;
    @Child private ForeignTypeData foreignType_cache;

    private JSToCanonicalizedLocaleListNodeGen(JSContext context) {
        super(context);
    }

    @Override
    public String[] executeLanguageTags(Object arg0Value) {
        int state = state_;
        if ((state & 0b1) != 0 /* is-active doString(String) */ && JSTypesGen.isImplicitString((state & 0b111100000) >>> 5 /* extract-implicit-active 0:String */, arg0Value)) {
            String arg0Value_ = JSTypesGen.asImplicitString((state & 0b111100000) >>> 5 /* extract-implicit-active 0:String */, arg0Value);
            return doString(arg0Value_);
        }
        if ((state & 0b110) != 0 /* is-active doUndefined(DynamicObject) || doLocale(DynamicObject) */ && JSTypes.isDynamicObject(arg0Value)) {
            DynamicObject arg0Value_ = (DynamicObject) arg0Value;
            if ((state & 0b10) != 0 /* is-active doUndefined(DynamicObject) */) {
                if ((JSGuards.isUndefined(arg0Value_))) {
                    return doUndefined(arg0Value_);
                }
            }
            if ((state & 0b100) != 0 /* is-active doLocale(DynamicObject) */) {
                if ((JSGuards.isJSLocale(arg0Value_))) {
                    return doLocale(arg0Value_);
                }
            }
        }
        if ((state & 0b11000) != 0 /* is-active doOtherType(Object, JSToObjectNode, JSGetLengthNode, JSHasPropertyNode, TypeOfNode, JSToStringNode) || doForeignType(Object, InteropLibrary, TypeOfNode, JSToStringNode) */) {
            if ((state & 0b1000) != 0 /* is-active doOtherType(Object, JSToObjectNode, JSGetLengthNode, JSHasPropertyNode, TypeOfNode, JSToStringNode) */) {
                OtherTypeData s4_ = this.otherType_cache;
                if (s4_ != null) {
                    if ((!(JSGuards.isForeignObject(arg0Value))) && (!(JSGuards.isString(arg0Value))) && (!(JSGuards.isUndefined(arg0Value))) && (!(JSGuards.isJSLocale(arg0Value)))) {
                        return doOtherType(arg0Value, s4_.toObjectNode_, s4_.getLengthNode_, s4_.hasPropertyNode_, s4_.typeOfNode_, s4_.toStringNode_);
                    }
                }
            }
            if ((state & 0b10000) != 0 /* is-active doForeignType(Object, InteropLibrary, TypeOfNode, JSToStringNode) */) {
                ForeignTypeData s5_ = this.foreignType_cache;
                if (s5_ != null) {
                    if ((JSGuards.isForeignObject(arg0Value))) {
                        return doForeignType(arg0Value, s5_.interop_, s5_.typeOfNode_, s5_.toStringNode_);
                    }
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    private String[] executeAndSpecialize(Object arg0Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        try {
            {
                int stringCast0;
                if ((stringCast0 = JSTypesGen.specializeImplicitString(arg0Value)) != 0) {
                    String arg0Value_ = JSTypesGen.asImplicitString(stringCast0, arg0Value);
                    state = (state | (stringCast0 << 5) /* set-implicit-active 0:String */);
                    this.state_ = state = state | 0b1 /* add-active doString(String) */;
                    lock.unlock();
                    hasLock = false;
                    return doString(arg0Value_);
                }
            }
            if (JSTypes.isDynamicObject(arg0Value)) {
                DynamicObject arg0Value_ = (DynamicObject) arg0Value;
                if ((JSGuards.isUndefined(arg0Value_))) {
                    this.state_ = state = state | 0b10 /* add-active doUndefined(DynamicObject) */;
                    lock.unlock();
                    hasLock = false;
                    return doUndefined(arg0Value_);
                }
                if ((JSGuards.isJSLocale(arg0Value_))) {
                    this.state_ = state = state | 0b100 /* add-active doLocale(DynamicObject) */;
                    lock.unlock();
                    hasLock = false;
                    return doLocale(arg0Value_);
                }
            }
            if ((!(JSGuards.isForeignObject(arg0Value))) && (!(JSGuards.isString(arg0Value))) && (!(JSGuards.isUndefined(arg0Value))) && (!(JSGuards.isJSLocale(arg0Value)))) {
                OtherTypeData s4_ = super.insert(new OtherTypeData());
                s4_.toObjectNode_ = s4_.insertAccessor((JSToObjectNode.createToObject(context)));
                s4_.getLengthNode_ = s4_.insertAccessor((JSGetLengthNode.create(context)));
                s4_.hasPropertyNode_ = s4_.insertAccessor((JSHasPropertyNode.create()));
                s4_.typeOfNode_ = s4_.insertAccessor((TypeOfNode.create()));
                s4_.toStringNode_ = s4_.insertAccessor((JSToStringNode.create()));
                this.otherType_cache = s4_;
                this.state_ = state = state | 0b1000 /* add-active doOtherType(Object, JSToObjectNode, JSGetLengthNode, JSHasPropertyNode, TypeOfNode, JSToStringNode) */;
                lock.unlock();
                hasLock = false;
                return doOtherType(arg0Value, s4_.toObjectNode_, s4_.getLengthNode_, s4_.hasPropertyNode_, s4_.typeOfNode_, s4_.toStringNode_);
            }
            if ((JSGuards.isForeignObject(arg0Value))) {
                ForeignTypeData s5_ = super.insert(new ForeignTypeData());
                s5_.interop_ = s5_.insertAccessor((INTEROP_LIBRARY_.createDispatched(1)));
                s5_.typeOfNode_ = s5_.insertAccessor((TypeOfNode.create()));
                s5_.toStringNode_ = s5_.insertAccessor((JSToStringNode.create()));
                this.foreignType_cache = s5_;
                this.state_ = state = state | 0b10000 /* add-active doForeignType(Object, InteropLibrary, TypeOfNode, JSToStringNode) */;
                lock.unlock();
                hasLock = false;
                return doForeignType(arg0Value, s5_.interop_, s5_.typeOfNode_, s5_.toStringNode_);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {null}, arg0Value);
        } finally {
            if (hasLock) {
                lock.unlock();
            }
        }
    }

    @Override
    public NodeCost getCost() {
        int state = state_;
        if ((state & 0b11111) == 0b0) {
            return NodeCost.UNINITIALIZED;
        } else if (((state & 0b11111) & ((state & 0b11111) - 1)) == 0 /* is-single-active  */) {
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
        s[0] = "doString";
        if ((state & 0b1) != 0 /* is-active doString(String) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doUndefined";
        if ((state & 0b10) != 0 /* is-active doUndefined(DynamicObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doLocale";
        if ((state & 0b100) != 0 /* is-active doLocale(DynamicObject) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doOtherType";
        if ((state & 0b1000) != 0 /* is-active doOtherType(Object, JSToObjectNode, JSGetLengthNode, JSHasPropertyNode, TypeOfNode, JSToStringNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            OtherTypeData s4_ = this.otherType_cache;
            if (s4_ != null) {
                cached.add(Arrays.asList(s4_.toObjectNode_, s4_.getLengthNode_, s4_.hasPropertyNode_, s4_.typeOfNode_, s4_.toStringNode_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doForeignType";
        if ((state & 0b10000) != 0 /* is-active doForeignType(Object, InteropLibrary, TypeOfNode, JSToStringNode) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            ForeignTypeData s5_ = this.foreignType_cache;
            if (s5_ != null) {
                cached.add(Arrays.asList(s5_.interop_, s5_.typeOfNode_, s5_.toStringNode_));
            }
            s[2] = cached;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        return Provider.create(data);
    }

    public static JSToCanonicalizedLocaleListNode create(JSContext context) {
        return new JSToCanonicalizedLocaleListNodeGen(context);
    }

    @GeneratedBy(JSToCanonicalizedLocaleListNode.class)
    private static final class OtherTypeData extends Node {

        @Child JSToObjectNode toObjectNode_;
        @Child JSGetLengthNode getLengthNode_;
        @Child JSHasPropertyNode hasPropertyNode_;
        @Child TypeOfNode typeOfNode_;
        @Child JSToStringNode toStringNode_;

        OtherTypeData() {
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.NONE;
        }

        <T extends Node> T insertAccessor(T node) {
            return super.insert(node);
        }

    }
    @GeneratedBy(JSToCanonicalizedLocaleListNode.class)
    private static final class ForeignTypeData extends Node {

        @Child InteropLibrary interop_;
        @Child TypeOfNode typeOfNode_;
        @Child JSToStringNode toStringNode_;

        ForeignTypeData() {
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
