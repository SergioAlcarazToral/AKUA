<%@page import="controlador.AgregarCancionLista"%>
<%@page import="pojo.ListaReproduccion"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="pojo.Usuario"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="pojo.Album"%>
<%@ page import="pojo.CancionCompleta"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel='stylesheet' type='text/css' href='cssReproductor.css'>
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
			String inicio = "Principal";

			Usuario usuario = (Usuario) request.getAttribute("usuario");

			ArrayList<CancionCompleta> canciones = (ArrayList<CancionCompleta>) request.getAttribute("canciones");

			ListaReproduccion lista = (ListaReproduccion) request.getAttribute("lista");

			if (usuario != null) {
				out.print("<img src='Imatges/" + usuario.getFoto() + "'><br>");
				out.print("<p>" + usuario.getNombre() + "</p>");
				out.print("<a href='" + logout + "'>Logout</a> | <a href='" + baja + "'>Eliminar cuenta</a> | <a href='"
						+ inicio + "'>Inicio</a>");
			}
		%>
		<div id="controles">
			<div class="trackinfo">
				<h3 id="titulo"></h3>
				<h3 id="artista"></h3>
			</div>
			<div id="botones">
				<button id="random" class="controles">
					<img src="icons/random.png">
				</button>
				<button id="prev" class="controles">
					<img src="icons/prev.png">
				</button>
				<button id="play" class="controles">
					<img id="fotoPlay" src="icons/play.png">
				</button>
				<button id="next" class="controles">
					<img src="icons/next.png">
				</button>
				<button id="repeat" class="controles">
					<img src="icons/repeat.png">
				</button>
			</div>
			<div id="sliders">
				<input type="range" id="durCancion" min="0" value="0" /> <input
					type="range" min="0" max="100" value="50" class="slider"
					id="volumen">
				<div class="currentTime"></div>
				<div class="durationTime"></div>
			</div>
		</div>
		<canvas id="canvas"></canvas>
		<audio id="audio" src=""></audio>

		<script>
			var audio = document.getElementById("audio");
			var progressBar = document.getElementById("durCancion");
			var titulaso = document.getElementById("titulo");
			var artista = document.getElementById("artista");
			var current_track = 0;

			var cancion;

			var songs = [
		<%for (CancionCompleta c : canciones) {
				out.println("{title: \"" + c.getTitulo() + "\",artist: '" + c.getArtista() + "',url: 'ArchivosMusica/"
						+ c.getArchivo() + "',},");
			}%>
			];

			cancion = songs[current_track];
			audio.src = cancion.url;
			visualizer();

			setInterval(updateProgressValue, 200);

			document.getElementById("play").addEventListener("click",
					reproducir);
			document.getElementById("repeat").addEventListener("click",
					repetir);
			document.getElementById("next")
					.addEventListener("click", nextTrack);
			document.getElementById("prev")
					.addEventListener("click", prevTrack);
			progressBar.addEventListener("change", changeProgressBar);

			document.getElementById("volumen").addEventListener("input",
					function() {
						volumen(document.getElementById("volumen").value);
					}, false);
			document.getElementById("volumen").addEventListener("change",
					function() {
						volumen(document.getElementById("volumen").value);
					}, false);

			function reproducir() {
				audio.play();
				updateInfo();
				document.getElementById("play").removeEventListener("click",
						reproducir);
				document.getElementById("play").addEventListener("click",
						pausar);
				document.getElementById("fotoPlay").setAttribute("src",
						"icons/stop.png");
				audio.onended = function() {
					nextTrack();
				};
			}
			function updateInfo() {
				titulaso.innerHTML = cancion.title;
				artista.innerHTML = cancion.artist;
			}
			function pausar() {
				audio.pause();
				document.getElementById("play").removeEventListener("click",
						pausar);
				document.getElementById("play").addEventListener("click",
						reproducir);
				document.getElementById("fotoPlay").setAttribute("src",
						"icons/play.png");
			}
			function repetir() {
				if (audio.hasAttribute("loop")) {
					audio.loop =false;
				} else {
					audio.loop =true;
					current_track = current_track -1;
				}

			}
			function nextTrack() {
				current_track++;
				current_track = current_track % (songs.length);
				cancion = songs[current_track];
				audio.src = cancion.url;
				audio.play();
				updateInfo();
			}
			function prevTrack() {
				current_track--;
				current_track = (current_track == -1 ? (songs.length - 1)
						: current_track);
				cancion = songs[current_track];
				audio.src = cancion.url;
				audio.play();
				updateInfo();
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
			function random() {
				if (next.getAttribute("onclick") == "nextTrack()") {
					next.setAttribute("onclick", "nextTrackRandom()");
					prev.setAttribute("onclick", "prevTrackcomplete()");
				} else {
					next.setAttribute("onclick", "nextTrack()");
					prev.setAttribute("onclick", "prevTrack()");
				}
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
			function visualizer() {
				audio.load();
				audio.play();
				var context = new AudioContext();
				var src = context.createMediaElementSource(audio);
				var analyser = context.createAnalyser();

				var canvas = document.getElementById("canvas");
				canvas.width = window.innerWidth;
				canvas.height = window.innerHeight;
				var ctx = canvas.getContext("2d");

				src.connect(analyser);
				analyser.connect(context.destination);

				analyser.fftSize = 256;

				var bufferLength = analyser.frequencyBinCount;
				console.log(bufferLength);

				var dataArray = new Uint8Array(bufferLength);

				var WIDTH = canvas.width;
				var HEIGHT = canvas.height;

				//Grosor de las barras
				var barWidth = (WIDTH / bufferLength) * 1.1;
				var barHeight;
				var x = 0;

				function renderFrame() {
					requestAnimationFrame(renderFrame);

					x = 0;

					analyser.getByteFrequencyData(dataArray);

					//Color de fondo
					ctx.fillStyle = "#000";
					ctx.fillRect(0, 0, WIDTH, HEIGHT);

					for (var i = 0; i < bufferLength; i++) {

						//Aumentar la altura de las barras
						barHeight = dataArray[i] * 3;

						var r = 0;
                        var g = 255 * (i / bufferLength);
                        var b = 255 * (i / bufferLength);

						ctx.fillStyle = "rgb(" + r + "," + g + "," + b + ")";
						ctx
								.fillRect(x, HEIGHT - barHeight, barWidth,
										barHeight);

						//Distancia entre barras
						x += barWidth + 2.4;
					}
				}

				audio.play();
				renderFrame();
			};
		</script>
	</div>