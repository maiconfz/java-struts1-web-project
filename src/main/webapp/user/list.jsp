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
    <jsp:include page="../incl/header.jsp" />
    <main class="container">
        <h1>Users</h1>
        <logic:messagesPresent message="true">
            <div class="alert alert-success" role="alert">
                <i class="fa fa-check-circle" aria-hidden="true"></i> <span class="sr-only">Success:</span>
                <html:messages id="msg" message="true">
                    <bean:write name="msg" filter="false" />
                </html:messages>
            </div>
        </logic:messagesPresent>
        <logic:messagesPresent message="false">
            <div class="alert alert-danger" role="alert">
                <i class="fa fa-exclamation-circle" aria-hidden="true"></i> <span class="sr-only">Error:</span>
                <html:errors />
            </div>
        </logic:messagesPresent>
        <table class="table table-hover">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th class="text-right">Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:choose>
                    <c:when test="${empty users}">
                        <tr>
                            <td colspan="3">No users</td>
                        </tr>
                    </c:when>
                    <c:otherwise>
                        <c:forEach items="${users}" var="user">
                            <tr>
                                <td>${user.id}</td>
                                <td>${user.username}</td>
                                <td class="text-right">
                                    <div class="btn-group" role="group" aria-label="...">
                                        <a href="${contextPath}/user/user-save.do?userId=${user.id}" class="btn btn-sm btn-default" title='Edit user "${user.username}"'><i class="fa fa-pencil" aria-hidden="true"></i></a>
                                        <a href="${contextPath}/user/user-delete.do?userId=${user.id}" class="btn btn-sm btn-danger" title='Delete user "${user.username}"'><i class="fa fa-times" aria-hidden="true"></i></a>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
            </tbody>
        </table>
        <a class="btn btn-primary" href="${contextPath}/user/user-save.do" title="Create new user">New</a>
    </main>
    <!-- /container -->
    <jsp:include page="../incl/footer.jsp" />
</body>
</html>