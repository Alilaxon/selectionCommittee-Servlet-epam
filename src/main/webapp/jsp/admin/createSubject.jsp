<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/jsp/parts/bootstrap.jsp" %>
<%@include file="/jsp/parts/springStyle.jsp"%>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="localization"/>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE>
<html>
<head>
    <title>CreateSubject</title>
</head>
<body>

</body>
<div>
    <form class="form-signin" method="POST" action="${pageContext.request.contextPath}/admin/addSubject" >

        <label for="nameEN" >
            <fmt:message key="subjects.nameEN"/>
        <input type="text" class="form-control" name="nameEN" id="nameEN" required="required"/>
        </label>

        <label for="nameRU" ><fmt:message key="subjects.nameRU"/></label>
        <input type="text" class="form-control" name="nameRU"  id="nameRU" required="required" />

        <br/>

        <button class="btn btn-lg btn-primary btn-block"
                type="submit"><fmt:message key="common.create"/></button>
    </form>
    <div>
        <a class="btn btn-primary"
         href="/subjects"><fmt:message key="subjects.back"/></a>
    </div>
</div>
</html>
