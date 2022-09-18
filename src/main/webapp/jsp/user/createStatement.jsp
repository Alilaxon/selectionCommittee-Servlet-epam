<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="localization"/>
<%@include file="/jsp/parts/bootstrap.jsp" %>
<%@include file="/jsp/parts/springStyle.jsp" %>
<%@ taglib uri="/WEB-INF/tld/myTags.tld" prefix="myTags" %>

<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 13.09.2022
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">

    <form class="form-signin" method="POST" action="/createStatement">

        <h1>
            <a> <myTags:facultyLocal faculty="${faculty}"></myTags:facultyLocal> </a>

        </h1>
        <input type="hidden" name="facultyId" value="${faculty.getId()}">
        <input type="hidden" name="userId" value="${sessionScope.user.getId()}">

        <div>
            <c:forEach var="subject" items="${subjectList}">

                <label for="${subject.id}"><myTags:subjectLocal subject="${subject}"></myTags:subjectLocal>
                    <input class="form-control" type="number" min="100" max="200" required="required"
                           name="grades" id="${subject.id}">
                </label>
                 <br>
            </c:forEach>
        </div>

        <div>
            <button type="submit" class="btn btn-primary">
                <fmt:message key="faculties.registration.create"/>
            </button>
        </div>


    </form>
    <a class="btn btn-primary" href="/faculties"><fmt:message key="faculties.registration.back"/></a>
</div>
</body>
</html>
