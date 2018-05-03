case class DNA(str: String) {
  val m = Map('A' -> 0, 'C' -> 0, 'G' -> 0, 'T' -> 0)

  def nucleotideCounts: Either[String, Map[Char, Int]] = {
    if (!str.toStream.distinct.forall(m.keySet.contains)) Left("Invalid values in sequence")
    else Right(m ++ str.groupBy(identity).mapValues(_.length))
  }
}