object Solution {
  def isValid(s: String): Boolean = { _isValid(List[Char](), s) }

  def _isValid(mem: List[Char], s: String): Boolean = s match {
    case "" => mem.length == 0
    case _ =>
      s.head match {
        case '(' | '[' | '{' => true && _isValid(s.head :: mem, s.tail)
        case _ =>
          mem match {
            case Nil     => false
            case x :: xs => matchParen(x, s.head) && _isValid(xs, s.tail)
          }
      }
  }

  def matchParen(a: Char, b: Char): Boolean = {
    (s"${a}${b}") match {
      case "()" | "[]" | "{}" => true
      case _                  => false
    }
  }
}
