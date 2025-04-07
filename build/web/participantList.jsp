<%-- 
    Document   : participantList
    Created on : Apr 4, 2025, 9:38:49 AM
    Author     : KZONE USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Participant List</title>
    </head>
    <body>
        <c:forEach var="participant" items="${ParticipantList}">
        <p>${participant.name} - ${participant.email} - ${participant.event}</p>
        </c:forEach>
    </body>
</html>
