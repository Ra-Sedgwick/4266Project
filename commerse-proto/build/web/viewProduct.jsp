<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="includes/header.jsp" />
    <main>
        <jsp:include page="includes/site-navigation.jsp" />
        <section>
            <h2>Current Item</h2>
            <hr>
            
            <figure>
                <img src=<c:out value="${productToEdit.getImageURL()}" /> style='height:200px'>
                <figcaption>
                    <h3><c:out value="${productToEdit.getProductName()}" />: <c:out value="${productToEdit.getPriceCurrencyFormat()}" /></h3>
                    <p><c:out value="${productToEdit.description}" /></p>
                    
                </figcaption>
            </figure>
                    
                    <section id="item-buttons">
                        <form action="AdminController">                        
                            <button class="btn btn-success" name="action" value="editProduct" type="submit">Edit</button>
                        </form>
                        <form action="AdminController" method="post">
                            <button id="add-button" class="btn btn-warning" name="action" value="deleteProduct" type="submit">Delete</button>
                        </form>
                    </section>
            
            
            
        </section>
    </main>

<jsp:include page="includes/footer.jsp" />



