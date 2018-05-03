object ScrabbleScore {
  val scores: Map[Char, Int] = Map(
    1 -> Seq('a', 'e', 'i', 'o', 'u', 'l', 'n', 'r', 's', 't'),
    2 -> Seq('d', 'g'),
    3 -> Seq('b', 'c', 'm', 'p'),
    4 -> Seq('f', 'h', 'v', 'w', 'y'),
    5 -> Seq('k'),
    8 -> Seq('j', 'x'),
    10 -> Seq('q', 'z')
  ).flatMap { case (value, letters) => letters.map(letter => (letter, value)) }

  def score(str: String): Int = str.toLowerCase.toCharArray.map(score).sum

  def score(c: Char): Int = scores.getOrElse(c, 0)
}