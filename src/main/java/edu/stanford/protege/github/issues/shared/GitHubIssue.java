package edu.stanford.protege.github.issues.shared;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import edu.stanford.protege.github.GitHubUser;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2023-07-12
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record GitHubIssue(@JsonProperty("url") String url,
                          @JsonProperty("id") long id,
                          @JsonProperty("node_id") String nodeId,
                          @JsonProperty("number") int number,
                          @JsonProperty("title") String title,
                          @JsonProperty("user") GitHubUser user,
                          @JsonProperty("labels") List<GitHubLabel> labels,
                          @JsonProperty("html_url") String htmlUrl,
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

    public GitHubIssue(@JsonProperty("url") String url,
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
        this.id = id;
        this.url = Objects.requireNonNullElse(url, "");
        this.nodeId = Objects.requireNonNullElse(nodeId, "");
        this.number = number;
        this.title = Objects.requireNonNullElse(title, "");
        this.user = Objects.requireNonNullElse(user, GitHubUser.empty());
        this.htmlUrl = Objects.requireNonNullElse(htmlUrl, "");
        this.labels = Objects.requireNonNullElse(labels, Collections.emptyList());
        this.state = Objects.requireNonNullElse(state, GitHubState.OPEN);
        this.locked = locked;
        this.assignee = assignee;
        this.assignees = Objects.requireNonNullElse(assignees, Collections.emptyList());
        this.milestone = milestone;
        this.comments = comments;
        this.createdAt = Objects.requireNonNullElse(createdAt, Instant.EPOCH);
        this.updatedAt = Objects.requireNonNullElse(updatedAt, Instant.EPOCH);
        this.closedAt = Objects.requireNonNullElse(closedAt, Instant.EPOCH);
        this.closedBy = closedBy;
        this.authorAssociation = Objects.requireNonNullElse(authorAssociation, GitHubAuthorAssociation.NONE);
        this.activeLockReason = Objects.requireNonNullElse(activeLockReason, "");
        this.body = Objects.requireNonNullElse(body, "");
        this.reactions = reactions;
        this.stateReason = stateReason;
    }

    @JsonIgnore
    @Nonnull
    public Optional<GitHubUser> getAssignee() {
        return Optional.ofNullable(assignee());
    }

    @JsonIgnore
    @Nonnull
    public Optional<GitHubMilestone> getMilestone() {
        return Optional.ofNullable(milestone());
    }

    @JsonIgnore
    @Nonnull
    public Optional<GitHubUser> getClosedBy() {
        return Optional.ofNullable(closedBy());
    }

    @JsonIgnore
    @Nonnull
    public Optional<GitHubReactions> getReactions() {
        return Optional.ofNullable(reactions());
    }

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
        return new GitHubIssue(Objects.requireNonNullElse(url, ""),
                               id,
                               Objects.requireNonNullElse(nodeId, ""),
                               number,
                               Objects.requireNonNullElse(title, ""),
                               Objects.requireNonNullElse(user, GitHubUser.empty()),
                               Objects.requireNonNullElse(labels, Collections.emptyList()),
                               Objects.requireNonNullElse(htmlUrl, ""),
                               Objects.requireNonNullElse(state, GitHubState.OPEN),
                               locked,
                               assignee,
                               Objects.requireNonNullElse(assignees, Collections.emptyList()),
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