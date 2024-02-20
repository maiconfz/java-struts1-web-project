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
    <title>Private - MyApp</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <link rel="stylesheet" href="${contextPath}/style/main.css">
</head>
<body>
<jsp:include page="incl/header.jsp" />
<main class="container">
    <h1>Page Layout (Default)</h1>
    <div class="jumbotron">
        <h1>This is a private page 🔐</h1>
        <p>Curabitur bibendum suscipit tellus eu congue. Proin venenatis justo a lectus finibus condimentum. Praesent fringilla mauris sed nulla dapibus tristique. Nulla facilisi. Sed malesuada, mi ut aliquet vestibulum, nunc arcu dignissim diam, ut laoreet lectus dolor quis neque. Sed faucibus consectetur urna sit amet consequat. Praesent a ligula dignissim, euismod purus vitae, venenatis leo. Quisque feugiat vehicula ultricies. Etiam tempus lacus at ligula ultrices condimentum. Mauris accumsan sodales risus a condimentum. Vestibulum vel turpis eget tortor porta lobortis. </p>
    </div>
</main>
<!-- /container -->
<jsp:include page="incl/footer.jsp" />
</body>
</html>