<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="includes/header.jsp" />
    <main>
        <jsp:include page="includes/site-navigation.jsp" />
        <section>
            <h1>Login</h1>

            <hr>
            <c:choose>
                <c:when test="${loginError != null}">
                    <p class="loginError">${loginError}</p>
                </c:when>
                <c:otherwise>
                    <p id="loginError"></p>
                </c:otherwise>
            </c:choose>
            <form action="LoginController" method="get">
                
                <div class="row">
                    <div class="form-group col-sm-5">
                        <label>Email: </label>
                        <input class="form-control" type="text" name="username">
                    </div>
                </div>
                
                <div class="row">
                    <div class="form-group col-sm-5">
                        <label>Password: </label>
                        <input class="form-control" type="password" name="password"> 
                    </div>
                </div>
                
                <button class="btn btn-success" type="submit"  value="authenticate" name="action">Submit</button>
                <button class="btn btn-warning" type="submit" value="register" name="action">Register </button>
            </form>
            <a href="resetPassword.jsp" id="password-reset-button-1"><small>Forgot Password?</small></a>
        </section>
        
    </main>
        
<jsp:include page="includes/footer.jsp" />