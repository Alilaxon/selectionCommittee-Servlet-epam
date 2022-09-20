<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="localization"/>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 13.09.2022
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE>
<html lang="en">
<head>
    <title>Statements</title>
    <%@include file="/jsp/parts/bootstrap.jsp" %>

</head>
<body>
<div class="container">
    <h1>

    <c:if test="${sessionScope.lang == 'en'}">
        <p>
            <fmt:message key="faculties.name"/>:${faculty.getFacultyName()}
        </p>
    </c:if>

    <c:if test="${sessionScope.lang == 'ru'}">
        <p>
            <fmt:message key="faculties.name"/>:${faculty.getFacultyNameRU()}
        </p>
    </c:if>
    </h1>

    <table class="table table-bordered">
        <tr>
            <th>
                <span><fmt:message key="statements.id"/></span>
            </th>
            <th>
                <span><fmt:message key="statements.username"/></span>
            </th>
            <th>
                <span><fmt:message key="statements.firstname"/></span>
            </th>
            <th>
                <span><fmt:message key="statements.surname"/></span>
            </th>
            <th>
                 <form method="get" action="/statements">


                    <c:if test="${order == 'desc'}">
                <button type="submit" >
                    <fmt:message key="statements.gradePointAverage"/>
                        <input type="hidden" name="facultyId" value="${faculty.id}">
                        <input type="hidden" name="page" value="${page}">
                        <input type="hidden" name="sort" value="gradePointAverage">
                        <input type="hidden" name="order" value="asc">
                        </button>
                    </c:if>

                     <c:if test="${order == 'asc'}">
                <button type="submit">
                    <input type="hidden" name="facultyId" value="${faculty.id}">
                    <input type="hidden" name="page" value="${page}">
                    <input type="hidden" name="sort" value="gradePointAverage">
                    <input type="hidden" name="order" value="desc">
                    <fmt:message key="statements.gradePointAverage"/></button>
                    </c:if>

                 </form>
            </th>
            <th>
                   <form method="get" action="/statements">
                    <c:if test="${order == 'desc'}">
                    <button type="submit">
                        <fmt:message key="statements.position"/>
                    <input type="hidden" name="facultyId" value="${faculty.id}">
                    <input type="hidden" name="page" value="${page}">
                    <input type="hidden" name="sort" value="position">
                    <input type="hidden" name="order" value="asc">
                    </button>
                    </c:if>

                    <c:if test="${order == 'asc'}">
                <button type="submit">
                    <fmt:message key="statements.position"/>
                    <input type="hidden" name="facultyId" value="${faculty.id}">
                    <input type="hidden" name="page" value="${page}">
                    <input type="hidden" name="sort" value="position">
                    <input type="hidden" name="order" value="desc">
                    </button>
                        </c:if>
            </th>

        </tr>
<c:forEach var="statement" items="${statements}">
        <tbody th:each="statement : ${statements}">

        <th>${statement.getId()}</th>
        <td th:text="${statement.userId.getUsername()}">${statement.userId.getUsername()}</td>
        <td th:text="${statement.userId.getFirstname()}">${statement.userId.getFirstname()}</td>
        <td th:text="${statement.userId.getSurname()}">${statement.userId.getSurname()}</td>
        <td th:text="${statement.getGradePointAverage()}">${statement.getGradePointAverage()}</td>
        <td th:text="${statement.position.positionType.name()}">${statement.position.positionType.name()}</td>

        </tbody>
</c:forEach>
        <h2>

            <a class="btn btn-primary" href="/faculties">
                <fmt:message key="faculties.back"/>
            </a>
        </h2>
    </table>
</div>
</body>
</html>
