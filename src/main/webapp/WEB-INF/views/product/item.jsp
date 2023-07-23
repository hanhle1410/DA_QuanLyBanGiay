<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<table>
    <thead>
    <tr>
        <th>Dòng sản phẩm</th>
        <th>Chất liệu</th>
        <th>Nhà sản xuất</th>
        <th>Màu</th>
        <th>Cỡ giày</th>
        <th>Đơn giá</th>
        <th>Số lượng</th>
        <th colspan="2">Thao tác</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${ chiTietSPList }" var="l">
        <tr>
            <td>${l.idSP.idDongSP.ten}</td>
            <td>${l.idSP.idDeGiay.chatLieu} </td>
            <td> ${l.idSP.idNSX.ten}</td>
            <td>${l.idMauSP.mau} </td>
            <td>${l.idKichCo.coGiay} </td>
            <td> ${l.idSP.giaBan}</td>
            <td> ${l.soLuong}</td>
            <td>
                <a class="btn" href="/shopping-cart/add/${l.id}">ADD TO CART</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

