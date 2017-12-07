<jsp:include page="includes/header.jsp" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    <main>
        <jsp:include page="includes/site-navigation.jsp" />
        <section>
            <h1>Create Product</h1>
            <hr>
            
            <c:if test="${registerError != null}">
                <h3 class="loginError">${registerError}</h3>
            </c:if>
            
            <form id="update-user-form" action="AdminController"  method="POST">
                
                <div class="row">
                    <div class="form-group col-sm-5">
                        <label for="productName">Product Name: </label>
                        <input type="text" class="form-control" name="productName" id="productName" />
                    </div>
                </div>
                
                <div class="row">
                    
                 <div class="form-group col-sm-5">
                     <label for="category">Category:</label><br>
                    <select class="form-control" name="category" id="category">
                      <option>Clipless</option>
                      <option>Platform</option>
                    </select>
                  </div>
                </div>
                
                <div class="row">
                    <div class="form-group col-sm-5">
                        <label for="description">Description </label>
                        <textarea class="form-control" id="description" name="description" rows="3"></textarea>
                    </div>
                </div>
                
                <div class="row">
                    <div class="form-group col-sm-5">
                        <label for="price">Price: </label>
                        <input type="number" class="form-control" name="price" id="price" />
                    </div>
                </div>
                
                <input type="submit" name="action" value="Create" class="btn btn-success" id="update-user-button"/>
                
            </form>
        </section> 
    </main>
<jsp:include page="includes/footer.jsp" />