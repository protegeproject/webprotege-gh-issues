package edu.stanford.protege.github.issues;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2023-07-11
 */
public enum GitHubState implements IsSerializable {

    @JsonProperty("open")
    OPEN,

    @JsonProperty("closed")
    CLOSED
}
