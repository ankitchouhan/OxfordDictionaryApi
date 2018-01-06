
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
    "etymologies",
    "grammaticalFeatures",
    "homographNumber",
    "senses"
})
public class Entry {

    @JsonProperty("etymologies")
    private List<String> etymologies = null;
    @JsonProperty("grammaticalFeatures")
    private List<GrammaticalFeature> grammaticalFeatures = null;
    @JsonProperty("homographNumber")
    private String homographNumber;
    @JsonProperty("senses")
    private List<Sense> senses = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("etymologies")
    public List<String> getEtymologies() {
        return etymologies;
    }

    @JsonProperty("etymologies")
    public void setEtymologies(List<String> etymologies) {
        this.etymologies = etymologies;
    }

    @JsonProperty("grammaticalFeatures")
    public List<GrammaticalFeature> getGrammaticalFeatures() {
        return grammaticalFeatures;
    }

    @JsonProperty("grammaticalFeatures")
    public void setGrammaticalFeatures(List<GrammaticalFeature> grammaticalFeatures) {
        this.grammaticalFeatures = grammaticalFeatures;
    }

    @JsonProperty("homographNumber")
    public String getHomographNumber() {
        return homographNumber;
    }

    @JsonProperty("homographNumber")
    public void setHomographNumber(String homographNumber) {
        this.homographNumber = homographNumber;
    }

    @JsonProperty("senses")
    public List<Sense> getSenses() {
        return senses;
    }

    @JsonProperty("senses")
    public void setSenses(List<Sense> senses) {
        this.senses = senses;
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
