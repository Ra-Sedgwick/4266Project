<jsp:include page="includes/header.jsp" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    <main>
        <jsp:include page="includes/site-navigation.jsp" />
        <section>
            <h1>Edit Order</h1>
            <hr>
            
            <c:if test="${registerError != null}">
                <h3 class="loginError">${registerError}</h3>
            </c:if>
            
            <form id="update-user-form" action="AdminController"  method="POST">
                
                <div class="row">
                    <div class="form-group col-sm-5">
                        <label for="orderNumber">Order Number </label>
                        <input type="text" class="form-control" name="orderNumber" id="orderNumber" placeholder="${orderToUpdate.orderNumber}">
                    </div>
                </div>
                
                <div class="row">
                    <div class="form-group col-sm-5">
                        <label for="userEmail">User Email </label>
                        <input type="text" class="form-control" name="userEmail" id="userEmail" placeholder="${orderToUpdate.user.email}">
                    </div>
                </div>
                    
                 <div class="row">
                    <div class="form-group col-sm-5">
                        <label for="date">Date </label>
                        <input type="text" class="form-control label-offset" name="date" id="datepicker2" placeholder="${orderToUpdate.date}"><br>
                    </div>
                </div>
                
                <div class="row">
                    <div class="form-group col-sm-5">
                        <label for="totalCost">Total Cost </label>
                        <input type="text" class="form-control" name="totalCost" id="totalCost" placeholder="${orderToUpdate.totalCost}">
                    </div>
                </div>
                    
                <input type="submit" name="action" value="update" class="btn btn-success" id="update-user-button"/>
            </form>
        </section> 
    </main>
<jsp:include page="includes/footer.jsp" />