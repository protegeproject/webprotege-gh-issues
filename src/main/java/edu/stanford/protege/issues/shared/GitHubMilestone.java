package edu.stanford.protege.issues.shared;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import com.google.gwt.user.client.rpc.IsSerializable;

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
@AutoValue
@GwtCompatible(serializable = true)
public abstract class GitHubMilestone implements IsSerializable {

    public abstract @JsonProperty("url") String url();

    public abstract @JsonProperty("id") long id();

    public abstract @JsonProperty("node_id") String nodeId();

    public abstract @JsonProperty("number") int number();

    public abstract @JsonProperty("title") String title();

    public abstract @JsonProperty("description") String description();

    public abstract @JsonProperty("creator") GitHubUser creator();

    public abstract @JsonProperty("open_issues") int openIssues();

    public abstract @JsonProperty("closed_issues") int closedIssues();

    public abstract @JsonProperty("state") GitHubState state();

    @Nullable
    public abstract @JsonProperty("created_at") Instant createdAt();

    @Nonnull
    public Optional<Instant> getCreatedAt() {
        return Optional.ofNullable(createdAt());
    }

    @Nullable
    public abstract @JsonProperty("updated_at") Instant updatedAt();

    @Nonnull
    public Optional<Instant> getUpdatedAt() {
        return Optional.ofNullable(updatedAt());
    }

    @Nullable
    public abstract @JsonProperty("due_on") Instant dueOn();

    @Nonnull
    public Optional<Instant> getDueOn() {
        return Optional.ofNullable(dueOn());
    }

    @Nullable
    public abstract @JsonProperty("closed_at") Instant closedAt();

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
        return new AutoValue_GitHubMilestone(
                Objects.requireNonNullElse(url, ""),
                id,
                Objects.requireNonNullElse(nodeId, ""),
                number,
                Objects.requireNonNullElse(title, ""),
                Objects.requireNonNullElse(description, ""),
                Objects.requireNonNullElse(creator, GitHubUser.empty()),
                Objects.requireNonNullElse(openIssues, 0),
                closedIssues,
                Objects.requireNonNullElse(state, GitHubState.OPEN),
                createdAt,
                updatedAt,
                dueOn,
                closedAt
        );
    }
}
