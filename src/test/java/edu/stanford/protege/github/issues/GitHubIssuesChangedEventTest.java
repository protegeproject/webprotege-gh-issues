package edu.stanford.protege.github.issues;

import edu.stanford.protege.webprotege.common.EventId;
import edu.stanford.protege.webprotege.common.ProjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLEntityProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJson;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@JsonTest
@AutoConfigureJson
class GitHubIssuesChangedEventTest {

    private EventId eventId;

    private ProjectId projectId;

    private OWLEntity entity;

    @Autowired
    private JacksonTester<GitHubIssuesChangedEvent> tester;

    @Autowired
    private OWLEntityProvider dataFactory;

    @BeforeEach
    void setUp() {
        eventId = EventId.valueOf("aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa");
        projectId = ProjectId.valueOf("bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb");
        entity = dataFactory.getOWLClass(IRI.create("https://example.org/A"));
    }

    @Test
    public void shouldParseJson() throws IOException {
        var inputStream = GitHubIssuesChangedEvent.class.getResourceAsStream("/issues-changed-event.json");
        var event = tester.readObject(inputStream);
        assertThat(event.eventId()).isEqualTo(eventId);
        assertThat(event.projectId()).isEqualTo(projectId);
        assertThat(event.entity()).isEqualTo(entity);
    }

    @Test
    public void shouldWriteJson() throws IOException {
        var content = tester.write(new GitHubIssuesChangedEvent(eventId, projectId, entity));
        assertThat(content).hasJsonPathStringValue("eventId", "aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa");
        assertThat(content).hasJsonPathStringValue("projectId", "bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb");
        assertThat(content).hasJsonPathMapValue("entity");
    }

    @Test
    void shouldHaveExpectedChannel() {
        var event = new GitHubIssuesChangedEvent(eventId, projectId, entity);
        assertThat(event.getChannel()).isEqualTo("webprotege.events.issues.GitHubIssuesChanged");
    }

    @Test
    void shouldThrowNpeIfEventIdIsNull() {
        assertThrows(NullPointerException.class, () -> {
            new GitHubIssuesChangedEvent(null, projectId, entity);
        });
    }

    @Test
    void shouldThrowNpeIfProjectIdIsNull() {
        assertThrows(NullPointerException.class, () -> {
            new GitHubIssuesChangedEvent(eventId, null, entity);
        });
    }

    @Test
    void shouldThrowNpeIfEntityIsNull() {
        assertThrows(NullPointerException.class, () -> {
            new GitHubIssuesChangedEvent(eventId, projectId, null);
        });
    }
}