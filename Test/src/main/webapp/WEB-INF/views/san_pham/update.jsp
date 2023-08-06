<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Sản phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="col-8 offset-2">
    <form method="post" action="/san-pham/update?id=${sp.id}">
        <h2>Thông tin sản phẩm</h2>
        <div class="row mt-3">
            <div class="col-6">
                <label>Dòng sản phẩm</label>
                <select name="idDongSP" class="form-select">
                    <c:forEach items="${listDSP}" var="dsp">
                        <option value="${dsp.id}" ${dsp.id == sp.idDongSP.id ? "selected" : ""}>${dsp.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-6">
                <label>Đế giày</label>
                <select name="idDeGiay" class="form-select">
                    <c:forEach items="${listDG}" var="dg">
                        <option value="${dg.id}" ${dg.id == sp.idDeGiay.id ? "selected" : ""}>${dg.chatLieu}</option>
                    </c:forEach>
                </select>
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
            </div>
            <div class="col-6">
                <label>Ngày nhập</label>
                <input type="date" name="ngayNhapHang" class="form-control" value="${sp.ngayNhapHang}" required/>
            </div>
        </div>

        <div class="row mt-3">
            <div class="col-6">
                <label>Giá nhập</label>
                <input type="number" name="giaNhap" class="form-control" value="${sp.giaNhap}" required/>
            </div>
            <div class="col-6">
                <label>Giá bán</label>
                <input type="number" name="giaBan" class="form-control" value="${sp.giaBan}" required/>
            </div>
        </div>

        <div class="row mt-3">
            <div class="col-6">
                <label>Xuất xứ</label>
                <input type="text" name="xuatXu" class="form-control" value="${sp.xuatXu}" required/>
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
                <button class="btn btn-primary">Update</button>
            </div>
        </div>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>