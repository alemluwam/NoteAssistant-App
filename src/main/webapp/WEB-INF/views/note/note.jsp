<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Siken and team">

    <title>NoteAssistant 2016 | Note Detail</title>

    <!-- Bootstrap Core CSS -->
    <link href="<c:url value='resources/css/bootstrap.min.css'/>" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<c:url value='resources/css/style.css'/>" rel="stylesheet">
    
    <!-- Favicon -->
    <link rel='shortcut icon' type='image/x-icon' href='resources/images/favicon.ico' />
    
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style>
        .jumbotron {
            background-color: #40bbe1;
        }
    </style>
</head>

<body>

    <!-- Navigation -->
    <%@ include file="../common/nav_menu_note.jsp" %>

    <!-- Page Content -->
    <div class="container">
        <div class="row">

            <div class="col-md-3">
                <p class="lead">Note</p>
                <div class="list-group">
                    <a href="${pageContext.request.contextPath}/note" class="list-group-item active">Note</a>
                    <a href="${pageContext.request.contextPath}/note/add" class="list-group-item">Add New Note</a>
                </div>
            </div>

            <div class="col-md-9">
                <div class="jumbotron">
                    <h2>Notes</h2>
                </div>

                <div class="col-md-15">
                    <form class="form-inline" role="form" method="POST" action="">
                        <div class="form-group">
                            <label for="section">Section </label>
                            <select class="form-control input-lg" name="section" style="width:573px" id="section">
                                <option value="1">Section A</option>
                                <option value="2">Section B</option>
                                <option value="3">Section C</option>
					        </select>
                        </div>
                        <button type="submit" class="btn btn-lg btn-primary">Go</button>
                    </form>
                    <br/>
                    <form class="form-inline" role="form" method="POST" action="">
                        <div class="form-group">
                            <label for="search">Search </label>
                            <input type="text" class="form-control input-lg" name="search" id="search" size="56" />
                        </div>
                        <div class="form-group">
                            <select class="form-control input-lg" name="searchby" id="searchby">
                                <option value="text">Text</option>
                                <option value="title">Title</option>
                                <option value="link">Link</option>
                            </select>
                        </div>
                        <button type="submit" class="btn btn-lg btn-primary">Search</button>
                    </form>

                    <hr/>
                    <!-- this will be the loop -->
                    <div class="panel panel-info show100">
                        <div class="panel-heading">
                            <h4>Note Title1</h4></div>
                        <div class="panel-body">
                            <span class="pull-right bg-success">&nbsp;2016-10-08 | <a href="#"><b>Update&nbsp;</b></a></span><br/>
                            Cu elit veri consectetuer his, id has debet dictas alienum.</div>
                    </div>
                    <div class="panel panel-info show100">
                        <div class="panel-heading">
                            <h4>Note Title2</h4></div>
                        <div class="panel-body">
                            <span class="pull-right bg-success">&nbsp;2016-10-07 | <a href="#"><b>Update&nbsp;</b></a></span><br/>
                            Est latine inimicus hendrerit no, nam zril scaevola ei. Pri ut nulla euismod. Brute doming dignissim
                            ei his, est ludus veniam dictas no</div>
                    </div>

                </div>

            </div>
        </div>
        <!-- /.row -->
    </div>
    <!-- /.container -->

    <div class="container">

        <!-- Footer -->
        <%@ include file="../common/footer.jsp" %>

    </div>
    <!-- /.container -->

    <!-- jQuery -->
    <script src="<c:url value='resources/js/jquery.min.js'/>"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<c:url value='resources/js/bootstrap.min.js'/>"></script>

</body>
</html>