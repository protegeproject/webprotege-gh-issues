package edu.stanford.protege.issues.shared;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2023-09-13
 */
public class GitHubReactionTest {

    @Test
    public void shouldHaveValidEmoji() {
        Arrays.stream(GitHubReaction.values())
                .forEach(emoji -> {
                    System.out.println(emoji.getEmoji());
                });
    }
}
