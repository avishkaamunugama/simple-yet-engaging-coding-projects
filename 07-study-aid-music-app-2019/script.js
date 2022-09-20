const app = () => {
    const song = document.querySelector(".song");
    const play = document.querySelector(".play");
    const outline = document.querySelector(".moving-outline circle");
    const video = document.querySelector(".vid-container video");

    //sounds
    const sounds = document.querySelectorAll(".sound-picker button");
    //time dispaly
    const timeDisplay = document.querySelector(".time-display");
    const timeSelect = document.querySelectorAll(".time-select button");
    //get the length of the outline
    const outlineLength = outline.getTotalLength();
    console.log(outlineLength);
    //default duration
    let fakeDuration = 900;

    outline.style.strokeDasharray = outlineLength;
    outline.style.strokeDashoffset = outlineLength;

    //change sounds and video
    sounds.forEach(sound => {
        sound.addEventListener('click', function () {
            song.src = this.getAttribute('data-sound');
            video.src = this.getAttribute('data-video');
            checkPlaying(song);
        });
    });

    //play sound
    play.addEventListener("click", () => {
        checkPlaying(song);
    });


    //select sound duration
    timeSelect.forEach(option => {
        option.addEventListener("click", function () {
            fakeDuration = this.getAttribute("data-time");
            if (!isNaN(fakeDuration)) {
                timeDisplay.textContent = `${Math.floor(fakeDuration / 60)}:${Math.floor(fakeDuration % 60)}`;
                console.log(fakeDuration);

            } else {

                timeDisplay.textContent = `0:00`;
                console.log(fakeDuration);
            }
        });

    });

    //function to stop and play music
    const checkPlaying = song => {
        if (song.paused) {
            song.play();
            video.play();
            play.src = "./svg/pause.svg";
        } else {
            song.pause();
            video.pause();
            play.src = "./svg/play.svg"
        }
    };

    //animate the circle
    song.ontimeupdate = () => {
        let currentTime = song.currentTime;

        if (!isNaN(fakeDuration)) {
            let elapsed = fakeDuration - currentTime;
            let seconds = Math.floor(elapsed % 60);
            let minutes = Math.floor(elapsed / 60);


            //circle animation
            let progress = outlineLength - (currentTime / fakeDuration) * outlineLength;
            outline.style.strokeDashoffset = progress;

            //time animation

            timeDisplay.textContent = `${minutes}:${seconds}`;

            //pause song and video hwen timergoes to zero
            if (currentTime >= fakeDuration) {
                song.pause();
                song.currentTime = 0;
                play.src = "./svg/play.svg";
                video.pause();
            }


        } else {
            let seconds = Math.floor(currentTime % 60);
            let minutes = Math.floor(currentTime / 60);

            timeDisplay.textContent = `${minutes}:${seconds}`;

            outline.style.strokeDasharray = outlineLength;
            outline.style.strokeDashoffset = outlineLength;

        }

    };


    //view page fullscreen and exit full screen
    function toggleFullscreen(elem) {
        elem = elem || document.documentElement;
        if (!document.fullscreenElement && !document.mozFullScreenElement &&
            !document.webkitFullscreenElement && !document.msFullscreenElement) {
            if (elem.requestFullscreen) {
                elem.requestFullscreen();
            } else if (elem.msRequestFullscreen) {
                elem.msRequestFullscreen();
            } else if (elem.mozRequestFullScreen) {
                elem.mozRequestFullScreen();
            } else if (elem.webkitRequestFullscreen) {
                elem.webkitRequestFullscreen(Element.ALLOW_KEYBOARD_INPUT);
            }

            document.getElementById("fullscreen").textContent = "Quit Fullscreen";
        } else {
            if (document.exitFullscreen) {
                document.exitFullscreen();
            } else if (document.msExitFullscreen) {
                document.msExitFullscreen();
            } else if (document.mozCancelFullScreen) {
                document.mozCancelFullScreen();
            } else if (document.webkitExitFullscreen) {
                document.webkitExitFullscreen();
            }

            document.getElementById("fullscreen").textContent = "View Fullscreen";
            document.getElementById("video").style.objectFit = "cover";
        }

        document.body.style.backgroundColor = "black";


    }

    document.getElementById('fullscreen').addEventListener('click', function () {
        toggleFullscreen();
    });

};

app();