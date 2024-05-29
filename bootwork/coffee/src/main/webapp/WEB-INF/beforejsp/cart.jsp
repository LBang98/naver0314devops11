<%@ page import="data.dto.Project1Dto" %>
<%@ page import="data.dao.Project1Dao" %>
<%@ page import="java.util.List" %>
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
            font-family: 'Jua';
        }

        td * {
        }
        #sho{
            margin-left: 30%;
        }

    </style>

</head>
<%

        Project1Dao dao = new Project1Dao();
        List<Project1Dto> list = dao.getCart();
%>
<body>
<!--위에 메뉴판-->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container px-4 px-lg-5">
        <a class="navbar-brand">뱅뱅 커피</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                <li class="nav-item"><a class="nav-link active" aria-current="page" href="home.jsp">Home</a></li>
                <li class="nav-item"><a class="nav-link active" aria-current="page" href="review.jsp">Review</a></li>
                <li class="nav-item"><a class="nav-link" href="#!"></a></li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Menu</a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="./allmenu.jsp">전 메뉴</a></li>
                        <li><hr class="dropdown-divider" /></li>
                        <li><a class="dropdown-item" href="./coffee.jsp">커피</a></li>
                        <li><a class="dropdown-item" href="./blended.jsp">블렌디드</a></li>
                        <li><a class="dropdown-item" href="./ade.jsp">에이드&주스</a></li>
                        <li><a class="dropdown-item" href="dessert.jsp">디저트</a></li>
                    </ul>
                </li>
            </ul>
            <form class="d-flex" action="cart.jsp" method="get">
                <button class="btn btn-outline-dark" type="submit" onclick="location.href='cart.jsp'">
                    <i class="bi bi-cart-check-fill"></i> 장바구니
                    <span class="badge bg-dark text-white ms-1 rounded-pill"><%=dao.countItem()%></span>
                </button>
            </form>
        </div>
    </div>
</nav>
<br><br>
<div id="sho">
    <caption align="top"><b><h2 style=""><i class="bi bi-cart-check-fill"></i> 장바구니</h2></b></caption>
    <hr style="width: 500px">
    <br>
    <table class="table table-striped" style="width: 500px">

        <tr class="table table-info table-bordered" align="center">
            <td style="width: 130px; line-height: 40px">상품명</td>
            <th style="width: 200px; line-height: 40px">가격</th>
            <td style="width: 100px">
                <button class="btn btn-outline-danger"type="button" onclick="location.href='./delallaction.jsp'">전체삭제</button>
            </td>
        </tr>
            <%
        int sum = 0;
        for(Project1Dto dto: list){
            sum += dto.getItemPrice();
    %>
        <tr align="center">
            <td><%=dto.getItemName()%></td>
            <td>￦ <%=dto.getItemPrice()%></td>
            <td>
                <button class="btn btn-outline-danger" id="del" type="button" name="<%=dto.getItemName()%>" id="aa"
                onclick="location.href='./delaction.jsp?num=<%=dto.getNum()%>'"><i class="bi bi-x-lg"></i></button>
            </td>
        </tr>
            <% } %>
        <tr align="center">
            <td colspan="2" style="background-color: #e4ffff"><b>총 합계</b></td>
            <td style="background-color: #e4ffff">￦ <%=sum%></td>
        </tr>

        <tr>
            <td colspan="3" align="center">
                    <button class="btn btn-outline-info" type="button" onclick="location.href='allmenu.jsp'">Home</button>
            </td>
        </tr>
    </table>
</div>
</body>
</html>