<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="localization"/>
<%@include file="/jsp/parts/bootstrap.jsp"%>
<%@include file="/jsp/parts/springStyle.jsp"%>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 14.09.2022
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div class="container">

  <form class="form-signin" method="POST" action="${pageContext.request.contextPath}/registration/form">



    <label for="login"><fmt:message key="registration.login"/>
      <input class="form-control" type="text"
             placeholder="<fmt:message key="registration.login.field"/>"
             name="username" id="login" required="required"/>
    </label>


    <label for="password"> <fmt:message key="registration.password"/>
      <input class="form-control" type="text"
             placeholder="<fmt:message key="registration.password.field"/>"
             name="password" id="password" required="required">
    </label>

    <label for="email"><fmt:message key="registration.email"/>
      <input class="form-control" type="text"
             placeholder="<fmt:message key="registration.email.field"/>"
             name=="email" id="email" required="required">
    </label>

    <label for="firstname"><fmt:message key="registration.firstname"/>
      <input class="form-control" type="text" name="firstname"
             id="firstname" required="required">
    </label>

    <label for="surname" ><fmt:message key="registration.surname"/>
      <input class="form-control" type="text" name="surname"
             id="surname" required="required">
    </label>

    <label for="city" ><fmt:message key="registration.city"/>
      <input class="form-control" type="text" name="city"
             id="city" required="required">
    </label>

    <label for="region" ><fmt:message key="registration.region"/>
      <input class="form-control" type="text" name="region"
             id="region" required="required">
    </label>

    <label for="institution"> <fmt:message key="registration.institution"/>
      <input class="form-control" type="text"
             field="institution" id="institution" required="required">
    </label>
    <br>
    <button class="btn btn-lg btn-primary btn-block" type="submit">
      <fmt:message key="registration.create"/>
    </button>
  </form>
</div>
<a class="btn btn-primary"
   href="/"><fmt:message key="common.back"/></a>
</div>

</body>
</html>
