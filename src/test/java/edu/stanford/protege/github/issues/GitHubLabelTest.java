package edu.stanford.protege.github.issues;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class GitHubLabelTest {

    protected static final int ID = 208045946;

    protected static final String NODE_ID = "MDU6TGFiZWwyMDgwNDU5NDY=";

    protected static final String URL = "https://api.github.com/repos/octocat/Hello-World/labels/bug";

    protected static final String NAME = "bug";

    protected static final String DESCRIPTION = "Something isn't working";

    protected static final String COLOR = "f29513";

    private JacksonTester<GitHubLabel> tester;

    @BeforeEach
    void setUp() {
        JacksonTester.initFields(this, new ObjectMapper());
    }

    @Test
    void shouldParseJson() throws IOException {
        try (var inputStream = GitHubLabelTest.class.getResourceAsStream("/label.json")) {
           var content = tester.read(inputStream);
           var label = content.getObject();
           assertThat(label.id()).isEqualTo(ID);
           assertThat(label.nodeId()).isEqualTo(NODE_ID);
           assertThat(label.url()).isEqualTo(URL);
           assertThat(label.name()).isEqualTo(NAME);
           assertThat(label.description()).isEqualTo(DESCRIPTION);
           assertThat(label.color()).isEqualTo(COLOR);
           assertThat(label.isDefault()).isTrue();
        }
    }

    @Test
    void shouldWriteJson() throws IOException {
        var label = GitHubLabel.get(ID, NODE_ID, URL, NAME, COLOR, true, DESCRIPTION);
        var content = tester.write(label);
        assertThat(content).hasJsonPathNumberValue("id", ID);
        assertThat(content).hasJsonPathStringValue("node_id", NODE_ID);
        assertThat(content).hasJsonPathStringValue("url", URL);
        assertThat(content).hasJsonPathStringValue("name", NAME);
        assertThat(content).hasJsonPathStringValue("description", DESCRIPTION);
        assertThat(content).hasJsonPathStringValue("color", COLOR);
        assertThat(content).hasJsonPathBooleanValue("default", true);
    }



    @Test
    public void testGitHubLabelProperties() {
        GitHubLabel label = GitHubLabel.get(1L, "node123", "https://example.com/label/1",
                                            "Bug", "ff0000", true, "Bug-related issues");

        assertThat(label.id()).isEqualTo(1L);
        assertThat(label.nodeId()).isEqualTo("node123");
        assertThat(label.url()).isEqualTo("https://example.com/label/1");
        assertThat(label.name()).isEqualTo("Bug");
        assertThat(label.color()).isEqualTo("ff0000");
        assertThat(label.isDefault()).isTrue();
        assertThat(label.description()).isEqualTo("Bug-related issues");
    }

    @Test
    public void testGitHubLabelWithNullValues() {
        GitHubLabel label = GitHubLabel.get(2L, null, null, null, null, false, null);

        assertThat(label.id()).isEqualTo(2L);
        assertThat(label.nodeId()).isEmpty();
        assertThat(label.url()).isEmpty();
        assertThat(label.name()).isEmpty();
        assertThat(label.color()).isEmpty();
        assertThat(label.isDefault()).isFalse();
        assertThat(label.description()).isEmpty();
    }
}