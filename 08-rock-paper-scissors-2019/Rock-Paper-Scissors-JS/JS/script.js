function game() {
    let pScore = 0;
    let cScore = 0;

    //transition from intro to game on click
    function startGame() {
        var playBtn = document.querySelector('.intro button');
        var introScreen = document.querySelector('.intro');
        var match = document.querySelector('.match');

        playBtn.addEventListener("click", function() {
            introScreen.classList.add('fadeOut');
            match.classList.add('fadeIn');
        });
    };


    //assign computer and user choice....... 

    var options = document.querySelectorAll(".options button");
    var computerOptions = ["rock", "paper", "scissors"];
    var comHandImg = document.querySelector(".computer-hnd");
    var plaHandImg = document.querySelector(".player-hnd");


    //enables consecutive animations
    var hands = document.querySelectorAll(".hands img");

    hands.forEach(hand => {
        hand.addEventListener("animationend", function() {
            this.style.animation = "";
        });
    });


    // ........
    options.forEach(option => {
        option.addEventListener("click", function() {

            var winnerText = document.querySelector(".winner");

            options.forEach(option => {
                option.addEventListener("mouseover", function() {
                    //rollback the hand and title to initial state

                    winnerText.innerHTML = "Choose an option";

                    comHandImg.src = `./Images/rock.png`;
                    plaHandImg.src = `./Images/rock.png`;

                });
            });

            var computerChoice = computerOptions[Math.floor(Math.random() * 3)];
            console.log(computerChoice);

            var userChoice = option.className;

            //change hand images after the animation


            setTimeout(() => {
                comHandImg.src = `./Images/${computerChoice}.png`;
                plaHandImg.src = `./Images/${userChoice}.png`;
                announceWinner();
            }, 2000);

            //chooce the winner and update score
            function announceWinner() {


                var playerScore = document.querySelector(".player-score p");
                var computerScore = document.querySelector(".computer-score p");


                if (userChoice === computerChoice) {
                    winnerText.innerHTML = "That's a tie.";


                } else if (userChoice === "rock") {
                    if (computerChoice === "scissors") {
                        winnerText.innerHTML = "Player wins";
                        playerScore.innerHTML = parseInt(playerScore.textContent) + 1;
                    } else {
                        winnerText.innerHTML = "Computer wins";
                        computerScore.innerHTML = parseInt(computerScore.textContent) + 1;
                    }
                } else if (userChoice === "paper") {
                    if (computerChoice === "rock") {
                        winnerText.innerHTML = "Player wins";
                        playerScore.innerHTML = parseInt(playerScore.textContent) + 1
                    } else {
                        winnerText.innerHTML = "Computer wins";
                        computerScore.innerHTML = parseInt(computerScore.textContent) + 1;

                    }
                } else if (userChoice === "scissors") {
                    if (computerChoice === "paper") {
                        winnerText.innerHTML = "Player wins";
                        playerScore.innerHTML = parseInt(playerScore.textContent) + 1
                    } else {
                        winnerText.innerHTML = "Computer wins";
                        computerScore.innerHTML = parseInt(computerScore.textContent) + 1;

                    }
                }
            };

            //hand animation
            comHandImg.style.animation = "shakeComputer 2s ease";
            plaHandImg.style.animation = "shakePlayer 2s ease";
        })

    })


    startGame();

}

game();