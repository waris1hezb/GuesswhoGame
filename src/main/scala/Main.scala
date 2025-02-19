//This file initializes and runs the game. It handles user interaction and processes inputs through the command line.
import scala.io.StdIn

object Main extends App {
  val game = new GameLogic()

  AsciiArt.printLogo()

  println(Console.CYAN + "\nYou can ask questions like:" + Console.RESET)
  println(Console.MAGENTA + "🔹 'Does the character have glasses?'" + Console.RESET)
  println(Console.MAGENTA + "🔹 'Is the character wearing a hat?'" + Console.RESET)
  println(Console.MAGENTA + "🔹 Or, you can guess the character's name directly!\n" + Console.RESET)

  var gameRunning = true

  while (gameRunning) {
    println(Console.BLUE + "\n🔹 Choose an option: 1, 2, or 3 🔹" + Console.RESET)
    println(Console.YELLOW + "1️⃣ Ask a question" + Console.RESET)
    println(Console.YELLOW + "2️⃣ Guess the character" + Console.RESET)
    println(Console.YELLOW + "3️⃣ Exit game\n" + Console.RESET)

    val choice = StdIn.readInt()

    choice match {
      case 1 =>
        println(Console.CYAN + "💡 Enter your question:" + Console.RESET)
        val question = StdIn.readLine()
        game.askQuestion(question)

      case 2 =>
        println(Console.CYAN + "🎯 Enter the name of the character you want to guess:" + Console.RESET)
        val name = StdIn.readLine().capitalize
        if (game.guessCharacter(name)) {
          gameRunning = false
        }

      case 3 =>
        println(Console.RED + "🚪 Exiting game. Thanks for playing!" + Console.RESET)
        gameRunning = false

      case _ =>
        println(Console.RED + "⚠️ Invalid choice. Please enter 1, 2, or 3." + Console.RESET)
    }
  }
}

