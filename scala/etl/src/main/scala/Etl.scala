import scala.collection.immutable.ListMap

object Etl {
  def transform(map: Map[Int, Seq[String]]): Map[String, Int] = {
    var out: Map[String, Int] = Map()
    for (key <- map.keysIterator; letter <- map(key)) {
      out += letter.toLowerCase() -> key
    }
    ListMap(out.toSeq.sortBy(_._1):_*)
  }
}