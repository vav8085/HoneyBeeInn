/* i522074 created on 2020-01-16*/
package com.vav.androidtesting.model

import com.nhaarman.mockitokotlin2.mock
import org.junit.Assert
import org.junit.Test

class GameUnitTests{
    @Test
    fun whenIncrementingScore_shouldIncrementCurrentScore(){
        val game: Game2 = Game2(0)
        game.incrementScore()
        Assert.assertEquals("Current score should increment by 1!",1, game.currentScore)
    }
    @Test
    fun whenCurrentScoreisLessThanHighscore_shouldNotIncrementTotalScore(){
        val game: Game2 = Game2(3)
        game.incrementScore()
        Assert.assertEquals("Total score should not increase if current score is less than it!",3, game.totalScore)
    }
    @Test
    fun whenCurrentScoreisGreaterThanHighscore_shouldIncrementHighscore(){
        val game: Game2 = Game2(3)
        game.incrementScore()
        game.incrementScore()
        game.incrementScore()
        game.incrementScore()
        Assert.assertEquals("Total score should increase as soon as current score is higher!",4, game.totalScore)
    }

}