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
<title>Companies - MyApp</title>
<jsp:include page="/incl/styles.jsp" />
</head>

<body>
    <jsp:include page="/incl/header.jsp" />
    <main class="container">
        <h1>${form.newCompany ? 'New' : 'Update'} Company ${form.newCompany ? '' : form.name}</h1>
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
                <form id="company-save-fome" action="${contextPath}/company/save.do" method="POST">
                    <input type="hidden" name="action" value="submit" />
                    <input type="hidden" name="formInit" value="${form.formInit}" />
                    <input type="hidden" id="company-id" name="companyId" value="${form.companyId}" />
                    <input type="hidden" id="company-original-name" name="originalName" value="${form.originalName}" />

                    <div class="form-group ${actionErrors.get('name').hasNext() ? 'has-error' : (validated ? 'has-success' : '')}">
                        <label for="company-name">Name</label>
                        <input id="company-name" type="text" class="form-control" name="name" value="${form.name}" placeholder="Name" aria-label="Name" maxlength="100" required />
                        <div class="help-block">
                            <html:errors property="name" />
                        </div>
                    </div>

                    <div class="form-group ${actionErrors.get('address').hasNext() ? 'has-error' :  (validated ? 'has-success' : '')}">
                        <label for="company-address">Address</label>
                        <input id="company-address" type="address" class="form-control" name="address" value="${form.address}" placeholder="Address" aria-label="Address" maxlength="100" required />
                        <div class="help-block">
                            <html:errors property="address" />
                        </div>
                    </div>
                    
                     <div class="form-group ${actionErrors.get('vatNumber').hasNext() ? 'has-error' :  (validated ? 'has-success' : '')}">
                        <label for="company-vatNumber">Email</label>
                        <input id="company-vatNumber" type="vatNumber" class="form-control" name="vatNumber" value="${form.vatNumber}" placeholder="VATNumber" aria-label="VATNumber" maxlength="100" required />
                        <div class="help-block">
                            <html:errors property="vatNumber" />
                        </div>
                    </div>

                    <div class="form-group ${actionErrors.get('country').hasNext() ? 'has-error' :  (validated ? 'has-success' : '')}">
                        <label for="company-country">Country</label>
                        <select class="form-control" id="company-country" name="countryId" required>
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
                        <label for="company-city">City</label>
                        <select class="form-control" id="company-city" name="cityId" required ${(form.countryId eq null or form.countryId eq 0) ? 'disabled' : ''}>
                            <option value="" hidden>Choose a city</option>
                            <c:forEach var="city" items="${cities}">
                                <option value="${city.id}" ${form.cityId eq city.id ? 'selected' : ''}>${city.name}</option>
                            </c:forEach>
                        </select>
                        <div class="help-block">
                            <html:errors property="city" />
                        </div>
                    </div>

                    <a class="btn btn-default" href="${contextPath}/companies.do">Back</a>
                    <button type="submit" class="btn btn-default btn-validate">Validate</button>
                    <button type="submit" class="btn btn-success btn-save">Save</button>
                </form>
            </div>
        </div>
    </main>
    <!-- /container -->
    <jsp:include page="/incl/footer.jsp" />
    <script src="${contextPath}/js/service/city-service.js"></script>
    <script src="${contextPath}/company/save/js/form.js"></script>
</body>
</html>