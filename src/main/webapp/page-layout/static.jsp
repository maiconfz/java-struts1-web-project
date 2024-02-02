<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Static <c:if test="${isLoggedIn eq true}">Logged in</c:if></title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<link rel="stylesheet" href="${contextPath}/style/main.css">
</head>
<body>
    <jsp:include page="../incl/header.jsp" />
    <main class="container">
    	<ol class="breadcrumb">
    		<li><a href="${contextPath}/">My App</a></li>
    		<li class="active">Static <c:if test="${isLoggedIn eq true}">Logged in</c:if></li>
    	</ol>
        <h1>Static <c:if test="${isLoggedIn eq true}"><small>Logged In</small></c:if></h1>
        <p>Nam tincidunt placerat tortor. Praesent vehicula tempus nisl quis rhoncus. Etiam a gravida ipsum, ac venenatis metus. Nulla velit velit,
        feugiat ac ipsum vitae, rutrum vestibulum nisi. Praesent mattis consequat urna sed vehicula. Integer ut luctus libero. Proin quis sagittis mi.
        Aenean commodo est diam, non vehicula eros elementum a. Phasellus ut velit massa. Phasellus et bibendum lorem. Morbi consectetur, metus vulputate
        convallis efficitur, nunc odio mattis nunc, vitae volutpat orci eros nec ligula. Nulla in laoreet est, id commodo tellus. Morbi id dui vel nunc
        eleifend ultricies.</p>
        
        <div class="progress">
			<div id="progress" class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100" style="width: 0">
    			<span class="sr-only">0% Complete</span>
  			</div>
		</div>
		<button type="button" class="btn btn-primary" id="click">Click Me!</button>
    </main>
    <!-- /container -->
    <jsp:include page="../incl/footer.jsp" />
    <script src="${contextPath}/js/static.js"></script>
</body>
</html>