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
//(27-360](361....
fun Date.humanizeDiff(date: Date = Date()):String {
    val diff = (this.time - date.time) //когда результат положительный -  было в прошлом (toSeconds-пол. число)
    var name:String = " "

if (diff in -75000..75000){

    when (diff/1000){
        in -1..1 -> return "только что"
        in 2..45 -> return "через несколько секунд"
        in -45 ..-2 -> return "несколько секунд назад"
        in -75..-46 -> return "минуту назад"
        in 46..75 -> return "через минуту"
    }
}

    if (diff in -2759000..2759000){
        var intDiffMin:Int = (diff.toInt())/1000/60
        if (intDiffMin>=-20 || intDiffMin<=20)
        {

            when(intDiffMin){
                in -20..-5 -> name = "минут"
                in -4..-2 -> name = "минуты"
                in -1..1 -> name = "минуту"
                in 2..4 -> name = "минуты"
                in 5..20 -> name = "минут"
            }
        }
        if (intDiffMin in -45..-21 || intDiffMin in 21..45)
        {
            var toMinutes = intDiffMin/1000/60
            val lastCharMinutes:Char = toMinutes.toString().last()
            val lastNumMinutes:Int = lastCharMinutes.toString().toInt()
            when((lastCharMinutes.toString().toInt())){
                1 -> name = "минуту"
                in 2..4 -> name = "минуты"
                else -> name = "минут"
            }
        }
        if (intDiffMin>0) {return "через " + intDiffMin.toString() + " " + name}
        else {return (intDiffMin.toString().drop(1) + " " + name + " назад")}

    }

if (diff in -4559000..4559000){
        if(diff>0){return "через час"}
        else{return "час назад"}
    }

if (diff in -96199999..-4560000 || diff in 4560000..96199999 ){
        var toHours:Int = ((diff/3600).toInt())/1000
        when (toHours){
            in -26..-22 -> return "день назад"
            in -23..-22 -> name = "часа"
            -21 -> name = "час"
            in -20..-5 -> name = "часов"
            in -4..-2 -> name = "часа"
            in -1..1 -> name = "час"
            in 2..4 -> name = "часа"
            in 5..20 -> name = "часов"
            21 -> name ="час"
            in 22..23 -> name ="часа"
            in 22..26 -> return "через день"
                    }
        if(toHours>0){return "через " + toHours.toString() + " " + name}
        else {return toHours.toString().drop(1) + " " + name + " назад"}
    }
    //97 200 000 - 27часов   1299600000 == 361 день (!!!вычесть тысячную секунды!!!)
if (diff in -1299599000..-97200000||diff in 97200000..1299599000){
    var toDays:Int = ((diff/3600).toInt())/1000
    return diff.toString() + " разница - таймЮнитс " + toDays.toString()
}

    else
    {
        return (diff/3600).toString()
    }
}

enum class TimeUnits {
    SECOND,
    MINUTE,
    HOUR,
    DAY
}