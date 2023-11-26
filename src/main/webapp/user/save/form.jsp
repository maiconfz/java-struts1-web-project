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
        <h1>${form.newUser ? 'New' : 'Update'} User ${form.newUser ? '' : form.username}</h1>
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
        <div class="row">
            <div class="col-xs-12 col-md-4">
                <form id="user-save-fome" action="${contextPath}/user/save.do" method="POST">
                    <input type="hidden" name="action" value="submit" />
                    <input type="hidden" name="formInit" value="${form.formInit}" />
                    <input type="hidden" id="user-id" name="userId" value="${form.userId}" />
                    <input type="hidden" id="user-original-username" name="originalUsername" value="${form.originalUsername}" />

                    <div class="form-group ${actionErrors.get('username').hasNext() ? 'has-error' : (validated ? 'has-success' : '')}">
                        <label for="user-username">Username</label>
                        <input id="user-username" type="text" class="form-control" name="username" value="${form.username}" placeholder="Username" aria-label="Username" maxlength="100" required />
                        <div class="help-block">
                            <html:errors property="username" />
                        </div>
                    </div>

                    <div class="form-group ${actionErrors.get('password').hasNext() ? 'has-error' :  (validated ? 'has-success' : '')}">
                        <label for="user-password">Password</label>
                        <input id="user-password" type="password" class="form-control" name="password" value="${form.password}" placeholder="Password" aria-label="Password" maxlength="100" required />
                        <div class="help-block">
                            <html:errors property="password" />
                        </div>
                    </div>

                    <div class="form-group ${actionErrors.get('country').hasNext() ? 'has-error' :  (validated ? 'has-success' : '')}">
                        <label for="user-country">Country</label>
                        <select class="form-control" id="user-country" name="countryId" required>
                            <option value="" hidden>Choose a country</option>
                            <c:forEach var="country" items="${countries}">
                                <option value="${country.id}" ${form.countryId eq country.id ? 'selected' : ''}>${country.name}</option>
                            </c:forEach>
                        </select>
                        <div class="help-block">
                            <html:errors property="country" />
                        </div>
                    </div>

                    <div class="form-group ${actionErrors.get('city').hasNext() ? 'has-error' :  (validated ? 'has-success' : '')}">
                        <label for="user-city">City</label>
                        <select class="form-control" id="user-city" name="cityId" required ${(form.countryId eq null or form.countryId eq 0) ? 'disabled' : ''}>
                            <option value="" hidden>Choose a city</option>
                            <c:forEach var="city" items="${cities}">
                                <option value="${city.id}" ${form.cityId eq city.id ? 'selected' : ''}>${city.name}</option>
                            </c:forEach>
                        </select>
                        <div class="help-block">
                            <html:errors property="city" />
                        </div>
                    </div>

                    <a class="btn btn-default" href="${contextPath}/users.do">Back</a>
                    <button type="submit" class="btn btn-default btn-validate">Validate</button>
                    <button type="submit" class="btn btn-success btn-save">Save</button>
                </form>
            </div>
        </div>
    </main>
    <!-- /container -->
    <jsp:include page="/incl/footer.jsp" />
    <script src="${contextPath}/js/service/city-service.js"></script>
    <script src="${contextPath}/user/save/js/form.js"></script>
</body>
</html>