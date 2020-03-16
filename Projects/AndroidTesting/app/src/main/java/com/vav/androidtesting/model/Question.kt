/* i522074 created on 2020-01-16*/
package com.vav.androidtesting.model

class Question(val option1:String,val option2: String){
    var answeredOption: String? = null
        private set
    fun setAnswer(answer: String){
        answer.let {
            if (!it.equals(option1) && !it.equals(option2)){
                answeredOption = null
            }else
                answeredOption = answer
        }
    }
}