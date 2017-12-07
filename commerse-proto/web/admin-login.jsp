<jsp:include page="includes/header.jsp" />
    <main>
        <jsp:include page="includes/site-navigation.jsp" />
        <section>
        <h1>Administrator Login</h1><br>
        <hr>
        <form action="j_security_check" method="get">
            <label>User Name</label>
            <input type="text" class="admin-login" name="j_username"><br>
            <label>Password</label>
            <input type="text" class="admin-login" name="j_password"><br>
            <label>&nbsp;</label>
            <input class="btn btn-success" type="submit" value="Login"><br>
            <a href="resetPasswordAdmin.jsp" id="reset-admin-password"><small>Forgot Password?</small></a>
        </form>
        </section>
        
    </main>
<jsp:include page="includes/footer.jsp" />
