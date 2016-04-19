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

<title>NoteAssistant 2016 | Contact</title>

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
	background-color: #6ca77c;
}
</style>
</head>

<body>

	<!-- Navigation -->
	<%@ include file="../common/nav_menu_contact.jsp"%>

	<!-- Page Content -->
	<div class="container">
		<div class="row">

			<div class="col-md-3">
				<p class="lead">Contact</p>
				<div class="list-group">
					<a href="${pageContext.request.contextPath}/contact" class="list-group-item">Contact List</a> <a
						href="${pageContext.request.contextPath}/contact/add" class="list-group-item active">Add New Contact</a>
				</div>
			</div>

			<div class="col-md-9">

				<div class="jumbotron">
					<h2>Contact Person</h2>
				</div>

				<form:form modelAttribute="newContact" cssClass="form">
					<div class="well">
						<div class="row">
							<div class="col-md-12">
								<span class="glyphicon glyphicon-star"></span> Add your friend, family or any person to your contact list.
								<span class="pull-right">&nbsp;</span>
							</div>
						</div>
					</div>

					<!-- <div class="form-group">
                        <input type="hidden" class="form-control" name="id" id="id" value="" />
                    </div> -->
                    <form:input path="user.userId" type="hidden" />
                    <!--  <input id="user" name="user" class="form-control"  type="hidden" />  -->

					<div class="form-group">
						<label for="title"> Name </label>
						<!--  <input type="text" class="form-control" name="name" id="name" placeholder="Name of contact person" value="" required /> -->
						<form:input path="contactName" cssClass="form-control" placeholder="Name of contact person" required="required" />
						<form:errors path="contactName" cssClass="has-error" />
					</div>


					<div class="form-group">
						<label for="address">Address</label>
						<!-- <textarea class="form-control" rows="3" name="address" id="address" placeholder="Your Address"></textarea> -->
						<form:textarea path="address" cssClass="form-control" rows="3" placeholder="Your Address" />
						<form:errors path="address" cssClass="has-error" />
					</div>

					<div class="form-group">
						<label for="tags">Home Phone</label>
						<!-- <input type="text" class="form-control" name="homephone" id="homephone" value="" /> -->
						<form:input path="homePhone" cssClass="form-control" placeholder="Home Phone" />
						<form:errors path="homePhone" cssClass="has-error" />
					</div>

					<div class="form-group">
						<label for="tags"> Mobile </label>
						<!-- <input type="text" class="form-control" name="mobile" id="mobile" value="" /> -->
						<form:input path="mobile" cssClass="form-control" placeholder="Mobile" />
						<form:errors path="mobile" cssClass="has-error" />
					</div>

					<div class="form-group">
						<label for="tags"> Email </label>
						<!-- <input type="email" class="form-control" name="email" id="email" placeholder="Email Address" value="" />  -->
						<form:input path="email" type="email" cssClass="form-control" placeholder="Email Address" />
						<form:errors path="email" cssClass="has-error" />
					</div>

					<div class="form-group">
						<label for="address">Note</label>
						<!--  <textarea class="form-control" rows="3" name="note" id="note" placeholder="Extra note if any"></textarea> -->
						<form:textarea path="info" cssClass="form-control" rows="3" placeholder="Extra note if any" />
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

