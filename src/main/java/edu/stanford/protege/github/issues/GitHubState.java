package edu.stanford.protege.github.issues;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2023-07-11
 */
public enum GitHubState {

    @JsonProperty("open")
    OPEN,

    @JsonProperty("closed")
    CLOSED
}
