<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/jsp/parts/bootstrap.jsp" %>
<%@include file="/jsp/parts/header.jsp"%>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 13.09.2022
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <table class="table table-bordered">
        <tr>
            <th>
                <span >  id</span>
            </th>
            <th>
                <span> <fmt:message key="users.name"/></span>
            </th>
            <th>
                <span> <fmt:message key="users.email"/></span>
            </th>
            <th>
                <span> <fmt:message key="users.status"/></span>
            </th>
            <th>
                <span> <fmt:message key="common.action"/></span>
            </th>
        </tr>
<c:forEach var="user" items="${users}">
        <tbody>

        <th>${user.getId()}</th>
        <td>${user.getUsername()}</td>
        <td>${user.getEmail()}</td>
        <td>${user.getBlocked()}</td>
        <td>
            <form method="POST" action="/blockUser">

                <input type="hidden" name="userId" value="${user.id}">
                <input type="hidden" name="userBlocked" value="${user.blocked}">
<c:if test="${user.getBlocked() == true}">
                <button class="btn btn-success"
                        type="submit"
                        th:if="${user.blocked}">
                    <fmt:message key="users.unlock"/>
                </button>
</c:if>

<c:if test="${user.getBlocked() == false}">
                <button class="btn btn-danger"
                        type="submit"
                        th:if="${!user.blocked}"
                        > <fmt:message key="users.block"/>
                </button>
</c:if>
            </form>
        </td>
        </tbody>
</c:forEach>
        <h2>
            <a class="btn btn-primary" href="/" >
                <fmt:message key="common.back"/></a>
        </h2>
    </table>

</div>
</body>
</html>
