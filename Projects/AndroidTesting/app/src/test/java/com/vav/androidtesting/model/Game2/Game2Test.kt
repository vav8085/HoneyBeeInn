/* i522074 created on 2020-01-16*/
package com.vav.androidtesting.model.Game2

import com.nhaarman.mockitokotlin2.mock
import com.vav.androidtesting.model.Game
import com.vav.androidtesting.model.Question
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class Game2Test {
    private lateinit var game :com.vav.androidtesting.model.Game2

    @Before
    fun setup(){
        game = com.vav.androidtesting.model.Game2(0)
    }
    @Test
    fun whenNoQuestionsNotPresent_shouldReturnNull(){
        Assert.assertNull(game.getNextQuestion())
    }
    @Test
    fun whenQuestionsPresent_shouldReturnQuestion(){

    }
    @Test
    fun whenAnswering_shouldDelegateToQuestion(){
        val question = mock<Question>()
        //val game = com.vav.androidtesting.model.Game2()
    }
}