package edu.stanford.protege.github.issues.server;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.github.issues.shared.GitHubIssue;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.Response;
import org.semanticweb.owlapi.model.OWLEntity;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Objects;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2023-09-14
 * <p/>
 * Represents a response containing a list of GitHub issues that is a response to
 * a {@link GetGitHubIssuesRequest}.
 *
 * @param issues The issues in the response.
 * @see Response
 * @see GetGitHubIssuesRequest
 */
@JsonTypeName("webprotege.issues.GetGitHubIssues")
public record GetGitHubIssuesResponse(@JsonProperty("projectId") @Nonnull ProjectId projectId,
                                      @JsonProperty("entity") @Nonnull OWLEntity entity,
                                      @JsonProperty("issues") @Nonnull List<GitHubIssue> issues) implements Response  {

    /**
     * Constructs a new {@code GetIssuesResponse} with the specified list of GitHub issues.
     *
     * @param projectId The projectId that this response pertains to
     * @param entity The entity that this response pertains to
     * @param issues The list of GitHub issues to include in the response. Must not be null.
     */
    @JsonCreator
    public GetGitHubIssuesResponse(@JsonProperty("projectId") @Nonnull ProjectId projectId,
                                   @JsonProperty("entity") @Nonnull OWLEntity entity,
                                   @JsonProperty("issues") @Nonnull List<GitHubIssue> issues) {
        this.projectId = Objects.requireNonNull(projectId);
        this.entity = Objects.requireNonNull(entity);
        this.issues = List.copyOf(Objects.requireNonNull(issues, "issues must not be null"));
    }
}
