<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/jsp/parts/bootstrap.jsp" %>
<%@include file="/jsp/parts/springStyle.jsp"%>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="localization"/>
<%@ taglib uri="/WEB-INF/tld/myTags.tld" prefix="myTags"%>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 13.09.2022
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <style>
        input.larger {
            width: 30px;
            height: 30px;
        }
    </style>
</head>
<body>
<div class="container">
    <form class="form-signin" method="POST" action="/updateFaculty" >
        <h5>

            <input type="hidden" name="facultyId" value="${faculty.getId()}">
            <input type="hidden" name="recruitment" value="${faculty.getRecruitment()}">

            <label for="facultyName" >
                <fmt:message key="faculties.name"/>
                <input class="form-control" type="text" name="facultyName"
                       value="${faculty.getFacultyName()}" id="facultyName">
            </label>


            <label for="facultyNameRU" > <fmt:message key="faculties.name"/>
                <input class="form-control" type="text" name="facultyNameRU"
                       value="${faculty.getFacultyNameRU()}" id="facultyNameRU"/>
            </label>



            <label for="generalPlaces" >
                <fmt:message key="faculties.generalPlaces"/>
                <input class="form-control" type="text" name="generalPlaces"
                       value="${faculty.getGeneralPlaces()}" id="generalPlaces">
            </label>


            <label for="budgetPlaces" > <fmt:message key="faculties.budgetPlaces"/>
                <input class="form-control" type="text" name="budgetPlaces"
                       value="${faculty.getBudgetPlaces()}" id="budgetPlaces">
            </label>


        </h5>
        <div>
            <h3>
               <c:forEach var="subject" items="${subjects}">
                <tr>
                    <!--    type="checkbox"  Позволяет ставить галочки-->
                    <input type="checkbox" class="larger"
                           value="${subject.id}"
                           id="${subject.id}">

                    <label for="${subject.getId()}" >
                        <myTags:subjectLocal subject="${subject}"></myTags:subjectLocal>
                    </label>
                    <br>
                </tr>
               </c:forEach>
            </h3>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">
            <fmt:message key="common.update"/></button>
    </form>
    <a class="btn btn-primary" href="/faculties" >
        <fmt:message key="faculties.back"/>
    </a>
</div>
</body>
</html>
