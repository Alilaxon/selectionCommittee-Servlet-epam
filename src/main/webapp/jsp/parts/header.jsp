<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="localization"/>

<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 13.09.2022
  Time: 23:16
  To change this template use File | Settings | File Templates.
--%>
<div class="container"
     xmlns:sec="http://www.w3.org/1999/xhtml">
    <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4">

        <div class="col-md-3 text-start">
            <a><fmt:message key="lang.current"/>
            </a>
            <a class="btn btn-primary" href="?lang=ru">
                <fmt:message key="lang.ru"/>
            </a>
            <a class="btn btn-primary" href="?lang=en" >
                <fmt:message key="lang.en"/>
            </a>
        </div>


        <ul class="nav col-12 col-md-auto mb-2 justify-content-center">
            <li>
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/users">
                    <fmt:message key="main.users"/>
                </a>
            </li>
            <li>
                <a class="btn btn-primary"
                   href="${pageContext.request.contextPath}/subjects" >
                    <fmt:message key="main.subjects"/>
                </a>
            </li>
            <li>
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/faculties" >
                    <fmt:message key="main.faculties"/>
                </a>
            </li>
        </ul>
        <div class="col-md-3 text-end">
<%--            <a class="btn btn-info"--%>
<%--               style="color: white"--%>
<%--               sec:authorize="hasAuthority('ADMIN')"--%>
<%--               sec:authentication="name"--%>
<%--               th:href="@{'/admin?id=' + ${#authentication.getPrincipal().getId()}}">--%>
<%--            </a>--%>
         <c:if test="${sessionScope.role == 'USER'}">
             <form method="get" action="/user">
            <button type="submit" class="btn btn-info">${sessionScope.user.getUsername()}
                <input type="hidden" name="userId" value="${sessionScope.userId}">
            </button>
             </form>
             <a class="btn btn-primary"

                href="/logout">
                 <fmt:message key="main.logout"/>
             </a>
            </c:if>

             <c:if test="${sessionScope.role == null}">
            <a class="btn btn-primary"
               href="${pageContext.request.contextPath}/registration">
                <fmt:message key="main.registration"/>
            </a>

            <a class="btn btn-primary"
               href="/login">
                <fmt:message key="main.login"/>
            </a>
             </c:if>

        </div>


    </header>
</div>
