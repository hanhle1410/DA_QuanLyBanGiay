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
    <li class="nav-item">
        <a class="nav-link" href="/san-pham/hien-thi">Sản phẩm</a>
    </li>
</ul>
<div class="col-8 offset-2">
    <form method="post" action="/nha-san-xuat/add">
        <div class="row mt-3">
            <h2>Nhà sản xuất</h2>
            <div class="col-6">
                <label>Id</label>
                <input type="text" name="id" class="form-control" value="${ nsx.id }" disabled/>
            </div>
            <div class="col-6">
                <label>Mã</label>
                <input type="text" name="ma" class="form-control" value="${nsx.ma}" required pattern="\S+.*"/>
            </div>
        </div>

        <div class="row mt-3">
            <div class="col-6">
                <label>Tên sản phẩm</label>
                <input type="text" name="ten" class="form-control" value="${nsx.ten}" required pattern="\S+.*"/>
            </div>
            <div class="col-6">
                <label>Địa chỉ</label>
                <input type="text" name="diaChi" class="form-control" value="${nsx.diaChi}" required pattern="\S+.*"/>
            </div>
        </div>

        <div class="row mt-3">
            <div class="col-6">
                <button class="btn btn-primary">Add</button>
            </div>
            <div class="col-6">
                <a class="btn btn-primary" href="/nha-san-xuat/clear">Clear</a>
            </div>
        </div>
    </form>
</div>

<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th>#</th>
            <th>Mã</th>
            <th>Tên</th>
            <th>Địa chỉ</th>
            <th colspan="3">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listNSX}" var="nsx" varStatus="stt">
            <tr>
                <td>${stt.index + 1}</td>
                <td>${nsx.ma}</td>
                <td>${nsx.ten}</td>
                <td>${nsx.diaChi}</td>
                <td>
                    <a href="/nha-san-xuat/detail/${nsx.id}" class="btn btn-success">Detail</a>
                    <a href="/nha-san-xuat/delete/${nsx.id}" class="btn btn-secondary">Delete</a>
                    <a href="/nha-san-xuat/view-update/${nsx.id}" class="btn btn-primary">Update</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
