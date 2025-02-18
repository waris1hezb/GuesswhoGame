//
//import scala.io.StdIn
//
//object Main extends App {
//  //Initialise the game logic
//  val game = new GameLogic()
//
//  println("Welcome to Guess Who! 🎭")
//  println("You can ask questions like: 'Does the character have glasses?' or 'Is the character Male?'")
//  println("Or, you can guess the character's name directly.")
//
//  //control variable to keep the game running
//  var gameRunning = true
//
//  while (gameRunning) {
//    println("\nChoose an option: 1, 2, or 3")
//    println("1. Ask a question")
//    println("2. Guess the character")
//    println("3. Exit game\n")
//
//    //Read players choice
//    val choice = StdIn.readInt()
//
//    choice match {
//      case 1 =>
//        println("Enter your question:")
//        val question = StdIn.readLine()
//        game.askQuestion(question)
//
//      case 2 =>
//        println("Enter the name of the character you want to guess:")
//        val name = StdIn.readLine().capitalize
//        if (game.guessCharacter(name)) {
//          gameRunning = false // End game if guessed correctly
//        }
//
//      case 3 =>
//        println("Exiting game. Thanks for playing!")
//        gameRunning = false
//
//      case _ =>
//        println("Invalid choice. Please enter 1, 2, or 3.")
//    }
//  }
//}

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

