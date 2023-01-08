package com.example.myquizzapp

object Constants {

    var USER_NAME: String = "Username"
    var TOTAL_QUESTION: String = "total_question"
    var CORRECT_ANSWER: String = "correct_answer"


    fun getQuestion(): ArrayList<Question>{
        val  questionList= ArrayList<Question>()
        //  1
        val que1 = Question(
            1,"What our planet name?","Mercury","Moon","Venus","Earth","Submit",4
        )
        questionList.add(que1)

        // 2
        val que2 = Question(
            2,"What our natural Satellite name?","Mercury","Moon","Venus","Earth","Submit",2
        )
        questionList.add(que2)
        // 3
        val que3 = Question(
            3,"What our galaxy name?","MilkyWay","Moon","Venus","Earth","Submit",1
        )
        questionList.add(que3)

        val que4 = Question(
            4,"Which is the 5th planet in our solar system?","Saturn","Jupiter","Mars","Earth","Submit",2
        )
        questionList.add(que4)

        val que5 = Question(
            5,"Which is the hottest planet in our solar system?","Saturn","Mercury","Mars","Earth","Submit",2
        )
        questionList.add(que5)

        val que6 = Question(
            6,"Which of the following part of the Sun is visible to humans?","Photosphere","Corona","Core","Chromosphere","Submit",1
        )
        questionList.add(que6)

        val que7 = Question(
            7,"What is the time taken by the light of the Sun to reach the Earth?","8 min","9 min","7 min 16 sec","8 min 20 sec","Submit",4
        )
        questionList.add(que7)

        val que8 = Question(
            8,"Which of the following planets in the Solar System takes the shortest revolution?","Neptune","Mars","Venus","Mercury","Submit",4
        )
        questionList.add(que8)

        val que9 = Question(
            9,"Which planet in the Solar System has the highest density?","Neptune","Mars","Venus","Earth","Submit",4
        )
        questionList.add(que9)

        val que10 = Question(
            10,"Aseroids are found between the orbits ","Saturn, Jupiter","Mars, Jupiter","Earth, Mars","Saturn, Uranus","Submit",2
        )
        questionList.add(que10)

        val que11 = Question(
            11,"Which of the following is indicated by the colour of a star?","Weight","Distance","Temperature","Size","Submit",3
        )
        questionList.add(que11)

        val que12 = Question(
            12,"Halley’s comet appears once in a period of _____","24 Years","36 Years","76 Years","86 Years","Submit",3
        )
        questionList.add(que12)

        val que13 = Question(
            13,"Which planet is known as ‘Morning Star’?","Mercury","Venus","Earth","Mars","Submit",2
        )
        questionList.add(que13)

        val que14 = Question(
            14,"Which of the following planets is known as Earth’s twin?","Mercury","Venus","Earth","Mars","Submit",2
        )
        questionList.add(que14)

        val que15 = Question(
            15,"Which of the following is not related to solar system?","Small Planet","Planets","Comets","Nebula","Submit",4
        )
        questionList.add(que15)

        val que16 = Question(
            16,"Comets revolve around____","Sun","Earth","Venus","Moon","Submit",1
        )
        questionList.add(que16)

        val que17 = Question(
            17,"The Planets that have no natural satellites are ________.","Mercury and Venus","Earth and Mars","Jupiter and Saturn","Uranus and Neptune","Submit",1
        )
        questionList.add(que17)

        val que18 = Question(
            18,"The darkest part of the shadow during eclipse is","Umbra","Hola","Black Hole","Penumbra","Submit",2
        )
        questionList.add(que18)

        val que19 = Question(
            19,"Which of these is a dwarf planet?","Neptune","Titan","Hydra","Eris","Submit",3
        )
        questionList.add(que19)

        val que20 = Question(
            20,"Which is the hottest planet in the solar system?","Neptune","Jupiter","Saturn","Venus","Submit",4
        )
        questionList.add(que20)

        return questionList
    }
}