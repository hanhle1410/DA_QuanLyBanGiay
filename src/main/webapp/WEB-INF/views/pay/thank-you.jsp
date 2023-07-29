<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thank you for your purchase!</title>
</head>
<body>
<h1>Thank you for your purchase!</h1>
<p>Your payment has been processed successfully.</p>
<p>Order details:</p>
<ul>
    <li>Order ID: ${hoaDon.id}</li>
    <li>Order total: ${hoaDon.tongTien}</li>
    <li>Payment method: ${hoaDon.phuongThucThanhToan}</li>
</ul>
</body>
</html>