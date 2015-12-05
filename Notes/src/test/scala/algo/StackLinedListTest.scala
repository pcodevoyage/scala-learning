package algo

import org.scalatest.{Matchers, FlatSpec}


class StackLinedListTest extends FlatSpec with Matchers {

  "A stack" should "pop values in last in first out order" in {
    val stack = new StackLinkedList()
    stack.push("first")
    stack.push("second")
    stack.pop() should be ("second")
    stack.pop() should be ("first")
  }
}
