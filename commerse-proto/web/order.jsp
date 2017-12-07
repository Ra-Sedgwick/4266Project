<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="includes/header.jsp" />
    <main>
        <jsp:include page="includes/site-navigation.jsp" />
        <section class="orderInfo">
            <h2>Invoice</h2>
            <section>
                <p><c:out value="${currentOrder.date}" /></p>
                <p>Ship To</p>
                <p><c:out value="${currentOrder.user.firstName}" /> <c:out value="${currentOrder.user.lastName}" /></p>
                <p><c:out value="${currentOrder.user.addressField_1}" />, <c:out value="${currentOrder.user.addressField_2}" /></p>
                <p><c:out value="${currentOrder.user.city}" />, <c:out value="${currentOrder.user.state}" /> <c:out value="${currentOrder.user.postCode}" /></p>
            </section>
            <section>
                <p>Sub Total: $<c:out value="${currentOrder.getSubTotal()}" /></p>
                <p>Tax      : $<c:out value="${currentOrder.taxRate}" /></p>
                <p>Total    : $<c:out value="${currentOrder.getTotalCost()}" /></p>
            </section>
                <c:choose>
                    <c:when test="${currentOrder.getIsPaid()}">
                        <p id="payment-flag">Paid In Full</p>
                    </c:when>
                    <c:otherwise>
                        <form class="cart-button">
                            <button type="submit" class="btn btn-primary" formaction="cart.jsp">Back To Cart</button>
                            <button type="submit" class="btn btn-success" formaction="payment.jsp">Purchase</button>   
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
