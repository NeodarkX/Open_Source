<%@page import="beans.GeneroBean"%>
<%@page import="beans.EditorialBean"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<% String nombre = (String)session.getAttribute("nombre"); %>s
<body>
<%
	Vector<GeneroBean> generos = (Vector<GeneroBean>)request.getAttribute("listageneros");
	Vector<EditorialBean> editorials = (Vector<EditorialBean>)request.getAttribute("listaeditorials");
%>

<h1>Registro de libros</h1>
<form method="post">
<p>Genero</p>
<select>
<% for(int i=0;i<generos.size();i++){%>
	<option value="<%=generos.get(i).getId()%>"><%=generos.get(i).getNombres()%></option>
<% } %>
</form>
</select>


<p>Editorial</p>
<select>
<% for(int i=0;i<editorials.size();i++){%>
	<option value="<%=generos.get(i).getId()%>"><%=generos.get(i).getNombres()%></option>
<% } %>
</form>
</select>

<p>Titulo</p>
<input type="text" name="titulos"/>
<p>Precio</p>
<input type="text" name="Precio" />
<p>ISBN</p>
<input type="text" name="ISBN" />
<p>Sinopsis</p>
<textarea name="sinopsis" rows="5">
</textarea>
<p><input type="submit" name="" value="Guardar Libro" /></p>
</body>
</html>