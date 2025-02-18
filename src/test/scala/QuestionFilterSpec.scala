import GameData.characters
import QuestionFilter._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class QuestionFilterSpec extends AnyWordSpec with Matchers {

  val secretCharacter: Character = Character("Ronaldo", "Male", "Black", hasGlasses = true, hasHat = false)

  "filterCharacters" should {
    //test if the secret character has glasses and return a list of all characters that match his hasGlasses boolean
    "return a boolean and a list of characters wearing glasses" when {
      "the characters wear glasses" in {
        val question = "does the person have glasses?"

        //call the method
        val result = filterCharacters(characters, question, secretCharacter)

        //expected result
        val expectedResult = (true, List(characters.head, characters(2), characters(4)))

        result shouldBe expectedResult
      }
    }

    //test if the secret character has glasses and return a list of all characters that match his hasHat boolean
    "return a boolean and a list of characters wearing a hat" when {
      "the characters wear a hat" in {
        val question = "do they wear a hat?"

        val result = filterCharacters(characters, question, secretCharacter)

        val expectedResult = (false, List(characters(1), characters(2), characters(4)))

        result shouldBe expectedResult
      }
    }

    //test if the secret character is Male and this will return a list of all characters

  }
}
