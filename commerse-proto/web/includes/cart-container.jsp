<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    
    
    
    <table>
        <tr>
            <th>Item</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Total</th>
        </tr>
        <c:forEach var="item" items="${theShoppingCart.orderItems}" >
            <tr>
                <td>${item.product.productName}</td>
                <td>${item.product.price}</td>
                <td>
                    <input type="text" name="quantity[]" value="${item.quantity}"  style="text-align: right"/>
                    <input type="hidden" name="productList[]" value="${item.product.productCode}" />
                </td>
                <td>${item.getTotal()}</td>
            </tr>
            
        </c:forEach>
<!--        <tr>
            <td>Blue Clipless Pedal</td>
            <td>$98.99</td>
            <td>
                
               <input type="text" name="Quantity" value="1" />
               <input type="hidden" name="productList[]" value="4" />
            </td>
            <td>$99.99</td>
        </tr>
        <tr style="width:25px">
            <td>Red Platform Pedal</td>
            <td>$20.00</td>
            <td>
               
                <input type="text" name="Quantity" value="2" style="text-align: right"/>
               <input type="hidden" name="productList[]" value="5" />
            </td>
            <td>$40.00</td>
        </tr>-->
    </table>         
</div>   
