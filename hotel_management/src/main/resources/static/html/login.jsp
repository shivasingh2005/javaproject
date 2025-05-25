<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Hotel Login</title>
    <link rel="stylesheet" href="../assets/css/style.css">
</head>
<body>
    <form method="post" action="../login">
        <h2>Login</h2>
        <input type="text" name="username" placeholder="Username" required/><br>
        <input type="password" name="password" placeholder="Password" required/><br>
        <button type="submit">Login</button>
        <p style="color:red">${error}</p>
    </form>
</body>
</html>
