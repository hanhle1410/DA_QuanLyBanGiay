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
    <form method="post" action="/dong-san-pham/add">
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
                <input type="text" name="ma" class="form-control" value="${dsp.ma}" required pattern="\S+.*"/>
            </div>
            <div class="col-6">
                <label>Tên sản phẩm</label>
                <input type="text" name="ten" class="form-control" value="${dsp.ten}" required pattern="\S+.*"/>
            </div>
        </div>

        <div class="row mt-3">
            <div class="col-6">
                <button class="btn btn-primary">Add</button>
            </div>
            <div class="col-6">
                <a class="btn btn-primary" href="/dong-san-pham/clear">Clear</a>
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
            <th colspan="3">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listDSP}" var="dsp" varStatus="stt">
            <tr>
                <td>${stt.index + 1}</td>
                <td>${dsp.ma}</td>
                <td>${dsp.ten}</td>
                <td>
                    <a href="/dong-san-pham/detail/${dsp.id}" class="btn btn-success">Detail</a>
                    <a href="/dong-san-pham/delete/${dsp.id}" class="btn btn-secondary">Delete</a>
                    <a href="/dong-san-pham/view-update/${dsp.id}" class="btn btn-primary">Update</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
