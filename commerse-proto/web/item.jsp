<jsp:include page="includes/header.jsp" />
    <main>
        <jsp:include page="includes/site-navigation.jsp" />
        <section>
            <h2>Current Item</h2>
            <hr>
            
            <figure>
                <img src=${product.getImageURL()} style='height:200px'>
                <figcaption>
                    <h3>${product.getProductName()}: ${product.getPriceCurrencyFormat()}</h3>
                    <p>${product.getDescription()}</p>
                    
                </figcaption>
            </figure>
                    
                    <section class="button-group">
                        <form action="OrderController?action=updateCart" method="post">
                            <input type="hidden" name="productList[]" value="${product.getProductCode()}" />
                            <input type="hidden" name="quantity[]" value="1" />

                            <button id="add-button" class="btn btn-success" type="submit">Add</button>
                        </form>
                        </form>
                        <form action="catalog.jsp">
                            <button class="btn btn-primary" type="submit">Back</button>
                        </form>
                    </section>
            
            
            
        </section>
    </main>

<jsp:include page="includes/footer.jsp" />



