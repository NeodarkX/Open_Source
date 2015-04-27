<%@page import="beans.AutorBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%
	AutorBean autor = (AutorBean)request.getAttribute("objAutor");
%>
<% String nombre = (String)session.getAttribute("nombre"); %>
<body>

<h2>Bienvenido <%=nombre %></h2>
<h3>Edición de autores</h3>
<form action="<%=getServletContext().getContextPath() %>/Autor_Editar" method="post">
<input type="hidden" name="id" value="<%=autor.getId() %>" />
<p>Nombres: <input type="text" name="nombres" value="<%=autor.getNombres() %>" /></p>
<p>Apellidos: <input type="text" name="apellidos" value="<%=autor.getApellidos() %>" /></p>
<p>Nacionalidad: <input type="text" name="nacionalidad" value="<%=autor.getNacionalidad() %>" /></p>
<p><input type="submit" name="" value="Guardar autor" /></p>
</form>
</body>
</html>