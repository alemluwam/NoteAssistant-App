<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
<link href="<c:url value='resources/css/bootstrap.min.css'/>"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="<c:url value='resources/css/style.css'/>" rel="stylesheet">

<!-- Favicon -->
<link rel='shortcut icon' type='image/x-icon'
	href='resources/images/favicon.ico' />

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
	<%@ include file="../common/nav_menu_todo.jsp"%>

	<!-- Page Content -->
	<div class="container">
		<div class="row">

			<div class="col-md-3">
				<p class="lead">ToDo</p>
				<div class="list-group">
					<a href="${pageContext.request.contextPath}/todo"
						class="list-group-item active">ToDo List</a> <a
						href="${pageContext.request.contextPath}/todo/add"
						class="list-group-item">Add New ToDo</a>
				</div>
			</div>

			<div class="col-md-9">
				<div class="jumbotron">
					<h2><span class="glyphicon glyphicon-th-list"></span> ToDo List</h2>
				</div>

				<div class="col-md-15">
					<%-- <form class="form-inline" role="form" method="POST" action="">
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
                    <br/> --%>
					<form:form class="form-inline" role="form" method="POST" action="">
						<div class="form-group">
							<label for="search">Search </label> <input type="text"
								class="form-control input-lg" name="search" id="search" placeholder="search"
								size="52" />
						</div>
						<div class="form-group">
							<select class="form-control input-lg" name="searchby"
								id="searchby">
								<option value="title">Title</option>
								<option value="description">Description</option>
							</select>
						</div>
						<button type="submit" class="btn btn-lg btn-primary">Search</button>
					</form:form>

					<hr />
					<!-- this will be the loop -->
					<c:if test="${not empty toDoLists}">
						<c:forEach items="${toDoLists}" var="toDoList" varStatus="count">
							<div class="panel panel-warning show100">
								<div class="panel-heading">
									<h4>
									 	${count.count}. <span style="padding:2px;background-color:${toDoList.section.theme};">
									 	<c:out value="${toDoList.section.sectionName}" /></span> | ${toDoList.title}
									 </h4>
								</div>
								<div class="panel-body">
									<span class="pull-right bg-danger"><b>Due:</b>
										${toDoList.dueDate}&nbsp;
										<a href="${pageContext.request.contextPath}/todo/${toDoList.toDoListId}">
											<button class="btn btn-cicle btn-xs btn-info">Upd</button>
										</a><a href="todo/delete/${toDoList.toDoListId}">
											<button class="btn btn-cicle btn-xs btn-danger">Del</button>
										</a>
										</span><br />
									${toDoList.description }
								</div>
							</div>
							<!-- <div class="panel panel-warning show100">
								<div class="panel-heading">
									<h4>Note Title2</h4>
								</div>
								<div class="panel-body">
									<span class="pull-right bg-danger"><b>Due:</b>
										2016-10-07 | <a href="#"><b>Delete&nbsp;</b></a></span><br /> Est
									latine inimicus hendrerit no, nam zril scaevola ei. Pri ut
									nulla euismod. Brute doming dignissim ei his, est ludus veniam
									dictas no
								</div>
							</div> -->
						</c:forEach>
					</c:if>
				</div>
			</div>

		</div>
		<!-- /.row -->
	</div>
	<!-- /.container -->

	<div class="container">

		<!-- Footer -->
		<%@ include file="../common/footer.jsp"%>

	</div>
	<!-- /.container -->

	<!-- jQuery -->
	<script src="<c:url value='resources/js/jquery.min.js'/>"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="<c:url value='resources/js/bootstrap.min.js'/>"></script>

</body>
</html>