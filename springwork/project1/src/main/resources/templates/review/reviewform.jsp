<%@ page import="data.dto.Project1Dto" %>
<%@ page import="data.dao.Project1Dao" %>
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
        #tab{
            margin-left: 30%;
            width: 500px;
        }

        .star-rating .star {
            font-size: 30px;
            cursor: pointer;
            color: lightgray;
        }

        .star-rating .star.rated {
            color: gold;
        }


    </style>
    <script type="text/javascript">
        function preview(tag){
            if(tag.files[0]){
                let f = tag.files[0];

                if(!f.type.match("image.*")){
                    alert("이미지 파일만 가능합니다")
                    return;
                }

                if(f){
                    let reader = new FileReader();
                    reader.onload=function (e){
                        $("#showimg").attr("src",e.target.result);
                    }
                    reader.readAsDataURL(tag.files[0]);
                }
            }
        }
    </script>
</head>
<%
    Project1Dao dao = new Project1Dao();
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

<div>
    <form action="reviewaction.jsp" method="post"enctype="multipart/form-data">
    <table class="table table-striped table-bordered" id="tab">
        <caption align="top"><b><h4>Review</h4></b></caption>
        <tr align="center">
            <th style="line-height: 40px">제목</th>
            <td>
                <input type="text" name="title" class="form-control" required>
            </td>
        </tr>
        <tr align="center">
            <th style="line-height: 30px">사진업로드</th>
            <td>
                <input type="file" name="upload" onchange="preview(this)" style="width: 400px;">
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <img id="showimg" src="" onerror="this.src = '../image/talent/noimage2.gif'" style="height: 100px;" >
            </td>
        </tr>
        <tr>
            <td style="line-height: 35px; font-size: 20px" align="center">별 점</td>
            <td>
                <div class="star-rating">
                    <input type="hidden" name="rating" id="rating" value="0">
                    <span class="star">&#9733;</span>
                    <span class="star">&#9733;</span>
                    <span class="star">&#9733;</span>
                    <span class="star">&#9733;</span>
                    <span class="star">&#9733;</span>
                </div>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <textarea style="width: 100%; height: 400px;" name="content" class="form-control" required></textarea>
            </td>
        </tr>
        <td colspan="2" align="center">
            <button class="btn btn-secondary" type="submit">저장하기</button>
        </td>
    </table>

    </form>
</div>
    <script>
        $(document).ready(function(){
        $('.star').click(function(){
            $(this).siblings().removeClass('rated');
            $(this).addClass('rated').prevAll().addClass('rated');
            var numStars = $(this).prevAll().length;
            $('#rating').val(numStars);
        });
    });
</script>
</body>
</html>
