<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section>
    <h1>Enter Your Payment Information</h1>

    <hr>
    
    <form  class="form-group" action="OrderController?action=confirmOrder" method="post">
        
        <label for="masterCard">Card Type: </label>
        <select class="form-control" name="Credit Card Type" id="card-type">
            <option value="masterCard">Master Card</option>
            <option value="visa">Visa</option>
        </select> <br>
        
        <label for="cardNumber">Card Number: </label>
        <input type="text" class="form-control label-offset" id="cardNumber" name="Card Number" /> <br>
        
        <label for="datepicker">Date: </label>
        <input type="text" class="form-control label-offset" id="datepicker" /></br>
        
        <label for="cvv">CVV (3-Digit) : </label>
        <input type="text" class="form-control label-offset" id="cvv" /> </br>
        
        <hr class="line-break">

        <p> Your card will be charged a total of: <span id="payment-total">$${currentOrder.totalCost}<span> </p>
            
        <button type="submit"  class="btn btn-warning"name="purchase">Confirm Payment</button>
        
    </form>
    
    
        
    

    
</section>