/* i522074 created on 2020-01-16*/
package com.vav.androidtesting.model

import org.junit.Test
import java.lang.IllegalArgumentException

class QuestionExceptionTest {
    @Test(expected = IllegalArgumentException::class)
    fun ifQuestionisNeitherOption1OrOption2_shouldThrowException(){
        val questionsException = QuestionsException("First","Second")
        questionsException.setAnswer("Third")
    }

}