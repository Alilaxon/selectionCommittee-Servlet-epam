<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:if test="${pages > 1}">
    <nav>
        <ul class="pagination justify-content-center">
            <c:forEach var="i" begin="1" end="${pages}" step="1" >
                <block>
                    <c:if test="${i == page}">
                        <li class="page-item myselect active" >
                            <form method="get" action="${pageContext.request.contextPath}/admin/statements">
                                <button class="page-link" type="submit" >${i}</button>
                                <input type="hidden" name="facultyId" value="${facultyId}">
                                <input type="hidden" name="page" value="${i}">
                            </form>
                        </li>
                    </c:if>
                    <c:if test="${i != page}">
                        <li class="page-item myselect">
                            <form method="get" action="${pageContext.request.contextPath}/admin/statements">
                                <button class="page-link" type="submit">${i}</button>
                                <input type="hidden" name="facultyId" value="${facultyId}">
                                <input type="hidden" name="page" value="${i}">
                            </form>
                        </li>
                    </c:if>
                </block>
            </c:forEach>
        </ul>
    </nav>
</c:if>