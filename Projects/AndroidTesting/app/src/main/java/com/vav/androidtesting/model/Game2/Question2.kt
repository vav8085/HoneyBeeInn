/* i522074 created on 2020-01-16*/
package com.vav.androidtesting.model

class Question2(val option1:String, val option2: String){
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
    fun getOptions(sorting: () -> List<String> = { listOf<String>(option1,option2).shuffled()}): List<String>{
        return sorting.invoke()
    }
}