package Reactive.Week2

/**
 * Created on 30/04/2015.
 */
class BankAccount extends Publisher{

  private var balance:Int = 0

  def currentBalance = balance

  def debit(i:Int) = {
    balance = balance+ i
    publish()
  }

  def credit(i:Int) ={
    if(i<=balance){
      balance = balance-i
      publish()
    }else{
      throw new IllegalArgumentException("cannot deduct")
    }
  }
}
