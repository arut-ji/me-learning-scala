// Maximum Subarray

object Solution {
  def max(a: Int, b: Int) = if (a > b) a else b

  def maxSubArray(nums: Array[Int]): Int = {
    var maxSub = nums(0)
    for (i <- 1 until nums.length) {
      nums(i) += nums(i - 1)
      maxSub = max(nums(i), maxSub)
    }

    for (i <- 0 until nums.length - 1) {
      for (j <- (i + 1) until nums.length) {
        maxSub = max(maxSub, nums(j) - nums(i))
      }
    }
    maxSub
  }
}
