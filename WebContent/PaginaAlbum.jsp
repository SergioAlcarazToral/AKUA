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
			String crearCancion = "CrearCancion";
			String inicio = "Principal";
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
					out.print("<img src='Imatges/" + usuario.getFoto() + "'><br>");
					out.print("<p>" + usuario.getNombre() + "</p>");
					out.print("<a href='" + logout + "'>Logout</a> | <a href='" + crearCancion + "?id=" + album.getId()
							+ "'>Crear cancion</a> | <a href='" + editarAlbum + "?id=" + +album.getId()
							+ "'>Editar album</a> | <a href='" + eliminarAlbum + "?id=" + album.getId()
							+ "'><Eliminar album</a> | <a href='" + inicio + "'>Inicio</a>");
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
		out.println("<h2>" + album.getNombre() + "</h2>");
		out.println(album.getAnyo());

		for (CancionCompleta c : canciones) {
			if (usuario != null) {
				if (usuario.getAdministrador() != 1) {
					out.println("<p>" + c.getTitulo() + " | <a href='" + eliminarCancion + "?id=" + c.getId()
							+ "'>Eliminar Cancion</a> | <a href='" + editarCancion + "?id=" + c.getId()
							+ "'>Editar Cancion</a></p>");
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
					out.print("<div class='dropdown'>"
							+ "<button class='btn btn-primary dropdown-toggle' type='button' data-toggle='dropdown'>Añadir a lista"
							+ "<span class='caret'></span></button>" + "<ul class='dropdown-menu'>");
					for (ListaReproduccion l : listas) {
						out.print("<li><a href='" + agregarCancionLista + "?nombre=" + l.getNombre() + "&idUsuario="
								+ usuario.getId() + "&idCancion=" + c.getId() + "'>" + l.getNombre() + "</a></li>");
					}
					out.print("</ul></div>");
				}
			} else {
				out.println("<p>" + c.getTitulo() + "</p>");
			}
		}
	%>
	<div id="controles">
		<div class="trackinfo">
			<p id="titulo"></p>
			<p id="artista"></p>
		</div>
		<div id="botones">
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
				out.println("{title: \"" + c.getTitulo() + "\",artista: '" + c.getGenero() + "',url: 'ArchivosMusica/"
						+ c.getArchivo() + "',},");
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
			} else {
				next.setAttribute("onclick", "nextTrack()");
				prev.setAttribute("onclick", "prevTrack()");

			}
		}
		function reproducir() {
			audio.play();
			titulaso.innerHTML = cancion.title;
			artista.innerHTML = cancion.artist;
			audio.onended = function() {
				nextTrack();
			};
		}
		function pausar() {
			audio.pause();
		}

		function updateInfo() {
			titulaso.innerHTML = cancion.title;
			artista.innerHTML = cancion.genero;
		}
		function volumen(volume_value) {
			audio.volume = volume_value / 100;

		}
		function updateProgressValue() {
			progressBar.max = audio.duration;
			progressBar.value = audio.currentTime;
			document.querySelector('.currentTime').innerHTML = formatTime(audio.currentTime);
			formatTime(audio.duration);
		};

		function changeProgressBar() {
			audio.currentTime = progressBar.value;
		};
	</script>
</body>
</html>