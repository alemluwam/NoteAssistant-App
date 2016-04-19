<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Siken and team">

    <title>NoteAssistant 2016 | Section Detail</title>

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
            background-color: #77ab59;
        }
    </style>
</head>

<body>

    <!-- Navigation -->
    <%@ include file="../common/nav_menu_section.jsp" %>

    <!-- Page Content -->
    <div class="container">
        <div class="row">

            <div class="col-md-3">
                <p class="lead">Section</p>
                <div class="list-group">
                    <a href="${pageContext.request.contextPath}/section" class="list-group-item active">Section List</a>
                    <a href="${pageContext.request.contextPath}/section/add" class="list-group-item">Add New Section</a>
                </div>
            </div>

            <div class="col-md-9">

                <div class="jumbotron">
                    <h2>Section List</h2>
                </div>

                <div class="col-md-15">

                    <table class="table table-hover table-striped">
                        <thead>
                            <tr>
                                <th>Section Name</th>
                                <th>Theme</th>

                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th>Maths</th>
                                <td>Theme5</td>

                            </tr>
                            <tr>
                                <th>Programming</th>
                                <td>Theme3</td>

                            </tr>
                        </tbody>
                    </table>
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