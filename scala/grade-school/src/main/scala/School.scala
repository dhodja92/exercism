import scala.collection.immutable.SortedMap

class School {
  type DB = Map[Int, Seq[String]]

  private var data: DB = Map()

  def db(): DB = data

  def add(name: String, studentGrade: Int): Unit = {
    val current = grade(studentGrade) :+ name
    data = data + (studentGrade -> current)
  }

  def grade(studentGrade: Int): Seq[String] = data.getOrElse(studentGrade, Seq())

  def sorted: DB = SortedMap(data.toSeq: _*).mapValues(_.sorted)
}