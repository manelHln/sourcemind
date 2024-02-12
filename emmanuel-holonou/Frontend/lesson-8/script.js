const inputField = document.querySelector(".guess")
const scoreField = document.querySelector(".score")
const highscoreField = document.querySelector(".highscore")
const messageField = document.querySelector(".message")
const randomNumber = Math.floor(Math.random() * 20) + 1

var highscore = 0
const reset = () => {
    inputField.value = ""
    scoreField.textContent = 20
    document.body.style.backgroundColor = "#222"
    messageField.textContent = "Start guessing..."
}

const check = () => {
    let userInput = inputField.value
    if(Number(userInput) === randomNumber){
        if(highscore < Number(scoreField.textContent)){
            highscore = scoreField.textContent
            messageField.textContent = "You won"
        }
        document.body.style.backgroundColor = "#60b347"
        highscoreField.textContent = highscore
    }else if(userInput < randomNumber){
        messageField.textContent = "Too low"
        scoreField.textContent -= 1
    }else{
        messageField.textContent = "Too hight"
        scoreField.textContent -= 1
    }
}
