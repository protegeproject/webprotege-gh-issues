package edu.stanford.protege.github.issues.shared;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2024-05-19
 *
 * An emulation of the Objects#requireNonNullOrElse method that is not
 * supported in GWT
 */
public class Helper {

    @SuppressWarnings("ReplaceNullCheck")
    @Nonnull
    public static <T> T requireNonNullOrElse(@Nullable T object, @Nonnull T defaultValue) {
        if(object == null) {
            return defaultValue;
        }
        else {
            return object;
        }
    }
}
