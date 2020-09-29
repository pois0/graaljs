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
import com.oracle.truffle.api.interop.UnknownIdentifierException;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.interop.UnsupportedTypeException;
import com.oracle.truffle.api.library.DynamicDispatchLibrary;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.ExplodeLoop;
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
import com.oracle.truffle.js.runtime.objects.JSObject.GetMembers;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSNumberObject.class)
final class JSNumberObjectGen {

    private static final LibraryFactory<DynamicDispatchLibrary> DYNAMIC_DISPATCH_LIBRARY_ = LibraryFactory.resolve(DynamicDispatchLibrary.class);
    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    static  {
        LibraryExport.register(JSNumberObject.class, new InteropLibraryExports());
    }

    private JSNumberObjectGen() {
    }

    @GeneratedBy(JSNumberObject.class)
    private static final class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        private InteropLibraryExports() {
            super(InteropLibrary.class, JSNumberObject.class, false);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof JSNumberObject;
            InteropLibrary uncached = new Uncached();
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof JSNumberObject;
            return new Cached();
        }

        @GeneratedBy(JSNumberObject.class)
        private static final class Cached extends InteropLibrary {

            @CompilationFinal private volatile int state_;
            @CompilationFinal private volatile int exclude_;
            @Child private KeyInfoNode keyInfo;
            @Child private InteropLibrary numberLib;
            @CompilationFinal private LanguageReference<JavaScriptLanguage> javaScriptLanguageReference_;
            @CompilationFinal private ContextReference<JSRealm> javaScriptLanguageContextReference_;
            @CompilationFinal private GetMembersNonArrayCachedData getMembers_nonArrayCached_cache;
            @Child private ReadElementNode readMemberNode__readNode_;
            @CompilationFinal private boolean readMemberNode__bindMemberFunctions_;
            @Child private ExportValueNode readMemberNode__exportNode_;
            @Child private ImportValueNode writeMemberNode__castValueNode_;
            @Child private WriteElementNode writeMemberNode__writeNode_;
            @Child private JSInteropInvokeNode invokeMemberNode__callNode_;
            @Child private ExportValueNode invokeMemberNode__exportNode_;

            Cached() {
            }

