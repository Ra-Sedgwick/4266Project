<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <div class="talbe-responsive">
        <table class="table table-striped table-hover">
            <tr>
                <th class="table-width">Item</th>
                <th class="table-width">Price</th>
                <th class="table-width">Quantity</th>
            </tr>
            <c:forEach var="item" items="${theShoppingCart.orderItems}" >
                <tr>
                    <td><c:out value="${item.product.productName}" /></td>
                    <td><c:out value="${item.product.price}" /></td>
                    <td>
                        <input type="text" class="form-control table-quantity" name="quantity[]" value="<c:out value="${item.quantity}" />"  style="text-align: right"/>
                        <input type="hidden"  name="productList[]" value="<c:out value="${item.product.productCode}" />" />
                    </td>
                </tr>
            </c:forEach>
        </table>       
    </div>
</div>   
