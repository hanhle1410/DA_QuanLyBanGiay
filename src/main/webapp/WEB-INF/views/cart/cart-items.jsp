<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <title>Danh sách sản phẩm và giỏ hàng</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

    <style>
        * {
            box-sizing: border-box;
        }
        .pagination > li {
            margin-right: 5px;
        }
        body {
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 1600px;
            margin: 0 auto;
            padding: 20px;
            display: flex;
            flex-direction: column;
        }

        .page-title {
            margin-bottom: 20px;
        }

        .table {
            margin-bottom: 20px;
        }

        .pagination {
            margin-bottom: 20px;
        }

        .card {
            margin-top: 20px;
        }

        .btn-create {
            position: relative;
            top: 10px;
            margin-right: 10px;
        }

        .btn-submit {
            position: relative;
            top: 10px;
        }
    </style>

</head>
<body>

<div class="container">

    <div class="row">
        <div class="col-md-8">
            <h4 class="page-title">Danh sách sản phẩm</h4>
            <form class="form-inline" action="/shopping-cart/search" method="GET">
                <div class="form-group search-results-container">
                    <label for="search-input" class="sr-only">Tìm kiếm sản phẩm</label>
                    <input type="text" class="form-control mr-2" id="search-input" name="q"
                           placeholder="Tìm kiếm sản phẩm">
                </div>
                <!-- Remove the submit button -->
            </form>
            <nav aria-label="Page navigation example">
                <ul class="pagination">
                    <c:forEach begin="0" end="${ chiTietSPList.totalPages -1}" varStatus="loop">
                        <li class="page-item">
                            <a class="page-link" href="/shopping-cart/views?page=${loop.begin + loop.count - 1}">
                                    ${loop.begin + loop.count }
                            </a>
                        </li>
                    </c:forEach>
                </ul>
            </nav>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">Sản phẩm</th>
                    <th scope="col">Đơn giá</th>
                    <th scope="col">Số lượng</th>
                    <th scope="col">Thao tác</th>
                </tr>
                </thead>
                <tbody id="search-results">
                <!-- The search results will be inserted here -->
                <c:forEach items="${ chiTietSPList.content }" var="l">
                    <tr>
                        <td>${l.idSP.idDongSP.ten} - ${l.idSP.idDeGiay.chatLieu} - Màu sắc: ${l.idMauSP.mau} - Kích
                            cỡ: ${l.idKichCo.coGiay}</td>
                        <td> ${l.idSP.giaBan}</td>
                        <td> ${l.soLuong}</td>
                        <td>
                            <a class="btn btn-primary" href="/shopping-cart/add/${l.id}"
                               onclick="addToCart(event, '${l.id}')">ADD</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <h4 class="my-1">Giỏ hàng</h4>
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Sản phẩm</th>
                    <th scope="col">Số lượng</th>
                    <th scope="col">Giá</th>
                    <th scope="col">Tổng cộng</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${CART_ITEMS}" var="item">
                    <form action="/shopping-cart/update/${item.id}" method="post">
                        <tr>
                            <input type="hidden" name="id" value="${item.idChiTietSP.id}"/>
                            <td>${item.idChiTietSP.idSP.idDongSP.ten} - ${item.idChiTietSP.idSP.idDeGiay.chatLieu} - Màu
                                sắc: ${item.idChiTietSP.idMauSP.mau} - Kích cỡ: ${item.idChiTietSP.idKichCo.coGiay}</td>
                            <td>
                                <input name="soLuong" type="number" value="${item.soLuong}" onblur="this.form.submit()"
                                       min="0" oninput="checkInput(this)" data-max="${item.idChiTietSP.soLuong}"
                                       style="width: 50px;">
                            </td>
                            <td>${item.idChiTietSP.idSP.giaBan}</td>
                            <td>${item.idChiTietSP.idSP.giaBan * item.soLuong}</td>
                            <td>
                                <a class="btn btn-danger btn-sm" href="/shopping-cart/remove/${item.id}"
                                   onclick="confirmDelete(event)">Xóa</a>
                            </td>
                        </tr>
                    </form>
                </c:forEach>
                </tbody>
            </table>
            <a class="btn btn-primary btn-sm" href="/shopping-cart/clear">Xóa giỏ hàng</a>
            <h4 class="card-header">Thông tin hóa đơn</h4>
            <table class="table">
                <!-- Nội dung bảng HoaDon -->
                <thead>
                    <tr>
                        <th>Mã</th>
                        <th>Nhân viên</th>
                        <th>Khách hàng</th>
                        <th>Ngày tạo</th>
                        <th>Trạng thái</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${hoaDonList}" var="hoaDon">
                    <tr>
                        <td>${hoaDon.ma}</td>
                        <td>${hoaDon.idNV.ten}</td>
                        <td>${hoaDon.idKH.ten}</td>
                        <td>${hoaDon.ngayTao}</td>
                        <td>${hoaDon.trangThai == 0 ? "Chờ thanh toán" : "Đã thanh toán"}</td>

                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

        <div class="col-md-4">
            <div class="card">
                <h4 class="card-header my-1">Thông tin thanh toán</h4>
                <div class="card-body">
                    <form method="post" action="/pay/luu">
                        <div class="form-group">
                            <label>Giảm giá</label>
                            <select name="idVoucher">
                                <c:forEach items="${ vouchers }" var="l" >
                                    <option value="${l.id}">${l.giamGia}%</option>
                                </c:forEach>
                            </select>
                        </div>
                        <p>Tổng tiền: <span id="total">${TOTAL}</span></p>
                        <div class="form-group">
                            <div class="form-group">
                                <label>Số điện thoại KH:<input type="text" name="sdt" id="sdt" class="form-control" value="0" onblur="kiemTraKhachHang(this)" /></label>
                                <a class="btn btn-primary" onclick="showForm('addKhachHang')">+</a>
                            </div>
                            <span id="sdt-error" style="color: red; display: none;">Vui lòng nhập số điện thoại</span>
                            <span id="sdt-format-error" style="color: red; display: none;">Số điện thoại không hợp lệ</span>
                        </div>
                        <div class="form-group" id="addKhachHang" style="display: none;">
                            <!-- Additional fields for new customer -->
                            <div class="form-group">
                                <label>Tên:<input type="text" name="ten" class="form-control" /></label>

                            </div>
                        </div>
                        <button class="btn btn-primary form-group text-center" type="submit">Tạo hóa đơn</button>
                    </form>
                </div>
            </div>
        </div>

    </div>

