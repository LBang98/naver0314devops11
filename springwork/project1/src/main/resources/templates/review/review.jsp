reviewform.jsp
<%@ page import="data.dto.Project1Dto" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="data.dao.Project1Dao" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>뱅뱅 커피 리뷰</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Jua', sans-serif;
        }
        .card {
            margin-top: 20px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
            transition: transform 0.3s;
        }
        .card:hover {
            transform: translateY(-5px);
        }
        .star-rating .star {
            font-size: 30px;
            cursor: pointer;
            color: lightgray;
        }

        .star-rating .star.rated {
            color: gold;
        }

        .card img {
            object-fit: cover;
            height: 300px;
        }
        .card-body {
            padding: 15px;
        }
    </style>
</head>
<%
    Project1Dao dao = new Project1Dao();
    List<Project1Dto> list = dao.getAllMemo();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
%>

<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
        <a class="navbar-brand" href="#">뱅뱅 커피</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item"><a class="nav-link active" href="home.jsp">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="review.jsp">Review</a></li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Menu
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="allmenu.jsp">전 메뉴</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="coffee.jsp">커피</a></li>
                        <li><a class="dropdown-item" href="blended.jsp">블렌디드</a></li>
                        <li><a class="dropdown-item" href="ade.jsp">에이드&주스</a></li>
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

<div class="container mt-5">
    <div class="row">
        <button class="btn btn-outline-info" type="button" onclick="location.href='reviewform.jsp'">리뷰쓰기</button>
        <% for(Project1Dto dto : list) { %>
        <div class="col-md-4">
            <div class="card">
                <caption align="top">
                    <button type="button" style="margin-left: 90%; width: 30px; border-color: white; background-color: #bdffff;"
                    onclick="location.href='./reviewdelaction.jsp?num=<%=dto.getNum()%>'">X</button>
                </caption>
                <img src="../save/<%=dto.getUploadPhoto()%>" alt="Review Image" class="card-img-top">
                <div class="card-body">
                    <h5 class="card-title">제목 : <%=dto.getTitle()%></h5>
                    <div class="star-rating">
                        <% for(int i = 1; i <= 5; i++) { %>
                        <% if(i <= dto.getRating()) { %>
                        <span class="star rated">&#9733;</span>
                        <% } else { %>
                        <span class="star">&#9733;</span>
                        <% } %>
                        <% } %>
                    </div>
                    <p class="card-text"><%=sdf.format(dto.getWriteday())%></p>
                    <pre class="content" style="font-size: 20px; font-family: 'Jua'"><%=dto.getContent()%></pre>
                </div>
            </div>
        </div>
        <% } %>
    </div>
</div>
</body>
</html>
