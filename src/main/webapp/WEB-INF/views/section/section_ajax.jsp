<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<table class="table table-hover table-striped table-condensed">
	<thead>
		<tr>
			<th><a href="#" onclick="doList('id')">ID</a></th>
			<th><a href="#" onclick="doList('name')">Section Name</a></th>
			<th><a href="#" onclick="doList('theme')">Section Theme</a></th>
			<th>&nbsp;</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${sections}" var="section">
			<tr>
				<td><c:out value="${section.sectionId}" /></td>
				<td><c:out value="${section.name}" /></td>
				<td><c:out value="${section.theme}" /></td>
				<td>
					<a href="${pageContext.request.contextPath}/section/${section.sectionId}">
					<button class="btn btn-cicle btn-xs btn-info">U</button>
					</a>
					<button class="btn btn-cicle btn-xs btn-danger" onclick="doDelete(${contact.contactId})">D</button>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>