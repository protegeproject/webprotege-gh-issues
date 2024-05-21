package edu.stanford.protege.github.issues;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Nullable;
import java.util.Objects;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2023-07-12
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record GitHubLabel(@JsonProperty("id") long id,
                          @JsonProperty("node_id") @Nullable String nodeId,
                          @JsonProperty("url") @Nullable String url,
                          @JsonProperty("name") @Nullable String name,
                          @JsonProperty("color") @Nullable String color,
                          @JsonProperty("default") boolean isDefault,
                          @JsonProperty("description") @Nullable String description) {

    public GitHubLabel(@JsonProperty("id") long id,
                       @JsonProperty("node_id") @Nullable String nodeId,
                       @JsonProperty("url") @Nullable String url,
                       @JsonProperty("name") @Nullable String name,
                       @JsonProperty("color") @Nullable String color,
                       @JsonProperty("default") boolean isDefault,
                       @JsonProperty("description") @Nullable String description) {
        this.id = id;
        this.nodeId = Objects.requireNonNullElse(nodeId, "");
        this.url = Objects.requireNonNullElse(url, "");
        this.name = Objects.requireNonNullElse(name, "");
        this.color = Objects.requireNonNullElse(color, "");
        this.isDefault = isDefault;
        this.description = Objects.requireNonNullElse(description, "");
    }

    @JsonCreator
    public static GitHubLabel get(@JsonProperty("id") long id,
                                  @JsonProperty("node_id") @Nullable String nodeId,
                                  @JsonProperty("url") @Nullable String url,
                                  @JsonProperty("name") @Nullable String name,
                                  @JsonProperty("color") @Nullable String color,
                                  @JsonProperty("default") boolean isDefault,
                                  @JsonProperty("description") @Nullable String description) {
        return new GitHubLabel(id, nodeId, url, name, color, isDefault, description);
    }
}
