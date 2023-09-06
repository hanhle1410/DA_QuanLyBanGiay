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
    <form method="post" action="/dong-san-pham/update?id=${dsp.id}">
        <div class="row mt-3">
            <h2>Dòng sản phẩm</h2>
            <div class="col-6">
                <label>Id</label>
                <input type="text" name="id" class="form-control" value="${ dsp.id }" disabled/>
            </div>
            <div class="col-6"></div>
        </div>

        <div class="row mt-3">
            <div class="col-6">
                <label>Mã</label>
                <input type="text" name="ma" class="form-control" value="${ dsp.ma }" required/>
            </div>
            <div class="col-6">
                <label>Tên sản phẩm</label>
                <input type="text" name="ten" class="form-control" value="${ dsp.ten }" required/>
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