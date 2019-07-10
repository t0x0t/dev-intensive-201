package ru.skillbranch.devintensive.extensions

fun String.truncate(lenght:Int = 16):String {
    var trimString = this.trim()

    if (lenght == trimString.length)

    {
        return trimString
    }

    if (trimString.length <= lenght)

    {
        return trimString
    }

     trimString = trimString.substring(0, lenght)

        if ((trimString.last()).isWhitespace())

        {
          trimString = trimString.dropLast(1)
          trimString = trimString + "..."
          return trimString
        }

    return trimString + "..."
}



/*
fun String.truncate(length: Int = 16): String {
    var stroka = this.trim()
    if (stroka.length > length) stroka = "${stroka.substring(0, length).trimEnd()}..."
    return stroka
}
*/