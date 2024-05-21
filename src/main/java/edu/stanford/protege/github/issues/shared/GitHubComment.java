package edu.stanford.protege.github.issues.shared;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import edu.stanford.protege.github.GitHubUser;

import javax.annotation.Nonnull;
import java.time.Instant;
import java.util.Objects;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2023-07-13
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record GitHubComment(@JsonProperty("id") long id,
                            @JsonProperty("node_id") String nodeId,
                            @JsonProperty("url") String url,
                            @JsonProperty("html_url") String htmlUrl,
                            @JsonProperty("body") String body,
                            @JsonProperty("user") GitHubUser user,
                            @JsonProperty("created_at") Instant createdAt,
                            @JsonProperty("updated_at") Instant updatedAt,
                            @JsonProperty("issue_url") String issueUrl,
                            @JsonProperty("author_association") GitHubAuthorAssociation authorAssociation) {

    public GitHubComment(@JsonProperty("id") long id,
                         @JsonProperty("node_id") String nodeId,
                         @JsonProperty("url") String url,
                         @JsonProperty("html_url") String htmlUrl,
                         @JsonProperty("body") String body,
                         @JsonProperty("user") GitHubUser user,
                         @JsonProperty("created_at") Instant createdAt,
                         @JsonProperty("updated_at") Instant updatedAt,
                         @JsonProperty("issue_url") String issueUrl,
                         @JsonProperty("author_association") GitHubAuthorAssociation authorAssociation) {
        this.id = id;
        this.nodeId = Objects.requireNonNullElse(nodeId, "");
        this.url = Objects.requireNonNullElse(url, "");
        this.htmlUrl = Objects.requireNonNullElse(htmlUrl, "");
        this.body = Objects.requireNonNullElse(body, "");
        this.user = Objects.requireNonNullElse(user, GitHubUser.empty());
        this.createdAt = Objects.requireNonNullElse(createdAt, Instant.EPOCH);
        this.updatedAt = Objects.requireNonNullElse(updatedAt, Instant.EPOCH);
        this.issueUrl = Objects.requireNonNullElse(issueUrl, "");
        this.authorAssociation = Objects.requireNonNullElse(authorAssociation, GitHubAuthorAssociation.NONE);
    }

    @Nonnull
    @JsonCreator
    public static GitHubComment get(@JsonProperty("id") long id,
                                    @JsonProperty("node_id") String nodeId,
                                    @JsonProperty("url") String url,
                                    @JsonProperty("html_url") String htmlUrl,
                                    @JsonProperty("body") String body,
                                    @JsonProperty("user") GitHubUser user,
                                    @JsonProperty("created_at") Instant createdAt,
                                    @JsonProperty("updated_at") Instant updatedAt,
                                    @JsonProperty("issue_url") String issueUrl,
                                    @JsonProperty("author_association") GitHubAuthorAssociation authorAssociation) {
        return new GitHubComment(id, nodeId, url, htmlUrl, body, user, createdAt, updatedAt, issueUrl, authorAssociation);
    }

    @Nonnull
    public static GitHubComment empty() {
        return get(0, null, null, null, null, null, null, null, null, null);
    }


}
