package com.oxfordtranslateapi.model;

import com.oxfordtranslateapi.model.wordMeaning.Sense;

import java.util.List;

/**
 * Created by Ankit Chouhan on 15/12/17.
 */

public class MeaningModel {

    private String lexicalCategory;
    private String audioFile;
    private String phoneticWord;
    private List<Sense> senseList;


    public MeaningModel() {

    }

    public MeaningModel(String lexicalCategory, String audioFile,String phoneticWord, List<Sense> senseList) {
        this.lexicalCategory = lexicalCategory;
        this.audioFile = audioFile;
        this.phoneticWord = phoneticWord;
        this.senseList = senseList;
    }

    public void setLexicalCategory(String lexicalCategory) {
        this.lexicalCategory = lexicalCategory;
    }

    public void setAudioFile(String audioFile) {
        this.audioFile = audioFile;
    }

    public void setPhoneticWord(String phoneticWord) {
        this.phoneticWord = phoneticWord;
    }

    public void setSenseList(List<Sense> senseList) {
        this.senseList = senseList;
    }

    public String getLexicalCategory() {
        return lexicalCategory;
    }

    public String getAudioFile() {
        return audioFile;
    }

    public String getPhoneticWord() {
        return phoneticWord;
    }

    public List<Sense> getSenseList() {
        return senseList;
    }
}
