<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header>
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${contextPath}/">MyApp</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Page Layouts<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="${contextPath}/page-layout/default.jsp">Default</a></li>
                            <li><a href="${contextPath}/page-layout/with-sidebar.jsp">With sidebar</a></li>
                            <li><a href="${contextPath}/page-layout/full-width-fluid.jsp">Full-width fluid</a></li>
                        </ul>
                    </li>
                    
                    
                    
                    <!-- alteração para exercicio 3 páginaa pública estática E página privada -->
                     <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Static Page<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="${contextPath}/public.do">Public  Page</a></li>
                            
                            
                            <!-- verifica se existe usuario logado para exibir o link para a página privada -->
                             <c:if test="${isLoggedIn eq true}">
                             
                             	<li><a href="${contextPath}/private.do">Private Page</a></li>
                             
                             </c:if>
             
                        </ul>
                    </li>
                                      
                    <!-- alteração para exercicio 6 -->
                    <c:if test="${isLoggedIn eq true}">
                        <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Manage <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="${contextPath}/users.do">Users</a></li>
                                
                              <!--  incluído item para gerenciamento de nova entidade do sistema companies -->
                                <li><a href="${contextPath}/companies.do">Companies</a></li>
                           
                            </ul>
                       </li>
                    </c:if>
                    
                    
                    <li class="${isLoggedIn eq true ? 'dropdown' : ''}">
                    <c:choose>
                            <c:when test="${isLoggedIn eq true}">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Hello, ${username} <span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="${contextPath}/logout.do">Logout</a></li>
                                </ul>
                            </c:when>
                            <c:otherwise>
                                <a href="${contextPath}/login.do">Login</a>
                            </c:otherwise>
                        </c:choose>
                    </li>
                    
                    
                    
                </ul>
            </div>
        </div>
    </nav>
</header>