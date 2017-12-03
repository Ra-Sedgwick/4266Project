<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="includes/header.jsp" />
    <main>
        <jsp:include page="includes/site-navigation.jsp" />
        <section>
            <h1>Reset Password</h1>
            <hr>
            <form action="UserController" method="get">
                
                
                <div class="row">
                    <div class="form-group col-sm-5">
                        <label>Email: </label>
                        <input type="text" name="userEmail">
                    </div>
                </div>
                
                <div class="row">
                    <div class="form-group col-sm-5">
                        <label>Favorite Fruit: </label>
                        <input type="text" name="secret">
                    </div>
                </div>
                
                
                
                
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
                <button class="btn btn-success" type="submit"  value="reset-password" name="action">Reset</button>
            </form><p></p>
        </section>
        
    </main>
<jsp:include page="includes/footer.jsp" />