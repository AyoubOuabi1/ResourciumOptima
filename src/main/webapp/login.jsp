<!DOCTYPE html>
 <html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- CSRF Token -->
    <meta name="csrf-token" content="{{ csrf_token() }}">
     <title>Login</title>
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i&amp;display=swap">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link rel="stylesheet" href="fonts/fontawesome-all.min.css"/>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="style/style.css"/>

</head>
<body >
<div class="container-fluid">
    <div class="container">
        <div class="row">
            <div class="col-md-6 offset-md-3">
                 <div class="card my-5">
                    <form method="post" action="${pageContext.request.contextPath}/login" class="card-body cardbody-color p-lg-5">

                        <div class="text-center">
                            <img src="https://p.kindpng.com/picc/s/227-2271313_user-icon-white-head-icon-hd-png-download.png" class="img-fluid profile-image-pic p-1 img-thumbnail rounded-circle my-3"
                                 width="200px" alt="profile">
                        </div>
                        <div class="mb-3">
                            <input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp"
                                   placeholder="Email">

                        </div>
                        <div class="mb-3">
                            <input type="password" class="form-control" name="password" id="password" placeholder="password">

                        </div>
                        <div class="text-center"><button type="submit" class="btn btn-dark px-5 mb-5 w-100">Login</button></div>

                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
        integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
        crossorigin="anonymous"></script>

</body>


</html>

