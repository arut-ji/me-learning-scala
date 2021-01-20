object Solution {
  def aux(s: String): String = {
    s match {
      case "" => ""
      case  _ => {
        val first = s.head
        val count = s.takeWhile(_ == first).length
        s"${count}${first}" ++ aux(s.slice(count, s.length))
      }
    }
  }
  
  def countAndSay(n: Int): String = n match {
    case 1 => "1"
    case _ => {
      val str = countAndSay(n - 1)
      aux(str)
    }
  }

}