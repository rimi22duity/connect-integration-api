<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Login</title>

    <!-- Custom fonts for this template-->
    <link href="resource/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
          rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="resource/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body class="bg-gradient-light">

<div class="container">

    <!-- Outer Row -->
    <div class="row justify-content-center">

        <div class="col-xl-6 col-lg-6 col-md-9">

            <div class="card my-5 border-bottom-warning">
                <div class="card-body">
                    <div class="text-center">
                        <h1 class="h4 text-gray-900 mb-4">Activate</h1>
                    </div>
                    <form action="/activate" method="post">
                        <input type="hidden" name="redirect_uri" value="${redirect_uri}">
                        <input type="hidden" name="state" value="${state}">
                        <p>
                            <label for="redirect_uri">Redirect URI:</label>
                            <input type="text"
                                   class="form-control"
                                   id="redirect_uri"
                                   value="${redirect_uri}"/>
                        </p>
                        <p>
                            <label for="state">State:</label>
                            <input type="text"
                                   class="form-control"
                                   id="state"
                                   value="${state}"/>
                        </p>
                        <p>
                            <input type="submit"
                                   class="btn btn-warning"
                                   value="Allow This App"
                                   style="color:black">
                        </p>
                    </form>
                </div>
            </div>

        </div>

    </div>

</div>

<!-- Bootstrap core JavaScript-->
<script src="resource/vendor/jquery/jquery.min.js"></script>
<script src="resource/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="resource/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="resource/js/sb-admin-2.min.js"></script>

</body>

</html>