// Letter Combinations of a Phone Number

object Solution {
  def letterCombinations(digits: String): List[String] = digits match {
    case "" => List()
    case _  => _letterCombinations(digits)
  }

  def _letterCombinations(digits: String): List[String] = digits match {
    case "" => List()
    case _ => {
      val currentDigit = digits.head
      val variants = currentDigit match {
        case '2' => List("a", "b", "c")
        case '3' => List("d", "e", "f")
        case '4' => List("g", "h", "i")
        case '5' => List("j", "k", "l")
        case '6' => List("m", "n", "o")
        case '7' => List("p", "q", "r", "s")
        case '8' => List("t", "u", "v")
        case '9' => List("w", "x", "y", "z")
      }
      val next = _letterCombinations(digits.slice(1, digits.length))
      var result: List[String] = List()
      for (variant <- variants) {
        result = result ++ next.map(variant ++ _)
      }
      result
    }
  }

}

Solution.letterCombinations("23")
