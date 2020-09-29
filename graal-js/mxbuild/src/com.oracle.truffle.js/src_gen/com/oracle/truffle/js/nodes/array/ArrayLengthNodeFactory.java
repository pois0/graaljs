// CheckStyle: start generated
package com.oracle.truffle.js.nodes.array;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.array.ArrayLengthNode.ArrayLengthReadNode;
import com.oracle.truffle.js.nodes.array.ArrayLengthNode.SetArrayLengthNode;
import com.oracle.truffle.js.nodes.array.ArrayLengthNode.SetArrayLengthOrDeleteNode;
import com.oracle.truffle.js.runtime.array.ScriptArray;
import com.oracle.truffle.js.runtime.array.ScriptArray.ProfileHolder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(ArrayLengthNode.class)
public final class ArrayLengthNodeFactory {

    @GeneratedBy(ArrayLengthReadNode.class)
    public static final class ArrayLengthReadNodeGen extends ArrayLengthReadNode implements Provider {

        @CompilationFinal private volatile int state_;
        @CompilationFinal private volatile int exclude_;
        @CompilationFinal private IntLengthData intLength_cache;
        @CompilationFinal private LongLengthData longLength_cache;

        private ArrayLengthReadNodeGen() {
        }

        @ExplodeLoop
        @Override
        public Object executeObject(DynamicObject arg0Value) {
            int state = state_;
            if (state != 0 /* is-active doIntLength(DynamicObject, ScriptArray) || doLongLength(DynamicObject, ScriptArray) || doUncachedIntLength(DynamicObject) || doUncachedLongLength(DynamicObject) */) {
                if ((state & 0b1) != 0 /* is-active doIntLength(DynamicObject, ScriptArray) */) {
                    IntLengthData s1_ = this.intLength_cache;
                    while (s1_ != null) {
                        if ((s1_.arrayType_.isInstance(ArrayLengthNode.getArrayType(arg0Value)))) {
                            assert (s1_.arrayType_.isStatelessType());
                            assert (ArrayLengthReadNode.isLengthAlwaysInt(s1_.arrayType_));
                            return ArrayLengthReadNode.doIntLength(arg0Value, s1_.arrayType_);
                        }
                        s1_ = s1_.next_;
                    }
                }
                if ((state & 0b10) != 0 /* is-active doLongLength(DynamicObject, ScriptArray) */) {
                    LongLengthData s2_ = this.longLength_cache;
                    while (s2_ != null) {
                        if ((s2_.arrayType_.isInstance(ArrayLengthNode.getArrayType(arg0Value)))) {
                            assert (s2_.arrayType_.isStatelessType());
                            return ArrayLengthReadNode.doLongLength(arg0Value, s2_.arrayType_);
                        }
                        s2_ = s2_.next_;
                    }
                }
                if ((state & 0b100) != 0 /* is-active doUncachedIntLength(DynamicObject) */) {
                    try {
                        return ArrayLengthReadNode.doUncachedIntLength(arg0Value);
                    } catch (UnexpectedResultException ex) {
                        // implicit transferToInterpreterAndInvalidate()
                        Lock lock = getLock();
                        lock.lock();
                        try {
                            this.exclude_ = this.exclude_ | 0b100 /* add-excluded doUncachedIntLength(DynamicObject) */;
                            this.state_ = this.state_ & 0xfffffffb /* remove-active doUncachedIntLength(DynamicObject) */;
                        } finally {
                            lock.unlock();
                        }
                        return ex.getResult();
                    }
                }
                if ((state & 0b1000) != 0 /* is-active doUncachedLongLength(DynamicObject) */) {
                    return ArrayLengthReadNode.doUncachedLongLength(arg0Value);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value);
        }

        @ExplodeLoop
        @Override
        public int executeInt(DynamicObject arg0Value) throws UnexpectedResultException {
            int state = state_;
            if ((state & 0b101) != 0 /* is-active doIntLength(DynamicObject, ScriptArray) || doUncachedIntLength(DynamicObject) */) {
                if ((state & 0b1) != 0 /* is-active doIntLength(DynamicObject, ScriptArray) */) {
                    IntLengthData s1_ = this.intLength_cache;
                    while (s1_ != null) {
                        if ((s1_.arrayType_.isInstance(ArrayLengthNode.getArrayType(arg0Value)))) {
                            assert (s1_.arrayType_.isStatelessType());
                            assert (ArrayLengthReadNode.isLengthAlwaysInt(s1_.arrayType_));
                            return ArrayLengthReadNode.doIntLength(arg0Value, s1_.arrayType_);
                        }
                        s1_ = s1_.next_;
                    }
                }
                if ((state & 0b100) != 0 /* is-active doUncachedIntLength(DynamicObject) */) {
                    try {
                        return ArrayLengthReadNode.doUncachedIntLength(arg0Value);
                    } catch (UnexpectedResultException ex) {
                        // implicit transferToInterpreterAndInvalidate()
                        Lock lock = getLock();
                        lock.lock();
                        try {
                            this.exclude_ = this.exclude_ | 0b100 /* add-excluded doUncachedIntLength(DynamicObject) */;
                            this.state_ = this.state_ & 0xfffffffb /* remove-active doUncachedIntLength(DynamicObject) */;
                        } finally {
                            lock.unlock();
                        }
                        return JSTypesGen.expectInteger(ex.getResult());
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return JSTypesGen.expectInteger(executeAndSpecialize(arg0Value));
        }

        private Object executeAndSpecialize(DynamicObject arg0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int exclude = exclude_;
            try {
                if (((exclude & 0b1)) == 0 /* is-not-excluded doIntLength(DynamicObject, ScriptArray) */) {
                    int count1_ = 0;
                    IntLengthData s1_ = this.intLength_cache;
                    if ((state & 0b1) != 0 /* is-active doIntLength(DynamicObject, ScriptArray) */) {
                        while (s1_ != null) {
                            if ((s1_.arrayType_.isInstance(ArrayLengthNode.getArrayType(arg0Value)))) {
                                assert (s1_.arrayType_.isStatelessType());
                                assert (ArrayLengthReadNode.isLengthAlwaysInt(s1_.arrayType_));
                                break;
                            }
                            s1_ = s1_.next_;
                            count1_++;
                        }
                    }
                    if (s1_ == null) {
                        {
                            ScriptArray arrayType__ = (ArrayLengthNode.getArrayType(arg0Value));
                            if ((arrayType__.isInstance(ArrayLengthNode.getArrayType(arg0Value))) && (arrayType__.isStatelessType()) && (ArrayLengthReadNode.isLengthAlwaysInt(arrayType__)) && count1_ < (ArrayLengthNode.MAX_TYPE_COUNT)) {
                                s1_ = new IntLengthData(intLength_cache);
                                s1_.arrayType_ = arrayType__;
                                this.intLength_cache = s1_;
                                this.state_ = state = state | 0b1 /* add-active doIntLength(DynamicObject, ScriptArray) */;
                            }
                        }
                    }
                    if (s1_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return ArrayLengthReadNode.doIntLength(arg0Value, s1_.arrayType_);
                    }
                }
                if (((exclude & 0b10)) == 0 /* is-not-excluded doLongLength(DynamicObject, ScriptArray) */) {
                    int count2_ = 0;
                    LongLengthData s2_ = this.longLength_cache;
                    if ((state & 0b10) != 0 /* is-active doLongLength(DynamicObject, ScriptArray) */) {
                        while (s2_ != null) {
                            if ((s2_.arrayType_.isInstance(ArrayLengthNode.getArrayType(arg0Value)))) {
                                assert (s2_.arrayType_.isStatelessType());
                                break;
                            }
                            s2_ = s2_.next_;
                            count2_++;
                        }
                    }
                    if (s2_ == null) {
                        {
                            ScriptArray arrayType__1 = (ArrayLengthNode.getArrayType(arg0Value));
                            if ((arrayType__1.isInstance(ArrayLengthNode.getArrayType(arg0Value))) && (arrayType__1.isStatelessType()) && count2_ < (ArrayLengthNode.MAX_TYPE_COUNT)) {
                                s2_ = new LongLengthData(longLength_cache);
                                s2_.arrayType_ = arrayType__1;
                                this.longLength_cache = s2_;
                                this.exclude_ = exclude = exclude | 0b1 /* add-excluded doIntLength(DynamicObject, ScriptArray) */;
                                this.intLength_cache = null;
                                state = state & 0xfffffffe /* remove-active doIntLength(DynamicObject, ScriptArray) */;
                                this.state_ = state = state | 0b10 /* add-active doLongLength(DynamicObject, ScriptArray) */;
                            }
                        }
                    }
                    if (s2_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return ArrayLengthReadNode.doLongLength(arg0Value, s2_.arrayType_);
                    }
                }
                if (((exclude & 0b100)) == 0 /* is-not-excluded doUncachedIntLength(DynamicObject) */) {
                    this.exclude_ = exclude = exclude | 0b11 /* add-excluded doIntLength(DynamicObject, ScriptArray), doLongLength(DynamicObject, ScriptArray) */;
                    this.intLength_cache = null;
                    this.longLength_cache = null;
                    state = state & 0xfffffffc /* remove-active doIntLength(DynamicObject, ScriptArray), doLongLength(DynamicObject, ScriptArray) */;
                    this.state_ = state = state | 0b100 /* add-active doUncachedIntLength(DynamicObject) */;
                    try {
                        lock.unlock();
                        hasLock = false;
                        return ArrayLengthReadNode.doUncachedIntLength(arg0Value);
                    } catch (UnexpectedResultException ex) {
                        // implicit transferToInterpreterAndInvalidate()
                        lock.lock();
                        try {
                            this.exclude_ = this.exclude_ | 0b100 /* add-excluded doUncachedIntLength(DynamicObject) */;
                            this.state_ = this.state_ & 0xfffffffb /* remove-active doUncachedIntLength(DynamicObject) */;
                        } finally {
                            lock.unlock();
                        }
                        return ex.getResult();
                    }
                }
                this.exclude_ = exclude = exclude | 0b111 /* add-excluded doIntLength(DynamicObject, ScriptArray), doLongLength(DynamicObject, ScriptArray), doUncachedIntLength(DynamicObject) */;
                this.intLength_cache = null;
                this.longLength_cache = null;
                state = state & 0xfffffff8 /* remove-active doIntLength(DynamicObject, ScriptArray), doLongLength(DynamicObject, ScriptArray), doUncachedIntLength(DynamicObject) */;
                this.state_ = state = state | 0b1000 /* add-active doUncachedLongLength(DynamicObject) */;
                lock.unlock();
                hasLock = false;
                return ArrayLengthReadNode.doUncachedLongLength(arg0Value);
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
            } else if ((state & (state - 1)) == 0 /* is-single-active  */) {
                IntLengthData s1_ = this.intLength_cache;
                LongLengthData s2_ = this.longLength_cache;
                if ((s1_ == null || s1_.next_ == null) && (s2_ == null || s2_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[5];
            Object[] s;
            data[0] = 0;
            int state = state_;
            int exclude = exclude_;
            s = new Object[3];
            s[0] = "doIntLength";
            if ((state & 0b1) != 0 /* is-active doIntLength(DynamicObject, ScriptArray) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                IntLengthData s1_ = this.intLength_cache;
                while (s1_ != null) {
                    cached.add(Arrays.asList(s1_.arrayType_));
                    s1_ = s1_.next_;
                }
                s[2] = cached;
            } else if ((exclude & 0b1) != 0 /* is-excluded doIntLength(DynamicObject, ScriptArray) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doLongLength";
            if ((state & 0b10) != 0 /* is-active doLongLength(DynamicObject, ScriptArray) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                LongLengthData s2_ = this.longLength_cache;
                while (s2_ != null) {
                    cached.add(Arrays.asList(s2_.arrayType_));
                    s2_ = s2_.next_;
                }
                s[2] = cached;
            } else if ((exclude & 0b10) != 0 /* is-excluded doLongLength(DynamicObject, ScriptArray) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "doUncachedIntLength";
            if ((state & 0b100) != 0 /* is-active doUncachedIntLength(DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else if ((exclude & 0b100) != 0 /* is-excluded doUncachedIntLength(DynamicObject) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            s = new Object[3];
            s[0] = "doUncachedLongLength";
            if ((state & 0b1000) != 0 /* is-active doUncachedLongLength(DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[4] = s;
            return Provider.create(data);
        }

        public static ArrayLengthReadNode create() {
            return new ArrayLengthReadNodeGen();
        }

        @GeneratedBy(ArrayLengthReadNode.class)
        private static final class IntLengthData {

            @CompilationFinal IntLengthData next_;
            @CompilationFinal ScriptArray arrayType_;

            IntLengthData(IntLengthData next_) {
                this.next_ = next_;
            }

        }
        @GeneratedBy(ArrayLengthReadNode.class)
        private static final class LongLengthData {

            @CompilationFinal LongLengthData next_;
            @CompilationFinal ScriptArray arrayType_;

            LongLengthData(LongLengthData next_) {
                this.next_ = next_;
            }

        }
    }
    @GeneratedBy(SetArrayLengthNode.class)
    public static final class SetArrayLengthNodeGen extends SetArrayLengthNode implements Provider {

        @CompilationFinal private volatile int state_;
        @CompilationFinal private volatile int exclude_;
        @CompilationFinal private CachedData cached_cache;
        @CompilationFinal private ConditionProfile generic_sealedProfile_;
        @CompilationFinal private ProfileHolder generic_setLengthProfile_;

        private SetArrayLengthNodeGen(boolean strict) {
            super(strict);
        }

        @ExplodeLoop
        @Override
        public void executeVoid(DynamicObject arg0Value, int arg1Value) {
            int state = state_;
            if (state != 0 /* is-active doCached(DynamicObject, int, ScriptArray, ProfileHolder) || doGeneric(DynamicObject, int, ConditionProfile, ProfileHolder) */) {
                if ((state & 0b1) != 0 /* is-active doCached(DynamicObject, int, ScriptArray, ProfileHolder) */) {
                    CachedData s1_ = this.cached_cache;
                    while (s1_ != null) {
                        if ((s1_.arrayType_.isInstance(ArrayLengthNode.getArrayType(arg0Value)))) {
                            assert (s1_.arrayType_.isStatelessType());
                            doCached(arg0Value, arg1Value, s1_.arrayType_, s1_.setLengthProfile_);
                            return;
                        }
                        s1_ = s1_.next_;
                    }
                }
                if ((state & 0b10) != 0 /* is-active doGeneric(DynamicObject, int, ConditionProfile, ProfileHolder) */) {
                    doGeneric(arg0Value, arg1Value, this.generic_sealedProfile_, this.generic_setLengthProfile_);
                    return;
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            executeAndSpecialize(arg0Value, arg1Value);
            return;
        }

        private void executeAndSpecialize(DynamicObject arg0Value, int arg1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int exclude = exclude_;
            try {
                if ((exclude) == 0 /* is-not-excluded doCached(DynamicObject, int, ScriptArray, ProfileHolder) */) {
                    int count1_ = 0;
                    CachedData s1_ = this.cached_cache;
                    if ((state & 0b1) != 0 /* is-active doCached(DynamicObject, int, ScriptArray, ProfileHolder) */) {
                        while (s1_ != null) {
                            if ((s1_.arrayType_.isInstance(ArrayLengthNode.getArrayType(arg0Value)))) {
                                assert (s1_.arrayType_.isStatelessType());
                                break;
                            }
                            s1_ = s1_.next_;
                            count1_++;
                        }
                    }
                    if (s1_ == null) {
                        {
                            ScriptArray arrayType__ = (ArrayLengthNode.getArrayType(arg0Value));
                            if ((arrayType__.isInstance(ArrayLengthNode.getArrayType(arg0Value))) && (arrayType__.isStatelessType()) && count1_ < (ArrayLengthNode.MAX_TYPE_COUNT)) {
                                s1_ = new CachedData(cached_cache);
                                s1_.arrayType_ = arrayType__;
                                s1_.setLengthProfile_ = (ScriptArray.createSetLengthProfile());
                                this.cached_cache = s1_;
                                this.state_ = state = state | 0b1 /* add-active doCached(DynamicObject, int, ScriptArray, ProfileHolder) */;
                            }
                        }
                    }
                    if (s1_ != null) {
                        lock.unlock();
                        hasLock = false;
                        doCached(arg0Value, arg1Value, s1_.arrayType_, s1_.setLengthProfile_);
                        return;
                    }
                }
                this.generic_sealedProfile_ = (ConditionProfile.createBinaryProfile());
                this.generic_setLengthProfile_ = (ScriptArray.createSetLengthProfile());
                this.exclude_ = exclude = exclude | 0b1 /* add-excluded doCached(DynamicObject, int, ScriptArray, ProfileHolder) */;
                this.cached_cache = null;
                state = state & 0xfffffffe /* remove-active doCached(DynamicObject, int, ScriptArray, ProfileHolder) */;
                this.state_ = state = state | 0b10 /* add-active doGeneric(DynamicObject, int, ConditionProfile, ProfileHolder) */;
                lock.unlock();
                hasLock = false;
                doGeneric(arg0Value, arg1Value, this.generic_sealedProfile_, this.generic_setLengthProfile_);
                return;
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
            } else if ((state & (state - 1)) == 0 /* is-single-active  */) {
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
            if ((state & 0b1) != 0 /* is-active doCached(DynamicObject, int, ScriptArray, ProfileHolder) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                CachedData s1_ = this.cached_cache;
                while (s1_ != null) {
                    cached.add(Arrays.asList(s1_.arrayType_, s1_.setLengthProfile_));
                    s1_ = s1_.next_;
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-excluded doCached(DynamicObject, int, ScriptArray, ProfileHolder) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doGeneric";
            if ((state & 0b10) != 0 /* is-active doGeneric(DynamicObject, int, ConditionProfile, ProfileHolder) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.generic_sealedProfile_, this.generic_setLengthProfile_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static SetArrayLengthNode create(boolean strict) {
            return new SetArrayLengthNodeGen(strict);
        }

        @GeneratedBy(SetArrayLengthNode.class)
        private static final class CachedData {

            @CompilationFinal CachedData next_;
            @CompilationFinal ScriptArray arrayType_;
            @CompilationFinal ProfileHolder setLengthProfile_;

            CachedData(CachedData next_) {
                this.next_ = next_;
            }

        }
    }
    @GeneratedBy(SetArrayLengthOrDeleteNode.class)
    public static final class SetArrayLengthOrDeleteNodeGen extends SetArrayLengthOrDeleteNode implements Provider {

        @CompilationFinal private volatile int state_;
        @CompilationFinal private volatile int exclude_;
        @CompilationFinal private CachedData cached_cache;
        @CompilationFinal private ConditionProfile generic_mustDeleteProfile_;
        @CompilationFinal private ProfileHolder generic_setLengthProfile_;

        private SetArrayLengthOrDeleteNodeGen(boolean strict) {
            super(strict);
        }

        @ExplodeLoop
        @Override
        public void executeVoid(DynamicObject arg0Value, int arg1Value) {
            int state = state_;
            if (state != 0 /* is-active doCached(DynamicObject, int, ScriptArray, ProfileHolder) || doGeneric(DynamicObject, int, ConditionProfile, ProfileHolder) */) {
                if ((state & 0b1) != 0 /* is-active doCached(DynamicObject, int, ScriptArray, ProfileHolder) */) {
                    CachedData s1_ = this.cached_cache;
                    while (s1_ != null) {
                        if ((s1_.arrayType_.isInstance(ArrayLengthNode.getArrayType(arg0Value)))) {
                            assert (s1_.arrayType_.isStatelessType());
                            doCached(arg0Value, arg1Value, s1_.arrayType_, s1_.setLengthProfile_);
                            return;
                        }
                        s1_ = s1_.next_;
                    }
                }
                if ((state & 0b10) != 0 /* is-active doGeneric(DynamicObject, int, ConditionProfile, ProfileHolder) */) {
                    doGeneric(arg0Value, arg1Value, this.generic_mustDeleteProfile_, this.generic_setLengthProfile_);
                    return;
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            executeAndSpecialize(arg0Value, arg1Value);
            return;
        }

        private void executeAndSpecialize(DynamicObject arg0Value, int arg1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int exclude = exclude_;
            try {
                if ((exclude) == 0 /* is-not-excluded doCached(DynamicObject, int, ScriptArray, ProfileHolder) */) {
                    int count1_ = 0;
                    CachedData s1_ = this.cached_cache;
                    if ((state & 0b1) != 0 /* is-active doCached(DynamicObject, int, ScriptArray, ProfileHolder) */) {
                        while (s1_ != null) {
                            if ((s1_.arrayType_.isInstance(ArrayLengthNode.getArrayType(arg0Value)))) {
                                assert (s1_.arrayType_.isStatelessType());
                                break;
                            }
                            s1_ = s1_.next_;
                            count1_++;
                        }
                    }
                    if (s1_ == null) {
                        {
                            ScriptArray arrayType__ = (ArrayLengthNode.getArrayType(arg0Value));
                            if ((arrayType__.isInstance(ArrayLengthNode.getArrayType(arg0Value))) && (arrayType__.isStatelessType()) && count1_ < (ArrayLengthNode.MAX_TYPE_COUNT)) {
                                s1_ = new CachedData(cached_cache);
                                s1_.arrayType_ = arrayType__;
                                s1_.setLengthProfile_ = (ScriptArray.createSetLengthProfile());
                                this.cached_cache = s1_;
                                this.state_ = state = state | 0b1 /* add-active doCached(DynamicObject, int, ScriptArray, ProfileHolder) */;
                            }
                        }
                    }
                    if (s1_ != null) {
                        lock.unlock();
                        hasLock = false;
                        doCached(arg0Value, arg1Value, s1_.arrayType_, s1_.setLengthProfile_);
                        return;
                    }
                }
                this.generic_mustDeleteProfile_ = (ConditionProfile.createBinaryProfile());
                this.generic_setLengthProfile_ = (ScriptArray.createSetLengthProfile());
                this.exclude_ = exclude = exclude | 0b1 /* add-excluded doCached(DynamicObject, int, ScriptArray, ProfileHolder) */;
                this.cached_cache = null;
                state = state & 0xfffffffe /* remove-active doCached(DynamicObject, int, ScriptArray, ProfileHolder) */;
                this.state_ = state = state | 0b10 /* add-active doGeneric(DynamicObject, int, ConditionProfile, ProfileHolder) */;
                lock.unlock();
                hasLock = false;
                doGeneric(arg0Value, arg1Value, this.generic_mustDeleteProfile_, this.generic_setLengthProfile_);
                return;
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
            } else if ((state & (state - 1)) == 0 /* is-single-active  */) {
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
            if ((state & 0b1) != 0 /* is-active doCached(DynamicObject, int, ScriptArray, ProfileHolder) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                CachedData s1_ = this.cached_cache;
                while (s1_ != null) {
                    cached.add(Arrays.asList(s1_.arrayType_, s1_.setLengthProfile_));
                    s1_ = s1_.next_;
                }
                s[2] = cached;
            } else if (exclude != 0 /* is-excluded doCached(DynamicObject, int, ScriptArray, ProfileHolder) */) {
                s[1] = (byte)0b10 /* excluded */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doGeneric";
            if ((state & 0b10) != 0 /* is-active doGeneric(DynamicObject, int, ConditionProfile, ProfileHolder) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.generic_mustDeleteProfile_, this.generic_setLengthProfile_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static SetArrayLengthOrDeleteNode create(boolean strict) {
            return new SetArrayLengthOrDeleteNodeGen(strict);
        }

        @GeneratedBy(SetArrayLengthOrDeleteNode.class)
        private static final class CachedData {

            @CompilationFinal CachedData next_;
            @CompilationFinal ScriptArray arrayType_;
            @CompilationFinal ProfileHolder setLengthProfile_;

            CachedData(CachedData next_) {
                this.next_ = next_;
            }

        }
    }
}
