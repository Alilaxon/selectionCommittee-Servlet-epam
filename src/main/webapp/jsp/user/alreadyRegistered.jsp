<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="localization"/>
<%@include file="/jsp/parts/bootstrap.jsp" %>

<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 13.09.2022
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE>
<html lang="en">
<head>
    <title>Title</title>


</head>
<body>
<div class="container">
    <h1><a><fmt:message key="faculties.registration.exception"/></a>
    </h1>
<a class="btn btn-primary" href="/faculties" ><fmt:message key="faculties.registration.back"/></a>
</div>
</body>
</html>
