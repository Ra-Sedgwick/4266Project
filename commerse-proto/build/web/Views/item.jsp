<%-- 
    Document   : item
    Created on : Oct 2, 2017, 9:06:12 PM
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
            <h2>Current Item</h2>
            <figure>
                <img src='pedal.jpg' style='height:200px'>
                <figcaption>
                    <h3>Blue Clipless Pedal: $99.99</h3>
                    <p>Make all your friends jealous with this super cool </p>
                    <p>blue clipless pedal! Dont twist you ankle.</p>
                </figcaption>

            </figure>
            <form action="cart.html">
                <input class="add-item-button" type="submit" value="add-item" />
            </form>
        </section>
    </main>
    <footer>
        <p>&copy; Roberts Just Bike Pedals LLC</p>
    </footer>
</html>
