import scala.annotation.tailrec

object Allergies {

  object Allergen extends Enumeration {
    type Allergen = Value
    val Eggs = Value(1)
    val Peanuts = Value(2)
    val Shellfish = Value(4)
    val Strawberries = Value(8)
    val Tomatoes = Value(16)
    val Chocolate = Value(32)
    val Pollen = Value(64)
    val Cats = Value(128)
  }

  val allergensSeq = Allergen.values.toList.reverse

  def allergicTo(allergen: Allergen.Value, score: Int): Boolean = {
    if (score < 0 || score < allergen.id) false
    else {
      _allergicTo(Seq(), allergensSeq.iterator, score % 256).contains(allergen)
    }
  }

  def list(score: Int): List[Allergen.Value] = {
    _allergicTo(Seq(), allergensSeq.iterator, score % 256).reverse.toList
  }

  @tailrec
  def _allergicTo(allergicTo: Seq[Allergen.Value], iterator: Iterator[Allergen.Value], score: Int): Seq[Allergen.Value] = {
    if (!iterator.hasNext) allergicTo
    else {
      val next = iterator.next
      if (score >= next.id) _allergicTo(allergicTo :+ next, iterator, score - next.id)
      else _allergicTo(allergicTo, iterator, score)
    }
  }
}