// Remove Element

object Solution {
  def removeElement(nums: Array[Int], instance: Int): Int = {
    var lastFound = 0
    var count = 0
    for (i <- 0 until (nums.length)) {
      if (instance != nums(i)) {
        // Increase the non-match
        count += 1
        nums(lastFound) = nums(i)
        lastFound += 1
      }
    }
    count
  }
}
