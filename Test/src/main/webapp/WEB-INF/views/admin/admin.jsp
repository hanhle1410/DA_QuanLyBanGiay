<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Trang chủ</title>
  <style>
    select {
      width: 100%;
      padding: 12px 20px;
      margin: 8px 0;
      box-sizing: border-box;
      border: 2px solid #ccc;
      border-radius: 4px;
      background-color: white;
      color: #333;
    }
    select:hover {
      border-color: #ddd;
    }
    .navbar {
      background-color: #333;
      overflow: hidden;
    }
    .navbar {
      background-color: #333;
      overflow: hidden;
    }
    .navbar a {
      float: left;
      display: block;
      color: white;
      text-align: center;
      padding: 14px 16px;
      text-decoration: none;
    }
    .navbar a:hover {
      background-color: #ddd;
      color: black;
    }
    form {
      margin: 20px;
      padding: 20px;
      border: 1px solid #ccc;
      border-radius: 5px;
    }
    label {
      display: block;
      margin: 10px 0;
    }
    input[type=text], input[type=password], input[type=tel], input[type=email], select {
      width: 100%;
      padding: 12px 20px;
      margin: 8px 0;
      box-sizing: border-box;
      border: 2px solid #ccc;
      border-radius: 4px;
    }
    input[type=submit], input[type=button] {
      background-color: #4CAF50;
      color: white;
      padding: 14px 20px;
      margin: 8px 0;
      border: none;
      border-radius: 4px;
      cursor: pointer;
    }
    input[type=submit]:hover, input[type=button]:hover {
      background-color: #45a049;
    }
    table {
      border-collapse: collapse;
      width: 100%;
      border-radius: 5px;
      overflow: hidden;
    }
    th, td {
      text-align: left;
      padding: 8px;
    }
    th {
      background-color: #4CAF50;
      color: white;
    }
    tr:nth-child(even) {
      background-color: #f2f2f2;
    }
  </style>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
  <div class="navbar navbar-expand-sm bg-dark navbar-dark">
    <a href="#" onclick="showEmployees()">Nhân viên</a>
    <a href="#" onclick="showPositions()">Chức vụ</a>
    <a href="#" onclick="showContracts()">HĐ</a>
    <a href="#" onclick="showVouchers()">Voucher</a>
    <a href="#">Thống kê</a>
  </div>

  <div id="voucher-info" style="display:none">
    <h2>Voucher</h2>
    <form id="voucher-form">
      <label for="voucher-id">ID:</label>
      <input type="text" id="voucher-id" name="voucher-id">

      <label for="voucher-code">Mã:</label>
      <input type="text" id="voucher-code" name="voucher-code">

      <label for="voucher-name">Tên:</label>
      <input type="text" id="voucher-name" name="voucher-name">

      <label for="voucher-discount">Giảm giá:</label>
      <input type="text" id="voucher-discount" name="voucher-discount">

      <label for="voucher-start-date">Ngày bắt đầu:</label>
      <input type="date" id="voucher-start-date" name="voucher-start-date">

      <label for="voucher-expiration-date">Ngày hết hạn:</label>
      <input type="date" id="voucher-expiration-date" name="voucher-expiration-date">

      <label for="voucher-status">Trạng thái:</label>
      <select id="voucher-status" name="voucher-status">
        <option value="Active">Active</option>
        <option value="Inactive">Inactive</option>
      </select>

      <label for="voucher-note">Ghi chú:</label>
      <textarea id="voucher-note" name="voucher-note"></textarea>

      <input type="button" value="Lưu" onclick="saveVoucher()">
      <input type="button" value="Clear" onclick="clearVoucherForm()">
    </form>

    <table id="voucher-table">
      <tr>
        <th>ID</th>
        <th>Mã</th>
        <th>Tên</th>
        <th>Giảm giá</th>
        <th>Ngày bắt đầu</th>
        <th>Ngày hết hạn</th>
        <th>Trạng thái</th>
        <th>Ghi chú</th>
      </tr>
    </table>
  </div>

  <div id="employee-form" style="display:none">
    <form>
      <label for="id">ID:</label>
      <input type="text" id="id" name="id">

      <label for="idcv">IDCV:</label>
      <select id="idcv" name="idcv">
        <option value="1">Position 1</option>
        <option value="2">Position 2</option>
        <option value="3">Position 3</option>
      </select>

      <label for="code">Mã:</label>
      <input type="text" id="code" name="code">

      <label for="name">Tên:</label>
      <input type="text" id="name" name="name">

      <label for="account">Tài khoản:</label>
      <input type="text" id="account" name="account">

      <label for="password">Mật khẩu:</label>
      <input type="password" id="password" name="password">

      <label for="phone">Số điện thoại:</label>
      <input type="tel" id="phone" name="phone">

      <label for="email">Email:</label>
      <input type="email" id="email" name="email">

      <label for="gender">Giới tính:</label>
      <select id="gender" name="gender">
        <option value="male">Nam</option>
        <option value="female">Nữ</option>
      </select>

      <label for="birthdate">Ngày sinh:</label>
      <input type="date" id="birthdate" name="birthdate">

      <label for="address">Địa chỉ:</label>
      <textarea id="address" name="address"></textarea>

      <input type="button" value="Lưu" onclick="saveEmployee()">
      <input type="button" value="Clear" onclick="clearForm()">
    </form>

    <table id="employee-table">
      <tr>
        <th>ID</th>
        <th>IDCV</th>
        <th>Mã</th>
        <th>Tên</th>
        <th>Tài khoản</th>
        <th>Số điện thoại</th>
        <th>Email</th>
        <th>Giới tính</th>
        <th>Ngày sinh</th>
        <th>Địa chỉ</th>
        <th></th>
      </tr>
    </table>
  </div>

  <div id="position-info" style="display:none">
    <h2>Chức vụ</h2>
    <div id="position-data"></div>
  </div>

  <div id="contract-info" style="display:none">
    <h2>Thông tin </h2>
    <table id="contract-table">
      <tr>
        <th>ID</th>
        <th>Mã</th>
        <th>Tên</th>
      </tr>
    </table>
  </div>
