// Add two numbers

class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

val as = new ListNode(9, new ListNode(9, new ListNode(9, null)))
val bs = new ListNode(9, null)
object Solution {
  def combine(xs: ListNode, ys: ListNode): ListNode = {
    (xs, ys) match {
      case (null, _) => ys
      case (_, null) => xs
      case _         => new ListNode(xs.x + ys.x, addTwoNumbers(xs.next, ys.next))
    }
  }
  def propagateCarry(carry: Int, xs: ListNode): ListNode = {
    (carry, xs) match {
      case (0, null)     => null
      case (carry, null) => new ListNode(carry, null)
      case _ => {
        val result = xs.x + carry
        new ListNode(
          result % 10,
          propagateCarry(result / 10, xs.next)
        )
      }
    }
  }
  def addTwoNumbers(xs: ListNode, ys: ListNode): ListNode = {
    propagateCarry(0, combine(xs, ys))
  }
}
