// CheckStyle: start generated
package com.oracle.truffle.js.builtins.intl;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.js.builtins.intl.SegmentIteratorPrototypeBuiltins.SegmentIteratorAdvanceOpNode;
import com.oracle.truffle.js.builtins.intl.SegmentIteratorPrototypeBuiltins.SegmentIteratorFollowingNode;
import com.oracle.truffle.js.builtins.intl.SegmentIteratorPrototypeBuiltins.SegmentIteratorNextNode;
import com.oracle.truffle.js.builtins.intl.SegmentIteratorPrototypeBuiltins.SegmentIteratorOpNode;
import com.oracle.truffle.js.builtins.intl.SegmentIteratorPrototypeBuiltins.SegmentIteratorPrecedingNode;
import com.oracle.truffle.js.nodes.JSGuards;
import com.oracle.truffle.js.nodes.JSTypes;
import com.oracle.truffle.js.nodes.JSTypesGen;
import com.oracle.truffle.js.nodes.JavaScriptNode;
import com.oracle.truffle.js.nodes.cast.JSToIndexNode;
import com.oracle.truffle.js.nodes.function.JSBuiltin;
import com.oracle.truffle.js.runtime.JSContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

@GeneratedBy(SegmentIteratorPrototypeBuiltins.class)
public final class SegmentIteratorPrototypeBuiltinsFactory {

    @GeneratedBy(SegmentIteratorNextNode.class)
    public static final class SegmentIteratorNextNodeGen extends SegmentIteratorNextNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @CompilationFinal private int state_;

