<%@ page import="data.dto.Project1Dto" %>
<%@ page import="data.dao.Project1Dao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>뱅뱅 커피</title>
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
        .card-img-top {
            height: 200px;
            object-fit: cover;
        }
        .card-body {
            text-align: center; /* 중앙 정렬을 위한 스타일 추가 */
        }
    </style>
</head>
    <%
    Project1Dao dao = new Project1Dao();
%>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container px-4 px-lg-5">
        <a class="navbar-brand" href="#">뱅뱅 커피</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                <li class="nav-item"><a class="nav-link active" aria-current="page" href="home.jsp">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="review.jsp">Review</a></li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Menu</a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="./allmenu.jsp">전 메뉴</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="./coffee.jsp">커피</a></li>
                        <li><a class="dropdown-item" href="./blended.jsp">블렌디드</a></li>
                        <li><a class="dropdown-item" href="./ade.jsp">에이드&주스</a></li>
                        <li><a class="dropdown-item" href="./dessert.jsp">디저트</a></li>
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
    <!-- 커피 섹션 -->
    <h2 class="mb-4">Coffee</h2>
    <div class="row">
        <div class="col-md-3">
            <div class="card">
                <img src="image.pro1/c/c1.png" class="card-img-top" alt="아메리카노">
                <div class="card-body">
                    <h5 class="card-title">아메리카노</h5>
                    <p class="card-text">₩4,000</p>
                    <form action="cartaction.jsp" method="post">
                        <input type="hidden" name="itemName" value="아메리카노">
                        <input type="hidden" name="itemPrice" value="4000">
                        <button class="btn btn-primary">장바구니 담기</button>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-md-3">
            <div class="card">
                <img src="image.pro1/c/c2.png" class="card-img-top" alt="에스프레소">
                <div class="card-body">
                    <h5 class="card-title">에스프레소</h5>
                    <p class="card-text">₩3,000</p>
                    <form action="cartaction.jsp" method="post">
                        <input type="hidden" name="itemName" value="에스프레소">
                        <input type="hidden" name="itemPrice" value="3000">
                        <button class="btn btn-primary">장바구니 담기</button>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-md-3">
            <div class="card">
                <img src="image.pro1/c/c3.png" class="card-img-top" alt="카푸치노">
                <div class="card-body">
                    <h5 class="card-title">카푸치노</h5>
                    <p class="card-text">₩5,000</p>
                    <form action="cartaction.jsp" method="post">
                        <input type="hidden" name="itemName" value="카푸치노">
                        <input type="hidden" name="itemPrice" value="5000">
                        <button class="btn btn-primary">장바구니 담기</button>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-md-3">
            <div class="card">
                <img src="image.pro1/c/c4.png" class="card-img-top" alt="카페라떼">
                <div class="card-body">
                    <h5 class="card-title">카페라떼</h5>
                    <p class="card-text">₩5,000</p>
                    <form action="cartaction.jsp" method="post">
                        <input type="hidden" name="itemName" value="카페라떼">
                        <input type="hidden" name="itemPrice" value="5000">
                        <button class="btn btn-primary">장바구니 담기</button>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-md-3">
            <div class="card">
                <img src="image.pro1/c/c5.png" class="card-img-top" alt="카라멜마끼야또">
                <div class="card-body">
                    <h5 class="card-title">카라멜마끼야또</h5>
                    <p class="card-text">₩5,500</p>
                    <form action="cartaction.jsp" method="post">
                        <input type="hidden" name="itemName" value="카라멜마끼야또">
                        <input type="hidden" name="itemPrice" value="5500">
                        <button class="btn btn-primary">장바구니 담기</button>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-md-3">
            <div class="card">
                <img src="image.pro1/c/c6.png" class="card-img-top" alt="바닐라라떼">
                <div class="card-body">
                    <h5 class="card-title">바닐라라떼</h5>
                    <p class="card-text">₩5,500</p>
                    <form action="cartaction.jsp" method="post">
                        <input type="hidden" name="itemName" value="바닐라라떼">
                        <input type="hidden" name="itemPrice" value="5500">
                        <button class="btn btn-primary">장바구니 담기</button>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-md-3">
            <div class="card">
                <img src="image.pro1/c/c7.png" class="card-img-top" alt="콜드브루">
                <div class="card-body">
                    <h5 class="card-title">콜드브루</h5>
                    <p class="card-text">₩5,000</p>
                    <form action="cartaction.jsp" method="post">
                        <input type="hidden" name="itemName" value="콜드브루">
                        <input type="hidden" name="itemPrice" value="5000">
                        <button class="btn btn-primary">장바구니 담기</button>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-md-3">
            <div class="card">
                <img src="image.pro1/c/c8.png" class="card-img-top" alt="콜드브루라떼">
                <div class="card-body">
                    <h5 class="card-title">콜드브루라떼</h5>
                    <p class="card-text">₩5,500</p>
                    <form action="cartaction.jsp" method="post">
                        <input type="hidden" name="itemName" value="콜드브루라">
                        <input type="hidden" name="itemPrice" value="5500">
                        <button class="btn btn-primary">장바구니 담기</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>