<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>축구 경기 순위</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1>축구 경기 순위</h1>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>순위</th>
            <th>팀명</th>
            <th>승점</th>
            <th>경기수</th>
            <th>승리</th>
            <th>무승부</th>
            <th>패배</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="team" items="${standings.standings[0].table}">
            <tr>
                <td>${team.position}</td>
                <td>${team.team.name}</td>
                <td>${team.points}</td>
                <td>${team.playedGames}</td>
                <td>${team.won}</td>
                <td>${team.draw}</td>
                <td>${team.lost}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
