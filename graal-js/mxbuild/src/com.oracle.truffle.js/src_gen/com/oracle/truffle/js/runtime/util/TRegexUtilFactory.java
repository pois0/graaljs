// CheckStyle: start generated
package com.oracle.truffle.js.runtime.util;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.EncapsulatingNodeReference;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.js.runtime.util.TRegexUtil.CompileRegexNode;
import com.oracle.truffle.js.runtime.util.TRegexUtil.InteropIsMemberReadableNode;
import com.oracle.truffle.js.runtime.util.TRegexUtil.InteropIsNullNode;
import com.oracle.truffle.js.runtime.util.TRegexUtil.InteropReadBooleanMemberNode;
import com.oracle.truffle.js.runtime.util.TRegexUtil.InteropReadIntMemberNode;
import com.oracle.truffle.js.runtime.util.TRegexUtil.InteropReadMemberNode;
import com.oracle.truffle.js.runtime.util.TRegexUtil.InteropReadStringMemberNode;
import com.oracle.truffle.js.runtime.util.TRegexUtil.InteropToBooleanNode;
import com.oracle.truffle.js.runtime.util.TRegexUtil.InteropToIntNode;
import com.oracle.truffle.js.runtime.util.TRegexUtil.InteropToStringNode;
import com.oracle.truffle.js.runtime.util.TRegexUtil.InvokeExecMethodNode;
import com.oracle.truffle.js.runtime.util.TRegexUtil.InvokeGetGroupBoundariesMethodNode;
import com.oracle.truffle.js.runtime.util.TRegexUtil.ValidateRegexNode;
import com.oracle.truffle.js.runtime.util.TRegexUtil.Props.CompiledRegex;
import com.oracle.truffle.js.runtime.util.TRegexUtil.Props.RegexEngine;
import java.util.concurrent.locks.Lock;

@GeneratedBy(TRegexUtil.class)
@SuppressWarnings("unused")
public final class TRegexUtilFactory {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @GeneratedBy(InteropIsNullNode.class)
    public static final class InteropIsNullNodeGen extends InteropIsNullNode {

        private static final Uncached UNCACHED = new Uncached();

        @CompilationFinal private volatile int state_;
        @CompilationFinal private volatile int exclude_;
        @Child private Read0Data read0_cache;

        private InteropIsNullNodeGen() {
        }

