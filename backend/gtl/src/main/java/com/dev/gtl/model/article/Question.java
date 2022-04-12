package com.dev.gtl.model.article;

public class Question {
    
    private int number;
    private String description;
    private String answer;
    private String explaination;

    public Question(int number, String description, String answer, String explaination) {
        this.number = number;
        this.description = description;
        this.answer = answer;
        this.explaination = explaination;
    }


    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAnswer() {
        return this.answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getExplaination() {
        return this.explaination;
    }

    public void setExplaination(String explaination) {
        this.explaination = explaination;
    }


    @Override
    public String toString() {
        return "{" +
            " number='" + getNumber() + "'" +
            ", description='" + getDescription() + "'" +
            ", answer='" + getAnswer() + "'" +
            ", explaination='" + getExplaination() + "'" +
            "}";
    }



}