</div>


<script>
    function showForm(formId) {
        var form = document.getElementById(formId);
        if (form.style.display === "none") {
            form.style.display = "block";
        } else {
            form.style.display = "none";
        }
    }

    var addButton = document.getElementById('addKhachHangButton');

    // Kiểm tra xem khách hàng có tồn tại hay không
    var khachHang = null; // Giả sử khách hàng không tồn tại

    if (khachHang == null) {
        // Ẩn nút nếu khách hàng không tồn tại
        addButton.style.display = 'none';
    } else {
        // Mở nút nếu khách hàng tồn tại
        addButton.style.display = 'inline-block';
    }

    function validateFormTTTT() {
        var sdtInput = document.getElementById("sdt");
        var sdtError = document.getElementById("sdt-error");
        var sdtFormatError = document.getElementById("sdt-format-error");
        var sdtRegex = /^0\d{9,10}$/; // định dạng số điện thoại bắt đầu bằng số 0, có độ dài từ 10-11 chữ số
        if (sdtInput.value == "0") {
            sdtError.style.display = "none";
            sdtFormatError.style.display = "none";
            return true;
        } else if (!sdtRegex.test(sdtInput.value)) {
            sdtError.style.display = "none";
            sdtFormatError.style.display = "block";
            return false;
        } else {
            sdtError.style.display = "none";
            sdtFormatError.style.display = "none";
            return true;
        }
    }

    function kiemTraKhachHang(input) {
        var regex = /^[0-9]+$/; // Biểu thức chính quy kiểm tra có toàn số hay không
        var sdt = input.value;
        if (sdt.length == 0) {
            document.getElementById("sdt-error").style.display = "block";
            document.getElementById("sdt-format-error").style.display = "none";
            return false;
        } else if (!regex.test(sdt)) {
            document.getElementById("sdt-error").style.display = "none";
            document.getElementById("sdt-format-error").style.display = "block";
            return false;
        } else {
            document.getElementById("sdt-error").style.display = "none";
            document.getElementById("sdt-format-error").style.display = "none";
            return true;
        }
    }

    function confirmDelete(event) {
        event.preventDefault();
        const confirmResult = confirm('Bạn có chắc chắn muốn xóa sản phẩm này khỏi giỏ hàng?');
        if (confirmResult) {
            window.location.href = event.currentTarget.href;
        }
    }

    const input = document.querySelector('input[name="soLuong"]');
    input.addEventListener('blur', () => {
        if (input.value < 1) {
            alert('Số lượng phải lớn hơn hoặc bằng 1');
            input.value = 1;
            input.focus();
        }
    });

    function checkInput(input) {
        const value = input.value.trim();
        const isNumber = /^\d+$/.test(value);
        const max = parseInt(input.dataset.max);
        if (!isNumber) {
            alert('Vui lòng chỉ nhập số');
            input.value = '';
            input.focus();
        } else if (parseInt(value) > max) {
            alert(`Số lượng không được vượt quá ${max}`);
            input.value = max;
            input.focus();
        }
    }
</script>




<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>