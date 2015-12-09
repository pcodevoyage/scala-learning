package algo.stack

import org.scalatest.{Matchers, FlatSpec}


class StackLinkedListTest extends FlatSpec with Matchers {

  "A stack" should "pop values in last in first out order" in {
    val stack = new StackLinkedList[String]()
    stack.push("first")
    stack.push("second")
    stack.pop() should be ("second")
    stack.pop() should be ("first")
  }

  it should "throw NoSuchElementException if an empty stack is popped" in {
    val stack = new StackLinkedList()
    a [NoSuchElementException] should be thrownBy {
      stack.pop()
    }
  }

  "A stack" should "return true if stack is empty" in {
    val stack = new StackLinkedList
    stack shouldBe 'isEmpty
  }
}

