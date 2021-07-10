<%-- 
    Document   : Left
    Created on : Jun 21, 2021, 8:26:57 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/Left.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <c:if test="${username == null}">
            <div class="a"><a href="Login"><button>Login</button></a></div>
            </c:if>
            <c:if test="${username != null}">
        <div class="a"><a href="LogOut"><button>Welcome ${username},<br>Log out</button></a></div>
        </c:if>
<div class="a"><a href="Home"><button>Home</button></a></div>
<div class="a"><a href="View"><button>View requests</button></a></div>
<div class="a"><a href="Solve"><button>Solve requests</button></a></div>
<div class="date"><a href=""><button>Today is: ${dateTime}</button></a></div>

</body>
</html>
