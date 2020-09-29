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

@GeneratedBy(ListSizeNode.class)
public final class ListSizeNodeGen extends ListSizeNode implements Provider {

    @CompilationFinal private int state_;

    private ListSizeNodeGen() {
    }

    @Override
    public int execute(List<?> arg0Value) {
        int state = state_;
        if ((state & 0b1) != 0 /* is-active unmodifiableArrayList(UnmodifiableArrayList<>) */ && arg0Value instanceof UnmodifiableArrayList<?>) {
            UnmodifiableArrayList<?> arg0Value_ = (UnmodifiableArrayList<?>) arg0Value;
            return ListSizeNode.unmodifiableArrayList(arg0Value_);
        }
        if ((state & 0b10) != 0 /* is-active list(List<>) */) {
            if (fallbackGuard_(state, arg0Value)) {
                return ListSizeNode.list(arg0Value);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    private int executeAndSpecialize(List<?> arg0Value) {
        int state = state_;
        if (arg0Value instanceof UnmodifiableArrayList<?>) {
            UnmodifiableArrayList<?> arg0Value_ = (UnmodifiableArrayList<?>) arg0Value;
            this.state_ = state = state | 0b1 /* add-active unmodifiableArrayList(UnmodifiableArrayList<>) */;
            return ListSizeNode.unmodifiableArrayList(arg0Value_);
        }
        this.state_ = state = state | 0b10 /* add-active list(List<>) */;
        return ListSizeNode.list(arg0Value);
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
        if ((state & 0b1) != 0 /* is-active unmodifiableArrayList(UnmodifiableArrayList<>) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[1] = s;
        s = new Object[3];
        s[0] = "list";
        if ((state & 0b10) != 0 /* is-active list(List<>) */) {
            s[1] = (byte)0b01 /* active */;
        } else {
            s[1] = (byte)0b00 /* inactive */;
        }
        data[2] = s;
        return Provider.create(data);
    }

    private static boolean fallbackGuard_(int state, List<?> arg0Value) {
        if (((state & 0b1)) == 0 /* is-not-active unmodifiableArrayList(UnmodifiableArrayList<>) */ && arg0Value instanceof UnmodifiableArrayList<?>) {
            return false;
        }
        return true;
    }

    public static ListSizeNode create() {
        return new ListSizeNodeGen();
    }

}
