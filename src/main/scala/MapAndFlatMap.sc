object MapAndFlatMap{

  val s:String = "this is great"

  //With map you are taking a list of characters and turning it
  //into a list of strings. That's the result you see.
  //A map never changes the length of a list – the list of strings has
  // as many elements as the original string has characters.
  s map (c => c + "-")

  //With flatMap you are taking a list of characters and turning it into
  // a list of strings and then you mush those strings together into a single
  // string again. flatMap is useful when you want to turn one element in a
  // list into multiple elements, without creating a list of lists.
  // (This of course also means that the resulting list can have any length,
  // including 0 – this is not possible with map unless you start out with the empty list.)
  //
  // flapMap = map then flatten
  s flatMap (c=>c + "-")


  val couples = List(List("kim", "al"), List("julia", "terry"))

  val people = couples.flatten

  val mapC =couples map ( c => "add" :: c)

  val mapCthenFlatten =couples map ( c => "add" :: c) flatten

  val flatMapC=couples flatMap( c=> "add" :: c)

  val isFlatMapSameAsMapThenFatten = flatMapC == mapCthenFlatten

  couples flatMap( c=> "add" :: c) flatten
}