        @ExplodeLoop
        @Override
        public boolean execute(Object arg0Value) {
            int state = state_;
            if (state != 0 /* is-active read(Object, InteropLibrary) || read(Object, InteropLibrary) */) {
                if ((state & 0b1) != 0 /* is-active read(Object, InteropLibrary) */) {
                    Read0Data s1_ = this.read0_cache;
                    while (s1_ != null) {
                        if ((s1_.objs_.accepts(arg0Value))) {
                            return InteropIsNullNode.read(arg0Value, s1_.objs_);
                        }
                        s1_ = s1_.next_;
                    }
                }
                if ((state & 0b10) != 0 /* is-active read(Object, InteropLibrary) */) {
                    return this.read1Boundary(state, arg0Value);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value);
        }

        @TruffleBoundary
        private boolean read1Boundary(int state, Object arg0Value) {
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(this);
            try {
                {
                    InteropLibrary read1_objs__ = (INTEROP_LIBRARY_.getUncached(arg0Value));
                    return InteropIsNullNode.read(arg0Value, read1_objs__);
                }
            } finally {
                encapsulating_.set(prev_);
            }
        }

        private boolean executeAndSpecialize(Object arg0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int exclude = exclude_;
            try {
                if ((exclude) == 0 /* is-not-excluded read(Object, InteropLibrary) */) {
                    int count1_ = 0;
                    Read0Data s1_ = this.read0_cache;
                    if ((state & 0b1) != 0 /* is-active read(Object, InteropLibrary) */) {
                        while (s1_ != null) {
                            if ((s1_.objs_.accepts(arg0Value))) {
                                break;
                            }
                            s1_ = s1_.next_;
                            count1_++;
                        }
                    }
                    if (s1_ == null) {
                        // assert (s1_.objs_.accepts(arg0Value));
                        if (count1_ < (3)) {
                            s1_ = super.insert(new Read0Data(read0_cache));
                            s1_.objs_ = s1_.insertAccessor((INTEROP_LIBRARY_.create(arg0Value)));
                            this.read0_cache = s1_;
                            this.state_ = state = state | 0b1 /* add-active read(Object, InteropLibrary) */;
                        }
                    }
                    if (s1_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return InteropIsNullNode.read(arg0Value, s1_.objs_);
                    }
                }
                {
                    InteropLibrary read1_objs__ = null;
                    {
                        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                        Node prev_ = encapsulating_.set(this);
                        try {
                            read1_objs__ = (INTEROP_LIBRARY_.getUncached(arg0Value));
                            this.exclude_ = exclude = exclude | 0b1 /* add-excluded read(Object, InteropLibrary) */;
                            this.read0_cache = null;
                            state = state & 0xfffffffe /* remove-active read(Object, InteropLibrary) */;
                            this.state_ = state = state | 0b10 /* add-active read(Object, InteropLibrary) */;
                            lock.unlock();
                            hasLock = false;
                            return InteropIsNullNode.read(arg0Value, read1_objs__);
                        } finally {
                            encapsulating_.set(prev_);
                        }
                    }
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
            } else if ((state & (state - 1)) == 0 /* is-single-active  */) {
                Read0Data s1_ = this.read0_cache;
                if ((s1_ == null || s1_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        public static InteropIsNullNode create() {
            return new InteropIsNullNodeGen();
        }

        public static InteropIsNullNode getUncached() {
            return InteropIsNullNodeGen.UNCACHED;
        }

        @GeneratedBy(InteropIsNullNode.class)
        private static final class Read0Data extends Node {

            @Child Read0Data next_;
            @Child InteropLibrary objs_;

            Read0Data(Read0Data next_) {
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
        @GeneratedBy(InteropIsNullNode.class)
        private static final class Uncached extends InteropIsNullNode {

            @TruffleBoundary
            @Override
            public boolean execute(Object arg0Value) {
                return InteropIsNullNode.read(arg0Value, (INTEROP_LIBRARY_.getUncached(arg0Value)));
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
    @GeneratedBy(InteropIsMemberReadableNode.class)
    public static final class InteropIsMemberReadableNodeGen extends InteropIsMemberReadableNode {

        private static final Uncached UNCACHED = new Uncached();

        @CompilationFinal private volatile int state_;
        @CompilationFinal private volatile int exclude_;
        @Child private Read0Data read0_cache;

        private InteropIsMemberReadableNodeGen() {
        }

        @ExplodeLoop
        @Override
        public boolean execute(Object arg0Value, String arg1Value) {
            int state = state_;
            if (state != 0 /* is-active read(Object, String, InteropLibrary) || read(Object, String, InteropLibrary) */) {
                if ((state & 0b1) != 0 /* is-active read(Object, String, InteropLibrary) */) {
                    Read0Data s1_ = this.read0_cache;
                    while (s1_ != null) {
                        if ((s1_.objs_.accepts(arg0Value))) {
                            return InteropIsMemberReadableNode.read(arg0Value, arg1Value, s1_.objs_);
                        }
                        s1_ = s1_.next_;
                    }
                }
                if ((state & 0b10) != 0 /* is-active read(Object, String, InteropLibrary) */) {
                    return this.read1Boundary(state, arg0Value, arg1Value);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value, arg1Value);
        }

        @TruffleBoundary
        private boolean read1Boundary(int state, Object arg0Value, String arg1Value) {
            EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
            Node prev_ = encapsulating_.set(this);
            try {
                {
                    InteropLibrary read1_objs__ = (INTEROP_LIBRARY_.getUncached(arg0Value));
                    return InteropIsMemberReadableNode.read(arg0Value, arg1Value, read1_objs__);
                }
            } finally {
                encapsulating_.set(prev_);
            }
        }

        private boolean executeAndSpecialize(Object arg0Value, String arg1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int exclude = exclude_;
            try {
                if ((exclude) == 0 /* is-not-excluded read(Object, String, InteropLibrary) */) {
                    int count1_ = 0;
                    Read0Data s1_ = this.read0_cache;
                    if ((state & 0b1) != 0 /* is-active read(Object, String, InteropLibrary) */) {
                        while (s1_ != null) {
                            if ((s1_.objs_.accepts(arg0Value))) {
                                break;
                            }
                            s1_ = s1_.next_;
                            count1_++;
                        }
                    }
                    if (s1_ == null) {
                        // assert (s1_.objs_.accepts(arg0Value));
                        if (count1_ < (9)) {
                            s1_ = super.insert(new Read0Data(read0_cache));
                            s1_.objs_ = s1_.insertAccessor((INTEROP_LIBRARY_.create(arg0Value)));
                            this.read0_cache = s1_;
                            this.state_ = state = state | 0b1 /* add-active read(Object, String, InteropLibrary) */;
                        }
                    }
                    if (s1_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return InteropIsMemberReadableNode.read(arg0Value, arg1Value, s1_.objs_);
                    }
                }
                {
                    InteropLibrary read1_objs__ = null;
                    {
                        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                        Node prev_ = encapsulating_.set(this);
                        try {
                            read1_objs__ = (INTEROP_LIBRARY_.getUncached(arg0Value));
                            this.exclude_ = exclude = exclude | 0b1 /* add-excluded read(Object, String, InteropLibrary) */;
                            this.read0_cache = null;
                            state = state & 0xfffffffe /* remove-active read(Object, String, InteropLibrary) */;
                            this.state_ = state = state | 0b10 /* add-active read(Object, String, InteropLibrary) */;
                            lock.unlock();
                            hasLock = false;
                            return InteropIsMemberReadableNode.read(arg0Value, arg1Value, read1_objs__);
                        } finally {
                            encapsulating_.set(prev_);
                        }
                    }
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
            } else if ((state & (state - 1)) == 0 /* is-single-active  */) {
                Read0Data s1_ = this.read0_cache;
                if ((s1_ == null || s1_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        public static InteropIsMemberReadableNode create() {
            return new InteropIsMemberReadableNodeGen();
        }

        public static InteropIsMemberReadableNode getUncached() {
            return InteropIsMemberReadableNodeGen.UNCACHED;
        }

        @GeneratedBy(InteropIsMemberReadableNode.class)
        private static final class Read0Data extends Node {

            @Child Read0Data next_;
            @Child InteropLibrary objs_;

            Read0Data(Read0Data next_) {
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
        @GeneratedBy(InteropIsMemberReadableNode.class)
        private static final class Uncached extends InteropIsMemberReadableNode {

            @TruffleBoundary
            @Override
            public boolean execute(Object arg0Value, String arg1Value) {
                return InteropIsMemberReadableNode.read(arg0Value, arg1Value, (INTEROP_LIBRARY_.getUncached(arg0Value)));
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
    @GeneratedBy(InteropReadMemberNode.class)
    public static final class InteropReadMemberNodeGen extends InteropReadMemberNode {

        private static final Uncached UNCACHED = new Uncached();

        @CompilationFinal private volatile int state_;
        @CompilationFinal private volatile int exclude_;
        @Child private Read0Data read0_cache;

        private InteropReadMemberNodeGen() {
        }

        @ExplodeLoop
        @Override
        public Object execute(Object arg0Value, String arg1Value) {
            int state = state_;
            if (state != 0 /* is-active read(Object, String, InteropLibrary) || read(Object, String, InteropLibrary) */) {
                if ((state & 0b1) != 0 /* is-active read(Object, String, InteropLibrary) */) {
                    Read0Data s1_ = this.read0_cache;
                    while (s1_ != null) {
                        if ((s1_.objs_.accepts(arg0Value)) && (s1_.objs_.isMemberReadable(arg0Value, arg1Value))) {
                            return InteropReadMemberNode.read(arg0Value, arg1Value, s1_.objs_);
                        }
                        s1_ = s1_.next_;
                    }
                }
                if ((state & 0b10) != 0 /* is-active read(Object, String, InteropLibrary) */) {
                    EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                    Node prev_ = encapsulating_.set(this);
                    try {
                        {
                            InteropLibrary read1_objs__ = (INTEROP_LIBRARY_.getUncached(arg0Value));
                            if ((read1_objs__.isMemberReadable(arg0Value, arg1Value))) {
                                return InteropReadMemberNode.read(arg0Value, arg1Value, read1_objs__);
                            }
                        }
                    } finally {
                        encapsulating_.set(prev_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value, arg1Value);
        }

        private Object executeAndSpecialize(Object arg0Value, String arg1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int exclude = exclude_;
            try {
                if ((exclude) == 0 /* is-not-excluded read(Object, String, InteropLibrary) */) {
                    int count1_ = 0;
                    Read0Data s1_ = this.read0_cache;
                    if ((state & 0b1) != 0 /* is-active read(Object, String, InteropLibrary) */) {
                        while (s1_ != null) {
                            if ((s1_.objs_.accepts(arg0Value)) && (s1_.objs_.isMemberReadable(arg0Value, arg1Value))) {
                                break;
                            }
                            s1_ = s1_.next_;
                            count1_++;
                        }
                    }
                    if (s1_ == null) {
                        {
                            InteropLibrary objs__ = super.insert((INTEROP_LIBRARY_.create(arg0Value)));
                            // assert (s1_.objs_.accepts(arg0Value));
                            if ((objs__.isMemberReadable(arg0Value, arg1Value)) && count1_ < (9)) {
                                s1_ = super.insert(new Read0Data(read0_cache));
                                s1_.objs_ = s1_.insertAccessor(objs__);
                                this.read0_cache = s1_;
                                this.state_ = state = state | 0b1 /* add-active read(Object, String, InteropLibrary) */;
                            }
                        }
                    }
                    if (s1_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return InteropReadMemberNode.read(arg0Value, arg1Value, s1_.objs_);
                    }
                }
                {
                    InteropLibrary read1_objs__ = null;
                    {
                        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                        Node prev_ = encapsulating_.set(this);
                        try {
                            {
                                read1_objs__ = (INTEROP_LIBRARY_.getUncached(arg0Value));
                                if ((read1_objs__.isMemberReadable(arg0Value, arg1Value))) {
                                    this.exclude_ = exclude = exclude | 0b1 /* add-excluded read(Object, String, InteropLibrary) */;
                                    this.read0_cache = null;
                                    state = state & 0xfffffffe /* remove-active read(Object, String, InteropLibrary) */;
                                    this.state_ = state = state | 0b10 /* add-active read(Object, String, InteropLibrary) */;
                                    lock.unlock();
                                    hasLock = false;
                                    return InteropReadMemberNode.read(arg0Value, arg1Value, read1_objs__);
                                }
                            }
                        } finally {
                            encapsulating_.set(prev_);
                        }
                    }
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null, null}, arg0Value, arg1Value);
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
                Read0Data s1_ = this.read0_cache;
                if ((s1_ == null || s1_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        public static InteropReadMemberNode create() {
            return new InteropReadMemberNodeGen();
        }

        public static InteropReadMemberNode getUncached() {
            return InteropReadMemberNodeGen.UNCACHED;
        }

        @GeneratedBy(InteropReadMemberNode.class)
        private static final class Read0Data extends Node {

            @Child Read0Data next_;
            @Child InteropLibrary objs_;

            Read0Data(Read0Data next_) {
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
        @GeneratedBy(InteropReadMemberNode.class)
        private static final class Uncached extends InteropReadMemberNode {

            @TruffleBoundary
            @Override
            public Object execute(Object arg0Value, String arg1Value) {
                if (((INTEROP_LIBRARY_.getUncached(arg0Value)).isMemberReadable(arg0Value, arg1Value))) {
                    return InteropReadMemberNode.read(arg0Value, arg1Value, (INTEROP_LIBRARY_.getUncached(arg0Value)));
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null, null}, arg0Value, arg1Value);
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
    @GeneratedBy(InteropReadIntMemberNode.class)
    public static final class InteropReadIntMemberNodeGen extends InteropReadIntMemberNode {

        private static final Uncached UNCACHED = new Uncached();

        @CompilationFinal private volatile int state_;
        @CompilationFinal private volatile int exclude_;
        @Child private Read0Data read0_cache;
        @Child private InteropToIntNode read1_coerceNode_;

        private InteropReadIntMemberNodeGen() {
        }

        @ExplodeLoop
        @Override
        public int execute(Object arg0Value, String arg1Value) {
            int state = state_;
            if (state != 0 /* is-active read(Object, String, InteropToIntNode, InteropLibrary) || read(Object, String, InteropToIntNode, InteropLibrary) */) {
                if ((state & 0b1) != 0 /* is-active read(Object, String, InteropToIntNode, InteropLibrary) */) {
                    Read0Data s1_ = this.read0_cache;
                    while (s1_ != null) {
                        if ((s1_.objs_.accepts(arg0Value)) && (s1_.objs_.isMemberReadable(arg0Value, arg1Value))) {
                            return InteropReadIntMemberNode.read(arg0Value, arg1Value, s1_.coerceNode_, s1_.objs_);
                        }
                        s1_ = s1_.next_;
                    }
                }
                if ((state & 0b10) != 0 /* is-active read(Object, String, InteropToIntNode, InteropLibrary) */) {
                    EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                    Node prev_ = encapsulating_.set(this);
                    try {
                        {
                            InteropLibrary read1_objs__ = (INTEROP_LIBRARY_.getUncached(arg0Value));
                            if ((read1_objs__.isMemberReadable(arg0Value, arg1Value))) {
                                return InteropReadIntMemberNode.read(arg0Value, arg1Value, this.read1_coerceNode_, read1_objs__);
                            }
                        }
                    } finally {
                        encapsulating_.set(prev_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value, arg1Value);
        }

        private int executeAndSpecialize(Object arg0Value, String arg1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int exclude = exclude_;
            try {
                if ((exclude) == 0 /* is-not-excluded read(Object, String, InteropToIntNode, InteropLibrary) */) {
                    int count1_ = 0;
                    Read0Data s1_ = this.read0_cache;
                    if ((state & 0b1) != 0 /* is-active read(Object, String, InteropToIntNode, InteropLibrary) */) {
                        while (s1_ != null) {
                            if ((s1_.objs_.accepts(arg0Value)) && (s1_.objs_.isMemberReadable(arg0Value, arg1Value))) {
                                break;
                            }
                            s1_ = s1_.next_;
                            count1_++;
                        }
                    }
                    if (s1_ == null) {
                        {
                            InteropLibrary objs__ = super.insert((INTEROP_LIBRARY_.create(arg0Value)));
                            // assert (s1_.objs_.accepts(arg0Value));
                            if ((objs__.isMemberReadable(arg0Value, arg1Value)) && count1_ < (9)) {
                                s1_ = super.insert(new Read0Data(read0_cache));
                                s1_.coerceNode_ = s1_.insertAccessor((InteropToIntNodeGen.create()));
                                s1_.objs_ = s1_.insertAccessor(objs__);
                                this.read0_cache = s1_;
                                this.state_ = state = state | 0b1 /* add-active read(Object, String, InteropToIntNode, InteropLibrary) */;
                            }
                        }
                    }
                    if (s1_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return InteropReadIntMemberNode.read(arg0Value, arg1Value, s1_.coerceNode_, s1_.objs_);
                    }
                }
                {
                    InteropLibrary read1_objs__ = null;
                    {
                        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                        Node prev_ = encapsulating_.set(this);
                        try {
                            {
                                read1_objs__ = (INTEROP_LIBRARY_.getUncached(arg0Value));
                                if ((read1_objs__.isMemberReadable(arg0Value, arg1Value))) {
                                    this.read1_coerceNode_ = super.insert((InteropToIntNodeGen.create()));
                                    this.exclude_ = exclude = exclude | 0b1 /* add-excluded read(Object, String, InteropToIntNode, InteropLibrary) */;
                                    this.read0_cache = null;
                                    state = state & 0xfffffffe /* remove-active read(Object, String, InteropToIntNode, InteropLibrary) */;
                                    this.state_ = state = state | 0b10 /* add-active read(Object, String, InteropToIntNode, InteropLibrary) */;
                                    lock.unlock();
                                    hasLock = false;
                                    return InteropReadIntMemberNode.read(arg0Value, arg1Value, this.read1_coerceNode_, read1_objs__);
                                }
                            }
                        } finally {
                            encapsulating_.set(prev_);
                        }
                    }
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null, null}, arg0Value, arg1Value);
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
                Read0Data s1_ = this.read0_cache;
                if ((s1_ == null || s1_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        public static InteropReadIntMemberNode create() {
            return new InteropReadIntMemberNodeGen();
        }

        public static InteropReadIntMemberNode getUncached() {
            return InteropReadIntMemberNodeGen.UNCACHED;
        }

        @GeneratedBy(InteropReadIntMemberNode.class)
        private static final class Read0Data extends Node {

            @Child Read0Data next_;
            @Child InteropToIntNode coerceNode_;
            @Child InteropLibrary objs_;

            Read0Data(Read0Data next_) {
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
        @GeneratedBy(InteropReadIntMemberNode.class)
        private static final class Uncached extends InteropReadIntMemberNode {

            @TruffleBoundary
            @Override
            public int execute(Object arg0Value, String arg1Value) {
                if (((INTEROP_LIBRARY_.getUncached(arg0Value)).isMemberReadable(arg0Value, arg1Value))) {
                    return InteropReadIntMemberNode.read(arg0Value, arg1Value, (InteropToIntNodeGen.getUncached()), (INTEROP_LIBRARY_.getUncached(arg0Value)));
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null, null}, arg0Value, arg1Value);
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
    @GeneratedBy(InteropReadBooleanMemberNode.class)
    public static final class InteropReadBooleanMemberNodeGen extends InteropReadBooleanMemberNode {

        private static final Uncached UNCACHED = new Uncached();

        @CompilationFinal private volatile int state_;
        @CompilationFinal private volatile int exclude_;
        @Child private Read0Data read0_cache;
        @Child private InteropToBooleanNode read1_coerceNode_;

        private InteropReadBooleanMemberNodeGen() {
        }

        @ExplodeLoop
        @Override
        public boolean execute(Object arg0Value, String arg1Value) {
            int state = state_;
            if (state != 0 /* is-active read(Object, String, InteropToBooleanNode, InteropLibrary) || read(Object, String, InteropToBooleanNode, InteropLibrary) */) {
                if ((state & 0b1) != 0 /* is-active read(Object, String, InteropToBooleanNode, InteropLibrary) */) {
                    Read0Data s1_ = this.read0_cache;
                    while (s1_ != null) {
                        if ((s1_.objs_.accepts(arg0Value)) && (s1_.objs_.isMemberReadable(arg0Value, arg1Value))) {
                            return InteropReadBooleanMemberNode.read(arg0Value, arg1Value, s1_.coerceNode_, s1_.objs_);
                        }
                        s1_ = s1_.next_;
                    }
                }
                if ((state & 0b10) != 0 /* is-active read(Object, String, InteropToBooleanNode, InteropLibrary) */) {
                    EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                    Node prev_ = encapsulating_.set(this);
                    try {
                        {
                            InteropLibrary read1_objs__ = (INTEROP_LIBRARY_.getUncached(arg0Value));
                            if ((read1_objs__.isMemberReadable(arg0Value, arg1Value))) {
                                return InteropReadBooleanMemberNode.read(arg0Value, arg1Value, this.read1_coerceNode_, read1_objs__);
                            }
                        }
                    } finally {
                        encapsulating_.set(prev_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value, arg1Value);
        }

        private boolean executeAndSpecialize(Object arg0Value, String arg1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int exclude = exclude_;
            try {
                if ((exclude) == 0 /* is-not-excluded read(Object, String, InteropToBooleanNode, InteropLibrary) */) {
                    int count1_ = 0;
                    Read0Data s1_ = this.read0_cache;
                    if ((state & 0b1) != 0 /* is-active read(Object, String, InteropToBooleanNode, InteropLibrary) */) {
                        while (s1_ != null) {
                            if ((s1_.objs_.accepts(arg0Value)) && (s1_.objs_.isMemberReadable(arg0Value, arg1Value))) {
                                break;
                            }
                            s1_ = s1_.next_;
                            count1_++;
                        }
                    }
                    if (s1_ == null) {
                        {
                            InteropLibrary objs__ = super.insert((INTEROP_LIBRARY_.create(arg0Value)));
                            // assert (s1_.objs_.accepts(arg0Value));
                            if ((objs__.isMemberReadable(arg0Value, arg1Value)) && count1_ < (9)) {
                                s1_ = super.insert(new Read0Data(read0_cache));
                                s1_.coerceNode_ = s1_.insertAccessor((InteropToBooleanNodeGen.create()));
                                s1_.objs_ = s1_.insertAccessor(objs__);
                                this.read0_cache = s1_;
                                this.state_ = state = state | 0b1 /* add-active read(Object, String, InteropToBooleanNode, InteropLibrary) */;
                            }
                        }
                    }
                    if (s1_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return InteropReadBooleanMemberNode.read(arg0Value, arg1Value, s1_.coerceNode_, s1_.objs_);
                    }
                }
                {
                    InteropLibrary read1_objs__ = null;
                    {
                        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                        Node prev_ = encapsulating_.set(this);
                        try {
                            {
                                read1_objs__ = (INTEROP_LIBRARY_.getUncached(arg0Value));
                                if ((read1_objs__.isMemberReadable(arg0Value, arg1Value))) {
                                    this.read1_coerceNode_ = super.insert((InteropToBooleanNodeGen.create()));
                                    this.exclude_ = exclude = exclude | 0b1 /* add-excluded read(Object, String, InteropToBooleanNode, InteropLibrary) */;
                                    this.read0_cache = null;
                                    state = state & 0xfffffffe /* remove-active read(Object, String, InteropToBooleanNode, InteropLibrary) */;
                                    this.state_ = state = state | 0b10 /* add-active read(Object, String, InteropToBooleanNode, InteropLibrary) */;
                                    lock.unlock();
                                    hasLock = false;
                                    return InteropReadBooleanMemberNode.read(arg0Value, arg1Value, this.read1_coerceNode_, read1_objs__);
                                }
                            }
                        } finally {
                            encapsulating_.set(prev_);
                        }
                    }
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null, null}, arg0Value, arg1Value);
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
                Read0Data s1_ = this.read0_cache;
                if ((s1_ == null || s1_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        public static InteropReadBooleanMemberNode create() {
            return new InteropReadBooleanMemberNodeGen();
        }

        public static InteropReadBooleanMemberNode getUncached() {
            return InteropReadBooleanMemberNodeGen.UNCACHED;
        }

        @GeneratedBy(InteropReadBooleanMemberNode.class)
        private static final class Read0Data extends Node {

            @Child Read0Data next_;
            @Child InteropToBooleanNode coerceNode_;
            @Child InteropLibrary objs_;

            Read0Data(Read0Data next_) {
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
        @GeneratedBy(InteropReadBooleanMemberNode.class)
        private static final class Uncached extends InteropReadBooleanMemberNode {

            @TruffleBoundary
            @Override
            public boolean execute(Object arg0Value, String arg1Value) {
                if (((INTEROP_LIBRARY_.getUncached(arg0Value)).isMemberReadable(arg0Value, arg1Value))) {
                    return InteropReadBooleanMemberNode.read(arg0Value, arg1Value, (InteropToBooleanNodeGen.getUncached()), (INTEROP_LIBRARY_.getUncached(arg0Value)));
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null, null}, arg0Value, arg1Value);
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
    @GeneratedBy(InteropReadStringMemberNode.class)
    public static final class InteropReadStringMemberNodeGen extends InteropReadStringMemberNode {

        private static final Uncached UNCACHED = new Uncached();

        @CompilationFinal private volatile int state_;
        @CompilationFinal private volatile int exclude_;
        @Child private Read0Data read0_cache;
        @Child private InteropToStringNode read1_coerceNode_;

        private InteropReadStringMemberNodeGen() {
        }

        @ExplodeLoop
        @Override
        public String execute(Object arg0Value, String arg1Value) {
            int state = state_;
            if (state != 0 /* is-active read(Object, String, InteropToStringNode, InteropLibrary) || read(Object, String, InteropToStringNode, InteropLibrary) */) {
                if ((state & 0b1) != 0 /* is-active read(Object, String, InteropToStringNode, InteropLibrary) */) {
                    Read0Data s1_ = this.read0_cache;
                    while (s1_ != null) {
                        if ((s1_.objs_.accepts(arg0Value)) && (s1_.objs_.isMemberReadable(arg0Value, arg1Value))) {
                            return InteropReadStringMemberNode.read(arg0Value, arg1Value, s1_.coerceNode_, s1_.objs_);
                        }
                        s1_ = s1_.next_;
                    }
                }
                if ((state & 0b10) != 0 /* is-active read(Object, String, InteropToStringNode, InteropLibrary) */) {
                    EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                    Node prev_ = encapsulating_.set(this);
                    try {
                        {
                            InteropLibrary read1_objs__ = (INTEROP_LIBRARY_.getUncached(arg0Value));
                            if ((read1_objs__.isMemberReadable(arg0Value, arg1Value))) {
                                return InteropReadStringMemberNode.read(arg0Value, arg1Value, this.read1_coerceNode_, read1_objs__);
                            }
                        }
                    } finally {
                        encapsulating_.set(prev_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value, arg1Value);
        }

        private String executeAndSpecialize(Object arg0Value, String arg1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int exclude = exclude_;
            try {
                if ((exclude) == 0 /* is-not-excluded read(Object, String, InteropToStringNode, InteropLibrary) */) {
                    int count1_ = 0;
                    Read0Data s1_ = this.read0_cache;
                    if ((state & 0b1) != 0 /* is-active read(Object, String, InteropToStringNode, InteropLibrary) */) {
                        while (s1_ != null) {
                            if ((s1_.objs_.accepts(arg0Value)) && (s1_.objs_.isMemberReadable(arg0Value, arg1Value))) {
                                break;
                            }
                            s1_ = s1_.next_;
                            count1_++;
                        }
                    }
                    if (s1_ == null) {
                        {
                            InteropLibrary objs__ = super.insert((INTEROP_LIBRARY_.create(arg0Value)));
                            // assert (s1_.objs_.accepts(arg0Value));
                            if ((objs__.isMemberReadable(arg0Value, arg1Value)) && count1_ < (3)) {
                                s1_ = super.insert(new Read0Data(read0_cache));
                                s1_.coerceNode_ = s1_.insertAccessor((InteropToStringNodeGen.create()));
                                s1_.objs_ = s1_.insertAccessor(objs__);
                                this.read0_cache = s1_;
                                this.state_ = state = state | 0b1 /* add-active read(Object, String, InteropToStringNode, InteropLibrary) */;
                            }
                        }
                    }
                    if (s1_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return InteropReadStringMemberNode.read(arg0Value, arg1Value, s1_.coerceNode_, s1_.objs_);
                    }
                }
                {
                    InteropLibrary read1_objs__ = null;
                    {
                        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                        Node prev_ = encapsulating_.set(this);
                        try {
                            {
                                read1_objs__ = (INTEROP_LIBRARY_.getUncached(arg0Value));
                                if ((read1_objs__.isMemberReadable(arg0Value, arg1Value))) {
                                    this.read1_coerceNode_ = super.insert((InteropToStringNodeGen.create()));
                                    this.exclude_ = exclude = exclude | 0b1 /* add-excluded read(Object, String, InteropToStringNode, InteropLibrary) */;
                                    this.read0_cache = null;
                                    state = state & 0xfffffffe /* remove-active read(Object, String, InteropToStringNode, InteropLibrary) */;
                                    this.state_ = state = state | 0b10 /* add-active read(Object, String, InteropToStringNode, InteropLibrary) */;
                                    lock.unlock();
                                    hasLock = false;
                                    return InteropReadStringMemberNode.read(arg0Value, arg1Value, this.read1_coerceNode_, read1_objs__);
                                }
                            }
                        } finally {
                            encapsulating_.set(prev_);
                        }
                    }
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null, null}, arg0Value, arg1Value);
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
                Read0Data s1_ = this.read0_cache;
                if ((s1_ == null || s1_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        public static InteropReadStringMemberNode create() {
            return new InteropReadStringMemberNodeGen();
        }

        public static InteropReadStringMemberNode getUncached() {
            return InteropReadStringMemberNodeGen.UNCACHED;
        }

        @GeneratedBy(InteropReadStringMemberNode.class)
        private static final class Read0Data extends Node {

            @Child Read0Data next_;
            @Child InteropToStringNode coerceNode_;
            @Child InteropLibrary objs_;

            Read0Data(Read0Data next_) {
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
        @GeneratedBy(InteropReadStringMemberNode.class)
        private static final class Uncached extends InteropReadStringMemberNode {

            @TruffleBoundary
            @Override
            public String execute(Object arg0Value, String arg1Value) {
                if (((INTEROP_LIBRARY_.getUncached(arg0Value)).isMemberReadable(arg0Value, arg1Value))) {
                    return InteropReadStringMemberNode.read(arg0Value, arg1Value, (InteropToStringNodeGen.getUncached()), (INTEROP_LIBRARY_.getUncached(arg0Value)));
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null, null}, arg0Value, arg1Value);
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
    @GeneratedBy(InteropToBooleanNode.class)
    public static final class InteropToBooleanNodeGen extends InteropToBooleanNode {

        private static final Uncached UNCACHED = new Uncached();

        @CompilationFinal private volatile int state_;
        @CompilationFinal private volatile int exclude_;
        @Child private Coerce0Data coerce0_cache;

        private InteropToBooleanNodeGen() {
        }

        @ExplodeLoop
        @Override
        public boolean execute(Object arg0Value) {
            int state = state_;
            if ((state & 0b1) != 0 /* is-active coerceDirect(boolean) */ && arg0Value instanceof Boolean) {
                boolean arg0Value_ = (boolean) arg0Value;
                return InteropToBooleanNode.coerceDirect(arg0Value_);
            }
            if ((state & 0b110) != 0 /* is-active coerce(Object, InteropLibrary) || coerce(Object, InteropLibrary) */) {
                if ((state & 0b10) != 0 /* is-active coerce(Object, InteropLibrary) */) {
                    Coerce0Data s2_ = this.coerce0_cache;
                    while (s2_ != null) {
                        if ((s2_.objs_.accepts(arg0Value)) && (s2_.objs_.isBoolean(arg0Value))) {
                            return InteropToBooleanNode.coerce(arg0Value, s2_.objs_);
                        }
                        s2_ = s2_.next_;
                    }
                }
                if ((state & 0b100) != 0 /* is-active coerce(Object, InteropLibrary) */) {
                    EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                    Node prev_ = encapsulating_.set(this);
                    try {
                        {
                            InteropLibrary coerce1_objs__ = (INTEROP_LIBRARY_.getUncached(arg0Value));
                            if ((coerce1_objs__.isBoolean(arg0Value))) {
                                return InteropToBooleanNode.coerce(arg0Value, coerce1_objs__);
                            }
                        }
                    } finally {
                        encapsulating_.set(prev_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value);
        }

        private boolean executeAndSpecialize(Object arg0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int exclude = exclude_;
            try {
                if (arg0Value instanceof Boolean) {
                    boolean arg0Value_ = (boolean) arg0Value;
                    this.state_ = state = state | 0b1 /* add-active coerceDirect(boolean) */;
                    lock.unlock();
                    hasLock = false;
                    return InteropToBooleanNode.coerceDirect(arg0Value_);
                }
                if ((exclude) == 0 /* is-not-excluded coerce(Object, InteropLibrary) */) {
                    int count2_ = 0;
                    Coerce0Data s2_ = this.coerce0_cache;
                    if ((state & 0b10) != 0 /* is-active coerce(Object, InteropLibrary) */) {
                        while (s2_ != null) {
                            if ((s2_.objs_.accepts(arg0Value)) && (s2_.objs_.isBoolean(arg0Value))) {
                                break;
                            }
                            s2_ = s2_.next_;
                            count2_++;
                        }
                    }
                    if (s2_ == null) {
                        {
                            InteropLibrary objs__ = super.insert((INTEROP_LIBRARY_.create(arg0Value)));
                            // assert (s2_.objs_.accepts(arg0Value));
                            if ((objs__.isBoolean(arg0Value)) && count2_ < (3)) {
                                s2_ = super.insert(new Coerce0Data(coerce0_cache));
                                s2_.objs_ = s2_.insertAccessor(objs__);
                                this.coerce0_cache = s2_;
                                this.state_ = state = state | 0b10 /* add-active coerce(Object, InteropLibrary) */;
                            }
                        }
                    }
                    if (s2_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return InteropToBooleanNode.coerce(arg0Value, s2_.objs_);
                    }
                }
                {
                    InteropLibrary coerce1_objs__ = null;
                    {
                        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                        Node prev_ = encapsulating_.set(this);
                        try {
                            {
                                coerce1_objs__ = (INTEROP_LIBRARY_.getUncached(arg0Value));
                                if ((coerce1_objs__.isBoolean(arg0Value))) {
                                    this.exclude_ = exclude = exclude | 0b1 /* add-excluded coerce(Object, InteropLibrary) */;
                                    this.coerce0_cache = null;
                                    state = state & 0xfffffffd /* remove-active coerce(Object, InteropLibrary) */;
                                    this.state_ = state = state | 0b100 /* add-active coerce(Object, InteropLibrary) */;
                                    lock.unlock();
                                    hasLock = false;
                                    return InteropToBooleanNode.coerce(arg0Value, coerce1_objs__);
                                }
                            }
                        } finally {
                            encapsulating_.set(prev_);
                        }
                    }
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
            if (state == 0b0) {
                return NodeCost.UNINITIALIZED;
            } else if ((state & (state - 1)) == 0 /* is-single-active  */) {
                Coerce0Data s2_ = this.coerce0_cache;
                if ((s2_ == null || s2_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        public static InteropToBooleanNode create() {
            return new InteropToBooleanNodeGen();
        }

        public static InteropToBooleanNode getUncached() {
            return InteropToBooleanNodeGen.UNCACHED;
        }

        @GeneratedBy(InteropToBooleanNode.class)
        private static final class Coerce0Data extends Node {

            @Child Coerce0Data next_;
            @Child InteropLibrary objs_;

            Coerce0Data(Coerce0Data next_) {
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
        @GeneratedBy(InteropToBooleanNode.class)
        private static final class Uncached extends InteropToBooleanNode {

            @TruffleBoundary
            @Override
            public boolean execute(Object arg0Value) {
                if (arg0Value instanceof Boolean) {
                    boolean arg0Value_ = (boolean) arg0Value;
                    return InteropToBooleanNode.coerceDirect(arg0Value_);
                }
                if (((INTEROP_LIBRARY_.getUncached(arg0Value)).isBoolean(arg0Value))) {
                    return InteropToBooleanNode.coerce(arg0Value, (INTEROP_LIBRARY_.getUncached(arg0Value)));
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null}, arg0Value);
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
    @GeneratedBy(InteropToIntNode.class)
    public static final class InteropToIntNodeGen extends InteropToIntNode {

        private static final Uncached UNCACHED = new Uncached();

        @CompilationFinal private volatile int state_;
        @CompilationFinal private volatile int exclude_;
        @Child private Coerce0Data coerce0_cache;

        private InteropToIntNodeGen() {
        }

        @ExplodeLoop
        @Override
        public int execute(Object arg0Value) {
            int state = state_;
            if ((state & 0b1) != 0 /* is-active coerceDirect(int) */ && arg0Value instanceof Integer) {
                int arg0Value_ = (int) arg0Value;
                return InteropToIntNode.coerceDirect(arg0Value_);
            }
            if ((state & 0b110) != 0 /* is-active coerce(Object, InteropLibrary) || coerce(Object, InteropLibrary) */) {
                if ((state & 0b10) != 0 /* is-active coerce(Object, InteropLibrary) */) {
                    Coerce0Data s2_ = this.coerce0_cache;
                    while (s2_ != null) {
                        if ((s2_.objs_.accepts(arg0Value)) && (s2_.objs_.fitsInInt(arg0Value))) {
                            return InteropToIntNode.coerce(arg0Value, s2_.objs_);
                        }
                        s2_ = s2_.next_;
                    }
                }
                if ((state & 0b100) != 0 /* is-active coerce(Object, InteropLibrary) */) {
                    EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                    Node prev_ = encapsulating_.set(this);
                    try {
                        {
                            InteropLibrary coerce1_objs__ = (INTEROP_LIBRARY_.getUncached(arg0Value));
                            if ((coerce1_objs__.fitsInInt(arg0Value))) {
                                return InteropToIntNode.coerce(arg0Value, coerce1_objs__);
                            }
                        }
                    } finally {
                        encapsulating_.set(prev_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value);
        }

        private int executeAndSpecialize(Object arg0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int exclude = exclude_;
            try {
                if (arg0Value instanceof Integer) {
                    int arg0Value_ = (int) arg0Value;
                    this.state_ = state = state | 0b1 /* add-active coerceDirect(int) */;
                    lock.unlock();
                    hasLock = false;
                    return InteropToIntNode.coerceDirect(arg0Value_);
                }
                if ((exclude) == 0 /* is-not-excluded coerce(Object, InteropLibrary) */) {
                    int count2_ = 0;
                    Coerce0Data s2_ = this.coerce0_cache;
                    if ((state & 0b10) != 0 /* is-active coerce(Object, InteropLibrary) */) {
                        while (s2_ != null) {
                            if ((s2_.objs_.accepts(arg0Value)) && (s2_.objs_.fitsInInt(arg0Value))) {
                                break;
                            }
                            s2_ = s2_.next_;
                            count2_++;
                        }
                    }
                    if (s2_ == null) {
                        {
                            InteropLibrary objs__ = super.insert((INTEROP_LIBRARY_.create(arg0Value)));
                            // assert (s2_.objs_.accepts(arg0Value));
                            if ((objs__.fitsInInt(arg0Value)) && count2_ < (3)) {
                                s2_ = super.insert(new Coerce0Data(coerce0_cache));
                                s2_.objs_ = s2_.insertAccessor(objs__);
                                this.coerce0_cache = s2_;
                                this.state_ = state = state | 0b10 /* add-active coerce(Object, InteropLibrary) */;
                            }
                        }
                    }
                    if (s2_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return InteropToIntNode.coerce(arg0Value, s2_.objs_);
                    }
                }
                {
                    InteropLibrary coerce1_objs__ = null;
                    {
                        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                        Node prev_ = encapsulating_.set(this);
                        try {
                            {
                                coerce1_objs__ = (INTEROP_LIBRARY_.getUncached(arg0Value));
                                if ((coerce1_objs__.fitsInInt(arg0Value))) {
                                    this.exclude_ = exclude = exclude | 0b1 /* add-excluded coerce(Object, InteropLibrary) */;
                                    this.coerce0_cache = null;
                                    state = state & 0xfffffffd /* remove-active coerce(Object, InteropLibrary) */;
                                    this.state_ = state = state | 0b100 /* add-active coerce(Object, InteropLibrary) */;
                                    lock.unlock();
                                    hasLock = false;
                                    return InteropToIntNode.coerce(arg0Value, coerce1_objs__);
                                }
                            }
                        } finally {
                            encapsulating_.set(prev_);
                        }
                    }
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
            if (state == 0b0) {
                return NodeCost.UNINITIALIZED;
            } else if ((state & (state - 1)) == 0 /* is-single-active  */) {
                Coerce0Data s2_ = this.coerce0_cache;
                if ((s2_ == null || s2_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        public static InteropToIntNode create() {
            return new InteropToIntNodeGen();
        }

        public static InteropToIntNode getUncached() {
            return InteropToIntNodeGen.UNCACHED;
        }

        @GeneratedBy(InteropToIntNode.class)
        private static final class Coerce0Data extends Node {

            @Child Coerce0Data next_;
            @Child InteropLibrary objs_;

            Coerce0Data(Coerce0Data next_) {
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
        @GeneratedBy(InteropToIntNode.class)
        private static final class Uncached extends InteropToIntNode {

            @TruffleBoundary
            @Override
            public int execute(Object arg0Value) {
                if (arg0Value instanceof Integer) {
                    int arg0Value_ = (int) arg0Value;
                    return InteropToIntNode.coerceDirect(arg0Value_);
                }
                if (((INTEROP_LIBRARY_.getUncached(arg0Value)).fitsInInt(arg0Value))) {
                    return InteropToIntNode.coerce(arg0Value, (INTEROP_LIBRARY_.getUncached(arg0Value)));
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null}, arg0Value);
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
    @GeneratedBy(InteropToStringNode.class)
    public static final class InteropToStringNodeGen extends InteropToStringNode {

        private static final Uncached UNCACHED = new Uncached();

        @CompilationFinal private volatile int state_;
        @CompilationFinal private volatile int exclude_;
        @Child private Coerce0Data coerce0_cache;

        private InteropToStringNodeGen() {
        }

        @ExplodeLoop
        @Override
        public String execute(Object arg0Value) {
            int state = state_;
            if ((state & 0b1) != 0 /* is-active coerceDirect(String) */ && arg0Value instanceof String) {
                String arg0Value_ = (String) arg0Value;
                return InteropToStringNode.coerceDirect(arg0Value_);
            }
            if ((state & 0b110) != 0 /* is-active coerce(Object, InteropLibrary) || coerce(Object, InteropLibrary) */) {
                if ((state & 0b10) != 0 /* is-active coerce(Object, InteropLibrary) */) {
                    Coerce0Data s2_ = this.coerce0_cache;
                    while (s2_ != null) {
                        if ((s2_.objs_.accepts(arg0Value)) && (s2_.objs_.isString(arg0Value))) {
                            return InteropToStringNode.coerce(arg0Value, s2_.objs_);
                        }
                        s2_ = s2_.next_;
                    }
                }
                if ((state & 0b100) != 0 /* is-active coerce(Object, InteropLibrary) */) {
                    EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                    Node prev_ = encapsulating_.set(this);
                    try {
                        {
                            InteropLibrary coerce1_objs__ = (INTEROP_LIBRARY_.getUncached(arg0Value));
                            if ((coerce1_objs__.isString(arg0Value))) {
                                return InteropToStringNode.coerce(arg0Value, coerce1_objs__);
                            }
                        }
                    } finally {
                        encapsulating_.set(prev_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value);
        }

        private String executeAndSpecialize(Object arg0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int exclude = exclude_;
            try {
                if (arg0Value instanceof String) {
                    String arg0Value_ = (String) arg0Value;
                    this.state_ = state = state | 0b1 /* add-active coerceDirect(String) */;
                    lock.unlock();
                    hasLock = false;
                    return InteropToStringNode.coerceDirect(arg0Value_);
                }
                if ((exclude) == 0 /* is-not-excluded coerce(Object, InteropLibrary) */) {
                    int count2_ = 0;
                    Coerce0Data s2_ = this.coerce0_cache;
                    if ((state & 0b10) != 0 /* is-active coerce(Object, InteropLibrary) */) {
                        while (s2_ != null) {
                            if ((s2_.objs_.accepts(arg0Value)) && (s2_.objs_.isString(arg0Value))) {
                                break;
                            }
                            s2_ = s2_.next_;
                            count2_++;
                        }
                    }
                    if (s2_ == null) {
                        {
                            InteropLibrary objs__ = super.insert((INTEROP_LIBRARY_.create(arg0Value)));
                            // assert (s2_.objs_.accepts(arg0Value));
                            if ((objs__.isString(arg0Value)) && count2_ < (3)) {
                                s2_ = super.insert(new Coerce0Data(coerce0_cache));
                                s2_.objs_ = s2_.insertAccessor(objs__);
                                this.coerce0_cache = s2_;
                                this.state_ = state = state | 0b10 /* add-active coerce(Object, InteropLibrary) */;
                            }
                        }
                    }
                    if (s2_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return InteropToStringNode.coerce(arg0Value, s2_.objs_);
                    }
                }
                {
                    InteropLibrary coerce1_objs__ = null;
                    {
                        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                        Node prev_ = encapsulating_.set(this);
                        try {
                            {
                                coerce1_objs__ = (INTEROP_LIBRARY_.getUncached(arg0Value));
                                if ((coerce1_objs__.isString(arg0Value))) {
                                    this.exclude_ = exclude = exclude | 0b1 /* add-excluded coerce(Object, InteropLibrary) */;
                                    this.coerce0_cache = null;
                                    state = state & 0xfffffffd /* remove-active coerce(Object, InteropLibrary) */;
                                    this.state_ = state = state | 0b100 /* add-active coerce(Object, InteropLibrary) */;
                                    lock.unlock();
                                    hasLock = false;
                                    return InteropToStringNode.coerce(arg0Value, coerce1_objs__);
                                }
                            }
                        } finally {
                            encapsulating_.set(prev_);
                        }
                    }
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
            if (state == 0b0) {
                return NodeCost.UNINITIALIZED;
            } else if ((state & (state - 1)) == 0 /* is-single-active  */) {
                Coerce0Data s2_ = this.coerce0_cache;
                if ((s2_ == null || s2_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        public static InteropToStringNode create() {
            return new InteropToStringNodeGen();
        }

        public static InteropToStringNode getUncached() {
            return InteropToStringNodeGen.UNCACHED;
        }

        @GeneratedBy(InteropToStringNode.class)
        private static final class Coerce0Data extends Node {

            @Child Coerce0Data next_;
            @Child InteropLibrary objs_;

            Coerce0Data(Coerce0Data next_) {
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
        @GeneratedBy(InteropToStringNode.class)
        private static final class Uncached extends InteropToStringNode {

            @TruffleBoundary
            @Override
            public String execute(Object arg0Value) {
                if (arg0Value instanceof String) {
                    String arg0Value_ = (String) arg0Value;
                    return InteropToStringNode.coerceDirect(arg0Value_);
                }
                if (((INTEROP_LIBRARY_.getUncached(arg0Value)).isString(arg0Value))) {
                    return InteropToStringNode.coerce(arg0Value, (INTEROP_LIBRARY_.getUncached(arg0Value)));
                }
                throw new UnsupportedSpecializationException(this, new Node[] {null}, arg0Value);
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
    @GeneratedBy(InvokeExecMethodNode.class)
    public static final class InvokeExecMethodNodeGen extends InvokeExecMethodNode {

        private static final Uncached UNCACHED = new Uncached();

        @CompilationFinal private volatile int state_;
        @CompilationFinal private volatile int exclude_;
        @Child private Exec0Data exec0_cache;

        private InvokeExecMethodNodeGen() {
        }

        @ExplodeLoop
        @Override
        public Object execute(Object arg0Value, String arg1Value, long arg2Value) {
            int state = state_;
            if (state != 0 /* is-active exec(Object, String, long, InteropLibrary) || exec(Object, String, long, InteropLibrary) */) {
                if ((state & 0b1) != 0 /* is-active exec(Object, String, long, InteropLibrary) */) {
                    Exec0Data s1_ = this.exec0_cache;
                    while (s1_ != null) {
                        if ((s1_.objs_.accepts(arg0Value)) && (s1_.objs_.isMemberInvocable(arg0Value, CompiledRegex.EXEC))) {
                            return InvokeExecMethodNode.exec(arg0Value, arg1Value, arg2Value, s1_.objs_);
                        }
                        s1_ = s1_.next_;
                    }
                }
                if ((state & 0b10) != 0 /* is-active exec(Object, String, long, InteropLibrary) */) {
                    EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                    Node prev_ = encapsulating_.set(this);
                    try {
                        {
                            InteropLibrary exec1_objs__ = (INTEROP_LIBRARY_.getUncached(arg0Value));
                            if ((exec1_objs__.isMemberInvocable(arg0Value, CompiledRegex.EXEC))) {
                                return InvokeExecMethodNode.exec(arg0Value, arg1Value, arg2Value, exec1_objs__);
                            }
                        }
                    } finally {
                        encapsulating_.set(prev_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value, arg1Value, arg2Value);
        }

        private Object executeAndSpecialize(Object arg0Value, String arg1Value, long arg2Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int exclude = exclude_;
            try {
                if ((exclude) == 0 /* is-not-excluded exec(Object, String, long, InteropLibrary) */) {
                    int count1_ = 0;
                    Exec0Data s1_ = this.exec0_cache;
                    if ((state & 0b1) != 0 /* is-active exec(Object, String, long, InteropLibrary) */) {
                        while (s1_ != null) {
                            if ((s1_.objs_.accepts(arg0Value)) && (s1_.objs_.isMemberInvocable(arg0Value, CompiledRegex.EXEC))) {
                                break;
                            }
                            s1_ = s1_.next_;
                            count1_++;
                        }
                    }
                    if (s1_ == null) {
                        {
                            InteropLibrary objs__ = super.insert((INTEROP_LIBRARY_.create(arg0Value)));
                            // assert (s1_.objs_.accepts(arg0Value));
                            if ((objs__.isMemberInvocable(arg0Value, CompiledRegex.EXEC)) && count1_ < (3)) {
                                s1_ = super.insert(new Exec0Data(exec0_cache));
                                s1_.objs_ = s1_.insertAccessor(objs__);
                                this.exec0_cache = s1_;
                                this.state_ = state = state | 0b1 /* add-active exec(Object, String, long, InteropLibrary) */;
                            }
                        }
                    }
                    if (s1_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return InvokeExecMethodNode.exec(arg0Value, arg1Value, arg2Value, s1_.objs_);
                    }
                }
                {
                    InteropLibrary exec1_objs__ = null;
                    {
                        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                        Node prev_ = encapsulating_.set(this);
                        try {
                            {
                                exec1_objs__ = (INTEROP_LIBRARY_.getUncached(arg0Value));
                                if ((exec1_objs__.isMemberInvocable(arg0Value, CompiledRegex.EXEC))) {
                                    this.exclude_ = exclude = exclude | 0b1 /* add-excluded exec(Object, String, long, InteropLibrary) */;
                                    this.exec0_cache = null;
                                    state = state & 0xfffffffe /* remove-active exec(Object, String, long, InteropLibrary) */;
                                    this.state_ = state = state | 0b10 /* add-active exec(Object, String, long, InteropLibrary) */;
                                    lock.unlock();
                                    hasLock = false;
                                    return InvokeExecMethodNode.exec(arg0Value, arg1Value, arg2Value, exec1_objs__);
                                }
                            }
                        } finally {
                            encapsulating_.set(prev_);
                        }
                    }
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
            if (state == 0b0) {
                return NodeCost.UNINITIALIZED;
            } else if ((state & (state - 1)) == 0 /* is-single-active  */) {
                Exec0Data s1_ = this.exec0_cache;
                if ((s1_ == null || s1_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        public static InvokeExecMethodNode create() {
            return new InvokeExecMethodNodeGen();
        }

        public static InvokeExecMethodNode getUncached() {
            return InvokeExecMethodNodeGen.UNCACHED;
        }

        @GeneratedBy(InvokeExecMethodNode.class)
        private static final class Exec0Data extends Node {

            @Child Exec0Data next_;
            @Child InteropLibrary objs_;

            Exec0Data(Exec0Data next_) {
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
        @GeneratedBy(InvokeExecMethodNode.class)
        private static final class Uncached extends InvokeExecMethodNode {

            @TruffleBoundary
            @Override
            public Object execute(Object arg0Value, String arg1Value, long arg2Value) {
                if (((INTEROP_LIBRARY_.getUncached(arg0Value)).isMemberInvocable(arg0Value, CompiledRegex.EXEC))) {
                    return InvokeExecMethodNode.exec(arg0Value, arg1Value, arg2Value, (INTEROP_LIBRARY_.getUncached(arg0Value)));
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
    @GeneratedBy(InvokeGetGroupBoundariesMethodNode.class)
    public static final class InvokeGetGroupBoundariesMethodNodeGen extends InvokeGetGroupBoundariesMethodNode {

        private static final Uncached UNCACHED = new Uncached();

        @CompilationFinal private volatile int state_;
        @CompilationFinal private volatile int exclude_;
        @Child private Exec0Data exec0_cache;
        @Child private InteropToIntNode exec1_toIntNode_;

        private InvokeGetGroupBoundariesMethodNodeGen() {
        }

        @ExplodeLoop
        @Override
        public int execute(Object arg0Value, String arg1Value, int arg2Value) {
            int state = state_;
            if (state != 0 /* is-active exec(Object, String, int, InteropLibrary, InteropToIntNode) || exec(Object, String, int, InteropLibrary, InteropToIntNode) */) {
                if ((state & 0b1) != 0 /* is-active exec(Object, String, int, InteropLibrary, InteropToIntNode) */) {
                    Exec0Data s1_ = this.exec0_cache;
                    while (s1_ != null) {
                        if ((s1_.objs_.accepts(arg0Value)) && (s1_.objs_.isMemberInvocable(arg0Value, arg1Value))) {
                            return InvokeGetGroupBoundariesMethodNode.exec(arg0Value, arg1Value, arg2Value, s1_.objs_, s1_.toIntNode_);
                        }
                        s1_ = s1_.next_;
                    }
                }
                if ((state & 0b10) != 0 /* is-active exec(Object, String, int, InteropLibrary, InteropToIntNode) */) {
                    EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                    Node prev_ = encapsulating_.set(this);
                    try {
                        {
                            InteropLibrary exec1_objs__ = (INTEROP_LIBRARY_.getUncached(arg0Value));
                            if ((exec1_objs__.isMemberInvocable(arg0Value, arg1Value))) {
                                return InvokeGetGroupBoundariesMethodNode.exec(arg0Value, arg1Value, arg2Value, exec1_objs__, this.exec1_toIntNode_);
                            }
                        }
                    } finally {
                        encapsulating_.set(prev_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value, arg1Value, arg2Value);
        }

        private int executeAndSpecialize(Object arg0Value, String arg1Value, int arg2Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int exclude = exclude_;
            try {
                if ((exclude) == 0 /* is-not-excluded exec(Object, String, int, InteropLibrary, InteropToIntNode) */) {
                    int count1_ = 0;
                    Exec0Data s1_ = this.exec0_cache;
                    if ((state & 0b1) != 0 /* is-active exec(Object, String, int, InteropLibrary, InteropToIntNode) */) {
                        while (s1_ != null) {
                            if ((s1_.objs_.accepts(arg0Value)) && (s1_.objs_.isMemberInvocable(arg0Value, arg1Value))) {
                                break;
                            }
                            s1_ = s1_.next_;
                            count1_++;
                        }
                    }
                    if (s1_ == null) {
                        {
                            InteropLibrary objs__ = super.insert((INTEROP_LIBRARY_.create(arg0Value)));
                            // assert (s1_.objs_.accepts(arg0Value));
                            if ((objs__.isMemberInvocable(arg0Value, arg1Value)) && count1_ < (9)) {
                                s1_ = super.insert(new Exec0Data(exec0_cache));
                                s1_.objs_ = s1_.insertAccessor(objs__);
                                s1_.toIntNode_ = s1_.insertAccessor((InteropToIntNodeGen.create()));
                                this.exec0_cache = s1_;
                                this.state_ = state = state | 0b1 /* add-active exec(Object, String, int, InteropLibrary, InteropToIntNode) */;
                            }
                        }
                    }
                    if (s1_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return InvokeGetGroupBoundariesMethodNode.exec(arg0Value, arg1Value, arg2Value, s1_.objs_, s1_.toIntNode_);
                    }
                }
                {
                    InteropLibrary exec1_objs__ = null;
                    {
                        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                        Node prev_ = encapsulating_.set(this);
                        try {
                            {
                                exec1_objs__ = (INTEROP_LIBRARY_.getUncached(arg0Value));
                                if ((exec1_objs__.isMemberInvocable(arg0Value, arg1Value))) {
                                    this.exec1_toIntNode_ = super.insert((InteropToIntNodeGen.create()));
                                    this.exclude_ = exclude = exclude | 0b1 /* add-excluded exec(Object, String, int, InteropLibrary, InteropToIntNode) */;
                                    this.exec0_cache = null;
                                    state = state & 0xfffffffe /* remove-active exec(Object, String, int, InteropLibrary, InteropToIntNode) */;
                                    this.state_ = state = state | 0b10 /* add-active exec(Object, String, int, InteropLibrary, InteropToIntNode) */;
                                    lock.unlock();
                                    hasLock = false;
                                    return InvokeGetGroupBoundariesMethodNode.exec(arg0Value, arg1Value, arg2Value, exec1_objs__, this.exec1_toIntNode_);
                                }
                            }
                        } finally {
                            encapsulating_.set(prev_);
                        }
                    }
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
            if (state == 0b0) {
                return NodeCost.UNINITIALIZED;
            } else if ((state & (state - 1)) == 0 /* is-single-active  */) {
                Exec0Data s1_ = this.exec0_cache;
                if ((s1_ == null || s1_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        public static InvokeGetGroupBoundariesMethodNode create() {
            return new InvokeGetGroupBoundariesMethodNodeGen();
        }

        public static InvokeGetGroupBoundariesMethodNode getUncached() {
            return InvokeGetGroupBoundariesMethodNodeGen.UNCACHED;
        }

        @GeneratedBy(InvokeGetGroupBoundariesMethodNode.class)
        private static final class Exec0Data extends Node {

            @Child Exec0Data next_;
            @Child InteropLibrary objs_;
            @Child InteropToIntNode toIntNode_;

            Exec0Data(Exec0Data next_) {
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
        @GeneratedBy(InvokeGetGroupBoundariesMethodNode.class)
        private static final class Uncached extends InvokeGetGroupBoundariesMethodNode {

            @TruffleBoundary
            @Override
            public int execute(Object arg0Value, String arg1Value, int arg2Value) {
                if (((INTEROP_LIBRARY_.getUncached(arg0Value)).isMemberInvocable(arg0Value, arg1Value))) {
                    return InvokeGetGroupBoundariesMethodNode.exec(arg0Value, arg1Value, arg2Value, (INTEROP_LIBRARY_.getUncached(arg0Value)), (InteropToIntNodeGen.getUncached()));
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
    @GeneratedBy(CompileRegexNode.class)
    public static final class CompileRegexNodeGen extends CompileRegexNode {

        private static final Uncached UNCACHED = new Uncached();

        @CompilationFinal private volatile int state_;
        @CompilationFinal private volatile int exclude_;
        @Child private Exec0Data exec0_cache;

        private CompileRegexNodeGen() {
        }

        @ExplodeLoop
        @Override
        public Object execute(Object arg0Value, String arg1Value, String arg2Value) {
            int state = state_;
            if (state != 0 /* is-active exec(Object, String, String, InteropLibrary) || exec(Object, String, String, InteropLibrary) */) {
                if ((state & 0b1) != 0 /* is-active exec(Object, String, String, InteropLibrary) */) {
                    Exec0Data s1_ = this.exec0_cache;
                    while (s1_ != null) {
                        if ((s1_.objs_.accepts(arg0Value)) && (s1_.objs_.isExecutable(arg0Value))) {
                            return CompileRegexNode.exec(arg0Value, arg1Value, arg2Value, s1_.objs_);
                        }
                        s1_ = s1_.next_;
                    }
                }
                if ((state & 0b10) != 0 /* is-active exec(Object, String, String, InteropLibrary) */) {
                    EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                    Node prev_ = encapsulating_.set(this);
                    try {
                        {
                            InteropLibrary exec1_objs__ = (INTEROP_LIBRARY_.getUncached(arg0Value));
                            if ((exec1_objs__.isExecutable(arg0Value))) {
                                return CompileRegexNode.exec(arg0Value, arg1Value, arg2Value, exec1_objs__);
                            }
                        }
                    } finally {
                        encapsulating_.set(prev_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value, arg1Value, arg2Value);
        }

        private Object executeAndSpecialize(Object arg0Value, String arg1Value, String arg2Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int exclude = exclude_;
            try {
                if ((exclude) == 0 /* is-not-excluded exec(Object, String, String, InteropLibrary) */) {
                    int count1_ = 0;
                    Exec0Data s1_ = this.exec0_cache;
                    if ((state & 0b1) != 0 /* is-active exec(Object, String, String, InteropLibrary) */) {
                        while (s1_ != null) {
                            if ((s1_.objs_.accepts(arg0Value)) && (s1_.objs_.isExecutable(arg0Value))) {
                                break;
                            }
                            s1_ = s1_.next_;
                            count1_++;
                        }
                    }
                    if (s1_ == null) {
                        {
                            InteropLibrary objs__ = super.insert((INTEROP_LIBRARY_.create(arg0Value)));
                            // assert (s1_.objs_.accepts(arg0Value));
                            if ((objs__.isExecutable(arg0Value)) && count1_ < (3)) {
                                s1_ = super.insert(new Exec0Data(exec0_cache));
                                s1_.objs_ = s1_.insertAccessor(objs__);
                                this.exec0_cache = s1_;
                                this.state_ = state = state | 0b1 /* add-active exec(Object, String, String, InteropLibrary) */;
                            }
                        }
                    }
                    if (s1_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return CompileRegexNode.exec(arg0Value, arg1Value, arg2Value, s1_.objs_);
                    }
                }
                {
                    InteropLibrary exec1_objs__ = null;
                    {
                        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                        Node prev_ = encapsulating_.set(this);
                        try {
                            {
                                exec1_objs__ = (INTEROP_LIBRARY_.getUncached(arg0Value));
                                if ((exec1_objs__.isExecutable(arg0Value))) {
                                    this.exclude_ = exclude = exclude | 0b1 /* add-excluded exec(Object, String, String, InteropLibrary) */;
                                    this.exec0_cache = null;
                                    state = state & 0xfffffffe /* remove-active exec(Object, String, String, InteropLibrary) */;
                                    this.state_ = state = state | 0b10 /* add-active exec(Object, String, String, InteropLibrary) */;
                                    lock.unlock();
                                    hasLock = false;
                                    return CompileRegexNode.exec(arg0Value, arg1Value, arg2Value, exec1_objs__);
                                }
                            }
                        } finally {
                            encapsulating_.set(prev_);
                        }
                    }
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
            if (state == 0b0) {
                return NodeCost.UNINITIALIZED;
            } else if ((state & (state - 1)) == 0 /* is-single-active  */) {
                Exec0Data s1_ = this.exec0_cache;
                if ((s1_ == null || s1_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        public static CompileRegexNode create() {
            return new CompileRegexNodeGen();
        }

        public static CompileRegexNode getUncached() {
            return CompileRegexNodeGen.UNCACHED;
        }

        @GeneratedBy(CompileRegexNode.class)
        private static final class Exec0Data extends Node {

            @Child Exec0Data next_;
            @Child InteropLibrary objs_;

            Exec0Data(Exec0Data next_) {
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
        @GeneratedBy(CompileRegexNode.class)
        private static final class Uncached extends CompileRegexNode {

            @TruffleBoundary
            @Override
            public Object execute(Object arg0Value, String arg1Value, String arg2Value) {
                if (((INTEROP_LIBRARY_.getUncached(arg0Value)).isExecutable(arg0Value))) {
                    return CompileRegexNode.exec(arg0Value, arg1Value, arg2Value, (INTEROP_LIBRARY_.getUncached(arg0Value)));
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
    @GeneratedBy(ValidateRegexNode.class)
    public static final class ValidateRegexNodeGen extends ValidateRegexNode {

        private static final Uncached UNCACHED = new Uncached();

        @CompilationFinal private volatile int state_;
        @CompilationFinal private volatile int exclude_;
        @Child private Exec0Data exec0_cache;

        private ValidateRegexNodeGen() {
        }

        @ExplodeLoop
        @Override
        public Object execute(Object arg0Value, String arg1Value, String arg2Value) {
            int state = state_;
            if (state != 0 /* is-active exec(Object, String, String, InteropLibrary) || exec(Object, String, String, InteropLibrary) */) {
                if ((state & 0b1) != 0 /* is-active exec(Object, String, String, InteropLibrary) */) {
                    Exec0Data s1_ = this.exec0_cache;
                    while (s1_ != null) {
                        if ((s1_.objs_.accepts(arg0Value)) && (s1_.objs_.isMemberInvocable(arg0Value, RegexEngine.VALIDATE))) {
                            return ValidateRegexNode.exec(arg0Value, arg1Value, arg2Value, s1_.objs_);
                        }
                        s1_ = s1_.next_;
                    }
                }
                if ((state & 0b10) != 0 /* is-active exec(Object, String, String, InteropLibrary) */) {
                    EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                    Node prev_ = encapsulating_.set(this);
                    try {
                        {
                            InteropLibrary exec1_objs__ = (INTEROP_LIBRARY_.getUncached(arg0Value));
                            if ((exec1_objs__.isMemberInvocable(arg0Value, RegexEngine.VALIDATE))) {
                                return ValidateRegexNode.exec(arg0Value, arg1Value, arg2Value, exec1_objs__);
                            }
                        }
                    } finally {
                        encapsulating_.set(prev_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arg0Value, arg1Value, arg2Value);
        }

        private Object executeAndSpecialize(Object arg0Value, String arg1Value, String arg2Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int exclude = exclude_;
            try {
                if ((exclude) == 0 /* is-not-excluded exec(Object, String, String, InteropLibrary) */) {
                    int count1_ = 0;
                    Exec0Data s1_ = this.exec0_cache;
                    if ((state & 0b1) != 0 /* is-active exec(Object, String, String, InteropLibrary) */) {
                        while (s1_ != null) {
                            if ((s1_.objs_.accepts(arg0Value)) && (s1_.objs_.isMemberInvocable(arg0Value, RegexEngine.VALIDATE))) {
                                break;
                            }
                            s1_ = s1_.next_;
                            count1_++;
                        }
                    }
                    if (s1_ == null) {
                        {
                            InteropLibrary objs__ = super.insert((INTEROP_LIBRARY_.create(arg0Value)));
                            // assert (s1_.objs_.accepts(arg0Value));
                            if ((objs__.isMemberInvocable(arg0Value, RegexEngine.VALIDATE)) && count1_ < (3)) {
                                s1_ = super.insert(new Exec0Data(exec0_cache));
                                s1_.objs_ = s1_.insertAccessor(objs__);
                                this.exec0_cache = s1_;
                                this.state_ = state = state | 0b1 /* add-active exec(Object, String, String, InteropLibrary) */;
                            }
                        }
                    }
                    if (s1_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return ValidateRegexNode.exec(arg0Value, arg1Value, arg2Value, s1_.objs_);
                    }
                }
                {
                    InteropLibrary exec1_objs__ = null;
                    {
                        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                        Node prev_ = encapsulating_.set(this);
                        try {
                            {
                                exec1_objs__ = (INTEROP_LIBRARY_.getUncached(arg0Value));
                                if ((exec1_objs__.isMemberInvocable(arg0Value, RegexEngine.VALIDATE))) {
                                    this.exclude_ = exclude = exclude | 0b1 /* add-excluded exec(Object, String, String, InteropLibrary) */;
                                    this.exec0_cache = null;
                                    state = state & 0xfffffffe /* remove-active exec(Object, String, String, InteropLibrary) */;
                                    this.state_ = state = state | 0b10 /* add-active exec(Object, String, String, InteropLibrary) */;
                                    lock.unlock();
                                    hasLock = false;
                                    return ValidateRegexNode.exec(arg0Value, arg1Value, arg2Value, exec1_objs__);
                                }
                            }
                        } finally {
                            encapsulating_.set(prev_);
                        }
                    }
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
            if (state == 0b0) {
                return NodeCost.UNINITIALIZED;
            } else if ((state & (state - 1)) == 0 /* is-single-active  */) {
                Exec0Data s1_ = this.exec0_cache;
                if ((s1_ == null || s1_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        public static ValidateRegexNode create() {
            return new ValidateRegexNodeGen();
        }

        public static ValidateRegexNode getUncached() {
            return ValidateRegexNodeGen.UNCACHED;
        }

        @GeneratedBy(ValidateRegexNode.class)
        private static final class Exec0Data extends Node {

            @Child Exec0Data next_;
            @Child InteropLibrary objs_;

            Exec0Data(Exec0Data next_) {
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
        @GeneratedBy(ValidateRegexNode.class)
        private static final class Uncached extends ValidateRegexNode {

            @TruffleBoundary
            @Override
            public Object execute(Object arg0Value, String arg1Value, String arg2Value) {
                if (((INTEROP_LIBRARY_.getUncached(arg0Value)).isMemberInvocable(arg0Value, RegexEngine.VALIDATE))) {
                    return ValidateRegexNode.exec(arg0Value, arg1Value, arg2Value, (INTEROP_LIBRARY_.getUncached(arg0Value)));
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
}
