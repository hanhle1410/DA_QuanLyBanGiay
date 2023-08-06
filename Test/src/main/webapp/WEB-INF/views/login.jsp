<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<section class="gradient-form py-5">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card rounded-3">
                    <div class="card-body p-md-5 mx-md-4">
                        <h4 class="text-center mb-5">Đăng Nhập</h4>
                        <form class="username">
                            <div class="mb-4">
                                <label for="username" class="form-label">Tên Đăng Nhập</label>
                                <input type="text" id="username" name="username" class="form-control" required />
                            </div>

                            <div class="mb-4">
                                <label for="password" class="form-label">Mật Khẩu</label>
                                <input type="password" id="password" name="password" class="form-control" required />
                            </div>

                            <button class="btn btn-primary btn-block w-100 mb-3" type="submit">Login</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>