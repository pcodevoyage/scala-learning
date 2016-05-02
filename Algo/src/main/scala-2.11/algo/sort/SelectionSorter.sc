import algo.sort.{InsertionSorter, SelectionSorter}

import scala.collection.mutable.ArrayBuffer

val sorter = new SelectionSorter[Int]
val buffer = ArrayBuffer(4,6,1,3)
sorter.sort(buffer)
buffer

assert(sorter.sorted(buffer))


val buffer1 = ArrayBuffer(4,6,1)
val insertionSorter = new InsertionSorter[Int]
insertionSorter.sort(buffer1)
buffer1
assert(insertionSorter.sorted(buffer1))

