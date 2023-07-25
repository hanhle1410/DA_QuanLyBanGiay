<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Thanh toán hóa đơn</title>
    <style>
        table { border-collapse: collapse; width: 100%; }
        th, td { border: 1px solid black; padding: 8px; text-align: left; }
        th { background-color: #ddd; }
        h1, h2 { text-align: center; }
        form { text-align: center; }
        input[type=submit] {
            background-color: #4CAF50;
            border: none; color: white;
            padding: 12px 28px;
            text-decoration: none;
            display: inline-block;
            font-size: 16px; margin: 4px 2px;
            cursor: pointer; }
    </style>
</head>
<body>
<h1>Thông tin hóa đơn</h1>
<table>
    <tr>
        <td><strong>Mã hóa đơn:</strong></td>
        <td><c:out value="${hoaDon.ma}" /></td>
    </tr>
    <tr>
        <td><strong>Khách hàng:</strong></td>
        <td><c:out value="${hoaDon.idKH.ten}" /></td>
    </tr>
    <tr>
        <td><strong>Nhân viên:</strong></td>
        <td><c:out value="${hoaDon.idNV.ten}" /></td>
    </tr>
    <tr>
        <td><strong>Ngày tạo:</strong></td>
        <td><c:out value="${hoaDon.ngayTao}" /></td>
    </tr>
    <tr>
        <td><strong>Tổng tiền:</strong></td>
        <td><c:out value="${hoaDon.tongTien}" /></td>
    </tr>
</table>

<h2>Chi tiết hóa đơn</h2>

<table>
    <tr>
        <th>Sản phẩm</th>
        <th>Số lượng</th>
        <th>Đơn giá</th>
        <th>Thành tiền</th>
    </tr>
    <c:forEach items="${ hoaDon.hoaDonCTList }" var="hoaDonCT">
        <tr>
            <td><c:out value="${hoaDonCT.idSP.ten}" /></td>
            <td><c:out value="${hoaDonCT.soLuong}" /></td>
            <td><c:out value="${hoaDonCT.donGia}" /></td>
            <td><c:out value="${hoaDonCT.soLuong * hoaDonCT.donGia}" /></td>
        </tr>
    </c:forEach>
</table>

<form action="thanh-toan" method="post">
    <input type="hidden" name="hoaDonId" value="${hoaDon.id}" />
    <input type="submit" value="Thanh toán" />
</form>
</body>
</html>