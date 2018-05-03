object Bob {
  private def isSilence(str: String) = str.forall(_.isWhitespace)
  private def isQuestion(str: String) = str.trim.endsWith("?") && !isYell(str)
  private def isYell(str: String) = str.exists(_.isUpper) && !str.exists(_.isLower)
  private def isWarning(str: String) = str.trim.endsWith("?") && isYell(str) && !str.forall(_.isDigit)

  def response(str: String): String = str match {
    case str if isWarning(str) => "Calm down, I know what I'm doing!"
    case str if isQuestion(str) => "Sure."
    case str if isYell(str) => "Whoa, chill out!"
    case str if isSilence(str) => "Fine. Be that way!"
    case _ => "Whatever."
  }
}