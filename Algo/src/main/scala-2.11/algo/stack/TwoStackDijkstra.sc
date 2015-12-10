import algo.stack.StackLinkedList
//Two stack Dijkstra's algo to evaluate an expression
// value    = push onto value stack
// (        = ignore
// operator = push on to operator stack
// )        = pop from operator stack and pop two values. Apply operation and add result
//            back to to the value stack
object  v {
  val exp = "(2*(1+(2+3)))"
  val valueStack = new StackLinkedList[Int]
  val operatorStack = new StackLinkedList[String]
  def compute = {
    operatorStack.pop() match {
      case "+" => valueStack.push( valueStack.pop() + valueStack.pop())
      case "*" => valueStack.push( valueStack.pop() * valueStack.pop())
      case _ => ""

    }

  }
  for (c <- exp.toList.map(_.toString)) c match {
    case x if x.matches("[0-9]") => valueStack.push(Integer.parseInt(x))
    case m if m.matches("\\+|\\*") => operatorStack.push(m)
    case ")" => compute
    case _ => ""
  }
//  for (c <-operatorStack) println(c)
//  for (c <-valueStack) println(c)

  println(exp + " = "+valueStack.pop())

}
