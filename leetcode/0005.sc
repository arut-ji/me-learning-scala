object Solution {
  def longestPalindrome(s: String): String = {
    var lps: String = ""
    for (i <- 0 until s.length) {
      val even = expandPalindrome(s, i, i + 1)
      val odd = expandPalindrome(s, i, i)
      lps = List(even, odd).fold(lps) { (acc, x) =>
        (acc.length > x.length) match {
          case true  => acc
          case false => x
        }
      }
    }
    lps
  }

  def expandPalindrome(s: String, lpos: Int, rpos: Int): String = {
    if (lpos < 0 || rpos >= s.length || s.charAt(lpos) != s.charAt(rpos))
      s.slice(lpos + 1, rpos)
    else {
      expandPalindrome(s, lpos - 1, rpos + 1)
    }
  }
}
