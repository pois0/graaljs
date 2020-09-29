// CheckStyle: start generated
package com.oracle.truffle.js.test.instrumentation.sourcesections;

import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.instrumentation.TruffleInstrument;
import com.oracle.truffle.api.instrumentation.TruffleInstrument.Provider;
import com.oracle.truffle.api.instrumentation.TruffleInstrument.Registration;
import java.util.Arrays;
import java.util.Collection;

@GeneratedBy(ExpressionsSourceSectionDumpInstrument.class)
@Registration(id = "ExpressionsSourceSectionDumpInstrument")
public final class ExpressionsSourceSectionDumpInstrumentProvider implements Provider {

    @Override
    public String getInstrumentClassName() {
        return "com.oracle.truffle.js.test.instrumentation.sourcesections.ExpressionsSourceSectionDumpInstrument";
    }

    @Override
    public TruffleInstrument create() {
        return new ExpressionsSourceSectionDumpInstrument();
    }

    @Override
    public Collection<String> getServicesClassNames() {
        return Arrays.asList("com.oracle.truffle.js.test.instrumentation.sourcesections.ExpressionsSourceSectionDumpInstrument");
    }

}
