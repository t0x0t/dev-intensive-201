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
}