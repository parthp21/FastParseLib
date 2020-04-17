package util


import fastparse.{CharIn, P, _}
import fastparse._
import NoWhitespace._

case class FastParsingLib() {


  def prefix [_: P] = P("Transactions").!

  def timeAttribute [_: P] = P(" within" ~ " " ~ Range  ~ time | " between " ~ Range ~ (":" ~ Range).? ~ " " ~ betweenTimeLHS ~ " to " ~ Range ~ (":" ~ Range).? ~ " " ~betweenTimeRHS ).!

  def betweenTimeLHS [_: P] = P("AM" | "PM").!

  def betweenTimeRHS [_: P] = P("AM" | "PM")

  def time [_: P] = P(" minutes" | " hours" | " days"  ).!

  def Range [_: P] = P(CharIn("0-9").rep(1))

  def level [_: P] = P("high" | "medium" | "low").!

  def condition [_: P] = P(" where" | " from").!

  def source [_: P] = P(" same" | " different").!

  def parameters [_: P] = P(" txnAmount" | " terminalId" | " bin" | " cardNumber" | " customerRiskScore").!

  def operator [_: P] = P(" greater than" | " lesser than" | " greaterThan equal to" | " lesserThan equal to" | " equal to" | " not equal to" ).!

  def shouldHave [_: P] = P(" should have").!

  def attribute [_: P] = P( " amount" | " count" | " unsuccessfulPinChangeCount" | " chargeBackTxnsCount").!

  def andOr [_: P] = P(" and" | " or")

  def extra [_: P] = P(andOr ~ parameters ~ operator ~ " " ~ Range)

  def limit [_: P] = P("% of dailyCardLimit" | "% of dailyTxnLimit")


  def rule [_: P] = P(prefix ~ timeAttribute ~ condition.? ~ source.? ~ parameters.? ~ (operator ~ " " ~ (Range | level) ).? ~( extra).rep(1).? ~ shouldHave ~ attribute ~ operator ~ " " ~ Range ~ limit.? ).!

}
