object EitherExample{

  //Use this when the answer can be two different unrelated things

  def divfunc(num:Int,den:Int) :Either[Int,String] ={
    if (den ==0 ) Right("This is not valid so says Dr Math")
    else Left(num/den)
  }

  def funcPerformer(num:Int,den:Int) = divfunc(num,den) match  {
    case Right(s) => "Wrong. Message :" + s
    case Left(i) => "You are a star. Your Answer is :" +i
  }

  funcPerformer(9,3)
  funcPerformer(9,0)
}