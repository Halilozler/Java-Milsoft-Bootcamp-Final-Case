<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
        // Kullanıcı adı ve şifreyi al
        String username = "";
        String password = "";
        if(request.getParameter("add")!= null){
        	username = request.getParameter("username");
            password = request.getParameter("password");
            if ("godoro".equals(username) && "java".equals(password)) {
                session.setAttribute("username", username);
                response.sendRedirect("Home.jsp");
            }
        }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login</h1>
    <form action="Login.jsp">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br><br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>
        <input type="submit" value="Login" name="add">
    </form>
</body>
</html>