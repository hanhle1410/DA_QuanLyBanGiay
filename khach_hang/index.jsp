<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Khách Hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
          crossorigin="anonymous">
</head>
<body>
<h1 class="text-center"> Khách hàng</h1>
<form method="post" action="/khach-hang/add">
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
            <input type="text" name="sdt" class="form-control" value="${kh.sdt}"/>
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
            <button class="btn btn-primary"> Add</button>
        </div>

        <div class="col-6">
            <button class="btn btn-primary" href="/khach-hang/clear">Clear</button>
        </div>
    </div>
</form>
    <table class="table table-striped mt-3">
        <thead>
        <tr>
            <th>#</th>
            <th>Mã</th>
            <th>Tên</th>
            <th>Số điện thoại</th>
            <th>Ngày sinh</th>
            <th>Địa chỉ</th>
            <th colspan="3">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${ lists }" var="kh" varStatus="stt">
            <tr>
                <td>${stt.index + 1}</td>
                <td>${kh.ma}</td>
                <td>${kh.ten}</td>
                <td>${kh.sdt}</td>
                <td>${kh.ngaySinh}</td>
                <td>${kh.diaChi}</td>
                <td>
                    <a href="/khach-hang/detail/${kh.id}" class="btn btn-primary">Detail</a>
                    <a href="/khach-hang/view-update/${kh.id}" class="btn btn-primary">Update</a>
                    <a href="/khach-hang/delete/${kh.id}" class="btn btn-primary">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
</body>

</html>
