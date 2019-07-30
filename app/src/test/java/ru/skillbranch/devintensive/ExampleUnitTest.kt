package ru.skillbranch.devintensive


import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.skillbranch.devintensive.models.Bender
import android.support.*
import org.junit.Assert.*

import org.junit.Assert.*
import ru.skillbranch.devintensive.extensions.*
import ru.skillbranch.devintensive.models.BaseMessage
//import ru.skillbranch.devintensive.models.BaseMessage
import ru.skillbranch.devintensive.models.Chat
import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.models.User.Builder
import java.sql.Time
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun wer12345dfg() {
        var x = 100
        var y = 25
        x = y.also { y = x }
        println("$x x")
        println("$y y")


    }

    /*@Test
    fun Test() {
        print("""bolshie siski""")
    }
var Pipka:User=User.makeUser("BOl Shoi")
    fun ttt() {
       print(User.makeUser("Kool Boot").toString())
    }
  @Test
  fun pisla(){
      //print(User.Factory.makeUser("Test TTT"))
      val user1 = User.makeUser("asd")
      val chat1 = Chat()
      BaseMessage.makeMessage(from = user1, date = Date(), type = "olol", payload = "siski", chat = chat1)
      print(Utils.parseFullName(null))
      print(Utils.parseFullName(""))
      print(Utils.parseFullName("  "))
      print(Utils.parseFullName("JOfg"))
  }*/
    @Test
    fun Test500() {
        val user53 = User.makeUser("Loop Pllo")
        val user2 = user53.copy(lastVisit = Date(), isOnline = true)
        println(user53)
        println(user2)
    }

    @Test
    fun tetete() {
        val userRen = User.makeUser("Мак Сим")
        println(userRen)
        val viewww = userRen.toUserView()
        println("NNNNNN" + viewww)
    }

    @Test
    fun tetest() {
        val User1 = User(id = "1")
        val User2 = User(id = "12", firstName = "piska", lastName = "iav")
        val User3 = User(id = "13", firstName = "pipirka", lastName = "vodka")
        User1.pintMe()
        User2.pintMe()
        User3.pintMe()
        print("$User1,\n $User2, \n $User3")
    }

    @Test
    fun imgtest() {
        val user100 = User.makeUser("Котлина Кусок")
        val txtmsg = BaseMessage.makeMessage(
            user100,
            Chat(id = "0"),
            date = Date().add(5, TimeUnits.HOUR),
            payload = "any text",
            type = "text"
        )
        val imgmsg =
            BaseMessage.makeMessage(user100, Chat(id = "0"), date = Date(), payload = "any text", type = "image")
        println(txtmsg.formatMessage())
        print(imgmsg.formatMessage())
    }

    @Test
    fun formatTest() {
        val messageDate = Date()
        val currDate = Date()

        //var a: Long = (Date().time - Date().add(100, TimeUnits.MINUTE).time) / 1000
        var n: Int = -370
        while (n <= 367) {
            messageDate.time = currDate.time
            n++
            println(messageDate.add(n, TimeUnits.MINUTE).humanizeDiff(currDate))
        }
    }
    @Test
    fun trimtrim(){
        var numberString:String = "24"
        var lastNumber: Int = numberString.last().toString().toInt()
        print(lastNumber)

    }
@Test

fun testPlu(){
    var lastNumber:Int = "24".last().toString().toInt()
    println(lastNumber)
    println(TimeUnits.SECOND.plural(0))
    println(TimeUnits.SECOND.plural(1))
    println(TimeUnits.SECOND.plural(2))
    println(TimeUnits.SECOND.plural(7))
    println(TimeUnits.SECOND.plural(14))
    println(TimeUnits.SECOND.plural(24))
    println(TimeUnits.SECOND.plural(102))
    println(TimeUnits.SECOND.plural(112))
    println(TimeUnits.SECOND.plural(122))
    println(TimeUnits.SECOND.plural(311))


}

    @Test
fun test_plural() {
    assertEquals("0 секунд", TimeUnits.SECOND.plural(0))
    assertEquals("1 секунду", TimeUnits.SECOND.plural(1))
    assertEquals("2 секунды", TimeUnits.SECOND.plural(2))
    assertEquals("7 секунд", TimeUnits.SECOND.plural(7))
    assertEquals("14 секунд", TimeUnits.SECOND.plural(14))
    assertEquals("24 секунды", TimeUnits.SECOND.plural(24))
    assertEquals("102 секунды", TimeUnits.SECOND.plural(102))
    assertEquals("112 секунд", TimeUnits.SECOND.plural(112))
    assertEquals("122 секунды", TimeUnits.SECOND.plural(122))
    assertEquals("311 секунд", TimeUnits.SECOND.plural(311))

    assertEquals("0 минут", TimeUnits.MINUTE.plural(0))
    assertEquals("1 минуту", TimeUnits.MINUTE.plural(1))
    assertEquals("2 минуты", TimeUnits.MINUTE.plural(2))
    assertEquals("7 минут", TimeUnits.MINUTE.plural(7))
    assertEquals("14 минут", TimeUnits.MINUTE.plural(14))
    assertEquals("24 минуты", TimeUnits.MINUTE.plural(24))
    assertEquals("102 минуты", TimeUnits.MINUTE.plural(102))
    assertEquals("112 минут", TimeUnits.MINUTE.plural(112))
    assertEquals("122 минуты", TimeUnits.MINUTE.plural(122))
    assertEquals("311 минут", TimeUnits.MINUTE.plural(311))

    assertEquals("0 часов", TimeUnits.HOUR.plural(0))
    assertEquals("1 час", TimeUnits.HOUR.plural(1))
    assertEquals("2 часа", TimeUnits.HOUR.plural(2))
    assertEquals("7 часов", TimeUnits.HOUR.plural(7))
    assertEquals("14 часов", TimeUnits.HOUR.plural(14))
    assertEquals("24 часа", TimeUnits.HOUR.plural(24))
    assertEquals("102 часа", TimeUnits.HOUR.plural(102))
    assertEquals("112 часов", TimeUnits.HOUR.plural(112))
    assertEquals("122 часа", TimeUnits.HOUR.plural(122))
    assertEquals("311 часов", TimeUnits.HOUR.plural(311))

    assertEquals("0 дней", TimeUnits.DAY.plural(0))
    assertEquals("1 день", TimeUnits.DAY.plural(1))
    assertEquals("2 дня", TimeUnits.DAY.plural(2))
    assertEquals("7 дней", TimeUnits.DAY.plural(7))
    assertEquals("14 дней", TimeUnits.DAY.plural(14))
    assertEquals("24 дня", TimeUnits.DAY.plural(24))
    assertEquals("102 дня", TimeUnits.DAY.plural(102))
    assertEquals("112 дней", TimeUnits.DAY.plural(112))
    assertEquals("122 дня", TimeUnits.DAY.plural(122))
    assertEquals("311 дней", TimeUnits.DAY.plural(311))
    assertEquals("1234 дня", TimeUnits.DAY.plural(1234))
}

}


