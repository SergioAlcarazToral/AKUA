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
</head>
<body>
	<div id="divLogo">
		<img id="Logo" src="">
	</div>
	<div id="cajaUsuario">
		<%
			Usuario usuario = (Usuario) request.getAttribute("usuario");
			ArrayList<Genero> generos = (ArrayList<Genero>) request.getAttribute("generos");
<<<<<<< HEAD
			Cancion cancion = (Cancion) request.getAttribute("cancion");
=======
<<<<<<< HEAD
			Cancion cancion = (Cancion) request.getAttribute("cancion");
=======
<<<<<<< HEAD
			Cancion cancion = (Cancion) request.getAttribute("cancion");
=======
<<<<<<< HEAD
			Cancion cancion = (Cancion) request.getAttribute("cancion");
=======
<<<<<<< HEAD
			Cancion cancion = (Cancion) request.getAttribute("cancion");
=======
			Cancion idGenero = (Cancion) request.getAttribute("genero");
>>>>>>> master
>>>>>>> master
>>>>>>> master
>>>>>>> master
>>>>>>> master
			if (usuario != null) {
				String logout = "Logout";

				out.print("<img src='Imatges/" + usuario.getFoto() + "'><br>");
				out.print("<p>" + usuario.getNombre() + "</p>");
				out.print("<a href='" + logout + "'>Logout</a>");

			}
		%>
	</div>
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> master
>>>>>>> master
>>>>>>> master
>>>>>>> master
	<form action="EditarCancion" method="post">
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
		<input type="submit" value="Editar cancion">
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
	<form action"EditarCancion" method="post">
		<p>Titulo de la cancion</p>
		<input type="text" name="titulo" required>
		<p>Genero</p>
		<select nam="genero">
			<%
				for(Genero g : generos){
					if(idGenero.getId() == g.getId()){
						out.print("<option value='" + g.getId() + "' selected>" + g.getNombre() + "</option>");
					}else{
						out.print("<option value='" + g.getId() + "'>" + g.getNombre() + "</option>");

					}
						
				}
			%>
		</select>
>>>>>>> master
>>>>>>> master
>>>>>>> master
>>>>>>> master
>>>>>>> master
	</form>
</body>
</html>