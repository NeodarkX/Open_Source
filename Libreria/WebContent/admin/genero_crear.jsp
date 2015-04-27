<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<% String nombre = (String)session.getAttribute("nombre"); %>
<body>
<h2>Bienvenido <%=nombre %></h2>
<h3>Registro de Genero literario</h3>
<form action="../Genero_Agregar" method="post">
<p>Nombres: <input type="text" name="nombres" /></p>
<p>Descripcion: <input type="text" name="descripcion"></p>
<p><input type="submit" name="" value="Guardar genero" /></p>
</form>
</body>
</html>