package algo

trait Stack[A]{
  def pop():A
  def push(item:A)
  def isEmpty():Boolean
}
class StackLinkedList extends Stack[String]{

  private case class Item(content:String,next:Item)

  var head:Item =null

  override def pop(): String = {
    if(head==null)
      throw new IllegalStateException()
    else {
      val content = head.content
      head= head.next
      content
    }
  }

  override def push(item: String) ={
    if(head==null){
      head = new Item(item,null)
    } else {
      val tmp = new Item(item,head)
      head=tmp
    }
  }

  override def isEmpty(): Boolean = head ==null
}
