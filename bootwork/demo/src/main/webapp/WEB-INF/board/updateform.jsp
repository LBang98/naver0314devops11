<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        div.a{
            margin-left: 200px;
            float: left;
        }

        #showimg{
            width: 200px;
            margin-left:30px;
            margin-top: 100px;
        }

    </style>

</head>
<c:set var="stpath" value="https://kr.object.ncloudstorage.com/bitcamp-bucket-56/photocommon"/>
<c:if test="${sessionScope.loginok == null}">
    <script type="text/javascript">
        alert("먼저 로그인 후 글을 작성해주세요");
        history.back();
    </script>
</c:if>
<script type="text/javascript">
    $(function() {
        $("#upload").change(function () {

            let reg = /(.*?)\/(jpg|jpeg|png|gif)$/;
            let f = $(this)[0].files[0];
            if (!f.type.match(reg)) {
                alert("이미지 파일만 가능합니다");
                return;
            }
            if (f) {
                let reader = new FileReader();
                reader.onload = function (e) {
                    $("#showimg").attr("src", e.target.result);
                }
                reader.readAsDataURL($(this)[0].files[0]);
            }
        });
    })
</script>
<body>
<form action="./update" method="post" enctype="multipart/form-data">
    <div class="a">
        <!-- 5개 hidden -->
        <input type="hidden" name="num" value="${dto.num}">
        <input type="hidden" name="currentPage" value="${currentPage}">

        <table class="table table-bordered" style="width: 400px;">
            <caption align="top">
                <h4><b>글 수정</b></h4>
            </caption>
            <tr>
                <th width="100" class="table-warning">제목</th>
                <td>
                    <input type="text" name="subject" value="${dto.subject}" class="form-control" required>
                </td>
            </tr>
            <tr>
                <th width="100" class="table-warning">사진</th>
                <td>
                    <input type="file" name="upload" id="upload" class="form-control">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <textarea name="content" required style="width: 100%; height: 150px;" placeholder="내용을 입력하세요">${dto.content}</textarea>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <button type="submit" class="btn btn-secondary" style="width: 100px;">수정</button>
                    <button type="button" class="btn btn-secondary" style="width: 100px;" onclick="history.back()">이전으로</button>
                </td>
            </tr>
        </table>
    </div>
    <br><br><b>사진을 선택하지 않으면 기존사진이 유지됩니다</b><br>
        <img src="${stpath}/${dto.uploadphoto}" id="showimg" onerror="this.src='../image/noimage1.png'">
</form>
</body>
</html>
