<%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 5. 21.
  Time: 오전 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
    <link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Dancing+Script:wght@400..700&family=East+Sea+Dokdo&family=Jua&family=Gaegu&family=Gamja+Flower&family=Pacifico&family=Single+Day&display=swap"
          rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <style>
        body * {
            font-family: 'Jua';
        }

        .id_ok {
            color: #008000;
            display: none;
        }

        .id_already {
            color: #ff2929;
            display: none;
        }
    </style>
    <title>Title</title>

</head>
<body>
<h1>update form</h1>
<form action="/member/update" method="post" enctype="multipart/form-data">
    <input type="hidden" name="num" value="${dto.num}">
    <label for="name">이름:</label>
    <input type="text" id="name" name="name" value="${dto.name}">
    <br><br>
    <label for="hp">핸드폰:</label>
    <input type="tel" name="hp" id="hp" required pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" placeholder="xxx-xxxx-xxxx"
           value="${dto.hp}">
    <br><br>
    <label for="email">이메일:</label>
    <input type="email" id="email" name="email" value="${dto.email}">
    <br><br>
    <label for="addr">주소:</label>
    <input type="text" id="addr" name="addr" value="${dto.addr}">
    <br><br>
    <label for="addr">생년월일:</label>
    <input type="date" id="birthday" name="birthday" value="${dto.birthday}">
    <br><br>
    <button class="btn btn-outline-danger" type="submit">Submit</button>
</form>

</body>
</html>
