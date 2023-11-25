<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
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
    <main class="container">
        <h1 class="sr-only">Home</h1>
    </main>
    <!-- /container -->
    <jsp:include page="/incl/footer.jsp" />
</body>
</html>