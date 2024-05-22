<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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
    <title>Title</title>
</head>
<body>
<h1>MemberList
</h1>
<h5 class="alert alert-info">총 ${totalCount}명 있음
    <span type="button" class="btn btn-sm btn-success" onclick="location.href='./form'">
        멤버등록
    </span>
</h5>
<div>
    <table>
        <tr>
            <th>번호</th>
            <th>이름</th>
            <th>아이디</th>
            <th>핸드폰</th>
            <th>상세보기</th>
            <th>삭제</th>
        </tr>
        <c:forEach items="${memberList}" var="member" varStatus="i">
            <tr class="member-data">
                <td>${member.num}</td>
                <td>${member.name}</td>
                <td>${member.myid}</td>
                <td>${member.hp}</td>
                <td>
                    <button onclick="location.href='./detail?num=${member.num}'">Detail</button>
                </td>
                <td>
                    <button onclick="deleteMember('${member.name}', ${member.num}, ${i.index})">삭제</button>
                </td>
            </tr>
        </c:forEach>

    </table>
</div>


<script>
    function deleteMember(name, num, rowNum) {
        if (confirm(name + "님 정보를 삭제하시겠습니까?")) {
            fetch('/member/delete', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ num: num })
            })
                .then(response => response.json())
                .then(data => {
                    if (data.status === 'success') {
                        // 삭제 성공 시, 해당 행 제거
                        removeRow(rowNum);
                    } else {
                        // 삭제 실패 시, 에러 처리
                        alert(data.message);
                    }
                })
                .catch(error => {
                    alert("다시 시도해주세요");
                    console.error('삭제 중 오류 발생:', error);
                });
        }
    }


    function removeRow(rowNum){
        var row = document.querySelectorAll(".member-data");
        row[rowNum].remove();
    }
</script>
</body>
</html>
