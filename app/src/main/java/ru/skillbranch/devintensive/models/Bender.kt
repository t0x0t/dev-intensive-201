package ru.skillbranch.devintensive.models

class Bender(
    var status:Status = Status.NORMAL,
    var question: Question = Question.NAME,
    var n: Int? = 0
    //var l: Int = 0
    )
{

    fun askQuestion():String =
         when (question)
        {
            Question.NAME -> Question.NAME.question
            Question.PROFESSION -> Question.PROFESSION.question
            Question.MATERIAL -> Question.MATERIAL.question
            Question.BDAY -> Question.BDAY.question
            Question.SERIAL -> Question.SERIAL.question
            Question.IDLE -> Question.IDLE.question
        }

    fun validate(ans:String, que:Question)
    {
        if (que==Question.NAME && ans[0].isLowerCase()){

        }
    }


    fun listenAnswer(answer:String): Pair<String, Triple<Int, Int, Int>>
    {
        //Блок кода ниже - ВАЛИДАЦИЯ
        if ( question == Question.NAME && (answer == "" || answer[0].isLowerCase() || !answer[0].isLetter()))
        {
            return "Имя должно начинаться с заглавной буквы\n${question.question}" to status.color
        }
        if ( question == Question.PROFESSION && (answer == "" || answer[0].isUpperCase() || !answer[0].isLetter()))
        {
            return "Профессия должна начинаться со строчной буквы\n${question.question}" to status.color
        }
        if(question==Question.MATERIAL && answer.contains(regex = Regex(".*[0-9].*")))
        {
            return "Материал не должен содержать цифр\n${question.question}" to status.color
        }
        if(question == Question.BDAY && !answer.matches(Regex("[0-9]+")))
        {
            return "Год моего рождения должен содержать только цифры\n${question.question}" to status.color
        }
        if (question == Question.SERIAL && !answer.matches(Regex("[\\d]{7}")))
        {
            return "Серийный номер содержит только цифры, и их 7\n${question.question}" to status.color
        }
        if (question == Question.IDLE && (answer =="" || answer.contains(regex = Regex(".*"))))
        {
            return "На этом все, вопросов больше нет" to status.color
        }
            //блок кода выше - ВАЛИДАЦИЯ

        if (question == Question.IDLE)
        {
            return "Отлично - ты справился\nНа этом все, вопросов больше нет" to status.color
        }

        if (!question.answers.contains(answer.toLowerCase()))
        {
            n = n!! +1
        }

        if (n!! >3)
        {
            question = Question.NAME
            status = Status.NORMAL
            n = 0
            return "Это неправильный ответ. Давай все по новой\n${question.question}" to status.color
        }

        if (question.answers.contains(answer.toLowerCase()))
        {

                question = question.nextQuestion()




                return "Отлично - ты справился\n${question.question}" to status.color


        }
        else
        {
            status = status.nextStatus()
            return "Это неправильный ответ\n${question.question}" to status.color
        }
    }

    enum class Status (val color: Triple<Int, Int, Int>)
    {
        NORMAL(Triple(255, 255, 255)) ,
        WARNING(Triple(255, 120, 0)),
        DANGER(Triple(255, 60, 60)),
        CRITICAL(Triple(255, 0, 0)) ;

         fun nextStatus():Status
        {
            return if (this.ordinal < values().lastIndex)
            {
                values()[this.ordinal + 1]
            }
            else
            {
                values()[0]
            }
        }
    }

    enum class Question(val question:String, val answers: List<String>)
    {
        NAME("Как меня зовут?", listOf("бендер", "bender"))
        {
            override fun nextQuestion(): Question = PROFESSION
        },
        PROFESSION("Назови мою профессию?", listOf("сгибальщик", "bender"))
        {
            override fun nextQuestion(): Question = MATERIAL
        },
        MATERIAL("Из чего я сделан?", listOf("металл", "дерево", "metal", "iron", "wood")){
            override fun nextQuestion(): Question = BDAY
        },
        BDAY("Когда меня создали?", listOf("2993")){
            override fun nextQuestion(): Question = SERIAL
        },
        SERIAL("Мой серийный номер?", listOf("2716057")){
            override fun nextQuestion(): Question = IDLE
        },
        IDLE("На этом все, вопросов больше нет", listOf()){
            override fun nextQuestion(): Question = IDLE
        };

        abstract fun nextQuestion():Question

    }
}