import scala.annotation.tailrec

object ProteinTranslation {

  def proteins(str: String): Seq[String] = {

    @tailrec
    def _proteins(iterator: Iterator[Stream[Char]], seq: Seq[String]): Seq[String] = {
      if (!iterator.hasNext) seq.reverse
      else _proteins(iterator, matchSeq(iterator.next.mkString, seq))
    }

    def matchSeq(str: String, seq: Seq[String]): Seq[String] = str match {
      case s if isStop(s) => seq
      case s if isMethionine(s) => "Methionine" +: seq
      case s if isPhenylalanine(s) => "Phenylalanine" +: seq
      case s if isLeucine(s) => "Leucine" +: seq
      case s if isSerine(s) => "Serine" +: seq
      case s if isTyrosine(s) => "Tyrosine" +: seq
      case s if isCysteine(s) => "Cysteine" +: seq
      case s if isTryptophan(s) => "Tryptophan" +: seq
    }

    def isStop(str: String) = str == "UAA" || str == "UAG" || str == "UGA"

    def isMethionine(str: String) = str == "AUG"

    def isPhenylalanine(str: String) = str == "UUU" || str == "UUC"

    def isLeucine(str: String) = str == "UUA" || str == "UUG"

    def isSerine(str: String) = str.startsWith("UC")

    def isTyrosine(str: String) = str == "UAU" || str == "UAC"

    def isCysteine(str: String) = str == "UGU" || str == "UGC"

    def isTryptophan(str: String) = str == "UGG"

    _proteins(str.toStream.grouped(3).takeWhile(s => !isStop(s.mkString)), Nil)

  }
}