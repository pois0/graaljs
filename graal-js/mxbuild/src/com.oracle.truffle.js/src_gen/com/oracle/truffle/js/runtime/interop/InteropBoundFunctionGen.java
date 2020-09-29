// CheckStyle: start generated
package com.oracle.truffle.js.runtime.interop;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.TruffleLanguage.ContextReference;
import com.oracle.truffle.api.TruffleLanguage.LanguageReference;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.interop.ArityException;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.interop.UnsupportedTypeException;
import com.oracle.truffle.api.library.DynamicDispatchLibrary;
import com.oracle.truffle.api.library.Library;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.utilities.FinalBitSet;
import com.oracle.truffle.js.lang.JavaScriptLanguage;
import com.oracle.truffle.js.nodes.interop.ExportValueNode;
import com.oracle.truffle.js.nodes.interop.ExportValueNodeGen;
import com.oracle.truffle.js.nodes.interop.JSInteropExecuteNode;
import com.oracle.truffle.js.nodes.interop.JSInteropExecuteNodeGen;
import com.oracle.truffle.js.runtime.JSRealm;
import java.util.concurrent.locks.Lock;

@GeneratedBy(InteropBoundFunction.class)
final class InteropBoundFunctionGen {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);
    private static final LibraryFactory<DynamicDispatchLibrary> DYNAMIC_DISPATCH_LIBRARY_ = LibraryFactory.resolve(DynamicDispatchLibrary.class);

    static  {
        LibraryExport.register(InteropBoundFunction.class, new InteropLibraryExports());
    }

    private InteropBoundFunctionGen() {
    }

    @GeneratedBy(InteropBoundFunction.class)
    private static final class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        static final FinalBitSet ENABLED_MESSAGES = createMessageBitSet(INTEROP_LIBRARY_, "isExecutable", "execute");

        private InteropLibraryExports() {
            super(InteropLibrary.class, InteropBoundFunction.class, false);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof InteropBoundFunction;
            InteropLibrary uncached = createDelegate(INTEROP_LIBRARY_, new Uncached());
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof InteropBoundFunction;
            return createDelegate(INTEROP_LIBRARY_, new Cached(receiver));
        }

        @GeneratedBy(InteropBoundFunction.class)
        private static final class Cached extends InteropLibrary implements DelegateExport {

            @Child private InteropLibrary receiverFunctionInteropLibrary_;
            @CompilationFinal private volatile int state_;
            @CompilationFinal private LanguageReference<JavaScriptLanguage> javaScriptLanguageReference_;
            @CompilationFinal private ContextReference<JSRealm> javaScriptLanguageContextReference_;
            @Child private JSInteropExecuteNode executeNode__callNode_;
            @Child private ExportValueNode executeNode__exportNode_;

            Cached(Object originalReceiver) {
                InteropBoundFunction receiver = ((InteropBoundFunction) originalReceiver) ;
                this.receiverFunctionInteropLibrary_ = super.insert(INTEROP_LIBRARY_.create((receiver.function)));
            }

            @Override
            public FinalBitSet getDelegateExportMessages() {
                return ENABLED_MESSAGES;
            }

            @Override
            public Object readDelegateExport(Object receiver_) {
                return ((InteropBoundFunction) receiver_).function;
            }

            @Override
            public Library getDelegateExportLibrary(Object delegate) {
                return this.receiverFunctionInteropLibrary_;
            }

            @Override
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof InteropBoundFunction) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                if (!(receiver instanceof InteropBoundFunction)) {
                    return false;
                } else if (!this.receiverFunctionInteropLibrary_.accepts((((InteropBoundFunction) receiver).function))) {
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public boolean isExecutable(Object receiver) {
                assert receiver instanceof InteropBoundFunction : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((InteropBoundFunction) receiver)).isExecutable();
            }

            @Override
            public Object execute(Object arg0Value_, Object... arg1Value) throws UnsupportedTypeException, ArityException, UnsupportedMessageException {
                assert arg0Value_ instanceof InteropBoundFunction : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                InteropBoundFunction arg0Value = ((InteropBoundFunction) arg0Value_);
                int state = state_;
                if (state != 0 /* is-active execute(InteropBoundFunction, Object[], JavaScriptLanguage, JSRealm, JSInteropExecuteNode, ExportValueNode) */) {
                    {
                        LanguageReference<JavaScriptLanguage> javaScriptLanguageReference__ = this.javaScriptLanguageReference_;
                        JavaScriptLanguage executeNode__language__ = javaScriptLanguageReference__.get();
                        ContextReference<JSRealm> javaScriptLanguageContextReference__ = this.javaScriptLanguageContextReference_;
                        JSRealm executeNode__realm__ = javaScriptLanguageContextReference__.get();
                        return arg0Value.execute(arg1Value, executeNode__language__, executeNode__realm__, this.executeNode__callNode_, this.executeNode__exportNode_);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return executeNode_AndSpecialize(arg0Value, arg1Value);
            }

            private Object executeNode_AndSpecialize(InteropBoundFunction arg0Value, Object[] arg1Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                int state = state_;
                try {
                    {
                        JSRealm executeNode__realm__ = null;
                        JavaScriptLanguage executeNode__language__ = null;
                        LanguageReference<JavaScriptLanguage> javaScriptLanguageReference__1 = this.javaScriptLanguageReference_;
                        if (javaScriptLanguageReference__1 == null) {
                            this.javaScriptLanguageReference_ = javaScriptLanguageReference__1 = super.lookupLanguageReference(JavaScriptLanguage.class);
                        }
                        executeNode__language__ = javaScriptLanguageReference__1.get();
                        ContextReference<JSRealm> javaScriptLanguageContextReference__1 = this.javaScriptLanguageContextReference_;
                        if (javaScriptLanguageContextReference__1 == null) {
                            this.javaScriptLanguageContextReference_ = javaScriptLanguageContextReference__1 = super.lookupContextReference(JavaScriptLanguage.class);
                        }
                        executeNode__realm__ = javaScriptLanguageContextReference__1.get();
                        this.executeNode__callNode_ = super.insert((JSInteropExecuteNodeGen.create()));
                        this.executeNode__exportNode_ = super.insert((ExportValueNode.create()));
                        this.state_ = state = state | 0b1 /* add-active execute(InteropBoundFunction, Object[], JavaScriptLanguage, JSRealm, JSInteropExecuteNode, ExportValueNode) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.execute(arg1Value, executeNode__language__, executeNode__realm__, this.executeNode__callNode_, this.executeNode__exportNode_);
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
                if (state == 0b0) {
                    return NodeCost.UNINITIALIZED;
                } else {
                    return NodeCost.MONOMORPHIC;
                }
            }

        }
        @GeneratedBy(InteropBoundFunction.class)
        private static final class Uncached extends InteropLibrary implements DelegateExport {

            private final LanguageReference<JavaScriptLanguage> javaScriptLanguageReference_ = lookupLanguageReference(JavaScriptLanguage.class);
            private final ContextReference<JSRealm> javaScriptLanguageContextReference_ = lookupContextReference(JavaScriptLanguage.class);

            Uncached() {
            }

            @Override
            public FinalBitSet getDelegateExportMessages() {
                return ENABLED_MESSAGES;
            }

            @Override
            public Object readDelegateExport(Object receiver_) {
                return (((InteropBoundFunction) receiver_)).function;
            }

            @Override
            public Library getDelegateExportLibrary(Object delegate_) {
                return INTEROP_LIBRARY_.getUncached(delegate_);
            }

            @TruffleBoundary
            @Override
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof InteropBoundFunction) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof InteropBoundFunction;
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
            public boolean isExecutable(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((InteropBoundFunction) receiver) .isExecutable();
            }

            @TruffleBoundary
            @Override
            public Object execute(Object arg0Value_, Object... arg1Value) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                InteropBoundFunction arg0Value = ((InteropBoundFunction) arg0Value_);
                return arg0Value.execute(arg1Value, this.javaScriptLanguageReference_.get(), this.javaScriptLanguageContextReference_.get(), (JSInteropExecuteNodeGen.getUncached()), (ExportValueNodeGen.getUncached()));
            }

        }
    }
}
