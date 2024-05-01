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
        img.photo{
            position: absolute;
            left:340px;
            top: 250px;
            width: 150px;
            border: 2px solid gray;
        }
    </style>

</head>
<%
    int num = Integer.parseInt(request.getParameter("num"));

    SawonDao dao = new SawonDao();

    SawonDto dto = dao.getData(num);
%>
<body>
<div style="margin: 20px; width: 300px">
    <form action="./sawonupdateaction.jsp" method="post">
        <input type="hidden" name="num" value="<%=num%>">

        <table class="table table-bordered">
            <caption align="top">
                <h5 class="alert alert-warning">사원정보입력</h5>
            </caption>
            <tr>
                <th width="100" class="table-danger">사원명</th>
                <td>
                    <input value="<%=dto.getName()%>" type="text" name="name" class="form-control" required autofocus>
                </td>
            </tr>

            <tr>
                <th width="100" class="table-danger">나이</th>
                <td>
                    <input value="<%=dto.getAge()%>" type="number" min="1" max="100" step="1" value="0" name="age" class="form-control" required>
                </td>
            </tr>

            <tr>
                <th width="100" class="table-danger">주소</th>
                <td>
                    <input value="<%=dto.getAddr()%>" type="text" name="addr" class="form-control" required>
                </td>
            </tr>

            <tr>
                <th width="100" class="table-danger">부서</th>
                <td>
                    <select class="form-select" name="buseo">
                        <option <%=dto.getBuseo().equals("교육부")?"selected":""%>>교육부</option>
                        <option <%=dto.getBuseo().equals("인사부")?"selected":""%>>인사부</option>
                        <option <%=dto.getBuseo().equals("홍보부")?"selected":""%>>홍보부</option>
                        <option <%=dto.getBuseo().equals("해외파견부")?"selected":""%>>해외파견부</option>
                    </select>
                </td>
            </tr>

            <tr>
                <th width="100" class="table-danger">성별</th>
                <td>
                    <label>
                        <input type="radio" name="gender" value="남자"
                            <%=dto.getGender().equals("남자")?"checked":""%>>남자
                    </label>
                    <label>
                        <input type="radio" name="gender" value="여자"
                        <%=dto.getGender().equals("여자")?"checked":""%>>여자
                    </label>
                </td>
            </tr>

            <tr>
                <th width="100" class="table-danger">프로필사진</th>
                <td>
                    <img class="photo" src="<%=dto.getPhoto().equals("no")?  "../image/talent/noimage1.png" : dto.getPhoto()%>">
                    <select class="form-select" name="photo" id="photo">
                        <option value="no">프로필사진없음</option>
                        <%
                            for(int i=1; i<=20; i++){
                                String v = "../image/talent/" + i + ".jpg";

                        %>
                        <option value="<%=v%>">프로필사진 #<%=i%></option>
                        <%}
                        %>
                    </select>
                    <script>
                        $("#photo").change(function (){
                            let src = $(this).val();
                            $("img.photo").attr("src",src);
                        });
                    </script>
                </td>
            </tr>

            <tr>
                <th width="100" class="table-danger">생년월일</th>
                <td>
                    <input type="date" class="form-control" name="birthday" value="<%=dto.getBirthday()%>">
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <button type="submit" class="btn btn-secondary">수정</button>
                    <button type="button" class="btn btn-secondary" onclick="location.href='sawonlist.jsp'">사원목록</button>
                </td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>
