<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section>
    <h1>Enter Your Payment Information</h1>

    <hr>
    
    <form action="" metho="POST">
        
        <label for="masterCard">Card Type: </label>
        <select name="Credit Card Type" id="card-type">
            <option value="masterCard">Master Card</option>
            <option value="visa">Visa</option>
        </select> <br>
        
        <label for="cardNumber">Card Number: </label>
        <input type="text" id="cardNumber" name="Card Number" value="No dashes" /> <br>
        
        <label for="datepicker">Date: </label>
        <input type="text" id="datepicker" /></br>
        
        <label for="cvv">CVV (3-Digit) : </label>
        <input type="text" id="cvv" /> </br>
        
        <hr class="line-break">

        <p> Your card will be charged a total of: $100.99 </p>
            
        <input type="submit" value="Confirm Payment" name="purchase" />
        
    </form>
    
    
        
    

    
</section>