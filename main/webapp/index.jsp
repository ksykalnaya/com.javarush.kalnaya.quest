<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Quest</title>
</head>
<body>
<div class="container">

    <form action="start" method="GET">
        <div class="mb-3">
            <div id="gameStartText" class="fs-2">Evacuation rules</div>
        </div>
        <div class="mb-3">
            <div id="rules1" class="fs-5">The test will show your knowledge of
                how to act during evacuation from a building in fire case.</div>
            <div id="rules2" class="fs-5">Test consists of 7 questions. You can make 2 mistakes</div>
        </div>
        <div class="mb-3">
            <label for="userName" class="form-label">Write your name</label>
            <input type="text" class="form-control" name="userName" id="userName" required>
        </div>
        <input type="hidden" name="questNumber" value="1" />
        <button type="submit" class="btn btn-primary">Start Test</button>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</body>
</html>