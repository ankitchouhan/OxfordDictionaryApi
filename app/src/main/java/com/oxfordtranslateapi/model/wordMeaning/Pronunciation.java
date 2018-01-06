
package com.oxfordtranslateapi.model.wordMeaning;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "audioFile",
    "dialects",
    "phoneticNotation",
    "phoneticSpelling"
})
public class Pronunciation {

    @JsonProperty("audioFile")
    private String audioFile;
    @JsonProperty("dialects")
    private List<String> dialects = null;
    @JsonProperty("phoneticNotation")
    private String phoneticNotation;
    @JsonProperty("phoneticSpelling")
    private String phoneticSpelling;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("audioFile")
    public String getAudioFile() {
        return audioFile;
    }

    @JsonProperty("audioFile")
    public void setAudioFile(String audioFile) {
        this.audioFile = audioFile;
    }

    @JsonProperty("dialects")
    public List<String> getDialects() {
        return dialects;
    }

    @JsonProperty("dialects")
    public void setDialects(List<String> dialects) {
        this.dialects = dialects;
    }

    @JsonProperty("phoneticNotation")
    public String getPhoneticNotation() {
        return phoneticNotation;
    }

    @JsonProperty("phoneticNotation")
    public void setPhoneticNotation(String phoneticNotation) {
        this.phoneticNotation = phoneticNotation;
    }

    @JsonProperty("phoneticSpelling")
    public String getPhoneticSpelling() {
        return phoneticSpelling;
    }

    @JsonProperty("phoneticSpelling")
    public void setPhoneticSpelling(String phoneticSpelling) {
        this.phoneticSpelling = phoneticSpelling;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
