<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="includes/header.jsp" />
    <main>
        <jsp:include page="includes/site-navigation.jsp" />
        <section>
            <h1>Login</h1>
            <hr>
            <form action="LoginController" method="get">
                <label>Email: </label>
                <input type="text" name="username"><br>
                <label>Password: </label>
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
                <button class="btn btn-warning" type="submit" value="register" name="action">Register </button>
                <button class="btn btn-success" type="submit"  value="authenticate" name="action">Submit</button>
<!--                <input type="hidden" name="action" value="authenticate"/>-->
            </form>
        </section>
        
    </main>
<jsp:include page="includes/footer.jsp" />