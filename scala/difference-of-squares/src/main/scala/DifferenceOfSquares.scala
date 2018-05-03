object DifferenceOfSquares {
  private def square(n: Int) = n * n
  def squareOfSum(n: Int): Int = square((1 to n).sum)
  def sumOfSquares(n: Int): Int = (1 to n).map(square).sum
  def differenceOfSquares(n: Int): Int = squareOfSum(n) - sumOfSquares(n)
}
