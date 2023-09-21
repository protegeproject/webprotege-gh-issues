package edu.stanford.protege.issues.shared;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJson;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;
import java.time.Instant;
import java.util.List;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@JsonTest
@AutoConfigureJson
class GitHubIssueTest {

    private static final long ID = 1;

    private static final String NODE_ID = "MDU6SXNzdWUx";

    private static final String URL = "https://api.github.com/repos/octocat/Hello-World/issues/1347";

    private static final int NUMBER = 1347;

    private static final GitHubState STATE = GitHubState.OPEN;

    private static final String TITLE = "Found a bug";

    private static final String BODY = "I'm having a problem with this.";

    private static final boolean LOCKED = true;

    private static final String ACTIVE_LOCK_REASON = "too heated";

    private static final int COMMENTS = 0;

    private static final Instant CLOSED_AT = Instant.EPOCH;

    private static final Instant CREATED_AT = Instant.parse("2011-04-22T13:33:48Z");

    private static final Instant UPDATED_AT = Instant.parse("2011-04-22T13:33:48Z");

    private static final GitHubUser CLOSED_BY = GitHubUserTest.getUser();

    private static final GitHubAuthorAssociation AUTHOR_ASSOCIATION = GitHubAuthorAssociation.COLLABORATOR;

    private static final GitHubStateReason STATE_REASON = GitHubStateReason.COMPLETED;

    protected static final String HTML_URL = "https://example.org/html/issue";

    @Autowired
    private JacksonTester<GitHubIssue> tester;

    @Test
    void shouldParseJson() throws IOException {
        var inputStream = GitHubIssueTest.class.getResourceAsStream("/issue.json");
        var issue = tester.readObject(inputStream);
        assertThat(issue.id()).isEqualTo(ID);
        assertThat(issue.nodeId()).isEqualTo(NODE_ID);
        assertThat(issue.url()).isEqualTo(URL);
        assertThat(issue.number()).isEqualTo(NUMBER);
        assertThat(issue.state()).isEqualTo(STATE);
        assertThat(issue.title()).isEqualTo(TITLE);
        assertThat(issue.body()).isEqualTo(BODY);
        assertThat(issue.locked()).isEqualTo(LOCKED);
        assertThat(issue.activeLockReason()).isEqualTo(ACTIVE_LOCK_REASON);
        assertThat(issue.comments()).isEqualTo(COMMENTS);
        assertThat(issue.createdAt()).isEqualTo(CREATED_AT);
        assertThat(issue.updatedAt()).isEqualTo(UPDATED_AT);
        assertThat(issue.closedAt()).isEqualTo(CLOSED_AT);
        assertThat(issue.closedBy()).isEqualTo(CLOSED_BY);
        assertThat(issue.authorAssociation()).isEqualTo(AUTHOR_ASSOCIATION);
        assertThat(issue.stateReason()).isEqualTo(STATE_REASON);
    }

    @Test
    public void shouldWriteJson() throws IOException {
        var content = tester.write(GitHubIssue.get(
                URL,
                ID,
                NODE_ID,
                NUMBER,
                TITLE,
                GitHubUserTest.getUser(),
                List.of(), HTML_URL,
                STATE,
                LOCKED,
                GitHubUserTest.getUser(),
                List.of(GitHubUserTest.getUser()),
                GitHubMilestoneTest.getMilestone(),
                COMMENTS,
                CREATED_AT,
                UPDATED_AT,
                CLOSED_AT,
                GitHubUserTest.getUser(),
                AUTHOR_ASSOCIATION,
                ACTIVE_LOCK_REASON,
                BODY,
                GitHubReactionsTest.getReactions(),
                STATE_REASON
        ));
        assertThat(content).hasJsonPathStringValue("url", URL);
        assertThat(content).hasJsonPathNumberValue("id", ID);
        assertThat(content).hasJsonPathStringValue("node_id", NODE_ID);
        assertThat(content).hasJsonPathNumberValue("number", NUMBER);
        assertThat(content).hasJsonPathStringValue("title", TITLE);
        assertThat(content).hasJsonPathValue("assignee");
        assertThat(content).hasJsonPathArrayValue("assignees");
        assertThat(content).hasJsonPathStringValue("html_url", HTML_URL);


    }
}