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
올 시즌부터 KBO는 프로야구 KBO리그에 수비 시프트 제한을 도입했고, 풀히터 좌타자들이 혜택을 볼거라고 예상했다.
    LG 김현수, 두산 김재환, KIA 최형우, 삼성 오재일 등 발느린 좌타 거포들은 그동안 1~2루 사이에 내야수 3명이 배치되는 수비 시프트로 안타를 많이 손해봤기 때문이다.
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
