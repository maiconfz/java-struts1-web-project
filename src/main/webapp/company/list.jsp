<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Users - MyApp</title>
<jsp:include page="/incl/styles.jsp" />
</head>
<body>
    <jsp:include page="/incl/header.jsp" />
    <main class="container">
        <h1>Companies</h1>
        <c:choose>
            <c:when test="${actionMessages.get('topMsgs').hasNext()}">
                <div class="alert alert-success" role="alert">
                    <i class="fa fa-check-circle" aria-hidden="true"></i> <span class="sr-only">Success:</span>
                    <html:messages id="msg" message="true">
                        <bean:write name="msg" filter="false" />
                    </html:messages>
                </div>
            </c:when>
            <c:when test="${actionErrors.get('topMsgs').hasNext()}">
                <div class="alert alert-danger" role="alert">
                    <i class="fa fa-exclamation-circle" aria-hidden="true"></i> <span class="sr-only">Error:</span>
                    <html:errors property="topMsgs" />
                </div>
            </c:when>
        </c:choose>
        <table class="table table-hover">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Username</th>
                    <th>Email</th>
                    <th>Country</th>
                    <th>City</th>
                    <th class="text-right">Actions</th>
                </tr>
            </thead>
            <tbody>
              <tr><td>${companies}</td></tr>
            </tbody>
        </table>
        <a class="btn btn-primary" href="${contextPath}/campony/save.do" title="Create new company">New</a>
    </main>
    <!-- /container -->
    <jsp:include page="/incl/footer.jsp" />
</body>
</html>