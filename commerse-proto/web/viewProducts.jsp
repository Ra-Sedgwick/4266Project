<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="includes/header.jsp" />

    <main>
        <jsp:include page="includes/site-navigation.jsp" />
        <section>
            <h2>Product Inventory</h2>
            <hr>
            <section>
                <form action="createProduct.jsp">
                    <button  class="btn btn-success">Create New Product</button>
                </form>
            </section>
            <section>
                <h3>Clipless</h3>
                <ul class="list-group">
                    <c:forEach var="c" items="${clipless}">
                        <li>
                            <form action="AdminController">
                                <input type="hidden" name="editId" value="${c.getProductCode()}" />
                                <button class="btn btn-info btn-sm delete-product" name="action" value="viewProduct"><c:out value="${c.getProductName()}" /></button>
                            </form>
                        </li>
                    </c:forEach>
                </ul>
            </section>
            <section>
                <h3>Platform</h3>
                <ul class="list-group">
                    <c:forEach var="p" items="${platform}">
                        
                        <li>
                            <form action="AdminController">
                                <input type="hidden" name="editId" value="${p.getProductCode()}" />
                                <button class="btn btn-info btn-sm delete-product" name="action" value="viewProduct"><c:out value="${p.getProductName()}" /></button>
                            </form>
                        </li>
                        
                    </c:forEach>
                </ul>
            </section>
        </section>
        
    </main>
     
<jsp:include page="includes/footer.jsp" />


