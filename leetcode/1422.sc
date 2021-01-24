// Maximum Score Sfter Splitting a String

object Solution {
  def maxScore(s: String): Int = {
    val right = s.scanLeft(0)((acc, x) => if (x == '1') acc + 1 else acc)
    val left = s.scanLeft(0)((acc, x) => if (x == '0') acc + 1 else acc)

    val totalOnes = right.last
    right
      .zip(left)
      .drop(1)
      .dropRight(1)
      .map { x =>
        {
          val (ones, zeros) = x
          totalOnes - ones + zeros
        }
      }
      .max
  }
}
