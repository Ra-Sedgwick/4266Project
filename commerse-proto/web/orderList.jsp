<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="includes/header.jsp" />

    <main>
        
        <jsp:include page="includes/site-navigation.jsp" />
        
        <section>
            <h1>Order List</h1> <br>
            <table id="order-table">
                <tr>
                    <th>Order Number</th>
                    <th>Customer</th>
                    <th>Order Date</th>
                    <th>Total</th>
                </tr>
                <c:forEach var="order" items="${orderList}">
                    <tr>
                        <td>${order.orderNumber}</td>
                        <td>${order.user.firstName}</td>
                        <td>${order.date}</td>
                        <td>$${currentOrder.totalCost + (currentOrder.totalCost * currentOrder.taxRate)}</td>
                    </tr>
                    
                </c:forEach>
            </table>
        </section>

    </main>
            
<jsp:include page="includes/footer.jsp" />