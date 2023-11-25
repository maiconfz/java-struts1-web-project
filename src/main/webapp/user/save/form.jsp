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
        <h1>${empty form.newUser ? 'New ' : 'Edit '}User ${empty form.newUser ? '' : form.username}</h1>
        <c:if test="${actionErrors.get('form').hasNext()}">
            <div class="alert alert-danger" role="alert">
                <i class="fa fa-exclamation-circle" aria-hidden="true"></i> <span class="sr-only">Error:</span>
                <html:errors property="form" />
            </div>
        </c:if>
        <div class="row">
            <div class="col-xs-12 col-md-4">
                <form id="user-save-fome" action="${contextPath}/user/save.do" method="POST">
                    <input type="hidden" name="action" value="submit" />
                    <input type="hidden" name="formInit" value="${form.formInit}" />
                    <input type="hidden" name="userId" value="${form.userId}" />
                    <div class="form-group ${actionErrors.get('username').hasNext() ? 'has-error' : (validated ? 'has-success' : '')}">
                        <label for="user-username">Username</label> <input id="user-username" type="text" class="form-control" name="username" value="${form.username}" placeholder="Username" aria-label="Username" maxlength="100" />
                        <div class="help-block">
                            <html:errors property="username" />
                        </div>
                    </div>
                    <div class="form-group ${actionErrors.get('password').hasNext() ? 'has-error' :  (validated ? 'has-success' : '')}">
                        <label for="user-password">Password</label> <input id="user-password" type="password" class="form-control" name="password" placeholder="Password" aria-label="Password" maxlength="100" />
                        <div class="help-block">
                            <html:errors property="password" />
                        </div>
                    </div>
                    <button type="submit" class="btn btn-success btn-save">Save</button>
                    <button type="submit" class="btn btn-default btn-validate">Validate</button>
                </form>
            </div>
        </div>
    </main>
    <!-- /container -->
    <jsp:include page="/incl/footer.jsp" />
    <script src="${contextPath}/user/save/js/form.js"></script>
</body>
</html>