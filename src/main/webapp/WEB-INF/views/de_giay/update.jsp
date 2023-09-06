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
    <form method="post" action="/de-giay/update?id=${dg.id}">
        <div class="row mt-3">
            <h2>Đế giày</h2>
            <div class="col-6">
                <label>Id</label>
                <input type="text" name="id" class="form-control" value="${ dg.id }" disabled/>
            </div>
            <div class="col-6">
                <label>Chất liệu</label>
                <input type="text" name="chatLieu" class="form-control" value="${ dg.chatLieu }" required/>
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