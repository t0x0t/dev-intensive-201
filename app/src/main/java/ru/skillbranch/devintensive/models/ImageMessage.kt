package ru.skillbranch.devintensive.models

import java.util.*

class ImageMessage (
    id: String,
    from: User?,
    chat: Chat,
    isIncoming: Boolean = false,
    date: Date = Date(),
    var image:String,
    val type:String="изображение"
) : BaseMessage(id, from, chat, isIncoming, date) {

    override  fun formatMessage() : String = "$id ${from?.firstName} ${if(isIncoming) "получил" else "отправил"} сообщение $type"
    //override  fun formatMessage() : String = "id:$id ${from?.firstName} ${if(isIncoming) "получил" else "отправил"} изображение $image $date"

}