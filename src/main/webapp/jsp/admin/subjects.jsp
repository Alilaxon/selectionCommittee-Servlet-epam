<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/jsp/parts/bootstrap.jsp" %>
<%@include file="/jsp/parts/header.jsp"%>

<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 13.09.2022
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Subjects</title>
</head>
<body>
<div class="container">
    <table class="table table-bordered">
        <tr>
            <th>
                <span > <fmt:message key="subjects.id"/></span>
            </th>
            <th>
                <span> <fmt:message key="subjects.nameEN"/></span>
            </th>
            <th>
                <span> <fmt:message key="subjects.nameRU"/></span>
            </th>
            <th>
                <span> <fmt:message key="common.action"/></span>
            </th>
        </tr>

<c:forEach var="subject" items="${subjects}">
        <tbody>

        <th>${subject.getId()}</th>
        <td >${subject.getNameEN()}</td>
        <td>${subject.getNameRU()}</td>
        <td>
            <form method="POST" action="${pageContext.request.contextPath}/admin/deleteSubject " >
                <input type="hidden" name="id" value="${subject.getId()}">
                <button class="btn btn-danger" type = "submit" >
         <fmt:message key="common.delete"/>
    </button>
            </form>
        </td>
        </tbody>
</c:forEach>
        <h2>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/admin/addSubject" >
    <fmt:message key="subjects.addSubject"/></a>
            </br>
            <a class="btn btn-primary" href="/" >
    <fmt:message key="common.back"/></a>
        </h2>
    </table>
</div>

<%@include file="/jsp/parts/paginationSubject.jsp" %>
</body>
</html>
