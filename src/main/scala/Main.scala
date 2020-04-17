import com.sun.org.apache.xml.internal.serializer.utils.Utils
import fastparse.{CharIn, P, Parsed, parse}
import geny.Generator.End
import util.FastParsingLib

object Main extends App {

  println("My test is started")

  val Parsed.Success(parseResult, _) = fastparse.parse("Transactions", FastParsingLib().prefix(_))
  println("prefix")
  val Parsed.Success(parseResult1, _) = fastparse.parse(" within 15 minutes", FastParsingLib().timeAttribute(_))
  println("timeAttribute")
  val Parsed.Success(parseResult2, _) = fastparse.parse("AM", FastParsingLib().betweenTimeLHS(_))
  println("betweenLSH")
  val Parsed.Success(parseResult3, _) = fastparse.parse("PM", FastParsingLib().betweenTimeRHS(_))
  println("betweenRSH")
  val Parsed.Success(parseResult5, _) = fastparse.parse("5", FastParsingLib().Range(_))
  println("timerange")
  val Parsed.Success(parseResult4, _) = fastparse.parse(" minutes", FastParsingLib().time(_))
  println("time")
  val Parsed.Success(parseResult6, _) = fastparse.parse(" where", FastParsingLib().condition(_))
  println("condition")
  val Parsed.Success(parseResult7, _) = fastparse.parse(" txnAmount", FastParsingLib().parameters(_))
  println("parameter")
  val Parsed.Success(parseResult8, _) = fastparse.parse(" equal to", FastParsingLib().operator(_))
  println("operator")
  val Parsed.Success(parseResult12, _) = fastparse.parse("50000", FastParsingLib().Range(_))
  println("timeRange")
  val Parsed.Success(parseResult9, _) = fastparse.parse(" should have", FastParsingLib().shouldHave(_))
  println("shouldHave")
  val Parsed.Success(parseResult10, _) = fastparse.parse(" count", FastParsingLib().attribute(_))
  println("attribute")
  val Parsed.Success(parseResult13, _) = fastparse.parse(" greater than", FastParsingLib().operator(_))
  println("operator")
  val Parsed.Success(parseResult14, _) = fastparse.parse("2", FastParsingLib().Range(_))
  println("timeRange")
  val Parsed.Success(parseResult15, _) = fastparse.parse(" and", FastParsingLib().andOr(_))
  println("andOR")
  val Parsed.Success(parseResult11, _) = fastparse.parse("Transactions within 15 minutes should have count greaterThan equal to 3", FastParsingLib().rule(_))
  println("rule")

  println("My test passed")

  println(fastparse.parse("Transactions", FastParsingLib().prefix(_)))
  println(fastparse.parse(" within 15 hours", FastParsingLib().timeAttribute(_)))
  println(fastparse.parse("AM", FastParsingLib().betweenTimeLHS(_)))
  println(fastparse.parse("PM", FastParsingLib().betweenTimeRHS(_)))
  println(fastparse.parse("5", FastParsingLib().Range(_)))
  println(fastparse.parse(" minutes", FastParsingLib().time(_)))
  println(fastparse.parse(" where", FastParsingLib().condition(_)))
  println(fastparse.parse(" txnAmount", FastParsingLib().parameters(_)))
  println(fastparse.parse(" equal to", FastParsingLib().operator(_)))
  println(fastparse.parse("50000", FastParsingLib().Range(_)))
  println(fastparse.parse(" should have", FastParsingLib().shouldHave(_)))
  println(fastparse.parse(" count", FastParsingLib().attribute(_)))
  println(fastparse.parse(" greater than", FastParsingLib().operator(_)))
  println(fastparse.parse("2", FastParsingLib().Range(_)))
  println(fastparse.parse(" and", FastParsingLib().andOr(_)))
  println(fastparse.parse("Transactions within 10 minutes from different terminalId should have count greater than 2", FastParsingLib().rule(_)))
  /*
    println(fastparse.parse("Transactions between 10AM to 12PM where txnAmount greater than 5000 and txnAmount greaterThan equal to 10000 and txnAmount greaterThan equal to 10000 or cardNumber equal to 60801402 should have count greaterThan equal to 3", FastParsingLib().rule(_)))
  */
}
