<%@ page import="data.dto.SawonDto" %>
<%@ page import="data.dao.SawonDao" %>
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
        div.ab{
            width: 700px;
            height: 700px;
            margin: 30px;
        }
        .a{
            border: 2px solid black;
        }
        .a>td{
            border: 1px solid black;
        }
    </style>

</head>
<%

    int num = Integer.parseInt(request.getParameter("num"));

    SawonDao dao = new SawonDao();

    SawonDto dto = dao.getData(num);

%>
<body>
<div class="ab">
    <caption><h2>[<%=dto.getName()%> 사원정보]</h2></caption>
    <table class="a">
        <tr>
            <td rowspan="6" width="300">
                <img src='<%=dto.getPhoto().equals("no")?"../image/talent/noimage1.png":dto.getPhoto()%>'
                     style="margin:10px;width:300px;">
            </td>
            <td><h5>이름 : <%=dto.getName()%></h5></td>
        </tr>

        <tr>
            <td><h5>나이 : <%=dto.getAge()%> 세</h5></td>
        </tr>

        <tr>
            <td><h5>주소 : <%=dto.getAddr()%></h5></td>
        </tr>

        <tr>
            <td><h5>부서 : <%=dto.getBuseo()%></h5></td>
        </tr>

        <tr>
            <td><h5>성별 : <%=dto.getGender()%></h5></td>
        </tr>

        <tr>
            <td><h5>생년월일 : <%=dto.getBirthday()%></h5></td>
        </tr>
        <tr height="60">
            <td colspan="2" align="center">
                <button type="button" class="btn btn-sm btn-warning"
                style="width: 80px;" onclick="location.href='sawonform.jsp'">사원추가</button>
                <button type="button" class="btn btn-sm btn-warning" id="delsawon"
                        style="width: 80px;" num=<%=dto.getNum()%> sawonname="<%=dto.getName()%>">사원삭제</button>
                <button type="button" class="btn btn-sm btn-warning"
                        style="width: 80px;" onclick="location.href='sawonlist.jsp'">사원목록</button>
                <button type="button" class="btn btn-sm btn-warning"
                        style="width: 80px;" onclick="location.href='sawonupdateform.jsp?num=<%=dto.getNum()%>'">정보수정</button>
            </td>
        </tr>
    </table>
</div>
<script>
    //사원삭제버튼 이벤트
    $("#delsawon").click(function (){

        let num = $(this).attr("num");
        let sawonname = $(this).attr("name");
        let a = confirm(sawonname + " 사원을 삭제하시겠습니까?")
        if(a){
            location.href='sawondelete.jsp?num=<%=dto.getNum()%>'
        }

    });
</script>
</body>
</html>
