trait NumberType
object NumberType {
  object Deficient extends NumberType
  object Abundant extends NumberType
  object Perfect extends NumberType
}

object PerfectNumbers {
  private def aliquotSum(num: Int) = (1 to num / 2).filter(num % _ == 0).sum

  def classify(num: Int): Either[String, NumberType] = {
    if (num < 1) Left("Classification is only possible for natural numbers.")
    else {
      aliquotSum(num) match {
        case (x) if x > num => Right(NumberType.Abundant)
        case (x) if x < num => Right(NumberType.Deficient)
        case _ => Right(NumberType.Perfect)
      }
    }
  }
}