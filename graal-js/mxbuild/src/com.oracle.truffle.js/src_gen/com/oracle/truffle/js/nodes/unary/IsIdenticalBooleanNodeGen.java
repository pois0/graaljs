// CheckStyle: start generated
package com.oracle.truffle.js.nodes.unary;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.js.nodes.JavaScriptNode;

@GeneratedBy(IsIdenticalBooleanNode.class)
public final class IsIdenticalBooleanNodeGen extends IsIdenticalBooleanNode implements Provider {

    @CompilationFinal private int state_;

    private IsIdenticalBooleanNodeGen(JavaScriptNode operand, boolean bool, boolean leftConstant) {
        super(operand, bool, leftConstant);
    }

    @Override
    public Object execute(VirtualFrame frameValue, Object operandNodeValue) {
        int state = state_;
        if ((state & 0b1) != 0 /* is-active doBoolean(boolean) */ && operandNodeValue instanceof Boolean) {
            boolean operandNodeValue_ = (boolean) operandNodeValue;
            return doBoolean(operandNodeValue_);
        }
        if ((state & 0b10) != 0 /* is-active doOther(Object) */) {
            if (fallbackGuard_(state, operandNodeValue)) {
                return doOther(operandNodeValue);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue);
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        int state = state_;
        if ((state & 0b10) == 0 /* only-active doBoolean(boolean) */ && state != 0  /* is-not doBoolean(boolean) && doOther(Object) */) {
            return execute_boolean0(frameValue, state);
        } else {
            return execute_generic1(frameValue, state);
        }
    }

    private Object execute_boolean0(VirtualFrame frameValue, int state) {
        boolean operandNodeValue_;
        try {
            operandNodeValue_ = super.operandNode.executeBoolean(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(ex.getResult());
        }
        assert (state & 0b1) != 0 /* is-active doBoolean(boolean) */;
        return doBoolean(operandNodeValue_);
    }

    private Object execute_generic1(VirtualFrame frameValue, int state) {
        Object operandNodeValue_ = super.operandNode.execute(frameValue);
        if ((state & 0b1) != 0 /* is-active doBoolean(boolean) */ && operandNodeValue_ instanceof Boolean) {
            boolean operandNodeValue__ = (boolean) operandNodeValue_;
            return doBoolean(operandNodeValue__);
        }
        if ((state & 0b10) != 0 /* is-active doOther(Object) */) {
            if (fallbackGuard_(state, operandNodeValue_)) {
                return doOther(operandNodeValue_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue_);
    }

    @Override
    public boolean executeBoolean(VirtualFrame frameValue) {
        int state = state_;
        if ((state & 0b10) == 0 /* only-active doBoolean(boolean) */ && state != 0  /* is-not doBoolean(boolean) && doOther(Object) */) {
            return executeBoolean_boolean2(frameValue, state);
        } else {
            return executeBoolean_generic3(frameValue, state);
        }
    }

    private boolean executeBoolean_boolean2(VirtualFrame frameValue, int state) {
        boolean operandNodeValue_;
        try {
            operandNodeValue_ = super.operandNode.executeBoolean(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(ex.getResult());
        }
        assert (state & 0b1) != 0 /* is-active doBoolean(boolean) */;
        return doBoolean(operandNodeValue_);
    }

    private boolean executeBoolean_generic3(VirtualFrame frameValue, int state) {
        Object operandNodeValue_ = super.operandNode.execute(frameValue);
        if ((state & 0b1) != 0 /* is-active doBoolean(boolean) */ && operandNodeValue_ instanceof Boolean) {
            boolean operandNodeValue__ = (boolean) operandNodeValue_;
            return doBoolean(operandNodeValue__);
        }
        if ((state & 0b10) != 0 /* is-active doOther(Object) */) {
            if (fallbackGuard_(state, operandNodeValue_)) {
                return doOther(operandNodeValue_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(operandNodeValue_);
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        executeBoolean(frameValue);
        return;
    }

    private boolean executeAndSpecialize(Object operandNodeValue) {
        int state = state_;
        if (operandNodeValue instanceof Boolean) {
            boolean operandNodeValue_ = (boolean) operandNodeValue;
            this.state_ = state = state | 0b1 /* add-active doBoolean(boolean) */;
            return doBoolean(operandNodeValue_);
        }
        this.state_ = state = state | 0b10 /* add-active doOther(Object) */;
        return doOther(operandNodeValue);
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
        s[0] = "doBoolean";
        if ((state & 0b1) != 0 /* is-active doBoolean(boolean) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "doOther";
        if ((state & 0b10) != 0 /* is-active doOther(Object) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        return Provider.create(data);
    }

    private static boolean fallbackGuard_(int state, Object operandNodeValue) {
        if (((state & 0b1)) == 0 /* is-not-active doBoolean(boolean) */ && operandNodeValue instanceof Boolean) {
            return false;
        }
        return true;
    }

    public static IsIdenticalBooleanNode create(JavaScriptNode operand, boolean bool, boolean leftConstant) {
        return new IsIdenticalBooleanNodeGen(operand, bool, leftConstant);
    }

}
