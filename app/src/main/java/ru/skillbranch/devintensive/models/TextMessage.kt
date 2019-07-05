package ru.skillbranch.devintensive.models

import java.util.*

class TextMessage(
    id: String,
    from: User?,
    chat: Chat,
    isIncoming: Boolean = false,
    date:Date = Date(),
    var text:String,
    val type:String="сообщение"
) : BaseMessage(id, from, chat, isIncoming, date) {

    override  fun formatMessage() : String = "$id ${from?.firstName} ${if(isIncoming) "получил" else "отправил"} сообщение $type"
    //override  fun formatMessage() : String = "$id ${from?.firstName} $isIncoming $text $date"
}