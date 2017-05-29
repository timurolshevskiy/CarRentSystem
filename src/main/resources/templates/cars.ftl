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

        <div class="col-md-3">
            <!--<div class="list-group">
                <a href="#" class="list-group-item">Sort by Name</a>
                <a href="#" class="list-group-item">Sort by Cost</a>
            </div>-->
            <form action="/car/all" method="get" role="form">
                <legend>Filter</legend>

                <div class="form-group">
                    <label for="mark">Mark</label>
                    <input type="text" class="form-control" name="mark" id="mark" placeholder="Mark">

                    <label for="qualityClass">Quality class</label>
                    <input type="text" class="form-control" name="qualityClass" id="qualityClass" placeholder="Quality class">

                    <div class="radio">
                        <p class="lead">
                            Sort by
                        </p>
                        <label>
                            <input type="radio" name="sortBy" id="sort_name" value="name" checked="checked">
                            Name
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio" name="sortBy" id="sort_pricePerDay" value="pricePerDay">
                            Price per day
                        </label>
                    </div>
                </div>
                
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>

        <div class="col-md-9">

            <div class="row">

                <#list cars as car>

                    <div class="col-sm-4 col-lg-4 col-md-4">
                        <div class="thumbnail">
                            <img src="/img/${car.id}.jpg" alt="" style="max-height: 150px; height: 150px">
                            <div class="caption">
                                <h4 class="pull-right">${car.pricePerDay} uah/h</h4>
                                <h4><a href="/car?id=${car.id}">${car.mark} ${car.name}</a>
                                </h4>
                                <p><b>${car.qualityClass}</b> quality</p>
                                <p>${car.description}</p>
                            </div>
                            <#if user?? && (user.role.role == 'ADMIN')>
                                <div class="caption-full">
                                    <form action="/car/delete" class="form-horizontal" role="form">
                                        <input type="hidden" name="id" value="${car.id}">
                                        <button type="submit" class="btn btn-success">Delete car</button>
                                    </form>
                                </div>
                            </#if>
                        </div>
                    </div>

                </#list>

            </div>

        </div>

    </div>

    <#if user?? && (user.role.role == 'ADMIN')>
    <div class="row">
        <form action="/car/add" method="post" class="form-horizontal" role="form">
            <div class="form-group">
                <legend>Add new car</legend>
            </div>

            <div class="col-lg-3">
                <label for="name" class="control-label">Name</label>
            </div>
            <div class="col-lg-6">
                <input type="text" class="form-control" name="name" id="name" placeholder="Name">
            </div>
            <br><hr>
            <div class="col-lg-3">
                <label for="addQualityClass" class="control-label">Quality class</label>
            </div>
            <div class="col-lg-6">
                <input type="text" class="form-control" name="qualityClass" id="addQualityClass" placeholder="Quality class">
            </div>
            <br><hr>
            <div class="col-lg-3">
                <label for="addMark" class="control-label">Add mark</label>
            </div>
            <div class="col-lg-6">
                <input type="text" class="form-control" name="mark" id="addMark" placeholder="Add mark">
            </div>
            <br><hr>
            <div class="col-lg-3">
                <label for="description" class="control-label">Description</label>
            </div>
            <div class="col-lg-6">
                <input type="text" class="form-control" name="description" id="description" placeholder="Description">
            </div>
            <br><hr>
            <div class="col-lg-3">
                <label for="addPricePerDay" class="control-label">Price per day</label>
            </div>
            <div class="col-lg-6">
                <input type="text" class="form-control" name="pricePerDay" id="addPricePerDay" placeholder="Price per day">
            </div>
            <br><hr>

            <div class="form-group">
                <div class="col-sm-10">
                    <button type="submit" class="btn btn-success">Add car</button>
                </div>
            </div>
        </form>
    </div>
    </#if>

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
