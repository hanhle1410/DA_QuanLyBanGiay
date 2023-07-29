<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Thanh toán hóa đơn</title>
    <style>
        table { border-collapse: collapse; width: 50%; }
        th, td { border: 1px solid black; padding: 8px; text-align: left; }
        th { background-color: #ddd; }
        h1, h2 { text-align: center; }
        form { text-align: center; }

        .container {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;

        }


        input[type=submit] {
            background-color: #4CAF50;
            border: none; color: white;
            padding: 12px 28px;
            text-decoration: none;
            display: inline-block;
            font-size: 16px; margin: 4px 2px;
            cursor: pointer;
        }
        .actions {
            display: inline-block;
            margin-top: 20px;
            background-color: #f5f5f5;
            color: #333;
            font-size: 16px;
            padding: 10px 20px;
        }
        .cancel {
            background-color: #4CAF50;
            border: none; color: white;
            padding: 12px 28px;
            text-decoration: none;
            display: inline-block;
            font-size: 16px; margin: 4px 2px;
            cursor: pointer;
        }
        #cancelButton {
            color: white;
            background-color: #4CAF50;
            border: none;
        }

        #paymentMessage {
            display: none; /* ẩn phần tử */
            background-color: #f2f2f2; /* thiết lập màu nền */
            padding: 10px; /* thêm padding */
            border: 1px solid #ccc; /* thêm đường viền */
        }

        #backButton {
            background-color: #4CAF50; /* thiết lập màu nền */
            color: white; /* thiết lập màu chữ */
            padding: 10px 15px; /* thêm padding */
            border: none; /* loại bỏ đường viền */
            cursor: pointer; /* biến con trỏ chuột thành hình tay */
        }

        /* khi rê chuột vào nút, thay đổi màu nền */
        #backButton:hover {
            background-color: #3e8e41;
        }
        /*in*/
        #printButton {
            background-color: #4CAF50; /* thiết lập màu nền */
            color: white; /* thiết lập màu chữ */
            padding: 10px 15px; /* thêm padding */
            border: none; /* loại bỏ đường viền */
            cursor: pointer; /* biến con trỏ chuột thành hình tay */
        }

        /* khi rê chuột vào nút, thay đổi màu nền */
        #printButton:hover {
            background-color: #3e8e41;
        }


    </style>
</head>
<body>

<div class="container">
    <h1>Thông tin hóa đơn</h1>
    <table>
        <tr>
            <td><strong>Mã hóa đơn:</strong></td>
            <td><c:out value="${hoaDon.ma}" /></td>
        </tr>
        <tr>
            <td><strong>Ngày tạo:</strong></td>
            <td><c:out value="${hoaDon.ngayTao}" /></td>
        </tr>
        <tr>
            <td><strong>Khách hàng:</strong></td>
            <td><c:out value="${hoaDon.idKH.ten}" /></td>
        </tr>
        <tr>
            <td><strong>Nhân viên:</strong></td>
            <td><c:out value="${hoaDon.idNV.ten}" /></td>
        </tr>
        <tr>
            <td><strong>Giảm giá:</strong></td>
            <td>
                <c:if test="${hoaDon.idVoucher.giamGia != 0}">
                    <c:out value="${hoaDon.idVoucher.giamGia}%"/>
                </c:if>
            </td>
        </tr>
<%--        <tr id="trangThai">--%>
<%--            <td><strong>Trạng thái:</strong></td>--%>
<%--            <td><c:out value="${hoaDon.trangThai == 0 ?'Chờ thanh toán':'Đã thanh toán'}" /></td>--%>
<%--        </tr>--%>
        <tr>
            <td><strong>Tổng tiền:</strong></td>
            <td><c:out value="${hoaDon.tongTien * (100 - hoaDon.idVoucher.giamGia)/100}" /></td>
        </tr>
    </table>

    <h2>Chi tiết hóa đơn</h2>

    <table>
        <tr>
            <th>Sản phẩm</th>
            <th>Số lượng</th>
            <th>Đơn giá</th>
            <th>Thành tiền</th>
        </tr>
        <c:forEach items="${ hoaDon.hoaDonCTList }" var="hoaDonCT">
            <tr>
                <td><c:out value="${hoaDonCT.idChiTietSP.idSP.idDongSP.ten}" /></td>
                <td><c:out value="${hoaDonCT.soLuong}" /></td>
                <td><c:out value="${hoaDonCT.donGia}" /></td>
                <td><c:out value="${hoaDonCT.soLuong * hoaDonCT.donGia}" /></td>
            </tr>
        </c:forEach>
    </table>

    <div class="actions pay">
        <form id="paymentForm" action="/pay/thanh-toan" method="post">
            <input type="hidden" name="hoaDonId" value="${hoaDon.id}" />
            <input type="submit" value="Thanh toán" />
        </form>
    </div>

    <div id="paymentMessage" class="no-print" style="display:none;">
        <p>Thanh toán thành công!</p>
        <button id="backButton" >Trở về trang chủ</button>
<%--        <button id="printButton">In hóa đơn</button>--%>
    </div>

    <div id="cancelButton1" class="actions cancel">
        <button id="cancelButton" type="submit">Hủy hóa đơn</button>
    </div>

    <form id="cancelForm" style="display:none;">
        <label for="reason">Lý do hủy:</label>
        <input type="text" id="reason" name="reason" />
        <input type="hidden" id="ghiChu" name="ghiChu" value="${hoaDon.id}" />
        <input type="submit" value="Xác nhận" />
    </form>


</div>

<script>
    // Add event listener to the payment form submission
    document.getElementById("paymentForm").addEventListener("submit", function(event) {
        // Prevent form submission
        event.preventDefault();

        // Make AJAX request to process payment
        var xhr = new XMLHttpRequest();
        xhr.open("POST", "/pay/thanh-toan");
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.onreadystatechange = function() {
            if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
                // If payment was successful, display success message
                document.getElementById("paymentForm").style.display = "none";
                document.getElementById("paymentMessage").style.display = "block";
                document.getElementById("cancelButton").style.display = "none";
                document.querySelector(".cancel").style.display = "none";
            }
        };
        xhr.send("hoaDonId=" + encodeURIComponent("${hoaDon.id}"));
    });

    // Add event listener to the "Back to homepage" button
    document.getElementById("backButton").addEventListener("click", function() {
        // Redirect to the homepage
        window.location.href = "/shopping-cart/views";
    });
        // In hóa đơn


    document.getElementById("paymentForm").addEventListener("submit", function() {

        // ẩn các phần tử không cần thiết khi in hóa đơn
        var confirmMsg = confirm("Bạn có muốn in hóa đơn không?");
        if (confirmMsg == true) {
            document.getElementById("paymentMessage").style.display = "none";
            document.getElementById("cancelButton1").style.display = "none";
            document.getElementById("paymentForm").style.display = "none";

            // Code để in hóa đơn vào đây
            window.print();
            // hiển thị lại các phần tử đã ẩn
            document.getElementById("paymentMessage").style.display = "block";
            document.getElementById("cancelButton1").style.display = "block";
            document.getElementById("paymentForm").style.display = "block";


        } else {
            // Tiếp tục xử lý thanh toán
            // this.submit();
        }


    });

</script>
<script>
    var cancelButton = document.getElementById('cancelButton');
    var cancelForm = document.getElementById('cancelForm');

    cancelButton.addEventListener('click', function() {
        cancelForm.style.display = 'block';
    });
</script>

</body>
</html>