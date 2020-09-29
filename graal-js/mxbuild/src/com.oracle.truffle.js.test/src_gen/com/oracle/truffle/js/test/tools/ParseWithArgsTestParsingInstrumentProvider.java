// CheckStyle: start generated
package com.oracle.truffle.js.test.tools;

import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.instrumentation.TruffleInstrument;
import com.oracle.truffle.api.instrumentation.TruffleInstrument.Provider;
import com.oracle.truffle.api.instrumentation.TruffleInstrument.Registration;
import com.oracle.truffle.js.test.tools.ParseWithArgsTest.ParsingInstrument;
import java.util.Arrays;
import java.util.Collection;

@GeneratedBy(ParsingInstrument.class)
@Registration(id = "parsingInstrument", name = "Parsing Instrument", version = "1.0")
public final class ParseWithArgsTestParsingInstrumentProvider implements Provider {

    @Override
    public String getInstrumentClassName() {
        return "com.oracle.truffle.js.test.tools.ParseWithArgsTest$ParsingInstrument";
    }

    @Override
    public TruffleInstrument create() {
        return new ParsingInstrument();
    }

    @Override
    public Collection<String> getServicesClassNames() {
        return Arrays.asList("com.oracle.truffle.js.test.tools.ParseWithArgsTest$ParsingInstrument");
    }

}
