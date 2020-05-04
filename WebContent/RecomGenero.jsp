<%@page import="controlador.AgregarCancionLista"%>
<%@page import="pojo.ListaReproduccion"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="pojo.Usuario"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="pojo.Album"%>
<%@ page import="pojo.Cancion"%>
<%@ page import="pojo.CancionCompleta"%>
<%@ page import="pojo.Genero"%>
<%@ page import="pojo.ListaReproduccion"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Canciones recomendadas por genero</title>
<script type="text/javascript">
	$('div.canvasContainer > canvas').css('-moz-transform',
			'scale(1) translate(0px, 0px)').css('-webkit-transform',
			'scale(1) translate(0px, 0px)').css('-o-transform',
			'scale(1) translate(0px, 0px)').css('transform',
			'scale(1) translate(0px, 0px)');
</script>
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
			Usuario usuario = (Usuario) request.getAttribute("usuario");

			ArrayList<CancionCompleta> canciones = (ArrayList<CancionCompleta>) request.getAttribute("canciones");

			Genero genero = (Genero) request.getAttribute("genero");

			ArrayList<ListaReproduccion> listas = (ArrayList<ListaReproduccion>) request.getAttribute("listas");

			if (usuario != null) {
				if (usuario.getAdministrador() != 1) {
					out.print("<img src='Imatges/" + usuario.getFoto() + "'><br>");
					out.print("<p>" + usuario.getNombre() + "</p>");
					out.print("<a href='" + logout + "'>Logout</a> | <a href='" + inicio + "'>Inicio</a>");
				} else {
					out.print("<img src='Imatges/" + usuario.getFoto() + "'><br>");
					out.print("<p>" + usuario.getNombre() + "</p>");
					out.print("<a href='" + logout + "'>Logout</a> | <a href='" + baja
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
		out.println("<h2>" + genero.getNombre() + "</h2>");

		for (CancionCompleta c : canciones) {
			if (usuario != null) {
				out.println("<p>" + c.getTitulo() + "</p>");
				out.print("<div class='dropdown'>"
						+ "<button class='btn btn-primary dropdown-toggle' type='button' data-toggle='dropdown'>Añadir a lista"
						+ "<span class='caret'></span></button>" + "<ul class='dropdown-menu'>");
				for (ListaReproduccion l : listas) {
					out.print("<li><a href='" + agregarCancionLista + "?nombre=" + l.getNombre() + "&idUsuario="
							+ usuario.getId() + "&idCancion=" + c.getId() + "'>" + l.getNombre() + "</a></li>");
				}
				out.print("</ul></div>");

			} else {
				out.println("<p>" + c.getTitulo() + "</p>");
				//out.print("</ul></div>");
			}

		}
	%>
	<div class="trackinfo">
		<p id="titulo"></p>
		<p id="artista"></p>
	</div>
	<div id="controles">
		<button id="prev" class="controles" onclick="prevTrack()">
			<img src="icons/prev.png">
		</button>
		<button id="play" class="controles" onclick="reproducir()">
			<img src="icons/play.png">
		</button>
		<button id="next" class="controles" onclick="nextTrack()">
			<img src="icons/next.png">
		</button>
		<button id="stop" class="controles" onclick="pausar()">
			<img src="icons/stop.png">
		</button>
		<button id="random" class="controles" onclick="random()">
			<img src="icons/random.png">
		</button>
		<input type="range" min="0" max="100" value="50" class="slider"
			onchange="volumen(this.value)" onInput="volumen(this.value)"
			id="volumen">
		<div id="vol"></div>
	</div>
	<script>
		var play = document.getElementById("play");
		var next = document.getElementById("next");
		var prev = document.getElementById("prev");
		var titulaso = document.getElementById("titulo");
		var artista = document.getElementById("artista");
		var current_track = 0;

		var cancion, audio, duracion;
		var playing = false;

		var songs = [
	<%for (CancionCompleta c : canciones) {
				out.println("{title: \"" + c.getTitulo() + "\",artist: '" + c.getArtista() + "',url: 'ArchivosMusica/"
						+ c.getArchivo() + "',},");
			}%>
		];
		window.addEventListener('load', init(), false);

		function init() {
			cancion = songs[current_track];
			audio = new Audio();
			audio.src = cancion.url;
		}
		function nextTrack() {
			current_track++;
			current_track = current_track % (songs.length);
			cancion = songs[current_track];
			audio.src = cancion.url;
			reproducir();
			audio.onloadeddata = function() {
				updateInfo();
			}
		}
		function prevTrack() {
			current_track--;
			current_track = (current_track == -1 ? (songs.length - 1)
					: current_track);
			cancion = songs[current_track];
			audio.src = cancion.url;
			reproducir();
			audio.onloadeddata = function() {
				updateInfo();
			}
		}
		function random() {
			current_track = Math.floor(Math.random() * songs.length);
			cancion = songs[current_track];
			audio.src = cancion.url;
			reproducir();
			audio.onloadeddata = function() {
				updateInfo();
			}
		}
		function reproducir() {
			audio.play();
			titulaso.innerHTML = cancion.title;
			artista.innerHTML = cancion.artist;
		}
		function pausar() {
			audio.pause();
		}
		function updateInfo() {
			titulaso.innerHTML = cancion.title;
			artista.innerHTML = cancion.artist;
		}
		function volumen(volume_value) {
			document.getElementById("vol").innerHTML = volume_value;
			audio.volume = volume_value / 100;

		}
	</script>
</body>
</html>