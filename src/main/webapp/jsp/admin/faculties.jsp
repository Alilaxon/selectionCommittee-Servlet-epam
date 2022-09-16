<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

    <%@include file="/jsp/parts/bootstrap.jsp" %>
    <%@include file="/jsp/parts/header.jsp"%>

</head>
<body>
<div class="container">



            <h5>
                 <fmt:message key="faculties.sort"/>
            </h5>
            <ul>
                <li>
                    <form method="get" action="/faculties">
                   <c:if test="${order == 'asc'}">
                    <button class="btn btn-secondary" type="submit" >
                        <fmt:message key="faculties.sortByName"/>
                        <input type="hidden" name="sort" value="name">
                        <input type="hidden" name="order" value="desc">

                    </button>
                   </c:if>

                    <c:if test="${order == 'desc'}">
                    <button class="btn btn-secondary" type="submit" >
                        <fmt:message key="faculties.sortByName"/>
                        <input type="hidden" name="sort" value="name">
                        <input type="hidden" name="order" value="asc">
                    </button>
                    </c:if>
                    </form>
                </li>

                <li>
                    <form method="get" action="/faculties">
                     <c:if test="${order == 'asc'}">
                    <button class="btn btn-secondary" type="submit">
                        <fmt:message key="faculties.sortByGeneralPlaces"/>
                        <input type="hidden" name="sort" value="generalPlaces">
                        <input type="hidden" name="order" value="desc">
                    </button>
                     </c:if>

                         <c:if test="${order == 'desc'}">
                    <button class="btn btn-secondary" type="submit">
                        <fmt:message key="faculties.sortByGeneralPlaces"/>
                        <input type="hidden" name="sort" value="generalPlaces">
                        <input type="hidden" name="order" value="asc">
                    </button>
                         </c:if>
                    </form>
                </li>

                <li>
                    <form method="get" action="/faculties">
                    <c:if test="${order == 'asc'}">
                    <button class="btn btn-secondary" type="submit">
                        <fmt:message key="faculties.sortByBudgetPlaces"/>
                        <input type="hidden" name="sort" value="budgetPlaces">
                        <input type="hidden" name="order" value="desc">
                    </button>
                    </c:if>
                        <c:if test="${order == 'desc'}">
                    <button class="btn btn-secondary" type="submit">
                        <fmt:message key="faculties.sortByBudgetPlaces"/>
                        <input type="hidden" name="sort" value="budgetPlaces">
                        <input type="hidden" name="order" value="asc">
                    </button>
                        </c:if>
                    </form>
                </li>

            </ul>
            <hr>

        </div>
    <div class="row row-cols-4 row-cols-md-4 g-4">
        <c:forEach var="faculty" items="${faculties}">

            <div class="card h-100" style="background-color: cornsilk">
                <h3>
                    <div class="card-header">

                        <c:if test="${sessionScope.lang == 'en'}">
                        <p class="card-title">
                            <fmt:message key="faculties.name"/>:${faculty.getFacultyName()}
                        </p>
                        </c:if>

                        <c:if test="${sessionScope.lang == 'ru'}">
                            <p class="card-title">
                                <fmt:message key="faculties.name"/>:${faculty.getFacultyNameRU()}
                            </p>
                        </c:if>


                    </div>
                </h3>
                <div class="card-body">
                    <h4>
                        <p><fmt:message key="faculties.budgetPlaces"/>:${faculty.getBudgetPlaces()}</p>

                        <p ><fmt:message key="faculties.generalPlaces"/>:${faculty.getGeneralPlaces()}</p>

                        <p><fmt:message key="faculties.requiredSubjects"/></p>
                    </h4>
                    <c:forEach var="subject" items="${faculty.getRequiredSubjects()}">
                    <div>
                        <h5>
                            <c:if test="${sessionScope.lang == 'en'}">
                            <p>${subject.getNameEN()}</p>
                            </c:if>

                            <c:if test="${sessionScope.lang == 'ru'}">
                            <p>${subject.getNameRU()}</p>
                            </c:if>
                        </h5>
                    </div>
                    </c:forEach>

                    <div >
                        <c:if test="${faculty.getRecruitment() == false}">
                        <div>
                            <a class="btn btn-secondary"
                               href="/user/statement?facultyId=${faculty.getId()}">
                                <fmt:message key="faculties.registration"/>
                            </a>
                        </div>
                        </c:if>
                    </div>



                    <div>
                        <form method="POST" action="/deleteFaculty">
                            <input type="hidden" name="id" value="${faculty.getId()}">
                            <button class="btn btn-secondary"
                                    type="submit" ><fmt:message key="common.delete"/>
                            </button>
                        </form>
                        <form>
                            <a class="btn btn-secondary"
                               href="/admin/updateFaculty?facultyId=${faculty.getId()}">
                                <fmt:message key="common.edit"/>
                            </a>
                        </form>
                        <form>
                            <a class="btn btn-secondary" href="/admin/statements?facultyId=${faculty.getId()}">
                                <fmt:message key="faculties.statements"/></a>
                            <br/>
                        </form>

                        <form method="POST"
                              action="${pageContext.request.contextPath}/recruitment">
                            <input type="hidden"
                                   name="facultyId"
                                   value="${faculty.getId()}">
                            <input type="hidden"
                                   name="facultyOpen"
                                   value="${faculty.getRecruitment()}">

                            <c:if test="${faculty.getRecruitment() == false}">
                            <button class="btn btn-success" type="submit">
                                <fmt:message key="faculties.open"/>
                            </button>
                            </c:if>

                            <c:if test="${faculty.getRecruitment() == true}">
                            <button class="btn btn-danger" type="submit">
                                <fmt:message key="faculties.close"/>
                            </button>
                            </c:if>

                        </form>
                    </div>
                </div>
            </div>

        </c:forEach>
    </div>
    <h2>

        <a class="btn btn-primary" href="/addFaculty"><fmt:message key="faculties.addFaculty"/></a>
        <br/>
        <a class="btn btn-primary" href="/"><fmt:message key="common.back"/></a>
    </h2>
</div>
</body>
</html>