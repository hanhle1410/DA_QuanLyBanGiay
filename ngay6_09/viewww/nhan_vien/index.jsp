<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Nhân viên</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
          crossorigin="anonymous">
</head>
<body>
<h2>Nhân viên</h2>
<form method="post" action="/nhan-vien/add">
    <div class="row mt-3">
        <div class="col-6">
            <label>Mã</label>
            <input type="text" name="ma" class="form-control" value="${nv.ma}" required/>
        </div>
        <div class="col-6">
            <label>Tên</label>
            <input type="text" name="ten" class="form-control" value="${nv.ten}" required/>
        </div>
    </div>


    <div class="row mt-3">
        <div class="col-6">
            <label>Giới tính</label>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gioiTinh" id="nam" value="Nam" ${ nv.gioiTinh == "Nam" ? "checked" : "" }>
                    <label class="form-check-label" for="nam"> Nam </label> </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gioiTinh" id="nu" value="Nữ" ${ nv.gioiTinh == "Nữ" ? "checked" : "" }>
                <label class="form-check-label" for="nu"> Nữ </label>
                </div>
        </div>
        <div class="col-6">
            <label>Ngày sinh</label>
            <input type="date" name="ngaySinh" class="form-control" value="${nv.ngaySinh}" required/>
        </div>
    </div>

    <div class="row mt-3">
        <div class="col-6">
            <label>Địa chỉ</label>
            <input type="text" name="diaChi" class="form-control" value="${nv.diaChi}" required/>
        </div>
        <div class="col-6">
            <label>Số điện thoại</label>
            <input type="text" name="sdt" class="form-control" value="${nv.sdt}"/>
        </div>
    </div>
    <div class="row mt-3">
        <div class="col-6">
            <label>Email</label>
            <input type="text" name="email" class="form-control" value="${nv.email}" required/>
        </div>
    </div>
    <div class="row mt-3">
        <div class="col-6">
            <label>Chức vụ</label>
            <select name="idCV" class="form-select"/>
            <c:forEach items="${listsCV}" var="ch">
                <option value="${ch.id}">${ch.ten}</option>
            </c:forEach>
            </select>
        </div>
    </div>

    <div class="row mt-3">
        <div class="col-6">
            <button class="btn btn-primary">Add</button>
        </div>
        <div class="col-6">
            <a class="btn btn-primary" href="/nhan-vien/clear">Clear</a>
        </div>
    </div>
</form>
<table class="table table-striped mt-3">
    <thead>
    <tr>
        <th>#</th>
        <th>Mã</th>
        <th>Tên</th>
        <th>Giới tính</th>
        <th>Ngày sinh</th>
        <th>Địa chỉ</th>
        <th>Số điện thoại</th>
        <th>Email</th>
        <th>Chức vụ</th>
        <th colspan="4">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${ lists }" var="nv" varStatus="stt">
        <tr>
            <td>${stt.index + 1}</td>
            <td>${nv.ma}</td>
            <td>${nv.ten}</td>
            <td>${nv.gioiTinh}</td>
            <td>${nv.ngaySinh}</td>
            <td>${nv.diaChi}</td>
            <td>${nv.sdt}</td>
            <td>${nv.email}</td>
            <td>${nv.idCV.ten}</td>
            <td>
                <a href="/nhan-vien/detail/${nv.id}" class="btn btn-primary">Detail</a>
                <a href="/nhan-vien/view-update/${nv.id}" class="btn btn-primary">Update</a>
                <a href="/nhan-vien/delete/${nv.id}" class="btn btn-primary">Delete</a>
<%--                <a href="/nhan-vien/view-updatetk/${nv.id}" class="btn btn-primary">Account</a>--%>
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