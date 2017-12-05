
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="includes/header.jsp" />

    <main>
        
        <jsp:include page="includes/site-navigation.jsp" />
        
        <section>
            <h1>User List</h1>
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
                        <c:forEach var="user" items="${userList}">
                            <tr>
                                <td><c:out value="${user.firstName}" /></td>
                                <td><c:out value="${user.lastName}" /></td>
                                <td><c:out value="${user.email}" /></td>
                                <td><c:out value="${user.addressField_1}" /></td>
                                <td><c:out value="${user.addressField_1}" /></td>
                                <td><c:out value="${user.city}" /></td>
                                <td><c:out value="${user.state}" /></td>
                                <td><c:out value="${user.postCode}" /></td>
                                <td><c:out value="${user.country}" /></td>
                                <td><c:out value="${user.secret}" /></td>
                                <td><c:out value="${user.password}" /></td>
                                <td>
                                    <input type="hidden" name="userId" value="${user.id}" />
                                    <button class="btn btn-warning" name="action" formaction="UserController" value="edit">Edit</button>

                                </td>
                            </tr>

                        </c:forEach>
                    </table>
                </form>
            </div>
            
        </section>

    </main>
            
<jsp:include page="includes/footer.jsp" />