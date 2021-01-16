// AddTwoNumbers
class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

object Solution {
  def addTwoNumbers(xs: ListNode, ys: ListNode): ListNode = {
    (xs, ys) match {
      case (null, _) => ys
      case (_, null) => xs
      case _ => {
        val result = (xs.x + ys.x) % 10
        val residual = (xs.x + ys.x) / 10
        (xs.next) match {
          case null => {
            residual match {
              case 0 => new ListNode(result, null)
              case _ => new ListNode(result, new ListNode(residual, null))
            }
          }
          case _ => {
            xs.next.x += residual
            new ListNode(result, addTwoNumbers(xs.next, ys.next))
          }
        }
      }
    }
  }
}
