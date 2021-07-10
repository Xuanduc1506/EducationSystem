<%-- 
    Document   : Login
    Created on : Jun 21, 2021, 9:58:21 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/Login.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:include page="Header.jsp"/>
        <div class="login">
            <div class="left">
                <jsp:include page="Left.jsp"/>
            </div>
            <div class="loginMid">
                <div class="loginTitle">
                    <h2>Member Login</h2>
                    <h6>Using your username and password.</h6>
                </div>

                <div class="input">
                    <form action="" method="POST">
                        <div class="username" >Username <input type="text" name="username"><p>(*)</p></div>
                        <div class="password" >Password <input type="password" name="password"><p>(*)</p></div>
                        <div class="submit"><input type="submit" value="Log in"></div>
                        <div class="noticing">The field <p>(*)</p>is required </div>
                    </form>
                </div>
            </div>
        </div>
        <jsp:include page="Footer.jsp"/>

    </body>
</html>
