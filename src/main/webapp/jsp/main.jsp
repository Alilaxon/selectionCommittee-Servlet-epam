<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 15.09.2022
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="/jsp/parts/bootstrap.jsp"%>
<%@include file="/jsp/parts/header.jsp"%>
<!DOCTYPE>
<html lang="en">
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <!--Стартовая страница -->

    <h1 class="display-1 text-center "><fmt:message key="main.school.part1"/>
    </h1>
    <h1 class="display-1 text-center "><fmt:message key="main.school.part2"/>
    </h1>
    <h1 class="display-1 text-center "><fmt:message key="main.school.part3"/>
    </h1>
    <h1 class="display-1 text-center "><fmt:message key="main.text"/></h1>

</div>
</body>
</html>
