package edu.stanford.protege.issues.server;

import edu.stanford.protege.issues.shared.GitHubIssue;
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
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@JsonTest
@AutoConfigureJson
class GetGitHubIssuesResponseTest {

    @Autowired
    private OWLEntityProvider dataFactory;

    @Autowired
    private JacksonTester<GetGitHubIssuesResponse> tester;

    private ProjectId projectId;

    private OWLEntity entity;

    private List<GitHubIssue> issues = List.of();

    @BeforeEach
    void setUp() {
        projectId = ProjectId.valueOf("12345678-1234-1234-1234-123456789abc");
        entity = dataFactory.getOWLClass(IRI.create("https://example.org/A"));
    }

    @Test
    public void shouldDeserializeFromJson() throws IOException {
        var inputStream = GetGitHubIssuesRequestTest.class.getResourceAsStream("/get-issues-response.json");
        var response = tester.readObject(inputStream);
        assertThat(response.projectId()).isEqualTo(projectId);
        assertThat(response.entity()).isEqualTo(entity);
        assertThat(response.issues()).hasSize(1);
    }

    @Test
    public void shouldThrowNpeIfProjectIdIsNull() {
        assertThrows(NullPointerException.class, () -> {
            new GetGitHubIssuesResponse(null, entity, issues);
        });
    }

    @Test
    public void shouldThrowNpeIfEntityIsNull() {
        assertThrows(NullPointerException.class, () -> {
            new GetGitHubIssuesResponse(projectId, null, issues);
        });
    }

    @Test
    public void shouldThrowNpeIfIssuesListIsNull() {
        assertThrows(NullPointerException.class, () -> {
            new GetGitHubIssuesResponse(projectId, entity, null);
        });
    }
}