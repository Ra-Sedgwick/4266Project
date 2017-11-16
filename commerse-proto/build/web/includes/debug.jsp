<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <c:forEach items="${sessionScope}" var="attr">
         ${attr.key}=${attr.value}<br>
    </c:forEach>
         <p> ${currentOrder.getIsPaid()}</p>
</div>