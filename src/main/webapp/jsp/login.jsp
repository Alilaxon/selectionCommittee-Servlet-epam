<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 14.09.2022
  Time: 23:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE>
<html lang="en">
<head>
    <title>Title</title>
  <fmt:setLocale value="${sessionScope.lang}"/>
  <fmt:setBundle basename="localization"/>
  <%@include file="/jsp/parts/springStyle.jsp"%>
  <%@include file="/jsp/parts/bootstrap.jsp"%>
</head>
<body>
<div class="container">
  <form class="form-signin" method="post" action="/login">
    <h2 class="form-signin-heading"><fmt:message key="login.sign"/></h2>
    <p>
      <label for="username" class="sr-only"><fmt:message key="registration.login"/></label>
      <input type="text" id="username" name="username"
             class="form-control" placeholder="Username"
             required="" autofocus="">
    </p>
    <p>
      <label for="password" class="sr-only"><fmt:message key="registration.password"/></label>
      <input type="password" id="password" name="password"
             class="form-control" placeholder="Password" required="">
    </p>
    <input name="_csrf" type="hidden" >
    <button class="btn btn-lg btn-primary btn-block" type="submit"><fmt:message key="login.signIn"/></button>
  </form>
</div>
</body>
</html>
