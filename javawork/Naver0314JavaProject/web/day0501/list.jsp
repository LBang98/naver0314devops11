<%@ page import="data.dao.StudentDao" %>
<%@ page import="data.dto.StudentDto" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
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
        #tit>th{
            background-color: #f8ffb0;
            text-align: center;
        }

    </style>

</head>
<%
    StudentDao dao = new StudentDao();

    List<StudentDto> list = dao.getAllStudent();

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

%>
<body>
<div style="width: 350px; margin: 30px; margin-left: 100px;">
    <form action="" method="post">
        <caption><h3>[목록]</h3></caption>
        <table class="table table-bordered">
            <tr id="tit">
                <th width="100">이름</th>
                <th width="150">등록일</th>
                <th>상세보기</th>
            </tr>
            <%
                for(StudentDto dto: list){%>
                    <tr style="line-height: 40px; text-align: center">
                        <td><%=dto.getName()%></td>
                        <td><%=sdf.format(dto.getWriteday())%></td>
                        <td>
                            <button class="btn btn-outline-danger" type="button" onclick="location.href='./detail.jsp?num=<%=dto.getNum()%>'">상세보기</button>
                        </td>
                    </tr>
                <%}
            %>
        </table>
    </form>
</div>
</body>
</html>
