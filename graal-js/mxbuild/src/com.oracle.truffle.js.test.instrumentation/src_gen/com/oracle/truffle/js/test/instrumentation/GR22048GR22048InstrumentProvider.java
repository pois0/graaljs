// CheckStyle: start generated
package com.oracle.truffle.js.test.instrumentation;

import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.instrumentation.TruffleInstrument;
import com.oracle.truffle.api.instrumentation.TruffleInstrument.Provider;
import com.oracle.truffle.api.instrumentation.TruffleInstrument.Registration;
import com.oracle.truffle.js.test.instrumentation.GR22048.GR22048Instrument;
import java.util.Arrays;
import java.util.Collection;

@GeneratedBy(GR22048Instrument.class)
@Registration(id = "GR22048Instrument")
public final class GR22048GR22048InstrumentProvider implements Provider {

    @Override
    public String getInstrumentClassName() {
        return "com.oracle.truffle.js.test.instrumentation.GR22048$GR22048Instrument";
    }

    @Override
    public TruffleInstrument create() {
        return new GR22048Instrument();
    }

    @Override
    public Collection<String> getServicesClassNames() {
        return Arrays.asList("com.oracle.truffle.js.test.instrumentation.GR22048$GR22048Instrument");
    }

}
