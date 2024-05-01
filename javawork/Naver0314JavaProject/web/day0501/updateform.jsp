<%@ page import="data.dao.StudentDao" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="data.dto.StudentDto" %>
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
<%
    int num = Integer.parseInt(request.getParameter("num"));

    StudentDao dao = new StudentDao();

    StudentDto dto =  dao.getData(num);
%>
<body>

<div style="margin: 10px; width: 400px;">
    <form action="./writeaction.jsp" method="post">
        <input type="hidden" value="<%=dto.getNum()%>">
        <table class="table table-bordered">
            <caption align="top"><b><h3>[수정]</h3></b></caption>
            <tr>
                <th class="table-warning" width="100">이름</th>
                <td>
                    <input type="text" name="name" class="form-control" style="width: 130px;"  value="<%=dto.getName()%>" required>
                </td>
            </tr>

            <tr>
                <th class="table-warning" width="100">혈액형</th>
                <td>
                    <select class="form-select" style="width: 100px" name="blood">
                        <option <%=dto.getBlood().equals("A")?"selected":""%>>A</option>
                        <option <%=dto.getBlood().equals("B")?"selected":""%>>B</option>
                        <option <%=dto.getBlood().equals("AB")?"selected":""%>>AB</option>
                        <option <%=dto.getBlood().equals("O")?"selected":""%>>O</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th class="table-warning" width="100">운전면허</th>
                <td>
                    <label>
                        <input type="checkbox" name="license" <%= dto.getLicense()=='y' ? "checked" : "" %> >있음
                    </label>
                </td>
            </tr>
            <tr>
                <th class="table-warning" width="100">Java 점수</th>
                <td>
                    <input type="number" name="java" class="form-control" style="width: 130px;" required
                           value="<%=dto.getJava()%>">
                </td>
            </tr>
            <tr>
                <th class="table-warning" width="100">Spring 점수</th>
                <td>
                    <input type="number" name="spring" class="form-control" style="width: 130px;" required
                           value="<%=dto.getSpring()%>">
                </td>
            </tr>
            <tr>
                <th class="table-warning" width="100">Html 점수</th>
                <td>
                    <input type="number" name="html" class="form-control" style="width: 130px;" required
                           value="<%=dto.getHtml()%>">
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <button class="btn btn-outline-danger"type="submit">학생정보저장</button>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
