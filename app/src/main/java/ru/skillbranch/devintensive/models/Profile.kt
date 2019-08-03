package ru.skillbranch.devintensive.models

import android.content.Context
import android.view.View
import android.widget.EditText
import android.widget.TextView
import ru.skillbranch.devintensive.R
import kotlinx.android.synthetic.main.*
import ru.skillbranch.devintensive.utils.Utils

data class Profile(

    val firstName: String,
    val lastName: String,
    val about: String,
    val repository: String,
    val rating: Int = 0,
    val respect: Int = 0

) {

    val rank: String = "Junior Android Developer"
    val nickName: String = Utils.transliteration("$firstName $lastName", "_")

    fun toMap(): Map<String, Any> = mapOf(

        "nickname" to nickName,
        "rank" to rank,
        "firstName" to firstName,
        "lastName" to lastName,
        "about" to about,
        "repository" to repository,
        "rating" to rating,
        "respect" to respect
    )


}
