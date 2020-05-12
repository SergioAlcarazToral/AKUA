window.onload = function () {

    var audio = document.getElementById("audio");
    var progressBar = document.getElementById("durCancion");
    var titulaso = document.getElementById("titulo");
    var artista = document.getElementById("artista");
    var current_track = 0;

    var cancion;

    var songs = [
        {
            title: 'I cant breathe',
            artist: 'Dead by april',
            url: 'canciones/DBA i cant breathe',
        },
        {
            title: 'WHAT!',
            artist: 'Jon Tron',
            url: 'canciones/WHAT.mp3',
        },
        {
            title: 'Silver bullet',
            artist: 'Devil My Cry V',
            url: 'canciones/DMC5 silver bullet',
        },
        {
            title: 'Toss a coin to your witcher',
            artist: 'Skay',
            url: 'canciones/The Witcher - Toss a Coin To Your Witcher (Epic Metal Cover by Skar Productions).mp3',
        }];

    cancion = songs[current_track];
    audio.src = cancion.url;
    visualizer();

    setInterval(updateProgressValue, 200);

    document.getElementById("play").addEventListener("click", reproducir);
    document.getElementById("next").addEventListener("click", nextTrack);
    document.getElementById("prev").addEventListener("click", prevTrack);
    progressBar.addEventListener("change", changeProgressBar);
    
    document.getElementById("volumen").addEventListener("input", function () {
        volumen(document.getElementById("volumen").value);
    }, false);
    document.getElementById("volumen").addEventListener("change", function () {
        volumen(document.getElementById("volumen").value);
    }, false);

    function reproducir() {
        audio.play();
        updateInfo();
        document.getElementById("play").removeEventListener("click", reproducir);
        document.getElementById("play").addEventListener("click", pausar);
        document.getElementById("fotoPlay").setAttribute("src", "icons/stop.png");
        audio.onended = function () {
            nextTrack();
        };
    }
    function updateInfo() {
        titulaso.innerHTML = cancion.title;
        artista.innerHTML = cancion.artist;
    }
    function pausar() {
        audio.pause();
        document.getElementById("play").removeEventListener("click", pausar);
        document.getElementById("play").addEventListener("click", reproducir);
        document.getElementById("fotoPlay").setAttribute("src", "icons/play.png");
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
        current_track = (current_track == -1 ? (songs.length - 1) : current_track);
        cancion = songs[current_track];
        audio.src = cancion.url;
        audio.play();
        updateInfo();
    }
    function volumen(volume_value) {
        audio.volume = volume_value / 100;

    }
    function updateProgressValue() {
        progressBar.max = audio.duration;
        progressBar.value = audio.currentTime;
        document.querySelector('.currentTime').innerHTML = formatTime(audio.currentTime);
        formatTime(audio.duration);
    }
    ;

    function changeProgressBar() {
        audio.currentTime = progressBar.value;
    }
    ;
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

                var r = barHeight + (25 * (i / bufferLength));
                var g = 250 * (i / bufferLength);
                var b = 50;

                ctx.fillStyle = "rgb(" + r + "," + g + "," + b + ")";
                ctx.fillRect(x, HEIGHT - barHeight, barWidth, barHeight);

                //Distancia entre barras
                x += barWidth + 2.4;
            }
        }

        audio.play();
        renderFrame();
    }
    ;

};
