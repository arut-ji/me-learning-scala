// Longest Substring Without Repating Charaters

object Solution {

  def max(a: Int, b: Int): Int = if (a < b) b else a

  def reduceUntilRepeated(xs: String, ys: String): Int = ys match {
    case "" => 0
    case _ => {
      (xs.contains(ys.head)) match {
        case true => 0
        case false =>
          1 + reduceUntilRepeated(xs + ys.head, ys.slice(1, ys.length))
      }
    }
  }

  def lengthOfLongestSubstring(s: String): Int = s match {
    case "" => 0
    case _ =>
      max(
        reduceUntilRepeated("", s),
        lengthOfLongestSubstring(s.slice(1, s.length))
      )
  }
}
