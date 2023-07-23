<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách sản phẩm</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        .container {
            max-width: 800px;
            margin: 0 auto;
        }

        .product-frame {
            display: inline-block;
            width: 30%;
            margin-right: 2%;
            margin-bottom: 20px;
            background-color: #f5f5f5;
            border: 1px solid #ddd;
            padding: 20px;
            box-sizing: border-box;
        }

        .product-frame:last-child {
            margin-right: 0;
        }

        .product-frame h3 {
            margin: 0;
            font-size: 18px;
            font-weight: bold;
            text-align: center;
        }

        .product-frame img {
            display: block;
            margin: 0 auto 10px;
            max-width: 100%;
            height: auto;
        }

        .product-frame p {
            margin: 0;
            font-size: 14px;
            text-align: center;
        }

        .product-frame .old-price {
            text-decoration: line-through;
            color: #999;
        }

        .product-frame .new-price {
            font-weight: bold;
            font-size: 18px;
            color: #f00;
        }

        .product-frame a {
            display: block;
            text-align: center;
            color: white;
            text-decoration: none;
            margin-top: 10px;
        }

        .product-frame a:hover {
            text-decoration: underline;
        }

    </style>
</head>
<body>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

...

<div class="container">
    <h1 class="my-4">Danh sách sản phẩm</h1>
    <div class="product-list">
        <c:forEach items="${sanPhamList}" var="sanPham">
            <div class="product-frame">
                <h3>${sanPham.idDongSP.ten}</h3>
                <img src="https://png.pngtree.com/png-vector/20201128/ourlarge/pngtree-casual-shoes-png-image_2394294.jpg"> <!-- Add the image source here -->
                <p>Chất liệu: ${sanPham.idDeGiay.chatLieu}</p>
                <p>Nhà sản xuất: ${sanPham.idNSX.ten}</p>
                <p class="new-price">Giá bán: ${sanPham.giaBan}</p>
                <table>
                    <c:forEach items="${sanPham.chiTietSPList}" var="chiTietSP">
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
                <a class="btn btn-primary" href="/product/views/${sanPham.id}">Mua ngay</a>
            </div>
        </c:forEach>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>

</body>
</html>