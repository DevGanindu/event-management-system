<%-- 
    Document   : eventForm
    Created on : Apr 4, 2025, 9:38:25 AM
    Author     : KZONE USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="ParticipantServlet" method="post">
        Name: <input type="text" name="name"/><br/>
        Email: <input type="text" name="email"/><br/>
        Event: <input type="text" name="event"/><br/>
        <input type="submit" value="Register"/>
        </form>
        
        <% String msg = (String) request.getAttribute("message"); %>
        <% if (msg != null) { %>
            <p style="color: green;"><%= msg %></p>
        <% } %>


    </body>
</html>
