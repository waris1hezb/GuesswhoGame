
import scala.io.StdIn

object Main extends App {

  val game = new GameLogic()

  println("Welcome to Guess Who! 🎭")
  println("You can ask questions like: 'Does the character have glasses?' or 'Is the character Male?'")
  println("Or, you can guess the character's name directly.")

  var gameRunning = true

  while (gameRunning) {
    println("\nChoose an option:")
    println("1. Ask a question")
    println("2. Guess the character")
    println("3. Exit game\n")

    val choice = StdIn.readInt()

    choice match {
      case 1 =>
        println("Enter your question:")
        val question = StdIn.readLine()
        game.askQuestion(question)

      case 2 =>
        println("Enter the name of the character you want to guess:")
        val name = StdIn.readLine()
        if (game.guessCharacter(name)) {
          gameRunning = false // End game if guessed correctly
        }

      case 3 =>
        println("Exiting game. Thanks for playing!")
        gameRunning = false

      case _ =>
        println("Invalid choice. Please enter 1, 2, or 3.")
    }
  }
}

//starts the game