package helper

class PreferedLang(val lang:String)

object GreetClass{

  def greet(msg:String)(implicit pref:PreferedLang): String ={

    msg + " "+pref.lang
  }

}