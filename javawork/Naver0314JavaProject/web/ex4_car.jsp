<%@ page import="java.util.List" %>
<%@ page import="java.util.Vector" %>
<%@ page import="test.data.CatDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
    <link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Dancing+Script:wght@400..700&family=East+Sea+Dokdo&family=Jua&family=Gaegu&family=Gamja+Flower&family=Pacifico&family=Single+Day&display=swap" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <style>
        body *{
            font-family: 'Jua';
        }
        body * {
            font-family: 'Jua';
        }
        div.car{
            float: left;
            margin: 5px;
            border: 2px solid gray;
            border-radius: 20px;
            padding: 15px;
            width: 200px;
            height: 350px;
        }
        div.car>img{
            width: 160px;
            height: 180px;
            border-radius: 20px;
        }
        div.box{
            width: 500px;
            height: 200px;
            margin-left: 100px;
            font-size: 50px;
        }
    </style>

</head>
<%
    List<CatDto> list = new Vector<>();

    list.add(new CatDto("벤츠","mycar1.png",500,2,"red"));
    list.add(new CatDto("아우디","mycar2.png",800,2,"green"));
    list.add(new CatDto("아우디2","mycar3.png",400,2,"aqua"));
    list.add(new CatDto("미니","mycar4.png",600,2,"gray"));
    list.add(new CatDto("미니2","mycar5.png",300,2,"pink"));
%>
<body>
<%
    for(CatDto dto: list){%>

<div class="car" style="background-color: <%=dto.getColor()%>">
    <img src="./car/<%=dto.getPhoto()%>">
    <h4>가격 : <%=dto.getModel()%></h4>
    <h4>수량 : <%=dto.getCount()%></h4>
    <button type="button" class="btn">구매 버튼</button>
</div>
<%}
%>
<br><br>
<div class="box">메시지</div>

<script>
    $(function (){

        $("button.btn").each(function (idx){

            $(this).click(function (){
                let msg = "구매하였습니다";
                $("div.box").html(msg);
            });
        });
    });
</script>

</body>
</html>
