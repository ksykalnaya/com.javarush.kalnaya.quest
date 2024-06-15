<%-- Created by IntelliJ IDEA.
  User: ruaklkg
  Date: 09.06.2024
  Time: 18:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Question End</title>
</head>
<body>
<% String userName = (String) session.getAttribute("userName");
   int correctAnswers = (int) session.getAttribute("correctAnswers"); %>
<div class="container">
    <% String result = (String) request.getAttribute("result");
        if(result.equals("Success")){ %>
            <div class="mb-3">
                <div id="gameSuccessFinishText" class="fs-2" aria-describedby="statisticSuccess">Test passed!</div>
                <div id="statisticSuccess" class="form-text">It is very important to know what to do in case of an emergency</div>
            </div>
            <div class="mb-3">
                <div id="SuccessText" class="fs-5">${userName}, Congratulations! Your result - ${correctAnswers}</div>
            </div>
    <% }else{ %>
    <div class="mb-3">
        <div id="gameFailFinishText" class="fs-2" aria-describedby="statisticFail">Test failed!</div>
            <div id="statisticFail" class="form-text">It is very important to know what to do in case of an emergency</div>
        </div>
        <div class="mb-3">
            <div id="FailText" class="fs-5">${userName}, You need to read rules! Try Test again</div>
        </div>
    <% } %>
    <button type="button" name="start" onclick="window.location='/quest_war_exploded'" class="btn btn-primary" >Start again</button>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</body>
</html>