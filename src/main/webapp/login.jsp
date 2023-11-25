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
<title>Login - MyApp</title>
<jsp:include page="/incl/styles.jsp" />
</head>
<body>
    <jsp:include page="./incl/header.jsp" />
    <main class="container">
        <div id="loginbox" style="margin-top: 50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <div class="panel-title">Login</div>
                </div>
                <div class="panel-body">
                    <div class="alert alert-danger col-sm-12" hidden></div>
                    <form id="loginform" action="${contextPath}/login.do" method="POST">
                        <input type="hidden" name="action" value="submit" />

                        <div class="form-group ${actionErrors.get('username').hasNext() ? 'has-error' : (validated ? 'has-success' : '')}">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                <input id="login-username" type="text" class="form-control" name="username" value="${form.username}" placeholder="Username" aria-label="Username" />
                            </div>
                            <div class="help-block">
                                <html:errors property="username" />
                            </div>
                        </div>

                        <div class="form-group ${actionErrors.get('password').hasNext() ? 'has-error' :  (validated ? 'has-success' : '')}">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                <input id="login-password" type="password" class="form-control" name="password" placeholder="Password" aria-label="Password" />
                            </div>
                            <div class="help-block">
                                <html:errors property="password" />
                            </div>
                        </div>

                        <button type="submit" id="btn-login" class="btn btn-success">Login</button>

                        <hr />

                        <a href="#">Create account</a>
                    </form>
                </div>
            </div>
        </div>
    </main>
    <!-- /container -->
    <jsp:include page="./incl/footer.jsp" />
</body>
</html>