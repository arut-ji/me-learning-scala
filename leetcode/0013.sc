// Roman Numbers

object Solution {
  def romanToInt(s: String): Int = s match {
    case "" => 0
    case _ =>
      (letterToInt(s.slice(0, 2))) match {
        case -1 => letterToInt(s"${s.head}") + romanToInt(s.tail)
        case _  => letterToInt(s.slice(0, 2)) + romanToInt(s.slice(2, s.length))
      }
  }

  def letterToInt(s: String): Int = s match {
    case "I"  => 1
    case "IV" => 4
    case "V"  => 5
    case "IX" => 9
    case "X"  => 10
    case "XL" => 40
    case "L"  => 50
    case "XC" => 90
    case "C"  => 100
    case "CD" => 400
    case "D"  => 500
    case "CM" => 900
    case "M"  => 1000
    case _    => -1
  }
}
