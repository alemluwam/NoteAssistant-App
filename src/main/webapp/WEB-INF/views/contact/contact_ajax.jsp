<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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