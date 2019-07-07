package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.utils.Utils
import java.util.*

data class User(
val id: String,
var firstName: String?,
var lastName: String?,
var avatar: String?,
var rating: Int = 0,
var respect: Int = 0,
val lastVisit: Date? = null,
val isOnline : Boolean = false)
{

    var introBit: String

    constructor(id: String, firstName: String?, lastName: String?) : this(
        id = id,
        firstName = firstName,
        lastName = lastName,
        avatar = null
    )

    constructor(id: String) : this(id = id, firstName = "John", lastName = "Doe $id")

    init {
        introBit = getIntro()
        println("I am sooo stupid, but i am initial. $firstName, $lastName, ${getIntro()}")
    }
    private fun getIntro() = """heLL"""

    fun pintMe():Unit=
        println("""
id: $id
FN: $firstName,
LN: $lastName,
AVA: $avatar,
RAIT: $rating,
RESP: $respect,
LASTVIS: $lastVisit,
ISONLINE: $isOnline
        """.trimIndent())


companion object Factory {
    private var lastId :Int = -1
        fun makeUser(fullName: String?): User {
            lastId++
            val (firstName, lastName) = Utils.parseFullName(fullName)
            return User(id= "$lastId", firstName = firstName, lastName = lastName)

        }
    }

    data class Builder(
        var id: String = "0",
        var firstName: String? = null,
        var lastName: String? = null,
        var avatar: String? = null,
        var rating: Int = 0,
        var respect: Int = 0,
        var lastVisit: Date? = Date(),
        var isOnline: Boolean = false
    ) {
        fun id(value: String) = apply { id = value }
        fun firstName(value: String?) = apply { firstName = value }
        fun lastName(value: String?) = apply { lastName = value }
        fun avatar(value: String?) = apply { avatar = value }
        fun rating(value: Int) = apply { rating = value }
        fun respect(value: Int) = apply { respect = value }
        fun lastVisit(value: Date?) = apply { lastVisit = value }
        fun isOnline(isOnline: Boolean) = apply { this.isOnline = isOnline }
        fun build() = User(id, firstName, lastName, avatar, rating, respect, lastVisit, isOnline)
    }
}