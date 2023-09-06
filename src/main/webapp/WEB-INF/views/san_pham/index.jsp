<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Sản phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<ul class="nav nav-tabs">
    <li class="nav-item">
        <a class="nav-link active" href="/chi-tiet-san-pham/hien-thi">Chi tiết sản phẩm</a>
    </li>
</ul>
<br>
<div class="col-8 offset-2">
    <form method="post" action="/san-pham/add">
        <h2>Sản phẩm</h2>
        <div class="row mt-3">
            <div class="col-6">
                <label>Dòng sản phẩm</label>
                <select name="idDongSP" class="form-select">
                    <c:forEach items="${listDSP}" var="dsp">
                        <option value="${dsp.id}" ${dsp.id == sp.idDongSP.id ? "selected" : ""}>${dsp.ten}</option>
                    </c:forEach>
                </select>
                <div>
                    <a href="/san-pham/view-dong-sp" class="btn">+</a>
                </div>
            </div>

            <div class="col-6">
                <label>Đế giày</label>
                <select name="idDeGiay" class="form-select">
                    <c:forEach items="${listDG}" var="dg">
                        <option value="${dg.id}" ${dg.id == sp.idDeGiay.id ? "selected" : ""}>${dg.chatLieu}</option>
                    </c:forEach>
                </select>
                <div>
                    <a href="/san-pham/view-de-giay" class="btn">+</a>
                </div>
            </div>
        </div>

        <div class="row mt-3">
            <div class="col-6">
                <label>Nhà sản xuất</label>
                <select name="idNhaSX" class="form-select">
                    <c:forEach items="${listNSX}" var="nsx">
                        <option value="${nsx.id}" ${nsx.id == sp.idNhaSX.id ? "selected" : ""}>${nsx.ten}</option>
                    </c:forEach>
                </select>
                <div>
                    <a href="/san-pham/view-nha-san-xuat" class="btn">+</a>
                </div>
            </div>
            <div class="col-6">
                <label>Ngày nhập</label>
                <input type="date" name="ngayNhapHang" class="form-control" value="${sp.ngayNhapHang}" required pattern="\S+.*"/>
            </div>
        </div>

        <div class="row mt-3">
            <div class="col-6">
                <label>Giá nhập</label>
                <input type="number" name="giaNhap" class="form-control" value="${sp.giaNhap}" required pattern="\S+.*"/>
            </div>
            <div class="col-6">
                <label>Giá bán</label>
                <input type="number" name="giaBan" class="form-control" value="${sp.giaBan}" required pattern="\S+.*"/>
            </div>
        </div>

        <div class="row mt-3">
            <div class="col-6">
                <label>Xuất xứ</label>
                <input type="text" name="xuatXu" class="form-control" value="${sp.xuatXu}" required pattern="\S+.*"/>
            </div>
            <div class="col-6">
                <label>Trạng thái</label>
                <div class="form-check">
                    <input type="radio" class="form-check-input" name="trangThai" value="0" ${sp.trangThai == "0" ? "checked" : ""} checked>Hết hàng
                    <label class="form-check-label"></label>
                </div>
                <div class="form-check">
                    <input type="radio" class="form-check-input" name="trangThai" value="1" ${sp.trangThai == "1" ? "checked" : ""}>Còn sản phẩm
                    <label class="form-check-label"></label>
                </div>
            </div>
        </div>

        <div class="row mt-3">
            <div class="col-6">
                <button class="btn btn-primary">Add</button>
            </div>
            <div class="col-6">
                <a class="btn btn-primary" href="/san-pham/clear">Clear</a>
            </div>
        </div>
    </form>
</div>

<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th>#</th>
            <th>Dòng sản phẩm</th>
            <th>Đế giày</th>
            <th>Nhà sản xuất</th>
            <th>Ngày nhập</th>
            <th>Giá nhập</th>
            <th>Giá bán</th>
            <th>Xuất xứ</th>
            <th>Trạng thái</th>
            <th colspan="3">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listSP}" var="sp" varStatus="stt">
            <tr>
                <td>${stt.index + 1}</td>
                <td>${sp.idDongSP.ten}</td>
                <td>${sp.idDeGiay.chatLieu}</td>
                <td>${sp.idNhaSX.ten}</td>
                <td>${sp.ngayNhapHang}</td>
                <td>${sp.giaNhap}</td>
                <td>${sp.giaBan}</td>
                <td>${sp.xuatXu}</td>
                <td>${sp.trangThai}</td>
                <td>
                    <a href="/san-pham/detail/${sp.id}" class="btn btn-success">Detail</a>
                    <a href="/san-pham/delete/${sp.id}" class="btn btn-secondary">Delete</a>
                    <a href="/san-pham/view-update/${sp.id}" class="btn btn-primary">Update</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
