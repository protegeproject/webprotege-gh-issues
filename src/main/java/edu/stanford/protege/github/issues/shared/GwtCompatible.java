package edu.stanford.protege.github.issues.shared;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2023-07-12
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface GwtCompatible {

    boolean serializable();
}
