<%-- 
    Document   : Home
    Created on : Jun 22, 2021, 10:49:20 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <div class="homeTilte"><h2>Request recived by today:${date}</h2> </div>
                <table>
                    <tr>
                        <th>Department name</th>
                        <th>Number of request</th>
                        <th>View detail</th>
                    </tr>
                    <c:forEach items="${departments}" var="d">
                        <tr>
                            <td><div class="departementName">${d.name}</div></td>
                            <td>${d.requests.size()}</td>
                            <td> <a class="view" href="View?id_Department=${d.id}">View</a></td>
                        </tr>
                    </c:forEach>
                </table>
                <br>
                <br>
                <div class="homeTilte"><h2>Request recived by Lastday</h2> </div>
                <table>
                    <tr>
                        <th>Department name</th>
                        <th>Number of request</th>
                        <th>View detail</th>
                    </tr>
                    <c:forEach items="${departmentsLastday}" var="d">
                        <tr>
                            <td><div class="departementName">${d.name}</div></td>
                            <td>${d.requests.size()}</td>
                            <td> <a class="view" href="View?id_Department=${d.id}">View</a></td>
                        </tr>
                    </c:forEach>
                </table>
                <div id="bottomPagger" class="pagger">
                    <c:forEach begin="1" end="${totalPage}" var="i">
                        <a class="${i==pageIndex?"active":""}" href="Home?page=${i}">${i}</a>
                    </c:forEach>
                </div>

            </div>
        </div>
        <jsp:include page="Footer.jsp"/>

    </body>
</html>
