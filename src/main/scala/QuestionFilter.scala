object QuestionFilter {

  def filterCharacters(characters: List[Character], question: String, secretCharacter: Character): (Boolean, List[Character]) = {

    val hairColours = List("blonde", "black", "brown", "red")
    val lowerCaseQuestion = question.toLowerCase

    if (lowerCaseQuestion.contains("glasses")) {
      val hasFeature = secretCharacter.hasGlasses
      (hasFeature, if (hasFeature) characters.filter(_.hasGlasses) else characters)

    } else if (lowerCaseQuestion.contains("hat")) {
      val hasFeature = secretCharacter.hasHat
      (hasFeature, if (hasFeature) characters.filter(_.hasHat) else characters)

    } else if (lowerCaseQuestion.contains("hair")) {
      val matchingHairColour = hairColours.find(colour => lowerCaseQuestion.contains(colour))
      matchingHairColour match {
        case Some(colour) =>
          val hasFeature = secretCharacter.hairColour.toLowerCase == colour
          (hasFeature, if (hasFeature) characters.filter(_.hairColour.toLowerCase == colour) else characters)
        case None => (false, characters)
      }

    } else if (lowerCaseQuestion.contains("gender")) {
      if (lowerCaseQuestion.contains("female")) {
        val hasFeature = secretCharacter.gender == "Female"
        (hasFeature, if (hasFeature) characters.filter(_.gender == "Female") else characters)

      } else if (lowerCaseQuestion.contains("male")) {
        val hasFeature = secretCharacter.gender == "Male"
        (hasFeature, if (hasFeature) characters.filter(_.gender == "Male") else characters)

      } else {
        (false, characters) // If "gender" is mentioned but no specific gender is asked
      }

    } else {
      (false, characters) // Return the same list if no valid question is asked
    }
  }
}























//object QuestionFilter {
//
//  def filterCharacters(characters: List[Character], question: String, secretCharacter: Character): List[Character] = {
//
//    val hairColours = List("blonde", "black", "brown", "red")
//    val lowerCaseQuestion = question.toLowerCase
//
//    if (lowerCaseQuestion.contains("glasses")) {
//      characters.filter(_.hasGlasses == secretCharacter.hasGlasses)
//
//    } else if (lowerCaseQuestion.contains("hat")) {
//      characters.filter(_.hasHat == secretCharacter.hasHat)
//
//    } else if (lowerCaseQuestion.contains("hair")) {
//      val matchingHairColour = hairColours.find(colour => lowerCaseQuestion.contains(colour))
//      matchingHairColour match {
//        case Some(colour) => characters.filter(_.hairColour.toLowerCase == colour)
//        case None => characters
//      }
//
//    } else if (lowerCaseQuestion.contains("gender")) {
//      if (lowerCaseQuestion.contains("female")) {
//        // Only keep characters whose gender matches the secret character's gender
//        characters.filter(_.gender.toLowerCase == secretCharacter.gender.toLowerCase)
//      } else if (lowerCaseQuestion.contains("male")) {
//        // Only keep characters whose gender matches the secret character's gender
//        characters.filter(_.gender.toLowerCase == secretCharacter.gender.toLowerCase)
//      } else {
//        characters // If "gender" is mentioned but no specific gender is asked, return all characters
//      }
//
//    } else {
//      characters // Return all characters if no valid question is asked
//    }
//  }
//}



























// Test filtering by hair colour
//val filteredByHair = filterCharacters(characters, "Does the character have blonde hair?", secretCharacter)
//println(filteredByHair)
//
//// Test asking if the character has glasses
//val filteredByGlasses = filterCharacters(characters, "Does the character have glasses?", secretCharacter)
//println(filteredByGlasses)
//
//// Test asking about gender (should only return males)
//val filteredByGender = filterCharacters(characters, "Is the character Male?", secretCharacter)
//println(filteredByGender)




//  val characters: List[Character] = List(
//    Character("Alice", "Female", "Blonde", hasGlasses = true, hasHat = true),
//    Character("Waris", "Male", "Black", hasGlasses = false, hasHat = false),
//    Character("Ronaldo", "Male", "Black", hasGlasses = true, hasHat = false)
//  )

//  val secretCharacter: Character = Character("Alice", "Female", "Blonde", hasGlasses = true, hasHat = true)

















//object QuestionFilter extends App {
//
//  val characters: List[Character] = List(
//    Character("Alice", "Female", "Blonde", hasGlasses = true, hasHat = true),
//    Character("Waris", "Male", "Black", hasGlasses = false, hasHat = false),
//    Character("Ronaldo", "Male", "Black", hasGlasses = true, hasHat = false)
//  )
//
//  val secretCharacter: Character = Character("Alice", "Female", "Blonde", hasGlasses = true, hasHat = true)
//
//
//  def filterCharacters(characters: List[Character], question: String, secretCharacter: Character): List[Character] = {
//
//    val hairColours = List("blonde", "black", "brown", "red")
//
//
//    if (question.contains("glasses")) {
//      characters.filter(_.hasGlasses == secretCharacter.hasGlasses)
//    }
//    else if (question.contains("hat")) {
//      characters.filter(_.hasHat == secretCharacter.hasHat)
//    }
//    else if (question.toLowerCase.contains("hair")) {
//      val matchingHairColour = hairColours.find(colour => question.toLowerCase.contains(colour))
//      matchingHairColour match {
//        case Some(colour) => characters.filter(_.hairColour.equalsIgnoreCase(colour))
//        case None => characters
//      }
//    }
//    else if (question.contains("gender")) {
//      if (question.contains("male")) {
//        characters.filter(_.gender.equalsIgnoreCase("Male"))
//      }
//      else if (question.contains("female")) {
//        characters.filter(_.gender.equalsIgnoreCase("Female"))
//      }
//      else {
//        characters
//      }
//    }
//    else{
//        characters
//
//    }
//
//  }
//
////  Test filtering by hair colour
//
//  val filteredByHair = QuestionFilter.filterCharacters(characters, "Does the character have blonde hair?", secretCharacter)
//  println(filteredByHair)
//
//  //   Asking if the character has glasses
//  val filteredByGlasses = QuestionFilter.filterCharacters(characters, "Does the character have glasses?", secretCharacter)
//  println(filteredByGlasses)
//
//  // Asking about gender
//  val filteredByGender = QuestionFilter.filterCharacters(characters, "Is the character Male?", secretCharacter)
//  println(filteredByGender)
//
//}
//
//


//Handles  filtering logic for questions using if/else statements
  //SANDRA TEST _ CAN YOU READ THIS??
