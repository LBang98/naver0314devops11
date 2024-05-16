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

</head>
<%
    //  amho 라는 쿠키가 있으면 true, 없으면 false
    boolean findAmho = false;
    Cookie[] cookies = request.getCookies();

    if (cookies != null) {

        for (Cookie ck : cookies) {
            String name = ck.getName();
            if (name.equals("amho")) {
                findAmho = true;
                break;
            }
        }
    }
%>
<body>
<%
    if (findAmho) {%>
    <pre>
        피치클락의 경기 시간 단축 효과는 의심의 여지가 없었다. '피치클락에 신경쓰다 투수들이 불리해지면 시간 단축 효과가 없을 것'이라는 주장이 나오기도 하지만,
        메이저리그에서는 피치클락 도입으로 투수들의 성적이 떨어졌는데도 경기 시간은 확실히 짧아졌다.
    </pre>
<%} else {%>
        <script type="text/javascript">
           alert("먼저 암호를 입력해주세요");
           history.back();
        </script>
<%
    }
%>
</body>
</html>
