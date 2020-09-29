// CheckStyle: start generated
package com.oracle.truffle.js.nodes;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.js.runtime.JSConfig;
import com.oracle.truffle.js.runtime.JSContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(CompileRegexNode.class)
public final class CompileRegexNodeGen extends CompileRegexNode implements Provider {

    @CompilationFinal private volatile int state_;
    @CompilationFinal private volatile int exclude_;
    @CompilationFinal private GetCachedData getCached_cache;

    private CompileRegexNodeGen(JSContext context) {
        super(context);
    }

    @ExplodeLoop
    @Override
    protected Object executeCompile(CharSequence arg0Value, String arg1Value) {
        int state = state_;
        if ((state & 0b111) != 0 /* is-active getCached(String, String, String, String, Object) || doCompileNoTrimCache(String, String) || doCompile(String, String) */ && JSTypesGen.isImplicitString((state & 0b1111000) >>> 3 /* extract-implicit-active 0:String */, arg0Value)) {
            String arg0Value_ = JSTypesGen.asImplicitString((state & 0b1111000) >>> 3 /* extract-implicit-active 0:String */, arg0Value);
            if ((state & 0b1) != 0 /* is-active getCached(String, String, String, String, Object) */) {
                GetCachedData s1_ = this.getCached_cache;
                while (s1_ != null) {
                    if ((CompileRegexNode.stringEquals(arg0Value_, s1_.cachedPattern_)) && (CompileRegexNode.stringEquals(arg1Value, s1_.cachedFlags_))) {
                        return getCached(arg0Value_, arg1Value, s1_.cachedPattern_, s1_.cachedFlags_, s1_.cachedCompiledRegex_);
                    }
                    s1_ = s1_.next_;
                }
            }
            if ((state & 0b10) != 0 /* is-active doCompileNoTrimCache(String, String) */) {
                assert (!(JSConfig.TrimCompiledRegexCache));
                return doCompileNoTrimCache(arg0Value_, arg1Value);
            }
            if ((state & 0b100) != 0 /* is-active doCompile(String, String) */) {
                return doCompile(arg0Value_, arg1Value);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value);
    }

    private Object executeAndSpecialize(CharSequence arg0Value, String arg1Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        int exclude = exclude_;
        int oldState = (state & 0b111);
        try {
            {
                int stringCast0;
                if ((stringCast0 = JSTypesGen.specializeImplicitString(arg0Value)) != 0) {
                    String arg0Value_ = JSTypesGen.asImplicitString(stringCast0, arg0Value);
                    if ((exclude) == 0 /* is-not-excluded getCached(String, String, String, String, Object) */) {
                        int count1_ = 0;
                        GetCachedData s1_ = this.getCached_cache;
                        if ((state & 0b1) != 0 /* is-active getCached(String, String, String, String, Object) */) {
                            while (s1_ != null) {
                                if ((CompileRegexNode.stringEquals(arg0Value_, s1_.cachedPattern_)) && (CompileRegexNode.stringEquals(arg1Value, s1_.cachedFlags_))) {
                                    break;
                                }
                                s1_ = s1_.next_;
                                count1_++;
                            }
                        }
                        if (s1_ == null) {
                            {
                                String cachedPattern__ = (arg0Value_);
                                if ((CompileRegexNode.stringEquals(arg0Value_, cachedPattern__))) {
                                    String cachedFlags__ = (arg1Value);
                                    if ((CompileRegexNode.stringEquals(arg1Value, cachedFlags__)) && count1_ < (JSConfig.MaxCompiledRegexCacheLength)) {
                                        s1_ = new GetCachedData(getCached_cache);
                                        s1_.cachedPattern_ = cachedPattern__;
                                        s1_.cachedFlags_ = cachedFlags__;
                                        s1_.cachedCompiledRegex_ = (doCompile(arg0Value_, arg1Value));
                                        this.getCached_cache = s1_;
                                        state = (state | (stringCast0 << 3) /* set-implicit-active 0:String */);
                                        this.state_ = state = state | 0b1 /* add-active getCached(String, String, String, String, Object) */;
                                    }
                                }
                            }
                        } else {
                            state = (state | (stringCast0 << 3) /* set-implicit-active 0:String */);
                            this.state_ = state = state | 0b1 /* add-active getCached(String, String, String, String, Object) */;
                        }
                        if (s1_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return getCached(arg0Value_, arg1Value, s1_.cachedPattern_, s1_.cachedFlags_, s1_.cachedCompiledRegex_);
                        }
                    }
                    if ((!(JSConfig.TrimCompiledRegexCache))) {
                        state = (state | (stringCast0 << 3) /* set-implicit-active 0:String */);
                        this.state_ = state = state | 0b10 /* add-active doCompileNoTrimCache(String, String) */;
                        lock.unlock();
                        hasLock = false;
                        return doCompileNoTrimCache(arg0Value_, arg1Value);
                    }
                    this.exclude_ = exclude = exclude | 0b1 /* add-excluded getCached(String, String, String, String, Object) */;
                    this.getCached_cache = null;
                    state = state & 0xfffffffe /* remove-active getCached(String, String, String, String, Object) */;
                    state = (state | (stringCast0 << 3) /* set-implicit-active 0:String */);
                    this.state_ = state = state | 0b100 /* add-active doCompile(String, String) */;
                    lock.unlock();
                    hasLock = false;
                    return doCompile(arg0Value_, arg1Value);
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
        int megamorphicMask = 0b100;
        int megamorphicState = (this.state_ & 0b100);
        if ((((oldState & megamorphicMask) == 0) && (megamorphicState != 0))) {
            this.reportPolymorphicSpecialize();
        }
    }

    @Override
    public NodeCost getCost() {
        int state = state_;
        if ((state & 0b111) == 0b0) {
            return NodeCost.UNINITIALIZED;
        } else if (((state & 0b111) & ((state & 0b111) - 1)) == 0 /* is-single-active  */) {
            GetCachedData s1_ = this.getCached_cache;
            if ((s1_ == null || s1_.next_ == null)) {
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
        s[0] = "getCached";
        if ((state & 0b1) != 0 /* is-active getCached(String, String, String, String, Object) */) {
            s[1] = (byte)0b01 /* active */;
            ArrayList<Object> cached = new ArrayList<>();
            GetCachedData s1_ = this.getCached_cache;
            while (s1_ != null) {
                cached.add(Arrays.asList(s1_.cachedPattern_, s1_.cachedFlags_, s1_.cachedCompiledRegex_));
                s1_ = s1_.next_;
            }
            s[2] = cached;
        } else if (exclude != 0 /* is-excluded getCached(String, String, String, String, Object) */) {
            s[1] = (byte)0b10 /* excluded */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doCompileNoTrimCache";
        if ((state & 0b10) != 0 /* is-active doCompileNoTrimCache(String, String) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doCompile";
        if ((state & 0b100) != 0 /* is-active doCompile(String, String) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        return Provider.create(data);
    }

    public static CompileRegexNode create(JSContext context) {
        return new CompileRegexNodeGen(context);
    }

    @GeneratedBy(CompileRegexNode.class)
    private static final class GetCachedData {

        @CompilationFinal GetCachedData next_;
        @CompilationFinal String cachedPattern_;
        @CompilationFinal String cachedFlags_;
        @CompilationFinal Object cachedCompiledRegex_;

        GetCachedData(GetCachedData next_) {
            this.next_ = next_;
        }

    }
}
