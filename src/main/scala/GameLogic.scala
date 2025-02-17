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







// create random, print list of characters and their filtered options. displays the 3 options