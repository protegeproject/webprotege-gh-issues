package edu.stanford.protege.github.issues.shared;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import com.google.gwt.user.client.rpc.IsSerializable;

import javax.annotation.Nonnull;
import java.time.Instant;
import java.util.Objects;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2023-07-13
 */
@AutoValue
@GwtCompatible(serializable = true)
public abstract class GitHubComment implements IsSerializable {

    @JsonProperty("id")
    public abstract long id();

    @JsonProperty("node_id")
    public abstract String nodeId();

    @JsonProperty("url")
    public abstract String url();

    @JsonProperty("html_url")
    public abstract String htmlUrl();

    @JsonProperty("body")
    public abstract String body();

    @JsonProperty("user")
    public abstract GitHubUser user();

    @JsonProperty("created_at")
    public abstract Instant createdAt();

    @JsonProperty("updated_at")
    public abstract Instant updatedAt();

    @JsonProperty("issue_url")
    public abstract String issueUrl();

    @JsonProperty("author_association")
    public abstract GitHubAuthorAssociation authorAssociation();

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
        return new AutoValue_GitHubComment(
                id,
                Objects.requireNonNullElse(nodeId, ""),
                Objects.requireNonNullElse(url, ""),
                Objects.requireNonNullElse(htmlUrl, ""),
                Objects.requireNonNullElse(body, ""),
                Objects.requireNonNullElse(user, GitHubUser.empty()),
                Objects.requireNonNullElse(createdAt, Instant.EPOCH),
                Objects.requireNonNullElse(updatedAt, Instant.EPOCH),
                Objects.requireNonNullElse(issueUrl, ""),
                Objects.requireNonNullElse(authorAssociation, GitHubAuthorAssociation.NONE)
        );
    }

    @Nonnull
    public static GitHubComment empty() {
        return get(0, null, null, null, null, null, null, null, null, null);
    }


}
