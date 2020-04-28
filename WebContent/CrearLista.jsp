<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="pojo.Usuario"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crear genero para canciones</title>
</head>
<body>
	<div id="divLogo">
		<img id="Logo" src="">
	</div>
	<div id="cajaUsuario">
		<%
			Usuario usuario = (Usuario) request.getAttribute("usuario");
			String logout = "Logout";
			String inicio = "Principal";
			if (usuario != null) {
				out.print("<img src='Imatges/" + usuario.getFoto() + "'><br>");
				out.print("<p>" + usuario.getNombre() + "</p>");
				out.print("<a href='" + logout + "'>Logout</a> | <a href='" + inicio + "'>Inicio</a>");
			}
		%>
	</div>
	<form method="post" action="CrearLista">
		<p>Nombre de la lista de reproduccion</p>
		<input type="text" name="nombre" required>
		<%
			out.print("<input type='hidden' value='" + usuario.getId() + "' name='id'>");
		%>
		<input type="submit" value="Crear lista">
	</form>
</body>
</html>