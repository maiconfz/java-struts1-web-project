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
        <h1 class="sr-only">Private Page</h1>
        <h2>Welcome to My Private Page</h2>
        <div class="row">
			<div class="col-xs-6 text-center">
				<div class="panel panel-default">
					<!-- Default panel contents -->
					<div class="panel-heading">#1 PYTHON</div>
					<div class="panel-body">
						<p>
							Landed at No.1 on the PYPL chart as the most popular programming language, Python accounts for 28.11% of the market share, making it the most used programming language in 2024, although it has been around for almost three decades. Python, developed by Guido van Rossum in 1989, is a general-purpose programming language that is widely used in web app development, data science, artificial intelligence (AI), scientific computing, machine learning, etc.
						</p>
					</div>

					<!-- List group -->
					<ul class="list-group">
						<li class="list-group-item">Where can I get some?</li>
						<li class="list-group-item">Why do we use it?</li>
						<li class="list-group-item">What is Lorem Ipsum?</li>
					</ul>
				</div>
			</div>
			
			<div class="col-xs-6 text-center">
				<div class="panel panel-default">
					<!-- Default panel contents -->
					<div class="panel-heading">#2 JAVA</div>
					<div class="panel-body">
						<p>
							Java, created by James Gosling in 1995, has long been one of the most popular programming languages in the world, and it holds the second position on the PYPL chart with a market share of 15.52%. Java is a general-purpose, platform-independent, and object-oriented programming language that enables developers to create robust and high-performance applications.
						</p>
					</div>

					<!-- List group -->
					<ul class="list-group">
						<li class="list-group-item">Where can I get some?</li>
						<li class="list-group-item">Why do we use it?</li>
						<li class="list-group-item">What is Lorem Ipsum?</li>

					</ul>
				</div>
			</div>
		</div>
    </main>
    <!-- /container -->
    <jsp:include page="/incl/footer.jsp" />
</body>
</html>