package edu.stanford.protege.github.issues.shared;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import com.google.gwt.user.client.rpc.IsSerializable;
import edu.stanford.protege.github.GitHubUser;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.Instant;
import java.util.Objects;
import java.util.Optional;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2023-07-12
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record GitHubMilestone(@JsonProperty("url") @Nullable String url,
                              @JsonProperty("id") long id,
                              @JsonProperty("node_id") @Nullable String nodeId,
                              @JsonProperty("number") int number,
                              @JsonProperty("title") @Nullable String title,
                              @JsonProperty("description") @Nullable String description,
                              @JsonProperty("creator") @Nullable GitHubUser creator,
                              @JsonProperty("open_issues") int openIssues,
                              @JsonProperty("closed_issues") int closedIssues,
                              @JsonProperty("state") @Nullable GitHubState state,
                              @JsonProperty("created_at") @Nullable Instant createdAt,
                              @JsonProperty("updated_at") @Nullable Instant updatedAt,
                              @JsonProperty("due_on") @Nullable Instant dueOn,
                              @JsonProperty("closed_at") @Nullable Instant closedAt) {

    @JsonIgnore
    @Nonnull
    public Optional<Instant> getCreatedAt() {
        return Optional.ofNullable(createdAt());
    }

    @JsonIgnore
    @Nonnull
    public Optional<Instant> getUpdatedAt() {
        return Optional.ofNullable(updatedAt());
    }

    @JsonIgnore
    @Nonnull
    public Optional<Instant> getDueOn() {
        return Optional.ofNullable(dueOn());
    }

    @JsonIgnore
    @Nonnull
    public Optional<Instant> getClosedAt() {
        return Optional.ofNullable(closedAt());
    }

    @JsonCreator
    @Nonnull
    public static GitHubMilestone get(@JsonProperty("url") @Nullable String url,
                               @JsonProperty("id") long id,
                               @JsonProperty("node_id") @Nullable String nodeId,
                               @JsonProperty("number") int number,
                               @JsonProperty("title") @Nullable String title,
                               @JsonProperty("description") @Nullable String description,
                               @JsonProperty("creator") @Nullable GitHubUser creator,
                               @JsonProperty("open_issues") int openIssues,
                               @JsonProperty("closed_issues") int closedIssues,
                               @JsonProperty("state") @Nullable GitHubState state,
                               @JsonProperty("created_at") @Nullable Instant createdAt,
                               @JsonProperty("updated_at") @Nullable Instant updatedAt,
                               @JsonProperty("due_on") @Nullable Instant dueOn,
                               @JsonProperty("closed_at") @Nullable Instant closedAt) {
        return new GitHubMilestone(
                Objects.requireNonNullElse(url, ""),
                id,
                Objects.requireNonNullElse(nodeId, ""),
                number,
                Objects.requireNonNullElse(title, ""),
                Objects.requireNonNullElse(description, ""),
                Objects.requireNonNullElse(creator, GitHubUser.empty()),
                openIssues,
                closedIssues,
                Objects.requireNonNullElse(state, GitHubState.OPEN),
                createdAt,
                updatedAt,
                dueOn,
                closedAt
        );
    }
}
