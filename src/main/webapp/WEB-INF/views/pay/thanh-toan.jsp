<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thanh toán hóa đơn</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h1 class="text-center mt-3">Thanh toán hóa đơn</h1>
    <table class="table table-hover table-bordered mt-3">
        <thead>
        <tr>
            <th>Mã hóa đơn</th>
            <th>Tên khách hàng</th>
            <th>Tổng tiền</th>
            <th>Thanh toán</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${invoices}" var="invoice">
            <tr>
                <td>${invoice.id}</td>
                <td>${invoice.customerName}</td>
                <td>${invoice.total}</td>
                <td><a href="/hoa-don/thanh-toan?id=${invoice.id}" class="btn btn-primary">Thanh toán</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>