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
    <title>Public - MyApp</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <link rel="stylesheet" href="${contextPath}/style/main.css">
</head>
<body>
<jsp:include page="incl/header.jsp" />
<main class="container">
    <h1>Page Layout (Default)</h1>
    <div class="jumbotron">
        <h1>Public Page 🌍</h1>
        <p> Praesent sodales sit amet arcu sit amet elementum. Sed laoreet lectus ex, eu ultrices nisi congue non. Donec scelerisque nisi a diam mollis vestibulum. Curabitur volutpat eu massa at posuere. Maecenas luctus, dui ac vestibulum tempor, sapien leo lobortis urna, tempor pulvinar ante nisi vitae orci. Praesent lacus leo, semper eu tincidunt non, sollicitudin in diam. Praesent maximus congue ligula at pellentesque. Vivamus ut consequat dolor. Sed venenatis justo vitae velit accumsan, et condimentum erat euismod. Suspendisse sagittis ultricies condimentum. Donec iaculis rutrum viverra. </p>
        <p><a class="btn btn-primary btn-lg" href="${contextPath}/login.do" role="button">Log in to view more!</a></p>
    </div>
</main>
<!-- /container -->
<jsp:include page="incl/footer.jsp" />
</body>
</html>