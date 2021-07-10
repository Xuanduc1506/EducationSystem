<%-- 
    Document   : Error
    Created on : Jun 24, 2021, 7:53:19 PM
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
            <div class="homeMid">
                <div class="homeTilte"><h2>${message}</h2> </div>
            </div>
        </div>
        <jsp:include page="Footer.jsp"/>
    </body>
</html>
