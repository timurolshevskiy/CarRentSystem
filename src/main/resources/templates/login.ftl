<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Shop Homepage - Start Bootstrap Template</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/shop-homepage.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<div>

    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Car rent system</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

                <#if user?? && (user.role.role == 'ADMIN' || user.role.role == 'MANAGER')>
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="/car/all">Main</a>
                        </li>
                        <li>
                            <a href="/user/all">Users</a>
                        </li>
                        <li>
                            <a href="#">Contacts</a>
                        </li>
                        <#if user??>
                            <li><a href="/logout">${user.login} (Logout)</a></li>
                            <#else>
                                <li><a href="/login">Login</a></li>
                                <li><a href="/login">Registration</a></li>
                        </#if>
                    </ul>
                    <#else>
                        <ul class="nav navbar-nav">
                            <li>
                                <a href="/car/all">Main</a>
                            </li>
                            <li>
                                <a href="/order?userId=${(user.id)!0}">My orders</a>
                            </li>
                            <li>
                                <a href="#">Contacts</a>
                            </li>
                                <#if user??>
                                    <li><a href="/logout">${user.login} (Logout)</a></li>
                                    <#else>
                                        <li><a href="/login">Login</a></li>
                                        <li><a href="/login">Registration</a></li>
                                </#if>
                        </ul>
                </#if>

            </div>
            <!-- /.navbar-collapse -->
        </div>

        <!-- /.container -->
    </nav>

    <!-- Page Content -->
    <div class="container">


        <div class="col-lg-4">

            <form action="/login" method="post" role="form">
                <legend>Login</legend>

                <div class="form-group">
                    <label for="login"></label>
                    <input type="text" class="form-control" name="username" id="login" placeholder="Login">

                    <label for="login_pass"></label>
                    <input type="password" class="form-control" name="password" id="login_pass" placeholder="Password">
                </div>



                <button type="submit" class="btn btn-primary">Sign in</button>
            </form>
        </div>

        <div class="col-lg-4 pull-right">
            <form action="/user/signUp" method="post" role="form">
                <legend>Registration</legend>

                <div class="form-group">
                    <label for="username">Login</label>
                    <input type="text" class="form-control" name="login" id="username" placeholder="Login">

                    <label for="password">Password</label>
                    <input type="password" class="form-control" name="password" id="password" placeholder="Password">

                    <label for="email">E-mail</label>
                    <input type="email" class="form-control" name="email" id="email" placeholder="E-mail">

                    <label for="firstName">First name</label>
                    <input type="text" class="form-control" name="firstName" id="firstName" placeholder="First name">

                    <label for="lastName">Last name</label>
                    <input type="text" class="form-control" name="lastName" id="lastName" placeholder="Last name">
                </div>

                <button type="submit" class="btn btn-primary">Sign up</button>
            </form>
        </div>
    </div>
    <!-- /.container -->

    <div class="container">

        <hr>

        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; Tymur Olshevskyi 2017</p>
                </div>
            </div>
        </footer>

    </div>
    <!-- /.container -->

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
</div>

</body>

</html>
