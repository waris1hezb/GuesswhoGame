//This file manages the game flow and keeps track of the remaining characters.
//class GameLogic {
//
//  // List of remaining characters in the game
//  var remainingCharacters: List[Character] = GameData.characters
//
//  // Randomly select a secret character for the player to guess
//    val secretCharacter: Character = remainingCharacters(scala.util.Random.nextInt(remainingCharacters.length))
////  val secretCharacter: Character = Character("Ronaldo", "Male", "Black", hasGlasses = true, hasHat = false)
//
//  // Asks a yes/no question and filters characters accordingly
//  //Calls QuestionFilter.filterCharacters to determine the answer (true if it matches the feature or false) and filter the remaining characters.
//
//  def askQuestion(question: String): List[Character] = {
//    val (answer, newRemainingCharacters) = QuestionFilter.filterCharacters(remainingCharacters, question, secretCharacter)
//
//    // Print the yes/no response
//    if (answer) {
//      println("Yes!")
//      remainingCharacters = newRemainingCharacters // Only update if the answer is "Yes"
//    } else {
//      println("No.")
//      remainingCharacters = newRemainingCharacters
//    }
//
//    println(s"Characters remaining: ${remainingCharacters.map(_.name).mkString(", ")}") // Display remaining characters
//    remainingCharacters
//  }
//
//  // Player makes a guess about the secret character
//  def guessCharacter(name: String): Boolean = {
//    val guessedCorrectly = name == secretCharacter.name
//
//    if (guessedCorrectly) {
//      remainingCharacters = List(secretCharacter) // Only the correct answer remains
//      println(s"🎉 Congratulations! You guessed correctly: $name")
//    } else {
//      remainingCharacters = remainingCharacters.filterNot(_.name.equalsIgnoreCase(name)) // Remove incorrect guess
//      println(s"❌ Incorrect guess: $name. Try asking more questions.")
//    }
//    guessedCorrectly
//  }
//}


class GameLogic {

  var remainingCharacters: List[Character] = GameData.characters
  val secretCharacter: Character = remainingCharacters(scala.util.Random.nextInt(remainingCharacters.length))

  // Unique icons for each character
  val characterIcons: Map[String, String] = Map(
    "Ronaldo" -> "⚽", "Alice" -> "👩‍🎤", "Diana" -> "👸", "Waris" -> "🕵️‍♂️",
    "Halaand" -> "⚽", "Dorothea" -> "📚", "Sandra" -> "🚀", "Mary" -> "🎭"
  )

  def askQuestion(question: String): List[Character] = {
    val (answer, newRemainingCharacters) = QuestionFilter.filterCharacters(remainingCharacters, question, secretCharacter)

    if (answer) {
      println(Console.GREEN + "✅ Yes!" + Console.RESET)
    } else {
      println(Console.RED + "❌ No." + Console.RESET)
    }

    remainingCharacters = newRemainingCharacters
    displayRemainingCharacters()
    remainingCharacters
  }

  def guessCharacter(name: String): Boolean = {
    val guessedCorrectly = name.equalsIgnoreCase(secretCharacter.name)

    if (guessedCorrectly) {
      remainingCharacters = List(secretCharacter)
      println(Console.GREEN + s"🎉 Congratulations! You guessed correctly: $name" + Console.RESET)
    } else {
      remainingCharacters = remainingCharacters.filterNot(_.name.equalsIgnoreCase(name))
      println(Console.RED + s"❌ Incorrect guess: $name. Try asking more questions." + Console.RESET)
    }

    displayRemainingCharacters()
    guessedCorrectly
  }

  def displayRemainingCharacters(): Unit = {
    println(Console.YELLOW + "\n📜 Remaining Characters:" + Console.RESET)

    remainingCharacters.foreach { character =>
      val icon = characterIcons.getOrElse(character.name, "❓") // Default if not found
      println(Console.BLUE + s"[ $icon ${character.name}]" + Console.RESET)
    }
  }
}







































//Needs to be done by Waris
//Pick a random character that the player has to guess.
//Allow the player to ask yes/no questions to narrow down the possibilities.  ADD THIS
//Filter out characters based on the answers.
//Let the player make a final guess.






// create random, print list of characters and their filtered options. displays the 3 options


//def askQuestion(question: String): List[Character] = {
//  val newRemainingCharacters = QuestionFilter.filterCharacters(remainingCharacters, question, secretCharacter)
//  remainingCharacters = newRemainingCharacters
//
//  println("\nCharacters remaining:")
//  println("+--------------------------------------------------------+")
//  println("| Name      | Gender     | Hair Colour | Glasses | Hat   |")
//  println("+--------------------------------------------------------+")
//  remainingCharacters.foreach { char =>
//    println(f"| ${char.name}%-10s | ${char.gender}%-8s | ${char.hairColour}%-12s | ${char.hasGlasses}%-7s | ${char.hasHat}%-5s |")
//  }
//  println("+--------------------------------------------------------+")
//
//  remainingCharacters
//}