</div>


    <script>
      function showProductDetails() {
        var productDetailForm = document.getElementById("product-detail-info");
        var employeeForm = document.getElementById("employee-form");
        var positionInfo = document.getElementById("position-info");
        var contractInfo = document.getElementById("contract-info");
        var voucherInfo = document.getElementById("voucher-info");

        employeeForm.style.display = "none";
        positionInfo.style.display = "none";
        contractInfo.style.display = "none";
        voucherInfo.style.display = "none";
        productDetailForm.style.display = "block";
      }

      function addProductDetail() {
        var id = document.getElementById("prod-detail-id").value;
        var id_sp = document.getElementById("prod-detail-id-sp").value;
        var id_mau = document.getElementById("prod-detail-id-mau").value;
        var id_kichco = document.getElementById("prod-detail-id-kichco").value;
        var soluong = document.getElementById("prod-detail-soluong").value;

        var table = document.getElementById("product-detail-table");
        var row = table.insertRow(-1);
        var idCell = row.insertCell(0);
        var idSpCell = row.insertCell(1);
        var idMauCell = row.insertCell(2);
        var idKichcoCell = row.insertCell(3);
        var soluongCell = row.insertCell(4);
        var actionCell = row.insertCell(5);

        idCell.innerHTML = id;
        idSpCell.innerHTML = id_sp;
        idMauCell.innerHTML = id_mau;
        idKichcoCell.innerHTML = id_kichco;
        soluongCell.innerHTML = soluong;
        actionCell.innerHTML = '<button onclick="loadProductDetail(this)">Load</button> <button onclick="removeProductDetail(this)">Xóa</button>';

        clearProductDetailForm();
      }

      function updateProductDetail() {
        var id = document.getElementById("prod-detail-id").value;
        var id_sp = document.getElementById("prod-detail-id-sp").value;
        var id_mau = document.getElementById("prod-detail-id-mau").value;
        var id_kichco = document.getElementById("prod-detail-id-kichco").value;
        var soluong = document.getElementById("prod-detail-soluong").value;

        var table = document.getElementById("product-detail-table");
        var rows = table.rows;
        for (var i = 1; i < rows.length; i++) {
          if (rows[i].cells[0].innerHTML === id) {
            rows[i].cells[1].innerHTML = id_sp;
            rows[i].cells[2].innerHTML = id_mau;
            rows[i].cells[3].innerHTML = id_kichco;
            rows[i].cells[4].innerHTML = soluong;
            break;
          }
        }

        clearProductDetailForm();
      }

      function deleteProductDetail(button) {
        var row = button.parentNode.parentNode;
        row.parentNode.removeChild(row);
      }

      function loadProductDetail(button) {
        var row = button.parentNode.parentNode;
        var id = row.cells[0].innerHTML;
        var id_sp = row.cells[1].innerHTML;
        var id_mau = row.cells[2].innerHTML;
        var id_kichco = row.cells[3].innerHTML;
        var soluong = row.cells[4].innerHTML;

        document.getElementById("prod-detail-id").value = id;
        document.getElementById("prod-detail-id-sp").value = id_sp;
        document.getElementById("prod-detail-id-mau").value = id_mau;
        document.getElementById("prod-detail-id-kichco").value = id_kichco;
        document.getElementById("prod-detail-soluong").value = soluong;
      }

      function clearProductDetailForm() {
        document.getElementById("prod-detail-id").value = "";
        document.getElementById("prod-detail-id-sp").value = "";
        document.getElementById("prod-detail-id-mau").value = "";
        document.getElementById("prod-detail-id-kichco").value = "";
        document.getElementById("prod-detail-soluong").value = "";
      }

      function showEmployees() {
        var form = document.getElementById("employee-form");
        var positionInfo = document.getElementById("position-info");
        var contractInfo = document.getElementById("contract-info");

        form.style.display = "block";
        positionInfo.style.display = "none";
        contractInfo.style.display = "none";
      }

      function showPositions() {
        var form = document.getElementById("employee-form");
        var positionInfo = document.getElementById("position-info");
        var contractInfo = document.getElementById("contract-info");

        form.style.display = "none";
        positionInfo.style.display = "block";
        contractInfo.style.display = "none";

        var positionData = document.getElementById("position-data");

        // Lấy thông tin từ bảng nhân viên
        var table = document.getElementById("employee-table");
        var rows = table.rows;

        // Lưu ID, Mã, Tên từ bảng nhân viên vào biến positions
        var positions = "";
        for (var i = 1; i < rows.length; i++) {
          var id = rows[i].cells[0].innerHTML;
          var code = rows[i].cells[2].innerHTML;
          var name = rows[i].cells[3].innerHTML;

          positions += "<strong>ID:</strong> " + id + "<br><strong>Mã:</strong> " + code + "<br><strong>Tên:</strong> " + name + "<br><br>";
        }

        positionData.innerHTML = positions;
      }

      function showContracts() {
        var form = document.getElementById("employee-form");
        var positionInfo = document.getElementById("position-info");
        var contractInfo = document.getElementById("contract-info");

        form.style.display = "none";
        positionInfo.style.display = "none";
        contractInfo.style.display = "block";

        var contractTable = document.getElementById("contract-table");

        // Lấy thông tin từ bảng nhân viên
        var table = document.getElementById("employee-table");
        var rows = table.rows;

        // Tạo các hàng mới trong bảng hợp đồng với thông tin từ bảng nhân viên
        for (var i = 1; i < rows.length; i++) {
          var id = rows[i].cells[0].innerHTML;
          var code = rows[i].cells[2].innerHTML;
          var name = rows[i].cells[3].innerHTML;

          var row = contractTable.insertRow(-1);
          var idCell = row.insertCell(0);
          var codeCell = row.insertCell(1);
          var nameCell = row.insertCell(2);

          idCell.innerHTML = id;
          codeCell.innerHTML = code;
          nameCell.innerHTML = name;
        }
      }

      function saveEmployee() {
        // Lấy thông tin từ các trường nhập liệu
        var id = document.getElementById("id").value;
        var idcv = document.getElementById("idcv").value;
        var code = document.getElementById("code").value;
        var name = document.getElementById("name").value;
        var account = document.getElementById("account").value;
        var password = document.getElementById("password").value;
        var phone = document.getElementById("phone").value;
        var email = document.getElementById("email").value;
        var gender = document.getElementById("gender").value;
        var birthdate = document.getElementById("birthdate").value;
        var address = document.getElementById("address").value;

        // Tạo một hàng mới trong bảng dữ liệu
        var table = document.getElementById("employee-table");
        var row = table.insertRow(-1);
        var idCell = row.insertCell(0);
        var idcvCell = row.insertCell(1);
        var codeCell = row.insertCell(2);
        var nameCell = row.insertCell(3);
        var accountCell = row.insertCell(4);
        var phoneCell = row.insertCell(5);
        var emailCell = row.insertCell(6);
        var genderCell = row.insertCell(7);
        var birthdateCell = row.insertCell(8);
        var addressCell = row.insertCell(9);
        var editCell = row.insertCell(10);

        idCell.innerHTML = id;
        idcvCell.innerHTML = idcv;
        codeCell.innerHTML = code;
        nameCell.innerHTML = name;
        accountCell.innerHTML = account;
        phoneCell.innerHTML = phone;
        emailCell.innerHTML = email;
        genderCell.innerHTML = gender;
        birthdateCell.innerHTML = birthdate;
        addressCell.innerHTML = address;
        editCell.innerHTML = '<button onclick="loadEmployee(this)">Load</button> <button onclick="removeEmployee(this)">Xóa</button>';

        // Xóa dữ liệu từ các trường nhập liệu
        clearForm();
      }

      function loadEmployee(button) {
        var row = button.parentNode.parentNode;
        var id = row.cells[0].innerHTML;
        var idcv = row.cells[1].innerHTML;
        var code = row.cells[2].innerHTML;
        var name = row.cells[3].innerHTML;
        var account = row.cells[4].innerHTML;
        var phone = row.cells[5].innerHTML;
        var email = row.cells[6].innerHTML;
        var gender = row.cells[7].innerHTML;
        var birthdate = row.cells[8].innerHTML;
        var address = row.cells[9].innerHTML;

        document.getElementById("id").value = id;
        document.getElementById("idcv").value = idcv;
        document.getElementById("code").value = code;
        document.getElementById("name").value = name;
        document.getElementById("account").value = account;
        document.getElementById("phone").value = phone;
        document.getElementById("email").value = email;
        document.getElementById("gender").value = gender;
        document.getElementById("birthdate").value = birthdate;
        document.getElementById("address").value = address;
      }

      function removeEmployee(button) {
        var row = button.parentNode.parentNode;
        row.parentNode.removeChild(row);
      }

      function clearForm() {
        document.getElementById("id").value = "";
        document.getElementById("idcv").value = "";
        document.getElementById("code").value = "";
        document.getElementById("name").value = "";
        document.getElementById("account").value = "";
        document.getElementById("password").value = "";
        document.getElementById("phone").value = "";
        document.getElementById("email").value = "";
        document.getElementById("gender").value = "male";
        document.getElementById("birthdate").value = "";
        document.getElementById("address").value = "";
      }

      function showEmployees() {
        var form = document.getElementById("employee-form");
        var positionInfo = document.getElementById("position-info");
        var contractInfo = document.getElementById("contract-info");
        var voucherInfo = document.getElementById("voucher-info");
        var productDetailInfo = document.getElementById("product-detail-info");

        form.style.display = "block";
        positionInfo.style.display = "none";
        contractInfo.style.display = "none";
        voucherInfo.style.display = "none";
        productDetailInfo.style.display = "none";
      }

      function showPositions() {
        var form = document.getElementById("employee-form");
        var positionInfo = document.getElementById("position-info");
        var contractInfo = document.getElementById("contract-info");
        var voucherInfo = document.getElementById("voucher-info");
        var productDetailInfo = document.getElementById("product-detail-info");

        form.style.display = "none";
        positionInfo.style.display = "block";
        contractInfo.style.display = "none";
        voucherInfo.style.display = "none";
        productDetailInfo.style.display = "none";
      }

      function showContracts() {
        var form = document.getElementById("employee-form");
        var positionInfo = document.getElementById("position-info");
        var contractInfo = document.getElementById("contract-info");
        var voucherInfo = document.getElementById("voucher-info");
        var productDetailInfo = document.getElementById("product-detail-info");

        form.style.display = "none";
        positionInfo.style.display = "none";
        contractInfo.style.display = "block";
        voucherInfo.style.display = "none";
        productDetailInfo.style.display = "none";
      }

      function showVouchers() {
        var form = document.getElementById("employee-form");
        var positionInfo = document.getElementById("position-info");
        var contractInfo = document.getElementById("contract-info");
        var voucherInfo = document.getElementById("voucher-info");
        var productDetailInfo = document.getElementById("product-detail-info");

        form.style.display = "none";
        positionInfo.style.display = "none";
        contractInfo.style.display = "none";
        voucherInfo.style.display = "block";
        productDetailInfo.style.display = "none";
      }

      function showProductDetails() {
        var productDetailForm = document.getElementById("product-detail-info");
        var employeeForm = document.getElementById("employee-form");
        var positionInfo = document.getElementById("position-info");
        var contractInfo = document.getElementById("contract-info");
        var voucherInfo = document.getElementById("voucher-info");

        employeeForm.style.display = "none";
        positionInfo.style.display = "none";
        contractInfo.style.display = "none";
        voucherInfo.style.display = "none";
        productDetailForm.style.display = "block";
      }
    </script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>