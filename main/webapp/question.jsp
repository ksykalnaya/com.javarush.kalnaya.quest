<%-- Created by IntelliJ IDEA.
  User: ruaklkg
  Date: 09.06.2024
  Time: 18:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.example.quest.entity.Answer" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Question #${questNumber}</title>
</head>
<body>
<% int life = (int) session.getAttribute("life");
    int correctAnswers = (int) session.getAttribute("correctAnswers"); %>
<div class="container">
    <form action="question" method="GET">
        <div class="mb-3">
            <div id="gameStartText" class="fs-2" aria-describedby="statistic">QUESTION ${questNumber} : ${questName}</div>
            <div id="statistic" class="form-text">Correct answers : ${correctAnswers} | Life : ${life}</div>
        </div>
        <% List<Answer> answers = (List<Answer>) request.getAttribute("answers");
            for(Answer answer : answers){
        %>
        <div class="form-check mb-3">
            <input class="form-check-input" type="radio" name="answerId" value="<%= answer.getId() %>" id="flexRadioDefault1" required>
            <input type="hidden" name="questNumber" value="${questNumber}" />
            <label class="form-check-label" for="flexRadioDefault1">
                <%= answer.getAnswer()%>
            </label>
        </div>
        <% } %>
        <button type="submit" class="btn btn-primary">Continue</button>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</body>
</html>

