<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>게시물 상세보기</title>
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

        div.a {
            margin-left: 250px;
        }

        #tab {
            border: 3px solid #34e1ff;
            border-collapse: separate;
            border-radius: 20px;
            overflow: hidden;
        }

        pre.adata {
            margin-left: 10px;
            color: gray;
        }

        span.aday {
            margin-left: 300px;
            font-size: 0.9em;
            color: gray;
        }
        i.adel{
            cursor: pointer;
        }


    </style>
    <c:set var="stpath" value="https://kr.object.ncloudstorage.com/bitcamp-bucket-56/photocommon"/>

    <script type="text/javascript">
        $(function () {
            //처음 로딩시 댓글 목록 출력
            answer_list();

            //댓글 추가 버튼
            $("#btnansweradd").click(function () {
                let num =${dto.num};
                let content = $("#acontent").val();
                if (content == '') {
                    alert("댓글을 입력후 등록해주세요");
                    return;
                }

                $.ajax({
                    type: "post",
                    dataType: "text",
                    url: "./ainsert",
                    data: {"num": num, "content": content},
                    success: function () {
                        //댓글 목록 다시 출력
                        answer_list();
                        //초기화
                        $("#acontent").val("");
                    }
                });
            });

            //댓글 삭제 이벤트
            $(document).on("click", ".adel", function () {

                let aidx = $(this).attr("aidx");
                let a = confirm("해당 댓글을 삭제할까요?");

                if (a) {
                    $.ajax({
                        type: "get",
                        dataType: "text",
                        data: {"aidx": aidx},
                        url: "./adelete",
                        success: function () {
                            //댓글 목록 다시 출력
                            answer_list();
                        }
                    });
                }
            });
        });


        function answer_list() {
            let num = ${dto.num};

            //로그인중인지 로그인중일경우 로그인 아이디 얻기
            let loginok = '${sessionScope.loginok}';
            let loginid = '${sessionScope.loginid}';

            $.ajax({
                type: "get",
                dataType: "json",
                data: {"num": num,},
                url: "./alist",
                success: function (data) {
                    //댓글 개수 출력
                    $(".answercount").text(data.length);

                    //목록출력
                    let s = "";
                    $.each(data, function (idx, ele) {


                        s +=
                            `
                        \${ele.writer}(\${ele.myid})
                        <span class="aday">\${ele.writeday}</span>
                        `;

                        if (loginok == 'yes' && loginid == ele.myid) {

                            s += `
                                <i class="bi bi-trash adel" aidx = "\${ele.aidx}"></i>
                                 `;
                        }

                        s += `
                            <br>
                            <pre class="adata">\${ele.content}</pre>
                            <hr>
                            `;

                    });
                    $(".answerlist").html(s);

                }
            });
        }

    </script>
</head>
<body>
<div class="a">
    <table id="tab" class="table" style="width: 600px; height: auto;">
        <tr>
            <td style="height: 70px; line-height: 70px; margin-right: 30px;">

                <img src="${stpath}/${profile_photo}" onerror="this.src='../image/noimage1.png'"
                     style="width: 45px; height: 45px; margin-right: 10px;" class="rounded-circle" align="left">
                <h2>${dto.subject}</h2>
            </td>
        </tr>
        <tr>
            <td style="height: 30px; font-size: 15px;">작성자 : ${dto.writer}</td>
        </tr>
        <tr>
            <td style="height: 30px; color: gray; font-size: 15px;">
                <fmt:formatDate value="${dto.writeday}" pattern="yyyy.MM.dd HH:mm"/>
                &nbsp;&nbsp;조회&nbsp;${dto.readcount}
                <span style="float: right;color: gray;">
			  	<i class="bi bi-chat-dots"></i>
			  	댓글<span class="answercount">0</span>
			  </span>
            </td>
        </tr>
        <tr>
            <td style="vertical-align: top; font-size: 22px; height: 300px;">
                <c:if test="${dto.uploadphoto!='no'}">
                <img src="../save/${dto.uploadphoto}"
                     onerror="this.src='../image/noimage1.png'"
                     style="max-width: 300px;">
                <br><br>
                </c:if>
                <pre style="font-size: 17px;">${dto.content}</pre>
        </tr>
        <tr align="center">
            <td style="background-color: #b6fcfc">댓글</td>
        </tr>
        <tr>
            <td>
                <!-- 댓글 출력할 영역 -->
                <div class="answerlist">

                </div>
            </td>
        </tr>
        <c:if test="${sessionScope.loginok != null}">
            <tr>
                <td style="height: 100px;">
                    <b>댓글 달기</b><br>
                    <textarea style="width: 80%; height: 80px;" id="acontent"></textarea>
                    <button type="button" id="btnansweradd" class="btn btn-outline-success" style="margin-left: 20px;">
                        등록
                    </button>
                </td>
            </tr>
        </c:if>

        <tr>
            <td style="height: 30px;" align="center">
                <button type="button" class="btn btn-sm btn-success" onclick="location.href='./form'">
                    <i class="bi bi-pencil-fill"></i>글쓰기
                </button>
                <!-- 답글 -->
                <button type="button" class="btn btn-sm btn-outline-success"
                        onclick="location.href='./form?num=${dto.num}&regroup=${dto.regroup}&restep=${dto.restep}$relevel=${dto.relevel}&currentPage=${currentPage}'">
                    답글
                </button>
                <c:if test="${sessionScope.loginok != null and sessionScope.loginid ==dto.myid}">
                    <button type="button" class="btn btn-sm btn-warning"
                            onclick="location.href='./updateform?num=${dto.num}&currentPage=${currentPage}'">수정
                    </button>
                    <button type="button" class="btn btn-sm btn-danger" onclick="del()">삭제</button>
                </c:if>
                <button type="button" class="btn btn-sm btn-outline-secondary"
                        onclick="location.href='./list?currentPage=${currentPage}'">목록
                </button>
            </td>
        </tr>
    </table>
</div>
<script type="text/javascript">
    function del() {
        let num = ${dto.num};
        let currentPage = ${currentPage};

        let a = confirm("정말 삭제하시겠습니까?");
        if (a) {
            location.href = "./delete?num=" + num + "&currentPage=" + currentPage;
        }
    }
</script>


</body>
</html>
