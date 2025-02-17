class GameLogic {

  // List of remaining characters in the game
  var remainingCharacters: List[Character] = GameData.characters

  // Randomly select a secret character for the player to guess
//  val secretCharacter: Character = remainingCharacters(scala.util.Random.nextInt(remainingCharacters.length))
  val secretCharacter: Character = Character("Ronaldo", "Male", "Black", hasGlasses = true, hasHat = false)

  // Asks a yes/no question and filters characters accordingly
  def askQuestion(question: String): List[Character] = {
    val (answer, newRemainingCharacters) = QuestionFilter.filterCharacters(remainingCharacters, question, secretCharacter)

    // Print the yes/no response
    if (answer) {
      println("Yes!")
      remainingCharacters = newRemainingCharacters // Only update if the answer is "Yes"
    } else {
      println("No.")
      remainingCharacters = newRemainingCharacters
    }

    println(s"Characters remaining: ${remainingCharacters.map(_.name).mkString(", ")}") // Display remaining characters
    remainingCharacters
  }

  // Player makes a guess about the secret character
  def guessCharacter(name: String): Boolean = {
    val guessedCorrectly = name == secretCharacter.name

    if (guessedCorrectly) {
      remainingCharacters = List(secretCharacter) // Only the correct answer remains
      println(s"🎉 Congratulations! You guessed correctly: $name")
    } else {
      remainingCharacters = remainingCharacters.filterNot(_.name == name) // Remove incorrect guess
      println(s"❌ Incorrect guess: $name. Try asking more questions.")
    }
    guessedCorrectly
  }
}


































//import scala.util.Random
//
//class GameLogic {
//
//  // List of remaining characters in the game
//  var remainingCharacters: List[Character] = GameData.characters
//
//  // Randomly select a secret character for the player to guess
//
//  val secretCharacter: Character = remainingCharacters(Random.nextInt(remainingCharacters.length))
//
//  // Asks a yes/no question and filters characters accordingly
//  def askQuestion(question: String): List[Character] = {
//    val newRemainingCharacters = QuestionFilter.filterCharacters(remainingCharacters, question, secretCharacter)
//    remainingCharacters = newRemainingCharacters
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
//      remainingCharacters = remainingCharacters.filterNot(_.name == name) // Remove incorrect guess
//      println(s"❌ Incorrect guess: $name. Try asking more questions.")
//    }
//    guessedCorrectly
//  }
//}













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