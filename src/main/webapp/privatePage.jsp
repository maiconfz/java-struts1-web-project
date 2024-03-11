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
<title>MyApp</title>
<jsp:include page="/incl/styles.jsp" />
</head>
<body>
	<jsp:include page="/incl/header.jsp" />
	<main class="container">
	<div class="row">
		<div class="col-xs-12 col-sm-6 col-md-6">
			<div class="well well-sm">
				<div class="row">
					<div class="col-sm-6 col-md-4">
						<img src="${contextPath}/img/aac.PNG" alt=""
							class="img-rounded img-responsive" />
					</div>
					<div class="col-sm-6 col-md-8">
						<h4> Cahango André</h4>
						<small><cite title="San Francisco, USA"> Luanda,
								Angola <i class="glyphicon glyphicon-map-marker"> </i>
						</cite></small>
						<p>
							<i class="glyphicon glyphicon-envelope"></i> misterdel04@hotmail.com.com
							<br /> <i class="glyphicon glyphicon-gift"></i> 04 de Fevereiro
							de 1994
						</p>
						<!-- Split button -->
						<div class="btn-group">
							<button type="button" class="btn btn-primary">Social</button>
							<button type="button" class="btn btn-primary dropdown-toggle"
								data-toggle="dropdown">
								<span class="caret"></span><span class="sr-only">Social</span>
							</button>
							<ul class="dropdown-menu" role="menu">
								<li><a href="#">Twitter</a></li>
								<li><a href="#">Google +</a></li>
								<li><a href="#">Facebook</a></li>
								<li><a href="#">Instagram</a></li>
								<li class="divider"></li>
								<li><a href="#">Github</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</main>
	<!-- /container -->
	<jsp:include page="/incl/footer.jsp" />
</body>
</html>

