<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <c:choose>
            <c:when test="${theUser.email != null}">
                <p id="login-msg">${theUser.email}"</p>
            </c:when>
            <c:otherwise>
                <p id="login-msg">Not logged in...</p>
            </c:otherwise>
        </c:choose>
<!--                <p id="login-msg">${theUser.email}</p>-->
        <h1><img src='pedal.jpg' alt="" style="width:100px">Just Bike Pedals!</h1>   
    </header>
    <nav>
        <a href="login.jsp">Log In</a>
        <a href="OrderController">Cart</a>
        <a href="order.jsp">Order</a>
    </nav>