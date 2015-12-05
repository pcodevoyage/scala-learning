trait Foo {
  def getFoo():String
}

trait FooAble extends Foo{
  def getFoo():String = "This is fooable"
}

class Bar{
  this : Foo=>

  def getBar():String = "This is bar with "+getFoo()
}


val testObj = new Bar with FooAble

testObj.getBar()