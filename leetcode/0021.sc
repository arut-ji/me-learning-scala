// Merge Two Sorted List

class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

object Solution {
  def mergeTwoLists(xs: ListNode, ys: ListNode): ListNode = (xs, ys) match {
    case (null, null) => null
    case (null, ys)   => ys
    case (xs, null)   => xs
    case _ => {
      if (xs.x <= ys.x) new ListNode(xs.x, mergeTwoLists(xs.next, ys))
      else new ListNode(ys.x, mergeTwoLists(xs, ys.next))
    }
  }
}
