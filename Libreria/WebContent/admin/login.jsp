<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<% String mensaje = (String)request.getAttribute("mensaje"); %>
<body>
<h2>Inicio de sesión</h2>
<form action="<%=getServletContext().getContextPath() %>/Usuario" method="post">
<p>Usuario: <input type="text" name="usuario" /></p>
<p>Clave: <input type="text" name="clave" /></p>
<% if(mensaje != null){ %>
<p><%=mensaje%></p>
<% } %>
<p><input type="submit" name="" value="Ingresar" /></p>
</form>
</body>
</html>