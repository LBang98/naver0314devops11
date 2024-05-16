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
이정후는 7일(한국시각) 미국 펜실베이니아주 필라델피아의 시티즌스뱅크파크에서 열린 2024 메이저리그 필라델피아 필리스와 방문 경기에서 1번 타자 중견수로 출전해 4타수 2안타를 쳤다.
    이정후의 멀티 히트는 지난달 21일 애리조나 다이아몬드백스전 이후 16일 만이자 14경기 만이다. 시즌 타율은 0.244에서 0.252로 소폭 상승했다.
이정후는 1회초 선두 타자로 나서 상대 선발 잭 휠러의 3구째 속구를 밀어쳐 좌익수 앞 안타를 만들어냈다.
    3회초와 5회초 모두 뜬공으로 물러난 이정후는 8회초 1사 주자 없는 상황에서 중견수 앞 안타를 만들어냈다. 시속 168.7㎞의 총알 같은 타구였다.

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
