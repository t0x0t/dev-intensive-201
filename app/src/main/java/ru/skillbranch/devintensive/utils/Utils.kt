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
    //module6 FAILED org.junit.ComparisonFailure: expected:<[ММ]> but was:<[мм]>
    fun transliteration(payload: String?, divider:String = " "): String {
return "0"
    }

    fun toInitials(firstName: String?, lastName: String?): String? {

        if (firstName.isNullOrBlank() && lastName.isNullOrBlank()) {
            return null
        }

        if (firstName.isNullOrBlank()) {
            val lastInitial=lastName?.get(0)
            val lastInitialUp = lastInitial.toString()
            return lastInitialUp.toUpperCase()
        }

        if (lastName.isNullOrBlank()) {
            val firstInitial = firstName.get(0)
            val firstInitialUp = firstInitial.toString()
            return firstInitialUp.toUpperCase()
        }

        else {

            val firstInitial = firstName.get(0)
            val lastInitial = lastName.get(0)
            val firstInitialUp = firstInitial.toString()
            val lastInitialUp = lastInitial.toString()
            val fullInitials: String? = firstInitialUp.toUpperCase() + lastInitialUp.toUpperCase()
            return fullInitials
        }
    }
}