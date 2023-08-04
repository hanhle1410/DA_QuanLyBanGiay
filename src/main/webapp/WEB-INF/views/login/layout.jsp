<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Quản lý bán hàng tại quầy</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }
        header {
            background-color: #333;
            color: white;
            padding: 10px;
            text-align: center;
            font-size: 24px;
        }
        aside {
            background-color: #f1f1f1;
            padding: 10px;
            height: 100%;
            width: 200px;
            float: left;
        }
        section {
            padding: 10px;
            margin-left: 200px;
            height: 100%;
        }
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            text-align: left;
            padding: 8px;
            border-bottom: 1px solid #ddd;
        }
        tr:hover {
            background-color: #f5f5f5;
        }
        button {
            background-color: #4CAF50;
            color: white;
            padding: 8px 16px;
            border: none;
            cursor: pointer;
            border-radius: 4px;
            float: right;
        }
        button:hover {
            background-color: #3e8e41;
        }
        input[type=text] {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            box-sizing: border-box;
            border: 2px solid #ccc;
            border-radius: 4px;
            font-size: 16px;
        }
        input[type=submit] {
            background-color: #4CAF50;
            color: white;
            padding: 8px 16px;
            border: none;
            cursor: pointer;
            border-radius: 4px;
            float: right;
        }
        input[type=submit]:hover {
            background-color: #3e8e41;
        }
    </style>
</head>
<body>
<header>
    <h1>Quản lý bán hàng tại quầy</h1>
</header>
<aside>
    <h2>Chức năng</h2>
    <ul>
        <li><a href="#sanpham">Quản lý sản phẩm</a></li>
        <li><a href="#donhang">Quản lý đơn hàng</a></li>
        <li><a href="#khachhang">Quản lý khách hàng</a></li>
        <li><a href="#baocao">Báo cáo</a></li>
    </ul>
</aside>
<section>
    <h2 id="sanpham">Quản lý sản phẩm</h2>
    <button onclick="showForm('addProductForm')">Thêm sản phẩm</button>
    <br><br>
    <table>
        <tr>
            <th>Mã sản phẩm</th>
            <th>Tên sản phẩm</th>
            <th>Giá bán</th>
            <th>Số lượng</th>
            <th>Thao tác</th>
        </tr>
        <tr>
            <td>SP001</td>
            <td>Áo thun nam</td>
            <td>150,000 VND</td>
            <td>50</td>
            <td><button onclick="showForm('editProductForm')">Sửa</button> <button onclick="deleteProduct()">Xóa</button></td>
        </tr>
        <tr>
            <td>SP002</td>
            <td>Áo thun nữ</td>
            <td>120,000 VND</td>
            <td>30</td>
            <td><button onclick="showForm('editProductForm')">Sửa</button> <button onclick="deleteProduct()">Xóa</button></td>
        </tr>
    </table>
    <div id="addProductForm" style="display: none;">
        <h3>Thêm sản phẩm</h3>
        <form>
            <label for="productCode">Mã sản phẩm:</label>
            <input type="text" id="productCode" name="productCode"><br><br>
            <label for="productName">Tên sản phẩm:</label>
            <input type="text" id="productName" name="productName"><br><br>
            <label for="productPrice">Giá bán:</label>
            <input type="text" id="productPrice" name="productPrice"><br><br>
            <label for="productQuantity">Số lượng:</label>
            <input type="text" id="productQuantity" name="productQuantity"><br><br>
            <input type="submit" value="Thêm">
        </form>
    </div>
    <div id="editProductForm" style="display: none;">
        <h3>Sửa sản phẩm</h3>
        <form>
            <label for="productCode">Mã sản phẩm:</label>
            <input type="text" id="productCode" name="productCode"><br><br>
            <label for="productName">Tên sản phẩm:</label>
            <input type="text" id="productName" name="productName"><br><br>
            <label for="productPrice">Giá bán:</label>
            <input type="text" id="productPrice" name="productPrice"><br><br>
            <label for="productQuantity">Số lượng:</label>
            <input type="text" id="productQuantity" name="productQuantity"><br><br>
            <input type="submit" value="Lưu">
        </form>
    </div>
    <script>
        function showForm(formId) {
            var form = document.getElementById(formId);
            if (form.style.display === "none") {
                form.style.display = "block";
            } else {
                form.style.display = "none";
            }
        }
        function deleteProduct() {
            if (confirm("Bạn có chắc chắn muốn xóa sản phẩm này không?")) {
                // Code xóa sản phẩm ở đây
            }
        }
    </script>

    <h2 id="donhang">Quản lý đơn hàng</h2>
    <form>
        <label for="searchOrder">Tìm kiếm đơn hàng:</label>
        <input type="text" id="searchOrder" name="searchOrder">
        <input type="submit" value="Tìm kiếm">
    </form>
    <br>
    <table>
        <tr>
            <th>Mã đơn hàng</th>
            <th>Khách hàng</th>
            <th>Ngày đặt hàng</th>
            <th>Tổng tiền</th>
            <th>Trạng thái</th>
            <th>Thao tác</th>
        </tr>
        <tr>
            <td>DH001</td>
            <td>Nguyễn Văn A</td>
            <td>2023-07-30</td>
            <td>1,500,000 VND</td>
            <td>Đã thanh toán</td>
            <td><button onclick="showForm('editOrderForm')">Cập nhật trạng thái</button></td>
        </tr>
        <tr>
            <td>DH002</td>
            <td>Trần Thị B</td>
            <td>2023-07-29</td>
            <td>2,400,000 VND</td>
            <td>Chưa thanh toán</td>
            <td><button onclick="showForm('editOrderForm')">Cập nhật trạng thái</