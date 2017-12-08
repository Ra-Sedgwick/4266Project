<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="includes/header.jsp" />
    <main>
        <jsp:include page="includes/site-navigation.jsp" />
        <section>
            <h2>Current Item</h2>
            <hr>
            
            <figure>
                <img src=<c:out value="${product.getImageURL()}" /> style='height:200px'>
                <figcaption>
                    <h3><c:out value="${product.getProductName()}" />: <c:out value="${product.getPriceCurrencyFormat()}" /></h3>
                    <p><c:out value="${product.getDescription()}" /></p>
                    
                </figcaption>
            </figure>
                    <section id="item-buttons">
                        <form>                        <form action="catalog.jsp">
                            <button class="btn btn-primary" type="submit">Back</button>
                        </form>
                        <form action="OrderController?action=updateCart" method="post">
                            <input type="hidden" name="productList[]" value="<c:out value="${product.getProductCode()}" />" />
                            <input type="hidden" name="quantity[]" value="1" />

                            <button id="add-button" class="btn btn-success" type="submit">Add</button>
                        </form>
                    </section>
        </section>
    </main>

<jsp:include page="includes/footer.jsp" />



