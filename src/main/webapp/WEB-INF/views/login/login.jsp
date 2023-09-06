<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Rubik" rel="stylesheet">

</head>

<body>
<section class=" gradient-form py-5" style="background: white;">
    <div class="container ">
        <div class="row d-flex justify-content-center align-items-center ">
            <div class="col-xl-6 ">
                <div class="card rounded-3 text-black" style="background: antiquewhite">
                    <div class="row g-0 col-lg-12">
                            <div class="card-body p-md-5 mx-md-4">
                                <div class="text-center">
                                    <h4 class="mt-1 mb-5 pb-1">Login to use your account</h4>
                                </div>
                                <form method="post" action="/loginForm"
                                      class="form form-login" (ngSubmit)="onSubmit()">
                                    <p>Please login to your account</p>

                                    <div class="form-outline mb-4">
                                        <input type="text" id="username" name="username" class="form-control"
                                               required />
                                        <label class="form-label" for="username">User Name</label>
                                    </div>

                                    <div class="form-outline mb-4">
                                        <input type="password" id="password" name="password" class="form-control"
                                               required />
                                        <label class="form-label" for="password">Password</label>
                                    </div>

                                    <div class="d-flex flex-column align-items-center  pt-1 mb-5 pb-1">
                                        <button class="btn btn-primary btn-block w-100 fa-lg gradient-custom-2 mb-3"
                                                type="submit">Log
                                            in</button>
                                        <a class="text-muted" href="#!">Forgot password?</a>
                                    </div>

                                    <div class="d-flex align-items-center justify-content-center pb-4">
                                        <p class="mb-0 me-2">Don't have an account?</p>
                                        <button type="submit" class="btn btn-outline-danger"
                                                routerLink="/register">Create new</button>
                                    </div>

                                </form>

                            </div>
                        </div>
                    </div>

            </div>
        </div>
    </div>
</section>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>