import scala.annotation.tailrec

object BinarySearch {
  def find(list: List[Int], num: Int): Option[Int] = {

    @tailrec
    def _find(min: Int, max: Int): Option[Int] = {
      val index = (min + max) / 2
      if (list(index) == num) Some(index)
      else if (min > max) None
      else {
        list(index) > num match {
          case true => _find(min, index - 1)
          case false => _find(index + 1, max)
        }
      }
    }

    if (list.length == 0) None
    else _find(0, list.length - 1)
  }
}
