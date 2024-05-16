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
        figure.mycar{
            float: left;
            margin: 10px;
        }
        figure.mycar img{

        }

    </style>

</head>
<!--
    Ajax
    비 동기방식의 자바스크립트와 XML (Asynchronous JavaScript and XML)
-->
<body>
<div style="margin: 10px">
    <button type="button" class="btn btn-sm btn-success" id="btn1">xml 데이타 읽기(1개)</button>
    <button type="button" class="btn btn-sm btn-success" id="btn2">json 데이타 읽기(1개)</button>
    <br><br>
    <button type="button" class="btn btn-sm btn-success" id="btn3">xml 데이타 읽기(여러개)</button>
    <button type="button" class="btn btn-sm btn-success" id="btn4">json 데이타 읽기(여러개)</button>
    <hr>
    <div class="result" style="white-space: pre-line;">
        <script type="text/javascript">
            $("#btn1").click(function (){
                $.ajax({
                    type:"get",
                    url:"../data/data1.xml",
                    dataType:"xml",
                    success:function (data){
                        let name = $(data).find("name").text();
                        let no = $(data).find("name").attr("no");
                        let color = $(data).find("name").attr("color");
                        let addr = $(data).find("addr").text();
                        let age = $(data).find("age").text();

                        let s = `
                                   번호 : \${no}
                                   이름 : \${name}
                                   주소 : \${addr}
                                   나이 : \${age}
                                `;
                        $("div.result").html(s).css("background-color",color);
                    },
                    statusCode:{
                        404:function (){
                            alert("xml 파일을 찾을 수 없어요!")
                        },
                        500:function (){
                            alert("서버오류 : 코드를 다시 한번 보세요")
                        }
                    }
                });
            });
            $("#btn2").click(function (){
                $.ajax({
                    type: "get",
                    url: "../data/data2.json",
                    dataType: "json",
                    success:function (data){
                        let s = `
                                이름 : \${data.name}
                                주소 : \${data.addr}
                                핸드폰 : \${data.hp}
                        `;
                        $("div.result").html(s).css("background-color","lightgray");
                    }
                });
            });
            $("#btn3").click(function (){
                $.ajax({
                    type:"get",
                    url:"../data/data3.xml",
                    dataType:"xml",
                    success:function (data){
                        $("div.result").empty();
                        $(data).find("mycar").each(function (idx,ele){
                            let title = $(ele).find("title").text();
                            let photo = $(ele).find("photo").text();
                            let s = `
                                <figure class="mycar">
                                    <img src="\${photo}">
                                    <figcaption>\${title}</fircaption>
                                </figure>
                            `;
                            $("div.result").append(s);
                        });
                    }
                });
            });
            $("#btn4").click(function (){
                $("div.result").empty().css("background-color","white");

                $.ajax({
                    type:"get",
                    dataType:"json",
                    success:function (data){

                        $.each(data,function (idx,ele){
                            let s = `
                                <img src="\${ele.photo}" width=130>
                                이름 : \${ele.name}
                                나이 : \${ele.age}
                                <hr>
                            `;
                                $("div.result").append(s);
                        });
                    }
                })

            });

        </script>

    </div>
</div>
</body>
</html>
