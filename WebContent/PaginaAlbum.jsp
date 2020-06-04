<%@page import="controlador.AgregarCancionLista"%>
<%@page import="pojo.ListaReproduccion"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="pojo.Usuario"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="pojo.Album"%>
<%@ page import="pojo.CancionCompleta"%>
<%@ page import="pojo.ListaReproduccion"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel='stylesheet' type='text/css' href='css.css'>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Pagina de album</title>
</head>
<body>
	<div id="divLogo">
		<a href="Principal"><img id="Logo" src="icons/akua negro.png"></a>
	</div>
	<div id="cajaUsuario">
		<%
			String login = "Login";
			String registrar = "Registrar";
			String logout = "Logout";
			String baja = "DarDeBaja";
			String paginaArtistaEnlace = "PaginaArtista";
			String crearCancion = "CrearCancion";
			String inicio = "Principal";
			String crearLista="CrearLista";
			String editarAlbum = "EditarAlbum";
			String editarCancion = "EditarCancion";
			String eliminarArtista = "EliminarArtista";
			String eliminarAlbum = "EliminarAlbum";
			String eliminarCancion = "EliminarCancion";
			String agregarCancionLista = "AgregarCancionLista";

			Usuario usuario = (Usuario) request.getAttribute("usuario");

			Album album = (Album) request.getAttribute("album");

			ArrayList<CancionCompleta> canciones = (ArrayList<CancionCompleta>) request.getAttribute("canciones");

			ArrayList<ListaReproduccion> listas = (ArrayList<ListaReproduccion>) request.getAttribute("listas");

			if (usuario != null) {
				if (usuario.getAdministrador() != 1) {
					out.print("<img id='fotoUser' src='Imatges/" + usuario.getFoto() + "'><br>");
					out.print("<p>" + usuario.getNombre() + "</p>");
					out.print("<a href='" + logout + "'>Logout</a>");
				} else {
					out.print("<img id='fotoUser' src='Imatges/" + usuario.getFoto() + "'><br>");
					out.print("<p>" + usuario.getNombre() + "</p>");
					out.print("<a href='" + logout + "'>Logout</a> | <a href='" + baja + "'>Eliminar cuenta</a>");
				}
			} else {
				out.println("<img id='fotoUser' src='Imatges/sinImagen.jpg'><br>");
				out.print("<a href='" + login + "'>Login</a>");
				out.print(" | <a href='" + registrar + "'>Registrar</a>");
			}
		%>
	</div>
	<%
		if (usuario != null) {
			out.print("<div id='lRepro'><h2 id='h2Intro'>Listas</h2>");
			out.print("<p><a href='" + crearLista + "'>Crear lista</a></p>");
			out.print("<p><a href='ReprductorAnimadoAlbum?id=" + album.getId() + "'>Reproductor animado</a></p>");
			out.print("<hr>");
			for (ListaReproduccion lista : listas) {
				out.print("<p><a href='PaginaLista?idUsuario=" + usuario.getId() + "&nombre=" + lista.getNombre()
						+ "'>" + lista.getNombre() + "</a></p>");
			}
			out.print("</div>");
		}
	%>
	<%
		out.println("<h2 id='h2Intro'>" + album.getNombre() + "</h2>");
		out.println("<h3>" + album.getAnyo() + "</h3>");
		if (usuario != null) {
			if (usuario.getAdministrador() != 1) {
				out.print(
						"<h3><a href='" + crearCancion + "?id=" + album.getId() + "'>Crear cancion</a> | <a href='"
								+ editarAlbum + "?id=" + +album.getId() + "'>Editar album</a> | <a href='"
								+ eliminarAlbum + "?id=" + album.getId() + "'>Eliminar album</a></h3>");
			}
		}

		out.print("<div class='container'><table class='table table-hover'>");
		out.print("<thead>");
		if (usuario != null) {
			out.print("<tr><th>Titulo</th><th>Artista</th><th>Listas</th></tr>");
		} else {
			out.print("<tr><th>Titulo</th><th>Artista</th></tr></thead>");

		}
		out.print("</thead>");
		for (CancionCompleta c : canciones) {
			if (usuario != null) {
				if (usuario.getAdministrador() != 1) {
					out.println("<tr><td>" + c.getTitulo() + "</td><td>" + c.getArtista() + "</td>");
					out.print("<td><div class='btn-group'>"
							+ "<button class='btn btn-primary dropdown-toggle' type='button' data-toggle='dropdown'>Añadir a lista"
							+ "<span class='caret'></span><span class='sr-only'>Toggle Dropdown</span></button>"
							+ "<ul class='dropdown-menu' role='menu'>");
					for (ListaReproduccion l : listas) {
						out.print("<li><a href='" + agregarCancionLista + "?nombre=" + l.getNombre() + "&idUsuario="
								+ usuario.getId() + "&idCancion=" + c.getId() + "'>" + l.getNombre() + "</a></li>");
					}
					out.print("<td><a href='" + eliminarCancion + "?id="
							+ c.getId() + "'>Eliminar Cancion</a></td><td><a href='" + editarCancion + "?id="
							+ c.getId() + "'>Editar Cancion</a></td>");
					out.print("</ul></div></td><br>");

				} else {
					out.print("<tr><td>" + c.getTitulo() + "</td><td>" + c.getArtista() + "</td>");
					out.print("<td><div class='btn-group'>"
							+ "<button class='btn btn-primary dropdown-toggle' type='button' data-toggle='dropdown'>Añadir a lista"
							+ "<span class='caret'></span><span class='sr-only'>Toggle Dropdown</span></button>"
							+ "<ul class='dropdown-menu' role='menu'>");
					for (ListaReproduccion l : listas) {
						out.print("<li><a href='" + agregarCancionLista + "?nombre=" + l.getNombre() + "&idCancion="
								+ c.getId() + "'>" + l.getNombre() + "</a></li>");
					}
					out.print("</ul></div></td><br>");

				}
			} else {
				out.print("<tr><td>" + c.getTitulo() + "</td><td>" + c.getArtista() + "</td></tr>");
			}
		}
		out.print("<table>");
		out.print("</div>");
	%>
	<div id="controles">
		<div class="trackinfo">
			<p id="titulo"></p>
			<p>
				<a id="artista" href="PaginaArtista"></a>
			</p>
		</div>
		<div id="botones">
			<button id="random" class="controles" onclick="random()">
				<img id='fotoRandom' src="icons/random.png">
			</button>
			<button id="prev" class="controles" onclick="prevTrack()">
				<img src="icons/prev.png">
			</button>
			<button id="play" class="controles" onclick="reproducir()">
				<img id="fotoPlay" src="icons/play.png">
			</button>
			<button id="next" class="controles" onclick="nextTrack()">
				<img src="icons/next.png">
			</button>
			<button id="repeat" class="controles" onclick="repetir()">
				<img id='fotoRepeat' src="icons/repeat.png">
			</button>
		</div>
		<div id="sliders">
			<input type="range" id="durCancion" min="0" value="0"
				onchange="changeProgressBar()" /> <input type="range" min="0"
				max="100" value="50" class="slider" onchange="volumen(this.value)"
				onInput="volumen(this.value)" id="volumen">
			<div class="currentTime"></div>
			<div class="durationTime"></div>
		</div>
	</div>
	<script>
		var play = document.getElementById("play");
		var next = document.getElementById("next");
		var prev = document.getElementById("prev");
		var titulaso = document.getElementById("titulo");
		var artista = document.getElementById("artista");
		var progressBar = document.getElementById("durCancion");

		var current_track = 0;

		var cancion, audio, duracion;
		var playing = false;

		var songs = [
	<%for (CancionCompleta c : canciones) {
				out.println("{id: '" + paginaArtistaEnlace + "?id=" + c.getId() + "',title: \"" + c.getTitulo()
						+ "\",artist: '" + c.getArtista() + "',url: 'ArchivosMusica/" + c.getArchivo() + "',},");
			}%>
		];

		window.addEventListener('load', init(), false);

		setInterval(updateProgressValue, 500);

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
		function nextTrackRandom() {
			current_track = Math.floor(Math.random() * songs.length);
			cancion = songs[current_track];
			audio.src = cancion.url;
			reproducir();
			audio.onloadeddata = function() {
				updateInfo();
			}
		}
		function prevTrackRandom(current_track) {
			cancion = songs[current_track];
			audio.src = cancion.url;
			reproducir();
			audio.onloadeddata = function() {
				updateInfo();
			}
		}
		function prevTrackcomplete() {
			prevTrackRandom(current_track);
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
			if (next.getAttribute("onclick") == "nextTrack()") {
				next.setAttribute("onclick", "nextTrackRandom()");
				prev.setAttribute("onclick", "prevTrackcomplete()");
				document.getElementById("fotoRandom").setAttribute("src",
						"icons/randomActive.png");
			} else {
				next.setAttribute("onclick", "nextTrack()");
				prev.setAttribute("onclick", "prevTrack()");
				document.getElementById("fotoRandom").setAttribute("src",
						"icons/random.png");
			}
		}
		function repetir() {
			if (audio.hasAttribute("loop")) {
				audio.loop = false;
				document.getElementById("fotoRepeat").setAttribute("src",
						"icons/repeat.png");
			} else {
				audio.loop = true;
				document.getElementById("fotoRepeat").setAttribute("src",
						"icons/repeatActive.png");
				current_track = current_track - 1;
			}

		}
		function reproducir() {
			audio.play();
			updateInfo();
			document.getElementById("play").removeEventListener("click",
					reproducir);
			document.getElementById("play").addEventListener("click", pausar);
			document.getElementById("fotoPlay").setAttribute("src",
					"icons/stop.png");
			audio.onended = function() {
				nextTrack();
			};
		}
		function pausar() {
			audio.pause();
			document.getElementById("play")
					.removeEventListener("click", pausar);
			document.getElementById("play").addEventListener("click",
					reproducir);
			document.getElementById("fotoPlay").setAttribute("src",
					"icons/play.png");
		}
		function updateInfo() {
			artista.href = cancion.id;
			titulaso.innerHTML = cancion.title;
			artista.innerHTML = cancion.artist;
		}
		function volumen(volume_value) {
			audio.volume = volume_value / 100;
		};
		function updateProgressValue() {
			var minutes = parseInt(audio.duration / 60, 10);
			var seconds = parseInt(audio.duration % 60);

			var realMinutes = parseInt(audio.currentTime / 60, 10);
			var realSeconds = parseInt(audio.currentTime % 60);

			progressBar.max = audio.duration;
			progressBar.value = audio.currentTime;
			if(realSeconds < 10){
				document.querySelector('.currentTime').innerHTML = realMinutes + ":0" + realSeconds;
			}else{
				document.querySelector('.currentTime').innerHTML = realMinutes + ":" + realSeconds;
			}
			document.querySelector('.durationTime').innerHTML = minutes + ":"
					+ seconds;
			formatTime(audio.duration);
		};
		function changeProgressBar() {
			audio.currentTime = progressBar.value;
		};
	</script>
</body>
</html>