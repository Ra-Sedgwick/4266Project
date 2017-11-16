<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                <p>Sub Total: $${currentOrder.getSubTotal()}</p>
                <p>Tax      : $${currentOrder.taxRate}</p>
                <p>Total    : $${currentOrder.totalCost}</p>
            </section>
                <c:choose>
                    <c:when test="${currentOrder.getIsPaid()}">
                        <p>Paid In Full</p>
                    </c:when>
                    <c:otherwise>
                        <form class="cart-button">
                            <button type="submit" formaction="cart.jsp">Back To Cart</button>
                            <button type="submit" formaction="payment.jsp">Purchase</button>   
                        </form>
                    </c:otherwise>
                </c:choose>
        </section>
        <section class="orderInfo">
            <h2>Order Items</h2>
            <jsp:include page="includes/cart-container.jsp" />
        </section>
            
    </main>

<jsp:include page="includes/footer.jsp" />
