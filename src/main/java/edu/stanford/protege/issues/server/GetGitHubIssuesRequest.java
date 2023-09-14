package edu.stanford.protege.issues.server;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.ProjectRequest;
import edu.stanford.protege.webprotege.common.Request;
import org.semanticweb.owlapi.model.OWLEntity;

import javax.annotation.Nonnull;
import java.util.Objects;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2023-09-14
 * <p>
 * A request to get the GitHub Issues pertaining to a specific OWL entity.  An issue pertains to an
 * entity if it mentions the entity in the title or the body of this issue or in the body
 * of a comment that belongs to the issue.  Entity mentions can either be Full IRIs, prefixed names
 * or OBO identifiers.
 *
 * @param entity The OWL entity for which issues are requested.
 * @see Request
 * @see GetGitHubIssuesResponse
 */
@JsonTypeName(GetGitHubIssuesRequest.CHANNEL)
public record GetGitHubIssuesRequest(@JsonProperty("projectId") @Nonnull ProjectId projectId,
                                     @JsonProperty("entity") @Nonnull OWLEntity entity) implements ProjectRequest<GetGitHubIssuesResponse> {

    /**
     * The communication channel identifier for this type of request.
     */
    public static final String CHANNEL = "webprotege.issues.GetGitHubIssues";

    /**
     * Constructs a new {@code GetIssuesRequest} with the specified OWL entity.
     *
     * @param entity The OWL entity for which issues are requested. Must not be null.
     */
    public GetGitHubIssuesRequest(
            @JsonProperty("projectId") @Nonnull ProjectId projectId,
            @JsonProperty("entity") @Nonnull OWLEntity entity) {
        this.projectId = Objects.requireNonNull(projectId, "projectId must not be null");
        this.entity = Objects.requireNonNull(entity, "entity must not be null");
    }

    /**
     * Retrieves the communication channel identifier for this request type.
     *
     * @return The communication channel identifier.
     */
    @Override
    public String getChannel() {
        return CHANNEL;
    }
}

