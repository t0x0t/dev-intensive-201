package ru.skillbranch.devintensive.extensions

import java.lang.IllegalStateException
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

val SECOND = 1000L
val MINUTE = 60 * SECOND
val HOUR = 60 * MINUTE
val DAY = 24 * HOUR

fun Date.format(pattern:String="HH:mm:ss dd.MM.yy"):String{
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value: Int, units: TimeUnits = TimeUnits.SECOND):Date{
    var time = this.time
    time +=when (units){
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }
    this.time = time
    return this
}
//[0-1](2-45](46 - 75] (76 - 45](46 - 75](76-22](23-26](27-360](361....
fun Date.humanizeDiff(date: Date = Date()):String {
    var toSeconds = (this.time - date.time)/1000 //когда результат положительный -  было в прошлом (toSeconds-пол. число)
    var name:String = " "

if (toSeconds in -75..75){

    when (toSeconds){
        in -1..1 -> return "только что"
        in 2..45 -> return "через несколько секунд"
        in -45 ..-2 -> return "несколько секунд назад"
        in -75..-46 -> return "минуту назад"
        in 46..75 -> return "через минуту"
    }
}

    if (toSeconds in -2759..2759){
        toSeconds /= 60
        var toMinutes:Int = toSeconds.toInt()
        if (toMinutes>=-20 || toMinutes<=20)
        {

            when(toMinutes){
                in -20..-5 -> name = "минут"
                in -4..-2 -> name = "минуты"
                in -1..1 -> name = "минуту"
                in 2..4 -> name = "минуты"
                in 5..20 -> name = "минут"
            }
        }
        if (toMinutes in -45..-21 || toMinutes in 21..45)
        {
            val lastCharMinutes:Char = toMinutes.toString().last()
            val lastNumMinutes:Int = lastCharMinutes.toString().toInt()

            when(lastCharMinutes.toString().toInt()){
                1 -> name = "минуту"
                in 2..4 -> name = "минуты"
                else -> name = "минут"
            }
        }
        if (toMinutes>0) {return "через " + toMinutes.toString() + " " + name}
        else {return (toMinutes.toString().drop(1) + " " + name + " назад")}

    }

if (toSeconds in -4559..4559){
        if(toSeconds>0){return "через час"}
        else{return "час назад"}
    }

    if (toSeconds in -82799..-4560 || toSeconds in 4560..82799 ){
        var toHours:Int = (toSeconds/3600).toInt()
        when (toHours){
            in -23..-22 -> name = "часа"
            -21 -> name = "час"
            in -20..-5 -> name = "часов"
            in -4..-2 -> name = "часа"
            in -1..1 -> name = "час"
            in 2..4 -> name = "часа"
            in 5..20 -> name = "часов"
            21 -> name ="час"
            in 22..23 -> name ="часа"
                    }
        if(toHours>0){return "через " + toHours.toString() + " " + name}
        else {return toHours.toString().drop(1) + " " + name + " назад"}
    }

    else
    {
        return "в разработке"
    }
}

enum class TimeUnits {
    SECOND,
    MINUTE,
    HOUR,
    DAY
}