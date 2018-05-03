object Pangrams {
  // optimized/refactored after extensive Google searching
  private val letters = 'a' to 'z'
  def isPangram(str: String): Boolean = {
    val strLowerCase = str.toLowerCase
    letters.forall(c => strLowerCase.indexOf(c) != -1)
  }
}