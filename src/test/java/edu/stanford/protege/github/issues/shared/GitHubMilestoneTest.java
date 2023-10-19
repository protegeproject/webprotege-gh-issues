package edu.stanford.protege.github.issues.shared;

import com.google.gwt.user.client.rpc.IsSerializable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJson;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;
import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;


@JsonTest
@AutoConfigureJson
public class GitHubMilestoneTest {

    protected static final Instant CREATED_AT = Instant.parse("2011-04-10T20:09:31Z");

    protected static final Instant UPDATED_AT = Instant.parse("2014-03-03T18:58:10Z");

    protected static final Instant CLOSED_AT = Instant.parse("2013-02-12T13:22:01Z");

    protected static final Instant DUE_ON = Instant.parse("2012-10-09T23:39:01Z");

    protected static final String TITLE = "Milestone 1";

    protected static final String DESCRIPTION = "Description of Milestone 1";

    protected static final String NODE_ID = "node456";

    protected static final long ID = 1L;

    protected static final int NUMBER = 42;

    protected static final int OPEN_ISSUES = 5;

    protected static final int CLOSED_ISSUES = 2;

    protected static final GitHubUser CREATOR = GitHubUserTest.getUser();

    @Autowired
    private JacksonTester<GitHubMilestone> tester;




    @Test
    public void shouldParseJson() throws IOException {
        try (var inputStream = GitHubMilestoneTest.class.getResourceAsStream("/milestone.json")) {
            var milestone = tester.readObject(inputStream);
            assertThat(milestone.url()).isEqualTo("https://api.github.com/repos/octocat/Hello-World/milestones/1");
            assertThat(milestone.id()).isEqualTo(1002604);
            assertThat(milestone.nodeId()).isEqualTo("MDk6TWlsZXN0b25lMTAwMjYwNA==");
            assertThat(milestone.number()).isEqualTo(1);
            assertThat(milestone.state()).isEqualTo(GitHubState.OPEN);
            assertThat(milestone.title()).isEqualTo("v1.0");
            assertThat(milestone.creator()).isEqualTo(CREATOR);
            assertThat(milestone.openIssues()).isEqualTo(4);
            assertThat(milestone.closedIssues()).isEqualTo(8);
            assertThat(milestone.createdAt()).isEqualTo(Instant.parse("2011-04-10T20:09:31Z"));
            assertThat(milestone.updatedAt()).isEqualTo(Instant.parse("2014-03-03T18:58:10Z"));
            assertThat(milestone.closedAt()).isEqualTo(Instant.parse("2013-02-12T13:22:01Z"));
            assertThat(milestone.dueOn()).isEqualTo(Instant.parse("2012-10-09T23:39:01Z"));
        }
    }

    @Test
    public void shouldWriteJson() throws IOException {
        var milestone = getMilestone();
        var content = tester.write(milestone);
        assertThat(content).hasJsonPathStringValue("url", "https://example.com/milestone/1");
        assertThat(content).hasJsonPathNumberValue("id", ID);
        assertThat(content).hasJsonPathStringValue("node_id", NODE_ID);
        assertThat(content).hasJsonPathNumberValue("number", NUMBER);
        assertThat(content).hasJsonPathStringValue("title", TITLE);
        assertThat(content).hasJsonPathStringValue("description", DESCRIPTION);
        assertThat(content).hasJsonPathNumberValue("open_issues", OPEN_ISSUES);
        assertThat(content).hasJsonPathNumberValue("closed_issues", CLOSED_ISSUES);
        assertThat(content).hasJsonPathStringValue("state", "open");
        assertThat(content).hasJsonPathStringValue("created_at", CREATED_AT);
        assertThat(content).hasJsonPathStringValue("updated_at", UPDATED_AT);
        assertThat(content).hasJsonPathStringValue("due_on", DUE_ON);
        assertThat(content).hasJsonPathStringValue("closed_at", CLOSED_AT);
    }

    @Test
    public void shouldBeGwtSerializable() {

        assertThat(GitHubMilestone.class.getInterfaces()).contains(IsSerializable.class);

        var anno = GitHubMilestone.class.getAnnotation(GwtCompatible.class);
        assertThat(anno).isNotNull();
    }


    @Test
    public void testGitHubMilestoneProperties() {
        var milestone = getMilestone();

        assertThat(milestone.url()).isEqualTo("https://example.com/milestone/1");
        assertThat(milestone.id()).isEqualTo(ID);
        assertThat(milestone.nodeId()).isEqualTo(NODE_ID);
        assertThat(milestone.number()).isEqualTo(NUMBER);
        assertThat(milestone.title()).isEqualTo(TITLE);
        assertThat(milestone.description()).isEqualTo(DESCRIPTION);
        assertThat(milestone.creator()).isEqualTo(CREATOR);
        assertThat(milestone.openIssues()).isEqualTo(OPEN_ISSUES);
        assertThat(milestone.closedIssues()).isEqualTo(CLOSED_ISSUES);
        assertThat(milestone.state()).isEqualTo(GitHubState.OPEN);
        assertThat(milestone.getCreatedAt()).isPresent().contains(CREATED_AT);
        assertThat(milestone.getUpdatedAt()).isPresent().contains(UPDATED_AT);
        assertThat(milestone.getDueOn()).isPresent().contains(DUE_ON);
        assertThat(milestone.getClosedAt()).isPresent().contains(CLOSED_AT);
    }

    public static GitHubMilestone getMilestone() {
        return GitHubMilestone.get("https://example.com/milestone/1",
                                   ID,
                                   NODE_ID,
                                   NUMBER,
                                   TITLE,
                                   DESCRIPTION,
                                   CREATOR,
                                   OPEN_ISSUES,
                                   CLOSED_ISSUES,
                                   GitHubState.OPEN,
                                   CREATED_AT,
                                   UPDATED_AT,
                                   DUE_ON,
                                   CLOSED_AT);
    }

    @Test
    public void testGitHubMilestoneWithNullValues() {
        var milestone = GitHubMilestone.get(null, 2L, null, 0, null, null, null, 0, 0, null, null, null, null, null);

        assertThat(milestone.url()).isEmpty();
        assertThat(milestone.id()).isEqualTo(2L);
        assertThat(milestone.nodeId()).isEmpty();
        assertThat(milestone.number()).isEqualTo(0);
        assertThat(milestone.title()).isEmpty();
        assertThat(milestone.description()).isEmpty();
        assertThat(milestone.creator()).isEqualTo(GitHubUser.empty());
        assertThat(milestone.openIssues()).isEqualTo(0);
        assertThat(milestone.closedIssues()).isEqualTo(0);
        assertThat(milestone.state()).isEqualTo(GitHubState.OPEN);
        assertThat(milestone.getCreatedAt()).isEmpty();
        assertThat(milestone.getUpdatedAt()).isEmpty();
        assertThat(milestone.getDueOn()).isEmpty();
        assertThat(milestone.getClosedAt()).isEmpty();
    }
}