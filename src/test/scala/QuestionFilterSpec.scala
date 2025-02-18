import GameData.characters
import QuestionFilter._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class QuestionFilterSpec extends AnyWordSpec with Matchers {

  val secretCharacter: Character = Character("Ronaldo", "Male", "Black", hasGlasses = true, hasHat = false)

  "filterCharacters" should {
    "return a Boolean and a list of characters wearing glasses" when {
      "the characters wear glasses" in {
        val question = "Does the character wear glasses?"

        //call the method
        val result = filterCharacters(characters, question, secretCharacter)
        //expected result
        val expectedResult = true; characters(0); characters(3); characters(5)

        result shouldBe expectedResult
      }
    }
  }
}
