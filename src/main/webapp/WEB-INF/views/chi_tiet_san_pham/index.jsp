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
    <form method="post" action="/chi-tiet-san-pham/add">
        <div class="row mt-3">
            <h2>Chi tiết sản phẩm</h2>
            <div class="col-6">
                <label>Sản phẩm</label>
                <select name="idSP" class="form-select">
                    <c:forEach items="${listSP}" var="sp">
                        <option value="${sp.id}" ${sp.id == ctsp.idSP.id ? "selected" : ""}>${sp.id}</option>
                    </c:forEach>
                </select>
                <a href="/chi-tiet-san-pham/view-san-pham" class="btn">+</a>
            </div>
            <div class="col-6">
                <label>Màu sản phẩm</label>
                <select name="idMauSP" class="form-select">
                    <c:forEach items="${listMS}" var="ms">
                        <option value="${ms.id}" ${ms.id == ctsp.idMauSP.id ? "selected" : ""}>${ms.mau}</option>
                    </c:forEach>
                </select>
                <a href="/chi-tiet-san-pham/view-mau-sac" class="btn">+</a>
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
                <a href="/chi-tiet-san-pham/view-kich-co" class="btn">+</a>
            </div>
            <div class="col-6">
                <label>Số lượng</label>
                <input type="number" name="soLuong" class="form-control" value="${ctsp.soLuong}" required/>
            </div>
        </div>

        <div class="row mt-3">
            <div class="col-6">
                <button class="btn btn-primary">Add</button>
            </div>
            <div class="col-6">
                <a class="btn btn-primary" href="/chi-tiet-san-pham/clear">Clear</a>
            </div>
        </div>
    </form>
</div>


<div class="container">
    <table class="table">
        <h2>Thông tin sản phẩm</h2>
        <thead>
        <tr>
            <th>#</th>
            <th>Sản phẩm</th>
            <th>Màu sản phẩm</th>
            <th>Kích cỡ</th>
            <th>Số lượng</th>
            <th colspan="3">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listCTSP}" var="ctsp" varStatus="stt">
            <tr>
                <td>${stt.index + 1}</td>
                <td>${ctsp.idSP.id}</td>
                <td>${ctsp.idMauSP.mau}</td>
                <td>${ctsp.idKichCo.coGiay}</td>
                <td>${ctsp.soLuong}</td>
                <td>
                    <a href="/chi-tiet-san-pham/detail/${ctsp.id}" class="btn btn-success">Detail</a>
                    <a href="/chi-tiet-san-pham/delete/${ctsp.id}" class="btn btn-secondary">Delete</a>
                    <a href="/chi-tiet-san-pham/view-update/${ctsp.id}" class="btn btn-primary">Update</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
