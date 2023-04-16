<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%
        // Session dan veriyi alalım.
        String username = (String) session.getAttribute("username");

        if (username == null || username.isEmpty()) {
            response.sendRedirect("Login.jsp");
        } else {
            out.println("<h1>Hoşgeldin, " + username + "!</h1>");
            out.println("<a href='Logout.jsp'>Çıkış Yap</a>");
        }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>