
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
    "derivatives",
    "entries",
    "language",
    "lexicalCategory",
    "pronunciations",
    "text"
})
public class LexicalEntry {

    @JsonProperty("derivatives")
    private List<Derivative> derivatives = null;
    @JsonProperty("entries")
    private List<Entry> entries = null;
    @JsonProperty("language")
    private String language;
    @JsonProperty("lexicalCategory")
    private String lexicalCategory;
    @JsonProperty("pronunciations")
    private List<Pronunciation> pronunciations = null;
    @JsonProperty("text")
    private String text;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("derivatives")
    public List<Derivative> getDerivatives() {
        return derivatives;
    }

    @JsonProperty("derivatives")
    public void setDerivatives(List<Derivative> derivatives) {
        this.derivatives = derivatives;
    }

    @JsonProperty("entries")
    public List<Entry> getEntries() {
        return entries;
    }

    @JsonProperty("entries")
    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }

    @JsonProperty("language")
    public String getLanguage() {
        return language;
    }

    @JsonProperty("language")
    public void setLanguage(String language) {
        this.language = language;
    }

    @JsonProperty("lexicalCategory")
    public String getLexicalCategory() {
        return lexicalCategory;
    }

    @JsonProperty("lexicalCategory")
    public void setLexicalCategory(String lexicalCategory) {
        this.lexicalCategory = lexicalCategory;
    }

    @JsonProperty("pronunciations")
    public List<Pronunciation> getPronunciations() {
        return pronunciations;
    }

    @JsonProperty("pronunciations")
    public void setPronunciations(List<Pronunciation> pronunciations) {
        this.pronunciations = pronunciations;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
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
