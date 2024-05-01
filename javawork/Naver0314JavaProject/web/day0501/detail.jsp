<%@ page import="data.dao.StudentDao" %>
<%@ page import="java.util.List" %>
<%@ page import="data.dto.StudentDto" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.NumberFormat" %>
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
        div.dia{
            margin: 30px;
        }
        td.a{
            text-align: center;
            background-color: #f8ffb0;
        }
        td.b{
            text-align: center;
        }

    </style>

</head>
<%
    int num = Integer.parseInt(request.getParameter("num"));

    StudentDao dao = new StudentDao();

    StudentDto dto = dao.getData(num);

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    double avg = (dto.getJava() + dto.getSpring() + dto.getHtml())/3;

%>
<body>
<div style="width: 300px" class="dia">
    <caption><h3>[상세보기]</h3></caption>
    <table class="table table-bordered" id="ta">
        <tr>
            <td class="a">등록일</td>
            <td class="b"><%=sdf.format(dto.getWriteday())%></td>
        </tr>

        <tr>
            <td class="a">이름</td>
            <td class="b"><%=dto.getName()%></td>
        </tr>

        <tr>
            <td class="a">혈액형</td>
            <td class="b"><%=dto.getBlood()%></td>
        </tr>

        <tr>
            <td class="a">운전면허</td>
            <td class="b"><%= dto.getLicense() == 'y' ? "있음" : "없음" %></td>
        </tr>

        <tr>
            <td class="a">Java</td>
            <td class="b"><%=dto.getJava()%> 점</td>
        </tr>

        <tr>
            <td class="a">Spring</td>
            <td class="b"><%=dto.getSpring()%> 점</td>
        </tr>

        <tr>
            <td class="a">Html</td>
            <td class="b"><%=dto.getHtml()%> 점</td>
        </tr>

        <tr>
            <td class="a">총 점</td>
            <td class="b"><%=dto.getJava() + dto.getSpring() + dto.getHtml()%> 점</td>
        </tr>

        <tr>
            <td class="a">평 균</td>
            <td class="b"><%=avg%> 점</td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <button class="btn btn-outline-danger" type="button" onclick="location.href='./writeform.jsp'">추가</button>
                <button class="btn btn-outline-danger" id="del" num="<%=dto.getNum()%>" name="<%=dto.getName()%>" type="button">삭제</button>
                <button class="btn btn-outline-danger" type="button" onclick="location.href='./updateform.jsp?num=<%=dto.getNum()%>'">수정</button>
                <button class="btn btn-outline-danger" type="button" onclick="location.href='./list.jsp'">목록</button>
            </td>
        </tr>


    </table>
</div>
<script>
    //사원삭제버튼 이벤트
    $("#del").click(function (){

        let num = $(this).attr("num");
        let name = $(this).attr("name");
        let a = confirm(name + " 을 삭제하시겠습니까?")
        if(a){
            location.href="delete.jsp?num="+num
        }
    });
</script>
</body>
</html>
