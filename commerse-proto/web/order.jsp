<jsp:include page="includes/header.jsp" />
    <main>
        <jsp:include page="includes/site-navigation.jsp" />
        <section>
            <h2>Invoice</h2>
            <section>
                <p>${currentOrder.date}</p>
                <p>Ship To</p>
                <p>${currentOrder.user.firstName} ${currentOrder.user.lastName}</p>
                <p>${currentOrder.user.addressField_1}, ${currentOrder.user.addressField_2}</p>
                <p>${currentOrder.user.city}, ${currentOrder.user.state} ${currentOrder.user.postCode}</p>
            </section>
            <section>
                <jsp:include page="includes/cart-container.jsp" />
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
            <form>
                <input type="hidden" min="0" name="productList" value="${item.product.getProductCode()}" />
                <input type="text" name="quantity[]" value="1"  style="text-align: right"/>
            </form> 
            
    </main>
<jsp:include page="includes/viewSessions.jsp" />

<jsp:include page="includes/footer.jsp" />
