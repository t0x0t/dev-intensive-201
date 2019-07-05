package ru.skillbranch.devintensive.models

class Chat(
    id:String,
    val members: MutableList<User> = mutableListOf(),
    val messages: MutableList<BaseMessage> = mutableListOf())
{

}