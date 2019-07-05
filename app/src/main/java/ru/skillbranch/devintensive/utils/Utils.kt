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
        }

        else {
            return Pair(firstName, lastName)
        }
    }

    fun transliteration(payload: String?, divider:String = " "): String {
return "0"
    }

    fun toInitials(firstName: String?, lastName: String?): String? {

        if (firstName.isNullOrBlank() && lastName.isNullOrBlank()) {
            return null
        }

        if (firstName.isNullOrBlank()) {
            var lastInitial=lastName?.get(0)
            return lastInitial.toString()
        }

        if (lastName.isNullOrBlank()) {
            var firstInitial = firstName.get(0)
            return firstInitial.toString()
        }

        else {
            var firstInitial = firstName?.get(0)
            val lastInitial = lastName?.get(0)
            val fullInitials: String? = firstInitial.toString() + lastInitial.toString()
            return fullInitials
        }
    }
}