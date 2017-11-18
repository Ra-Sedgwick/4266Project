<jsp:include page="includes/header.jsp" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    <main>
        
        <jsp:include page="includes/site-navigation.jsp" />
        <section>
            <h2>Your Cart</h2>
            <hr>
                   <form action="OrderController?action=updateCart" method="post">

            <jsp:include page="includes/cart-container.jsp" />
            <section class="button-group">
                <button type="submit" class="btn btn-primary">Update Cart</button>
                <button type="submit" class="btn btn-success" formaction="OrderController?action=checkout">Check Out</button>
                <c:if test="${checkoutError != null}">
                    <p id="checkoutError">Error: Please sign in to complete transaction.</p> 
                   
                </c:if>
            </section>
                   
            </form>
        </section>
        
 
    </main>
            
