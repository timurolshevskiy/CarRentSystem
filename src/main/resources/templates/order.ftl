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
    <link href="/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/css/shop-homepage.css" rel="stylesheet">

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

    <div class="row">

        <div class="col-md-4">

            <div class="thumbnail" >
                <img class="img-responsive" src="/img/${order.car.id}.jpg" alt="">
                <div class="caption-full">
                    <h4>${order.car.mark} ${order.car.name}</h4>
                    <h4>Status: <b>${order.status}</b></h4>
                    <h4>Date created: <b>${order.date}</b></h4>
                    <h4>For <b>${order.termDays} days</b></h4>
                    <h4>Description:</h4>
                    <p>${order.description}</p>
                    <h4>With driver: <b>${order.withDriver?c}</b></h4>
                </div>

                <#if user.role.role == 'ADMIN' || user.role.role == 'MANAGER'>
                    <div class="caption-full">
                        <form action="/order/confirm">
                            <input type="hidden" name="orderId" value="${order.id}">
                            <button type="submit" class="btn btn-success">Confirm and create bill</button>
                        </form>
                        <hr>
                        <form action="/order/cancel">
                            <input type="hidden" name="orderId" value="${order.id}">

                            <div class="col-lg-2">
                                <label for="reason">Reason</label>
                            </div>
                            <div class="col-lg-7">
                                <input type="text" class="form-control" name="reason" id="reason" placeholder="Reason">
                            </div>
                            <button type="submit" class="btn btn-danger">Cancel</button>
                        </form>
                        <hr>
                        <form action="/order/complete">
                            <input type="hidden" name="orderId" value="${order.id}">
                            <button type="submit" class="btn btn-primary">Complete (car returned)</button>
                        </form>
                    </div>
                </#if>
            </div>

        </div>

        <div class="col-md-7">
            <p class="lead">Order № ${order.id}</p>
            <div class="list-group">
                <#list bills as bill>
                    <div class="list-group-item">
                        <span><b>Bill № ${bill.id}</b></span>
                        <span><#if bill.paid == false>NOT </#if>PAID</span>
                        <span>(${bill.description})</span>
                        <#if bill.paid == false && user.role.role == 'CLIENT'>
                            <hr>
                            <form action="/order/pay">
                                <input type="hidden" name="billId" value="${bill.id}">
                                <button type="submit" class="btn btn-success">Pay ${bill.price} грн</button>
                            </form>
                        </#if>
                    </div>
                </#list>
            </div>

            <#if user.role.role == 'ADMIN' || user.role.role == 'MANAGER'>
                <div class="row">
                    <p class="lead">Bill for damages:</p>
                    <form action="/order/billForDamages">
                        <div class="col-lg-3">
                            <label for="description" class="control-label">Description</label>
                        </div>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" name="description" id="description" placeholder="Description">
                        </div>
                        <br><hr>

                        <div class="col-lg-3">
                            <label for="cost" class="control-label">Cost</label>
                        </div>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" name="cost" id="cost" placeholder="Cost">
                        </div>
                        <br><hr>

                        <div class="col-lg-4">
                            <button type="submit" class="btn btn-primary">Create</button>
                        </div>
                        <input type="hidden" name="orderId" value="${order.id}">
                    </form>
                </div>
            </#if>
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
