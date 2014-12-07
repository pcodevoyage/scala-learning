package com.test
import org.specs2.mutable._

/**
 * Created by p.samaddar on 04/12/2014.
 */
class HelloWorldSpec extends Specification{

  "This 'Hellow world' string" should{
    "container 11 characters" in {
      "Hello world" must have size(11)
    }
  }

  "my example on string" ! e1

  def e1 = {
    "hello" must have size(10)
    "hello" must startWith("hel")
  }

  "my example on string check 2 things" ! e2

  def e2 = "hello67890" must have size(10) and startWith("hel")

}

