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

<div class="container-fluid">
		
<!-- Carousel container -->
<div id="my-pics" class="carousel slide" data-ride="carousel" style="width:800px;margin:auto;">

<!-- Indicators -->
<ol class="carousel-indicators">
<li data-target="#my-pics" data-slide-to="0" class="active"></li>
<li data-target="#my-pics" data-slide-to="1"></li>
<li data-target="#my-pics" data-slide-to="2"></li>
</ol>

<!-- Content -->
<div class="carousel-inner" role="listbox">

<!-- Slide 1 -->
<div class="item active">
<img src="${contextPath}/img/vista1.jpg" alt="Sunset over beach">
<div class="carousel-caption">
<h3>Teste Img 1</h3>
<p>teste imagen 1</p>
</div>
</div>

<!-- Slide 2 -->
<div class="item">
<img src="${contextPath}/img/vista1.jpg" alt="Rob Roy Glacier">
<div class="carousel-caption">
<h3>Teste Img2</h3>
<p>teste imagen 2</p>
</div>
</div>

<!-- Slide 3 -->
<div class="item">
<img src="${contextPath}/img/vista1.jpg" alt="Longtail boats at Phi Phi">
<div class="carousel-caption">
<h3>Teste Img3</h3>
<p>teste imagen 3</p>
</div>
</div>

</div>

<!-- Previous/Next controls -->
<a class="left carousel-control" href="#my-pics" role="button" data-slide="prev">
<span class="icon-prev" aria-hidden="true"></span>
<span class="sr-only">Previous</span>
</a>
<a class="right carousel-control" href="#my-pics" role="button" data-slide="next">
<span class="icon-next" aria-hidden="true"></span>
<span class="sr-only">Next</span>
</a>

</div>

</div>

	</main>
	<!-- /container -->
	<jsp:include page="/incl/footer.jsp" />
</body>

<script>
// Inicialização do componente tooltip
$(function () {
  $('[data-toggle="tooltip"]').tooltip()
})

// Inicialização do componente popover
$(function () {
  $('[data-toggle="popover"]').popover()
})
</script>
</html>