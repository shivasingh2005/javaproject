<%@ page import="com.hotel.model.User" %>
<%@ page session="true" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<html>
<head>
    <title>Dashboard</title>
</head>
<body>
    <h1>Welcome, <%= user.getUsername() %>!</h1>
    <p>You are logged in as <%= user.getRole() %>.</p>
</body>
</html>
