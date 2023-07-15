package edu.stanford.protege.issues.shared;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;
import java.util.List;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2023-07-12
 */
public record GitHubIssue(
        @JsonProperty("url") String url,
        @JsonProperty("id") long id,
        @JsonProperty("node_id") String nodeId,
        @JsonProperty("number") int number,
        @JsonProperty("title") String title,
        @JsonProperty("user") GitHubUser user,
        @JsonProperty("labels") List<GitHubLabel> labels,
        @JsonProperty("state") GitHubState state,
        @JsonProperty("locked") boolean locked,
        @JsonProperty("assignee") GitHubUser assignee,
        @JsonProperty("assignees") List<GitHubUser> assignees,
        @JsonProperty("milestone") GitHubMilestone milestone,
        @JsonProperty("comments") int comments,
        @JsonProperty("created_at") Instant createdAt,
        @JsonProperty("updated_at") Instant updatedAt,
        @JsonProperty("closedAt") Instant closedAt,
        @JsonProperty("author_association") String authorAssociation,
        @JsonProperty("active_lock_reason") String activeLockReason,
        @JsonProperty("body") String body,
        @JsonProperty("reactions") GitHubReactions reactions,
        @JsonProperty("performed_via_github_app") String performedViaGithubApp,
        @JsonProperty("state_reason") GitHubStateReason stateReason
) {

    public GitHubIssue(@JsonProperty("url") String url,
                       @JsonProperty("id") long id,
                       @JsonProperty("node_id") String nodeId,
                       @JsonProperty("number") int number,
                       @JsonProperty("title") String title,
                       @JsonProperty("user") GitHubUser user,
                       @JsonProperty("labels") List<GitHubLabel> labels,
                       @JsonProperty("state") GitHubState state,
                       @JsonProperty("locked") boolean locked,
                       @JsonProperty("assignee") GitHubUser assignee,
                       @JsonProperty("assignees") List<GitHubUser> assignees,
                       @JsonProperty("milestone") GitHubMilestone milestone,
                       @JsonProperty("comments") int comments,
                       @JsonProperty("created_at") Instant createdAt,
                       @JsonProperty("updated_at") Instant updatedAt,
                       @JsonProperty("closedAt") Instant closedAt,
                       @JsonProperty("author_association") String authorAssociation,
                       @JsonProperty("active_lock_reason") String activeLockReason,
                       @JsonProperty("body") String body,
                       @JsonProperty("reactions") GitHubReactions reactions,
                       @JsonProperty("performed_via_github_app") String performedViaGithubApp,
                       @JsonProperty("state_reason") GitHubStateReason stateReason) {
        this.url = url;
        this.id = id;
        this.nodeId = nodeId;
        this.number = number;
        this.title = title;
        this.user = user;
        this.labels = List.copyOf(labels);
        this.state = state;
        this.locked = locked;
        this.assignee = assignee;
        this.assignees = List.copyOf(assignees);
        this.milestone = milestone;
        this.comments = comments;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.closedAt = closedAt;
        this.authorAssociation = authorAssociation;
        this.activeLockReason = activeLockReason;
        this.body = body;
        this.reactions = reactions;
        this.performedViaGithubApp = performedViaGithubApp;
        this.stateReason = stateReason;
    }
}