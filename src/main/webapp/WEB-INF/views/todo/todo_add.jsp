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

    <title>NoteAssistant 2016 | ToDo</title>

    <!-- Bootstrap Core CSS -->
    <link href="<c:url value='../resources/css/bootstrap.min.css'/>" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<c:url value='../resources/css/style.css'/>" rel="stylesheet">
    
    <!-- Favicon -->
    <link rel='shortcut icon' type='image/x-icon' href='../resources/images/favicon.ico' />
    
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style>
        .jumbotron {
            background-color: #ffd934;
            color: #333;
        }
    </style>
</head>

<body>

    <!-- Navigation -->
    <%@ include file="../common/nav_menu_todo.jsp" %>

    <!-- Page Content -->
    <div class="container">
        <div class="row">

            <div class="col-md-3">
                <p class="lead">ToDo</p>
                <div class="list-group">
                    <a href="${pageContext.request.contextPath}/todo" class="list-group-item">ToDo List</a>
                    <a href="${pageContext.request.contextPath}/todo/add" class="list-group-item active">Add New ToDo</a>
                </div>
            </div>

            <div class="col-md-9">

                <div class="jumbotron">
                    <h2>ToDo</h2>
                </div>

                <form role="form" method="post" action="">
                    <div class="form-group">
                        <label for="title">
						Title
					</label>
                        <input type="text" class="form-control" name="title" id="title" placeholder="Title of the todo" value="" required />
                    </div>

                    <div class="form-group">
                        <label for="content">Description</label>
                        <textarea class="form-control" rows="10" name="desc" id="desc" placeholder="What do you want to do" required></textarea>
                    </div>

                    <div class="form-group">
                        <label for="due_date">
						Due Date
					</label>
                        <input type="date" class="form-control" name="due_date" id="due_date" value="" required />
                    </div>

                    <div class="form-group">
                        <label for="due_date">Reminder Start Date</label>
                        <input type="date" class="form-control" name="reminder_date" id="reminder_date" value="" required />
                    </div>
                    
					<div class="form-group">
						<label for="section">Section</label>
						<select class="form-control" name="section" id="section">
							<option value="#e6d273">Section A</option>
							<option value="#c9df8a">Section B</option>
							<option value="#77ab59">Section C</option>
						</select>
					</div>
									
                    <div class="text-right">
                        <button type="submit" class="btn-lg btn-primary">
						Save
					</button>
                        <button type="reset" class="btn-lg btn-success">
						Clear
					</button>
                    </div>
                </form>
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
    <script src="<c:url value='../resources/js/jquery.min.js'/>"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<c:url value='../resources/js/bootstrap.min.js'/>"></script>

</body>
</html>