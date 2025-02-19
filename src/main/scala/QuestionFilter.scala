//This file contains the logic for filtering characters based on user questions.
object QuestionFilter {

  //Returns:
  //A Boolean indicating if the answer to the question is true or false.
  //A filtered list of remaining characters.
  def filterCharacters(characters: List[Character], question: String, secretCharacter: Character): (Boolean, List[Character]) = {

    val hairColours = List("blonde", "black", "brown", "red")
    val lowerCaseQuestion = question.toLowerCase


//    Checks if the question contains "glasses".
//    If the secret character has glasses (true), filter only those who have glasses.
//    If not, remove all characters who have glasses.

    if (lowerCaseQuestion.contains("glasses")) {
      val hasFeature = secretCharacter.hasGlasses
      (hasFeature, if (hasFeature) characters.filter(_.hasGlasses) else characters.filterNot(_.hasGlasses))

    } else if (lowerCaseQuestion.contains("hat")) {
      val hasFeature = secretCharacter.hasHat
      (hasFeature, if (hasFeature) characters.filter(_.hasHat) else characters.filterNot(_.hasHat))

    } else if (lowerCaseQuestion.contains("hair")) {
      val matchingHairColour = hairColours.find(colour => lowerCaseQuestion.contains(colour))
      matchingHairColour match {
        case Some(colour) =>
          val hasFeature = secretCharacter.hairColour.equalsIgnoreCase(colour)
          (hasFeature, if (hasFeature) characters.filter(_.hairColour.equalsIgnoreCase(colour)) else characters.filterNot(_.hairColour.equalsIgnoreCase(colour)))
        case None => (false, characters)
      }

      //If "gender" is in the question, check if it refers to "Male" or "Female".
      //If the secret character is female, filter females; otherwise, remove females.
    } else if (lowerCaseQuestion.contains("is the character female")) {
      val hasFeature = secretCharacter.gender == "Female"
      (hasFeature, if (hasFeature) characters.filter(_.gender == "Female") else characters.filterNot(_.gender == "Female"))

    } else if (lowerCaseQuestion.contains("is the character male")) {
      val hasFeature = secretCharacter.gender == "Male"
      (hasFeature, if (hasFeature) characters.filter(_.gender == "Male") else characters.filterNot(_.gender == "Male"))

    } else {
      (false, characters) // Return the same list if no valid question is asked
    }
  }
}














