// CheckStyle: start generated
package com.oracle.truffle.js.test.instrumentation;

import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.instrumentation.TruffleInstrument;
import com.oracle.truffle.api.instrumentation.TruffleInstrument.Provider;
import com.oracle.truffle.api.instrumentation.TruffleInstrument.Registration;
import com.oracle.truffle.js.test.instrumentation.GR18957.GR18957Instrument;
import java.util.Arrays;
import java.util.Collection;

@GeneratedBy(GR18957Instrument.class)
@Registration(id = "GR18957Instrument")
public final class GR18957GR18957InstrumentProvider implements Provider {

    @Override
    public String getInstrumentClassName() {
        return "com.oracle.truffle.js.test.instrumentation.GR18957$GR18957Instrument";
    }

    @Override
    public TruffleInstrument create() {
        return new GR18957Instrument();
    }

    @Override
    public Collection<String> getServicesClassNames() {
        return Arrays.asList("com.oracle.truffle.js.test.instrumentation.GR18957$GR18957Instrument");
    }

}
