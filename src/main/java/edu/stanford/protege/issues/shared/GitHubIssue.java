package edu.stanford.protege.issues.shared;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import com.google.auto.value.extension.serializable.SerializableAutoValue;
import com.google.gwt.user.client.rpc.IsSerializable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2023-07-12
 */
@AutoValue
@SerializableAutoValue
@GwtCompatible(serializable = true)
public abstract class GitHubIssue implements IsSerializable, Serializable {

    public abstract @JsonProperty("url") String url();

    public abstract @JsonProperty("id") long id();

    public abstract @JsonProperty("node_id") String nodeId();

    public abstract @JsonProperty("number") int number();

    public abstract @JsonProperty("title") String title();

    public abstract @JsonProperty("user") GitHubUser user();

    public abstract @JsonProperty("html_url") String htmlUrl();

    public abstract @JsonProperty("labels") List<GitHubLabel> labels();

    public abstract @JsonProperty("state") GitHubState state();

    public abstract @JsonProperty("locked") boolean locked();

    @Nullable
    public abstract @JsonProperty("assignee") GitHubUser assignee();

    @JsonIgnore
    @Nonnull
    public Optional<GitHubUser> getAssignee() {
        return Optional.ofNullable(assignee());
    }

    public abstract @JsonProperty("assignees") List<GitHubUser> assignees();

    @Nullable
    public abstract @JsonProperty("milestone") GitHubMilestone milestone();

    @JsonIgnore
    @Nonnull
    public Optional<GitHubMilestone> getMilestone() {
        return Optional.ofNullable(milestone());
    }

    public abstract @JsonProperty("comments") int comments();

    public abstract @JsonProperty("created_at") Instant createdAt();

    public abstract @JsonProperty("updated_at") Instant updatedAt();

    public abstract @JsonProperty("closed_at") Instant closedAt();

    @Nullable
    public abstract @JsonProperty("closed_by") GitHubUser closedBy();

    @JsonIgnore
    @Nonnull
    public Optional<GitHubUser> getClosedBy() {
        return Optional.ofNullable(closedBy());
    }

    public abstract @JsonProperty("author_association") GitHubAuthorAssociation authorAssociation();

    public abstract @JsonProperty("active_lock_reason") String activeLockReason();

    public abstract @JsonProperty("body") String body();

    @Nullable
    public abstract @JsonProperty("reactions") GitHubReactions reactions();

    @JsonIgnore
    @Nonnull
    public Optional<GitHubReactions> getReactions() {
        return Optional.ofNullable(reactions());
    }

    @Nullable
    public abstract @JsonProperty("state_reason") GitHubStateReason stateReason();

    @JsonIgnore
    @Nonnull
    public Optional<GitHubStateReason> getStateReason() {
        return Optional.ofNullable(stateReason());
    }

    @JsonCreator
    public static GitHubIssue get(@JsonProperty("url") String url,
                       @JsonProperty("id") long id,
                       @JsonProperty("node_id") String nodeId,
                       @JsonProperty("number") int number,
                       @JsonProperty("title") String title,
                       @JsonProperty("user") GitHubUser user,
                       @JsonProperty("labels") List<GitHubLabel> labels,
                       @JsonProperty("htmlUrl") String htmlUrl,
                       @JsonProperty("state") GitHubState state,
                       @JsonProperty("locked") boolean locked,
                       @JsonProperty("assignee") @Nullable GitHubUser assignee,
                       @JsonProperty("assignees") List<GitHubUser> assignees,
                       @JsonProperty("milestone") @Nullable GitHubMilestone milestone,
                       @JsonProperty("comments") int comments,
                       @JsonProperty("created_at") Instant createdAt,
                       @JsonProperty("updated_at") Instant updatedAt,
                       @JsonProperty("closed_at") Instant closedAt,
                       @JsonProperty("closed_by") @Nullable GitHubUser closedBy,
                       @JsonProperty("author_association") GitHubAuthorAssociation authorAssociation,
                       @JsonProperty("active_lock_reason") String activeLockReason,
                       @JsonProperty("body") String body,
                       @JsonProperty("reactions") GitHubReactions reactions,
                       @JsonProperty("state_reason") @Nullable GitHubStateReason stateReason) {
        return new AutoValue_GitHubIssue(Objects.requireNonNullElse(url, ""),
                                         id,
                                         Objects.requireNonNullElse(nodeId, ""),
                                         number,
                                         Objects.requireNonNullElse(title, ""),
                                         Objects.requireNonNullElse(user, GitHubUser.empty()),
                                         Objects.requireNonNullElse(htmlUrl, ""),
                                         Objects.requireNonNullElse(labels, List.of()),
                                         Objects.requireNonNullElse(state, GitHubState.OPEN),
                                         locked,
                                         assignee,
                                         Objects.requireNonNullElse(assignees, List.of()),
                                         milestone,
                                         comments,
                                         Objects.requireNonNullElse(createdAt, Instant.EPOCH),
                                         Objects.requireNonNullElse(updatedAt, Instant.EPOCH),
                                         Objects.requireNonNullElse(closedAt, Instant.EPOCH),
                                         closedBy,
                                         Objects.requireNonNullElse(authorAssociation, GitHubAuthorAssociation.NONE),
                                         Objects.requireNonNullElse(activeLockReason, ""),
                                         Objects.requireNonNullElse(body, ""),
                                         reactions,
                                         stateReason);




    }
}