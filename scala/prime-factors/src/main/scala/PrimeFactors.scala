import scala.annotation.tailrec

object PrimeFactors {
  def factors(n: BigInt): List[BigInt] = {

    @tailrec
    def _factors(n: BigInt, divisor: Int, factors: List[BigInt]): List[BigInt] = {
      if (n == 1) factors.reverse
      // increase divisor by 2 instead of 1 and go with odd numbers only, because every even num is divisible by 2
      else if (n % divisor != 0) _factors(n, if (divisor > 2) divisor + 2 else 3, factors)
      else _factors(n / divisor, divisor, divisor :: factors)
    }

    _factors(n, 2, List())
  }
}