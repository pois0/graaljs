// CheckStyle: start generated
package com.oracle.truffle.js.test.instrumentation;

import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.instrumentation.TruffleInstrument;
import com.oracle.truffle.api.instrumentation.TruffleInstrument.Provider;
import com.oracle.truffle.api.instrumentation.TruffleInstrument.Registration;
import com.oracle.truffle.js.test.instrumentation.GR21608.DummyInstrument1;
import java.util.Arrays;
import java.util.Collection;

@GeneratedBy(DummyInstrument1.class)
@Registration(id = "DummyInstrument1")
public final class GR21608DummyInstrument1Provider implements Provider {

    @Override
    public String getInstrumentClassName() {
        return "com.oracle.truffle.js.test.instrumentation.GR21608$DummyInstrument1";
    }

    @Override
    public TruffleInstrument create() {
        return new DummyInstrument1();
    }

    @Override
    public Collection<String> getServicesClassNames() {
        return Arrays.asList("com.oracle.truffle.js.test.instrumentation.GR21608$DummyInstrument1");
    }

}
