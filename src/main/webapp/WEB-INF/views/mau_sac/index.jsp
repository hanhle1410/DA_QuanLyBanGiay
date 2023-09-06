<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Màu sắc</title>
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
    <form method="post" action="/mau-sac/add">
        <div class="row mt-3">
            <h2>Màu sắc</h2>
            <div class="col-6">
                <label>Mã</label>
                <input type="text" name="ma" class="form-control" value="${ms.ma}" required pattern="\S+.*"/>
            </div>
            <div class="col-6">
                <label>Màu sắc</label>
                <input type="text" name="mau" class="form-control" value="${ms.mau}" required pattern="\S+.*"/>
            </div>
        </div>

        <div class="row mt-3">
            <div class="col-6">
                <button class="btn btn-primary">Add</button>
            </div>
            <div class="col-6">
                <a class="btn btn-primary" href="/mau-sac/clear">Clear</a>
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
            <th>Màu sắc</th>
            <th colspan="3">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listMS}" var="ms" varStatus="stt">
            <tr>
                <td>${stt.index + 1}</td>
                <td>${ms.ma}</td>
                <td>${ms.mau}</td>
                <td>
                    <a href="/mau-sac/detail/${ms.id}" class="btn btn-success">Detail</a>
                    <a href="/mau-sac/delete/${ms.id}" class="btn btn-secondary">Delete</a>
                    <a href="/mau-sac/view-update/${ms.id}" class="btn btn-primary">Update</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
