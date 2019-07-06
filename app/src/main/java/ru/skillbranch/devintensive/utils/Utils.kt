package ru.skillbranch.devintensive.utils

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
        if (payload == null || payload == "") {
            return "Передай Значение, Подонок"
        } else {
            val payloadLow = payload.toLowerCase()//.trim().replace("\\s+".toRegex(), " ")
            val translit: String = payloadLow.replace(Regex("[абвгдеёжзийклмнопрстуфхцчшщъыьэюя]")) {
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
                    else -> it.value
                }
            }
            val parts: List<String> = translit.split(" ")
            var n: Int = 0
            var translUpFirst: String = ""
            while (parts.size-1 != n) {
                translUpFirst += parts.get(n).capitalize() + divider
                n++
            }
            translUpFirst += parts.get(n).capitalize()
            return translUpFirst

        }
    }
}
