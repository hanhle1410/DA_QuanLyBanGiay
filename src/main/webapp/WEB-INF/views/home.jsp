<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>

<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../css/home.css">
    <style>
        /* Reset default margin and padding */
        body, h1, h2, h3, p, ul, li {
            margin: 0;
            padding: 0;
        }

        /* Set font and background color */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
        }

        /* Header styles */
        header {
            background-color: #333;
            color: white;
            padding: 20px;
            text-align: center;
        }

        /* Navigation styles */
        nav ul {
            list-style-type: none;
            display: flex;
            justify-content: center;
            background-color: #555;
            padding: 10px 0;
        }

        nav ul li {
            margin: 0 15px;
        }

        nav ul li a {
            text-decoration: none;
            color: white;
            padding: 5px 10px;
            border-radius: 5px;
            transition: background-color 0.3s;
        }

        nav ul li a:hover {
            background-color: #777;
            color: white;
        }
        /* End css home */


    </style>
</head>

<body>

<nav>
    <ul>
        <li><a href="../home"><i class="fas fa-home"></i> Trang chủ</a></li>
        <li><a href="#"><i class="fas fa-box-open"></i> Sản phẩm</a></li>
        <li><a href="../shopping-cart/views"><i class="fas fa-shopping-cart"></i> Bán Hàng</a></li>
        <li><a href="#"><i class="fas fa-users-cog"></i> Nhân Viên</a></li>
        <li><a href="#"><i class="fas fa-user-friends"></i> Khách Hàng</a></li>
        <li><a href="../hoa-don/views"><i class="fas fa-receipt"></i> Hóa Đơn</a></li>
        <li><a href="#"><i class="fas fa-chart-bar"></i> Thống Kê</a></li>
        <li><a href="#"><i class="fas fa-percent"></i> Khuyến Mãi</a></li>
        <li><a href="../login"><i class="fas fa-sign-out-alt"></i> Đăng Xuất</a></li>
        <li><a href="#"><i class="fas fa-user-circle"></i></a></li>
    </ul>
</nav>

<div class="container">

    <div class="bg-light ">
        <jsp:include page="${view}" />
    </div>

</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
