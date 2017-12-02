<%-- 
    Document   : cart
    Created on : Oct 2, 2017, 9:04:36 PM
    Author     : robert
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="styles/main.css">
    </head>
    <header>
        <p id="login-msg">Not logged in...</p>
        <h1><img src='pedal.jpg' alt="bike pedal" style="width:100px">Just Bike Pedals!</h1>   
    </header>
    <nav>
        <a href="login.html">Log In</a>
        <a href="cart.html">Cart</a>
        <a href="orders.html">Orders</a>
    </nav>
    <main>
        <aside>
            <a href="index.html">Home</a>
            <a href="catalog.html">Catalog</a>
            <a href="about.html">About</a>
            <a href="contact.html">Contact</a>

        </aside>
        <section>
            <h2>Your Cart</h2>
            <div id="cart-container">
                <table>
                <tr>
                    <th>Item</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Total</th>
                </tr>
                <tr>
                    <td>Blue Clipless Pedal</td>
                    <td>$98.99</td>
                    <td>
                        <form>
                            <input type="text" name="Quantity" value="1" />
                        </form>
                    </td>
                    <td>$99.99</td>
                </tr>
                <tr style="width:25px">
                    <td>Red Platform Pedal</td>
                    <td>$20.00</td>
                    <td>
                        <form>
                            <input type="text" name="Quantity" value="2" style="text-align: right"/>
                        </form>
                    </td>
                    <td>$40.00</td>
                </tr>
            </table>
            <form class="cart-button">
                <button type="submit" formaction="cart.html">Update Cart</button>
                <button type="submit" formaction="catalog.html">Check Out</button>   
             </form>         
            </div>
            
        </section>
    </main>
    <footer>
        <p>&copy; Roberts Just Bike Pedals LLC</p>
    </footer>
</html>
