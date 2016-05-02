package algo.sort

import scala.collection.mutable

abstract class Sorter[T <% Ordered[T]] {

  // algorithm provided by subclasses
  def sort(buffer : mutable.Buffer[T]) : Unit

  // check if the buffer is sorted
  def sorted(buffer : mutable.Buffer[T]) = buffer.isEmpty || buffer.view.zip(buffer.tail).forall { t => t._2 > t._1 }

  // swap elements in buffer
  def swap(buffer : mutable.Buffer[T], destination:Int, source:Int) {
    val temp = buffer(destination)
    buffer(destination) = buffer(source)
    buffer(source) = temp
  }
}


//Selection sort
//----------------
//Moving forward check if the min number on right is lower than the pointer value. If it is swap.
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



//Insertion Sort
//-----------------
//As the pointer moves forward the elements on the left are sorted.
//
//Using the pointer value moving left find the first element that is bigger than the value at hand and swap with it.
class InsertionSorter[T<% Ordered[T]] extends  Sorter[T]{
  def sortWithGap(buffer : mutable.Buffer[T], gap:Int): Unit ={
    for (i <- 0 until buffer.length) {
      for ( k <- i until 0 by -gap){
        if ((k-gap) > -1 && buffer(k)<buffer(k-gap)) {
          swap(buffer, k - 1, k)
        }
      }
    }
  }
  def sort(buffer : mutable.Buffer[T]) : Unit = {
   sortWithGap(buffer,1)
  }
}


//Shell Sort
//-----------------
//Same as insertion sort except shell sort can use n as interval
class ShellSort[T<% Ordered[T]] extends InsertionSorter[T]{
  override def sort(buffer : mutable.Buffer[T]) : Unit = {

    var maxGap:Int = 1
    while (maxGap < buffer.length/3 ) {
      maxGap = maxGap*3 +1
    }

    while (maxGap > 0){
      sortWithGap(buffer,maxGap)
      maxGap = maxGap/3
    }

  }
}