package edu.stanford.protege.github.issues.shared;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import com.google.gwt.user.client.rpc.IsSerializable;

import java.util.Objects;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2023-07-14
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record GitHubReactions(@JsonProperty("url") String url,
                                      @JsonProperty("total_count") int totalCount,
                                      @JsonProperty("+1") int plus1,
                                      @JsonProperty("-1") int minus1,
                                      @JsonProperty("laugh") int laugh,
                                      @JsonProperty("hooray") int hooray,
                                      @JsonProperty("confused") int confused,
                                      @JsonProperty("heart") int heart,
                                      @JsonProperty("rocket") int rocket,
                                      @JsonProperty("eyes") int eyes) {

    public GitHubReactions(@JsonProperty("url") String url,
                           @JsonProperty("total_count") int totalCount,
                           @JsonProperty("+1") int plus1,
                           @JsonProperty("-1") int minus1,
                           @JsonProperty("laugh") int laugh,
                           @JsonProperty("hooray") int hooray,
                           @JsonProperty("confused") int confused,
                           @JsonProperty("heart") int heart,
                           @JsonProperty("rocket") int rocket,
                           @JsonProperty("eyes") int eyes) {
        this.url = Objects.requireNonNullElse(url, "");
        this.totalCount = totalCount;
        this.plus1 = plus1;
        this.minus1 = minus1;
        this.laugh = laugh;
        this.hooray = hooray;
        this.confused = confused;
        this.heart = heart;
        this.rocket = rocket;
        this.eyes = eyes;
    }

    @JsonCreator
    public static GitHubReactions get(@JsonProperty("url") String url,
                                      @JsonProperty("total_count") int totalCount,
                                      @JsonProperty("+1") int plus1,
                                      @JsonProperty("-1") int minus1,
                                      @JsonProperty("laugh") int laugh,
                                      @JsonProperty("hooray") int hooray,
                                      @JsonProperty("confused") int confused,
                                      @JsonProperty("heart") int heart,
                                      @JsonProperty("rocket") int rocket,
                                      @JsonProperty("eyes") int eyes) {
        return new GitHubReactions(url,
                                             totalCount,
                                             plus1,
                                             minus1,
                                             laugh,
                                             hooray,
                                             confused,
                                             heart,
                                             rocket,
                                             eyes
        );
    }

    public static GitHubReactions empty() {
        return get(null, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    }
}
