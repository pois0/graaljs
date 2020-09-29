// CheckStyle: start generated
package com.oracle.truffle.js.builtins.helper;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.nodes.access.IsJSClassNode;
import com.oracle.truffle.js.runtime.JSContext;
import com.oracle.truffle.js.runtime.builtins.JSObjectFactory;
import com.oracle.truffle.js.runtime.builtins.JSRegExp;
import com.oracle.truffle.js.runtime.util.TRegexUtil.TRegexCompiledRegexAccessor;
import com.oracle.truffle.js.runtime.util.TRegexUtil.TRegexResultAccessor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(JSRegExpExecIntlNode.class)
public final class JSRegExpExecIntlNodeGen extends JSRegExpExecIntlNode implements Provider {

    private JSRegExpExecIntlNodeGen(JSContext context) {
        super(context);
    }

    @Override
    public Object execute(DynamicObject arg0Value, String arg1Value) {
        return doGeneric(arg0Value, arg1Value);
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
        s[0] = "doGeneric";
        s[1] = (byte)0b01 /* active */;
        data[1] = s;
        return Provider.create(data);
    }

    public static JSRegExpExecIntlNode create(JSContext context) {
        return new JSRegExpExecIntlNodeGen(context);
    }

    @GeneratedBy(JSRegExpExecIntlIgnoreLastIndexNode.class)
    public static final class JSRegExpExecIntlIgnoreLastIndexNodeGen extends JSRegExpExecIntlIgnoreLastIndexNode implements Provider {

        @CompilationFinal private volatile int state_;
        @Child private TRegexCompiledRegexAccessor compiledRegexAccessor_;
        @Child private TRegexResultAccessor regexResultAccessor_;

        private JSRegExpExecIntlIgnoreLastIndexNodeGen(JSContext context, boolean doStaticResultUpdate) {
            super(context, doStaticResultUpdate);
        }

