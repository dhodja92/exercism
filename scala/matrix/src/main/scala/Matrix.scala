class Matrix(val mtxStr: String) {
  lazy val mtx = mtxStr
    .split("\n")
    .map(line => line.split(" ")
      .filter(word => word.forall(c => c.isDigit))
      .map(_.toInt))

  def row(row: Int) = mtx(row)
  def column(col: Int) = mtx.map(row => row(col))

  override def equals(obj: scala.Any): Boolean = {
    obj.isInstanceOf[Matrix] && obj.asInstanceOf[Matrix].mtxStr == this.mtxStr
  }
}

object Matrix {
  def apply(str: String) = new Matrix(str)
}