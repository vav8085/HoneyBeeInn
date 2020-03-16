/* i522074 created on 2020-01-16*/
package com.vav.androidtesting.model.Game2

import com.vav.androidtesting.model.Question2
import org.junit.Assert
import org.junit.Test

class Question2Test {
    private lateinit var question2: Question2

    @Test
    fun whenNoParamsPassed_getOptionsReturnShuffledList(){
        val right = "Right"
        val wrong = "Wrong"
        question2 = Question2(right,wrong)

        Assert.assertEquals(true, listOf(right,wrong).count() == question2.getOptions().count())
    }
}