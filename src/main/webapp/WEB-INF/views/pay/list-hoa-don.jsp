<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table" border="1">
    <thead>
        <tr>
            <th>Mã</th>
            <th>Khách hàng</th>
            <th>Nhân viên</th>
            <th>Ngày tạo</th>
            <th>Ngày thanh toán</th>
            <th>Giảm giá</th>
            <th>Tổng tiền</th>
            <th>Trạng thái</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${hoaDonList}" var="hoaDon">
        <tr>
            <td>${hoaDon.ma}</td>
            <td>${hoaDon.idKH.ten}</td>
            <td>${hoaDon.idNV.ten}</td>
            <td>${hoaDon.ngayTao}</td>
            <td>${hoaDon.ngayThanhToan}</td>
            <td>${hoaDon.idVoucher.giamGia}</td>
            <td>${hoaDon.tongTien}</td>
            <td>${hoaDon.trangThai == 0 ? "Chưa thanh toán" : "Đã thanh toán"}</td>
            <td>
                <a class="btn btn-danger btn-sm" href="/hoa-don/remove/${hoaDon.id}">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>