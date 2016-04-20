<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>ADD TODOLIST</title>
</head>
<body>
	<form:form modelAttribute="newToDoList" cssClass="form">
		<div class="form-group">
			<div class="col-sm-8">
				<label for="title" class="col-md-4 control-label">Title</label>
				<form:input path="title" cssClass="form-control input-sm" />
				<form:errors path="title" cssClass="has-error" />
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-8">
				<label for="description" class="col-md-4 control-label">Description</label>
				<form:textarea path="description" cssClass="form-control input-sm" />
				<form:errors path="description" cssClass="has-error" />
			</div>
		</div>
		<div class="form-group">
		  	<div class="col-sm-8">
		  		<input type="submit" value="Save" class="btn btn-lg btn-primary" />
		  	</div>
	  	</div>
	</form:form>
</body>
</html>