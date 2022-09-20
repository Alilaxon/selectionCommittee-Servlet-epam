<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/jsp/parts/bootstrap.jsp" %>
<%@include file="/jsp/parts/springStyle.jsp" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="localization"/>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 13.09.2022
  Time: 23:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE>
<html lang="en">
<head>
    <title>CreateFaculty</title>

    <style>
        input.larger {
            width: 30px;
            height: 30px;
        }
    </style>
</head>
<body>
<div class="container">
    <form class="form-signin" method="POST" action="${pageContext.request.contextPath}/admin/addFaculty">


        <h5>

            <label for="facultyName"> <fmt:message key="faculties.name"/>
                <input class="form-control" type="text" name="facultyName"
                       placeholder="<fmt:message key="faculties.registration.nameEN"/>"
                       id="facultyName" required="required"/>
            </label>


            <label for="facultyNameRU"><fmt:message key="faculties.name"/>

                <input class="form-control" type="text" name="facultyNameRU"
                       placeholder="<fmt:message key="faculties.registration.nameRU"/>"
                       id="facultyNameRU" required="required"/>
            </label>

            <label for="generalPlaces"><fmt:message key="faculties.generalPlaces"/>
                <input class="form-control" type="number" min="2"
                       name="generalPlaces" id="generalPlaces" required="required"/>
            </label>

            <label for="budgetPlaces"><fmt:message key="faculties.budgetPlaces"/>
                <input class="form-control" type="number" min="1"
                       name="budgetPlaces" id="budgetPlaces" required="required"/>
            </label>


        </h5>
        <div>
            <h5><fmt:message key="faculties.requiredSubjects"/></h5>

            <h6><fmt:message key="faculties.addFaculty.subjectsMinValue"/></h6>
            <c:forEach var="subject" items="${subjectList}">
                <tr>
                    <h3>
                        <input type="checkbox" class="larger"
                               name="id"
                               value="${subject.id}"
                               id="${subject.id}">
                        <c:if test="${sessionScope.lang == 'en'}">

                            <label for="${subject.id}">${subject.getNameEN()}</label>

                        </c:if>

                        <c:if test="${sessionScope.lang == 'ru'}">

                            <label for="${subject.id}">${subject.getNameRU()}
                            </label>
                        </c:if>
                    </h3>


                </tr>
            </c:forEach>
        </div>

        <button class="btn btn-lg btn-primary btn-block"
                type="submit"><fmt:message key="common.create"/></button>
    </form>
    <a class="btn btn-primary" href="/faculties"><fmt:message key="faculties.back"/></a>
</div>
</body>
</html>
