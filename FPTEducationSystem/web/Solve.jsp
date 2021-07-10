<%-- 
    Document   : Solve
    Created on : Jun 28, 2021, 10:13:19 AM
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
                <div class="homeTilte"><h2>RequestID:${req.id}</h2> </div>
                <div class="Solve">
                    <form action="Solve" method="POST">
                        <input type="hidden" value="${req.id}" name="id">
                        <div class="department" >Request to department <input type="text" value="${req.department.name}" readonly name="department"></div>
                        <div class="studentID" >Student ID <input  type="text" value="${req.studentID}" readonly name="studentID"></div>
                        <div class="studentName" >Student name <input type="text" value="${req.studentName}" readonly name="studentName"></div>
                        <div class="dateCreated" >Date created <input type="text"value="${req.dateCreated}" readonly name="dateCreated"></div>
                        <div class="requestTitle" >Request title <input type="text"value="${req.title}" readonly name="requestTitle"></div>
                        <div class="requestContent" ><p>Request content</p> <textarea readonly  style="margin: 0px; width: 300px; height: 50px;" name="requestContent">${req.content}</textarea></div>
                        <div class="requestState" >Request State <input id="Approved" value="Approved" type="radio" name="state"><label class="Approved" for="Approved">Approved</label> <input id="Reject" value="Reject" type="radio" name="state"> <label class="Reject" for="Reject">Reject</label> </div>
                        <div class="closeDate" >Close date <input type="text"readonly value="${nowDate}" name="closeDate"></div>
                        <div class="admin" >Solve by <input type="text" value="${username}"readonly name="admin"></div>
                        <div class="solution" ><p>School solution</p> <textarea required="required" minlength="1" maxlength="300" style="margin: 0px; width: 300px; height: 50px;" name="solution"></textarea></div>

                        <input type="submit" value="Save">
                    </form>
                </div>
            </div>
        </div>
        <jsp:include page="Footer.jsp"/>
    </body>

</html>
