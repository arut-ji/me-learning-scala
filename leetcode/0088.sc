// Merge Sorted Array

object Solution {
  def merge(as: Array[Int], m: Int, bs: Array[Int], n: Int): Unit = {
    if (n <= 0) return

    if (m > 0 && as(m - 1) > bs(n - 1)) {
      as(m + n - 1) = as(m - 1)
      merge(as, m - 1, bs, n)
    } else {
      as(m + n - 1) = bs(n - 1)
      merge(as, m, bs, n - 1)
    }
  }
}