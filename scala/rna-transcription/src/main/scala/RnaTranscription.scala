object RnaTranscription {
  def toRna(str: String): Option[String] = {
    Some(str.map(transform))
  }

  def transform(c: Char) = c match {
    case 'C' => 'G'
    case 'G' => 'C'
    case 'T' => 'A'
    case 'A' => 'U'
    case _ => '*'
  }
}