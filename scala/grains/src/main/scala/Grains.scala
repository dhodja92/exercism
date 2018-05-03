import scala.annotation.tailrec

object Grains {
  def square(i: Int): Option[BigInt] = {

    @tailrec
    def _sumSquareBigInt(sum: BigInt, current: Int): BigInt = {
      if (current == i) sum
      else _sumSquareBigInt(sum * 2, current + 1)
    }

    if (i < 1 || i > 64) None
    else Some(_sumSquareBigInt(1, 1))
  }

  def total = (square(64).get * 2) - 1
}