        @Override
        public Object execute(DynamicObject arg0Value, String arg1Value, long arg2Value) {
            int state = state_;
            if ((state & 0b1) != 0 /* is-active doGeneric(DynamicObject, String, long, TRegexCompiledRegexAccessor, TRegexResultAccessor) */) {
                return doGeneric(arg0Value, arg1Value, arg2Value, this.compiledRegexAccessor_, this.regexResultAccessor_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value, arg1Value, arg2Value);
        }

        private Object executeAndSpecialize(DynamicObject arg0Value, String arg1Value, long arg2Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            try {
                this.compiledRegexAccessor_ = super.insert((TRegexCompiledRegexAccessor.create()));
                this.regexResultAccessor_ = super.insert((TRegexResultAccessor.create()));
                this.state_ = state = state | 0b1 /* add-active doGeneric(DynamicObject, String, long, TRegexCompiledRegexAccessor, TRegexResultAccessor) */;
                lock.unlock();
                hasLock = false;
                return doGeneric(arg0Value, arg1Value, arg2Value, this.compiledRegexAccessor_, this.regexResultAccessor_);
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
        public Introspection getIntrospectionData() {
            Object[] data = new Object[2];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "doGeneric";
            if ((state & 0b1) != 0 /* is-active doGeneric(DynamicObject, String, long, TRegexCompiledRegexAccessor, TRegexResultAccessor) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.compiledRegexAccessor_, this.regexResultAccessor_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            return Provider.create(data);
        }

        public static JSRegExpExecIntlIgnoreLastIndexNode create(JSContext context, boolean doStaticResultUpdate) {
            return new JSRegExpExecIntlIgnoreLastIndexNodeGen(context, doStaticResultUpdate);
        }

    }
    @GeneratedBy(BuildGroupsObjectNode.class)
    public static final class BuildGroupsObjectNodeGen extends BuildGroupsObjectNode implements Provider {

        @CompilationFinal private volatile int state_;
        @Child private CachedGroupsFactoryData cachedGroupsFactory_cache;

        private BuildGroupsObjectNodeGen() {
        }

        @ExplodeLoop
        @Override
        public DynamicObject execute(JSContext arg0Value, DynamicObject arg1Value, Object arg2Value, String arg3Value, boolean arg4Value) {
            int state = state_;
            if ((state & 0b11) != 0 /* is-active doCachedGroupsFactory(JSContext, DynamicObject, Object, String, boolean, Object, JSObjectFactory, IsJSClassNode) || doVaryingGroupsFactory(JSContext, DynamicObject, Object, String, boolean) */) {
                if ((state & 0b1) != 0 /* is-active doCachedGroupsFactory(JSContext, DynamicObject, Object, String, boolean, Object, JSObjectFactory, IsJSClassNode) */) {
                    CachedGroupsFactoryData s1_ = this.cachedGroupsFactory_cache;
                    while (s1_ != null) {
                        if ((JSRegExp.getGroupsFactory(arg1Value) == s1_.cachedGroupsFactory_ || JSRegExp.getCompiledRegex(arg1Value) == s1_.cachedCompiledRegex_)) {
                            return BuildGroupsObjectNode.doCachedGroupsFactory(arg0Value, arg1Value, arg2Value, arg3Value, arg4Value, s1_.cachedCompiledRegex_, s1_.cachedGroupsFactory_, s1_.isJSRegExpNode_);
                        }
                        s1_ = s1_.next_;
                    }
                }
                if ((state & 0b10) != 0 /* is-active doVaryingGroupsFactory(JSContext, DynamicObject, Object, String, boolean) */) {
                    return BuildGroupsObjectNode.doVaryingGroupsFactory(arg0Value, arg1Value, arg2Value, arg3Value, arg4Value);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value, arg1Value, arg2Value, arg3Value, arg4Value);
        }

        private DynamicObject executeAndSpecialize(JSContext arg0Value, DynamicObject arg1Value, Object arg2Value, String arg3Value, boolean arg4Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            try {
                int count1_ = 0;
                CachedGroupsFactoryData s1_ = this.cachedGroupsFactory_cache;
                if ((state & 0b1) != 0 /* is-active doCachedGroupsFactory(JSContext, DynamicObject, Object, String, boolean, Object, JSObjectFactory, IsJSClassNode) */) {
                    while (s1_ != null) {
                        if ((JSRegExp.getGroupsFactory(arg1Value) == s1_.cachedGroupsFactory_ || JSRegExp.getCompiledRegex(arg1Value) == s1_.cachedCompiledRegex_)) {
                            break;
                        }
                        s1_ = s1_.next_;
                        count1_++;
                    }
                }
                if (s1_ == null) {
                    {
                        Object cachedCompiledRegex__ = (JSRegExp.getCompiledRegex(arg1Value));
                        JSObjectFactory cachedGroupsFactory__ = (JSRegExp.getGroupsFactory(arg1Value));
                        if ((JSRegExp.getGroupsFactory(arg1Value) == cachedGroupsFactory__ || JSRegExp.getCompiledRegex(arg1Value) == cachedCompiledRegex__) && count1_ < (3)) {
                            s1_ = super.insert(new CachedGroupsFactoryData(cachedGroupsFactory_cache));
                            s1_.cachedCompiledRegex_ = cachedCompiledRegex__;
                            s1_.cachedGroupsFactory_ = cachedGroupsFactory__;
                            s1_.isJSRegExpNode_ = s1_.insertAccessor((JSRegExpExecIntlNode.createIsJSRegExpNode()));
                            this.cachedGroupsFactory_cache = s1_;
                            this.state_ = state = state | 0b1 /* add-active doCachedGroupsFactory(JSContext, DynamicObject, Object, String, boolean, Object, JSObjectFactory, IsJSClassNode) */;
                        }
                    }
                }
                if (s1_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return BuildGroupsObjectNode.doCachedGroupsFactory(arg0Value, arg1Value, arg2Value, arg3Value, arg4Value, s1_.cachedCompiledRegex_, s1_.cachedGroupsFactory_, s1_.isJSRegExpNode_);
                }
                this.state_ = state = state | 0b10 /* add-active doVaryingGroupsFactory(JSContext, DynamicObject, Object, String, boolean) */;
                lock.unlock();
                hasLock = false;
                return BuildGroupsObjectNode.doVaryingGroupsFactory(arg0Value, arg1Value, arg2Value, arg3Value, arg4Value);
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
                CachedGroupsFactoryData s1_ = this.cachedGroupsFactory_cache;
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
            s = new Object[3];
            s[0] = "doCachedGroupsFactory";
            if ((state & 0b1) != 0 /* is-active doCachedGroupsFactory(JSContext, DynamicObject, Object, String, boolean, Object, JSObjectFactory, IsJSClassNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                CachedGroupsFactoryData s1_ = this.cachedGroupsFactory_cache;
                while (s1_ != null) {
                    cached.add(Arrays.asList(s1_.cachedCompiledRegex_, s1_.cachedGroupsFactory_, s1_.isJSRegExpNode_));
                    s1_ = s1_.next_;
                }
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doVaryingGroupsFactory";
            if ((state & 0b10) != 0 /* is-active doVaryingGroupsFactory(JSContext, DynamicObject, Object, String, boolean) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static BuildGroupsObjectNode create() {
            return new BuildGroupsObjectNodeGen();
        }

        @GeneratedBy(BuildGroupsObjectNode.class)
        private static final class CachedGroupsFactoryData extends Node {

            @Child CachedGroupsFactoryData next_;
            @CompilationFinal Object cachedCompiledRegex_;
            @CompilationFinal JSObjectFactory cachedGroupsFactory_;
            @Child IsJSClassNode isJSRegExpNode_;

            CachedGroupsFactoryData(CachedGroupsFactoryData next_) {
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
    @GeneratedBy(JSRegExpExecBuiltinNode.class)
    public static final class JSRegExpExecBuiltinNodeGen extends JSRegExpExecBuiltinNode implements Provider {

        @CompilationFinal private volatile int state_;
        @CompilationFinal private volatile int exclude_;
        @CompilationFinal private CachedData cached_cache;

        private JSRegExpExecBuiltinNodeGen(JSContext context) {
            super(context);
        }

        @ExplodeLoop
        @Override
        public Object execute(DynamicObject arg0Value, String arg1Value) {
            int state = state_;
            if ((state & 0b11) != 0 /* is-active doCached(DynamicObject, String, Object) || doDynamic(DynamicObject, String) */) {
                if ((state & 0b1) != 0 /* is-active doCached(DynamicObject, String, Object) */) {
                    CachedData s1_ = this.cached_cache;
                    while (s1_ != null) {
                        if ((JSRegExp.getCompiledRegex(arg0Value) == s1_.cachedCompiledRegex_)) {
                            return doCached(arg0Value, arg1Value, s1_.cachedCompiledRegex_);
                        }
                        s1_ = s1_.next_;
                    }
                }
                if ((state & 0b10) != 0 /* is-active doDynamic(DynamicObject, String) */) {
                    return doDynamic(arg0Value, arg1Value);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value, arg1Value);
        }

        private Object executeAndSpecialize(DynamicObject arg0Value, String arg1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int exclude = exclude_;
            try {
                if ((exclude) == 0 /* is-not-excluded doCached(DynamicObject, String, Object) */) {
                    int count1_ = 0;
                    CachedData s1_ = this.cached_cache;
                    if ((state & 0b1) != 0 /* is-active doCached(DynamicObject, String, Object) */) {
                        while (s1_ != null) {
                            if ((JSRegExp.getCompiledRegex(arg0Value) == s1_.cachedCompiledRegex_)) {
                                break;
                            }
                            s1_ = s1_.next_;
                            count1_++;
                        }
                    }
                    if (s1_ == null) {
                        {
                            Object cachedCompiledRegex__ = (JSRegExp.getCompiledRegex(arg0Value));
                            if ((JSRegExp.getCompiledRegex(arg0Value) == cachedCompiledRegex__) && count1_ < (3)) {
                                s1_ = new CachedData(cached_cache);
                                s1_.cachedCompiledRegex_ = cachedCompiledRegex__;
                                this.cached_cache = s1_;
                                this.state_ = state = state | 0b1 /* add-active doCached(DynamicObject, String, Object) */;
                            }
                        }
                    }
                    if (s1_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return doCached(arg0Value, arg1Value, s1_.cachedCompiledRegex_);
                    }
                }
                this.exclude_ = exclude = exclude | 0b1 /* add-excluded doCached(DynamicObject, String, Object) */;
                this.cached_cache = null;
                state = state & 0xfffffffe /* remove-active doCached(DynamicObject, String, Object) */;
                this.state_ = state = state | 0b10 /* add-active doDynamic(DynamicObject, String) */;
                lock.unlock();
                hasLock = false;
                return doDynamic(arg0Value, arg1Value);
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
            if ((state & 0b1) != 0 /* is-active doCached(DynamicObject, String, Object) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                CachedData s1_ = this.cached_cache;
                while (s1_ != null) {
                    cached.add(Arrays.asList(s1_.cachedCompiledRegex_));
                    s1_ = s1_.next_;
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-excluded doCached(DynamicObject, String, Object) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doDynamic";
            if ((state & 0b10) != 0 /* is-active doDynamic(DynamicObject, String) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static JSRegExpExecBuiltinNode create(JSContext context) {
            return new JSRegExpExecBuiltinNodeGen(context);
        }

        @GeneratedBy(JSRegExpExecBuiltinNode.class)
        private static final class CachedData {

            @CompilationFinal CachedData next_;
            @CompilationFinal Object cachedCompiledRegex_;

            CachedData(CachedData next_) {
                this.next_ = next_;
            }

        }
    }
}
