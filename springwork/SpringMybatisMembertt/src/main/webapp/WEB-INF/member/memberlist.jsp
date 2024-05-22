<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title></title>
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
    </style>

</head>
<body>
<h2 class="alert alert-danger">
    총 ${totalCount}명의 회원이 있습니다
<span style="float: right;">
    <button type="button" class="btn btn-sm btn-success" onclick="location.href='./form'">멤버등록</button>
</span>
</h2>
<table class="table-bordered" width="600" align="center">
    <tr class="alert alert-danger" align="center">
        <th width="50">번호</th>
        <th width="120">아이디</th>
        <th width="200">핸드폰</th>
        <th>상세보기</th>
    </tr>
    <c:forEach items="${list}" var="s" >

    <tr align="center">
        <td>${s.num}</td>
        <td>${s.myid}</td>
        <td>${s.hp}</td>
        <td>
            <button class="btn btn-outline-danger" type="button">상세보기</button>
            <button class="btn btn-outline-danger" type="button">삭제</button>
        </td>
    </tr>
    </c:forEach>

</table>

</body>
</html>