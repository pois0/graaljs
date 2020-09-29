// CheckStyle: start generated
package com.oracle.truffle.js.nodes.access;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.js.nodes.JSTypesGen;

@GeneratedBy(JSReadCurrentFrameSlotNode.class)
final class JSReadCurrentFrameSlotNodeGen extends JSReadCurrentFrameSlotNode implements Provider {

    @CompilationFinal private int state_;

    private JSReadCurrentFrameSlotNodeGen(FrameSlot slot) {
        super(slot);
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        int state = state_;
        if ((state & 0b1) != 0 /* is-active doBoolean(VirtualFrame) */) {
            if ((frameValue.isBoolean(frameSlot))) {
                return doBoolean(frameValue);
            }
        }
        if ((state & 0b10) != 0 /* is-active doInt(VirtualFrame) */) {
            if ((frameValue.isInt(frameSlot))) {
                return doInt(frameValue);
            }
        }
        if ((state & 0b100) != 0 /* is-active doDouble(VirtualFrame) */) {
            if ((frameValue.isDouble(frameSlot))) {
                return doDouble(frameValue);
            }
        }
        if ((state & 0b1000) != 0 /* is-active doObject(VirtualFrame) */) {
            if ((frameValue.isObject(frameSlot))) {
                return doObject(frameValue);
            }
        }
        if ((state & 0b10000) != 0 /* is-active doSafeInteger(VirtualFrame) */) {
            if ((frameValue.isLong(frameSlot))) {
                return doSafeInteger(frameValue);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(frameValue);
    }

    @Override
    public boolean executeBoolean(VirtualFrame frameValue) throws UnexpectedResultException {
        int state = state_;
        if ((state & 0b1000) != 0 /* is-active doObject(VirtualFrame) */) {
            return JSTypesGen.expectBoolean(execute(frameValue));
        }
        if ((state & 0b1) != 0 /* is-active doBoolean(VirtualFrame) */) {
            if ((frameValue.isBoolean(frameSlot))) {
                return doBoolean(frameValue);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectBoolean(executeAndSpecialize(frameValue));
    }

    @Override
    public double executeDouble(VirtualFrame frameValue) throws UnexpectedResultException {
        int state = state_;
        if ((state & 0b1000) != 0 /* is-active doObject(VirtualFrame) */) {
            return JSTypesGen.expectDouble(execute(frameValue));
        }
        if ((state & 0b100) != 0 /* is-active doDouble(VirtualFrame) */) {
            if ((frameValue.isDouble(frameSlot))) {
                return doDouble(frameValue);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectDouble(executeAndSpecialize(frameValue));
    }

    @Override
    public int executeInt(VirtualFrame frameValue) throws UnexpectedResultException {
        int state = state_;
        if ((state & 0b1000) != 0 /* is-active doObject(VirtualFrame) */) {
            return JSTypesGen.expectInteger(execute(frameValue));
        }
        if ((state & 0b10) != 0 /* is-active doInt(VirtualFrame) */) {
            if ((frameValue.isInt(frameSlot))) {
                return doInt(frameValue);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return JSTypesGen.expectInteger(executeAndSpecialize(frameValue));
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        int state = state_;
        try {
            if ((state & 0b11101) == 0 /* only-active doInt(VirtualFrame) */ && state != 0  /* is-not doBoolean(VirtualFrame) && doInt(VirtualFrame) && doDouble(VirtualFrame) && doObject(VirtualFrame) && doSafeInteger(VirtualFrame) */) {
                executeInt(frameValue);
                return;
            } else if ((state & 0b11011) == 0 /* only-active doDouble(VirtualFrame) */ && state != 0  /* is-not doBoolean(VirtualFrame) && doInt(VirtualFrame) && doDouble(VirtualFrame) && doObject(VirtualFrame) && doSafeInteger(VirtualFrame) */) {
                executeDouble(frameValue);
                return;
            } else if ((state & 0b11110) == 0 /* only-active doBoolean(VirtualFrame) */ && state != 0  /* is-not doBoolean(VirtualFrame) && doInt(VirtualFrame) && doDouble(VirtualFrame) && doObject(VirtualFrame) && doSafeInteger(VirtualFrame) */) {
                executeBoolean(frameValue);
                return;
            }
            execute(frameValue);
            return;
        } catch (UnexpectedResultException ex) {
            return;
        }
    }

    private Object executeAndSpecialize(VirtualFrame frameValue) {
        int state = state_;
        if ((frameValue.isBoolean(frameSlot))) {
            this.state_ = state = state | 0b1 /* add-active doBoolean(VirtualFrame) */;
            return doBoolean(frameValue);
        }
        if ((frameValue.isInt(frameSlot))) {
            this.state_ = state = state | 0b10 /* add-active doInt(VirtualFrame) */;
            return doInt(frameValue);
        }
        if ((frameValue.isDouble(frameSlot))) {
            this.state_ = state = state | 0b100 /* add-active doDouble(VirtualFrame) */;
            return doDouble(frameValue);
        }
        if ((frameValue.isObject(frameSlot))) {
            this.state_ = state = state | 0b1000 /* add-active doObject(VirtualFrame) */;
            return doObject(frameValue);
        }
        if ((frameValue.isLong(frameSlot))) {
            this.state_ = state = state | 0b10000 /* add-active doSafeInteger(VirtualFrame) */;
            return doSafeInteger(frameValue);
        }
        throw new UnsupportedSpecializationException(this, new Node[] {});
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
        Object[] data = new Object[6];
        Object[] s;
        data[0] = 0;
        int state = state_;
        s = new Object[3];
        s[0] = "doBoolean";
        if ((state & 0b1) != 0 /* is-active doBoolean(VirtualFrame) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doInt";
        if ((state & 0b10) != 0 /* is-active doInt(VirtualFrame) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        s = new Object[3];
        s[0] = "doDouble";
        if ((state & 0b100) != 0 /* is-active doDouble(VirtualFrame) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[3] = s;
        s = new Object[3];
        s[0] = "doObject";
        if ((state & 0b1000) != 0 /* is-active doObject(VirtualFrame) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[4] = s;
        s = new Object[3];
        s[0] = "doSafeInteger";
        if ((state & 0b10000) != 0 /* is-active doSafeInteger(VirtualFrame) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[5] = s;
        return Provider.create(data);
    }

    public static JSReadCurrentFrameSlotNode create(FrameSlot slot) {
        return new JSReadCurrentFrameSlotNodeGen(slot);
    }

}
