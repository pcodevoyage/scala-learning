import algo.sort._

import scala.collection.mutable.ArrayBuffer
import scala.util.Random


def makeArray(numOfElements:Int)={
  val buffer = new ArrayBuffer[Int]
  for(i <- 1 to numOfElements)
    buffer.prepend(Random.nextInt())
  buffer
}

def sort(sorter:Sorter[Int],buffer: ArrayBuffer[Int]) ={
  val t0 = System.nanoTime()
  sorter.sort(buffer)
  val t1 = System.nanoTime()

  assert(sorter.sorted(buffer))
  t1-t0
}


def timeSorter(sorter:Sorter[Int]) = {
  val b = makeArray(10000)
  sort(sorter, b)
}


val insertionSortTimeRandom =timeSorter(new InsertionSorter[Int])
val selectionSortTimeRandom =timeSorter(new SelectionSorter[Int])
val shellSortTimeRandom =timeSorter(new ShellSort[Int])
val g = makeArray(10000)
g.sorted
val insertionSortTimeSorted =sort(new InsertionSorter[Int],g)
val selectionSortTimeSorted =sort(new SelectionSorter[Int],g)
val g1 = makeArray(10000)
g1.sorted
g1.reverse
val insertionSortTimeSortedReverse =sort(new InsertionSorter[Int],g1)
val selectionSortTimeSortedReverse =sort(new SelectionSorter[Int],g1)




