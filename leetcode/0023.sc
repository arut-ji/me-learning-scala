// Merge k sorted lists

import scala.collection.mutable.PriorityQueue

object Solution {
  def addNode(a: ListNode, item: Int): ListNode = a match {
    case null => new ListNode(item, null)
    case _ => {
      new ListNode(item, a)
    }
  }

  def toList(ln: ListNode): List[Int] = ln match {
    case null => Nil
    case _ => {
      List(ln.x) ::: toList(ln.next)
    }
  }

  def toListNode(lists: List[Int]): ListNode = lists match {
    case Nil => null
    case x :: xs => {
      new ListNode(x, toListNode(xs))
    }
  }

  def mergeKLists(lists: Array[ListNode]): ListNode = {
    var pq = new PriorityQueue[ListNode]()(Ordering.by(x => -x.x))
    lists.foreach(node => if (node != null) pq.enqueue(node))
    var result: ListNode = null
    while (!pq.isEmpty) {
      var curr = pq.dequeue()
      result = addNode(result, curr.x)
      if (curr.next != null) {
        pq.enqueue(curr.next)
      }
    }
    toListNode(toList(result).reverse)
  }
}
