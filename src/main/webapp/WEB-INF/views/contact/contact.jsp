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

<title>NoteAssistant 2016 | Contact Detail</title>

<!-- Bootstrap Core CSS -->
<link href="<c:url value='resources/css/bootstrap.min.css'/>"
	rel="stylesheet">

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
					<a href="${pageContext.request.contextPath}/contact" class="list-group-item active">Contact List</a> <a
						href="${pageContext.request.contextPath}/contact/add" class="list-group-item">Add New Contact</a>
				</div>
			</div>

			<div class="col-md-9">
				<div class="jumbotron">
					<h2>Contact List</h2>
				</div>

				<div class="col-md-15">

					<form class="form-inline" role="form" id="xyz">
						<div class="form-group">
							<label for="search">Search</label>
							<input type="text" class="form-control input-lg" name="search" id="search" size="50" />
						</div>
						<div class="form-group">
							<select class="form-control input-lg" name="searchby" id="searchby">
								<option value="name">Name</option>
								<option value="address">Address</option>
								<option value="email">Email</option>
								<option value="phone">Phone or Cell</option>
							</select>
						</div>
						<button class="btn btn-lg btn-primary" onclick="doFind()">Search</button>
					</form>

					<hr />

					<div id="newdata">
						<table class="table table-hover table-striped table-condensed">
							<thead>
								<tr>
									<th><a href="#" onclick="doList('id')">ID</a></th>
									<th><a href="#" onclick="doList('name')">Name</a> <a href="#" onclick="doListD('name')"> &hearts; </a></th>
									<th><a href="#" onclick="doList('address')">Address</a></th>
									<th><a href="#" onclick="doList('phone')">Phone</a></th>
									<th><a href="#" onclick="doList('mobile')">Mobile</a></th>
									<th><a href="#" onclick="doList('email')">Email</a> <a href="#" onclick="doListD('name')"> &hearts; </a></th>
									<th>&nbsp;</th>
								</tr>
							</thead>

							<tbody>
								<c:forEach items="${contacts}" var="contact">
									<tr>
										<td><c:out value="${contact.contactId}" /></td>
										<td><c:out value="${contact.contactName}" /></td>
										<td><c:out value="${contact.address}" /></td>
										<td><c:out value="${contact.homePhone}" /></td>
										<td><c:out value="${contact.mobile}" /></td>
										<td><c:out value="${contact.email}" /></td>
										<td>
											<a href="${pageContext.request.contextPath}/contact/${contact.contactId}">
											<button class="btn btn-cicle btn-xs btn-info">Upd</button>
											</a>
											<button class="btn btn-cicle btn-xs btn-danger" onclick="doDelete(${contact.contactId})">Del</button>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
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

	<script>
		
		$('#xyz').submit(function(e){
	    	e.preventDefault();
		});
		
		function doFind() {
			
			var search  = $("#search").val();
			var searchby = $("#searchby option:selected").val();
			
			$.ajax({
				"type" : "POST",
				"data" : {
					search : search,
					searchby : searchby
				},
				"url" : "${pageContext.request.contextPath}/contact/find",
				"success" : function(msg) {
				}
			}).done(function(data) {
				$("#newdata").html(data);
			});
		}
		
		function doList(sortby) {
			$.ajax({
				"type" : "POST",
				"data" : {
					sort : sortby,
					order: "asc"
				},
				"url" : "${pageContext.request.contextPath}/contact/list",
				"success" : function(msg) {
				}
			}).done(function(data) {
				$("#newdata").html(data);
			});
		}
		
		function doListD(sortby) {
			$.ajax({
				"type" : "POST",
				"data" : {
					sort : sortby,
					order: "desc"
				},
				"url" : "${pageContext.request.contextPath}/contact/list",
				"success" : function(msg) {
				}
			}).done(function(data) {
				$("#newdata").html(data);
			});
		}
		
		function doDelete(id) {
			var r = confirm("Delete this contact?");
			if (r == true) {
				$.ajax({
					"type" : "POST",
					"url" : "${pageContext.request.contextPath}/contact/delete/"+id,
					"success" : function(msg) {
					}
				}).done(function(data) {
					$("#newdata").html(data);
				});
			} 
		}
	</script>

</body>
</html>