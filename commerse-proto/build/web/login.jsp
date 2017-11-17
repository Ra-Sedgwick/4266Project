<jsp:include page="includes/header.jsp" />
    <main>
        <jsp:include page="includes/site-navigation.jsp" />
        <h1>Login</h1>
        <form action="LoginController" method="get">
            <label>User Name</label>
            <input type="text" name="username"><br>
            <label>Password</label>
            <input type="text" name="password"><br>
            <label>&nbsp;</label>
            <input type="submit">
            <input type="hidden" name="action" value="authenticate"/>
        </form>
    </main>
<jsp:include page="includes/footer.jsp" />