        private SegmentIteratorNextNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            if ((state & 0b1) != 0 /* is-active doSegmentIterator(VirtualFrame, DynamicObject) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((SegmentIteratorOpNode.isSegmentIterator(arguments0Value__))) {
                    return doSegmentIterator(frameValue, arguments0Value__);
                }
            }
            if ((state & 0b10) != 0 /* is-active doIncompatibleReceiver(Object) */) {
                if ((!(SegmentIteratorOpNode.isSegmentIterator(arguments0Value_)))) {
                    return doIncompatibleReceiver(arguments0Value_);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(frameValue, arguments0Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            execute(frameValue);
            return;
        }

        private DynamicObject executeAndSpecialize(VirtualFrame frameValue, Object arguments0Value) {
            int state = state_;
            if (JSTypes.isDynamicObject(arguments0Value)) {
                DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                if ((SegmentIteratorOpNode.isSegmentIterator(arguments0Value_))) {
                    this.state_ = state = state | 0b1 /* add-active doSegmentIterator(VirtualFrame, DynamicObject) */;
                    return doSegmentIterator(frameValue, arguments0Value_);
                }
            }
            if ((!(SegmentIteratorOpNode.isSegmentIterator(arguments0Value)))) {
                this.state_ = state = state | 0b10 /* add-active doIncompatibleReceiver(Object) */;
                return doIncompatibleReceiver(arguments0Value);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_}, arguments0Value);
        }

        @Override
        public NodeCost getCost() {
            int state = state_;
            if (state == 0b0) {
                return NodeCost.UNINITIALIZED;
            } else if ((state & (state - 1)) == 0 /* is-single-active  */) {
                return NodeCost.MONOMORPHIC;
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
            s[0] = "doSegmentIterator";
            if ((state & 0b1) != 0 /* is-active doSegmentIterator(VirtualFrame, DynamicObject) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doIncompatibleReceiver";
            if ((state & 0b10) != 0 /* is-active doIncompatibleReceiver(Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            return Provider.create(data);
        }

        public static SegmentIteratorNextNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new SegmentIteratorNextNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(SegmentIteratorAdvanceOpNode.class)
    public static final class SegmentIteratorAdvanceOpNodeGen extends SegmentIteratorAdvanceOpNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_;
        @Child private JSToIndexNode segmentIteratorWithFrom_toIndexNode_;

        private SegmentIteratorAdvanceOpNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if (state != 0 /* is-active doSegmentIteratorWithFrom(DynamicObject, Object, JSToIndexNode) || doSegmentIteratorNoFrom(DynamicObject, Object) || doIncompatibleReceiver(Object, Object) */) {
                if ((state & 0b11) != 0 /* is-active doSegmentIteratorWithFrom(DynamicObject, Object, JSToIndexNode) || doSegmentIteratorNoFrom(DynamicObject, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((state & 0b1) != 0 /* is-active doSegmentIteratorWithFrom(DynamicObject, Object, JSToIndexNode) */) {
                        if ((SegmentIteratorOpNode.isSegmentIterator(arguments0Value__)) && (!(JSGuards.isUndefined(arguments1Value_)))) {
                            return doSegmentIteratorWithFrom(arguments0Value__, arguments1Value_, this.segmentIteratorWithFrom_toIndexNode_);
                        }
                    }
                    if ((state & 0b10) != 0 /* is-active doSegmentIteratorNoFrom(DynamicObject, Object) */) {
                        if ((SegmentIteratorOpNode.isSegmentIterator(arguments0Value__)) && (JSGuards.isUndefined(arguments1Value_))) {
                            return doSegmentIteratorNoFrom(arguments0Value__, arguments1Value_);
                        }
                    }
                }
                if ((state & 0b100) != 0 /* is-active doIncompatibleReceiver(Object, Object) */) {
                    if ((!(SegmentIteratorOpNode.isSegmentIterator(arguments0Value_)))) {
                        return doIncompatibleReceiver(arguments0Value_, arguments1Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) throws UnexpectedResultException {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if ((state & 0b11) != 0 /* is-active doSegmentIteratorWithFrom(DynamicObject, Object, JSToIndexNode) || doSegmentIteratorNoFrom(DynamicObject, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state & 0b1) != 0 /* is-active doSegmentIteratorWithFrom(DynamicObject, Object, JSToIndexNode) */) {
                    if ((SegmentIteratorOpNode.isSegmentIterator(arguments0Value__)) && (!(JSGuards.isUndefined(arguments1Value_)))) {
                        return doSegmentIteratorWithFrom(arguments0Value__, arguments1Value_, this.segmentIteratorWithFrom_toIndexNode_);
                    }
                }
                if ((state & 0b10) != 0 /* is-active doSegmentIteratorNoFrom(DynamicObject, Object) */) {
                    if ((SegmentIteratorOpNode.isSegmentIterator(arguments0Value__)) && (JSGuards.isUndefined(arguments1Value_))) {
                        return doSegmentIteratorNoFrom(arguments0Value__, arguments1Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return JSTypesGen.expectBoolean(executeAndSpecialize(arguments0Value_, arguments1Value_));
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            int state = state_;
            try {
                if ((state & 0b100) == 0 /* only-active doSegmentIteratorWithFrom(DynamicObject, Object, JSToIndexNode) && doSegmentIteratorNoFrom(DynamicObject, Object) */ && state != 0  /* is-not doSegmentIteratorWithFrom(DynamicObject, Object, JSToIndexNode) && doSegmentIteratorNoFrom(DynamicObject, Object) && doIncompatibleReceiver(Object, Object) */) {
                    executeBoolean(frameValue);
                    return;
                }
                execute(frameValue);
                return;
            } catch (UnexpectedResultException ex) {
                return;
            }
        }

        private Object executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            try {
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((SegmentIteratorOpNode.isSegmentIterator(arguments0Value_)) && (!(JSGuards.isUndefined(arguments1Value)))) {
                        this.segmentIteratorWithFrom_toIndexNode_ = super.insert((JSToIndexNode.create()));
                        this.state_ = state = state | 0b1 /* add-active doSegmentIteratorWithFrom(DynamicObject, Object, JSToIndexNode) */;
                        lock.unlock();
                        hasLock = false;
                        return doSegmentIteratorWithFrom(arguments0Value_, arguments1Value, this.segmentIteratorWithFrom_toIndexNode_);
                    }
                    if ((SegmentIteratorOpNode.isSegmentIterator(arguments0Value_)) && (JSGuards.isUndefined(arguments1Value))) {
                        this.state_ = state = state | 0b10 /* add-active doSegmentIteratorNoFrom(DynamicObject, Object) */;
                        lock.unlock();
                        hasLock = false;
                        return doSegmentIteratorNoFrom(arguments0Value_, arguments1Value);
                    }
                }
                if ((!(SegmentIteratorOpNode.isSegmentIterator(arguments0Value)))) {
                    this.state_ = state = state | 0b100 /* add-active doIncompatibleReceiver(Object, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return doIncompatibleReceiver(arguments0Value, arguments1Value);
                }
                throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_}, arguments0Value, arguments1Value);
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
                return NodeCost.MONOMORPHIC;
            }
            return NodeCost.POLYMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[4];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "doSegmentIteratorWithFrom";
            if ((state & 0b1) != 0 /* is-active doSegmentIteratorWithFrom(DynamicObject, Object, JSToIndexNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.segmentIteratorWithFrom_toIndexNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doSegmentIteratorNoFrom";
            if ((state & 0b10) != 0 /* is-active doSegmentIteratorNoFrom(DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "doIncompatibleReceiver";
            if ((state & 0b100) != 0 /* is-active doIncompatibleReceiver(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static SegmentIteratorAdvanceOpNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new SegmentIteratorAdvanceOpNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(SegmentIteratorPrecedingNode.class)
    public static final class SegmentIteratorPrecedingNodeGen extends SegmentIteratorPrecedingNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_;
        @Child private JSToIndexNode segmentIteratorWithFrom_toIndexNode_;

        private SegmentIteratorPrecedingNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if (state != 0 /* is-active doSegmentIteratorWithFrom(DynamicObject, Object, JSToIndexNode) || doSegmentIteratorNoFrom(DynamicObject, Object) || doIncompatibleReceiver(Object, Object) */) {
                if ((state & 0b11) != 0 /* is-active doSegmentIteratorWithFrom(DynamicObject, Object, JSToIndexNode) || doSegmentIteratorNoFrom(DynamicObject, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((state & 0b1) != 0 /* is-active doSegmentIteratorWithFrom(DynamicObject, Object, JSToIndexNode) */) {
                        if ((SegmentIteratorOpNode.isSegmentIterator(arguments0Value__)) && (!(JSGuards.isUndefined(arguments1Value_)))) {
                            return doSegmentIteratorWithFrom(arguments0Value__, arguments1Value_, this.segmentIteratorWithFrom_toIndexNode_);
                        }
                    }
                    if ((state & 0b10) != 0 /* is-active doSegmentIteratorNoFrom(DynamicObject, Object) */) {
                        if ((SegmentIteratorOpNode.isSegmentIterator(arguments0Value__)) && (JSGuards.isUndefined(arguments1Value_))) {
                            return doSegmentIteratorNoFrom(arguments0Value__, arguments1Value_);
                        }
                    }
                }
                if ((state & 0b100) != 0 /* is-active doIncompatibleReceiver(Object, Object) */) {
                    if ((!(SegmentIteratorOpNode.isSegmentIterator(arguments0Value_)))) {
                        return doIncompatibleReceiver(arguments0Value_, arguments1Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) throws UnexpectedResultException {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if ((state & 0b11) != 0 /* is-active doSegmentIteratorWithFrom(DynamicObject, Object, JSToIndexNode) || doSegmentIteratorNoFrom(DynamicObject, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state & 0b1) != 0 /* is-active doSegmentIteratorWithFrom(DynamicObject, Object, JSToIndexNode) */) {
                    if ((SegmentIteratorOpNode.isSegmentIterator(arguments0Value__)) && (!(JSGuards.isUndefined(arguments1Value_)))) {
                        return doSegmentIteratorWithFrom(arguments0Value__, arguments1Value_, this.segmentIteratorWithFrom_toIndexNode_);
                    }
                }
                if ((state & 0b10) != 0 /* is-active doSegmentIteratorNoFrom(DynamicObject, Object) */) {
                    if ((SegmentIteratorOpNode.isSegmentIterator(arguments0Value__)) && (JSGuards.isUndefined(arguments1Value_))) {
                        return doSegmentIteratorNoFrom(arguments0Value__, arguments1Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return JSTypesGen.expectBoolean(executeAndSpecialize(arguments0Value_, arguments1Value_));
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            int state = state_;
            try {
                if ((state & 0b100) == 0 /* only-active doSegmentIteratorWithFrom(DynamicObject, Object, JSToIndexNode) && doSegmentIteratorNoFrom(DynamicObject, Object) */ && state != 0  /* is-not doSegmentIteratorWithFrom(DynamicObject, Object, JSToIndexNode) && doSegmentIteratorNoFrom(DynamicObject, Object) && doIncompatibleReceiver(Object, Object) */) {
                    executeBoolean(frameValue);
                    return;
                }
                execute(frameValue);
                return;
            } catch (UnexpectedResultException ex) {
                return;
            }
        }

        private Object executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            try {
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((SegmentIteratorOpNode.isSegmentIterator(arguments0Value_)) && (!(JSGuards.isUndefined(arguments1Value)))) {
                        this.segmentIteratorWithFrom_toIndexNode_ = super.insert((JSToIndexNode.create()));
                        this.state_ = state = state | 0b1 /* add-active doSegmentIteratorWithFrom(DynamicObject, Object, JSToIndexNode) */;
                        lock.unlock();
                        hasLock = false;
                        return doSegmentIteratorWithFrom(arguments0Value_, arguments1Value, this.segmentIteratorWithFrom_toIndexNode_);
                    }
                    if ((SegmentIteratorOpNode.isSegmentIterator(arguments0Value_)) && (JSGuards.isUndefined(arguments1Value))) {
                        this.state_ = state = state | 0b10 /* add-active doSegmentIteratorNoFrom(DynamicObject, Object) */;
                        lock.unlock();
                        hasLock = false;
                        return doSegmentIteratorNoFrom(arguments0Value_, arguments1Value);
                    }
                }
                if ((!(SegmentIteratorOpNode.isSegmentIterator(arguments0Value)))) {
                    this.state_ = state = state | 0b100 /* add-active doIncompatibleReceiver(Object, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return doIncompatibleReceiver(arguments0Value, arguments1Value);
                }
                throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_}, arguments0Value, arguments1Value);
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
                return NodeCost.MONOMORPHIC;
            }
            return NodeCost.POLYMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[4];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "doSegmentIteratorWithFrom";
            if ((state & 0b1) != 0 /* is-active doSegmentIteratorWithFrom(DynamicObject, Object, JSToIndexNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.segmentIteratorWithFrom_toIndexNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doSegmentIteratorNoFrom";
            if ((state & 0b10) != 0 /* is-active doSegmentIteratorNoFrom(DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "doIncompatibleReceiver";
            if ((state & 0b100) != 0 /* is-active doIncompatibleReceiver(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static SegmentIteratorPrecedingNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new SegmentIteratorPrecedingNodeGen(context, builtin, arguments);
        }

    }
    @GeneratedBy(SegmentIteratorFollowingNode.class)
    public static final class SegmentIteratorFollowingNodeGen extends SegmentIteratorFollowingNode implements Provider {

        @Child private JavaScriptNode arguments0_;
        @Child private JavaScriptNode arguments1_;
        @CompilationFinal private volatile int state_;
        @Child private JSToIndexNode segmentIteratorWithFrom_toIndexNode_;

        private SegmentIteratorFollowingNodeGen(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            super(context, builtin);
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
        }

        @Override
        public JavaScriptNode[] getArguments() {
            return new JavaScriptNode[] {this.arguments0_, this.arguments1_};
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if (state != 0 /* is-active doSegmentIteratorWithFrom(DynamicObject, Object, JSToIndexNode) || doSegmentIteratorNoFrom(DynamicObject, Object) || doIncompatibleReceiver(Object, Object) */) {
                if ((state & 0b11) != 0 /* is-active doSegmentIteratorWithFrom(DynamicObject, Object, JSToIndexNode) || doSegmentIteratorNoFrom(DynamicObject, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                    DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                    if ((state & 0b1) != 0 /* is-active doSegmentIteratorWithFrom(DynamicObject, Object, JSToIndexNode) */) {
                        if ((SegmentIteratorOpNode.isSegmentIterator(arguments0Value__)) && (!(JSGuards.isUndefined(arguments1Value_)))) {
                            return doSegmentIteratorWithFrom(arguments0Value__, arguments1Value_, this.segmentIteratorWithFrom_toIndexNode_);
                        }
                    }
                    if ((state & 0b10) != 0 /* is-active doSegmentIteratorNoFrom(DynamicObject, Object) */) {
                        if ((SegmentIteratorOpNode.isSegmentIterator(arguments0Value__)) && (JSGuards.isUndefined(arguments1Value_))) {
                            return doSegmentIteratorNoFrom(arguments0Value__, arguments1Value_);
                        }
                    }
                }
                if ((state & 0b100) != 0 /* is-active doIncompatibleReceiver(Object, Object) */) {
                    if ((!(SegmentIteratorOpNode.isSegmentIterator(arguments0Value_)))) {
                        return doIncompatibleReceiver(arguments0Value_, arguments1Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        @Override
        public boolean executeBoolean(VirtualFrame frameValue) throws UnexpectedResultException {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.execute(frameValue);
            Object arguments1Value_ = this.arguments1_.execute(frameValue);
            if ((state & 0b11) != 0 /* is-active doSegmentIteratorWithFrom(DynamicObject, Object, JSToIndexNode) || doSegmentIteratorNoFrom(DynamicObject, Object) */ && JSTypes.isDynamicObject(arguments0Value_)) {
                DynamicObject arguments0Value__ = (DynamicObject) arguments0Value_;
                if ((state & 0b1) != 0 /* is-active doSegmentIteratorWithFrom(DynamicObject, Object, JSToIndexNode) */) {
                    if ((SegmentIteratorOpNode.isSegmentIterator(arguments0Value__)) && (!(JSGuards.isUndefined(arguments1Value_)))) {
                        return doSegmentIteratorWithFrom(arguments0Value__, arguments1Value_, this.segmentIteratorWithFrom_toIndexNode_);
                    }
                }
                if ((state & 0b10) != 0 /* is-active doSegmentIteratorNoFrom(DynamicObject, Object) */) {
                    if ((SegmentIteratorOpNode.isSegmentIterator(arguments0Value__)) && (JSGuards.isUndefined(arguments1Value_))) {
                        return doSegmentIteratorNoFrom(arguments0Value__, arguments1Value_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return JSTypesGen.expectBoolean(executeAndSpecialize(arguments0Value_, arguments1Value_));
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            int state = state_;
            try {
                if ((state & 0b100) == 0 /* only-active doSegmentIteratorWithFrom(DynamicObject, Object, JSToIndexNode) && doSegmentIteratorNoFrom(DynamicObject, Object) */ && state != 0  /* is-not doSegmentIteratorWithFrom(DynamicObject, Object, JSToIndexNode) && doSegmentIteratorNoFrom(DynamicObject, Object) && doIncompatibleReceiver(Object, Object) */) {
                    executeBoolean(frameValue);
                    return;
                }
                execute(frameValue);
                return;
            } catch (UnexpectedResultException ex) {
                return;
            }
        }

        private Object executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            try {
                if (JSTypes.isDynamicObject(arguments0Value)) {
                    DynamicObject arguments0Value_ = (DynamicObject) arguments0Value;
                    if ((SegmentIteratorOpNode.isSegmentIterator(arguments0Value_)) && (!(JSGuards.isUndefined(arguments1Value)))) {
                        this.segmentIteratorWithFrom_toIndexNode_ = super.insert((JSToIndexNode.create()));
                        this.state_ = state = state | 0b1 /* add-active doSegmentIteratorWithFrom(DynamicObject, Object, JSToIndexNode) */;
                        lock.unlock();
                        hasLock = false;
                        return doSegmentIteratorWithFrom(arguments0Value_, arguments1Value, this.segmentIteratorWithFrom_toIndexNode_);
                    }
                    if ((SegmentIteratorOpNode.isSegmentIterator(arguments0Value_)) && (JSGuards.isUndefined(arguments1Value))) {
                        this.state_ = state = state | 0b10 /* add-active doSegmentIteratorNoFrom(DynamicObject, Object) */;
                        lock.unlock();
                        hasLock = false;
                        return doSegmentIteratorNoFrom(arguments0Value_, arguments1Value);
                    }
                }
                if ((!(SegmentIteratorOpNode.isSegmentIterator(arguments0Value)))) {
                    this.state_ = state = state | 0b100 /* add-active doIncompatibleReceiver(Object, Object) */;
                    lock.unlock();
                    hasLock = false;
                    return doIncompatibleReceiver(arguments0Value, arguments1Value);
                }
                throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_}, arguments0Value, arguments1Value);
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
                return NodeCost.MONOMORPHIC;
            }
            return NodeCost.POLYMORPHIC;
        }

        @Override
        public Introspection getIntrospectionData() {
            Object[] data = new Object[4];
            Object[] s;
            data[0] = 0;
            int state = state_;
            s = new Object[3];
            s[0] = "doSegmentIteratorWithFrom";
            if ((state & 0b1) != 0 /* is-active doSegmentIteratorWithFrom(DynamicObject, Object, JSToIndexNode) */) {
                s[1] = (byte)0b01 /* active */;
                ArrayList<Object> cached = new ArrayList<>();
                cached.add(Arrays.asList(this.segmentIteratorWithFrom_toIndexNode_));
                s[2] = cached;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[1] = s;
            s = new Object[3];
            s[0] = "doSegmentIteratorNoFrom";
            if ((state & 0b10) != 0 /* is-active doSegmentIteratorNoFrom(DynamicObject, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[2] = s;
            s = new Object[3];
            s[0] = "doIncompatibleReceiver";
            if ((state & 0b100) != 0 /* is-active doIncompatibleReceiver(Object, Object) */) {
                s[1] = (byte)0b01 /* active */;
            } else {
                s[1] = (byte)0b00 /* inactive */;
            }
            data[3] = s;
            return Provider.create(data);
        }

        public static SegmentIteratorFollowingNode create(JSContext context, JSBuiltin builtin, JavaScriptNode[] arguments) {
            return new SegmentIteratorFollowingNodeGen(context, builtin, arguments);
        }

    }
}
