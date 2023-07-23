<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chi tiết sản phẩm</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <style>
        .container {
            max-width: 600px;
            margin: 0 auto;
        }

        .product-details {
            padding: 20px;
            background-color: #f5f5f5;
            border: 1px solid #ddd;
            margin-bottom: 20px;
        }

        .product-details h1 {
            font-size: 24px;
            font-weight: bold;
            margin-bottom: 20px;
        }

        .product-details table {
            width: 100%;
            margin-bottom: 20px;
        }

        .product-details td {
            padding: 10px;
            border: none;
        }

        .product-details td:first-child {
            font-weight: bold;
            width: 30%;
        }

        .product-details .btn {
            background-color: #0077cc;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 20px;
            transition: background-color 0.3s ease-in-out, color 0.3s ease-in-out;
        }

        .product-details .btn:hover {
            background-color: #fff;
            color: #0077cc;
        }

        .table-responsive {
            overflow-x: auto;
        }
    </style>

</head>
<body>

<div class="container">
    <div class="product-details">
        <h1>${sanPham.idDongSP.ten}</h1>
        <table>
            <tr>
                <td>Chất liệu:</td>
                <td>${sanPham.idDeGiay.chatLieu}</td>
            </tr>
            <tr>
                <td>Nhà sản xuất:</td>
                <td>${sanPham.idNSX.ten}</td>
            </tr>
            <tr>
                <td>Giá:</td>
                <td>${sanPham.giaBan}</td>
            </tr>
        </table>
        <table>
            <c:forEach items="${chiTietSPList}" var="chiTietSP">
            <tr>
                <td>Màu sắc:</td>
                <td>${chiTietSP.idMauSP.mau}</td>
            </tr>
            <tr>
                <td>Kích cỡ:</td>
                <td>${chiTietSP.idKichCo.coGiay}</td>
            </tr>
            <tr>
                <td>Số lượng:</td>
                <td>${chiTietSP.soLuong}</td>
            </tr>
            <tr>
                <td>
                    <a class="btn" href="/shopping-cart/add/${chiTietSP.id}">ADD TO CART</a>
                </td>
            </tr>
            </c:forEach>
        </table>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>

</body>
</html>