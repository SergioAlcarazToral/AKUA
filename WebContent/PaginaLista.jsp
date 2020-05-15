<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="pojo.Usuario"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="pojo.CancionCompleta"%>
<%@ page import="pojo.ListaReproduccion"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pagina lista</title>
<link rel='stylesheet' type='text/css' href='css.css'>
</head>
<body>
	<%
		ListaReproduccion lista = (ListaReproduccion) request.getAttribute("lista");
	%>
	<div id="divLogo">
		<img id="Logo" src="icons/akua negro.png">
			<h1 id="akua"><%out.print(lista.getNombre());%></h1>
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

			ArrayList<CancionCompleta> canciones = (ArrayList<CancionCompleta>) request.getAttribute("canciones");

			if (usuario != null) {
				if (usuario.getAdministrador() != 1) {
					out.print("<img id='fotoUser' src='Imatges/" + usuario.getFoto() + "'><br>");
					out.print("<p>" + usuario.getNombre() + "</p>");
					out.print("<a href='" + logout + "'>Logout</a> | <a href='" + borrarLista + "?id=" + usuario.getId()
							+ "&nombre=" + lista.getNombre() + "'>Borrar lista</a> | <a href='" + inicio
							+ "'>Inicio</a> | <a href='ReproductorAnimadoLista?nombre=" + lista.getNombre()
							+ "'>Reproductor animado</a>");
				} else {
					out.print("<img id='fotoUser' src='Imatges/" + usuario.getFoto() + "'><br>");
					out.print("<p>" + usuario.getNombre() + "</p>");
					out.print("<a href='" + logout + "'>Logout</a> | <a href='" + borrarLista + "?id=" + usuario.getId()
							+ "&nombre=" + lista.getNombre() + "'>Borrar lista</a> | <a href='" + baja
							+ "'>Eliminar cuenta</a> | <a href='" + inicio
							+ "'>Inicio</a> | <a href='ReproductorAnimadoLista?nombre=" + lista.getNombre()
							+ "'>Reproductor animado</a>");
				}
			} else {
				out.println("<img id='fotoUser' src='Imatges/sinImagen.jsp'><br>");
				out.print("<a href='" + login + "'>Login</a>");
				out.print("| <a href='" + registrar + "'>Registrar</a> | <a href='" + inicio + "'>Inicio</a>");
			}
		%>
	</div>
	<%
		out.println("<h2>" + lista.getNombre() + "</h2>");
		for (CancionCompleta c : canciones) {
			out.println("<p>" + c.getTitulo() + " | <a href='" + eliminarCancion + "?idCancion=" + c.getId()
					+ "&nombre=" + lista.getNombre() + "&idUsuario=" + usuario.getId()
					+ "'>Eliminar Cancion</a></p>");
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
				out.println("{title: \"" + c.getTitulo() + "\",artista: '" + c.getArtista() + "',url: 'ArchivosMusica/"
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
			updateInfo();
			audio.onended = function() {
				nextTrack();
			};
		}
		function pausar() {
			audio.pause();
		}
		function updateInfo() {
			titulaso.innerHTML = cancion.title;
			artista.innerHTML = cancion.artista;
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