<%-- 
    Document   : View
    Created on : Jun 23, 2021, 10:43:08 AM
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
            <div class="viewMid">
                <div class="homeTilte"><h2>View requests</h2> </div>
                <table >
                    <tr>
                        <th>
                            <form id="frmSearch" action="View" method="GET">
                                <div class="tileTable">
                                    Select department:
                                    <select name="id_Department" onchange="submitForm();">
                                        <option value="0">Pls Select a Department</option>
                                        <c:forEach items="${departments}" var="d">
                                            <option
                                                <c:if test="${d.id == id_Department}" >
                                                    selected="selected"
                                                </c:if>
                                                value ="${d.id}"> ${d.name}
                                            </option> 
                                        </c:forEach>
                                    </select>
                                    <div class="search"><b>or enter request title</b> <input type="text" value="${title}" name="title"> <input type="submit" value="View"></div>
                                </div>

                            </form>
                        </th>
                    </tr>
                </table>
                <table>
                    <tr>
                        <th>Request title</th>
                        <th>Date created</th>
                        <th>Close created</th>
                        <th>Status</th>
                        <th>Report to</th>
                        <th>Detail</th>
                    </tr>
                    <c:forEach items="${requests}" var="r">
                        <tr>
                            <td>${r.title}</td>
                            <td>${r.dateCreated}</td>
                            <td>${r.closeDatel}</td>
                            <td>${r.status}</td>
                            <td>${r.department.name}</td>
                            <c:if test="${r.detail}">
                                <td>Sovled</td>
                            </c:if>
                            <c:if test="${!r.detail}">
                                <td><a href="Solve?id=${r.id}">Sovle</a></td>
                            </c:if>

                        </tr>
                    </c:forEach>
                </table>
                <div id="bottomPagger" class="pagger">
                    <c:if test="${totalPage gt 1}">
                        <c:forEach begin="1" end="${totalPage}" var="i">
                            <a class="${i==pageIndex?"active":""}" href="View?page=${i}">${i}</a>
                        </c:forEach>
                    </c:if>

                </div>

            </div>
        </div>
        <jsp:include page="Footer.jsp"/>

    </body>
    <script>
        function submitForm()
        {
            document.getElementById("frmSearch").submit();
        }

    </script>
</html>
