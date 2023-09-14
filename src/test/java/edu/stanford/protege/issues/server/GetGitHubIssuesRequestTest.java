package edu.stanford.protege.issues.server;

import edu.stanford.protege.webprotege.common.ProjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJson;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;
import static org.junit.jupiter.api.Assertions.*;

@JsonTest
@AutoConfigureJson
class GetGitHubIssuesRequestTest {

    private ProjectId projectId = ProjectId.generate();

    private OWLEntity entity;

    @Autowired
    private OWLDataFactory dataFactory;

    @Autowired
    private JacksonTester<GetGitHubIssuesRequest> tester;

    @BeforeEach
    void setUp() {
        entity = dataFactory.getOWLClass(IRI.create("https://example.org/A"));
    }

    @Test
    void shouldParseJson() throws IOException {
        var inputStream = GetGitHubIssuesRequestTest.class.getResourceAsStream("/get-issues-request.json");
        var request = tester.readObject(inputStream);
        assertThat(request.entity()).isEqualTo(entity);
        assertThat(request.entity()).isInstanceOf(OWLClass.class);
    }

    @Test
    void shouldThrowNpeIfProjectIdIsNull() {
        assertThrows(NullPointerException.class, () -> {
           new GetGitHubIssuesRequest(null, entity);
        });
    }

    @Test
    void shouldThrowNpeIfEntityIsNull() {
        assertThrows(NullPointerException.class, () -> {
           new GetGitHubIssuesRequest(projectId, null);
        });
    }
}