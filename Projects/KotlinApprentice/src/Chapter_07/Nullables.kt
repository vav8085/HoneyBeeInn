package Chapter_07

/**
 * When we think about nullables we think about the variables that can have some information that may not be available to us
 * all the time. For an employee this can be his picture or his middle name.
 *
 * We usually have two wayts to handle these types of values.
 * 1.   Add some sentinel value to these which is risky. like make middlename empty string ""
 * 2.   Add null to middlename which is java way of doing it.
 *
 * In kotlin null handling is built into to language.
 * Using nullable types in kotlin you know that if there is some variable that can be null you have to deal with it in a different
 * way from the way you deal with variables of not nullable types
 *
 * Nullables are like a box which can or cannot have a value. you can always open it and look inside.
 * Non Nullables like Int, Double are just values. They are guranteed to have some value.
 *
 * you can create any type as nullable by putting a ? after it
 * val a: Int? is a nullable integer
 *
 *
 * */
fun main(){
    nullability()
}
fun nullability(){
    miniExercise1()
    nullabilityTesting()
}
fun miniExercise1(){
    val myFavoriteSong: String?
    myFavoriteSong = "Brothers"

    val parsedInt1 = "2".toIntOrNull()
    val parsedInt2 = "dog".toIntOrNull()
    println(parsedInt2)
}
fun nullabilityTesting(){
    println("Nullability testing")
    var result: Int? = null
    println(result)
    if(result!=null){ //kotlin smartcast
        result = result + 1
    }
    println(result?.plus(1)) //kotlin safe calls using ?. operator
    result?.let { //wont execute if result is null
        println(result+1)   //kotlin smartcast using let. the variable becomes not nullable inside let
    }

    //also we cannot change the value of null here. this is because we dont know above lambda or this will execute first.
    //result = result?:1 + 1 //if result is null then assign it 1
   // println(result)
}