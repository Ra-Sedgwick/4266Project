<jsp:include page="includes/header.jsp" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    <main>
        <jsp:include page="includes/site-navigation.jsp" />
        <section>
            <h1>Edit Product</h1>
            <hr>
            
            <c:if test="${registerError != null}">
                <h3 class="loginError">${registerError}</h3>
            </c:if>
            
            <form id="update-user-form" action="AdminController?action=updateProduct"  method="POST">
                         
                <div class="row">
                    <div class="form-group col-sm-5">
                        <label for="productName">Name: </label>
                        <input type="text" class="form-control" name="productName" id="productName" placeholder="<c:out value="${productToEdit.productName}" />" />
                    </div>
                </div>
                
                <div class="row">
                    <div class="form-group col-sm-5">
                        <label for="catalogCategory">Category: </label>
                        <select class="form-control" name="catalogCategory" id="category"  />
                            <option></option>
                            <option>Clipless</option>
                            <option>Platform</option>
                          </select>
                    </div>
                </div>
                
                <div class="row">
                    <div class="form-group col-sm-5">
                        <label for="description">Description </label>
                        <textarea class="form-control" id="description" name="description" placeholder="<c:out value="${productToEdit.description}" />" rows="3"></textarea>
                    </div>
                </div>
                
                <div class="row">
                    <div class="form-group col-sm-5">
                        <label for="price">Price: </label>
                        <input type="number" class="form-control" name="price" id="price" placeholder="<c:out value="${productToEdit.price}" />" />
                    </div>
                </div>
                    
                 <div class="row">
                    <div class="form-group col-sm-5">
                        <label for="imageURL">imageURL: </label>
                        <input type="text" class="form-control" name="imageURL" id="imageURL" placeholder="<c:out value="${productToEdit.imageURL}" />" />
                    </div>
                </div>   
                    
                <button type="submit" class="btn btn-success" id="update-user-button">Update</button>
            </form>
        </section> 
    </main>
<jsp:include page="includes/footer.jsp" />
