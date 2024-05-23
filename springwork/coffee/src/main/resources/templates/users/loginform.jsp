<%@ page import="data.dto.Project1Dto" %>
<%@ page import="data.dao.Project1Dao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
    <link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Dancing+Script:wght@400..700&family=East+Sea+Dokdo&family=Jua&family=Gaegu&family=Gamja+Flower&family=Pacifico&family=Single+Day&display=swap"
          rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <style>
        body * {
            font-family: 'Gamja Flower';
        }

        div.co{
            margin-left: 45%;
            margin-top: 10%;
        }
        a.btn{
            padding: 20px;
            width: 200px;
            text-align: center;
            font-size: 30px;
        }



    </style>

</head>
<body>
<div class="co">
    <h1 style="width: 200px; text-align: center">뱅뱅 커피</h1>
    <br>
    <form action="loginaction.jsp" method="post">
    <h5>I D</h5><input type="text" style="width: 200px" name="id">
    <h5>P W</h5><input type="password" style="width: 200px" name="pw">
    <h5>이 름</h5><input type="text" style="width: 200px" name="name">
    <h5>연락처</h5><input type="text" style="width: 200px" name="hp">

    <h5>성 별</h5>
    <label>
    <input type="checkbox" value="남자">남자
    <input type="checkbox" value="여자">여자
    </label>
    <br><br>
    <a class="btn btn-outline-info" href="home.jsp" style="width: 200px; height: 50px; line-height: 5px">회원가입</a>
</div>

</body>
</html>
