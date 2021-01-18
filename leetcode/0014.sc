// Longest Common Prefix

// Optimization needed

object Solution {
  def getCommonPrefix(l: String, r: String): String = {
    if (l == "" || r == "") {
      ""
    } else {
      (l.charAt(0) == r.charAt(0)) match {
        case false => ""
        case true => {
          val next = getCommonPrefix(
            l.slice(1, l.length),
            r.slice(1, r.length)
          )
          s"${l.charAt(0)}${next}"
        }
      }
    }
  }

  def longestCommonPrefix(strs: Array[String]): String = strs match {
    case Array() => ""
    case _ => {
      val init = strs(0)
      strs.slice(1, strs.length).fold(init) { (acc, x) =>
        getCommonPrefix(acc, x)
      }
    }
  }
}
