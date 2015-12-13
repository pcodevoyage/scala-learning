package algo.stack

trait Stack[A]{
  def pop():A
  def push(item:A)
  def isEmpty():Boolean
}

class StackLinkedList[A] extends Stack[A] with Iterable[A]{

  private case class Item(content:A,next:Item)

  private var headElement:Item =null

  override def pop(): A = headElement match {
    case null => throw new NoSuchElementException
    case _ => {
      val content = headElement.content
      headElement= headElement.next
      content
    }
  }

  override def push(item: A):Unit = headElement match {
    case null => headElement = new Item(item,null)
    case _ => {
      val tmp = new Item(item,headElement)
      headElement=tmp
    }
  }

  override def isEmpty(): Boolean = headElement ==null

  override def iterator: Iterator[A] = new StackIterator(this)
}
class StackIterator[A](stackLinkedList: Stack[A]) extends Iterator[A]{
  override def hasNext: Boolean = !stackLinkedList.isEmpty()
  override def next(): A =stackLinkedList.pop()
}

class StackArray[A:Manifest] extends Stack[A] with Iterable[A]{

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

  override def iterator: Iterator[A] = new StackIterator[A](this)
}