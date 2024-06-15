package com.example.quest.controller;

import java.io.*;
import java.util.List;

import com.example.quest.entity.Answer;
import com.example.quest.entity.Question;
import com.example.quest.repository.QuestionRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.lang3.StringUtils;

@WebServlet(name = "Question", value = "/question")
public class QuestServlet extends HttpServlet {

    private List<Question> questions;

    public void init(){
        try {
            questions = QuestionRepository.getQuestions();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        response.setContentType("text/html");
        HttpSession session = request.getSession();
        int life = (int) session.getAttribute("life");
        int correctAnswers = (int) session.getAttribute("correctAnswers");

        int questNumber = Integer.parseInt(request.getParameter("questNumber"));
        String answerId = request.getParameter("answerId");
        Boolean correctAnswer = Boolean.FALSE;
        Question curQuestion = getQuestion(questNumber);

        if(!StringUtils.isEmpty(answerId)){
            Answer answer = curQuestion.getAnswers().stream().filter(a -> a.getId() == Integer.parseInt(answerId)).findFirst().get();
            questNumber = answer.getNextQuestion();
            correctAnswer = answer.getCorrectAnswer();
        }

        if(!correctAnswer){
            --life;
            session.setAttribute("life", life);
        }else{
            ++correctAnswers;
            session.setAttribute("correctAnswers", correctAnswers);
        }

        if(life <= 0) {
            request.setAttribute("result", "Fail");
            request.getRequestDispatcher("/finish.jsp").forward(request, response);
        }
        else if(questNumber < 0){
            request.setAttribute("result", "Success");
            request.getRequestDispatcher("/finish.jsp").forward(request, response);
        }else {
            Question nextQuestion = getQuestion(questNumber);

            request.setAttribute("questNumber", nextQuestion.getId());
            request.setAttribute("questName", nextQuestion.getQuestion());
            request.setAttribute("answers", nextQuestion.getAnswers());

            request.getRequestDispatcher("/question.jsp").forward(request,response);
        }
    }

    public void destroy() {
    }

    private Question getQuestion(int id) {
        return questions.stream().filter(q -> q.getId() == id).findFirst().get();
    }
}