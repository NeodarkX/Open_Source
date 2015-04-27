<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% String nombre = (String)session.getAttribute("nombre"); %>

<h2>Bienvenido <%=nombre %></h2>
<h3>Opciones disponibles</h3>
<ul>
<li><a href="admin/autor_agregar.jsp">Agregar autor</a></li>
<li><a href="admin/genero_crear.jsp">Agregar genero</a></li>
<li><a href="admin/editorial_crear.jsp">Agregar genero</a></li>
<li><a href="<%=getServletContext().getContextPath() %>/Autor_Listar">Listar autor</a></li>
<li><a href="<%=getServletContext().getContextPath() %>/Usuario">Cerrar sesión</a></li>
</ul>
</body>
</html>