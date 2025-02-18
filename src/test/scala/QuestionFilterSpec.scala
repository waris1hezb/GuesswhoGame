import QuestionFilter._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class QuestionFilterSpec extends AnyWordSpec with Matchers {

  "filterCharacters" should {
    "return a list of characters wearing glasses" when {
      "they wear glasses." in {
        val question = "Does the character wear glasses?"

        //call the method
        val result = filterCharacters(characters, question, secretCharacter)
        //expected result
        val expectedResult = List(characters.head, characters(2))

        result shouldBe expectedResult
      }
    }
  }
}
