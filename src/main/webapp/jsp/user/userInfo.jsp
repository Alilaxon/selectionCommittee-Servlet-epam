<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/WEB-INF/tld/myTags.tld" prefix="myTags"%>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="localization"/>
<%@include file="/jsp/parts/bootstrap.jsp" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 13.09.2022
  Time: 23:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <h1>UserPage</h1>
    <h3>
        <a><fmt:message key="profile.login"/> : ${sessionScope.user.getUsername()}</a>
        <br>
        <a><fmt:message key="profile.email"/> : ${sessionScope.user.getEmail()}</a>
        <br>
        <a><fmt:message key="profile.firstname"/> :${sessionScope.user.getFirstname()}</a>
        <br>
        <a><fmt:message key="profile.surname"/> : ${sessionScope.user.getSurname()}</a>
        <br>
        <a><fmt:message key="profile.city"/> : ${sessionScope.user.getCity()}</a>
        <br>
        <a><fmt:message key="profile.region"/> : ${sessionScope.user.getRegion()}</a>
        <br>
        <a><fmt:message key="profile.institution"/> : ${sessionScope.user.getInstitution()}
        </a>
    </h3>
       <c:forEach var="statement" items="${statements}">
       <div>


           <h3>
            <div class="card" style="background-color: cornsilk">
                <a><fmt:message key="profile.faculty"/> :
                    <myTags:facultyLocal faculty="${statement.getFacultyId()}"></myTags:facultyLocal></a>
                <br/>
                <a><fmt:message key="profile.gpa"/> : ${statement.getGradePointAverage()}</a>
                <br/>
                <a><fmt:message key="profile.position"/> : ${statement.getPosition().getPositionType().name()}</a>

                <form method="POST" action="${pageContext.request.contextPath}/user/deleteStatement">
                    <button class="btn btn-secondary" type="submit">
                        <input type="hidden" name="statementId" value="${statement.getId()}">
                        <fmt:message key="common.delete"/>
                    </button>
                </form>

            </div>
           </h3>
       </div>
       </c:forEach>
</div>
</body>
</html>
