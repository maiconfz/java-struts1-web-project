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
<title>Last News - MyApp</title>
<jsp:include page="/incl/styles.jsp" />
</head>
<body>
    <jsp:include page="/incl/header.jsp" />
    <main class="container text-center">
    	<div class="col-12">
	        <h1 class="sr-only">Last News</h1>    	
    	</div>
    	<div class="row gx-5">
    		<div class="col-12 col-md-6">
    			<h3>Lisbon</h3>
    			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ac augue eu leo posuere hendrerit nec vel sapien. Pellentesque a ipsum hendrerit, elementum lectus eget, convallis enim. Phasellus sit amet sollicitudin nisl. Suspendisse ac placerat nibh. Suspendisse non pellentesque lectus. Vivamus pulvinar faucibus neque, sed vulputate libero commodo at. Morbi sed placerat diam. Nullam vestibulum iaculis ante, nec rhoncus ligula efficitur ac. Integer vel risus tortor. Morbi laoreet blandit cursus. Nulla venenatis leo ut risus luctus aliquet. Etiam ut rhoncus risus. Phasellus purus lorem, convallis et varius sed, auctor eu felis. Mauris feugiat metus id quam sodales suscipit. Curabitur id rhoncus metus.</p>
    			<p class="secodary-color"> updated 21/01/2024</p>
    			<a href="#" class="btn"> More</a>
    		</div>
    		<div class="col-12 col-md-6">
    			<h3>Porto</h3>
    			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ac augue eu leo posuere hendrerit nec vel sapien. Pellentesque a ipsum hendrerit, elementum lectus eget, convallis enim. Phasellus sit amet sollicitudin nisl. Suspendisse ac placerat nibh. Suspendisse non pellentesque lectus. Vivamus pulvinar faucibus neque, sed vulputate libero commodo at. Morbi sed placerat diam. Nullam vestibulum iaculis ante, nec rhoncus ligula efficitur ac. Integer vel risus tortor. Morbi laoreet blandit cursus. Nulla venenatis leo ut risus luctus aliquet. Etiam ut rhoncus risus. Phasellus purus lorem, convallis et varius sed, auctor eu felis. Mauris feugiat metus id quam sodales suscipit. Curabitur id rhoncus metus.</p>
    			<p class="secodary-color"> updated 22/01/2024</p>
    			<a href="#" class="btn"> More</a>
    		</div>
    	</div>
        
        
    </main>
    <!-- /container -->
    <jsp:include page="/incl/footer.jsp" />
</body>
</html>