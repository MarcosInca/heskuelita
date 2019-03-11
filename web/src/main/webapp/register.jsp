<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Register</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
    <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
    <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
    <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
    <link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
    <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
    <link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
    <link rel="stylesheet" type="text/css" href="css/util.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
</head>

<body>

<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login100">
            <form action="register" method="post" class="login100-form validate-form">
                <span class="login100-form-title p-b-34">
                    Register
                </span>

                <div class="wrap-input100 rs1-wrap-input100 validate-input m-b-20">
                    <input class="input100" type="text" placeholder="Username" name="user">
                    <span class="focus-input100"></span>
                </div>

                <div class="wrap-input100 rs2-wrap-input100 validate-input m-b-20">
                    <input class="input100" type="text" placeholder="Password" name="pwd">
                    <span class="focus-input100"></span>
                </div>

                <div class="wrap-input100 rs3-wrap-input100 validate-input m-b-20">
                    <input class="input100" type="text" placeholder="Email" name="email">
                    <span class="focus-input100"></span>
                </div>

                <div class="w-full text-center p-t-35 p-b-239"></div>
                <div class="w-full text-center p-t-35 p-b-239"></div>
            </form>

            <div class="login100-more" style="background-image: url('images/Student1.png');"></div>
        </div>
    </div>
</div>

<div id="dropDownSelect1"></div>
<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<script src="vendor/animsition/js/animsition.min.js"></script>
<script src="vendor/bootstrap/js/popper.js"></script>
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="vendor/select2/select2.min.js"></script>
<script>
    $(".selection-2").select2({
        minimumResultsForSearch: 20,
        dropdownParent: $('#dropDownSelect1')
    });
</script>
<script src="vendor/daterangepicker/moment.min.js"></script>
<script src="vendor/daterangepicker/daterangepicker.js"></script>
<script src="vendor/countdowntime/countdowntime.js"></script>
<script src="js/main.js"></script>

</body>
</html>
