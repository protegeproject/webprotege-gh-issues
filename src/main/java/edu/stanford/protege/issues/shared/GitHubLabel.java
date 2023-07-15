package edu.stanford.protege.issues.shared;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import com.google.gwt.user.client.rpc.IsSerializable;

import javax.annotation.Nullable;
import java.util.Objects;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2023-07-12
 */
@AutoValue
@GwtCompatible(serializable = true)
public abstract class GitHubLabel implements IsSerializable {

    @JsonProperty("id")
    public abstract long id();

    @JsonProperty("node_id")
    public abstract String nodeId();

    @JsonProperty("url")
    public abstract String url();

    @JsonProperty("name")
    public abstract String name();

    @JsonProperty("color")
    public abstract String color();

    @JsonProperty("default")
    public abstract boolean isDefault();

    @JsonProperty("description")
    public abstract String description();

    @JsonCreator
    public static GitHubLabel get(@JsonProperty("id") long id,
                                  @JsonProperty("node_id") @Nullable String nodeId,
                                  @JsonProperty("url") @Nullable String url,
                                  @JsonProperty("name") @Nullable String name,
                                  @JsonProperty("color") @Nullable String color,
                                  @JsonProperty("default") boolean isDefault,
                                  @JsonProperty("description") @Nullable String description) {
        return new AutoValue_GitHubLabel(
                id,
                Objects.requireNonNullElse(nodeId, ""),
                Objects.requireNonNullElse(url, ""),
                Objects.requireNonNullElse(name, ""),
                Objects.requireNonNullElse(color, ""),
                isDefault,
                Objects.requireNonNullElse(description, ""));
    }
}
