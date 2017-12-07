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
                        <c:if test="${pageContext.request.isUserInRole('admin')}">
                                    <th>Controls</th>
                                </c:if>

                        </tr>
                        <c:forEach var="order" items="${orderList}">
                            <tr>
                                <td><c:out value="${order.orderNumber}" /></td>
                                <td><c:out value="${order.user.firstName}" /></td>
                                <td><c:out value="${order.date}" /></td>
                                <td>$<c:out value="${order.totalCost}" /></td>
                                <td>
                                    <c:if test="${pageContext.request.isUserInRole('admin')}">
                                        <form class="form-inline">
                                            <input type="hidden" name="updateOrderNumber" value="<c:out value="${order.orderNumber}" />" />
                                            <button class="btn btn-primary btn-xs order-edit" name="action" formaction="AdminController" value="editOrder">Edit</button>
                                        </form>
                                        <form class="form-inline">
                                            <input type="hidden" name="deleteId" value="<c:out value="${order.orderNumber}" />" />
                                            <button class="btn btn-warning btn-xs order-delete" name="action" formaction="AdminController" value="deleteOrder">Delete</button> 
                                        </form>
                                    </c:if>
                                </td>
                                
                            </tr>

                        </c:forEach>
                </table>
            </div>
            
        </section>

    </main>
            
<jsp:include page="includes/footer.jsp" />