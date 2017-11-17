<jsp:include page="includes/header.jsp" />
    <main>
        <jsp:include page="includes/site-navigation.jsp" />
        <h1>Login</h1>
        <form action="j_security_check" method="get">
            <label>User Name</label>
            <input type="text" name="j_username"><br>
            <label>Password</label>
            <input type="text" name="j_password"><br>
            <label>&nbsp;</label>
            <input type="submit" value="Login">
        </form>
    </main>
<jsp:include page="includes/footer.jsp" />
