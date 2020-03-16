/* i522074 created on 2020-01-16*/
package com.vav.androidtesting.model

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class QuestionUnitTests {
    private lateinit var question: Question2
    @Before
    fun setup(){
        question = Question2("CORRECT", "INCORRECT")
    }
    @Test
    fun whenCreatingQuestion_shouldNotHaveAnsweredOption(){
        Assert.assertNull(question.answeredOption)
    }
    @Test
    fun whenSetAnswer_IsNeitherAnswer1OrAnswer2(){
        question.setAnswer("Hello")
        Assert.assertEquals(null, question.answeredOption)
    }
    @Test
    fun whenSetAnswer_IseitherAnswer1OrAnswer2_updateAnswer(){
        question.setAnswer("CORRECT")
        Assert.assertEquals("CORRECT", question.answeredOption)
    }
}