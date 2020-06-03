package com.laioffer.vicabulary.model;

public class Word {
    private String word;
    private String explanation;
    private String translation;
    private int time;
    private String path;

    public void setWord(String word) {
        this.word = word;
    }


    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public void setExplanation (String explanation){
        this.explanation = explanation;
    }

    public String getWord() {
        return word;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getPath() {
        return path;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setPath(String path) {
        this.path = path;
    }
}


