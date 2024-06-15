package com.example.quest.entity;

import java.util.ArrayList;

public class Question {

    private int id;
    private String question;
    private ArrayList<Answer> answers;

    private Question() {}

    public int getId(){
        return id;
    }

    public String getQuestion(){
        return question;
    }

    public ArrayList<Answer> getAnswers(){
        return answers;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuestion(String question){
        this.question = question;
    }

    public void setAnswer(Answer answer){
        answers.add(answer);
    }


}
