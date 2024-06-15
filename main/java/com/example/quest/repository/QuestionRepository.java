package com.example.quest.repository;

import com.example.quest.entity.Question;
import com.fasterxml.jackson.databind.json.JsonMapper;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class QuestionRepository {

    private static List<Question> questions;

    private QuestionRepository() throws IOException {
        JsonMapper mapper = new JsonMapper();
        Question[] questionsArray = mapper.readValue(new FileReader("/Users/ruaklkg/Documents/com.javarush.kalnaya.quest/src/main/resources/Questions"), Question[].class);
        questions = Arrays.asList(questionsArray);
    }

    public static List<Question> getQuestions() throws IOException {
        if(questions == null){
            new QuestionRepository();
        }
        return questions;
    }
}