import scala.annotation.tailrec

object Sieve {
  def primes(n: Int): List[Int] = {

    @tailrec
    def _primes(list: List[Int], divisor: Int): List[Int] = {
      val remaining = filterPrimes(list, divisor)
      val nextDivisor = getNextDivisor(remaining, divisor)
      if (nextDivisor == 0) remaining
      else _primes(remaining, nextDivisor)
    }

    if (n == 1) List()
    else if (n == 2) List(2)
    else _primes((2 to n).toList, 2)
  }

  private def filterPrimes(list: List[Int], divisor: Int): List[Int] = {
    list.filter(i => i % divisor > 0 || i == divisor)
  }

  private def getNextDivisor(list: List[Int], current: Int): Int = {
    list.find(_ > current).getOrElse(0)
  }

}