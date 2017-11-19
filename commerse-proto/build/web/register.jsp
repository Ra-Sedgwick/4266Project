<jsp:include page="includes/header.jsp" />
    <main>
        <jsp:include page="includes/site-navigation.jsp" />
        <section>
            <h1>Register</h1>
            <hr>
            <form action="RegisterController" method="POST">
                <div class="row">
                    <div class="form-group col-sm-5">
                        <label for="firstName">First Name: </label>
                        <input type="text" class="form-control" name="firstName" id="firstName">
                    </div>
                </div>
                
                <div class="row">
                    <div class="form-group col-sm-5">
                        <label for="lastName">Last Name: </label>
                        <input type="text" class="form-control" name="lastName" id="lastName">
                    </div>
                </div>
                
                <div class="row">
                    <div class="form-group col-sm-5">
                        <label for="email">Email: </label>
                        <input type="email" class="form-control" name="email" id="email">
                    </div>
                </div>
                
                <div class="row">
                    <div class="form-group col-sm-5">
                        <label for="address-1">Address 1: </label>
                        <input type="text" class="form-control" name="address-1" id="address-1">
                    </div>
                </div>
                
                <div class="row">
                    <div class="form-group col-sm-5">
                        <label for="address-2">Address 2: </label>
                        <input type="text" class="form-control" name="address-2" id="address-2">
                    </div>
                </div>
                
                <div class="row">
                    <div class="form-group col-sm-5">
                        <label for="city">City: </label>
                        <input type="text" class="form-control" name="city" id="city">
                    </div>
                </div>
                
                <div class="row">
                    <div class="form-group col-sm-5">
                        <label for="state">State: </label>
                        <input type="text" class="form-control"name="state" id="state">
                    </div>
                </div>
                
                <div class="row">
                    <div class="form-group col-sm-5">
                        <label for="postCode">Zip Code: </label>
                        <input type="text" class="form-control" name="postCode" id="postCode">
                    </div>
                </div>
                
                <div class="row">
                    <div class="form-group col-sm-5">
                        <label for="country">Country </label>
                        <input type="text" class="form-control" name="country" id="country">
                    </div>
                </div>
                
                <div class="row">
                    <div class="form-group col-sm-5">
                        <label for="password">Password: </label>
                        <input type="password" class="form-control" name="password" id="password">
                    </div>
                </div>
                <input type="hidden" value="user" />
                <input type="submit" value="Submit" class="btn btn-success" />
                
            </form>
        </section> 
    </main>
<jsp:include page="includes/footer.jsp" />