package edu.stanford.protege.issues.shared;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import com.google.gwt.user.client.rpc.IsSerializable;

import java.util.Objects;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2023-07-14
 */
@AutoValue
@GwtCompatible(serializable = true)
public abstract class GitHubReactions implements IsSerializable {

    @JsonProperty("url")
    public abstract String url();

    @JsonProperty("total_count")
    public abstract int totalCount();

    @JsonProperty("+1")
    public abstract int plus1();

    @JsonProperty("-1")
    public abstract int minus1();

    @JsonProperty("laugh")
    public abstract int laugh();

    @JsonProperty("hooray")
    public abstract int hooray();

    @JsonProperty("confused")
    public abstract int confused();

    @JsonProperty("heart")
    public abstract int heart();

    @JsonProperty("rocket")
    public abstract int rocket();

    @JsonProperty("eyes")
    public abstract int eyes();

    @JsonCreator
    public static GitHubReactions get(@JsonProperty("url") String url,
                                      @JsonProperty("total_count") int totalCount,
                                      @JsonProperty("plus1") int plus1,
                                      @JsonProperty("minus1") int minus1,
                                      @JsonProperty("laugh") int laugh,
                                      @JsonProperty("hooray") int hooray,
                                      @JsonProperty("confused") int confused,
                                      @JsonProperty("heart") int heart,
                                      @JsonProperty("rocket") int rocket,
                                      @JsonProperty("eyes") int eyes) {
        return new AutoValue_GitHubReactions(Objects.requireNonNullElse(url, ""),
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
