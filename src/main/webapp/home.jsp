<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Home - MyApp</title>
<jsp:include page="/incl/styles.jsp" />
</head>
<body>
	<jsp:include page="/incl/header.jsp" />
	<main class="container text-center">
		<h1 class="sr-only">Home</h1>
		<h2>Welcome to MyApp</h2>
		<h3>Choose an area</h3>
		<div class="row">
			<div class="col-xs-12 text-center">
				<a class="btn btn-default btn-lg" href="${contextPath}/users.do"
					title="Go to users management area" style="font-size: 6rem"> <i
					class="fa fa-users" aria-hidden="true"></i><br /> <span
					style="font-size: 0.75em;">Users</span>
				</a>
				<a class="btn btn-default btn-lg" href="${contextPath}/companies.do"
					title="Go to companies management area" style="font-size: 6rem">
					 <span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>
					<br /> <span
					style="font-size: 0.75em;">Companies</span>
				</a>
			</div>

		</div>
	</main>
	<!-- /container -->
	<jsp:include page="/incl/footer.jsp" />
</body>
</html>