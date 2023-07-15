package edu.stanford.protege.issues.shared;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2023-07-12
 */
public record GitHubReactions(String url,
                              @JsonProperty("total_count") int totalCount,
                              int plus1,
                              int minus1,
                              int laugh,
                              int hooray,
                              int confused,
                              int heart,
                              int rocket,
                              int eyes) {

}
