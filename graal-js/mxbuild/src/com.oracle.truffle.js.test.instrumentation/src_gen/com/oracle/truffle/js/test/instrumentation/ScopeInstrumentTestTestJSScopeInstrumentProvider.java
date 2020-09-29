// CheckStyle: start generated
package com.oracle.truffle.js.test.instrumentation;

import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.instrumentation.TruffleInstrument;
import com.oracle.truffle.api.instrumentation.TruffleInstrument.Provider;
import com.oracle.truffle.api.instrumentation.TruffleInstrument.Registration;
import com.oracle.truffle.js.test.instrumentation.ScopeInstrumentTest.TestJSScopeInstrument;
import java.util.Arrays;
import java.util.Collection;

@GeneratedBy(TestJSScopeInstrument.class)
@Registration(id = "TestJSScopeInstrument")
public final class ScopeInstrumentTestTestJSScopeInstrumentProvider implements Provider {

    @Override
    public String getInstrumentClassName() {
        return "com.oracle.truffle.js.test.instrumentation.ScopeInstrumentTest$TestJSScopeInstrument";
    }

    @Override
    public TruffleInstrument create() {
        return new TestJSScopeInstrument();
    }

    @Override
    public Collection<String> getServicesClassNames() {
        return Arrays.asList("java.lang.Object");
    }

}
