<jsp:include page="includes/header.jsp" />

    <main>
        
        <jsp:include page="includes/site-navigation.jsp" />
        
        <section>
            <h1>Administrator Menu</h1>
            <hr>
            <form>
                <button class="btn btn-warning" name="action" formaction="AdminController" value="viewOrders">Display All Orders</button>
            </form>
        </section>
                    

    </main>
            
<jsp:include page="includes/footer.jsp" />