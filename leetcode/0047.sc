// Permutations II

object Solution {
  def permuteUnique(nums: Array[Int]): List[List[Int]] = {
    _permute(nums, Array.fill(nums.length)(false), Vector()).toList
  }

  def _permute(
      nums: Array[Int],
      used: Array[Boolean],
      curr: Vector[Int]
  ): Set[List[Int]] = {
    if (curr.length == nums.length) {
      return Set(curr.toList)
    }
    var result = Set[List[Int]]()
    for (i <- 0 until nums.length) {
      if (!used(i)) {
        used(i) = true
        result = result ++ _permute(nums, used, Vector(nums(i)) ++ curr)
        used(i) = false
      }
    }
    return result
  }
}
