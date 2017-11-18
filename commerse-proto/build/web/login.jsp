<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="includes/header.jsp" />
    <main>
        <jsp:include page="includes/site-navigation.jsp" />
        <section>
            <h1>Login</h1>
            <hr>
            <form action="LoginController" method="get">
                <label>User Name</label>
                <input type="text" name="username"><br>
                <label>Password</label>
                <input type="text" name="password"><br><br>
                <c:choose>
                    <c:when test="${loginError != null}">
                        <label>&nbsp;</label>
                        <p class="loginError">${loginError}</p>
                    </c:when>
                    <c:otherwise>
                        <label>&nbsp;</label>
                        <p id="loginError"></p>
                    </c:otherwise>
                </c:choose>
                <label>&nbsp;</label>
                <input class="btn btn-success" type="submit">
                <input type="hidden" name="action" value="authenticate"/>
            </form>
        </section>
        
    </main>
<jsp:include page="includes/footer.jsp" />