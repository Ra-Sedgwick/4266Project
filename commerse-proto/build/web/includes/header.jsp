<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Rsedgwic</title>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <link href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.7/flatly/bootstrap.min.css" rel="stylesheet" integrity="sha384-+ENW/yibaokMnme+vBLnHMphUYxHs34h9lpdbSLuAwGkOKFRl4C34WkjazBtb7eT" crossorigin="anonymous">
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
        
        
        <!--        Bootstrap-      -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" 
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" 
        crossorigin="anonymous"></script>
        
        
        <!--    Site Javascript     -->
        <script src="scripts/site.js"> </script>
    </head>

    <nav class="navbar navbar-default">
      <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
            <a class="navbar-brand" href="./">Just Pedals</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav"></ul>
            <ul class="nav navbar-nav pull-right">
                <li>
                <c:choose>
                    <c:when test="${theUser.email != null}">
                        <form action="LoginController">

                            <input type="hidden" name="action" value="signOut" />
                                <span id="user-email"><c:out value="${theUser.email}" /></span>
                                <button formaction="cart.jsp" class="btn btn-default nav-button">Cart</button>
                                <a href="#" class="dropdown-toggle btn btn-default nav-button" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">My Account <span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                  <li><a href="OrderController?action=viewOrders">My Orders</a></li>
                                  <li><a href="user.jsp">My Info</a></li>
                                </ul>
                                <button type="submit" class="btn btn-default nav-button">Sign Out</button>

                        </form>

                    </c:when>
                    <c:otherwise>
                        <form action="./login.jsp">
                                <button formaction="cart.jsp" class="btn btn-default nav-button">Cart</button>                                
                                <a href="#" class="dropdown-toggle btn btn-default nav-button" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Sign In <span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                  <li><a href="./login.jsp">Customer</a></li>
                                  <li><a href="./admin.jsp">Administrator</a></li>
                                </ul>

                        </form>
                    </c:otherwise>
                </c:choose>
                </li>
                
            </ul>
          
        </div><!-- /.navbar-collapse -->
      </div><!-- /.container-fluid -->
    </nav>
    <body>