
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="includes/header.jsp" />

    <main>
        
        <jsp:include page="includes/site-navigation.jsp" />
        
        <section>
            <h1>User Info</h1>
            <hr>
            <div class="table-responsive">
                <form>
                    <table class="table table-striped table-hover">
                        <tr>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Email</th>
                            <th>Address 1</th>
                            <th>Address 2</th>
                            <th>city</th>
                            <th>State</th>
                            <th>Zip Code</th>
                            <th>Country</th>
                            <th>Secret</th>
                            <th>Password</th>
                            <th>Controls</th>
                        </tr>
                        <tr>
                            <td><c:out value="${theUser.firstName}" /></td>
                            <td><c:out value="${theUser.lastName}" /></td>
                            <td><c:out value="${theUser.email}" /></td>
                            <td><c:out value="${theUser.addressField_1}" /></td>
                            <td><c:out value="${theUser.addressField_1}" /></td>
                            <td><c:out value="${theUser.city}" /></td>
                            <td><c:out value="${theUser.state}" /></td>
                            <td><c:out value="${theUser.postCode}" /></td>
                            <td><c:out value="${theUser.country}" /></td>
                            <td><c:out value="${theUser.secret}" /></td>
                            <td><c:out value="${theUser.password}" /></td>
                            <th>
                                <input type="hidden" name="userId" value="${theUser.id}" />
                                <button class="btn btn-xs btn-warning" name="action" formaction="UserController" value="edit">Edit</button>

                            </th>
                        </tr>

                    </table>
                </form>
            </div>
            
        </section>

    </main>
            
<jsp:include page="includes/footer.jsp" />