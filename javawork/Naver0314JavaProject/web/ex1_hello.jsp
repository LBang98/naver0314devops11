<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<h3>html 주석과 jsp 주석 비교하기</h3>
<!--    html 주석   <%=new Date()%>  -->
<%--    jsp 주석   <%=new Date()%>   --%>

<h5>선언문의 변수는 위치 상관없이 출력 가능하다</h5>
<h5>이름 : <%=name%></h5>
<h5>나이 : <%=age%></h5>
<%!
    //선언문이라고 부른다
    //여기서 선언하는 변수는 서블릿으로 변환시 위치 상관없이 멤버변수로 선언된다
    String name = "송혜교";
    int age = 30;
%>

<%
    //스크립트릿이라고 부른다(Scriptlet)
    String addr = "서울";
    out.print("<h5 class='alert alert-danger'>나의 주소는 "+addr+"입니다</h5>");
%>

</body>
</html>
