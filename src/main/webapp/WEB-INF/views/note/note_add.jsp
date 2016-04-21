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

    <title>NoteAssistant 2016 | Note</title>

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
            background-color: #77ab59;
        }
    </style>
</head>

<body>

    <!-- Navigation -->
    <%@ include file="../common/nav_menu_note.jsp" %>

    <!-- Page Content -->
    <div class="container">
        <div class="row">

            <div class="col-md-3">
                <p class="lead">Note</p>
                <div class="list-group">
                    <a href="${pageContext.request.contextPath}/note" class="list-group-item">Note</a>
                    <a href="${pageContext.request.contextPath}/note/add" class="list-group-item active">Add New Note</a>
                </div>
            </div>

            <div class="col-md-9">

                <div class="jumbotron">
                    <h2><span class="glyphicon glyphicon-list-alt"></span> Note</h2> 
				</div>
			
			<form:form modelAttribute="newNote" cssClass="form">
				
				<div class="well">
                    <div class="row">
                        <div class="col-md-12">
                            <span class="glyphicon glyphicon-star"></span>
                            Add important note for your reference.
                            <span class="pull-right">&nbsp;</span>
                        </div>
                    </div>
                </div>
				
				<div class="form-group">
					<label for="title">
						Title
					</label>
					<!-- <input type="text" class="form-control" name="title" id="title" placeholder="Title of the note" value="" required /> -->
					<form:input path="title" cssClass="form-control" placeholder="Title of the note" required="required" />
					<form:errors path="title" cssClass="has-error" />
				</div>
				
				<div class="form-group">
					<label for="content">Content</label>
					<!-- <textarea class="form-control" rows="10" name="content" id="content" placeholder="Content of the note" required></textarea>  -->
					<form:textarea path="content" cssClass="form-control" rows="10" placeholder="Content of the note" required="required" />
					<form:errors path="content" cssClass="has-error" />
				</div>
				
				<!-- 
				<div class="form-group">
					<label for="tags">
						Tags
					</label>
					<input type="text" class="form-control" name="tags" id="tags" value="" />
				</div>
				 -->
				
				<div class="form-group">
					<label for="remark">
						Remark
					</label>
					<!-- <input type="text" class="form-control" name="remark" id="remark" value="" />  -->
					<form:input path="remark" cssClass="form-control" placeholder="Remark" />
					<form:errors path="remark" cssClass="has-error" />
				</div>
				
				<div class="form-group">
					<label for="link">
						Link
					</label>
					<!-- <input type="url" class="form-control" name="link" id="link" placeholder="URL of note (if any)" value="" />  -->
					<form:input type="url" path="link" cssClass="form-control" placeholder="URL of note (if any)" />
				</div>
				
				<!-- <div class="form-group">
					<label for="section">Section</label>
					<select class="form-control" name="section" id="section">
						<option value="1">Section A</option>
					</select>
				</div>  -->
					
				<div class="form-group">
				<label for="section">Section</label>
				<form:select cssClass="form-control" path="section">
					<%-- <form:option value="-" label="--Please Select --"/> --%>
					<form:options items="${sections}" itemValue="sectionId" itemLabel="sectionName"/>
				</form:select>
				</div>
					
				<div class="text-right">
					<button type="submit" class="btn-lg btn-primary">
						Save
					</button>
					<button type="reset" class="btn-lg btn-success">
						Clear
					</button>
				</div>
			</form:form>
		</div>
	</div> <!-- /.row -->
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