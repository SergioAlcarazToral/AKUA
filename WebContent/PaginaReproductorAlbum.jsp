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
<title>Reproductor animado de album</title>
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
			String inicio = "Principal";

			Usuario usuario = (Usuario) request.getAttribute("usuario");

			Album album = (Album) request.getAttribute("album");

			ArrayList<CancionCompleta> canciones = (ArrayList<CancionCompleta>) request.getAttribute("canciones");

			if (usuario != null) {
				out.print("<img id='fotoUser' src='Imatges/" + usuario.getFoto() + "'><br>");
				out.print("<p id='userNombre'>" + usuario.getNombre() + "</p>");
				out.print("<a href='" + logout + "'>Logout</a> | <a href='" + baja + "'>Eliminar cuenta</a> | <a href='"
						+ inicio + "'>Inicio</a>");
			}
		%>
		<div id="controles">
			<div class="trackinfo">
				<h3 id="titulo"></h3>
				<h3>
					<a id="artista" href=""></a></h3>
			</div>
			<div id="botones">
				<button id="random" class="controles">
					<img id='fotoRandom' src="icons/random.png">
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
					<img id='fotoRepeat' src="icons/repeat.png">
				</button>
			</div>
			<img id="fotoAltavoz" src="icons/mute.png"> <img
				id="fotoVolumen" src="icons/50.png">
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
				out.println("{id:'PaginaArtista?id=" + c.getId() + "' ,title: \"" + c.getTitulo() + "\",artist: '"
						+ c.getArtista() + "',url: 'ArchivosMusica/" + c.getArchivo() + "',},");
			}%>
			];

			cancion = songs[current_track];
			audio.src = cancion.url;
			visualizer();

			setInterval(updateProgressValue, 200);

			document.getElementById("play").addEventListener("click",
					reproducir);
			document.getElementById("repeat")
					.addEventListener("click", repetir);
			document.getElementById("next")
					.addEventListener("click", nextTrack);
			document.getElementById("prev")
					.addEventListener("click", prevTrack);
			document.getElementById("random").addEventListener("click",random);
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
				artista.href= cancion.id;
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
			
			function prevTrackcomplete() {
				prevTrackRandom(current_track);
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
			function volumen(volume_value) {
				audio.volume = volume_value / 100;

				if (audio.volume == 0) {
					document.getElementById("fotoVolumen").src = "icons/0.png";
				} else if ( audio.volume <= 0.25 && audio.volume >0) {
					document.getElementById("fotoVolumen").src = "icons/25.png";
				} else if (audio.volume <= 0.50 && audio.volume >= 0.25) {
					document.getElementById("fotoVolumen").src = "icons/50.png";
				} else if(audio.volume <= 0.75 && audio.volume > 0.50){
					document.getElementById("fotoVolumen").src = "icons/75.png";
				}else if(audio.volume = 1){
					document.getElementById("fotoVolumen").src = "icons/100.png";
				}

			}
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
				var barWidth = (WIDTH / bufferLength) * 1;
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
						barHeight = dataArray[i] * 3.7;

						var r = barHeight + (25 *(i / bufferLength));
						var g =0;
						var b = barHeight * (i / bufferLength);
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