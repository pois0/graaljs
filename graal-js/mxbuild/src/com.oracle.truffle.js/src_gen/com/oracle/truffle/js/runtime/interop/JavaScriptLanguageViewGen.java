// CheckStyle: start generated
package com.oracle.truffle.js.runtime.interop;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.library.DynamicDispatchLibrary;
import com.oracle.truffle.api.library.Library;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.utilities.FinalBitSet;

@GeneratedBy(JavaScriptLanguageView.class)
final class JavaScriptLanguageViewGen {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);
    private static final LibraryFactory<DynamicDispatchLibrary> DYNAMIC_DISPATCH_LIBRARY_ = LibraryFactory.resolve(DynamicDispatchLibrary.class);

    static  {
        LibraryExport.register(JavaScriptLanguageView.class, new InteropLibraryExports());
    }

    private JavaScriptLanguageViewGen() {
    }

    @GeneratedBy(JavaScriptLanguageView.class)
    private static final class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        static final FinalBitSet ENABLED_MESSAGES = createMessageBitSet(INTEROP_LIBRARY_, "hasLanguage", "getLanguage", "toDisplayString", "hasMetaObject", "getMetaObject");
        private static final Uncached UNCACHED = new Uncached();

        private InteropLibraryExports() {
            super(InteropLibrary.class, JavaScriptLanguageView.class, false);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof JavaScriptLanguageView;
            InteropLibrary uncached = createDelegate(INTEROP_LIBRARY_, InteropLibraryExports.UNCACHED);
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof JavaScriptLanguageView;
            return createDelegate(INTEROP_LIBRARY_, new Cached(receiver));
        }

        @GeneratedBy(JavaScriptLanguageView.class)
        private static final class Cached extends InteropLibrary implements DelegateExport {

            @Child private InteropLibrary receiverDelegateInteropLibrary_;

            Cached(Object originalReceiver) {
                JavaScriptLanguageView receiver = ((JavaScriptLanguageView) originalReceiver) ;
                this.receiverDelegateInteropLibrary_ = super.insert(INTEROP_LIBRARY_.create((receiver.delegate)));
            }

            @Override
            public FinalBitSet getDelegateExportMessages() {
                return ENABLED_MESSAGES;
            }

            @Override
            public Object readDelegateExport(Object receiver_) {
                return ((JavaScriptLanguageView) receiver_).delegate;
            }

            @Override
            public Library getDelegateExportLibrary(Object delegate) {
                return this.receiverDelegateInteropLibrary_;
            }

            @Override
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof JavaScriptLanguageView) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                if (!(receiver instanceof JavaScriptLanguageView)) {
                    return false;
                } else if (!this.receiverDelegateInteropLibrary_.accepts((((JavaScriptLanguageView) receiver).delegate))) {
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public boolean hasLanguage(Object receiver) {
                assert receiver instanceof JavaScriptLanguageView : "Invalid library usage. Library does not accept given receiver.";
                return (((JavaScriptLanguageView) receiver)).hasLanguage();
            }

            @Override
            public Class<? extends TruffleLanguage<?>> getLanguage(Object receiver) throws UnsupportedMessageException {
                assert receiver instanceof JavaScriptLanguageView : "Invalid library usage. Library does not accept given receiver.";
                return (((JavaScriptLanguageView) receiver)).getLanguage();
            }

            @Override
            public Object toDisplayString(Object receiver, boolean allowSideEffects) {
                assert receiver instanceof JavaScriptLanguageView : "Invalid library usage. Library does not accept given receiver.";
                return (((JavaScriptLanguageView) receiver)).toDisplayString(allowSideEffects);
            }

            @Override
            public boolean hasMetaObject(Object arg0Value_) {
                assert arg0Value_ instanceof JavaScriptLanguageView : "Invalid library usage. Library does not accept given receiver.";
                JavaScriptLanguageView arg0Value = ((JavaScriptLanguageView) arg0Value_);
                {
                    InteropLibrary hasMetaObjectNode__delegateLibrary__ = this.receiverDelegateInteropLibrary_;
                    return arg0Value.hasMetaObject(hasMetaObjectNode__delegateLibrary__);
                }
            }

            @Override
            public NodeCost getCost() {
                return NodeCost.MONOMORPHIC;
            }

            @Override
            public Object getMetaObject(Object arg0Value_) throws UnsupportedMessageException {
                assert arg0Value_ instanceof JavaScriptLanguageView : "Invalid library usage. Library does not accept given receiver.";
                JavaScriptLanguageView arg0Value = ((JavaScriptLanguageView) arg0Value_);
                {
                    InteropLibrary getMetaObjectNode__delegateLibrary__ = this.receiverDelegateInteropLibrary_;
                    return arg0Value.getMetaObject(getMetaObjectNode__delegateLibrary__);
                }
            }

        }
        @GeneratedBy(JavaScriptLanguageView.class)
        private static final class Uncached extends InteropLibrary implements DelegateExport {

            Uncached() {
            }

            @Override
            public FinalBitSet getDelegateExportMessages() {
                return ENABLED_MESSAGES;
            }

            @Override
            public Object readDelegateExport(Object receiver_) {
                return (((JavaScriptLanguageView) receiver_)).delegate;
            }

            @Override
            public Library getDelegateExportLibrary(Object delegate_) {
                return INTEROP_LIBRARY_.getUncached(delegate_);
            }

            @TruffleBoundary
            @Override
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof JavaScriptLanguageView) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof JavaScriptLanguageView;
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
            public boolean hasLanguage(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((JavaScriptLanguageView) receiver) .hasLanguage();
            }

            @TruffleBoundary
            @Override
            public Class<? extends TruffleLanguage<?>> getLanguage(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((JavaScriptLanguageView) receiver) .getLanguage();
            }

            @TruffleBoundary
            @Override
            public Object toDisplayString(Object receiver, boolean allowSideEffects) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((JavaScriptLanguageView) receiver) .toDisplayString(allowSideEffects);
            }

            @TruffleBoundary
            @Override
            public boolean hasMetaObject(Object arg0Value_) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JavaScriptLanguageView arg0Value = ((JavaScriptLanguageView) arg0Value_);
                return arg0Value.hasMetaObject(INTEROP_LIBRARY_.getUncached((arg0Value.delegate)));
            }

            @TruffleBoundary
            @Override
            public Object getMetaObject(Object arg0Value_) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                JavaScriptLanguageView arg0Value = ((JavaScriptLanguageView) arg0Value_);
                return arg0Value.getMetaObject(INTEROP_LIBRARY_.getUncached((arg0Value.delegate)));
            }

        }
    }
}
