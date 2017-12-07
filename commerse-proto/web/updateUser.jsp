<jsp:include page="includes/header.jsp" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    <main>
        <jsp:include page="includes/site-navigation.jsp" />
        <section>
            <h1>Edit User</h1>
            <hr>
            
            <c:if test="${registerError != null}">
                <h3 class="loginError">${registerError}</h3>
            </c:if>
            
            <form id="update-user-form" action="UserController"  method="POST">
                <div class="row">
                    <div class="form-group col-sm-5">
                        <label for="firstName"><sup>*</sup>First Name: </label>
                        <input type="text" class="form-control" name="firstName" id="firstName" placeholder="<c:out value="${updateUser.firstName}" />">
                    </div>
                </div>
                
                <div class="row">
                    <div class="form-group col-sm-5">
                        <label for="lastName"><sup>*</sup>Last Name: </label>
                        <input type="text" class="form-control" name="lastName" id="lastName" placeholder="<c:out value="${updateUser.lastName}" />">
                    </div>
                </div>
                
                <div class="row">
                    <div class="form-group col-sm-5">
                        <label for="email"><sup>*</sup>Email: </label>
                        <input type="email" class="form-control" name="email" id="email" placeholder="<c:out value="${updateUser.email}" />">
                    </div>
                </div>
                
                <div class="row">
                    <div class="form-group col-sm-5">
                        <label for="address-1">Address 1: </label>
                        <input type="text" class="form-control" name="address-1" id="address-1" placeholder="<c:out value="${updateUser.addressField_1}" />">
                    </div>
                </div>
                
                <div class="row">
                    <div class="form-group col-sm-5">
                        <label for="address-2">Address 2: </label>
                        <input type="text" class="form-control" name="address-2" id="address-2" placeholder="<c:out value="${updateUser.addressField_2}" />">
                    </div>
                </div>
                
                <div class="row">
                    <div class="form-group col-sm-5">
                        <label for="city">City: </label>
                        <input type="text" class="form-control" name="city" id="city" placeholder="<c:out value="${updateUser.city}" />">
                    </div>
                </div>
                
                <div class="row">
                    <div class="form-group col-sm-5">
                        <label for="state">State: </label>
                        <input type="text" class="form-control"name="state" id="state" placeholder="<c:out value="${updateUser.state}" />">
                    </div>
                </div>
                
                <div class="row">
                    <div class="form-group col-sm-5">
                        <label for="postCode">Zip Code: </label>
                        <input type="text" class="form-control" name="postCode" id="postCode" placeholder="<c:out value="${updateUser.postCode}" />">
                    </div>
                </div>
                
                <div class="row">
                    <div class="form-group col-sm-5">
                        <label for="country">Country </label>
                        <input type="text" class="form-control" name="country" id="country" placeholder="<c:out value="${updateUser.country}" />">
                    </div>
                </div>
                    
                <div class="row">
                    <div class="form-group col-sm-5">
                        <label for="secret">Secret Question:<br> What is your favorite fruit? </label>
                        <input type="text" class="form-control" name="secret" id="secret" placeholder="<c:out value="${updateUser.secret}" />">
                    </div>
                </div>
                
                <div class="row">
                    <div class="form-group col-sm-5">
                        <label for="password"><sup>*</sup>Password: </label>
                        <input type="password" class="form-control" name="password" id="password" placeholder="<c:out value="${updateUser.password}" />">
                    </div>
                </div>
                <input type="hidden" name="userId" value="<c:out value="${updateUser.id}" />"/>
                <input type="submit" name="action" value="Update" class="btn btn-success" id="update-user-button"/>
                
            </form>
        </section> 
    </main>
<jsp:include page="includes/footer.jsp" />