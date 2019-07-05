package ru.skillbranch.devintensive

import org.junit.Test

import org.junit.Assert.*
import ru.skillbranch.devintensive.extensions.TimeUnits
import ru.skillbranch.devintensive.extensions.add
import ru.skillbranch.devintensive.extensions.format
import ru.skillbranch.devintensive.extensions.toUserView
//import ru.skillbranch.devintensive.models.BaseMessage
import ru.skillbranch.devintensive.models.Chat
import ru.skillbranch.devintensive.models.ImageMessage
import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.utils.Utils
import java.util.*
import kotlin.concurrent.timer

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
    fun tetete(){
        val userRen = User.makeUser("Мак Сим")
        println(userRen)
        val viewww = userRen.toUserView()
        println("NNNNNN" + viewww)
    }
    @Test
fun tetest ()
    {
        val User1 = User (id="1")
        val User2 = User (id="12",firstName =  "piska", lastName = "iav")
        val User3 = User (id="13", firstName = "pipirka", lastName = "vodka")
        User1.pintMe()
        User2.pintMe()
        User3.pintMe()
        print("$User1,\n $User2, \n $User3")
    }
    @Test
    fun imgmsg() {
    var imggmsg :ImageMessage
    }


}





