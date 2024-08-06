package headfirst.chapter3

fun main() {
    val options = arrayOf("Rock", "Paper", "Scissors")
    printResult(getUserChoice(options), getGameChoice(options))
}

fun getGameChoice(options: Array<String>) =
    options[(Math.random() * options.size).toInt()]

fun getUserChoice(options: Array<String>): String {
    var isValidChoice = false
    var userChoice = ""

    while (!isValidChoice) {
        print("Please enter one of the following:")
        for (item in options) print(" $item")
        println(".")

        val userInput = readLine() // читает строку данных из стандартного входного потока

        if (userInput != null && userInput in options) {
            isValidChoice = true
            userChoice = userInput
        }

        if (!isValidChoice) println("You must enter a valid choice.")
    }
    return userChoice
}

fun printResult(userChoice: String, gameChoice: String) {
    val result: String

    if (userChoice == gameChoice) result = "Tie!"
    else if ((userChoice == "Rock" && gameChoice == "Scissors") ||
        (userChoice == "Paper" && gameChoice == "Rock") ||
        (userChoice == "Scissors" && gameChoice == "Paper")) result = "You win!"
    else result = "You lose!"

    println("You chose $userChoice. I chose $gameChoice. $result")
}
