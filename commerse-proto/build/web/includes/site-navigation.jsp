<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<aside>
    <c:choose>
        <c:when test="${pageContext.request.isUserInRole('admin')}">
            <a href="admin.jsp">Home</a>
        </c:when>
        <c:otherwise>
            <a href="index.jsp">Home</a>
        </c:otherwise>
    </c:choose>
    
    <a href="catalog">Catalog</a>
    <a href="about.jsp">About</a>
    <a href="contact.jsp">Contact</a>
</aside>
