<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Khách hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
          crossorigin="anonymous">
</head>
<body>
<h2>Khách hàng</h2> <br>
<div class="col-8 offset-2">
    <form method="post" action="/khach-hang/update?id=${kh.id}">
        <div class="row mt-3">
            <div class="col-6">
                <label>ID</label>
                <input type="text" name="id" class="form-control" value="${kh.id}" required disabled/>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Mã</label>
                <input type="text" name="ma" class="form-control" value="${kh.ma}" required/>
            </div>
            <div class="col-6">
                <label>Tên</label>
                <input type="text" name="ten" class="form-control" value="${kh.ten}" required/>
            </div>
        </div>


        <div class="row mt-3">
            <div class="col-6">
                <label>Số điện thoại</label>
                <input type="text" name="sdt" class="form-control" value="${kh.sdt}" required/>
            </div>
            <div class="col-6">
                <label>Ngày sinh</label>
                <input type="date" name="ngaySinh" class="form-control" value="${kh.ngaySinh}" required/>
            </div>
        </div>

        <div class="row mt-3">
            <div class="col-6">
                <label>Địa chỉ</label>
                <input type="text" name="diaChi" class="form-control" value="${kh.diaChi}" required/>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <button class="btn btn-primary">Update</button>
            </div>
        </div>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
</body>
</html>