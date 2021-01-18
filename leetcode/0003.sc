// Longest Substring Without Repating Charaters

object Solution {
  def max(a: Int, b: Int) = (a < b) match {
    case true  => b
    case false => a
  }

  def lengthOfLongestSubstring(s: String): Int = {
    var lastSeenAt = Array.fill[Int](258)(-1)
    var result = 0
    var i = 0

    for (j <- 1 to s.length) {
      i = max(i, lastSeenAt(s.charAt(j - 1).toByte))
      result = max(result, j - i)
      lastSeenAt(s.charAt(j - 1).toByte) = j
    }
    result
  }
}
