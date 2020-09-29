// CheckStyle: start generated
package com.oracle.truffle.js.runtime.builtins;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.TruffleLanguage.ContextReference;
import com.oracle.truffle.api.TruffleLanguage.LanguageReference;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.interop.ArityException;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.InvalidArrayIndexException;
import com.oracle.truffle.api.interop.UnknownIdentifierException;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.interop.UnsupportedTypeException;
import com.oracle.truffle.api.library.DynamicDispatchLibrary;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.js.lang.JavaScriptLanguage;
import com.oracle.truffle.js.nodes.access.ReadElementNode;
import com.oracle.truffle.js.nodes.access.WriteElementNode;
import com.oracle.truffle.js.nodes.interop.ExportValueNode;
import com.oracle.truffle.js.nodes.interop.ExportValueNodeGen;
import com.oracle.truffle.js.nodes.interop.ImportValueNode;
import com.oracle.truffle.js.nodes.interop.ImportValueNodeGen;
import com.oracle.truffle.js.nodes.interop.JSInteropInvokeNode;
import com.oracle.truffle.js.nodes.interop.JSInteropInvokeNodeGen;
import com.oracle.truffle.js.nodes.interop.KeyInfoNode;
import com.oracle.truffle.js.nodes.interop.KeyInfoNodeGen;
import com.oracle.truffle.js.runtime.JSRealm;
import com.oracle.truffle.js.runtime.objects.JSNonProxyObject;
import com.oracle.truffle.js.runtime.objects.JSObject;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSTypedArrayObject.class)
final class JSTypedArrayObjectGen {

    private static final LibraryFactory<DynamicDispatchLibrary> DYNAMIC_DISPATCH_LIBRARY_ = LibraryFactory.resolve(DynamicDispatchLibrary.class);

    static  {
        LibraryExport.register(JSTypedArrayObject.class, new InteropLibraryExports());
    }

    private JSTypedArrayObjectGen() {
    }

    @GeneratedBy(JSTypedArrayObject.class)
    private static final class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        private InteropLibraryExports() {
            super(InteropLibrary.class, JSTypedArrayObject.class, false);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof JSTypedArrayObject;
            InteropLibrary uncached = new Uncached();
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof JSTypedArrayObject;
            return new Cached();
        }

        @GeneratedBy(JSTypedArrayObject.class)
        private static final class Cached extends InteropLibrary {

            @CompilationFinal private volatile int state_;
            @Child private KeyInfoNode keyInfo;
            @CompilationFinal private LanguageReference<JavaScriptLanguage> javaScriptLanguageReference_;
            @CompilationFinal private ContextReference<JSRealm> javaScriptLanguageContextReference_;
            @Child private ReadElementNode readMemberNode__readNode_;
            @CompilationFinal private boolean readMemberNode__bindMemberFunctions_;
            @Child private ExportValueNode readMemberNode__exportNode_;
            @Child private ImportValueNode writeMemberNode__castValueNode_;
            @Child private WriteElementNode writeMemberNode__writeNode_;
            @Child private JSInteropInvokeNode invokeMemberNode__callNode_;
            @Child private ExportValueNode invokeMemberNode__exportNode_;
            @Child private ReadElementNode readArrayElementNode__readNode_;
            @Child private ExportValueNode readArrayElementNode__exportNode_;
            @Child private ImportValueNode writeArrayElementNode__castValueNode_;
            @Child private WriteElementNode writeArrayElementNode__writeNode_;

            Cached() {
            }

