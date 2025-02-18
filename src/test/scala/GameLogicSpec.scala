import GameData.characters
//import scala.GameLogic
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec


class GameLogicSpec extends AnyWordSpec with Matchers {

  val gamelogic = new GameLogic //making an instance of our class.
  val secretCharacter: Character = Character("Ronaldo", "Male", "Black", hasGlasses = true, hasHat = false)

  "askQuestion" should {

    //test to check if when the answer is true the computer returns Yes

    "return an updated list of remaining characters" when {
      "the characters match the boolen type of true" in {

        val question = "Is the character male?"

        //call the method
        val result = gamelogic.askQuestion(question)

        //expected result
        val expectedResult = (List(characters(1), characters(2), characters(5)))

        result shouldBe expectedResult

      }
    }
  }
}

