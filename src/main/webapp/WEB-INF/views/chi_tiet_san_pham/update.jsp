<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Chi tiết sản phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="col-8 offset-2">
    <form method="post" action="/chi-tiet-san-pham/update?id=${ctsp.id}">
        <div class="row mt-3">
            <h2>Thông tin chi tiết sản phẩm</h2>
            <div class="col-6">
                <label>Sản phẩm</label>
                <select name="idSP" class="form-select">
                    <c:forEach items="${listSP}" var="sp">
                        <option value="${sp.id}" ${sp.id == ctsp.idSP.id ? "selected" : ""}>${sp.id}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-6">
                <label>Màu sản phẩm</label>
                <select name="idMauSP" class="form-select">
                    <c:forEach items="${listMS}" var="ms">
                        <option value="${ms.id}" ${ms.id == ctsp.idMauSP.id ? "selected" : ""}>${ms.mau}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="row mt-3">
            <div class="col-6">
                <label>Kích cỡ</label>
                <select name="idKichCo" class="form-select">
                    <c:forEach items="${listKC}" var="kc">
                        <option value="${kc.id}" ${kc.id == ctsp.idKichCo.id ? "selected" : ""}>${kc.coGiay}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-6">
                <label>Số lượng</label>
                <input type="number" name="soLuong" class="form-control" value="${ctsp.soLuong}" required/>
            </div>
        </div>

        <div class="row mt-3">
            <div class="col-6">
                <button class="btn btn-primary">Update</button>
            </div>
            <div class="col-6"></div>
        </div>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>