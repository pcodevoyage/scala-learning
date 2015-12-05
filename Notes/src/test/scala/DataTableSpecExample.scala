import org.specs2.specification.Fragments
import org.specs2.{Specification,matcher}

/**
 * Created by p.samaddar on 07/12/2014.
 */
class DataTableSpecExample extends  Specification with matcher.DataTables{
  def is = "adding integers should just work in scala" ^ {
    "a" | "b" | "c" |
      2 ! 2 ! 4 |
      1 ! 1 ! 2 |> { (a, b, c) => a + b === c}
  }

}
