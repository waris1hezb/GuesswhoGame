import GameData.characters
import QuestionFilter._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class QuestionFilterSpec extends AnyWordSpec with Matchers {

  val secretCharacter: Character = Character("Ronaldo", "Male", "Black", hasGlasses = true, hasHat = false)

  "filterCharacters" should {
    //test if the secret character has glasses and return a list of all characters that match his hasGlasses with boolean of true
    "return true and a list of characters wearing glasses" when {
      "the characters wear glasses" in {
        val question = "does the person have glasses?"

        //call the method
        val result = filterCharacters(characters, question, secretCharacter)

        //expected result
        val expectedResult = (true, List(characters.head, characters(2), characters(4)))

        result shouldBe expectedResult
      }
    }

    //test if the secret character has glasses and return a list of all characters that match his hasHat with boolean of false
    "return false and a list of characters wearing a hat" when {
      "the characters wear a hat" in {
        val question = "do they wear a hat?"

        val result = filterCharacters(characters, question, secretCharacter)

        val expectedResult = (false, List(characters(1), characters(2), characters(4), characters(5), characters(7)))

        result shouldBe expectedResult
      }
    }

    //test if the secret character is Male and this will return a list of all characters that are male
    "return true and a list of characters who are male" when {
      "the characters are men" in {
        val question = "is the character male?"

        val result = filterCharacters(characters, question, secretCharacter)

        val expectedResult = (true, List(characters(1), characters(2), characters(5)))

        result shouldBe expectedResult
      }
    }


    //test if the secret character is Female and this will return a list of all characters that are female
    "return false and a list of characters who are female" when {
      "the characters are female" in {
        val question = "is the character female?"

        val result = filterCharacters(characters, question, secretCharacter)

        val expectedResult = (false, List(characters(1), characters(2), characters(5)))

        result shouldBe expectedResult
      }
    }


    //test if the hair colour is blonde and this will return a list of all characters that are not blonde

    "return false and a list of characters who are not blonde" when {
      "the characters are not blonde" in {
        val question = "Does the person have blonde hair"

        val result = filterCharacters(characters, question, secretCharacter)

        val expectedResult = (false, List(characters(1), characters(2), characters(3), characters(4), characters(6), characters (7)))
        result shouldBe expectedResult
      }
    }


    //test if the hair colour is black and this will return a list of all characters that have black hair

    "return true and a list of characters who have black hair" when {
      "the characters have black hair" in {
        val question = "does the person have black hair"

        val result = filterCharacters(characters, question, secretCharacter)

        val expectedResult = (true, List(characters(1), characters(2), characters (7)))

        result shouldBe expectedResult
      }
    }

    //test if anything invalid is entered, it will return all the characters entirely
    "return false and a list of all characters" when {
      "anything is invalid" in {
        val question = "Is it an alien"

        val result = filterCharacters(characters, question, secretCharacter)

        val expectedResult = (false, List(characters(0), characters(1), characters(2), characters(3), characters(4), characters(5), characters(6), characters(7)))
        result shouldBe expectedResult
      }
    }


    //test if nothing is entered, it will return all the characters entirely
    "return false and a list of all characters" when {
      "nothing is entered" in {
        val question = ""

        val result = filterCharacters(characters, question, secretCharacter)

        val expectedResult = (false, List(characters(0), characters(1), characters(2), characters(3), characters(4), characters(5), characters(6), characters(7)))
        result shouldBe expectedResult
      }
    }



  }
}
