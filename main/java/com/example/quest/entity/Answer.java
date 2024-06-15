package com.example.quest.entity;

import com.example.quest.repository.QuestionRepository;

public class Answer {
    private int id;
    private String answer;
    private int nextQuestion;
    private Boolean correctAnswer;

    private Answer(){}

    public int getId(){
        return id;
    }

    public String getAnswer(){
        return answer;
    }

    public int getNextQuestion(){
        return nextQuestion;
    }

    public Boolean getCorrectAnswer(){
        return correctAnswer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setNextQuestion(int nextQuestion) {
        this.nextQuestion = nextQuestion;
    }

    public void setCorrectAnswer(Boolean correctAnswer) {
        this.correctAnswer = correctAnswer;
    }


}
