
package br.com.own.dtos;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "aspects",
    "author_name",
    "author_url",
    "language",
    "profile_photo_url",
    "rating",
    "relative_time_description",
    "text",
    "time"
})
public class Review {

    @JsonProperty("aspects")
    public List<Aspect> aspects = null;
    @JsonProperty("author_name")
    public String authorName;
    @JsonProperty("author_url")
    public String authorUrl;
    @JsonProperty("language")
    public String language;
    @JsonProperty("profile_photo_url")
    public String profilePhotoUrl;
    @JsonProperty("rating")
    public Integer rating;
    @JsonProperty("relative_time_description")
    public String relativeTimeDescription;
    @JsonProperty("text")
    public String text;
    @JsonProperty("time")
    public Integer time;

}
