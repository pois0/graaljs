// CheckStyle: start generated
package com.oracle.truffle.js.test.debug;

import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.instrumentation.TruffleInstrument;
import com.oracle.truffle.api.instrumentation.TruffleInstrument.Provider;
import com.oracle.truffle.api.instrumentation.TruffleInstrument.Registration;
import com.oracle.truffle.js.test.debug.ParseInlineTest.ParseInlineInstrument;
import java.util.Arrays;
import java.util.Collection;

@GeneratedBy(ParseInlineInstrument.class)
@Registration(id = "testParseInline", name = "", version = "")
public final class ParseInlineTestParseInlineInstrumentProvider implements Provider {

    @Override
    public String getInstrumentClassName() {
        return "com.oracle.truffle.js.test.debug.ParseInlineTest$ParseInlineInstrument";
    }

    @Override
    public TruffleInstrument create() {
        return new ParseInlineInstrument();
    }

    @Override
    public Collection<String> getServicesClassNames() {
        return Arrays.asList("com.oracle.truffle.js.test.debug.ParseInlineTest$ParseInlineInstrument$Tester");
    }

}
