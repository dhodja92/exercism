object Raindrops {
  private def map = Map(3 -> "Pling", 5 -> "Plang", 7 -> "Plong")

  def convert(n: Int): String = {
    val out = map.keys.map(divisor => getWord(n, (divisor, map(divisor)))).reduceLeft(_ + _)
    if (out.length == 0) n.toString
    else out
  }

  def byNum(n: Int, divisor: Int) = n % divisor == 0

  def getWord(n: Int, divisor: (Int, String)): String = if (n % divisor._1 == 0) divisor._2 else ""
}