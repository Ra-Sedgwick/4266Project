<jsp:include page="includes/header.jsp" />
    <main>
        <jsp:include page="includes/site-navigation.jsp" />
        <section class="orderInfo">
            <h2>Invoice</h2>
            <section>
                <p>${currentOrder.date}</p>
                <p>Ship To</p>
                <p>${currentOrder.user.firstName} ${currentOrder.user.lastName}</p>
                <p>${currentOrder.user.addressField_1}, ${currentOrder.user.addressField_2}</p>
                <p>${currentOrder.user.city}, ${currentOrder.user.state} ${currentOrder.user.postCode}</p>
            </section>
            <section>
                <p>Sub Total: $${currentOrder.totalCost}</p>
                <p>Tax      : $${currentOrder.taxRate}</p>
                <p>Total    : $${currentOrder.totalCost + (currentOrder.totalCost * currentOrder.taxRate)}</p>
            </section>
            <form class="cart-button">
                <button type="submit" formaction="cart.jsp">Back To Cart</button>
                <button type="submit" formaction="catalog.jsp">Purchase</button>   
            </form>
        </section>
        <section class="orderInfo">
            <h2>Order Items</h2>
            <jsp:include page="includes/cart-container.jsp" />
        </section>
            
    </main>

<jsp:include page="includes/footer.jsp" />
