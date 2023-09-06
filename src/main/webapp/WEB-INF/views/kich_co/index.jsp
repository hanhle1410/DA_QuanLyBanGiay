<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Kích cỡ</title>
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
    <form method="post" action="/kich-co/add">
        <div class="row mt-3">
            <h2>Kích cỡ</h2>
            <div class="col-6">
                <label>Id</label>
                <input type="text" name="id" class="form-control" value="${ kc.id }" disabled/>
            </div>
            <div class="col-6">
                <label>Cỡ giày</label>
                <input type="text" name="coGiay" class="form-control" value="${kc.coGiay}" required pattern="\S+.*"/>
            </div>
        </div>

        <div class="row mt-3">
            <div class="col-6">
                <button class="btn btn-primary">Add</button>
            </div>
            <div class="col-6">
                <a class="btn btn-primary" href="/kich-co/clear">Clear</a>
            </div>
        </div>
    </form>
</div>

<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th>#</th>
            <th>Chất liệu</th>
            <th colspan="3">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listKC}" var="kc" varStatus="stt">
            <tr>
                <td>${stt.index + 1}</td>
                <td>${kc.coGiay}</td>
                <td>
                    <a href="/kich-co/detail/${kc.id}" class="btn btn-success">Detail</a>
                    <a href="/kich-co/delete/${kc.id}" class="btn btn-secondary">Delete</a>
                    <a href="/kich-co/view-update/${kc.id}" class="btn btn-primary">Update</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
