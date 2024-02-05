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
<title>Private Page  - MyApp</title>
<jsp:include page="/incl/styles.jsp" />
</head>
<body>
    <jsp:include page="/incl/header.jsp" />
    <main class="container text-center">

        <p>Página Privada</p>

		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">Panel Privado de Usuario</h3>
			</div>
			<div class="panel-body">Dados de Usuário</div>

			<ul class="list-group">
				<li class="list-group-item">Nome: <span
					class="badge badge-primary"><i class="fa fa-check"
						aria-hidden="true"></i> </span> ${username}
				</li>
				<li class="list-group-item">Email: <span
					class="badge badge-primary"><i class="fa fa-check"
						aria-hidden="true"></i> </span> admin@admin.com
				</li>
			</ul>


		</div>

	</main>
    <!-- /container -->
    <jsp:include page="/incl/footer.jsp" />
</body>
</html>