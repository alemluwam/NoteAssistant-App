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

<title>NoteAssistant 2016 | Section</title>

<!-- Bootstrap Core CSS -->
<link href="<c:url value='../resources/css/bootstrap.min.css'/>"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="<c:url value='../resources/css/style.css'/>"
	rel="stylesheet">

<!-- Favicon -->
<link rel='shortcut icon' type='image/x-icon'
	href='../resources/images/favicon.ico' />

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
	<%@ include file="../common/nav_menu_section.jsp"%>

	<!-- Page Content -->
	<div class="container">
		<div class="row">

			<div class="col-md-3">
				<p class="lead">Section</p>
				<div class="list-group">
					<a href="${pageContext.request.contextPath}/section" class="list-group-item">Section List</a> <a
						href="${pageContext.request.contextPath}/section/add" class="list-group-item active">Add New Section</a>
				</div>
			</div>

			<div class="col-md-9">

				<div class="jumbotron">
					<h2><span class="glyphicon glyphicon-picture"></span> Section</h2>
				</div>


				<form:form modelAttribute="newSection" cssClass="form">
					<div class="well">
						<div class="row">
							<div class="col-md-12">
								<span class="glyphicon glyphicon-star"></span> Add section for
								better organizing Note or ToDo. <span class="pull-right">&nbsp;</span>
							</div>
						</div>
					</div>

					<form:input path="user.userId" type="hidden" />

					<div class="form-group">
						<label for="sec_name">Name</label>

						<!-- <input type="text" class="form-control" name="sec_name" id="sec_name" placeholder="Section Name" value="" required>  -->
						<form:input path="sectionName" cssClass="form-control"
							placeholder="Section Name" required="required" />
						<form:errors path="sectionName" cssClass="has-error" />
					</div>

					<div class="form-group">
						<div class="box" style="background-color: #e6d273">Theme1</div>
						<div class="box" style="background-color: #ffd934">Theme2</div>
						<div class="box" style="background-color: #c9df8a">Theme3</div>
						<div class="box" style="background-color: #add633">Theme4</div>
						<div class="box" style="background-color: #77ab59">Theme5</div>
						<div class="box" style="background-color: #e3f7ff">Theme6</div>
						<div class="box" style="background-color: #b1cccd">Theme7</div>
						<div class="box" style="background-color: #417282">Theme8</div>
						<div class="box" style="background-color: #ff8c5a">Theme9</div>
						<div class="box" style="background-color: #c92434">Theme10</div>
					</div>

					<div class="row">
						<div class="col-md-12"></div>
					</div>

					<div class="form-group">
						<label for="theme">Theme</label> <select class="form-control"
							name="theme" id="theme">
							<option value="#e6d273">Theme1</option>
							<option value="#ffd934">Theme2</option>
							<option value="#c9df8a">Theme3</option>
							<option value="#add633">Theme4</option>
							<option value="#77ab59">Theme5</option>
							<option value="#e3f7ff">Theme6</option>
							<option value="#b1cccd">Theme7</option>
							<option value="#417282">Theme8</option>
							<option value="#ff8c5a">Theme9</option>
							<option value="#c92434">Theme10</option>
						</select>
					</div>

					<div class="text-right">
						<button type="submit" class="btn-lg btn-primary">Save</button>
						<button type="reset" class="btn-lg btn-success">Clear</button>
					</div>
				</form:form>
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
	<script src="<c:url value='../resources/js/jquery.min.js'/>"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="<c:url value='../resources/js/bootstrap.min.js'/>"></script>

</body>
</html>