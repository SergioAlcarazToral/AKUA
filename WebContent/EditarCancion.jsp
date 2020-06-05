<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="pojo.Usuario"%>
<%@ page import="pojo.Genero"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="pojo.Cancion"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar cancion</title>
<link
	href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@700&family=Hind+Madurai:wght@300&display=swap"
	rel="stylesheet">
</head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel='stylesheet' type='text/css' href='css.css'>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel='stylesheet' type='text/css' href='css.css'>
</head>
<body>
	<div id="divLogo">
		<a href="Principal"><img id="Logo" src="icons/akua negro.png"></a>
	</div>
	<div id="cajaUsuario">
		<%
			Usuario usuario = (Usuario) request.getAttribute("usuario");
			ArrayList<Genero> generos = (ArrayList<Genero>) request.getAttribute("generos");
			Cancion cancion = (Cancion) request.getAttribute("cancion");
			if (usuario != null) {
				String logout = "Logout";

				out.print("<img id='fotoUser' src='Imatges/" + usuario.getFoto() + "'><br>");
				out.print("<p>" + usuario.getNombre() + "</p>");
				out.print("<a href='" + logout + "'>Logout</a>");

			}
		%>
	</div>
	<form id='formCancion' action="EditarCancion" method="post">
		<p>Titulo de la cancion</p>
		<%
			out.print("<input type='text' name='titulo' value='" + cancion.getTitulo() + "' required>");
		%>
		<p>Genero</p>

		<select name="genero">
			<%
				for (Genero g : generos) {
					if (cancion.getId() == g.getId()) {
						out.print("<option value='" + g.getId() + "' selected>" + g.getNombre() + "</option>");
					} else {
						out.print("<option value='" + g.getId() + "'>" + g.getNombre() + "</option>");

					}

				}
			%>
		</select>
		<%
			out.print("<input type='hidden' value='" + cancion.getId() + "' name='id'>");
		%>
		<br /> <br /> <input type="submit" value="Editar cancion">
	</form>
	<footer>Web creada por: Sergio Alcaraz Toral copyright:2020 |
		Contacto: akuaProyect@gmail.com</footer>

</body>
</html>