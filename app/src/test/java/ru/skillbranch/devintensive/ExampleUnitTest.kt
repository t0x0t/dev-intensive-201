package ru.skillbranch.devintensive

import org.junit.Test

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
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
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


    /*println(Utils.parseFullName("john doe"))
    println(Utils.parseFullName(" doe"))
    println(Utils.parseFullName("john "))
    println(Utils.parseFullName("john"))
    println(Utils.parseFullName(null))
    println(Utils.parseFullName(""))
    println(Utils.parseFullName("   "))
    println(Utils.toInitials("John", null))
    println(Utils.toInitials(null, null)) //null
    println(Utils.toInitials(" ", ""))
    println(Utils.toInitials("", "test"))*/
    @Test
    fun formatTest() {
        val messageDate = Date()
        val currDate = Date()

        //var a: Long = (Date().time - Date().add(100, TimeUnits.MINUTE).time) / 1000
        var n: Int = -500
        while (n <= 500) {
            messageDate.time = currDate.time
            n++
            println(messageDate.add(n, TimeUnits.HOUR).humanizeDiff(currDate))
        }
    }

    @Test
    fun humanizeDiffTest() {
        val messageDate = Date()
        val currDate = Date()

        assertEquals("только что", messageDate.add(-1, TimeUnits.SECOND).humanizeDiff(currDate))
        messageDate.time = currDate.time
        assertEquals("только что", messageDate.add(1, TimeUnits.SECOND).humanizeDiff(currDate))
        messageDate.time = currDate.time
        assertEquals("несколько секунд назад", messageDate.add(-2, TimeUnits.SECOND).humanizeDiff(currDate))
        messageDate.time = currDate.time
        assertEquals("через несколько секунд", messageDate.add(2, TimeUnits.SECOND).humanizeDiff(currDate))
        messageDate.time = currDate.time
        assertEquals("несколько секунд назад", messageDate.add(-45, TimeUnits.SECOND).humanizeDiff(currDate))
        messageDate.time = currDate.time
        assertEquals("через несколько секунд", messageDate.add(45, TimeUnits.SECOND).humanizeDiff(currDate))
        messageDate.time = currDate.time
        assertEquals("минуту назад", messageDate.add(-46, TimeUnits.SECOND).humanizeDiff(currDate))
        messageDate.time = currDate.time
        assertEquals("через минуту", messageDate.add(46, TimeUnits.SECOND).humanizeDiff(currDate))
        messageDate.time = currDate.time
        assertEquals("минуту назад", messageDate.add(-75, TimeUnits.SECOND).humanizeDiff(currDate))
        messageDate.time = currDate.time
        assertEquals("через минуту", messageDate.add(75, TimeUnits.SECOND).humanizeDiff(currDate))

        messageDate.time = currDate.time
        assertEquals("через 1 минуту", messageDate.add(76, TimeUnits.SECOND).humanizeDiff(currDate))
        messageDate.time = currDate.time
        assertEquals("через 2 минуты", messageDate.add(2, TimeUnits.MINUTE).humanizeDiff(currDate))
        messageDate.time = currDate.time
        assertEquals("3 минуты назад", messageDate.add(-3, TimeUnits.MINUTE).humanizeDiff(currDate))
        messageDate.time = currDate.time
        assertEquals("45 минут назад", messageDate.add(-45, TimeUnits.MINUTE).humanizeDiff(currDate))
        messageDate.time = currDate.time
        assertEquals("через 45 минут", messageDate.add(45, TimeUnits.MINUTE).humanizeDiff(currDate))
        messageDate.time = currDate.time
        assertEquals("час назад", messageDate.add(-46, TimeUnits.MINUTE).humanizeDiff(currDate))
        messageDate.time = currDate.time
        assertEquals("через час", messageDate.add(46, TimeUnits.MINUTE).humanizeDiff(currDate))
        messageDate.time = currDate.time
        assertEquals("час назад", messageDate.add(-75, TimeUnits.MINUTE).humanizeDiff(currDate))
        messageDate.time = currDate.time
        assertEquals("через час", messageDate.add(75, TimeUnits.MINUTE).humanizeDiff(currDate))
        messageDate.time = currDate.time
        assertEquals("1 час назад", messageDate.add(-76, TimeUnits.MINUTE).humanizeDiff(currDate))
        messageDate.time = currDate.time
        assertEquals("через 1 час", messageDate.add(76, TimeUnits.MINUTE).humanizeDiff(currDate))
        messageDate.time = currDate.time
        assertEquals("4 часа назад", messageDate.add(-4, TimeUnits.HOUR).humanizeDiff(currDate))
        messageDate.time = currDate.time
        assertEquals("через 4 часа", messageDate.add(4, TimeUnits.HOUR).humanizeDiff(currDate))
        messageDate.time = currDate.time
        assertEquals("6 часов назад", messageDate.add(-6, TimeUnits.HOUR).humanizeDiff(currDate))
        messageDate.time = currDate.time
        assertEquals("через 6 часов", messageDate.add(6, TimeUnits.HOUR).humanizeDiff(currDate))
        messageDate.time = currDate.time
        assertEquals("11 часов назад", messageDate.add(-11, TimeUnits.HOUR).humanizeDiff(currDate))
        messageDate.time = currDate.time
        assertEquals("через 11 часов", messageDate.add(11, TimeUnits.HOUR).humanizeDiff(currDate))
        messageDate.time = currDate.time
        assertEquals("22 часа назад", messageDate.add(-22, TimeUnits.HOUR).humanizeDiff(currDate))
        messageDate.time = currDate.time
        assertEquals("через 22 часа", messageDate.add(22, TimeUnits.HOUR).humanizeDiff(currDate))
        messageDate.time = currDate.time
        /*
        assertEquals("день назад", messageDate.add(-23, TimeUnits.HOUR).humanizeDiff(currDate))
        messageDate.time = currDate.time
        assertEquals("через день", messageDate.add(23, TimeUnits.HOUR).humanizeDiff(currDate))
        messageDate.time = currDate.time
        assertEquals("день назад", messageDate.add(-26, TimeUnits.HOUR).humanizeDiff(currDate))
        messageDate.time = currDate.time
        assertEquals("через день", messageDate.add(26, TimeUnits.HOUR).humanizeDiff(currDate))
        messageDate.time = currDate.time
        assertEquals("1 день назад", messageDate.add(-27, TimeUnits.HOUR).humanizeDiff(currDate))
        messageDate.time = currDate.time
        assertEquals("через 1 день", messageDate.add(27, TimeUnits.HOUR).humanizeDiff(currDate))
        messageDate.time = currDate.time
        assertEquals("12 дней назад", messageDate.add(-12, TimeUnits.DAY).humanizeDiff(currDate))
        messageDate.time = currDate.time
        assertEquals("через 12 дней", messageDate.add(12, TimeUnits.DAY).humanizeDiff(currDate))
        messageDate.time = currDate.time
        assertEquals("112 дней назад", messageDate.add(-112, TimeUnits.DAY).humanizeDiff(currDate))
        messageDate.time = currDate.time
        assertEquals("через 112 дней", messageDate.add(112, TimeUnits.DAY).humanizeDiff(currDate))
        messageDate.time = currDate.time
        assertEquals("360 дней назад", messageDate.add(-360, TimeUnits.DAY).humanizeDiff(currDate))
        messageDate.time = currDate.time
        assertEquals("через 360 дней", messageDate.add(360, TimeUnits.DAY).humanizeDiff(currDate))
        messageDate.time = currDate.time
        assertEquals("более года назад", messageDate.add(-361, TimeUnits.DAY).humanizeDiff(currDate))
        messageDate.time = currDate.time
        assertEquals("более чем через год", messageDate.add(361, TimeUnits.DAY).humanizeDiff(currDate))
        messageDate.time = currDate.time
        assertEquals("более года назад", messageDate.add(-12345, TimeUnits.DAY).humanizeDiff(currDate))
        messageDate.time = currDate.time
        assertEquals("более чем через год", messageDate.add(12345, TimeUnits.DAY).humanizeDiff(currDate))*/
    }
}






