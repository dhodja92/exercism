object SumOfMultiples {
  def sum(set: Set[Int], upper: Int): Int = {
    (1 until upper).filter(num => set.exists(setElem => num % setElem == 0)).sum
  }
}