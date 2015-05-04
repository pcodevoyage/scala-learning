import org.scalacheck.Properties
import org.scalacheck.Prop.forAll

/**
 * Created on 17/04/2015.
 */
object StringSpecification extends Properties("String"){

  property("startWith") = forAll { (a:String,b:String) =>
    (a+b).startsWith(a+"sa")
  }
}
