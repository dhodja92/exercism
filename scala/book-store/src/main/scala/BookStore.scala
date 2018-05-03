import scala.annotation.tailrec

object BookStore {
  // incomplete solution - does not pass tests on line 36 & 60

  var books: Map[Int, Int] = Map()
  def total(list: List[Int]): Int = {
    @tailrec
    def _total(sum: Int): Int = {
      if (books.values.forall(count => count == 0)) sum
      else {
        _total(sum + calculateSum(books.keysIterator.count(key => remove(key))))
      }
    }

    books = list.groupBy(identity).mapValues(_.size)
    _total(0)
  }

  def remove(book: Int): Boolean = {
    if (books.get(book) == None) false
    else {
      val current = books.get(book).get - 1
      if (current == 0) books = books - book
      else books = books + (book -> current)
      true
    }
  }

  def calculateSum(booksAtOnce: Int): Int = booksAtOnce match {
    case 5 => (800 * booksAtOnce * 0.75).toInt
    case 4 => (800 * booksAtOnce * 0.8).toInt
    case 3 => (800 * booksAtOnce * 0.9).toInt
    case 2 => (800 * booksAtOnce * 0.95).toInt
    case _ => 800 * booksAtOnce
  }
}