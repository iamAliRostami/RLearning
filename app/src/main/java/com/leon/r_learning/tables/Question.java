package com.leon.r_learning.tables;

public class Question {

    private int questionNumber;
    private int sectionId;
    private int[] results;
    private String title;
    private String[] answers;


    public Question(int questionNumber, int sectionId, String title, String[] answers) {
        this.questionNumber = questionNumber;
        this.sectionId = sectionId;
        this.title = title;
        this.answers = answers;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public int[] getResults() {
        return results;
    }

    public void setResults(int[] results) {
        this.results = results;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }
}
