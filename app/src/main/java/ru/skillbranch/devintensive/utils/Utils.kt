package ru.skillbranch.devintensive.utils

import android.content.Context

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parts: List<String>? = fullName?.split(" ")
        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)

        if (firstName.isNullOrBlank() && lastName.isNullOrBlank()) {
            return Pair(null, null)
        }

        if (lastName.isNullOrBlank()) {
            return Pair(firstName, null)
        }

        if (firstName.isNullOrBlank()) {
            return Pair(null, lastName)
        } else {
            return Pair(firstName, lastName)
        }
    }

    fun toInitials(firstName: String?, lastName: String?): String? {

        if (firstName.isNullOrBlank() && lastName.isNullOrBlank()) {
            return null
        }

        if (firstName.isNullOrBlank()) {
            val lastInitial = lastName?.get(0)
            val lastInitialUp = lastInitial.toString()
            return lastInitialUp.toUpperCase()
        }

        if (lastName.isNullOrBlank()) {
            val firstInitial = firstName.get(0)
            val firstInitialUp = firstInitial.toString()
            return firstInitialUp.toUpperCase()
        } else {

            val firstInitial = firstName.get(0)
            val lastInitial = lastName.get(0)
            val firstInitialUp = firstInitial.toString()
            val lastInitialUp = lastInitial.toString()
            val fullInitials: String? = firstInitialUp.toUpperCase() + lastInitialUp.toUpperCase()
            return fullInitials
        }
    }

    fun transliteration(payload: String?, divider: String = " "): String {
        if (payload == null || payload == "" || payload == " ") {
            return ""
        } else {
            //val payloadLow = payload.toLowerCase().trim().replace("\\s+".toRegex(), " ")
            val translit: String = payload!!.replace(Regex("[абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ]")) {
                when (it.value) {
                    "а" -> "a"
                    "б" -> "b"
                    "в" -> "v"
                    "г" -> "g"
                    "д" -> "d"
                    "е" -> "e"
                    "ё" -> "e"
                    "ж" -> "zh"
                    "з" -> "z"
                    "и" -> "i"
                    "й" -> "i"
                    "к" -> "k"
                    "л" -> "l"
                    "м" -> "m"
                    "н" -> "n"
                    "о" -> "o"
                    "п" -> "p"
                    "р" -> "r"
                    "с" -> "s"
                    "т" -> "t"
                    "у" -> "u"
                    "ф" -> "f"
                    "х" -> "h"
                    "ц" -> "c"
                    "ч" -> "ch"
                    "ш" -> "sh"
                    "щ" -> "sh'"
                    "ъ" -> ""
                    "ы" -> "i"
                    "ь" -> ""
                    "э" -> "e"
                    "ю" -> "yu"
                    "я" -> "ya"
                    "А" -> "A"
                    "Б" -> "B"
                    "В" -> "V"
                    "Г" -> "G"
                    "Д" -> "D"
                    "Е" -> "E"
                    "Ё" -> "E"
                    "Ж" -> "Zh"
                    "З" -> "Z"
                    "И" -> "I"
                    "Й" -> "I"
                    "К" -> "K"
                    "Л" -> "L"
                    "М" -> "M"
                    "Н" -> "N"
                    "О" -> "O"
                    "П" -> "P"
                    "Р" -> "R"
                    "С" -> "S"
                    "Т" -> "T"
                    "У" -> "U"
                    "Ф" -> "F"
                    "Х" -> "H"
                    "Ц" -> "C"
                    "Ч" -> "Ch"
                    "Ш" -> "Sh"
                    "Щ" -> "Sh'"
                    "Ъ" -> ""
                    "Ы" -> "I"
                    "Ь" -> ""
                    "Э" -> "E"
                    "Ю" -> "Yu"
                    "Я" -> "Ya"
                    else -> it.value
                }
            }
            val tr = translit.replace("\\s+".toRegex(), " ")
            val parts: List<String> = tr.split(" ")

            if (parts.get(0) == "")
            {
                return parts.get(1)
            }
            if (parts.get(1)=="")
            {
                return parts.get(0)
            }

            var n: Int = 0
            var translUpFirst: String = ""
            while (parts.size-1 != n) {
                translUpFirst += parts.get(n) + divider
                n++
            }
            translUpFirst += parts.get(n)
            return translUpFirst

        }
    }
    fun convertPxToDp(context: Context, px: Int): Int {
        val scale = context.resources.displayMetrics.density
        return (px / scale + 0.5f).toInt()
    }

    fun convertDpToPx(context: Context, dp: Int): Int {
        val scale = context.resources.displayMetrics.density
        return (dp * scale + 0.5f).toInt()
    }

    fun convertSpToPx(context: Context, sp: Int): Int {
        return sp * context.resources.displayMetrics.scaledDensity.toInt()
    }
}
