object ExtractorSecond {


  def f(e:Employee) = e match {
    case Engineer(name,salary) => "Hello " + name + " your salary is " + salary
    case Manager(name,_,_) => "Welcome back, dear " + name
    case employee @ Ceo() => "Hello CEO"
  }

  val e: Employee = new Engineer("Joe",4500.45f)
  f(e)

  val e1: Manager = new Manager("Joe' Manager",45000.45f,"Manage stuff")
  f(e1)

  val e2: Ceo = new Ceo("Joe' CEO",40500.45f)
  f(e2)
}

trait Employee{
  def name :String
  def salary :Float
}


class Engineer(val name:String,val salary:Float) extends Employee
class Manager(val name:String,val salary:Float,val role:String) extends Employee
class Ceo(val name:String,val salary:Float) extends Employee

object Engineer{
  def unapply(employee:Engineer):Option[(String,Float)] ={
    Some((employee.name,employee.salary))
  }
}

object Manager{
  def unapply(employee:Manager):Option[(String,Float,String)] ={
    Some((employee.name,employee.salary,employee.role))
  }
}

object Ceo{
  def unapply(employee:Ceo):Boolean ={
    employee.salary > 10000
  }
}