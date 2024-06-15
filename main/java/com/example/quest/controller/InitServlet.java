package com.example.quest.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "InitServlet", value = "/start")
public class InitServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        response.setContentType("text/html");
        HttpSession session = request.getSession(true);
        session.setAttribute("userName",request.getParameter("userName"));
        session.setAttribute("life",3);
        session.setAttribute("correctAnswers",0);

        request.getRequestDispatcher("/question").forward(request, response);
    }
}