<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        body {
            font-family: "Lato", sans-serif;
        }

        .sidepanel {
            width: 0;
            position: fixed;
            z-index: 1;
            height: 1000px;
            top: 0;
            left: 0;
            background-color: white;
            overflow-x: hidden;
            transition: 0.5s;
            padding-top: 60px;
        }

        .sidepanel a {
            padding: 8px 8px 8px 32px;
            text-decoration: none;
            font-size: 15px;
            color: #111111;
            display: block;
            transition: 0.3s;
        }

        .sidepanel a:hover {
            color: black;
            background-color: white;
        }

        .sidepanel .closebtn {
            position: absolute;
            top: 0;
            right: 25px;
            font-size: 20px;
        }

        .openbtn {
            font-size: 20px;
            cursor: pointer;
            background-color: #ffffff;
            color: black;
            padding: 10px 15px;
            border: none;
        }

        .openbtn:hover {
            background-color: #444;
        }

        table {
            border-collapse: collapse;
            border-spacing: 0;
            width: 100%;
            border: 1px solid #ddd;
        }

        th, td {
            text-align: left;
            padding: 16px;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        .errors{
            color: red;
        }
    </style>
</head>
<body>

<nav class="navbar navbar-inverse" style="margin-bottom: 0px">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Quản lý bán giày</a>
        </div>
    </div>
</nav>

<div class="row mt-10">
    <div class="col-2 ">
        <div id="mySidepanel" class="sidepanel">
            <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">×</a>
            <a href="">Nhân Viên</a>
            <a href="">Khách Hàng</a>
            <a href="/chi-tiet-san-pham/hien-thi">Sản phẩm</a>
            <a href="">Hoá đơn chi tiết</a>
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">Quản lý sản phẩm <span class="caret"></span></a>
<%--            <ul class="dropdown-menu">--%>
<%--                <li><a href="/chi-tiet-san-pham/hien-thi">Sản phẩm</a></li>--%>
<%--                <li><a href="">Nhà sản xuất</a></li>--%>
<%--                <li><a href="">Màu sắc</a></li>--%>
<%--                <li><a href="">Dòng sản phẩm</a></li>--%>
<%--            </ul>--%>
        </div>
        <button class="openbtn" onclick="openNav()">☰ Menu</button>
    </div>

    <div class="col-10">
        <jsp:include page="${ view }"/>
    </div>

</div>

<script>
    function openNav() {
        document.getElementById("mySidepanel").style.width = "190px";
    }

    function closeNav() {
        document.getElementById("mySidepanel").style.width = "0";
    }
</script>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
