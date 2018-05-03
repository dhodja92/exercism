class Accumulate {
  def accumulate[T, U](f: (T) => Any, list: List[T]): List[Any] = for (el <- list) yield f(el)

  def apply[T](x: T, y: (T) => Any) = y(x)
}
