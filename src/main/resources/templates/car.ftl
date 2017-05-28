<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Shop Item - Start Bootstrap Template</title>

    <!-- Bootstrap Core CSS -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/css/shop-item.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

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

        <div class="row" style="margin-top: 15px">

            <div class="col-md-10">

                <div class="thumbnail" >
                    <img class="img-responsive" src="/img/${car.id}.jpg" alt="">
                    <div class="caption-full">
                        <h4 class="pull-right">${car.pricePerDay} грн/час</h4>
                        <h4><a href="#">${car.mark} ${car.name}</a>
                        </h4>
                        <p>${car.description}</p>
                        <p>Want to find out <a href="https://www.google.com.ua/search?q=${car.mark}+${car.name}">more</a>?</p>
                        <h4>Currently <#if car.available == false><b>not</b></#if> available</h4>
                    </div>
                </div>

                <div class="well">

                    <form action="/order/make" method="post" class="form-horizontal" role="form">
                        <div class="form-group">
                            <legend>Order the car</legend>
                        </div>

                        <div class="col-lg-3">
                            <label for="termDays" class="control-label">Amount of days</label>
                        </div>
                        <div class="col-lg-6">
                            <input type="text" class="form-control" name="termDays" id="termDays" placeholder="Amount of days">
                        </div>
                        <br><hr>
                        <div class="col-lg-3">
                            <label for="passportSeries" class="control-label">Passport series</label>
                        </div>
                        <div class="col-lg-6">
                            <input type="text" class="form-control" name="passportSeries" id="passportSeries" placeholder="Passport series">
                        </div>
                        <br><hr>
                        <div class="col-lg-3">
                            <label for="passportNumber" class="control-label">Passport number</label>
                        </div>
                        <div class="col-lg-6">
                            <input type="text" class="form-control" name="passportNumber" id="passportNumber" placeholder="Passport number">
                        </div>
                        <br><hr>
                        <div class="col-lg-3">
                            <label for="description" class="control-label">Description</label>
                        </div>
                        <div class="col-lg-6">
                            <input type="text" class="form-control" name="description" id="description" placeholder="Description">
                        </div>
                        <br><hr>

                        <div class="radio">
                            <label>
                                <input type="radio" name="withDriver" id="withDriver" value="true" checked="checked">
                                With driver
                            </label>
                            <br>
                            <label>
                                <input type="radio" name="withDriver" id="withoutDriver" value="false" checked="checked">
                                Without driver
                            </label>
                        </div>
                        <br><hr>
                        <input type="hidden" name="carId" value="${car.id}">

                        <div class="form-group">
                            <div class="col-sm-10">
                                <button type="submit" class="btn btn-success">Submit</button>
                            </div>
                        </div>
                    </form>

                </div>

            </div>


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
    <script src="/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/js/bootstrap.min.js"></script>

</body>

</html>
