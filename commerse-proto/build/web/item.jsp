<jsp:include page="includes/header.jsp" />
    <main>
        <jsp:include page="includes/site-navigation.jsp" />
        <section>
            <h2>Current Item</h2>
            
            <figure>
                <img src=${product.getImageURL()} style='height:200px'>
                <figcaption>
                    <h3>${product.getProductName()}: ${product.getPriceCurrencyFormat()}</h3>
                    <p>${product.getDescription()}</p>
                    
                </figcaption>
            </figure>
            <form action="catalog.jsp">
                <input class="item-button" type="submit" value="<- Back" />
            </form>
            <form action="OrderController?action=updateCart" method="post">
                <input type="hidden" name="productList[]" value="${product.getProductCode()}" />
                <input type="hidden" name="quantity[]" value="1" />

                <input class="item-button" type="submit" value="add-item" />
            </form>
            
        </section>
    </main>

<jsp:include page="includes/footer.jsp" />



