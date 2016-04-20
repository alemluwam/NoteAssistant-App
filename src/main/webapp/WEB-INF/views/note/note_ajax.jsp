<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:forEach items="${notes}" var="note" varStatus="count">
	<div class="panel panel-success show100">
		<div class="panel-heading">
			<h4>
				 ${count.count}. <span style="padding:2px;background-color:${note.section.theme};"><c:out value="${note.section.sectionName}" /></span> | <c:out value="${note.title}" /> 
			</h4>
		</div>
		<div class="panel-body">
			<p class="small" style="color:#337AB7;">
			<c:out value="${note.link}" />
			<span class="pull-right bg-warning">&nbsp;<fmt:formatDate type="both" value="${note.modifiedDate}" timeStyle="short" /> 
			&nbsp;
			<a href="${pageContext.request.contextPath}/note/${note.noteId}">
				<button class="btn btn-cicle btn-xs btn-info">Upd</button>
			</a>
			<button class="btn btn-cicle btn-xs btn-danger" onclick="doDelete(${note.noteId})">Del</button>
			</span>
			</p>
			<hr/>
			<c:out value="${note.content}" />
		</div>
	</div>
</c:forEach>