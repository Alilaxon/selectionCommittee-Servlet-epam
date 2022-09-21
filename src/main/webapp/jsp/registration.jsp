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
<!DOCTYPE>
<html lang="en">
<head>
    <title>Title</title>
</head>
<body>

<div class="container">

  <form class="form-signin" method="POST" action="${pageContext.request.contextPath}/registration">



    <label for="login"><fmt:message key="registration.login"/>
      <input class="form-control" type="text" value="${requestScope.username}"
             placeholder="<fmt:message key="registration.login.field"/>"
             name="username" id="login" required="required"/>
    </label>

    <c:if test="${requestScope.loginSizeOutOfBoundsException}">
      <div id="loginHelp" class="form-text">
        <fmt:message key="registration.exception.loginSizeOutOfBoundsException"/>
      </div>
    </c:if>

    <c:if test="${requestScope.LoginIsReserved}">
      <p class="error-message"><fmt:message
              key="registration.exception.loginIsReserved"/></p>
    </c:if>

    <label for="password"> <fmt:message key="registration.password"/>
      <input class="form-control" type="text" value="${requestScope.password}"
             placeholder="<fmt:message key="registration.password.field"/>"
             name="password" id="password" required="required">
    </label>

    <c:if test="${requestScope.passwordSizeOutOfBoundsException}">
      <p class="error-message"><fmt:message
              key="registration.exception.passwordSizeOutOfBoundsException"/></p>
    </c:if>
    <c:if test="${requestScope.passwordNotMatchTemplateException}">
      <p class="error-message"><fmt:message
              key="registration.exception.passwordNotMatchTemplateException"/></p>
    </c:if>


    <label for="passwordCopy"> <fmt:message key="registration.passwordCopy"/>
      <input class="form-control" type="text"
             placeholder="<fmt:message key="registration.password.field"/>"
             name="passwordCopy" id="passwordCopy" required="required">
    </label>

    <c:if test="${requestScope.passwordsNotSameException}">
      <p class="error-message"><fmt:message
              key="registration.exception.passwordsNotSame"/></p>
    </c:if>

    <label for="email"><fmt:message key="registration.email"/>
      <input class="form-control" type="text" value="${requestScope.email}"
             placeholder="<fmt:message key="registration.email.field"/>"
             name="email" id="email" required="required">
    </label>


    <c:if test="${requestScope.emailSizeOutOfBoundsException}">
      <div id="emailHelp" class="form-text">
        <fmt:message key="registration.exception.emailSizeOutOfBoundsException"/>
      </div>
    </c:if>

    <c:if test="${requestScope.EmailIsReserved}">
      <p class="error-message"><fmt:message
              key="registration.exception.emailIsReserved"/></p>
    </c:if>

    <c:if test="${requestScope.emailNotMatchTemplateException}">
      <p class="error-message"><fmt:message
              key="registration.exception.emailNotMatchTemplateException"/></p>
    </c:if>

    <label for="firstname"><fmt:message key="registration.firstname"/>
      <input class="form-control" type="text" name="firstname" value="${requestScope.firstname}"
             id="firstname" required="required">
    </label>

    <c:if test="${requestScope.firstNameSizeOutOfBoundsException}">
      <p class="error-message"><fmt:message
              key="registration.exception.firstNameSizeOutOfBoundsException"/></p>
    </c:if>

    <label for="surname" ><fmt:message key="registration.surname"/>
      <input class="form-control" type="text" name="surname" value="${requestScope.surname}"
             id="surname" required="required">
    </label>

    <c:if test="${requestScope.secondNameSizeOutOfBoundsException}">
      <p class="error-message"><fmt:message
              key="registration.exception.surnameSizeOutOfBoundsException"/></p>
    </c:if>

    <label for="city" ><fmt:message key="registration.city"/>
      <input class="form-control" type="text" name="city" value="${requestScope.city}"
             id="city" required="required">
    </label>

    <c:if test="${requestScope.citySizeOutOfBoundsException}">
      <p class="error-message"><fmt:message
              key="registration.exception.citySizeOutOfBoundsException"/></p>
    </c:if>

    <label for="region" ><fmt:message key="registration.region"/>
      <input class="form-control" type="text" name="region" value="${requestScope.region}"
             id="region" required="required">
    </label>

    <c:if test="${requestScope.regionSizeOutOfBoundsException}">
      <p class="error-message"><fmt:message
              key="registration.exception.regionSizeOutOfBoundsException"/></p>
    </c:if>

    <label for="institution"> <fmt:message key="registration.institution"/>
      <input class="form-control" type="text" name="institution" value="${requestScope.institution}"
             field="institution" id="institution" required="required">
    </label>

    <c:if test="${requestScope.institutionSizeOutOfBoundsException}">
      <p class="error-message"><fmt:message
              key="registration.exception.institutionSizeOutOfBoundsException"/></p>
    </c:if>
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
