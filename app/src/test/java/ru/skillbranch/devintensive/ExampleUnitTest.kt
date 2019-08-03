package ru.skillbranch.devintensive

import org.junit.Test
import ru.skillbranch.devintensive.ui.custom.CircleImageView
import ru.skillbranch.devintensive.utils.Utils
import androidx.appcompat.app.AppCompatActivity

class ExampleUnitTest {

    @Test
    fun test() {
        println(Utils.toInitials("test", "test"))
        println("${R.id.iv_avatar}")
        //var a = findViewById<CircleImageView>(R.id.iv_avatar)
    }
}