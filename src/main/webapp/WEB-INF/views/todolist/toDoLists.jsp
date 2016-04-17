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
<title>Insert title here</title>
</head>
<body>
	<table class="table table-hover table-striped table-condensed">
		<thead>
			<tr>
				<th>Title</th>
				<th>Description</th>
				<th colspan="3"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${toDoLists}" var="toDoList">
				<tr>
					<td><c:out value="${toDoList.title}" /></td>
					<td><c:out value="${toDoList.description}" /></td>
					<td><a
						href='<spring:url value="/todolists/${toDoList.toDoListId}"/>'><button
								class="btn btn-xs btn-default">
								<span class="glyphicon glyphicon-edit"></span>
							</button></a></td>
					<td>
						<form:form method="DELETE">
						
						
						
						<button type="submit"
							class="btn btn-cicle btn-xs btn-danger triggerRemove"
							href="/todolists/delete/${toDoList.toDoListId}">x</button>
						
						</form:form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>