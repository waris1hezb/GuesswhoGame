class GameLogic {

  var remainingCharacters: List[Character] = GameData.characters
  val secretCharacter: Character = remainingCharacters(scala.util.Random.nextInt(remainingCharacters.length))

  def askQuestion(question:String): List[Character] = {

    val newRemainingCharacters = QuestionFilter.filterCharacters(remainingCharacters,question, secretCharacter)
    remainingCharacters = newRemainingCharacters
    remainingCharacters

  }
  def guessCharacter(name:String):Boolean = {
    val guessedCorrectly = name == secretCharacter.name
    if (guessedCorrectly) {
      remainingCharacters = List(secretCharacter)    //Only correct answer remains
      println("Congratulations you guess correctly ")

    } else {
      remainingCharacters = remainingCharacters.filterNot(_.name == name)  ///remove incorrect guess
      println("Incorrect guess, ask a question again")

    }
    guessedCorrectly

  }
}

//Needs to be done by Waris
//Pick a random character that the player has to guess.
//Allow the player to ask yes/no questions to narrow down the possibilities.  ADD THIS
//Filter out characters based on the answers.
//Let the player make a final guess.






// create random, print list of characters and their filtered options. displays the 3 options