            @Override
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof JSNumberObject) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof JSNumberObject;
            }

            @ExplodeLoop
            @Override
            public Object getMembers(Object arg0Value_, boolean arg1Value) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSNumberObject arg0Value = ((JSNumberObject) arg0Value_);
                int state = state_;
                if ((state & 0b11) != 0 /* is-active nonArrayCached(JSObject, boolean, JSClass) || nonArrayUncached(JSObject, boolean) */) {
                    if ((state & 0b1) != 0 /* is-active nonArrayCached(JSObject, boolean, JSClass) */) {
                        GetMembersNonArrayCachedData s1_ = this.getMembers_nonArrayCached_cache;
                        while (s1_ != null) {
                            assert (s1_.cachedJSClass_ != null);
                            if ((JSObject.getJSClass(arg0Value) == s1_.cachedJSClass_)) {
                                return GetMembers.nonArrayCached(arg0Value, arg1Value, s1_.cachedJSClass_);
                            }
                            s1_ = s1_.next_;
                        }
                    }
                    if ((state & 0b10) != 0 /* is-active nonArrayUncached(JSObject, boolean) */) {
                        return GetMembers.nonArrayUncached(arg0Value, arg1Value);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return getMembersAndSpecialize(arg0Value, arg1Value);
            }

            private Object getMembersAndSpecialize(JSObject arg0Value, boolean arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                int state = state_;
                int exclude = exclude_;
                try {
                    if ((exclude) == 0 /* is-not-excluded nonArrayCached(JSObject, boolean, JSClass) */) {
                        int count1_ = 0;
                        GetMembersNonArrayCachedData s1_ = this.getMembers_nonArrayCached_cache;
                        if ((state & 0b1) != 0 /* is-active nonArrayCached(JSObject, boolean, JSClass) */) {
                            while (s1_ != null) {
                                assert (s1_.cachedJSClass_ != null);
                                if ((JSObject.getJSClass(arg0Value) == s1_.cachedJSClass_)) {
                                    break;
                                }
                                s1_ = s1_.next_;
                                count1_++;
                            }
                        }
                        if (s1_ == null) {
                            {
                                JSClass cachedJSClass__ = (JSObject.getJSClass(arg0Value));
                                if ((cachedJSClass__ != null) && (JSObject.getJSClass(arg0Value) == cachedJSClass__) && count1_ < (3)) {
                                    s1_ = new GetMembersNonArrayCachedData(getMembers_nonArrayCached_cache);
                                    s1_.cachedJSClass_ = cachedJSClass__;
                                    this.getMembers_nonArrayCached_cache = s1_;
                                    this.state_ = state = state | 0b1 /* add-active nonArrayCached(JSObject, boolean, JSClass) */;
                                }
                            }
                        }
                        if (s1_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return GetMembers.nonArrayCached(arg0Value, arg1Value, s1_.cachedJSClass_);
                        }
                    }
                    this.exclude_ = exclude = exclude | 0b1 /* add-excluded nonArrayCached(JSObject, boolean, JSClass) */;
                    this.getMembers_nonArrayCached_cache = null;
                    state = state & 0xfffffffe /* remove-active nonArrayCached(JSObject, boolean, JSClass) */;
                    this.state_ = state = state | 0b10 /* add-active nonArrayUncached(JSObject, boolean) */;
                    lock.unlock();
                    hasLock = false;
                    return GetMembers.nonArrayUncached(arg0Value, arg1Value);
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
                    GetMembersNonArrayCachedData s1_ = this.getMembers_nonArrayCached_cache;
                    if ((s1_ == null || s1_.next_ == null)) {
                        return NodeCost.MONOMORPHIC;
                    }
                }
                return NodeCost.POLYMORPHIC;
            }

            @Override
            public boolean hasMembers(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((JSNumberObject) receiver)).hasMembers();
            }

            @Override
            public Object readMember(Object arg0Value_, String arg1Value) throws UnsupportedMessageException, UnknownIdentifierException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSNumberObject arg0Value = ((JSNumberObject) arg0Value_);
                int state = state_;
                if ((state & 0b100) != 0 /* is-active readMember(JSObject, String, LanguageReference<JavaScriptLanguage>, ReadElementNode, boolean, ExportValueNode) */) {
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
                        this.state_ = state = state | 0b100 /* add-active readMember(JSObject, String, LanguageReference<JavaScriptLanguage>, ReadElementNode, boolean, ExportValueNode) */;
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
            public boolean isMemberReadable(Object arg0Value_, String arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSNumberObject arg0Value = ((JSNumberObject) arg0Value_);
                int state = state_;
                if ((state & 0b1000) != 0 /* is-active isMemberReadable(JSObject, String, KeyInfoNode) */) {
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
                    this.state_ = state = state | 0b1000 /* add-active isMemberReadable(JSObject, String, KeyInfoNode) */;
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
                JSNumberObject arg0Value = ((JSNumberObject) arg0Value_);
                int state = state_;
                if ((state & 0b10000) != 0 /* is-active writeMember(JSObject, String, Object, KeyInfoNode, ImportValueNode, LanguageReference<JavaScriptLanguage>, WriteElementNode) */) {
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
                        this.state_ = state = state | 0b10000 /* add-active writeMember(JSObject, String, Object, KeyInfoNode, ImportValueNode, LanguageReference<JavaScriptLanguage>, WriteElementNode) */;
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
                JSNumberObject arg0Value = ((JSNumberObject) arg0Value_);
                int state = state_;
                if ((state & 0b100000) != 0 /* is-active isMemberModifiable(JSObject, String, KeyInfoNode) */) {
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
                    this.state_ = state = state | 0b100000 /* add-active isMemberModifiable(JSObject, String, KeyInfoNode) */;
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
                JSNumberObject arg0Value = ((JSNumberObject) arg0Value_);
                int state = state_;
                if ((state & 0b1000000) != 0 /* is-active isMemberInsertable(JSObject, String, KeyInfoNode) */) {
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
                    this.state_ = state = state | 0b1000000 /* add-active isMemberInsertable(JSObject, String, KeyInfoNode) */;
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
                (((JSNumberObject) receiver)).removeMember(member);
                return;
            }

            @Override
            public boolean isMemberRemovable(Object arg0Value_, String arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSNumberObject arg0Value = ((JSNumberObject) arg0Value_);
                int state = state_;
                if ((state & 0b10000000) != 0 /* is-active isMemberRemovable(JSObject, String, KeyInfoNode) */) {
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
                    this.state_ = state = state | 0b10000000 /* add-active isMemberRemovable(JSObject, String, KeyInfoNode) */;
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
                JSNumberObject arg0Value = ((JSNumberObject) arg0Value_);
                int state = state_;
                if ((state & 0b100000000) != 0 /* is-active invokeMember(JSObject, String, Object[], JavaScriptLanguage, JSRealm, JSInteropInvokeNode, ExportValueNode) */) {
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
                        this.state_ = state = state | 0b100000000 /* add-active invokeMember(JSObject, String, Object[], JavaScriptLanguage, JSRealm, JSInteropInvokeNode, ExportValueNode) */;
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
                JSNumberObject arg0Value = ((JSNumberObject) arg0Value_);
                int state = state_;
                if ((state & 0b1000000000) != 0 /* is-active isMemberInvocable(JSObject, String, KeyInfoNode) */) {
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
                    this.state_ = state = state | 0b1000000000 /* add-active isMemberInvocable(JSObject, String, KeyInfoNode) */;
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
                JSNumberObject arg0Value = ((JSNumberObject) arg0Value_);
                int state = state_;
                if ((state & 0b10000000000) != 0 /* is-active hasMemberReadSideEffects(JSObject, String, KeyInfoNode) */) {
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
                    this.state_ = state = state | 0b10000000000 /* add-active hasMemberReadSideEffects(JSObject, String, KeyInfoNode) */;
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
                JSNumberObject arg0Value = ((JSNumberObject) arg0Value_);
                int state = state_;
                if ((state & 0b100000000000) != 0 /* is-active hasMemberWriteSideEffects(JSObject, String, KeyInfoNode) */) {
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
                    this.state_ = state = state | 0b100000000000 /* add-active hasMemberWriteSideEffects(JSObject, String, KeyInfoNode) */;
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
                return (((JSNumberObject) receiver)).hasLanguage();
            }

            @Override
            public Class<? extends TruffleLanguage<?>> getLanguage(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((JSNumberObject) receiver)).getLanguage();
            }

            @Override
            public Object toDisplayString(Object receiver, boolean allowSideEffects) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((JSNumberObject) receiver)).toDisplayString(allowSideEffects);
            }

            @Override
            public boolean hasMetaObject(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((JSNumberObject) receiver)).hasMetaObject();
            }

            @Override
            public Object getMetaObject(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((JSNumberObject) receiver)).getMetaObject();
            }

            @Override
            public boolean isNumber(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((JSNumberObject) receiver)).isNumber();
            }

            @Override
            public boolean fitsInByte(Object arg0Value_) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                JSNumberObject arg0Value = ((JSNumberObject) arg0Value_);
                int state = state_;
                if ((state & 0b1000000000000) != 0 /* is-active fitsInByte(JSNumberObject, InteropLibrary) */) {
                    return arg0Value.fitsInByte(this.numberLib);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return fitsInByteNode_AndSpecialize(arg0Value);
            }

            private boolean fitsInByteNode_AndSpecialize(JSNumberObject arg0Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                int state = state_;
                try {
                    if (this.numberLib == null) {
                        this.numberLib = super.insert((INTEROP_LIBRARY_.createDispatched(1)));
                    }
                    this.state_ = state = state | 0b1000000000000 /* add-active fitsInByte(JSNumberObject, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.fitsInByte(this.numberLib);
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
                JSNumberObject arg0Value = ((JSNumberObject) arg0Value_);
                int state = state_;
                if ((state & 0b10000000000000) != 0 /* is-active fitsInShort(JSNumberObject, InteropLibrary) */) {
                    return arg0Value.fitsInShort(this.numberLib);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return fitsInShortNode_AndSpecialize(arg0Value);
            }

            private boolean fitsInShortNode_AndSpecialize(JSNumberObject arg0Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                int state = state_;
                try {
                    if (this.numberLib == null) {
                        this.numberLib = super.insert((INTEROP_LIBRARY_.createDispatched(1)));
                    }
                    this.state_ = state = state | 0b10000000000000 /* add-active fitsInShort(JSNumberObject, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.fitsInShort(this.numberLib);
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
                JSNumberObject arg0Value = ((JSNumberObject) arg0Value_);
                int state = state_;
                if ((state & 0b100000000000000) != 0 /* is-active fitsInInt(JSNumberObject, InteropLibrary) */) {
                    return arg0Value.fitsInInt(this.numberLib);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return fitsInIntNode_AndSpecialize(arg0Value);
            }

            private boolean fitsInIntNode_AndSpecialize(JSNumberObject arg0Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                int state = state_;
                try {
                    if (this.numberLib == null) {
                        this.numberLib = super.insert((INTEROP_LIBRARY_.createDispatched(1)));
                    }
                    this.state_ = state = state | 0b100000000000000 /* add-active fitsInInt(JSNumberObject, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.fitsInInt(this.numberLib);
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
                JSNumberObject arg0Value = ((JSNumberObject) arg0Value_);
                int state = state_;
                if ((state & 0b1000000000000000) != 0 /* is-active fitsInLong(JSNumberObject, InteropLibrary) */) {
                    return arg0Value.fitsInLong(this.numberLib);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return fitsInLongNode_AndSpecialize(arg0Value);
            }

            private boolean fitsInLongNode_AndSpecialize(JSNumberObject arg0Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                int state = state_;
                try {
                    if (this.numberLib == null) {
                        this.numberLib = super.insert((INTEROP_LIBRARY_.createDispatched(1)));
                    }
                    this.state_ = state = state | 0b1000000000000000 /* add-active fitsInLong(JSNumberObject, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.fitsInLong(this.numberLib);
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
                JSNumberObject arg0Value = ((JSNumberObject) arg0Value_);
                int state = state_;
                if ((state & 0x10000) != 0 /* is-active fitsInFloat(JSNumberObject, InteropLibrary) */) {
                    return arg0Value.fitsInFloat(this.numberLib);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return fitsInFloatNode_AndSpecialize(arg0Value);
            }

            private boolean fitsInFloatNode_AndSpecialize(JSNumberObject arg0Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                int state = state_;
                try {
                    if (this.numberLib == null) {
                        this.numberLib = super.insert((INTEROP_LIBRARY_.createDispatched(1)));
                    }
                    this.state_ = state = state | 0x10000 /* add-active fitsInFloat(JSNumberObject, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.fitsInFloat(this.numberLib);
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
                JSNumberObject arg0Value = ((JSNumberObject) arg0Value_);
                int state = state_;
                if ((state & 0x20000) != 0 /* is-active fitsInDouble(JSNumberObject, InteropLibrary) */) {
                    return arg0Value.fitsInDouble(this.numberLib);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return fitsInDoubleNode_AndSpecialize(arg0Value);
            }

            private boolean fitsInDoubleNode_AndSpecialize(JSNumberObject arg0Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                int state = state_;
                try {
                    if (this.numberLib == null) {
                        this.numberLib = super.insert((INTEROP_LIBRARY_.createDispatched(1)));
                    }
                    this.state_ = state = state | 0x20000 /* add-active fitsInDouble(JSNumberObject, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.fitsInDouble(this.numberLib);
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
                JSNumberObject arg0Value = ((JSNumberObject) arg0Value_);
                int state = state_;
                if ((state & 0x40000) != 0 /* is-active asByte(JSNumberObject, InteropLibrary) */) {
                    return arg0Value.asByte(this.numberLib);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return asByteNode_AndSpecialize(arg0Value);
            }

            private byte asByteNode_AndSpecialize(JSNumberObject arg0Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                int state = state_;
                try {
                    if (this.numberLib == null) {
                        this.numberLib = super.insert((INTEROP_LIBRARY_.createDispatched(1)));
                    }
                    this.state_ = state = state | 0x40000 /* add-active asByte(JSNumberObject, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.asByte(this.numberLib);
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
                JSNumberObject arg0Value = ((JSNumberObject) arg0Value_);
                int state = state_;
                if ((state & 0x80000) != 0 /* is-active asShort(JSNumberObject, InteropLibrary) */) {
                    return arg0Value.asShort(this.numberLib);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return asShortNode_AndSpecialize(arg0Value);
            }

            private short asShortNode_AndSpecialize(JSNumberObject arg0Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                int state = state_;
                try {
                    if (this.numberLib == null) {
                        this.numberLib = super.insert((INTEROP_LIBRARY_.createDispatched(1)));
                    }
                    this.state_ = state = state | 0x80000 /* add-active asShort(JSNumberObject, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.asShort(this.numberLib);
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
                JSNumberObject arg0Value = ((JSNumberObject) arg0Value_);
                int state = state_;
                if ((state & 0x100000) != 0 /* is-active asInt(JSNumberObject, InteropLibrary) */) {
                    return arg0Value.asInt(this.numberLib);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return asIntNode_AndSpecialize(arg0Value);
            }

            private int asIntNode_AndSpecialize(JSNumberObject arg0Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                int state = state_;
                try {
                    if (this.numberLib == null) {
                        this.numberLib = super.insert((INTEROP_LIBRARY_.createDispatched(1)));
                    }
                    this.state_ = state = state | 0x100000 /* add-active asInt(JSNumberObject, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.asInt(this.numberLib);
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
                JSNumberObject arg0Value = ((JSNumberObject) arg0Value_);
                int state = state_;
                if ((state & 0x200000) != 0 /* is-active asLong(JSNumberObject, InteropLibrary) */) {
                    return arg0Value.asLong(this.numberLib);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return asLongNode_AndSpecialize(arg0Value);
            }

            private long asLongNode_AndSpecialize(JSNumberObject arg0Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                int state = state_;
                try {
                    if (this.numberLib == null) {
                        this.numberLib = super.insert((INTEROP_LIBRARY_.createDispatched(1)));
                    }
                    this.state_ = state = state | 0x200000 /* add-active asLong(JSNumberObject, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.asLong(this.numberLib);
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
                JSNumberObject arg0Value = ((JSNumberObject) arg0Value_);
                int state = state_;
                if ((state & 0x400000) != 0 /* is-active asFloat(JSNumberObject, InteropLibrary) */) {
                    return arg0Value.asFloat(this.numberLib);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return asFloatNode_AndSpecialize(arg0Value);
            }

            private float asFloatNode_AndSpecialize(JSNumberObject arg0Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                int state = state_;
                try {
                    if (this.numberLib == null) {
                        this.numberLib = super.insert((INTEROP_LIBRARY_.createDispatched(1)));
                    }
                    this.state_ = state = state | 0x400000 /* add-active asFloat(JSNumberObject, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.asFloat(this.numberLib);
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
                JSNumberObject arg0Value = ((JSNumberObject) arg0Value_);
                int state = state_;
                if ((state & 0x800000) != 0 /* is-active asDouble(JSNumberObject, InteropLibrary) */) {
                    return arg0Value.asDouble(this.numberLib);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return asDoubleNode_AndSpecialize(arg0Value);
            }

            private double asDoubleNode_AndSpecialize(JSNumberObject arg0Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                int state = state_;
                try {
                    if (this.numberLib == null) {
                        this.numberLib = super.insert((INTEROP_LIBRARY_.createDispatched(1)));
                    }
                    this.state_ = state = state | 0x800000 /* add-active asDouble(JSNumberObject, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.asDouble(this.numberLib);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @GeneratedBy(JSObject.class)
            private static final class GetMembersNonArrayCachedData {

                @CompilationFinal GetMembersNonArrayCachedData next_;
                @CompilationFinal JSClass cachedJSClass_;

                GetMembersNonArrayCachedData(GetMembersNonArrayCachedData next_) {
                    this.next_ = next_;
                }

            }
        }
        @GeneratedBy(JSNumberObject.class)
        private static final class Uncached extends InteropLibrary {

            private final LanguageReference<JavaScriptLanguage> javaScriptLanguageReference_ = lookupLanguageReference(JavaScriptLanguage.class);
            private final ContextReference<JSRealm> javaScriptLanguageContextReference_ = lookupContextReference(JavaScriptLanguage.class);

            Uncached() {
            }

            @TruffleBoundary
            @Override
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof JSNumberObject) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof JSNumberObject;
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
            public Object getMembers(Object arg0Value_, boolean arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSObject arg0Value = ((JSObject) arg0Value_);
                return GetMembers.nonArrayUncached(arg0Value, arg1Value);
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
            public boolean isNumber(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((JSNumberObject) receiver) .isNumber();
            }

            @TruffleBoundary
            @Override
            public boolean fitsInByte(Object arg0Value_) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSNumberObject arg0Value = ((JSNumberObject) arg0Value_);
                return arg0Value.fitsInByte((INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean fitsInShort(Object arg0Value_) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSNumberObject arg0Value = ((JSNumberObject) arg0Value_);
                return arg0Value.fitsInShort((INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean fitsInInt(Object arg0Value_) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSNumberObject arg0Value = ((JSNumberObject) arg0Value_);
                return arg0Value.fitsInInt((INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean fitsInLong(Object arg0Value_) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSNumberObject arg0Value = ((JSNumberObject) arg0Value_);
                return arg0Value.fitsInLong((INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean fitsInFloat(Object arg0Value_) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSNumberObject arg0Value = ((JSNumberObject) arg0Value_);
                return arg0Value.fitsInFloat((INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean fitsInDouble(Object arg0Value_) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSNumberObject arg0Value = ((JSNumberObject) arg0Value_);
                return arg0Value.fitsInDouble((INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public byte asByte(Object arg0Value_) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSNumberObject arg0Value = ((JSNumberObject) arg0Value_);
                return arg0Value.asByte((INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public short asShort(Object arg0Value_) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSNumberObject arg0Value = ((JSNumberObject) arg0Value_);
                return arg0Value.asShort((INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public int asInt(Object arg0Value_) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSNumberObject arg0Value = ((JSNumberObject) arg0Value_);
                return arg0Value.asInt((INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public long asLong(Object arg0Value_) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSNumberObject arg0Value = ((JSNumberObject) arg0Value_);
                return arg0Value.asLong((INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public float asFloat(Object arg0Value_) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSNumberObject arg0Value = ((JSNumberObject) arg0Value_);
                return arg0Value.asFloat((INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public double asDouble(Object arg0Value_) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JSNumberObject arg0Value = ((JSNumberObject) arg0Value_);
                return arg0Value.asDouble((INTEROP_LIBRARY_.getUncached()));
            }

        }
    }
}
