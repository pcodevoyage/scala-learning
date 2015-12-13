package algo.sort

import scala.collection.mutable

abstract class Sorter[T <% Ordered[T]] {

  // algorithm provided by subclasses
  def sort(buffer : mutable.Buffer[T]) : Unit

  // check if the buffer is sorted
  def sorted(buffer : mutable.Buffer[T]) = buffer.isEmpty || buffer.view.zip(buffer.tail).forall { t => t._2 > t._1 }

  // swap elements in buffer
  def swap(buffer : mutable.Buffer[T], i:Int, j:Int) {
    val temp = buffer(i)
    buffer(i) = buffer(j)
    buffer(j) = temp
  }
}

class SelectionSorter[T <% Ordered[T]] extends Sorter[T] {
  def sort(buffer : mutable.Buffer[T]) : Unit = {
    for (i <- 0 until buffer.length) {
      var min = i
      for (j <- i until buffer.length) {
        if (buffer(j) < buffer(min))
          min = j
      }
      swap(buffer, i, min)
    }
  }
}


class InsertionSorter[T<% Ordered[T]] extends  Sorter[T]{
  def sort(buffer : mutable.Buffer[T]) : Unit = {
    for (i <- 0 until buffer.length) {
      for ( k <- i until 0 by -1){
        if (buffer(k)<buffer(k-1)) {
          swap(buffer, k - 1, k)
        }
      }
    }
  }
}