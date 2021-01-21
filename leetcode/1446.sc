// Consecutive Characters

object Solution {
  def maxPower(s: String): Int = {
    s.sliding(2)
      .toList
      .scanLeft(1) { (acc, x) =>
        if (x.length <= 1) x.length
        else {
          if (x(0) == x(1)) acc + 1
          else 1
        }
      }
      .max
  }
}
