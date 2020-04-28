<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="pojo.Usuario"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="pojo.Cancion"%>
<%@ page import="pojo.ListaReproduccion"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="divLogo">
		<img id="Logo" src="">
	</div>
	<div id="cajaUsuario">
		<%
			String login = "Login";
			String registrar = "Registrar";
			String logout = "Logout";
			String baja = "DarDeBaja";
			String inicio = "Principal";
			String agregarCancionLista = "AgregarCancionLista";
			String eliminarCancion = "BorrarCancionLista";
			String borrarLista = "BorrarLista";
			Usuario usuario = (Usuario) request.getAttribute("usuario");

			ArrayList<Cancion> canciones = (ArrayList<Cancion>) request.getAttribute("canciones");

			ListaReproduccion lista = (ListaReproduccion) request.getAttribute("lista");

			if (usuario != null) {
				if (usuario.getAdministrador() != 1) {
					out.print("<img src='Imatges/" + usuario.getFoto() + "'><br>");
					out.print("<p>" + usuario.getNombre() + "</p>");
					out.print("<a href='" + logout + "'>Logout</a> | <a href='" + borrarLista + "?id=" + usuario.getId()
							+ "&nombre=" + lista.getNombre() + "'>Borrar lista</a> | <a href='" + inicio
							+ "'>Inicio</a>");
				} else {
					out.print("<img src='Imatges/" + usuario.getFoto() + "'><br>");
					out.print("<p>" + usuario.getNombre() + "</p>");
					out.print("<a href='" + logout + "'>Logout</a> | <a href='" + borrarLista + "?id=" + usuario.getId()
					+ "&nombre=" + lista.getNombre() + "'>Borrar lista</a> | <a href='" + baja
							+ "'>Eliminar cuenta</a> | <a href='" + inicio + "'>Inicio</a>");
				}
			} else {
				out.println("<img src='Imatges/sinImagen.jsp'><br>");
				out.print("<a href='" + login + "'>Login</a>");
				out.print("| <a href='" + registrar + "'>Registrar</a> | <a href='" + inicio + "'>Inicio</a>");
			}
		%>
	</div>
	<%
		out.println("<h2>" + lista.getNombre() + "</h2>");
		for (Cancion c : canciones) {
			out.println("<p>" + c.getTitulo() + " | <a href='" + eliminarCancion + "?idCancion=" + c.getId()
					+ "&nombre=" + lista.getNombre() + "&idUsuario=" + usuario.getId()
					+ "'>Eliminar Cancion</a></p>");
		}
	%>
</body>
</html>