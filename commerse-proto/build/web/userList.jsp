
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="includes/header.jsp" />

    <main>
        
        <jsp:include page="includes/site-navigation.jsp" />
        
        <section>
            <h1>Order List</h1>
            <hr>
            <div class="table-responsive">
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
                        <th>Password</th>
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
                            <td><c:out value="${user.password}" /></td>
                        </tr>

                    </c:forEach>
                </table>
            </div>
            
        </section>

    </main>
            
<jsp:include page="includes/footer.jsp" />