/* i522074 created on 2020-01-16*/
package com.vav.androidtesting.model

class Game2(val totScore: Int) {
    var currentScore = 0
        private set
    var totalScore = 0
        private set
    var questions = mutableListOf<Question2>()
        private set
    init {
        totalScore = totScore
    }

    fun incrementScore(){
        currentScore++
        if(currentScore > totalScore)
            totalScore++
    }
    fun getNextQuestion(): Question2?{
        if(questions.isEmpty()){
            return null
        }else
            return questions[0]
    }
}