            @Override
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof JSTypedArrayObject) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof JSTypedArrayObject;
            }

            @Override
            public Object getMembers(Object receiver, boolean includeInternal) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((JSTypedArrayObject) receiver)).getMembers(includeInternal);
            }

            @Override
            public boolean hasMembers(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((JSTypedArrayObject) receiver)).hasMembers();
            }

            @Override
            public Object readMember(Object arg0Value_, String arg1Value) throws UnsupportedMessageException, UnknownIdentifierException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSTypedArrayObject arg0Value = ((JSTypedArrayObject) arg0Value_);
                int state = state_;
                if ((state & 0b1) != 0 /* is-active readMember(JSObject, String, LanguageReference<JavaScriptLanguage>, ReadElementNode, boolean, ExportValueNode) */) {
                    {
                        LanguageReference<JavaScriptLanguage> javaScriptLanguageReference__ = this.javaScriptLanguageReference_;
                        LanguageReference<JavaScriptLanguage> readMemberNode__languageRef__ = javaScriptLanguageReference__;
                        return arg0Value.readMember(arg1Value, readMemberNode__languageRef__, this.readMemberNode__readNode_, this.readMemberNode__bindMemberFunctions_, this.readMemberNode__exportNode_);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return readMemberNode_AndSpecialize(arg0Value, arg1Value);
            }

            private Object readMemberNode_AndSpecialize(JSObject arg0Value, String arg1Value) throws UnknownIdentifierException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                int state = state_;
                try {
                    {
                        LanguageReference<JavaScriptLanguage> readMemberNode__languageRef__ = null;
                        LanguageReference<JavaScriptLanguage> javaScriptLanguageReference__1 = this.javaScriptLanguageReference_;
                        if (javaScriptLanguageReference__1 == null) {
                            this.javaScriptLanguageReference_ = javaScriptLanguageReference__1 = super.lookupLanguageReference(JavaScriptLanguage.class);
                        }
                        readMemberNode__languageRef__ = javaScriptLanguageReference__1;
                        this.readMemberNode__readNode_ = super.insert((ReadElementNode.create(readMemberNode__languageRef__.get().getJSContext())));
                        this.readMemberNode__bindMemberFunctions_ = (readMemberNode__languageRef__.get().bindMemberFunctions());
                        this.readMemberNode__exportNode_ = super.insert((ExportValueNode.create()));
                        this.state_ = state = state | 0b1 /* add-active readMember(JSObject, String, LanguageReference<JavaScriptLanguage>, ReadElementNode, boolean, ExportValueNode) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.readMember(arg1Value, readMemberNode__languageRef__, this.readMemberNode__readNode_, this.readMemberNode__bindMemberFunctions_, this.readMemberNode__exportNode_);
                    }
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
            public boolean isMemberReadable(Object arg0Value_, String arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSTypedArrayObject arg0Value = ((JSTypedArrayObject) arg0Value_);
                int state = state_;
                if ((state & 0b10) != 0 /* is-active isMemberReadable(JSObject, String, KeyInfoNode) */) {
                    return arg0Value.isMemberReadable(arg1Value, this.keyInfo);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isMemberReadableNode_AndSpecialize(arg0Value, arg1Value);
            }

            private boolean isMemberReadableNode_AndSpecialize(JSObject arg0Value, String arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                int state = state_;
                try {
                    if (this.keyInfo == null) {
                        this.keyInfo = super.insert((KeyInfoNodeGen.create()));
                    }
                    this.state_ = state = state | 0b10 /* add-active isMemberReadable(JSObject, String, KeyInfoNode) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.isMemberReadable(arg1Value, this.keyInfo);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public void writeMember(Object arg0Value_, String arg1Value, Object arg2Value) throws UnsupportedMessageException, UnknownIdentifierException, UnsupportedTypeException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSTypedArrayObject arg0Value = ((JSTypedArrayObject) arg0Value_);
                int state = state_;
                if ((state & 0b100) != 0 /* is-active writeMember(JSObject, String, Object, KeyInfoNode, ImportValueNode, LanguageReference<JavaScriptLanguage>, WriteElementNode) */) {
                    {
                        LanguageReference<JavaScriptLanguage> javaScriptLanguageReference__ = this.javaScriptLanguageReference_;
                        LanguageReference<JavaScriptLanguage> writeMemberNode__languageRef__ = javaScriptLanguageReference__;
                        arg0Value.writeMember(arg1Value, arg2Value, this.keyInfo, this.writeMemberNode__castValueNode_, writeMemberNode__languageRef__, this.writeMemberNode__writeNode_);
                        return;
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                writeMemberNode_AndSpecialize(arg0Value, arg1Value, arg2Value);
                return;
            }

            private void writeMemberNode_AndSpecialize(JSObject arg0Value, String arg1Value, Object arg2Value) throws UnknownIdentifierException, UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                int state = state_;
                try {
                    {
                        LanguageReference<JavaScriptLanguage> writeMemberNode__languageRef__ = null;
                        if (this.keyInfo == null) {
                            this.keyInfo = super.insert((KeyInfoNodeGen.create()));
                        }
                        this.writeMemberNode__castValueNode_ = super.insert((ImportValueNode.create()));
                        LanguageReference<JavaScriptLanguage> javaScriptLanguageReference__1 = this.javaScriptLanguageReference_;
                        if (javaScriptLanguageReference__1 == null) {
                            this.javaScriptLanguageReference_ = javaScriptLanguageReference__1 = super.lookupLanguageReference(JavaScriptLanguage.class);
                        }
                        writeMemberNode__languageRef__ = javaScriptLanguageReference__1;
                        this.writeMemberNode__writeNode_ = super.insert((WriteElementNode.createCachedInterop(writeMemberNode__languageRef__)));
                        this.state_ = state = state | 0b100 /* add-active writeMember(JSObject, String, Object, KeyInfoNode, ImportValueNode, LanguageReference<JavaScriptLanguage>, WriteElementNode) */;
                        lock.unlock();
                        hasLock = false;
                        arg0Value.writeMember(arg1Value, arg2Value, this.keyInfo, this.writeMemberNode__castValueNode_, writeMemberNode__languageRef__, this.writeMemberNode__writeNode_);
                        return;
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean isMemberModifiable(Object arg0Value_, String arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSTypedArrayObject arg0Value = ((JSTypedArrayObject) arg0Value_);
                int state = state_;
                if ((state & 0b1000) != 0 /* is-active isMemberModifiable(JSObject, String, KeyInfoNode) */) {
                    return arg0Value.isMemberModifiable(arg1Value, this.keyInfo);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isMemberModifiableNode_AndSpecialize(arg0Value, arg1Value);
            }

            private boolean isMemberModifiableNode_AndSpecialize(JSObject arg0Value, String arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                int state = state_;
                try {
                    if (this.keyInfo == null) {
                        this.keyInfo = super.insert((KeyInfoNodeGen.create()));
                    }
                    this.state_ = state = state | 0b1000 /* add-active isMemberModifiable(JSObject, String, KeyInfoNode) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.isMemberModifiable(arg1Value, this.keyInfo);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean isMemberInsertable(Object arg0Value_, String arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSTypedArrayObject arg0Value = ((JSTypedArrayObject) arg0Value_);
                int state = state_;
                if ((state & 0b10000) != 0 /* is-active isMemberInsertable(JSObject, String, KeyInfoNode) */) {
                    return arg0Value.isMemberInsertable(arg1Value, this.keyInfo);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isMemberInsertableNode_AndSpecialize(arg0Value, arg1Value);
            }

            private boolean isMemberInsertableNode_AndSpecialize(JSObject arg0Value, String arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                int state = state_;
                try {
                    if (this.keyInfo == null) {
                        this.keyInfo = super.insert((KeyInfoNodeGen.create()));
                    }
                    this.state_ = state = state | 0b10000 /* add-active isMemberInsertable(JSObject, String, KeyInfoNode) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.isMemberInsertable(arg1Value, this.keyInfo);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public void removeMember(Object receiver, String member) throws UnsupportedMessageException, UnknownIdentifierException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                (((JSTypedArrayObject) receiver)).removeMember(member);
                return;
            }

            @Override
            public boolean isMemberRemovable(Object arg0Value_, String arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSTypedArrayObject arg0Value = ((JSTypedArrayObject) arg0Value_);
                int state = state_;
                if ((state & 0b100000) != 0 /* is-active isMemberRemovable(JSObject, String, KeyInfoNode) */) {
                    return arg0Value.isMemberRemovable(arg1Value, this.keyInfo);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isMemberRemovableNode_AndSpecialize(arg0Value, arg1Value);
            }

            private boolean isMemberRemovableNode_AndSpecialize(JSObject arg0Value, String arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                int state = state_;
                try {
                    if (this.keyInfo == null) {
                        this.keyInfo = super.insert((KeyInfoNodeGen.create()));
                    }
                    this.state_ = state = state | 0b100000 /* add-active isMemberRemovable(JSObject, String, KeyInfoNode) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.isMemberRemovable(arg1Value, this.keyInfo);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public Object invokeMember(Object arg0Value_, String arg1Value, Object... arg2Value) throws UnsupportedMessageException, ArityException, UnknownIdentifierException, UnsupportedTypeException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSTypedArrayObject arg0Value = ((JSTypedArrayObject) arg0Value_);
                int state = state_;
                if ((state & 0b1000000) != 0 /* is-active invokeMember(JSObject, String, Object[], JavaScriptLanguage, JSRealm, JSInteropInvokeNode, ExportValueNode) */) {
                    {
                        LanguageReference<JavaScriptLanguage> javaScriptLanguageReference__ = this.javaScriptLanguageReference_;
                        JavaScriptLanguage invokeMemberNode__language__ = javaScriptLanguageReference__.get();
                        ContextReference<JSRealm> javaScriptLanguageContextReference__ = this.javaScriptLanguageContextReference_;
                        JSRealm invokeMemberNode__realm__ = javaScriptLanguageContextReference__.get();
                        return arg0Value.invokeMember(arg1Value, arg2Value, invokeMemberNode__language__, invokeMemberNode__realm__, this.invokeMemberNode__callNode_, this.invokeMemberNode__exportNode_);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return invokeMemberNode_AndSpecialize(arg0Value, arg1Value, arg2Value);
            }

            private Object invokeMemberNode_AndSpecialize(JSObject arg0Value, String arg1Value, Object[] arg2Value) throws UnsupportedMessageException, UnknownIdentifierException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                int state = state_;
                try {
                    {
                        JSRealm invokeMemberNode__realm__ = null;
                        JavaScriptLanguage invokeMemberNode__language__ = null;
                        LanguageReference<JavaScriptLanguage> javaScriptLanguageReference__1 = this.javaScriptLanguageReference_;
                        if (javaScriptLanguageReference__1 == null) {
                            this.javaScriptLanguageReference_ = javaScriptLanguageReference__1 = super.lookupLanguageReference(JavaScriptLanguage.class);
                        }
                        invokeMemberNode__language__ = javaScriptLanguageReference__1.get();
                        ContextReference<JSRealm> javaScriptLanguageContextReference__1 = this.javaScriptLanguageContextReference_;
                        if (javaScriptLanguageContextReference__1 == null) {
                            this.javaScriptLanguageContextReference_ = javaScriptLanguageContextReference__1 = super.lookupContextReference(JavaScriptLanguage.class);
                        }
                        invokeMemberNode__realm__ = javaScriptLanguageContextReference__1.get();
                        this.invokeMemberNode__callNode_ = super.insert((JSInteropInvokeNode.create()));
                        this.invokeMemberNode__exportNode_ = super.insert((ExportValueNode.create()));
                        this.state_ = state = state | 0b1000000 /* add-active invokeMember(JSObject, String, Object[], JavaScriptLanguage, JSRealm, JSInteropInvokeNode, ExportValueNode) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.invokeMember(arg1Value, arg2Value, invokeMemberNode__language__, invokeMemberNode__realm__, this.invokeMemberNode__callNode_, this.invokeMemberNode__exportNode_);
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean isMemberInvocable(Object arg0Value_, String arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSTypedArrayObject arg0Value = ((JSTypedArrayObject) arg0Value_);
                int state = state_;
                if ((state & 0b10000000) != 0 /* is-active isMemberInvocable(JSObject, String, KeyInfoNode) */) {
                    return arg0Value.isMemberInvocable(arg1Value, this.keyInfo);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isMemberInvocableNode_AndSpecialize(arg0Value, arg1Value);
            }

            private boolean isMemberInvocableNode_AndSpecialize(JSObject arg0Value, String arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                int state = state_;
                try {
                    if (this.keyInfo == null) {
                        this.keyInfo = super.insert((KeyInfoNodeGen.create()));
                    }
                    this.state_ = state = state | 0b10000000 /* add-active isMemberInvocable(JSObject, String, KeyInfoNode) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.isMemberInvocable(arg1Value, this.keyInfo);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean hasMemberReadSideEffects(Object arg0Value_, String arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSTypedArrayObject arg0Value = ((JSTypedArrayObject) arg0Value_);
                int state = state_;
                if ((state & 0b100000000) != 0 /* is-active hasMemberReadSideEffects(JSObject, String, KeyInfoNode) */) {
                    return arg0Value.hasMemberReadSideEffects(arg1Value, this.keyInfo);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return hasMemberReadSideEffectsNode_AndSpecialize(arg0Value, arg1Value);
            }

            private boolean hasMemberReadSideEffectsNode_AndSpecialize(JSObject arg0Value, String arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                int state = state_;
                try {
                    if (this.keyInfo == null) {
                        this.keyInfo = super.insert((KeyInfoNodeGen.create()));
                    }
                    this.state_ = state = state | 0b100000000 /* add-active hasMemberReadSideEffects(JSObject, String, KeyInfoNode) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.hasMemberReadSideEffects(arg1Value, this.keyInfo);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean hasMemberWriteSideEffects(Object arg0Value_, String arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSTypedArrayObject arg0Value = ((JSTypedArrayObject) arg0Value_);
                int state = state_;
                if ((state & 0b1000000000) != 0 /* is-active hasMemberWriteSideEffects(JSObject, String, KeyInfoNode) */) {
                    return arg0Value.hasMemberWriteSideEffects(arg1Value, this.keyInfo);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return hasMemberWriteSideEffectsNode_AndSpecialize(arg0Value, arg1Value);
            }

            private boolean hasMemberWriteSideEffectsNode_AndSpecialize(JSObject arg0Value, String arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                int state = state_;
                try {
                    if (this.keyInfo == null) {
                        this.keyInfo = super.insert((KeyInfoNodeGen.create()));
                    }
                    this.state_ = state = state | 0b1000000000 /* add-active hasMemberWriteSideEffects(JSObject, String, KeyInfoNode) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.hasMemberWriteSideEffects(arg1Value, this.keyInfo);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean hasLanguage(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((JSTypedArrayObject) receiver)).hasLanguage();
            }

            @Override
            public Class<? extends TruffleLanguage<?>> getLanguage(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((JSTypedArrayObject) receiver)).getLanguage();
            }

            @Override
            public Object toDisplayString(Object receiver, boolean allowSideEffects) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((JSTypedArrayObject) receiver)).toDisplayString(allowSideEffects);
            }

            @Override
            public boolean hasMetaObject(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((JSTypedArrayObject) receiver)).hasMetaObject();
            }

            @Override
            public Object getMetaObject(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((JSTypedArrayObject) receiver)).getMetaObject();
            }

            @Override
            public boolean hasArrayElements(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((JSTypedArrayObject) receiver)).hasArrayElements();
            }

            @Override
            public long getArraySize(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((JSTypedArrayObject) receiver)).getArraySize();
            }

            @Override
            public Object readArrayElement(Object arg0Value_, long arg1Value) throws UnsupportedMessageException, InvalidArrayIndexException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSTypedArrayObject arg0Value = ((JSTypedArrayObject) arg0Value_);
                int state = state_;
                if ((state & 0b10000000000) != 0 /* is-active readArrayElement(JSTypedArrayObject, long, LanguageReference<JavaScriptLanguage>, ReadElementNode, ExportValueNode, InteropLibrary) */) {
                    {
                        LanguageReference<JavaScriptLanguage> javaScriptLanguageReference__ = this.javaScriptLanguageReference_;
                        LanguageReference<JavaScriptLanguage> readArrayElementNode__languageRef__ = javaScriptLanguageReference__;
                        InteropLibrary readArrayElementNode__thisLibrary__ = (this);
                        return arg0Value.readArrayElement(arg1Value, readArrayElementNode__languageRef__, this.readArrayElementNode__readNode_, this.readArrayElementNode__exportNode_, readArrayElementNode__thisLibrary__);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return readArrayElementNode_AndSpecialize(arg0Value, arg1Value);
            }

            private Object readArrayElementNode_AndSpecialize(JSTypedArrayObject arg0Value, long arg1Value) throws InvalidArrayIndexException, UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                int state = state_;
                try {
                    {
                        InteropLibrary readArrayElementNode__thisLibrary__ = null;
                        LanguageReference<JavaScriptLanguage> readArrayElementNode__languageRef__ = null;
                        LanguageReference<JavaScriptLanguage> javaScriptLanguageReference__1 = this.javaScriptLanguageReference_;
                        if (javaScriptLanguageReference__1 == null) {
                            this.javaScriptLanguageReference_ = javaScriptLanguageReference__1 = super.lookupLanguageReference(JavaScriptLanguage.class);
                        }
                        readArrayElementNode__languageRef__ = javaScriptLanguageReference__1;
                        this.readArrayElementNode__readNode_ = super.insert((ReadElementNode.create(readArrayElementNode__languageRef__.get().getJSContext())));
                        this.readArrayElementNode__exportNode_ = super.insert((ExportValueNode.create()));
                        readArrayElementNode__thisLibrary__ = (this);
                        this.state_ = state = state | 0b10000000000 /* add-active readArrayElement(JSTypedArrayObject, long, LanguageReference<JavaScriptLanguage>, ReadElementNode, ExportValueNode, InteropLibrary) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.readArrayElement(arg1Value, readArrayElementNode__languageRef__, this.readArrayElementNode__readNode_, this.readArrayElementNode__exportNode_, readArrayElementNode__thisLibrary__);
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean isArrayElementReadable(Object arg0Value_, long arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSTypedArrayObject arg0Value = ((JSTypedArrayObject) arg0Value_);
                {
                    InteropLibrary isArrayElementReadableNode__thisLibrary__ = (this);
                    return arg0Value.isArrayElementReadable(arg1Value, isArrayElementReadableNode__thisLibrary__);
                }
            }

            @Override
            public void writeArrayElement(Object arg0Value_, long arg1Value, Object arg2Value) throws UnsupportedMessageException, UnsupportedTypeException, InvalidArrayIndexException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSTypedArrayObject arg0Value = ((JSTypedArrayObject) arg0Value_);
                int state = state_;
                if ((state & 0b100000000000) != 0 /* is-active writeArrayElement(JSTypedArrayObject, long, Object, KeyInfoNode, ImportValueNode, LanguageReference<JavaScriptLanguage>, WriteElementNode) */) {
                    {
                        LanguageReference<JavaScriptLanguage> javaScriptLanguageReference__ = this.javaScriptLanguageReference_;
                        LanguageReference<JavaScriptLanguage> writeArrayElementNode__languageRef__ = javaScriptLanguageReference__;
                        arg0Value.writeArrayElement(arg1Value, arg2Value, this.keyInfo, this.writeArrayElementNode__castValueNode_, writeArrayElementNode__languageRef__, this.writeArrayElementNode__writeNode_);
                        return;
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                writeArrayElementNode_AndSpecialize(arg0Value, arg1Value, arg2Value);
                return;
            }

            private void writeArrayElementNode_AndSpecialize(JSTypedArrayObject arg0Value, long arg1Value, Object arg2Value) throws InvalidArrayIndexException, UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                int state = state_;
                try {
                    {
                        LanguageReference<JavaScriptLanguage> writeArrayElementNode__languageRef__ = null;
                        if (this.keyInfo == null) {
                            this.keyInfo = super.insert((KeyInfoNodeGen.create()));
                        }
                        this.writeArrayElementNode__castValueNode_ = super.insert((ImportValueNode.create()));
                        LanguageReference<JavaScriptLanguage> javaScriptLanguageReference__1 = this.javaScriptLanguageReference_;
                        if (javaScriptLanguageReference__1 == null) {
                            this.javaScriptLanguageReference_ = javaScriptLanguageReference__1 = super.lookupLanguageReference(JavaScriptLanguage.class);
                        }
                        writeArrayElementNode__languageRef__ = javaScriptLanguageReference__1;
                        this.writeArrayElementNode__writeNode_ = super.insert((WriteElementNode.createCachedInterop(writeArrayElementNode__languageRef__)));
                        this.state_ = state = state | 0b100000000000 /* add-active writeArrayElement(JSTypedArrayObject, long, Object, KeyInfoNode, ImportValueNode, LanguageReference<JavaScriptLanguage>, WriteElementNode) */;
                        lock.unlock();
                        hasLock = false;
                        arg0Value.writeArrayElement(arg1Value, arg2Value, this.keyInfo, this.writeArrayElementNode__castValueNode_, writeArrayElementNode__languageRef__, this.writeArrayElementNode__writeNode_);
                        return;
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean isArrayElementModifiable(Object arg0Value_, long arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSTypedArrayObject arg0Value = ((JSTypedArrayObject) arg0Value_);
                int state = state_;
                if ((state & 0b1000000000000) != 0 /* is-active isArrayElementModifiable(JSTypedArrayObject, long, KeyInfoNode) */) {
                    return arg0Value.isArrayElementModifiable(arg1Value, this.keyInfo);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isArrayElementModifiableNode_AndSpecialize(arg0Value, arg1Value);
            }

            private boolean isArrayElementModifiableNode_AndSpecialize(JSTypedArrayObject arg0Value, long arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                int state = state_;
                try {
                    if (this.keyInfo == null) {
                        this.keyInfo = super.insert((KeyInfoNodeGen.create()));
                    }
                    this.state_ = state = state | 0b1000000000000 /* add-active isArrayElementModifiable(JSTypedArrayObject, long, KeyInfoNode) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.isArrayElementModifiable(arg1Value, this.keyInfo);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean isArrayElementInsertable(Object arg0Value_, long arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSTypedArrayObject arg0Value = ((JSTypedArrayObject) arg0Value_);
                int state = state_;
                if ((state & 0b10000000000000) != 0 /* is-active isArrayElementInsertable(JSTypedArrayObject, long, KeyInfoNode) */) {
                    return arg0Value.isArrayElementInsertable(arg1Value, this.keyInfo);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isArrayElementInsertableNode_AndSpecialize(arg0Value, arg1Value);
            }

            private boolean isArrayElementInsertableNode_AndSpecialize(JSTypedArrayObject arg0Value, long arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                int state = state_;
                try {
                    if (this.keyInfo == null) {
                        this.keyInfo = super.insert((KeyInfoNodeGen.create()));
                    }
                    this.state_ = state = state | 0b10000000000000 /* add-active isArrayElementInsertable(JSTypedArrayObject, long, KeyInfoNode) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.isArrayElementInsertable(arg1Value, this.keyInfo);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

        }
        @GeneratedBy(JSTypedArrayObject.class)
        private static final class Uncached extends InteropLibrary {

            private final LanguageReference<JavaScriptLanguage> javaScriptLanguageReference_ = lookupLanguageReference(JavaScriptLanguage.class);
            private final ContextReference<JSRealm> javaScriptLanguageContextReference_ = lookupContextReference(JavaScriptLanguage.class);

            Uncached() {
            }

            @TruffleBoundary
            @Override
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof JSTypedArrayObject) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof JSTypedArrayObject;
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
            public Object getMembers(Object receiver, boolean includeInternal) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((JSTypedArrayObject) receiver) .getMembers(includeInternal);
            }

            @TruffleBoundary
            @Override
            public boolean hasMembers(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((JSObject) receiver) .hasMembers();
            }

            @TruffleBoundary
            @Override
            public Object readMember(Object arg0Value_, String arg1Value) throws UnknownIdentifierException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSObject arg0Value = ((JSObject) arg0Value_);
                return arg0Value.readMember(arg1Value, this.javaScriptLanguageReference_, (JSObject.getUncachedRead()), (this.javaScriptLanguageReference_.get().bindMemberFunctions()), (ExportValueNodeGen.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean isMemberReadable(Object arg0Value_, String arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSObject arg0Value = ((JSObject) arg0Value_);
                return arg0Value.isMemberReadable(arg1Value, (KeyInfoNodeGen.getUncached()));
            }

            @TruffleBoundary
            @Override
            public void writeMember(Object arg0Value_, String arg1Value, Object arg2Value) throws UnknownIdentifierException, UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSObject arg0Value = ((JSObject) arg0Value_);
                arg0Value.writeMember(arg1Value, arg2Value, (KeyInfoNodeGen.getUncached()), (ImportValueNodeGen.getUncached()), this.javaScriptLanguageReference_, (JSObject.getUncachedWrite()));
                return;
            }

            @TruffleBoundary
            @Override
            public boolean isMemberModifiable(Object arg0Value_, String arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSObject arg0Value = ((JSObject) arg0Value_);
                return arg0Value.isMemberModifiable(arg1Value, (KeyInfoNodeGen.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean isMemberInsertable(Object arg0Value_, String arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSObject arg0Value = ((JSObject) arg0Value_);
                return arg0Value.isMemberInsertable(arg1Value, (KeyInfoNodeGen.getUncached()));
            }

            @TruffleBoundary
            @Override
            public void removeMember(Object receiver, String member) throws UnsupportedMessageException, UnknownIdentifierException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                ((JSObject) receiver) .removeMember(member);
                return;
            }

            @TruffleBoundary
            @Override
            public boolean isMemberRemovable(Object arg0Value_, String arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSObject arg0Value = ((JSObject) arg0Value_);
                return arg0Value.isMemberRemovable(arg1Value, (KeyInfoNodeGen.getUncached()));
            }

            @TruffleBoundary
            @Override
            public Object invokeMember(Object arg0Value_, String arg1Value, Object... arg2Value) throws UnsupportedMessageException, UnknownIdentifierException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSObject arg0Value = ((JSObject) arg0Value_);
                return arg0Value.invokeMember(arg1Value, arg2Value, this.javaScriptLanguageReference_.get(), this.javaScriptLanguageContextReference_.get(), (JSInteropInvokeNodeGen.getUncached()), (ExportValueNodeGen.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean isMemberInvocable(Object arg0Value_, String arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSObject arg0Value = ((JSObject) arg0Value_);
                return arg0Value.isMemberInvocable(arg1Value, (KeyInfoNodeGen.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean hasMemberReadSideEffects(Object arg0Value_, String arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSObject arg0Value = ((JSObject) arg0Value_);
                return arg0Value.hasMemberReadSideEffects(arg1Value, (KeyInfoNodeGen.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean hasMemberWriteSideEffects(Object arg0Value_, String arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSObject arg0Value = ((JSObject) arg0Value_);
                return arg0Value.hasMemberWriteSideEffects(arg1Value, (KeyInfoNodeGen.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean hasLanguage(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((JSObject) receiver) .hasLanguage();
            }

            @TruffleBoundary
            @Override
            public Class<? extends TruffleLanguage<?>> getLanguage(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((JSObject) receiver) .getLanguage();
            }

            @TruffleBoundary
            @Override
            public Object toDisplayString(Object receiver, boolean allowSideEffects) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((JSObject) receiver) .toDisplayString(allowSideEffects);
            }

            @TruffleBoundary
            @Override
            public boolean hasMetaObject(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((JSNonProxyObject) receiver) .hasMetaObject();
            }

            @TruffleBoundary
            @Override
            public Object getMetaObject(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((JSNonProxyObject) receiver) .getMetaObject();
            }

            @TruffleBoundary
            @Override
            public boolean hasArrayElements(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((JSTypedArrayObject) receiver) .hasArrayElements();
            }

            @TruffleBoundary
            @Override
            public long getArraySize(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((JSTypedArrayObject) receiver) .getArraySize();
            }

            @TruffleBoundary
            @Override
            public Object readArrayElement(Object arg0Value_, long arg1Value) throws InvalidArrayIndexException, UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSTypedArrayObject arg0Value = ((JSTypedArrayObject) arg0Value_);
                return arg0Value.readArrayElement(arg1Value, this.javaScriptLanguageReference_, (JSObject.getUncachedRead()), (ExportValueNodeGen.getUncached()), (this));
            }

            @TruffleBoundary
            @Override
            public boolean isArrayElementReadable(Object arg0Value_, long arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSTypedArrayObject arg0Value = ((JSTypedArrayObject) arg0Value_);
                return arg0Value.isArrayElementReadable(arg1Value, (this));
            }

            @TruffleBoundary
            @Override
            public void writeArrayElement(Object arg0Value_, long arg1Value, Object arg2Value) throws InvalidArrayIndexException, UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSTypedArrayObject arg0Value = ((JSTypedArrayObject) arg0Value_);
                arg0Value.writeArrayElement(arg1Value, arg2Value, (KeyInfoNodeGen.getUncached()), (ImportValueNodeGen.getUncached()), this.javaScriptLanguageReference_, (JSObject.getUncachedWrite()));
                return;
            }

            @TruffleBoundary
            @Override
            public boolean isArrayElementModifiable(Object arg0Value_, long arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSTypedArrayObject arg0Value = ((JSTypedArrayObject) arg0Value_);
                return arg0Value.isArrayElementModifiable(arg1Value, (KeyInfoNodeGen.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean isArrayElementInsertable(Object arg0Value_, long arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSTypedArrayObject arg0Value = ((JSTypedArrayObject) arg0Value_);
                return arg0Value.isArrayElementInsertable(arg1Value, (KeyInfoNodeGen.getUncached()));
            }

        }
    }
}
