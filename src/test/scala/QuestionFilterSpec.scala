
import org.scalatest.flatspec.AnyFlatSpec

class QuestionFilterSpec extends AnyFlatSpec{

  val filterQuestion = new QuestionFilter

  "glasses" should "return all the characters wearing glasses" in {
    assert(filterQuestion.filterQuestion())
  }


}
