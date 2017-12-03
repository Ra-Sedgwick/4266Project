<jsp:include page="includes/header.jsp" />

    <main>
        
        <jsp:include page="includes/site-navigation.jsp" />
        
        <section>
            <h1>Administrator Menu</h1>
            <hr>
            <form>
                <div class="form-group">
                    <button class="btn btn-primary" name="action" formaction="AdminController" value="viewOrders">Display All Orders</button>
                </div>
                <div class="form-group">
                    <button class="btn btn-primary admin-button" name="action" formaction="AdminController" value="viewUsers">Display All Users</button>
                </div>
                <div class="form-group">
                    <button class="btn btn-warning" name="action" formaction="AdminController" value="signOut">Sign Out</button>
                </div>
            </form>
        </section>
                    

    </main>
            
<jsp:include page="includes/footer.jsp" />