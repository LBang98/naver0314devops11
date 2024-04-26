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
    </style>
    <script>
        $(function (){
            $("div.view").hide();
            $("h5.title").css("cursor","pointer");
            //제목 클릭 시 아래의 내용이 보이게 하기
            //다른 내용은 접기
            $("h5.title").click(function (){
                $("h5.tilte").next().hide();
                $(this).next().slideDown('fast');
            });
        });
    </script>
</head>
<body>
<h3 class="alert alert-danger">JSP의 Action Tag include</h3>
<h5 class="title">2024-04-26 1번 예제</h5>
<div class="view">
    <jsp:include page="ex1_test.jsp"/>
</div>

<h5 class="title">2024-04-26 2번 예제</h5>
<div class="view">
    <jsp:include page="ex2_gugudan.jsp"/>
</div>

</body>
</html>
