case class Triangle(a: Double, b: Double, c: Double) {
  def equilateral = isValid && isEquilateral
  def isosceles = isValid && isIsosceles
  def scalene = isValid && isScalene

  def isEquilateral = a == b && a == c
  def isIsosceles = (a == b || b == c || a == c)
  def isScalene = a != b && b != c && a != c

  def hasPositiveSideLengths = a > 0 && b > 0 && c > 0
  def hasValidSideLengths = (a + b >= c) && (a + c >= b) && (b + c >= a)
  def isValid = hasPositiveSideLengths && hasValidSideLengths
}