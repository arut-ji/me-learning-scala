// Remove Duplicates from Sorted Array
object Solution {
  def removeDuplicates(nums: Array[Int]): Int = {
    val result = nums
      .foldLeft(List[Int]()) { (acc, x) =>
        acc match {
          case Nil => List(x)
          case _ =>
            (acc.last == x) match {
              case false => acc ++ List(x)
              case true  => acc
            }
        }
      }
    for (i <- 0 until result.length) {
      nums(i) = result(i)
    }
    result.length
  }
}
