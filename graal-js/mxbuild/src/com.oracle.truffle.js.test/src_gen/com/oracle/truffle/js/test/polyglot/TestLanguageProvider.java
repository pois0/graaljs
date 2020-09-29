// CheckStyle: start generated
package com.oracle.truffle.js.test.polyglot;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.TruffleFile.FileTypeDetector;
import com.oracle.truffle.api.TruffleLanguage.ContextPolicy;
import com.oracle.truffle.api.TruffleLanguage.Provider;
import com.oracle.truffle.api.TruffleLanguage.Registration;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.instrumentation.ProvidedTags;
import com.oracle.truffle.api.instrumentation.StandardTags.ExpressionTag;
import com.oracle.truffle.api.instrumentation.StandardTags.RootTag;
import com.oracle.truffle.api.instrumentation.StandardTags.StatementTag;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@GeneratedBy(TestLanguage.class)
@Registration(contextPolicy = ContextPolicy.SHARED, id = "jsTestLanguage", name = "jsTestLanguage", version = "1.0")
@ProvidedTags({ExpressionTag.class, StatementTag.class, RootTag.class})
public final class TestLanguageProvider implements Provider {

    @Override
    public String getLanguageClassName() {
        return "com.oracle.truffle.js.test.polyglot.TestLanguage";
    }

    @Override
    public TruffleLanguage<?> create() {
        return new TestLanguage();
    }

    @Override
    public List<FileTypeDetector> createFileTypeDetectors() {
        return Collections.emptyList();
    }

    @Override
    public Collection<String> getServicesClassNames() {
        return Collections.emptySet();
    }

}
