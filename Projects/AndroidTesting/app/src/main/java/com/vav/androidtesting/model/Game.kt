/* i522074 created on 2020-01-16*/
package com.vav.androidtesting.model

class Game(val totScore: Int) {
    var currentScore = 0
        private set
    var totalScore = 0
        private set
    init {
        totalScore = totScore
    }

    fun incrementScore(){
        currentScore++
        if(currentScore > totalScore)
            totalScore++
    }
}