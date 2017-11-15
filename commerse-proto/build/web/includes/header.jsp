<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <link rel="stylesheet" href="styles/main.css">
        <!--    jQuery CDN      -->
        <script
          src="https://code.jquery.com/jquery-3.2.1.min.js"
          integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
          crossorigin="anonymous">
        </script>

        <!--    jQueryUI CDN     -->
        <script
            src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"
            integrity="sha256-VazP97ZCwtekAsvgPBSUwPFKdrwD3unUfSGVYrahUqU="
            crossorigin="anonymous">
        </script>

        <!--    Site Javascript     -->
        <script src="scripts/site.js"> </script>
    </head>
    <header>
        <c:choose>
            <c:when test="${theUser.email != null}">
                <p id="login-msg">${theUser.email}"</p>
            </c:when>
            <c:otherwise>
                <p id="login-msg">Not logged in...</p>
            </c:otherwise>
        </c:choose>
<!--                <p id="login-msg">${theUser.email}</p>-->
<!--        <h1><img src='pedal.jpg' alt="" style="width:100px">Just Bike Pedals!</h1>   -->
    </header>
    <nav>
        <a href="login.jsp">Log In</a>
        <a href="cart.jsp">Cart</a>
        <a href="OrderController?action=viewOrders">My Orders</a>
    </nav>
    <body>