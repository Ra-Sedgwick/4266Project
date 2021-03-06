<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="includes/header.jsp" />

    <main>
        
        <jsp:include page="includes/site-navigation.jsp" />
        
        <section>
            <h1>Order List</h1>
            <hr>
            <div class="table-responsive">
                <table class="table table-striped table-hover">
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
                            <td>$${order.totalCost}</td>
                        </tr>

                    </c:forEach>
                </table>
            </div>
            
        </section>

    </main>
            
<jsp:include page="includes/footer.jsp" />