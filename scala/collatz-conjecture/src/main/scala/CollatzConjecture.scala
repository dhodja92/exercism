import scala.annotation.tailrec

object CollatzConjecture {
  def steps(num: Int): Option[Int] = {
    @tailrec
    def _steps(num: Int, step: Int): Option[Int] = {
      if (num < 1) None
      else if (num == 1) Some(step)
      else {
        if (num % 2 != 0) _steps(num * 3 + 1, step + 1)
        else _steps(num / 2, step + 1)
      }
    }
    _steps(num, 0)
  }
}