<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="includes/header.jsp" />
    <main>
        <jsp:include page="includes/site-navigation.jsp" />
        <section>
            <h2>Pedal Selection</h2>
            <section>
                <h3>Clipless</h3>
                <ul>
                    <c:forEach var="c" items="${clipless}">
                        <li><a href="catalog?productCode=${c.getProductCode()}">${c.getProductName()} </a></li>
                    </c:forEach>
                </ul>
            </section>
            <section>
                <h3>Platform</h3>
                <ul>
                    <c:forEach var="p" items="${platform}">
                        <li><a href="catalog?productCode=${p.getProductCode()}">${p.getProductName()} </a></li>
                    </c:forEach>
                </ul>
            </section>
        </section>
        
    </main>
<jsp:include page="includes/footer.jsp" />


