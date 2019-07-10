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

    @Test
    fun formatTest() {
        val messageDate = Date()
        val currDate = Date()

        //var a: Long = (Date().time - Date().add(100, TimeUnits.MINUTE).time) / 1000
        var n: Int = -370
        while (n <= 367) {
            messageDate.time = currDate.time
            n++
            println(messageDate.add(n, TimeUnits.DAY).humanizeDiff(currDate))
        }
    }
    @Test
    fun trimtrim(){
        var a:String
        a = "123"
        print(a.truncate(3))

    }

    @Test
    fun truncateTest() {
        /* skillBranch tests */
        assertEquals("Bender Bending R...", "Bender Bending Rodriguez — дословно «Сгибальщик Сгибающий Родригес»".truncate())
        assertEquals("Bender Bending...", "Bender Bending Rodriguez — дословно «Сгибальщик Сгибающий Родригес»".truncate(15))
        assertEquals("A", "A     ".truncate(3))


        assertEquals("too lo...", "   too long line with lots of spaces before".truncate(6))
        assertEquals("too short", "too short".truncate(20))
        assertEquals("12345", "12345".truncate(5))
        assertEquals("1234...", "12345".truncate(4))
        assertEquals("12345", "12345  ".truncate(5))
        assertEquals("tab", "tab    ".truncate(5))
        assertEquals("dots......", "dots... a lot".truncate(7))
        assertEquals("abc", "abc    ".truncate(15))
        assertEquals("123456...", "123456789".truncate(6))
        assertEquals("123456789", "123456789".truncate(9))
        assertEquals("Bender Bending R...", "Bender Bending Rodriguez — дословно «Сгибальщик Сгибающий Родригес»".truncate())
        assertEquals("Bender Bending...", "Bender Bending Rodriguez — дословно «Сгибальщик Сгибающий Родригес»".truncate(15))
        assertEquals("1", "1     ".truncate(3))
    }

}






