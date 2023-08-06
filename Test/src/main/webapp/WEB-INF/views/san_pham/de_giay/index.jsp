<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Sản phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<a href="/san-pham/hien-thi" class="btn btn-primary"><-</a>
<div class="col-8 offset-2">
    <form method="post" action="/de-giay/add">
        <div class="row mt-3">
            <h2>Dòng sản phẩm</h2>
            <div class="col-6">
                <label>Id</label>
                <input type="text" name="id" class="form-control" value="${ dg.id }" disabled/>
            </div>
            <div class="col-6">
                <label>Chất liệu</label>
                <input type="text" name="chatLieu" class="form-control" value="${dg.chatLieu}" required pattern="\S+.*"/>
            </div>
        </div>

        <div class="row mt-3">
            <div class="col-6">
                <button class="btn btn-primary">Add</button>
            </div>
            <div class="col-6">
                <a class="btn btn-primary" href="/de-giay/clear">Clear</a>
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
        <c:forEach items="${listDG}" var="dg" varStatus="stt">
            <tr>
                <td>${stt.index + 1}</td>
                <td>${dg.chatLieu}</td>
                <td>
                    <a href="/de-giay/detail/${dg.id}" class="btn btn-success">Detail</a>
                    <a href="/de-giay/delete/${dg.id}" class="btn btn-secondary">Delete</a>
                    <a href="/de-giay/view-update/${dg.id}" class="btn btn-primary">Update</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
