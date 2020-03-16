/* i522074 created on 2020-01-16*/
package com.vav.androidtesting.model

import java.lang.IllegalArgumentException

class QuestionsException(val option1: String,val option2: String) {
    var answeredOption: String? = null
        private set
    fun setAnswer(answer: String){
        answer.let {
            if (!it.equals(option1) && !it.equals(option2)){
                throw IllegalArgumentException()
            }else
                answeredOption = answer
        }
    }
}