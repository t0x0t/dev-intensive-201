package ru.skillbranch.devintensive.models
import java.util.*

abstract class BaseMessage(
    val id: String,
    val from: User?,
    val chat: Chat,
    val isIncoming: Boolean = false,
    val date: Date = Date(),
    val type:String
) {
    //abstract fun formatMessage(id: String, from: User, isIncoming: Boolean, type: String, payload:Any) : String

    companion object AbstractFactory {
        fun makeMessage(from:User, chat:Chat, date:Date, type:String, payload:String){

        }
    }

}