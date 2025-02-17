object QuestionFilter {

  def filterCharacters(characters: List[Character], question: String, secretCharacter: Character): List[Character] = {

    val hairColours = List("blonde", "black", "brown", "red")


    if (question.contains("glasses")) {
      characters.filter(_.hasGlasses == secretCharacter.hasGlasses)
    }
    else if (question.contains("hat")) {
      characters.filter(_.hasHat == secretCharacter.hasHat)
    }
    else if (question.toLowerCase.contains("hair")) {
      val matchingHairColour = hairColours.find(colour => question.toLowerCase.contains(colour))
      matchingHairColour match {
        case Some(colour) => characters.filter(_.hairColour.equalsIgnoreCase(colour))
        case None => characters
      }
    }
    else if (question.contains("gender")) {
      if (question.contains("male")) {
        characters.filter(_.gender.equalsIgnoreCase("Male"))
      }
      else if (question.contains("female")) {
        characters.filter(_.gender.equalsIgnoreCase("Female"))
      }
      else {
        characters
      }
    }
    else{
        characters

    }

  }

}



//Handles  filtering logic for questions using if/else statements
