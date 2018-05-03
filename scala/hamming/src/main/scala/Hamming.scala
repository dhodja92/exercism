object Hamming {
  def distance(a: String, b: String) = {
    if (a.length != b.length) None
    else Some((0 until a.length).filter(i => a(i) != b(i)).length)
  }
}