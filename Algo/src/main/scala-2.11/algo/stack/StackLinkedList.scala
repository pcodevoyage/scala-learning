package algo.stack

trait Stack[A]{
  def pop():A
  def push(item:A)
  def isEmpty():Boolean
}
class StackLinkedList[A] extends Stack[A]{

  private case class Item(content:A,next:Item)

  private var head:Item =null

  override def pop(): A = {
    if(head==null)
      throw new NoSuchElementException()
    else {
      val content = head.content
      head= head.next
      content
    }
  }

  override def push(item: A):Unit ={
    if(head==null){
      head = new Item(item,null)
    } else {
      val tmp = new Item(item,head)
      head=tmp
    }
  }

  override def isEmpty(): Boolean = head ==null
}


class StackArray[A:Manifest] extends Stack[A] {

  var array = new Array[A](5)
  var nextEmptyHead = 0;

  override def pop(): A = {
    if(nextEmptyHead==0)
      throw new NoSuchElementException
    val tmp = array(nextEmptyHead-1)
    nextEmptyHead = nextEmptyHead -1

    tmp
  }
  private def reduceArrayIfQuaterfull={
    if(nextEmptyHead == array.length/4){
      changeArraySize(array.length/2)
    }
  }

  private def changeArraySize(size:Int): Unit = {
    val tmpArray = new Array[A](size)
    array.copyToArray(tmpArray)
    array = tmpArray
  }

  override def push(item: A): Unit = {
    array(nextEmptyHead) = item
    nextEmptyHead=nextEmptyHead+1
    doubleArrayIfFilled
  }

  private def doubleArrayIfFilled: Unit = {
    if (nextEmptyHead == array.length) {
      changeArraySize(array.length*2)
    }
  }
  override def isEmpty(): Boolean = nextEmptyHead==0
}