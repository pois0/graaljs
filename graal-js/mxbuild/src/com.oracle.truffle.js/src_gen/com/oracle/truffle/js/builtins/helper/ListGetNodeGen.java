// CheckStyle: start generated
package com.oracle.truffle.js.builtins.helper;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.Introspection;
import com.oracle.truffle.api.dsl.Introspection.Provider;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.js.runtime.util.UnmodifiableArrayList;
import java.util.List;

@GeneratedBy(ListGetNode.class)
@SuppressWarnings("unused")
public final class ListGetNodeGen extends ListGetNode implements Provider {

    @CompilationFinal private int state_;

    private ListGetNodeGen() {
    }

    @Override
    public Object execute(List<?> arg0Value, int arg1Value) {
        int state = state_;
        if (state != 0 /* is-active unmodifiableArrayList(UnmodifiableArrayList<>, int) || list(List<>, int) */) {
            if ((state & 0b1) != 0 /* is-active unmodifiableArrayList(UnmodifiableArrayList<>, int) */ && arg0Value instanceof UnmodifiableArrayList<?>) {
                UnmodifiableArrayList<?> arg0Value_ = (UnmodifiableArrayList<?>) arg0Value;
                return ListGetNode.unmodifiableArrayList(arg0Value_, arg1Value);
            }
            if ((state & 0b10) != 0 /* is-active list(List<>, int) */) {
                if (fallbackGuard_(state, arg0Value, arg1Value)) {
                    return ListGetNode.list(arg0Value, arg1Value);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value, arg1Value);
    }

    private Object executeAndSpecialize(List<?> arg0Value, int arg1Value) {
        int state = state_;
        if (arg0Value instanceof UnmodifiableArrayList<?>) {
            UnmodifiableArrayList<?> arg0Value_ = (UnmodifiableArrayList<?>) arg0Value;
            this.state_ = state = state | 0b1 /* add-active unmodifiableArrayList(UnmodifiableArrayList<>, int) */;
            return ListGetNode.unmodifiableArrayList(arg0Value_, arg1Value);
        }
        this.state_ = state = state | 0b10 /* add-active list(List<>, int) */;
        return ListGetNode.list(arg0Value, arg1Value);
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
        s[0] = "unmodifiableArrayList";
        if ((state & 0b1) != 0 /* is-active unmodifiableArrayList(UnmodifiableArrayList<>, int) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "list";
        if ((state & 0b10) != 0 /* is-active list(List<>, int) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        return Provider.create(data);
    }

    private static boolean fallbackGuard_(int state, List<?> arg0Value, int arg1Value) {
        if (((state & 0b1)) == 0 /* is-not-active unmodifiableArrayList(UnmodifiableArrayList<>, int) */ && arg0Value instanceof UnmodifiableArrayList<?>) {
            return false;
        }
        return true;
    }

    public static ListGetNode create() {
        return new ListGetNodeGen();
    }

}
