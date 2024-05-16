<%@ page import="java.util.List" %>
<%@ page import="java.util.Vector" %>
<%@ page import="test.data.ShopDto" %>
<%@ page import="day0325.Shop" %>
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
        div.shop{
            float: left;
            margin: 5px;
            border: 2px solid gray;
            border-radius: 20px;
            padding: 15px;
            width: 200px;
            height: 300px;
        }
        div.shop>img{
            width: 160px;
            height: 180px;
            border-radius: 20px;
        }
    </style>

</head>
<%
    List <ShopDto>list = new Vector();
    //5개의 상품을 리스트에 등록해보자
    list.add(new ShopDto("보석머리띠","30.jpg",23000,3,"orange"));
    list.add(new ShopDto("화이트자켓","31.jpg",35000,3,"pink"));
    list.add(new ShopDto("꽃머리끈","26.jpg",19000,3,"yellow"));
    list.add(new ShopDto("플렛슈즈","14.jpg",95000,3,"green"));
    list.add(new ShopDto("쁘띠스카프","10.jpg",40000,3,"hotpink"));
%>
<body>
<%
    for(ShopDto dto: list){%>
        <div class="shop" style="background-color: <%=dto.getColor()%>">
            <img src="./shop/<%=dto.getPhoto()%>">
            <h5>이름 : <%=dto.getSangpum()%></h5>
            <h5>가격 : <%=dto.getPrice()%></h5>
            <h5>수량 : <%=dto.getCount()%></h5>
        </div>
    <%}
%>

</body>
</html>
