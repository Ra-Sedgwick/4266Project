<jsp:include page="includes/header.jsp" />

    <main>
        
        <jsp:include page="includes/site-navigation.jsp" />
        
        <section id="cart-container">
            <form action="OrderController?action=updateCart" method="post" class="cart-button">
            <h2>Your Cart</h2>
            <jsp:include page="includes/cart-container.jsp" />
                <button type="submit">Update Cart</button>
                <button type="submit" formaction="OrderController?action=checkout">Check Out</button>   
            </form>
        </section>
        
    </main>
            
<jsp:include page="includes/footer.jsp" />


