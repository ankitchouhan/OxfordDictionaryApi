
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
    "definitions",
    "examples",
    "id",
    "notes",
    "domains",
    "subsenses",
    "regions",
    "registers",
    "variantForms"
})
public class Sense {

    @JsonProperty("definitions")
    private List<String> definitions = null;
    @JsonProperty("examples")
    private List<Example> examples = null;
    @JsonProperty("id")
    private String id;
    @JsonProperty("notes")
    private List<Note> notes = null;
    @JsonProperty("domains")
    private List<String> domains = null;
    @JsonProperty("subsenses")
    private List<Subsense> subsenses = null;
    @JsonProperty("regions")
    private List<String> regions = null;
    @JsonProperty("registers")
    private List<String> registers = null;
    @JsonProperty("variantForms")
    private List<VariantForm> variantForms = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("definitions")
    public List<String> getDefinitions() {
        return definitions;
    }

    @JsonProperty("definitions")
    public void setDefinitions(List<String> definitions) {
        this.definitions = definitions;
    }

    @JsonProperty("examples")
    public List<Example> getExamples() {
        return examples;
    }

    @JsonProperty("examples")
    public void setExamples(List<Example> examples) {
        this.examples = examples;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("notes")
    public List<Note> getNotes() {
        return notes;
    }

    @JsonProperty("notes")
    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    @JsonProperty("domains")
    public List<String> getDomains() {
        return domains;
    }

    @JsonProperty("domains")
    public void setDomains(List<String> domains) {
        this.domains = domains;
    }

    @JsonProperty("subsenses")
    public List<Subsense> getSubsenses() {
        return subsenses;
    }

    @JsonProperty("subsenses")
    public void setSubsenses(List<Subsense> subsenses) {
        this.subsenses = subsenses;
    }

    @JsonProperty("regions")
    public List<String> getRegions() {
        return regions;
    }

    @JsonProperty("regions")
    public void setRegions(List<String> regions) {
        this.regions = regions;
    }

    @JsonProperty("registers")
    public List<String> getRegisters() {
        return registers;
    }

    @JsonProperty("registers")
    public void setRegisters(List<String> registers) {
        this.registers = registers;
    }

    @JsonProperty("variantForms")
    public List<VariantForm> getVariantForms() {
        return variantForms;
    }

    @JsonProperty("variantForms")
    public void setVariantForms(List<VariantForm> variantForms) {
        this.variantForms = variantForms;
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
