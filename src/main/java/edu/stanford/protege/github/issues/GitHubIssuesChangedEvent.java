package edu.stanford.protege.github.issues;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.Event;
import edu.stanford.protege.webprotege.common.EventId;
import edu.stanford.protege.webprotege.common.ProjectId;
import org.semanticweb.owlapi.model.OWLEntity;

import javax.annotation.Nonnull;
import java.util.Objects;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2023-09-14
 */
@JsonTypeName(GitHubIssuesChangedEvent.CHANNEL)
public record GitHubIssuesChangedEvent(EventId eventId,
                                       ProjectId projectId,
                                       OWLEntity entity) implements Event {

    public static final String CHANNEL = "webprotege.events.issues.GitHubIssuesChanged";

    @JsonCreator
    public GitHubIssuesChangedEvent(@JsonProperty("eventId") @Nonnull EventId eventId,
                                    @JsonProperty("projectId") @Nonnull ProjectId projectId,
                                    @JsonProperty("entity") @Nonnull OWLEntity entity) {
        this.eventId = Objects.requireNonNull(eventId);
        this.projectId = Objects.requireNonNull(projectId);
        this.entity = Objects.requireNonNull(entity);
    }

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
