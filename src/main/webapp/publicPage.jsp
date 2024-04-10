<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/incl/styles.jsp" />
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>My Public Page - MyApp</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<link rel="stylesheet" href="${contextPath}/style/main.css">
</head>
<body>
    <jsp:include page="/incl/header.jsp" />
    <main class="container text-center">
        <h1 class="sr-only">Page Public</h1>
        <h2>Welcome to My Public Page</h2>
        <h3>Top 20 Most Popular Programming Languages in 2024 & Beyond</h3>
        <div class="row">
            <div class="col-xs-12 text-center">
				<ul class="list-group">
				  <li class="list-group-item">Python</li>
				  <li class="list-group-item">Java</li>
				  <li class="list-group-item">JavaScript</li>
				  <li class="list-group-item">C/C++</li>
				  <li class="list-group-item">C#</li>
				</ul>
            </div>
        </div>
    </main>
    <!-- /container -->
    <jsp:include page="/incl/footer.jsp" />
</body>
</html>