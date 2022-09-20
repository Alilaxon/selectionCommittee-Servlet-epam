<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="localization"/>
<%@include file="/jsp/parts/bootstrap.jsp"%>
<%@include file="/jsp/parts/springStyle.jsp"%>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 19.09.2022
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <h1 class="display-1 text-center">
        <fmt:message key="user.isBlocked"/>
    </h1>
</head>
<body>
<div class="container">
    <a class="btn btn-primary" href="/">
        <fmt:message key="common.back"/>
    </a>
</div>
</body>
</html>
